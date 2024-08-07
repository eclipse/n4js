/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021 by studentmain (initial contribution)
 * Copyright (c) 2022 by NumberFour AG (contributor -> overall restructuring and d.ts support)
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package org.eclipse.n4js.dts;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

/**
 * All lexer methods that used in grammar (IsStrictMode) should start with Upper Case Char similar to Lexer rules.
 */
public abstract class TypeScriptLexerBase extends Lexer {

	private Token lastToken = null;
	/** Default value of strict mode Can be defined externally by setUseStrictDefault */
	private boolean useStrictDefault = false;
	/** Current value of strict mode Can be defined during parsing, see StringFunctions.js and StringGlobal.js sample */
	private boolean useStrictCurrent = false;
	/**
	 * Keeps track of the the current depth of nested template string backticks. E.g. after the X in:
	 *
	 * `${a ? `${X
	 *
	 * templateDepth will be 2. This variable is needed to determine if a `}` is a plain CloseBrace, or one that closes
	 * an expression inside a template string.
	 */
	private int templateDepth = 0;

	/** Constructor */
	public TypeScriptLexerBase(CharStream input) {
		super(input);
	}

	/** @return {@code true} iff use strict is enabled as default */
	public boolean getStrictDefault() {
		return useStrictDefault;
	}

	/** Enables/disables strict mode */
	public void setUseStrictDefault(boolean value) {
		useStrictDefault = value;
		useStrictCurrent = value;
	}

	/**
	 * @return {@code true} iff strict mode is active
	 * @implNote method name starts with upper case latter: see {@link #TypeScriptLexerBase}
	 */
	public boolean IsStrictMode() {
		return useStrictCurrent;
	}

	/**
	 * @return {@code true} iff the cursor is inside a template string
	 * @implNote method name starts with upper case latter: see {@link #TypeScriptLexerBase}
	 */
	public boolean IsInTemplateString() {
		return this.templateDepth > 0;
	}

	/** Pops the current mode iff the cursor is inside a template string. */
	public void popModeIfInTamplateString() {
		if (IsInTemplateString()) {
			popMode();
		}
	}

	/**
	 * Return the next token from the character stream and records this last token in case it resides on the default
	 * channel. This recorded token is used to determine when the lexer could possibly match a regex literal. Also
	 * changes scopeStrictModes stack if tokenize special string 'use strict';
	 *
	 * @return the next token from the character stream.
	 */
	@Override
	public Token nextToken() {
		Token next = super.nextToken();

		if (next.getChannel() == Token.DEFAULT_CHANNEL) {
			// Keep track of the last token on the default channel.
			this.lastToken = next;
		}

		return next;
	}

	/**
	 * Increases template depth count by one
	 *
	 * @implNote method name starts with upper case latter: see {@link #TypeScriptLexerBase}
	 */
	protected void IncreaseTemplateDepth() {
		this.templateDepth++;
	}

	/**
	 * Decreases template depth count by one
	 *
	 * @implNote method name starts with upper case latter: see {@link #TypeScriptLexerBase}
	 */
	protected void DecreaseTemplateDepth() {
		this.templateDepth--;
	}

	/**
	 * Returns {@code true} if the lexer can match a regex literal.
	 *
	 * @implNote method name starts with upper case latter: see {@link #TypeScriptLexerBase}
	 */
	protected boolean IsRegexPossible() {
		if (this.lastToken == null) {
			// No token has been produced yet: at the start of the input,
			// no division is possible, so a regex literal _is_ possible.
			return true;
		}

		switch (this.lastToken.getType()) {
		case TypeScriptLexer.Identifier:
		case TypeScriptLexer.NullLiteral:
		case TypeScriptLexer.BooleanLiteral:
		case TypeScriptLexer.This:
		case TypeScriptLexer.CloseBracket:
		case TypeScriptLexer.CloseParen:
		case TypeScriptLexer.OctalIntegerLiteral:
		case TypeScriptLexer.DecimalLiteral:
		case TypeScriptLexer.HexIntegerLiteral:
		case TypeScriptLexer.StringLiteral:
		case TypeScriptLexer.PlusPlus:
		case TypeScriptLexer.MinusMinus:
			// After any of the tokens above, no regex literal can follow.
			return false;
		default:
			// In all other cases, a regex literal _is_ possible.
			return true;
		}
	}
}