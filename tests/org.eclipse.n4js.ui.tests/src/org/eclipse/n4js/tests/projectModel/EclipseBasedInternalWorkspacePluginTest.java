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
package org.eclipse.n4js.tests.projectModel;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.n4js.N4JSUiInjectorProvider;
import org.eclipse.n4js.internal.InternalN4JSWorkspace;
import org.eclipse.n4js.internal.MultiCleartriggerCache;
import org.eclipse.n4js.ui.internal.EclipseBasedN4JSWorkspace;
import org.eclipse.n4js.ui.internal.PlatformResourceURI;
import org.eclipse.n4js.utils.ProjectDescriptionLoader;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 */
@RunWith(XtextRunner.class)
@InjectWith(N4JSUiInjectorProvider.class)
public class EclipseBasedInternalWorkspacePluginTest extends AbstractInternalWorkspaceTest<PlatformResourceURI> {

	@Inject
	private IWorkspaceRoot workspace;

	@Inject
	private ProjectDescriptionLoader projectDescriptionLoader;

	@Inject
	private MultiCleartriggerCache cache;

	private EclipseBasedN4JSWorkspace testMe;

	@Override
	protected AbstractProjectModelSetup<PlatformResourceURI> createSetup() {
		return new EclipseBasedProjectModelSetup(this, workspace);
	}

	@Override
	protected String[] getExpectedIssuesInInitialSetup(String projectName) {
		if (projectName.equals(myProjectName)) {
			return new String[] {
					"line 6: Project depends on workspace project libProject which is missing in the node_modules folder. Either install project libProject or introduce a yarn workspace of both of the projects."
			};
		}
		return new String[0];
	}

	@Override
	public void setUp() {
		testMe = new EclipseBasedN4JSWorkspace(workspace, projectDescriptionLoader, cache);
		super.setUp();
	}

	@Override
	public void tearDown() {
		super.tearDown();
		testMe = null;
	}

	@Override
	protected InternalN4JSWorkspace<PlatformResourceURI> getWorkspace() {
		return testMe;
	}

}
