/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 02/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.view.components.UICnpj.UICnpj;
import br.com.bradesco.web.aq.view.components.UICpf.UICpf;
import br.com.bradesco.web.aq.view.components.base.UICnpj.CnpjDataTypeBase;
import br.com.bradesco.web.aq.view.components.html.uiinputtext.UIInputTextBradesco;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.InformacaoPilotoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ComboCotacaoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumComissaoSobre;

/**
 * Nome: TradeFinanceNegociacaoViewHelper.java
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
 * Registro  de Manutenção: 02/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TradeFinanceNegociacaoViewHelper {
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboProduto = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboMoedaOperacao = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboMoedaDesembolso = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboMoedaEqualizavel = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboMoedaReceita = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboPaisOrigem = new ArrayList<SelectItem>();
	
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboPaisEmbarque = new ArrayList<SelectItem>();

    /** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboPaisBeneficiario = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboMomento = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboCodBaseJuros = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboCodCobrancaComissao = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboComissaoSobre = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboTipoCotacao = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboCodigoPtax = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<ComboCotacaoVO> listaPeriodicidade = new ArrayList<ComboCotacaoVO>();
	private List<SelectItem> comboPeriodicidade = new ArrayList<SelectItem>();
	
	private List<ComboCotacaoVO> listaPeriodicidadePrinc = new ArrayList<ComboCotacaoVO>();
	private List<SelectItem> comboPeriodicidadePrinc = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboTipoComissao = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboTarifas = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboPeriodoDaTaxa = new ArrayList<SelectItem>();
	
	/** Variável do tipo List<SelectItem>. */
	private List<SelectItem> comboDesembolsoOri = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboModalidade = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboPrazo = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboAVistaPrazo = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboPorConta = new ArrayList<SelectItem>();

    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboTipoDespesas = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboDocumentosConsignados = new ArrayList<SelectItem>();
    
    private List<SelectItem> comboPrazoProex = new ArrayList<SelectItem>();
    
    /** Variável do tipo boolean. */
	private Boolean renderListaModalLimite = Boolean.FALSE;

	/** Variável do tipo boolean. */
	private Boolean renderBtoConfirmar = Boolean.FALSE;

	/** Variável do tipo boolean. */
	private Boolean renderBtoTrocarProdutoIncl = Boolean.FALSE;
    
	/** Variável do tipo boolean. */
    private boolean renderMsg = Boolean.FALSE;
    
    /** Variável do tipo boolean. */
    private boolean operaComLimite = Boolean.TRUE;

	/** 
     * Variável de controle da tela que está chamando o modal de clientes 
     **/
    private boolean telaInicioNegociacao = Boolean.TRUE;

    /** Variável com nome da tela de retorno para o chamador */
    private String telaRetorno = null;

	/** Variável de controle do botão na Inclusão */
	private Boolean renderDetalheCliente = Boolean.FALSE;
    
    /** 
     * Variável de controle do MODAL 
     **/
	private Boolean renderModalCliente = Boolean.FALSE;
    private Boolean renderModalUnidExt = Boolean.FALSE;
    private Boolean renderModalLiborTravada = Boolean.FALSE;
    private Boolean renderModalBeneficiario = Boolean.FALSE;
    private Boolean renderModalMercadoria = Boolean.FALSE;
    private Boolean renderModalOperacoesVinculadas = Boolean.FALSE;
    private Boolean renderModalLimite = Boolean.TRUE;
    private Boolean renderModal = Boolean.FALSE;
    private Boolean renderFechar = Boolean.FALSE;
    
    /** 
     * Variáveis de com o id do modal
     **/
    private String modalId = "";
    
    /** 
     * Variável de controle do MODAL COMISSAO
     **/
    private Boolean renderModalComissaoInterna = Boolean.FALSE;
    private Boolean renderModalComissaoExterna = Boolean.FALSE;
    private Boolean disabledValorComissaoExt = Boolean.FALSE;
    private Boolean disabledTaxaComissaoExt = Boolean.FALSE;
    
    private String nomeTomador = null;
    
    /** 
     * Variável de controle do MODAL FLUXO PAGTO 
     **/
    private Date dateFluxoPgtoTemp = null;
    
    /** 
     * Variável de controle da funcao do Botao na Comissao
     **/
    private String funcaoBotaoComissaoInterna = "Incluir";
    
    /** 
     * Variável de controle da funcao do Botao no Fluxo Pagto
     **/
    private String funcaoBotaoFluxo = "Incluir";
    
    /** 
     * Variável de controle para habilitar/desabilitar botão Alterar, Excluir, Detalhar
     **/
    private Integer ctrBotaoFluxo = 0;
    /**
     * Indice do radio selecionado na grid
     */
    private Integer itemSelecListaModalLimites = Numeros.ZERO;
    
    /**
     * Indice do radio selecionado na grid
     */
    private String itemSelecListaFluxos = null;
    
	/**
     *  Variável utilizada para definier o state id da lista 
     */
    private String stateIdListaModalLimites = null;
	
	/**
     *  Variável utilizada para definier o state id da lista 
     */
    private String stateIdListaFluxos = null;
	
	/**
     *  Variável utilizada para definier o state id da lista 
     */
    private String stateIdListaFluxosComissao = null;
	
	/**
     *  Variável utilizada para definier o state id da lista 
     */
    private String stateIdListaMercadoria = null;
	
	/**
     *  Variável utilizada para definier o state id da lista 
     */
    private String stateIdListaModalOperVinculadas = null;
    private String stateIdListaOperacaoVinculada = null;
	
	/**
     *  Variável utilizada para definier o state id da lista 
     */
    private String stateIdListaTarifas = null;
	
	/**
     *  Variável utilizada para definier o state id da lista 
     */
    private String stateIdListaComissaoInterna = null;
    private String stateIdListaComissaoExterna = null;
	
	/** PRAZO STAND BY TELA **/
	private Boolean disabledCheckLibor = Boolean.TRUE;

	private Boolean disabledCheckFluxo = Boolean.TRUE;

	private Boolean disabledCheckMeMn = Boolean.TRUE;

	private Boolean disabledComboPtax = Boolean.TRUE;

	private Boolean disabledTxtSpreadAll = Boolean.TRUE;
	
	private Boolean disabledTxtParcelaComissaoExt = Boolean.TRUE;
    
    private Boolean disabledModalComissaoInt = Boolean.TRUE;
    
    private Boolean disabledModalComissaoExt = Boolean.TRUE;
	
	/** PRAZO STAND BY TELA ***/
	private Integer tdiamaxcredt = 0;
	
    private Boolean disabledRadioStandBy = Boolean.FALSE;
    
	private Boolean disabledTxtPrazoStandBy = Boolean.TRUE;

	private Boolean disabledRadioComisStandBy = Boolean.FALSE;

    /** Variável do tipo Date. */
    private Date dataLimiteCotacao = null;
    
    /** Variável do tipo Date. */
    private Date dataDisponibilidade = null;
    
    /** Variável do tipo Date. */
    private Date vencimentoSaque = null;
    
    private Date datePrevDesembolso = null;
    
    private Date dateVencFianc = null;
    
    private String valueMaisMenosFluxoPagto = "+";

    private String valueMaisMenosPrecificacao = "+";

    private String valueMaisMenosComissaoInterna = "+";

    private String valueMaisMenosMercadoria = "+";

    private String valueMaisMenosOperacaoVinculada = "+";

	private String valueMaisMenosResponsavelEmpresa = "+";
	
	private String valueMaisMenosTarifas = "+";
	
	private String valueMaisMenosComissao = "+";
	
	private String valueMaisMenosDocumentosConsignados = "+";
	
	private String valueMaisMenosContatoRetiradaGarantia = "+";
    
    private Boolean renderFluxoPagto = Boolean.FALSE;
    
    private Boolean renderPrecificacao = Boolean.FALSE;
    
    private Boolean renderComissaoInterna = Boolean.FALSE;
    
    private Boolean renderMercadoria = Boolean.FALSE;
    
    private Boolean renderOperacaoVinculada = Boolean.FALSE;
    
	private Boolean renderResponsavelEmpresa = Boolean.FALSE;
	    
	private Boolean renderTarifas = Boolean.FALSE;
	    
	private Boolean renderComissao = Boolean.FALSE;
	
	private Boolean renderDocumentosConsignados = Boolean.FALSE;
	
    private Boolean renderContatoRetiradaGarantia = Boolean.FALSE;

    /** Variável do tipo Integer. */
    private Integer itemSelecListaFluxosComissao = Numeros.ZERO;

    /** Variável do tipo Integer. */
    private Integer itemSelecListaMercadoria = Numeros.ZERO;

    /** Variável do tipo Integer. */
    private Integer[] itemSelecListaModalOperVinculadas = null;
    private Integer itemSelecListaOperacaoVinculada = Numeros.ZERO;

    /** Variável do tipo Integer. */
    private String itemSelecListaTarifas = null;

    /** Variável do tipo Integer. */
    private Integer itemSelecListaComissaoInterna = Numeros.NUM999;
    private String itemSelecListaComissaoExterna = null;
    private String itemSelecListaComissaoBanqueiro = null;

    /** Variável do tipo Integer. */
    private Integer codCpfCnpjSelecionado = Numeros.ZERO;
    private Integer codCpfCnpjDepositarioSelecionado = Numeros.ZERO;
    
    private String txtUnidExterna = null;
    private String liborTravada = null;
    
    /** Variavel Binding CPF */
    private UICpf cpfClienteBinding = new UICpf();
    
    /** Variavel Binding CNPJ */
    private UICnpj cnpjClienteBinding = new UICnpj();

	/***************  Tela Modal **************/

    /** Variável do tipo Integer. */
    private Integer itemSelecListaSelCliente = Numeros.ZERO;
    private Integer itemSelecListaBeneficiario = Numeros.ZERO;
    private Integer itemSelecListaUnidExt = Numeros.ZERO;
    private Integer itemSelecListaDesembolso = Numeros.ZERO;
	
	/**
     *  Variável utilizada para definier o state id das listas
     */
    private String nomeStateIdListaSelCliente = null;
    private String nomeStateIdListaSelUnidExt = null;
    private String nomeStateIdListaSelBeneficiario = null;
    private String nomeStateIdListaSelMercadoria = null;
    private String stateIdListaParcelasFluxoPgto = null;
    private String stateIdListaParcelasComissao = null;
    private String stateIdListaParcelas = null;
    private String stateIdListaDespesas = null;
    private String stateIdListaRespDesp = null;

    /** Variavel do tipo BradescoHtmlInputText. */
    private UIInputTextBradesco campoCodigoDescricao = new UIInputTextBradesco();
       
    private String nomeMoedaDesembolso = null;
    private String statusCotacao = null;
    
    
    private String nomeMoedaComissaoInterna = null;

    private Integer tipoCobrancaComissao = Numeros.ZERO;
    private String valueComissaoCobranca = null;
    private Integer codMoedaComissao = Numeros.ZERO;
    private Integer codComissaoSobre = Numeros.ZERO;
    private Integer codTarifa = Numeros.ZERO;
    private String vmincobrcomis = null;
    
    private Integer cfluxoperdccmbio = Numeros.ZERO;
    private Integer cfluxoperdccmbioRed = Numeros.ZERO;
	private Integer codMomentoComissao = Numeros.ZERO;
    private Integer codMomentoComissaoRed = Numeros.ZERO;


	private Integer przomediooperd = 0;
	
	private String przomedioopera = null;

	// Campos da tela de dadosPrecificacao
    private Boolean renderIrIof = Boolean.FALSE;

    // Campos da tela de dadosTomador
    private Boolean renderAbout = Boolean.FALSE;

    // Campos da tela de dadosMercadoria
    private Boolean renderSeguroBenef = Boolean.FALSE;
    
    
    //controle de edicao do cliente nas tela de Prorrogar e Alongar
    private Boolean clienteEditavel = Boolean.TRUE;
    
    //Controle de campos exclusivos da tela de prorrogar PPE
    private Boolean prorrogarPPE = Boolean.FALSE;
    
    private Boolean desabilitaCamposPrrg = Boolean.FALSE;
    
    private Date dateProrrogacao;
    
    /**
     * Indice do radio selecionado na grid de rebate
     */
    private String codRebateSelecionado = null;
    
    /**
     * Indice do radio selecionado na grid de rebate
     */
    private String codTaxaDescontoSelecionado = null;
    
    // mensagem auxiliar para evitar dupla mensagem no BradescoFacesUtils
    private Integer tipoAcesso = 0;
    private String mensagemFluxoValidacao = null;
    private Boolean renderModalAlerta = Boolean.FALSE;
   
   private boolean checkPercCDI = Boolean.FALSE;
   private boolean checkMaisCDI = Boolean.FALSE;
   private boolean checkTaxaPre = Boolean.FALSE;

   private boolean disabledCheckPercCDI = Boolean.FALSE;
   private boolean disabledCheckMaisCDI = Boolean.FALSE;
   private boolean disabledCheckTaxaPre = Boolean.FALSE;

   private boolean disabledPercCDI = Boolean.FALSE;
   private boolean disabledMaisCDI = Boolean.FALSE;
   private boolean disabledTaxaPre = Boolean.FALSE;
   
   private boolean disabledGarantidor = Boolean.FALSE;
   private boolean disabledRadioTaxaPre = Boolean.FALSE;
   
   private Date dataLimiteFRO = null;
   private Date dataVencProposta = null;
   private Date periodoEmbarqueIni = null;
   private Date periodoEmbarqueFim = null;   

   private boolean disabledTxtParcelaFlxPgtPrinc = true;
   private boolean disabledTxtCarenciaPrinc = false;
   
   private boolean disabledTxtParcelaFlxPgtJuros = true;
   private boolean disabledTxtCarenciaJuros = false;
   private boolean disabledComboMomentoJuros = false;
   
   /** Numero de aprovacao de credito CELIM ou PEL **/
   private Long nAprvCred = 0L;

   //controle de edicao do combo Tipo de Cotação
   private Boolean disabledTipoCotacao = Boolean.FALSE;
   
   private Boolean disabledModalidade = Boolean.FALSE;
   
   private List<SelectItem> comboFormaPagamento = new ArrayList<SelectItem>();
   protected List<SelectItem> comboMoeda = new ArrayList<SelectItem>();
   
   private String stateIdListaCotacoes = null;
   private Integer itemSelecListaCotacoes = 0;
   
   private Date dataValidadeCotacao = new Date();
   
   private String alertMessageConfirmation = "";
   
   private InformacaoPilotoVO informacaoPiloto = new InformacaoPilotoVO();
   
   /**
    * Indice do radio selecionado na grid de rebate
    */
   private Integer controleBotaoAlerta = null;

   
   /****************************************
    * INICIO - ATRIBUTOS LC IMPORTACAO       *
    ****************************************/
   private Integer itemSelecListaParcelas = Numeros.NUM999;
   private Integer itemSelecListaDespesas = null;
   private Date dataLimiteEmbarque = null;

   /****************************************
    * FIM - ATRIBUTOS LC IMPORTACAO          *
    ****************************************/
   
   /************************************************************
    * INICIO - ATRIBUTOS GARANTIA INTERNACIONAL EXPEDIDA       *
    ************************************************************/
   private Integer itemSelecListaRespDesp = 0;
   private boolean indeterminado = false;

   /************************************************************
    * INICIO - ATRIBUTOS GARANTIA INTERNACIONAL EXPEDIDA       *
    ************************************************************/
   
   private List<SelectItem> comboFuncao = null;
   private Integer funcaoSelecionada = 0;
   
   /**
    * Indica qual o modal foi aberto para pesquisa | Reembolsador ou Unidade Externa
    */
   private String tipoUnidExt = null;
   
   /**
    * Numero desembolso utilizado no Aditar NCE para vinculo operacoes / fluxo pagametno
    */
   
   private Integer numDesembFlxPgtoOperAditar = 0;
   
   private Boolean disabledQtdeParcela = Boolean.TRUE;
   
   private Boolean renderLupaAprovCredito = Boolean.TRUE;
   
   /**
    * Comissao Externa Reduzida
    */
   
	private Integer tipoComissaoExterna = 0;
	private Integer cobrancaComissaoExterna = 0;
	private String valorComissaoExterna = null;
	private String taxaComissaoExterna = null;
	private Integer moedaComissaoExterna = 0;
	
	private Integer codComisSobre = 0;
	
	public String getDescComissaoSobre() {
	    return EnumComissaoSobre.fromCode(getCodComissaoSobre()).getDescricao();
	}
	
	/**
	 * DESPESA POR CONTA GARANTIA, FINIMP ECA E LC
	 */
   
	private String cidtfdrespdesp = null;
	private List<SelectItem> comboPorContaGarantia = new ArrayList<SelectItem>();
	
	private List<SelectItem> comboPeriodoDaTaxa2;
	
	/**
     * Nome: getTipoPesquisa
     * 
     * Propósito: Monta a lista de Radio Button de Tipo de Pesquisa para Beneficiario/Afiançado
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getTipoPesquisaCpfCnpj() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM2, "CNPJ"));
        tipo.add(new SelectItem(Numeros.NUM3, "CPF"));
        return tipo;
    }

    /**
     * Nome: getListaComboPorte
     * 
     * Propósito: Monta a lista do combo "Porte" - Dados valor moeda
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 09/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getListaComboPorte() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM1, "GRANDE"));
        tipo.add(new SelectItem(Numeros.NUM2, "MPME"));
        tipo.add(new SelectItem(Numeros.NUM3, "MEDIA GRANDE"));
        return tipo;
    }    

    /**
     * Nome: getListaComboGrupo
     * 
     * Propósito: Monta a lista do combo "Grupo" - Dados valor moeda
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 09/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getListaComboGrupo() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM0, "Selecione..."));
        tipo.add(new SelectItem(Numeros.NUM1, "Grupo I"));
        tipo.add(new SelectItem(Numeros.NUM2, "Grupo II"));
        tipo.add(new SelectItem(Numeros.NUM3, "Grupo III"));
        tipo.add(new SelectItem(Numeros.NUM4, "Grupo 1A"));
        tipo.add(new SelectItem(Numeros.NUM5, "Serviços"));
        return tipo;
    }     
    
    /**
     * Nome: getListaComboCobrancaComissao
     * 
     * Propósito: Monta a lista do combo "Cobrança da Comissão"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 09/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getListaComboCobrancaComissao() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();   
        tipo.add(new SelectItem(Numeros.NUM0, "Selecione..."));
        tipo.add(new SelectItem(Numeros.NUM2, "Flat"));
        tipo.add(new SelectItem(Numeros.NUM3, "AA"));
        tipo.add(new SelectItem(Numeros.NUM4, "AM"));
        return tipo;
    }
    
    /**
     * Nome: carregaComboPeriodicidade
     * 
     * Propósito: Carrega combo de peridicidade e guarda a lista original para recuperar a quantidade de dias
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 09/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void carregaComboPeriodicidade(List<ComboCotacaoVO> lista){
        
        // Guarda lista de periodicidade
        setListaPeriodicidade(lista);
        
        setComboPeriodicidade(new ArrayList<SelectItem>());
        getComboPeriodicidade().add(new SelectItem(Numeros.ZERO, "Selecione..."));
        for (Iterator<ComboCotacaoVO> iterator = lista.iterator(); iterator.hasNext();) {
            ComboCotacaoVO comboVO = iterator.next();
            if (comboVO.getCfluxoperdccmbio() != 13) {
            	getComboPeriodicidade().add(new SelectItem(comboVO.getCfluxoperdccmbio(), comboVO.getIfluxoperdccmbio()));
            }
        }
    }
    
    /**
     * Nome: carregaComboPeriodicidade
     * 
     * Propósito: Carrega combo de peridicidade e guarda a lista original para recuperar a quantidade de dias
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 09/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void carregaComboPeriodicidadePrinc(List<ComboCotacaoVO> lista){
        
        // Guarda lista de periodicidadePrinc
        setListaPeriodicidadePrinc(lista);
        
        setComboPeriodicidadePrinc(new ArrayList<SelectItem>());
        getComboPeriodicidadePrinc().add(new SelectItem(Numeros.ZERO, "Selecione..."));
        for (Iterator<ComboCotacaoVO> iterator = lista.iterator(); iterator.hasNext();) {
            ComboCotacaoVO comboVO = iterator.next();
            if (comboVO.getCfluxoperdccmbio() != 14 && comboVO.getCfluxoperdccmbio() != 13) {
            	getComboPeriodicidadePrinc().add(new SelectItem(comboVO.getCfluxoperdccmbio(), comboVO.getIfluxoperdccmbio()));
			}
        }
    }
    
    /**
     * Nome: getDiasPeriodicidade
     * 
     * Propósito: Recupera a quantidade de dias da periodicidade selecionada
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 09/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public Integer getDiasPeriodicidade(Integer cfluxoperdccmbio){
        Integer result = null;
        
        if(SiteUtil.getInt(cfluxoperdccmbio) != 0) {
            for (ComboCotacaoVO item : getListaPeriodicidade()) {
                if(item.getCfluxoperdccmbio().equals(cfluxoperdccmbio)){
                    result = item.getPerdcprzomes();
                    break;
                }
            }
        }
        
        return result;
    }

	/**
	 * @return o valor do comboProduto
	 */
	public List<SelectItem> getComboProduto() {
		return comboProduto;
	}

	/**
	 * @param comboProduto seta o novo valor para o campo comboProduto
	 */
	public void setComboProduto(List<SelectItem> comboProduto) {
		this.comboProduto = comboProduto;
	}

	/**
	 * @return o valor do comboMoedaOperacao
	 */
	public List<SelectItem> getComboMoedaOperacao() {
		return comboMoedaOperacao;
	}

	/**
	 * @param comboMoedaOperacao seta o novo valor para o campo comboMoedaOperacao
	 */
	public void setComboMoedaOperacao(List<SelectItem> comboMoedaOperacao) {
		this.comboMoedaOperacao = comboMoedaOperacao;
	}

	/**
	 * @return o valor do comboMoedaDesembolso
	 */
	public List<SelectItem> getComboMoedaDesembolso() {
		return comboMoedaDesembolso;
	}

	/**
	 * @param comboMoedaDesembolso seta o novo valor para o campo comboMoedaDesembolso
	 */
	public void setComboMoedaDesembolso(List<SelectItem> comboMoedaDesembolso) {
		this.comboMoedaDesembolso = comboMoedaDesembolso;
	}

	/**
	 * @return o valor do comboPaisOrigem
	 */
	public List<SelectItem> getComboPaisOrigem() {
		return comboPaisOrigem;
	}

	/**
	 * @param comboPaisOrigem seta o novo valor para o campo comboPaisOrigem
	 */
	public void setComboPaisOrigem(List<SelectItem> comboPaisOrigem) {
		this.comboPaisOrigem = comboPaisOrigem;
	}

	/**
     * @return o valor do comboPaisEmbarque
     */
    public List<SelectItem> getComboPaisEmbarque() {
        return comboPaisEmbarque;
    }

    /**
     * @param comboPaisEmbarque seta o novo valor para o campo comboPaisEmbarque
     */
    public void setComboPaisEmbarque(List<SelectItem> comboPaisEmbarque) {
        this.comboPaisEmbarque = comboPaisEmbarque;
    }

    /**
	 * @return o valor do comboPaisBeneficiario
	 */
	public List<SelectItem> getComboPaisBeneficiario() {
		return comboPaisBeneficiario;
	}

	/**
	 * @param comboPaisBeneficiario seta o novo valor para o campo comboPaisBeneficiario
	 */
	public void setComboPaisBeneficiario(List<SelectItem> comboPaisBeneficiario) {
		this.comboPaisBeneficiario = comboPaisBeneficiario;
	}

	/**
	 * @return o valor do comboMomento
	 */
	public List<SelectItem> getComboMomento() {
		return comboMomento;
	}

	/**
	 * @param comboMomento seta o novo valor para o campo comboMomento
	 */
	public void setComboMomento(List<SelectItem> comboMomento) {
		this.comboMomento = comboMomento;
	}

	/**
	 * @return o valor do comboCodBaseJuros
	 */
	public List<SelectItem> getComboCodBaseJuros() {
		return comboCodBaseJuros;
	}

	/**
	 * @param comboCodBaseJuros seta o novo valor para o campo comboCodBaseJuros
	 */
	public void setComboCodBaseJuros(List<SelectItem> comboCodBaseJuros) {
		this.comboCodBaseJuros = comboCodBaseJuros;
	}

	/**
	 * @return o valor do comboCodCobrancaComissao
	 */
	public List<SelectItem> getComboCodCobrancaComissao() {
		return comboCodCobrancaComissao;
	}

	/**
	 * @param comboCodCobrancaComissao seta o novo valor para o campo comboCodCobrancaComissao
	 */
	public void setComboCodCobrancaComissao(
			List<SelectItem> comboCodCobrancaComissao) {
		this.comboCodCobrancaComissao = comboCodCobrancaComissao;
	}

	/**
	 * @return o valor do comboCodComissaoSobre
	 */
	public List<SelectItem> getComboComissaoSobre() {
		return comboComissaoSobre;
	}

	/**
	 * @param comboCodComissaoSobre seta o novo valor para o campo comboCodComissaoSobre
	 */
	public void setComboComissaoSobre(List<SelectItem> comboCodComissaoSobre) {
		this.comboComissaoSobre = comboCodComissaoSobre;
	}

	/**
	 * @return o valor do comboTipoCotacao
	 */
	public List<SelectItem> getComboTipoCotacao() {
		return comboTipoCotacao;
	}

	/**
	 * @param comboTipoCotacao seta o novo valor para o campo comboTipoCotacao
	 */
	public void setComboTipoCotacao(List<SelectItem> comboTipoCotacao) {
		this.comboTipoCotacao = comboTipoCotacao;
	}

	/**
	 * @return o valor do comboCodigoPtax
	 */
	public List<SelectItem> getComboCodigoPtax() {
		return comboCodigoPtax;
	}

	/**
	 * @param comboCodigoPtax seta o novo valor para o campo comboCodigoPtax
	 */
	public void setComboCodigoPtax(List<SelectItem> comboCodigoPtax) {
		this.comboCodigoPtax = comboCodigoPtax;
	}

	/**
	 * @return o valor do comboPeriodicidade
	 */
	public List<SelectItem> getComboPeriodicidade() {
		return comboPeriodicidade;
	}

	/**
	 * @param comboPeriodicidadePrinc seta o novo valor para o campo comboPeriodicidadePrinc
	 */
	public void setComboPeriodicidadePrinc(List<SelectItem> comboPeriodicidadePrinc) {
		this.comboPeriodicidadePrinc = comboPeriodicidadePrinc;
	}
	
	/**
	 * @return o valor do comboPeriodicidade
	 */
	public List<SelectItem> getComboPeriodicidadePrinc() {
		return comboPeriodicidadePrinc;
	}

	/**
	 * @param comboPeriodicidade seta o novo valor para o campo comboPeriodicidade
	 */
	public void setComboPeriodicidade(List<SelectItem> comboPeriodicidade) {
		this.comboPeriodicidade = comboPeriodicidade;
	}

	/**
	 * @return o valor do comboTipoComissao
	 */
	public List<SelectItem> getComboTipoComissao() {
		return comboTipoComissao;
	}

	/**
	 * @param comboTipoComissao seta o novo valor para o campo comboTipoComissao
	 */
	public void setComboTipoComissao(List<SelectItem> comboTipoComissao) {
		this.comboTipoComissao = comboTipoComissao;
	}

	/**
	 * @return o valor do comboTarifas
	 */
	public List<SelectItem> getComboTarifas() {
		return comboTarifas;
	}

	/**
	 * @param comboTarifas seta o novo valor para o campo comboTarifas
	 */
	public void setComboTarifas(List<SelectItem> comboTarifas) {
		this.comboTarifas = comboTarifas;
	}

	/**
	 * @return o valor do comboPeriodoDaTaxa
	 */
	public List<SelectItem> getComboPeriodoDaTaxa() {
		return comboPeriodoDaTaxa;
	}

	/**
	 * @param comboPeriodoDaTaxa seta o novo valor para o campo comboPeriodoDaTaxa
	 */
	public void setComboPeriodoDaTaxa(List<SelectItem> comboPeriodoDaTaxa) {
		this.comboPeriodoDaTaxa = comboPeriodoDaTaxa;
	}
	public List<SelectItem> getComboPeriodoDaTaxa2() {
		return comboPeriodoDaTaxa2;
	}

	/**
	 * @param comboPeriodoDaTaxa seta o novo valor para o campo comboPeriodoDaTaxa
	 */
	public void setComboPeriodoDaTaxa2(List<SelectItem> comboPeriodoDaTaxa2) {
		this.comboPeriodoDaTaxa2 = comboPeriodoDaTaxa2;
	} 

	/**
	 * @return o valor do renderListaModalLimite
	 */
	public Boolean getRenderListaModalLimite() {
		return renderListaModalLimite;
	}

	/**
	 * @param renderListaModalLimite seta o novo valor para o campo renderListaModalLimite
	 */
	public void setRenderListaModalLimite(Boolean renderListaModalLimite) {
		this.renderListaModalLimite = renderListaModalLimite;
	}

	/**
	 * @return o valor do renderBtoConfirmar
	 */
	public Boolean getRenderBtoConfirmar() {
		return renderBtoConfirmar;
	}

	/**
	 * @param renderBtoConfirmar seta o novo valor para o campo renderBtoConfirmar
	 */
	public void setRenderBtoConfirmar(Boolean renderBtoConfirmar) {
		this.renderBtoConfirmar = renderBtoConfirmar;
	}

	/**
	 * @return o valor do renderBtoTrocarProdutoIncl
	 */
	public Boolean getRenderBtoTrocarProdutoIncl() {
		return renderBtoTrocarProdutoIncl;
	}

	/**
	 * @param renderBtoTrocarProdutoIncl seta o novo valor para o campo renderBtoTrocarProdutoIncl
	 */
	public void setRenderBtoTrocarProdutoIncl(Boolean renderBtoTrocarProdutoIncl) {
		this.renderBtoTrocarProdutoIncl = renderBtoTrocarProdutoIncl;
	}

	/**
	 * @return o valor do telaInicioNegociacao
	 */
	public boolean isTelaInicioNegociacao() {
		return telaInicioNegociacao;
	}

	/**
	 * @param telaInicioNegociacao seta o novo valor para o campo telaInicioNegociacao
	 */
	public void setTelaInicioNegociacao(boolean telaInicioNegociacao) {
		this.telaInicioNegociacao = telaInicioNegociacao;
	}

	/**
	 * @return o valor do renderDetalheCliente
	 */
	public Boolean getRenderDetalheCliente() {
		return renderDetalheCliente;
	}

	/**
	 * @param renderDetalheCliente seta o novo valor para o campo renderDetalheCliente
	 */
	public void setRenderDetalheCliente(Boolean renderDetalheCliente) {
		this.renderDetalheCliente = renderDetalheCliente;
	}

	/**
     * @return o valor do renderModalCliente
     */
    public Boolean getRenderModalCliente() {
        return renderModalCliente;
    }

    /**
     * @param renderModalCliente seta o novo valor para o campo renderModalCliente
     */
    public void setRenderModalCliente(Boolean renderModalCliente) {
        this.renderModalCliente = renderModalCliente;
    }

    /**
	 * @return o valor do renderModalUnidExt
	 */
	public Boolean getRenderModalUnidExt() {
		return renderModalUnidExt;
	}

	/**
	 * @param renderModalUnidExt seta o novo valor para o campo renderModalUnidExt
	 */
	public void setRenderModalUnidExt(Boolean renderModalUnidExt) {
		this.renderModalUnidExt = renderModalUnidExt;
	}

	/**
	 * @return o valor do renderModalLiborTravada
	 */
	public Boolean getRenderModalLiborTravada() {
		return renderModalLiborTravada;
	}

	/**
	 * @param renderModalLiborTravada seta o novo valor para o campo renderModalLiborTravada
	 */
	public void setRenderModalLiborTravada(Boolean renderModalLiborTravada) {
		this.renderModalLiborTravada = renderModalLiborTravada;
	}

	/**
	 * @return o valor do renderModalBeneficiario
	 */
	public Boolean getRenderModalBeneficiario() {
		return renderModalBeneficiario;
	}

	/**
	 * @param renderModalBeneficiario seta o novo valor para o campo renderModalBeneficiario
	 */
	public void setRenderModalBeneficiario(Boolean renderModalBeneficiario) {
		this.renderModalBeneficiario = renderModalBeneficiario;
	}

	/**
	 * @return o valor do renderModalMercadoria
	 */
	public Boolean getRenderModalMercadoria() {
		return renderModalMercadoria;
	}

	/**
	 * @param renderModalMercadoria seta o novo valor para o campo renderModalMercadoria
	 */
	public void setRenderModalMercadoria(Boolean renderModalMercadoria) {
		this.renderModalMercadoria = renderModalMercadoria;
	}

	/**
	 * @return o valor do renderModalOperacoesVinculadas
	 */
	public Boolean getRenderModalOperacoesVinculadas() {
		return renderModalOperacoesVinculadas;
	}

	/**
	 * @param renderModalOperacoesVinculadas seta o novo valor para o campo renderModalOperacoesVinculadas
	 */
	public void setRenderModalOperacoesVinculadas(
			Boolean renderModalOperacoesVinculadas) {
		this.renderModalOperacoesVinculadas = renderModalOperacoesVinculadas;
	}

	/**
	 * @return o valor do renderModalLimite
	 */
	public Boolean getRenderModalLimite() {
		return renderModalLimite;
	}

	/**
	 * @param renderModalLimite seta o novo valor para o campo renderModalLimite
	 */
	public void setRenderModalLimite(Boolean renderModalLimite) {
		this.renderModalLimite = renderModalLimite;
	}

	/**
	 * @return o valor do modalId
	 */
	public String getModalId() {
		return modalId;
	}

	/**
	 * @param modalId seta o novo valor para o campo modalId
	 */
	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	/**
	 * @return o valor do renderModalComissaoInterna
	 */
	public Boolean getRenderModalComissaoInterna() {
		return renderModalComissaoInterna;
	}

	/**
	 * @param renderModalComissaoInterna seta o novo valor para o campo renderModalComissaoInterna
	 */
	public void setRenderModalComissaoInterna(Boolean renderModalComissaoInterna) {
		this.renderModalComissaoInterna = renderModalComissaoInterna;
	}

	/**
	 * @return o valor do renderModalComissaoExterna
	 */
	public Boolean getRenderModalComissaoExterna() {
		return renderModalComissaoExterna;
	}

	/**
	 * @param renderModalComissaoExterna seta o novo valor para o campo renderModalComissaoExterna
	 */
	public void setRenderModalComissaoExterna(Boolean renderModalComissaoExterna) {
		this.renderModalComissaoExterna = renderModalComissaoExterna;
	}


	/**
	 * @return o valor do funcaoBotaoComissaoInterna
	 */
	public String getFuncaoBotaoComissaoInterna() {
		return funcaoBotaoComissaoInterna;
	}

	/**
	 * @param funcaoBotaoComissaoInterna seta o novo valor para o campo funcaoBotaoComissaoInterna
	 */
	public void setFuncaoBotaoComissaoInterna(String funcaoBotaoComissaoInterna) {
		this.funcaoBotaoComissaoInterna = funcaoBotaoComissaoInterna;
	}

	/**
	 * @return o valor do funcaoBotaoFluxo
	 */
	public String getFuncaoBotaoFluxo() {
		return funcaoBotaoFluxo;
	}

	/**
	 * @param funcaoBotaoFluxo seta o novo valor para o campo funcaoBotaoFluxo
	 */
	public void setFuncaoBotaoFluxo(String funcaoBotaoFluxo) {
		this.funcaoBotaoFluxo = funcaoBotaoFluxo;
	}

	/**
	 * @return o valor do itemSelecListaModalLimites
	 */
	public Integer getItemSelecListaModalLimites() {
		return itemSelecListaModalLimites;
	}

	/**
	 * @param itemSelecListaModalLimites seta o novo valor para o campo itemSelecListaModalLimites
	 */
	public void setItemSelecListaModalLimites(Integer itemSelecListaModalLimites) {
		this.itemSelecListaModalLimites = itemSelecListaModalLimites;
	}

	/**
	 * @return o valor do stateIdListaModalLimites
	 */
	public String getStateIdListaModalLimites() {
		return stateIdListaModalLimites;
	}

	/**
	 * @param stateIdListaModalLimites seta o novo valor para o campo stateIdListaModalLimites
	 */
	public void setStateIdListaModalLimites(String stateIdListaModalLimites) {
		this.stateIdListaModalLimites = stateIdListaModalLimites;
	}

	/**
	 * @return o valor do stateIdListaFluxos
	 */
	public String getStateIdListaFluxos() {
		return stateIdListaFluxos;
	}

	/**
	 * @param stateIdListaFluxos seta o novo valor para o campo stateIdListaFluxos
	 */
	public void setStateIdListaFluxos(String stateIdListaFluxos) {
		this.stateIdListaFluxos = stateIdListaFluxos;
	}

	/**
	 * @return o valor do stateIdListaFluxosComissao
	 */
	public String getStateIdListaFluxosComissao() {
		return stateIdListaFluxosComissao;
	}

	/**
	 * @param stateIdListaFluxosComissao seta o novo valor para o campo stateIdListaFluxosComissao
	 */
	public void setStateIdListaFluxosComissao(String stateIdListaFluxosComissao) {
		this.stateIdListaFluxosComissao = stateIdListaFluxosComissao;
	}

	/**
	 * @return o valor do stateIdListaMercadoria
	 */
	public String getStateIdListaMercadoria() {
		return stateIdListaMercadoria;
	}

	/**
	 * @param stateIdListaMercadoria seta o novo valor para o campo stateIdListaMercadoria
	 */
	public void setStateIdListaMercadoria(String stateIdListaMercadoria) {
		this.stateIdListaMercadoria = stateIdListaMercadoria;
	}

	/**
	 * @return o valor do stateIdListaModalOperVinculadas
	 */
	public String getStateIdListaModalOperVinculadas() {
		return stateIdListaModalOperVinculadas;
	}

	/**
	 * @param stateIdListaModalOperVinculadas seta o novo valor para o campo stateIdListaModalOperVinculadas
	 */
	public void setStateIdListaModalOperVinculadas(
			String stateIdListaModalOperVinculadas) {
		this.stateIdListaModalOperVinculadas = stateIdListaModalOperVinculadas;
	}

	/**
	 * @return o valor do stateIdListaOperacaoVinculada
	 */
	public String getStateIdListaOperacaoVinculada() {
		return stateIdListaOperacaoVinculada;
	}

	/**
	 * @param stateIdListaOperacaoVinculada seta o novo valor para o campo stateIdListaOperacaoVinculada
	 */
	public void setStateIdListaOperacaoVinculada(
			String stateIdListaOperacaoVinculada) {
		this.stateIdListaOperacaoVinculada = stateIdListaOperacaoVinculada;
	}

	/**
	 * @return o valor do stateIdListaTarifas
	 */
	public String getStateIdListaTarifas() {
		return stateIdListaTarifas;
	}

	/**
	 * @param stateIdListaTarifas seta o novo valor para o campo stateIdListaTarifas
	 */
	public void setStateIdListaTarifas(String stateIdListaTarifas) {
		this.stateIdListaTarifas = stateIdListaTarifas;
	}

	/**
	 * @return o valor do stateIdListaComissaoInterna
	 */
	public String getStateIdListaComissaoInterna() {
		return stateIdListaComissaoInterna;
	}

	/**
	 * @param stateIdListaComissaoInterna seta o novo valor para o campo stateIdListaComissaoInterna
	 */
	public void setStateIdListaComissaoInterna(String stateIdListaComissaoInterna) {
		this.stateIdListaComissaoInterna = stateIdListaComissaoInterna;
	}

	/**
	 * @return o valor do stateIdListaComissaoExterna
	 */
	public String getStateIdListaComissaoExterna() {
		return stateIdListaComissaoExterna;
	}

	/**
	 * @param stateIdListaComissaoExterna seta o novo valor para o campo stateIdListaComissaoExterna
	 */
	public void setStateIdListaComissaoExterna(String stateIdListaComissaoExterna) {
		this.stateIdListaComissaoExterna = stateIdListaComissaoExterna;
	}

	/**
	 * @return o valor do disabledCheckLibor
	 */
	public Boolean getDisabledCheckLibor() {
		return disabledCheckLibor;
	}

	/**
	 * @param disabledCheckLibor seta o novo valor para o campo disabledCheckLibor
	 */
	public void setDisabledCheckLibor(Boolean disabledCheckLibor) {
		this.disabledCheckLibor = disabledCheckLibor;
	}

	/**
	 * @return o valor do disabledCheckFluxo
	 */
	public Boolean getDisabledCheckFluxo() {
		return disabledCheckFluxo;
	}

	/**
	 * @param disabledCheckFluxo seta o novo valor para o campo disabledCheckFluxo
	 */
	public void setDisabledCheckFluxo(Boolean disabledCheckFluxo) {
		this.disabledCheckFluxo = disabledCheckFluxo;
	}

	/**
	 * @return o valor do disabledCheckMeMn
	 */
	public Boolean getDisabledCheckMeMn() {
		return disabledCheckMeMn;
	}

	/**
	 * @param disabledCheckMeMn seta o novo valor para o campo disabledCheckMeMn
	 */
	public void setDisabledCheckMeMn(Boolean disabledCheckMeMn) {
		this.disabledCheckMeMn = disabledCheckMeMn;
	}

	/**
	 * @return o valor do disabledComboPtax
	 */
	public Boolean getDisabledComboPtax() {
		return disabledComboPtax;
	}

	/**
	 * @param disabledComboPtax seta o novo valor para o campo disabledComboPtax
	 */
	public void setDisabledComboPtax(Boolean disabledComboPtax) {
		this.disabledComboPtax = disabledComboPtax;
	}

	/**
	 * @return o valor do disabledTxtSpreadAll
	 */
	public Boolean getDisabledTxtSpreadAll() {
		return disabledTxtSpreadAll;
	}

	/**
	 * @param disabledTxtSpreadAll seta o novo valor para o campo disabledTxtSpreadAll
	 */
	public void setDisabledTxtSpreadAll(Boolean disabledTxtSpreadAll) {
		this.disabledTxtSpreadAll = disabledTxtSpreadAll;
	}

	/**
	 * @return o valor do tdiamaxcredt
	 */
	public Integer getTdiamaxcredt() {
		return tdiamaxcredt;
	}

	/**
	 * @param tdiamaxcredt seta o novo valor para o campo tdiamaxcredt
	 */
	public void setTdiamaxcredt(Integer tdiamaxcredt) {
		this.tdiamaxcredt = tdiamaxcredt;
	}

	/**
	 * @return o valor do dataLimiteCotacao
	 */
	public Date getDataLimiteCotacao() {
		return dataLimiteCotacao;
	}

	/**
	 * @param dataLimiteCotacao seta o novo valor para o campo dataLimiteCotacao
	 */
	public void setDataLimiteCotacao(Date dataLimiteCotacao) {
		this.dataLimiteCotacao = dataLimiteCotacao;
	}

	/**
	 * @return o valor do valueMaisMenosFluxoPagto
	 */
	public String getValueMaisMenosFluxoPagto() {
		return valueMaisMenosFluxoPagto;
	}

	/**
	 * @param valueMaisMenosFluxoPagto seta o novo valor para o campo valueMaisMenosFluxoPagto
	 */
	public void setValueMaisMenosFluxoPagto(String valueMaisMenosFluxoPagto) {
		this.valueMaisMenosFluxoPagto = valueMaisMenosFluxoPagto;
	}

	/**
	 * @return o valor do valueMaisMenosPrecificacao
	 */
	public String getValueMaisMenosPrecificacao() {
		return valueMaisMenosPrecificacao;
	}

	/**
	 * @param valueMaisMenosPrecificacao seta o novo valor para o campo valueMaisMenosPrecificacao
	 */
	public void setValueMaisMenosPrecificacao(String valueMaisMenosPrecificacao) {
		this.valueMaisMenosPrecificacao = valueMaisMenosPrecificacao;
	}

	/**
	 * @return o valor do valueMaisMenosComissaoInterna
	 */
	public String getValueMaisMenosComissaoInterna() {
		return valueMaisMenosComissaoInterna;
	}

	/**
	 * @param valueMaisMenosComissaoInterna seta o novo valor para o campo valueMaisMenosComissaoInterna
	 */
	public void setValueMaisMenosComissaoInterna(
			String valueMaisMenosComissaoInterna) {
		this.valueMaisMenosComissaoInterna = valueMaisMenosComissaoInterna;
	}

	/**
     * @return o valor do valueMaisMenosDocumentosConsignados
     */
    public String getValueMaisMenosDocumentosConsignados() {
        return valueMaisMenosDocumentosConsignados;
    }

    /**
     * @param valueMaisMenosDocumentosConsignados seta o novo valor para o campo valueMaisMenosDocumentosConsignados
     */
    public void setValueMaisMenosDocumentosConsignados(String valueMaisMenosDocumentosConsignados) {
        this.valueMaisMenosDocumentosConsignados = valueMaisMenosDocumentosConsignados;
    }

    /**
     * @return o valor do valueMaisMenosContatoRetiradaGarantia
     */
    public String getValueMaisMenosContatoRetiradaGarantia() {
        return valueMaisMenosContatoRetiradaGarantia;
    }

    /**
     * @param valueMaisMenosContatoRetiradaGarantia seta o novo valor para o campo valueMaisMenosContatoRetiradaGarantia
     */
    public void setValueMaisMenosContatoRetiradaGarantia(String valueMaisMenosContatoRetiradaGarantia) {
        this.valueMaisMenosContatoRetiradaGarantia = valueMaisMenosContatoRetiradaGarantia;
    }

    /**
	 * @return o valor do valueMaisMenosMercadoria
	 */
	public String getValueMaisMenosMercadoria() {
		return valueMaisMenosMercadoria;
	}

	/**
	 * @param valueMaisMenosMercadoria seta o novo valor para o campo valueMaisMenosMercadoria
	 */
	public void setValueMaisMenosMercadoria(String valueMaisMenosMercadoria) {
		this.valueMaisMenosMercadoria = valueMaisMenosMercadoria;
	}

	/**
	 * @return o valor do valueMaisMenosOperacaoVinculada
	 */
	public String getValueMaisMenosOperacaoVinculada() {
		return valueMaisMenosOperacaoVinculada;
	}

	/**
	 * @param valueMaisMenosOperacaoVinculada seta o novo valor para o campo valueMaisMenosOperacaoVinculada
	 */
	public void setValueMaisMenosOperacaoVinculada(
			String valueMaisMenosOperacaoVinculada) {
		this.valueMaisMenosOperacaoVinculada = valueMaisMenosOperacaoVinculada;
	}

	/**
	 * @return o valor do valueMaisMenosResponsavelEmpresa
	 */
	public String getValueMaisMenosResponsavelEmpresa() {
		return valueMaisMenosResponsavelEmpresa;
	}

	/**
	 * @param valueMaisMenosResponsavelEmpresa seta o novo valor para o campo valueMaisMenosResponsavelEmpresa
	 */
	public void setValueMaisMenosResponsavelEmpresa(
			String valueMaisMenosResponsavelEmpresa) {
		this.valueMaisMenosResponsavelEmpresa = valueMaisMenosResponsavelEmpresa;
	}

	/**
	 * @return o valor do valueMaisMenosTarifas
	 */
	public String getValueMaisMenosTarifas() {
		return valueMaisMenosTarifas;
	}

	/**
	 * @param valueMaisMenosTarifas seta o novo valor para o campo valueMaisMenosTarifas
	 */
	public void setValueMaisMenosTarifas(String valueMaisMenosTarifas) {
		this.valueMaisMenosTarifas = valueMaisMenosTarifas;
	}

	/**
	 * @return o valor do valueMaisMenosComissao
	 */
	public String getValueMaisMenosComissao() {
		return valueMaisMenosComissao;
	}

	/**
	 * @param valueMaisMenosComissao seta o novo valor para o campo valueMaisMenosComissao
	 */
	public void setValueMaisMenosComissao(String valueMaisMenosComissao) {
		this.valueMaisMenosComissao = valueMaisMenosComissao;
	}

	/**
	 * @return o valor do renderFluxoPagto
	 */
	public Boolean getRenderFluxoPagto() {
		return renderFluxoPagto;
	}

	/**
	 * @param renderFluxoPagto seta o novo valor para o campo renderFluxoPagto
	 */
	public void setRenderFluxoPagto(Boolean renderFluxoPagto) {
		this.renderFluxoPagto = renderFluxoPagto;
	}

	/**
	 * @return o valor do renderPrecificacao
	 */
	public Boolean getRenderPrecificacao() {
		return renderPrecificacao;
	}

	/**
	 * @param renderPrecificacao seta o novo valor para o campo renderPrecificacao
	 */
	public void setRenderPrecificacao(Boolean renderPrecificacao) {
		this.renderPrecificacao = renderPrecificacao;
	}

	/**
	 * @return o valor do renderComissaoInterna
	 */
	public Boolean getRenderComissaoInterna() {
		return renderComissaoInterna;
	}

	/**
	 * @param renderComissaoInterna seta o novo valor para o campo renderComissaoInterna
	 */
	public void setRenderComissaoInterna(Boolean renderComissaoInterna) {
		this.renderComissaoInterna = renderComissaoInterna;
	}

	/**
     * @return o valor do renderDocumentosConsignados
     */
    public Boolean getRenderDocumentosConsignados() {
        return renderDocumentosConsignados;
    }

    /**
     * @param renderDocumentosConsignados seta o novo valor para o campo renderDocumentosConsignados
     */
    public void setRenderDocumentosConsignados(Boolean renderDocumentosConsignados) {
        this.renderDocumentosConsignados = renderDocumentosConsignados;
    }

    /**
     * @return o valor do renderContatoRetiradaGarantia
     */
    public Boolean getRenderContatoRetiradaGarantia() {
        return renderContatoRetiradaGarantia;
    }

    /**
     * @param renderContatoRetiradaGarantia seta o novo valor para o campo renderContatoRetiradaGarantia
     */
    public void setRenderContatoRetiradaGarantia(Boolean renderContatoRetiradaGarantia) {
        this.renderContatoRetiradaGarantia = renderContatoRetiradaGarantia;
    }

    /**
	 * @return o valor do renderMercadoria
	 */
	public Boolean getRenderMercadoria() {
		return renderMercadoria;
	}

	/**
	 * @param renderMercadoria seta o novo valor para o campo renderMercadoria
	 */
	public void setRenderMercadoria(Boolean renderMercadoria) {
		this.renderMercadoria = renderMercadoria;
	}

	/**
	 * @return o valor do renderOperacaoVinculada
	 */
	public Boolean getRenderOperacaoVinculada() {
		return renderOperacaoVinculada;
	}

	/**
	 * @param renderOperacaoVinculada seta o novo valor para o campo renderOperacaoVinculada
	 */
	public void setRenderOperacaoVinculada(Boolean renderOperacaoVinculada) {
		this.renderOperacaoVinculada = renderOperacaoVinculada;
	}

	/**
	 * @return o valor do renderResponsavelEmpresa
	 */
	public Boolean getRenderResponsavelEmpresa() {
		return renderResponsavelEmpresa;
	}

	/**
	 * @param renderResponsavelEmpresa seta o novo valor para o campo renderResponsavelEmpresa
	 */
	public void setRenderResponsavelEmpresa(Boolean renderResponsavelEmpresa) {
		this.renderResponsavelEmpresa = renderResponsavelEmpresa;
	}

	/**
	 * @return o valor do renderTarifas
	 */
	public Boolean getRenderTarifas() {
		return renderTarifas;
	}

	/**
	 * @param renderTarifas seta o novo valor para o campo renderTarifas
	 */
	public void setRenderTarifas(Boolean renderTarifas) {
		this.renderTarifas = renderTarifas;
	}

	/**
	 * @return o valor do renderComissao
	 */
	public Boolean getRenderComissao() {
		return renderComissao;
	}

	/**
	 * @param renderComissao seta o novo valor para o campo renderComissao
	 */
	public void setRenderComissao(Boolean renderComissao) {
		this.renderComissao = renderComissao;
	}

	/**
	 * @return o valor do itemSelecListaFluxosComissao
	 */
	public Integer getItemSelecListaFluxosComissao() {
		return itemSelecListaFluxosComissao;
	}

	/**
	 * @param itemSelecListaFluxosComissao seta o novo valor para o campo itemSelecListaFluxosComissao
	 */
	public void setItemSelecListaFluxosComissao(Integer itemSelecListaFluxosComissao) {
		this.itemSelecListaFluxosComissao = itemSelecListaFluxosComissao;
	}

	/**
	 * @return o valor do itemSelecListaMercadoria
	 */
	public Integer getItemSelecListaMercadoria() {
		return itemSelecListaMercadoria;
	}

	/**
	 * @param itemSelecListaMercadoria seta o novo valor para o campo itemSelecListaMercadoria
	 */
	public void setItemSelecListaMercadoria(Integer itemSelecListaMercadoria) {
		this.itemSelecListaMercadoria = itemSelecListaMercadoria;
	}

	/**
	 * @return o valor do itemSelecListaModalOperVinculadas
	 */
	public Integer[] getItemSelecListaModalOperVinculadas() {
		return itemSelecListaModalOperVinculadas;
	}

	/**
	 * @param itemSelecListaModalOperVinculadas seta o novo valor para o campo itemSelecListaModalOperVinculadas
	 */
	public void setItemSelecListaModalOperVinculadas(
			Integer[] itemSelecListaModalOperVinculadas) {
		this.itemSelecListaModalOperVinculadas = itemSelecListaModalOperVinculadas;
	}

	/**
	 * @return o valor do itemSelecListaOperacaoVinculada
	 */
	public Integer getItemSelecListaOperacaoVinculada() {
		return itemSelecListaOperacaoVinculada;
	}

	/**
	 * @param itemSelecListaOperacaoVinculada seta o novo valor para o campo itemSelecListaOperacaoVinculada
	 */
	public void setItemSelecListaOperacaoVinculada(
			Integer itemSelecListaOperacaoVinculada) {
		this.itemSelecListaOperacaoVinculada = itemSelecListaOperacaoVinculada;
	}

	/**
	 * @return o valor do itemSelecListaTarifas
	 */
	public String getItemSelecListaTarifas() {
		return itemSelecListaTarifas;
	}

	/**
	 * @param itemSelecListaTarifas seta o novo valor para o campo itemSelecListaTarifas
	 */
	public void setItemSelecListaTarifas(String itemSelecListaTarifas) {
		this.itemSelecListaTarifas = itemSelecListaTarifas;
	}

	/**
	 * @return o valor do itemSelecListaComissaoInterna
	 */
	public Integer getItemSelecListaComissaoInterna() {
		return itemSelecListaComissaoInterna;
	}

	/**
	 * @param itemSelecListaComissaoInterna seta o novo valor para o campo itemSelecListaComissaoInterna
	 */
	public void setItemSelecListaComissaoInterna(
			Integer itemSelecListaComissaoInterna) {
		this.itemSelecListaComissaoInterna = itemSelecListaComissaoInterna;
	}

	/**
	 * @return o valor do itemSelecListaComissaoExterna
	 */
	public String getItemSelecListaComissaoExterna() {
		return itemSelecListaComissaoExterna;
	}

	/**
	 * @param itemSelecListaComissaoExterna seta o novo valor para o campo itemSelecListaComissaoExterna
	 */
	public void setItemSelecListaComissaoExterna(
			String itemSelecListaComissaoExterna) {
		this.itemSelecListaComissaoExterna = itemSelecListaComissaoExterna;
	}

	/**
	 * @return o valor do codCpfCnpjSelecionado
	 */
	public Integer getCodCpfCnpjSelecionado() {
		return codCpfCnpjSelecionado;
	}

	/**
	 * @param codCpfCnpjSelecionado seta o novo valor para o campo codCpfCnpjSelecionado
	 */
	public void setCodCpfCnpjSelecionado(Integer codCpfCnpjSelecionado) {
		this.codCpfCnpjSelecionado = codCpfCnpjSelecionado;
	}

	/**
     * @return o valor do codCpfCnpjDepositarioSelecionado
     */
    public Integer getCodCpfCnpjDepositarioSelecionado() {
        return codCpfCnpjDepositarioSelecionado;
    }

    /**
     * @param codCpfCnpjDepositarioSelecionado seta o novo valor para o campo codCpfCnpjDepositarioSelecionado
     */
    public void setCodCpfCnpjDepositarioSelecionado(Integer codCpfCnpjDepositarioSelecionado) {
        this.codCpfCnpjDepositarioSelecionado = codCpfCnpjDepositarioSelecionado;
    }

    /**
	 * @return o valor do txtUnidExterna
	 */
	public String getTxtUnidExterna() {
		return txtUnidExterna;
	}

	/**
	 * @param txtUnidExterna seta o novo valor para o campo txtUnidExterna
	 */
	public void setTxtUnidExterna(String txtUnidExterna) {
		this.txtUnidExterna = txtUnidExterna;
	}

	/**
	 * @return o valor do liborTravada
	 */
	public String getLiborTravada() {
		return liborTravada;
	}

	/**
	 * @param liborTravada seta o novo valor para o campo liborTravada
	 */
	public void setLiborTravada(String liborTravada) {
		this.liborTravada = liborTravada;
	}

	/**
	 * @return o valor do itemSelecListaSelCliente
	 */
	public Integer getItemSelecListaSelCliente() {
		return itemSelecListaSelCliente;
	}

	/**
	 * @param itemSelecListaSelCliente seta o novo valor para o campo itemSelecListaSelCliente
	 */
	public void setItemSelecListaSelCliente(Integer itemSelecListaSelCliente) {
		this.itemSelecListaSelCliente = itemSelecListaSelCliente;
	}

	/**
	 * @return o valor do itemSelecListaBeneficiario
	 */
	public Integer getItemSelecListaBeneficiario() {
		return itemSelecListaBeneficiario;
	}

	/**
	 * @param itemSelecListaBeneficiario seta o novo valor para o campo itemSelecListaBeneficiario
	 */
	public void setItemSelecListaBeneficiario(Integer itemSelecListaBeneficiario) {
		this.itemSelecListaBeneficiario = itemSelecListaBeneficiario;
	}

	/**
	 * @return o valor do itemSelecListaUnidExt
	 */
	public Integer getItemSelecListaUnidExt() {
		return itemSelecListaUnidExt;
	}

	/**
	 * @param itemSelecListaUnidExt seta o novo valor para o campo itemSelecListaUnidExt
	 */
	public void setItemSelecListaUnidExt(Integer itemSelecListaUnidExt) {
		this.itemSelecListaUnidExt = itemSelecListaUnidExt;
	}

	/**
	 * @return o valor do nomeStateIdListaSelCliente
	 */
	public String getNomeStateIdListaSelCliente() {
		return nomeStateIdListaSelCliente;
	}

	/**
	 * @param nomeStateIdListaSelCliente seta o novo valor para o campo nomeStateIdListaSelCliente
	 */
	public void setNomeStateIdListaSelCliente(String nomeStateIdListaSelCliente) {
		this.nomeStateIdListaSelCliente = nomeStateIdListaSelCliente;
	}

	/**
	 * @return o valor do nomeStateIdListaSelUnidExt
	 */
	public String getNomeStateIdListaSelUnidExt() {
		return nomeStateIdListaSelUnidExt;
	}

	/**
	 * @param nomeStateIdListaSelUnidExt seta o novo valor para o campo nomeStateIdListaSelUnidExt
	 */
	public void setNomeStateIdListaSelUnidExt(String nomeStateIdListaSelUnidExt) {
		this.nomeStateIdListaSelUnidExt = nomeStateIdListaSelUnidExt;
	}

	/**
	 * @return o valor do nomeStateIdListaSelBeneficiario
	 */
	public String getNomeStateIdListaSelBeneficiario() {
		return nomeStateIdListaSelBeneficiario;
	}

	/**
	 * @param nomeStateIdListaSelBeneficiario seta o novo valor para o campo nomeStateIdListaSelBeneficiario
	 */
	public void setNomeStateIdListaSelBeneficiario(
			String nomeStateIdListaSelBeneficiario) {
		this.nomeStateIdListaSelBeneficiario = nomeStateIdListaSelBeneficiario;
	}

	/**
	 * @return o valor do nomeStateIdListaSelMercadoria
	 */
	public String getNomeStateIdListaSelMercadoria() {
		return nomeStateIdListaSelMercadoria;
	}

	/**
	 * @param nomeStateIdListaSelMercadoria seta o novo valor para o campo nomeStateIdListaSelMercadoria
	 */
	public void setNomeStateIdListaSelMercadoria(
			String nomeStateIdListaSelMercadoria) {
		this.nomeStateIdListaSelMercadoria = nomeStateIdListaSelMercadoria;
	}

	/**
	 * @return o valor do stateIdListaParcelasFluxoPgto
	 */
	public String getStateIdListaParcelasFluxoPgto() {
		return stateIdListaParcelasFluxoPgto;
	}

	/**
	 * @param stateIdListaParcelasFluxoPgto seta o novo valor para o campo stateIdListaParcelasFluxoPgto
	 */
	public void setStateIdListaParcelasFluxoPgto(
			String stateIdListaParcelasFluxoPgto) {
		this.stateIdListaParcelasFluxoPgto = stateIdListaParcelasFluxoPgto;
	}

	/**
	 * @return o valor do stateIdListaParcelasComissao
	 */
	public String getStateIdListaParcelasComissao() {
		return stateIdListaParcelasComissao;
	}

	/**
	 * @param stateIdListaParcelasComissao seta o novo valor para o campo stateIdListaParcelasComissao
	 */
	public void setStateIdListaParcelasComissao(String stateIdListaParcelasComissao) {
		this.stateIdListaParcelasComissao = stateIdListaParcelasComissao;
	}

	/**
     * @return o valor do stateIdListaParcelas
     */
    public String getStateIdListaParcelas() {
        return stateIdListaParcelas;
    }

    /**
     * @param stateIdListaParcelas seta o novo valor para o campo stateIdListaParcelas
     */
    public void setStateIdListaParcelas(String stateIdListaParcelas) {
        this.stateIdListaParcelas = stateIdListaParcelas;
    }

    /**
     * @return o valor do stateIdListaDespesas
     */
    public String getStateIdListaDespesas() {
        return stateIdListaDespesas;
    }

    /**
     * @param stateIdListaDespesas seta o novo valor para o campo stateIdListaDespesas
     */
    public void setStateIdListaDespesas(String stateIdListaDespesas) {
        this.stateIdListaDespesas = stateIdListaDespesas;
    }

    /**
     * @return o valor do stateIdListaRespDesp
     */
    public String getStateIdListaRespDesp() {
        return stateIdListaRespDesp;
    }

    /**
     * @param stateIdListaRespDesp seta o novo valor para o campo stateIdListaRespDesp
     */
    public void setStateIdListaRespDesp(String stateIdListaRespDesp) {
        this.stateIdListaRespDesp = stateIdListaRespDesp;
    }

    /**
	 * @return o valor do campoCodigoDescricao
	 */
	public UIInputTextBradesco getCampoCodigoDescricao() {
		return campoCodigoDescricao;
	}

	/**
	 * @param campoCodigoDescricao seta o novo valor para o campo campoCodigoDescricao
	 */
	public void setCampoCodigoDescricao(UIInputTextBradesco campoCodigoDescricao) {
		this.campoCodigoDescricao = campoCodigoDescricao;
	}
    /**
	 * @return o valor do nomeMoedaDesembolso
	 */
	public String getNomeMoedaDesembolso() {
		return nomeMoedaDesembolso;
	}

	/**
	 * @param nomeMoedaDesembolso seta o novo valor para o campo nomeMoedaDesembolso
	 */
	public void setNomeMoedaDesembolso(String nomeMoedaDesembolso) {
		this.nomeMoedaDesembolso = nomeMoedaDesembolso;
	}

	/**
	 * @return o valor do nomeMoedaComissaoInterna
	 */
	public String getNomeMoedaComissaoInterna() {
		return nomeMoedaComissaoInterna;
	}

	/**
	 * @param nomeMoedaComissaoInterna seta o novo valor para o campo nomeMoedaComissaoInterna
	 */
	public void setNomeMoedaComissaoInterna(String nomeMoedaComissaoInterna) {
		this.nomeMoedaComissaoInterna = nomeMoedaComissaoInterna;
	}

	/**
	 * @return o valor do tipoCobrancaComissao
	 */
	public Integer getTipoCobrancaComissao() {
		return tipoCobrancaComissao;
	}

	/**
	 * @param tipoCobrancaComissao seta o novo valor para o campo tipoCobrancaComissao
	 */
	public void setTipoCobrancaComissao(Integer tipoCobrancaComissao) {
		this.tipoCobrancaComissao = tipoCobrancaComissao;
	}

	/**
	 * @return o valor do valueComissaoCobranca
	 */
	public String getValueComissaoCobranca() {
		return valueComissaoCobranca;
	}

	/**
	 * @param valueComissaoCobranca seta o novo valor para o campo valueComissaoCobranca
	 */
	public void setValueComissaoCobranca(String valueComissaoCobranca) {
		this.valueComissaoCobranca = valueComissaoCobranca;
	}

    /**
	 * @return o valor do codMoedaComissao
	 */
	public Integer getCodMoedaComissao() {
		return codMoedaComissao;
	}

	/**
	 * @param codMoedaComissao seta o novo valor para o campo codMoedaComissao
	 */
	public void setCodMoedaComissao(Integer codMoedaComissao) {
		this.codMoedaComissao = codMoedaComissao;
	}

	/**
	 * @return o valor do codComissaoSobre
	 */
	public Integer getCodComissaoSobre() {
		return codComissaoSobre;
	}

	/**
	 * @param codComissaoSobre seta o novo valor para o campo codComissaoSobre
	 */
	public void setCodComissaoSobre(Integer codComissaoSobre) {
		this.codComissaoSobre = codComissaoSobre;
	}

	/**
	 * @return o valor do codTarifa
	 */
	public Integer getCodTarifa() {
		return codTarifa;
	}

	/**
	 * @param codTarifa seta o novo valor para o campo codTarifa
	 */
	public void setCodTarifa(Integer codTarifa) {
		this.codTarifa = codTarifa;
	}

	/**
	 * @return o valor do disabledTxtParcelaComissaoExt
	 */
	public Boolean getDisabledTxtParcelaComissaoExt() {
		return disabledTxtParcelaComissaoExt;
	}

	/**
	 * @param disabledTxtParcelaComissaoExt seta o novo valor para o campo disabledTxtParcelaComissaoExt
	 */
	public void setDisabledTxtParcelaComissaoExt(
			Boolean disabledTxtParcelaComissaoExt) {
		this.disabledTxtParcelaComissaoExt = disabledTxtParcelaComissaoExt;
	}

	/**
	 * @return o valor do przomediooperd
	 */
	public Integer getPrzomediooperd() {
		return przomediooperd;
	}

	/**
	 * @param przomediooperd seta o novo valor para o campo przomediooperd
	 */
	public void setPrzomediooperd(Integer przomediooperd) {
		this.przomediooperd = przomediooperd;
	}

	/**
	 * @return o valor do przomedioopera
	 */
	public String getPrzomedioopera() {
		return przomedioopera;
	}

	/**
	 * @param przomedioopera seta o novo valor para o campo przomedioopera
	 */
	public void setPrzomedioopera(String przomedioopera) {
		this.przomedioopera = przomedioopera;
	}

	/**
	 * @return o valor do statusCotacao
	 */
	public String getStatusCotacao() {
		return statusCotacao;
	}

	/**
	 * @param statusCotacao seta o novo valor para o campo statusCotacao
	 */
	public void setStatusCotacao(String statusCotacao) {
		this.statusCotacao = statusCotacao;
	}

    /**
     * @return o valor do renderIrIof
     */
    public Boolean getRenderIrIof() {
        return renderIrIof;
    }

    /**
     * @param renderIrIof seta o novo valor para o campo renderIrIof
     */
    public void setRenderIrIof(Boolean renderIrIof) {
        this.renderIrIof = renderIrIof;
    }

    /**
     * @return o valor do disabledModalComissaoInt
     */
    public Boolean getDisabledModalComissaoInt() {
        return disabledModalComissaoInt;
    }

    /**
     * @param disabledModalComissaoInt seta o novo valor para o campo disabledModalComissaoInt
     */
    public void setDisabledModalComissaoInt(Boolean disabledModalComissaoInt) {
        this.disabledModalComissaoInt = disabledModalComissaoInt;
    }

    /**
     * @return o valor do disabledModalComissaoExt
     */
    public Boolean getDisabledModalComissaoExt() {
        return disabledModalComissaoExt;
    }

    /**
     * @param disabledModalComissaoExt seta o novo valor para o campo disabledModalComissaoExt
     */
    public void setDisabledModalComissaoExt(Boolean disabledModalComissaoExt) {
        this.disabledModalComissaoExt = disabledModalComissaoExt;
    }

    /**
     * @return o valor do renderAbout
     */
    public Boolean getRenderAbout() {
        return renderAbout;
    }

    /**
     * @param renderAbout seta o novo valor para o campo renderAbout
     */
    public void setRenderAbout(Boolean renderAbout) {
        this.renderAbout = renderAbout;
    }

    /**
     * @return o valor do renderSeguroBenef
     */
    public Boolean getRenderSeguroBenef() {
        return renderSeguroBenef;
    }

    /**
     * @param renderSeguroBenef seta o novo valor para o campo renderSeguroBenef
     */
    public void setRenderSeguroBenef(Boolean renderSeguroBenef) {
        this.renderSeguroBenef = renderSeguroBenef;
    }

    /**
     * @return o valor do datePrevDesembolso
     */
    public Date getDatePrevDesembolso() {
        return datePrevDesembolso;
    }

    /**
     * @param datePrevDesembolso seta o novo valor para o campo datePrevDesembolso
     */
    public void setDatePrevDesembolso(Date datePrevDesembolso) {
        this.datePrevDesembolso = datePrevDesembolso;
    }

    /**
     * @return o valor do telaRetorno
     */
    public String getTelaRetorno() {
        return telaRetorno;
    }

    /**
     * @param telaRetorno seta o novo valor para o campo telaRetorno
     */
    public void setTelaRetorno(String telaRetorno) {
        this.telaRetorno = telaRetorno;
    }

    /**
     * @return o valor do dateFluxoPgtoTemp
     */
    public Date getDateFluxoPgtoTemp() {
        return dateFluxoPgtoTemp;
    }

    /**
     * @param dateFluxoPgtoTemp seta o novo valor para o campo dateFluxoPgtoTemp
     */
    public void setDateFluxoPgtoTemp(Date dateFluxoPgtoTemp) {
        this.dateFluxoPgtoTemp = dateFluxoPgtoTemp;
    }

    /**
     * @return o valor do itemSelecListaFluxos
     */
    public String getItemSelecListaFluxos() {
        return itemSelecListaFluxos;
    }

    /**
     * @param itemSelecListaFluxos seta o novo valor para o campo itemSelecListaFluxos
     */
    public void setItemSelecListaFluxos(String itemSelecListaFluxos) {
        this.itemSelecListaFluxos = itemSelecListaFluxos;
    }
    
	public Boolean getClienteEditavel() {
		return clienteEditavel;
	}

	public void setClienteEditavel(Boolean clienteEditavel) {
		this.clienteEditavel = clienteEditavel;
	}

	public List<SelectItem> getComboDesembolsoOri() {
		return comboDesembolsoOri;
	}

	public void setComboDesembolsoOri(List<SelectItem> comboDesembolsoOri) {
		this.comboDesembolsoOri = comboDesembolsoOri;
	}

	public Boolean getProrrogarPPE() {
		return prorrogarPPE;
	}

	public void setProrrogarPPE(Boolean prorrogarPPE) {
		this.prorrogarPPE = prorrogarPPE;
	}

	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	public Boolean getDesabilitaCamposPrrg() {
		return desabilitaCamposPrrg;
	}

	public void setDesabilitaCamposPrrg(Boolean desabilitaCamposPrrg) {
		this.desabilitaCamposPrrg = desabilitaCamposPrrg;
	}

    /**
     * @return o valor do itemSelecListaDesembolso
     */
    public Integer getItemSelecListaDesembolso() {
        return itemSelecListaDesembolso;
    }

    /**
     * @param itemSelecListaDesembolso seta o novo valor para o campo itemSelecListaDesembolso
     */
    public void setItemSelecListaDesembolso(Integer itemSelecListaDesembolso) {
        this.itemSelecListaDesembolso = itemSelecListaDesembolso;
    }

	public Date getDateProrrogacao() {
		return dateProrrogacao;
	}

	public void setDateProrrogacao(Date dateProrrogacao) {
		this.dateProrrogacao = dateProrrogacao;
	}

    /**
     * @return o valor do mensagemFluxoValidacao
     */
    public String getMensagemFluxoValidacao() {
        return mensagemFluxoValidacao;
    }

    /**
     * @param mensagemFluxoValidacao seta o novo valor para o campo mensagemFluxoValidacao
     */
    public void setMensagemFluxoValidacao(String mensagemFluxoValidacao) {
        this.mensagemFluxoValidacao = mensagemFluxoValidacao;
    }

    /**
     * @return o valor do renderModalAlerta
     */
    public Boolean getRenderModalAlerta() {
        return renderModalAlerta;
    }

    /**
     * @param renderModalAlerta seta o novo valor para o campo renderModalAlerta
     */
    public void setRenderModalAlerta(Boolean renderModalAlerta) {
        this.renderModalAlerta = renderModalAlerta;
    }

    /**
     * @return o valor do tipoAcesso
     */
    public Integer getTipoAcesso() {
        return tipoAcesso;
    }

    /**
     * @param tipoAcesso seta o novo valor para o campo tipoAcesso
     */
    public void setTipoAcesso(Integer tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    /**
     * @return o valor do nomeTomador
     */
    public String getNomeTomador() {
        return nomeTomador;
    }

    /**
     * @param nomeTomador seta o novo valor para o campo nomeTomador
     */
    public void setNomeTomador(String nomeTomador) {
        this.nomeTomador = nomeTomador;
    }
    
    /**
     * @return o valor do checkPercCDI
     */
    public boolean isCheckPercCDI() {
        return checkPercCDI;
    }

    /**
     * @param checkPercCDI seta o novo valor para o campo checkPercCDI
     */
    public void setCheckPercCDI(boolean checkPercCDI) {
        this.checkPercCDI = checkPercCDI;
    }

    /**
     * @return o valor do checkMaisCDI
     */
    public boolean isCheckMaisCDI() {
        return checkMaisCDI;
    }

    /**
     * @param checkMaisCDI seta o novo valor para o campo checkMaisCDI
     */
    public void setCheckMaisCDI(boolean checkMaisCDI) {
        this.checkMaisCDI = checkMaisCDI;
    }

    /**
     * @return o valor do checkTaxaPre
     */
    public boolean isCheckTaxaPre() {
        return checkTaxaPre;
    }

    /**
     * @param checkTaxaPre seta o novo valor para o campo checkTaxaPre
     */
    public void setCheckTaxaPre(boolean checkTaxaPre) {
        this.checkTaxaPre = checkTaxaPre;
    }

    /**
     * @return o valor do disabledCheckPercCDI
     */
    public boolean isDisabledCheckPercCDI() {
        return disabledCheckPercCDI;
    }

    /**
     * @param disabledCheckPercCDI seta o novo valor para o campo disabledCheckPercCDI
     */
    public void setDisabledCheckPercCDI(boolean disabledCheckPercCDI) {
        this.disabledCheckPercCDI = disabledCheckPercCDI;
    }

    /**
     * @return o valor do disabledCheckMaisCDI
     */
    public boolean isDisabledCheckMaisCDI() {
        return disabledCheckMaisCDI;
    }

    /**
     * @param disabledCheckMaisCDI seta o novo valor para o campo disabledCheckMaisCDI
     */
    public void setDisabledCheckMaisCDI(boolean disabledCheckMaisCDI) {
        this.disabledCheckMaisCDI = disabledCheckMaisCDI;
    }

    /**
     * @return o valor do disabledCheckTaxaPre
     */
    public boolean isDisabledCheckTaxaPre() {
        return disabledCheckTaxaPre;
    }

    /**
     * @param disabledCheckTaxaPre seta o novo valor para o campo disabledCheckTaxaPre
     */
    public void setDisabledCheckTaxaPre(boolean disabledCheckTaxaPre) {
        this.disabledCheckTaxaPre = disabledCheckTaxaPre;
    }

    /**
     * @return o valor do disabledPercCDI
     */
    public boolean isDisabledPercCDI() {
        return disabledPercCDI;
    }

    /**
     * @param disabledPercCDI seta o novo valor para o campo disabledPercCDI
     */
    public void setDisabledPercCDI(boolean disabledPercCDI) {
        this.disabledPercCDI = disabledPercCDI;
    }

    /**
     * @return o valor do disabledMaisCDI
     */
    public boolean isDisabledMaisCDI() {
        return disabledMaisCDI;
    }

    /**
     * @param disabledMaisCDI seta o novo valor para o campo disabledMaisCDI
     */
    public void setDisabledMaisCDI(boolean disabledMaisCDI) {
        this.disabledMaisCDI = disabledMaisCDI;
    }

    /**
     * @return o valor do disabledTaxaPre
     */
    public boolean isDisabledTaxaPre() {
        return disabledTaxaPre;
    }

    /**
     * @param disabledTaxaPre seta o novo valor para o campo disabledTaxaPre
     */
    public void setDisabledTaxaPre(boolean disabledTaxaPre) {
        this.disabledTaxaPre = disabledTaxaPre;
    }

    /**
     * @return o valor do disabledGarantidor
     */
    public boolean isDisabledGarantidor() {
        return disabledGarantidor;
    }

    /**
     * @param disabledGarantidor seta o novo valor para o campo disabledGarantidor
     */
    public void setDisabledGarantidor(boolean disabledGarantidor) {
        this.disabledGarantidor = disabledGarantidor;
    }

    /**
     * @return o valor do disabledRadioTaxaPre
     */
    public boolean isDisabledRadioTaxaPre() {
        return disabledRadioTaxaPre;
    }

    /**
     * @param disabledRadioTaxaPre seta o novo valor para o campo disabledRadioTaxaPre
     */
    public void setDisabledRadioTaxaPre(boolean disabledRadioTaxaPre) {
        this.disabledRadioTaxaPre = disabledRadioTaxaPre;
    }

    /**
     * @return o valor do codRebateSelecionado
     */
    public String getCodRebateSelecionado() {
        return codRebateSelecionado;
    }

    /**
     * @param codRebateSelecionado seta o novo valor para o campo codRebateSelecionado
     */
    public void setCodRebateSelecionado(String codRebateSelecionado) {
        this.codRebateSelecionado = codRebateSelecionado;
    }

    /**
     * @return o valor do codTaxaDescontoSelecionado
     */
    public String getCodTaxaDescontoSelecionado() {
        return codTaxaDescontoSelecionado;
    }

    /**
     * @param codTaxaDescontoSelecionado seta o novo valor para o campo codTaxaDescontoSelecionado
     */
    public void setCodTaxaDescontoSelecionado(String codTaxaDescontoSelecionado) {
        this.codTaxaDescontoSelecionado = codTaxaDescontoSelecionado;
    }

    /**
     * @return o valor do ctrBotaoFluxo
     */
    public Integer getCtrBotaoFluxo() {
        return ctrBotaoFluxo;
    }

    /**
     * @param ctrBotaoFluxo seta o novo valor para o campo ctrBotaoFluxo
     */
    public void setCtrBotaoFluxo(Integer ctrBotaoFluxo) {
        this.ctrBotaoFluxo = ctrBotaoFluxo;
    }

    /**
     * @return o valor do comboMoedaEqualizavel
     */
    public List<SelectItem> getComboMoedaEqualizavel() {
        return comboMoedaEqualizavel;
    }

    /**
     * @param comboMoedaEqualizavel seta o novo valor para o campo comboMoedaEqualizavel
     */
    public void setComboMoedaEqualizavel(List<SelectItem> comboMoedaEqualizavel) {
        this.comboMoedaEqualizavel = comboMoedaEqualizavel;
    }

    /**
     * @return o valor do comboMoedaReceita
     */
    public List<SelectItem> getComboMoedaReceita() {
        return comboMoedaReceita;
    }

    /**
     * @param comboMoedaReceita seta o novo valor para o campo comboMoedaReceita
     */
    public void setComboMoedaReceita(List<SelectItem> comboMoedaReceita) {
        this.comboMoedaReceita = comboMoedaReceita;
    }

    /**
     * @return o valor do dateVencFianc
     */
    public Date getDateVencFianc() {
        return dateVencFianc;
    }

    /**
     * @param dateVencFianc seta o novo valor para o campo dateVencFianc
     */
    public void setDateVencFianc(Date dateVencFianc) {
        this.dateVencFianc = dateVencFianc;
    }
    

    /**
     * @return o valor do comboModalidade
     */
    public List<SelectItem> getComboModalidade() {
        return comboModalidade;
    }

    /**
     * @param comboModalidade seta o novo valor para o campo comboModalidade
     */
    public void setComboModalidade(List<SelectItem> comboModalidade) {
        this.comboModalidade = comboModalidade;
    }

    /**
     * @return o valor do comboPrazo
     */
    public List<SelectItem> getComboPrazo() {
        return comboPrazo;
    }

    /**
     * @param comboPrazo seta o novo valor para o campo comboPrazo
     */
    public void setComboPrazo(List<SelectItem> comboPrazo) {
        this.comboPrazo = comboPrazo;
    }

    /**
     * @return o valor do comboAVistaPrazo
     */
    public List<SelectItem> getComboAVistaPrazo() {
        return comboAVistaPrazo;
    }

    /**
     * @param comboAVistaPrazo seta o novo valor para o campo comboAVistaPrazo
     */
    public void setComboAVistaPrazo(List<SelectItem> comboAVistaPrazo) {
        this.comboAVistaPrazo = comboAVistaPrazo;
    }

    /**
     * @return o valor do comboPorConta
     */
    public List<SelectItem> getComboPorConta() {
        return comboPorConta;
    }

    /**
     * @param comboPorConta seta o novo valor para o campo comboPorConta
     */
    public void setComboPorConta(List<SelectItem> comboPorConta) {
        this.comboPorConta = comboPorConta;
    }

    /**
     * @return o valor do comboTipoDespesas
     */
    public List<SelectItem> getComboTipoDespesas() {
        return comboTipoDespesas;
    }

    /**
     * @param comboTipoDespesas seta o novo valor para o campo comboTipoDespesas
     */
    public void setComboTipoDespesas(List<SelectItem> comboTipoDespesas) {
        this.comboTipoDespesas = comboTipoDespesas;
    }

    /**
     * @return o valor do comboDocumentosConsignados
     */
    public List<SelectItem> getComboDocumentosConsignados() {
        return comboDocumentosConsignados;
    }

    /**
     * @param comboDocumentosConsignados seta o novo valor para o campo comboDocumentosConsignados
     */
    public void setComboDocumentosConsignados(List<SelectItem> comboDocumentosConsignados) {
        this.comboDocumentosConsignados = comboDocumentosConsignados;
    }

    /**
     * @return o valor do dataLimiteFRO
     */
    public Date getDataLimiteFRO() {
        return dataLimiteFRO;
    }

    /**
     * @param dataLimiteFRO seta o novo valor para o campo dataLimiteFRO
     */
    public void setDataLimiteFRO(Date dataLimiteFRO) {
        this.dataLimiteFRO = dataLimiteFRO;
    }

    /**
     * @return o valor do dataVencProposta
     */
    public Date getDataVencProposta() {
        return dataVencProposta;
    }

    /**
     * @param dataVencProposta seta o novo valor para o campo dataVencProposta
     */
    public void setDataVencProposta(Date dataVencProposta) {
        this.dataVencProposta = dataVencProposta;
    }

    /**
     * @return o valor do periodoEmbarqueIni
     */
    public Date getPeriodoEmbarqueIni() {
        return periodoEmbarqueIni;
    }

    /**
     * @param periodoEmbarqueIni seta o novo valor para o campo periodoEmbarqueIni
     */
    public void setPeriodoEmbarqueIni(Date periodoEmbarqueIni) {
        this.periodoEmbarqueIni = periodoEmbarqueIni;
    }

    /**
     * @return o valor do periodoEmbarqueFim
     */
    public Date getPeriodoEmbarqueFim() {
        return periodoEmbarqueFim;
    }

    /**
     * @param periodoEmbarqueFim seta o novo valor para o campo periodoEmbarqueFim
     */
    public void setPeriodoEmbarqueFim(Date periodoEmbarqueFim) {
        this.periodoEmbarqueFim = periodoEmbarqueFim;
    }

    /**
     * @return o valor do disabledTxtParcelaFlxPgtPrinc
     */
    public boolean isDisabledTxtParcelaFlxPgtPrinc() {
        return disabledTxtParcelaFlxPgtPrinc;
    }

    /**
     * @param disabledTxtParcelaFlxPgtPrinc seta o novo valor para o campo disabledTxtParcelaFlxPgtPrinc
     */
    public void setDisabledTxtParcelaFlxPgtPrinc(boolean disabledTxtParcelaFlxPgtPrinc) {
        this.disabledTxtParcelaFlxPgtPrinc = disabledTxtParcelaFlxPgtPrinc;
    }

    /**
     * @return o valor do disabledTxtParcelaFlxPgtJuros
     */
    public boolean isDisabledTxtParcelaFlxPgtJuros() {
        return disabledTxtParcelaFlxPgtJuros;
    }

    /**
     * @param disabledTxtParcelaFlxPgtJuros seta o novo valor para o campo disabledTxtParcelaFlxPgtJuros
     */
    public void setDisabledTxtParcelaFlxPgtJuros(boolean disabledTxtParcelaFlxPgtJuros) {
        this.disabledTxtParcelaFlxPgtJuros = disabledTxtParcelaFlxPgtJuros;
    }

    /**
     * @return o valor do itemSelecListaParcelas
     */
    public Integer getItemSelecListaParcelas() {
        return itemSelecListaParcelas;
    }

    /**
     * @param itemSelecListaParcelas seta o novo valor para o campo itemSelecListaParcelas
     */
    public void setItemSelecListaParcelas(Integer itemSelecListaParcelas) {
        this.itemSelecListaParcelas = itemSelecListaParcelas;
    }

    /**
     * @return o valor do itemSelecListaDespesas
     */
    public Integer getItemSelecListaDespesas() {
        return itemSelecListaDespesas;
    }

    /**
     * @param itemSelecListaDespesas seta o novo valor para o campo itemSelecListaDespesas
     */
    public void setItemSelecListaDespesas(Integer itemSelecListaDespesas) {
        this.itemSelecListaDespesas = itemSelecListaDespesas;
    }

    /**
     * @return o valor do dataLimiteEmbarque
     */
    public Date getDataLimiteEmbarque() {
        return dataLimiteEmbarque;
    }

    /**
     * @param dataLimiteEmbarque seta o novo valor para o campo dataLimiteEmbarque
     */
    public void setDataLimiteEmbarque(Date dataLimiteEmbarque) {
        this.dataLimiteEmbarque = dataLimiteEmbarque;
    }

    /**
     * @return o valor do itemSelecListarRespDesp
     */
    public Integer getItemSelecListaRespDesp() {
        return itemSelecListaRespDesp;
    }

    /**
     * @param itemSelecListarRespDesp seta o novo valor para o campo itemSelecListarRespDesp
     */
    public void setItemSelecListaRespDesp(Integer itemSelecListaRespDesp) {
        this.itemSelecListaRespDesp = itemSelecListaRespDesp;
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

    public Long getnAprvCred() {
        return nAprvCred;
    }

    public void setnAprvCred(Long nAprvCred) {
        this.nAprvCred = nAprvCred;
    }

    /**
     * @return o valor do cpfClienteBinding
     */
    public UICpf getCpfClienteBinding() {
        return cpfClienteBinding;
    }

    /**
     * @param cpfClienteBinding seta o novo valor para o campo cpfClienteBinding
     */
    public void setCpfClienteBinding(UICpf cpfClienteBinding) {
        this.cpfClienteBinding = cpfClienteBinding;
    }

    /**
     * @return o valor do cnpjClienteBinding
     */
    public UICnpj getCnpjClienteBinding() {
        return cnpjClienteBinding;
    }

    /**
     * @param cnpjClienteBinding seta o novo valor para o campo cnpjClienteBinding
     */
    public void setCnpjClienteBinding(UICnpj cnpjClienteBinding) {
    	UICnpj c = new UICnpj();
    	c.setValue("68.041.727/0001-50");
        this.cnpjClienteBinding = c;
    }

    /**
     * @return o valor do disabledTipoCotacao
     */
    public Boolean getDisabledTipoCotacao() {
        return disabledTipoCotacao;
    }

    /**
     * @param disabledTipoCotacao seta o novo valor para o campo disabledTipoCotacao
     */
    public void setDisabledTipoCotacao(Boolean disabledTipoCotacao) {
        this.disabledTipoCotacao = disabledTipoCotacao;
    }

    /**
     * @return o valor do disabledTxtCarenciaPrinc
     */
    public boolean isDisabledTxtCarenciaPrinc() {
        return disabledTxtCarenciaPrinc;
    }

    /**
     * @param disabledTxtCarenciaPrinc seta o novo valor para o campo disabledTxtCarenciaPrinc
     */
    public void setDisabledTxtCarenciaPrinc(boolean disabledTxtCarenciaPrinc) {
        this.disabledTxtCarenciaPrinc = disabledTxtCarenciaPrinc;
    }

    /**
     * @return o valor do disabledTxtCarenciaJuros
     */
    public boolean isDisabledTxtCarenciaJuros() {
        return disabledTxtCarenciaJuros;
    }

    /**
     * @param disabledTxtCarenciaJuros seta o novo valor para o campo disabledTxtCarenciaJuros
     */
    public void setDisabledTxtCarenciaJuros(boolean disabledTxtCarenciaJuros) {
        this.disabledTxtCarenciaJuros = disabledTxtCarenciaJuros;
    }

    /**
     * @return o valor do disabledComboMomentoJuros
     */
    public boolean isDisabledComboMomentoJuros() {
        return disabledComboMomentoJuros;
    }

    /**
     * @param disabledComboMomentoJuros seta o novo valor para o campo disabledComboMomentoJuros
     */
    public void setDisabledComboMomentoJuros(boolean disabledComboMomentoJuros) {
        this.disabledComboMomentoJuros = disabledComboMomentoJuros;
    }

    /**
     * @return o valor do controleBotaoAlerta
     */
    public Integer getControleBotaoAlerta() {
        return controleBotaoAlerta;
    }

    /**
     * @param controleBotaoAlerta seta o novo valor para o campo controleBotaoAlerta
     */
    public void setControleBotaoAlerta(Integer controleBotaoAlerta) {
        this.controleBotaoAlerta = controleBotaoAlerta;
    }
    
    public String getVmincobrcomis() {
		return vmincobrcomis;
	}

	public void setVmincobrcomis(String vmincobrcomis) {
		this.vmincobrcomis = vmincobrcomis;
	}

    /**
     * @return o valor do renderFechar
     */
    public Boolean getRenderFechar() {
        return renderFechar;
    }

    /**
     * @param renderFechar seta o novo valor para o campo renderFechar
     */
    public void setRenderFechar(Boolean renderFechar) {
        this.renderFechar = renderFechar;
    }

    /**
     * @return o valor do disabledRadioStandBy
     */
    public Boolean getDisabledRadioStandBy() {
        return disabledRadioStandBy;
    }

    /**
     * @param disabledRadioStandBy seta o novo valor para o campo disabledRadioStandBy
     */
    public void setDisabledRadioStandBy(Boolean disabledRadioStandBy) {
        this.disabledRadioStandBy = disabledRadioStandBy;
    }

	public Date getDataDisponibilidade() {
		return dataDisponibilidade;
	}

	public void setDataDisponibilidade(Date dataDisponibilidade) {
		this.dataDisponibilidade = dataDisponibilidade;
	}

    /**
     * @return o valor do vencimentoSaque
     */
    public Date getVencimentoSaque() {
        return vencimentoSaque;
    }

    /**
     * @param vencimentoSaque seta o novo valor para o campo vencimentoSaque
     */
    public void setVencimentoSaque(Date vencimentoSaque) {
        this.vencimentoSaque = vencimentoSaque;
    }

    /**
     * @return o valor do comboFormaPagamento
     */
    public List<SelectItem> getComboFormaPagamento() {
        return comboFormaPagamento;
    }

    /**
     * @param comboFormaPagamento seta o novo valor para o campo comboFormaPagamento
     */
    public void setComboFormaPagamento(List<SelectItem> comboFormaPagamento) {
        this.comboFormaPagamento = comboFormaPagamento;
    }

    /**
     * @return o valor do comboMoeda
     */
    public List<SelectItem> getComboMoeda() {
        return comboMoeda;
    }

    /**
     * @param comboMoeda seta o novo valor para o campo comboMoeda
     */
    public void setComboMoeda(List<SelectItem> comboMoeda) {
        this.comboMoeda = comboMoeda;
    }

    /**
     * @return o valor do stateIdListaCotacoes
     */
    public String getStateIdListaCotacoes() {
        return stateIdListaCotacoes;
    }

    /**
     * @param stateIdListaCotacoes seta o novo valor para o campo stateIdListaCotacoes
     */
    public void setStateIdListaCotacoes(String stateIdListaCotacoes) {
        this.stateIdListaCotacoes = stateIdListaCotacoes;
    }

    /**
     * @return o valor do itemSelecListaCotacoes
     */
    public Integer getItemSelecListaCotacoes() {
        return itemSelecListaCotacoes;
    }

    /**
     * @param itemSelecListaCotacoes seta o novo valor para o campo itemSelecListaCotacoes
     */
    public void setItemSelecListaCotacoes(Integer itemSelecListaCotacoes) {
        this.itemSelecListaCotacoes = itemSelecListaCotacoes;
    }

    /**
     * @return o valor do dataValidadeCotacao
     */
    public Date getDataValidadeCotacao() {
        return dataValidadeCotacao;
    }

    /**
     * @param dataValidadeCotacao seta o novo valor para o campo dataValidadeCotacao
     */
    public void setDataValidadeCotacao(Date dataValidadeCotacao) {
        this.dataValidadeCotacao = dataValidadeCotacao;
    }

    /**
     * @return o valor do comboFuncao
     */
    public List<SelectItem> getComboFuncao() {
        return comboFuncao;
    }

    /**
     * @param comboFuncao seta o novo valor para o campo comboFuncao
     */
    public void setComboFuncao(List<SelectItem> comboFuncao) {
        this.comboFuncao = comboFuncao;
    }

    /**
     * @return o valor do funcaoSelecionada
     */
    public Integer getFuncaoSelecionada() {
        return funcaoSelecionada;
    }

    /**
     * @param funcaoSelecionada seta o novo valor para o campo funcaoSelecionada
     */
    public void setFuncaoSelecionada(Integer funcaoSelecionada) {
        this.funcaoSelecionada = funcaoSelecionada;
    }

    public String getTipoUnidExt() {
        return tipoUnidExt;
    }

    public void setTipoUnidExt(String tipoUnidExt) {
        this.tipoUnidExt = tipoUnidExt;
    }

    /**
     * @return o valor do listaPeriodicidade
     */
    public List<ComboCotacaoVO> getListaPeriodicidade() {
        return listaPeriodicidade;
    }

    /**
     * @param listaPeriodicidade seta o novo valor para o campo listaPeriodicidade
     */
    public void setListaPeriodicidade(List<ComboCotacaoVO> listaPeriodicidade) {
        this.listaPeriodicidade = listaPeriodicidade;
    }
    
    /**
     * @return o valor do listaPeriodicidadePrinc
     */
    public List<ComboCotacaoVO> getListaPeriodicidadePrinc() {
        return listaPeriodicidadePrinc;
    }

    /**
     * @param listaPeriodicidadePrinc seta o novo valor para o campo listaPeriodicidadePrinc
     */
    public void setListaPeriodicidadePrinc(List<ComboCotacaoVO> listaPeriodicidadePrinc) {
        this.listaPeriodicidadePrinc = listaPeriodicidadePrinc;
    }

	public Integer getNumDesembFlxPgtoOperAditar() {
		return numDesembFlxPgtoOperAditar;
	}

	public void setNumDesembFlxPgtoOperAditar(Integer numDesembFlxPgtoOperAditar) {
		this.numDesembFlxPgtoOperAditar = numDesembFlxPgtoOperAditar;
	}
	
	public Boolean getDisabledQtdeParcela() {
		return disabledQtdeParcela;
	}

	public void setDisabledQtdeParcela(Boolean disabledQtdeParcela) {
		this.disabledQtdeParcela = disabledQtdeParcela;
	}

	public Boolean getDisabledValorComissaoExt() {
		return disabledValorComissaoExt;
	}

	public void setDisabledValorComissaoExt(Boolean disabledValorComissaoExt) {
		this.disabledValorComissaoExt = disabledValorComissaoExt;
	}

	public Boolean getDisabledTaxaComissaoExt() {
		return disabledTaxaComissaoExt;
	}

	public void setDisabledTaxaComissaoExt(Boolean disabledTaxaComissaoExt) {
		this.disabledTaxaComissaoExt = disabledTaxaComissaoExt;
	}

	public Integer getTipoComissaoExterna() {
		return tipoComissaoExterna;
	}

	public void setTipoComissaoExterna(Integer tipoComissaoExterna) {
		this.tipoComissaoExterna = tipoComissaoExterna;
	}

	public Integer getCobrancaComissaoExterna() {
		return cobrancaComissaoExterna;
	}

	public void setCobrancaComissaoExterna(Integer cobrancaComissaoExterna) {
		this.cobrancaComissaoExterna = cobrancaComissaoExterna;
	}

	public String getValorComissaoExterna() {
		return valorComissaoExterna;
	}

	public void setValorComissaoExterna(String valorComissaoExterna) {
		this.valorComissaoExterna = valorComissaoExterna;
	}

	public String getTaxaComissaoExterna() {
		return taxaComissaoExterna;
	}

	public void setTaxaComissaoExterna(String taxaComissaoExterna) {
		this.taxaComissaoExterna = taxaComissaoExterna;
	}

	public Integer getMoedaComissaoExterna() {
		return moedaComissaoExterna;
	}

	public void setMoedaComissaoExterna(Integer moedaComissaoExterna) {
		this.moedaComissaoExterna = moedaComissaoExterna;
	}

	public boolean isRenderMsg() {
		return renderMsg;
	}

	public void setRenderMsg(boolean renderMsg) {
		this.renderMsg = renderMsg;
	}

    public String getCidtfdrespdesp() {
        return cidtfdrespdesp;
    }

    public void setCidtfdrespdesp(String cidtfdrespdesp) {
        this.cidtfdrespdesp = cidtfdrespdesp;
    }

    public List<SelectItem> getComboPorContaGarantia() {
        return comboPorContaGarantia;
    }

    public void setComboPorContaGarantia(List<SelectItem> comboPorContaGarantia) {
        this.comboPorContaGarantia = comboPorContaGarantia;
    }

    /**
     * @return o valor do disabledModalidade
     */
    public Boolean getDisabledModalidade() {
        return disabledModalidade;
    }

    /**
     * @param disabledModalidade seta o novo valor para o campo disabledModalidade
     */
    public void setDisabledModalidade(Boolean disabledModalidade) {
        this.disabledModalidade = disabledModalidade;
    }
    
    /**
     * @return o valor do Cfluxoperdccmbio
     */
	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}

    /**
     * @param seta o novo valor para o campo Cfluxoperdccmbio
     */
	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}
    
    /**
     * @return o valor do codMomentoComissao
     */
	public Integer getCodMomentoComissao() {
		return codMomentoComissao;
	}

    /**
     * @param seta o novo valor para o campo codMomentoComissao
     */
	public void setCodMomentoComissao(Integer codMomentoComissao) {
		this.codMomentoComissao = codMomentoComissao;
	}
	
    /**
     * @return o valor do CfluxoperdccmbioRed
     */
    public Integer getCfluxoperdccmbioRed() {
		return cfluxoperdccmbioRed;
	}

    /**
     * @param seta o novo valor para o campo CfluxoperdccmbioRed
     */
	public void setCfluxoperdccmbioRed(Integer cfluxoperdccmbioRed) {
		this.cfluxoperdccmbioRed = cfluxoperdccmbioRed;
	}
	
    /**
     * @return o valor do CodMomentoComissaoRed
     */
	public Integer getCodMomentoComissaoRed() {
		return codMomentoComissaoRed;
	}

    /**
     * @return o valor do CodMomentoComissaoRed
     */
	public void setCodMomentoComissaoRed(Integer codMomentoComissaoRed) {
		this.codMomentoComissaoRed = codMomentoComissaoRed;
	}

    /**
     * @return o valor do renderLupaAprovCredito
     */
    public Boolean getRenderLupaAprovCredito() {
        return renderLupaAprovCredito;
    }

    /**
     * @param renderLupaAprovCredito seta o novo valor para o campo renderLupaAprovCredito
     */
    public void setRenderLupaAprovCredito(Boolean renderLupaAprovCredito) {
        this.renderLupaAprovCredito = renderLupaAprovCredito;
    }

    /**
     * @return o valor do itemSelecListaComissaoBanqueiro
     */
    public String getItemSelecListaComissaoBanqueiro() {
        return itemSelecListaComissaoBanqueiro;
    }

    /**
     * @param itemSelecListaComissaoBanqueiro seta o novo valor para o campo itemSelecListaComissaoBanqueiro
     */
    public void setItemSelecListaComissaoBanqueiro(String itemSelecListaComissaoBanqueiro) {
        this.itemSelecListaComissaoBanqueiro = itemSelecListaComissaoBanqueiro;
    }

    /**
     * @return the comboPrazoProex
     */
    public List<SelectItem> getComboPrazoProex() {
        return comboPrazoProex;
    }

    /**
     * @param comboPrazoProex the comboPrazoProex to set
     */
    public void setComboPrazoProex(List<SelectItem> comboPrazoProex) {
        this.comboPrazoProex = comboPrazoProex;
    }
    

    /**
     * @return o valor do alertMessageConfirmation
     */
    public String getAlertMessageConfirmation() {
        return alertMessageConfirmation;
    }

    /**
     * @param alertMessageConfirmation seta o novo valor para o campo alertMessageConfirmation
     */
    public void setAlertMessageConfirmation(String alertMessageConfirmation) {
        this.alertMessageConfirmation = alertMessageConfirmation;
    }

    /**
     * @return the codComisSobre
     */
    public Integer getCodComisSobre() {
        return codComisSobre;
    }

    /**
     * @param codComisSobre the codComisSobre to set
     */
    public void setCodComisSobre(Integer codComisSobre) {
        this.codComisSobre = codComisSobre;
    }

    /**
     * @return the operaComLimite
     */
    public boolean isOperaComLimite() {
        return operaComLimite;
    }

    /**
     * @param operaComLimite the operaComLimite to set
     */
    public void setOperaComLimite(boolean operaComLimite) {
        this.operaComLimite = operaComLimite;
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

	public Boolean getDisabledTxtPrazoStandBy() {
		return disabledTxtPrazoStandBy;
	}

	public void setDisabledTxtPrazoStandBy(Boolean disabledTxtPrazoStandBy) {
		this.disabledTxtPrazoStandBy = disabledTxtPrazoStandBy;
	}

	public Boolean getDisabledRadioComisStandBy() {
		return disabledRadioComisStandBy;
	}

	public void setDisabledRadioComisStandBy(Boolean disabledRadioComisStandBy) {
		this.disabledRadioComisStandBy = disabledRadioComisStandBy;
	}
    
}
