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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TExportable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.ts.types.TExportableElement#isDirectlyExported <em>Directly Exported</em>}</li>
 *   <li>{@link org.eclipse.n4js.ts.types.TExportableElement#isDirectlyExportedAsDefault <em>Directly Exported As Default</em>}</li>
 *   <li>{@link org.eclipse.n4js.ts.types.TExportableElement#getExportingExportDefinitions <em>Exporting Export Definitions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.n4js.ts.types.TypesPackage#getTExportableElement()
 * @model
 * @generated
 */
public interface TExportableElement extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Directly Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells whether this element is actually directly exported. This will be true
	 * iff the corresponding {@code ExportableElement} in the AST returned true
	 * from {@code #isDeclaredExported()} OR from {@code #isExportedByNamespace()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Directly Exported</em>' attribute.
	 * @see #setDirectlyExported(boolean)
	 * @see org.eclipse.n4js.ts.types.TypesPackage#getTExportableElement_DirectlyExported()
	 * @model unique="false"
	 * @generated
	 */
	boolean isDirectlyExported();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.ts.types.TExportableElement#isDirectlyExported <em>Directly Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directly Exported</em>' attribute.
	 * @see #isDirectlyExported()
	 * @generated
	 */
	void setDirectlyExported(boolean value);

	/**
	 * Returns the value of the '<em><b>Directly Exported As Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Iff this element is {@link TExportableElement#isDirectlyExported() directly exported}, then this property
	 * tells whether the element is exported as default. Otherwise, the value is undefined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Directly Exported As Default</em>' attribute.
	 * @see #setDirectlyExportedAsDefault(boolean)
	 * @see org.eclipse.n4js.ts.types.TypesPackage#getTExportableElement_DirectlyExportedAsDefault()
	 * @model unique="false"
	 * @generated
	 */
	boolean isDirectlyExportedAsDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.n4js.ts.types.TExportableElement#isDirectlyExportedAsDefault <em>Directly Exported As Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directly Exported As Default</em>' attribute.
	 * @see #isDirectlyExportedAsDefault()
	 * @generated
	 */
	void setDirectlyExportedAsDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Exporting Export Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.n4js.ts.types.ElementExportDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Export definitions within the same {@link TModule} exporting this {@link TExportableElement}.
	 * <p>
	 * NOTE: an export definition in this list may belong to a {@code TExportableElement} other than this
	 * exportable element's containing {@code TExportableElement}:
	 * <pre>
	 * public class Cls {}
	 * export namespace N1 {
	 *     export { Cls };
	 * }
	 * </pre>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exporting Export Definitions</em>' reference list.
	 * @see org.eclipse.n4js.ts.types.TypesPackage#getTExportableElement_ExportingExportDefinitions()
	 * @model
	 * @generated
	 */
	EList<ElementExportDefinition> getExportingExportDefinitions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isExported();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isIndirectlyExported();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	String getDirectlyExportedName();

} // TExportableElement
