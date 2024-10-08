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
package org.eclipse.n4js.ts.types.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef;
import org.eclipse.n4js.ts.typeRefs.TypeRef;

import org.eclipse.n4js.ts.types.SyntaxRelatedTElement;
import org.eclipse.n4js.ts.types.TClassifier;
import org.eclipse.n4js.ts.types.TMember;
import org.eclipse.n4js.ts.types.Type;
import org.eclipse.n4js.ts.types.TypeAlias;
import org.eclipse.n4js.ts.types.TypesPackage;

import org.eclipse.n4js.ts.types.TypesPackage.Literals;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TClassifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.ts.types.impl.TClassifierImpl#getAstElement <em>Ast Element</em>}</li>
 *   <li>{@link org.eclipse.n4js.ts.types.impl.TClassifierImpl#isDeclaredCovariantConstructor <em>Declared Covariant Constructor</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TClassifierImpl extends ContainerTypeImpl<TMember> implements TClassifier {
	/**
	 * The cached value of the '{@link #getAstElement() <em>Ast Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAstElement()
	 * @generated
	 * @ordered
	 */
	protected EObject astElement;

	/**
	 * The default value of the '{@link #isDeclaredCovariantConstructor() <em>Declared Covariant Constructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeclaredCovariantConstructor()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECLARED_COVARIANT_CONSTRUCTOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeclaredCovariantConstructor() <em>Declared Covariant Constructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeclaredCovariantConstructor()
	 * @generated
	 * @ordered
	 */
	protected boolean declaredCovariantConstructor = DECLARED_COVARIANT_CONSTRUCTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.TCLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getAstElement() {
		if (astElement != null && astElement.eIsProxy()) {
			InternalEObject oldAstElement = (InternalEObject)astElement;
			astElement = eResolveProxy(oldAstElement);
			if (astElement != oldAstElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.TCLASSIFIER__AST_ELEMENT, oldAstElement, astElement));
			}
		}
		return astElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetAstElement() {
		return astElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAstElement(EObject newAstElement) {
		EObject oldAstElement = astElement;
		astElement = newAstElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TCLASSIFIER__AST_ELEMENT, oldAstElement, astElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDeclaredCovariantConstructor() {
		return declaredCovariantConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeclaredCovariantConstructor(boolean newDeclaredCovariantConstructor) {
		boolean oldDeclaredCovariantConstructor = declaredCovariantConstructor;
		declaredCovariantConstructor = newDeclaredCovariantConstructor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TCLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR, oldDeclaredCovariantConstructor, declaredCovariantConstructor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iterable<? extends TClassifier> getSuperClassifiers() {
		final List<TClassifier> result = CollectionLiterals.<TClassifier>newArrayList();
		final Object _superClassifierRefs = this.getSuperClassifierRefs();
		for (final Object superClassifierRef : ((Iterable<?>) _superClassifierRefs)) {
			if ((superClassifierRef != null)) {
				Type declType = ((TypeRef) superClassifierRef).getDeclaredType();
				if ((declType instanceof TypeAlias)) {
					declType = ((TypeAlias)declType).getTypeRef().getDeclaredType();
				}
				if ((declType instanceof TClassifier)) {
					result.add(((TClassifier)declType));
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iterable<ParameterizedTypeRef> getSuperClassifierRefs() {
		return CollectionLiterals.<ParameterizedTypeRef>emptyList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iterable<ParameterizedTypeRef> getImplementedOrExtendedInterfaceRefs() {
		return CollectionLiterals.<ParameterizedTypeRef>emptyList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFinal() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getAstElementNoResolve() {
		Object _eGet = this.eGet(Literals.SYNTAX_RELATED_TELEMENT__AST_ELEMENT, false);
		final EObject astElem = ((EObject) _eGet);
		if (((astElem != null) && (!astElem.eIsProxy()))) {
			return astElem;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.TCLASSIFIER__AST_ELEMENT:
				if (resolve) return getAstElement();
				return basicGetAstElement();
			case TypesPackage.TCLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR:
				return isDeclaredCovariantConstructor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.TCLASSIFIER__AST_ELEMENT:
				setAstElement((EObject)newValue);
				return;
			case TypesPackage.TCLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR:
				setDeclaredCovariantConstructor((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypesPackage.TCLASSIFIER__AST_ELEMENT:
				setAstElement((EObject)null);
				return;
			case TypesPackage.TCLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR:
				setDeclaredCovariantConstructor(DECLARED_COVARIANT_CONSTRUCTOR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypesPackage.TCLASSIFIER__AST_ELEMENT:
				return astElement != null;
			case TypesPackage.TCLASSIFIER__DECLARED_COVARIANT_CONSTRUCTOR:
				return declaredCovariantConstructor != DECLARED_COVARIANT_CONSTRUCTOR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SyntaxRelatedTElement.class) {
			switch (derivedFeatureID) {
				case TypesPackage.TCLASSIFIER__AST_ELEMENT: return TypesPackage.SYNTAX_RELATED_TELEMENT__AST_ELEMENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SyntaxRelatedTElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.SYNTAX_RELATED_TELEMENT__AST_ELEMENT: return TypesPackage.TCLASSIFIER__AST_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Type.class) {
			switch (baseOperationID) {
				case TypesPackage.TYPE___IS_FINAL: return TypesPackage.TCLASSIFIER___IS_FINAL;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == SyntaxRelatedTElement.class) {
			switch (baseOperationID) {
				case TypesPackage.SYNTAX_RELATED_TELEMENT___GET_AST_ELEMENT_NO_RESOLVE: return TypesPackage.TCLASSIFIER___GET_AST_ELEMENT_NO_RESOLVE;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TypesPackage.TCLASSIFIER___IS_ABSTRACT:
				return isAbstract();
			case TypesPackage.TCLASSIFIER___GET_SUPER_CLASSIFIERS:
				return getSuperClassifiers();
			case TypesPackage.TCLASSIFIER___GET_SUPER_CLASSIFIER_REFS:
				return getSuperClassifierRefs();
			case TypesPackage.TCLASSIFIER___GET_IMPLEMENTED_OR_EXTENDED_INTERFACE_REFS:
				return getImplementedOrExtendedInterfaceRefs();
			case TypesPackage.TCLASSIFIER___IS_FINAL:
				return isFinal();
			case TypesPackage.TCLASSIFIER___GET_AST_ELEMENT_NO_RESOLVE:
				return getAstElementNoResolve();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (declaredCovariantConstructor: ");
		result.append(declaredCovariantConstructor);
		result.append(')');
		return result.toString();
	}

} //TClassifierImpl
