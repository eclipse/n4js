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
package org.eclipse.n4js.transpiler.im;

import org.eclipse.emf.ecore.EFactory;

import org.eclipse.n4js.ts.typeRefs.TypeRef;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.n4js.transpiler.im.ImPackage
 * @generated
 */
public interface ImFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImFactory eINSTANCE = org.eclipse.n4js.transpiler.im.impl.ImFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Script IM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script IM</em>'.
	 * @generated
	 */
	Script_IM createScript_IM();

	/**
	 * Returns a new object of class '<em>Symbol Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbol Table</em>'.
	 * @generated
	 */
	SymbolTable createSymbolTable();

	/**
	 * Returns a new object of class '<em>Symbol Table Entry Original</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbol Table Entry Original</em>'.
	 * @generated
	 */
	SymbolTableEntryOriginal createSymbolTableEntryOriginal();

	/**
	 * Returns a new object of class '<em>Symbol Table Entry IM Only</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbol Table Entry IM Only</em>'.
	 * @generated
	 */
	SymbolTableEntryIMOnly createSymbolTableEntryIMOnly();

	/**
	 * Returns a new object of class '<em>Symbol Table Entry Internal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbol Table Entry Internal</em>'.
	 * @generated
	 */
	SymbolTableEntryInternal createSymbolTableEntryInternal();

	/**
	 * Returns a new object of class '<em>Plain Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plain Reference</em>'.
	 * @generated
	 */
	PlainReference createPlainReference();

	/**
	 * Returns a new object of class '<em>Identifier Ref IM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier Ref IM</em>'.
	 * @generated
	 */
	IdentifierRef_IM createIdentifierRef_IM();

	/**
	 * Returns a new object of class '<em>Parameterized Property Access Expression IM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameterized Property Access Expression IM</em>'.
	 * @generated
	 */
	ParameterizedPropertyAccessExpression_IM createParameterizedPropertyAccessExpression_IM();

	/**
	 * Returns a new object of class '<em>Type Reference Node IM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Reference Node IM</em>'.
	 * @generated
	 */
	<T extends TypeRef> TypeReferenceNode_IM<T> createTypeReferenceNode_IM();

	/**
	 * Returns a new object of class '<em>Snippet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snippet</em>'.
	 * @generated
	 */
	Snippet createSnippet();

	/**
	 * Returns a new object of class '<em>Delegating Getter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delegating Getter Declaration</em>'.
	 * @generated
	 */
	DelegatingGetterDeclaration createDelegatingGetterDeclaration();

	/**
	 * Returns a new object of class '<em>Delegating Setter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delegating Setter Declaration</em>'.
	 * @generated
	 */
	DelegatingSetterDeclaration createDelegatingSetterDeclaration();

	/**
	 * Returns a new object of class '<em>Delegating Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delegating Method Declaration</em>'.
	 * @generated
	 */
	DelegatingMethodDeclaration createDelegatingMethodDeclaration();

	/**
	 * Returns a new object of class '<em>String Literal For STE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal For STE</em>'.
	 * @generated
	 */
	StringLiteralForSTE createStringLiteralForSTE();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImPackage getImPackage();

} //ImFactory
