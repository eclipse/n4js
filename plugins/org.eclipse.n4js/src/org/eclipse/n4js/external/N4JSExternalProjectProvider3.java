/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.external;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.internal.N4JSModel;
import org.eclipse.n4js.projectModel.IN4JSProject;
import org.eclipse.n4js.utils.resources.ExternalProject;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * This provider wraps {@link ExternalProject}s into {@link N4JSExternalProject}s.
 */
@Singleton
public class N4JSExternalProjectProvider3 {

	@Inject
	private ExternalLibraryWorkspace extLibWS;

	@Inject
	private N4JSModel model;

	public N4JSExternalProject getProject(String projectName) {
		ExternalProject extPrj = extLibWS.getProject(projectName);
		return createN4JSExternalProject(extPrj);
	}

	public Collection<N4JSExternalProject> getProjects() {
		Collection<N4JSExternalProject> n4extPrjs = new HashSet<>();
		for (ExternalProject extPrj : extLibWS.getProjects()) {
			N4JSExternalProject n4extPrj = createN4JSExternalProject(extPrj);
			n4extPrjs.add(n4extPrj);
		}
		return n4extPrjs;
	}

	public Collection<N4JSExternalProject> getProjectsIn(Iterable<java.net.URI> rootLocations) {
		Collection<N4JSExternalProject> n4extPrjs = new HashSet<>();
		for (java.net.URI rLoc : rootLocations) {
			n4extPrjs.addAll(getProjectsIn(rLoc));
		}
		return n4extPrjs;
	}

	public Collection<N4JSExternalProject> getProjectsIn(java.net.URI rootLocations) {
		Collection<N4JSExternalProject> n4extPrjs = new HashSet<>();
		Iterable<ExternalProject> extPrjs = extLibWS.getProjects(rootLocations);
		for (ExternalProject extPrj : extPrjs) {
			N4JSExternalProject n4extPrj = createN4JSExternalProject(extPrj);
			n4extPrjs.add(n4extPrj);
		}
		return n4extPrjs;
	}

	private N4JSExternalProject createN4JSExternalProject(ExternalProject externalProject) {
		if (externalProject != null) {
			File projectLocation = externalProject.getLocation().toFile();
			URI projectURI = org.eclipse.emf.common.util.URI.createFileURI(projectLocation.getAbsolutePath());
			IN4JSProject in4jsProject = model.getN4JSProject(projectURI);
			return new N4JSExternalProject(projectLocation, in4jsProject);
		}
		return null;
	}

}
