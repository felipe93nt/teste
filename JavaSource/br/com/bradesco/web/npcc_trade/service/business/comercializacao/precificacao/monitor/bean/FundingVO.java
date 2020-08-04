package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

public class FundingVO {
	
	/**
	 * CODIGO EXTERNO REFEERNCIA FUNDING
	 */
	private String cexterreftfndng;
	
	/**
	 * CODIGO DA MOEDA DO BOLETO
	 */
	private Integer cindcdeconmmoeda;
	/**
	 * DESCRICAO DA MOEDA
	 */
	private String descreconmmoeda;
	
	/**
	 * VALOR DA PARCELA FUNDING CAMBIO
	 */
	private String vpcelafndngcmbio;
	
	/**
	 * 	VALOR ME (MOEDA EXTERNA)
	 */
	private String vfndngnegoccmbio;
	
	public String getcexterreftfndng() {
		return cexterreftfndng;
	}

	public void setcexterreftfndng(String cexterreftfndng) {
		this.cexterreftfndng = cexterreftfndng;
	}

	public Integer getcindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setcindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getvpcelafndngcmbio() {
		return vpcelafndngcmbio;
	}

	public void setvpcelafndngcmbio(String vpcelafndngcmbio) {
		this.vpcelafndngcmbio = vpcelafndngcmbio;
	}

	public String getdescreconmmoeda() {
		return descreconmmoeda;
	}

	public void setdescreconmmoeda(String descreconmmoeda) {
		this.descreconmmoeda = descreconmmoeda;
	}

	public String getVfndngnegoccmbio() {
		return vfndngnegoccmbio;
	}

	public void setVfndngnegoccmbio(String vfndngnegoccmbio) {
		this.vfndngnegoccmbio = vfndngnegoccmbio;
	}
	
	
}
