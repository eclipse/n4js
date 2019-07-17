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
package org.eclipse.n4js.projectModel.names;

import org.eclipse.n4js.utils.ProjectDescriptionUtils;

import com.google.common.base.Preconditions;

/**
 * A project name of the shape `(@scope/)?name`.
 */
public class N4JSProjectName implements Comparable<N4JSProjectName> {

	private final String name;

	public N4JSProjectName(String name) {
		this.name = Preconditions.checkNotNull(name);
	}

	public String getName() {
		return ProjectDescriptionUtils.getPlainProjectName(name);
	}

	public String getScope() {
		return ProjectDescriptionUtils.getScopeName(name);
	}

	public String getRawName() {
		return name;
	}

	public EclipseProjectName toEclipseProjectName() {
		return new EclipseProjectName(ProjectDescriptionUtils.convertN4JSProjectNameToEclipseProjectName(name));
	}

	public boolean isEmpty() {
		return name.isEmpty();
	}

	@Override
	public int compareTo(N4JSProjectName o) {
		return name.compareTo(o.getRawName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			throw new IllegalArgumentException("Cannot compare to type " + obj.getClass().getName());
		N4JSProjectName other = (N4JSProjectName) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
