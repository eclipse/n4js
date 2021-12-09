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
package org.eclipse.n4js.tests

import java.nio.file.FileVisitOption
import java.nio.file.Files
import java.nio.file.Path
import java.util.Collections
import java.util.stream.Collectors
import org.eclipse.n4js.tests.parser.AbstractParserTest
import org.eclipse.n4js.validation.ASTStructureValidator
import org.eclipse.n4js.validation.JavaScriptVariant
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

import static org.eclipse.n4js.validation.ASTStructureValidator.*

/**
 * Current state as of Dec. 8, 2021:
 * <p>
 * Sample output of method {@link #testFolder()} for folder {@link #DEFINITELY_TYPED} at
 * commit <code>98ba37aa412093a3158fd18d5481c2d476ef84ac</code> can be found in file
 * <code>"n4js/plugins/org.eclipse.n4js.lang.tests/src/org/eclipse/n4js/tests/log_20211207_1630.txt"</code>
 * (20788 files: good 20281 (97.5%) / bad 507 (2.4%)).
 * <p>
 * Method {@link #testFolder()} for folder {@link #TYPE_SCRIPT_LIBS} show no parse errors and
 * for folder {@link #NODE_API} only three parse errors related to assert functions.
 */
class DtsParserTest extends AbstractParserTest {

	private Path FILE_TEST = Path.of("/Users/mark-oliver.reiser/Desktop/dtsParser/test.d.ts");
	private Path FILE_ES5 = Path.of("/Users/mark-oliver.reiser/Desktop/TTT-IDE-3540/ts-libs/es5.d.ts");
	private Path FILE_TEMP = Path.of("/Users/mark-oliver.reiser/Desktop/dtsParser/DefinitelyTyped/types/actioncable/index.d.ts");
	private Path TYPE_SCRIPT_LIBS = Path.of("/Users/mark-oliver.reiser/Desktop/TTT-IDE-3540/ts-libs"); // subfolder 'libs' in TypeScript git repository
	private Path DEFINITELY_TYPED = Path.of("/Users/mark-oliver.reiser/Desktop/dtsParser/DefinitelyTyped/types");
	private Path NODE_API = Path.of("/Users/mark-oliver.reiser/Desktop/dtsParser/DefinitelyTyped/types/node");

	private String[] DEFINITELY_TYPED__EXCLUDED_PACKAGES = #[
		"carbon__icons-react", "carbon__pictograms-react"
	];

	@BeforeClass
	def static void turnOffASTStructureValidator() {
		ASTStructureValidator.SUPPRESS_AST_STRUCTURE_VALIDATION = true;
	}

	@AfterClass
	def static void turnOnASTStructureValidator() {
		ASTStructureValidator.SUPPRESS_AST_STRUCTURE_VALIDATION = false;
	}

	@Test
	def void testSingleFile() {
//		val file = FILE_TEST;
//		val file = FILE_ES5;
		val file = FILE_TEMP;
		val code = Files.readString(file);
		val idx = code.indexOf("%%END");
		val codeTrimmed = if (idx>=0) code.substring(0, idx) else code;
		val script = codeTrimmed.parseN4jsdSuccessfully;
	}

	@Test
	def void testFolder() {
//		val folder = TYPE_SCRIPT_LIBS;
//		val folder = NODE_API;
		val folder = DEFINITELY_TYPED;
		val files = Files.walk(folder, FileVisitOption.FOLLOW_LINKS)
			.filter[fileName.toString.endsWith(".d.ts")]
			.filter[!isExcluded]
			.collect(Collectors.toList);
		Collections.sort(files, [p1,p2|p1.toString.compareTo(p2.toString)]);
		val filesCount = files.size;
		println("Processing " + filesCount + " files ...");
		var int good = 0;
		var int bad = 0;
		for (file : files) {
			val code = Files.readString(file);
			val script = code.parse(JavaScriptVariant.external);
			val diags = script.eResource.errors;
			if (!diags.empty) {
				bad++;
				println("PARSE ERROR in " + file);
				println("    " + diags.map[line + ',' + column + ': ' + message].head)
				println("    " + getLine(code, diags.head.line).trim);
			} else {
				good++;
				println("ok: " + file);
			}
		}
		println("Done processing " + filesCount + " files: good " + good + " (" + percent(good, filesCount) + "%) / bad " + bad + " (" + percent(bad, filesCount) + "%).");
		assertEquals(filesCount, good + bad);
	}

	def private boolean isExcluded(Path path) {
		val pathStr = path.toString;
		for (name : DEFINITELY_TYPED__EXCLUDED_PACKAGES) {
			if (pathStr.startsWith("/Users/mark-oliver.reiser/Desktop/dtsParser/DefinitelyTyped/types/" + name + "/")) {
				return true;
			}
		}
		return false;
	}

	def private String getLine(String str, int lineNo) {
		val lines = str.split("\\n");
		return if (lines.length >= lineNo) lines.get(lineNo - 1) else "<line not found>";
	}

	def private double percent(int n, int full) {
		return Math.floor(((n as double) / (full as double)) * 1000.0) / 10.0;
	}
}
