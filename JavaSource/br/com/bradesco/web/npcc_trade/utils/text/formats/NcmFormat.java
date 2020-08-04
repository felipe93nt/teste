package br.com.bradesco.web.npcc_trade.utils.text.formats;

import java.util.HashMap;
import java.util.Map;

import br.com.bradesco.web.npcc_trade.utils.text.TextAttribute;

public final class NcmFormat implements ITextFormat {
	
	public boolean hasHeader() {
		return true;
	}
	
	public String getHeaderContent() {
		return "CO_SH4;NO_SH4_POR;NO_SH4_ING;NO_SH4_ESP;NO_SH4_FRA";
	}

	public Map<Integer, TextAttribute> getLayout() {
		Map<Integer, TextAttribute> layout = new HashMap<Integer, TextAttribute>();
		layout.put(0, new TextAttribute(10, true, "0"));
		layout.put(1, new TextAttribute(300, false, " "));
		layout.put(2, new TextAttribute(300, false, " "));
		
		return layout;
	}
}
