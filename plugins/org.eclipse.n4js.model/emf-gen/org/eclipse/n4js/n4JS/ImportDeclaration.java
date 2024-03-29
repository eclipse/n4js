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
package org.eclipse.n4js.n4JS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.ImportDeclaration#getImportSpecifiers <em>Import Specifiers</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.ImportDeclaration#isImportFrom <em>Import From</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.n4JS.N4JSPackage#getImportDeclaration()
 * @model
 * @generated
 */
public interface ImportDeclaration extends AnnotableScriptElement, ModuleRef {
	/**
	 * Returns the value of the '<em><b>Import Specifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.n4js.n4JS.ImportSpecifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Specifiers</em>' containment reference list.
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getImportDeclaration_ImportSpecifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportSpecifier> getImportSpecifiers();

	/**
	 * Returns the value of the '<em><b>Import From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import From</em>' attribute.
	 * @see #setImportFrom(boolean)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getImportDeclaration_ImportFrom()
	 * @model unique="false"
	 * @generated
	 */
	boolean isImportFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.ImportDeclaration#isImportFrom <em>Import From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import From</em>' attribute.
	 * @see #isImportFrom()
	 * @generated
	 */
	void setImportFrom(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if this import is a so-called "bare import" of the form:
	 * <pre>
	 * import "path/to/SomeModule"
	 * </pre>
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isBare();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells whether this import declaration will be present in the transpiled output code.
	 * Derived from {@link ImportSpecifier#isRetainedAtRuntime() retainedAtRuntime} and
	 * therefore only valid after AST traversal has completed.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isRetainedAtRuntime();

} // ImportDeclaration
