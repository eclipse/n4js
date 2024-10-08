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
package org.eclipse.n4js.tests.realworld;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.tests.utils.ConvertedIdeTest;
import org.eclipse.n4js.utils.InjectorCollector;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Scope;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.DefaultBindingScopingVisitor;

/**
 * This test detects multiple instances of injected classes marked with <code>@Singleton</code>.
 * <p>
 * Note that instances are created lazily. Consequently, this test cannot guarantee completeness. In case a case of
 * multiple singleton instances is missing, this test should be adjusted to provoke the lazy creation of this missing
 * case.
 * <p>
 * Note also that singleton classes that are never bound explicitly (meaning in none of the modules), are not checked in
 * this test.
 */
// converted from MultipleSingletonPluginUITest
public class MultipleSingletonIdeTest extends ConvertedIdeTest {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	/**
	 * The tests first collects all injectors. The shared injector is identified using the class
	 * {@link InjectorCollector}. Afterwards, it detects all singleton classes that are bound in N4JS related injectors.
	 * Finally, for every such singleton class all injectors are checked whether they created an instance of the
	 * singleton class and whether these instances are the same.
	 */
	@Test
	public void identifyMultipleSingletons() throws Exception {
		importProband(new File("probands", "ListBase"));

		Multimap<Class<?>, Injector> singletonInstances = HashMultimap.create();

		Map<Injector, String> injectors = getAllInjectors();
		for (Map.Entry<Injector, String> injectorAndName : injectors.entrySet()) {
			Injector injector = injectorAndName.getKey();
			String name = injectorAndName.getValue();
			assertTrue("Injector '" + name + "' is null.", injector != null);
			getN4JSSingletonsOfInjector(injector, singletonInstances);
		}

		String status = getMultipleSingletonStatusString(singletonInstances, injectors);

		assertEquals(MultiSingletonExpectation.get(), status);
	}

	Map<Injector, String> getAllInjectors() {
		Map<Injector, String> injectors = new HashMap<>();

		injectors.putAll(InjectorCollector.getSharedInjectors());

		Assert.assertNull(injectors.put(getInjectorFor("n4js"), "N4JS-Injector"));
		Assert.assertNull(injectors.put(getInjectorFor("json"), "JSON-Injector"));
		Assert.assertNull(injectors.put(getInjectorFor("regex"), "Regex-Injector"));

		return injectors;
	}

	private Injector getInjectorFor(String fileExtension) {
		IResourceServiceProvider rsp = resourceServiceProviderRegistry
				.getResourceServiceProvider(URI.createFileURI("dummy." + fileExtension));
		Injector injector = rsp.get(Injector.class);
		Assert.assertNotNull(injector);
		return injector;
	}

	private void getN4JSSingletonsOfInjector(Injector injector, Multimap<Class<?>, Injector> singletonInstances) {
		for (Binding<?> b : injector.getAllBindings().values()) {
			if (isSingleton(b)) {
				Key<?> key = b.getKey();
				TypeLiteral<?> typeLiteral = key.getTypeLiteral();
				String typeName = typeLiteral.toString();
				if (typeName.contains("n4js")) {
					singletonInstances.put(typeLiteral.getRawType(), injector);
				}
			}
		}
	}

	private boolean isSingleton(Binding<?> b) {
		return b.acceptScopingVisitor(new DefaultBindingScopingVisitor<Boolean>() {
			@Override
			public Boolean visitEagerSingleton() {
				return Boolean.TRUE;
			}

			@Override
			public Boolean visitScope(Scope scope) {
				return Scopes.SINGLETON.equals(scope);
			}

			@Override
			protected Boolean visitOther() {
				return Boolean.FALSE;
			}
		});
	}

	private String getMultipleSingletonStatusString(Multimap<Class<?>, Injector> singletonInstances,
			Map<Injector, String> injectors) {

		// sort to preserve output order
		List<Class<?>> sortedByClassName = new ArrayList<>(singletonInstances.keySet());
		Comparator<Class<?>> comparatorByClassName = new Comparator<>() {
			@Override
			public int compare(Class<?> c1, Class<?> c2) {
				return c1.getName().compareTo(c2.getName());
			}
		};
		Collections.sort(sortedByClassName, comparatorByClassName);

		String status = "";
		int multipleInstancesCount = 0;
		for (Class<?> singleton : sortedByClassName) {
			String outputForInstance = printInjectorsForInstances(singleton, injectors);
			if (outputForInstance.length() > 0) {
				status += outputForInstance;
				multipleInstancesCount++;
			}
		}
		status = "Found multiple instances for " + multipleInstancesCount + " singleton classes:\n" + status;
		return status;
	}

	private String printInjectorsForInstances(Class<?> singleton, Map<Injector, String> injectors) {
		Multimap<Object, String> instances = HashMultimap.create();
		for (Map.Entry<Injector, String> entry : injectors.entrySet()) {
			String name = entry.getValue();
			Injector inj = entry.getKey();
			try {
				Binding<?> existingBinding = inj.getExistingBinding(Key.get(singleton));
				if (existingBinding != null) {
					Object instance = inj.getInstance(singleton);
					instances.put(instance, name);
				}
			} catch (Exception e) {
				// ignore
			}
		}

		int instanceCount = instances.keySet().size();
		String status = "";
		if (instanceCount > 1) {
			String singletonName = singleton.getName();
			status += "Singleton '" + singletonName + "' has " + instanceCount;
			status += " instances that have the following injectors:\n";
			List<String> statusLines = new ArrayList<>();
			for (Object instance : instances.keySet()) {
				List<String> injNames = new ArrayList<>(instances.get(instance));
				Collections.sort(injNames); // sort to preserve output order
				statusLines.add("\t- " + String.join(", ", injNames));
			}

			Collections.sort(statusLines); // sort to preserve output order
			status += String.join("\n", statusLines);
			status += "\n";
		}

		return status;
	}

}
