/**
 * Copyright (c) 2018 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package org.eclipse.n4js.validation.validators

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.n4js.AnnotationDefinition
import org.eclipse.n4js.n4JS.FunctionDeclaration
import org.eclipse.n4js.n4JS.N4JSPackage
import org.eclipse.n4js.n4idl.versioning.VersionUtils
import org.eclipse.n4js.ts.typeRefs.TypeRef
import org.eclipse.n4js.ts.typeRefs.VersionedParameterizedTypeRef
import org.eclipse.n4js.ts.types.TMigration
import org.eclipse.n4js.validation.AbstractN4JSDeclarativeValidator
import org.eclipse.n4js.validation.IssueCodes
import org.eclipse.n4js.validation.JavaScriptVariantHelper
import org.eclipse.xtext.validation.Check

/**
 * Validates N4IDL migration declarations.
 */
class N4IDLMigrationValidator extends AbstractN4JSDeclarativeValidator {
	
	@Inject
	private JavaScriptVariantHelper variantHelper;

	/** Validates migration declarations (function declarations annotated as {@code @Migration}. */
	@Check
	public def void checkMigration(FunctionDeclaration functionDeclaration) {
		// this validation only applies for variants which support versioned types
		if (!variantHelper.allowVersionedTypes(functionDeclaration)) {
			return;
		}
		
		// do not validate a broken AST
		if (functionDeclaration === null || functionDeclaration.name === null) {
			return;
		}
		
		// this validation only applies for migrations
		if (!VersionUtils.isMigrationDeclaration(functionDeclaration)) {
			return;
		}
		
		// make sure the type model fulfills expectations
		if (!(functionDeclaration.definedFunction instanceof TMigration)) {
			throw new IllegalStateException("FunctionDeclaration " + functionDeclaration.name + " does not refer to a valid TMigration type model instance");
		}
		
		val migration = functionDeclaration.definedFunction as TMigration;
		
		if (holdsExplicitlyDeclaresReturnType(functionDeclaration, migration) 
			&& holdsMigrationHasSourceAndTargetTypes(migration)) {
			
			// only validate source and target version for non-generic migrations 
			if (migration.typeVars.empty) {
				holdsMigrationHasValidSourceAndTargetVersion(migration)
				&& holdsMigrationHasVersionExclusiveSourceAndTargetVersion(migration)
				&& holdsMigrationHasDifferentSourceAndTargetVersions(functionDeclaration, migration);
			}
				
			return;
		}
	}
	
	/** Checks that the #targetTypeRefs of TMigration aren't inferred but explicitly declared. */
	private def boolean holdsExplicitlyDeclaresReturnType(FunctionDeclaration migrationDeclaration, TMigration tMigration) {
		if (null === migrationDeclaration.returnTypeRef && !tMigration.targetTypeRefs.empty) {
			addIssue(IssueCodes.messageForIDL_MIGRATION_MUST_EXPLICITLY_DECLARE_RETURN_TYPE, migrationDeclaration,
				N4JSPackage.Literals.FUNCTION_DECLARATION__NAME, IssueCodes.IDL_MIGRATION_MUST_EXPLICITLY_DECLARE_RETURN_TYPE);
				return false;
		}
		return true;
	}
	
	/** Checks that the given migration has at least one source type and one target type. */
	private def boolean holdsMigrationHasSourceAndTargetTypes(TMigration migration) {
		if (migration.sourceTypeRefs.empty || migration.targetTypeRefs.empty) {
			addIssue(IssueCodes.messageForIDL_MIGRATION_MUST_DECLARE_IN_AND_OUTPUT, migration.astElement,
				N4JSPackage.Literals.FUNCTION_DECLARATION__NAME, IssueCodes.IDL_MIGRATION_MUST_DECLARE_IN_AND_OUTPUT);
			return false;
		}
		return true;
	}
	
	/** Checks that the given migration source and target types allow to infer a source and target version. */
	private def boolean holdsMigrationHasValidSourceAndTargetVersion(TMigration migration) {
		if (migration.sourceVersion == 0) {
			val message = IssueCodes.getMessageForIDL_MIGRATION_VERSION_CANNOT_BE_INFERRED("source version", migration.name);
			addIssue(message, migration.astElement, N4JSPackage.Literals.FUNCTION_DEFINITION__FPARS, -1,
				IssueCodes.IDL_MIGRATION_VERSION_CANNOT_BE_INFERRED);
			return false;
		}
		
		if (migration.targetVersion == 0) {
			val message = IssueCodes.getMessageForIDL_MIGRATION_VERSION_CANNOT_BE_INFERRED("target version", migration.name);
			addIssue(message, migration.astElement, N4JSPackage.Literals.FUNCTION_DEFINITION__RETURN_TYPE_REF,
				IssueCodes.IDL_MIGRATION_VERSION_CANNOT_BE_INFERRED);
			return false;
		}
		
		return true;
	}
	
	/** 
	 * Checks that the source and target types all are exclusively of one version (one source version, one target version).
	 * 
	 * Does nothing for migrations with {@TMigration#hasDeclaredSourceAndTargetVersion}.
	 */
	private def boolean holdsMigrationHasVersionExclusiveSourceAndTargetVersion(TMigration migration) {
		// do not validate explicitly declared source and target version
		if (migration.hasDeclaredSourceAndTargetVersion) {
			return true;
		}
		
		if (!isVersionExclusive(migration.sourceTypeRefs)) {
			val message = IssueCodes.getMessageForIDL_MIGRATION_AMBIGUOUS_VERSION("source version", migration.name);
			addIssue(message, migration.astElement, N4JSPackage.Literals.FUNCTION_DEFINITION__FPARS, -1,
				IssueCodes.IDL_MIGRATION_VERSION_CANNOT_BE_INFERRED);
			return false;
		}
		
		if (!isVersionExclusive(migration.targetTypeRefs)) {
			val message = IssueCodes.getMessageForIDL_MIGRATION_AMBIGUOUS_VERSION("target version", migration.name);
			addIssue(message, migration.astElement, N4JSPackage.Literals.FUNCTION_DEFINITION__RETURN_TYPE_REF,
				IssueCodes.IDL_MIGRATION_VERSION_CANNOT_BE_INFERRED);
			return false;
		}
		
		return true;
	}
	
	private def boolean holdsMigrationHasDifferentSourceAndTargetVersions(FunctionDeclaration declaration, TMigration migration) {
		if (migration.sourceVersion == migration.targetVersion) {
			val msg = IssueCodes.getMessageForIDL_MIGRATION_SAME_SOURCE_AND_TARGET_VERSION(migration.name, migration.sourceVersion);
			
			// Depending on where the source and target version are declared,
			// add an issue to the @Migration annotation or to the migration name
			if (migration.hasDeclaredSourceAndTargetVersion) {
				val migrationAnno = AnnotationDefinition.MIGRATION.getAnnotation(declaration);
				addIssue(msg, migrationAnno, 
					N4JSPackage.Literals.ANNOTATION__ARGS, -1,
					IssueCodes.IDL_MIGRATION_SAME_SOURCE_AND_TARGET_VERSION);
				return false;
			} else {
				addIssue(msg, declaration, 
					N4JSPackage.Literals.FUNCTION_DECLARATION__NAME,
					IssueCodes.IDL_MIGRATION_SAME_SOURCE_AND_TARGET_VERSION);
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns {@code true} if the given list of {@link TypeRef}s do not mix mulitple
	 * model versions (Multiple {@link VersionedParameterizedTypeRef} with different versions).
	 */
	private def boolean isVersionExclusive(Collection<TypeRef> typeRefs) {
		val versions = typeRefs.stream
			.flatMap[ref | VersionUtils.streamVersionedSubReferences(ref)]
			.mapToInt([versionedRef | versionedRef.version.intValue])
			.distinct.limit(2).toArray;
		
		return versions.size == 1;
	}	
}