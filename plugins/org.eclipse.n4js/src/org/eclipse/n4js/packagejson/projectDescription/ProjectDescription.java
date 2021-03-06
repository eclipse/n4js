/**
 * Copyright (c) 2021 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.packagejson.projectDescription;

import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.n4js.semver.Semver.VersionNumber;
import org.eclipse.n4js.semver.model.SemverSerializer;
import org.eclipse.n4js.utils.ImmutableDataClass;
import org.eclipse.n4js.workspace.N4JSProjectConfigSnapshot;
import org.eclipse.n4js.workspace.utils.N4JSProjectName;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

/**
 * Basic information about a project, as read from the {@code package.json} file in the project's root folder.
 */
@SuppressWarnings("javadoc")
public class ProjectDescription extends ImmutableDataClass {

	private final String name;
	private final String vendorId;
	private final String vendorName;
	private final VersionNumber version;
	private final String internalVersionStr; // for hash code computation and equality checks
	private final ProjectType type;
	private final String mainModule;
	private final ProjectReference extendedRuntimeEnvironment;
	private final ImmutableList<ProjectReference> providedRuntimeLibraries;
	private final ImmutableList<ProjectReference> requiredRuntimeLibraries;
	private final ImmutableList<ProjectDependency> dependencies;
	private final String implementationId;
	private final ImmutableList<ProjectReference> implementedProjects;
	private final String outputPath;
	private final ImmutableList<SourceContainerDescription> sourceContainers;
	private final ImmutableList<ModuleFilter> moduleFilters;
	private final ImmutableList<ProjectReference> testedProjects;
	private final String definesPackage;
	private final boolean nestedNodeModulesFolder;
	private final boolean n4jsNature;
	private final boolean yarnWorkspaceRoot;
	private final boolean isGeneratorEnabledDts;
	private final ImmutableList<String> workspaces;

	/** Better use a {@link ProjectDescriptionBuilder builder}. */
	public ProjectDescription(String name, String vendorId, String vendorName, VersionNumber version,
			ProjectType type, String mainModule, ProjectReference extendedRuntimeEnvironment,
			Iterable<ProjectReference> providedRuntimeLibraries, Iterable<ProjectReference> requiredRuntimeLibraries,
			Iterable<ProjectDependency> dependencies, String implementationId,
			Iterable<ProjectReference> implementedProjects, String outputPath,
			Iterable<SourceContainerDescription> sourceContainers, Iterable<ModuleFilter> moduleFilters,
			Iterable<ProjectReference> testedProjects, String definesPackage, boolean nestedNodeModulesFolder,
			boolean n4jsNature, boolean yarnWorkspaceRoot,
			boolean isGeneratorEnabledDts, Iterable<String> workspaces) {
		this.name = name;
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.version = version != null ? EcoreUtil.copy(version) : null;
		this.internalVersionStr = version != null ? SemverSerializer.serialize(version) : null;
		this.type = type;
		this.mainModule = mainModule;
		this.extendedRuntimeEnvironment = extendedRuntimeEnvironment;
		this.providedRuntimeLibraries = ImmutableList.copyOf(providedRuntimeLibraries);
		this.requiredRuntimeLibraries = ImmutableList.copyOf(requiredRuntimeLibraries);
		this.dependencies = ImmutableList.copyOf(dependencies);
		this.implementationId = implementationId;
		this.implementedProjects = ImmutableList.copyOf(implementedProjects);
		this.outputPath = outputPath;
		this.sourceContainers = ImmutableList.copyOf(sourceContainers);
		this.moduleFilters = ImmutableList.copyOf(moduleFilters);
		this.testedProjects = ImmutableList.copyOf(testedProjects);
		this.definesPackage = definesPackage;
		this.nestedNodeModulesFolder = nestedNodeModulesFolder;
		this.n4jsNature = n4jsNature;
		this.yarnWorkspaceRoot = yarnWorkspaceRoot;
		this.isGeneratorEnabledDts = isGeneratorEnabledDts;
		this.workspaces = ImmutableList.copyOf(workspaces);
	}

	public ProjectDescription(ProjectDescription template) {
		this.name = template.name;
		this.vendorId = template.vendorId;
		this.vendorName = template.vendorName;
		this.version = template.version != null ? EcoreUtil.copy(template.version) : null;
		this.internalVersionStr = version != null ? SemverSerializer.serialize(version) : null;
		this.type = template.type;
		this.mainModule = template.mainModule;
		this.extendedRuntimeEnvironment = template.extendedRuntimeEnvironment;
		this.providedRuntimeLibraries = template.providedRuntimeLibraries;
		this.requiredRuntimeLibraries = template.requiredRuntimeLibraries;
		this.dependencies = template.dependencies;
		this.implementationId = template.implementationId;
		this.implementedProjects = template.implementedProjects;
		this.outputPath = template.outputPath;
		this.sourceContainers = template.sourceContainers;
		this.moduleFilters = template.moduleFilters;
		this.testedProjects = template.testedProjects;
		this.definesPackage = template.definesPackage;
		this.nestedNodeModulesFolder = template.nestedNodeModulesFolder;
		this.n4jsNature = template.n4jsNature;
		this.yarnWorkspaceRoot = template.yarnWorkspaceRoot;
		this.isGeneratorEnabledDts = template.isGeneratorEnabledDts;
		this.workspaces = template.workspaces;
	}

	/** Builds a new {@link ProjectDescription project description}. */
	public static ProjectDescriptionBuilder builder() {
		return new ProjectDescriptionBuilder();
	}

	public ProjectDescriptionBuilder change() {
		ProjectDescriptionBuilder builder = new ProjectDescriptionBuilder();
		builder.setName(name);
		builder.setVendorId(vendorId);
		builder.setVendorName(vendorName);
		builder.setVersion(version != null ? EcoreUtil.copy(version) : null);
		builder.setType(type);
		builder.setMainModule(mainModule);
		builder.setExtendedRuntimeEnvironment(extendedRuntimeEnvironment);
		builder.getProvidedRuntimeLibraries().addAll(providedRuntimeLibraries);
		builder.getRequiredRuntimeLibraries().addAll(requiredRuntimeLibraries);
		builder.getDependencies().addAll(dependencies);
		builder.setImplementationId(implementationId);
		builder.getImplementedProjects().addAll(implementedProjects);
		builder.setOutputPath(outputPath);
		builder.getSourceContainers().addAll(sourceContainers);
		builder.getModuleFilters().addAll(moduleFilters);
		builder.getTestedProjects().addAll(testedProjects);
		builder.setDefinesPackage(definesPackage);
		builder.setNestedNodeModulesFolder(nestedNodeModulesFolder);
		builder.setN4JSNature(n4jsNature);
		builder.setYarnWorkspaceRoot(yarnWorkspaceRoot);
		builder.getWorkspaces().addAll(workspaces);
		return builder;
	}

	/** The project name, possibly including a scope prefix (e.g. {@code "@someScope/myProject"}). */
	public String getName() {
		return name;
	}

	public N4JSProjectName getN4JSProjectName() {
		return name != null ? new N4JSProjectName(name) : null;
	}

	public String getVendorId() {
		return vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public VersionNumber getVersion() {
		return version;
	}

	public ProjectType getType() {
		return type;
	}

	public String getMainModule() {
		return mainModule;
	}

	public ProjectReference getExtendedRuntimeEnvironment() {
		return extendedRuntimeEnvironment;
	}

	public List<ProjectReference> getProvidedRuntimeLibraries() {
		return providedRuntimeLibraries;
	}

	public List<ProjectReference> getRequiredRuntimeLibraries() {
		return requiredRuntimeLibraries;
	}

	public List<ProjectDependency> getProjectDependencies() {
		return dependencies;
	}

	public String getImplementationId() {
		return implementationId;
	}

	public List<ProjectReference> getImplementedProjects() {
		return implementedProjects;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public List<SourceContainerDescription> getSourceContainers() {
		return sourceContainers;
	}

	public List<ModuleFilter> getModuleFilters() {
		return moduleFilters;
	}

	public List<ProjectReference> getTestedProjects() {
		return testedProjects;
	}

	/**
	 * Returns the name of the package the project provides type definitions for. {@code null} if this project does not
	 * specify the property (i.e. not a type definitions project (cf. {@link ProjectType#DEFINITION}).
	 */
	public String getDefinesPackage() {
		return definesPackage;
	}

	/**
	 * Tells if the project represented by this project description has a nested "node_modules" folder, i.e. a folder
	 * named "node_modules" located right next to the package.json file.
	 */
	public boolean hasNestedNodeModulesFolder() {
		return nestedNodeModulesFolder;
	}

	/**
	 * Indicates whether the underlying project description explicitly configured the project to be an N4JS project
	 * (e.g. includes n4js section).
	 */
	public boolean hasN4JSNature() {
		return n4jsNature;
	}

	/**
	 * Tells whether the project represented by this project description is the root of a yarn workspace. This flag will
	 * be {@code true} iff the package.json contains yarn's top-level property "workspaces", no matter the value (i.e.
	 * will be {@code true} even if the value is the empty array).
	 */
	public boolean isYarnWorkspaceRoot() {
		return yarnWorkspaceRoot;
	}

	/**
	 * Tells whether the generator creates d.ts files.
	 */
	public boolean isGeneratorEnabledDts() {
		return isGeneratorEnabledDts;
	}

	/**
	 * Value of top-level property "workspaces" in package.json, used by yarn to denote the contained projects.
	 */
	public List<String> getWorkspaces() {
		return workspaces;
	}

	@Override
	protected int computeHashCode() {
		return Objects.hash(
				name,
				vendorId,
				vendorName,
				// projectVersion is covered by internalProjectVersionStr
				internalVersionStr,
				type,
				mainModule,
				extendedRuntimeEnvironment,
				providedRuntimeLibraries,
				requiredRuntimeLibraries,
				dependencies,
				implementationId,
				implementedProjects,
				outputPath,
				sourceContainers,
				moduleFilters,
				testedProjects,
				definesPackage,
				nestedNodeModulesFolder,
				n4jsNature,
				yarnWorkspaceRoot,
				isGeneratorEnabledDts,
				workspaces);
	}

	@Override
	protected boolean computeEquals(Object obj) {
		ProjectDescription other = (ProjectDescription) obj;
		return Objects.equals(name, other.name)
				&& Objects.equals(vendorId, other.vendorId)
				&& Objects.equals(vendorName, other.vendorName)
				// version is covered by internalVersionStr
				&& Objects.equals(internalVersionStr, other.internalVersionStr)
				&& type == other.type
				&& Objects.equals(mainModule, other.mainModule)
				&& Objects.equals(extendedRuntimeEnvironment, other.extendedRuntimeEnvironment)
				&& Objects.equals(providedRuntimeLibraries, other.providedRuntimeLibraries)
				&& Objects.equals(requiredRuntimeLibraries, other.requiredRuntimeLibraries)
				&& Objects.equals(dependencies, other.dependencies)
				&& Objects.equals(implementationId, other.implementationId)
				&& Objects.equals(implementedProjects, other.implementedProjects)
				&& Objects.equals(outputPath, other.outputPath)
				&& Objects.equals(sourceContainers, other.sourceContainers)
				&& Objects.equals(moduleFilters, other.moduleFilters)
				&& Objects.equals(testedProjects, other.testedProjects)
				&& Objects.equals(definesPackage, other.definesPackage)
				&& nestedNodeModulesFolder == other.nestedNodeModulesFolder
				&& n4jsNature == other.n4jsNature
				&& yarnWorkspaceRoot == other.yarnWorkspaceRoot
				&& isGeneratorEnabledDts == other.isGeneratorEnabledDts
				&& Objects.equals(workspaces, other.workspaces);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" {\n");
		sb.append("    name: " + name + "\n");
		toStringAdditionalProperties(sb);
		sb.append("    dependencies: [");
		if (dependencies.isEmpty()) {
			sb.append("]\n");
		} else {
			sb.append(' ');
			sb.append(Joiner.on(", ").join(IterableExtensions.map(dependencies, ProjectDependency::getProjectName)));
			sb.append(" ]\n");
		}
		sb.append("    sourceContainers: [");
		if (sourceContainers.isEmpty()) {
			sb.append("]\n");
		} else {
			for (SourceContainerDescription scd : sourceContainers) {
				sb.append("\n        ");
				sb.append(scd.toString());
			}
			sb.append("\n    ]\n");
		}
		sb.append("    moduleFilters: [");
		if (moduleFilters.isEmpty()) {
			sb.append("]\n");
		} else {
			for (ModuleFilter mf : moduleFilters) {
				sb.append("\n        ");
				sb.append(mf.toString());
			}
			sb.append("\n    ]\n");
		}
		sb.append("}");
		return sb.toString();
	}

	/** Factored out from {@link #toString()} only to allow reuse in {@link N4JSProjectConfigSnapshot}. */
	public void toStringAdditionalProperties(StringBuilder sb) {
		sb.append("    type: " + type + "\n");
		sb.append("    version: " + internalVersionStr + "\n");
		sb.append("    mainModule: " + mainModule + "\n");
		if (!testedProjects.isEmpty()) {
			String namesStr = Joiner.on(", ").join(
					IterableExtensions.map(testedProjects, ProjectReference::getProjectName));
			sb.append("    testedProjects: [ " + namesStr + " ]\n");
		}
		if (definesPackage != null) {
			sb.append("    definesPackage: " + definesPackage + "\n");
		}
		if (yarnWorkspaceRoot) {
			sb.append("    yarnWorkspaceRoot: true\n");
		}
		if (!workspaces.isEmpty()) {
			sb.append("    workspaces: [ " + Joiner.on(", ").join(workspaces) + " ]\n");
		}
	}
}
