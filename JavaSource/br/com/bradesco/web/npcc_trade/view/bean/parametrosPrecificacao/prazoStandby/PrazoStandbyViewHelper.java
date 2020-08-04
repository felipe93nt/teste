/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.prazoStandby
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
package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.prazoStandby;

/**
 * Nome: PrazoStandbyViewHelper.java
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
public class PrazoStandbyViewHelper {
	
	/** Variavel do tipo boolean. */
	private boolean disabledBtnIncluir = Boolean.TRUE;
	
	/** Variavel do tipo boolean. */
	private boolean disabledBtnAlterar = Boolean.TRUE;
	
	/** PRAZO STAND BY TELA*/
	private Integer tdiamaxcredt = 0;

	/**
	 * @return o valor do disabledBtnIncluir
	 */
	public boolean isDisabledBtnIncluir() {
		return disabledBtnIncluir;
	}

	/**
	 * @param disabledBtnIncluir seta o novo valor para o campo disabledBtnIncluir
	 */
	public void setDisabledBtnIncluir(boolean disabledBtnIncluir) {
		this.disabledBtnIncluir = disabledBtnIncluir;
	}

	/**
	 * @return o valor do disabledBtnAlterar
	 */
	public boolean isDisabledBtnAlterar() {
		return disabledBtnAlterar;
	}

	/**
	 * @param disabledBtnAlterar seta o novo valor para o campo disabledBtnAlterar
	 */
	public void setDisabledBtnAlterar(boolean disabledBtnAlterar) {
		this.disabledBtnAlterar = disabledBtnAlterar;
	}

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

}
