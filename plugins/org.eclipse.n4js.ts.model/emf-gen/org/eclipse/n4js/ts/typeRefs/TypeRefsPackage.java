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
package org.eclipse.n4js.ts.typeRefs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  * Contributors:
 *   NumberFour AG - Initial API and implementation
 * <!-- end-model-doc -->
 * @see org.eclipse.n4js.ts.typeRefs.TypeRefsFactory
 * @model kind="package"
 * @generated
 */
public interface TypeRefsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "typeRefs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/n4js/ts/TypeRefs";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "typeRefs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypeRefsPackage eINSTANCE = org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.TypeArgumentImpl <em>Type Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeArgumentImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getTypeArgument()
	 * @generated
	 */
	int TYPE_ARGUMENT = 0;

	/**
	 * The number of structural features of the '<em>Type Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT___IS_TYPE_REF = 0;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT___GET_DECLARED_TYPE = 1;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT___GET_TYPE_REF_AS_STRING = 2;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT___INTERNAL_GET_TYPE_REF_AS_STRING = 3;

	/**
	 * The number of operations of the '<em>Type Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.TypeRefImpl <em>Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getTypeRef()
	 * @generated
	 */
	int TYPE_REF = 1;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF__FOLLOWED_BY_QUESTION_MARK = TYPE_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = TYPE_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_FEATURE_COUNT = TYPE_ARGUMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_DECLARED_TYPE = TYPE_ARGUMENT___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_MODIFIERS_AS_STRING = TYPE_ARGUMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_TYPE_REF = TYPE_ARGUMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_ALIAS_UNRESOLVED = TYPE_ARGUMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_ALIAS_RESOLVED = TYPE_ARGUMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_FINAL_BY_TYPE = TYPE_ARGUMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_ARRAY_LIKE = TYPE_ARGUMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_UNKNOWN = TYPE_ARGUMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_DYNAMIC = TYPE_ARGUMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_EXISTENTIAL = TYPE_ARGUMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_GENERIC = TYPE_ARGUMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_PARAMETERIZED = TYPE_ARGUMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_RAW = TYPE_ARGUMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_DECLARED_UPPER_BOUND = TYPE_ARGUMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_DECLARED_LOWER_BOUND = TYPE_ARGUMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_DECLARED_TYPE_ARGS = TYPE_ARGUMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = TYPE_ARGUMENT_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_TYPE_REF_AS_STRING = TYPE_ARGUMENT_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = TYPE_ARGUMENT_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_ARGUMENT_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___TO_STRING = TYPE_ARGUMENT_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_TOP_TYPE = TYPE_ARGUMENT_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_BOTTOM_TYPE = TYPE_ARGUMENT_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_TYPING_STRATEGY = TYPE_ARGUMENT_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_STRUCTURAL_MEMBERS = TYPE_ARGUMENT_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_STRUCTURAL_TYPING = TYPE_ARGUMENT_OPERATION_COUNT + 24;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = TYPE_ARGUMENT_OPERATION_COUNT + 25;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = TYPE_ARGUMENT_OPERATION_COUNT + 26;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = TYPE_ARGUMENT_OPERATION_COUNT + 27;

	/**
	 * The number of operations of the '<em>Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_OPERATION_COUNT = TYPE_ARGUMENT_OPERATION_COUNT + 28;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.BaseTypeRefImpl <em>Base Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.BaseTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getBaseTypeRef()
	 * @generated
	 */
	int BASE_TYPE_REF = 2;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF__DYNAMIC = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Base Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_DECLARED_TYPE = TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_TYPE_REF = TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_ALIAS_UNRESOLVED = TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_ALIAS_RESOLVED = TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_FINAL_BY_TYPE = TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_ARRAY_LIKE = TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_UNKNOWN = TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_DYNAMIC = TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_EXISTENTIAL = TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_GENERIC = TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_PARAMETERIZED = TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_RAW = TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_DECLARED_UPPER_BOUND = TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_DECLARED_LOWER_BOUND = TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_DECLARED_TYPE_ARGS = TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_TYPE_REF_AS_STRING = TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___TO_STRING = TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_TOP_TYPE = TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_BOTTOM_TYPE = TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_TYPING_STRATEGY = TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_STRUCTURAL_MEMBERS = TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_STRUCTURAL_TYPING = TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF___GET_MODIFIERS_AS_STRING = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_REF_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ComposedTypeRefImpl <em>Composed Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.ComposedTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getComposedTypeRef()
	 * @generated
	 */
	int COMPOSED_TYPE_REF = 3;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Type Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF__TYPE_REFS = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composed Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_DECLARED_TYPE = TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_MODIFIERS_AS_STRING = TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_TYPE_REF = TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_ALIAS_UNRESOLVED = TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_ALIAS_RESOLVED = TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_FINAL_BY_TYPE = TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_ARRAY_LIKE = TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_UNKNOWN = TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_EXISTENTIAL = TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_GENERIC = TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_PARAMETERIZED = TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_RAW = TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_DECLARED_UPPER_BOUND = TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_DECLARED_LOWER_BOUND = TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_DECLARED_TYPE_ARGS = TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_TYPE_REF_AS_STRING = TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___TO_STRING = TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_TOP_TYPE = TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_BOTTOM_TYPE = TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_TYPING_STRATEGY = TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_STRUCTURAL_MEMBERS = TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_STRUCTURAL_TYPING = TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___IS_DYNAMIC = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composed Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TYPE_REF_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.UnionTypeExpressionImpl <em>Union Type Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.UnionTypeExpressionImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getUnionTypeExpression()
	 * @generated
	 */
	int UNION_TYPE_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION__FOLLOWED_BY_QUESTION_MARK = COMPOSED_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION__ORIGINAL_ALIAS_TYPE_REF = COMPOSED_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Type Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION__TYPE_REFS = COMPOSED_TYPE_REF__TYPE_REFS;

	/**
	 * The number of structural features of the '<em>Union Type Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION_FEATURE_COUNT = COMPOSED_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_DECLARED_TYPE = COMPOSED_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_MODIFIERS_AS_STRING = COMPOSED_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_TYPE_REF = COMPOSED_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_ALIAS_UNRESOLVED = COMPOSED_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_ALIAS_RESOLVED = COMPOSED_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_FINAL_BY_TYPE = COMPOSED_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_ARRAY_LIKE = COMPOSED_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_UNKNOWN = COMPOSED_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_EXISTENTIAL = COMPOSED_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_GENERIC = COMPOSED_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_PARAMETERIZED = COMPOSED_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_RAW = COMPOSED_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_DECLARED_UPPER_BOUND = COMPOSED_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_DECLARED_LOWER_BOUND = COMPOSED_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_DECLARED_TYPE_ARGS = COMPOSED_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_TYPE_ARGS_WITH_DEFAULTS = COMPOSED_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_TYPE_REF_AS_STRING = COMPOSED_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = COMPOSED_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___TO_STRING = COMPOSED_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_TOP_TYPE = COMPOSED_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_BOTTOM_TYPE = COMPOSED_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_TYPING_STRATEGY = COMPOSED_TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_STRUCTURAL_MEMBERS = COMPOSED_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_STRUCTURAL_TYPING = COMPOSED_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_USE_SITE_STRUCTURAL_TYPING = COMPOSED_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_DEF_SITE_STRUCTURAL_TYPING = COMPOSED_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = COMPOSED_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___IS_DYNAMIC = COMPOSED_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION___INTERNAL_GET_TYPE_REF_AS_STRING = COMPOSED_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Union Type Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_EXPRESSION_OPERATION_COUNT = COMPOSED_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.IntersectionTypeExpressionImpl <em>Intersection Type Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.IntersectionTypeExpressionImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getIntersectionTypeExpression()
	 * @generated
	 */
	int INTERSECTION_TYPE_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION__FOLLOWED_BY_QUESTION_MARK = COMPOSED_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION__ORIGINAL_ALIAS_TYPE_REF = COMPOSED_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Type Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION__TYPE_REFS = COMPOSED_TYPE_REF__TYPE_REFS;

	/**
	 * The number of structural features of the '<em>Intersection Type Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION_FEATURE_COUNT = COMPOSED_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_DECLARED_TYPE = COMPOSED_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_MODIFIERS_AS_STRING = COMPOSED_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_TYPE_REF = COMPOSED_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_ALIAS_UNRESOLVED = COMPOSED_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_ALIAS_RESOLVED = COMPOSED_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_FINAL_BY_TYPE = COMPOSED_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_ARRAY_LIKE = COMPOSED_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_UNKNOWN = COMPOSED_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_EXISTENTIAL = COMPOSED_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_GENERIC = COMPOSED_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_PARAMETERIZED = COMPOSED_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_RAW = COMPOSED_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_DECLARED_UPPER_BOUND = COMPOSED_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_DECLARED_LOWER_BOUND = COMPOSED_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_DECLARED_TYPE_ARGS = COMPOSED_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_TYPE_ARGS_WITH_DEFAULTS = COMPOSED_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_TYPE_REF_AS_STRING = COMPOSED_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = COMPOSED_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___TO_STRING = COMPOSED_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_TOP_TYPE = COMPOSED_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_BOTTOM_TYPE = COMPOSED_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_TYPING_STRATEGY = COMPOSED_TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_STRUCTURAL_MEMBERS = COMPOSED_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_STRUCTURAL_TYPING = COMPOSED_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_USE_SITE_STRUCTURAL_TYPING = COMPOSED_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_DEF_SITE_STRUCTURAL_TYPING = COMPOSED_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = COMPOSED_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___IS_DYNAMIC = COMPOSED_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION___INTERNAL_GET_TYPE_REF_AS_STRING = COMPOSED_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Intersection Type Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_TYPE_EXPRESSION_OPERATION_COUNT = COMPOSED_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefImpl <em>This Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getThisTypeRef()
	 * @generated
	 */
	int THIS_TYPE_REF = 6;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = BASE_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = BASE_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF__DYNAMIC = BASE_TYPE_REF__DYNAMIC;

	/**
	 * The number of structural features of the '<em>This Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_FEATURE_COUNT = BASE_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_DECLARED_TYPE = BASE_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_TYPE_REF = BASE_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_ALIAS_UNRESOLVED = BASE_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_ALIAS_RESOLVED = BASE_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_FINAL_BY_TYPE = BASE_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_ARRAY_LIKE = BASE_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_UNKNOWN = BASE_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_DYNAMIC = BASE_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_EXISTENTIAL = BASE_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_GENERIC = BASE_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_PARAMETERIZED = BASE_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_RAW = BASE_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_DECLARED_UPPER_BOUND = BASE_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_DECLARED_LOWER_BOUND = BASE_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_DECLARED_TYPE_ARGS = BASE_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = BASE_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_TYPE_REF_AS_STRING = BASE_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = BASE_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___TO_STRING = BASE_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_TOP_TYPE = BASE_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_BOTTOM_TYPE = BASE_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_STRUCTURAL_TYPING = BASE_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = BASE_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = BASE_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_MODIFIERS_AS_STRING = BASE_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = BASE_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_TYPING_STRATEGY = BASE_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___GET_STRUCTURAL_MEMBERS = BASE_TYPE_REF_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = BASE_TYPE_REF_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>This Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_OPERATION_COUNT = BASE_TYPE_REF_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefNominalImpl <em>This Type Ref Nominal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefNominalImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getThisTypeRefNominal()
	 * @generated
	 */
	int THIS_TYPE_REF_NOMINAL = 7;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL__FOLLOWED_BY_QUESTION_MARK = THIS_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL__ORIGINAL_ALIAS_TYPE_REF = THIS_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL__DYNAMIC = THIS_TYPE_REF__DYNAMIC;

	/**
	 * The number of structural features of the '<em>This Type Ref Nominal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL_FEATURE_COUNT = THIS_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_DECLARED_TYPE = THIS_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_TYPE_REF = THIS_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_ALIAS_UNRESOLVED = THIS_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_ALIAS_RESOLVED = THIS_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_FINAL_BY_TYPE = THIS_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_ARRAY_LIKE = THIS_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_UNKNOWN = THIS_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_DYNAMIC = THIS_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_EXISTENTIAL = THIS_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_GENERIC = THIS_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_PARAMETERIZED = THIS_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_RAW = THIS_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_DECLARED_UPPER_BOUND = THIS_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_DECLARED_LOWER_BOUND = THIS_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_DECLARED_TYPE_ARGS = THIS_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_TYPE_ARGS_WITH_DEFAULTS = THIS_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_TYPE_REF_AS_STRING = THIS_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = THIS_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___TO_STRING = THIS_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_TOP_TYPE = THIS_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_BOTTOM_TYPE = THIS_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_STRUCTURAL_TYPING = THIS_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_DEF_SITE_STRUCTURAL_TYPING = THIS_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = THIS_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_MODIFIERS_AS_STRING = THIS_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___INTERNAL_GET_TYPE_REF_AS_STRING = THIS_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_TYPING_STRATEGY = THIS_TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___GET_STRUCTURAL_MEMBERS = THIS_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL___IS_USE_SITE_STRUCTURAL_TYPING = THIS_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The number of operations of the '<em>This Type Ref Nominal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_NOMINAL_OPERATION_COUNT = THIS_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefStructuralImpl <em>This Type Ref Structural</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefStructuralImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getThisTypeRefStructural()
	 * @generated
	 */
	int THIS_TYPE_REF_STRUCTURAL = 8;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL__FOLLOWED_BY_QUESTION_MARK = THIS_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL__ORIGINAL_ALIAS_TYPE_REF = THIS_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL__DYNAMIC = THIS_TYPE_REF__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Ast Structural Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL__AST_STRUCTURAL_MEMBERS = THIS_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structural Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL__STRUCTURAL_TYPE = THIS_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Structural Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL__GEN_STRUCTURAL_MEMBERS = THIS_TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Postponed Substitutions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL__POSTPONED_SUBSTITUTIONS = THIS_TYPE_REF_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Defined Typing Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL__DEFINED_TYPING_STRATEGY = THIS_TYPE_REF_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>This Type Ref Structural</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL_FEATURE_COUNT = THIS_TYPE_REF_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_DECLARED_TYPE = THIS_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_TYPE_REF = THIS_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_ALIAS_UNRESOLVED = THIS_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_ALIAS_RESOLVED = THIS_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_FINAL_BY_TYPE = THIS_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_ARRAY_LIKE = THIS_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_UNKNOWN = THIS_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_DYNAMIC = THIS_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_EXISTENTIAL = THIS_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_GENERIC = THIS_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_PARAMETERIZED = THIS_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_RAW = THIS_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_DECLARED_UPPER_BOUND = THIS_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_DECLARED_LOWER_BOUND = THIS_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_DECLARED_TYPE_ARGS = THIS_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_TYPE_ARGS_WITH_DEFAULTS = THIS_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_TYPE_REF_AS_STRING = THIS_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = THIS_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___TO_STRING = THIS_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_TOP_TYPE = THIS_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_BOTTOM_TYPE = THIS_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_STRUCTURAL_TYPING = THIS_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_DEF_SITE_STRUCTURAL_TYPING = THIS_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = THIS_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_MODIFIERS_AS_STRING = THIS_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Get Structural Members With Call Construct Signatures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_STRUCTURAL_MEMBERS_WITH_CALL_CONSTRUCT_SIGNATURES = THIS_TYPE_REF_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Postponed Substitution For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___HAS_POSTPONED_SUBSTITUTION_FOR__TYPEVARIABLE = THIS_TYPE_REF_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_TYPING_STRATEGY = THIS_TYPE_REF_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Set Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___SET_TYPING_STRATEGY__TYPINGSTRATEGY = THIS_TYPE_REF_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___IS_USE_SITE_STRUCTURAL_TYPING = THIS_TYPE_REF_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___GET_STRUCTURAL_MEMBERS = THIS_TYPE_REF_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL___INTERNAL_GET_TYPE_REF_AS_STRING = THIS_TYPE_REF_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>This Type Ref Structural</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_TYPE_REF_STRUCTURAL_OPERATION_COUNT = THIS_TYPE_REF_OPERATION_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.BoundThisTypeRefImpl <em>Bound This Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.BoundThisTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getBoundThisTypeRef()
	 * @generated
	 */
	int BOUND_THIS_TYPE_REF = 9;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = THIS_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = THIS_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__DYNAMIC = THIS_TYPE_REF__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Ast Structural Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__AST_STRUCTURAL_MEMBERS = THIS_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structural Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__STRUCTURAL_TYPE = THIS_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Structural Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__GEN_STRUCTURAL_MEMBERS = THIS_TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Postponed Substitutions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__POSTPONED_SUBSTITUTIONS = THIS_TYPE_REF_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Actual This Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__ACTUAL_THIS_TYPE_REF = THIS_TYPE_REF_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Defined Typing Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF__DEFINED_TYPING_STRATEGY = THIS_TYPE_REF_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Bound This Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF_FEATURE_COUNT = THIS_TYPE_REF_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_DECLARED_TYPE = THIS_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_TYPE_REF = THIS_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_ALIAS_UNRESOLVED = THIS_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_ALIAS_RESOLVED = THIS_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_FINAL_BY_TYPE = THIS_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_ARRAY_LIKE = THIS_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_UNKNOWN = THIS_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_DYNAMIC = THIS_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_EXISTENTIAL = THIS_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_GENERIC = THIS_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_PARAMETERIZED = THIS_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_RAW = THIS_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_DECLARED_LOWER_BOUND = THIS_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_DECLARED_TYPE_ARGS = THIS_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = THIS_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_TYPE_REF_AS_STRING = THIS_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = THIS_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___TO_STRING = THIS_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_TOP_TYPE = THIS_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_BOTTOM_TYPE = THIS_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_STRUCTURAL_TYPING = THIS_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = THIS_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_MODIFIERS_AS_STRING = THIS_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Get Structural Members With Call Construct Signatures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_STRUCTURAL_MEMBERS_WITH_CALL_CONSTRUCT_SIGNATURES = THIS_TYPE_REF_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Postponed Substitution For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___HAS_POSTPONED_SUBSTITUTION_FOR__TYPEVARIABLE = THIS_TYPE_REF_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_TYPING_STRATEGY = THIS_TYPE_REF_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Set Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___SET_TYPING_STRATEGY__TYPINGSTRATEGY = THIS_TYPE_REF_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = THIS_TYPE_REF_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_DECLARED_UPPER_BOUND = THIS_TYPE_REF_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = THIS_TYPE_REF_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = THIS_TYPE_REF_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF___GET_STRUCTURAL_MEMBERS = THIS_TYPE_REF_OPERATION_COUNT + 11;

	/**
	 * The number of operations of the '<em>Bound This Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_THIS_TYPE_REF_OPERATION_COUNT = THIS_TYPE_REF_OPERATION_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ParameterizedTypeRefImpl <em>Parameterized Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.ParameterizedTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getParameterizedTypeRef()
	 * @generated
	 */
	int PARAMETERIZED_TYPE_REF = 10;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = BASE_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = BASE_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__DYNAMIC = BASE_TYPE_REF__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Declared Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__DECLARED_TYPE = BASE_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Type As Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__DECLARED_TYPE_AS_TEXT = BASE_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Type Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__DECLARED_TYPE_ARGS = BASE_TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Array Type Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__ARRAY_TYPE_EXPRESSION = BASE_TYPE_REF_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Array NType Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__ARRAY_NTYPE_EXPRESSION = BASE_TYPE_REF_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ast Namespace Like Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__AST_NAMESPACE_LIKE_REFS = BASE_TYPE_REF_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>AST Node Optional Field Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__AST_NODE_OPTIONAL_FIELD_STRATEGY = BASE_TYPE_REF_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Defined Typing Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF__DEFINED_TYPING_STRATEGY = BASE_TYPE_REF_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Parameterized Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_FEATURE_COUNT = BASE_TYPE_REF_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_DECLARED_TYPE = BASE_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_TYPE_REF = BASE_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_ALIAS_UNRESOLVED = BASE_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_ALIAS_RESOLVED = BASE_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_FINAL_BY_TYPE = BASE_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_ARRAY_LIKE = BASE_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_UNKNOWN = BASE_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_DYNAMIC = BASE_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_EXISTENTIAL = BASE_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_DECLARED_UPPER_BOUND = BASE_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_DECLARED_LOWER_BOUND = BASE_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_DECLARED_TYPE_ARGS = BASE_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_TYPE_REF_AS_STRING = BASE_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = BASE_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___TO_STRING = BASE_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_TOP_TYPE = BASE_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_BOTTOM_TYPE = BASE_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_STRUCTURAL_MEMBERS = BASE_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_STRUCTURAL_TYPING = BASE_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = BASE_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_MODIFIERS_AS_STRING = BASE_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Get Previous Sibling</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_PREVIOUS_SIBLING__NAMESPACELIKEREF = BASE_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_TYPING_STRATEGY = BASE_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = BASE_TYPE_REF_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = BASE_TYPE_REF_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_PARAMETERIZED = BASE_TYPE_REF_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_GENERIC = BASE_TYPE_REF_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_RAW = BASE_TYPE_REF_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = BASE_TYPE_REF_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = BASE_TYPE_REF_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>Parameterized Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_OPERATION_COUNT = BASE_TYPE_REF_OPERATION_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.StructuralTypeRefImpl <em>Structural Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.StructuralTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getStructuralTypeRef()
	 * @generated
	 */
	int STRUCTURAL_TYPE_REF = 11;

	/**
	 * The feature id for the '<em><b>Ast Structural Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF__AST_STRUCTURAL_MEMBERS = 0;

	/**
	 * The feature id for the '<em><b>Structural Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF__STRUCTURAL_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Gen Structural Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF__GEN_STRUCTURAL_MEMBERS = 2;

	/**
	 * The feature id for the '<em><b>Postponed Substitutions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF__POSTPONED_SUBSTITUTIONS = 3;

	/**
	 * The number of structural features of the '<em>Structural Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF___GET_TYPING_STRATEGY = 0;

	/**
	 * The operation id for the '<em>Set Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF___SET_TYPING_STRATEGY__TYPINGSTRATEGY = 1;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF___GET_STRUCTURAL_MEMBERS = 2;

	/**
	 * The operation id for the '<em>Get Structural Members With Call Construct Signatures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF___GET_STRUCTURAL_MEMBERS_WITH_CALL_CONSTRUCT_SIGNATURES = 3;

	/**
	 * The operation id for the '<em>Has Postponed Substitution For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF___HAS_POSTPONED_SUBSTITUTION_FOR__TYPEVARIABLE = 4;

	/**
	 * The number of operations of the '<em>Structural Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_TYPE_REF_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ParameterizedTypeRefStructuralImpl <em>Parameterized Type Ref Structural</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.ParameterizedTypeRefStructuralImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getParameterizedTypeRefStructural()
	 * @generated
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL = 12;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__FOLLOWED_BY_QUESTION_MARK = PARAMETERIZED_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__ORIGINAL_ALIAS_TYPE_REF = PARAMETERIZED_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__DYNAMIC = PARAMETERIZED_TYPE_REF__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Declared Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__DECLARED_TYPE = PARAMETERIZED_TYPE_REF__DECLARED_TYPE;

	/**
	 * The feature id for the '<em><b>Declared Type As Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__DECLARED_TYPE_AS_TEXT = PARAMETERIZED_TYPE_REF__DECLARED_TYPE_AS_TEXT;

	/**
	 * The feature id for the '<em><b>Declared Type Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__DECLARED_TYPE_ARGS = PARAMETERIZED_TYPE_REF__DECLARED_TYPE_ARGS;

	/**
	 * The feature id for the '<em><b>Array Type Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__ARRAY_TYPE_EXPRESSION = PARAMETERIZED_TYPE_REF__ARRAY_TYPE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Array NType Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__ARRAY_NTYPE_EXPRESSION = PARAMETERIZED_TYPE_REF__ARRAY_NTYPE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Ast Namespace Like Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__AST_NAMESPACE_LIKE_REFS = PARAMETERIZED_TYPE_REF__AST_NAMESPACE_LIKE_REFS;

	/**
	 * The feature id for the '<em><b>AST Node Optional Field Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__AST_NODE_OPTIONAL_FIELD_STRATEGY = PARAMETERIZED_TYPE_REF__AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The feature id for the '<em><b>Defined Typing Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__DEFINED_TYPING_STRATEGY = PARAMETERIZED_TYPE_REF__DEFINED_TYPING_STRATEGY;

	/**
	 * The feature id for the '<em><b>Ast Structural Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__AST_STRUCTURAL_MEMBERS = PARAMETERIZED_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structural Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__STRUCTURAL_TYPE = PARAMETERIZED_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Structural Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__GEN_STRUCTURAL_MEMBERS = PARAMETERIZED_TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Postponed Substitutions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL__POSTPONED_SUBSTITUTIONS = PARAMETERIZED_TYPE_REF_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Parameterized Type Ref Structural</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL_FEATURE_COUNT = PARAMETERIZED_TYPE_REF_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_DECLARED_TYPE = PARAMETERIZED_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_TYPE_REF = PARAMETERIZED_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_ALIAS_UNRESOLVED = PARAMETERIZED_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_ALIAS_RESOLVED = PARAMETERIZED_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_FINAL_BY_TYPE = PARAMETERIZED_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_ARRAY_LIKE = PARAMETERIZED_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_UNKNOWN = PARAMETERIZED_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_DYNAMIC = PARAMETERIZED_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_EXISTENTIAL = PARAMETERIZED_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_DECLARED_UPPER_BOUND = PARAMETERIZED_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_DECLARED_LOWER_BOUND = PARAMETERIZED_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_DECLARED_TYPE_ARGS = PARAMETERIZED_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_TYPE_REF_AS_STRING = PARAMETERIZED_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = PARAMETERIZED_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___TO_STRING = PARAMETERIZED_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_TOP_TYPE = PARAMETERIZED_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_BOTTOM_TYPE = PARAMETERIZED_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_STRUCTURAL_TYPING = PARAMETERIZED_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = PARAMETERIZED_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_MODIFIERS_AS_STRING = PARAMETERIZED_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Get Previous Sibling</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_PREVIOUS_SIBLING__NAMESPACELIKEREF = PARAMETERIZED_TYPE_REF___GET_PREVIOUS_SIBLING__NAMESPACELIKEREF;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_TYPE_ARGS_WITH_DEFAULTS = PARAMETERIZED_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_PARAMETERIZED = PARAMETERIZED_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_GENERIC = PARAMETERIZED_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_RAW = PARAMETERIZED_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_USE_SITE_STRUCTURAL_TYPING = PARAMETERIZED_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___IS_DEF_SITE_STRUCTURAL_TYPING = PARAMETERIZED_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get Structural Members With Call Construct Signatures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_STRUCTURAL_MEMBERS_WITH_CALL_CONSTRUCT_SIGNATURES = PARAMETERIZED_TYPE_REF_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Postponed Substitution For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___HAS_POSTPONED_SUBSTITUTION_FOR__TYPEVARIABLE = PARAMETERIZED_TYPE_REF_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_TYPING_STRATEGY = PARAMETERIZED_TYPE_REF_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Set Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___SET_TYPING_STRATEGY__TYPINGSTRATEGY = PARAMETERIZED_TYPE_REF_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_STRUCTURAL_MEMBERS = PARAMETERIZED_TYPE_REF_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL___INTERNAL_GET_TYPE_REF_AS_STRING = PARAMETERIZED_TYPE_REF_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>Parameterized Type Ref Structural</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_STRUCTURAL_OPERATION_COUNT = PARAMETERIZED_TYPE_REF_OPERATION_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ExistentialTypeRefImpl <em>Existential Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.ExistentialTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getExistentialTypeRef()
	 * @generated
	 */
	int EXISTENTIAL_TYPE_REF = 13;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF__ID = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reopened</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF__REOPENED = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Wildcard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF__WILDCARD = TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Existential Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_DECLARED_TYPE = TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_MODIFIERS_AS_STRING = TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_TYPE_REF = TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_ALIAS_UNRESOLVED = TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_ALIAS_RESOLVED = TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_FINAL_BY_TYPE = TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_ARRAY_LIKE = TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_UNKNOWN = TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_DYNAMIC = TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_RAW = TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_DECLARED_UPPER_BOUND = TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_DECLARED_LOWER_BOUND = TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_DECLARED_TYPE_ARGS = TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_TYPE_REF_AS_STRING = TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___TO_STRING = TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_TOP_TYPE = TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_BOTTOM_TYPE = TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_TYPING_STRATEGY = TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_STRUCTURAL_MEMBERS = TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_STRUCTURAL_TYPING = TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_EXISTENTIAL = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_GENERIC = TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___IS_PARAMETERIZED = TYPE_REF_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_REF_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Existential Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_TYPE_REF_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.UnknownTypeRefImpl <em>Unknown Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.UnknownTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getUnknownTypeRef()
	 * @generated
	 */
	int UNKNOWN_TYPE_REF = 14;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The number of structural features of the '<em>Unknown Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_DECLARED_TYPE = TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_MODIFIERS_AS_STRING = TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_TYPE_REF = TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_ALIAS_UNRESOLVED = TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_ALIAS_RESOLVED = TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_FINAL_BY_TYPE = TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_ARRAY_LIKE = TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_DYNAMIC = TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_EXISTENTIAL = TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_GENERIC = TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_PARAMETERIZED = TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_RAW = TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_DECLARED_UPPER_BOUND = TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_DECLARED_LOWER_BOUND = TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_DECLARED_TYPE_ARGS = TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_TYPE_REF_AS_STRING = TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___TO_STRING = TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_TOP_TYPE = TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_BOTTOM_TYPE = TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_TYPING_STRATEGY = TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_STRUCTURAL_MEMBERS = TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_STRUCTURAL_TYPING = TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___IS_UNKNOWN = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unknown Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_REF_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.TypeTypeRefImpl <em>Type Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getTypeTypeRef()
	 * @generated
	 */
	int TYPE_TYPE_REF = 15;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = BASE_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = BASE_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF__DYNAMIC = BASE_TYPE_REF__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Type Arg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF__TYPE_ARG = BASE_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constructor Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF__CONSTRUCTOR_REF = BASE_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF_FEATURE_COUNT = BASE_TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_DECLARED_TYPE = BASE_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_TYPE_REF = BASE_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_ALIAS_UNRESOLVED = BASE_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_ALIAS_RESOLVED = BASE_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_FINAL_BY_TYPE = BASE_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_ARRAY_LIKE = BASE_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_UNKNOWN = BASE_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_DYNAMIC = BASE_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_EXISTENTIAL = BASE_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_GENERIC = BASE_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_PARAMETERIZED = BASE_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_RAW = BASE_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_DECLARED_UPPER_BOUND = BASE_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_DECLARED_LOWER_BOUND = BASE_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_DECLARED_TYPE_ARGS = BASE_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = BASE_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_TYPE_REF_AS_STRING = BASE_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = BASE_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___TO_STRING = BASE_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_TOP_TYPE = BASE_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_BOTTOM_TYPE = BASE_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_TYPING_STRATEGY = BASE_TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_STRUCTURAL_MEMBERS = BASE_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_STRUCTURAL_TYPING = BASE_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = BASE_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = BASE_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = BASE_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___GET_MODIFIERS_AS_STRING = BASE_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = BASE_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_REF_OPERATION_COUNT = BASE_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.NamespaceLikeRefImpl <em>Namespace Like Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.NamespaceLikeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getNamespaceLikeRef()
	 * @generated
	 */
	int NAMESPACE_LIKE_REF = 16;

	/**
	 * The feature id for the '<em><b>Declared Type As Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_LIKE_REF__DECLARED_TYPE_AS_TEXT = 0;

	/**
	 * The feature id for the '<em><b>Declared Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_LIKE_REF__DECLARED_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Namespace Like Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_LIKE_REF_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Previous Sibling</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_LIKE_REF___GET_PREVIOUS_SIBLING = 0;

	/**
	 * The number of operations of the '<em>Namespace Like Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_LIKE_REF_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.WildcardImpl <em>Wildcard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.WildcardImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getWildcard()
	 * @generated
	 */
	int WILDCARD = 17;

	/**
	 * The feature id for the '<em><b>Declared Upper Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD__DECLARED_UPPER_BOUND = TYPE_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Lower Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD__DECLARED_LOWER_BOUND = TYPE_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Using In Out Notation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD__USING_IN_OUT_NOTATION = TYPE_ARGUMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Wildcard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FEATURE_COUNT = TYPE_ARGUMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD___IS_TYPE_REF = TYPE_ARGUMENT___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD___GET_DECLARED_TYPE = TYPE_ARGUMENT___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD___GET_TYPE_REF_AS_STRING = TYPE_ARGUMENT___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Declared Or Implicit Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD___GET_DECLARED_OR_IMPLICIT_UPPER_BOUND = TYPE_ARGUMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Implicit Upper Bound In Effect</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD___IS_IMPLICIT_UPPER_BOUND_IN_EFFECT = TYPE_ARGUMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_ARGUMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Wildcard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_OPERATION_COUNT = TYPE_ARGUMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl <em>Function Type Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getFunctionTypeExpression()
	 * @generated
	 */
	int FUNCTION_TYPE_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__FOLLOWED_BY_QUESTION_MARK = TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__ORIGINAL_ALIAS_TYPE_REF = TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__BINDING = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__DECLARED_FUNCTION = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE = TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__OWNED_TYPE_VARS = TYPE_REF_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Unbound Type Vars</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS = TYPE_REF_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Unbound Type Vars Upper Bounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS_UPPER_BOUNDS = TYPE_REF_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Fpars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__FPARS = TYPE_REF_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Return Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF = TYPE_REF_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Return Value Marked Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION__RETURN_VALUE_MARKED_OPTIONAL = TYPE_REF_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Function Type Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 9;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_DECLARED_TYPE = TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_MODIFIERS_AS_STRING = TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_TYPE_REF = TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_ALIAS_UNRESOLVED = TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_ALIAS_RESOLVED = TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_FINAL_BY_TYPE = TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_ARRAY_LIKE = TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_UNKNOWN = TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_DYNAMIC = TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_EXISTENTIAL = TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_PARAMETERIZED = TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_DECLARED_UPPER_BOUND = TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_DECLARED_LOWER_BOUND = TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_DECLARED_TYPE_ARGS = TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_TYPE_ARGS_WITH_DEFAULTS = TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_TYPE_REF_AS_STRING = TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___TO_STRING = TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_TOP_TYPE = TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_BOTTOM_TYPE = TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_TYPING_STRATEGY = TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_STRUCTURAL_MEMBERS = TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_STRUCTURAL_TYPING = TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_USE_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_DEF_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Is Return Value Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_RETURN_VALUE_OPTIONAL = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_TYPE_VARS = TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_GENERIC = TYPE_REF_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___IS_RAW = TYPE_REF_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Fpar For Arg Idx</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_FPAR_FOR_ARG_IDX__INT = TYPE_REF_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_REF_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Type Var Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION___GET_TYPE_VAR_UPPER_BOUND__TYPEVARIABLE = TYPE_REF_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Function Type Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_EXPRESSION_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.DeferredTypeRefImpl <em>Deferred Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.DeferredTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getDeferredTypeRef()
	 * @generated
	 */
	int DEFERRED_TYPE_REF = 19;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The number of structural features of the '<em>Deferred Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_DECLARED_TYPE = TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_MODIFIERS_AS_STRING = TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_TYPE_REF = TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_ALIAS_UNRESOLVED = TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_ALIAS_RESOLVED = TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_FINAL_BY_TYPE = TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_ARRAY_LIKE = TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_UNKNOWN = TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_DYNAMIC = TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_EXISTENTIAL = TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_GENERIC = TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_PARAMETERIZED = TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_RAW = TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_DECLARED_UPPER_BOUND = TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_DECLARED_LOWER_BOUND = TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_DECLARED_TYPE_ARGS = TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_TYPE_REF_AS_STRING = TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___TO_STRING = TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_TOP_TYPE = TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_BOTTOM_TYPE = TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_TYPING_STRATEGY = TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_STRUCTURAL_MEMBERS = TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_STRUCTURAL_TYPING = TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Deferred Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_TYPE_REF_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.TypeVariableMappingImpl <em>Type Variable Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeVariableMappingImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getTypeVariableMapping()
	 * @generated
	 */
	int TYPE_VARIABLE_MAPPING = 20;

	/**
	 * The feature id for the '<em><b>Type Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_MAPPING__TYPE_VAR = 0;

	/**
	 * The feature id for the '<em><b>Type Arg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_MAPPING__TYPE_ARG = 1;

	/**
	 * The number of structural features of the '<em>Type Variable Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Type Variable Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_MAPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.LiteralTypeRefImpl <em>Literal Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.LiteralTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getLiteralTypeRef()
	 * @generated
	 */
	int LITERAL_TYPE_REF = 21;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Ast Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF__AST_VALUE = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_DECLARED_TYPE = TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING = TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_TYPE_REF = TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED = TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_ALIAS_RESOLVED = TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_FINAL_BY_TYPE = TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_ARRAY_LIKE = TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_UNKNOWN = TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_DYNAMIC = TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_EXISTENTIAL = TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_GENERIC = TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_PARAMETERIZED = TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_RAW = TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND = TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND = TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS = TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING = TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___TO_STRING = TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_TOP_TYPE = TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_BOTTOM_TYPE = TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_TYPING_STRATEGY = TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS = TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING = TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF___GET_VALUE = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_REF_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.BooleanLiteralTypeRefImpl <em>Boolean Literal Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.BooleanLiteralTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getBooleanLiteralTypeRef()
	 * @generated
	 */
	int BOOLEAN_LITERAL_TYPE_REF = 22;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Ast Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF__AST_VALUE = LITERAL_TYPE_REF__AST_VALUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF__VALUE = LITERAL_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF_FEATURE_COUNT = LITERAL_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_DECLARED_TYPE = LITERAL_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING = LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_TYPE_REF = LITERAL_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED = LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_ALIAS_RESOLVED = LITERAL_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_FINAL_BY_TYPE = LITERAL_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_ARRAY_LIKE = LITERAL_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_UNKNOWN = LITERAL_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_DYNAMIC = LITERAL_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_EXISTENTIAL = LITERAL_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_GENERIC = LITERAL_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_PARAMETERIZED = LITERAL_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_RAW = LITERAL_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND = LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND = LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS = LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING = LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___TO_STRING = LITERAL_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_TOP_TYPE = LITERAL_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_BOTTOM_TYPE = LITERAL_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_TYPING_STRATEGY = LITERAL_TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS = LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___GET_VALUE = LITERAL_TYPE_REF___GET_VALUE;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = LITERAL_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_TYPE_REF_OPERATION_COUNT = LITERAL_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.NumericLiteralTypeRefImpl <em>Numeric Literal Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.NumericLiteralTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getNumericLiteralTypeRef()
	 * @generated
	 */
	int NUMERIC_LITERAL_TYPE_REF = 23;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Ast Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF__AST_VALUE = LITERAL_TYPE_REF__AST_VALUE;

	/**
	 * The feature id for the '<em><b>Ast Negated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF__AST_NEGATED = LITERAL_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF__VALUE = LITERAL_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Numeric Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF_FEATURE_COUNT = LITERAL_TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_DECLARED_TYPE = LITERAL_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING = LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_TYPE_REF = LITERAL_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED = LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_ALIAS_RESOLVED = LITERAL_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_FINAL_BY_TYPE = LITERAL_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_ARRAY_LIKE = LITERAL_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_UNKNOWN = LITERAL_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_DYNAMIC = LITERAL_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_EXISTENTIAL = LITERAL_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_GENERIC = LITERAL_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_PARAMETERIZED = LITERAL_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_RAW = LITERAL_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND = LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND = LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS = LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING = LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___TO_STRING = LITERAL_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_TOP_TYPE = LITERAL_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_BOTTOM_TYPE = LITERAL_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_TYPING_STRATEGY = LITERAL_TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS = LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___GET_VALUE = LITERAL_TYPE_REF___GET_VALUE;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = LITERAL_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Numeric Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_TYPE_REF_OPERATION_COUNT = LITERAL_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.StringLiteralTypeRefImpl <em>String Literal Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.StringLiteralTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getStringLiteralTypeRef()
	 * @generated
	 */
	int STRING_LITERAL_TYPE_REF = 24;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Ast Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF__AST_VALUE = LITERAL_TYPE_REF__AST_VALUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF__VALUE = LITERAL_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF_FEATURE_COUNT = LITERAL_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_DECLARED_TYPE = LITERAL_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING = LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_TYPE_REF = LITERAL_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED = LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_ALIAS_RESOLVED = LITERAL_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_FINAL_BY_TYPE = LITERAL_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_ARRAY_LIKE = LITERAL_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_UNKNOWN = LITERAL_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_DYNAMIC = LITERAL_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_EXISTENTIAL = LITERAL_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_GENERIC = LITERAL_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_PARAMETERIZED = LITERAL_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_RAW = LITERAL_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND = LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND = LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS = LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING = LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___TO_STRING = LITERAL_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_TOP_TYPE = LITERAL_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_BOTTOM_TYPE = LITERAL_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_TYPING_STRATEGY = LITERAL_TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS = LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___GET_VALUE = LITERAL_TYPE_REF___GET_VALUE;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = LITERAL_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>String Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_TYPE_REF_OPERATION_COUNT = LITERAL_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.impl.EnumLiteralTypeRefImpl <em>Enum Literal Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.impl.EnumLiteralTypeRefImpl
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getEnumLiteralTypeRef()
	 * @generated
	 */
	int ENUM_LITERAL_TYPE_REF = 25;

	/**
	 * The feature id for the '<em><b>Followed By Question Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK = LITERAL_TYPE_REF__FOLLOWED_BY_QUESTION_MARK;

	/**
	 * The feature id for the '<em><b>Original Alias Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = LITERAL_TYPE_REF__ORIGINAL_ALIAS_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Ast Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF__AST_VALUE = LITERAL_TYPE_REF__AST_VALUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF__VALUE = LITERAL_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF_FEATURE_COUNT = LITERAL_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Declared Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_DECLARED_TYPE = LITERAL_TYPE_REF___GET_DECLARED_TYPE;

	/**
	 * The operation id for the '<em>Get Modifiers As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING = LITERAL_TYPE_REF___GET_MODIFIERS_AS_STRING;

	/**
	 * The operation id for the '<em>Is Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_TYPE_REF = LITERAL_TYPE_REF___IS_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Alias Unresolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED = LITERAL_TYPE_REF___IS_ALIAS_UNRESOLVED;

	/**
	 * The operation id for the '<em>Is Alias Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_ALIAS_RESOLVED = LITERAL_TYPE_REF___IS_ALIAS_RESOLVED;

	/**
	 * The operation id for the '<em>Is Final By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_FINAL_BY_TYPE = LITERAL_TYPE_REF___IS_FINAL_BY_TYPE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_ARRAY_LIKE = LITERAL_TYPE_REF___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Unknown</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_UNKNOWN = LITERAL_TYPE_REF___IS_UNKNOWN;

	/**
	 * The operation id for the '<em>Is Dynamic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_DYNAMIC = LITERAL_TYPE_REF___IS_DYNAMIC;

	/**
	 * The operation id for the '<em>Is Existential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_EXISTENTIAL = LITERAL_TYPE_REF___IS_EXISTENTIAL;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_GENERIC = LITERAL_TYPE_REF___IS_GENERIC;

	/**
	 * The operation id for the '<em>Is Parameterized</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_PARAMETERIZED = LITERAL_TYPE_REF___IS_PARAMETERIZED;

	/**
	 * The operation id for the '<em>Is Raw</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_RAW = LITERAL_TYPE_REF___IS_RAW;

	/**
	 * The operation id for the '<em>Get Declared Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND = LITERAL_TYPE_REF___GET_DECLARED_UPPER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND = LITERAL_TYPE_REF___GET_DECLARED_LOWER_BOUND;

	/**
	 * The operation id for the '<em>Get Declared Type Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS = LITERAL_TYPE_REF___GET_DECLARED_TYPE_ARGS;

	/**
	 * The operation id for the '<em>Get Type Args With Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = LITERAL_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS;

	/**
	 * The operation id for the '<em>Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING = LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = LITERAL_TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___TO_STRING = LITERAL_TYPE_REF___TO_STRING;

	/**
	 * The operation id for the '<em>Is Top Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_TOP_TYPE = LITERAL_TYPE_REF___IS_TOP_TYPE;

	/**
	 * The operation id for the '<em>Is Bottom Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_BOTTOM_TYPE = LITERAL_TYPE_REF___IS_BOTTOM_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_TYPING_STRATEGY = LITERAL_TYPE_REF___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Get Structural Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS = LITERAL_TYPE_REF___GET_STRUCTURAL_MEMBERS;

	/**
	 * The operation id for the '<em>Is Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Use Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Is Def Site Structural Typing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = LITERAL_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING;

	/**
	 * The operation id for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = LITERAL_TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_VALUE = LITERAL_TYPE_REF___GET_VALUE;

	/**
	 * The operation id for the '<em>Get Enum Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___GET_ENUM_TYPE = LITERAL_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Internal Get Type Ref As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = LITERAL_TYPE_REF_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Literal Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TYPE_REF_OPERATION_COUNT = LITERAL_TYPE_REF_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.typeRefs.OptionalFieldStrategy <em>Optional Field Strategy</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.typeRefs.OptionalFieldStrategy
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getOptionalFieldStrategy()
	 * @generated
	 */
	int OPTIONAL_FIELD_STRATEGY = 26;

	/**
	 * The meta object id for the '<em>UUID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.UUID
	 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getUUID()
	 * @generated
	 */
	int UUID = 27;


	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.TypeArgument <em>Type Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Argument</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeArgument
	 * @generated
	 */
	EClass getTypeArgument();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeArgument#isTypeRef() <em>Is Type Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Type Ref</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeArgument#isTypeRef()
	 * @generated
	 */
	EOperation getTypeArgument__IsTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeArgument#getDeclaredType() <em>Get Declared Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Declared Type</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeArgument#getDeclaredType()
	 * @generated
	 */
	EOperation getTypeArgument__GetDeclaredType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeArgument#getTypeRefAsString() <em>Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeArgument#getTypeRefAsString()
	 * @generated
	 */
	EOperation getTypeArgument__GetTypeRefAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeArgument#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeArgument#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getTypeArgument__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef
	 * @generated
	 */
	EClass getTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isFollowedByQuestionMark <em>Followed By Question Mark</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Followed By Question Mark</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isFollowedByQuestionMark()
	 * @see #getTypeRef()
	 * @generated
	 */
	EAttribute getTypeRef_FollowedByQuestionMark();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getOriginalAliasTypeRef <em>Original Alias Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Alias Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getOriginalAliasTypeRef()
	 * @see #getTypeRef()
	 * @generated
	 */
	EReference getTypeRef_OriginalAliasTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getModifiersAsString() <em>Get Modifiers As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Modifiers As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getModifiersAsString()
	 * @generated
	 */
	EOperation getTypeRef__GetModifiersAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isTypeRef() <em>Is Type Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Type Ref</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isTypeRef()
	 * @generated
	 */
	EOperation getTypeRef__IsTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isAliasUnresolved() <em>Is Alias Unresolved</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Alias Unresolved</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isAliasUnresolved()
	 * @generated
	 */
	EOperation getTypeRef__IsAliasUnresolved();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isAliasResolved() <em>Is Alias Resolved</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Alias Resolved</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isAliasResolved()
	 * @generated
	 */
	EOperation getTypeRef__IsAliasResolved();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isFinalByType() <em>Is Final By Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Final By Type</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isFinalByType()
	 * @generated
	 */
	EOperation getTypeRef__IsFinalByType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isArrayLike() <em>Is Array Like</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Array Like</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isArrayLike()
	 * @generated
	 */
	EOperation getTypeRef__IsArrayLike();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isUnknown() <em>Is Unknown</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Unknown</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isUnknown()
	 * @generated
	 */
	EOperation getTypeRef__IsUnknown();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isDynamic() <em>Is Dynamic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Dynamic</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isDynamic()
	 * @generated
	 */
	EOperation getTypeRef__IsDynamic();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isExistential() <em>Is Existential</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Existential</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isExistential()
	 * @generated
	 */
	EOperation getTypeRef__IsExistential();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isGeneric() <em>Is Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Generic</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isGeneric()
	 * @generated
	 */
	EOperation getTypeRef__IsGeneric();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isParameterized() <em>Is Parameterized</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Parameterized</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isParameterized()
	 * @generated
	 */
	EOperation getTypeRef__IsParameterized();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isRaw() <em>Is Raw</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Raw</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isRaw()
	 * @generated
	 */
	EOperation getTypeRef__IsRaw();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getDeclaredUpperBound() <em>Get Declared Upper Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Declared Upper Bound</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getDeclaredUpperBound()
	 * @generated
	 */
	EOperation getTypeRef__GetDeclaredUpperBound();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getDeclaredLowerBound() <em>Get Declared Lower Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Declared Lower Bound</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getDeclaredLowerBound()
	 * @generated
	 */
	EOperation getTypeRef__GetDeclaredLowerBound();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getDeclaredTypeArgs() <em>Get Declared Type Args</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Declared Type Args</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getDeclaredTypeArgs()
	 * @generated
	 */
	EOperation getTypeRef__GetDeclaredTypeArgs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getTypeArgsWithDefaults() <em>Get Type Args With Defaults</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Args With Defaults</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getTypeArgsWithDefaults()
	 * @generated
	 */
	EOperation getTypeRef__GetTypeArgsWithDefaults();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getTypeRefAsString() <em>Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getTypeRefAsString()
	 * @generated
	 */
	EOperation getTypeRef__GetTypeRefAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getTypeRefAsStringWithAliasResolution() <em>Get Type Ref As String With Alias Resolution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Ref As String With Alias Resolution</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getTypeRefAsStringWithAliasResolution()
	 * @generated
	 */
	EOperation getTypeRef__GetTypeRefAsStringWithAliasResolution();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#toString()
	 * @generated
	 */
	EOperation getTypeRef__ToString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isTopType() <em>Is Top Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Top Type</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isTopType()
	 * @generated
	 */
	EOperation getTypeRef__IsTopType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isBottomType() <em>Is Bottom Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Bottom Type</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isBottomType()
	 * @generated
	 */
	EOperation getTypeRef__IsBottomType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getTypingStrategy() <em>Get Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getTypingStrategy()
	 * @generated
	 */
	EOperation getTypeRef__GetTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getStructuralMembers() <em>Get Structural Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Structural Members</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getStructuralMembers()
	 * @generated
	 */
	EOperation getTypeRef__GetStructuralMembers();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isStructuralTyping() <em>Is Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isStructuralTyping()
	 * @generated
	 */
	EOperation getTypeRef__IsStructuralTyping();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isUseSiteStructuralTyping() <em>Is Use Site Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Use Site Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isUseSiteStructuralTyping()
	 * @generated
	 */
	EOperation getTypeRef__IsUseSiteStructuralTyping();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#isDefSiteStructuralTyping() <em>Is Def Site Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Def Site Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#isDefSiteStructuralTyping()
	 * @generated
	 */
	EOperation getTypeRef__IsDefSiteStructuralTyping();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeRef#getASTNodeOptionalFieldStrategy() <em>Get AST Node Optional Field Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get AST Node Optional Field Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeRef#getASTNodeOptionalFieldStrategy()
	 * @generated
	 */
	EOperation getTypeRef__GetASTNodeOptionalFieldStrategy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.BaseTypeRef <em>Base Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.BaseTypeRef
	 * @generated
	 */
	EClass getBaseTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.BaseTypeRef#isDynamic <em>Dynamic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamic</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.BaseTypeRef#isDynamic()
	 * @see #getBaseTypeRef()
	 * @generated
	 */
	EAttribute getBaseTypeRef_Dynamic();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BaseTypeRef#getModifiersAsString() <em>Get Modifiers As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Modifiers As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BaseTypeRef#getModifiersAsString()
	 * @generated
	 */
	EOperation getBaseTypeRef__GetModifiersAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.ComposedTypeRef <em>Composed Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ComposedTypeRef
	 * @generated
	 */
	EClass getComposedTypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.ComposedTypeRef#getTypeRefs <em>Type Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Refs</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ComposedTypeRef#getTypeRefs()
	 * @see #getComposedTypeRef()
	 * @generated
	 */
	EReference getComposedTypeRef_TypeRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ComposedTypeRef#isDynamic() <em>Is Dynamic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Dynamic</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ComposedTypeRef#isDynamic()
	 * @generated
	 */
	EOperation getComposedTypeRef__IsDynamic();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ComposedTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ComposedTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getComposedTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.UnionTypeExpression <em>Union Type Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union Type Expression</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.UnionTypeExpression
	 * @generated
	 */
	EClass getUnionTypeExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.UnionTypeExpression#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.UnionTypeExpression#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getUnionTypeExpression__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.IntersectionTypeExpression <em>Intersection Type Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intersection Type Expression</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.IntersectionTypeExpression
	 * @generated
	 */
	EClass getIntersectionTypeExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.IntersectionTypeExpression#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.IntersectionTypeExpression#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getIntersectionTypeExpression__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRef <em>This Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRef
	 * @generated
	 */
	EClass getThisTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getThisTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRef#getTypingStrategy() <em>Get Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRef#getTypingStrategy()
	 * @generated
	 */
	EOperation getThisTypeRef__GetTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRef#getStructuralMembers() <em>Get Structural Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Structural Members</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRef#getStructuralMembers()
	 * @generated
	 */
	EOperation getThisTypeRef__GetStructuralMembers();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRef#isUseSiteStructuralTyping() <em>Is Use Site Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Use Site Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRef#isUseSiteStructuralTyping()
	 * @generated
	 */
	EOperation getThisTypeRef__IsUseSiteStructuralTyping();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRefNominal <em>This Type Ref Nominal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Type Ref Nominal</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRefNominal
	 * @generated
	 */
	EClass getThisTypeRefNominal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural <em>This Type Ref Structural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Type Ref Structural</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural
	 * @generated
	 */
	EClass getThisTypeRefStructural();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#getDefinedTypingStrategy <em>Defined Typing Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defined Typing Strategy</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#getDefinedTypingStrategy()
	 * @see #getThisTypeRefStructural()
	 * @generated
	 */
	EAttribute getThisTypeRefStructural_DefinedTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#getTypingStrategy() <em>Get Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#getTypingStrategy()
	 * @generated
	 */
	EOperation getThisTypeRefStructural__GetTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#setTypingStrategy(org.eclipse.n4js.ts.types.TypingStrategy) <em>Set Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#setTypingStrategy(org.eclipse.n4js.ts.types.TypingStrategy)
	 * @generated
	 */
	EOperation getThisTypeRefStructural__SetTypingStrategy__TypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#isUseSiteStructuralTyping() <em>Is Use Site Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Use Site Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#isUseSiteStructuralTyping()
	 * @generated
	 */
	EOperation getThisTypeRefStructural__IsUseSiteStructuralTyping();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#getStructuralMembers() <em>Get Structural Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Structural Members</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#getStructuralMembers()
	 * @generated
	 */
	EOperation getThisTypeRefStructural__GetStructuralMembers();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ThisTypeRefStructural#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getThisTypeRefStructural__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef <em>Bound This Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound This Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef
	 * @generated
	 */
	EClass getBoundThisTypeRef();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getActualThisTypeRef <em>Actual This Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Actual This Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getActualThisTypeRef()
	 * @see #getBoundThisTypeRef()
	 * @generated
	 */
	EReference getBoundThisTypeRef_ActualThisTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getDefinedTypingStrategy <em>Defined Typing Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defined Typing Strategy</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getDefinedTypingStrategy()
	 * @see #getBoundThisTypeRef()
	 * @generated
	 */
	EAttribute getBoundThisTypeRef_DefinedTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getTypingStrategy() <em>Get Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getTypingStrategy()
	 * @generated
	 */
	EOperation getBoundThisTypeRef__GetTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#setTypingStrategy(org.eclipse.n4js.ts.types.TypingStrategy) <em>Set Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#setTypingStrategy(org.eclipse.n4js.ts.types.TypingStrategy)
	 * @generated
	 */
	EOperation getBoundThisTypeRef__SetTypingStrategy__TypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getBoundThisTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getDeclaredUpperBound() <em>Get Declared Upper Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Declared Upper Bound</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getDeclaredUpperBound()
	 * @generated
	 */
	EOperation getBoundThisTypeRef__GetDeclaredUpperBound();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#isDefSiteStructuralTyping() <em>Is Def Site Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Def Site Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#isDefSiteStructuralTyping()
	 * @generated
	 */
	EOperation getBoundThisTypeRef__IsDefSiteStructuralTyping();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#isUseSiteStructuralTyping() <em>Is Use Site Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Use Site Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#isUseSiteStructuralTyping()
	 * @generated
	 */
	EOperation getBoundThisTypeRef__IsUseSiteStructuralTyping();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getStructuralMembers() <em>Get Structural Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Structural Members</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BoundThisTypeRef#getStructuralMembers()
	 * @generated
	 */
	EOperation getBoundThisTypeRef__GetStructuralMembers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef <em>Parameterized Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef
	 * @generated
	 */
	EClass getParameterizedTypeRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getDeclaredType <em>Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declared Type</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getDeclaredType()
	 * @see #getParameterizedTypeRef()
	 * @generated
	 */
	EReference getParameterizedTypeRef_DeclaredType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getDeclaredTypeAsText <em>Declared Type As Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Type As Text</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getDeclaredTypeAsText()
	 * @see #getParameterizedTypeRef()
	 * @generated
	 */
	EAttribute getParameterizedTypeRef_DeclaredTypeAsText();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getDeclaredTypeArgs <em>Declared Type Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Type Args</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getDeclaredTypeArgs()
	 * @see #getParameterizedTypeRef()
	 * @generated
	 */
	EReference getParameterizedTypeRef_DeclaredTypeArgs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isArrayTypeExpression <em>Array Type Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Type Expression</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isArrayTypeExpression()
	 * @see #getParameterizedTypeRef()
	 * @generated
	 */
	EAttribute getParameterizedTypeRef_ArrayTypeExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isArrayNTypeExpression <em>Array NType Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array NType Expression</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isArrayNTypeExpression()
	 * @see #getParameterizedTypeRef()
	 * @generated
	 */
	EAttribute getParameterizedTypeRef_ArrayNTypeExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getAstNamespaceLikeRefs <em>Ast Namespace Like Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ast Namespace Like Refs</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getAstNamespaceLikeRefs()
	 * @see #getParameterizedTypeRef()
	 * @generated
	 */
	EReference getParameterizedTypeRef_AstNamespaceLikeRefs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getASTNodeOptionalFieldStrategy <em>AST Node Optional Field Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>AST Node Optional Field Strategy</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getASTNodeOptionalFieldStrategy()
	 * @see #getParameterizedTypeRef()
	 * @generated
	 */
	EAttribute getParameterizedTypeRef_ASTNodeOptionalFieldStrategy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getDefinedTypingStrategy <em>Defined Typing Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defined Typing Strategy</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getDefinedTypingStrategy()
	 * @see #getParameterizedTypeRef()
	 * @generated
	 */
	EAttribute getParameterizedTypeRef_DefinedTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getPreviousSibling(org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef) <em>Get Previous Sibling</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Previous Sibling</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getPreviousSibling(org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef)
	 * @generated
	 */
	EOperation getParameterizedTypeRef__GetPreviousSibling__NamespaceLikeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getTypingStrategy() <em>Get Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getTypingStrategy()
	 * @generated
	 */
	EOperation getParameterizedTypeRef__GetTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getTypeArgsWithDefaults() <em>Get Type Args With Defaults</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Args With Defaults</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#getTypeArgsWithDefaults()
	 * @generated
	 */
	EOperation getParameterizedTypeRef__GetTypeArgsWithDefaults();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getParameterizedTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isParameterized() <em>Is Parameterized</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Parameterized</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isParameterized()
	 * @generated
	 */
	EOperation getParameterizedTypeRef__IsParameterized();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isGeneric() <em>Is Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Generic</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isGeneric()
	 * @generated
	 */
	EOperation getParameterizedTypeRef__IsGeneric();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isRaw() <em>Is Raw</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Raw</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isRaw()
	 * @generated
	 */
	EOperation getParameterizedTypeRef__IsRaw();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isUseSiteStructuralTyping() <em>Is Use Site Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Use Site Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isUseSiteStructuralTyping()
	 * @generated
	 */
	EOperation getParameterizedTypeRef__IsUseSiteStructuralTyping();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isDefSiteStructuralTyping() <em>Is Def Site Structural Typing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Def Site Structural Typing</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef#isDefSiteStructuralTyping()
	 * @generated
	 */
	EOperation getParameterizedTypeRef__IsDefSiteStructuralTyping();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef <em>Structural Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef
	 * @generated
	 */
	EClass getStructuralTypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getAstStructuralMembers <em>Ast Structural Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ast Structural Members</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getAstStructuralMembers()
	 * @see #getStructuralTypeRef()
	 * @generated
	 */
	EReference getStructuralTypeRef_AstStructuralMembers();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getStructuralType <em>Structural Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Structural Type</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getStructuralType()
	 * @see #getStructuralTypeRef()
	 * @generated
	 */
	EReference getStructuralTypeRef_StructuralType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getGenStructuralMembers <em>Gen Structural Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gen Structural Members</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getGenStructuralMembers()
	 * @see #getStructuralTypeRef()
	 * @generated
	 */
	EReference getStructuralTypeRef_GenStructuralMembers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getPostponedSubstitutions <em>Postponed Substitutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postponed Substitutions</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getPostponedSubstitutions()
	 * @see #getStructuralTypeRef()
	 * @generated
	 */
	EReference getStructuralTypeRef_PostponedSubstitutions();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getTypingStrategy() <em>Get Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getTypingStrategy()
	 * @generated
	 */
	EOperation getStructuralTypeRef__GetTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#setTypingStrategy(org.eclipse.n4js.ts.types.TypingStrategy) <em>Set Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#setTypingStrategy(org.eclipse.n4js.ts.types.TypingStrategy)
	 * @generated
	 */
	EOperation getStructuralTypeRef__SetTypingStrategy__TypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getStructuralMembers() <em>Get Structural Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Structural Members</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getStructuralMembers()
	 * @generated
	 */
	EOperation getStructuralTypeRef__GetStructuralMembers();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getStructuralMembersWithCallConstructSignatures() <em>Get Structural Members With Call Construct Signatures</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Structural Members With Call Construct Signatures</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#getStructuralMembersWithCallConstructSignatures()
	 * @generated
	 */
	EOperation getStructuralTypeRef__GetStructuralMembersWithCallConstructSignatures();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#hasPostponedSubstitutionFor(org.eclipse.n4js.ts.types.TypeVariable) <em>Has Postponed Substitution For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Postponed Substitution For</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.StructuralTypeRef#hasPostponedSubstitutionFor(org.eclipse.n4js.ts.types.TypeVariable)
	 * @generated
	 */
	EOperation getStructuralTypeRef__HasPostponedSubstitutionFor__TypeVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural <em>Parameterized Type Ref Structural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Type Ref Structural</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural
	 * @generated
	 */
	EClass getParameterizedTypeRefStructural();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural#getTypingStrategy() <em>Get Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural#getTypingStrategy()
	 * @generated
	 */
	EOperation getParameterizedTypeRefStructural__GetTypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural#setTypingStrategy(org.eclipse.n4js.ts.types.TypingStrategy) <em>Set Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural#setTypingStrategy(org.eclipse.n4js.ts.types.TypingStrategy)
	 * @generated
	 */
	EOperation getParameterizedTypeRefStructural__SetTypingStrategy__TypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural#getStructuralMembers() <em>Get Structural Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Structural Members</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural#getStructuralMembers()
	 * @generated
	 */
	EOperation getParameterizedTypeRefStructural__GetStructuralMembers();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getParameterizedTypeRefStructural__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef <em>Existential Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Existential Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef
	 * @generated
	 */
	EClass getExistentialTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#getId()
	 * @see #getExistentialTypeRef()
	 * @generated
	 */
	EAttribute getExistentialTypeRef_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#isReopened <em>Reopened</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reopened</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#isReopened()
	 * @see #getExistentialTypeRef()
	 * @generated
	 */
	EAttribute getExistentialTypeRef_Reopened();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#getWildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wildcard</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#getWildcard()
	 * @see #getExistentialTypeRef()
	 * @generated
	 */
	EReference getExistentialTypeRef_Wildcard();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#isExistential() <em>Is Existential</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Existential</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#isExistential()
	 * @generated
	 */
	EOperation getExistentialTypeRef__IsExistential();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#isGeneric() <em>Is Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Generic</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#isGeneric()
	 * @generated
	 */
	EOperation getExistentialTypeRef__IsGeneric();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#isParameterized() <em>Is Parameterized</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Parameterized</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#isParameterized()
	 * @generated
	 */
	EOperation getExistentialTypeRef__IsParameterized();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.ExistentialTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getExistentialTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.UnknownTypeRef <em>Unknown Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.UnknownTypeRef
	 * @generated
	 */
	EClass getUnknownTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.UnknownTypeRef#isUnknown() <em>Is Unknown</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Unknown</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.UnknownTypeRef#isUnknown()
	 * @generated
	 */
	EOperation getUnknownTypeRef__IsUnknown();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.UnknownTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.UnknownTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getUnknownTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.TypeTypeRef <em>Type Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeTypeRef
	 * @generated
	 */
	EClass getTypeTypeRef();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.typeRefs.TypeTypeRef#getTypeArg <em>Type Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Arg</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeTypeRef#getTypeArg()
	 * @see #getTypeTypeRef()
	 * @generated
	 */
	EReference getTypeTypeRef_TypeArg();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.TypeTypeRef#isConstructorRef <em>Constructor Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constructor Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeTypeRef#isConstructorRef()
	 * @see #getTypeTypeRef()
	 * @generated
	 */
	EAttribute getTypeTypeRef_ConstructorRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.TypeTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getTypeTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef <em>Namespace Like Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace Like Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef
	 * @generated
	 */
	EClass getNamespaceLikeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef#getDeclaredTypeAsText <em>Declared Type As Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Type As Text</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef#getDeclaredTypeAsText()
	 * @see #getNamespaceLikeRef()
	 * @generated
	 */
	EAttribute getNamespaceLikeRef_DeclaredTypeAsText();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef#getDeclaredType <em>Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declared Type</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef#getDeclaredType()
	 * @see #getNamespaceLikeRef()
	 * @generated
	 */
	EReference getNamespaceLikeRef_DeclaredType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef#getPreviousSibling() <em>Get Previous Sibling</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Previous Sibling</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef#getPreviousSibling()
	 * @generated
	 */
	EOperation getNamespaceLikeRef__GetPreviousSibling();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.Wildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.Wildcard
	 * @generated
	 */
	EClass getWildcard();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.typeRefs.Wildcard#getDeclaredUpperBound <em>Declared Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Upper Bound</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.Wildcard#getDeclaredUpperBound()
	 * @see #getWildcard()
	 * @generated
	 */
	EReference getWildcard_DeclaredUpperBound();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.typeRefs.Wildcard#getDeclaredLowerBound <em>Declared Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Lower Bound</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.Wildcard#getDeclaredLowerBound()
	 * @see #getWildcard()
	 * @generated
	 */
	EReference getWildcard_DeclaredLowerBound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.Wildcard#isUsingInOutNotation <em>Using In Out Notation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Using In Out Notation</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.Wildcard#isUsingInOutNotation()
	 * @see #getWildcard()
	 * @generated
	 */
	EAttribute getWildcard_UsingInOutNotation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.Wildcard#getDeclaredOrImplicitUpperBound() <em>Get Declared Or Implicit Upper Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Declared Or Implicit Upper Bound</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.Wildcard#getDeclaredOrImplicitUpperBound()
	 * @generated
	 */
	EOperation getWildcard__GetDeclaredOrImplicitUpperBound();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.Wildcard#isImplicitUpperBoundInEffect() <em>Is Implicit Upper Bound In Effect</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Implicit Upper Bound In Effect</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.Wildcard#isImplicitUpperBoundInEffect()
	 * @generated
	 */
	EOperation getWildcard__IsImplicitUpperBoundInEffect();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.Wildcard#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.Wildcard#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getWildcard__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression <em>Function Type Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Type Expression</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression
	 * @generated
	 */
	EClass getFunctionTypeExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isBinding()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EAttribute getFunctionTypeExpression_Binding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getDeclaredFunction <em>Declared Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declared Function</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getDeclaredFunction()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EReference getFunctionTypeExpression_DeclaredFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getDeclaredThisType <em>Declared This Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared This Type</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getDeclaredThisType()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EReference getFunctionTypeExpression_DeclaredThisType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getOwnedTypeVars <em>Owned Type Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Type Vars</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getOwnedTypeVars()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EReference getFunctionTypeExpression_OwnedTypeVars();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getUnboundTypeVars <em>Unbound Type Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unbound Type Vars</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getUnboundTypeVars()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EReference getFunctionTypeExpression_UnboundTypeVars();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getUnboundTypeVarsUpperBounds <em>Unbound Type Vars Upper Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unbound Type Vars Upper Bounds</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getUnboundTypeVarsUpperBounds()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EReference getFunctionTypeExpression_UnboundTypeVarsUpperBounds();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getFpars <em>Fpars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fpars</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getFpars()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EReference getFunctionTypeExpression_Fpars();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getReturnTypeRef <em>Return Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getReturnTypeRef()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EReference getFunctionTypeExpression_ReturnTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isReturnValueMarkedOptional <em>Return Value Marked Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Value Marked Optional</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isReturnValueMarkedOptional()
	 * @see #getFunctionTypeExpression()
	 * @generated
	 */
	EAttribute getFunctionTypeExpression_ReturnValueMarkedOptional();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isReturnValueOptional() <em>Is Return Value Optional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Return Value Optional</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isReturnValueOptional()
	 * @generated
	 */
	EOperation getFunctionTypeExpression__IsReturnValueOptional();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getTypeVars() <em>Get Type Vars</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Vars</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getTypeVars()
	 * @generated
	 */
	EOperation getFunctionTypeExpression__GetTypeVars();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isGeneric() <em>Is Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Generic</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isGeneric()
	 * @generated
	 */
	EOperation getFunctionTypeExpression__IsGeneric();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isRaw() <em>Is Raw</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Raw</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#isRaw()
	 * @generated
	 */
	EOperation getFunctionTypeExpression__IsRaw();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getFparForArgIdx(int) <em>Get Fpar For Arg Idx</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Fpar For Arg Idx</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getFparForArgIdx(int)
	 * @generated
	 */
	EOperation getFunctionTypeExpression__GetFparForArgIdx__int();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getFunctionTypeExpression__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getTypeVarUpperBound(org.eclipse.n4js.ts.types.TypeVariable) <em>Get Type Var Upper Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Var Upper Bound</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression#getTypeVarUpperBound(org.eclipse.n4js.ts.types.TypeVariable)
	 * @generated
	 */
	EOperation getFunctionTypeExpression__GetTypeVarUpperBound__TypeVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.DeferredTypeRef <em>Deferred Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deferred Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.DeferredTypeRef
	 * @generated
	 */
	EClass getDeferredTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.DeferredTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.DeferredTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getDeferredTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.TypeVariableMapping <em>Type Variable Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Variable Mapping</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeVariableMapping
	 * @generated
	 */
	EClass getTypeVariableMapping();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.typeRefs.TypeVariableMapping#getTypeVar <em>Type Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Var</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeVariableMapping#getTypeVar()
	 * @see #getTypeVariableMapping()
	 * @generated
	 */
	EReference getTypeVariableMapping_TypeVar();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.typeRefs.TypeVariableMapping#getTypeArg <em>Type Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Arg</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.TypeVariableMapping#getTypeArg()
	 * @see #getTypeVariableMapping()
	 * @generated
	 */
	EReference getTypeVariableMapping_TypeArg();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.LiteralTypeRef <em>Literal Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.LiteralTypeRef
	 * @generated
	 */
	EClass getLiteralTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.LiteralTypeRef#getAstValue <em>Ast Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ast Value</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.LiteralTypeRef#getAstValue()
	 * @see #getLiteralTypeRef()
	 * @generated
	 */
	EAttribute getLiteralTypeRef_AstValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.LiteralTypeRef#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.LiteralTypeRef#getValue()
	 * @generated
	 */
	EOperation getLiteralTypeRef__GetValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.BooleanLiteralTypeRef <em>Boolean Literal Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.BooleanLiteralTypeRef
	 * @generated
	 */
	EClass getBooleanLiteralTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.BooleanLiteralTypeRef#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.BooleanLiteralTypeRef#getValue()
	 * @see #getBooleanLiteralTypeRef()
	 * @generated
	 */
	EAttribute getBooleanLiteralTypeRef_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.BooleanLiteralTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.BooleanLiteralTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getBooleanLiteralTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef <em>Numeric Literal Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef
	 * @generated
	 */
	EClass getNumericLiteralTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef#isAstNegated <em>Ast Negated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ast Negated</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef#isAstNegated()
	 * @see #getNumericLiteralTypeRef()
	 * @generated
	 */
	EAttribute getNumericLiteralTypeRef_AstNegated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef#getValue()
	 * @see #getNumericLiteralTypeRef()
	 * @generated
	 */
	EAttribute getNumericLiteralTypeRef_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getNumericLiteralTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.StringLiteralTypeRef <em>String Literal Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.StringLiteralTypeRef
	 * @generated
	 */
	EClass getStringLiteralTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.typeRefs.StringLiteralTypeRef#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.StringLiteralTypeRef#getValue()
	 * @see #getStringLiteralTypeRef()
	 * @generated
	 */
	EAttribute getStringLiteralTypeRef_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.StringLiteralTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.StringLiteralTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getStringLiteralTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.typeRefs.EnumLiteralTypeRef <em>Enum Literal Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.EnumLiteralTypeRef
	 * @generated
	 */
	EClass getEnumLiteralTypeRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.typeRefs.EnumLiteralTypeRef#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.EnumLiteralTypeRef#getValue()
	 * @see #getEnumLiteralTypeRef()
	 * @generated
	 */
	EReference getEnumLiteralTypeRef_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.EnumLiteralTypeRef#getEnumType() <em>Get Enum Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Enum Type</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.EnumLiteralTypeRef#getEnumType()
	 * @generated
	 */
	EOperation getEnumLiteralTypeRef__GetEnumType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.typeRefs.EnumLiteralTypeRef#internalGetTypeRefAsString() <em>Internal Get Type Ref As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Internal Get Type Ref As String</em>' operation.
	 * @see org.eclipse.n4js.ts.typeRefs.EnumLiteralTypeRef#internalGetTypeRefAsString()
	 * @generated
	 */
	EOperation getEnumLiteralTypeRef__InternalGetTypeRefAsString();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.n4js.ts.typeRefs.OptionalFieldStrategy <em>Optional Field Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Optional Field Strategy</em>'.
	 * @see org.eclipse.n4js.ts.typeRefs.OptionalFieldStrategy
	 * @generated
	 */
	EEnum getOptionalFieldStrategy();

	/**
	 * Returns the meta object for data type '{@link java.util.UUID <em>UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UUID</em>'.
	 * @see java.util.UUID
	 * @model instanceClass="java.util.UUID"
	 * @generated
	 */
	EDataType getUUID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypeRefsFactory getTypeRefsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.TypeArgumentImpl <em>Type Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeArgumentImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getTypeArgument()
		 * @generated
		 */
		EClass TYPE_ARGUMENT = eINSTANCE.getTypeArgument();

		/**
		 * The meta object literal for the '<em><b>Is Type Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_ARGUMENT___IS_TYPE_REF = eINSTANCE.getTypeArgument__IsTypeRef();

		/**
		 * The meta object literal for the '<em><b>Get Declared Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_ARGUMENT___GET_DECLARED_TYPE = eINSTANCE.getTypeArgument__GetDeclaredType();

		/**
		 * The meta object literal for the '<em><b>Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_ARGUMENT___GET_TYPE_REF_AS_STRING = eINSTANCE.getTypeArgument__GetTypeRefAsString();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_ARGUMENT___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getTypeArgument__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.TypeRefImpl <em>Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getTypeRef()
		 * @generated
		 */
		EClass TYPE_REF = eINSTANCE.getTypeRef();

		/**
		 * The meta object literal for the '<em><b>Followed By Question Mark</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_REF__FOLLOWED_BY_QUESTION_MARK = eINSTANCE.getTypeRef_FollowedByQuestionMark();

		/**
		 * The meta object literal for the '<em><b>Original Alias Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_REF__ORIGINAL_ALIAS_TYPE_REF = eINSTANCE.getTypeRef_OriginalAliasTypeRef();

		/**
		 * The meta object literal for the '<em><b>Get Modifiers As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_MODIFIERS_AS_STRING = eINSTANCE.getTypeRef__GetModifiersAsString();

		/**
		 * The meta object literal for the '<em><b>Is Type Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_TYPE_REF = eINSTANCE.getTypeRef__IsTypeRef();

		/**
		 * The meta object literal for the '<em><b>Is Alias Unresolved</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_ALIAS_UNRESOLVED = eINSTANCE.getTypeRef__IsAliasUnresolved();

		/**
		 * The meta object literal for the '<em><b>Is Alias Resolved</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_ALIAS_RESOLVED = eINSTANCE.getTypeRef__IsAliasResolved();

		/**
		 * The meta object literal for the '<em><b>Is Final By Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_FINAL_BY_TYPE = eINSTANCE.getTypeRef__IsFinalByType();

		/**
		 * The meta object literal for the '<em><b>Is Array Like</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_ARRAY_LIKE = eINSTANCE.getTypeRef__IsArrayLike();

		/**
		 * The meta object literal for the '<em><b>Is Unknown</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_UNKNOWN = eINSTANCE.getTypeRef__IsUnknown();

		/**
		 * The meta object literal for the '<em><b>Is Dynamic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_DYNAMIC = eINSTANCE.getTypeRef__IsDynamic();

		/**
		 * The meta object literal for the '<em><b>Is Existential</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_EXISTENTIAL = eINSTANCE.getTypeRef__IsExistential();

		/**
		 * The meta object literal for the '<em><b>Is Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_GENERIC = eINSTANCE.getTypeRef__IsGeneric();

		/**
		 * The meta object literal for the '<em><b>Is Parameterized</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_PARAMETERIZED = eINSTANCE.getTypeRef__IsParameterized();

		/**
		 * The meta object literal for the '<em><b>Is Raw</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_RAW = eINSTANCE.getTypeRef__IsRaw();

		/**
		 * The meta object literal for the '<em><b>Get Declared Upper Bound</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_DECLARED_UPPER_BOUND = eINSTANCE.getTypeRef__GetDeclaredUpperBound();

		/**
		 * The meta object literal for the '<em><b>Get Declared Lower Bound</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_DECLARED_LOWER_BOUND = eINSTANCE.getTypeRef__GetDeclaredLowerBound();

		/**
		 * The meta object literal for the '<em><b>Get Declared Type Args</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_DECLARED_TYPE_ARGS = eINSTANCE.getTypeRef__GetDeclaredTypeArgs();

		/**
		 * The meta object literal for the '<em><b>Get Type Args With Defaults</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = eINSTANCE.getTypeRef__GetTypeArgsWithDefaults();

		/**
		 * The meta object literal for the '<em><b>Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_TYPE_REF_AS_STRING = eINSTANCE.getTypeRef__GetTypeRefAsString();

		/**
		 * The meta object literal for the '<em><b>Get Type Ref As String With Alias Resolution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_TYPE_REF_AS_STRING_WITH_ALIAS_RESOLUTION = eINSTANCE.getTypeRef__GetTypeRefAsStringWithAliasResolution();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___TO_STRING = eINSTANCE.getTypeRef__ToString();

		/**
		 * The meta object literal for the '<em><b>Is Top Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_TOP_TYPE = eINSTANCE.getTypeRef__IsTopType();

		/**
		 * The meta object literal for the '<em><b>Is Bottom Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_BOTTOM_TYPE = eINSTANCE.getTypeRef__IsBottomType();

		/**
		 * The meta object literal for the '<em><b>Get Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_TYPING_STRATEGY = eINSTANCE.getTypeRef__GetTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Get Structural Members</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_STRUCTURAL_MEMBERS = eINSTANCE.getTypeRef__GetStructuralMembers();

		/**
		 * The meta object literal for the '<em><b>Is Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_STRUCTURAL_TYPING = eINSTANCE.getTypeRef__IsStructuralTyping();

		/**
		 * The meta object literal for the '<em><b>Is Use Site Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = eINSTANCE.getTypeRef__IsUseSiteStructuralTyping();

		/**
		 * The meta object literal for the '<em><b>Is Def Site Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = eINSTANCE.getTypeRef__IsDefSiteStructuralTyping();

		/**
		 * The meta object literal for the '<em><b>Get AST Node Optional Field Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_REF___GET_AST_NODE_OPTIONAL_FIELD_STRATEGY = eINSTANCE.getTypeRef__GetASTNodeOptionalFieldStrategy();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.BaseTypeRefImpl <em>Base Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.BaseTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getBaseTypeRef()
		 * @generated
		 */
		EClass BASE_TYPE_REF = eINSTANCE.getBaseTypeRef();

		/**
		 * The meta object literal for the '<em><b>Dynamic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_TYPE_REF__DYNAMIC = eINSTANCE.getBaseTypeRef_Dynamic();

		/**
		 * The meta object literal for the '<em><b>Get Modifiers As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BASE_TYPE_REF___GET_MODIFIERS_AS_STRING = eINSTANCE.getBaseTypeRef__GetModifiersAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ComposedTypeRefImpl <em>Composed Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.ComposedTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getComposedTypeRef()
		 * @generated
		 */
		EClass COMPOSED_TYPE_REF = eINSTANCE.getComposedTypeRef();

		/**
		 * The meta object literal for the '<em><b>Type Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_TYPE_REF__TYPE_REFS = eINSTANCE.getComposedTypeRef_TypeRefs();

		/**
		 * The meta object literal for the '<em><b>Is Dynamic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSED_TYPE_REF___IS_DYNAMIC = eINSTANCE.getComposedTypeRef__IsDynamic();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSED_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getComposedTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.UnionTypeExpressionImpl <em>Union Type Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.UnionTypeExpressionImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getUnionTypeExpression()
		 * @generated
		 */
		EClass UNION_TYPE_EXPRESSION = eINSTANCE.getUnionTypeExpression();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNION_TYPE_EXPRESSION___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getUnionTypeExpression__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.IntersectionTypeExpressionImpl <em>Intersection Type Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.IntersectionTypeExpressionImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getIntersectionTypeExpression()
		 * @generated
		 */
		EClass INTERSECTION_TYPE_EXPRESSION = eINSTANCE.getIntersectionTypeExpression();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTERSECTION_TYPE_EXPRESSION___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getIntersectionTypeExpression__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefImpl <em>This Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getThisTypeRef()
		 * @generated
		 */
		EClass THIS_TYPE_REF = eINSTANCE.getThisTypeRef();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getThisTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '<em><b>Get Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF___GET_TYPING_STRATEGY = eINSTANCE.getThisTypeRef__GetTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Get Structural Members</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF___GET_STRUCTURAL_MEMBERS = eINSTANCE.getThisTypeRef__GetStructuralMembers();

		/**
		 * The meta object literal for the '<em><b>Is Use Site Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = eINSTANCE.getThisTypeRef__IsUseSiteStructuralTyping();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefNominalImpl <em>This Type Ref Nominal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefNominalImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getThisTypeRefNominal()
		 * @generated
		 */
		EClass THIS_TYPE_REF_NOMINAL = eINSTANCE.getThisTypeRefNominal();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefStructuralImpl <em>This Type Ref Structural</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.ThisTypeRefStructuralImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getThisTypeRefStructural()
		 * @generated
		 */
		EClass THIS_TYPE_REF_STRUCTURAL = eINSTANCE.getThisTypeRefStructural();

		/**
		 * The meta object literal for the '<em><b>Defined Typing Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THIS_TYPE_REF_STRUCTURAL__DEFINED_TYPING_STRATEGY = eINSTANCE.getThisTypeRefStructural_DefinedTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Get Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF_STRUCTURAL___GET_TYPING_STRATEGY = eINSTANCE.getThisTypeRefStructural__GetTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Set Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF_STRUCTURAL___SET_TYPING_STRATEGY__TYPINGSTRATEGY = eINSTANCE.getThisTypeRefStructural__SetTypingStrategy__TypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Is Use Site Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF_STRUCTURAL___IS_USE_SITE_STRUCTURAL_TYPING = eINSTANCE.getThisTypeRefStructural__IsUseSiteStructuralTyping();

		/**
		 * The meta object literal for the '<em><b>Get Structural Members</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF_STRUCTURAL___GET_STRUCTURAL_MEMBERS = eINSTANCE.getThisTypeRefStructural__GetStructuralMembers();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THIS_TYPE_REF_STRUCTURAL___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getThisTypeRefStructural__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.BoundThisTypeRefImpl <em>Bound This Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.BoundThisTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getBoundThisTypeRef()
		 * @generated
		 */
		EClass BOUND_THIS_TYPE_REF = eINSTANCE.getBoundThisTypeRef();

		/**
		 * The meta object literal for the '<em><b>Actual This Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_THIS_TYPE_REF__ACTUAL_THIS_TYPE_REF = eINSTANCE.getBoundThisTypeRef_ActualThisTypeRef();

		/**
		 * The meta object literal for the '<em><b>Defined Typing Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUND_THIS_TYPE_REF__DEFINED_TYPING_STRATEGY = eINSTANCE.getBoundThisTypeRef_DefinedTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Get Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUND_THIS_TYPE_REF___GET_TYPING_STRATEGY = eINSTANCE.getBoundThisTypeRef__GetTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Set Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUND_THIS_TYPE_REF___SET_TYPING_STRATEGY__TYPINGSTRATEGY = eINSTANCE.getBoundThisTypeRef__SetTypingStrategy__TypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUND_THIS_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getBoundThisTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '<em><b>Get Declared Upper Bound</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUND_THIS_TYPE_REF___GET_DECLARED_UPPER_BOUND = eINSTANCE.getBoundThisTypeRef__GetDeclaredUpperBound();

		/**
		 * The meta object literal for the '<em><b>Is Def Site Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUND_THIS_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = eINSTANCE.getBoundThisTypeRef__IsDefSiteStructuralTyping();

		/**
		 * The meta object literal for the '<em><b>Is Use Site Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUND_THIS_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = eINSTANCE.getBoundThisTypeRef__IsUseSiteStructuralTyping();

		/**
		 * The meta object literal for the '<em><b>Get Structural Members</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUND_THIS_TYPE_REF___GET_STRUCTURAL_MEMBERS = eINSTANCE.getBoundThisTypeRef__GetStructuralMembers();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ParameterizedTypeRefImpl <em>Parameterized Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.ParameterizedTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getParameterizedTypeRef()
		 * @generated
		 */
		EClass PARAMETERIZED_TYPE_REF = eINSTANCE.getParameterizedTypeRef();

		/**
		 * The meta object literal for the '<em><b>Declared Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE_REF__DECLARED_TYPE = eINSTANCE.getParameterizedTypeRef_DeclaredType();

		/**
		 * The meta object literal for the '<em><b>Declared Type As Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETERIZED_TYPE_REF__DECLARED_TYPE_AS_TEXT = eINSTANCE.getParameterizedTypeRef_DeclaredTypeAsText();

		/**
		 * The meta object literal for the '<em><b>Declared Type Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE_REF__DECLARED_TYPE_ARGS = eINSTANCE.getParameterizedTypeRef_DeclaredTypeArgs();

		/**
		 * The meta object literal for the '<em><b>Array Type Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETERIZED_TYPE_REF__ARRAY_TYPE_EXPRESSION = eINSTANCE.getParameterizedTypeRef_ArrayTypeExpression();

		/**
		 * The meta object literal for the '<em><b>Array NType Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETERIZED_TYPE_REF__ARRAY_NTYPE_EXPRESSION = eINSTANCE.getParameterizedTypeRef_ArrayNTypeExpression();

		/**
		 * The meta object literal for the '<em><b>Ast Namespace Like Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE_REF__AST_NAMESPACE_LIKE_REFS = eINSTANCE.getParameterizedTypeRef_AstNamespaceLikeRefs();

		/**
		 * The meta object literal for the '<em><b>AST Node Optional Field Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETERIZED_TYPE_REF__AST_NODE_OPTIONAL_FIELD_STRATEGY = eINSTANCE.getParameterizedTypeRef_ASTNodeOptionalFieldStrategy();

		/**
		 * The meta object literal for the '<em><b>Defined Typing Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETERIZED_TYPE_REF__DEFINED_TYPING_STRATEGY = eINSTANCE.getParameterizedTypeRef_DefinedTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Get Previous Sibling</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___GET_PREVIOUS_SIBLING__NAMESPACELIKEREF = eINSTANCE.getParameterizedTypeRef__GetPreviousSibling__NamespaceLikeRef();

		/**
		 * The meta object literal for the '<em><b>Get Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___GET_TYPING_STRATEGY = eINSTANCE.getParameterizedTypeRef__GetTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Get Type Args With Defaults</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___GET_TYPE_ARGS_WITH_DEFAULTS = eINSTANCE.getParameterizedTypeRef__GetTypeArgsWithDefaults();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getParameterizedTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '<em><b>Is Parameterized</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___IS_PARAMETERIZED = eINSTANCE.getParameterizedTypeRef__IsParameterized();

		/**
		 * The meta object literal for the '<em><b>Is Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___IS_GENERIC = eINSTANCE.getParameterizedTypeRef__IsGeneric();

		/**
		 * The meta object literal for the '<em><b>Is Raw</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___IS_RAW = eINSTANCE.getParameterizedTypeRef__IsRaw();

		/**
		 * The meta object literal for the '<em><b>Is Use Site Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___IS_USE_SITE_STRUCTURAL_TYPING = eINSTANCE.getParameterizedTypeRef__IsUseSiteStructuralTyping();

		/**
		 * The meta object literal for the '<em><b>Is Def Site Structural Typing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF___IS_DEF_SITE_STRUCTURAL_TYPING = eINSTANCE.getParameterizedTypeRef__IsDefSiteStructuralTyping();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.StructuralTypeRefImpl <em>Structural Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.StructuralTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getStructuralTypeRef()
		 * @generated
		 */
		EClass STRUCTURAL_TYPE_REF = eINSTANCE.getStructuralTypeRef();

		/**
		 * The meta object literal for the '<em><b>Ast Structural Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_TYPE_REF__AST_STRUCTURAL_MEMBERS = eINSTANCE.getStructuralTypeRef_AstStructuralMembers();

		/**
		 * The meta object literal for the '<em><b>Structural Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_TYPE_REF__STRUCTURAL_TYPE = eINSTANCE.getStructuralTypeRef_StructuralType();

		/**
		 * The meta object literal for the '<em><b>Gen Structural Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_TYPE_REF__GEN_STRUCTURAL_MEMBERS = eINSTANCE.getStructuralTypeRef_GenStructuralMembers();

		/**
		 * The meta object literal for the '<em><b>Postponed Substitutions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_TYPE_REF__POSTPONED_SUBSTITUTIONS = eINSTANCE.getStructuralTypeRef_PostponedSubstitutions();

		/**
		 * The meta object literal for the '<em><b>Get Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURAL_TYPE_REF___GET_TYPING_STRATEGY = eINSTANCE.getStructuralTypeRef__GetTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Set Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURAL_TYPE_REF___SET_TYPING_STRATEGY__TYPINGSTRATEGY = eINSTANCE.getStructuralTypeRef__SetTypingStrategy__TypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Get Structural Members</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURAL_TYPE_REF___GET_STRUCTURAL_MEMBERS = eINSTANCE.getStructuralTypeRef__GetStructuralMembers();

		/**
		 * The meta object literal for the '<em><b>Get Structural Members With Call Construct Signatures</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURAL_TYPE_REF___GET_STRUCTURAL_MEMBERS_WITH_CALL_CONSTRUCT_SIGNATURES = eINSTANCE.getStructuralTypeRef__GetStructuralMembersWithCallConstructSignatures();

		/**
		 * The meta object literal for the '<em><b>Has Postponed Substitution For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURAL_TYPE_REF___HAS_POSTPONED_SUBSTITUTION_FOR__TYPEVARIABLE = eINSTANCE.getStructuralTypeRef__HasPostponedSubstitutionFor__TypeVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ParameterizedTypeRefStructuralImpl <em>Parameterized Type Ref Structural</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.ParameterizedTypeRefStructuralImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getParameterizedTypeRefStructural()
		 * @generated
		 */
		EClass PARAMETERIZED_TYPE_REF_STRUCTURAL = eINSTANCE.getParameterizedTypeRefStructural();

		/**
		 * The meta object literal for the '<em><b>Get Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_TYPING_STRATEGY = eINSTANCE.getParameterizedTypeRefStructural__GetTypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Set Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF_STRUCTURAL___SET_TYPING_STRATEGY__TYPINGSTRATEGY = eINSTANCE.getParameterizedTypeRefStructural__SetTypingStrategy__TypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Get Structural Members</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF_STRUCTURAL___GET_STRUCTURAL_MEMBERS = eINSTANCE.getParameterizedTypeRefStructural__GetStructuralMembers();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERIZED_TYPE_REF_STRUCTURAL___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getParameterizedTypeRefStructural__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.ExistentialTypeRefImpl <em>Existential Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.ExistentialTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getExistentialTypeRef()
		 * @generated
		 */
		EClass EXISTENTIAL_TYPE_REF = eINSTANCE.getExistentialTypeRef();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXISTENTIAL_TYPE_REF__ID = eINSTANCE.getExistentialTypeRef_Id();

		/**
		 * The meta object literal for the '<em><b>Reopened</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXISTENTIAL_TYPE_REF__REOPENED = eINSTANCE.getExistentialTypeRef_Reopened();

		/**
		 * The meta object literal for the '<em><b>Wildcard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXISTENTIAL_TYPE_REF__WILDCARD = eINSTANCE.getExistentialTypeRef_Wildcard();

		/**
		 * The meta object literal for the '<em><b>Is Existential</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXISTENTIAL_TYPE_REF___IS_EXISTENTIAL = eINSTANCE.getExistentialTypeRef__IsExistential();

		/**
		 * The meta object literal for the '<em><b>Is Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXISTENTIAL_TYPE_REF___IS_GENERIC = eINSTANCE.getExistentialTypeRef__IsGeneric();

		/**
		 * The meta object literal for the '<em><b>Is Parameterized</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXISTENTIAL_TYPE_REF___IS_PARAMETERIZED = eINSTANCE.getExistentialTypeRef__IsParameterized();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXISTENTIAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getExistentialTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.UnknownTypeRefImpl <em>Unknown Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.UnknownTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getUnknownTypeRef()
		 * @generated
		 */
		EClass UNKNOWN_TYPE_REF = eINSTANCE.getUnknownTypeRef();

		/**
		 * The meta object literal for the '<em><b>Is Unknown</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNKNOWN_TYPE_REF___IS_UNKNOWN = eINSTANCE.getUnknownTypeRef__IsUnknown();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNKNOWN_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getUnknownTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.TypeTypeRefImpl <em>Type Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getTypeTypeRef()
		 * @generated
		 */
		EClass TYPE_TYPE_REF = eINSTANCE.getTypeTypeRef();

		/**
		 * The meta object literal for the '<em><b>Type Arg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TYPE_REF__TYPE_ARG = eINSTANCE.getTypeTypeRef_TypeArg();

		/**
		 * The meta object literal for the '<em><b>Constructor Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE_REF__CONSTRUCTOR_REF = eINSTANCE.getTypeTypeRef_ConstructorRef();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getTypeTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.NamespaceLikeRefImpl <em>Namespace Like Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.NamespaceLikeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getNamespaceLikeRef()
		 * @generated
		 */
		EClass NAMESPACE_LIKE_REF = eINSTANCE.getNamespaceLikeRef();

		/**
		 * The meta object literal for the '<em><b>Declared Type As Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMESPACE_LIKE_REF__DECLARED_TYPE_AS_TEXT = eINSTANCE.getNamespaceLikeRef_DeclaredTypeAsText();

		/**
		 * The meta object literal for the '<em><b>Declared Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMESPACE_LIKE_REF__DECLARED_TYPE = eINSTANCE.getNamespaceLikeRef_DeclaredType();

		/**
		 * The meta object literal for the '<em><b>Get Previous Sibling</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAMESPACE_LIKE_REF___GET_PREVIOUS_SIBLING = eINSTANCE.getNamespaceLikeRef__GetPreviousSibling();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.WildcardImpl <em>Wildcard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.WildcardImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getWildcard()
		 * @generated
		 */
		EClass WILDCARD = eINSTANCE.getWildcard();

		/**
		 * The meta object literal for the '<em><b>Declared Upper Bound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD__DECLARED_UPPER_BOUND = eINSTANCE.getWildcard_DeclaredUpperBound();

		/**
		 * The meta object literal for the '<em><b>Declared Lower Bound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD__DECLARED_LOWER_BOUND = eINSTANCE.getWildcard_DeclaredLowerBound();

		/**
		 * The meta object literal for the '<em><b>Using In Out Notation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WILDCARD__USING_IN_OUT_NOTATION = eINSTANCE.getWildcard_UsingInOutNotation();

		/**
		 * The meta object literal for the '<em><b>Get Declared Or Implicit Upper Bound</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WILDCARD___GET_DECLARED_OR_IMPLICIT_UPPER_BOUND = eINSTANCE.getWildcard__GetDeclaredOrImplicitUpperBound();

		/**
		 * The meta object literal for the '<em><b>Is Implicit Upper Bound In Effect</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WILDCARD___IS_IMPLICIT_UPPER_BOUND_IN_EFFECT = eINSTANCE.getWildcard__IsImplicitUpperBoundInEffect();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WILDCARD___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getWildcard__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl <em>Function Type Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getFunctionTypeExpression()
		 * @generated
		 */
		EClass FUNCTION_TYPE_EXPRESSION = eINSTANCE.getFunctionTypeExpression();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_TYPE_EXPRESSION__BINDING = eINSTANCE.getFunctionTypeExpression_Binding();

		/**
		 * The meta object literal for the '<em><b>Declared Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_EXPRESSION__DECLARED_FUNCTION = eINSTANCE.getFunctionTypeExpression_DeclaredFunction();

		/**
		 * The meta object literal for the '<em><b>Declared This Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE = eINSTANCE.getFunctionTypeExpression_DeclaredThisType();

		/**
		 * The meta object literal for the '<em><b>Owned Type Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_EXPRESSION__OWNED_TYPE_VARS = eINSTANCE.getFunctionTypeExpression_OwnedTypeVars();

		/**
		 * The meta object literal for the '<em><b>Unbound Type Vars</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS = eINSTANCE.getFunctionTypeExpression_UnboundTypeVars();

		/**
		 * The meta object literal for the '<em><b>Unbound Type Vars Upper Bounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS_UPPER_BOUNDS = eINSTANCE.getFunctionTypeExpression_UnboundTypeVarsUpperBounds();

		/**
		 * The meta object literal for the '<em><b>Fpars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_EXPRESSION__FPARS = eINSTANCE.getFunctionTypeExpression_Fpars();

		/**
		 * The meta object literal for the '<em><b>Return Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF = eINSTANCE.getFunctionTypeExpression_ReturnTypeRef();

		/**
		 * The meta object literal for the '<em><b>Return Value Marked Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_TYPE_EXPRESSION__RETURN_VALUE_MARKED_OPTIONAL = eINSTANCE.getFunctionTypeExpression_ReturnValueMarkedOptional();

		/**
		 * The meta object literal for the '<em><b>Is Return Value Optional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_TYPE_EXPRESSION___IS_RETURN_VALUE_OPTIONAL = eINSTANCE.getFunctionTypeExpression__IsReturnValueOptional();

		/**
		 * The meta object literal for the '<em><b>Get Type Vars</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_TYPE_EXPRESSION___GET_TYPE_VARS = eINSTANCE.getFunctionTypeExpression__GetTypeVars();

		/**
		 * The meta object literal for the '<em><b>Is Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_TYPE_EXPRESSION___IS_GENERIC = eINSTANCE.getFunctionTypeExpression__IsGeneric();

		/**
		 * The meta object literal for the '<em><b>Is Raw</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_TYPE_EXPRESSION___IS_RAW = eINSTANCE.getFunctionTypeExpression__IsRaw();

		/**
		 * The meta object literal for the '<em><b>Get Fpar For Arg Idx</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_TYPE_EXPRESSION___GET_FPAR_FOR_ARG_IDX__INT = eINSTANCE.getFunctionTypeExpression__GetFparForArgIdx__int();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_TYPE_EXPRESSION___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getFunctionTypeExpression__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '<em><b>Get Type Var Upper Bound</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_TYPE_EXPRESSION___GET_TYPE_VAR_UPPER_BOUND__TYPEVARIABLE = eINSTANCE.getFunctionTypeExpression__GetTypeVarUpperBound__TypeVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.DeferredTypeRefImpl <em>Deferred Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.DeferredTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getDeferredTypeRef()
		 * @generated
		 */
		EClass DEFERRED_TYPE_REF = eINSTANCE.getDeferredTypeRef();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEFERRED_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getDeferredTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.TypeVariableMappingImpl <em>Type Variable Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeVariableMappingImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getTypeVariableMapping()
		 * @generated
		 */
		EClass TYPE_VARIABLE_MAPPING = eINSTANCE.getTypeVariableMapping();

		/**
		 * The meta object literal for the '<em><b>Type Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_VARIABLE_MAPPING__TYPE_VAR = eINSTANCE.getTypeVariableMapping_TypeVar();

		/**
		 * The meta object literal for the '<em><b>Type Arg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_VARIABLE_MAPPING__TYPE_ARG = eINSTANCE.getTypeVariableMapping_TypeArg();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.LiteralTypeRefImpl <em>Literal Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.LiteralTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getLiteralTypeRef()
		 * @generated
		 */
		EClass LITERAL_TYPE_REF = eINSTANCE.getLiteralTypeRef();

		/**
		 * The meta object literal for the '<em><b>Ast Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_TYPE_REF__AST_VALUE = eINSTANCE.getLiteralTypeRef_AstValue();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_TYPE_REF___GET_VALUE = eINSTANCE.getLiteralTypeRef__GetValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.BooleanLiteralTypeRefImpl <em>Boolean Literal Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.BooleanLiteralTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getBooleanLiteralTypeRef()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_TYPE_REF = eINSTANCE.getBooleanLiteralTypeRef();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_TYPE_REF__VALUE = eINSTANCE.getBooleanLiteralTypeRef_Value();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getBooleanLiteralTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.NumericLiteralTypeRefImpl <em>Numeric Literal Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.NumericLiteralTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getNumericLiteralTypeRef()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_TYPE_REF = eINSTANCE.getNumericLiteralTypeRef();

		/**
		 * The meta object literal for the '<em><b>Ast Negated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_LITERAL_TYPE_REF__AST_NEGATED = eINSTANCE.getNumericLiteralTypeRef_AstNegated();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_LITERAL_TYPE_REF__VALUE = eINSTANCE.getNumericLiteralTypeRef_Value();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NUMERIC_LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getNumericLiteralTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.StringLiteralTypeRefImpl <em>String Literal Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.StringLiteralTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getStringLiteralTypeRef()
		 * @generated
		 */
		EClass STRING_LITERAL_TYPE_REF = eINSTANCE.getStringLiteralTypeRef();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_TYPE_REF__VALUE = eINSTANCE.getStringLiteralTypeRef_Value();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRING_LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getStringLiteralTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.impl.EnumLiteralTypeRefImpl <em>Enum Literal Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.impl.EnumLiteralTypeRefImpl
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getEnumLiteralTypeRef()
		 * @generated
		 */
		EClass ENUM_LITERAL_TYPE_REF = eINSTANCE.getEnumLiteralTypeRef();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_TYPE_REF__VALUE = eINSTANCE.getEnumLiteralTypeRef_Value();

		/**
		 * The meta object literal for the '<em><b>Get Enum Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENUM_LITERAL_TYPE_REF___GET_ENUM_TYPE = eINSTANCE.getEnumLiteralTypeRef__GetEnumType();

		/**
		 * The meta object literal for the '<em><b>Internal Get Type Ref As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENUM_LITERAL_TYPE_REF___INTERNAL_GET_TYPE_REF_AS_STRING = eINSTANCE.getEnumLiteralTypeRef__InternalGetTypeRefAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.typeRefs.OptionalFieldStrategy <em>Optional Field Strategy</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.typeRefs.OptionalFieldStrategy
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getOptionalFieldStrategy()
		 * @generated
		 */
		EEnum OPTIONAL_FIELD_STRATEGY = eINSTANCE.getOptionalFieldStrategy();

		/**
		 * The meta object literal for the '<em>UUID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.UUID
		 * @see org.eclipse.n4js.ts.typeRefs.impl.TypeRefsPackageImpl#getUUID()
		 * @generated
		 */
		EDataType UUID = eINSTANCE.getUUID();

	}

} //TypeRefsPackage
