/**
 * Copyright (c) 2022 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.dts.astbuilders;

import static org.eclipse.n4js.dts.TypeScriptParser.RULE_block;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_declarationStatement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_declareStatement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_exportStatement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_exportStatementTail;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_statement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_statementList;

import java.util.LinkedList;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.dts.DtsTokenStream;
import org.eclipse.n4js.dts.TypeScriptParser.ClassDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.EnumDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.ExportStatementContext;
import org.eclipse.n4js.dts.TypeScriptParser.FunctionDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.ImportStatementContext;
import org.eclipse.n4js.dts.TypeScriptParser.InterfaceDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.ModuleDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.NamespaceDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.ProgramContext;
import org.eclipse.n4js.dts.TypeScriptParser.TypeAliasDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.VariableStatementContext;
import org.eclipse.n4js.dts.utils.ParserContextUtils;
import org.eclipse.n4js.n4JS.ExportDeclaration;
import org.eclipse.n4js.n4JS.ExportableElement;
import org.eclipse.n4js.n4JS.FunctionDeclaration;
import org.eclipse.n4js.n4JS.ImportDeclaration;
import org.eclipse.n4js.n4JS.N4ClassDeclaration;
import org.eclipse.n4js.n4JS.N4EnumDeclaration;
import org.eclipse.n4js.n4JS.N4InterfaceDeclaration;
import org.eclipse.n4js.n4JS.N4JSFactory;
import org.eclipse.n4js.n4JS.N4JSPackage;
import org.eclipse.n4js.n4JS.N4NamespaceDeclaration;
import org.eclipse.n4js.n4JS.N4TypeAliasDeclaration;
import org.eclipse.n4js.n4JS.NamespaceElement;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.n4JS.ScriptElement;
import org.eclipse.n4js.n4JS.VariableStatement;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;

/**
 * Builder to create {@link Script} elements and all its children from d.ts parse tree elements
 */
public class DtsScriptBuilder extends AbstractDtsBuilder<ProgramContext, Script> {
	private final URI srcFolder;

	private DtsExportBuilder exportBuilder;

	/** Constructor */
	public DtsScriptBuilder(DtsTokenStream tokenStream, LazyLinkingResource resource, URI srcFolder) {
		super(tokenStream, resource);
		this.srcFolder = srcFolder;
	}

	/** @return the script that was created during visiting the parse tree */
	public Script getScript() {
		return result;
	}

	private void addToScript(ScriptElement elem) {
		if (elem == null) {
			return;
		}
		result.getScriptElements().add(elem);
	}

	@Override
	protected Set<Integer> getVisitChildrenOfRules() {
		return java.util.Set.of(
				RULE_statement,
				RULE_statementList,
				RULE_declareStatement,
				RULE_declarationStatement,
				RULE_exportStatement,
				RULE_exportStatementTail,
				RULE_block); // temp
	}

	@Override
	public void enterProgram(ProgramContext ctx) {
		result = N4JSFactory.eINSTANCE.createScript();
		if (ctx.statementList() != null) {
			walker.enqueue(ctx.statementList().statement());
		}
		exportBuilder = new DtsExportBuilder(tokenStream, resource, ctx);
	}

	@Override
	public void exitProgram(ProgramContext ctx) {
		ParserContextUtils.removeOverloadingFunctionDefs(result.getScriptElements());
		ParserContextUtils.transformPromisifiables(result.getScriptElements());
	}

	@Override
	public void enterImportStatement(ImportStatementContext ctx) {
		ImportDeclaration id = newImportBuilder().consume(ctx);
		addToScript(id);
	}

	@Override
	public void enterExportStatement(ExportStatementContext ctx) {
		ExportDeclaration ed = exportBuilder.consume(ctx);
		addToScript(ed);
	}

	@Override
	public void enterNamespaceDeclaration(NamespaceDeclarationContext ctx) {
		N4NamespaceDeclaration nd = newNamespaceBuilder().consume(ctx);
		addAndHandleExported(ctx, nd);
	}

	@Override
	public void enterModuleDeclaration(ModuleDeclarationContext ctx) {
		N4NamespaceDeclaration d = newModuleBuilder(srcFolder).consume(ctx);
		addAndHandleExported(ctx, d);
	}

	@Override
	public void enterVariableStatement(VariableStatementContext ctx) {
		VariableStatement vs = newVariableBuilder().consumeInScript(ctx);
		addAndHandleExported(ctx, vs);
	}

	@Override
	public void enterInterfaceDeclaration(InterfaceDeclarationContext ctx) {
		N4InterfaceDeclaration id = newInterfaceBuilder().consume(ctx);
		addAndHandleExported(ctx, id);
	}

	@Override
	public void enterClassDeclaration(ClassDeclarationContext ctx) {
		N4ClassDeclaration cd = newClassBuilder().consume(ctx);
		addAndHandleExported(ctx, cd);
	}

	@Override
	public void enterEnumDeclaration(EnumDeclarationContext ctx) {
		N4EnumDeclaration ed = newEnumBuilder().consume(ctx);
		addAndHandleExported(ctx, ed);
	}

	@Override
	public void enterTypeAliasDeclaration(TypeAliasDeclarationContext ctx) {
		N4TypeAliasDeclaration tad = newTypeAliasBuilder().consume(ctx);
		addAndHandleExported(ctx, tad);
	}

	@Override
	public void enterFunctionDeclaration(FunctionDeclarationContext ctx) {
		FunctionDeclaration fd = newFunctionBuilder().consume(ctx);
		addAndHandleExported(ctx, fd);
	}

	private void addAndHandleExported(ParserRuleContext ctx, ExportableElement elem) {
		if (exportBuilder.isExportedEquals()) {
			// TODO check for name
			transformExportEquals(elem);
		} else {
			ParserContextUtils.addAndHandleExported(result, N4JSPackage.Literals.SCRIPT__SCRIPT_ELEMENTS,
					elem, false, ctx);
		}
	}

	/** Ignore namespace and map all its contents to the script. Also export every element directly. */
	private void transformExportEquals(ExportableElement elem) {
		if (elem instanceof N4NamespaceDeclaration) {
			N4NamespaceDeclaration nsDecl = (N4NamespaceDeclaration) elem;

			for (NamespaceElement nsElem : new LinkedList<>(nsDecl.getOwnedElementsRaw())) {
				ExportableElement exportableElem = null;
				if (nsElem instanceof ExportableElement) {
					exportableElem = (ExportableElement) nsElem;
				} else if (nsElem instanceof ExportDeclaration) {
					exportableElem = ((ExportDeclaration) nsElem).getExportedElement();
				}
				if (exportableElem != null) {
					ParserContextUtils.addAndHandleExported(result, N4JSPackage.Literals.SCRIPT__SCRIPT_ELEMENTS,
							exportableElem, false, true, false);
				}
			}
		} else {
			ParserContextUtils.addAndHandleExported(result, N4JSPackage.Literals.SCRIPT__SCRIPT_ELEMENTS,
					elem, false, true, true);
		}
	}

}
