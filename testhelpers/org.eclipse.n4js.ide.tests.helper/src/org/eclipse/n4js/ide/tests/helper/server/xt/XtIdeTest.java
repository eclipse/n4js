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

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.n4js.ide.tests.helper.server.AbstractIdeTest;
import org.eclipse.n4js.ide.tests.helper.server.AbstractStructuredIdeTest;
import org.eclipse.n4js.ide.tests.helper.server.xt.XtFileData.MethodData;
import org.eclipse.n4js.projectModel.locations.FileURI;
import org.eclipse.n4js.resource.N4JSResource;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

/**
 *
 */
public class XtIdeTest extends AbstractIdeTest {
	static final String CURSOR = AbstractStructuredIdeTest.CURSOR_SYMBOL;

	@Inject
	private XtMethodHelper mh;

	XtFileData xtData;
	XtIssueHelper issueHelper;
	XtextResource resource;

	/**
	 */
	public void initializeXtFile(XtFileData newXtData) throws IOException {
		Preconditions.checkNotNull(newXtData);
		xtData = newXtData;

		cleanupTestDataFolder();
		testWorkspaceManager.createTestOnDisk(xtData.workspace);

		for (MethodData startupMethod : xtData.startupMethodData) {
			switch (startupMethod.name) {
			case "startAndWaitForLspServer":
				startAndWaitForLspServer();
				break;
			default:
				throw new IllegalArgumentException("Unknown method: " + startupMethod.name);
			}
		}
		FileURI xtModule = getFileURIFromModuleName(xtData.workspace.moduleNameOfXtFile);

		languageServer.getResourceTaskManager().runInTemporaryContext(xtModule.toURI(), "test", false,
				(context, ci) -> {
					resource = context.getResource();
					Preconditions.checkNotNull(resource);
					if (resource instanceof N4JSResource) {
						N4JSResource n4Res = ((N4JSResource) resource);
						n4Res.resolveLazyCrossReferences(ci);
					}
					return null;
				}).join();

		ArrayList<MethodData> issueTests = new ArrayList<>();
		LOOP: for (MethodData testMethod : xtData.getTestMethodData()) {
			switch (testMethod.name) {
			case "nowarnings":
			case "noerrors":
			case "warnings":
			case "errors":
				issueTests.add(testMethod);
				break;
			default:
				// test method data is sorted: issue related tests methods come first
				break LOOP;
			}
		}

		this.issueHelper = new XtIssueHelper(xtData, getIssuesInFile(xtModule), issueTests);
	}

	/**
	 */
	public void invokeTestMethod(MethodData testMethodData) throws InterruptedException, ExecutionException {
		switch (testMethodData.name) {
		case "definition":
			definition(testMethodData);
			break;
		case "type":
			type(testMethodData);
			break;
		case "nowarnings": {
			nowarnings(testMethodData);
			break;
		}
		case "noerrors": {
			noerrors(testMethodData);
			break;
		}
		case "warnings": {
			warnings(testMethodData);
			break;
		}
		case "errors": {
			errors(testMethodData);
			break;
		}
		default:
			throw new IllegalArgumentException("Unknown method: " + testMethodData.name);
		}
	}

	/** 	 */
	public void teardown() throws IOException {
		deleteTestProject();
	}

	/**
	 * Validates that there are no errors at the given location.
	 *
	 * <pre>
	 * // Xpect noerrors --&gt;
	 * </pre>
	 */
	@Xpect // NOTE: This annotation is used only to enable validation and navigation of .xt files.
	public void noerrors(MethodData data) {
		issueHelper.noerrors(data);
	}

	/**
	 * Validates that there are no warnings at the given location.
	 *
	 * <pre>
	 * // Xpect nowarnings --&gt;
	 * </pre>
	 */
	@Xpect // NOTE: This annotation is used only to enable validation and navigation of .xt files.
	public void nowarnings(MethodData data) {
		issueHelper.nowarnings(data);
	}

	/**
	 * Compares expected errors at a given location to actual errors at that location. Multiple errors are separated by
	 * space.
	 *
	 * <pre>
	 * // Xpect errors --&gt; "&ltMESSAGE&gt" at "&ltLOCATION&gt"
	 * </pre>
	 */
	@Xpect // NOTE: This annotation is used only to enable validation and navigation of .xt files.
	public void errors(MethodData data) {
		issueHelper.errors(data);
	}

	/**
	 * Compares expected warnings at a given location to actual warnings at that location. Multiple warnings are
	 * separated by space.
	 *
	 * <pre>
	 * // Xpect warnings --&gt; "&ltMESSAGE&gt" at "&ltLOCATION&gt"
	 * </pre>
	 */
	@Xpect // NOTE: This annotation is used only to enable validation and navigation of .xt files.
	public void warnings(MethodData data) {
		issueHelper.warnings(data);
	}

	/**
	 * Calls LSP endpoint 'definition'.
	 *
	 * <pre>
	 * // Xpect definition --&gt; file and range
	 * </pre>
	 */
	@Xpect // NOTE: This annotation is used only to enable validation and navigation of .xt files.
	public void definition(MethodData data) throws InterruptedException, ExecutionException {
		Position position = getPosition(data, "definition", "at");
		FileURI uri = getFileURIFromModuleName(xtData.workspace.moduleNameOfXtFile);

		CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> future = callDefinition(
				uri.toString(), position.getLine(), position.getCharacter());

		Either<List<? extends Location>, List<? extends LocationLink>> definitions = future.get();

		String actualSignatureHelp = getStringLSP4J().toString4(definitions);
		assertEquals(data.expectation, actualSignatureHelp.trim());
	}

	/**
	 * Checks that an element/expression has a certain type. Usage:
	 *
	 * <pre>
	 * // Xpect type of 'location' --&gt; Type
	 * </pre>
	 *
	 * The location (of) is optional.
	 *
	 * The location is identified by the offset. Note that there are different implementations of IEObjectOwner, and we
	 * need IEStructuralFeatureAndEObject, while ICrossEReferenceAndEObject or IEAttributeAndEObject would not work in
	 * all cases (as not all eobjects we test have cross references or attributes, but feature is the join of both).
	 */
	@Xpect // NOTE: This annotation is used only to enable validation and navigation of .xt files.
	public void type(MethodData data) {
		int offset = getOffset(data, "type", "of");
		EObject eObject = XtMethodHelper.getEObject(resource, offset, 0);
		String typeStr = mh.getTypeString(eObject, false);
		assertEquals(data.expectation, typeStr);
	}

	private Position getPosition(MethodData data, String checkArg1, String optionalDelimiter) {
		int offset = getOffset(data, checkArg1, optionalDelimiter);
		Position position = xtData.getPosition(offset);
		return position;
	}

	private int getOffset(MethodData data, String checkArg1, String optionalLocation) {
		Preconditions.checkArgument(data.name.equals(checkArg1));
		int offset;
		if (data.args.length > 1) {
			Preconditions.checkArgument(data.args[0].equals(optionalLocation));
			Preconditions.checkArgument(data.args[1].startsWith("'"));
			Preconditions.checkArgument(data.args[1].endsWith("'"));
			String locationStr = data.args[1].substring(1, data.args[1].length() - 2);
			int relLocationIdx = locationStr.contains(CURSOR) ? locationStr.indexOf(CURSOR) : 0;
			locationStr = locationStr.replace(CURSOR, "");
			offset = xtData.content.indexOf(locationStr, data.offset) + relLocationIdx;
		} else {
			offset = data.offset;
		}
		return offset;
	}

}
