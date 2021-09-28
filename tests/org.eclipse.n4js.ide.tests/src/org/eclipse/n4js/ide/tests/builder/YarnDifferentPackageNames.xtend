/**
 * Copyright (c) 2020 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.ide.tests.builder

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import org.junit.Test

import static org.junit.Assert.*

/**
 * Test two cases of projects with the same project name within a yarn setup
 */
class YarnDifferentPackageNames extends AbstractIncrementalBuilderTest {

	private static val testData = #[
		"main-project" -> #[
			"MainModule" -> '''
				import {LibraryClass} from "LibraryModule"
				
				new LibraryClass();
			''',
			CFG_DEPENDENCIES -> '''
				library-project-other-name
			'''
		],
		"library-project" -> #[
			"LibraryModule" -> '''
				export public class LibraryClass {
				}
			''',
			PACKAGE_JSON -> '''
				{
					"name": "library-project-other-name",
					"version": "0.0.1",
					"dependencies": {
						"n4js-runtime": "*"
					},
					"n4js": {
						"projectType": "library",
						"mainModule": "LibraryModule",
						"vendorId": "org.eclipse.n4js",
						"sources": {
							"source": [
								"src"
							]
						},
						"output": "src-gen"
					}
				}
			'''
		]
	];

	@Test
	def void twoEqualProjectNames() throws Exception {
		testWorkspaceManager.createTestOnDisk(testData);
		
		startAndWaitForLspServer();
		assertIssues("library-project/package.json" -> #[
			"(Warning, [1:9 - 1:37], As a convention the package name \"library-project-other-name\" should match the name of the project folder \"library-project\" on the file system.)"]);
		
		assertOutputFileExists("main-project", "MainModule");
		
		val outputFile = getOutputFile("main-project", "MainModule");
		val content = Files.readString(outputFile.toPath, StandardCharsets.US_ASCII);
		assertEquals('''
			// Generated by N4JS transpiler; for copyright see original N4JS source file.
			
			import 'n4js-runtime'
			import {LibraryClass} from 'library-project-other-name'
			
			new LibraryClass();
			//# sourceMappingURL=MainModule.map
		''', content);
	}

}
