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

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.WorkspaceSymbol;
import org.eclipse.lsp4j.WorkspaceSymbolParams;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.n4js.xtext.ide.server.findReferences.XWorkspaceResourceAccess;
import org.eclipse.n4js.xtext.ide.server.util.XChunkedResourceDescriptions;
import org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.ExecutableCommandRegistry;
import org.eclipse.xtext.ide.server.symbol.WorkspaceSymbolService;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Handles all lsp calls that refer to the whole workspace, i.e. do not specify a specific test document.
 */
@SuppressWarnings({ "restriction", "deprecation" })
@Singleton
public class WorkspaceFrontend {
	@Inject
	private ResourceTaskManager resourceTaskManager;

	@Inject
	private QueuedExecutorService lspExecutorService;

	@Inject
	private WorkspaceSymbolService workspaceSymbolService;

	@Inject
	private ExecutableCommandRegistry commandRegistry;

	private IResourceAccess resourceAccess;

	private ILanguageServerAccess access;

	/** Sets non-injectable fields */
	public void initialize(@SuppressWarnings("hiding") ILanguageServerAccess access) {
		this.resourceAccess = new XWorkspaceResourceAccess(resourceTaskManager, false);
		this.access = access;
	}

	/** Compute the symbol information. */
	public CompletableFuture<Either<List<? extends SymbolInformation>, List<? extends WorkspaceSymbol>>> symbol(
			WorkspaceSymbolParams params) {
		return lspExecutorService.submitAndCancelPrevious(WorkspaceSymbolParams.class, "symbol",
				cancelIndicator -> symbol(params, cancelIndicator));
	}

	/** Compute the symbol information. Executed in a read request. */
	protected Either<List<? extends SymbolInformation>, List<? extends WorkspaceSymbol>> symbol(
			WorkspaceSymbolParams params, CancelIndicator cancelIndicator) {
		XChunkedResourceDescriptions liveScopeIndex = resourceTaskManager.createLiveScopeIndex();
		return workspaceSymbolService.getSymbols(params.getQuery(), resourceAccess, liveScopeIndex, cancelIndicator);
	}

	/** Execute the given command. */
	public CompletableFuture<Object> executeCommand(ExecuteCommandParams params) {
		return lspExecutorService.submit("executeCommand", cancelIndicator -> executeCommand(params, cancelIndicator));
	}

	/** Execute the command. Runs in a read request. */
	protected Object executeCommand(ExecuteCommandParams params, CancelIndicator cancelIndicator) {
		return commandRegistry.executeCommand(params, access, cancelIndicator);
	}

}
