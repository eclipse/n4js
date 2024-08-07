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
package org.eclipse.n4js.ide.imports;

import static org.eclipse.n4js.utils.N4JSLanguageUtils.lastSegmentOrDefaultHost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.n4js.ide.editor.contentassist.ContentAssistDataCollectors;
import org.eclipse.n4js.n4JS.ImportDeclaration;
import org.eclipse.n4js.n4JS.N4JSPackage;
import org.eclipse.n4js.naming.N4JSQualifiedNameProvider;
import org.eclipse.n4js.packagejson.projectDescription.ProjectType;
import org.eclipse.n4js.scoping.IContentAssistScopeProvider;
import org.eclipse.n4js.scoping.imports.PlainAccessOfAliasedImportDescription;
import org.eclipse.n4js.scoping.imports.PlainAccessOfNamespacedImportDescription;
import org.eclipse.n4js.scoping.members.WrongTypingStrategyDescription;
import org.eclipse.n4js.scoping.utils.QualifiedNameUtils;
import org.eclipse.n4js.smith.Measurement;
import org.eclipse.n4js.ts.types.ModuleNamespaceVirtualType;
import org.eclipse.n4js.ts.types.TModule;
import org.eclipse.n4js.utils.N4JSLanguageUtils;
import org.eclipse.n4js.utils.UtilN4;
import org.eclipse.n4js.workspace.N4JSProjectConfigSnapshot;
import org.eclipse.n4js.workspace.N4JSWorkspaceConfigSnapshot;
import org.eclipse.n4js.workspace.utils.N4JSPackageName;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ide.editor.contentassist.IPrefixMatcher;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * For a {@link ReferenceDescriptor reference in the N4JS source code} (which may be resolved or unresolved), this class
 * provides helper functionality to search all possible {@link ReferenceResolution resolutions}, i.e. all possible
 * target elements the reference may refer to.
 * <p>
 * Do not confuse this with "find references" functionality:
 * <ul>
 * <li>"find references" searches all valid, resolved references in the code base that point to a given identifiable
 * element.
 * <li>this class searches all identifiable elements in the code base that may serve as a valid target for a given,
 * resolved or unresolved, reference.
 * </ul>
 * This functionality is used by
 * <ul>
 * <li>content assist (to compute all content assist proposals),
 * <li>quick fix "add missing import" (to compute the new import to be added),
 * <li>organize imports (to compute new imports to be added for all unresolved references in the file).
 * </ul>
 */
@Singleton
public class ReferenceResolutionFinder {

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IPrefixMatcher prefixMatcher;

	@Inject
	private ContentAssistDataCollectors contentAssistDataCollectors;

	/**
	 * An acceptor receiving valid {@link ReferenceResolution}s for a given {@link ReferenceDescriptor reference}. See
	 * {@link ReferenceResolutionFinder#findResolutions(N4JSWorkspaceConfigSnapshot, ReferenceDescriptor, boolean, boolean, Predicate, Predicate, IResolutionAcceptor)
	 * #searchResolutions()} for details.
	 */
	public interface IResolutionAcceptor {

		/** Invoked when a valid {@link ReferenceResolution} is found. */
		void accept(ReferenceResolution resolution);

		/** Tells if this acceptor is able and willing to accept more {@link ReferenceResolution}s. */
		boolean canAcceptMoreProposals();
	}

	/**
	 * Searches all valid resolutions of the given reference. Note: two higher-level convenience methods are available
	 * in {@link ImportHelper}.
	 *
	 * @param reference
	 *            the reference to resolve.
	 * @param requireFullMatch
	 *            if <code>true</code>, a candidate's name must be <em>equal</em> to the given <code>reference</code>'s
	 *            {@link ReferenceDescriptor#text text}; otherwise it is sufficient if the name <em>starts with</em> the
	 *            text.
	 * @param isUnresolvedReference
	 *            if true, the given <code>reference</code> is assumed to be an unresolved reference (which means
	 *            certain collision checks can be omitted); otherwise nothing will be assumed, i.e. the reference may be
	 *            resolved or unresolved.
	 * @param conflictChecker
	 *            allows for additional checks to be performed on a potential resolution's
	 *            {@link ReferenceResolutionCandidate#shortName shortName}, before it is deemed valid and sent to the
	 *            acceptor.
	 * @param filter
	 *            a filter to decide with candidate {@link IEObjectDescription}s to include in the search. Should return
	 *            <code>true</code> to include the given candidate in the search.
	 * @param acceptor
	 *            an {@link IResolutionAcceptor} that will be invoked with all valid resolutions.
	 */
	public void findResolutions(
			N4JSWorkspaceConfigSnapshot wc,
			ReferenceDescriptor reference,
			boolean requireFullMatch,
			boolean isUnresolvedReference,
			Predicate<String> conflictChecker,
			Predicate<IEObjectDescription> filter,
			IResolutionAcceptor acceptor) {

		IScope scope = getScopeForContentAssist(reference);

		// iterate over candidates, filter them, and create ICompletionProposals for them

		boolean isPropertyAccess = reference.eReference == N4JSPackage.Literals.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION__PROPERTY;
		boolean needCollisionCheck = !isUnresolvedReference && !isPropertyAccess;

		List<IEObjectDescription> candidates = new ArrayList<>(512);
		Map<IEObjectDescription, N4JSProjectConfigSnapshot> projects = new HashMap<>();
		Set<QualifiedName> candidateNames = needCollisionCheck ? new HashSet<>() : null;
		Set<QualifiedName> collisioningModules = new HashSet<>();
		collectAllElements(scope, wc, candidates, projects, candidateNames, collisioningModules, acceptor);

		try (Measurement m = contentAssistDataCollectors.dcIterateAllElements().getMeasurement()) {
			Set<URI> candidateURIs = new HashSet<>(); // note: shadowing for #getAllElements does not work
			for (IEObjectDescription candidate : candidates) {
				if (!acceptor.canAcceptMoreProposals()) {
					return;
				}
				if (!filter.apply(candidate)) {
					continue;
				}

				final N4JSProjectConfigSnapshot candidateProject = projects.get(candidate);

				final Optional<IScope> scopeForCollisionCheck = needCollisionCheck
						? Optional.of(scope)
						: Optional.absent();
				final Optional<Set<QualifiedName>> allElementsForCollisionCheck = needCollisionCheck
						? Optional.of(candidateNames)
						: Optional.absent();
				final ReferenceResolution resolution = getResolution(reference.text, reference.parseTreeNode,
						requireFullMatch, candidate, candidateProject, isPropertyAccess, scopeForCollisionCheck,
						allElementsForCollisionCheck, collisioningModules, conflictChecker);
				if (resolution != null && candidateURIs.add(candidate.getEObjectURI())) {
					acceptor.accept(resolution);
				}
			}
		}
	}

	/**
	 * @param addHere
	 *            elements will be added here.
	 * @param addHereNames
	 *            iff non-<code>null</code>, names of all elements will be added here.
	 * @param addHereCollisioningModules
	 *            iff non-<code>null</code>, module uris that clash (need project import) will be added here.
	 * @param acceptor
	 *            no resolutions will be passed to the acceptor by this method, only used for cancellation handling.
	 */
	private void collectAllElements(IScope scope, N4JSWorkspaceConfigSnapshot wc,
			List<IEObjectDescription> addHere, Map<IEObjectDescription, N4JSProjectConfigSnapshot> addHereProjects,
			Set<QualifiedName> addHereNames, Set<QualifiedName> addHereCollisioningModules,
			IResolutionAcceptor acceptor) {

		try (Measurement m = contentAssistDataCollectors.dcGetAllElements().getMeasurement()) {
			if (!acceptor.canAcceptMoreProposals()) {
				return;
			}
			Map<QualifiedName, N4JSProjectConfigSnapshot> moduleQN2Prj = new HashMap<>();

			Iterator<IEObjectDescription> iter = scope.getAllElements().iterator();
			// note: checking #canAcceptMoreProposals() in next line is required to quickly react to cancellation
			while (acceptor.canAcceptMoreProposals() && iter.hasNext()) {
				IEObjectDescription curr = iter.next();
				if (!isRelevantDescription(curr)) {
					continue;
				}

				addHere.add(curr);
				N4JSProjectConfigSnapshot prj = wc.findProjectContaining(curr.getEObjectURI());
				addHereProjects.put(curr, prj);
				// note: must go on with resolution computation even if 'candidateProject' is 'null', because this will
				// happen in some valid cases (e.g. built-in types)

				if (addHereNames != null) {
					addHereNames.add(curr.getName());
				}
				if (curr.getEObjectURI() != null) {
					QualifiedName candidateModuleQN = QualifiedNameUtils.trimModuleContent(curr.getQualifiedName());
					if (candidateModuleQN != null) {
						if (moduleQN2Prj.containsKey(candidateModuleQN)) {
							if (moduleQN2Prj.get(candidateModuleQN) != prj) {
								addHereCollisioningModules.add(candidateModuleQN);
							}
						} else {
							moduleQN2Prj.put(candidateModuleQN, prj);
						}
					}
				}
			}
		}
	}

	private IScope getScopeForContentAssist(ReferenceDescriptor reference) {
		try (Measurement m = contentAssistDataCollectors.dcGetScope().getMeasurement()) {
			IContentAssistScopeProvider contentAssistScopeProvider = (IContentAssistScopeProvider) scopeProvider;
			EObject context = reference.astNode;
			EObject semanticElement = reference.parseTreeNode.getSemanticElement();

			if (semanticElement != null && EcoreUtil.isAncestor(context, semanticElement)) {
				// sometimes the context represented by reference.astNode is less accurate than that from the iNode
				context = semanticElement;
			}

			return contentAssistScopeProvider.getScopeForContentAssist(context, reference.eReference);
		}
	}

	/**
	 * Returns a resolution if the given candidate is a valid target element for the given reference text (full name or
	 * just prefix, depending on <code>requireFullMatch</code>); otherwise <code>null</code> is returned.
	 *
	 * @param candidate
	 *            the {@link IEObjectDescription} representing the potential target element of the resolution.
	 * @param candidateProjectOrNull
	 *            the containing project of the <code>candidate</code> or <code>null</code> if not available /
	 *            applicable (e.g. in case the candidate represents a built-in type).
	 * @param isPropertyAccess
	 *            <code>true</code> iff content assist is performed for the property of a property access expression;
	 *            means that all computations related to adding missing imports, etc. (including collision checks) can
	 *            be skipped.
	 * @param scopeForCollisionCheck
	 *            a scope that will be used for a collision check. If the reference being resolved is known to be an
	 *            unresolved reference and <code>requireFullMatch</code> is set to <code>true</code>, then this
	 *            collision check can safely be omitted.
	 *
	 * @return the resolution of <code>null</code> if the candidate is not a valid match for the reference.
	 */
	private ReferenceResolution getResolution(String text, INode parseTreeNode, boolean requireFullMatch,
			IEObjectDescription candidate, N4JSProjectConfigSnapshot candidateProjectOrNull, boolean isPropertyAccess,
			Optional<IScope> scopeForCollisionCheck, Optional<Set<QualifiedName>> allElementNamesForCollisionCheck,
			Set<QualifiedName> collisioningModules, Predicate<String> conflictChecker) {

		try (Measurement m1 = contentAssistDataCollectors.dcGetResolution().getMeasurement()) {
			ReferenceResolutionCandidate rrc = new ReferenceResolutionCandidate(candidate, candidateProjectOrNull,
					isPropertyAccess, scopeForCollisionCheck, allElementNamesForCollisionCheck,
					collisioningModules, text, parseTreeNode, requireFullMatch, conflictChecker);

			if (!rrc.isValid) {
				return null;
			}

			try (Measurement m2 = contentAssistDataCollectors.dcGetResolution().getMeasurement()) {
				String proposal = getProposal(rrc);
				String label = getLabel(rrc);
				String description = getDescription(rrc);
				ImportDescriptor importToBeAdded = getImportToBeAdded(rrc);

				return new ReferenceResolution(candidate, proposal, label, description, importToBeAdded);

			} catch (ValueConverterException e) {
				// text does not match the concrete syntax
			}

			return null;
		}
	}

	private String getProposal(ReferenceResolutionCandidate rrc) {
		switch (rrc.accessType) {
		case alias:
			return rrc.aliasName;
		case namespace:
			return rrc.namespaceName.toString();
		default:
			// noop
		}
		if (rrc.newImportHasAlias()) {
			return rrc.addedImportNameAndAlias.alias;
		}
		return rrc.shortName;
	}

	private String getLabel(ReferenceResolutionCandidate rrc) {
		String typeVersion = "";
		if (rrc.isAlias()) {
			return rrc.aliasName + typeVersion;
		}
		if (rrc.isNamespace()) {
			return rrc.namespaceName + typeVersion;
		}
		if (rrc.newImportHasAlias()) {
			return rrc.shortName + typeVersion;
		}

		return rrc.shortName + typeVersion;
	}

	private String getDescription(ReferenceResolutionCandidate rrc) {
		if (rrc.isAlias()) {
			return "alias for " + QualifiedNameUtils.toHumanReadableString(rrc.qualifiedName);
		}
		if (rrc.isNamespace()) {
			return QualifiedNameUtils.toHumanReadableString(rrc.qualifiedName);
		}
		if (rrc.newImportHasAlias()) {
			String descr = "via new alias " + rrc.addedImportNameAndAlias.alias;
			descr += " for " + QualifiedNameUtils.toHumanReadableString(rrc.qualifiedName);
			descr += "\n\n";
			descr += "Introduces the new alias '" + rrc.addedImportNameAndAlias.alias;
			descr += "' for element " + QualifiedNameUtils.toHumanReadableString(rrc.qualifiedName);
			return descr;
		}

		return QualifiedNameUtils.toHumanReadableString(rrc.qualifiedName, true);
	}

	private ImportDescriptor getImportToBeAdded(ReferenceResolutionCandidate rrc) {
		NameAndAlias requestedImport = rrc.addedImportNameAndAlias;
		if (requestedImport == null) {
			return null;
		}

		String elementName = requestedImport.elementName;
		QualifiedName moduleSpecifier = requestedImport.moduleSpecifier;
		String moduleSpecifierStr = qualifiedNameConverter.toString(moduleSpecifier);
		String optionalAlias = requestedImport.alias;

		N4JSPackageName projectName = rrc.candidateProjectOrNull != null
				? rrc.candidateProjectOrNull.getN4JSPackageName()
				: null;
		if (projectName == null) {
			return null;
		}

		ImportDescriptor importDesc;
		if (N4JSLanguageUtils.isDefaultExport(rrc.qualifiedName)) {
			String localName = optionalAlias != null ? optionalAlias
					: N4JSLanguageUtils.lastSegmentOrDefaultHost(rrc.qualifiedName);
			importDesc = ImportDescriptor.createDefaultImport(localName, moduleSpecifierStr, projectName,
					moduleSpecifier, Integer.MAX_VALUE);
		} else {
			importDesc = ImportDescriptor.createNamedImport(elementName, optionalAlias, moduleSpecifierStr, projectName,
					moduleSpecifier, Integer.MAX_VALUE);
		}

		return importDesc;
	}

	private static enum CandidateAccessType {
		direct, alias, namespace
	}

	private class ReferenceResolutionCandidate {
		final IEObjectDescription candidate;
		final IEObjectDescription candidateViaScopeShortName;
		/** If <code>true</code>, then collision check and computation of a new import will be skipped. */
		final boolean isPropertyAccess;
		/** The project containing the candidate. Might be <code>null</code>, e.g. in case of built-in types. */
		final N4JSProjectConfigSnapshot candidateProjectOrNull;
		final boolean isScopedCandidateEqual;
		final boolean isScopedCandidateCollisioning;
		final boolean isValid;
		final EObject parentImportElement;
		final String parentImportModuleName;
		final QualifiedName qualifiedName;
		final String shortName;
		final QualifiedName namespaceName;
		final String aliasName;
		final CandidateAccessType accessType;
		final NameAndAlias addedImportNameAndAlias;

		ReferenceResolutionCandidate(IEObjectDescription candidate, N4JSProjectConfigSnapshot candidateProjectOrNull,
				boolean isPropertyAccess, Optional<IScope> scopeForCollisionCheck,
				Optional<Set<QualifiedName>> allElementNamesForCollisionCheck,
				Set<QualifiedName> collisioningModules, String text, INode parseTreeNode,
				boolean requireFullMatch, Predicate<String> conflictChecker) {

			try (Measurement m = contentAssistDataCollectors.dcCreateReferenceResolutionCandidate1().getMeasurement()) {
				if (!isPropertyAccess && !requireFullMatch && !scopeForCollisionCheck.isPresent()) {
					throw new IllegalArgumentException(
							"collision check may only be omitted if candidate never needs an import OR a full match is required");
				}
				if (isPropertyAccess && scopeForCollisionCheck.isPresent()) {
					throw new IllegalArgumentException(
							"collision check should be omitted if candidate never needs an import");
				}

				this.candidate = candidate;
				this.candidateProjectOrNull = candidateProjectOrNull;
				this.isPropertyAccess = isPropertyAccess;
				this.shortName = getShortName();
				this.qualifiedName = getQualifiedName();
				this.parentImportElement = getParentImportElement(parseTreeNode);
				this.parentImportModuleName = getParentImportModuleName();
			}
			try (Measurement m = contentAssistDataCollectors.dcDetectProposalConflicts().getMeasurement()) {
				this.candidateViaScopeShortName = getCorrectCandidateViaScope(scopeForCollisionCheck,
						allElementNamesForCollisionCheck);
			}
			try (Measurement m = contentAssistDataCollectors.dcCreateReferenceResolutionCandidate2().getMeasurement()) {
				this.isScopedCandidateEqual = isEqualCandidateName(candidateViaScopeShortName, qualifiedName);
				this.isScopedCandidateCollisioning = isScopedCandidateCollisioning();
				this.accessType = getAccessType();
				this.aliasName = getAliasName();
				this.namespaceName = getNamespaceName();
				this.addedImportNameAndAlias = getImportChanges(collisioningModules);
				this.isValid = isValid(text, requireFullMatch, conflictChecker);
			}
		}

		private String getShortName() {
			QualifiedName qName = candidate.getQualifiedName();
			return lastSegmentOrDefaultHost(qName);
		}

		/** @return true iff this candidate is valid and should be shown as a proposal */
		private boolean isValid(String text, boolean requireFullMatch, Predicate<String> conflictChecker) {
			boolean validName = false;
			validName |= isMatch(shortName, text, requireFullMatch);
			validName |= isAlias() && isMatch(aliasName, text, requireFullMatch);
			validName |= isNamespace()
					&& prefixMatcher.isCandidateMatchingPrefix(namespaceName.getLastSegment(), text);

			boolean valid = validName;
			valid &= !Strings.isNullOrEmpty(shortName);
			valid &= !conflictChecker.apply(shortName);
			valid &= parentImportModuleName == null || qualifiedName.toString("/").startsWith(parentImportModuleName);

			return valid;
		}

		private boolean isMatch(String name, String text, boolean requireFullMatch) {
			if (requireFullMatch) {
				return text.equals(name);
			}
			return prefixMatcher.isCandidateMatchingPrefix(name, text);
		}

		private QualifiedName getQualifiedName() {
			QualifiedName qName = candidate.getQualifiedName();

			if (qName.toString().equals(shortName)) {
				QualifiedName qnOfEObject = getCompleteQualifiedName(candidate);
				if (qnOfEObject != null) {
					return qnOfEObject;
				}
			}

			return qName;
		}

		private IEObjectDescription getCorrectCandidateViaScope(Optional<IScope> scopeForCollisionCheck,
				Optional<Set<QualifiedName>> allElementNamesForCollisionCheck) {
			if (!isPropertyAccess && scopeForCollisionCheck.isPresent()) {
				IScope scope = scopeForCollisionCheck.get();
				Set<QualifiedName> allElementNames = allElementNamesForCollisionCheck.get();
				IEObjectDescription candidateViaScope = getCandidateViaScope(scope, allElementNames);
				candidateViaScope = specialcaseNamespaceShadowsOwnElement(scope, candidateViaScope);
				return candidateViaScope;
			}
			return null;
		}

		private IEObjectDescription getCandidateViaScope(IScope scope, Set<QualifiedName> allElementNames) {
			QualifiedName shortNameQN = QualifiedName.create(shortName);
			// because 'scope.getElements()' is slow-ish and we are invoked for every element in
			// 'scope.getAllElements()' (see #collectAllElements() above), we use this guard:
			if (!allElementNames.contains(shortNameQN)) {
				return null;
			}
			List<IEObjectDescription> elements = Lists.newArrayList(Iterables.filter(
					scope.getElements(shortNameQN), ReferenceResolutionFinder::isRelevantDescription));
			if (elements.isEmpty()) {
				return null;
			}
			if (elements.size() > 1) {
				for (IEObjectDescription element : elements) {
					if (isEqualCandidateName(element, qualifiedName)) {
						return element;
					}
				}
			}
			if (!elements.isEmpty()) {
				return elements.get(0);
			}

			return null;
		}

		private IEObjectDescription specialcaseNamespaceShadowsOwnElement(IScope scope,
				IEObjectDescription candidateViaScope) {

			if (candidateViaScope == null) {
				return candidateViaScope;
			}

			if (candidate.getEObjectOrProxy() instanceof ModuleNamespaceVirtualType) {
				return candidateViaScope;
			}

			EObject eObject = candidateViaScope.getEObjectOrProxy();
			if (!(candidateViaScope.getEObjectOrProxy() instanceof ModuleNamespaceVirtualType)) {
				return candidateViaScope;
			}

			ModuleNamespaceVirtualType mnvt = (ModuleNamespaceVirtualType) eObject;
			TModule module = mnvt.getModule();
			if (module == null) {
				return candidateViaScope;
			}

			String moduleQN = module.getQualifiedName();
			String candidateNamespaceName = candidateViaScope.getName().toString();
			if (!candidateNamespaceName.equals(shortName)) {
				return candidateViaScope;
			}

			QualifiedName qualifiedNameViaModule = QualifiedName.create(moduleQN).append(shortName);
			IEObjectDescription shadowedCandidateViaScope = scope.getSingleElement(qualifiedNameViaModule);
			if (shadowedCandidateViaScope == null) {
				return candidateViaScope;
			}

			QualifiedName qualifiedNameViaNamespace = QualifiedName.create(candidateNamespaceName).append(shortName);
			if (!qualifiedName.equals(qualifiedNameViaModule)) {
				return candidateViaScope;
			}

			// handle special case:
			return new PlainAccessOfNamespacedImportDescription(shadowedCandidateViaScope, qualifiedNameViaNamespace);
		}

		/** @return the complete qualified name using {@link IQualifiedNameProvider} */
		private QualifiedName getCompleteQualifiedName(IEObjectDescription objDescr) {
			if (objDescr == null) {
				return null;
			}
			EObject eObjectOrProxy = objDescr.getEObjectOrProxy();
			if (eObjectOrProxy == null) {
				return null;
			}
			QualifiedName qnOfEObject = qualifiedNameProvider.getFullyQualifiedName(eObjectOrProxy);
			return qnOfEObject;
		}

		/** @return true iff the {@link QualifiedName} of the given objDescr equals the given qName */
		private boolean isEqualCandidateName(IEObjectDescription objDescr, QualifiedName qName) {
			QualifiedName qnOfEObject = getCompleteQualifiedName(objDescr);
			if (qnOfEObject == null) {
				return false;
			}
			return qnOfEObject.equals(qName);
		}

		/**
		 * @return true iff {@link #candidate} and {@link #candidateViaScopeShortName} are different but accessible via
		 *         the same short name
		 */
		private boolean isScopedCandidateCollisioning() {
			if (isPropertyAccess) {
				return false;
			}
			if (isScopedCandidateEqual) {
				return false;
			}
			if (candidateViaScopeShortName instanceof PlainAccessOfAliasedImportDescription) {
				String candidateAlias = ((PlainAccessOfAliasedImportDescription) candidateViaScopeShortName).getAlias();
				if (!shortName.equals(candidateAlias)) {
					return false;
				}
			}
			if (candidateViaScopeShortName instanceof PlainAccessOfNamespacedImportDescription) {
				QualifiedName candidateNamespaceName = ((PlainAccessOfNamespacedImportDescription) candidateViaScopeShortName)
						.getNamespacedName();
				if (!shortName.equals(candidateNamespaceName.toString())) {
					return false;
				}
			}
			return true;
		}

		private CandidateAccessType getAccessType() {
			if (isScopedCandidateEqual) {
				if (candidateViaScopeShortName instanceof PlainAccessOfAliasedImportDescription) {
					return CandidateAccessType.alias;
				}
				if (candidateViaScopeShortName instanceof PlainAccessOfNamespacedImportDescription) {
					return CandidateAccessType.namespace;
				}
			}
			if (candidate instanceof AliasedEObjectDescription) {
				return CandidateAccessType.alias;
			}
			return CandidateAccessType.direct;
		}

		private String getAliasName() {
			if (accessType == CandidateAccessType.alias) {
				if (candidate instanceof AliasedEObjectDescription) {
					return candidate.getName().toString();
				}
				return ((PlainAccessOfAliasedImportDescription) candidateViaScopeShortName).getAlias();
			}
			return null;
		}

		private QualifiedName getNamespaceName() {
			if (accessType == CandidateAccessType.namespace) {
				return ((PlainAccessOfNamespacedImportDescription) candidateViaScopeShortName).getNamespacedName();
			}
			return null;
		}

		private EObject getParentImportElement(INode parseTreeNode) {
			while (parseTreeNode != null) {
				EObject semanticElement = parseTreeNode.getSemanticElement();
				if (semanticElement instanceof ImportDeclaration
						|| N4JSLanguageUtils.isDynamicImportCall(semanticElement)) {
					return semanticElement;
				}
				parseTreeNode = parseTreeNode.getParent();
			}
			return null;
		}

		private String getParentImportModuleName() {
			// TODO: Deal with dynamic imports: 'import("lib/myModule");'
			if (parentImportElement instanceof ImportDeclaration) {
				// TODO GH-1704: could also be done via scoping
				ImportDeclaration impDecl = (ImportDeclaration) parentImportElement;
				return impDecl.getModuleSpecifierAsText();
			}

			return null;
		}

		private NameAndAlias getImportChanges(Set<QualifiedName> collisioningModules) {
			if (isPropertyAccess) {
				return null;
			}

			if (parentImportElement != null) {
				return null;
			}

			if (accessType != CandidateAccessType.direct) {
				return null;
			}

			QualifiedName importName = candidate.getQualifiedName();
			if (importName == null) {
				return null;
			}

			// we could create an import statement if there is no conflict
			if (importName.getSegmentCount() == 1) {
				// type name is a simple name - no need to hassle with imports
				return null;
			}

			// Globally available elements should not generate imports
			if (QualifiedNameUtils.isGlobal(qualifiedName)) {
				// type name is a simple name from global Namespace - no need to hassle with imports
				return null;
			}

			String elementName = getImportElementName();
			if (elementName == null) {
				return null;
			}

			QualifiedName moduleSpecifier = getImportModuleSpecifier(collisioningModules);
			if (moduleSpecifier == null) {
				return null;
			}

			String alias = null;

			if (candidateViaScopeShortName != null && isScopedCandidateCollisioning) {
				// accessing default export via already imported namespace
				if (candidateViaScopeShortName.getEObjectOrProxy() instanceof ModuleNamespaceVirtualType) {
					// return null;
				}

				// the simple name is already reachable, i.e. already in use - another import is present
				// try to use an alias
				alias = "Alias_" + UtilN4.toUpperCaseFirst(qualifiedName.toString()
						.replace("." + N4JSQualifiedNameProvider.MODULE_CONTENT_SEGMENT + ".", "_")
						.replace(".", "_"));
			}

			return new NameAndAlias(elementName, moduleSpecifier, alias);
		}

		private String getImportElementName() {
			QualifiedName candidateElementQN = QualifiedNameUtils.getModuleContent(qualifiedName);
			if (candidateElementQN == null || candidateElementQN.isEmpty()) {
				return null;
			}
			if (candidateElementQN.getSegmentCount() > 1) {
				// type is nested in namespace(s) - no way to import it directly
				return null;
			}
			return candidateElementQN.getSegment(0);
		}

		private QualifiedName getImportModuleSpecifier(Set<QualifiedName> collisioningModules) {
			QualifiedName candidateModuleQN = QualifiedNameUtils.trimModuleContent(qualifiedName);
			if (candidateModuleQN == null) {
				return null;
			}

			String candidateModuleQNStr = qualifiedNameConverter.toString(candidateModuleQN);
			ProjectType projectType = candidateProjectOrNull != null ? candidateProjectOrNull.getType() : null;

			QualifiedName moduleSpecifier;
			if (candidateProjectOrNull != null && candidateModuleQNStr != null
					&& N4JSLanguageUtils.isMainModule(candidateProjectOrNull, candidateModuleQNStr)) {
				// use project import when importing from a main module (e.g. index.Element -> react.Element)
				N4JSPackageName projectName = getNameOfDefinedOrGivenProject(candidateProjectOrNull);
				moduleSpecifier = projectName.toQualifiedName();

			} else if (candidateProjectOrNull != null && (projectType == ProjectType.PLAINJS
					|| projectType == ProjectType.DEFINITION
					|| collisioningModules.contains(candidateModuleQN))) {
				// use complete module specifier (i.e. prepend project name) when importing
				// from PLAINJS or DEFINITION project
				// OR when the imported module is clashing with another module that is equally named
				N4JSPackageName projectName = getNameOfDefinedOrGivenProject(candidateProjectOrNull);
				moduleSpecifier = projectName.toQualifiedName().append(candidateModuleQN);

			} else {
				// standard case: use plain module specifier
				moduleSpecifier = candidateModuleQN;
			}
			return moduleSpecifier;
		}

		public boolean hasNewImport() {
			return addedImportNameAndAlias != null;
		}

		public boolean newImportHasAlias() {
			return hasNewImport() && !Strings.isNullOrEmpty(addedImportNameAndAlias.alias);
		}

		public boolean isAlias() {
			return accessType == CandidateAccessType.alias;
		}

		public boolean isNamespace() {
			return accessType == CandidateAccessType.namespace;
		}
	}

	/**
	 * Returns <code>true</code> iff the given description is relevant for the purpose of reference resolution finding
	 * in this class. All other descriptions will be ignored.
	 */
	private static boolean isRelevantDescription(IEObjectDescription desc) {
		if (desc instanceof PlainAccessOfAliasedImportDescription
				|| desc instanceof PlainAccessOfNamespacedImportDescription
				|| desc instanceof WrongTypingStrategyDescription) {
			// for these subclasses of IEObjectDescriptionWithError method #isActualElementInScope() would return
			// 'false'; but because some special handling exists in the above code for these classes, we actually have
			// to treat them as relevant, i.e. return 'true' for them:
			return true;
		}
		// standard case:
		return N4JSLanguageUtils.isActualElementInScope(desc);
	}

	private static N4JSPackageName getNameOfDefinedOrGivenProject(N4JSProjectConfigSnapshot project) {
		if (project.getType() == ProjectType.DEFINITION) {
			N4JSPackageName definedProjectName = project.getDefinesPackage();
			if (definedProjectName != null) {
				return definedProjectName;
			}
		}
		return project.getN4JSPackageName();
	}

	private static class NameAndAlias {
		private final String elementName;
		private final QualifiedName moduleSpecifier;
		private final String alias;

		public NameAndAlias(String elementName, QualifiedName moduleSpecifier, String alias) {
			this.elementName = elementName;
			this.moduleSpecifier = moduleSpecifier;
			this.alias = alias;
		}
	}
}
