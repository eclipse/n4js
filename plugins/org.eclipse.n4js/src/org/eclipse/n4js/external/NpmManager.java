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
import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.difference;
import static org.eclipse.core.runtime.Status.OK_STATUS;
import static org.eclipse.n4js.projectModel.IN4JSProject.N4MF_MANIFEST;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.n4js.binaries.BinaryCommandFactory;
import org.eclipse.n4js.binaries.IllegalBinaryStateException;
import org.eclipse.n4js.binaries.nodejs.NpmBinary;
import org.eclipse.n4js.external.ExternalLibraryWorkspace.RegisterResult;
import org.eclipse.n4js.external.libraries.PackageJson;
import org.eclipse.n4js.external.libraries.ShippedCodeAccess;
import org.eclipse.n4js.smith.ClosableMeasurement;
import org.eclipse.n4js.smith.DataCollector;
import org.eclipse.n4js.smith.DataCollectors;
import org.eclipse.n4js.utils.ProcessExecutionCommandStatus;
import org.eclipse.n4js.utils.StatusHelper;
import org.eclipse.n4js.utils.git.GitUtils;
import org.eclipse.n4js.utils.resources.ExternalProject;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Class for installing npm dependencies into the external library.
 */
@Singleton
public class NpmManager {

	private static final String NO_VERSION = "";

	private static final String LINE_DOUBLE = "================================================================";

	private static final String LINE_SINGLE = "----------------------------------------------------------------";

	private static final DataCollector dcLibMngr = DataCollectors.INSTANCE.getOrCreateDataCollector("Library Manager");

	@Inject
	private BinaryCommandFactory commandFactory;

	@Inject
	private NpmPackageToProjectAdapter npmPackageToProjectAdapter;

	@Inject
	private ProcessExecutionCommandStatus executor;

	@Inject
	private TargetPlatformInstallLocationProvider locationProvider;

	@Inject
	private ExternalLibraryWorkspace externalLibraryWorkspace;

	@Inject
	private ExternalProjectsCollector collector;

	@Inject
	private StatusHelper statusHelper;

	@Inject
	private Provider<NpmBinary> npmBinaryProvider;

	@Inject
	private NpmLogger logger;

	/**
	 * Installs the given npm package in a blocking fashion.
	 *
	 * @param packageName
	 *            the name of the package that has to be installed via package manager.
	 * @param monitor
	 *            the monitor for the blocking install process.
	 * @return a status representing the outcome of the install process.
	 */
	public IStatus installDependency(final String packageName, IProgressMonitor monitor) {
		return installDependency(packageName, NO_VERSION, monitor);
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
	public IStatus installDependency(final String packageName, final String packageVersion, IProgressMonitor monitor) {
		return installDependencies(Collections.singletonMap(packageName, packageVersion), monitor);
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
	public IStatus installDependencies(final Collection<String> unversionedPackages, final IProgressMonitor monitor) {

		Map<String, String> versionedPackages = unversionedPackages.stream()
				.collect(Collectors.toMap((String name) -> name, (String name) -> NO_VERSION));
		return installDependencies(versionedPackages, monitor);
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
	 * @return a status representing the outcome of the install process.
	 */
	public IStatus installDependencies(final Map<String, String> versionedNPMs, final IProgressMonitor monitor) {
		return installDependencies(versionedNPMs, monitor, true);
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
	 * @param triggerCleanbuild
	 *            if true, a clean build is triggered on all affected workspace projects.
	 * @return a status representing the outcome of the install process.
	 */
	public IStatus installDependencies(final Map<String, String> versionedNPMs, final IProgressMonitor monitor,
			boolean triggerCleanbuild) {
		return runWithWorkspaceLock(() -> installDependenciesInternal(versionedNPMs, monitor, triggerCleanbuild));
	}

	private IStatus installDependenciesInternal(final Map<String, String> versionedNPMs, final IProgressMonitor monitor,
			boolean triggerCleanbuild) {

		MultiStatus status = statusHelper.createMultiStatus("Status of installing multiple npm dependencies.");

		IStatus binaryStatus = checkNPM();
		if (!binaryStatus.isOK()) {
			status.merge(binaryStatus);
			return status;
		}

		Set<String> requestedNPMs = versionedNPMs.keySet();

		try (ClosableMeasurement mes = dcLibMngr.getClosableMeasurement("installDependenciesInternal");) {

			Set<String> oldNPMs = getOldNPMs(monitor, requestedNPMs);

			installUninstallNPMs(versionedNPMs, monitor, status, requestedNPMs, oldNPMs);

			Pair<Collection<String>, Iterable<java.net.URI>> changedDeps = getChangedDependencies(monitor, oldNPMs);
			Collection<String> addedDependencies = changedDeps.getFirst();
			Iterable<java.net.URI> toBeDeleted = changedDeps.getSecond();

			Collection<File> adaptedPackages = adaptNPMPackages(monitor, status, addedDependencies);

			cleanBuildDependencies(monitor, status, toBeDeleted, adaptedPackages, triggerCleanbuild);

			return status;

		} finally {
			monitor.done();
		}
	}

	private Set<String> getOldNPMs(final IProgressMonitor monitor, final Set<String> requestedNPMs) {
		logger.logInfo("Installing npm packages: " + String.join(", ", requestedNPMs) + ". NPM output:");

		monitor.beginTask("Installing npm packages...", 10);

		URI targetPlatformNodeModulesLocation = locationProvider.getTargetPlatformNodeModulesLocation();
		final Set<String> oldNPMs = from(externalLibraryWorkspace.getProjectsIn(targetPlatformNodeModulesLocation))
				.transform(p -> p.getName()).toSet();

		monitor.worked(1); // Intentionally cheating for better user experience.
		return oldNPMs;
	}

	private void installUninstallNPMs(final Map<String, String> versionedNPMs, final IProgressMonitor monitor,
			final MultiStatus status, final Set<String> requestedNPMs, final Set<String> oldNPMs) {

		monitor.setTaskName("Installing packages... [step 1 of 4]");
		// calculate already installed to skip
		final Set<String> npmNamesToInstall = difference(requestedNPMs, oldNPMs);
		final Set<String> npmsToInstall = versionedNPMs.entrySet().stream()
				// skip already installed
				.filter(e -> npmNamesToInstall.contains(e.getKey()))
				// [name, @">=1.0.0 <2.0.0"] to [name@">=1.0.0 <2.0.0"]
				.map(e -> e.getKey() + Strings.emptyIfNull(e.getValue()))
				.collect(Collectors.toSet());

		IStatus installStatus = batchInstallUninstall(monitor, npmsToInstall, true);

		// log possible errors, but proceed with the process
		// assume that at least some packages were installed correctly and can be adapted
		if (!installStatus.isOK()) {
			logger.logInfo("Some packages could not be installed due to errors, see log for details.");
			status.merge(installStatus);
		}
		monitor.worked(2);
	}

	private Pair<Collection<String>, Iterable<java.net.URI>> getChangedDependencies(final IProgressMonitor monitor,
			Set<String> oldNPMs) {

		monitor.setTaskName("Calculating dependency changes... [step 2 of 4]");

		externalLibraryWorkspace.updateState();
		URI targetPlatformNodeModulesLocation = locationProvider.getTargetPlatformNodeModulesLocation();

		Map<String, String> afterDependencies = locationProvider.getTargetPlatformContent().dependencies;
		if (null == afterDependencies) {
			afterDependencies = newHashMap();
		}
		final Set<String> newDependencies = new HashSet<>(afterDependencies.keySet());

		Set<String> newNpmProjectNames = new HashSet<>();
		Iterable<N4JSExternalProject> newNPMs = externalLibraryWorkspace
				.getProjectsIn(targetPlatformNodeModulesLocation);
		for (IProject newNPM : newNPMs) {
			newNpmProjectNames.add(newNPM.getName());
		}

		Set<String> overwrittenShippedLibNames = getOverwrittenShippedLibs(newNpmProjectNames);
		newDependencies.addAll(overwrittenShippedLibNames);

		final Collection<String> addedDependencies = difference(newDependencies, oldNPMs);
		final Collection<String> deletedDependencies = difference(oldNPMs, newDependencies);
		final File nodeModulesFolder = new File(targetPlatformNodeModulesLocation);
		final Iterable<java.net.URI> toBeDeleted = from(deletedDependencies)
				.transform(name -> new File(nodeModulesFolder, name).toURI());
		monitor.worked(1);

		Pair<Collection<String>, Iterable<java.net.URI>> changedDeps = Tuples.pair(addedDependencies, toBeDeleted);

		return changedDeps;
	}

	private Collection<File> adaptNPMPackages(final IProgressMonitor monitor, final MultiStatus status,
			final Collection<String> addedDependencies) {

		monitor.setTaskName("Adapting npm package structure to N4JS project structure... [step 3 of 4]");
		Pair<IStatus, Collection<File>> result = npmPackageToProjectAdapter.adaptPackages(addedDependencies);
		IStatus adaptionStatus = result.getFirst();

		// log possible errors, but proceed with the process
		// assume that at least some packages were installed correctly and can be adapted
		if (!adaptionStatus.isOK()) {
			logger.logError(adaptionStatus);
			status.merge(adaptionStatus);
		}

		Collection<File> adaptedPackages = result.getSecond();
		monitor.worked(2);
		return adaptedPackages;
	}

	private void cleanBuildDependencies(final IProgressMonitor monitor, final MultiStatus status,
			final Iterable<java.net.URI> toBeDeleted, final Collection<File> adaptedPackages,
			final boolean triggerCleanbuild) {

		monitor.setTaskName("Registering new projects... [step 4 of 4]");
		// nothing to do in the headless case. TODO inject logic instead?
		if (Platform.isRunning()) {
			Iterable<java.net.URI> toBeUpdated = from(adaptedPackages).transform(file -> file.toURI());
			NpmProjectAdaptionResult adaptionResult = NpmProjectAdaptionResult.newOkResult(toBeUpdated, toBeDeleted);

			RegisterResult rr = externalLibraryWorkspace.registerProjects(adaptionResult, monitor, triggerCleanbuild);
			printRegisterResults(rr);
		}

		if (!status.isOK()) {
			logger.logInfo("There were errors during installation, see logs for details.");
		}
	}

	private void printRegisterResults(RegisterResult rr) {
		if (!rr.externalProjectsCleaned.isEmpty()) {
			SortedSet<String> prjNames = getProjectNames(rr.externalProjectsCleaned);
			logger.logInfo("External libraries cleaned: " + String.join(", ", prjNames));
		}

		if (!rr.externalProjectsBuilt.isEmpty()) {
			SortedSet<String> prjNames = getProjectNames(rr.externalProjectsBuilt);
			logger.logInfo("External libraries built: " + String.join(", ", prjNames));
		}

		if (!rr.workspaceProjectsScheduled.isEmpty()) {
			SortedSet<String> prjNames = getProjectNames(rr.workspaceProjectsScheduled);
			logger.logInfo("Workspace projects scheduled: " + String.join(", ", prjNames));
		}
	}

	private SortedSet<String> getProjectNames(Collection<? extends IProject> projects) {
		SortedSet<String> prjNames = new TreeSet<>();
		prjNames.addAll(projects.stream().map(p -> p.getName()).collect(Collectors.toSet()));
		return prjNames;
	}

	private Set<String> getOverwrittenShippedLibs(Set<String> newNpmProjectNames) {
		Set<String> overwrittenShippedLibNames = new HashSet<>();
		Iterable<String> ps = ShippedCodeAccess.getAllShippedPaths();
		for (String shippedLibPath : ps) {
			URI uri = new File(shippedLibPath).toURI();
			Iterable<N4JSExternalProject> slProjects = externalLibraryWorkspace.getProjectsIn(uri);

			for (IProject slProject : slProjects) {
				String slpName = slProject.getName();
				if (newNpmProjectNames.contains(slpName)) {
					overwrittenShippedLibNames.add(slpName);
				}
			}
		}
		return overwrittenShippedLibNames;
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
	public IStatus uninstallDependency(final String packageName, final IProgressMonitor monitor) {
		return uninstallDependencies(Arrays.asList(packageName), monitor);
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
	public IStatus uninstallDependencies(Collection<String> packageNames, final IProgressMonitor monitor) {
		return runWithWorkspaceLock(() -> uninstallDependenciesInternal(packageNames, monitor));
	}

	private IStatus uninstallDependenciesInternal(Collection<String> packageNames, final IProgressMonitor monitor) {
		MultiStatus status = statusHelper.createMultiStatus("Status of uninstalling multiple npm dependencies.");

		IStatus binaryStatus = checkNPM();
		if (!binaryStatus.isOK()) {
			status.merge(binaryStatus);
			return status;
		}

		Set<String> requestedPackages = new HashSet<>(packageNames);
		try {

			logger.logInfo("Uninstalling npm packages: " + String.join(", ", requestedPackages) + ". NPM output:");

			monitor.beginTask("Uninstalling npm packages...", 10);

			URI npmLocation = locationProvider.getTargetPlatformNodeModulesLocation();
			Iterable<N4JSExternalProject> externalProjects = externalLibraryWorkspace.getProjectsIn(npmLocation);
			Multimap<N4JSExternalProject, IProject> beforeExternalsWithDependees = collector
					.getWSProjectDependents(externalProjects);
			Multimap<N4JSExternalProject, N4JSExternalProject> beforeExtExternalsWithDependees = collector
					.getExtProjectDependents(externalProjects);

			monitor.worked(1); // Intentionally cheating for better user experience.
			monitor.setTaskName("Uninstalling packages... [step 1 of 4]");

			URI targetPlatformNodeModulesLocation = locationProvider.getTargetPlatformNodeModulesLocation();
			File nodeModulesFolder = new File(targetPlatformNodeModulesLocation);
			Iterable<java.net.URI> toBeDeleted = from(packageNames)
					.transform(name -> new File(nodeModulesFolder, name).toURI());
			// Iterable<java.net.URI> toBeDeleted = new LinkedList<>();

			Iterable<java.net.URI> toBeUpdated = new LinkedList<>();
			NpmProjectAdaptionResult adaptionResult = NpmProjectAdaptionResult.newOkResult(toBeUpdated, toBeDeleted);
			RegisterResult rr = externalLibraryWorkspace.registerProjects(adaptionResult, monitor, true);
			printRegisterResults(rr);

			IStatus installStatus = batchInstallUninstall(monitor, requestedPackages, false);

			externalLibraryWorkspace.updateState();

			// log possible errors, but proceed with the process
			// assume that at least some packages were installed correctly and can be adapted
			if (!installStatus.isOK()) {
				logger.logInfo("Some packages could not be installed due to errors, see log for details.");
				status.merge(installStatus);
			}

			monitor.worked(2);
			monitor.setTaskName("Calculating dependency changes... [step 2 of 4]");

			externalProjects = externalLibraryWorkspace.getProjectsIn(npmLocation);
			Multimap<N4JSExternalProject, IProject> afterExternalsWithDependees = collector
					.getWSProjectDependents(externalProjects);
			Multimap<N4JSExternalProject, N4JSExternalProject> afterExtExternalsWithDependees = collector
					.getExtProjectDependents(externalProjects);

			Set<IProject> affectedExtEclipseProjects = new HashSet<>();
			for (N4JSExternalProject p : beforeExtExternalsWithDependees.keySet()) {
				if (!afterExtExternalsWithDependees.containsKey(p)) {
					// external project p was uninstalled
					Collection<N4JSExternalProject> collection = beforeExtExternalsWithDependees.get(p);
					if (collection != null) {
						// external project p had dependent workspace projects
						affectedExtEclipseProjects.addAll(collection);
					}
				}
			}

			monitor.worked(1);
			monitor.setTaskName("Calculating dependency changes... [3 of 4]");

			Set<IProject> affectedEclipseProjects = new HashSet<>();
			for (N4JSExternalProject p : beforeExternalsWithDependees.keySet()) {
				if (!afterExternalsWithDependees.containsKey(p)) {
					// external project p was uninstalled
					Collection<IProject> collection = beforeExternalsWithDependees.get(p);
					if (collection != null) {
						// external project p had dependent workspace projects
						affectedEclipseProjects.addAll(collection);
					}
				}
			}

			monitor.worked(2);
			monitor.setTaskName("Scheduling build of projects... [4 of 4]");

			// scheduler.scheduleBuildIfNecessary(affectedEclipseProjects);
			// logger.logInfo("Scheduling re-builds for the following affected projects:");
			// for (IProject affPrj : affectedEclipseProjects) {
			// logger.logInfo(" - " + affPrj.getName());
			// }

			if (!status.isOK()) {
				logger.logInfo("There were errors during installation, see logs for details.");
			}
			return OK_STATUS;

		} finally {
			monitor.done();
		}
	}

	/**
	 * Refreshes the type definitions for all installed, available {@code npm} packages in the external workspace.
	 * Performs a {@code git pull} before the actual refresh process. Returns with an {@link IStatus status}
	 * representing the outcome of the refresh operation.
	 *
	 * @param monitor
	 *            the monitor for the progress.
	 * @return a status representing the outcome of the operation.
	 */
	public IStatus refreshInstalledNpmPackages(final IProgressMonitor monitor) {
		return runWithWorkspaceLock(() -> refreshInstalledNpmPackagesInternal(monitor));
	}

	private IStatus refreshInstalledNpmPackagesInternal(final IProgressMonitor monitor) {
		checkNotNull(monitor, "monitor");

		final Collection<String> packageNames = getAllNpmProjectsMapping().keySet();

		if (packageNames.isEmpty()) {
			return statusHelper.OK();
		}

		final SubMonitor subMonitor = SubMonitor.convert(monitor, packageNames.size() + 1);
		try {

			logger.logInfo(LINE_DOUBLE);
			logger.logInfo("Refreshing installed npm packages.");
			subMonitor.setTaskName("Refreshing cache for type definitions files...");

			performGitPull(subMonitor.newChild(1, SubMonitor.SUPPRESS_ALL_LABELS));

			final MultiStatus refreshStatus = statusHelper
					.createMultiStatus("Status of refreshing definitions for npm packages.");
			for (final String packageName : packageNames) {
				final IStatus status = refreshInstalledNpmPackage(packageName, false, subMonitor.newChild(1));
				if (!status.isOK()) {
					logger.logError(status);
					refreshStatus.merge(status);
				}
			}
			logger.logInfo("Installed npm packages have been refreshed.");
			logger.logInfo(LINE_DOUBLE);
			return refreshStatus;

		} finally {
			subMonitor.done();
		}
	}

	/**
	 * Refreshes the type definitions for all installed, available {@code npm} packages in the external workspace.
	 * Performs a {@code git pull} before the actual refresh process. Returns with an {@link IStatus status}
	 * representing the outcome of the refresh operation.
	 *
	 * @param monitor
	 *            the monitor for the progress.
	 * @return a status representing the outcome of the operation.
	 */
	public IStatus cleanCache(final IProgressMonitor monitor) {
		return runWithWorkspaceLock(() -> cleanCacheInternal(monitor));
	}

	private IStatus cleanCacheInternal(final IProgressMonitor monitor) {
		checkNotNull(monitor, "monitor");

		final SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
		try {

			subMonitor.setTaskName("Cleaning npm cache");

			performGitPull(subMonitor.newChild(1, SubMonitor.SUPPRESS_ALL_LABELS));
			final File targetInstallLocation = new File(locationProvider.getTargetPlatformInstallLocation());
			return clean(targetInstallLocation);

		} finally {
			subMonitor.done();
		}
	}

	/** Simple validation if the package name is not null or empty */
	public boolean invalidPackageName(final String packageName) {
		return packageName == null || packageName.trim().isEmpty();
	}

	/**
	 * Batch install / uninstall of npm packages based on provided names. Provided boolean flag switches between install
	 * and uninstall operations. Method does not return early, it will try to process all packages, even if there are
	 * errors during processing of a specific package. All encountered errors are logged and added as children to the
	 * returned multi status.
	 *
	 * @param monitor
	 *            used to track progress
	 * @param packageNames
	 *            names of the packages to install or uninstall
	 * @param install
	 *            used to switch between install and uninstall operations
	 * @return multi status with children for each issue during processing
	 */
	private MultiStatus batchInstallUninstall(IProgressMonitor monitor, final Collection<String> packageNames,
			final boolean install) {

		final MultiStatus batchStatus = statusHelper
				.createMultiStatus("Status of " + (install ? "installing" : "uninstalling") + " npm packages.");

		final int packagesCount = packageNames.size();
		final SubMonitor subMonitor = SubMonitor.convert(monitor, packagesCount + 1);
		final File installPath = new File(locationProvider.getTargetPlatformInstallLocation());

		final AtomicInteger index = new AtomicInteger(0);
		packageNames.forEach(packageName -> {
			String msg = (install ? "Fetching '" : "Removing '") + packageName + "' package... [package "
					+ index.incrementAndGet() + " of " + packagesCount + "]";
			// logger.logInfo(msg);
			subMonitor.setTaskName(msg);
			subMonitor.worked(1);

			// switch between install and uninstall
			IStatus packageProcessingStatus = install
					? install(packageName, installPath)
					: uninstall(packageName, installPath);

			if (packageProcessingStatus.isOK()) {
				msg = "Package '" + packageName + "' has been successfully " + (install ? "fetched." : "removed");
				// logger.logInfo(msg);
			} else {
				logger.logError(packageProcessingStatus);
				batchStatus.merge(packageProcessingStatus);
			}
		});

		return batchStatus;
	}

	private IStatus refreshInstalledNpmPackage(final String packageName, final boolean performGitPull,
			final IProgressMonitor monitor) {

		final SubMonitor progress = SubMonitor.convert(monitor, 2);

		logger.logInfo(LINE_SINGLE);
		final String taskName = "Refreshing type definitions for '" + packageName + "' npm package...";
		logger.logInfo(taskName);
		progress.setTaskName(taskName);

		try {

			final URI uri = getAllNpmProjectsMapping().get(packageName);
			if (null == uri) {
				// No project with the given package name. Nothing to do.
				return statusHelper.OK();
			}

			final File definitionsFolder = npmPackageToProjectAdapter.getNpmsTypeDefinitionsFolder(performGitPull);
			if (null == definitionsFolder) {
				// No definitions are available at the moment.
				return statusHelper.OK();
			}

			if (performGitPull) {
				performGitPull(progress.newChild(1));
			}

			final File packageRoot = new File(uri);
			final PackageJson packageJson = npmPackageToProjectAdapter.getPackageJson(packageRoot);
			final File manifest = new File(packageRoot, N4MF_MANIFEST);
			if (!manifest.isFile()) {
				String message = "Cannot locate N4JS manifest for '" + packageName + "' package at '" + manifest + "'.";
				final IStatus error = statusHelper.createError(message);
				logger.logError(error);
			}

			final IStatus status = npmPackageToProjectAdapter.addTypeDefinitions(
					packageRoot,
					packageJson,
					manifest,
					definitionsFolder);

			if (status.isOK()) {
				logger.logInfo("Successfully refreshed the type definitions for '" + packageName + "' npm package.");
				logger.logInfo(LINE_SINGLE);
			} else {
				logger.logError(status);
			}

			return status;

		} catch (final IOException e) {
			final String message = "Error while refreshing the definitions for '" + packageName + "' npm package.";
			final IStatus error = statusHelper.createError(message, e);
			logger.logError(error);
			return error;
		} finally {
			monitor.done();
		}
	}

	/**
	 * Checks the npm binary.
	 */
	private IStatus checkNPM() {
		final NpmBinary npmBinary = npmBinaryProvider.get();
		final IStatus npmBinaryStatus = npmBinary.validate();
		if (!npmBinaryStatus.isOK()) {
			return statusHelper.createError("npm binary invalid",
					new IllegalBinaryStateException(npmBinary, npmBinaryStatus));
		}
		return statusHelper.OK();
	}

	/**
	 * Installs package with given name at the given path. Updates dependencies in the package.json of that location. If
	 * there is no package.json at that location npm errors will be logged to the error log. In that case npm usual
	 * still installs requested dependency (if possible).
	 *
	 * @param packageName
	 *            to be installed
	 * @param installPath
	 *            path where package is supposed to be installed
	 */
	private IStatus install(final String packageName, final File installPath) {
		if (invalidPackageName(packageName)) {
			return statusHelper.createError("Malformed npm package name: '" + packageName + "'.");
		}
		return executor.execute(
				() -> commandFactory.createInstallPackageCommand(installPath, packageName, true),
				"Error while installing npm package.");
	}

	/**
	 * Uninstalls package under given name at the given path. Updates dependencies in the package.json of that location.
	 * If there is no package.json at that location npm errors will be logged to the error log. In that case npm usual
	 * still uninstalls requested dependency (if possible).
	 *
	 * @param packageName
	 *            to be uninstalled
	 * @param uninstallPath
	 *            path where package is supposed to be uninstalled
	 */
	private IStatus uninstall(final String packageName, final File uninstallPath) {
		if (invalidPackageName(packageName)) {
			return statusHelper.createError("Malformed npm package name: '" + packageName + "'.");
		}
		return executor.execute(
				() -> commandFactory.createUninstallPackageCommand(uninstallPath, packageName, true),
				"Error while uninstalling npm package.");
	}

	/**
	 * Cleans npm cache. Note that normally this has global side effects, i.e. it will delete npm cache for the user
	 * settings. While provided path does not have impact on effects of clean, it is used as working directory for
	 * invoking the command.
	 *
	 * @param cleanPath
	 *            to be uninstalled
	 */
	private IStatus clean(final File cleanPath) {
		return executor.execute(
				() -> commandFactory.createCacheCleanCommand(cleanPath),
				"Error while cleaning npm cache.");
	}

	/**
	 * A map of project (npm package) names to project location mappings.
	 */
	private Map<String, URI> getAllNpmProjectsMapping() {
		final URI nodeModulesLocation = locationProvider.getTargetPlatformNodeModulesLocation();
		final Map<String, URI> mappings = newHashMap();

		// Intentionally might include projects that are already in the workspace
		for (final IProject project : externalLibraryWorkspace.getProjectsIn(nodeModulesLocation)) {
			if (project.isAccessible() && project instanceof ExternalProject) {
				final URI location = ((ExternalProject) project).getExternalResource().toURI();
				mappings.put(project.getName(), location);
			}
		}

		return ImmutableMap.copyOf(mappings);
	}

	private void performGitPull(final IProgressMonitor monitor) {
		final URI repositoryLocation = locationProvider.getTargetPlatformLocalGitRepositoryLocation();
		GitUtils.pull(new File(repositoryLocation).toPath(), monitor);
	}

	private static <T> T runWithWorkspaceLock(Supplier<T> operation) {
		if (Platform.isRunning()) {
			final ISchedulingRule rule = ResourcesPlugin.getWorkspace().getRoot();
			try {
				Job.getJobManager().beginRule(rule, null);
				return operation.get();
			} finally {
				Job.getJobManager().endRule(rule);
			}
		} else {
			// locking not available/required in headless case
			return operation.get();
		}
	}

}
