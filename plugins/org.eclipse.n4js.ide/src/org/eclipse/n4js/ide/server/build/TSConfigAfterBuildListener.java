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
package org.eclipse.n4js.ide.server.build;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.n4js.N4JSGlobals;
import org.eclipse.n4js.packagejson.PackageJsonModificationUtils;
import org.eclipse.n4js.utils.JsonUtils;
import org.eclipse.n4js.workspace.N4JSProjectConfigSnapshot;
import org.eclipse.n4js.xtext.ide.server.build.XBuildRequest;
import org.eclipse.n4js.xtext.ide.server.build.XBuildRequest.AfterBuildListener;
import org.eclipse.n4js.xtext.ide.server.build.XBuildResult;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * Executed after a single project was build. Ensures that there exists a ts.config file in the project folder and that
 * this file contains correct information.
 */
public class TSConfigAfterBuildListener implements AfterBuildListener {
	final N4JSProjectConfigSnapshot projectConfig;
	final File tsconfig;

	/** Constructor */
	public TSConfigAfterBuildListener(N4JSProjectConfigSnapshot projectConfig) {
		this.projectConfig = projectConfig;
		tsconfig = projectConfig.getPathAsFileURI().toPath().resolve(N4JSGlobals.TS_CONFIG).toFile();
	}

	@Override
	public void afterBuild(XBuildRequest request, XBuildResult result) {
		try {
			ensureTSConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ensureTSConfig() throws IOException {
		if (tsconfig.isFile()) {
			ensureContent();
		} else {
			createDefault();
		}
	}

	private void createDefault() throws IOException {
		String defaultTSConfig = "{\n"
				+ "    \"include\": [\"" + createIncludePath() + "\"],\n"
				+ "    \"exclude\": [\"node_modules\"],\n"
				+ "    \"compilerOptions\": {\n"
				+ "        \"target\": \"es5\",\n"
				+ "        \"lib\": [\"es2019\", \"es2020\"],\n"
				+ "        \"module\": \"commonjs\",\n"
				+ "        \"noImplicitAny\": false,\n"
				+ "    }\n"
				+ "}\n"
				+ "";

		Files.writeString(tsconfig.toPath(), defaultTSConfig);
	}

	private String createIncludePath() {
		return projectConfig.getOutputPath() + "/**/*.ts";
	}

	private void ensureContent() throws IOException {
		JsonElement json = JsonUtils.loadJson(tsconfig.toPath());
		JsonArray includeArr = json.getAsJsonObject().getAsJsonArray("include");
		String includePath = createIncludePath();
		for (JsonElement includeElem : includeArr) {
			String includeValue = includeElem.getAsString();
			if (Objects.equals(includeValue, includePath)) {
				return; // everything is fine
			}
		}

		// add include path to an existing ts.config
		JsonArray addToArray = new JsonArray();
		addToArray.add(includePath);
		Map<String, JsonElement> elements = new HashMap<>();
		elements.put("include", addToArray);
		PackageJsonModificationUtils.addProperties(tsconfig, elements.entrySet());
	}
}
