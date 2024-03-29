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

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.n4js.n4JS.Annotation;
import org.eclipse.n4js.n4JS.Block;
import org.eclipse.n4js.n4JS.FunctionDefinition;
import org.eclipse.n4js.n4JS.FunctionOrFieldAccessor;
import org.eclipse.n4js.n4JS.LiteralOrComputedPropertyName;
import org.eclipse.n4js.n4JS.N4FieldAccessor;
import org.eclipse.n4js.n4JS.N4InterfaceDeclaration;
import org.eclipse.n4js.n4JS.N4JSPackage;
import org.eclipse.n4js.n4JS.N4MemberDeclaration;
import org.eclipse.n4js.n4JS.NamedElement;
import org.eclipse.n4js.n4JS.PropertyNameKind;
import org.eclipse.n4js.n4JS.PropertyNameOwner;
import org.eclipse.n4js.n4JS.ThisArgProvider;
import org.eclipse.n4js.n4JS.TypeProvidingElement;
import org.eclipse.n4js.n4JS.TypeReferenceNode;
import org.eclipse.n4js.n4JS.VariableEnvironmentElement;

import org.eclipse.n4js.ts.typeRefs.TypeRef;

import org.eclipse.n4js.ts.types.FieldAccessor;
import org.eclipse.n4js.ts.types.IdentifiableElement;
import org.eclipse.n4js.ts.types.TExportableElement;
import org.eclipse.n4js.ts.types.TVariable;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>N4 Field Accessor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.N4FieldAccessorImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.N4FieldAccessorImpl#getImplicitArgumentsVariable <em>Implicit Arguments Variable</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.N4FieldAccessorImpl#getDeclaredName <em>Declared Name</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.N4FieldAccessorImpl#isDeclaredOptional <em>Declared Optional</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class N4FieldAccessorImpl extends AnnotableN4MemberDeclarationImpl implements N4FieldAccessor {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Block body;

	/**
	 * The cached value of the '{@link #getImplicitArgumentsVariable() <em>Implicit Arguments Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitArgumentsVariable()
	 * @generated
	 * @ordered
	 */
	protected TVariable implicitArgumentsVariable;

	/**
	 * The cached value of the '{@link #getDeclaredName() <em>Declared Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredName()
	 * @generated
	 * @ordered
	 */
	protected LiteralOrComputedPropertyName declaredName;

	/**
	 * The default value of the '{@link #isDeclaredOptional() <em>Declared Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeclaredOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECLARED_OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeclaredOptional() <em>Declared Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeclaredOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean declaredOptional = DECLARED_OPTIONAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected N4FieldAccessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return N4JSPackage.Literals.N4_FIELD_ACCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Block newBody, NotificationChain msgs) {
		Block oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, N4JSPackage.N4_FIELD_ACCESSOR__BODY, oldBody, newBody);
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
	public void setBody(Block newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.N4_FIELD_ACCESSOR__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.N4_FIELD_ACCESSOR__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.N4_FIELD_ACCESSOR__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TVariable getImplicitArgumentsVariable() {
		if (implicitArgumentsVariable != null && implicitArgumentsVariable.eIsProxy()) {
			InternalEObject oldImplicitArgumentsVariable = (InternalEObject)implicitArgumentsVariable;
			implicitArgumentsVariable = (TVariable)eResolveProxy(oldImplicitArgumentsVariable);
			if (implicitArgumentsVariable != oldImplicitArgumentsVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, N4JSPackage.N4_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE, oldImplicitArgumentsVariable, implicitArgumentsVariable));
			}
		}
		return implicitArgumentsVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TVariable basicGetImplicitArgumentsVariable() {
		return implicitArgumentsVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplicitArgumentsVariable(TVariable newImplicitArgumentsVariable) {
		TVariable oldImplicitArgumentsVariable = implicitArgumentsVariable;
		implicitArgumentsVariable = newImplicitArgumentsVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.N4_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE, oldImplicitArgumentsVariable, implicitArgumentsVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralOrComputedPropertyName getDeclaredName() {
		return declaredName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaredName(LiteralOrComputedPropertyName newDeclaredName, NotificationChain msgs) {
		LiteralOrComputedPropertyName oldDeclaredName = declaredName;
		declaredName = newDeclaredName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME, oldDeclaredName, newDeclaredName);
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
	public void setDeclaredName(LiteralOrComputedPropertyName newDeclaredName) {
		if (newDeclaredName != declaredName) {
			NotificationChain msgs = null;
			if (declaredName != null)
				msgs = ((InternalEObject)declaredName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME, null, msgs);
			if (newDeclaredName != null)
				msgs = ((InternalEObject)newDeclaredName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME, null, msgs);
			msgs = basicSetDeclaredName(newDeclaredName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME, newDeclaredName, newDeclaredName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDeclaredOptional() {
		return declaredOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeclaredOptional(boolean newDeclaredOptional) {
		boolean oldDeclaredOptional = declaredOptional;
		declaredOptional = newDeclaredOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_OPTIONAL, oldDeclaredOptional, declaredOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract() {
		return ((((this.eContainer() instanceof N4InterfaceDeclaration) && (this.getBody() == null)) && 
			(!IterableExtensions.<Annotation>exists(this.getAnnotations(), new Function1<Annotation, Boolean>() {
				public Boolean apply(final Annotation it) {
					String _name = it.getName();
					return Boolean.valueOf(Objects.equal(_name, "ProvidesDefaultImplementation"));
				}
			}))) || this.isDeclaredAbstract());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isValidName() {
		String _name = this.getName();
		boolean _equals = Objects.equal("prototype", _name);
		if (_equals) {
			return false;
		}
		boolean _and = false;
		String _name_1 = this.getName();
		boolean _equals_1 = Objects.equal("constructor", _name_1);
		if (!_equals_1) {
			_and = false;
		} else {
			LiteralOrComputedPropertyName _declaredName = this.getDeclaredName();
			PropertyNameKind _kind = null;
			if (_declaredName!=null) {
				_kind=_declaredName.getKind();
			}
			boolean _tripleNotEquals = (_kind != PropertyNameKind.COMPUTED);
			_and = _tripleNotEquals;
		}
		if (_and) {
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeRef getDeclaredTypeRef() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeRef getDeclaredTypeRefInAST() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeReferenceNode<TypeRef> getDeclaredTypeRefNode() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FieldAccessor getDefinedAccessor() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOptional() {
		return this.isDeclaredOptional();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		LiteralOrComputedPropertyName _declaredName = this.getDeclaredName();
		String _name = null;
		if (_declaredName!=null) {
			_name=_declaredName.getName();
		}
		return _name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean hasComputedPropertyName() {
		final LiteralOrComputedPropertyName declName = this.getDeclaredName();
		return ((declName != null) && declName.hasComputedPropertyName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReturnValueOptional() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAsync() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IdentifiableElement getDefinedFunctionOrAccessor() {
		final FunctionOrFieldAccessor _this = this;
		EObject _switchResult = null;
		boolean _matched = false;
		if (_this instanceof FunctionDefinition) {
			_matched=true;
			_switchResult = ((FunctionDefinition)_this).getDefinedType();
		}
		if (!_matched) {
			if (_this instanceof org.eclipse.n4js.n4JS.FieldAccessor) {
				_matched=true;
				_switchResult = ((org.eclipse.n4js.n4JS.FieldAccessor)_this).getDefinedAccessor();
			}
		}
		return ((TExportableElement)_switchResult);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean appliesOnlyToBlockScopedElements() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case N4JSPackage.N4_FIELD_ACCESSOR__BODY:
				return basicSetBody(null, msgs);
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME:
				return basicSetDeclaredName(null, msgs);
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
			case N4JSPackage.N4_FIELD_ACCESSOR__BODY:
				return getBody();
			case N4JSPackage.N4_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE:
				if (resolve) return getImplicitArgumentsVariable();
				return basicGetImplicitArgumentsVariable();
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME:
				return getDeclaredName();
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_OPTIONAL:
				return isDeclaredOptional();
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
			case N4JSPackage.N4_FIELD_ACCESSOR__BODY:
				setBody((Block)newValue);
				return;
			case N4JSPackage.N4_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE:
				setImplicitArgumentsVariable((TVariable)newValue);
				return;
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME:
				setDeclaredName((LiteralOrComputedPropertyName)newValue);
				return;
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_OPTIONAL:
				setDeclaredOptional((Boolean)newValue);
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
			case N4JSPackage.N4_FIELD_ACCESSOR__BODY:
				setBody((Block)null);
				return;
			case N4JSPackage.N4_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE:
				setImplicitArgumentsVariable((TVariable)null);
				return;
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME:
				setDeclaredName((LiteralOrComputedPropertyName)null);
				return;
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_OPTIONAL:
				setDeclaredOptional(DECLARED_OPTIONAL_EDEFAULT);
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
			case N4JSPackage.N4_FIELD_ACCESSOR__BODY:
				return body != null;
			case N4JSPackage.N4_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE:
				return implicitArgumentsVariable != null;
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME:
				return declaredName != null;
			case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_OPTIONAL:
				return declaredOptional != DECLARED_OPTIONAL_EDEFAULT;
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
		if (baseClass == VariableEnvironmentElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ThisArgProvider.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == FunctionOrFieldAccessor.class) {
			switch (derivedFeatureID) {
				case N4JSPackage.N4_FIELD_ACCESSOR__BODY: return N4JSPackage.FUNCTION_OR_FIELD_ACCESSOR__BODY;
				case N4JSPackage.N4_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE: return N4JSPackage.FUNCTION_OR_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE;
				default: return -1;
			}
		}
		if (baseClass == TypeProvidingElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PropertyNameOwner.class) {
			switch (derivedFeatureID) {
				case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME: return N4JSPackage.PROPERTY_NAME_OWNER__DECLARED_NAME;
				default: return -1;
			}
		}
		if (baseClass == org.eclipse.n4js.n4JS.FieldAccessor.class) {
			switch (derivedFeatureID) {
				case N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_OPTIONAL: return N4JSPackage.FIELD_ACCESSOR__DECLARED_OPTIONAL;
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
		if (baseClass == VariableEnvironmentElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ThisArgProvider.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == FunctionOrFieldAccessor.class) {
			switch (baseFeatureID) {
				case N4JSPackage.FUNCTION_OR_FIELD_ACCESSOR__BODY: return N4JSPackage.N4_FIELD_ACCESSOR__BODY;
				case N4JSPackage.FUNCTION_OR_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE: return N4JSPackage.N4_FIELD_ACCESSOR__IMPLICIT_ARGUMENTS_VARIABLE;
				default: return -1;
			}
		}
		if (baseClass == TypeProvidingElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PropertyNameOwner.class) {
			switch (baseFeatureID) {
				case N4JSPackage.PROPERTY_NAME_OWNER__DECLARED_NAME: return N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_NAME;
				default: return -1;
			}
		}
		if (baseClass == org.eclipse.n4js.n4JS.FieldAccessor.class) {
			switch (baseFeatureID) {
				case N4JSPackage.FIELD_ACCESSOR__DECLARED_OPTIONAL: return N4JSPackage.N4_FIELD_ACCESSOR__DECLARED_OPTIONAL;
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
		if (baseClass == NamedElement.class) {
			switch (baseOperationID) {
				case N4JSPackage.NAMED_ELEMENT___GET_NAME: return N4JSPackage.N4_FIELD_ACCESSOR___GET_NAME;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == N4MemberDeclaration.class) {
			switch (baseOperationID) {
				case N4JSPackage.N4_MEMBER_DECLARATION___IS_ABSTRACT: return N4JSPackage.N4_FIELD_ACCESSOR___IS_ABSTRACT;
				case N4JSPackage.N4_MEMBER_DECLARATION___GET_NAME: return N4JSPackage.N4_FIELD_ACCESSOR___GET_NAME;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == VariableEnvironmentElement.class) {
			switch (baseOperationID) {
				case N4JSPackage.VARIABLE_ENVIRONMENT_ELEMENT___APPLIES_ONLY_TO_BLOCK_SCOPED_ELEMENTS: return N4JSPackage.N4_FIELD_ACCESSOR___APPLIES_ONLY_TO_BLOCK_SCOPED_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == ThisArgProvider.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == FunctionOrFieldAccessor.class) {
			switch (baseOperationID) {
				case N4JSPackage.FUNCTION_OR_FIELD_ACCESSOR___GET_NAME: return N4JSPackage.N4_FIELD_ACCESSOR___GET_NAME;
				case N4JSPackage.FUNCTION_OR_FIELD_ACCESSOR___IS_RETURN_VALUE_OPTIONAL: return N4JSPackage.N4_FIELD_ACCESSOR___IS_RETURN_VALUE_OPTIONAL;
				case N4JSPackage.FUNCTION_OR_FIELD_ACCESSOR___IS_ASYNC: return N4JSPackage.N4_FIELD_ACCESSOR___IS_ASYNC;
				case N4JSPackage.FUNCTION_OR_FIELD_ACCESSOR___GET_DEFINED_FUNCTION_OR_ACCESSOR: return N4JSPackage.N4_FIELD_ACCESSOR___GET_DEFINED_FUNCTION_OR_ACCESSOR;
				default: return -1;
			}
		}
		if (baseClass == TypeProvidingElement.class) {
			switch (baseOperationID) {
				case N4JSPackage.TYPE_PROVIDING_ELEMENT___GET_DECLARED_TYPE_REF: return N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF;
				case N4JSPackage.TYPE_PROVIDING_ELEMENT___GET_DECLARED_TYPE_REF_IN_AST: return N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF_IN_AST;
				case N4JSPackage.TYPE_PROVIDING_ELEMENT___GET_DECLARED_TYPE_REF_NODE: return N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF_NODE;
				default: return -1;
			}
		}
		if (baseClass == PropertyNameOwner.class) {
			switch (baseOperationID) {
				case N4JSPackage.PROPERTY_NAME_OWNER___GET_NAME: return N4JSPackage.N4_FIELD_ACCESSOR___GET_NAME;
				case N4JSPackage.PROPERTY_NAME_OWNER___HAS_COMPUTED_PROPERTY_NAME: return N4JSPackage.N4_FIELD_ACCESSOR___HAS_COMPUTED_PROPERTY_NAME;
				case N4JSPackage.PROPERTY_NAME_OWNER___IS_VALID_NAME: return N4JSPackage.N4_FIELD_ACCESSOR___IS_VALID_NAME;
				default: return -1;
			}
		}
		if (baseClass == org.eclipse.n4js.n4JS.FieldAccessor.class) {
			switch (baseOperationID) {
				case N4JSPackage.FIELD_ACCESSOR___GET_DECLARED_TYPE_REF: return N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF;
				case N4JSPackage.FIELD_ACCESSOR___GET_DECLARED_TYPE_REF_IN_AST: return N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF_IN_AST;
				case N4JSPackage.FIELD_ACCESSOR___GET_DECLARED_TYPE_REF_NODE: return N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF_NODE;
				case N4JSPackage.FIELD_ACCESSOR___GET_DEFINED_ACCESSOR: return N4JSPackage.N4_FIELD_ACCESSOR___GET_DEFINED_ACCESSOR;
				case N4JSPackage.FIELD_ACCESSOR___IS_OPTIONAL: return N4JSPackage.N4_FIELD_ACCESSOR___IS_OPTIONAL;
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
			case N4JSPackage.N4_FIELD_ACCESSOR___IS_ABSTRACT:
				return isAbstract();
			case N4JSPackage.N4_FIELD_ACCESSOR___IS_VALID_NAME:
				return isValidName();
			case N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF:
				return getDeclaredTypeRef();
			case N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF_IN_AST:
				return getDeclaredTypeRefInAST();
			case N4JSPackage.N4_FIELD_ACCESSOR___GET_DECLARED_TYPE_REF_NODE:
				return getDeclaredTypeRefNode();
			case N4JSPackage.N4_FIELD_ACCESSOR___GET_DEFINED_ACCESSOR:
				return getDefinedAccessor();
			case N4JSPackage.N4_FIELD_ACCESSOR___IS_OPTIONAL:
				return isOptional();
			case N4JSPackage.N4_FIELD_ACCESSOR___GET_NAME:
				return getName();
			case N4JSPackage.N4_FIELD_ACCESSOR___HAS_COMPUTED_PROPERTY_NAME:
				return hasComputedPropertyName();
			case N4JSPackage.N4_FIELD_ACCESSOR___IS_RETURN_VALUE_OPTIONAL:
				return isReturnValueOptional();
			case N4JSPackage.N4_FIELD_ACCESSOR___IS_ASYNC:
				return isAsync();
			case N4JSPackage.N4_FIELD_ACCESSOR___GET_DEFINED_FUNCTION_OR_ACCESSOR:
				return getDefinedFunctionOrAccessor();
			case N4JSPackage.N4_FIELD_ACCESSOR___APPLIES_ONLY_TO_BLOCK_SCOPED_ELEMENTS:
				return appliesOnlyToBlockScopedElements();
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
		result.append(" (declaredOptional: ");
		result.append(declaredOptional);
		result.append(')');
		return result.toString();
	}

} //N4FieldAccessorImpl
