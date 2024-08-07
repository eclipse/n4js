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
package org.eclipse.n4js.tests.parser;

import org.eclipse.n4js.n4JS.Script;
import org.junit.Test;

/**
 * Parser tests for type annotations in functions.
 */
public class N4_06_02_01_FunctionDeclarationsWithTypeAnnotations extends AbstractParserTest {

	@Test
	public void test_IDE_2019_OLD() throws Exception {
		Script script = parseHelper.parse("""
				function f(i: int, s: string): int { return i + s.length; }
				""");
		assertTrue(script.eResource().getErrors().toString(), script.eResource().getErrors().isEmpty());
	}

	@Test
	public void test_IDE_2019() throws Exception {
		Script script = parseHelper.parse("""
				function f(i: int, s: string): int { return i + s.length; }
				""");
		assertTrue(script.eResource().getErrors().toString(), script.eResource().getErrors().isEmpty());
	}

}
