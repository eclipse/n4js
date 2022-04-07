/**
 * Copyright (c) 2021 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.ide.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.n4js.n4JS.ImportDeclaration;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.postprocessing.N4JSPostProcessor;
import org.eclipse.n4js.scoping.builtin.N4Scheme;
import org.eclipse.n4js.utils.URIUtils;
import org.eclipse.n4js.workspace.N4JSProjectConfigSnapshot;
import org.eclipse.n4js.xtext.ide.server.XLanguageServerImpl;
import org.eclipse.n4js.xtext.ide.server.build.ProjectBuilder;
import org.eclipse.n4js.xtext.ide.server.build.WorkspaceAwareResourceSet;
import org.eclipse.n4js.xtext.ide.server.build.XBuildContext;
import org.eclipse.n4js.xtext.ide.server.build.XBuildRequest;
import org.eclipse.n4js.xtext.ide.server.build.XBuildResult;
import org.eclipse.n4js.xtext.ide.server.build.XStatefulIncrementalBuilder;
import org.eclipse.n4js.xtext.ide.server.build.XWorkspaceManager;
import org.eclipse.n4js.xtext.workspace.SourceFolderSnapshot;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.IFileSystemScanner;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * N4JS-specific adjustments to {@link XLanguageServerImpl}.
 */
public class N4JSStatefulIncrementalBuilder extends XStatefulIncrementalBuilder {

	static class AdjustedBuildRequest extends XBuildRequest {
		final XBuildRequest delegate;

		AdjustedBuildRequest(XBuildRequest delegate, Collection<URI> dirtyFiles, Collection<URI> deletedFiles) {

			super(delegate.getProjectName(), delegate.getBaseDir(), dirtyFiles, deletedFiles,
					delegate.getExternalDeltas(), delegate.getIndex(),
					delegate.getResourceSet(), delegate.getFileMappings(),
					delegate.isGeneratorEnabled(), delegate.isValidatorEnabled(), delegate.isIndexOnly(),
					delegate.isWriteStorageResources());

			this.delegate = delegate;
		}

		@Override
		public void addAfterValidateListener(AfterValidateListener listener) {
			delegate.addAfterValidateListener(listener);
		}

		@Override
		public void afterValidate(URI source, List<? extends Issue> issues) {
			delegate.afterValidate(source, issues);
		}

		@Override
		public void addAfterGenerateListener(AfterGenerateListener listener) {
			delegate.addAfterGenerateListener(listener);
		}

		@Override
		public void afterGenerate(URI source, URI generated) {
			delegate.afterGenerate(source, generated);
		}

		@Override
		public void addAfterDeleteListener(AfterDeleteListener listener) {
			delegate.addAfterDeleteListener(listener);
		}

		@Override
		public void afterDelete(URI file) {
			delegate.afterDelete(file);
		}

		@Override
		public void addAffectedListener(AffectedListener listener) {
			delegate.addAffectedListener(listener);
		}

		@Override
		public void afterDetectedAsAffected(URI uri) {
			delegate.afterDetectedAsAffected(uri);
		}

		@Override
		public void addAfterBuildFileListener(AfterBuildFileListener listener) {
			delegate.addAfterBuildFileListener(listener);
		}

		@Override
		public void afterBuildFile(URI uri) {
			delegate.afterBuildFile(uri);
		}

		@Override
		public void addAfterBuildRequestListener(AfterBuildRequestListener listener) {
			delegate.addAfterBuildRequestListener(listener);
		}

		@Override
		public void afterBuildRequest(XBuildResult buildResult) {
			delegate.afterBuildRequest(buildResult);
		}
	}

	@Inject
	XWorkspaceManager workspaceManager;

	@Inject
	IFileSystemScanner fileSystemScanner;

	/**
	 * Never unload built-in resources for performance considerations.
	 */
	@Override
	protected void unloadResource(URI uri) {
		if (!N4Scheme.isN4Scheme(uri)) {
			super.unloadResource(uri);
		}
	}

	/**
	 * This override introduces two changes:
	 * <p>
	 * (1) on initial/full builds, all uris are sorted.
	 * <p>
	 * (2) on closure builds, the build request is adjusted so that dirty/deleted files always respect the URI closure.
	 */
	@Override
	protected XBuildRequest initializeBuildRequest(XBuildRequest initialRequest, XBuildContext context) {
		ProjectBuilder projectBuilder = workspaceManager.getProjectBuilder(initialRequest.getProjectName());
		N4JSProjectConfigSnapshot projectConfig = (N4JSProjectConfigSnapshot) projectBuilder.getProjectConfig();
		ResourceDescriptionsData oldIndex = context.getOldIndex();
		boolean isInitialBuild = oldIndex.isEmpty() && initialRequest.getDeletedFiles().isEmpty();

		if (projectConfig.hasTsConfigBuildSemantic()) {
			// this is a closure build
			// adjust the build request: compute file closure and adjust the set of changed/deleted uris

			Collection<URI> allUris = projectConfig.getAllContents(fileSystemScanner);
			Collection<URI> startUris = projectConfig.computeStartUris(fileSystemScanner);
			startUris.addAll(initialRequest.getDirtyFiles());

			Multimap<String, URI> moduleName2Uri = getModuleName2UrisMap(projectConfig, allUris);
			List<URI> sortedUriClosure = computeSortedUriClosure(initialRequest.getResourceSet(),
					projectConfig.getName(), moduleName2Uri, startUris);

			if (isInitialBuild) {
				return new AdjustedBuildRequest(initialRequest, sortedUriClosure, null);
			} else {
				Set<URI> removedFromClosure = Sets.newHashSet(oldIndex.getAllURIs());
				removedFromClosure.removeAll(sortedUriClosure);
				Set<URI> addedToClosure = Sets.newHashSet(sortedUriClosure);
				addedToClosure.removeAll(oldIndex.getAllURIs());
				Set<URI> adjDeletedUris = new HashSet<>();
				adjDeletedUris.addAll(initialRequest.getDeletedFiles());
				adjDeletedUris.addAll(removedFromClosure);
				Set<URI> adjDirtyUris = new HashSet<>();
				adjDirtyUris.addAll(initialRequest.getDirtyFiles());
				adjDirtyUris.addAll(addedToClosure);
				return new AdjustedBuildRequest(initialRequest, adjDirtyUris, adjDeletedUris);
			}

		} else if (isInitialBuild) {
			// this is a normal initial build
			Collection<URI> allUris = initialRequest.getDirtyFiles();
			Multimap<String, URI> moduleName2Uri = getModuleName2UrisMap(projectConfig, allUris);
			List<URI> sortedUris = computeSortedUriClosure(initialRequest.getResourceSet(),
					projectConfig.getName(), moduleName2Uri, allUris);

			return new AdjustedBuildRequest(initialRequest, sortedUris, null);

		} else {
			// this is a normal incremental build. Sorting is unnecessary (usually only one file changed).
			return initialRequest;
		}
	}

	private Multimap<String, URI> getModuleName2UrisMap(N4JSProjectConfigSnapshot pcs, Iterable<URI> allUris) {
		Multimap<String, URI> moduleName2Uri = LinkedHashMultimap.create();
		for (URI uri : allUris) {
			SourceFolderSnapshot srcFolder = pcs.findSourceFolderContaining(uri);
			if (srcFolder != null) {
				URI srcFolderUri = srcFolder.getPath();
				URI relUri = uri.deresolve(srcFolderUri);

				String moduleName = URIUtils.trimFileExtension(relUri).toFileString();
				moduleName2Uri.put(moduleName, uri);
			}
		}
		return moduleName2Uri;
	}

	private Collection<URI> getImportedUris(WorkspaceAwareResourceSet resourceSet, String prjName,
			Multimap<String, URI> moduleName2Uri, URI uri) {

		List<ImportDeclaration> importDeclarations = getImportDeclarations(resourceSet, uri);
		for (ImportDeclaration importDeclaration : importDeclarations) {
			String moduleSpecifier = importDeclaration.getModuleSpecifierAsText();
			String adjModuleSpecifier = getAdjustedModuleSpecifierOrNull(moduleSpecifier, prjName, moduleName2Uri);
			if (adjModuleSpecifier != null) {
				return moduleName2Uri.get(adjModuleSpecifier);
			}
		}
		return Collections.emptyList();
	}

	private List<ImportDeclaration> getImportDeclarations(WorkspaceAwareResourceSet resourceSet, URI uri) {
		List<ImportDeclaration> result = new ArrayList<>();
		Resource resource = null;
		try {
			resource = resourceSet.getResource(uri, true);
		} catch (Exception e) {
			// ignore error during load
		}
		if (resource == null) {
			return result;
		}

		for (EObject eobj : resource.getContents()) {
			if (eobj instanceof Script) {
				Script script = (Script) eobj;

				for (EObject topLevelStmt : script.getScriptElements()) {
					if (topLevelStmt instanceof ImportDeclaration) {
						ImportDeclaration impDecl = (ImportDeclaration) topLevelStmt;
						result.add(impDecl);
					} else {

						// we know that all import statements are at the beginning of a file
						break;
					}
				}
			}
		}
		return result;
	}

	private String getAdjustedModuleSpecifierOrNull(String moduleSpecifier, String prjName,
			Multimap<String, URI> moduleName2Uri) {

		if (moduleName2Uri.containsKey(moduleSpecifier)) {
			return moduleSpecifier;
		} else if (moduleSpecifier.startsWith("./")) {
			moduleSpecifier = moduleSpecifier.substring(2); // remove './'
		} else if (moduleSpecifier.startsWith(prjName)) {
			moduleSpecifier = moduleSpecifier.substring(prjName.length() + 1);
		}

		if (moduleName2Uri.containsKey(moduleSpecifier)) {
			return moduleSpecifier;
		}

		URI msUri = URI.createFileURI(moduleSpecifier);
		String msWithoutExt = URIUtils.trimFileExtension(msUri).toString();
		if (moduleName2Uri.containsKey(msWithoutExt)) {
			return msWithoutExt;
		}
		return null;
	}

	/**
	 * The given list of URIs is sorted by this method to improve the post processing of N4JS started by the
	 * {@link N4JSPostProcessor}. During post processing, other dependency resources will be processed too in a
	 * recursive fashion. However, by sorting URIs beforehand here, that will not be necessary since dependencies
	 * already have been processed. Note however that in case of dependency cycles, sorting cannot avoid the recursive
	 * post processing of dependencies.
	 */
	private List<URI> computeSortedUriClosure(WorkspaceAwareResourceSet resourceSet, String prjName,
			Multimap<String, URI> moduleName2Uri, Collection<URI> startUris) {

		List<URI> sortedResults = new ArrayList<>(startUris.size());
		Set<URI> worklist = new HashSet<>();
		worklist.addAll(startUris);
		while (!worklist.isEmpty()) {
			Iterator<URI> iter = worklist.iterator();
			URI uri = iter.next();
			iter.remove();
			sortedResults.add(uri);

			Collection<URI> importedUris = getImportedUris(resourceSet, prjName, moduleName2Uri, uri);
			worklist.addAll(importedUris);
		}

		return Lists.reverse(sortedResults);
	}

}
