/**
 * Copyright (c) 2019 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.xsemantics

import org.eclipse.n4js.N4JSInjectorProviderWithIssueSuppression
import org.eclipse.n4js.n4JS.Script
import org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef
import org.eclipse.n4js.ts.typeRefs.TypeRefsPackage
import org.eclipse.n4js.ts.typeRefs.Wildcard
import org.eclipse.n4js.ts.types.TClass
import org.eclipse.n4js.typesystem.utils.RuleEnvironment
import org.eclipse.n4js.validation.JavaScriptVariant
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

import static extension org.eclipse.n4js.typesystem.utils.RuleEnvironmentExtensions.*

/**
 * Tests for capturing wildcards, i.e. turning {@link Wildcard}s into
 * non-reopened {@link ExistentialTypeRef}s.
 */
@RunWith(XtextRunner)
@InjectWith(N4JSInjectorProviderWithIssueSuppression)
class WildcardAndExistentialTypeRefCaptureTest extends AbstractTypesystemTest {

	private RuleEnvironment G;
	private Script script;
	private TClass A;
	private TClass B;
	private TClass C;
	private TClass List;

	@Before
	def void before() {
		script = createAndValidateScript(JavaScriptVariant.n4js, '''
			class A {}
			class B extends A {}
			class C extends B {}
			class List<T> {}
		''');

		G = script.newRuleEnvironment;

		val types = script.module.topLevelTypes;
		A = types.filter[name=="A"].head as TClass;
		B = types.filter[name=="B"].head as TClass;
		C = types.filter[name=="C"].head as TClass;
		List = types.filter[name=="List"].head as TClass;
		assertNotNull(A);
		assertNotNull(B);
		assertNotNull(C);
		assertNotNull(List);
	}

	@Test
	def void testMustNotCaptureWildcardsContainedInUpperBoundsOfWildcard() {
		val typeRef = List.of(wildcardExtends(List.of(wildcard))); // List<? extends List<?>>>
		val typeRefCaptured = ts.substTypeVariablesWithCapture(G, typeRef);

		// the higher-level wildcard must have been captured
		val typeArg1 = (typeRefCaptured as ParameterizedTypeRef).typeArgs.get(0);
		assertEquals("higher-level type argument should be an ExistentialTypeRef", TypeRefsPackage.eINSTANCE.existentialTypeRef, typeArg1.eClass);
		assertFalse("higher-level type argument should be closed, i.e. not reopened", (typeArg1 as ExistentialTypeRef).reopened);
		// the lower-level wildcard must *not* have been captured
		val upperBoundOfTypeArg1 = (typeArg1 as ExistentialTypeRef).wildcard.declaredUpperBound;
		val typeArg2 = (upperBoundOfTypeArg1 as ParameterizedTypeRef).typeArgs.get(0);
		assertEquals("lower-level type argument should still be a wildcard", TypeRefsPackage.eINSTANCE.wildcard, typeArg2.eClass);
	}

	@Test
	def void testMustNotCaptureWildcardsContainedInLowerBoundsOfWildcard() {
		val typeRef = List.of(wildcardSuper(List.of(wildcard))); // List<? super List<?>>>
		val typeRefCaptured = ts.substTypeVariablesWithCapture(G, typeRef);

		// the higher-level wildcard must have been captured
		val typeArg1 = (typeRefCaptured as ParameterizedTypeRef).typeArgs.get(0);
		assertEquals("higher-level type argument should be an ExistentialTypeRef", TypeRefsPackage.eINSTANCE.existentialTypeRef, typeArg1.eClass);
		assertFalse("higher-level type argument should be closed, i.e. not reopened", (typeArg1 as ExistentialTypeRef).reopened);
		// the lower-level wildcard must *not* have been captured
		val lowerBoundOfTypeArg1 = (typeArg1 as ExistentialTypeRef).wildcard.declaredLowerBound;
		val typeArg2 = (lowerBoundOfTypeArg1 as ParameterizedTypeRef).typeArgs.get(0);
		assertEquals("lower-level type argument should still be a wildcard", TypeRefsPackage.eINSTANCE.wildcard, typeArg2.eClass);
	}
}
