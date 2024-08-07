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
package org.eclipse.n4js.ide.tests.builder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import org.eclipse.n4js.ide.tests.helper.server.AbstractIdeTest;
import org.junit.Assert;

/**
 * Abstract base class for tests of the incremental builder in the LSP server.
 */
abstract class AbstractIncrementalBuilderTest extends AbstractIdeTest {

	@Override
	protected boolean enableProjectStatePersister() {
		return true;
	}

	protected FileSnapshot createSnapshotForOutputFile(String moduleName) {
		return createSnapshotForOutputFile(DEFAULT_PROJECT_NAME, moduleName);
	}

	protected FileSnapshot createSnapshotForOutputFile(String projectName, String moduleName) {
		return FileSnapshot.create(getOutputFile(projectName, moduleName));
	}

	protected FileSnapshot createSnapshotForProjectStateFile() {
		return createSnapshotForProjectStateFile(DEFAULT_PROJECT_NAME);
	}

	protected FileSnapshot createSnapshotForProjectStateFile(String projectName) {
		return FileSnapshot.create(getProjectStateFile(projectName));
	}

	protected static final class FileSnapshot {

		private final File file;
		private byte[] content;

		private FileSnapshot(File file) {
			this.file = file;
			update();
		}

		static FileSnapshot create(File parent, String child) {
			return create(new File(parent, child));
		}

		static FileSnapshot create(File file) {
			return new FileSnapshot(file);
		}

		public File getFile() {
			return file;
		}

		public synchronized void update() {
			content = getFileContent(file);
		}

		public synchronized void assertExists() {
			Assert.assertTrue("expected file to exist, but it does not exist: " + file, file.exists());
		}

		public synchronized void assertNotExists() {
			Assert.assertFalse("expected file to not exist, but it exists: " + file, file.exists());
		}

		public synchronized void assertUnchanged() {
			assertExists();
			Assert.assertTrue("expected file to be unchanged, but it has changed: " + file,
					Arrays.equals(content, getFileContent(file)));
		}

		public synchronized void assertChanged() {
			assertExists();
			Assert.assertFalse("expected file to have changed, but it is unchanged: " + file,
					Arrays.equals(content, getFileContent(file)));
		}
	}

	private static byte[] getFileContent(File file) {
		try {
			return Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			throw new AssertionError("error reading from file " + file, e);
		}
	}
}
