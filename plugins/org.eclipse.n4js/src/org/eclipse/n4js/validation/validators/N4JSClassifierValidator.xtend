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
package org.eclipse.n4js.validation.validators

import com.google.common.collect.Multimaps
import com.google.inject.Inject
import java.util.Collection
import java.util.HashMap
import java.util.List
import org.eclipse.emf.ecore.EReference
import org.eclipse.n4js.n4JS.N4ClassDefinition
import org.eclipse.n4js.n4JS.N4ClassifierDeclaration
import org.eclipse.n4js.n4JS.N4ClassifierDefinition
import org.eclipse.n4js.n4JS.N4InterfaceDeclaration
import org.eclipse.n4js.n4JS.N4JSPackage
import org.eclipse.n4js.n4JS.N4TypeVariable
import org.eclipse.n4js.n4JS.Script
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef
import org.eclipse.n4js.ts.typeRefs.TypeRefsPackage
import org.eclipse.n4js.ts.typeRefs.Wildcard
import org.eclipse.n4js.ts.types.SyntaxRelatedTElement
import org.eclipse.n4js.ts.types.TClass
import org.eclipse.n4js.ts.types.TClassifier
import org.eclipse.n4js.ts.types.TGetter
import org.eclipse.n4js.ts.types.TInterface
import org.eclipse.n4js.ts.types.TMember
import org.eclipse.n4js.ts.types.TSetter
import org.eclipse.n4js.ts.types.TypeVariable
import org.eclipse.n4js.ts.types.TypesPackage
import org.eclipse.n4js.ts.types.util.Variance
import org.eclipse.n4js.types.utils.TypeUtils
import org.eclipse.n4js.typesystem.N4JSTypeSystem
import org.eclipse.n4js.utils.N4JSLanguageUtils
import org.eclipse.n4js.validation.AbstractN4JSDeclarativeValidator
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.util.Pair
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static org.eclipse.n4js.validation.IssueCodes.*

import static extension org.eclipse.n4js.typesystem.utils.RuleEnvironmentExtensions.*

/**
 * Validation of rules that apply to all classifiers w/o examining members of the classifiers.<p>
 */
class N4JSClassifierValidator extends AbstractN4JSDeclarativeValidator {

	@Inject
	private extension IQualifiedNameProvider qualifiedNameProvider;
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter
	@Inject
	private N4JSTypeSystem ts;

	/**
	 * NEEEDED
	 *
	 * when removed check methods will be called twice once by N4JSValidator, and once by
	 * AbstractDeclarativeN4JSValidator
	 */
	override register(EValidatorRegistrar registrar) {
		// nop
	}

	/**
	 * Constraints 38.3: Wildcards may not be used as type argument when binding a supertype’s type parameters.
	 */
	@Check
	def checkWildcardInExtendsImplements(N4ClassifierDefinition n4ClassifierDef) {
		val superTypeRefs = switch(n4ClassifierDef) {
			N4ClassDefinition: #[ n4ClassifierDef.superClassRef ] + n4ClassifierDef.implementedInterfaceRefs
			N4InterfaceDeclaration: n4ClassifierDef.superInterfaceRefs
		}.filterNull.map[typeRefInAST].filterNull;
		for(typeRefInAST : superTypeRefs) {
			for(typeArgInAST : typeRefInAST.declaredTypeArgs) {
				if(typeArgInAST instanceof Wildcard) {
					addIssue(getMessageForCLF_IMPLEMENT_EXTEND_WITH_WILDCARD, typeArgInAST, CLF_IMPLEMENT_EXTEND_WITH_WILDCARD);
				}
			}
		}
	}

	/**
	 * Constraints 32 (Consuming Roles)
	 */
	@Check
	def checkConsumingRoles(N4ClassifierDefinition n4ClassifierDefinition) {

		// some preparations common for all the below checks
		val tClassifier = n4ClassifierDefinition.definedType as TClassifier
		if (tClassifier === null) {
			return;
		}

		// check
		tClassifier.internalCheckDuplicatedConsumedInterfaces
	}


	/**
	 * Delegates further to perform check if classifier is {@link TClass} or {@link TInterface}
	 * otherwise does nothing
	 */
	def private internalCheckDuplicatedConsumedInterfaces(TClassifier classifier) {

		switch classifier {
			TClass:
				classifier.implementedInterfaceRefs.map[declaredType?.fullyQualifiedName].filterNull.toList.
					doInternalCheckDuplicatedConsumedRoles(classifier,
						N4JSPackage.Literals.N4_CLASS_DEFINITION__IMPLEMENTED_INTERFACE_REFS)
			TInterface:
				classifier.superInterfaceRefs.map[declaredType?.fullyQualifiedName].filterNull.toList.
					doInternalCheckDuplicatedConsumedRoles(classifier,
						N4JSPackage.Literals.N4_INTERFACE_DECLARATION__SUPER_INTERFACE_REFS)
			default:
				return
		}
	}

	def private doInternalCheckDuplicatedConsumedRoles(List<QualifiedName> names, SyntaxRelatedTElement source,
		EReference eref) {

		if (names.nullOrEmpty) return;

		val duplicates = names.map[qualifiedNameConverter.toString(it)].computeStringOccurance.filter[value > 1]

		for (dupe : duplicates) {
			val message = getMessageForCLF_MULTIPLE_ROLE_CONSUME(dupe.key)
			addIssue(message, source.astElement, eref, CLF_MULTIPLE_ROLE_CONSUME)
		}
	}

	/**
	 * Computes occurrence of every String in the Collection.
	 * Returns Iterable&lt;Pair&lt;String, Integer>>, where {@link Pair} keys are
	 * items of original collection and values are number of occurrences in collection
	 */
	def static private computeStringOccurance(Collection<String> collection) {

		var acc = new HashMap<String, Integer>()

		for (entry : collection) {
			if (acc.containsKey(entry)) {
				acc.put(entry, acc.get(entry).intValue + 1)
			} else {
				acc.put(entry, 1)
			}
		}

		val finalAcc = acc
		return acc.keySet.map[it -> finalAcc.get(it)]
	}

	/**
	 * @see N4JSSpec, 4.18. Members, Constraints 33 (Member Names)
	 */
	@Check
	def checkUniqueOwenedMemberNames(N4ClassifierDefinition n4ClassifierDefinition) {

		// wrong parsed
		if (!(n4ClassifierDefinition.definedType instanceof TClassifier)) {
			return
		}

		val tClassifier = n4ClassifierDefinition.definedType as TClassifier

		val ownedMembersByNameAndStatic = Multimaps.index(tClassifier.ownedMembers, [Tuples.pair(name, static)]).asMap();
		ownedMembersByNameAndStatic.values.forEach [
			if (size() > 1) {
				createErrorsForDuplicateOwnedMembers(it)
				// IDEBUG-332:
				// not done yet; in a list like #[ TGetter, TSetter, TSetter ] we will miss error messages for the
				// two setters, because method #createErrorsForDuplicateOwnedMembers() compares all tail elements to
				// the head so it sees just getter/setter pairs (which are legal, see call to #isFieldAccessorPair() below)
				if(it.head instanceof TGetter)
					createErrorsForDuplicateOwnedMembers(it.filter(TSetter))
				else if(it.head instanceof TSetter)
					createErrorsForDuplicateOwnedMembers(it.filter(TGetter))
			}
		]
	}

	/**
	 * Assumes that all TMembers in argument 'members' have the same name and will create error messages for them,
	 * except for getter/setter pairs.
	 */
	def private void createErrorsForDuplicateOwnedMembers(Iterable<? extends TMember> members) {
		val firstDup = members.head;
		var createErrorForFirst = true;
		for (TMember otherDup : members.tail) {
			if (! isFieldAccessorPair(firstDup, otherDup)) {
				if (firstDup.constructor) {
					if (createErrorForFirst) {
						val message = getMessageForCLF_DUP_CTOR(
							NodeModelUtils::getNode(firstDup.astElement).startLine,
							NodeModelUtils::getNode(otherDup.astElement).startLine
						);
						addIssue(message, firstDup.astElement, N4JSPackage.Literals.PROPERTY_NAME_OWNER__DECLARED_NAME,
							CLF_DUP_CTOR)
						createErrorForFirst = false;
					}
					val message = getMessageForCLF_DUP_CTOR(
						NodeModelUtils::getNode(otherDup.astElement).startLine,
						NodeModelUtils::getNode(firstDup.astElement).startLine);
					addIssue(message, otherDup.astElement, N4JSPackage.Literals.PROPERTY_NAME_OWNER__DECLARED_NAME,
						CLF_DUP_CTOR)
				} else {
					if (createErrorForFirst) {
						val message = getMessageForCLF_DUP_MEMBER(firstDup.descriptionWithLine(),
							otherDup.descriptionWithLine());
						addIssue(message, firstDup.astElement, N4JSPackage.Literals.PROPERTY_NAME_OWNER__DECLARED_NAME,
							CLF_DUP_MEMBER)
						createErrorForFirst = false;
					}
					val message = getMessageForCLF_DUP_MEMBER(otherDup.descriptionWithLine(),
						firstDup.descriptionWithLine());
					addIssue(message, otherDup.astElement, N4JSPackage.Literals.PROPERTY_NAME_OWNER__DECLARED_NAME,
						CLF_DUP_MEMBER)
				}
			}
		}
	}

	@Check
	def void checkTypeParameters(N4ClassifierDeclaration n4ClassifierDecl) {
		if (holdsCorrectTypeParameterOptionality(n4ClassifierDecl)) {
			if (holdsDefaultArgumentsContainValidReferences(n4ClassifierDecl)) {
				holdsDefaultArgumentsComplyToBounds(n4ClassifierDecl);
			}
		}
	}

	def private boolean holdsCorrectTypeParameterOptionality(N4ClassifierDeclaration n4ClassifierDecl) {
		var haveOptional = false;
		for (n4TypeParam : n4ClassifierDecl.typeVars) {
			if (haveOptional && !n4TypeParam.optional) {
				val message = messageForCLF_TYPE_PARAM_MANDATORY_AFTER_OPTIONAL;
				addIssue(message, n4TypeParam, TypesPackage.eINSTANCE.identifiableElement_Name, CLF_TYPE_PARAM_MANDATORY_AFTER_OPTIONAL);
				return false;
			}
			haveOptional = haveOptional || n4TypeParam.optional;
		}
		return true;
	}

	/**
	 * Currently this method only checks for forward references in default arguments (e.g. <code>G&lt;T1=T2,T2=any> {}</code>).
	 * In the future, we might also check for cyclic default arguments.
	 */
	def private boolean holdsDefaultArgumentsContainValidReferences(N4ClassifierDeclaration n4ClassifierDecl) {
		// find forward references to type parameters declared after the current type parameter
		val badTypeVars = n4ClassifierDecl.typeVars.map[definedTypeVariable].filterNull.toSet;
		if (badTypeVars.size < n4ClassifierDecl.typeVars.size) {
			return true; // syntax error
		}
		val forwardReferences = <ParameterizedTypeRef>newArrayList;
		for (n4TypeParam : n4ClassifierDecl.typeVars) {
			val defaultArgInAST = n4TypeParam.getDeclaredDefaultArgumentNode?.typeRefInAST;
			if (defaultArgInAST !== null) {
				TypeUtils.forAllTypeRefs(defaultArgInAST, ParameterizedTypeRef, true, false, null, [ptr|
					val declType = ptr.declaredType;
					if (declType instanceof TypeVariable && badTypeVars.contains(declType)) {
						val isContainedInAST = EcoreUtil2.getContainerOfType(ptr, Script) !== null;
						if (isContainedInAST) {
							forwardReferences.add(ptr);
						}
					}
					return true; // continue with traversal
				], null);
			}
			// from now on, the current type variable may be referenced in the default argument of all following type variables:
			badTypeVars.remove(n4TypeParam.definedTypeVariable);
		}
		// create error markers
		if (!forwardReferences.empty) {
			for (badRef : forwardReferences) {
				val message = messageForCLF_TYPE_PARAM_DEFAULT_REFERENCES_LATER_TYPE_PARAM;
				addIssue(message, badRef, TypeRefsPackage.Literals.PARAMETERIZED_TYPE_REF__DECLARED_TYPE, CLF_TYPE_PARAM_DEFAULT_REFERENCES_LATER_TYPE_PARAM);
			}
			return false;
		}
		return true;
	}

	def private boolean holdsDefaultArgumentsComplyToBounds(N4ClassifierDeclaration n4ClassifierDecl) {
		val G = n4ClassifierDecl.newRuleEnvironment;
		var haveInvalidDefault = false;
		for (n4TypeParam : n4ClassifierDecl.typeVars) {
			if (n4TypeParam.name !== null) {
				val defaultArgInAST = n4TypeParam.getDeclaredDefaultArgumentNode?.typeRefInAST;
				val defaultArg = n4TypeParam.getDeclaredDefaultArgumentNode?.typeRef;
				val ub = n4TypeParam.declaredUpperBound;
				if (defaultArgInAST !== null && defaultArg !== null && ub !== null) {
					val result = ts.subtype(G, defaultArg, ub);
					if (result.failure) {
						val message = getMessageForCLF_TYPE_PARAM_DEFAULT_NOT_SUBTYPE_OF_BOUND(n4TypeParam.name, result.compiledFailureMessage);
						addIssue(message, n4TypeParam, N4JSPackage.Literals.N4_TYPE_VARIABLE__DECLARED_DEFAULT_ARGUMENT_NODE, CLF_TYPE_PARAM_DEFAULT_NOT_SUBTYPE_OF_BOUND);
						haveInvalidDefault = true;
					}
				}
			}
		}
		return !haveInvalidDefault;
	}

	@Check
	def void checkUseOfDefinitionSiteVariance(N4TypeVariable n4TypeVar) {
		if((n4TypeVar.declaredCovariant || n4TypeVar.declaredContravariant) &&
			!(n4TypeVar.eContainer instanceof N4ClassifierDeclaration
				&& n4TypeVar.eContainmentFeature===N4JSPackage.eINSTANCE.genericDeclaration_TypeVars)) {
			val message = messageForCLF_DEF_SITE_VARIANCE_ONLY_IN_CLASSIFIER;
			val feature = if(n4TypeVar.declaredCovariant) {
				N4JSPackage.eINSTANCE.n4TypeVariable_DeclaredCovariant
			} else {
				N4JSPackage.eINSTANCE.n4TypeVariable_DeclaredContravariant
			};
			addIssue(message, n4TypeVar, feature, CLF_DEF_SITE_VARIANCE_ONLY_IN_CLASSIFIER);
		}
	}

	/**
	 * Ensures that type variables declared as covariant only appear in covariant positions and type variables declared
	 * as contravariant only appear in contravariant positions. Type variables declared to be invariant do not require
	 * such a check.
	 */
	@Check
	def void checkTypeVariableVariance(ParameterizedTypeRef typeRefInAST) {
		val tv = typeRefInAST.declaredType;
		if(tv instanceof TypeVariable) {
			val variance = tv.variance;
			if(variance!==Variance.INV) {
				val varianceOfPos = N4JSLanguageUtils.getVarianceOfPosition(typeRefInAST);
				if(varianceOfPos!==null && variance!==varianceOfPos) {
					val msg = getMessageForCLF_TYPE_VARIABLE_AT_INVALID_POSITION(variance.getDescriptiveString(true),
						varianceOfPos.getDescriptiveString(false));
					addIssue(msg, typeRefInAST, CLF_TYPE_VARIABLE_AT_INVALID_POSITION);
				}
			}
		}
	}
}
