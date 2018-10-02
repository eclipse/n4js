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
package org.eclipse.n4js.external;

import static java.util.Collections.emptyIterator;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.projectDescription.ProjectDescription;
import org.eclipse.n4js.projectDescription.ProjectReference;
import org.eclipse.n4js.semver.Semver.VersionNumber;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Singleton;

/**
 * NOOP implementation of the external library workspace.
 */
@Singleton
public class HlcExternalLibraryWorkspace extends ExternalLibraryWorkspace {

	@Override
	public RegisterResult registerProjects(IProgressMonitor monitor, Set<URI> toBeUpdated) {
		return new RegisterResult();
	}

	@Override
	public RegisterResult deregisterProjects(IProgressMonitor monitor, Set<URI> toBeDeleted) {
		return new RegisterResult();
	}

	@Override
	public RegisterResult deregisterAllProjects(IProgressMonitor monitor) {
		return new RegisterResult();
	}

	@Override
	public void scheduleWorkspaceProjects(IProgressMonitor monitor, Set<URI> toBeScheduled) {
		// NOOP
	}

	@Override
	public Collection<N4JSExternalProject> getProjects() {
		return emptyList();
	}

	@Override
	public Map<String, VersionNumber> getProjectInfos() {
		return emptyMap();
	}

	@Override
	public Collection<N4JSExternalProject> getProjectsIn(final java.net.URI rootLocation) {
		return emptyList();
	}

	@Override
	public Collection<N4JSExternalProject> getProjectsIn(final Collection<java.net.URI> rootLocations) {
		return emptyList();
	}

	@Override
	public Collection<ProjectDescription> getProjectsDescriptions(java.net.URI rootLocation) {
		return emptyList();
	}

	@Override
	public N4JSExternalProject getProject(final String projectName) {
		return null;
	}

	@Override
	public N4JSExternalProject getProject(URI projectLocation) {
		return null;
	}

	@Override
	public IResource getResource(final URI location) {
		return null;
	}

	@Override
	public void updateState() {
		// NOOP
	}

	@Override
	public ProjectDescription getProjectDescription(final URI location) {
		return null;
	}

	@Override
	public URI getLocation(final URI projectURI, final ProjectReference reference) {
		return null;
	}

	@Override
	public Iterator<URI> getFolderIterator(final URI folderLocation) {
		return emptyIterator();
	}

	@Override
	public URI findArtifactInFolder(final URI folderLocation, final String folderRelativePath) {
		return null;
	}

	@Override
	public URI findProjectWith(final URI nestedLocation) {
		return null;
	}

	@Override
	public List<Pair<N4JSExternalProject, ProjectDescription>> computeProjectsUncached() {
		return emptyList();
	}

}
