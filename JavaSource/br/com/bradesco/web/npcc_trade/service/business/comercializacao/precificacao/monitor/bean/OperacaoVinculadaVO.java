package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;



public class OperacaoVinculadaVO {
	
	/**
	 * numero da operacao vinculada
	 */
	private long nbletonegocvnclo;
	
	/**
     * NUMERO BOLETO CAMBIO ANO
     */
    private Long nbletocmbioano;
	
	/**
	 * codigo do produto
	 */
	private Integer cprodtservc;
	
	/**
	 * descricao do produto
	 */
	private String iprodtservc;
	
	/**
	 * codigo da moeda
	 */
	private Integer cindcdeconmmoeda;
	
	/**
	 * simbolo da moeda
	 */
	private String iindcdeconmmoeda;
	
	
	private String cindcdvncloimpor;
	
	/**
	 * valor moeda estrangeira
	 */
	private String vnegocmoedaestr;

	public long getNbletonegocvnclo() {
		return nbletonegocvnclo;
	}

	public void setNbletonegocvnclo(long nbletonegocvnclo) {
		this.nbletonegocvnclo = nbletonegocvnclo;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}

	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getIprodtservc() {
		return iprodtservc;
	}

	public void setIprodtservc(String iprodtservc) {
		this.iprodtservc = iprodtservc;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getIindcdeconmmoeda() {
		return iindcdeconmmoeda;
	}

	public void setIindcdeconmmoeda(String iindcdeconmmoeda) {
		this.iindcdeconmmoeda = iindcdeconmmoeda;
	}

	public String getVnegocmoedaestr() {
		return vnegocmoedaestr;
	}

	public void setVnegocmoedaestr(String vnegocmoedaestr) {
		this.vnegocmoedaestr = vnegocmoedaestr;
	}


	public Long getNbletocmbioano() {
		return nbletocmbioano;
	}

	public void setNbletocmbioano(Long nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}

	public String getCindcdvncloimpor() {
		return cindcdvncloimpor;
	}

	public void setCindcdvncloimpor(String cindcdvncloimpor) {
		this.cindcdvncloimpor = cindcdvncloimpor;
	}

	
}
