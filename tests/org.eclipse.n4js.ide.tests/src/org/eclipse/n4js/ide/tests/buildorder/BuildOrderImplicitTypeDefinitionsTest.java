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
package org.eclipse.n4js.ide.tests.buildorder;

import java.util.Map;

import org.junit.Test;

/**
 * Test for build order
 */

public class BuildOrderImplicitTypeDefinitionsTest extends AbstractBuildOrderTest {

	@Test
	public void testSingleDependency1() {
		test("yarn-test-project, " +
				"yarn-test-project/packages-gen/@n4jsd/Lib1, " +
				"yarn-test-project/packages-gen/@n4jsd/Lib3, " +
				"yarn-test-project/packages-gen/@n4jsd/Lib2, " +
				"yarn-test-project/node_modules/n4js-runtime, " +
				"yarn-test-project/node_modules/Lib1, " +
				"yarn-test-project/node_modules/Lib2, " +
				"yarn-test-project/packages/P1",
				Map.of(
						CFG_NODE_MODULES + "n4js-runtime", Map.of(),
						CFG_NODE_MODULES + "Lib1", Map.of(
								"package.json", """
											{
												"name": "Lib1"
											}
										"""),
						CFG_NODE_MODULES + "Lib2", Map.of(
								"package.json", """
											{
												"name": "Lib2",
												"dependencies": {
													"Lib3": "*"
												}
											}
										"""),
						CFG_NODE_MODULES + "Lib3", Map.of(
								"package.json", """
											{
												"name": "Lib3"
											}
										"""),
						CFG_WORKSPACES_FOLDER + "packages-gen/@n4jsd/Lib1", Map.of(
								"package.json", """
											{
												"name": "@n4jsd/Lib1",
												"n4js": {
													"projectType": "definition",
													"definesPackage": "Lib1"
												}
											}
										"""),
						CFG_WORKSPACES_FOLDER + "packages-gen/@n4jsd/Lib2", Map.of(
								"package.json", """
											{
												"name": "@n4jsd/Lib2",
												"dependencies": {
													"@n4jsd/Lib3": "*"
												},
												"n4js": {
													"projectType": "definition",
													"definesPackage": "Lib2"
												}
											}
										"""),
						CFG_WORKSPACES_FOLDER + "packages-gen/@n4jsd/Lib3", Map.of(
								"package.json", """
											{
												"name": "@n4jsd/Lib3",
												"n4js": {
													"projectType": "definition",
													"definesPackage": "Lib3"
												}
											}
										"""),
						"P1", Map.of(
								CFG_DEPENDENCIES, """
											n4js-runtime,
											Lib1,
											Lib2
										""")));
	}

}
