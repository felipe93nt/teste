/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 13/01/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;



/**
 * Nome: TrdFinNegTarifaVO.java
 * 
 * Propósito: Área com Dados Temporários de trabalho
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 13/01/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TrdFinNegTarifaVO {

	private Integer cindcddesptarf = 0;

	private String descrdesptarif = null;

	private Integer ccondceconc = 0;

	private Integer ntarifbletocmbio;

	private Integer ctpodespcmbio = 0;

	private String itpodespcmbio = null;

	private Integer cindcdeconmmoeda = 0;

	private String isglindcdfonte = null;

	private String vdespbletocmbio = null;

	/**
	 * @return o valor do cindcddesptarf
	 */
	public Integer getCindcddesptarf() {
		return cindcddesptarf;
	}

	/**
	 * @param cindcddesptarf seta o novo valor para o campo cindcddesptarf
	 */
	public void setCindcddesptarf(Integer cindcddesptarf) {
		this.cindcddesptarf = cindcddesptarf;
	}

	/**
	 * @return o valor do descrdesptarif
	 */
	public String getDescrdesptarif() {
		return descrdesptarif;
	}

	/**
	 * @param descrdesptarif seta o novo valor para o campo descrdesptarif
	 */
	public void setDescrdesptarif(String descrdesptarif) {
		this.descrdesptarif = descrdesptarif;
	}

	/**
	 * @return o valor do ccondceconc
	 */
	public Integer getCcondceconc() {
		return ccondceconc;
	}

	/**
	 * @param ccondceconc seta o novo valor para o campo ccondceconc
	 */
	public void setCcondceconc(Integer ccondceconc) {
		this.ccondceconc = ccondceconc;
	}

	/**
	 * @return o valor do ctpodespcmbio
	 */
	public Integer getCtpodespcmbio() {
		return ctpodespcmbio;
	}

	/**
	 * @param ctpodespcmbio seta o novo valor para o campo ctpodespcmbio
	 */
	public void setCtpodespcmbio(Integer ctpodespcmbio) {
		this.ctpodespcmbio = ctpodespcmbio;
	}

	/**
	 * @return o valor do itpodespcmbio
	 */
	public String getItpodespcmbio() {
		return itpodespcmbio;
	}

	/**
	 * @param itpodespcmbio seta o novo valor para o campo itpodespcmbio
	 */
	public void setItpodespcmbio(String itpodespcmbio) {
		this.itpodespcmbio = itpodespcmbio;
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

	/**
	 * @return o valor do vdespbletocmbio
	 */
	public String getVdespbletocmbio() {
		return vdespbletocmbio;
	}

	/**
	 * @param vdespbletocmbio seta o novo valor para o campo vdespbletocmbio
	 */
	public void setVdespbletocmbio(String vdespbletocmbio) {
		this.vdespbletocmbio = vdespbletocmbio;
	}

    /**
     * @return o valor do ntarifbletocmbio
     */
    public Integer getNtarifbletocmbio() {
        return ntarifbletocmbio;
    }

    /**
     * @param ntarifbletocmbio seta o novo valor para o campo ntarifbletocmbio
     */
    public void setNtarifbletocmbio(Integer ntarifbletocmbio) {
        this.ntarifbletocmbio = ntarifbletocmbio;
    }

}
