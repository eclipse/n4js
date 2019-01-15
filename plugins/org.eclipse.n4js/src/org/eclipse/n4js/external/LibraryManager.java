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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.eclipse.n4js.external.LibraryChange.LibraryChangeType.Install;
import static org.eclipse.n4js.external.LibraryChange.LibraryChangeType.Uninstall;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.n4js.binaries.IllegalBinaryStateException;
import org.eclipse.n4js.binaries.nodejs.NpmBinary;
import org.eclipse.n4js.projectDescription.ProjectDescription;
import org.eclipse.n4js.projectModel.IN4JSProject;
import org.eclipse.n4js.semver.SemverHelper;
import org.eclipse.n4js.semver.SemverMatcher;
import org.eclipse.n4js.semver.SemverUtils;
import org.eclipse.n4js.semver.Semver.NPMVersionRequirement;
import org.eclipse.n4js.semver.Semver.VersionNumber;
import org.eclipse.n4js.semver.model.SemverSerializer;
import org.eclipse.n4js.smith.Measurement;
import org.eclipse.n4js.utils.N4JSDataCollectors;
import org.eclipse.n4js.utils.ProjectDescriptionUtils;
import org.eclipse.n4js.utils.StatusHelper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Class for installing npm dependencies into the external library.
 */
@Singleton
public class LibraryManager {

	private static final Logger LOGGER = Logger.getLogger(LibraryManager.class);

	private static final NPMVersionRequirement NO_VERSION_REQUIREMENT = SemverUtils.createEmptyVersionRequirement();

	@Inject
	private ExternalLibraryWorkspace externalLibraryWorkspace;

	@Inject
	private StatusHelper statusHelper;

	@Inject
	private Provider<NpmBinary> npmBinaryProvider;

	@Inject
	private NpmLogger logger;

	@Inject
	private NpmCLI npmCli;

	@Inject
	private ExternalIndexSynchronizer indexSynchronizer;

	@Inject
	private SemverHelper semverHelper;

	/**
	 * Call this method to synchronize the information in the Xtext index with all external projects in the external
	 * library folders.
	 */
	public void synchronizeNpms(IProgressMonitor monitor) {
		indexSynchronizer.synchronizeNpms(monitor);
	}

	public IStatus installNPM(String packageName, IProgressMonitor monitor) {
		return installNPM(packageName, (IN4JSProject) null, monitor);
	}

	public IStatus installNPM(String packageName, String packageVersionStr, IProgressMonitor monitor) {
		return installNPM(packageName, packageVersionStr, (IN4JSProject) null, monitor);
	}

	public IStatus installNPM(String packageName, NPMVersionRequirement packageVersion, IProgressMonitor monitor) {
		return installNPM(packageName, packageVersion, (IN4JSProject) null, monitor);
	}

	public IStatus installNPMs(Map<String, NPMVersionRequirement> versionedNPMs, boolean forceReloadAll,
			IProgressMonitor monitor) {
		return installNPMs(versionedNPMs, forceReloadAll, (IN4JSProject) null, monitor);
	}

	/**
	 * Installs the given npm package in a blocking fashion.
	 *
	 * @param packageName
	 *            the name of the package that has to be installed via package manager.
	 * @param monitor
	 *            the monitor for the blocking install process.
	 * @return a status representing the outcome of the install process.
	 */
	public IStatus installNPM(String packageName, IN4JSProject context, IProgressMonitor monitor) {
		return installNPM(packageName, NO_VERSION_REQUIREMENT, context, monitor);
	}

	/**
	 * Installs the given npm package in a blocking fashion.
	 *
	 * @param packageName
	 *            the name of the package that has to be installed via package manager.
	 * @param monitor
	 *            the monitor for the blocking install process.
	 * @return a status representing the outcome of the install process.
	 * @throws IllegalArgumentException
	 *             if the given version string cannot be parsed to an {@link NPMVersionRequirement}.
	 */
	public IStatus installNPM(String packageName, String packageVersionStr, IN4JSProject context,
			IProgressMonitor monitor) {
		NPMVersionRequirement packageVersion = semverHelper.parse(packageVersionStr);
		if (packageVersion == null) {
			throw new IllegalArgumentException("unable to parse version requirement: " + packageVersionStr);
		}
		return installNPM(packageName, packageVersion, context, monitor);
	}

	/**
	 * Installs the given npm package in a blocking fashion.
	 *
	 * @param packageName
	 *            the name of the package that has to be installed via package manager.
	 * @param monitor
	 *            the monitor for the blocking install process.
	 * @return a status representing the outcome of the install process.
	 */
	public IStatus installNPM(String packageName, NPMVersionRequirement packageVersion, IN4JSProject context,
			IProgressMonitor monitor) {
		return installNPMs(Collections.singletonMap(packageName, packageVersion), false, context, monitor);
	}

	/**
	 * Installs the given npm packages in a blocking fashion.
	 *
	 * This method tries to install all packages even if installation for some of them fail. In such cases it will try
	 * log encountered errors but it will try to proceed for all remaining packages. Details about issues are in the
	 * returned status.
	 *
	 * @param unversionedPackages
	 *            map of name to version data for the packages to be installed via package manager.
	 * @param monitor
	 *            the monitor for the blocking install process.
	 * @return a status representing the outcome of the install process.
	 */
	public IStatus installNPMs(Collection<String> unversionedPackages, IN4JSProject context, IProgressMonitor monitor) {
		Map<String, NPMVersionRequirement> versionedPackages = unversionedPackages.stream()
				.collect(Collectors.toMap((String name) -> name, (String name) -> NO_VERSION_REQUIREMENT));
		return installNPMs(versionedPackages, false, context, monitor);
	}

	/**
	 * Installs the given npm packages in a blocking fashion.
	 *
	 * This method tries to install all packages even if installation for some of them fail. In such cases it will try
	 * log encountered errors but it will try to proceed for all remaining packages. Details about issues are in the
	 * returned status.
	 *
	 * @param versionedNPMs
	 *            map of name to version data for the packages to be installed via package manager.
	 * @param monitor
	 *            the monitor for the blocking install process.
	 * @param forceReloadAll
	 *            Specifies whether after the installation all external libraries in the external library workspace
	 *            should be reloaded and rebuilt (cf. {@link #registerAllExternalProjects(IProgressMonitor)}). If
	 *            {@code false}, only the set of packages that was created and/or updated by this install call will be
	 *            scheduled for a reload.
	 * @return a status representing the outcome of the install process.
	 */
	public IStatus installNPMs(Map<String, NPMVersionRequirement> versionedNPMs, boolean forceReloadAll,
			IN4JSProject context, IProgressMonitor monitor) {
		return runWithWorkspaceLock(() -> installNPMsInternal(versionedNPMs, forceReloadAll, context, monitor));
	}

	private IStatus installNPMsInternal(Map<String, NPMVersionRequirement> versionedNPMs, boolean forceReloadAll,
			IN4JSProject context, IProgressMonitor monitor) {

		String msg = getMessage(versionedNPMs);
		MultiStatus status = statusHelper.createMultiStatus(msg);
		logger.logInfo(msg);

		IStatus binaryStatus = checkNPM();
		if (!binaryStatus.isOK()) {
			status.merge(binaryStatus);
			return status;
		}

		try (Measurement mes = N4JSDataCollectors.dcLibMngr.getMeasurement("installDependenciesInternal");) {
			final int steps = forceReloadAll ? 3 : 2;
			SubMonitor subMonitor = SubMonitor.convert(monitor, steps + 4);
			Map<String, NPMVersionRequirement> npmsToInstall = new LinkedHashMap<>(versionedNPMs);

			SubMonitor subMonitor1 = subMonitor.split(2);
			subMonitor1.setTaskName("Installing packages... [step 1 of " + steps + "]");
			List<LibraryChange> actualChanges = installUninstallNPMs(subMonitor1, status, npmsToInstall, emptyList(),
					context);

			if (!status.isOK()) {
				return status;
			}

			// if forceReloadAll, unregister all currently-registered projects from
			// the workspace and remove them from the index
			if (forceReloadAll) {
				SubMonitor subMonitor2 = subMonitor.split(1);
				subMonitor2.setTaskName("Clean all packages... [step 2 of 3]");
				externalLibraryWorkspace.deregisterAllProjects(subMonitor2);
			}

			try (Measurement m = N4JSDataCollectors.dcIndexSynchronizer.getMeasurement("synchronizeNpms")) {
				SubMonitor subMonitor3 = subMonitor.split(4);
				subMonitor3.setTaskName("Building installed packages... [step " + steps + " of " + steps + "]");
				indexSynchronizer.synchronizeNpms(subMonitor3, actualChanges);
			}

			return status;

		} finally {
			monitor.done();
		}
	}

	private String getMessage(Map<String, NPMVersionRequirement> versionedNPMs) {
		String msg = "Installing NPM(s): ";

		for (Iterator<Map.Entry<String, NPMVersionRequirement>> entryIter = versionedNPMs.entrySet()
				.iterator(); entryIter.hasNext();) {

			Map.Entry<String, NPMVersionRequirement> entry = entryIter.next();
			msg += entry.getKey(); // packageName

			NPMVersionRequirement versionRequirement = entry.getValue();
			if (versionRequirement != null && !SemverUtils.isEmptyVersionRequirement(versionRequirement)) {
				msg += "@" + versionRequirement;
			}

			if (entryIter.hasNext()) {
				msg += ", ";
			}
		}

		return msg;
	}

	private List<LibraryChange> installUninstallNPMs(IProgressMonitor monitor, MultiStatus status,
			Map<String, NPMVersionRequirement> installRequested, Collection<String> removeRequested,
			IN4JSProject context) {

		SubMonitor subMonitor = SubMonitor.convert(monitor, 2);

		Collection<LibraryChange> requestedChanges = getRequestedChanges(installRequested, removeRequested);
		List<LibraryChange> actualChanges = new LinkedList<>();

		try (Measurement m = N4JSDataCollectors.dcNpmUninstall.getMeasurement("batchUninstall")) {
			// remove
			actualChanges.addAll(npmCli.batchUninstall(subMonitor.split(1), status, requestedChanges));
		}

		try (Measurement m = N4JSDataCollectors.dcNpmInstall.getMeasurement("batchInstall")) {
			// install
			actualChanges.addAll(npmCli.batchInstall(subMonitor.split(1), status, requestedChanges, context));
		}

		return actualChanges;
	}

	private Collection<LibraryChange> getRequestedChanges(Map<String, NPMVersionRequirement> installRequested,
			Collection<String> removeRequested) {

		Collection<LibraryChange> requestedChanges = new LinkedList<>();
		Map<String, Pair<org.eclipse.emf.common.util.URI, ProjectDescription>> installedNpms = new HashMap<>();
		for (Pair<org.eclipse.emf.common.util.URI, ProjectDescription> prjPair : externalLibraryWorkspace
				.getProjectsIncludingUnnecessary()) {

			org.eclipse.emf.common.util.URI location = prjPair.getFirst();
			String nameFromURI = ProjectDescriptionUtils.deriveN4JSProjectNameFromURI(location);
			installedNpms.put(nameFromURI, Tuples.pair(location, prjPair.getSecond()));
		}

		for (Map.Entry<String, NPMVersionRequirement> reqestedNpm : installRequested.entrySet()) {
			String name = reqestedNpm.getKey();
			NPMVersionRequirement requestedVersion = reqestedNpm.getValue();

			if (installedNpms.containsKey(name)) {
				VersionNumber version = installedNpms.get(name).getSecond().getProjectVersion();
				org.eclipse.emf.common.util.URI location = installedNpms.get(name).getFirst();

				String installedVersionString = Strings.emptyIfNull(version.toString());
				if (installedMatchesRequestedVersion(installedVersionString, requestedVersion)) {
					// if a matching version is installed, do not reinstall
					continue;
				}

				// wrong version installed -> update (uninstall, then install)
				requestedChanges.add(new LibraryChange(Uninstall, location, name, installedVersionString));
				String requestedVersionStr = SemverSerializer.serialize(requestedVersion);
				requestedChanges.add(new LibraryChange(Install, location, name, requestedVersionStr));
			} else {
				String requestedVersionStr = SemverSerializer.serialize(requestedVersion);
				requestedChanges.add(new LibraryChange(Install, null, name, requestedVersionStr));
			}
		}

		for (String name : removeRequested) {
			if (installedNpms.containsKey(name)) {
				Pair<org.eclipse.emf.common.util.URI, ProjectDescription> pair = installedNpms.get(name);
				org.eclipse.emf.common.util.URI location = pair.getFirst();
				VersionNumber version = pair.getSecond().getProjectVersion();
				String versionStr = version != null ? version.toString() : "";
				requestedChanges.add(new LibraryChange(Uninstall, location, name, versionStr));
			} else {
				// already removed
			}
		}

		return requestedChanges;
	}

	/**
	 * Returns {@code true} iff the given {@code installedVersionString} matches the {@code requestedVersionString}.
	 * Returns {@code false} otherwise.
	 *
	 * @param installedVersionString
	 *            The version of the already installed package.
	 * @param requestedVersionRequirement
	 *            The requested version requirement in npm-semver format of the same package.
	 */
	public boolean installedMatchesRequestedVersion(String installedVersionString,
			NPMVersionRequirement requestedVersionRequirement) {

		VersionNumber installedVersion = semverHelper.parseVersionNumber(installedVersionString);

		return SemverMatcher.matchesStrict(installedVersion, requestedVersionRequirement);
	}

	/**
	 * Uninstalls the given npm package in a blocking fashion.
	 *
	 * @param packageName
	 *            the name of the package that has to be uninstalled via package manager.
	 * @param monitor
	 *            the monitor for the blocking uninstall process.
	 * @return a status representing the outcome of the uninstall process.
	 */
	public IStatus uninstallNPM(String packageName, IProgressMonitor monitor) {
		return uninstallNPM(Arrays.asList(packageName), monitor);
	}

	/**
	 * Uninstalls the given npm packages in a blocking fashion.
	 *
	 * This method tries to uninstall all packages even if uninstalling for some of them fails. In such cases it will
	 * try to log encountered errors but it will try to proceed for all remaining packages. Details about issues are in
	 * the returned status.
	 *
	 * @param packageNames
	 *            the names of the packages that has to be uninstalled via package manager.
	 * @param monitor
	 *            the monitor for the blocking uninstall process.
	 * @return a status representing the outcome of the uninstall process.
	 */
	public IStatus uninstallNPM(Collection<String> packageNames, IProgressMonitor monitor) {
		return runWithWorkspaceLock(() -> uninstallDependenciesInternal(packageNames, monitor));
	}

	private IStatus uninstallDependenciesInternal(Collection<String> packageNames, IProgressMonitor monitor) {
		String msg = "Uninstalling NPM(s): " + String.join(", ", packageNames);
		MultiStatus status = statusHelper.createMultiStatus(msg);
		logger.logInfo(msg);

		IStatus binaryStatus = checkNPM();
		if (!binaryStatus.isOK()) {
			status.merge(binaryStatus);
			return status;
		}

		try (Measurement mes = N4JSDataCollectors.dcLibMngr.getMeasurement("uninstallDependenciesInternal");) {

			List<LibraryChange> actualChanges = installUninstallNPMs(monitor, status, emptyMap(), packageNames, null);

			try (Measurement m = N4JSDataCollectors.dcIndexSynchronizer.getMeasurement("synchronizeNpms")) {
				indexSynchronizer.synchronizeNpms(monitor, actualChanges);
			}

			return status;

		} finally {
			monitor.done();
		}
	}

	/**
	 * Reloads the external libraries by re-indexing all external projects that not shadowed from projects in the
	 * workspace. Performs a {@code git pull} before the actual refresh process. Returns with an {@link IStatus status}
	 * representing the outcome of the refresh operation.
	 *
	 * @param monitor
	 *            the monitor for the progress.
	 * @return a status representing the outcome of the operation.
	 */
	public IStatus registerAllExternalProjects(IProgressMonitor monitor) {
		return runWithWorkspaceLock(() -> registerAllExternalProjectsInternal(monitor));
	}

	private IStatus registerAllExternalProjectsInternal(IProgressMonitor monitor) {
		checkNotNull(monitor, "monitor");

		MultiStatus refreshStatus = statusHelper.createMultiStatus("Refreshing npm type definitions.");

		Collection<String> packageNames = getAllNpmProjectsMapping().keySet();
		if (packageNames.isEmpty()) {
			return statusHelper.OK();
		}

		SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
		try {
			indexSynchronizer.reindexAllExternalProjects(subMonitor.split(1));

			return refreshStatus;

		} finally {
			subMonitor.done();
		}
	}

	/**
	 *
	 * @param monitor
	 *            the monitor for the progress.
	 * @return a status representing the outcome of the operation.
	 */
	public IStatus registerUnregisteredNpms(IProgressMonitor monitor) {
		return runWithWorkspaceLock(() -> registerUnregisteredNpmsInternal(monitor));
	}

	private IStatus registerUnregisteredNpmsInternal(IProgressMonitor monitor) {
		checkNotNull(monitor, "monitor");
		MultiStatus refreshStatus = statusHelper.createMultiStatus("Register not registered NPM(s).");

		List<N4JSExternalProject> unregisteredProjects = new LinkedList<>();
		for (N4JSExternalProject p : externalLibraryWorkspace.getProjects()) {
			if (!indexSynchronizer.isInIndex(p)) {
				unregisteredProjects.add(p);
			}
		}

		indexSynchronizer.synchronizeNpms(monitor);

		Collection<String> packageNames = getAllNpmProjectsMapping().keySet();
		if (packageNames.isEmpty()) {
			return statusHelper.OK();
		}

		SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
		try {
			indexSynchronizer.reindexAllExternalProjects(subMonitor.split(1));

			return refreshStatus;

		} finally {
			subMonitor.done();
		}
	}

	/**
	 * Cleans npm cache. Please note:
	 * <p>
	 * <i>"It should never be necessary to clear the cache for any reason other than reclaiming disk space"</i> (see
	 * <a href="https://docs.npmjs.com/cli/cache}">NPM Doc</a>)
	 *
	 * @param monitor
	 *            the monitor for the progress.
	 * @return a status representing the outcome of the operation.
	 */
	public IStatus cleanCache(IProgressMonitor monitor) {
		return runWithWorkspaceLock(() -> npmCli.cleanCacheInternal(monitor));
	}

	/**
	 * Checks the npm binary.
	 */
	private IStatus checkNPM() {
		NpmBinary npmBinary = npmBinaryProvider.get();
		IStatus npmBinaryStatus = npmBinary.validate();
		if (!npmBinaryStatus.isOK()) {
			return statusHelper.createError("npm binary invalid",
					new IllegalBinaryStateException(npmBinary, npmBinaryStatus));
		}
		return statusHelper.OK();
	}

	/**
	 * A map of project (npm package) names to project location mappings.
	 */
	private Map<String, URI> getAllNpmProjectsMapping() {
		Map<String, URI> mappings = newHashMap();

		for (IProject project : externalLibraryWorkspace.getProjects()) {
			if (project.isAccessible() && project instanceof ExternalProject) {
				URI location = ((ExternalProject) project).getExternalResource().toURI();
				mappings.put(project.getName(), location);
			}
		}

		return ImmutableMap.copyOf(mappings);
	}

	private IStatus runWithWorkspaceLock(Supplier<IStatus> operation) {
		if (Platform.isRunning()) {
			ISchedulingRule rule = ResourcesPlugin.getWorkspace().getRoot();
			try {
				Job.getJobManager().beginRule(rule, null);
				return operation.get();
			} catch (final OperationCanceledException e) {
				LOGGER.info("User cancelled operation.");
				return statusHelper.createCancel("User cancelled operation.");
			} finally {
				Job.getJobManager().endRule(rule);
			}
		} else {
			// locking not available/required in headless case
			return operation.get();
		}
	}
}
