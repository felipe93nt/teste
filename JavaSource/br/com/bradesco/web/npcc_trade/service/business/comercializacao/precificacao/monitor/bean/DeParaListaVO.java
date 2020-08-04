package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

public class DeParaListaVO {

	/**
	 * CAMPO PARA
	 */
	private String pcampo;
	
	/**
	 * DESCRICAO
	 */
	private String ncampo;
	
	/**
	 * CAMPO DE 
	 */
	private String dcampo;
	
	/**
	 * Indica se os valores De/Para são diferentes
	 */
	private boolean diferente = Boolean.FALSE;
	
	public String getPcampo() {
		return pcampo;
	}

	public void setPcampo(String pcampo) {
		this.pcampo = pcampo;
	}

	public String getNcampo() {
		return ncampo;
	}

	public void setNcampo(String ncampo) {
		this.ncampo = ncampo;
	}

	public String getDcampo() {
		return dcampo;
	}

	public void setDcampo(String dcampo) {
		this.dcampo = dcampo;
	}

    public boolean isDiferente() {
        return diferente;
    }

    public void setDiferente(boolean diferente) {
        this.diferente = diferente;
    }
	
}
