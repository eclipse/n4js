import * as ts from "typescript";
import * as path from "path";
import * as model from "./model";
import * as utils from "./utils";
import * as utils_ts from "./utils_ts";

export class Converter {
	readonly program: ts.Program;
	readonly checker: ts.TypeChecker;
	readonly projectPath?: string;

	legacyExportedNamespace: ts.Symbol;
	readonly issues: utils.Issue[] = [];

	constructor(program: ts.Program, projectPath?: string) {
		if (projectPath !== undefined && !path.isAbsolute(projectPath)) {
			throw "projectPath must be absolute";
		}

		this.program = program;
		this.checker = program.getTypeChecker();
		this.projectPath = projectPath;
	}

	convertScript(sourceFilePath: string): model.Script {
		// clean up
		this.legacyExportedNamespace = undefined;
		this.issues.length = 0;

		const sourceFile = this.program.getSourceFile(sourceFilePath);
		const dtsMode = utils_ts.getDTSMode(sourceFile);

		if (dtsMode == model.DTSMode.LEGACY) {
			const legacyExport = utils_ts.getExportEquals(sourceFile);
			const sym = this.checker.getSymbolAtLocation(legacyExport.expression);
			if (utils.testFlagsOR(sym.flags, ts.SymbolFlags.ValueModule, ts.SymbolFlags.NamespaceModule)) {
				this.legacyExportedNamespace = sym;
			}
		}

		const result = new model.Script();
		result.mode = dtsMode;
		sourceFile.forEachChild(node => {
			if (ts.isImportDeclaration(node)) {
				const imports = this.convertImport(node);
				result.imports.push(...imports);
			} else {
				const elems = this.convertExportableElement(node);
				result.topLevelElements.push(...elems);
			}
		});
		result.issues.push(...this.issues);

		return result;
	}

	private convertImport(node: ts.ImportDeclaration): model.Import[] {
		const moduleSpecifier = this.convertModuleSpecifier(node);
		if (moduleSpecifier === undefined) {
			return [];
		}
		const bindings = node.importClause?.namedBindings;
		if (ts.isNamespaceImport(bindings)) {
			const sym = this.checker.getSymbolAtLocation(bindings.name);
			const result = new model.NamespaceImport();
			result.moduleSpecifier = moduleSpecifier;
			result.namespaceName = sym.getName();
			return [ result ];
		} else if (ts.isNamedImports(bindings)) {
			const results = [];
			for (const importSpecifier of bindings.elements) {
				const symImportedElement = this.checker.getSymbolAtLocation(importSpecifier.name);
				const symAlias = importSpecifier.propertyName !== undefined ? this.checker.getSymbolAtLocation(importSpecifier.propertyName) : undefined;
				const result = new model.NamedImport();
				result.moduleSpecifier = moduleSpecifier;
				result.importedElementName = symImportedElement.getName();
				if (symAlias) {
					result.aliasName = symAlias.getName();
				}
				results.push(result);
			}
			return results;
		}
		this.createIssueForUnsupportedNode(node, "import");
		return [];
	}

	private convertExportableElement(node: ts.Node): model.ExportableElement[] {
		if (node.kind === ts.SyntaxKind.EndOfFileToken) {
			return []; // ignore
		}
		const typeKind = utils_ts.getTypeKind(node);
		if (ts.isImportDeclaration(node)) {
			return []; // imports are handled in #convertScript(), ignore them here
		} else if (ts.isExportAssignment(node) && node.isExportEquals) {
			return []; // "export equals" was handled in #convertScript() as part of legacy support, ignore it here
		} else if (ts.isExportAssignment(node) && !node.isExportEquals) { // default exports
			return []; // TODO!!!
		} else if (ts.isVariableDeclarationList(node)) {
			return this.convertVariableDeclList(node); // TODO can a VariableDeclarationList even appear here?
		} else if (ts.isFunctionDeclaration(node)) {
			return [ this.convertFunction(node) ];
		} else if (typeKind !== undefined) {
			return [ this.convertType(node as ts.NamedDeclaration) ];
		} else if (node.kind === ts.SyntaxKind.FirstStatement) {
			const children = utils_ts.getAllChildNodes(node);
			if (children.length === 2
				&& (children[0].kind === ts.SyntaxKind.ExportKeyword
					|| children[0].kind === ts.SyntaxKind.DeclareKeyword)
				&& children[1].kind === ts.SyntaxKind.VariableDeclarationList) {
				// something like "export var someStr: string, someNum: number;"
				return this.convertVariableDeclList(children[1] as ts.VariableDeclarationList);
			}
		} else if (ts.isModuleDeclaration(node)) {
			const sym = this.checker.getSymbolAtLocation(node.name);
			if (sym === this.legacyExportedNamespace) {
				const result = [];
				node.body.forEachChild(child => {
					result.push(...this.convertExportableElement(child));
				});
				return result;
			}
		}
		this.createIssueForUnsupportedNode(node);
		return [];
	}

	private convertVariableDeclList(node: ts.VariableDeclarationList): model.Variable[] {
		const keyword = utils_ts.getVarDeclKeyword(node);
		const result = [] as model.Variable[];
		for (const varDecl of node.declarations) {
			result.push(this.convertVariable(varDecl, keyword));
		}
		return result;
	}

	private convertVariable(node: ts.VariableDeclaration, keyword: 'var' | 'let' | 'const'): model.Variable {
		const sym = this.checker.getSymbolAtLocation(node.name);
		const varName = sym.getName();

		const result = new model.Variable();
		result.name = varName;
		result.keyword = keyword;
		result.typeStr = this.convertTypeReference(node.type);
		result.exported = utils_ts.isExported(node);
		return result;
	}

	private convertFunction(node: ts.FunctionDeclaration): model.Function {
		const sym = this.checker.getSymbolAtLocation(node.name);
		const funName = sym.getName();
		const funSigs = this.convertCallSignatures(sym);

		const result = new model.Function();
		result.name = funName;
		result.signatures = funSigs;
		result.exported = utils_ts.isExported(node);
		return result;
	}

	private convertType(node: ts.NamedDeclaration): model.Type {
		const sym = this.checker.getSymbolAtLocation(node.name);
		const kind = utils_ts.getTypeKind(node);

		let result = new model.Type();
		result.name = sym.getName();
		result.kind = kind;
		result.defSiteStructural = kind == 'class' || kind == 'interface' ? true : undefined;
		result.exported = utils_ts.isExported(node);

		sym.members?.forEach((symMember, name) => {
			const member = this.convertMember(symMember, sym);
			if (member !== undefined) {
				result.members.push(member);
			}
		});

		return result;
	}

	private convertMember(symMember: ts.Symbol, symOwner: ts.Symbol): model.Member {
		// we need an AST node; in case of overloading there will be several declarations (one per signature)
		// but because relevant properties (kind, accessibility, etc.) will be the same in all cases we can
		// simply use the first one as representative:
		const nodeOfFirstDecl = symMember.declarations[0] as ts.NamedDeclaration;

		const result = new model.Member();
		result.accessibility = utils_ts.getAccessibility(nodeOfFirstDecl);

		if (ts.isConstructorDeclaration(nodeOfFirstDecl)) {
			result.kind = 'ctor';
			result.signatures = this.convertConstructSignatures(symOwner);
			return result;
		}

		result.name = symMember.getName();

		if (ts.isPropertyDeclaration(nodeOfFirstDecl)) {
			result.kind = 'field';
			result.typeStr = this.convertTypeReferenceOfTypedSymbol(symMember);
			return result;
		} else if (ts.isMethodDeclaration(nodeOfFirstDecl)
				|| ts.isMethodSignature(nodeOfFirstDecl)) {
			const sigs = this.convertCallSignatures(symMember);
			result.kind = 'method';
			result.signatures = sigs;
			return result;
		}
		this.createIssueForUnsupportedNode(nodeOfFirstDecl, "member");
		return undefined;
	}

	private convertConstructSignatures(somethingWithCtors: ts.Symbol): model.Signature[] {
		const type = this.checker.getTypeOfSymbolAtLocation(somethingWithCtors, somethingWithCtors.valueDeclaration!);
		return this.convertSignatures([...type.getConstructSignatures()]);
	}

	private convertCallSignatures(somethingWithSignatures: ts.Symbol): model.Signature[] {
		const type = this.checker.getTypeOfSymbolAtLocation(somethingWithSignatures, somethingWithSignatures.valueDeclaration!);
		return this.convertSignatures([...type.getCallSignatures()]);
	}

	private convertSignatures(signatures: ts.Signature[]): model.Signature[] {
		const results = [] as model.Signature[];
		for (const sig of signatures) {
			const result = new model.Signature();
			result.parameters = sig.getParameters().map(param => this.convertParameter(param));
			result.returnTypeStr = this.convertTypeReferenceOfTypedDeclaration(sig.declaration);
			results.push(result);
		}
		return results;
	}

	private convertParameter(param: ts.Symbol): model.Parameter {
		const result = new model.Parameter();
		result.name = param.getName();
		result.typeStr = this.convertTypeReferenceOfTypedSymbol(param);
		return result;
	}

	private convertModuleSpecifier(importDecl: ts.ImportDeclaration): string {
		const moduleSpec = importDecl.moduleSpecifier;
		if (!ts.isStringLiteral(moduleSpec)) {
			return undefined; // this is a syntax error in TS
		}
		let moduleSpecStr = moduleSpec.text;
		if (moduleSpecStr.startsWith(".")) {
			if (this.projectPath !== undefined) {
				const srcFilePath = path.dirname(importDecl.getSourceFile().fileName);
				const srcFilePathAbs = path.isAbsolute(srcFilePath) ? srcFilePath : path.resolve(srcFilePath);
				const trgtFilePath = path.resolve(srcFilePathAbs, moduleSpecStr).normalize();
				moduleSpecStr = path.relative(this.projectPath, trgtFilePath);
			} else {
				this.issues.push(utils.error("cannot resolve relative module specifier in single-file mode: " + moduleSpecStr));
			}
		}
		return moduleSpecStr;
	}

	private convertTypeReferenceOfTypedSymbol(sym: ts.Symbol): string {
		// note: the following API might be of use when proper handling of type references is being implemented:
		// const symType = this.checker.getTypeOfSymbolAtLocation(sym, sym.valueDeclaration!);
		// const typeAsStr = this.checker.typeToString(symType);
		return this.convertTypeReferenceOfTypedDeclaration(sym.valueDeclaration);
	}
	private convertTypeReferenceOfTypedDeclaration(decl: ts.Declaration): string {
		const typeRef = (decl as any).type; // no common interface available
		if (typeRef !== undefined && ts.isTypeNode(typeRef)) {
			return this.convertTypeReference(typeRef);
		}
		return undefined;
	}
	private convertTypeReference(node?: ts.TypeNode): string {
		return node?.getText().trim();
	}

	private createIssueForUnsupportedNode(node: ts.Node, superKind: string = "node") {
		const nodeKindStr = ts.SyntaxKind[node.kind];
		const offendingCode = utils_ts.getSourceCodeForNode(node);
		const error = utils.error("unsupported kind of " + superKind + ": " + nodeKindStr + "\n" + offendingCode);
		this.issues.push(error);
	}
}
