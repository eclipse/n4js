/**
 * Copyright (c) 2021 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.ide.tests.helper.server.xt;

import static org.eclipse.n4js.ide.tests.helper.server.xt.EObjectDescriptionToNameWithPositionMapper.descriptionToNameWithPosition;
import static org.eclipse.n4js.typesystem.utils.RuleEnvironmentExtensions.newRuleEnvironment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.n4js.formatting2.N4JSFormatterPreferenceKeys;
import org.eclipse.n4js.jsdoc2spec.adoc.ADocFactory;
import org.eclipse.n4js.jsdoc2spec.adoc.RepoRelativePathHolder;
import org.eclipse.n4js.jsdoc2spec.adoc.SpecIdentifiableElementSection;
import org.eclipse.n4js.n4JS.AbstractVariable;
import org.eclipse.n4js.n4JS.BindingProperty;
import org.eclipse.n4js.n4JS.ExportDeclaration;
import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.n4js.n4JS.FunctionDeclaration;
import org.eclipse.n4js.n4JS.GenericDeclaration;
import org.eclipse.n4js.n4JS.LiteralOrComputedPropertyName;
import org.eclipse.n4js.n4JS.N4MemberDeclaration;
import org.eclipse.n4js.n4JS.N4TypeDeclaration;
import org.eclipse.n4js.n4JS.N4TypeVariable;
import org.eclipse.n4js.n4JS.NamedElement;
import org.eclipse.n4js.n4JS.ParameterizedCallExpression;
import org.eclipse.n4js.n4JS.ParameterizedPropertyAccessExpression;
import org.eclipse.n4js.n4JS.PropertyNameOwner;
import org.eclipse.n4js.n4JS.TypeDefiningElement;
import org.eclipse.n4js.n4JS.TypeReferenceNode;
import org.eclipse.n4js.n4JS.VariableDeclaration;
import org.eclipse.n4js.n4JS.VariableStatement;
import org.eclipse.n4js.postprocessing.ASTMetaInfoUtils;
import org.eclipse.n4js.resource.N4JSResource;
import org.eclipse.n4js.scoping.utils.QualifiedNameUtils;
import org.eclipse.n4js.ts.typeRefs.FunctionTypeExprOrRef;
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef;
import org.eclipse.n4js.ts.typeRefs.TypeRef;
import org.eclipse.n4js.ts.types.IdentifiableElement;
import org.eclipse.n4js.ts.types.TMember;
import org.eclipse.n4js.ts.types.TypableElement;
import org.eclipse.n4js.ts.types.TypeVariable;
import org.eclipse.n4js.typesystem.N4JSTypeSystem;
import org.eclipse.n4js.typesystem.utils.RuleEnvironment;
import org.eclipse.n4js.typesystem.utils.RuleEnvironmentExtensions;
import org.eclipse.n4js.utils.FindReferenceHelper;
import org.eclipse.n4js.validation.N4JSElementKeywordProvider;
import org.eclipse.n4js.xtext.scoping.FilteringScope;
import org.eclipse.n4js.xtext.scoping.IEObjectDescriptionWithError;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.ExceptionAcceptor;
import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Class that holds implementations for xt test methods
 */
@SuppressWarnings("restriction")
public class XtMethods {
	@Inject
	private N4JSTypeSystem ts;

	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	@Inject
	private N4JSElementKeywordProvider keywordProvider;

	@Inject
	private FindReferenceHelper findReferenceHelper;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IResourceDescription.Manager manager;

	@Inject
	private Provider<IFormatter2> formatterProvider;

	@Inject
	private Provider<FormatterRequest> formatterRequestProvider;

	@Inject
	private ADocFactory adocFactory;

	@Inject
	private RepoRelativePathHolder repoPathHolder;

	/** Implementation for {@link XtIdeTest#accessModifier(XtMethodData)} */
	static public String getAccessModifierString(EObject context) {
		String actual = null;
		if (context instanceof TMember) {
			TMember tMember = (TMember) context;
			actual = tMember.getMemberAccessModifier().getName();
		} else {
			FunctionDeclaration functionDeclaration = EcoreUtil2.getContainerOfType(context, FunctionDeclaration.class);
			if (functionDeclaration != null) {
				actual = functionDeclaration.getDefinedType().getTypeAccessModifier().getName();
			} else {
				VariableStatement variableStatement = EcoreUtil2.getContainerOfType(context, VariableStatement.class);
				if (variableStatement != null) {
					context = variableStatement.getVarDecl().get(0);
					if (context instanceof VariableDeclaration) {
						if (((VariableDeclaration) context).isDirectlyExported()) {
							actual = ((VariableDeclaration) context).getDefinedVariable().getTypeAccessModifier()
									.getName();
						} else {
							actual = "private";
						}
					}
				} else if (context instanceof ExportDeclaration) {
					context = ((ExportDeclaration) context).getExportedElement();
					actual = getAccessModifierString(context);
				} else if (context instanceof ParameterizedPropertyAccessExpression) {
					ParameterizedPropertyAccessExpression ppae = (ParameterizedPropertyAccessExpression) context;
					IdentifiableElement ie = ppae.getProperty();
					actual = getAccessModifierString(ie);
				} else if (context instanceof ParameterizedCallExpression) {
					ParameterizedCallExpression pce = (ParameterizedCallExpression) context;
					Expression targetExpr = pce.getTarget();
					actual = getAccessModifierString(targetExpr);
				} else {
					N4MemberDeclaration member = EcoreUtil2.getContainerOfType(context, N4MemberDeclaration.class);
					N4TypeDeclaration type = EcoreUtil2.getContainerOfType(context, N4TypeDeclaration.class);
					if (type == null && member == null) {
						actual = "no element with access modifier found";
					} else if (type != null && (member == null || EcoreUtil.isAncestor(member, type))) {
						actual = type.getDefinedType().getTypeAccessModifier().getName();
					} else {
						actual = member.getDefinedTypeElement().getMemberAccessModifier().getName();
					}
				}
			}
		}
		return actual;
	}

	/** Implementation for {@link XtIdeTest#elementKeyword(XtMethodData)} */
	public String getElementKeywordString(IEObjectCoveringRegion ocr) {
		int offset = ocr.getOffset();
		EObject eObject = ocr.getEObject();
		// Get the cross-referenced element at the offset.
		EObject crossRef = offsetHelper.resolveCrossReferencedElementAt((XtextResource) eObject.eResource(), offset);

		String elementKeywordStr = keywordProvider.keyword(crossRef == null ? eObject : crossRef);
		return elementKeywordStr;
	}

	/** Implementation for {@link XtIdeTest#exportedObjects(XtMethodData)} */
	public List<String> getExportedObjectsString(IEObjectCoveringRegion ocr) {
		IResourceDescription resourceDescription = manager.getResourceDescription(ocr.getXtextResource());
		Iterable<IEObjectDescription> exportedObjects = resourceDescription.getExportedObjects();
		List<String> exportedObjectStrings = new ArrayList<>();
		for (IEObjectDescription desc : exportedObjects) {
			String str = desc.getEClass().getEPackage().getNsPrefix()
					+ "::" + desc.getEClass().getName()
					+ ": " + QualifiedNameUtils.toHumanReadableString(desc.getName());
			exportedObjectStrings.add(str);
		}
		return exportedObjectStrings;
	}

	/** Implementation for {@link XtIdeTest#findReferences(XtMethodData)} */
	public List<String> getFindReferences(IEObjectCoveringRegion ocr) {
		int offset = ocr.getOffset();
		EObject eObject = ocr.getEObject();
		EObject argEObj = offsetHelper.resolveElementAt((XtextResource) eObject.eResource(), offset);
		// If not a cross-reference element, use context instead
		if (argEObj == null) {
			argEObj = eObject;
		}

		EObject eObj = argEObj;

		if (argEObj instanceof ParameterizedTypeRef) {
			eObj = ((ParameterizedTypeRef) argEObj).getDeclaredType();
		}

		List<EObject> refs = findReferenceHelper.findReferences(eObj, eObject.eResource().getResourceSet());
		ArrayList<String> result = Lists.newArrayList();
		for (EObject ref : refs) {
			if (ref instanceof PropertyNameOwner && ((PropertyNameOwner) ref).getDeclaredName() != null) {
				ref = ((PropertyNameOwner) ref).getDeclaredName();
			}

			ICompositeNode srcNode = NodeModelUtils.getNode(ref);
			int line = srcNode.getStartLine();

			String moduleName = "(unknown resource)";
			if (ref.eResource() instanceof N4JSResource) {
				N4JSResource n4jsResource = (N4JSResource) ref.eResource();
				moduleName = n4jsResource.getModule().getQualifiedName();
			}

			String text = NodeModelUtils.getTokenText(srcNode);
			if (ref instanceof GenericDeclaration) {
				text = ((GenericDeclaration) ref).getDefinedType().getName();
			}
			if (ref instanceof BindingProperty && ((BindingProperty) ref).getProperty() != null) {
				text = ((BindingProperty) ref).getPropertyAsText();
			}

			String resultText = moduleName + " - " + text + " - " + line;
			result.add(resultText);
		}

		return result;
	}

	/** Implementation for {@link XtIdeTest#linkedFragment(XtMethodData)} */
	public String getLinkedFragment(IEObjectCoveringRegion ocr) {
		int offset = ocr.getOffset();
		EObject eObject = ocr.getEObject();
		XtextResource eResource = (XtextResource) eObject.eResource();
		EObject targetObject = offsetHelper.resolveCrossReferencedElementAt(eResource, offset);
		if (targetObject == null) {
			Assert.fail("Reference is null");
		} else {
			URI baseUri = eObject.eResource().getURI();
			String fragmentName = getLinkedFragment(targetObject, baseUri);
			return fragmentName;
		}
		return null;
	}

	/** Implementation for {@link XtIdeTest#linkedName(XtMethodData)} */
	@Xpect
	public QualifiedName getLinkedName(IEObjectCoveringRegion ocr) {
		int offset = ocr.getOffset();
		EObject eObject = ocr.getEObject();
		// Get the cross-referenced element at the offset.
		XtextResource eResource = (XtextResource) eObject.eResource();
		EObject targetObject = offsetHelper.resolveCrossReferencedElementAt(eResource, offset);
		if (targetObject == null) {
			Assert.fail("Reference is null");
			return null; // to avoid warnings in the following
		}
		if (targetObject.eIsProxy()) {
			Assert.fail("Reference is a Proxy: " + ((InternalEObject) targetObject).eProxyURI());
		}
		Resource targetResource = targetObject.eResource();
		if (targetResource instanceof TypeResource) {
			targetResource = eObject.eResource();
		}
		if (!(targetResource instanceof XtextResource)) {
			Assert.fail("Referenced EObject is not in an XtextResource.");
		}
		IQualifiedNameProvider provider = ((XtextResource) targetResource)
				.getResourceServiceProvider().get(IQualifiedNameProvider.class);
		QualifiedName name = provider.getFullyQualifiedName(targetObject);
		return name;
	}

	/** Implementation for {@link XtIdeTest#linkedPathname(XtMethodData)} */
	public String getLinkedPathname(IEObjectCoveringRegion ocr) {
		int offset = ocr.getOffset();
		EObject eObject = ocr.getEObject();
		// Get the cross-referenced element at the offset.
		XtextResource eResource = (XtextResource) eObject.eResource();
		EObject targetObject = offsetHelper.resolveCrossReferencedElementAt(eResource, offset);
		// EObject targetObject = (EObject) eObject.eGet(arg1.getCrossEReference());
		if (targetObject == null) {
			Assert.fail("Reference is null");
			return null; // to avoid warnings in the following
		}
		if (targetObject.eIsProxy())
			Assert.fail("Reference is a Proxy: " + ((InternalEObject) targetObject).eProxyURI());
		Resource targetResource = targetObject.eResource();
		if (targetResource instanceof TypeResource)
			targetResource = eObject.eResource();
		if (!(targetResource instanceof XtextResource))
			Assert.fail("Referenced EObject is not in an XtextResource.");

		Deque<String> segments = new ArrayDeque<>();
		do {
			EStructuralFeature nameFeature = targetObject.eClass().getEStructuralFeature("name");
			if (nameFeature != null) {
				Object obj = targetObject.eGet(nameFeature);
				if (obj instanceof String) {
					segments.push((String) obj);
				}
			} else {
				if (targetObject instanceof NamedElement) {
					segments.push(((NamedElement) targetObject).getName());
				}
			}
			targetObject = targetObject.eContainer();
		} while (targetObject != null);
		String pathname = Joiner.on('/').join(segments);
		return pathname;
	}

	/** Implementation for {@link XtIdeTest#type(XtMethodData)} */
	public String getTypeString(EObject eobject, boolean expectedType, boolean withAliasResolution) {
		if (eobject == null) {
			return "No element found at given region";
		}
		if (eobject instanceof LiteralOrComputedPropertyName) {
			eobject = eobject.eContainer();
		}
		RuleEnvironment G = newRuleEnvironment(eobject);
		TypeRef result;
		if (expectedType) {
			if (!(eobject instanceof Expression && eobject.eContainer() != null))
				return "Not an Expression at given region (required to obtain expected type); got instead: "
						+ eobject.eClass().getName();
			result = ts.expectedType(G, eobject.eContainer(), (Expression) eobject);
		} else {
			if (eobject instanceof BindingProperty) {
				/*-
				 * Small tweak to allow testing the inferred type of variable declarations within binding patterns. For
				 * example, without this tweak, the following test would fail with a "Not a TypableElement at given
				 * region" exception:
				 *
				 * // Xpect type of 'len' --> number
				 * var {length:len} = "hello";
				 */
				if (((BindingProperty) eobject).getValue() != null
						&& ((BindingProperty) eobject).getValue().getVarDecl() != null) {
					eobject = ((BindingProperty) eobject).getValue().getVarDecl();
				}
			}
			if (!(eobject instanceof TypableElement))
				return "Not a TypableElement at given region; got instead: " + eobject.eClass().getName();
			result = ts.type(G, (TypableElement) eobject);
		}
		final String calculatedString = withAliasResolution
				? result.getTypeRefAsStringWithAliasExpansion()
				: result.getTypeRefAsString();
		return calculatedString;
	}

	/** Implementation for {@link XtIdeTest#typeArgs(XtMethodData)} */
	public String getTypeArgumentsString(EObject eobject) {
		final EObject container = eobject != null ? eobject.eContainer() : null;
		if (eobject == null || !(container instanceof ParameterizedCallExpression
				&& ((ParameterizedCallExpression) container).getTarget() == eobject)) {
			// missing or invalid offset
			return "xpect method error: offset not given or does not point to target of a call expression";
		}
		if (!(eobject.eResource() instanceof N4JSResource)) {
			return "xpect method error: offset does not point to an EObject contained in a N4JSResource";
		}
		// offset points to the target of a call expression
		final ParameterizedCallExpression callExpr = (ParameterizedCallExpression) container;
		final RuleEnvironment G = RuleEnvironmentExtensions.newRuleEnvironment(eobject);
		final TypeRef targetTypeRef = ts.type(G, callExpr.getTarget());
		if (!(targetTypeRef instanceof FunctionTypeExprOrRef)) {
			return "xpect method error: cannot infer type of call expression target OR it's not a FunctionTypeExprOrRef";
		}
		final List<TypeVariable> typeParams = ((FunctionTypeExprOrRef) targetTypeRef).getTypeVars();
		final int expectedNumOfTypeArgs = typeParams.size(); // not interested in the actual typeParams, just the size
		final List<TypeRef> typeArgs;
		if (callExpr.getTypeArgs().isEmpty()) {
			// no type arguments given in call expression -> use inferred type arguments
			// (should be the standard case when testing)
			final List<TypeRef> inferredTypeArgs = ASTMetaInfoUtils.getInferredTypeArgs(callExpr);
			if (inferredTypeArgs != null) {
				typeArgs = inferredTypeArgs;
			} else {
				typeArgs = Collections.emptyList();
			}
		} else {
			// call expression is parameterized -> use the explicitly given type arguments
			// (just provided for completeness)
			typeArgs = FluentIterable.from(callExpr.getTypeArgs()).transform(TypeReferenceNode::getTypeRef).toList();
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < expectedNumOfTypeArgs; i++) {
			final TypeRef inferredTypeArg = i < typeArgs.size() ? typeArgs.get(i) : null;
			if (sb.length() > 0)
				sb.append(", ");
			if (inferredTypeArg != null)
				sb.append(inferredTypeArg.getTypeRefAsString());
			else
				sb.append("*missing*");
		}
		return sb.toString();
	}

	/** Implementation for {@link XtIdeTest#binding(XtMethodData)} */
	public String getBindingName(IEObjectCoveringRegion ocr) {
		EObject eobj = ocr.getEObject();
		ParameterizedPropertyAccessExpression ppae = EcoreUtil2.getContainerOfType(eobj,
				ParameterizedPropertyAccessExpression.class);
		IdentifiableElement element;

		if (ppae != null) {
			element = ppae.getProperty();
		} else if (eobj instanceof IdentifiableElement) {
			element = (IdentifiableElement) eobj;
		} else {
			throw new IllegalArgumentException("Cannot check binding for "
					+ (eobj == null ? "null" : eobj.eClass().getName()));
		}
		String container = "";
		if (element instanceof TMember) {
			container = ((TMember) element).getContainingType().getName() + ".";
		}
		final String qn = container + element.getName();

		return qn;
	}

	/** Implementation for {@link XtIdeTest#scope(XtMethodData)} */
	public Set<String> getScopeString(IEObjectCoveringRegion ocr) {
		LinkedHashSet<String> scopeNames = new LinkedHashSet<>();
		for (IEObjectDescription desc : getElementsFromScope(ocr)) {
			scopeNames.add(QualifiedNameUtils.toHumanReadableString(desc.getName()));
		}
		return scopeNames;
	}

	/** Implementation for {@link XtIdeTest#scopeWithResource(XtMethodData)} */
	public Set<String> getScopeWithResourceString(IEObjectCoveringRegion ocr) {
		LinkedHashSet<String> scopeNames = new LinkedHashSet<>();
		URI uri = ocr.getXtextResource().getURI();
		for (IEObjectDescription desc : getElementsFromScope(ocr)) {
			scopeNames.add(descriptionToNameWithPosition(uri, false, desc));
		}
		return scopeNames;
	}

	/** Implementation for {@link XtIdeTest#scopeWithPosition(XtMethodData)} */
	public Set<String> getScopeWithPositionString(IEObjectCoveringRegion ocr) {
		LinkedHashSet<String> scopeNames = new LinkedHashSet<>();
		URI uri = ocr.getXtextResource().getURI();
		for (IEObjectDescription desc : getElementsFromScope(ocr)) {
			scopeNames.add(descriptionToNameWithPosition(uri, true, desc));
		}
		return scopeNames;
	}

	private List<IEObjectDescription> getElementsFromScope(IEObjectCoveringRegion ocr) {
		Assert.assertNotNull(ocr.getEStructuralFeature());
		IScope scope = scopeProvider.getScope(ocr.getEObject(), (EReference) ocr.getEStructuralFeature());
		IScope scopeWithoutErrors = new FilteringScope(scope,
				desc -> !IEObjectDescriptionWithError.isErrorDescription(desc));
		List<IEObjectDescription> allElements = Lists.newArrayList(scopeWithoutErrors.getAllElements());
		return allElements;
	}

	private String getLinkedFragment(EObject targetObject, URI baseUri) {
		if (targetObject.eIsProxy())
			Assert.fail("Reference is a Proxy: " + ((InternalEObject) targetObject).eProxyURI());
		Resource targetResource = targetObject.eResource();
		if (targetResource == null)
			Assert.fail("Referenced EObject is not in a resource.");
		URI target = EcoreUtil.getURI(targetObject);
		return deresolve(baseUri, target);
	}

	private String deresolve(URI base, URI uri) {
		if (base.equals(uri.trimFragment()))
			return uri.fragment();
		return uri.deresolve(base).toString();
	}

	/** Implementation for {@link XtIdeTest#ast(XtMethodData)} */
	public String serializeAst(EObject root) {
		StringBuilder sb = new StringBuilder();
		serializeAst(root, sb, 1);
		return sb.toString().trim();
	}

	private void serializeAst(EObject node, StringBuilder sb, int identLevel) {
		String name = node.getClass().getSimpleName();
		if (name.endsWith("Impl")) {
			name = name.substring(0, name.length() - "Impl".length());
		}
		String props = "";
		List<EStructuralFeature> structuralFeatures = new ArrayList<>(node.eClass().getEAllStructuralFeatures());
		Collections.sort(structuralFeatures, Comparator.comparing(EStructuralFeature::getName));
		for (EStructuralFeature feature : structuralFeatures) {
			Object featureValue = node.eGet(feature);
			if (featureValue != null) {
				boolean serializeProp = false;
				if (feature.isMany() && featureValue instanceof EList<?>) {
					EList<?> list = (EList<?>) featureValue;
					if (!list.isEmpty() && !(list.get(0) instanceof EObject)) {
						serializeProp = true;
					}
				} else {
					serializeProp = !(featureValue instanceof EObject);
				}

				if (serializeProp) {
					props += props.isEmpty() ? ": " : ", ";
					props += featureValue.toString();
				}
			}
		}
		String line = String.format("%1$" + identLevel + "s", "") + name + props + "\n";

		sb.append(line);
		for (EObject child : node.eContents()) {
			serializeAst(child, sb, identLevel + 1);
		}
	}

	// TODO GH-2562
	@SuppressWarnings("unused")
	public String getFormattedLines(int startOffset, int lines, Map<String, String> prefsMap) {
		int length = 0;
		TextRegion textRegion = new TextRegion(startOffset, length);

		Preferences prefs = new Preferences();
		// First put some defaults
		prefs.put(N4JSFormatterPreferenceKeys.FORMAT_PARENTHESIS, true);
		prefs.put(FormatterPreferenceKeys.lineSeparator, "\n");
		// Second init from concrete tests - will override defaults.
		for (Map.Entry<String, String> entry : prefsMap.entrySet()) {
			prefs.put(entry.getKey(), entry.getValue());
		}

		IFormatter2 formatter = formatterProvider.get();

		FormatterRequest request = formatterRequestProvider.get();
		// request.setTextRegionAccess(reg);
		request.setExceptionHandler(ExceptionAcceptor.THROWING);
		// needed in case a check like this will be implemented:
		// org.eclipse.xtext.testing.formatter.FormatterTester.assertAllWhitespaceIsFormatted()
		request.setAllowIdentityEdits(true);
		request.setFormatUndefinedHiddenRegionsOnly(false);
		request.addRegion(textRegion);
		request.setPreferences(prefs);

		// List<ITextReplacement> replacements = formatter.format(request);
		// String fmt = reg.getRewriter().renderToString(replacements);
		// ITextSegment doc = reg.regionForDocument();
		// int endIndex = textRegion.getEndOffset() + (fmt.length() - doc.getLength()) - 1;
		// String selection = fmt.substring(textRegion.getOffset(), endIndex);
		return null;
	}

	/** Implementation for {@link XtIdeTest#specADoc(XtMethodData)} */
	public String getSpecADoc(IEObjectCoveringRegion ocr) {
		IdentifiableElement element = getIdentifiableElement(ocr);
		SpecIdentifiableElementSection src = new SpecIdentifiableElementSection(element, repoPathHolder);
		String actual = adocFactory.createSpecRegionString(src, Collections.emptyMap()).toString();
		return actual.trim();
	}

	private IdentifiableElement getIdentifiableElement(IEObjectCoveringRegion arg1) {
		EObject eobj = arg1.getEObject();
		if (eobj instanceof ExportDeclaration) {
			eobj = ((ExportDeclaration) eobj).getExportedElement();
		}
		if (eobj instanceof VariableStatement) {
			EList<VariableDeclaration> decls = ((VariableStatement) eobj).getVarDecl();
			if (decls.size() != 1) {
				throw new IllegalStateException("JSDoc for var statements required exactly one declaration.");
			}
			eobj = decls.get(0);
		}
		// For variables using the old type notation and spec comment after export modifier
		if (eobj instanceof TypeRef && eobj.eContainer() instanceof VariableDeclaration) {
			eobj = eobj.eContainer();
		}
		if (eobj instanceof TypeDefiningElement) {
			return ((TypeDefiningElement) eobj).getDefinedType();
		}
		if (eobj instanceof AbstractVariable) {
			return ((AbstractVariable<?>) eobj).getDefinedVariable();
		}
		if (eobj instanceof N4TypeVariable) {
			return ((N4TypeVariable) eobj).getDefinedTypeVariable();
		}
		throw new IllegalStateException("No type defining element found at location.");
	}

}
