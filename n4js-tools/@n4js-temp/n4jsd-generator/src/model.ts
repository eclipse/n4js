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

import { CodeBuffer } from "./CodeBuffer";
import { globalOptions } from "./main";
import * as utils from "./utils";

export enum DTSMode {
	NONE,
	MODULE,
	LEGACY
}

export enum Accessibility {
	PUBLIC,
	PROTECTED,
	PRIVATE
}

export class Script {
	mode: DTSMode = DTSMode.NONE;
	imports: Import[] = [];
	topLevelElements: ExportableElement[] = [];
	issues: utils.Issue[] = [];
}

export abstract class Import {
	moduleSpecifier: string;
}

export class DefaultImport extends Import {
	localName: string;
}

export class NamespaceImport extends Import {
	namespaceName: string;
}

export class NamedImport extends Import {
	importedElementName: string;
	aliasName?: string;
}

export abstract class NamedElement {
	name: string;
}

export abstract class ExportableElement extends NamedElement {
	exported: boolean;
}

export class Variable extends ExportableElement {
	keyword: 'var' | 'let' | 'const';
	type: TypeRef;
}

export class Function extends ExportableElement {
	signatures: Signature[] = [];
}

export class Type extends ExportableElement {
	kind: 'enum' | 'interface' | 'class' | 'alias';
	defSiteStructural?: boolean;
	primitiveBased?: 'string' | 'number';
	literals: EnumLiteral[] = [];
	members: Member[] = [];
}

export class EnumLiteral extends NamedElement {
	value?: string | number;
}

export class Member extends NamedElement {
	kind: 'ctor' | 'field' | 'getter' | 'setter' | 'method';
	accessibility: Accessibility;
	/** Will be defined iff this member is a data field or field accessor. */
	type?: TypeRef;
	signatures?: Signature[];
}

export class Signature {
	parameters: Parameter[] = [];
	/** Will be undefined iff this signature belongs to a constructor. */
	returnType?: TypeRef;
}

export class Parameter extends NamedElement {
	type: TypeRef;
}

export class TypeRef {
	/** The type reference as given in the TypeScript source code. */
	tsSourceString: string;
}


export function scriptToString(script: Script): string {
    const emitter = new Emitter();
    emitter.emitScript(script);
    return emitter.getCode();
}

class Emitter {

	private buff: CodeBuffer = new CodeBuffer();

	getCode(): string {
		return this.buff.getCode();
	}

	emitScript(script: Script) {
		const buff = this.buff;
		if (script.imports.length > 0) {
			script.imports.forEach((elem, idx) => {
				if (idx > 0) {
					buff.pushln();
				}
				this.emitImport(elem);
			});
			buff.pushln();
			buff.pushln();
		}
		script.topLevelElements.forEach((elem, idx) => {
			if (idx > 0) {
				buff.pushln();
				buff.pushln();
			}
			this.emitExportableElement(elem);
		});
	}

	emitImport(elem: Import) {
		const buff = this.buff;
		buff.push("import ");
		if (elem instanceof DefaultImport) {
			buff.push(elem.localName, " ");
		} else if (elem instanceof NamespaceImport) {
			buff.push("* as ", elem.namespaceName, " ");
		} else if (elem instanceof NamedImport) {
			buff.push("{ ", elem.importedElementName);
			if (elem.aliasName !== undefined) {
				buff.push(" as ", elem.aliasName);
			}
			buff.push(" } ");
		} else {
			throw "unsupported sub-class of Import";
		}
		buff.push("from \"", elem.moduleSpecifier, "\";");
	}

	emitExportableElement(elem: ExportableElement) {
		if (elem instanceof Variable) {
			this.emitVariable(elem);
		} else if (elem instanceof Function) {
			this.emitFunction(elem);
		} else if (elem instanceof Type) {
			this.emitType(elem);
		} else {
			throw "unsupported sub-type of ExportableElement";
		}
	}

	emitVariable(variable: Variable) {
		const buff = this.buff;
		if (variable.exported) {
			buff.push("export ");
		}
		buff.push(variable.keyword);
		buff.push(" ");
		buff.push(variable.name);
		this.emitTypeRef(variable.type);
		buff.push(";");
	}

	emitFunction(fun: Function) {
		const buff = this.buff;
		if (fun.exported) {
			buff.push("export ");
		}
		buff.push("external ");
		buff.push("function ");
		buff.push(fun.name);
		this.emitSignature(fun.signatures[0]);
		buff.push(";");
	}

	emitType(type: Type) {
		const buff = this.buff;
		if (type.primitiveBased == 'string') {
			buff.pushln("@StringBased");
		} else if (type.primitiveBased == 'number') {
			buff.pushln("@NumberBased");
		}
		if (type.exported) {
			buff.push("export ");
		}
		buff.push("external ");
		buff.push(type.kind, " ");
		if (type.defSiteStructural) {
			buff.push("~");
		}
		buff.pushln(type.name, " {");
		buff.indent();
		if (type.kind == 'interface' || type.kind == 'class') {
			this.emitMembers(type.members);
		} else if (type.kind == 'enum') {
			this.emitEnumLiterals(type.literals, type.primitiveBased == 'string');
		} else {
			throw "unknown kind of type: " + type.kind;
		}
		buff.undent();
		buff.push("}");
	}

	emitEnumLiterals(literals: EnumLiteral[], isStringBased: boolean) {
		const buff = this.buff;
		const len = literals.length;
		for (let i = 0; i < len; i++) {
			const lit = literals[i];
			buff.push(lit.name);
			if (lit.value !== undefined) {
				buff.push(": ");
				if (typeof lit.value == 'string') {
					buff.push("'" + lit.value + "'"); // TODO escaping!
				} else {
					buff.push("" + lit.value);
				}
			}
			if (i + 1 < len) {
				buff.pushln(",");
			} else {
				buff.pushln();
			}
		}
	}

	emitMembers(members: Member[]) {
		const buff = this.buff;
		for (const m of members) {
			this.emitMember(m);
			buff.pushln();
		}
	}

	emitMember(member: Member) {
		const buff = this.buff;
		if (member.accessibility !== undefined) {
			this.emitAccessibility(member);
			buff.push(" ");
		}
		switch(member.kind) {
			case 'ctor':
				buff.push("constructor");
				this.emitSignature(member.signatures[0], true);
				buff.push(";");
				break;
			case 'field':
				buff.push(member.name);
				this.emitTypeRef(member.type);
				buff.push(";");
				break;
			case 'getter':
				buff.push("get ", member.name, "()");
				this.emitTypeRef(member.type);
				buff.push(";");
				break;
			case 'setter':
				buff.push("set ", member.name, "(", "value");
				this.emitTypeRef(member.type);
				buff.push(");");
				break;
			case 'method':
				buff.push(member.name);
				this.emitSignature(member.signatures[0]);
				buff.push(";");
				break;
			default:
				throw "unknown kind of member: " + member.kind;
		}
		if (member.signatures !== undefined && member.signatures.length > 1) {
			buff.push(" // further signatures were omitted");
		}
	}

	emitSignature(sig: Signature, ignoreReturnType: boolean = false) {
		const buff = this.buff;
		buff.push("(");
		let needSep = false;
		for (const param of sig.parameters) {
			if (needSep) {
				buff.push(", ");
			}
			this.emitParameter(param);
			needSep = true;
		}
		buff.push(")");
		if (!ignoreReturnType) {
			this.emitTypeRef(sig.returnType);
		}
	}

	emitParameter(param: Parameter) {
		const buff = this.buff;
		buff.push(param.name);
		this.emitTypeRef(param.type);
	}

	emitAccessibility(member: Member) {
		const buff = this.buff;
		if (member.accessibility === undefined) {
			// ignore
		} else if (member.accessibility == Accessibility.PUBLIC) {
			buff.push("public");
		} else if (member.accessibility == Accessibility.PROTECTED) {
			buff.push("protected");
		} else if (member.accessibility == Accessibility.PRIVATE) {
			buff.push("private");
		} else {
			throw "unkown member accessibility: " + Accessibility[member.accessibility];
		}
	}

	emitTypeRef(typeRef: TypeRef) {
		const buff = this.buff;
		if (globalOptions.copyTypeRefs) {
			if (typeRef) {
				buff.push(": ");
				buff.push(typeRef.tsSourceString);
			}
		} else {
			// note: in "any+ mode" we write out "any+" even in case
			// the type was undeclared on the TypeScript side, because
			// N4JS would infer the type to "any" instead of "any+":
			buff.push(": ", "any+");
		}
	}
}
