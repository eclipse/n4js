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

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.n4js.ide.tests.helper.server.AbstractRenameTest.RenameTestConfiguration;
import org.eclipse.n4js.tests.codegen.Project;
import org.eclipse.n4js.workspace.locations.FileURI;
import org.eclipse.n4js.xtext.ide.server.XDocument;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/**
 * Abstract test class for rename protocol tests.
 */
abstract public class AbstractRenameTest extends AbstractStructuredIdeTest<RenameTestConfiguration> {

	/** Configuration for a rename test. Supports testing same rename scenario at multiple cursor positions. */
	public static class RenameTestConfiguration {
		/** Source code before the rename happens (does not contain any {@link #CURSOR_SYMBOL cursor markers}). */
		final Map<String, Map<String, String>> projectsModulesSourcesBefore;
		/** Cursor positions where rename should be initiated. */
		final List<RenamePosition> positions;
		/** The new name used during rename. */
		final String newName;
		/** Test expectation for the source code after the rename happened. */
		final Map<String, Map<String, String>> projectsModulesExpectedSourcesAfter;
		/** Array of expected issues */
		final Pair<String, List<String>>[] expectedIssues;

		/** Creates a new {@link RenameTestConfiguration}. */
		public RenameTestConfiguration(
				Map<String, Map<String, String>> projectsModulesSourcesBefore,
				List<RenamePosition> positions,
				String newName,
				Map<String, Map<String, String>> projectsModulesExpectedSourcesAfter,
				Pair<String, List<String>>[] expectedIssues) {

			this.projectsModulesSourcesBefore = projectsModulesSourcesBefore;
			this.positions = ImmutableList.copyOf(positions);
			this.newName = newName;
			this.projectsModulesExpectedSourcesAfter = projectsModulesExpectedSourcesAfter;
			this.expectedIssues = expectedIssues;
		}
	}

	/** Position where a rename should be initiated. */
	public static class RenamePosition {
		/** Name of the project containing the module in which the rename should be initiated. */
		final String projectName;
		/** Name of the module in which the rename should be initiated. */
		final String moduleName;
		/** Line of the cursor position where the rename should be initiated. */
		final int line;
		/** Column of the cursor position where the rename should be initiated. */
		final int column;

		/** Creates a new {@link RenamePosition}. */
		public RenamePosition(String projectName, String moduleName, int line, int column) {
			this.projectName = projectName;
			this.moduleName = moduleName;
			this.line = line;
			this.column = column;
		}
	}

	/** Call this method in a single-file test. */
	protected void testAtCursors(CharSequence sourceBefore, String newName, CharSequence expectedSourceAfter) {
		Pair<String, String> sourceBeforeAsPair = Pair.of(
				DEFAULT_MODULE_NAME,
				sourceBefore.toString());
		Pair<String, String> expectedSourceAfterAsPair = Pair.of(
				DEFAULT_MODULE_NAME,
				expectedSourceAfter.toString());
		testAtCursors(
				Collections.singletonList(sourceBeforeAsPair),
				newName,
				Collections.singletonList(expectedSourceAfterAsPair),
				null);
	}

	/** Call this method in a single-project, multi-file test. */
	protected void testAtCursors(
			Iterable<Pair<String, String>> modulesSourcesBefore,
			String newName,
			Iterable<Pair<String, String>> modulesExpectedSourcesAfter) {

		testAtCursors(modulesSourcesBefore, newName, modulesExpectedSourcesAfter, null);
	}

	/** Call this method in a single-project, multi-file test. */
	protected void testAtCursors(
			Map<String, String> modulesSourcesBefore,
			String newName,
			Map<String, String> modulesExpectedSourcesAfter) {

		testAtCursors(modulesSourcesBefore, newName, modulesExpectedSourcesAfter, null);
	}

	/** Call this method in a single-project, multi-file test. */
	protected void testAtCursors(
			Map<String, String> modulesSourcesBefore,
			String newName,
			Map<String, String> modulesExpectedSourcesAfter,
			Pair<String, List<String>>[] expectedIssues) {

		List<Pair<String, String>> modulesSourcesBeforePairList = new ArrayList<>();
		List<Pair<String, String>> modulesExpectedSourcesAfterPairList = new ArrayList<>();

		for (Map.Entry<String, String> e : modulesSourcesBefore.entrySet()) {
			modulesSourcesBeforePairList.add(Pair.of(e.getKey(), e.getValue()));
		}
		for (Map.Entry<String, String> e : modulesExpectedSourcesAfter.entrySet()) {
			modulesExpectedSourcesAfterPairList.add(Pair.of(e.getKey(), e.getValue()));
		}

		testAtCursors(modulesSourcesBeforePairList, newName, modulesExpectedSourcesAfterPairList, expectedIssues);
	}

	/** Call this method in a single-project, multi-file test. */
	protected void testAtCursors(
			Iterable<Pair<String, String>> modulesSourcesBefore,
			String newName,
			Iterable<Pair<String, String>> modulesExpectedSourcesAfter,
			Pair<String, List<String>>[] expectedIssues) {

		Pair<String, ? extends Iterable<Pair<String, String>>> sourceBeforeAsPair = Pair.of(
				DEFAULT_PROJECT_NAME,
				modulesSourcesBefore);
		Pair<String, ? extends Iterable<Pair<String, String>>> expectedSourceAfterAsPair = Pair.of(
				DEFAULT_PROJECT_NAME,
				modulesExpectedSourcesAfter);
		testAtCursorsWS(
				Collections.singletonList(sourceBeforeAsPair),
				newName,
				Collections.singletonList(expectedSourceAfterAsPair),
				expectedIssues);
	}

	/** Call this method in a multi-project test. */
	protected void testAtCursorsWS(
			Iterable<Pair<String, ? extends Iterable<Pair<String, String>>>> projectsModulesSourcesBefore,
			String newName,
			Iterable<Pair<String, ? extends Iterable<Pair<String, String>>>> projectsModulesExpectedSourcesAfter,
			Pair<String, List<String>>[] expectedIssues) {

		Map<String, Map<String, String>> projectsModulesSourcesBeforeAsMap = new LinkedHashMap<>();
		TestWorkspaceManager.convertProjectsModulesContentsToMap(
				projectsModulesSourcesBefore, projectsModulesSourcesBeforeAsMap, false);

		List<RenamePosition> positions = new ArrayList<>();
		for (Pair<String, ? extends Iterable<Pair<String, String>>> modulesSourcesBefore : projectsModulesSourcesBefore) {
			String projectName = modulesSourcesBefore.getKey();
			for (Pair<String, String> moduleName2SourceBefore : modulesSourcesBefore.getValue()) {
				String moduleName = moduleName2SourceBefore.getKey();
				String sourceBefore = moduleName2SourceBefore.getValue();
				if (!sourceBefore.contains(CURSOR_SYMBOL)) {
					continue;
				}
				List<ContentAndPosition> contentAndPositions = getContentAndPositions(sourceBefore.toString());
				String sourceBeforeWithoutCursors = contentAndPositions.get(0).content;
				projectsModulesSourcesBeforeAsMap.get(projectName).put(moduleName, sourceBeforeWithoutCursors);
				positions.addAll(contentAndPositions.stream()
						.map(cap -> new RenamePosition(projectName, moduleName, cap.line, cap.column))
						.collect(Collectors.toList()));
			}
		}
		Assert.assertFalse("no rename positions marked with " + CURSOR_SYMBOL + " in source code", positions.isEmpty());

		Map<String, Map<String, String>> projectsModulesExpectedSourcesAfterAsMap = new LinkedHashMap<>();
		TestWorkspaceManager.convertProjectsModulesContentsToMap(
				projectsModulesExpectedSourcesAfter, projectsModulesExpectedSourcesAfterAsMap, false);

		RenameTestConfiguration config = new RenameTestConfiguration(projectsModulesSourcesBeforeAsMap, positions,
				newName, projectsModulesExpectedSourcesAfterAsMap, expectedIssues);

		String selectedProject = positions.get(0).projectName;
		String selectedModule = positions.get(0).moduleName;
		test(projectsModulesSourcesBeforeAsMap, selectedProject, selectedModule, config);
	}

	@Override
	protected void performTest(Project project, String moduleName, RenameTestConfiguration config)
			throws InterruptedException, ExecutionException, URISyntaxException {

		if (config.expectedIssues == null) {
			assertNoIssues();
		} else {
			assertIssues2(config.expectedIssues);
		}

		for (RenamePosition pos : config.positions) {
			performTestAtPosition(pos, config);
			joinServerRequests();
		}
	}

	private void performTestAtPosition(RenamePosition pos, RenameTestConfiguration config)
			throws InterruptedException, ExecutionException {

		FileURI fileURI = getFileURIFromModuleName(pos.moduleName);
		String uriStr = fileURI.toString();

		String sourceBefore = config.projectsModulesSourcesBefore.get(pos.projectName).get(pos.moduleName);

		WorkspaceEdit workspaceEdit = callRename(uriStr, pos.line, pos.column, config.newName);
		if (workspaceEdit == null) {
			fail("element cannot be renamed", sourceBefore, pos);
			return;
		}

		Set<FileURI> unknownURIs = new LinkedHashSet<>();
		Map<FileURI, String> fileURI2ActualSourceAfter = applyWorkspaceEdit(config.projectsModulesSourcesBefore,
				workspaceEdit, unknownURIs);

		if (!unknownURIs.isEmpty()) {
			fail("rename led to text edits in unknown URIs: " + Joiner.on(", ").join(unknownURIs), null, null);
		}

		Set<FileURI> checkedFileURIs = new LinkedHashSet<>();
		for (Map<String, String> moduleName2ExpectedSourceAfter : config.projectsModulesExpectedSourcesAfter.values()) {
			for (Entry<String, String> entry : moduleName2ExpectedSourceAfter.entrySet()) {
				String moduleName = entry.getKey();
				String expectedSourceAfter = entry.getValue();
				FileURI changedFileURI = getFileURIFromModuleName(moduleName);
				String actualSourceAfter = fileURI2ActualSourceAfter.get(changedFileURI);
				if (actualSourceAfter == null) {
					fail("expected changes in module '" + moduleName
							+ "' but rename did not lead to any changes in this module", sourceBefore, pos);
					return;
				} else if (!actualSourceAfter.equals(expectedSourceAfter)) {
					fail("rename led to incorrect source code changes in module '" + moduleName + "'", sourceBefore,
							pos, expectedSourceAfter, actualSourceAfter);
					return;
				}
				checkedFileURIs.add(changedFileURI);
			}
		}

		for (Entry<FileURI, String> entry : fileURI2ActualSourceAfter.entrySet()) {
			FileURI changedFileURI = entry.getKey();
			String actualSourceAfter = entry.getValue();
			if (!checkedFileURIs.contains(changedFileURI)) {
				fail("rename led to unexpected changes in file '" + changedFileURI.getName() + "'", sourceBefore, pos,
						null, actualSourceAfter);
				return;
			}
		}
	}

	private void fail(String msg, String sourceBefore, RenamePosition pos) {
		fail(msg, sourceBefore, pos, null, null);
	}

	private void fail(String msg, String sourceBefore, RenamePosition pos, String expectedCodeAfter,
			String actualCodeAfter) {
		StringBuilder sb = new StringBuilder();
		sb.append(msg);
		if (sourceBefore != null && pos != null) {
			sb.append('\n');
			sb.append("TEST CASE:");
			sb.append('\n');
			sb.append(insertCursorSymbol(sourceBefore, pos).trim());
		}
		if (expectedCodeAfter != null) {
			sb.append('\n');
			sb.append("EXPECTED SOURCE AFTER RENAME:");
			sb.append('\n');
			sb.append(expectedCodeAfter.trim());
		}
		if (actualCodeAfter != null) {
			sb.append('\n');
			sb.append("ACTUAL SOURCE AFTER RENAME:");
			sb.append('\n');
			sb.append(actualCodeAfter.trim());
		}
		if (Objects.equal(expectedCodeAfter, actualCodeAfter)) {
			Assert.fail(sb.toString());
		} else {
			Assert.assertEquals(sb.toString(), expectedCodeAfter, actualCodeAfter);
		}
	}

	private String insertCursorSymbol(String source, RenamePosition pos) {
		int offset = new XDocument(0, source).getOffSet(new Position(pos.line, pos.column));
		return source.substring(0, offset) + CURSOR_SYMBOL + source.substring(offset);
	}
}
