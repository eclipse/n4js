/**
 * Copyright (c) 2020 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.utils;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.n4js.dts.DtsParseTreeNodeInfo;
import org.eclipse.n4js.n4JS.DefaultImportSpecifier;
import org.eclipse.n4js.n4JS.FunctionOrFieldAccessor;
import org.eclipse.n4js.n4JS.GenericDeclaration;
import org.eclipse.n4js.n4JS.ImportDeclaration;
import org.eclipse.n4js.n4JS.LiteralOrComputedPropertyName;
import org.eclipse.n4js.n4JS.N4JSASTUtils;
import org.eclipse.n4js.n4JS.N4JSPackage;
import org.eclipse.n4js.n4JS.NamedImportSpecifier;
import org.eclipse.n4js.resource.N4JSResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Fixes an N4JS-specific problem with the default implementation of the super class.
 */
public class N4JSEObjectAtOffsetHelper extends EObjectAtOffsetHelper {

	@Override
	public EObject resolveElementAt(XtextResource resource, int offset) {
		if (ResourceType.getResourceType(resource) == ResourceType.DTS) {
			return findElementAtInDts(resource, offset);
		}

		EObject result = super.resolveElementAt(resource, offset);
		if (result instanceof LiteralOrComputedPropertyName) {
			result = result.eContainer();
		}

		if (result instanceof ImportDeclaration) {
			// special case: when the cursor is located at the end of an alias, the default implementation
			// returns the containing import declaration, but we prefer the named import specifier
			result = findBetterMatch(result, offset,
					IterableExtensions.filter(((ImportDeclaration) result).getImportSpecifiers(),
							NamedImportSpecifier.class),
					N4JSPackage.eINSTANCE.getNamedImportSpecifier_Alias());
		}
		if (result instanceof FunctionOrFieldAccessor) {
			// special case: when the cursor is located at the end of a formal parameter, the default implementation
			// returns the containing function declaration, but we prefer the formal parameter
			result = findBetterMatch(result, offset,
					N4JSASTUtils.getFormalParameters((FunctionOrFieldAccessor) result),
					N4JSPackage.eINSTANCE.getAbstractVariable_Name());
		}
		if (result instanceof GenericDeclaration) {
			// special case: when the cursor is located at the end of a type parameter, the default implementation
			// returns the containing classifier declaration, but we prefer the type parameter
			result = findBetterMatch(result, offset,
					((GenericDeclaration) result).getTypeVars(),
					N4JSPackage.eINSTANCE.getN4TypeVariable_Name());
		}

		return result;
	}

	private EObject findElementAtInDts(XtextResource resource, int offset) {
		int lastMatchOffsetDistance = Integer.MAX_VALUE;
		int lastMathLength = Integer.MAX_VALUE;
		TreeIterator<EObject> iter = ((N4JSResource) resource).getScript().eAllContents();
		EObject bestFit = iter.next();

		while (iter.hasNext()) {
			EObject object = iter.next();
			DtsParseTreeNodeInfo ptnInfo = DtsParseTreeNodeInfo.get(object);

			if (ptnInfo != null) {
				int offsetDistance = Math.abs(ptnInfo.getOffset() - offset);
				if ((offsetDistance < lastMatchOffsetDistance)
						|| (offsetDistance == lastMatchOffsetDistance && ptnInfo.getLength() < lastMathLength)) {

					bestFit = object;
					lastMatchOffsetDistance = offsetDistance;
					lastMathLength = ptnInfo.getLength();
				}
			}
		}
		return bestFit;
	}

	private EObject findBetterMatch(EObject defaultResult, int offset, Iterable<? extends EObject> candidates,
			EAttribute candidateNameAttribute) {

		for (EObject candidate : candidates) {
			if (candidate.eGet(candidateNameAttribute) == null) {
				continue; // ignore candidates with undefined name
			}
			List<INode> nodes = NodeModelUtils.findNodesForFeature(candidate, candidateNameAttribute);
			for (INode node : nodes) {
				if (node.getEndOffset() == offset) {
					return candidate;
				}
			}
		}
		return defaultResult;
	}

	@Override
	protected EObject resolveCrossReferencedElement(INode node) {
		EObject referenceOwner = NodeModelUtils.findActualSemanticObjectFor(node);
		if (referenceOwner instanceof DefaultImportSpecifier) {
			// Default imports of the form "import LocalName from 'module';" are special in that the identifier
			// LocalName has two meanings at the same time:
			// 1) it is a reference to the imported element (i.e. the default exported element of 'module'),
			// 2) it is the declaration of an alias for the imported element in the local module.
			// The default behavior of the super class would treat 'LocalName' as a reference to the imported element
			// and would thus resolve to the imported element. However, for our purposes (e.g. find references, rename
			// refactoring) we prefer to treat it as the declaration of a new, local name and there return the import
			// specifier:
			return referenceOwner;
		}
		return super.resolveCrossReferencedElement(node);
	}
}
