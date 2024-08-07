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

import org.eclipse.n4js.n4JS.ImportDeclaration;
import org.eclipse.n4js.n4JS.ImportSpecifier;
import org.eclipse.n4js.n4JS.MemberAccess;
import org.eclipse.n4js.n4JS.ModuleRef;
import org.eclipse.n4js.n4JS.ModuleSpecifierForm;
import org.eclipse.n4js.n4JS.N4JSPackage;

import org.eclipse.n4js.n4JS.N4JSPackage.Literals;

import org.eclipse.n4js.ts.types.ComposedMemberCache;
import org.eclipse.n4js.ts.types.TModule;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.ImportDeclarationImpl#getComposedMemberCache <em>Composed Member Cache</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.ImportDeclarationImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.ImportDeclarationImpl#getModuleSpecifierAsText <em>Module Specifier As Text</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.ImportDeclarationImpl#getModuleSpecifierForm <em>Module Specifier Form</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.ImportDeclarationImpl#getImportSpecifiers <em>Import Specifiers</em>}</li>
 *   <li>{@link org.eclipse.n4js.n4JS.impl.ImportDeclarationImpl#isImportFrom <em>Import From</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportDeclarationImpl extends AnnotableScriptElementImpl implements ImportDeclaration {
	/**
	 * The cached value of the '{@link #getComposedMemberCache() <em>Composed Member Cache</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposedMemberCache()
	 * @generated
	 * @ordered
	 */
	protected ComposedMemberCache composedMemberCache;

	/**
	 * The cached value of the '{@link #getModule() <em>Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModule()
	 * @generated
	 * @ordered
	 */
	protected TModule module;

	/**
	 * The default value of the '{@link #getModuleSpecifierAsText() <em>Module Specifier As Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleSpecifierAsText()
	 * @generated
	 * @ordered
	 */
	protected static final String MODULE_SPECIFIER_AS_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModuleSpecifierAsText() <em>Module Specifier As Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleSpecifierAsText()
	 * @generated
	 * @ordered
	 */
	protected String moduleSpecifierAsText = MODULE_SPECIFIER_AS_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getModuleSpecifierForm() <em>Module Specifier Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleSpecifierForm()
	 * @generated
	 * @ordered
	 */
	protected static final ModuleSpecifierForm MODULE_SPECIFIER_FORM_EDEFAULT = ModuleSpecifierForm.UNKNOWN;

	/**
	 * The cached value of the '{@link #getModuleSpecifierForm() <em>Module Specifier Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleSpecifierForm()
	 * @generated
	 * @ordered
	 */
	protected ModuleSpecifierForm moduleSpecifierForm = MODULE_SPECIFIER_FORM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImportSpecifiers() <em>Import Specifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportSpecifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportSpecifier> importSpecifiers;

	/**
	 * The default value of the '{@link #isImportFrom() <em>Import From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImportFrom()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPORT_FROM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImportFrom() <em>Import From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImportFrom()
	 * @generated
	 * @ordered
	 */
	protected boolean importFrom = IMPORT_FROM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return N4JSPackage.Literals.IMPORT_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposedMemberCache getComposedMemberCache() {
		if (composedMemberCache != null && composedMemberCache.eIsProxy()) {
			InternalEObject oldComposedMemberCache = (InternalEObject)composedMemberCache;
			composedMemberCache = (ComposedMemberCache)eResolveProxy(oldComposedMemberCache);
			if (composedMemberCache != oldComposedMemberCache) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, N4JSPackage.IMPORT_DECLARATION__COMPOSED_MEMBER_CACHE, oldComposedMemberCache, composedMemberCache));
			}
		}
		return composedMemberCache;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedMemberCache basicGetComposedMemberCache() {
		return composedMemberCache;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComposedMemberCache(ComposedMemberCache newComposedMemberCache) {
		ComposedMemberCache oldComposedMemberCache = composedMemberCache;
		composedMemberCache = newComposedMemberCache;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.IMPORT_DECLARATION__COMPOSED_MEMBER_CACHE, oldComposedMemberCache, composedMemberCache));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TModule getModule() {
		if (module != null && module.eIsProxy()) {
			InternalEObject oldModule = (InternalEObject)module;
			module = (TModule)eResolveProxy(oldModule);
			if (module != oldModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, N4JSPackage.IMPORT_DECLARATION__MODULE, oldModule, module));
			}
		}
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TModule basicGetModule() {
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModule(TModule newModule) {
		TModule oldModule = module;
		module = newModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.IMPORT_DECLARATION__MODULE, oldModule, module));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModuleSpecifierAsText() {
		return moduleSpecifierAsText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModuleSpecifierAsText(String newModuleSpecifierAsText) {
		String oldModuleSpecifierAsText = moduleSpecifierAsText;
		moduleSpecifierAsText = newModuleSpecifierAsText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_AS_TEXT, oldModuleSpecifierAsText, moduleSpecifierAsText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModuleSpecifierForm getModuleSpecifierForm() {
		return moduleSpecifierForm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModuleSpecifierForm(ModuleSpecifierForm newModuleSpecifierForm) {
		ModuleSpecifierForm oldModuleSpecifierForm = moduleSpecifierForm;
		moduleSpecifierForm = newModuleSpecifierForm == null ? MODULE_SPECIFIER_FORM_EDEFAULT : newModuleSpecifierForm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_FORM, oldModuleSpecifierForm, moduleSpecifierForm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportSpecifier> getImportSpecifiers() {
		if (importSpecifiers == null) {
			importSpecifiers = new EObjectContainmentEList<ImportSpecifier>(ImportSpecifier.class, this, N4JSPackage.IMPORT_DECLARATION__IMPORT_SPECIFIERS);
		}
		return importSpecifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isImportFrom() {
		return importFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImportFrom(boolean newImportFrom) {
		boolean oldImportFrom = importFrom;
		importFrom = newImportFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.IMPORT_DECLARATION__IMPORT_FROM, oldImportFrom, importFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBare() {
		return this.getImportSpecifiers().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRetainedAtRuntime() {
		return (this.isBare() || IterableExtensions.<ImportSpecifier>exists(this.getImportSpecifiers(), new Function1<ImportSpecifier, Boolean>() {
			public Boolean apply(final ImportSpecifier it) {
				return Boolean.valueOf(it.isRetainedAtRuntime());
			}
		}));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReferringToOtherModule() {
		Object _eGet = this.eGet(Literals.MODULE_REF__MODULE, false);
		return (_eGet != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_SPECIFIERS:
				return ((InternalEList<?>)getImportSpecifiers()).basicRemove(otherEnd, msgs);
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
			case N4JSPackage.IMPORT_DECLARATION__COMPOSED_MEMBER_CACHE:
				if (resolve) return getComposedMemberCache();
				return basicGetComposedMemberCache();
			case N4JSPackage.IMPORT_DECLARATION__MODULE:
				if (resolve) return getModule();
				return basicGetModule();
			case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_AS_TEXT:
				return getModuleSpecifierAsText();
			case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_FORM:
				return getModuleSpecifierForm();
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_SPECIFIERS:
				return getImportSpecifiers();
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_FROM:
				return isImportFrom();
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
			case N4JSPackage.IMPORT_DECLARATION__COMPOSED_MEMBER_CACHE:
				setComposedMemberCache((ComposedMemberCache)newValue);
				return;
			case N4JSPackage.IMPORT_DECLARATION__MODULE:
				setModule((TModule)newValue);
				return;
			case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_AS_TEXT:
				setModuleSpecifierAsText((String)newValue);
				return;
			case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_FORM:
				setModuleSpecifierForm((ModuleSpecifierForm)newValue);
				return;
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_SPECIFIERS:
				getImportSpecifiers().clear();
				getImportSpecifiers().addAll((Collection<? extends ImportSpecifier>)newValue);
				return;
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_FROM:
				setImportFrom((Boolean)newValue);
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
			case N4JSPackage.IMPORT_DECLARATION__COMPOSED_MEMBER_CACHE:
				setComposedMemberCache((ComposedMemberCache)null);
				return;
			case N4JSPackage.IMPORT_DECLARATION__MODULE:
				setModule((TModule)null);
				return;
			case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_AS_TEXT:
				setModuleSpecifierAsText(MODULE_SPECIFIER_AS_TEXT_EDEFAULT);
				return;
			case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_FORM:
				setModuleSpecifierForm(MODULE_SPECIFIER_FORM_EDEFAULT);
				return;
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_SPECIFIERS:
				getImportSpecifiers().clear();
				return;
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_FROM:
				setImportFrom(IMPORT_FROM_EDEFAULT);
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
			case N4JSPackage.IMPORT_DECLARATION__COMPOSED_MEMBER_CACHE:
				return composedMemberCache != null;
			case N4JSPackage.IMPORT_DECLARATION__MODULE:
				return module != null;
			case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_AS_TEXT:
				return MODULE_SPECIFIER_AS_TEXT_EDEFAULT == null ? moduleSpecifierAsText != null : !MODULE_SPECIFIER_AS_TEXT_EDEFAULT.equals(moduleSpecifierAsText);
			case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_FORM:
				return moduleSpecifierForm != MODULE_SPECIFIER_FORM_EDEFAULT;
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_SPECIFIERS:
				return importSpecifiers != null && !importSpecifiers.isEmpty();
			case N4JSPackage.IMPORT_DECLARATION__IMPORT_FROM:
				return importFrom != IMPORT_FROM_EDEFAULT;
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
		if (baseClass == MemberAccess.class) {
			switch (derivedFeatureID) {
				case N4JSPackage.IMPORT_DECLARATION__COMPOSED_MEMBER_CACHE: return N4JSPackage.MEMBER_ACCESS__COMPOSED_MEMBER_CACHE;
				default: return -1;
			}
		}
		if (baseClass == ModuleRef.class) {
			switch (derivedFeatureID) {
				case N4JSPackage.IMPORT_DECLARATION__MODULE: return N4JSPackage.MODULE_REF__MODULE;
				case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_AS_TEXT: return N4JSPackage.MODULE_REF__MODULE_SPECIFIER_AS_TEXT;
				case N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_FORM: return N4JSPackage.MODULE_REF__MODULE_SPECIFIER_FORM;
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
		if (baseClass == MemberAccess.class) {
			switch (baseFeatureID) {
				case N4JSPackage.MEMBER_ACCESS__COMPOSED_MEMBER_CACHE: return N4JSPackage.IMPORT_DECLARATION__COMPOSED_MEMBER_CACHE;
				default: return -1;
			}
		}
		if (baseClass == ModuleRef.class) {
			switch (baseFeatureID) {
				case N4JSPackage.MODULE_REF__MODULE: return N4JSPackage.IMPORT_DECLARATION__MODULE;
				case N4JSPackage.MODULE_REF__MODULE_SPECIFIER_AS_TEXT: return N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_AS_TEXT;
				case N4JSPackage.MODULE_REF__MODULE_SPECIFIER_FORM: return N4JSPackage.IMPORT_DECLARATION__MODULE_SPECIFIER_FORM;
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
		if (baseClass == MemberAccess.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ModuleRef.class) {
			switch (baseOperationID) {
				case N4JSPackage.MODULE_REF___IS_REFERRING_TO_OTHER_MODULE: return N4JSPackage.IMPORT_DECLARATION___IS_REFERRING_TO_OTHER_MODULE;
				case N4JSPackage.MODULE_REF___IS_RETAINED_AT_RUNTIME: return N4JSPackage.IMPORT_DECLARATION___IS_RETAINED_AT_RUNTIME;
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
			case N4JSPackage.IMPORT_DECLARATION___IS_BARE:
				return isBare();
			case N4JSPackage.IMPORT_DECLARATION___IS_RETAINED_AT_RUNTIME:
				return isRetainedAtRuntime();
			case N4JSPackage.IMPORT_DECLARATION___IS_REFERRING_TO_OTHER_MODULE:
				return isReferringToOtherModule();
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
		result.append(" (moduleSpecifierAsText: ");
		result.append(moduleSpecifierAsText);
		result.append(", moduleSpecifierForm: ");
		result.append(moduleSpecifierForm);
		result.append(", importFrom: ");
		result.append(importFrom);
		result.append(')');
		return result.toString();
	}

} //ImportDeclarationImpl
