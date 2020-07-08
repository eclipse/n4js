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
package org.eclipse.n4js.ide.xtext.server.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Similar to an ordinary {@link ExecutorService}, but with two differences:
 * <ol>
 * <li>when submitting a task, a queue ID may be provided and this executor will then guarantee that
 * <ol type="a">
 * <li>two tasks with {@link Object#equals(Object) equal} queue ID are never running at the same time, and
 * <li>tasks with equal queue ID will be executed in the order they were submitted.
 * </ol>
 * If no queue ID is provided, the usual behavior of ordinary {@link ExecutorService executor services} applies, i.e.
 * the task might run concurrently to any other task and ordering depends on the {@link #delegate delegate executor
 * service}.
 * <li>each task is provided with an Xtext {@link CancelIndicator} and cancellation via a task's
 * {@link CompletableFuture future}, as returned by the submit methods, is converted into a cancellation request via
 * that cancel indicator. This leads to a slight change how cancellation works compared to ordinary futures, see
 * {@link QueuedTaskFuture#cancel(boolean) #cancel(boolean)} for details.
 * </ol>
 *
 * <h2>Cancellation Handling</h2>
 *
 * Cancellation is handled entirely through Xtext's {@link CancelIndicator}s and a task's implementation can decide how
 * to react to that (as usual with cancel indicators). Tasks will always be invoked, even if they were marked as
 * cancelled while waiting on the queue, so implementors of a task may choose to implement a "non-cancellable" operation
 * at the beginning of a task before reacting to the cancel indicator.
 */
@Singleton // not truly necessary, but ensures queue IDs are "global" within a single injector
public class LSPExecutorService {

	private static final Logger LOG = Logger.getLogger(LSPExecutorService.class);

	/** The underlying executor service that is used to actually execute the tasks. */
	@Inject
	protected ExecutorService delegate;

	/***/
	@Inject
	protected OperationCanceledManager operationCanceledManager;

	/** Global queue of all pending tasks across all queue IDs. */
	protected final List<QueuedTask<?>> pendingTasks = new ArrayList<>();
	/** Queue IDs with currently running tasks. */
	protected final Map<Object, QueuedTask<?>> runningTasks = new LinkedHashMap<>();

	@SuppressWarnings("javadoc")
	protected final class QueuedTask<T> implements Runnable, XCancellable {
		protected final Object queueId;
		protected final String description;
		protected final Function<CancelIndicator, T> operation;
		protected final QueuedTaskFuture<T> result;
		protected volatile boolean cancelled = false;

		protected QueuedTask(Object queueId, String description, Function<CancelIndicator, T> operation) {
			this.queueId = Objects.requireNonNull(queueId);
			this.description = Objects.requireNonNull(description);
			this.operation = Objects.requireNonNull(operation);
			this.result = createResult();
		}

		protected QueuedTaskFuture<T> createResult() {
			return new QueuedTaskFuture<>(this);
		}

		@Override
		public void run() {
			try {
				T actualResult = operation.apply(new CancelIndicator() {
					@Override
					public boolean isCanceled() {
						return cancelled;
					}
				});
				result.complete(actualResult);
			} catch (Throwable th) {
				if (isCancellation(th)) {
					result.doCancel();
				} else {
					result.completeExceptionally(th);
					LOG.error("error during queued task: ", th);
				}
			} finally {
				onDone(this);
			}
		}

		@Override
		public void cancel() {
			cancelled = true;
		}
	}

	@SuppressWarnings("javadoc")
	public static class QueuedTaskFuture<T> extends CompletableFuture<T> {

		protected final QueuedTask<T> task;

		protected QueuedTaskFuture(QueuedTask<T> task) {
			this.task = Objects.requireNonNull(task);
		}

		/**
		 * Does not immediately cancel this future! Instead, only the corresponding queued task's cancel indicator is
		 * marked as cancelled, but it lies in the discretion of the task's implementation how to react to that. This
		 * future might even still complete normally if the task implementation chooses to ignore the cancellation
		 * status of the cancel indicator.
		 */
		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			task.cancel();
			return isCancelled();
		}

		/** Tells whether this future's queued task was marked as cancelled. */
		public boolean isCancellationRequested() {
			return task.cancelled;
		}

		/** Actually cancels this future. Should only be invoked by {@link QueuedTask#run()}. */
		protected void doCancel() {
			super.cancel(false);
		}
	}

	/** Submits the given task without a queue ID. See {@link LSPExecutorService} for details. */
	public synchronized <T> QueuedTaskFuture<T> submit(String description,
			Function<CancelIndicator, T> task) {
		return submit(new Object(), description, task);
	}

	/**
	 * Same as {@link #submit(Object, String, Function)}, but first cancels all running and pending tasks for the given
	 * queue ID.
	 */
	public synchronized <T> QueuedTaskFuture<T> submitAndCancelPrevious(Object queueId, String description,
			Function<CancelIndicator, T> task) {
		cancelAll(queueId);
		return submit(queueId, description, task);
	}

	/** Submits the given task under the given queue ID. See {@link LSPExecutorService} for details. */
	public synchronized <T> QueuedTaskFuture<T> submit(Object queueId, String description,
			Function<CancelIndicator, T> task) {
		QueuedTask<T> queuedTask = createQueuedTask(queueId, description, task);
		enqueue(queuedTask);
		doSubmitAllPending();
		return queuedTask.result;
	}

	/** Put the given task on the queue of pending tasks. */
	protected synchronized void enqueue(QueuedTask<?> task) {
		pendingTasks.add(task);
	}

	/** Remove and return the next pending, non-blocked task from the queue of pending tasks. */
	protected synchronized QueuedTask<?> pollNextPending() {
		Iterator<QueuedTask<?>> iter = pendingTasks.iterator();
		while (iter.hasNext()) {
			QueuedTask<?> curr = iter.next();
			boolean isBlocked = runningTasks.containsKey(curr.queueId);
			if (!isBlocked) {
				iter.remove();
				return curr;
			}
		}
		return null;
	}

	/** Like {@link #doSubmit(QueuedTask)}, but will submit all currently pending, non-blocked tasks. */
	protected synchronized void doSubmitAllPending() {
		QueuedTask<?> next;
		while ((next = pollNextPending()) != null) {
			doSubmit(next);
		}
	}

	/** Submit the given task to the delegate executor service. */
	protected synchronized void doSubmit(QueuedTask<?> task) {
		if (runningTasks.putIfAbsent(task.queueId, task) != null) {
			throw new IllegalStateException("executor inconsistency: queue ID already in progress: " + task.queueId);
		}
		delegate.submit(task); // will eventually invoke #onDone()
	}

	/** Invoked by each running task upon completion, see {@link QueuedTask#run()}. */
	protected synchronized void onDone(QueuedTask<?> task) {
		if (runningTasks.remove(task.queueId) == null) {
			throw new IllegalStateException("executor inconsistency: queue ID not in progress: " + task.queueId);
		}
		doSubmitAllPending();
	}

	/**
	 * Marks all running and pending tasks as cancelled, i.e. their cancel indicator will return <code>true</code> from
	 * {@link CancelIndicator#isCanceled() #isCanceled()}. Does not mark the tasks' result futures as cancelled, see
	 * {@link LSPExecutorService} for details.
	 */
	public synchronized void cancelAll() {
		Stream.concat(runningTasks.values().stream(), pendingTasks.stream())
				.forEach(t -> t.cancel());
	}

	/** Same as {@link #cancelAll()}, but only affects tasks with a queue ID equal to the given ID. */
	public synchronized void cancelAll(Object queueId) {
		Stream.concat(runningTasks.values().stream(), pendingTasks.stream())
				.filter(t -> queueId.equals(t.queueId))
				.forEach(t -> t.cancel());
	}

	/**
	 * Blocks until all tasks complete that are running or pending at the time of invocation of this method OR are being
	 * submitted by other threads while this method is waiting. Thus, this method waits for the executor to idle.
	 * <p>
	 * More precisely, this method waits for a point in time when this executor is idle but <u>does not guarantee</u>
	 * the <em>first</em> such point in time will be detected and does not guarantee the executor is <em>still</em> idle
	 * when this method returns (however, the latter may only be untrue if there exist threads submitting issues other
	 * than those of the tasks running or pending when this method is invoked).
	 * <p>
	 * This method should not usually be invoked from ordinary code; it is mainly intended for server shutdown and
	 * during testing.
	 */
	public /* NOT synchronized */ void join() {
		CompletableFuture<Void> allTasks;
		while ((allTasks = allTasksOrNull()) != null) {
			try {
				allTasks.join();
			} catch (CompletionException | CancellationException e) {
				// ignore cancellations
			}
		}
	}

	/** Same as {@link #allTasks()}, but returns <code>null</code> iff there are no running or pending tasks. */
	public synchronized CompletableFuture<Void> allTasksOrNull() {
		if (runningTasks.isEmpty() && pendingTasks.isEmpty()) {
			return null;
		}
		return allTasks();
	}

	/**
	 * Returns a future that will complete when all tasks complete that are running or pending <em>at the time of
	 * invocation of this method</em>. Tasks submitted after this method returns will not be considered. Never returns
	 * <code>null</code>.
	 */
	public synchronized CompletableFuture<Void> allTasks() {
		CompletableFuture<?>[] allTasks = Stream.concat(runningTasks.values().stream(), pendingTasks.stream())
				.map(t -> t.result)
				.collect(Collectors.toList())
				.toArray(CompletableFuture[]::new);
		return CompletableFuture.allOf(allTasks);
	}

	/** An orderly shutdown of this executor service. */
	public synchronized void shutdown() {
		MoreExecutors.shutdownAndAwaitTermination(delegate, 2500, TimeUnit.MILLISECONDS);
		cancelAll();
	}

	/** May be invoked from arbitrary threads. */
	protected /* NOT synchronized */ <T> QueuedTask<T> createQueuedTask(Object queueId, String description,
			Function<CancelIndicator, T> task) {

		return new QueuedTask<>(queueId, description, task);
	}

	/** May be invoked from arbitrary threads. */
	protected /* NOT synchronized */ boolean isCancellation(Throwable th) {
		return th instanceof CancellationException || operationCanceledManager.isOperationCanceledException(th);
	}
}
