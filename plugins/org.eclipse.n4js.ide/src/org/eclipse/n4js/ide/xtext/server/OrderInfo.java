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
package org.eclipse.n4js.ide.xtext.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ProjectDescription;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 *
 */
public class OrderInfo implements IOrderInfo<ProjectDescription> {

	/** A provider for {@link OrderInfo} instances. */
	public static class Provider implements com.google.inject.Provider<IOrderInfo<ProjectDescription>> {
		@Inject
		protected Injector injector;

		/** Returns a new instanceof of {@link OrderInfo} */
		@Override
		public IOrderInfo<ProjectDescription> get() {
			return injector.getInstance(OrderInfo.class);
		}

		public IOrderInfo<ProjectDescription> get(Collection<ProjectDescription> projectDescriptions) {
			IOrderInfo<ProjectDescription> orderInfo = get();
			orderInfo.visit(projectDescriptions);
			return orderInfo;
		}
	}

	@Inject
	protected XWorkspaceManager workspaceManager;

	final protected Multimap<String, ProjectDescription> inversedDependencies = HashMultimap.create();
	final protected List<ProjectDescription> sortedProjects = new ArrayList<>();
	final protected Set<String> visitProjectNames = new HashSet<>();

	@Override
	public Iterator<ProjectDescription> iterator() {
		return Iterables.filter(sortedProjects, input -> visitProjectNames.contains(input.getName())).iterator();
	}

	@Override
	public void visit(Collection<ProjectDescription> projectDescriptions) {
		for (ProjectDescription prj : projectDescriptions) {
			visitProjectNames.add(prj.getName());
		}
	}

	@Override
	public void visitAffected(List<IResourceDescription.Delta> changes) {
		visit(getAffectedProjects(changes));
	}

	@Override
	public void visitAll() {
		visit(sortedProjects);
	}

	@Inject
	protected void init() {
		LinkedHashSet<String> orderedProjectNames = new LinkedHashSet<>();
		for (XProjectManager pm : workspaceManager.getProjectManagers()) {
			ProjectDescription pd = pm.getProjectDescription();
			for (String dependencyName : pd.getDependencies()) {
				inversedDependencies.put(dependencyName, pd);
			}
			computeOrder(pd, orderedProjectNames, new LinkedHashSet<>());
		}

		for (String projectName : orderedProjectNames) {
			sortedProjects.add(workspaceManager.getProjectManager(projectName).getProjectDescription());
		}
	}

	protected void computeOrder(ProjectDescription pd, LinkedHashSet<String> orderedProjects,
			LinkedHashSet<String> projectStack) {

		String pdName = pd.getName();
		if (projectStack.contains(pdName)) {
			for (String cyclicPD : projectStack) {
				reportDependencyCycle(cyclicPD);
			}
		} else {
			projectStack.add(pdName);

			for (String depName : pd.getDependencies()) {
				ProjectDescription depPd = workspaceManager.getProjectManager(depName).getProjectDescription();
				computeOrder(depPd, orderedProjects, projectStack);
			}

			orderedProjects.add(pdName);
			projectStack.remove(pdName);
		}
	}

	protected Set<ProjectDescription> getAffectedProjects(List<IResourceDescription.Delta> changes) {
		Set<String> changedProjectsNames = new HashSet<>();
		for (IResourceDescription.Delta change : changes) {
			change.getUri();
			XProjectManager projectManager = workspaceManager.getProjectManager(change.getUri());
			ProjectDescription pd = projectManager.getProjectDescription();
			changedProjectsNames.add(pd.getName());
		}

		Set<ProjectDescription> affectedProjects = new HashSet<>();
		for (String changedProjectName : changedProjectsNames) {
			affectedProjects.addAll(inversedDependencies.get(changedProjectName));
		}

		return affectedProjects;
	}

	/** Report cycle. */
	protected void reportDependencyCycle(String projectName) {
		XProjectManager projectManager = workspaceManager.getProjectManager(projectName);
		String msg = "Project has cyclic dependencies";
		projectManager.reportProjectIssue(msg, XBuildManager.CYCLIC_PROJECT_DEPENDENCIES, Severity.ERROR);
	}
}