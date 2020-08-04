/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 29/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;

/**
 * Nome: TrdFinNegComissaoVO.java
 * 
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 29/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TrdFinNegComissaoVO extends TrdFinNegComumVO implements IComissaoExterna  {
    
    /** 
     * TIPO COMISSAO - ADICIONAL ou BANQUEIRO
     */
    private EnumTipoComissao tipoComissao;
    private Integer crespcomisexter = 0;
	
	private Date dateComissao = null;
	private String dataComissaoFormat = null;
	
	/** 
     * FUNCAO COMISSAO INTERNA - I = Inclusão || A = Alteração(botão gerar do modal)
     */
	private String funcao = null;
	
    /* PRAZO DO DESEMBOLSO  */
	private Integer tdiafinandsemb = 0;
	
	/* PRAZO DO COMISSAO  */
	private Integer tdiaopercmbio = 0;

	private Integer ccobrcomisintrn = 0;
	
    private Integer ncomisextertrade = 0;

    /*  VALOR DA OPERACAO */
	private String vnegocmoedaestrg = null;
	
	/* TAXA DE JUROS */
	private String pjuronegoccmbio = null;
	
	/* PERIODICIDADE DA TAXA */
	private Integer cperdcjurocmbio = 0;
	private String periodoTaxa = null;

    /* VALOR DO DESEMBOLSO */
	private String vprevtdsembcmbio = null;

    /* VALOR MINIMO */
	private String vmincobrcomis = null;
	
    /* SPREAD APROVADO */
	private String ptxcustototal = null;

    /* SPREAD NEGOCIADO */
	private String vtxspreadnegoc = null;

    /* PERCENTUAL FLAT */
	private String ptxflatpnalt = null;

    /* PERCENTUAL COMISSAO */
    private String pcomisnegoccmbio = null;

    /* VALOR DA COMISSAO TOTAL */
	private String vlxtotalcomis = null;

    /* VALOR TOTAL DA COMISSAO CALCULADO */
	private String vprevtcomiscmbio = null;
	
	private String taxaComissao = null;
	
	private String periodoComissao = null;

	private Integer cfluxoperdccmbio = 0;
	private String periodicidadeComissao = null;
	
	private Integer codMomentoComissao = 0;
	private String momentoComissao = null;
	
	private Integer qpcelacmbiotrade = null;

	private Integer ccondceconc = 0;
	private String tipoComissaoExt = null;
	
	/* CODIGO IDENT. COMISSAO INTERNA */
    private Integer ncomisintrncmbio = 0;
	
	/**** Dados Calculo do Spread - Entrada ****/

	private Integer ccobrcomiscmbio = 0;

	private String vlxcomiscmbio = null;

	private String moedaComissao = null;

	private String vlxoperaccmbio = null;

	private Integer przoperaccmbio = 0;

	private String cindcdnegoccarta = null;
	
	private String ccomiscartanacio = null;

	private String cindcdnegocswap = null;

	private String vtravaliborcmbio = null;

	private String ptxcustoexter = null;

	private String ptximpstrenda = null;

	private Integer przoperaclibor = null;
	
	private Integer cprodtservc = 0;
	
	/** Variável do tipo Integer */
	private Integer cindcdeconmmoeda = null;
	
	/**** Dados Calculo do Spread - Saída ****/

	private String dsccustototal = null;
    
    /**** Custo Total calculado Forfaiting ****/

    private String custoTotalForfaiting = null;
    
    private Integer cpais = 0;

    private String vlimcobervar = null;
    
    private String vtxspreadtot = null;
    
	/**
	 * DATA PREVISTA DESEMBOLSO CAMBIO
	 */
	private String dprevtdsembcmbio;

    
	/**
     * From List
     */
    private Boolean fromList = Boolean.FALSE;
	
    /* LISTA-PARCELAS */
    private List<TrdFinNegParcelaVO> listaParcelasComissao = new ArrayList<TrdFinNegParcelaVO>();

    public boolean isPeriodicidadeIrregular() {
        
        if (cfluxoperdccmbio.equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) == true ) {
            return true;
        }
        return false;
    }


	/**
	 * @return o valor do dateComissao
	 */
	public Date getDateComissao() {
		return dateComissao;
	}


	/**
	 * @param dateComissao seta o novo valor para o campo dateComissao
	 */
	public void setDateComissao(Date dateComissao) {
		this.dateComissao = dateComissao;
	}


	/**
	 * @return o valor do dataComissaoFormat
	 */
	public String getDataComissaoFormat() {
		return dataComissaoFormat;
	}


	/**
	 * @param dataComissaoFormat seta o novo valor para o campo dataComissaoFormat
	 */
	public void setDataComissaoFormat(String dataComissaoFormat) {
		this.dataComissaoFormat = dataComissaoFormat;
	}


	/**
	 * @return o valor do tdiafinandsemb
	 */
	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}


	/**
	 * @param tdiafinandsemb seta o novo valor para o campo tdiafinandsemb
	 */
	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}

	/**
	 * @param vnegocmoedaestrg seta o novo valor para o campo vnegocmoedaestrg
	 */
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}


	/**
	 * @return o valor do pjuronegoccmbio
	 */
	public String getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}


	/**
	 * @param pjuronegoccmbio seta o novo valor para o campo pjuronegoccmbio
	 */
	public void setPjuronegoccmbio(String pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}


	/**
	 * @return o valor do cperdcjurocmbio
	 */
	public Integer getCperdcjurocmbio() {
		return cperdcjurocmbio;
	}


	/**
	 * @param cperdcjurocmbio seta o novo valor para o campo cperdcjurocmbio
	 */
	public void setCperdcjurocmbio(Integer cperdcjurocmbio) {
		this.cperdcjurocmbio = cperdcjurocmbio;
	}


	/**
	 * @return o valor do vprevtdsembcmbio
	 */
	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}


	/**
	 * @param vprevtdsembcmbio seta o novo valor para o campo vprevtdsembcmbio
	 */
	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}


	/**
	 * @return o valor do vmincobrcomis
	 */
	public String getVmincobrcomis() {
		return vmincobrcomis;
	}


	/**
	 * @param vmincobrcomis seta o novo valor para o campo vmincobrcomis
	 */
	public void setVmincobrcomis(String vmincobrcomis) {
		this.vmincobrcomis = vmincobrcomis;
	}


	/**
	 * @return o valor do ptxcustototal
	 */
	public String getPtxcustototal() {
		return ptxcustototal;
	}


	/**
	 * @param ptxcustototal seta o novo valor para o campo ptxcustototal
	 */
	public void setPtxcustototal(String ptxcustototal) {
		this.ptxcustototal = ptxcustototal;
	}


	/**
	 * @return o valor do vtxspreadnegoc
	 */
	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}


	/**
	 * @param vtxspreadnegoc seta o novo valor para o campo vtxspreadnegoc
	 */
	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}


	/**
	 * @return o valor do ptxflatpnalt
	 */
	public String getPtxflatpnalt() {
		return ptxflatpnalt;
	}


	/**
	 * @param ptxflatpnalt seta o novo valor para o campo ptxflatpnalt
	 */
	public void setPtxflatpnalt(String ptxflatpnalt) {
		this.ptxflatpnalt = ptxflatpnalt;
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


	/**
	 * @return o valor do vprevtcomiscmbio
	 */
	public String getVprevtcomiscmbio() {
		return vprevtcomiscmbio;
	}


	/**
	 * @param vprevtcomiscmbio seta o novo valor para o campo vprevtcomiscmbio
	 */
	public void setVprevtcomiscmbio(String vprevtcomiscmbio) {
		this.vprevtcomiscmbio = vprevtcomiscmbio;
	}


	/**
	 * @return o valor do taxaComissao
	 */
	public String getTaxaComissao() {
		return taxaComissao;
	}


	/**
	 * @param taxaComissao seta o novo valor para o campo taxaComissao
	 */
	public void setTaxaComissao(String taxaComissao) {
		this.taxaComissao = taxaComissao;
	}


	/**
	 * @return o valor do periodoComissao
	 */
	public String getPeriodoComissao() {
		return periodoComissao;
	}


	/**
	 * @param periodoComissao seta o novo valor para o campo periodoComissao
	 */
	public void setPeriodoComissao(String periodoComissao) {
		this.periodoComissao = periodoComissao;
	}


	/**
	 * @return o valor do cfluxoperdccmbio
	 */
	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}


	/**
	 * @param cfluxoperdccmbio seta o novo valor para o campo cfluxoperdccmbio
	 */
	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}


	/**
	 * @return o valor do periodicidadeComissao
	 */
	public String getPeriodicidadeComissao() {
		return periodicidadeComissao;
	}


	/**
	 * @param periodicidadeComissao seta o novo valor para o campo periodicidadeComissao
	 */
	public void setPeriodicidadeComissao(String periodicidadeComissao) {
		this.periodicidadeComissao = periodicidadeComissao;
	}


	/**
	 * @return o valor do codMomentoComissao
	 */
	public Integer getCodMomentoComissao() {
		return codMomentoComissao;
	}


	/**
	 * @param codMomentoComissao seta o novo valor para o campo codMomentoComissao
	 */
	public void setCodMomentoComissao(Integer codMomentoComissao) {
		this.codMomentoComissao = codMomentoComissao;
	}


	/**
	 * @return o valor do momentoComissao
	 */
	public String getMomentoComissao() {
		return momentoComissao;
	}


	/**
	 * @param momentoComissao seta o novo valor para o campo momentoComissao
	 */
	public void setMomentoComissao(String momentoComissao) {
		this.momentoComissao = momentoComissao;
	}

	/**
	 * @return o valor do ccobrcomiscmbio
	 */
	public Integer getCcobrcomiscmbio() {
		return ccobrcomiscmbio;
	}


	/**
	 * @param ccobrcomiscmbio seta o novo valor para o campo ccobrcomiscmbio
	 */
	public void setCcobrcomiscmbio(Integer ccobrcomiscmbio) {
		this.ccobrcomiscmbio = ccobrcomiscmbio;
	}


	/**
	 * @return o valor do vlxcomiscmbio
	 */
	public String getVlxcomiscmbio() {
		return vlxcomiscmbio;
	}


	/**
	 * @param vlxcomiscmbio seta o novo valor para o campo vlxcomiscmbio
	 */
	public void setVlxcomiscmbio(String vlxcomiscmbio) {
		this.vlxcomiscmbio = vlxcomiscmbio;
	}

	/**
	 * @return o valor do cindcdeconmmoeda
	 */
	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}


	/**
	 * @param cindcdeconmmoeda seta o novo valor para o campo cindcdeconmmoeda
	 */
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}


	/**
	 * @return o valor do vlxoperaccmbio
	 */
	public String getVlxoperaccmbio() {
		return vlxoperaccmbio;
	}


	/**
	 * @param vlxoperaccmbio seta o novo valor para o campo vlxoperaccmbio
	 */
	public void setVlxoperaccmbio(String vlxoperaccmbio) {
		this.vlxoperaccmbio = vlxoperaccmbio;
	}


	/**
	 * @return o valor do przoperaccmbio
	 */
	public Integer getPrzoperaccmbio() {
		return przoperaccmbio;
	}


	/**
	 * @param przoperaccmbio seta o novo valor para o campo przoperaccmbio
	 */
	public void setPrzoperaccmbio(Integer przoperaccmbio) {
		this.przoperaccmbio = przoperaccmbio;
	}


	/**
	 * @return o valor do cindcdnegoccarta
	 */
	public String getCindcdnegoccarta() {
		return cindcdnegoccarta;
	}


	/**
	 * @param cindcdnegoccarta seta o novo valor para o campo cindcdnegoccarta
	 */
	public void setCindcdnegoccarta(String cindcdnegoccarta) {
		this.cindcdnegoccarta = cindcdnegoccarta;
	}


	/**
	 * @return o valor do cindcdnegocswap
	 */
	public String getCindcdnegocswap() {
		return cindcdnegocswap;
	}


	/**
	 * @param cindcdnegocswap seta o novo valor para o campo cindcdnegocswap
	 */
	public void setCindcdnegocswap(String cindcdnegocswap) {
		this.cindcdnegocswap = cindcdnegocswap;
	}


	/**
	 * @return o valor do vtravaliborcmbio
	 */
	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}


	/**
	 * @param vtravaliborcmbio seta o novo valor para o campo vtravaliborcmbio
	 */
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}


	/**
	 * @return o valor do ptxcustoexter
	 */
	public String getPtxcustoexter() {
		return ptxcustoexter;
	}


	/**
	 * @param ptxcustoexter seta o novo valor para o campo ptxcustoexter
	 */
	public void setPtxcustoexter(String ptxcustoexter) {
		this.ptxcustoexter = ptxcustoexter;
	}


	/**
	 * @return o valor do ptximpstrenda
	 */
	public String getPtximpstrenda() {
		return ptximpstrenda;
	}


	/**
	 * @param ptximpstrenda seta o novo valor para o campo ptximpstrenda
	 */
	public void setPtximpstrenda(String ptximpstrenda) {
		this.ptximpstrenda = ptximpstrenda;
	}


	/**
	 * @return o valor do przoperaclibor
	 */
	public Integer getPrzoperaclibor() {
		return przoperaclibor;
	}


	/**
	 * @param przoperaclibor seta o novo valor para o campo przoperaclibor
	 */
	public void setPrzoperaclibor(Integer przoperaclibor) {
		this.przoperaclibor = przoperaclibor;
	}


	/**
	 * @return o valor do dsccustototal
	 */
	public String getDsccustototal() {
		return dsccustototal;
	}


	/**
	 * @param dsccustototal seta o novo valor para o campo dsccustototal
	 */
	public void setDsccustototal(String dsccustototal) {
		this.dsccustototal = dsccustototal;
	}


	/**
	 * @return o valor do listaParcelasComissao
	 */
	public List<TrdFinNegParcelaVO> getListaParcelasComissao() {
		return listaParcelasComissao;
	}


	/**
	 * @param listaParcelasComissao seta o novo valor para o campo listaParcelasComissao
	 */
	public void setListaParcelasComissao(
			List<TrdFinNegParcelaVO> listaParcelasComissao) {
		this.listaParcelasComissao = listaParcelasComissao;
	}


	/**
	 * @return o valor do qpcelacmbiotrade
	 */
	public Integer getQpcelacmbiotrade() {
		return qpcelacmbiotrade;
	}


	/**
	 * @param qpcelacmbiotrade seta o novo valor para o campo qpcelacmbiotrade
	 */
	public void setQpcelacmbiotrade(Integer qpcelacmbiotrade) {
		this.qpcelacmbiotrade = qpcelacmbiotrade;
	}


	/**
	 * @return o valor do ccobrcomisintrn
	 */
	public Integer getCcobrcomisintrn() {
		return ccobrcomisintrn;
	}


	/**
	 * @param ccobrcomisintrn seta o novo valor para o campo ccobrcomisintrn
	 */
	public void setCcobrcomisintrn(Integer ccobrcomisintrn) {
		this.ccobrcomisintrn = ccobrcomisintrn;
	}


	/**
	 * @return o valor do ccondceconc
	 */
	public Integer getCcondceconc() {
		return ccondceconc;
	}


	/**
	 * @param ccondceconc seta o novo valor para o campo ccondceconc
	 */
	public void setCcondceconc(Integer ccondceconc) {
		this.ccondceconc = ccondceconc;
	}


	/**
	 * @return o valor do vnegocmoedaestrg
	 */
	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}


	/**
	 * @return o valor do tipoComissaoExt
	 */
	public String getTipoComissaoExt() {
		return tipoComissaoExt;
	}


	/**
	 * @param tipoComissaoExt seta o novo valor para o campo tipoComissaoExt
	 */
	public void setTipoComissaoExt(String tipoComissaoExt) {
		this.tipoComissaoExt = tipoComissaoExt;
	}


	/**
	 * @return o valor do periodoTaxa
	 */
	public String getPeriodoTaxa() {
		return periodoTaxa;
	}


	/**
	 * @param periodoTaxa seta o novo valor para o campo periodoTaxa
	 */
	public void setPeriodoTaxa(String periodoTaxa) {
		this.periodoTaxa = periodoTaxa;
	}


	/**
	 * @return o valor do moedaComissao
	 */
	public String getMoedaComissao() {
		return moedaComissao;
	}


	/**
	 * @param moedaComissao seta o novo valor para o campo moedaComissao
	 */
	public void setMoedaComissao(String moedaComissao) {
		this.moedaComissao = moedaComissao;
	}


    /**
     * @return o valor do pcomisnegoccmbio
     */
    public String getPcomisnegoccmbio() {
        return pcomisnegoccmbio;
    }


    /**
     * @param pcomisnegoccmbio seta o novo valor para o campo pcomisnegoccmbio
     */
    public void setPcomisnegoccmbio(String pcomisnegoccmbio) {
        this.pcomisnegoccmbio = pcomisnegoccmbio;
    }


    /**
     * @return o valor do ncomisintrncmbio
     */
    public Integer getNcomisintrncmbio() {
        return ncomisintrncmbio;
    }


    /**
     * @param ncomisintrncmbio seta o novo valor para o campo ncomisintrncmbio
     */
    public void setNcomisintrncmbio(Integer ncomisintrncmbio) {
        this.ncomisintrncmbio = ncomisintrncmbio;
    }


    /**
     * @return o valor do fromList
     */
    public Boolean getFromList() {
        return fromList;
    }


    /**
     * @param fromList seta o novo valor para o campo fromList
     */
    public void setFromList(Boolean fromList) {
        this.fromList = fromList;
    }

    /**
     * @return o valor do ncomisextertrade
     */
    public Integer getNcomisextertrade() {
        return ncomisextertrade;
    }


    /**
     * @param ncomisextertrade seta o novo valor para o campo ncomisextertrade
     */
    public void setNcomisextertrade(Integer ncomisextertrade) {
        this.ncomisextertrade = ncomisextertrade;
    }


    /**
     * @return o valor do custoTotalForfaiting
     */
    public String getCustoTotalForfaiting() {
        return custoTotalForfaiting;
    }


    /**
     * @param custoTotalForfaiting seta o novo valor para o campo custoTotalForfaiting
     */
    public void setCustoTotalForfaiting(String custoTotalForfaiting) {
        this.custoTotalForfaiting = custoTotalForfaiting;
    }


    /**
     * @return o valor do tdiaopercmbio
     */
    public Integer getTdiaopercmbio() {
        return tdiaopercmbio;
    }


    /**
     * @param tdiaopercmbio seta o novo valor para o campo tdiaopercmbio
     */
    public void setTdiaopercmbio(Integer tdiaopercmbio) {
        this.tdiaopercmbio = tdiaopercmbio;
    }


    /**
     * @return o valor do cpais
     */
    public Integer getCpais() {
        return cpais;
    }


    /**
     * @param cpais seta o novo valor para o campo cpais
     */
    public void setCpais(Integer cpais) {
        this.cpais = cpais;
    }

    /**
     * @return o valor do cprodtservc
     */
    public Integer getCprodtservc() {
        return cprodtservc;
    }


    /**
     * @param cprodtservc seta o novo valor para o campo cprodtservc
     */
    public void setCprodtservc(Integer cprodtservc) {
        this.cprodtservc = cprodtservc;
    }


    /**
     * @return o valor do vlimcobervar
     */
    public String getVlimcobervar() {
        return vlimcobervar;
    }


    /**
     * @param vlimcobervar seta o novo valor para o campo vlimcobervar
     */
    public void setVlimcobervar(String vlimcobervar) {
        this.vlimcobervar = vlimcobervar;
    }


    /**
     * @return the ccomiscartanacio
     */
    public String getCcomiscartanacio() {
        return ccomiscartanacio;
    }


    /**
     * @param ccomiscartanacio the ccomiscartanacio to set
     */
    public void setCcomiscartanacio(String ccomiscartanacio) {
        this.ccomiscartanacio = ccomiscartanacio;
    }


    /**
     * @return o valor do tipoComissao
     */
    public EnumTipoComissao getTipoComissao() {
        if(!SiteUtil.isEmptyOrNull(this.crespcomisexter))
            this.tipoComissao = EnumTipoComissao.fromCode(this.crespcomisexter);
        return tipoComissao;
    }


    /**
     * @param tipoComissao seta o novo valor para o campo tipoComissao
     */
    public void setTipoComissao(EnumTipoComissao tipoComissao) {
        if(tipoComissao != null)
            this.crespcomisexter = tipoComissao.getCodigo();
        this.tipoComissao = tipoComissao;
    }


    /**
     * @return o valor do crespcomisexter
     */
    public Integer getCrespcomisexter() {
        return crespcomisexter;
    }


    /**
     * @param crespcomisexter seta o novo valor para o campo crespcomisexter
     */
    public void setCrespcomisexter(Integer crespcomisexter) {
        this.crespcomisexter = crespcomisexter;
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
     * @return o valor do funcao
     */
    public String getFuncao() {
        return funcao;
    }


    /**
     * @param funcao seta o novo valor para o campo funcao
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return o valor do dprevtdsembcmbio
     */
    public String getDprevtdsembcmbio() {
        return dprevtdsembcmbio;
    }

    /**
     * @param dprevtdsembcmbio seta o novo valor para o campo dprevtdsembcmbio
     */
    public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
        this.dprevtdsembcmbio = dprevtdsembcmbio;
    }
    
}
