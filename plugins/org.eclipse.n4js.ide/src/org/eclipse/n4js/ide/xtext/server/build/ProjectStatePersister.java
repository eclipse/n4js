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
package org.eclipse.n4js.ide.xtext.server.build;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.n4js.ide.xtext.server.QueuedExecutorService;
import org.eclipse.n4js.projectModel.locations.FileURI;
import org.eclipse.n4js.utils.URIUtils;
import org.eclipse.n4js.xtext.server.LSPIssue;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;
import org.eclipse.xtext.resource.persistence.SerializableReferenceDescription;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Allows to read / write the state of a compiled project to disk to sport incremental builds after a restart of the
 * compiler process. The first byte in the written binary file indicates the version of the file. The file format is
 * documented per version.
 */
@SuppressWarnings({ "restriction", "deprecation" })
@Singleton
public class ProjectStatePersister {
	private static final Logger LOG = LogManager.getLogger(ProjectStatePersister.class);

	/** Data holder class of project state */
	static public class ProjectState {
		/** Type index */
		final public ResourceDescriptionsData index;
		/** File Mappings */
		final public XSource2GeneratedMapping fileMappings;
		/** Hashes to indicate file changes */
		final public Map<URI, HashedFileContent> fileHashs;
		/** Hashes to indicate file changes */
		final public ListMultimap<URI, LSPIssue> validationIssues;

		/** Constructor */
		public ProjectState(ResourceDescriptionsData index, XSource2GeneratedMapping fileMappings,
				Map<URI, HashedFileContent> fileHashs, ListMultimap<URI, LSPIssue> validationIssues) {

			this.index = index;
			this.fileMappings = fileMappings;
			this.fileHashs = fileHashs;
			this.validationIssues = validationIssues;
		}

		/** @return a copied instance of this with copied field values */
		public ProjectState copy() {
			return new ProjectState(
					index.copy(),
					fileMappings.copy(),
					ImmutableMap.copyOf(fileHashs),
					ImmutableListMultimap.copyOf(validationIssues));
		}
	}

	/**
	 * After the version, the stream contains a zipped, data stream of the following shape:
	 *
	 * <pre>
	 * - Language version as per {@link #getLanguageVersion() getLanguageVersion}
	 * - Number #r of resource descriptions
	 * - #r times a serializable resource description as per {@link #writeResourceDescription(SerializableResourceDescription, DataOutput)}
	 * - A mapping of generated URIs as per {@link Source2GeneratedMapping#writeExternal(java.io.ObjectOutput) Source2GeneratedMapping.writeExternal}
	 * - Number #f of fingerprints per URI
	 * - #f times a fingerprint as per {@link HashedFileContent#write(DataOutput) HashedFileContent.write}
	 * - Number #vs of source files that have issues
	 * - #vs times:
	 * 	- source URI
	 * 	- Number #vi of issues of source
	 * 	- #vi times a validation issue as per {@link LSPIssue#writeExternal(DataOutput) LSPIssue.writeExternal}
	 * </pre>
	 */
	private static final int VERSION_2 = 2;

	/** The current version of the persistence format. Increment to support backwards compatible deserialization. */
	private static final int CURRENT_VERSION = VERSION_2;

	@Inject
	private QueuedExecutorService queuedExecutorService;

	/** @return the simple name of the file with the project state. */
	public String getPersistedFileName() {
		return ".projectstate";
	}

	/**
	 * The language version changes (i.e. must change) iff any of the persisted languages changes the serialization of
	 * its persisted state.
	 *
	 * @return the version string to distinguish persisted files with different serialization
	 */
	public String getLanguageVersion() {
		return "1";
	}

	/**
	 * Write the index state and a hash of the project state to disk in order to allow loading it again.
	 *
	 * @param project
	 *            the project
	 * @param state
	 *            the state to be written
	 */
	public void writeProjectState(IProjectConfig project, ProjectState state) {
		ProjectState stateCopy = state.copy();
		asyncWriteProjectState(project, stateCopy);
	}

	private void asyncWriteProjectState(IProjectConfig project, ProjectState state) {
		queuedExecutorService.submit(ProjectStatePersister.class, "asyncWriteProjectState", (ignore) -> {
			File file = getDataFile(project);
			try (OutputStream nativeOut = Files.asByteSink(file).openBufferedStream()) {
				writeProjectState(nativeOut, state);
			} catch (IOException e) {
				e.printStackTrace();
				if (file.isFile()) {
					file.delete();
				}
			}
			return null;
		});
	}

	/**
	 * @param stream
	 *            the output stream. Will not be closed.
	 * @param state
	 *            the state to be written
	 * @throws IOException
	 *             if things go bananas.
	 */
	public void writeProjectState(OutputStream stream, ProjectState state)
			throws IOException {

		String languageVersion = getLanguageVersion();
		LOG.info("write project state (file version " + languageVersion + ")");
		stream.write(CURRENT_VERSION);
		try (DataOutputStream output = new DataOutputStream(
				new BufferedOutputStream(new GZIPOutputStream(stream, 8192)))) {

			output.writeUTF(languageVersion);

			writeResourceDescriptions(state, output);

			writeFileMappings(state, output);

			writeFingerprints(state, output);

			writeValidationIssues(state, output);
		}
	}

	private void writeResourceDescriptions(ProjectState state, DataOutput output) throws IOException {
		output.writeInt(state.index.getAllURIs().size());
		for (IResourceDescription description : state.index.getAllResourceDescriptions()) {
			if (description instanceof SerializableResourceDescription) {
				writeResourceDescription((SerializableResourceDescription) description, output);
			} else {
				throw new IOException("Unexpected type: " + description.getClass().getName());
			}
		}
	}

	private void writeResourceDescription(SerializableResourceDescription description, DataOutput output)
			throws IOException {

		// description.writeExternal(output);
		// relies on writeObject which is very slow

		output.writeUTF(description.getURI().toString());
		writeEObjectDescriptions(description, output);
		writeReferenceDescriptions(description, output);
		writeImportedNames(description, output);
	}

	private void writeImportedNames(SerializableResourceDescription resourceDescription, DataOutput output)
			throws IOException {

		List<QualifiedName> importedNames = IterableExtensions.toList(resourceDescription.getImportedNames());
		output.writeInt(importedNames.size());
		for (QualifiedName importedName : importedNames) {
			writeQualifiedName(importedName, output);
		}
	}

	private void writeReferenceDescriptions(SerializableResourceDescription resourceDescription, DataOutput output)
			throws IOException {

		List<SerializableReferenceDescription> references = resourceDescription.getReferences();
		output.writeInt(references.size());
		for (SerializableReferenceDescription reference : references) {
			output.writeUTF(reference.getSourceEObjectUri().toString());
			output.writeUTF(reference.getTargetEObjectUri().toString());
			output.writeUTF(reference.getContainerEObjectURI().toString());
			output.writeUTF(EcoreUtil.getURI(reference.getEReference()).toString());
			output.writeInt(reference.getIndexInList());
		}
	}

	private void writeEObjectDescriptions(SerializableResourceDescription resourceDescription, DataOutput output)
			throws IOException {

		List<SerializableEObjectDescription> objects = resourceDescription.getDescriptions();
		output.writeInt(objects.size());
		for (SerializableEObjectDescription object : objects) {
			output.writeUTF(object.getEObjectURI().toString());
			output.writeUTF(EcoreUtil.getURI(object.getEClass()).toString());
			QualifiedName qn = object.getQualifiedName();
			writeQualifiedName(qn, output);
			Map<String, String> userData = object.getUserData();
			if (userData != null) {
				output.writeInt(userData.size());
				for (Map.Entry<String, String> entry : userData.entrySet()) {
					output.writeUTF(entry.getKey());
					writeUserDataValue(entry.getValue(), output);
				}
			} else {
				output.writeInt(0);
			}
		}
	}

	private void writeUserDataValue(String value, DataOutput output) throws IOException {
		// User data tends to be very long but the value in output.writeUTF is written as a short
		// therefore we need to do it manually for this string
		byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
		output.writeInt(bytes.length);
		output.write(bytes);
	}

	private void writeQualifiedName(QualifiedName qualifiedName, DataOutput output) throws IOException {
		output.writeInt(qualifiedName.getSegmentCount());
		for (int i = 0, max = qualifiedName.getSegmentCount(); i < max; i++) {
			output.writeUTF(qualifiedName.getSegment(i));
		}
	}

	private void writeFileMappings(ProjectState state, DataOutputStream output) throws IOException {
		state.fileMappings.writeExternal(output);
	}

	private void writeFingerprints(ProjectState state, DataOutput output) throws IOException {
		Collection<HashedFileContent> files = state.fileHashs.values();
		output.writeInt(files.size());
		for (HashedFileContent fingerprint : files) {
			fingerprint.write(output);
		}
	}

	private void writeValidationIssues(ProjectState state, DataOutput output) throws IOException {
		Set<URI> allSources = state.validationIssues.keySet();
		int numberSources = allSources.size();
		output.writeInt(numberSources);
		for (URI source : allSources) {
			Collection<? extends LSPIssue> issues = state.validationIssues.get(source);

			output.writeUTF(source.toString());

			int numberIssues = issues.size();
			output.writeInt(numberIssues);
			for (LSPIssue issue : issues) {
				issue.writeExternal(output);
			}
		}
	}

	/**
	 * Read the index state as it was written to disk for the given project.
	 *
	 * @param project
	 *            the project
	 */
	public ProjectState readProjectState(IProjectConfig project) {
		File file = getDataFile(project);
		try {
			if (file.isFile()) {
				try (InputStream nativeIn = Files.asByteSource(file).openBufferedStream()) {
					ProjectState result = readProjectState(nativeIn);
					if (result == null && file.isFile()) {
						file.delete();
					}
					return result;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			if (file.isFile()) {
				file.delete();
			}
		}
		return null;
	}

	/**
	 * @param stream
	 *            the stream to read from.
	 * @throws IOException
	 *             if things go bananas.
	 * @throws ClassNotFoundException
	 *             if things go bananas.
	 */
	public ProjectState readProjectState(InputStream stream)
			throws IOException, ClassNotFoundException {

		int version = stream.read();
		if (version != CURRENT_VERSION) {
			return null;
		}

		try (DataInputStream input = new DataInputStream(new BufferedInputStream(new GZIPInputStream(stream, 8192)))) {
			String languageVersion = input.readUTF();
			if (!getLanguageVersion().equals(languageVersion)) {
				return null;
			}
			ResourceDescriptionsData resourceDescriptionsData = readResourceDescriptions(input);

			XSource2GeneratedMapping fileMappings = readFileMappings(input);

			Map<URI, HashedFileContent> fingerprints = readFingerprints(input);

			ListMultimap<URI, LSPIssue> validationIssues = readValidationIssues(input);

			return new ProjectState(resourceDescriptionsData, fileMappings, fingerprints, validationIssues);
		}
	}

	private ResourceDescriptionsData readResourceDescriptions(DataInput input) throws IOException {
		List<IResourceDescription> descriptions = new ArrayList<>();
		int size = input.readInt();
		while (size > 0) {
			size--;
			descriptions.add(readResourceDescription(input));
		}
		return new ResourceDescriptionsData(descriptions);
	}

	private ENamedElement readEcoreElement(DataInput input) throws IOException {
		URI uri = URI.createURI(input.readUTF());
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri.trimFragment().toString());
		if (ePackage != null) {
			Resource resource = ePackage.eResource();
			return (ENamedElement) resource.getEObject(uri.fragment());
		}
		return null;
	}

	private SerializableResourceDescription readResourceDescription(DataInput input) throws IOException {
		SerializableResourceDescription result = new SerializableResourceDescription();
		result.setURI(URI.createURI(input.readUTF()));
		result.setDescriptions(readEObjectDescriptions(input));
		result.setReferences(readReferenceDescriptions(input));
		result.setImportedNames(readImportedNames(input));
		return result;
	}

	private List<QualifiedName> readImportedNames(DataInput input) throws IOException {
		int size = input.readInt();
		if (size == 0) {
			return Collections.emptyList();
		}
		List<QualifiedName> result = new ArrayList<>(size);
		while (size > 0) {
			size--;
			result.add(readQualifiedName(input));
		}
		return result;
	}

	private List<SerializableReferenceDescription> readReferenceDescriptions(DataInput input) throws IOException {
		int size = input.readInt();
		if (size == 0) {
			return Collections.emptyList();
		}
		List<SerializableReferenceDescription> result = new ArrayList<>(size);
		while (size > 0) {
			size--;
			SerializableReferenceDescription reference = new SerializableReferenceDescription();
			reference.setSourceEObjectUri(URI.createURI(input.readUTF()));
			reference.setTargetEObjectUri(URI.createURI(input.readUTF()));
			reference.setContainerEObjectURI(URI.createURI(input.readUTF()));
			reference.setEReference((EReference) readEcoreElement(input));
			reference.setIndexInList(input.readInt() - 1);
			result.add(reference);
		}
		return result;
	}

	private List<SerializableEObjectDescription> readEObjectDescriptions(DataInput input) throws IOException {
		int size = input.readInt();
		if (size == 0) {
			return Collections.emptyList();
		}
		List<SerializableEObjectDescription> result = new ArrayList<>(size);
		while (size > 0) {
			size--;
			SerializableEObjectDescription object = new SerializableEObjectDescription();
			object.setEObjectURI(URI.createURI(input.readUTF()));
			object.setEClass((EClass) readEcoreElement(input));
			object.setQualifiedName(readQualifiedName(input));
			int userDataSize = input.readInt();
			HashMap<String, String> userData = new HashMap<>();
			while (userDataSize > 0) {
				userDataSize--;
				String key = input.readUTF();
				userData.put(key, readUserDataValue(input));
			}
			object.setUserData(userData);
			result.add(object);
		}
		return result;
	}

	private String readUserDataValue(DataInput input) throws IOException {
		byte[] value = new byte[input.readInt()];
		input.readFully(value);
		return new String(value, StandardCharsets.UTF_8);
	}

	private QualifiedName readQualifiedName(DataInput input) throws IOException {
		int size = input.readInt();
		QualifiedName.Builder builder = new QualifiedName.Builder(size);
		while (size > 0) {
			size--;
			builder.add(input.readUTF());
		}
		return builder.build();
	}

	private XSource2GeneratedMapping readFileMappings(DataInput input) throws IOException {
		XSource2GeneratedMapping fileMappings = new XSource2GeneratedMapping();
		fileMappings.readExternal(input);
		return fileMappings;
	}

	private Map<URI, HashedFileContent> readFingerprints(DataInput input) throws IOException {
		int size = input.readInt();
		Map<URI, HashedFileContent> fingerprints = new HashMap<>(size);
		while (size > 0) {
			size--;
			HashedFileContent hashFileContent = new HashedFileContent(input);
			fingerprints.put(hashFileContent.getUri(), hashFileContent);
		}
		return fingerprints;
	}

	private ListMultimap<URI, LSPIssue> readValidationIssues(DataInput input) throws IOException {
		int numberOfSources = input.readInt();
		ListMultimap<URI, LSPIssue> validationIssues = ArrayListMultimap.create();
		while (numberOfSources > 0) {
			numberOfSources--;
			URI source = URI.createURI(input.readUTF());
			int numberOfIssues = input.readInt();
			List<LSPIssue> issuesPerResource = validationIssues.get(source);
			while (numberOfIssues > 0) {
				numberOfIssues--;
				LSPIssue issue = new LSPIssue();
				issue.readExternal(input);
				issuesPerResource.add(issue);
			}
		}
		return validationIssues;
	}

	private File getDataFile(IProjectConfig project) {
		URI fileName = getFileName(project);
		File file = URIUtils.toFile(fileName);
		return file;
	}

	/** @return the file URI of the persisted index */
	public URI getFileName(IProjectConfig project) {
		String fileName = getPersistedFileName();
		URI rootPath = project.getPath();
		return new FileURI(rootPath).appendSegment(fileName).toURI();
	}
}
