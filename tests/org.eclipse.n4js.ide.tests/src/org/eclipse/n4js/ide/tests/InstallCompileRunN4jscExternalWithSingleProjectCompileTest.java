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
package org.eclipse.n4js.ide.tests;

import static org.eclipse.n4js.cli.N4jscTestOptions.COMPILE;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.cli.helper.AbstractCliCompileTest;
import org.eclipse.n4js.cli.helper.CliCompileResult;
import org.eclipse.n4js.cli.helper.ProcessResult;
import org.eclipse.n4js.utils.io.FileDeleter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Downloads, installs, compiles and runs 'express'.
 */
public class InstallCompileRunN4jscExternalWithSingleProjectCompileTest extends AbstractCliCompileTest {
	File workspace;

	/** Prepare workspace. */
	@Before
	public void setupWorkspace() throws IOException {
		workspace = setupWorkspace("external_singleProjectOrFileCompile", true, N4JSGlobals.N4JS_RUNTIME);
	}

	/** Delete workspace. */
	@After
	public void deleteWorkspace() throws IOException {
		FileDeleter.delete(workspace.toPath(), true);
	}

	/**
	 * Test for checking the npm support in the headless case by downloading third party package, importing it and
	 * running it with Common JS.
	 */
	@Test
	public void testCompileAndRunWithExternalDependencies() {
		final Path wsRoot = workspace.getAbsoluteFile().toPath();
		final Path project = wsRoot.resolve("packages").resolve("external.project");
		final Path fileToRun = project.resolve("src-gen").resolve("Main.js");

		yarnInstall(workspace.toPath());

		CliCompileResult cliResult = n4jsc(COMPILE(workspace));
		assertEquals(cliResult.toString(), 1, cliResult.getTranspiledFilesCount(project));

		String expectedString = "Application was created!";

		ProcessResult nodejsResult = runNodejs(workspace.toPath(), fileToRun);
		assertEquals(nodejsResult.toString(), expectedString, nodejsResult.getStdOut());
	}

}
