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
package org.eclipse.n4js.ide.tests.helper.server;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.HoverParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.n4js.tests.codegen.Project;
import org.eclipse.xtext.testing.HoverTestConfiguration;

/**
 * Abstract test class for hover protocol tests
 */
abstract public class AbstractHoverTest extends AbstractStructuredIdeTest<HoverTestConfiguration> {

	/** Call this method in a test */
	protected void testAtCursor(String content, String expectation) throws Exception {
		ContentAndPosition contentAndPosition = getContentAndPosition(content);
		HoverTestConfiguration htc = new HoverTestConfiguration();
		htc.setModel(contentAndPosition.content);
		htc.setLine(contentAndPosition.line);
		htc.setColumn(contentAndPosition.column);
		htc.setExpectedHover(expectation);

		test(htc.getFilePath(), htc.getModel(), htc);
	}

	@Override
	protected void performTest(Project project, String moduleName, HoverTestConfiguration htc)
			throws InterruptedException, ExecutionException {

		HoverParams hoverParams = new HoverParams();
		String completeFileUri = getFileURIFromModuleName(htc.getFilePath()).toString();
		hoverParams.setTextDocument(new TextDocumentIdentifier(completeFileUri));
		hoverParams.setPosition(new Position(htc.getLine(), htc.getColumn()));
		CompletableFuture<Hover> hoverFuture = languageServer.hover(hoverParams);

		Hover hover = hoverFuture.get();
		if (htc.getAssertHover() != null) {
			htc.getAssertHover().apply(hover);
		} else {
			String actualSignatureHelp = getStringLSP4J().toString(hover);
			assertEquals(htc.getExpectedHover().trim(), actualSignatureHelp.trim());
		}
	}

}
