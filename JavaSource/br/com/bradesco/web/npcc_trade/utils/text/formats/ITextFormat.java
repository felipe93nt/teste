package br.com.bradesco.web.npcc_trade.utils.text.formats;

import java.util.Map;

import br.com.bradesco.web.npcc_trade.utils.text.TextAttribute;

public interface ITextFormat {
	boolean hasHeader();
	
	String getHeaderContent();
	
	Map<Integer, TextAttribute> getLayout();
}
