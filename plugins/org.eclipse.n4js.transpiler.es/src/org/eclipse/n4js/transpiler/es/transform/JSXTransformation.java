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
package org.eclipse.n4js.transpiler.es.transform;

import static org.eclipse.n4js.tooling.react.ReactHelper.REACT_ELEMENT_PROPERTY_CHILDREN_NAME;
import static org.eclipse.n4js.tooling.react.ReactHelper.REACT_ELEMENT_PROPERTY_KEY_NAME;
import static org.eclipse.n4js.tooling.react.ReactHelper.REACT_JSXS_TRANSFORM_NAME;
import static org.eclipse.n4js.tooling.react.ReactHelper.REACT_JSX_RUNTIME_NAME;
import static org.eclipse.n4js.tooling.react.ReactHelper.REACT_JSX_TRANSFORM_NAME;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._ArrLit;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._CallExpr;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._NamedImportSpecifier;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._ObjLit;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._PropertyAccessExpr;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._PropertyNameValuePair;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._PropertySpread;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._StringLiteral;
import static org.eclipse.n4js.transpiler.TranspilerBuilderBlocks._TRUE;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.filter;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.map;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.n4js.n4JS.ImportDeclaration;
import org.eclipse.n4js.n4JS.JSXAbstractElement;
import org.eclipse.n4js.n4JS.JSXAttribute;
import org.eclipse.n4js.n4JS.JSXChild;
import org.eclipse.n4js.n4JS.JSXElement;
import org.eclipse.n4js.n4JS.JSXExpression;
import org.eclipse.n4js.n4JS.JSXFragment;
import org.eclipse.n4js.n4JS.JSXPropertyAttribute;
import org.eclipse.n4js.n4JS.JSXSpreadAttribute;
import org.eclipse.n4js.n4JS.NamedImportSpecifier;
import org.eclipse.n4js.n4JS.NamespaceImportSpecifier;
import org.eclipse.n4js.n4JS.ParameterizedCallExpression;
import org.eclipse.n4js.n4JS.PropertyAssignment;
import org.eclipse.n4js.tooling.react.ReactHelper;
import org.eclipse.n4js.transpiler.Transformation;
import org.eclipse.n4js.transpiler.im.IdentifierRef_IM;
import org.eclipse.n4js.transpiler.im.ImFactory;
import org.eclipse.n4js.transpiler.im.Script_IM;
import org.eclipse.n4js.transpiler.im.SymbolTableEntry;
import org.eclipse.n4js.transpiler.im.SymbolTableEntryInternal;
import org.eclipse.n4js.transpiler.im.SymbolTableEntryOriginal;
import org.eclipse.n4js.ts.types.IdentifiableElement;
import org.eclipse.n4js.ts.types.TModule;
import org.eclipse.n4js.utils.ResourceType;
import org.eclipse.xtext.EcoreUtil2;

import com.google.inject.Inject;

/**
 * Transforms JSX tags to output code according to JSX/React conventions.
 * <p>
 * For example:
 *
 * <pre>
 * &lt;div attr="value">&lt;/div>
 * </pre>
 *
 * will be transformed to
 *
 * <pre>
 * $jsv('div', {attr: "value"});
 * </pre>
 */
public class JSXTransformation extends Transformation {
	static final Map<String, String> ALIAS_MAP = Map.of(
			REACT_JSX_TRANSFORM_NAME, "$" + REACT_JSX_TRANSFORM_NAME,
			REACT_JSXS_TRANSFORM_NAME, "$" + REACT_JSXS_TRANSFORM_NAME);

	private final Set<String> necessaryImports = new LinkedHashSet<>();
	private SymbolTableEntryOriginal steForJsxBackendNamespace;
	private SymbolTableEntryOriginal steForJsxBackendFragmentComponent;

	@Inject
	private ReactHelper reactHelper;

	@Override
	public void assertPreConditions() {
		// empty
	}

	@Override
	public void assertPostConditions() {
		// empty
	}

	@Override
	public void analyze() {
		// ignore
	}

	/**
	 * IMPORTANT: our strategy for handling nested JSXElements is as follows: 1) direct child JSXElements will be
	 * handled together with their parent JSXElement 2) indirect children that are contained in nested expressions will
	 * be handled via a separate invocation to method #transformJSXElement(JSXElement)
	 *
	 * Example for case 1:
	 *
	 * <pre>
	 * let elem1 = &lt;div>&lt;a>&lt;/a>&lt;/div>; // &lt;a> is a direct child
	 * </pre>
	 *
	 * Example for case 2:
	 *
	 * <pre>
	 * let elem2 = &lt;div>{function() {return &lt;a>&lt;/a>;}}&lt;/div>; // &lt;a> is the child of a nested expression!
	 * </pre>
	 *
	 * More examples for case 2:
	 *
	 * <pre>
	 * let elem3 = &lt;div>{&lt;a>&lt;/a>}&lt;/div>;
	 * let elem4 = &lt;div prop={&lt;a>&lt;/a>}>&lt;/div>;
	 * </pre>
	 */
	@Override
	public void transform() {
		ResourceType resourceType = ResourceType.getResourceType(getState().resource);
		boolean inJSX = resourceType == ResourceType.JSX || resourceType == ResourceType.N4JSX;
		if (!inJSX) {
			return; // this transformation is not applicable
		}

		// note: we are passing 'true' to #collectNodes(), i.e. we are searching for nested elements
		List<JSXAbstractElement> jsxAbstractElements = collectNodes(getState().im, JSXAbstractElement.class, true);
		if (jsxAbstractElements.isEmpty()) {
			// Nothing to transform
			return;
		}

		steForJsxBackendNamespace = createImportOfJsxBackend(); // will be removed if obsolete
		steForJsxBackendFragmentComponent = prepareFragmentComponent();

		// Transform JSXFragments and JSXElements
		for (JSXAbstractElement jsxElem : jsxAbstractElements) {
			transformJSXAbstractElement(jsxElem);
		}
		createNecessaryImportsOfJsx();
	}

	private void createNecessaryImportsOfJsx() {
		List<String> importSpecifierNames = new ArrayList<>(necessaryImports);
		NamedImportSpecifier[] importSpecs = new NamedImportSpecifier[importSpecifierNames.size()];
		for (int i = 0; i < importSpecifierNames.size(); i++) {
			String isn = importSpecifierNames.get(i);
			String alias = ALIAS_MAP.get(isn);
			importSpecs[i] = _NamedImportSpecifier(isn, alias, true);
		}
		addNamedImport(REACT_JSX_RUNTIME_NAME, importSpecs);
	}

	private SymbolTableEntryOriginal createImportOfJsxBackend() {
		TModule jsxBackendModule = reactHelper.getJsxBackendModule(getState().resource);
		if (jsxBackendModule == null) {
			throw new RuntimeException("cannot locate JSX backend for N4JSX resource " + getState().resource.getURI());
		}
		NamespaceImportSpecifier existingNamespaceImportOfReactIM = null;
		for (ImportDeclaration id : filter(getState().im.getScriptElements(), ImportDeclaration.class)) {
			if (getState().info.getImportedModule(id) == jsxBackendModule) {
				List<NamespaceImportSpecifier> niss = toList(
						filter(id.getImportSpecifiers(), NamespaceImportSpecifier.class));
				if (!niss.isEmpty()) {
					existingNamespaceImportOfReactIM = niss.get(0);
					break;
				}
			}
		}

		if (existingNamespaceImportOfReactIM != null) {
			// we already have a namespace import of the JSX backend, no need to create a new one:
			existingNamespaceImportOfReactIM.setFlaggedUsedInCode(true);
			return findSymbolTableEntryForNamespaceImport(existingNamespaceImportOfReactIM);
		}
		// create namespace import for the JSX backend
		// (note: we do not have to care for name clashes regarding name of the namespace, because validations ensure
		// that "React" is never used as a name in N4JSX files, except as the namespace name of a react import)
		return addNamespaceImport(jsxBackendModule, reactHelper.getJsxBackendNamespaceName());
	}

	private SymbolTableEntryOriginal prepareFragmentComponent() {
		IdentifiableElement fragmentComponent = reactHelper.getJsxBackendFragmentComponent(getState().resource);
		if (fragmentComponent == null) {
			throw new RuntimeException("cannot locate fragment component of JSX backend for N4JSX resource "
					+ getState().resource.getURI());
		}
		return getSymbolTableEntryOriginal(fragmentComponent, true);
	}

	private void transformJSXAbstractElement(JSXAbstractElement elem) {
		// IMPORTANT: 'elem' might be a direct or indirect child, but if it is a direct child, it was already
		// transformed when this method was invoked with its ancestor JSXElement as argument
		if (EcoreUtil2.getContainerOfType(elem, Script_IM.class) == null) {
			// 'elem' was already processed -> simply ignore it
			return;
		}
		replace(elem, convertJSXAbstractElement(elem));
	}

	private ParameterizedCallExpression convertJSXAbstractElement(JSXAbstractElement elem) {
		List<Expression> args = new ArrayList<>();
		if (elem instanceof JSXElement) {
			JSXElement jsxElem = (JSXElement) elem;
			args.add(getTagNameFromElement(jsxElem));
			args.add(convertJSXAttributes(jsxElem.getJsxAttributes(), elem.getJsxChildren()));
			Expression keysValue = findKeysAttribute(jsxElem.getJsxAttributes());
			if (keysValue != null) {
				args.add(keysValue);
			}
		} else if (elem instanceof JSXFragment) {
			args.add(_PropertyAccessExpr(steForJsxBackendNamespace, steForJsxBackendFragmentComponent));
			args.add(convertJSXAttributes(Collections.emptyList(), elem.getJsxChildren()));
		}

		IdentifierRef_IM idRef = ImFactory.eINSTANCE.createIdentifierRef_IM();
		String isn = elem.getJsxChildren().size() > 1 ? REACT_JSXS_TRANSFORM_NAME : REACT_JSX_TRANSFORM_NAME;
		necessaryImports.add(isn);
		String jsxAlias = ALIAS_MAP.get(isn);
		idRef.setIdAsText(jsxAlias);
		SymbolTableEntryInternal ste = getSymbolTableEntryInternal(idRef.getIdAsText(), true);
		idRef.setId_IM(ste);
		return _CallExpr(idRef, args.toArray(new Expression[0]));
	}

	private Expression findKeysAttribute(EList<JSXAttribute> jsxAttributes) {
		for (JSXAttribute attr : jsxAttributes) {
			if (attr instanceof JSXPropertyAttribute) {
				JSXPropertyAttribute pa = (JSXPropertyAttribute) attr;
				// https://github.com/reactjs/rfcs/blob/createlement-rfc/text/0000-create-element-changes.md#motivation
				// notes that the key property will not be extracted from attributes
				// at some time in the future
				if (REACT_ELEMENT_PROPERTY_KEY_NAME.equals(pa.getPropertyAsText())) {
					return pa.getJsxAttributeValue();
				}
			}
		}
		return null;
	}

	// Generate {foo:foo, ...spread, bar: "Hi", children: []}
	private Expression convertJSXAttributes(List<JSXAttribute> attrs, List<JSXChild> children) {
		if (children.isEmpty() && attrs.isEmpty()) {
			return _ObjLit();
		}
		if (children.isEmpty() && attrs.size() == 1 && attrs.get(0) instanceof JSXSpreadAttribute) {
			// Special case: if only a single spread operator is passed, we pass it directly, e.g. spr instead of
			// cloning.
			// return ((JSXSpreadAttribute) attrs.get(0)).getExpression();
		}

		List<PropertyAssignment> pas = new ArrayList<>();

		for (JSXAttribute attr : attrs) {
			if (attr instanceof JSXSpreadAttribute) {
				JSXSpreadAttribute sAttr = (JSXSpreadAttribute) attr;
				pas.add(_PropertySpread(sAttr.getExpression()));
			} else if (attr instanceof JSXPropertyAttribute) {
				JSXPropertyAttribute pAttr = (JSXPropertyAttribute) attr;
				if (!children.isEmpty() && REACT_ELEMENT_PROPERTY_CHILDREN_NAME.equals(pAttr.getPropertyAsText())) {
					continue;
				}
				if (REACT_ELEMENT_PROPERTY_KEY_NAME.equals(pAttr.getPropertyAsText())) {
					continue;
				}
				pas.add(_PropertyNameValuePair(
						getNameFromPropertyAttribute(pAttr),
						getValueExpressionFromPropertyAttribute(pAttr)));
			}
		}

		if (!children.isEmpty()) {
			Expression childrenValue;
			if (children.size() == 1) {
				childrenValue = convertJSXChild(children.get(0));
			} else {
				childrenValue = _ArrLit(
						toList(map(children, child -> convertJSXChild(child))).toArray(new Expression[0]));
			}
			// this will cause any other custom property children to be overwritten
			pas.add(_PropertyNameValuePair(REACT_ELEMENT_PROPERTY_CHILDREN_NAME, childrenValue));
		}

		return _ObjLit(pas.toArray(new PropertyAssignment[0]));
	}

	private Expression convertJSXChild(JSXChild child) {
		if (child instanceof JSXElement) {
			return convertJSXAbstractElement((JSXElement) child);
		}
		if (child instanceof JSXFragment) {
			return convertJSXAbstractElement((JSXFragment) child);
		}
		if (child instanceof JSXExpression) {
			return ((JSXExpression) child).getExpression();
		}
		return null;
	}

	private Expression getTagNameFromElement(JSXElement elem) {
		Expression nameExpr = elem.getJsxElementName().getExpression();
		if (nameExpr instanceof IdentifierRef_IM) {
			IdentifierRef_IM idRef = (IdentifierRef_IM) nameExpr;
			SymbolTableEntry id = idRef.getId_IM();
			if (id == null) {
				return _StringLiteral(idRef.getIdAsText());
			}
		}
		return nameExpr;
	}

	private String getNameFromPropertyAttribute(JSXPropertyAttribute attr) {
		IdentifiableElement prop = attr.getProperty();
		if (prop != null && !prop.eIsProxy()) {
			return prop.getName();
		}
		return attr.getPropertyAsText();
	}

	private Expression getValueExpressionFromPropertyAttribute(JSXPropertyAttribute attr) {
		return attr.getJsxAttributeValue() != null ? attr.getJsxAttributeValue() : _TRUE();
	}
}
