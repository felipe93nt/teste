package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;



public class CustoExternoVO {

    /**
     * ÓRGÃO GOVERNAMENTAL
     */
	private String iorgextercmbio = null;
    
    /**
	 * NÚMERO DA COTACAO
	 */
	private Long nbletonegoccmbio = 0L;

	/**
	 * SITUACAO DO BOLETO
	 */
	private Integer csitbletocmbio = 0;

	/**
	 * DATA LIMITE DA COTACAO
	 */
	private String dlimfndngcmbio = null;

	/**
	 * BANCO CORRESPONDENETE
	 */
	private Long cbanqrcmbiofndng = 0L;

	/**
	 * BANCO REEMBOLSADOR
	 */
	private Long cbanqrcmbiorcdor = 0L;
	
    /**
     * BANCO AVISADOR
     */
    private Long cbanqrcmbioaviso = 0L;	

	/**
	 * TAXA FIXA
	 */
	private String ptxfixacmbio = null;

	/**
	 * CODIGO DA MOEDA TAXA LIBOR
	 */
	private Integer cindcdeconmmoeda = 0;

	/**
	 * MESES TAXA LIBOR
	 */
	private Integer tmesliborcmbio = 0;

	/**
	 * TAXA LIBOR
	 */
	private String vtxliborcmbio = null;

	/**
	 * OBSERVACOES
	 */
	private String observacao = null;
	
	/**
	 * BANCO CORRESPONDENTE
	 */
	private String bancocorr;
	
	/**
	 * BANCO DESEMBOLSADOR
	 */
	private String bancodesemb;
	
	/**
     * COMISSÃO DE DESEMBOLSO
     */
	private String comissaodsemblso = null;
	
	/**
     * VALOR DE DESEMBOLSO
     */
    private String vlrcomisdsemb = null;
	
	/**
	  * SAÍDA - REGISTRO DE MANUTENÇÃO
	  */
	private String shmanutreg;
	
	/**
     * PRAZO DA OPERACAO (EM DIAS)
     */
    private Integer tdiaopercmbio = 0;
    
    /**
     * VALOR DA MOEDA ESTRANGEIRA (ME)
     */
    private String vnegocmoedaestrg = null;
    
    /**
     * CODIGO DO PRODUTO DA OPERACAO
     */
    private Integer cprodtservc = 0;
	
    public String getIorgextercmbio() {
        return iorgextercmbio;
    }

    public void setIorgextercmbio(String iorgextercmbio) {
        this.iorgextercmbio = iorgextercmbio;
    }

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

	public String getDlimfndngcmbio() {
		return dlimfndngcmbio;
	}

	public void setDlimfndngcmbio(String dlimfndngcmbio) {
		this.dlimfndngcmbio = dlimfndngcmbio;
	}

	public Long getCbanqrcmbiofndng() {
		return cbanqrcmbiofndng;
	}

	public void setCbanqrcmbiofndng(Long cbanqrcmbiofndng) {
		this.cbanqrcmbiofndng = cbanqrcmbiofndng;
	}

	public Long getCbanqrcmbiorcdor() {
		return cbanqrcmbiorcdor;
	}

	public void setCbanqrcmbiorcdor(Long cbanqrcmbiorcdor) {
		this.cbanqrcmbiorcdor = cbanqrcmbiorcdor;
	}

    public Long getCbanqrcmbioaviso() {
        return cbanqrcmbioaviso;
    }

    public void setCbanqrcmbioaviso(Long cbanqrcmbioaviso) {
        this.cbanqrcmbioaviso = cbanqrcmbioaviso;
    }

    public String getPtxfixacmbio() {
		return ptxfixacmbio;
	}

	public void setPtxfixacmbio(String ptxfixacmbio) {
		this.ptxfixacmbio = ptxfixacmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public Integer getTmesliborcmbio() {
		return tmesliborcmbio;
	}

	public void setTmesliborcmbio(Integer tmesliborcmbio) {
		this.tmesliborcmbio = tmesliborcmbio;
	}

	public String getVtxliborcmbio() {
		return vtxliborcmbio;
	}

	public void setVtxliborcmbio(String vtxliborcmbio) {
		this.vtxliborcmbio = vtxliborcmbio;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

    public String getShmanutreg() {
        return shmanutreg;
    }

    public void setShmanutreg(String shmanutreg) {
        this.shmanutreg = shmanutreg;
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

    /**
     * @return the vlrcomisdsemb
     */
    public String getVlrcomisdsemb() {
        return vlrcomisdsemb;
    }

    /**
     * @param vlrcomisdsemb the vlrcomisdsemb to set
     */
    public void setVlrcomisdsemb(String vlrcomisdsemb) {
        this.vlrcomisdsemb = vlrcomisdsemb;
    }

    /**
     * @return the tdiaopercmbio
     */
    public Integer getTdiaopercmbio() {
        return tdiaopercmbio;
    }

    /**
     * @param tdiaopercmbio the tdiaopercmbio to set
     */
    public void setTdiaopercmbio(Integer tdiaopercmbio) {
        this.tdiaopercmbio = tdiaopercmbio;
    }

    /**
     * @return the vnegocmoedaestrg
     */
    public String getVnegocmoedaestrg() {
        return vnegocmoedaestrg;
    }

    /**
     * @param vnegocmoedaestrg the vnegocmoedaestrg to set
     */
    public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
        this.vnegocmoedaestrg = vnegocmoedaestrg;
    }

    /**
     * @return the cprodtservc
     */
    public Integer getCprodtservc() {
        return cprodtservc;
    }

    /**
     * @param cprodtservc the cprodtservc to set
     */
    public void setCprodtservc(Integer cprodtservc) {
        this.cprodtservc = cprodtservc;
    }
    
}
