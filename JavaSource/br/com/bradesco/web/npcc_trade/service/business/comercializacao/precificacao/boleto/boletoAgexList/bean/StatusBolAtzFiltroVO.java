package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean;


public class StatusBolAtzFiltroVO {

    private Long enbletonegoccmbio = 0L;

    /*STATUS DO BOLETO*/
    private Integer estatusbletocmbio = 0;

    /*STATUS ANTERIOR DO BOLETO*/
	private Integer estatusbletoanter = 0;
    
    private String evultestrnbaixa = null;

    private String esaldbletocmbio = null;
    
	private Integer ecindcdmoedautlzd = 0;
	
	private Integer etmaxcontrprodt = 0;
    
    /**
     * Construtor
     * 
     * @param
     */
    public StatusBolAtzFiltroVO() {
        super();
    }

    /**
     * @return o valor do enbletonegoccmbio
     */
    public Long getEnbletonegoccmbio() {
        return enbletonegoccmbio;
    }

    /**
     * @param enbletonegoccmbio seta o novo valor para o campo enbletonegoccmbio
     */
    public void setEnbletonegoccmbio(Long enbletonegoccmbio) {
        this.enbletonegoccmbio = enbletonegoccmbio;
    }

    /**
     * @return o valor do estatusbletocmbio
     */
    public Integer getEstatusbletocmbio() {
        return estatusbletocmbio;
    }

    /**
     * @param estatusbletocmbio seta o novo valor para o campo estatusbletocmbio
     */
    public void setEstatusbletocmbio(Integer estatusbletocmbio) {
        this.estatusbletocmbio = estatusbletocmbio;
    }

    
    /**
	 * @return the estatusbletoanter
	 */
	public Integer getEstatusbletoanter() {
		return estatusbletoanter;
	}

    /**
     * @param estatusbletocmbio seta o novo valor para o campo estatusbletoanter
     */
	public void setEstatusbletoanter(Integer estatusbletoanter) {
		this.estatusbletoanter = estatusbletoanter;
	}

	/**
     * @return o valor do evultestrnbaixa
     */
    public String getEvultestrnbaixa() {
        return evultestrnbaixa;
    }

    /**
     * @param evultestrnbaixa seta o novo valor para o campo evultestrnbaixa
     */
    public void setEvultestrnbaixa(String evultestrnbaixa) {
        this.evultestrnbaixa = evultestrnbaixa;
    }

    /**
     * @return o valor do esaldbletocmbio
     */
    public String getEsaldbletocmbio() {
        return esaldbletocmbio;
    }

    /**
     * @param esaldbletocmbio seta o novo valor para o campo esaldbletocmbio
     */
    public void setEsaldbletocmbio(String esaldbletocmbio) {
        this.esaldbletocmbio = esaldbletocmbio;
    }

	/**
	 * @return the ecindcdmoedautlzd
	 */
	public Integer getEcindcdmoedautlzd() {
		return ecindcdmoedautlzd;
	}

	/**
	 * @param ecindcdmoedautlzd the ecindcdmoedautlzd to set
	 */
	public void setEcindcdmoedautlzd(Integer ecindcdmoedautlzd) {
		this.ecindcdmoedautlzd = ecindcdmoedautlzd;
	}

	public Integer getEtmaxcontrprodt() {
		return etmaxcontrprodt;
	}

	public void setEtmaxcontrprodt(Integer etmaxcontrprodt) {
		this.etmaxcontrprodt = etmaxcontrprodt;
	}

}
