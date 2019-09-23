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
package org.eclipse.n4js.cli.tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.Permission;

import org.eclipse.n4js.cli.N4jscConsole;
import org.eclipse.n4js.cli.N4jscMain;
import org.eclipse.n4js.cli.N4jscOptions;
import org.junit.After;
import org.junit.Before;

/**  */
public class AbstractCliTest {

	private ByteArrayOutputStream baos;

	/** Sets up the System outputs and Security Manager */
	@Before
	final public void before() throws UnsupportedEncodingException {
		baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos, true, "UTF-8");
		N4jscConsole.setPrintStream(ps);
		System.setSecurityManager(new NoExitSecurityManager());
	}

	/** Restores everything. */
	@After
	final public void after() throws IOException {
		baos.close();
		System.setSecurityManager(null); // restore original security manager
	}

	/** Convenience version of {@link #main(String[], int)} with exist code == 0 */
	protected String main(String[] args) {
		return main(args, 0);
	}

	/** Convenience version of {@link #main(String[], int, boolean)} with exist code == 0 and removeUsage == true */
	protected String main(String[] args, int exitCode) {
		return main(args, exitCode, true);
	}

	/**
	 * Calls main entry point of N4jsc with the given args. Checks that the given exit code equals the actual exit code
	 * of the invocation. Removes {@link N4jscOptions#USAGE} text if desired.
	 */
	protected String main(String[] args, int exitCode, boolean removeUsage) {
		String consoleLog = "";
		try {
			baos.reset();
			N4jscMain.main(args);
		} catch (SystemExitException e) {
			assertEquals(exitCode, e.status);
		}
		consoleLog = getConsoleOutput();
		if (removeUsage) {
			consoleLog = consoleLog.replace(N4jscOptions.USAGE, "");
		}
		return consoleLog.trim();
	}

	/**  */
	protected String getConsoleOutput() {
		try {
			String output = baos.toString("UTF-8");
			return output;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	static class SystemExitException extends SecurityException {
		public final int status;

		public SystemExitException(int status) {
			this.status = status;
		}
	}

	private static class NoExitSecurityManager extends SecurityManager {
		private final SecurityManager securityManager;

		NoExitSecurityManager() {
			this.securityManager = System.getSecurityManager();
		}

		@Override
		public void checkPermission(Permission perm) {
			if (securityManager != null) {
				securityManager.checkPermission(perm);
			}
		}

		@Override
		public void checkPermission(Permission perm, Object context) {
			if (securityManager != null) {
				securityManager.checkPermission(perm, context);
			}
		}

		@Override
		public void checkExit(int status) {
			super.checkExit(status);
			throw new SystemExitException(status);
		}

	}
}
