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
package org.eclipse.n4js.internal;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.projectDescription.SourceContainerType;
import org.eclipse.n4js.projectModel.IN4JSProject;
import org.eclipse.n4js.projectModel.IN4JSSourceContainer;
import org.eclipse.n4js.utils.URIUtils;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;

/**
 */
@SuppressWarnings("javadoc")
public class N4JSProjectSourceContainer extends AbstractSourceContainer implements IN4JSSourceContainer {

	private final N4JSProject project;

	protected N4JSProjectSourceContainer(N4JSProject project, SourceContainerType type, String relativeLocation) {
		super(type, relativeLocation);
		this.project = project;
	}

	/// ISourceFolder

	@Override
	public String getName() {
		return this.getRelativeLocation();
	}

	@Override
	public URI getPath() {
		return this.getLocation();
	}

	@Override
	public boolean contains(URI uri) {
		URI path = getPath();
		path = path.hasTrailingPathSeparator() ? path : path.appendSegment("");
		uri = uri.hasTrailingPathSeparator() ? uri : uri.appendSegment("");
		if (!uri.toFileString().startsWith(path.toFileString())) {
			return false;
		}
		URI relUri = uri.deresolve(path);
		if (relUri.segmentCount() > 0) {
			boolean uriInsideNodeModules = relUri.segment(0).equals(N4JSGlobals.NODE_MODULES);
			return !uriInsideNodeModules;
		}
		return true;
	}

	@Override
	public List<URI> getAllResources() {
		return FluentIterable.from(this).transform(URIUtils::addEmptyAuthority).toList();
	}
	/// END ISourceFolder

	@Override
	public IN4JSProject getProject() {
		return project;
	}

	@Override
	public Iterator<URI> iterator() {
		return project.getModel().iterator(this);
	}

	@Override
	public URI findArtifact(QualifiedName name, Optional<String> fileExtension) {
		return project.getModel().findArtifact(this, name, fileExtension);
	}

	@Override
	public URI getLocation() {
		List<String> segmentList = Strings.split(getRelativeLocation(), '/');
		String[] segments = segmentList.toArray(new String[segmentList.size()]);
		if (!URI.validSegments(segments)) {
			return null;
		}
		URI result = project.getLocation().appendSegments(segments);
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof N4JSProjectSourceContainer))
			return false;
		N4JSProjectSourceContainer other = (N4JSProjectSourceContainer) obj;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}
}
