/**
 * Copyright (c) 2019 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.ui.refactoring;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;

/**
 * HACK! We need to use the ResourceSet that contains already built resources
 */
public class N4JSRefactoringResourceSetProvider extends RefactoringResourceSetProvider {
	public static ResourceSet myGlobalResourceSet;

	@Override
	public ResourceSet get(IProject project) {
		return N4JSRefactoringResourceSetProvider.myGlobalResourceSet;
	}
}
