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
package org.eclipse.n4js.ts.types;

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
 * @see org.eclipse.n4js.ts.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "types";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/n4js/ts/Types";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "types";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesPackage eINSTANCE = org.eclipse.n4js.ts.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TExportingElementImpl <em>TExporting Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TExportingElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTExportingElement()
	 * @generated
	 */
	int TEXPORTING_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Export Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTING_ELEMENT__EXPORT_DEFINITIONS = 0;

	/**
	 * The number of structural features of the '<em>TExporting Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTING_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>TExporting Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTING_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.AbstractNamespaceImpl <em>Abstract Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.AbstractNamespaceImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getAbstractNamespace()
	 * @generated
	 */
	int ABSTRACT_NAMESPACE = 24;

	/**
	 * The feature id for the '<em><b>Export Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE__EXPORT_DEFINITIONS = TEXPORTING_ELEMENT__EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE__ANNOTATIONS = TEXPORTING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE__TYPES = TEXPORTING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE__FUNCTIONS = TEXPORTING_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exported Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE__EXPORTED_VARIABLES = TEXPORTING_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Local Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE__LOCAL_VARIABLES = TEXPORTING_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Exposed Local Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE__EXPOSED_LOCAL_VARIABLES = TEXPORTING_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Namespaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE__NAMESPACES = TEXPORTING_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Abstract Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE_FEATURE_COUNT = TEXPORTING_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Types And Functions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE___GET_TYPES_AND_FUNCTIONS = TEXPORTING_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Exportable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE___GET_EXPORTABLE_ELEMENTS = TEXPORTING_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get All Namespaces</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE___GET_ALL_NAMESPACES = TEXPORTING_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE___GET_CONTAINING_MODULE = TEXPORTING_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Clear Transient Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE___CLEAR_TRANSIENT_ELEMENTS = TEXPORTING_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Abstract Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMESPACE_OPERATION_COUNT = TEXPORTING_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TModuleImpl <em>TModule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TModuleImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTModule()
	 * @generated
	 */
	int TMODULE = 0;

	/**
	 * The feature id for the '<em><b>Export Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__EXPORT_DEFINITIONS = ABSTRACT_NAMESPACE__EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__ANNOTATIONS = ABSTRACT_NAMESPACE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__TYPES = ABSTRACT_NAMESPACE__TYPES;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__FUNCTIONS = ABSTRACT_NAMESPACE__FUNCTIONS;

	/**
	 * The feature id for the '<em><b>Exported Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__EXPORTED_VARIABLES = ABSTRACT_NAMESPACE__EXPORTED_VARIABLES;

	/**
	 * The feature id for the '<em><b>Local Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__LOCAL_VARIABLES = ABSTRACT_NAMESPACE__LOCAL_VARIABLES;

	/**
	 * The feature id for the '<em><b>Exposed Local Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__EXPOSED_LOCAL_VARIABLES = ABSTRACT_NAMESPACE__EXPOSED_LOCAL_VARIABLES;

	/**
	 * The feature id for the '<em><b>Namespaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__NAMESPACES = ABSTRACT_NAMESPACE__NAMESPACES;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__AST_ELEMENT = ABSTRACT_NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__SIMPLE_NAME = ABSTRACT_NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__QUALIFIED_NAME = ABSTRACT_NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__PACKAGE_NAME = ABSTRACT_NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Project ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__PROJECT_ID = ABSTRACT_NAMESPACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Vendor ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__VENDOR_ID = ABSTRACT_NAMESPACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>N4jsd Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__N4JSD_MODULE = ABSTRACT_NAMESPACE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Static Polyfill Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__STATIC_POLYFILL_MODULE = ABSTRACT_NAMESPACE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Static Polyfill Aware</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__STATIC_POLYFILL_AWARE = ABSTRACT_NAMESPACE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Main Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__MAIN_MODULE = ABSTRACT_NAMESPACE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Pre Linking Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__PRE_LINKING_PHASE = ABSTRACT_NAMESPACE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Reconciled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__RECONCILED = ABSTRACT_NAMESPACE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Dependencies Runtime</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__DEPENDENCIES_RUNTIME = ABSTRACT_NAMESPACE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Cyclic Modules Runtime</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__CYCLIC_MODULES_RUNTIME = ABSTRACT_NAMESPACE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Cyclic Modules Loadtime For Inheritance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__CYCLIC_MODULES_LOADTIME_FOR_INHERITANCE = ABSTRACT_NAMESPACE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Runtime Cyclic Loadtime Dependents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__RUNTIME_CYCLIC_LOADTIME_DEPENDENTS = ABSTRACT_NAMESPACE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Internal Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__INTERNAL_TYPES = ABSTRACT_NAMESPACE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Exposed Internal Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__EXPOSED_INTERNAL_TYPES = ABSTRACT_NAMESPACE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Internal Dynamic Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__INTERNAL_DYNAMIC_ELEMENTS = ABSTRACT_NAMESPACE_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Ast MD5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__AST_MD5 = ABSTRACT_NAMESPACE_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Composed Member Caches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__COMPOSED_MEMBER_CACHES = ABSTRACT_NAMESPACE_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Temporary Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__TEMPORARY_TYPES = ABSTRACT_NAMESPACE_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Module Specifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE__MODULE_SPECIFIER = ABSTRACT_NAMESPACE_FEATURE_COUNT + 22;

	/**
	 * The number of structural features of the '<em>TModule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE_FEATURE_COUNT = ABSTRACT_NAMESPACE_FEATURE_COUNT + 23;

	/**
	 * The operation id for the '<em>Get Types And Functions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE___GET_TYPES_AND_FUNCTIONS = ABSTRACT_NAMESPACE___GET_TYPES_AND_FUNCTIONS;

	/**
	 * The operation id for the '<em>Get Exportable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE___GET_EXPORTABLE_ELEMENTS = ABSTRACT_NAMESPACE___GET_EXPORTABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Get All Namespaces</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE___GET_ALL_NAMESPACES = ABSTRACT_NAMESPACE___GET_ALL_NAMESPACES;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE___GET_CONTAINING_MODULE = ABSTRACT_NAMESPACE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE___GET_AST_ELEMENT_NO_RESOLVE = ABSTRACT_NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Clear Transient Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE___CLEAR_TRANSIENT_ELEMENTS = ABSTRACT_NAMESPACE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>TModule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODULE_OPERATION_COUNT = ABSTRACT_NAMESPACE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.RuntimeDependencyImpl <em>Runtime Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.RuntimeDependencyImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getRuntimeDependency()
	 * @generated
	 */
	int RUNTIME_DEPENDENCY = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_DEPENDENCY__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Loadtime For Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_DEPENDENCY__LOADTIME_FOR_INHERITANCE = 1;

	/**
	 * The number of structural features of the '<em>Runtime Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_DEPENDENCY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Runtime Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.ComposedMemberCacheImpl <em>Composed Member Cache</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.ComposedMemberCacheImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getComposedMemberCache()
	 * @generated
	 */
	int COMPOSED_MEMBER_CACHE = 2;

	/**
	 * The feature id for the '<em><b>Cached Composed Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MEMBER_CACHE__CACHED_COMPOSED_MEMBERS = 0;

	/**
	 * The feature id for the '<em><b>Composed Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MEMBER_CACHE__COMPOSED_TYPE_REF = 1;

	/**
	 * The number of structural features of the '<em>Composed Member Cache</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MEMBER_CACHE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Composed Member Cache</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MEMBER_CACHE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.TypableElement <em>Typable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.TypableElement
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypableElement()
	 * @generated
	 */
	int TYPABLE_ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>Typable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPABLE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Typable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPABLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.IdentifiableElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIdentifiableElement()
	 * @generated
	 */
	int IDENTIFIABLE_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT__NAME = TYPABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT_FEATURE_COUNT = TYPABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT___GET_CONTAINING_MODULE = TYPABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Identifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT_OPERATION_COUNT = TYPABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.ExportDefinitionImpl <em>Export Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.ExportDefinitionImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getExportDefinition()
	 * @generated
	 */
	int EXPORT_DEFINITION = 6;

	/**
	 * The number of structural features of the '<em>Export Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_DEFINITION_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_DEFINITION___GET_CONTAINING_MODULE = 0;

	/**
	 * The number of operations of the '<em>Export Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_DEFINITION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.ElementExportDefinitionImpl <em>Element Export Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.ElementExportDefinitionImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getElementExportDefinition()
	 * @generated
	 */
	int ELEMENT_EXPORT_DEFINITION = 7;

	/**
	 * The feature id for the '<em><b>Exported Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXPORT_DEFINITION__EXPORTED_NAME = EXPORT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exported Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXPORT_DEFINITION__EXPORTED_ELEMENT = EXPORT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Element Export Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXPORT_DEFINITION_FEATURE_COUNT = EXPORT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXPORT_DEFINITION___GET_CONTAINING_MODULE = EXPORT_DEFINITION___GET_CONTAINING_MODULE;

	/**
	 * The number of operations of the '<em>Element Export Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXPORT_DEFINITION_OPERATION_COUNT = EXPORT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.ModuleExportDefinitionImpl <em>Module Export Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.ModuleExportDefinitionImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getModuleExportDefinition()
	 * @generated
	 */
	int MODULE_EXPORT_DEFINITION = 8;

	/**
	 * The feature id for the '<em><b>Exported Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EXPORT_DEFINITION__EXPORTED_MODULE = EXPORT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Export Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EXPORT_DEFINITION_FEATURE_COUNT = EXPORT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EXPORT_DEFINITION___GET_CONTAINING_MODULE = EXPORT_DEFINITION___GET_CONTAINING_MODULE;

	/**
	 * The number of operations of the '<em>Module Export Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EXPORT_DEFINITION_OPERATION_COUNT = EXPORT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TExportableElementImpl <em>TExportable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TExportableElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTExportableElement()
	 * @generated
	 */
	int TEXPORTABLE_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT__NAME = IDENTIFIABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT__DIRECTLY_EXPORTED = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT__DIRECTLY_EXPORTED_AS_DEFAULT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT__EXPORTING_EXPORT_DEFINITIONS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TExportable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT___GET_CONTAINING_MODULE = IDENTIFIABLE_ELEMENT___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT___IS_EXPORTED = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT___IS_INDIRECTLY_EXPORTED = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT___GET_DIRECTLY_EXPORTED_NAME = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>TExportable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPORTABLE_ELEMENT_OPERATION_COUNT = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TDynamicElementImpl <em>TDynamic Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TDynamicElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTDynamicElement()
	 * @generated
	 */
	int TDYNAMIC_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT__NAME = TEXPORTABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT__DIRECTLY_EXPORTED = TEXPORTABLE_ELEMENT__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT__DIRECTLY_EXPORTED_AS_DEFAULT = TEXPORTABLE_ELEMENT__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT__EXPORTING_EXPORT_DEFINITIONS = TEXPORTABLE_ELEMENT__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT__AST_ELEMENT = TEXPORTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TDynamic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT_FEATURE_COUNT = TEXPORTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT___GET_CONTAINING_MODULE = TEXPORTABLE_ELEMENT___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT___IS_EXPORTED = TEXPORTABLE_ELEMENT___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT___IS_INDIRECTLY_EXPORTED = TEXPORTABLE_ELEMENT___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT___GET_DIRECTLY_EXPORTED_NAME = TEXPORTABLE_ELEMENT___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT___GET_AST_ELEMENT_NO_RESOLVE = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TDynamic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDYNAMIC_ELEMENT_OPERATION_COUNT = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotationImpl <em>TAnnotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TAnnotationImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotation()
	 * @generated
	 */
	int TANNOTATION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION__ARGS = 1;

	/**
	 * The number of structural features of the '<em>TAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Has String Argument</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION___HAS_STRING_ARGUMENT__STRING = 0;

	/**
	 * The operation id for the '<em>Get Annotation As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION___GET_ANNOTATION_AS_STRING = 1;

	/**
	 * The number of operations of the '<em>TAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotationArgumentImpl <em>TAnnotation Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TAnnotationArgumentImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotationArgument()
	 * @generated
	 */
	int TANNOTATION_ARGUMENT = 12;

	/**
	 * The number of structural features of the '<em>TAnnotation Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_ARGUMENT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Arg As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_ARGUMENT___GET_ARG_AS_STRING = 0;

	/**
	 * The number of operations of the '<em>TAnnotation Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_ARGUMENT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotationStringArgumentImpl <em>TAnnotation String Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TAnnotationStringArgumentImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotationStringArgument()
	 * @generated
	 */
	int TANNOTATION_STRING_ARGUMENT = 13;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_STRING_ARGUMENT__VALUE = TANNOTATION_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TAnnotation String Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_STRING_ARGUMENT_FEATURE_COUNT = TANNOTATION_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Arg As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_STRING_ARGUMENT___GET_ARG_AS_STRING = TANNOTATION_ARGUMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TAnnotation String Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_STRING_ARGUMENT_OPERATION_COUNT = TANNOTATION_ARGUMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.TTypedElement <em>TTyped Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.TTypedElement
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTTypedElement()
	 * @generated
	 */
	int TTYPED_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTYPED_ELEMENT__TYPE_REF = 0;

	/**
	 * The number of structural features of the '<em>TTyped Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTYPED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>TTyped Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTYPED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotationTypeRefArgumentImpl <em>TAnnotation Type Ref Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TAnnotationTypeRefArgumentImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotationTypeRefArgument()
	 * @generated
	 */
	int TANNOTATION_TYPE_REF_ARGUMENT = 15;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_TYPE_REF_ARGUMENT__TYPE_REF = TANNOTATION_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TAnnotation Type Ref Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_TYPE_REF_ARGUMENT_FEATURE_COUNT = TANNOTATION_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Arg As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_TYPE_REF_ARGUMENT___GET_ARG_AS_STRING = TANNOTATION_ARGUMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TAnnotation Type Ref Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTATION_TYPE_REF_ARGUMENT_OPERATION_COUNT = TANNOTATION_ARGUMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotableElementImpl <em>TAnnotable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TAnnotableElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotableElement()
	 * @generated
	 */
	int TANNOTABLE_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTABLE_ELEMENT__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>TAnnotable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>TAnnotable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANNOTABLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = TEXPORTABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__DIRECTLY_EXPORTED = TEXPORTABLE_ELEMENT__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = TEXPORTABLE_ELEMENT__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__EXPORTING_EXPORT_DEFINITIONS = TEXPORTABLE_ELEMENT__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ANNOTATIONS = TEXPORTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = TEXPORTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_CONTAINING_MODULE = TEXPORTABLE_ELEMENT___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_EXPORTED = TEXPORTABLE_ELEMENT___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_INDIRECTLY_EXPORTED = TEXPORTABLE_ELEMENT___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_DIRECTLY_EXPORTED_NAME = TEXPORTABLE_ELEMENT___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_HOLLOW = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_ALIAS = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_PROVIDED_BY_RUNTIME = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_POLYFILL = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_STATIC_POLYFILL = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_FINAL = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_DYNAMIZABLE = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_ARRAY_LIKE = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_ELEMENT_TYPE = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_TYPE_ACCESS_MODIFIER = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_GENERIC = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_TYPE_VARS = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_RAW_TYPE_AS_STRING = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_TYPE_AS_STRING = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = TEXPORTABLE_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TypeVariableImpl <em>Type Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TypeVariableImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypeVariable()
	 * @generated
	 */
	int TYPE_VARIABLE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__DIRECTLY_EXPORTED = TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__DIRECTLY_EXPORTED_AS_DEFAULT = TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__EXPORTING_EXPORT_DEFINITIONS = TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declared Covariant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__DECLARED_COVARIANT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Contravariant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__DECLARED_CONTRAVARIANT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Upper Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__DECLARED_UPPER_BOUND = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__DEFAULT_ARGUMENT = TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Type Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_CONTAINING_MODULE = TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_EXPORTED = TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_INDIRECTLY_EXPORTED = TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_DIRECTLY_EXPORTED_NAME = TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_HOLLOW = TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_ALIAS = TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_PROVIDED_BY_RUNTIME = TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_POLYFILL = TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_STATIC_POLYFILL = TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_FINAL = TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_DYNAMIZABLE = TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_ARRAY_LIKE = TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_ELEMENT_TYPE = TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_TYPE_ACCESS_MODIFIER = TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_GENERIC = TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_TYPE_VARS = TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_VARIANCE_OF_TYPE_VAR__INT = TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_RAW_TYPE_AS_STRING = TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Variance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_VARIANCE = TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___IS_OPTIONAL = TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_TYPE_AS_STRING = TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Type Variable As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE___GET_TYPE_VARIABLE_AS_STRING__TYPEREF = TYPE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Type Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.InferenceVariableImpl <em>Inference Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.InferenceVariableImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getInferenceVariable()
	 * @generated
	 */
	int INFERENCE_VARIABLE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__NAME = TYPE_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__DIRECTLY_EXPORTED = TYPE_VARIABLE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__DIRECTLY_EXPORTED_AS_DEFAULT = TYPE_VARIABLE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__EXPORTING_EXPORT_DEFINITIONS = TYPE_VARIABLE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__ANNOTATIONS = TYPE_VARIABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declared Covariant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__DECLARED_COVARIANT = TYPE_VARIABLE__DECLARED_COVARIANT;

	/**
	 * The feature id for the '<em><b>Declared Contravariant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__DECLARED_CONTRAVARIANT = TYPE_VARIABLE__DECLARED_CONTRAVARIANT;

	/**
	 * The feature id for the '<em><b>Declared Upper Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__DECLARED_UPPER_BOUND = TYPE_VARIABLE__DECLARED_UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Default Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE__DEFAULT_ARGUMENT = TYPE_VARIABLE__DEFAULT_ARGUMENT;

	/**
	 * The number of structural features of the '<em>Inference Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE_FEATURE_COUNT = TYPE_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_CONTAINING_MODULE = TYPE_VARIABLE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_EXPORTED = TYPE_VARIABLE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_INDIRECTLY_EXPORTED = TYPE_VARIABLE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_DIRECTLY_EXPORTED_NAME = TYPE_VARIABLE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_HOLLOW = TYPE_VARIABLE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_ALIAS = TYPE_VARIABLE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_PROVIDED_BY_RUNTIME = TYPE_VARIABLE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_POLYFILL = TYPE_VARIABLE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_STATIC_POLYFILL = TYPE_VARIABLE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_FINAL = TYPE_VARIABLE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_DYNAMIZABLE = TYPE_VARIABLE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_ARRAY_LIKE = TYPE_VARIABLE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_ELEMENT_TYPE = TYPE_VARIABLE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_TYPE_ACCESS_MODIFIER = TYPE_VARIABLE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_GENERIC = TYPE_VARIABLE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_TYPE_VARS = TYPE_VARIABLE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_VARIANCE_OF_TYPE_VAR__INT = TYPE_VARIABLE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_RAW_TYPE_AS_STRING = TYPE_VARIABLE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Variance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_VARIANCE = TYPE_VARIABLE___GET_VARIANCE;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___IS_OPTIONAL = TYPE_VARIABLE___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_TYPE_AS_STRING = TYPE_VARIABLE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type Variable As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE___GET_TYPE_VARIABLE_AS_STRING__TYPEREF = TYPE_VARIABLE___GET_TYPE_VARIABLE_AS_STRING__TYPEREF;

	/**
	 * The number of operations of the '<em>Inference Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERENCE_VARIABLE_OPERATION_COUNT = TYPE_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.GenericTypeImpl <em>Generic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.GenericTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getGenericType()
	 * @generated
	 */
	int GENERIC_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__DIRECTLY_EXPORTED = TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__EXPORTING_EXPORT_DEFINITIONS = TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__TYPE_VARS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Generic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___GET_CONTAINING_MODULE = TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_EXPORTED = TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_INDIRECTLY_EXPORTED = TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___GET_DIRECTLY_EXPORTED_NAME = TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_HOLLOW = TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_ALIAS = TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_PROVIDED_BY_RUNTIME = TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_POLYFILL = TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_STATIC_POLYFILL = TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_FINAL = TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_DYNAMIZABLE = TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_ARRAY_LIKE = TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___GET_ELEMENT_TYPE = TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___GET_TYPE_ACCESS_MODIFIER = TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___IS_GENERIC = TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___GET_TYPE_VARS = TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___GET_RAW_TYPE_AS_STRING = TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE___GET_TYPE_AS_STRING = TYPE___GET_TYPE_AS_STRING;

	/**
	 * The number of operations of the '<em>Generic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TFunctionImpl <em>TFunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TFunctionImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTFunction()
	 * @generated
	 */
	int TFUNCTION = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__NAME = GENERIC_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__DIRECTLY_EXPORTED = GENERIC_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__DIRECTLY_EXPORTED_AS_DEFAULT = GENERIC_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__EXPORTING_EXPORT_DEFINITIONS = GENERIC_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__ANNOTATIONS = GENERIC_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__TYPE_VARS = GENERIC_TYPE__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__DECLARED_TYPE_ACCESS_MODIFIER = GENERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__DECLARED_PROVIDED_BY_RUNTIME = GENERIC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__AST_ELEMENT = GENERIC_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__EXTERNAL = GENERIC_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fpars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__FPARS = GENERIC_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Return Value Marked Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__RETURN_VALUE_MARKED_OPTIONAL = GENERIC_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Return Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__RETURN_TYPE_REF = GENERIC_TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__DECLARED_THIS_TYPE = GENERIC_TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Declared Async</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__DECLARED_ASYNC = GENERIC_TYPE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Declared Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__DECLARED_GENERATOR = GENERIC_TYPE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION__CONSTRUCTOR = GENERIC_TYPE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>TFunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION_FEATURE_COUNT = GENERIC_TYPE_FEATURE_COUNT + 11;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_CONTAINING_MODULE = GENERIC_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_EXPORTED = GENERIC_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_INDIRECTLY_EXPORTED = GENERIC_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_DIRECTLY_EXPORTED_NAME = GENERIC_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_HOLLOW = GENERIC_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_ALIAS = GENERIC_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_POLYFILL = GENERIC_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_STATIC_POLYFILL = GENERIC_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_DYNAMIZABLE = GENERIC_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_ARRAY_LIKE = GENERIC_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_ELEMENT_TYPE = GENERIC_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_GENERIC = GENERIC_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_TYPE_VARS = GENERIC_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_VARIANCE_OF_TYPE_VAR__INT = GENERIC_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_RAW_TYPE_AS_STRING = GENERIC_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_TYPE_AS_STRING = GENERIC_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_PROVIDED_BY_RUNTIME = GENERIC_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_TYPE_ACCESS_MODIFIER = GENERIC_TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_DEFAULT_TYPE_ACCESS_MODIFIER = GENERIC_TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_DIRECTLY_EXPORTED = GENERIC_TYPE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_AST_ELEMENT_NO_RESOLVE = GENERIC_TYPE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Return Value Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_RETURN_VALUE_OPTIONAL = GENERIC_TYPE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Call Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_CALL_SIGNATURE = GENERIC_TYPE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Construct Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_CONSTRUCT_SIGNATURE = GENERIC_TYPE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Fpar For Arg Idx</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_FPAR_FOR_ARG_IDX__INT = GENERIC_TYPE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Function As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___GET_FUNCTION_AS_STRING = GENERIC_TYPE_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION___IS_FINAL = GENERIC_TYPE_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>TFunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFUNCTION_OPERATION_COUNT = GENERIC_TYPE_OPERATION_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.AccessibleTypeElementImpl <em>Accessible Type Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.AccessibleTypeElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getAccessibleTypeElement()
	 * @generated
	 */
	int ACCESSIBLE_TYPE_ELEMENT = 22;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIBLE_TYPE_ELEMENT__DECLARED_TYPE_ACCESS_MODIFIER = 0;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIBLE_TYPE_ELEMENT__DECLARED_PROVIDED_BY_RUNTIME = 1;

	/**
	 * The number of structural features of the '<em>Accessible Type Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIBLE_TYPE_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIBLE_TYPE_ELEMENT___IS_PROVIDED_BY_RUNTIME = 0;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIBLE_TYPE_ELEMENT___GET_TYPE_ACCESS_MODIFIER = 1;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIBLE_TYPE_ELEMENT___GET_DEFAULT_TYPE_ACCESS_MODIFIER = 2;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIBLE_TYPE_ELEMENT___IS_DIRECTLY_EXPORTED = 3;

	/**
	 * The number of operations of the '<em>Accessible Type Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIBLE_TYPE_ELEMENT_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.ContainerTypeImpl <em>Container Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.ContainerTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getContainerType()
	 * @generated
	 */
	int CONTAINER_TYPE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__NAME = GENERIC_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__DIRECTLY_EXPORTED = GENERIC_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = GENERIC_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__EXPORTING_EXPORT_DEFINITIONS = GENERIC_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__ANNOTATIONS = GENERIC_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__TYPE_VARS = GENERIC_TYPE__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Owned Members By Name And Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__OWNED_MEMBERS_BY_NAME_AND_ACCESS = GENERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__OWNED_MEMBERS = GENERIC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Call Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__CALL_SIGNATURE = GENERIC_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Construct Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE__CONSTRUCT_SIGNATURE = GENERIC_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Container Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE_FEATURE_COUNT = GENERIC_TYPE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_CONTAINING_MODULE = GENERIC_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_EXPORTED = GENERIC_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_INDIRECTLY_EXPORTED = GENERIC_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_DIRECTLY_EXPORTED_NAME = GENERIC_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_HOLLOW = GENERIC_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_ALIAS = GENERIC_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_PROVIDED_BY_RUNTIME = GENERIC_TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_POLYFILL = GENERIC_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_STATIC_POLYFILL = GENERIC_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_FINAL = GENERIC_TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_DYNAMIZABLE = GENERIC_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_ARRAY_LIKE = GENERIC_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_ELEMENT_TYPE = GENERIC_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_TYPE_ACCESS_MODIFIER = GENERIC_TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___IS_GENERIC = GENERIC_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_TYPE_VARS = GENERIC_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = GENERIC_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_RAW_TYPE_AS_STRING = GENERIC_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_TYPE_AS_STRING = GENERIC_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Owned Ctor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_OWNED_CTOR = GENERIC_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___FIND_OWNED_MEMBER__STRING = GENERIC_TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN = GENERIC_TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Or Create Owned Members By Name And Access</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS = GENERIC_TYPE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Container Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_TYPE_OPERATION_COUNT = GENERIC_TYPE_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TNamespaceImpl <em>TNamespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TNamespaceImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTNamespace()
	 * @generated
	 */
	int TNAMESPACE = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__DIRECTLY_EXPORTED = TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__DIRECTLY_EXPORTED_AS_DEFAULT = TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__EXPORTING_EXPORT_DEFINITIONS = TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Export Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__EXPORT_DEFINITIONS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__TYPES = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__FUNCTIONS = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exported Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__EXPORTED_VARIABLES = TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Local Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__LOCAL_VARIABLES = TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Exposed Local Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__EXPOSED_LOCAL_VARIABLES = TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Namespaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__NAMESPACES = TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__DECLARED_TYPE_ACCESS_MODIFIER = TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__DECLARED_PROVIDED_BY_RUNTIME = TYPE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__AST_ELEMENT = TYPE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE__EXTERNAL = TYPE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>TNamespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_EXPORTED = TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_INDIRECTLY_EXPORTED = TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_DIRECTLY_EXPORTED_NAME = TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_HOLLOW = TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_ALIAS = TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_POLYFILL = TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_STATIC_POLYFILL = TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_FINAL = TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_DYNAMIZABLE = TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_ARRAY_LIKE = TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_ELEMENT_TYPE = TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_GENERIC = TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_TYPE_VARS = TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_VARIANCE_OF_TYPE_VAR__INT = TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_RAW_TYPE_AS_STRING = TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_TYPE_AS_STRING = TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Types And Functions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_TYPES_AND_FUNCTIONS = TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Exportable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_EXPORTABLE_ELEMENTS = TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get All Namespaces</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_ALL_NAMESPACES = TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_CONTAINING_MODULE = TYPE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Clear Transient Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___CLEAR_TRANSIENT_ELEMENTS = TYPE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_PROVIDED_BY_RUNTIME = TYPE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_TYPE_ACCESS_MODIFIER = TYPE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_DEFAULT_TYPE_ACCESS_MODIFIER = TYPE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___IS_DIRECTLY_EXPORTED = TYPE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE___GET_AST_ELEMENT_NO_RESOLVE = TYPE_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>TNamespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TNamespaceElementImpl <em>TNamespace Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TNamespaceElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTNamespaceElement()
	 * @generated
	 */
	int TNAMESPACE_ELEMENT = 26;

	/**
	 * The number of structural features of the '<em>TNamespace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE_ELEMENT___IS_HOLLOW = 0;

	/**
	 * The number of operations of the '<em>TNamespace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNAMESPACE_ELEMENT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.ModuleNamespaceVirtualTypeImpl <em>Module Namespace Virtual Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.ModuleNamespaceVirtualTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getModuleNamespaceVirtualType()
	 * @generated
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE__DIRECTLY_EXPORTED = TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE__EXPORTING_EXPORT_DEFINITIONS = TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE__AST_ELEMENT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE__MODULE = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE__DECLARED_DYNAMIC = TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Module Namespace Virtual Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_CONTAINING_MODULE = TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_EXPORTED = TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_INDIRECTLY_EXPORTED = TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_DIRECTLY_EXPORTED_NAME = TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_HOLLOW = TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_ALIAS = TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_POLYFILL = TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_STATIC_POLYFILL = TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_FINAL = TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_DYNAMIZABLE = TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_ARRAY_LIKE = TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_ELEMENT_TYPE = TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_TYPE_ACCESS_MODIFIER = TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_GENERIC = TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_TYPE_VARS = TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_RAW_TYPE_AS_STRING = TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_TYPE_AS_STRING = TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___GET_AST_ELEMENT_NO_RESOLVE = TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE___IS_PROVIDED_BY_RUNTIME = TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Module Namespace Virtual Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_NAMESPACE_VIRTUAL_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.PrimitiveTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = GENERIC_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__DIRECTLY_EXPORTED = GENERIC_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = GENERIC_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__EXPORTING_EXPORT_DEFINITIONS = GENERIC_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__ANNOTATIONS = GENERIC_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TYPE_VARS = GENERIC_TYPE__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Declared Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__DECLARED_ELEMENT_TYPE = GENERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assignment Compatible</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__ASSIGNMENT_COMPATIBLE = GENERIC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Autoboxed Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__AUTOBOXED_TYPE = GENERIC_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = GENERIC_TYPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_CONTAINING_MODULE = GENERIC_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_EXPORTED = GENERIC_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_INDIRECTLY_EXPORTED = GENERIC_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_DIRECTLY_EXPORTED_NAME = GENERIC_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_HOLLOW = GENERIC_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_ALIAS = GENERIC_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_PROVIDED_BY_RUNTIME = GENERIC_TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_POLYFILL = GENERIC_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_STATIC_POLYFILL = GENERIC_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_FINAL = GENERIC_TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_DYNAMIZABLE = GENERIC_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_ARRAY_LIKE = GENERIC_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_TYPE_ACCESS_MODIFIER = GENERIC_TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_GENERIC = GENERIC_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_TYPE_VARS = GENERIC_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = GENERIC_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_RAW_TYPE_AS_STRING = GENERIC_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_TYPE_AS_STRING = GENERIC_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_ELEMENT_TYPE = GENERIC_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = GENERIC_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.BuiltInTypeImpl <em>Built In Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.BuiltInTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getBuiltInType()
	 * @generated
	 */
	int BUILT_IN_TYPE = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE__DIRECTLY_EXPORTED = TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE__EXPORTING_EXPORT_DEFINITIONS = TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Built In Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___GET_CONTAINING_MODULE = TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_EXPORTED = TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_INDIRECTLY_EXPORTED = TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___GET_DIRECTLY_EXPORTED_NAME = TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_HOLLOW = TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_ALIAS = TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_PROVIDED_BY_RUNTIME = TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_POLYFILL = TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_STATIC_POLYFILL = TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_FINAL = TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_DYNAMIZABLE = TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_ARRAY_LIKE = TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___GET_ELEMENT_TYPE = TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___GET_TYPE_ACCESS_MODIFIER = TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___IS_GENERIC = TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___GET_TYPE_VARS = TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___GET_RAW_TYPE_AS_STRING = TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE___GET_TYPE_AS_STRING = TYPE___GET_TYPE_AS_STRING;

	/**
	 * The number of operations of the '<em>Built In Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.AnyTypeImpl <em>Any Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.AnyTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getAnyType()
	 * @generated
	 */
	int ANY_TYPE = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__NAME = BUILT_IN_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__DIRECTLY_EXPORTED = BUILT_IN_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = BUILT_IN_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__EXPORTING_EXPORT_DEFINITIONS = BUILT_IN_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__ANNOTATIONS = BUILT_IN_TYPE__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_FEATURE_COUNT = BUILT_IN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_CONTAINING_MODULE = BUILT_IN_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_EXPORTED = BUILT_IN_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_INDIRECTLY_EXPORTED = BUILT_IN_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_DIRECTLY_EXPORTED_NAME = BUILT_IN_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_HOLLOW = BUILT_IN_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_ALIAS = BUILT_IN_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_PROVIDED_BY_RUNTIME = BUILT_IN_TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_POLYFILL = BUILT_IN_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_STATIC_POLYFILL = BUILT_IN_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_DYNAMIZABLE = BUILT_IN_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_ARRAY_LIKE = BUILT_IN_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_ELEMENT_TYPE = BUILT_IN_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_TYPE_ACCESS_MODIFIER = BUILT_IN_TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_GENERIC = BUILT_IN_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_TYPE_VARS = BUILT_IN_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = BUILT_IN_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_RAW_TYPE_AS_STRING = BUILT_IN_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_TYPE_AS_STRING = BUILT_IN_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_FINAL = BUILT_IN_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_OPERATION_COUNT = BUILT_IN_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.UndefinedTypeImpl <em>Undefined Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.UndefinedTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getUndefinedType()
	 * @generated
	 */
	int UNDEFINED_TYPE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE__NAME = BUILT_IN_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE__DIRECTLY_EXPORTED = BUILT_IN_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = BUILT_IN_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE__EXPORTING_EXPORT_DEFINITIONS = BUILT_IN_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE__ANNOTATIONS = BUILT_IN_TYPE__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Undefined Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE_FEATURE_COUNT = BUILT_IN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___GET_CONTAINING_MODULE = BUILT_IN_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_EXPORTED = BUILT_IN_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_INDIRECTLY_EXPORTED = BUILT_IN_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___GET_DIRECTLY_EXPORTED_NAME = BUILT_IN_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_HOLLOW = BUILT_IN_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_ALIAS = BUILT_IN_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_PROVIDED_BY_RUNTIME = BUILT_IN_TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_POLYFILL = BUILT_IN_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_STATIC_POLYFILL = BUILT_IN_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_FINAL = BUILT_IN_TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_DYNAMIZABLE = BUILT_IN_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_ARRAY_LIKE = BUILT_IN_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___GET_ELEMENT_TYPE = BUILT_IN_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___GET_TYPE_ACCESS_MODIFIER = BUILT_IN_TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___IS_GENERIC = BUILT_IN_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___GET_TYPE_VARS = BUILT_IN_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = BUILT_IN_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___GET_RAW_TYPE_AS_STRING = BUILT_IN_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE___GET_TYPE_AS_STRING = BUILT_IN_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The number of operations of the '<em>Undefined Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_TYPE_OPERATION_COUNT = BUILT_IN_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.NullTypeImpl <em>Null Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.NullTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getNullType()
	 * @generated
	 */
	int NULL_TYPE = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE__NAME = BUILT_IN_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE__DIRECTLY_EXPORTED = BUILT_IN_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = BUILT_IN_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE__EXPORTING_EXPORT_DEFINITIONS = BUILT_IN_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE__ANNOTATIONS = BUILT_IN_TYPE__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Null Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE_FEATURE_COUNT = BUILT_IN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___GET_CONTAINING_MODULE = BUILT_IN_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_EXPORTED = BUILT_IN_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_INDIRECTLY_EXPORTED = BUILT_IN_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___GET_DIRECTLY_EXPORTED_NAME = BUILT_IN_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_HOLLOW = BUILT_IN_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_ALIAS = BUILT_IN_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_PROVIDED_BY_RUNTIME = BUILT_IN_TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_POLYFILL = BUILT_IN_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_STATIC_POLYFILL = BUILT_IN_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_FINAL = BUILT_IN_TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_DYNAMIZABLE = BUILT_IN_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_ARRAY_LIKE = BUILT_IN_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___GET_ELEMENT_TYPE = BUILT_IN_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___GET_TYPE_ACCESS_MODIFIER = BUILT_IN_TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___IS_GENERIC = BUILT_IN_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___GET_TYPE_VARS = BUILT_IN_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = BUILT_IN_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___GET_RAW_TYPE_AS_STRING = BUILT_IN_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE___GET_TYPE_AS_STRING = BUILT_IN_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The number of operations of the '<em>Null Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_TYPE_OPERATION_COUNT = BUILT_IN_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.VoidTypeImpl <em>Void Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.VoidTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAME = BUILT_IN_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__DIRECTLY_EXPORTED = BUILT_IN_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = BUILT_IN_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__EXPORTING_EXPORT_DEFINITIONS = BUILT_IN_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__ANNOTATIONS = BUILT_IN_TYPE__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = BUILT_IN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_CONTAINING_MODULE = BUILT_IN_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_EXPORTED = BUILT_IN_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_INDIRECTLY_EXPORTED = BUILT_IN_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_DIRECTLY_EXPORTED_NAME = BUILT_IN_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_HOLLOW = BUILT_IN_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_ALIAS = BUILT_IN_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_PROVIDED_BY_RUNTIME = BUILT_IN_TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_POLYFILL = BUILT_IN_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_STATIC_POLYFILL = BUILT_IN_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_FINAL = BUILT_IN_TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_DYNAMIZABLE = BUILT_IN_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_ARRAY_LIKE = BUILT_IN_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_ELEMENT_TYPE = BUILT_IN_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_TYPE_ACCESS_MODIFIER = BUILT_IN_TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_GENERIC = BUILT_IN_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_TYPE_VARS = BUILT_IN_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = BUILT_IN_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_RAW_TYPE_AS_STRING = BUILT_IN_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_TYPE_AS_STRING = BUILT_IN_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The number of operations of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_OPERATION_COUNT = BUILT_IN_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TStructuralTypeImpl <em>TStructural Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TStructuralTypeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructuralType()
	 * @generated
	 */
	int TSTRUCTURAL_TYPE = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__NAME = CONTAINER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__DIRECTLY_EXPORTED = CONTAINER_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT = CONTAINER_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__EXPORTING_EXPORT_DEFINITIONS = CONTAINER_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__ANNOTATIONS = CONTAINER_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__TYPE_VARS = CONTAINER_TYPE__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Owned Members By Name And Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__OWNED_MEMBERS_BY_NAME_AND_ACCESS = CONTAINER_TYPE__OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__OWNED_MEMBERS = CONTAINER_TYPE__OWNED_MEMBERS;

	/**
	 * The feature id for the '<em><b>Call Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__CALL_SIGNATURE = CONTAINER_TYPE__CALL_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Construct Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__CONSTRUCT_SIGNATURE = CONTAINER_TYPE__CONSTRUCT_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE__AST_ELEMENT = CONTAINER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TStructural Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE_FEATURE_COUNT = CONTAINER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_CONTAINING_MODULE = CONTAINER_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_EXPORTED = CONTAINER_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_INDIRECTLY_EXPORTED = CONTAINER_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_DIRECTLY_EXPORTED_NAME = CONTAINER_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_HOLLOW = CONTAINER_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_ALIAS = CONTAINER_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_PROVIDED_BY_RUNTIME = CONTAINER_TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_POLYFILL = CONTAINER_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_STATIC_POLYFILL = CONTAINER_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_DYNAMIZABLE = CONTAINER_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_ARRAY_LIKE = CONTAINER_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_ELEMENT_TYPE = CONTAINER_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_TYPE_ACCESS_MODIFIER = CONTAINER_TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_GENERIC = CONTAINER_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_TYPE_VARS = CONTAINER_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = CONTAINER_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_RAW_TYPE_AS_STRING = CONTAINER_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_TYPE_AS_STRING = CONTAINER_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Owned Ctor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_OWNED_CTOR = CONTAINER_TYPE___GET_OWNED_CTOR;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___FIND_OWNED_MEMBER__STRING = CONTAINER_TYPE___FIND_OWNED_MEMBER__STRING;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN = CONTAINER_TYPE___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN;

	/**
	 * The operation id for the '<em>Get Or Create Owned Members By Name And Access</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS = CONTAINER_TYPE___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___GET_AST_ELEMENT_NO_RESOLVE = CONTAINER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE___IS_FINAL = CONTAINER_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>TStructural Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCTURAL_TYPE_OPERATION_COUNT = CONTAINER_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TClassifierImpl <em>TClassifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TClassifierImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTClassifier()
	 * @generated
	 */
	int TCLASSIFIER = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__NAME = CONTAINER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__DIRECTLY_EXPORTED = CONTAINER_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__DIRECTLY_EXPORTED_AS_DEFAULT = CONTAINER_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__EXPORTING_EXPORT_DEFINITIONS = CONTAINER_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__ANNOTATIONS = CONTAINER_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__TYPE_VARS = CONTAINER_TYPE__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Owned Members By Name And Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__OWNED_MEMBERS_BY_NAME_AND_ACCESS = CONTAINER_TYPE__OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__OWNED_MEMBERS = CONTAINER_TYPE__OWNED_MEMBERS;

	/**
	 * The feature id for the '<em><b>Call Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__CALL_SIGNATURE = CONTAINER_TYPE__CALL_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Construct Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__CONSTRUCT_SIGNATURE = CONTAINER_TYPE__CONSTRUCT_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__AST_ELEMENT = CONTAINER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Covariant Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR = CONTAINER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TClassifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER_FEATURE_COUNT = CONTAINER_TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_CONTAINING_MODULE = CONTAINER_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_EXPORTED = CONTAINER_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_INDIRECTLY_EXPORTED = CONTAINER_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_DIRECTLY_EXPORTED_NAME = CONTAINER_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_HOLLOW = CONTAINER_TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_ALIAS = CONTAINER_TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_PROVIDED_BY_RUNTIME = CONTAINER_TYPE___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_POLYFILL = CONTAINER_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_STATIC_POLYFILL = CONTAINER_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_DYNAMIZABLE = CONTAINER_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_ARRAY_LIKE = CONTAINER_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_ELEMENT_TYPE = CONTAINER_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_TYPE_ACCESS_MODIFIER = CONTAINER_TYPE___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_GENERIC = CONTAINER_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_TYPE_VARS = CONTAINER_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_VARIANCE_OF_TYPE_VAR__INT = CONTAINER_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_RAW_TYPE_AS_STRING = CONTAINER_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_TYPE_AS_STRING = CONTAINER_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Owned Ctor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_OWNED_CTOR = CONTAINER_TYPE___GET_OWNED_CTOR;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___FIND_OWNED_MEMBER__STRING = CONTAINER_TYPE___FIND_OWNED_MEMBER__STRING;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN = CONTAINER_TYPE___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN;

	/**
	 * The operation id for the '<em>Get Or Create Owned Members By Name And Access</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS = CONTAINER_TYPE___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_AST_ELEMENT_NO_RESOLVE = CONTAINER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_ABSTRACT = CONTAINER_TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Super Classifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_SUPER_CLASSIFIERS = CONTAINER_TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Super Classifier Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_SUPER_CLASSIFIER_REFS = CONTAINER_TYPE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Implemented Or Extended Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS = CONTAINER_TYPE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER___IS_FINAL = CONTAINER_TYPE_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>TClassifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASSIFIER_OPERATION_COUNT = CONTAINER_TYPE_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.ArrayLikeImpl <em>Array Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.ArrayLikeImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getArrayLike()
	 * @generated
	 */
	int ARRAY_LIKE = 36;

	/**
	 * The feature id for the '<em><b>Declared Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LIKE__DECLARED_ELEMENT_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Array Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LIKE_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LIKE___GET_ELEMENT_TYPE = 0;

	/**
	 * The number of operations of the '<em>Array Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LIKE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TN4ClassifierImpl <em>TN4 Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TN4ClassifierImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTN4Classifier()
	 * @generated
	 */
	int TN4_CLASSIFIER = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__NAME = TCLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__DIRECTLY_EXPORTED = TCLASSIFIER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__DIRECTLY_EXPORTED_AS_DEFAULT = TCLASSIFIER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__EXPORTING_EXPORT_DEFINITIONS = TCLASSIFIER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__ANNOTATIONS = TCLASSIFIER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__TYPE_VARS = TCLASSIFIER__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Owned Members By Name And Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__OWNED_MEMBERS_BY_NAME_AND_ACCESS = TCLASSIFIER__OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__OWNED_MEMBERS = TCLASSIFIER__OWNED_MEMBERS;

	/**
	 * The feature id for the '<em><b>Call Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__CALL_SIGNATURE = TCLASSIFIER__CALL_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Construct Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__CONSTRUCT_SIGNATURE = TCLASSIFIER__CONSTRUCT_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__AST_ELEMENT = TCLASSIFIER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Declared Covariant Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR = TCLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__DECLARED_TYPE_ACCESS_MODIFIER = TCLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__DECLARED_PROVIDED_BY_RUNTIME = TCLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__DECLARED_ELEMENT_TYPE = TCLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__EXTERNAL = TCLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Declared Non Static Polyfill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__DECLARED_NON_STATIC_POLYFILL = TCLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Dynamizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER__DYNAMIZABLE = TCLASSIFIER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>TN4 Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER_FEATURE_COUNT = TCLASSIFIER_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_CONTAINING_MODULE = TCLASSIFIER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_EXPORTED = TCLASSIFIER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_INDIRECTLY_EXPORTED = TCLASSIFIER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_DIRECTLY_EXPORTED_NAME = TCLASSIFIER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_HOLLOW = TCLASSIFIER___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_ALIAS = TCLASSIFIER___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_STATIC_POLYFILL = TCLASSIFIER___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_DYNAMIZABLE = TCLASSIFIER___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_ARRAY_LIKE = TCLASSIFIER___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_GENERIC = TCLASSIFIER___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_TYPE_VARS = TCLASSIFIER___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_VARIANCE_OF_TYPE_VAR__INT = TCLASSIFIER___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_RAW_TYPE_AS_STRING = TCLASSIFIER___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_TYPE_AS_STRING = TCLASSIFIER___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Owned Ctor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_OWNED_CTOR = TCLASSIFIER___GET_OWNED_CTOR;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___FIND_OWNED_MEMBER__STRING = TCLASSIFIER___FIND_OWNED_MEMBER__STRING;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN = TCLASSIFIER___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN;

	/**
	 * The operation id for the '<em>Get Or Create Owned Members By Name And Access</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS = TCLASSIFIER___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_AST_ELEMENT_NO_RESOLVE = TCLASSIFIER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_ABSTRACT = TCLASSIFIER___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Get Super Classifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_SUPER_CLASSIFIERS = TCLASSIFIER___GET_SUPER_CLASSIFIERS;

	/**
	 * The operation id for the '<em>Get Super Classifier Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_SUPER_CLASSIFIER_REFS = TCLASSIFIER___GET_SUPER_CLASSIFIER_REFS;

	/**
	 * The operation id for the '<em>Get Implemented Or Extended Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS = TCLASSIFIER___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_FINAL = TCLASSIFIER___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_PROVIDED_BY_RUNTIME = TCLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_TYPE_ACCESS_MODIFIER = TCLASSIFIER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_DEFAULT_TYPE_ACCESS_MODIFIER = TCLASSIFIER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_DIRECTLY_EXPORTED = TCLASSIFIER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_ELEMENT_TYPE = TCLASSIFIER_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___IS_POLYFILL = TCLASSIFIER_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER___GET_TYPING_STRATEGY = TCLASSIFIER_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>TN4 Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TN4_CLASSIFIER_OPERATION_COUNT = TCLASSIFIER_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TClassImpl <em>TClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TClassImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTClass()
	 * @generated
	 */
	int TCLASS = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__NAME = TN4_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DIRECTLY_EXPORTED = TN4_CLASSIFIER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DIRECTLY_EXPORTED_AS_DEFAULT = TN4_CLASSIFIER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__EXPORTING_EXPORT_DEFINITIONS = TN4_CLASSIFIER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__ANNOTATIONS = TN4_CLASSIFIER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__TYPE_VARS = TN4_CLASSIFIER__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Owned Members By Name And Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__OWNED_MEMBERS_BY_NAME_AND_ACCESS = TN4_CLASSIFIER__OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__OWNED_MEMBERS = TN4_CLASSIFIER__OWNED_MEMBERS;

	/**
	 * The feature id for the '<em><b>Call Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__CALL_SIGNATURE = TN4_CLASSIFIER__CALL_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Construct Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__CONSTRUCT_SIGNATURE = TN4_CLASSIFIER__CONSTRUCT_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__AST_ELEMENT = TN4_CLASSIFIER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Declared Covariant Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_COVARIANT_CONSTRUCTOR = TN4_CLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_TYPE_ACCESS_MODIFIER = TN4_CLASSIFIER__DECLARED_TYPE_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_PROVIDED_BY_RUNTIME = TN4_CLASSIFIER__DECLARED_PROVIDED_BY_RUNTIME;

	/**
	 * The feature id for the '<em><b>Declared Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_ELEMENT_TYPE = TN4_CLASSIFIER__DECLARED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__EXTERNAL = TN4_CLASSIFIER__EXTERNAL;

	/**
	 * The feature id for the '<em><b>Declared Non Static Polyfill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_NON_STATIC_POLYFILL = TN4_CLASSIFIER__DECLARED_NON_STATIC_POLYFILL;

	/**
	 * The feature id for the '<em><b>Dynamizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DYNAMIZABLE = TN4_CLASSIFIER__DYNAMIZABLE;

	/**
	 * The feature id for the '<em><b>Declared Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_ABSTRACT = TN4_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Ecma Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_ECMA_SCRIPT = TN4_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_FINAL = TN4_CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Declared Static Polyfill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__DECLARED_STATIC_POLYFILL = TN4_CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Observable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__OBSERVABLE = TN4_CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Super Class Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__SUPER_CLASS_REF = TN4_CLASSIFIER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Implemented Interface Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS__IMPLEMENTED_INTERFACE_REFS = TN4_CLASSIFIER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>TClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS_FEATURE_COUNT = TN4_CLASSIFIER_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_CONTAINING_MODULE = TN4_CLASSIFIER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_EXPORTED = TN4_CLASSIFIER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_INDIRECTLY_EXPORTED = TN4_CLASSIFIER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_DIRECTLY_EXPORTED_NAME = TN4_CLASSIFIER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_HOLLOW = TN4_CLASSIFIER___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_ALIAS = TN4_CLASSIFIER___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_DYNAMIZABLE = TN4_CLASSIFIER___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_ARRAY_LIKE = TN4_CLASSIFIER___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_GENERIC = TN4_CLASSIFIER___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_TYPE_VARS = TN4_CLASSIFIER___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_VARIANCE_OF_TYPE_VAR__INT = TN4_CLASSIFIER___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_RAW_TYPE_AS_STRING = TN4_CLASSIFIER___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_TYPE_AS_STRING = TN4_CLASSIFIER___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Owned Ctor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_OWNED_CTOR = TN4_CLASSIFIER___GET_OWNED_CTOR;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___FIND_OWNED_MEMBER__STRING = TN4_CLASSIFIER___FIND_OWNED_MEMBER__STRING;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN = TN4_CLASSIFIER___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN;

	/**
	 * The operation id for the '<em>Get Or Create Owned Members By Name And Access</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS = TN4_CLASSIFIER___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_AST_ELEMENT_NO_RESOLVE = TN4_CLASSIFIER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Get Super Classifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_SUPER_CLASSIFIERS = TN4_CLASSIFIER___GET_SUPER_CLASSIFIERS;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_PROVIDED_BY_RUNTIME = TN4_CLASSIFIER___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_TYPE_ACCESS_MODIFIER = TN4_CLASSIFIER___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_DEFAULT_TYPE_ACCESS_MODIFIER = TN4_CLASSIFIER___GET_DEFAULT_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_DIRECTLY_EXPORTED = TN4_CLASSIFIER___IS_DIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_ELEMENT_TYPE = TN4_CLASSIFIER___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_TYPING_STRATEGY = TN4_CLASSIFIER___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_ABSTRACT = TN4_CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Super Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_SUPER_CLASS = TN4_CLASSIFIER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Super Classifier Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_SUPER_CLASSIFIER_REFS = TN4_CLASSIFIER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Implemented Or Extended Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS = TN4_CLASSIFIER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_POLYFILL = TN4_CLASSIFIER_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_STATIC_POLYFILL = TN4_CLASSIFIER_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS___IS_FINAL = TN4_CLASSIFIER_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>TClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCLASS_OPERATION_COUNT = TN4_CLASSIFIER_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TInterfaceImpl <em>TInterface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TInterfaceImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTInterface()
	 * @generated
	 */
	int TINTERFACE = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__NAME = TN4_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__DIRECTLY_EXPORTED = TN4_CLASSIFIER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__DIRECTLY_EXPORTED_AS_DEFAULT = TN4_CLASSIFIER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__EXPORTING_EXPORT_DEFINITIONS = TN4_CLASSIFIER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__ANNOTATIONS = TN4_CLASSIFIER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__TYPE_VARS = TN4_CLASSIFIER__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Owned Members By Name And Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__OWNED_MEMBERS_BY_NAME_AND_ACCESS = TN4_CLASSIFIER__OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__OWNED_MEMBERS = TN4_CLASSIFIER__OWNED_MEMBERS;

	/**
	 * The feature id for the '<em><b>Call Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__CALL_SIGNATURE = TN4_CLASSIFIER__CALL_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Construct Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__CONSTRUCT_SIGNATURE = TN4_CLASSIFIER__CONSTRUCT_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__AST_ELEMENT = TN4_CLASSIFIER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Declared Covariant Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__DECLARED_COVARIANT_CONSTRUCTOR = TN4_CLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__DECLARED_TYPE_ACCESS_MODIFIER = TN4_CLASSIFIER__DECLARED_TYPE_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__DECLARED_PROVIDED_BY_RUNTIME = TN4_CLASSIFIER__DECLARED_PROVIDED_BY_RUNTIME;

	/**
	 * The feature id for the '<em><b>Declared Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__DECLARED_ELEMENT_TYPE = TN4_CLASSIFIER__DECLARED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__EXTERNAL = TN4_CLASSIFIER__EXTERNAL;

	/**
	 * The feature id for the '<em><b>Declared Non Static Polyfill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__DECLARED_NON_STATIC_POLYFILL = TN4_CLASSIFIER__DECLARED_NON_STATIC_POLYFILL;

	/**
	 * The feature id for the '<em><b>Dynamizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__DYNAMIZABLE = TN4_CLASSIFIER__DYNAMIZABLE;

	/**
	 * The feature id for the '<em><b>Super Interface Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__SUPER_INTERFACE_REFS = TN4_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typing Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE__TYPING_STRATEGY = TN4_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TInterface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE_FEATURE_COUNT = TN4_CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_CONTAINING_MODULE = TN4_CLASSIFIER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_EXPORTED = TN4_CLASSIFIER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_INDIRECTLY_EXPORTED = TN4_CLASSIFIER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_DIRECTLY_EXPORTED_NAME = TN4_CLASSIFIER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_ALIAS = TN4_CLASSIFIER___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_STATIC_POLYFILL = TN4_CLASSIFIER___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_DYNAMIZABLE = TN4_CLASSIFIER___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_ARRAY_LIKE = TN4_CLASSIFIER___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_GENERIC = TN4_CLASSIFIER___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_TYPE_VARS = TN4_CLASSIFIER___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_VARIANCE_OF_TYPE_VAR__INT = TN4_CLASSIFIER___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_RAW_TYPE_AS_STRING = TN4_CLASSIFIER___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_TYPE_AS_STRING = TN4_CLASSIFIER___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Owned Ctor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_OWNED_CTOR = TN4_CLASSIFIER___GET_OWNED_CTOR;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___FIND_OWNED_MEMBER__STRING = TN4_CLASSIFIER___FIND_OWNED_MEMBER__STRING;

	/**
	 * The operation id for the '<em>Find Owned Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN = TN4_CLASSIFIER___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN;

	/**
	 * The operation id for the '<em>Get Or Create Owned Members By Name And Access</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS = TN4_CLASSIFIER___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_AST_ELEMENT_NO_RESOLVE = TN4_CLASSIFIER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Get Super Classifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_SUPER_CLASSIFIERS = TN4_CLASSIFIER___GET_SUPER_CLASSIFIERS;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_FINAL = TN4_CLASSIFIER___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_PROVIDED_BY_RUNTIME = TN4_CLASSIFIER___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_TYPE_ACCESS_MODIFIER = TN4_CLASSIFIER___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_DEFAULT_TYPE_ACCESS_MODIFIER = TN4_CLASSIFIER___GET_DEFAULT_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_DIRECTLY_EXPORTED = TN4_CLASSIFIER___IS_DIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_ELEMENT_TYPE = TN4_CLASSIFIER___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_POLYFILL = TN4_CLASSIFIER___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Get Typing Strategy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_TYPING_STRATEGY = TN4_CLASSIFIER___GET_TYPING_STRATEGY;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_ABSTRACT = TN4_CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Super Classifier Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_SUPER_CLASSIFIER_REFS = TN4_CLASSIFIER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Implemented Or Extended Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS = TN4_CLASSIFIER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE___IS_HOLLOW = TN4_CLASSIFIER_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>TInterface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERFACE_OPERATION_COUNT = TN4_CLASSIFIER_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TMemberImpl <em>TMember</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TMemberImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTMember()
	 * @generated
	 */
	int TMEMBER = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__NAME = IDENTIFIABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__ANNOTATIONS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__AST_ELEMENT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__DIRECTLY_EXPORTED = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__DIRECTLY_EXPORTED_AS_DEFAULT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__EXPORTING_EXPORT_DEFINITIONS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__DECLARED_FINAL = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__DECLARED_STATIC = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__DECLARED_OVERRIDE = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__HAS_COMPUTED_NAME = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__CONSTITUENT_MEMBERS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER__COMPOSED = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>TMember</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___GET_CONTAINING_MODULE = IDENTIFIABLE_ELEMENT___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___GET_AST_ELEMENT_NO_RESOLVE = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_EXPORTED = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_INDIRECTLY_EXPORTED = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___GET_DIRECTLY_EXPORTED_NAME = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___GET_CONTAINING_TYPE = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___GET_MEMBER_ACCESS_MODIFIER = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___GET_MEMBER_TYPE = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_FIELD = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_GETTER = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_SETTER = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_ACCESSOR = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_METHOD = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_CONSTRUCTOR = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_OPTIONAL = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_ABSTRACT = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_READABLE = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_WRITEABLE = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___GET_MEMBER_AS_STRING = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_FINAL = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_STATIC = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_CONST = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER___IS_POLYFILLED = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 21;

	/**
	 * The number of operations of the '<em>TMember</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_OPERATION_COUNT = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 22;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TMemberWithAccessModifierImpl <em>TMember With Access Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TMemberWithAccessModifierImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTMemberWithAccessModifier()
	 * @generated
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__NAME = TMEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__ANNOTATIONS = TMEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__AST_ELEMENT = TMEMBER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__DIRECTLY_EXPORTED = TMEMBER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__DIRECTLY_EXPORTED_AS_DEFAULT = TMEMBER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__EXPORTING_EXPORT_DEFINITIONS = TMEMBER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_FINAL = TMEMBER__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_STATIC = TMEMBER__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_OVERRIDE = TMEMBER__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__HAS_COMPUTED_NAME = TMEMBER__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__CONSTITUENT_MEMBERS = TMEMBER__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__COMPOSED = TMEMBER__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__HAS_NO_BODY = TMEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_MEMBER_ACCESS_MODIFIER = TMEMBER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TMember With Access Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT = TMEMBER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___GET_CONTAINING_MODULE = TMEMBER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___GET_AST_ELEMENT_NO_RESOLVE = TMEMBER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_EXPORTED = TMEMBER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_INDIRECTLY_EXPORTED = TMEMBER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___GET_DIRECTLY_EXPORTED_NAME = TMEMBER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___GET_CONTAINING_TYPE = TMEMBER___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___GET_MEMBER_TYPE = TMEMBER___GET_MEMBER_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_FIELD = TMEMBER___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_GETTER = TMEMBER___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_SETTER = TMEMBER___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_ACCESSOR = TMEMBER___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_METHOD = TMEMBER___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_CONSTRUCTOR = TMEMBER___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_OPTIONAL = TMEMBER___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_ABSTRACT = TMEMBER___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_READABLE = TMEMBER___IS_READABLE;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_WRITEABLE = TMEMBER___IS_WRITEABLE;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___GET_MEMBER_AS_STRING = TMEMBER___GET_MEMBER_AS_STRING;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_FINAL = TMEMBER___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_STATIC = TMEMBER___IS_STATIC;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_CONST = TMEMBER___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___IS_POLYFILLED = TMEMBER___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___GET_MEMBER_ACCESS_MODIFIER = TMEMBER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TMEMBER_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>TMember With Access Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT = TMEMBER_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TStructMemberImpl <em>TStruct Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TStructMemberImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructMember()
	 * @generated
	 */
	int TSTRUCT_MEMBER = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__NAME = TMEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__ANNOTATIONS = TMEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__AST_ELEMENT = TMEMBER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__DIRECTLY_EXPORTED = TMEMBER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__DIRECTLY_EXPORTED_AS_DEFAULT = TMEMBER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__EXPORTING_EXPORT_DEFINITIONS = TMEMBER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__DECLARED_FINAL = TMEMBER__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__DECLARED_STATIC = TMEMBER__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__DECLARED_OVERRIDE = TMEMBER__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__HAS_COMPUTED_NAME = TMEMBER__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__CONSTITUENT_MEMBERS = TMEMBER__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__COMPOSED = TMEMBER__COMPOSED;

	/**
	 * The feature id for the '<em><b>Defined Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER__DEFINED_MEMBER = TMEMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TStruct Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER_FEATURE_COUNT = TMEMBER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___GET_CONTAINING_MODULE = TMEMBER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___GET_AST_ELEMENT_NO_RESOLVE = TMEMBER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_EXPORTED = TMEMBER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_INDIRECTLY_EXPORTED = TMEMBER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___GET_DIRECTLY_EXPORTED_NAME = TMEMBER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___GET_CONTAINING_TYPE = TMEMBER___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___GET_MEMBER_TYPE = TMEMBER___GET_MEMBER_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_FIELD = TMEMBER___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_GETTER = TMEMBER___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_SETTER = TMEMBER___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_ACCESSOR = TMEMBER___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_METHOD = TMEMBER___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_CONSTRUCTOR = TMEMBER___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_OPTIONAL = TMEMBER___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_ABSTRACT = TMEMBER___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_READABLE = TMEMBER___IS_READABLE;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_WRITEABLE = TMEMBER___IS_WRITEABLE;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___GET_MEMBER_AS_STRING = TMEMBER___GET_MEMBER_AS_STRING;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_FINAL = TMEMBER___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_CONST = TMEMBER___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_POLYFILLED = TMEMBER___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TMEMBER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_STATIC = TMEMBER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___GET_MEMBER_ACCESS_MODIFIER = TMEMBER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is AST Call Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_AST_CALL_SIGNATURE = TMEMBER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is AST Construct Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER___IS_AST_CONSTRUCT_SIGNATURE = TMEMBER_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>TStruct Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_MEMBER_OPERATION_COUNT = TMEMBER_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TMethodImpl <em>TMethod</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TMethodImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTMethod()
	 * @generated
	 */
	int TMETHOD = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__NAME = TFUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DIRECTLY_EXPORTED = TFUNCTION__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DIRECTLY_EXPORTED_AS_DEFAULT = TFUNCTION__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__EXPORTING_EXPORT_DEFINITIONS = TFUNCTION__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__ANNOTATIONS = TFUNCTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__TYPE_VARS = TFUNCTION__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_TYPE_ACCESS_MODIFIER = TFUNCTION__DECLARED_TYPE_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_PROVIDED_BY_RUNTIME = TFUNCTION__DECLARED_PROVIDED_BY_RUNTIME;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__AST_ELEMENT = TFUNCTION__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__EXTERNAL = TFUNCTION__EXTERNAL;

	/**
	 * The feature id for the '<em><b>Fpars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__FPARS = TFUNCTION__FPARS;

	/**
	 * The feature id for the '<em><b>Return Value Marked Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__RETURN_VALUE_MARKED_OPTIONAL = TFUNCTION__RETURN_VALUE_MARKED_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Return Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__RETURN_TYPE_REF = TFUNCTION__RETURN_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_THIS_TYPE = TFUNCTION__DECLARED_THIS_TYPE;

	/**
	 * The feature id for the '<em><b>Declared Async</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_ASYNC = TFUNCTION__DECLARED_ASYNC;

	/**
	 * The feature id for the '<em><b>Declared Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_GENERATOR = TFUNCTION__DECLARED_GENERATOR;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__CONSTRUCTOR = TFUNCTION__CONSTRUCTOR;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_FINAL = TFUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_STATIC = TFUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_OVERRIDE = TFUNCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__HAS_COMPUTED_NAME = TFUNCTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__CONSTITUENT_MEMBERS = TFUNCTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__COMPOSED = TFUNCTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__HAS_NO_BODY = TFUNCTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_MEMBER_ACCESS_MODIFIER = TFUNCTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Declared Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__DECLARED_ABSTRACT = TFUNCTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Lacks This Or Super Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD__LACKS_THIS_OR_SUPER_USAGE = TFUNCTION_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>TMethod</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD_FEATURE_COUNT = TFUNCTION_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_CONTAINING_MODULE = TFUNCTION___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_EXPORTED = TFUNCTION___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_INDIRECTLY_EXPORTED = TFUNCTION___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_DIRECTLY_EXPORTED_NAME = TFUNCTION___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_HOLLOW = TFUNCTION___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_ALIAS = TFUNCTION___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_POLYFILL = TFUNCTION___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_STATIC_POLYFILL = TFUNCTION___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_DYNAMIZABLE = TFUNCTION___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_ARRAY_LIKE = TFUNCTION___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_ELEMENT_TYPE = TFUNCTION___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_GENERIC = TFUNCTION___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_TYPE_VARS = TFUNCTION___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_VARIANCE_OF_TYPE_VAR__INT = TFUNCTION___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_RAW_TYPE_AS_STRING = TFUNCTION___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_TYPE_AS_STRING = TFUNCTION___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_PROVIDED_BY_RUNTIME = TFUNCTION___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_TYPE_ACCESS_MODIFIER = TFUNCTION___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_DEFAULT_TYPE_ACCESS_MODIFIER = TFUNCTION___GET_DEFAULT_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_DIRECTLY_EXPORTED = TFUNCTION___IS_DIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_AST_ELEMENT_NO_RESOLVE = TFUNCTION___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Return Value Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_RETURN_VALUE_OPTIONAL = TFUNCTION___IS_RETURN_VALUE_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Call Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_CALL_SIGNATURE = TFUNCTION___IS_CALL_SIGNATURE;

	/**
	 * The operation id for the '<em>Is Construct Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_CONSTRUCT_SIGNATURE = TFUNCTION___IS_CONSTRUCT_SIGNATURE;

	/**
	 * The operation id for the '<em>Get Fpar For Arg Idx</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_FPAR_FOR_ARG_IDX__INT = TFUNCTION___GET_FPAR_FOR_ARG_IDX__INT;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_CONTAINING_TYPE = TFUNCTION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_FIELD = TFUNCTION_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_GETTER = TFUNCTION_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_SETTER = TFUNCTION_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_ACCESSOR = TFUNCTION_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_METHOD = TFUNCTION_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_OPTIONAL = TFUNCTION_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_READABLE = TFUNCTION_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_WRITEABLE = TFUNCTION_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_FINAL = TFUNCTION_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_STATIC = TFUNCTION_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_CONST = TFUNCTION_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_POLYFILLED = TFUNCTION_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_MEMBER_ACCESS_MODIFIER = TFUNCTION_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TFUNCTION_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_ABSTRACT = TFUNCTION_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_MEMBER_TYPE = TFUNCTION_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___IS_CONSTRUCTOR = TFUNCTION_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Get Function As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_FUNCTION_AS_STRING = TFUNCTION_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD___GET_MEMBER_AS_STRING = TFUNCTION_OPERATION_COUNT + 24;

	/**
	 * The number of operations of the '<em>TMethod</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMETHOD_OPERATION_COUNT = TFUNCTION_OPERATION_COUNT + 25;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TStructMethodImpl <em>TStruct Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TStructMethodImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructMethod()
	 * @generated
	 */
	int TSTRUCT_METHOD = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__NAME = TMETHOD__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DIRECTLY_EXPORTED = TMETHOD__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DIRECTLY_EXPORTED_AS_DEFAULT = TMETHOD__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__EXPORTING_EXPORT_DEFINITIONS = TMETHOD__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__ANNOTATIONS = TMETHOD__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__TYPE_VARS = TMETHOD__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_TYPE_ACCESS_MODIFIER = TMETHOD__DECLARED_TYPE_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_PROVIDED_BY_RUNTIME = TMETHOD__DECLARED_PROVIDED_BY_RUNTIME;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__AST_ELEMENT = TMETHOD__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__EXTERNAL = TMETHOD__EXTERNAL;

	/**
	 * The feature id for the '<em><b>Fpars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__FPARS = TMETHOD__FPARS;

	/**
	 * The feature id for the '<em><b>Return Value Marked Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__RETURN_VALUE_MARKED_OPTIONAL = TMETHOD__RETURN_VALUE_MARKED_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Return Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__RETURN_TYPE_REF = TMETHOD__RETURN_TYPE_REF;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_THIS_TYPE = TMETHOD__DECLARED_THIS_TYPE;

	/**
	 * The feature id for the '<em><b>Declared Async</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_ASYNC = TMETHOD__DECLARED_ASYNC;

	/**
	 * The feature id for the '<em><b>Declared Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_GENERATOR = TMETHOD__DECLARED_GENERATOR;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__CONSTRUCTOR = TMETHOD__CONSTRUCTOR;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_FINAL = TMETHOD__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_STATIC = TMETHOD__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_OVERRIDE = TMETHOD__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__HAS_COMPUTED_NAME = TMETHOD__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__CONSTITUENT_MEMBERS = TMETHOD__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__COMPOSED = TMETHOD__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__HAS_NO_BODY = TMETHOD__HAS_NO_BODY;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_MEMBER_ACCESS_MODIFIER = TMETHOD__DECLARED_MEMBER_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Declared Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DECLARED_ABSTRACT = TMETHOD__DECLARED_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Lacks This Or Super Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__LACKS_THIS_OR_SUPER_USAGE = TMETHOD__LACKS_THIS_OR_SUPER_USAGE;

	/**
	 * The feature id for the '<em><b>Defined Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD__DEFINED_MEMBER = TMETHOD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TStruct Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD_FEATURE_COUNT = TMETHOD_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_CONTAINING_MODULE = TMETHOD___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_EXPORTED = TMETHOD___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_INDIRECTLY_EXPORTED = TMETHOD___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_DIRECTLY_EXPORTED_NAME = TMETHOD___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_HOLLOW = TMETHOD___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_ALIAS = TMETHOD___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_POLYFILL = TMETHOD___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_STATIC_POLYFILL = TMETHOD___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_DYNAMIZABLE = TMETHOD___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_ARRAY_LIKE = TMETHOD___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_ELEMENT_TYPE = TMETHOD___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_GENERIC = TMETHOD___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_TYPE_VARS = TMETHOD___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_VARIANCE_OF_TYPE_VAR__INT = TMETHOD___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_RAW_TYPE_AS_STRING = TMETHOD___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_TYPE_AS_STRING = TMETHOD___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_PROVIDED_BY_RUNTIME = TMETHOD___IS_PROVIDED_BY_RUNTIME;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_TYPE_ACCESS_MODIFIER = TMETHOD___GET_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_DEFAULT_TYPE_ACCESS_MODIFIER = TMETHOD___GET_DEFAULT_TYPE_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_DIRECTLY_EXPORTED = TMETHOD___IS_DIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_AST_ELEMENT_NO_RESOLVE = TMETHOD___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Return Value Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_RETURN_VALUE_OPTIONAL = TMETHOD___IS_RETURN_VALUE_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Call Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_CALL_SIGNATURE = TMETHOD___IS_CALL_SIGNATURE;

	/**
	 * The operation id for the '<em>Is Construct Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_CONSTRUCT_SIGNATURE = TMETHOD___IS_CONSTRUCT_SIGNATURE;

	/**
	 * The operation id for the '<em>Get Fpar For Arg Idx</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_FPAR_FOR_ARG_IDX__INT = TMETHOD___GET_FPAR_FOR_ARG_IDX__INT;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_CONTAINING_TYPE = TMETHOD___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_FIELD = TMETHOD___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_GETTER = TMETHOD___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_SETTER = TMETHOD___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_ACCESSOR = TMETHOD___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_METHOD = TMETHOD___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_OPTIONAL = TMETHOD___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_READABLE = TMETHOD___IS_READABLE;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_WRITEABLE = TMETHOD___IS_WRITEABLE;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_FINAL = TMETHOD___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_CONST = TMETHOD___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_POLYFILLED = TMETHOD___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_ABSTRACT = TMETHOD___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_MEMBER_TYPE = TMETHOD___GET_MEMBER_TYPE;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_CONSTRUCTOR = TMETHOD___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Get Function As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_FUNCTION_AS_STRING = TMETHOD___GET_FUNCTION_AS_STRING;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_MEMBER_AS_STRING = TMETHOD___GET_MEMBER_AS_STRING;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TMETHOD_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_STATIC = TMETHOD_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___GET_MEMBER_ACCESS_MODIFIER = TMETHOD_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is AST Call Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_AST_CALL_SIGNATURE = TMETHOD_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is AST Construct Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD___IS_AST_CONSTRUCT_SIGNATURE = TMETHOD_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>TStruct Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_METHOD_OPERATION_COUNT = TMETHOD_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TAbstractVariableImpl <em>TAbstract Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TAbstractVariableImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAbstractVariable()
	 * @generated
	 */
	int TABSTRACT_VARIABLE = 59;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABSTRACT_VARIABLE__NAME = IDENTIFIABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABSTRACT_VARIABLE__TYPE_REF = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABSTRACT_VARIABLE__ANNOTATIONS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABSTRACT_VARIABLE__AST_ELEMENT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TAbstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABSTRACT_VARIABLE_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABSTRACT_VARIABLE___GET_CONTAINING_MODULE = IDENTIFIABLE_ELEMENT___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABSTRACT_VARIABLE___GET_AST_ELEMENT_NO_RESOLVE = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TAbstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABSTRACT_VARIABLE_OPERATION_COUNT = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TFormalParameterImpl <em>TFormal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TFormalParameterImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTFormalParameter()
	 * @generated
	 */
	int TFORMAL_PARAMETER = 45;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER__NAME = TABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER__TYPE_REF = TABSTRACT_VARIABLE__TYPE_REF;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER__ANNOTATIONS = TABSTRACT_VARIABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER__AST_ELEMENT = TABSTRACT_VARIABLE__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Variadic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER__VARIADIC = TABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ast Initializer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER__AST_INITIALIZER = TABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Initializer Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT = TABSTRACT_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TFormal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER_FEATURE_COUNT = TABSTRACT_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER___GET_CONTAINING_MODULE = TABSTRACT_VARIABLE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER___GET_AST_ELEMENT_NO_RESOLVE = TABSTRACT_VARIABLE___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Has AST Initializer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER___HAS_AST_INITIALIZER = TABSTRACT_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER___IS_OPTIONAL = TABSTRACT_VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Variadic Or Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER___IS_VARIADIC_OR_OPTIONAL = TABSTRACT_VARIABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Formal Parameter As Types String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER___GET_FORMAL_PARAMETER_AS_TYPES_STRING = TABSTRACT_VARIABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Formal Parameter As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER___GET_FORMAL_PARAMETER_AS_STRING = TABSTRACT_VARIABLE_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>TFormal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFORMAL_PARAMETER_OPERATION_COUNT = TABSTRACT_VARIABLE_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TAnonymousFormalParameterImpl <em>TAnonymous Formal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TAnonymousFormalParameterImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnonymousFormalParameter()
	 * @generated
	 */
	int TANONYMOUS_FORMAL_PARAMETER = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER__NAME = TFORMAL_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER__TYPE_REF = TFORMAL_PARAMETER__TYPE_REF;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER__ANNOTATIONS = TFORMAL_PARAMETER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER__AST_ELEMENT = TFORMAL_PARAMETER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Variadic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER__VARIADIC = TFORMAL_PARAMETER__VARIADIC;

	/**
	 * The feature id for the '<em><b>Ast Initializer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER__AST_INITIALIZER = TFORMAL_PARAMETER__AST_INITIALIZER;

	/**
	 * The feature id for the '<em><b>Has Initializer Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT = TFORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT;

	/**
	 * The number of structural features of the '<em>TAnonymous Formal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER_FEATURE_COUNT = TFORMAL_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___GET_CONTAINING_MODULE = TFORMAL_PARAMETER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___GET_AST_ELEMENT_NO_RESOLVE = TFORMAL_PARAMETER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Has AST Initializer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___HAS_AST_INITIALIZER = TFORMAL_PARAMETER___HAS_AST_INITIALIZER;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___IS_OPTIONAL = TFORMAL_PARAMETER___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Variadic Or Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___IS_VARIADIC_OR_OPTIONAL = TFORMAL_PARAMETER___IS_VARIADIC_OR_OPTIONAL;

	/**
	 * The operation id for the '<em>Get Formal Parameter As Types String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___GET_FORMAL_PARAMETER_AS_TYPES_STRING = TFORMAL_PARAMETER___GET_FORMAL_PARAMETER_AS_TYPES_STRING;

	/**
	 * The operation id for the '<em>Get Formal Parameter As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___GET_FORMAL_PARAMETER_AS_STRING = TFORMAL_PARAMETER___GET_FORMAL_PARAMETER_AS_STRING;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___GET_NAME = TFORMAL_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Defined Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER___GET_DEFINED_NAME = TFORMAL_PARAMETER_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>TAnonymous Formal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANONYMOUS_FORMAL_PARAMETER_OPERATION_COUNT = TFORMAL_PARAMETER_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TFieldImpl <em>TField</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TFieldImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTField()
	 * @generated
	 */
	int TFIELD = 47;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__NAME = TMEMBER_WITH_ACCESS_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__ANNOTATIONS = TMEMBER_WITH_ACCESS_MODIFIER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__AST_ELEMENT = TMEMBER_WITH_ACCESS_MODIFIER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__DIRECTLY_EXPORTED = TMEMBER_WITH_ACCESS_MODIFIER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__DIRECTLY_EXPORTED_AS_DEFAULT = TMEMBER_WITH_ACCESS_MODIFIER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__EXPORTING_EXPORT_DEFINITIONS = TMEMBER_WITH_ACCESS_MODIFIER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__DECLARED_FINAL = TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__DECLARED_STATIC = TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__DECLARED_OVERRIDE = TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__HAS_COMPUTED_NAME = TMEMBER_WITH_ACCESS_MODIFIER__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__CONSTITUENT_MEMBERS = TMEMBER_WITH_ACCESS_MODIFIER__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__COMPOSED = TMEMBER_WITH_ACCESS_MODIFIER__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__HAS_NO_BODY = TMEMBER_WITH_ACCESS_MODIFIER__HAS_NO_BODY;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__DECLARED_MEMBER_ACCESS_MODIFIER = TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_MEMBER_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__TYPE_REF = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__CONST = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Compile Time Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__COMPILE_TIME_VALUE = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Has Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__HAS_EXPRESSION = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD__OPTIONAL = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>TField</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD_FEATURE_COUNT = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___GET_CONTAINING_MODULE = TMEMBER_WITH_ACCESS_MODIFIER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___GET_AST_ELEMENT_NO_RESOLVE = TMEMBER_WITH_ACCESS_MODIFIER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_EXPORTED = TMEMBER_WITH_ACCESS_MODIFIER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_INDIRECTLY_EXPORTED = TMEMBER_WITH_ACCESS_MODIFIER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___GET_DIRECTLY_EXPORTED_NAME = TMEMBER_WITH_ACCESS_MODIFIER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___GET_CONTAINING_TYPE = TMEMBER_WITH_ACCESS_MODIFIER___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_FIELD = TMEMBER_WITH_ACCESS_MODIFIER___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_GETTER = TMEMBER_WITH_ACCESS_MODIFIER___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_SETTER = TMEMBER_WITH_ACCESS_MODIFIER___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_ACCESSOR = TMEMBER_WITH_ACCESS_MODIFIER___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_METHOD = TMEMBER_WITH_ACCESS_MODIFIER___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_CONSTRUCTOR = TMEMBER_WITH_ACCESS_MODIFIER___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_OPTIONAL = TMEMBER_WITH_ACCESS_MODIFIER___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_ABSTRACT = TMEMBER_WITH_ACCESS_MODIFIER___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_FINAL = TMEMBER_WITH_ACCESS_MODIFIER___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_CONST = TMEMBER_WITH_ACCESS_MODIFIER___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_POLYFILLED = TMEMBER_WITH_ACCESS_MODIFIER___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___GET_MEMBER_ACCESS_MODIFIER = TMEMBER_WITH_ACCESS_MODIFIER___GET_MEMBER_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TMEMBER_WITH_ACCESS_MODIFIER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_STATIC = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_READABLE = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___IS_WRITEABLE = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___GET_MEMBER_TYPE = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD___GET_MEMBER_AS_STRING = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>TField</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFIELD_OPERATION_COUNT = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TStructFieldImpl <em>TStruct Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TStructFieldImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructField()
	 * @generated
	 */
	int TSTRUCT_FIELD = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__NAME = TFIELD__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__ANNOTATIONS = TFIELD__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__AST_ELEMENT = TFIELD__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__DIRECTLY_EXPORTED = TFIELD__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__DIRECTLY_EXPORTED_AS_DEFAULT = TFIELD__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__EXPORTING_EXPORT_DEFINITIONS = TFIELD__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__DECLARED_FINAL = TFIELD__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__DECLARED_STATIC = TFIELD__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__DECLARED_OVERRIDE = TFIELD__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__HAS_COMPUTED_NAME = TFIELD__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__CONSTITUENT_MEMBERS = TFIELD__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__COMPOSED = TFIELD__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__HAS_NO_BODY = TFIELD__HAS_NO_BODY;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__DECLARED_MEMBER_ACCESS_MODIFIER = TFIELD__DECLARED_MEMBER_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__TYPE_REF = TFIELD__TYPE_REF;

	/**
	 * The feature id for the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__CONST = TFIELD__CONST;

	/**
	 * The feature id for the '<em><b>Compile Time Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__COMPILE_TIME_VALUE = TFIELD__COMPILE_TIME_VALUE;

	/**
	 * The feature id for the '<em><b>Has Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__HAS_EXPRESSION = TFIELD__HAS_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__OPTIONAL = TFIELD__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Defined Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD__DEFINED_MEMBER = TFIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TStruct Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD_FEATURE_COUNT = TFIELD_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___GET_CONTAINING_MODULE = TFIELD___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___GET_AST_ELEMENT_NO_RESOLVE = TFIELD___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_EXPORTED = TFIELD___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_INDIRECTLY_EXPORTED = TFIELD___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___GET_DIRECTLY_EXPORTED_NAME = TFIELD___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___GET_CONTAINING_TYPE = TFIELD___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_FIELD = TFIELD___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_GETTER = TFIELD___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_SETTER = TFIELD___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_ACCESSOR = TFIELD___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_METHOD = TFIELD___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_CONSTRUCTOR = TFIELD___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_OPTIONAL = TFIELD___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_ABSTRACT = TFIELD___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_FINAL = TFIELD___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_CONST = TFIELD___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_POLYFILLED = TFIELD___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_READABLE = TFIELD___IS_READABLE;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_WRITEABLE = TFIELD___IS_WRITEABLE;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___GET_MEMBER_TYPE = TFIELD___GET_MEMBER_TYPE;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___GET_MEMBER_AS_STRING = TFIELD___GET_MEMBER_AS_STRING;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TFIELD_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_STATIC = TFIELD_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___GET_MEMBER_ACCESS_MODIFIER = TFIELD_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is AST Call Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_AST_CALL_SIGNATURE = TFIELD_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is AST Construct Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD___IS_AST_CONSTRUCT_SIGNATURE = TFIELD_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>TStruct Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_FIELD_OPERATION_COUNT = TFIELD_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.FieldAccessorImpl <em>Field Accessor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.FieldAccessorImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getFieldAccessor()
	 * @generated
	 */
	int FIELD_ACCESSOR = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__NAME = TMEMBER_WITH_ACCESS_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__ANNOTATIONS = TMEMBER_WITH_ACCESS_MODIFIER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__AST_ELEMENT = TMEMBER_WITH_ACCESS_MODIFIER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__DIRECTLY_EXPORTED = TMEMBER_WITH_ACCESS_MODIFIER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__DIRECTLY_EXPORTED_AS_DEFAULT = TMEMBER_WITH_ACCESS_MODIFIER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__EXPORTING_EXPORT_DEFINITIONS = TMEMBER_WITH_ACCESS_MODIFIER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__DECLARED_FINAL = TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__DECLARED_STATIC = TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__DECLARED_OVERRIDE = TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__HAS_COMPUTED_NAME = TMEMBER_WITH_ACCESS_MODIFIER__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__CONSTITUENT_MEMBERS = TMEMBER_WITH_ACCESS_MODIFIER__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__COMPOSED = TMEMBER_WITH_ACCESS_MODIFIER__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__HAS_NO_BODY = TMEMBER_WITH_ACCESS_MODIFIER__HAS_NO_BODY;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__DECLARED_MEMBER_ACCESS_MODIFIER = TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_MEMBER_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__OPTIONAL = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__DECLARED_ABSTRACT = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR__DECLARED_THIS_TYPE = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Field Accessor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR_FEATURE_COUNT = TMEMBER_WITH_ACCESS_MODIFIER_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_CONTAINING_MODULE = TMEMBER_WITH_ACCESS_MODIFIER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_AST_ELEMENT_NO_RESOLVE = TMEMBER_WITH_ACCESS_MODIFIER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_EXPORTED = TMEMBER_WITH_ACCESS_MODIFIER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_INDIRECTLY_EXPORTED = TMEMBER_WITH_ACCESS_MODIFIER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_DIRECTLY_EXPORTED_NAME = TMEMBER_WITH_ACCESS_MODIFIER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_CONTAINING_TYPE = TMEMBER_WITH_ACCESS_MODIFIER___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_MEMBER_TYPE = TMEMBER_WITH_ACCESS_MODIFIER___GET_MEMBER_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_FIELD = TMEMBER_WITH_ACCESS_MODIFIER___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_GETTER = TMEMBER_WITH_ACCESS_MODIFIER___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_SETTER = TMEMBER_WITH_ACCESS_MODIFIER___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_ACCESSOR = TMEMBER_WITH_ACCESS_MODIFIER___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_METHOD = TMEMBER_WITH_ACCESS_MODIFIER___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_CONSTRUCTOR = TMEMBER_WITH_ACCESS_MODIFIER___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_OPTIONAL = TMEMBER_WITH_ACCESS_MODIFIER___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_READABLE = TMEMBER_WITH_ACCESS_MODIFIER___IS_READABLE;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_WRITEABLE = TMEMBER_WITH_ACCESS_MODIFIER___IS_WRITEABLE;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_MEMBER_AS_STRING = TMEMBER_WITH_ACCESS_MODIFIER___GET_MEMBER_AS_STRING;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_FINAL = TMEMBER_WITH_ACCESS_MODIFIER___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_STATIC = TMEMBER_WITH_ACCESS_MODIFIER___IS_STATIC;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_CONST = TMEMBER_WITH_ACCESS_MODIFIER___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_POLYFILLED = TMEMBER_WITH_ACCESS_MODIFIER___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_MEMBER_ACCESS_MODIFIER = TMEMBER_WITH_ACCESS_MODIFIER___GET_MEMBER_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TMEMBER_WITH_ACCESS_MODIFIER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___GET_TYPE_REF = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR___IS_ABSTRACT = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Field Accessor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ACCESSOR_OPERATION_COUNT = TMEMBER_WITH_ACCESS_MODIFIER_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TGetterImpl <em>TGetter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TGetterImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTGetter()
	 * @generated
	 */
	int TGETTER = 50;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__NAME = FIELD_ACCESSOR__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__ANNOTATIONS = FIELD_ACCESSOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__AST_ELEMENT = FIELD_ACCESSOR__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__DIRECTLY_EXPORTED = FIELD_ACCESSOR__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__DIRECTLY_EXPORTED_AS_DEFAULT = FIELD_ACCESSOR__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__EXPORTING_EXPORT_DEFINITIONS = FIELD_ACCESSOR__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__DECLARED_FINAL = FIELD_ACCESSOR__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__DECLARED_STATIC = FIELD_ACCESSOR__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__DECLARED_OVERRIDE = FIELD_ACCESSOR__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__HAS_COMPUTED_NAME = FIELD_ACCESSOR__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__CONSTITUENT_MEMBERS = FIELD_ACCESSOR__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__COMPOSED = FIELD_ACCESSOR__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__HAS_NO_BODY = FIELD_ACCESSOR__HAS_NO_BODY;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__DECLARED_MEMBER_ACCESS_MODIFIER = FIELD_ACCESSOR__DECLARED_MEMBER_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__OPTIONAL = FIELD_ACCESSOR__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Declared Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__DECLARED_ABSTRACT = FIELD_ACCESSOR__DECLARED_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__DECLARED_THIS_TYPE = FIELD_ACCESSOR__DECLARED_THIS_TYPE;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER__TYPE_REF = FIELD_ACCESSOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TGetter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER_FEATURE_COUNT = FIELD_ACCESSOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_CONTAINING_MODULE = FIELD_ACCESSOR___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_AST_ELEMENT_NO_RESOLVE = FIELD_ACCESSOR___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_EXPORTED = FIELD_ACCESSOR___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_INDIRECTLY_EXPORTED = FIELD_ACCESSOR___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_DIRECTLY_EXPORTED_NAME = FIELD_ACCESSOR___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_CONTAINING_TYPE = FIELD_ACCESSOR___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_FIELD = FIELD_ACCESSOR___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_GETTER = FIELD_ACCESSOR___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_SETTER = FIELD_ACCESSOR___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_ACCESSOR = FIELD_ACCESSOR___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_METHOD = FIELD_ACCESSOR___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_CONSTRUCTOR = FIELD_ACCESSOR___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_OPTIONAL = FIELD_ACCESSOR___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_READABLE = FIELD_ACCESSOR___IS_READABLE;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_WRITEABLE = FIELD_ACCESSOR___IS_WRITEABLE;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_FINAL = FIELD_ACCESSOR___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_STATIC = FIELD_ACCESSOR___IS_STATIC;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_CONST = FIELD_ACCESSOR___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_POLYFILLED = FIELD_ACCESSOR___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_MEMBER_ACCESS_MODIFIER = FIELD_ACCESSOR___GET_MEMBER_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = FIELD_ACCESSOR___GET_DEFAULT_MEMBER_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_TYPE_REF = FIELD_ACCESSOR___GET_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___IS_ABSTRACT = FIELD_ACCESSOR___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_MEMBER_TYPE = FIELD_ACCESSOR_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER___GET_MEMBER_AS_STRING = FIELD_ACCESSOR_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>TGetter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGETTER_OPERATION_COUNT = FIELD_ACCESSOR_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TStructGetterImpl <em>TStruct Getter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TStructGetterImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructGetter()
	 * @generated
	 */
	int TSTRUCT_GETTER = 51;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__NAME = TGETTER__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__ANNOTATIONS = TGETTER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__AST_ELEMENT = TGETTER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DIRECTLY_EXPORTED = TGETTER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DIRECTLY_EXPORTED_AS_DEFAULT = TGETTER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__EXPORTING_EXPORT_DEFINITIONS = TGETTER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DECLARED_FINAL = TGETTER__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DECLARED_STATIC = TGETTER__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DECLARED_OVERRIDE = TGETTER__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__HAS_COMPUTED_NAME = TGETTER__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__CONSTITUENT_MEMBERS = TGETTER__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__COMPOSED = TGETTER__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__HAS_NO_BODY = TGETTER__HAS_NO_BODY;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DECLARED_MEMBER_ACCESS_MODIFIER = TGETTER__DECLARED_MEMBER_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__OPTIONAL = TGETTER__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Declared Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DECLARED_ABSTRACT = TGETTER__DECLARED_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DECLARED_THIS_TYPE = TGETTER__DECLARED_THIS_TYPE;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__TYPE_REF = TGETTER__TYPE_REF;

	/**
	 * The feature id for the '<em><b>Defined Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER__DEFINED_MEMBER = TGETTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TStruct Getter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER_FEATURE_COUNT = TGETTER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_CONTAINING_MODULE = TGETTER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_AST_ELEMENT_NO_RESOLVE = TGETTER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_EXPORTED = TGETTER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_INDIRECTLY_EXPORTED = TGETTER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_DIRECTLY_EXPORTED_NAME = TGETTER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_CONTAINING_TYPE = TGETTER___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_FIELD = TGETTER___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_GETTER = TGETTER___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_SETTER = TGETTER___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_ACCESSOR = TGETTER___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_METHOD = TGETTER___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_CONSTRUCTOR = TGETTER___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_OPTIONAL = TGETTER___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_READABLE = TGETTER___IS_READABLE;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_WRITEABLE = TGETTER___IS_WRITEABLE;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_FINAL = TGETTER___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_CONST = TGETTER___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_POLYFILLED = TGETTER___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Get Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_TYPE_REF = TGETTER___GET_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_ABSTRACT = TGETTER___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_MEMBER_TYPE = TGETTER___GET_MEMBER_TYPE;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_MEMBER_AS_STRING = TGETTER___GET_MEMBER_AS_STRING;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TGETTER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_STATIC = TGETTER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___GET_MEMBER_ACCESS_MODIFIER = TGETTER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is AST Call Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_AST_CALL_SIGNATURE = TGETTER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is AST Construct Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER___IS_AST_CONSTRUCT_SIGNATURE = TGETTER_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>TStruct Getter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_GETTER_OPERATION_COUNT = TGETTER_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TSetterImpl <em>TSetter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TSetterImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTSetter()
	 * @generated
	 */
	int TSETTER = 52;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__NAME = FIELD_ACCESSOR__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__ANNOTATIONS = FIELD_ACCESSOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__AST_ELEMENT = FIELD_ACCESSOR__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__DIRECTLY_EXPORTED = FIELD_ACCESSOR__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__DIRECTLY_EXPORTED_AS_DEFAULT = FIELD_ACCESSOR__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__EXPORTING_EXPORT_DEFINITIONS = FIELD_ACCESSOR__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__DECLARED_FINAL = FIELD_ACCESSOR__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__DECLARED_STATIC = FIELD_ACCESSOR__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__DECLARED_OVERRIDE = FIELD_ACCESSOR__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__HAS_COMPUTED_NAME = FIELD_ACCESSOR__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__CONSTITUENT_MEMBERS = FIELD_ACCESSOR__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__COMPOSED = FIELD_ACCESSOR__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__HAS_NO_BODY = FIELD_ACCESSOR__HAS_NO_BODY;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__DECLARED_MEMBER_ACCESS_MODIFIER = FIELD_ACCESSOR__DECLARED_MEMBER_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__OPTIONAL = FIELD_ACCESSOR__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Declared Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__DECLARED_ABSTRACT = FIELD_ACCESSOR__DECLARED_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__DECLARED_THIS_TYPE = FIELD_ACCESSOR__DECLARED_THIS_TYPE;

	/**
	 * The feature id for the '<em><b>Fpar</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER__FPAR = FIELD_ACCESSOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TSetter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER_FEATURE_COUNT = FIELD_ACCESSOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_CONTAINING_MODULE = FIELD_ACCESSOR___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_AST_ELEMENT_NO_RESOLVE = FIELD_ACCESSOR___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_EXPORTED = FIELD_ACCESSOR___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_INDIRECTLY_EXPORTED = FIELD_ACCESSOR___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_DIRECTLY_EXPORTED_NAME = FIELD_ACCESSOR___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_CONTAINING_TYPE = FIELD_ACCESSOR___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_FIELD = FIELD_ACCESSOR___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_GETTER = FIELD_ACCESSOR___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_SETTER = FIELD_ACCESSOR___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_ACCESSOR = FIELD_ACCESSOR___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_METHOD = FIELD_ACCESSOR___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_CONSTRUCTOR = FIELD_ACCESSOR___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_OPTIONAL = FIELD_ACCESSOR___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_FINAL = FIELD_ACCESSOR___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_STATIC = FIELD_ACCESSOR___IS_STATIC;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_CONST = FIELD_ACCESSOR___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_POLYFILLED = FIELD_ACCESSOR___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_MEMBER_ACCESS_MODIFIER = FIELD_ACCESSOR___GET_MEMBER_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = FIELD_ACCESSOR___GET_DEFAULT_MEMBER_ACCESS_MODIFIER;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_ABSTRACT = FIELD_ACCESSOR___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Get Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_TYPE_REF = FIELD_ACCESSOR_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_READABLE = FIELD_ACCESSOR_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___IS_WRITEABLE = FIELD_ACCESSOR_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_MEMBER_TYPE = FIELD_ACCESSOR_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER___GET_MEMBER_AS_STRING = FIELD_ACCESSOR_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>TSetter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSETTER_OPERATION_COUNT = FIELD_ACCESSOR_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TStructSetterImpl <em>TStruct Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TStructSetterImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructSetter()
	 * @generated
	 */
	int TSTRUCT_SETTER = 53;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__NAME = TSETTER__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__ANNOTATIONS = TSETTER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__AST_ELEMENT = TSETTER__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DIRECTLY_EXPORTED = TSETTER__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DIRECTLY_EXPORTED_AS_DEFAULT = TSETTER__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__EXPORTING_EXPORT_DEFINITIONS = TSETTER__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Declared Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DECLARED_FINAL = TSETTER__DECLARED_FINAL;

	/**
	 * The feature id for the '<em><b>Declared Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DECLARED_STATIC = TSETTER__DECLARED_STATIC;

	/**
	 * The feature id for the '<em><b>Declared Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DECLARED_OVERRIDE = TSETTER__DECLARED_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Has Computed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__HAS_COMPUTED_NAME = TSETTER__HAS_COMPUTED_NAME;

	/**
	 * The feature id for the '<em><b>Constituent Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__CONSTITUENT_MEMBERS = TSETTER__CONSTITUENT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__COMPOSED = TSETTER__COMPOSED;

	/**
	 * The feature id for the '<em><b>Has No Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__HAS_NO_BODY = TSETTER__HAS_NO_BODY;

	/**
	 * The feature id for the '<em><b>Declared Member Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DECLARED_MEMBER_ACCESS_MODIFIER = TSETTER__DECLARED_MEMBER_ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__OPTIONAL = TSETTER__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Declared Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DECLARED_ABSTRACT = TSETTER__DECLARED_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DECLARED_THIS_TYPE = TSETTER__DECLARED_THIS_TYPE;

	/**
	 * The feature id for the '<em><b>Fpar</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__FPAR = TSETTER__FPAR;

	/**
	 * The feature id for the '<em><b>Defined Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER__DEFINED_MEMBER = TSETTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TStruct Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER_FEATURE_COUNT = TSETTER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_CONTAINING_MODULE = TSETTER___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_AST_ELEMENT_NO_RESOLVE = TSETTER___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_EXPORTED = TSETTER___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_INDIRECTLY_EXPORTED = TSETTER___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_DIRECTLY_EXPORTED_NAME = TSETTER___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Get Containing Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_CONTAINING_TYPE = TSETTER___GET_CONTAINING_TYPE;

	/**
	 * The operation id for the '<em>Is Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_FIELD = TSETTER___IS_FIELD;

	/**
	 * The operation id for the '<em>Is Getter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_GETTER = TSETTER___IS_GETTER;

	/**
	 * The operation id for the '<em>Is Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_SETTER = TSETTER___IS_SETTER;

	/**
	 * The operation id for the '<em>Is Accessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_ACCESSOR = TSETTER___IS_ACCESSOR;

	/**
	 * The operation id for the '<em>Is Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_METHOD = TSETTER___IS_METHOD;

	/**
	 * The operation id for the '<em>Is Constructor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_CONSTRUCTOR = TSETTER___IS_CONSTRUCTOR;

	/**
	 * The operation id for the '<em>Is Optional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_OPTIONAL = TSETTER___IS_OPTIONAL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_FINAL = TSETTER___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Const</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_CONST = TSETTER___IS_CONST;

	/**
	 * The operation id for the '<em>Is Polyfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_POLYFILLED = TSETTER___IS_POLYFILLED;

	/**
	 * The operation id for the '<em>Is Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_ABSTRACT = TSETTER___IS_ABSTRACT;

	/**
	 * The operation id for the '<em>Get Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_TYPE_REF = TSETTER___GET_TYPE_REF;

	/**
	 * The operation id for the '<em>Is Readable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_READABLE = TSETTER___IS_READABLE;

	/**
	 * The operation id for the '<em>Get Member Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_MEMBER_TYPE = TSETTER___GET_MEMBER_TYPE;

	/**
	 * The operation id for the '<em>Get Member As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_MEMBER_AS_STRING = TSETTER___GET_MEMBER_AS_STRING;

	/**
	 * The operation id for the '<em>Get Default Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = TSETTER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Static</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_STATIC = TSETTER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Member Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___GET_MEMBER_ACCESS_MODIFIER = TSETTER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is AST Call Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_AST_CALL_SIGNATURE = TSETTER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is AST Construct Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_AST_CONSTRUCT_SIGNATURE = TSETTER_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Writeable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER___IS_WRITEABLE = TSETTER_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>TStruct Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTRUCT_SETTER_OPERATION_COUNT = TSETTER_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TEnumImpl <em>TEnum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TEnumImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTEnum()
	 * @generated
	 */
	int TENUM = 54;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__DIRECTLY_EXPORTED = TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__DIRECTLY_EXPORTED_AS_DEFAULT = TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__EXPORTING_EXPORT_DEFINITIONS = TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__DECLARED_TYPE_ACCESS_MODIFIER = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__DECLARED_PROVIDED_BY_RUNTIME = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__AST_ELEMENT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__EXTERNAL = TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM__LITERALS = TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>TEnum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_FEATURE_COUNT = TYPE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_CONTAINING_MODULE = TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_EXPORTED = TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_INDIRECTLY_EXPORTED = TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_DIRECTLY_EXPORTED_NAME = TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_HOLLOW = TYPE___IS_HOLLOW;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_ALIAS = TYPE___IS_ALIAS;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_POLYFILL = TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_STATIC_POLYFILL = TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_FINAL = TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_DYNAMIZABLE = TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_ARRAY_LIKE = TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_ELEMENT_TYPE = TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_GENERIC = TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_TYPE_VARS = TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_VARIANCE_OF_TYPE_VAR__INT = TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_RAW_TYPE_AS_STRING = TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_TYPE_AS_STRING = TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_PROVIDED_BY_RUNTIME = TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_TYPE_ACCESS_MODIFIER = TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_DEFAULT_TYPE_ACCESS_MODIFIER = TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___IS_DIRECTLY_EXPORTED = TYPE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM___GET_AST_ELEMENT_NO_RESOLVE = TYPE_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>TEnum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_OPERATION_COUNT = TYPE_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.SyntaxRelatedTElementImpl <em>Syntax Related TElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.SyntaxRelatedTElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getSyntaxRelatedTElement()
	 * @generated
	 */
	int SYNTAX_RELATED_TELEMENT = 57;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_RELATED_TELEMENT__AST_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Syntax Related TElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_RELATED_TELEMENT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_RELATED_TELEMENT___GET_AST_ELEMENT_NO_RESOLVE = 0;

	/**
	 * The number of operations of the '<em>Syntax Related TElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_RELATED_TELEMENT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TEnumLiteralImpl <em>TEnum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TEnumLiteralImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTEnumLiteral()
	 * @generated
	 */
	int TENUM_LITERAL = 55;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_LITERAL__AST_ELEMENT = SYNTAX_RELATED_TELEMENT__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_LITERAL__NAME = SYNTAX_RELATED_TELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_LITERAL__VALUE_STRING = SYNTAX_RELATED_TELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_LITERAL__VALUE_NUMBER = SYNTAX_RELATED_TELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TEnum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_LITERAL_FEATURE_COUNT = SYNTAX_RELATED_TELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_LITERAL___GET_AST_ELEMENT_NO_RESOLVE = SYNTAX_RELATED_TELEMENT___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_LITERAL___GET_CONTAINING_MODULE = SYNTAX_RELATED_TELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TEnum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENUM_LITERAL_OPERATION_COUNT = SYNTAX_RELATED_TELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TypeAliasImpl <em>Type Alias</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TypeAliasImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypeAlias()
	 * @generated
	 */
	int TYPE_ALIAS = 56;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__NAME = GENERIC_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__DIRECTLY_EXPORTED = GENERIC_TYPE__DIRECTLY_EXPORTED;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__DIRECTLY_EXPORTED_AS_DEFAULT = GENERIC_TYPE__DIRECTLY_EXPORTED_AS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__EXPORTING_EXPORT_DEFINITIONS = GENERIC_TYPE__EXPORTING_EXPORT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__ANNOTATIONS = GENERIC_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__TYPE_VARS = GENERIC_TYPE__TYPE_VARS;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__DECLARED_TYPE_ACCESS_MODIFIER = GENERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__DECLARED_PROVIDED_BY_RUNTIME = GENERIC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__TYPE_REF = GENERIC_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS__AST_ELEMENT = GENERIC_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Type Alias</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS_FEATURE_COUNT = GENERIC_TYPE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_CONTAINING_MODULE = GENERIC_TYPE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_EXPORTED = GENERIC_TYPE___IS_EXPORTED;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_INDIRECTLY_EXPORTED = GENERIC_TYPE___IS_INDIRECTLY_EXPORTED;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_DIRECTLY_EXPORTED_NAME = GENERIC_TYPE___GET_DIRECTLY_EXPORTED_NAME;

	/**
	 * The operation id for the '<em>Is Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_POLYFILL = GENERIC_TYPE___IS_POLYFILL;

	/**
	 * The operation id for the '<em>Is Static Polyfill</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_STATIC_POLYFILL = GENERIC_TYPE___IS_STATIC_POLYFILL;

	/**
	 * The operation id for the '<em>Is Final</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_FINAL = GENERIC_TYPE___IS_FINAL;

	/**
	 * The operation id for the '<em>Is Dynamizable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_DYNAMIZABLE = GENERIC_TYPE___IS_DYNAMIZABLE;

	/**
	 * The operation id for the '<em>Is Array Like</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_ARRAY_LIKE = GENERIC_TYPE___IS_ARRAY_LIKE;

	/**
	 * The operation id for the '<em>Get Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_ELEMENT_TYPE = GENERIC_TYPE___GET_ELEMENT_TYPE;

	/**
	 * The operation id for the '<em>Is Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_GENERIC = GENERIC_TYPE___IS_GENERIC;

	/**
	 * The operation id for the '<em>Get Type Vars</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_TYPE_VARS = GENERIC_TYPE___GET_TYPE_VARS;

	/**
	 * The operation id for the '<em>Get Variance Of Type Var</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_VARIANCE_OF_TYPE_VAR__INT = GENERIC_TYPE___GET_VARIANCE_OF_TYPE_VAR__INT;

	/**
	 * The operation id for the '<em>Get Raw Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_RAW_TYPE_AS_STRING = GENERIC_TYPE___GET_RAW_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Get Type As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_TYPE_AS_STRING = GENERIC_TYPE___GET_TYPE_AS_STRING;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_PROVIDED_BY_RUNTIME = GENERIC_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_TYPE_ACCESS_MODIFIER = GENERIC_TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_DEFAULT_TYPE_ACCESS_MODIFIER = GENERIC_TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_DIRECTLY_EXPORTED = GENERIC_TYPE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___GET_AST_ELEMENT_NO_RESOLVE = GENERIC_TYPE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Alias</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_ALIAS = GENERIC_TYPE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS___IS_HOLLOW = GENERIC_TYPE_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Type Alias</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS_OPERATION_COUNT = GENERIC_TYPE_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TConstableElementImpl <em>TConstable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TConstableElementImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTConstableElement()
	 * @generated
	 */
	int TCONSTABLE_ELEMENT = 58;

	/**
	 * The feature id for the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCONSTABLE_ELEMENT__CONST = 0;

	/**
	 * The feature id for the '<em><b>Compile Time Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCONSTABLE_ELEMENT__COMPILE_TIME_VALUE = 1;

	/**
	 * The number of structural features of the '<em>TConstable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCONSTABLE_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>TConstable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCONSTABLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.impl.TVariableImpl <em>TVariable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.impl.TVariableImpl
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTVariable()
	 * @generated
	 */
	int TVARIABLE = 60;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__NAME = TABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__TYPE_REF = TABSTRACT_VARIABLE__TYPE_REF;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__ANNOTATIONS = TABSTRACT_VARIABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ast Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__AST_ELEMENT = TABSTRACT_VARIABLE__AST_ELEMENT;

	/**
	 * The feature id for the '<em><b>Declared Type Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__DECLARED_TYPE_ACCESS_MODIFIER = TABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Provided By Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__DECLARED_PROVIDED_BY_RUNTIME = TABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__DIRECTLY_EXPORTED = TABSTRACT_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__DIRECTLY_EXPORTED_AS_DEFAULT = TABSTRACT_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__EXPORTING_EXPORT_DEFINITIONS = TABSTRACT_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__CONST = TABSTRACT_VARIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Compile Time Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__COMPILE_TIME_VALUE = TABSTRACT_VARIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__EXTERNAL = TABSTRACT_VARIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Object Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__OBJECT_LITERAL = TABSTRACT_VARIABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>New Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__NEW_EXPRESSION = TABSTRACT_VARIABLE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>TVariable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE_FEATURE_COUNT = TABSTRACT_VARIABLE_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Containing Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___GET_CONTAINING_MODULE = TABSTRACT_VARIABLE___GET_CONTAINING_MODULE;

	/**
	 * The operation id for the '<em>Get Ast Element No Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___GET_AST_ELEMENT_NO_RESOLVE = TABSTRACT_VARIABLE___GET_AST_ELEMENT_NO_RESOLVE;

	/**
	 * The operation id for the '<em>Is Provided By Runtime</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___IS_PROVIDED_BY_RUNTIME = TABSTRACT_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___GET_TYPE_ACCESS_MODIFIER = TABSTRACT_VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Default Type Access Modifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___GET_DEFAULT_TYPE_ACCESS_MODIFIER = TABSTRACT_VARIABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Directly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___IS_DIRECTLY_EXPORTED = TABSTRACT_VARIABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___IS_EXPORTED = TABSTRACT_VARIABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Indirectly Exported</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___IS_INDIRECTLY_EXPORTED = TABSTRACT_VARIABLE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Directly Exported Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___GET_DIRECTLY_EXPORTED_NAME = TABSTRACT_VARIABLE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Hollow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___IS_HOLLOW = TABSTRACT_VARIABLE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Variable As String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE___GET_VARIABLE_AS_STRING = TABSTRACT_VARIABLE_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>TVariable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE_OPERATION_COUNT = TABSTRACT_VARIABLE_OPERATION_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.TypingStrategy <em>Typing Strategy</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.TypingStrategy
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypingStrategy()
	 * @generated
	 */
	int TYPING_STRATEGY = 61;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.TypeAccessModifier <em>Type Access Modifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.TypeAccessModifier
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypeAccessModifier()
	 * @generated
	 */
	int TYPE_ACCESS_MODIFIER = 62;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.MemberAccessModifier <em>Member Access Modifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.MemberAccessModifier
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getMemberAccessModifier()
	 * @generated
	 */
	int MEMBER_ACCESS_MODIFIER = 63;

	/**
	 * The meta object id for the '{@link org.eclipse.n4js.ts.types.MemberType <em>Member Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.MemberType
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getMemberType()
	 * @generated
	 */
	int MEMBER_TYPE = 64;

	/**
	 * The meta object id for the '<em>Iterable Of TExportable Element</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIterableOfTExportableElement()
	 * @generated
	 */
	int ITERABLE_OF_TEXPORTABLE_ELEMENT = 65;

	/**
	 * The meta object id for the '<em>Iterable Of Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIterableOfType()
	 * @generated
	 */
	int ITERABLE_OF_TYPE = 66;

	/**
	 * The meta object id for the '<em>Iterable Of Abstract Namespace</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIterableOfAbstractNamespace()
	 * @generated
	 */
	int ITERABLE_OF_ABSTRACT_NAMESPACE = 67;

	/**
	 * The meta object id for the '<em>Parameterized Type Ref Iterable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getParameterizedTypeRefIterable()
	 * @generated
	 */
	int PARAMETERIZED_TYPE_REF_ITERABLE = 68;

	/**
	 * The meta object id for the '<em>Iterable Of TClassifier</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIterableOfTClassifier()
	 * @generated
	 */
	int ITERABLE_OF_TCLASSIFIER = 69;

	/**
	 * The meta object id for the '<em>Variance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.util.Variance
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getVariance()
	 * @generated
	 */
	int VARIANCE = 70;

	/**
	 * The meta object id for the '<em>Name And Access</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.n4js.ts.types.NameAndAccess
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getNameAndAccess()
	 * @generated
	 */
	int NAME_AND_ACCESS = 71;

	/**
	 * The meta object id for the '<em>Member List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getMemberList()
	 * @generated
	 */
	int MEMBER_LIST = 72;

	/**
	 * The meta object id for the '<em>TClassifier Iterable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTClassifierIterable()
	 * @generated
	 */
	int TCLASSIFIER_ITERABLE = 73;


	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TModule <em>TModule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TModule</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule
	 * @generated
	 */
	EClass getTModule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getSimpleName()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_SimpleName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getQualifiedName()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getPackageName()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_PackageName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#getProjectID <em>Project ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project ID</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getProjectID()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_ProjectID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#getVendorID <em>Vendor ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vendor ID</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getVendorID()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_VendorID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#isN4jsdModule <em>N4jsd Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>N4jsd Module</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#isN4jsdModule()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_N4jsdModule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#isStaticPolyfillModule <em>Static Polyfill Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static Polyfill Module</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#isStaticPolyfillModule()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_StaticPolyfillModule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#isStaticPolyfillAware <em>Static Polyfill Aware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static Polyfill Aware</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#isStaticPolyfillAware()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_StaticPolyfillAware();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#isMainModule <em>Main Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Module</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#isMainModule()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_MainModule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#isPreLinkingPhase <em>Pre Linking Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pre Linking Phase</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#isPreLinkingPhase()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_PreLinkingPhase();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#isReconciled <em>Reconciled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reconciled</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#isReconciled()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_Reconciled();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TModule#getDependenciesRuntime <em>Dependencies Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies Runtime</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getDependenciesRuntime()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_DependenciesRuntime();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.n4js.ts.types.TModule#getCyclicModulesRuntime <em>Cyclic Modules Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Cyclic Modules Runtime</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getCyclicModulesRuntime()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_CyclicModulesRuntime();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.n4js.ts.types.TModule#getCyclicModulesLoadtimeForInheritance <em>Cyclic Modules Loadtime For Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Cyclic Modules Loadtime For Inheritance</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getCyclicModulesLoadtimeForInheritance()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_CyclicModulesLoadtimeForInheritance();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.n4js.ts.types.TModule#getRuntimeCyclicLoadtimeDependents <em>Runtime Cyclic Loadtime Dependents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Runtime Cyclic Loadtime Dependents</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getRuntimeCyclicLoadtimeDependents()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_RuntimeCyclicLoadtimeDependents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TModule#getInternalTypes <em>Internal Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Types</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getInternalTypes()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_InternalTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TModule#getExposedInternalTypes <em>Exposed Internal Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exposed Internal Types</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getExposedInternalTypes()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_ExposedInternalTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TModule#getInternalDynamicElements <em>Internal Dynamic Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Dynamic Elements</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getInternalDynamicElements()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_InternalDynamicElements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#getAstMD5 <em>Ast MD5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ast MD5</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getAstMD5()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_AstMD5();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TModule#getComposedMemberCaches <em>Composed Member Caches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composed Member Caches</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getComposedMemberCaches()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_ComposedMemberCaches();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TModule#getTemporaryTypes <em>Temporary Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Temporary Types</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getTemporaryTypes()
	 * @see #getTModule()
	 * @generated
	 */
	EReference getTModule_TemporaryTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TModule#getModuleSpecifier <em>Module Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Specifier</em>'.
	 * @see org.eclipse.n4js.ts.types.TModule#getModuleSpecifier()
	 * @see #getTModule()
	 * @generated
	 */
	EAttribute getTModule_ModuleSpecifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TModule#clearTransientElements() <em>Clear Transient Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clear Transient Elements</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TModule#clearTransientElements()
	 * @generated
	 */
	EOperation getTModule__ClearTransientElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.RuntimeDependency <em>Runtime Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Dependency</em>'.
	 * @see org.eclipse.n4js.ts.types.RuntimeDependency
	 * @generated
	 */
	EClass getRuntimeDependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.types.RuntimeDependency#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.n4js.ts.types.RuntimeDependency#getTarget()
	 * @see #getRuntimeDependency()
	 * @generated
	 */
	EReference getRuntimeDependency_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.RuntimeDependency#isLoadtimeForInheritance <em>Loadtime For Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loadtime For Inheritance</em>'.
	 * @see org.eclipse.n4js.ts.types.RuntimeDependency#isLoadtimeForInheritance()
	 * @see #getRuntimeDependency()
	 * @generated
	 */
	EAttribute getRuntimeDependency_LoadtimeForInheritance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.ComposedMemberCache <em>Composed Member Cache</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Member Cache</em>'.
	 * @see org.eclipse.n4js.ts.types.ComposedMemberCache
	 * @generated
	 */
	EClass getComposedMemberCache();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.ComposedMemberCache#getCachedComposedMembers <em>Cached Composed Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cached Composed Members</em>'.
	 * @see org.eclipse.n4js.ts.types.ComposedMemberCache#getCachedComposedMembers()
	 * @see #getComposedMemberCache()
	 * @generated
	 */
	EReference getComposedMemberCache_CachedComposedMembers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.ComposedMemberCache#getComposedTypeRef <em>Composed Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Composed Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.types.ComposedMemberCache#getComposedTypeRef()
	 * @see #getComposedMemberCache()
	 * @generated
	 */
	EReference getComposedMemberCache_ComposedTypeRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TypableElement <em>Typable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typable Element</em>'.
	 * @see org.eclipse.n4js.ts.types.TypableElement
	 * @generated
	 */
	EClass getTypableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Element</em>'.
	 * @see org.eclipse.n4js.ts.types.IdentifiableElement
	 * @generated
	 */
	EClass getIdentifiableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.IdentifiableElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.n4js.ts.types.IdentifiableElement#getName()
	 * @see #getIdentifiableElement()
	 * @generated
	 */
	EAttribute getIdentifiableElement_Name();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.IdentifiableElement#getContainingModule() <em>Get Containing Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Containing Module</em>' operation.
	 * @see org.eclipse.n4js.ts.types.IdentifiableElement#getContainingModule()
	 * @generated
	 */
	EOperation getIdentifiableElement__GetContainingModule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TExportingElement <em>TExporting Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExporting Element</em>'.
	 * @see org.eclipse.n4js.ts.types.TExportingElement
	 * @generated
	 */
	EClass getTExportingElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TExportingElement#getExportDefinitions <em>Export Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Export Definitions</em>'.
	 * @see org.eclipse.n4js.ts.types.TExportingElement#getExportDefinitions()
	 * @see #getTExportingElement()
	 * @generated
	 */
	EReference getTExportingElement_ExportDefinitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.ExportDefinition <em>Export Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Export Definition</em>'.
	 * @see org.eclipse.n4js.ts.types.ExportDefinition
	 * @generated
	 */
	EClass getExportDefinition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.ExportDefinition#getContainingModule() <em>Get Containing Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Containing Module</em>' operation.
	 * @see org.eclipse.n4js.ts.types.ExportDefinition#getContainingModule()
	 * @generated
	 */
	EOperation getExportDefinition__GetContainingModule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.ElementExportDefinition <em>Element Export Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Export Definition</em>'.
	 * @see org.eclipse.n4js.ts.types.ElementExportDefinition
	 * @generated
	 */
	EClass getElementExportDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.ElementExportDefinition#getExportedName <em>Exported Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exported Name</em>'.
	 * @see org.eclipse.n4js.ts.types.ElementExportDefinition#getExportedName()
	 * @see #getElementExportDefinition()
	 * @generated
	 */
	EAttribute getElementExportDefinition_ExportedName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.types.ElementExportDefinition#getExportedElement <em>Exported Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exported Element</em>'.
	 * @see org.eclipse.n4js.ts.types.ElementExportDefinition#getExportedElement()
	 * @see #getElementExportDefinition()
	 * @generated
	 */
	EReference getElementExportDefinition_ExportedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.ModuleExportDefinition <em>Module Export Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Export Definition</em>'.
	 * @see org.eclipse.n4js.ts.types.ModuleExportDefinition
	 * @generated
	 */
	EClass getModuleExportDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.types.ModuleExportDefinition#getExportedModule <em>Exported Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exported Module</em>'.
	 * @see org.eclipse.n4js.ts.types.ModuleExportDefinition#getExportedModule()
	 * @see #getModuleExportDefinition()
	 * @generated
	 */
	EReference getModuleExportDefinition_ExportedModule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TExportableElement <em>TExportable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExportable Element</em>'.
	 * @see org.eclipse.n4js.ts.types.TExportableElement
	 * @generated
	 */
	EClass getTExportableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TExportableElement#isDirectlyExported <em>Directly Exported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directly Exported</em>'.
	 * @see org.eclipse.n4js.ts.types.TExportableElement#isDirectlyExported()
	 * @see #getTExportableElement()
	 * @generated
	 */
	EAttribute getTExportableElement_DirectlyExported();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TExportableElement#isDirectlyExportedAsDefault <em>Directly Exported As Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directly Exported As Default</em>'.
	 * @see org.eclipse.n4js.ts.types.TExportableElement#isDirectlyExportedAsDefault()
	 * @see #getTExportableElement()
	 * @generated
	 */
	EAttribute getTExportableElement_DirectlyExportedAsDefault();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.n4js.ts.types.TExportableElement#getExportingExportDefinitions <em>Exporting Export Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exporting Export Definitions</em>'.
	 * @see org.eclipse.n4js.ts.types.TExportableElement#getExportingExportDefinitions()
	 * @see #getTExportableElement()
	 * @generated
	 */
	EReference getTExportableElement_ExportingExportDefinitions();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TExportableElement#isExported() <em>Is Exported</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Exported</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TExportableElement#isExported()
	 * @generated
	 */
	EOperation getTExportableElement__IsExported();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TExportableElement#isIndirectlyExported() <em>Is Indirectly Exported</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Indirectly Exported</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TExportableElement#isIndirectlyExported()
	 * @generated
	 */
	EOperation getTExportableElement__IsIndirectlyExported();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TExportableElement#getDirectlyExportedName() <em>Get Directly Exported Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Directly Exported Name</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TExportableElement#getDirectlyExportedName()
	 * @generated
	 */
	EOperation getTExportableElement__GetDirectlyExportedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TDynamicElement <em>TDynamic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDynamic Element</em>'.
	 * @see org.eclipse.n4js.ts.types.TDynamicElement
	 * @generated
	 */
	EClass getTDynamicElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TAnnotation <em>TAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TAnnotation</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotation
	 * @generated
	 */
	EClass getTAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TAnnotation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotation#getName()
	 * @see #getTAnnotation()
	 * @generated
	 */
	EAttribute getTAnnotation_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TAnnotation#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Args</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotation#getArgs()
	 * @see #getTAnnotation()
	 * @generated
	 */
	EReference getTAnnotation_Args();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TAnnotation#hasStringArgument(java.lang.String) <em>Has String Argument</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has String Argument</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TAnnotation#hasStringArgument(java.lang.String)
	 * @generated
	 */
	EOperation getTAnnotation__HasStringArgument__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TAnnotation#getAnnotationAsString() <em>Get Annotation As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Annotation As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TAnnotation#getAnnotationAsString()
	 * @generated
	 */
	EOperation getTAnnotation__GetAnnotationAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TAnnotationArgument <em>TAnnotation Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TAnnotation Argument</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotationArgument
	 * @generated
	 */
	EClass getTAnnotationArgument();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TAnnotationArgument#getArgAsString() <em>Get Arg As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Arg As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TAnnotationArgument#getArgAsString()
	 * @generated
	 */
	EOperation getTAnnotationArgument__GetArgAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TAnnotationStringArgument <em>TAnnotation String Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TAnnotation String Argument</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotationStringArgument
	 * @generated
	 */
	EClass getTAnnotationStringArgument();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TAnnotationStringArgument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotationStringArgument#getValue()
	 * @see #getTAnnotationStringArgument()
	 * @generated
	 */
	EAttribute getTAnnotationStringArgument_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TAnnotationStringArgument#getArgAsString() <em>Get Arg As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Arg As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TAnnotationStringArgument#getArgAsString()
	 * @generated
	 */
	EOperation getTAnnotationStringArgument__GetArgAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TTypedElement <em>TTyped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTyped Element</em>'.
	 * @see org.eclipse.n4js.ts.types.TTypedElement
	 * @generated
	 */
	EClass getTTypedElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.TTypedElement#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.types.TTypedElement#getTypeRef()
	 * @see #getTTypedElement()
	 * @generated
	 */
	EReference getTTypedElement_TypeRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TAnnotationTypeRefArgument <em>TAnnotation Type Ref Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TAnnotation Type Ref Argument</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotationTypeRefArgument
	 * @generated
	 */
	EClass getTAnnotationTypeRefArgument();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TAnnotationTypeRefArgument#getArgAsString() <em>Get Arg As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Arg As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TAnnotationTypeRefArgument#getArgAsString()
	 * @generated
	 */
	EOperation getTAnnotationTypeRefArgument__GetArgAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TAnnotableElement <em>TAnnotable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TAnnotable Element</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotableElement
	 * @generated
	 */
	EClass getTAnnotableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TAnnotableElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnnotableElement#getAnnotations()
	 * @see #getTAnnotableElement()
	 * @generated
	 */
	EReference getTAnnotableElement_Annotations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TypeVariable <em>Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Variable</em>'.
	 * @see org.eclipse.n4js.ts.types.TypeVariable
	 * @generated
	 */
	EClass getTypeVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TypeVariable#isDeclaredCovariant <em>Declared Covariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Covariant</em>'.
	 * @see org.eclipse.n4js.ts.types.TypeVariable#isDeclaredCovariant()
	 * @see #getTypeVariable()
	 * @generated
	 */
	EAttribute getTypeVariable_DeclaredCovariant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TypeVariable#isDeclaredContravariant <em>Declared Contravariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Contravariant</em>'.
	 * @see org.eclipse.n4js.ts.types.TypeVariable#isDeclaredContravariant()
	 * @see #getTypeVariable()
	 * @generated
	 */
	EAttribute getTypeVariable_DeclaredContravariant();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.TypeVariable#getDeclaredUpperBound <em>Declared Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Upper Bound</em>'.
	 * @see org.eclipse.n4js.ts.types.TypeVariable#getDeclaredUpperBound()
	 * @see #getTypeVariable()
	 * @generated
	 */
	EReference getTypeVariable_DeclaredUpperBound();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.TypeVariable#getDefaultArgument <em>Default Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Argument</em>'.
	 * @see org.eclipse.n4js.ts.types.TypeVariable#getDefaultArgument()
	 * @see #getTypeVariable()
	 * @generated
	 */
	EReference getTypeVariable_DefaultArgument();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TypeVariable#getVariance() <em>Get Variance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Variance</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TypeVariable#getVariance()
	 * @generated
	 */
	EOperation getTypeVariable__GetVariance();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TypeVariable#isOptional() <em>Is Optional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Optional</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TypeVariable#isOptional()
	 * @generated
	 */
	EOperation getTypeVariable__IsOptional();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TypeVariable#getTypeAsString() <em>Get Type As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TypeVariable#getTypeAsString()
	 * @generated
	 */
	EOperation getTypeVariable__GetTypeAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TypeVariable#getTypeVariableAsString(org.eclipse.n4js.ts.typeRefs.TypeRef) <em>Get Type Variable As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Variable As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TypeVariable#getTypeVariableAsString(org.eclipse.n4js.ts.typeRefs.TypeRef)
	 * @generated
	 */
	EOperation getTypeVariable__GetTypeVariableAsString__TypeRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.InferenceVariable <em>Inference Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inference Variable</em>'.
	 * @see org.eclipse.n4js.ts.types.InferenceVariable
	 * @generated
	 */
	EClass getInferenceVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TFunction <em>TFunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFunction</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction
	 * @generated
	 */
	EClass getTFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TFunction#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction#isExternal()
	 * @see #getTFunction()
	 * @generated
	 */
	EAttribute getTFunction_External();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TFunction#getFpars <em>Fpars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fpars</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction#getFpars()
	 * @see #getTFunction()
	 * @generated
	 */
	EReference getTFunction_Fpars();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TFunction#isReturnValueMarkedOptional <em>Return Value Marked Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Value Marked Optional</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction#isReturnValueMarkedOptional()
	 * @see #getTFunction()
	 * @generated
	 */
	EAttribute getTFunction_ReturnValueMarkedOptional();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.TFunction#getReturnTypeRef <em>Return Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction#getReturnTypeRef()
	 * @see #getTFunction()
	 * @generated
	 */
	EReference getTFunction_ReturnTypeRef();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.TFunction#getDeclaredThisType <em>Declared This Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared This Type</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction#getDeclaredThisType()
	 * @see #getTFunction()
	 * @generated
	 */
	EReference getTFunction_DeclaredThisType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TFunction#isDeclaredAsync <em>Declared Async</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Async</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction#isDeclaredAsync()
	 * @see #getTFunction()
	 * @generated
	 */
	EAttribute getTFunction_DeclaredAsync();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TFunction#isDeclaredGenerator <em>Declared Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Generator</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction#isDeclaredGenerator()
	 * @see #getTFunction()
	 * @generated
	 */
	EAttribute getTFunction_DeclaredGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TFunction#isConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constructor</em>'.
	 * @see org.eclipse.n4js.ts.types.TFunction#isConstructor()
	 * @see #getTFunction()
	 * @generated
	 */
	EAttribute getTFunction_Constructor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFunction#isReturnValueOptional() <em>Is Return Value Optional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Return Value Optional</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFunction#isReturnValueOptional()
	 * @generated
	 */
	EOperation getTFunction__IsReturnValueOptional();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFunction#isCallSignature() <em>Is Call Signature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Call Signature</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFunction#isCallSignature()
	 * @generated
	 */
	EOperation getTFunction__IsCallSignature();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFunction#isConstructSignature() <em>Is Construct Signature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Construct Signature</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFunction#isConstructSignature()
	 * @generated
	 */
	EOperation getTFunction__IsConstructSignature();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFunction#getFparForArgIdx(int) <em>Get Fpar For Arg Idx</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Fpar For Arg Idx</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFunction#getFparForArgIdx(int)
	 * @generated
	 */
	EOperation getTFunction__GetFparForArgIdx__int();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFunction#getFunctionAsString() <em>Get Function As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Function As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFunction#getFunctionAsString()
	 * @generated
	 */
	EOperation getTFunction__GetFunctionAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFunction#isFinal() <em>Is Final</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Final</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFunction#isFinal()
	 * @generated
	 */
	EOperation getTFunction__IsFinal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.n4js.ts.types.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#isAlias() <em>Is Alias</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Alias</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#isAlias()
	 * @generated
	 */
	EOperation getType__IsAlias();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#isProvidedByRuntime() <em>Is Provided By Runtime</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Provided By Runtime</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#isProvidedByRuntime()
	 * @generated
	 */
	EOperation getType__IsProvidedByRuntime();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#isPolyfill() <em>Is Polyfill</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Polyfill</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#isPolyfill()
	 * @generated
	 */
	EOperation getType__IsPolyfill();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#isStaticPolyfill() <em>Is Static Polyfill</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Static Polyfill</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#isStaticPolyfill()
	 * @generated
	 */
	EOperation getType__IsStaticPolyfill();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#isFinal() <em>Is Final</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Final</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#isFinal()
	 * @generated
	 */
	EOperation getType__IsFinal();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#isDynamizable() <em>Is Dynamizable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Dynamizable</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#isDynamizable()
	 * @generated
	 */
	EOperation getType__IsDynamizable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#isArrayLike() <em>Is Array Like</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Array Like</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#isArrayLike()
	 * @generated
	 */
	EOperation getType__IsArrayLike();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#getElementType() <em>Get Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Element Type</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#getElementType()
	 * @generated
	 */
	EOperation getType__GetElementType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#getTypeAccessModifier() <em>Get Type Access Modifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Access Modifier</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#getTypeAccessModifier()
	 * @generated
	 */
	EOperation getType__GetTypeAccessModifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#isGeneric() <em>Is Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Generic</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#isGeneric()
	 * @generated
	 */
	EOperation getType__IsGeneric();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#getTypeVars() <em>Get Type Vars</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Vars</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#getTypeVars()
	 * @generated
	 */
	EOperation getType__GetTypeVars();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#getVarianceOfTypeVar(int) <em>Get Variance Of Type Var</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Variance Of Type Var</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#getVarianceOfTypeVar(int)
	 * @generated
	 */
	EOperation getType__GetVarianceOfTypeVar__int();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#getRawTypeAsString() <em>Get Raw Type As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Raw Type As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#getRawTypeAsString()
	 * @generated
	 */
	EOperation getType__GetRawTypeAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.Type#getTypeAsString() <em>Get Type As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.Type#getTypeAsString()
	 * @generated
	 */
	EOperation getType__GetTypeAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.GenericType <em>Generic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Type</em>'.
	 * @see org.eclipse.n4js.ts.types.GenericType
	 * @generated
	 */
	EClass getGenericType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.GenericType#getTypeVars <em>Type Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Vars</em>'.
	 * @see org.eclipse.n4js.ts.types.GenericType#getTypeVars()
	 * @see #getGenericType()
	 * @generated
	 */
	EReference getGenericType_TypeVars();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.AccessibleTypeElement <em>Accessible Type Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Accessible Type Element</em>'.
	 * @see org.eclipse.n4js.ts.types.AccessibleTypeElement
	 * @generated
	 */
	EClass getAccessibleTypeElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.AccessibleTypeElement#getDeclaredTypeAccessModifier <em>Declared Type Access Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Type Access Modifier</em>'.
	 * @see org.eclipse.n4js.ts.types.AccessibleTypeElement#getDeclaredTypeAccessModifier()
	 * @see #getAccessibleTypeElement()
	 * @generated
	 */
	EAttribute getAccessibleTypeElement_DeclaredTypeAccessModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.AccessibleTypeElement#isDeclaredProvidedByRuntime <em>Declared Provided By Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Provided By Runtime</em>'.
	 * @see org.eclipse.n4js.ts.types.AccessibleTypeElement#isDeclaredProvidedByRuntime()
	 * @see #getAccessibleTypeElement()
	 * @generated
	 */
	EAttribute getAccessibleTypeElement_DeclaredProvidedByRuntime();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AccessibleTypeElement#isProvidedByRuntime() <em>Is Provided By Runtime</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Provided By Runtime</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AccessibleTypeElement#isProvidedByRuntime()
	 * @generated
	 */
	EOperation getAccessibleTypeElement__IsProvidedByRuntime();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AccessibleTypeElement#getTypeAccessModifier() <em>Get Type Access Modifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Access Modifier</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AccessibleTypeElement#getTypeAccessModifier()
	 * @generated
	 */
	EOperation getAccessibleTypeElement__GetTypeAccessModifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AccessibleTypeElement#getDefaultTypeAccessModifier() <em>Get Default Type Access Modifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Default Type Access Modifier</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AccessibleTypeElement#getDefaultTypeAccessModifier()
	 * @generated
	 */
	EOperation getAccessibleTypeElement__GetDefaultTypeAccessModifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AccessibleTypeElement#isDirectlyExported() <em>Is Directly Exported</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Directly Exported</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AccessibleTypeElement#isDirectlyExported()
	 * @generated
	 */
	EOperation getAccessibleTypeElement__IsDirectlyExported();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.ContainerType <em>Container Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Type</em>'.
	 * @see org.eclipse.n4js.ts.types.ContainerType
	 * @generated
	 */
	EClass getContainerType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.ContainerType#getOwnedMembersByNameAndAccess <em>Owned Members By Name And Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owned Members By Name And Access</em>'.
	 * @see org.eclipse.n4js.ts.types.ContainerType#getOwnedMembersByNameAndAccess()
	 * @see #getContainerType()
	 * @generated
	 */
	EAttribute getContainerType_OwnedMembersByNameAndAccess();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.ContainerType#getOwnedMembers <em>Owned Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Members</em>'.
	 * @see org.eclipse.n4js.ts.types.ContainerType#getOwnedMembers()
	 * @see #getContainerType()
	 * @generated
	 */
	EReference getContainerType_OwnedMembers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.ContainerType#getCallSignature <em>Call Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Signature</em>'.
	 * @see org.eclipse.n4js.ts.types.ContainerType#getCallSignature()
	 * @see #getContainerType()
	 * @generated
	 */
	EReference getContainerType_CallSignature();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.ContainerType#getConstructSignature <em>Construct Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Construct Signature</em>'.
	 * @see org.eclipse.n4js.ts.types.ContainerType#getConstructSignature()
	 * @see #getContainerType()
	 * @generated
	 */
	EReference getContainerType_ConstructSignature();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.ContainerType#getOwnedCtor() <em>Get Owned Ctor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Owned Ctor</em>' operation.
	 * @see org.eclipse.n4js.ts.types.ContainerType#getOwnedCtor()
	 * @generated
	 */
	EOperation getContainerType__GetOwnedCtor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.ContainerType#findOwnedMember(java.lang.String) <em>Find Owned Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Owned Member</em>' operation.
	 * @see org.eclipse.n4js.ts.types.ContainerType#findOwnedMember(java.lang.String)
	 * @generated
	 */
	EOperation getContainerType__FindOwnedMember__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.ContainerType#findOwnedMember(java.lang.String, boolean, boolean) <em>Find Owned Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Owned Member</em>' operation.
	 * @see org.eclipse.n4js.ts.types.ContainerType#findOwnedMember(java.lang.String, boolean, boolean)
	 * @generated
	 */
	EOperation getContainerType__FindOwnedMember__String_boolean_boolean();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.ContainerType#getOrCreateOwnedMembersByNameAndAccess() <em>Get Or Create Owned Members By Name And Access</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Or Create Owned Members By Name And Access</em>' operation.
	 * @see org.eclipse.n4js.ts.types.ContainerType#getOrCreateOwnedMembersByNameAndAccess()
	 * @generated
	 */
	EOperation getContainerType__GetOrCreateOwnedMembersByNameAndAccess();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.AbstractNamespace <em>Abstract Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Namespace</em>'.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace
	 * @generated
	 */
	EClass getAbstractNamespace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getTypes()
	 * @see #getAbstractNamespace()
	 * @generated
	 */
	EReference getAbstractNamespace_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getFunctions()
	 * @see #getAbstractNamespace()
	 * @generated
	 */
	EReference getAbstractNamespace_Functions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getExportedVariables <em>Exported Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exported Variables</em>'.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getExportedVariables()
	 * @see #getAbstractNamespace()
	 * @generated
	 */
	EReference getAbstractNamespace_ExportedVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getLocalVariables <em>Local Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Variables</em>'.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getLocalVariables()
	 * @see #getAbstractNamespace()
	 * @generated
	 */
	EReference getAbstractNamespace_LocalVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getExposedLocalVariables <em>Exposed Local Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exposed Local Variables</em>'.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getExposedLocalVariables()
	 * @see #getAbstractNamespace()
	 * @generated
	 */
	EReference getAbstractNamespace_ExposedLocalVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getNamespaces <em>Namespaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Namespaces</em>'.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getNamespaces()
	 * @see #getAbstractNamespace()
	 * @generated
	 */
	EReference getAbstractNamespace_Namespaces();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getTypesAndFunctions() <em>Get Types And Functions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Types And Functions</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getTypesAndFunctions()
	 * @generated
	 */
	EOperation getAbstractNamespace__GetTypesAndFunctions();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getExportableElements() <em>Get Exportable Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Exportable Elements</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getExportableElements()
	 * @generated
	 */
	EOperation getAbstractNamespace__GetExportableElements();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getAllNamespaces() <em>Get All Namespaces</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Namespaces</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getAllNamespaces()
	 * @generated
	 */
	EOperation getAbstractNamespace__GetAllNamespaces();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AbstractNamespace#getContainingModule() <em>Get Containing Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Containing Module</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#getContainingModule()
	 * @generated
	 */
	EOperation getAbstractNamespace__GetContainingModule();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AbstractNamespace#clearTransientElements() <em>Clear Transient Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clear Transient Elements</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AbstractNamespace#clearTransientElements()
	 * @generated
	 */
	EOperation getAbstractNamespace__ClearTransientElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TNamespace <em>TNamespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TNamespace</em>'.
	 * @see org.eclipse.n4js.ts.types.TNamespace
	 * @generated
	 */
	EClass getTNamespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TNamespace#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see org.eclipse.n4js.ts.types.TNamespace#isExternal()
	 * @see #getTNamespace()
	 * @generated
	 */
	EAttribute getTNamespace_External();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TNamespaceElement <em>TNamespace Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TNamespace Element</em>'.
	 * @see org.eclipse.n4js.ts.types.TNamespaceElement
	 * @generated
	 */
	EClass getTNamespaceElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TNamespaceElement#isHollow() <em>Is Hollow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Hollow</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TNamespaceElement#isHollow()
	 * @generated
	 */
	EOperation getTNamespaceElement__IsHollow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType <em>Module Namespace Virtual Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Namespace Virtual Type</em>'.
	 * @see org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType
	 * @generated
	 */
	EClass getModuleNamespaceVirtualType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Module</em>'.
	 * @see org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType#getModule()
	 * @see #getModuleNamespaceVirtualType()
	 * @generated
	 */
	EReference getModuleNamespaceVirtualType_Module();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType#isDeclaredDynamic <em>Declared Dynamic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Dynamic</em>'.
	 * @see org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType#isDeclaredDynamic()
	 * @see #getModuleNamespaceVirtualType()
	 * @generated
	 */
	EAttribute getModuleNamespaceVirtualType_DeclaredDynamic();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType#isProvidedByRuntime() <em>Is Provided By Runtime</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Provided By Runtime</em>' operation.
	 * @see org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType#isProvidedByRuntime()
	 * @generated
	 */
	EOperation getModuleNamespaceVirtualType__IsProvidedByRuntime();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.n4js.ts.types.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.types.PrimitiveType#getAssignmentCompatible <em>Assignment Compatible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assignment Compatible</em>'.
	 * @see org.eclipse.n4js.ts.types.PrimitiveType#getAssignmentCompatible()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EReference getPrimitiveType_AssignmentCompatible();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.types.PrimitiveType#getAutoboxedType <em>Autoboxed Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Autoboxed Type</em>'.
	 * @see org.eclipse.n4js.ts.types.PrimitiveType#getAutoboxedType()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EReference getPrimitiveType_AutoboxedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.BuiltInType <em>Built In Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Built In Type</em>'.
	 * @see org.eclipse.n4js.ts.types.BuiltInType
	 * @generated
	 */
	EClass getBuiltInType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Type</em>'.
	 * @see org.eclipse.n4js.ts.types.AnyType
	 * @generated
	 */
	EClass getAnyType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.AnyType#isFinal() <em>Is Final</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Final</em>' operation.
	 * @see org.eclipse.n4js.ts.types.AnyType#isFinal()
	 * @generated
	 */
	EOperation getAnyType__IsFinal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.UndefinedType <em>Undefined Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Undefined Type</em>'.
	 * @see org.eclipse.n4js.ts.types.UndefinedType
	 * @generated
	 */
	EClass getUndefinedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.NullType <em>Null Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Type</em>'.
	 * @see org.eclipse.n4js.ts.types.NullType
	 * @generated
	 */
	EClass getNullType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see org.eclipse.n4js.ts.types.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TStructuralType <em>TStructural Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TStructural Type</em>'.
	 * @see org.eclipse.n4js.ts.types.TStructuralType
	 * @generated
	 */
	EClass getTStructuralType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TStructuralType#isFinal() <em>Is Final</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Final</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TStructuralType#isFinal()
	 * @generated
	 */
	EOperation getTStructuralType__IsFinal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TClassifier <em>TClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TClassifier</em>'.
	 * @see org.eclipse.n4js.ts.types.TClassifier
	 * @generated
	 */
	EClass getTClassifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TClassifier#isDeclaredCovariantConstructor <em>Declared Covariant Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Covariant Constructor</em>'.
	 * @see org.eclipse.n4js.ts.types.TClassifier#isDeclaredCovariantConstructor()
	 * @see #getTClassifier()
	 * @generated
	 */
	EAttribute getTClassifier_DeclaredCovariantConstructor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClassifier#isAbstract() <em>Is Abstract</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Abstract</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClassifier#isAbstract()
	 * @generated
	 */
	EOperation getTClassifier__IsAbstract();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClassifier#getSuperClassifiers() <em>Get Super Classifiers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Super Classifiers</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClassifier#getSuperClassifiers()
	 * @generated
	 */
	EOperation getTClassifier__GetSuperClassifiers();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClassifier#getSuperClassifierRefs() <em>Get Super Classifier Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Super Classifier Refs</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClassifier#getSuperClassifierRefs()
	 * @generated
	 */
	EOperation getTClassifier__GetSuperClassifierRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClassifier#getImplementedOrExtendedInterfaceRefs() <em>Get Implemented Or Extended Interface Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Implemented Or Extended Interface Refs</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClassifier#getImplementedOrExtendedInterfaceRefs()
	 * @generated
	 */
	EOperation getTClassifier__GetImplementedOrExtendedInterfaceRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClassifier#isFinal() <em>Is Final</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Final</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClassifier#isFinal()
	 * @generated
	 */
	EOperation getTClassifier__IsFinal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.ArrayLike <em>Array Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Like</em>'.
	 * @see org.eclipse.n4js.ts.types.ArrayLike
	 * @generated
	 */
	EClass getArrayLike();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.ArrayLike#getDeclaredElementType <em>Declared Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Element Type</em>'.
	 * @see org.eclipse.n4js.ts.types.ArrayLike#getDeclaredElementType()
	 * @see #getArrayLike()
	 * @generated
	 */
	EReference getArrayLike_DeclaredElementType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.ArrayLike#getElementType() <em>Get Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Element Type</em>' operation.
	 * @see org.eclipse.n4js.ts.types.ArrayLike#getElementType()
	 * @generated
	 */
	EOperation getArrayLike__GetElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TN4Classifier <em>TN4 Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TN4 Classifier</em>'.
	 * @see org.eclipse.n4js.ts.types.TN4Classifier
	 * @generated
	 */
	EClass getTN4Classifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TN4Classifier#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see org.eclipse.n4js.ts.types.TN4Classifier#isExternal()
	 * @see #getTN4Classifier()
	 * @generated
	 */
	EAttribute getTN4Classifier_External();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TN4Classifier#isDeclaredNonStaticPolyfill <em>Declared Non Static Polyfill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Non Static Polyfill</em>'.
	 * @see org.eclipse.n4js.ts.types.TN4Classifier#isDeclaredNonStaticPolyfill()
	 * @see #getTN4Classifier()
	 * @generated
	 */
	EAttribute getTN4Classifier_DeclaredNonStaticPolyfill();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TN4Classifier#isDynamizable <em>Dynamizable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamizable</em>'.
	 * @see org.eclipse.n4js.ts.types.TN4Classifier#isDynamizable()
	 * @see #getTN4Classifier()
	 * @generated
	 */
	EAttribute getTN4Classifier_Dynamizable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TN4Classifier#isPolyfill() <em>Is Polyfill</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Polyfill</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TN4Classifier#isPolyfill()
	 * @generated
	 */
	EOperation getTN4Classifier__IsPolyfill();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TN4Classifier#getTypingStrategy() <em>Get Typing Strategy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typing Strategy</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TN4Classifier#getTypingStrategy()
	 * @generated
	 */
	EOperation getTN4Classifier__GetTypingStrategy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TClass <em>TClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TClass</em>'.
	 * @see org.eclipse.n4js.ts.types.TClass
	 * @generated
	 */
	EClass getTClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TClass#isDeclaredAbstract <em>Declared Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Abstract</em>'.
	 * @see org.eclipse.n4js.ts.types.TClass#isDeclaredAbstract()
	 * @see #getTClass()
	 * @generated
	 */
	EAttribute getTClass_DeclaredAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TClass#isDeclaredEcmaScript <em>Declared Ecma Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Ecma Script</em>'.
	 * @see org.eclipse.n4js.ts.types.TClass#isDeclaredEcmaScript()
	 * @see #getTClass()
	 * @generated
	 */
	EAttribute getTClass_DeclaredEcmaScript();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TClass#isDeclaredFinal <em>Declared Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Final</em>'.
	 * @see org.eclipse.n4js.ts.types.TClass#isDeclaredFinal()
	 * @see #getTClass()
	 * @generated
	 */
	EAttribute getTClass_DeclaredFinal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TClass#isDeclaredStaticPolyfill <em>Declared Static Polyfill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Static Polyfill</em>'.
	 * @see org.eclipse.n4js.ts.types.TClass#isDeclaredStaticPolyfill()
	 * @see #getTClass()
	 * @generated
	 */
	EAttribute getTClass_DeclaredStaticPolyfill();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TClass#isObservable <em>Observable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Observable</em>'.
	 * @see org.eclipse.n4js.ts.types.TClass#isObservable()
	 * @see #getTClass()
	 * @generated
	 */
	EAttribute getTClass_Observable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.TClass#getSuperClassRef <em>Super Class Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super Class Ref</em>'.
	 * @see org.eclipse.n4js.ts.types.TClass#getSuperClassRef()
	 * @see #getTClass()
	 * @generated
	 */
	EReference getTClass_SuperClassRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TClass#getImplementedInterfaceRefs <em>Implemented Interface Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implemented Interface Refs</em>'.
	 * @see org.eclipse.n4js.ts.types.TClass#getImplementedInterfaceRefs()
	 * @see #getTClass()
	 * @generated
	 */
	EReference getTClass_ImplementedInterfaceRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClass#isAbstract() <em>Is Abstract</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Abstract</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClass#isAbstract()
	 * @generated
	 */
	EOperation getTClass__IsAbstract();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClass#getSuperClass() <em>Get Super Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Super Class</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClass#getSuperClass()
	 * @generated
	 */
	EOperation getTClass__GetSuperClass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClass#getSuperClassifierRefs() <em>Get Super Classifier Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Super Classifier Refs</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClass#getSuperClassifierRefs()
	 * @generated
	 */
	EOperation getTClass__GetSuperClassifierRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClass#getImplementedOrExtendedInterfaceRefs() <em>Get Implemented Or Extended Interface Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Implemented Or Extended Interface Refs</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClass#getImplementedOrExtendedInterfaceRefs()
	 * @generated
	 */
	EOperation getTClass__GetImplementedOrExtendedInterfaceRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClass#isPolyfill() <em>Is Polyfill</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Polyfill</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClass#isPolyfill()
	 * @generated
	 */
	EOperation getTClass__IsPolyfill();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClass#isStaticPolyfill() <em>Is Static Polyfill</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Static Polyfill</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClass#isStaticPolyfill()
	 * @generated
	 */
	EOperation getTClass__IsStaticPolyfill();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TClass#isFinal() <em>Is Final</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Final</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TClass#isFinal()
	 * @generated
	 */
	EOperation getTClass__IsFinal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TInterface <em>TInterface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TInterface</em>'.
	 * @see org.eclipse.n4js.ts.types.TInterface
	 * @generated
	 */
	EClass getTInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TInterface#getSuperInterfaceRefs <em>Super Interface Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Interface Refs</em>'.
	 * @see org.eclipse.n4js.ts.types.TInterface#getSuperInterfaceRefs()
	 * @see #getTInterface()
	 * @generated
	 */
	EReference getTInterface_SuperInterfaceRefs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TInterface#getTypingStrategy <em>Typing Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typing Strategy</em>'.
	 * @see org.eclipse.n4js.ts.types.TInterface#getTypingStrategy()
	 * @see #getTInterface()
	 * @generated
	 */
	EAttribute getTInterface_TypingStrategy();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TInterface#isAbstract() <em>Is Abstract</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Abstract</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TInterface#isAbstract()
	 * @generated
	 */
	EOperation getTInterface__IsAbstract();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TInterface#getSuperClassifierRefs() <em>Get Super Classifier Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Super Classifier Refs</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TInterface#getSuperClassifierRefs()
	 * @generated
	 */
	EOperation getTInterface__GetSuperClassifierRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TInterface#getImplementedOrExtendedInterfaceRefs() <em>Get Implemented Or Extended Interface Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Implemented Or Extended Interface Refs</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TInterface#getImplementedOrExtendedInterfaceRefs()
	 * @generated
	 */
	EOperation getTInterface__GetImplementedOrExtendedInterfaceRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TInterface#isHollow() <em>Is Hollow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Hollow</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TInterface#isHollow()
	 * @generated
	 */
	EOperation getTInterface__IsHollow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TMember <em>TMember</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TMember</em>'.
	 * @see org.eclipse.n4js.ts.types.TMember
	 * @generated
	 */
	EClass getTMember();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMember#isDeclaredFinal <em>Declared Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Final</em>'.
	 * @see org.eclipse.n4js.ts.types.TMember#isDeclaredFinal()
	 * @see #getTMember()
	 * @generated
	 */
	EAttribute getTMember_DeclaredFinal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMember#isDeclaredStatic <em>Declared Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Static</em>'.
	 * @see org.eclipse.n4js.ts.types.TMember#isDeclaredStatic()
	 * @see #getTMember()
	 * @generated
	 */
	EAttribute getTMember_DeclaredStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMember#isDeclaredOverride <em>Declared Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Override</em>'.
	 * @see org.eclipse.n4js.ts.types.TMember#isDeclaredOverride()
	 * @see #getTMember()
	 * @generated
	 */
	EAttribute getTMember_DeclaredOverride();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMember#isHasComputedName <em>Has Computed Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Computed Name</em>'.
	 * @see org.eclipse.n4js.ts.types.TMember#isHasComputedName()
	 * @see #getTMember()
	 * @generated
	 */
	EAttribute getTMember_HasComputedName();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.n4js.ts.types.TMember#getConstituentMembers <em>Constituent Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constituent Members</em>'.
	 * @see org.eclipse.n4js.ts.types.TMember#getConstituentMembers()
	 * @see #getTMember()
	 * @generated
	 */
	EReference getTMember_ConstituentMembers();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMember#isComposed <em>Composed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composed</em>'.
	 * @see org.eclipse.n4js.ts.types.TMember#isComposed()
	 * @see #getTMember()
	 * @generated
	 */
	EAttribute getTMember_Composed();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#getContainingType() <em>Get Containing Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Containing Type</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#getContainingType()
	 * @generated
	 */
	EOperation getTMember__GetContainingType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#getMemberAccessModifier() <em>Get Member Access Modifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member Access Modifier</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#getMemberAccessModifier()
	 * @generated
	 */
	EOperation getTMember__GetMemberAccessModifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#getMemberType() <em>Get Member Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member Type</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#getMemberType()
	 * @generated
	 */
	EOperation getTMember__GetMemberType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isField() <em>Is Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Field</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isField()
	 * @generated
	 */
	EOperation getTMember__IsField();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isGetter() <em>Is Getter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Getter</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isGetter()
	 * @generated
	 */
	EOperation getTMember__IsGetter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isSetter() <em>Is Setter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Setter</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isSetter()
	 * @generated
	 */
	EOperation getTMember__IsSetter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isAccessor() <em>Is Accessor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Accessor</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isAccessor()
	 * @generated
	 */
	EOperation getTMember__IsAccessor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isMethod() <em>Is Method</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Method</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isMethod()
	 * @generated
	 */
	EOperation getTMember__IsMethod();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isConstructor() <em>Is Constructor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Constructor</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isConstructor()
	 * @generated
	 */
	EOperation getTMember__IsConstructor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isOptional() <em>Is Optional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Optional</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isOptional()
	 * @generated
	 */
	EOperation getTMember__IsOptional();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isAbstract() <em>Is Abstract</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Abstract</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isAbstract()
	 * @generated
	 */
	EOperation getTMember__IsAbstract();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isReadable() <em>Is Readable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Readable</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isReadable()
	 * @generated
	 */
	EOperation getTMember__IsReadable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isWriteable() <em>Is Writeable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Writeable</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isWriteable()
	 * @generated
	 */
	EOperation getTMember__IsWriteable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#getMemberAsString() <em>Get Member As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#getMemberAsString()
	 * @generated
	 */
	EOperation getTMember__GetMemberAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isFinal() <em>Is Final</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Final</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isFinal()
	 * @generated
	 */
	EOperation getTMember__IsFinal();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isStatic() <em>Is Static</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Static</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isStatic()
	 * @generated
	 */
	EOperation getTMember__IsStatic();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isConst() <em>Is Const</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Const</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isConst()
	 * @generated
	 */
	EOperation getTMember__IsConst();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMember#isPolyfilled() <em>Is Polyfilled</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Polyfilled</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMember#isPolyfilled()
	 * @generated
	 */
	EOperation getTMember__IsPolyfilled();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TMemberWithAccessModifier <em>TMember With Access Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TMember With Access Modifier</em>'.
	 * @see org.eclipse.n4js.ts.types.TMemberWithAccessModifier
	 * @generated
	 */
	EClass getTMemberWithAccessModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMemberWithAccessModifier#isHasNoBody <em>Has No Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has No Body</em>'.
	 * @see org.eclipse.n4js.ts.types.TMemberWithAccessModifier#isHasNoBody()
	 * @see #getTMemberWithAccessModifier()
	 * @generated
	 */
	EAttribute getTMemberWithAccessModifier_HasNoBody();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMemberWithAccessModifier#getDeclaredMemberAccessModifier <em>Declared Member Access Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Member Access Modifier</em>'.
	 * @see org.eclipse.n4js.ts.types.TMemberWithAccessModifier#getDeclaredMemberAccessModifier()
	 * @see #getTMemberWithAccessModifier()
	 * @generated
	 */
	EAttribute getTMemberWithAccessModifier_DeclaredMemberAccessModifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMemberWithAccessModifier#getMemberAccessModifier() <em>Get Member Access Modifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member Access Modifier</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMemberWithAccessModifier#getMemberAccessModifier()
	 * @generated
	 */
	EOperation getTMemberWithAccessModifier__GetMemberAccessModifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMemberWithAccessModifier#getDefaultMemberAccessModifier() <em>Get Default Member Access Modifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Default Member Access Modifier</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMemberWithAccessModifier#getDefaultMemberAccessModifier()
	 * @generated
	 */
	EOperation getTMemberWithAccessModifier__GetDefaultMemberAccessModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TStructMember <em>TStruct Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TStruct Member</em>'.
	 * @see org.eclipse.n4js.ts.types.TStructMember
	 * @generated
	 */
	EClass getTStructMember();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.types.TStructMember#getDefinedMember <em>Defined Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Defined Member</em>'.
	 * @see org.eclipse.n4js.ts.types.TStructMember#getDefinedMember()
	 * @see #getTStructMember()
	 * @generated
	 */
	EReference getTStructMember_DefinedMember();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TStructMember#getDefaultMemberAccessModifier() <em>Get Default Member Access Modifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Default Member Access Modifier</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TStructMember#getDefaultMemberAccessModifier()
	 * @generated
	 */
	EOperation getTStructMember__GetDefaultMemberAccessModifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TStructMember#isStatic() <em>Is Static</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Static</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TStructMember#isStatic()
	 * @generated
	 */
	EOperation getTStructMember__IsStatic();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TStructMember#getMemberAccessModifier() <em>Get Member Access Modifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member Access Modifier</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TStructMember#getMemberAccessModifier()
	 * @generated
	 */
	EOperation getTStructMember__GetMemberAccessModifier();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TStructMember#isASTCallSignature() <em>Is AST Call Signature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is AST Call Signature</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TStructMember#isASTCallSignature()
	 * @generated
	 */
	EOperation getTStructMember__IsASTCallSignature();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TStructMember#isASTConstructSignature() <em>Is AST Construct Signature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is AST Construct Signature</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TStructMember#isASTConstructSignature()
	 * @generated
	 */
	EOperation getTStructMember__IsASTConstructSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TMethod <em>TMethod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TMethod</em>'.
	 * @see org.eclipse.n4js.ts.types.TMethod
	 * @generated
	 */
	EClass getTMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMethod#isDeclaredAbstract <em>Declared Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Abstract</em>'.
	 * @see org.eclipse.n4js.ts.types.TMethod#isDeclaredAbstract()
	 * @see #getTMethod()
	 * @generated
	 */
	EAttribute getTMethod_DeclaredAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TMethod#isLacksThisOrSuperUsage <em>Lacks This Or Super Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lacks This Or Super Usage</em>'.
	 * @see org.eclipse.n4js.ts.types.TMethod#isLacksThisOrSuperUsage()
	 * @see #getTMethod()
	 * @generated
	 */
	EAttribute getTMethod_LacksThisOrSuperUsage();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMethod#isAbstract() <em>Is Abstract</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Abstract</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMethod#isAbstract()
	 * @generated
	 */
	EOperation getTMethod__IsAbstract();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMethod#getMemberType() <em>Get Member Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member Type</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMethod#getMemberType()
	 * @generated
	 */
	EOperation getTMethod__GetMemberType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMethod#isConstructor() <em>Is Constructor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Constructor</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMethod#isConstructor()
	 * @generated
	 */
	EOperation getTMethod__IsConstructor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMethod#getFunctionAsString() <em>Get Function As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Function As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMethod#getFunctionAsString()
	 * @generated
	 */
	EOperation getTMethod__GetFunctionAsString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TMethod#getMemberAsString() <em>Get Member As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TMethod#getMemberAsString()
	 * @generated
	 */
	EOperation getTMethod__GetMemberAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TStructMethod <em>TStruct Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TStruct Method</em>'.
	 * @see org.eclipse.n4js.ts.types.TStructMethod
	 * @generated
	 */
	EClass getTStructMethod();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TFormalParameter <em>TFormal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFormal Parameter</em>'.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter
	 * @generated
	 */
	EClass getTFormalParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TFormalParameter#isVariadic <em>Variadic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variadic</em>'.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter#isVariadic()
	 * @see #getTFormalParameter()
	 * @generated
	 */
	EAttribute getTFormalParameter_Variadic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TFormalParameter#getAstInitializer <em>Ast Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ast Initializer</em>'.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter#getAstInitializer()
	 * @see #getTFormalParameter()
	 * @generated
	 */
	EAttribute getTFormalParameter_AstInitializer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TFormalParameter#isHasInitializerAssignment <em>Has Initializer Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Initializer Assignment</em>'.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter#isHasInitializerAssignment()
	 * @see #getTFormalParameter()
	 * @generated
	 */
	EAttribute getTFormalParameter_HasInitializerAssignment();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFormalParameter#hasASTInitializer() <em>Has AST Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has AST Initializer</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter#hasASTInitializer()
	 * @generated
	 */
	EOperation getTFormalParameter__HasASTInitializer();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFormalParameter#isOptional() <em>Is Optional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Optional</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter#isOptional()
	 * @generated
	 */
	EOperation getTFormalParameter__IsOptional();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFormalParameter#isVariadicOrOptional() <em>Is Variadic Or Optional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Variadic Or Optional</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter#isVariadicOrOptional()
	 * @generated
	 */
	EOperation getTFormalParameter__IsVariadicOrOptional();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFormalParameter#getFormalParameterAsTypesString() <em>Get Formal Parameter As Types String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Formal Parameter As Types String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter#getFormalParameterAsTypesString()
	 * @generated
	 */
	EOperation getTFormalParameter__GetFormalParameterAsTypesString();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TFormalParameter#getFormalParameterAsString() <em>Get Formal Parameter As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Formal Parameter As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TFormalParameter#getFormalParameterAsString()
	 * @generated
	 */
	EOperation getTFormalParameter__GetFormalParameterAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TAnonymousFormalParameter <em>TAnonymous Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TAnonymous Formal Parameter</em>'.
	 * @see org.eclipse.n4js.ts.types.TAnonymousFormalParameter
	 * @generated
	 */
	EClass getTAnonymousFormalParameter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TAnonymousFormalParameter#getName() <em>Get Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Name</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TAnonymousFormalParameter#getName()
	 * @generated
	 */
	EOperation getTAnonymousFormalParameter__GetName();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TAnonymousFormalParameter#getDefinedName() <em>Get Defined Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Defined Name</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TAnonymousFormalParameter#getDefinedName()
	 * @generated
	 */
	EOperation getTAnonymousFormalParameter__GetDefinedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TField <em>TField</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TField</em>'.
	 * @see org.eclipse.n4js.ts.types.TField
	 * @generated
	 */
	EClass getTField();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TField#isHasExpression <em>Has Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Expression</em>'.
	 * @see org.eclipse.n4js.ts.types.TField#isHasExpression()
	 * @see #getTField()
	 * @generated
	 */
	EAttribute getTField_HasExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TField#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see org.eclipse.n4js.ts.types.TField#isOptional()
	 * @see #getTField()
	 * @generated
	 */
	EAttribute getTField_Optional();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TField#isStatic() <em>Is Static</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Static</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TField#isStatic()
	 * @generated
	 */
	EOperation getTField__IsStatic();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TField#isReadable() <em>Is Readable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Readable</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TField#isReadable()
	 * @generated
	 */
	EOperation getTField__IsReadable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TField#isWriteable() <em>Is Writeable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Writeable</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TField#isWriteable()
	 * @generated
	 */
	EOperation getTField__IsWriteable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TField#getMemberType() <em>Get Member Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member Type</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TField#getMemberType()
	 * @generated
	 */
	EOperation getTField__GetMemberType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TField#getMemberAsString() <em>Get Member As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TField#getMemberAsString()
	 * @generated
	 */
	EOperation getTField__GetMemberAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TStructField <em>TStruct Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TStruct Field</em>'.
	 * @see org.eclipse.n4js.ts.types.TStructField
	 * @generated
	 */
	EClass getTStructField();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.FieldAccessor <em>Field Accessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Accessor</em>'.
	 * @see org.eclipse.n4js.ts.types.FieldAccessor
	 * @generated
	 */
	EClass getFieldAccessor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.FieldAccessor#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see org.eclipse.n4js.ts.types.FieldAccessor#isOptional()
	 * @see #getFieldAccessor()
	 * @generated
	 */
	EAttribute getFieldAccessor_Optional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.FieldAccessor#isDeclaredAbstract <em>Declared Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Abstract</em>'.
	 * @see org.eclipse.n4js.ts.types.FieldAccessor#isDeclaredAbstract()
	 * @see #getFieldAccessor()
	 * @generated
	 */
	EAttribute getFieldAccessor_DeclaredAbstract();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.FieldAccessor#getDeclaredThisType <em>Declared This Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared This Type</em>'.
	 * @see org.eclipse.n4js.ts.types.FieldAccessor#getDeclaredThisType()
	 * @see #getFieldAccessor()
	 * @generated
	 */
	EReference getFieldAccessor_DeclaredThisType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.FieldAccessor#getTypeRef() <em>Get Type Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Ref</em>' operation.
	 * @see org.eclipse.n4js.ts.types.FieldAccessor#getTypeRef()
	 * @generated
	 */
	EOperation getFieldAccessor__GetTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.FieldAccessor#isAbstract() <em>Is Abstract</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Abstract</em>' operation.
	 * @see org.eclipse.n4js.ts.types.FieldAccessor#isAbstract()
	 * @generated
	 */
	EOperation getFieldAccessor__IsAbstract();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TGetter <em>TGetter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TGetter</em>'.
	 * @see org.eclipse.n4js.ts.types.TGetter
	 * @generated
	 */
	EClass getTGetter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.TGetter#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see org.eclipse.n4js.ts.types.TGetter#getTypeRef()
	 * @see #getTGetter()
	 * @generated
	 */
	EReference getTGetter_TypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TGetter#getMemberType() <em>Get Member Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member Type</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TGetter#getMemberType()
	 * @generated
	 */
	EOperation getTGetter__GetMemberType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TGetter#getMemberAsString() <em>Get Member As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TGetter#getMemberAsString()
	 * @generated
	 */
	EOperation getTGetter__GetMemberAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TStructGetter <em>TStruct Getter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TStruct Getter</em>'.
	 * @see org.eclipse.n4js.ts.types.TStructGetter
	 * @generated
	 */
	EClass getTStructGetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TSetter <em>TSetter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TSetter</em>'.
	 * @see org.eclipse.n4js.ts.types.TSetter
	 * @generated
	 */
	EClass getTSetter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.n4js.ts.types.TSetter#getFpar <em>Fpar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fpar</em>'.
	 * @see org.eclipse.n4js.ts.types.TSetter#getFpar()
	 * @see #getTSetter()
	 * @generated
	 */
	EReference getTSetter_Fpar();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TSetter#getTypeRef() <em>Get Type Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Ref</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TSetter#getTypeRef()
	 * @generated
	 */
	EOperation getTSetter__GetTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TSetter#isReadable() <em>Is Readable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Readable</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TSetter#isReadable()
	 * @generated
	 */
	EOperation getTSetter__IsReadable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TSetter#isWriteable() <em>Is Writeable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Writeable</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TSetter#isWriteable()
	 * @generated
	 */
	EOperation getTSetter__IsWriteable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TSetter#getMemberType() <em>Get Member Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member Type</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TSetter#getMemberType()
	 * @generated
	 */
	EOperation getTSetter__GetMemberType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TSetter#getMemberAsString() <em>Get Member As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Member As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TSetter#getMemberAsString()
	 * @generated
	 */
	EOperation getTSetter__GetMemberAsString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TStructSetter <em>TStruct Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TStruct Setter</em>'.
	 * @see org.eclipse.n4js.ts.types.TStructSetter
	 * @generated
	 */
	EClass getTStructSetter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TStructSetter#isWriteable() <em>Is Writeable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Writeable</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TStructSetter#isWriteable()
	 * @generated
	 */
	EOperation getTStructSetter__IsWriteable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TEnum <em>TEnum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TEnum</em>'.
	 * @see org.eclipse.n4js.ts.types.TEnum
	 * @generated
	 */
	EClass getTEnum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TEnum#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see org.eclipse.n4js.ts.types.TEnum#isExternal()
	 * @see #getTEnum()
	 * @generated
	 */
	EAttribute getTEnum_External();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.n4js.ts.types.TEnum#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.eclipse.n4js.ts.types.TEnum#getLiterals()
	 * @see #getTEnum()
	 * @generated
	 */
	EReference getTEnum_Literals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TEnumLiteral <em>TEnum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TEnum Literal</em>'.
	 * @see org.eclipse.n4js.ts.types.TEnumLiteral
	 * @generated
	 */
	EClass getTEnumLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TEnumLiteral#getValueString <em>Value String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value String</em>'.
	 * @see org.eclipse.n4js.ts.types.TEnumLiteral#getValueString()
	 * @see #getTEnumLiteral()
	 * @generated
	 */
	EAttribute getTEnumLiteral_ValueString();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TEnumLiteral#getValueNumber <em>Value Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Number</em>'.
	 * @see org.eclipse.n4js.ts.types.TEnumLiteral#getValueNumber()
	 * @see #getTEnumLiteral()
	 * @generated
	 */
	EAttribute getTEnumLiteral_ValueNumber();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TypeAlias <em>Type Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Alias</em>'.
	 * @see org.eclipse.n4js.ts.types.TypeAlias
	 * @generated
	 */
	EClass getTypeAlias();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TypeAlias#isAlias() <em>Is Alias</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Alias</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TypeAlias#isAlias()
	 * @generated
	 */
	EOperation getTypeAlias__IsAlias();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TypeAlias#isHollow() <em>Is Hollow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Hollow</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TypeAlias#isHollow()
	 * @generated
	 */
	EOperation getTypeAlias__IsHollow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.SyntaxRelatedTElement <em>Syntax Related TElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Syntax Related TElement</em>'.
	 * @see org.eclipse.n4js.ts.types.SyntaxRelatedTElement
	 * @generated
	 */
	EClass getSyntaxRelatedTElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.n4js.ts.types.SyntaxRelatedTElement#getAstElement <em>Ast Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast Element</em>'.
	 * @see org.eclipse.n4js.ts.types.SyntaxRelatedTElement#getAstElement()
	 * @see #getSyntaxRelatedTElement()
	 * @generated
	 */
	EReference getSyntaxRelatedTElement_AstElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.SyntaxRelatedTElement#getAstElementNoResolve() <em>Get Ast Element No Resolve</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ast Element No Resolve</em>' operation.
	 * @see org.eclipse.n4js.ts.types.SyntaxRelatedTElement#getAstElementNoResolve()
	 * @generated
	 */
	EOperation getSyntaxRelatedTElement__GetAstElementNoResolve();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TConstableElement <em>TConstable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TConstable Element</em>'.
	 * @see org.eclipse.n4js.ts.types.TConstableElement
	 * @generated
	 */
	EClass getTConstableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TConstableElement#isConst <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Const</em>'.
	 * @see org.eclipse.n4js.ts.types.TConstableElement#isConst()
	 * @see #getTConstableElement()
	 * @generated
	 */
	EAttribute getTConstableElement_Const();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TConstableElement#getCompileTimeValue <em>Compile Time Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compile Time Value</em>'.
	 * @see org.eclipse.n4js.ts.types.TConstableElement#getCompileTimeValue()
	 * @see #getTConstableElement()
	 * @generated
	 */
	EAttribute getTConstableElement_CompileTimeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TAbstractVariable <em>TAbstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TAbstract Variable</em>'.
	 * @see org.eclipse.n4js.ts.types.TAbstractVariable
	 * @generated
	 */
	EClass getTAbstractVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.n4js.ts.types.TVariable <em>TVariable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TVariable</em>'.
	 * @see org.eclipse.n4js.ts.types.TVariable
	 * @generated
	 */
	EClass getTVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TVariable#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see org.eclipse.n4js.ts.types.TVariable#isExternal()
	 * @see #getTVariable()
	 * @generated
	 */
	EAttribute getTVariable_External();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TVariable#isObjectLiteral <em>Object Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Literal</em>'.
	 * @see org.eclipse.n4js.ts.types.TVariable#isObjectLiteral()
	 * @see #getTVariable()
	 * @generated
	 */
	EAttribute getTVariable_ObjectLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.n4js.ts.types.TVariable#isNewExpression <em>New Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Expression</em>'.
	 * @see org.eclipse.n4js.ts.types.TVariable#isNewExpression()
	 * @see #getTVariable()
	 * @generated
	 */
	EAttribute getTVariable_NewExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.n4js.ts.types.TVariable#getVariableAsString() <em>Get Variable As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Variable As String</em>' operation.
	 * @see org.eclipse.n4js.ts.types.TVariable#getVariableAsString()
	 * @generated
	 */
	EOperation getTVariable__GetVariableAsString();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.n4js.ts.types.TypingStrategy <em>Typing Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Typing Strategy</em>'.
	 * @see org.eclipse.n4js.ts.types.TypingStrategy
	 * @generated
	 */
	EEnum getTypingStrategy();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.n4js.ts.types.TypeAccessModifier <em>Type Access Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Access Modifier</em>'.
	 * @see org.eclipse.n4js.ts.types.TypeAccessModifier
	 * @generated
	 */
	EEnum getTypeAccessModifier();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.n4js.ts.types.MemberAccessModifier <em>Member Access Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Member Access Modifier</em>'.
	 * @see org.eclipse.n4js.ts.types.MemberAccessModifier
	 * @generated
	 */
	EEnum getMemberAccessModifier();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.n4js.ts.types.MemberType <em>Member Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Member Type</em>'.
	 * @see org.eclipse.n4js.ts.types.MemberType
	 * @generated
	 */
	EEnum getMemberType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>Iterable Of TExportable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Iterable Of TExportable Element</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable&lt;? extends org.eclipse.n4js.ts.types.TExportableElement&gt;"
	 * @generated
	 */
	EDataType getIterableOfTExportableElement();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>Iterable Of Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Iterable Of Type</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable&lt;? extends org.eclipse.n4js.ts.types.Type&gt;"
	 * @generated
	 */
	EDataType getIterableOfType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>Iterable Of Abstract Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Iterable Of Abstract Namespace</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable&lt;? extends org.eclipse.n4js.ts.types.AbstractNamespace&gt;"
	 * @generated
	 */
	EDataType getIterableOfAbstractNamespace();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>Parameterized Type Ref Iterable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Parameterized Type Ref Iterable</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable&lt;org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef&gt;"
	 * @generated
	 */
	EDataType getParameterizedTypeRefIterable();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>Iterable Of TClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Iterable Of TClassifier</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable&lt;? extends org.eclipse.n4js.ts.types.TClassifier&gt;"
	 * @generated
	 */
	EDataType getIterableOfTClassifier();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.n4js.ts.types.util.Variance <em>Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Variance</em>'.
	 * @see org.eclipse.n4js.ts.types.util.Variance
	 * @model instanceClass="org.eclipse.n4js.ts.types.util.Variance"
	 * @generated
	 */
	EDataType getVariance();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.n4js.ts.types.NameAndAccess <em>Name And Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Name And Access</em>'.
	 * @see org.eclipse.n4js.ts.types.NameAndAccess
	 * @model instanceClass="org.eclipse.n4js.ts.types.NameAndAccess"
	 * @generated
	 */
	EDataType getNameAndAccess();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Member List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Member List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List&lt;? extends org.eclipse.n4js.ts.types.TMember&gt;"
	 * @generated
	 */
	EDataType getMemberList();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>TClassifier Iterable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TClassifier Iterable</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable&lt;org.eclipse.n4js.ts.types.TClassifier&gt;"
	 * @generated
	 */
	EDataType getTClassifierIterable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TModuleImpl <em>TModule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TModuleImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTModule()
		 * @generated
		 */
		EClass TMODULE = eINSTANCE.getTModule();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__SIMPLE_NAME = eINSTANCE.getTModule_SimpleName();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__QUALIFIED_NAME = eINSTANCE.getTModule_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__PACKAGE_NAME = eINSTANCE.getTModule_PackageName();

		/**
		 * The meta object literal for the '<em><b>Project ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__PROJECT_ID = eINSTANCE.getTModule_ProjectID();

		/**
		 * The meta object literal for the '<em><b>Vendor ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__VENDOR_ID = eINSTANCE.getTModule_VendorID();

		/**
		 * The meta object literal for the '<em><b>N4jsd Module</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__N4JSD_MODULE = eINSTANCE.getTModule_N4jsdModule();

		/**
		 * The meta object literal for the '<em><b>Static Polyfill Module</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__STATIC_POLYFILL_MODULE = eINSTANCE.getTModule_StaticPolyfillModule();

		/**
		 * The meta object literal for the '<em><b>Static Polyfill Aware</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__STATIC_POLYFILL_AWARE = eINSTANCE.getTModule_StaticPolyfillAware();

		/**
		 * The meta object literal for the '<em><b>Main Module</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__MAIN_MODULE = eINSTANCE.getTModule_MainModule();

		/**
		 * The meta object literal for the '<em><b>Pre Linking Phase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__PRE_LINKING_PHASE = eINSTANCE.getTModule_PreLinkingPhase();

		/**
		 * The meta object literal for the '<em><b>Reconciled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__RECONCILED = eINSTANCE.getTModule_Reconciled();

		/**
		 * The meta object literal for the '<em><b>Dependencies Runtime</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__DEPENDENCIES_RUNTIME = eINSTANCE.getTModule_DependenciesRuntime();

		/**
		 * The meta object literal for the '<em><b>Cyclic Modules Runtime</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__CYCLIC_MODULES_RUNTIME = eINSTANCE.getTModule_CyclicModulesRuntime();

		/**
		 * The meta object literal for the '<em><b>Cyclic Modules Loadtime For Inheritance</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__CYCLIC_MODULES_LOADTIME_FOR_INHERITANCE = eINSTANCE.getTModule_CyclicModulesLoadtimeForInheritance();

		/**
		 * The meta object literal for the '<em><b>Runtime Cyclic Loadtime Dependents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__RUNTIME_CYCLIC_LOADTIME_DEPENDENTS = eINSTANCE.getTModule_RuntimeCyclicLoadtimeDependents();

		/**
		 * The meta object literal for the '<em><b>Internal Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__INTERNAL_TYPES = eINSTANCE.getTModule_InternalTypes();

		/**
		 * The meta object literal for the '<em><b>Exposed Internal Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__EXPOSED_INTERNAL_TYPES = eINSTANCE.getTModule_ExposedInternalTypes();

		/**
		 * The meta object literal for the '<em><b>Internal Dynamic Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__INTERNAL_DYNAMIC_ELEMENTS = eINSTANCE.getTModule_InternalDynamicElements();

		/**
		 * The meta object literal for the '<em><b>Ast MD5</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__AST_MD5 = eINSTANCE.getTModule_AstMD5();

		/**
		 * The meta object literal for the '<em><b>Composed Member Caches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__COMPOSED_MEMBER_CACHES = eINSTANCE.getTModule_ComposedMemberCaches();

		/**
		 * The meta object literal for the '<em><b>Temporary Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODULE__TEMPORARY_TYPES = eINSTANCE.getTModule_TemporaryTypes();

		/**
		 * The meta object literal for the '<em><b>Module Specifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODULE__MODULE_SPECIFIER = eINSTANCE.getTModule_ModuleSpecifier();

		/**
		 * The meta object literal for the '<em><b>Clear Transient Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMODULE___CLEAR_TRANSIENT_ELEMENTS = eINSTANCE.getTModule__ClearTransientElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.RuntimeDependencyImpl <em>Runtime Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.RuntimeDependencyImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getRuntimeDependency()
		 * @generated
		 */
		EClass RUNTIME_DEPENDENCY = eINSTANCE.getRuntimeDependency();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_DEPENDENCY__TARGET = eINSTANCE.getRuntimeDependency_Target();

		/**
		 * The meta object literal for the '<em><b>Loadtime For Inheritance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_DEPENDENCY__LOADTIME_FOR_INHERITANCE = eINSTANCE.getRuntimeDependency_LoadtimeForInheritance();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.ComposedMemberCacheImpl <em>Composed Member Cache</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.ComposedMemberCacheImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getComposedMemberCache()
		 * @generated
		 */
		EClass COMPOSED_MEMBER_CACHE = eINSTANCE.getComposedMemberCache();

		/**
		 * The meta object literal for the '<em><b>Cached Composed Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_MEMBER_CACHE__CACHED_COMPOSED_MEMBERS = eINSTANCE.getComposedMemberCache_CachedComposedMembers();

		/**
		 * The meta object literal for the '<em><b>Composed Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_MEMBER_CACHE__COMPOSED_TYPE_REF = eINSTANCE.getComposedMemberCache_ComposedTypeRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.TypableElement <em>Typable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.TypableElement
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypableElement()
		 * @generated
		 */
		EClass TYPABLE_ELEMENT = eINSTANCE.getTypableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.IdentifiableElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIdentifiableElement()
		 * @generated
		 */
		EClass IDENTIFIABLE_ELEMENT = eINSTANCE.getIdentifiableElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE_ELEMENT__NAME = eINSTANCE.getIdentifiableElement_Name();

		/**
		 * The meta object literal for the '<em><b>Get Containing Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IDENTIFIABLE_ELEMENT___GET_CONTAINING_MODULE = eINSTANCE.getIdentifiableElement__GetContainingModule();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TExportingElementImpl <em>TExporting Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TExportingElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTExportingElement()
		 * @generated
		 */
		EClass TEXPORTING_ELEMENT = eINSTANCE.getTExportingElement();

		/**
		 * The meta object literal for the '<em><b>Export Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXPORTING_ELEMENT__EXPORT_DEFINITIONS = eINSTANCE.getTExportingElement_ExportDefinitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.ExportDefinitionImpl <em>Export Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.ExportDefinitionImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getExportDefinition()
		 * @generated
		 */
		EClass EXPORT_DEFINITION = eINSTANCE.getExportDefinition();

		/**
		 * The meta object literal for the '<em><b>Get Containing Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXPORT_DEFINITION___GET_CONTAINING_MODULE = eINSTANCE.getExportDefinition__GetContainingModule();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.ElementExportDefinitionImpl <em>Element Export Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.ElementExportDefinitionImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getElementExportDefinition()
		 * @generated
		 */
		EClass ELEMENT_EXPORT_DEFINITION = eINSTANCE.getElementExportDefinition();

		/**
		 * The meta object literal for the '<em><b>Exported Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_EXPORT_DEFINITION__EXPORTED_NAME = eINSTANCE.getElementExportDefinition_ExportedName();

		/**
		 * The meta object literal for the '<em><b>Exported Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_EXPORT_DEFINITION__EXPORTED_ELEMENT = eINSTANCE.getElementExportDefinition_ExportedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.ModuleExportDefinitionImpl <em>Module Export Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.ModuleExportDefinitionImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getModuleExportDefinition()
		 * @generated
		 */
		EClass MODULE_EXPORT_DEFINITION = eINSTANCE.getModuleExportDefinition();

		/**
		 * The meta object literal for the '<em><b>Exported Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_EXPORT_DEFINITION__EXPORTED_MODULE = eINSTANCE.getModuleExportDefinition_ExportedModule();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TExportableElementImpl <em>TExportable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TExportableElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTExportableElement()
		 * @generated
		 */
		EClass TEXPORTABLE_ELEMENT = eINSTANCE.getTExportableElement();

		/**
		 * The meta object literal for the '<em><b>Directly Exported</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXPORTABLE_ELEMENT__DIRECTLY_EXPORTED = eINSTANCE.getTExportableElement_DirectlyExported();

		/**
		 * The meta object literal for the '<em><b>Directly Exported As Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXPORTABLE_ELEMENT__DIRECTLY_EXPORTED_AS_DEFAULT = eINSTANCE.getTExportableElement_DirectlyExportedAsDefault();

		/**
		 * The meta object literal for the '<em><b>Exporting Export Definitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXPORTABLE_ELEMENT__EXPORTING_EXPORT_DEFINITIONS = eINSTANCE.getTExportableElement_ExportingExportDefinitions();

		/**
		 * The meta object literal for the '<em><b>Is Exported</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEXPORTABLE_ELEMENT___IS_EXPORTED = eINSTANCE.getTExportableElement__IsExported();

		/**
		 * The meta object literal for the '<em><b>Is Indirectly Exported</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEXPORTABLE_ELEMENT___IS_INDIRECTLY_EXPORTED = eINSTANCE.getTExportableElement__IsIndirectlyExported();

		/**
		 * The meta object literal for the '<em><b>Get Directly Exported Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEXPORTABLE_ELEMENT___GET_DIRECTLY_EXPORTED_NAME = eINSTANCE.getTExportableElement__GetDirectlyExportedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TDynamicElementImpl <em>TDynamic Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TDynamicElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTDynamicElement()
		 * @generated
		 */
		EClass TDYNAMIC_ELEMENT = eINSTANCE.getTDynamicElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotationImpl <em>TAnnotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TAnnotationImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotation()
		 * @generated
		 */
		EClass TANNOTATION = eINSTANCE.getTAnnotation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TANNOTATION__NAME = eINSTANCE.getTAnnotation_Name();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TANNOTATION__ARGS = eINSTANCE.getTAnnotation_Args();

		/**
		 * The meta object literal for the '<em><b>Has String Argument</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TANNOTATION___HAS_STRING_ARGUMENT__STRING = eINSTANCE.getTAnnotation__HasStringArgument__String();

		/**
		 * The meta object literal for the '<em><b>Get Annotation As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TANNOTATION___GET_ANNOTATION_AS_STRING = eINSTANCE.getTAnnotation__GetAnnotationAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotationArgumentImpl <em>TAnnotation Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TAnnotationArgumentImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotationArgument()
		 * @generated
		 */
		EClass TANNOTATION_ARGUMENT = eINSTANCE.getTAnnotationArgument();

		/**
		 * The meta object literal for the '<em><b>Get Arg As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TANNOTATION_ARGUMENT___GET_ARG_AS_STRING = eINSTANCE.getTAnnotationArgument__GetArgAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotationStringArgumentImpl <em>TAnnotation String Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TAnnotationStringArgumentImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotationStringArgument()
		 * @generated
		 */
		EClass TANNOTATION_STRING_ARGUMENT = eINSTANCE.getTAnnotationStringArgument();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TANNOTATION_STRING_ARGUMENT__VALUE = eINSTANCE.getTAnnotationStringArgument_Value();

		/**
		 * The meta object literal for the '<em><b>Get Arg As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TANNOTATION_STRING_ARGUMENT___GET_ARG_AS_STRING = eINSTANCE.getTAnnotationStringArgument__GetArgAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.TTypedElement <em>TTyped Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.TTypedElement
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTTypedElement()
		 * @generated
		 */
		EClass TTYPED_ELEMENT = eINSTANCE.getTTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTYPED_ELEMENT__TYPE_REF = eINSTANCE.getTTypedElement_TypeRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotationTypeRefArgumentImpl <em>TAnnotation Type Ref Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TAnnotationTypeRefArgumentImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotationTypeRefArgument()
		 * @generated
		 */
		EClass TANNOTATION_TYPE_REF_ARGUMENT = eINSTANCE.getTAnnotationTypeRefArgument();

		/**
		 * The meta object literal for the '<em><b>Get Arg As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TANNOTATION_TYPE_REF_ARGUMENT___GET_ARG_AS_STRING = eINSTANCE.getTAnnotationTypeRefArgument__GetArgAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TAnnotableElementImpl <em>TAnnotable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TAnnotableElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnnotableElement()
		 * @generated
		 */
		EClass TANNOTABLE_ELEMENT = eINSTANCE.getTAnnotableElement();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TANNOTABLE_ELEMENT__ANNOTATIONS = eINSTANCE.getTAnnotableElement_Annotations();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TypeVariableImpl <em>Type Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TypeVariableImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypeVariable()
		 * @generated
		 */
		EClass TYPE_VARIABLE = eINSTANCE.getTypeVariable();

		/**
		 * The meta object literal for the '<em><b>Declared Covariant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_VARIABLE__DECLARED_COVARIANT = eINSTANCE.getTypeVariable_DeclaredCovariant();

		/**
		 * The meta object literal for the '<em><b>Declared Contravariant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_VARIABLE__DECLARED_CONTRAVARIANT = eINSTANCE.getTypeVariable_DeclaredContravariant();

		/**
		 * The meta object literal for the '<em><b>Declared Upper Bound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_VARIABLE__DECLARED_UPPER_BOUND = eINSTANCE.getTypeVariable_DeclaredUpperBound();

		/**
		 * The meta object literal for the '<em><b>Default Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_VARIABLE__DEFAULT_ARGUMENT = eINSTANCE.getTypeVariable_DefaultArgument();

		/**
		 * The meta object literal for the '<em><b>Get Variance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_VARIABLE___GET_VARIANCE = eINSTANCE.getTypeVariable__GetVariance();

		/**
		 * The meta object literal for the '<em><b>Is Optional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_VARIABLE___IS_OPTIONAL = eINSTANCE.getTypeVariable__IsOptional();

		/**
		 * The meta object literal for the '<em><b>Get Type As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_VARIABLE___GET_TYPE_AS_STRING = eINSTANCE.getTypeVariable__GetTypeAsString();

		/**
		 * The meta object literal for the '<em><b>Get Type Variable As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_VARIABLE___GET_TYPE_VARIABLE_AS_STRING__TYPEREF = eINSTANCE.getTypeVariable__GetTypeVariableAsString__TypeRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.InferenceVariableImpl <em>Inference Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.InferenceVariableImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getInferenceVariable()
		 * @generated
		 */
		EClass INFERENCE_VARIABLE = eINSTANCE.getInferenceVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TFunctionImpl <em>TFunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TFunctionImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTFunction()
		 * @generated
		 */
		EClass TFUNCTION = eINSTANCE.getTFunction();

		/**
		 * The meta object literal for the '<em><b>External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFUNCTION__EXTERNAL = eINSTANCE.getTFunction_External();

		/**
		 * The meta object literal for the '<em><b>Fpars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFUNCTION__FPARS = eINSTANCE.getTFunction_Fpars();

		/**
		 * The meta object literal for the '<em><b>Return Value Marked Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFUNCTION__RETURN_VALUE_MARKED_OPTIONAL = eINSTANCE.getTFunction_ReturnValueMarkedOptional();

		/**
		 * The meta object literal for the '<em><b>Return Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFUNCTION__RETURN_TYPE_REF = eINSTANCE.getTFunction_ReturnTypeRef();

		/**
		 * The meta object literal for the '<em><b>Declared This Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFUNCTION__DECLARED_THIS_TYPE = eINSTANCE.getTFunction_DeclaredThisType();

		/**
		 * The meta object literal for the '<em><b>Declared Async</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFUNCTION__DECLARED_ASYNC = eINSTANCE.getTFunction_DeclaredAsync();

		/**
		 * The meta object literal for the '<em><b>Declared Generator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFUNCTION__DECLARED_GENERATOR = eINSTANCE.getTFunction_DeclaredGenerator();

		/**
		 * The meta object literal for the '<em><b>Constructor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFUNCTION__CONSTRUCTOR = eINSTANCE.getTFunction_Constructor();

		/**
		 * The meta object literal for the '<em><b>Is Return Value Optional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFUNCTION___IS_RETURN_VALUE_OPTIONAL = eINSTANCE.getTFunction__IsReturnValueOptional();

		/**
		 * The meta object literal for the '<em><b>Is Call Signature</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFUNCTION___IS_CALL_SIGNATURE = eINSTANCE.getTFunction__IsCallSignature();

		/**
		 * The meta object literal for the '<em><b>Is Construct Signature</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFUNCTION___IS_CONSTRUCT_SIGNATURE = eINSTANCE.getTFunction__IsConstructSignature();

		/**
		 * The meta object literal for the '<em><b>Get Fpar For Arg Idx</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFUNCTION___GET_FPAR_FOR_ARG_IDX__INT = eINSTANCE.getTFunction__GetFparForArgIdx__int();

		/**
		 * The meta object literal for the '<em><b>Get Function As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFUNCTION___GET_FUNCTION_AS_STRING = eINSTANCE.getTFunction__GetFunctionAsString();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFUNCTION___IS_FINAL = eINSTANCE.getTFunction__IsFinal();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Is Alias</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_ALIAS = eINSTANCE.getType__IsAlias();

		/**
		 * The meta object literal for the '<em><b>Is Provided By Runtime</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_PROVIDED_BY_RUNTIME = eINSTANCE.getType__IsProvidedByRuntime();

		/**
		 * The meta object literal for the '<em><b>Is Polyfill</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_POLYFILL = eINSTANCE.getType__IsPolyfill();

		/**
		 * The meta object literal for the '<em><b>Is Static Polyfill</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_STATIC_POLYFILL = eINSTANCE.getType__IsStaticPolyfill();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_FINAL = eINSTANCE.getType__IsFinal();

		/**
		 * The meta object literal for the '<em><b>Is Dynamizable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_DYNAMIZABLE = eINSTANCE.getType__IsDynamizable();

		/**
		 * The meta object literal for the '<em><b>Is Array Like</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_ARRAY_LIKE = eINSTANCE.getType__IsArrayLike();

		/**
		 * The meta object literal for the '<em><b>Get Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___GET_ELEMENT_TYPE = eINSTANCE.getType__GetElementType();

		/**
		 * The meta object literal for the '<em><b>Get Type Access Modifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___GET_TYPE_ACCESS_MODIFIER = eINSTANCE.getType__GetTypeAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Is Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_GENERIC = eINSTANCE.getType__IsGeneric();

		/**
		 * The meta object literal for the '<em><b>Get Type Vars</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___GET_TYPE_VARS = eINSTANCE.getType__GetTypeVars();

		/**
		 * The meta object literal for the '<em><b>Get Variance Of Type Var</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___GET_VARIANCE_OF_TYPE_VAR__INT = eINSTANCE.getType__GetVarianceOfTypeVar__int();

		/**
		 * The meta object literal for the '<em><b>Get Raw Type As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___GET_RAW_TYPE_AS_STRING = eINSTANCE.getType__GetRawTypeAsString();

		/**
		 * The meta object literal for the '<em><b>Get Type As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___GET_TYPE_AS_STRING = eINSTANCE.getType__GetTypeAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.GenericTypeImpl <em>Generic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.GenericTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getGenericType()
		 * @generated
		 */
		EClass GENERIC_TYPE = eINSTANCE.getGenericType();

		/**
		 * The meta object literal for the '<em><b>Type Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_TYPE__TYPE_VARS = eINSTANCE.getGenericType_TypeVars();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.AccessibleTypeElementImpl <em>Accessible Type Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.AccessibleTypeElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getAccessibleTypeElement()
		 * @generated
		 */
		EClass ACCESSIBLE_TYPE_ELEMENT = eINSTANCE.getAccessibleTypeElement();

		/**
		 * The meta object literal for the '<em><b>Declared Type Access Modifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESSIBLE_TYPE_ELEMENT__DECLARED_TYPE_ACCESS_MODIFIER = eINSTANCE.getAccessibleTypeElement_DeclaredTypeAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Declared Provided By Runtime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESSIBLE_TYPE_ELEMENT__DECLARED_PROVIDED_BY_RUNTIME = eINSTANCE.getAccessibleTypeElement_DeclaredProvidedByRuntime();

		/**
		 * The meta object literal for the '<em><b>Is Provided By Runtime</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACCESSIBLE_TYPE_ELEMENT___IS_PROVIDED_BY_RUNTIME = eINSTANCE.getAccessibleTypeElement__IsProvidedByRuntime();

		/**
		 * The meta object literal for the '<em><b>Get Type Access Modifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACCESSIBLE_TYPE_ELEMENT___GET_TYPE_ACCESS_MODIFIER = eINSTANCE.getAccessibleTypeElement__GetTypeAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Get Default Type Access Modifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACCESSIBLE_TYPE_ELEMENT___GET_DEFAULT_TYPE_ACCESS_MODIFIER = eINSTANCE.getAccessibleTypeElement__GetDefaultTypeAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Is Directly Exported</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACCESSIBLE_TYPE_ELEMENT___IS_DIRECTLY_EXPORTED = eINSTANCE.getAccessibleTypeElement__IsDirectlyExported();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.ContainerTypeImpl <em>Container Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.ContainerTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getContainerType()
		 * @generated
		 */
		EClass CONTAINER_TYPE = eINSTANCE.getContainerType();

		/**
		 * The meta object literal for the '<em><b>Owned Members By Name And Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER_TYPE__OWNED_MEMBERS_BY_NAME_AND_ACCESS = eINSTANCE.getContainerType_OwnedMembersByNameAndAccess();

		/**
		 * The meta object literal for the '<em><b>Owned Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_TYPE__OWNED_MEMBERS = eINSTANCE.getContainerType_OwnedMembers();

		/**
		 * The meta object literal for the '<em><b>Call Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_TYPE__CALL_SIGNATURE = eINSTANCE.getContainerType_CallSignature();

		/**
		 * The meta object literal for the '<em><b>Construct Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_TYPE__CONSTRUCT_SIGNATURE = eINSTANCE.getContainerType_ConstructSignature();

		/**
		 * The meta object literal for the '<em><b>Get Owned Ctor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_TYPE___GET_OWNED_CTOR = eINSTANCE.getContainerType__GetOwnedCtor();

		/**
		 * The meta object literal for the '<em><b>Find Owned Member</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_TYPE___FIND_OWNED_MEMBER__STRING = eINSTANCE.getContainerType__FindOwnedMember__String();

		/**
		 * The meta object literal for the '<em><b>Find Owned Member</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_TYPE___FIND_OWNED_MEMBER__STRING_BOOLEAN_BOOLEAN = eINSTANCE.getContainerType__FindOwnedMember__String_boolean_boolean();

		/**
		 * The meta object literal for the '<em><b>Get Or Create Owned Members By Name And Access</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_TYPE___GET_OR_CREATE_OWNED_MEMBERS_BY_NAME_AND_ACCESS = eINSTANCE.getContainerType__GetOrCreateOwnedMembersByNameAndAccess();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.AbstractNamespaceImpl <em>Abstract Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.AbstractNamespaceImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getAbstractNamespace()
		 * @generated
		 */
		EClass ABSTRACT_NAMESPACE = eINSTANCE.getAbstractNamespace();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAMESPACE__TYPES = eINSTANCE.getAbstractNamespace_Types();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAMESPACE__FUNCTIONS = eINSTANCE.getAbstractNamespace_Functions();

		/**
		 * The meta object literal for the '<em><b>Exported Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAMESPACE__EXPORTED_VARIABLES = eINSTANCE.getAbstractNamespace_ExportedVariables();

		/**
		 * The meta object literal for the '<em><b>Local Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAMESPACE__LOCAL_VARIABLES = eINSTANCE.getAbstractNamespace_LocalVariables();

		/**
		 * The meta object literal for the '<em><b>Exposed Local Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAMESPACE__EXPOSED_LOCAL_VARIABLES = eINSTANCE.getAbstractNamespace_ExposedLocalVariables();

		/**
		 * The meta object literal for the '<em><b>Namespaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAMESPACE__NAMESPACES = eINSTANCE.getAbstractNamespace_Namespaces();

		/**
		 * The meta object literal for the '<em><b>Get Types And Functions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_NAMESPACE___GET_TYPES_AND_FUNCTIONS = eINSTANCE.getAbstractNamespace__GetTypesAndFunctions();

		/**
		 * The meta object literal for the '<em><b>Get Exportable Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_NAMESPACE___GET_EXPORTABLE_ELEMENTS = eINSTANCE.getAbstractNamespace__GetExportableElements();

		/**
		 * The meta object literal for the '<em><b>Get All Namespaces</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_NAMESPACE___GET_ALL_NAMESPACES = eINSTANCE.getAbstractNamespace__GetAllNamespaces();

		/**
		 * The meta object literal for the '<em><b>Get Containing Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_NAMESPACE___GET_CONTAINING_MODULE = eINSTANCE.getAbstractNamespace__GetContainingModule();

		/**
		 * The meta object literal for the '<em><b>Clear Transient Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_NAMESPACE___CLEAR_TRANSIENT_ELEMENTS = eINSTANCE.getAbstractNamespace__ClearTransientElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TNamespaceImpl <em>TNamespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TNamespaceImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTNamespace()
		 * @generated
		 */
		EClass TNAMESPACE = eINSTANCE.getTNamespace();

		/**
		 * The meta object literal for the '<em><b>External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNAMESPACE__EXTERNAL = eINSTANCE.getTNamespace_External();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TNamespaceElementImpl <em>TNamespace Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TNamespaceElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTNamespaceElement()
		 * @generated
		 */
		EClass TNAMESPACE_ELEMENT = eINSTANCE.getTNamespaceElement();

		/**
		 * The meta object literal for the '<em><b>Is Hollow</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TNAMESPACE_ELEMENT___IS_HOLLOW = eINSTANCE.getTNamespaceElement__IsHollow();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.ModuleNamespaceVirtualTypeImpl <em>Module Namespace Virtual Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.ModuleNamespaceVirtualTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getModuleNamespaceVirtualType()
		 * @generated
		 */
		EClass MODULE_NAMESPACE_VIRTUAL_TYPE = eINSTANCE.getModuleNamespaceVirtualType();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_NAMESPACE_VIRTUAL_TYPE__MODULE = eINSTANCE.getModuleNamespaceVirtualType_Module();

		/**
		 * The meta object literal for the '<em><b>Declared Dynamic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_NAMESPACE_VIRTUAL_TYPE__DECLARED_DYNAMIC = eINSTANCE.getModuleNamespaceVirtualType_DeclaredDynamic();

		/**
		 * The meta object literal for the '<em><b>Is Provided By Runtime</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE_NAMESPACE_VIRTUAL_TYPE___IS_PROVIDED_BY_RUNTIME = eINSTANCE.getModuleNamespaceVirtualType__IsProvidedByRuntime();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.PrimitiveTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Assignment Compatible</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE__ASSIGNMENT_COMPATIBLE = eINSTANCE.getPrimitiveType_AssignmentCompatible();

		/**
		 * The meta object literal for the '<em><b>Autoboxed Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE__AUTOBOXED_TYPE = eINSTANCE.getPrimitiveType_AutoboxedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.BuiltInTypeImpl <em>Built In Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.BuiltInTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getBuiltInType()
		 * @generated
		 */
		EClass BUILT_IN_TYPE = eINSTANCE.getBuiltInType();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.AnyTypeImpl <em>Any Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.AnyTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getAnyType()
		 * @generated
		 */
		EClass ANY_TYPE = eINSTANCE.getAnyType();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANY_TYPE___IS_FINAL = eINSTANCE.getAnyType__IsFinal();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.UndefinedTypeImpl <em>Undefined Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.UndefinedTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getUndefinedType()
		 * @generated
		 */
		EClass UNDEFINED_TYPE = eINSTANCE.getUndefinedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.NullTypeImpl <em>Null Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.NullTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getNullType()
		 * @generated
		 */
		EClass NULL_TYPE = eINSTANCE.getNullType();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.VoidTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TStructuralTypeImpl <em>TStructural Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TStructuralTypeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructuralType()
		 * @generated
		 */
		EClass TSTRUCTURAL_TYPE = eINSTANCE.getTStructuralType();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSTRUCTURAL_TYPE___IS_FINAL = eINSTANCE.getTStructuralType__IsFinal();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TClassifierImpl <em>TClassifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TClassifierImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTClassifier()
		 * @generated
		 */
		EClass TCLASSIFIER = eINSTANCE.getTClassifier();

		/**
		 * The meta object literal for the '<em><b>Declared Covariant Constructor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR = eINSTANCE.getTClassifier_DeclaredCovariantConstructor();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASSIFIER___IS_ABSTRACT = eINSTANCE.getTClassifier__IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Get Super Classifiers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASSIFIER___GET_SUPER_CLASSIFIERS = eINSTANCE.getTClassifier__GetSuperClassifiers();

		/**
		 * The meta object literal for the '<em><b>Get Super Classifier Refs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASSIFIER___GET_SUPER_CLASSIFIER_REFS = eINSTANCE.getTClassifier__GetSuperClassifierRefs();

		/**
		 * The meta object literal for the '<em><b>Get Implemented Or Extended Interface Refs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASSIFIER___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS = eINSTANCE.getTClassifier__GetImplementedOrExtendedInterfaceRefs();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASSIFIER___IS_FINAL = eINSTANCE.getTClassifier__IsFinal();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.ArrayLikeImpl <em>Array Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.ArrayLikeImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getArrayLike()
		 * @generated
		 */
		EClass ARRAY_LIKE = eINSTANCE.getArrayLike();

		/**
		 * The meta object literal for the '<em><b>Declared Element Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_LIKE__DECLARED_ELEMENT_TYPE = eINSTANCE.getArrayLike_DeclaredElementType();

		/**
		 * The meta object literal for the '<em><b>Get Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARRAY_LIKE___GET_ELEMENT_TYPE = eINSTANCE.getArrayLike__GetElementType();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TN4ClassifierImpl <em>TN4 Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TN4ClassifierImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTN4Classifier()
		 * @generated
		 */
		EClass TN4_CLASSIFIER = eINSTANCE.getTN4Classifier();

		/**
		 * The meta object literal for the '<em><b>External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TN4_CLASSIFIER__EXTERNAL = eINSTANCE.getTN4Classifier_External();

		/**
		 * The meta object literal for the '<em><b>Declared Non Static Polyfill</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TN4_CLASSIFIER__DECLARED_NON_STATIC_POLYFILL = eINSTANCE.getTN4Classifier_DeclaredNonStaticPolyfill();

		/**
		 * The meta object literal for the '<em><b>Dynamizable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TN4_CLASSIFIER__DYNAMIZABLE = eINSTANCE.getTN4Classifier_Dynamizable();

		/**
		 * The meta object literal for the '<em><b>Is Polyfill</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TN4_CLASSIFIER___IS_POLYFILL = eINSTANCE.getTN4Classifier__IsPolyfill();

		/**
		 * The meta object literal for the '<em><b>Get Typing Strategy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TN4_CLASSIFIER___GET_TYPING_STRATEGY = eINSTANCE.getTN4Classifier__GetTypingStrategy();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TClassImpl <em>TClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TClassImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTClass()
		 * @generated
		 */
		EClass TCLASS = eINSTANCE.getTClass();

		/**
		 * The meta object literal for the '<em><b>Declared Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCLASS__DECLARED_ABSTRACT = eINSTANCE.getTClass_DeclaredAbstract();

		/**
		 * The meta object literal for the '<em><b>Declared Ecma Script</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCLASS__DECLARED_ECMA_SCRIPT = eINSTANCE.getTClass_DeclaredEcmaScript();

		/**
		 * The meta object literal for the '<em><b>Declared Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCLASS__DECLARED_FINAL = eINSTANCE.getTClass_DeclaredFinal();

		/**
		 * The meta object literal for the '<em><b>Declared Static Polyfill</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCLASS__DECLARED_STATIC_POLYFILL = eINSTANCE.getTClass_DeclaredStaticPolyfill();

		/**
		 * The meta object literal for the '<em><b>Observable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCLASS__OBSERVABLE = eINSTANCE.getTClass_Observable();

		/**
		 * The meta object literal for the '<em><b>Super Class Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCLASS__SUPER_CLASS_REF = eINSTANCE.getTClass_SuperClassRef();

		/**
		 * The meta object literal for the '<em><b>Implemented Interface Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCLASS__IMPLEMENTED_INTERFACE_REFS = eINSTANCE.getTClass_ImplementedInterfaceRefs();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASS___IS_ABSTRACT = eINSTANCE.getTClass__IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Get Super Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASS___GET_SUPER_CLASS = eINSTANCE.getTClass__GetSuperClass();

		/**
		 * The meta object literal for the '<em><b>Get Super Classifier Refs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASS___GET_SUPER_CLASSIFIER_REFS = eINSTANCE.getTClass__GetSuperClassifierRefs();

		/**
		 * The meta object literal for the '<em><b>Get Implemented Or Extended Interface Refs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASS___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS = eINSTANCE.getTClass__GetImplementedOrExtendedInterfaceRefs();

		/**
		 * The meta object literal for the '<em><b>Is Polyfill</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASS___IS_POLYFILL = eINSTANCE.getTClass__IsPolyfill();

		/**
		 * The meta object literal for the '<em><b>Is Static Polyfill</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASS___IS_STATIC_POLYFILL = eINSTANCE.getTClass__IsStaticPolyfill();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCLASS___IS_FINAL = eINSTANCE.getTClass__IsFinal();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TInterfaceImpl <em>TInterface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TInterfaceImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTInterface()
		 * @generated
		 */
		EClass TINTERFACE = eINSTANCE.getTInterface();

		/**
		 * The meta object literal for the '<em><b>Super Interface Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINTERFACE__SUPER_INTERFACE_REFS = eINSTANCE.getTInterface_SuperInterfaceRefs();

		/**
		 * The meta object literal for the '<em><b>Typing Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TINTERFACE__TYPING_STRATEGY = eINSTANCE.getTInterface_TypingStrategy();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TINTERFACE___IS_ABSTRACT = eINSTANCE.getTInterface__IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Get Super Classifier Refs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TINTERFACE___GET_SUPER_CLASSIFIER_REFS = eINSTANCE.getTInterface__GetSuperClassifierRefs();

		/**
		 * The meta object literal for the '<em><b>Get Implemented Or Extended Interface Refs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TINTERFACE___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS = eINSTANCE.getTInterface__GetImplementedOrExtendedInterfaceRefs();

		/**
		 * The meta object literal for the '<em><b>Is Hollow</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TINTERFACE___IS_HOLLOW = eINSTANCE.getTInterface__IsHollow();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TMemberImpl <em>TMember</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TMemberImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTMember()
		 * @generated
		 */
		EClass TMEMBER = eINSTANCE.getTMember();

		/**
		 * The meta object literal for the '<em><b>Declared Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMEMBER__DECLARED_FINAL = eINSTANCE.getTMember_DeclaredFinal();

		/**
		 * The meta object literal for the '<em><b>Declared Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMEMBER__DECLARED_STATIC = eINSTANCE.getTMember_DeclaredStatic();

		/**
		 * The meta object literal for the '<em><b>Declared Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMEMBER__DECLARED_OVERRIDE = eINSTANCE.getTMember_DeclaredOverride();

		/**
		 * The meta object literal for the '<em><b>Has Computed Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMEMBER__HAS_COMPUTED_NAME = eINSTANCE.getTMember_HasComputedName();

		/**
		 * The meta object literal for the '<em><b>Constituent Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMEMBER__CONSTITUENT_MEMBERS = eINSTANCE.getTMember_ConstituentMembers();

		/**
		 * The meta object literal for the '<em><b>Composed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMEMBER__COMPOSED = eINSTANCE.getTMember_Composed();

		/**
		 * The meta object literal for the '<em><b>Get Containing Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___GET_CONTAINING_TYPE = eINSTANCE.getTMember__GetContainingType();

		/**
		 * The meta object literal for the '<em><b>Get Member Access Modifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___GET_MEMBER_ACCESS_MODIFIER = eINSTANCE.getTMember__GetMemberAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Get Member Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___GET_MEMBER_TYPE = eINSTANCE.getTMember__GetMemberType();

		/**
		 * The meta object literal for the '<em><b>Is Field</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_FIELD = eINSTANCE.getTMember__IsField();

		/**
		 * The meta object literal for the '<em><b>Is Getter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_GETTER = eINSTANCE.getTMember__IsGetter();

		/**
		 * The meta object literal for the '<em><b>Is Setter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_SETTER = eINSTANCE.getTMember__IsSetter();

		/**
		 * The meta object literal for the '<em><b>Is Accessor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_ACCESSOR = eINSTANCE.getTMember__IsAccessor();

		/**
		 * The meta object literal for the '<em><b>Is Method</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_METHOD = eINSTANCE.getTMember__IsMethod();

		/**
		 * The meta object literal for the '<em><b>Is Constructor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_CONSTRUCTOR = eINSTANCE.getTMember__IsConstructor();

		/**
		 * The meta object literal for the '<em><b>Is Optional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_OPTIONAL = eINSTANCE.getTMember__IsOptional();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_ABSTRACT = eINSTANCE.getTMember__IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Readable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_READABLE = eINSTANCE.getTMember__IsReadable();

		/**
		 * The meta object literal for the '<em><b>Is Writeable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_WRITEABLE = eINSTANCE.getTMember__IsWriteable();

		/**
		 * The meta object literal for the '<em><b>Get Member As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___GET_MEMBER_AS_STRING = eINSTANCE.getTMember__GetMemberAsString();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_FINAL = eINSTANCE.getTMember__IsFinal();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_STATIC = eINSTANCE.getTMember__IsStatic();

		/**
		 * The meta object literal for the '<em><b>Is Const</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_CONST = eINSTANCE.getTMember__IsConst();

		/**
		 * The meta object literal for the '<em><b>Is Polyfilled</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER___IS_POLYFILLED = eINSTANCE.getTMember__IsPolyfilled();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TMemberWithAccessModifierImpl <em>TMember With Access Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TMemberWithAccessModifierImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTMemberWithAccessModifier()
		 * @generated
		 */
		EClass TMEMBER_WITH_ACCESS_MODIFIER = eINSTANCE.getTMemberWithAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Has No Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMEMBER_WITH_ACCESS_MODIFIER__HAS_NO_BODY = eINSTANCE.getTMemberWithAccessModifier_HasNoBody();

		/**
		 * The meta object literal for the '<em><b>Declared Member Access Modifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMEMBER_WITH_ACCESS_MODIFIER__DECLARED_MEMBER_ACCESS_MODIFIER = eINSTANCE.getTMemberWithAccessModifier_DeclaredMemberAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Get Member Access Modifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER_WITH_ACCESS_MODIFIER___GET_MEMBER_ACCESS_MODIFIER = eINSTANCE.getTMemberWithAccessModifier__GetMemberAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Get Default Member Access Modifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMEMBER_WITH_ACCESS_MODIFIER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = eINSTANCE.getTMemberWithAccessModifier__GetDefaultMemberAccessModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TStructMemberImpl <em>TStruct Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TStructMemberImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructMember()
		 * @generated
		 */
		EClass TSTRUCT_MEMBER = eINSTANCE.getTStructMember();

		/**
		 * The meta object literal for the '<em><b>Defined Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSTRUCT_MEMBER__DEFINED_MEMBER = eINSTANCE.getTStructMember_DefinedMember();

		/**
		 * The meta object literal for the '<em><b>Get Default Member Access Modifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSTRUCT_MEMBER___GET_DEFAULT_MEMBER_ACCESS_MODIFIER = eINSTANCE.getTStructMember__GetDefaultMemberAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSTRUCT_MEMBER___IS_STATIC = eINSTANCE.getTStructMember__IsStatic();

		/**
		 * The meta object literal for the '<em><b>Get Member Access Modifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSTRUCT_MEMBER___GET_MEMBER_ACCESS_MODIFIER = eINSTANCE.getTStructMember__GetMemberAccessModifier();

		/**
		 * The meta object literal for the '<em><b>Is AST Call Signature</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSTRUCT_MEMBER___IS_AST_CALL_SIGNATURE = eINSTANCE.getTStructMember__IsASTCallSignature();

		/**
		 * The meta object literal for the '<em><b>Is AST Construct Signature</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSTRUCT_MEMBER___IS_AST_CONSTRUCT_SIGNATURE = eINSTANCE.getTStructMember__IsASTConstructSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TMethodImpl <em>TMethod</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TMethodImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTMethod()
		 * @generated
		 */
		EClass TMETHOD = eINSTANCE.getTMethod();

		/**
		 * The meta object literal for the '<em><b>Declared Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMETHOD__DECLARED_ABSTRACT = eINSTANCE.getTMethod_DeclaredAbstract();

		/**
		 * The meta object literal for the '<em><b>Lacks This Or Super Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMETHOD__LACKS_THIS_OR_SUPER_USAGE = eINSTANCE.getTMethod_LacksThisOrSuperUsage();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMETHOD___IS_ABSTRACT = eINSTANCE.getTMethod__IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Get Member Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMETHOD___GET_MEMBER_TYPE = eINSTANCE.getTMethod__GetMemberType();

		/**
		 * The meta object literal for the '<em><b>Is Constructor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMETHOD___IS_CONSTRUCTOR = eINSTANCE.getTMethod__IsConstructor();

		/**
		 * The meta object literal for the '<em><b>Get Function As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMETHOD___GET_FUNCTION_AS_STRING = eINSTANCE.getTMethod__GetFunctionAsString();

		/**
		 * The meta object literal for the '<em><b>Get Member As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TMETHOD___GET_MEMBER_AS_STRING = eINSTANCE.getTMethod__GetMemberAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TStructMethodImpl <em>TStruct Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TStructMethodImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructMethod()
		 * @generated
		 */
		EClass TSTRUCT_METHOD = eINSTANCE.getTStructMethod();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TFormalParameterImpl <em>TFormal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TFormalParameterImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTFormalParameter()
		 * @generated
		 */
		EClass TFORMAL_PARAMETER = eINSTANCE.getTFormalParameter();

		/**
		 * The meta object literal for the '<em><b>Variadic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFORMAL_PARAMETER__VARIADIC = eINSTANCE.getTFormalParameter_Variadic();

		/**
		 * The meta object literal for the '<em><b>Ast Initializer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFORMAL_PARAMETER__AST_INITIALIZER = eINSTANCE.getTFormalParameter_AstInitializer();

		/**
		 * The meta object literal for the '<em><b>Has Initializer Assignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT = eINSTANCE.getTFormalParameter_HasInitializerAssignment();

		/**
		 * The meta object literal for the '<em><b>Has AST Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFORMAL_PARAMETER___HAS_AST_INITIALIZER = eINSTANCE.getTFormalParameter__HasASTInitializer();

		/**
		 * The meta object literal for the '<em><b>Is Optional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFORMAL_PARAMETER___IS_OPTIONAL = eINSTANCE.getTFormalParameter__IsOptional();

		/**
		 * The meta object literal for the '<em><b>Is Variadic Or Optional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFORMAL_PARAMETER___IS_VARIADIC_OR_OPTIONAL = eINSTANCE.getTFormalParameter__IsVariadicOrOptional();

		/**
		 * The meta object literal for the '<em><b>Get Formal Parameter As Types String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFORMAL_PARAMETER___GET_FORMAL_PARAMETER_AS_TYPES_STRING = eINSTANCE.getTFormalParameter__GetFormalParameterAsTypesString();

		/**
		 * The meta object literal for the '<em><b>Get Formal Parameter As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFORMAL_PARAMETER___GET_FORMAL_PARAMETER_AS_STRING = eINSTANCE.getTFormalParameter__GetFormalParameterAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TAnonymousFormalParameterImpl <em>TAnonymous Formal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TAnonymousFormalParameterImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAnonymousFormalParameter()
		 * @generated
		 */
		EClass TANONYMOUS_FORMAL_PARAMETER = eINSTANCE.getTAnonymousFormalParameter();

		/**
		 * The meta object literal for the '<em><b>Get Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TANONYMOUS_FORMAL_PARAMETER___GET_NAME = eINSTANCE.getTAnonymousFormalParameter__GetName();

		/**
		 * The meta object literal for the '<em><b>Get Defined Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TANONYMOUS_FORMAL_PARAMETER___GET_DEFINED_NAME = eINSTANCE.getTAnonymousFormalParameter__GetDefinedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TFieldImpl <em>TField</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TFieldImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTField()
		 * @generated
		 */
		EClass TFIELD = eINSTANCE.getTField();

		/**
		 * The meta object literal for the '<em><b>Has Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFIELD__HAS_EXPRESSION = eINSTANCE.getTField_HasExpression();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFIELD__OPTIONAL = eINSTANCE.getTField_Optional();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFIELD___IS_STATIC = eINSTANCE.getTField__IsStatic();

		/**
		 * The meta object literal for the '<em><b>Is Readable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFIELD___IS_READABLE = eINSTANCE.getTField__IsReadable();

		/**
		 * The meta object literal for the '<em><b>Is Writeable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFIELD___IS_WRITEABLE = eINSTANCE.getTField__IsWriteable();

		/**
		 * The meta object literal for the '<em><b>Get Member Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFIELD___GET_MEMBER_TYPE = eINSTANCE.getTField__GetMemberType();

		/**
		 * The meta object literal for the '<em><b>Get Member As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFIELD___GET_MEMBER_AS_STRING = eINSTANCE.getTField__GetMemberAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TStructFieldImpl <em>TStruct Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TStructFieldImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructField()
		 * @generated
		 */
		EClass TSTRUCT_FIELD = eINSTANCE.getTStructField();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.FieldAccessorImpl <em>Field Accessor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.FieldAccessorImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getFieldAccessor()
		 * @generated
		 */
		EClass FIELD_ACCESSOR = eINSTANCE.getFieldAccessor();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_ACCESSOR__OPTIONAL = eINSTANCE.getFieldAccessor_Optional();

		/**
		 * The meta object literal for the '<em><b>Declared Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_ACCESSOR__DECLARED_ABSTRACT = eINSTANCE.getFieldAccessor_DeclaredAbstract();

		/**
		 * The meta object literal for the '<em><b>Declared This Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD_ACCESSOR__DECLARED_THIS_TYPE = eINSTANCE.getFieldAccessor_DeclaredThisType();

		/**
		 * The meta object literal for the '<em><b>Get Type Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FIELD_ACCESSOR___GET_TYPE_REF = eINSTANCE.getFieldAccessor__GetTypeRef();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FIELD_ACCESSOR___IS_ABSTRACT = eINSTANCE.getFieldAccessor__IsAbstract();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TGetterImpl <em>TGetter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TGetterImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTGetter()
		 * @generated
		 */
		EClass TGETTER = eINSTANCE.getTGetter();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TGETTER__TYPE_REF = eINSTANCE.getTGetter_TypeRef();

		/**
		 * The meta object literal for the '<em><b>Get Member Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TGETTER___GET_MEMBER_TYPE = eINSTANCE.getTGetter__GetMemberType();

		/**
		 * The meta object literal for the '<em><b>Get Member As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TGETTER___GET_MEMBER_AS_STRING = eINSTANCE.getTGetter__GetMemberAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TStructGetterImpl <em>TStruct Getter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TStructGetterImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructGetter()
		 * @generated
		 */
		EClass TSTRUCT_GETTER = eINSTANCE.getTStructGetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TSetterImpl <em>TSetter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TSetterImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTSetter()
		 * @generated
		 */
		EClass TSETTER = eINSTANCE.getTSetter();

		/**
		 * The meta object literal for the '<em><b>Fpar</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSETTER__FPAR = eINSTANCE.getTSetter_Fpar();

		/**
		 * The meta object literal for the '<em><b>Get Type Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSETTER___GET_TYPE_REF = eINSTANCE.getTSetter__GetTypeRef();

		/**
		 * The meta object literal for the '<em><b>Is Readable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSETTER___IS_READABLE = eINSTANCE.getTSetter__IsReadable();

		/**
		 * The meta object literal for the '<em><b>Is Writeable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSETTER___IS_WRITEABLE = eINSTANCE.getTSetter__IsWriteable();

		/**
		 * The meta object literal for the '<em><b>Get Member Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSETTER___GET_MEMBER_TYPE = eINSTANCE.getTSetter__GetMemberType();

		/**
		 * The meta object literal for the '<em><b>Get Member As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSETTER___GET_MEMBER_AS_STRING = eINSTANCE.getTSetter__GetMemberAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TStructSetterImpl <em>TStruct Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TStructSetterImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTStructSetter()
		 * @generated
		 */
		EClass TSTRUCT_SETTER = eINSTANCE.getTStructSetter();

		/**
		 * The meta object literal for the '<em><b>Is Writeable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TSTRUCT_SETTER___IS_WRITEABLE = eINSTANCE.getTStructSetter__IsWriteable();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TEnumImpl <em>TEnum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TEnumImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTEnum()
		 * @generated
		 */
		EClass TENUM = eINSTANCE.getTEnum();

		/**
		 * The meta object literal for the '<em><b>External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TENUM__EXTERNAL = eINSTANCE.getTEnum_External();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TENUM__LITERALS = eINSTANCE.getTEnum_Literals();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TEnumLiteralImpl <em>TEnum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TEnumLiteralImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTEnumLiteral()
		 * @generated
		 */
		EClass TENUM_LITERAL = eINSTANCE.getTEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Value String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TENUM_LITERAL__VALUE_STRING = eINSTANCE.getTEnumLiteral_ValueString();

		/**
		 * The meta object literal for the '<em><b>Value Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TENUM_LITERAL__VALUE_NUMBER = eINSTANCE.getTEnumLiteral_ValueNumber();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TypeAliasImpl <em>Type Alias</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TypeAliasImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypeAlias()
		 * @generated
		 */
		EClass TYPE_ALIAS = eINSTANCE.getTypeAlias();

		/**
		 * The meta object literal for the '<em><b>Is Alias</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_ALIAS___IS_ALIAS = eINSTANCE.getTypeAlias__IsAlias();

		/**
		 * The meta object literal for the '<em><b>Is Hollow</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_ALIAS___IS_HOLLOW = eINSTANCE.getTypeAlias__IsHollow();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.SyntaxRelatedTElementImpl <em>Syntax Related TElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.SyntaxRelatedTElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getSyntaxRelatedTElement()
		 * @generated
		 */
		EClass SYNTAX_RELATED_TELEMENT = eINSTANCE.getSyntaxRelatedTElement();

		/**
		 * The meta object literal for the '<em><b>Ast Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNTAX_RELATED_TELEMENT__AST_ELEMENT = eINSTANCE.getSyntaxRelatedTElement_AstElement();

		/**
		 * The meta object literal for the '<em><b>Get Ast Element No Resolve</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SYNTAX_RELATED_TELEMENT___GET_AST_ELEMENT_NO_RESOLVE = eINSTANCE.getSyntaxRelatedTElement__GetAstElementNoResolve();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TConstableElementImpl <em>TConstable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TConstableElementImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTConstableElement()
		 * @generated
		 */
		EClass TCONSTABLE_ELEMENT = eINSTANCE.getTConstableElement();

		/**
		 * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCONSTABLE_ELEMENT__CONST = eINSTANCE.getTConstableElement_Const();

		/**
		 * The meta object literal for the '<em><b>Compile Time Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCONSTABLE_ELEMENT__COMPILE_TIME_VALUE = eINSTANCE.getTConstableElement_CompileTimeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TAbstractVariableImpl <em>TAbstract Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TAbstractVariableImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTAbstractVariable()
		 * @generated
		 */
		EClass TABSTRACT_VARIABLE = eINSTANCE.getTAbstractVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.impl.TVariableImpl <em>TVariable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.impl.TVariableImpl
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTVariable()
		 * @generated
		 */
		EClass TVARIABLE = eINSTANCE.getTVariable();

		/**
		 * The meta object literal for the '<em><b>External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TVARIABLE__EXTERNAL = eINSTANCE.getTVariable_External();

		/**
		 * The meta object literal for the '<em><b>Object Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TVARIABLE__OBJECT_LITERAL = eINSTANCE.getTVariable_ObjectLiteral();

		/**
		 * The meta object literal for the '<em><b>New Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TVARIABLE__NEW_EXPRESSION = eINSTANCE.getTVariable_NewExpression();

		/**
		 * The meta object literal for the '<em><b>Get Variable As String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TVARIABLE___GET_VARIABLE_AS_STRING = eINSTANCE.getTVariable__GetVariableAsString();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.TypingStrategy <em>Typing Strategy</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.TypingStrategy
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypingStrategy()
		 * @generated
		 */
		EEnum TYPING_STRATEGY = eINSTANCE.getTypingStrategy();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.TypeAccessModifier <em>Type Access Modifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.TypeAccessModifier
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTypeAccessModifier()
		 * @generated
		 */
		EEnum TYPE_ACCESS_MODIFIER = eINSTANCE.getTypeAccessModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.MemberAccessModifier <em>Member Access Modifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.MemberAccessModifier
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getMemberAccessModifier()
		 * @generated
		 */
		EEnum MEMBER_ACCESS_MODIFIER = eINSTANCE.getMemberAccessModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.n4js.ts.types.MemberType <em>Member Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.MemberType
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getMemberType()
		 * @generated
		 */
		EEnum MEMBER_TYPE = eINSTANCE.getMemberType();

		/**
		 * The meta object literal for the '<em>Iterable Of TExportable Element</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIterableOfTExportableElement()
		 * @generated
		 */
		EDataType ITERABLE_OF_TEXPORTABLE_ELEMENT = eINSTANCE.getIterableOfTExportableElement();

		/**
		 * The meta object literal for the '<em>Iterable Of Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIterableOfType()
		 * @generated
		 */
		EDataType ITERABLE_OF_TYPE = eINSTANCE.getIterableOfType();

		/**
		 * The meta object literal for the '<em>Iterable Of Abstract Namespace</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIterableOfAbstractNamespace()
		 * @generated
		 */
		EDataType ITERABLE_OF_ABSTRACT_NAMESPACE = eINSTANCE.getIterableOfAbstractNamespace();

		/**
		 * The meta object literal for the '<em>Parameterized Type Ref Iterable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getParameterizedTypeRefIterable()
		 * @generated
		 */
		EDataType PARAMETERIZED_TYPE_REF_ITERABLE = eINSTANCE.getParameterizedTypeRefIterable();

		/**
		 * The meta object literal for the '<em>Iterable Of TClassifier</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getIterableOfTClassifier()
		 * @generated
		 */
		EDataType ITERABLE_OF_TCLASSIFIER = eINSTANCE.getIterableOfTClassifier();

		/**
		 * The meta object literal for the '<em>Variance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.util.Variance
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getVariance()
		 * @generated
		 */
		EDataType VARIANCE = eINSTANCE.getVariance();

		/**
		 * The meta object literal for the '<em>Name And Access</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.n4js.ts.types.NameAndAccess
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getNameAndAccess()
		 * @generated
		 */
		EDataType NAME_AND_ACCESS = eINSTANCE.getNameAndAccess();

		/**
		 * The meta object literal for the '<em>Member List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getMemberList()
		 * @generated
		 */
		EDataType MEMBER_LIST = eINSTANCE.getMemberList();

		/**
		 * The meta object literal for the '<em>TClassifier Iterable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.n4js.ts.types.impl.TypesPackageImpl#getTClassifierIterable()
		 * @generated
		 */
		EDataType TCLASSIFIER_ITERABLE = eINSTANCE.getTClassifierIterable();

	}

} //TypesPackage
