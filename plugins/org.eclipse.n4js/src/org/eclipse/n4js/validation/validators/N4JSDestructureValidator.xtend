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

import com.google.common.base.Optional
import com.google.inject.Inject
import java.util.Map
import java.util.Set
import java.util.concurrent.atomic.AtomicReference
import org.eclipse.emf.ecore.EObject
import org.eclipse.n4js.n4JS.ArrayBindingPattern
import org.eclipse.n4js.n4JS.ArrayLiteral
import org.eclipse.n4js.n4JS.AssignmentExpression
import org.eclipse.n4js.n4JS.BindingPattern
import org.eclipse.n4js.n4JS.BindingProperty
import org.eclipse.n4js.n4JS.DestructNode
import org.eclipse.n4js.n4JS.DestructureUtils
import org.eclipse.n4js.n4JS.ForStatement
import org.eclipse.n4js.n4JS.N4JSPackage
import org.eclipse.n4js.n4JS.ObjectBindingPattern
import org.eclipse.n4js.n4JS.ObjectLiteral
import org.eclipse.n4js.n4JS.PropertyNameValuePair
import org.eclipse.n4js.n4JS.VariableBinding
import org.eclipse.n4js.scoping.utils.AbstractDescriptionWithError
import org.eclipse.n4js.ts.typeRefs.TypeRef
import org.eclipse.n4js.ts.typeRefs.TypeRefsFactory
import org.eclipse.n4js.ts.types.PrimitiveType
import org.eclipse.n4js.types.utils.TypeUtils
import org.eclipse.n4js.typesystem.N4JSTypeSystem
import org.eclipse.n4js.typesystem.utils.RuleEnvironment
import org.eclipse.n4js.typesystem.utils.RuleEnvironmentExtensions
import org.eclipse.n4js.utils.DestructureHelper
import org.eclipse.n4js.validation.AbstractN4JSDeclarativeValidator
import org.eclipse.n4js.validation.IssueCodes
import org.eclipse.n4js.validation.IssueItem
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static org.eclipse.n4js.validation.IssueCodes.*

import static extension org.eclipse.n4js.n4JS.DestructNode.arePositional
import static extension org.eclipse.n4js.typesystem.utils.RuleEnvironmentExtensions.*
import static extension org.eclipse.n4js.utils.UtilN4.trimPrefix
import static extension org.eclipse.n4js.utils.UtilN4.trimSuffix

/**
 * Validations within destructuring patterns.
 */
class N4JSDestructureValidator extends AbstractN4JSDeclarativeValidator {

	@Inject
	private N4JSTypeSystem ts;
	@Inject
	private DestructureHelper destructureHelper;


	/**
	 * NEEEDED
	 *
	 * when removed check methods will be called twice once by N4JSValidator, and once by
	 * AbstractDeclarativeN4JSValidator
	 */
	override register(EValidatorRegistrar registrar) {
		// nop
	}


	@Check
	def public void checkNoEmptyPattern_Binding(BindingPattern pattern) {
		val isEmpty = switch(pattern) {
			ArrayBindingPattern: pattern.elements.empty
			ObjectBindingPattern: pattern.properties.empty
		};
		if(isEmpty) {
			addIssue(pattern, IssueCodes.DESTRUCT_EMPTY_PATTERN.toIssueItem());
		}
	}

	@Check
	def public void checkNoEmptyPattern_Assignment(AssignmentExpression expr) {
		if(DestructureUtils.isTopOfDestructuringAssignment(expr)) {
			val lhs = expr.lhs;
			val empty = switch(lhs) {
			ArrayLiteral: lhs.elements.empty
			ObjectLiteral: lhs.propertyAssignments.filter(PropertyNameValuePair).empty
			}
			if(empty) {
				addIssue(lhs, IssueCodes.DESTRUCT_EMPTY_PATTERN.toIssueItem());
			}
		}
	}

	@Check
	def void checkTypesInDestructPatternInVariableBinding(VariableBinding binding) {
		internal_checkDestructPattern(DestructNode.unify(binding), binding);
	}

	@Check
	def void checkTypesInDestructPatternInAssignmentExpression(AssignmentExpression expr) {
		internal_checkDestructPattern(DestructNode.unify(expr), expr);
	}

	@Check
	def void checkTypesInDestructPatternInForInOfStatement(ForStatement stmnt) {
		internal_checkDestructPattern(DestructNode.unify(stmnt), stmnt);
	}

	private def void internal_checkDestructPattern(DestructNode rootNode, EObject contextObject) {
		if(rootNode===null) {
			// not a destructuring pattern
			// (an assignment expression without array/object literal on LHS, a broken AST, etc.)
			// -> ignore
			return;
		}
		val G = RuleEnvironmentExtensions.newRuleEnvironment(contextObject);
		val valueTypePerNode = newHashMap;
		destructureHelper.buildValueTypesMap(G, rootNode, Optional.absent(), valueTypePerNode, contextObject);
		internal_checkDestructNode(G, null, rootNode, null, valueTypePerNode, contextObject);
	}

	/**
	 * @param parentNode
	 *             parent node of {@code node} or <code>null</code> if {@code node} is a root.
	 * @param parentMemberScope
	 *             member scope of parentNode or <code>null</code> if {@code node} is a root.
	 */
	private def void internal_checkDestructNode(RuleEnvironment G, DestructNode parentNode, DestructNode node, IScope parentMemberScope, Map<DestructNode,TypeRef> valueTypePerNode, EObject contextObject) {
		// check currNode
		var isValid = holdsValidPropertyAccessInDestructNode(G, parentNode, node, parentMemberScope, valueTypePerNode)
				&& holdsCorrectTypeInDestructNode(G, parentNode, node, valueTypePerNode);

		// continue with children (but only if node is valid)
		if(isValid && node.nestedNodes!==null && !node.nestedNodes.empty) {
			val valueTypeRef = valueTypePerNode.get(node);
			if(valueTypeRef!==null) {
				val memberScope = createMemberScope(node, valueTypeRef, contextObject);
				for(childNode : node.nestedNodes) {
					if(childNode!==null) {
						internal_checkDestructNode(G, node, childNode, memberScope, valueTypePerNode, contextObject);
					}
				}
			}
		}
	}

	private def boolean holdsValidPropertyAccessInDestructNode(RuleEnvironment G, DestructNode parentNode, DestructNode node, IScope parentMemberScope, Map<DestructNode,TypeRef> valueTypePerNode) {
		if(node.propName!==null && parentMemberScope!==null) {
			// property names in object destructuring patterns constitute a property access without
			// a PropertyAccessExpression in the AST -> make sure property exists & is visible
			val mDescRef = new AtomicReference<AbstractDescriptionWithError>();
			val propTypeRef = destructureHelper.getPropertyTypeForNode(G, valueTypePerNode.get(parentNode), parentMemberScope, node.propName, mDescRef);
			val errMsg = if (mDescRef.get() === null) "" else mDescRef.get().message;
			if(errMsg.length>0) {
				val astElement = node.astElement;
				val issueCode = mDescRef.get().issueCode;
				if (Set.of(VIS_ILLEGAL_MEMBER_ACCESS.name(), VIS_WRONG_READ_WRITE_ACCESS.name()).contains(issueCode)) {
					if (astElement instanceof BindingProperty && !(astElement as BindingProperty).isSingleNameBinding) {
						// handled elsewhere: var {fieldPublic: a, fieldPrivate: b} = cls;
						return true;
					}
					if (astElement instanceof PropertyNameValuePair && (astElement as PropertyNameValuePair).property !== null) {
						// handled elsewhere: {fieldPublic: a, fieldPrivate: b} = cls;
						return true;
					}
				}
			
				val astNodeOfPropName = node.getEObjectAndFeatureForPropName();
				addIssue(astNodeOfPropName.key, astNodeOfPropName.value, DESTRUCT_PROP_WITH_ERROR.toIssueItem(node.propName, errMsg.toString.trim.trimSuffix('.')));
				return false;
			}
			else if(propTypeRef===null) {
				val astNodeOfPropName = node.getEObjectAndFeatureForPropName();
				addIssue(astNodeOfPropName.key, astNodeOfPropName.value, DESTRUCT_PROP_MISSING.toIssueItem(node.propName, valueTypePerNode.get(parentNode)?.typeRefAsString));
				return false;
			}
		}
		return true;
	}

	/**
	 * @param parentNode
	 *             parent node of {@code node} or <code>null</code> if {@code node} is a root.
	 */
	private def boolean holdsCorrectTypeInDestructNode(RuleEnvironment G, DestructNode parentNode, DestructNode node, Map<DestructNode,TypeRef> valueTypePerNode) {
		val valueTypeRef = valueTypePerNode.get(node);
		if(valueTypeRef===null) {
			// valueTypeRef===null is ok, means "no type expectation" or "unknown type"
			return true;
		}
		if(node.varDecl!==null || node.varRef!==null) {
			// binding target is a newly declared or existing variable
			if(node.varDecl!==null && node.varDecl.declaredTypeRefInAST===null) {
				// variable declared within pattern _without_ an explicitly declared type
				// -> ignore this case
				// (such a variable does not introduce any type expectation; instead,
				// its type is inferred from the type of the value to be destructured)
			}
			else {
				// variable declared within pattern _with_ an explicitly declared type OR
				// existing variable referenced from within a pattern
				// -> check if it can hold the corresponding value
				val variableTypeRef = if(node.varDecl!==null) {
					ts.type(G,node.varDecl)
				} else if(node.varRef!==null) {
					ts.type(G,node.varRef)
				};

				// exception case: if we have a defaultExpr AND it is of wrong type
				// -> suppress further checking to avoid confusing duplicate error message
				if(node.defaultExpr!==null) {
					val defaultExprTypeRef = ts.type(G,node.defaultExpr);
					val isOfCorrectType = if(defaultExprTypeRef!==null) ts.subtypeSucceeded(G,defaultExprTypeRef,variableTypeRef);
					if(!isOfCorrectType) {
						return false;
					}
				}

				val result = ts.subtype(G,valueTypeRef,variableTypeRef);
				if(result.failure) {
					val varName = node.varDecl?.name ?: node.varRef?.id?.name ?: "<unnamed>";
					var elemDesc = if(node.isPositional) {
						"at index "+parentNode.nestedNodes.indexOf(node)
					} else {
						"of property '"+node.propName+"'"
					};
					var tsMsg = result.failureMessage.trimPrefix('failed: ').trimSuffix('.');
					val IssueItem issueItem = DESTRUCT_TYPE_ERROR_VAR.toIssueItem(varName, elemDesc, tsMsg);
					if(node.varDecl!==null) {
						addIssue(node.varDecl, N4JSPackage.eINSTANCE.abstractVariable_Name, issueItem)
					} else {
						addIssue(node.varRef, issueItem);
					}
					return false;
				}
			}
		}
		else if(node.nestedNodes!==null) {
			// binding target is a top-level or nested pattern
			// -> assert that we have an Iterable<?> or an Object depending on array/object destructuring
			// (keep consistent with Xsemantics rule 'expectedTypeOfRightSideInVariableBinding' and rule
			// 'expectedTypeOfOperandInAssignmentExpression' that are doing the same thing but on top-level)
			val isPositional = node.nestedNodes.arePositional;
			val expectedTypeRef = if(isPositional) {
				G.iterableTypeRef(TypeRefsFactory.eINSTANCE.createWildcard)
			} else {
				G.objectTypeRef
			};
			val result = ts.subtype(G,valueTypeRef.autoboxIfPrimitive,expectedTypeRef);
			if(result.failure) {
				val patternKind = if(isPositional) {
					if(parentNode!==null) "Nested array" else "Array"
				} else {
					if(parentNode!==null) "Nested object" else "Object"
				};
				var elemDesc = if(parentNode!==null) {
					if(node.isPositional) {
						"destructured value at index "+parentNode.nestedNodes.indexOf(node)
					} else {
						"destructured value of property '"+node.propName+"'"
					}
				} else {
					"a value of type '"+valueTypeRef.typeRefAsString+"'"
				};
				var tsMsg = result.failureMessage.trimPrefix('failed: ').trimSuffix('.');
				val IssueItem issueItem = DESTRUCT_TYPE_ERROR_PATTERN.toIssueItem(patternKind, elemDesc, tsMsg);
				val astElem = node.astElement;
				switch(astElem) {
					PropertyNameValuePair:
						addIssue(astElem, N4JSPackage.eINSTANCE.propertyNameValuePair_Expression, issueItem)
					BindingProperty:
						addIssue(astElem, N4JSPackage.eINSTANCE.bindingProperty_Value, issueItem)
					VariableBinding:
						addIssue(astElem, N4JSPackage.eINSTANCE.variableBinding_Pattern, issueItem)
					AssignmentExpression:
						addIssue(astElem, N4JSPackage.eINSTANCE.assignmentExpression_Lhs, issueItem)
					ForStatement case !astElem.varDeclsOrBindings.empty:
						addIssue(astElem, N4JSPackage.eINSTANCE.variableDeclarationContainer_VarDeclsOrBindings, issueItem)
					ForStatement case astElem.initExpr !== null:
						addIssue(astElem, N4JSPackage.eINSTANCE.forStatement_InitExpr, issueItem)
					ForStatement case astElem.expression !== null:
						addIssue(astElem, N4JSPackage.eINSTANCE.iterationStatement_Expression, issueItem)
					default:
						addIssue(astElem, issueItem)
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * Create a member scope for looking up property names of the <em>children</em> of {@code node}, i.e. the {@code propName}
	 * attribute of the {@code nestedNodes} of {@code node}. Will return <code>null</code> if node does not have nested nodes
	 * or if they are positional (because then property look-up does not make sense).
	 */
	private def IScope createMemberScope(DestructNode node, TypeRef valueTypeRef, EObject contextObject) {
		if(!node.nestedNodes.empty && !node.nestedNodes.arePositional) {
			destructureHelper.createMemberScopeForPropertyAccess(valueTypeRef, contextObject, true); // also check visibility
		} else {
			null
		}
	}

	private def TypeRef autoboxIfPrimitive(TypeRef typeRef) {
		val declType = typeRef.declaredType;
		if(declType instanceof PrimitiveType) {
			if(declType.autoboxedType!==null) {
				return TypeUtils.createTypeRef(declType.autoboxedType);
			}
		}
		return typeRef;
	}
}
