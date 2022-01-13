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

import static org.eclipse.n4js.dts.TypeScriptParser.RULE_typeParameterList;
import static org.eclipse.n4js.dts.TypeScriptParser.RULE_typeParameters;

import java.util.List;
import java.util.Set;

import org.eclipse.n4js.dts.TypeScriptParser.FunctionDeclarationContext;
import org.eclipse.n4js.n4JS.FormalParameter;
import org.eclipse.n4js.n4JS.FunctionDeclaration;
import org.eclipse.n4js.n4JS.N4JSFactory;
import org.eclipse.n4js.n4JS.N4Modifier;
import org.eclipse.n4js.n4JS.N4TypeVariable;
import org.eclipse.n4js.n4JS.TypeReferenceNode;
import org.eclipse.n4js.ts.typeRefs.TypeRef;

/**
 * Builder to create {@link TypeReferenceNode} from parse tree elements
 */
public class DtsFunctionBuilder extends AbstractDtsSubBuilder<FunctionDeclarationContext, FunctionDeclaration> {
	private final DtsTypeVariablesBuilder typeVariablesBuilder = new DtsTypeVariablesBuilder();
	private final DtsFormalParametersBuilder formalParametersBuilder = new DtsFormalParametersBuilder();

	@Override
	protected Set<Integer> getVisitChildrenOfRules() {
		return java.util.Set.of(
				RULE_typeParameters,
				RULE_typeParameterList);
	}

	@Override
	public void enterFunctionDeclaration(FunctionDeclarationContext ctx) {
		FunctionDeclaration fd = N4JSFactory.eINSTANCE.createFunctionDeclaration();
		fd.setName(ctx.identifierName().getText());
		fd.getDeclaredModifiers().add(N4Modifier.EXTERNAL);

		fd.setGenerator(ctx.Multiply() != null);
		TypeReferenceNode<TypeRef> trn = typeRefBuilder.consume(ctx.callSignature().typeRef());
		fd.setDeclaredReturnTypeRefNode(trn);
		List<N4TypeVariable> typeVars = typeVariablesBuilder.consume(ctx.callSignature().typeParameters());
		fd.getTypeVars().addAll(typeVars);
		List<FormalParameter> fPars = formalParametersBuilder.consume(ctx.callSignature().parameterBlock());
		fd.getFpars().addAll(fPars);
	}

}
