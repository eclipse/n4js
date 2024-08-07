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

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SignatureHelpParams;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.n4js.tests.codegen.Project;
import org.eclipse.xtext.testing.SignatureHelpConfiguration;

/**
 * Abstract test class for signature protocol tests
 */
abstract public class AbstractSignatureHelpTest extends AbstractStructuredIdeTest<SignatureHelpConfiguration> {

	/** Call this method in a test */
	protected void test(SignatureHelpConfiguration shc) throws Exception {
		test(shc.getFilePath(), shc.getModel(), shc);
	}

	@Override
	protected void performTest(Project project, String moduleName, SignatureHelpConfiguration shc)
			throws InterruptedException, ExecutionException {

		SignatureHelpParams signatureHelpParams = new SignatureHelpParams();
		String completeFileUri = getFileURIFromModuleName(shc.getFilePath()).toString();
		signatureHelpParams.setTextDocument(new TextDocumentIdentifier(completeFileUri));
		signatureHelpParams.setPosition(new Position(shc.getLine(), shc.getColumn()));
		CompletableFuture<SignatureHelp> signatureHelpFuture = languageServer.signatureHelp(signatureHelpParams);

		SignatureHelp signatureHelp = signatureHelpFuture.get();
		if (shc.getAssertSignatureHelp() != null) {
			shc.getAssertSignatureHelp().apply(signatureHelp);
		} else {
			String actualSignatureHelp = getStringLSP4J().toString(signatureHelp);
			assertEquals(shc.getExpectedSignatureHelp().trim(), actualSignatureHelp.trim());
		}
	}

}
