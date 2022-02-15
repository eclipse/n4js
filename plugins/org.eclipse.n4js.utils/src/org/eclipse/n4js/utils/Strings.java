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
package org.eclipse.n4js.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Joiner;

/**
 * Utility functions for strings
 */
abstract public class Strings {

	/**
	 * Converts the given iterable to a string representation of an array
	 *
	 * @param iterable
	 *            to be concatenated
	 */
	final static public String toString(Iterable<? extends Object> iterable) {
		return toString(Object::toString, iterable);
	}

	/**
	 * Converts the given iterable to a string representation of an array
	 *
	 * @param accessor
	 *            lambda to be used on every element of the iterable
	 */
	final static public <A, T extends Exception> String toString(FunctionWithException<A, String, T> accessor,
			Iterable<A> iterable) throws T {

		return "[" + join(", ", accessor, iterable) + "]";
	}

	/** Joins the given iterable with the given delimiter */
	final static public String join(String delimiter, Iterable<? extends Object> iterable) {
		return join(delimiter, Object::toString, iterable);
	}

	/** Joins the given array with the given delimiter */
	final static public String join(String delimiter, Object... objects) {
		return join(delimiter, Object::toString, objects);
	}

	/** Joins the given array with the given delimiter. The accessor is applied on every element of the array. */
	@SafeVarargs
	final static public <A, T extends Exception> String join(String delimiter,
			FunctionWithException<A, String, T> accessor, A... objects) throws T {

		return join(delimiter, accessor, Arrays.asList(objects));
	}

	/** Joins the given array with the given delimiter. The accessor is applied on every element of the iterable. */
	final static public <A, T extends Exception> String join(String delimiter,
			FunctionWithException<A, String, T> accessor, Iterable<A> iterable) throws T {

		if (iterable == null || delimiter == null || accessor == null) {
			return "";
		}
		String str = "";
		for (Iterator<A> it = iterable.iterator(); it.hasNext();) {
			A t = it.next();
			str += (t == null) ? "" : accessor.apply(t);
			if (it.hasNext()) {
				str += delimiter;
			}
		}

		return str;
	}

	/** Joins the given map with the given delimiter */
	final static public <K extends Object, V extends Object> String toString(Map<K, V> map) {
		return toString(map, Object::toString);
	}

	/** Joins the given map with the given delimiter */
	final static public <K extends Object, V extends Object, T extends Exception> String toString(Map<K, V> map,
			FunctionWithException<V, String, T> valueAccessor) throws T {

		return toString(map, Object::toString, valueAccessor);
	}

	/** Joins the given map with the given delimiter */
	final static public <K extends Object, V extends Object, T extends Exception> String toString(Map<K, V> map,
			FunctionWithException<K, String, T> keyAccessor, FunctionWithException<V, String, T> valueAccessor)
			throws T {

		return toString(", ", map, keyAccessor, valueAccessor);
	}

	/** Joins the given map with the given delimiter */
	final static public <K extends Object, V extends Object, T extends Exception> String toString(String delimiter,
			Map<K, V> map, FunctionWithException<K, String, T> keyAccessor,
			FunctionWithException<V, String, T> valueAccessor) throws T {

		if (map == null || delimiter == null || keyAccessor == null || valueAccessor == null) {
			return "";
		}
		String str = "";
		for (Iterator<Entry<K, V>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<K, V> e = it.next();
			str += keyAccessor.apply(e.getKey()) + " -> " + valueAccessor.apply(e.getValue());
			if (it.hasNext()) {
				str += delimiter;
			}
		}

		return str;
	}

	/** Creates a multi-line string from the given lines, using the operating system's line separator. */
	final static public String fromLines(String... lines) {
		// rationale for using system-specific line separator: consistency with Xtend's template string literals
		return Joiner.on(System.lineSeparator()).join(lines) + System.lineSeparator();
	}

	/** Converts the given string to an identifier. */
	final static public String toIdentifier(String str, char replacement) {
		if (replacement != 0
				&& !(Character.isJavaIdentifierStart(replacement) && Character.isJavaIdentifierPart(replacement))) {
			throw new IllegalArgumentException(
					"the given replacement character must be a valid Java identifier start and part: " + replacement);
		}
		if (str == null || str.isEmpty()) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			boolean isLegal = (i == 0 && Character.isJavaIdentifierStart(ch))
					|| (i > 0 && Character.isJavaIdentifierPart(ch));
			if (isLegal) {
				sb.append(ch);
			} else if (replacement != 0) {
				sb.append(replacement);
			}
		}
		return sb.toString();
	}

	/** Escapes all non-printable characters in the given string or replaces them by '?'. */
	public static final String escapeNonPrintable(String str) {
		StringBuilder result = new StringBuilder(str.length());
		int i = 0;
		while (i < str.length()) {
			int codePoint = str.codePointAt(i);

			switch (codePoint) {
			case '\t':
				result.append("\\t");
				break;
			case '\b':
				result.append("\\b");
				break;
			case '\n':
				result.append("\\n");
				break;
			case '\r':
				result.append("\\r");
				break;
			case '\f':
				result.append("\\f");
				break;
			case '\'':
				result.append("\\'");
				break;
			case '\"':
				result.append("\\\"");
				break;
			case '\\':
				result.append("\\\\");
				break;
			default:
				switch (Character.getType(codePoint)) {
				case Character.CONTROL:
				case Character.FORMAT:
				case Character.PRIVATE_USE:
				case Character.SURROGATE:
				case Character.UNASSIGNED:
					result.append("\\u");
					String hexString = Integer.toHexString(codePoint);
					for (int j = hexString.length(); j < 4; j++) {
						result.append('0');
					}
					result.append(hexString);
					break;
				default:
					result.append(Character.toChars(codePoint));
					break;
				}
				break;
			}

			i += Character.charCount(codePoint);
		}
		return result.toString();
	}
}
