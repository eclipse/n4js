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
public class N4_08_01_05_PropertyDeclarationsWithTypeAnnotations extends AbstractParserTest {

	@Test
	public void test_Members() throws Exception {
		Script script = parseHelper.parse("""
				var ol = {
					int 	a: 5,
					string 	b: "",
					{function(int):string} c: function(i: int): string { return ""; },
					get eOld(): string {return ""},
					get e(): string {return ""},
					set f(x: int){}
				}
				""");
		assertTrue(script.eResource().getErrors().toString(), script.eResource().getErrors().isEmpty());
	}

}
