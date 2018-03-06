/**
 * Copyright (c) 2018 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.n4idl

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.n4js.ts.scoping.builtin.BuiltInTypeScope
import org.eclipse.n4js.ts.typeRefs.IntersectionTypeExpression
import org.eclipse.n4js.ts.typeRefs.ParameterizedTypeRef
import org.eclipse.n4js.ts.typeRefs.TypeRef
import org.eclipse.n4js.ts.typeRefs.TypeTypeRef
import org.eclipse.n4js.ts.typeRefs.UnionTypeExpression
import org.eclipse.n4js.ts.types.TypingStrategy
import org.eclipse.n4js.ts.utils.TypeUtils
import org.eclipse.n4js.typesystem.RuleEnvironmentExtensions
import org.eclipse.xsemantics.runtime.RuleEnvironment

/**
 * The MigrationSwitchComputer can be used to compute a {@link SwitchCondition} which 
 * recognizes values of a given compile-time {@link TypeRef} at runtime (with limits).
 */
class MigrationSwitchComputer {
	
	/** 
	 * Computes a {@link SwitchCondition which detects the given {@link TypeRef} 
	 * at runtime (with limits).
	 * 
	 *  Currently the generated switch conditions support the following {@link TypeRef} features:
	 * - union and intersection types (such as (A#1|A#2))
	 * - parameterized array types (such as [A#1] or Array<A#1>)
	 * - plain non-parameterized types (such as A#1)
	 * 
	 * Also the nesting of all above-mentioned type refs is supported.
	 * 
	 * Furthermore, the following {@link TypeRef}s are ignored and therefore always evaluate to true
	 * in the generated switch condition:
	 * 
	 * - TypeTypeRef
	 * 
	 * All other possible {@link TypeRef}s will lead to an {@link IllegalArgumentException}.
	 */
	public def SwitchCondition compute(TypeRef ref) {
		switch(ref) {
			UnionTypeExpression: {
				return SwitchCondition.or(ref.typeRefs.map[this.compute(it)]);
			}
			IntersectionTypeExpression: {
				return SwitchCondition.and(ref.typeRefs.map[this.compute(it)]);
			}
			ParameterizedTypeRef case isParameterizedArrayTypeRef(ref): {
				val elementTypeRef = ref.typeArgs.get(0) as TypeRef;
				return SwitchCondition.arrayOf(compute(elementTypeRef));
			}
			ParameterizedTypeRef:
				return SwitchCondition.instanceOf(ref.declaredType)
			case isIgnoredTypeRef(ref): {
				return SwitchCondition.trueCondition;
			}
			default: {
				throw new IllegalArgumentException("Cannot handle (sub-)type ref '" + ref.typeRefAsString + "'");
			}
		}
	}
	
	/**
	 * Infers the generalized {@link TypeRef} of the given typeRef, which can be recognized by
	 * a type switch.
	 * 
	 * In many cases this {@link TypeRef} will be more generic than the given typeRef, since at runtime
	 * only limited type information is available (e.g. usually no type arguments). However, it always 
	 * holds true that the returned type reference is a subtype of the given type reference typeRef. 
	 */
	public def TypeRef toSwitchRecognizableTypeRef(RuleEnvironment ruleEnv, TypeRef typeRef) {
		val condition = this.compute(typeRef);
		return toTypeRef(ruleEnv, condition);
	}
	
	/**
	 * Converts a given {@link SwitchCondition} to the corresponding recognized {@link TypeRef}.
	 */
	public def TypeRef toTypeRef(RuleEnvironment ruleEnv, SwitchCondition condition) {
		return SwitchCondition2TypeRefConverter.toTypeRef(ruleEnv, condition);
	}
	
	/** 
	 * Converter to convert a {@link SwitchCondition} back to an equivalent {@link TypeRef}. 
	 * 
	 * Use dynamically dispatched method {@link #toTypeRef} to trigger a recursive transformation.
	 */
	private static final class SwitchCondition2TypeRefConverter {
		public static dispatch def TypeRef toTypeRef(RuleEnvironment env, AndSwitchCondition condition) {
			return TypeUtils.createNonSimplifiedIntersectionType(condition.operands.map[o | toTypeRef(env, o)])
		}
		
		public static dispatch def TypeRef toTypeRef(RuleEnvironment env, OrSwitchCondition condition) {
			return TypeUtils.createNonSimplifiedUnionType(condition.operands.map[o | toTypeRef(env, o)])
		}
		
		public static dispatch def TypeRef toTypeRef(RuleEnvironment env, TypeSwitchCondition condition) {
			return TypeUtils.createTypeRef(condition.type, TypingStrategy.DEFAULT, true);
		}
		
		public static dispatch def TypeRef toTypeRef(RuleEnvironment env, ConstantSwitchCondition condition) {
			return TypeUtils.createTypeRef(RuleEnvironmentExtensions.anyType(env));
		}
		
		public static dispatch def TypeRef toTypeRef(RuleEnvironment env, ArrayTypeSwitchCondition condition) {
			return RuleEnvironmentExtensions.arrayTypeRef(env, toTypeRef(env, condition.elementTypeCondition));
		}
	}
	
	public def List<? extends SwitchCondition> disambiguate(SwitchCondition condition) {
		return SwitchConditionDisambiguator.disambiguate(condition).toList;
	}
	
	private final static class SwitchConditionDisambiguator {
		public static def Iterable<? extends SwitchCondition> disambiguate(SwitchCondition condition) {
			return doTransform(condition);
		}
		
		private static dispatch def Iterable<? extends SwitchCondition> doTransform(OrSwitchCondition or) {
			return or.operands.map[op | return doTransform(op)].flatten.toList
		}
		
		private static dispatch def Iterable<? extends SwitchCondition> doTransform(AndSwitchCondition and) {
			val operandResults = and.operands.map[op | return doTransform(op)];
			
			return combinations(operandResults).map[ operands |
				new AndSwitchCondition(operands.get(0), operands.get(1), operands.drop(2))
			].toList;
		}
		
		private static dispatch def Iterable<? extends SwitchCondition> doTransform(ArrayTypeSwitchCondition array) {
			val operandResults = doTransform(array.elementTypeCondition);
			
			return operandResults.map[c | SwitchCondition.arrayOf(c)];
		}
		
		private static dispatch def Iterable<? extends SwitchCondition> doTransform(SwitchCondition switchCondition) {
			return #[switchCondition];
		}
	}
	
	private static def <T> Iterable<Iterable<? extends T>> combinations(List<Iterable<? extends T>> lists) {
		var Iterable<Iterable<? extends T>> remainingPools = lists.tail;
		var Iterable<Iterable<? extends T>> combinations = lists.head.map[e | #[e] ]; 
		
		while (!remainingPools.empty) {
			val current = remainingPools.head;
			remainingPools = remainingPools.tail;
			
			val previousCombinations = combinations;
			
			combinations = current.map[e |
				previousCombinations.map[combination |
					return #[e] + combination;
				]
			].flatten
		}
		
		return combinations;
	}
	
	/** Returns {@code true} if the given {@link TypeRef} should be ignored
	 * by the generated {@link SwitchCondition}s.
	 */
	private def boolean isIgnoredTypeRef(TypeRef ref) {
		return ref instanceof TypeTypeRef;
	}
	
	/** Returns the BuiltInTypeScope that is used for the given context object. */
	private def BuiltInTypeScope getBuiltInTypes(EObject context) {
		return BuiltInTypeScope.get(context.eResource.resourceSet);
	}
	
	/** 
	 * Returns {@code true} iff the given {@link TypeRef} refers to a parameterized Array type.
	 * 
	 * This excludes Array type references with type variables or wildcards as type argument. 
	 */
	private def boolean isParameterizedArrayTypeRef(ParameterizedTypeRef typeRef) {
		return typeRef.declaredType == getBuiltInTypes(typeRef).arrayType 
			&& typeRef.typeArgs.size > 0
			// TODO support for wildcards with bounds
			&& typeRef.typeArgs.get(0) instanceof TypeRef;
	}
}