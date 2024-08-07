package org.eclipse.n4js.json.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.n4js.json.services.JSONGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
public class InternalJSONParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_NUMBER", "RULE_DOUBLE", "RULE_INT", "RULE_DOUBLE_STRING_CHAR", "RULE_LINE_TERMINATOR_FRAGMENT", "RULE_LINE_TERMINATOR_SEQUENCE_FRAGMENT", "RULE_DECIMAL_INTEGER_LITERAL_FRAGMENT", "RULE_DECIMAL_DIGIT_FRAGMENT", "RULE_EXPONENT_PART", "RULE_SIGNED_INT", "RULE_ML_COMMENT_FRAGMENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WHITESPACE_FRAGMENT", "RULE_WS", "RULE_EOL", "RULE_HEX_DIGIT", "RULE_ZWJ", "RULE_ZWNJ", "RULE_BOM", "RULE_UNICODE_SPACE_SEPARATOR_FRAGMENT", "RULE_SL_COMMENT_FRAGMENT", "RULE_UNICODE_COMBINING_MARK_FRAGMENT", "RULE_UNICODE_DIGIT_FRAGMENT", "RULE_UNICODE_CONNECTOR_PUNCTUATION_FRAGMENT", "RULE_UNICODE_LETTER_FRAGMENT", "RULE_ANY_OTHER", "'{'", "','", "'}'", "':'", "'['", "']'", "'true'", "'false'", "'null'"
    };
    public static final int RULE_ML_COMMENT_FRAGMENT=15;
    public static final int RULE_STRING=4;
    public static final int RULE_EXPONENT_PART=13;
    public static final int RULE_SL_COMMENT=17;
    public static final int RULE_ZWJ=22;
    public static final int RULE_SL_COMMENT_FRAGMENT=26;
    public static final int RULE_WHITESPACE_FRAGMENT=18;
    public static final int RULE_UNICODE_DIGIT_FRAGMENT=28;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=6;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int RULE_UNICODE_SPACE_SEPARATOR_FRAGMENT=25;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__32=32;
    public static final int RULE_LINE_TERMINATOR_SEQUENCE_FRAGMENT=10;
    public static final int RULE_WS=19;
    public static final int RULE_EOL=20;
    public static final int RULE_BOM=24;
    public static final int RULE_SIGNED_INT=14;
    public static final int RULE_UNICODE_COMBINING_MARK_FRAGMENT=27;
    public static final int RULE_ANY_OTHER=31;
    public static final int RULE_DOUBLE_STRING_CHAR=8;
    public static final int RULE_NUMBER=5;
    public static final int RULE_LINE_TERMINATOR_FRAGMENT=9;
    public static final int RULE_ZWNJ=23;
    public static final int RULE_UNICODE_LETTER_FRAGMENT=30;
    public static final int RULE_DECIMAL_DIGIT_FRAGMENT=12;
    public static final int RULE_INT=7;
    public static final int RULE_ML_COMMENT=16;
    public static final int RULE_DECIMAL_INTEGER_LITERAL_FRAGMENT=11;
    public static final int RULE_HEX_DIGIT=21;
    public static final int RULE_UNICODE_CONNECTOR_PUNCTUATION_FRAGMENT=29;
    public static final int T__40=40;

    // delegates
    // delegators


        public InternalJSONParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalJSONParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalJSONParser.tokenNames; }
    public String getGrammarFileName() { return "InternalJSON.g"; }



     	private JSONGrammarAccess grammarAccess;

        public InternalJSONParser(TokenStream input, JSONGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "JSONDocument";
       	}

       	@Override
       	protected JSONGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleJSONDocument"
    // InternalJSON.g:71:1: entryRuleJSONDocument returns [EObject current=null] : iv_ruleJSONDocument= ruleJSONDocument EOF ;
    public final EObject entryRuleJSONDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONDocument = null;


        try {
            // InternalJSON.g:71:53: (iv_ruleJSONDocument= ruleJSONDocument EOF )
            // InternalJSON.g:72:2: iv_ruleJSONDocument= ruleJSONDocument EOF
            {
             newCompositeNode(grammarAccess.getJSONDocumentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONDocument=ruleJSONDocument();

            state._fsp--;

             current =iv_ruleJSONDocument; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONDocument"


    // $ANTLR start "ruleJSONDocument"
    // InternalJSON.g:78:1: ruleJSONDocument returns [EObject current=null] : ( () ( (lv_content_1_0= ruleJSONValue ) )? ) ;
    public final EObject ruleJSONDocument() throws RecognitionException {
        EObject current = null;

        EObject lv_content_1_0 = null;



        	enterRule();

        try {
            // InternalJSON.g:84:2: ( ( () ( (lv_content_1_0= ruleJSONValue ) )? ) )
            // InternalJSON.g:85:2: ( () ( (lv_content_1_0= ruleJSONValue ) )? )
            {
            // InternalJSON.g:85:2: ( () ( (lv_content_1_0= ruleJSONValue ) )? )
            // InternalJSON.g:86:3: () ( (lv_content_1_0= ruleJSONValue ) )?
            {
            // InternalJSON.g:86:3: ()
            // InternalJSON.g:87:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONDocumentAccess().getJSONDocumentAction_0(),
            					current);
            			

            }

            // InternalJSON.g:93:3: ( (lv_content_1_0= ruleJSONValue ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_NUMBER)||LA1_0==32||LA1_0==36||(LA1_0>=38 && LA1_0<=40)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalJSON.g:94:4: (lv_content_1_0= ruleJSONValue )
                    {
                    // InternalJSON.g:94:4: (lv_content_1_0= ruleJSONValue )
                    // InternalJSON.g:95:5: lv_content_1_0= ruleJSONValue
                    {

                    					newCompositeNode(grammarAccess.getJSONDocumentAccess().getContentJSONValueParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_content_1_0=ruleJSONValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJSONDocumentRule());
                    					}
                    					set(
                    						current,
                    						"content",
                    						lv_content_1_0,
                    						"org.eclipse.n4js.json.JSON.JSONValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONDocument"


    // $ANTLR start "entryRuleJSONObject"
    // InternalJSON.g:116:1: entryRuleJSONObject returns [EObject current=null] : iv_ruleJSONObject= ruleJSONObject EOF ;
    public final EObject entryRuleJSONObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONObject = null;


        try {
            // InternalJSON.g:116:51: (iv_ruleJSONObject= ruleJSONObject EOF )
            // InternalJSON.g:117:2: iv_ruleJSONObject= ruleJSONObject EOF
            {
             newCompositeNode(grammarAccess.getJSONObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONObject=ruleJSONObject();

            state._fsp--;

             current =iv_ruleJSONObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONObject"


    // $ANTLR start "ruleJSONObject"
    // InternalJSON.g:123:1: ruleJSONObject returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_nameValuePairs_2_0= ruleNameValuePair ) ) (otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) ) )* )? (otherlv_5= ',' )? otherlv_6= '}' ) ;
    public final EObject ruleJSONObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_nameValuePairs_2_0 = null;

        EObject lv_nameValuePairs_4_0 = null;



        	enterRule();

        try {
            // InternalJSON.g:129:2: ( ( () otherlv_1= '{' ( ( (lv_nameValuePairs_2_0= ruleNameValuePair ) ) (otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) ) )* )? (otherlv_5= ',' )? otherlv_6= '}' ) )
            // InternalJSON.g:130:2: ( () otherlv_1= '{' ( ( (lv_nameValuePairs_2_0= ruleNameValuePair ) ) (otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) ) )* )? (otherlv_5= ',' )? otherlv_6= '}' )
            {
            // InternalJSON.g:130:2: ( () otherlv_1= '{' ( ( (lv_nameValuePairs_2_0= ruleNameValuePair ) ) (otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) ) )* )? (otherlv_5= ',' )? otherlv_6= '}' )
            // InternalJSON.g:131:3: () otherlv_1= '{' ( ( (lv_nameValuePairs_2_0= ruleNameValuePair ) ) (otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) ) )* )? (otherlv_5= ',' )? otherlv_6= '}'
            {
            // InternalJSON.g:131:3: ()
            // InternalJSON.g:132:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONObjectAccess().getJSONObjectAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getJSONObjectAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalJSON.g:142:3: ( ( (lv_nameValuePairs_2_0= ruleNameValuePair ) ) (otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalJSON.g:143:4: ( (lv_nameValuePairs_2_0= ruleNameValuePair ) ) (otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) ) )*
                    {
                    // InternalJSON.g:143:4: ( (lv_nameValuePairs_2_0= ruleNameValuePair ) )
                    // InternalJSON.g:144:5: (lv_nameValuePairs_2_0= ruleNameValuePair )
                    {
                    // InternalJSON.g:144:5: (lv_nameValuePairs_2_0= ruleNameValuePair )
                    // InternalJSON.g:145:6: lv_nameValuePairs_2_0= ruleNameValuePair
                    {

                    						newCompositeNode(grammarAccess.getJSONObjectAccess().getNameValuePairsNameValuePairParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_nameValuePairs_2_0=ruleNameValuePair();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJSONObjectRule());
                    						}
                    						add(
                    							current,
                    							"nameValuePairs",
                    							lv_nameValuePairs_2_0,
                    							"org.eclipse.n4js.json.JSON.NameValuePair");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalJSON.g:162:4: (otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==33) ) {
                            int LA2_1 = input.LA(2);

                            if ( (LA2_1==RULE_STRING) ) {
                                alt2=1;
                            }


                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalJSON.g:163:5: otherlv_3= ',' ( (lv_nameValuePairs_4_0= ruleNameValuePair ) )
                    	    {
                    	    otherlv_3=(Token)match(input,33,FOLLOW_5); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getJSONObjectAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalJSON.g:167:5: ( (lv_nameValuePairs_4_0= ruleNameValuePair ) )
                    	    // InternalJSON.g:168:6: (lv_nameValuePairs_4_0= ruleNameValuePair )
                    	    {
                    	    // InternalJSON.g:168:6: (lv_nameValuePairs_4_0= ruleNameValuePair )
                    	    // InternalJSON.g:169:7: lv_nameValuePairs_4_0= ruleNameValuePair
                    	    {

                    	    							newCompositeNode(grammarAccess.getJSONObjectAccess().getNameValuePairsNameValuePairParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_nameValuePairs_4_0=ruleNameValuePair();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getJSONObjectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"nameValuePairs",
                    	    								lv_nameValuePairs_4_0,
                    	    								"org.eclipse.n4js.json.JSON.NameValuePair");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalJSON.g:188:3: (otherlv_5= ',' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==33) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalJSON.g:189:4: otherlv_5= ','
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getJSONObjectAccess().getCommaKeyword_3());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getJSONObjectAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONObject"


    // $ANTLR start "entryRuleNameValuePair"
    // InternalJSON.g:202:1: entryRuleNameValuePair returns [EObject current=null] : iv_ruleNameValuePair= ruleNameValuePair EOF ;
    public final EObject entryRuleNameValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameValuePair = null;


        try {
            // InternalJSON.g:202:54: (iv_ruleNameValuePair= ruleNameValuePair EOF )
            // InternalJSON.g:203:2: iv_ruleNameValuePair= ruleNameValuePair EOF
            {
             newCompositeNode(grammarAccess.getNameValuePairRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNameValuePair=ruleNameValuePair();

            state._fsp--;

             current =iv_ruleNameValuePair; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNameValuePair"


    // $ANTLR start "ruleNameValuePair"
    // InternalJSON.g:209:1: ruleNameValuePair returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) ) ) ;
    public final EObject ruleNameValuePair() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalJSON.g:215:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) ) ) )
            // InternalJSON.g:216:2: ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) ) )
            {
            // InternalJSON.g:216:2: ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) ) )
            // InternalJSON.g:217:3: ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) )
            {
            // InternalJSON.g:217:3: ( (lv_name_0_0= RULE_STRING ) )
            // InternalJSON.g:218:4: (lv_name_0_0= RULE_STRING )
            {
            // InternalJSON.g:218:4: (lv_name_0_0= RULE_STRING )
            // InternalJSON.g:219:5: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_name_0_0, grammarAccess.getNameValuePairAccess().getNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNameValuePairRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.n4js.json.JSON.STRING");
            				

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getNameValuePairAccess().getColonKeyword_1());
            		
            // InternalJSON.g:239:3: ( (lv_value_2_0= ruleJSONValue ) )
            // InternalJSON.g:240:4: (lv_value_2_0= ruleJSONValue )
            {
            // InternalJSON.g:240:4: (lv_value_2_0= ruleJSONValue )
            // InternalJSON.g:241:5: lv_value_2_0= ruleJSONValue
            {

            					newCompositeNode(grammarAccess.getNameValuePairAccess().getValueJSONValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleJSONValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNameValuePairRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.n4js.json.JSON.JSONValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNameValuePair"


    // $ANTLR start "entryRuleJSONArray"
    // InternalJSON.g:262:1: entryRuleJSONArray returns [EObject current=null] : iv_ruleJSONArray= ruleJSONArray EOF ;
    public final EObject entryRuleJSONArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONArray = null;


        try {
            // InternalJSON.g:262:50: (iv_ruleJSONArray= ruleJSONArray EOF )
            // InternalJSON.g:263:2: iv_ruleJSONArray= ruleJSONArray EOF
            {
             newCompositeNode(grammarAccess.getJSONArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONArray=ruleJSONArray();

            state._fsp--;

             current =iv_ruleJSONArray; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONArray"


    // $ANTLR start "ruleJSONArray"
    // InternalJSON.g:269:1: ruleJSONArray returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) ) )* )? (otherlv_5= ',' )? otherlv_6= ']' ) ;
    public final EObject ruleJSONArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_elements_2_0 = null;

        EObject lv_elements_4_0 = null;



        	enterRule();

        try {
            // InternalJSON.g:275:2: ( ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) ) )* )? (otherlv_5= ',' )? otherlv_6= ']' ) )
            // InternalJSON.g:276:2: ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) ) )* )? (otherlv_5= ',' )? otherlv_6= ']' )
            {
            // InternalJSON.g:276:2: ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) ) )* )? (otherlv_5= ',' )? otherlv_6= ']' )
            // InternalJSON.g:277:3: () otherlv_1= '[' ( ( (lv_elements_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) ) )* )? (otherlv_5= ',' )? otherlv_6= ']'
            {
            // InternalJSON.g:277:3: ()
            // InternalJSON.g:278:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONArrayAccess().getJSONArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,36,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getJSONArrayAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalJSON.g:288:3: ( ( (lv_elements_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_NUMBER)||LA6_0==32||LA6_0==36||(LA6_0>=38 && LA6_0<=40)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalJSON.g:289:4: ( (lv_elements_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) ) )*
                    {
                    // InternalJSON.g:289:4: ( (lv_elements_2_0= ruleJSONValue ) )
                    // InternalJSON.g:290:5: (lv_elements_2_0= ruleJSONValue )
                    {
                    // InternalJSON.g:290:5: (lv_elements_2_0= ruleJSONValue )
                    // InternalJSON.g:291:6: lv_elements_2_0= ruleJSONValue
                    {

                    						newCompositeNode(grammarAccess.getJSONArrayAccess().getElementsJSONValueParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_elements_2_0=ruleJSONValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJSONArrayRule());
                    						}
                    						add(
                    							current,
                    							"elements",
                    							lv_elements_2_0,
                    							"org.eclipse.n4js.json.JSON.JSONValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalJSON.g:308:4: (otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==33) ) {
                            int LA5_1 = input.LA(2);

                            if ( ((LA5_1>=RULE_STRING && LA5_1<=RULE_NUMBER)||LA5_1==32||LA5_1==36||(LA5_1>=38 && LA5_1<=40)) ) {
                                alt5=1;
                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalJSON.g:309:5: otherlv_3= ',' ( (lv_elements_4_0= ruleJSONValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,33,FOLLOW_8); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getJSONArrayAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalJSON.g:313:5: ( (lv_elements_4_0= ruleJSONValue ) )
                    	    // InternalJSON.g:314:6: (lv_elements_4_0= ruleJSONValue )
                    	    {
                    	    // InternalJSON.g:314:6: (lv_elements_4_0= ruleJSONValue )
                    	    // InternalJSON.g:315:7: lv_elements_4_0= ruleJSONValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getJSONArrayAccess().getElementsJSONValueParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_elements_4_0=ruleJSONValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getJSONArrayRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_4_0,
                    	    								"org.eclipse.n4js.json.JSON.JSONValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalJSON.g:334:3: (otherlv_5= ',' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==33) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalJSON.g:335:4: otherlv_5= ','
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_11); 

                    				newLeafNode(otherlv_5, grammarAccess.getJSONArrayAccess().getCommaKeyword_3());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getJSONArrayAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONArray"


    // $ANTLR start "entryRuleJSONValue"
    // InternalJSON.g:348:1: entryRuleJSONValue returns [EObject current=null] : iv_ruleJSONValue= ruleJSONValue EOF ;
    public final EObject entryRuleJSONValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONValue = null;


        try {
            // InternalJSON.g:348:50: (iv_ruleJSONValue= ruleJSONValue EOF )
            // InternalJSON.g:349:2: iv_ruleJSONValue= ruleJSONValue EOF
            {
             newCompositeNode(grammarAccess.getJSONValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONValue=ruleJSONValue();

            state._fsp--;

             current =iv_ruleJSONValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONValue"


    // $ANTLR start "ruleJSONValue"
    // InternalJSON.g:355:1: ruleJSONValue returns [EObject current=null] : (this_JSONObject_0= ruleJSONObject | this_JSONArray_1= ruleJSONArray | this_JSONStringLiteral_2= ruleJSONStringLiteral | this_JSONNumericLiteral_3= ruleJSONNumericLiteral | this_JSONNullLiteral_4= ruleJSONNullLiteral | this_JSONBooleanLiteral_5= ruleJSONBooleanLiteral ) ;
    public final EObject ruleJSONValue() throws RecognitionException {
        EObject current = null;

        EObject this_JSONObject_0 = null;

        EObject this_JSONArray_1 = null;

        EObject this_JSONStringLiteral_2 = null;

        EObject this_JSONNumericLiteral_3 = null;

        EObject this_JSONNullLiteral_4 = null;

        EObject this_JSONBooleanLiteral_5 = null;



        	enterRule();

        try {
            // InternalJSON.g:361:2: ( (this_JSONObject_0= ruleJSONObject | this_JSONArray_1= ruleJSONArray | this_JSONStringLiteral_2= ruleJSONStringLiteral | this_JSONNumericLiteral_3= ruleJSONNumericLiteral | this_JSONNullLiteral_4= ruleJSONNullLiteral | this_JSONBooleanLiteral_5= ruleJSONBooleanLiteral ) )
            // InternalJSON.g:362:2: (this_JSONObject_0= ruleJSONObject | this_JSONArray_1= ruleJSONArray | this_JSONStringLiteral_2= ruleJSONStringLiteral | this_JSONNumericLiteral_3= ruleJSONNumericLiteral | this_JSONNullLiteral_4= ruleJSONNullLiteral | this_JSONBooleanLiteral_5= ruleJSONBooleanLiteral )
            {
            // InternalJSON.g:362:2: (this_JSONObject_0= ruleJSONObject | this_JSONArray_1= ruleJSONArray | this_JSONStringLiteral_2= ruleJSONStringLiteral | this_JSONNumericLiteral_3= ruleJSONNumericLiteral | this_JSONNullLiteral_4= ruleJSONNullLiteral | this_JSONBooleanLiteral_5= ruleJSONBooleanLiteral )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt8=1;
                }
                break;
            case 36:
                {
                alt8=2;
                }
                break;
            case RULE_STRING:
                {
                alt8=3;
                }
                break;
            case RULE_NUMBER:
                {
                alt8=4;
                }
                break;
            case 40:
                {
                alt8=5;
                }
                break;
            case 38:
            case 39:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalJSON.g:363:3: this_JSONObject_0= ruleJSONObject
                    {

                    			newCompositeNode(grammarAccess.getJSONValueAccess().getJSONObjectParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_JSONObject_0=ruleJSONObject();

                    state._fsp--;


                    			current = this_JSONObject_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJSON.g:372:3: this_JSONArray_1= ruleJSONArray
                    {

                    			newCompositeNode(grammarAccess.getJSONValueAccess().getJSONArrayParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_JSONArray_1=ruleJSONArray();

                    state._fsp--;


                    			current = this_JSONArray_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJSON.g:381:3: this_JSONStringLiteral_2= ruleJSONStringLiteral
                    {

                    			newCompositeNode(grammarAccess.getJSONValueAccess().getJSONStringLiteralParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_JSONStringLiteral_2=ruleJSONStringLiteral();

                    state._fsp--;


                    			current = this_JSONStringLiteral_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalJSON.g:390:3: this_JSONNumericLiteral_3= ruleJSONNumericLiteral
                    {

                    			newCompositeNode(grammarAccess.getJSONValueAccess().getJSONNumericLiteralParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_JSONNumericLiteral_3=ruleJSONNumericLiteral();

                    state._fsp--;


                    			current = this_JSONNumericLiteral_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalJSON.g:399:3: this_JSONNullLiteral_4= ruleJSONNullLiteral
                    {

                    			newCompositeNode(grammarAccess.getJSONValueAccess().getJSONNullLiteralParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_JSONNullLiteral_4=ruleJSONNullLiteral();

                    state._fsp--;


                    			current = this_JSONNullLiteral_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalJSON.g:408:3: this_JSONBooleanLiteral_5= ruleJSONBooleanLiteral
                    {

                    			newCompositeNode(grammarAccess.getJSONValueAccess().getJSONBooleanLiteralParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_JSONBooleanLiteral_5=ruleJSONBooleanLiteral();

                    state._fsp--;


                    			current = this_JSONBooleanLiteral_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONValue"


    // $ANTLR start "entryRuleJSONStringLiteral"
    // InternalJSON.g:420:1: entryRuleJSONStringLiteral returns [EObject current=null] : iv_ruleJSONStringLiteral= ruleJSONStringLiteral EOF ;
    public final EObject entryRuleJSONStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONStringLiteral = null;


        try {
            // InternalJSON.g:420:58: (iv_ruleJSONStringLiteral= ruleJSONStringLiteral EOF )
            // InternalJSON.g:421:2: iv_ruleJSONStringLiteral= ruleJSONStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getJSONStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONStringLiteral=ruleJSONStringLiteral();

            state._fsp--;

             current =iv_ruleJSONStringLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONStringLiteral"


    // $ANTLR start "ruleJSONStringLiteral"
    // InternalJSON.g:427:1: ruleJSONStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleJSONStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalJSON.g:433:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalJSON.g:434:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalJSON.g:434:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalJSON.g:435:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalJSON.g:435:3: (lv_value_0_0= RULE_STRING )
            // InternalJSON.g:436:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getJSONStringLiteralAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getJSONStringLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.n4js.json.JSON.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONStringLiteral"


    // $ANTLR start "entryRuleJSONNumericLiteral"
    // InternalJSON.g:455:1: entryRuleJSONNumericLiteral returns [EObject current=null] : iv_ruleJSONNumericLiteral= ruleJSONNumericLiteral EOF ;
    public final EObject entryRuleJSONNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONNumericLiteral = null;


        try {
            // InternalJSON.g:455:59: (iv_ruleJSONNumericLiteral= ruleJSONNumericLiteral EOF )
            // InternalJSON.g:456:2: iv_ruleJSONNumericLiteral= ruleJSONNumericLiteral EOF
            {
             newCompositeNode(grammarAccess.getJSONNumericLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONNumericLiteral=ruleJSONNumericLiteral();

            state._fsp--;

             current =iv_ruleJSONNumericLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONNumericLiteral"


    // $ANTLR start "ruleJSONNumericLiteral"
    // InternalJSON.g:462:1: ruleJSONNumericLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleJSONNumericLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalJSON.g:468:2: ( ( (lv_value_0_0= RULE_NUMBER ) ) )
            // InternalJSON.g:469:2: ( (lv_value_0_0= RULE_NUMBER ) )
            {
            // InternalJSON.g:469:2: ( (lv_value_0_0= RULE_NUMBER ) )
            // InternalJSON.g:470:3: (lv_value_0_0= RULE_NUMBER )
            {
            // InternalJSON.g:470:3: (lv_value_0_0= RULE_NUMBER )
            // InternalJSON.g:471:4: lv_value_0_0= RULE_NUMBER
            {
            lv_value_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getJSONNumericLiteralAccess().getValueNUMBERTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getJSONNumericLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.n4js.json.JSON.NUMBER");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONNumericLiteral"


    // $ANTLR start "entryRuleJSONBooleanLiteral"
    // InternalJSON.g:490:1: entryRuleJSONBooleanLiteral returns [EObject current=null] : iv_ruleJSONBooleanLiteral= ruleJSONBooleanLiteral EOF ;
    public final EObject entryRuleJSONBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONBooleanLiteral = null;


        try {
            // InternalJSON.g:490:59: (iv_ruleJSONBooleanLiteral= ruleJSONBooleanLiteral EOF )
            // InternalJSON.g:491:2: iv_ruleJSONBooleanLiteral= ruleJSONBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getJSONBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONBooleanLiteral=ruleJSONBooleanLiteral();

            state._fsp--;

             current =iv_ruleJSONBooleanLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONBooleanLiteral"


    // $ANTLR start "ruleJSONBooleanLiteral"
    // InternalJSON.g:497:1: ruleJSONBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_booleanValue_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleJSONBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_booleanValue_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalJSON.g:503:2: ( ( () ( ( (lv_booleanValue_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalJSON.g:504:2: ( () ( ( (lv_booleanValue_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalJSON.g:504:2: ( () ( ( (lv_booleanValue_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalJSON.g:505:3: () ( ( (lv_booleanValue_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalJSON.g:505:3: ()
            // InternalJSON.g:506:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONBooleanLiteralAccess().getJSONBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalJSON.g:512:3: ( ( (lv_booleanValue_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==38) ) {
                alt9=1;
            }
            else if ( (LA9_0==39) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalJSON.g:513:4: ( (lv_booleanValue_1_0= 'true' ) )
                    {
                    // InternalJSON.g:513:4: ( (lv_booleanValue_1_0= 'true' ) )
                    // InternalJSON.g:514:5: (lv_booleanValue_1_0= 'true' )
                    {
                    // InternalJSON.g:514:5: (lv_booleanValue_1_0= 'true' )
                    // InternalJSON.g:515:6: lv_booleanValue_1_0= 'true'
                    {
                    lv_booleanValue_1_0=(Token)match(input,38,FOLLOW_2); 

                    						newLeafNode(lv_booleanValue_1_0, grammarAccess.getJSONBooleanLiteralAccess().getBooleanValueTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getJSONBooleanLiteralRule());
                    						}
                    						setWithLastConsumed(current, "booleanValue", lv_booleanValue_1_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJSON.g:528:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getJSONBooleanLiteralAccess().getFalseKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONBooleanLiteral"


    // $ANTLR start "entryRuleJSONNullLiteral"
    // InternalJSON.g:537:1: entryRuleJSONNullLiteral returns [EObject current=null] : iv_ruleJSONNullLiteral= ruleJSONNullLiteral EOF ;
    public final EObject entryRuleJSONNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONNullLiteral = null;


        try {
            // InternalJSON.g:537:56: (iv_ruleJSONNullLiteral= ruleJSONNullLiteral EOF )
            // InternalJSON.g:538:2: iv_ruleJSONNullLiteral= ruleJSONNullLiteral EOF
            {
             newCompositeNode(grammarAccess.getJSONNullLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONNullLiteral=ruleJSONNullLiteral();

            state._fsp--;

             current =iv_ruleJSONNullLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONNullLiteral"


    // $ANTLR start "ruleJSONNullLiteral"
    // InternalJSON.g:544:1: ruleJSONNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleJSONNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalJSON.g:550:2: ( ( () otherlv_1= 'null' ) )
            // InternalJSON.g:551:2: ( () otherlv_1= 'null' )
            {
            // InternalJSON.g:551:2: ( () otherlv_1= 'null' )
            // InternalJSON.g:552:3: () otherlv_1= 'null'
            {
            // InternalJSON.g:552:3: ()
            // InternalJSON.g:553:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONNullLiteralAccess().getJSONNullLiteralAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getJSONNullLiteralAccess().getNullKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONNullLiteral"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000600000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000001D100000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000001F300000030L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000002200000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000002000000000L});

}