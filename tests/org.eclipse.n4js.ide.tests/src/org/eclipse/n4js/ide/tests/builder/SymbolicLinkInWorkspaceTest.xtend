/**
 * Copyright (c) 2021 NumberFour AG.
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
import org.eclipse.n4js.ide.tests.helper.server.AbstractIdeTest
import org.eclipse.n4js.utils.io.FileUtils
import org.junit.Assert
import org.junit.Test

/**
 * Tests workspaces in which one or more projects have a path that crosses symbolic links,
 * both taking into account workspace projects and projects located in the "node_modules" folder.
 * 
 * Hard links are not tested, for now.
 */
class SymbolicLinkInWorkspaceTest extends AbstractIdeTest {

	@Test
	def void testSymLinkInNodeModulesFolder() throws Exception {
		createYarnWorkspaceWithProjectMainWithDependencyTo("ProjectOther");
		val other = createProjectOutsideWorkspace("ProjectOther", "Other");
		val nodeModulesFolder = getNodeModulesFolder().toPath;
		Files.createSymbolicLink(nodeModulesFolder.resolve("ProjectOther"), other);
		startAndWaitForLspServer();

		assertProjectsInWorkspace('''
			yarn-test-project
			yarn-test-project/node_modules/n4js-runtime
			yarn-test-project/node_modules/ProjectOther
			yarn-test-project/packages/ProjectMain
		''');
		assertNoIssues();
	}

	@Test
	def void testSymLinkInNodeModulesFolder_withScope01() throws Exception {
		createYarnWorkspaceWithProjectMainWithDependencyTo("@someScope/ProjectOther");
		val other = createProjectOutsideWorkspace("@someScope/ProjectOther", "Other");
		val nodeModulesFolder = getNodeModulesFolder().toPath;
		Files.createSymbolicLink(nodeModulesFolder.resolve("@someScope"), other.parent);
		startAndWaitForLspServer();

		assertProjectsInWorkspace('''
			yarn-test-project
			yarn-test-project/node_modules/n4js-runtime
			yarn-test-project/node_modules/@someScope/ProjectOther
			yarn-test-project/packages/ProjectMain
		''');
		assertNoIssues();
	}

	@Test
	def void testSymLinkInNodeModulesFolder_withScope02() throws Exception {
		createYarnWorkspaceWithProjectMainWithDependencyTo("@someScope/ProjectOther");
		val other = createProjectOutsideWorkspace("@someScope/ProjectOther", "Other");
		val nodeModulesFolder = getNodeModulesFolder().toPath;
		Files.createDirectory(nodeModulesFolder.resolve("@someScope"));
		Files.createSymbolicLink(nodeModulesFolder.resolve("@someScope").resolve("ProjectOther"), other);
		startAndWaitForLspServer();

		assertProjectsInWorkspace('''
			yarn-test-project
			yarn-test-project/node_modules/n4js-runtime
			yarn-test-project/node_modules/@someScope/ProjectOther
			yarn-test-project/packages/ProjectMain
		''');
		assertNoIssues();
	}

	@Test
	def void testSymLinkInPackagesFolder() throws Exception {
		createYarnWorkspaceWithProjectMainWithDependencyTo("ProjectOther");
		val other = createProjectOutsideWorkspace("ProjectOther", "Other");
		val packagesFolder = getProjectLocation().toPath;
		Files.createSymbolicLink(packagesFolder.resolve("ProjectOther"), other);
		startAndWaitForLspServer();

		assertProjectsInWorkspace('''
			yarn-test-project
			yarn-test-project/node_modules/n4js-runtime
			yarn-test-project/packages/ProjectOther
			yarn-test-project/packages/ProjectMain
		''');
		assertNoIssues();
	}

	@Test
	def void testSymLinkInPackagesFolder_withScope01() throws Exception {
		createYarnWorkspaceWithProjectMainWithDependencyTo("@someScope/ProjectOther");
		val other = createProjectOutsideWorkspace("@someScope/ProjectOther", "Other");
		val packagesFolder = getProjectLocation().toPath;
		Files.createSymbolicLink(packagesFolder.resolve("@someScope"), other.parent);
		startAndWaitForLspServer();

		assertProjectsInWorkspace('''
			yarn-test-project
			yarn-test-project/node_modules/n4js-runtime
			yarn-test-project/packages/@someScope/ProjectOther
			yarn-test-project/packages/ProjectMain
		''');
		assertNoIssues();
	}

	@Test
	def void testSymLinkInPackagesFolder_withScope02() throws Exception {
		createYarnWorkspaceWithProjectMainWithDependencyTo("@someScope/ProjectOther");
		val other = createProjectOutsideWorkspace("@someScope/ProjectOther", "Other");
		val packagesFolder = getProjectLocation().toPath;
		Files.createDirectory(packagesFolder.resolve("@someScope"));
		Files.createSymbolicLink(packagesFolder.resolve("@someScope").resolve("ProjectOther"), other);
		startAndWaitForLspServer();

		assertProjectsInWorkspace('''
			yarn-test-project
			yarn-test-project/node_modules/n4js-runtime
			yarn-test-project/packages/@someScope/ProjectOther
			yarn-test-project/packages/ProjectMain
		''');
		assertNoIssues();
	}


	def private void createYarnWorkspaceWithProjectMainWithDependencyTo(CharSequence dependenciesOfProjectMain) {
		testWorkspaceManager.createTestYarnWorkspaceOnDisk("ProjectMain" -> #[
			"Main" -> '''
				import {ClassOther} from "ModuleOther"
				new ClassOther();
			''',
			CFG_DEPENDENCIES -> dependenciesOfProjectMain
		]);
	}


	def private void assertProjectsInWorkspace(CharSequence expectedProjects) {
		val expectedProjectPathStrs = expectedProjects.toString.trim.split("\\n").map[trim].sort;
		val baseFolder = getRoot().toPath;
		val actualProjectPathStrs = concurrentIndex.workspaceConfigSnapshot.projects
			.map[Path.of(path.toFileString)]
			.map[baseFolder.relativize(it)]
			.map[toString]
			.sort;
		Assert.assertEquals(expectedProjectPathStrs.join('\n'), actualProjectPathStrs.join('\n'))
	}

	def private Path createProjectOutsideWorkspace(String projectName, String nameSuffix) throws IOException {
		val tempFolder = FileUtils.createTempDirectory(this.class.simpleName + "_");
		val projectFolder = tempFolder.resolve(projectName); // note: supports npm scopes!
		Files.createDirectories(projectFolder);
		Files.createDirectories(projectFolder.resolve("src"));
		Files.writeString(projectFolder.resolve(PACKAGE_JSON), '''
			{
				"name": "«projectName»",
				"version": "0.0.1",
				"n4js": {
					"projectType": "library",
					"output": "src-gen",
					"sources": { "source": [ "src" ] }
				},
				"dependencies": {
					"n4js-runtime": "*"
				}
			}
		''');
		Files.writeString(projectFolder.resolve("src").resolve("Module" + nameSuffix + ".n4js"), '''
			export public class Class«nameSuffix» {}
		''');
		return projectFolder;
	}
}
