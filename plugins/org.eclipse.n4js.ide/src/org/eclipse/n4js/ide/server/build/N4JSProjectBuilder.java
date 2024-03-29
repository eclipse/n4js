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
package org.eclipse.n4js.ide.server.build;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.packagejson.projectDescription.ProjectDescription;
import org.eclipse.n4js.packagejson.projectDescription.ProjectType;
import org.eclipse.n4js.postprocessing.ASTFlowInfo;
import org.eclipse.n4js.resource.N4JSResource;
import org.eclipse.n4js.tooling.tester.TestCatalogSupplier;
import org.eclipse.n4js.ts.types.TypesPackage;
import org.eclipse.n4js.utils.N4JSLanguageUtils;
import org.eclipse.n4js.utils.URIUtils;
import org.eclipse.n4js.utils.UtilN4;
import org.eclipse.n4js.workspace.N4JSProjectConfigSnapshot;
import org.eclipse.n4js.workspace.N4JSWorkspaceConfigSnapshot;
import org.eclipse.n4js.xtext.ide.server.ResourceChangeSet;
import org.eclipse.n4js.xtext.ide.server.build.IBuildRequestFactory;
import org.eclipse.n4js.xtext.ide.server.build.ImmutableProjectState;
import org.eclipse.n4js.xtext.ide.server.build.ProjectBuilder;
import org.eclipse.n4js.xtext.ide.server.build.XBuildRequest;
import org.eclipse.n4js.xtext.ide.server.build.XBuildResult;
import org.eclipse.n4js.xtext.workspace.ProjectConfigSnapshot;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;

/**
 * Adds {@link #writeTestCatalog()} and {@link #removeTestCatalog()}.
 */
public class N4JSProjectBuilder extends ProjectBuilder {
	private static final Logger LOG = LogManager.getLogger(N4JSProjectBuilder.class);

	@Inject
	private TestCatalogSupplier testCatalogSupplier;

	@Override
	public N4JSProjectConfigSnapshot getProjectConfig() {
		return (N4JSProjectConfigSnapshot) super.getProjectConfig();
	}

	@Override
	public ResourceChangeSet scanForSourceFileChanges() {
		N4JSProjectConfigSnapshot prjConfig = getProjectConfig();
		Set<URI> sourceFileURIsToStartWith = scanForSourceFiles(true);
		Set<URI> sourceFileURIsOnDisk = prjConfig.hasTsConfigBuildSemantic()
				? scanForSourceFiles(false)
				: sourceFileURIsToStartWith;

		return super.scanForSourceFileChanges(sourceFileURIsToStartWith, sourceFileURIsOnDisk);
	}

	@Override
	protected XBuildResult doBuild(IBuildRequestFactory buildRequestFactory, Set<URI> dirtyFiles, Set<URI> deletedFiles,
			List<Delta> externalDeltas, ProjectStateUpdater projectStateUpdater, CancelIndicator cancelIndicator) {

		XBuildResult buildResult = super.doBuild(buildRequestFactory, dirtyFiles, deletedFiles, externalDeltas,
				projectStateUpdater, cancelIndicator);

		writeTestCatalog();

		onBuildDone();

		return buildResult;
	}

	/**
	 * This is a suitable place for measuring memory consumption with method {@link UtilN4#measureUsedMemory(boolean)}.
	 */
	private void onBuildDone() {
		// UtilN4.measureUsedMemory(true);
	}

	@Override
	public void doClean(XBuildRequest buildRequest, CancelIndicator cancelIndicator) {
		super.doClean(buildRequest, cancelIndicator);

		removeTestCatalog();
	}

	@Override
	protected XBuildRequest newBuildRequest(IBuildRequestFactory buildRequestFactory, Set<URI> changedFiles,
			Set<URI> deletedFiles, List<Delta> externalDeltas, CancelIndicator cancelIndicator) {

		XBuildRequest request = super.newBuildRequest(buildRequestFactory, changedFiles, deletedFiles, externalDeltas,
				cancelIndicator);

		ProjectDescription pd = getProjectConfig().getProjectDescription();
		if (N4JSLanguageUtils.isDtsGenerationActive(pd)) {
			request.addAfterBuildRequestListener(new DtsAfterBuildListener(getProjectConfig()));
		}

		request.addAfterBuildFileListener((uri) -> {
			Resource resource = getResource(uri);
			if (resource instanceof N4JSResource) {
				N4JSResource n4jsResource = (N4JSResource) resource;
				ASTFlowInfo flowInfo = n4jsResource.getASTMetaInfoCache().getFlowInfo();

				// release memory
				flowInfo.reset();
				n4jsResource.unloadAST();
			}
		});

		return request;
	}

	@Override
	protected boolean handleProjectAdditionRemovalSinceProjectStateWasComputed(ResourceChangeSet result,
			ImmutableProjectState projectState) {

		// ignore PLAINJS projects here
		if (getProjectConfig().getType() == ProjectType.PLAINJS) {
			// NOTE: This is more than just a performance tweak! Since project dependencies of PLAINJS projects are
			// ignored when computing the project build order (see #getDependencies(ProjectConfigSnapshot) in class
			// N4JSProjectBuildOrderInfo), the dependency information in the project state files of PLAINJS projects
			// may be out-dated, so this would lead to unnecessary building of PLAINJS projects. In combination with
			// bug GH-1935 this could lead to large parts of a yarn workspace being rebuilt unnecessarily if this
			// project builder's project is the root project of a yarn workspace.
			return false;
		}
		return super.handleProjectAdditionRemovalSinceProjectStateWasComputed(result, projectState);
	}

	/** Overridden to exclude all ts files (yet still include d.ts files) */
	@Override
	protected Set<URI> scanForSourceFiles() {
		return scanForSourceFiles(true);
	}

	/**
	 * @param useTsConfigBuildSemantic
	 *            if <code>true</code> and the project being built has
	 *            {@link N4JSProjectConfigSnapshot#hasTsConfigBuildSemantic() tsconfig.json build semantics}, only the
	 *            "start URIs" will be returned; otherwise, URIs for all source files on disk will be returned.
	 */
	protected Set<URI> scanForSourceFiles(boolean useTsConfigBuildSemantic) {
		Set<URI> result = new TreeSet<>(Comparator.comparing(URI::toString)); // stable build order
		N4JSProjectConfigSnapshot prjConfig = getProjectConfig();
		if (useTsConfigBuildSemantic && prjConfig.hasTsConfigBuildSemantic()) {
			for (URI startUri : prjConfig.computeStartUris(fileSystemScanner)) {
				addToResults(result, startUri);
			}
		} else {
			for (URI srcFileUri : prjConfig.getAllContents(fileSystemScanner)) {
				addToResults(result, srcFileUri);
			}
		}
		return result;
	}

	private void addToResults(Set<URI> result, URI srcFileUri) {
		if (!srcFileUri.hasTrailingPathSeparator()) {
			IResourceServiceProvider rsp = resourceServiceProviders.getResourceServiceProvider(srcFileUri);
			if (rsp != null) {
				String fileExtension = URIUtils.fileExtension(srcFileUri);
				if (N4JSGlobals.TS_FILE_EXTENSION.equals(fileExtension)) {
					return;
				}
				result.add(srcFileUri);
			}
		}
	}

	@Override
	protected boolean isNestedResource(URI uri) {
		ImmutableProjectState projectState = getProjectState();
		IResourceDescription resDescr = projectState.getResourceDescriptions().getResourceDescription(uri);
		if (resDescr == null) {
			return false;
		}

		for (IEObjectDescription objDescr : resDescr.getExportedObjectsByType(TypesPackage.eINSTANCE.getTModule())) {
			if (URIUtils.isVirtualResourceURI(objDescr.getEObjectURI())) {
				return true;
			}
		}
		return false;
	}

	/** Generates the test catalog for the project. */
	private void writeTestCatalog() {
		N4JSWorkspaceConfigSnapshot workspaceConfig = (N4JSWorkspaceConfigSnapshot) workspaceManager
				.getWorkspaceConfig();
		N4JSProjectConfigSnapshot projectConfig = getProjectConfig();
		File testCatalog = getTestCatalogFile(projectConfig);

		String catalog = testCatalogSupplier.get(
				workspaceConfig,
				getResourceSet(),
				projectConfig,
				true); // do not include "endpoint" property here

		if (catalog != null) {
			try (FileWriter fileWriter = new FileWriter(testCatalog)) {
				fileWriter.write(catalog);

			} catch (IOException e) {
				LOG.error("Error while writing test catalog file: " + testCatalog);
			}
		}
	}

	/** Removes the test catalog for the project. */
	private void removeTestCatalog() {
		ProjectConfigSnapshot projectConfig = getProjectConfig();
		File testCatalog = getTestCatalogFile(projectConfig);

		if (testCatalog.isFile()) {
			try {
				testCatalog.delete();

			} catch (Exception e) {
				LOG.error("Error while deleting test catalog file: " + testCatalog);
			}
		}
	}

	private File getTestCatalogFile(ProjectConfigSnapshot projectConfig) {
		return new File(projectConfig.getPath().toFileString(), N4JSGlobals.TEST_CATALOG);
	}
}
