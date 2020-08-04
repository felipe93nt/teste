/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.bean
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 17/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


/**
 * Nome: ComboMoedaOperacaoVO.java
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
 * Registro  de Manuten��o: 17/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
public class ComboMoedaOperacaoVO {

	/**** Campos da Entrada  *****/
	private Integer cprodtservc = 0;

	/**** Campos da Sa�da  *****/

	private Integer cindcdeconmmoeda = 0;

	private String cindcdfontecons = null;

	private String isglindcdfonte = null;

	/**
	 * @return o valor do cprodtservc
	 */
	public Integer getCprodtservc() {
		return cprodtservc;
	}

	/**
	 * @param cprodtservc seta o novo valor para o campo cprodtservc
	 */
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	/**
	 * @return o valor do cindcdeconmmoeda
	 */
	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	/**
	 * @param cindcdeconmmoeda seta o novo valor para o campo cindcdeconmmoeda
	 */
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	/**
	 * @return o valor do cindcdfontecons
	 */
	public String getCindcdfontecons() {
		return cindcdfontecons;
	}

	/**
	 * @param cindcdfontecons seta o novo valor para o campo cindcdfontecons
	 */
	public void setCindcdfontecons(String cindcdfontecons) {
		this.cindcdfontecons = cindcdfontecons;
	}

	/**
	 * @return o valor do isglindcdfonte
	 */
	public String getIsglindcdfonte() {
		return isglindcdfonte;
	}

	/**
	 * @param isglindcdfonte seta o novo valor para o campo isglindcdfonte
	 */
	public void setIsglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}

}
