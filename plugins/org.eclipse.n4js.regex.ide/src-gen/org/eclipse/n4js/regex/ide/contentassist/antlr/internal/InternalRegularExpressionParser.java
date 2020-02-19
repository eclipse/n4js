package org.eclipse.n4js.regex.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.n4js.regex.services.RegularExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * Copyright (c) 2017 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
@SuppressWarnings("all")
public class InternalRegularExpressionParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LeftParenthesisQuestionMarkLessThanSignExclamationMark", "LeftParenthesisQuestionMarkLessThanSignEqualsSign", "LeftParenthesisQuestionMarkExclamationMark", "LeftParenthesisQuestionMarkColon", "LeftParenthesisQuestionMarkLessThanSign", "LeftParenthesisQuestionMarkEqualsSign", "LeftParenthesisQuestionMark", "ExclamationMark", "DollarSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "QuestionMark", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "KW__", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_WORD_BOUNDARY", "RULE_NOT_WORD_BOUNDARY", "RULE_CHARACTER_CLASS_ESCAPE", "RULE_CONTROL_ESCAPE", "RULE_CONTROL_LETTER_ESCAPE", "RULE_HEX_DIGIT", "RULE_HEX_ESCAPE", "RULE_UNICODE_ESCAPE", "RULE_DECIMAL_INTEGER_LITERAL_FRAGMENT", "RULE_DECIMAL_ESCAPE", "RULE_IDENTITY_ESCAPE", "RULE_UNICODE_DIGIT_FRAGMENT", "RULE_UNICODE_DIGIT", "RULE_UNICODE_LETTER_FRAGMENT", "RULE_UNICODE_LETTER", "RULE_PATTERN_CHARACTER_NO_DASH", "RULE_DECIMAL_DIGIT_FRAGMENT", "RULE_ZWJ", "RULE_ZWNJ", "RULE_BOM", "RULE_UNICODE_SPACE_SEPARATOR_FRAGMENT", "RULE_WHITESPACE_FRAGMENT", "RULE_LINE_TERMINATOR_FRAGMENT", "RULE_LINE_TERMINATOR_SEQUENCE_FRAGMENT", "RULE_SL_COMMENT_FRAGMENT", "RULE_ML_COMMENT_FRAGMENT", "RULE_UNICODE_COMBINING_MARK_FRAGMENT", "RULE_UNICODE_CONNECTOR_PUNCTUATION_FRAGMENT", "RULE_ANY_OTHER"
    };
    public static final int LeftParenthesisQuestionMarkLessThanSignEqualsSign=5;
    public static final int LessThanSign=22;
    public static final int LeftParenthesisQuestionMark=10;
    public static final int RULE_WHITESPACE_FRAGMENT=54;
    public static final int LeftParenthesis=13;
    public static final int RULE_HEX_ESCAPE=39;
    public static final int RightSquareBracket=27;
    public static final int ExclamationMark=11;
    public static final int GreaterThanSign=24;
    public static final int RULE_CONTROL_LETTER_ESCAPE=37;
    public static final int RULE_LINE_TERMINATOR_SEQUENCE_FRAGMENT=56;
    public static final int RightParenthesis=14;
    public static final int RULE_UNICODE_COMBINING_MARK_FRAGMENT=59;
    public static final int LeftParenthesisQuestionMarkLessThanSignExclamationMark=4;
    public static final int LeftParenthesisQuestionMarkExclamationMark=6;
    public static final int LeftParenthesisQuestionMarkColon=7;
    public static final int RULE_ZWNJ=51;
    public static final int VerticalLine=31;
    public static final int PlusSign=16;
    public static final int LeftSquareBracket=26;
    public static final int RULE_DECIMAL_ESCAPE=42;
    public static final int LeftParenthesisQuestionMarkLessThanSign=8;
    public static final int RULE_ML_COMMENT_FRAGMENT=58;
    public static final int RULE_PATTERN_CHARACTER_NO_DASH=48;
    public static final int RULE_WORD_BOUNDARY=33;
    public static final int RULE_UNICODE_ESCAPE=40;
    public static final int Comma=17;
    public static final int EqualsSign=23;
    public static final int RULE_ZWJ=50;
    public static final int RULE_SL_COMMENT_FRAGMENT=57;
    public static final int HyphenMinus=18;
    public static final int RULE_UNICODE_DIGIT_FRAGMENT=44;
    public static final int RULE_UNICODE_LETTER=47;
    public static final int RULE_CONTROL_ESCAPE=36;
    public static final int RULE_UNICODE_SPACE_SEPARATOR_FRAGMENT=53;
    public static final int Solidus=20;
    public static final int Colon=21;
    public static final int RightCurlyBracket=32;
    public static final int RULE_CHARACTER_CLASS_ESCAPE=35;
    public static final int EOF=-1;
    public static final int Asterisk=15;
    public static final int FullStop=19;
    public static final int RULE_UNICODE_DIGIT=45;
    public static final int LeftParenthesisQuestionMarkEqualsSign=9;
    public static final int RULE_BOM=52;
    public static final int LeftCurlyBracket=30;
    public static final int RULE_ANY_OTHER=61;
    public static final int CircumflexAccent=28;
    public static final int RULE_NOT_WORD_BOUNDARY=34;
    public static final int KW__=29;
    public static final int RULE_LINE_TERMINATOR_FRAGMENT=55;
    public static final int RULE_UNICODE_LETTER_FRAGMENT=46;
    public static final int RULE_DECIMAL_DIGIT_FRAGMENT=49;
    public static final int QuestionMark=25;
    public static final int DollarSign=12;
    public static final int RULE_HEX_DIGIT=38;
    public static final int RULE_DECIMAL_INTEGER_LITERAL_FRAGMENT=41;
    public static final int RULE_IDENTITY_ESCAPE=43;
    public static final int RULE_UNICODE_CONNECTOR_PUNCTUATION_FRAGMENT=60;

    // delegates
    // delegators


        public InternalRegularExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRegularExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRegularExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRegularExpressionParser.g"; }


    	private RegularExpressionGrammarAccess grammarAccess;
    	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
    	
    	{
    		tokenNameToValue.put("ExclamationMark", "'!'");
    		tokenNameToValue.put("DollarSign", "'\\u0024'");
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("Asterisk", "'*'");
    		tokenNameToValue.put("PlusSign", "'+'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("HyphenMinus", "'-'");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Solidus", "'/'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("LessThanSign", "'<'");
    		tokenNameToValue.put("EqualsSign", "'='");
    		tokenNameToValue.put("GreaterThanSign", "'>'");
    		tokenNameToValue.put("QuestionMark", "'?'");
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
    		tokenNameToValue.put("CircumflexAccent", "'^'");
    		tokenNameToValue.put("KW__", "'_'");
    		tokenNameToValue.put("LeftCurlyBracket", "'{'");
    		tokenNameToValue.put("VerticalLine", "'|'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("LeftParenthesisQuestionMark", "'(?'");
    		tokenNameToValue.put("LeftParenthesisQuestionMarkExclamationMark", "'(?!'");
    		tokenNameToValue.put("LeftParenthesisQuestionMarkColon", "'(?:'");
    		tokenNameToValue.put("LeftParenthesisQuestionMarkLessThanSign", "'(?<'");
    		tokenNameToValue.put("LeftParenthesisQuestionMarkEqualsSign", "'(?='");
    		tokenNameToValue.put("LeftParenthesisQuestionMarkLessThanSignExclamationMark", "'(?<!'");
    		tokenNameToValue.put("LeftParenthesisQuestionMarkLessThanSignEqualsSign", "'(?<='");
    	}

    	public void setGrammarAccess(RegularExpressionGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		String result = tokenNameToValue.get(tokenName);
    		if (result == null)
    			result = tokenName;
    		return result;
    	}



    // $ANTLR start "entryRuleRegularExpressionLiteral"
    // InternalRegularExpressionParser.g:92:1: entryRuleRegularExpressionLiteral : ruleRegularExpressionLiteral EOF ;
    public final void entryRuleRegularExpressionLiteral() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:93:1: ( ruleRegularExpressionLiteral EOF )
            // InternalRegularExpressionParser.g:94:1: ruleRegularExpressionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRegularExpressionLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegularExpressionLiteral"


    // $ANTLR start "ruleRegularExpressionLiteral"
    // InternalRegularExpressionParser.g:101:1: ruleRegularExpressionLiteral : ( ( rule__RegularExpressionLiteral__Group__0 ) ) ;
    public final void ruleRegularExpressionLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:105:2: ( ( ( rule__RegularExpressionLiteral__Group__0 ) ) )
            // InternalRegularExpressionParser.g:106:2: ( ( rule__RegularExpressionLiteral__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:106:2: ( ( rule__RegularExpressionLiteral__Group__0 ) )
            // InternalRegularExpressionParser.g:107:3: ( rule__RegularExpressionLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionLiteralAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:108:3: ( rule__RegularExpressionLiteral__Group__0 )
            // InternalRegularExpressionParser.g:108:4: rule__RegularExpressionLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RegularExpressionLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegularExpressionLiteral"


    // $ANTLR start "entryRuleRegularExpressionBody"
    // InternalRegularExpressionParser.g:117:1: entryRuleRegularExpressionBody : ruleRegularExpressionBody EOF ;
    public final void entryRuleRegularExpressionBody() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:118:1: ( ruleRegularExpressionBody EOF )
            // InternalRegularExpressionParser.g:119:1: ruleRegularExpressionBody EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionBodyRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRegularExpressionBody();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionBodyRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegularExpressionBody"


    // $ANTLR start "ruleRegularExpressionBody"
    // InternalRegularExpressionParser.g:126:1: ruleRegularExpressionBody : ( ( rule__RegularExpressionBody__PatternAssignment ) ) ;
    public final void ruleRegularExpressionBody() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:130:2: ( ( ( rule__RegularExpressionBody__PatternAssignment ) ) )
            // InternalRegularExpressionParser.g:131:2: ( ( rule__RegularExpressionBody__PatternAssignment ) )
            {
            // InternalRegularExpressionParser.g:131:2: ( ( rule__RegularExpressionBody__PatternAssignment ) )
            // InternalRegularExpressionParser.g:132:3: ( rule__RegularExpressionBody__PatternAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionBodyAccess().getPatternAssignment()); 
            }
            // InternalRegularExpressionParser.g:133:3: ( rule__RegularExpressionBody__PatternAssignment )
            // InternalRegularExpressionParser.g:133:4: rule__RegularExpressionBody__PatternAssignment
            {
            pushFollow(FOLLOW_2);
            rule__RegularExpressionBody__PatternAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionBodyAccess().getPatternAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegularExpressionBody"


    // $ANTLR start "entryRuleDisjunction"
    // InternalRegularExpressionParser.g:142:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:143:1: ( ruleDisjunction EOF )
            // InternalRegularExpressionParser.g:144:1: ruleDisjunction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDisjunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // InternalRegularExpressionParser.g:151:1: ruleDisjunction : ( ( rule__Disjunction__Alternatives ) ) ;
    public final void ruleDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:155:2: ( ( ( rule__Disjunction__Alternatives ) ) )
            // InternalRegularExpressionParser.g:156:2: ( ( rule__Disjunction__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:156:2: ( ( rule__Disjunction__Alternatives ) )
            // InternalRegularExpressionParser.g:157:3: ( rule__Disjunction__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:158:3: ( rule__Disjunction__Alternatives )
            // InternalRegularExpressionParser.g:158:4: rule__Disjunction__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleAlternative"
    // InternalRegularExpressionParser.g:167:1: entryRuleAlternative : ruleAlternative EOF ;
    public final void entryRuleAlternative() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:168:1: ( ruleAlternative EOF )
            // InternalRegularExpressionParser.g:169:1: ruleAlternative EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlternativeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAlternative();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlternativeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAlternative"


    // $ANTLR start "ruleAlternative"
    // InternalRegularExpressionParser.g:176:1: ruleAlternative : ( ( rule__Alternative__Group__0 ) ) ;
    public final void ruleAlternative() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:180:2: ( ( ( rule__Alternative__Group__0 ) ) )
            // InternalRegularExpressionParser.g:181:2: ( ( rule__Alternative__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:181:2: ( ( rule__Alternative__Group__0 ) )
            // InternalRegularExpressionParser.g:182:3: ( rule__Alternative__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlternativeAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:183:3: ( rule__Alternative__Group__0 )
            // InternalRegularExpressionParser.g:183:4: rule__Alternative__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Alternative__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlternativeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternative"


    // $ANTLR start "entryRuleTerm"
    // InternalRegularExpressionParser.g:192:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:193:1: ( ruleTerm EOF )
            // InternalRegularExpressionParser.g:194:1: ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalRegularExpressionParser.g:201:1: ruleTerm : ( ( rule__Term__Alternatives ) ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:205:2: ( ( ( rule__Term__Alternatives ) ) )
            // InternalRegularExpressionParser.g:206:2: ( ( rule__Term__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:206:2: ( ( rule__Term__Alternatives ) )
            // InternalRegularExpressionParser.g:207:3: ( rule__Term__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:208:3: ( rule__Term__Alternatives )
            // InternalRegularExpressionParser.g:208:4: rule__Term__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Term__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAssertion"
    // InternalRegularExpressionParser.g:217:1: entryRuleAssertion : ruleAssertion EOF ;
    public final void entryRuleAssertion() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:218:1: ( ruleAssertion EOF )
            // InternalRegularExpressionParser.g:219:1: ruleAssertion EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssertionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAssertion();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssertionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssertion"


    // $ANTLR start "ruleAssertion"
    // InternalRegularExpressionParser.g:226:1: ruleAssertion : ( ( rule__Assertion__Alternatives ) ) ;
    public final void ruleAssertion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:230:2: ( ( ( rule__Assertion__Alternatives ) ) )
            // InternalRegularExpressionParser.g:231:2: ( ( rule__Assertion__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:231:2: ( ( rule__Assertion__Alternatives ) )
            // InternalRegularExpressionParser.g:232:3: ( rule__Assertion__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssertionAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:233:3: ( rule__Assertion__Alternatives )
            // InternalRegularExpressionParser.g:233:4: rule__Assertion__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Assertion__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssertionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssertion"


    // $ANTLR start "entryRuleLineStart"
    // InternalRegularExpressionParser.g:242:1: entryRuleLineStart : ruleLineStart EOF ;
    public final void entryRuleLineStart() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:243:1: ( ruleLineStart EOF )
            // InternalRegularExpressionParser.g:244:1: ruleLineStart EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLineStartRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLineStart();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLineStartRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLineStart"


    // $ANTLR start "ruleLineStart"
    // InternalRegularExpressionParser.g:251:1: ruleLineStart : ( ( rule__LineStart__Group__0 ) ) ;
    public final void ruleLineStart() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:255:2: ( ( ( rule__LineStart__Group__0 ) ) )
            // InternalRegularExpressionParser.g:256:2: ( ( rule__LineStart__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:256:2: ( ( rule__LineStart__Group__0 ) )
            // InternalRegularExpressionParser.g:257:3: ( rule__LineStart__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLineStartAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:258:3: ( rule__LineStart__Group__0 )
            // InternalRegularExpressionParser.g:258:4: rule__LineStart__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LineStart__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLineStartAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLineStart"


    // $ANTLR start "entryRuleLineEnd"
    // InternalRegularExpressionParser.g:267:1: entryRuleLineEnd : ruleLineEnd EOF ;
    public final void entryRuleLineEnd() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:268:1: ( ruleLineEnd EOF )
            // InternalRegularExpressionParser.g:269:1: ruleLineEnd EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLineEndRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLineEnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLineEndRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLineEnd"


    // $ANTLR start "ruleLineEnd"
    // InternalRegularExpressionParser.g:276:1: ruleLineEnd : ( ( rule__LineEnd__Group__0 ) ) ;
    public final void ruleLineEnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:280:2: ( ( ( rule__LineEnd__Group__0 ) ) )
            // InternalRegularExpressionParser.g:281:2: ( ( rule__LineEnd__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:281:2: ( ( rule__LineEnd__Group__0 ) )
            // InternalRegularExpressionParser.g:282:3: ( rule__LineEnd__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLineEndAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:283:3: ( rule__LineEnd__Group__0 )
            // InternalRegularExpressionParser.g:283:4: rule__LineEnd__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LineEnd__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLineEndAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLineEnd"


    // $ANTLR start "entryRuleWordBoundary"
    // InternalRegularExpressionParser.g:292:1: entryRuleWordBoundary : ruleWordBoundary EOF ;
    public final void entryRuleWordBoundary() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:293:1: ( ruleWordBoundary EOF )
            // InternalRegularExpressionParser.g:294:1: ruleWordBoundary EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWordBoundaryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleWordBoundary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWordBoundaryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWordBoundary"


    // $ANTLR start "ruleWordBoundary"
    // InternalRegularExpressionParser.g:301:1: ruleWordBoundary : ( ( rule__WordBoundary__Group__0 ) ) ;
    public final void ruleWordBoundary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:305:2: ( ( ( rule__WordBoundary__Group__0 ) ) )
            // InternalRegularExpressionParser.g:306:2: ( ( rule__WordBoundary__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:306:2: ( ( rule__WordBoundary__Group__0 ) )
            // InternalRegularExpressionParser.g:307:3: ( rule__WordBoundary__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWordBoundaryAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:308:3: ( rule__WordBoundary__Group__0 )
            // InternalRegularExpressionParser.g:308:4: rule__WordBoundary__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WordBoundary__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWordBoundaryAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWordBoundary"


    // $ANTLR start "entryRuleAbstractLookAhead"
    // InternalRegularExpressionParser.g:317:1: entryRuleAbstractLookAhead : ruleAbstractLookAhead EOF ;
    public final void entryRuleAbstractLookAhead() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:318:1: ( ruleAbstractLookAhead EOF )
            // InternalRegularExpressionParser.g:319:1: ruleAbstractLookAhead EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAbstractLookAhead();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractLookAhead"


    // $ANTLR start "ruleAbstractLookAhead"
    // InternalRegularExpressionParser.g:326:1: ruleAbstractLookAhead : ( ( rule__AbstractLookAhead__Group__0 ) ) ;
    public final void ruleAbstractLookAhead() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:330:2: ( ( ( rule__AbstractLookAhead__Group__0 ) ) )
            // InternalRegularExpressionParser.g:331:2: ( ( rule__AbstractLookAhead__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:331:2: ( ( rule__AbstractLookAhead__Group__0 ) )
            // InternalRegularExpressionParser.g:332:3: ( rule__AbstractLookAhead__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:333:3: ( rule__AbstractLookAhead__Group__0 )
            // InternalRegularExpressionParser.g:333:4: rule__AbstractLookAhead__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractLookAhead"


    // $ANTLR start "entryRuleAtom"
    // InternalRegularExpressionParser.g:342:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:343:1: ( ruleAtom EOF )
            // InternalRegularExpressionParser.g:344:1: ruleAtom EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalRegularExpressionParser.g:351:1: ruleAtom : ( ( rule__Atom__Alternatives ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:355:2: ( ( ( rule__Atom__Alternatives ) ) )
            // InternalRegularExpressionParser.g:356:2: ( ( rule__Atom__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:356:2: ( ( rule__Atom__Alternatives ) )
            // InternalRegularExpressionParser.g:357:3: ( rule__Atom__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:358:3: ( rule__Atom__Alternatives )
            // InternalRegularExpressionParser.g:358:4: rule__Atom__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRulePatternCharacter"
    // InternalRegularExpressionParser.g:367:1: entryRulePatternCharacter : rulePatternCharacter EOF ;
    public final void entryRulePatternCharacter() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:368:1: ( rulePatternCharacter EOF )
            // InternalRegularExpressionParser.g:369:1: rulePatternCharacter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPatternCharacterRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePatternCharacter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPatternCharacterRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePatternCharacter"


    // $ANTLR start "rulePatternCharacter"
    // InternalRegularExpressionParser.g:376:1: rulePatternCharacter : ( ( rule__PatternCharacter__ValueAssignment ) ) ;
    public final void rulePatternCharacter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:380:2: ( ( ( rule__PatternCharacter__ValueAssignment ) ) )
            // InternalRegularExpressionParser.g:381:2: ( ( rule__PatternCharacter__ValueAssignment ) )
            {
            // InternalRegularExpressionParser.g:381:2: ( ( rule__PatternCharacter__ValueAssignment ) )
            // InternalRegularExpressionParser.g:382:3: ( rule__PatternCharacter__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPatternCharacterAccess().getValueAssignment()); 
            }
            // InternalRegularExpressionParser.g:383:3: ( rule__PatternCharacter__ValueAssignment )
            // InternalRegularExpressionParser.g:383:4: rule__PatternCharacter__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PatternCharacter__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPatternCharacterAccess().getValueAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePatternCharacter"


    // $ANTLR start "entryRuleWildcard"
    // InternalRegularExpressionParser.g:392:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:393:1: ( ruleWildcard EOF )
            // InternalRegularExpressionParser.g:394:1: ruleWildcard EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleWildcard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // InternalRegularExpressionParser.g:401:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:405:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // InternalRegularExpressionParser.g:406:2: ( ( rule__Wildcard__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:406:2: ( ( rule__Wildcard__Group__0 ) )
            // InternalRegularExpressionParser.g:407:3: ( rule__Wildcard__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:408:3: ( rule__Wildcard__Group__0 )
            // InternalRegularExpressionParser.g:408:4: rule__Wildcard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Wildcard__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleAtomEscape"
    // InternalRegularExpressionParser.g:417:1: entryRuleAtomEscape : ruleAtomEscape EOF ;
    public final void entryRuleAtomEscape() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:418:1: ( ruleAtomEscape EOF )
            // InternalRegularExpressionParser.g:419:1: ruleAtomEscape EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomEscapeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAtomEscape();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomEscapeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtomEscape"


    // $ANTLR start "ruleAtomEscape"
    // InternalRegularExpressionParser.g:426:1: ruleAtomEscape : ( ( rule__AtomEscape__Alternatives ) ) ;
    public final void ruleAtomEscape() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:430:2: ( ( ( rule__AtomEscape__Alternatives ) ) )
            // InternalRegularExpressionParser.g:431:2: ( ( rule__AtomEscape__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:431:2: ( ( rule__AtomEscape__Alternatives ) )
            // InternalRegularExpressionParser.g:432:3: ( rule__AtomEscape__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomEscapeAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:433:3: ( rule__AtomEscape__Alternatives )
            // InternalRegularExpressionParser.g:433:4: rule__AtomEscape__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AtomEscape__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomEscapeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtomEscape"


    // $ANTLR start "entryRuleCharacterClassEscapeSequence"
    // InternalRegularExpressionParser.g:442:1: entryRuleCharacterClassEscapeSequence : ruleCharacterClassEscapeSequence EOF ;
    public final void entryRuleCharacterClassEscapeSequence() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:443:1: ( ruleCharacterClassEscapeSequence EOF )
            // InternalRegularExpressionParser.g:444:1: ruleCharacterClassEscapeSequence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassEscapeSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCharacterClassEscapeSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassEscapeSequenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCharacterClassEscapeSequence"


    // $ANTLR start "ruleCharacterClassEscapeSequence"
    // InternalRegularExpressionParser.g:451:1: ruleCharacterClassEscapeSequence : ( ( rule__CharacterClassEscapeSequence__SequenceAssignment ) ) ;
    public final void ruleCharacterClassEscapeSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:455:2: ( ( ( rule__CharacterClassEscapeSequence__SequenceAssignment ) ) )
            // InternalRegularExpressionParser.g:456:2: ( ( rule__CharacterClassEscapeSequence__SequenceAssignment ) )
            {
            // InternalRegularExpressionParser.g:456:2: ( ( rule__CharacterClassEscapeSequence__SequenceAssignment ) )
            // InternalRegularExpressionParser.g:457:3: ( rule__CharacterClassEscapeSequence__SequenceAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassEscapeSequenceAccess().getSequenceAssignment()); 
            }
            // InternalRegularExpressionParser.g:458:3: ( rule__CharacterClassEscapeSequence__SequenceAssignment )
            // InternalRegularExpressionParser.g:458:4: rule__CharacterClassEscapeSequence__SequenceAssignment
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassEscapeSequence__SequenceAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassEscapeSequenceAccess().getSequenceAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCharacterClassEscapeSequence"


    // $ANTLR start "entryRuleCharacterEscapeSequence"
    // InternalRegularExpressionParser.g:467:1: entryRuleCharacterEscapeSequence : ruleCharacterEscapeSequence EOF ;
    public final void entryRuleCharacterEscapeSequence() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:468:1: ( ruleCharacterEscapeSequence EOF )
            // InternalRegularExpressionParser.g:469:1: ruleCharacterEscapeSequence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterEscapeSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCharacterEscapeSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterEscapeSequenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCharacterEscapeSequence"


    // $ANTLR start "ruleCharacterEscapeSequence"
    // InternalRegularExpressionParser.g:476:1: ruleCharacterEscapeSequence : ( ( rule__CharacterEscapeSequence__SequenceAssignment ) ) ;
    public final void ruleCharacterEscapeSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:480:2: ( ( ( rule__CharacterEscapeSequence__SequenceAssignment ) ) )
            // InternalRegularExpressionParser.g:481:2: ( ( rule__CharacterEscapeSequence__SequenceAssignment ) )
            {
            // InternalRegularExpressionParser.g:481:2: ( ( rule__CharacterEscapeSequence__SequenceAssignment ) )
            // InternalRegularExpressionParser.g:482:3: ( rule__CharacterEscapeSequence__SequenceAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterEscapeSequenceAccess().getSequenceAssignment()); 
            }
            // InternalRegularExpressionParser.g:483:3: ( rule__CharacterEscapeSequence__SequenceAssignment )
            // InternalRegularExpressionParser.g:483:4: rule__CharacterEscapeSequence__SequenceAssignment
            {
            pushFollow(FOLLOW_2);
            rule__CharacterEscapeSequence__SequenceAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterEscapeSequenceAccess().getSequenceAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCharacterEscapeSequence"


    // $ANTLR start "entryRuleControlLetterEscapeSequence"
    // InternalRegularExpressionParser.g:492:1: entryRuleControlLetterEscapeSequence : ruleControlLetterEscapeSequence EOF ;
    public final void entryRuleControlLetterEscapeSequence() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:493:1: ( ruleControlLetterEscapeSequence EOF )
            // InternalRegularExpressionParser.g:494:1: ruleControlLetterEscapeSequence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getControlLetterEscapeSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleControlLetterEscapeSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getControlLetterEscapeSequenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleControlLetterEscapeSequence"


    // $ANTLR start "ruleControlLetterEscapeSequence"
    // InternalRegularExpressionParser.g:501:1: ruleControlLetterEscapeSequence : ( ( rule__ControlLetterEscapeSequence__SequenceAssignment ) ) ;
    public final void ruleControlLetterEscapeSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:505:2: ( ( ( rule__ControlLetterEscapeSequence__SequenceAssignment ) ) )
            // InternalRegularExpressionParser.g:506:2: ( ( rule__ControlLetterEscapeSequence__SequenceAssignment ) )
            {
            // InternalRegularExpressionParser.g:506:2: ( ( rule__ControlLetterEscapeSequence__SequenceAssignment ) )
            // InternalRegularExpressionParser.g:507:3: ( rule__ControlLetterEscapeSequence__SequenceAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getControlLetterEscapeSequenceAccess().getSequenceAssignment()); 
            }
            // InternalRegularExpressionParser.g:508:3: ( rule__ControlLetterEscapeSequence__SequenceAssignment )
            // InternalRegularExpressionParser.g:508:4: rule__ControlLetterEscapeSequence__SequenceAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ControlLetterEscapeSequence__SequenceAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getControlLetterEscapeSequenceAccess().getSequenceAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleControlLetterEscapeSequence"


    // $ANTLR start "entryRuleHexEscapeSequence"
    // InternalRegularExpressionParser.g:517:1: entryRuleHexEscapeSequence : ruleHexEscapeSequence EOF ;
    public final void entryRuleHexEscapeSequence() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:518:1: ( ruleHexEscapeSequence EOF )
            // InternalRegularExpressionParser.g:519:1: ruleHexEscapeSequence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexEscapeSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleHexEscapeSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexEscapeSequenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHexEscapeSequence"


    // $ANTLR start "ruleHexEscapeSequence"
    // InternalRegularExpressionParser.g:526:1: ruleHexEscapeSequence : ( ( rule__HexEscapeSequence__SequenceAssignment ) ) ;
    public final void ruleHexEscapeSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:530:2: ( ( ( rule__HexEscapeSequence__SequenceAssignment ) ) )
            // InternalRegularExpressionParser.g:531:2: ( ( rule__HexEscapeSequence__SequenceAssignment ) )
            {
            // InternalRegularExpressionParser.g:531:2: ( ( rule__HexEscapeSequence__SequenceAssignment ) )
            // InternalRegularExpressionParser.g:532:3: ( rule__HexEscapeSequence__SequenceAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexEscapeSequenceAccess().getSequenceAssignment()); 
            }
            // InternalRegularExpressionParser.g:533:3: ( rule__HexEscapeSequence__SequenceAssignment )
            // InternalRegularExpressionParser.g:533:4: rule__HexEscapeSequence__SequenceAssignment
            {
            pushFollow(FOLLOW_2);
            rule__HexEscapeSequence__SequenceAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexEscapeSequenceAccess().getSequenceAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHexEscapeSequence"


    // $ANTLR start "entryRuleUnicodeEscapeSequence"
    // InternalRegularExpressionParser.g:542:1: entryRuleUnicodeEscapeSequence : ruleUnicodeEscapeSequence EOF ;
    public final void entryRuleUnicodeEscapeSequence() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:543:1: ( ruleUnicodeEscapeSequence EOF )
            // InternalRegularExpressionParser.g:544:1: ruleUnicodeEscapeSequence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnicodeEscapeSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUnicodeEscapeSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnicodeEscapeSequenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnicodeEscapeSequence"


    // $ANTLR start "ruleUnicodeEscapeSequence"
    // InternalRegularExpressionParser.g:551:1: ruleUnicodeEscapeSequence : ( ( rule__UnicodeEscapeSequence__SequenceAssignment ) ) ;
    public final void ruleUnicodeEscapeSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:555:2: ( ( ( rule__UnicodeEscapeSequence__SequenceAssignment ) ) )
            // InternalRegularExpressionParser.g:556:2: ( ( rule__UnicodeEscapeSequence__SequenceAssignment ) )
            {
            // InternalRegularExpressionParser.g:556:2: ( ( rule__UnicodeEscapeSequence__SequenceAssignment ) )
            // InternalRegularExpressionParser.g:557:3: ( rule__UnicodeEscapeSequence__SequenceAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnicodeEscapeSequenceAccess().getSequenceAssignment()); 
            }
            // InternalRegularExpressionParser.g:558:3: ( rule__UnicodeEscapeSequence__SequenceAssignment )
            // InternalRegularExpressionParser.g:558:4: rule__UnicodeEscapeSequence__SequenceAssignment
            {
            pushFollow(FOLLOW_2);
            rule__UnicodeEscapeSequence__SequenceAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnicodeEscapeSequenceAccess().getSequenceAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnicodeEscapeSequence"


    // $ANTLR start "entryRuleIdentityEscapeSequence"
    // InternalRegularExpressionParser.g:567:1: entryRuleIdentityEscapeSequence : ruleIdentityEscapeSequence EOF ;
    public final void entryRuleIdentityEscapeSequence() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:568:1: ( ruleIdentityEscapeSequence EOF )
            // InternalRegularExpressionParser.g:569:1: ruleIdentityEscapeSequence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentityEscapeSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIdentityEscapeSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentityEscapeSequenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdentityEscapeSequence"


    // $ANTLR start "ruleIdentityEscapeSequence"
    // InternalRegularExpressionParser.g:576:1: ruleIdentityEscapeSequence : ( ( rule__IdentityEscapeSequence__SequenceAssignment ) ) ;
    public final void ruleIdentityEscapeSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:580:2: ( ( ( rule__IdentityEscapeSequence__SequenceAssignment ) ) )
            // InternalRegularExpressionParser.g:581:2: ( ( rule__IdentityEscapeSequence__SequenceAssignment ) )
            {
            // InternalRegularExpressionParser.g:581:2: ( ( rule__IdentityEscapeSequence__SequenceAssignment ) )
            // InternalRegularExpressionParser.g:582:3: ( rule__IdentityEscapeSequence__SequenceAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentityEscapeSequenceAccess().getSequenceAssignment()); 
            }
            // InternalRegularExpressionParser.g:583:3: ( rule__IdentityEscapeSequence__SequenceAssignment )
            // InternalRegularExpressionParser.g:583:4: rule__IdentityEscapeSequence__SequenceAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IdentityEscapeSequence__SequenceAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentityEscapeSequenceAccess().getSequenceAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentityEscapeSequence"


    // $ANTLR start "entryRuleDecimalEscapeSequence"
    // InternalRegularExpressionParser.g:592:1: entryRuleDecimalEscapeSequence : ruleDecimalEscapeSequence EOF ;
    public final void entryRuleDecimalEscapeSequence() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:593:1: ( ruleDecimalEscapeSequence EOF )
            // InternalRegularExpressionParser.g:594:1: ruleDecimalEscapeSequence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalEscapeSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDecimalEscapeSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalEscapeSequenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDecimalEscapeSequence"


    // $ANTLR start "ruleDecimalEscapeSequence"
    // InternalRegularExpressionParser.g:601:1: ruleDecimalEscapeSequence : ( ( rule__DecimalEscapeSequence__SequenceAssignment ) ) ;
    public final void ruleDecimalEscapeSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:605:2: ( ( ( rule__DecimalEscapeSequence__SequenceAssignment ) ) )
            // InternalRegularExpressionParser.g:606:2: ( ( rule__DecimalEscapeSequence__SequenceAssignment ) )
            {
            // InternalRegularExpressionParser.g:606:2: ( ( rule__DecimalEscapeSequence__SequenceAssignment ) )
            // InternalRegularExpressionParser.g:607:3: ( rule__DecimalEscapeSequence__SequenceAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalEscapeSequenceAccess().getSequenceAssignment()); 
            }
            // InternalRegularExpressionParser.g:608:3: ( rule__DecimalEscapeSequence__SequenceAssignment )
            // InternalRegularExpressionParser.g:608:4: rule__DecimalEscapeSequence__SequenceAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DecimalEscapeSequence__SequenceAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalEscapeSequenceAccess().getSequenceAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDecimalEscapeSequence"


    // $ANTLR start "entryRuleCharacterClass"
    // InternalRegularExpressionParser.g:617:1: entryRuleCharacterClass : ruleCharacterClass EOF ;
    public final void entryRuleCharacterClass() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:618:1: ( ruleCharacterClass EOF )
            // InternalRegularExpressionParser.g:619:1: ruleCharacterClass EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCharacterClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCharacterClass"


    // $ANTLR start "ruleCharacterClass"
    // InternalRegularExpressionParser.g:626:1: ruleCharacterClass : ( ( rule__CharacterClass__Group__0 ) ) ;
    public final void ruleCharacterClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:630:2: ( ( ( rule__CharacterClass__Group__0 ) ) )
            // InternalRegularExpressionParser.g:631:2: ( ( rule__CharacterClass__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:631:2: ( ( rule__CharacterClass__Group__0 ) )
            // InternalRegularExpressionParser.g:632:3: ( rule__CharacterClass__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:633:3: ( rule__CharacterClass__Group__0 )
            // InternalRegularExpressionParser.g:633:4: rule__CharacterClass__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClass__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCharacterClass"


    // $ANTLR start "entryRuleCharacterClassElement"
    // InternalRegularExpressionParser.g:642:1: entryRuleCharacterClassElement : ruleCharacterClassElement EOF ;
    public final void entryRuleCharacterClassElement() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:643:1: ( ruleCharacterClassElement EOF )
            // InternalRegularExpressionParser.g:644:1: ruleCharacterClassElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCharacterClassElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCharacterClassElement"


    // $ANTLR start "ruleCharacterClassElement"
    // InternalRegularExpressionParser.g:651:1: ruleCharacterClassElement : ( ( rule__CharacterClassElement__Group__0 ) ) ;
    public final void ruleCharacterClassElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:655:2: ( ( ( rule__CharacterClassElement__Group__0 ) ) )
            // InternalRegularExpressionParser.g:656:2: ( ( rule__CharacterClassElement__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:656:2: ( ( rule__CharacterClassElement__Group__0 ) )
            // InternalRegularExpressionParser.g:657:3: ( rule__CharacterClassElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:658:3: ( rule__CharacterClassElement__Group__0 )
            // InternalRegularExpressionParser.g:658:4: rule__CharacterClassElement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCharacterClassElement"


    // $ANTLR start "entryRuleCharacterClassAtom"
    // InternalRegularExpressionParser.g:667:1: entryRuleCharacterClassAtom : ruleCharacterClassAtom EOF ;
    public final void entryRuleCharacterClassAtom() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:668:1: ( ruleCharacterClassAtom EOF )
            // InternalRegularExpressionParser.g:669:1: ruleCharacterClassAtom EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAtomRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCharacterClassAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAtomRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCharacterClassAtom"


    // $ANTLR start "ruleCharacterClassAtom"
    // InternalRegularExpressionParser.g:676:1: ruleCharacterClassAtom : ( ( rule__CharacterClassAtom__Alternatives ) ) ;
    public final void ruleCharacterClassAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:680:2: ( ( ( rule__CharacterClassAtom__Alternatives ) ) )
            // InternalRegularExpressionParser.g:681:2: ( ( rule__CharacterClassAtom__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:681:2: ( ( rule__CharacterClassAtom__Alternatives ) )
            // InternalRegularExpressionParser.g:682:3: ( rule__CharacterClassAtom__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAtomAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:683:3: ( rule__CharacterClassAtom__Alternatives )
            // InternalRegularExpressionParser.g:683:4: rule__CharacterClassAtom__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassAtom__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAtomAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCharacterClassAtom"


    // $ANTLR start "entryRuleEscapedCharacterClassAtom"
    // InternalRegularExpressionParser.g:692:1: entryRuleEscapedCharacterClassAtom : ruleEscapedCharacterClassAtom EOF ;
    public final void entryRuleEscapedCharacterClassAtom() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:693:1: ( ruleEscapedCharacterClassAtom EOF )
            // InternalRegularExpressionParser.g:694:1: ruleEscapedCharacterClassAtom EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEscapedCharacterClassAtomRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEscapedCharacterClassAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEscapedCharacterClassAtomRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEscapedCharacterClassAtom"


    // $ANTLR start "ruleEscapedCharacterClassAtom"
    // InternalRegularExpressionParser.g:701:1: ruleEscapedCharacterClassAtom : ( ( rule__EscapedCharacterClassAtom__Alternatives ) ) ;
    public final void ruleEscapedCharacterClassAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:705:2: ( ( ( rule__EscapedCharacterClassAtom__Alternatives ) ) )
            // InternalRegularExpressionParser.g:706:2: ( ( rule__EscapedCharacterClassAtom__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:706:2: ( ( rule__EscapedCharacterClassAtom__Alternatives ) )
            // InternalRegularExpressionParser.g:707:3: ( rule__EscapedCharacterClassAtom__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEscapedCharacterClassAtomAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:708:3: ( rule__EscapedCharacterClassAtom__Alternatives )
            // InternalRegularExpressionParser.g:708:4: rule__EscapedCharacterClassAtom__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EscapedCharacterClassAtom__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEscapedCharacterClassAtomAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEscapedCharacterClassAtom"


    // $ANTLR start "entryRuleBackspace"
    // InternalRegularExpressionParser.g:717:1: entryRuleBackspace : ruleBackspace EOF ;
    public final void entryRuleBackspace() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:718:1: ( ruleBackspace EOF )
            // InternalRegularExpressionParser.g:719:1: ruleBackspace EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBackspaceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBackspace();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBackspaceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBackspace"


    // $ANTLR start "ruleBackspace"
    // InternalRegularExpressionParser.g:726:1: ruleBackspace : ( ( rule__Backspace__Group__0 ) ) ;
    public final void ruleBackspace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:730:2: ( ( ( rule__Backspace__Group__0 ) ) )
            // InternalRegularExpressionParser.g:731:2: ( ( rule__Backspace__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:731:2: ( ( rule__Backspace__Group__0 ) )
            // InternalRegularExpressionParser.g:732:3: ( rule__Backspace__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBackspaceAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:733:3: ( rule__Backspace__Group__0 )
            // InternalRegularExpressionParser.g:733:4: rule__Backspace__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Backspace__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBackspaceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBackspace"


    // $ANTLR start "entryRuleGroup"
    // InternalRegularExpressionParser.g:742:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:743:1: ( ruleGroup EOF )
            // InternalRegularExpressionParser.g:744:1: ruleGroup EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleGroup();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalRegularExpressionParser.g:751:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:755:2: ( ( ( rule__Group__Group__0 ) ) )
            // InternalRegularExpressionParser.g:756:2: ( ( rule__Group__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:756:2: ( ( rule__Group__Group__0 ) )
            // InternalRegularExpressionParser.g:757:3: ( rule__Group__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:758:3: ( rule__Group__Group__0 )
            // InternalRegularExpressionParser.g:758:4: rule__Group__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Group__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleRegExpIdentifierName"
    // InternalRegularExpressionParser.g:767:1: entryRuleRegExpIdentifierName : ruleRegExpIdentifierName EOF ;
    public final void entryRuleRegExpIdentifierName() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:768:1: ( ruleRegExpIdentifierName EOF )
            // InternalRegularExpressionParser.g:769:1: ruleRegExpIdentifierName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegExpIdentifierNameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRegExpIdentifierName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegExpIdentifierNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegExpIdentifierName"


    // $ANTLR start "ruleRegExpIdentifierName"
    // InternalRegularExpressionParser.g:776:1: ruleRegExpIdentifierName : ( ( rule__RegExpIdentifierName__Group__0 ) ) ;
    public final void ruleRegExpIdentifierName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:780:2: ( ( ( rule__RegExpIdentifierName__Group__0 ) ) )
            // InternalRegularExpressionParser.g:781:2: ( ( rule__RegExpIdentifierName__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:781:2: ( ( rule__RegExpIdentifierName__Group__0 ) )
            // InternalRegularExpressionParser.g:782:3: ( rule__RegExpIdentifierName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegExpIdentifierNameAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:783:3: ( rule__RegExpIdentifierName__Group__0 )
            // InternalRegularExpressionParser.g:783:4: rule__RegExpIdentifierName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RegExpIdentifierName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegExpIdentifierNameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegExpIdentifierName"


    // $ANTLR start "entryRuleRegExpIdentifierStart"
    // InternalRegularExpressionParser.g:792:1: entryRuleRegExpIdentifierStart : ruleRegExpIdentifierStart EOF ;
    public final void entryRuleRegExpIdentifierStart() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:793:1: ( ruleRegExpIdentifierStart EOF )
            // InternalRegularExpressionParser.g:794:1: ruleRegExpIdentifierStart EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegExpIdentifierStartRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRegExpIdentifierStart();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegExpIdentifierStartRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegExpIdentifierStart"


    // $ANTLR start "ruleRegExpIdentifierStart"
    // InternalRegularExpressionParser.g:801:1: ruleRegExpIdentifierStart : ( ( rule__RegExpIdentifierStart__Alternatives ) ) ;
    public final void ruleRegExpIdentifierStart() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:805:2: ( ( ( rule__RegExpIdentifierStart__Alternatives ) ) )
            // InternalRegularExpressionParser.g:806:2: ( ( rule__RegExpIdentifierStart__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:806:2: ( ( rule__RegExpIdentifierStart__Alternatives ) )
            // InternalRegularExpressionParser.g:807:3: ( rule__RegExpIdentifierStart__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegExpIdentifierStartAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:808:3: ( rule__RegExpIdentifierStart__Alternatives )
            // InternalRegularExpressionParser.g:808:4: rule__RegExpIdentifierStart__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RegExpIdentifierStart__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegExpIdentifierStartAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegExpIdentifierStart"


    // $ANTLR start "entryRuleRegExpIdentifierPart"
    // InternalRegularExpressionParser.g:817:1: entryRuleRegExpIdentifierPart : ruleRegExpIdentifierPart EOF ;
    public final void entryRuleRegExpIdentifierPart() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:818:1: ( ruleRegExpIdentifierPart EOF )
            // InternalRegularExpressionParser.g:819:1: ruleRegExpIdentifierPart EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegExpIdentifierPartRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRegExpIdentifierPart();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegExpIdentifierPartRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegExpIdentifierPart"


    // $ANTLR start "ruleRegExpIdentifierPart"
    // InternalRegularExpressionParser.g:826:1: ruleRegExpIdentifierPart : ( ( rule__RegExpIdentifierPart__Alternatives ) ) ;
    public final void ruleRegExpIdentifierPart() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:830:2: ( ( ( rule__RegExpIdentifierPart__Alternatives ) ) )
            // InternalRegularExpressionParser.g:831:2: ( ( rule__RegExpIdentifierPart__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:831:2: ( ( rule__RegExpIdentifierPart__Alternatives ) )
            // InternalRegularExpressionParser.g:832:3: ( rule__RegExpIdentifierPart__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegExpIdentifierPartAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:833:3: ( rule__RegExpIdentifierPart__Alternatives )
            // InternalRegularExpressionParser.g:833:4: rule__RegExpIdentifierPart__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RegExpIdentifierPart__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegExpIdentifierPartAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegExpIdentifierPart"


    // $ANTLR start "entryRuleQuantifier"
    // InternalRegularExpressionParser.g:842:1: entryRuleQuantifier : ruleQuantifier EOF ;
    public final void entryRuleQuantifier() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:843:1: ( ruleQuantifier EOF )
            // InternalRegularExpressionParser.g:844:1: ruleQuantifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuantifierRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQuantifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuantifierRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuantifier"


    // $ANTLR start "ruleQuantifier"
    // InternalRegularExpressionParser.g:851:1: ruleQuantifier : ( ( rule__Quantifier__Alternatives ) ) ;
    public final void ruleQuantifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:855:2: ( ( ( rule__Quantifier__Alternatives ) ) )
            // InternalRegularExpressionParser.g:856:2: ( ( rule__Quantifier__Alternatives ) )
            {
            // InternalRegularExpressionParser.g:856:2: ( ( rule__Quantifier__Alternatives ) )
            // InternalRegularExpressionParser.g:857:3: ( rule__Quantifier__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuantifierAccess().getAlternatives()); 
            }
            // InternalRegularExpressionParser.g:858:3: ( rule__Quantifier__Alternatives )
            // InternalRegularExpressionParser.g:858:4: rule__Quantifier__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Quantifier__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuantifierAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuantifier"


    // $ANTLR start "entryRuleSimpleQuantifier"
    // InternalRegularExpressionParser.g:867:1: entryRuleSimpleQuantifier : ruleSimpleQuantifier EOF ;
    public final void entryRuleSimpleQuantifier() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:868:1: ( ruleSimpleQuantifier EOF )
            // InternalRegularExpressionParser.g:869:1: ruleSimpleQuantifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleQuantifierRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSimpleQuantifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleQuantifierRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleQuantifier"


    // $ANTLR start "ruleSimpleQuantifier"
    // InternalRegularExpressionParser.g:876:1: ruleSimpleQuantifier : ( ( rule__SimpleQuantifier__Group__0 ) ) ;
    public final void ruleSimpleQuantifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:880:2: ( ( ( rule__SimpleQuantifier__Group__0 ) ) )
            // InternalRegularExpressionParser.g:881:2: ( ( rule__SimpleQuantifier__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:881:2: ( ( rule__SimpleQuantifier__Group__0 ) )
            // InternalRegularExpressionParser.g:882:3: ( rule__SimpleQuantifier__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleQuantifierAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:883:3: ( rule__SimpleQuantifier__Group__0 )
            // InternalRegularExpressionParser.g:883:4: rule__SimpleQuantifier__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleQuantifier__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleQuantifierAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleQuantifier"


    // $ANTLR start "entryRuleExactQuantifier"
    // InternalRegularExpressionParser.g:892:1: entryRuleExactQuantifier : ruleExactQuantifier EOF ;
    public final void entryRuleExactQuantifier() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:893:1: ( ruleExactQuantifier EOF )
            // InternalRegularExpressionParser.g:894:1: ruleExactQuantifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExactQuantifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExactQuantifier"


    // $ANTLR start "ruleExactQuantifier"
    // InternalRegularExpressionParser.g:901:1: ruleExactQuantifier : ( ( rule__ExactQuantifier__Group__0 ) ) ;
    public final void ruleExactQuantifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:905:2: ( ( ( rule__ExactQuantifier__Group__0 ) ) )
            // InternalRegularExpressionParser.g:906:2: ( ( rule__ExactQuantifier__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:906:2: ( ( rule__ExactQuantifier__Group__0 ) )
            // InternalRegularExpressionParser.g:907:3: ( rule__ExactQuantifier__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:908:3: ( rule__ExactQuantifier__Group__0 )
            // InternalRegularExpressionParser.g:908:4: rule__ExactQuantifier__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExactQuantifier"


    // $ANTLR start "entryRuleRegularExpressionFlags"
    // InternalRegularExpressionParser.g:917:1: entryRuleRegularExpressionFlags : ruleRegularExpressionFlags EOF ;
    public final void entryRuleRegularExpressionFlags() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:918:1: ( ruleRegularExpressionFlags EOF )
            // InternalRegularExpressionParser.g:919:1: ruleRegularExpressionFlags EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionFlagsRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRegularExpressionFlags();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionFlagsRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegularExpressionFlags"


    // $ANTLR start "ruleRegularExpressionFlags"
    // InternalRegularExpressionParser.g:926:1: ruleRegularExpressionFlags : ( ( rule__RegularExpressionFlags__Group__0 ) ) ;
    public final void ruleRegularExpressionFlags() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:930:2: ( ( ( rule__RegularExpressionFlags__Group__0 ) ) )
            // InternalRegularExpressionParser.g:931:2: ( ( rule__RegularExpressionFlags__Group__0 ) )
            {
            // InternalRegularExpressionParser.g:931:2: ( ( rule__RegularExpressionFlags__Group__0 ) )
            // InternalRegularExpressionParser.g:932:3: ( rule__RegularExpressionFlags__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionFlagsAccess().getGroup()); 
            }
            // InternalRegularExpressionParser.g:933:3: ( rule__RegularExpressionFlags__Group__0 )
            // InternalRegularExpressionParser.g:933:4: rule__RegularExpressionFlags__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RegularExpressionFlags__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionFlagsAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegularExpressionFlags"


    // $ANTLR start "entryRuleINT"
    // InternalRegularExpressionParser.g:942:1: entryRuleINT : ruleINT EOF ;
    public final void entryRuleINT() throws RecognitionException {
        try {
            // InternalRegularExpressionParser.g:943:1: ( ruleINT EOF )
            // InternalRegularExpressionParser.g:944:1: ruleINT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleINT"


    // $ANTLR start "ruleINT"
    // InternalRegularExpressionParser.g:951:1: ruleINT : ( ( ( RULE_UNICODE_DIGIT ) ) ( ( RULE_UNICODE_DIGIT )* ) ) ;
    public final void ruleINT() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:955:2: ( ( ( ( RULE_UNICODE_DIGIT ) ) ( ( RULE_UNICODE_DIGIT )* ) ) )
            // InternalRegularExpressionParser.g:956:2: ( ( ( RULE_UNICODE_DIGIT ) ) ( ( RULE_UNICODE_DIGIT )* ) )
            {
            // InternalRegularExpressionParser.g:956:2: ( ( ( RULE_UNICODE_DIGIT ) ) ( ( RULE_UNICODE_DIGIT )* ) )
            // InternalRegularExpressionParser.g:957:3: ( ( RULE_UNICODE_DIGIT ) ) ( ( RULE_UNICODE_DIGIT )* )
            {
            // InternalRegularExpressionParser.g:957:3: ( ( RULE_UNICODE_DIGIT ) )
            // InternalRegularExpressionParser.g:958:4: ( RULE_UNICODE_DIGIT )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getUNICODE_DIGITTerminalRuleCall()); 
            }
            // InternalRegularExpressionParser.g:959:4: ( RULE_UNICODE_DIGIT )
            // InternalRegularExpressionParser.g:959:5: RULE_UNICODE_DIGIT
            {
            match(input,RULE_UNICODE_DIGIT,FOLLOW_3); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTAccess().getUNICODE_DIGITTerminalRuleCall()); 
            }

            }

            // InternalRegularExpressionParser.g:962:3: ( ( RULE_UNICODE_DIGIT )* )
            // InternalRegularExpressionParser.g:963:4: ( RULE_UNICODE_DIGIT )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getUNICODE_DIGITTerminalRuleCall()); 
            }
            // InternalRegularExpressionParser.g:964:4: ( RULE_UNICODE_DIGIT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_UNICODE_DIGIT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRegularExpressionParser.g:964:5: RULE_UNICODE_DIGIT
            	    {
            	    match(input,RULE_UNICODE_DIGIT,FOLLOW_3); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTAccess().getUNICODE_DIGITTerminalRuleCall()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleINT"


    // $ANTLR start "rule__Disjunction__Alternatives"
    // InternalRegularExpressionParser.g:973:1: rule__Disjunction__Alternatives : ( ( ( rule__Disjunction__Group_0__0 ) ) | ( ( rule__Disjunction__Group_1__0 ) ) );
    public final void rule__Disjunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:977:1: ( ( ( rule__Disjunction__Group_0__0 ) ) | ( ( rule__Disjunction__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA2_0<=LeftParenthesisQuestionMarkEqualsSign)||(LA2_0>=ExclamationMark && LA2_0<=LeftParenthesis)||(LA2_0>=Comma && LA2_0<=FullStop)||(LA2_0>=Colon && LA2_0<=GreaterThanSign)||(LA2_0>=LeftSquareBracket && LA2_0<=CircumflexAccent)||LA2_0==LeftCurlyBracket||(LA2_0>=RightCurlyBracket && LA2_0<=RULE_CONTROL_LETTER_ESCAPE)||(LA2_0>=RULE_HEX_ESCAPE && LA2_0<=RULE_UNICODE_ESCAPE)||(LA2_0>=RULE_DECIMAL_ESCAPE && LA2_0<=RULE_IDENTITY_ESCAPE)||LA2_0==RULE_UNICODE_DIGIT||(LA2_0>=RULE_UNICODE_LETTER && LA2_0<=RULE_PATTERN_CHARACTER_NO_DASH)) ) {
                alt2=1;
            }
            else if ( (LA2_0==EOF||LA2_0==RightParenthesis||LA2_0==Solidus||LA2_0==VerticalLine) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalRegularExpressionParser.g:978:2: ( ( rule__Disjunction__Group_0__0 ) )
                    {
                    // InternalRegularExpressionParser.g:978:2: ( ( rule__Disjunction__Group_0__0 ) )
                    // InternalRegularExpressionParser.g:979:3: ( rule__Disjunction__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDisjunctionAccess().getGroup_0()); 
                    }
                    // InternalRegularExpressionParser.g:980:3: ( rule__Disjunction__Group_0__0 )
                    // InternalRegularExpressionParser.g:980:4: rule__Disjunction__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Disjunction__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDisjunctionAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:984:2: ( ( rule__Disjunction__Group_1__0 ) )
                    {
                    // InternalRegularExpressionParser.g:984:2: ( ( rule__Disjunction__Group_1__0 ) )
                    // InternalRegularExpressionParser.g:985:3: ( rule__Disjunction__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
                    }
                    // InternalRegularExpressionParser.g:986:3: ( rule__Disjunction__Group_1__0 )
                    // InternalRegularExpressionParser.g:986:4: rule__Disjunction__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Disjunction__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDisjunctionAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Alternatives"


    // $ANTLR start "rule__Term__Alternatives"
    // InternalRegularExpressionParser.g:994:1: rule__Term__Alternatives : ( ( ruleAssertion ) | ( ( rule__Term__Group_1__0 ) ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:998:1: ( ( ruleAssertion ) | ( ( rule__Term__Group_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA3_0<=LeftParenthesisQuestionMarkExclamationMark)||LA3_0==LeftParenthesisQuestionMarkEqualsSign||LA3_0==DollarSign||LA3_0==CircumflexAccent||(LA3_0>=RULE_WORD_BOUNDARY && LA3_0<=RULE_NOT_WORD_BOUNDARY)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=LeftParenthesisQuestionMarkColon && LA3_0<=LeftParenthesisQuestionMarkLessThanSign)||LA3_0==ExclamationMark||LA3_0==LeftParenthesis||(LA3_0>=Comma && LA3_0<=FullStop)||(LA3_0>=Colon && LA3_0<=GreaterThanSign)||(LA3_0>=LeftSquareBracket && LA3_0<=RightSquareBracket)||LA3_0==LeftCurlyBracket||LA3_0==RightCurlyBracket||(LA3_0>=RULE_CHARACTER_CLASS_ESCAPE && LA3_0<=RULE_CONTROL_LETTER_ESCAPE)||(LA3_0>=RULE_HEX_ESCAPE && LA3_0<=RULE_UNICODE_ESCAPE)||(LA3_0>=RULE_DECIMAL_ESCAPE && LA3_0<=RULE_IDENTITY_ESCAPE)||LA3_0==RULE_UNICODE_DIGIT||(LA3_0>=RULE_UNICODE_LETTER && LA3_0<=RULE_PATTERN_CHARACTER_NO_DASH)) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalRegularExpressionParser.g:999:2: ( ruleAssertion )
                    {
                    // InternalRegularExpressionParser.g:999:2: ( ruleAssertion )
                    // InternalRegularExpressionParser.g:1000:3: ruleAssertion
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTermAccess().getAssertionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleAssertion();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTermAccess().getAssertionParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1005:2: ( ( rule__Term__Group_1__0 ) )
                    {
                    // InternalRegularExpressionParser.g:1005:2: ( ( rule__Term__Group_1__0 ) )
                    // InternalRegularExpressionParser.g:1006:3: ( rule__Term__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTermAccess().getGroup_1()); 
                    }
                    // InternalRegularExpressionParser.g:1007:3: ( rule__Term__Group_1__0 )
                    // InternalRegularExpressionParser.g:1007:4: rule__Term__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Term__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTermAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Alternatives"


    // $ANTLR start "rule__Assertion__Alternatives"
    // InternalRegularExpressionParser.g:1015:1: rule__Assertion__Alternatives : ( ( ruleLineStart ) | ( ruleLineEnd ) | ( ruleWordBoundary ) | ( ruleAbstractLookAhead ) );
    public final void rule__Assertion__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1019:1: ( ( ruleLineStart ) | ( ruleLineEnd ) | ( ruleWordBoundary ) | ( ruleAbstractLookAhead ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case CircumflexAccent:
                {
                alt4=1;
                }
                break;
            case DollarSign:
                {
                alt4=2;
                }
                break;
            case RULE_WORD_BOUNDARY:
            case RULE_NOT_WORD_BOUNDARY:
                {
                alt4=3;
                }
                break;
            case LeftParenthesisQuestionMarkLessThanSignExclamationMark:
            case LeftParenthesisQuestionMarkLessThanSignEqualsSign:
            case LeftParenthesisQuestionMarkExclamationMark:
            case LeftParenthesisQuestionMarkEqualsSign:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalRegularExpressionParser.g:1020:2: ( ruleLineStart )
                    {
                    // InternalRegularExpressionParser.g:1020:2: ( ruleLineStart )
                    // InternalRegularExpressionParser.g:1021:3: ruleLineStart
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssertionAccess().getLineStartParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLineStart();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssertionAccess().getLineStartParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1026:2: ( ruleLineEnd )
                    {
                    // InternalRegularExpressionParser.g:1026:2: ( ruleLineEnd )
                    // InternalRegularExpressionParser.g:1027:3: ruleLineEnd
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssertionAccess().getLineEndParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLineEnd();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssertionAccess().getLineEndParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1032:2: ( ruleWordBoundary )
                    {
                    // InternalRegularExpressionParser.g:1032:2: ( ruleWordBoundary )
                    // InternalRegularExpressionParser.g:1033:3: ruleWordBoundary
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssertionAccess().getWordBoundaryParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleWordBoundary();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssertionAccess().getWordBoundaryParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRegularExpressionParser.g:1038:2: ( ruleAbstractLookAhead )
                    {
                    // InternalRegularExpressionParser.g:1038:2: ( ruleAbstractLookAhead )
                    // InternalRegularExpressionParser.g:1039:3: ruleAbstractLookAhead
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssertionAccess().getAbstractLookAheadParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleAbstractLookAhead();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssertionAccess().getAbstractLookAheadParserRuleCall_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assertion__Alternatives"


    // $ANTLR start "rule__WordBoundary__Alternatives_1"
    // InternalRegularExpressionParser.g:1048:1: rule__WordBoundary__Alternatives_1 : ( ( RULE_WORD_BOUNDARY ) | ( ( rule__WordBoundary__NotAssignment_1_1 ) ) );
    public final void rule__WordBoundary__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1052:1: ( ( RULE_WORD_BOUNDARY ) | ( ( rule__WordBoundary__NotAssignment_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_WORD_BOUNDARY) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_NOT_WORD_BOUNDARY) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalRegularExpressionParser.g:1053:2: ( RULE_WORD_BOUNDARY )
                    {
                    // InternalRegularExpressionParser.g:1053:2: ( RULE_WORD_BOUNDARY )
                    // InternalRegularExpressionParser.g:1054:3: RULE_WORD_BOUNDARY
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWordBoundaryAccess().getWORD_BOUNDARYTerminalRuleCall_1_0()); 
                    }
                    match(input,RULE_WORD_BOUNDARY,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getWordBoundaryAccess().getWORD_BOUNDARYTerminalRuleCall_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1059:2: ( ( rule__WordBoundary__NotAssignment_1_1 ) )
                    {
                    // InternalRegularExpressionParser.g:1059:2: ( ( rule__WordBoundary__NotAssignment_1_1 ) )
                    // InternalRegularExpressionParser.g:1060:3: ( rule__WordBoundary__NotAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWordBoundaryAccess().getNotAssignment_1_1()); 
                    }
                    // InternalRegularExpressionParser.g:1061:3: ( rule__WordBoundary__NotAssignment_1_1 )
                    // InternalRegularExpressionParser.g:1061:4: rule__WordBoundary__NotAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__WordBoundary__NotAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getWordBoundaryAccess().getNotAssignment_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordBoundary__Alternatives_1"


    // $ANTLR start "rule__AbstractLookAhead__Alternatives_0"
    // InternalRegularExpressionParser.g:1069:1: rule__AbstractLookAhead__Alternatives_0 : ( ( ( rule__AbstractLookAhead__Group_0_0__0 ) ) | ( ( rule__AbstractLookAhead__Group_0_1__0 ) ) );
    public final void rule__AbstractLookAhead__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1073:1: ( ( ( rule__AbstractLookAhead__Group_0_0__0 ) ) | ( ( rule__AbstractLookAhead__Group_0_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LeftParenthesisQuestionMarkExclamationMark||LA6_0==LeftParenthesisQuestionMarkEqualsSign) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA6_0<=LeftParenthesisQuestionMarkLessThanSignEqualsSign)) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalRegularExpressionParser.g:1074:2: ( ( rule__AbstractLookAhead__Group_0_0__0 ) )
                    {
                    // InternalRegularExpressionParser.g:1074:2: ( ( rule__AbstractLookAhead__Group_0_0__0 ) )
                    // InternalRegularExpressionParser.g:1075:3: ( rule__AbstractLookAhead__Group_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAbstractLookAheadAccess().getGroup_0_0()); 
                    }
                    // InternalRegularExpressionParser.g:1076:3: ( rule__AbstractLookAhead__Group_0_0__0 )
                    // InternalRegularExpressionParser.g:1076:4: rule__AbstractLookAhead__Group_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AbstractLookAhead__Group_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAbstractLookAheadAccess().getGroup_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1080:2: ( ( rule__AbstractLookAhead__Group_0_1__0 ) )
                    {
                    // InternalRegularExpressionParser.g:1080:2: ( ( rule__AbstractLookAhead__Group_0_1__0 ) )
                    // InternalRegularExpressionParser.g:1081:3: ( rule__AbstractLookAhead__Group_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAbstractLookAheadAccess().getGroup_0_1()); 
                    }
                    // InternalRegularExpressionParser.g:1082:3: ( rule__AbstractLookAhead__Group_0_1__0 )
                    // InternalRegularExpressionParser.g:1082:4: rule__AbstractLookAhead__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AbstractLookAhead__Group_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAbstractLookAheadAccess().getGroup_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Alternatives_0"


    // $ANTLR start "rule__AbstractLookAhead__Alternatives_0_0_1"
    // InternalRegularExpressionParser.g:1090:1: rule__AbstractLookAhead__Alternatives_0_0_1 : ( ( LeftParenthesisQuestionMarkEqualsSign ) | ( ( rule__AbstractLookAhead__NotAssignment_0_0_1_1 ) ) );
    public final void rule__AbstractLookAhead__Alternatives_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1094:1: ( ( LeftParenthesisQuestionMarkEqualsSign ) | ( ( rule__AbstractLookAhead__NotAssignment_0_0_1_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LeftParenthesisQuestionMarkEqualsSign) ) {
                alt7=1;
            }
            else if ( (LA7_0==LeftParenthesisQuestionMarkExclamationMark) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalRegularExpressionParser.g:1095:2: ( LeftParenthesisQuestionMarkEqualsSign )
                    {
                    // InternalRegularExpressionParser.g:1095:2: ( LeftParenthesisQuestionMarkEqualsSign )
                    // InternalRegularExpressionParser.g:1096:3: LeftParenthesisQuestionMarkEqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAbstractLookAheadAccess().getLeftParenthesisQuestionMarkEqualsSignKeyword_0_0_1_0()); 
                    }
                    match(input,LeftParenthesisQuestionMarkEqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAbstractLookAheadAccess().getLeftParenthesisQuestionMarkEqualsSignKeyword_0_0_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1101:2: ( ( rule__AbstractLookAhead__NotAssignment_0_0_1_1 ) )
                    {
                    // InternalRegularExpressionParser.g:1101:2: ( ( rule__AbstractLookAhead__NotAssignment_0_0_1_1 ) )
                    // InternalRegularExpressionParser.g:1102:3: ( rule__AbstractLookAhead__NotAssignment_0_0_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAbstractLookAheadAccess().getNotAssignment_0_0_1_1()); 
                    }
                    // InternalRegularExpressionParser.g:1103:3: ( rule__AbstractLookAhead__NotAssignment_0_0_1_1 )
                    // InternalRegularExpressionParser.g:1103:4: rule__AbstractLookAhead__NotAssignment_0_0_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__AbstractLookAhead__NotAssignment_0_0_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAbstractLookAheadAccess().getNotAssignment_0_0_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Alternatives_0_0_1"


    // $ANTLR start "rule__AbstractLookAhead__Alternatives_0_1_1"
    // InternalRegularExpressionParser.g:1111:1: rule__AbstractLookAhead__Alternatives_0_1_1 : ( ( LeftParenthesisQuestionMarkLessThanSignEqualsSign ) | ( ( rule__AbstractLookAhead__NotAssignment_0_1_1_1 ) ) );
    public final void rule__AbstractLookAhead__Alternatives_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1115:1: ( ( LeftParenthesisQuestionMarkLessThanSignEqualsSign ) | ( ( rule__AbstractLookAhead__NotAssignment_0_1_1_1 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LeftParenthesisQuestionMarkLessThanSignEqualsSign) ) {
                alt8=1;
            }
            else if ( (LA8_0==LeftParenthesisQuestionMarkLessThanSignExclamationMark) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalRegularExpressionParser.g:1116:2: ( LeftParenthesisQuestionMarkLessThanSignEqualsSign )
                    {
                    // InternalRegularExpressionParser.g:1116:2: ( LeftParenthesisQuestionMarkLessThanSignEqualsSign )
                    // InternalRegularExpressionParser.g:1117:3: LeftParenthesisQuestionMarkLessThanSignEqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAbstractLookAheadAccess().getLeftParenthesisQuestionMarkLessThanSignEqualsSignKeyword_0_1_1_0()); 
                    }
                    match(input,LeftParenthesisQuestionMarkLessThanSignEqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAbstractLookAheadAccess().getLeftParenthesisQuestionMarkLessThanSignEqualsSignKeyword_0_1_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1122:2: ( ( rule__AbstractLookAhead__NotAssignment_0_1_1_1 ) )
                    {
                    // InternalRegularExpressionParser.g:1122:2: ( ( rule__AbstractLookAhead__NotAssignment_0_1_1_1 ) )
                    // InternalRegularExpressionParser.g:1123:3: ( rule__AbstractLookAhead__NotAssignment_0_1_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAbstractLookAheadAccess().getNotAssignment_0_1_1_1()); 
                    }
                    // InternalRegularExpressionParser.g:1124:3: ( rule__AbstractLookAhead__NotAssignment_0_1_1_1 )
                    // InternalRegularExpressionParser.g:1124:4: rule__AbstractLookAhead__NotAssignment_0_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__AbstractLookAhead__NotAssignment_0_1_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAbstractLookAheadAccess().getNotAssignment_0_1_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Alternatives_0_1_1"


    // $ANTLR start "rule__Atom__Alternatives"
    // InternalRegularExpressionParser.g:1132:1: rule__Atom__Alternatives : ( ( rulePatternCharacter ) | ( ruleWildcard ) | ( ruleAtomEscape ) | ( ruleCharacterClass ) | ( ruleGroup ) );
    public final void rule__Atom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1136:1: ( ( rulePatternCharacter ) | ( ruleWildcard ) | ( ruleAtomEscape ) | ( ruleCharacterClass ) | ( ruleGroup ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case ExclamationMark:
            case Comma:
            case HyphenMinus:
            case Colon:
            case LessThanSign:
            case EqualsSign:
            case GreaterThanSign:
            case RightSquareBracket:
            case LeftCurlyBracket:
            case RightCurlyBracket:
            case RULE_UNICODE_DIGIT:
            case RULE_UNICODE_LETTER:
            case RULE_PATTERN_CHARACTER_NO_DASH:
                {
                alt9=1;
                }
                break;
            case FullStop:
                {
                alt9=2;
                }
                break;
            case RULE_CHARACTER_CLASS_ESCAPE:
            case RULE_CONTROL_ESCAPE:
            case RULE_CONTROL_LETTER_ESCAPE:
            case RULE_HEX_ESCAPE:
            case RULE_UNICODE_ESCAPE:
            case RULE_DECIMAL_ESCAPE:
            case RULE_IDENTITY_ESCAPE:
                {
                alt9=3;
                }
                break;
            case LeftSquareBracket:
                {
                alt9=4;
                }
                break;
            case LeftParenthesisQuestionMarkColon:
            case LeftParenthesisQuestionMarkLessThanSign:
            case LeftParenthesis:
                {
                alt9=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalRegularExpressionParser.g:1137:2: ( rulePatternCharacter )
                    {
                    // InternalRegularExpressionParser.g:1137:2: ( rulePatternCharacter )
                    // InternalRegularExpressionParser.g:1138:3: rulePatternCharacter
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomAccess().getPatternCharacterParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePatternCharacter();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomAccess().getPatternCharacterParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1143:2: ( ruleWildcard )
                    {
                    // InternalRegularExpressionParser.g:1143:2: ( ruleWildcard )
                    // InternalRegularExpressionParser.g:1144:3: ruleWildcard
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomAccess().getWildcardParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleWildcard();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomAccess().getWildcardParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1149:2: ( ruleAtomEscape )
                    {
                    // InternalRegularExpressionParser.g:1149:2: ( ruleAtomEscape )
                    // InternalRegularExpressionParser.g:1150:3: ruleAtomEscape
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomAccess().getAtomEscapeParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleAtomEscape();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomAccess().getAtomEscapeParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRegularExpressionParser.g:1155:2: ( ruleCharacterClass )
                    {
                    // InternalRegularExpressionParser.g:1155:2: ( ruleCharacterClass )
                    // InternalRegularExpressionParser.g:1156:3: ruleCharacterClass
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomAccess().getCharacterClassParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCharacterClass();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomAccess().getCharacterClassParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRegularExpressionParser.g:1161:2: ( ruleGroup )
                    {
                    // InternalRegularExpressionParser.g:1161:2: ( ruleGroup )
                    // InternalRegularExpressionParser.g:1162:3: ruleGroup
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomAccess().getGroupParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleGroup();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomAccess().getGroupParserRuleCall_4()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Alternatives"


    // $ANTLR start "rule__PatternCharacter__ValueAlternatives_0"
    // InternalRegularExpressionParser.g:1171:1: rule__PatternCharacter__ValueAlternatives_0 : ( ( RULE_PATTERN_CHARACTER_NO_DASH ) | ( RULE_UNICODE_LETTER ) | ( RULE_UNICODE_DIGIT ) | ( HyphenMinus ) | ( Comma ) | ( EqualsSign ) | ( Colon ) | ( ExclamationMark ) | ( LeftCurlyBracket ) | ( RightCurlyBracket ) | ( RightSquareBracket ) | ( LessThanSign ) | ( GreaterThanSign ) );
    public final void rule__PatternCharacter__ValueAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1175:1: ( ( RULE_PATTERN_CHARACTER_NO_DASH ) | ( RULE_UNICODE_LETTER ) | ( RULE_UNICODE_DIGIT ) | ( HyphenMinus ) | ( Comma ) | ( EqualsSign ) | ( Colon ) | ( ExclamationMark ) | ( LeftCurlyBracket ) | ( RightCurlyBracket ) | ( RightSquareBracket ) | ( LessThanSign ) | ( GreaterThanSign ) )
            int alt10=13;
            switch ( input.LA(1) ) {
            case RULE_PATTERN_CHARACTER_NO_DASH:
                {
                alt10=1;
                }
                break;
            case RULE_UNICODE_LETTER:
                {
                alt10=2;
                }
                break;
            case RULE_UNICODE_DIGIT:
                {
                alt10=3;
                }
                break;
            case HyphenMinus:
                {
                alt10=4;
                }
                break;
            case Comma:
                {
                alt10=5;
                }
                break;
            case EqualsSign:
                {
                alt10=6;
                }
                break;
            case Colon:
                {
                alt10=7;
                }
                break;
            case ExclamationMark:
                {
                alt10=8;
                }
                break;
            case LeftCurlyBracket:
                {
                alt10=9;
                }
                break;
            case RightCurlyBracket:
                {
                alt10=10;
                }
                break;
            case RightSquareBracket:
                {
                alt10=11;
                }
                break;
            case LessThanSign:
                {
                alt10=12;
                }
                break;
            case GreaterThanSign:
                {
                alt10=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalRegularExpressionParser.g:1176:2: ( RULE_PATTERN_CHARACTER_NO_DASH )
                    {
                    // InternalRegularExpressionParser.g:1176:2: ( RULE_PATTERN_CHARACTER_NO_DASH )
                    // InternalRegularExpressionParser.g:1177:3: RULE_PATTERN_CHARACTER_NO_DASH
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValuePATTERN_CHARACTER_NO_DASHTerminalRuleCall_0_0()); 
                    }
                    match(input,RULE_PATTERN_CHARACTER_NO_DASH,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValuePATTERN_CHARACTER_NO_DASHTerminalRuleCall_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1182:2: ( RULE_UNICODE_LETTER )
                    {
                    // InternalRegularExpressionParser.g:1182:2: ( RULE_UNICODE_LETTER )
                    // InternalRegularExpressionParser.g:1183:3: RULE_UNICODE_LETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueUNICODE_LETTERTerminalRuleCall_0_1()); 
                    }
                    match(input,RULE_UNICODE_LETTER,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueUNICODE_LETTERTerminalRuleCall_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1188:2: ( RULE_UNICODE_DIGIT )
                    {
                    // InternalRegularExpressionParser.g:1188:2: ( RULE_UNICODE_DIGIT )
                    // InternalRegularExpressionParser.g:1189:3: RULE_UNICODE_DIGIT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueUNICODE_DIGITTerminalRuleCall_0_2()); 
                    }
                    match(input,RULE_UNICODE_DIGIT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueUNICODE_DIGITTerminalRuleCall_0_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRegularExpressionParser.g:1194:2: ( HyphenMinus )
                    {
                    // InternalRegularExpressionParser.g:1194:2: ( HyphenMinus )
                    // InternalRegularExpressionParser.g:1195:3: HyphenMinus
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueHyphenMinusKeyword_0_3()); 
                    }
                    match(input,HyphenMinus,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueHyphenMinusKeyword_0_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRegularExpressionParser.g:1200:2: ( Comma )
                    {
                    // InternalRegularExpressionParser.g:1200:2: ( Comma )
                    // InternalRegularExpressionParser.g:1201:3: Comma
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueCommaKeyword_0_4()); 
                    }
                    match(input,Comma,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueCommaKeyword_0_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRegularExpressionParser.g:1206:2: ( EqualsSign )
                    {
                    // InternalRegularExpressionParser.g:1206:2: ( EqualsSign )
                    // InternalRegularExpressionParser.g:1207:3: EqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueEqualsSignKeyword_0_5()); 
                    }
                    match(input,EqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueEqualsSignKeyword_0_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalRegularExpressionParser.g:1212:2: ( Colon )
                    {
                    // InternalRegularExpressionParser.g:1212:2: ( Colon )
                    // InternalRegularExpressionParser.g:1213:3: Colon
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueColonKeyword_0_6()); 
                    }
                    match(input,Colon,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueColonKeyword_0_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalRegularExpressionParser.g:1218:2: ( ExclamationMark )
                    {
                    // InternalRegularExpressionParser.g:1218:2: ( ExclamationMark )
                    // InternalRegularExpressionParser.g:1219:3: ExclamationMark
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueExclamationMarkKeyword_0_7()); 
                    }
                    match(input,ExclamationMark,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueExclamationMarkKeyword_0_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalRegularExpressionParser.g:1224:2: ( LeftCurlyBracket )
                    {
                    // InternalRegularExpressionParser.g:1224:2: ( LeftCurlyBracket )
                    // InternalRegularExpressionParser.g:1225:3: LeftCurlyBracket
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueLeftCurlyBracketKeyword_0_8()); 
                    }
                    match(input,LeftCurlyBracket,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueLeftCurlyBracketKeyword_0_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalRegularExpressionParser.g:1230:2: ( RightCurlyBracket )
                    {
                    // InternalRegularExpressionParser.g:1230:2: ( RightCurlyBracket )
                    // InternalRegularExpressionParser.g:1231:3: RightCurlyBracket
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueRightCurlyBracketKeyword_0_9()); 
                    }
                    match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueRightCurlyBracketKeyword_0_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalRegularExpressionParser.g:1236:2: ( RightSquareBracket )
                    {
                    // InternalRegularExpressionParser.g:1236:2: ( RightSquareBracket )
                    // InternalRegularExpressionParser.g:1237:3: RightSquareBracket
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueRightSquareBracketKeyword_0_10()); 
                    }
                    match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueRightSquareBracketKeyword_0_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalRegularExpressionParser.g:1242:2: ( LessThanSign )
                    {
                    // InternalRegularExpressionParser.g:1242:2: ( LessThanSign )
                    // InternalRegularExpressionParser.g:1243:3: LessThanSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueLessThanSignKeyword_0_11()); 
                    }
                    match(input,LessThanSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueLessThanSignKeyword_0_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalRegularExpressionParser.g:1248:2: ( GreaterThanSign )
                    {
                    // InternalRegularExpressionParser.g:1248:2: ( GreaterThanSign )
                    // InternalRegularExpressionParser.g:1249:3: GreaterThanSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatternCharacterAccess().getValueGreaterThanSignKeyword_0_12()); 
                    }
                    match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatternCharacterAccess().getValueGreaterThanSignKeyword_0_12()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PatternCharacter__ValueAlternatives_0"


    // $ANTLR start "rule__AtomEscape__Alternatives"
    // InternalRegularExpressionParser.g:1258:1: rule__AtomEscape__Alternatives : ( ( ruleDecimalEscapeSequence ) | ( ruleCharacterEscapeSequence ) | ( ruleControlLetterEscapeSequence ) | ( ruleHexEscapeSequence ) | ( ruleUnicodeEscapeSequence ) | ( ruleIdentityEscapeSequence ) | ( ruleCharacterClassEscapeSequence ) );
    public final void rule__AtomEscape__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1262:1: ( ( ruleDecimalEscapeSequence ) | ( ruleCharacterEscapeSequence ) | ( ruleControlLetterEscapeSequence ) | ( ruleHexEscapeSequence ) | ( ruleUnicodeEscapeSequence ) | ( ruleIdentityEscapeSequence ) | ( ruleCharacterClassEscapeSequence ) )
            int alt11=7;
            switch ( input.LA(1) ) {
            case RULE_DECIMAL_ESCAPE:
                {
                alt11=1;
                }
                break;
            case RULE_CONTROL_ESCAPE:
                {
                alt11=2;
                }
                break;
            case RULE_CONTROL_LETTER_ESCAPE:
                {
                alt11=3;
                }
                break;
            case RULE_HEX_ESCAPE:
                {
                alt11=4;
                }
                break;
            case RULE_UNICODE_ESCAPE:
                {
                alt11=5;
                }
                break;
            case RULE_IDENTITY_ESCAPE:
                {
                alt11=6;
                }
                break;
            case RULE_CHARACTER_CLASS_ESCAPE:
                {
                alt11=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalRegularExpressionParser.g:1263:2: ( ruleDecimalEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1263:2: ( ruleDecimalEscapeSequence )
                    // InternalRegularExpressionParser.g:1264:3: ruleDecimalEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomEscapeAccess().getDecimalEscapeSequenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDecimalEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomEscapeAccess().getDecimalEscapeSequenceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1269:2: ( ruleCharacterEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1269:2: ( ruleCharacterEscapeSequence )
                    // InternalRegularExpressionParser.g:1270:3: ruleCharacterEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomEscapeAccess().getCharacterEscapeSequenceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCharacterEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomEscapeAccess().getCharacterEscapeSequenceParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1275:2: ( ruleControlLetterEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1275:2: ( ruleControlLetterEscapeSequence )
                    // InternalRegularExpressionParser.g:1276:3: ruleControlLetterEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomEscapeAccess().getControlLetterEscapeSequenceParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleControlLetterEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomEscapeAccess().getControlLetterEscapeSequenceParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRegularExpressionParser.g:1281:2: ( ruleHexEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1281:2: ( ruleHexEscapeSequence )
                    // InternalRegularExpressionParser.g:1282:3: ruleHexEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomEscapeAccess().getHexEscapeSequenceParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleHexEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomEscapeAccess().getHexEscapeSequenceParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRegularExpressionParser.g:1287:2: ( ruleUnicodeEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1287:2: ( ruleUnicodeEscapeSequence )
                    // InternalRegularExpressionParser.g:1288:3: ruleUnicodeEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomEscapeAccess().getUnicodeEscapeSequenceParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleUnicodeEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomEscapeAccess().getUnicodeEscapeSequenceParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRegularExpressionParser.g:1293:2: ( ruleIdentityEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1293:2: ( ruleIdentityEscapeSequence )
                    // InternalRegularExpressionParser.g:1294:3: ruleIdentityEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomEscapeAccess().getIdentityEscapeSequenceParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIdentityEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomEscapeAccess().getIdentityEscapeSequenceParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalRegularExpressionParser.g:1299:2: ( ruleCharacterClassEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1299:2: ( ruleCharacterClassEscapeSequence )
                    // InternalRegularExpressionParser.g:1300:3: ruleCharacterClassEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomEscapeAccess().getCharacterClassEscapeSequenceParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCharacterClassEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomEscapeAccess().getCharacterClassEscapeSequenceParserRuleCall_6()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomEscape__Alternatives"


    // $ANTLR start "rule__CharacterClassAtom__Alternatives"
    // InternalRegularExpressionParser.g:1309:1: rule__CharacterClassAtom__Alternatives : ( ( ruleEscapedCharacterClassAtom ) | ( ( rule__CharacterClassAtom__CharactersAssignment_1 ) ) );
    public final void rule__CharacterClassAtom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1313:1: ( ( ruleEscapedCharacterClassAtom ) | ( ( rule__CharacterClassAtom__CharactersAssignment_1 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_WORD_BOUNDARY||(LA12_0>=RULE_CHARACTER_CLASS_ESCAPE && LA12_0<=RULE_CONTROL_LETTER_ESCAPE)||(LA12_0>=RULE_HEX_ESCAPE && LA12_0<=RULE_UNICODE_ESCAPE)||(LA12_0>=RULE_DECIMAL_ESCAPE && LA12_0<=RULE_IDENTITY_ESCAPE)) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA12_0<=LeftParenthesisQuestionMarkExclamationMark)||(LA12_0>=LeftParenthesisQuestionMarkLessThanSign && LA12_0<=LeftSquareBracket)||LA12_0==CircumflexAccent||(LA12_0>=LeftCurlyBracket && LA12_0<=RightCurlyBracket)||LA12_0==RULE_UNICODE_DIGIT||(LA12_0>=RULE_UNICODE_LETTER && LA12_0<=RULE_PATTERN_CHARACTER_NO_DASH)) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalRegularExpressionParser.g:1314:2: ( ruleEscapedCharacterClassAtom )
                    {
                    // InternalRegularExpressionParser.g:1314:2: ( ruleEscapedCharacterClassAtom )
                    // InternalRegularExpressionParser.g:1315:3: ruleEscapedCharacterClassAtom
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getEscapedCharacterClassAtomParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEscapedCharacterClassAtom();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getEscapedCharacterClassAtomParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1320:2: ( ( rule__CharacterClassAtom__CharactersAssignment_1 ) )
                    {
                    // InternalRegularExpressionParser.g:1320:2: ( ( rule__CharacterClassAtom__CharactersAssignment_1 ) )
                    // InternalRegularExpressionParser.g:1321:3: ( rule__CharacterClassAtom__CharactersAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersAssignment_1()); 
                    }
                    // InternalRegularExpressionParser.g:1322:3: ( rule__CharacterClassAtom__CharactersAssignment_1 )
                    // InternalRegularExpressionParser.g:1322:4: rule__CharacterClassAtom__CharactersAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__CharacterClassAtom__CharactersAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassAtom__Alternatives"


    // $ANTLR start "rule__CharacterClassAtom__CharactersAlternatives_1_0"
    // InternalRegularExpressionParser.g:1330:1: rule__CharacterClassAtom__CharactersAlternatives_1_0 : ( ( Comma ) | ( EqualsSign ) | ( Colon ) | ( ExclamationMark ) | ( HyphenMinus ) | ( CircumflexAccent ) | ( DollarSign ) | ( FullStop ) | ( Asterisk ) | ( PlusSign ) | ( QuestionMark ) | ( LeftParenthesis ) | ( RightParenthesis ) | ( LeftSquareBracket ) | ( LeftCurlyBracket ) | ( RightCurlyBracket ) | ( VerticalLine ) | ( Solidus ) | ( LessThanSign ) | ( GreaterThanSign ) | ( LeftParenthesisQuestionMark ) | ( LeftParenthesisQuestionMarkLessThanSign ) | ( LeftParenthesisQuestionMarkEqualsSign ) | ( LeftParenthesisQuestionMarkExclamationMark ) | ( LeftParenthesisQuestionMarkLessThanSignExclamationMark ) | ( LeftParenthesisQuestionMarkLessThanSignEqualsSign ) | ( RULE_PATTERN_CHARACTER_NO_DASH ) | ( RULE_UNICODE_LETTER ) | ( RULE_UNICODE_DIGIT ) );
    public final void rule__CharacterClassAtom__CharactersAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1334:1: ( ( Comma ) | ( EqualsSign ) | ( Colon ) | ( ExclamationMark ) | ( HyphenMinus ) | ( CircumflexAccent ) | ( DollarSign ) | ( FullStop ) | ( Asterisk ) | ( PlusSign ) | ( QuestionMark ) | ( LeftParenthesis ) | ( RightParenthesis ) | ( LeftSquareBracket ) | ( LeftCurlyBracket ) | ( RightCurlyBracket ) | ( VerticalLine ) | ( Solidus ) | ( LessThanSign ) | ( GreaterThanSign ) | ( LeftParenthesisQuestionMark ) | ( LeftParenthesisQuestionMarkLessThanSign ) | ( LeftParenthesisQuestionMarkEqualsSign ) | ( LeftParenthesisQuestionMarkExclamationMark ) | ( LeftParenthesisQuestionMarkLessThanSignExclamationMark ) | ( LeftParenthesisQuestionMarkLessThanSignEqualsSign ) | ( RULE_PATTERN_CHARACTER_NO_DASH ) | ( RULE_UNICODE_LETTER ) | ( RULE_UNICODE_DIGIT ) )
            int alt13=29;
            switch ( input.LA(1) ) {
            case Comma:
                {
                alt13=1;
                }
                break;
            case EqualsSign:
                {
                alt13=2;
                }
                break;
            case Colon:
                {
                alt13=3;
                }
                break;
            case ExclamationMark:
                {
                alt13=4;
                }
                break;
            case HyphenMinus:
                {
                alt13=5;
                }
                break;
            case CircumflexAccent:
                {
                alt13=6;
                }
                break;
            case DollarSign:
                {
                alt13=7;
                }
                break;
            case FullStop:
                {
                alt13=8;
                }
                break;
            case Asterisk:
                {
                alt13=9;
                }
                break;
            case PlusSign:
                {
                alt13=10;
                }
                break;
            case QuestionMark:
                {
                alt13=11;
                }
                break;
            case LeftParenthesis:
                {
                alt13=12;
                }
                break;
            case RightParenthesis:
                {
                alt13=13;
                }
                break;
            case LeftSquareBracket:
                {
                alt13=14;
                }
                break;
            case LeftCurlyBracket:
                {
                alt13=15;
                }
                break;
            case RightCurlyBracket:
                {
                alt13=16;
                }
                break;
            case VerticalLine:
                {
                alt13=17;
                }
                break;
            case Solidus:
                {
                alt13=18;
                }
                break;
            case LessThanSign:
                {
                alt13=19;
                }
                break;
            case GreaterThanSign:
                {
                alt13=20;
                }
                break;
            case LeftParenthesisQuestionMark:
                {
                alt13=21;
                }
                break;
            case LeftParenthesisQuestionMarkLessThanSign:
                {
                alt13=22;
                }
                break;
            case LeftParenthesisQuestionMarkEqualsSign:
                {
                alt13=23;
                }
                break;
            case LeftParenthesisQuestionMarkExclamationMark:
                {
                alt13=24;
                }
                break;
            case LeftParenthesisQuestionMarkLessThanSignExclamationMark:
                {
                alt13=25;
                }
                break;
            case LeftParenthesisQuestionMarkLessThanSignEqualsSign:
                {
                alt13=26;
                }
                break;
            case RULE_PATTERN_CHARACTER_NO_DASH:
                {
                alt13=27;
                }
                break;
            case RULE_UNICODE_LETTER:
                {
                alt13=28;
                }
                break;
            case RULE_UNICODE_DIGIT:
                {
                alt13=29;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalRegularExpressionParser.g:1335:2: ( Comma )
                    {
                    // InternalRegularExpressionParser.g:1335:2: ( Comma )
                    // InternalRegularExpressionParser.g:1336:3: Comma
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersCommaKeyword_1_0_0()); 
                    }
                    match(input,Comma,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersCommaKeyword_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1341:2: ( EqualsSign )
                    {
                    // InternalRegularExpressionParser.g:1341:2: ( EqualsSign )
                    // InternalRegularExpressionParser.g:1342:3: EqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersEqualsSignKeyword_1_0_1()); 
                    }
                    match(input,EqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersEqualsSignKeyword_1_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1347:2: ( Colon )
                    {
                    // InternalRegularExpressionParser.g:1347:2: ( Colon )
                    // InternalRegularExpressionParser.g:1348:3: Colon
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersColonKeyword_1_0_2()); 
                    }
                    match(input,Colon,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersColonKeyword_1_0_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRegularExpressionParser.g:1353:2: ( ExclamationMark )
                    {
                    // InternalRegularExpressionParser.g:1353:2: ( ExclamationMark )
                    // InternalRegularExpressionParser.g:1354:3: ExclamationMark
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersExclamationMarkKeyword_1_0_3()); 
                    }
                    match(input,ExclamationMark,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersExclamationMarkKeyword_1_0_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRegularExpressionParser.g:1359:2: ( HyphenMinus )
                    {
                    // InternalRegularExpressionParser.g:1359:2: ( HyphenMinus )
                    // InternalRegularExpressionParser.g:1360:3: HyphenMinus
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersHyphenMinusKeyword_1_0_4()); 
                    }
                    match(input,HyphenMinus,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersHyphenMinusKeyword_1_0_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRegularExpressionParser.g:1365:2: ( CircumflexAccent )
                    {
                    // InternalRegularExpressionParser.g:1365:2: ( CircumflexAccent )
                    // InternalRegularExpressionParser.g:1366:3: CircumflexAccent
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersCircumflexAccentKeyword_1_0_5()); 
                    }
                    match(input,CircumflexAccent,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersCircumflexAccentKeyword_1_0_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalRegularExpressionParser.g:1371:2: ( DollarSign )
                    {
                    // InternalRegularExpressionParser.g:1371:2: ( DollarSign )
                    // InternalRegularExpressionParser.g:1372:3: DollarSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersDollarSignKeyword_1_0_6()); 
                    }
                    match(input,DollarSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersDollarSignKeyword_1_0_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalRegularExpressionParser.g:1377:2: ( FullStop )
                    {
                    // InternalRegularExpressionParser.g:1377:2: ( FullStop )
                    // InternalRegularExpressionParser.g:1378:3: FullStop
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersFullStopKeyword_1_0_7()); 
                    }
                    match(input,FullStop,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersFullStopKeyword_1_0_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalRegularExpressionParser.g:1383:2: ( Asterisk )
                    {
                    // InternalRegularExpressionParser.g:1383:2: ( Asterisk )
                    // InternalRegularExpressionParser.g:1384:3: Asterisk
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersAsteriskKeyword_1_0_8()); 
                    }
                    match(input,Asterisk,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersAsteriskKeyword_1_0_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalRegularExpressionParser.g:1389:2: ( PlusSign )
                    {
                    // InternalRegularExpressionParser.g:1389:2: ( PlusSign )
                    // InternalRegularExpressionParser.g:1390:3: PlusSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersPlusSignKeyword_1_0_9()); 
                    }
                    match(input,PlusSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersPlusSignKeyword_1_0_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalRegularExpressionParser.g:1395:2: ( QuestionMark )
                    {
                    // InternalRegularExpressionParser.g:1395:2: ( QuestionMark )
                    // InternalRegularExpressionParser.g:1396:3: QuestionMark
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersQuestionMarkKeyword_1_0_10()); 
                    }
                    match(input,QuestionMark,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersQuestionMarkKeyword_1_0_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalRegularExpressionParser.g:1401:2: ( LeftParenthesis )
                    {
                    // InternalRegularExpressionParser.g:1401:2: ( LeftParenthesis )
                    // InternalRegularExpressionParser.g:1402:3: LeftParenthesis
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisKeyword_1_0_11()); 
                    }
                    match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisKeyword_1_0_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalRegularExpressionParser.g:1407:2: ( RightParenthesis )
                    {
                    // InternalRegularExpressionParser.g:1407:2: ( RightParenthesis )
                    // InternalRegularExpressionParser.g:1408:3: RightParenthesis
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersRightParenthesisKeyword_1_0_12()); 
                    }
                    match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersRightParenthesisKeyword_1_0_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalRegularExpressionParser.g:1413:2: ( LeftSquareBracket )
                    {
                    // InternalRegularExpressionParser.g:1413:2: ( LeftSquareBracket )
                    // InternalRegularExpressionParser.g:1414:3: LeftSquareBracket
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftSquareBracketKeyword_1_0_13()); 
                    }
                    match(input,LeftSquareBracket,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftSquareBracketKeyword_1_0_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalRegularExpressionParser.g:1419:2: ( LeftCurlyBracket )
                    {
                    // InternalRegularExpressionParser.g:1419:2: ( LeftCurlyBracket )
                    // InternalRegularExpressionParser.g:1420:3: LeftCurlyBracket
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftCurlyBracketKeyword_1_0_14()); 
                    }
                    match(input,LeftCurlyBracket,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftCurlyBracketKeyword_1_0_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalRegularExpressionParser.g:1425:2: ( RightCurlyBracket )
                    {
                    // InternalRegularExpressionParser.g:1425:2: ( RightCurlyBracket )
                    // InternalRegularExpressionParser.g:1426:3: RightCurlyBracket
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersRightCurlyBracketKeyword_1_0_15()); 
                    }
                    match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersRightCurlyBracketKeyword_1_0_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalRegularExpressionParser.g:1431:2: ( VerticalLine )
                    {
                    // InternalRegularExpressionParser.g:1431:2: ( VerticalLine )
                    // InternalRegularExpressionParser.g:1432:3: VerticalLine
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersVerticalLineKeyword_1_0_16()); 
                    }
                    match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersVerticalLineKeyword_1_0_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalRegularExpressionParser.g:1437:2: ( Solidus )
                    {
                    // InternalRegularExpressionParser.g:1437:2: ( Solidus )
                    // InternalRegularExpressionParser.g:1438:3: Solidus
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersSolidusKeyword_1_0_17()); 
                    }
                    match(input,Solidus,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersSolidusKeyword_1_0_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalRegularExpressionParser.g:1443:2: ( LessThanSign )
                    {
                    // InternalRegularExpressionParser.g:1443:2: ( LessThanSign )
                    // InternalRegularExpressionParser.g:1444:3: LessThanSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLessThanSignKeyword_1_0_18()); 
                    }
                    match(input,LessThanSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLessThanSignKeyword_1_0_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalRegularExpressionParser.g:1449:2: ( GreaterThanSign )
                    {
                    // InternalRegularExpressionParser.g:1449:2: ( GreaterThanSign )
                    // InternalRegularExpressionParser.g:1450:3: GreaterThanSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersGreaterThanSignKeyword_1_0_19()); 
                    }
                    match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersGreaterThanSignKeyword_1_0_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalRegularExpressionParser.g:1455:2: ( LeftParenthesisQuestionMark )
                    {
                    // InternalRegularExpressionParser.g:1455:2: ( LeftParenthesisQuestionMark )
                    // InternalRegularExpressionParser.g:1456:3: LeftParenthesisQuestionMark
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkKeyword_1_0_20()); 
                    }
                    match(input,LeftParenthesisQuestionMark,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkKeyword_1_0_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalRegularExpressionParser.g:1461:2: ( LeftParenthesisQuestionMarkLessThanSign )
                    {
                    // InternalRegularExpressionParser.g:1461:2: ( LeftParenthesisQuestionMarkLessThanSign )
                    // InternalRegularExpressionParser.g:1462:3: LeftParenthesisQuestionMarkLessThanSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkLessThanSignKeyword_1_0_21()); 
                    }
                    match(input,LeftParenthesisQuestionMarkLessThanSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkLessThanSignKeyword_1_0_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalRegularExpressionParser.g:1467:2: ( LeftParenthesisQuestionMarkEqualsSign )
                    {
                    // InternalRegularExpressionParser.g:1467:2: ( LeftParenthesisQuestionMarkEqualsSign )
                    // InternalRegularExpressionParser.g:1468:3: LeftParenthesisQuestionMarkEqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkEqualsSignKeyword_1_0_22()); 
                    }
                    match(input,LeftParenthesisQuestionMarkEqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkEqualsSignKeyword_1_0_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalRegularExpressionParser.g:1473:2: ( LeftParenthesisQuestionMarkExclamationMark )
                    {
                    // InternalRegularExpressionParser.g:1473:2: ( LeftParenthesisQuestionMarkExclamationMark )
                    // InternalRegularExpressionParser.g:1474:3: LeftParenthesisQuestionMarkExclamationMark
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkExclamationMarkKeyword_1_0_23()); 
                    }
                    match(input,LeftParenthesisQuestionMarkExclamationMark,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkExclamationMarkKeyword_1_0_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalRegularExpressionParser.g:1479:2: ( LeftParenthesisQuestionMarkLessThanSignExclamationMark )
                    {
                    // InternalRegularExpressionParser.g:1479:2: ( LeftParenthesisQuestionMarkLessThanSignExclamationMark )
                    // InternalRegularExpressionParser.g:1480:3: LeftParenthesisQuestionMarkLessThanSignExclamationMark
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkLessThanSignExclamationMarkKeyword_1_0_24()); 
                    }
                    match(input,LeftParenthesisQuestionMarkLessThanSignExclamationMark,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkLessThanSignExclamationMarkKeyword_1_0_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // InternalRegularExpressionParser.g:1485:2: ( LeftParenthesisQuestionMarkLessThanSignEqualsSign )
                    {
                    // InternalRegularExpressionParser.g:1485:2: ( LeftParenthesisQuestionMarkLessThanSignEqualsSign )
                    // InternalRegularExpressionParser.g:1486:3: LeftParenthesisQuestionMarkLessThanSignEqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkLessThanSignEqualsSignKeyword_1_0_25()); 
                    }
                    match(input,LeftParenthesisQuestionMarkLessThanSignEqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersLeftParenthesisQuestionMarkLessThanSignEqualsSignKeyword_1_0_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // InternalRegularExpressionParser.g:1491:2: ( RULE_PATTERN_CHARACTER_NO_DASH )
                    {
                    // InternalRegularExpressionParser.g:1491:2: ( RULE_PATTERN_CHARACTER_NO_DASH )
                    // InternalRegularExpressionParser.g:1492:3: RULE_PATTERN_CHARACTER_NO_DASH
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersPATTERN_CHARACTER_NO_DASHTerminalRuleCall_1_0_26()); 
                    }
                    match(input,RULE_PATTERN_CHARACTER_NO_DASH,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersPATTERN_CHARACTER_NO_DASHTerminalRuleCall_1_0_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // InternalRegularExpressionParser.g:1497:2: ( RULE_UNICODE_LETTER )
                    {
                    // InternalRegularExpressionParser.g:1497:2: ( RULE_UNICODE_LETTER )
                    // InternalRegularExpressionParser.g:1498:3: RULE_UNICODE_LETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersUNICODE_LETTERTerminalRuleCall_1_0_27()); 
                    }
                    match(input,RULE_UNICODE_LETTER,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersUNICODE_LETTERTerminalRuleCall_1_0_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // InternalRegularExpressionParser.g:1503:2: ( RULE_UNICODE_DIGIT )
                    {
                    // InternalRegularExpressionParser.g:1503:2: ( RULE_UNICODE_DIGIT )
                    // InternalRegularExpressionParser.g:1504:3: RULE_UNICODE_DIGIT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCharacterClassAtomAccess().getCharactersUNICODE_DIGITTerminalRuleCall_1_0_28()); 
                    }
                    match(input,RULE_UNICODE_DIGIT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCharacterClassAtomAccess().getCharactersUNICODE_DIGITTerminalRuleCall_1_0_28()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassAtom__CharactersAlternatives_1_0"


    // $ANTLR start "rule__EscapedCharacterClassAtom__Alternatives"
    // InternalRegularExpressionParser.g:1513:1: rule__EscapedCharacterClassAtom__Alternatives : ( ( ruleDecimalEscapeSequence ) | ( ruleBackspace ) | ( ruleCharacterEscapeSequence ) | ( ruleControlLetterEscapeSequence ) | ( ruleHexEscapeSequence ) | ( ruleUnicodeEscapeSequence ) | ( ruleIdentityEscapeSequence ) | ( ruleCharacterClassEscapeSequence ) );
    public final void rule__EscapedCharacterClassAtom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1517:1: ( ( ruleDecimalEscapeSequence ) | ( ruleBackspace ) | ( ruleCharacterEscapeSequence ) | ( ruleControlLetterEscapeSequence ) | ( ruleHexEscapeSequence ) | ( ruleUnicodeEscapeSequence ) | ( ruleIdentityEscapeSequence ) | ( ruleCharacterClassEscapeSequence ) )
            int alt14=8;
            switch ( input.LA(1) ) {
            case RULE_DECIMAL_ESCAPE:
                {
                alt14=1;
                }
                break;
            case RULE_WORD_BOUNDARY:
                {
                alt14=2;
                }
                break;
            case RULE_CONTROL_ESCAPE:
                {
                alt14=3;
                }
                break;
            case RULE_CONTROL_LETTER_ESCAPE:
                {
                alt14=4;
                }
                break;
            case RULE_HEX_ESCAPE:
                {
                alt14=5;
                }
                break;
            case RULE_UNICODE_ESCAPE:
                {
                alt14=6;
                }
                break;
            case RULE_IDENTITY_ESCAPE:
                {
                alt14=7;
                }
                break;
            case RULE_CHARACTER_CLASS_ESCAPE:
                {
                alt14=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalRegularExpressionParser.g:1518:2: ( ruleDecimalEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1518:2: ( ruleDecimalEscapeSequence )
                    // InternalRegularExpressionParser.g:1519:3: ruleDecimalEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEscapedCharacterClassAtomAccess().getDecimalEscapeSequenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDecimalEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEscapedCharacterClassAtomAccess().getDecimalEscapeSequenceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1524:2: ( ruleBackspace )
                    {
                    // InternalRegularExpressionParser.g:1524:2: ( ruleBackspace )
                    // InternalRegularExpressionParser.g:1525:3: ruleBackspace
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEscapedCharacterClassAtomAccess().getBackspaceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBackspace();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEscapedCharacterClassAtomAccess().getBackspaceParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1530:2: ( ruleCharacterEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1530:2: ( ruleCharacterEscapeSequence )
                    // InternalRegularExpressionParser.g:1531:3: ruleCharacterEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEscapedCharacterClassAtomAccess().getCharacterEscapeSequenceParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCharacterEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEscapedCharacterClassAtomAccess().getCharacterEscapeSequenceParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRegularExpressionParser.g:1536:2: ( ruleControlLetterEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1536:2: ( ruleControlLetterEscapeSequence )
                    // InternalRegularExpressionParser.g:1537:3: ruleControlLetterEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEscapedCharacterClassAtomAccess().getControlLetterEscapeSequenceParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleControlLetterEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEscapedCharacterClassAtomAccess().getControlLetterEscapeSequenceParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRegularExpressionParser.g:1542:2: ( ruleHexEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1542:2: ( ruleHexEscapeSequence )
                    // InternalRegularExpressionParser.g:1543:3: ruleHexEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEscapedCharacterClassAtomAccess().getHexEscapeSequenceParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleHexEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEscapedCharacterClassAtomAccess().getHexEscapeSequenceParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRegularExpressionParser.g:1548:2: ( ruleUnicodeEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1548:2: ( ruleUnicodeEscapeSequence )
                    // InternalRegularExpressionParser.g:1549:3: ruleUnicodeEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEscapedCharacterClassAtomAccess().getUnicodeEscapeSequenceParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleUnicodeEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEscapedCharacterClassAtomAccess().getUnicodeEscapeSequenceParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalRegularExpressionParser.g:1554:2: ( ruleIdentityEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1554:2: ( ruleIdentityEscapeSequence )
                    // InternalRegularExpressionParser.g:1555:3: ruleIdentityEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEscapedCharacterClassAtomAccess().getIdentityEscapeSequenceParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIdentityEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEscapedCharacterClassAtomAccess().getIdentityEscapeSequenceParserRuleCall_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalRegularExpressionParser.g:1560:2: ( ruleCharacterClassEscapeSequence )
                    {
                    // InternalRegularExpressionParser.g:1560:2: ( ruleCharacterClassEscapeSequence )
                    // InternalRegularExpressionParser.g:1561:3: ruleCharacterClassEscapeSequence
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEscapedCharacterClassAtomAccess().getCharacterClassEscapeSequenceParserRuleCall_7()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCharacterClassEscapeSequence();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEscapedCharacterClassAtomAccess().getCharacterClassEscapeSequenceParserRuleCall_7()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EscapedCharacterClassAtom__Alternatives"


    // $ANTLR start "rule__Group__Alternatives_1"
    // InternalRegularExpressionParser.g:1570:1: rule__Group__Alternatives_1 : ( ( LeftParenthesis ) | ( ( rule__Group__NonCapturingAssignment_1_1 ) ) | ( ( rule__Group__Group_1_2__0 ) ) );
    public final void rule__Group__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1574:1: ( ( LeftParenthesis ) | ( ( rule__Group__NonCapturingAssignment_1_1 ) ) | ( ( rule__Group__Group_1_2__0 ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case LeftParenthesis:
                {
                alt15=1;
                }
                break;
            case LeftParenthesisQuestionMarkColon:
                {
                alt15=2;
                }
                break;
            case LeftParenthesisQuestionMarkLessThanSign:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalRegularExpressionParser.g:1575:2: ( LeftParenthesis )
                    {
                    // InternalRegularExpressionParser.g:1575:2: ( LeftParenthesis )
                    // InternalRegularExpressionParser.g:1576:3: LeftParenthesis
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupAccess().getLeftParenthesisKeyword_1_0()); 
                    }
                    match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupAccess().getLeftParenthesisKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1581:2: ( ( rule__Group__NonCapturingAssignment_1_1 ) )
                    {
                    // InternalRegularExpressionParser.g:1581:2: ( ( rule__Group__NonCapturingAssignment_1_1 ) )
                    // InternalRegularExpressionParser.g:1582:3: ( rule__Group__NonCapturingAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupAccess().getNonCapturingAssignment_1_1()); 
                    }
                    // InternalRegularExpressionParser.g:1583:3: ( rule__Group__NonCapturingAssignment_1_1 )
                    // InternalRegularExpressionParser.g:1583:4: rule__Group__NonCapturingAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Group__NonCapturingAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupAccess().getNonCapturingAssignment_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1587:2: ( ( rule__Group__Group_1_2__0 ) )
                    {
                    // InternalRegularExpressionParser.g:1587:2: ( ( rule__Group__Group_1_2__0 ) )
                    // InternalRegularExpressionParser.g:1588:3: ( rule__Group__Group_1_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupAccess().getGroup_1_2()); 
                    }
                    // InternalRegularExpressionParser.g:1589:3: ( rule__Group__Group_1_2__0 )
                    // InternalRegularExpressionParser.g:1589:4: rule__Group__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Group__Group_1_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupAccess().getGroup_1_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Alternatives_1"


    // $ANTLR start "rule__RegExpIdentifierStart__Alternatives"
    // InternalRegularExpressionParser.g:1597:1: rule__RegExpIdentifierStart__Alternatives : ( ( RULE_UNICODE_LETTER ) | ( DollarSign ) | ( KW__ ) | ( RULE_UNICODE_ESCAPE ) );
    public final void rule__RegExpIdentifierStart__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1601:1: ( ( RULE_UNICODE_LETTER ) | ( DollarSign ) | ( KW__ ) | ( RULE_UNICODE_ESCAPE ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_UNICODE_LETTER:
                {
                alt16=1;
                }
                break;
            case DollarSign:
                {
                alt16=2;
                }
                break;
            case KW__:
                {
                alt16=3;
                }
                break;
            case RULE_UNICODE_ESCAPE:
                {
                alt16=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalRegularExpressionParser.g:1602:2: ( RULE_UNICODE_LETTER )
                    {
                    // InternalRegularExpressionParser.g:1602:2: ( RULE_UNICODE_LETTER )
                    // InternalRegularExpressionParser.g:1603:3: RULE_UNICODE_LETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierStartAccess().getUNICODE_LETTERTerminalRuleCall_0()); 
                    }
                    match(input,RULE_UNICODE_LETTER,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierStartAccess().getUNICODE_LETTERTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1608:2: ( DollarSign )
                    {
                    // InternalRegularExpressionParser.g:1608:2: ( DollarSign )
                    // InternalRegularExpressionParser.g:1609:3: DollarSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierStartAccess().getDollarSignKeyword_1()); 
                    }
                    match(input,DollarSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierStartAccess().getDollarSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1614:2: ( KW__ )
                    {
                    // InternalRegularExpressionParser.g:1614:2: ( KW__ )
                    // InternalRegularExpressionParser.g:1615:3: KW__
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierStartAccess().get_Keyword_2()); 
                    }
                    match(input,KW__,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierStartAccess().get_Keyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRegularExpressionParser.g:1620:2: ( RULE_UNICODE_ESCAPE )
                    {
                    // InternalRegularExpressionParser.g:1620:2: ( RULE_UNICODE_ESCAPE )
                    // InternalRegularExpressionParser.g:1621:3: RULE_UNICODE_ESCAPE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierStartAccess().getUNICODE_ESCAPETerminalRuleCall_3()); 
                    }
                    match(input,RULE_UNICODE_ESCAPE,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierStartAccess().getUNICODE_ESCAPETerminalRuleCall_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegExpIdentifierStart__Alternatives"


    // $ANTLR start "rule__RegExpIdentifierPart__Alternatives"
    // InternalRegularExpressionParser.g:1630:1: rule__RegExpIdentifierPart__Alternatives : ( ( RULE_UNICODE_LETTER ) | ( RULE_UNICODE_DIGIT ) | ( DollarSign ) | ( KW__ ) | ( RULE_UNICODE_ESCAPE ) );
    public final void rule__RegExpIdentifierPart__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1634:1: ( ( RULE_UNICODE_LETTER ) | ( RULE_UNICODE_DIGIT ) | ( DollarSign ) | ( KW__ ) | ( RULE_UNICODE_ESCAPE ) )
            int alt17=5;
            switch ( input.LA(1) ) {
            case RULE_UNICODE_LETTER:
                {
                alt17=1;
                }
                break;
            case RULE_UNICODE_DIGIT:
                {
                alt17=2;
                }
                break;
            case DollarSign:
                {
                alt17=3;
                }
                break;
            case KW__:
                {
                alt17=4;
                }
                break;
            case RULE_UNICODE_ESCAPE:
                {
                alt17=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalRegularExpressionParser.g:1635:2: ( RULE_UNICODE_LETTER )
                    {
                    // InternalRegularExpressionParser.g:1635:2: ( RULE_UNICODE_LETTER )
                    // InternalRegularExpressionParser.g:1636:3: RULE_UNICODE_LETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierPartAccess().getUNICODE_LETTERTerminalRuleCall_0()); 
                    }
                    match(input,RULE_UNICODE_LETTER,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierPartAccess().getUNICODE_LETTERTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1641:2: ( RULE_UNICODE_DIGIT )
                    {
                    // InternalRegularExpressionParser.g:1641:2: ( RULE_UNICODE_DIGIT )
                    // InternalRegularExpressionParser.g:1642:3: RULE_UNICODE_DIGIT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierPartAccess().getUNICODE_DIGITTerminalRuleCall_1()); 
                    }
                    match(input,RULE_UNICODE_DIGIT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierPartAccess().getUNICODE_DIGITTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1647:2: ( DollarSign )
                    {
                    // InternalRegularExpressionParser.g:1647:2: ( DollarSign )
                    // InternalRegularExpressionParser.g:1648:3: DollarSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierPartAccess().getDollarSignKeyword_2()); 
                    }
                    match(input,DollarSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierPartAccess().getDollarSignKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRegularExpressionParser.g:1653:2: ( KW__ )
                    {
                    // InternalRegularExpressionParser.g:1653:2: ( KW__ )
                    // InternalRegularExpressionParser.g:1654:3: KW__
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierPartAccess().get_Keyword_3()); 
                    }
                    match(input,KW__,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierPartAccess().get_Keyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRegularExpressionParser.g:1659:2: ( RULE_UNICODE_ESCAPE )
                    {
                    // InternalRegularExpressionParser.g:1659:2: ( RULE_UNICODE_ESCAPE )
                    // InternalRegularExpressionParser.g:1660:3: RULE_UNICODE_ESCAPE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegExpIdentifierPartAccess().getUNICODE_ESCAPETerminalRuleCall_4()); 
                    }
                    match(input,RULE_UNICODE_ESCAPE,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegExpIdentifierPartAccess().getUNICODE_ESCAPETerminalRuleCall_4()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegExpIdentifierPart__Alternatives"


    // $ANTLR start "rule__Quantifier__Alternatives"
    // InternalRegularExpressionParser.g:1669:1: rule__Quantifier__Alternatives : ( ( ruleSimpleQuantifier ) | ( ruleExactQuantifier ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1673:1: ( ( ruleSimpleQuantifier ) | ( ruleExactQuantifier ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=Asterisk && LA18_0<=PlusSign)||LA18_0==QuestionMark) ) {
                alt18=1;
            }
            else if ( (LA18_0==LeftCurlyBracket) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalRegularExpressionParser.g:1674:2: ( ruleSimpleQuantifier )
                    {
                    // InternalRegularExpressionParser.g:1674:2: ( ruleSimpleQuantifier )
                    // InternalRegularExpressionParser.g:1675:3: ruleSimpleQuantifier
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuantifierAccess().getSimpleQuantifierParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSimpleQuantifier();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuantifierAccess().getSimpleQuantifierParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1680:2: ( ruleExactQuantifier )
                    {
                    // InternalRegularExpressionParser.g:1680:2: ( ruleExactQuantifier )
                    // InternalRegularExpressionParser.g:1681:3: ruleExactQuantifier
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuantifierAccess().getExactQuantifierParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleExactQuantifier();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuantifierAccess().getExactQuantifierParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quantifier__Alternatives"


    // $ANTLR start "rule__SimpleQuantifier__QuantifierAlternatives_0_0"
    // InternalRegularExpressionParser.g:1690:1: rule__SimpleQuantifier__QuantifierAlternatives_0_0 : ( ( PlusSign ) | ( Asterisk ) | ( QuestionMark ) );
    public final void rule__SimpleQuantifier__QuantifierAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1694:1: ( ( PlusSign ) | ( Asterisk ) | ( QuestionMark ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                alt19=1;
                }
                break;
            case Asterisk:
                {
                alt19=2;
                }
                break;
            case QuestionMark:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalRegularExpressionParser.g:1695:2: ( PlusSign )
                    {
                    // InternalRegularExpressionParser.g:1695:2: ( PlusSign )
                    // InternalRegularExpressionParser.g:1696:3: PlusSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleQuantifierAccess().getQuantifierPlusSignKeyword_0_0_0()); 
                    }
                    match(input,PlusSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleQuantifierAccess().getQuantifierPlusSignKeyword_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1701:2: ( Asterisk )
                    {
                    // InternalRegularExpressionParser.g:1701:2: ( Asterisk )
                    // InternalRegularExpressionParser.g:1702:3: Asterisk
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleQuantifierAccess().getQuantifierAsteriskKeyword_0_0_1()); 
                    }
                    match(input,Asterisk,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleQuantifierAccess().getQuantifierAsteriskKeyword_0_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRegularExpressionParser.g:1707:2: ( QuestionMark )
                    {
                    // InternalRegularExpressionParser.g:1707:2: ( QuestionMark )
                    // InternalRegularExpressionParser.g:1708:3: QuestionMark
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleQuantifierAccess().getQuantifierQuestionMarkKeyword_0_0_2()); 
                    }
                    match(input,QuestionMark,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleQuantifierAccess().getQuantifierQuestionMarkKeyword_0_0_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleQuantifier__QuantifierAlternatives_0_0"


    // $ANTLR start "rule__ExactQuantifier__Alternatives_3"
    // InternalRegularExpressionParser.g:1717:1: rule__ExactQuantifier__Alternatives_3 : ( ( ( rule__ExactQuantifier__Group_3_0__0 ) ) | ( ( rule__ExactQuantifier__UnboundedMaxAssignment_3_1 ) ) );
    public final void rule__ExactQuantifier__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1721:1: ( ( ( rule__ExactQuantifier__Group_3_0__0 ) ) | ( ( rule__ExactQuantifier__UnboundedMaxAssignment_3_1 ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Comma) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==EOF||LA20_1==RightCurlyBracket) ) {
                    alt20=2;
                }
                else if ( (LA20_1==RULE_UNICODE_DIGIT) ) {
                    alt20=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalRegularExpressionParser.g:1722:2: ( ( rule__ExactQuantifier__Group_3_0__0 ) )
                    {
                    // InternalRegularExpressionParser.g:1722:2: ( ( rule__ExactQuantifier__Group_3_0__0 ) )
                    // InternalRegularExpressionParser.g:1723:3: ( rule__ExactQuantifier__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getExactQuantifierAccess().getGroup_3_0()); 
                    }
                    // InternalRegularExpressionParser.g:1724:3: ( rule__ExactQuantifier__Group_3_0__0 )
                    // InternalRegularExpressionParser.g:1724:4: rule__ExactQuantifier__Group_3_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExactQuantifier__Group_3_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getExactQuantifierAccess().getGroup_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1728:2: ( ( rule__ExactQuantifier__UnboundedMaxAssignment_3_1 ) )
                    {
                    // InternalRegularExpressionParser.g:1728:2: ( ( rule__ExactQuantifier__UnboundedMaxAssignment_3_1 ) )
                    // InternalRegularExpressionParser.g:1729:3: ( rule__ExactQuantifier__UnboundedMaxAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getExactQuantifierAccess().getUnboundedMaxAssignment_3_1()); 
                    }
                    // InternalRegularExpressionParser.g:1730:3: ( rule__ExactQuantifier__UnboundedMaxAssignment_3_1 )
                    // InternalRegularExpressionParser.g:1730:4: rule__ExactQuantifier__UnboundedMaxAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExactQuantifier__UnboundedMaxAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getExactQuantifierAccess().getUnboundedMaxAssignment_3_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Alternatives_3"


    // $ANTLR start "rule__RegularExpressionFlags__FlagsAlternatives_1_0"
    // InternalRegularExpressionParser.g:1738:1: rule__RegularExpressionFlags__FlagsAlternatives_1_0 : ( ( RULE_UNICODE_LETTER ) | ( RULE_UNICODE_ESCAPE ) );
    public final void rule__RegularExpressionFlags__FlagsAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1742:1: ( ( RULE_UNICODE_LETTER ) | ( RULE_UNICODE_ESCAPE ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_UNICODE_LETTER) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_UNICODE_ESCAPE) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalRegularExpressionParser.g:1743:2: ( RULE_UNICODE_LETTER )
                    {
                    // InternalRegularExpressionParser.g:1743:2: ( RULE_UNICODE_LETTER )
                    // InternalRegularExpressionParser.g:1744:3: RULE_UNICODE_LETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegularExpressionFlagsAccess().getFlagsUNICODE_LETTERTerminalRuleCall_1_0_0()); 
                    }
                    match(input,RULE_UNICODE_LETTER,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegularExpressionFlagsAccess().getFlagsUNICODE_LETTERTerminalRuleCall_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRegularExpressionParser.g:1749:2: ( RULE_UNICODE_ESCAPE )
                    {
                    // InternalRegularExpressionParser.g:1749:2: ( RULE_UNICODE_ESCAPE )
                    // InternalRegularExpressionParser.g:1750:3: RULE_UNICODE_ESCAPE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRegularExpressionFlagsAccess().getFlagsUNICODE_ESCAPETerminalRuleCall_1_0_1()); 
                    }
                    match(input,RULE_UNICODE_ESCAPE,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRegularExpressionFlagsAccess().getFlagsUNICODE_ESCAPETerminalRuleCall_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionFlags__FlagsAlternatives_1_0"


    // $ANTLR start "rule__RegularExpressionLiteral__Group__0"
    // InternalRegularExpressionParser.g:1759:1: rule__RegularExpressionLiteral__Group__0 : rule__RegularExpressionLiteral__Group__0__Impl rule__RegularExpressionLiteral__Group__1 ;
    public final void rule__RegularExpressionLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1763:1: ( rule__RegularExpressionLiteral__Group__0__Impl rule__RegularExpressionLiteral__Group__1 )
            // InternalRegularExpressionParser.g:1764:2: rule__RegularExpressionLiteral__Group__0__Impl rule__RegularExpressionLiteral__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__RegularExpressionLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RegularExpressionLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__Group__0"


    // $ANTLR start "rule__RegularExpressionLiteral__Group__0__Impl"
    // InternalRegularExpressionParser.g:1771:1: rule__RegularExpressionLiteral__Group__0__Impl : ( Solidus ) ;
    public final void rule__RegularExpressionLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1775:1: ( ( Solidus ) )
            // InternalRegularExpressionParser.g:1776:1: ( Solidus )
            {
            // InternalRegularExpressionParser.g:1776:1: ( Solidus )
            // InternalRegularExpressionParser.g:1777:2: Solidus
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionLiteralAccess().getSolidusKeyword_0()); 
            }
            match(input,Solidus,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionLiteralAccess().getSolidusKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__Group__0__Impl"


    // $ANTLR start "rule__RegularExpressionLiteral__Group__1"
    // InternalRegularExpressionParser.g:1786:1: rule__RegularExpressionLiteral__Group__1 : rule__RegularExpressionLiteral__Group__1__Impl rule__RegularExpressionLiteral__Group__2 ;
    public final void rule__RegularExpressionLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1790:1: ( rule__RegularExpressionLiteral__Group__1__Impl rule__RegularExpressionLiteral__Group__2 )
            // InternalRegularExpressionParser.g:1791:2: rule__RegularExpressionLiteral__Group__1__Impl rule__RegularExpressionLiteral__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__RegularExpressionLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RegularExpressionLiteral__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__Group__1"


    // $ANTLR start "rule__RegularExpressionLiteral__Group__1__Impl"
    // InternalRegularExpressionParser.g:1798:1: rule__RegularExpressionLiteral__Group__1__Impl : ( ( rule__RegularExpressionLiteral__BodyAssignment_1 ) ) ;
    public final void rule__RegularExpressionLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1802:1: ( ( ( rule__RegularExpressionLiteral__BodyAssignment_1 ) ) )
            // InternalRegularExpressionParser.g:1803:1: ( ( rule__RegularExpressionLiteral__BodyAssignment_1 ) )
            {
            // InternalRegularExpressionParser.g:1803:1: ( ( rule__RegularExpressionLiteral__BodyAssignment_1 ) )
            // InternalRegularExpressionParser.g:1804:2: ( rule__RegularExpressionLiteral__BodyAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionLiteralAccess().getBodyAssignment_1()); 
            }
            // InternalRegularExpressionParser.g:1805:2: ( rule__RegularExpressionLiteral__BodyAssignment_1 )
            // InternalRegularExpressionParser.g:1805:3: rule__RegularExpressionLiteral__BodyAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RegularExpressionLiteral__BodyAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionLiteralAccess().getBodyAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__Group__1__Impl"


    // $ANTLR start "rule__RegularExpressionLiteral__Group__2"
    // InternalRegularExpressionParser.g:1813:1: rule__RegularExpressionLiteral__Group__2 : rule__RegularExpressionLiteral__Group__2__Impl rule__RegularExpressionLiteral__Group__3 ;
    public final void rule__RegularExpressionLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1817:1: ( rule__RegularExpressionLiteral__Group__2__Impl rule__RegularExpressionLiteral__Group__3 )
            // InternalRegularExpressionParser.g:1818:2: rule__RegularExpressionLiteral__Group__2__Impl rule__RegularExpressionLiteral__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__RegularExpressionLiteral__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RegularExpressionLiteral__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__Group__2"


    // $ANTLR start "rule__RegularExpressionLiteral__Group__2__Impl"
    // InternalRegularExpressionParser.g:1825:1: rule__RegularExpressionLiteral__Group__2__Impl : ( Solidus ) ;
    public final void rule__RegularExpressionLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1829:1: ( ( Solidus ) )
            // InternalRegularExpressionParser.g:1830:1: ( Solidus )
            {
            // InternalRegularExpressionParser.g:1830:1: ( Solidus )
            // InternalRegularExpressionParser.g:1831:2: Solidus
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionLiteralAccess().getSolidusKeyword_2()); 
            }
            match(input,Solidus,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionLiteralAccess().getSolidusKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__Group__2__Impl"


    // $ANTLR start "rule__RegularExpressionLiteral__Group__3"
    // InternalRegularExpressionParser.g:1840:1: rule__RegularExpressionLiteral__Group__3 : rule__RegularExpressionLiteral__Group__3__Impl ;
    public final void rule__RegularExpressionLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1844:1: ( rule__RegularExpressionLiteral__Group__3__Impl )
            // InternalRegularExpressionParser.g:1845:2: rule__RegularExpressionLiteral__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RegularExpressionLiteral__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__Group__3"


    // $ANTLR start "rule__RegularExpressionLiteral__Group__3__Impl"
    // InternalRegularExpressionParser.g:1851:1: rule__RegularExpressionLiteral__Group__3__Impl : ( ( rule__RegularExpressionLiteral__FlagsAssignment_3 ) ) ;
    public final void rule__RegularExpressionLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1855:1: ( ( ( rule__RegularExpressionLiteral__FlagsAssignment_3 ) ) )
            // InternalRegularExpressionParser.g:1856:1: ( ( rule__RegularExpressionLiteral__FlagsAssignment_3 ) )
            {
            // InternalRegularExpressionParser.g:1856:1: ( ( rule__RegularExpressionLiteral__FlagsAssignment_3 ) )
            // InternalRegularExpressionParser.g:1857:2: ( rule__RegularExpressionLiteral__FlagsAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionLiteralAccess().getFlagsAssignment_3()); 
            }
            // InternalRegularExpressionParser.g:1858:2: ( rule__RegularExpressionLiteral__FlagsAssignment_3 )
            // InternalRegularExpressionParser.g:1858:3: rule__RegularExpressionLiteral__FlagsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__RegularExpressionLiteral__FlagsAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionLiteralAccess().getFlagsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__Group__3__Impl"


    // $ANTLR start "rule__Disjunction__Group_0__0"
    // InternalRegularExpressionParser.g:1867:1: rule__Disjunction__Group_0__0 : rule__Disjunction__Group_0__0__Impl rule__Disjunction__Group_0__1 ;
    public final void rule__Disjunction__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1871:1: ( rule__Disjunction__Group_0__0__Impl rule__Disjunction__Group_0__1 )
            // InternalRegularExpressionParser.g:1872:2: rule__Disjunction__Group_0__0__Impl rule__Disjunction__Group_0__1
            {
            pushFollow(FOLLOW_7);
            rule__Disjunction__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0__0"


    // $ANTLR start "rule__Disjunction__Group_0__0__Impl"
    // InternalRegularExpressionParser.g:1879:1: rule__Disjunction__Group_0__0__Impl : ( ruleAlternative ) ;
    public final void rule__Disjunction__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1883:1: ( ( ruleAlternative ) )
            // InternalRegularExpressionParser.g:1884:1: ( ruleAlternative )
            {
            // InternalRegularExpressionParser.g:1884:1: ( ruleAlternative )
            // InternalRegularExpressionParser.g:1885:2: ruleAlternative
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getAlternativeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAlternative();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getAlternativeParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_0__1"
    // InternalRegularExpressionParser.g:1894:1: rule__Disjunction__Group_0__1 : rule__Disjunction__Group_0__1__Impl ;
    public final void rule__Disjunction__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1898:1: ( rule__Disjunction__Group_0__1__Impl )
            // InternalRegularExpressionParser.g:1899:2: rule__Disjunction__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0__1"


    // $ANTLR start "rule__Disjunction__Group_0__1__Impl"
    // InternalRegularExpressionParser.g:1905:1: rule__Disjunction__Group_0__1__Impl : ( ( rule__Disjunction__Group_0_1__0 )? ) ;
    public final void rule__Disjunction__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1909:1: ( ( ( rule__Disjunction__Group_0_1__0 )? ) )
            // InternalRegularExpressionParser.g:1910:1: ( ( rule__Disjunction__Group_0_1__0 )? )
            {
            // InternalRegularExpressionParser.g:1910:1: ( ( rule__Disjunction__Group_0_1__0 )? )
            // InternalRegularExpressionParser.g:1911:2: ( rule__Disjunction__Group_0_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getGroup_0_1()); 
            }
            // InternalRegularExpressionParser.g:1912:2: ( rule__Disjunction__Group_0_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==VerticalLine) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRegularExpressionParser.g:1912:3: rule__Disjunction__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Disjunction__Group_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getGroup_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_0_1__0"
    // InternalRegularExpressionParser.g:1921:1: rule__Disjunction__Group_0_1__0 : rule__Disjunction__Group_0_1__0__Impl rule__Disjunction__Group_0_1__1 ;
    public final void rule__Disjunction__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1925:1: ( rule__Disjunction__Group_0_1__0__Impl rule__Disjunction__Group_0_1__1 )
            // InternalRegularExpressionParser.g:1926:2: rule__Disjunction__Group_0_1__0__Impl rule__Disjunction__Group_0_1__1
            {
            pushFollow(FOLLOW_7);
            rule__Disjunction__Group_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0_1__0"


    // $ANTLR start "rule__Disjunction__Group_0_1__0__Impl"
    // InternalRegularExpressionParser.g:1933:1: rule__Disjunction__Group_0_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1937:1: ( ( () ) )
            // InternalRegularExpressionParser.g:1938:1: ( () )
            {
            // InternalRegularExpressionParser.g:1938:1: ( () )
            // InternalRegularExpressionParser.g:1939:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getDisjunctionElementsAction_0_1_0()); 
            }
            // InternalRegularExpressionParser.g:1940:2: ()
            // InternalRegularExpressionParser.g:1940:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getDisjunctionElementsAction_0_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_0_1__1"
    // InternalRegularExpressionParser.g:1948:1: rule__Disjunction__Group_0_1__1 : rule__Disjunction__Group_0_1__1__Impl ;
    public final void rule__Disjunction__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1952:1: ( rule__Disjunction__Group_0_1__1__Impl )
            // InternalRegularExpressionParser.g:1953:2: rule__Disjunction__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0_1__1"


    // $ANTLR start "rule__Disjunction__Group_0_1__1__Impl"
    // InternalRegularExpressionParser.g:1959:1: rule__Disjunction__Group_0_1__1__Impl : ( ( ( rule__Disjunction__Group_0_1_1__0 ) ) ( ( rule__Disjunction__Group_0_1_1__0 )* ) ) ;
    public final void rule__Disjunction__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1963:1: ( ( ( ( rule__Disjunction__Group_0_1_1__0 ) ) ( ( rule__Disjunction__Group_0_1_1__0 )* ) ) )
            // InternalRegularExpressionParser.g:1964:1: ( ( ( rule__Disjunction__Group_0_1_1__0 ) ) ( ( rule__Disjunction__Group_0_1_1__0 )* ) )
            {
            // InternalRegularExpressionParser.g:1964:1: ( ( ( rule__Disjunction__Group_0_1_1__0 ) ) ( ( rule__Disjunction__Group_0_1_1__0 )* ) )
            // InternalRegularExpressionParser.g:1965:2: ( ( rule__Disjunction__Group_0_1_1__0 ) ) ( ( rule__Disjunction__Group_0_1_1__0 )* )
            {
            // InternalRegularExpressionParser.g:1965:2: ( ( rule__Disjunction__Group_0_1_1__0 ) )
            // InternalRegularExpressionParser.g:1966:3: ( rule__Disjunction__Group_0_1_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getGroup_0_1_1()); 
            }
            // InternalRegularExpressionParser.g:1967:3: ( rule__Disjunction__Group_0_1_1__0 )
            // InternalRegularExpressionParser.g:1967:4: rule__Disjunction__Group_0_1_1__0
            {
            pushFollow(FOLLOW_8);
            rule__Disjunction__Group_0_1_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getGroup_0_1_1()); 
            }

            }

            // InternalRegularExpressionParser.g:1970:2: ( ( rule__Disjunction__Group_0_1_1__0 )* )
            // InternalRegularExpressionParser.g:1971:3: ( rule__Disjunction__Group_0_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getGroup_0_1_1()); 
            }
            // InternalRegularExpressionParser.g:1972:3: ( rule__Disjunction__Group_0_1_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==VerticalLine) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalRegularExpressionParser.g:1972:4: rule__Disjunction__Group_0_1_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Disjunction__Group_0_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getGroup_0_1_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0_1__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_0_1_1__0"
    // InternalRegularExpressionParser.g:1982:1: rule__Disjunction__Group_0_1_1__0 : rule__Disjunction__Group_0_1_1__0__Impl rule__Disjunction__Group_0_1_1__1 ;
    public final void rule__Disjunction__Group_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1986:1: ( rule__Disjunction__Group_0_1_1__0__Impl rule__Disjunction__Group_0_1_1__1 )
            // InternalRegularExpressionParser.g:1987:2: rule__Disjunction__Group_0_1_1__0__Impl rule__Disjunction__Group_0_1_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Disjunction__Group_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0_1_1__0"


    // $ANTLR start "rule__Disjunction__Group_0_1_1__0__Impl"
    // InternalRegularExpressionParser.g:1994:1: rule__Disjunction__Group_0_1_1__0__Impl : ( VerticalLine ) ;
    public final void rule__Disjunction__Group_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:1998:1: ( ( VerticalLine ) )
            // InternalRegularExpressionParser.g:1999:1: ( VerticalLine )
            {
            // InternalRegularExpressionParser.g:1999:1: ( VerticalLine )
            // InternalRegularExpressionParser.g:2000:2: VerticalLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_0_1_1_0()); 
            }
            match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0_1_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_0_1_1__1"
    // InternalRegularExpressionParser.g:2009:1: rule__Disjunction__Group_0_1_1__1 : rule__Disjunction__Group_0_1_1__1__Impl ;
    public final void rule__Disjunction__Group_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2013:1: ( rule__Disjunction__Group_0_1_1__1__Impl )
            // InternalRegularExpressionParser.g:2014:2: rule__Disjunction__Group_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0_1_1__1"


    // $ANTLR start "rule__Disjunction__Group_0_1_1__1__Impl"
    // InternalRegularExpressionParser.g:2020:1: rule__Disjunction__Group_0_1_1__1__Impl : ( ( rule__Disjunction__ElementsAssignment_0_1_1_1 )? ) ;
    public final void rule__Disjunction__Group_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2024:1: ( ( ( rule__Disjunction__ElementsAssignment_0_1_1_1 )? ) )
            // InternalRegularExpressionParser.g:2025:1: ( ( rule__Disjunction__ElementsAssignment_0_1_1_1 )? )
            {
            // InternalRegularExpressionParser.g:2025:1: ( ( rule__Disjunction__ElementsAssignment_0_1_1_1 )? )
            // InternalRegularExpressionParser.g:2026:2: ( rule__Disjunction__ElementsAssignment_0_1_1_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getElementsAssignment_0_1_1_1()); 
            }
            // InternalRegularExpressionParser.g:2027:2: ( rule__Disjunction__ElementsAssignment_0_1_1_1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA24_0<=LeftParenthesisQuestionMarkEqualsSign)||(LA24_0>=ExclamationMark && LA24_0<=LeftParenthesis)||(LA24_0>=Comma && LA24_0<=FullStop)||(LA24_0>=Colon && LA24_0<=GreaterThanSign)||(LA24_0>=LeftSquareBracket && LA24_0<=CircumflexAccent)||LA24_0==LeftCurlyBracket||(LA24_0>=RightCurlyBracket && LA24_0<=RULE_CONTROL_LETTER_ESCAPE)||(LA24_0>=RULE_HEX_ESCAPE && LA24_0<=RULE_UNICODE_ESCAPE)||(LA24_0>=RULE_DECIMAL_ESCAPE && LA24_0<=RULE_IDENTITY_ESCAPE)||LA24_0==RULE_UNICODE_DIGIT||(LA24_0>=RULE_UNICODE_LETTER && LA24_0<=RULE_PATTERN_CHARACTER_NO_DASH)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRegularExpressionParser.g:2027:3: rule__Disjunction__ElementsAssignment_0_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Disjunction__ElementsAssignment_0_1_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getElementsAssignment_0_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_0_1_1__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__0"
    // InternalRegularExpressionParser.g:2036:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2040:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // InternalRegularExpressionParser.g:2041:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Disjunction__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0"


    // $ANTLR start "rule__Disjunction__Group_1__0__Impl"
    // InternalRegularExpressionParser.g:2048:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2052:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2053:1: ( () )
            {
            // InternalRegularExpressionParser.g:2053:1: ( () )
            // InternalRegularExpressionParser.g:2054:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getDisjunctionAction_1_0()); 
            }
            // InternalRegularExpressionParser.g:2055:2: ()
            // InternalRegularExpressionParser.g:2055:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getDisjunctionAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__1"
    // InternalRegularExpressionParser.g:2063:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2067:1: ( rule__Disjunction__Group_1__1__Impl )
            // InternalRegularExpressionParser.g:2068:2: rule__Disjunction__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1"


    // $ANTLR start "rule__Disjunction__Group_1__1__Impl"
    // InternalRegularExpressionParser.g:2074:1: rule__Disjunction__Group_1__1__Impl : ( ( rule__Disjunction__Group_1_1__0 )* ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2078:1: ( ( ( rule__Disjunction__Group_1_1__0 )* ) )
            // InternalRegularExpressionParser.g:2079:1: ( ( rule__Disjunction__Group_1_1__0 )* )
            {
            // InternalRegularExpressionParser.g:2079:1: ( ( rule__Disjunction__Group_1_1__0 )* )
            // InternalRegularExpressionParser.g:2080:2: ( rule__Disjunction__Group_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getGroup_1_1()); 
            }
            // InternalRegularExpressionParser.g:2081:2: ( rule__Disjunction__Group_1_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==VerticalLine) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalRegularExpressionParser.g:2081:3: rule__Disjunction__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Disjunction__Group_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getGroup_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1_1__0"
    // InternalRegularExpressionParser.g:2090:1: rule__Disjunction__Group_1_1__0 : rule__Disjunction__Group_1_1__0__Impl rule__Disjunction__Group_1_1__1 ;
    public final void rule__Disjunction__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2094:1: ( rule__Disjunction__Group_1_1__0__Impl rule__Disjunction__Group_1_1__1 )
            // InternalRegularExpressionParser.g:2095:2: rule__Disjunction__Group_1_1__0__Impl rule__Disjunction__Group_1_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Disjunction__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1_1__0"


    // $ANTLR start "rule__Disjunction__Group_1_1__0__Impl"
    // InternalRegularExpressionParser.g:2102:1: rule__Disjunction__Group_1_1__0__Impl : ( VerticalLine ) ;
    public final void rule__Disjunction__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2106:1: ( ( VerticalLine ) )
            // InternalRegularExpressionParser.g:2107:1: ( VerticalLine )
            {
            // InternalRegularExpressionParser.g:2107:1: ( VerticalLine )
            // InternalRegularExpressionParser.g:2108:2: VerticalLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1_0()); 
            }
            match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_1_1__1"
    // InternalRegularExpressionParser.g:2117:1: rule__Disjunction__Group_1_1__1 : rule__Disjunction__Group_1_1__1__Impl ;
    public final void rule__Disjunction__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2121:1: ( rule__Disjunction__Group_1_1__1__Impl )
            // InternalRegularExpressionParser.g:2122:2: rule__Disjunction__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1_1__1"


    // $ANTLR start "rule__Disjunction__Group_1_1__1__Impl"
    // InternalRegularExpressionParser.g:2128:1: rule__Disjunction__Group_1_1__1__Impl : ( ( rule__Disjunction__ElementsAssignment_1_1_1 )? ) ;
    public final void rule__Disjunction__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2132:1: ( ( ( rule__Disjunction__ElementsAssignment_1_1_1 )? ) )
            // InternalRegularExpressionParser.g:2133:1: ( ( rule__Disjunction__ElementsAssignment_1_1_1 )? )
            {
            // InternalRegularExpressionParser.g:2133:1: ( ( rule__Disjunction__ElementsAssignment_1_1_1 )? )
            // InternalRegularExpressionParser.g:2134:2: ( rule__Disjunction__ElementsAssignment_1_1_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getElementsAssignment_1_1_1()); 
            }
            // InternalRegularExpressionParser.g:2135:2: ( rule__Disjunction__ElementsAssignment_1_1_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA26_0<=LeftParenthesisQuestionMarkEqualsSign)||(LA26_0>=ExclamationMark && LA26_0<=LeftParenthesis)||(LA26_0>=Comma && LA26_0<=FullStop)||(LA26_0>=Colon && LA26_0<=GreaterThanSign)||(LA26_0>=LeftSquareBracket && LA26_0<=CircumflexAccent)||LA26_0==LeftCurlyBracket||(LA26_0>=RightCurlyBracket && LA26_0<=RULE_CONTROL_LETTER_ESCAPE)||(LA26_0>=RULE_HEX_ESCAPE && LA26_0<=RULE_UNICODE_ESCAPE)||(LA26_0>=RULE_DECIMAL_ESCAPE && LA26_0<=RULE_IDENTITY_ESCAPE)||LA26_0==RULE_UNICODE_DIGIT||(LA26_0>=RULE_UNICODE_LETTER && LA26_0<=RULE_PATTERN_CHARACTER_NO_DASH)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRegularExpressionParser.g:2135:3: rule__Disjunction__ElementsAssignment_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Disjunction__ElementsAssignment_1_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getElementsAssignment_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1_1__1__Impl"


    // $ANTLR start "rule__Alternative__Group__0"
    // InternalRegularExpressionParser.g:2144:1: rule__Alternative__Group__0 : rule__Alternative__Group__0__Impl rule__Alternative__Group__1 ;
    public final void rule__Alternative__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2148:1: ( rule__Alternative__Group__0__Impl rule__Alternative__Group__1 )
            // InternalRegularExpressionParser.g:2149:2: rule__Alternative__Group__0__Impl rule__Alternative__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Alternative__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Alternative__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__0"


    // $ANTLR start "rule__Alternative__Group__0__Impl"
    // InternalRegularExpressionParser.g:2156:1: rule__Alternative__Group__0__Impl : ( ruleTerm ) ;
    public final void rule__Alternative__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2160:1: ( ( ruleTerm ) )
            // InternalRegularExpressionParser.g:2161:1: ( ruleTerm )
            {
            // InternalRegularExpressionParser.g:2161:1: ( ruleTerm )
            // InternalRegularExpressionParser.g:2162:2: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlternativeAccess().getTermParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlternativeAccess().getTermParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__0__Impl"


    // $ANTLR start "rule__Alternative__Group__1"
    // InternalRegularExpressionParser.g:2171:1: rule__Alternative__Group__1 : rule__Alternative__Group__1__Impl ;
    public final void rule__Alternative__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2175:1: ( rule__Alternative__Group__1__Impl )
            // InternalRegularExpressionParser.g:2176:2: rule__Alternative__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Alternative__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__1"


    // $ANTLR start "rule__Alternative__Group__1__Impl"
    // InternalRegularExpressionParser.g:2182:1: rule__Alternative__Group__1__Impl : ( ( rule__Alternative__Group_1__0 )? ) ;
    public final void rule__Alternative__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2186:1: ( ( ( rule__Alternative__Group_1__0 )? ) )
            // InternalRegularExpressionParser.g:2187:1: ( ( rule__Alternative__Group_1__0 )? )
            {
            // InternalRegularExpressionParser.g:2187:1: ( ( rule__Alternative__Group_1__0 )? )
            // InternalRegularExpressionParser.g:2188:2: ( rule__Alternative__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlternativeAccess().getGroup_1()); 
            }
            // InternalRegularExpressionParser.g:2189:2: ( rule__Alternative__Group_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA27_0<=LeftParenthesisQuestionMarkEqualsSign)||(LA27_0>=ExclamationMark && LA27_0<=LeftParenthesis)||(LA27_0>=Comma && LA27_0<=FullStop)||(LA27_0>=Colon && LA27_0<=GreaterThanSign)||(LA27_0>=LeftSquareBracket && LA27_0<=CircumflexAccent)||LA27_0==LeftCurlyBracket||(LA27_0>=RightCurlyBracket && LA27_0<=RULE_CONTROL_LETTER_ESCAPE)||(LA27_0>=RULE_HEX_ESCAPE && LA27_0<=RULE_UNICODE_ESCAPE)||(LA27_0>=RULE_DECIMAL_ESCAPE && LA27_0<=RULE_IDENTITY_ESCAPE)||LA27_0==RULE_UNICODE_DIGIT||(LA27_0>=RULE_UNICODE_LETTER && LA27_0<=RULE_PATTERN_CHARACTER_NO_DASH)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRegularExpressionParser.g:2189:3: rule__Alternative__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Alternative__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlternativeAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__1__Impl"


    // $ANTLR start "rule__Alternative__Group_1__0"
    // InternalRegularExpressionParser.g:2198:1: rule__Alternative__Group_1__0 : rule__Alternative__Group_1__0__Impl rule__Alternative__Group_1__1 ;
    public final void rule__Alternative__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2202:1: ( rule__Alternative__Group_1__0__Impl rule__Alternative__Group_1__1 )
            // InternalRegularExpressionParser.g:2203:2: rule__Alternative__Group_1__0__Impl rule__Alternative__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Alternative__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Alternative__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group_1__0"


    // $ANTLR start "rule__Alternative__Group_1__0__Impl"
    // InternalRegularExpressionParser.g:2210:1: rule__Alternative__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternative__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2214:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2215:1: ( () )
            {
            // InternalRegularExpressionParser.g:2215:1: ( () )
            // InternalRegularExpressionParser.g:2216:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlternativeAccess().getSequenceElementsAction_1_0()); 
            }
            // InternalRegularExpressionParser.g:2217:2: ()
            // InternalRegularExpressionParser.g:2217:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlternativeAccess().getSequenceElementsAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group_1__0__Impl"


    // $ANTLR start "rule__Alternative__Group_1__1"
    // InternalRegularExpressionParser.g:2225:1: rule__Alternative__Group_1__1 : rule__Alternative__Group_1__1__Impl ;
    public final void rule__Alternative__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2229:1: ( rule__Alternative__Group_1__1__Impl )
            // InternalRegularExpressionParser.g:2230:2: rule__Alternative__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Alternative__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group_1__1"


    // $ANTLR start "rule__Alternative__Group_1__1__Impl"
    // InternalRegularExpressionParser.g:2236:1: rule__Alternative__Group_1__1__Impl : ( ( ( rule__Alternative__ElementsAssignment_1_1 ) ) ( ( rule__Alternative__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Alternative__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2240:1: ( ( ( ( rule__Alternative__ElementsAssignment_1_1 ) ) ( ( rule__Alternative__ElementsAssignment_1_1 )* ) ) )
            // InternalRegularExpressionParser.g:2241:1: ( ( ( rule__Alternative__ElementsAssignment_1_1 ) ) ( ( rule__Alternative__ElementsAssignment_1_1 )* ) )
            {
            // InternalRegularExpressionParser.g:2241:1: ( ( ( rule__Alternative__ElementsAssignment_1_1 ) ) ( ( rule__Alternative__ElementsAssignment_1_1 )* ) )
            // InternalRegularExpressionParser.g:2242:2: ( ( rule__Alternative__ElementsAssignment_1_1 ) ) ( ( rule__Alternative__ElementsAssignment_1_1 )* )
            {
            // InternalRegularExpressionParser.g:2242:2: ( ( rule__Alternative__ElementsAssignment_1_1 ) )
            // InternalRegularExpressionParser.g:2243:3: ( rule__Alternative__ElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlternativeAccess().getElementsAssignment_1_1()); 
            }
            // InternalRegularExpressionParser.g:2244:3: ( rule__Alternative__ElementsAssignment_1_1 )
            // InternalRegularExpressionParser.g:2244:4: rule__Alternative__ElementsAssignment_1_1
            {
            pushFollow(FOLLOW_10);
            rule__Alternative__ElementsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlternativeAccess().getElementsAssignment_1_1()); 
            }

            }

            // InternalRegularExpressionParser.g:2247:2: ( ( rule__Alternative__ElementsAssignment_1_1 )* )
            // InternalRegularExpressionParser.g:2248:3: ( rule__Alternative__ElementsAssignment_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlternativeAccess().getElementsAssignment_1_1()); 
            }
            // InternalRegularExpressionParser.g:2249:3: ( rule__Alternative__ElementsAssignment_1_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA28_0<=LeftParenthesisQuestionMarkEqualsSign)||(LA28_0>=ExclamationMark && LA28_0<=LeftParenthesis)||(LA28_0>=Comma && LA28_0<=FullStop)||(LA28_0>=Colon && LA28_0<=GreaterThanSign)||(LA28_0>=LeftSquareBracket && LA28_0<=CircumflexAccent)||LA28_0==LeftCurlyBracket||(LA28_0>=RightCurlyBracket && LA28_0<=RULE_CONTROL_LETTER_ESCAPE)||(LA28_0>=RULE_HEX_ESCAPE && LA28_0<=RULE_UNICODE_ESCAPE)||(LA28_0>=RULE_DECIMAL_ESCAPE && LA28_0<=RULE_IDENTITY_ESCAPE)||LA28_0==RULE_UNICODE_DIGIT||(LA28_0>=RULE_UNICODE_LETTER && LA28_0<=RULE_PATTERN_CHARACTER_NO_DASH)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalRegularExpressionParser.g:2249:4: rule__Alternative__ElementsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Alternative__ElementsAssignment_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlternativeAccess().getElementsAssignment_1_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group_1__1__Impl"


    // $ANTLR start "rule__Term__Group_1__0"
    // InternalRegularExpressionParser.g:2259:1: rule__Term__Group_1__0 : rule__Term__Group_1__0__Impl rule__Term__Group_1__1 ;
    public final void rule__Term__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2263:1: ( rule__Term__Group_1__0__Impl rule__Term__Group_1__1 )
            // InternalRegularExpressionParser.g:2264:2: rule__Term__Group_1__0__Impl rule__Term__Group_1__1
            {
            pushFollow(FOLLOW_11);
            rule__Term__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Term__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Group_1__0"


    // $ANTLR start "rule__Term__Group_1__0__Impl"
    // InternalRegularExpressionParser.g:2271:1: rule__Term__Group_1__0__Impl : ( ruleAtom ) ;
    public final void rule__Term__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2275:1: ( ( ruleAtom ) )
            // InternalRegularExpressionParser.g:2276:1: ( ruleAtom )
            {
            // InternalRegularExpressionParser.g:2276:1: ( ruleAtom )
            // InternalRegularExpressionParser.g:2277:2: ruleAtom
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getAtomParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getAtomParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Group_1__0__Impl"


    // $ANTLR start "rule__Term__Group_1__1"
    // InternalRegularExpressionParser.g:2286:1: rule__Term__Group_1__1 : rule__Term__Group_1__1__Impl ;
    public final void rule__Term__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2290:1: ( rule__Term__Group_1__1__Impl )
            // InternalRegularExpressionParser.g:2291:2: rule__Term__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Term__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Group_1__1"


    // $ANTLR start "rule__Term__Group_1__1__Impl"
    // InternalRegularExpressionParser.g:2297:1: rule__Term__Group_1__1__Impl : ( ( rule__Term__QuantifierAssignment_1_1 )? ) ;
    public final void rule__Term__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2301:1: ( ( ( rule__Term__QuantifierAssignment_1_1 )? ) )
            // InternalRegularExpressionParser.g:2302:1: ( ( rule__Term__QuantifierAssignment_1_1 )? )
            {
            // InternalRegularExpressionParser.g:2302:1: ( ( rule__Term__QuantifierAssignment_1_1 )? )
            // InternalRegularExpressionParser.g:2303:2: ( rule__Term__QuantifierAssignment_1_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getQuantifierAssignment_1_1()); 
            }
            // InternalRegularExpressionParser.g:2304:2: ( rule__Term__QuantifierAssignment_1_1 )?
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalRegularExpressionParser.g:2304:3: rule__Term__QuantifierAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Term__QuantifierAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getQuantifierAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Group_1__1__Impl"


    // $ANTLR start "rule__LineStart__Group__0"
    // InternalRegularExpressionParser.g:2313:1: rule__LineStart__Group__0 : rule__LineStart__Group__0__Impl rule__LineStart__Group__1 ;
    public final void rule__LineStart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2317:1: ( rule__LineStart__Group__0__Impl rule__LineStart__Group__1 )
            // InternalRegularExpressionParser.g:2318:2: rule__LineStart__Group__0__Impl rule__LineStart__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__LineStart__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LineStart__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineStart__Group__0"


    // $ANTLR start "rule__LineStart__Group__0__Impl"
    // InternalRegularExpressionParser.g:2325:1: rule__LineStart__Group__0__Impl : ( () ) ;
    public final void rule__LineStart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2329:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2330:1: ( () )
            {
            // InternalRegularExpressionParser.g:2330:1: ( () )
            // InternalRegularExpressionParser.g:2331:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLineStartAccess().getLineStartAction_0()); 
            }
            // InternalRegularExpressionParser.g:2332:2: ()
            // InternalRegularExpressionParser.g:2332:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLineStartAccess().getLineStartAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineStart__Group__0__Impl"


    // $ANTLR start "rule__LineStart__Group__1"
    // InternalRegularExpressionParser.g:2340:1: rule__LineStart__Group__1 : rule__LineStart__Group__1__Impl ;
    public final void rule__LineStart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2344:1: ( rule__LineStart__Group__1__Impl )
            // InternalRegularExpressionParser.g:2345:2: rule__LineStart__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LineStart__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineStart__Group__1"


    // $ANTLR start "rule__LineStart__Group__1__Impl"
    // InternalRegularExpressionParser.g:2351:1: rule__LineStart__Group__1__Impl : ( CircumflexAccent ) ;
    public final void rule__LineStart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2355:1: ( ( CircumflexAccent ) )
            // InternalRegularExpressionParser.g:2356:1: ( CircumflexAccent )
            {
            // InternalRegularExpressionParser.g:2356:1: ( CircumflexAccent )
            // InternalRegularExpressionParser.g:2357:2: CircumflexAccent
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLineStartAccess().getCircumflexAccentKeyword_1()); 
            }
            match(input,CircumflexAccent,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLineStartAccess().getCircumflexAccentKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineStart__Group__1__Impl"


    // $ANTLR start "rule__LineEnd__Group__0"
    // InternalRegularExpressionParser.g:2367:1: rule__LineEnd__Group__0 : rule__LineEnd__Group__0__Impl rule__LineEnd__Group__1 ;
    public final void rule__LineEnd__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2371:1: ( rule__LineEnd__Group__0__Impl rule__LineEnd__Group__1 )
            // InternalRegularExpressionParser.g:2372:2: rule__LineEnd__Group__0__Impl rule__LineEnd__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__LineEnd__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LineEnd__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineEnd__Group__0"


    // $ANTLR start "rule__LineEnd__Group__0__Impl"
    // InternalRegularExpressionParser.g:2379:1: rule__LineEnd__Group__0__Impl : ( () ) ;
    public final void rule__LineEnd__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2383:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2384:1: ( () )
            {
            // InternalRegularExpressionParser.g:2384:1: ( () )
            // InternalRegularExpressionParser.g:2385:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLineEndAccess().getLineEndAction_0()); 
            }
            // InternalRegularExpressionParser.g:2386:2: ()
            // InternalRegularExpressionParser.g:2386:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLineEndAccess().getLineEndAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineEnd__Group__0__Impl"


    // $ANTLR start "rule__LineEnd__Group__1"
    // InternalRegularExpressionParser.g:2394:1: rule__LineEnd__Group__1 : rule__LineEnd__Group__1__Impl ;
    public final void rule__LineEnd__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2398:1: ( rule__LineEnd__Group__1__Impl )
            // InternalRegularExpressionParser.g:2399:2: rule__LineEnd__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LineEnd__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineEnd__Group__1"


    // $ANTLR start "rule__LineEnd__Group__1__Impl"
    // InternalRegularExpressionParser.g:2405:1: rule__LineEnd__Group__1__Impl : ( DollarSign ) ;
    public final void rule__LineEnd__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2409:1: ( ( DollarSign ) )
            // InternalRegularExpressionParser.g:2410:1: ( DollarSign )
            {
            // InternalRegularExpressionParser.g:2410:1: ( DollarSign )
            // InternalRegularExpressionParser.g:2411:2: DollarSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLineEndAccess().getDollarSignKeyword_1()); 
            }
            match(input,DollarSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLineEndAccess().getDollarSignKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineEnd__Group__1__Impl"


    // $ANTLR start "rule__WordBoundary__Group__0"
    // InternalRegularExpressionParser.g:2421:1: rule__WordBoundary__Group__0 : rule__WordBoundary__Group__0__Impl rule__WordBoundary__Group__1 ;
    public final void rule__WordBoundary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2425:1: ( rule__WordBoundary__Group__0__Impl rule__WordBoundary__Group__1 )
            // InternalRegularExpressionParser.g:2426:2: rule__WordBoundary__Group__0__Impl rule__WordBoundary__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__WordBoundary__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__WordBoundary__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordBoundary__Group__0"


    // $ANTLR start "rule__WordBoundary__Group__0__Impl"
    // InternalRegularExpressionParser.g:2433:1: rule__WordBoundary__Group__0__Impl : ( () ) ;
    public final void rule__WordBoundary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2437:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2438:1: ( () )
            {
            // InternalRegularExpressionParser.g:2438:1: ( () )
            // InternalRegularExpressionParser.g:2439:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWordBoundaryAccess().getWordBoundaryAction_0()); 
            }
            // InternalRegularExpressionParser.g:2440:2: ()
            // InternalRegularExpressionParser.g:2440:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWordBoundaryAccess().getWordBoundaryAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordBoundary__Group__0__Impl"


    // $ANTLR start "rule__WordBoundary__Group__1"
    // InternalRegularExpressionParser.g:2448:1: rule__WordBoundary__Group__1 : rule__WordBoundary__Group__1__Impl ;
    public final void rule__WordBoundary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2452:1: ( rule__WordBoundary__Group__1__Impl )
            // InternalRegularExpressionParser.g:2453:2: rule__WordBoundary__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WordBoundary__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordBoundary__Group__1"


    // $ANTLR start "rule__WordBoundary__Group__1__Impl"
    // InternalRegularExpressionParser.g:2459:1: rule__WordBoundary__Group__1__Impl : ( ( rule__WordBoundary__Alternatives_1 ) ) ;
    public final void rule__WordBoundary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2463:1: ( ( ( rule__WordBoundary__Alternatives_1 ) ) )
            // InternalRegularExpressionParser.g:2464:1: ( ( rule__WordBoundary__Alternatives_1 ) )
            {
            // InternalRegularExpressionParser.g:2464:1: ( ( rule__WordBoundary__Alternatives_1 ) )
            // InternalRegularExpressionParser.g:2465:2: ( rule__WordBoundary__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWordBoundaryAccess().getAlternatives_1()); 
            }
            // InternalRegularExpressionParser.g:2466:2: ( rule__WordBoundary__Alternatives_1 )
            // InternalRegularExpressionParser.g:2466:3: rule__WordBoundary__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__WordBoundary__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWordBoundaryAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordBoundary__Group__1__Impl"


    // $ANTLR start "rule__AbstractLookAhead__Group__0"
    // InternalRegularExpressionParser.g:2475:1: rule__AbstractLookAhead__Group__0 : rule__AbstractLookAhead__Group__0__Impl rule__AbstractLookAhead__Group__1 ;
    public final void rule__AbstractLookAhead__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2479:1: ( rule__AbstractLookAhead__Group__0__Impl rule__AbstractLookAhead__Group__1 )
            // InternalRegularExpressionParser.g:2480:2: rule__AbstractLookAhead__Group__0__Impl rule__AbstractLookAhead__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__AbstractLookAhead__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group__0"


    // $ANTLR start "rule__AbstractLookAhead__Group__0__Impl"
    // InternalRegularExpressionParser.g:2487:1: rule__AbstractLookAhead__Group__0__Impl : ( ( rule__AbstractLookAhead__Alternatives_0 ) ) ;
    public final void rule__AbstractLookAhead__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2491:1: ( ( ( rule__AbstractLookAhead__Alternatives_0 ) ) )
            // InternalRegularExpressionParser.g:2492:1: ( ( rule__AbstractLookAhead__Alternatives_0 ) )
            {
            // InternalRegularExpressionParser.g:2492:1: ( ( rule__AbstractLookAhead__Alternatives_0 ) )
            // InternalRegularExpressionParser.g:2493:2: ( rule__AbstractLookAhead__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getAlternatives_0()); 
            }
            // InternalRegularExpressionParser.g:2494:2: ( rule__AbstractLookAhead__Alternatives_0 )
            // InternalRegularExpressionParser.g:2494:3: rule__AbstractLookAhead__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group__0__Impl"


    // $ANTLR start "rule__AbstractLookAhead__Group__1"
    // InternalRegularExpressionParser.g:2502:1: rule__AbstractLookAhead__Group__1 : rule__AbstractLookAhead__Group__1__Impl rule__AbstractLookAhead__Group__2 ;
    public final void rule__AbstractLookAhead__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2506:1: ( rule__AbstractLookAhead__Group__1__Impl rule__AbstractLookAhead__Group__2 )
            // InternalRegularExpressionParser.g:2507:2: rule__AbstractLookAhead__Group__1__Impl rule__AbstractLookAhead__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__AbstractLookAhead__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group__1"


    // $ANTLR start "rule__AbstractLookAhead__Group__1__Impl"
    // InternalRegularExpressionParser.g:2514:1: rule__AbstractLookAhead__Group__1__Impl : ( ( rule__AbstractLookAhead__PatternAssignment_1 ) ) ;
    public final void rule__AbstractLookAhead__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2518:1: ( ( ( rule__AbstractLookAhead__PatternAssignment_1 ) ) )
            // InternalRegularExpressionParser.g:2519:1: ( ( rule__AbstractLookAhead__PatternAssignment_1 ) )
            {
            // InternalRegularExpressionParser.g:2519:1: ( ( rule__AbstractLookAhead__PatternAssignment_1 ) )
            // InternalRegularExpressionParser.g:2520:2: ( rule__AbstractLookAhead__PatternAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getPatternAssignment_1()); 
            }
            // InternalRegularExpressionParser.g:2521:2: ( rule__AbstractLookAhead__PatternAssignment_1 )
            // InternalRegularExpressionParser.g:2521:3: rule__AbstractLookAhead__PatternAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__PatternAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getPatternAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group__1__Impl"


    // $ANTLR start "rule__AbstractLookAhead__Group__2"
    // InternalRegularExpressionParser.g:2529:1: rule__AbstractLookAhead__Group__2 : rule__AbstractLookAhead__Group__2__Impl ;
    public final void rule__AbstractLookAhead__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2533:1: ( rule__AbstractLookAhead__Group__2__Impl )
            // InternalRegularExpressionParser.g:2534:2: rule__AbstractLookAhead__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group__2"


    // $ANTLR start "rule__AbstractLookAhead__Group__2__Impl"
    // InternalRegularExpressionParser.g:2540:1: rule__AbstractLookAhead__Group__2__Impl : ( RightParenthesis ) ;
    public final void rule__AbstractLookAhead__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2544:1: ( ( RightParenthesis ) )
            // InternalRegularExpressionParser.g:2545:1: ( RightParenthesis )
            {
            // InternalRegularExpressionParser.g:2545:1: ( RightParenthesis )
            // InternalRegularExpressionParser.g:2546:2: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getRightParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group__2__Impl"


    // $ANTLR start "rule__AbstractLookAhead__Group_0_0__0"
    // InternalRegularExpressionParser.g:2556:1: rule__AbstractLookAhead__Group_0_0__0 : rule__AbstractLookAhead__Group_0_0__0__Impl rule__AbstractLookAhead__Group_0_0__1 ;
    public final void rule__AbstractLookAhead__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2560:1: ( rule__AbstractLookAhead__Group_0_0__0__Impl rule__AbstractLookAhead__Group_0_0__1 )
            // InternalRegularExpressionParser.g:2561:2: rule__AbstractLookAhead__Group_0_0__0__Impl rule__AbstractLookAhead__Group_0_0__1
            {
            pushFollow(FOLLOW_16);
            rule__AbstractLookAhead__Group_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Group_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group_0_0__0"


    // $ANTLR start "rule__AbstractLookAhead__Group_0_0__0__Impl"
    // InternalRegularExpressionParser.g:2568:1: rule__AbstractLookAhead__Group_0_0__0__Impl : ( () ) ;
    public final void rule__AbstractLookAhead__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2572:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2573:1: ( () )
            {
            // InternalRegularExpressionParser.g:2573:1: ( () )
            // InternalRegularExpressionParser.g:2574:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getLookAheadAction_0_0_0()); 
            }
            // InternalRegularExpressionParser.g:2575:2: ()
            // InternalRegularExpressionParser.g:2575:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getLookAheadAction_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group_0_0__0__Impl"


    // $ANTLR start "rule__AbstractLookAhead__Group_0_0__1"
    // InternalRegularExpressionParser.g:2583:1: rule__AbstractLookAhead__Group_0_0__1 : rule__AbstractLookAhead__Group_0_0__1__Impl ;
    public final void rule__AbstractLookAhead__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2587:1: ( rule__AbstractLookAhead__Group_0_0__1__Impl )
            // InternalRegularExpressionParser.g:2588:2: rule__AbstractLookAhead__Group_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Group_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group_0_0__1"


    // $ANTLR start "rule__AbstractLookAhead__Group_0_0__1__Impl"
    // InternalRegularExpressionParser.g:2594:1: rule__AbstractLookAhead__Group_0_0__1__Impl : ( ( rule__AbstractLookAhead__Alternatives_0_0_1 ) ) ;
    public final void rule__AbstractLookAhead__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2598:1: ( ( ( rule__AbstractLookAhead__Alternatives_0_0_1 ) ) )
            // InternalRegularExpressionParser.g:2599:1: ( ( rule__AbstractLookAhead__Alternatives_0_0_1 ) )
            {
            // InternalRegularExpressionParser.g:2599:1: ( ( rule__AbstractLookAhead__Alternatives_0_0_1 ) )
            // InternalRegularExpressionParser.g:2600:2: ( rule__AbstractLookAhead__Alternatives_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getAlternatives_0_0_1()); 
            }
            // InternalRegularExpressionParser.g:2601:2: ( rule__AbstractLookAhead__Alternatives_0_0_1 )
            // InternalRegularExpressionParser.g:2601:3: rule__AbstractLookAhead__Alternatives_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Alternatives_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getAlternatives_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group_0_0__1__Impl"


    // $ANTLR start "rule__AbstractLookAhead__Group_0_1__0"
    // InternalRegularExpressionParser.g:2610:1: rule__AbstractLookAhead__Group_0_1__0 : rule__AbstractLookAhead__Group_0_1__0__Impl rule__AbstractLookAhead__Group_0_1__1 ;
    public final void rule__AbstractLookAhead__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2614:1: ( rule__AbstractLookAhead__Group_0_1__0__Impl rule__AbstractLookAhead__Group_0_1__1 )
            // InternalRegularExpressionParser.g:2615:2: rule__AbstractLookAhead__Group_0_1__0__Impl rule__AbstractLookAhead__Group_0_1__1
            {
            pushFollow(FOLLOW_17);
            rule__AbstractLookAhead__Group_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Group_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group_0_1__0"


    // $ANTLR start "rule__AbstractLookAhead__Group_0_1__0__Impl"
    // InternalRegularExpressionParser.g:2622:1: rule__AbstractLookAhead__Group_0_1__0__Impl : ( () ) ;
    public final void rule__AbstractLookAhead__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2626:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2627:1: ( () )
            {
            // InternalRegularExpressionParser.g:2627:1: ( () )
            // InternalRegularExpressionParser.g:2628:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getLookBehindAction_0_1_0()); 
            }
            // InternalRegularExpressionParser.g:2629:2: ()
            // InternalRegularExpressionParser.g:2629:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getLookBehindAction_0_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group_0_1__0__Impl"


    // $ANTLR start "rule__AbstractLookAhead__Group_0_1__1"
    // InternalRegularExpressionParser.g:2637:1: rule__AbstractLookAhead__Group_0_1__1 : rule__AbstractLookAhead__Group_0_1__1__Impl ;
    public final void rule__AbstractLookAhead__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2641:1: ( rule__AbstractLookAhead__Group_0_1__1__Impl )
            // InternalRegularExpressionParser.g:2642:2: rule__AbstractLookAhead__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Group_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group_0_1__1"


    // $ANTLR start "rule__AbstractLookAhead__Group_0_1__1__Impl"
    // InternalRegularExpressionParser.g:2648:1: rule__AbstractLookAhead__Group_0_1__1__Impl : ( ( rule__AbstractLookAhead__Alternatives_0_1_1 ) ) ;
    public final void rule__AbstractLookAhead__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2652:1: ( ( ( rule__AbstractLookAhead__Alternatives_0_1_1 ) ) )
            // InternalRegularExpressionParser.g:2653:1: ( ( rule__AbstractLookAhead__Alternatives_0_1_1 ) )
            {
            // InternalRegularExpressionParser.g:2653:1: ( ( rule__AbstractLookAhead__Alternatives_0_1_1 ) )
            // InternalRegularExpressionParser.g:2654:2: ( rule__AbstractLookAhead__Alternatives_0_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getAlternatives_0_1_1()); 
            }
            // InternalRegularExpressionParser.g:2655:2: ( rule__AbstractLookAhead__Alternatives_0_1_1 )
            // InternalRegularExpressionParser.g:2655:3: rule__AbstractLookAhead__Alternatives_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AbstractLookAhead__Alternatives_0_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getAlternatives_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__Group_0_1__1__Impl"


    // $ANTLR start "rule__Wildcard__Group__0"
    // InternalRegularExpressionParser.g:2664:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2668:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // InternalRegularExpressionParser.g:2669:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Wildcard__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Wildcard__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__0"


    // $ANTLR start "rule__Wildcard__Group__0__Impl"
    // InternalRegularExpressionParser.g:2676:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2680:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2681:1: ( () )
            {
            // InternalRegularExpressionParser.g:2681:1: ( () )
            // InternalRegularExpressionParser.g:2682:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            }
            // InternalRegularExpressionParser.g:2683:2: ()
            // InternalRegularExpressionParser.g:2683:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__0__Impl"


    // $ANTLR start "rule__Wildcard__Group__1"
    // InternalRegularExpressionParser.g:2691:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2695:1: ( rule__Wildcard__Group__1__Impl )
            // InternalRegularExpressionParser.g:2696:2: rule__Wildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Wildcard__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__1"


    // $ANTLR start "rule__Wildcard__Group__1__Impl"
    // InternalRegularExpressionParser.g:2702:1: rule__Wildcard__Group__1__Impl : ( FullStop ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2706:1: ( ( FullStop ) )
            // InternalRegularExpressionParser.g:2707:1: ( FullStop )
            {
            // InternalRegularExpressionParser.g:2707:1: ( FullStop )
            // InternalRegularExpressionParser.g:2708:2: FullStop
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            }
            match(input,FullStop,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__1__Impl"


    // $ANTLR start "rule__CharacterClass__Group__0"
    // InternalRegularExpressionParser.g:2718:1: rule__CharacterClass__Group__0 : rule__CharacterClass__Group__0__Impl rule__CharacterClass__Group__1 ;
    public final void rule__CharacterClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2722:1: ( rule__CharacterClass__Group__0__Impl rule__CharacterClass__Group__1 )
            // InternalRegularExpressionParser.g:2723:2: rule__CharacterClass__Group__0__Impl rule__CharacterClass__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__CharacterClass__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CharacterClass__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__0"


    // $ANTLR start "rule__CharacterClass__Group__0__Impl"
    // InternalRegularExpressionParser.g:2730:1: rule__CharacterClass__Group__0__Impl : ( () ) ;
    public final void rule__CharacterClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2734:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2735:1: ( () )
            {
            // InternalRegularExpressionParser.g:2735:1: ( () )
            // InternalRegularExpressionParser.g:2736:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getCharacterClassAction_0()); 
            }
            // InternalRegularExpressionParser.g:2737:2: ()
            // InternalRegularExpressionParser.g:2737:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getCharacterClassAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__0__Impl"


    // $ANTLR start "rule__CharacterClass__Group__1"
    // InternalRegularExpressionParser.g:2745:1: rule__CharacterClass__Group__1 : rule__CharacterClass__Group__1__Impl rule__CharacterClass__Group__2 ;
    public final void rule__CharacterClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2749:1: ( rule__CharacterClass__Group__1__Impl rule__CharacterClass__Group__2 )
            // InternalRegularExpressionParser.g:2750:2: rule__CharacterClass__Group__1__Impl rule__CharacterClass__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__CharacterClass__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CharacterClass__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__1"


    // $ANTLR start "rule__CharacterClass__Group__1__Impl"
    // InternalRegularExpressionParser.g:2757:1: rule__CharacterClass__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__CharacterClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2761:1: ( ( LeftSquareBracket ) )
            // InternalRegularExpressionParser.g:2762:1: ( LeftSquareBracket )
            {
            // InternalRegularExpressionParser.g:2762:1: ( LeftSquareBracket )
            // InternalRegularExpressionParser.g:2763:2: LeftSquareBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,LeftSquareBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__1__Impl"


    // $ANTLR start "rule__CharacterClass__Group__2"
    // InternalRegularExpressionParser.g:2772:1: rule__CharacterClass__Group__2 : rule__CharacterClass__Group__2__Impl rule__CharacterClass__Group__3 ;
    public final void rule__CharacterClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2776:1: ( rule__CharacterClass__Group__2__Impl rule__CharacterClass__Group__3 )
            // InternalRegularExpressionParser.g:2777:2: rule__CharacterClass__Group__2__Impl rule__CharacterClass__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__CharacterClass__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CharacterClass__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__2"


    // $ANTLR start "rule__CharacterClass__Group__2__Impl"
    // InternalRegularExpressionParser.g:2784:1: rule__CharacterClass__Group__2__Impl : ( ( rule__CharacterClass__Group_2__0 )? ) ;
    public final void rule__CharacterClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2788:1: ( ( ( rule__CharacterClass__Group_2__0 )? ) )
            // InternalRegularExpressionParser.g:2789:1: ( ( rule__CharacterClass__Group_2__0 )? )
            {
            // InternalRegularExpressionParser.g:2789:1: ( ( rule__CharacterClass__Group_2__0 )? )
            // InternalRegularExpressionParser.g:2790:2: ( rule__CharacterClass__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getGroup_2()); 
            }
            // InternalRegularExpressionParser.g:2791:2: ( rule__CharacterClass__Group_2__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==CircumflexAccent) ) {
                int LA30_1 = input.LA(2);

                if ( (synpred91_InternalRegularExpressionParser()) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // InternalRegularExpressionParser.g:2791:3: rule__CharacterClass__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CharacterClass__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__2__Impl"


    // $ANTLR start "rule__CharacterClass__Group__3"
    // InternalRegularExpressionParser.g:2799:1: rule__CharacterClass__Group__3 : rule__CharacterClass__Group__3__Impl rule__CharacterClass__Group__4 ;
    public final void rule__CharacterClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2803:1: ( rule__CharacterClass__Group__3__Impl rule__CharacterClass__Group__4 )
            // InternalRegularExpressionParser.g:2804:2: rule__CharacterClass__Group__3__Impl rule__CharacterClass__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__CharacterClass__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CharacterClass__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__3"


    // $ANTLR start "rule__CharacterClass__Group__3__Impl"
    // InternalRegularExpressionParser.g:2811:1: rule__CharacterClass__Group__3__Impl : ( ( rule__CharacterClass__ElementsAssignment_3 )* ) ;
    public final void rule__CharacterClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2815:1: ( ( ( rule__CharacterClass__ElementsAssignment_3 )* ) )
            // InternalRegularExpressionParser.g:2816:1: ( ( rule__CharacterClass__ElementsAssignment_3 )* )
            {
            // InternalRegularExpressionParser.g:2816:1: ( ( rule__CharacterClass__ElementsAssignment_3 )* )
            // InternalRegularExpressionParser.g:2817:2: ( rule__CharacterClass__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getElementsAssignment_3()); 
            }
            // InternalRegularExpressionParser.g:2818:2: ( rule__CharacterClass__ElementsAssignment_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=LeftParenthesisQuestionMarkLessThanSignExclamationMark && LA31_0<=LeftParenthesisQuestionMarkExclamationMark)||(LA31_0>=LeftParenthesisQuestionMarkLessThanSign && LA31_0<=LeftSquareBracket)||LA31_0==CircumflexAccent||(LA31_0>=LeftCurlyBracket && LA31_0<=RULE_WORD_BOUNDARY)||(LA31_0>=RULE_CHARACTER_CLASS_ESCAPE && LA31_0<=RULE_CONTROL_LETTER_ESCAPE)||(LA31_0>=RULE_HEX_ESCAPE && LA31_0<=RULE_UNICODE_ESCAPE)||(LA31_0>=RULE_DECIMAL_ESCAPE && LA31_0<=RULE_IDENTITY_ESCAPE)||LA31_0==RULE_UNICODE_DIGIT||(LA31_0>=RULE_UNICODE_LETTER && LA31_0<=RULE_PATTERN_CHARACTER_NO_DASH)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalRegularExpressionParser.g:2818:3: rule__CharacterClass__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__CharacterClass__ElementsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getElementsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__3__Impl"


    // $ANTLR start "rule__CharacterClass__Group__4"
    // InternalRegularExpressionParser.g:2826:1: rule__CharacterClass__Group__4 : rule__CharacterClass__Group__4__Impl ;
    public final void rule__CharacterClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2830:1: ( rule__CharacterClass__Group__4__Impl )
            // InternalRegularExpressionParser.g:2831:2: rule__CharacterClass__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClass__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__4"


    // $ANTLR start "rule__CharacterClass__Group__4__Impl"
    // InternalRegularExpressionParser.g:2837:1: rule__CharacterClass__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__CharacterClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2841:1: ( ( RightSquareBracket ) )
            // InternalRegularExpressionParser.g:2842:1: ( RightSquareBracket )
            {
            // InternalRegularExpressionParser.g:2842:1: ( RightSquareBracket )
            // InternalRegularExpressionParser.g:2843:2: RightSquareBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getRightSquareBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group__4__Impl"


    // $ANTLR start "rule__CharacterClass__Group_2__0"
    // InternalRegularExpressionParser.g:2853:1: rule__CharacterClass__Group_2__0 : rule__CharacterClass__Group_2__0__Impl ;
    public final void rule__CharacterClass__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2857:1: ( rule__CharacterClass__Group_2__0__Impl )
            // InternalRegularExpressionParser.g:2858:2: rule__CharacterClass__Group_2__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClass__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group_2__0"


    // $ANTLR start "rule__CharacterClass__Group_2__0__Impl"
    // InternalRegularExpressionParser.g:2864:1: rule__CharacterClass__Group_2__0__Impl : ( ( rule__CharacterClass__NegatedAssignment_2_0 ) ) ;
    public final void rule__CharacterClass__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2868:1: ( ( ( rule__CharacterClass__NegatedAssignment_2_0 ) ) )
            // InternalRegularExpressionParser.g:2869:1: ( ( rule__CharacterClass__NegatedAssignment_2_0 ) )
            {
            // InternalRegularExpressionParser.g:2869:1: ( ( rule__CharacterClass__NegatedAssignment_2_0 ) )
            // InternalRegularExpressionParser.g:2870:2: ( rule__CharacterClass__NegatedAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getNegatedAssignment_2_0()); 
            }
            // InternalRegularExpressionParser.g:2871:2: ( rule__CharacterClass__NegatedAssignment_2_0 )
            // InternalRegularExpressionParser.g:2871:3: rule__CharacterClass__NegatedAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClass__NegatedAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getNegatedAssignment_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__Group_2__0__Impl"


    // $ANTLR start "rule__CharacterClassElement__Group__0"
    // InternalRegularExpressionParser.g:2880:1: rule__CharacterClassElement__Group__0 : rule__CharacterClassElement__Group__0__Impl rule__CharacterClassElement__Group__1 ;
    public final void rule__CharacterClassElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2884:1: ( rule__CharacterClassElement__Group__0__Impl rule__CharacterClassElement__Group__1 )
            // InternalRegularExpressionParser.g:2885:2: rule__CharacterClassElement__Group__0__Impl rule__CharacterClassElement__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__CharacterClassElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group__0"


    // $ANTLR start "rule__CharacterClassElement__Group__0__Impl"
    // InternalRegularExpressionParser.g:2892:1: rule__CharacterClassElement__Group__0__Impl : ( ruleCharacterClassAtom ) ;
    public final void rule__CharacterClassElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2896:1: ( ( ruleCharacterClassAtom ) )
            // InternalRegularExpressionParser.g:2897:1: ( ruleCharacterClassAtom )
            {
            // InternalRegularExpressionParser.g:2897:1: ( ruleCharacterClassAtom )
            // InternalRegularExpressionParser.g:2898:2: ruleCharacterClassAtom
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementAccess().getCharacterClassAtomParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCharacterClassAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementAccess().getCharacterClassAtomParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group__0__Impl"


    // $ANTLR start "rule__CharacterClassElement__Group__1"
    // InternalRegularExpressionParser.g:2907:1: rule__CharacterClassElement__Group__1 : rule__CharacterClassElement__Group__1__Impl ;
    public final void rule__CharacterClassElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2911:1: ( rule__CharacterClassElement__Group__1__Impl )
            // InternalRegularExpressionParser.g:2912:2: rule__CharacterClassElement__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group__1"


    // $ANTLR start "rule__CharacterClassElement__Group__1__Impl"
    // InternalRegularExpressionParser.g:2918:1: rule__CharacterClassElement__Group__1__Impl : ( ( rule__CharacterClassElement__Group_1__0 )? ) ;
    public final void rule__CharacterClassElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2922:1: ( ( ( rule__CharacterClassElement__Group_1__0 )? ) )
            // InternalRegularExpressionParser.g:2923:1: ( ( rule__CharacterClassElement__Group_1__0 )? )
            {
            // InternalRegularExpressionParser.g:2923:1: ( ( rule__CharacterClassElement__Group_1__0 )? )
            // InternalRegularExpressionParser.g:2924:2: ( rule__CharacterClassElement__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementAccess().getGroup_1()); 
            }
            // InternalRegularExpressionParser.g:2925:2: ( rule__CharacterClassElement__Group_1__0 )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalRegularExpressionParser.g:2925:3: rule__CharacterClassElement__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CharacterClassElement__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group__1__Impl"


    // $ANTLR start "rule__CharacterClassElement__Group_1__0"
    // InternalRegularExpressionParser.g:2934:1: rule__CharacterClassElement__Group_1__0 : rule__CharacterClassElement__Group_1__0__Impl ;
    public final void rule__CharacterClassElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2938:1: ( rule__CharacterClassElement__Group_1__0__Impl )
            // InternalRegularExpressionParser.g:2939:2: rule__CharacterClassElement__Group_1__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group_1__0"


    // $ANTLR start "rule__CharacterClassElement__Group_1__0__Impl"
    // InternalRegularExpressionParser.g:2945:1: rule__CharacterClassElement__Group_1__0__Impl : ( ( rule__CharacterClassElement__Group_1_0__0 ) ) ;
    public final void rule__CharacterClassElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2949:1: ( ( ( rule__CharacterClassElement__Group_1_0__0 ) ) )
            // InternalRegularExpressionParser.g:2950:1: ( ( rule__CharacterClassElement__Group_1_0__0 ) )
            {
            // InternalRegularExpressionParser.g:2950:1: ( ( rule__CharacterClassElement__Group_1_0__0 ) )
            // InternalRegularExpressionParser.g:2951:2: ( rule__CharacterClassElement__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementAccess().getGroup_1_0()); 
            }
            // InternalRegularExpressionParser.g:2952:2: ( rule__CharacterClassElement__Group_1_0__0 )
            // InternalRegularExpressionParser.g:2952:3: rule__CharacterClassElement__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group_1__0__Impl"


    // $ANTLR start "rule__CharacterClassElement__Group_1_0__0"
    // InternalRegularExpressionParser.g:2961:1: rule__CharacterClassElement__Group_1_0__0 : rule__CharacterClassElement__Group_1_0__0__Impl rule__CharacterClassElement__Group_1_0__1 ;
    public final void rule__CharacterClassElement__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2965:1: ( rule__CharacterClassElement__Group_1_0__0__Impl rule__CharacterClassElement__Group_1_0__1 )
            // InternalRegularExpressionParser.g:2966:2: rule__CharacterClassElement__Group_1_0__0__Impl rule__CharacterClassElement__Group_1_0__1
            {
            pushFollow(FOLLOW_22);
            rule__CharacterClassElement__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group_1_0__0"


    // $ANTLR start "rule__CharacterClassElement__Group_1_0__0__Impl"
    // InternalRegularExpressionParser.g:2973:1: rule__CharacterClassElement__Group_1_0__0__Impl : ( () ) ;
    public final void rule__CharacterClassElement__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2977:1: ( ( () ) )
            // InternalRegularExpressionParser.g:2978:1: ( () )
            {
            // InternalRegularExpressionParser.g:2978:1: ( () )
            // InternalRegularExpressionParser.g:2979:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementAccess().getCharacterClassRangeLeftAction_1_0_0()); 
            }
            // InternalRegularExpressionParser.g:2980:2: ()
            // InternalRegularExpressionParser.g:2980:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementAccess().getCharacterClassRangeLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group_1_0__0__Impl"


    // $ANTLR start "rule__CharacterClassElement__Group_1_0__1"
    // InternalRegularExpressionParser.g:2988:1: rule__CharacterClassElement__Group_1_0__1 : rule__CharacterClassElement__Group_1_0__1__Impl rule__CharacterClassElement__Group_1_0__2 ;
    public final void rule__CharacterClassElement__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:2992:1: ( rule__CharacterClassElement__Group_1_0__1__Impl rule__CharacterClassElement__Group_1_0__2 )
            // InternalRegularExpressionParser.g:2993:2: rule__CharacterClassElement__Group_1_0__1__Impl rule__CharacterClassElement__Group_1_0__2
            {
            pushFollow(FOLLOW_23);
            rule__CharacterClassElement__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__Group_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group_1_0__1"


    // $ANTLR start "rule__CharacterClassElement__Group_1_0__1__Impl"
    // InternalRegularExpressionParser.g:3000:1: rule__CharacterClassElement__Group_1_0__1__Impl : ( HyphenMinus ) ;
    public final void rule__CharacterClassElement__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3004:1: ( ( HyphenMinus ) )
            // InternalRegularExpressionParser.g:3005:1: ( HyphenMinus )
            {
            // InternalRegularExpressionParser.g:3005:1: ( HyphenMinus )
            // InternalRegularExpressionParser.g:3006:2: HyphenMinus
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementAccess().getHyphenMinusKeyword_1_0_1()); 
            }
            match(input,HyphenMinus,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementAccess().getHyphenMinusKeyword_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group_1_0__1__Impl"


    // $ANTLR start "rule__CharacterClassElement__Group_1_0__2"
    // InternalRegularExpressionParser.g:3015:1: rule__CharacterClassElement__Group_1_0__2 : rule__CharacterClassElement__Group_1_0__2__Impl ;
    public final void rule__CharacterClassElement__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3019:1: ( rule__CharacterClassElement__Group_1_0__2__Impl )
            // InternalRegularExpressionParser.g:3020:2: rule__CharacterClassElement__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group_1_0__2"


    // $ANTLR start "rule__CharacterClassElement__Group_1_0__2__Impl"
    // InternalRegularExpressionParser.g:3026:1: rule__CharacterClassElement__Group_1_0__2__Impl : ( ( rule__CharacterClassElement__RightAssignment_1_0_2 ) ) ;
    public final void rule__CharacterClassElement__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3030:1: ( ( ( rule__CharacterClassElement__RightAssignment_1_0_2 ) ) )
            // InternalRegularExpressionParser.g:3031:1: ( ( rule__CharacterClassElement__RightAssignment_1_0_2 ) )
            {
            // InternalRegularExpressionParser.g:3031:1: ( ( rule__CharacterClassElement__RightAssignment_1_0_2 ) )
            // InternalRegularExpressionParser.g:3032:2: ( rule__CharacterClassElement__RightAssignment_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementAccess().getRightAssignment_1_0_2()); 
            }
            // InternalRegularExpressionParser.g:3033:2: ( rule__CharacterClassElement__RightAssignment_1_0_2 )
            // InternalRegularExpressionParser.g:3033:3: rule__CharacterClassElement__RightAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassElement__RightAssignment_1_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementAccess().getRightAssignment_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__Group_1_0__2__Impl"


    // $ANTLR start "rule__Backspace__Group__0"
    // InternalRegularExpressionParser.g:3042:1: rule__Backspace__Group__0 : rule__Backspace__Group__0__Impl rule__Backspace__Group__1 ;
    public final void rule__Backspace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3046:1: ( rule__Backspace__Group__0__Impl rule__Backspace__Group__1 )
            // InternalRegularExpressionParser.g:3047:2: rule__Backspace__Group__0__Impl rule__Backspace__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Backspace__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Backspace__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Backspace__Group__0"


    // $ANTLR start "rule__Backspace__Group__0__Impl"
    // InternalRegularExpressionParser.g:3054:1: rule__Backspace__Group__0__Impl : ( () ) ;
    public final void rule__Backspace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3058:1: ( ( () ) )
            // InternalRegularExpressionParser.g:3059:1: ( () )
            {
            // InternalRegularExpressionParser.g:3059:1: ( () )
            // InternalRegularExpressionParser.g:3060:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBackspaceAccess().getBackspaceAction_0()); 
            }
            // InternalRegularExpressionParser.g:3061:2: ()
            // InternalRegularExpressionParser.g:3061:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBackspaceAccess().getBackspaceAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Backspace__Group__0__Impl"


    // $ANTLR start "rule__Backspace__Group__1"
    // InternalRegularExpressionParser.g:3069:1: rule__Backspace__Group__1 : rule__Backspace__Group__1__Impl ;
    public final void rule__Backspace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3073:1: ( rule__Backspace__Group__1__Impl )
            // InternalRegularExpressionParser.g:3074:2: rule__Backspace__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Backspace__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Backspace__Group__1"


    // $ANTLR start "rule__Backspace__Group__1__Impl"
    // InternalRegularExpressionParser.g:3080:1: rule__Backspace__Group__1__Impl : ( RULE_WORD_BOUNDARY ) ;
    public final void rule__Backspace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3084:1: ( ( RULE_WORD_BOUNDARY ) )
            // InternalRegularExpressionParser.g:3085:1: ( RULE_WORD_BOUNDARY )
            {
            // InternalRegularExpressionParser.g:3085:1: ( RULE_WORD_BOUNDARY )
            // InternalRegularExpressionParser.g:3086:2: RULE_WORD_BOUNDARY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBackspaceAccess().getWORD_BOUNDARYTerminalRuleCall_1()); 
            }
            match(input,RULE_WORD_BOUNDARY,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBackspaceAccess().getWORD_BOUNDARYTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Backspace__Group__1__Impl"


    // $ANTLR start "rule__Group__Group__0"
    // InternalRegularExpressionParser.g:3096:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3100:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // InternalRegularExpressionParser.g:3101:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Group__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Group__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0"


    // $ANTLR start "rule__Group__Group__0__Impl"
    // InternalRegularExpressionParser.g:3108:1: rule__Group__Group__0__Impl : ( () ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3112:1: ( ( () ) )
            // InternalRegularExpressionParser.g:3113:1: ( () )
            {
            // InternalRegularExpressionParser.g:3113:1: ( () )
            // InternalRegularExpressionParser.g:3114:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getGroupAction_0()); 
            }
            // InternalRegularExpressionParser.g:3115:2: ()
            // InternalRegularExpressionParser.g:3115:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getGroupAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0__Impl"


    // $ANTLR start "rule__Group__Group__1"
    // InternalRegularExpressionParser.g:3123:1: rule__Group__Group__1 : rule__Group__Group__1__Impl rule__Group__Group__2 ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3127:1: ( rule__Group__Group__1__Impl rule__Group__Group__2 )
            // InternalRegularExpressionParser.g:3128:2: rule__Group__Group__1__Impl rule__Group__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Group__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Group__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1"


    // $ANTLR start "rule__Group__Group__1__Impl"
    // InternalRegularExpressionParser.g:3135:1: rule__Group__Group__1__Impl : ( ( rule__Group__Alternatives_1 ) ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3139:1: ( ( ( rule__Group__Alternatives_1 ) ) )
            // InternalRegularExpressionParser.g:3140:1: ( ( rule__Group__Alternatives_1 ) )
            {
            // InternalRegularExpressionParser.g:3140:1: ( ( rule__Group__Alternatives_1 ) )
            // InternalRegularExpressionParser.g:3141:2: ( rule__Group__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getAlternatives_1()); 
            }
            // InternalRegularExpressionParser.g:3142:2: ( rule__Group__Alternatives_1 )
            // InternalRegularExpressionParser.g:3142:3: rule__Group__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__Group__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1__Impl"


    // $ANTLR start "rule__Group__Group__2"
    // InternalRegularExpressionParser.g:3150:1: rule__Group__Group__2 : rule__Group__Group__2__Impl rule__Group__Group__3 ;
    public final void rule__Group__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3154:1: ( rule__Group__Group__2__Impl rule__Group__Group__3 )
            // InternalRegularExpressionParser.g:3155:2: rule__Group__Group__2__Impl rule__Group__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Group__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Group__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__2"


    // $ANTLR start "rule__Group__Group__2__Impl"
    // InternalRegularExpressionParser.g:3162:1: rule__Group__Group__2__Impl : ( ( rule__Group__PatternAssignment_2 ) ) ;
    public final void rule__Group__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3166:1: ( ( ( rule__Group__PatternAssignment_2 ) ) )
            // InternalRegularExpressionParser.g:3167:1: ( ( rule__Group__PatternAssignment_2 ) )
            {
            // InternalRegularExpressionParser.g:3167:1: ( ( rule__Group__PatternAssignment_2 ) )
            // InternalRegularExpressionParser.g:3168:2: ( rule__Group__PatternAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getPatternAssignment_2()); 
            }
            // InternalRegularExpressionParser.g:3169:2: ( rule__Group__PatternAssignment_2 )
            // InternalRegularExpressionParser.g:3169:3: rule__Group__PatternAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Group__PatternAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getPatternAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__2__Impl"


    // $ANTLR start "rule__Group__Group__3"
    // InternalRegularExpressionParser.g:3177:1: rule__Group__Group__3 : rule__Group__Group__3__Impl ;
    public final void rule__Group__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3181:1: ( rule__Group__Group__3__Impl )
            // InternalRegularExpressionParser.g:3182:2: rule__Group__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Group__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__3"


    // $ANTLR start "rule__Group__Group__3__Impl"
    // InternalRegularExpressionParser.g:3188:1: rule__Group__Group__3__Impl : ( RightParenthesis ) ;
    public final void rule__Group__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3192:1: ( ( RightParenthesis ) )
            // InternalRegularExpressionParser.g:3193:1: ( RightParenthesis )
            {
            // InternalRegularExpressionParser.g:3193:1: ( RightParenthesis )
            // InternalRegularExpressionParser.g:3194:2: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__3__Impl"


    // $ANTLR start "rule__Group__Group_1_2__0"
    // InternalRegularExpressionParser.g:3204:1: rule__Group__Group_1_2__0 : rule__Group__Group_1_2__0__Impl rule__Group__Group_1_2__1 ;
    public final void rule__Group__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3208:1: ( rule__Group__Group_1_2__0__Impl rule__Group__Group_1_2__1 )
            // InternalRegularExpressionParser.g:3209:2: rule__Group__Group_1_2__0__Impl rule__Group__Group_1_2__1
            {
            pushFollow(FOLLOW_25);
            rule__Group__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Group__Group_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1_2__0"


    // $ANTLR start "rule__Group__Group_1_2__0__Impl"
    // InternalRegularExpressionParser.g:3216:1: rule__Group__Group_1_2__0__Impl : ( ( rule__Group__NamedAssignment_1_2_0 ) ) ;
    public final void rule__Group__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3220:1: ( ( ( rule__Group__NamedAssignment_1_2_0 ) ) )
            // InternalRegularExpressionParser.g:3221:1: ( ( rule__Group__NamedAssignment_1_2_0 ) )
            {
            // InternalRegularExpressionParser.g:3221:1: ( ( rule__Group__NamedAssignment_1_2_0 ) )
            // InternalRegularExpressionParser.g:3222:2: ( rule__Group__NamedAssignment_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getNamedAssignment_1_2_0()); 
            }
            // InternalRegularExpressionParser.g:3223:2: ( rule__Group__NamedAssignment_1_2_0 )
            // InternalRegularExpressionParser.g:3223:3: rule__Group__NamedAssignment_1_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Group__NamedAssignment_1_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getNamedAssignment_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1_2__0__Impl"


    // $ANTLR start "rule__Group__Group_1_2__1"
    // InternalRegularExpressionParser.g:3231:1: rule__Group__Group_1_2__1 : rule__Group__Group_1_2__1__Impl rule__Group__Group_1_2__2 ;
    public final void rule__Group__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3235:1: ( rule__Group__Group_1_2__1__Impl rule__Group__Group_1_2__2 )
            // InternalRegularExpressionParser.g:3236:2: rule__Group__Group_1_2__1__Impl rule__Group__Group_1_2__2
            {
            pushFollow(FOLLOW_26);
            rule__Group__Group_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Group__Group_1_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1_2__1"


    // $ANTLR start "rule__Group__Group_1_2__1__Impl"
    // InternalRegularExpressionParser.g:3243:1: rule__Group__Group_1_2__1__Impl : ( ( rule__Group__NameAssignment_1_2_1 ) ) ;
    public final void rule__Group__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3247:1: ( ( ( rule__Group__NameAssignment_1_2_1 ) ) )
            // InternalRegularExpressionParser.g:3248:1: ( ( rule__Group__NameAssignment_1_2_1 ) )
            {
            // InternalRegularExpressionParser.g:3248:1: ( ( rule__Group__NameAssignment_1_2_1 ) )
            // InternalRegularExpressionParser.g:3249:2: ( rule__Group__NameAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getNameAssignment_1_2_1()); 
            }
            // InternalRegularExpressionParser.g:3250:2: ( rule__Group__NameAssignment_1_2_1 )
            // InternalRegularExpressionParser.g:3250:3: rule__Group__NameAssignment_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Group__NameAssignment_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getNameAssignment_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1_2__1__Impl"


    // $ANTLR start "rule__Group__Group_1_2__2"
    // InternalRegularExpressionParser.g:3258:1: rule__Group__Group_1_2__2 : rule__Group__Group_1_2__2__Impl ;
    public final void rule__Group__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3262:1: ( rule__Group__Group_1_2__2__Impl )
            // InternalRegularExpressionParser.g:3263:2: rule__Group__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Group__Group_1_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1_2__2"


    // $ANTLR start "rule__Group__Group_1_2__2__Impl"
    // InternalRegularExpressionParser.g:3269:1: rule__Group__Group_1_2__2__Impl : ( GreaterThanSign ) ;
    public final void rule__Group__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3273:1: ( ( GreaterThanSign ) )
            // InternalRegularExpressionParser.g:3274:1: ( GreaterThanSign )
            {
            // InternalRegularExpressionParser.g:3274:1: ( GreaterThanSign )
            // InternalRegularExpressionParser.g:3275:2: GreaterThanSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getGreaterThanSignKeyword_1_2_2()); 
            }
            match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getGreaterThanSignKeyword_1_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1_2__2__Impl"


    // $ANTLR start "rule__RegExpIdentifierName__Group__0"
    // InternalRegularExpressionParser.g:3285:1: rule__RegExpIdentifierName__Group__0 : rule__RegExpIdentifierName__Group__0__Impl rule__RegExpIdentifierName__Group__1 ;
    public final void rule__RegExpIdentifierName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3289:1: ( rule__RegExpIdentifierName__Group__0__Impl rule__RegExpIdentifierName__Group__1 )
            // InternalRegularExpressionParser.g:3290:2: rule__RegExpIdentifierName__Group__0__Impl rule__RegExpIdentifierName__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__RegExpIdentifierName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RegExpIdentifierName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegExpIdentifierName__Group__0"


    // $ANTLR start "rule__RegExpIdentifierName__Group__0__Impl"
    // InternalRegularExpressionParser.g:3297:1: rule__RegExpIdentifierName__Group__0__Impl : ( ruleRegExpIdentifierStart ) ;
    public final void rule__RegExpIdentifierName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3301:1: ( ( ruleRegExpIdentifierStart ) )
            // InternalRegularExpressionParser.g:3302:1: ( ruleRegExpIdentifierStart )
            {
            // InternalRegularExpressionParser.g:3302:1: ( ruleRegExpIdentifierStart )
            // InternalRegularExpressionParser.g:3303:2: ruleRegExpIdentifierStart
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegExpIdentifierNameAccess().getRegExpIdentifierStartParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRegExpIdentifierStart();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegExpIdentifierNameAccess().getRegExpIdentifierStartParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegExpIdentifierName__Group__0__Impl"


    // $ANTLR start "rule__RegExpIdentifierName__Group__1"
    // InternalRegularExpressionParser.g:3312:1: rule__RegExpIdentifierName__Group__1 : rule__RegExpIdentifierName__Group__1__Impl ;
    public final void rule__RegExpIdentifierName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3316:1: ( rule__RegExpIdentifierName__Group__1__Impl )
            // InternalRegularExpressionParser.g:3317:2: rule__RegExpIdentifierName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RegExpIdentifierName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegExpIdentifierName__Group__1"


    // $ANTLR start "rule__RegExpIdentifierName__Group__1__Impl"
    // InternalRegularExpressionParser.g:3323:1: rule__RegExpIdentifierName__Group__1__Impl : ( ( ruleRegExpIdentifierPart )* ) ;
    public final void rule__RegExpIdentifierName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3327:1: ( ( ( ruleRegExpIdentifierPart )* ) )
            // InternalRegularExpressionParser.g:3328:1: ( ( ruleRegExpIdentifierPart )* )
            {
            // InternalRegularExpressionParser.g:3328:1: ( ( ruleRegExpIdentifierPart )* )
            // InternalRegularExpressionParser.g:3329:2: ( ruleRegExpIdentifierPart )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegExpIdentifierNameAccess().getRegExpIdentifierPartParserRuleCall_1()); 
            }
            // InternalRegularExpressionParser.g:3330:2: ( ruleRegExpIdentifierPart )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==DollarSign||LA33_0==KW__||LA33_0==RULE_UNICODE_ESCAPE||LA33_0==RULE_UNICODE_DIGIT||LA33_0==RULE_UNICODE_LETTER) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalRegularExpressionParser.g:3330:3: ruleRegExpIdentifierPart
            	    {
            	    pushFollow(FOLLOW_28);
            	    ruleRegExpIdentifierPart();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegExpIdentifierNameAccess().getRegExpIdentifierPartParserRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegExpIdentifierName__Group__1__Impl"


    // $ANTLR start "rule__SimpleQuantifier__Group__0"
    // InternalRegularExpressionParser.g:3339:1: rule__SimpleQuantifier__Group__0 : rule__SimpleQuantifier__Group__0__Impl rule__SimpleQuantifier__Group__1 ;
    public final void rule__SimpleQuantifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3343:1: ( rule__SimpleQuantifier__Group__0__Impl rule__SimpleQuantifier__Group__1 )
            // InternalRegularExpressionParser.g:3344:2: rule__SimpleQuantifier__Group__0__Impl rule__SimpleQuantifier__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__SimpleQuantifier__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SimpleQuantifier__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleQuantifier__Group__0"


    // $ANTLR start "rule__SimpleQuantifier__Group__0__Impl"
    // InternalRegularExpressionParser.g:3351:1: rule__SimpleQuantifier__Group__0__Impl : ( ( rule__SimpleQuantifier__QuantifierAssignment_0 ) ) ;
    public final void rule__SimpleQuantifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3355:1: ( ( ( rule__SimpleQuantifier__QuantifierAssignment_0 ) ) )
            // InternalRegularExpressionParser.g:3356:1: ( ( rule__SimpleQuantifier__QuantifierAssignment_0 ) )
            {
            // InternalRegularExpressionParser.g:3356:1: ( ( rule__SimpleQuantifier__QuantifierAssignment_0 ) )
            // InternalRegularExpressionParser.g:3357:2: ( rule__SimpleQuantifier__QuantifierAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleQuantifierAccess().getQuantifierAssignment_0()); 
            }
            // InternalRegularExpressionParser.g:3358:2: ( rule__SimpleQuantifier__QuantifierAssignment_0 )
            // InternalRegularExpressionParser.g:3358:3: rule__SimpleQuantifier__QuantifierAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleQuantifier__QuantifierAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleQuantifierAccess().getQuantifierAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleQuantifier__Group__0__Impl"


    // $ANTLR start "rule__SimpleQuantifier__Group__1"
    // InternalRegularExpressionParser.g:3366:1: rule__SimpleQuantifier__Group__1 : rule__SimpleQuantifier__Group__1__Impl ;
    public final void rule__SimpleQuantifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3370:1: ( rule__SimpleQuantifier__Group__1__Impl )
            // InternalRegularExpressionParser.g:3371:2: rule__SimpleQuantifier__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleQuantifier__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleQuantifier__Group__1"


    // $ANTLR start "rule__SimpleQuantifier__Group__1__Impl"
    // InternalRegularExpressionParser.g:3377:1: rule__SimpleQuantifier__Group__1__Impl : ( ( rule__SimpleQuantifier__NonGreedyAssignment_1 )? ) ;
    public final void rule__SimpleQuantifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3381:1: ( ( ( rule__SimpleQuantifier__NonGreedyAssignment_1 )? ) )
            // InternalRegularExpressionParser.g:3382:1: ( ( rule__SimpleQuantifier__NonGreedyAssignment_1 )? )
            {
            // InternalRegularExpressionParser.g:3382:1: ( ( rule__SimpleQuantifier__NonGreedyAssignment_1 )? )
            // InternalRegularExpressionParser.g:3383:2: ( rule__SimpleQuantifier__NonGreedyAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleQuantifierAccess().getNonGreedyAssignment_1()); 
            }
            // InternalRegularExpressionParser.g:3384:2: ( rule__SimpleQuantifier__NonGreedyAssignment_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==QuestionMark) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalRegularExpressionParser.g:3384:3: rule__SimpleQuantifier__NonGreedyAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleQuantifier__NonGreedyAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleQuantifierAccess().getNonGreedyAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleQuantifier__Group__1__Impl"


    // $ANTLR start "rule__ExactQuantifier__Group__0"
    // InternalRegularExpressionParser.g:3393:1: rule__ExactQuantifier__Group__0 : rule__ExactQuantifier__Group__0__Impl rule__ExactQuantifier__Group__1 ;
    public final void rule__ExactQuantifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3397:1: ( rule__ExactQuantifier__Group__0__Impl rule__ExactQuantifier__Group__1 )
            // InternalRegularExpressionParser.g:3398:2: rule__ExactQuantifier__Group__0__Impl rule__ExactQuantifier__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__ExactQuantifier__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__0"


    // $ANTLR start "rule__ExactQuantifier__Group__0__Impl"
    // InternalRegularExpressionParser.g:3405:1: rule__ExactQuantifier__Group__0__Impl : ( () ) ;
    public final void rule__ExactQuantifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3409:1: ( ( () ) )
            // InternalRegularExpressionParser.g:3410:1: ( () )
            {
            // InternalRegularExpressionParser.g:3410:1: ( () )
            // InternalRegularExpressionParser.g:3411:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getExactQuantifierAction_0()); 
            }
            // InternalRegularExpressionParser.g:3412:2: ()
            // InternalRegularExpressionParser.g:3412:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getExactQuantifierAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__0__Impl"


    // $ANTLR start "rule__ExactQuantifier__Group__1"
    // InternalRegularExpressionParser.g:3420:1: rule__ExactQuantifier__Group__1 : rule__ExactQuantifier__Group__1__Impl rule__ExactQuantifier__Group__2 ;
    public final void rule__ExactQuantifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3424:1: ( rule__ExactQuantifier__Group__1__Impl rule__ExactQuantifier__Group__2 )
            // InternalRegularExpressionParser.g:3425:2: rule__ExactQuantifier__Group__1__Impl rule__ExactQuantifier__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__ExactQuantifier__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__1"


    // $ANTLR start "rule__ExactQuantifier__Group__1__Impl"
    // InternalRegularExpressionParser.g:3432:1: rule__ExactQuantifier__Group__1__Impl : ( LeftCurlyBracket ) ;
    public final void rule__ExactQuantifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3436:1: ( ( LeftCurlyBracket ) )
            // InternalRegularExpressionParser.g:3437:1: ( LeftCurlyBracket )
            {
            // InternalRegularExpressionParser.g:3437:1: ( LeftCurlyBracket )
            // InternalRegularExpressionParser.g:3438:2: LeftCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,LeftCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__1__Impl"


    // $ANTLR start "rule__ExactQuantifier__Group__2"
    // InternalRegularExpressionParser.g:3447:1: rule__ExactQuantifier__Group__2 : rule__ExactQuantifier__Group__2__Impl rule__ExactQuantifier__Group__3 ;
    public final void rule__ExactQuantifier__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3451:1: ( rule__ExactQuantifier__Group__2__Impl rule__ExactQuantifier__Group__3 )
            // InternalRegularExpressionParser.g:3452:2: rule__ExactQuantifier__Group__2__Impl rule__ExactQuantifier__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__ExactQuantifier__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__2"


    // $ANTLR start "rule__ExactQuantifier__Group__2__Impl"
    // InternalRegularExpressionParser.g:3459:1: rule__ExactQuantifier__Group__2__Impl : ( ( rule__ExactQuantifier__MinAssignment_2 ) ) ;
    public final void rule__ExactQuantifier__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3463:1: ( ( ( rule__ExactQuantifier__MinAssignment_2 ) ) )
            // InternalRegularExpressionParser.g:3464:1: ( ( rule__ExactQuantifier__MinAssignment_2 ) )
            {
            // InternalRegularExpressionParser.g:3464:1: ( ( rule__ExactQuantifier__MinAssignment_2 ) )
            // InternalRegularExpressionParser.g:3465:2: ( rule__ExactQuantifier__MinAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getMinAssignment_2()); 
            }
            // InternalRegularExpressionParser.g:3466:2: ( rule__ExactQuantifier__MinAssignment_2 )
            // InternalRegularExpressionParser.g:3466:3: rule__ExactQuantifier__MinAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__MinAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getMinAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__2__Impl"


    // $ANTLR start "rule__ExactQuantifier__Group__3"
    // InternalRegularExpressionParser.g:3474:1: rule__ExactQuantifier__Group__3 : rule__ExactQuantifier__Group__3__Impl rule__ExactQuantifier__Group__4 ;
    public final void rule__ExactQuantifier__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3478:1: ( rule__ExactQuantifier__Group__3__Impl rule__ExactQuantifier__Group__4 )
            // InternalRegularExpressionParser.g:3479:2: rule__ExactQuantifier__Group__3__Impl rule__ExactQuantifier__Group__4
            {
            pushFollow(FOLLOW_31);
            rule__ExactQuantifier__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__3"


    // $ANTLR start "rule__ExactQuantifier__Group__3__Impl"
    // InternalRegularExpressionParser.g:3486:1: rule__ExactQuantifier__Group__3__Impl : ( ( rule__ExactQuantifier__Alternatives_3 )? ) ;
    public final void rule__ExactQuantifier__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3490:1: ( ( ( rule__ExactQuantifier__Alternatives_3 )? ) )
            // InternalRegularExpressionParser.g:3491:1: ( ( rule__ExactQuantifier__Alternatives_3 )? )
            {
            // InternalRegularExpressionParser.g:3491:1: ( ( rule__ExactQuantifier__Alternatives_3 )? )
            // InternalRegularExpressionParser.g:3492:2: ( rule__ExactQuantifier__Alternatives_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getAlternatives_3()); 
            }
            // InternalRegularExpressionParser.g:3493:2: ( rule__ExactQuantifier__Alternatives_3 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==Comma) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalRegularExpressionParser.g:3493:3: rule__ExactQuantifier__Alternatives_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExactQuantifier__Alternatives_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getAlternatives_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__3__Impl"


    // $ANTLR start "rule__ExactQuantifier__Group__4"
    // InternalRegularExpressionParser.g:3501:1: rule__ExactQuantifier__Group__4 : rule__ExactQuantifier__Group__4__Impl rule__ExactQuantifier__Group__5 ;
    public final void rule__ExactQuantifier__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3505:1: ( rule__ExactQuantifier__Group__4__Impl rule__ExactQuantifier__Group__5 )
            // InternalRegularExpressionParser.g:3506:2: rule__ExactQuantifier__Group__4__Impl rule__ExactQuantifier__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__ExactQuantifier__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__4"


    // $ANTLR start "rule__ExactQuantifier__Group__4__Impl"
    // InternalRegularExpressionParser.g:3513:1: rule__ExactQuantifier__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__ExactQuantifier__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3517:1: ( ( RightCurlyBracket ) )
            // InternalRegularExpressionParser.g:3518:1: ( RightCurlyBracket )
            {
            // InternalRegularExpressionParser.g:3518:1: ( RightCurlyBracket )
            // InternalRegularExpressionParser.g:3519:2: RightCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__4__Impl"


    // $ANTLR start "rule__ExactQuantifier__Group__5"
    // InternalRegularExpressionParser.g:3528:1: rule__ExactQuantifier__Group__5 : rule__ExactQuantifier__Group__5__Impl ;
    public final void rule__ExactQuantifier__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3532:1: ( rule__ExactQuantifier__Group__5__Impl )
            // InternalRegularExpressionParser.g:3533:2: rule__ExactQuantifier__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__5"


    // $ANTLR start "rule__ExactQuantifier__Group__5__Impl"
    // InternalRegularExpressionParser.g:3539:1: rule__ExactQuantifier__Group__5__Impl : ( ( rule__ExactQuantifier__NonGreedyAssignment_5 )? ) ;
    public final void rule__ExactQuantifier__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3543:1: ( ( ( rule__ExactQuantifier__NonGreedyAssignment_5 )? ) )
            // InternalRegularExpressionParser.g:3544:1: ( ( rule__ExactQuantifier__NonGreedyAssignment_5 )? )
            {
            // InternalRegularExpressionParser.g:3544:1: ( ( rule__ExactQuantifier__NonGreedyAssignment_5 )? )
            // InternalRegularExpressionParser.g:3545:2: ( rule__ExactQuantifier__NonGreedyAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getNonGreedyAssignment_5()); 
            }
            // InternalRegularExpressionParser.g:3546:2: ( rule__ExactQuantifier__NonGreedyAssignment_5 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==QuestionMark) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalRegularExpressionParser.g:3546:3: rule__ExactQuantifier__NonGreedyAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExactQuantifier__NonGreedyAssignment_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getNonGreedyAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group__5__Impl"


    // $ANTLR start "rule__ExactQuantifier__Group_3_0__0"
    // InternalRegularExpressionParser.g:3555:1: rule__ExactQuantifier__Group_3_0__0 : rule__ExactQuantifier__Group_3_0__0__Impl rule__ExactQuantifier__Group_3_0__1 ;
    public final void rule__ExactQuantifier__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3559:1: ( rule__ExactQuantifier__Group_3_0__0__Impl rule__ExactQuantifier__Group_3_0__1 )
            // InternalRegularExpressionParser.g:3560:2: rule__ExactQuantifier__Group_3_0__0__Impl rule__ExactQuantifier__Group_3_0__1
            {
            pushFollow(FOLLOW_30);
            rule__ExactQuantifier__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group_3_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group_3_0__0"


    // $ANTLR start "rule__ExactQuantifier__Group_3_0__0__Impl"
    // InternalRegularExpressionParser.g:3567:1: rule__ExactQuantifier__Group_3_0__0__Impl : ( Comma ) ;
    public final void rule__ExactQuantifier__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3571:1: ( ( Comma ) )
            // InternalRegularExpressionParser.g:3572:1: ( Comma )
            {
            // InternalRegularExpressionParser.g:3572:1: ( Comma )
            // InternalRegularExpressionParser.g:3573:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getCommaKeyword_3_0_0()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getCommaKeyword_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group_3_0__0__Impl"


    // $ANTLR start "rule__ExactQuantifier__Group_3_0__1"
    // InternalRegularExpressionParser.g:3582:1: rule__ExactQuantifier__Group_3_0__1 : rule__ExactQuantifier__Group_3_0__1__Impl ;
    public final void rule__ExactQuantifier__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3586:1: ( rule__ExactQuantifier__Group_3_0__1__Impl )
            // InternalRegularExpressionParser.g:3587:2: rule__ExactQuantifier__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__Group_3_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group_3_0__1"


    // $ANTLR start "rule__ExactQuantifier__Group_3_0__1__Impl"
    // InternalRegularExpressionParser.g:3593:1: rule__ExactQuantifier__Group_3_0__1__Impl : ( ( rule__ExactQuantifier__MaxAssignment_3_0_1 ) ) ;
    public final void rule__ExactQuantifier__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3597:1: ( ( ( rule__ExactQuantifier__MaxAssignment_3_0_1 ) ) )
            // InternalRegularExpressionParser.g:3598:1: ( ( rule__ExactQuantifier__MaxAssignment_3_0_1 ) )
            {
            // InternalRegularExpressionParser.g:3598:1: ( ( rule__ExactQuantifier__MaxAssignment_3_0_1 ) )
            // InternalRegularExpressionParser.g:3599:2: ( rule__ExactQuantifier__MaxAssignment_3_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getMaxAssignment_3_0_1()); 
            }
            // InternalRegularExpressionParser.g:3600:2: ( rule__ExactQuantifier__MaxAssignment_3_0_1 )
            // InternalRegularExpressionParser.g:3600:3: rule__ExactQuantifier__MaxAssignment_3_0_1
            {
            pushFollow(FOLLOW_2);
            rule__ExactQuantifier__MaxAssignment_3_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getMaxAssignment_3_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__Group_3_0__1__Impl"


    // $ANTLR start "rule__RegularExpressionFlags__Group__0"
    // InternalRegularExpressionParser.g:3609:1: rule__RegularExpressionFlags__Group__0 : rule__RegularExpressionFlags__Group__0__Impl rule__RegularExpressionFlags__Group__1 ;
    public final void rule__RegularExpressionFlags__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3613:1: ( rule__RegularExpressionFlags__Group__0__Impl rule__RegularExpressionFlags__Group__1 )
            // InternalRegularExpressionParser.g:3614:2: rule__RegularExpressionFlags__Group__0__Impl rule__RegularExpressionFlags__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__RegularExpressionFlags__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RegularExpressionFlags__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionFlags__Group__0"


    // $ANTLR start "rule__RegularExpressionFlags__Group__0__Impl"
    // InternalRegularExpressionParser.g:3621:1: rule__RegularExpressionFlags__Group__0__Impl : ( () ) ;
    public final void rule__RegularExpressionFlags__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3625:1: ( ( () ) )
            // InternalRegularExpressionParser.g:3626:1: ( () )
            {
            // InternalRegularExpressionParser.g:3626:1: ( () )
            // InternalRegularExpressionParser.g:3627:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionFlagsAccess().getRegularExpressionFlagsAction_0()); 
            }
            // InternalRegularExpressionParser.g:3628:2: ()
            // InternalRegularExpressionParser.g:3628:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionFlagsAccess().getRegularExpressionFlagsAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionFlags__Group__0__Impl"


    // $ANTLR start "rule__RegularExpressionFlags__Group__1"
    // InternalRegularExpressionParser.g:3636:1: rule__RegularExpressionFlags__Group__1 : rule__RegularExpressionFlags__Group__1__Impl ;
    public final void rule__RegularExpressionFlags__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3640:1: ( rule__RegularExpressionFlags__Group__1__Impl )
            // InternalRegularExpressionParser.g:3641:2: rule__RegularExpressionFlags__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RegularExpressionFlags__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionFlags__Group__1"


    // $ANTLR start "rule__RegularExpressionFlags__Group__1__Impl"
    // InternalRegularExpressionParser.g:3647:1: rule__RegularExpressionFlags__Group__1__Impl : ( ( rule__RegularExpressionFlags__FlagsAssignment_1 )* ) ;
    public final void rule__RegularExpressionFlags__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3651:1: ( ( ( rule__RegularExpressionFlags__FlagsAssignment_1 )* ) )
            // InternalRegularExpressionParser.g:3652:1: ( ( rule__RegularExpressionFlags__FlagsAssignment_1 )* )
            {
            // InternalRegularExpressionParser.g:3652:1: ( ( rule__RegularExpressionFlags__FlagsAssignment_1 )* )
            // InternalRegularExpressionParser.g:3653:2: ( rule__RegularExpressionFlags__FlagsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionFlagsAccess().getFlagsAssignment_1()); 
            }
            // InternalRegularExpressionParser.g:3654:2: ( rule__RegularExpressionFlags__FlagsAssignment_1 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_UNICODE_ESCAPE||LA37_0==RULE_UNICODE_LETTER) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalRegularExpressionParser.g:3654:3: rule__RegularExpressionFlags__FlagsAssignment_1
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__RegularExpressionFlags__FlagsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionFlagsAccess().getFlagsAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionFlags__Group__1__Impl"


    // $ANTLR start "rule__RegularExpressionLiteral__BodyAssignment_1"
    // InternalRegularExpressionParser.g:3663:1: rule__RegularExpressionLiteral__BodyAssignment_1 : ( ruleRegularExpressionBody ) ;
    public final void rule__RegularExpressionLiteral__BodyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3667:1: ( ( ruleRegularExpressionBody ) )
            // InternalRegularExpressionParser.g:3668:2: ( ruleRegularExpressionBody )
            {
            // InternalRegularExpressionParser.g:3668:2: ( ruleRegularExpressionBody )
            // InternalRegularExpressionParser.g:3669:3: ruleRegularExpressionBody
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionLiteralAccess().getBodyRegularExpressionBodyParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRegularExpressionBody();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionLiteralAccess().getBodyRegularExpressionBodyParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__BodyAssignment_1"


    // $ANTLR start "rule__RegularExpressionLiteral__FlagsAssignment_3"
    // InternalRegularExpressionParser.g:3678:1: rule__RegularExpressionLiteral__FlagsAssignment_3 : ( ruleRegularExpressionFlags ) ;
    public final void rule__RegularExpressionLiteral__FlagsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3682:1: ( ( ruleRegularExpressionFlags ) )
            // InternalRegularExpressionParser.g:3683:2: ( ruleRegularExpressionFlags )
            {
            // InternalRegularExpressionParser.g:3683:2: ( ruleRegularExpressionFlags )
            // InternalRegularExpressionParser.g:3684:3: ruleRegularExpressionFlags
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionLiteralAccess().getFlagsRegularExpressionFlagsParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRegularExpressionFlags();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionLiteralAccess().getFlagsRegularExpressionFlagsParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionLiteral__FlagsAssignment_3"


    // $ANTLR start "rule__RegularExpressionBody__PatternAssignment"
    // InternalRegularExpressionParser.g:3693:1: rule__RegularExpressionBody__PatternAssignment : ( ruleDisjunction ) ;
    public final void rule__RegularExpressionBody__PatternAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3697:1: ( ( ruleDisjunction ) )
            // InternalRegularExpressionParser.g:3698:2: ( ruleDisjunction )
            {
            // InternalRegularExpressionParser.g:3698:2: ( ruleDisjunction )
            // InternalRegularExpressionParser.g:3699:3: ruleDisjunction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionBodyAccess().getPatternDisjunctionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDisjunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionBodyAccess().getPatternDisjunctionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionBody__PatternAssignment"


    // $ANTLR start "rule__Disjunction__ElementsAssignment_0_1_1_1"
    // InternalRegularExpressionParser.g:3708:1: rule__Disjunction__ElementsAssignment_0_1_1_1 : ( ruleAlternative ) ;
    public final void rule__Disjunction__ElementsAssignment_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3712:1: ( ( ruleAlternative ) )
            // InternalRegularExpressionParser.g:3713:2: ( ruleAlternative )
            {
            // InternalRegularExpressionParser.g:3713:2: ( ruleAlternative )
            // InternalRegularExpressionParser.g:3714:3: ruleAlternative
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getElementsAlternativeParserRuleCall_0_1_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAlternative();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getElementsAlternativeParserRuleCall_0_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__ElementsAssignment_0_1_1_1"


    // $ANTLR start "rule__Disjunction__ElementsAssignment_1_1_1"
    // InternalRegularExpressionParser.g:3723:1: rule__Disjunction__ElementsAssignment_1_1_1 : ( ruleAlternative ) ;
    public final void rule__Disjunction__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3727:1: ( ( ruleAlternative ) )
            // InternalRegularExpressionParser.g:3728:2: ( ruleAlternative )
            {
            // InternalRegularExpressionParser.g:3728:2: ( ruleAlternative )
            // InternalRegularExpressionParser.g:3729:3: ruleAlternative
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDisjunctionAccess().getElementsAlternativeParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAlternative();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDisjunctionAccess().getElementsAlternativeParserRuleCall_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__Alternative__ElementsAssignment_1_1"
    // InternalRegularExpressionParser.g:3738:1: rule__Alternative__ElementsAssignment_1_1 : ( ruleTerm ) ;
    public final void rule__Alternative__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3742:1: ( ( ruleTerm ) )
            // InternalRegularExpressionParser.g:3743:2: ( ruleTerm )
            {
            // InternalRegularExpressionParser.g:3743:2: ( ruleTerm )
            // InternalRegularExpressionParser.g:3744:3: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlternativeAccess().getElementsTermParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlternativeAccess().getElementsTermParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__ElementsAssignment_1_1"


    // $ANTLR start "rule__Term__QuantifierAssignment_1_1"
    // InternalRegularExpressionParser.g:3753:1: rule__Term__QuantifierAssignment_1_1 : ( ruleQuantifier ) ;
    public final void rule__Term__QuantifierAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3757:1: ( ( ruleQuantifier ) )
            // InternalRegularExpressionParser.g:3758:2: ( ruleQuantifier )
            {
            // InternalRegularExpressionParser.g:3758:2: ( ruleQuantifier )
            // InternalRegularExpressionParser.g:3759:3: ruleQuantifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getQuantifierQuantifierParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQuantifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getQuantifierQuantifierParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__QuantifierAssignment_1_1"


    // $ANTLR start "rule__WordBoundary__NotAssignment_1_1"
    // InternalRegularExpressionParser.g:3768:1: rule__WordBoundary__NotAssignment_1_1 : ( RULE_NOT_WORD_BOUNDARY ) ;
    public final void rule__WordBoundary__NotAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3772:1: ( ( RULE_NOT_WORD_BOUNDARY ) )
            // InternalRegularExpressionParser.g:3773:2: ( RULE_NOT_WORD_BOUNDARY )
            {
            // InternalRegularExpressionParser.g:3773:2: ( RULE_NOT_WORD_BOUNDARY )
            // InternalRegularExpressionParser.g:3774:3: RULE_NOT_WORD_BOUNDARY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWordBoundaryAccess().getNotNOT_WORD_BOUNDARYTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_NOT_WORD_BOUNDARY,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWordBoundaryAccess().getNotNOT_WORD_BOUNDARYTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordBoundary__NotAssignment_1_1"


    // $ANTLR start "rule__AbstractLookAhead__NotAssignment_0_0_1_1"
    // InternalRegularExpressionParser.g:3783:1: rule__AbstractLookAhead__NotAssignment_0_0_1_1 : ( ( LeftParenthesisQuestionMarkExclamationMark ) ) ;
    public final void rule__AbstractLookAhead__NotAssignment_0_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3787:1: ( ( ( LeftParenthesisQuestionMarkExclamationMark ) ) )
            // InternalRegularExpressionParser.g:3788:2: ( ( LeftParenthesisQuestionMarkExclamationMark ) )
            {
            // InternalRegularExpressionParser.g:3788:2: ( ( LeftParenthesisQuestionMarkExclamationMark ) )
            // InternalRegularExpressionParser.g:3789:3: ( LeftParenthesisQuestionMarkExclamationMark )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getNotLeftParenthesisQuestionMarkExclamationMarkKeyword_0_0_1_1_0()); 
            }
            // InternalRegularExpressionParser.g:3790:3: ( LeftParenthesisQuestionMarkExclamationMark )
            // InternalRegularExpressionParser.g:3791:4: LeftParenthesisQuestionMarkExclamationMark
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getNotLeftParenthesisQuestionMarkExclamationMarkKeyword_0_0_1_1_0()); 
            }
            match(input,LeftParenthesisQuestionMarkExclamationMark,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getNotLeftParenthesisQuestionMarkExclamationMarkKeyword_0_0_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getNotLeftParenthesisQuestionMarkExclamationMarkKeyword_0_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__NotAssignment_0_0_1_1"


    // $ANTLR start "rule__AbstractLookAhead__NotAssignment_0_1_1_1"
    // InternalRegularExpressionParser.g:3802:1: rule__AbstractLookAhead__NotAssignment_0_1_1_1 : ( ( LeftParenthesisQuestionMarkLessThanSignExclamationMark ) ) ;
    public final void rule__AbstractLookAhead__NotAssignment_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3806:1: ( ( ( LeftParenthesisQuestionMarkLessThanSignExclamationMark ) ) )
            // InternalRegularExpressionParser.g:3807:2: ( ( LeftParenthesisQuestionMarkLessThanSignExclamationMark ) )
            {
            // InternalRegularExpressionParser.g:3807:2: ( ( LeftParenthesisQuestionMarkLessThanSignExclamationMark ) )
            // InternalRegularExpressionParser.g:3808:3: ( LeftParenthesisQuestionMarkLessThanSignExclamationMark )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getNotLeftParenthesisQuestionMarkLessThanSignExclamationMarkKeyword_0_1_1_1_0()); 
            }
            // InternalRegularExpressionParser.g:3809:3: ( LeftParenthesisQuestionMarkLessThanSignExclamationMark )
            // InternalRegularExpressionParser.g:3810:4: LeftParenthesisQuestionMarkLessThanSignExclamationMark
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getNotLeftParenthesisQuestionMarkLessThanSignExclamationMarkKeyword_0_1_1_1_0()); 
            }
            match(input,LeftParenthesisQuestionMarkLessThanSignExclamationMark,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getNotLeftParenthesisQuestionMarkLessThanSignExclamationMarkKeyword_0_1_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getNotLeftParenthesisQuestionMarkLessThanSignExclamationMarkKeyword_0_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__NotAssignment_0_1_1_1"


    // $ANTLR start "rule__AbstractLookAhead__PatternAssignment_1"
    // InternalRegularExpressionParser.g:3821:1: rule__AbstractLookAhead__PatternAssignment_1 : ( ruleDisjunction ) ;
    public final void rule__AbstractLookAhead__PatternAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3825:1: ( ( ruleDisjunction ) )
            // InternalRegularExpressionParser.g:3826:2: ( ruleDisjunction )
            {
            // InternalRegularExpressionParser.g:3826:2: ( ruleDisjunction )
            // InternalRegularExpressionParser.g:3827:3: ruleDisjunction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractLookAheadAccess().getPatternDisjunctionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDisjunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractLookAheadAccess().getPatternDisjunctionParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractLookAhead__PatternAssignment_1"


    // $ANTLR start "rule__PatternCharacter__ValueAssignment"
    // InternalRegularExpressionParser.g:3836:1: rule__PatternCharacter__ValueAssignment : ( ( rule__PatternCharacter__ValueAlternatives_0 ) ) ;
    public final void rule__PatternCharacter__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3840:1: ( ( ( rule__PatternCharacter__ValueAlternatives_0 ) ) )
            // InternalRegularExpressionParser.g:3841:2: ( ( rule__PatternCharacter__ValueAlternatives_0 ) )
            {
            // InternalRegularExpressionParser.g:3841:2: ( ( rule__PatternCharacter__ValueAlternatives_0 ) )
            // InternalRegularExpressionParser.g:3842:3: ( rule__PatternCharacter__ValueAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPatternCharacterAccess().getValueAlternatives_0()); 
            }
            // InternalRegularExpressionParser.g:3843:3: ( rule__PatternCharacter__ValueAlternatives_0 )
            // InternalRegularExpressionParser.g:3843:4: rule__PatternCharacter__ValueAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__PatternCharacter__ValueAlternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPatternCharacterAccess().getValueAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PatternCharacter__ValueAssignment"


    // $ANTLR start "rule__CharacterClassEscapeSequence__SequenceAssignment"
    // InternalRegularExpressionParser.g:3851:1: rule__CharacterClassEscapeSequence__SequenceAssignment : ( RULE_CHARACTER_CLASS_ESCAPE ) ;
    public final void rule__CharacterClassEscapeSequence__SequenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3855:1: ( ( RULE_CHARACTER_CLASS_ESCAPE ) )
            // InternalRegularExpressionParser.g:3856:2: ( RULE_CHARACTER_CLASS_ESCAPE )
            {
            // InternalRegularExpressionParser.g:3856:2: ( RULE_CHARACTER_CLASS_ESCAPE )
            // InternalRegularExpressionParser.g:3857:3: RULE_CHARACTER_CLASS_ESCAPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassEscapeSequenceAccess().getSequenceCHARACTER_CLASS_ESCAPETerminalRuleCall_0()); 
            }
            match(input,RULE_CHARACTER_CLASS_ESCAPE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassEscapeSequenceAccess().getSequenceCHARACTER_CLASS_ESCAPETerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassEscapeSequence__SequenceAssignment"


    // $ANTLR start "rule__CharacterEscapeSequence__SequenceAssignment"
    // InternalRegularExpressionParser.g:3866:1: rule__CharacterEscapeSequence__SequenceAssignment : ( RULE_CONTROL_ESCAPE ) ;
    public final void rule__CharacterEscapeSequence__SequenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3870:1: ( ( RULE_CONTROL_ESCAPE ) )
            // InternalRegularExpressionParser.g:3871:2: ( RULE_CONTROL_ESCAPE )
            {
            // InternalRegularExpressionParser.g:3871:2: ( RULE_CONTROL_ESCAPE )
            // InternalRegularExpressionParser.g:3872:3: RULE_CONTROL_ESCAPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterEscapeSequenceAccess().getSequenceCONTROL_ESCAPETerminalRuleCall_0()); 
            }
            match(input,RULE_CONTROL_ESCAPE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterEscapeSequenceAccess().getSequenceCONTROL_ESCAPETerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterEscapeSequence__SequenceAssignment"


    // $ANTLR start "rule__ControlLetterEscapeSequence__SequenceAssignment"
    // InternalRegularExpressionParser.g:3881:1: rule__ControlLetterEscapeSequence__SequenceAssignment : ( RULE_CONTROL_LETTER_ESCAPE ) ;
    public final void rule__ControlLetterEscapeSequence__SequenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3885:1: ( ( RULE_CONTROL_LETTER_ESCAPE ) )
            // InternalRegularExpressionParser.g:3886:2: ( RULE_CONTROL_LETTER_ESCAPE )
            {
            // InternalRegularExpressionParser.g:3886:2: ( RULE_CONTROL_LETTER_ESCAPE )
            // InternalRegularExpressionParser.g:3887:3: RULE_CONTROL_LETTER_ESCAPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getControlLetterEscapeSequenceAccess().getSequenceCONTROL_LETTER_ESCAPETerminalRuleCall_0()); 
            }
            match(input,RULE_CONTROL_LETTER_ESCAPE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getControlLetterEscapeSequenceAccess().getSequenceCONTROL_LETTER_ESCAPETerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ControlLetterEscapeSequence__SequenceAssignment"


    // $ANTLR start "rule__HexEscapeSequence__SequenceAssignment"
    // InternalRegularExpressionParser.g:3896:1: rule__HexEscapeSequence__SequenceAssignment : ( RULE_HEX_ESCAPE ) ;
    public final void rule__HexEscapeSequence__SequenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3900:1: ( ( RULE_HEX_ESCAPE ) )
            // InternalRegularExpressionParser.g:3901:2: ( RULE_HEX_ESCAPE )
            {
            // InternalRegularExpressionParser.g:3901:2: ( RULE_HEX_ESCAPE )
            // InternalRegularExpressionParser.g:3902:3: RULE_HEX_ESCAPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexEscapeSequenceAccess().getSequenceHEX_ESCAPETerminalRuleCall_0()); 
            }
            match(input,RULE_HEX_ESCAPE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexEscapeSequenceAccess().getSequenceHEX_ESCAPETerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HexEscapeSequence__SequenceAssignment"


    // $ANTLR start "rule__UnicodeEscapeSequence__SequenceAssignment"
    // InternalRegularExpressionParser.g:3911:1: rule__UnicodeEscapeSequence__SequenceAssignment : ( RULE_UNICODE_ESCAPE ) ;
    public final void rule__UnicodeEscapeSequence__SequenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3915:1: ( ( RULE_UNICODE_ESCAPE ) )
            // InternalRegularExpressionParser.g:3916:2: ( RULE_UNICODE_ESCAPE )
            {
            // InternalRegularExpressionParser.g:3916:2: ( RULE_UNICODE_ESCAPE )
            // InternalRegularExpressionParser.g:3917:3: RULE_UNICODE_ESCAPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnicodeEscapeSequenceAccess().getSequenceUNICODE_ESCAPETerminalRuleCall_0()); 
            }
            match(input,RULE_UNICODE_ESCAPE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnicodeEscapeSequenceAccess().getSequenceUNICODE_ESCAPETerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnicodeEscapeSequence__SequenceAssignment"


    // $ANTLR start "rule__IdentityEscapeSequence__SequenceAssignment"
    // InternalRegularExpressionParser.g:3926:1: rule__IdentityEscapeSequence__SequenceAssignment : ( RULE_IDENTITY_ESCAPE ) ;
    public final void rule__IdentityEscapeSequence__SequenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3930:1: ( ( RULE_IDENTITY_ESCAPE ) )
            // InternalRegularExpressionParser.g:3931:2: ( RULE_IDENTITY_ESCAPE )
            {
            // InternalRegularExpressionParser.g:3931:2: ( RULE_IDENTITY_ESCAPE )
            // InternalRegularExpressionParser.g:3932:3: RULE_IDENTITY_ESCAPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentityEscapeSequenceAccess().getSequenceIDENTITY_ESCAPETerminalRuleCall_0()); 
            }
            match(input,RULE_IDENTITY_ESCAPE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentityEscapeSequenceAccess().getSequenceIDENTITY_ESCAPETerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentityEscapeSequence__SequenceAssignment"


    // $ANTLR start "rule__DecimalEscapeSequence__SequenceAssignment"
    // InternalRegularExpressionParser.g:3941:1: rule__DecimalEscapeSequence__SequenceAssignment : ( RULE_DECIMAL_ESCAPE ) ;
    public final void rule__DecimalEscapeSequence__SequenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3945:1: ( ( RULE_DECIMAL_ESCAPE ) )
            // InternalRegularExpressionParser.g:3946:2: ( RULE_DECIMAL_ESCAPE )
            {
            // InternalRegularExpressionParser.g:3946:2: ( RULE_DECIMAL_ESCAPE )
            // InternalRegularExpressionParser.g:3947:3: RULE_DECIMAL_ESCAPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalEscapeSequenceAccess().getSequenceDECIMAL_ESCAPETerminalRuleCall_0()); 
            }
            match(input,RULE_DECIMAL_ESCAPE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalEscapeSequenceAccess().getSequenceDECIMAL_ESCAPETerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalEscapeSequence__SequenceAssignment"


    // $ANTLR start "rule__CharacterClass__NegatedAssignment_2_0"
    // InternalRegularExpressionParser.g:3956:1: rule__CharacterClass__NegatedAssignment_2_0 : ( ( CircumflexAccent ) ) ;
    public final void rule__CharacterClass__NegatedAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3960:1: ( ( ( CircumflexAccent ) ) )
            // InternalRegularExpressionParser.g:3961:2: ( ( CircumflexAccent ) )
            {
            // InternalRegularExpressionParser.g:3961:2: ( ( CircumflexAccent ) )
            // InternalRegularExpressionParser.g:3962:3: ( CircumflexAccent )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getNegatedCircumflexAccentKeyword_2_0_0()); 
            }
            // InternalRegularExpressionParser.g:3963:3: ( CircumflexAccent )
            // InternalRegularExpressionParser.g:3964:4: CircumflexAccent
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getNegatedCircumflexAccentKeyword_2_0_0()); 
            }
            match(input,CircumflexAccent,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getNegatedCircumflexAccentKeyword_2_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getNegatedCircumflexAccentKeyword_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__NegatedAssignment_2_0"


    // $ANTLR start "rule__CharacterClass__ElementsAssignment_3"
    // InternalRegularExpressionParser.g:3975:1: rule__CharacterClass__ElementsAssignment_3 : ( ruleCharacterClassElement ) ;
    public final void rule__CharacterClass__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3979:1: ( ( ruleCharacterClassElement ) )
            // InternalRegularExpressionParser.g:3980:2: ( ruleCharacterClassElement )
            {
            // InternalRegularExpressionParser.g:3980:2: ( ruleCharacterClassElement )
            // InternalRegularExpressionParser.g:3981:3: ruleCharacterClassElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAccess().getElementsCharacterClassElementParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCharacterClassElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAccess().getElementsCharacterClassElementParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClass__ElementsAssignment_3"


    // $ANTLR start "rule__CharacterClassElement__RightAssignment_1_0_2"
    // InternalRegularExpressionParser.g:3990:1: rule__CharacterClassElement__RightAssignment_1_0_2 : ( ruleCharacterClassAtom ) ;
    public final void rule__CharacterClassElement__RightAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:3994:1: ( ( ruleCharacterClassAtom ) )
            // InternalRegularExpressionParser.g:3995:2: ( ruleCharacterClassAtom )
            {
            // InternalRegularExpressionParser.g:3995:2: ( ruleCharacterClassAtom )
            // InternalRegularExpressionParser.g:3996:3: ruleCharacterClassAtom
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassElementAccess().getRightCharacterClassAtomParserRuleCall_1_0_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCharacterClassAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassElementAccess().getRightCharacterClassAtomParserRuleCall_1_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassElement__RightAssignment_1_0_2"


    // $ANTLR start "rule__CharacterClassAtom__CharactersAssignment_1"
    // InternalRegularExpressionParser.g:4005:1: rule__CharacterClassAtom__CharactersAssignment_1 : ( ( rule__CharacterClassAtom__CharactersAlternatives_1_0 ) ) ;
    public final void rule__CharacterClassAtom__CharactersAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4009:1: ( ( ( rule__CharacterClassAtom__CharactersAlternatives_1_0 ) ) )
            // InternalRegularExpressionParser.g:4010:2: ( ( rule__CharacterClassAtom__CharactersAlternatives_1_0 ) )
            {
            // InternalRegularExpressionParser.g:4010:2: ( ( rule__CharacterClassAtom__CharactersAlternatives_1_0 ) )
            // InternalRegularExpressionParser.g:4011:3: ( rule__CharacterClassAtom__CharactersAlternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterClassAtomAccess().getCharactersAlternatives_1_0()); 
            }
            // InternalRegularExpressionParser.g:4012:3: ( rule__CharacterClassAtom__CharactersAlternatives_1_0 )
            // InternalRegularExpressionParser.g:4012:4: rule__CharacterClassAtom__CharactersAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__CharacterClassAtom__CharactersAlternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterClassAtomAccess().getCharactersAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterClassAtom__CharactersAssignment_1"


    // $ANTLR start "rule__Group__NonCapturingAssignment_1_1"
    // InternalRegularExpressionParser.g:4020:1: rule__Group__NonCapturingAssignment_1_1 : ( ( LeftParenthesisQuestionMarkColon ) ) ;
    public final void rule__Group__NonCapturingAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4024:1: ( ( ( LeftParenthesisQuestionMarkColon ) ) )
            // InternalRegularExpressionParser.g:4025:2: ( ( LeftParenthesisQuestionMarkColon ) )
            {
            // InternalRegularExpressionParser.g:4025:2: ( ( LeftParenthesisQuestionMarkColon ) )
            // InternalRegularExpressionParser.g:4026:3: ( LeftParenthesisQuestionMarkColon )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getNonCapturingLeftParenthesisQuestionMarkColonKeyword_1_1_0()); 
            }
            // InternalRegularExpressionParser.g:4027:3: ( LeftParenthesisQuestionMarkColon )
            // InternalRegularExpressionParser.g:4028:4: LeftParenthesisQuestionMarkColon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getNonCapturingLeftParenthesisQuestionMarkColonKeyword_1_1_0()); 
            }
            match(input,LeftParenthesisQuestionMarkColon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getNonCapturingLeftParenthesisQuestionMarkColonKeyword_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getNonCapturingLeftParenthesisQuestionMarkColonKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__NonCapturingAssignment_1_1"


    // $ANTLR start "rule__Group__NamedAssignment_1_2_0"
    // InternalRegularExpressionParser.g:4039:1: rule__Group__NamedAssignment_1_2_0 : ( ( LeftParenthesisQuestionMarkLessThanSign ) ) ;
    public final void rule__Group__NamedAssignment_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4043:1: ( ( ( LeftParenthesisQuestionMarkLessThanSign ) ) )
            // InternalRegularExpressionParser.g:4044:2: ( ( LeftParenthesisQuestionMarkLessThanSign ) )
            {
            // InternalRegularExpressionParser.g:4044:2: ( ( LeftParenthesisQuestionMarkLessThanSign ) )
            // InternalRegularExpressionParser.g:4045:3: ( LeftParenthesisQuestionMarkLessThanSign )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getNamedLeftParenthesisQuestionMarkLessThanSignKeyword_1_2_0_0()); 
            }
            // InternalRegularExpressionParser.g:4046:3: ( LeftParenthesisQuestionMarkLessThanSign )
            // InternalRegularExpressionParser.g:4047:4: LeftParenthesisQuestionMarkLessThanSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getNamedLeftParenthesisQuestionMarkLessThanSignKeyword_1_2_0_0()); 
            }
            match(input,LeftParenthesisQuestionMarkLessThanSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getNamedLeftParenthesisQuestionMarkLessThanSignKeyword_1_2_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getNamedLeftParenthesisQuestionMarkLessThanSignKeyword_1_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__NamedAssignment_1_2_0"


    // $ANTLR start "rule__Group__NameAssignment_1_2_1"
    // InternalRegularExpressionParser.g:4058:1: rule__Group__NameAssignment_1_2_1 : ( ruleRegExpIdentifierName ) ;
    public final void rule__Group__NameAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4062:1: ( ( ruleRegExpIdentifierName ) )
            // InternalRegularExpressionParser.g:4063:2: ( ruleRegExpIdentifierName )
            {
            // InternalRegularExpressionParser.g:4063:2: ( ruleRegExpIdentifierName )
            // InternalRegularExpressionParser.g:4064:3: ruleRegExpIdentifierName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getNameRegExpIdentifierNameParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRegExpIdentifierName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getNameRegExpIdentifierNameParserRuleCall_1_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__NameAssignment_1_2_1"


    // $ANTLR start "rule__Group__PatternAssignment_2"
    // InternalRegularExpressionParser.g:4073:1: rule__Group__PatternAssignment_2 : ( ruleDisjunction ) ;
    public final void rule__Group__PatternAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4077:1: ( ( ruleDisjunction ) )
            // InternalRegularExpressionParser.g:4078:2: ( ruleDisjunction )
            {
            // InternalRegularExpressionParser.g:4078:2: ( ruleDisjunction )
            // InternalRegularExpressionParser.g:4079:3: ruleDisjunction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupAccess().getPatternDisjunctionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDisjunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupAccess().getPatternDisjunctionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__PatternAssignment_2"


    // $ANTLR start "rule__SimpleQuantifier__QuantifierAssignment_0"
    // InternalRegularExpressionParser.g:4088:1: rule__SimpleQuantifier__QuantifierAssignment_0 : ( ( rule__SimpleQuantifier__QuantifierAlternatives_0_0 ) ) ;
    public final void rule__SimpleQuantifier__QuantifierAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4092:1: ( ( ( rule__SimpleQuantifier__QuantifierAlternatives_0_0 ) ) )
            // InternalRegularExpressionParser.g:4093:2: ( ( rule__SimpleQuantifier__QuantifierAlternatives_0_0 ) )
            {
            // InternalRegularExpressionParser.g:4093:2: ( ( rule__SimpleQuantifier__QuantifierAlternatives_0_0 ) )
            // InternalRegularExpressionParser.g:4094:3: ( rule__SimpleQuantifier__QuantifierAlternatives_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleQuantifierAccess().getQuantifierAlternatives_0_0()); 
            }
            // InternalRegularExpressionParser.g:4095:3: ( rule__SimpleQuantifier__QuantifierAlternatives_0_0 )
            // InternalRegularExpressionParser.g:4095:4: rule__SimpleQuantifier__QuantifierAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleQuantifier__QuantifierAlternatives_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleQuantifierAccess().getQuantifierAlternatives_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleQuantifier__QuantifierAssignment_0"


    // $ANTLR start "rule__SimpleQuantifier__NonGreedyAssignment_1"
    // InternalRegularExpressionParser.g:4103:1: rule__SimpleQuantifier__NonGreedyAssignment_1 : ( ( QuestionMark ) ) ;
    public final void rule__SimpleQuantifier__NonGreedyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4107:1: ( ( ( QuestionMark ) ) )
            // InternalRegularExpressionParser.g:4108:2: ( ( QuestionMark ) )
            {
            // InternalRegularExpressionParser.g:4108:2: ( ( QuestionMark ) )
            // InternalRegularExpressionParser.g:4109:3: ( QuestionMark )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleQuantifierAccess().getNonGreedyQuestionMarkKeyword_1_0()); 
            }
            // InternalRegularExpressionParser.g:4110:3: ( QuestionMark )
            // InternalRegularExpressionParser.g:4111:4: QuestionMark
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleQuantifierAccess().getNonGreedyQuestionMarkKeyword_1_0()); 
            }
            match(input,QuestionMark,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleQuantifierAccess().getNonGreedyQuestionMarkKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleQuantifierAccess().getNonGreedyQuestionMarkKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleQuantifier__NonGreedyAssignment_1"


    // $ANTLR start "rule__ExactQuantifier__MinAssignment_2"
    // InternalRegularExpressionParser.g:4122:1: rule__ExactQuantifier__MinAssignment_2 : ( ruleINT ) ;
    public final void rule__ExactQuantifier__MinAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4126:1: ( ( ruleINT ) )
            // InternalRegularExpressionParser.g:4127:2: ( ruleINT )
            {
            // InternalRegularExpressionParser.g:4127:2: ( ruleINT )
            // InternalRegularExpressionParser.g:4128:3: ruleINT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getMinINTParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getMinINTParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__MinAssignment_2"


    // $ANTLR start "rule__ExactQuantifier__MaxAssignment_3_0_1"
    // InternalRegularExpressionParser.g:4137:1: rule__ExactQuantifier__MaxAssignment_3_0_1 : ( ruleINT ) ;
    public final void rule__ExactQuantifier__MaxAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4141:1: ( ( ruleINT ) )
            // InternalRegularExpressionParser.g:4142:2: ( ruleINT )
            {
            // InternalRegularExpressionParser.g:4142:2: ( ruleINT )
            // InternalRegularExpressionParser.g:4143:3: ruleINT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getMaxINTParserRuleCall_3_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getMaxINTParserRuleCall_3_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__MaxAssignment_3_0_1"


    // $ANTLR start "rule__ExactQuantifier__UnboundedMaxAssignment_3_1"
    // InternalRegularExpressionParser.g:4152:1: rule__ExactQuantifier__UnboundedMaxAssignment_3_1 : ( ( Comma ) ) ;
    public final void rule__ExactQuantifier__UnboundedMaxAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4156:1: ( ( ( Comma ) ) )
            // InternalRegularExpressionParser.g:4157:2: ( ( Comma ) )
            {
            // InternalRegularExpressionParser.g:4157:2: ( ( Comma ) )
            // InternalRegularExpressionParser.g:4158:3: ( Comma )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getUnboundedMaxCommaKeyword_3_1_0()); 
            }
            // InternalRegularExpressionParser.g:4159:3: ( Comma )
            // InternalRegularExpressionParser.g:4160:4: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getUnboundedMaxCommaKeyword_3_1_0()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getUnboundedMaxCommaKeyword_3_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getUnboundedMaxCommaKeyword_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__UnboundedMaxAssignment_3_1"


    // $ANTLR start "rule__ExactQuantifier__NonGreedyAssignment_5"
    // InternalRegularExpressionParser.g:4171:1: rule__ExactQuantifier__NonGreedyAssignment_5 : ( ( QuestionMark ) ) ;
    public final void rule__ExactQuantifier__NonGreedyAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4175:1: ( ( ( QuestionMark ) ) )
            // InternalRegularExpressionParser.g:4176:2: ( ( QuestionMark ) )
            {
            // InternalRegularExpressionParser.g:4176:2: ( ( QuestionMark ) )
            // InternalRegularExpressionParser.g:4177:3: ( QuestionMark )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getNonGreedyQuestionMarkKeyword_5_0()); 
            }
            // InternalRegularExpressionParser.g:4178:3: ( QuestionMark )
            // InternalRegularExpressionParser.g:4179:4: QuestionMark
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExactQuantifierAccess().getNonGreedyQuestionMarkKeyword_5_0()); 
            }
            match(input,QuestionMark,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getNonGreedyQuestionMarkKeyword_5_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExactQuantifierAccess().getNonGreedyQuestionMarkKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExactQuantifier__NonGreedyAssignment_5"


    // $ANTLR start "rule__RegularExpressionFlags__FlagsAssignment_1"
    // InternalRegularExpressionParser.g:4190:1: rule__RegularExpressionFlags__FlagsAssignment_1 : ( ( rule__RegularExpressionFlags__FlagsAlternatives_1_0 ) ) ;
    public final void rule__RegularExpressionFlags__FlagsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRegularExpressionParser.g:4194:1: ( ( ( rule__RegularExpressionFlags__FlagsAlternatives_1_0 ) ) )
            // InternalRegularExpressionParser.g:4195:2: ( ( rule__RegularExpressionFlags__FlagsAlternatives_1_0 ) )
            {
            // InternalRegularExpressionParser.g:4195:2: ( ( rule__RegularExpressionFlags__FlagsAlternatives_1_0 ) )
            // InternalRegularExpressionParser.g:4196:3: ( rule__RegularExpressionFlags__FlagsAlternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRegularExpressionFlagsAccess().getFlagsAlternatives_1_0()); 
            }
            // InternalRegularExpressionParser.g:4197:3: ( rule__RegularExpressionFlags__FlagsAlternatives_1_0 )
            // InternalRegularExpressionParser.g:4197:4: rule__RegularExpressionFlags__FlagsAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__RegularExpressionFlags__FlagsAlternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRegularExpressionFlagsAccess().getFlagsAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegularExpressionFlags__FlagsAssignment_1"

    // $ANTLR start synpred90_InternalRegularExpressionParser
    public final void synpred90_InternalRegularExpressionParser_fragment() throws RecognitionException {   
        // InternalRegularExpressionParser.g:2304:3: ( rule__Term__QuantifierAssignment_1_1 )
        // InternalRegularExpressionParser.g:2304:3: rule__Term__QuantifierAssignment_1_1
        {
        pushFollow(FOLLOW_2);
        rule__Term__QuantifierAssignment_1_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_InternalRegularExpressionParser

    // $ANTLR start synpred91_InternalRegularExpressionParser
    public final void synpred91_InternalRegularExpressionParser_fragment() throws RecognitionException {   
        // InternalRegularExpressionParser.g:2791:3: ( rule__CharacterClass__Group_2__0 )
        // InternalRegularExpressionParser.g:2791:3: rule__CharacterClass__Group_2__0
        {
        pushFollow(FOLLOW_2);
        rule__CharacterClass__Group_2__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred91_InternalRegularExpressionParser

    // $ANTLR start synpred93_InternalRegularExpressionParser
    public final void synpred93_InternalRegularExpressionParser_fragment() throws RecognitionException {   
        // InternalRegularExpressionParser.g:2925:3: ( rule__CharacterClassElement__Group_1__0 )
        // InternalRegularExpressionParser.g:2925:3: rule__CharacterClassElement__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__CharacterClassElement__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred93_InternalRegularExpressionParser

    // Delegated rules

    public final boolean synpred90_InternalRegularExpressionParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_InternalRegularExpressionParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalRegularExpressionParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalRegularExpressionParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_InternalRegularExpressionParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_InternalRegularExpressionParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA29 dfa29 = new DFA29(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\3\1\uffff\1\3\1\uffff\3\3\1\uffff\2\3";
    static final String dfa_3s = "\1\4\1\uffff\1\4\1\uffff\3\4\1\0\2\4";
    static final String dfa_4s = "\1\60\1\uffff\1\60\1\uffff\3\60\1\0\2\60";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\2\6\uffff";
    static final String dfa_6s = "\7\uffff\1\0\2\uffff}>";
    static final String[] dfa_7s = {
            "\6\3\1\uffff\4\3\2\1\10\3\1\1\3\3\1\uffff\1\2\7\3\1\uffff\2\3\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3",
            "",
            "\6\3\1\uffff\22\3\1\uffff\10\3\1\uffff\2\3\1\uffff\2\3\1\uffff\1\4\1\uffff\2\3",
            "",
            "\6\3\1\uffff\6\3\1\6\13\3\1\uffff\2\3\1\7\5\3\1\uffff\2\3\1\uffff\2\3\1\uffff\1\5\1\uffff\2\3",
            "\6\3\1\uffff\6\3\1\6\13\3\1\uffff\2\3\1\7\5\3\1\uffff\2\3\1\uffff\2\3\1\uffff\1\5\1\uffff\2\3",
            "\6\3\1\uffff\22\3\1\uffff\2\3\1\7\5\3\1\uffff\2\3\1\uffff\2\3\1\uffff\1\10\1\uffff\2\3",
            "\1\uffff",
            "\6\3\1\uffff\22\3\1\uffff\2\3\1\7\5\3\1\uffff\2\3\1\uffff\2\3\1\uffff\1\11\1\uffff\2\3",
            "\6\3\1\uffff\22\3\1\uffff\2\3\1\7\5\3\1\uffff\2\3\1\uffff\2\3\1\uffff\1\11\1\uffff\2\3"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2304:2: ( rule__Term__QuantifierAssignment_1_1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_7 = input.LA(1);

                         
                        int index29_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalRegularExpressionParser()) ) {s = 1;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index29_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\51\uffff";
    static final String dfa_9s = "\1\2\50\uffff";
    static final String dfa_10s = "\2\4\1\uffff\45\0\1\uffff";
    static final String dfa_11s = "\2\60\1\uffff\45\0\1\uffff";
    static final String dfa_12s = "\2\uffff\1\2\45\uffff\1\1";
    static final String dfa_13s = "\3\uffff\1\2\1\16\1\37\1\31\1\12\1\24\1\5\1\43\1\0\1\32\1\6\1\14\1\40\1\20\1\41\1\3\1\22\1\10\1\26\1\35\1\13\1\44\1\17\1\25\1\1\1\33\1\7\1\15\1\34\1\21\1\42\1\4\1\23\1\11\1\27\1\36\1\30\1\uffff}>";
    static final String[] dfa_14s = {
            "\3\2\1\uffff\12\2\1\1\12\2\1\uffff\4\2\1\uffff\3\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2",
            "\1\43\1\44\1\42\1\uffff\1\40\1\41\1\37\1\16\1\21\1\26\1\27\1\23\1\24\1\13\1\17\1\22\1\34\1\15\1\35\1\14\1\36\1\25\1\30\1\2\1\20\1\uffff\1\31\1\33\1\32\1\4\1\uffff\1\12\1\5\1\6\1\uffff\1\7\1\10\1\uffff\1\3\1\11\1\uffff\1\47\1\uffff\1\46\1\45",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2925:2: ( rule__CharacterClassElement__Group_1__0 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_11 = input.LA(1);

                         
                        int index32_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_27 = input.LA(1);

                         
                        int index32_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_27);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_18 = input.LA(1);

                         
                        int index32_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_18);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_34 = input.LA(1);

                         
                        int index32_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_34);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_9 = input.LA(1);

                         
                        int index32_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_13 = input.LA(1);

                         
                        int index32_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_13);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_29 = input.LA(1);

                         
                        int index32_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_29);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_20 = input.LA(1);

                         
                        int index32_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_20);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA32_36 = input.LA(1);

                         
                        int index32_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_36);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA32_23 = input.LA(1);

                         
                        int index32_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_23);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA32_14 = input.LA(1);

                         
                        int index32_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_14);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA32_30 = input.LA(1);

                         
                        int index32_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_30);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_4);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA32_25 = input.LA(1);

                         
                        int index32_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_25);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA32_16 = input.LA(1);

                         
                        int index32_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_16);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA32_32 = input.LA(1);

                         
                        int index32_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_32);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA32_19 = input.LA(1);

                         
                        int index32_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA32_35 = input.LA(1);

                         
                        int index32_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_35);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA32_8 = input.LA(1);

                         
                        int index32_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_8);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA32_26 = input.LA(1);

                         
                        int index32_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_26);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA32_21 = input.LA(1);

                         
                        int index32_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_21);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA32_37 = input.LA(1);

                         
                        int index32_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_37);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA32_39 = input.LA(1);

                         
                        int index32_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_39);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA32_12 = input.LA(1);

                         
                        int index32_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_12);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA32_28 = input.LA(1);

                         
                        int index32_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA32_31 = input.LA(1);

                         
                        int index32_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_31);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA32_22 = input.LA(1);

                         
                        int index32_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_22);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA32_38 = input.LA(1);

                         
                        int index32_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_38);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA32_15 = input.LA(1);

                         
                        int index32_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_15);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA32_17 = input.LA(1);

                         
                        int index32_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_17);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA32_33 = input.LA(1);

                         
                        int index32_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_33);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA32_10 = input.LA(1);

                         
                        int index32_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_10);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA32_24 = input.LA(1);

                         
                        int index32_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalRegularExpressionParser()) ) {s = 40;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_24);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0001ADBFDDEE3BF0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000810000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0001ADBF5DEE3BF0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0001ADBF5DEE3BF2L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000042018000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000610001270L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0001ADBBDFFFFF70L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0001ADBBD7FFFF72L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0001ADBBD7FFFF70L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000810020001000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000A10020001000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000A10020001002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100020000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000810000000002L});

}