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

import org.eclipse.n4js.ts.types.ComposedMemberCache;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.MemberAccess#getComposedMemberCache <em>Composed Member Cache</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.n4JS.N4JSPackage#getMemberAccess()
 * @model abstract="true"
 * @generated
 */
public interface MemberAccess extends EObject {
	/**
	 * Returns the value of the '<em><b>Composed Member Cache</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed Member Cache</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed Member Cache</em>' reference.
	 * @see #setComposedMemberCache(ComposedMemberCache)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getMemberAccess_ComposedMemberCache()
	 * @model transient="true"
	 * @generated
	 */
	ComposedMemberCache getComposedMemberCache();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.MemberAccess#getComposedMemberCache <em>Composed Member Cache</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed Member Cache</em>' reference.
	 * @see #getComposedMemberCache()
	 * @generated
	 */
	void setComposedMemberCache(ComposedMemberCache value);

} // MemberAccess
