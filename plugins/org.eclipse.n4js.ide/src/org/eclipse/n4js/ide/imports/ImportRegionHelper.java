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
package org.eclipse.n4js.ide.imports;

import static org.eclipse.n4js.parser.InternalSemicolonInjectingParser.SEMICOLON_INSERTED;
import static org.eclipse.n4js.utils.UtilN4.isIgnoredSyntaxErrorNode;
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.findActualNodeFor;
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.findNodesForFeature;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.n4js.n4JS.ImportDeclaration;
import org.eclipse.n4js.n4JS.N4JSASTUtils;
import org.eclipse.n4js.n4JS.N4JSPackage;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.n4JS.ScriptElement;
import org.eclipse.n4js.parser.InternalSemicolonInjectingParser;
import org.eclipse.n4js.services.TypeExpressionsGrammarAccess;
import org.eclipse.n4js.tooling.N4JSDocumentationProvider;
import org.eclipse.n4js.utils.UtilN4;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNodeWithSyntaxError;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Helper used to calculate imports region in the resource.
 */
public class ImportRegionHelper {
	@Inject
	private N4JSDocumentationProvider documentationProvider;

	@Inject
	private TypeExpressionsGrammarAccess typeExpressionGrammmarAccess;

	/**
	 * Calculates import offset by analyzing the provided script.
	 *
	 * @See {@link #getImportRegion(Script)}
	 */
	public int findInsertionOffset(Script script) {
		int result = 0;
		List<ScriptElement> scriptElements = script.getScriptElements();
		for (int i = 0, size = scriptElements.size(); i < size; i++) {
			ScriptElement element = scriptElements.get(i);
			if (element instanceof ImportDeclaration) {
				// Instead of getting the total offset for the first non-import-declaration, we try to get the
				// total end offset for the most recent import declaration which is followed by any other script
				// element
				// this is required for the linebreak handling for automatic semicolon insertion.
				ICompositeNode importNode = NodeModelUtils.findActualNodeFor(element);
				if (null != importNode) {
					result = importNode.getTotalOffset() + getLengthWithoutAutomaticSemicolon(importNode);
				}
			} else {
				// We assume that all import declarations are to be found in one place, thus
				// at this point we must have seen all of them.
				break;
			}
		}
		// If previously, an existing import declaration could be found, use it as offset.
		if (result != 0) {
			return result;
		}
		// Otherwise, we assume there is no import declarations yet. Use {@link ImportsRegionHelper}
		// to obtain an offset for the insertion of a new import declaration.
		return getImportRegion(script).offset;
	}

	/**
	 * Returns with the length of the node including all hidden leaf nodes but the {@link LeafNodeWithSyntaxError} one,
	 * that was created for the automatic semicolon insertion.
	 */
	private static int getLengthWithoutAutomaticSemicolon(final INode node) {
		if (node instanceof ILeafNode) {
			return node.getLength();
		}

		int length = 0;
		for (INode leafNode : ((ICompositeNode) node).getLeafNodes()) {
			if (!isIgnoredSyntaxErrorNode(leafNode, SEMICOLON_INSERTED)) {
				length += leafNode.getLength();
			}
		}

		return length;
	}

	/**
	 * Calculate destination region in Document for imports. If the offset is not 0, then it has to be advanced by
	 * current line feed length
	 *
	 * Note reduced visibility - it is internal method used only by helpers related to organizing imports.
	 *
	 * Using first position after script-annotation ("@@") and after any directive in the prolog section, that is just
	 * before the first statement or, in cases where the first statement is js-style documented, before the jsdoc-style
	 * documentation.
	 *
	 * Examples:
	 *
	 * <pre>
	 *  // (A)
	 *  // (B)
	 *  &#64;&#64;StaticPolyfillAware
	 *  // (C)
	 *  "use strict";
	 *  // (D)
	 *  /&#42; non-jsdoc comment (E) &#42;/
	 *  /&#42;&#42; jsdoc comment (F) &#42;/
	 *  /&#42; non-jsdoc comment (G) &#42;/
	 *  // (H)
	 *  export public class A { // (I)
	 *     method(): B {
	 *        return new B(); // requires import
	 *    }
	 *  }
	 * </pre>
	 *
	 * Will put the insertion-point in front of line (F), since this is the active jsdoc for class A.
	 * {@link InsertionPoint#isBeforeJsdocDocumentation} will be set to true. Lowest possible insertion is the begin of
	 * line (D), stored in {@link InsertionPoint#notBeforeTotalOffset}. If the directive <code>"use strict";</code>
	 * between lines (C) and (D) is omitted, then the lowest insertion point would be in front of line (C). In any case
	 * the insertion of the import must be in front of the <code>export</code> keyword line (I).
	 *
	 * <p>
	 * Region has length 0.
	 *
	 * @param script
	 *            n4js resource
	 * @return region for import statements, length 0
	 */
	private InsertionPoint getImportRegion(Script script) {
		// In N4js imports can appear anywhere in the Script as top-level elements. So even as a last
		// statement and more importantly scattered around.
		InsertionPoint insertionPoint = new InsertionPoint();

		// First Position
		int begin = -1;

		if (script != null) {
			// if there is a script, we can insert in first position.
			begin = 0;
			List<INode> scriptAnnos = findNodesForFeature(script, N4JSPackage.Literals.SCRIPT__ANNOTATIONS);
			if (!scriptAnnos.isEmpty()) {
				INode lastAnno = scriptAnnos.get(scriptAnnos.size() - 1);
				begin = lastAnno.getTotalEndOffset();
				insertionPoint.notBeforeTotalOffset = begin;
				// advance over line feed, since newlines are in the hidden token
				// channel of the following element
				// ChangeManager has information of current line feed length.
			}

			// Searching for directives (string-statements at the beginning, e.g. "use strict")
			// and the first real statement, ignoring imports:
			EList<ScriptElement> elements = script.getScriptElements();
			int lastSeenDirective = -1;
			int idxNondirectiveStatemnt = -1;
			for (var i = 0; i < elements.size() && idxNondirectiveStatemnt == -1; i++) {
				ScriptElement curr = elements.get(i);
				if (N4JSASTUtils.isStringLiteralExpression(curr)) {
					lastSeenDirective = i;
				} else if (curr instanceof ImportDeclaration) {
					// ignore import declarations, will be removed anyway.
				} else {
					idxNondirectiveStatemnt = i;
				}
			}

			// Conditionally calculate begin-position
			if (idxNondirectiveStatemnt != -1) {
				// Standard case, a normal statement encountered.
				// get documentation of that statement:
				ScriptElement realScriptElement = elements.get(idxNondirectiveStatemnt);
				ICompositeNode realScriptElementNode = findActualNodeFor(realScriptElement);

				// find doc, looks for nearest.
				List<INode> docuNodes = documentationProvider.getDocumentationNodes(realScriptElement);

				if (!docuNodes.isEmpty()) {
					// documentation found
					INode docuNode = docuNodes.get(0);
					INode previousNode = docuNode;
					INode lastEOL = null;
					boolean cont = true;
					while (cont && previousNode.hasPreviousSibling() &&
							previousNode.getPreviousSibling() instanceof HiddenLeafNode) {

						EObject grammar = previousNode.getPreviousSibling().getGrammarElement();
						if (grammar == typeExpressionGrammmarAccess.getWSRule()) {
							previousNode = previousNode.getPreviousSibling();
						} else if (grammar == typeExpressionGrammmarAccess.getEOLRule()) {
							previousNode = previousNode.getPreviousSibling();
							lastEOL = previousNode;
						} else {
							cont = false;
						}
					}

					begin = (lastEOL != null) ? lastEOL.getEndOffset() : docuNode.getTotalOffset();
					insertionPoint.isBeforeJsdocDocumentation = true;

				} else {
					// no documentation, go before the statement:
					List<ILeafNode> listLeafNodes = Lists.newArrayList(realScriptElementNode.getLeafNodes());

					// looking for a position right after the last comment and before (WS+EOL)* NOT_HIDDEN_LEAF
					{
						Iterator<ILeafNode> iterLeaves = listLeafNodes.iterator();
						ILeafNode curr = null;
						ILeafNode firstEOL = null;
						ILeafNode afterFirstEOL = null;
						boolean sawComment = false;
						ILeafNode lastComment = null;
						// got to first non-hidden:
						while (iterLeaves.hasNext() && ((curr = iterLeaves.next()).isHidden())) {
							if (curr.getGrammarElement() instanceof TerminalRule) {
								if (curr.getGrammarElement() == typeExpressionGrammmarAccess.getML_COMMENTRule()) {
									// reset EOLs
									firstEOL = null;
									afterFirstEOL = null;
									sawComment = true;
									lastComment = curr;
								} else if (curr.getGrammarElement() == typeExpressionGrammmarAccess
										.getSL_COMMENTRule()) {
									// reset EOLs
									firstEOL = null;
									afterFirstEOL = null;
									sawComment = true;
									lastComment = curr;
								} else if (curr.getGrammarElement() == typeExpressionGrammmarAccess.getEOLRule()) {
									if (firstEOL == null) {
										// store
										firstEOL = curr;
									} else if (afterFirstEOL == null) {
										// store insertion point.
										afterFirstEOL = curr;
									}
								} else if (curr.getGrammarElement() == typeExpressionGrammmarAccess.getWSRule()) {
									// keep going
									if (firstEOL != null && afterFirstEOL == null)
										afterFirstEOL = curr;
								} else {
									firstEOL = null;
									afterFirstEOL = null;
								}
							}
						}
						if (curr == null || curr.isHidden()) {
							// Something is wrong here.
							throw new RuntimeException("Expected at least one non-hidden element.");
						}

						insertionPoint.notAfterTotalOffset = curr.getTotalOffset();

						int begin2 = (afterFirstEOL != null && sawComment) ? afterFirstEOL.getTotalOffset()
								: (hasNoCommentUpTo(curr)) ? 0 // all the imports before will be removed, so put at the
																// beginning.
										:
										// make the comments above the import.
										(sawComment && lastComment != null) ? lastComment.getEndOffset()
												:
												// do not use 'curr.totalOffset;' since it would insert the import
												// directly before the statement.
												// we'd rather want to keep is above the whitespace, so use the first in
												// the list:
												listLeafNodes.get(0).getTotalOffset();

						begin = Math.max(begin, begin2);
					}

					if (lastSeenDirective > -1) {
						// have directive, so insert not before last directive.
						ICompositeNode lastDirectiveNode = NodeModelUtils
								.findActualNodeFor(elements.get(lastSeenDirective));
						int lastDirectiveEndOffset = lastDirectiveNode.getTotalEndOffset();
						// update not before,
						insertionPoint.notBeforeTotalOffset = Math.max(lastDirectiveEndOffset,
								insertionPoint.notBeforeTotalOffset);
						// update begin
						begin = Math.max(begin, lastDirectiveEndOffset);
					}

				}

			} else {
				// no normal statement encountered.
				if (lastSeenDirective > -1) {
					// have directive, so insert after last directive.
					ICompositeNode lastDirectiveNode = NodeModelUtils
							.findActualNodeFor(elements.get(lastSeenDirective));

					// update begin:
					begin = lastDirectiveNode.getTotalEndOffset();
					insertionPoint.notBeforeTotalOffset = Math.max(begin, insertionPoint.notBeforeTotalOffset);

				} else {
					// no directive
					// --> just leave begin as is, after the "@@"
				}
			}

			// create new insertion point.
			insertionPoint.offset = begin;
		}

		return insertionPoint;
	}

	/**
	 * Goes from the beginning of the RootNode up to the passed in node. Looks only at hidden leafs and at
	 * ASI-LeafNodes.
	 *
	 * @return {@code false} if any comment is encountered on the way.
	 */
	private boolean hasNoCommentUpTo(ILeafNode node) {
		if (node == null)
			return true;

		BidiTreeIterator<INode> iter = node.getRootNode().getAsTreeIterable().iterator();
		while (iter.hasNext()) {
			INode curr = iter.next();
			// exit case:
			if (curr == node)
				return true;

			if (curr instanceof LeafNode) {
				if (((LeafNode) curr).isHidden() ||
						UtilN4.isIgnoredSyntaxErrorNode(curr, InternalSemicolonInjectingParser.SEMICOLON_INSERTED)) {
					// hidden OR ASI
					if (!curr.getText().trim().isEmpty()) {
						// token-text contains not only whitespace --> there must be a comment.
						return false;
					}
				}
			}
		}
		// should never be reached.
		throw new IllegalStateException("Iteration over-stepped the passed in node.");
	}

	/**
	 * Extended information about where to insert new text. It holds a general total offset in the document - similar to
	 * a {@link TextRegion} instance, but contrary to that has no length as it describes the point after that insertion
	 * should happen.
	 *
	 * It also carries information if the insertion has to be recomputed. The properties {@link #notBeforeTotalOffset}
	 * and {@link #notAfterTotalOffset} mark the domain of valid recomputed insertion points.
	 *
	 * The property {@linkp #isBeforeJsdocDocumentation} marks insertion points associated with active jsdoc-style
	 * ML-comments.
	 */
	private static class InsertionPoint {

		/** Insertion point, a value of {@code -1} means not set. Zero-based total offset. */
		int offset = -1;

		/**
		 * Flag, if set indicates that the textRegion is just in Front of an active jsdoc region for the first statement
		 */
		@SuppressWarnings("unused")
		boolean isBeforeJsdocDocumentation = false;

		/**
		 * Lowest offset for possible insertion. Usually marked by existing ScriptAnnotation(s) or directives in prolog
		 */
		int notBeforeTotalOffset = 0;

		/** Highest possible insertion point in the document. */
		@SuppressWarnings("unused")
		int notAfterTotalOffset = Integer.MAX_VALUE;
	}
}
