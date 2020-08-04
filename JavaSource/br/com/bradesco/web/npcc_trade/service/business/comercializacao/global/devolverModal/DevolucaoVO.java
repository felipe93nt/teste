package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.devolverModal;

public class DevolucaoVO {
	/**
	 * NUMERO DO BOLETO 
	 */
	private Long nbletonegoccmbio;
	
	/**
	 * CODIGO DA SITUACAO
	 */
	private Integer csitbletocmbio;
	
	/**
	* CODIGO DO MOTIVO
	*/
	private Integer cmotvobletocmbio;
	 
	/**
	* OBSERVACAO 
	*/
	private String robsbletocmbio;
	
	/**
	 * TIPO DE OBSERVACAO 
	 */
	 private Integer ctpoobsbleto;
	 
	/**
	 * NUMERO DE CONTROLE DO LIMITE
	 */
	 private Long nseqcontrlim;
	 
	/**
	 * NR APROV. CREDITO 
	 */
	 private Long nppstapontucmbio;
	 

	/**
	 * STATUS DE APROVAÇÃO
	 */
	 private Integer csitbletoaprov = 0;


	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}

	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}

	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public Integer getCmotvobletocmbio() {
		return cmotvobletocmbio;
	}

	public void setCmotvobletocmbio(Integer cmotvobletocmbio) {
		this.cmotvobletocmbio = cmotvobletocmbio;
	}

	public String getRobsbletocmbio() {
		return robsbletocmbio;
	}

	public void setRobsbletocmbio(String robsbletocmbio) {
		this.robsbletocmbio = robsbletocmbio;
	}

	public Integer getCtpoobsbleto() {
		return ctpoobsbleto;
	}

	public void setCtpoobsbleto(Integer ctpoobsbleto) {
		this.ctpoobsbleto = ctpoobsbleto;
	}
	
	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}

	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}
	
	public Long getNppstapontucmbio() {
		return nppstapontucmbio;
	}

	public void setNppstapontucmbio(Long nppstapontucmbio) {
		this.nppstapontucmbio = nppstapontucmbio;
	}
	
	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}

	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}
	 
}
