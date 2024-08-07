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
package org.eclipse.n4js.transpiler.es.tests;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.n4js.N4JSInjectorProvider;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

/**
 */
@RunWith(XtextRunner.class)
@InjectWith(N4JSInjectorProvider.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BlockTransformationTest extends AbstractTranspilerTest {

	@Test
	public void testReplace_Arguments_CompileResult() throws Throwable {

		String script = """
				function f() {
					var aa = arguments.length;
					var ab = arguments[1];
				}
				""";

		String moduleWrapped = """
				// Generated by N4JS transpiler; for copyright see original N4JS source file.

				import 'n4js-runtime'

				function f() {
					var $capturedArgs = arguments;
					var aa = $capturedArgs.length;
					var ab = $capturedArgs[1];
				}
				""";

		// Prepare ResourceSet to contain exportedScript:
		ResourceSet resSet = installExportedScript();

		Script scriptNode = parseHelper.parse(script, toTestProjectURI("A.n4js"), resSet);
		resolveLazyRefs(scriptNode);

		assertCompileResult(scriptNode, moduleWrapped);
	}
}
