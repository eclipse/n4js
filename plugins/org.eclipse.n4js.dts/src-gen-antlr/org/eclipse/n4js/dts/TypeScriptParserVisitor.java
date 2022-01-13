// Generated from /Users/marcusmews/Eclipses/ECL3/git/n4js/plugins/org.eclipse.n4js.dts/grammar/TypeScriptParser.g4 by ANTLR 4.7.2
package org.eclipse.n4js.dts;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TypeScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TypeScriptParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(TypeScriptParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#bindingPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingPattern(TypeScriptParser.BindingPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(TypeScriptParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(TypeScriptParser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(TypeScriptParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(TypeScriptParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#defaultType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultType(TypeScriptParser.DefaultTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#colonSepTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColonSepTypeRef(TypeScriptParser.ColonSepTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(TypeScriptParser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#conditionalTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalTypeRef(TypeScriptParser.ConditionalTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#unionTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionTypeExpression(TypeScriptParser.UnionTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#intersectionTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntersectionTypeExpression(TypeScriptParser.IntersectionTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#operatorTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorTypeRef(TypeScriptParser.OperatorTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeOperator(TypeScriptParser.TypeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#arrayTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeExpression(TypeScriptParser.ArrayTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#primaryTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryTypeExpression(TypeScriptParser.PrimaryTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#literalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralType(TypeScriptParser.LiteralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#arrowFunctionTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunctionTypeExpression(TypeScriptParser.ArrowFunctionTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#tupleTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleTypeExpression(TypeScriptParser.TupleTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#tupleTypeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleTypeArgument(TypeScriptParser.TupleTypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(TypeScriptParser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeRefWithModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRefWithModifiers(TypeScriptParser.TypeRefWithModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#parameterizedTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterizedTypeRef(TypeScriptParser.ParameterizedTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(TypeScriptParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeGeneric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeGeneric(TypeScriptParser.TypeGenericContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(TypeScriptParser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(TypeScriptParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(TypeScriptParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#objectLiteralTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteralTypeRef(TypeScriptParser.ObjectLiteralTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#thisTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisTypeRef(TypeScriptParser.ThisTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#queryTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryTypeRef(TypeScriptParser.QueryTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#importTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportTypeRef(TypeScriptParser.ImportTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#anonymousFormalParameterListWithDeclaredThisType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousFormalParameterListWithDeclaredThisType(TypeScriptParser.AnonymousFormalParameterListWithDeclaredThisTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#anonymousFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousFormalParameter(TypeScriptParser.AnonymousFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#defaultFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultFormalParameter(TypeScriptParser.DefaultFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typePredicateWithOperatorTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePredicateWithOperatorTypeRef(TypeScriptParser.TypePredicateWithOperatorTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#bindingIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingIdentifier(TypeScriptParser.BindingIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#propertyAccessExpressionInTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyAccessExpressionInTypeRef(TypeScriptParser.PropertyAccessExpressionInTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#inferTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInferTypeRef(TypeScriptParser.InferTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#propertySignatur}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertySignatur(TypeScriptParser.PropertySignaturContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#constructSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructSignature(TypeScriptParser.ConstructSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#indexSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexSignature(TypeScriptParser.IndexSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#indexSignatureElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexSignatureElement(TypeScriptParser.IndexSignatureElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#methodSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSignature(TypeScriptParser.MethodSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeAliasDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAliasDeclaration(TypeScriptParser.TypeAliasDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(TypeScriptParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#interfaceExtendsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceExtendsClause(TypeScriptParser.InterfaceExtendsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#classOrInterfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceTypeList(TypeScriptParser.ClassOrInterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(TypeScriptParser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(TypeScriptParser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#enumMemberList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumMemberList(TypeScriptParser.EnumMemberListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#enumMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumMember(TypeScriptParser.EnumMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#namespaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceDeclaration(TypeScriptParser.NamespaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#namespaceName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceName(TypeScriptParser.NamespaceNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#moduleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDeclaration(TypeScriptParser.ModuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#moduleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleName(TypeScriptParser.ModuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#decoratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorList(TypeScriptParser.DecoratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(TypeScriptParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#decoratorMemberExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorMemberExpression(TypeScriptParser.DecoratorMemberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#decoratorCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorCallExpression(TypeScriptParser.DecoratorCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TypeScriptParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TypeScriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#declareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStatement(TypeScriptParser.DeclareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#declarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStatement(TypeScriptParser.DeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(TypeScriptParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(TypeScriptParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(TypeScriptParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#importFromBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportFromBlock(TypeScriptParser.ImportFromBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#multipleImportElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleImportElements(TypeScriptParser.MultipleImportElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#importedElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportedElement(TypeScriptParser.ImportedElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#importAliasDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAliasDeclaration(TypeScriptParser.ImportAliasDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#exportStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportStatement(TypeScriptParser.ExportStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportAsNamespace}
	 * labeled alternative in {@link TypeScriptParser#exportStatementTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportAsNamespace(TypeScriptParser.ExportAsNamespaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportEquals}
	 * labeled alternative in {@link TypeScriptParser#exportStatementTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportEquals(TypeScriptParser.ExportEqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportImport}
	 * labeled alternative in {@link TypeScriptParser#exportStatementTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportImport(TypeScriptParser.ExportImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportDeclareStatement}
	 * labeled alternative in {@link TypeScriptParser#exportStatementTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDeclareStatement(TypeScriptParser.ExportDeclareStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportElement}
	 * labeled alternative in {@link TypeScriptParser#exportStatementTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportElement(TypeScriptParser.ExportElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#exportFromBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportFromBlock(TypeScriptParser.ExportFromBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatement(TypeScriptParser.VariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationList(TypeScriptParser.VariableDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(TypeScriptParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(TypeScriptParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(TypeScriptParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(TypeScriptParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link TypeScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(TypeScriptParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link TypeScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(TypeScriptParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link TypeScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(TypeScriptParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForVarStatement}
	 * labeled alternative in {@link TypeScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForVarStatement(TypeScriptParser.ForVarStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link TypeScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInStatement(TypeScriptParser.ForInStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForVarInStatement}
	 * labeled alternative in {@link TypeScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForVarInStatement(TypeScriptParser.ForVarInStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#varModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarModifier(TypeScriptParser.VarModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(TypeScriptParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(TypeScriptParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(TypeScriptParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(TypeScriptParser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(TypeScriptParser.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(TypeScriptParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(TypeScriptParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#caseClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClauses(TypeScriptParser.CaseClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#caseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClause(TypeScriptParser.CaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(TypeScriptParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#labelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelledStatement(TypeScriptParser.LabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(TypeScriptParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(TypeScriptParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#catchProduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchProduction(TypeScriptParser.CatchProductionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#finallyProduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyProduction(TypeScriptParser.FinallyProductionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#debuggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebuggerStatement(TypeScriptParser.DebuggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(TypeScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(TypeScriptParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#classHeritage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassHeritage(TypeScriptParser.ClassHeritageContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#classTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassTail(TypeScriptParser.ClassTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#classElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassElementList(TypeScriptParser.ClassElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#classExtendsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExtendsClause(TypeScriptParser.ClassExtendsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#implementsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplementsClause(TypeScriptParser.ImplementsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#classElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassElement(TypeScriptParser.ClassElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(TypeScriptParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#propertyMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyMemberDeclaration(TypeScriptParser.PropertyMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#abstractDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractDeclaration(TypeScriptParser.AbstractDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#propertyMemberBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyMemberBase(TypeScriptParser.PropertyMemberBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#generatorMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorMethod(TypeScriptParser.GeneratorMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#generatorFunctionExpressionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorFunctionExpressionDeclaration(TypeScriptParser.GeneratorFunctionExpressionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#generatorBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorBlock(TypeScriptParser.GeneratorBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#generatorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorDefinition(TypeScriptParser.GeneratorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#iteratorBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteratorBlock(TypeScriptParser.IteratorBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#iteratorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteratorDefinition(TypeScriptParser.IteratorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#callSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSignature(TypeScriptParser.CallSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#parameterBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterBlock(TypeScriptParser.ParameterBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#parameterListTrailingComma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListTrailingComma(TypeScriptParser.ParameterListTrailingCommaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(TypeScriptParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#restParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestParameter(TypeScriptParser.RestParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(TypeScriptParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#requiredParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiredParameter(TypeScriptParser.RequiredParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#optionalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalParameter(TypeScriptParser.OptionalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#accessibilityModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessibilityModifier(TypeScriptParser.AccessibilityModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#identifierOrPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierOrPattern(TypeScriptParser.IdentifierOrPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(TypeScriptParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#elementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementList(TypeScriptParser.ElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#arrayElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElement(TypeScriptParser.ArrayElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBody(TypeScriptParser.TypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeMemberList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeMemberList(TypeScriptParser.TypeMemberListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeMember(TypeScriptParser.TypeMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(TypeScriptParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyExpressionAssignment}
	 * labeled alternative in {@link TypeScriptParser#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyExpressionAssignment(TypeScriptParser.PropertyExpressionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComputedPropertyExpressionAssignment}
	 * labeled alternative in {@link TypeScriptParser#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedPropertyExpressionAssignment(TypeScriptParser.ComputedPropertyExpressionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyGetter}
	 * labeled alternative in {@link TypeScriptParser#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyGetter(TypeScriptParser.PropertyGetterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertySetter}
	 * labeled alternative in {@link TypeScriptParser#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertySetter(TypeScriptParser.PropertySetterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodProperty}
	 * labeled alternative in {@link TypeScriptParser#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodProperty(TypeScriptParser.MethodPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyShorthand}
	 * labeled alternative in {@link TypeScriptParser#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyShorthand(TypeScriptParser.PropertyShorthandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RestParameterInObject}
	 * labeled alternative in {@link TypeScriptParser#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestParameterInObject(TypeScriptParser.RestParameterInObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#getAccessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetAccessor(TypeScriptParser.GetAccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#setAccessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAccessor(TypeScriptParser.SetAccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#propertyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyName(TypeScriptParser.PropertyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(TypeScriptParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(TypeScriptParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(TypeScriptParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(TypeScriptParser.ExpressionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#functionExpressionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpressionDeclaration(TypeScriptParser.FunctionExpressionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TemplateStringExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateStringExpression(TypeScriptParser.TemplateStringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(TypeScriptParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GeneratorsExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorsExpression(TypeScriptParser.GeneratorsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(TypeScriptParser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectLiteralExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteralExpression(TypeScriptParser.ObjectLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(TypeScriptParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GenericTypes}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTypes(TypeScriptParser.GenericTypesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(TypeScriptParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecreaseExpression(TypeScriptParser.PreDecreaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentsExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsExpression(TypeScriptParser.ArgumentsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ThisExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(TypeScriptParser.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(TypeScriptParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(TypeScriptParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(TypeScriptParser.UnaryMinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(TypeScriptParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(TypeScriptParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecreaseExpression(TypeScriptParser.PostDecreaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeofExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeofExpression(TypeScriptParser.TypeofExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstanceofExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceofExpression(TypeScriptParser.InstanceofExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryPlusExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPlusExpression(TypeScriptParser.UnaryPlusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeleteExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteExpression(TypeScriptParser.DeleteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrowFunctionExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunctionExpression(TypeScriptParser.ArrowFunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IteratorsExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteratorsExpression(TypeScriptParser.IteratorsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(TypeScriptParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CastAsExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastAsExpression(TypeScriptParser.CastAsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SuperExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperExpression(TypeScriptParser.SuperExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(TypeScriptParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitShiftExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitShiftExpression(TypeScriptParser.BitShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(TypeScriptParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(TypeScriptParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(TypeScriptParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(TypeScriptParser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code YieldExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldExpression(TypeScriptParser.YieldExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitNotExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitNotExpression(TypeScriptParser.BitNotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(TypeScriptParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(TypeScriptParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLiteralExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralExpression(TypeScriptParser.ArrayLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDotExpression(TypeScriptParser.MemberDotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExpression(TypeScriptParser.ClassExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberIndexExpression(TypeScriptParser.MemberIndexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(TypeScriptParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentOperatorExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperatorExpression(TypeScriptParser.AssignmentOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidExpression}
	 * labeled alternative in {@link TypeScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidExpression(TypeScriptParser.VoidExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#arrowFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunctionDeclaration(TypeScriptParser.ArrowFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#arrowFunctionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunctionParameters(TypeScriptParser.ArrowFunctionParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#arrowFunctionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunctionBody(TypeScriptParser.ArrowFunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(TypeScriptParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(TypeScriptParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#templateStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateStringLiteral(TypeScriptParser.TemplateStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#templateStringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateStringAtom(TypeScriptParser.TemplateStringAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(TypeScriptParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#identifierOrKeyWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierOrKeyWord(TypeScriptParser.IdentifierOrKeyWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#identifierName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierName(TypeScriptParser.IdentifierNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#reservedWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReservedWord(TypeScriptParser.ReservedWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#typeReferenceName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeReferenceName(TypeScriptParser.TypeReferenceNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(TypeScriptParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#keywordAllowedInTypeReferences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordAllowedInTypeReferences(TypeScriptParser.KeywordAllowedInTypeReferencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#getter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetter(TypeScriptParser.GetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#setter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetter(TypeScriptParser.SetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypeScriptParser#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(TypeScriptParser.EosContext ctx);
}