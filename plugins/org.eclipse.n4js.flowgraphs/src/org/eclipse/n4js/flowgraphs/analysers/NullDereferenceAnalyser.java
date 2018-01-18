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
package org.eclipse.n4js.flowgraphs.analysers;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.n4js.flowgraphs.dataflow.Assumption;
import org.eclipse.n4js.flowgraphs.dataflow.DataFlowVisitor;
import org.eclipse.n4js.flowgraphs.dataflow.DestructUtils;
import org.eclipse.n4js.flowgraphs.dataflow.EffectInfo;
import org.eclipse.n4js.flowgraphs.dataflow.EffectType;
import org.eclipse.n4js.flowgraphs.dataflow.Guard;
import org.eclipse.n4js.flowgraphs.dataflow.GuardAssertion;
import org.eclipse.n4js.flowgraphs.dataflow.GuardType;
import org.eclipse.n4js.flowgraphs.dataflow.Symbol;
import org.eclipse.n4js.n4JS.AssignmentExpression;
import org.eclipse.n4js.n4JS.ControlFlowElement;
import org.eclipse.n4js.n4JS.DoStatement;
import org.eclipse.n4js.n4JS.EqualityExpression;
import org.eclipse.n4js.n4JS.EqualityOperator;
import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.n4js.n4JS.ForStatement;
import org.eclipse.n4js.n4JS.N4JSASTUtils;
import org.eclipse.n4js.n4JS.NullLiteral;
import org.eclipse.n4js.n4JS.ParameterizedPropertyAccessExpression;
import org.eclipse.n4js.n4JS.Statement;
import org.eclipse.n4js.n4JS.VariableDeclaration;
import org.eclipse.n4js.n4JS.WhileStatement;
import org.eclipse.xtext.EcoreUtil2;

/**
 * This analysis computes all cases where an implicit assumption of a variable being not null conflicts either with an
 * explicit guard that assures this variable to be null, or with an explicit assignment of null.
 */
public class NullDereferenceAnalyser extends DataFlowVisitor {

	@Override
	public void visitEffect(EffectInfo effect, ControlFlowElement cfe) {
		if (isDereferencing(cfe)) {
			Symbol tgtSymbol = getSymbolFactory().create(cfe);
			if (tgtSymbol != null) {
				IsNotNull symbolNotNull = new IsNotNull(cfe, tgtSymbol);
				assume(symbolNotNull);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void visitGuard(EffectInfo effect, ControlFlowElement cfe, boolean must, boolean inverse) {
		if (must && isDereferencing(cfe)) {
			Symbol tgtSymbol = getSymbolFactory().create(cfe);
			IsReasonableNullGuard isReasonableNullGuard = new IsReasonableNullGuard(cfe, tgtSymbol);
			assume(isReasonableNullGuard);
		}
	}

	private boolean isDereferencing(ControlFlowElement cfe) {
		EObject parent = cfe.eContainer();
		if (parent instanceof ParameterizedPropertyAccessExpression) {
			ParameterizedPropertyAccessExpression ppae = (ParameterizedPropertyAccessExpression) parent;
			Expression target = ppae.getTarget();
			return cfe == target;
		}
		return false;
	}

	/** @return a list of all AST locations where a null pointer dereference can happen */
	public Iterable<NullDereferenceResult> getNullDereferences() {
		Set<NullDereferenceResult> nullDerefs = new HashSet<>();
		for (Assumption ass : failedAssumptions) {
			IsNotNull inn = (IsNotNull) ass;
			ControlFlowElement astLocation = inn.creationSite;
			NullDereferenceResult ndr = new NullDereferenceResult(astLocation, inn);
			nullDerefs.add(ndr);
		}
		return nullDerefs;
	}

	static private EqualityOperator getNullCheckOperator(Symbol alias, ControlFlowElement readOperation) {
		if (readOperation instanceof EqualityExpression) {
			EqualityExpression eqExpr = (EqualityExpression) readOperation;
			EqualityOperator equalityOperator = eqExpr.getOp();
			if (equalityOperator == EqualityOperator.EQ || equalityOperator == EqualityOperator.NEQ) {
				Expression otherExpr = alias.is(eqExpr.getLhs()) ? eqExpr.getRhs() : eqExpr.getLhs();
				if (otherExpr instanceof NullLiteral) {
					return equalityOperator;
				}
			}
		}
		return null;
	}

	private Symbol getSymbolForExpression(EObject value) {
		if (value == null) {
			return getSymbolFactory().getUndefined();
		} else {
			Expression canCrash = (Expression) value;
			return getSymbolFactory().create(canCrash);
		}
	}

	class IsNotNull extends Assumption {
		Symbol nullOrUndefinedSymbol;

		IsNotNull(ControlFlowElement cfe, Symbol symbol) {
			super(cfe, symbol);
		}

		IsNotNull(IsNotNull copy) {
			super(copy);
		}

		@Override
		public Assumption copy() {
			return new IsNotNull(this);
		}

		@Override
		public boolean holdsOnEffect(EffectInfo effect, ControlFlowElement cfe) {
			if (effect.type == EffectType.Write) {
				nullOrUndefinedSymbol = getNullOrUndefinedAssignee(effect, cfe);

				if (nullOrUndefinedSymbol != null) {
					if (nullOrUndefinedSymbol.isNullLiteral()) {
						return false;
					} else if (nullOrUndefinedSymbol.isUndefinedLiteral()) {
						return false;
					}
				} else {
					deactivateAlias(effect.symbol);
				}
			}
			return true;
		}

		private Symbol getNullOrUndefinedAssignee(EffectInfo effect, ControlFlowElement cfe) {
			Symbol nullOrUndefined = null;

			if (cfe instanceof AssignmentExpression) {
				AssignmentExpression ae = (AssignmentExpression) cfe;
				EObject value = null;

				if (N4JSASTUtils.isDestructuringAssignment(ae)) {
					value = DestructUtils.getValueFromDestructuring(getSymbolFactory(), effect.location);
				} else {
					value = ae.getRhs();
				}
				nullOrUndefined = getSymbolForExpression(value);
			}
			if (cfe instanceof VariableDeclaration) {
				VariableDeclaration vd = (VariableDeclaration) cfe;
				Statement stmt = EcoreUtil2.getContainerOfType(cfe, Statement.class);
				boolean parentIsLoop = false;
				parentIsLoop |= parentIsLoop || stmt instanceof ForStatement;
				parentIsLoop |= parentIsLoop || stmt instanceof WhileStatement;
				parentIsLoop |= parentIsLoop || stmt instanceof DoStatement;

				if (!parentIsLoop) {
					EObject value = null;
					if (N4JSASTUtils.isInDestructuringPattern(vd)) {
						value = DestructUtils.getValueFromDestructuring(getSymbolFactory(), effect.location);
					} else {
						value = vd.getExpression();
					}
					nullOrUndefined = getSymbolForExpression(value);
				}
			}

			return nullOrUndefined;
		}

		@SuppressWarnings("deprecation")
		@Override
		public boolean holdsOnGuard(Guard guard) {
			if (guard.type.IsNullOrUndefined() && guard.asserts.canHold()) {
				return false;
			}
			if (guard.type == GuardType.IsTruthy && guard.asserts == GuardAssertion.AlwaysHolds) {
				this.deactivateAlias(guard.symbol);
			}

			return true;
		}
	}

	// TODO: revisit and specify Null|Undefined|Truthy better
	static class IsReasonableNullGuard extends Assumption {
		private boolean alwaysNullBefore = false;
		private boolean neverNullBefore = false;

		IsReasonableNullGuard(ControlFlowElement cfe, Symbol symbol) {
			this(cfe, symbol, false, false);
		}

		IsReasonableNullGuard(ControlFlowElement cfe, Symbol symbol, boolean alwaysNullBefore,
				boolean alwaysNotNullBefore) {

			super(cfe, symbol);
			this.alwaysNullBefore = alwaysNullBefore;
			this.neverNullBefore = alwaysNotNullBefore;
		}

		IsReasonableNullGuard(IsReasonableNullGuard copy) {
			super(copy);
			this.alwaysNullBefore = copy.alwaysNullBefore;
			this.neverNullBefore = copy.neverNullBefore;
		}

		@Override
		public Assumption copy() {
			return new IsReasonableNullGuard(this);
		}

		@Override
		public void mergeWith(Assumption assumption) {
			super.mergeWith(assumption);
			IsReasonableNullGuard irng = (IsReasonableNullGuard) assumption;
			alwaysNullBefore |= irng.alwaysNullBefore;
			neverNullBefore |= irng.neverNullBefore;
		}

		@Override
		public boolean holdsOnEffect(EffectInfo effect, ControlFlowElement cfe) {
			if (effect.type == EffectType.Write && cfe instanceof AssignmentExpression) {
				AssignmentExpression ae = (AssignmentExpression) cfe;
				if (ae.getRhs() instanceof NullLiteral) {
					alwaysNullBefore = true;
				} else {
					neverNullBefore = true;
				}
				deactivate();
			}
			return true;
		}

		@SuppressWarnings("deprecation")
		@Override
		public boolean holdsOnGuard(Guard guard) {
			if (guard.type == GuardType.IsTruthy) {
				if (guard.asserts == GuardAssertion.AlwaysHolds) {
					neverNullBefore = true;
					this.deactivateAlias(guard.symbol);
				}
				if (guard.asserts == GuardAssertion.NeverHolds) {
					alwaysNullBefore = true;
					this.deactivateAlias(guard.symbol);
				}
			}

			return true;
		}

		@Override
		public boolean holdsAfterall() {
			boolean isReasonableNullGuard = true;
			isReasonableNullGuard &= !alwaysNullBefore;
			isReasonableNullGuard &= !neverNullBefore;
			return isReasonableNullGuard;
		}
	}
}
