/**
 * Copyright (c) 2017 itemis, NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.ui.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * Filters out static members.
 */
public class N4JSFilterStaticMembersOutlineContribution extends AbstractN4JSFilterOutlineContribution {

	/**
	 * Preference key to store default mode.
	 */
	public static final String PREFERENCE_KEY = "ui.outline.filterStatic";

	@Override
	protected boolean apply(IOutlineNode node) {
		if (node instanceof N4JSEObjectNode) {
			N4JSEObjectNode n4jseObjectNode = (N4JSEObjectNode) node;
			if (n4jseObjectNode.isMember) {
				return !n4jseObjectNode.isStatic;
			}
		}
		return true;
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void configureAction(Action action) {
		action.setText("Hide Static Members");
		action.setDescription("Hide Static Members");
		action.setToolTipText("Hide Static Fields and Methods");
		action.setImageDescriptor(imageHelper.getImageDescriptor("static_co.png"));
	}
}
