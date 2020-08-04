package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;



public class ComboTipoGarantiaVO {

	/**
	 * CODIGO DA GARANTIA
	 */
	private Integer cdgarnt = 0;

	/**
	 * DESCRICAO DA GARANTIA
	 */
	private String dsgarnt = null;

	/**
	 * MOEDA DA GARANTIA
	 */
	private Integer cindcdeconmmoegar = 0;

	/**
	 * VENCIMENTO DA GARANTIA
	 */
	private String dvctogarantcmbio = null;

	public Integer getCdgarnt() {
		return cdgarnt;
	}

	public void setCdgarnt(Integer cdgarnt) {
		this.cdgarnt = cdgarnt;
	}

	public String getDsgarnt() {
		return dsgarnt;
	}

	public void setDsgarnt(String dsgarnt) {
		this.dsgarnt = dsgarnt;
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
	 * @return o valor do dvctogarantcmbio
	 */
	public String getDvctogarantcmbio() {
		return dvctogarantcmbio;
	}

	/**
	 * @param dvctogarantcmbio seta o novo valor para o campo dvctogarantcmbio
	 */
	public void setDvctogarantcmbio(String dvctogarantcmbio) {
		this.dvctogarantcmbio = dvctogarantcmbio;
	}
	
	
	
}
