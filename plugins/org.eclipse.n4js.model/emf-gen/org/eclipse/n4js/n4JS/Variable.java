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

import org.eclipse.n4js.ts.types.TAbstractVariable;
import org.eclipse.n4js.ts.types.TypableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 *  Abstract super type of declared variables (VariableDeclaration), formal parameters (FormalParameter),
 * and variables declared in catch clause (CatchVariable). Variables may be used on the left-hand side
 * of assignments. Note that variables are also named (NamedElement) and typed (TypedElement).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.Variable#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.Variable#getDefinedVariable <em>Defined Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.n4JS.N4JSPackage#getVariable()
 * @model abstract="true"
 * @generated
 */
public interface Variable<T extends TAbstractVariable> extends TypedElement, TypableElement, NamedElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getVariable_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.Variable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Defined Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Variable</em>' reference.
	 * @see #setDefinedVariable(TAbstractVariable)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getVariable_DefinedVariable()
	 * @model transient="true"
	 * @generated
	 */
	T getDefinedVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.Variable#getDefinedVariable <em>Defined Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defined Variable</em>' reference.
	 * @see #getDefinedVariable()
	 * @generated
	 */
	void setDefinedVariable(T value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns true if variable is defined as const. This is only true for variables declared in const statement.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isConst();

} // Variable
