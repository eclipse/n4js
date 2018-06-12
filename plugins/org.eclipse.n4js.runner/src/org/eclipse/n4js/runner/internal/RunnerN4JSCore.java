/**
 * Copyright (c) 2017 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.runner.internal;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.external.ExternalLibraryUtils;
import org.eclipse.n4js.external.libraries.ShippedCodeAccess;
import org.eclipse.n4js.internal.FileBasedWorkspace;
import org.eclipse.n4js.internal.N4JSModel;
import org.eclipse.n4js.internal.N4JSProject;
import org.eclipse.n4js.projectModel.IN4JSCore;
import org.eclipse.n4js.projectModel.IN4JSProject;
import org.eclipse.n4js.utils.ProjectDescriptionHelper;

import com.google.common.base.Strings;
import com.google.inject.Inject;

/**
 * Provides access to the shipped code projects.
 *
 * Provides similar functionality to {@link IN4JSCore} but limited to projects included with the shipped code.
 */
public class RunnerN4JSCore {
	private static final Logger LOGGER = Logger.getLogger(RunnerN4JSCore.class);

	private static final int DANGLING_SEGMENT_COUNT = 1;

	@Inject
	private ProjectDescriptionHelper projectDescriptionHelper;

	/**
	 * Returns all shipped projects as iterable. Returned projects are stubs for real {@link N4JSProject}. They
	 * implement the same API only to allow common utilities to calculate runner information for both real workspace
	 * based projects and stubs returned here. All information is calculated from the file system on the fly, and is not
	 * stored. Subsequent calls will result all information being computed once more.
	 *
	 * @return iterable of shipped code wrapped in {@link IN4JSProject} interface
	 */
	public Iterable<IN4JSProject> getAllShippedProjects() {

		final RunnerTargetPlatformInstallLocationProvider locationProvider = new RunnerTargetPlatformInstallLocationProvider();
		final RunnerClasspathPackageManager manager = new RunnerClasspathPackageManager();
		final FileBasedWorkspace workspace = new FileBasedWorkspace(manager, projectDescriptionHelper);
		final N4JSModel model = new N4JSModel(workspace, locationProvider);

		ShippedCodeAccess.getAllShippedPaths().forEach(path -> discoverProjects(path, workspace));

		// we need to collect projects provided by the workspace iterator into iterable instance to allow caller to make
		// multiple iterations over it. Note that just wrapping iterator into iterable (e.g. via
		// org.eclipse.xtext.xbase.lib.IteratorExtensions) does not work, i.e. it is just simple wrapping that allows
		// one iteration just like plain iterator.
		List<IN4JSProject> projects = new ArrayList<>();
		workspace.getAllProjectsLocations().forEachRemaining(
				location -> projects.add(model.getN4JSProject(location)));

		return projects;
	}

	/**
	 * Discovers all projects at given location. Only first level children, no recursive lookup, i.e. nested projects
	 * are not supported. Projects are registered in the provided workspace. Access to the projects is done through
	 * provided model.
	 *
	 * @param rootLocation
	 *            location from which projects should be loaded.
	 * @param workspace
	 *            workspace used for project registration
	 */
	private void discoverProjects(String rootLocation, FileBasedWorkspace workspace) {
		File root = new File(rootLocation);

		Arrays.asList(root.listFiles()).stream().filter(File::isDirectory).forEach(projectDir -> {
			if (ExternalLibraryUtils.isExternalProjectDirectory(projectDir)) {
				URI createURI = createProjectUri(projectDir);
				workspace.registerProject(createURI);
			} else {
				LOGGER.warn("Cannot locate project description file (i.e. package.json) file at "
						+ projectDir.getAbsolutePath());
			}
		});
	}

	/**
	 * Creates project {@link URI} for the given file system location.
	 *
	 * @param location
	 *            file system location to transform
	 * @return {@link URI} for the provided location
	 */
	private URI createProjectUri(File location) {
		URI createURI = null;
		try {
			createURI = URI.createURI(location.toURI().toURL().toString());
			// by convention IN4JSProject URI does not end with '/'
			// i.e. last segment is not empty
			if (Strings.isNullOrEmpty(createURI.lastSegment())) {
				createURI = createURI.trimSegments(DANGLING_SEGMENT_COUNT);
			}
		} catch (MalformedURLException e) {
			LOGGER.warn("Exceptions when transforming location: " + location, e);
		}
		return createURI;
	}
}
