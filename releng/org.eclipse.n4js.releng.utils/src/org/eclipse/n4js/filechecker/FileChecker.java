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
package org.eclipse.n4js.filechecker;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;

/**
 * Sniffs through all files and checks them for integrity (copyright headers, formatting, Unix line endings, etc.).
 */
public class FileChecker extends AbstractFileChecker {

	private enum Mode {
		NORMAL, XSEMANTICS, XPECT
	}

	private static final Mode MODE = Mode.XSEMANTICS;

	private static final boolean FIX_FILE_ENDING = false;
	private static final boolean FIX_TRAILING_WHITE_SPACE = false;

	private static final String[] REPOS = { "n4js", "n4js-n4" }; // FIXME remove all references to "n4js-n4"
	private static final String[] REPOS_MANDATORY = { "n4js" };

	private static final String[] XSEMANTICS_REPOS = { "xsemantics" };
	private static final String[] XSEMANTICS_REPOS_MANDATORY = XSEMANTICS_REPOS;

	private static final String[] XPECT_REPOS = { "Xpect" };
	private static final String[] XPECT_REPOS_MANDATORY = XPECT_REPOS;

	/** Name used as vendor (in manifest.mf) and provider (in feature.xml). */
	private static final String PROVIDER_NAME = "Eclipse " + (MODE == Mode.XSEMANTICS ? "Xsemantics" : "N4JS")
			+ " Project";
	private static final String PROVIDER_NAME_N4 = "NumberFour AG";

	private static final String FILE_NAME__DOT_PROJECT = ".project";

	private static final String FILE_NAME__PLUGIN_PROPERTIES = "plugin.properties";
	private static final String FILE_NAME__MANIFEST_MF = "MANIFEST.MF";
	private static final String FILE_NAME__FEATURE_PROPERTIES = "feature.properties";
	private static final String FILE_NAME__FEATURE_XML = "feature.xml";

	/**
	 * Name of file containing the Eclipse Foundation Software User Agreement, see
	 * https://www.eclipse.org/legal/epl/notice.php
	 */
	private static final String FILE_NAME__NOTICE_HTML = "notice.html";

	/** Name of file with legal information to be placed in root folder of every bundle (except feature bundles). */
	private static final String FILE_NAME__ABOUT_HTML = "about.html";
	private static final String FILE_NAME__ABOUT_HTML_TEMPLATE = "about.html_TEMPLATE";

	/** Name of file with same content as "about.html" but in feature bundles. */
	private static final String FILE_NAME__LICENSE_HTML = "license.html";

	/** Name of file containing the Eclipse Public License. */
	private static final String FILE_NAME__EPL = "EPL-1.0.html";

	/** Extensions of files that should be checked more thoroughly. */
	private static final String[] FILE_EXTENSIONS = { ".java", ".xtend", ".xtext", ".xcore", ".xsemantics", ".xml",
			".mwe2", ".adoc", "Jenkinsfile", ".xt", ".n4jsx", ".n4jsd", ".n4mf" };

	/** These files will be ignored. May contain '/' but should not start or end with '/'. */
	private static final String[] IGNORED_FILES = {
			FILE_NAME__THIRD_PARTY, // third-party.txt may, of course, contain "copyright" or "license" in comments
			".antlr-generator-3.2.0-patch.jar", // downloaded by xtext but under git-ignore, so not in repository
			"plugins/org.eclipse.n4js.regex/model/generated/RegularExpression.genmodel", // generated by Xtext
			"prepareInitialCommit.sh", // removed in initial commit
	};

	/** All contents of these folders will be ignored. May contain '/' but should not start or end with '/'. */
	private static final String[] IGNORED_FOLDERS = {
			"xtend-gen", // under git-ignore, so not in repository
			// "plugins/org.eclipse.n4js.common.unicode/grammar-gen",
			"docs/org.eclipse.n4js.doc/src-gen", // under git-ignore, so not in repository
			"docs/org.eclipse.n4js.doc/generated-docs", // under git-ignore, so not in repository
			// "org.eclipse.n4js.jsdoc2spec.tests/testresourcesADoc", // test expectations (copyright header
			// unsupported)
			"tools/org.eclipse.n4js.hlc/target/wsp", // temporary test data under git-ignore, so not in repository
			".github", // removed in initial commit
			".git", // removed in initial commit
	};

	private static final String[] GENERATED_FOLDERS = {
			"src-gen",
			"emf-gen",
			"xsemantics-gen",
	};

	/** These file extensions are disallowed, EXCEPT the file is ignored or registered in file "third-party.txt". */
	private static final String[] BANNED_EXTENSIONS = {
			".jar",
			".zip"
	};

	/** Words disallowed outside of copyright headers. Each word should start with a single capitalized letter. */
	private static final String[] BANNED_WORDS = {
			"Copyright",
			"License",
			"numberfour.jira.com",
			"jira.numberfour.eu",

			// FIXME add more banned words (at least temporarily to prepare initial contribution):
			// "NumberFour",
			// "Number Four",
	};

	/** Endings of the paths (i.e. file names) that <b>can</b> contain {@link #BANNED_WORDS} */
	private static final String[] BANNED_WORDS_WHITELIST = {

			/* myself ;-) */
			AbstractFileChecker.class.getSimpleName() + ".java",
			FileChecker.class.getSimpleName() + ".java",
			Report.class.getSimpleName() + ".java",
			FullReport.class.getSimpleName() + ".java",
			ReportUtils.class.getSimpleName() + ".java",
			CRHStatsPrinter.class.getSimpleName() + ".java",

			/* prepareInitialCommit.sh */
			"prepareInitialCommit.sh",

			/* eclipse copyrights */
			FILE_NAME__NOTICE_HTML,
			FILE_NAME__ABOUT_HTML,
			FILE_NAME__ABOUT_HTML_TEMPLATE,
			FILE_NAME__LICENSE_HTML,
			FILE_NAME__EPL,
			"epl-v10.html",
			"asl-v20.txt",

			/* open source copyrights */
			"LICENSE",
			"LICENSE.md",
			"license",
			"license.adoc",
			"licenses.adoc",
			"README.md",
			"README.adoc",
			"readme.md",
			"package.json",
			"copyrightheader.adoc",

			/* N4JS documentation specific */
			"n4js/docs/org.eclipse.n4js.doc/src/userguides/index.adoc",
			"n4js/docs/org.eclipse.n4js.spec/N4JSSpec.adoc",
			"docs/index.html",
			"acronyms.adoc",

			/* our documentation includes some files with their own licenses */
			"scripts/highlight.min.js",
			"styles/adoc-readthedocs.css",
			"styles/foundation.css",
			"styles/foundation.css",

			/* markdown, license at the bottom */
			"n4js-libraries/eu.numberfour.mangelhaft.reporter.ide/messages.md",

			/* shell scripts, shebang before license */
			"n4js-libraries/n4js-node/src/js/n4js-cli.js",
			"plugins/org.eclipse.n4js.runner/res/ide-nodejs-env/n4js-node/n4js-cli.js",
			"plugins/org.eclipse.n4js.external.libraries/runtime/n4js-node/src/js/n4js-cli.js",
			"n4js-libraries/n4js-node-mangelhaft/src/js/n4js-mangelhaft-cli.js",
			"plugins/org.eclipse.n4js.runner/res/ide-nodejs-env/n4js-node-mangelhaft/n4js-mangelhaft-cli.js",
			"plugins/org.eclipse.n4js.external.libraries/runtime/n4js-node-mangelhaft/src/js/n4js-mangelhaft-cli.js",
			"n4js-libraries/n4js-node-mangelhaft/tests/npm-test.sh",
			"plugins/org.eclipse.n4js.external.libraries/runtime/n4js-node-mangelhaft/tests/npm-test.sh",

			/* templates */
			"plugins/org.eclipse.n4js.external.libraries/src/org/eclipse/n4js/external/libraries/PackageJson.java",
			"plugins/org.eclipse.n4js.external.libraries/src/org/eclipse/n4js/external/libraries/TargetPlatformFactory.xtend",
			"plugins/org.eclipse.n4js.npmexporter/src/org/eclipse/n4js/npmexporter/PackageJsonData.java",
			"plugins/org.eclipse.n4js.runner/schema/org.eclipse.n4js.runner.runners.exsd",
			"plugins/org.eclipse.n4js.utils/schema/org.eclipse.n4js.utils.fileExtensions.exsd",
			"plugins/org.eclipse.n4js.common.unicode/src/org/eclipse/n4js/common/unicode/generator/UnicodeGrammarGenerator.xtend",

			/* tests */
			"tests/org.eclipse.n4js.n4ide.spec.tests/xpect-test/Ch05_04_01_02__Organize_Imports/organize_imports/GHOLD_103/GHOLD_103.txt",
			"tests/org.eclipse.n4js.smoke.tests/src/org/eclipse/n4js/smoke/tests/GeneratedSmokeTestCases2.xtend",
			"tests/org.eclipse.n4js.lang.tests/src/org/eclipse/n4js/tests/contentassist/NodeModelTokenSourceTest.xtend",
			"tests/org.eclipse.n4js.lang.tests/src/org/eclipse/n4js/npmexporter/PackageJasonTemplateTest.xtend",

			/* update site */
			"releng/org.eclipse.n4js.targetplatform/N4JS.setup",
			"releng/org.eclipse.n4js.targetplatform/org.eclipse.n4js.targetplatform.target",

			/* product info needs to mention license */
			"builds/org.eclipse.n4js.product.build/org.eclipse.n4js.product.product",

			/* MWE2 workflows that generate files with copyright headers. */
			"plugins/org.eclipse.n4js/src/org/eclipse/n4js/GenerateN4JS.mwe2",
			"plugins/org.eclipse.n4js.common.unicode/src/org/eclipse/n4js/common/unicode/GenerateUnicode.mwe2",
			"plugins/org.eclipse.n4js.n4jsx/src/org/eclipse/n4js/n4jsx/GenerateN4JSX.mwe2",
			"plugins/org.eclipse.n4js.n4mf/src/org/eclipse/n4js/n4mf/GenerateN4MF.mwe2",
			"plugins/org.eclipse.n4js.regex/src/org/eclipse/n4js/regex/GenerateRegularExpression.mwe2",
			"plugins/org.eclipse.n4js.ts/src/org/eclipse/n4js/ts/GenerateTypes.mwe2",

			/* EMF packages contain banned words 'copyright' outside the copyright header (only interface). */
			"plugins/org.eclipse.n4js.jsdoc/emf-gen/org/eclipse/n4js/jsdoc/dom/DomPackage.java",
			"plugins/org.eclipse.n4js.model/emf-gen/org/eclipse/n4js/n4JS/N4JSPackage.java",
			"plugins/org.eclipse.n4js.n4jsx.model/emf-gen/org/eclipse/n4js/n4jsx/n4JSX/N4JSXPackage.java",
			"plugins/org.eclipse.n4js.n4mf.model/emf-gen/org/eclipse/n4js/n4mf/N4mfPackage.java",
			"plugins/org.eclipse.n4js.transpiler/emf-gen/org/eclipse/n4js/transpiler/im/ImPackage.java",
			"plugins/org.eclipse.n4js.ts.model/emf-gen/org/eclipse/n4js/ts/typeRefs/TypeRefsPackage.java",
			"plugins/org.eclipse.n4js.ts.model/emf-gen/org/eclipse/n4js/ts/types/TypesPackage.java",
			"plugins/org.eclipse.n4js.utils/emf-gen/org/eclipse/n4js/utils/validation/ValidationPackage.java",
			"tools/org.eclipse.n4js.hlc/src/main/resources/org/eclipse/emf/ecore/plugin/plugin.properties",

			/* API description is copied from ECMAScript Language Specification */
			"plugins/org.eclipse.n4js.environments/src-env/env/builtin_js.n4ts",
	};

	/** Same as {@link #BANNED_WORDS_WHITELIST}, but for Xsemantics. */
	private static final String[] XSEMANTICS_BANNED_WORDS_WHITELIST = {
			FILE_NAME__NOTICE_HTML,
			FILE_NAME__ABOUT_HTML,
			FILE_NAME__ABOUT_HTML_TEMPLATE,
			FILE_NAME__EPL,
			"LICENSE",
			"README.md",

			/* The following 4 files introduce & handle the keyword "copyright" of the Xsemantics DSL. */
			"plugins/it.xsemantics.dsl/model/custom/Xsemantics.ecore",
			"plugins/it.xsemantics.dsl/model/custom/Xsemantics.genmodel",
			"plugins/it.xsemantics.dsl/src/it/xsemantics/dsl/jvmmodel/XsemanticsJvmModelInferrer.xtend",
			"plugins/it.xsemantics.dsl/src/it/xsemantics/dsl/Xsemantics.xtext",

			/* The following 4 files contain documentation for keyword "copyright" of the Xsemantics DSL. */
			"/Users/mark-oliver.reiser/Home/Prog/Java/n4js-main/git-repo/xsemantics/doc/it.xsemantics.doc/contents/00-Main.html",
			"/Users/mark-oliver.reiser/Home/Prog/Java/n4js-main/git-repo/xsemantics/doc/it.xsemantics.doc/contents/00-Main_12.html",
			"/Users/mark-oliver.reiser/Home/Prog/Java/n4js-main/git-repo/xsemantics/doc/it.xsemantics.doc/contents/XsemanticsSyntax.html",
			"/Users/mark-oliver.reiser/Home/Prog/Java/n4js-main/git-repo/xsemantics/doc/it.xsemantics.doc/xdoc/00-Main.xdoc",
			"/Users/mark-oliver.reiser/Home/Prog/Java/n4js-main/git-repo/xsemantics/doc/it.xsemantics.doc/xdoc/XsemanticsSyntax.xdoc",

			/* Two test files for keyword "copyright" of the Xsemantics DSL. */
			"tests/it.xsemantics.dsl.tests/tests_input_files/header_test.xsemantics",
			"tests/it.xsemantics.dsl.tests/src/it/xsemantics/dsl/tests/generator/XsemanticsGeneratedFileHeaderTest.xtend",
	};

	/** Same as {@link #BANNED_WORDS_WHITELIST}, but for Xpect. */
	private static final String[] XPECT_BANNED_WORDS_WHITELIST = {
	};

	/** Files with an extension listed in {@link #FILE_EXTENSIONS} must start with this header. */
	private static final String[] COPYRIGHT_TEXT = {
			// "Copyright (c) 2016 NumberFour AG.",
			// "All rights reserved. This program and the accompanying materials",
			// "are made available under the terms of the Eclipse Public License v1.0",
			// "which accompanies this distribution, and is available at",
			// "http://www.eclipse.org/legal/epl-v10.html",
			// "",
			// "Contributors:",
			// " NumberFour AG - Initial API and implementation",

			/* Xpect: */
			// "Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.",
			// "All rights reserved. This program and the accompanying materials",
			// "are made available under the terms of the Eclipse Public License v1.0",
			// "which accompanies this distribution, and is available at",
			// "http://www.eclipse.org/legal/epl-v10.html",

			/* Xsemantics: */
			"Copyright (c) 2013-2017 Lorenzo Bettini.",
			"All rights reserved. This program and the accompanying materials",
			"are made available under the terms of the Eclipse Public License v1.0",
			"which accompanies this distribution, and is available at",
			"http://www.eclipse.org/legal/epl-v10.html",
			"",
			"Contributors:",
			"  Lorenzo Bettini - Initial contribution and API",
	};

	/** Files with an extension listed in {@link #FILE_EXTENSIONS} must start with this header. */
	private static final String COPYRIGHT_TEXT_SHORT = "Generated by N4JS transpiler; for copyright see original N4JS source file.";

	/**
	 * Files with an extension listed in {@link #FILE_EXTENSIONS} must start with this header (derived from
	 * {@link #COPYRIGHT_TEXT}).
	 */
	private static final String COPYRIGHT_HEADER = ("/**\n"
			+ " * " + Joiner.on("\n * ").join(COPYRIGHT_TEXT) + "\n"
			+ " */").replace("\n * \n",
					"\n *\n");

	/** Same as {@link #COPYRIGHT_HEADER}, but with more asterisks. Used in Xsemantics. */
	private static final String COPYRIGHT_HEADER_V2 = COPYRIGHT_HEADER
			.replace("/**\n", "/*******************************************************************************\n")
			.replace(" */", " *******************************************************************************/");

	/** JS files must start with this header (derived from {@link #COPYRIGHT_TEXT}). */
	private static final String COPYRIGHT_HEADER_JS = ("/*\n"
			+ " * " + Joiner.on("\n * ").join(COPYRIGHT_TEXT) + "\n"
			+ " */").replace("\n * \n", "\n *\n");

	/** XML files must start with this header (derived from {@link #COPYRIGHT_TEXT}). */
	private static final String COPYRIGHT_HEADER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<!--\n"
			+ Joiner.on("\n").join(COPYRIGHT_TEXT) + "\n"
			+ "-->";

	/** HTML files must start with this header (derived from {@link #COPYRIGHT_TEXT}). */
	private static final String COPYRIGHT_HEADER_HTML = "<!DOCTYPE HTML>\n"
			+ "<!--\n"
			+ Joiner.on("\n").join(COPYRIGHT_TEXT) + "\n"
			+ "-->";

	/** ADOC files must start with this header (derived from {@link #COPYRIGHT_TEXT}). */
	private static final String COPYRIGHT_HEADER_ADOC = "////\n"
			+ Joiner.on("\n").join(COPYRIGHT_TEXT) + "\n"
			+ "////";

	/** TEX files must start with this header (derived from {@link #COPYRIGHT_TEXT}). */
	private static final String COPYRIGHT_HEADER_TEX = ("%\n"
			+ "% " + Joiner.on("\n% ").join(COPYRIGHT_TEXT) + "\n"
			+ "%").replace(" \n", "\n");

	/** TEX files must start with this header (derived from {@link #COPYRIGHT_TEXT}). */
	private static final String COPYRIGHT_HEADER_SH = ("#\n"
			+ "# " + Joiner.on("\n# ").join(COPYRIGHT_TEXT) + "\n"
			+ "#").replace(" \n", "\n");

	/** XCORE files must contain this copyright notice directive (derived from {@link #COPYRIGHT_TEXT}). */
	private static final String COPYRIGHT_GEN_MODEL_PROPERTY = "copyrightText=\""
			+ Joiner.on("\\n").join(COPYRIGHT_TEXT) + "\"";

	/** Generated JS files must start with this header (derived from {@link #COPYRIGHT_TEXT_SHORT}). */
	private static final String COPYRIGHT_HEADER_JS_SHORT = "// " + COPYRIGHT_TEXT_SHORT;

	/** TXT files must start with this header. */
	private static final String COPYRIGHT_HEADER_TXT = "*******************************************************************************\n"
			+ Joiner.on("\n").join(COPYRIGHT_TEXT) + "\n"
			+ "*******************************************************************************";

	/** The copyright keyword together with the copyright text as optionally contained in .xsemantics files. */
	private static final String COPYRIGHT_KEYWORD_IN_XSEMANTICS = "copyright\n"
			+ '"' + Joiner.on("\n").join(COPYRIGHT_TEXT) + '"';

	/**
	 * When letting Xtext generate the AST model (only applies to the RegEx language), it corrupts the copyright header
	 * when adding it to the generated EMF .genmodel file. This results in all EMF-generated Java files having a bogus
	 * copyright header. This constant contains this bogus copyright header to not show file checker complaints in these
	 * cases.
	 */
	private static final String COPYRIGHT_HEADER_EMF_CODE_XTEXT_GENMODEL_BUG = COPYRIGHT_HEADER
			.replace("/**\n", "/**\n * *\n")
			.replace("\n *\n", "\n *  *\n");

	/** Copyright header for EMF-generated code in cases when Xcore was used as source. */
	private static final String COPYRIGHT_HEADER_EMF_CODE_VIA_XCORE = COPYRIGHT_HEADER
			.replace("\n *\n", "\n * \n");

	private static final String PATTERN_FEATURE_TAG = Pattern.quote("<feature")
			+ "\\s.*"
			+ Pattern.quote("provider-name=\"%providerName\"")
			+ "\\s+"
			+ Pattern.quote("license-feature=\"org.eclipse.license\"")
			+ "\\s+"
			+ Pattern.quote("license-feature-version=\"1.0.1.v20140414-1359\"")
			+ ".*"
			+ Pattern.quote(">");

	private static final String PATTERN_COPYRIGHT_TAG = Pattern.quote("<copyright>")
			+ "\\s*"
			+ Pattern.quote(Joiner.on("\n").join(COPYRIGHT_TEXT))
			+ "\\s*"
			+ Pattern.quote("</copyright>");

	private static final String PATTERN_LICENSE_TAG = Pattern.quote("<license url=\"%licenseURL\">")
			+ "\\s*"
			+ Pattern.quote("%license")
			+ "\\s*"
			+ Pattern.quote("</license>");

	/** A pattern to skip the package declaration and import statements at the top of a Java file. */
	private static final String PATTERN_JAVA_IMPORTS = "package [^;]*;\\n"
			+ "(\\s*((// .*)|(import [^;]*;))\\n)*"
			+ "\\s*";

	private static final Pattern PATTERN_FEATURE_TAG_COMPILED = Pattern.compile(PATTERN_FEATURE_TAG, Pattern.DOTALL);
	private static final Pattern PATTERN_COPYRIGHT_TAG_COMPILED = Pattern.compile(PATTERN_COPYRIGHT_TAG);
	private static final Pattern PATTERN_LICENSE_TAG_COMPILED = Pattern.compile(PATTERN_LICENSE_TAG);
	private static final Pattern PATTERN_JAVA_IMPORTS_COMPILED = Pattern.compile(PATTERN_JAVA_IMPORTS);

	// ################################################################################################################

	@Override
	protected String[] getRepos() {
		switch (MODE) {
		case XSEMANTICS:
			return XSEMANTICS_REPOS;
		case XPECT:
			return XPECT_REPOS;
		default:
			return REPOS;
		}
	}

	@Override
	protected String[] getReposMandatory() {
		switch (MODE) {
		case XSEMANTICS:
			return XSEMANTICS_REPOS_MANDATORY;
		case XPECT:
			return XPECT_REPOS_MANDATORY;
		default:
			return REPOS_MANDATORY;
		}
	}

	@Override
	protected boolean isIgnored(Path path, String pathStr) {
		if (path.endsWith("pom.xml"))
			return false; // never ignore pom.xml!
		if (isFile(pathStr, IGNORED_FILES))
			return true; // ignore ignored files
		if (isBelowFolder(pathStr, IGNORED_FOLDERS))
			return true; // ignore files in ignored folders
		if (hasExtension(path, ".prefs"))
			return true; // ignore Eclipse preferences
		if (hasExtension(path, ".bib"))
			return true; // ignore BibTeX files
		return false;
	}

	// ################################################################################################################

	private static final void fixCopyrightHeader(Path path, String content) {
		if (hasExtension(path, ".xml")) {
			final int preambleLen = COPYRIGHT_HEADER_XML.indexOf('\n') + 1;
			final String preamble = COPYRIGHT_HEADER_XML.substring(0, preambleLen);
			if (!content.startsWith(preamble)) {
				throw new IllegalStateException(
						"cannot fix copyright header of file " + path + ": does not start with preamble:\n" + preamble);
			}
			final String contentToKeep = content.substring(preambleLen);
			writeFile(path, COPYRIGHT_HEADER_XML + '\n' + contentToKeep);
		} else if (hasExtension(path, ".mwe2")) {
			writeFile(path, COPYRIGHT_HEADER + '\n' + content);
		} else {
			throw new UnsupportedOperationException(
					"cannot fix copyright header due to supported file extension: " + path);
		}
	}

	/**
	 * Invoked for every file for which {@link #isIgnored(Path, String)} returns <code>false</code>.
	 */
	@Override
	protected void checkFile(Path path, String content, boolean isRegisteredAsThirdParty, Report report) {

		if (!isRegisteredAsThirdParty) {
			if (path.endsWith(FILE_NAME__PLUGIN_PROPERTIES) || path.endsWith(FILE_NAME__FEATURE_PROPERTIES)) {
				checkFilePluginOrFeatureProperties(path, content, report);
			} else if (path.endsWith(FILE_NAME__MANIFEST_MF)) {
				checkFileManifestMF(path, content, report);
			} else if (path.endsWith(FILE_NAME__FEATURE_XML)) {
				checkFileFeatureXML(path, content, report);
			}
		}

		String[] moreCRHs = { ".xml", ".html", ".sh", ".tex", ".grammar", "adoc", "n4ts", "n4js", "n4jsx", "n4mf",
				"n4jsd", "xt_IN_FOLDER_my", "xt_", "xt_IN_FOLDER_P", "xt_IN_FOLDER_p", "xt.DISABLED", ".idx", ".js" };
		if (hasExtension(path, concat(FILE_EXTENSIONS, moreCRHs))) {
			if (hasCorrectCopyrightHeader(path, content)) {
				report.setToHasCRH();
			} else {
				if (path.toString().endsWith(".mwe2")) {
					fixCopyrightHeader(path, content);
				}
			}
		}

		if (hasExtension(path, ".xml")) { // FIXME apply ordinary checks to .xml files (by removing this special case)

			// special case: .xml files

			if (!hasCorrectCopyrightHeader(path, content)) {
				report.problems.add("does not contain correct copyright header");
			} else {
				// report.setToHasCRH();
			}

		} else if (hasExtension(path, BANNED_EXTENSIONS)) {

			// special case: banned file extensions

			if (!isRegisteredAsThirdParty) {
				report.problems.add("file has a banned file extension (add to third-party.txt or to IGNORED_FILES)");
			}

		} else {

			if (hasExtension(path, FILE_EXTENSIONS)) {

				// checks for files with one of the extensions in FILE_EXTENSIONS

				checkCommonFiles(path, content, isRegisteredAsThirdParty, report);
			}

			// checks for all files

			if (!isRegisteredAsThirdParty && !inN4Repo(path) && !canContainBannedWord(path)) {
				final String bannedWord = containsBannedWord(path, content);
				if (bannedWord != null) {
					report.problems.add("must not contain banned word '" + bannedWord + "'");
				}
			}
		}
	}

	static private String[] concat(String[] a, String[] b) {
		String[] array = new String[a.length + b.length];
		System.arraycopy(a, 0, array, 0, a.length);
		System.arraycopy(b, 0, array, a.length, b.length);
		return array;
	}

	private void checkCommonFiles(Path path, String content, boolean isRegisteredAsThirdParty, Report report) {
		if (content.contains("\r")) {
			report.problems.add("contains invalid line endings (i.e. contains carriage return: '\\r')");
		} else {
			if (!hasExtension(path, ".xt") && !isBelowFolder(path.toString(), GENERATED_FOLDERS)
					&& MODE != Mode.XSEMANTICS && MODE != Mode.XPECT) {
				// check file end (single '\n' character)
				final int len = content.length();
				final char charLast = len > 0 ? content.charAt(len - 1) : 0;
				final char char2ndToLast = len > 1 ? content.charAt(len - 2) : 0;
				if (len > 0 && (charLast != '\n' || char2ndToLast == '\n')) {
					report.problems.add("does not end with a single empty line");
					if (FIX_FILE_ENDING) {
						writeFile(path, fixFileEnding(content));
					}
				}
				// check line end (no trailing white-space)
				int lineNumber;
				if ((lineNumber = containsTrailingWhiteSpace(content)) > 0) {
					report.problems
							.add("must not contain lines with trailing white-space (line " + lineNumber + ")");
					if (FIX_TRAILING_WHITE_SPACE) {
						writeFile(path, trimTrailingWhiteSpace(content));
					}
				}
			}
			if (!isRegisteredAsThirdParty && !hasCorrectCopyrightHeader(path, content)) {
				report.problems.add("does not contain correct copyright header");
			} else {
				// report.setToHasCRH();
			}
			if (!isRegisteredAsThirdParty && hasExtension(path, ".xcore")
					&& !content.contains(COPYRIGHT_GEN_MODEL_PROPERTY)) {
				report.problems.add(".xcore file does not contain correct 'copyrightText' genModel property");
			}
			if (!isRegisteredAsThirdParty && MODE != Mode.XSEMANTICS
					&& !hasExtension(path, ".adoc") && content.contains("@" + "author")) {
				report.problems.add("must not contain author tags");
			}
		}
	}

	private void checkFilePluginOrFeatureProperties(Path path, String content, Report report) {
		final String kind = path.getFileName().toString().startsWith("feature.") ? "feature" : "plugin";
		final String pluginName = path.getName(path.getNameCount() - 2).toString();
		final String providerName = inN4Repo(path) ? PROVIDER_NAME_N4 : PROVIDER_NAME;
		if (!content.contains(kind + "Name = " + pluginName)) {
			report.problems.add("property " + kind + "Name missing or value != name of containing folder");
		}
		if (!content.contains("providerName = " + providerName)) {
			report.problems.add("property providerName missing or does not have value \"" + providerName + "\"");
		}
	}

	private void checkFileManifestMF(Path path, String content, Report report) {
		final String bundleSymbolicName = path.getName(path.getNameCount() - 3).toString();
		final String bundleSymbolicNamePropertyAndValue = "Bundle-SymbolicName: " + bundleSymbolicName;
		if (!content.contains(bundleSymbolicNamePropertyAndValue + "\n")
				&& !content.contains(bundleSymbolicNamePropertyAndValue + ";")) {
			report.problems.add("property 'Bundle-SymbolicName' missing or has incorrect value");
		}
		if (MODE != Mode.XSEMANTICS) {
			if (!content.contains("Bundle-Name: %pluginName")) {
				report.problems.add("property 'Bundle-Name' missing or does not have value \"%pluginName\"");
			}
		}
		if (!content.contains("Bundle-Vendor: %providerName")) {
			report.problems.add("property 'Bundle-Vendor' missing or does not have value \"%providerName\"");
		}
	}

	/** Check some required tags in feature.xml files and their values. */
	private void checkFileFeatureXML(Path path, String content, Report report) {
		if (inN4Repo(path)) {
			return; // don't check this in N4 repo
		}
		if (!containsPattern(content, PATTERN_FEATURE_TAG_COMPILED)) {
			report.problems.add("tag 'feature' missing or attributes 'provider-name', 'license-feature' are incorrect");
		}
		if (!containsPattern(content, PATTERN_COPYRIGHT_TAG_COMPILED)) {
			report.problems.add("tag 'copyright' missing or has an incorrect value");
		}
		if (!containsPattern(content, PATTERN_LICENSE_TAG_COMPILED)) {
			report.problems.add("tag 'license' missing or has an incorrect value");
		}
	}

	// ################################################################################################################

	/**
	 * Invoked for every folder for which {@link #isIgnored(Path, String)} returns <code>false</code>.
	 */
	@Override
	protected void checkFolder(Path path, int depth, Report report) {
		if (depth == 0) {
			checkFolderRepositoryRoot(path, report);
		} else if (depth == 2 && !isBelowFolder(path.toString(), "n4js/n4js-libraries")) {
			checkFolderBundleRoot(path, report);
		}
	}

	/** See Section 4.1 "Software User Agreement" at https://www.eclipse.org/legal/guidetolegaldoc.php */
	private void checkFolderRepositoryRoot(Path path, Report report) {
		if (inN4Repo(path)) {
			return; // don't check this in N4 repo
		}
		assertContainsFileWithName(path, FILE_NAME__NOTICE_HTML, report);
		assertContainsFileWithName(path, FILE_NAME__EPL, report);
	}

	private void checkFolderBundleRoot(Path path, Report report) {

		if (!containsFileWithName(path, FILE_NAME__DOT_PROJECT)) {
			report.problems.add("folder on level 2 does not contain an Eclipse '.project' file");
		}

		if (inN4Repo(path)) {
			if (isBelowFolder(path.toString(), "features")) {
				// feature bundles
				// nothing to check here
			} else {
				// all other bundles
				assertContainsFileWithName(path, FILE_NAME__PLUGIN_PROPERTIES, report);
			}
		} else {
			if (isBelowFolder(path.toString(), "features")) {
				// feature bundles
				// See Section 4.3 Features Licenses and Feature Update Licenses
				// at https://www.eclipse.org/legal/guidetolegaldoc.php
				//
				// NOTE: we do not use "license.html" files; instead we use the 'license-feature' attributes of the
				// 'feature' tag in the "feature.xml" file (checked in #checkFileFeatureXML())
				if (containsFileWithName(path, FILE_NAME__LICENSE_HTML)) {
					report.problems.add("feature bundles should not contain a '" + FILE_NAME__LICENSE_HTML
							+ "' file (because we are using property license-feature in feature.xml)");
				}
				if (containsFileWithName(path, FILE_NAME__ABOUT_HTML)) {
					report.problems.add("feature bundles should not contain an '" + FILE_NAME__ABOUT_HTML + "' file");
				}
				assertContainsFileWithName(path, FILE_NAME__FEATURE_PROPERTIES, report);
			} else {
				// all other bundles
				// See https://www.eclipse.org/legal/guidetolegaldoc.php#Abouts
				assertContainsFileWithName(path, FILE_NAME__ABOUT_HTML, report);
				assertContainsFileWithName(path, FILE_NAME__PLUGIN_PROPERTIES, report);
			}
		}
	}

	// ################################################################################################################
	// Utility Methods

	private static boolean hasCorrectCopyrightHeader(Path path, String content) {
		return beginIndexWithoutCopyrightHeader(path, content) > 0;
	}

	private void assertContainsFileWithName(Path path, String fileName, Report report) {
		if (!containsFileWithName(path, fileName)) {
			report.problems.add("folder missing required file: " + fileName);
		}
	}

	private static int beginIndexWithoutCopyrightHeader(Path path, String content) {
		if (hasExtension(path, ".xml")) {
			return beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_XML, false);

		} else if (hasExtension(path, ".html")) {
			return beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_HTML, false);

		} else if (hasExtension(path, ".adoc")) {
			return beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_ADOC, false);

		} else if (hasExtension(path, ".n4js", "n4jsx", ".n4jsd", ".n4mf", ".n4ts", "Jenkinsfile", ".xt",
				"xt_IN_FOLDER_my", "xt_", "xt_IN_FOLDER_P", "xt_IN_FOLDER_p", "xt.DISABLED")) {
			return beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_JS, false);

		} else if (hasExtension(path, ".js")) {
			int startPos = beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_JS, false);
			int startPosShort = beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_JS_SHORT, false);
			return Math.max(startPos, startPosShort);

		} else if (hasExtension(path, ".tex")) {
			return beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_TEX, false);

		} else if (hasExtension(path, ".sh", ".idx")) {
			return beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_SH, true);

		} else if (hasExtension(path, ".txt")) {
			return beginIndexWithoutCopyrightHeader(content, COPYRIGHT_HEADER_TXT, false);

		} else {
			int base = 0;
			// two tweaks for Xtext/EMF-generated code:
			if (isBelowFolder(path.toString(), GENERATED_FOLDERS)) {
				// tweak #1: sometimes, the copyright header appears below imports in Xtext-generated files
				if (hasExtension(path, ".java")) {
					Matcher m = PATTERN_JAVA_IMPORTS_COMPILED.matcher(content);
					if (m.lookingAt()) {
						base = m.end();
						content = content.substring(base);
					}
				}
				// tweak #2: copyright header corrupted in EMF-generated files, if Xtext generated the .genmodel file
				if (startsWithCopyrightHeader(content, COPYRIGHT_HEADER_EMF_CODE_XTEXT_GENMODEL_BUG)) {
					return base + COPYRIGHT_HEADER_EMF_CODE_XTEXT_GENMODEL_BUG.length();
				}
				// tweak #3: copyright header different in EMF-generated files, if Xcore was used as source
				if (startsWithCopyrightHeader(content, COPYRIGHT_HEADER_EMF_CODE_VIA_XCORE)) {
					return base + COPYRIGHT_HEADER_EMF_CODE_VIA_XCORE.length();
				}
			}
			if (startsWithCopyrightHeader(content, COPYRIGHT_HEADER)) {
				return base + COPYRIGHT_HEADER.length();
			}
			if (MODE == Mode.XSEMANTICS) {
				// Xsemantics may also use the slightly different version COPYRIGHT_HEADER_V2
				if (startsWithCopyrightHeader(content, COPYRIGHT_HEADER_V2)) {
					return base + COPYRIGHT_HEADER_V2.length();
				}
			}
			return 0;
		}
	}

	private static int beginIndexWithoutCopyrightHeader(String content, String header, boolean skipBashHeader) {
		int offset = 0;
		if (skipBashHeader && content.startsWith("#!/")) {
			offset = content.indexOf("\n") + 1;
		}
		int startPos = startsWithCopyrightHeader(content, header, offset) ? header.length() : 0;
		return startPos;
	}

	private static boolean startsWithCopyrightHeader(String content, String header) {
		return startsWithCopyrightHeader(content, header, 0);
	}

	private static boolean startsWithCopyrightHeader(String content, String header, int offset) {
		if (content.startsWith(header, offset))
			return true;
		if (content.startsWith(header.replace(" 2016 ", " 2017 "), offset)) // FIXME
			return true;
		return false;
	}

	private static boolean canContainBannedWord(Path path) {
		final String[] whiteList;
		switch (MODE) {
		case XSEMANTICS:
			whiteList = XSEMANTICS_BANNED_WORDS_WHITELIST;
			break;
		case XPECT:
			whiteList = XPECT_BANNED_WORDS_WHITELIST;
			break;
		default:
			whiteList = BANNED_WORDS_WHITELIST;
		}
		for (String whitelisted : whiteList) {
			if (path.endsWith(whitelisted)) {
				return true;
			}
		}
		return false;
	}

	private static String containsBannedWord(Path path, String content) {
		return containsWord(path, content, true, BANNED_WORDS);
	}

	private static String containsWord(Path path, String content, boolean skipCopyrightHeader, String... words) {
		// skip copyright header (if requested)
		if (skipCopyrightHeader) {
			final int beginIndex = beginIndexWithoutCopyrightHeader(path, content);
			content = content.substring(beginIndex);
			if (hasExtension(path, ".xcore")) {
				// FIXME consider cleaning this up
				content = content.replace("copyrightFields=\"false\",", "");
				content = content.replace(COPYRIGHT_GEN_MODEL_PROPERTY, "");
				content = content.replace(COPYRIGHT_GEN_MODEL_PROPERTY.replace(" 2016 ", " 2017 "), ""); // FIXME
			}
		}
		// skip "copyright" keyword in .xsemantics files
		if (hasExtension(path, ".xsemantics")) {
			final int idx = content.indexOf(COPYRIGHT_KEYWORD_IN_XSEMANTICS);
			if (idx >= 0) {
				content = content.substring(0, idx) + content.substring(idx + COPYRIGHT_KEYWORD_IN_XSEMANTICS.length());
			}
		}
		// actually check for contained words
		for (String word : words) {
			if (content.contains(word) || content.contains(word.toLowerCase()) // FIXME use containsIgnoreCase()
					|| content.contains(word.toUpperCase())) {
				return word;
			}
		}
		return null;
	}

	// ################################################################################################################

	/** Main method. */
	public static void main(String[] args) {
		final boolean success = new FileChecker().run(args);
		System.exit(success ? 0 : 1);
	}
}
