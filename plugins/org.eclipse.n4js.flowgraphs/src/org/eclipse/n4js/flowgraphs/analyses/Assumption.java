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
package org.eclipse.n4js.flowgraphs.analyses;

import org.eclipse.n4js.flowgraphs.model.EffectInfo;
import org.eclipse.n4js.flowgraphs.model.Symbol;
import org.eclipse.n4js.n4JS.AssignmentExpression;
import org.eclipse.n4js.n4JS.ConditionalExpression;
import org.eclipse.n4js.n4JS.ControlFlowElement;
import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.n4js.n4JS.IfStatement;

/**
 *
 */
abstract public class Assumption {
	/** Initial symbol this assumption refers to */
	public final Symbol symbol;
	private boolean active = true;

	/** Constructor */
	public Assumption(Symbol symbol) {
		this.symbol = symbol;
	}

	/**
	 * Some {@link Assumption} have a state on their own. This makes copying and merging them necessary.
	 *
	 * @return true iff instances will be copied and merged during analysis
	 */
	public boolean isCopyNecessary() {
		return false;
	}

	/** @return a copy of this instance */
	public Assumption copy() {
		throw new IllegalStateException();
	}

	/**
	 * @param assumption
	 *            the {@link Assumption} this {@link Assumption} will be merged with
	 */
	public void mergeWith(Assumption assumption) {
		throw new IllegalStateException();
	}

	/** Deactivates this {@link Assumption} */
	public void deactivate() {
		active = false;
	}

	/**
	 * By default, {@link Assumption}s are active. In case the method {@link #deactivate()} was called, this
	 * {@link Assumption} is inactive.
	 *
	 * @return true iff {@link #deactivate()} was never called before on this {@link Assumption}
	 */
	final public boolean isActive() {
		return active;
	}

	/**
	 * This method gets called on {@link Expression}s that trigger the value of {@code rhs} to be assigned to
	 * {@code lhs}. For instance, an {@link AssignmentExpression} can trigger such a dataflow.
	 *
	 * @param lhs
	 *            the {@link Symbol} whose value is overwritten
	 * @param rhs
	 *            the {@link Symbol} that provides the new value
	 * @param container
	 *            the {@link ControlFlowElement} that triggers the dataflow
	 * @return true iff the assumption holds on the given dataflow
	 */
	public boolean holdsOnDataflow(Symbol lhs, Symbol rhs, ControlFlowElement container) {
		return true;
	}

	/**
	 * This method gets called on {@link Expression}s that have an effect on the given alias.
	 *
	 * @param effect
	 *            the {@link EffectInfo} that is performed on the aliased symbol due to the container
	 * @param container
	 *            the {@link ControlFlowElement} that contains the given alias
	 * @return true iff the assumption holds on the given alias symbol and its container
	 */
	public boolean holdsOnEffect(EffectInfo effect, ControlFlowElement container) {
		return true;
	}

	/**
	 * This method gets called on {@link Expression}s that guard branches such as in {@link IfStatement},
	 * {@link ConditionalExpression} and loops.
	 *
	 * @param effect
	 *            the {@link EffectInfo} that is performed on the aliased symbol due to the container
	 * @param cfe
	 *            the {@link ControlFlowElement} that contains the given alias. The {@code container} is always an
	 *            {@link Expression} with a boolean return type.
	 * @param must
	 *            true iff the container must be true, false iff the container can be true
	 * @param inverse
	 *            true iff the semantics of the container has to be inverted (i.e. in 'else' branch of 'if' statements),
	 *            otherwise false
	 * @return true iff the assumption holds
	 */
	@Deprecated // not implemented yet
	public boolean holdsOnGuard(EffectInfo effect, ControlFlowElement cfe, boolean must, boolean inverse) {
		return true;
	}

	/**
	 * Called finally after the last copy of this {@link Assumption} was deactivated
	 *
	 * @return true iff the assumption holds
	 */
	public boolean holdsAfterall() {
		return true;
	}
}
