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
package org.eclipse.n4js.cli.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.n4js.cli.N4jscFactory;
import org.eclipse.n4js.cli.N4jscMain;
import org.eclipse.n4js.cli.N4jscOptions;
import org.eclipse.n4js.cli.compiler.N4jscCompiler;
import org.eclipse.n4js.ide.server.N4JSWorkspaceManager;
import org.eclipse.n4js.projectModel.names.N4JSProjectName;
import org.eclipse.n4js.utils.io.FileUtils;
import org.eclipse.xtext.workspace.IProjectConfig;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.inject.Injector;

/**
 * Subclass this class for test cases that compile n4js code and run js code
 */
@SuppressWarnings("restriction")
public class AbstractCliCompileTest extends AbstractCliTest<N4jscOptions> {
	/** name of workspace sub-folder (inside target folder) */
	private static final String WSP = "wsp";
	/** see {@link N4CliHelper#PACKAGES} */
	protected static final String PACKAGES = N4CliHelper.PACKAGES;
	/** name of folder containing the test resources */
	protected static final String FIXTURE = "probands";
	/** name of test data set for launching testers from the command line */
	protected static final String TEST_DATA_SET__TESTERS = "testers";
	/** name of test data set for npm scopes */
	protected static final String TEST_DATA_SET__NPM_SCOPES = "npmScopes";

	/** Specifies how n4jsc is executed */
	static public enum N4jscVariant {
		/** N4jsc is called using a function call to {@link N4jscMain#main(String[])} */
		inprocess,
		/** N4jsc is called using the {@code n4jsc.jar} and a Java {@link ProcessBuilder} */
		exprocess
	}

	final private N4jscVariant variant;
	final private Map<String, String> environment = new HashMap<>();

	/** Constructor */
	public AbstractCliCompileTest() {
		this(N4jscVariant.inprocess);
	}

	/** Constructor */
	public AbstractCliCompileTest(N4jscVariant variant) {
		this.variant = variant;
	}

	@Override
	public CliCompileResult createResult() {
		CliCompileResult result = null;

		switch (variant) {
		case inprocess:
			result = new CliCompileResult();
			break;
		case exprocess:
			result = new CliCompileProcessResult();
			break;
		default:
			throw new IllegalStateException();
		}

		return result;
	}

	@Override
	public void doN4jsc(N4jscOptions options, CliCompileResult result) throws Exception {
		switch (variant) {
		case inprocess:
			callN4jscInprocess(options, result);
			return;
		case exprocess:
			callN4jscExprocess(options, result);
			return;
		default:
			throw new IllegalStateException();
		}
	}

	private void callN4jscInprocess(N4jscOptions options, CliCompileResult result) throws Exception {
		N4jscCompiler.start(options);

		// save transpiled files
		File workspaceRoot = options.getSrcFiles().get(0);
		result.transpiledFiles = GeneratedJSFilesCounter.getTranspiledFiles(workspaceRoot.toPath());

		// save projects
		Injector injector = N4jscFactory.getOrCreateInjector();
		N4JSWorkspaceManager workspaceManager = injector.getInstance(N4JSWorkspaceManager.class);
		Set<? extends IProjectConfig> projects = workspaceManager.getWorkspaceConfig().getProjects();
		Map<String, String> projectMap = new TreeMap<>();
		for (IProjectConfig pConfig : projects) {
			Path projectPath = Path.of(pConfig.getPath().toFileString());
			Path relativeProjectPath = workspaceRoot.toPath().relativize(projectPath);
			projectMap.put(pConfig.getName(), relativeProjectPath.toString());
		}
		result.projects = projectMap;
	}

	private void callN4jscExprocess(N4jscOptions options, CliCompileResult cliResult) throws Exception {
		Injector injector = N4jscFactory.getOrCreateInjector();
		TestProcessExecuter tpExecuter = new TestProcessExecuter(injector);
		List<File> srcFiles = options.getSrcFiles();
		File fileArg = srcFiles.isEmpty() ? new File(".") : srcFiles.get(0);
		ProcessResult n4jscResult = tpExecuter.n4jscRun(fileArg.toPath(), environment, options);

		cliResult.command = n4jscResult.getCommand();
		cliResult.exception = n4jscResult.getException();
		cliResult.exitCode = n4jscResult.getExitCode();
		cliResult.stdOut = n4jscResult.getStdOut();
		cliResult.errOut = n4jscResult.getErrOut();

		// save transpiled files
		cliResult.transpiledFiles = GeneratedJSFilesCounter.getTranspiledFiles(fileArg.toPath());
	}

	/**
	 * Sets the given name and value pair to the environment.
	 * <p>
	 * <b>Note:</b> Only active when used in {@link N4jscVariant#exprocess }
	 */
	public void setEnvironmentVariable(String name, String value) {
		this.environment.put(name, value);
	}

	/** see {@link TestProcessExecuter#runNodejs(Path, Path, String[])} */
	public ProcessResult runNodejs(Path workingDir, Path runFile, String... options) {
		Injector injector = N4jscFactory.getOrCreateInjector();
		TestProcessExecuter tpExecuter = new TestProcessExecuter(injector);
		return tpExecuter.runNodejs(workingDir, runFile, options);
	}

	/** see {@link TestProcessExecuter#npmRun(Path, String[])} */
	public ProcessResult npmInstall(Path workingDir, String... options) {
		Injector injector = N4jscFactory.getOrCreateInjector();
		TestProcessExecuter tpExecuter = new TestProcessExecuter(injector);
		String[] installOptions = Lists.asList("install", options).toArray(String[]::new);
		return tpExecuter.npmRun(workingDir, installOptions);
	}

	/** see {@link TestProcessExecuter#npmRun(Path, String[])} */
	public ProcessResult npmList(Path workingDir, String... options) {
		Injector injector = N4jscFactory.getOrCreateInjector();
		TestProcessExecuter tpExecuter = new TestProcessExecuter(injector);
		String[] listOptions = Lists.asList("list", options).toArray(String[]::new);
		return tpExecuter.npmRun(workingDir, listOptions);
	}

	/** see {@link TestProcessExecuter#yarnRun(Path, String[])} */
	public ProcessResult yarnInstall(Path workingDir, String... options) {
		Injector injector = N4jscFactory.getOrCreateInjector();
		TestProcessExecuter tpExecuter = new TestProcessExecuter(injector);
		String[] installOptions = Lists.asList("install", options).toArray(String[]::new);
		return tpExecuter.yarnRun(workingDir, installOptions);
	}

	/**
	 * Copy a fresh fixture to the workspace area. Deleting old leftovers from former tests.
	 *
	 * @param createYarnWorkspace
	 *            see {@link N4CliHelper#setupWorkspace(Path, Path, Predicate, boolean)}.
	 *
	 * @returns file indicating the relative path to the copied data set
	 */
	protected static File setupWorkspace(String testDataSet, boolean createYarnWorkspace) throws IOException {
		return setupWorkspace(testDataSet, Predicates.alwaysFalse(), createYarnWorkspace);
	}

	/**
	 * Copy a fresh fixture to the workspace area. Deleting old leftovers from former tests.
	 *
	 * @param createYarnWorkspace
	 *            see {@link N4CliHelper#setupWorkspace(Path, Path, Predicate, boolean)}.
	 *
	 * @returns file indicating the relative path to the copied data set
	 */
	protected static File setupWorkspace(String testDataRoot, String testDataSet, boolean createYarnWorkspace)
			throws IOException {
		return setupWorkspace(testDataRoot, testDataSet, Predicates.alwaysFalse(), createYarnWorkspace);
	}

	/**
	 * Same as {@link #setupWorkspace(String, Predicate, boolean)}, but accepts one or more names of libraries to
	 * install instead of a predicate.
	 */
	protected static File setupWorkspace(String testDataSet, boolean createYarnWorkspace, N4JSProjectName... libNames)
			throws IOException {
		return setupWorkspace(testDataSet, libName -> Arrays.asList(libNames).contains(libName), createYarnWorkspace);
	}

	/**
	 * Copy a fresh fixture to the workspace area. Deleting old leftovers from former tests. Also includes all N4JS
	 * libraries from the {@code n4js} Git repository which name provides {@code true} value for the given predicate.
	 *
	 * @param createYarnWorkspace
	 *            see {@link N4CliHelper#setupWorkspace(Path, Path, Predicate, boolean)}.
	 *
	 * @returns file indicating the relative path to the copied data set
	 */
	protected static File setupWorkspace(String testDataSet, Predicate<N4JSProjectName> n4jsLibrariesPredicate,
			boolean createYarnWorkspace) throws IOException {
		return setupWorkspace(FIXTURE, testDataSet, n4jsLibrariesPredicate, createYarnWorkspace);
	}

	private static File setupWorkspace(String testDataRoot, String testDataSet,
			Predicate<N4JSProjectName> n4jsLibrariesPredicate, boolean createYarnWorkspace) throws IOException {
		Path fixture = new File(testDataRoot, testDataSet).toPath();
		Path root = FileUtils.createTempDirectory(testDataRoot + "_" + testDataSet + "_");
		root = root.toFile().getCanonicalFile().toPath();
		Path wsp = root.resolve(WSP);
		N4CliHelper.setupWorkspace(fixture, wsp, n4jsLibrariesPredicate, createYarnWorkspace);
		return wsp.toFile();
	}
}
