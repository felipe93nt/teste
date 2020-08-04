/**
 * Nome: br.com.bradesco.web.npcd.utils.FormatadorNumerico
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * Data da Cria��o: 07/08/2015
 *
 * @see : Referencias externas.
 *
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
  * Nome: FormatadorNumerico.java
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
  * Registro  de Manuten��o: 07/01/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
*/
public class FormatadorNumerico {

	/** Variavel do tipo DecimalFormat. */
	protected DecimalFormat formatoMilhar;
	/** Variavel do tipo DecimalFormat. */
	protected DecimalFormat formatoPercentual;
	/** Variavel do tipo DecimalFormat. */
	protected DecimalFormat formatoPercentualCincoCasas;

	    /**
	     * Construtor
	     * 
	     * @param 
	     */
	public FormatadorNumerico() {
		this.formatoMilhar = this.getFormatoMilhar();
		this.formatoPercentual = this.getFormatoPercentual();
	}

	/**
     * @return o valor do 
     */
	public String formatoMilhar(final Number fromServidor) {
		return this.formatoMilhar.format(fromServidor);
	}
	
	/**
     * @return o valor do formatoMilhar
     */
	public String formatoMilhar(final String fromServidor) {
		BigDecimal valor;
		valor = this.getValor(fromServidor);
		return this.formatoMilhar.format(valor);
	}

	/**
     * @return o valor do formatoPercentual
     */
	public String formatoPercentual(final Number fromServidor) {
		return this.formatoPercentual.format(fromServidor);
	}

	/**
     * @return o valor do formatoPercentualCincoCasas
     */
	public String formatoPercentual(final String fromServidor) {
		BigDecimal valor;
		valor = this.getValor(fromServidor);
		return this.formatoPercentual.format(valor);
	}
	
	/**
     * @return o valor do 
     */
	public String formatoPercentualCincoCasas(final Number fromServidor) {
		return this.formatoPercentualCincoCasas.format(fromServidor);
	}

	/**
     * @return o valor do formatoPercentualCincoCasas
     */
	public String formatoPercentualCincoCasas(final String fromServidor) {
		BigDecimal valor;
		valor = this.getValor(fromServidor);
		return this.formatoPercentualCincoCasas.format(valor);
	}

	/**
	 * Gancho para configuracao do FormataoMIlhar
	 * 
	 * @return
	 */
	protected DecimalFormat getFormatoMilhar() {
		return (new DecimalFormat(",##0.000"));
	}

	/**
	 * Gancho para configuracao do FormatoPercentual
	 * 
	 * @return
	 */
	protected DecimalFormat getFormatoPercentual() {
		return (new DecimalFormat("##0.000"));

	}
	
	/**
     * @return o valor do valor
     */
	protected BigDecimal getValor(final String fromServidor) {
		BigDecimal retorno;
		String valor = SiteUtil.formatarPontosVirgula(fromServidor);
		retorno = new BigDecimal(valor);
		return (retorno);
	}
	
	/**
	 * Gancho para configuracao do FormatoPercentual
	 * 
	 * @return
	 */
	protected DecimalFormat getFormatoPercentualCincoCasas() {
		return (new DecimalFormat(SiteUtil.DECIMAL_PATTERN_CINCO_CASAS));

	}
}
