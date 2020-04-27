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
package org.eclipse.n4js.ui.editor.syntaxcoloring;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.n4js.parser.LazyTokenStream;
import org.eclipse.n4js.parser.RegExLiteralAwareLexer;
import org.eclipse.n4js.parser.SemicolonInjectionHelper;
import org.eclipse.n4js.services.N4JSGrammarAccess;
import org.eclipse.xtext.AbstractElement;

/**
 * Subclass of the generated highlighting parser which implements the method stubs that are put into the generated code.
 *
 * This logic is used to implement ASI, RegEx disambiguation and template literals.
 */
public class InternalHighlightingParser extends InternalN4JSParser implements SemicolonInjectionHelper.Callback {

	private final TokenTypeRewriter rewriter;
	private final RecoverySets recoverySets;

	private NoViableAltException asiRecoveredEx = null;

	@Override
	public boolean allowASI(final RecognitionException re) {
		if (re instanceof NoViableAltException) {
			final NoViableAltException nvae = (NoViableAltException) re;
			if (asiRecoveredEx != null && re.index == asiRecoveredEx.index
					&& nvae.decisionNumber == asiRecoveredEx.decisionNumber) {
				return false;
			}
			asiRecoveredEx = nvae;
		}
		return true;
	}

	/**
	 * Protected to allow access from subtypes and same package.
	 */
	protected InternalHighlightingParser(TokenStream input, N4JSGrammarAccess grammarAccess,
			TokenTypeRewriter rewriter) {
		super(input, grammarAccess);
		this.rewriter = rewriter;
		this.recoverySets = computeRecoverySets();
	}

	@Override
	public RecoverySets getRecoverySets() {
		return recoverySets;
	}

	@Override
	public int getCommaBit() {
		return Comma;
	}

	/**
	 * Assign the regular expression mode to the {@link RegExLiteralAwareLexer lexer}. This method is called from
	 * {@link #ruleREGEX_LITERAL()}.
	 * <p>
	 * Overrides method stub generated by customized ANTLR/Xtext generator.
	 * </p>
	 */
	@Override
	protected void setInRegularExpression() {
		if (!hasBufferedTokens()) {
			RegExLiteralAwareLexer lexer = (RegExLiteralAwareLexer) this.input.getTokenSource();
			lexer.setInRegularExpression();
		}
	}

	/**
	 * Assign the template mode {@link RegExLiteralAwareLexer lexer}. This method is called from
	 * {@link #ruleTemplateExpressionEnd()}.
	 * <p>
	 * Overrides method stub generated by customized ANTLR/Xtext generator.
	 * </p>
	 */
	@Override
	protected void setInTemplateSegment() {
		if (!hasBufferedTokens()) {
			RegExLiteralAwareLexer lexer = (RegExLiteralAwareLexer) this.input.getTokenSource();
			lexer.setInTemplateSegment();
		}
	}

	@Override
	protected boolean setInJsxChildren() {
		if (!hasBufferedTokens()) {
			RegExLiteralAwareLexer lexer = (RegExLiteralAwareLexer) this.input.getTokenSource();
			lexer.setInJsxChildren();
		}
		return true;
	}

	private boolean hasBufferedTokens() {
		return input.index() < input.size() - 1;
	}

	@Override
	public void addASIMessage() {
		// nothing to do
	}

	@Override
	public void discardError() {
		// nothing to do
	}

	@Override
	public RecognizerSharedState getState() {
		return state;
	}

	@Override
	public void recoverBase(IntStream inputStream, RecognitionException re) {
		super.recover(inputStream, re);
	}

	/**
	 * Recover from an error found on the input stream. This is for {@link NoViableAltException} and
	 * {@link MismatchedTokenException}. If you enable single token insertion and deletion, this will usually not handle
	 * mismatched symbol exceptions but there could be a mismatched token that the {@link #match(IntStream, int, BitSet)
	 * match} routine could not recover from.
	 */
	@Override
	public void recover(IntStream inputStream, RecognitionException re) {
		SemicolonInjectionHelper.recover(inputStream, re, this);
	}

	@Override
	public BitSet getSemicolonFollowSet() {
		return FOLLOW_ruleExpression_in_ruleExpressionStatement;
	}

	/**
	 * <p>
	 * Overrides method stub generated by customized ANTLR/Xtext generator.
	 * </p>
	 */
	@Override
	protected boolean forcedRewind(int position) {
		input.seek(position);
		addASIMessage();
		return true;
	}

	/**
	 * <p>
	 * Promotes EOL which may lead to an automatically inserted semicolon. This is probably the most important method
	 * for automatic semicolon insertion, as it is only possible to insert a semicolon in case of line breaks (even if
	 * they are hidden in a multi-line comment!).
	 * </p>
	 * <p>
	 * Overrides method stub generated by customized ANTLR/Xtext generator.
	 * </p>
	 */
	@Override
	protected void promoteEOL() {
		SemicolonInjectionHelper.promoteEOL(this);
	}

	/**
	 * Overrides method stub generated by customized ANTLR/Xtext generator.
	 */
	@Override
	protected boolean hasDisallowedEOL() {
		return SemicolonInjectionHelper.hasDisallowedEOL(this);
	}

	@Override
	protected void announce(Token token, AbstractElement element) {
		rewriter.rewrite((CommonToken) token, element);
	}

	@Override
	protected void announce(Token start, Token stop, AbstractElement element) {
		if (start != null && start != Token.EOF_TOKEN) {
			if (start == stop) {
				announce(start, element);
			} else {
				CommonToken castedStart = (CommonToken) start;
				if (stop == null) { // possible error condition
					if (start.getTokenIndex() == state.lastErrorIndex) {
						return;
					}
				}
				CommonToken castedEnd = (CommonToken) stop;
				Integer newType = rewriter.rewrite(castedStart, element);
				if (newType != null && castedEnd != null && castedEnd != Token.EOF_TOKEN) {
					LazyTokenStream castedInput = (LazyTokenStream) this.input;
					for (int i = castedStart.getTokenIndex() + 1; i < castedEnd.getTokenIndex(); i++) {
						Token token = castedInput.get(i);
						if (token.getChannel() != Token.HIDDEN_CHANNEL)
							token.setType(newType);
					}
					castedEnd.setType(newType);
				}
			}
		}
	}
}
