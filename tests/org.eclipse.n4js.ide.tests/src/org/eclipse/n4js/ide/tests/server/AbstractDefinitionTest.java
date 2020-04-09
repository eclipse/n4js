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
package org.eclipse.n4js.ide.tests.server;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.n4js.tests.codegen.Project;
import org.eclipse.xtext.testing.DefinitionTestConfiguration;

/**
 * Abstract test class for defintion protocol tests
 */
abstract public class AbstractDefinitionTest extends AbstractStructuredIdeTest<DefinitionTestConfiguration> {

	/** Call this method in a test */
	protected void testAtCursor(String content, String expectation) throws Exception {
		ContentAndPosition contentAndPosition = getContentAndPosition(content);

		DefinitionTestConfiguration config = new DefinitionTestConfiguration();
		config.setModel(contentAndPosition.content);
		config.setLine(contentAndPosition.line);
		config.setColumn(contentAndPosition.column);
		config.setExpectedDefinitions(expectation);

		test(config.getFilePath(), config.getModel(), config);
	}

	@Override
	protected void performTest(Project project, String moduleName, DefinitionTestConfiguration dtc)
			throws InterruptedException, ExecutionException, URISyntaxException {

		TextDocumentPositionParams textDocumentPositionParams = new TextDocumentPositionParams();
		String completeFileUri = getFileURIFromModuleName(dtc.getFilePath()).toString();
		textDocumentPositionParams.setTextDocument(new TextDocumentIdentifier(completeFileUri));
		textDocumentPositionParams.setPosition(new Position(dtc.getLine(), dtc.getColumn()));
		CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definitionsFuture = languageServer
				.definition(textDocumentPositionParams);

		Either<List<? extends Location>, List<? extends LocationLink>> definitions = definitionsFuture.get();
		if (dtc.getAssertDefinitions() != null) {
			dtc.getAssertDefinitions().apply(definitions.getLeft());
		} else {
			String actualSignatureHelp = getStringLSP4J().toString4(definitions);
			assertEquals(dtc.getExpectedDefinitions().trim(), actualSignatureHelp.trim());
		}
	}

}