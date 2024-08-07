/**
 * Copyright (c) 2017 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.tests.validation;

import java.util.List;

import org.eclipse.n4js.AbstractN4JSTest;
import org.eclipse.n4js.N4JSInjectorProvider;
import org.eclipse.n4js.N4JSStandaloneTestsModule;
import org.eclipse.n4js.postprocessing.N4JSPostProcessor;
import org.eclipse.n4js.resource.N4JSResource;
import org.eclipse.n4js.resource.PostProcessingAwareResource;
import org.eclipse.n4js.resource.PostProcessingAwareResource.PostProcessor;
import org.eclipse.n4js.scoping.builtin.N4Scheme;
import org.eclipse.n4js.tests.issues.IssueUtils;
import org.eclipse.n4js.tests.validation.AvoidFollowUpExceptionsInValidationTest.N4JSInjectorProviderWithPostProcessingFailure;
import org.eclipse.n4js.validation.N4JSResourceValidator;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

/**
 * This tests the early return in method
 * {@link N4JSResourceValidator#validate(org.eclipse.emf.ecore.resource.Resource, CheckMode, CancelIndicator)}.
 */
@InjectWith(N4JSInjectorProviderWithPostProcessingFailure.class) // NOTE the special injector provider!
public class AvoidFollowUpExceptionsInValidationTest extends AbstractN4JSTest {

	@Test
	public void testSimulatedEditorUpdate() throws Exception {
		N4JSResource res = (N4JSResource) parserHelper.parse("""
				class C {
					m() {
					}
				}
				""").eResource();

		// the following code simulates behavior of an Xtext editor that is triggered when the source is edited by the
		// user, see method: XtextDocumentReconcileStrategy#postParse(XtextResource, IProgressMonitor)

		try {
			// this triggers: res.performPostProcessing()
			EcoreUtil2.resolveLazyCrossReferences(res, CancelIndicator.NullImpl);
			fail("expected exception during post-processing was not thrown by FailingN4JSPostProcessor");
		} catch (RuntimeException e) {
			assertTrue("expected FailedPostProcessingException, actual: " + e.getClass().getSimpleName(),
					e instanceof FailedPostProcessingException);

			res.getCache().clear(res); // <-- Xtext clears the cache after RuntimeException

			// <-- Xtext does not re-throw the runtime exception
		}

		// Xtext always triggers a validation
		// see last finally block in method: XtextDocument.XtextDocumentLocker#modify(IUnitOfWork<T, XtextResource>)
		// which always invokes: XtextDocument#checkAndUpdateAnnotations()
		IResourceValidator validator = ((XtextResource) res).getResourceServiceProvider().getResourceValidator();
		// ASSERTION #1: this should not throw follow-up exceptions
		List<Issue> issues = validator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl);

		// ASSERTION #2: the exception thrown during post-processing should show up as a single error
		assertEquals("incorrect number of issues", 1, issues.size());
		String issueStr = IssueUtils.toString(issues.get(0));
		assertTrue("incorrect beginning of issue string", issueStr.startsWith(
				"ERROR:exception FailedPostProcessingException thrown during post-processing (please report this!): failure of post-processing as simulated by FailingN4JSPostProcessor\n"));
		assertTrue("incorrect end of issue string", issueStr.endsWith(
				" (__synthetic0.n4js line : 1 column : 1)"));
	}

	/** Special injector provider, to simulate an exception during post-processing. */
	public static class N4JSInjectorProviderWithPostProcessingFailure extends N4JSInjectorProvider {
		public N4JSInjectorProviderWithPostProcessingFailure() {
			super(new FailingPostProcessingModule());
		}
	}

	private static class FailingPostProcessingModule extends N4JSStandaloneTestsModule {
		@SuppressWarnings("unused")
		public Class<? extends PostProcessor> bindPostProcessor() {
			return FailingN4JSPostProcessor.class;
		}
	}

	private static class FailingN4JSPostProcessor extends N4JSPostProcessor {
		@Override
		public void performPostProcessing(PostProcessingAwareResource resource, CancelIndicator cancelIndicator) {
			super.performPostProcessing(resource, cancelIndicator);
			if (N4Scheme.isResourceWithN4Scheme(resource)) {
				return; // <-- don't simulate exceptions while resolving built-in types
			}
			throw new FailedPostProcessingException(); // <-- simulate exception thrown during post-processing
		}
	}

	private static class FailedPostProcessingException extends RuntimeException {
		public static final String MESSAGE = "failure of post-processing as simulated by FailingN4JSPostProcessor";

		public FailedPostProcessingException() {
			super(MESSAGE);
		}
	}
}
