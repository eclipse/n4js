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
package org.eclipse.n4js.projectModel;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.n4mf.ProjectDescription;

/**
 */
public interface IExternalPackageManager {

	/**
	 * Loads the N4JS {@link ProjectDescription} for the given external project root location.
	 */
	ProjectDescription loadProjectDescriptionFromProjectRoot(URI rootLocation);

	/**
	 * @return true iff the given location is the (existing) root folder of a project that contains a manifest.n4mf file
	 */
	public boolean isN4ProjectRoot(URI rootLocation);
}
