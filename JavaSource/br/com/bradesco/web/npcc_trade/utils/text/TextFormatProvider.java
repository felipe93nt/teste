package br.com.bradesco.web.npcc_trade.utils.text;

import br.com.bradesco.web.npcc_trade.utils.text.formats.ITextFormat;
import br.com.bradesco.web.npcc_trade.utils.text.formats.NcmFormat;

public final class TextFormatProvider {
	public static ITextFormat getNcmFormat() {		
		return new NcmFormat();
	}
}
