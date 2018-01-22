/**
 * Copyright (c) 2018 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.flowgraphs.dataflow;

import static org.eclipse.n4js.flowgraphs.dataflow.SymbolContextUtils.getContextChangedSymbol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.n4js.flowgraphs.analysis.BranchWalkerInternal;
import org.eclipse.n4js.flowgraphs.model.ControlFlowEdge;
import org.eclipse.n4js.flowgraphs.model.Node;
import org.eclipse.n4js.n4JS.AssignmentExpression;
import org.eclipse.n4js.n4JS.ControlFlowElement;
import org.eclipse.n4js.n4JS.DestructNode;
import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.n4js.n4JS.N4JSASTUtils;
import org.eclipse.n4js.n4JS.VariableDeclaration;
import org.eclipse.n4js.n4JS.VariableDeclarationOrBinding;
import org.eclipse.n4js.n4JS.VariableStatement;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * {@link BranchWalkerInternal} that is used only in data flow analyses.
 */
class DataFlowBranchWalker extends BranchWalkerInternal {
	final Map<Object, Assumption> assumptions = new HashMap<>();
	private int forkCount = 0;

	@Override
	protected BranchWalkerInternal fork() {
		DataFlowBranchWalker dfb = new DataFlowBranchWalker();
		for (Map.Entry<Object, Assumption> entry : assumptions.entrySet()) {
			Object key = entry.getKey();
			Assumption ass = entry.getValue();
			if (forkCount > 0) {
				ass = ass.copy();
			}
			dfb.assumptions.put(key, ass);
		}
		forkCount++;
		return dfb;
	}

	@Override
	protected void visit(Node node) {
		ControlFlowElement cfe = node.getControlFlowElement();
		for (EffectInfo effect : node.effectInfos) {
			boolean handledDataFlow = false;
			if (cfe instanceof AssignmentExpression) {
				handledDataFlow |= handleDataFlow((AssignmentExpression) cfe);
			}
			if (cfe instanceof VariableDeclaration) {
				handledDataFlow |= handleDataFlow((VariableDeclaration) cfe);
			}
			if (!handledDataFlow) {
				handleVisitEffect(cfe, effect);
			}
		}
	}

	@Override
	protected void visit(Node lastVisitNodes, Node end, ControlFlowEdge edge) {
		GuardStructure guardStructure = new GuardStructureFactory(getSymbolFactory()).create(edge);
		if (guardStructure == null) {
			return;
		}

		for (Iterator<Assumption> assIter = assumptions.values().iterator(); assIter.hasNext();) {
			Assumption ass = assIter.next();
			if (ass.isActive()) {
				for (Symbol alias : ass.aliases) {
					if (guardStructure.guards.containsKey(alias)) {
						List<Guard> guards = guardStructure.guards.get(alias);
						for (Guard guard : guards) {
							ass.callHoldsOnGuard(guard);
						}
					}
				}
			}
			if (!ass.isActive()) {
				assIter.remove();
			}
		}
	}

	@Override
	protected void switchedToDeadBranch() {
		for (Assumption ass : assumptions.values()) {
			ass.deactivate();
		}
		assumptions.clear();
	}

	private DataFlowVisitorHost getDataFlowVisitorHost() {
		return (DataFlowVisitorHost) getExplorer().getGraphVisitorInternal();
	}

	private SymbolFactory getSymbolFactory() {
		return getDataFlowVisitorHost().getSymbolFactory();
	}

	private boolean handleDataFlow(AssignmentExpression ae) {
		boolean dataFlow = false;

		if (N4JSASTUtils.isDestructuringAssignment(ae)) {
			DestructNode dNode = DestructNode.unify(ae);
			dataFlow = callHoldOnDataflowForDestructuring(dataFlow, ae, dNode);
		} else {
			Expression lhs = ae.getLhs();
			Expression rhs = ae.getRhs();
			dataFlow = callHoldOnDataflow(ae, lhs, rhs);
		}

		return dataFlow;
	}

	private boolean handleDataFlow(VariableDeclaration vd) {
		boolean dataFlow = false;
		EObject parent = vd.eContainer();

		if (N4JSASTUtils.isInDestructuringPattern(vd)) {
			DestructNode dNode = N4JSASTUtils.getCorrespondingDestructNode(vd);
			if (dNode != null) {
				dataFlow = callHoldOnDataflowForDestructuring(dataFlow, vd, dNode);
			}

		} else if (parent instanceof VariableStatement) {
			VariableStatement vs = (VariableStatement) parent;
			for (VariableDeclarationOrBinding varDeclOrBind : vs.getVarDeclsOrBindings()) {
				if (varDeclOrBind instanceof VariableDeclaration) {
					VariableDeclaration varDecl = (VariableDeclaration) varDeclOrBind;
					Expression rhs = varDecl.getExpression();
					dataFlow = callHoldOnDataflow(varDecl, varDecl, rhs);
				}
			}
		}

		return dataFlow;
	}

	private boolean callHoldOnDataflowForDestructuring(boolean dataFlow, ControlFlowElement cfe,
			DestructNode dNode) {

		for (Iterator<DestructNode> dnIter = dNode.stream().iterator(); dnIter.hasNext();) {
			DestructNode dnChild = dnIter.next();
			ControlFlowElement lhs = dnChild.getVarRef() != null ? dnChild.getVarRef() : dnChild.getVarDecl();
			EObject rhs = DestructUtils.getValueFromDestructuring(getSymbolFactory(), dnChild);
			if (rhs instanceof Expression) {
				dataFlow |= callHoldOnDataflow(cfe, lhs, (Expression) rhs);
			}
		}
		return dataFlow;
	}

	private void handleVisitEffect(ControlFlowElement cfe, EffectInfo effect) {
		for (DataFlowVisitor dfv : getDataFlowVisitorHost().dfVisitors) {
			callHoldsOnEffect(cfe, effect);
			dfv.visitEffect(effect, cfe);

			Collection<Assumption> newAssumptions = dfv.moveNewAssumptions();
			Iterator<Assumption> assIter = newAssumptions.iterator();
			while (assIter.hasNext()) {
				Assumption ass = assIter.next();
				assumptions.put(ass.key, ass);
			}
		}
	}

	private void callHoldsOnEffect(ControlFlowElement cfe, EffectInfo effect) {
		for (Iterator<Assumption> assIter = assumptions.values().iterator(); assIter.hasNext();) {
			Assumption ass = assIter.next();
			if (ass.isActive()) {
				if (ass.aliases.contains(effect.symbol)) {
					ass.callHoldsOnEffect(effect, cfe); // call for plain aliases

				} else {
					for (Symbol alias : ass.aliases) {
						if (effect.symbol.isStrucuralAlias(alias)) {
							ass.callHoldsOnEffect(effect, cfe); // also called for structural aliases
							break;
						}
					}
				}
			}
			if (!ass.isActive()) {
				assIter.remove();
			}
		}
	}

	private boolean callHoldOnDataflow(ControlFlowElement cfe, ControlFlowElement lhs, Expression rhs) {
		Symbol lSymbol = getSymbolFactory().create(lhs);
		Symbol rSymbol = getSymbolFactory().create(rhs);

		if (lSymbol != null && rSymbol != null && rSymbol.isVariableSymbol()) {
			for (Iterator<Assumption> assIter = assumptions.values().iterator(); assIter.hasNext();) {
				Assumption ass = assIter.next();

				if (ass.isActive()) {
					boolean callPerformed = callHoldOnDataflowOnAliases(ass, cfe, lSymbol, rSymbol);
					if (!callPerformed) {
						callPerformed = callHoldOnDataflowOnFailedStructuralAliases(ass, lSymbol, rSymbol);
					}
					if (!callPerformed) {
						callPerformed = callHoldOnDataflowOnStructuralAliases(ass, cfe, rhs, lSymbol);
					}
					// if still (!callPerformed): not important
				}
				if (!ass.isActive()) {
					assIter.remove();
				}
			}
			return true;
		}
		return false;
	}

	private boolean callHoldOnDataflowOnAliases(Assumption ass, ControlFlowElement cfe, Symbol lSymbol,
			Symbol rSymbol) {

		if (ass.aliases.contains(lSymbol)) {
			ass.callHoldsOnDataflow(lSymbol, rSymbol, cfe);
			return true;
		}
		return false;
	}

	private boolean callHoldOnDataflowOnStructuralAliases(Assumption ass, ControlFlowElement cfe,
			Expression rhs, Symbol lSymbol) {

		Pair<Symbol, Symbol> cSymbols = getContextChangedSymbol(getSymbolFactory(), ass.aliases, lSymbol, rhs);
		Symbol newLSymbol = cSymbols.getKey();
		Symbol newRSymbol = cSymbols.getValue();
		if (newRSymbol != null) {
			ass.callHoldsOnDataflow(newLSymbol, newRSymbol, cfe);
			return true;
		}

		cSymbols = getContextChangedSymbol(getSymbolFactory(), ass.failingStructuralAliases, lSymbol, rhs);
		newLSymbol = cSymbols.getKey();
		newRSymbol = cSymbols.getValue();
		if (newRSymbol != null) {
			ass.callHoldsOnDataflow(newLSymbol, newRSymbol, cfe);
			return true;
		}
		return false;
	}

	private boolean callHoldOnDataflowOnFailedStructuralAliases(Assumption ass, Symbol lSymbol, Symbol rSymbol) {
		Pair<Symbol, List<Symbol>> lSCA = SymbolContextUtils
				.getSymbolAndContextsToAlias(ass.failingStructuralAliases, lSymbol);

		if (lSCA.getKey() != null) {
			ass.failOnStructuralAlias(lSCA.getKey());
			return true;
		}

		Pair<Symbol, List<Symbol>> rCSA = SymbolContextUtils
				.getSymbolAndContextsToAlias(ass.failingStructuralAliases, rSymbol);

		if (rCSA.getKey() != null) {
			ass.failOnStructuralAlias(rCSA.getKey());
			return true;
		}

		return false;
	}
}
