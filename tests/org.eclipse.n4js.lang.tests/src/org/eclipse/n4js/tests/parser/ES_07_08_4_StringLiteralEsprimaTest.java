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

import static org.eclipse.xtext.xbase.lib.IterableExtensions.last;

import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.n4js.n4JS.ExpressionStatement;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.n4JS.ScriptElement;
import org.eclipse.n4js.n4JS.StringLiteral;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;

public class ES_07_08_4_StringLiteralEsprimaTest extends AbstractParserTest {

	@Test
	public void testHello() {
		Script script = parseESSuccessfully("\"Hello\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello", stringLiteral.getValue());
	}

	/* This test source code might behave strange when editing */
	@Test
	public void testEscapeSequences() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("\"\\n\\r\\t\\v\\b\\f\\\\\\\'\\\"\\0\"");
		final Script script = this.parseESSuccessfully(_builder);
		ScriptElement _head = IterableExtensions.<ScriptElement> head(script.getScriptElements());
		final ExpressionStatement statement = ((ExpressionStatement) _head);
		Expression _expression = statement.getExpression();
		final StringLiteral stringLiteral = ((StringLiteral) _expression);
		assertEquals("\n\r\t\b\f\\\'\" ", stringLiteral.getValue());
		StringConcatenation _builder_1 = new StringConcatenation();
		_builder_1.append("\"\\n\\r\\t\\v\\b\\f\\\\\\\'\\\"\\0\"");
		assertEquals(_builder_1.toString(), stringLiteral.getRawValue());
	}

	@Test
	public void testUnicodeEscapeSequence_01() {
		Script script = parseESSuccessfully("\"\u0061\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("a", stringLiteral.getValue());
	}

	@Test
	public void testUnicodeEscapeSequence_02() {
		Script script = parseESSuccessfully("\"\\u{0061}\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("a", stringLiteral.getValue());
	}

	@Test
	public void testUnicodeEscapeSequence_03() {
		Script script = parseESSuccessfully("\"\\u{61}\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("a", stringLiteral.getValue());
	}

	@Test
	public void testHexEscapeSequence() {
		Script script = parseESSuccessfully("\"\\x61\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("a", stringLiteral.getValue());
	}

	@Test
	public void testIncompleteUnicodeEscapeSequence_01() {
		Script script = parseESWithError("\"\\u00\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("u00", stringLiteral.getValue());
	}

	@Test
	public void testIncompleteUnicodeEscapeSequence_02() {
		Script script = parseESWithError("\"\\u{00\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("u{00", stringLiteral.getValue());
	}

	@Test
	public void testIncompleteUnicodeEscapeSequence_03() {
		Script script = parseESWithError("\"\\u{}\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("u{}", stringLiteral.getValue());
	}

	@Test
	public void testIncompleteHexEscapeSequence() {
		Script script = parseESWithError("\"\\xt\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("xt", stringLiteral.getValue());
	}

	@Test
	public void testLineBreak() {
		Script script = parseESSuccessfully("\"Hello\\nworld\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\nworld", stringLiteral.getValue());
	}

	@Test
	public void testLineContinuation_01() {
		Script script = parseESSuccessfully("\"Hello\\\nworld\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Helloworld", stringLiteral.getValue());
	}

	@Test
	public void testLineContinuation_02() {
		Script script = parseESSuccessfully("\"Hello\\\r\nworld\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Helloworld", stringLiteral.getValue());
	}

	@Test
	public void testInvalidContinuation() {
		Script script = parseESSuccessfully("\"Hello\02World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\u0002World", stringLiteral.getValue());
	}

	@Test
	public void testOctalSequence() {
		Script script = parseESSuccessfully("\"Hello\\012World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\nWorld", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscape_01() {
		Script script = parseESSuccessfully("\"Hello\112World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("HelloJWorld", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscape_02() {
		Script script = parseESSuccessfully("\"Hello\0112World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\t2World", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscape_03() {
		Script script = parseESSuccessfully("\"Hello\\312World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\u00CAWorld", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscape_04() {
		Script script = parseESSuccessfully("\"Hello\\412World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello!2World", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscape_05() {
		Script script = parseESSuccessfully("\"Hello\\812World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello812World", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscape_06() {
		Script script = parseESSuccessfully("\"Hello\\712World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello92World", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscape_07() {
		Script script = parseESSuccessfully("\"Hello\\1World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\u0001World", stringLiteral.getValue());
	}

	@Test
	public void testNULEscape() {
		Script script = parseESSuccessfully("\"Hello\\0World\"");
		ExpressionStatement statement = (ExpressionStatement) script.getScriptElements().get(0);
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\u0000World", stringLiteral.getValue());
	}

	// NOTE: strict mode is validated in the validation, not in the parser
	@Test
	public void testOctalEscapeStrictMode_01() {
		Script script = parseESWithError("'use strict';\"Hello\\112World\"");
		ExpressionStatement statement = (ExpressionStatement) last(script.getScriptElements());
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("HelloJWorld", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscapeStrictMode_02() {
		Script script = parseESWithError("'use strict';\"Hello\\0112World\"");
		ExpressionStatement statement = (ExpressionStatement) last(script.getScriptElements());
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\t2World", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscapeStrictMode_03() {
		Script script = parseESWithError("'use strict';\"Hello\\312World\"");
		ExpressionStatement statement = (ExpressionStatement) last(script.getScriptElements());
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\u00CAWorld", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscapeStrictMode_04() {
		Script script = parseESWithError("'use strict';\"Hello\\412World\"");
		ExpressionStatement statement = (ExpressionStatement) last(script.getScriptElements());
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello!2World", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscapeStrictMode_05() {
		Script script = parseESWithError("'use strict';\"Hello\\812World\"");
		ExpressionStatement statement = (ExpressionStatement) last(script.getScriptElements());
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello812World", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscapeStrictMode_06() {
		Script script = parseESWithError("'use strict';\"Hello\\712World\"");
		ExpressionStatement statement = (ExpressionStatement) last(script.getScriptElements());
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello92World", stringLiteral.getValue());
	}

	@Test
	public void testOctalEscapeStrictMode_07() {
		Script script = parseESWithError("'use strict';\"Hello\\1World\"");
		ExpressionStatement statement = (ExpressionStatement) last(script.getScriptElements());
		StringLiteral stringLiteral = (StringLiteral) statement.getExpression();
		assertEquals("Hello\u0001World", stringLiteral.getValue());
	}

}
