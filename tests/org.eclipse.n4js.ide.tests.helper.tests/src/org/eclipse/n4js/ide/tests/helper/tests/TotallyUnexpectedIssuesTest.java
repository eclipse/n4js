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
package org.eclipse.n4js.ide.tests.helper.tests;

import org.junit.Test;

/**
 *
 */
public class TotallyUnexpectedIssuesTest extends AbstractXtParentRunnerTest {

	/***/
	@Test
	public void test() throws Exception {
		run("probands/TotallyUnexpectedIssues");

		assertTestStructure("org.eclipse.n4js.ide.tests.helper.server.xt.XtIdeTest\n"
				+ " + TotallyUnexpectedIssues.n4js.xt: probands/TotallyUnexpectedIssues\n"
				+ " ++ nothing~0:  〔probands/TotallyUnexpectedIssues/TotallyUnexpectedIssues.n4js.xt〕()");

		assertResults(
				"Failed: TotallyUnexpectedIssues.n4js.xt: probands/TotallyUnexpectedIssues. Unexpected issue found: 'Couldn't resolve reference to IdentifiableElement 'B1'.' at 'B1'");
	}

}
