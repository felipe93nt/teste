package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.bean;

public class OperacoesPendTotaisVO {

	/**
	 * UNIDADE
	 */	
	private String nomeundorgnz;
	
	/**
	 * VALOR
	 */	
	private String vprevtdsembcmbio;
	
	/**
	 * SITUACAO
	 */
	private String isitbletocmbio;
	

	public String getNomeundorgnz() {
		return nomeundorgnz;
	}

	public void setNomeundorgnz(String nomeundorgnz) {
		this.nomeundorgnz = nomeundorgnz;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}

	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}

	public String getIsitbletocmbio() {
		return isitbletocmbio;
	}

	public void setIsitbletocmbio(String isitbletocmbio) {
		this.isitbletocmbio = isitbletocmbio;
	}
}
