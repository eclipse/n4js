// Generated by N4JS transpiler; for copyright see original N4JS source file.

import 'n4js-runtime'

"use strict";
import * as lib_n4jsc from './n4jsc'
import * as lib_fs from 'fs'
import * as lib_http from 'http'
import * as lib_https from 'https'
import * as log from 'npmlog'

const env = process.env;
const jarPath = env.N4JSC_JAR;
if (jarPath) {
	const outPath = lib_n4jsc.getN4jscPath();
	log.info(`${env.npm_package_name}@${env.npm_package_version}`, `Replacing ${outPath} with ${jarPath}`);
	if (lib_fs.existsSync(outPath)) {
		lib_fs.unlinkSync(outPath);
	}
	if (/^https?:\/\//i.test(jarPath)) {
		const stream = lib_fs.createWriteStream(outPath);
		const download = (url)=>{
			const callback = (resp)=>{
				if (Math.trunc(resp.statusCode / 100) === 3 && resp.headers.location) {
					download(resp.headers.location);
				} else {
					if (resp.statusCode !== 200) {
						throw new Error(`Request on ${url} failed: ${resp.statusCode}`);
					}
					resp.pipe(stream);
				}
			};
			if (/^http:\/\//i.test(url)) {
				lib_http.get(url, undefined, callback);
			} else {
				lib_https.get(url, undefined, callback);
			}
		};
		download(jarPath);
	} else {
		lib_fs.copyFileSync(jarPath, outPath);
	}
}
lib_n4jsc.ensureJRE();
//# sourceMappingURL=npm-postinstall.map
