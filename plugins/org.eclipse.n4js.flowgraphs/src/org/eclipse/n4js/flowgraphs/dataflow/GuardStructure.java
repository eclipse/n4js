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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.xtext.EcoreUtil2;

/**
 *
 */
public class GuardStructure {
	final private GuardFactory guardFactory;

	final Expression condition;
	final boolean negate;
	final Map<Symbol, List<Guard>> guards;

	GuardStructure(GuardFactory guardFactory, Expression condition, boolean negate) {
		this.guardFactory = guardFactory;
		this.condition = condition;
		this.negate = negate;
		guards = getGuards();
	}

	private Map<Symbol, List<Guard>> getGuards() {
		Map<Symbol, List<Guard>> guardsMap = new HashMap<>();
		List<Expression> allExpressions = EcoreUtil2.getAllContentsOfType(condition, Expression.class);
		allExpressions.add(condition);

		for (Expression expr : allExpressions) {
			Guard guard = guardFactory.create(condition, expr, negate);
			if (guard != null) {
				if (!guardsMap.containsKey(guard.symbol)) {
					guardsMap.put(guard.symbol, new LinkedList<>());
				}
				List<Guard> symbolGuards = guardsMap.get(guard.symbol);
				symbolGuards.add(guard);
			}
		}

		return guardsMap;
	}
}
