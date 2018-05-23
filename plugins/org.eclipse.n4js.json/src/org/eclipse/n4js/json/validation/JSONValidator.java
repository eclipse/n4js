/**
 * Copyright (c) 2017 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.json.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.n4js.json.JSON.JSONDocument;
import org.eclipse.n4js.json.JSON.JSONObject;
import org.eclipse.n4js.json.JSON.JSONPackage;
import org.eclipse.n4js.json.JSON.JSONValue;
import org.eclipse.n4js.json.JSON.NameValuePair;
import org.eclipse.n4js.json.services.JSONGrammarAccess;
import org.eclipse.n4js.json.validation.validators.PackageJsonValidator;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;

import com.google.inject.Inject;

/**
 * This class contains general validation with regard to JSON files. 
 */
@ComposedChecks(validators = {
	PackageJsonValidator.class
})
public class JSONValidator extends AbstractResourceDependentJSONValidator {
	
	@Inject
	JSONGrammarAccess grammarAccess;

	JSONValidator() {
		super();
	}
	
	/**
	 * Checks for duplicate keys in {@link JSONObject}s.
	 */
	@Check
	public void checkDuplicateKeys(JSONObject object) {
		final Map<String, JSONValue> values = new HashMap<>();
		
		for (NameValuePair pair : object.getNameValuePairs()) {
			final JSONValue value = values.get(pair.getName());
			if (value != null) {
				final INode duplicatedNode = NodeModelUtils.findActualNodeFor(value);
				final int duplicatedLine = NodeModelUtils.getLineAndColumn(duplicatedNode, duplicatedNode.getOffset()).getLine();
				addIssue(JSONIssueCodes.getMessageForJSON_DUPLICATE_KEY(pair.getName(), duplicatedLine), pair, 
						JSONPackage.Literals.NAME_VALUE_PAIR__NAME, JSONIssueCodes.JSON_DUPLICATE_KEY);
			}
			values.put(pair.getName(), pair.getValue());
		}
	}
	

	/** 
	 * Checks the document for comments (single or multi-line) which are not valid JSON constructs
	 * but accepted by our parser. */
	@Check
	public void checkDocumentForComments(JSONDocument document) {
		ICompositeNode documentNode = NodeModelUtils.findActualNodeFor(document);
		ICompositeNode rootNode = documentNode.getRootNode();
		
		StreamSupport.stream(rootNode.getAsTreeIterable().spliterator(), false)
			.filter(n -> n instanceof HiddenLeafNode)
			.filter(n -> isCommentNode(n))
			.forEach(n -> {
				addIssue(JSONIssueCodes.getMessageForJSON_COMMENT_UNSUPPORTED(), document, n.getOffset(), 
						n.getLength(), JSONIssueCodes.JSON_COMMENT_UNSUPPORTED);
			});
	}
	
	private boolean isCommentNode(INode node) {
		EObject grammarElement = node.getGrammarElement();
		if (grammarElement instanceof TerminalRule) {
			return ((TerminalRule) grammarElement).getName().equals(grammarAccess.getSL_COMMENTRule().getName())
					|| ((TerminalRule) grammarElement).getName().equals(grammarAccess.getML_COMMENTRule().getName());
		}
		return false;
	}
}
