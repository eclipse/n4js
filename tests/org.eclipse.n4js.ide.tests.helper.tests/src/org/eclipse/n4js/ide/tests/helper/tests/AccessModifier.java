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
 * Test for test method 'accessModifier'
 */
public class AccessModifier extends AbstractXtParentRunnerTest {

	/***/
	@Test
	public void test() throws Exception {
		run("probands/AccessModifier");

		assertTestStructure("org.eclipse.n4js.ide.tests.helper.server.xt.XtIdeTest\n"
				+ " + AccessModifier.n4js.xt: probands/AccessModifier\n"
				+ " ++ accessModifier~0: test-1 〔probands/AccessModifier/AccessModifier.n4js.xt〕(test-1)");

		assertResult("(test-1)", "Passed: type~0: test-1 〔probands/Type/Type.n4js.xt〕");
	}

}
