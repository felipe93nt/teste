package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;


public class DataDesembolsoVO {

	/**
	 * NUMERO DO DESEMBOLSO
	 */
	private Integer ndsembcmbiotrade = 0;

	/**
	 * DATA DO DESEMBOLSO
	 */
	private String dprevtdsembcmbio = null;

	/**
	 * PRAZO DO DESEMBOLSO
	 */
	private Integer tdiafinandsemb = 0;

	/**
	 * VALOR DO DESEMBOLSO
	 */
	private String vprevtdsembcmbio = null;

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}

	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}

	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}

	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}

	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}
	
}
