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
package org.eclipse.n4js.flowgraphs.model;

import org.eclipse.n4js.flowgraphs.ControlFlowType;

public class CatchToken extends JumpToken {

	public CatchToken(ControlFlowType type) {
		this(type, null);
	}

	public CatchToken(ControlFlowType type, Object id) {
		super(type, id);
	}

}
