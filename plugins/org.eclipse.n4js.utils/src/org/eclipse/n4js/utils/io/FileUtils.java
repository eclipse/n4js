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
package org.eclipse.n4js.utils.io;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.StandardSystemProperty;
import com.google.common.base.Strings;

/**
 * Convenient methods for {@code java.io.File}s.
 */
public abstract class FileUtils {

	private static final DateFormat TIME_STAMP_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmm_ss");

	private FileUtils() {
		// private.
	}

	/**
	 * Returns all regular files below the given root.
	 */
	public static List<Path> getAllRegularFilesIn(Path root) {
		List<Path> result = new ArrayList<>();
		try {
			Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
					if (attrs.isRegularFile()) {
						result.add(path);
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			throw new RuntimeException("exception while collecting regular files in: " + root, e);
		}
		return result;
	}

	/** Same as {@link FileDeleter#delete(File)}. For more options see class {@link FileDeleter}. */
	public static void delete(File resourceToDelete) throws IOException {
		FileDeleter.delete(resourceToDelete);
	}

	/** Same as {@link FileDeleter#delete(Path)}. For more options see class {@link FileDeleter}. */
	public static void delete(Path resourceToDelete) throws IOException {
		FileDeleter.delete(resourceToDelete);
	}

	/** Same as {@link FileCopier#copy(File, File)}. For more options see class {@link FileCopier}. */
	public static void copy(File from, File to) throws IOException {
		FileCopier.copy(from, to);
	}

	/** Same as {@link FileCopier#copy(Path, Path)}. For more options see class {@link FileCopier}. */
	public static void copy(Path from, Path to) throws IOException {
		FileCopier.copy(from, to);
	}

	/** Same as {@link FileMover#move(File, File)}. */
	public static void move(File from, File to) throws IOException {
		FileMover.move(from, to);
	}

	/** Same as {@link FileMover#move(Path, Path)}. */
	public static void move(Path from, Path to) throws IOException {
		FileMover.move(from, to);
	}

	/** Same as {@link #appendToFileName(Path, String)}, but always appends a time stamp. */
	public static Path appendTimeStampToFileName(Path path) {
		String timeStamp = TIME_STAMP_FORMAT.format(new Date());
		return appendToFileName(path, timeStamp);
	}

	/** Append the given string to the path's file name, taking into account file extensions. */
	public static Path appendToFileName(Path path, String str) {
		String name = path.getFileName().toString();
		int extStart = name.lastIndexOf('.');
		String nameNew = extStart >= 0
				? name.substring(0, extStart) + str + name.substring(extStart)
				: name + str;
		Path parent = path.getParent();
		return parent != null
				? parent.resolve(nameNew)
				: Path.of(nameNew);
	}

	/**
	 * Returns with the value of {@code System.getProperty("java.io.tmpdir")}. Never {@code null}.
	 */
	private static final String getTempDirValue() {
		return checkNotNull(StandardSystemProperty.JAVA_IO_TMPDIR.value(), "Null for java.io.tmpdir system property.");
	}

	/**
	 * Returns with the path of the user temporary folder. Never returns with {@code null}.
	 *
	 * @return the path to the temporary folder.
	 */
	public static Path getTempFolder() {
		final File file = new File(getTempDirValue());
		if (!file.exists() || !file.canWrite()) {
			throw new RuntimeException("Cannot access temporary directory under: " + getTempDirValue());
		}
		return file.toPath();
	}

	private static final String getUserHomeValue() {
		return checkNotNull(StandardSystemProperty.USER_HOME.value(), "Null for user.home system property.");
	}

	private static final String getUserHomeValueFailSafe() {
		return StandardSystemProperty.USER_HOME.value();
	}

	/**
	 * Returns with the path of the user home folder. Never returns with {@code null}.
	 *
	 * @return the path to the user home folder.
	 */
	public static Path getUserHomeFolder() {
		final File file = new File(getUserHomeValue());
		if (!file.isDirectory() || !file.canRead()) {
			throw new RuntimeException("Cannot access user home directory under: " + file);
		}
		return file.toPath();
	}

	/**
	 * Returns with the path of the user home folder or <code>null</code> if not available.
	 *
	 * @return the path to the user home folder or <code>null</code>.
	 */
	public static Path getUserHomeFolderFailSafe() {
		final File file = new File(getUserHomeValueFailSafe());
		if (!file.isDirectory() || !file.canRead()) {
			return null;
		}
		return file.toPath();
	}

	/**
	 * Creates a new directory with the given parent folder and folder name. The newly created folder will be deleted on
	 * graceful VM shutdown.
	 *
	 * @param parent
	 *            the path of the parent folder.
	 * @param folderName
	 *            the name of the folder.
	 * @return the path to the new directory.
	 */
	public static Path createDirectory(final Path parent, final String folderName) {
		final File file = new File(parent.toFile(), folderName);
		if (!file.exists()) {
			if (!file.mkdir()) {
				throw new RuntimeException(
						"Error while trying to create folder at " + parent + " with " + folderName + ".");
			}
		}
		file.deleteOnExit();
		return file.toPath();
	}

	/**
	 * Creates a new directory nested with the given parent folder and desredSubPath. The newly created folder will be
	 * deleted on graceful VM shutdown.
	 *
	 * @param parent
	 *            the path of the parent folder.
	 * @param nestedPath
	 *            the nested path to the created folder.
	 * @return the path to the new directory.
	 */
	public static Path createNestedDirectory(final Path parent, final String nestedPath) {
		if (!parent.toFile().isDirectory())
			throw new RuntimeException(
					"Invalid parent at " + parent + ".");

		Path desiredPath = parent.resolve(nestedPath);
		final File file = new File(desiredPath.toUri());
		if (!file.exists())
			if (!file.mkdirs())
				throw new RuntimeException(
						"Error while trying to create folder at " + parent + " with " + nestedPath + ".");

		file.deleteOnExit();
		return file.toPath();
	}

	/**
	 * Creates a new temp directory with the given parent. The newly created folder will be deleted on graceful VM
	 * shutdown.
	 *
	 * @param parent
	 *            the path of the parent folder.
	 * @return the path to the new directory.
	 */
	public static Path createDirectory(final Path parent) {
		File file;
		try {
			file = Files.createTempDirectory(parent, null).toFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		if (!file.exists()) {
			throw new RuntimeException(
					"Error while trying to create folder at " + parent + ".");
		}
		file.deleteOnExit();
		return file.toPath();
	}

	/**
	 * Creates a new temp directory in the java temp folder. The newly created folder will be deleted on graceful VM
	 * shutdown.
	 *
	 * @return the path to the new directory.
	 */
	public static Path createTempDirectory() {
		return createTempDirectory(null);
	}

	/**
	 * Creates a new temp directory in the java temp folder. The newly created folder will use provided prefix for name
	 * and will be deleted on graceful VM shutdown.
	 *
	 * @return the path to the new directory.
	 */
	public static Path createTempDirectory(String prefix) {
		final File parent = new File(getTempDirValue());
		if (!parent.exists() || !parent.canWrite()) {
			throw new RuntimeException("Cannot access temporary directory under: " + getTempDirValue());
		}
		File child;
		try {
			child = Files.createTempDirectory(parent.toPath(), prefix).toFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		if (!child.exists()) {
			throw new RuntimeException(
					"Error while trying to create folder at " + parent + ".");
		}
		child.deleteOnExit();
		return child.toPath();
	}

	/**
	 * Compares the two given files.
	 *
	 * @return -2 if the files are identical, -1 if the files differ in length, or the byte position where the first
	 *         difference of content appears.
	 * @throws IllegalArgumentException
	 *             if expectedFile or actualFile does not exist or is a directory.
	 */
	public static long compareFiles(File expectedFile, File actualFile) {
		if (!expectedFile.exists() || expectedFile.isDirectory()) {
			throw new IllegalArgumentException("expectedFile does not exist or is a directory");
		}
		if (!actualFile.exists() || actualFile.isDirectory()) {
			throw new IllegalArgumentException("actualFile does not exist or is a directory");
		}

		if (actualFile.length() != expectedFile.length()) {
			return -1;
		}
		try (InputStream inActual = new BufferedInputStream(new FileInputStream(actualFile));
				InputStream inExpected = new BufferedInputStream(new FileInputStream(expectedFile))) {
			int b;
			long pos = 0;
			while ((b = inActual.read()) >= 0) {
				if (b != inExpected.read()) {
					return pos;
				}
				pos++;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return -2;
	}

	/**
	 * Deep comparison of the two given directory trees. Differences are reported via the given
	 * {@link IDirectoryDiffAcceptor}.
	 *
	 * @throws IllegalArgumentException
	 *             if expectedRoot or actualRoot does not exist or isn't a directory.
	 */
	public static void compareDirectories(File expectedRoot, File actualRoot, IDirectoryDiffAcceptor acceptor)
			throws IOException {

		if (!expectedRoot.exists() || !expectedRoot.isDirectory()) {
			throw new IllegalArgumentException("expectedRoot does not exist or is not a directory");
		}
		if (!actualRoot.exists() || !actualRoot.isDirectory()) {
			throw new IllegalArgumentException("actualRoot does not exist or is not a directory");
		}

		final Path expectedRootPath = expectedRoot.toPath();
		final Path actualRootPath = actualRoot.toPath();
		final Set<Path> expectedContents = Files.walk(expectedRootPath).collect(Collectors.toSet());
		Files.walk(actualRootPath).forEach(actualPath -> {
			final Path relativePath = actualRootPath.relativize(actualPath);
			final Path expectedPath = expectedRootPath.resolve(relativePath);
			if (expectedContents.remove(expectedPath)) {
				// expectedPath was contained in expectedContents
				final File expectedFile = expectedPath.toFile();
				final File actualFile = actualPath.toFile();
				if (expectedFile.isDirectory()) {
					// expecting a directory ...
					if (actualFile.isDirectory()) {
						// ... and got a directory; ok!
						// -> nothing to be done
					} else {
						// ... and got a file; error!
						acceptor.fileInsteadOfDirectory(relativePath);
					}
				} else {
					// expecting an ordinary file ...
					if (actualFile.isDirectory()) {
						// ... and got a directory; error!
						acceptor.directoryInsteadOfFile(relativePath);
					} else {
						// ... and got a file; ok!
						// -> compare contents
						final long diffPos = compareFiles(expectedFile, actualFile);
						if (diffPos == -1) {
							acceptor.differentLength(relativePath);
						} else if (diffPos >= 0) {
							acceptor.differentContent(relativePath, diffPos);
						}
					}
				}
			} else {
				// expectedPath was *not* contained in expectedContents
				acceptor.unexpected(relativePath);
			}
		});
		// remaining paths in expectedContents are missing
		expectedContents.stream().forEach(expectedPath -> {
			final Path relativePath = expectedRootPath.relativize(expectedPath);
			acceptor.missing(relativePath);
		});
	}

	/**
	 * Delete a file or a possibly non-empty folder on JVM exit using {@link File#deleteOnExit()}
	 *
	 * @param file
	 *            file or folder to be deleted
	 */
	public static void onExitDeleteFileOrFolder(File file) {
		file.deleteOnExit();
		if (file.isDirectory()) {
			File[] childFildes = file.listFiles();
			for (int i = 0; i < childFildes.length; i++) {
				onExitDeleteFileOrFolder(childFildes[i]);
			}
		}
	}

	/** Same as {@link #cleanFolder(File)}, accepting a {@link Path}. */
	public static void cleanFolder(Path folder) throws IOException {
		cleanFolder(folder.toFile());
	}

	/**
	 * Clean a possibly non-empty folder. This method does not remove the folder itself but only empty its content.
	 *
	 * @param folder
	 *            the folder to be cleaned
	 */
	public static void cleanFolder(File folder) throws IOException {
		if (!folder.isDirectory()) {
			throw new IllegalArgumentException("not a folder: " + folder);
		}
		File[] childFiles = folder.listFiles();
		for (int i = 0; i < childFiles.length; i++) {
			delete(childFiles[i]);
		}
	}

	/** @return the normalized version of the given path. If the given path is null, null is returned. */
	public static String normalize(String path) {
		String normalized = null;
		if (path != null) {
			normalized = Paths.get(path).normalize().toString();
		}
		return normalized;
	}

	/** @return @see {@link #normalize(String)}, but iff the normalized path is empty then {@code .} is returned */
	public static String normalizeToDotWhenEmpty(String path) {
		String normalized = normalize(path);
		if (normalized != null && normalized.isEmpty()) {
			normalized = ".";
		}
		return normalized;
	}

	/** @return a serialized file tree starting from the given root. */
	public static String serializeFileTree(File root) {
		return serializeFileTree(root, 0);
	}

	private static String serializeFileTree(File root, int indentLevel) {
		String indentStr = Strings.repeat(" ", Math.max(0, indentLevel - 1) * 2);
		if (root.isFile()) {
			indentStr += (indentLevel > 0) ? "- " : "";
			return indentStr + root.getName() + "\n";
		}
		if (root.isDirectory()) {
			String subtree = "";
			File[] childFildes = root.listFiles();
			Arrays.sort(childFildes, Comparator.comparing(File::isDirectory).thenComparing(File::getName));
			for (int i = 0; i < childFildes.length; i++) {
				subtree += serializeFileTree(childFildes[i], indentLevel + 1);
			}
			indentStr += (indentLevel > 0) ? "+ " : "";
			return indentStr + root.getName() + "\n" + subtree;
		}
		return "";
	}

}
