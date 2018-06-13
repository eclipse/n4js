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
package org.eclipse.n4js.ui.internal;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.n4js.binaries.BinariesPreferenceStore;
import org.eclipse.n4js.binaries.BinariesProvider;
import org.eclipse.n4js.binaries.BinariesValidator;
import org.eclipse.n4js.binaries.BinaryCommandFactory;
import org.eclipse.n4js.binaries.OsgiBinariesPreferenceStore;
import org.eclipse.n4js.binaries.nodejs.NodeBinaryLocatorHelper;
import org.eclipse.n4js.binaries.nodejs.NodeJsBinary;
import org.eclipse.n4js.binaries.nodejs.NodeProcessBuilder;
import org.eclipse.n4js.binaries.nodejs.NpmBinary;
import org.eclipse.n4js.binaries.nodejs.NpmrcBinary;
import org.eclipse.n4js.external.EclipseTargetPlatformInstallLocationProvider;
import org.eclipse.n4js.external.ExternalIndexSynchronizer;
import org.eclipse.n4js.external.ExternalLibraryUriHelper;
import org.eclipse.n4js.external.ExternalLibraryWorkspace;
import org.eclipse.n4js.external.ExternalProjectsCollector;
import org.eclipse.n4js.external.GitCloneSupplier;
import org.eclipse.n4js.external.NpmLogger;
import org.eclipse.n4js.external.RebuildWorkspaceProjectsScheduler;
import org.eclipse.n4js.external.TargetPlatformInstallLocationProvider;
import org.eclipse.n4js.external.TypeDefinitionGitLocationProvider;
import org.eclipse.n4js.external.TypeDefinitionGitLocationProvider.TypeDefinitionGitLocationProviderImpl;
import org.eclipse.n4js.generator.IWorkspaceMarkerSupport;
import org.eclipse.n4js.internal.FileBasedExternalPackageManager;
import org.eclipse.n4js.internal.InternalN4JSWorkspace;
import org.eclipse.n4js.internal.N4JSModel;
import org.eclipse.n4js.preferences.ExternalLibraryPreferenceStore;
import org.eclipse.n4js.preferences.OsgiExternalLibraryPreferenceStore;
import org.eclipse.n4js.projectModel.IN4JSCore;
import org.eclipse.n4js.ts.validation.TypesKeywordProvider;
import org.eclipse.n4js.ui.containers.CompositeStorage2UriMapperContribution;
import org.eclipse.n4js.ui.containers.N4JSExternalLibraryStorage2UriMapperContribution;
import org.eclipse.n4js.ui.containers.N4JSToBeBuiltComputer;
import org.eclipse.n4js.ui.containers.NfarStorageMapper;
import org.eclipse.n4js.ui.external.BuildOrderComputer;
import org.eclipse.n4js.ui.external.EclipseExternalIndexSynchronizer;
import org.eclipse.n4js.ui.external.EclipseExternalLibraryWorkspace;
import org.eclipse.n4js.ui.external.ExternalIndexUpdater;
import org.eclipse.n4js.ui.external.ExternalLibraryBuildQueue;
import org.eclipse.n4js.ui.external.ExternalLibraryBuildScheduler;
import org.eclipse.n4js.ui.external.ExternalLibraryBuilder;
import org.eclipse.n4js.ui.external.ExternalLibraryErrorMarkerManager;
import org.eclipse.n4js.ui.external.ExternalProjectProvider;
import org.eclipse.n4js.ui.external.ProjectStateChangeListener;
import org.eclipse.n4js.ui.navigator.N4JSProjectExplorerLabelProvider;
import org.eclipse.n4js.ui.navigator.internal.N4JSProjectExplorerHelper;
import org.eclipse.n4js.ui.projectModel.IN4JSEclipseCore;
import org.eclipse.n4js.ui.quickfix.N4JSQuickfixProvider;
import org.eclipse.n4js.ui.scoping.builtin.ScopeInitializer;
import org.eclipse.n4js.ui.workingsets.WorkingSetManagerBroker;
import org.eclipse.n4js.ui.workingsets.WorkingSetManagerBrokerImpl;
import org.eclipse.n4js.ui.workingsets.WorkingSetManagerModificationStrategyProvider;
import org.eclipse.n4js.ui.workingsets.WorkingSetManualAssociationWizard;
import org.eclipse.n4js.ui.workingsets.WorkingSetProjectNameFilterWizard;
import org.eclipse.n4js.ui.workingsets.WorkspaceRepositoriesProvider;
import org.eclipse.n4js.utils.InjectorCollector;
import org.eclipse.n4js.utils.StatusHelper;
import org.eclipse.n4js.utils.process.OutputStreamPrinterThreadProvider;
import org.eclipse.n4js.utils.process.OutputStreamProvider;
import org.eclipse.n4js.utils.process.ProcessExecutor;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.resource.IResourceSetInitializer;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperContribution;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.name.Names;

/**
 * The following bindings are used by the shared injector.
 * <p>
 * Do not use the method {@link ScopedBindingBuilder#in(Class) in(SINGLETON)} or similar to declare a singleton scope.
 * Use the annotation {@code @Singleton} instead in the bound class itself. The reason is that the test for singleton
 * validation {@code MultipleSingletonPluginTest} only respects annotations.
 */
@SuppressWarnings("restriction")
public class ContributingModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(InjectorCollector.class);

		binder.bind(IToBeBuiltComputerContribution.class).to(N4JSToBeBuiltComputer.class);
		binder.bind(IStorage2UriMapperContribution.class).to(CompositeStorage2UriMapperContribution.class);
		binder.bind(NfarStorageMapper.class);
		binder.bind(InternalN4JSWorkspace.class).to(EclipseBasedN4JSWorkspace.class);
		binder.bind(EclipseBasedN4JSWorkspace.class);
		binder.bind(IWorkspaceRoot.class).toProvider(new Provider<IWorkspaceRoot>() {
			@Inject
			IWorkspace workspace;

			@SuppressWarnings("unused")
			@Inject
			InjectorCollector injectorCollector; // used to collect the injector

			@Override
			public IWorkspaceRoot get() {
				return workspace.getRoot();
			}
		});
		binder.bind(StatusHelper.class);
		binder.bind(TargetPlatformInstallLocationProvider.class).to(EclipseTargetPlatformInstallLocationProvider.class);
		binder.bind(GitCloneSupplier.class);
		binder.bind(TypeDefinitionGitLocationProvider.class).to(TypeDefinitionGitLocationProviderImpl.class);

		binder.bind(IN4JSCore.class).to(N4JSEclipseCore.class);
		binder.bind(IN4JSEclipseCore.class).to(N4JSEclipseCore.class);
		binder.bind(N4JSEclipseCore.class);
		binder.bind(N4JSModel.class).to(N4JSEclipseModel.class);
		binder.bind(N4JSEclipseModel.class);
		binder.bind(MarkerCreator.class);

		binder.bind(ExternalLibraryWorkspace.class).to(EclipseExternalLibraryWorkspace.class);
		binder.bind(EclipseExternalLibraryWorkspace.class);
		binder.bind(ExternalIndexSynchronizer.class).to(EclipseExternalIndexSynchronizer.class);
		binder.bind(EclipseExternalIndexSynchronizer.class);

		binder.bind(ExternalProjectCacheLoader.class);
		binder.bind(ProjectStateChangeListener.class);
		binder.bind(ExternalIndexUpdater.class);
		binder.bind(ExternalLibraryBuildScheduler.class);
		binder.bind(ExternalLibraryBuilder.class);
		binder.bind(ExternalLibraryBuildQueue.class);
		binder.bind(BuildOrderComputer.class);
		binder.bind(NpmLogger.class);
		binder.bind(OutputStreamProvider.class).to(ConsoleOutputStreamProvider.class);
		binder.bind(ConsoleOutputStreamProvider.class);
		binder.bind(ExternalProjectsCollector.class);
		binder.bind(ExternalProjectProvider.class);
		binder.bind(RebuildWorkspaceProjectsScheduler.class);

		binder.bind(N4JSExternalLibraryStorage2UriMapperContribution.class);
		binder.bind(ExternalLibraryUriHelper.class);
		binder.bind(FileBasedExternalPackageManager.class);
		binder.bind(ExternalLibraryPreferenceStore.class).to(OsgiExternalLibraryPreferenceStore.class);
		binder.bind(OsgiExternalLibraryPreferenceStore.class);
		binder.bind(XtextResourceSet.class);
		binder.bind(ProjectDescriptionLoadListener.class);
		binder.bind(IEagerContribution.class).to(ProjectDescriptionLoadListener.class);
		binder.bind(ProjectDescriptionLoadListener.Strategy.class).to(N4MFProjectDependencyStrategy.class);
		binder.bind(N4MFProjectDependencyStrategy.class);
		binder.bind(IResourceSetInitializer.class).to(ScopeInitializer.class);
		binder.bind(ClassLoader.class).toInstance(getClass().getClassLoader());

		binder.bind(WorkingSetManagerBrokerImpl.class);
		binder.bind(WorkingSetManagerBroker.class).to(WorkingSetManagerBrokerImpl.class);
		binder.bind(WorkingSetManualAssociationWizard.class);
		binder.bind(WorkingSetManagerModificationStrategyProvider.class);
		binder.bind(WorkingSetProjectNameFilterWizard.class);
		binder.bind(N4JSProjectExplorerLabelProvider.class);
		binder.bind(N4JSProjectExplorerHelper.class);
		binder.bind(ObjectMapper.class);

		binder.bind(WorkspaceRepositoriesProvider.class);

		binder.bind(ResourceDescriptionsProvider.class);
		binder.bind(ResourceSetBasedResourceDescriptions.class);
		binder.bind(IResourceDescriptions.class)
				.annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE))
				.to(LiveShadowedResourceDescriptions.class);
		binder.bind(IResourceDescriptions.class)
				.annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE))
				.to(CurrentDescriptions.ResourceSetAware.class);
		binder.bind(IResourceDescriptions.class)
				.annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS))
				.to(IBuilderState.class);

		binder.bind(ProcessExecutor.class);
		binder.bind(BinaryCommandFactory.class);
		binder.bind(NodeProcessBuilder.class);
		binder.bind(OutputStreamPrinterThreadProvider.class);
		binder.bind(BinariesPreferenceStore.class).to(OsgiBinariesPreferenceStore.class);
		binder.bind(BinariesValidator.class);
		binder.bind(BinariesProvider.class);

		binder.bind(NodeBinaryLocatorHelper.class);
		binder.bind(NodeJsBinary.class);
		binder.bind(NpmBinary.class);
		binder.bind(NpmrcBinary.class);

		binder.bind(TypesKeywordProvider.class);
		binder.bind(ExternalLibraryErrorMarkerManager.class);
		binder.bind(IWorkspaceMarkerSupport.class).to(WorkspaceMarkerSupport.class);

		// we want to expose the N4JSQuickfixProvider as a shared contribution
		// To be removed when N4MF does no longer use the quickfix provider of n4js
		binder.bind(N4JSQuickfixProvider.class).toProvider(() -> {
			return N4JSActivator.getInstance().getInjector(N4JSActivator.ORG_ECLIPSE_N4JS_N4JS)
					.getInstance(N4JSQuickfixProvider.class);
		});
	}
}
