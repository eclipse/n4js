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
package org.eclipse.n4js.tooling.findReferences;

import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.n4js.n4JS.BindingElement;
import org.eclipse.n4js.n4JS.BindingProperty;
import org.eclipse.n4js.n4JS.IdentifierRef;
import org.eclipse.n4js.n4JS.ImportSpecifier;
import org.eclipse.n4js.n4JS.N4JSPackage;
import org.eclipse.n4js.n4JS.NamedImportSpecifier;
import org.eclipse.n4js.n4JS.PropertyNameValuePairSingleName;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.resource.N4JSResource;
import org.eclipse.n4js.ts.types.TMember;
import org.eclipse.n4js.utils.FindReferenceHelper;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.ReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * A reference finder that will check the concrete syntax in the document before it attempts to resolve a proxy.
 */
@SuppressWarnings("restriction")
@Singleton
public class ConcreteSyntaxAwareReferenceFinder extends ReferenceFinder {

	@Inject
	private TargetURIKey keys;

	@Inject
	private LazyURIEncoder uriEncoder;

	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private FindReferenceHelper findReferenceHelper;

	@Override
	protected void findReferencesInDescription(TargetURIs targetURIs, IResourceDescription resourceDescription,
			IResourceAccess resourceAccess, Acceptor acceptor, IProgressMonitor monitor) {

		TargetURIKey.Data findReferencesData = keys.getData(targetURIs, resourceAccess);
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		SortedSet<QualifiedName> typesOrModulesToFind = findReferencesData.getTypesOrModulesToFind();
		if (typesOrModulesToFind.isEmpty()) {
			return;
		}

		URI uri = resourceDescription.getURI();
		Iterable<QualifiedName> importedNames = resourceDescription.getImportedNames();

		if (importedNames instanceof SortedSet<QualifiedName>) {
			// Optimize search
			SortedSet<QualifiedName> sortedSet = (SortedSet<QualifiedName>) importedNames;
			for (QualifiedName typeOrModuleToFind : typesOrModulesToFind) {
				SortedSet<QualifiedName> tailSet = sortedSet.tailSet(typeOrModuleToFind);
				if (!tailSet.isEmpty() && Objects.equal(tailSet.first(), typeOrModuleToFind)) {
					resourceAccess.readOnly(
							uri,
							(resourceSet) -> {
								findReferences(targetURIs, resourceSet.getResource(uri, true), acceptor, monitor);
								return null;
							});
				}
				sortedSet = tailSet;
			}

		} else {
			typesOrModulesToFind = new TreeSet<>(typesOrModulesToFind);
			for (QualifiedName importedName : importedNames) {
				if (typesOrModulesToFind.contains(importedName)) {
					resourceAccess.readOnly(
							uri,
							(resourceSet) -> {
								findReferences(targetURIs, resourceSet.getResource(uri, true), acceptor, monitor);
								return null;
							});
					typesOrModulesToFind.remove(importedName);
					if (typesOrModulesToFind.isEmpty()) {
						break;
					}
				}
			}
		}
	}

	@Override
	public void findReferences(Predicate<URI> targetURIs, Resource resource, Acceptor acceptor,
			IProgressMonitor monitor) {
		// make sure data is present
		keys.getData((TargetURIs) targetURIs, new SimpleResourceAccess(resource.getResourceSet()));
		EList<EObject> astContents;
		if (resource instanceof N4JSResource) {
			// In case of N4JSResource, we search only in the AST but NOT in TModule tree!
			Script script = (Script) ((N4JSResource) resource).getContents().get(0);
			astContents = new BasicEList<>();
			astContents.add(script);
		} else {
			astContents = resource.getContents();
		}
		for (EObject content : astContents) {
			findReferences(targetURIs, content, acceptor, monitor);
		}
	}

	@Override
	protected boolean doProcess(EReference reference, Predicate<URI> targetURISet) {
		return ((TargetURIs) targetURISet).getUserData(TargetURIKey.KEY)
				.isEReferenceTypeApplicable(reference.getEReferenceType());
	}

	@Override
	protected EObject toValidInstanceOrNull(Resource resource, Predicate<URI> targetURIs, EObject value) {
		EObject result = value;
		if (result.eIsProxy()) {
			URI proxyURI = EcoreUtil.getURI(result);
			if (uriEncoder.isCrossLinkFragment(resource, proxyURI.fragment())) {
				INode node = uriEncoder.decode(resource, proxyURI.fragment()).getThird();
				try {
					String string = linkingHelper.getCrossRefNodeAsString(node, true);
					if (((TargetURIs) targetURIs).getUserData(TargetURIKey.KEY).isMatchingConcreteSyntax(string)) {
						result = resolveInternalProxy(value, resource);
					} else {
						result = null;
					}
				} catch (IllegalNodeException ine) {
					// illegal nodes exist in broken ASTs
					// fired in linkingHelper.getCrossRefNodeAsString(...)
					result = null;
				}
			} else {
				result = resolveInternalProxy(value, resource);
			}
		}
		return result;
	}

	/**
	 * This method overrides Xtext's standard behavior because we need special handling for composed members. The places
	 * with custom behavior are highlighted.
	 */
	@Override
	protected void findLocalReferencesFromElement(
			Predicate<URI> targetURIs,
			EObject sourceCandidate,
			Resource localResource,
			Acceptor acceptor) {
		URI sourceURI = null;
		if (doProcess(sourceCandidate, targetURIs)) {
			for (EReference ref : sourceCandidate.eClass().getEAllReferences()) {
				Object value = sourceCandidate.eGet(ref, false);
				if (sourceCandidate.eIsSet(ref) && value != null) {

					if (sourceCandidate instanceof PropertyNameValuePairSingleName && value instanceof EObject) {
						// special case to find references to destructuring cases like:
						// const { fieldF } = new C(); // where class C { fieldF : string = "init"; }
						checkValue((EObject) value, localResource, targetURIs, sourceCandidate, sourceURI,
								ref, acceptor);
					}
					if (sourceCandidate instanceof BindingElement
							&& ((BindingElement) sourceCandidate).getVarDecl() != null && value instanceof EObject) {
						// special case to find references to destructuring cases like:
						// const { fieldF } = new C(); // where class C { fieldF : string = "init"; }
						checkValue((EObject) value, localResource, targetURIs, sourceCandidate, sourceURI,
								ref, acceptor);
					}

					if (ref.isContainment()) {
						if (ref.isMany()) {
							@SuppressWarnings("unchecked")
							InternalEList<EObject> contentList = (InternalEList<EObject>) value;
							for (int i = 0; i < contentList.size(); ++i) {
								EObject childElement = contentList.basicGet(i);
								if (!childElement.eIsProxy()) {
									findLocalReferencesFromElement(targetURIs, childElement, localResource, acceptor);
								}
							}
						} else {
							EObject childElement = (EObject) value;
							if (!childElement.eIsProxy()) {
								findLocalReferencesFromElement(targetURIs, childElement, localResource, acceptor);
							}
						}
					} else if (!ref.isContainer()
							// CUSTOM BEHAVIOR: don't show references for transient attributes, because they represent
							// internal helper values and should therefore not appear in a list of references
							&& !ref.isTransient()) {
						if (doProcess(ref, targetURIs)) {
							if (ref.isMany()) {
								@SuppressWarnings("unchecked")
								InternalEList<EObject> values = (InternalEList<EObject>) value;
								for (int i = 0; i < values.size(); ++i) {
									checkValue(values.basicGet(i), localResource, targetURIs, sourceCandidate,
											sourceURI, ref, acceptor);
								}
							} else {
								checkValue((EObject) value, localResource, targetURIs, sourceCandidate, sourceURI, ref,
										acceptor);
							}
						}
					} else if (ref == N4JSPackage.Literals.IDENTIFIER_REF__ORIGIN_IMPORT
							&& isIdentifierRefToAlias(sourceCandidate)) {
						if (doProcess(ref, targetURIs)) {
							checkValue((EObject) value, localResource, targetURIs, sourceCandidate, sourceURI, ref,
									acceptor);
						}
					}
				}
			}
		}
	}

	private void checkValue(EObject value, Resource localResource, Predicate<URI> targetURIs, EObject sourceCandidate,
			URI sourceURI, EReference ref, Acceptor acceptor) {

		EObject instanceOrProxy = toValidInstanceOrNull(localResource, targetURIs, value);
		if (instanceOrProxy != null) {
			URI refURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(instanceOrProxy);
			// CUSTOM BEHAVIOR: check for and handle composed members
			if (referenceHasBeenFound(targetURIs, sourceCandidate, ref, refURI, instanceOrProxy)) {
				sourceURI = (sourceURI == null)
						? EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate)
						: sourceURI;

				acceptor.accept(sourceCandidate, sourceURI, ref, -1, instanceOrProxy, refURI);
			}
		}
	}

	private boolean referenceHasBeenFound(Predicate<URI> targetURIs, EObject sourceCandidate, EReference ref,
			URI refURI, EObject instanceOrProxy) {

		if (instanceOrProxy instanceof TMember && ((TMember) instanceOrProxy).isComposed()) {
			// If the EObject is a composed member, we compare the target URIs with the URIs of the constituent members.
			boolean result = false;
			TMember member = (TMember) instanceOrProxy;
			for (TMember constituentMember : member.getConstituentMembers()) {
				URI constituentRefURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(constituentMember);
				result = result || targetURIs.apply(constituentRefURI);
			}
			return result;
		}

		URI memberRefURI = null;
		if ((sourceCandidate instanceof PropertyNameValuePairSingleName
				&& ref == N4JSPackage.eINSTANCE.getPropertyNameValuePair_Expression())) {

			memberRefURI = findReferenceHelper.getMemberRefURIInDestructuring(instanceOrProxy);
		}

		if (sourceCandidate instanceof BindingElement && sourceCandidate.eContainer() instanceof BindingProperty) {
			BindingElement bElem = (BindingElement) sourceCandidate;
			BindingProperty bProp = (BindingProperty) sourceCandidate.eContainer();
			if (bProp.isSingleNameBinding() && bElem.getVarDecl() != null &&
					ref == N4JSPackage.eINSTANCE.getBindingElement_VarDecl()) {

				memberRefURI = findReferenceHelper.getMemberRefURIInDestructuring(instanceOrProxy);
			}
		}

		if (memberRefURI == null) {
			// Standard case
			memberRefURI = refURI;
		}

		return targetURIs.apply(memberRefURI);
	}

	/** Tells whether the given object is an IdentifierRef pointing to the alias of a named import. */
	private boolean isIdentifierRefToAlias(EObject obj) {
		if (obj instanceof IdentifierRef) {
			ImportSpecifier originImport = ((IdentifierRef) obj).getOriginImport();
			if (originImport instanceof NamedImportSpecifier) { // including DefaultImportSpecifier
				if (((NamedImportSpecifier) originImport).getAlias() != null) {
					return true;
				}
			}
		}
		return false;
	}
}
