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
package org.eclipse.n4js.ide.server;

import static org.eclipse.n4js.N4JSGlobals.CJS_FILE_EXTENSION;
import static org.eclipse.n4js.N4JSGlobals.DTS_FILE_EXTENSION;
import static org.eclipse.n4js.N4JSGlobals.JSX_FILE_EXTENSION;
import static org.eclipse.n4js.N4JSGlobals.JS_FILE_EXTENSION;
import static org.eclipse.n4js.N4JSGlobals.MJS_FILE_EXTENSION;
import static org.eclipse.n4js.N4JSGlobals.N4JSD_FILE_EXTENSION;
import static org.eclipse.n4js.N4JSGlobals.N4JSX_FILE_EXTENSION;
import static org.eclipse.n4js.N4JSGlobals.N4JS_FILE_EXTENSION;

import org.eclipse.n4js.fileextensions.FileExtensionType;
import org.eclipse.n4js.fileextensions.FileExtensionsRegistry;
import org.eclipse.n4js.generator.SubGeneratorRegistry;
import org.eclipse.n4js.json.JSONGlobals;
import org.eclipse.n4js.json.JSONStandaloneSetup;
import org.eclipse.n4js.json.extension.JSONExtensionRegistry;
import org.eclipse.n4js.resource.PackageJsonResourceDescriptionExtension;
import org.eclipse.n4js.transpiler.dts.DtsSubGenerator;
import org.eclipse.n4js.transpiler.es.EcmaScriptSubGenerator;
import org.eclipse.n4js.validation.validators.packagejson.N4JSProjectSetupJsonValidatorExtension;
import org.eclipse.n4js.validation.validators.packagejson.PackageJsonValidatorExtension;
import org.eclipse.n4js.xtext.ide.server.util.IHeadlessExtensionRegistrationHelper;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * This class provides helper methods for registering extensions in headless case. This should become obsolete the
 * extensions are registered by a service loaded in the headless case.
 */
public class HeadlessExtensionRegistrationHelper implements IHeadlessExtensionRegistrationHelper {

	@Inject
	private FileExtensionsRegistry n4jsFileExtensionsRegistry;

	@Inject
	private SubGeneratorRegistry subGeneratorRegistry;

	@Inject
	private EcmaScriptSubGenerator ecmaScriptSubGenerator;

	@Inject
	private DtsSubGenerator dtsSubGenerator;

	@Inject
	private PackageJsonValidatorExtension packageJsonValidatorExtension;

	@Inject
	private N4JSProjectSetupJsonValidatorExtension projectSetupValidatorExtension;

	@Inject
	private PackageJsonResourceDescriptionExtension packageJsonResourceDescriptionExtension;

	/**
	 * Register extensions manually. This method should become obsolete when extension point fully works in headless
	 * case.
	 */
	@Override
	public void registerExtensions() {
		// Register file extensions
		registerTestableFiles(N4JS_FILE_EXTENSION, N4JSX_FILE_EXTENSION);
		registerRunnableFiles(N4JS_FILE_EXTENSION, JS_FILE_EXTENSION, CJS_FILE_EXTENSION, MJS_FILE_EXTENSION,
				N4JSX_FILE_EXTENSION, JSX_FILE_EXTENSION);
		registerTranspilableFiles(N4JS_FILE_EXTENSION, N4JSX_FILE_EXTENSION, JS_FILE_EXTENSION, CJS_FILE_EXTENSION,
				MJS_FILE_EXTENSION, JSX_FILE_EXTENSION);
		registerTypableFiles(N4JSD_FILE_EXTENSION, N4JS_FILE_EXTENSION, N4JSX_FILE_EXTENSION, JS_FILE_EXTENSION,
				CJS_FILE_EXTENSION, MJS_FILE_EXTENSION, JSX_FILE_EXTENSION, DTS_FILE_EXTENSION);
		registerRawFiles(JS_FILE_EXTENSION, CJS_FILE_EXTENSION, MJS_FILE_EXTENSION, JSX_FILE_EXTENSION);

		// Register d.ts subgenerator
		subGeneratorRegistry.register(dtsSubGenerator, N4JS_FILE_EXTENSION);
		subGeneratorRegistry.register(dtsSubGenerator, N4JSX_FILE_EXTENSION);
		subGeneratorRegistry.register(dtsSubGenerator, N4JSD_FILE_EXTENSION);

		// Register ECMAScript subgenerator
		subGeneratorRegistry.register(ecmaScriptSubGenerator, N4JS_FILE_EXTENSION);
		subGeneratorRegistry.register(ecmaScriptSubGenerator, JS_FILE_EXTENSION);
		subGeneratorRegistry.register(ecmaScriptSubGenerator, CJS_FILE_EXTENSION);
		subGeneratorRegistry.register(ecmaScriptSubGenerator, MJS_FILE_EXTENSION);
		subGeneratorRegistry.register(ecmaScriptSubGenerator, N4JSX_FILE_EXTENSION);
		subGeneratorRegistry.register(ecmaScriptSubGenerator, JSX_FILE_EXTENSION);

		// register N4JS-specific package.json behavior with JSONExtensionRegistry
		registerJSONLanguageExtension();

	}

	/** Unregister all extensions */
	@Override
	public void unregisterExtensions() {
		n4jsFileExtensionsRegistry.reset();
		subGeneratorRegistry.reset();
	}

	/**
	 * Registers files to {@link FileExtensionType#TESTABLE_FILE_EXTENSION}
	 */
	private void registerTestableFiles(String... extensions) {
		for (String extension : extensions) {
			n4jsFileExtensionsRegistry.register(extension, FileExtensionType.TESTABLE_FILE_EXTENSION);
		}
	}

	/**
	 * Registers files to {@link FileExtensionType#RUNNABLE_FILE_EXTENSION}
	 */
	private void registerRunnableFiles(String... extensions) {
		for (String extension : extensions) {
			n4jsFileExtensionsRegistry.register(extension, FileExtensionType.RUNNABLE_FILE_EXTENSION);
		}
	}

	/**
	 * Registers files to {@link FileExtensionType#TRANSPILABLE_FILE_EXTENSION}
	 */
	private void registerTranspilableFiles(String... extensions) {
		for (String extension : extensions) {
			n4jsFileExtensionsRegistry.register(extension, FileExtensionType.TRANSPILABLE_FILE_EXTENSION);
		}
	}

	/**
	 * Registers files to {@link FileExtensionType#TYPABLE_FILE_EXTENSION}
	 */
	private void registerTypableFiles(String... extensions) {
		for (String extension : extensions) {
			n4jsFileExtensionsRegistry.register(extension, FileExtensionType.TYPABLE_FILE_EXTENSION);
		}
	}

	/**
	 * Registers files to {@link FileExtensionType#RAW_FILE_EXTENSION}
	 */
	private void registerRawFiles(String... extensions) {
		for (String extension : extensions) {
			n4jsFileExtensionsRegistry.register(extension, FileExtensionType.TESTABLE_FILE_EXTENSION);
		}
	}

	/**
	 * Register the N4JS-specific package.json language extension with the JSON extension registry.
	 *
	 * Assumes that the {@link JSONStandaloneSetup} has been performed beforehand.
	 */
	private void registerJSONLanguageExtension() {
		final IResourceServiceProvider jsonServiceProvider = (IResourceServiceProvider) IResourceServiceProvider.Registry.INSTANCE
				.getExtensionToFactoryMap().get(JSONGlobals.FILE_EXTENSION);

		if (jsonServiceProvider == null) {
			throw new IllegalStateException("Could not obtain the IResourceServiceProvider for the JSON language. "
					+ " Has the standlone setup of the JSON language been performed.");
		}

		final JSONExtensionRegistry jsonExtensionRegistry = jsonServiceProvider
				.get(JSONExtensionRegistry.class);

		jsonExtensionRegistry.register(packageJsonValidatorExtension);
		jsonExtensionRegistry.register(projectSetupValidatorExtension);
		jsonExtensionRegistry.register(packageJsonResourceDescriptionExtension);

	}

}
