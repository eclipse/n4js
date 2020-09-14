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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.internal.MultiCleartriggerCache;
import org.eclipse.n4js.internal.N4JSRuntimeCore;
import org.eclipse.n4js.packagejson.PackageJsonProperties;
import org.eclipse.n4js.projectModel.IN4JSCore;
import org.eclipse.n4js.projectModel.IN4JSProject;
import org.eclipse.n4js.projectModel.locations.FileURI;
import org.eclipse.n4js.projectModel.names.N4JSProjectName;
import org.eclipse.n4js.utils.ProjectDiscoveryHelper;
import org.eclipse.n4js.xtext.workspace.ProjectConfigSnapshot;
import org.eclipse.n4js.xtext.workspace.WorkspaceChanges;
import org.eclipse.n4js.xtext.workspace.WorkspaceConfigSnapshot;
import org.eclipse.n4js.xtext.workspace.XIProjectConfig;
import org.eclipse.n4js.xtext.workspace.XIWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * Wrapper around {@link IN4JSCore}.
 */
@SuppressWarnings("restriction")
public class N4JSWorkspaceConfig implements XIWorkspaceConfig {

	private final URI baseDirectory;
	private final IN4JSCore delegate;
	private final MultiCleartriggerCache multiCleartriggerCache;

	/** Constructor */
	public N4JSWorkspaceConfig(URI baseDirectory, IN4JSCore delegate, MultiCleartriggerCache multiCleartriggerCache) {
		this.baseDirectory = baseDirectory;
		this.delegate = delegate;
		this.multiCleartriggerCache = multiCleartriggerCache;
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
	public WorkspaceChanges update(WorkspaceConfigSnapshot oldWorkspaceConfig, List<URI> dirtyFiles,
			List<URI> deletedFiles) {

		WorkspaceChanges changes = WorkspaceChanges.createUrisRemovedAndChanged(deletedFiles, dirtyFiles);

		boolean needToDetectAddedRemovedProjects = false;
		for (URI changedResource : Iterables.concat(dirtyFiles, deletedFiles)) {
			String lastSegment = changedResource.lastSegment();
			boolean isPackageJson = lastSegment != null && lastSegment.equals(N4JSGlobals.PACKAGE_JSON);
			if (!isPackageJson) {
				continue;
			}

			ProjectConfigSnapshot oldProject = oldWorkspaceConfig.findProjectContaining(changedResource);
			XIProjectConfig project = oldProject != null ? findProjectByName(oldProject.getName()) : null;
			if (oldProject != null && project != null) {
				// an existing project was modified (maybe removed)
				changes = changes.merge(((N4JSProjectConfig) project).update(oldWorkspaceConfig, changedResource));

				if (((N4JSProjectConfig) project).isWorkspacesProject()) {
					needToDetectAddedRemovedProjects = true;
				}
			} else {
				// a new project was created
				needToDetectAddedRemovedProjects = true;
			}
		}

		if (needToDetectAddedRemovedProjects) {
			changes = changes.merge(detectAddedRemovedProjects(oldWorkspaceConfig));
		}

		changes = recomputeSortedDependenciesIfNecessary(oldWorkspaceConfig, changes);

		return changes;
	}

	private WorkspaceChanges detectAddedRemovedProjects(WorkspaceConfigSnapshot oldWorkspaceConfig) {

		// update all projects
		((N4JSRuntimeCore) delegate).deregisterAll();

		ProjectDiscoveryHelper projectDiscoveryHelper = ((N4JSRuntimeCore) delegate).getProjectDiscoveryHelper();
		Path baseDir = new FileURI(getPath()).toFile().toPath();
		LinkedHashSet<Path> newProjectPaths = projectDiscoveryHelper.collectAllProjectDirs(baseDir);
		for (Path newProjectPath : newProjectPaths) {
			((N4JSRuntimeCore) delegate).registerProject(newProjectPath.toFile());
		}

		// detect changes
		Map<URI, ProjectConfigSnapshot> oldProjectsMap = IterableExtensions.toMap(oldWorkspaceConfig.getProjects(),
				ProjectConfigSnapshot::getPath);
		Map<URI, XIProjectConfig> newProjectsMap = IterableExtensions.toMap(getProjects(), XIProjectConfig::getPath);
		List<ProjectConfigSnapshot> addedProjects = new ArrayList<>();
		List<ProjectConfigSnapshot> removedProjects = new ArrayList<>();
		for (URI uri : Sets.union(oldProjectsMap.keySet(), newProjectsMap.keySet())) {
			boolean isOld = oldProjectsMap.containsKey(uri);
			boolean isNew = newProjectsMap.containsKey(uri);
			if (isOld && !isNew) {
				removedProjects.add(oldProjectsMap.get(uri));
			} else if (!isOld && isNew) {
				addedProjects.add(newProjectsMap.get(uri).toSnapshot());
			}
		}

		return new WorkspaceChanges(ImmutableList.of(), ImmutableList.of(), ImmutableList.of(),
				ImmutableList.of(),
				ImmutableList.of(), ImmutableList.copyOf(removedProjects), ImmutableList.copyOf(addedProjects),
				ImmutableList.of());
	}

	/**
	 * The list of {@link IN4JSProject#getSortedDependencies() sorted dependencies} of {@link IN4JSProject}s is tricky
	 * for two reasons:
	 * <ol>
	 * <li>the sorted dependencies do not contain names of non-existing projects (in case of unresolved project
	 * references in the package.json),
	 * <li>the order of the sorted dependencies depends on the characteristics of the target projects (mainly the
	 * {@link IN4JSProject#getDefinesPackageName() "defines package"} property).
	 * </ol>
	 * Therefore, the "sorted dependencies" can change even without a change in the <code>package.json</code> file of
	 * the source project. To detect and apply these changes is the purpose of this method.
	 * <p>
	 * TODO: sorted dependencies should not be a property of IN4JSProject/N4JSProjectConfig/N4JSProjectConfigSnapshot
	 * (probably the scoping has to be adjusted, because the sorted dependencies ensure correct shadowing between
	 * definition and defined projects)
	 */
	protected WorkspaceChanges recomputeSortedDependenciesIfNecessary(WorkspaceConfigSnapshot oldWorkspaceConfig,
			WorkspaceChanges changes) {

		boolean needRecompute = !changes.getAddedProjects().isEmpty() || !changes.getRemovedProjects().isEmpty()
				|| Iterables.any(changes.getChangedProjects(), pc -> didDefinesPackageChange(pc, oldWorkspaceConfig));

		if (needRecompute) {
			multiCleartriggerCache.clear(MultiCleartriggerCache.CACHE_KEY_SORTED_DEPENDENCIES);
			Set<String> changedProjectNames = changes.getChangedProjects().stream().map(ProjectConfigSnapshot::getName)
					.collect(Collectors.toSet());
			List<ProjectConfigSnapshot> projectsWithChangedSortedDeps = new ArrayList<>();
			for (XIProjectConfig pc : getProjects()) {
				String projectName = pc.getName();
				if (changedProjectNames.contains(projectName)) {
					continue; // should already be up-to-date
				}
				ProjectConfigSnapshot oldSnapshot = oldWorkspaceConfig.findProjectByName(projectName);
				if (oldSnapshot == null) {
					continue;
				}
				List<String> oldSortedDeps = ((N4JSProjectConfigSnapshot) oldSnapshot).getSortedDependencies();
				List<String> newSortedDeps = ((N4JSProjectConfig) pc).toProject().getSortedDependencies().stream()
						.map(IN4JSProject::getProjectName)
						.map(N4JSProjectName::getRawName)
						.collect(Collectors.toList());
				if (!newSortedDeps.equals(oldSortedDeps)) {
					ProjectConfigSnapshot newSnapshot = pc.toSnapshot();
					if (!newSnapshot.equals(oldSnapshot)) {
						projectsWithChangedSortedDeps.add(newSnapshot);
					}
				}
			}
			if (!projectsWithChangedSortedDeps.isEmpty()) {
				changes = changes.merge(WorkspaceChanges.createProjectsChanged(projectsWithChangedSortedDeps));
			}
		}
		return changes;
	}

	/** Tells whether the property {@link PackageJsonProperties#DEFINES_PACKAGE "definesPackage"} changed. */
	private boolean didDefinesPackageChange(ProjectConfigSnapshot projectConfig,
			WorkspaceConfigSnapshot oldWorkspaceConfig) {
		ProjectConfigSnapshot oldProjectConfig = oldWorkspaceConfig.findProjectByName(projectConfig.getName());
		return oldProjectConfig == null || !Objects.equals(
				((N4JSProjectConfigSnapshot) projectConfig).getDefinesPackage(),
				((N4JSProjectConfigSnapshot) oldProjectConfig).getDefinesPackage());
	}
}
