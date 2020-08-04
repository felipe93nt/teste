package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

public class OperacaoAditarVO {
	
	private Integer danobase = 0;
	private Integer numoperacao = 0;
	
	private Integer ccontrfinanexpor = 0;
	private String dfimfinanexpor = null;
	private Integer cmoedacmbiofinan = 0;
	private String vfinanexporcmbio = null;
	private String vfinandevedcmbio = null;
	private Integer ndsembcmbiotrade= 0;
	
	private String vladitado = null;
	
	public Integer getDanobase() {
		return danobase;
	}
	public void setDanobase(Integer danobase) {
		this.danobase = danobase;
	}
	public Integer getNumoperacao() {
		return numoperacao;
	}
	public void setNumoperacao(Integer numoperacao) {
		this.numoperacao = numoperacao;
	}
	
	public Integer getCcontrfinanexpor() {
		return ccontrfinanexpor;
	}
	public void setCcontrfinanexpor(Integer ccontrfinanexpor) {
		this.ccontrfinanexpor = ccontrfinanexpor;
	}
	public String getDfimfinanexpor() {
		return dfimfinanexpor;
	}
	public void setDfimfinanexpor(String dfimfinanexpor) {
		this.dfimfinanexpor = dfimfinanexpor;
	}
	public Integer getCmoedacmbiofinan() {
		return cmoedacmbiofinan;
	}
	public void setCmoedacmbiofinan(Integer cmoedacmbiofinan) {
		this.cmoedacmbiofinan = cmoedacmbiofinan;
	}
	public String getVfinanexporcmbio() {
		return vfinanexporcmbio;
	}
	public void setVfinanexporcmbio(String vfinanexporcmbio) {
		this.vfinanexporcmbio = vfinanexporcmbio;
	}
	public String getVfinandevedcmbio() {
		return vfinandevedcmbio;
	}
	public void setVfinandevedcmbio(String vfinandevedcmbio) {
		this.vfinandevedcmbio = vfinandevedcmbio;
	}
	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}
	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}
	public String getVladitado() {
		return vladitado;
	}
	public void setVladitado(String vladitado) {
		this.vladitado = vladitado;
	}

}
