/**
 * Copyright (c) 2018 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.tests.hyperlink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.n4js.json.JSONGlobals;
import org.eclipse.n4js.tests.builder.AbstractBuilderParticipantTest;
import org.eclipse.n4js.tests.util.EclipseUIUtils;
import org.eclipse.n4js.tests.util.ProjectTestsUtils;
import org.eclipse.n4js.ui.editor.N4JSHyperlinkDetector;
import org.eclipse.n4js.ui.utils.UIUtils;
import org.eclipse.n4js.utils.languages.N4LanguageUtils;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hyperlinking.DefaultHyperlinkDetector;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * This test checks that hyperlinks to resources in the external libraries use file based {@link URI}s.
 */
public class HyperlinkPluginUITest extends AbstractBuilderParticipantTest {

	private static final String PROBANDS = "probands";
	private static final String SUBFOLDER = "Hyperlink";
	private static final String PROJECT_NAME = "Hyperlink";

	@Override
	protected boolean provideShippedCode() {
		return true;
	}

	@Inject
	private N4JSHyperlinkDetector hyperlinkDetector;

	@Inject
	private IURIEditorOpener uriEditorOpener;

	/**
	 * The test invokes the method
	 * {@link N4JSHyperlinkDetector#detectHyperlinks(org.eclipse.jface.text.ITextViewer, IRegion, boolean)} to gather
	 * all hyperlinks on the call to 'process' of "n4js-runtime-node" and checks that the returned hyperlink uri is a
	 * file based uri.
	 */
	@Test
	public void testHyperlinks() throws CoreException {
		File prjDir = new File(getResourceUri(PROBANDS, SUBFOLDER));
		IProject project = ProjectTestsUtils.importProject(prjDir, PROJECT_NAME);

		IResource resourceABC = project.findMember("src/ABC.n4js");
		IFile fileABC = ResourcesPlugin.getWorkspace().getRoot().getFile(resourceABC.getFullPath());
		IResourcesSetupUtil.fullBuild();
		waitForAutoBuild();

		libraryManager.runNpmYarnInstallOnAllProjects(new NullProgressMonitor());
		syncExtAndBuild();
		ProjectTestsUtils.assertNoErrors();

		IWorkbenchPage page = EclipseUIUtils.getActivePage();
		XtextEditor editor = openAndGetXtextEditor(fileABC, page);
		ISourceViewer sourceViewer = editor.getInternalSourceViewer();
		IRegion region = new Region(367, 0); // find location with Breakpoint in N4JSHyperlinkHelper
		ProjectTestsUtils.waitForAllJobs();

		IHyperlink[] hlinksInABC = hyperlinkDetector.detectHyperlinks(sourceViewer, region, true);

		assertTrue("Hyperlink missing", hlinksInABC != null && hlinksInABC.length == 1);
		assertTrue("Hyperlink must be of type XtextHyperlink", hlinksInABC[0] instanceof XtextHyperlink);
		XtextHyperlink hyperlinkToProcess = (XtextHyperlink) hlinksInABC[0];
		URI uriProcess = hyperlinkToProcess.getURI();
		assertTrue("Hyperlink URI must be a platform uri", uriProcess.isPlatform());

		URI uriProcessFile = CommonPlugin.resolve(uriProcess);
		File fileProcess = new File(uriProcessFile.toFileString());
		assertTrue("File 'process.n4jsd' must exist", fileProcess.isFile());

		editor = (XtextEditor) uriEditorOpener.open(uriProcess, true);
		page = EclipseUIUtils.getActivePage();
		assertEquals("Wrong editor title", "process.n4jsd", editor.getTitle());
		TextSelection selectionProcess = (TextSelection) page.getSelection();
		assertTrue("Selection must be 'process'", selectionProcess.getText().equals("process"));
		sourceViewer = editor.getInternalSourceViewer();
		region = new Region(556, 12);
		IHyperlink[] hlinksInProcess = hyperlinkDetector.detectHyperlinks(sourceViewer, region, true);

		assertTrue("Hyperlink in external library missing", hlinksInProcess != null && hlinksInProcess.length == 1);
		assertTrue("Hyperlink must be of type XtextHyperlink", hlinksInProcess[0] instanceof XtextHyperlink);
		XtextHyperlink hyperlinkToEvent = (XtextHyperlink) hlinksInProcess[0];
		URI uriEvent = hyperlinkToEvent.getURI();
		assertTrue("Hyperlink URI must be a platform uri", uriEvent.isPlatform());

		editor = (XtextEditor) uriEditorOpener.open(uriEvent, true);
		page = EclipseUIUtils.getActivePage();
		assertEquals("Wrong editor title", "events.n4jsd", editor.getTitle());
		TextSelection selectionEvent = (TextSelection) page.getSelection();
		assertEquals("Wrong selection", "EventEmitter", selectionEvent.getText());
	}

	/**
	 * GH-1199
	 * <p>
	 * Similar to {@link #testHyperlinks()}, but instead of opening external library file "process.n4jsd" by following a
	 * hyperlink inside an ordinary N4JS source file, we open "process.n4jsd" via the "External Dependencies" entry in
	 * the Project Explorer view.
	 */
	@Test
	public void testHyperlinksWhenOpenedFromExplorer() throws CoreException {
		File prjDir = new File(getResourceUri(PROBANDS, SUBFOLDER));
		ProjectTestsUtils.importProject(prjDir, PROJECT_NAME);
		waitForAutoBuild();

		libraryManager.runNpmYarnInstallOnAllProjects(new NullProgressMonitor());
		syncExtAndBuild();
		UIUtils.waitForUiThread();
		assertNoErrors();

		IWorkbenchPage page = EclipseUIUtils.getActivePage();
		XtextEditor editor = openAndGetXtextEditorViaProjectExplorer(page,
				PROJECT_NAME,
				"node_modules",
				"n4js-runtime-node 0.13.4 [Runtime library]",
				"src",
				"n4js",
				"process.n4jsd");
		UIUtils.waitForUiThread();

		ISourceViewer sourceViewer = editor.getInternalSourceViewer();
		IRegion region = new Region(556, 12); // find location with Breakpoint in N4JSHyperlinkHelper
		IHyperlink[] hlinksInProcess = hyperlinkDetector.detectHyperlinks(sourceViewer, region, true);

		assertTrue("Hyperlink in external library missing", hlinksInProcess != null && hlinksInProcess.length == 1);
		assertTrue("Hyperlink must be of type XtextHyperlink", hlinksInProcess[0] instanceof XtextHyperlink);
		XtextHyperlink hyperlinkToEvent = (XtextHyperlink) hlinksInProcess[0];
		URI uriEvent = hyperlinkToEvent.getURI();
		assertTrue("Hyperlink URI must be a platform uri", uriEvent.isPlatform());

		editor = (XtextEditor) uriEditorOpener.open(uriEvent, true);
		page = EclipseUIUtils.getActivePage();
		UIUtils.waitForUiThread();
		TextSelection selectionEvent = (TextSelection) page.getSelection();

		assertEquals("Wrong editor title", "events.n4jsd", editor.getTitle());
		assertEquals("Wrong selection", "EventEmitter", selectionEvent.getText());
	}

	/**
	 * Test to check that hyperlinks to file URIs does work.
	 * <p>
	 * This test will open a version of the hyperlink project that is part of a yarn workspace. Also, the yarn workspace
	 * project is closed in the Eclipse workspace. Consequently, the external libraries are not available as a platform
	 * resource.
	 */
	@Test
	public void testHyperlinksToFileUri() throws CoreException {
		File prjDir = new File(getResourceUri(PROBANDS, SUBFOLDER));
		ProjectTestsUtils.importYarnWorkspace(libraryManager, prjDir, "YarnWorkspaceProject");
		waitForAutoBuild();

		IProject ywPrj = ResourcesPlugin.getWorkspace().getRoot().getProject("YarnWorkspaceProject");
		ywPrj.close(new NullProgressMonitor());

		IWorkbenchPage page = EclipseUIUtils.getActivePage();
		UIUtils.waitForUiThread();

		Path path = Paths.get(PROJECT_NAME, "src", "ABC.n4js");
		org.eclipse.core.runtime.Path iPath = new org.eclipse.core.runtime.Path(path.toString());
		IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(iPath);
		XtextEditor editor = openAndGetXtextEditor(iFile, page);
		UIUtils.waitForUiThread();

		ISourceViewer sourceViewer = editor.getInternalSourceViewer();
		IRegion region = new Region(364, 7); // find location with Breakpoint in N4JSHyperlinkHelper
		IHyperlink[] hlinksInProcess = hyperlinkDetector.detectHyperlinks(sourceViewer, region, true);

		assertTrue("Hyperlink in external library missing", hlinksInProcess != null && hlinksInProcess.length == 1);
		assertTrue("Hyperlink must be of type XtextHyperlink", hlinksInProcess[0] instanceof XtextHyperlink);
		XtextHyperlink hyperlinkToEvent = (XtextHyperlink) hlinksInProcess[0];
		URI uriEvent = hyperlinkToEvent.getURI();
		assertTrue("Hyperlink URI must be a file uri", uriEvent.isFile());

		editor = (XtextEditor) uriEditorOpener.open(uriEvent, true);
		page = EclipseUIUtils.getActivePage();
		UIUtils.waitForUiThread();
		TextSelection selectionEvent = (TextSelection) page.getSelection();

		assertEquals("Wrong editor title", "process.n4jsd", editor.getTitle());
		assertEquals("Wrong selection", "process", selectionEvent.getText());
	}

	/**
	 * Test for hyperlink support on npm dependencies in package.json files.
	 */
	@Test
	public void testHyperlinksOnPackageJson() throws CoreException {
		File prjDir = new File(getResourceUri(PROBANDS, SUBFOLDER));
		ProjectTestsUtils.importProject(prjDir, PROJECT_NAME);
		waitForAutoBuild();

		libraryManager.runNpmYarnInstallOnAllProjects(new NullProgressMonitor());
		syncExtAndBuild();
		UIUtils.waitForUiThread();
		assertNoErrors();

		IWorkbenchPage page = EclipseUIUtils.getActivePage();
		XtextEditor editor = openAndGetXtextEditorViaProjectExplorer(page,
				PROJECT_NAME,
				"node_modules",
				"n4js-runtime-node 0.13.4 [Runtime library]",
				"package.json");
		UIUtils.waitForUiThread();

		DefaultHyperlinkDetector pckjsonHD = null;
		pckjsonHD = N4LanguageUtils
				.getServiceForContext(JSONGlobals.FILE_EXTENSION, DefaultHyperlinkDetector.class).get();

		ISourceViewer sourceViewer = editor.getInternalSourceViewer();
		IRegion region = new Region(973, 0); // find location with Breakpoint in PackageJsonHyperlinkHelperExtension
		IHyperlink[] hlinksInProcess = pckjsonHD.detectHyperlinks(sourceViewer, region, true);

		assertTrue("Hyperlink in external library missing", hlinksInProcess != null && hlinksInProcess.length == 1);
		assertTrue("Hyperlink must be of type XtextHyperlink", hlinksInProcess[0] instanceof XtextHyperlink);
		XtextHyperlink hyperlinkToEvent = (XtextHyperlink) hlinksInProcess[0];
		URI uriEvent = hyperlinkToEvent.getURI();
		assertTrue("Hyperlink URI must be a file uri", uriEvent.isFile());

		editor = (XtextEditor) uriEditorOpener.open(uriEvent, true);
		UIUtils.waitForUiThread();

		assertEquals("Wrong editor title", "package.json", editor.getTitle());
	}

}
