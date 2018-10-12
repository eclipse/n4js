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
package org.eclipse.n4js.smith;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Collector for timed data. NOT thread safe.
 */
class TimedDataCollector extends DataCollector {

	private final String id;
	private final DataCollector parent;
	// maintains insertion order
	private final Map<String, DataCollector> children = new LinkedHashMap<>();

	private static final TimedMeasurement NULL_MEASURMENT = new TimedMeasurement("NOOP", TimedDataCollector::noop);
	private boolean paused = true;

	private Measurement activeMeasurement = null;

	private final List<DataPoint> data = new LinkedList<>();

	/** Convenience constructors, delegates to {@link #TimedDataCollector(String, DataCollector)} with null argument. */
	public TimedDataCollector(String id) {
		this(id, null);
	}

	/** Creates instance of the collector. Provided parent can be {@code null}. */
	public TimedDataCollector(String id, DataCollector parent) {
		this.id = id;
		this.parent = parent;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean isPaused() {
		return paused;
	}

	@Override
	public boolean hasActiveMeasurement() {
		return activeMeasurement != null;
	}

	@Override
	synchronized public Measurement getMeasurement(String name) {
		if (name == null || name.isEmpty())
			throw new RuntimeException(TimedMeasurement.class.getName() + " needs non empty name.");

		if (paused)
			return NULL_MEASURMENT;

		if (activeMeasurement != null) {
			DataCollectors.INSTANCE.warn("reentrant invocation of #getMeasurement() in data collector " + id);
			return NULL_MEASURMENT;
		}
		activeMeasurement = new TimedMeasurement(name, this::consume);
		return activeMeasurement;
	}

	/** This method must be synchronized to protect race conditions when calling data.add */
	synchronized private void consume(TimedMeasurement measurement) {
		if (measurement != activeMeasurement) {
			DataCollectors.INSTANCE.warn("bad invocation of consume in data collector " + id + "#" + measurement.name);
			return;
		}
		activeMeasurement = null;
		TimedMeasurement timed = measurement;
		data.add(new DataPoint(timed.name, timed.elapsed(TimeUnit.NANOSECONDS)));
	}

	@Override
	public List<DataPoint> getData() {
		return Collections.unmodifiableList(data);
	}

	@Override
	public DataCollector getParent() {
		return parent;
	}

	@Override
	public Collection<DataCollector> getChildren() {
		return children.values();
	}

	@Override
	public DataCollector getChild(String key) {
		return this.children.get(key);
	}

	@Override
	public void addChild(String key, DataCollector child) {
		if (this.children.containsKey(key)) {
			throw new RuntimeException("Already contains key " + key + " with child " + this.children.get(key));
		}

		if (this.children.containsValue(child)) {
			String keys = this.children.entrySet()
					.stream()
					.filter(entry -> Objects.equals(entry.getValue(), child))
					.map(Map.Entry::getKey)
					.collect(Collectors.joining(",", "[", "]"));
			throw new RuntimeException("Already contains child " + child + " with keys " + keys);
		}

		this.children.put(key, child);
	}

	@Override
	public Collection<String> childrenKeys() {
		return this.children.keySet();
	}

	@Override
	public void setPaused(boolean paused) {
		this.activeMeasurement = null;
		this.paused = paused;
		this.children.values().forEach(child -> child.setPaused(paused));
	}

	@Override
	public void purgeData() {
		this.activeMeasurement = null;
		this.data.clear();
		this.children.values().forEach(c -> c.purgeData());
	}

	/** NOOP consumer. */
	private static void noop(@SuppressWarnings("unused") Measurement measurement) {
		// NOOP
	}
}
