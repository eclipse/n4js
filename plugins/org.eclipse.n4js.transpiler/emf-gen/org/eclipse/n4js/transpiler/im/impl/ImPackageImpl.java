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
package org.eclipse.n4js.transpiler.im.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.n4js.n4JS.N4JSPackage;

import org.eclipse.n4js.transpiler.im.DelegatingGetterDeclaration;
import org.eclipse.n4js.transpiler.im.DelegatingMember;
import org.eclipse.n4js.transpiler.im.DelegatingMethodDeclaration;
import org.eclipse.n4js.transpiler.im.DelegatingSetterDeclaration;
import org.eclipse.n4js.transpiler.im.IdentifierRef_IM;
import org.eclipse.n4js.transpiler.im.ImFactory;
import org.eclipse.n4js.transpiler.im.ImPackage;
import org.eclipse.n4js.transpiler.im.ManyReferencingElement_IM;
import org.eclipse.n4js.transpiler.im.ParameterizedPropertyAccessExpression_IM;
import org.eclipse.n4js.transpiler.im.PlainReference;
import org.eclipse.n4js.transpiler.im.ReferencingElementExpression_IM;
import org.eclipse.n4js.transpiler.im.ReferencingElement_IM;
import org.eclipse.n4js.transpiler.im.Script_IM;
import org.eclipse.n4js.transpiler.im.Snippet;
import org.eclipse.n4js.transpiler.im.StringLiteralForSTE;
import org.eclipse.n4js.transpiler.im.SymbolTable;
import org.eclipse.n4js.transpiler.im.SymbolTableEntry;
import org.eclipse.n4js.transpiler.im.SymbolTableEntryIMOnly;
import org.eclipse.n4js.transpiler.im.SymbolTableEntryInternal;
import org.eclipse.n4js.transpiler.im.SymbolTableEntryOriginal;
import org.eclipse.n4js.transpiler.im.TypeReferenceNode_IM;

import org.eclipse.n4js.ts.typeRefs.TypeRefsPackage;

import org.eclipse.n4js.ts.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImPackageImpl extends EPackageImpl implements ImPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass script_IMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolTableEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolTableEntryOriginalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolTableEntryIMOnlyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolTableEntryInternalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencingElement_IMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass manyReferencingElement_IMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plainReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencingElementExpression_IMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierRef_IMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterizedPropertyAccessExpression_IMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeReferenceNode_IMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snippetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegatingMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegatingGetterDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegatingSetterDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegatingMethodDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralForSTEEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.n4js.transpiler.im.ImPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImPackageImpl() {
		super(eNS_URI, ImFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ImPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImPackage init() {
		if (isInited) return (ImPackage)EPackage.Registry.INSTANCE.getEPackage(ImPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredImPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ImPackageImpl theImPackage = registeredImPackage instanceof ImPackageImpl ? (ImPackageImpl)registeredImPackage : new ImPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		N4JSPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		TypeRefsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImPackage.createPackageContents();

		// Initialize created meta-data
		theImPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImPackage.eNS_URI, theImPackage);
		return theImPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScript_IM() {
		return script_IMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScript_IM_SymbolTable() {
		return (EReference)script_IMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSymbolTable() {
		return symbolTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSymbolTable_Entries() {
		return (EReference)symbolTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSymbolTableEntry() {
		return symbolTableEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSymbolTableEntry_Name() {
		return (EAttribute)symbolTableEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSymbolTableEntry_ElementsOfThisName() {
		return (EReference)symbolTableEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSymbolTableEntry_ReferencingElements() {
		return (EReference)symbolTableEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSymbolTableEntryOriginal() {
		return symbolTableEntryOriginalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSymbolTableEntryOriginal_OriginalTarget() {
		return (EReference)symbolTableEntryOriginalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSymbolTableEntryOriginal_ImportSpecifier() {
		return (EReference)symbolTableEntryOriginalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSymbolTableEntryOriginal__GetExportedName() {
		return symbolTableEntryOriginalEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSymbolTableEntryIMOnly() {
		return symbolTableEntryIMOnlyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSymbolTableEntryInternal() {
		return symbolTableEntryInternalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReferencingElement_IM() {
		return referencingElement_IMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReferencingElement_IM_RewiredTarget() {
		return (EReference)referencingElement_IMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReferencingElement_IM__GetOriginalTargetOfRewiredTarget() {
		return referencingElement_IMEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getManyReferencingElement_IM() {
		return manyReferencingElement_IMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getManyReferencingElement_IM_RewiredReferences() {
		return (EReference)manyReferencingElement_IMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getManyReferencingElement_IM__GetRewiredTargets() {
		return manyReferencingElement_IMEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getManyReferencingElement_IM__AddRewiredTarget__SymbolTableEntry() {
		return manyReferencingElement_IMEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getManyReferencingElement_IM__RemoveRewiredTarget__SymbolTableEntry() {
		return manyReferencingElement_IMEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPlainReference() {
		return plainReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReferencingElementExpression_IM() {
		return referencingElementExpression_IMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentifierRef_IM() {
		return identifierRef_IMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIdentifierRef_IM__GetId_IM() {
		return identifierRef_IMEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIdentifierRef_IM__SetId_IM__SymbolTableEntry() {
		return identifierRef_IMEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIdentifierRef_IM__GetId() {
		return identifierRef_IMEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIdentifierRef_IM__SetId__IdentifiableElement() {
		return identifierRef_IMEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameterizedPropertyAccessExpression_IM() {
		return parameterizedPropertyAccessExpression_IMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameterizedPropertyAccessExpression_IM_AnyPlusAccess() {
		return (EAttribute)parameterizedPropertyAccessExpression_IMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameterizedPropertyAccessExpression_IM_NameOfAnyPlusProperty() {
		return (EAttribute)parameterizedPropertyAccessExpression_IMEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameterizedPropertyAccessExpression_IM__GetProperty_IM() {
		return parameterizedPropertyAccessExpression_IMEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameterizedPropertyAccessExpression_IM__SetProperty_IM__SymbolTableEntry() {
		return parameterizedPropertyAccessExpression_IMEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameterizedPropertyAccessExpression_IM__GetPropertyName() {
		return parameterizedPropertyAccessExpression_IMEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameterizedPropertyAccessExpression_IM__GetProperty() {
		return parameterizedPropertyAccessExpression_IMEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameterizedPropertyAccessExpression_IM__SetProperty__IdentifiableElement() {
		return parameterizedPropertyAccessExpression_IMEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeReferenceNode_IM() {
		return typeReferenceNode_IMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypeReferenceNode_IM_CodeToEmit() {
		return (EAttribute)typeReferenceNode_IMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTypeReferenceNode_IM__GetRewiredReferences() {
		return typeReferenceNode_IMEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTypeReferenceNode_IM__GetTypeRef() {
		return typeReferenceNode_IMEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTypeReferenceNode_IM__GetCachedProcessedTypeRef() {
		return typeReferenceNode_IMEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSnippet() {
		return snippetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnippet_CodeToEmit() {
		return (EAttribute)snippetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDelegatingMember() {
		return delegatingMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDelegatingMember_DelegationBaseType() {
		return (EReference)delegatingMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDelegatingMember_DelegationSuperClassSteps() {
		return (EAttribute)delegatingMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDelegatingMember_DelegationTarget() {
		return (EReference)delegatingMemberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDelegatingMember_DelegationTargetIsAbstract() {
		return (EAttribute)delegatingMemberEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDelegatingGetterDeclaration() {
		return delegatingGetterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDelegatingSetterDeclaration() {
		return delegatingSetterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDelegatingMethodDeclaration() {
		return delegatingMethodDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringLiteralForSTE() {
		return stringLiteralForSTEEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStringLiteralForSTE_Entry() {
		return (EReference)stringLiteralForSTEEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringLiteralForSTE_UseExportedName() {
		return (EAttribute)stringLiteralForSTEEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getStringLiteralForSTE__GetValueAsString() {
		return stringLiteralForSTEEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImFactory getImFactory() {
		return (ImFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		script_IMEClass = createEClass(SCRIPT_IM);
		createEReference(script_IMEClass, SCRIPT_IM__SYMBOL_TABLE);

		symbolTableEClass = createEClass(SYMBOL_TABLE);
		createEReference(symbolTableEClass, SYMBOL_TABLE__ENTRIES);

		symbolTableEntryEClass = createEClass(SYMBOL_TABLE_ENTRY);
		createEAttribute(symbolTableEntryEClass, SYMBOL_TABLE_ENTRY__NAME);
		createEReference(symbolTableEntryEClass, SYMBOL_TABLE_ENTRY__ELEMENTS_OF_THIS_NAME);
		createEReference(symbolTableEntryEClass, SYMBOL_TABLE_ENTRY__REFERENCING_ELEMENTS);

		symbolTableEntryOriginalEClass = createEClass(SYMBOL_TABLE_ENTRY_ORIGINAL);
		createEReference(symbolTableEntryOriginalEClass, SYMBOL_TABLE_ENTRY_ORIGINAL__ORIGINAL_TARGET);
		createEReference(symbolTableEntryOriginalEClass, SYMBOL_TABLE_ENTRY_ORIGINAL__IMPORT_SPECIFIER);
		createEOperation(symbolTableEntryOriginalEClass, SYMBOL_TABLE_ENTRY_ORIGINAL___GET_EXPORTED_NAME);

		symbolTableEntryIMOnlyEClass = createEClass(SYMBOL_TABLE_ENTRY_IM_ONLY);

		symbolTableEntryInternalEClass = createEClass(SYMBOL_TABLE_ENTRY_INTERNAL);

		referencingElement_IMEClass = createEClass(REFERENCING_ELEMENT_IM);
		createEReference(referencingElement_IMEClass, REFERENCING_ELEMENT_IM__REWIRED_TARGET);
		createEOperation(referencingElement_IMEClass, REFERENCING_ELEMENT_IM___GET_ORIGINAL_TARGET_OF_REWIRED_TARGET);

		manyReferencingElement_IMEClass = createEClass(MANY_REFERENCING_ELEMENT_IM);
		createEReference(manyReferencingElement_IMEClass, MANY_REFERENCING_ELEMENT_IM__REWIRED_REFERENCES);
		createEOperation(manyReferencingElement_IMEClass, MANY_REFERENCING_ELEMENT_IM___GET_REWIRED_TARGETS);
		createEOperation(manyReferencingElement_IMEClass, MANY_REFERENCING_ELEMENT_IM___ADD_REWIRED_TARGET__SYMBOLTABLEENTRY);
		createEOperation(manyReferencingElement_IMEClass, MANY_REFERENCING_ELEMENT_IM___REMOVE_REWIRED_TARGET__SYMBOLTABLEENTRY);

		plainReferenceEClass = createEClass(PLAIN_REFERENCE);

		referencingElementExpression_IMEClass = createEClass(REFERENCING_ELEMENT_EXPRESSION_IM);

		identifierRef_IMEClass = createEClass(IDENTIFIER_REF_IM);
		createEOperation(identifierRef_IMEClass, IDENTIFIER_REF_IM___GET_ID_IM);
		createEOperation(identifierRef_IMEClass, IDENTIFIER_REF_IM___SET_ID_IM__SYMBOLTABLEENTRY);
		createEOperation(identifierRef_IMEClass, IDENTIFIER_REF_IM___GET_ID);
		createEOperation(identifierRef_IMEClass, IDENTIFIER_REF_IM___SET_ID__IDENTIFIABLEELEMENT);

		parameterizedPropertyAccessExpression_IMEClass = createEClass(PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM);
		createEAttribute(parameterizedPropertyAccessExpression_IMEClass, PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM__ANY_PLUS_ACCESS);
		createEAttribute(parameterizedPropertyAccessExpression_IMEClass, PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM__NAME_OF_ANY_PLUS_PROPERTY);
		createEOperation(parameterizedPropertyAccessExpression_IMEClass, PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM___GET_PROPERTY_IM);
		createEOperation(parameterizedPropertyAccessExpression_IMEClass, PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM___SET_PROPERTY_IM__SYMBOLTABLEENTRY);
		createEOperation(parameterizedPropertyAccessExpression_IMEClass, PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM___GET_PROPERTY_NAME);
		createEOperation(parameterizedPropertyAccessExpression_IMEClass, PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM___GET_PROPERTY);
		createEOperation(parameterizedPropertyAccessExpression_IMEClass, PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM___SET_PROPERTY__IDENTIFIABLEELEMENT);

		typeReferenceNode_IMEClass = createEClass(TYPE_REFERENCE_NODE_IM);
		createEAttribute(typeReferenceNode_IMEClass, TYPE_REFERENCE_NODE_IM__CODE_TO_EMIT);
		createEOperation(typeReferenceNode_IMEClass, TYPE_REFERENCE_NODE_IM___GET_REWIRED_REFERENCES);
		createEOperation(typeReferenceNode_IMEClass, TYPE_REFERENCE_NODE_IM___GET_TYPE_REF);
		createEOperation(typeReferenceNode_IMEClass, TYPE_REFERENCE_NODE_IM___GET_CACHED_PROCESSED_TYPE_REF);

		snippetEClass = createEClass(SNIPPET);
		createEAttribute(snippetEClass, SNIPPET__CODE_TO_EMIT);

		delegatingMemberEClass = createEClass(DELEGATING_MEMBER);
		createEReference(delegatingMemberEClass, DELEGATING_MEMBER__DELEGATION_BASE_TYPE);
		createEAttribute(delegatingMemberEClass, DELEGATING_MEMBER__DELEGATION_SUPER_CLASS_STEPS);
		createEReference(delegatingMemberEClass, DELEGATING_MEMBER__DELEGATION_TARGET);
		createEAttribute(delegatingMemberEClass, DELEGATING_MEMBER__DELEGATION_TARGET_IS_ABSTRACT);

		delegatingGetterDeclarationEClass = createEClass(DELEGATING_GETTER_DECLARATION);

		delegatingSetterDeclarationEClass = createEClass(DELEGATING_SETTER_DECLARATION);

		delegatingMethodDeclarationEClass = createEClass(DELEGATING_METHOD_DECLARATION);

		stringLiteralForSTEEClass = createEClass(STRING_LITERAL_FOR_STE);
		createEReference(stringLiteralForSTEEClass, STRING_LITERAL_FOR_STE__ENTRY);
		createEAttribute(stringLiteralForSTEEClass, STRING_LITERAL_FOR_STE__USE_EXPORTED_NAME);
		createEOperation(stringLiteralForSTEEClass, STRING_LITERAL_FOR_STE___GET_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		N4JSPackage theN4JSPackage = (N4JSPackage)EPackage.Registry.INSTANCE.getEPackage(N4JSPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		TypeRefsPackage theTypeRefsPackage = (TypeRefsPackage)EPackage.Registry.INSTANCE.getEPackage(TypeRefsPackage.eNS_URI);

		// Create type parameters
		ETypeParameter typeReferenceNode_IMEClass_T = addETypeParameter(typeReferenceNode_IMEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theTypeRefsPackage.getTypeRef());
		typeReferenceNode_IMEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		script_IMEClass.getESuperTypes().add(theN4JSPackage.getScript());
		symbolTableEntryOriginalEClass.getESuperTypes().add(this.getSymbolTableEntry());
		symbolTableEntryIMOnlyEClass.getESuperTypes().add(this.getSymbolTableEntry());
		symbolTableEntryInternalEClass.getESuperTypes().add(this.getSymbolTableEntry());
		plainReferenceEClass.getESuperTypes().add(this.getReferencingElement_IM());
		referencingElementExpression_IMEClass.getESuperTypes().add(this.getReferencingElement_IM());
		referencingElementExpression_IMEClass.getESuperTypes().add(theN4JSPackage.getExpression());
		identifierRef_IMEClass.getESuperTypes().add(theN4JSPackage.getIdentifierRef());
		identifierRef_IMEClass.getESuperTypes().add(this.getReferencingElementExpression_IM());
		parameterizedPropertyAccessExpression_IMEClass.getESuperTypes().add(theN4JSPackage.getParameterizedPropertyAccessExpression());
		parameterizedPropertyAccessExpression_IMEClass.getESuperTypes().add(this.getReferencingElementExpression_IM());
		g1 = createEGenericType(theN4JSPackage.getTypeReferenceNode());
		EGenericType g2 = createEGenericType(typeReferenceNode_IMEClass_T);
		g1.getETypeArguments().add(g2);
		typeReferenceNode_IMEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getManyReferencingElement_IM());
		typeReferenceNode_IMEClass.getEGenericSuperTypes().add(g1);
		snippetEClass.getESuperTypes().add(theN4JSPackage.getExpression());
		delegatingMemberEClass.getESuperTypes().add(theN4JSPackage.getN4MemberDeclaration());
		delegatingGetterDeclarationEClass.getESuperTypes().add(theN4JSPackage.getN4GetterDeclaration());
		delegatingGetterDeclarationEClass.getESuperTypes().add(this.getDelegatingMember());
		delegatingSetterDeclarationEClass.getESuperTypes().add(theN4JSPackage.getN4SetterDeclaration());
		delegatingSetterDeclarationEClass.getESuperTypes().add(this.getDelegatingMember());
		delegatingMethodDeclarationEClass.getESuperTypes().add(theN4JSPackage.getN4MethodDeclaration());
		delegatingMethodDeclarationEClass.getESuperTypes().add(this.getDelegatingMember());
		stringLiteralForSTEEClass.getESuperTypes().add(theN4JSPackage.getStringLiteral());

		// Initialize classes, features, and operations; add parameters
		initEClass(script_IMEClass, Script_IM.class, "Script_IM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScript_IM_SymbolTable(), this.getSymbolTable(), null, "symbolTable", null, 0, 1, Script_IM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(symbolTableEClass, SymbolTable.class, "SymbolTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSymbolTable_Entries(), this.getSymbolTableEntry(), null, "entries", null, 0, -1, SymbolTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(symbolTableEntryEClass, SymbolTableEntry.class, "SymbolTableEntry", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSymbolTableEntry_Name(), theEcorePackage.getEString(), "name", null, 0, 1, SymbolTableEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymbolTableEntry_ElementsOfThisName(), theN4JSPackage.getNamedElement(), null, "elementsOfThisName", null, 0, -1, SymbolTableEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymbolTableEntry_ReferencingElements(), this.getReferencingElement_IM(), this.getReferencingElement_IM_RewiredTarget(), "referencingElements", null, 0, -1, SymbolTableEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(symbolTableEntryOriginalEClass, SymbolTableEntryOriginal.class, "SymbolTableEntryOriginal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSymbolTableEntryOriginal_OriginalTarget(), theTypesPackage.getIdentifiableElement(), null, "originalTarget", null, 0, 1, SymbolTableEntryOriginal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymbolTableEntryOriginal_ImportSpecifier(), theN4JSPackage.getImportSpecifier(), null, "importSpecifier", null, 0, 1, SymbolTableEntryOriginal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSymbolTableEntryOriginal__GetExportedName(), theEcorePackage.getEString(), "getExportedName", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(symbolTableEntryIMOnlyEClass, SymbolTableEntryIMOnly.class, "SymbolTableEntryIMOnly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(symbolTableEntryInternalEClass, SymbolTableEntryInternal.class, "SymbolTableEntryInternal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referencingElement_IMEClass, ReferencingElement_IM.class, "ReferencingElement_IM", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferencingElement_IM_RewiredTarget(), this.getSymbolTableEntry(), this.getSymbolTableEntry_ReferencingElements(), "rewiredTarget", null, 0, 1, ReferencingElement_IM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReferencingElement_IM__GetOriginalTargetOfRewiredTarget(), theTypesPackage.getIdentifiableElement(), "getOriginalTargetOfRewiredTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(manyReferencingElement_IMEClass, ManyReferencingElement_IM.class, "ManyReferencingElement_IM", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getManyReferencingElement_IM_RewiredReferences(), this.getPlainReference(), null, "rewiredReferences", null, 0, -1, ManyReferencingElement_IM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getManyReferencingElement_IM__GetRewiredTargets(), this.getSymbolTableEntry(), "getRewiredTargets", 0, -1, !IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getManyReferencingElement_IM__AddRewiredTarget__SymbolTableEntry(), null, "addRewiredTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSymbolTableEntry(), "ste", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getManyReferencingElement_IM__RemoveRewiredTarget__SymbolTableEntry(), null, "removeRewiredTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSymbolTableEntry(), "ste", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(plainReferenceEClass, PlainReference.class, "PlainReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referencingElementExpression_IMEClass, ReferencingElementExpression_IM.class, "ReferencingElementExpression_IM", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(identifierRef_IMEClass, IdentifierRef_IM.class, "IdentifierRef_IM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getIdentifierRef_IM__GetId_IM(), this.getSymbolTableEntry(), "getId_IM", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIdentifierRef_IM__SetId_IM__SymbolTableEntry(), null, "setId_IM", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSymbolTableEntry(), "target", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getIdentifierRef_IM__GetId(), theTypesPackage.getIdentifiableElement(), "getId", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIdentifierRef_IM__SetId__IdentifiableElement(), null, "setId", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTypesPackage.getIdentifiableElement(), "ix", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(parameterizedPropertyAccessExpression_IMEClass, ParameterizedPropertyAccessExpression_IM.class, "ParameterizedPropertyAccessExpression_IM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterizedPropertyAccessExpression_IM_AnyPlusAccess(), theEcorePackage.getEBoolean(), "anyPlusAccess", null, 0, 1, ParameterizedPropertyAccessExpression_IM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterizedPropertyAccessExpression_IM_NameOfAnyPlusProperty(), theEcorePackage.getEString(), "nameOfAnyPlusProperty", null, 0, 1, ParameterizedPropertyAccessExpression_IM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getParameterizedPropertyAccessExpression_IM__GetProperty_IM(), this.getSymbolTableEntry(), "getProperty_IM", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getParameterizedPropertyAccessExpression_IM__SetProperty_IM__SymbolTableEntry(), null, "setProperty_IM", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSymbolTableEntry(), "target", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getParameterizedPropertyAccessExpression_IM__GetPropertyName(), theEcorePackage.getEString(), "getPropertyName", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getParameterizedPropertyAccessExpression_IM__GetProperty(), theTypesPackage.getIdentifiableElement(), "getProperty", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getParameterizedPropertyAccessExpression_IM__SetProperty__IdentifiableElement(), null, "setProperty", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTypesPackage.getIdentifiableElement(), "ix", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(typeReferenceNode_IMEClass, TypeReferenceNode_IM.class, "TypeReferenceNode_IM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeReferenceNode_IM_CodeToEmit(), theEcorePackage.getEString(), "codeToEmit", null, 0, 1, TypeReferenceNode_IM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTypeReferenceNode_IM__GetRewiredReferences(), this.getPlainReference(), "getRewiredReferences", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTypeReferenceNode_IM__GetTypeRef(), theTypeRefsPackage.getTypeRef(), "getTypeRef", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTypeReferenceNode_IM__GetCachedProcessedTypeRef(), theTypeRefsPackage.getTypeRef(), "getCachedProcessedTypeRef", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(snippetEClass, Snippet.class, "Snippet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSnippet_CodeToEmit(), theEcorePackage.getEString(), "codeToEmit", null, 0, 1, Snippet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(delegatingMemberEClass, DelegatingMember.class, "DelegatingMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelegatingMember_DelegationBaseType(), this.getSymbolTableEntryOriginal(), null, "delegationBaseType", null, 0, 1, DelegatingMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDelegatingMember_DelegationSuperClassSteps(), theEcorePackage.getEInt(), "delegationSuperClassSteps", null, 0, 1, DelegatingMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelegatingMember_DelegationTarget(), this.getSymbolTableEntryOriginal(), null, "delegationTarget", null, 0, 1, DelegatingMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDelegatingMember_DelegationTargetIsAbstract(), theEcorePackage.getEBoolean(), "delegationTargetIsAbstract", null, 0, 1, DelegatingMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(delegatingGetterDeclarationEClass, DelegatingGetterDeclaration.class, "DelegatingGetterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(delegatingSetterDeclarationEClass, DelegatingSetterDeclaration.class, "DelegatingSetterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(delegatingMethodDeclarationEClass, DelegatingMethodDeclaration.class, "DelegatingMethodDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringLiteralForSTEEClass, StringLiteralForSTE.class, "StringLiteralForSTE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringLiteralForSTE_Entry(), this.getSymbolTableEntry(), null, "entry", null, 0, 1, StringLiteralForSTE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringLiteralForSTE_UseExportedName(), theEcorePackage.getEBoolean(), "useExportedName", null, 0, 1, StringLiteralForSTE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getStringLiteralForSTE__GetValueAsString(), theEcorePackage.getEString(), "getValueAsString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ImPackageImpl
