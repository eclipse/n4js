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
package org.eclipse.n4js.tests.typesbuilder;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.last;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.n4js.N4JSInjectorProvider;
import org.eclipse.n4js.n4JS.ExportDeclaration;
import org.eclipse.n4js.n4JS.ExportableElement;
import org.eclipse.n4js.n4JS.N4InterfaceDeclaration;
import org.eclipse.n4js.n4JS.N4Modifier;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.tests.typesbuilder.extensions.ASTStructureAssertionExtension;
import org.eclipse.n4js.tests.typesbuilder.extensions.TypesStructureAssertionExtension;
import org.eclipse.n4js.tests.typesbuilder.utils.AbstractTypesBuilderTest;
import org.eclipse.n4js.ts.types.TInterface;
import org.eclipse.n4js.ts.types.TModule;
import org.eclipse.n4js.ts.types.TypeAccessModifier;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(N4JSInjectorProvider.class)
public class InterfaceWithInterfaceTypesBuilderTest extends AbstractTypesBuilderTest {

	@Inject
	private ASTStructureAssertionExtension astStructX;

	@Inject
	private TypesStructureAssertionExtension typesStructX;

	@Override
	protected boolean enableUserDataCompare() {
		// to check the complete AST just change false to true
		return false;
		// true
	}

	@Test
	public void test() {
		String textFileName = "InterfaceWithInterface.n4js";
		List<? extends Pair<? extends Class<? extends EObject>, String>> expectedTypesNamePairs = List.of(
				Pair.of(TInterface.class, "OtherInterface"),
				Pair.of(TInterface.class, "MyInterface"),
				Pair.of(TInterface.class, "PrivateInterface"),
				Pair.of(TInterface.class, "PublicApiInterface"));

		// currently everything is exported to user data and Xtext index, e.g. to be able to
		// use in IDE "Open Type"
		List<? extends Pair<? extends Class<? extends EObject>, String>> expectedExportedTypeToNamePairsOnIndex = List
				.of(
						Pair.of(TModule.class, getQualifiedNamePrefix() + "InterfaceWithInterface"),
						Pair.of(TInterface.class, "OtherInterface"),
						Pair.of(TInterface.class, "MyInterface"),
						Pair.of(TInterface.class, "PrivateInterface"),
						Pair.of(TInterface.class, "PublicApiInterface"));
		int expectedTypesCount = expectedTypesNamePairs.size();
		int expectedExportedElementsCount = expectedExportedTypeToNamePairsOnIndex.size();
		executeTest(textFileName, expectedExportedTypeToNamePairsOnIndex, expectedTypesCount,
				expectedExportedElementsCount);
	}

	@Override
	public String getExpectedTypesSerialization() {
		return """
				TModule {

				}
				""";
	}

	@Override
	public void assertExampleTypeStructure(String phase, Resource newN4jsResource) {
		assertEquals("AST and TModule as root", 2, newN4jsResource.getContents().size());

		TInterface firstInterface = typesStructX.assertTInterface(phase, newN4jsResource, "OtherInterface", 0);

		// TODO to be supported in the next Sprint
		// assertAnnotations(phase, firstInterface, newN4jsResource, )

		typesStructX.assertAccessModifier(phase, firstInterface, newN4jsResource, TypeAccessModifier.PROJECT);

		typesStructX.assertSuperInterfaces(phase, firstInterface, newN4jsResource);

		TInterface secondInterface = typesStructX.assertTInterface(phase, newN4jsResource, "MyInterface", 2);

		// TODO to be supported in the next Sprint
		// assertAnnotations(phase, firstInterface, newN4jsResource, )

		typesStructX.assertAccessModifier(phase, secondInterface, newN4jsResource, TypeAccessModifier.PUBLIC);

		typesStructX.assertSuperInterfaces(phase, secondInterface, newN4jsResource, "OtherInterface");

		TInterface privateInterface = typesStructX.assertTInterface(phase, newN4jsResource, "PrivateInterface", 0);

		// TODO to be supported in the next Sprint
		// assertAnnotations(phase, firstInterface, newN4jsResource, )
		typesStructX.assertAccessModifier(phase, privateInterface, newN4jsResource, TypeAccessModifier.PRIVATE);
		typesStructX.assertSuperInterfaces(phase, privateInterface, newN4jsResource);

		TInterface publicApiInterface = typesStructX.assertTInterface(phase, newN4jsResource, "PublicApiInterface", 0);
		// TODO to be supported in the next Sprint
		// assertAnnotations(phase, firstInterface, newN4jsResource, )
		typesStructX.assertAccessModifier(phase, publicApiInterface, newN4jsResource,
				TypeAccessModifier.PUBLIC_INTERNAL);
		typesStructX.assertSuperInterfaces(phase, publicApiInterface, newN4jsResource);
	}

	@Override
	public void assertExampleJSStructure(String phase, Resource resource) {
		assertEquals("AST and TModule as root", 2, resource.getContents().size());

		Script script = astStructX.assertScript(phase, resource, 4);

		ExportableElement firstExportedElement = ((ExportDeclaration) script.getScriptElements().get(0))
				.getExportedElement();

		N4InterfaceDeclaration firstInterface = astStructX.assertN4InterfaceDeclaration(phase, firstExportedElement,
				"OtherInterface", 0);
		// TODO to be supported in the next Sprint
		// assertAnnotations(phase, firstInterface, newN4jsResource, )
		astStructX.assertDeclaredAccessModifier(phase, firstInterface, resource, N4Modifier.UNDEFINED);
		astStructX.assertSuperInterfaces(phase, firstInterface, resource);

		ExportableElement secondExportedElement = astStructX.assertExportDeclaration(phase, script, 1);
		N4InterfaceDeclaration secondInterface = astStructX.assertN4InterfaceDeclaration(phase, secondExportedElement,
				"MyInterface", 2);
		// TODO to be supported in the next Sprint
		// assertAnnotations(phase, firstInterface, newN4jsResource, )
		astStructX.assertDeclaredAccessModifier(phase, secondInterface, resource, N4Modifier.PUBLIC);
		astStructX.assertSuperInterfaces(phase, secondInterface, resource, "OtherInterface");

		ExportableElement thirdExportableElement = (ExportableElement) script.getScriptElements().get(2);
		N4InterfaceDeclaration thirdInterface = astStructX.assertN4InterfaceDeclaration(phase, thirdExportableElement,
				"PrivateInterface", 0);
		// TODO to be supported in the next Sprint
		// assertAnnotations(phase, firstInterface, newN4jsResource, )
		astStructX.assertDeclaredAccessModifier(phase, thirdInterface, resource, N4Modifier.UNDEFINED);
		astStructX.assertSuperInterfaces(phase, thirdInterface, resource);

		ExportableElement forthExportableElement = ((ExportDeclaration) last(script.getScriptElements()))
				.getExportedElement();
		N4InterfaceDeclaration forthInterface = astStructX.assertN4InterfaceDeclaration(phase, forthExportableElement,
				"PublicApiInterface", 0);
		// TODO to be supported in the next Sprint
		// assertAnnotations(phase, firstInterface, newN4jsResource, )
		astStructX.assertDeclaredAccessModifier(phase, forthInterface, resource, N4Modifier.PUBLIC);
		astStructX.assertSuperInterfaces(phase, forthInterface, resource);
	}
}
