package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.cotacoesaVencer.bean;


public class CotacoesaVencerVO {

    /**
     * NUMERO DA COTACAO (BOLETO)
     */
    private Integer nbletocmbio;
    
    /**
     * ANO BASE
     */
    private String danobase;
    
    /**
     * NUMERO DA COTACAO CONHECIDO
     */
    private String nbletocmbioano;
    
    /**
     * DATA DE FECHAMENTO BOLETO
     */
    private String dfchtobletocmbio;
    
    /**
     * CÓDIGO ÚNICO DO CLIENTE
     */
    private Integer cuniccliccmbio;
    
    /**
     * CÓDIGO INDICADOR ECONOMIA MOEDA
     */
    private Integer cindcdeconmmoeda;
    
    /**
     * CÓDIGO PRODUTO SERVIÇO
     */
    private Integer cprodtserv;
    
    /**
     * CÓDIGO ECONÔMICO MOEDA LIMITE
     */
    private Integer ceconmmoedalim;
    
    /**
     * DATA FIM NECOCIAÇÃO CÂMBIO
     */
    private String dfimnegoccmbio;
    
    /**
     * VALOR NEGÓCIO MOEDA ESTRANGEIRA
     */
    private String vnegocmoedaestrg;
    
    /**
     * VALOR NEGÓCIO MOEDA DOLAR
     */
    private String vnegocmoedadolar;
    
    /**
     * DESCRIÇÃO PRODUTO
     */
    private String descprod;
    
    /**
     * INDICADOR GL 1 - SIM / 2 - NAO
     */
    private String isglindcdfonte;

    /**
     * DESCRIÇÃO DO NOME DO CLIENTE
     */
    private String nomecompletocli;
    

	/**
     * @return o número do boleto
     */
	public Integer getNbletocmbio() {
		return nbletocmbio;
	}
	
    /**
     * @param seta o número do boleto
     */
	public void setNbletocmbio(Integer nbletocmbio) {
		this.nbletocmbio = nbletocmbio;
	}

    /**
     * @return o ano base
     */
	public String getDanobase() {
		return danobase;
	}

    /**
     * @param seta o ano base
     */
	public void setDanobase(String danobase) {
		this.danobase = danobase;
	}

    /**
     * @return a data de fechamento do boleto
     */
	public String getDfchtobletocmbio() {
		return dfchtobletocmbio;
	}

    /**
     * @param seta a data de fechamento do boleto
     */
	public void setDfchtobletocmbio(String dfchtobletocmbio) {
		this.dfchtobletocmbio = dfchtobletocmbio;
	}

    /**
     * @return o código único do cliente
     */
	public Integer getCuniccliccmbio() {
		return cuniccliccmbio;
	}

    /**
     * @param seta o código único do cliente
     */
	public void setCuniccliccmbio(Integer cuniccliccmbio) {
		this.cuniccliccmbio = cuniccliccmbio;
	}

    /**
     * @return o código de indicador da moeda
     */
	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

    /**
     * @param seta o código de indicador da moeda
     */
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

    /**
     * @return o código do serviço
     */
	public Integer getCprodtserv() {
		return cprodtserv;
	}

    /**
     * @param seta o código de indicador da moeda
     */
	public void setCprodtserv(Integer cprodtserv) {
		this.cprodtserv = cprodtserv;
	}

    /**
     * @return o código de limite econômico da moeda
     */
	public Integer getCeconmmoedalim() {
		return ceconmmoedalim;
	}

    /**
     * @param seta o código de limite econômico da moeda
     */
	public void setCeconmmoedalim(Integer ceconmmoedalim) {
		this.ceconmmoedalim = ceconmmoedalim;
	}

    /**
     * @return a data de finalização do câmbio
     */
	public String getDfimnegoccmbio() {
		return dfimnegoccmbio;
	}

    /**
     * @param seta a data de finalização do câmbio
     */
	public void setDfimnegoccmbio(String dfimnegoccmbio) {
		this.dfimnegoccmbio = dfimnegoccmbio;
	}

    /**
     * @return o valor da negociaçao da moeda estrangeira
     */
	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}

    /**
     * @param seta o valor da negociaçao da moeda estrangeira
     */
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

    /**
     * @return o valor da negociaçao da moeda dolar
     */
	public String getVnegocmoedadolar() {
		return vnegocmoedadolar;
	}

    /**
     * @param seta o valor da negociaçao da moeda dolar
     */
	public void setVnegocmoedadolar(String vnegocmoedadolar) {
		this.vnegocmoedadolar = vnegocmoedadolar;
	}

    /**
     * @return a descição do produto
     */
	public String getDescprod() {
		return descprod;
	}

    /**
     * @param seta a descição do produto
     */
	public void setDescprod(String descprod) {
		this.descprod = descprod;
	}

    /**
     * @return valor de GL
     */
    public String getIsglindcdfonte() {
		return isglindcdfonte;
	}

    /**
     * @param seta valor de GL
     */
	public void setIsglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}

    /**
     * @return o nome do cliente
     */
    public String getNomecompletocli() {
		return nomecompletocli;
	}

	/**
     * @param seta o nome do cliente
     */
	public void setNomecompletocli(String nomecompletocli) {
		this.nomecompletocli = nomecompletocli;
	}

	/**
     * @return numero do boleto conhecido
     */
	public String getNbletocmbioano() {
		return nbletocmbioano;
	}

	/**
     * @param numero do boleto conhecido
     */
	public void setNbletocmbioano(String nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}
}
