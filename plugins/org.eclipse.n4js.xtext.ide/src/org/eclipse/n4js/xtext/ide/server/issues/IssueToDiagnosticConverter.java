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
package org.eclipse.n4js.xtext.ide.server.issues;

import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.IssueImpl;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

/**
 * Converter for Xtext {@link Issue}s and LSP {@link Diagnostic}s
 */
public class IssueToDiagnosticConverter {

	/** Convert the given issue to a diagnostic. */
	public Diagnostic toDiagnostic(Issue issue) {
		Diagnostic result = new Diagnostic();

		result.setCode(issue.getCode());
		result.setMessage(Strings.nullToEmpty(issue.getMessage()));
		result.setSeverity(toSeverity(issue.getSeverity()));

		Position start = new Position(issue.getLineNumber() - 1, issue.getColumn() - 1);
		Position end = new Position(issue.getLineNumberEnd() - 1, issue.getColumnEnd() - 1);

		result.setRange(new Range(start, end));
		return result;
	}

	/**
	 * Convert the {@link Severity} to a lsp {@link DiagnosticSeverity}.
	 *
	 * Defaults to severity {@link DiagnosticSeverity#Hint}.
	 */
	protected DiagnosticSeverity toSeverity(Severity severity) {
		switch (severity) {
		case ERROR:
			return DiagnosticSeverity.Error;
		case IGNORE:
			return DiagnosticSeverity.Hint;
		case INFO:
			return DiagnosticSeverity.Information;
		case WARNING:
			return DiagnosticSeverity.Warning;
		default:
			return DiagnosticSeverity.Hint;
		}
	}

	/**
	 * Convert the lsp {@link DiagnosticSeverity} to an Xtext {@link Severity}.
	 *
	 * Defaults to severity {@link Severity#IGNORE}.
	 */
	protected Severity toSeverity(DiagnosticSeverity severity) {
		switch (severity) {
		case Error:
			return Severity.ERROR;
		case Hint:
			return Severity.IGNORE;
		case Information:
			return Severity.INFO;
		case Warning:
			return Severity.WARNING;
		default:
			return Severity.IGNORE;
		}
	}

	/** Convert the given diagnostic to an issue. */
	public Issue toIssue(URI uri, Diagnostic diagnostic, Optional<Document> document) {
		IssueImpl issue = new IssueImpl();

		issue.setSeverity(toSeverity(diagnostic.getSeverity()));

		Range range = diagnostic.getRange();
		Position sPos = range.getStart();
		Position ePos = range.getEnd();
		int offSetStart = 0;
		int offSetEnd = 0;
		if (document.isPresent()) {
			offSetStart = document.get().getOffSet(new Position(sPos.getLine() + 1, sPos.getCharacter() + 1));
			offSetEnd = document.get().getOffSet(new Position(ePos.getLine() + 1, ePos.getCharacter() + 1));
		}

		issue.setLineNumber(sPos.getLine() + 1);
		issue.setColumn(sPos.getCharacter() + 1);
		issue.setLineNumberEnd(ePos.getLine() + 1);
		issue.setColumnEnd(ePos.getCharacter() + 1);
		issue.setOffset(offSetStart);
		issue.setLength(offSetEnd - offSetStart);

		issue.setUriToProblem(uri);
		issue.setCode(diagnostic.getCode().getLeft());
		issue.setType(CheckType.FAST);
		issue.setMessage(diagnostic.getMessage());

		return issue;
	}

}
