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
package org.eclipse.n4js.semver.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.n4js.semver.services.SEMVERGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SEMVERSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SEMVERGrammarAccess grammarAccess;
	protected AbstractElementAlias match_HyphenVersionRange_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_HyphenVersionRange_WSTerminalRuleCall_4_p;
	protected AbstractElementAlias match_NPMVersion_WSTerminalRuleCall_0_0_a;
	protected AbstractElementAlias match_NPMVersion_WSTerminalRuleCall_1_1_a;
	protected AbstractElementAlias match_SimpleVersion_WSTerminalRuleCall_1_1_a;
	protected AbstractElementAlias match_URLSemver_SemverKeyword_0_q;
	protected AbstractElementAlias match_VersionRangeContraint_WSTerminalRuleCall_2_0_p;
	protected AbstractElementAlias match_VersionRangeSet_WSTerminalRuleCall_1_1_0_a;
	protected AbstractElementAlias match_VersionRangeSet_WSTerminalRuleCall_1_1_2_a;
	protected AbstractElementAlias match_VersionRangeSet_WSTerminalRuleCall_1_2_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SEMVERGrammarAccess) access;
		match_HyphenVersionRange_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getHyphenVersionRangeAccess().getWSTerminalRuleCall_2());
		match_HyphenVersionRange_WSTerminalRuleCall_4_p = new TokenAlias(true, false, grammarAccess.getHyphenVersionRangeAccess().getWSTerminalRuleCall_4());
		match_NPMVersion_WSTerminalRuleCall_0_0_a = new TokenAlias(true, true, grammarAccess.getNPMVersionAccess().getWSTerminalRuleCall_0_0());
		match_NPMVersion_WSTerminalRuleCall_1_1_a = new TokenAlias(true, true, grammarAccess.getNPMVersionAccess().getWSTerminalRuleCall_1_1());
		match_SimpleVersion_WSTerminalRuleCall_1_1_a = new TokenAlias(true, true, grammarAccess.getSimpleVersionAccess().getWSTerminalRuleCall_1_1());
		match_URLSemver_SemverKeyword_0_q = new TokenAlias(false, true, grammarAccess.getURLSemverAccess().getSemverKeyword_0());
		match_VersionRangeContraint_WSTerminalRuleCall_2_0_p = new TokenAlias(true, false, grammarAccess.getVersionRangeContraintAccess().getWSTerminalRuleCall_2_0());
		match_VersionRangeSet_WSTerminalRuleCall_1_1_0_a = new TokenAlias(true, true, grammarAccess.getVersionRangeSetAccess().getWSTerminalRuleCall_1_1_0());
		match_VersionRangeSet_WSTerminalRuleCall_1_1_2_a = new TokenAlias(true, true, grammarAccess.getVersionRangeSetAccess().getWSTerminalRuleCall_1_1_2());
		match_VersionRangeSet_WSTerminalRuleCall_1_2_a = new TokenAlias(true, true, grammarAccess.getVersionRangeSetAccess().getWSTerminalRuleCall_1_2());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getWILDCARDRule())
			return getWILDCARDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * WILDCARD:
	 * 	'x' | 'X' | '*'
	 * ;
	 */
	protected String getWILDCARDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "x";
	}
	
	/**
	 * terminal WS:
	 * 	WHITESPACE_FRAGMENT+;
	 */
	protected String getWSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\t";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_HyphenVersionRange_WSTerminalRuleCall_2_p.equals(syntax))
				emit_HyphenVersionRange_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HyphenVersionRange_WSTerminalRuleCall_4_p.equals(syntax))
				emit_HyphenVersionRange_WSTerminalRuleCall_4_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NPMVersion_WSTerminalRuleCall_0_0_a.equals(syntax))
				emit_NPMVersion_WSTerminalRuleCall_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NPMVersion_WSTerminalRuleCall_1_1_a.equals(syntax))
				emit_NPMVersion_WSTerminalRuleCall_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SimpleVersion_WSTerminalRuleCall_1_1_a.equals(syntax))
				emit_SimpleVersion_WSTerminalRuleCall_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_URLSemver_SemverKeyword_0_q.equals(syntax))
				emit_URLSemver_SemverKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VersionRangeContraint_WSTerminalRuleCall_2_0_p.equals(syntax))
				emit_VersionRangeContraint_WSTerminalRuleCall_2_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VersionRangeSet_WSTerminalRuleCall_1_1_0_a.equals(syntax))
				emit_VersionRangeSet_WSTerminalRuleCall_1_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VersionRangeSet_WSTerminalRuleCall_1_1_2_a.equals(syntax))
				emit_VersionRangeSet_WSTerminalRuleCall_1_1_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VersionRangeSet_WSTerminalRuleCall_1_2_a.equals(syntax))
				emit_VersionRangeSet_WSTerminalRuleCall_1_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     from=VersionNumber (ambiguity) '-' WS+ to=VersionNumber
	 */
	protected void emit_HyphenVersionRange_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     from=VersionNumber WS+ '-' (ambiguity) to=VersionNumber
	 */
	protected void emit_HyphenVersionRange_WSTerminalRuleCall_4_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 *     (rule start) (ambiguity) ranges+=VersionRange
	 */
	protected void emit_NPMVersion_WSTerminalRuleCall_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     commitISH=ALPHA_NUMERIC_CHARS (ambiguity) (rule end)
	 *     githubUrl=URL (ambiguity) (rule end)
	 *     localPath=PATH (ambiguity) (rule end)
	 *     tagName=TAG (ambiguity) (rule end)
	 *     url=URL (ambiguity) (rule end)
	 *     versionSpecifier=URLVersionSpecifier (ambiguity) (rule end)
	 */
	protected void emit_NPMVersion_WSTerminalRuleCall_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     comparators+=VersionComparator (ambiguity) comparators+=VersionComparator
	 *     comparators+=VersionComparator (ambiguity) number=VersionNumber
	 */
	protected void emit_SimpleVersion_WSTerminalRuleCall_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'semver:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) simpleVersion=SimpleVersion
	 */
	protected void emit_URLSemver_SemverKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     versionConstraints+=SimpleVersion (ambiguity) versionConstraints+=SimpleVersion
	 */
	protected void emit_VersionRangeContraint_WSTerminalRuleCall_2_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     ranges+=VersionRange (ambiguity) '||' WS* ranges+=VersionRange
	 */
	protected void emit_VersionRangeSet_WSTerminalRuleCall_1_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     ranges+=VersionRange WS* '||' (ambiguity) ranges+=VersionRange
	 */
	protected void emit_VersionRangeSet_WSTerminalRuleCall_1_1_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     ranges+=VersionRange (ambiguity) (rule end)
	 */
	protected void emit_VersionRangeSet_WSTerminalRuleCall_1_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
