package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.npcc_trade.utils.enums.EnumComissaoSobre;

public class ComissaoInternaVO {

    /**
     * VALOR COMISSAO
     */
    private String vprevtcomistotal = null;
    
    /* VALOR DA COMISSAO TOTAL */
    private String vlxtotalcomis = null;

	/**
	 * NUMERO DA COMISSAO INTERNA
	 */
	private Integer ncomisintrncmbio;
	
	/**
	 * CODIGO DA PERIODICIDADE
	 */
	private Integer cfluxoperdccmbio;
	
	/**
	 * DESCRICAO DA PERIODICIDADE
	 */
	private String ifluxoperdccmbio;
	
	/**
	 * CODIGO DO MOMENTO
	 */
	private Integer cmomencobrcmbio;
	private String descrmomen = null;
	
	/**
	 * CODIGO DA MOEDA
	 */
	private Integer cindcdeconmmoeda;
	
	/**
	 * SIMBOLO DA MOEDA
	 */
	private String isglindcdeconmmoeda;
	
	/**
	 * VALOR COMISSAO INTERNA
	 */
	private String vprevtcomiscmbio;
	
	/**
	 * DATA PREVISTA DESEMBOLSO CAMBIO
	 */
	private String dprevtdsembcmbio;
	
	/**
	 * COD. IDENTIFICADOR TIPO COBRANCA COMISSAO INTERNA CAMBIO          
	 */
	private Integer ccobrcomisintrn;
	
	/**
	 * DESCRICAO TIPO COBRANCA COMISSAO INTERNA CAMBIO          
	 */
	private String descrComissao;
	
	/**
	 * % COMISSAO NEGOCIACAO CAMBIO          
	 */
	private String pcomisnegoccmbio;
	
	/**
     * % COMISSAO NEGOCIACAO CAMBIO ou Valor da Comissão          
     */
	private String valorComissaoBoleto;
	
	/**
	 *  COD. IDENTIFICADOR TIPO COBRANCA COMISSAO CAMBIO
	 *  1 - Total 
	 *  2 - Saldo Devedor          
	 */
	private Integer ccobrcomiscmbio;
	
	private String identificaCobranca;
	
	/**
	 * VALOR MINIMO COBRANCA COMISSAO NEGOCIACAO CAMBIO          
	 */
	private String vmincobrcomis;	      
	
	/**
	 * VALOR TAXA SPREAD CAMBIO APROVADO          
	 */
	private String vtxspreadaprov;
	
	/**
	 * VALOR TAXA SPREAD CAMBIO NEGOCIACAO          
	 */
	private String vtxspreadnegoc;
	
	/**
	 * VALOR TAXA SPREAD CAMBIO NEGOCIACAO          
	 */
	private String ptxflatpnalt;
	
	/**
	 * VALOR DO CUSTO TOTAL         
	 */
	private String custototal;
	
	/**
	 * NUMERO DA BOLETO NEGOCIACAO
	 */
	private Integer nbletonegoccmbio;
	
	/**
	 * NUMERO DA COMISSAO INTERNA
	 */
	private Integer ncomisintrntrade;
	
	/**
	 * NUMERO DA PARCELA
	 */
	private Integer npcelacomisintrn;
	
	/**
	 * VENCIMENTO DA PARCELA
	 */
	private String  dvctopcelatrade;
	
	/**
	 * VALOR DA PARCELA
	 */
	private String vpcelacomiscmbio;
	
	/**
	 * PRAZO DA PARCELA
	 */
	private Integer prazoparcela;     
	
	/**
	 * DESCRICAO DO MOMENTO
	 */
	private String descrmomento;
	
	/**
	 * QTDE DE PARCELAS
	 */
	private Integer qtdepcela;
	
	/**
     * DESCRICAO PARA CAMPO COMISSAO GERAR BOLETO
     */
    private String desccomisbleto;
    
    /**
     * SPREAD TOTAL
     */
    private String vtxspreadtot = null;
	
	
	private List<ComissaoInternaVO> lista = new ArrayList<ComissaoInternaVO>();

	public Integer getNcomisintrncmbio() {
		return ncomisintrncmbio;
	}

	public void setNcomisintrncmbio(Integer ncomisintrncmbio) {
		this.ncomisintrncmbio = ncomisintrncmbio;
	}

	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}

	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}

	public String getIfluxoperdccmbio() {
		return ifluxoperdccmbio;
	}

	public void setIfluxoperdccmbio(String ifluxoperdccmbio) {
		this.ifluxoperdccmbio = ifluxoperdccmbio;
	}

	public Integer getCmomencobrcmbio() {
		return cmomencobrcmbio;
	}

	public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
		this.cmomencobrcmbio = cmomencobrcmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getIsglindcdeconmmoeda() {
		return isglindcdeconmmoeda;
	}

	public void setIsglindcdeconmmoeda(String isglindcdeconmmoeda) {
		this.isglindcdeconmmoeda = isglindcdeconmmoeda;
	}

	public String getVprevtcomiscmbio() {
		return vprevtcomiscmbio;
	}

	public void setVprevtcomiscmbio(String vprevtcomiscmbio) {
		this.vprevtcomiscmbio = vprevtcomiscmbio;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}

	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public Integer getCcobrcomisintrn() {
		return ccobrcomisintrn;
	}

	public void setCcobrcomisintrn(Integer ccobrcomisintrn) {
		this.ccobrcomisintrn = ccobrcomisintrn;
	}

	public String getDescrComissao() {
		return descrComissao;
	}

	public void setDescrComissao(String descrComissao) {
		this.descrComissao = descrComissao;
	}

	public String getPcomisnegoccmbio() {
		return pcomisnegoccmbio;
	}

	public void setPcomisnegoccmbio(String pcomisnegoccmbio) {
		this.pcomisnegoccmbio = pcomisnegoccmbio;
	}

	public Integer getCcobrcomiscmbio() {
		return ccobrcomiscmbio;
	}

	public void setCcobrcomiscmbio(Integer ccobrcomiscmbio) {
		this.ccobrcomiscmbio = ccobrcomiscmbio;
	}

	public String getVmincobrcomis() {
		return vmincobrcomis;
	}

	public void setVmincobrcomis(String vmincobrcomis) {
		this.vmincobrcomis = vmincobrcomis;
	}

	public String getVtxspreadaprov() {
		return vtxspreadaprov;
	}

	public void setVtxspreadaprov(String vtxspreadaprov) {
		this.vtxspreadaprov = vtxspreadaprov;
	}

	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}

	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}

	public String getPtxflatpnalt() {
		return ptxflatpnalt;
	}

	public void setPtxflatpnalt(String ptxflatpnalt) {
		this.ptxflatpnalt = ptxflatpnalt;
	}

	public String getCustototal() {
		return custototal;
	}

	public void setCustototal(String custototal) {
		this.custototal = custototal;
	}

	public Integer getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}

	public void setNbletonegoccmbio(Integer nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Integer getNcomisintrntrade() {
		return ncomisintrntrade;
	}

	public void setNcomisintrntrade(Integer ncomisintrntrade) {
		this.ncomisintrntrade = ncomisintrntrade;
	}

	public Integer getNpcelacomisintrn() {
		return npcelacomisintrn;
	}

	public void setNpcelacomisintrn(Integer npcelacomisintrn) {
		this.npcelacomisintrn = npcelacomisintrn;
	}

	public String getDvctopcelatrade() {
		return dvctopcelatrade;
	}

	public void setDvctopcelatrade(String dvctopcelatrade) {
		this.dvctopcelatrade = dvctopcelatrade;
	}

	public String getVpcelacomiscmbio() {
		return vpcelacomiscmbio;
	}

	public void setVpcelacomiscmbio(String vpcelacomiscmbio) {
		this.vpcelacomiscmbio = vpcelacomiscmbio;
	}

	public Integer getPrazoparcela() {
		return prazoparcela;
	}

	public void setPrazoparcela(Integer prazoparcela) {
		this.prazoparcela = prazoparcela;
	}

	public String getDescrmomento() {
		return descrmomento;
	}

	public void setDescrmomento(String descrmomento) {
		this.descrmomento = descrmomento;
	}

	public List<ComissaoInternaVO> getLista() {
		return lista;
	}

	public void setLista(List<ComissaoInternaVO> lista) {
		this.lista = lista;
	}

	public Integer getQtdepcela() {
		return qtdepcela;
	}

	public void setQtdepcela(Integer qtdepcela) {
		this.qtdepcela = qtdepcela;
	}

    /**
     * @return o valor do vprevtcomistotal
     */
    public String getVprevtcomistotal() {
        return vprevtcomistotal;
    }

    /**
     * @param vprevtcomistotal seta o novo valor para o campo vprevtcomistotal
     */
    public void setVprevtcomistotal(String vprevtcomistotal) {
        this.vprevtcomistotal = vprevtcomistotal;
    }

    /**
     * @return o valor do descrmomen
     */
    public String getDescrmomen() {
        return descrmomen;
    }

    /**
     * @param descrmomen seta o novo valor para o campo descrmomen
     */
    public void setDescrmomen(String descrmomen) {
        this.descrmomen = descrmomen;
    }

    /**
     * @return o valor do identificaCobranca
     */
    public String getIdentificaCobranca() {
        
        /**
         *  COD. IDENTIFICADOR TIPO COBRANCA COMISSAO CAMBIO
         *  1 - Total 
         *  2 - Saldo Devedor          
         */
    	if (ccobrcomiscmbio != null) {
    		this.identificaCobranca = EnumComissaoSobre.fromCode(ccobrcomiscmbio).getDescricao();
		}
        return this.identificaCobranca;
    }

    /**
     * @param identificaCobranca seta o novo valor para o campo identificaCobranca
     */
    public void setIdentificaCobranca(String identificaCobranca) {
        this.identificaCobranca = identificaCobranca;
    }

    /**
     * @return o valor do valorComissaoBoleto
     */
    public String getValorComissaoBoleto() {
        return valorComissaoBoleto;
    }

    /**
     * @param valorComissaoBoleto seta o novo valor para o campo valorComissaoBoleto
     */
    public void setValorComissaoBoleto(String valorComissaoBoleto) {
        this.valorComissaoBoleto = valorComissaoBoleto;
    }

    /**
     * @return the desccomisbleto
     */
    public String getDesccomisbleto() {
        return desccomisbleto;
    }

    /**
     * @param desccomisbleto the desccomisbleto to set
     */
    public void setDesccomisbleto(String desccomisbleto) {
        this.desccomisbleto = desccomisbleto;
    }

    /**
     * @return the vtxspreadtot
     */
    public String getVtxspreadtot() {
        return vtxspreadtot;
    }

    /**
     * @param vtxspreadtot the vtxspreadtot to set
     */
    public void setVtxspreadtot(String vtxspreadtot) {
        this.vtxspreadtot = vtxspreadtot;
    }

    /**
     * @return o valor do vlxtotalcomis
     */
    public String getVlxtotalcomis() {
        return vlxtotalcomis;
    }

    /**
     * @param vlxtotalcomis seta o novo valor para o campo vlxtotalcomis
     */
    public void setVlxtotalcomis(String vlxtotalcomis) {
        this.vlxtotalcomis = vlxtotalcomis;
    }
    
}
