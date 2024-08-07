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
package org.eclipse.n4js;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.n4js.common.unicode.UnicodeStandaloneSetup;
import org.eclipse.xtext.ISetup;

@SuppressWarnings("all")
public class TypeExpressionsStandaloneSetupGenerated implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		UnicodeStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new TypeExpressionsRuntimeModule());
	}
	
	public void register(Injector injector) {
	}
}
