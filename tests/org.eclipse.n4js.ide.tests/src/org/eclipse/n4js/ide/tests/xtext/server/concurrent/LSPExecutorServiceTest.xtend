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
package org.eclipse.n4js.ide.tests.xtext.server.concurrent

import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.UncheckedExecutionException
import com.google.common.util.concurrent.Uninterruptibles
import com.google.inject.Guice
import com.google.inject.Inject
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.apache.log4j.Level
import org.eclipse.n4js.ide.xtext.server.concurrent.LSPExecutorService
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.testing.logging.LoggingTester
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * Ported from Xtext's RequestManager tests.
 */
class LSPExecutorServiceTest {

	@Inject
	private LSPExecutorService lspExecutorService;

	private AtomicInteger sharedState

	@Before
	def void setUp() {
		sharedState = new AtomicInteger();
		Guice.createInjector(new ServerModule).injectMembers(this);
	}

	@After
	def void tearDown() {
		lspExecutorService.shutdown();
		sharedState = null;
	}

	@Test(timeout = 1000)
	def void testSubmitLogException() {
		val logResult = LoggingTester.captureLogging(Level.ALL, LSPExecutorService, [
			val future = lspExecutorService.submit("test", [
				throw new RuntimeException();
			]);
			try {
				future.join();
			} catch(Exception e) {}
		]);
		logResult.assertLogEntry("error during queued task:");
	}

	@Test(timeout = 1000, expected = UncheckedExecutionException)
	def void testSubmitCatchException() {
		LoggingTester.captureLogging(Level.ALL, LSPExecutorService, [
			val future = lspExecutorService.submit("test", [
				throw new RuntimeException();
			]);

			assertEquals('Foo', Futures.getUnchecked(future));
		]);

		fail("unreachable");
	}

	@Test(timeout = 1000)
	def void testSubmit() {
		val future = lspExecutorService.submit("test") [
			return 'Foo';
		];
		assertEquals('Foo', Futures.getUnchecked(future));
	}

	@Test(timeout = 1000)
	def void testSubmitConcurrent01() {
		val firstStarted = new CountDownLatch(1)
		val future = lspExecutorService.submit("id1", "first") [
			firstStarted.countDown
			while (sharedState.get == 0) {
				Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS)
			}
			sharedState.incrementAndGet
		];
		lspExecutorService.submit("id2", "second") [
			Uninterruptibles.awaitUninterruptibly(firstStarted)
			sharedState.incrementAndGet
		]
		future.join
		assertEquals(2, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testSubmitConcurrent02() {
		val firstStarted = new CountDownLatch(1)
		val future = lspExecutorService.submit("first") [
			firstStarted.countDown
			while (sharedState.get == 0) {
				Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS)
			}
			sharedState.incrementAndGet
		];
		lspExecutorService.submit("second") [
			Uninterruptibles.awaitUninterruptibly(firstStarted)
			sharedState.incrementAndGet
		]
		future.join
		assertEquals(2, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testSubmitSequential01() {
		lspExecutorService.submit("id", "first") [
			sharedState.incrementAndGet
		]
		val future = lspExecutorService.submit("id", "second") [
			sharedState.get
		]
		assertEquals(1, Futures.<Integer>getUnchecked(future))
	}

	@Test(timeout = 1000)
	def void testSubmitSequential02() {
		val releaseFirst = new CountDownLatch(1)
		val future = lspExecutorService.submit("id", "first") [
			Uninterruptibles.awaitUninterruptibly(releaseFirst)
			sharedState.get
		]
		lspExecutorService.submit("id", "second") [
			sharedState.incrementAndGet
		]
		Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS)
		releaseFirst.countDown
		assertEquals(0, Futures.<Integer>getUnchecked(future))
		lspExecutorService.join
	}

	@Test(timeout = 1000)
	def void testSubmitSequential03() throws Exception {
		val secondStarted = new CountDownLatch(1)
		lspExecutorService.submit("id", "first") [
			Uninterruptibles.awaitUninterruptibly(secondStarted)
			null
		]
		lspExecutorService.submit("id", "second") [
			secondStarted.countDown
			null
		]
		assertFalse(secondStarted.await(500, TimeUnit.MILLISECONDS))
		secondStarted.countDown
		lspExecutorService.join
	}

	@Test(timeout = 1000)
	def void testCancel01() {
		val future1 = lspExecutorService.submit("id", "first") [ ci |
			while (!ci.isCanceled()) {
				Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS)
			}
			null
		]
		val future2 = lspExecutorService.submit("id", "second") [
			sharedState.incrementAndGet
		]
		future1.cancel(false)
		future2.join()
		assertEquals(1, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testCancel02() {
		lspExecutorService.submit("id", "first") [ ci |
			while (!ci.isCanceled()) {
				Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS)
			}
			null
		]
		val future = lspExecutorService.submit("id", "second") [ ci |
			assertTrue(ci.isCanceled());
			sharedState.incrementAndGet
		]
		lspExecutorService.cancelAll("id");
		future.join()
		assertEquals(1, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testCancel03() {
		lspExecutorService.submit("id", "first") [ ci |
			while (!ci.isCanceled()) {
				Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS)
			}
			null
		]
		val future = lspExecutorService.submitAndCancelPrevious("id", "second") [
			sharedState.incrementAndGet
		]
		future.join()
		assertEquals(1, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testCancel04() {
		val firstStarted = new CountDownLatch(1)
		val firstCanceled = new CountDownLatch(1)
		val secondStarted = new CountDownLatch(1)
		val secondCanceled = new CountDownLatch(1)
		lspExecutorService.submit("id1", "first") [ ci |
			firstStarted.countDown
			while (!ci.isCanceled()) {
				Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS)
			}
			firstCanceled.countDown
			null
		]
		lspExecutorService.submit("id2", "second") [ ci |
			secondStarted.countDown
			while (!ci.isCanceled()) {
				Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS)
				sharedState.incrementAndGet
			}
			secondCanceled.countDown
			null
		]
		Uninterruptibles.awaitUninterruptibly(firstStarted)
		Uninterruptibles.awaitUninterruptibly(secondStarted)

		lspExecutorService.cancelAll("id1");
		// 1) assert that 'first' got the cancellation event
		Uninterruptibles.awaitUninterruptibly(firstCanceled)
		// 2) assert that 'second' did not get the cancellation event (i.e. that it is still incrementing sharedState)
		val cnt = sharedState.get
		while (sharedState.get === cnt) {
			Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS)
		}

		lspExecutorService.cancelAll("id2");
		// assert that now 'second' also got the cancellation event
		Uninterruptibles.awaitUninterruptibly(secondCanceled)
	}
}
