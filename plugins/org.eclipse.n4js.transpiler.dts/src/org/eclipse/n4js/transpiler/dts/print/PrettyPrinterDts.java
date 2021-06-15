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
package org.eclipse.n4js.transpiler.dts.print;

import static org.eclipse.n4js.transpiler.utils.TranspilerUtils.isLegalIdentifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.n4js.n4JS.Annotation;
import org.eclipse.n4js.n4JS.Block;
import org.eclipse.n4js.n4JS.DefaultImportSpecifier;
import org.eclipse.n4js.n4JS.ExportDeclaration;
import org.eclipse.n4js.n4JS.ExportSpecifier;
import org.eclipse.n4js.n4JS.ExportableElement;
import org.eclipse.n4js.n4JS.ExportedVariableBinding;
import org.eclipse.n4js.n4JS.ExportedVariableDeclaration;
import org.eclipse.n4js.n4JS.ExportedVariableStatement;
import org.eclipse.n4js.n4JS.Expression;
import org.eclipse.n4js.n4JS.FormalParameter;
import org.eclipse.n4js.n4JS.FunctionDeclaration;
import org.eclipse.n4js.n4JS.FunctionDefinition;
import org.eclipse.n4js.n4JS.ImportDeclaration;
import org.eclipse.n4js.n4JS.ImportSpecifier;
import org.eclipse.n4js.n4JS.LiteralOrComputedPropertyName;
import org.eclipse.n4js.n4JS.LocalArgumentsVariable;
import org.eclipse.n4js.n4JS.N4ClassDeclaration;
import org.eclipse.n4js.n4JS.N4EnumDeclaration;
import org.eclipse.n4js.n4JS.N4EnumLiteral;
import org.eclipse.n4js.n4JS.N4FieldDeclaration;
import org.eclipse.n4js.n4JS.N4GetterDeclaration;
import org.eclipse.n4js.n4JS.N4InterfaceDeclaration;
import org.eclipse.n4js.n4JS.N4MemberDeclaration;
import org.eclipse.n4js.n4JS.N4MethodDeclaration;
import org.eclipse.n4js.n4JS.N4Modifier;
import org.eclipse.n4js.n4JS.N4SetterDeclaration;
import org.eclipse.n4js.n4JS.N4TypeAliasDeclaration;
import org.eclipse.n4js.n4JS.N4TypeVariable;
import org.eclipse.n4js.n4JS.NamedImportSpecifier;
import org.eclipse.n4js.n4JS.NamespaceImportSpecifier;
import org.eclipse.n4js.n4JS.PropertyNameKind;
import org.eclipse.n4js.n4JS.PropertyNameOwner;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.n4JS.Statement;
import org.eclipse.n4js.n4JS.TypeProvidingElement;
import org.eclipse.n4js.n4JS.TypeReferenceNode;
import org.eclipse.n4js.n4JS.VariableBinding;
import org.eclipse.n4js.n4JS.VariableDeclaration;
import org.eclipse.n4js.n4JS.VariableStatement;
import org.eclipse.n4js.n4JS.VariableStatementKeyword;
import org.eclipse.n4js.n4JS.util.N4JSSwitch;
import org.eclipse.n4js.parser.conversion.ValueConverterUtils;
import org.eclipse.n4js.tooling.N4JSDocumentationProvider;
import org.eclipse.n4js.transpiler.TranspilerState;
import org.eclipse.n4js.transpiler.im.Script_IM;
import org.eclipse.n4js.transpiler.print.LineColTrackingAppendable;
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef;
import org.eclipse.n4js.utils.N4JSLanguageUtils;
import org.eclipse.xtext.EcoreUtil2;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 * Traverses an intermediate model and serializes it to a {@link LineColTrackingAppendable}. Client code should only use
 * the static method {@link #append(LineColTrackingAppendable, TranspilerState, Optional, N4JSDocumentationProvider)}.
 */
public final class PrettyPrinterDts extends N4JSSwitch<Boolean> {

	/**
	 * Appends the given transpiler state's intermediate model to the given {@link LineColTrackingAppendable}.
	 */
	public static void append(LineColTrackingAppendable out, TranspilerState state, Optional<String> optPreamble,
			N4JSDocumentationProvider documentationProvider) {
		final PrettyPrinterDts theSwitch = new PrettyPrinterDts(out, state, optPreamble, documentationProvider);
		theSwitch.doSwitch(state.im);
	}

	/** Value to be returned from case-methods to indicate that processing is completed and should not be continued. */
	private static final Boolean DONE = Boolean.TRUE;

	private static final Set<N4Modifier> ACCESSIBILITY_MODIFIERS = Sets.newHashSet(
			N4Modifier.PRIVATE,
			N4Modifier.PROTECTED,
			N4Modifier.PROJECT,
			N4Modifier.PUBLIC);

	private final LineColTrackingAppendable out;
	private final Optional<String> optPreamble;
	private final TranspilerState state;
	private final PrettyPrinterTypeRef prettyPrinterTypeRef;
	private final N4JSDocumentationProvider documentationProvider;

	private PrettyPrinterDts(LineColTrackingAppendable out, TranspilerState state, Optional<String> optPreamble,
			N4JSDocumentationProvider documentationProvider) {
		this.out = out;
		this.optPreamble = optPreamble;
		this.state = state;
		this.prettyPrinterTypeRef = new PrettyPrinterTypeRef(this, state);
		this.documentationProvider = documentationProvider;
	}

	@Override
	protected Boolean doSwitch(EClass eClass, EObject eObject) {
		// here we can check for entities of IM.xcore that do not have a super-class in n4js.xcore
		if (eObject instanceof TypeReferenceNode<?>) {
			prettyPrinterTypeRef.processTypeRefNode((TypeReferenceNode<?>) eObject, "");
			return DONE;
		}
		return super.doSwitch(eClass, eObject);
	}

	@Override
	public Boolean defaultCase(EObject object) {
		throw new IllegalStateException(
				"PrettyPrinterSwitch missing a case for objects of type " + object.eClass().getName());
	}

	@Override
	public Boolean caseScript(Script original) {
		final Script_IM original_IM = (Script_IM) original;
		processHashbang(original_IM.getHashbang());
		processPreamble();
		processAnnotations(original_IM.getAnnotations());

		process(original_IM.getScriptElements(), () -> {
			newLine();
		});

		return DONE;
	}

	@Override
	public Boolean caseExportDeclaration(ExportDeclaration original) {
		if (original.getReexportedFrom() != null) {
			throwUnsupportedSyntax();
		}
		processAnnotations(original.getAnnotations());
		write("export ");
		final List<ExportSpecifier> namedExports = original.getNamedExports();
		if (!namedExports.isEmpty()) {
			write("{ ");
			process(namedExports, ", ");
			write(" }");
		} else {
			if (original.isDefaultExport()) {
				write("default ");
			}
			final ExportableElement exportedElement = original.getExportedElement();
			if (exportedElement != null) {
				process(exportedElement);
			} else {
				final Expression exportedExpression = original.getDefaultExportedExpression();
				if (exportedExpression != null && original.isDefaultExport()) {
					process(exportedExpression);
					write(';');
				}
			}
		}
		return DONE;
	}

	@Override
	public Boolean caseExportSpecifier(ExportSpecifier original) {
		process(original.getElement());
		final String alias = original.getAlias();
		if (alias != null) {
			write(" as ");
			write(alias);
		}
		return DONE;
	}

	@Override
	public Boolean caseImportDeclaration(ImportDeclaration original) {
		processAnnotations(original.getAnnotations());
		write("import ");
		// 1) import specifiers
		List<ImportSpecifier> importSpecifiers = new ArrayList<>(original.getImportSpecifiers());
		if (!importSpecifiers.isEmpty() && importSpecifiers.get(0) instanceof DefaultImportSpecifier) {
			process(importSpecifiers.remove(0));
			if (!importSpecifiers.isEmpty()) {
				write(", ");
			}
		}
		if (!importSpecifiers.isEmpty()) {
			final boolean isNamespaceImport = importSpecifiers.get(0) instanceof NamespaceImportSpecifier;
			if (isNamespaceImport) {
				process(importSpecifiers.get(0)); // syntax does not allow more than one namespace import
			} else {
				write('{');
				process(importSpecifiers, ", ");
				write('}');
			}
		}
		// 2) "from"
		if (original.isImportFrom()) {
			write(" from ");
		}
		// 3) module specifier
		String moduleSpecifier = original.getModuleSpecifierAsText() != null
				? original.getModuleSpecifierAsText()
				: original.getModule().getQualifiedName();
		write(quote(moduleSpecifier));
		// 4) empty line after block of imports
		boolean isLastImport = !(EcoreUtil2.getNextSibling(original) instanceof ImportDeclaration);
		if (isLastImport) {
			newLine();
		}
		return DONE;
	}

	/** Also handles DefaultImportSpecifier (which is a subclass of NamedImportSpecifier). */
	@Override
	public Boolean caseNamedImportSpecifier(NamedImportSpecifier original) {
		write(original.getImportedElementAsText());
		final String alias = original.getAlias();
		if (alias != null && !original.isDefaultImport()) {
			write(" as ");
			write(alias);
		}
		return DONE;
	}

	@Override
	public Boolean caseNamespaceImportSpecifier(NamespaceImportSpecifier original) {
		write("* as ");
		write(original.getAlias());
		return DONE;
	}

	@Override
	public Boolean caseN4ClassDeclaration(N4ClassDeclaration original) {
		writeJsdoc(original);
		writeIf("declare ", !original.isExported());
		processModifiers(original.getDeclaredModifiers(), ACCESSIBILITY_MODIFIERS, " ");
		write("class ");
		write(original.getName());
		if (!original.getTypeVars().isEmpty()) {
			write("<");
			for (int i = 0; i < original.getTypeVars().size(); i++) {
				if (i > 0) {
					write(", ");
				}
				N4TypeVariable typeVar = original.getTypeVars().get(i);
				process(typeVar);
			}
			write(">");
		}
		write(' ');

		final TypeReferenceNode<ParameterizedTypeRef> superClassRef = original.getSuperClassRef();
		final Expression superClassExpression = original.getSuperClassExpression();
		if (superClassRef != null) {
			write("extends ");
			process(superClassRef);
			write(' ');
		} else if (superClassExpression != null) {
			// TODO show error
		}

		if (!original.getImplementedInterfaceRefs().isEmpty()) {
			write("implements ");
			for (int i = 0; i < original.getImplementedInterfaceRefs().size(); i++) {
				if (i > 0) {
					write(", ");
				}
				TypeReferenceNode<ParameterizedTypeRef> superInterfRef = original.getImplementedInterfaceRefs().get(i);
				process(superInterfRef);
			}
			write(' ');
		}

		processBlockLike(original.getOwnedMembersRaw(), '{', null, null, '}');
		return DONE;
	}

	@Override
	public Boolean caseN4InterfaceDeclaration(N4InterfaceDeclaration original) {
		writeJsdoc(original);
		writeIf("declare ", !original.isExported());
		processModifiers(original.getDeclaredModifiers(), ACCESSIBILITY_MODIFIERS, " ");
		write("interface ");
		write(original.getName());
		if (!original.getTypeVars().isEmpty()) {
			write("<");
			for (int i = 0; i < original.getTypeVars().size(); i++) {
				if (i > 0) {
					write(", ");
				}
				N4TypeVariable typeVar = original.getTypeVars().get(i);
				process(typeVar);
			}
			write(">");
		}
		write(' ');

		if (!original.getSuperInterfaceRefs().isEmpty()) {
			write("extends ");
			for (int i = 0; i < original.getSuperInterfaceRefs().size(); i++) {
				if (i > 0) {
					write(", ");
				}
				TypeReferenceNode<ParameterizedTypeRef> superInterfRef = original.getSuperInterfaceRefs().get(i);
				process(superInterfRef);
			}
			write(' ');
		}

		// Workaround since TypeScript interfaces do not support static methods

		List<N4MemberDeclaration> staticMembers = new ArrayList<>();
		List<N4MemberDeclaration> nonStaticMembers = new ArrayList<>();
		for (N4MemberDeclaration member : original.getOwnedMembersRaw()) {
			if (member.isStatic()) {
				staticMembers.add(member);
			} else {
				nonStaticMembers.add(member);
			}
		}
		processBlockLike(nonStaticMembers, '{', null, null, '}');

		if (!staticMembers.isEmpty()) {
			write("export ");
			write("namespace ");
			write(original.getName());

			// TODO rewrite static methods to exported(!) functions
			processBlockLike(staticMembers, '{', null, null, '}');
		}
		return DONE;
	}

	@Override
	public Boolean caseN4EnumDeclaration(N4EnumDeclaration original) {
		writeJsdoc(original);
		writeIf("declare ", !original.isExported());
		processModifiers(original.getDeclaredModifiers(), ACCESSIBILITY_MODIFIERS, " ");
		write("enum ");
		write(original.getName());

		processBlockLike(original.getLiterals(), '{', null, null, '}');
		return DONE;
	}

	@Override
	public Boolean caseN4EnumLiteral(N4EnumLiteral literal) {
		write(literal.getName());
		// TODO value!
		return DONE;
	}

	@Override
	public Boolean caseN4TypeAliasDeclaration(N4TypeAliasDeclaration alias) {
		writeJsdoc(alias);
		writeIf("declare ", !alias.isExported());
		write("type ");
		write(alias.getName());
		write(" = ");
		process(alias.getDeclaredTypeRefNode());
		write(";");
		return DONE;
	}

	@Override
	public Boolean caseN4FieldDeclaration(N4FieldDeclaration original) {
		writeJsdoc(original);
		processAnnotations(original.getAnnotations());
		processModifiers(original.getDeclaredModifiers(), Collections.emptySet(), " ");
		processPropertyName(original);
		processDeclaredTypeRef(original);
		write(";");
		return DONE;
	}

	@Override
	public Boolean caseN4GetterDeclaration(N4GetterDeclaration original) {
		writeJsdoc(original);
		processAnnotations(original.getAnnotations());
		processModifiers(original.getDeclaredModifiers(), Collections.emptySet(), " ");
		write("get ");
		processPropertyName(original);
		write("() ");
		processDeclaredTypeRef(original);
		// process(original.getBody());
		write(";");
		return DONE;
	}

	@Override
	public Boolean caseN4SetterDeclaration(N4SetterDeclaration original) {
		writeJsdoc(original);
		processAnnotations(original.getAnnotations());
		processModifiers(original.getDeclaredModifiers(), Collections.emptySet(), " ");
		write("set ");
		processPropertyName(original);
		write('(');
		process(original.getFpar());
		write(") ");
		// process(original.getBody());
		write(";");
		return DONE;
	}

	@Override
	public Boolean caseN4MethodDeclaration(N4MethodDeclaration original) {
		writeJsdoc(original);
		processAnnotations(original.getAnnotations());
		processModifiers(original.getDeclaredModifiers(), Collections.emptySet(), " ");
		if (original.isAsync()) {
			write("async ");
		}
		if (!original.getTypeVars().isEmpty()) {
			processTypeParams(original.getTypeVars());
			write(' ');
		}
		if (original.isGenerator()) {
			write("* ");
		}
		processPropertyName(original);
		write('(');
		process(original.getFpars(), ", ");
		write(")");
		processReturnTypeRef(original);
		// process(original.getBody());
		write(';');
		return DONE;
	}

	@Override
	public Boolean caseLiteralOrComputedPropertyName(LiteralOrComputedPropertyName original) {
		processPropertyName(original);
		return DONE;
	}

	@Override
	public Boolean caseFunctionDeclaration(FunctionDeclaration original) {
		writeJsdoc(original);
		writeIf("declare ", !original.isExported());
		processAnnotations(original.getAnnotations());
		processModifiers(original.getDeclaredModifiers(), ACCESSIBILITY_MODIFIERS, " ");
		if (original.isAsync()) {
			write("async ");
		}
		write("function ");
		if (!original.getTypeVars().isEmpty()) {
			processTypeParams(original.getTypeVars());
			write(' ');
		}
		if (original.isGenerator()) {
			write("* ");
		}
		write(original.getName());
		write('(');
		process(original.getFpars(), ", ");
		write(")");
		processReturnTypeRef(original);
		// process(original.getBody());
		write(';');
		return DONE;
	}

	@Override
	public Boolean caseLocalArgumentsVariable(LocalArgumentsVariable original) {
		// ignore
		return DONE;
	}

	@Override
	public Boolean caseFormalParameter(FormalParameter original) {
		processAnnotations(original.getAnnotations(), false);
		if (original.isVariadic()) {
			write("...");
		}
		write(original.getName());
		processDeclaredTypeRef(original);
		if (original.getInitializer() != null) {
			write("=");
			process(original.getInitializer());
		}
		return DONE;
	}

	@Override
	public Boolean caseBlock(Block original) {
		processBlock(original.getStatements());
		return DONE;
	}

	@Override
	public Boolean caseVariableStatement(VariableStatement original) {
		writeIf("declare ", !(original instanceof ExportedVariableStatement));
		write(keyword(original.getVarStmtKeyword()));
		write(' ');
		process(original.getVarDeclsOrBindings(), ", ");
		// alternative to previous line would be:
		// out.indent();
		// process(original.getVarDeclsOrBindings(), () -> {
		// write(',');
		// newLine();
		// });
		// out.undent();
		write(';');
		return DONE;
	}

	@Override
	public Boolean caseExportedVariableStatement(ExportedVariableStatement original) {
		// note: an ExportedVariableStatement is always a child of an ExportDeclaration and the "export" keyword is
		// emitted there; so, no need to emit "export" in this method!
		processModifiers(original.getDeclaredModifiers(), ACCESSIBILITY_MODIFIERS, " ");
		caseVariableStatement(original);
		return DONE;
	}

	private String keyword(VariableStatementKeyword varStmtKeyword) {
		switch (varStmtKeyword) {
		case LET:
			return "let";
		case CONST:
			return "const";
		case VAR:
			return "var";
		default:
			throw new UnsupportedOperationException("unsupported variable statement keyword");
		}
	}

	@Override
	public Boolean caseExportedVariableDeclaration(ExportedVariableDeclaration original) {
		caseVariableDeclaration(original);
		return DONE;
	}

	@Override
	public Boolean caseVariableDeclaration(VariableDeclaration original) {
		processAnnotations(original.getAnnotations());
		write(original.getName());
		processDeclaredTypeRef(original);
		// if (original.getExpression() != null) {
		// write(" = ");
		// process(original.getExpression());
		// }
		return DONE;
	}

	@Override
	public Boolean caseVariableBinding(VariableBinding original) {
		process(original.getPattern());
		if (original.getExpression() != null) {
			write(" = ");
			process(original.getExpression());
		}
		return DONE;
	}

	@Override
	public Boolean caseExportedVariableBinding(ExportedVariableBinding original) {
		caseExportedVariableBinding(original);
		return DONE;
	}

	@Override
	public Boolean caseN4TypeVariable(N4TypeVariable typeVar) {
		write(typeVar.getName());
		return DONE;
	}

	// ###############################################################################################################
	// UTILITY AND CONVENIENCE METHODS

	private void writeJsdoc(EObject original) {
		EObject originalASTNode = state.tracer.getOriginalASTNode(original);
		if (originalASTNode != null) {
			String documentation = documentationProvider.findComment(originalASTNode);
			if (documentation != null) {
				// documentation = documentation.replaceAll("\\*/", "*\\\\/");
				write(documentation);
				newLine();
			}
		}
	}

	/* package */ void write(char c) {
		try {
			out.append(c);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	/* package */ void write(CharSequence csq) {
		try {
			out.append(csq);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	private void writeIf(CharSequence csq, boolean condition) {
		if (condition) {
			write(csq);
		}
	}

	private void writeQuoted(String csq) {
		write(quote(csq));
	}

	private void writeQuotedIfNonIdentifier(String csq) {
		if (!isLegalIdentifier(csq)) {
			writeQuoted(csq);
		} else {
			write(csq);
		}
	}

	private void newLine() {
		try {
			out.newLine();
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	private void process(Iterable<? extends EObject> elemsInIM, String separator) {
		final Iterator<? extends EObject> iter = elemsInIM.iterator();
		while (iter.hasNext()) {
			doSwitch(iter.next());
			if (separator != null && iter.hasNext()) {
				write(separator);
			}
		}
	}

	private void process(Iterable<? extends EObject> elemsInIM, Runnable separator) {
		final Iterator<? extends EObject> iter = elemsInIM.iterator();
		while (iter.hasNext()) {
			process(iter.next());
			if (separator != null && iter.hasNext()) {
				separator.run();
			}
		}
	}

	@SuppressWarnings("unused")
	private void processIfNonNull(EObject elemInIM) {
		if (elemInIM != null) {
			doSwitch(elemInIM);
		}
	}

	private void process(EObject elemInIM) {
		if (elemInIM == null) {
			throw new IllegalArgumentException("element to process may not be null");
		}
		doSwitch(elemInIM);
	}

	private void processHashbang(String hashbang) {
		if (!Strings.isNullOrEmpty(hashbang)) {
			write(prependHashbang(hashbang));
			newLine();
		}
	}

	private void processPreamble() {
		if (optPreamble.isPresent()) {
			write(optPreamble.get()); // #append(CharSequence) will convert '\n' to correct line separator
			newLine();
		}
	}

	private void processAnnotations(Iterable<? extends Annotation> annotations) {
		processAnnotations(annotations, true);
	}

	private void processAnnotations(@SuppressWarnings("unused") Iterable<? extends Annotation> annotations,
			@SuppressWarnings("unused") boolean multiLine) {
		// throw exception if
		// if (annotations.iterator().hasNext()) {
		// throw new IllegalStateException("Annotations left in the code: " + Joiner.on(",").join(annotations));
		// }
	}

	private void processPropertyName(PropertyNameOwner owner) {
		final LiteralOrComputedPropertyName name = owner.getDeclaredName();
		processPropertyName(name);
	}

	private void processPropertyName(LiteralOrComputedPropertyName name) {
		final PropertyNameKind kind = name.getKind();
		if (kind == PropertyNameKind.COMPUTED) {
			// computed property names:
			write('[');
			process(name.getExpression());
			write(']');
		} else {
			// all other cases than computed property names: IDENTIFIER, STRING, NUMBER
			final String propName = name.getName();
			if (propName.startsWith(N4JSLanguageUtils.SYMBOL_IDENTIFIER_PREFIX)) {
				// we have a name like "#iterator" that represents a Symbol --> emit as: "[Symbol.iterator]"
				// (note: we have to do this special handling here in the pretty printer because there is, at the
				// moment, no way to represent a property assignment with a Symbol as name other than using a name
				// starting with the SYMBOL_IDENTIFIER_PREFIX)
				write("[Symbol.");
				write(propName.substring(1));
				write(']');
			} else {
				// standard case:
				writeQuotedIfNonIdentifier(propName);
			}
		}
	}

	private boolean processModifiers(List<N4Modifier> modifiers, Set<N4Modifier> ignoredModifiers) {
		final int len = modifiers.size();
		boolean didEmitSomething = false;
		for (int idx = 0; idx < len; idx++) {
			N4Modifier m = modifiers.get(idx);
			if (ignoredModifiers != null && ignoredModifiers.contains(m)) {
				continue;
			}
			if (m == N4Modifier.PROJECT) {
				m = N4Modifier.PUBLIC;
			}
			if (didEmitSomething) {
				write(' ');
			}
			write(m.getName());
			didEmitSomething = true;
		}
		return didEmitSomething;
	}

	private boolean processModifiers(List<N4Modifier> modifiers, Set<N4Modifier> ignoredModifiers, String suffix) {
		boolean didEmitSomething = processModifiers(modifiers, ignoredModifiers);
		if (didEmitSomething) {
			write(suffix);
		}
		return didEmitSomething;
	}

	private void processReturnTypeRef(FunctionDefinition funDef) {
		processReturnTypeRef(funDef, "");
	}

	private void processReturnTypeRef(FunctionDefinition funDef, String suffix) {
		TypeReferenceNode<?> declaredReturnTypeRefNode = funDef.getDeclaredReturnTypeRefNode();
		if (declaredReturnTypeRefNode != null) {
			write(": ");
			prettyPrinterTypeRef.processTypeRefNode(declaredReturnTypeRefNode, suffix);
		} else {
			// implicit return type in TypeScript is 'any', so we have to explictly emit 'void' here:
			write(": void");
		}
	}

	private void processDeclaredTypeRef(TypeProvidingElement elem) {
		processDeclaredTypeRef(elem, "");
	}

	private void processDeclaredTypeRef(TypeProvidingElement elem, String suffix) {
		TypeReferenceNode<?> declaredTypeRefNode = elem.getDeclaredTypeRefNode();
		if (declaredTypeRefNode != null) {
			write(": ");
			prettyPrinterTypeRef.processTypeRefNode(declaredTypeRefNode, suffix);
		}
	}

	private void processTypeParams(EList<N4TypeVariable> typeParams) {
		if (typeParams.isEmpty())
			return;

		// In case of plain-JS output no types will be written
		throw new IllegalStateException("Type reference still left in code. typeParams=" + typeParams);
	}

	private void processBlock(Collection<? extends Statement> statements) {
		processBlockLike(statements, '{', null, null, '}');
	}

	/**
	 * Process and indent the given elements in the same way as blocks are indented but using the given characters for
	 * opening and closing the code section.
	 */
	private void processBlockLike(Collection<? extends EObject> elemsInIM, char open, String lineEnd,
			String lastLineEnd, char close) {
		if (elemsInIM.isEmpty()) {
			write(open);
			write(close);
			return;
		}
		write(open);
		out.indent();
		newLine();
		process(elemsInIM, () -> {
			if (lineEnd != null)
				write(lineEnd);
			newLine();
		});
		if (lastLineEnd != null)
			write(lineEnd);
		out.undent();
		newLine();
		write(close);
	}

	private String quote(String txt) {
		return '\'' + ValueConverterUtils.convertToEscapedString(txt, false) + '\'';
	}

	private String prependHashbang(String txt) {
		return "#!" + txt;
	}

	/**
	 * We call this method in methods that we do not want to delete but aren't used and tests for now.
	 */
	private void throwUnsupportedSyntax() {
		throw new UnsupportedOperationException("syntax not supported by pretty printer");
	}
}
