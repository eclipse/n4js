/**
 * Copyright (c) 2017 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.cli.helper;

import static org.junit.Assert.assertEquals;

import org.eclipse.n4js.cli.N4jscOptions;

/**
 * Abstract test class to be used when testing N4JS CLI related things.
 */
abstract public class AbstractCliTest<ArgType> {

	/** Invokes the starting method of this test class */
	abstract public void doN4jsc(ArgType arg, boolean ignoreFailure, boolean removeUsage, CliCompileResult cliResult);

	/** @return instance of {@link CliCompileResult} which is filled with values later on */
	protected CliCompileResult createResult() {
		return new CliCompileResult();
	}

	/** Convenience version of {@link #n4jsc(Object, int)} with exit code == 0. */
	protected CliCompileResult n4jsc(ArgType args) {
		return n4jsc(args, 0);
	}

	/** Convenience version of {@link #n4jsc(Object, int, boolean)} with removeUsage == true. */
	protected CliCompileResult n4jsc(ArgType args, int exitCode) {
		return n4jsc(args, exitCode, true);
	}

	/**
	 * Calls main entry point of N4jsc with the given args. Checks that the given exit code equals the given exit code
	 * but does not perform any other assertions. Removes {@link N4jscOptions#USAGE} text if desired.
	 */
	protected CliCompileResult n4jsc(ArgType args, int exitCode, boolean removeUsage) {
		CliCompileResult cliResult = createResult();
		doN4jsc(args, true, removeUsage, cliResult);
		assertEquals(cliResult.toString(), exitCode, cliResult.getExitCode());
		return cliResult;
	}

}
