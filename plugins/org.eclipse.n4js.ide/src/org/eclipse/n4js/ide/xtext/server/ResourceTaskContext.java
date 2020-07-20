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
package org.eclipse.n4js.ide.xtext.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.ResourceLocator;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.n4js.ide.xtext.server.build.ConcurrentIssueRegistry;
import org.eclipse.n4js.xtext.workspace.IWorkspaceConfigSnapshot;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Manager.AllChangeAware;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.DelegatingIAllContainerAdapter;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.ImmutableSetMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Represents the context for tasks that operate on a certain EMF resource, called main resource, including all
 * necessary information and data structures for performing such task. In particular, this includes EMF resources for
 * files required by the main resource.
 */
@SuppressWarnings({ "restriction" })
public class ResourceTaskContext {

	@Inject
	private LSPIssueConverter lspIssueConverter;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private IExternalContentSupport externalContentSupport;

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private IResourceServiceProvider.Registry languagesRegistry;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	@Inject
	private ConcurrentIssueRegistry issueRegistry;

	/** The {@link ResourceTaskManager} that created this instance. */
	protected ResourceTaskManager parent;
	/** URI of the resource represented by this {@link ResourceTaskContext} (i.e. URI of the main resource). */
	protected URI mainURI;
	/** Tells whether this context represents a temporarily opened file, see {@link #isTemporary()}. */
	protected boolean temporary;

	/**
	 * Contains the state of all files in the workspace. For open files managed by {@link #parent} (including the open
	 * file of this context) this state will represent the dirty state and for all other files it will represent the
	 * persisted state (as provided by the LSP builder).
	 */
	protected ResourceDescriptionsData indexSnapshot;

	/** Maps project names to URIs of all resources contained in the project. */
	protected ImmutableSetMultimap<String, URI> project2URIs;

	/** Most recent workspace configuration. */
	protected IWorkspaceConfigSnapshot workspaceConfig;

	/** The resource set used for the current resource and any other resources required for resolution. */
	protected XtextResourceSet mainResourceSet;
	/** The EMF resource representing the open file. */
	protected XtextResource mainResource = null;
	/** The current textual content of the open file. */
	protected XDocument document = null;

	/** Within each resource task's context, this provides source text of all other task's main resource. */
	protected class ResourceTaskContentProvider implements IExternalContentProvider {
		@Override
		public String getContent(URI uri) {
			XDocument doc = parent.getOpenDocument(uri);
			return doc != null ? doc.getContents() : null;
		}

		@Override
		public boolean hasContent(URI uri) {
			return parent.getOpenDocument(uri) != null;
		}

		@Override
		public IExternalContentProvider getActualContentProvider() {
			return this;
		}
	}

	/** @return URI of main resource. */
	public synchronized URI getURI() {
		return mainURI;
	}

	/**
	 * Tells whether this {@link ResourceTaskContext} represents a temporary resource task. Such contexts do not
	 * actually represent an open editor in the LSP client but were created to perform editing-related computations in
	 * files not actually opened in the LSP client. For example, when API documentation needs to be retrieved from a
	 * file not currently opened in an editor in the LSP client, such a temporary {@code OpenFileContext} will be
	 * created.
	 * <p>
	 * Some special characteristics of temporary resource task contexts:
	 * <ul>
	 * <li>temporary contexts will not publish their state to the {@link #parent}'s dirty state index.
	 * <li>temporary contexts may be created even for files that actually have an open editor in the LSP client. This
	 * might be useful if some computation needs to be performed that should not influence the open editor's state.
	 * </ul>
	 */
	public synchronized boolean isTemporary() {
		return temporary;
	}

	/**
	 * Tells whether this {@link ResourceTaskContext} represents a context for an open file, i.e. not a
	 * {@link #isTemporary() temporary context}.
	 */
	public synchronized boolean isOpen() {
		return !isTemporary();
	}

	/** Returns the context's resource set. Each resource task has exactly one resource set. */
	public synchronized XtextResourceSet getResourceSet() {
		return mainResourceSet;
	}

	/**
	 * This resource task's main resource. Each resource task is associated with exactly one main resource.
	 * <p>
	 * Other resources that exist in a task's {@link #getResourceSet() resource set} were either demand-loaded during
	 * {@link LazyLinkingResource#resolveLazyCrossReferences(CancelIndicator) resolution} of the main resource or were
	 * explicitly loaded by some task running in the context (e.g. some editing functionality).
	 */
	public synchronized XtextResource getResource() {
		return mainResource;
	}

	/**
	 * May return <code>null</code> if not fully initialized yet. In contrast to most other methods of this class, this
	 * method is thread safe, i.e. may be invoked from any thread.
	 */
	public synchronized XDocument getDocument() {
		return document;
	}

	/** Initialize this context's fields and resource set. Invoked once per context. */
	@SuppressWarnings("hiding")
	public synchronized void initialize(ResourceTaskManager parent, URI uri, boolean isTemporary,
			ResourceDescriptionsData index, ImmutableSetMultimap<String, URI> project2URIs,
			IWorkspaceConfigSnapshot workspaceConfig) {
		this.parent = parent;
		this.mainURI = uri;
		this.temporary = isTemporary;
		this.indexSnapshot = index;
		this.project2URIs = project2URIs;
		this.workspaceConfig = workspaceConfig;

		this.mainResourceSet = createResourceSet();
	}

	/** Returns a newly created and fully configured resource set */
	protected XtextResourceSet createResourceSet() {
		XtextResourceSet result = resourceSetProvider.get();
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(result, indexSnapshot);
		externalContentSupport.configureResourceSet(result, new ResourceTaskContentProvider());

		IAllContainersState allContainersState = new ResourceTaskContextAllContainerState(this);
		result.eAdapters().add(new DelegatingIAllContainerAdapter(allContainersState));

		return result;
	}

	/**
	 * Create & initialize this context's main resource with the given content. Invoked exactly once for
	 * NON-{@link #isTemporary() temporary} contexts, not at all for temporary contexts.
	 */
	protected void initContext(int version, String content, CancelIndicator cancelIndicator) {
		if (mainResource != null) {
			throw new IllegalStateException("trying to initialize an already initialized resource: " + mainURI);
		}

		mainResource = (XtextResource) mainResourceSet.createResource(mainURI);
		document = new XDocument(version, content);

		try (InputStream in = new LazyStringInputStream(document.getContents(), mainResource.getEncoding())) {
			mainResource.load(in, null);
		} catch (IOException e) {
			throw new RuntimeException("IOException while reading from string input stream", e);
		}

		resolveAndValidateResource(cancelIndicator);
	}

	/**
	 * Create & initialize this context's main resource based only on its URI, retrieving its content via EMF's
	 * {@link ResourceLocator}. Invoked exactly once for {@link #isTemporary() temporary} contexts, not at all for
	 * non-temporary contexts.
	 */
	protected void initContext(boolean resolveAndValidate, CancelIndicator cancelIndicator) {
		if (mainResource != null) {
			throw new IllegalStateException("trying to initialize an already initialized resource: " + mainURI);
		}

		mainResource = (XtextResource) mainResourceSet.getResource(mainURI, true); // uses the EMF ResourceLocator
		IParseResult parseResult = mainResource != null ? mainResource.getParseResult() : null;
		ICompositeNode rootNode = parseResult != null ? parseResult.getRootNode() : null;
		document = new XDocument(0, rootNode != null ? rootNode.getText() : "");

		if (resolveAndValidate) {
			resolveAndValidateResource(cancelIndicator);
		}
	}

	/** Same as {@link #refreshContext(int, Iterable, CancelIndicator)}, but without changing the source text. */
	public void refreshContext(CancelIndicator cancelIndicator) {
		// TODO IDE-3402 find better solution for updating unchanged resource task contexts!
		TextDocumentContentChangeEvent dummyChange = new TextDocumentContentChangeEvent(document.getContents());
		refreshContext(document.getVersion(), Collections.singletonList(dummyChange), cancelIndicator);
	}

	/**
	 * Refresh this context's main resource, i.e. change its source text and then parse, resolve, and validate it. Also
	 * sends out dirty state index and issue updates (not for {@link #isTemporary() temporary} contexts).
	 */
	public void refreshContext(@SuppressWarnings("unused") int version,
			Iterable<? extends TextDocumentContentChangeEvent> changes, CancelIndicator cancelIndicator) {

		if (mainResource == null) {
			throw new IllegalStateException("trying to refresh a resource that was not yet initialized: " + mainURI);
		}
		if (!mainResource.isLoaded()) {
			throw new IllegalStateException("trying to refresh a resource that is not yet loaded: " + mainURI);
		}

		ResourceSet resSet = getResourceSet();
		for (Resource res : new ArrayList<>(resSet.getResources())) {
			if (res != mainResource) {
				res.unload(); // TODO IDE-3402 better way to do this? (unload is expensive due to re-proxyfication)
				resSet.getResources().remove(res);
			}
		}

		for (TextDocumentContentChangeEvent change : changes) {
			Range range = change.getRange();
			int start = range != null ? document.getOffSet(range.getStart()) : 0;
			int end = range != null ? document.getOffSet(range.getEnd()) : document.getContents().length();
			String replacement = change.getText();

			document = document.applyTextDocumentChanges(Collections.singletonList(change));

			mainResource.update(start, end - start, replacement);
		}

		resolveAndValidateResource(cancelIndicator);
	}

	/**
	 * Triggers {@link #resolveResource(CancelIndicator) resolution} and {@link #validateResource(CancelIndicator)
	 * validation} of this context's main resource.
	 */
	public List<Issue> resolveAndValidateResource(CancelIndicator cancelIndicator) {
		resolveResource(cancelIndicator);
		return validateResource(cancelIndicator);
	}

	/** Resolve this context's main resource and send a dirty state index update. */
	public void resolveResource(CancelIndicator cancelIndicator) {
		// resolve
		EcoreUtil2.resolveLazyCrossReferences(mainResource, cancelIndicator);
		// update dirty state
		updateSharedDirtyState();
		// notify resource task listeners
		parent.onDidRefreshContext(this, cancelIndicator);
	}

	/** Validate this context's main resource and send an issue update. */
	public List<Issue> validateResource(CancelIndicator cancelIndicator) {
		// validate
		IResourceServiceProvider resourceServiceProvider = languagesRegistry.getResourceServiceProvider(mainURI);
		IResourceValidator resourceValidator = resourceServiceProvider.getResourceValidator();
		List<Issue> issues = resourceValidator.validate(mainResource, CheckMode.ALL, cancelIndicator);
		operationCanceledManager.checkCanceled(cancelIndicator); // #validate() sometimes returns null when canceled!
		// notify LSP client
		publishIssues(issues, cancelIndicator);
		return issues;
	}

	/** Send issue update to issue registry. Ignored for {@link #isTemporary()} contexts. */
	protected void publishIssues(List<Issue> issues, CancelIndicator cancelIndicator) {
		if (isTemporary()) {
			return; // temporarily opened files do not contribute to the global issue registry
		}
		List<LSPIssue> lspIssues = lspIssueConverter.convertToLSPIssues(mainResource, issues, cancelIndicator);
		issueRegistry.setIssuesOfDirtyState(mainURI, lspIssues);
	}

	/** Send dirty state index update to parent. Ignored for {@link #isTemporary() temporary} contexts. */
	protected void updateSharedDirtyState() {
		if (isTemporary()) {
			return; // temporarily opened files do not contribute to the parent's shared dirty state index
		}
		IResourceDescription newDesc = createResourceDescription();
		indexSnapshot.addDescription(mainURI, newDesc);
		parent.updateSharedDirtyState(newDesc.getURI(), newDesc);
	}

	/**
	 * Invoked by {@link #parent} when a change happened in another open file (not the one represented by this
	 * {@link ResourceTaskContext}). Will never be invoked for {@link #isTemporary() temporary} contexts.
	 */
	protected void onDirtyStateChanged(IResourceDescription changedDesc, CancelIndicator cancelIndicator) {
		updateIndex(Collections.singletonList(changedDesc), Collections.emptySet(), project2URIs,
				workspaceConfig, cancelIndicator);
	}

	/**
	 * Invoked by {@link #parent} when a change happened in a non-opened file OR after an open file was closed.
	 */
	protected void onPersistedStateChanged(Collection<? extends IResourceDescription> changedDescs,
			Set<URI> removedURIs, ImmutableSetMultimap<String, URI> newProject2URIs,
			IWorkspaceConfigSnapshot newWorkspaceConfig, CancelIndicator cancelIndicator) {
		updateIndex(changedDescs, removedURIs, newProject2URIs, newWorkspaceConfig, cancelIndicator);
	}

	/** Update this context's internal index and trigger a refresh if required. */
	protected void updateIndex(Collection<? extends IResourceDescription> changedDescs, Set<URI> removedURIs,
			ImmutableSetMultimap<String, URI> newProject2URIs, IWorkspaceConfigSnapshot newWorkspaceConfig,
			CancelIndicator cancelIndicator) {

		// update my cached state

		List<IResourceDescription.Delta> allDeltas = createDeltas(changedDescs, removedURIs);
		for (IResourceDescription.Delta delta : allDeltas) {
			indexSnapshot.register(delta);
		}

		project2URIs = newProject2URIs;

		IWorkspaceConfigSnapshot oldWorkspaceConfig = workspaceConfig;
		workspaceConfig = newWorkspaceConfig;

		// refresh if I am affected by the changes

		boolean isAffected = !workspaceConfig.equals(oldWorkspaceConfig);

		if (!isAffected) {
			IResourceDescription.Manager rdm = getResourceDescriptionManager(mainURI);
			if (rdm == null) {
				return;
			}
			IResourceDescription candidateDesc = indexSnapshot.getResourceDescription(mainURI);
			if (rdm instanceof AllChangeAware) {
				isAffected = ((AllChangeAware) rdm).isAffectedByAny(allDeltas, candidateDesc, indexSnapshot);
			} else {
				List<IResourceDescription.Delta> changedDeltas = allDeltas.stream()
						.filter(d -> d.haveEObjectDescriptionsChanged())
						.collect(Collectors.toList());
				isAffected = rdm.isAffected(changedDeltas, candidateDesc, indexSnapshot);
			}
		}

		if (isAffected) {
			refreshContext(cancelIndicator);
		}
	}

	/** Create deltas for the given changes and removals. */
	protected List<IResourceDescription.Delta> createDeltas(Collection<? extends IResourceDescription> changedDescs,
			Set<URI> removedURIs) {

		List<IResourceDescription.Delta> deltas = new ArrayList<>(changedDescs.size() + removedURIs.size());

		for (IResourceDescription changedDesc : changedDescs) {
			URI changedURI = changedDesc.getURI();
			IResourceDescription oldDesc = indexSnapshot.getResourceDescription(changedURI);
			IResourceDescription.Delta delta = createDelta(changedURI, oldDesc, changedDesc);
			if (delta != null) {
				deltas.add(delta);
			}
		}

		for (URI removedURI : removedURIs) {
			IResourceDescription removedDesc = indexSnapshot.getResourceDescription(removedURI);
			IResourceDescription.Delta delta = createDelta(removedURI, removedDesc, null);
			if (delta != null) {
				deltas.add(delta);
			}
		}

		return deltas;
	}

	/** Create a delta for the given change. 'oldDesc' and 'newDesc' may be <code>null</code>. */
	protected IResourceDescription.Delta createDelta(URI uri, IResourceDescription oldDesc,
			IResourceDescription newDesc) {

		if (oldDesc != newDesc) {
			IResourceDescription.Manager rdm = getResourceDescriptionManager(uri);
			if (rdm != null) {
				Delta delta = rdm.createDelta(oldDesc, newDesc);
				return delta;
			}
		}
		return null;
	}

	/** Create a resource description representing the current state of this context's main resource. */
	protected IResourceDescription createResourceDescription() {
		IResourceDescription.Manager resourceDescriptionManager = getResourceDescriptionManager(mainURI);
		IResourceDescription newDesc = resourceDescriptionManager.getResourceDescription(mainResource);
		// sanitize resource description
		// NOTE: it seems that resource descriptions created by the resource description manager may contain mutable
		// state (e.g. user data implemented as a ForwardingMap with lazily initialized content) and hold references to
		// the resource they were created from (i.e. 'mainResource' in this case); this means they are (1) not thread
		// safe and (2) may leak EObjects from one file context into another or to the outside. The following line
		// seems to fix that, but requires access to restricted Xtext API:
		SerializableResourceDescription newDesc2 = SerializableResourceDescription.createCopy(newDesc);
		return newDesc2;
	}

	/** Return the correct resource description manager for the resource with the given URI. */
	protected IResourceDescription.Manager getResourceDescriptionManager(URI uri) {
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry
				.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null) {
			return null;
		}
		return resourceServiceProvider.getResourceDescriptionManager();
	}
}
