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
package org.eclipse.n4js.typesystem.utils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.n4js.smith.Measurement;
import org.eclipse.n4js.smith.N4JSDataCollectors;
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef;
import org.eclipse.n4js.ts.typeRefs.TypeRefsFactory;
import org.eclipse.n4js.ts.types.ContainerType;
import org.eclipse.n4js.ts.types.PrimitiveType;
import org.eclipse.n4js.ts.types.TClass;
import org.eclipse.n4js.ts.types.Type;
import org.eclipse.n4js.types.utils.TypeUtils;
import org.eclipse.n4js.utils.DeclMergingHelper;

import com.google.common.collect.Lists;

/**
 * The bottom type or its merged/polyfilled types <b>are not</b> included.
 */
public class AllDirectStructuralSuperTypeRefsCollector
		extends AbstractCompleteHierarchyTraverser<List<ParameterizedTypeRef>> {

	private final List<ParameterizedTypeRef> result;

	private final ParameterizedTypeRef typeRef;

	/**
	 * Used to traverse both super classes and implemented interfaces even if the super class would break traversal
	 * already.
	 */
	private boolean breakTraversing;

	/**
	 * Creates a new collector.
	 *
	 * @param typeRef
	 *            the type to start with.
	 */
	public AllDirectStructuralSuperTypeRefsCollector(ParameterizedTypeRef typeRef,
			DeclMergingHelper declMergingHelper) {
		super(typeRef, declMergingHelper);
		this.typeRef = typeRef;
		result = Lists.newArrayList();
	}

	@Override
	protected Measurement getMeasurement() {
		return N4JSDataCollectors.dcTHT_AllSuperTypeRefsCollector.getMeasurementIfInactive("HierarchyTraverser");
	}

	@Override
	protected List<ParameterizedTypeRef> doGetResult() {
		return Collections.unmodifiableList(result);
	}

	@Override
	protected boolean releaseGuard() {
		return true;
	}

	/** Traverses only iff the current type is either a start type or if it is a structural type */
	@Override
	protected boolean process(ContainerType<?> currentType) {
		super.process(currentType);
		if (getCurrentTypeRef() == typeRef) {
			return false; // start
		}
		if (TypeUtils.isStructural(getCurrentTypeRef())) {
			return false;
		}
		Set<Type> mergedTypes = declMergingHelper.getMergedElements(contextResource, typeRef.getDeclaredType());
		if (mergedTypes.contains(currentType)) {
			return false; // start
		}
		return true;
	}

	@Override
	protected boolean doSwitchSuperClasses(TClass object) {
		// assumption: called in super class before #doSwitchImplementedInterfaces() is called
		breakTraversing = super.doSwitchSuperClasses(object);
		return false;
	}

	@Override
	protected boolean doSwitchImplementedInterfaces(TClass object) {
		// assumption: see above
		breakTraversing |= super.doSwitchImplementedInterfaces(object);
		return breakTraversing;
	}

	@Override
	protected void doProcess(ContainerType<?> containerType) {
		// if (containerType instanceof TClass) {
		// TClass casted = (TClass) containerType;
		// ParameterizedTypeRef superType = casted.getSuperClassRef();
		// result.addAll(casted.getImplementedInterfaceRefs());
		// if (superType != null) {
		// result.add(superType);
		// }
		// } else if (containerType instanceof TInterface) {
		// TInterface casted = (TInterface) containerType;
		// result.addAll(getSuperTypes(casted ));
		// }
		if (!isCurrentBottomOrPolyfillOrMergedType()) {
			ParameterizedTypeRef ptr = getCurrentTypeRef();
			if (ptr == typeRef) {
				return;
			}
			if (ptr == null) {
				ptr = TypeRefsFactory.eINSTANCE.createParameterizedTypeRef();
				ptr.setDeclaredType(containerType);
			}
			result.add(ptr);
		}
	}

	@Override
	protected void doProcess(PrimitiveType currentType) {
		PrimitiveType assignmentCompatible = currentType.getAssignmentCompatible();
		if (!isDirectPolyfillOrMergedType && assignmentCompatible != null) {
			ParameterizedTypeRef ptr = TypeRefsFactory.eINSTANCE.createParameterizedTypeRef();
			ptr.setDeclaredType(assignmentCompatible);
			result.add(ptr);
		}
	}

	/**
	 * Convenience method to create a new instance of {@link AllDirectStructuralSuperTypeRefsCollector} and immediately
	 * return its result.
	 *
	 * @param typeRef
	 *            the type ref to start with.
	 * @return transitive closure of all super classes, consumed roles and implemented interfaces.
	 */
	public static final List<ParameterizedTypeRef> collect(ParameterizedTypeRef typeRef,
			DeclMergingHelper declMergingHelper) {
		return new AllDirectStructuralSuperTypeRefsCollector(typeRef, declMergingHelper).getResult();
	}
}
