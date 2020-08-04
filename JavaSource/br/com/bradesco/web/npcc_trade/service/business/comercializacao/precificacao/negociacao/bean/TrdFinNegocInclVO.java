/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propףsito: Uso exclusivo do Bradesco, contיm
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 02/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.InformacaoPilotoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPrazoProex;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;

/**
 * Nome: TrdFinNegocInclVO.java
 * 
 * Propףsito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 02/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
public class TrdFinNegocInclVO extends TrdFinNegComumVO implements Cloneable{

	private String msgRetorno = null;

	private String crting = null;

	private Integer ctposgmtocli = 0;
	private String isgmto = null;

	private Long cpssoaundorgnz = 0L;

	private Integer nsequndorgnz = 0;

	private String irzscial = null;
	
	private String iciddeender = null;
	
	private String csgluf = null;
	
	private Integer cpais = 0;
	
	/**  DESCRICAO DO PAIS DE ORIGEM MOEDA **/
    private String ipais = null;
    
    /** CODIGO DO PAIS DE ORIGEM MOEDA **/
    private Integer cpaisInec = 0;
	
    private String nomeundorgnz = null;

	private Integer csitbletocmbio = 0;      

	/** CODIGO PRODUTO */
	private Integer cprodtservc = 0;
	
    /** CODIGO MODALIDADE */
	private Integer cmodldprodtcmbio = 0;

	private Long nseqcontrlim = 0L;

	private Long cpssoaanlsecredt = 0L;

	private Integer danosoltcanlse = 0;

	private Long nsoltcanlsecredt = 0L;

	private Integer nseqsoltcanlse = 0;

	private Integer cindcdeconmmoeda = 0;

	private String vnegocmoedaestrg = null;

	private String dfchtobletocmbio = null;
	private Integer ceconmmoedalim = 0;
	private String moedaLimite = null;

	private Integer nctabcriacmbio = 0;

	private Integer ctponegoccmbio = 0;

	/**
     * PRAZO DA OPERACAO (EM DIAS)
     */
	private Integer tdiaopercmbio = 0;
	
	/**
     * Vari�vel para controlar se o prazo da opera��o foi ajustado pelo sistema ou digitado pelo usu�rio;
     */
    private boolean prazoOperacaoAjustado;

	private String vmoedalimgerc = null;
	
	/* Campo utilizado na LC para exibir o valor na moeda do limite mais o about */
	private String vlMoedaLimite = null;

	private Integer ceconmmoedadsemb = 0;

	private String cindcdnegocswap = null;

	private boolean cindcdnegoclibor = false;

	private boolean cnegocswapfluxo = false;

	private boolean cnegocswapestrg = false;

	private Integer ctpocotactx = 0;

	private String ptxswapcmpdo = null;

	private String cindcdnegoccarta = null;

	private Integer tdiavalddletra = 0;

	private String dvalddnegoccmbio = null;

	private String ccomiscartanacio = null;

	private String cindcdnegocarbtr = null;

	private Integer qprzmedcmbio = 0;

	private String vtravaliborcmbio = null;

	private String vimpstnegoccmbio = null;

	private String viofnegoccmbio = null;

	private String vtxmoracmbio = null;

	private String vtxspreadnegoc = null;

	private Integer cbasejuromora = 0;

	private String vmultanegoccmbio = null;

	private String csegurtrnspmcado = null;

	private String csegurmcadoorgnz = null;

	private Integer cmodcontrcmbio = 0;
	
    /** DESCRICAO MODALIDADE */
	private String dmodcontrcmbio = null;

	private String rof_nome = null;

	private String rof_telefone = null;

	private String rof_cargo = null;

	private String rof_email = null;

	private String observacao = null;

	private String divergente = null;

	private String outrasespcs = null;

	private String motivo = null;

	private String dprevtdsembcmbio = null;
	
	/***** Campos do Forfaiting *****/
	
	private Integer ctpojurotrade = 0;
	
    private String ccobrcomisadcio = null;

    private CalendarioPeriodo dataPrevDesemb = new CalendarioPeriodo();

    private CalendarioPeriodo dataPrevEmbarq = new CalendarioPeriodo();
    
	private Integer cindcpsqtomador = 0;
    private Long ecunicpssoacmbiot = 0L;
    
    private Integer cindcdtipoacces = 0;
    
    private String vtxspreadtot = null;
     
    private String grupomercadoriaboleto = null;

	/**
	 * DATA DE PREVISAO DA PRORROGACAO
	 */
	private String dprevtprorrog = null;
	
	private ObservacoesCotacaoVO obsCotacaoVO = new ObservacoesCotacaoVO();	
	private PrevDesembolsoVO prevDesembolsoVO = new PrevDesembolsoVO();
	private ParcelaVO parcelaVO = new ParcelaVO();
	private ListaDespesasVO despesaVO = new ListaDespesasVO();
	
    /* LISTA-FLUXOS */
    private List<TrdFinNegFluxoPagtoVO> listaFluxos = new ArrayList<TrdFinNegFluxoPagtoVO>();

    /* LISTA-MERCADORIA */
    private List<TrdFinNegMercadoriaVO> listaMercadoria = new ArrayList<TrdFinNegMercadoriaVO>();

    /* LISTA-OPERACAO VINCULADA */
    private List<TrdFinNegOperVincVO> listaOperacaoVinculada = new ArrayList<TrdFinNegOperVincVO>();

    /* LISTA-TARIFAS */
    private List<TrdFinNegTarifaVO> listaTarifas = new ArrayList<TrdFinNegTarifaVO>();

    /* LISTA-COMISSAO */
    private List<TrdFinNegComissaoVO> listaComissaoInterna = new ArrayList<TrdFinNegComissaoVO>();
    private ComissaoCollection listaComissaoExterna = new ComissaoCollection();
    
    /* LISTA-GARANTIAS_AVALISTAS */
	private List<GarantiasVO> listaGarantiasInclusao = new ArrayList<GarantiasVO>();
	
    private Integer ntpopapelcmbio = 0;
	private List<GarantiasAvaListaVO> listaAvalistasInclusao = new ArrayList<GarantiasAvaListaVO>();
	
    private TrdFinNegPrecificacaoVO dadosPrecificacao = new TrdFinNegPrecificacaoVO();
    
    /* LISTA DE PARCELAS*/
    private List<ParcelaVO> listaParcelas = new ArrayList<ParcelaVO>();
    
    /* LISTA DE DESPESAS */
    private List<ListaDespesasVO> listaDespesas = new ArrayList<ListaDespesasVO>();
    
    /* LISTA DE RESPONSֱVEL PELAS DESPESAS */
    private List<ListaResponsavelDespesaVO> listaRespDesp = new ArrayList<ListaResponsavelDespesaVO>();
    
    // Paramentros para recuperar os dados da tela
    private ListaResponsavelDespesaVO responsavelDespesaVO = new ListaResponsavelDespesaVO();
    
    /** 
     *  INICIO CAMPOS GRUPO 1 E GRUPO 3
     */

    /** Variבvel do tipo String */
    private String cusuarmanut = null;

    /** Variבvel do tipo String */
    private String hmanutreg = null;

    /** Variבvel do tipo Long */
    private Long nbletocmbioorige = null;

    /** Variבvel do tipo Integer */
    private Integer ctpocanal = null;

    /** Variבvel do tipo Integer */
    private Integer ntpoclasfpssoa = null;

    /** Variבvel do tipo String */
    private String vutlzdlimgerc = null;

    /** Variבvel do tipo String */
    private String vsdolimsensi = null;

    /** Variבvel do tipo Integer */
    private Integer csitbletoaprov = null;

    /** Variבvel do tipo Integer */
    private Integer cmotvobletocmbio = null;

    /** Variבvel do tipo String */
    private String cusuarincl = null;

    /** Variבvel do tipo Long */
    private Long cpssoajuridcli = null;

    /** Variבvel do tipo Integer */
    private Integer nsequndcli = null;

    /** Variבvel do tipo String */
    private String dvalddlimcmbio = null;

    /** Variבvel do tipo Long */    
    private Long nppstapontucmbio = null;

    /** Variבvel do tipo Integer */
    private Integer ceconmmoedaequal = null;

    /** Variבvel do tipo Integer */
    private Integer cmoedaeconmrecta = null;

    /** Variבvel do tipo Long */
    private Long cunicpssoacta = null;

    /** Variבvel do tipo String */
    private String dinicvalddcmbio = null;

    /** Variבvel do tipo String */
    private String cnegoccmbioindmd = null;

    /** Variבvel do tipo String */
    private String dlimembrqcmbio = null;

    /** Variבvel do tipo String */
    private String dlimdoctoembrq = null;

    /** Variבvel do tipo String */
    private Date dprevtgarntexpdi = null;

    /** Variבvel do tipo String */
    private String dinclreg = null;

    /** Variבvel do tipo Integer */
    private Integer tdiavalddcarta = 0;

    /** Variבvel do tipo Integer */
    private Integer qprevtembrqcmbio = null;

    /** Variבvel do tipo Integer */
    private Integer qregexporcmbio = null;

    /** Variבvel do tipo String */
    private String cindcdembrqpcial = null;

    /** Variבvel do tipo String */
    private String cpermtrnsfcarta = "2";

    /** Variבvel do tipo String */
    private String cindcdcartaidpdt = "2";

    /** Variבvel do tipo String */
    private String ccartaconverecdd = "2";

    /** Variבvel do tipo String */
    private String cindcdlastrcarta = "2";

    /** Variבvel do tipo String */
    private String cindcdlastragric = null;

    /** Variבvel do tipo String */
    private String cpermvarcmbio = null;

    /** Variבvel do tipo Integer */
    private Integer ctpoembrqcmbio = null;

    /** Variבvel do tipo Integer */
    private Integer cidtfdbndesporte = null;

    /** Variבvel do tipo Integer */
    private Integer cidtfdbndesgrp = null;

    /** Variבvel do tipo Integer */
    private Integer cprznegoccmbio = null;

    /** Variבvel do tipo Integer */
    private Integer cidtfdcartacsndo = null;

    /** Variבvel do tipo Integer */
    private Integer ccobrcomismtori = null;

    /** Variבvel do tipo Integer */
    private Integer cidtfdformacomis = null;

    /** Variבvel do tipo String */
    private String vprevtcmbioequal = null;

    /** Variבvel do tipo String */
    private String vprevtrectacmbio = null;

    /** Variבvel do tipo String */
    private String vtxremunbndes = null;

    /** Variבvel do tipo String */
    private String vtxremuncmbio = null;

    /** Variבvel do tipo String */
    private String vlimcobervar = null;

    /** Variבvel do tipo String */
    private String pcobervarprodt = null;

    /** Variבvel do tipo String */
    private String ptxcdifinan = null;

    /** Variבvel do tipo String */
    private String pcdimaiscmbio = null;

    /** Variבvel do tipo String */
    private String pjuronegoccmbio = null;

    /** Variבvel do tipo String */
    private String pfixajurocmbio = null;

    /** Variבvel do tipo String */
    private String ptotjurocmbio = null;

    /** Variבvel do tipo String */
    private String pcomismtoricmbio = null;

    /** Variבvel do tipo String */
    private String pagtefincrcmbio = null;

    /** Variבvel do tipo String */
    private String ptxequalcmbio = null;

    /** Variבvel do tipo String */
    private String iorgextercmbio = null;

    /** Variבvel do tipo Integer */
    private Integer cfluxoperdccmbio = null;

    /** Variבvel do tipo String */
    private String dprevtinicembrq = null;

    /** Variבvel do tipo String */
    private String dprevtfimembrq = null;

    /** Variבvel do tipo String */
    private String cindcdcntragarnt = null;

    /** Variבvel do tipo String */
    private Integer tdiacntragarnt = null;

    /** Variבvel do tipo String */
    private Date dvctocntragarnt = null;

    /** Variבvel do tipo String */
    private Date dabertcntragarnt = null;

    /** Variבvel do tipo String */
    private String cindcdrenovcntra = null;

    /** Variבvel do tipo Integer */
    private Integer qdiaalertcntra = null;

    /** Variבvel do tipo String */
    private Date dalertvctocntra = null;

    /** Variבvel do tipo String */
    private String cindcdcustoexter = null;

    // ALTERAR
    
    /** Variבvel do tipo String */
	private String dfimnegoccmbio = null;

    /** Variבvel do tipo String */
	private String cindcdcartacnfdo = "2";

    /** Variבvel do tipo Integer */
	private Integer ccobrcomisagte = null;
	
	private Long cbanqrcmbioaviso = 0L;
	
	private String rjustfdqmto = null;
	
	// Utilizado apenas no desenquadradas
	private String dprevtembrq = null;
	
    /** Cota��o Funding **/
    private ListaCotacoesExternasVO cotacaoFundingVO = new ListaCotacoesExternasVO();
    
    /** Lista de Cotacoes Funding **/
    private List<ListaCotacoesExternasVO> listaCotacoes = new ArrayList<ListaCotacoesExternasVO>();
    
    /** Codigo do usuario inclusao da despesa  **/
    private String cusuariosess;
    
    /** Nome do usuario inclusao da despesa  **/
    private String nusuariosess;
    
    /**CAMPO UTILIZADO NO PROEX E BNDES POS **/
    private Long cunicpssoaindica = 0L;
    
    /** 
     *  FIM CAMPOS GRUPO 1 E GRUPO 3
     */
    
    
    /**
     * NUMERO DO DESEMBOLSO UTLIZADO NA TELAS DE PRORROGAR E ALONGAR
     */
    private Integer ndsembcmbiotrade = 0;
    
    /** Variavel do tipo String para o input Rebate */
    private String rebate = null;
    
    /** Variavel do tipo String para o input Taxa de Desconto. */
    private String taxaDesconto = null;
    
    /** Variavel do tipo String para o input credor. */
    private String credor = null;
    
    /** Variavel do tipo CnpjDataType para o input CNPJ. */
    private CnpjDataType cnpj = new CnpjDataType();
    
    /** Variavel do tipo CalendarPeriodDataType. */
    private CalendarioPeriodo periodoValidadeProposta = null;
    
    /** HORA DA INCLUSAO DO HISTORICO **/
    private String hinclreghist = null;
    
    
    /** CODIGO DO BENEFICIARIO **/
    private Long cunicpssoacmbiob = 0L;

    /** CODIGO DO AFIANCADO**/
    private Long cunicpssoacmbioa = 0L;
    
    /** INDETERMINADO GARANTIAS **/
    private boolean indeterminado = false;
    
    private String dlimenviorsumo = null;
    
    private String praca = null;
    
    // CÓDIGO DESPESA POR CONTA
    private String cidtfdrespdesp = null; 
    
    /** CODIGO DO INDICADOR ECONOMICO **/
    private Integer ecindcdeconm = 0;
    
    /** tipo data usado no validar data **/
    private String tpodata = null;
    
    /** CODIGO VALOR COMBO PRAZO PROEX **/
    private Integer ctpoprzcmbio = 0;
    
    private String descPrazoProex = null;
    
    private String imunintlcmbio = null;
    
    /** VALOR DO AGENTE FINANCEIRO **/
    private String vagtefincrcmbio = null;
    
    /** VALOR DO BANCO MANDATORIO **/
    private String vbcomtoricmbio = null;
    
    
    private InformacaoPilotoVO informacaoPiloto = new InformacaoPilotoVO();

    /** 
     * Vari�vel de controle da tela que est� chamando o modal de clientes 
     **/
    private boolean telaInicioNegociacao = Boolean.TRUE;
    
    	/**
    	* Nome: isForfaitingTipoJuroEmbutido
    	* 
    	* Propףsito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public boolean isForfaitingTipoJuroEmbutido() {
        
        return getCtpojurotrade().equals(EnumTradeFinance.OPCAO_JUROS_EMBUTIDOS.getCodigo());
    }


        /**
    	* Nome: isForfaitingTipoJuroDeduzido
    	* 
    	* Propףsito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public boolean isForfaitingTipoJuroDeduzido() {
        
        return getCtpojurotrade().equals(EnumTradeFinance.OPCAO_JUROS_DEDUZIDOS.getCodigo());
    }
	
	/**
     * @return o valor do cunicpssoacmbiob
     */
    public Long getCunicpssoacmbiob() {
        return cunicpssoacmbiob;
    }
    /**
     * @param cunicpssoacmbiob seta o novo valor para o campo cunicpssoacmbiob
     */
    public void setCunicpssoacmbiob(Long cunicpssoacmbiob) {
        this.cunicpssoacmbiob = cunicpssoacmbiob;
    }
    /**
     * @return o valor do cunicpssoacmbioa
     */
    public Long getCunicpssoacmbioa() {
        return cunicpssoacmbioa;
    }
    /**
     * @param cunicpssoacmbioa seta o novo valor para o campo cunicpssoacmbioa
     */
    public void setCunicpssoacmbioa(Long cunicpssoacmbioa) {
        this.cunicpssoacmbioa = cunicpssoacmbioa;
    }
    /**
	 * @return o valor do msgRetorno
	 */
	public String getMsgRetorno() {
		return msgRetorno;
	}
	/**
	 * @param msgRetorno seta o novo valor para o campo msgRetorno
	 */
	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
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
	 * @return o valor do contatonome
	 *//*
	public String getContatonome() {
		return contatonome;
	}
	*//**
	 * @param contatonome seta o novo valor para o campo contatonome
	 *//*
	public void setContatonome(String contatonome) {
		this.contatonome = contatonome;
	}
	*//**
	 * @return o valor do contatotele
	 *//*
	public String getContatotele() {
		return contatotele;
	}
	*//**
	 * @param contatotele seta o novo valor para o campo contatotele
	 *//*
	public void setContatotele(String contatotele) {
		this.contatotele = contatotele;
	}*/
	/**
	 * @return o valor do ctposgmtocli
	 */
	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}
	/**
	 * @param ctposgmtocli seta o novo valor para o campo ctposgmtocli
	 */
	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
	}
	/**
	 * @return o valor do isgmto
	 */
	public String getIsgmto() {
		return isgmto;
	}
	/**
	 * @param isgmto seta o novo valor para o campo isgmto
	 */
	public void setIsgmto(String isgmto) {
		this.isgmto = isgmto;
	}
	/**
	 * @return o valor do cpssoaundorgnz
	 */
	public Long getCpssoaundorgnz() {
		return cpssoaundorgnz;
	}
	/**
	 * @param cpssoaundorgnz seta o novo valor para o campo cpssoaundorgnz
	 */
	public void setCpssoaundorgnz(Long cpssoaundorgnz) {
		this.cpssoaundorgnz = cpssoaundorgnz;
	}
	/**
	 * @return o valor do nsequndorgnz
	 */
	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	/**
	 * @param nsequndorgnz seta o novo valor para o campo nsequndorgnz
	 */
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}
	/**
	 * @return o valor do irzscial
	 */
	public String getIrzscial() {
		return irzscial;
	}
	/**
	 * @param irzscial seta o novo valor para o campo irzscial
	 */
	public void setIrzscial(String irzscial) {
		this.irzscial = irzscial;
	}
	/**
	 * @return o valor do iciddeender
	 */
	public String getIciddeender() {
		return iciddeender;
	}
	/**
	 * @param iciddeender seta o novo valor para o campo iciddeender
	 */
	public void setIciddeender(String iciddeender) {
		this.iciddeender = iciddeender;
	}
	/**
	 * @return o valor do csgluf
	 */
	public String getCsgluf() {
		return csgluf;
	}
	/**
	 * @param csgluf seta o novo valor para o campo csgluf
	 */
	public void setCsgluf(String csgluf) {
		this.csgluf = csgluf;
	}
	/**
	 * @return o valor do csitbletocmbio
	 */
	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	/**
	 * @param csitbletocmbio seta o novo valor para o campo csitbletocmbio
	 */
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
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
	 * @return o valor do nseqcontrlim
	 */
	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}
	/**
	 * @param nseqcontrlim seta o novo valor para o campo nseqcontrlim
	 */
	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}
	/**
	 * @return o valor do cpssoaanlsecredt
	 */
	public Long getCpssoaanlsecredt() {
		return cpssoaanlsecredt;
	}
	/**
	 * @param cpssoaanlsecredt seta o novo valor para o campo cpssoaanlsecredt
	 */
	public void setCpssoaanlsecredt(Long cpssoaanlsecredt) {
		this.cpssoaanlsecredt = cpssoaanlsecredt;
	}
	/**
	 * @return o valor do danosoltcanlse
	 */
	public Integer getDanosoltcanlse() {
		return danosoltcanlse;
	}
	/**
	 * @param danosoltcanlse seta o novo valor para o campo danosoltcanlse
	 */
	public void setDanosoltcanlse(Integer danosoltcanlse) {
		this.danosoltcanlse = danosoltcanlse;
	}
	/**
	 * @return o valor do nsoltcanlsecredt
	 */
	public Long getNsoltcanlsecredt() {
		return nsoltcanlsecredt;
	}
	/**
	 * @param nsoltcanlsecredt seta o novo valor para o campo nsoltcanlsecredt
	 */
	public void setNsoltcanlsecredt(Long nsoltcanlsecredt) {
		this.nsoltcanlsecredt = nsoltcanlsecredt;
	}
	/**
	 * @return o valor do nseqsoltcanlse
	 */
	public Integer getNseqsoltcanlse() {
		return nseqsoltcanlse;
	}
	/**
	 * @param nseqsoltcanlse seta o novo valor para o campo nseqsoltcanlse
	 */
	public void setNseqsoltcanlse(Integer nseqsoltcanlse) {
		this.nseqsoltcanlse = nseqsoltcanlse;
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
	 * @return o valor do dfchtobletocmbio
	 */
	public String getDfchtobletocmbio() {
		return dfchtobletocmbio;
	}
	/**
	 * @param dfchtobletocmbio seta o novo valor para o campo dfchtobletocmbio
	 */
	public void setDfchtobletocmbio(String dfchtobletocmbio) {
		this.dfchtobletocmbio = dfchtobletocmbio;
	}
	/**
	 * @return o valor do ceconmmoedalim
	 */
	public Integer getCeconmmoedalim() {
		return ceconmmoedalim;
	}
	/**
	 * @param ceconmmoedalim seta o novo valor para o campo ceconmmoedalim
	 */
	public void setCeconmmoedalim(Integer ceconmmoedalim) {
		this.ceconmmoedalim = ceconmmoedalim;
	}
	/**
	 * @return o valor do moedaLimite
	 */
	public String getMoedaLimite() {
		return moedaLimite;
	}
	/**
	 * @param moedaLimite seta o novo valor para o campo moedaLimite
	 */
	public void setMoedaLimite(String moedaLimite) {
		this.moedaLimite = moedaLimite;
	}
	/**
	 * @return o valor do nctabcriacmbio
	 */
	public Integer getNctabcriacmbio() {
		return nctabcriacmbio;
	}
	/**
	 * @param nctabcriacmbio seta o novo valor para o campo nctabcriacmbio
	 */
	public void setNctabcriacmbio(Integer nctabcriacmbio) {
		this.nctabcriacmbio = nctabcriacmbio;
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
		this.ctponegoccmbio = ctponegoccmbio;
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
	 * @return o valor do vmoedalimgerc
	 */
	public String getVmoedalimgerc() {
		return vmoedalimgerc;
	}
	/**
	 * @param vmoedalimgerc seta o novo valor para o campo vmoedalimgerc
	 */
	public void setVmoedalimgerc(String vmoedalimgerc) {
		this.vmoedalimgerc = vmoedalimgerc;
	}
	/**
	 * @return o valor do vlMoedaLimite
	 */
	public String getVlMoedaLimite() {
		return vlMoedaLimite;
	}
	/**
	 * @param vlMoedaLimite seta o novo valor para o campo vlMoedaLimite
	 */
	public void setVlMoedaLimite(String vlMoedaLimite) {
		this.vlMoedaLimite = vlMoedaLimite;
	}
	/**
	 * @return o valor do ceconmmoedadsemb
	 */
	public Integer getCeconmmoedadsemb() {
		return ceconmmoedadsemb;
	}
	/**
	 * @param ceconmmoedadsemb seta o novo valor para o campo ceconmmoedadsemb
	 */
	public void setCeconmmoedadsemb(Integer ceconmmoedadsemb) {
		this.ceconmmoedadsemb = ceconmmoedadsemb;
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
	 * @return o valor do cindcdnegoclibor
	 */
	public boolean isCindcdnegoclibor() {
		return cindcdnegoclibor;
	}
	/**
	 * @param cindcdnegoclibor seta o novo valor para o campo cindcdnegoclibor
	 */
	public void setCindcdnegoclibor(boolean cindcdnegoclibor) {
		this.cindcdnegoclibor = cindcdnegoclibor;
	}
	/**
	 * @return o valor do cnegocswapfluxo
	 */
	public boolean isCnegocswapfluxo() {
		return cnegocswapfluxo;
	}
	/**
	 * @param cnegocswapfluxo seta o novo valor para o campo cnegocswapfluxo
	 */
	public void setCnegocswapfluxo(boolean cnegocswapfluxo) {
		this.cnegocswapfluxo = cnegocswapfluxo;
	}
	/**
	 * @return o valor do cnegocswapestrg
	 */
	public boolean isCnegocswapestrg() {
		return cnegocswapestrg;
	}
	/**
	 * @param cnegocswapestrg seta o novo valor para o campo cnegocswapestrg
	 */
	public void setCnegocswapestrg(boolean cnegocswapestrg) {
		this.cnegocswapestrg = cnegocswapestrg;
	}
	/**
	 * @return o valor do ctpocotactx
	 */
	public Integer getCtpocotactx() {
		return ctpocotactx;
	}
	/**
	 * @param ctpocotactx seta o novo valor para o campo ctpocotactx
	 */
	public void setCtpocotactx(Integer ctpocotactx) {
		this.ctpocotactx = ctpocotactx;
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
		this.ptxswapcmpdo = ptxswapcmpdo;
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
	 * @return o valor do tdiavalddletra
	 */
	public Integer getTdiavalddletra() {
		return tdiavalddletra;
	}
	/**
	 * @param tdiavalddletra seta o novo valor para o campo tdiavalddletra
	 */
	public void setTdiavalddletra(Integer tdiavalddletra) {
		this.tdiavalddletra = tdiavalddletra;
	}
	/**
	 * @return o valor do dvalddnegoccmbio
	 */
	public String getDvalddnegoccmbio() {
		return dvalddnegoccmbio;
	}
	/**
	 * @param dvalddnegoccmbio seta o novo valor para o campo dvalddnegoccmbio
	 */
	public void setDvalddnegoccmbio(String dvalddnegoccmbio) {
		this.dvalddnegoccmbio = dvalddnegoccmbio;
	}
	/**
	 * @return o valor do ccomiscartanacio
	 */
	public String getCcomiscartanacio() {
		return ccomiscartanacio;
	}
	/**
	 * @param ccomiscartanacio seta o novo valor para o campo ccomiscartanacio
	 */
	public void setCcomiscartanacio(String ccomiscartanacio) {
		this.ccomiscartanacio = ccomiscartanacio;
	}
	/**
	 * @return o valor do cindcdnegocarbtr
	 */
	public String getCindcdnegocarbtr() {
		return cindcdnegocarbtr;
	}
	/**
	 * @param cindcdnegocarbtr seta o novo valor para o campo cindcdnegocarbtr
	 */
	public void setCindcdnegocarbtr(String cindcdnegocarbtr) {
		this.cindcdnegocarbtr = cindcdnegocarbtr;
	}
	/**
	 * @return o valor do qprzmedcmbio
	 */
	public Integer getQprzmedcmbio() {
		return qprzmedcmbio;
	}
	/**
	 * @param qprzmedcmbio seta o novo valor para o campo qprzmedcmbio
	 */
	public void setQprzmedcmbio(Integer qprzmedcmbio) {
		this.qprzmedcmbio = qprzmedcmbio;
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
	 * @return o valor do vimpstnegoccmbio
	 */
	public String getVimpstnegoccmbio() {
		return vimpstnegoccmbio;
	}
	/**
	 * @param vimpstnegoccmbio seta o novo valor para o campo vimpstnegoccmbio
	 */
	public void setVimpstnegoccmbio(String vimpstnegoccmbio) {
		this.vimpstnegoccmbio = vimpstnegoccmbio;
	}
	/**
	 * @return o valor do viofnegoccmbio
	 */
	public String getViofnegoccmbio() {
		return viofnegoccmbio;
	}
	/**
	 * @param viofnegoccmbio seta o novo valor para o campo viofnegoccmbio
	 */
	public void setViofnegoccmbio(String viofnegoccmbio) {
		this.viofnegoccmbio = viofnegoccmbio;
	}
	/**
	 * @return o valor do vtxmoracmbio
	 */
	public String getVtxmoracmbio() {
		return vtxmoracmbio;
	}
	/**
	 * @param vtxmoracmbio seta o novo valor para o campo vtxmoracmbio
	 */
	public void setVtxmoracmbio(String vtxmoracmbio) {
		this.vtxmoracmbio = vtxmoracmbio;
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
	 * @return o valor do cbasejuromora
	 */
	public Integer getCbasejuromora() {
		return cbasejuromora;
	}
	/**
	 * @param cbasejuromora seta o novo valor para o campo cbasejuromora
	 */
	public void setCbasejuromora(Integer cbasejuromora) {
		this.cbasejuromora = cbasejuromora;
	}
	/**
	 * @return o valor do vmultanegoccmbio
	 */
	public String getVmultanegoccmbio() {
		return vmultanegoccmbio;
	}
	/**
	 * @param vmultanegoccmbio seta o novo valor para o campo vmultanegoccmbio
	 */
	public void setVmultanegoccmbio(String vmultanegoccmbio) {
		this.vmultanegoccmbio = vmultanegoccmbio;
	}
	
	public String getGrupomercadoriaboleto() {
		return grupomercadoriaboleto;
	}


	public void setGrupomercadoriaboleto(String grupomercadoriaboleto) {
		this.grupomercadoriaboleto = grupomercadoriaboleto;
	}


	/**
	 * @return o valor do csegurtrnspmcado
	 */
	public String getCsegurtrnspmcado() {
		return csegurtrnspmcado;
	}
	/**
	 * @param csegurtrnspmcado seta o novo valor para o campo csegurtrnspmcado
	 */
	public void setCsegurtrnspmcado(String csegurtrnspmcado) {
		this.csegurtrnspmcado = csegurtrnspmcado;
	}
	/**
	 * @return o valor do csegurmcadoorgnz
	 */
	public String getCsegurmcadoorgnz() {
		return csegurmcadoorgnz;
	}
	/**
	 * @param csegurmcadoorgnz seta o novo valor para o campo csegurmcadoorgnz
	 */
	public void setCsegurmcadoorgnz(String csegurmcadoorgnz) {
		this.csegurmcadoorgnz = csegurmcadoorgnz;
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
	 * @return o valor do rof_nome
	 */
	public String getRof_nome() {
		return rof_nome;
	}
	/**
	 * @param rof_nome seta o novo valor para o campo rof_nome
	 */
	public void setRof_nome(String rof_nome) {
		this.rof_nome = rof_nome;
	}
	/**
	 * @return o valor do rof_telefone
	 */
	public String getRof_telefone() {
		return rof_telefone;
	}
	/**
	 * @param rof_telefone seta o novo valor para o campo rof_telefone
	 */
	public void setRof_telefone(String rof_telefone) {
		this.rof_telefone = rof_telefone;
	}
	/**
	 * @return o valor do rof_cpf
	 */
	/*public CpfDataType getRof_cpf() {
		return rof_cpf;
	}*/
	/**
	 * @param rof_cpf seta o novo valor para o campo rof_cpf
	 */
	/*public void setRof_cpf(CpfDataType rof_cpf) {
		this.rof_cpf = rof_cpf;
	}*/
	/**
	 * @return o valor do rof_cargo
	 */
	public String getRof_cargo() {
		return rof_cargo;
	}
	/**
	 * @param rof_cargo seta o novo valor para o campo rof_cargo
	 */
	public void setRof_cargo(String rof_cargo) {
		this.rof_cargo = rof_cargo;
	}
	/**
	 * @return o valor do rof_email
	 */
	public String getRof_email() {
		return rof_email;
	}
	/**
	 * @param rof_email seta o novo valor para o campo rof_email
	 */
	public void setRof_email(String rof_email) {
		this.rof_email = rof_email;
	}
	/**
	 * @return o valor do observacao
	 */
	public String getObservacao() {
		return observacao;
	}
	/**
	 * @param observacao seta o novo valor para o campo observacao
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	/**
	 * @return o valor do outrasespcs
	 */
	public String getOutrasespcs() {
		return outrasespcs;
	}
	/**
	 * @param outrasespcs seta o novo valor para o campo outrasespcs
	 */
	public void setOutrasespcs(String outrasespcs) {
		this.outrasespcs = outrasespcs;
	}
	/**
	 * @return o valor do motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @param motivo seta o novo valor para o campo motivo
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	/**
	 * @return o valor do listaFluxos
	 */
	public List<TrdFinNegFluxoPagtoVO> getListaFluxos() {
		return listaFluxos;
	}
	/**
	 * @param listaFluxos seta o novo valor para o campo listaFluxos
	 */
	public void setListaFluxos(List<TrdFinNegFluxoPagtoVO> listaFluxos) {
		this.listaFluxos = listaFluxos;
	}
	/**
	 * @return o valor do listaMercadoria
	 */
	public List<TrdFinNegMercadoriaVO> getListaMercadoria() {
		return listaMercadoria;
	}
	/**
	 * @param listaMercadoria seta o novo valor para o campo listaMercadoria
	 */
	public void setListaMercadoria(List<TrdFinNegMercadoriaVO> listaMercadoria) {
		this.listaMercadoria = listaMercadoria;
	}
	/**
	 * @return o valor do listaOperacaoVinculada
	 */
	public List<TrdFinNegOperVincVO> getListaOperacaoVinculada() {
		return listaOperacaoVinculada;
	}
	/**
	 * @param listaOperacaoVinculada seta o novo valor para o campo listaOperacaoVinculada
	 */
	public void setListaOperacaoVinculada(
			List<TrdFinNegOperVincVO> listaOperacaoVinculada) {
		this.listaOperacaoVinculada = listaOperacaoVinculada;
	}
	/**
	 * @return o valor do listaTarifas
	 */
	public List<TrdFinNegTarifaVO> getListaTarifas() {
		return listaTarifas;
	}
	/**
	 * @param listaTarifas seta o novo valor para o campo listaTarifas
	 */
	public void setListaTarifas(List<TrdFinNegTarifaVO> listaTarifas) {
		this.listaTarifas = listaTarifas;
	}
	/**
	 * @return o valor do listaComissaoInterna
	 */
	public List<TrdFinNegComissaoVO> getListaComissaoInterna() {
		return listaComissaoInterna;
	}
	/**
	 * @param listaComissaoInterna seta o novo valor para o campo listaComissaoInterna
	 */
	public void setListaComissaoInterna(
			List<TrdFinNegComissaoVO> listaComissaoInterna) {
		this.listaComissaoInterna = listaComissaoInterna;
	}
	/**
	 * @return o valor do listaComissaoExterna
	 */
	public ComissaoCollection getListaComissaoExterna() {
		return listaComissaoExterna;
	}
	/**
	 * @param listaComissaoExterna seta o novo valor para o campo listaComissaoExterna
	 */
	public void setListaComissaoExterna(
	        ComissaoCollection listaComissaoExterna) {
		this.listaComissaoExterna = listaComissaoExterna;
	}
	/**
	 * @return o valor do listaGarantiasInclusao
	 */
	public List<GarantiasVO> getListaGarantiasInclusao() {
		return listaGarantiasInclusao;
	}
	/**
	 * @param listaGarantiasInclusao seta o novo valor para o campo listaGarantiasInclusao
	 */
	public void setListaGarantiasInclusao(List<GarantiasVO> listaGarantiasInclusao) {
		this.listaGarantiasInclusao = listaGarantiasInclusao;
	}
	/**
	 * @return o valor do listaAvalistasInclusao
	 */
	public List<GarantiasAvaListaVO> getListaAvalistasInclusao() {
		return listaAvalistasInclusao;
	}
	/**
	 * @param listaAvalistasInclusao seta o novo valor para o campo listaAvalistasInclusao
	 */
	public void setListaAvalistasInclusao(
			List<GarantiasAvaListaVO> listaAvalistasInclusao) {
		this.listaAvalistasInclusao = listaAvalistasInclusao;
	}
    /**
     * @return o valor do cmodldprodtcmbio
     */
    public Integer getCmodldprodtcmbio() {
        return cmodldprodtcmbio;
    }
    /**
     * @param cmodldprodtcmbio seta o novo valor para o campo cmodldprodtcmbio
     */
    public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
        this.cmodldprodtcmbio = cmodldprodtcmbio;
    }
    /**
     * @return o valor do dadosPrecificacao
     */
    public TrdFinNegPrecificacaoVO getDadosPrecificacao() {
        return dadosPrecificacao;
    }
    /**
     * @param dadosPrecificacao seta o novo valor para o campo dadosPrecificacao
     */
    public void setDadosPrecificacao(TrdFinNegPrecificacaoVO dadosPrecificacao) {
        this.dadosPrecificacao = dadosPrecificacao;
    }    
    /**
     * @return o valor do listaParcelas
     */
    public List<ParcelaVO> getListaParcelas() {
        return listaParcelas;
    }
    /**
     * @param listaParcelas seta o novo valor para o campo listaParcelas
     */
    public void setListaParcelas(List<ParcelaVO> listaParcelas) {
        this.listaParcelas = listaParcelas;
    }    
    /**
     * @return o valor do listaDespesas
     */
    public List<ListaDespesasVO> getListaDespesas() {
        return listaDespesas;
    }
    /**
     * @param listaDespesas seta o novo valor para o campo listaDespesas
     */
    public void setListaDespesas(List<ListaDespesasVO> listaDespesas) {
        this.listaDespesas = listaDespesas;
    }    
    /**
     * @return o valor do listaRespDesp
     */
    public List<ListaResponsavelDespesaVO> getListaRespDesp() {
        return listaRespDesp;
    }
    /**
     * @param listaRespDesp seta o novo valor para o campo listaRespDesp
     */
    public void setListaRespDesp(List<ListaResponsavelDespesaVO> listaRespDesp) {
        this.listaRespDesp = listaRespDesp;
    }
    /**
     * @return o valor do ntpopapelcmbio
     */
    public Integer getNtpopapelcmbio() {
        return ntpopapelcmbio;
    }
    /**
     * @param ntpopapelcmbio seta o novo valor para o campo ntpopapelcmbio
     */
    public void setNtpopapelcmbio(Integer ntpopapelcmbio) {
        this.ntpopapelcmbio = ntpopapelcmbio;
    }
    
	public String getDprevtprorrog() {
		return dprevtprorrog;
	}
	
	public void setDprevtprorrog(String dprevtprorrog) {
		this.dprevtprorrog = dprevtprorrog;
	}
	
	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}
	
	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}
    /**
     * @return o valor do divergente
     */
    public String getDivergente() {
        return divergente;
    }
    /**
     * @param divergente seta o novo valor para o campo divergente
     */
    public void setDivergente(String divergente) {
        this.divergente = divergente;
    }
    /**
     * @return o valor do ccobrcomisadcio
     */
    public String getCcobrcomisadcio() {
        return ccobrcomisadcio;
    }
    /**
     * @param ccobrcomisadcio seta o novo valor para o campo ccobrcomisadcio
     */
    public void setCcobrcomisadcio(String ccobrcomisadcio) {
        this.ccobrcomisadcio = ccobrcomisadcio;
    }
    /**
     * @return o valor do dataPrevEmbarq
     */
    public CalendarioPeriodo getDataPrevEmbarq() {
        return dataPrevEmbarq;
    }
    /**
     * @param dataPrevEmbarq seta o novo valor para o campo dataPrevEmbarq
     */
    public void setDataPrevEmbarq(CalendarioPeriodo dataPrevEmbarq) {
        this.dataPrevEmbarq = dataPrevEmbarq;
    }
	
	/**
	 * @return o valor do cusuarmanut
	 */
	public String getCusuarmanut() {
		return cusuarmanut;
	}
	/**
	 * @param cusuarmanut seta o novo valor para o campo cusuarmanut
	 */
	public void setCusuarmanut(String cusuarmanut) {
		this.cusuarmanut = cusuarmanut;
	}
	/**
	 * @return o valor do hmanutreg
	 */
	public String getHmanutreg() {
		return hmanutreg;
	}
	/**
	 * @param hmanutreg seta o novo valor para o campo hmanutreg
	 */
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}
	/**
	 * @return o valor do nbletocmbioorige
	 */
	public Long getNbletocmbioorige() {
		return nbletocmbioorige;
	}
	/**
	 * @param nbletocmbioorige seta o novo valor para o campo nbletocmbioorige
	 */
	public void setNbletocmbioorige(Long nbletocmbioorige) {
		this.nbletocmbioorige = nbletocmbioorige;
	}
	
	/**
	 * @return o valor do ctpocanal
	 */
	public Integer getCtpocanal() {
		return ctpocanal;
	}
	/**
	 * @param ctpocanal seta o novo valor para o campo ctpocanal
	 */
	public void setCtpocanal(Integer ctpocanal) {
		this.ctpocanal = ctpocanal;
	}
	/**
	 * @return o valor do ntpoclasfpssoa
	 */
	public Integer getNtpoclasfpssoa() {
		return ntpoclasfpssoa;
	}
	/**
	 * @param ntpoclasfpssoa seta o novo valor para o campo ntpoclasfpssoa
	 */
	public void setNtpoclasfpssoa(Integer ntpoclasfpssoa) {
		this.ntpoclasfpssoa = ntpoclasfpssoa;
	}
	/**
	 * @return o valor do vutlzdlimgerc
	 */
	public String getVutlzdlimgerc() {
		return vutlzdlimgerc;
	}
	/**
	 * @param vutlzdlimgerc seta o novo valor para o campo vutlzdlimgerc
	 */
	public void setVutlzdlimgerc(String vutlzdlimgerc) {
		this.vutlzdlimgerc = vutlzdlimgerc;
	}
	/**
	 * @return o valor do vsdolimsensi
	 */
	public String getVsdolimsensi() {
		return vsdolimsensi;
	}
	/**
	 * @param vsdolimsensi seta o novo valor para o campo vsdolimsensi
	 */
	public void setVsdolimsensi(String vsdolimsensi) {
		this.vsdolimsensi = vsdolimsensi;
	}
	/**
	 * @return o valor do csitbletoaprov
	 */
	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	/**
	 * @param csitbletoaprov seta o novo valor para o campo csitbletoaprov
	 */
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}
	/**
	 * @return o valor do cmotvobletocmbio
	 */
	public Integer getCmotvobletocmbio() {
		return cmotvobletocmbio;
	}
	/**
	 * @param cmotvobletocmbio seta o novo valor para o campo cmotvobletocmbio
	 */
	public void setCmotvobletocmbio(Integer cmotvobletocmbio) {
		this.cmotvobletocmbio = cmotvobletocmbio;
	}
	/**
	 * @return o valor do cusuarincl
	 */
	public String getCusuarincl() {
		return cusuarincl;
	}
	/**
	 * @param cusuarincl seta o novo valor para o campo cusuarincl
	 */
	public void setCusuarincl(String cusuarincl) {
		this.cusuarincl = cusuarincl;
	}
	
	/**
	 * @return o valor do cpssoajuridcli
	 */
	public Long getCpssoajuridcli() {
		return cpssoajuridcli;
	}
	/**
	 * @param cpssoajuridcli seta o novo valor para o campo cpssoajuridcli
	 */
	public void setCpssoajuridcli(Long cpssoajuridcli) {
		this.cpssoajuridcli = cpssoajuridcli;
	}
	/**
	 * @return o valor do nsequndcli
	 */
	public Integer getNsequndcli() {
		return nsequndcli;
	}
	/**
	 * @param nsequndcli seta o novo valor para o campo nsequndcli
	 */
	public void setNsequndcli(Integer nsequndcli) {
		this.nsequndcli = nsequndcli;
	}
	/**
	 * @return o valor do dvalddlimcmbio
	 */
	public String getDvalddlimcmbio() {
		return dvalddlimcmbio;
	}
	/**
	 * @param dvalddlimcmbio seta o novo valor para o campo dvalddlimcmbio
	 */
	public void setDvalddlimcmbio(String dvalddlimcmbio) {
		this.dvalddlimcmbio = dvalddlimcmbio;
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
		this.nppstapontucmbio = nppstapontucmbio;
	}
	/**
	 * @return o valor do ceconmmoedaequal
	 */
	public Integer getCeconmmoedaequal() {
		return ceconmmoedaequal;
	}
	/**
	 * @param ceconmmoedaequal seta o novo valor para o campo ceconmmoedaequal
	 */
	public void setCeconmmoedaequal(Integer ceconmmoedaequal) {
		this.ceconmmoedaequal = ceconmmoedaequal;
	}
	/**
	 * @return o valor do cmoedaeconmrecta
	 */
	public Integer getCmoedaeconmrecta() {
		return cmoedaeconmrecta;
	}
	/**
	 * @param cmoedaeconmrecta seta o novo valor para o campo cmoedaeconmrecta
	 */
	public void setCmoedaeconmrecta(Integer cmoedaeconmrecta) {
		this.cmoedaeconmrecta = cmoedaeconmrecta;
	}
	/**
	 * @return o valor do cunicpssoacta
	 */
	public Long getCunicpssoacta() {
		return cunicpssoacta;
	}
	/**
	 * @param cunicpssoacta seta o novo valor para o campo cunicpssoacta
	 */
	public void setCunicpssoacta(Long cunicpssoacta) {
		this.cunicpssoacta = cunicpssoacta;
	}
	/**
	 * @return o valor do dinicvalddcmbio
	 */
	public String getDinicvalddcmbio() {
		return dinicvalddcmbio;
	}
	/**
	 * @param dinicvalddcmbio seta o novo valor para o campo dinicvalddcmbio
	 */
	public void setDinicvalddcmbio(String dinicvalddcmbio) {
		this.dinicvalddcmbio = dinicvalddcmbio;
	}
	/**
	 * @return o valor do cnegoccmbioindmd
	 */
	public String getCnegoccmbioindmd() {
		return cnegoccmbioindmd;
	}
	/**
	 * @param cnegoccmbioindmd seta o novo valor para o campo cnegoccmbioindmd
	 */
	public void setCnegoccmbioindmd(String cnegoccmbioindmd) {
		this.cnegoccmbioindmd = cnegoccmbioindmd;
	}
	/**
	 * @return o valor do dlimembrqcmbio
	 */
	public String getDlimembrqcmbio() {
		return dlimembrqcmbio;
	}
	/**
	 * @param dlimembrqcmbio seta o novo valor para o campo dlimembrqcmbio
	 */
	public void setDlimembrqcmbio(String dlimembrqcmbio) {
		this.dlimembrqcmbio = dlimembrqcmbio;
	}
	/**
	 * @return o valor do dlimdoctoembrq
	 */
	public String getDlimdoctoembrq() {
		return dlimdoctoembrq;
	}
	/**
	 * @param dlimdoctoembrq seta o novo valor para o campo dlimdoctoembrq
	 */
	public void setDlimdoctoembrq(String dlimdoctoembrq) {
		this.dlimdoctoembrq = dlimdoctoembrq;
	}
	/**
	 * @return o valor do dprevtgarntexpdi
	 */
	public Date getDprevtgarntexpdi() {
		return dprevtgarntexpdi;
	}
	/**
	 * @param dprevtgarntexpdi seta o novo valor para o campo dprevtgarntexpdi
	 */
	public void setDprevtgarntexpdi(Date dprevtgarntexpdi) {
		this.dprevtgarntexpdi = dprevtgarntexpdi;
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
		this.tdiavalddcarta = tdiavalddcarta;
	}
	/**
	 * @return o valor do qprevtembrqcmbio
	 */
	public Integer getQprevtembrqcmbio() {
		return qprevtembrqcmbio;
	}
	/**
	 * @param qprevtembrqcmbio seta o novo valor para o campo qprevtembrqcmbio
	 */
	public void setQprevtembrqcmbio(Integer qprevtembrqcmbio) {
		this.qprevtembrqcmbio = qprevtembrqcmbio;
	}
	/**
	 * @return o valor do qregexporcmbio
	 */
	public Integer getQregexporcmbio() {
		return qregexporcmbio;
	}
	/**
	 * @param qregexporcmbio seta o novo valor para o campo qregexporcmbio
	 */
	public void setQregexporcmbio(Integer qregexporcmbio) {
		this.qregexporcmbio = qregexporcmbio;
	}
	/**
	 * @return o valor do cindcdembrqpcial
	 */
	public String getCindcdembrqpcial() {
		return cindcdembrqpcial;
	}
	/**
	 * @param cindcdembrqpcial seta o novo valor para o campo cindcdembrqpcial
	 */
	public void setCindcdembrqpcial(String cindcdembrqpcial) {
		this.cindcdembrqpcial = cindcdembrqpcial;
	}
	/**
	 * @return o valor do cpermtrnsfcarta
	 */
	public String getCpermtrnsfcarta() {
		return cpermtrnsfcarta;
	}
	/**
	 * @param cpermtrnsfcarta seta o novo valor para o campo cpermtrnsfcarta
	 */
	public void setCpermtrnsfcarta(String cpermtrnsfcarta) {
		this.cpermtrnsfcarta = cpermtrnsfcarta;
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
		this.cindcdcartaidpdt = cindcdcartaidpdt;
	}
	/**
	 * @return o valor do ccartaconverecdd
	 */
	public String getCcartaconverecdd() {
		return ccartaconverecdd;
	}
	/**
	 * @param ccartaconverecdd seta o novo valor para o campo ccartaconverecdd
	 */
	public void setCcartaconverecdd(String ccartaconverecdd) {
		this.ccartaconverecdd = ccartaconverecdd;
	}
	/**
	 * @return o valor do cindcdlastrcarta
	 */
	public String getCindcdlastrcarta() {
		return cindcdlastrcarta;
	}
	/**
	 * @param cindcdlastrcarta seta o novo valor para o campo cindcdlastrcarta
	 */
	public void setCindcdlastrcarta(String cindcdlastrcarta) {
		this.cindcdlastrcarta = cindcdlastrcarta;
	}
	/**
	 * @return o valor do cindcdlastragric
	 */
	public String getCindcdlastragric() {
		return cindcdlastragric;
	}
	/**
	 * @param cindcdlastragric seta o novo valor para o campo cindcdlastragric
	 */
	public void setCindcdlastragric(String cindcdlastragric) {
		this.cindcdlastragric = cindcdlastragric;
	}
	/**
	 * @return o valor do cpermvarcmbio
	 */
	public String getCpermvarcmbio() {
		return cpermvarcmbio;
	}
	/**
	 * @param cpermvarcmbio seta o novo valor para o campo cpermvarcmbio
	 */
	public void setCpermvarcmbio(String cpermvarcmbio) {
		this.cpermvarcmbio = cpermvarcmbio;
	}
	/**
	 * @return o valor do ctpoembrqcmbio
	 */
	public Integer getCtpoembrqcmbio() {
		return ctpoembrqcmbio;
	}
	/**
	 * @param ctpoembrqcmbio seta o novo valor para o campo ctpoembrqcmbio
	 */
	public void setCtpoembrqcmbio(Integer ctpoembrqcmbio) {
		this.ctpoembrqcmbio = ctpoembrqcmbio;
	}
	/**
	 * @return o valor do cidtfdbndesporte
	 */
	public Integer getCidtfdbndesporte() {
		return cidtfdbndesporte;
	}
	/**
	 * @param cidtfdbndesporte seta o novo valor para o campo cidtfdbndesporte
	 */
	public void setCidtfdbndesporte(Integer cidtfdbndesporte) {
		this.cidtfdbndesporte = cidtfdbndesporte;
	}
	/**
	 * @return o valor do cidtfdbndesgrp
	 */
	public Integer getCidtfdbndesgrp() {
		return cidtfdbndesgrp;
	}
	/**
	 * @param cidtfdbndesgrp seta o novo valor para o campo cidtfdbndesgrp
	 */
	public void setCidtfdbndesgrp(Integer cidtfdbndesgrp) {
		this.cidtfdbndesgrp = cidtfdbndesgrp;
	}
	/**
	 * @return o valor do cprznegoccmbio
	 */
	public Integer getCprznegoccmbio() {
		return cprznegoccmbio;
	}
	/**
	 * @param cprznegoccmbio seta o novo valor para o campo cprznegoccmbio
	 */
	public void setCprznegoccmbio(Integer cprznegoccmbio) {
		this.cprznegoccmbio = cprznegoccmbio;
	}
	/**
	 * @return o valor do cidtfdcartacsndo
	 */
	public Integer getCidtfdcartacsndo() {
		return cidtfdcartacsndo;
	}
	/**
	 * @param cidtfdcartacsndo seta o novo valor para o campo cidtfdcartacsndo
	 */
	public void setCidtfdcartacsndo(Integer cidtfdcartacsndo) {
		this.cidtfdcartacsndo = cidtfdcartacsndo;
	}
	/**
	 * @return o valor do ccobrcomismtori
	 */
	public Integer getCcobrcomismtori() {
		return ccobrcomismtori;
	}
	/**
	 * @param ccobrcomismtori seta o novo valor para o campo ccobrcomismtori
	 */
	public void setCcobrcomismtori(Integer ccobrcomismtori) {
		this.ccobrcomismtori = ccobrcomismtori;
	}
	/**
	 * @return o valor do cidtfdformacomis
	 */
	public Integer getCidtfdformacomis() {
		return cidtfdformacomis;
	}
	/**
	 * @param cidtfdformacomis seta o novo valor para o campo cidtfdformacomis
	 */
	public void setCidtfdformacomis(Integer cidtfdformacomis) {
		this.cidtfdformacomis = cidtfdformacomis;
	}
	/**
	 * @return o valor do vprevtcmbioequal
	 */
	public String getVprevtcmbioequal() {
		return vprevtcmbioequal;
	}
	/**
	 * @param vprevtcmbioequal seta o novo valor para o campo vprevtcmbioequal
	 */
	public void setVprevtcmbioequal(String vprevtcmbioequal) {
		this.vprevtcmbioequal = vprevtcmbioequal;
	}
	/**
	 * @return o valor do vprevtrectacmbio
	 */
	public String getVprevtrectacmbio() {
		return vprevtrectacmbio;
	}
	/**
	 * @param vprevtrectacmbio seta o novo valor para o campo vprevtrectacmbio
	 */
	public void setVprevtrectacmbio(String vprevtrectacmbio) {
		this.vprevtrectacmbio = vprevtrectacmbio;
	}
	/**
	 * @return o valor do vtxremunbndes
	 */
	public String getVtxremunbndes() {
		return vtxremunbndes;
	}
	/**
	 * @param vtxremunbndes seta o novo valor para o campo vtxremunbndes
	 */
	public void setVtxremunbndes(String vtxremunbndes) {
		this.vtxremunbndes = vtxremunbndes;
	}
	/**
	 * @return o valor do vtxremuncmbio
	 */
	public String getVtxremuncmbio() {
		return vtxremuncmbio;
	}
	/**
	 * @param vtxremuncmbio seta o novo valor para o campo vtxremuncmbio
	 */
	public void setVtxremuncmbio(String vtxremuncmbio) {
		this.vtxremuncmbio = vtxremuncmbio;
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
	 * @return o valor do pcobervarprodt
	 */
	public String getPcobervarprodt() {
		return pcobervarprodt;
	}
	/**
	 * @param pcobervarprodt seta o novo valor para o campo pcobervarprodt
	 */
	public void setPcobervarprodt(String pcobervarprodt) {
		this.pcobervarprodt = pcobervarprodt;
	}
	/**
	 * @return o valor do ptxcdifinan
	 */
	public String getPtxcdifinan() {
		return ptxcdifinan;
	}
	/**
	 * @param ptxcdifinan seta o novo valor para o campo ptxcdifinan
	 */
	public void setPtxcdifinan(String ptxcdifinan) {
		this.ptxcdifinan = ptxcdifinan;
	}
	/**
	 * @return o valor do pcdimaiscmbio
	 */
	public String getPcdimaiscmbio() {
		return pcdimaiscmbio;
	}
	/**
	 * @param pcdimaiscmbio seta o novo valor para o campo pcdimaiscmbio
	 */
	public void setPcdimaiscmbio(String pcdimaiscmbio) {
		this.pcdimaiscmbio = pcdimaiscmbio;
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
	 * @return o valor do pfixajurocmbio
	 */
	public String getPfixajurocmbio() {
		return pfixajurocmbio;
	}
	/**
	 * @param pfixajurocmbio seta o novo valor para o campo pfixajurocmbio
	 */
	public void setPfixajurocmbio(String pfixajurocmbio) {
		this.pfixajurocmbio = pfixajurocmbio;
	}
	/**
	 * @return o valor do ptotjurocmbio
	 */
	public String getPtotjurocmbio() {
		return ptotjurocmbio;
	}
	/**
	 * @param ptotjurocmbio seta o novo valor para o campo ptotjurocmbio
	 */
	public void setPtotjurocmbio(String ptotjurocmbio) {
		this.ptotjurocmbio = ptotjurocmbio;
	}
	/**
	 * @return o valor do pcomismtoricmbio
	 */
	public String getPcomismtoricmbio() {
		return pcomismtoricmbio;
	}
	/**
	 * @param pcomismtoricmbio seta o novo valor para o campo pcomismtoricmbio
	 */
	public void setPcomismtoricmbio(String pcomismtoricmbio) {
		this.pcomismtoricmbio = pcomismtoricmbio;
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
		this.pagtefincrcmbio = pagtefincrcmbio;
	}
	/**
	 * @return o valor do ptxequalcmbio
	 */
	public String getPtxequalcmbio() {
		return ptxequalcmbio;
	}
	/**
	 * @param ptxequalcmbio seta o novo valor para o campo ptxequalcmbio
	 */
	public void setPtxequalcmbio(String ptxequalcmbio) {
		this.ptxequalcmbio = ptxequalcmbio;
	}
	/**
	 * @return o valor do iorgextercmbio
	 */
	public String getIorgextercmbio() {
		return iorgextercmbio;
	}
	/**
	 * @param iorgextercmbio seta o novo valor para o campo iorgextercmbio
	 */
	public void setIorgextercmbio(String iorgextercmbio) {
		this.iorgextercmbio = iorgextercmbio;
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
	 * @return o valor do dprevtinicembrq
	 */
	public String getDprevtinicembrq() {
		return dprevtinicembrq;
	}
	/**
	 * @param dprevtinicembrq seta o novo valor para o campo dprevtinicembrq
	 */
	public void setDprevtinicembrq(String dprevtinicembrq) {
		this.dprevtinicembrq = dprevtinicembrq;
	}
	/**
	 * @return o valor do dprevtfimembrq
	 */
	public String getDprevtfimembrq() {
		return dprevtfimembrq;
	}
	/**
	 * @param dprevtfimembrq seta o novo valor para o campo dprevtfimembrq
	 */
	public void setDprevtfimembrq(String dprevtfimembrq) {
		this.dprevtfimembrq = dprevtfimembrq;
	}
	/**
	 * @return o valor do cindcdcntragarnt
	 */
	public String getCindcdcntragarnt() {
		return cindcdcntragarnt;
	}
	/**
	 * @param cindcdcntragarnt seta o novo valor para o campo cindcdcntragarnt
	 */
	public void setCindcdcntragarnt(String cindcdcntragarnt) {
		this.cindcdcntragarnt = cindcdcntragarnt;
	}
	/**
	 * @return o valor do tdiacntragarnt
	 */
	public Integer getTdiacntragarnt() {
		return tdiacntragarnt;
	}
	/**
	 * @param tdiacntragarnt seta o novo valor para o campo tdiacntragarnt
	 */
	public void setTdiacntragarnt(Integer tdiacntragarnt) {
		this.tdiacntragarnt = tdiacntragarnt;
	}
	/**
	 * @return o valor do dvctocntragarnt
	 */
	public Date getDvctocntragarnt() {
		return dvctocntragarnt;
	}
	/**
	 * @param dvctocntragarnt seta o novo valor para o campo dvctocntragarnt
	 */
	public void setDvctocntragarnt(Date dvctocntragarnt) {
		this.dvctocntragarnt = dvctocntragarnt;
	}
	/**
	 * @return o valor do dabertcntragarnt
	 */
	public Date getDabertcntragarnt() {
		return dabertcntragarnt;
	}
	/**
	 * @param dabertcntragarnt seta o novo valor para o campo dabertcntragarnt
	 */
	public void setDabertcntragarnt(Date dabertcntragarnt) {
		this.dabertcntragarnt = dabertcntragarnt;
	}
	/**
	 * @return o valor do cindcdrenovcntra
	 */
	public String getCindcdrenovcntra() {
		return cindcdrenovcntra;
	}
	/**
	 * @param cindcdrenovcntra seta o novo valor para o campo cindcdrenovcntra
	 */
	public void setCindcdrenovcntra(String cindcdrenovcntra) {
		this.cindcdrenovcntra = cindcdrenovcntra;
	}
	/**
	 * @return o valor do qdiaalertcntra
	 */
	public Integer getQdiaalertcntra() {
		return qdiaalertcntra;
	}
	/**
	 * @param qdiaalertcntra seta o novo valor para o campo qdiaalertcntra
	 */
	public void setQdiaalertcntra(Integer qdiaalertcntra) {
		this.qdiaalertcntra = qdiaalertcntra;
	}
	/**
	 * @return o valor do dalertvctocntra
	 */
	public Date getDalertvctocntra() {
		return dalertvctocntra;
	}
	/**
	 * @param dalertvctocntra seta o novo valor para o campo dalertvctocntra
	 */
	public void setDalertvctocntra(Date dalertvctocntra) {
		this.dalertvctocntra = dalertvctocntra;
	}
	/**
	 * @return o valor do cindcdcustoexter
	 */
	public String getCindcdcustoexter() {
		return cindcdcustoexter;
	}
	/**
	 * @param cindcdcustoexter seta o novo valor para o campo cindcdcustoexter
	 */
	public void setCindcdcustoexter(String cindcdcustoexter) {
		this.cindcdcustoexter = cindcdcustoexter;
	}
	
	/**
	 * @return o valor do dfimnegoccmbio
	 */
	public String getDfimnegoccmbio() {
		return dfimnegoccmbio;
	}
	/**
	 * @param dfimnegoccmbio seta o novo valor para o campo dfimnegoccmbio
	 */
	public void setDfimnegoccmbio(String dfimnegoccmbio) {
		this.dfimnegoccmbio = dfimnegoccmbio;
	}
	/**
	 * @return o valor do cindcdcartacnfdo
	 */
	public String getCindcdcartacnfdo() {
		return cindcdcartacnfdo;
	}
	/**
	 * @param cindcdcartacnfdo seta o novo valor para o campo cindcdcartacnfdo
	 */
	public void setCindcdcartacnfdo(String cindcdcartacnfdo) {
		this.cindcdcartacnfdo = cindcdcartacnfdo;
	}
	/**
	 * @return o valor do ccobrcomisagte
	 */
	public Integer getCcobrcomisagte() {
		return ccobrcomisagte;
	}
	/**
	 * @param ccobrcomisagte seta o novo valor para o campo ccobrcomisagte
	 */
	public void setCcobrcomisagte(Integer ccobrcomisagte) {
		this.ccobrcomisagte = ccobrcomisagte;
	}
    /**
     * @return o valor do ctpojurotrade
     */
    public Integer getCtpojurotrade() {
        if (SiteUtil.isEmptyOrNull(ctpojurotrade)) {
            return Numeros.NUM0;
        }
        return ctpojurotrade;
    }
    /**
     * @param ctpojurotrade seta o novo valor para o campo ctpojurotrade
     */
    public void setCtpojurotrade(Integer ctpojurotrade) {
        this.ctpojurotrade = ctpojurotrade;
    }		
    /**
     * @return o valor do obsCotacaoVO
     */
    public ObservacoesCotacaoVO getObsCotacaoVO() {
        return obsCotacaoVO;
    }
    /**
     * @param obsCotacaoVO seta o novo valor para o campo obsCotacaoVO
     */
    public void setObsCotacaoVO(ObservacoesCotacaoVO obsCotacaoVO) {
        this.obsCotacaoVO = obsCotacaoVO;
    }
    /**
     * @return o valor do prevDesembolsoVO
     */
    public PrevDesembolsoVO getPrevDesembolsoVO() {
        return prevDesembolsoVO;
    }
    /**
     * @param prevDesembolsoVO seta o novo valor para o campo prevDesembolsoVO
     */
    public void setPrevDesembolsoVO(PrevDesembolsoVO prevDesembolsoVO) {
        this.prevDesembolsoVO = prevDesembolsoVO;
    }    
    /**
     * @return o valor do parcelaVO
     */
    public ParcelaVO getParcelaVO() {
        return parcelaVO;
    }
    /**
     * @param parcelaVO seta o novo valor para o campo parcelaVO
     */
    public void setParcelaVO(ParcelaVO parcelaVO) {
        this.parcelaVO = parcelaVO;
    }    
    /**
     * @return o valor do despesaVO
     */
    public ListaDespesasVO getDespesaVO() {
        return despesaVO;
    }
    /**
     * @param despesaVO seta o novo valor para o campo despesaVO
     */
    public void setDespesaVO(ListaDespesasVO despesaVO) {
        this.despesaVO = despesaVO;
    }
    /**
     * @return o valor do rebate
     */
    public String getRebate() {
        return rebate;
    }
    /**
     * @param rebate seta o novo valor para o campo rebate
     */
    public void setRebate(String rebate) {
        this.rebate = rebate;
    }
    /**
     * @return o valor do taxaDesconto
     */
    public String getTaxaDesconto() {
        return taxaDesconto;
    }
    /**
     * @param taxaDesconto seta o novo valor para o campo taxaDesconto
     */
    public void setTaxaDesconto(String taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }
    /**
     * @return o valor do credor
     */
    public String getCredor() {
        return credor;
    }
    /**
     * @param credor seta o novo valor para o campo credor
     */
    public void setCredor(String credor) {
        this.credor = credor;
    }
    /**
     * @return o valor do cnpj
     */
    public CnpjDataType getCnpj() {
        return cnpj;
    }
    /**
     * @param cnpj seta o novo valor para o campo cnpj
     */
    public void setCnpj(CnpjDataType cnpj) {
        this.cnpj = cnpj;
    }
    /**
     * @return o valor do periodoValidadeProposta
     */
    public CalendarioPeriodo getPeriodoValidadeProposta() {
        return periodoValidadeProposta;
    }
    /**
     * @param periodoValidadeProposta seta o novo valor para o campo periodoValidadeProposta
     */
    public void setPeriodoValidadeProposta(CalendarioPeriodo periodoValidadeProposta) {
        this.periodoValidadeProposta = periodoValidadeProposta;
    }
    /**
     * @return o valor do dataPrevDesemb
     */
    public CalendarioPeriodo getDataPrevDesemb() {
        return dataPrevDesemb;
    }
    /**
     * @param dataPrevDesemb seta o novo valor para o campo dataPrevDesemb
     */
    public void setDataPrevDesemb(CalendarioPeriodo dataPrevDesemb) {
        this.dataPrevDesemb = dataPrevDesemb;
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
    
    public EnumProduto getProduto() {
        return EnumProduto.fromCode(this.cprodtservc == null ? Numeros.ZERO : this.cprodtservc);
    }
    /**
     * @return o valor do cbanqrcmbioaviso
     */
    public Long getCbanqrcmbioaviso() {
        return cbanqrcmbioaviso;
    }
    /**
     * @param cbanqrcmbioaviso seta o novo valor para o campo cbanqrcmbioaviso
     */
    public void setCbanqrcmbioaviso(Long cbanqrcmbioaviso) {
        this.cbanqrcmbioaviso = cbanqrcmbioaviso;
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
     * @return o valor do indeterminado
     */
    public boolean isIndeterminado() {
        return indeterminado;
    }
    /**
     * @param indeterminado seta o novo valor para o campo indeterminado
     */
    public void setIndeterminado(boolean indeterminado) {
        this.indeterminado = indeterminado;
    }
    
	/**
	 * @return
	 */
	public String getDinclreg() {
		return dinclreg;
	}
	/**
	 * @param dinclreg
	 */
	public void setDinclreg(String dinclreg) {
		this.dinclreg = dinclreg;
	}
    /**
     * @return o valor do rjustfdqmto
     */
    public String getRjustfdqmto() {
        return rjustfdqmto;
    }
    /**
     * @param rjustfdqmto seta o novo valor para o campo rjustfdqmto
     */
    public void setRjustfdqmto(String rjustfdqmto) {
        this.rjustfdqmto = rjustfdqmto;
    }
    
    /**
     * @return
     */
    public String getNomeundorgnz() {
        return nomeundorgnz;
    }
    /**
     * @param Nomeundorgnz
     */
    public void setNomeundorgnz(String nomeundorgnz) {
        this.nomeundorgnz = nomeundorgnz;
    }
    
	public Long getEcunicpssoacmbiot() {
		return ecunicpssoacmbiot;
	}
	public void setEcunicpssoacmbiot(Long ecunicpssoacmbiot) {
		this.ecunicpssoacmbiot = ecunicpssoacmbiot;
	}
	public ListaCotacoesExternasVO getCotacaoFundingVO() {
		return cotacaoFundingVO;
	}
	public void setCotacaoFundingVO(ListaCotacoesExternasVO cotacaoFundingVO) {
		this.cotacaoFundingVO = cotacaoFundingVO;
	}
	public List<ListaCotacoesExternasVO> getListaCotacoes() {
		return listaCotacoes;
	}
	public void setListaCotacoes(List<ListaCotacoesExternasVO> listaCotacoes) {
		this.listaCotacoes = listaCotacoes;
	}
	public String getCusuariosess() {
		return cusuariosess;
	}
	public void setCusuariosess(String cusuariosess) {
		this.cusuariosess = cusuariosess;
	}
	public String getNusuariosess() {
		return nusuariosess;
	}
	public void setNusuariosess(String nusuariosess) {
		this.nusuariosess = nusuariosess;
	}
    /**
     * @return o valor do cindcdtipoacces
     */
    public Integer getCindcdtipoacces() {
        return cindcdtipoacces;
    }
    /**
     * @param cindcdtipoacces seta o novo valor para o campo cindcdtipoacces
     */
    public void setCindcdtipoacces(Integer cindcdtipoacces) {
        this.cindcdtipoacces = cindcdtipoacces;
    }
    /**
     * @return o valor do responsavelDespesaVO
     */
    public ListaResponsavelDespesaVO getResponsavelDespesaVO() {
        return responsavelDespesaVO;
    }
    /**
     * @param responsavelDespesaVO seta o novo valor para o campo responsavelDespesaVO
     */
    public void setResponsavelDespesaVO(ListaResponsavelDespesaVO responsavelDespesaVO) {
        this.responsavelDespesaVO = responsavelDespesaVO;
    }

    /**
     * @return o valor do cunicpssoaindica
     */
    public Long getCunicpssoaindica() {
        return cunicpssoaindica;
    }

    /**
     * @param cunicpssoaindica seta o novo valor para o campo cunicpssoaindica
     */
    public void setCunicpssoaindica(Long cunicpssoaindica) {
        this.cunicpssoaindica = cunicpssoaindica;
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
        this.dprevtembrq = dprevtembrq;
    }

    /**
     * @return o valor do dlimenviorsumo
     */
    public String getDlimenviorsumo() {
        return dlimenviorsumo;
    }

    /**
     * @param dlimenviorsumo seta o novo valor para o campo dlimenviorsumo
     */
    public void setDlimenviorsumo(String dlimenviorsumo) {
        this.dlimenviorsumo = dlimenviorsumo;
    }

    /**
     * @return o valor do praca
     */
    public String getPraca() {
        return praca;
    }

    /**
     * @param praca seta o novo valor para o campo praca
     */
    public void setPraca(String praca) {
        this.praca = praca;
    }

    public String getCidtfdrespdesp() {
        return cidtfdrespdesp;
    }

    public void setCidtfdrespdesp(String cidtfdrespdesp) {
        this.cidtfdrespdesp = cidtfdrespdesp;
    }

    public Integer getEcindcdeconm() {
        return ecindcdeconm;
    }

    public void setEcindcdeconm(Integer ecindcdeconm) {
        this.ecindcdeconm = ecindcdeconm;
    }

    public String getIpais() {
        return ipais;
    }

    public void setIpais(String ipais) {
        this.ipais = ipais;
    }

    public Integer getCpaisInec() {
        return cpaisInec;
    }

    public void setCpaisInec(Integer cpaisInec) {
        this.cpaisInec = cpaisInec;
    }

    public String getTpodata() {
        return tpodata;
    }

    public void setTpodata(String tpodata) {
        this.tpodata = tpodata;
    }

	/**
	 * @return the cindcpsqtomador
	 */
	public Integer getCindcpsqtomador() {
		return cindcpsqtomador;
	}

	/**
	 * @param cindcpsqtomador the cindcpsqtomador to set
	 */
	public void setCindcpsqtomador(Integer cindcpsqtomador) {
		this.cindcpsqtomador = cindcpsqtomador;
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
     * @return the ctpoprzcmbio
     */
    public Integer getCtpoprzcmbio() {
        return ctpoprzcmbio;
    }

    /**
     * @param ctpoprzcmbio the ctpoprzcmbio to set
     */
    public void setCtpoprzcmbio(Integer ctpoprzcmbio) {
        this.ctpoprzcmbio = ctpoprzcmbio;
    }
    
    /**
     * @return the descPrazoProex
     */
    public String getDescPrazoProex() {
        this.descPrazoProex = EnumPrazoProex.fromCode(this.ctpoprzcmbio).getDescricao();
        return this.descPrazoProex;
    }

    /**
     * @param descPrazoProex the descPrazoProex to set
     */
    public void setDescPrazoProex(String descPrazoProex) {
        this.descPrazoProex = descPrazoProex;
    }


    /**
     * @return o valor do prazoOperacaoAjustado
     */
    public boolean isPrazoOperacaoAjustado() {
        return prazoOperacaoAjustado;
    }

    /**
     * @param prazoOperacaoAjustado seta o novo valor para o campo prazoOperacaoAjustado
     */
    public void setPrazoOperacaoAjustado(boolean prazoOperacaoAjustado) {
        this.prazoOperacaoAjustado = prazoOperacaoAjustado;
    }


    /**
     * @return the imunintlcmbio
     */
    public String getImunintlcmbio() {
        return imunintlcmbio;
    }


    /**
     * @param imunintlcmbio the imunintlcmbio to set
     */
    public void setImunintlcmbio(String imunintlcmbio) {
        this.imunintlcmbio = imunintlcmbio;
    }


    /**
     * @return the informacaoPiloto
     */
    public InformacaoPilotoVO getInformacaoPiloto() {
        return informacaoPiloto;
    }


    /**
     * @param informacaoPiloto the informacaoPiloto to set
     */
    public void setInformacaoPiloto(InformacaoPilotoVO informacaoPiloto) {
        this.informacaoPiloto = informacaoPiloto;
    }


    public boolean isTelaInicioNegociacao() {
        return telaInicioNegociacao;
    }


    public void setTelaInicioNegociacao(boolean telaInicioNegociacao) {
        this.telaInicioNegociacao = telaInicioNegociacao;
    }


	public String getVagtefincrcmbio() {
		return vagtefincrcmbio;
	}


	public void setVagtefincrcmbio(String vagtefincrcmbio) {
		this.vagtefincrcmbio = vagtefincrcmbio;
	}


	public String getVbcomtoricmbio() {
		return vbcomtoricmbio;
	}


	public void setVbcomtoricmbio(String vbcomtoricmbio) {
		this.vbcomtoricmbio = vbcomtoricmbio;
	}

	public String getDmodcontrcmbio() {
		return dmodcontrcmbio;
	}

	public void setDmodcontrcmbio(String dmodcontrcmbio) {
		this.dmodcontrcmbio = dmodcontrcmbio;
	}    
	
	public TrdFinNegocInclVO copy() {
        try {
        	TrdFinNegocInclVO copiaTrdFinNegocInclVO = (TrdFinNegocInclVO)this.clone();

        	// Fluxo pagamento
        	List<TrdFinNegFluxoPagtoVO> listTrdFinNegFluxoPagtoVO = this.getListaFluxos();
        	List<TrdFinNegFluxoPagtoVO> copiaListTrdFinNegFluxoPagtoVO = new ArrayList<TrdFinNegFluxoPagtoVO>();
        	
        	for (Iterator<TrdFinNegFluxoPagtoVO> iterator = listTrdFinNegFluxoPagtoVO.iterator(); iterator.hasNext();) {
				TrdFinNegFluxoPagtoVO trdFinNegFluxoPagtoVO = (TrdFinNegFluxoPagtoVO) iterator.next();
				TrdFinNegFluxoPagtoVO copiaTrdFinNegFluxoPagtoVO = trdFinNegFluxoPagtoVO.copy();
				copiaListTrdFinNegFluxoPagtoVO.add(copiaTrdFinNegFluxoPagtoVO);
			}
        	copiaTrdFinNegocInclVO.setListaFluxos(copiaListTrdFinNegFluxoPagtoVO);

        	// Precifica��o Unidade Externa
        	UnidadeExternaVO unidadeExternaVO = getDadosPrecificacao().getUnidadeExternaVO().copy();
        	copiaTrdFinNegocInclVO.getDadosPrecificacao().setUnidadeExternaVO(unidadeExternaVO);
        	
        	// Precifica��o
        	TrdFinNegPrecificacaoVO trdFinNegPrecificacaoVO = getDadosPrecificacao().copy();
        	copiaTrdFinNegocInclVO.setDadosPrecificacao(trdFinNegPrecificacaoVO);
        	
        	// Data Desembolso
            CalendarioPeriodo calendarioPeriodoDesem = getDataPrevDesemb().copy();
            copiaTrdFinNegocInclVO.setDataPrevDesemb(calendarioPeriodoDesem);
            
         // Data Embarque
            CalendarioPeriodo calendarioPeriodoEmbarque = getDataPrevEmbarq().copy();
            copiaTrdFinNegocInclVO.setDataPrevEmbarq(calendarioPeriodoEmbarque);
        	
            
            return copiaTrdFinNegocInclVO;
            
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
