/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 22/12/2015
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

import br.com.bradesco.web.aq.view.components.UICalendarPeriod.CalendarPeriodDataType;

/**
 * Nome: ComboMercadoriasVO.java
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
 * Registro  de Manutenção: 22/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TrdFinNegOperVincVO {

	/**** Campos da Entrada  *****/
	
	private Long cunicclicmbio = 0L;

    private CalendarPeriodDataType dataPesquisa = null;
	private String datainio = null;
	private String datafim = null;

	private Integer danobase = 0;

	private Integer numoperacao = 0;
	
	/**** Campos da Saída  *****/

	private Long nbletonegoccmbio = 0L;
	private String cindcdvncloimpor = null;
	
    private Long nbletocmbioano = 0L;

	private String dfimnegoccmbio = null;

	private String dataVencimento = null;

	private Integer cindcdeconmmoeda = 0;

	private String iindcdeconmmoeda = null;

	private String vnegocmoedaestrg = null;

	private String valorMoeda = null;

	private Integer cprodtservc = 0;

	private String iprodtservc = null;

	/**
	 * @return o valor do cunicclicmbio
	 */
	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}

	/**
	 * @param cunicclicmbio seta o novo valor para o campo cunicclicmbio
	 */
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	/**
	 * @return o valor do dataPesquisa
	 */
	public CalendarPeriodDataType getDataPesquisa() {
		return dataPesquisa;
	}

	/**
	 * @param dataPesquisa seta o novo valor para o campo dataPesquisa
	 */
	public void setDataPesquisa(CalendarPeriodDataType dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	/**
	 * @return o valor do datainio
	 */
	public String getDatainio() {
		return datainio;
	}

	/**
	 * @param datainio seta o novo valor para o campo datainio
	 */
	public void setDatainio(String datainio) {
		this.datainio = datainio;
	}

	/**
	 * @return o valor do datafim
	 */
	public String getDatafim() {
		return datafim;
	}

	/**
	 * @param datafim seta o novo valor para o campo datafim
	 */
	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}

	/**
	 * @return o valor do numoperacao
	 */
	public Integer getNumoperacao() {
		return numoperacao;
	}

	/**
	 * @param numoperacao seta o novo valor para o campo numoperacao
	 */
	public void setNumoperacao(Integer numoperacao) {
		this.numoperacao = numoperacao;
	}

	/**
	 * @return o valor do nbletonegoccmbio
	 */
	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}

	/**
	 * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
	 */
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	/**
	 * @return o valor do dfimnegoccmbio
	 */
	public String getDfimnegoccmbio() {
		return dfimnegoccmbio;
	}

	/**
	 * @param dfimnegoccmbio seta o novo valor para o campo dfimnegoccmbio
	 */
	public void setDfimnegoccmbio(String dfimnegoccmbio) {
		this.dfimnegoccmbio = dfimnegoccmbio;
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
	 * @return o valor do iindcdeconmmoeda
	 */
	public String getIindcdeconmmoeda() {
		return iindcdeconmmoeda;
	}

	/**
	 * @param iindcdeconmmoeda seta o novo valor para o campo iindcdeconmmoeda
	 */
	public void setIindcdeconmmoeda(String iindcdeconmmoeda) {
		this.iindcdeconmmoeda = iindcdeconmmoeda;
	}

	/**
	 * @return o valor do vnegocmoedaestrg
	 */
	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}

	/**
	 * @param vnegocmoedaestrg seta o novo valor para o campo vnegocmoedaestrg
	 */
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

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
	 * @return o valor do iprodtservc
	 */
	public String getIprodtservc() {
		return iprodtservc;
	}

	/**
	 * @param iprodtservc seta o novo valor para o campo iprodtservc
	 */
	public void setIprodtservc(String iprodtservc) {
		this.iprodtservc = iprodtservc;
	}

	/**
	 * @return o valor do dataVencimento
	 */
	public String getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento seta o novo valor para o campo dataVencimento
	 */
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * @return o valor do valorMoeda
	 */
	public String getValorMoeda() {
		return valorMoeda;
	}

	/**
	 * @param valorMoeda seta o novo valor para o campo valorMoeda
	 */
	public void setValorMoeda(String valorMoeda) {
		this.valorMoeda = valorMoeda;
	}

    /**
     * @return o valor do nbletocmbioano
     */
    public Long getNbletocmbioano() {
        return nbletocmbioano;
    }

    /**
     * @param nbletocmbioano seta o novo valor para o campo nbletocmbioano
     */
    public void setNbletocmbioano(Long nbletocmbioano) {
        this.nbletocmbioano = nbletocmbioano;
    }

    /**
     * @return o valor do danobase
     */
    public Integer getDanobase() {
        return danobase;
    }

    /**
     * @param danobase seta o novo valor para o campo danobase
     */
    public void setDanobase(Integer danobase) {
        this.danobase = danobase;
    }

	public String getCindcdvncloimpor() {
		return cindcdvncloimpor;
	}

	public void setCindcdvncloimpor(String cindcdvncloimpor) {
		this.cindcdvncloimpor = cindcdvncloimpor;
	}

}
