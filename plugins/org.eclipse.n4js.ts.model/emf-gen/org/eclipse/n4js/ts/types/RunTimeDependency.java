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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run Time Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A run-time dependency from one module (i.e. <code>this.eContainer()</code>) to
 * another module (i.e. <code>this.getTarget()</code>).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.ts.types.RunTimeDependency#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.n4js.ts.types.RunTimeDependency#isLoadTimeForInheritance <em>Load Time For Inheritance</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.ts.types.TypesPackage#getRunTimeDependency()
 * @model
 * @generated
 */
public interface RunTimeDependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  The target module of this dependency.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TModule)
	 * @see org.eclipse.n4js.ts.types.TypesPackage#getRunTimeDependency_Target()
	 * @model
	 * @generated
	 */
	TModule getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.ts.types.RunTimeDependency#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TModule value);

	/**
	 * Returns the value of the '<em><b>Load Time For Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Tells whether this dependency is a load-time dependency that is caused by an extends/implements clause.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Time For Inheritance</em>' attribute.
	 * @see #setLoadTimeForInheritance(boolean)
	 * @see org.eclipse.n4js.ts.types.TypesPackage#getRunTimeDependency_LoadTimeForInheritance()
	 * @model unique="false"
	 * @generated
	 */
	boolean isLoadTimeForInheritance();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.ts.types.RunTimeDependency#isLoadTimeForInheritance <em>Load Time For Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Time For Inheritance</em>' attribute.
	 * @see #isLoadTimeForInheritance()
	 * @generated
	 */
	void setLoadTimeForInheritance(boolean value);

} // RunTimeDependency
