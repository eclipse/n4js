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
package org.eclipse.n4js.ide.tests.helper.server.xt.tests;

import org.eclipse.n4js.ide.tests.helper.server.xt.XtIdeTest;
import org.eclipse.n4js.ide.tests.helper.server.xt.XtMethodData;
import org.junit.Test;

/**
 * Tests for test method {@link XtIdeTest#elementKeyword(XtMethodData)}
 */
public class ElementKeywordTest extends AbstractXtParentRunnerTest {

	@Test
	public void test() throws Exception {
		run("probands/ElementKeyword");
		assertEventNames("testSuiteStarted - org.eclipse.n4js.ide.tests.helper.server.xt.tests.XtTestSetupTestMockup\n"
				+ "testSuiteStarted - ElementKeyword.n4js.xt: probands/ElementKeyword\n"
				+ "testStarted\n"
				+ "testFinished\n"
				+ "testStarted\n"
				+ "testFailure\n"
				+ "testSuiteFinished - ElementKeyword.n4js.xt: probands/ElementKeyword\n"
				+ "testSuiteFinished - org.eclipse.n4js.ide.tests.helper.server.xt.tests.XtTestSetupTestMockup");
		assertResults(
				"Passed: elementKeyword~0: test-1 〔probands/ElementKeyword/ElementKeyword.n4js.xt〕\n"
						+ "Failed: elementKeyword~1: test-2 〔probands/ElementKeyword/ElementKeyword.n4js.xt〕. expected:<[wrong expectation]> but was:<[method]>");
	}

}
