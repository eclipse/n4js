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
package org.eclipse.n4js.flowgraphs;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.n4js.n4JS.ControlFlowElement;

/**
 *
 */
public class FlowEdge implements Comparable<FlowEdge> {
	final public ControlFlowElement start;
	final public ControlFlowElement end;
	final public Set<ControlFlowType> cfTypes;

	public FlowEdge(ControlFlowElement start, ControlFlowElement end, Set<ControlFlowType> cfTypes) {
		this.start = start;
		this.end = end;
		this.cfTypes = Collections.unmodifiableSet(cfTypes);
	}

	@Override
	public int compareTo(FlowEdge fe) {
		int compareVal = 0;
		compareVal = (compareVal != 0) ? compareVal : this.start.hashCode() - fe.start.hashCode();
		compareVal = (compareVal != 0) ? compareVal : this.end.hashCode() - fe.end.hashCode();
		compareVal = (compareVal != 0) ? compareVal : this.cfTypes.size() - fe.cfTypes.size();

		Iterator<ControlFlowType> myCFTs = this.cfTypes.iterator();
		Iterator<ControlFlowType> otherCFTs = fe.cfTypes.iterator();
		while (compareVal == 0 && myCFTs.hasNext()) {
			ControlFlowType myCFT = myCFTs.next();
			ControlFlowType otherCFT = otherCFTs.next();
			compareVal = myCFT.hashCode() - otherCFT.hashCode();
		}

		return compareVal;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FlowEdge))
			return false;

		FlowEdge fe = (FlowEdge) o;
		boolean equals = true;
		equals &= this.start == fe.start;
		equals &= this.end == fe.end;
		equals &= this.cfTypes.equals(fe.cfTypes);
		return equals;
	}

	@Override
	public int hashCode() {
		long hashCode = start.hashCode() + end.hashCode();
		for (ControlFlowType cft : cfTypes) {
			hashCode += cft.hashCode();
		}
		return (int) (hashCode % Integer.MAX_VALUE);
	}

	@Override
	public String toString() {
		String toString = "";
		toString += FGUtils.getTextLabel(start);
		toString += " -";
		boolean firstCFT = true;
		for (Iterator<ControlFlowType> cftIt = cfTypes.iterator(); cftIt.hasNext();) {
			ControlFlowType cft = cftIt.next();
			if (cft != ControlFlowType.Successor) {
				if (!firstCFT && cftIt.hasNext()) {
					toString += "|";
				}
				firstCFT = false;
				toString += cft.name();
			}
		}
		toString += "-> ";
		toString += FGUtils.getTextLabel(end);
		return toString;
	}
}
