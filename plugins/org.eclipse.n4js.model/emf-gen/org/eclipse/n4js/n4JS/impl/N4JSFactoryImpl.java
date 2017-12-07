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
package org.eclipse.n4js.n4JS.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.n4js.n4JS.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class N4JSFactoryImpl extends EFactoryImpl implements N4JSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static N4JSFactory init() {
		try {
			N4JSFactory theN4JSFactory = (N4JSFactory)EPackage.Registry.INSTANCE.getEFactory(N4JSPackage.eNS_URI);
			if (theN4JSFactory != null) {
				return theN4JSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new N4JSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4JSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case N4JSPackage.SCRIPT: return createScript();
			case N4JSPackage.EXPORT_DECLARATION: return createExportDeclaration();
			case N4JSPackage.EXPORT_SPECIFIER: return createExportSpecifier();
			case N4JSPackage.IMPORT_DECLARATION: return createImportDeclaration();
			case N4JSPackage.NAMED_IMPORT_SPECIFIER: return createNamedImportSpecifier();
			case N4JSPackage.DEFAULT_IMPORT_SPECIFIER: return createDefaultImportSpecifier();
			case N4JSPackage.NAMESPACE_IMPORT_SPECIFIER: return createNamespaceImportSpecifier();
			case N4JSPackage.ANNOTATION_LIST: return createAnnotationList();
			case N4JSPackage.EXPRESSION_ANNOTATION_LIST: return createExpressionAnnotationList();
			case N4JSPackage.ANNOTATION: return createAnnotation();
			case N4JSPackage.LITERAL_ANNOTATION_ARGUMENT: return createLiteralAnnotationArgument();
			case N4JSPackage.TYPE_REF_ANNOTATION_ARGUMENT: return createTypeRefAnnotationArgument();
			case N4JSPackage.FUNCTION_DECLARATION: return createFunctionDeclaration();
			case N4JSPackage.FUNCTION_EXPRESSION: return createFunctionExpression();
			case N4JSPackage.ARROW_FUNCTION: return createArrowFunction();
			case N4JSPackage.LOCAL_ARGUMENTS_VARIABLE: return createLocalArgumentsVariable();
			case N4JSPackage.FORMAL_PARAMETER: return createFormalParameter();
			case N4JSPackage.BLOCK: return createBlock();
			case N4JSPackage.STATEMENT: return createStatement();
			case N4JSPackage.VARIABLE_STATEMENT: return createVariableStatement();
			case N4JSPackage.EXPORTED_VARIABLE_STATEMENT: return createExportedVariableStatement();
			case N4JSPackage.VARIABLE_BINDING: return createVariableBinding();
			case N4JSPackage.EXPORTED_VARIABLE_BINDING: return createExportedVariableBinding();
			case N4JSPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case N4JSPackage.EXPORTED_VARIABLE_DECLARATION: return createExportedVariableDeclaration();
			case N4JSPackage.EMPTY_STATEMENT: return createEmptyStatement();
			case N4JSPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
			case N4JSPackage.IF_STATEMENT: return createIfStatement();
			case N4JSPackage.ITERATION_STATEMENT: return createIterationStatement();
			case N4JSPackage.DO_STATEMENT: return createDoStatement();
			case N4JSPackage.WHILE_STATEMENT: return createWhileStatement();
			case N4JSPackage.FOR_STATEMENT: return createForStatement();
			case N4JSPackage.CONTINUE_STATEMENT: return createContinueStatement();
			case N4JSPackage.BREAK_STATEMENT: return createBreakStatement();
			case N4JSPackage.RETURN_STATEMENT: return createReturnStatement();
			case N4JSPackage.WITH_STATEMENT: return createWithStatement();
			case N4JSPackage.SWITCH_STATEMENT: return createSwitchStatement();
			case N4JSPackage.CASE_CLAUSE: return createCaseClause();
			case N4JSPackage.DEFAULT_CLAUSE: return createDefaultClause();
			case N4JSPackage.LABELLED_STATEMENT: return createLabelledStatement();
			case N4JSPackage.THROW_STATEMENT: return createThrowStatement();
			case N4JSPackage.TRY_STATEMENT: return createTryStatement();
			case N4JSPackage.CATCH_BLOCK: return createCatchBlock();
			case N4JSPackage.CATCH_VARIABLE: return createCatchVariable();
			case N4JSPackage.FINALLY_BLOCK: return createFinallyBlock();
			case N4JSPackage.DEBUGGER_STATEMENT: return createDebuggerStatement();
			case N4JSPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
			case N4JSPackage.PAREN_EXPRESSION: return createParenExpression();
			case N4JSPackage.IDENTIFIER_REF: return createIdentifierRef();
			case N4JSPackage.SUPER_LITERAL: return createSuperLiteral();
			case N4JSPackage.THIS_LITERAL: return createThisLiteral();
			case N4JSPackage.ARRAY_LITERAL: return createArrayLiteral();
			case N4JSPackage.ARRAY_ELEMENT: return createArrayElement();
			case N4JSPackage.ARRAY_PADDING: return createArrayPadding();
			case N4JSPackage.OBJECT_LITERAL: return createObjectLiteral();
			case N4JSPackage.LITERAL_OR_COMPUTED_PROPERTY_NAME: return createLiteralOrComputedPropertyName();
			case N4JSPackage.PROPERTY_ASSIGNMENT_ANNOTATION_LIST: return createPropertyAssignmentAnnotationList();
			case N4JSPackage.PROPERTY_NAME_VALUE_PAIR: return createPropertyNameValuePair();
			case N4JSPackage.PROPERTY_NAME_VALUE_PAIR_SINGLE_NAME: return createPropertyNameValuePairSingleName();
			case N4JSPackage.PROPERTY_METHOD_DECLARATION: return createPropertyMethodDeclaration();
			case N4JSPackage.PROPERTY_GETTER_DECLARATION: return createPropertyGetterDeclaration();
			case N4JSPackage.PROPERTY_SETTER_DECLARATION: return createPropertySetterDeclaration();
			case N4JSPackage.NEW_TARGET: return createNewTarget();
			case N4JSPackage.NEW_EXPRESSION: return createNewExpression();
			case N4JSPackage.PARAMETERIZED_CALL_EXPRESSION: return createParameterizedCallExpression();
			case N4JSPackage.ARGUMENT: return createArgument();
			case N4JSPackage.INDEXED_ACCESS_EXPRESSION: return createIndexedAccessExpression();
			case N4JSPackage.TAGGED_TEMPLATE_STRING: return createTaggedTemplateString();
			case N4JSPackage.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION: return createParameterizedPropertyAccessExpression();
			case N4JSPackage.AWAIT_EXPRESSION: return createAwaitExpression();
			case N4JSPackage.PROMISIFY_EXPRESSION: return createPromisifyExpression();
			case N4JSPackage.YIELD_EXPRESSION: return createYieldExpression();
			case N4JSPackage.LITERAL: return createLiteral();
			case N4JSPackage.NULL_LITERAL: return createNullLiteral();
			case N4JSPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			case N4JSPackage.STRING_LITERAL: return createStringLiteral();
			case N4JSPackage.TEMPLATE_LITERAL: return createTemplateLiteral();
			case N4JSPackage.TEMPLATE_SEGMENT: return createTemplateSegment();
			case N4JSPackage.NUMERIC_LITERAL: return createNumericLiteral();
			case N4JSPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case N4JSPackage.ABSTRACT_INT_LITERAL: return createAbstractIntLiteral();
			case N4JSPackage.INT_LITERAL: return createIntLiteral();
			case N4JSPackage.BINARY_INT_LITERAL: return createBinaryIntLiteral();
			case N4JSPackage.OCTAL_INT_LITERAL: return createOctalIntLiteral();
			case N4JSPackage.LEGACY_OCTAL_INT_LITERAL: return createLegacyOctalIntLiteral();
			case N4JSPackage.HEX_INT_LITERAL: return createHexIntLiteral();
			case N4JSPackage.SCIENTIFIC_INT_LITERAL: return createScientificIntLiteral();
			case N4JSPackage.REGULAR_EXPRESSION_LITERAL: return createRegularExpressionLiteral();
			case N4JSPackage.POSTFIX_EXPRESSION: return createPostfixExpression();
			case N4JSPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case N4JSPackage.CAST_EXPRESSION: return createCastExpression();
			case N4JSPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
			case N4JSPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
			case N4JSPackage.SHIFT_EXPRESSION: return createShiftExpression();
			case N4JSPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
			case N4JSPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
			case N4JSPackage.BINARY_BITWISE_EXPRESSION: return createBinaryBitwiseExpression();
			case N4JSPackage.BINARY_LOGICAL_EXPRESSION: return createBinaryLogicalExpression();
			case N4JSPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
			case N4JSPackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
			case N4JSPackage.COMMA_EXPRESSION: return createCommaExpression();
			case N4JSPackage.N4_CLASS_DECLARATION: return createN4ClassDeclaration();
			case N4JSPackage.N4_CLASS_EXPRESSION: return createN4ClassExpression();
			case N4JSPackage.N4_INTERFACE_DECLARATION: return createN4InterfaceDeclaration();
			case N4JSPackage.N4_ENUM_DECLARATION: return createN4EnumDeclaration();
			case N4JSPackage.N4_ENUM_LITERAL: return createN4EnumLiteral();
			case N4JSPackage.N4_MEMBER_ANNOTATION_LIST: return createN4MemberAnnotationList();
			case N4JSPackage.N4_FIELD_DECLARATION: return createN4FieldDeclaration();
			case N4JSPackage.N4_METHOD_DECLARATION: return createN4MethodDeclaration();
			case N4JSPackage.N4_GETTER_DECLARATION: return createN4GetterDeclaration();
			case N4JSPackage.N4_SETTER_DECLARATION: return createN4SetterDeclaration();
			case N4JSPackage.OBJECT_BINDING_PATTERN: return createObjectBindingPattern();
			case N4JSPackage.ARRAY_BINDING_PATTERN: return createArrayBindingPattern();
			case N4JSPackage.BINDING_PROPERTY: return createBindingProperty();
			case N4JSPackage.BINDING_ELEMENT: return createBindingElement();
			case N4JSPackage.JSX_ELEMENT_NAME: return createJSXElementName();
			case N4JSPackage.JSX_TEXT: return createJSXText();
			case N4JSPackage.JSX_EXPRESSION: return createJSXExpression();
			case N4JSPackage.JSX_PROPERTY_ATTRIBUTE: return createJSXPropertyAttribute();
			case N4JSPackage.JSX_SPREAD_ATTRIBUTE: return createJSXSpreadAttribute();
			case N4JSPackage.JSX_ELEMENT: return createJSXElement();
			case N4JSPackage.N4IDL_CLASS_DECLARATION: return createN4IDLClassDeclaration();
			case N4JSPackage.N4IDL_INTERFACE_DECLARATION: return createN4IDLInterfaceDeclaration();
			case N4JSPackage.N4IDL_ENUM_DECLARATION: return createN4IDLEnumDeclaration();
			case N4JSPackage.MIGRATION_DECLARATION: return createMigrationDeclaration();
			case N4JSPackage.VERSIONED_IDENTIFIER_REF: return createVersionedIdentifierRef();
			case N4JSPackage.VERSIONED_NAMED_IMPORT_SPECIFIER: return createVersionedNamedImportSpecifier();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case N4JSPackage.VARIABLE_STATEMENT_KEYWORD:
				return createVariableStatementKeywordFromString(eDataType, initialValue);
			case N4JSPackage.PROPERTY_NAME_KIND:
				return createPropertyNameKindFromString(eDataType, initialValue);
			case N4JSPackage.POSTFIX_OPERATOR:
				return createPostfixOperatorFromString(eDataType, initialValue);
			case N4JSPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
			case N4JSPackage.MULTIPLICATIVE_OPERATOR:
				return createMultiplicativeOperatorFromString(eDataType, initialValue);
			case N4JSPackage.ADDITIVE_OPERATOR:
				return createAdditiveOperatorFromString(eDataType, initialValue);
			case N4JSPackage.RELATIONAL_OPERATOR:
				return createRelationalOperatorFromString(eDataType, initialValue);
			case N4JSPackage.EQUALITY_OPERATOR:
				return createEqualityOperatorFromString(eDataType, initialValue);
			case N4JSPackage.BINARY_BITWISE_OPERATOR:
				return createBinaryBitwiseOperatorFromString(eDataType, initialValue);
			case N4JSPackage.BINARY_LOGICAL_OPERATOR:
				return createBinaryLogicalOperatorFromString(eDataType, initialValue);
			case N4JSPackage.SHIFT_OPERATOR:
				return createShiftOperatorFromString(eDataType, initialValue);
			case N4JSPackage.ASSIGNMENT_OPERATOR:
				return createAssignmentOperatorFromString(eDataType, initialValue);
			case N4JSPackage.N4_MODIFIER:
				return createN4ModifierFromString(eDataType, initialValue);
			case N4JSPackage.ITERATOR_OF_EXPRESSION:
				return createIteratorOfExpressionFromString(eDataType, initialValue);
			case N4JSPackage.ITERATOR_OF_YIELD_EXPRESSION:
				return createIteratorOfYieldExpressionFromString(eDataType, initialValue);
			case N4JSPackage.ITERATOR_OF_STATEMENT:
				return createIteratorOfStatementFromString(eDataType, initialValue);
			case N4JSPackage.ITERATOR_OF_RETURN_STATEMENT:
				return createIteratorOfReturnStatementFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case N4JSPackage.VARIABLE_STATEMENT_KEYWORD:
				return convertVariableStatementKeywordToString(eDataType, instanceValue);
			case N4JSPackage.PROPERTY_NAME_KIND:
				return convertPropertyNameKindToString(eDataType, instanceValue);
			case N4JSPackage.POSTFIX_OPERATOR:
				return convertPostfixOperatorToString(eDataType, instanceValue);
			case N4JSPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			case N4JSPackage.MULTIPLICATIVE_OPERATOR:
				return convertMultiplicativeOperatorToString(eDataType, instanceValue);
			case N4JSPackage.ADDITIVE_OPERATOR:
				return convertAdditiveOperatorToString(eDataType, instanceValue);
			case N4JSPackage.RELATIONAL_OPERATOR:
				return convertRelationalOperatorToString(eDataType, instanceValue);
			case N4JSPackage.EQUALITY_OPERATOR:
				return convertEqualityOperatorToString(eDataType, instanceValue);
			case N4JSPackage.BINARY_BITWISE_OPERATOR:
				return convertBinaryBitwiseOperatorToString(eDataType, instanceValue);
			case N4JSPackage.BINARY_LOGICAL_OPERATOR:
				return convertBinaryLogicalOperatorToString(eDataType, instanceValue);
			case N4JSPackage.SHIFT_OPERATOR:
				return convertShiftOperatorToString(eDataType, instanceValue);
			case N4JSPackage.ASSIGNMENT_OPERATOR:
				return convertAssignmentOperatorToString(eDataType, instanceValue);
			case N4JSPackage.N4_MODIFIER:
				return convertN4ModifierToString(eDataType, instanceValue);
			case N4JSPackage.ITERATOR_OF_EXPRESSION:
				return convertIteratorOfExpressionToString(eDataType, instanceValue);
			case N4JSPackage.ITERATOR_OF_YIELD_EXPRESSION:
				return convertIteratorOfYieldExpressionToString(eDataType, instanceValue);
			case N4JSPackage.ITERATOR_OF_STATEMENT:
				return convertIteratorOfStatementToString(eDataType, instanceValue);
			case N4JSPackage.ITERATOR_OF_RETURN_STATEMENT:
				return convertIteratorOfReturnStatementToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script createScript() {
		ScriptImpl script = new ScriptImpl();
		return script;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportDeclaration createExportDeclaration() {
		ExportDeclarationImpl exportDeclaration = new ExportDeclarationImpl();
		return exportDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportSpecifier createExportSpecifier() {
		ExportSpecifierImpl exportSpecifier = new ExportSpecifierImpl();
		return exportSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportDeclaration createImportDeclaration() {
		ImportDeclarationImpl importDeclaration = new ImportDeclarationImpl();
		return importDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedImportSpecifier createNamedImportSpecifier() {
		NamedImportSpecifierImpl namedImportSpecifier = new NamedImportSpecifierImpl();
		return namedImportSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultImportSpecifier createDefaultImportSpecifier() {
		DefaultImportSpecifierImpl defaultImportSpecifier = new DefaultImportSpecifierImpl();
		return defaultImportSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespaceImportSpecifier createNamespaceImportSpecifier() {
		NamespaceImportSpecifierImpl namespaceImportSpecifier = new NamespaceImportSpecifierImpl();
		return namespaceImportSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationList createAnnotationList() {
		AnnotationListImpl annotationList = new AnnotationListImpl();
		return annotationList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAnnotationList createExpressionAnnotationList() {
		ExpressionAnnotationListImpl expressionAnnotationList = new ExpressionAnnotationListImpl();
		return expressionAnnotationList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralAnnotationArgument createLiteralAnnotationArgument() {
		LiteralAnnotationArgumentImpl literalAnnotationArgument = new LiteralAnnotationArgumentImpl();
		return literalAnnotationArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRefAnnotationArgument createTypeRefAnnotationArgument() {
		TypeRefAnnotationArgumentImpl typeRefAnnotationArgument = new TypeRefAnnotationArgumentImpl();
		return typeRefAnnotationArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration createFunctionDeclaration() {
		FunctionDeclarationImpl functionDeclaration = new FunctionDeclarationImpl();
		return functionDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionExpression createFunctionExpression() {
		FunctionExpressionImpl functionExpression = new FunctionExpressionImpl();
		return functionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowFunction createArrowFunction() {
		ArrowFunctionImpl arrowFunction = new ArrowFunctionImpl();
		return arrowFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalArgumentsVariable createLocalArgumentsVariable() {
		LocalArgumentsVariableImpl localArgumentsVariable = new LocalArgumentsVariableImpl();
		return localArgumentsVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameter createFormalParameter() {
		FormalParameterImpl formalParameter = new FormalParameterImpl();
		return formalParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement createStatement() {
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableStatement createVariableStatement() {
		VariableStatementImpl variableStatement = new VariableStatementImpl();
		return variableStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedVariableStatement createExportedVariableStatement() {
		ExportedVariableStatementImpl exportedVariableStatement = new ExportedVariableStatementImpl();
		return exportedVariableStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableBinding createVariableBinding() {
		VariableBindingImpl variableBinding = new VariableBindingImpl();
		return variableBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedVariableBinding createExportedVariableBinding() {
		ExportedVariableBindingImpl exportedVariableBinding = new ExportedVariableBindingImpl();
		return exportedVariableBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedVariableDeclaration createExportedVariableDeclaration() {
		ExportedVariableDeclarationImpl exportedVariableDeclaration = new ExportedVariableDeclarationImpl();
		return exportedVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyStatement createEmptyStatement() {
		EmptyStatementImpl emptyStatement = new EmptyStatementImpl();
		return emptyStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationStatement createIterationStatement() {
		IterationStatementImpl iterationStatement = new IterationStatementImpl();
		return iterationStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoStatement createDoStatement() {
		DoStatementImpl doStatement = new DoStatementImpl();
		return doStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinueStatement createContinueStatement() {
		ContinueStatementImpl continueStatement = new ContinueStatementImpl();
		return continueStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakStatement createBreakStatement() {
		BreakStatementImpl breakStatement = new BreakStatementImpl();
		return breakStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnStatement createReturnStatement() {
		ReturnStatementImpl returnStatement = new ReturnStatementImpl();
		return returnStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WithStatement createWithStatement() {
		WithStatementImpl withStatement = new WithStatementImpl();
		return withStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchStatement createSwitchStatement() {
		SwitchStatementImpl switchStatement = new SwitchStatementImpl();
		return switchStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseClause createCaseClause() {
		CaseClauseImpl caseClause = new CaseClauseImpl();
		return caseClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultClause createDefaultClause() {
		DefaultClauseImpl defaultClause = new DefaultClauseImpl();
		return defaultClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelledStatement createLabelledStatement() {
		LabelledStatementImpl labelledStatement = new LabelledStatementImpl();
		return labelledStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrowStatement createThrowStatement() {
		ThrowStatementImpl throwStatement = new ThrowStatementImpl();
		return throwStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TryStatement createTryStatement() {
		TryStatementImpl tryStatement = new TryStatementImpl();
		return tryStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatchBlock createCatchBlock() {
		CatchBlockImpl catchBlock = new CatchBlockImpl();
		return catchBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatchVariable createCatchVariable() {
		CatchVariableImpl catchVariable = new CatchVariableImpl();
		return catchVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinallyBlock createFinallyBlock() {
		FinallyBlockImpl finallyBlock = new FinallyBlockImpl();
		return finallyBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebuggerStatement createDebuggerStatement() {
		DebuggerStatementImpl debuggerStatement = new DebuggerStatementImpl();
		return debuggerStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryExpression createPrimaryExpression() {
		PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
		return primaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParenExpression createParenExpression() {
		ParenExpressionImpl parenExpression = new ParenExpressionImpl();
		return parenExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierRef createIdentifierRef() {
		IdentifierRefImpl identifierRef = new IdentifierRefImpl();
		return identifierRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperLiteral createSuperLiteral() {
		SuperLiteralImpl superLiteral = new SuperLiteralImpl();
		return superLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisLiteral createThisLiteral() {
		ThisLiteralImpl thisLiteral = new ThisLiteralImpl();
		return thisLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayLiteral createArrayLiteral() {
		ArrayLiteralImpl arrayLiteral = new ArrayLiteralImpl();
		return arrayLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayElement createArrayElement() {
		ArrayElementImpl arrayElement = new ArrayElementImpl();
		return arrayElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayPadding createArrayPadding() {
		ArrayPaddingImpl arrayPadding = new ArrayPaddingImpl();
		return arrayPadding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectLiteral createObjectLiteral() {
		ObjectLiteralImpl objectLiteral = new ObjectLiteralImpl();
		return objectLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralOrComputedPropertyName createLiteralOrComputedPropertyName() {
		LiteralOrComputedPropertyNameImpl literalOrComputedPropertyName = new LiteralOrComputedPropertyNameImpl();
		return literalOrComputedPropertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAssignmentAnnotationList createPropertyAssignmentAnnotationList() {
		PropertyAssignmentAnnotationListImpl propertyAssignmentAnnotationList = new PropertyAssignmentAnnotationListImpl();
		return propertyAssignmentAnnotationList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyNameValuePair createPropertyNameValuePair() {
		PropertyNameValuePairImpl propertyNameValuePair = new PropertyNameValuePairImpl();
		return propertyNameValuePair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyNameValuePairSingleName createPropertyNameValuePairSingleName() {
		PropertyNameValuePairSingleNameImpl propertyNameValuePairSingleName = new PropertyNameValuePairSingleNameImpl();
		return propertyNameValuePairSingleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyMethodDeclaration createPropertyMethodDeclaration() {
		PropertyMethodDeclarationImpl propertyMethodDeclaration = new PropertyMethodDeclarationImpl();
		return propertyMethodDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyGetterDeclaration createPropertyGetterDeclaration() {
		PropertyGetterDeclarationImpl propertyGetterDeclaration = new PropertyGetterDeclarationImpl();
		return propertyGetterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySetterDeclaration createPropertySetterDeclaration() {
		PropertySetterDeclarationImpl propertySetterDeclaration = new PropertySetterDeclarationImpl();
		return propertySetterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewTarget createNewTarget() {
		NewTargetImpl newTarget = new NewTargetImpl();
		return newTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewExpression createNewExpression() {
		NewExpressionImpl newExpression = new NewExpressionImpl();
		return newExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedCallExpression createParameterizedCallExpression() {
		ParameterizedCallExpressionImpl parameterizedCallExpression = new ParameterizedCallExpressionImpl();
		return parameterizedCallExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Argument createArgument() {
		ArgumentImpl argument = new ArgumentImpl();
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexedAccessExpression createIndexedAccessExpression() {
		IndexedAccessExpressionImpl indexedAccessExpression = new IndexedAccessExpressionImpl();
		return indexedAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaggedTemplateString createTaggedTemplateString() {
		TaggedTemplateStringImpl taggedTemplateString = new TaggedTemplateStringImpl();
		return taggedTemplateString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedPropertyAccessExpression createParameterizedPropertyAccessExpression() {
		ParameterizedPropertyAccessExpressionImpl parameterizedPropertyAccessExpression = new ParameterizedPropertyAccessExpressionImpl();
		return parameterizedPropertyAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AwaitExpression createAwaitExpression() {
		AwaitExpressionImpl awaitExpression = new AwaitExpressionImpl();
		return awaitExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromisifyExpression createPromisifyExpression() {
		PromisifyExpressionImpl promisifyExpression = new PromisifyExpressionImpl();
		return promisifyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YieldExpression createYieldExpression() {
		YieldExpressionImpl yieldExpression = new YieldExpressionImpl();
		return yieldExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullLiteral createNullLiteral() {
		NullLiteralImpl nullLiteral = new NullLiteralImpl();
		return nullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateLiteral createTemplateLiteral() {
		TemplateLiteralImpl templateLiteral = new TemplateLiteralImpl();
		return templateLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSegment createTemplateSegment() {
		TemplateSegmentImpl templateSegment = new TemplateSegmentImpl();
		return templateSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericLiteral createNumericLiteral() {
		NumericLiteralImpl numericLiteral = new NumericLiteralImpl();
		return numericLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleLiteral createDoubleLiteral() {
		DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
		return doubleLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractIntLiteral createAbstractIntLiteral() {
		AbstractIntLiteralImpl abstractIntLiteral = new AbstractIntLiteralImpl();
		return abstractIntLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntLiteral createIntLiteral() {
		IntLiteralImpl intLiteral = new IntLiteralImpl();
		return intLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryIntLiteral createBinaryIntLiteral() {
		BinaryIntLiteralImpl binaryIntLiteral = new BinaryIntLiteralImpl();
		return binaryIntLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OctalIntLiteral createOctalIntLiteral() {
		OctalIntLiteralImpl octalIntLiteral = new OctalIntLiteralImpl();
		return octalIntLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LegacyOctalIntLiteral createLegacyOctalIntLiteral() {
		LegacyOctalIntLiteralImpl legacyOctalIntLiteral = new LegacyOctalIntLiteralImpl();
		return legacyOctalIntLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HexIntLiteral createHexIntLiteral() {
		HexIntLiteralImpl hexIntLiteral = new HexIntLiteralImpl();
		return hexIntLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificIntLiteral createScientificIntLiteral() {
		ScientificIntLiteralImpl scientificIntLiteral = new ScientificIntLiteralImpl();
		return scientificIntLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegularExpressionLiteral createRegularExpressionLiteral() {
		RegularExpressionLiteralImpl regularExpressionLiteral = new RegularExpressionLiteralImpl();
		return regularExpressionLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpression createPostfixExpression() {
		PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
		return postfixExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CastExpression createCastExpression() {
		CastExpressionImpl castExpression = new CastExpressionImpl();
		return castExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeExpression createMultiplicativeExpression() {
		MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
		return multiplicativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveExpression createAdditiveExpression() {
		AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
		return additiveExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShiftExpression createShiftExpression() {
		ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
		return shiftExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExpression createRelationalExpression() {
		RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
		return relationalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityExpression createEqualityExpression() {
		EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
		return equalityExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryBitwiseExpression createBinaryBitwiseExpression() {
		BinaryBitwiseExpressionImpl binaryBitwiseExpression = new BinaryBitwiseExpressionImpl();
		return binaryBitwiseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryLogicalExpression createBinaryLogicalExpression() {
		BinaryLogicalExpressionImpl binaryLogicalExpression = new BinaryLogicalExpressionImpl();
		return binaryLogicalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalExpression createConditionalExpression() {
		ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
		return conditionalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentExpression createAssignmentExpression() {
		AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
		return assignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommaExpression createCommaExpression() {
		CommaExpressionImpl commaExpression = new CommaExpressionImpl();
		return commaExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4ClassDeclaration createN4ClassDeclaration() {
		N4ClassDeclarationImpl n4ClassDeclaration = new N4ClassDeclarationImpl();
		return n4ClassDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4ClassExpression createN4ClassExpression() {
		N4ClassExpressionImpl n4ClassExpression = new N4ClassExpressionImpl();
		return n4ClassExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4InterfaceDeclaration createN4InterfaceDeclaration() {
		N4InterfaceDeclarationImpl n4InterfaceDeclaration = new N4InterfaceDeclarationImpl();
		return n4InterfaceDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4EnumDeclaration createN4EnumDeclaration() {
		N4EnumDeclarationImpl n4EnumDeclaration = new N4EnumDeclarationImpl();
		return n4EnumDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4EnumLiteral createN4EnumLiteral() {
		N4EnumLiteralImpl n4EnumLiteral = new N4EnumLiteralImpl();
		return n4EnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4MemberAnnotationList createN4MemberAnnotationList() {
		N4MemberAnnotationListImpl n4MemberAnnotationList = new N4MemberAnnotationListImpl();
		return n4MemberAnnotationList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4FieldDeclaration createN4FieldDeclaration() {
		N4FieldDeclarationImpl n4FieldDeclaration = new N4FieldDeclarationImpl();
		return n4FieldDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4MethodDeclaration createN4MethodDeclaration() {
		N4MethodDeclarationImpl n4MethodDeclaration = new N4MethodDeclarationImpl();
		return n4MethodDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4GetterDeclaration createN4GetterDeclaration() {
		N4GetterDeclarationImpl n4GetterDeclaration = new N4GetterDeclarationImpl();
		return n4GetterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4SetterDeclaration createN4SetterDeclaration() {
		N4SetterDeclarationImpl n4SetterDeclaration = new N4SetterDeclarationImpl();
		return n4SetterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectBindingPattern createObjectBindingPattern() {
		ObjectBindingPatternImpl objectBindingPattern = new ObjectBindingPatternImpl();
		return objectBindingPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayBindingPattern createArrayBindingPattern() {
		ArrayBindingPatternImpl arrayBindingPattern = new ArrayBindingPatternImpl();
		return arrayBindingPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingProperty createBindingProperty() {
		BindingPropertyImpl bindingProperty = new BindingPropertyImpl();
		return bindingProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingElement createBindingElement() {
		BindingElementImpl bindingElement = new BindingElementImpl();
		return bindingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXElementName createJSXElementName() {
		JSXElementNameImpl jsxElementName = new JSXElementNameImpl();
		return jsxElementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXText createJSXText() {
		JSXTextImpl jsxText = new JSXTextImpl();
		return jsxText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXExpression createJSXExpression() {
		JSXExpressionImpl jsxExpression = new JSXExpressionImpl();
		return jsxExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXPropertyAttribute createJSXPropertyAttribute() {
		JSXPropertyAttributeImpl jsxPropertyAttribute = new JSXPropertyAttributeImpl();
		return jsxPropertyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXSpreadAttribute createJSXSpreadAttribute() {
		JSXSpreadAttributeImpl jsxSpreadAttribute = new JSXSpreadAttributeImpl();
		return jsxSpreadAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXElement createJSXElement() {
		JSXElementImpl jsxElement = new JSXElementImpl();
		return jsxElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4IDLClassDeclaration createN4IDLClassDeclaration() {
		N4IDLClassDeclarationImpl n4IDLClassDeclaration = new N4IDLClassDeclarationImpl();
		return n4IDLClassDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4IDLInterfaceDeclaration createN4IDLInterfaceDeclaration() {
		N4IDLInterfaceDeclarationImpl n4IDLInterfaceDeclaration = new N4IDLInterfaceDeclarationImpl();
		return n4IDLInterfaceDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4IDLEnumDeclaration createN4IDLEnumDeclaration() {
		N4IDLEnumDeclarationImpl n4IDLEnumDeclaration = new N4IDLEnumDeclarationImpl();
		return n4IDLEnumDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationDeclaration createMigrationDeclaration() {
		MigrationDeclarationImpl migrationDeclaration = new MigrationDeclarationImpl();
		return migrationDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionedIdentifierRef createVersionedIdentifierRef() {
		VersionedIdentifierRefImpl versionedIdentifierRef = new VersionedIdentifierRefImpl();
		return versionedIdentifierRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionedNamedImportSpecifier createVersionedNamedImportSpecifier() {
		VersionedNamedImportSpecifierImpl versionedNamedImportSpecifier = new VersionedNamedImportSpecifierImpl();
		return versionedNamedImportSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableStatementKeyword createVariableStatementKeywordFromString(EDataType eDataType, String initialValue) {
		VariableStatementKeyword result = VariableStatementKeyword.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableStatementKeywordToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyNameKind createPropertyNameKindFromString(EDataType eDataType, String initialValue) {
		PropertyNameKind result = PropertyNameKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyNameKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixOperator createPostfixOperatorFromString(EDataType eDataType, String initialValue) {
		PostfixOperator result = PostfixOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPostfixOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryOperator result = UnaryOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue) {
		MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue) {
		AdditiveOperator result = AdditiveOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue) {
		RelationalOperator result = RelationalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue) {
		EqualityOperator result = EqualityOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryBitwiseOperator createBinaryBitwiseOperatorFromString(EDataType eDataType, String initialValue) {
		BinaryBitwiseOperator result = BinaryBitwiseOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryBitwiseOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryLogicalOperator createBinaryLogicalOperatorFromString(EDataType eDataType, String initialValue) {
		BinaryLogicalOperator result = BinaryLogicalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryLogicalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShiftOperator createShiftOperatorFromString(EDataType eDataType, String initialValue) {
		ShiftOperator result = ShiftOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShiftOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue) {
		AssignmentOperator result = AssignmentOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4Modifier createN4ModifierFromString(EDataType eDataType, String initialValue) {
		N4Modifier result = N4Modifier.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertN4ModifierToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Iterator<Expression> createIteratorOfExpressionFromString(EDataType eDataType, String initialValue) {
		return (Iterator<Expression>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIteratorOfExpressionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Iterator<YieldExpression> createIteratorOfYieldExpressionFromString(EDataType eDataType, String initialValue) {
		return (Iterator<YieldExpression>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIteratorOfYieldExpressionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Iterator<Statement> createIteratorOfStatementFromString(EDataType eDataType, String initialValue) {
		return (Iterator<Statement>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIteratorOfStatementToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Iterator<ReturnStatement> createIteratorOfReturnStatementFromString(EDataType eDataType, String initialValue) {
		return (Iterator<ReturnStatement>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIteratorOfReturnStatementToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public N4JSPackage getN4JSPackage() {
		return (N4JSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static N4JSPackage getPackage() {
		return N4JSPackage.eINSTANCE;
	}

} //N4JSFactoryImpl
