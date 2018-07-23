/**
 * Copyright (c) 2018 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.packagejson;

import static org.eclipse.n4js.json.model.utils.JSONModelUtils.asArrayElementsOrEmpty;
import static org.eclipse.n4js.json.model.utils.JSONModelUtils.asNameValuePairsOrEmpty;
import static org.eclipse.n4js.json.model.utils.JSONModelUtils.asNonEmptyStringOrNull;
import static org.eclipse.n4js.json.model.utils.JSONModelUtils.asNonEmptyStringsInArrayOrEmpty;
import static org.eclipse.n4js.packagejson.PackageJsonConstants.PROP__MODULE;
import static org.eclipse.n4js.packagejson.PackageJsonConstants.PROP__SOURCE_CONTAINER;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.n4js.json.JSON.JSONArray;
import org.eclipse.n4js.json.JSON.JSONObject;
import org.eclipse.n4js.json.JSON.JSONPackage;
import org.eclipse.n4js.json.JSON.JSONValue;
import org.eclipse.n4js.json.JSON.NameValuePair;
import org.eclipse.n4js.n4mf.BootstrapModule;
import org.eclipse.n4js.n4mf.ModuleFilter;
import org.eclipse.n4js.n4mf.ModuleFilterSpecifier;
import org.eclipse.n4js.n4mf.ModuleFilterType;
import org.eclipse.n4js.n4mf.ModuleLoader;
import org.eclipse.n4js.n4mf.N4mfFactory;
import org.eclipse.n4js.n4mf.N4mfPackage;
import org.eclipse.n4js.n4mf.ProjectReference;
import org.eclipse.n4js.n4mf.ProjectType;
import org.eclipse.n4js.n4mf.SourceContainerDescription;
import org.eclipse.n4js.n4mf.SourceContainerType;
import org.eclipse.n4js.validation.validators.packagejson.N4JSProjectSetupJsonValidatorExtension;
import org.eclipse.n4js.validation.validators.packagejson.PackageJsonValidatorExtension;

import com.google.common.base.Strings;

/**
 * A utility methods for extracting N4JS-specific information from generic {@link JSONPackage} model instances
 * <p>
 * These utility methods do not validate the structure of the given {@link JSONPackage} instances. Rather, they will
 * defensively abort and return {@code null} in case the given {@link JSONValue} is not a valid representation of the
 * {@link N4mfPackage} instance in question (for validation see {@link PackageJsonValidatorExtension} and
 * {@link N4JSProjectSetupJsonValidatorExtension}).
 * <p>
 * Example: obtain source containers in terms of {@link SourceContainerDescription}s from a given {@link JSONObject})
 */
public class PackageJsonUtils {

	/**
	 * Converts given JSON value to a {@link ProjectReference}; returns <code>null</code> if not possible.
	 */
	public static ProjectReference asProjectReferenceOrNull(JSONValue jsonValue) {
		String valueStr = asNonEmptyStringOrNull(jsonValue);
		if (!Strings.isNullOrEmpty(valueStr)) {
			final ProjectReference result = N4mfFactory.eINSTANCE.createProjectReference();
			result.setProjectId(valueStr);
			return result;
		}
		return null;
	}

	/**
	 * If the given JSON value is a {@link JSONArray}, returns its elements converted to {@link ProjectReference}s with
	 * {@link #asProjectReferenceOrNull(JSONValue)}; otherwise an empty list is returned.
	 */
	public static List<ProjectReference> asProjectReferencesInArrayOrEmpty(JSONValue jsonValue) {
		return asArrayElementsOrEmpty(jsonValue).stream()
				.map(PackageJsonUtils::asProjectReferenceOrNull)
				.filter(ref -> ref != null)
				.collect(Collectors.toList());
	}

	/**
	 * Converts given JSON value to a {@link BootstrapModule}; returns <code>null</code> if not possible.
	 */
	public static BootstrapModule asBootstrapModuleOrNull(JSONValue jsonValue) {
		String valueStr = asNonEmptyStringOrNull(jsonValue);
		if (!Strings.isNullOrEmpty(valueStr)) {
			final BootstrapModule result = N4mfFactory.eINSTANCE.createBootstrapModule();
			result.setModuleSpecifier(valueStr);
			return result;
		}
		return null;
	}

	/**
	 * If the given JSON value is a {@link JSONArray}, returns its elements converted to {@link BootstrapModule}s with
	 * {@link #asBootstrapModuleOrNull(JSONValue)}; otherwise an empty list is returned.
	 */
	public static List<BootstrapModule> asBootstrapModulesInArrayOrEmpty(JSONValue jsonValue) {
		return asArrayElementsOrEmpty(jsonValue).stream()
				.map(PackageJsonUtils::asBootstrapModuleOrNull)
				.filter(boomod -> boomod != null)
				.collect(Collectors.toList());
	}

	/**
	 * Converts given name/value pair to a {@link ModuleFilter}; returns <code>null</code> if not possible.
	 * <p>
	 * Expected format of argument:
	 *
	 * <pre>
	 * "noValidate": [
	 *     "abc*",
	 *     {
	 *         "sourceContainer": "src",
	 *         "module": "abc*"
	 *     }
	 * ]
	 *
	 * // or:
	 *
	 * "noModuleWrap": [
	 *     // same as above
	 * ]
	 * </pre>
	 */
	public static ModuleFilter asModuleFilterOrNull(NameValuePair pair) {
		ModuleFilterType type = parseModuleFilterType(pair.getName());
		if (type != null) {
			List<ModuleFilterSpecifier> mspecs = asModuleFilterSpecifierInArrayOrEmpty(pair.getValue());
			if (!mspecs.isEmpty()) {
				ModuleFilter mfilter = N4mfFactory.eINSTANCE.createModuleFilter();
				mfilter.setModuleFilterType(type);
				mfilter.getModuleSpecifiers().addAll(mspecs);
				return mfilter;
			}
		}
		return null;
	}

	/**
	 * If the given JSON value is a {@link JSONObject}, returns its name/value pairs converted to {@link ModuleFilter}s
	 * with {@link #asModuleFilterOrNull(NameValuePair)}; otherwise an empty list is returned.
	 */
	public static List<ModuleFilter> asModuleFiltersInObjectOrEmpty(JSONValue jsonValue) {
		return asNameValuePairsOrEmpty(jsonValue).stream()
				.map(PackageJsonUtils::asModuleFilterOrNull)
				.filter(mfilter -> mfilter != null)
				.collect(Collectors.toList());
	}

	/**
	 * Converts given JSON value to a {@link ModuleFilterSpecifier}; returns <code>null</code> if not possible.<br>
	 * The following variants are supported:
	 *
	 * <pre>
	 * "abc*"
	 *
	 * // or:
	 *
	 * {
	 *     "sourceContainer": "src"
	 *     "module": "abc*",
	 * }
	 * </pre>
	 */
	public static ModuleFilterSpecifier asModuleFilterSpecifierOrNull(JSONValue jsonValue) {
		// 1st variant:
		String singleString = asNonEmptyStringOrNull(jsonValue);
		if (singleString != null) {
			return createModuleFilterSpecifier(null, singleString);
		}
		// 2nd variant:
		List<NameValuePair> pairs = asNameValuePairsOrEmpty(jsonValue);
		NameValuePair pathNVP = pairs.stream()
				.filter(p -> PROP__SOURCE_CONTAINER.equals(p.getName())).findFirst()
				.orElse(null);
		NameValuePair moduleNVP = pairs.stream().filter(p -> PROP__MODULE.equals(p.getName()))
				.findFirst().orElse(null);
		String pathStr = pathNVP != null ? asNonEmptyStringOrNull(pathNVP.getValue()) : null;
		String moduleStr = moduleNVP != null ? asNonEmptyStringOrNull(moduleNVP.getValue()) : null;
		if (moduleStr != null) { // pathStr may be null, i.e. "sourceContainer" is optional
			return createModuleFilterSpecifier(pathStr, moduleStr);
		}
		return null;
	}

	private static ModuleFilterSpecifier createModuleFilterSpecifier(String sourcePath,
			String moduleSpecifierWithWildcard) {
		final ModuleFilterSpecifier result = N4mfFactory.eINSTANCE.createModuleFilterSpecifier();
		result.setSourcePath(sourcePath);
		result.setModuleSpecifierWithWildcard(moduleSpecifierWithWildcard);
		return result;
	}

	/**
	 * If the given JSON value is a {@link JSONArray}, returns its elements converted to {@link ModuleFilterSpecifier}s
	 * with {@link #asModuleFilterSpecifierOrNull(JSONValue)}; otherwise an empty list is returned.
	 */
	public static List<ModuleFilterSpecifier> asModuleFilterSpecifierInArrayOrEmpty(JSONValue jsonValue) {
		return asArrayElementsOrEmpty(jsonValue).stream()
				.map(PackageJsonUtils::asModuleFilterSpecifierOrNull)
				.filter(mspec -> mspec != null)
				.collect(Collectors.toList());
	}

	/**
	 * Converts given name/value pair to a {@link SourceContainerDescription}; returns <code>null</code> if not
	 * possible.
	 * <p>
	 * Expected format of argument:
	 *
	 * <pre>
	 * "source": [
	 *     "src1",
	 *     "src2"
	 * ]
	 *
	 * // or:
	 *
	 * "external": [
	 *     "src-ext"
	 * ]
	 * </pre>
	 */
	public static SourceContainerDescription asSourceContainerDescriptionOrNull(NameValuePair pair) {
		SourceContainerType type = parseSourceContainerType(pair.getName());
		List<String> paths = asNonEmptyStringsInArrayOrEmpty(pair.getValue());
		if (type != null && !paths.isEmpty()) {
			SourceContainerDescription sourceContainerDescription = N4mfFactory.eINSTANCE
					.createSourceContainerDescription();
			sourceContainerDescription.setSourceContainerType(type);
			sourceContainerDescription.getPaths().addAll(paths);
			return sourceContainerDescription;
		}
		return null;
	}

	/**
	 * If the given JSON value is a {@link JSONObject}, returns its name/value pairs converted to
	 * {@link SourceContainerDescription}s with {@link #asSourceContainerDescriptionOrNull(NameValuePair)}; otherwise an
	 * empty list is returned.
	 */
	public static List<SourceContainerDescription> asSourceContainerDescriptionsOrEmpty(JSONValue sourcesSection) {
		return asNameValuePairsOrEmpty(sourcesSection).stream()
				.map(PackageJsonUtils::asSourceContainerDescriptionOrNull)
				.filter(scd -> scd != null)
				.collect(Collectors.toList());
	}

	/**
	 * Parses the {@link ModuleFilterType} from the given string representation.
	 *
	 * Returns {@code null} if {@code value} is not a valid string representation of a {@link ModuleFilterType}.
	 */
	public static ModuleFilterType parseModuleFilterType(String value) {
		if (value.equals("noValidate")) {
			return ModuleFilterType.NO_VALIDATE;
		} else if (value.equals("noModuleWrap")) {
			return ModuleFilterType.NO_MODULE_WRAP;
		} else {
			return null;
		}
	}

	/**
	 * Returns the string representation of the given {@link ModuleFilterType}.
	 */
	public static String getModuleFilterTypeStringRepresentation(ModuleFilterType type) {
		if (type == ModuleFilterType.NO_VALIDATE) {
			return "noValidate";
		} else if (type == ModuleFilterType.NO_MODULE_WRAP) {
			return "noModuleWrap";
		} else {
			return "<invalid module filter type>";
		}
	}

	/**
	 * Parses a {@link ProjectType} from the given string representation.
	 *
	 * Returns {@code null} if {@code value} is not a valid string representation of a {@link ProjectType}.
	 */
	public static ProjectType parseProjectType(String projectTypeStr) {
		if ("runtimeEnvironment".equals(projectTypeStr))
			return ProjectType.RUNTIME_ENVIRONMENT;
		if ("runtimeLibrary".equals(projectTypeStr))
			return ProjectType.RUNTIME_LIBRARY;
		return parseEnumLiteral(N4mfPackage.eINSTANCE.getProjectType(), ProjectType.class,
				projectTypeStr);
	}

	/**
	 * Parses a {@link ModuleLoader} from the given string representation.
	 *
	 * Returns {@code null} if {@code value} is not a valid string representation of a {@link ModuleLoader}.
	 */
	public static ModuleLoader parseModuleLoader(String moduleLoaderStr) {
		return parseEnumLiteral(N4mfPackage.eINSTANCE.getModuleLoader(), ModuleLoader.class,
				moduleLoaderStr);
	}

	/**
	 * Parses a {@link SourceContainerType} from the given string representation.
	 *
	 * Returns {@code null} if {@code sourceContainerTypeStr} is not a valid source container type string
	 * representation.
	 */
	public static SourceContainerType parseSourceContainerType(String sourceContainerTypeStr) {
		return parseEnumLiteral(N4mfPackage.eINSTANCE.getSourceContainerType(), SourceContainerType.class,
				sourceContainerTypeStr);
	}

	/**
	 * Returns the string representation of the given {@link SourceContainerType}.
	 *
	 * @throw {@link NullPointerException} if {@code type} is null.
	 */
	public static String getSourceContainerTypeStringRepresentation(SourceContainerType type) {
		return type.getLiteral().toLowerCase();
	}

	private static <T extends Enumerator> T parseEnumLiteral(EEnum emfEnumType, Class<T> javaEnumType,
			String enumLiteralStr) {
		EEnumLiteral emfLit = enumLiteralStr != null ? emfEnumType.getELiterals().stream()
				.filter(lit -> lit.getName().equalsIgnoreCase(enumLiteralStr))
				.findFirst().orElse(null) : null;
		if (emfLit == null) {
			return null;
		}
		final Enumerator javaLit = emfLit.getInstance();
		@SuppressWarnings("unchecked")
		T javaLitCasted = javaEnumType.isInstance(javaLit) ? (T) javaLit : null;
		return javaLitCasted;
	}
}
