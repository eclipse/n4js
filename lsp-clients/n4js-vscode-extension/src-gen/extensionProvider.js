// Generated by N4JS transpiler; for copyright see original N4JS source file.

import 'n4js-runtime'
import * as n4jscli from 'n4js-cli'
import * as n4jsc from 'n4js-cli/src-gen/n4jsc'
import * as net from 'net'
import * as VSCodeJRCP from 'vscode-jsonrpc'

const PORT = 5007;
let n4jscProcess;
export function getActivate(vscode, vscodeLC) {
	return (context)=>{
		let outputChannel = vscode.window.createOutputChannel('N4JS Language Server');
		let serverOptions = async()=>{
			outputChannel.appendLine("Start LSP extension");
			let socket = await connectToRunningN4jsLspServer(PORT, outputChannel);
			if (!socket) {
				outputChannel.appendLine("Unable to connect to an already running LSP server (port=" + PORT + "). Start new instance.");
				socket = await startN4jsLspServerAndConnect(PORT, outputChannel);
			}
			let result = {
				writer: socket,
				reader: socket,
				process: n4jscProcess,
				detached: true
			};
			return Promise.resolve(result);
		};
		let clientOptions = {
			documentSelector: [
				{
					scheme: 'file',
					language: 'n4js'
				},
				{
					scheme: 'n4scheme',
					language: 'n4js'
				},
				{
					scheme: 'untitled',
					language: 'n4js'
				}
			],
			synchronize: {
				fileEvents: vscode.workspace.createFileSystemWatcher('{/**/*.+(n4js|n4jsd|n4jsx|n4idl),/**/package.json}')
			},
			outputChannel: outputChannel
		};
		let lc = new vscodeLC.LanguageClient('N4JS Language Server', serverOptions, clientOptions, true);
		lc.trace = VSCodeJRCP.Trace.Verbose;
		lc.onReady().then(()=>{
			const requestType = new vscodeLC.RequestType('n4/documentContents');
			const textDocumentContentProvider = {
				provideTextDocumentContent: (uri, token)=>{
					return lc.sendRequest(requestType, {
						uri: uri.toString()
					}, token).then((v)=>{
						return v || '';
					});
				}
			};
			context.subscriptions.push(vscode.workspace.registerTextDocumentContentProvider('n4scheme', textDocumentContentProvider));
		});
		let disposableLangClient = lc.start();
		context.subscriptions.push(disposableLangClient);
	};
}
export function getDeactivate(vscode, vscodeLC) {
	return ()=>{
		if (!n4jscProcess) {
			return undefined;
		}
		n4jscProcess.kill();
		return new Promise((resolve, reject)=>{
			n4jscProcess.on('exit', ()=>{
				resolve();
			});
		});
	};
}
async function startN4jsLspServerAndConnect(port, outputChannel) {
	let logFn = (text)=>outputChannel.appendLine(text);
	await n4jsc.ensureJRE(logFn);
	let env = Object.assign({
		NODEJS_PATH: process.argv[0]
	}, process.env);
	let spawnOptions = {
		env: env
	};
	n4jscProcess = n4jscli.n4jscProcess('lsp', undefined, {
		port: port
	}, spawnOptions, logFn);
	n4jscProcess.stdout.on('data', (data)=>outputChannel.append(data.toString()));
	n4jscProcess.stderr.on('data', (data)=>outputChannel.append(data.toString()));
	n4jscProcess.on('message', (data)=>outputChannel.append(data.toString()));
	let serverReady = new Promise((resolve, reject)=>{
		let waitForListenMsg = (data)=>{
			let $opt;
			let receivedServerOutput = data.toString();
			if (($opt = receivedServerOutput) == null ? void 0 : $opt.startsWith("Listening for LSP clients")) {
				n4jscProcess.stdout.removeListener("data", waitForListenMsg);
				resolve();
			}
		};
		n4jscProcess.stdout.on('data', waitForListenMsg);
	});
	await serverReady;
	let socket = net.connect({
		port: port
	});
	return socket;
}
async function connectToRunningN4jsLspServer(port, outputChannel) {
	let timeout = 1000;
	let connectionPromise = new Promise((resolve, reject)=>{
		try {
			let timer = setTimeout(()=>{
				clientSocket.end();
				resolve(null);
			}, timeout);
			let clientSocket = net.createConnection({
				port: port
			});
			clientSocket.on('connect', ()=>{
				outputChannel.appendLine("Connected to a already running LSP server (port=" + PORT + ")");
				clearTimeout(timer);
				resolve(clientSocket);
			});
			clientSocket.on('error', (err)=>{
				clearTimeout(timer);
				clientSocket.destroy();
				resolve(null);
			});
			clientSocket.on('disconnect', ()=>{
				resolve(null);
			});
		} catch(err) {}
		return null;
	});
	let result = await connectionPromise;
	return result;
}
async function sleep(ms) {
	return new Promise((resolve)=>{
		setTimeout(resolve, ms);
	});
}
//# sourceMappingURL=extensionProvider.map
