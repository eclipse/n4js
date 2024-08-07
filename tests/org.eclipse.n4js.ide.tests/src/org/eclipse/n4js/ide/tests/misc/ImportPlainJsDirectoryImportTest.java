/**
 * Copyright (c) 2022 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.ide.tests.misc;

import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.n4js.ide.tests.helper.server.AbstractIdeTest;
import org.eclipse.n4js.workspace.locations.FileURI;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * Tests for importing from plain-JS modules.
 * <p>
 * This test class covers directory imports.
 */

public class ImportPlainJsDirectoryImportTest extends AbstractIdeTest {

	@Ignore("not yet supported") // directory imports are supported only if an .n4jsd file exists!
	@Test
	public void testDirectoryImport_noN4jsdFile() throws Exception {
		throw new UnsupportedOperationException();
	}

	@Test
	public void testDirectoryImport_withN4jsdFile_sameProject() throws Exception {
		testWorkspaceManager.createTestOnDisk(Map.of(
				"N4jsProject", Map.of(
						"../src-ext/someFolder/subFolder/hiddenModule.js", """
								// content does not matter
								""",
						// note: file "../src-ext/someFolder/package.json" will be added below
						"someFolder.n4jsd", """
								export external public function foo();
								""",
						"N4jsModule", """
								import * as stuff from "someFolder";
								stuff.foo();
								""",
						PACKAGE_JSON, """
								{
									"name": "N4jsProject",
									"version": "0.0.1",
									"n4js": {
										"projectType": "library",
										"vendorId": "org.eclipse.n4js",
										"sources": {
											"source": [
												"src"
											],
											"external": [
												"src-ext"
											]
										},
										"output": "src-gen"
									},
									"dependencies": {
										"n4js-runtime": "*"
									}
								}
								""")));
		Files.writeString(getProjectRoot("N4jsProject").toPath().resolve("src-ext/someFolder/package.json"), """
				{
					"main": "./subFolder/hiddenModule.js"
				}
				""", StandardOpenOption.CREATE_NEW);
		startAndWaitForLspServer();
		assertNoIssues();
		// ensure the transpiler does not emit a file extension at the end of the module specifier when importing
		// directory "someFolder".
		assertModuleSpecifier("./someFolder"); // <-- must not have a file extension here!
	}

	@Test
	public void testDirectoryImport_withN4jsdFile_separateProjects() throws Exception {
		testWorkspaceManager.createTestOnDisk(Map.of(
				CFG_NODE_MODULES + "somePackage", Map.of(
						"someFolder/subFolder/hiddenModule.js", """
									// content does not matter
								""",
						// note: file "someFolder/package.json" will be added below
						CFG_SOURCE_FOLDER, ".",
						PACKAGE_JSON, """
									{
										"name": "somePackage",
										"version": "0.0.1"
									}
								"""),
				CFG_NODE_MODULES + "@n4jsd/somePackage", Map.of(
						"someFolder.n4jsd", """
									export external public function foo();
								""",
						CFG_SOURCE_FOLDER, ".",
						PACKAGE_JSON, """
									{
										"name": "@n4jsd/somePackage",
										"version": "0.0.1",
										"n4js": {
											"projectType": "definition",
											"definesPackage": "somePackage",
											"vendorId": "org.eclipse.n4js",
											"sources": {
												"source": [
													"."
												]
											}
										}
									}
								"""),
				"N4jsProject", Map.of(
						"N4jsModule", """
									import * as stuff from "someFolder";
									stuff.foo();
								""",
						CFG_DEPENDENCIES, """
									@n4jsd/somePackage,
									somePackage
								""")));
		Files.writeString(getProjectRoot().toPath().resolve("node_modules/somePackage/someFolder/package.json"), """
					{
						"main": "./subFolder/hiddenModule.js"
					}
				""", StandardOpenOption.CREATE_NEW);
		startAndWaitForLspServer();
		assertNoIssues();
		// ensure the transpiler does not emit a file extension at the end of the module specifier when importing
		// directory "someFolder".
		assertModuleSpecifier("somePackage/someFolder"); // <-- must not have a file extension here!
	}

	private void assertModuleSpecifier(String expectedModuleSpecifier) {
		FileURI outputFileURI = toFileURI(getOutputFile("N4jsProject", "N4jsModule"));
		String outputCode = getContentOfFileOnDisk(outputFileURI);
		Matcher matcher = Pattern.compile("\\nimport \\* as stuff from '(.+)'\\n").matcher(outputCode);
		if (!matcher.find()) {
			Assert.fail("expected import not found in output code:\n" + outputCode);
		}
		String actualModuleSpecifier = matcher.group(1);
		if (Strings.isNullOrEmpty(actualModuleSpecifier)) {
			Assert.fail("failed to extract module specifier from output code:\n" + outputCode);
		}
		Assert.assertEquals("unexpected module specifier", expectedModuleSpecifier, actualModuleSpecifier);
	}
}
