/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 08/06/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.6
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


/**
  * Nome: ComboModalidadeVO.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 08/06/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class ComboModalidadeVO {
	
	/** 15 NPCCWICS-IMODLD-PRODT-CMBIO PIC X(030). */
	private Integer cmodldprodtcmbio = 0;

	/** 15 NPCCWICS-CMODLD-PRODT-CMBIO PIC 9(003). */
	private String imodldprodtcmbio = null;

	public Integer getCmodldprodtcmbio() {
		return cmodldprodtcmbio;
	}

	public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
		this.cmodldprodtcmbio = cmodldprodtcmbio;
	}

	public String getImodldprodtcmbio() {
		return imodldprodtcmbio;
	}

	public void setImodldprodtcmbio(String imodldprodtcmbio) {
		this.imodldprodtcmbio = imodldprodtcmbio;
	}
}
