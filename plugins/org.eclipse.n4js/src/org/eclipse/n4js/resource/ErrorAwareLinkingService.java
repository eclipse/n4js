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
package org.eclipse.n4js.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.N4JSLanguageConstants;
import org.eclipse.n4js.n4JS.DefaultImportSpecifier;
import org.eclipse.n4js.n4JS.IdentifierRef;
import org.eclipse.n4js.n4JS.N4JSPackage;
import org.eclipse.n4js.scoping.IUsageAwareEObjectDescription;
import org.eclipse.n4js.scoping.utils.UnresolvableObjectDescription;
import org.eclipse.n4js.scoping.validation.ScopeElementIssue;
import org.eclipse.n4js.scoping.validation.ScopeInfo;
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef;
import org.eclipse.n4js.ts.typeRefs.TypeRefsPackage;
import org.eclipse.n4js.ts.types.AnyType;
import org.eclipse.n4js.ts.types.TypesPackage;
import org.eclipse.n4js.typesystem.utils.RuleEnvironment;
import org.eclipse.n4js.typesystem.utils.RuleEnvironmentExtensions;
import org.eclipse.n4js.utils.URIUtils;
import org.eclipse.n4js.utils.languages.N4LanguageUtils;
import org.eclipse.n4js.workspace.WorkspaceAccess;
import org.eclipse.n4js.xtext.scoping.IEObjectDescriptionWithError;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;

/**
 * Additional to {@link DefaultLinkingService} it handles {@link IEObjectDescription} typed as
 * {@link IEObjectDescriptionWithError} to produce linking diagnostics (i.e. error messages for not resolvable links)
 * for them. This is only done, when validation is enabled.
 */
public class ErrorAwareLinkingService extends DefaultLinkingService {

	private static final EReference PARAMETERIZED_TYPE_REF__DECLARED_TYPE = TypeRefsPackage.eINSTANCE
			.getParameterizedTypeRef_DeclaredType();
	private static final EReference NAMED_IMPORT_SPECIFIER__IMPORTED_ELEMENT = N4JSPackage.eINSTANCE
			.getNamedImportSpecifier_ImportedElement();

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private WorkspaceAccess workspaceAccess;

	/**
	 * Override to get scope based on the context, otherwise we might get scope for main language, while context is from
	 * sub-language.
	 */
	@Override
	protected IScope getScope(EObject context, EReference reference) {
		IScopeProvider scopeProvider = N4LanguageUtils.getServiceForContext(context, IScopeProvider.class)
				.orElse(super.getScopeProvider());
		if (getScopeProvider() == null)
			throw new IllegalStateException("scopeProvider must not be null.");
		try {
			registerImportedNamesAdapter(scopeProvider, context);
			return scopeProvider.getScope(context, reference);
		} finally {
			unRegisterImportedNamesAdapter(scopeProvider);
		}
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final String crossRefString = getCrossRefNodeAsString(context, ref, node);
		if (crossRefString != null && !crossRefString.equals("")) {
			final IScope scope = getScope(context, ref);
			QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString);

			IEObjectDescription eObjectDescription = null;
			if (scope instanceof ScopeInfo) {
				ScopeInfo scopeInfo = ((ScopeInfo) scope);
				eObjectDescription = scopeInfo.getScope().getSingleElement(qualifiedLinkName);

			} else {
				eObjectDescription = scope.getSingleElement(qualifiedLinkName);
			}

			IEObjectDescriptionWithError errorDescr;
			Resource resource = context.eResource();
			if (resource != null
					&& (errorDescr = IEObjectDescriptionWithError
							.getDescriptionWithError(eObjectDescription)) != null
					// isNoValidate traverses the file system so it should be the last part of the check
					&& !workspaceAccess.isNoValidate(resource, resource.getURI())) {
				addIssue(context, ref, node, errorDescr);
			} else if (eObjectDescription instanceof UnresolvableObjectDescription) {
				return Collections.<EObject> singletonList((EObject) context.eGet(ref, false));
			}

			if (scope instanceof ScopeInfo) {
				ScopeInfo scopeInfo = ((ScopeInfo) scope);

				if (!scopeInfo.isValid(eObjectDescription) && resource != null
						&& !workspaceAccess.isNoValidate(resource, resource.getURI())) {

					eObjectDescription = null;
					IEObjectDescription invalidEOD = null;
					Iterable<IEObjectDescription> elements = scopeInfo.getScope().getElements(qualifiedLinkName);
					for (IEObjectDescription elem : elements) {
						if (scopeInfo.isValid(elem)) {
							eObjectDescription = elem;
						} else {
							invalidEOD = elem;
						}
					}

					if (invalidEOD != null) {
						if (eObjectDescription == null) {
							List<ScopeElementIssue> issues = scopeInfo.getIssues(invalidEOD);
							for (ScopeElementIssue issue : issues) {
								addIssue(context, ref, node, issue);
							}
							eObjectDescription = invalidEOD;
						} else {
							markAsUsed(invalidEOD, context);
						}
					}
				}
			}

			if (eObjectDescription != null) {
				EObject candidate = eObjectDescription.getEObjectOrProxy();
				if (!candidate.eIsProxy() && candidate.eResource() == null) {
					// Error is necessary since EMF catches all exceptions in EcoreUtil#resolve
					throw new AssertionError("Found an instance without resource and without URI");
				}

				markAsUsed(eObjectDescription, context);

				return Collections.singletonList(candidate);
			}
		}

		if (N4JSGlobals.DTS_FILE_EXTENSION.equals(URIUtils.fileExtension(context.eResource().getURI()))) {
			if (ref == PARAMETERIZED_TYPE_REF__DECLARED_TYPE || ref == NAMED_IMPORT_SPECIFIER__IMPORTED_ELEMENT) {
				RuleEnvironment G = RuleEnvironmentExtensions.newRuleEnvironment(context);
				AnyType anyType = RuleEnvironmentExtensions.anyType(G);
				return Collections.singletonList(anyType);

			} else if (ref.getEType() == TypesPackage.eINSTANCE.getType()) {
				RuleEnvironment G = RuleEnvironmentExtensions.newRuleEnvironment(context);
				AnyType anyType = RuleEnvironmentExtensions.anyType(G);
				return Collections.singletonList(anyType);
			}
		}
		return Collections.emptyList();
	}

	/** if supported, mark object description as used and record the origin import */
	private void markAsUsed(IEObjectDescription eObjectDescription, EObject context) {
		if (eObjectDescription instanceof IUsageAwareEObjectDescription) {
			IUsageAwareEObjectDescription eObjectDescriptionCasted = (IUsageAwareEObjectDescription) eObjectDescription;
			eObjectDescriptionCasted.markAsUsed();
			if (context instanceof IdentifierRef) {
				eObjectDescriptionCasted.recordOrigin((IdentifierRef) context);
			}
		}
	}

	/**
	 * Converts the cross reference specified by the given parameters to a string.
	 *
	 * As {@link #getCrossRefNodeAsString(INode)}, but gets more information passed in to decide if some special
	 * handling is required. By default, simply delegates to {@code #getCrossRefNodeAsString(INode)}.
	 */
	public String getCrossRefNodeAsString(EObject context, EReference ref, INode node) {
		if (ref == NAMED_IMPORT_SPECIFIER__IMPORTED_ELEMENT && context instanceof DefaultImportSpecifier) {
			// special case: we got a default import of the form: import localName from "some/module"
			return N4JSLanguageConstants.EXPORT_DEFAULT_NAME; // "default"
		}
		// standard cases:
		String result = getCrossRefNodeAsString(node);

		if (ref == PARAMETERIZED_TYPE_REF__DECLARED_TYPE && context instanceof ParameterizedTypeRef) {
			// special case: we might have a reference to a type C imported via namespace import: NS.C
			// -> replace '.' by '/' to make it a valid qualified name
			ParameterizedTypeRef ptr = (ParameterizedTypeRef) context;
			result = ptr.getDeclaredTypeAsText();
			result = result != null ? result.replace(".", N4JSGlobals.QUALIFIED_NAME_DELIMITER) : null;
		}
		return result;
	}

	/**
	 * Add the error to the resource of the given {@code context} if it does support validation.
	 *
	 * @param context
	 *            the context object that caused the error.
	 * @param node
	 *            the error location.
	 * @param issue
	 *            the actual error description.
	 */
	protected void addIssue(EObject context, EReference ref, INode node, IEObjectDescriptionWithError issue) {
		doAddIssue(context, ref, node, issue, issue.getSeverity(), issue.getIssueCode(), issue.getMessage());
	}

	/**
	 * Add the error to the resource of the given {@code context} if it does support validation.
	 *
	 * @param context
	 *            the context object that caused the error.
	 * @param node
	 *            the error location.
	 * @param issue
	 *            the actual error description.
	 */
	protected void addIssue(EObject context, EReference ref, INode node, ScopeElementIssue issue) {
		doAddIssue(context, ref, node, issue.delegate, issue.severity, issue.issueCode, issue.message);
	}

	private void doAddIssue(EObject context, EReference ref, INode node, IEObjectDescription objDescr,
			Severity severity, String issueCode, String message) {

		N4JSResource resource = (N4JSResource) context.eResource();
		if (resource.isValidationDisabled()) {
			return;
		}

		List<Diagnostic> list;
		if (severity == Severity.WARNING) {
			list = resource.getWarnings();
		} else {
			list = resource.getErrors();
		}

		// Convert key value user data to String array
		String[] userData = null;
		if (objDescr.getUserDataKeys() != null) {
			ArrayList<String> userDataList = new ArrayList<>(objDescr.getUserDataKeys().length * 2);
			for (String userDataKey : objDescr.getUserDataKeys()) {
				final String userDataValue = objDescr.getUserData(userDataKey);
				if (userDataValue != null) {
					userDataList.add(userDataKey);
					userDataList.add(userDataValue);
				}
			}
			userData = userDataList.toArray(new String[userDataList.size()]);
		}

		Diagnostic diagnostic = new XtextLinkingDiagnostic(node, message, issueCode, userData);

		if (!list.contains(diagnostic)) {
			list.add(diagnostic);

			resource.getASTMetaInfoCacheVerifyContext().storeLinkingIssueCode(context, ref, issueCode);
		}
	}
}
