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
package org.eclipse.n4js.ui.external;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Maps.newTreeMap;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Collections.unmodifiableCollection;
import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.external.ExternalProjectCacheLoader;
import org.eclipse.n4js.n4mf.ProjectDescription;
import org.eclipse.n4js.preferences.ExternalLibraryPreferenceStore;
import org.eclipse.n4js.preferences.ExternalLibraryPreferenceStore.ExternalProjectLocationsProvider;
import org.eclipse.n4js.preferences.ExternalLibraryPreferenceStore.StoreUpdatedListener;
import org.eclipse.n4js.utils.Procedure;
import org.eclipse.n4js.utils.resources.ExternalProject;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * This provider creates {@link ExternalProject}s.
 */
@Singleton
public class ExternalProjectProvider implements StoreUpdatedListener {
	private static Logger logger = Logger.getLogger(ExternalProjectProvider.class);

	@Inject
	private ExternalProjectCacheLoader cacheLoader;

	@Inject
	private ProjectStateChangeListener projectStateChangeListener;

	private final Collection<java.net.URI> rootLocations;
	private LoadingCache<URI, Optional<Pair<ExternalProject, ProjectDescription>>> projectCache;
	private Map<String, ExternalProject> projectNameMapping;

	/**
	 * Creates a new external library workspace instance with the preference store that provides the configured library
	 * location.
	 *
	 * @param preferenceStore
	 *            the preference store to get the registered external library locations.
	 */
	@Inject
	ExternalProjectProvider(ExternalLibraryPreferenceStore preferenceStore) {
		rootLocations = newHashSet(preferenceStore.getLocations());
		preferenceStore.addListener(this);
	}

	/**
	 * Initializes the backing cache with the cache loader and registers a {@link ProjectStateChangeListener} into the
	 * workspace.
	 */
	@Inject
	void init() {
		projectCache = CacheBuilder.newBuilder().build(cacheLoader);
		if (Platform.isRunning()) {
			getWorkspace().addResourceChangeListener(projectStateChangeListener);
		}
	}

	Collection<java.net.URI> getRootLocations() {
		return rootLocations;
	}

	@Override
	public void storeUpdated(final ExternalLibraryPreferenceStore store, final IProgressMonitor monitor) {
		ensureInitialized();
		updateCache(store);
	}

	void ensureInitialized() {
		checkNotNull(getProjectMapping(), "Eclipse based external library workspace is not initialized yet.");
	}

	private Map<String, ExternalProject> getProjectMapping() {
		if (null == projectNameMapping) {
			synchronized (this) {
				if (null == projectNameMapping) {
					updateCache();
				}
			}
		}
		return projectNameMapping;
	}

	void updateCache(ExternalLibraryPreferenceStore store) {
		rootLocations.clear();
		rootLocations.addAll(store.getLocations());

		updateCache();
	}

	void updateCache() {
		projectCache.invalidateAll();
		visitAllExternalProjects(rootLocations, new Procedure<File>() {
			@Override
			public void doApply(File projectRoot) {
				final URI location = URI.createFileURI(projectRoot.getAbsolutePath());
				final Pair<ExternalProject, ProjectDescription> pair = get(location);
				if (null == pair) { // Removed trash.
					projectCache.invalidate(location);
				}
			}
		});

		updateMappings();
	}

	private Pair<ExternalProject, ProjectDescription> get(URI location) {
		try {
			return projectCache.get(location).orNull();
		} catch (ExecutionException e) {
			final String message = "Error while getting external project with description for location: " + location;
			logger.error(message, e);
			return null;
		}
	}

	/**
	 * Updates the internal state based on the available external project root locations.
	 * <p>
	 * This cannot be done in construction time, because it might happen that N4MF is not initialized yet, hence not
	 * available when injecting this instance.
	 */
	private void updateMappings() {
		Map<String, ExternalProject> projectIdProjectMap = newHashMap();
		Map<URI, Optional<Pair<ExternalProject, ProjectDescription>>> availableProjects = projectCache.asMap();
		visitAllExternalProjects(rootLocations, new Procedure<File>() {
			@Override
			public void doApply(File input) {
				URI projectLocation = URI.createFileURI(input.getAbsolutePath());
				if (availableProjects.containsKey(projectLocation)) {
					Pair<ExternalProject, ProjectDescription> pair = availableProjects.get(projectLocation).orNull();
					if (null != pair) {
						ExternalProject project = pair.getFirst();
						if (!projectIdProjectMap.containsKey(project.getName())) {
							projectIdProjectMap.put(project.getName(), project);
						}
					}
				}
			}
		});
		projectNameMapping = Collections.unmodifiableMap(projectIdProjectMap);
	}

	private void visitAllExternalProjects(Iterable<java.net.URI> pRootLocations, Procedure<File> procedure) {
		Iterable<java.net.URI> projectRoots = ExternalProjectLocationsProvider.INSTANCE
				.convertToProjectRootLocations(pRootLocations);

		for (java.net.URI projectRoot : projectRoots) {
			procedure.apply(new File(projectRoot));
		}
	}

	Collection<URI> getProjectURIs() {
		return projectCache.asMap().keySet();
	}

	Collection<ExternalProject> getProjects() {
		ensureInitialized();
		Map<String, ExternalProject> projects = getProjectMapping();
		return unmodifiableCollection(projects.values());
	}

	ExternalProject getProject(String projectName) {
		ensureInitialized();
		return getProjectMapping().get(projectName);
	}

	Collection<ExternalProject> getProjectsIn(Iterable<java.net.URI> pRootLocations) {
		Map<String, ExternalProject> projectsMapping = newTreeMap();
		for (java.net.URI rootLocation : pRootLocations) {
			Iterable<ExternalProject> projects = getProjectsIn(rootLocation);
			for (ExternalProject project : projects) {
				projectsMapping.put(project.getName(), project);
			}
		}
		return unmodifiableCollection(projectsMapping.values());
	}

	Collection<ExternalProject> getProjectsIn(java.net.URI rootLocation) {
		ensureInitialized();
		File rootFolder = new File(rootLocation);

		Map<String, ExternalProject> projectsMapping = newTreeMap();
		URI rootUri = URI.createFileURI(rootFolder.getAbsolutePath());

		for (Entry<URI, Optional<Pair<ExternalProject, ProjectDescription>>> entry : projectCache.asMap()
				.entrySet()) {

			URI projectLocation = entry.getKey();
			if (rootUri.equals(projectLocation.trimSegments(1))) {
				Pair<ExternalProject, ProjectDescription> pair = entry.getValue().orNull();
				if (null != pair && null != pair.getFirst()) {
					ExternalProject project = pair.getFirst();
					projectsMapping.put(project.getName(), project);
				}
			}
		}

		return unmodifiableCollection(projectsMapping.values());
	}

	Collection<ProjectDescription> getProjectsDescriptions(java.net.URI rootLocation) {
		ensureInitialized();
		File rootFolder = new File(rootLocation);

		Set<ProjectDescription> projectsMapping = newHashSet();
		URI rootUri = URI.createFileURI(rootFolder.getAbsolutePath());

		for (Entry<URI, Optional<Pair<ExternalProject, ProjectDescription>>> entry : projectCache.asMap()
				.entrySet()) {
			URI projectLocation = entry.getKey();
			if (rootUri.equals(projectLocation.trimSegments(1))) {
				Pair<ExternalProject, ProjectDescription> pair = entry.getValue().orNull();
				if (null != pair && null != pair.getFirst()) {
					ProjectDescription description = pair.getSecond();
					if (description != null) {
						projectsMapping.add(description);
					}
				}
			}
		}

		return unmodifiableCollection(projectsMapping);
	}

	Pair<ExternalProject, ProjectDescription> getProjectWithDescription(URI location) {
		try {
			return projectCache.get(location).orNull();
		} catch (ExecutionException e) {
			String message = "Error while getting external project with description for location: " + location;
			logger.error(message, e);
			return null;
		}

	}

}
