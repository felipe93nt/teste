/**
*
* Nome: ComboTipoOrgaoVo.java
* Propósito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 13/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


/**
 *
 * Nome: ComboTipoOrgaoVo.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 13/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class ComboTipoOrgaoVo {
	
	/** Variavel do tipo Integer. */
	private Integer ctpoorgnzfincr = null;
	
	/** Variavel do tipo String. */
	private String itpoorgnzfincr = null;
	
	/** Variavel do tipo Integer. */
	private Integer ntpositcmbio = null;

	/** Variavel do tipo String. */
	private String rjustfsitcmbio = null;
	
	/** 
	 * Método construtor da classe.
	 */
	public ComboTipoOrgaoVo() {
		super();

	}

	/**
	 * @return o valor do ctpoorgnzfincr
	 */
	public Integer getCtpoorgnzfincr() {
		return ctpoorgnzfincr;
	}

	/**
	 * @param ctpoorgnzfincr seta o novo valor para o campo ctpoorgnzfincr
	 */
	public void setCtpoorgnzfincr(Integer ctpoorgnzfincr) {
		this.ctpoorgnzfincr = ctpoorgnzfincr;
	}

	/**
	 * @return o valor do itpoorgnzfincr
	 */
	public String getItpoorgnzfincr() {
		return itpoorgnzfincr;
	}

	/**
	 * @param itpoorgnzfincr seta o novo valor para o campo itpoorgnzfincr
	 */
	public void setItpoorgnzfincr(String itpoorgnzfincr) {
		this.itpoorgnzfincr = itpoorgnzfincr;
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
