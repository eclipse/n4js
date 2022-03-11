/**
 * Copyright (c) 2020 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.workspace.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.utils.URIUtils;
import org.eclipse.n4js.workspace.N4JSSourceFolderSnapshotForPackageJson;
import org.eclipse.n4js.xtext.workspace.SourceFolderScanner;
import org.eclipse.n4js.xtext.workspace.SourceFolderSnapshot;
import org.eclipse.xtext.util.IFileSystemScanner;

/**
 * N4JS-specific implementation of {@link SourceFolderScanner}.
 */
public class N4JSSourceFolderScanner extends SourceFolderScanner {

	@Override
	public List<URI> findAllSourceFiles(SourceFolderSnapshot sourceFolder, IFileSystemScanner scanner) {
		if (sourceFolder instanceof N4JSSourceFolderSnapshotForPackageJson) {
			return Collections
					.singletonList(((N4JSSourceFolderSnapshotForPackageJson) sourceFolder).getPackageJsonURI());
		}
		return findAllSourceFilesInFolder(sourceFolder.getPath(), scanner);
	}

	/**
	 * Assuming 'baseFolder' is the path of an N4JS source folder, this method returns all source files in this source
	 * folder. Excludes all files below sub-folders called {@link N4JSGlobals#NODE_MODULES "node_modules"}.
	 *
	 * @return a list of URIs, each representing a source file.
	 */
	public static List<URI> findAllSourceFilesInFolder(URI baseFolder, IFileSystemScanner scanner) {
		return findAllSourceFilesInFolder(baseFolder, scanner, Collections.emptyList(), Collections.emptyList());
	}

	/**
	 * Assuming 'baseFolder' is the path of an N4JS source folder, this method returns all source files in this source
	 * folder. Implements features:
	 * <ul>
	 * <li/>Excludes all files below sub-folders called {@link N4JSGlobals#NODE_MODULES "node_modules"}.
	 * <li/>Includes all files with an n4js file extension.
	 * <li/>Excludes all files matching a glob in {@code globsTsExclude}
	 * <li/>Includes all remaining files iff {@code globsTsInclude} is empty
	 * <li/>or includes only those remaining files matching a glob in {@code globsTsExclude}.
	 * </ul>
	 *
	 * @return a list of URIs, each representing a source file.
	 */
	@SuppressWarnings("resource")
	public static List<URI> findAllSourceFilesInFolder(URI baseFolder, IFileSystemScanner scanner,
			Iterable<String> globsTsInclude, Iterable<String> globsTsExclude) {

		List<PathMatcher> pmInclude = new ArrayList<>();
		List<PathMatcher> pmExclude = new ArrayList<>();
		for (String glob : globsTsInclude) {
			PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
			pmInclude.add(pathMatcher);
		}
		for (String glob : globsTsExclude) {
			PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
			pmExclude.add(pathMatcher);
		}

		List<URI> uris = new ArrayList<>();
		scanner.scan(baseFolder, new FileVisitingAcceptor() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				if (dir.endsWith(N4JSGlobals.NODE_MODULES)) {
					return FileVisitResult.SKIP_SUBTREE;
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public void accept(URI uri) {
				if ((pmInclude.isEmpty() && pmExclude.isEmpty())
						|| N4JSGlobals.ALL_N4JS_FILE_EXTENSIONS.contains(URIUtils.fileExtension(uri))) {
					// 95% case
					uris.add(uri);
					return;
				}

				Path path = Path.of(uri.toFileString());
				for (PathMatcher pm : pmExclude) {
					if (pm.matches(path)) {
						return;
					}
				}
				if (pmInclude.isEmpty()) {
					uris.add(uri);
				} else {
					for (PathMatcher pm : pmInclude) {
						if (pm.matches(path)) {
							uris.add(uri);
						}
					}
				}
			}
		});
		return uris;
	}
}
