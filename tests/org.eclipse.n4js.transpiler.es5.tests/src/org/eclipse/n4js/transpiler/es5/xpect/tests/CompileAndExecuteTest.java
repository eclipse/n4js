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
package org.eclipse.n4js.transpiler.es5.xpect.tests;

import org.eclipse.n4js.N4JSStandaloneTestsModule;
import org.eclipse.n4js.xpect.ui.methods.OutputXpectMethod;
import org.eclipse.n4js.xpect.validation.suppression.N4JSSuppressIssuesSetup;
import org.junit.runner.RunWith;
import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.runner.XpectSuiteClasses;
import org.eclipse.xpect.runner.XpectTestFiles;
import org.eclipse.xpect.runner.XpectTestFiles.FileRoot;
import org.eclipse.xpect.xtext.lib.tests.ValidationTest;

/**
 */
@XpectSuiteClasses({
		ValidationTest.class,
		OutputXpectMethod.class
})
@RunWith(XpectRunner.class)
@XpectImport({ N4JSStandaloneTestsModule.class, N4JSSuppressIssuesSetup.class })
@XpectTestFiles(relativeTo = FileRoot.PROJECT, baseDir = "testdata", fileExtensions = { "xt" })
public class CompileAndExecuteTest {
	// nop
}
