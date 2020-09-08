/**
 * Copyright (c) 2019 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.internal.lsp;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.internal.N4JSRuntimeCore;
import org.eclipse.n4js.projectModel.IN4JSCore;
import org.eclipse.n4js.projectModel.IN4JSProject;
import org.eclipse.n4js.projectModel.locations.FileURI;
import org.eclipse.n4js.projectModel.names.N4JSProjectName;
import org.eclipse.n4js.utils.ProjectDiscoveryHelper;
import org.eclipse.n4js.xtext.workspace.WorkspaceChanges;
import org.eclipse.n4js.xtext.workspace.XIProjectConfig;
import org.eclipse.n4js.xtext.workspace.XIWorkspaceConfig;
import org.eclipse.xtext.workspace.IProjectConfig;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

/**
 * Wrapper around {@link IN4JSCore}.
 */
@SuppressWarnings("restriction")
public class N4JSWorkspaceConfig implements XIWorkspaceConfig {

	private final URI baseDirectory;
	private final IN4JSCore delegate;

	/** Constructor */
	public N4JSWorkspaceConfig(URI baseDirectory, IN4JSCore delegate) {
		this.baseDirectory = baseDirectory;
		this.delegate = delegate;
	}

	@Override
	public XIProjectConfig findProjectByName(String name) {
		IN4JSProject project = delegate.findProject(new N4JSProjectName(name)).orNull();
		if (project != null) {
			return new N4JSProjectConfig(this, project);
		}
		return null;
	}

	@Override
	public XIProjectConfig findProjectContaining(URI member) {
		IN4JSProject project = delegate.findProject(member).orNull();
		if (project != null) {
			return new N4JSProjectConfig(this, project);
		}
		return null;
	}

	@Override
	public Set<? extends XIProjectConfig> getProjects() {
		Set<XIProjectConfig> pConfigs = new HashSet<>();
		for (IN4JSProject project : delegate.findAllProjects()) {
			pConfigs.add(new N4JSProjectConfig(this, project));
		}
		return pConfigs;
	}

	@Override
	public URI getPath() {
		return baseDirectory;
	}

	@Override
	public WorkspaceChanges update(List<URI> changedResources) {
		WorkspaceChanges result = WorkspaceChanges.NO_CHANGES;
		for (URI changedResource : changedResources) {
			result = result.merge(update(changedResource));
		}
		return result;
	}

	private WorkspaceChanges update(URI changedResource) {
		IProjectConfig project = this.findProjectContaining(changedResource);

		// get old projects here before it gets invalidated by N4JSProjectConfig#update()
		Set<? extends XIProjectConfig> oldProjects = getProjects();

		WorkspaceChanges update = new WorkspaceChanges();

		// project location do not end with an empty segment
		FileURI projectUri = project != null ? new FileURI(new File(project.getPath().toFileString())) : null;
		boolean wasExistingInWorkspace = projectUri != null && ((N4JSRuntimeCore) delegate).isRegistered(projectUri);
		if (project != null && wasExistingInWorkspace) {
			// an existing project was modified
			update = update.merge(((N4JSProjectConfig) project).update(changedResource));

			if (((N4JSProjectConfig) project).isWorkspacesProject()) {
				update = update.merge(detectAddedRemovedProjects(oldProjects));
			}
		} else {
			// a new project was created
			update = update.merge(detectAddedRemovedProjects(oldProjects));
		}

		return update;
	}

	private WorkspaceChanges detectAddedRemovedProjects(Set<? extends XIProjectConfig> oldProjects) {

		// update all projects
		((N4JSRuntimeCore) delegate).deregisterAll();

		ProjectDiscoveryHelper projectDiscoveryHelper = ((N4JSRuntimeCore) delegate).getProjectDiscoveryHelper();
		Path baseDir = new FileURI(getPath()).toFile().toPath();
		LinkedHashSet<Path> newProjectPaths = projectDiscoveryHelper.collectAllProjectDirs(baseDir);
		for (Path newProjectPath : newProjectPaths) {
			((N4JSRuntimeCore) delegate).registerProject(newProjectPath.toFile());
		}

		// detect changes
		Map<URI, XIProjectConfig> oldProjectsMap = getProjectsMap(oldProjects);
		Map<URI, XIProjectConfig> newProjectsMap = getProjectsMap(getProjects());
		List<XIProjectConfig> addedProjects = new ArrayList<>();
		List<XIProjectConfig> removedProjects = new ArrayList<>();
		for (URI uri : Sets.union(oldProjectsMap.keySet(), newProjectsMap.keySet())) {
			boolean isOld = oldProjectsMap.containsKey(uri);
			boolean isNew = newProjectsMap.containsKey(uri);
			if (isOld && !isNew) {
				removedProjects.add(oldProjectsMap.get(uri));
			} else if (!isOld && isNew) {
				addedProjects.add(newProjectsMap.get(uri));
			}
		}

		boolean dependenciesChanged = !addedProjects.isEmpty() || !removedProjects.isEmpty();
		return new WorkspaceChanges(dependenciesChanged, ImmutableList.of(), ImmutableList.of(), ImmutableList.of(),
				ImmutableList.of(),
				ImmutableList.of(), ImmutableList.copyOf(removedProjects), ImmutableList.copyOf(addedProjects),
				ImmutableList.of());
	}

	private Map<URI, XIProjectConfig> getProjectsMap(Set<? extends XIProjectConfig> projects) {
		Map<URI, XIProjectConfig> projectsMap = new HashMap<>();
		for (XIProjectConfig projectConfig : projects) {
			projectsMap.put(projectConfig.getPath(), projectConfig);
		}
		return projectsMap;
	}
}
