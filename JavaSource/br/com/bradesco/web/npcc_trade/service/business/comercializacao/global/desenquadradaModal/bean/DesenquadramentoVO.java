/**
 * Nome: br.com.bradesco.web.npcc_garantias.service.business.global.limitesModal.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 12/05/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;

/**
 * Nome: DesenquadradasVO.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ - Francinaldo Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 12/05/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class DesenquadramentoVO {

    /** NPCCWM4S-IND-DQMTO PIC X(001). - INDICADOR DE DESENQUADRAMENTO */
    private String inddqmto = null;

    /** 10 NPCCWM4E-CIDTFD-MESA-CMBIO PIC 9(001). - INDICADOR DE MESA CAMBIO */
    private Integer cidtfdmesacmbio = null;

    /** 10 NPCCWM4E-NSEQ-CONTR-LIM PIC 9(017). - SEQUENCIAL DE CONTROLE CLIM */
    private Long nseqcontrlim = null;

    /** 10 NPCCWM4E-NPPSTA-PONTU-CMBIO PIC 9(010). - NUMERO PROPOSTA PONTUAL NPCA */
    private Long nppstapontucmbio = null;

    /** 10 NPCCWM4E-CUNIC-CLI-CMBIO PIC 9(010). - CODIGO UNICO CAMBIO */
    private Long cunicclicmbio = null;

    /** 10 NPCCWM4E-CINDCD-ECONM-MOEDA PIC 9(005). - INDICADOR DA MOEDA DO BOLETO */
    private Integer cindcdeconmmoeda = null;

    /** 10 NPCCWM4E-VNEGOC-MOEDA-ESTRG PIC 9(015)V9(02). - VALOR DO BOLETO */
    private String vnegocmoedaestrg = null;

    /** 10 NPCCWM4E-TDIA-OPER-CMBIO PIC 9(005). - PRAZO DO BOLETO */
    private Integer tdiaopercmbio = null;

    /** 10 NPCCWM4E-PSPREAD-TX-CMBIO PIC 9(003)V9(04). - SPREAD DO BOLETO */
    private String pspreadtxcmbio = null;
    
    /** SPREAD ALL-IN*/
    private String ptxswapcmpdo = null;

    /** 10 NPCCWM4E-PTX-PARIDADE PIC 9(006)V9(09). - TAXA PARIDADE */
    private String ptxparidade = null;
    
    /** CPRODT-SERVC        PIC 9(008). */
    private Integer cprodtservc = null;

    /** CINDCD-NEGOC-CARTA  PIC X(001). */
    private String cindcdnegoccarta = null;

    /** CINDCD-CARTA-IDPDT  PIC X(001). */
    private String cindcdcartaidpdt = null;

    /** DPREVT-EMBRQ        PIC X(010). */
    private String dprevtembrq = null;

    /** DPREVT-DSEMB-CMBIO  PIC X(010). */
    private String dprevtdsembcmbio = null;

    /** TDIA-VALDD-CARTA    PIC 9(005). */
    private Integer tdiavalddcarta = null;

    private String justificativa = null;
    
    private Integer ctponegoccmbio = 0;

    /* COD-MOEDA-OPER                     PIC  9(005). */
    private Integer Codmoedaoper = null;

    /* SIGLA-MOEDA-OPER                   PIC  X(010). */
    private String Siglamoedaoper = null;

    /* DESC-MOEDA-OPER                    PIC  X(040). */
    private String Descmoedaoper = null;

    /* COD-MOEDA-LIM                      PIC  9(005). */
    private Integer Codmoedalim = null;

    /* SIGLA-MOEDA-LIM                    PIC  X(010). */
    private String Siglamoedalim = null;

    /* DESC-MOEDA-LIM                     PIC  X(040). */
    private String Descmoedalim = null;
    
    /** Margem Agente **/
    private String pagtefincrcmbio = null;
    
    private String vlimcobervar = null;
    
    private String garangarant = null;
    
    private List<DesembolsoVO> desembolso;
    
    /**
     * SPREAD TOTAL
     */
    private String vtxspreadtot = null;
    
    private String cindcdnegocswap = null;

    /** VALOR FINANCIADO **/
    private String vprevtrectacmbio = null;

    /** LISTA DESENQUADRAMENTO DE CREDITOS */
    private List<DesenquadramentoCreditoVO> creditos = new ArrayList<DesenquadramentoCreditoVO>();
    
    /** LISTA DESENQUADRAMENTO DE PAGAMENTOS ANTECIPADOS */
    private List<DesenquadramentoPagamentoAntecipadoVO> pagamentosAntecipados = new ArrayList<DesenquadramentoPagamentoAntecipadoVO>();
    
    /** LISTA DESENQUADRAMENTO DE ANY BANK */
    private List<DesenquadramentoAnyBankVO> anyBank = new ArrayList<DesenquadramentoAnyBankVO>();
    
    /** LISTA DESENQUADRAMENTO DE STAND-BY */
    private List<DesenquadramentoStandByVO> standBy = new ArrayList<DesenquadramentoStandByVO>();
    
    private Boolean valoresAtualizados = Boolean.FALSE;
    
    /** Construtor */
    public DesenquadramentoVO() {
        super();
    }
    
    /**
     * Nome: DesenquadramentoVO
     * 
     * Propósito: Construtor para classe onde são armazenados os campos para tomada de decisão do desenquadramento
     *
     */
    public DesenquadramentoVO(TrdFinNegocInclVO tradeFinNegocVO, Date datePrevDesembolso) {
        super();
        
        this.cprodtservc = tradeFinNegocVO.getCprodtservc();
        this.cidtfdmesacmbio = Numeros.DOIS;
        this.cindcdcartaidpdt = !tradeFinNegocVO.getCindcdcartaidpdt().equals(SiteUtil.getString(Numeros.UM)) 
                ? SiteUtil.getString(Numeros.DOIS) 
                        : tradeFinNegocVO.getCindcdcartaidpdt();
        this.cindcdeconmmoeda = tradeFinNegocVO.getCindcdeconmmoeda();
        this.cunicclicmbio = tradeFinNegocVO.getCunicclicmbio();
        this.cindcdnegoccarta = tradeFinNegocVO.getCindcdnegoccarta();
        this.dprevtdsembcmbio = SiteUtil.dataWebToMainframe(datePrevDesembolso);
        this.nseqcontrlim = tradeFinNegocVO.getNseqcontrlim();
        this.nppstapontucmbio = tradeFinNegocVO.getNppstapontucmbio();
        this.ptxparidade = "0";
        this.pspreadtxcmbio = tradeFinNegocVO.getVtxspreadnegoc();
        this.ptxswapcmpdo = tradeFinNegocVO.getPtxswapcmpdo();
        this.tdiavalddcarta = tradeFinNegocVO.getTdiavalddletra();
        this.tdiaopercmbio = tradeFinNegocVO.getTdiaopercmbio();
        this.vnegocmoedaestrg = tradeFinNegocVO.getVnegocmoedaestrg();
        this.dprevtembrq = tratarDataPrevisaoEmbarque(tradeFinNegocVO, datePrevDesembolso);
        this.justificativa = null;
        this.valoresAtualizados = Boolean.FALSE;
        this.ctponegoccmbio = tradeFinNegocVO.getCtponegoccmbio();
        this.pagtefincrcmbio = tradeFinNegocVO.getPagtefincrcmbio();
        this.vlimcobervar = tradeFinNegocVO.getVlimcobervar();
        this.vtxspreadtot = tradeFinNegocVO.getVtxspreadtot();
        this.cindcdnegocswap = tradeFinNegocVO.getCindcdnegocswap();
        this.vprevtrectacmbio = tradeFinNegocVO.getVprevtrectacmbio();
        
        if (tradeFinNegocVO.getObsCotacaoVO() != null ) {
            this.garangarant = tradeFinNegocVO.getObsCotacaoVO().getGarangarant();
        }
    }
    
    /**
     * Nome: DesenquadramentoVO
     * 
     * Propósito: Construtor para classe onde são armazenados os campos para tomada de decisão do desenquadramento
     *
     */
    public DesenquadramentoVO(TradeFinanceVO tradeFinNegocVO) {
        super();
        
        this.cprodtservc = tradeFinNegocVO.getCprodtservc();
        this.cidtfdmesacmbio = Numeros.DOIS;
        this.cindcdcartaidpdt = !tradeFinNegocVO.getCindcdcartaidpdt().equals(SiteUtil.getString(Numeros.UM)) 
                ? SiteUtil.getString(Numeros.DOIS) 
                        : tradeFinNegocVO.getCindcdcartaidpdt();
        this.cindcdeconmmoeda = tradeFinNegocVO.getCindcdeconmmoeda();
        this.cunicclicmbio = tradeFinNegocVO.getCunicclicmbio();
        this.dprevtdsembcmbio = tradeFinNegocVO.getDprevtdsembcmbio();
        this.nseqcontrlim = tradeFinNegocVO.getNseqcontrlim();
        this.nppstapontucmbio = tradeFinNegocVO.getNppstapontucmbio();
        this.ptxparidade = "0";
        this.pspreadtxcmbio = tradeFinNegocVO.getVtxspreadnegoc();
        this.ptxswapcmpdo = tradeFinNegocVO.getPtxswapcmpdo();
        this.tdiavalddcarta = tradeFinNegocVO.getTdiavalddletra();
        this.tdiaopercmbio = tradeFinNegocVO.getTdiaopercmbio();
        this.vnegocmoedaestrg = tradeFinNegocVO.getVnegocmoedaestrg();
        this.dprevtembrq = tratarDataPrevisaoEmbarque(tradeFinNegocVO);
        this.valoresAtualizados = Boolean.FALSE;
        this.ctponegoccmbio = tradeFinNegocVO.getCtponegoccmbio();
        this.pagtefincrcmbio = tradeFinNegocVO.getPagtefincrcmbio();
        this.vlimcobervar = tradeFinNegocVO.getVlimcobervar();
        this.vtxspreadtot = tradeFinNegocVO.getVtxspreadtot();
        this.cindcdnegocswap = tradeFinNegocVO.getCindcdnegocswap();
        this.vprevtrectacmbio = tradeFinNegocVO.getVprevtrectacmbio();
        
        if (tradeFinNegocVO.getObsCotacaoVO() != null ) {
            this.garangarant = tradeFinNegocVO.getObsCotacaoVO().getGarangarant();
        }
        
        if (tradeFinNegocVO.getCprodtservc().
                equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
            this.cindcdnegoccarta = "N";
        } else {
            if(tradeFinNegocVO.getCindcdnegoccarta().toUpperCase().equals("SIM")
                    || tradeFinNegocVO.getCindcdnegoccarta().toUpperCase().equals("S")) {
                this.cindcdnegoccarta = "S";
            } else {
                this.cindcdnegoccarta = "N";
            }
        }
        List<DesembolsoVO> listDesembolso = new ArrayList<DesembolsoVO>();
        for (TradeFinanceDesembolsoVO listaDesembolso : tradeFinNegocVO.getListaDesembolso()) {
        	DesembolsoVO desemb = new DesembolsoVO(); 
        	desemb.setSpreadDesemb(SiteUtil.getDouble(listaDesembolso.getPspreadtxcmbio()));
        	listDesembolso.add(desemb);
		} 
		this.setDesembolso(listDesembolso);
    }
    
    /**
     * Nome: DesenquadramentoVO
     * 
     * Propósito: Atualiza os valores do objeto verificando se houve alteração nos valores.
     *            A verificação de alteração do valor do atributo esta no metodo acessor do atributo, isso para que caso haja uma alteração do valor fora da classe o controle já realizado corretamente.
     *
     */
    public void atualizaValores(TrdFinNegocInclVO tradeFinNegocVO, Date datePrevDesembolso, List<TradeFinanceDesembolsoVO> tradeFinanceDesembolsoVO) {
        
        setCprodtservc(tradeFinNegocVO.getCprodtservc());
        setCidtfdmesacmbio(Numeros.DOIS);
        setPtxparidade("0");
        
        if(tradeFinNegocVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            setCindcdcartaidpdt(tradeFinNegocVO.getCindcdcartaidpdt());
        }else {
            setCindcdcartaidpdt(SiteUtil.getString(Numeros.DOIS));
        }
        
        setTdiavalddcarta(tradeFinNegocVO.getTdiavalddletra());
        
        setCindcdeconmmoeda(tradeFinNegocVO.getCindcdeconmmoeda());
        setCunicclicmbio(tradeFinNegocVO.getCunicclicmbio());
        setCindcdnegoccarta(tradeFinNegocVO.getCindcdnegoccarta());
        setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(datePrevDesembolso));
        setNseqcontrlim(tradeFinNegocVO.getNseqcontrlim());
        setNppstapontucmbio(tradeFinNegocVO.getNppstapontucmbio());
        setPspreadtxcmbio(tradeFinNegocVO.getVtxspreadnegoc());
        setPtxswapcmpdo(tradeFinNegocVO.getPtxswapcmpdo());
        setTdiaopercmbio(tradeFinNegocVO.getTdiaopercmbio());
        setVnegocmoedaestrg(tradeFinNegocVO.getVnegocmoedaestrg());
        setDprevtembrq(tratarDataPrevisaoEmbarque(tradeFinNegocVO, datePrevDesembolso));
        setCtponegoccmbio(tradeFinNegocVO.getCtponegoccmbio());
        setPagtefincrcmbio(tradeFinNegocVO.getPagtefincrcmbio());
        setVlimcobervar(tradeFinNegocVO.getVlimcobervar());
        setVtxspreadtot(tradeFinNegocVO.getVtxspreadtot());
        setCindcdnegocswap(tradeFinNegocVO.getCindcdnegocswap());
        setVprevtrectacmbio(tradeFinNegocVO.getVprevtrectacmbio());
        
        if (tradeFinNegocVO.getObsCotacaoVO() != null ) {
            setGarangarant(tradeFinNegocVO.getObsCotacaoVO().getGarangarant());
        }
        
        List<DesembolsoVO> listaDesemb = new ArrayList<DesembolsoVO>();
        for (TradeFinanceDesembolsoVO itemDesembolso : tradeFinanceDesembolsoVO) {
        	DesembolsoVO desemb = new DesembolsoVO();
        	desemb.setSpreadDesemb(SiteUtil.getDouble(itemDesembolso.getPspreadtxcmbio()));
        	listaDesemb.add(desemb);
		}
        setDesembolso(listaDesemb);
    }
    
    /**
     * Nome: DesenquadramentoVO
     * 
     * Propósito: Atualiza os valores do objeto verificando se houve alteração nos valores.
     *            A verificação de alteração do valor do atributo esta no metodo acessor do atributo, isso para que caso haja uma alteração do valor fora da classe o controle já realizado corretamente.
     *
     */
    public void atualizaValores(TradeFinanceVO tradeFinanceVO) {
        
        setCprodtservc(tradeFinanceVO.getCprodtservc());
        setCidtfdmesacmbio(Numeros.DOIS);
        setPtxparidade("0");
        
        if(tradeFinanceVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            setCindcdcartaidpdt(tradeFinanceVO.getCindcdcartaidpdt());
        }else {
            setCindcdcartaidpdt(SiteUtil.getString(Numeros.DOIS));
        }
        setTdiavalddcarta(tradeFinanceVO.getTdiavalddletra());
        
        setCindcdeconmmoeda(tradeFinanceVO.getCindcdeconmmoeda());
        setCunicclicmbio(tradeFinanceVO.getCunicclicmbio());
        setDprevtdsembcmbio(tradeFinanceVO.getDprevtdsembcmbio());
        setNseqcontrlim(tradeFinanceVO.getNseqcontrlim());
        setNppstapontucmbio(tradeFinanceVO.getNppstapontucmbio());
        setPspreadtxcmbio(tradeFinanceVO.getVtxspreadnegoc());
        setPtxswapcmpdo(tradeFinanceVO.getPtxswapcmpdo());
        setTdiaopercmbio(tradeFinanceVO.getTdiaopercmbio());
        setVnegocmoedaestrg(tradeFinanceVO.getVnegocmoedaestrg());
        setCtponegoccmbio(tradeFinanceVO.getCtponegoccmbio());
        setDprevtembrq(tratarDataPrevisaoEmbarque(tradeFinanceVO));
        setPagtefincrcmbio(tradeFinanceVO.getPagtefincrcmbio());
        setVlimcobervar(tradeFinanceVO.getVlimcobervar());
        setVtxspreadtot(tradeFinanceVO.getVtxspreadtot());
        setCindcdnegocswap(tradeFinanceVO.getCindcdnegocswap());
        setVprevtrectacmbio(tradeFinanceVO.getVprevtrectacmbio());
        
        if (tradeFinanceVO.getObsCotacaoVO() != null ) {
            setGarangarant(tradeFinanceVO.getObsCotacaoVO().getGarangarant());
        }
        
        if (tradeFinanceVO.getCprodtservc().
                equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
            setCindcdnegoccarta("N");
        } else {
            if(tradeFinanceVO.getCindcdnegoccarta().toUpperCase().equals("SIM")
                    || tradeFinanceVO.getCindcdnegoccarta().toUpperCase().equals("S")) {
                setCindcdnegoccarta("S");
            } else {
                setCindcdnegoccarta("N");
            }
        }
        List<DesembolsoVO> listDesembolso = new ArrayList<DesembolsoVO>();
        for (TradeFinanceDesembolsoVO listaDesembolso : tradeFinanceVO.getListaDesembolso()) {
        	DesembolsoVO desemb = new DesembolsoVO(); 
        	desemb.setSpreadDesemb(SiteUtil.getDouble(listaDesembolso.getPspreadtxcmbio()));
        	listDesembolso.add(desemb);
		} 
		this.setDesembolso(listDesembolso);
    }
    
    /**
     * Nome: tratarDataPrevisaoEmbarque
     * 
     * Propósito: Trata campo previsão de embarque a partir do VO da tela de inclusão e alteração
     *
     */
    private String tratarDataPrevisaoEmbarque(TrdFinNegocInclVO tradeFinNegocVO, Date datePrevDesembolso) {
        
        String dprevtembrq = null;
        
        // Trata data de previsão de embarque para Finimp's
        if(tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)
                || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)
                || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)
                || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
            
            // Maior data de embarque, caso não tenha data de embarque usa a data do desembolso 
            Date dataPrevisaoEmbarque = null;
            
            if(tradeFinNegocVO.getListaMercadoria() != null 
                    && !tradeFinNegocVO.getListaMercadoria().isEmpty()) {
                
                for (TrdFinNegMercadoriaVO mercadoria : tradeFinNegocVO.getListaMercadoria()) {
                    if (mercadoria.getDprevtembrq() != null) {
                        if(dataPrevisaoEmbarque == null 
                                || (SiteUtil.comparaDatas(dataPrevisaoEmbarque, mercadoria.getDprevtembrq()) < 0)) {
                            dataPrevisaoEmbarque = mercadoria.getDprevtembrq();                           
                        }
                    }
                }
                
            }
            
            // Maior data de embarque, caso não tenha data de embarque usa a data do desembolso 
            dataPrevisaoEmbarque = dataPrevisaoEmbarque == null ? datePrevDesembolso : dataPrevisaoEmbarque;
            
            dprevtembrq = SiteUtil.dataWebToMainframe(dataPrevisaoEmbarque);
        }else{
            dprevtembrq = SiteUtil.dataWebToMainframe(datePrevDesembolso);
        }
        
        return dprevtembrq;
    }

    /**
     * Nome: tratarDataPrevisaoEmbarque
     * 
     * Propósito: Trata campo previsão de embarque a partir do VO da tela de consulta
     *
     */
    private String tratarDataPrevisaoEmbarque(TradeFinanceVO tradeFinanceVO) {
        
        String dprevtembrq = null;
        Date datePrevDesembolso = SiteUtil.dataMainframeToWeb(tradeFinanceVO.getDprevtdsembcmbio());
        
        // Trata data de previsão de embarque para Finimp's
        if(tradeFinanceVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)
                || tradeFinanceVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)
                || tradeFinanceVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)
                || tradeFinanceVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
            
            // Maior data de embarque, caso não tenha data de embarque usa a data do desembolso 
            Date dataPrevisaoEmbarque = null;
            
            if(tradeFinanceVO.getListaMercadoria() != null 
                    && !tradeFinanceVO.getListaMercadoria().isEmpty()) {
                
                for (MercadoriaVO mercadoria : tradeFinanceVO.getListaMercadoria()) {
                    if (mercadoria.getDprevtembrq() != null) {
                        if(dataPrevisaoEmbarque == null 
                                || (SiteUtil.comparaDatas(dataPrevisaoEmbarque, SiteUtil.dataMainframeToWeb(mercadoria.getDprevtembrq())) < 0)) {
                            dataPrevisaoEmbarque = SiteUtil.dataMainframeToWeb(mercadoria.getDprevtembrq());                            
                        }
                    }
                }
                
            }
            
            // Maior data de embarque, caso não tenha data de embarque usa a data do desembolso 
            dataPrevisaoEmbarque = dataPrevisaoEmbarque == null ? datePrevDesembolso : dataPrevisaoEmbarque;
            
            dprevtembrq = SiteUtil.dataWebToMainframe(dataPrevisaoEmbarque);
        }
        
        return dprevtembrq;
    }
    
    /**
     * @return o valor do creditos
     */
    public List<DesenquadramentoCreditoVO> getCreditos() {
        return creditos;
    }

    /**
     * @param creditos seta o novo valor para o campo creditos
     */
    public void setCreditos(List<DesenquadramentoCreditoVO> creditos) {
        this.creditos = creditos;
    }

    /**
     * @return o valor do pagamentosAntecipados
     */
    public List<DesenquadramentoPagamentoAntecipadoVO> getPagamentosAntecipados() {
        return pagamentosAntecipados;
    }

    /**
     * @param pagamentosAntecipados seta o novo valor para o campo pagamentosAntecipados
     */
    public void setPagamentosAntecipados(List<DesenquadramentoPagamentoAntecipadoVO> pagamentosAntecipados) {
        this.pagamentosAntecipados = pagamentosAntecipados;
    }

    /**
     * @return o valor do anyBank
     */
    public List<DesenquadramentoAnyBankVO> getAnyBank() {
        return anyBank;
    }

    /**
     * @param anyBank seta o novo valor para o campo anyBank
     */
    public void setAnyBank(List<DesenquadramentoAnyBankVO> anyBank) {
        this.anyBank = anyBank;
    }

    /**
     * @return o valor do standBy
     */
    public List<DesenquadramentoStandByVO> getStandBy() {
        return standBy;
    }

    /**
     * @param standBy seta o novo valor para o campo standBy
     */
    public void setStandBy(List<DesenquadramentoStandByVO> standBy) {
        this.standBy = standBy;
    }

    /**
     * @return o valor do inddqmto
     */
    public String getInddqmto() {
        return inddqmto;
    }

    /**
     * @param inddqmto seta o novo valor para o campo inddqmto
     */
    public void setInddqmto(String inddqmto) {
        this.inddqmto = inddqmto;
    }

    /**
     * @return o valor do cidtfdmesacmbio
     */
    public Integer getCidtfdmesacmbio() {
        return cidtfdmesacmbio;
    }

    /**
     * @param cidtfdmesacmbio seta o novo valor para o campo cidtfdmesacmbio
     */
    public void setCidtfdmesacmbio(Integer cidtfdmesacmbio) {
        this.cidtfdmesacmbio = cidtfdmesacmbio;
    }

    /**
     * @return o valor do nseqcontrlim
     */
    public Long getNseqcontrlim() {
        return nseqcontrlim;
    }

    /**
     * @param nseqcontrlim seta o novo valor para o campo nseqcontrlim
     */
    public void setNseqcontrlim(Long nseqcontrlim) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getLong(this.nseqcontrlim).equals(SiteUtil.getLong(nseqcontrlim));
        
        this.nseqcontrlim = nseqcontrlim;
    }

    /**
     * @return o valor do nppstapontucmbio
     */
    public Long getNppstapontucmbio() {
        return nppstapontucmbio;
    }

    /**
     * @param nppstapontucmbio seta o novo valor para o campo nppstapontucmbio
     */
    public void setNppstapontucmbio(Long nppstapontucmbio) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getLong(this.nppstapontucmbio).equals(SiteUtil.getLong(nppstapontucmbio));
        
        this.nppstapontucmbio = nppstapontucmbio;
    }

    /**
     * @return o valor do cunicclicmbio
     */
    public Long getCunicclicmbio() {
        return cunicclicmbio;
    }

    /**
     * @param cunicclicmbio seta o novo valor para o campo cunicclicmbio
     */
    public void setCunicclicmbio(Long cunicclicmbio) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getLong(this.cunicclicmbio).equals(SiteUtil.getLong(cunicclicmbio));
        
        this.cunicclicmbio = cunicclicmbio;
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
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || SiteUtil.getInt(this.cindcdeconmmoeda) != SiteUtil.getInt(cindcdeconmmoeda);
        
        this.cindcdeconmmoeda = cindcdeconmmoeda;
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
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.webMoedaToMainframe(this.vnegocmoedaestrg).equals(SiteUtil.webMoedaToMainframe(vnegocmoedaestrg));
        
        this.vnegocmoedaestrg = vnegocmoedaestrg;
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
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || SiteUtil.getInt(this.tdiaopercmbio) != SiteUtil.getInt(tdiaopercmbio);
        
        this.tdiaopercmbio = tdiaopercmbio;
    }

    /**
     * @return o valor do pspreadtxcmbio
     */
    public String getPspreadtxcmbio() {
        return pspreadtxcmbio;
    }

    /**
     * @param pspreadtxcmbio seta o novo valor para o campo pspreadtxcmbio
     */
    public void setPspreadtxcmbio(String pspreadtxcmbio) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.webMoedaToMainframe(this.pspreadtxcmbio).equals(SiteUtil.webMoedaToMainframe(pspreadtxcmbio));
        
        this.pspreadtxcmbio = pspreadtxcmbio;
    }

    /**
     * @return o valor do ptxparidade
     */
    public String getPtxparidade() {
        return ptxparidade;
    }

    /**
     * @param ptxparidade seta o novo valor para o campo ptxparidade
     */
    public void setPtxparidade(String ptxparidade) {
        this.ptxparidade = ptxparidade;
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
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || SiteUtil.getInt(this.cprodtservc) != SiteUtil.getInt(cprodtservc);
        
        this.cprodtservc = cprodtservc;
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
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getString(this.cindcdnegoccarta).equals(SiteUtil.getString(cindcdnegoccarta));
        
        this.cindcdnegoccarta = cindcdnegoccarta;
    }

    /**
     * @return o valor do cindcdcartaidpdt
     */
    public String getCindcdcartaidpdt() {
        return cindcdcartaidpdt;
    }

    /**
     * @param cindcdcartaidpdt seta o novo valor para o campo cindcdcartaidpdt
     */
    public void setCindcdcartaidpdt(String cindcdcartaidpdt) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getString(this.cindcdcartaidpdt).equals(SiteUtil.getString(cindcdcartaidpdt));
        
        this.cindcdcartaidpdt = cindcdcartaidpdt;
    }

    /**
     * @return o valor do dprevtembrq
     */
    public String getDprevtembrq() {
        return dprevtembrq;
    }

    /**
     * @param dprevtembrq seta o novo valor para o campo dprevtembrq
     */
    public void setDprevtembrq(String dprevtembrq) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getString(this.dprevtembrq).equals(SiteUtil.getString(dprevtembrq));
        
        this.dprevtembrq = dprevtembrq;
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
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getString(this.dprevtdsembcmbio).equals(SiteUtil.getString(dprevtdsembcmbio));
        
        this.dprevtdsembcmbio = dprevtdsembcmbio;
    }

    /**
     * @return o valor do tdiavalddcarta
     */
    public Integer getTdiavalddcarta() {
        return tdiavalddcarta;
    }

    /**
     * @param tdiavalddcarta seta o novo valor para o campo tdiavalddcarta
     */
    public void setTdiavalddcarta(Integer tdiavalddcarta) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || SiteUtil.getInt(this.tdiavalddcarta) != SiteUtil.getInt(tdiavalddcarta);
        
        this.tdiavalddcarta = tdiavalddcarta;
    }

    /**
     * @return o valor do justificativa
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * @param justificativa seta o novo valor para o campo justificativa
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * @return o valor do valoresAtualizados
     */
    public Boolean getValoresAtualizados() {
        return valoresAtualizados;
    }
    
    public EnumProduto getProduto() {
        return EnumProduto.fromCode(this.cprodtservc);
    }

    /**
     * @return o valor do ptxswapcmpdo
     */
    public String getPtxswapcmpdo() {
        return ptxswapcmpdo;
    }

    /**
     * @param ptxswapcmpdo seta o novo valor para o campo ptxswapcmpdo
     */
    public void setPtxswapcmpdo(String ptxswapcmpdo) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.webMoedaToMainframe(this.pspreadtxcmbio).equals(SiteUtil.webMoedaToMainframe(pspreadtxcmbio));
        
        this.ptxswapcmpdo = ptxswapcmpdo;
    }

    /**
     * @return o valor do ctponegoccmbio
     */
    public Integer getCtponegoccmbio() {
        return ctponegoccmbio;
    }

    /**
     * @param ctponegoccmbio seta o novo valor para o campo ctponegoccmbio
     */
    public void setCtponegoccmbio(Integer ctponegoccmbio) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || SiteUtil.getInt(this.ctponegoccmbio) != SiteUtil.getInt(ctponegoccmbio);
        
        this.ctponegoccmbio = ctponegoccmbio;
    }

    /**
     * @return o valor do codmoedaoper
     */
    public Integer getCodmoedaoper() {
        return Codmoedaoper;
    }

    /**
     * @param codmoedaoper seta o novo valor para o campo codmoedaoper
     */
    public void setCodmoedaoper(Integer codmoedaoper) {
        Codmoedaoper = codmoedaoper;
    }

    /**
     * @return o valor do siglamoedaoper
     */
    public String getSiglamoedaoper() {
        return Siglamoedaoper;
    }

    /**
     * @param siglamoedaoper seta o novo valor para o campo siglamoedaoper
     */
    public void setSiglamoedaoper(String siglamoedaoper) {
        Siglamoedaoper = siglamoedaoper;
    }

    /**
     * @return o valor do descmoedaoper
     */
    public String getDescmoedaoper() {
        return Descmoedaoper;
    }

    /**
     * @param descmoedaoper seta o novo valor para o campo descmoedaoper
     */
    public void setDescmoedaoper(String descmoedaoper) {
        Descmoedaoper = descmoedaoper;
    }

    /**
     * @return o valor do codmoedalim
     */
    public Integer getCodmoedalim() {
        return Codmoedalim;
    }

    /**
     * @param codmoedalim seta o novo valor para o campo codmoedalim
     */
    public void setCodmoedalim(Integer codmoedalim) {
        Codmoedalim = codmoedalim;
    }

    /**
     * @return o valor do siglamoedalim
     */
    public String getSiglamoedalim() {
        return Siglamoedalim;
    }

    /**
     * @param siglamoedalim seta o novo valor para o campo siglamoedalim
     */
    public void setSiglamoedalim(String siglamoedalim) {
        Siglamoedalim = siglamoedalim;
    }

    /**
     * @return o valor do descmoedalim
     */
    public String getDescmoedalim() {
        return Descmoedalim;
    }

    /**
     * @param descmoedalim seta o novo valor para o campo descmoedalim
     */
    public void setDescmoedalim(String descmoedalim) {
        Descmoedalim = descmoedalim;
    }

    /**
     * @return o valor do pagtefincrcmbio
     */
    public String getPagtefincrcmbio() {
        return pagtefincrcmbio;
    }

    /**
     * @param pagtefincrcmbio seta o novo valor para o campo pagtefincrcmbio
     */
    public void setPagtefincrcmbio(String pagtefincrcmbio) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getString(this.pagtefincrcmbio).equals(SiteUtil.getString(pagtefincrcmbio));
        
        this.pagtefincrcmbio = pagtefincrcmbio;
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
     * @return o valor do garangarant
     */
    public String getGarangarant() {
        return garangarant;
    }

    /**
     * @param garangarant seta o novo valor para o campo garangarant
     */
    public void setGarangarant(String garangarant) {
        
        // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.getString(this.garangarant).equals(SiteUtil.getString(garangarant));
        
        this.garangarant = garangarant;
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
        
     // Verifica se o valor do atributo foi alterado
        this.valoresAtualizados = this.valoresAtualizados || !SiteUtil.webMoedaToMainframe(this.vtxspreadtot).equals(SiteUtil.webMoedaToMainframe(vtxspreadtot));
        
        this.vtxspreadtot = vtxspreadtot;
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
     * @return o valor do desenquadramentoDesenbolso
     */
    public List<DesembolsoVO> getDesembolso() {
        return desembolso;
    }

    /**
     * @param desenquadramentoDesembolso seta o novo valor para o campo desenquadramentoDesembolso
     */
    public void setDesembolso(List<DesembolsoVO> desembolso) {
        this.desembolso = desembolso;
    }

	public String getVprevtrectacmbio() {
		return vprevtrectacmbio;
	}

	public void setVprevtrectacmbio(String vprevtrectacmbio) {
		this.vprevtrectacmbio = vprevtrectacmbio;
	}
}
