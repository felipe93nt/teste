/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.bean
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 08/06/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.6
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


/**
  * Nome: ComboModalidadeVO.java
  * 
  * Prop�sito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 08/06/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
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
