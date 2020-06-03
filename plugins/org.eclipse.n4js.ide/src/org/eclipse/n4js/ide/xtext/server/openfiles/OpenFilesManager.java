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
package org.eclipse.n4js.ide.xtext.server.openfiles;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.n4js.ide.xtext.server.XWorkspaceManager;
import org.eclipse.n4js.ide.xtext.server.concurrent.LSPExecutorService;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@SuppressWarnings("javadoc")
@Singleton
public class OpenFilesManager {

	@Inject
	private XWorkspaceManager workspaceManager;

	@Inject
	private Provider<OpenFileManager> openFileManagerProvider;

	@Inject
	private LSPExecutorService lspExecutorService;

	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;

	protected final Map<URI, OpenFileManager> openFiles = new HashMap<>();
	protected final ResourceDescriptionsData sharedDirtyState = new ResourceDescriptionsData(Collections.emptyList());

	public synchronized void openFile(URI uri, int version, String content) {
		if (openFiles.containsKey(uri)) {
			return; // FIXME content gets lost in this case!
		}
		OpenFileManager newOFM = createOpenFileManager(uri);
		openFiles.put(uri, newOFM);

		runInOpenFileContext(uri, ofm -> {
			ofm.initOpenFile(version, content, CancelIndicator.NullImpl); // FIXME use proper indicator!
		});
	}

	public synchronized void changeFile(URI uri, int version,
			Iterable<? extends TextDocumentContentChangeEvent> changes, CancelIndicator cancelIndicator) {

		runInOpenFileContext(uri, ofm -> {
			ofm.refreshOpenFile(version, changes, cancelIndicator);
		});
	}

	public synchronized void closeFile(URI uri) {
		// To allow running/pending tasks in the context of the given URI's file to complete normally, we put the call
		// to #discardOpenFileInfo() on the queue (note: this does apply to tasks being submitted after this method
		// returns and before #discardOpenFileInfo() is invoked).
		// TODO reconsider sequence when closing files
		runInOpenFileContext(uri, ofm -> {
			discardOpenFileInfo(uri);
		});
	}

	public synchronized CompletableFuture<Void> runInOpenFileContext(URI uri, Consumer<OpenFileManager> task) {
		return runInOpenFileContext(uri, ofm -> {
			task.accept(ofm);
			return null;
		});
	}

	public synchronized <T> CompletableFuture<T> runInOpenFileContext(URI uri, Function<OpenFileManager, T> task) {

		OpenFileManager ofm = openFiles.get(uri);
		if (ofm == null) {
			throw new IllegalArgumentException("no open file found for given URI: " + uri);
		}

		Object queueId = getQueueIdForOpenFileContext(uri);
		return lspExecutorService.submit(queueId, () -> {
			return task.apply(ofm);
		});
	}

	protected Object getQueueIdForOpenFileContext(URI uri) {
		return Pair.of(OpenFilesManager.class, uri);
	}

	protected OpenFileManager createOpenFileManager(URI uri) {
		@SuppressWarnings("restriction")
		String projectName = workspaceManager.getProjectConfig(uri).getName();
		OpenFileManager ofm = openFileManagerProvider.get();
		ofm.initialize(this, uri, projectName, sharedDirtyState);
		return ofm;
	}

	protected synchronized void discardOpenFileInfo(URI uri) {
		openFiles.remove(uri);
		sharedDirtyState.removeDescription(uri);
		// TODO what if a task for the file being closed is currently in progress? (partially solved, see above)
		// TODO closing a file may lead to a change in other open files (because they will switch from using dirty state
		// to using persisted state for the file being closed)
		// TODO what about publishing diagnostics, here? (not required for VSCode because it sends a content change
		// event, back to original content, before closing a file with unsaved changes)
	}

	/**
	 * If the given origin resource set is one that is used to process an open file, then this method will return the
	 * resource set responsible for containing a resource with the given uri; otherwise <code>null</code> is returned.
	 * Might return the origin resource set itself or might return a newly created resource set.
	 */
	// FIXME find better solution for this (it's dirty to leak a manager's resource sets to the outside)
	public synchronized ResourceSet getOrCreateResourceSetForURI(ResourceSet origin, URI uri) {
		OpenFileManager ofm = findOpenFileManager(origin);
		if (ofm == null) {
			return null; // origin is not a resource set related to an open file
		}
		return ofm.getResourceSetForURI(uri, true);
	}

	protected synchronized OpenFileManager findOpenFileManager(ResourceSet resourceSet) {
		return openFiles.values().stream()
				.filter(ofm -> ofm.containerHandle2ResourceSet.containsValue(resourceSet))
				.findAny().orElse(null);
	}

	protected synchronized void updateSharedDirtyState(URI uri, IResourceDescription newDesc,
			CancelIndicator cancelIndicator) {
		// update my dirty state instance
		IResourceDescription oldDesc = sharedDirtyState.getResourceDescription(uri);
		IResourceDescription.Delta delta = resourceDescriptionManager.createDelta(oldDesc, newDesc);
		sharedDirtyState.register(delta);
		// update dirty state instances in the manager of each open file (except the one that caused the change)
		for (URI currURI : openFiles.keySet()) {
			if (currURI.equals(uri)) {
				continue;
			}
			runInOpenFileContext(currURI, ofm -> {
				ofm.onDirtyStateChanged(delta, cancelIndicator);
			});
		}
	}
}
