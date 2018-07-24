/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.generator.headless;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.external.ExternalLibraryUtils;
import org.eclipse.n4js.external.TargetPlatformInstallLocationProvider;
import org.eclipse.n4js.generator.headless.logging.IHeadlessLogger;
import org.eclipse.n4js.internal.FileBasedWorkspace;
import org.eclipse.n4js.internal.N4JSBrokenProjectException;
import org.eclipse.n4js.internal.N4JSModel;
import org.eclipse.n4js.internal.N4JSProject;
import org.eclipse.n4js.n4mf.ProjectDescription;
import org.eclipse.n4js.projectModel.IN4JSProject;
import org.eclipse.n4js.utils.ProjectDescriptionHelper;
import org.eclipse.n4js.utils.URIUtils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Helper methods to deal with projects and {@link FileBasedWorkspace}.
 */
public class HeadlessHelper {

	@Inject
	private ProjectDescriptionHelper projectDescriptionHelper;

	@Inject
	private N4JSModel n4jsModel;

	@Inject
	private IHeadlessLogger logger;

	@Inject
	private TargetPlatformInstallLocationProvider targetPlatformInstallLocationProvider;

	/**
	 * Configure FileBasedWorkspace with all projects contained in {@code buildSet}.
	 *
	 * Skips {@link IN4JSProject}s that are already registered with the given {@code workspace}.
	 *
	 * @param buildSet
	 *            build set of projects
	 * @param workspace
	 *            instance of FileBasedWorkspace to configure (in N4JS injector)
	 * @throws N4JSCompileException
	 *             in error Case.
	 */
	public void registerProjects(BuildSet buildSet, FileBasedWorkspace workspace) throws N4JSCompileException {
		Iterable<URI> projectUris = Iterables.transform(buildSet.getAllProjects(), p -> p.getLocation());
		// Register all projects with the file based workspace.
		this.registerProjectsToFileBasedWorkspace(projectUris, workspace);
	}

	/**
	 * Configure FileBasedWorkspace with all projects found in sub-folders of {@code projectLocations}.
	 *
	 * Skips {@link IN4JSProject}s that are already registered with the given {@code workspace}.
	 *
	 * @param projectLocations
	 *            list of project roots
	 * @param workspace
	 *            instance of FileBasedWorkspace to configure (in N4JS injector)
	 * @throws N4JSCompileException
	 *             in error Case.
	 */
	public void registerProjects(List<File> projectLocations, FileBasedWorkspace workspace)
			throws N4JSCompileException {
		// make absolute, since downstream URI conversion doesn't work if relative dir only.
		List<File> absProjectRoots = this.toAbsoluteFileList(projectLocations);

		// Collect all Projects in first Level
		List<URI> pUris = collectAllProjectUris(absProjectRoots);

		registerProjectsToFileBasedWorkspace(pUris, workspace);
	}

	/**
	 * Registers provided project URIs in the given workspace.
	 *
	 * Skips {@link IN4JSProject}s that are already registered with the given {@code workspace}.
	 *
	 */
	public void registerProjectsToFileBasedWorkspace(Iterable<URI> projectURIs, FileBasedWorkspace workspace)
			throws N4JSCompileException {

		// TODO GH-783 refactor FileBasedWorkspace, https://github.com/eclipse/n4js/issues/783
		// this is reverse mapping of the one that is kept in the workspace
		Map<String, URI> registeredProjects = new HashMap<>();
		workspace.getAllProjectsLocations().forEachRemaining(uri -> {
			String projectID = workspace.getProjectDescription(uri).getProjectId();
			registeredProjects.put(projectID, URIUtils.normalize(uri));
		});

		// register all projects with the file based workspace.
		for (URI uri : projectURIs) {
			URI projectURI = URIUtils.normalize(uri);

			final ProjectDescription projectDescription = projectDescriptionHelper
					.loadProjectDescriptionAtLocation(projectURI);

			if (projectDescription == null) {
				throw new N4JSCompileException(
						"Cannot load project description for project at " + projectURI.toFileString()
								+ ". Make sure the project contains a valid package.json file.");
			}

			final String projectId = projectDescription.getProjectId();

			if (skipRegistering(projectId, projectURI, registeredProjects)) {
				if (logger != null && logger.isCreateDebugOutput()) {
					logger.debug("Skipping already registered project '" + projectURI + "'");
				}
				/*
				 * We could call FileBasedWorkspace.registerProject which would fail silently. Still to avoid potential
				 * side effects and to keep {@code registeredProjects} management simpler,we will skip it explicitly.
				 */
				continue;
			}

			try {
				if (logger != null && logger.isCreateDebugOutput()) {
					logger.debug("Registering project '" + projectURI + "'");
				}
				workspace.registerProject(projectURI);
				registeredProjects.put(projectId, projectURI);
			} catch (N4JSBrokenProjectException e) {
				throw new N4JSCompileException("Unable to register project '" + projectURI + "'", e);
			}
		}
	}

	/**
	 * Creates a new list, calling {@link File#getAbsoluteFile()} on each member
	 *
	 * @param relativeFiles
	 *            list of possibly relative paths.
	 * @return new list of absolute paths.
	 * @throws N4JSCompileException
	 *             in case of underlying IO-problems
	 */
	public List<File> toAbsoluteFileList(List<File> relativeFiles) throws N4JSCompileException {
		List<File> absProjectRoots = new ArrayList<>(relativeFiles.size());
		for (File relPR : relativeFiles) {
			try {
				absProjectRoots.add(relPR.getCanonicalFile());
			} catch (IOException e) {
				throw new N4JSCompileException("Unable to create canonical filename of file '" + relPR + "'", e);
			}
		}
		return absProjectRoots;
	}

	/**
	 * Collects the projects containing the given single source files.
	 *
	 * @param sourceFiles
	 *            the list of single source files
	 * @param workspace
	 *            the workspace to be checked for containing projects
	 * @return list of N4JS project locations
	 * @throws N4JSCompileException
	 *             if no project cannot be found for one of the given files
	 */
	public List<File> findProjectsForSingleFiles(List<File> sourceFiles,
			FileBasedWorkspace workspace)
			throws N4JSCompileException {

		Set<URI> result = Sets.newLinkedHashSet();

		for (File sourceFile : sourceFiles) {
			URI sourceFileURI = URI.createFileURI(sourceFile.toString());
			URI projectURI = workspace.findProjectWith(sourceFileURI);
			if (projectURI == null) {
				throw new N4JSCompileException("No project for file '" + sourceFile.toString() + "' found.");
			}
			result.add(projectURI);
		}

		// convert back to Files:
		return result.stream().map(u -> new File(u.toFileString())).collect(Collectors.toList());
	}

	/**
	 * Searches for direct sub-folders containing a File named {@link IN4JSProject#PACKAGE_JSON}
	 *
	 * @param absProjectRoots
	 *            all project root (must be absolute)
	 * @return list of directories being a project
	 */
	public List<File> collectAllProjectPaths(List<File> absProjectRoots) {
		return getProjectStream(absProjectRoots)
				.collect(Collectors.toList());
	}

	/**
	 * Searches for direct sub-folders containing a File named {@link IN4JSProject#PACKAGE_JSON}
	 *
	 * @param absProjectRoots
	 *            all project root (must be absolute)
	 * @return list of directories being a project
	 */
	public List<URI> collectAllProjectUris(List<File> absProjectRoots) {
		return getProjectStream(absProjectRoots)
				.map(HeadlessHelper::fileToURI)
				.collect(Collectors.toList());
	}

	/**
	 * Returns a list of {@link N4JSProject} instances representing all N4JS projects at the given locations.
	 *
	 * Excludes projects that have been installed by the library manager which do not need to be built (cf.
	 * {@link #isProjectToBeBuilt(IN4JSProject)}).
	 *
	 * @param projectURIs
	 *            the URIs to process
	 * @return a list of projects at the given URIs
	 */
	public List<N4JSProject> getN4JSProjects(List<URI> projectURIs) {
		return projectURIs.stream().map(URIUtils::normalize)
				.map(u -> n4jsModel.getN4JSProject(u))
				.filter(p -> isProjectToBeBuilt(p))
				.collect(Collectors.toList());
	}

	/**
	 * Indicates whether the given {@code project} is to be built by the headless compiler.
	 *
	 * In particular, this excludes transitive non-N4JS dependencies that have been installed by npm.
	 *
	 */
	public boolean isProjectToBeBuilt(IN4JSProject project) {
		if (project.isExternal()) {
			return ExternalLibraryUtils.isExternalProjectDirectory(project.getLocationPath().toFile());
		}
		return true;
	}

	/**
	 * Convert the given list of files to a list of URIs. Each file is converted to a URI by means of
	 * {@link URI#createFileURI(String)}.
	 *
	 * @param files
	 *            the files to convert
	 * @return the list of URIs
	 */
	public List<URI> createFileURIs(List<File> files) {
		return files.stream().map(f -> URI.createFileURI(f.toString())).map(URIUtils::normalize)
				.collect(Collectors.toList());
	}

	/**
	 * Utility for deciding if a given project location should be registered in the FileBasedWorkspace. Note that this
	 * method has three "return values". {@code false} if provided project manifest describes new project that has to be
	 * registered. {@code false} when project manifest describes already known project in the same location, in which
	 * case project is safe to be skipped. {@code N4JSCompileException} is thrown when provided project manifest
	 * describes already known project but in different location in which case compilation should be stopped.
	 *
	 * @param projectId
	 *            of the new project to be considered for registering
	 * @param projectLocation
	 *            of the new project to be considered for registering
	 * @param registeredProjects
	 *            local cache of already known projects
	 * @return {@code false} if projects needs to be registered
	 * @throws N4JSCompileException
	 *             if project conflicts with project in different location
	 */
	private boolean skipRegistering(String projectId, URI projectLocation, Map<String, URI> registeredProjects)
			throws N4JSCompileException {

		// new ID, don't skip registering
		if (!registeredProjects.containsKey(projectId))
			return false;

		URI registeredProjectLocation = registeredProjects.get(projectId);

		// duplicate is the same location, so the same project passed twice, skip registering
		if (projectLocation.equals(registeredProjectLocation))
			return true;

		if (registeredProjectLocation == null)
			// our local cache of known projects is out of sync with FileBasedWorkspace -> stop compilation
			throw new N4JSCompileException("Duplicate project id [" + projectId
					+ "]. Already registered project at " + registeredProjects.get(projectId)
					+ ", trying to register project at " + projectLocation + ".");

		// duplicate is in new location, so new project with the same name -> stop compilation
		throw new N4JSCompileException("Duplicate project id [" + projectId
				+ "]. Already registered project at " + registeredProjectLocation
				+ ", trying to register project at " + projectLocation + ".");

	}

	/**
	 * Returns a stream of {@link File} handles for all N4JS project locations that can be found by scanning the given
	 * list of {@code absProjectRoots}.
	 *
	 * Never includes the target platform install location (cf.
	 * {@link TargetPlatformInstallLocationProvider#getTargetPlatformFileLocation()}).
	 */
	private Stream<File> getProjectStream(List<File> absProjectRoots) {
		final File targetPlatformLocation = getTargetPlatformInstallLocation();

		return absProjectRoots.stream()
				.filter(f -> f.exists())
				// find all contained folders
				.flatMap(root -> Arrays.asList(root.listFiles(File::isDirectory)).stream())
				// only those with package.json file
				.filter(dir -> new File(dir, IN4JSProject.PACKAGE_JSON).isFile())
				// do not include target platform install location as project (if install location is configured)
				.filter(dir -> targetPlatformLocation == null || !dir.equals(targetPlatformLocation));
	}

	/**
	 * Returns a {@link File} handle for the target platform install location or {@code null} if no such location is
	 * configured.
	 */
	private File getTargetPlatformInstallLocation() {
		final java.net.URI targetPlatformLocation = targetPlatformInstallLocationProvider
				.getTargetPlatformInstallLocation();
		if (null == targetPlatformLocation) {
			return null;
		}
		return new File(targetPlatformLocation);
	}

	private static URI fileToURI(File file) {
		return URI.createFileURI(file.toString());
	}
}
