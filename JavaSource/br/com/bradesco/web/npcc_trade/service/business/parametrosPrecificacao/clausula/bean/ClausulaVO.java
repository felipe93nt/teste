/**
*
* Nome: ClausulaVO.java
* Propósito: <p>Modelo para a tela de Clausulas </p>
*
* @author :  BRQ <BR>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 27/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.bean;

import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;

/**
*
* Nome: ClausulaVO.java
* Propósito: <p>Modelo para a tela de Clausulas </p>
*
* @author :  BRQ <BR>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 27/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/

public class ClausulaVO extends BaseVO {
	
	/** CODIGO TIPO CLAUSULA DO MODELO DE CONTRATO DE CAMBIO */
	private Integer ctpoclauscmbio = 0;
	/** CODIGO IDENTIF. DA CLAUSULA */
	private Integer cclauscontrcmbio = 0;
	/** DESCRICAO DE CLAUSULA */
	private String rclauscontrcmbio = null;
	/** QUANTIDADE DE OCORRENCIAS */
	private Integer qtdeocorr = 0;
	/** DESCRIÇÃO DO TIPO DA CLAUSULA */
	private String itpoclauscmbio = null;
	
	/** 
     * Método construtor da classe.
     */
	public ClausulaVO(){
		super();
	}

	/**
	 * @return o valor do ctpoclauscmbio
	 */
	public Integer getCtpoclauscmbio() {
		return ctpoclauscmbio;
	}

	/**
	 * @param ctpoclauscmbio seta o novo valor para o campo ctpoclauscmbio
	 */
	public void setCtpoclauscmbio(Integer ctpoclauscmbio) {
		this.ctpoclauscmbio = ctpoclauscmbio;
	}

	/**
	 * @return o valor do cclauscontrcmbio 
	 */
	public Integer getCclauscontrcmbio() {
		return cclauscontrcmbio;
	}

	/**
	 * @param cclauscontrcmbio seta o novo valor para o campo cclauscontrcmbio
	 */
	public void setCclauscontrcmbio(Integer cclauscontrcmbio) {
		this.cclauscontrcmbio = cclauscontrcmbio;
	}

	/**
	 * @return o valor do rclauscontrcmbio
	 */
	public String getRclauscontrcmbio() {
		return rclauscontrcmbio;
	}

	/**
	 * @param rclauscontrcmbio seta o novo valor para o campo rclauscontrcmbio
	 */
	public void setRclauscontrcmbio(String rclauscontrcmbio) {
		this.rclauscontrcmbio = rclauscontrcmbio;
	}

	/**
	 * @return o valor do qtdeocorr
	 */
	public Integer getQtdeocorr() {
		return qtdeocorr;
	}

	/**
	 * @param qtdeocorr seta o novo valor para o campo qtdeocorr
	 */
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}
	
	/**
	 * @return o valor do itpoclauscmbio
	 */
	public String getItpoclauscmbio() {
		return itpoclauscmbio;
	}

	/**
	 * @param itpoclauscmbio seta o novo valor para o campo itpoclauscmbio
	 */
	public void setItpoclauscmbio(String itpoclauscmbio) {
		this.itpoclauscmbio = itpoclauscmbio;
	}
}
