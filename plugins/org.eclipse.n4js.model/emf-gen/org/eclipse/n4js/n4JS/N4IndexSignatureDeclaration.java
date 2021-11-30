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

import org.eclipse.n4js.ts.typeRefs.TypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>N4 Index Signature Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.N4IndexSignatureDeclaration#getDeclaredIndexTypeRefNode <em>Declared Index Type Ref Node</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.N4IndexSignatureDeclaration#getDeclaredValueTypeRefNode <em>Declared Value Type Ref Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.n4JS.N4JSPackage#getN4IndexSignatureDeclaration()
 * @model
 * @generated
 */
public interface N4IndexSignatureDeclaration extends AnnotableN4MemberDeclaration {
	/**
	 * Returns the value of the '<em><b>Declared Index Type Ref Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Index Type Ref Node</em>' containment reference.
	 * @see #setDeclaredIndexTypeRefNode(TypeReferenceNode)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getN4IndexSignatureDeclaration_DeclaredIndexTypeRefNode()
	 * @model containment="true"
	 * @generated
	 */
	TypeReferenceNode<TypeRef> getDeclaredIndexTypeRefNode();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.N4IndexSignatureDeclaration#getDeclaredIndexTypeRefNode <em>Declared Index Type Ref Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Index Type Ref Node</em>' containment reference.
	 * @see #getDeclaredIndexTypeRefNode()
	 * @generated
	 */
	void setDeclaredIndexTypeRefNode(TypeReferenceNode<TypeRef> value);

	/**
	 * Returns the value of the '<em><b>Declared Value Type Ref Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Value Type Ref Node</em>' containment reference.
	 * @see #setDeclaredValueTypeRefNode(TypeReferenceNode)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getN4IndexSignatureDeclaration_DeclaredValueTypeRefNode()
	 * @model containment="true"
	 * @generated
	 */
	TypeReferenceNode<TypeRef> getDeclaredValueTypeRefNode();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.N4IndexSignatureDeclaration#getDeclaredValueTypeRefNode <em>Declared Value Type Ref Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Value Type Ref Node</em>' containment reference.
	 * @see #getDeclaredValueTypeRefNode()
	 * @generated
	 */
	void setDeclaredValueTypeRefNode(TypeReferenceNode<TypeRef> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	TypeRef getDeclaredIndexTypeRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	TypeRef getDeclaredIndexTypeRefInAST();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	TypeRef getDeclaredValueTypeRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	TypeRef getDeclaredValueTypeRefInAST();

} // N4IndexSignatureDeclaration
