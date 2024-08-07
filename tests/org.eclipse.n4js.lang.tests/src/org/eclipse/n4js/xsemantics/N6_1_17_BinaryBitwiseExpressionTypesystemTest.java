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
package org.eclipse.n4js.xsemantics;

import static org.eclipse.n4js.validation.JavaScriptVariant.n4js;
import static org.eclipse.n4js.validation.JavaScriptVariant.strict;
import static org.eclipse.n4js.validation.JavaScriptVariant.unrestricted;

import java.util.List;

import org.eclipse.n4js.N4JSInjectorProvider;
import org.eclipse.n4js.validation.JavaScriptVariant;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for operator test (6.1.10- 6.1.18)
 */
@RunWith(XtextRunner.class)
@InjectWith(N4JSInjectorProvider.class)
public class N6_1_17_BinaryBitwiseExpressionTypesystemTest extends AbstractOperatorExpressionTypesystemTest {

	@Test
	public void testType() {
		for (JavaScriptVariant mode : JavaScriptVariant.nonDepricatedValues()) {
			for (String op : List.of("&", "^", "|")) {
				assertOperatorType(mode, "number", "n1 " + op + " n2");
				assertOperatorType(mode, "number", "s1 " + op + " s2");
				assertOperatorType(mode, "number", "s1 " + op + " n2");
				assertOperatorType(mode, "number", "a " + op + " b");

			}
		}
	}

	@Test
	public void testExpectedType_NonStrict() {
		for (String op : List.of("&", "^", "|")) {
			assertBinaryOperatorExpectedType(unrestricted, "any", "any", "n1 " + op + " n2");
			assertBinaryOperatorExpectedType(unrestricted, "any", "any", "s1 " + op + " s2");
			assertBinaryOperatorExpectedType(unrestricted, "any", "any", "s1 " + op + " f1");
			assertBinaryOperatorExpectedType(unrestricted, "any", "any", "s1 " + op + " a");
			assertBinaryOperatorExpectedType(unrestricted, "any", "any", "a " + op + " a");
			assertBinaryOperatorExpectedType(unrestricted, "any", "any", "a " + op + " b");
			assertBinaryOperatorExpectedType(strict, "any", "any", "n1 " + op + " n2");
			assertBinaryOperatorExpectedType(strict, "any", "any", "s1 " + op + " s2");
			assertBinaryOperatorExpectedType(strict, "any", "any", "s1 " + op + " f1");
			assertBinaryOperatorExpectedType(strict, "any", "any", "s1 " + op + " a");
			assertBinaryOperatorExpectedType(strict, "any", "any", "a " + op + " a");
			assertBinaryOperatorExpectedType(strict, "any", "any", "a " + op + " b");
			assertBinaryOperatorExpectedType(n4js, "number", "number", "n1 " + op + " n2");
			assertBinaryOperatorExpectedType(n4js, "number", "number", "s1 " + op + " s2");
			assertBinaryOperatorExpectedType(n4js, "number", "number", "s1 " + op + " f1");
			assertBinaryOperatorExpectedType(n4js, "number", "number", "s1 " + op + " a");
			assertBinaryOperatorExpectedType(n4js, "number", "number", "a " + op + " a");
			assertBinaryOperatorExpectedType(n4js, "number", "number", "a " + op + " b");

		}
	}

}
