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
 * A representation of the model object '<em><b>Export Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.ExportDeclaration#getExportedElement <em>Exported Element</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.ExportDeclaration#getDefaultExportedExpression <em>Default Exported Expression</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.ExportDeclaration#getNamespaceExport <em>Namespace Export</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.ExportDeclaration#getNamedExports <em>Named Exports</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.ExportDeclaration#isDefaultExport <em>Default Export</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.n4JS.N4JSPackage#getExportDeclaration()
 * @model
 * @generated
 */
public interface ExportDeclaration extends AnnotableScriptElement, NamespaceElement, ModuleRef {
	/**
	 * Returns the value of the '<em><b>Exported Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exported Element</em>' containment reference.
	 * @see #setExportedElement(ExportableElement)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getExportDeclaration_ExportedElement()
	 * @model containment="true"
	 * @generated
	 */
	ExportableElement getExportedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.ExportDeclaration#getExportedElement <em>Exported Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exported Element</em>' containment reference.
	 * @see #getExportedElement()
	 * @generated
	 */
	void setExportedElement(ExportableElement value);

	/**
	 * Returns the value of the '<em><b>Default Exported Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Exported Expression</em>' containment reference.
	 * @see #setDefaultExportedExpression(Expression)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getExportDeclaration_DefaultExportedExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getDefaultExportedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.ExportDeclaration#getDefaultExportedExpression <em>Default Exported Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Exported Expression</em>' containment reference.
	 * @see #getDefaultExportedExpression()
	 * @generated
	 */
	void setDefaultExportedExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Namespace Export</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace Export</em>' containment reference.
	 * @see #setNamespaceExport(NamespaceExportSpecifier)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getExportDeclaration_NamespaceExport()
	 * @model containment="true"
	 * @generated
	 */
	NamespaceExportSpecifier getNamespaceExport();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.ExportDeclaration#getNamespaceExport <em>Namespace Export</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace Export</em>' containment reference.
	 * @see #getNamespaceExport()
	 * @generated
	 */
	void setNamespaceExport(NamespaceExportSpecifier value);

	/**
	 * Returns the value of the '<em><b>Named Exports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.n4js.n4JS.NamedExportSpecifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Exports</em>' containment reference list.
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getExportDeclaration_NamedExports()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedExportSpecifier> getNamedExports();

	/**
	 * Returns the value of the '<em><b>Default Export</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Export</em>' attribute.
	 * @see #setDefaultExport(boolean)
	 * @see org.eclipse.n4js.n4JS.N4JSPackage#getExportDeclaration_DefaultExport()
	 * @model unique="false"
	 * @generated
	 */
	boolean isDefaultExport();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.n4JS.ExportDeclaration#isDefaultExport <em>Default Export</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Export</em>' attribute.
	 * @see #isDefaultExport()
	 * @generated
	 */
	void setDefaultExport(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isHollow();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells whether this is a "re-export", i.e. something like:
	 * <pre>export { Cls } from "a/b/module";</pre>
	 * <b>not</b> something like:
	 * <pre>export { Cls };</pre>
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isReexport();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isRetainedAtRuntime();

} // ExportDeclaration
