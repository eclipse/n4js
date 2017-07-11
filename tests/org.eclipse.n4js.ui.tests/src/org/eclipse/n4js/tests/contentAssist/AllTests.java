/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.tests.contentAssist;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All the unit tests related to content assist.
 */
@RunWith(Suite.class)
@SuiteClasses({
		TypeReferenceContentAssistPluginUITest.class,
		ContentAssistParserSanityTest.class,
		ContentAssistBugTest.class,
		InternalParserTest.class,
		ParserTest.class,
		ParserWithNodesTest.class })
public class AllTests {
	// empty
}
