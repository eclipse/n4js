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
package org.eclipse.n4js.parser.conversion;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.n4js.validation.IssueCodes;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * A value converter that properly converts hexadecimal JS numbers to {@link BigDecimal}.
 */
public class HexIntValueConverter extends AbstractLexerBasedConverter<BigDecimal> {

	@Override
	protected String toEscapedString(BigDecimal value) {
		return "0x" + value.toBigInteger().toString(16);
	}

	@Override
	protected void assertValidValue(BigDecimal value) {
		super.assertValidValue(value);
		if (value.signum() == -1)
			throw new N4JSValueConverterException(IssueCodes.VCO_HEXINT_NEGATIVE.getMessage(getRuleName(), value),
					IssueCodes.VCO_HEXINT_NEGATIVE.name(), null, null);
	}

	@Override
	public BigDecimal toValue(String string, INode node) {
		if (Strings.isEmpty(string))
			throw new N4JSValueConverterException(IssueCodes.VCO_HEXINT_CONVERT_EMPTY_STR.getMessage(),
					IssueCodes.VCO_HEXINT_CONVERT_EMPTY_STR.name(), node, null);
		if (string.length() <= 2) {
			throw new N4JSValueConverterWithValueException(
					IssueCodes.VCO_HEXINT_CONVERT_TOO_SHORT.getMessage(string),
					IssueCodes.VCO_HEXINT_CONVERT_TOO_SHORT.name(), node,
					BigDecimal.ZERO, null);
		}
		try {
			return new BigDecimal(new BigInteger(string.substring(2), 16));
		} catch (NumberFormatException e) {
			throw new N4JSValueConverterException(IssueCodes.VCO_HEXINT_CONVERT_STR.getMessage(string),
					IssueCodes.VCO_HEXINT_CONVERT_STR.name(), node, null);
		}
	}
}
