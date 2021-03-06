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
package org.eclipse.n4js.transpiler.dts;

import java.io.Writer;

import org.eclipse.n4js.generator.GeneratorOption;
import org.eclipse.n4js.resource.N4JSResource;
import org.eclipse.n4js.smith.Measurement;
import org.eclipse.n4js.smith.N4JSDataCollectors;
import org.eclipse.n4js.transpiler.AbstractTranspiler;
import org.eclipse.n4js.transpiler.Transformation;
import org.eclipse.n4js.transpiler.TranspilerState;
import org.eclipse.n4js.transpiler.dts.print.PrettyPrinterSwitchDts;
import org.eclipse.n4js.transpiler.print.LineColTrackingAppendable;

import com.google.common.base.Optional;

/**
 * Transpiles N4JS to d.ts.
 */
public class DtsTranspiler extends AbstractTranspiler {

	/**
	 * Returns the AST transformations to be executed for the resource to transpile in the given transpiler state, in
	 * the order they should be executed.
	 */
	@Override
	protected Transformation[] computeTransformationsToBeExecuted(TranspilerState state) {
		return new Transformation[] {
				// interfaceDeclarationTransformationProvider.get(),
		};
	}

	/**
	 * General entry-point. Overridden to handle plain-JS-wrapping without transforming.
	 */
	@Override
	public void transpile(N4JSResource resource, GeneratorOption[] options, Writer outCode,
			Optional<SourceMapInfo> optSourceMapInfo) {

		try (Measurement m = N4JSDataCollectors.dcDtsGeneration.getMeasurement()) {
			super.transpile(resource, options, outCode, optSourceMapInfo);
		}
	}

	/**
	 * Third and last step during transpilation. Generating output code and source maps (optional).
	 */
	@Override
	protected void prettyPrint(TranspilerState state, Writer outCode, Optional<String> optPreamble,
			Optional<SourceMapInfo> optSourceMapInfo) {

		final LineColTrackingAppendable out = new LineColTrackingAppendable(outCode, "\t");
		PrettyPrinterSwitchDts.append(out, state, optPreamble);
	}
}
