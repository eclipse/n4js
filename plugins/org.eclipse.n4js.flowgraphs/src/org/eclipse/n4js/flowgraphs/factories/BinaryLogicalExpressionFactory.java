/**
 * Copyright (c) 2017 Marcus Mews.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Marcus Mews - Initial API and implementation
 */
package org.eclipse.n4js.flowgraphs.factories;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.n4js.flowgraphs.ControlFlowType;
import org.eclipse.n4js.flowgraphs.model.CatchToken;
import org.eclipse.n4js.flowgraphs.model.ComplexNode;
import org.eclipse.n4js.flowgraphs.model.HelperNode;
import org.eclipse.n4js.flowgraphs.model.JumpToken;
import org.eclipse.n4js.flowgraphs.model.Node;
import org.eclipse.n4js.flowgraphs.model.RepresentingNode;
import org.eclipse.n4js.n4JS.BinaryLogicalExpression;
import org.eclipse.n4js.n4JS.BinaryLogicalOperator;
import org.eclipse.n4js.n4JS.ConditionalExpression;
import org.eclipse.n4js.n4JS.DoStatement;
import org.eclipse.n4js.n4JS.ForStatement;
import org.eclipse.n4js.n4JS.IfStatement;
import org.eclipse.n4js.n4JS.ParenExpression;
import org.eclipse.n4js.n4JS.Statement;
import org.eclipse.n4js.n4JS.WhileStatement;

/**
 * Creates instances of {@link ComplexNode}s for AST elements of type {@link ConditionalExpression}s.
 * <p/>
 * <b>Attention:</b> The order of {@link Node#astPosition}s is important, and thus the order of Node instantiation! In
 * case this order is inconsistent to {@link OrderedEContentProvider}, the assertion with the message
 * {@link ReentrantASTIterator#ASSERTION_MSG_AST_ORDER} is thrown.
 */
class BinaryLogicalExpressionFactory {

	static ComplexNode buildComplexNode(ReentrantASTIterator astpp, BinaryLogicalExpression lbExpr) {
		ComplexNode cNode = new ComplexNode(astpp.container(), lbExpr);

		HelperNode entryNode = new HelperNode(NodeNames.ENTRY, astpp.pos(), lbExpr);
		Node lhsNode = DelegatingNodeFactory.createOrHelper(astpp, NodeNames.LHS, lbExpr, lbExpr.getLhs());
		Node jumpNode = new HelperNode(NodeNames.SHORT_CIRCUIT_JUMP, astpp.pos(), lbExpr);
		Node rhsNode = DelegatingNodeFactory.createOrHelper(astpp, NodeNames.RHS, lbExpr, lbExpr.getRhs());
		Node exitNode = new RepresentingNode(NodeNames.EXIT, astpp.pos(), lbExpr);

		cNode.addNode(entryNode);
		cNode.addNode(lhsNode);
		cNode.addNode(jumpNode);
		cNode.addNode(rhsNode);
		cNode.addNode(exitNode);

		ControlFlowType thenCFT = null;
		ControlFlowType elseCFT = null;
		switch (lbExpr.getOp()) {
		case OR:
			thenCFT = ControlFlowType.IfFalse;
			elseCFT = ControlFlowType.IfTrue;
			break;
		case AND:
			thenCFT = ControlFlowType.IfTrue;
			elseCFT = ControlFlowType.IfFalse;
			break;
		}

		cNode.connectInternalSucc(entryNode, lhsNode, jumpNode);
		cNode.connectInternalSucc(thenCFT, jumpNode, rhsNode);
		cNode.connectInternalSucc(rhsNode, exitNode);

		jumpNode.addJumpToken(new JumpToken(elseCFT)); // short-circuit evaluation
		cNode.setJumpNode(jumpNode);

		cNode.setEntryNode(entryNode);
		cNode.setExitNode(exitNode);

		boolean isCatching = isCatching(lbExpr, lbExpr.getOp());
		if (isCatching) {
			CatchToken catchToken = null;
			if (lbExpr.getOp() == BinaryLogicalOperator.OR) {
				catchToken = new CatchToken(ControlFlowType.IfTrue);
			}
			if (lbExpr.getOp() == BinaryLogicalOperator.AND) {
				catchToken = new CatchToken(ControlFlowType.IfFalse);
			}
			if (catchToken != null) {
				exitNode.addCatchToken(catchToken);
			}
		}

		return cNode;
	}

	static private boolean isCatching(EObject eObj, BinaryLogicalOperator operator) {
		EObject parent = eObj.eContainer();
		if (parent instanceof ParenExpression) {
			return isCatching(parent, operator);
		}

		if (parent instanceof BinaryLogicalExpression) {
			BinaryLogicalExpression bleParent = (BinaryLogicalExpression) parent;
			return bleParent.getOp() != operator;
		}
		if (parent instanceof ConditionalExpression) {
			ConditionalExpression isParent = (ConditionalExpression) parent;
			return isParent.getExpression() != eObj;
		}
		if (parent instanceof Statement) {
			if (parent instanceof IfStatement) {
				IfStatement isParent = (IfStatement) parent;
				return isParent.getExpression() != eObj;
			}
			if (parent instanceof ForStatement) {
				ForStatement isParent = (ForStatement) parent;
				return isParent.getExpression() != eObj;
			}
			if (parent instanceof WhileStatement) {
				WhileStatement isParent = (WhileStatement) parent;
				return isParent.getExpression() != eObj;
			}
			if (parent instanceof DoStatement) {
				DoStatement isParent = (DoStatement) parent;
				return isParent.getExpression() != eObj;
			}
		}

		return true;
	}

}
