/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.bean
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 01/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.bean;

/**
 * Nome: PrazoStandbyVO.java
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
 * Registro  de Manuten��o: 01/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
public class PrazoStandbyVO {
	
	/** PRAZO STAND BY */
	private Integer tdiamaxcredt = 0;
	
	/** Variavel do tipo String. */
	String codmens = null;
	
	/** Variavel do tipo String. */
	String texmens = null;

	/**
	 * @return o valor do tdiamaxcredt
	 */
	public Integer getTdiamaxcredt() {
		return tdiamaxcredt;
	}

	/**
	 * @param tdiamaxcredt seta o novo valor para o campo tdiamaxcredt
	 */
	public void setTdiamaxcredt(Integer tdiamaxcredt) {
		this.tdiamaxcredt = tdiamaxcredt;
	}

	/**
	 * @return o valor do codmens
	 */
	public String getCodmens() {
		return codmens;
	}

	/**
	 * @param codmens seta o novo valor para o campo codmens
	 */
	public void setCodmens(String codmens) {
		this.codmens = codmens;
	}

	/**
	 * @return o valor do texmens
	 */
	public String getTexmens() {
		return texmens;
	}

	/**
	 * @param texmens seta o novo valor para o campo texmens
	 */
	public void setTexmens(String texmens) {
		this.texmens = texmens;
	}
}
