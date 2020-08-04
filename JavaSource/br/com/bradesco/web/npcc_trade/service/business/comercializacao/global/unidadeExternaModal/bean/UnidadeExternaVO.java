package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean;

public class UnidadeExternaVO implements Cloneable{

	/***************  Tela Modal Selecionar Unidade Externa **************/
	private Integer tipoPesquisaUnidExt = 0;
	
	private String ibanqrcmbio = null;

	private Long cbanqrcmbio = 0L;

	private String cidbanqrswift = null;

	private String cflialbanqrswift = null;

	private Integer cpais = 0;

	private String ipais = null;

	private Long cmunintlcmbio = 0L;

	private String imunintlcmbio = null;

	private Integer ctrocamsgemswift = 0;

	private Integer cindcdbloqueado = 0;

	/**
	 * BANCO CORRESPONDENTE
	 */
	private String bancocorr;
	
	/**
	 * CODIGO DO BANCO CORRESPONDENTE
	 */
	private Long cbancoocrr;
	
	/**
	 * BANCO DESEMBOLSADOR
	 */
	private String bancodesemb;
	
	/**
	 * CODIGO DO BANCO DESEMBOLSADOR
	 */
	private Long cbancodesemb;
	
    /**
     * BANCO AVISADOR
     */
    private String bancoaviso;
    
    /**
     * CODIGO DO BANCO AVISADOR
     */
    private Long cbancoaviso;
    
    /**
     * BANCO INDICADOR
     */
    private String bancoindica;
    
    /**
     * CODIGO DO BANCO INDICADOR
     */
    private Long cbancoindica;
    
    /**
     * VALOR DO CAMPO COMISSÃO DE DESEMBOLSO
     */
    private String comissaodsemblso = null;
	
	public String getIbanqrcmbio() {
		return ibanqrcmbio;
	}

	public void setIbanqrcmbio(String ibanqrcmbio) {
		this.ibanqrcmbio = ibanqrcmbio;
	}

	public Long getCbanqrcmbio() {
		return cbanqrcmbio;
	}

	public void setCbanqrcmbio(Long cbanqrcmbio) {
		this.cbanqrcmbio = cbanqrcmbio;
	}

	public String getCidbanqrswift() {
		return cidbanqrswift;
	}

	public void setCidbanqrswift(String cidbanqrswift) {
		this.cidbanqrswift = cidbanqrswift;
	}

	public String getCflialbanqrswift() {
		return cflialbanqrswift;
	}

	public void setCflialbanqrswift(String cflialbanqrswift) {
		this.cflialbanqrswift = cflialbanqrswift;
	}

	public Integer getCpais() {
		return cpais;
	}

	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getIpais() {
		return ipais;
	}

	public void setIpais(String ipais) {
		this.ipais = ipais;
	}

	public Long getCmunintlcmbio() {
		return cmunintlcmbio;
	}

	public void setCmunintlcmbio(Long cmunintlcmbio) {
		this.cmunintlcmbio = cmunintlcmbio;
	}

	public String getImunintlcmbio() {
		return imunintlcmbio;
	}

	public void setImunintlcmbio(String imunintlcmbio) {
		this.imunintlcmbio = imunintlcmbio;
	}

	public Integer getCtrocamsgemswift() {
		return ctrocamsgemswift;
	}

	public void setCtrocamsgemswift(Integer ctrocamsgemswift) {
		this.ctrocamsgemswift = ctrocamsgemswift;
	}

	public Integer getCindcdbloqueado() {
		return cindcdbloqueado;
	}

	public void setCindcdbloqueado(Integer cindcdbloqueado) {
		this.cindcdbloqueado = cindcdbloqueado;
	}

	public String getBancocorr() {
		return bancocorr;
	}

	public void setBancocorr(String bancocorr) {
		this.bancocorr = bancocorr;
	}

	public String getBancodesemb() {
		return bancodesemb;
	}

	public void setBancodesemb(String bancodesemb) {
		this.bancodesemb = bancodesemb;
	}

    public String getBancoaviso() {
        return bancoaviso;
    }

    public void setBancoaviso(String bancoaviso) {
        this.bancoaviso = bancoaviso;
    }

    public String getBancoindica() {
        return bancoindica;
    }

    public void setBancoindica(String bancoindica) {
        this.bancoindica = bancoindica;
    }

    public Long getCbancoocrr() {
		return cbancoocrr;
	}

	public void setCbancoocrr(Long cbancoocrr) {
		this.cbancoocrr = cbancoocrr;
	}

	public Long getCbancodesemb() {
		return cbancodesemb;
	}

	public void setCbancodesemb(Long cbancodesemb) {
		this.cbancodesemb = cbancodesemb;
	}

    public Long getCbancoaviso() {
        return cbancoaviso;
    }

    public void setCbancoaviso(Long cbancoaviso) {
        this.cbancoaviso = cbancoaviso;
    }

    public Long getCbancoindica() {
        return cbancoindica;
    }

    public void setCbancoindica(Long cbancoindica) {
        this.cbancoindica = cbancoindica;
    }

    public Integer getTipoPesquisaUnidExt() {
		return tipoPesquisaUnidExt;
	}

	public void setTipoPesquisaUnidExt(Integer tipoPesquisaUnidExt) {
		this.tipoPesquisaUnidExt = tipoPesquisaUnidExt;
	}

    /**
     * @return the comissaodsemblso
     */
    public String getComissaodsemblso() {
        return comissaodsemblso;
    }

    /**
     * @param comissaodsemblso the comissaodsemblso to set
     */
    public void setComissaodsemblso(String comissaodsemblso) {
        this.comissaodsemblso = comissaodsemblso;
    }
    
    public UnidadeExternaVO copy() {
        try {
            return (UnidadeExternaVO)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
	
   
}
