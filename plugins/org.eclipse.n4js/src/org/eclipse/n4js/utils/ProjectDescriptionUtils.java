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
package org.eclipse.n4js.utils;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.naming.N4JSQualifiedNameConverter;
import org.eclipse.n4js.packagejson.projectDescription.ProjectDescription;
import org.eclipse.n4js.packagejson.projectDescription.SourceContainerDescription;
import org.eclipse.n4js.utils.io.FileUtils;
import org.eclipse.n4js.workspace.locations.SafeURI;
import org.eclipse.n4js.workspace.utils.N4JSPackageName;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 * Miscellaneous utilities for dealing with {@link ProjectDescription}s and values stored within them. In particular,
 * this class provides logic for dealing with project names.
 */
public class ProjectDescriptionUtils {

	/** Prefix denoting project names that include an npm scope. */
	public static final String NPM_SCOPE_PREFIX = "@";
	/** Character used in N4JS project names for separating the scope name from the plain project name. */
	public static final char NPM_SCOPE_SEPARATOR = '/';

	/**
	 * Regular expression for valid package.json identifier (e.g. package name, vendor ID).
	 * <p>
	 * NOTE: for legacy reasons, upper case letters are accepted, even though they are not allowed by npm.
	 */
	private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("(^)?[A-Za-z][A-Za-z_\\-\\.0-9]*");

	private static final Set<String> NPM_RESERVED_PACKAGE_NAMES = Sets.newHashSet(
			// npm core modules (as of 2018/08/06)
			// ---
			// The following core module names are technically reserved package names, however in the npmjs.com
			// registry, many packages exist which use one of these reserved names. Therefore, we cannot strictly
			// enforce a validation of reserved package names. This list remains for reference.
			// ---
			// "assert", "buffer", "child_process", "cluster", "console", "constants", "crypto", "dgram", "dns",
			// "domain",
			// "events", "fs", "http", "https", "module", "net", "os", "path", "punycode", "querystring", "readline",
			// "repl", "stream", "string_decoder", "sys", "timers", "tls", "tty", "url", "util", "vm", "zlib",
			// other reserved names
			N4JSGlobals.NODE_MODULES, "favicon.ico");

	/**
	 * Tells if the given N4JS project name includes an npm scope, i.e. if it is of the form
	 * <code>@scopeName/projectName</code>. In this case, the substring before the {@value #NPM_SCOPE_SEPARATOR} is
	 * referred to as the <em>scope name</em> and the substring following this separator is referred to as <em>plain
	 * project name</em>.
	 *
	 * <h1>Overview of Project Name Handling</h1>
	 *
	 * Naming of N4JS projects is non-trivial, because it has to be in line with NPM conventions regarding npm package
	 * names, esp. the use of npm scopes.
	 * <p>
	 * The following names have to be distinguished:
	 * <table border=1 align="center">
	 * <tr>
	 * <th></th>
	 * <th>Description</th>
	 * <th>Example</th>
	 * </tr>
	 * <tr>
	 * <td>N4JS project name</td>
	 * <td>The value the value returned by {@link ProjectDescription#getPackageName()}. Always equal to<br>
	 * the value of the top-level property "name" in the project's <code>package.json</code> file.</td>
	 * <td>{@code @myScope/myProject}</td>
	 * </tr>
	 * <tr>
	 * <td>plain project name</td>
	 * <td>The N4JS project name without the scope name and without the scope separator.</td>
	 * <td>{@code myProject}</td>
	 * </tr>
	 * <tr>
	 * <td>scope name</td>
	 * <td>The name of the npm scope of a scoped N4JS project, usually including the scope prefix
	 * {@value #NPM_SCOPE_PREFIX}.</td>
	 * <td>{@code @myScope}</td>
	 * </tr>
	 * </table>
	 * In case the intended meaning is apparent from the context, the "N4JS project name" can simply be referred to as
	 * "project name" (as is common practice in the context of npm). For non-scoped projects, the N4JS project name and
	 * the plain project name are equal.
	 * <p>
	 * Due to conventions and rules we cannot influence, an N4JS project name including a scope has to be encoded in
	 * {@link URI}s and {@link QualifiedName}s in various ways:
	 * <table border=1 align="center">
	 * <tr>
	 * <th></th>
	 * <th>Encoding</th>
	 * <th>Example</th>
	 * </tr>
	 * <tr>
	 * <td>{@link URI#isFile() file URIs}</td>
	 * <td>Scope and plain project name represented as <em>two separate</em> segments.</td>
	 * <td>{@code file://a/b/wsp/@myScope/myProject}</td>
	 * </tr>
	 * <tr>
	 * <td>{@link QualifiedName}s</td>
	 * <td>Scope and plain project name represented as <em>a single</em> segment.<br>
	 * {@link #NPM_SCOPE_SEPARATOR} used as separator.</td>
	 * <td>{@code "@myScope/myProject"/"f"/"M"}</td>
	 * </tr>
	 * </table>
	 * These encoding rules are implemented in methods {@link #deriveN4JSPackageNameFromURI(SafeURI)},
	 * {@link N4JSPackageName#toQualifiedName()}, and {@link N4JSQualifiedNameConverter#toQualifiedName(String)}.
	 */
	public static boolean isPackageNameWithScope(String projectName) {
		return projectName != null
				&& projectName.startsWith(NPM_SCOPE_PREFIX)
				&& projectName.indexOf(NPM_SCOPE_SEPARATOR) >= 0;
	}

	/**
	 * Given an N4JS project name that may or may not {@link #isPackageNameWithScope(String) include an npm scope}, this
	 * method returns the scope name or <code>null</code> if the given project name does not include an npm scope.
	 * <p>
	 * NOTE: the returned scope name includes the {@link #NPM_SCOPE_PREFIX}!
	 * <p>
	 * For details on N4JS project name handling, see {@link #isPackageNameWithScope(String)}.
	 */
	public static String getScopeName(String projectName) {
		return isPackageNameWithScope(projectName)
				? projectName.substring(0, projectName.indexOf(NPM_SCOPE_SEPARATOR))
				: null;
	}

	/**
	 * Given an N4JS project name that may or may not {@link #isPackageNameWithScope(String) include an npm scope}, this
	 * method returns the plain project name without scope. If the given project name does not include an npm scope,
	 * that name is returned without change.
	 * <p>
	 * For details on N4JS project name handling, see {@link #isPackageNameWithScope(String)}.
	 */
	public static String getPlainPackageName(String projectName) {
		return isPackageNameWithScope(projectName)
				? projectName.substring(projectName.indexOf(NPM_SCOPE_SEPARATOR) + 1)
				: projectName;
	}

	/**
	 * Tells if the given N4JS project name is valid, i.e. the name may include an npm scope as described
	 * {@link #isPackageNameWithScope(String) here}.
	 */
	public static boolean isValidProjectName(String name) {
		String scopeName = getScopeName(name);
		if (scopeName != null) {
			String plainProjectName = getPlainPackageName(name);
			return isValidScopeName(scopeName) && isValidPlainPackageName(plainProjectName);
		}
		return isValidPlainPackageName(name);
	}

	/**
	 * Tells if the given plain project name is valid.
	 */
	public static boolean isValidPlainPackageName(String name) {
		return isValidNpmPackageName(name);
	}

	/**
	 * Tells if the given NPM scope name is valid.
	 */
	public static boolean isValidScopeName(String name) {
		// if present, remove scope prefix character
		if (name.startsWith(NPM_SCOPE_PREFIX)) {
			return isValidNpmPackageName(name.substring(1));
		}

		return isValidNpmPackageName(name);
	}

	private static boolean isValidNpmPackageName(String name) {
		return !Strings.isNullOrEmpty(name)
				&& name.length() <= 214
				&& !NPM_RESERVED_PACKAGE_NAMES.contains(name)
				&& IDENTIFIER_PATTERN.matcher(name).matches();
	}

	/** Same as {@link #deriveN4JSPackageNameFromURI(URI)}, accepting a {@link SafeURI}. */
	public static String deriveN4JSPackageNameFromURI(SafeURI<?> location) {
		if (location == null) {
			return null;
		}
		return deriveN4JSPackageNameFromURI(location.toURI());
	}

	/**
	 * This method derives a N4JS project name including its scope from a given URI (iff scope folder exists).
	 * <p>
	 * <b>Attention:</b> Note that project names defined in packages.json files can differ from the names of their
	 * parent folders. This method can usually be used safely in node_modules folders since we can assume that npm and
	 * yarn create package folders according to the package names.
	 * <p>
	 * For details on N4JS project name handling, see {@link #isPackageNameWithScope(String)}.
	 */
	// keep aligned to #deriveN4JSProjectNameFromPath(Path) below!
	public static String deriveN4JSPackageNameFromURI(URI uri) {
		if (uri == null) {
			return null;
		}
		int segCount = uri.segmentCount();
		String last = segCount > 0 ? uri.segment(segCount - 1) : null;
		if (uri.isFile()) {
			// due to conventions we cannot influence, the scope name and plain project name are represented as two
			// separate segments in file URIs:
			String secondToLast = segCount > 1 ? uri.segment(segCount - 2) : null;
			if (secondToLast != null && secondToLast.startsWith(NPM_SCOPE_PREFIX)) {
				return secondToLast + NPM_SCOPE_SEPARATOR + last;
			}
			return last;
		}
		throw new IllegalArgumentException("not a file URI: " + uri);
	}

	/** Same as {@link #deriveN4JSPackageNameFromURI(URI)}, but from a {@link Path path}. */
	// keep aligned to #deriveN4JSProjectNameFromURI(URI) above!
	public static String deriveN4JSPackageNameFromPath(Path path) {
		if (path == null) {
			return null;
		}
		int segCount = path.getNameCount();
		String last = segCount > 0 ? path.getName(segCount - 1).toString() : null;
		// due to conventions we cannot influence, the scope name and plain project name are represented as two
		// separate segments in paths:
		String secondToLast = segCount > 1 ? path.getName(segCount - 2).toString() : null;
		if (secondToLast != null && secondToLast.startsWith(NPM_SCOPE_PREFIX)) {
			return secondToLast + NPM_SCOPE_SEPARATOR + last;
		}
		return last;
	}

	/** Same as {@link #deriveN4JSPackageNameFromURI(URI)}, but from a {@link File file}. */
	public static String deriveN4JSPackageNameFromFile(File file) {
		return deriveN4JSPackageNameFromPath(file.toPath());
	}

	/**
	 * Given a path to the main module of an NPM project as given by the "main" property in a package.json, this method
	 * will return the corresponding N4JS module specifier. Returns <code>null</code> if given <code>null</code> or an
	 * invalid path (e.g. absolute path).
	 * <p>
	 * Note: this methods does not implement the package.json feature that a "main" path may point to a folder and then
	 * a file "index.js" in that folder will be used as main module (reason: this method cannot access the file system);
	 * to support this, the path given to this method must be adjusted *before* invoking this method (i.e. append
	 * "/index.js" iff the path points to a folder).
	 */
	public static String convertMainPathToModuleSpecifier(String path, List<String> sourceContainerPaths) {
		if (path == null) {
			return null;
		}

		// strip file extension
		if (!path.contains(".")) {
			// no file extension -> no need to change 'path'
		} else {
			path = URIUtils.trimFileExtension(URI.createFileURI(path)).toString();
		}
		// normalize path segments
		path = normalizeRelativePath(path);
		if (path == null) {
			return null;
		}
		// Now 'path' must point to a file inside a source container.
		// If that is true, then we want to return a path relative to that source container:
		List<String> sourceContainerPathsNormalized = sourceContainerPaths.stream()
				.map(ProjectDescriptionUtils::normalizeRelativePath)
				.filter(p -> p != null)
				.collect(Collectors.toList());
		for (String scp : sourceContainerPathsNormalized) {
			if (".".equals(scp)) {
				return path;
			} else {
				String scpSlash = scp + "/";
				if (path.startsWith(scpSlash)) {
					return path.substring(scpSlash.length());
				}
			}
		}
		return null;
	}

	private static String normalizeRelativePath(String path) {
		if (path == null || path.isEmpty()) {
			return null;
		}
		// enforce relative path
		if (path.startsWith("/")) {
			return null;
		}
		// normalize separator character
		if (File.separatorChar != '/') {
			path = path.replace(File.separatorChar, '/');
		}
		// normalize ".", "..", and empty path segments
		List<String> segmentsNew = new ArrayList<>();
		for (String segment : path.split("/", -1)) {
			if (segment.isEmpty()) {
				continue; // simply ignore //
			} else if (".".equals(segment)) {
				continue; // simply ignore /./
			} else if ("..".equals(segment)) {
				if (segmentsNew.isEmpty()) {
					return null;
				}
				segmentsNew.remove(segmentsNew.size() - 1);
			} else {
				segmentsNew.add(segment);
			}
		}
		if (segmentsNew.isEmpty()) {
			return ".";
		}
		return Joiner.on('/').join(segmentsNew);
	}

	/**
	 * Compares the given source container descriptions based on the natural ordering of the wrapped
	 * {@link SourceContainerDescription source container type}. For more details, see
	 * {@link Comparator#compare(Object, Object)}.
	 */
	public static int compareBySourceContainerType(SourceContainerDescription first, SourceContainerDescription other) {
		if (first == null)
			return other == null ? 0 : 1;
		if (other == null)
			return -1;
		return first.getType().compareTo(other.getType());
	}

	/**
	 * Returns the {@link SourceContainerDescription#getPaths() paths} of the given source container description but
	 * normalized with {@link FileUtils#normalizeToDotWhenEmpty(String)}.
	 */
	public static List<String> getPathsNormalized(List<String> paths) {
		List<String> normalizedPaths = new ArrayList<>(paths.size());
		for (String path : paths) {
			String normalizedPath = FileUtils.normalizeToDotWhenEmpty(path);
			normalizedPaths.add(normalizedPath);
		}
		return normalizedPaths;
	}

	/**
	 * Utility class to obtain and store the name of a project's <em>project folder</em> on disk, together with the name
	 * of the project folder's <em>parent folder</em>. In the UI case, the name of the Eclipse project in the workspace
	 * is stored, too.
	 */
	public static final class ProjectNameInfo {
		/** Name of the project folder, i.e. the folder containing the project's <code>package.json</code> file. */
		public final String projectFolderName;
		/** Name of the folder containing the {@link #projectFolderName project folder}. */
		public final String parentFolderName;

		private ProjectNameInfo(String projectFolderName, String parentFolderName) {
			this.projectFolderName = projectFolderName;
			this.parentFolderName = parentFolderName;
		}

		/** Creates a new instance. Given URI should point to an N4JS project, not a file within an N4JS project. */
		public static ProjectNameInfo of(URI projectUri) {
			if (projectUri.isFile()) {
				if (projectUri.lastSegment().isEmpty()) {
					// folders end with an empty segment?
					// projectUri = projectUri.trimSegments(1);
				}
				// a file URI actually represents the file system hierarchy -> no need to look up names on disk
				return new ProjectNameInfo(
						projectUri.lastSegment(),
						projectUri.trimSegments(1).lastSegment());
			}
			throw new IllegalStateException("not a file or platform URI: " + projectUri);
		}
	}

	private ProjectDescriptionUtils() {
		// non-instantiable utility class
	}
}
