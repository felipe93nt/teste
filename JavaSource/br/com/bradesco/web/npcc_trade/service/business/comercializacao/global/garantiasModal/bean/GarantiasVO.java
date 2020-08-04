package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean;

import java.io.Serializable;
/**
 * 
  * Nome: GarantiasVO.java
  * 
  * Propósito: <p> Classe utilizada para apresentacao da listagem de Historico Antecipacao Boleto </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 14/01/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class GarantiasVO implements Serializable {
    
    private static final long serialVersionUID = 0L;

    /**
	 * CODIGO DO TIPO DE GARANTIA
	 */
	private Integer ccaractpogarnt = 0;

    /**
	 * DESCRICAO DO TIPO DE GARANTIA
	 */
	private String icaractpogarnt = null;
	
	/**
	 * DESCRICAO DO TIPO DE GARANTIA
	 */
	private String descrGaran = null;
	
	/**
	 * PERCENTUAL
	 */
	private String vtxgarntcmbio = null;
	
	/**
	 * OBSERVACAO
	 */
	private String rcomplgarntcmbio = null;
	
	/**
	 * MOEDA GARANTIA
	 */
	private Integer cindcdeconmmoegar = 0;
	
	/**
	 * DESCRICAO DA MOEDA GARANTIA
	 */

	private String descrMoedaGar = null;

	/**
	 * BOLETO
	 */
	private Long nbletonegoccmbio = null;

	/**
	 * INDICA SE GARANTIA PRINCIPAL
	 */
	private String cindcdgarntprinc = null;

	/**
	 * INDICA SE GARANTIA E CLIM
	 */
	private Integer cidtfdgarntadcio = 0;

	/**
	 * DATA VENCIMENTO GARANTIA
	 */
	private String dvctogarntcmbio = null;
	
	private String descPrincipal = null;
	
	/**
	 * @return o valor do icaractpogarnt
	 */
	public String getIcaractpogarnt() {
		return icaractpogarnt;
	}

	/**
	 * @param icaractpogarnt seta o novo valor para o campo icaractpogarnt
	 */
	public void setIcaractpogarnt(String icaractpogarnt) {
		this.icaractpogarnt = icaractpogarnt;
	}

	/**
	 * @return o valor do descrGaran
	 */
	public String getDescrGaran() {
		return descrGaran;
	}

	/**
	 * @param descrGaran seta o novo valor para o campo descrGaran
	 */
	public void setDescrGaran(String descrGaran) {
		this.descrGaran = descrGaran;
	}

	/**
	 * @return o valor do vtxgarntcmbio
	 */
	public String getVtxgarntcmbio() {
		return vtxgarntcmbio;
	}

	/**
	 * @param vtxgarntcmbio seta o novo valor para o campo vtxgarntcmbio
	 */
	public void setVtxgarntcmbio(String vtxgarntcmbio) {
		this.vtxgarntcmbio = vtxgarntcmbio;
	}

	/**
	 * @return o valor do rcomplgarntcmbio
	 */
	public String getRcomplgarntcmbio() {
		return rcomplgarntcmbio;
	}

	/**
	 * @param rcomplgarntcmbio seta o novo valor para o campo rcomplgarntcmbio
	 */
	public void setRcomplgarntcmbio(String rcomplgarntcmbio) {
		this.rcomplgarntcmbio = rcomplgarntcmbio;
	}

	/**
	 * @return o valor do cindcdeconmmoegar
	 */
	public Integer getCindcdeconmmoegar() {
		return cindcdeconmmoegar;
	}

	/**
	 * @param cindcdeconmmoegar seta o novo valor para o campo cindcdeconmmoegar
	 */
	public void setCindcdeconmmoegar(Integer cindcdeconmmoegar) {
		this.cindcdeconmmoegar = cindcdeconmmoegar;
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
	 * @return o valor do cindcdgarntprinc
	 */
	public String getCindcdgarntprinc() {
		return cindcdgarntprinc;
	}

	/**
	 * @param cindcdgarntprinc seta o novo valor para o campo cindcdgarntprinc
	 */
	public void setCindcdgarntprinc(String cindcdgarntprinc) {
		this.cindcdgarntprinc = cindcdgarntprinc;
	}

	/**
	 * @return o valor do cidtfdgarntadcio
	 */
	public Integer getCidtfdgarntadcio() {
		return cidtfdgarntadcio;
	}

	/**
	 * @param cidtfdgarntadcio seta o novo valor para o campo cidtfdgarntadcio
	 */
	public void setCidtfdgarntadcio(Integer cidtfdgarntadcio) {
		this.cidtfdgarntadcio = cidtfdgarntadcio;
	}

	/**
	 * @return o valor do dvctogarntcmbio
	 */
	public String getDvctogarntcmbio() {
		return dvctogarntcmbio;
	}

	/**
	 * @param dvctogarntcmbio seta o novo valor para o campo dvctogarntcmbio
	 */
	public void setDvctogarntcmbio(String dvctogarntcmbio) {
		this.dvctogarntcmbio = dvctogarntcmbio;
	}

	/**
	 * @return o valor do ccaractpogarnt
	 */
	public Integer getCcaractpogarnt() {
		return ccaractpogarnt;
	}

	/**
	 * @param ccaractpogarnt seta o novo valor para o campo ccaractpogarnt
	 */
	public void setCcaractpogarnt(Integer ccaractpogarnt) {
		this.ccaractpogarnt = ccaractpogarnt;
	}

    public String getDescPrincipal() {
        return descPrincipal;
    }

    public void setDescPrincipal(String descPrincipal) {
        this.descPrincipal = descPrincipal;
    }
	
	public String getDescrMoedaGar() {
		return descrMoedaGar;
	}

	public void setDescrMoedaGar(String descrMoedaGar) {
		this.descrMoedaGar = descrMoedaGar;
	}

	
}
