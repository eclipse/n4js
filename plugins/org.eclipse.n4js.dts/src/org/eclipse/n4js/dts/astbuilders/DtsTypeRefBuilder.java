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

import static org.eclipse.n4js.dts.TypeScriptParser.RULE_arrayTypeExpression;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_conditionalTypeRef;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_intersectionTypeExpression;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_literalType;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_operatorTypeRef;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_primaryTypeExpression;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_typeOperator;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_typeRef;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_typeRefWithModifiers;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_unionTypeExpression;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.n4js.dts.TypeScriptParser.ArrayTypeExpressionContext;
import org.eclipse.n4js.dts.TypeScriptParser.ArrayTypeExpressionSuffixContext;
import org.eclipse.n4js.dts.TypeScriptParser.ArrowFunctionTypeExpressionContext;
import org.eclipse.n4js.dts.TypeScriptParser.ColonSepTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.ConditionalTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.ImportTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.InferTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.IntersectionTypeExpressionContext;
import org.eclipse.n4js.dts.TypeScriptParser.LiteralTypeContext;
import org.eclipse.n4js.dts.TypeScriptParser.NumericLiteralContext;
import org.eclipse.n4js.dts.TypeScriptParser.ObjectLiteralTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.OperatorTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.ParameterizedTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.ParenthesizedTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.QueryTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.ThisTypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.TupleTypeArgumentContext;
import org.eclipse.n4js.dts.TypeScriptParser.TupleTypeExpressionContext;
import org.eclipse.n4js.dts.TypeScriptParser.TypeArgumentContext;
import org.eclipse.n4js.dts.TypeScriptParser.TypeArgumentsContext;
import org.eclipse.n4js.dts.TypeScriptParser.TypeRefContext;
import org.eclipse.n4js.dts.TypeScriptParser.UnionTypeExpressionContext;
import org.eclipse.n4js.dts.utils.ParserContextUtils;
import org.eclipse.n4js.n4JS.TypeReferenceNode;
import org.eclipse.n4js.ts.typeRefs.BooleanLiteralTypeRef;
import org.eclipse.n4js.ts.typeRefs.FunctionTypeExpression;
import org.eclipse.n4js.ts.typeRefs.IntersectionTypeExpression;
import org.eclipse.n4js.ts.typeRefs.NamespaceLikeRef;
import org.eclipse.n4js.ts.typeRefs.NumericLiteralTypeRef;
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef;
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRefStructural;
import org.eclipse.n4js.ts.typeRefs.StringLiteralTypeRef;
import org.eclipse.n4js.ts.typeRefs.ThisTypeRefNominal;
import org.eclipse.n4js.ts.typeRefs.TypeRef;
import org.eclipse.n4js.ts.typeRefs.TypeRefsFactory;
import org.eclipse.n4js.ts.typeRefs.TypeRefsPackage;
import org.eclipse.n4js.ts.typeRefs.UnionTypeExpression;
import org.eclipse.n4js.ts.types.TStructMember;
import org.eclipse.n4js.ts.types.Type;
import org.eclipse.n4js.ts.types.TypesFactory;

/**
 * Builder to create {@link TypeReferenceNode} from parse tree elements
 */
public class DtsTypeRefBuilder extends AbstractDtsBuilderWithHelpers<TypeRefContext, TypeRef> {
	final boolean handleReturnTypeRef;
	private boolean returnTypeRefWasOptional = false;

	/** Constructor */
	public DtsTypeRefBuilder(AbstractDtsBuilder<?, ?> parent) {
		this(parent, false);
	}

	/** Constructor */
	public DtsTypeRefBuilder(AbstractDtsBuilder<?, ?> parent, boolean handleReturnTypeRef) {
		super(parent);
		this.handleReturnTypeRef = handleReturnTypeRef;
	}

	/** Returns true iff the resulting type reference is an optional return type ref */
	protected boolean returnTypeRefWasOptional() {
		return returnTypeRefWasOptional;
	}

	@Override
	protected Set<Integer> getVisitChildrenOfRules() {
		return java.util.Set.of(
				RULE_typeRef,
				RULE_conditionalTypeRef,
				RULE_unionTypeExpression,
				RULE_intersectionTypeExpression,
				RULE_operatorTypeRef,
				RULE_typeOperator,
				RULE_arrayTypeExpression,
				RULE_primaryTypeExpression,
				RULE_literalType,
				RULE_typeRefWithModifiers);
	}

	/** Convenience method for consuming 0..* {@link TypeRefContext}s in one go. */
	public List<TypeRef> consumeManyTypeRefs(Iterable<TypeRefContext> ctxs) {
		@SuppressWarnings("hiding")
		List<TypeRef> result = new ArrayList<>();
		if (ctxs != null) {
			for (TypeRefContext typeRefCtx : ctxs) {
				TypeRef typeRef = doConsume(typeRefCtx);
				if (typeRef != null) {
					result.add(typeRef);
				}
			}
		}
		return result;
	}

	/** Convenience method for consuming 0..* {@link TypeArgumentContext}s in one go. */
	public List<TypeRef> consumeManyTypeArgs(Iterable<TypeArgumentContext> typeArgCtxs) {
		@SuppressWarnings("hiding")
		List<TypeRef> result = new ArrayList<>();
		if (typeArgCtxs != null) {
			for (TypeArgumentContext typeArgCtx : typeArgCtxs) {
				TypeRef typeArg = doConsume(typeArgCtx.typeRef());
				if (typeArg != null) {
					result.add(typeArg);
				}
			}
		}
		return result;
	}

	/** Convenience method for consuming 0..* {@link TupleTypeArgumentContext}s in one go. */
	public List<TypeRef> consumeManyTupleTypeArgs(Iterable<TupleTypeArgumentContext> typeArgCtxs) {
		@SuppressWarnings("hiding")
		List<TypeRef> result = new ArrayList<>();
		if (typeArgCtxs != null) {
			for (TupleTypeArgumentContext typeArgCtx : typeArgCtxs) {
				TypeRef typeArg = doConsume(typeArgCtx.typeRef());
				if (typeArg != null) {
					result.add(typeArg);
				}
			}
		}
		return result;
	}

	/** @return a {@link TypeRef} from the given context. Consumes the given context and all its children. */
	public TypeRef consume(ColonSepTypeRefContext ctx) {
		if (ctx == null) {
			return null;
		}
		return consume(ctx.typeRef());
	}

	/**
	 * @return a {@link TypeRef} from the given context. Consumes the given context and all its children. Will not
	 *         always return a {@link UnionTypeExpression}!
	 */
	public TypeRef consume(UnionTypeExpressionContext ctx) {
		return doConsume(ctx);
	}

	/**
	 * @return a {@link TypeRef} from the given context. Consumes the given context and all its children. Will not
	 *         always return an {@link IntersectionTypeExpression}!
	 */
	public TypeRef consume(IntersectionTypeExpressionContext ctx) {
		return doConsume(ctx);
	}

	/** @return a {@link TypeRef} from the given context. Consumes the given context and all its children. */
	public TypeRef consume(OperatorTypeRefContext ctx) {
		return doConsume(ctx);
	}

	/** @return a wrapped {@link ParameterizedTypeRef}, created from the given context. */
	public ParameterizedTypeRef consume(ParameterizedTypeRefContext ctx) {
		return (ParameterizedTypeRef) doConsume(ctx);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		super.exitEveryRule(ctx);
		addLocationInfo(result, ctx);
	}

	@Override
	public void exitConditionalTypeRef(ConditionalTypeRefContext ctx) {
		// TODO conditional type references in .d.ts
	}

	@Override
	public void exitUnionTypeExpression(UnionTypeExpressionContext ctx) {
		if (result != null && ctx.intersectionTypeExpression().size() > 1) {
			boolean returnTypeRefIsOptional = false;
			List<TypeRef> typeRefs = new ArrayList<>();
			for (IntersectionTypeExpressionContext childCtx : ctx.intersectionTypeExpression()) {
				DtsTypeRefBuilder subTypeRefBuilder = newTypeRefBuilder(handleReturnTypeRef);
				TypeRef childTypeRef = subTypeRefBuilder.consume(childCtx);
				if (childTypeRef != null) {
					typeRefs.add(childTypeRef);
				} else {
					returnTypeRefIsOptional |= subTypeRefBuilder.returnTypeRefWasOptional();
				}
			}

			if (typeRefs.size() == 0 && returnTypeRefIsOptional) {
				DtsTypeRefBuilder subTypeRefBuilder = newTypeRefBuilder(handleReturnTypeRef);
				typeRefs.add(subTypeRefBuilder.createParameterizedTypeRef("void", false));
				returnTypeRefIsOptional = false;
			}

			if (typeRefs.size() == 1) {
				result = typeRefs.get(0);
			} else if (typeRefs.size() >= 2) {
				UnionTypeExpression ute = TypeRefsFactory.eINSTANCE.createUnionTypeExpression();
				ute.getTypeRefs().addAll(typeRefs);
				result = ute;
			}
			result.setFollowedByQuestionMark(returnTypeRefIsOptional);
		}
	}

	@Override
	public void exitIntersectionTypeExpression(IntersectionTypeExpressionContext ctx) {
		if (result != null && ctx.operatorTypeRef().size() > 1) {
			List<TypeRef> typeRefs = new ArrayList<>();
			for (OperatorTypeRefContext childCtx : ctx.operatorTypeRef()) {
				TypeRef childTypeRef = newTypeRefBuilder(handleReturnTypeRef).consume(childCtx);
				if (childTypeRef != null) {
					typeRefs.add(childTypeRef);
				}
			}

			if (typeRefs.size() == 1) {
				result = typeRefs.get(0);
			} else if (typeRefs.size() >= 2) {
				IntersectionTypeExpression ite = TypeRefsFactory.eINSTANCE.createIntersectionTypeExpression();
				ite.getTypeRefs().addAll(typeRefs);
				result = ite;
			}
		}
	}

	@Override
	public void exitOperatorTypeRef(OperatorTypeRefContext ctx) {
		// TODO operator type references in .d.ts
	}

	@Override
	public void exitArrayTypeExpression(ArrayTypeExpressionContext ctx) {
		if (result != null) {
			for (ArrayTypeExpressionSuffixContext suffixCtx : ctx.arrayTypeExpressionSuffix()) {
				if (suffixCtx.typeRef() != null) {
					// special case: index access type
					// TODO index access type references in .d.ts
					result = createAnyPlusTypeRef();
				} else {
					// standard case: array type expression
					result = createParameterizedTypeRef("Array", Collections.singletonList(result), false);
				}
			}
		}
	}

	@Override
	public void enterLiteralType(LiteralTypeContext ctx) {
		if (ctx.BooleanLiteral() != null) {
			BooleanLiteralTypeRef tr = TypeRefsFactory.eINSTANCE.createBooleanLiteralTypeRef();
			tr.setAstValue(ctx.BooleanLiteral().getText().toLowerCase());
			result = tr;
		} else if (ctx.numericLiteral() != null) {
			NumericLiteralTypeRef tr = TypeRefsFactory.eINSTANCE.createNumericLiteralTypeRef();
			NumericLiteralContext numLitCtx = ctx.numericLiteral();
			tr.setAstNegated(numLitCtx.Minus() != null);
			BigDecimal value = ParserContextUtils.parseNumericLiteral(numLitCtx, true);
			if (value == null) {
				return;
			}
			tr.setAstValue(value);
			result = tr;
		} else if (ctx.StringLiteral() != null) {
			StringLiteralTypeRef tr = TypeRefsFactory.eINSTANCE.createStringLiteralTypeRef();
			tr.setAstValue(ParserContextUtils.trimAndUnescapeStringLiteral(ctx.StringLiteral()));
			result = tr;
		}
	}

	@Override
	public void enterArrowFunctionTypeExpression(ArrowFunctionTypeExpressionContext ctx) {
		if (ctx.parameterBlock() == null) {
			return;
		}
		FunctionTypeExpression fte = TypeRefsFactory.eINSTANCE.createFunctionTypeExpression();
		fte.getTypeVars().addAll(newTypeVariablesBuilder().consume(ctx.typeParameters()));
		fte.getFpars().addAll(newTFormalParametersBuilder().consumeWithDeclThisType(ctx.parameterBlock(), fte));
		if (ctx.unionTypeExpression() != null) {
			DtsTypeRefBuilder returnTypeRefBuilder = newTypeRefBuilderHandleReturnTypeRef();
			fte.setReturnTypeRef(orAnyPlus(returnTypeRefBuilder.consume(ctx.unionTypeExpression())));
			fte.setReturnValueMarkedOptional(returnTypeRefBuilder.returnTypeRefWasOptional());
		} else if (ctx.typePredicateWithOperatorTypeRef() != null) {
			fte.setReturnTypeRef(createBooleanTypeRef());
		}
		result = fte;
	}

	@Override
	public void enterTupleTypeExpression(TupleTypeExpressionContext ctx) {
		ParameterizedTypeRef ptr = TypeRefsFactory.eINSTANCE.createParameterizedTypeRef();
		ptr.setArrayNTypeExpression(true);
		if (!ctx.tupleTypeArgument().isEmpty()) {
			ptr.getDeclaredTypeArgs()
					.addAll(newTypeRefBuilder(handleReturnTypeRef).consumeManyTupleTypeArgs(ctx.tupleTypeArgument()));
		} else {
			ptr.getDeclaredTypeArgs().add(TypeRefsFactory.eINSTANCE.createWildcard());
		}
		result = ptr;
	}

	@Override
	public void enterQueryTypeRef(QueryTypeRefContext ctx) {
		result = createAnyPlusTypeRef();
	}

	@Override
	public void enterImportTypeRef(ImportTypeRefContext ctx) {
		result = createAnyPlusTypeRef();
	}

	@Override
	public void enterInferTypeRef(InferTypeRefContext ctx) {
		result = createAnyPlusTypeRef();
	}

	@Override
	public void enterParenthesizedTypeRef(ParenthesizedTypeRefContext ctx) {
		walker.enqueue(ctx.typeRef());
	}

	@Override
	public void enterThisTypeRef(ThisTypeRefContext ctx) {
		ThisTypeRefNominal ttr = TypeRefsFactory.eINSTANCE.createThisTypeRefNominal();
		result = ttr;
	}

	@Override
	public void enterParameterizedTypeRef(ParameterizedTypeRefContext ctx) {
		String declTypeName = ctx.typeName() != null ? ctx.typeName().getText() : null;
		TypeRef ptr = createParameterizedTypeRef(declTypeName, ctx.typeArguments(), false);
		result = ptr;
	}

	@Override
	public void enterObjectLiteralTypeRef(ObjectLiteralTypeRefContext ctx) {
		ParameterizedTypeRefStructural ptr = (ParameterizedTypeRefStructural) createParameterizedTypeRef("Object",
				(TypeArgumentsContext) null, true);

		List<TStructMember> members = newTStructBodyBuilder().consume(ctx.interfaceBody());
		ptr.getAstStructuralMembers().addAll(members);
		result = ptr;
	}

	private TypeRef createParameterizedTypeRef(String declTypeName, TypeArgumentsContext typeArgsCtx,
			boolean structural) {
		return createParameterizedTypeRef(declTypeName, ParserContextUtils.getTypeArgsFromTypeArgCtx(typeArgsCtx),
				structural);
	}

	/**
	 * @param declTypeName
	 *            name of the declared type; may contain '.' when accessing types in namespaces (of namespace imports or
	 *            namespace declarations).
	 */
	private TypeRef createParameterizedTypeRef(String declTypeName, Iterable<TypeArgumentContext> typeArgs,
			boolean structural) {

		if (declTypeName == null) {
			return null;
		}

		if (Set.of("null", "never", "unknown", "bigint", "BigInt").contains(declTypeName)) {
			return createAnyPlusTypeRef();
		}

		if ("void".equals(declTypeName)) {
			if (handleReturnTypeRef) {
				if (parent instanceof DtsTypeRefBuilder) {
					DtsTypeRefBuilder parentTRB = (DtsTypeRefBuilder) parent;
					if (parentTRB.handleReturnTypeRef) {
						// at this point we know that the current 'void' reference is part of a composed type in a
						// return type ref and will be omitted
						returnTypeRefWasOptional = true;
						return null;
					}
				}
			}
		}

		if ("Readonly".equals(declTypeName) && typeArgs.iterator().hasNext()) {
			// special case for Readonly
			return newTypeRefBuilder(handleReturnTypeRef).consume(typeArgs.iterator().next().typeRef());
		} else {
			ParameterizedTypeRef ptr = structural
					? TypeRefsFactory.eINSTANCE.createParameterizedTypeRefStructural()
					: TypeRefsFactory.eINSTANCE.createParameterizedTypeRef();

			String[] segs = declTypeName.split(Pattern.quote(ParserContextUtils.NAMESPACE_ACCESS_DELIMITER));
			for (int i = 0; i < segs.length - 1; i++) {
				String currSeg = segs[i];
				NamespaceLikeRef nslRef = TypeRefsFactory.eINSTANCE.createNamespaceLikeRef();
				nslRef.setDeclaredTypeAsText(currSeg);

				Type nsProxy = TypesFactory.eINSTANCE.createType();
				EReference eRef = TypeRefsPackage.eINSTANCE.getNamespaceLikeRef_DeclaredType();
				ParserContextUtils.installProxy(resource, nslRef, eRef, nsProxy, currSeg);
				nslRef.setDeclaredType(nsProxy);

				ptr.getAstNamespaceLikeRefs().add(nslRef);
			}
			String lastSeg = segs[segs.length - 1];
			ptr.setDeclaredTypeAsText(lastSeg);

			Type typeProxy = TypesFactory.eINSTANCE.createType();
			EReference eRef = TypeRefsPackage.eINSTANCE.getParameterizedTypeRef_DeclaredType();
			ParserContextUtils.installProxy(resource, ptr, eRef, typeProxy, lastSeg);
			ptr.setDeclaredType(typeProxy);

			ptr.getDeclaredTypeArgs().addAll(newTypeRefBuilder(handleReturnTypeRef).consumeManyTypeArgs(typeArgs));

			return ptr;
		}
	}

}
