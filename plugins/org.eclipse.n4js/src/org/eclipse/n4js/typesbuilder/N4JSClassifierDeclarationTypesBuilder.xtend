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
package org.eclipse.n4js.typesbuilder

import com.google.inject.Inject
import org.eclipse.n4js.n4JS.GenericDeclaration
import org.eclipse.n4js.n4JS.N4ClassifierDeclaration
import org.eclipse.n4js.n4JS.N4ClassifierDefinition
import org.eclipse.n4js.n4JS.N4FieldDeclaration
import org.eclipse.n4js.n4JS.N4GetterDeclaration
import org.eclipse.n4js.n4JS.N4MethodDeclaration
import org.eclipse.n4js.n4JS.N4SetterDeclaration
import org.eclipse.n4js.ts.types.TClassifier

/**
 * Abstract base class for N4JSClassDeclarationTypesBuilder and N4JSInterfaceDeclarationTypesBuilder
 * to provide reusable bits and pieces.
 */
package abstract class N4JSClassifierDeclarationTypesBuilder {
	
	@Inject protected extension N4JSTypesBuilderHelper
	@Inject protected extension N4JSFieldTypesBuilder
	@Inject protected extension N4JSMethodTypesBuilder
	@Inject protected extension N4JSGetterTypesBuilder
	@Inject protected extension N4JSSetterTypesBuilder
	
	def protected void addFields(TClassifier classifier, N4ClassifierDefinition definition, boolean preLinkingPhase) {
		val n4Fields = definition.ownedMembers.filter(N4FieldDeclaration);
		val fields = n4Fields.map[createField(classifier, preLinkingPhase)].filterNull
		classifier.ownedMembers.addAll(fields);
	}
	
	def protected void addMethods(TClassifier classifier, N4ClassifierDefinition definition, boolean preLinkingPhase) {
		val n4Methods = definition.ownedMembers.filter(N4MethodDeclaration);
		val methods = n4Methods.map[createMethod(preLinkingPhase)].filterNull; 
		classifier.ownedMembers.addAll(methods);
		classifier.callableCtor = definition.ownedCallableCtor?.createMethod(preLinkingPhase);
	}
	
	def protected void addGetters(TClassifier classifier, N4ClassifierDefinition definition, boolean preLinkingPhase) {
		// create also getters for all non private fields without explicit getter
		val n4Getters = definition.ownedMembers.filter(N4GetterDeclaration)
		val getters = n4Getters.map[createGetter(classifier, preLinkingPhase)].filterNull
		classifier.ownedMembers.addAll(getters);
	}

	def protected void addSetters(TClassifier classifier, N4ClassifierDefinition definition, boolean preLinkingPhase) {
		// create also getters for all non private fields without explicit getter
		val n4Setters = definition.ownedMembers.filter(N4SetterDeclaration)
		val setters = n4Setters.map[createSetter(classifier, preLinkingPhase)].filterNull
		classifier.ownedMembers.addAll(setters);
	}
	
	def protected void addTypeParameters(TClassifier classifier, GenericDeclaration decl, boolean preLinkingPhase) {
		addCopyOfReferences(classifier.typeVars, decl.typeVars)
	}
	
	def package void linkClassifierAndMembers(TClassifier classifier, N4ClassifierDeclaration declaration, boolean preLinkingPhase) {
		ensureEqualName(declaration, classifier);

		// members
		var memberIdx = classifier.linkFields(declaration, preLinkingPhase, 0);
		memberIdx = classifier.linkMethods(declaration, preLinkingPhase, memberIdx);
		memberIdx = classifier.linkGetters(declaration, preLinkingPhase, memberIdx);
		memberIdx = classifier.linkSetters(declaration, preLinkingPhase, memberIdx);

		// TODO proxy resolve vs setter invocation?
		classifier.astElement = declaration;
		// setter is ok here
		declaration.definedType = classifier;
	}
	
	def protected int linkFields(TClassifier classifier, N4ClassifierDefinition definition, boolean preLinkingPhase, int start) {
		return definition.ownedMembers.filter(N4FieldDeclaration).fold(start) [ idx, fld |
			if (linkField(fld, classifier, preLinkingPhase, idx)) {
				return idx + 1
			}
			return idx
		]
	}

	def protected int linkMethods(TClassifier classifier, N4ClassifierDefinition definition, boolean preLinkingPhase, int start) {
		var int result = definition.ownedMembers.filter(N4MethodDeclaration).fold(start) [ idx, method |
			if (linkMethod(method, classifier, preLinkingPhase, idx)) {
				return idx + 1
			}
			return idx
		]
		if (definition.ownedCallableCtor !== null && linkMethod(definition.ownedCallableCtor, classifier, preLinkingPhase, result)) {
			result++;
		}
		return result;
	}

	def protected int linkGetters(TClassifier classifier, N4ClassifierDefinition definition, boolean preLinkingPhase, int start) {
		return definition.ownedMembers.filter(N4GetterDeclaration).fold(start) [ idx, getter |
			if (linkGetter(getter, classifier, preLinkingPhase, idx)) {
				return idx + 1
			}
			return idx
		]
	}

	def protected int linkSetters(TClassifier classifier, N4ClassifierDefinition definition, boolean preLinkingPhase, int start) {
		return definition.ownedMembers.filter(N4SetterDeclaration).fold(start) [ idx, setter |
			if (linkSetter(setter, classifier, preLinkingPhase, idx)) {
				return idx + 1
			}
			return idx
		]
	}
	
}