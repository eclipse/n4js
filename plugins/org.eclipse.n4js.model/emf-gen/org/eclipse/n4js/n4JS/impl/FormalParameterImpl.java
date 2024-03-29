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
package org.eclipse.n4js.n4JS.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.n4js.n4JS.AbstractVariable;
import org.eclipse.n4js.n4JS.Annotation;
import org.eclipse.n4js.n4JS.BindingPattern;
import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.n4js.n4JS.FormalParameter;
import org.eclipse.n4js.n4JS.N4JSPackage;
import org.eclipse.n4js.n4JS.NamedElement;
import org.eclipse.n4js.n4JS.TypeProvidingElement;
import org.eclipse.n4js.n4JS.TypeReferenceNode;
import org.eclipse.n4js.n4JS.TypedElement;

import org.eclipse.n4js.ts.typeRefs.TypeRef;

import org.eclipse.n4js.ts.types.TFormalParameter;
import org.eclipse.n4js.ts.types.TypableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.FormalParameterImpl#getDeclaredTypeRefNode <em>Declared Type Ref Node</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.FormalParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.FormalParameterImpl#getDefinedVariable <em>Defined Variable</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.FormalParameterImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.FormalParameterImpl#isVariadic <em>Variadic</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.FormalParameterImpl#isHasInitializerAssignment <em>Has Initializer Assignment</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.FormalParameterImpl#getInitializer <em>Initializer</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.FormalParameterImpl#getBindingPattern <em>Binding Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FormalParameterImpl extends AnnotableElementImpl implements FormalParameter {
	/**
	 * The cached value of the '{@link #getDeclaredTypeRefNode() <em>Declared Type Ref Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredTypeRefNode()
	 * @generated
	 * @ordered
	 */
	protected TypeReferenceNode<TypeRef> declaredTypeRefNode;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinedVariable() <em>Defined Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinedVariable()
	 * @generated
	 * @ordered
	 */
	protected TFormalParameter definedVariable;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The default value of the '{@link #isVariadic() <em>Variadic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVariadic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VARIADIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVariadic() <em>Variadic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVariadic()
	 * @generated
	 * @ordered
	 */
	protected boolean variadic = VARIADIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasInitializerAssignment() <em>Has Initializer Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasInitializerAssignment()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_INITIALIZER_ASSIGNMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasInitializerAssignment() <em>Has Initializer Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasInitializerAssignment()
	 * @generated
	 * @ordered
	 */
	protected boolean hasInitializerAssignment = HAS_INITIALIZER_ASSIGNMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInitializer() <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializer()
	 * @generated
	 * @ordered
	 */
	protected Expression initializer;

	/**
	 * The cached value of the '{@link #getBindingPattern() <em>Binding Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingPattern()
	 * @generated
	 * @ordered
	 */
	protected BindingPattern bindingPattern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormalParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return N4JSPackage.Literals.FORMAL_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeReferenceNode<TypeRef> getDeclaredTypeRefNode() {
		return declaredTypeRefNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaredTypeRefNode(TypeReferenceNode<TypeRef> newDeclaredTypeRefNode, NotificationChain msgs) {
		TypeReferenceNode<TypeRef> oldDeclaredTypeRefNode = declaredTypeRefNode;
		declaredTypeRefNode = newDeclaredTypeRefNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE, oldDeclaredTypeRefNode, newDeclaredTypeRefNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeclaredTypeRefNode(TypeReferenceNode<TypeRef> newDeclaredTypeRefNode) {
		if (newDeclaredTypeRefNode != declaredTypeRefNode) {
			NotificationChain msgs = null;
			if (declaredTypeRefNode != null)
				msgs = ((InternalEObject)declaredTypeRefNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE, null, msgs);
			if (newDeclaredTypeRefNode != null)
				msgs = ((InternalEObject)newDeclaredTypeRefNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE, null, msgs);
			msgs = basicSetDeclaredTypeRefNode(newDeclaredTypeRefNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE, newDeclaredTypeRefNode, newDeclaredTypeRefNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TFormalParameter getDefinedVariable() {
		if (definedVariable != null && definedVariable.eIsProxy()) {
			InternalEObject oldDefinedVariable = (InternalEObject)definedVariable;
			definedVariable = (TFormalParameter)eResolveProxy(oldDefinedVariable);
			if (definedVariable != oldDefinedVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, N4JSPackage.FORMAL_PARAMETER__DEFINED_VARIABLE, oldDefinedVariable, definedVariable));
			}
		}
		return definedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFormalParameter basicGetDefinedVariable() {
		return definedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefinedVariable(TFormalParameter newDefinedVariable) {
		TFormalParameter oldDefinedVariable = definedVariable;
		definedVariable = newDefinedVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__DEFINED_VARIABLE, oldDefinedVariable, definedVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, N4JSPackage.FORMAL_PARAMETER__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVariadic() {
		return variadic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariadic(boolean newVariadic) {
		boolean oldVariadic = variadic;
		variadic = newVariadic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__VARIADIC, oldVariadic, variadic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasInitializerAssignment() {
		return hasInitializerAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasInitializerAssignment(boolean newHasInitializerAssignment) {
		boolean oldHasInitializerAssignment = hasInitializerAssignment;
		hasInitializerAssignment = newHasInitializerAssignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT, oldHasInitializerAssignment, hasInitializerAssignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getInitializer() {
		return initializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializer(Expression newInitializer, NotificationChain msgs) {
		Expression oldInitializer = initializer;
		initializer = newInitializer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__INITIALIZER, oldInitializer, newInitializer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitializer(Expression newInitializer) {
		if (newInitializer != initializer) {
			NotificationChain msgs = null;
			if (initializer != null)
				msgs = ((InternalEObject)initializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.FORMAL_PARAMETER__INITIALIZER, null, msgs);
			if (newInitializer != null)
				msgs = ((InternalEObject)newInitializer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.FORMAL_PARAMETER__INITIALIZER, null, msgs);
			msgs = basicSetInitializer(newInitializer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__INITIALIZER, newInitializer, newInitializer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingPattern getBindingPattern() {
		return bindingPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBindingPattern(BindingPattern newBindingPattern, NotificationChain msgs) {
		BindingPattern oldBindingPattern = bindingPattern;
		bindingPattern = newBindingPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN, oldBindingPattern, newBindingPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBindingPattern(BindingPattern newBindingPattern) {
		if (newBindingPattern != bindingPattern) {
			NotificationChain msgs = null;
			if (bindingPattern != null)
				msgs = ((InternalEObject)bindingPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN, null, msgs);
			if (newBindingPattern != null)
				msgs = ((InternalEObject)newBindingPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN, null, msgs);
			msgs = basicSetBindingPattern(newBindingPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN, newBindingPattern, newBindingPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isConst() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeRef getDeclaredTypeRef() {
		TypeReferenceNode<TypeRef> _declaredTypeRefNode = this.getDeclaredTypeRefNode();
		TypeRef _typeRef = null;
		if (_declaredTypeRefNode!=null) {
			_typeRef=_declaredTypeRefNode.getTypeRef();
		}
		return _typeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeRef getDeclaredTypeRefInAST() {
		TypeReferenceNode<TypeRef> _declaredTypeRefNode = this.getDeclaredTypeRefNode();
		TypeRef _typeRefInAST = null;
		if (_declaredTypeRefNode!=null) {
			_typeRefInAST=_declaredTypeRefNode.getTypeRefInAST();
		}
		return _typeRefInAST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE:
				return basicSetDeclaredTypeRefNode(null, msgs);
			case N4JSPackage.FORMAL_PARAMETER__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case N4JSPackage.FORMAL_PARAMETER__INITIALIZER:
				return basicSetInitializer(null, msgs);
			case N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN:
				return basicSetBindingPattern(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE:
				return getDeclaredTypeRefNode();
			case N4JSPackage.FORMAL_PARAMETER__NAME:
				return getName();
			case N4JSPackage.FORMAL_PARAMETER__DEFINED_VARIABLE:
				if (resolve) return getDefinedVariable();
				return basicGetDefinedVariable();
			case N4JSPackage.FORMAL_PARAMETER__ANNOTATIONS:
				return getAnnotations();
			case N4JSPackage.FORMAL_PARAMETER__VARIADIC:
				return isVariadic();
			case N4JSPackage.FORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT:
				return isHasInitializerAssignment();
			case N4JSPackage.FORMAL_PARAMETER__INITIALIZER:
				return getInitializer();
			case N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN:
				return getBindingPattern();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE:
				setDeclaredTypeRefNode((TypeReferenceNode<TypeRef>)newValue);
				return;
			case N4JSPackage.FORMAL_PARAMETER__NAME:
				setName((String)newValue);
				return;
			case N4JSPackage.FORMAL_PARAMETER__DEFINED_VARIABLE:
				setDefinedVariable((TFormalParameter)newValue);
				return;
			case N4JSPackage.FORMAL_PARAMETER__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case N4JSPackage.FORMAL_PARAMETER__VARIADIC:
				setVariadic((Boolean)newValue);
				return;
			case N4JSPackage.FORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT:
				setHasInitializerAssignment((Boolean)newValue);
				return;
			case N4JSPackage.FORMAL_PARAMETER__INITIALIZER:
				setInitializer((Expression)newValue);
				return;
			case N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN:
				setBindingPattern((BindingPattern)newValue);
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
			case N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE:
				setDeclaredTypeRefNode((TypeReferenceNode<TypeRef>)null);
				return;
			case N4JSPackage.FORMAL_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case N4JSPackage.FORMAL_PARAMETER__DEFINED_VARIABLE:
				setDefinedVariable((TFormalParameter)null);
				return;
			case N4JSPackage.FORMAL_PARAMETER__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case N4JSPackage.FORMAL_PARAMETER__VARIADIC:
				setVariadic(VARIADIC_EDEFAULT);
				return;
			case N4JSPackage.FORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT:
				setHasInitializerAssignment(HAS_INITIALIZER_ASSIGNMENT_EDEFAULT);
				return;
			case N4JSPackage.FORMAL_PARAMETER__INITIALIZER:
				setInitializer((Expression)null);
				return;
			case N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN:
				setBindingPattern((BindingPattern)null);
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
			case N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE:
				return declaredTypeRefNode != null;
			case N4JSPackage.FORMAL_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case N4JSPackage.FORMAL_PARAMETER__DEFINED_VARIABLE:
				return definedVariable != null;
			case N4JSPackage.FORMAL_PARAMETER__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case N4JSPackage.FORMAL_PARAMETER__VARIADIC:
				return variadic != VARIADIC_EDEFAULT;
			case N4JSPackage.FORMAL_PARAMETER__HAS_INITIALIZER_ASSIGNMENT:
				return hasInitializerAssignment != HAS_INITIALIZER_ASSIGNMENT_EDEFAULT;
			case N4JSPackage.FORMAL_PARAMETER__INITIALIZER:
				return initializer != null;
			case N4JSPackage.FORMAL_PARAMETER__BINDING_PATTERN:
				return bindingPattern != null;
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
		if (baseClass == TypeProvidingElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == TypedElement.class) {
			switch (derivedFeatureID) {
				case N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE: return N4JSPackage.TYPED_ELEMENT__DECLARED_TYPE_REF_NODE;
				default: return -1;
			}
		}
		if (baseClass == TypableElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractVariable.class) {
			switch (derivedFeatureID) {
				case N4JSPackage.FORMAL_PARAMETER__NAME: return N4JSPackage.ABSTRACT_VARIABLE__NAME;
				case N4JSPackage.FORMAL_PARAMETER__DEFINED_VARIABLE: return N4JSPackage.ABSTRACT_VARIABLE__DEFINED_VARIABLE;
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
		if (baseClass == TypeProvidingElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == TypedElement.class) {
			switch (baseFeatureID) {
				case N4JSPackage.TYPED_ELEMENT__DECLARED_TYPE_REF_NODE: return N4JSPackage.FORMAL_PARAMETER__DECLARED_TYPE_REF_NODE;
				default: return -1;
			}
		}
		if (baseClass == TypableElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractVariable.class) {
			switch (baseFeatureID) {
				case N4JSPackage.ABSTRACT_VARIABLE__NAME: return N4JSPackage.FORMAL_PARAMETER__NAME;
				case N4JSPackage.ABSTRACT_VARIABLE__DEFINED_VARIABLE: return N4JSPackage.FORMAL_PARAMETER__DEFINED_VARIABLE;
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
		if (baseClass == TypeProvidingElement.class) {
			switch (baseOperationID) {
				case N4JSPackage.TYPE_PROVIDING_ELEMENT___GET_DECLARED_TYPE_REF: return N4JSPackage.FORMAL_PARAMETER___GET_DECLARED_TYPE_REF;
				case N4JSPackage.TYPE_PROVIDING_ELEMENT___GET_DECLARED_TYPE_REF_IN_AST: return N4JSPackage.FORMAL_PARAMETER___GET_DECLARED_TYPE_REF_IN_AST;
				case N4JSPackage.TYPE_PROVIDING_ELEMENT___GET_DECLARED_TYPE_REF_NODE: return N4JSPackage.FORMAL_PARAMETER___GET_DECLARED_TYPE_REF_NODE;
				default: return -1;
			}
		}
		if (baseClass == TypedElement.class) {
			switch (baseOperationID) {
				case N4JSPackage.TYPED_ELEMENT___GET_DECLARED_TYPE_REF: return N4JSPackage.FORMAL_PARAMETER___GET_DECLARED_TYPE_REF;
				case N4JSPackage.TYPED_ELEMENT___GET_DECLARED_TYPE_REF_IN_AST: return N4JSPackage.FORMAL_PARAMETER___GET_DECLARED_TYPE_REF_IN_AST;
				default: return -1;
			}
		}
		if (baseClass == TypableElement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseOperationID) {
				case N4JSPackage.NAMED_ELEMENT___GET_NAME: return N4JSPackage.FORMAL_PARAMETER___GET_NAME;
				default: return -1;
			}
		}
		if (baseClass == AbstractVariable.class) {
			switch (baseOperationID) {
				case N4JSPackage.ABSTRACT_VARIABLE___IS_CONST: return N4JSPackage.FORMAL_PARAMETER___IS_CONST;
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
			case N4JSPackage.FORMAL_PARAMETER___IS_CONST:
				return isConst();
			case N4JSPackage.FORMAL_PARAMETER___GET_DECLARED_TYPE_REF:
				return getDeclaredTypeRef();
			case N4JSPackage.FORMAL_PARAMETER___GET_DECLARED_TYPE_REF_IN_AST:
				return getDeclaredTypeRefInAST();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", variadic: ");
		result.append(variadic);
		result.append(", hasInitializerAssignment: ");
		result.append(hasInitializerAssignment);
		result.append(')');
		return result.toString();
	}

} //FormalParameterImpl
