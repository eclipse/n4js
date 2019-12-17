/**
 * Copyright (c) 2019 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.cli.projectdiscovery.tests;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.n4js.cli.N4jscFactory;
import org.eclipse.n4js.utils.ProjectDiscoveryHelper;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.inject.Injector;

/**
 * Test checks if {@link ProjectDiscoveryHelper} find all projects and their dependencies.
 */
@RunWith(Parameterized.class)
public class ProjectDiscoveryTest extends AbstractProjectDiscoveryTest {
	static ProjectDiscoveryHelper projectDiscoveryHelper;

	/** Find test data files */
	@Parameters(name = "{index}: {0}")
	public static Collection<File> testData() {
		Collection<File> tests = new ArrayList<>();
		tests.addAll(getPDTFilesIn(new File("DiscoveryTestsBoth")));
		tests.addAll(getPDTFilesIn(new File("DiscoveryTestsOnlyNonOptimized")));
		return tests;
	}

	/** Init the {@link ProjectDiscoveryHelper} */
	@BeforeClass
	public static void init() {
		Injector injector = N4jscFactory.getOrCreateInjector();
		projectDiscoveryHelper = injector.getInstance(ProjectDiscoveryHelper.class);
	}

	/** Constructor */
	public ProjectDiscoveryTest(File testFile) {
		super(testFile);
	}

	@Override
	protected LinkedHashSet<Path> callProjectDiscoveryHelper(Path workspaceRoot) {
		return projectDiscoveryHelper.collectAllProjectDirs(workspaceRoot);
	}
}
