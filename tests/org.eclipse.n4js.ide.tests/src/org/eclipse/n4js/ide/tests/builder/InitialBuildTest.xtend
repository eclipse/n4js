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

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import org.eclipse.n4js.N4JSGlobals
import org.eclipse.n4js.ide.tests.server.TestWorkspaceManager
import org.eclipse.n4js.utils.io.FileDeleter
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

import static org.junit.Assert.*

/**
 * Test various cases of changes between server sessions to ensure the initial build of the later session
 * correctly reacts to those changes.
 */
class InitialBuildTest extends AbstractIncrementalBuilderTest {

	private static Path temporaryFolder;

	@BeforeClass
	def static void createTemporaryFolder() throws IOException {
		temporaryFolder = Files.createTempDirectory("temp_InitialBuildTest_");
	}

	@AfterClass
	def static void deleteTemporaryFolder() throws IOException {
		if (temporaryFolder !== null) {
			FileDeleter.delete(temporaryFolder);
		}
	}

	@Test
	def void testFixFileBetweenServerSessions() {
		testWorkspaceManager.createTestOnDisk(
			TestWorkspaceManager.CFG_NODE_MODULES + "n4js-runtime" -> null,
			"ProviderProject" -> #[
				"SomeModule" -> '''
					export public class SomeClassX {
					}
				''',
				TestWorkspaceManager.CFG_DEPENDENCIES -> '''
					n4js-runtime
				'''
			],
			"ClientProject" -> #[
				"ClientModule" -> '''
					import {SomeClass} from "SomeModule";
					const x: SomeClass = null;
					x;
				''',
				TestWorkspaceManager.CFG_DEPENDENCIES -> '''
					n4js-runtime,
					ProviderProject
				'''
			]
		);
		startAndWaitForLspServer();
		assertIssues("ClientModule" -> #[
			"(Error, [0:8 - 0:17], Import of SomeClass cannot be resolved.)",
			"(Error, [1:9 - 1:18], Couldn't resolve reference to Type 'SomeClass'.)"
		]);

		shutdownLspServer();

		changeFileOnDiskWithoutNotification("SomeModule", Pair.of("SomeClassX", "SomeClass"));

		startAndWaitForLspServer();
		assertNoIssues();

		openFile("ClientModule");
		joinServerRequests();
		assertNoIssues();
		closeFile("ClientModule");
		joinServerRequests();
		assertNoIssues();
	}

	@Test
	def void testBreakFileBetweenServerSessions() {
		testWorkspaceManager.createTestOnDisk(
			TestWorkspaceManager.CFG_NODE_MODULES + "n4js-runtime" -> null,
			"ProviderProject" -> #[
				"SomeModule" -> '''
					export public class SomeClass {
					}
				''',
				TestWorkspaceManager.CFG_DEPENDENCIES -> '''
					n4js-runtime
				'''
			],
			"ClientProject" -> #[
				"ClientModule" -> '''
					import {SomeClass} from "SomeModule";
					const x: SomeClass = null;
					x;
				''',
				TestWorkspaceManager.CFG_DEPENDENCIES -> '''
					n4js-runtime,
					ProviderProject
				'''
			]
		);
		startAndWaitForLspServer();
		assertNoIssues();

		shutdownLspServer();

		changeFileOnDiskWithoutNotification("SomeModule", Pair.of("SomeClass", "SomeClassX"));

		startAndWaitForLspServer();
		assertIssues("ClientModule" -> #[
			"(Error, [0:8 - 0:17], Import of SomeClass cannot be resolved.)",
			"(Error, [1:9 - 1:18], Couldn't resolve reference to Type 'SomeClass'.)"
		]);

		openFile("ClientModule");
		joinServerRequests();
		assertIssues("ClientModule" -> #[
			"(Error, [0:8 - 0:17], Import of SomeClass cannot be resolved.)",
			"(Error, [1:9 - 1:18], Couldn't resolve reference to Type 'SomeClass'.)"
		]);
		closeFile("ClientModule");
		joinServerRequests();
		assertIssues("ClientModule" -> #[
			"(Error, [0:8 - 0:17], Import of SomeClass cannot be resolved.)",
			"(Error, [1:9 - 1:18], Couldn't resolve reference to Type 'SomeClass'.)"
		]);
	}

	@Test
	def void testAddRemoveFileBetweenServerSessions() throws IOException {
		testWorkspaceManager.createTestOnDisk(
			TestWorkspaceManager.CFG_NODE_MODULES + "n4js-runtime" -> null,
			"ProviderProject" -> #[
				"SomeModule" -> '''
					export public class SomeClass {
					}
				''',
				TestWorkspaceManager.CFG_DEPENDENCIES -> '''
					n4js-runtime
				'''
			],
			"ClientProject" -> #[
				"ClientModule" -> '''
					import {SomeClass} from "SomeModule";
					const x: SomeClass = null;
					x;
				''',
				TestWorkspaceManager.CFG_DEPENDENCIES -> '''
					n4js-runtime,
					ProviderProject
				'''
			]
		);

		val someModule = getFileURIFromModuleName("SomeModule").toFile.toPath;
		val someModuleHidden = temporaryFolder.resolve(someModule.fileName.toString);
		Files.move(someModule, someModuleHidden);

		startAndWaitForLspServer();
		val errorsWithSomeModuleMissing = #[
			"ClientModule" -> #[
				"(Error, [0:24 - 0:36], Cannot resolve plain module specifier (without project name as first segment): no matching module found.)",
				"(Error, [1:9 - 1:18], Couldn't resolve reference to Type 'SomeClass'.)"
			]
		];
		assertIssues(errorsWithSomeModuleMissing);

		shutdownLspServer();

		// sub-case #1: add file between server sessions (containing project does *not* contain a .n4js.projectstate file)
		Files.move(someModuleHidden, someModule);

		startAndWaitForLspServer();
		assertNoIssues();

		openFile("ClientModule");
		joinServerRequests();
		assertNoIssues();
		closeFile("ClientModule");
		joinServerRequests();
		assertNoIssues();

		shutdownLspServer();

		// sub-case #2: remove file between server sessions
		Files.move(someModule, someModuleHidden);

		startAndWaitForLspServer();
		assertIssues(errorsWithSomeModuleMissing);

		openFile("ClientModule");
		joinServerRequests();
		assertIssues(errorsWithSomeModuleMissing);
		closeFile("ClientModule");
		joinServerRequests();
		assertIssues(errorsWithSomeModuleMissing);

		shutdownLspServer();

		// sub-case #3: add file between server sessions (this time, containing project does contain an up-to-date '.n4js.projectstate' file!)
		Files.move(someModuleHidden, someModule);
		assertTrue("project state file does not exist", Files.isRegularFile(getProjectRoot("ProviderProject").toPath.resolve(N4JSGlobals.N4JS_PROJECT_STATE)))

		startAndWaitForLspServer();
		assertNoIssues();

		openFile("ClientModule");
		joinServerRequests();
		assertNoIssues();
		closeFile("ClientModule");
		joinServerRequests();
		assertNoIssues();
	}
}
