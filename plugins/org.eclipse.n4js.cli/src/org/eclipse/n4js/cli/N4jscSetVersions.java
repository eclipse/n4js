/**
 * Copyright (c) 2021 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.cli;

import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.packagejson.PackageJsonModificationUtils;

/**
 * Performs the n4jsc goal set-versions
 */
public class N4jscSetVersions {

	/** Starts the compiler for goal SET-VERSIONS in a blocking fashion */
	public static N4jscExitState start(N4jscOptions options) {
		Path workingDirectory = options.getWorkingDirectory();
		String newVersionString = options.getSetVersions();

		try {
			PackageJsonModificationUtils.setVersionOfDependenciesInAllPackageJsonFiles(workingDirectory,
					N4JSGlobals.ALL_N4JS_LIBS, newVersionString);
			return N4jscExitState.SUCCESS;
		} catch (IOException e) {
			return new N4jscExitState(N4jscExitCode.SET_VERSIONS_ERROR, e.getMessage());
		}
	}
}
