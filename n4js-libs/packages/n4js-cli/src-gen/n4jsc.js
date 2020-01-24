// Generated by N4JS transpiler; for copyright see original N4JS source file.

import 'n4js-runtime'
import * as path from 'path'
import * as childProcess from 'child_process'
import * as fs from 'fs'
import * as lib_decompress from 'decompress'
import * as log from 'npmlog'
import * as followRedirects from 'follow-redirects'

const decompress = (lib_decompress);
const JAVA_DEFAULT = "java";
const JRE_VERSION_START = "11.";
const JRE_LOCAL_DIR = "jre";
const JRE_URL_DIR = "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.6%2B10/";
const JRE_INFO_MAP = new Map([
	[
		'aix',
		{
			bin: "bin/java",
			name: "OpenJDK11U-jre_ppc64_aix_hotspot_11.0.6_10.tar.gz"
		}
	],
	[
		'darwin',
		{
			bin: "Contents/Home/bin/java",
			name: "OpenJDK11U-jre_x64_mac_hotspot_11.0.6_10.tar.gz"
		}
	],
	[
		'freebsd',
		{
			bin: "bin/java",
			name: "OpenJDK11U-jre_x64_linux_hotspot_11.0.6_10.tar.gz"
		}
	],
	[
		'linux',
		{
			bin: "bin/java",
			name: "OpenJDK11U-jre_x64_linux_hotspot_11.0.6_10.tar.gz"
		}
	],
	[
		'openbsd',
		{
			bin: "bin/java",
			name: "OpenJDK11U-jre_x64_linux_hotspot_11.0.6_10.tar.gz"
		}
	],
	[
		'sunos',
		null
	],
	[
		'win32',
		{
			bin: "bin/java",
			name: "OpenJDK11U-jre_x86-32_windows_hotspot_11.0.6_10.zip"
		}
	]
]);
var JreInfo = {};
JreInfo.$fieldDefaults = {
	bin: undefined,
	name: undefined
};
JreInfo.$methods = {};
$makeInterface(JreInfo, undefined, function(instanceProto, staticProto) {
	var metaClass = new N4Interface({
		name: 'JreInfo',
		origin: 'n4js-cli',
		fqn: 'n4jsc/JreInfo',
		n4superType: undefined,
		allImplementedInterfaces: [],
		ownedMembers: [
			new N4DataField({
				name: 'bin',
				isStatic: false,
				annotations: []
			}),
			new N4DataField({
				name: 'name',
				isStatic: false,
				annotations: []
			})
		],
		consumedMembers: [],
		annotations: []
	});
	return metaClass;
});
export async function runN4jscSync() {
	const args = getArgs();
	let exitCode = await runN4jsc(args);
	if (exitCode !== 0) {
		process.exit(exitCode);
	}
}
export function runN4jsc(args) {
	let java = getJavaCommand();
	if (!/-Xmx/.test(process.env.JAVA_TOOL_OPTIONS)) {
		args.unshift("-Xmx4096m");
	}
	let p = new Promise((resolve, reject)=>{
		childProcess.spawn(java, args, {
			stdio: "inherit",
			env: Object.assign({
				NODEJS_PATH: process.argv[0]
			}, process.env)
		}).on("close", (code)=>{
			if (code === 0) {
				resolve(0);
			} else {
				reject(code);
			}
		});
	});
	return p;
}
export function getN4jscPath() {
	return path.resolve(__dirname, "..", "bin", "n4jsc.jar");
}
function getArgs() {
	const args = [
		"-jar",
		getN4jscPath()
	].concat(process.argv.slice(2));
	return args;
}
function getJavaCommand() {
	const jreInfo = JRE_INFO_MAP.get(process.platform);
	if (jreInfo) {
		const absJreDir = process.cwd() + "/" + JRE_LOCAL_DIR;
		if (fs.existsSync(absJreDir)) {
			const directories = fs.readdirSync(absJreDir, {
				withFileTypes: true
			});
			const dirNames = directories.filter((dirent)=>dirent.isDirectory()).map((dirent)=>dirent.name);
			for(const dirName of dirNames) {
				const absJreJavaPath = absJreDir + "/" + dirName + "/" + jreInfo.bin;
				if (fs.existsSync(absJreJavaPath)) {
					log.info("n4js-cli", "Using JRE of n4jsc/bin/" + JRE_LOCAL_DIR + "/" + dirName);
					return absJreJavaPath;
				}
			}
		}
	}
	return JAVA_DEFAULT;
}
export async function ensureJRE() {
	const version = getJavaVersion();
	if (version && version.startsWith(JRE_VERSION_START)) {
		log.info("n4js-cli", "JRE found.");
		return;
	}
	const java = getJavaCommand();
	if (java != JAVA_DEFAULT) {
		return;
	}
	const jreInfo = JRE_INFO_MAP.get(process.platform);
	if (jreInfo) {
		log.info("n4js-cli", "JRE not found. Downloading and extracting JRE into local folder.");
		await downloadJRE(jreInfo);
		extractJRE(jreInfo);
	} else {
		log.info("n4js-cli", "Platform not supported: " + process.platform);
		log.info("n4js-cli", "Please install JRE11+ and make the call to 'bin/java' globally available.");
	}
}
function getJavaVersion() {
	const spawn = childProcess.spawnSync('java', [
		'-version'
	]);
	if (spawn.error) {
		return spawn.error.toString();
	}
	if (spawn.stderr) {
		const data = spawn.stderr.toString().split('\n')[0];
		const javaVersion = new RegExp('java version').test(data) ? data.split(' ')[2].replace(/"/g, '') : false;
		if (javaVersion !== false) {
			return javaVersion;
		} else {
			return null;
		}
	}
	return null;
}
async function downloadJRE(jreInfo) {
	const jreUrl = JRE_URL_DIR + jreInfo.name;
	log.info("n4js-cli", "downloading JRE from " + jreUrl);
	return new Promise((resolve, reject)=>{
		followRedirects.https.get(jreUrl, (response)=>{
			const file = fs.createWriteStream(jreInfo.name);
			response.pipe(file);
			log.info("n4js-cli", "receiving JRE ...");
			response.on("error", (err)=>{
				log.error("n4js-cli", err);
				reject(err);
			});
			response.on("end", ()=>{
				log.info("n4js-cli", "JRE written to file n4js-cli/bin/" + jreInfo.name);
				resolve();
			});
		});
	});
}
function extractJRE(jreInfo) {
	const outputDir = process.cwd() + "/" + JRE_LOCAL_DIR;
	log.info("n4js-cli", "Cleaning " + outputDir);
	if (fs.existsSync(outputDir)) {
		fs.rmdirSync(outputDir);
	}
	decompress(jreInfo.name, outputDir).then((files)=>{
		log.info("n4js-cli", "JRE extracted to " + outputDir);
	});
}
//# sourceMappingURL=n4jsc.map
