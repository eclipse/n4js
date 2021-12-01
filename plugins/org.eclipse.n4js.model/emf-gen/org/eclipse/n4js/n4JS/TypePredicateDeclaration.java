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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.n4js.ts.typeRefs.TypeRef;

import org.eclipse.n4js.ts.types.IdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Predicate Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.TypePredicateDeclaration#isReferringToThis <em>Referring To This</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.TypePredicateDeclaration#getFpar <em>Fpar</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.TypePredicateDeclaration#getTypeRefNode <em>Type Ref Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.n4JS.N4JSPackage#getTypePredicateDeclaration()
 * @model
 * @generated
 */
public interface TypePredicateDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Referring To This</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referring To This</em>' attribute.
	 * @see #setReferringToThis(boolean)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getTypePredicateDeclaration_ReferringToThis()
	 * @model unique="false"
	 * @generated
	 */
	boolean isReferringToThis();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.TypePredicateDeclaration#isReferringToThis <em>Referring To This</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referring To This</em>' attribute.
	 * @see #isReferringToThis()
	 * @generated
	 */
	void setReferringToThis(boolean value);

	/**
	 * Returns the value of the '<em><b>Fpar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fpar</em>' reference.
	 * @see #setFpar(IdentifiableElement)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getTypePredicateDeclaration_Fpar()
	 * @model
	 * @generated
	 */
	IdentifiableElement getFpar();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.TypePredicateDeclaration#getFpar <em>Fpar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fpar</em>' reference.
	 * @see #getFpar()
	 * @generated
	 */
	void setFpar(IdentifiableElement value);

	/**
	 * Returns the value of the '<em><b>Type Ref Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Ref Node</em>' containment reference.
	 * @see #setTypeRefNode(TypeReferenceNode)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getTypePredicateDeclaration_TypeRefNode()
	 * @model containment="true"
	 * @generated
	 */
	TypeReferenceNode<TypeRef> getTypeRefNode();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.TypePredicateDeclaration#getTypeRefNode <em>Type Ref Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref Node</em>' containment reference.
	 * @see #getTypeRefNode()
	 * @generated
	 */
	void setTypeRefNode(TypeReferenceNode<TypeRef> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	TypeRef getTypeRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	TypeRef getTypeRefInAST();

} // TypePredicateDeclaration
