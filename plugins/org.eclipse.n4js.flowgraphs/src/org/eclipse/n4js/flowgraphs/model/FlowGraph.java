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
package org.eclipse.n4js.flowgraphs.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.n4js.flowgraphs.N4JSFlowAnalyzer;
import org.eclipse.n4js.flowgraphs.factories.CFEMapper;
import org.eclipse.n4js.n4JS.Block;
import org.eclipse.n4js.n4JS.CatchBlock;
import org.eclipse.n4js.n4JS.ControlFlowElement;
import org.eclipse.n4js.n4JS.Script;

/**
 * Stores information about all control flow graphs of one {@link Script}.
 */
public class FlowGraph {
	final private Script script;
	final private Map<ControlFlowElement, List<ControlFlowElement>> cfContainers;
	final private Set<Block> cfCatchBlocks;
	final private Map<ControlFlowElement, ComplexNode> cnMap;

	/** Constructor. */
	public FlowGraph(Script script, Map<ControlFlowElement, List<ControlFlowElement>> cfContainers,
			Set<Block> cfCatchBlocks, Map<ControlFlowElement, ComplexNode> cnMap) {

		this.script = script;
		this.cfContainers = cfContainers;
		this.cfCatchBlocks = cfCatchBlocks;
		this.cnMap = cnMap;
	}

	/** @return the script of this {@link FlowGraph} */
	public Script getScript() {
		return script;
	}

	/** @return the URI String of the script of this {@link FlowGraph} */
	public String getScriptName() {
		return script.eResource().getURI().toString();
	}

	/** @return all {@link ComplexNode}s of the script. */
	public Collection<ComplexNode> getAllComplexNodes() {
		return cnMap.values();
	}

	/** @return the {@link ComplexNode} for the given {@link ControlFlowElement} cfe. */
	public ComplexNode getComplexNode(ControlFlowElement cfe) {
		cfe = CFEMapper.map(cfe);
		if (!cnMap.containsKey(cfe))
			return null;
		return cnMap.get(cfe);
	}

	/** see {@link N4JSFlowAnalyzer#getContainer(ControlFlowElement)} */
	public ControlFlowElement getContainer(ControlFlowElement cfe) {
		ComplexNode cn = getComplexNode(cfe);
		return cn.getControlFlowContainer();
	}

	/** see {@link N4JSFlowAnalyzer#getAllContainers()} */
	public Set<ControlFlowElement> getAllContainers() {
		return cfContainers.keySet();
	}

	/** @return all {@link ControlFlowElement}s of the given container */
	public List<ControlFlowElement> getCFEsOfContainer(ControlFlowElement container) {
		return cfContainers.get(container);
	}

	/** @return all {@link Block}s whose containers are of type {@link CatchBlock} */
	public Set<Block> getCatchBlocks() {
		return cfCatchBlocks;
	}

	/** see {@link N4JSFlowAnalyzer#getCatchBlocksOfContainer(ControlFlowElement)} */
	public List<Block> getCatchBlocksOfContainer(ControlFlowElement container) {
		List<Block> catchBlockOfContainer = new LinkedList<>();
		for (Block catchBlock : cfCatchBlocks) {
			ControlFlowElement cbContainer = getContainer(catchBlock);
			if (cbContainer == container) {
				catchBlockOfContainer.add(catchBlock);
			}
		}
		return catchBlockOfContainer;
	}

}
