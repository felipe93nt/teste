package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;

/**
*
* Nome: ComboIdentClearing.java
* Propósito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 15/10/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
public class ComboIdentClearingVO {

	/** CODIGO DO TIPO DE CLEARING     PIC 9(002). */
	private Integer ccmaracompeexter = null;
	
	/** DESCRICAO DO TIPO DE CLEARING  PIC X(30). */
	private String icmaracompeexter = null;
	
	/** Variavel do tipo Integer. */
	private Integer ntpositcmbio = null;

	/** Variavel do tipo String. */
	private String rjustfsitcmbio = null;
	
	/** 
	 * Método construtor da classe.
	 */
	public ComboIdentClearingVO(){
		super();
	}

	/**
	 * @return o valor do icmaracompeexter
	 */
	public String getIcmaracompeexter() {
		return icmaracompeexter;
	}

	/**
	 * @param icmaracompeexter seta o novo valor para o campo icmaracompeexter
	 */
	public void setIcmaracompeexter(String icmaracompeexter) {
		this.icmaracompeexter = icmaracompeexter;
	}
	
	/**
	 * @return o valor do ccmaracompeexter
	 */
	public Integer getCcmaracompeexter(){
		return ccmaracompeexter;
	}

	/**
	 * @param ccmaracompeexter seta o novo valor para o campo ccmaracompeexter
	 */
	public void setCcmaracompeexter(Integer ccmaracompeexter) {
		this.ccmaracompeexter = ccmaracompeexter;
	}

	/**
	 * @return o valor do ntpositcmbio
	 */
	public Integer getNtpositcmbio() {
		return ntpositcmbio;
	}

	/**
	 * @param ntpositcmbio seta o novo valor para o campo ntpositcmbio
	 */
	public void setNtpositcmbio(Integer ntpositcmbio) {
		this.ntpositcmbio = ntpositcmbio;
	}

	/**
	 * @return o valor do rjustfsitcmbio
	 */
	public String getRjustfsitcmbio() {
		return rjustfsitcmbio;
	}

	/**
	 * @param rjustfsitcmbio seta o novo valor para o campo rjustfsitcmbio
	 */
	public void setRjustfsitcmbio(String rjustfsitcmbio) {
		this.rjustfsitcmbio = rjustfsitcmbio;
	}
	
}
