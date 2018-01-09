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
package org.eclipse.n4js.xpect.ui.common;

import static com.google.common.base.Preconditions.checkState;
import static com.google.common.base.Splitter.on;
import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newLinkedList;
import static org.eclipse.n4js.utils.io.FileUtils.createDirectory;
import static org.eclipse.n4js.utils.io.FileUtils.createNestedDirectory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.n4js.AnnotationDefinition;
import org.eclipse.n4js.generator.AbstractSubGenerator;
import org.eclipse.n4js.generator.GeneratorOption;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.naming.N4JSQualifiedNameConverter;
import org.eclipse.n4js.projectModel.IN4JSCore;
import org.eclipse.n4js.projectModel.IN4JSProject;
import org.eclipse.n4js.projectModel.IN4JSSourceContainer;
import org.eclipse.n4js.runner.IExecutor;
import org.eclipse.n4js.runner.RunConfiguration;
import org.eclipse.n4js.runner.RunnerFrontEnd;
import org.eclipse.n4js.runner.SystemLoaderInfo;
import org.eclipse.n4js.runner.extension.RunnerRegistry;
import org.eclipse.n4js.runner.nodejs.NodeRunner;
import org.eclipse.n4js.runner.nodejs.NodeRunner.NodeRunnerDescriptorProvider;
import org.eclipse.n4js.runner.ui.ChooseImplementationHelper;
import org.eclipse.n4js.transpiler.es.EcmaScriptSubGenerator;
import org.eclipse.n4js.xpect.common.ResourceTweaker;
import org.eclipse.xpect.xtext.lib.setup.FileSetupContext;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.inject.Inject;

/**
 * Xpect helper that allows to compile and execute resources on demand in xpect tests. Uses
 * {@link EcmaScriptSubGenerator} for compilation and {@link NodeRunner} for execution.
 */
public class XpectN4JSES5TranspilerHelper {

	private final static String NL = "\n";

	/**
	 * https://github.com/eclipse/n4js/issues/394
	 *
	 * for simplifying node js compilation target we want to skip compiler id in the compiled code segments Hide this
	 * behind the flag, as we anticipate that this needs to be configurable for other (than node.js) generators, or we
	 * might make this configurable in the manifest.
	 */
	public static final boolean USE_COMPILED_OUTPUT = true;

	@Inject
	private IN4JSCore core;

	@Inject
	private IResourceValidator resourceValidator;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private RunnerFrontEnd runnerFrontEnd;

	@Inject
	private RunnerRegistry runnerRegistry;

	@Inject
	private ChooseImplementationHelper chooseImplHelper;

	private ReadOutConfiguration readOutConfiguration;

	/**
	 * Injection - method used to lazily initialize the runnerRegistry. Called after field-injection.
	 */
	@Inject
	private void init(NodeRunnerDescriptorProvider descriptorProvider) {
		if (!runnerRegistry.isRegistered(NodeRunner.ID)) {
			runnerRegistry.register(descriptorProvider.get());
		}
	}

	/**
	 * Compile provided resource, execute in Node.js and return execution output.
	 *
	 * @param resource
	 *            Script to execute
	 * @param init
	 *            xpect setup-init
	 * @param fileSetupContext
	 *            xpect injected
	 * @param decorateStdStreams
	 *            false-just connect stdout+stderr or errors to resulting string, true - decorate the streams with "<==
	 *            stdout: ..."
	 * @param resourceTweaker
	 *            - resource-modifier like QuickFix application, can be null
	 * @param systemLoader
	 *            the system loader to use (SYSTEM_JS[default], COMMON_JS,...)
	 * @return output streams concatenated
	 */
	public String doCompileAndExecute(final XtextResource resource,
			org.eclipse.xpect.setup.ISetupInitializer<Object> init,
			FileSetupContext fileSetupContext, boolean decorateStdStreams, ResourceTweaker resourceTweaker,
			GeneratorOption[] options, SystemLoaderInfo systemLoader) throws IOException {

		// Apply some modification to the resource here.
		if (resourceTweaker != null) {
			resourceTweaker.tweak(resource);
		}

		loadXpectConfiguration(init, fileSetupContext);

		File artificialRoot = Files.createTempDirectory("n4jsXpect").toFile();

		RunConfiguration runConfig;
		// if Xpect configured workspace is null, this has been triggered directly in the IDE
		// && (((ReadOutWorkspaceConfiguration) readOutConfiguration).getXpectConfiguredWorkspace() == null)
		if (Platform.isRunning()) {
			// If we are in the IDE, execute the test the same as for "Run in Node.js" and this way avoid
			// the effort of calculating dependencies etc.

			final String implementationId = chooseImplHelper.chooseImplementationIfRequired(NodeRunner.ID,
					resource.getURI().trimFileExtension());

			boolean replaceQuotes = false;
			// We have to generate JS code for the resource. Because if Xpect test is quickfixAndRun the resource
			// contains errors and hence no generated JS code is available for execution.
			// Then sneak in the path to the generated JS code.
			Script script = (Script) resource.getContents().get(0);
			createTempJsFileWithScript(artificialRoot.toPath(), script, options, replaceQuotes);
			runConfig = runnerFrontEnd.createConfiguration(NodeRunner.ID,
					(implementationId == ChooseImplementationHelper.CANCEL) ? null : implementationId,
					systemLoader.getId(),
					resource.getURI().trimFileExtension(), artificialRoot.getAbsolutePath().toString());
		} else {
			// In the non-GUI case, we need to calculate dependencies etc. manually
			final Iterable<Resource> dependencies = from(getDependentResources());
			boolean replaceQuotes = false;

			// compile all file resources
			StringBuilder errorResult = new StringBuilder();

			Script testScript = (Script) resource.getContents().get(0);

			// replace n4jsd resource with provided js resource
			for (final Resource dep : from(dependencies).filter(r -> !r.getURI().equals(resource.getURI()))) {
				if ("n4jsd".equalsIgnoreCase(dep.getURI().fileExtension())) {
					compileImplementationOfN4JSDFile(artificialRoot.toPath(), errorResult, dep, options, replaceQuotes);
				} else if (isCompilable(dep, errorResult)) {
					final Script script = (Script) dep.getContents().get(0);
					createTempJsFileWithScript(artificialRoot.toPath(), script, options, replaceQuotes);
				}
			}

			if (errorResult.length() != 0) {
				return errorResult.toString();
			}

			// No error so far
			// determine module to run
			createTempJsFileWithScript(artificialRoot.toPath(), testScript, options, replaceQuotes);
			String fileToRun = jsModulePathToRun(testScript);

			// Not in UI case, hence manually set up the resources
			runConfig = runnerFrontEnd.createXpectOutputTestConfiguration(NodeRunner.ID,
					fileToRun,
					systemLoader, artificialRoot.toPath().toString() + "/" + testScript.getModule().getProjectId());
		}

		return executeWithConfig(runConfig, decorateStdStreams);
	}

	private String executeWithConfig(final RunConfiguration runConfig, boolean decorateStdStreams) {
		String executionResult;
		List<String> combinedOutput = new ArrayList<>();
		try {
			Process process = runnerFrontEnd.run(runConfig, executor());
			EngineOutput eo = captureOutput(process);

			if (decorateStdStreams) {
				combinedOutput.add("<==");
				combinedOutput.add("stdout:");
			}
			combinedOutput.addAll(eo.getStdOut());
			if (decorateStdStreams) {
				combinedOutput.add("stderr:");
			}
			combinedOutput.addAll(eo.getErrOut());
			if (decorateStdStreams) {
				combinedOutput.add("==>");
			}

			executionResult = Joiner.on(NL).join(combinedOutput);
		} catch (Exception e) {
			executionResult = e.getMessage();
			// TODO Debugging:
			System.out.println("Error in N4js execution " + e);
			e.printStackTrace();

		}
		return executionResult;
	}

	/**
	 * Load Xpect configuration
	 */
	private void loadXpectConfiguration(
			org.eclipse.xpect.setup.ISetupInitializer<Object> init, FileSetupContext fileSetupContext) {
		if (Platform.isRunning()) {
			readOutConfiguration = new ReadOutWorkspaceConfiguration(fileSetupContext, core, fileExtensionProvider);
		} else {
			readOutConfiguration = new ReadOutResourceSetConfiguration(fileSetupContext, core);
		}
		init.initialize(readOutConfiguration);
	}

	/**
	 * private Executor which is not redirecting out & err streams.
	 */
	private IExecutor executor() {
		return new IExecutor() {
			@Override
			public Process exec(String[] cmdLine, File workingDirectory, Map<String, String> envp)
					throws ExecutionException {

				ProcessBuilder pb = new ProcessBuilder(cmdLine);
				pb.environment().putAll(envp);
				pb.directory(workingDirectory);

				try {
					return pb.start();
				} catch (IOException e) {
					throw new ExecutionException(e);
				}
			}
		};
	}

	/**
	 * Composes the name of the module as seen from the node-path. Is uses '/' as the path-separator, since it the path
	 * is consumed from js-code.
	 */
	private String jsModulePathToRun(Script script) {
		ArrayList<String> pathSegements = newArrayList(getCompiledFileBasePath(script));
		pathSegements.addAll(moduleQualifiedNameSegments(script));
		String fileToRun = Joiner.on('/').join(pathSegements);
		return fileToRun;
	}

	/**
	 * This operation is blocking (waits for process to finish).
	 *
	 * @param process
	 *            the process to get the standard out and error from.
	 *
	 * @return output captured during process run
	 */
	protected EngineOutput captureOutput(Process process) throws IOException {
		List<String> out = new ArrayList<>();
		List<String> err = new ArrayList<>();
		String outLine;
		String errLine;
		BufferedReader bri = null;
		BufferedReader bre = null;
		try {
			bri = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((outLine = bri.readLine()) != null) {
				out.add(outLine);
				// log.debug(outLine);
			}
			bre = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while ((errLine = bre.readLine()) != null) {
				err.add(errLine);
				System.err.println(errLine);
			}
		} catch (Exception e) {
			System.err.println("Exception in Engine.captureOutput: " + e.getMessage());
		} finally {
			if (bri != null) {
				bri.close();
			}
			if (bre != null) {
				bre.close();
			}
		}
		return new EngineOutput(out, err);
	}

	/**
	 * Compiles provided Script. Can replace backslashes with single quote (for windows command line issues)
	 *
	 * @param depRoot
	 *            script to transpile
	 * @param options
	 *            the {@link GeneratorOption}s to use during compilation.
	 * @param replaceQuotes
	 *            should replace quotes (only for windows)
	 * @return string representation of compilation result
	 */
	public String compile(Script depRoot, GeneratorOption[] options, boolean replaceQuotes) {
		final Resource resource = depRoot.eResource();
		EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
		final AbstractSubGenerator generator = getGeneratorForResource(resource);
		String compileResultStr = generator.getCompileResultAsText(depRoot, options);
		if (replaceQuotes) {
			// Windows Node.js has problems with " as it interprets it as ending of script to execute
			compileResultStr = compileResultStr.replace("\"", "'");
		}
		return compileResultStr;
	}

	/**
	 * Checks if given resource can be compiled. During the process validators for that resource are executed.
	 *
	 * @param resource
	 *            {@link Resource} that will check
	 * @param errorResult
	 *            {@link StringBuilder} to which potential validation issues will be appended
	 * @return {@code true} if there are no validation issues for resource and it can be compiled
	 */
	public boolean isCompilable(Resource resource, StringBuilder errorResult) {
		final AbstractSubGenerator generator = getGeneratorForResource(resource);
		// shouldBeCompiled already calls the resource validator, so
		// registerErrors should only be called when there have been errors found before
		return generator.shouldBeCompiled(resource, CancelIndicator.NullImpl) || !registerErrors(resource, errorResult);
	}

	/**
	 * Returns the desired generator instance for the resource argument. For now, will always return an instance of
	 * {@link EcmaScriptSubGenerator}.
	 */
	private AbstractSubGenerator getGeneratorForResource(Resource resource) {
		checkState(resource instanceof XtextResource, "Expected XtextResource was " + resource);
		return ((XtextResource) resource).getResourceServiceProvider().get(EcmaScriptSubGenerator.class);
	}

	/**
	 * Get dependent resources. Before calling this method make sure xpect configuration has been loaded.
	 */
	private List<Resource> getDependentResources() {
		Assert.assertNotNull("Xpect configuration has not been loaded!", readOutConfiguration);

		List<Resource> resourcesFromXpectConfiguredResourceSet = new ArrayList<>();
		resourcesFromXpectConfiguredResourceSet = readOutConfiguration.getResources();
		return Collections.unmodifiableList(new ArrayList<>(resourcesFromXpectConfiguredResourceSet));
	}

	private boolean registerErrors(Resource dep, StringBuilder errorResult) {
		boolean hasErrors = false;
		List<Issue> issues = resourceValidator.validate(dep, CheckMode.ALL, CancelIndicator.NullImpl);
		List<Issue> errorIssues = new ArrayList<>();
		for (Issue issue : issues) {
			if (Severity.ERROR == issue.getSeverity()) {
				errorIssues.add(issue);
			}
		}
		hasErrors = !errorIssues.isEmpty();
		if (hasErrors) {
			errorResult.append("Couldn't compile resource " + dep.getURI() + " because it contains errors: ");
			for (Issue errorIssue : errorIssues) {
				errorResult
						.append(NL + errorIssue.getMessage() + " at line " + errorIssue.getLineNumber());
			}
		}
		return hasErrors;
	}

	private void compileImplementationOfN4JSDFile(final Path root, StringBuilder errorResult, Resource dep,
			GeneratorOption[] options,
			boolean replaceQuotes) {

		Script script = (Script) dep.getContents().get(0);
		if (AnnotationDefinition.PROVIDED_BY_RUNTIME.hasAnnotation(script)) {
			return;
		}

		Optional<? extends IN4JSSourceContainer> sourceOpt = core.findN4JSSourceContainer(dep.getURI());
		if (sourceOpt.isPresent()) {
			IN4JSSourceContainer source = sourceOpt.get();
			IN4JSProject project = source.getProject();
			for (IN4JSSourceContainer c : project.getSourceContainers()) {
				if (c.isExternal()) {
					String sourceRelativePath = dep.getURI().toString()
							.replace(source.getLocation().toString(), "");
					String[] potentialExternalSourceRelativeURISegments = null;
					String potentialExternalSourceRelativePath = sourceRelativePath.replace(".n4jsd", ".js");
					potentialExternalSourceRelativeURISegments = URI.createURI(potentialExternalSourceRelativePath)
							.segments();

					if (potentialExternalSourceRelativeURISegments != null) {
						URI potentialExternalSourceURI = c.getLocation().appendSegments(
								potentialExternalSourceRelativeURISegments);
						try {
							Resource externalDep = dep.getResourceSet().getResource(potentialExternalSourceURI, true);
							script = (Script) externalDep.getContents().get(0);
							if (isCompilable(externalDep, errorResult)) {
								createTempJsFileWithScript(root, script, options, replaceQuotes);
							}
						} catch (Exception e) {
							throw new RuntimeException("Couldn't load " + potentialExternalSourceURI + ".", e);
						}
					}
				}
			}
		}
	}

	private File createTempJsFileWithScript(final Path root, final Script script, GeneratorOption[] options,
			final boolean replaceQuotes)
			throws IOException {
		// Compile script to get file content.
		final String content = compile(script, options, replaceQuotes);

		String srcgenSegments = getCompiledFileBasePath(script);
		Path srcgenPath = createNestedDirectory(root, srcgenSegments);

		// Get folder structure from qualified names.
		final LinkedList<String> segments = moduleQualifiedNameSegments(script);
		// Pop the file name from the segments.
		final String fileName = segments.removeLast();
		// Recursively create temporary folder structure.
		for (final String folderName : segments) {
			srcgenPath = createDirectory(srcgenPath, folderName);
		}

		final File file = new File(srcgenPath.toFile(), fileName + ".js");
		if (!file.exists()) {
			if (!file.createNewFile()) {
				throw new RuntimeException("Exception when creating new file: " + file);
			}
		}

		file.deleteOnExit();
		try (final PrintWriter pw = new PrintWriter(file)) {
			pw.print(content); // Make sure not to append but override content.
		}

		return file;
	}

	/** Splits up the script's qualified name along the delimiters. */
	private LinkedList<String> moduleQualifiedNameSegments(final Script script) {
		return newLinkedList(on(N4JSQualifiedNameConverter.DELIMITER).split(script.getModule().getQualifiedName()));
	}

	private String getCompiledFileBasePath(final Script script) {
		String path = script.getModule().getProjectId() + "/src-gen/";
		if (USE_COMPILED_OUTPUT) {
			IN4JSProject project = core.findProject(script.eResource().getURI()).orNull();
			if (project != null) {
				path = AbstractSubGenerator.calculateProjectBasedOutputDirectory(project);
			}
		}
		return path;
	}

}
