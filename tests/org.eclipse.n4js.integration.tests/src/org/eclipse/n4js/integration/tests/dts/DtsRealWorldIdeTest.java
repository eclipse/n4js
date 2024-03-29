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
package org.eclipse.n4js.integration.tests.dts;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.n4js.cli.helper.CliTools;
import org.eclipse.n4js.cli.helper.ProcessResult;
import org.eclipse.n4js.ide.tests.helper.server.AbstractIdeTest;
import org.eclipse.n4js.utils.Strings;
import org.eclipse.n4js.workspace.locations.FileURI;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing .d.ts support with real-world type definitions.
 */

public class DtsRealWorldIdeTest extends AbstractIdeTest {

	/**
	 * Real-world npm packages containing .d.ts files that will be tested in the test cases of this class, given as
	 * pairs of package name and version constraint.
	 * <p>
	 * These projects may or may not be <code>@types</code> projects.
	 */
	private static final Map<String, String> PACKAGES_TO_TEST = Map.of(
			"@types/node", "17.0.27");

	@Test
	public void testNode() {
		assertDtsUsage("""
				import * as url from "url"
				let u: url.Url;
				let v01: number = u.href;
				let v02: string = u.href;
				""", List.of(
				"(Error, [2:18 - 2:24], string is not a subtype of number.)"));
	}

	@Test
	public void testNode_withColonInModuleSpecifier() {
		assertDtsUsage("""
				import * as url from "node:url"
				let u: url.Url;
				let v01: number = u.href;
				let v02: string = u.href;
				""", List.of(
				"(Error, [2:18 - 2:24], string is not a subtype of number.)"));
	}

	private FileURI mainModuleURI = null;

	@Before
	public void prepare() {
		if (mainModuleURI != null) {
			return; // already prepared
		}

		Iterable<String> deps = map(PACKAGES_TO_TEST.entrySet(),
				(e) -> "\"" + e.getKey() + "\": \"" + e.getValue() + "\"");
		String depsStr = Strings.join(", ", deps);

		testWorkspaceManager.createTestProjectOnDisk(Map.of(
				"Main", """
						// test cases will replace this with test code
						""",
				PACKAGE_JSON, """
						{
							"name": "%s",
							"version": "0.0.1",
							"type": "module",
							"n4js": {
								"projectType": "library",
								"vendorId": "VENDOR",
								"vendorName": "VENDOR_name",
								"output": "src-gen",
								"sources": {
									"source": [
										"src"
									]
								}
							},
							"dependencies": {
								"n4js-runtime": "",
								%s
							}
						}
						""".formatted(DEFAULT_PROJECT_NAME, depsStr)));

		File root = getProjectRoot();
		ProcessResult result = new CliTools().npmInstall(root.toPath());
		assertNull(result.getException());
		assertEquals(0, result.getExitCode());

		startAndWaitForLspServer();
		mainModuleURI = getFileURIFromModuleName("Main");
		openFile(mainModuleURI);

		joinServerRequests();
		assertNoErrors();
		// note: we will have warnings along the lines of ...
		// "The implementation project node of type definition project @types/node is missing from the dependencies
		// section."
	}

	private void assertDtsUsage(CharSequence sourceCode, List<String> expectedIssuesInMain) {
		assertNotNull(mainModuleURI);
		changeOpenedFile(mainModuleURI, sourceCode);
		joinServerRequests();
		assertIssuesInModules(Pair.of("Main", expectedIssuesInMain));
	}
}
