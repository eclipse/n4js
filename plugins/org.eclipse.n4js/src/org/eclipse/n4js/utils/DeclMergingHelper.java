/**
 * Copyright (c) 2022 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.n4js.naming.N4JSQualifiedNameProvider;
import org.eclipse.n4js.ts.typeRefs.TypeRef;
import org.eclipse.n4js.ts.typeRefs.TypeTypeRef;
import org.eclipse.n4js.ts.types.AbstractNamespace;
import org.eclipse.n4js.ts.types.TClass;
import org.eclipse.n4js.ts.types.TFunction;
import org.eclipse.n4js.ts.types.Type;
import org.eclipse.n4js.types.utils.TypeUtils;
import org.eclipse.n4js.typesystem.utils.RuleEnvironment;
import org.eclipse.n4js.typesystem.utils.TypeSystemHelper;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.inject.Inject;

/**
 * Helper for handling declaration merging.
 */
public class DeclMergingHelper {

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private ImportedNamesRecordingGlobalScopeAccess globalScopeAccess;

	@Inject
	private TypeSystemHelper tsh;

	/**
	 * For each set of merged elements in the given list, this method will retain the
	 * {@link DeclMergingUtils#compareForMerging(IEObjectDescription, IEObjectDescription) representative} of these
	 * merged elements and remove the others. The given list may contain more than one such set of merged elements.
	 * Elements without merged elements will be retained. Order will be preserved, except that representatives are moved
	 * to the position of the first of their merged elements.
	 * <p>
	 * ASSUMPTIONS:
	 * <ul>
	 * <li>for each set S of elements that are merged into each other, the given list is expected to contain
	 * <em>all</em> elements in S if it contains one of them. The index is not queried for additional merged elements.
	 * <li>the {@link IEObjectDescription}s in the given list are expected to return a global, fully qualified name
	 * (such as the ones provided by {@link N4JSQualifiedNameProvider}) from method
	 * {@link IEObjectDescription#getQualifiedName() #getQualifiedName()}, not some temporary, local name.
	 * </ul>
	 */
	@SuppressWarnings("null")
	public List<IEObjectDescription> chooseRepresentatives(List<IEObjectDescription> descs) {
		int len = descs.size();
		List<IEObjectDescription> result = null;
		ListMultimap<QualifiedName, IEObjectDescription> mergedElements = null;
		Map<QualifiedName, Integer> firstIndex = null;
		int idx = 0;
		for (int i = 0; i < len; i++) {
			IEObjectDescription curr = descs.get(i);
			if (DeclMergingUtils.mayBeMerged(curr)) {
				// we have an element that may be merged
				if (result == null) {
					result = new ArrayList<>(len);
					for (int j = 0; j < i; j++) {
						result.add(descs.get(j));
					}
					mergedElements = MultimapBuilder.linkedHashKeys().arrayListValues().build();
					firstIndex = new HashMap<>();
				}
				// do not use #getName() in next line! (see AliasedEObjectDescription for the difference)
				QualifiedName qn = curr.getQualifiedName();
				if (!mergedElements.containsKey(qn)) {
					firstIndex.put(qn, idx);
					idx++;
				}
				mergedElements.put(qn, curr);
			} else {
				// we have an ordinary element that cannot be merged
				if (result != null) {
					result.add(curr);
				}
				idx++;
			}
		}
		if (result == null) {
			return descs;
		}
		Comparator<IEObjectDescription> comparator = null;
		for (Entry<QualifiedName, Collection<IEObjectDescription>> entry : mergedElements.asMap().entrySet()) {
			Collection<IEObjectDescription> mergedModules = entry.getValue();
			IEObjectDescription representative;
			if (mergedModules.size() > 1) {
				if (comparator == null) {
					comparator = DeclMergingUtils::compareForMerging;
				}
				representative = IterableExtensions.sortWith(mergedModules, comparator).iterator().next();
			} else {
				representative = mergedModules.iterator().next();
			}
			result.add(firstIndex.get(entry.getKey()), representative);
		}
		return result;
	}

	/**
	 * Ordinary code should not have to use this. Only intended to be invoked from {@code TypeJudgment}.
	 */
	public TypeRef handleDeclarationMergingDuringTypeInference(RuleEnvironment G, TypeRef typeRef) {
		// only the case "function/class"; all other cases are simpler and are handled elsewhere
		Type type = typeRef instanceof TypeTypeRef ? tsh.getStaticType(G, (TypeTypeRef) typeRef, true) : null;
		if (type != null && !type.eIsProxy()
				&& type instanceof TClass
				&& DeclMergingUtils.mayBeMerged(type)) {
			List<Type> mergedElems = getMergedElements(type.eResource(), type);
			List<TypeRef> mergedTypeRefs = new ArrayList<>();
			for (Type mergedElem : mergedElems) {
				if (mergedElem instanceof TFunction) {
					TypeRef mergedTypeRef = TypeUtils.wrapTypeInTypeRef(mergedElem);
					mergedTypeRefs.add(mergedTypeRef);
				}
			}
			if (!mergedTypeRefs.isEmpty()) {
				return TypeUtils.createNonSimplifiedIntersectionType(
						Iterables.concat(Collections.singleton(typeRef), mergedTypeRefs));
			}
		}
		return typeRef;
	}

	/**
	 * Returns those elements merged with the given namespace that are also {@link AbstractNamespace}s.
	 * <p>
	 * The given namespace does not have to be the
	 * {@link DeclMergingUtils#compareForMerging(IEObjectDescription, IEObjectDescription) representative}.
	 */
	public List<AbstractNamespace> getMergedElements(Resource context, AbstractNamespace namespace) {
		QualifiedName qn = qualifiedNameProvider.getFullyQualifiedName(namespace);
		List<AbstractNamespace> result = globalScopeAccess.getNamespacesFromGlobalScope(context, qn);
		result.removeIf(ns -> ns == namespace);
		return result;
	}

	/**
	 * Returns those elements merged with the given type that are also {@link Type}s.
	 * <p>
	 * The given type does not have to be the
	 * {@link DeclMergingUtils#compareForMerging(IEObjectDescription, IEObjectDescription) representative}.
	 */
	public List<Type> getMergedElements(Resource context, Type type) {
		QualifiedName qn = qualifiedNameProvider.getFullyQualifiedName(type);
		List<Type> result = globalScopeAccess.getTypesFromGlobalScope(context, qn);
		result.removeIf(t -> t == type);
		return result;
	}
}
