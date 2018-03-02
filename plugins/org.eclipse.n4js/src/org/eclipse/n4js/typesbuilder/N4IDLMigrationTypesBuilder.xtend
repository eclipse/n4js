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
package org.eclipse.n4js.typesbuilder

import java.util.List
import org.eclipse.n4js.AnnotationDefinition
import org.eclipse.n4js.n4JS.FunctionDeclaration
import org.eclipse.n4js.n4idl.versioning.VersionUtils
import org.eclipse.n4js.ts.typeRefs.TypeRef
import org.eclipse.n4js.ts.types.TFunction
import org.eclipse.n4js.ts.types.TMigration
import org.eclipse.n4js.ts.types.TypesFactory
import org.eclipse.n4js.utils.Log

/**
 * A types builder to create and initialise {@link TMigration}s from {@link FunctionDeclaration} instances. 
 */
@Log
class N4IDLMigrationTypesBuilder {
	
	/**
	 * Initialises a {@link TMigration} instance based on a {@link FunctionDeclaration}.
	 * 
	 * This method assumes that all {@link TFunction} related attributes of tMigration were already
	 * initialised appropriately.
	 * 
	 * This method also assumes that functionDecl is a migration (and therefore annotated as {@code @Migration}. 
	 */
	public def void initialiseTMigration(FunctionDeclaration functionDecl, TMigration tMigration) {
		val migrationAnno = AnnotationDefinition.MIGRATION.getAnnotation(tMigration);
		
		// if the migration explicitly declares a source and target version
		if (migrationAnno.args.length == 2) {
			
			try {
				val Integer sourceVersion = Integer.parseInt(migrationAnno.args.get(0).argAsString);
				val Integer targetVersion = Integer.parseInt(migrationAnno.args.get(1).argAsString);
				
				tMigration.sourceVersion = sourceVersion;
				tMigration.targetVersion = targetVersion;
				
				tMigration.hasDeclaredSourceAndTargetVersion = true;
			} catch (NumberFormatException e) {
				logger.error("Failed to infer source/target version for migration " + tMigration.name + " in file " + tMigration.eResource.URI, e);
	
				// fail-safe to source and target versions 0
				tMigration.sourceVersion = 0;
				tMigration.sourceVersion = 0;
			}
		} else {
			// set source and target version by inferring them from source and target type refs
			tMigration.sourceVersion = computeVersion(tMigration.sourceTypeRefs)
			tMigration.targetVersion = computeVersion(tMigration.targetTypeRefs)
			
			tMigration.hasDeclaredSourceAndTargetVersion = false;
		}
	}
	
	
	/**
	 * Returns a new instance of {@link TMigration}.
	 */
	public def TMigration createTMigration() {
		return TypesFactory::eINSTANCE.createTMigration();
	}
	
	/**
	 * Computes the version of the given {@link TypeRef}s.
	 *
	 * Returns {@code 0} if none of the {@link TypeRef}s declare a version.
	 *
	 * If the given {@link TypeRef}s declared multiple different versions, this method may 
	 * yield an inaccurate result. At this point however, there is no other sensible value
	 * to populate the type model with. 
	 */
	private static def int computeVersion(List<TypeRef> typeRefs) {
		VersionUtils.getVersion(typeRefs);
	}
	
}