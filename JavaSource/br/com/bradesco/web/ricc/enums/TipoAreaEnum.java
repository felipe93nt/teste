/**
 * @name br.com.bradesco.web.ricc.enums
 */
package br.com.bradesco.web.ricc.enums;

/**
 * @name TipoAreaEnum
 * @author Foursys
 * @see TipoAreaEnum.java
 * @version 1.0
 * @since 12/09/2018
 */
public enum TipoAreaEnum {
	/**
	 * Atributo AREA_PROPRIA Tipo TipoAreaEnum
	 */
	AREA_PROPRIA("1"),
	/**
	 * Atributo AREA_ARRENDADA Tipo TipoAreaEnum
	 */
	AREA_ARRENDADA("2");

	/**
	 * Atributo codTipoArea Tipo String
	 */
	private String codTipoArea = "";

	/**
	 * @param codTipoArea
	 */
	private TipoAreaEnum(String codTipoArea) {
		this.codTipoArea = codTipoArea;
	}

	/**
	 * @return the codTipoArea
	 */
	public String getCodTipoArea() {
		return codTipoArea;
	}

	/**
	 * @param codTipoArea
	 *            the codTipoArea to set
	 */
	public void setCodTipoArea(String codTipoArea) {
		this.codTipoArea = codTipoArea;
	}
}
