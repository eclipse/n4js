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

import static org.eclipse.n4js.dts.TypeScriptParser.RULE_classElement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_classElementList;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_declarationStatement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_declareStatement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_exportStatement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_exportStatementTail;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_statement;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_statementList;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_typeMember;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_typeMemberList;

import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.n4js.dts.ParserContextUtil;
import org.eclipse.n4js.dts.TypeScriptParser;
import org.eclipse.n4js.dts.TypeScriptParser.ClassDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.EnumDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.FunctionDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.InterfaceDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.NamespaceDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.TypeAliasDeclarationContext;
import org.eclipse.n4js.dts.TypeScriptParser.VariableStatementContext;
import org.eclipse.n4js.n4JS.ExportDeclaration;
import org.eclipse.n4js.n4JS.FormalParameter;
import org.eclipse.n4js.n4JS.FunctionDeclaration;
import org.eclipse.n4js.n4JS.N4ClassDeclaration;
import org.eclipse.n4js.n4JS.N4EnumDeclaration;
import org.eclipse.n4js.n4JS.N4InterfaceDeclaration;
import org.eclipse.n4js.n4JS.N4JSFactory;
import org.eclipse.n4js.n4JS.N4Modifier;
import org.eclipse.n4js.n4JS.N4NamespaceDeclaration;
import org.eclipse.n4js.n4JS.N4TypeAliasDeclaration;
import org.eclipse.n4js.n4JS.N4TypeVariable;
import org.eclipse.n4js.n4JS.Script;
import org.eclipse.n4js.n4JS.TypeReferenceNode;
import org.eclipse.n4js.ts.typeRefs.TypeRef;

/**
 * Builder to create {@link Script} elements and all its children from d.ts parse tree elements
 */
public class DtsNamespaceBuilder extends AbstractDtsSubBuilder<NamespaceDeclarationContext, N4NamespaceDeclaration> {
	private final DtsTypeRefBuilder typeRefBuilder = new DtsTypeRefBuilder();
	private final DtsTypeVariablesBuilder typeVariablesBuilder = new DtsTypeVariablesBuilder();
	private final DtsFormalParametersBuilder formalParametersBuilder = new DtsFormalParametersBuilder();
	private final DtsExpressionBuilder expressionBuilder = new DtsExpressionBuilder();
	private final DtsClassBuilder classBuilder = new DtsClassBuilder();
	private final DtsInterfaceBuilder interfaceBuilder = new DtsInterfaceBuilder();
	private final DtsEnumBuilder enumBuilder = new DtsEnumBuilder();
	private final Stack<N4NamespaceDeclaration> currentNamespace = new Stack<>();

	@Override
	protected Set<Integer> getVisitChildrenOfRules() {
		return java.util.Set.of(
				RULE_statement,
				RULE_statementList,
				RULE_declareStatement,
				RULE_declarationStatement,
				RULE_exportStatement,
				RULE_exportStatementTail,
				RULE_classElementList,
				RULE_classElement,
				RULE_typeMember,
				RULE_typeMemberList);
	}

	@Override
	public void enterNamespaceDeclaration(NamespaceDeclarationContext ctx) {
		N4NamespaceDeclaration nd = N4JSFactory.eINSTANCE.createN4NamespaceDeclaration();
		nd.setName(ctx.namespaceName().getText());

		boolean isExported = ParserContextUtil.isExported(ctx);
		if (isExported) {
			nd.getDeclaredModifiers().add(N4Modifier.PUBLIC);
		}
		if (isExported && currentNamespace.empty()) {
			ExportDeclaration ed = N4JSFactory.eINSTANCE.createExportDeclaration();
			ed.setExportedElement(nd);
			addToScript(ed);
		} else {
			addToScript(nd);
		}

		currentNamespace.push(nd);

		walker.enqueue(ctx.block().statementList());
	}

	@Override
	public void enterVariableStatement(VariableStatementContext ctx) {
	}

	@Override
	public void enterInterfaceDeclaration(InterfaceDeclarationContext ctx) {
		N4InterfaceDeclaration id = interfaceBuilder.consume(ctx);
		boolean isExported = ParserContextUtil.isExported(ctx);
		if (isExported) {
			id.getDeclaredModifiers().add(N4Modifier.PUBLIC);
		}
		resultNamespace.getOwnedElementsRaw().add(id);
	}

	@Override
	public void enterClassDeclaration(ClassDeclarationContext ctx) {
		N4ClassDeclaration cd = classBuilder.consume(ctx);
		boolean isExported = ParserContextUtil.isExported(ctx);
		if (isExported) {
			cd.getDeclaredModifiers().add(N4Modifier.PUBLIC);
		}
		resultNamespace.getOwnedElementsRaw().add(cd);
	}

	@Override
	public void enterTypeAliasDeclaration(TypeAliasDeclarationContext ctx) {
		N4TypeAliasDeclaration tad = N4JSFactory.eINSTANCE.createN4TypeAliasDeclaration();
		tad.setName(ctx.identifierName().getText());
		tad.getDeclaredModifiers().add(N4Modifier.EXTERNAL);
		boolean isExported = ParserContextUtil.isExported(ctx);
		if (isExported) {
			tad.getDeclaredModifiers().add(N4Modifier.PUBLIC);
		}
		if (isExported && currentNamespace.empty()) {
			ExportDeclaration ed = N4JSFactory.eINSTANCE.createExportDeclaration();
			ed.setExportedElement(tad);
			addToScript(ed);
		} else {
			addToScript(tad);
		}

		TypeReferenceNode<TypeRef> trn = typeRefBuilder.consume(ctx.typeRef());
		tad.setDeclaredTypeRefNode(trn);
		List<N4TypeVariable> typeVars = typeVariablesBuilder.consume(ctx.typeParameters());
		tad.getTypeVars().addAll(typeVars);
	}

	@Override
	public void enterFunctionDeclaration(FunctionDeclarationContext ctx) {
		FunctionDeclaration fd = N4JSFactory.eINSTANCE.createFunctionDeclaration();
		fd.setName(ctx.identifierName().getText());
		fd.getDeclaredModifiers().add(N4Modifier.EXTERNAL);
		boolean isExported = ParserContextUtil.isExported(ctx);
		if (isExported) {
			fd.getDeclaredModifiers().add(N4Modifier.PUBLIC);
		}
		if (isExported && currentNamespace.empty()) {
			ExportDeclaration ed = N4JSFactory.eINSTANCE.createExportDeclaration();
			ed.setExportedElement(fd);
			addToScript(ed);
		} else {
			addToScript(fd);
		}

		fd.setGenerator(ctx.Multiply() != null);
		TypeReferenceNode<TypeRef> trn = typeRefBuilder.consume(ctx.callSignature().typeRef());
		fd.setDeclaredReturnTypeRefNode(trn);
		List<N4TypeVariable> typeVars = typeVariablesBuilder.consume(ctx.callSignature().typeParameters());
		fd.getTypeVars().addAll(typeVars);
		List<FormalParameter> fPars = formalParametersBuilder.consume(ctx.callSignature().parameterBlock());
		fd.getFpars().addAll(fPars);
	}

	@Override
	public void enterEnumDeclaration(EnumDeclarationContext ctx) {
		N4EnumDeclaration ed = enumBuilder.consume(ctx);

		boolean isExported = ParserContextUtil.isExported(ctx);
		if (isExported) {
			ed.getDeclaredModifiers().add(N4Modifier.PUBLIC);
		}
		resultNamespace.getOwnedElementsRaw().add(ed);
	}
}
