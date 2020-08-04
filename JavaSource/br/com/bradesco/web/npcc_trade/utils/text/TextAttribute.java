package br.com.bradesco.web.npcc_trade.utils.text;

public final class TextAttribute {
	private int size;
	
	private boolean isNumericField;
	
	private String defaultValue;

	public TextAttribute() {
		
	}
	
	public TextAttribute(int size, boolean isNumericField, String defaultValue) {
		this.size = size;
		this.isNumericField = isNumericField;
		this.defaultValue = defaultValue;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isNumericField() {
		return isNumericField;
	}

	public void setNumericField(boolean isNumericField) {
		this.isNumericField = isNumericField;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
