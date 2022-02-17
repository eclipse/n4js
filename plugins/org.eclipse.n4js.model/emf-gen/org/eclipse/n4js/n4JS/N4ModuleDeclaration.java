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

import org.eclipse.n4js.ts.types.TNestedModule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>N4 Module Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.N4ModuleDeclaration#getDefinedModule <em>Defined Module</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.n4JS.N4JSPackage#getN4ModuleDeclaration()
 * @model
 * @generated
 */
public interface N4ModuleDeclaration extends N4AbstractNamespaceDeclaration, ScriptElement {
	/**
	 * Returns the value of the '<em><b>Defined Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Module</em>' reference.
	 * @see #setDefinedModule(TNestedModule)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getN4ModuleDeclaration_DefinedModule()
	 * @model transient="true"
	 * @generated
	 */
	TNestedModule getDefinedModule();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.N4ModuleDeclaration#getDefinedModule <em>Defined Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defined Module</em>' reference.
	 * @see #getDefinedModule()
	 * @generated
	 */
	void setDefinedModule(TNestedModule value);

} // N4ModuleDeclaration
