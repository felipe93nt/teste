package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean.ListaHistoricoTarifaVO;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumAcaoProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumAcaoSituacao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;



public class TradeFinanceListaVO {
	
	/**
	 * CODIGO STATUS BOLETO
	 */
	private Integer csitbletocmbio = 0;

	/**
	 * DESCRICAO PRORROGACAO
	 */
	private String caditvbletocmbiostr = null;
	
	/**
	 * DESCRICAO STATUS BOLETO
	 */
	private String dsitbletocmbio = null;

	/**
	 * CODIGO STATUS APROVACAO BOLETO
	 */ 
	private Integer csitbletoaprov = 0;

	/**
	 * DATA DA COTACAO
	 */
	private String dtcotacao = null;

	/**
	 * CODIGO OPERADOR
	 */
	private String cusuarinclt = null;

	/**
	 * NOME DO OPERADOR
	 */
	private String nusuarinclt = null;

	/**
	 * NUMERO BOLETO (NUMERO COTACAO)
	 */
	private Long nbletonegoccmbio = 0L;
	
	/**
	 * NUMERO BOLETO + ANO (NUMERO COTACAO)
	 */
	private Long nbletocmbioano = 0L;
	
	/**
	 * CODIGO UNICO CLIENTE
	 */
	private Long cunicclicmbio = 0L;

	/**
	 * NOME DO CLIENTE
	 */
	private String ncunicclicmbio = null;
	
	/**
	 * CPF/CNPJ CLIENTE
	 */
	private Integer cpfcnpj =  null;

	/**
	 * 	FILIAL CPF CNPJ
	 */
	private Integer cfilial =  null;
	
	/**
	 * CONTROLE CPF/CNPJ
	 */
	private Integer cctrl =  null;
	
	/**
	 * CODIGO DO SEGMENTO
	 */
	private Integer ctposgmtocli = 0;

	/**
	 * DESCRICAO DO TIPO DE SEGMENTO
	 */
	private String dtposgmtocli = null;

	/**
	 * CODIGO DA UNIDADE DE NEGOCIO
	 */
	private Integer nsequndorgnz = 0;

	/**
	 * NOME DA UNIDADE DE NEGOCIO
	 */
	private String nomeundorgnz = null;

	/**
	 * CODIGO DA AGENCIA COMERCIAL
	 */
	private Integer agcmrcl = 0;

	/**
	 * CODIGO DO PRODUTO
	 */
	private Integer cprodtservc = 0;

	/**
	 * DESCRICAO DO PRODUTO
	 */
	private String dprodtservc = null;

	/**
	 * CODIGO DA MOEDA
	 */
	private Integer cindcdeconmmoeda = 0;

	/**
	 * SIMBOLO DA MOEDA
	 */
	private String simbleconmmoeda = null;

	/**
	 * VALOR DA MOEDA ESTRANGEIRA
	 */
	private String vlrmoedaestrang = null;
	
	/**
	 * VALOR EQUIVALENTE AO DOLAR
	 */
	private String vlreqvlntedolar = null;

	/**
	 * INDICADOR NEGOCIACAO CMBIO SWAT
	 */
	private String cindcdnegocswap = null;
	
	/**
	 * PRAZO DIAS
	 */
	private Integer tdiaopercmbio = 0;

	/**
	 * PRAZO MEDIA DIAS
	 */
	private Integer qprzmedcmbio = 0;

	/**
	 * NUMERO DE APROVACAO DE CREDITO
	 */
	private Long nseqcontrlim = 0L;

	/**
	 * TAXA SPREAD CREDITO APROVADO
	 */
	private String vtxspreadaprov = null;

	/**
	 * CUSTO
	 */
	private String custo = null;

	/**
	 * TAXA SPREAD NEGOCIADA
	 */
	private String vtxspreadnegoc = null;

	/**
	 * TAXA SWAP COMPARTILHADA
	 */
	private String ptxswapcmpdo = null;

	/**
	 * SPREAD EM DOLAR 	
	 */
	private String spreaddolar = null;

	/**
	 * CODIGO UNIDADE EXTERNA
	 */
	private Long cbcoextcmbio = 0L;

	/**
	 * NOME DA UNIDADE EXTERNA
	 */
	private String dbcoextcmbio = null;

	/**
	 * DATA DE FECHAMENTO DO BOLETO
	 */
	private String dfchtobletocmbio = null;

	/**
	 * PRORROGACAO BOLETO (SIM/NAO)
	 */
	private Integer caditvbletocmbio = 0;

	/**
	 * CODIGO DO PAIS
	 */
	private Integer cpais = 0;

	/**
	 * NOME DO PAIS
	 */
	private String dpais = null;

	/**
	 * CODIGO DO PAIS DE EMBARQUE
	 */
	private Integer cpaisembrq = 0;

	/**
	 * NOME PAIS DE EMBARQUE
	 */
	private String dpaisembrq = null;
	
	
	private String divergente;
	
	private String dtfechamento;
			      
	private Integer ctponegoccmbio;
	
	private String statusAprovacao;
	
	private Long cpssoa;
	
	private String nmbnefc;
	
	private String cpfCnpjFormatado;

	/**
	 * CODIGO DA MODALIDADE
	 */
	private Integer cmodldprodtcmbio;
	
	/**
	 * DESCRICAO DA MODALIDADE
	 */
    private String cmodldprodtdesc;
	
    /** Variável do tipo EnumAcaoProduto */
    private EnumAcaoProduto enumAcaoProduto;
    
    /** Variável do tipo EnumAcaoSituacao */
    private EnumAcaoSituacao enumAcaoSituacao;

   
    /** HORARIO INCLUSAO HISTORICO **/  
    private String horario = null;

    /** CODIGO DA AGENCIA **/  
    private Integer cagbcria = 0;

    /** CONTA BANCARIA **/  
    private Long cctabcriacmbio = 0L;

    /** DIGITO DA CONTA **/  
    private String digtcctabcria = null;

    /** TIPO DE PESSOA **/  
    private String tppessoa = null;

    /** FILIAL (CNPJ)    **/  
    private Integer cflial = 0;

    /** CODIGO RATING    **/  
    private String crting = null;

    /** VALOR DA MOEDA ESTRANGEIRA **/  
    private String vnegocmoedaestrg = null;

    /** FUNCAO DA OPERACAO **/
    private String cindcdtpomanut = null;

    /** DESCRICAO DA FUNCAO **/
    private String funcao = null;
    
    /** HORA DA INCLUSAO DO HISTORICO **/
    private String hinclreghist = null;
    
    /** HORA DA INCLUSAO DO HISTORICO - ANTES **/
    private String hinclanthist = null;
    
    /** LISTAR HISTORICO DE TARIFAS **/
    private List<ListaHistoricoTarifaVO> historicoTarifaList = new ArrayList<ListaHistoricoTarifaVO>();

    /** DESCRICAO DA MODALIDADE **/
    private String dmodldprodtcmbio = null;
    
    private Integer cmodcontrcmbio = 0;


    /* Campos específicos usados na tela "Agenda de Operações com SWAP" */
    
    /** DATA VENCIMENTO SWAP **/
    private String dvctopcelatrade = null;
    
    /** DATA PTAX (D-1/ D-2) **/
    private Integer ctpocotactx = 0;
        
    /** Descrição da PTAX **/
    private String descricaoPtax = null;

    /** VALOR PRINCIPAL (USD) **/
    private String vpcelaprnctrade = null;

    /** VALOR DOS JUROS (USD) **/
    private String vpcelajurotrade = null;
    
    /** NOME ROF **/
    private String nomerof = null;

    /** STATUS SWAP (1 - EM SER / 2 - BAIXADO) **/
    private String cindcdliqdcswap = null;
    
    /** Descrição do Status SWAP **/
    private String descricaoStatusSwap;
    
    /** NUMERO DESEMBOLSO PRINCIPAL **/
    private Integer ndsembcmbiop = 0;
    
    /** NUMERO DA PARCELA PRINCIPAL **/
    private Integer npceladsembp = 0;
    
    /** NUMERO DESEMBOLSO JUROS  **/
    private Integer ndsembcmbioj = 0;
    
    /** NUMERO DA PARCELA JUROS **/
    private Integer npceladsembj = 0;  
    
    /* Fim - campos da tela "Agenda de Operações com SWAP" */
    
    /**
     * @return o valor do cagbcria
     */
    public Integer getCagbcria() {
        return cagbcria;
    }

    /**
     * @param cagbcria seta o novo valor para o campo cagbcria
     */
    public void setCagbcria(Integer cagbcria) {
        this.cagbcria = cagbcria;
    }

    /**
     * @return o valor do cctabcriacmbio
     */
    public Long getCctabcriacmbio() {
        return cctabcriacmbio;
    }

    /**
     * @param cctabcriacmbio seta o novo valor para o campo cctabcriacmbio
     */
    public void setCctabcriacmbio(Long cctabcriacmbio) {
        this.cctabcriacmbio = cctabcriacmbio;
    }

    /**
     * @return o valor do digtcctabcria
     */
    public String getDigtcctabcria() {
        return digtcctabcria;
    }

    /**
     * @param digtcctabcria seta o novo valor para o campo digtcctabcria
     */
    public void setDigtcctabcria(String digtcctabcria) {
        this.digtcctabcria = digtcctabcria;
    }

    /**
     * @return o valor do tppessoa
     */
    public String getTppessoa() {
        return tppessoa;
    }

    /**
     * @param tppessoa seta o novo valor para o campo tppessoa
     */
    public void setTppessoa(String tppessoa) {
        this.tppessoa = tppessoa;
    }

    /**
     * @return o valor do cflial
     */
    public Integer getCflial() {
        return cflial;
    }

    /**
     * @param cflial seta o novo valor para o campo cflial
     */
    public void setCflial(Integer cflial) {
        this.cflial = cflial;
    }

    /**
     * @return o valor do crting
     */
    public String getCrting() {
        return crting;
    }

    /**
     * @param crting seta o novo valor para o campo crting
     */
    public void setCrting(String crting) {
        this.crting = crting;
    }

    /**
     * @return o valor do vnegocmoedaestrg
     */
    public String getVnegocmoedaestrg() {
        return vnegocmoedaestrg;
    }

    /**
     * @param vnegocmoedaestrg seta o novo valor para o campo vnegocmoedaestrg
     */
    public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
        this.vnegocmoedaestrg = vnegocmoedaestrg;
    }

    /**
	 * @return o valor do enumAcaoProduto
	 */
	public EnumAcaoProduto getEnumAcaoProduto() {
		return enumAcaoProduto;
	}

	/**
	 * @param enumAcaoProduto seta o novo valor para o campo enumAcaoProduto
	 */
	public void setEnumAcaoProduto(EnumAcaoProduto enumAcaoProduto) {
		this.enumAcaoProduto = enumAcaoProduto;
	}

	/**
	 * @return o valor do enumAcaoSituacao
	 */
	public EnumAcaoSituacao getEnumAcaoSituacao() {
		return enumAcaoSituacao;
	}

	/**
	 * @param enumAcaoSituacao seta o novo valor para o campo enumAcaoSituacao
	 */
	public void setEnumAcaoSituacao(EnumAcaoSituacao enumAcaoSituacao) {
		this.enumAcaoSituacao = enumAcaoSituacao;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}

	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public String getDsitbletocmbio() {
		return dsitbletocmbio;
	}

	public void setDsitbletocmbio(String dsitbletocmbio) {
		this.dsitbletocmbio = dsitbletocmbio;
	}

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}

	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}

	public String getDtcotacao() {
		return dtcotacao;
	}

	public void setDtcotacao(String dtcotacao) {
		this.dtcotacao = dtcotacao;
	}

	public String getCusuarinclt() {
		return cusuarinclt;
	}

	public void setCusuarinclt(String cusuarinclt) {
		this.cusuarinclt = cusuarinclt;
	}

	public String getNusuarinclt() {
		return nusuarinclt;
	}

	public void setNusuarinclt(String nusuarinclt) {
		this.nusuarinclt = nusuarinclt;
	}

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}

	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Long getNbletocmbioano() {
		return nbletocmbioano;
	}

	public void setNbletocmbioano(Long nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}

	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public String getNcunicclicmbio() {
		return ncunicclicmbio;
	}

	public void setNcunicclicmbio(String ncunicclicmbio) {
		this.ncunicclicmbio = ncunicclicmbio;
	}

	public Integer getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(Integer cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public Integer getCfilial() {
		return cfilial;
	}

	public void setCfilial(Integer cfilial) {
		this.cfilial = cfilial;
	}

	public Integer getCctrl() {
		return cctrl;
	}

	public void setCctrl(Integer cctrl) {
		this.cctrl = cctrl;
	}

	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}

	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
	}

	public String getDtposgmtocli() {
		return dtposgmtocli;
	}

	public void setDtposgmtocli(String dtposgmtocli) {
		this.dtposgmtocli = dtposgmtocli;
	}

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}

	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public String getNomeundorgnz() {
		return nomeundorgnz;
	}

	public void setNomeundorgnz(String nomeundorgnz) {
		this.nomeundorgnz = nomeundorgnz;
	}

	public Integer getAgcmrcl() {
		return agcmrcl;
	}

	public void setAgcmrcl(Integer agcmrcl) {
		this.agcmrcl = agcmrcl;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}

	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getDprodtservc() {
		return dprodtservc;
	}

	public void setDprodtservc(String dprodtservc) {
		this.dprodtservc = dprodtservc;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getSimbleconmmoeda() {
		return simbleconmmoeda;
	}

	public void setSimbleconmmoeda(String simbleconmmoeda) {
		this.simbleconmmoeda = simbleconmmoeda;
	}

	public String getVlrmoedaestrang() {
		return vlrmoedaestrang;
	}

	public void setVlrmoedaestrang(String vlrmoedaestrang) {
		this.vlrmoedaestrang = vlrmoedaestrang;
	}

	public String getVlreqvlntedolar() {
		return vlreqvlntedolar;
	}

	public void setVlreqvlntedolar(String vlreqvlntedolar) {
		this.vlreqvlntedolar = vlreqvlntedolar;
	}

	public String getCindcdnegocswap() {
		return cindcdnegocswap;
	}

	public void setCindcdnegocswap(String cindcdnegocswap) {
		this.cindcdnegocswap = cindcdnegocswap;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}

	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public Integer getQprzmedcmbio() {
		return qprzmedcmbio;
	}

	public void setQprzmedcmbio(Integer qprzmedcmbio) {
		this.qprzmedcmbio = qprzmedcmbio;
	}

	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}

	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}

	public String getVtxspreadaprov() {
		return vtxspreadaprov;
	}

	public void setVtxspreadaprov(String vtxspreadaprov) {
		this.vtxspreadaprov = vtxspreadaprov;
	}

	public String getCusto() {
		return custo;
	}

	public void setCusto(String custo) {
		this.custo = custo;
	}

	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}

	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}

	public String getPtxswapcmpdo() {
		return ptxswapcmpdo;
	}

	public void setPtxswapcmpdo(String ptxswapcmpdo) {
		this.ptxswapcmpdo = ptxswapcmpdo;
	}

	public String getSpreaddolar() {
		return spreaddolar;
	}

	public void setSpreaddolar(String spreaddolar) {
		this.spreaddolar = spreaddolar;
	}

	public Long getCbcoextcmbio() {
		return cbcoextcmbio;
	}

	public void setCbcoextcmbio(Long cbcoextcmbio) {
		this.cbcoextcmbio = cbcoextcmbio;
	}

	public String getDbcoextcmbio() {
		return dbcoextcmbio;
	}

	public void setDbcoextcmbio(String dbcoextcmbio) {
		this.dbcoextcmbio = dbcoextcmbio;
	}

	public String getDfchtobletocmbio() {
		return dfchtobletocmbio;
	}

	public void setDfchtobletocmbio(String dfchtobletocmbio) {
		this.dfchtobletocmbio = dfchtobletocmbio;
	}

	public Integer getCaditvbletocmbio() {
		return caditvbletocmbio;
	}

	public void setCaditvbletocmbio(Integer caditvbletocmbio) {
		this.caditvbletocmbio = caditvbletocmbio;
	}

	public Integer getCpais() {
		return cpais;
	}

	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getDpais() {
		return dpais;
	}

	public void setDpais(String dpais) {
		this.dpais = dpais;
	}

	public Integer getCpaisembrq() {
		return cpaisembrq;
	}

	public void setCpaisembrq(Integer cpaisembrq) {
		this.cpaisembrq = cpaisembrq;
	}

	public String getDpaisembrq() {
		return dpaisembrq;
	}

	public void setDpaisembrq(String dpaisembrq) {
		this.dpaisembrq = dpaisembrq;
	}

	public String getDivergente() {
		return divergente;
	}

	public void setDivergente(String divergente) {
		this.divergente = divergente;
	}

	public String getDtfechamento() {
		return dtfechamento;
	}

	public void setDtfechamento(String dtfechamento) {
		this.dtfechamento = dtfechamento;
	}

	public Integer getCtponegoccmbio() {
		return ctponegoccmbio;
	}

	public void setCtponegoccmbio(Integer ctponegoccmbio) {
		this.ctponegoccmbio = ctponegoccmbio;
	}

	public String getStatusAprovacao() {
		return statusAprovacao;
	}

	public void setStatusAprovacao(String statusAprovacao) {
		this.statusAprovacao = statusAprovacao;
	}

	public Long getCpssoa() {
		return cpssoa;
	}

	public void setCpssoa(Long cpssoa) {
		this.cpssoa = cpssoa;
	}

	public String getNmbnefc() {
		return nmbnefc;
	}

	public void setNmbnefc(String nmbnefc) {
		this.nmbnefc = nmbnefc;
	}

	public String getCpfCnpjFormatado() {
		return cpfCnpjFormatado;
	}

	public void setCpfCnpjFormatado(String cpfCnpjFormatado) {
		this.cpfCnpjFormatado = cpfCnpjFormatado;
	}

	public Integer getCmodldprodtcmbio() {
		return cmodldprodtcmbio;
	}

	public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
		this.cmodldprodtcmbio = cmodldprodtcmbio;
	}

	public String getCmodldprodtdesc() {
		return cmodldprodtdesc;
	}

	public void setCmodldprodtdesc(String cmodldprodtdesc) {
		this.cmodldprodtdesc = cmodldprodtdesc;
	}
	
	public EnumProduto getProduto() {
	    return EnumProduto.fromCode(this.cprodtservc);
	}

    /**
     * @return o valor do horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario seta o novo valor para o campo horario
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return o valor do cindcdtpomanut
     */
    public String getCindcdtpomanut() {
        return cindcdtpomanut;
    }

    /**
     * @param cindcdtpomanut seta o novo valor para o campo cindcdtpomanut
     */
    public void setCindcdtpomanut(String cindcdtpomanut) {
        this.cindcdtpomanut = cindcdtpomanut;
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
     * @return o valor do historicoTarifaList
     */
    public List<ListaHistoricoTarifaVO> getHistoricoTarifaList() {
        return historicoTarifaList;
    }

    /**
     * @param historicoTarifaList seta o novo valor para o campo historicoTarifaList
     */
    public void setHistoricoTarifaList(List<ListaHistoricoTarifaVO> historicoTarifaList) {
        this.historicoTarifaList = historicoTarifaList;
    }

    /**
     * @return o valor do hinclreghist
     */
    public String getHinclreghist() {
        return hinclreghist;
    }

    /**
     * @param hinclreghist seta o novo valor para o campo hinclreghist
     */
    public void setHinclreghist(String hinclreghist) {
        this.hinclreghist = hinclreghist;
    }

	/**
	 * @return o valor do caditvbletocmbiostr
	 */
	public String getCaditvbletocmbiostr() {
		return caditvbletocmbiostr;
	}

	/**
	 * @param caditvbletocmbiostr seta o novo valor para o campo caditvbletocmbiostr
	 */
	public void setCaditvbletocmbiostr(String caditvbletocmbiostr) {
		this.caditvbletocmbiostr = caditvbletocmbiostr;
	}

    /**
     * @return o valor do dmodldprodtcmbio
     */
    public String getDmodldprodtcmbio() {
        return dmodldprodtcmbio;
    }

    /**
     * @param dmodldprodtcmbio seta o novo valor para o campo dmodldprodtcmbio
     */
    public void setDmodldprodtcmbio(String dmodldprodtcmbio) {
        this.dmodldprodtcmbio = dmodldprodtcmbio;
    }

    /**
     * @return o valor do cmodcontrcmbio
     */
    public Integer getCmodcontrcmbio() {
        return cmodcontrcmbio;
    }

    /**
     * @param cmodcontrcmbio seta o novo valor para o campo cmodcontrcmbio
     */
    public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
        this.cmodcontrcmbio = cmodcontrcmbio;
    }

    /**
     * @return o valor do dvctopcelatrade
     */
    public String getDvctopcelatrade() {
        return dvctopcelatrade;
    }

    /**
     * @param dvctopcelatrade seta o novo valor para o campo dvctopcelatrade
     */
    public void setDvctopcelatrade(String dvctopcelatrade) {
        this.dvctopcelatrade = dvctopcelatrade;
    }

    /**
     * @return o valor do ctpocotactx
     */
    public Integer getCtpocotactx() {
        return ctpocotactx;
    }

    /**
     * @return o valor do descricaoPtax
     */
    public String getDescricaoPtax() {
        return descricaoPtax;
    }

    /**
     * @param descricaoPtax seta o novo valor para o campo descricaoPtax
     */
    public void setDescricaoPtax(String descricaoPtax) {
        this.descricaoPtax = descricaoPtax;
    }

    /**
     * @param ctpocotactx seta o novo valor para o campo ctpocotactx
     */
    public void setCtpocotactx(Integer ctpocotactx) {
        this.ctpocotactx = ctpocotactx;
    }

    /**
     * @return o valor do vpcelaprnctrade
     */
    public String getVpcelaprnctrade() {
        return vpcelaprnctrade;
    }

    /**
     * @param vpcelaprnctrade seta o novo valor para o campo vpcelaprnctrade
     */
    public void setVpcelaprnctrade(String vpcelaprnctrade) {
        this.vpcelaprnctrade = vpcelaprnctrade;
    }

    /**
     * @return o valor do vpcelajurotrade
     */
    public String getVpcelajurotrade() {
        return vpcelajurotrade;
    }

    /**
     * @param vpcelajurotrade seta o novo valor para o campo vpcelajurotrade
     */
    public void setVpcelajurotrade(String vpcelajurotrade) {
        this.vpcelajurotrade = vpcelajurotrade;
    }

    /**
     * @return o valor do nomerof
     */
    public String getNomerof() {
        return nomerof;
    }

    /**
     * @param nomerof seta o novo valor para o campo nomerof
     */
    public void setNomerof(String nomerof) {
        this.nomerof = nomerof;
    }

    /**
     * @return o valor do cindcdliqdcswap
     */
    public String getCindcdliqdcswap() {
        return cindcdliqdcswap;
    }

    /**
     * @param cindcdliqdcswap seta o novo valor para o campo cindcdliqdcswap
     */
    public void setCindcdliqdcswap(String cindcdliqdcswap) {
        this.cindcdliqdcswap = cindcdliqdcswap;
    }

    /**
     * @return o valor do descricaoStatusSwap
     */
    public String getDescricaoStatusSwap() {
        return descricaoStatusSwap;
    }

    /**
     * @param descricaoStatusSwap seta o novo valor para o campo descricaoStatusSwap
     */
    public void setDescricaoStatusSwap(String descricaoStatusSwap) {
        this.descricaoStatusSwap = descricaoStatusSwap;
    }

    /**
     * @return o valor do ndsembcmbiop
     */
    public Integer getNdsembcmbiop() {
        return ndsembcmbiop;
    }

    /**
     * @param ndsembcmbiop seta o novo valor para o campo ndsembcmbiop
     */
    public void setNdsembcmbiop(Integer ndsembcmbiop) {
        this.ndsembcmbiop = ndsembcmbiop;
    }

    /**
     * @return o valor do npceladsembp
     */
    public Integer getNpceladsembp() {
        return npceladsembp;
    }

    /**
     * @param npceladsembp seta o novo valor para o campo npceladsembp
     */
    public void setNpceladsembp(Integer npceladsembp) {
        this.npceladsembp = npceladsembp;
    }

    /**
     * @return o valor do ndsembcmbioj
     */
    public Integer getNdsembcmbioj() {
        return ndsembcmbioj;
    }

    /**
     * @param ndsembcmbioj seta o novo valor para o campo ndsembcmbioj
     */
    public void setNdsembcmbioj(Integer ndsembcmbioj) {
        this.ndsembcmbioj = ndsembcmbioj;
    }

    /**
     * @return o valor do npceladsembj
     */
    public Integer getNpceladsembj() {
        return npceladsembj;
    }

    /**
     * @param npceladsembj seta o novo valor para o campo npceladsembj
     */
    public void setNpceladsembj(Integer npceladsembj) {
        this.npceladsembj = npceladsembj;
    }

	public String getHinclanthist() {
		return hinclanthist;
	}

	public void setHinclanthist(String hinclanthist) {
		this.hinclanthist = hinclanthist;
	}

}
