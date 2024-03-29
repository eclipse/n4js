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

@RunWith(XtextRunner.class)
@InjectWith(N4JSInjectorProvider.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GHOLD_184_TemplateStringTest extends AbstractTranspilerTest {

	@Test
	public void test_Compile() throws Throwable {

		String script = """
				var foo = `\\n party`;
				var bar = "\\n party";
				console.log(foo === bar); //should be true but is false

				var foo2 = `"${bar}"`
				var bar2 = '"\\n party"';
				""";

		String moduleWrapped = """
				// Generated by N4JS transpiler; for copyright see original N4JS source file.

				import 'n4js-runtime'

				var foo = "\\n party";
				var bar = "\\n party";
				console.log(foo === bar);
				var foo2 = ("\\""+bar+"\\"");
				var bar2 = '"\\n party"';
				""";

		// Prepare ResourceSet to contain exportedScript:
		ResourceSet resSet = installExportedScript();

		Script scriptNode = parseHelper.parse(script, toTestProjectURI("A.n4js"), resSet);
		resolveLazyRefs(scriptNode);

		assertCompileResult(scriptNode, moduleWrapped);
	}

}
