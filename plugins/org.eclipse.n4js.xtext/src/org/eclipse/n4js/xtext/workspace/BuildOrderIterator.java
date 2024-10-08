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
package org.eclipse.n4js.xtext.workspace;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.xtext.resource.IResourceDescription;

/**
 * {@link Iterator} that iterates over {@link BuildOrderInfo#sortedProjects}.
 */
public class BuildOrderIterator implements IOrderIterator<ProjectConfigSnapshot> {
	/** The {@link WorkspaceConfigSnapshot} this iterator works with */
	final protected WorkspaceConfigSnapshot wcs;
	/** The {@link BuildOrderInfo} this iterator works with */
	final protected BuildOrderInfo boi;
	/**
	 * Subset of {@link BuildOrderInfo#sortedProjects}: when {@link BuildOrderInfo} is used as an iterator, only those
	 * projects are iterated over that are contained in this set
	 */
	final protected Set<String> visitProjectIDs = new HashSet<>();
	/** Set of all projects that have already visited by this iterator */
	final protected LinkedHashSet<ProjectConfigSnapshot> visitedAlready = new LinkedHashSet<>();

	/** The last visited project or null */
	protected ProjectConfigSnapshot lastVisited;
	/** The iterator index of the next project to visit */
	protected int iteratorIndex = -1;

	/** Constructor */
	public BuildOrderIterator(WorkspaceConfigSnapshot workspaceConfigSnapshot) {
		this.wcs = workspaceConfigSnapshot;
		this.boi = wcs.buildOrderInfo;
	}

	@Override
	public BuildOrderIterator visit(Collection<? extends ProjectConfigSnapshot> projectConfigs) {
		for (ProjectConfigSnapshot pc : projectConfigs) {
			String projectID = pc.getName();

			if (boi.sortedProjects.indexOf(pc) < boi.sortedProjects.indexOf(lastVisited)) {
				// Dependency-inverse visit order not supported. Happens in dependency cycles
			} else {

				visitProjectIDs.add(projectID);
				iteratorIndex = boi.sortedProjects.indexOf(lastVisited);
				moveNext();
			}
		}
		return this;
	}

	/** Mark all projects as to be visited that are affected by a change in the given project. */
	public IOrderIterator<ProjectConfigSnapshot> visitAffected(String projectName) {
		visit(wcs.getProjectsDependingOn(projectName));
		return this;
	}

	@Override
	public BuildOrderIterator visitAffected(List<IResourceDescription.Delta> changes) {
		visit(getAffectedProjects(changes));
		return this;
	}

	@Override
	public BuildOrderIterator visitAll() {
		visit(boi.sortedProjects);
		return this;
	}

	/** @return the set of projects that may contain resources that need to be rebuild given the list of changes */
	protected Set<ProjectConfigSnapshot> getAffectedProjects(List<IResourceDescription.Delta> changes) {
		Set<String> changedProjectIDs = new HashSet<>();
		for (IResourceDescription.Delta change : changes) {
			ProjectConfigSnapshot projectConfig = wcs.findProjectByNestedLocation(change.getUri());
			changedProjectIDs.add(projectConfig.getName());
		}

		Set<ProjectConfigSnapshot> affectedProjects = new HashSet<>();
		for (String changedProjectID : changedProjectIDs) {
			affectedProjects.addAll(wcs.getProjectsDependingOn(changedProjectID));
		}

		return affectedProjects;
	}

	/** @return the current {@link ProjectConfigSnapshot} of this iterator */
	public ProjectConfigSnapshot current() {
		return lastVisited;
	}

	@Override
	public boolean hasNext() {
		if (notStarted()) {
			moveNext();
		}
		return iteratorIndex < boi.sortedProjects.size();
	}

	@Override
	public ProjectConfigSnapshot next() {
		if (notStarted()) {
			moveNext();
		}

		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		ProjectConfigSnapshot next = atIndex();
		visitedAlready.add(next);
		lastVisited = next;

		moveNext();

		return next;
	}

	/** Resets this visitor. I.e. this visitor can be reused. */
	public void reset() {
		iteratorIndex = -1;
		visitedAlready.clear();
		lastVisited = null;
	}

	private ProjectConfigSnapshot atIndex() {
		return boi.sortedProjects.get(iteratorIndex);

	}

	private boolean notStarted() {
		return iteratorIndex < 0;
	}

	private void moveNext() {
		iteratorIndex++;
		while (hasNext() && !visitProjectIDs.contains(atIndex().getName())) {
			iteratorIndex++;
		}
	}
}
