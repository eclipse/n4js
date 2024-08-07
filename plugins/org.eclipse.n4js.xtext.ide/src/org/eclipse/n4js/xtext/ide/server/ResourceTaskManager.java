/**
 * Copyright (c) 2020 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.xtext.ide.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.n4js.xtext.ide.server.build.BuilderFrontend;
import org.eclipse.n4js.xtext.ide.server.util.CancelIndicatorUtil;
import org.eclipse.n4js.xtext.ide.server.util.WorkspaceConfigAllContainerState;
import org.eclipse.n4js.xtext.ide.server.util.XChunkedResourceDescriptions;
import org.eclipse.n4js.xtext.workspace.ProjectConfigSnapshot;
import org.eclipse.n4js.xtext.workspace.WorkspaceConfigAdapter;
import org.eclipse.n4js.xtext.workspace.WorkspaceConfigSnapshot;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.DelegatingIAllContainerAdapter;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Manages a set of {@link ResourceTaskContext}s, including creation, disposal, and executing tasks within those
 * contexts.
 *
 * <h2>Life Times of Non-Temporary Contexts</h2>
 *
 * Regarding the creation and disposal of resource task contexts, two viewpoints have to be distinguished: "from outside
 * the queue" and "on the queue". In the former sense, a context exists immediately after a call to
 * {@link #createContext(URI, int, String) #createContext()} and ceases to exist immediately after a following call to
 * {@link #disposeContext(URI) #disposeContext()} (represented by {@link #uri2RTCs}). In the latter sense, a context
 * exists when its first task was started <em>on the queue</em> until its last task completed <em>on the queue</em>
 * (represented by field {@link #uri2RTCsOnQueue}).
 * <p>
 * In other words, a context immediately shows up in / disappears from {@link #uri2RTCs} when
 * {@link #createContext(URI, int, String)} / {@link #disposeContext(URI)} are called but may appear in / disappear from
 * {@link #uri2RTCsOnQueue} much later, depending on delays caused by pending/running tasks on the context's queue.
 * <p>
 * Two examples for when this distinction matters:
 * <ul>
 * <li>For deciding whether a call to {@link #runInExistingContext(URI, String, BiFunction)} is allowed, the outside
 * viewpoint is relevant. This means a call to this method is always valid right after
 * {@link #createContext(URI, int, String)} was invoked as long as no {@link #disposeContext(URI)} invocation happened
 * since then.
 * <li>For deciding whether the builder should send validation diagnostics of a particular resource to the client, or if
 * they are shadowed by an open editor, the "on the queue" viewpoint is relevant.
 * </ul>
 */
@Singleton
public class ResourceTaskManager {

	/** Set to <code>true</code> for logging resource task starting, completion, cancellation. */
	public static final boolean LOG_RESOURCE_TASK_EXECUTION = false;

	@Inject
	private Provider<ResourceTaskContext> resourceTaskContextProvider;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private QueuedExecutorService queuedExecutorService;

	/**
	 * Contains all non-temporary contexts created with {@link #createContext(URI, int, String)} and not yet discarded
	 * with {@link #disposeContext(URI)}, no matter whether those contexts were already created/disposed on the queue.
	 */
	protected final Map<URI, ResourceTaskContext> uri2RTCs = new HashMap<>();
	/**
	 * Contains all non-temporary contexts that were already created but not yet disposed <em>on the queue</em>. If
	 * long-running tasks are on the queue, creation/disposal on the queue can happen significantly later than the
	 * corresponding {@link #createContext(URI, int, String)} / {@link #disposeContext(URI)} invocations.
	 */
	protected final Map<URI, ResourceTaskContext> uri2RTCsOnQueue = new HashMap<>();

	/**
	 * For each thread that is currently executing a resource-related task, this stores the corresponding
	 * {@link ResourceTaskContext}.
	 */
	protected final ThreadLocal<ResourceTaskContext> currentContext = new ThreadLocal<>();

	/*
	 * Review feedback:
	 *
	 * This looks like being the same as the the ConcurrentIndex structure?
	 */
	/**
	 * The persisted state index, not taking into account dirty state from existing resource task contexts.
	 * <p>
	 * Contained instances of {@link ResourceDescriptionsData} are shared across threads and must not be changed!
	 */
	protected final XChunkedResourceDescriptions persistedIndex = new XChunkedResourceDescriptions();
	/** The dirty state index. Contains an entry for each URI with an existing resource task context. */
	protected final ResourceDescriptionsData dirtyIndex = new ResourceDescriptionsData(Collections.emptyList());
	/** Most recent workspace configuration. */
	protected WorkspaceConfigSnapshot workspaceConfig = null;

	/***/
	protected final List<IResourceTaskListener> listeners = new CopyOnWriteArrayList<>();

	/*
	 * Review feedback:
	 *
	 * Rethink the terminology: refresh is not something that is usually associated with an Xtext resource.
	 */
	/** Listener for events in resource task contexts. */
	public interface IResourceTaskListener {
		/**
		 * Invoked whenever a non-temporary {@link ResourceTaskContext resource task context}'s main resource was
		 * resolved, validated, etc. Invoked in the given resource task context, i.e. on its corresponding queue.
		 */
		public void didRefreshContext(ResourceTaskContext rtc, CancelIndicator ci);
	}

	/**
	 * Returns true iff a non-temporary {@link ResourceTaskContext} exists for the given URI, according to a viewpoint
	 * "from outside the queue" (see details of context life times {@link ResourceTaskManager here}).
	 */
	public synchronized boolean hasContext(URI uri) {
		return uri2RTCs.containsKey(uri);
	}

	/**
	 * Returns true iff a non-temporary {@link ResourceTaskContext} exists for the given URI, according to the "on the
	 * queue" viewpoint (see details of context life times {@link ResourceTaskManager here}).
	 */
	public synchronized boolean hasContextOnQueue(URI uri) {
		return uri2RTCsOnQueue.containsKey(uri);
	}

	/** Returns the {@link XDocument} for the given uri iff #{@link #hasContext(URI)} holds for the given uri. */
	public synchronized XDocument getDocumentOnQueue(URI uri) {
		ResourceTaskContext rtc = uri2RTCsOnQueue.get(uri);
		if (rtc != null) {
			// note: since we only obtain an object reference to an immutable data structure (XDocument) we do not need
			// to execute the following in the resource task context:
			return rtc.getDocument();
		}
		return null;
	}

	/** Create a new resource task context for the resource with the given URI. */
	public synchronized CompletableFuture<ResourceTaskContext> createContext(URI uri, int version, String content) {
		if (uri2RTCs.containsKey(uri)) {
			throw new IllegalArgumentException("a context already exists for given URI: " + uri);
		}
		ResourceTaskContext newContext = doCreateContext(uri, false);
		uri2RTCs.put(uri, newContext); // n.b.: add to this map immediately

		// beware: there might be pending tasks in the queue for 'uri', if that file was recently closed, because we
		// allow tasks to end gracefully after receiving a 'didClose' notification (see #disposeContext(URI) below);
		// therefore, we have to initialize the newly created context on the queue for the given URI
		CompletableFuture<ResourceTaskContext> future = runInExistingContext(uri, "createContext", (rtc, ci) -> {
			synchronized (ResourceTaskManager.this) {
				uri2RTCsOnQueue.put(uri, newContext); // n.b.: add to this map later on the queue
			}
			newContext.initContext(version, content, ci);
			return newContext;
		});

		// note: even though we created the ResourceTaskContext instance immediately (i.e. outside the queue), we do not
		// immediately return that new instance but only return the future, in order to make sure the caller does not
		// gain access to the new ResourceTaskContext before its initialization completed (which happens on the queue):
		return future;
	}

	/** Change the source text of the main resource of the resource task context for the given URI. */
	public synchronized CompletableFuture<Void> changeSourceTextOfExistingContext(URI uri, int version,
			Iterable<? extends TextDocumentContentChangeEvent> changes) {

		// cancel current tasks for this context (they are now out-dated, anyway)
		doCancelCurrentTasks(uri);

		// refresh the context
		return runInExistingContextVoid(uri, "changeSourceTextOfExistingContext", (rtc, ci) -> {
			rtc.refreshContext(version, changes, ci);
		});
	}

	/** Dispose of all resource task contexts managed by this manager. */
	public synchronized CompletableFuture<Void> disposeAll() {
		List<CompletableFuture<Void>> cfs = new ArrayList<>(uri2RTCs.size());
		for (URI uri : new ArrayList<>(uri2RTCs.keySet())) {
			cfs.add(disposeContext(uri));
		}
		return CompletableFuture.allOf(cfs.toArray(new CompletableFuture<?>[cfs.size()]));
	}

	/** Dispose of the resource task context for the resource with the given URI. */
	public synchronized CompletableFuture<Void> disposeContext(URI uri) {
		// To allow running/pending tasks in the context of the given URI's file to complete gracefully, we only perform
		// a cancellation and then put the call to #doDisposeContext() on the queue (note: this does not apply to tasks
		// being submitted after this method returns and before #doDisposeContext() is invoked).

		// cancel current tasks for this context (they are now out-dated, anyway)
		doCancelCurrentTasks(uri);

		CompletableFuture<Void> future = runInExistingContextVoid(uri, "disposeContext", (rtc, ci) -> {
			doDisposeContext(rtc);
			synchronized (ResourceTaskManager.this) {
				uri2RTCsOnQueue.remove(uri); // n.b.: remove from this map later on the queue
			}
		});

		uri2RTCs.remove(uri); // n.b.: remove from this map immediately, not later on the queue

		return future;
	}

	/** Tries to run the given task in an existing context, falling back to a temporary context if necessary. */
	public synchronized <T> CompletableFuture<T> runInExistingOrTemporaryContext(URI uri, String description,
			BiFunction<ResourceTaskContext, CancelIndicator, T> task) {

		if (hasContext(uri)) {
			return runInExistingContext(uri, description, task);
		} else {
			return runInTemporaryContext(uri, description, true, task);
		}
	}

	/** Same as {@link #runInExistingContext(URI, String, BiFunction)}, but for tasks without a return value. */
	public synchronized CompletableFuture<Void> runInExistingContextVoid(URI uri, String description,
			BiConsumer<ResourceTaskContext, CancelIndicator> task) {

		return runInExistingContext(uri, description, (rtc, ci) -> {
			task.accept(rtc, ci);
			return null;
		});
	}

	/**
	 * Run the given task within the resource task context for the given URI. Assumes that a context for the given URI
	 * exists and throws an exception otherwise.
	 */
	public synchronized <T> CompletableFuture<T> runInExistingContext(URI uri, String description,
			BiFunction<ResourceTaskContext, CancelIndicator, T> task) {

		ResourceTaskContext rtc = uri2RTCs.get(uri);
		if (rtc == null) {
			throw new IllegalArgumentException("no existing context found for given URI: " + uri);
		}

		String descriptionWithContext = description + " [" + uri.lastSegment() + "]";
		return doSubmitTask(rtc, descriptionWithContext, task);
	}

	/**
	 * Creates a temporary resource task context for the file with the given URI, initializes it, and executes the given
	 * task, without interfering with other possibly existing or temporary contexts for that 'uri'.
	 * <p>
	 * The temporary context is not retained over a longer period of time; the given task is the only task that will
	 * ever be executed in this temporary context.
	 * <p>
	 * Note that instead of using this method, the caller might simply create a new resource set from scratch, configure
	 * it with a {@link #createLiveScopeIndex() live scope index}, and synchronously perform any desired computation
	 * there. The intention of this method is to provide means to easily perform such computations in temporary contexts
	 * with a consistent setup/configuration and with a similar API as compared to computations in the context of
	 * actually opened files.
	 */
	public synchronized <T> CompletableFuture<T> runInTemporaryContext(URI uri, String description,
			boolean resolveAndValidate, BiFunction<ResourceTaskContext, CancelIndicator, T> task) {
		return runInTemporaryContext(uri, description, resolveAndValidate, CancelIndicator.NullImpl, task);
	}

	/**
	 * Same as {@link #runInTemporaryContext(URI, String, boolean, BiFunction)}, but accepts an outer cancel indicator
	 * as argument as an additional source of cancellation. The implementation of the given function 'task' should only
	 * use the cancel indicator passed into 'task' (it is a {@link CancelIndicatorUtil#combine(List) combination} of the
	 * given outer cancel indicator and other sources of cancellation).
	 */
	public synchronized <T> CompletableFuture<T> runInTemporaryContext(URI uri, String description,
			boolean resolveAndValidate, CancelIndicator outerCancelIndicator,
			BiFunction<ResourceTaskContext, CancelIndicator, T> task) {

		ResourceTaskContext tempContext = doCreateContext(uri, true);

		String descriptionWithContext = description + " (temporary) [" + uri.lastSegment() + "]";
		return doSubmitTask(tempContext, descriptionWithContext, (_tempContext, ciFromExecutor) -> {
			CancelIndicator ciCombined = CancelIndicatorUtil.combine(outerCancelIndicator, ciFromExecutor);
			_tempContext.initContext(resolveAndValidate, ciCombined);
			return task.apply(_tempContext, ciCombined);
		});
	}

	/** Submit a task for execution within a resource task context to the executor service. */
	protected <T> CompletableFuture<T> doSubmitTask(ResourceTaskContext rtc, String description,
			BiFunction<ResourceTaskContext, CancelIndicator, T> task) {

		Object queueId = getQueueIdForContext(rtc.getURI(), rtc.isTemporary());
		if (LOG_RESOURCE_TASK_EXECUTION) {
			System.out.println("===> queuing: " + description + " " + rtc.getURI().toFileString());
		}
		return queuedExecutorService.submit(queueId, description, ci -> {

			final long start;
			if (LOG_RESOURCE_TASK_EXECUTION) {
				start = System.currentTimeMillis();
				System.out.println("===> starting: " + description + " " + rtc.getURI().toFileString());
			}

			try {
				if (!rtc.isAlive()) {
					throw new CancellationException();
				}
				currentContext.set(rtc);

				T result = task.apply(rtc, ci);

				if (LOG_RESOURCE_TASK_EXECUTION) {
					long elapsed = System.currentTimeMillis() - start;
					System.out.println(
							"===> done: " + description + " (after " + elapsed + " ms) " + rtc.getURI().toFileString());
				}

				return result;

			} catch (Throwable th) {
				if (LOG_RESOURCE_TASK_EXECUTION) {
					long elapsed = System.currentTimeMillis() - start;
					System.out.println("===> ABORTED with " + th.getClass().getSimpleName() + ": " + description
							+ " (after " + elapsed + " ms) " + rtc.getURI().toFileString());
				}
				throw th;
			} finally {
				currentContext.set(null);
			}
		});
	}

	/** Cancels all tasks of the non-temporary context with the given URI. */
	protected void doCancelCurrentTasks(URI uri) {
		Object queueId = getQueueIdForContext(uri, false);
		queuedExecutorService.cancelAll(queueId);
	}

	/** Returns a queue ID for tasks supposed to run in the resource task context of the given URI. */
	protected Object getQueueIdForContext(URI uri, boolean isTemporary) {
		if (isTemporary) {
			// for every temporary context only a single task is being submitted that is supposed to be independent of
			// all other tasks (in particular, we can have several temporary contexts for the same URI that should all
			// be independent of one another), so we use "new Object()" as the actual ID here:
			return Pair.of(ResourceTaskManager.class, new Object());
		}
		// note that the queue ID does not depend on the identity of a particular ResourceTaskContext instance; this
		// means that if a file is closed and reopened all tasks will be on the same strand, no matter whether they
		// belong to the file before or after it was closed & reopened:
		return Pair.of(ResourceTaskManager.class, uri);
	}

	/**
	 * Actually creates a new resource task context for the given URI and initializes it with its core values, but does
	 * not invoke {@link ResourceTaskContext#initContext(boolean, CancelIndicator)} /
	 * {@link ResourceTaskContext#initContext(int, String, CancelIndicator)} yet.
	 * <p>
	 * TODO IDE-3402 add support for language-specific bindings of ResourceTaskContext
	 */
	protected synchronized ResourceTaskContext doCreateContext(URI uri, boolean isTemporary) {
		ResourceTaskContext rtc = resourceTaskContextProvider.get();
		XChunkedResourceDescriptions index = isTemporary ? createPersistedStateIndex() : createLiveScopeIndex();
		rtc.initialize(this, uri, isTemporary, index, workspaceConfig);
		return rtc;
	}

	/**
	 * Triggers work that needs to be done before a {@link ResourceTaskContext} can be entrusted to the garbage
	 * collector.
	 */
	protected synchronized void doDisposeContext(ResourceTaskContext rtc) {
		rtc.dispose();
		if (!rtc.isTemporary()) {
			updateSharedDirtyState(rtc.getURI(), null);
		}
	}

	/**
	 * If the thread invoking this method {@link #runInExistingContext(URI, String, BiFunction) currently runs in an
	 * context}, that context is returned. Otherwise returns <code>null</code>.
	 * <p>
	 * Corresponds to {@link Thread#currentThread()}.
	 */
	public ResourceTaskContext currentContext() {
		return currentContext.get();
	}

	/**
	 * Creates a resource set configured with the current workspace configuration and the current
	 * {@link #createPersistedStateIndex() persisted index}. Just as is the case in temporary resource task contexts,
	 * the returned resource set's workspace configuration represents a fixed point in time and will not receive any
	 * updates of the workspace state on disk.
	 */
	public XtextResourceSet createTemporaryResourceSet() {
		XChunkedResourceDescriptions index = createPersistedStateIndex();
		return createResourceSet(workspaceConfig, index, Optional.absent());
	}

	/**
	 * Single method for creating a resource set for all three use cases:
	 * <ol>
	 * <li>ordinary resource task contexts,
	 * <li>temporary resource task contexts,
	 * <li>temporary resource sets (without a containing resource task context; as created with method
	 * {@link #createTemporaryResourceSet()}).
	 * </ol>
	 */
	protected XtextResourceSet createResourceSet(WorkspaceConfigSnapshot currWorkspaceConfig,
			XChunkedResourceDescriptions currResourceDescriptions, Optional<ResourceTaskContext> rtc) {
		XtextResourceSet result = resourceSetProvider.get();
		WorkspaceConfigAdapter.installWorkspaceConfig(result, currWorkspaceConfig);
		currResourceDescriptions.setResourceSet(result); // installs 'currResourceDescriptions' as adapter on 'result'
		IAllContainersState allContainersState = rtc.isPresent()
				? new ResourceTaskContextAllContainerState(result, rtc.get())
				: new WorkspaceConfigAllContainerState(result);
		result.eAdapters().add(new DelegatingIAllContainerAdapter(allContainersState));
		return result;
	}

	/*
	 * Review feedback:
	 *
	 * Copying the entire index should not be necessary since we do have implementations of IResourceDescriptions that
	 * do apply sane shadowing semantics.
	 */
	/** Creates an index not containing any dirty state information. */
	protected synchronized XChunkedResourceDescriptions createPersistedStateIndex() {
		return persistedIndex.createDeepCopy();
	}

	/** Creates an index containing the persisted state shadowed by the dirty state of all non-temporary contexts. */
	public synchronized XChunkedResourceDescriptions createLiveScopeIndex() {
		XChunkedResourceDescriptions result = createPersistedStateIndex();
		for (IResourceDescription desc : dirtyIndex.getAllResourceDescriptions()) {
			ProjectConfigSnapshot project = workspaceConfig.findProjectContaining(desc.getURI());
			if (project != null) {
				result.addDescription(project.getName(), desc);
			}
		}
		return result;
	}

	/**
	 * Updates this manager and all its {@link ResourceTaskContext}s with the given changes to the persisted state
	 * index. Should be invoked from the outside whenever changes to the persisted state become available, e.g. because
	 * the {@link BuilderFrontend builder} has rebuilt some files.
	 */
	public synchronized void updatePersistedState(
			WorkspaceConfigSnapshot newWorkspaceConfig,
			Map<String, ? extends ResourceDescriptionsData> changedDescriptions,
			@SuppressWarnings("unused") List<? extends ProjectConfigSnapshot> changedProjects,
			Set<String> removedProjects) {

		WorkspaceConfigSnapshot oldWC = workspaceConfig;

		// compute "flat" modification info (not per project but on a global URI->description basis)
		List<IResourceDescription> changed = new ArrayList<>();
		Set<URI> removed = new HashSet<>();
		for (Entry<String, ? extends ResourceDescriptionsData> entry : changedDescriptions.entrySet()) {
			String projectName = entry.getKey();
			ResourceDescriptionsData newData = entry.getValue();

			ResourceDescriptionsData oldData = persistedIndex.getContainer(projectName);
			if (oldData != null) {
				removed.addAll(oldData.getAllURIs());
			}

			for (IResourceDescription desc : newData.getAllResourceDescriptions()) {
				URI descURI = desc.getURI();
				changed.add(desc);
				removed.remove(descURI);
			}
		}

		// update my internal state
		for (String removedProject : removedProjects) {
			persistedIndex.removeContainer(removedProject);
		}
		for (Entry<String, ? extends ResourceDescriptionsData> entry : changedDescriptions.entrySet()) {
			persistedIndex.setContainer(entry.getKey(), entry.getValue());
		}

		workspaceConfig = newWorkspaceConfig;

		// from this point forward: ignore changes/removals related to existing resource task contexts
		changed.removeIf(desc -> uri2RTCsOnQueue.containsKey(desc.getURI()));
		removed.removeAll(uri2RTCsOnQueue.keySet());

		// update internal state of all contexts
		if (Iterables.isEmpty(changed) && removed.isEmpty() && workspaceConfig.equals(oldWC)) {
			return;
		}
		WorkspaceConfigSnapshot capturedWorkspaceConfig = workspaceConfig;
		for (Entry<URI, ResourceTaskContext> currEntry : uri2RTCsOnQueue.entrySet()) {
			ResourceTaskContext currRTC = currEntry.getValue();
			doSubmitTask(currRTC, "updatePersistedState of existing context", (rtc, ci) -> {
				rtc.onPersistedStateChanged(changed, removed, capturedWorkspaceConfig, ci);
				return null;
			});
		}
	}

	/**
	 * Updates this manager and all its {@link ResourceTaskContext}s with the given changes to the persisted state
	 * index. Should only be invoked internally from {@link ResourceTaskContext} after
	 * {@link ResourceTaskContext#refreshContext(int, Iterable, CancelIndicator) refreshing} its internal state.
	 *
	 * @param uri
	 *            uri of the resource that has changed or was deleted.
	 * @param newDesc
	 *            the new resource description or <code>null</code> if the resource was deleted.
	 */
	protected synchronized void updateSharedDirtyState(URI uri, IResourceDescription newDesc) {
		// update my dirty state instance
		if (newDesc != null) {
			dirtyIndex.addDescription(uri, newDesc);
		} else {
			dirtyIndex.removeDescription(uri);
		}
		// update dirty state instance in each resource task context (except the one that caused the change)
		WorkspaceConfigSnapshot capturedWorkspaceConfig = workspaceConfig;
		IResourceDescription replacementDesc = newDesc == null ? getPersistedIndexDescription(uri) : null;
		for (Entry<URI, ResourceTaskContext> currEntry : uri2RTCsOnQueue.entrySet()) {
			URI currURI = currEntry.getKey();
			ResourceTaskContext currRTC = currEntry.getValue();
			if (currURI.equals(uri)) {
				continue;
			}
			doSubmitTask(currRTC, "updateSharedDirtyState of existing context", (rtc, ci) -> {
				if (newDesc != null) {
					// happens in case a resource context has changed
					rtc.onDirtyStateChanged(newDesc, ci);
				} else {
					// happens in case a resource context was disposed
					if (replacementDesc != null) {
						rtc.onPersistedStateChanged(Collections.singleton(replacementDesc), Collections.emptySet(),
								capturedWorkspaceConfig, ci);
					} else {
						rtc.onPersistedStateChanged(Collections.emptyList(), Collections.singleton(uri),
								capturedWorkspaceConfig, ci);
					}
				}
				return null;
			});
		}
	}

	private IResourceDescription getPersistedIndexDescription(URI uri) {
		ProjectConfigSnapshot project = workspaceConfig.findProjectContaining(uri);
		if (project != null) {
			ResourceDescriptionsData container = persistedIndex.getContainer(project.getName());
			if (container != null) {
				return container.getResourceDescription(uri);
			}
		}
		return persistedIndex.getResourceDescription(uri);
	}

	/** Adds a {@link IResourceTaskListener listener}. */
	public void addListener(IResourceTaskListener l) {
		listeners.add(l);
	}

	/** Removes a {@link IResourceTaskListener listener}. */
	public void removeListener(IResourceTaskListener l) {
		listeners.remove(l);
	}

	/** Invoked by {@link ResourceTaskContext} after completing a refresh. */
	protected /* NOT synchronized */ void onDidRefreshContext(ResourceTaskContext rtc, CancelIndicator ci) {
		if (rtc.isTemporary()) {
			return; // temporarily opened files do not send out events to resource task listeners
		}
		notifyResourceTaskListeners(rtc, ci);
	}

	/** Notify listeners that a resource task context has completed a refresh. */
	protected /* NOT synchronized */ void notifyResourceTaskListeners(ResourceTaskContext rtc, CancelIndicator ci) {
		for (IResourceTaskListener l : listeners) {
			l.didRefreshContext(rtc, ci);
		}
	}
}
