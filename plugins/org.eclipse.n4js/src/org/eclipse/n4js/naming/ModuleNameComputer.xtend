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
package org.eclipse.n4js.naming

import com.google.common.base.Preconditions
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.n4js.N4JSGlobals
import org.eclipse.n4js.utils.ResourceType
import org.eclipse.n4js.workspace.WorkspaceAccess
import org.eclipse.xtext.naming.QualifiedName

/**
 * Utility class to calculate the qualified name of the resource depending on the project configuration.
 * The project configuration is provided by a package.json file in the root folder of the project.
 * This file contains the definition which folders of the current project should be handled as src rsp.
 * src-test folders. So if a resource is placed under MyProject/src/my/pack/MyResource.n4js, the calculated
 * qualified name would be my.pack.MyResource.
 *
 * Client code should usually use {@code TModule.getName()} or {@code Script.getModule().getName()} to access the
 * module's name.
 */
@Singleton
class ModuleNameComputer {

	@Inject
	private WorkspaceAccess workspaceAccess

	/**
	 * Returns the qualified module name which is implicitly defined by the given resource.
	 * <p>
	 * Please note there is also a special treatment for Xpect test files that may have a file extension
	 * like {@code ".n4js.xt"}. The calculation will handle this as a hole file extension, so {@code ".n4js"} will be pruned, too.
	 */
	def public QualifiedName getQualifiedModuleName(Resource resource) {
		getQualifiedModuleName(resource, resource.getURI());
	}

	/**
	 * Returns the qualified module name which is explicitly defined by the given uri.
	 * <p>
	 * Please note there is also a special treatment for Xpect test files that may have a file extension
	 * like {@code ".n4js.xt"}. The calculation will handle this as a hole file extension, so {@code ".n4js"} will be pruned, too.
	 */
	def public getQualifiedModuleName(Notifier context, URI uri) {
		val sourceContainer = workspaceAccess.findSourceFolderContaining(context, uri);
		if (sourceContainer !== null) {
			val location = sourceContainer.pathAsFileURI.withTrailingPathDelimiter.toURI
			if(uri.uriStartsWith(location)) {
				var relativeURI = uri.deresolve(location)
				if (ResourceType.xtHidesOtherExtension(uri) || (N4JSGlobals.XT_FILE_EXTENSION == uri.fileExtension.toLowerCase)) {
					relativeURI = relativeURI.trimFileExtension.trimFileExtension
				} else {
					relativeURI = relativeURI.trimFileExtension
				}
				return QualifiedName.create(relativeURI.segments)
			}
		} else if (uri.segmentCount == 1 && uri.fileExtension !== null) {
			// Special case of synthesized test resources where we don't have a source container.
			// In this case we deal with top-level test resources.
			if (ResourceType.xtHidesOtherExtension(uri) ||
				(N4JSGlobals.XT_FILE_EXTENSION == uri.fileExtension.toLowerCase)) {
				// if applicable, remove double-file-extension
				return QualifiedName.create(uri.trimFileExtension.trimFileExtension.segments)
			}
		}
		return uri.createDefaultQualifiedName
	}

	/** Called only for URIs without container, e.g. from tests, or built-ins. Hardcoded values should be fine for those cases.*/
	def private createDefaultQualifiedName(URI uri) {
		var segmentList = uri.trimFileExtension.segmentsList
		val srcFolder = Math.max(segmentList.indexOf('src'), segmentList.indexOf('src-test'))
		if (srcFolder != -1) {
			segmentList = segmentList.subList(srcFolder + 1, segmentList.size)
		}
		return QualifiedName.create(segmentList)
	}

	def private boolean uriStartsWith(URI resourceLocation, URI containerLocation) {
		Preconditions.checkArgument(containerLocation.hasTrailingPathSeparator, 'Must have trailing separator: %s', containerLocation);
		val maxSegments = containerLocation.segmentCount() - 1
		if (resourceLocation.segmentCount < maxSegments) {
			return false;
		}
		for(var i = 0; i < maxSegments; i++) {
			if (resourceLocation.segment(i) != containerLocation.segment(i)) {
				return false;
			}
		}
		return true;
	}
}
