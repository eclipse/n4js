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
package org.eclipse.n4js.tests.typesbuilder.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.xtext.util.Strings;

/**
 */
public class OrderedEmfFormatter {

	private static final char SPACE = ' ';
	private static final String INDENT = "    ";

	
	public static String objToStr(Object obj) {
		Appendable buf = new StringBuilder(1024);
		try {
			objToStrImpl(obj, "", buf);
		} catch (Exception e) {
			throw new WrappedException(e);
		}
		return buf.toString().replace("\n", Strings.newLine());
	}

	private static List<EStructuralFeature> getAllFeatures(EClass clazz) {
		List<EStructuralFeature> features = new ArrayList<>(clazz.getEAllStructuralFeatures());
		Collections.sort(features, new Comparator<EStructuralFeature>() {
			@Override
			public int compare(EStructuralFeature o1, EStructuralFeature o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return features;
	}

	private static void objToStrImpl(Object obj, String indent, Appendable buf) throws Exception {
		String innerIdent = INDENT + indent;
		if (obj instanceof EObject) {
			EObject eobj = (EObject) obj;
			buf.append(eobj.eClass().getName()).append(" {\n");
			for (EStructuralFeature f : getAllFeatures(eobj.eClass())) {
				if (!eobj.eIsSet(f))
					continue;
				buf.append(innerIdent);
				if (f instanceof EReference) {
					EReference r = (EReference) f;
					if (r.isContainment()) {
						buf.append("cref ");
						buf.append(f.getEType().getName()).append(SPACE);
						buf.append(f.getName()).append(SPACE);
						objToStrImpl(eobj.eGet(f), innerIdent, buf);
					} else {
						buf.append("ref ");
						buf.append(f.getEType().getName()).append(SPACE);
						buf.append(f.getName()).append(SPACE);
						refToStr(eobj, r, innerIdent, buf);
					}
				} else if (f instanceof EAttribute) {
					buf.append("attr ");
					buf.append(f.getEType().getName()).append(SPACE);
					buf.append(f.getName()).append(SPACE);
					// logger.debug(Msg.create("Path:").path(eobj));
					Object at = eobj.eGet(f);
					if (eobj != at)
						objToStrImpl(at, innerIdent, buf);
					else
						buf.append("<same as container object>");
				} else {
					buf.append("attr ");
					buf.append(f.getEType().getName()).append(SPACE);
					buf.append(f.getName()).append(" ??????");
				}
				buf.append('\n');
			}
			buf.append(indent).append("}");
			return;
		}
		if (obj instanceof FeatureMap.Entry) {
			FeatureMap.Entry e = (FeatureMap.Entry) obj;
			buf.append(e.getEStructuralFeature().getEContainingClass().getName());
			buf.append(".");
			buf.append(e.getEStructuralFeature().getName());
			buf.append("->");
			objToStrImpl(e.getValue(), innerIdent, buf);
			return;
		}
		if (obj instanceof Collection<?>) {
			int counter = 0;
			Collection<?> coll = (Collection<?>) obj;
			buf.append("[\n");
			for (Object o : coll) {
				buf.append(innerIdent);
				printInt(counter++, coll.size(), buf);
				buf.append(": ");
				objToStrImpl(o, innerIdent, buf);
				buf.append("\n");
			}
			buf.append(indent + "]");
			return;
		}
		if (obj != null) {
			buf.append("'").append(Strings.notNull(obj)).append("'");
			return;
		}
		buf.append("null");
	}

	private static void refToStr(EObject obj, EReference ref, String indent, Appendable buf) throws Exception {
		Object o = obj.eGet(ref);
		if (o instanceof EObject) {
			EObject eo = (EObject) o;

			if (eo instanceof ENamedElement)
				buf.append("'").append(((ENamedElement) eo).getName()).append("' ");
			buf.append("ref: ");
			getURI(obj, eo, buf);
			return;
		}
		if (o instanceof Collection<?>) {
			String innerIndent = indent + INDENT;
			buf.append("[");
			int counter = 0;
			Collection<?> coll = (Collection<?>) o;
			for (Iterator<?> i = coll.iterator(); i.hasNext();) {
				Object item = i.next();
				if (counter == 0)
					buf.append('\n');
				buf.append(innerIndent);
				printInt(counter++, coll.size(), buf);
				buf.append(": ");
				getURI(obj, (EObject) item, buf);
				if (i.hasNext())
					buf.append(",\n");
				else
					buf.append('\n').append(indent);
			}
			buf.append("]");
			return;
		}
		buf.append("?????");
	}

	private static void printInt(int current, int max, Appendable buffer) throws IOException {
		int length = getNumberOfDigits(current);
		int maxLength = getNumberOfDigits(max);
		buffer.append(Integer.toString(current));
		for (int i = maxLength; i > length; i--) {
			buffer.append(SPACE);
		}
	}

	private static int getNumberOfDigits(int number) {
		return number <= 1 ? 1 : (int) Math.floor(Math.log10(number + 0.5)) + 1;
	}

	private static void getURI(EObject parent, EObject target, Appendable buf) throws Exception {
		Resource r = target.eResource();
		buf.append(target.eClass().getName());
		buf.append("@");
		if (r == null) {
			if (((InternalEObject) target).eIsProxy()) {
				buf.append("(unresolved proxy " + ((InternalEObject) target).eProxyURI() + ")");
			} else {
				buf.append("(resource null)");
			}
		} else if (parent.eResource() == r)
			buf.append(r.getURIFragment(target));
		else
			buf.append(r.getURI().toString()).append("#").append(r.getURIFragment(target));
	}

	
	public static String listToStr(List<? extends EObject> elements) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < elements.size(); i++) {
			EObject obj = elements.get(i);
			buff.append(objToStr(obj));
			if (i < elements.size() - 1)
				buff.append(",\n");
		}
		return buff.toString();
	}

	
	public static String objPath(EObject obj) {
		if (obj == null)
			return "null";
		StringBuffer b = new StringBuffer();
		objPath(b, obj);
		return b.toString();
	}

	private static void objPath(StringBuffer b, EObject obj) {
		if (obj.eContainer() != null) {
			objPath(b, obj.eContainer());
			b.append(".");
			b.append(obj.eContainingFeature().getName());
			if (obj.eContainingFeature().isMany()) {
				b.append("[");
				b.append(((List<?>) obj.eContainer().eGet(obj.eContainingFeature())).indexOf(obj));
				b.append("]");
			}
			b.append("->");
		}
		b.append(obj.eClass().getName());
		EStructuralFeature nameF = obj.eClass().getEStructuralFeature("name");
		Object name = nameF != null ? obj.eGet(nameF) : null;
		if (name != null) {
			b.append("'");
			b.append(name);
			b.append("'");
		}
	}
}
