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
package org.eclipse.n4js.generator.common;

import java.util.Collection;
import java.util.Set;

/**
 * A composite generator is responsible for a language. A composite generator delegates the generation logics to its
 * children (subgenerators).
 */
public interface IComposedGenerator extends IBaseGenerator {

	/**
	 * @return the descriptors of the registered compilers. Besides identifier and name they also contain the default
	 *         output configuration.
	 */
	Set<CompilerDescriptor> getCompilerDescriptors();

	/**
	 * @return the list of sub-generators.
	 */
	Collection<ISubGenerator> getSubGenerators();
}
