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
package org.eclipse.n4js.ide.editor.contentassist;

import java.util.Set;

import org.eclipse.xtext.ide.editor.contentassist.IPrefixMatcher;

/**
 * Used the algorithm that is also used by the xtext.ui implementation of the CamelCase prefix matcher.
 */
public class CamelCasePrefixMatcher extends IPrefixMatcher.IgnoreCase {

	private static Set<Character> PRMOTING_CHARS = Set.of('/', '-');

	@Override
	public boolean isCandidateMatchingPrefix(String name, String prefix) {
		boolean result = super.isCandidateMatchingPrefix(name, prefix) ||
				prefix.length() < name.length() && camelCaseMatch(name, prefix);
		return result;
	}

	private static boolean camelCaseMatch(String name, String prefix) {
		return camelCaseMatch(prefix.toCharArray(), name.toCharArray());
	}

	private static boolean camelCaseMatch(char[] pattern, char[] name) {
		if (pattern == null)
			return true; // null pattern is equivalent to '*'
		if (name == null)
			return false; // null name cannot match

		return camelCaseMatch(pattern, 0, pattern.length, name, 0, name.length, false/* not the same count of parts */);
	}

	private static boolean camelCaseMatch(char[] pattern, int patternStart, int patternEnd, char[] name, int nameStart,
			int nameEnd, boolean samePartCount) {

		/*
		 * !!!!!!!!!! WARNING !!!!!!!!!! The algorithm implemented in this method has been heavily used in
		 * StringOperation#getCamelCaseMatchingRegions(String, int, int, String, int, int, boolean) method.
		 *
		 * So, if any change needs to be applied in the current algorithm, do NOT forget to also apply the same change
		 * in the StringOperation method!
		 */

		if (name == null)
			return false; // null name cannot match
		if (pattern == null)
			return true; // null pattern is equivalent to '*'
		if (patternEnd < 0)
			patternEnd = pattern.length;
		if (nameEnd < 0)
			nameEnd = name.length;

		if (patternEnd <= patternStart)
			return nameEnd <= nameStart;
		if (nameEnd <= nameStart)
			return false;

		int iPattern = patternStart;
		int iName = nameStart;
		char patternChar = pattern[iPattern];
		char nameChar = name[iName];

		if (isUppercaseSlashOrDigit(patternChar)) {
			// search for start
			while (iName < nameEnd && !equalsOrPromotedEquals(patternChar, name, iName)) {
				iName++;
			}
			// check first pattern char
			if (iName >= nameEnd) {
				return false;
			}
		} else if (name[iName] != patternChar) {
			return false;
		}

		// Main loop is on pattern characters
		while (true) {

			iPattern++;
			iName++;

			if (iPattern == patternEnd) { // we have exhausted pattern...
				// it's a match if the name can have additional parts (i.e. uppercase characters) or is also exhausted
				if (!samePartCount || iName == nameEnd)
					return true;

				// otherwise it's a match only if the name has no more uppercase characters
				while (true) {
					if (iName == nameEnd) {
						// we have exhausted the name, so it's a match
						return true;
					}
					nameChar = name[iName];
					// test if the name character is uppercase
					if (!Character.isJavaIdentifierPart(nameChar) || Character.isUpperCase(nameChar)) {
						return false;
					}
					iName++;
				}
			}

			if (iName == nameEnd) {
				// We have exhausted the name (and not the pattern), so it's not a match
				return false;
			}

			// For as long as we're exactly matching, bring it on (even if it's a lower case character)
			if ((patternChar = pattern[iPattern]) == name[iName]) {
				continue;
			}

			// If characters are not equals, then it's not a match if patternChar is lowercase
			if (Character.isJavaIdentifierPart(patternChar) && !Character.isUpperCase(patternChar)
					&& !Character.isDigit(patternChar)) {

				// rewind pattern chars, keep name chars
				while (iPattern >= 0 && !isUppercaseSlashOrDigit(pattern[iPattern])) {
					iPattern--;
				}
				if (iPattern < 0) {
					return false;
				}
				// search for next start
				while (iName < nameEnd && !equalsOrPromotedEquals(pattern[iPattern], name, iName)) {
					iName++;
				}
				// check first pattern char
				if (iName >= nameEnd) {
					return false;
				}
				continue;
			}

			// patternChar is uppercase, so let's find the next uppercase in name
			while (true) {
				if (iName == nameEnd) {
					// We have exhausted name (and not pattern), so it's not a match
					return false;
				}

				nameChar = name[iName];
				if (Character.isDigit(nameChar)) {
					// optional digits
					if (patternChar == nameChar)
						break;
					iName++;
				} else if (PRMOTING_CHARS.contains(nameChar)) {
					// optional slashes
					if (patternChar == nameChar)
						break;
					iName++;
				} else if (promotedEquals(patternChar, name, iName)) {
					// uppercase to indicate first letter after '/'
					break;
				} else if (Character.isJavaIdentifierPart(nameChar) && Character.isUpperCase(nameChar) && iName > 0
						&& Character.isUpperCase(name[iName - 1])) {
					// optional consecutive uppercase letters
					if (patternChar == nameChar)
						break;
					iName++;
				} else if (Character.isJavaIdentifierPart(nameChar) && !Character.isUpperCase(nameChar)) {
					// skip lowercase letters
					iName++;
				} else if (patternChar != nameChar) {
					// allow skipping uppercase letters
					iName++;
				} else {
					break;
				}
			}
			// At this point, either name has been exhausted, or it is at an uppercase letter.
			// Since pattern is also at an uppercase letter
		}
	}

	private static boolean isUppercaseSlashOrDigit(char c) {
		return Character.isUpperCase(c) || Character.isDigit(c) || PRMOTING_CHARS.contains(c);
	}

	private static boolean equalsOrPromotedEquals(char c1, char[] chars, int charsIdx) {
		if (c1 == chars[charsIdx]) {
			return true;
		}
		return promotedEquals(c1, chars, charsIdx);
	}

	private static boolean promotedEquals(char c1, char[] chars, int charsIdx) {
		if (charsIdx > 0 && PRMOTING_CHARS.contains(chars[charsIdx - 1])
				&& c1 == Character.toUpperCase(chars[charsIdx])) {
			return true;
		}
		return false;
	}
}
