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
 *         Compilador: JDK 1.6
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.comissaoIntExtModal.IComissaoInternaExternaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.IDesenquadradaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.ITradeFinanceMonitService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoInternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.InformacaoPilotoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoVinculadaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ITradeFinanceNegociacaoService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CalcPrazoTotalOperLcVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaParcelasDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ObservacoesCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TaxasForfaitingVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegPrecificacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean.LimitesModalVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboPaisVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrizacao.IComissaoDesembolsoService;
import br.com.bradesco.web.npcc_trade.service.business.parametrizacao.bean.ComissaoDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.IParametroUnidadeExternaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean.FaixaOperacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean.ParametroUnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.IPrazoStandbyService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.bean.PrazoStandbyVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.ITarifaAutomaticaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean.TarifaAutomaticaFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean.TarifaAutomaticaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumCampoData;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumCobrancaComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumComissaoSobre;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNaoStr;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoCotacao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.ResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.TradeFinanceBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.ComissaoIntManutModal.ComissaoIntManutModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.alertasClienteModal.AlertasClienteModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.beneficiarioModal.BenefModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.clienteModal.ClienteModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.comissaoBase.ComissaoViewHelper;
import br.com.bradesco.web.npcc_trade.view.bean.global.comissaoExtManutModal.ComissaoExtManutModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.custoExtDsnModal.CustoExtAutoDsnModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.desenquadradaModal.DesenquadradasModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.fluxoPgtoManutModal.FluxoPgtoManutModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.garantiasModal.GarantiasModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.liborTravadaBean.LiborTravadaModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.limitesModal.LimitesModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.mercadoriaModal.MercadoriaModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.modeloBoletoModalbean.ModeloBoletoModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.oprVincModal.OprVincModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.unidadeExternaModalbean.UnidadeExternaModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.vincularOperacaoLc.VincularOperacaoLcBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;
/**
 * Nome: TradeFinanceNegociacaoBase.java
 * 
 * Propósito: Fornecer metodos básicos para manutenção de cotações
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 23/04/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public abstract class TradeFinanceNegociacaoBase extends BaseBean implements Cloneable {

    /** 
     * Controle de execução 
     */
    protected Integer funcaoExecutando = 0;

    /** 
     * VO Principal 
     */
    protected TrdFinNegocInclVO tradeFinNegocVO = new TrdFinNegocInclVO();
    
    /** 
     * Variáveis de apoio a tela 
     */
    protected TradeFinanceNegociacaoViewHelper viewHelper = new TradeFinanceNegociacaoViewHelper();
    protected String controleInclusaoAlteracao = "DadosBasicos";
    
    /** 
     * Váriáveis Clientes 
     **/
    protected ClienteSelecaoVO clienteSelecaoVO = new ClienteSelecaoVO();
    protected List<TradeFinNegocListasVO> listaSelCliente = new ArrayList<TradeFinNegocListasVO>();
    protected Integer tipoPesquisaCliente = Numeros.ZERO;
    protected Integer tipoCpfCnpj = Numeros.ZERO;
    
    /** 
     * Váriáveis Limites 
     **/
    protected LimitesModalVO limiteVO = new LimitesModalVO();
    protected List<TradeFinNegocListasVO> listaModalLimite = new ArrayList<TradeFinNegocListasVO>();
    
    /** 
     * Variáveis Precificacao 
     */
    protected TrdFinNegPrecificacaoVO trdFinNegPrecificacaoVO = new TrdFinNegPrecificacaoVO();
    private TrdFinNegMercadoriaVO tomadorModal = new TrdFinNegMercadoriaVO();
    
    /** 
     * Variáveis Prazo Standby
     */
    protected PrazoStandbyVO prazoStandbyVO = new PrazoStandbyVO();
    
    /**
     * Modelos de boleto
     */
    
    protected ModeloBoletoVO modeloBoletoVO = new ModeloBoletoVO();
    
    /** 
     * Variáveis Fluxo de Pagamento
     */
    protected TrdFinNegFluxoPagtoVO itemListaFluxoPgto = new TrdFinNegFluxoPagtoVO();
    
    private TrdFinNegFluxoPagtoVO itemListaFluxoPgtoAux = new TrdFinNegFluxoPagtoVO();
    private List<TrdFinNegParcelaVO> itemListaFluxoPgtoBackUp;
    
	/** 
     * Variáveis Unidade Externa
     */
    protected List<TradeFinNegocListasVO> listaUniExterna = new ArrayList<TradeFinNegocListasVO>();
    
    /**
     * Variáveis Mercadoria
     */
    protected TrdFinNegMercadoriaVO trdFinNegMercadoriaVO = new TrdFinNegMercadoriaVO();
    protected List<TradeFinNegocListasVO> listaSelMercadoria = new ArrayList<TradeFinNegocListasVO>();
    protected List<TradeFinNegocListasVO> listaSelBeneficiario = new ArrayList<TradeFinNegocListasVO>();
   
    /**
     * Variáveis Operações Vinculadas
     */
    protected TrdFinNegOperVincVO operVinculadasVO = new TrdFinNegOperVincVO();
    protected List<TrdFinNegOperVincVO> listaModalOperVinculadas = new ArrayList<TrdFinNegOperVincVO>();
    
    /**
     * Variáveis Comissão Interna
     */
    protected TrdFinNegComissaoVO itemListaComissaoInterna = new TrdFinNegComissaoVO();
    protected List<TrdFinNegComissaoVO> listaParcelas = new ArrayList<TrdFinNegComissaoVO>();
    
    /**
     * Variáveis Comissão Externa
     */
    protected TrdFinNegComissaoVO itemListaComissaoExterna = new TrdFinNegComissaoVO();

    protected ComissaoViewHelper viewHelperAux = new ComissaoViewHelper();
    

    /**
     * Variáveis produto Forfaiting
     */
    protected TradeFinanceDesembolsoVO desembolsoForfaitingVO = new TradeFinanceDesembolsoVO();
    protected List<TradeFinanceDesembolsoVO> listaDesembolso = new ArrayList<TradeFinanceDesembolsoVO>();
    protected TaxasForfaitingVO txForfaitingVO = new TaxasForfaitingVO();
    
    /**
     * Variáveis Tarifas
     */
    protected String TIPO_TARIFA = "T";
    
    /**
     * Objeto com observacoes e complementos
     */
    protected ObservacoesCotacaoVO obsCotacaoVO = new ObservacoesCotacaoVO();
    
   
    /** Desenquadradas */
    private DesenquadramentoVO desenquadradas = new DesenquadramentoVO();
    
    protected Date limiteCtc = null;
    protected UnidadeExternaVO unidadeExternaVO = new UnidadeExternaVO();
    protected UnidadeExternaVO bancoAvisadorVO = new UnidadeExternaVO();
    protected UnidadeExternaVO bancoReembolsadorVO = new UnidadeExternaVO();
    
    /** Dados originais **/
	private TrdFinNegocInclVO trdFinNegocOriginalVO = new TrdFinNegocInclVO();
    
 
    
    /*************************** 
     * Injeção de Dependências *
     ***************************/
    
    @Inject
    @Named("tradeFinanceNegociacaoService")
    protected ITradeFinanceNegociacaoService tradeFinanceNegociacaoService;
    
    @Inject
    @Named("selectItemBean")
    protected SelectItemBean selectItemBean;
    
    @Inject
    @Named("prazoStandbyService")
    protected IPrazoStandbyService prazoStandbyService;
    
    @Inject
    @Named("commonService")
    protected ICommonService commonService;
    
    @Inject
    @Named("limitesModalBean")
    protected LimitesModalBean limitesModalBean;
    
    @Inject
    @Named("garantiasModalBean")
    protected GarantiasModalBean garantiasModalBean;
    
    @Inject
    @Named("tradeFinanceMonitService")
    protected ITradeFinanceMonitService tradeFinanceMonitService;

    @Inject
    @Named("tradeFinanceBean")
    protected TradeFinanceBean tradeFinanceBean;

    @Inject
    @Named("fluxoPgtoManutModalBean")
    protected FluxoPgtoManutModalBean fluxoPgtoManutModalBean;

    @Inject
    @Named("custoExtAutoDsnModalBean")
    protected CustoExtAutoDsnModalBean custoExtAutoDsnModalBean;
    
    @Inject
	@Named("unidadeExternaModalBean")
	private UnidadeExternaModalBean unidadeExternaModalBean;
    
    @Inject
	@Named("liborTravadaModalBean")
	private LiborTravadaModalBean liborTravadaModalBean;

    @Inject
	@Named("mercadoriaModalBean")
	private MercadoriaModalBean mercadoriaModalBean;
    
    @Inject
	@Named("benefModalBean")
	private BenefModalBean benefModalBean;
    
    @Inject
	@Named("oprVincModalBean")
	private OprVincModalBean oprVincModalBean;
    
    @Inject
    @Named("clienteModalBean")
    private ClienteModalBean clienteModalBean;
    
    @Inject
    @Named("comissaoIntManutModalBean")
    protected ComissaoIntManutModalBean comissaoIntManutModalBean;
    
    @Inject
    @Named("comissaoExtManutModalBean")
    protected ComissaoExtManutModalBean comissaoExtManutModalBean;
    
    @Inject
    @Named("alertasClienteModalBean")
    private AlertasClienteModalBean alertasClienteModalBean;
    
    @Inject
    @Named("desenquadradaModalService")
    private IDesenquadradaModalService desenquadradaModalService;
    
    @Inject
    @Named("desenquadradasModalBean")
    private DesenquadradasModalBean desenquadradasModalBean;
    
    @Inject
    @Named("comissaoInternaExternaModalService")
    private IComissaoInternaExternaModalService comissaoInternaExternaModalService;
    
    @Inject
    @Named("vincularOperacaoLcBean")
    protected VincularOperacaoLcBean vincularOperacaoLcBean;
    
    @Inject
    @Named("tradeFinMonitBean")
    protected TradeFinMonitBean tradeFinMonitBean;

    @Inject
	@Named("modeloBoletoModalBean")
	private ModeloBoletoModalBean modeloBoletoModalBean;
    
    @Inject
	@Named("comissaodesembolsoService")
	private IComissaoDesembolsoService comissaodesembolsoservice;
    
	@Inject
	@Named("parametroUnidadeExternaService")
	private IParametroUnidadeExternaService parametroUnidadeExternaService;

    
	private boolean validaListenerTrocaValorMe = false;

	private boolean validarListenerDiaUtil = false;
	private boolean validaListenerTrocaPrazo = false;
	
    /*************************************************** 
     * METODOS PARA MANIPULAR CAMPOS E VALORES DA TELA *
     * *************************************************/
    
    /**
     * Nome: testarProdutoDisponivel
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public Boolean testarProdutoDisponivel(Integer codProduto) {

        if (codProduto.equals(EnumProduto.PRODUTO_FINIMP_DIRETO.getCodigo())
                || codProduto.equals(EnumProduto.PRODUTO_REFINIMP_DIRETO.getCodigo())
                || codProduto.equals(EnumProduto.PRODUTO_FINIMP_INDIRETO.getCodigo())
                || codProduto.equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO.getCodigo())
                || codProduto.equals(EnumProduto.PRODUTO_LEI_4131.getCodigo())
                || codProduto.equals(EnumProduto.PRODUTO_P_P_E.getCodigo())
                || codProduto.equals(EnumProduto.PRODUTO_WORKING_CAPITAL.getCodigo())
                || codProduto.equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())
                || codProduto.equals(EnumProduto.FINIMP_ECA.getCodigo())
                || codProduto.equals(EnumProduto.PROEX.getCodigo())
                || codProduto.equals(EnumProduto.CCE_CEDULA_EXPORTACAO.getCodigo())
                || codProduto.equals(EnumProduto.CCE_CEDULA_EXPORTACAO_INDIRETO.getCodigo())
                || codProduto.equals(EnumProduto.NCE_NOTA_EXPORTACAO_COMPOR.getCodigo())
                || codProduto.equals(EnumProduto.NCE_NOTA_EXPORTACAO_INDIRETO.getCodigo())
                || codProduto.equals(EnumProduto.NCE_NOTA_EXPORTACAO_REVOLVING.getCodigo())
                || codProduto.equals(EnumProduto.NCE_CREDITO_EXPORTACAO.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_POS_BUYER.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_POS_SUPPLIER.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_PRE_AGIL.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_PRE_ANCORA.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_PRE_AUTOMOVEIS.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_PRE_ESPECIAL.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_PRE_NORMAL.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_PRE_REVITALIZA.getCodigo())
                || codProduto.equals(EnumProduto.BNDES_PRE_SUSTENTANCAO_INVEST.getCodigo())
                || codProduto.equals(EnumProduto.LC_IMPORTACAO.getCodigo())
                || codProduto.equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA.getCodigo())
                || codProduto.equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO.getCodigo())) {

            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    /**
     * Nome: configurarTelaPorProduto
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 10/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void configurarTelaPorProduto() {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.configurarTelaPorProduto <<<<<<<<<<<");
    		
    		// FINIMP DIRETO (1644)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
    			inicializarComponentesTela();
    			carregaUnidadeExternaDefault();
    			carregaModeloBoletoDefault();
    			atribuirValoresDefault();
    			// Não tem tela de dadosTomador
    	        
    			setarModalidadeDefaultFinimpDireto();
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.TRUE);
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// REFINIMP DIRETO (1646)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
    			inicializarComponentesTela();
    			carregaUnidadeExternaDefault();
    			carregaModeloBoletoDefault();
    			atribuirValoresDefault();
    			// Não tem tela de dadosTomador
    			
    	        setarModalidadeDefaultFinimpDireto();
    			
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.TRUE);
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// FINIMP INDIRETO (2692)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
    			inicializarComponentesTela();
    			carregaUnidadeExternaDefault();
    			carregaModeloBoletoDefault();
    			atribuirValoresDefault();
    			// Não tem tela de dadosTomador
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.TRUE);
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// REFINIMP INDIRETO (1717)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
    			inicializarComponentesTela();
    			carregaUnidadeExternaDefault();
    			carregaModeloBoletoDefault();
    			atribuirValoresDefault();
    			// Não tem tela de dadosTomador
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.TRUE);
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// LEI 4131 (2010)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
    			inicializarComponentesTela();
    			carregaUnidadeExternaDefault();
    			carregaModeloBoletoDefault();
    			atribuirValoresDefault();
    			atribuirValoresDefaultLei4131Ppe();
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Não tem tela de dadosMercadoria
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// PPE (1642)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
    			inicializarComponentesTela();
    			carregaUnidadeExternaDefault();
    			carregaModeloBoletoDefault();
    			atribuirValoresDefault();
    			// Não tem tela de dadosTomador
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.FALSE);
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.TRUE);
    			
    			// Não tem tela de dadosOperacaoVinculada
    			
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// WORKING CAPITAL (2011)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
    			inicializarComponentesTelaWorkingCapital();
    			carregaUnidadeExternaDefault();
    			carregaModeloBoletoDefault();
    			atribuirValoresDefault();
    			// Não tem tela de dadosSwapPtaxSpread
    			// Item tela de dadosTomador
    			getViewHelper().setRenderAbout(Boolean.FALSE);
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.FALSE);
    			
    			// Não tem tela de dadosMercadoria
    			// Não tem tela de dadosOperacaoVinculada
    			// Não tem tela de dadosResponsavelEmpresa
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// FORFAITING (644)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    			inicializarComponentesTela();
    			carregaUnidadeExternaDefault();
    			carregaModeloBoletoDefault();
    			getTradeFinanceBean().setQuadroOperacaoForfaiting(new ArrayList<TaxasForfaitingVO>());
    			
    			atribuirValoresDefault();
    			// Não tem tela de dadosSwapPtaxSpread
    			// Não tem tela de dadosStandby
    			// Item tela de dadosTomador
    			getViewHelper().setRenderAbout(Boolean.TRUE);
    			// Não tem tela de dadosFluxoPagamento
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.FALSE);
    			
    			// Tem tela de dadosComissaoIntForfaiting
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.FALSE);
    			
    			// Não tem tela de dadosOperacaoVinculada
    			// Não tem tela de dadosResponsavelEmpresa

    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// FINIMP ECA (1715)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
    			inicializarComponentesTela();
    			atribuirValoresDefault();
    			carregaModeloBoletoDefault();
    			// Não tem tela de dadosTomador
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.TRUE);

    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// PROEX EQUALIZACAO (642)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
    			inicializarComponentesTelaWorkingCapital();
    			atribuirValoresDefault();
    			carregaModeloBoletoDefault();
    			// Não tem tela de dadosSwapPtaxSpread
    			// Item tela de dadosTomador
    			getViewHelper().setRenderAbout(Boolean.FALSE);
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.FALSE);
    			
    			// Não tem tela de dadosMercadoria
    			// Não tem tela de dadosOperacaoVinculada
    			// Não tem tela de dadosResponsavelEmpresa
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
    		if (getTradeFinNegocVO().getProduto().isNce()) {
    			
    			inicializarComponentesTela();
    			atribuirValoresDefault();
    			carregaModeloBoletoDefault();
    			// Não tem tela de dadosTomador
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.TRUE);
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		// GARANTIA INTERNACIONAL EXPEDIDA (1769, 3933)
    		if(getTradeFinNegocVO().getProduto().isGarantia()) {
    			
    			inicializarComponentesTela();
    			atribuirValoresDefault();
    			carregaModeloBoletoDefault();
    			
    			//ITEM DOS DADOS PRECIFICACAO
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Item tela de dadosMercadoria
                getViewHelper().setRenderSeguroBenef(Boolean.TRUE);
    			
    			TrdFinNegComissaoVO itemComissaoInterna = new TrdFinNegComissaoVO();
                itemComissaoInterna.setDateComissao(new Date());
                itemComissaoInterna.setDataComissaoFormat(SiteUtil.dateToString(itemComissaoInterna.getDateComissao(), "dd/MM/yyyy"));
                itemComissaoInterna.setPtxcustototal(getLimiteVO().getPspreadprodt());
                getTradeFinNegocVO().getListaComissaoInterna().add(itemComissaoInterna);            
                
                getViewHelper().setDisabledModalComissaoExt(Boolean.FALSE);
                getViewHelper().setComboPeriodoDaTaxa(selectItemBean.getCodigoCobrancaComissao());
                getViewHelper().setCobrancaComissaoExterna(Numeros.UM);
                getViewHelper().setMoedaComissaoExterna(EnumTradeFinance.MOEDA_USD.getCodigo());
                disableValorTaxa();
                
    			// Carregar tarifas automáticas
                pesquisarTarifaAutomatica();
                
                if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
                
    			return;
    		}
    		
    		// BNDES Pós (661, 662)
    		// BNDES Pré (663, 664, 665, 666, 667, 670, 3934)
    		if (getTradeFinNegocVO().getProduto().isBndesPos() || getTradeFinNegocVO().getProduto().isBndesPre()) {
    			
    			inicializarComponentesTela();
    			atribuirValoresDefault();
    			carregaModeloBoletoDefault();
    			atribuirValoresDefaultBNDES();
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    		}
    		
    		
    		// CARTA DE CRÉDITO DE IMPORTAÇÃO (2018)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
    			inicializarComponentesTela();
    			atribuirValoresDefault();
    			carregaModeloBoletoDefault();
    			// Não tem tela de dadosTomador
    			
    			// Item tela de dadosPrecificacao
    			getViewHelper().setRenderIrIof(Boolean.TRUE);
    			
    			// Não Carrega Unidade Externa default
                getTrdFinNegPrecificacaoVO().setUnidadeExternaVO(new UnidadeExternaVO());
    			
    			// Item tela de dadosMercadoria
    			getViewHelper().setRenderSeguroBenef(Boolean.TRUE);
    			
    			TrdFinNegComissaoVO itemComissaoInterna = new TrdFinNegComissaoVO();
    			itemComissaoInterna.setDateComissao(new Date());
    			itemComissaoInterna.setDataComissaoFormat(SiteUtil.dateToString(itemComissaoInterna.getDateComissao(), "dd/MM/yyyy"));
    			itemComissaoInterna.setPtxcustototal(getLimiteVO().getPspreadprodt());
    			getTradeFinNegocVO().getListaComissaoInterna().add(itemComissaoInterna);       
    			
    			getViewHelper().setDisabledModalComissaoExt(Boolean.FALSE);
    			getViewHelper().setComboPeriodoDaTaxa(selectItemBean.getCodigoCobrancaComissao());
    			getViewHelper().setCobrancaComissaoExterna(Numeros.UM);
    			getViewHelper().setMoedaComissaoExterna(EnumTradeFinance.MOEDA_USD.getCodigo());
    			disableValorTaxa();
    			
    			// Carregar tarifas automáticas
    			pesquisarTarifaAutomatica();
    			
    			if (getTradeFinNegocVO().getListaTarifas().size() > 0) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			}
    			
    			return;
    		}
    		
    		return;

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.configurarTelaPorProduto <<<<<<<<<<<");
    	}
    	
    }
    
    //Limpar Comissão Interna e Comissão Externa LC, quando trocar prazo
	private void trocarPrazoLC() {
    	    
    	    NpcFacesUtils.addInfoModalMessage("Recalcular os fluxos de Comissão Interna, juros e Comissão Externa", false);
    	    
    	    getViewHelper().setValueComissaoCobranca("");
    	    itemListaComissaoInterna.setVmincobrcomis("0,00");
    	    itemListaComissaoInterna.setPtxcustototal("0,00000");
            itemListaComissaoInterna.setVtxspreadnegoc("0,00000");
            itemListaComissaoInterna.setVtxspreadtot("0,00000");
            itemListaComissaoInterna.setPtxflatpnalt("0,00000");
			
    	    //Limpa comissão Externa
    	    limpaFluxoPgtComissaoExterna();
    }
	
	//Setar valor da Modadalidade com Standy By somente para FINIMP DIRETO e REFINIMP DIRETO
	private void setarModalidadeDefaultFinimpDireto() {
		
		for (SelectItem modalidade : getViewHelper().getComboModalidade()) {
			String[] cModalidade = modalidade.getLabel().split("-");
			if("DC".equals(cModalidade[0])){
				getTradeFinNegocVO().setCmodldprodtcmbio((Integer) modalidade.getValue());
				
				viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
				viewHelper.setDisabledTxtPrazoStandBy(Boolean.FALSE);
				getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.SIM.getCodigo());
				getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.SIM.getCodigo());
				tratarStandBy();
			}
		}
	}

//	//Setar valor da comissão do Brasil, conforme o produto
//	private void setarComissaoBrasilDefault() {
//		
//		// PPE (1642) ou WORKING CAPITAL (2011)
//		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E) || 
//    	   getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
//			viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
//			viewHelper.setDisabledTxtPrazoStandBy(Boolean.FALSE);
//			viewHelper.setDisabledRadioComisStandBy(Boolean.FALSE);
//			getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.SIM.getCodigo());
//			getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.SIM.getCodigo());
//		}
//		else {
//			viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
//			viewHelper.setDisabledTxtPrazoStandBy(Boolean.FALSE);
//			viewHelper.setDisabledRadioComisStandBy(Boolean.FALSE);
//			getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.SIM.getCodigo());
//			getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.SIM.getCodigo());
//		}
//	}

	private void carregaUnidadeExternaDefault() {
		// carrega a unidade externa como default na inicialização da tela
		getTrdFinNegPrecificacaoVO().setUnidadeExternaVO(getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO());
	}
	
	// carrega o modelo de boleto default na inicialização da tela
	private void carregaModeloBoletoDefault() {
		getModeloBoletoVO().setCprodtservc(getTradeFinNegocVO().getCprodtservc());
		getModeloBoletoVO().setImodcontrcmbio("");
		modeloBoletoModalBean.setBoletoVO(getModeloBoletoVO());
	    ModeloBoletoVO modeloBoletoPadrao = modeloBoletoModalBean.getModeloBoletoPadrao();
	    if(modeloBoletoPadrao != null) {
	    	getTradeFinNegocVO().setCmodcontrcmbio(modeloBoletoPadrao.getCmodcontrcmbio());
	    	getTradeFinNegocVO().setDmodcontrcmbio(modeloBoletoPadrao.getImodcontrcmbio());
	    }
	    else {
	    	getTradeFinNegocVO().setCmodcontrcmbio(null);
	    	getTradeFinNegocVO().setDmodcontrcmbio(null);
	    }
	}
	
	 /**
     * 
    	* Nome: listenerTrocaPeriodoDaTaxa
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 22/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerTrocaPeriodoDaTaxa(AjaxBehaviorEvent e) {
    	
    	try{
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaPeriodoDaTaxa <<<<<<<<<<<");
      		
      		disableValorTaxa();
      		 
      		if (itemListaComissaoExterna.getCfluxoperdccmbio() != EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
      		    itemListaComissaoExterna.setVprevtcomiscmbio(null);
      		}
      		 
   	   	}finally{
   	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaPeriodoDaTaxa <<<<<<<<<<<");
   	   	}
        
    }
    
    private void disableValorTaxa() {
        
    	if (getViewHelper().getCobrancaComissaoExterna().equals(Numeros.NUM2)
    			|| getViewHelper().getCobrancaComissaoExterna().equals(Numeros.NUM3)) {
    		
    		getViewHelper().setDisabledValorComissaoExt(Boolean.TRUE);
    		getViewHelper().setDisabledTaxaComissaoExt(Boolean.FALSE);
    	} else {
    		getViewHelper().setDisabledValorComissaoExt(Boolean.FALSE);
    		getViewHelper().setDisabledTaxaComissaoExt(Boolean.TRUE);
    	}
    }

    /**
     * Nome: inicializarComponentesTela
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void inicializarComponentesTela() {
        inicializarComponentesTelaParte1();
        inicializarComponentesTelaParte2();
    }

    protected void inicializarComponentesTelaWorkingCapital() {
        inicializarComponentesTelaParte1();

        getViewHelper().setComboPaisOrigem(selectItemBean.getPais("A"));
        getViewHelper().setComboPaisBeneficiario(selectItemBean.getPais("A"));
    }

    protected void inicializarComponentesTelaParte1() {

        getViewHelper().setValueMaisMenosFluxoPagto("+");
        getViewHelper().setRenderFluxoPagto(Boolean.FALSE);
        getViewHelper().setValueMaisMenosPrecificacao("+");
        getViewHelper().setRenderPrecificacao(Boolean.FALSE);
        getViewHelper().setValueMaisMenosComissaoInterna("+");
        getViewHelper().setRenderComissaoInterna(Boolean.FALSE);
        getViewHelper().setValueMaisMenosMercadoria("+");
        getViewHelper().setRenderMercadoria(Boolean.FALSE);
        getViewHelper().setValueMaisMenosOperacaoVinculada("+");
        getViewHelper().setRenderOperacaoVinculada(Boolean.FALSE);
        getViewHelper().setValueMaisMenosResponsavelEmpresa("+");
        getViewHelper().setRenderResponsavelEmpresa(Boolean.FALSE);
        getViewHelper().setValueMaisMenosTarifas("+");
        getViewHelper().setRenderTarifas(Boolean.FALSE);
        getViewHelper().setValueMaisMenosComissao("+");
        getViewHelper().setRenderComissao(Boolean.FALSE);
        getViewHelper().setRenderMsg(Boolean.FALSE);

        setPrazoStandbyVO(prazoStandbyService.getPrazoStandby());
        if (getPrazoStandbyVO().getTdiamaxcredt() == null) {
            getViewHelper().setTdiamaxcredt(0);
        } else {
            getViewHelper().setTdiamaxcredt(getPrazoStandbyVO().getTdiamaxcredt());
        }

        getViewHelper().setComboModalidade(selectItemBean.getModalidade(getTradeFinNegocVO().getCprodtservc()));

        getViewHelper().setComboMoedaOperacao(selectItemBean.getMoedaOperacao(getTradeFinNegocVO().getCprodtservc()));

        getViewHelper().setComboMoedaDesembolso(selectItemBean.getMoeda());

        getViewHelper().setComboMomento(selectItemBean.
                        getMomentoJuros(EnumTradeFinance.FLUXO_PAGAMENTO.getCodigo(), getTradeFinNegocVO().getProduto().getCodigo()));

        getViewHelper().setComboCodBaseJuros(selectItemBean.getCodigoBaseJuros());

        getViewHelper().setComboCodCobrancaComissao(selectItemBean.getCodigoCobrancaComissao());
        getViewHelper().setTipoCobrancaComissao(Numeros.UM);
        trocaCobrancaComissao();

        getViewHelper().setComboTipoCotacao(selectItemBean.getCodigoTipoCotacao());

        // Carrega o campo de periodicidade e guarda os dados retornados no mainframe
        getViewHelper().carregaComboPeriodicidade(commonService.getComboPeriodicidade(0));
        
        // Carrega o campo de periodicidade principal e guarda os dados retornados no mainframe
        getViewHelper().carregaComboPeriodicidadePrinc(commonService.getComboPeriodicidade(0));

        getViewHelper().setComboTipoComissao(selectItemBean.getTipoComissao(getTradeFinNegocVO().getCprodtservc(), 1));

        getViewHelper().setComboCodigoPtax(selectItemBean.getCodigoPtax());

        getViewHelper().setComboTarifas(selectItemBean.getTarifas(getTradeFinNegocVO().getCprodtservc(), TIPO_TARIFA));

        getViewHelper().setComboPeriodoDaTaxa(selectItemBean.getPeriodoDaTaxa(getTradeFinNegocVO().getCprodtservc()));

        if (getTradeFinNegocVO().getCunicclicmbio() != null && getTradeFinNegocVO().getCunicclicmbio() > 0
                && getTradeFinNegocVO().getCdcpfcnpj() != null && getTradeFinNegocVO().getCdcpfcnpj() > 0) {
            obterDadosClienteRatingSegmento();
            
        } else {
            getTradeFinNegocVO().setCrting("");
            getTradeFinNegocVO().setIsgmto("");           
        }

        itemListaComissaoInterna.setVlxtotalcomis("0,00");
        itemListaComissaoInterna.setVmincobrcomis("0,00");
        getViewHelper().setVmincobrcomis("0,00");

        getViewHelper().setTelaInicioNegociacao(Boolean.FALSE);
        getViewHelper().setRenderDetalheCliente(Boolean.TRUE);

        getViewHelper().setRenderBtoTrocarProdutoIncl(Boolean.FALSE);
        
        getViewHelper().setComboMoedaEqualizavel(selectItemBean.getMoeda());
        getViewHelper().setComboMoedaReceita(selectItemBean.getMoeda());
        
        getViewHelper().setComboPrazoProex(selectItemBean.getComboPrazoProex());
        getViewHelper().setComboComissaoSobre(selectItemBean.getComboComissaoSobre());
        
        getViewHelper().setComboPrazo(selectItemBean.getComboPrazo());
        getViewHelper().setComboAVistaPrazo(selectItemBean.getComboAVistaPrazo());
        getViewHelper().setComboPorConta(selectItemBean.getComboPorConta());
        getViewHelper().setComboTipoDespesas(selectItemBean.getComboTipoDespesas());
        getViewHelper().setComboDocumentosConsignados(selectItemBean.getComboDocumentosConsignados());
        getViewHelper().setControleBotaoAlerta(null);

        getViewHelper().setRenderLupaAprovCredito(Boolean.TRUE);
    }

    protected void inicializarComponentesTelaParte2() {
        getViewHelper().setComboPaisOrigem(selectItemBean.getPais("A"));
        getViewHelper().setComboPaisBeneficiario(selectItemBean.getPais("A"));
        getViewHelper().setComboPaisEmbarque(selectItemBean.getPais("A"));
    }

    /**
     * Nome: atribuirValoresDefault
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atribuirValoresDefault() {
        getViewHelper().setStatusCotacao(EnumTradeFinance.STATUS_EM_NEGOCIACAO.getDescricao());
        if (getTradeFinNegocVO().getProduto().isGarantia() == Boolean.TRUE){
        	getTradeFinNegocVO().setCtponegoccmbio(EnumTipoCotacao.TIPO_INDICATIVA.getCodigo());
        } else {
        	getTradeFinNegocVO().setCtponegoccmbio(EnumTradeFinance.TPO_NEGOC_CMBIO_FIRME.getCodigo());	
        }
        getTradeFinNegocVO().setCindcdeconmmoeda(EnumTradeFinance.MOEDA_USD.getCodigo());
        getTradeFinNegocVO().setCeconmmoedadsemb(EnumTradeFinance.MOEDA_USD.getCodigo());
        trocarMoedaDesembolso();
        getViewHelper().setCodMoedaComissao(EnumTradeFinance.MOEDA_USD.getCodigo());
        
        getTradeFinNegocVO().setCindcdnegocswap(EnumSimNaoStr.NAO.getCodigo());
        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.NAO.getCodigo());
		// FINIMP INDIRETO (2692) OU REFINIMP INDIRETO (1717), SETA comissão do Brasil = "Sim"
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO) ||
			getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO))
			getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.SIM.getCodigo());
		else
			getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.NAO.getCodigo());
        getTradeFinNegocVO().setCindcdnegocarbtr(EnumSimNaoStr.NAO.getCodigo());
        getTradeFinNegocVO().setCsegurtrnspmcado(EnumSimNaoStr.SIM.getCodigo());
        getTradeFinNegocVO().setCsegurmcadoorgnz(EnumSimNaoStr.SIM.getCodigo());
        
        getItemListaFluxoPgto().setCfluxoliqdcprinc(EnumTradeFinance.PERIODICIDADE_SEMESTRAL.getCodigo());
        getItemListaFluxoPgto().setCodJurosPeriodicidade(EnumTradeFinance.PERIODICIDADE_SEMESTRAL.getCodigo());

        getTradeFinNegocVO().setVnegocmoedaestrg("0,00");
        getTradeFinNegocVO().setVtravaliborcmbio("0,00000");
        getTradeFinNegocVO().setVimpstnegoccmbio("0,00000");
        getTradeFinNegocVO().setViofnegoccmbio("0,00000");
        
		if (!getTradeFinNegocVO().getProduto().isNce() 
				|| getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo())) {
			getTradeFinNegocVO().setVtxmoracmbio("1,00000");
			getTradeFinNegocVO().setVmultanegoccmbio("2,00000");
		}
		
        getTradeFinNegocVO().setCbasejuromora(EnumTradeFinance.JUROS_DE_MORA_AO_MES.getCodigo());
        itemListaComissaoInterna.setVmincobrcomis("0,00");
        getViewHelper().setVmincobrcomis("0,00");
        itemListaComissaoInterna.setPtxcustototal("0,00000");
        itemListaComissaoInterna.setVtxspreadnegoc("0,00000");
        itemListaComissaoInterna.setVtxspreadtot("0,00000");
        itemListaComissaoInterna.setPtxflatpnalt("0,00000");
        itemListaComissaoInterna.setVlxtotalcomis("0,00");
        getTradeFinNegocVO().setPtxequalcmbio("0,00000");
        getTradeFinNegocVO().setQprzmedcmbio(Numeros.NUM0);
        getTradeFinNegocVO().setCeconmmoedaequal(EnumTradeFinance.MOEDA_USD.getCodigo());
        getTradeFinNegocVO().setVprevtcmbioequal("0,00");
        getTradeFinNegocVO().setVtxspreadnegoc("0,00000");
        getTradeFinNegocVO().setCmoedaeconmrecta(EnumTradeFinance.MOEDA_USD.getCodigo());
        getTradeFinNegocVO().setVprevtrectacmbio("0,00");
        getTradeFinNegocVO().setCcobrcomisagte(Numeros.NUM0);
        getTradeFinNegocVO().setCcobrcomismtori(Numeros.NUM0);
        
        comissaoExtManutModalBean.getItemListaComissaoExterna().setCindcdeconmmoeda(getTradeFinNegocVO().getCindcdeconmmoeda());
        
        getViewHelper().setDataLimiteCotacao(commonService.getDataLimiteCotacao(new Date()));
        
        // Tela Fofaiting
        getTradeFinNegocVO().setCcobrcomisadcio(EnumSimNaoStr.SIM.getCodigo());
        
        // limpa justificativa do desenquadramento
        getTradeFinNegocVO().setRjustfdqmto(null);

    }

    	/**
    	* Nome: atribuirValoresDefaultLei4131
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 20/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    protected void atribuirValoresDefaultLei4131Ppe() {
        getTradeFinNegocVO().setCsegurtrnspmcado(EnumSimNaoStr.NAO.getCodigo());
        getTradeFinNegocVO().setCsegurmcadoorgnz(EnumSimNaoStr.NAO.getCodigo());
    }
    
    /**
     * 
    	* Nome: atribuirValoresDefaultBNDES
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 01/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    protected void atribuirValoresDefaultBNDES() {
        getTradeFinNegocVO().setPagtefincrcmbio("0,00");
        getTradeFinNegocVO().setVtxremunbndes("0,00");
        getTradeFinNegocVO().setPjuronegoccmbio("0,00");
        getTradeFinNegocVO().setPtotjurocmbio("0,00");
        
        // BNDES Pré (663, 664, 665, 666, 667, 670, 3934)
        if (getTradeFinNegocVO().getProduto().isBndesPre()) {
            
            getTradeFinNegocVO().getObsCotacaoVO().setTxapre(EnumSimNaoStr.SIM.getCodigo());
        }
    }
    
    /****************************************************************** 
     * FIM - METODOS PARA MANIPULAR CAMPOS E VALORES DA TELA *
     * ****************************************************************/
    
    /*************************
     * METODOS DADOS BASICOS *
     *************************/
    
    /**
     * Nome: listenerCalcularValorLimite
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerCalcularValorLimite(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerCalcularValorLimite <<<<<<<<<<<");
    		
    		setBancoCorrespondenteParametro();
    		calcularValorLimite();
    		// Recalcular o SpreadClean (Libor)
    		if(getTrdFinNegPrecificacaoVO() != null 
    		        && !SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getCindcdeconmmoeda())
    		        && !SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getPrzomediodsemb())) {
    		    
    		    calcularCustoExterno();
    	    }
    		
    		// Recalcular o custo total, se já tiver comissão interna inserida
    		if(!getTradeFinNegocVO().getListaComissaoInterna().isEmpty()) {
    		    calcularValoresSpreadFlatCustoTotalComissaoInt();
    		}
    		getViewHelper().setCodMoedaComissao(getTradeFinNegocVO().getCindcdeconmmoeda());
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerCalcularValorLimite <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: listenerTrocaValorMe
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTrocaValorMe(AjaxBehaviorEvent e) {
    	
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaValorMe <<<<<<<<<<<");
            
            setBancoCorrespondenteParametro();
            // se fluxo de pagamento preenchido
            if(getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0) {
                //NpcFacesUtils.addInfoModalMessage("Recalcular os fluxos de pagamento de principal, juros e comissões", false);
                setValidaListenerTrocaValorMe(true);
                
        		if ((getViewHelper().getItemSelecListaFluxos() == "" || getViewHelper().getItemSelecListaFluxos() == null) && getTradeFinNegocVO().getListaFluxos().size() > 0) {
        			getViewHelper().setItemSelecListaFluxos(SiteUtil.getString(getTradeFinNegocVO().getListaFluxos().size() -1));
    			}
        		listenerShowFluxoPgtSel(e);
        		
                itemListaFluxoPgto.setVprevtdsembcmbio(tradeFinNegocVO.getVnegocmoedaestrg());
                listenerAlterarFluxo(e);                
            } // comissão interna já incluída
            else if (getTradeFinNegocVO().getListaComissaoInterna() != null 
                    && getTradeFinNegocVO().getListaComissaoInterna().size() > 0
                    && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getListaComissaoInterna().get(0).getVprevtcomiscmbio())
                    && !SiteUtil.isValueZero(getTradeFinNegocVO().getListaComissaoInterna().get(0).getVprevtcomiscmbio())) {
                NpcFacesUtils.addInfoModalMessage("Recalcular os fluxos de Comissão Interna (Spread).", false);
            } 
            
            //trocaCobrancaComissao();
            calcularValorLimite();
            
          
            if (getTradeFinNegocVO().getListaFluxos() == null
                            || getTradeFinNegocVO().getListaFluxos().isEmpty()
                            || getTradeFinNegocVO().getListaFluxos().size() <= Numeros.ZERO) {
                itemListaFluxoPgto.setVprevtdsembcmbio(tradeFinNegocVO.getVnegocmoedaestrg());
            }
            listenerExcluirComissaoInterna(null);
            // limpar dados da comissão interna para produtos que não tem fluxo de pagamento
            if (getTradeFinNegocVO().getProduto().isGarantia()) {
                limparDadosComissaoInterna();
            }
    		
        }finally{
        	if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter());
	    		if (taxaFixaMaiorQueZero(custoTotal.toString())) {
					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
					} else {
						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
					}
				}
        	} else if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || getTradeFinNegocVO().getCcomiscartanacio().equals("2")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter(), getItemListaComissaoInterna().getVtxspreadtot());
				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
					} else {
						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
					}
				}
            }
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaValorMe <<<<<<<<<<<");
        }
    }

    /**
     * Nome: setBancoCorrespondenteParametro
     * 
     * Propósito: Consulta os parametros de Faixa para setar o banco correspondente e a comissão de desembolso do banqueiro para o produto LC
     *
    	    Seta a Banco Correspondente para os produtos
    	    
			0644 Desconto de Saque no Exterior - Forfaiting  
    		1717 Refinanciamento de Importação Banco a Banco
    		1715 Financiamento à Importação de Longo Prazo - Export Credit Agencies 
    		1646 Refinanciamento de Importação Direto 
    		1644 Financiamento de Importação Direto
    		1642 Pré-pagamento de Exportação
    		2011 Working Capital - Capital de Giro no Exterior
    		2010 Empréstimo Internacional - Lei 4.131  
    		2692 Financiamento de Importação Banco a Banco
    		
    	    Seta a Comissao de desembolso do banqueiro para produto:
    	    
			0644 Desconto de Saque no Exterior - Forfaiting  
    	
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void setBancoCorrespondenteParametro() {
    	
        if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)			|| 
           getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131) 			|| 
           getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)	|| 
           getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)		|| 
           getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA) 				|| 
           getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)				|| 
           getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)	|| 
           getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)	|| 
           getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) { 
    	
			if (!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCindcdeconmmoeda()) &&
	            !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) &&
	            !SiteUtil.isValueZero(getTradeFinNegocVO().getVnegocmoedaestrg())) {
				
				// Busca Banco Correspondente no parâmetro
				ParametroUnidadeExternaVO filtroParametroOperacao = new ParametroUnidadeExternaVO();
				filtroParametroOperacao.setCprodtservc(getTradeFinNegocVO().getCprodtservc());
				filtroParametroOperacao.setCindcdeconmmoeda(getTradeFinNegocVO().getCindcdeconmmoeda());
				filtroParametroOperacao.setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());
	
				ParametroUnidadeExternaVO parametroUnidadeExterna = parametroUnidadeExternaService.detalhar(filtroParametroOperacao);
	
				if(parametroUnidadeExterna.getListaFaixaOperacao().size() > 0) {
	    			FaixaOperacaoVO faixa = parametroUnidadeExterna.getListaFaixaOperacao().get(0);
	
	    			getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setCbanqrcmbio(faixa.getBanco().getCbanqrcmbio());
	    			getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setIbanqrcmbio(faixa.getBanco().getIbanqrcmbio());
	    			//getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setBancocorr(faixa.getBanco().getIbanqrcmbio());
	    			getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setImunintlcmbio(faixa.getBanco().getImunintlcmbio());
				}
				
			}
        }
				
        if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING) && 
           !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCindcdeconmmoeda()) 		&&
           !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) 		&&
           !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCeconmmoedadsemb())) {
        	
        	getTrdFinNegPrecificacaoVO().setVlrcomisdsemb(pesquisarParametroComissaoDesembolso());	
        }
    }

    /**
     * Nome: pesquisarParametroComissaoDesembolso
     * 
     * Propósito: Consulta os parametros de Faixa para setar os campos de banqueiro, praça e parametros de comissão de desembolso para setar 
     * o valor mínimo da comissão interna 
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public String pesquisarParametroComissaoDesembolso() {
    	
    	String valorComissaoFixa = "";    	
    	
		ComissaoDesembolsoVO comissaodesembolso = new ComissaoDesembolsoVO();
		
		comissaodesembolso.setCprodtservc(getTradeFinNegocVO().getCprodtservc());			// PRODUTO
		comissaodesembolso.setCindcdeconmmoeda(getTradeFinNegocVO().getCeconmmoedadsemb());	// MOEDA DO DESEMBOLSO
		
		List<ComissaoDesembolsoVO> retornooperacao = comissaodesembolsoservice.pesquisar(comissaodesembolso, 1);
		
		if(retornooperacao.size() > 0) {
			ComissaoDesembolsoVO comissaodesemb = retornooperacao.get(0);
			if(SiteUtil.webMoedaToDouble(getTradeFinNegocVO().getVnegocmoedaestrg()) < SiteUtil.webMoedaToDouble(comissaodesemb.getVlimcomisfixa())) {
				valorComissaoFixa = comissaodesemb.getVcomisfixa();
			}
		}

		return valorComissaoFixa;
    }
    
    /**
     * Nome: calcularValorLimite
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void calcularValorLimite() {

        getTradeFinNegocVO().setCeconmmoedalim(getLimiteVO().getCindcdeconmmoeda());
        getTradeFinNegocVO().setNppstapontucmbio(getLimiteVO().getNseqcontrppl());
        getTradeFinNegocVO().setNseqcontrlim(getLimiteVO().getNcontrlim());

        if (SiteUtil.isEmptyOrNull(getLimiteVO().getPspreadprodt()) == false) {
            getItemListaComissaoInterna().setPtxcustototal(getLimiteVO().getPspreadprodt());
        }

        getTradeFinNegocVO().setVmoedalimgerc("0,00");

        if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCindcdeconmmoeda())
                || SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg())
                || SiteUtil.isValueZero(getTradeFinNegocVO().getVnegocmoedaestrg())
                || SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCeconmmoedalim())) {
            return;
        }

        getTradeFinNegocVO().setDfchtobletocmbio(SiteUtil.dataWebToMainframe(new Date()));
        getTradeFinNegocVO().setVmoedalimgerc(tradeFinanceNegociacaoService.getConverterValorParaMoedaLimite(getTradeFinNegocVO()));
        
        // Calcular valor na moeda do limite + about
        getTradeFinNegocVO().setVlMoedaLimite(getTradeFinNegocVO().getVmoedalimgerc());
        if(!SiteUtil.isValueZero(getTradeFinNegocVO().getVlimcobervar())) {
            getTradeFinNegocVO().setVlMoedaLimite(tradeFinanceNegociacaoService.somaAboutValorLimite(getTradeFinNegocVO()));
        }
    }
    
    protected void consultaSituacaoPiloto() {
        
        getTradeFinNegocVO().setInformacaoPiloto(tradeFinanceNegociacaoService.consultarSituacaoPiloto(getTradeFinNegocVO().getCunicclicmbio()));
        // Caso o piloto está ativo e o cliente nao opera com limite
        // Não irá liberar para operar com limite
        if (getTradeFinNegocVO().getInformacaoPiloto().isPilotoAtivo()
                        && !getTradeFinNegocVO().getInformacaoPiloto().isClientePiloto()) {
            getViewHelper().setOperaComLimite(false);
        } else {
            getViewHelper().setOperaComLimite(true);
        }
        
    }
    /**
     * Nome: listenerTrocaMoedaDesembolso
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTrocaMoedaDesembolso(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaMoedaDesembolso <<<<<<<<<<<");
    		
            setBancoCorrespondenteParametro();
    		trocarMoedaDesembolso();
			if (getTradeFinNegocVO().getListaComissaoInterna() != null && getTradeFinNegocVO().getListaComissaoInterna().size() > 0 ) {
				if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
    				BigDecimal custoTotal = calcularCustoTotal(getTradeFinNegocVO().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter());
    				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
    					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
    	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
    					} else {
    						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
    					}
    				}
				} else if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || getTradeFinNegocVO().getCcomiscartanacio().equals("2")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
    				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter(), getItemListaComissaoInterna().getVtxspreadtot());
    				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
    					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
    	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
    					} else {
    						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
    					}
    				}
                }
			}
            if(getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0){
                setValidaListenerTrocaValorMe(true);
        		if ((getViewHelper().getItemSelecListaFluxos() == "" || getViewHelper().getItemSelecListaFluxos() == null) && getTradeFinNegocVO().getListaFluxos().size() > 0) {
        			getViewHelper().setItemSelecListaFluxos(SiteUtil.getString(getTradeFinNegocVO().getListaFluxos().size() -1));
    			}
                listenerShowFluxoPgtSel(e);
                itemListaFluxoPgto.setTdiaopercmbio(tradeFinNegocVO.getTdiaopercmbio());
                openModalFluxoPgto();
            }
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaMoedaDesembolso <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: trocarMoedaDesembolso
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void trocarMoedaDesembolso() {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.trocarMoedaDesembolso <<<<<<<<<<<");
    		
    		for (int j = 0; j < getViewHelper().getComboMoedaDesembolso().size(); j++) {
    			if (getViewHelper().getComboMoedaDesembolso().get(j).getValue().equals(getTradeFinNegocVO().getCeconmmoedadsemb())) {
    				getViewHelper().setNomeMoedaDesembolso(getViewHelper().getComboMoedaDesembolso().get(j).getLabel());
    			}
    		}

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.trocarMoedaDesembolso <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: listenerTratarSwap
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTratarSwap(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarSwap <<<<<<<<<<<");
    		
    		int codSimNaoSwap = Numeros.ZERO;
    		
    		codSimNaoSwap = Integer.valueOf(getTradeFinNegocVO().getCindcdnegocswap());
    		if (codSimNaoSwap == EnumSimNao.SIM.getCodigo()) {
    			getViewHelper().setDisabledCheckLibor(Boolean.FALSE);
    			getViewHelper().setDisabledCheckFluxo(Boolean.FALSE);
    			getViewHelper().setDisabledCheckMeMn(Boolean.FALSE);
    			getViewHelper().setDisabledTxtSpreadAll(Boolean.FALSE);
    		} else {
    			getTradeFinNegocVO().setPtxswapcmpdo("");
    			getTradeFinNegocVO().setCtpocotactx(0);
    			getTradeFinNegocVO().setCindcdnegoclibor(Boolean.FALSE);
    			getTradeFinNegocVO().setCnegocswapfluxo(Boolean.FALSE);
    			getTradeFinNegocVO().setCnegocswapestrg(Boolean.FALSE);
    			
    			
    			getViewHelper().setDisabledCheckLibor(Boolean.TRUE);
    			getViewHelper().setDisabledCheckFluxo(Boolean.TRUE);
    			getViewHelper().setDisabledCheckMeMn(Boolean.TRUE);
    			getViewHelper().setDisabledComboPtax(Boolean.TRUE);
    			getViewHelper().setDisabledTxtSpreadAll(Boolean.TRUE);
    		}
    		
    		listenerTratarCheckMeMn(null);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarSwap <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: listenerTratarCheckMeMn
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTratarCheckMeMn(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarCheckMeMn <<<<<<<<<<<");
    		
    		if (getTradeFinNegocVO().isCnegocswapestrg() == Boolean.TRUE) {
    			getViewHelper().setDisabledComboPtax(Boolean.FALSE); 
    		} else {
    			getViewHelper().setDisabledComboPtax(Boolean.TRUE);
    			getTradeFinNegocVO().setPtxswapcmpdo(null);
    			getTradeFinNegocVO().setCtpocotactx(0);
    		}

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarCheckMeMn <<<<<<<<<<<");
    	}
    	

    }
    
    	/**
    	* Nome: listenerTrocaModalidade
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 11/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaModalidade(AjaxBehaviorEvent ev) {
        
        String[] partesDescricao = null;
        String siglaModalidade = null;
        
        viewHelper.setDisabledRadioStandBy(Boolean.FALSE);
        
        if (!getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO) 
                && !getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)
                && !getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)
                && !getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)
                && !getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
            return;
        }

        for (int j = 0; j < viewHelper.getComboModalidade().size(); j++) {
            if (viewHelper.getComboModalidade().get(j).getValue()
                    .equals(tradeFinNegocVO.getCmodldprodtcmbio())) {
                partesDescricao = viewHelper.getComboModalidade().get(j).getLabel().split("-");
                siglaModalidade = partesDescricao[0].trim();
                break;
            }
        }
        
        if(!SiteUtil.isEmptyOrNull(siglaModalidade)) {
            
            switch (getTradeFinNegocVO().getProduto()) {
            
                case PRODUTO_FINIMP_DIRETO:
                case PRODUTO_REFINIMP_DIRETO:
                    
                    if (siglaModalidade.equals("DC")) {
                        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.SIM.getCodigo());
                        
                        viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
                        getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.SIM.getCodigo());
                    }
                    if (siglaModalidade.equals("DS")) {
                        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.NAO.getCodigo());
                        
                        viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
                        getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.NAO.getCodigo());
                    }
                    
                    break;
        
                case PRODUTO_LEI_4131:
                    
                    if (siglaModalidade.equals("EC") || siglaModalidade.equals("EY")) {
                        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.SIM.getCodigo());
                        
                        viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
                    }
                    if (siglaModalidade.equals("ES") || siglaModalidade.equals("ED")) {
                        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.NAO.getCodigo());
                        
                        viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
                    }
                    
                    break;
                    
                case PRODUTO_P_P_E:
                    
                    if (siglaModalidade.equals("PC") || siglaModalidade.equals("PY")) {
                        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.SIM.getCodigo());
                        
                        viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
                    }
                    if (siglaModalidade.equals("PD") || siglaModalidade.equals("PS")) {
                        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.NAO.getCodigo());
                        
                        viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
                    }
                    
                    break;
                    
                case PRODUTO_WORKING_CAPITAL:
                    
                    if (siglaModalidade.equals("WC") || siglaModalidade.equals("WY")) {
                        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.SIM.getCodigo());
                        
                        viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
                    }
                    if (siglaModalidade.equals("WD") || siglaModalidade.equals("WS")) {
                        getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.NAO.getCodigo());
                        
                        viewHelper.setDisabledRadioStandBy(Boolean.TRUE);
                    }
                    
                    break;
                    
                default:
                    break;
            }
            
        }
        
        tratarStandBy();
		tratarComissaoBrasil();
    }

    /**
     * Nome: listenerTratarStandBy
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTratarStandBy(AjaxBehaviorEvent e) {
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarStandBy <<<<<<<<<<<");
    		tratarStandBy();
			tratarComissaoBrasil();
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarStandBy <<<<<<<<<<<");
    	}
    	
    }
    
    public void listenerTratarComissaoBrisil(AjaxBehaviorEvent e) {
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarComissaoBrisil <<<<<<<<<<<");
    		listenerExcluirComissaoInterna(null);
    		// limpar dados da comissão interna para produtos que não tem fluxo de pagamento
    		if (getTradeFinNegocVO().getProduto().isGarantia()) {
    			limparDadosComissaoInterna();
    		}
            
            if (getViewHelper().getValueComissaoCobranca() != null && getViewHelper().getValueComissaoCobranca() != "") {
            	listenerIncluirComissaoInterna(null);
			}
            
    		if (getTradeFinNegocVO().getListaComissaoInterna() != null && getTradeFinNegocVO().getListaComissaoInterna().size() > 0 ) {
    			if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
    				BigDecimal custoTotal = calcularCustoTotal(getTradeFinNegocVO().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter());
    				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
    					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
    	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
    					} else {
    						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
    					}
    				}
    			} else if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || getTradeFinNegocVO().getCcomiscartanacio().equals("2")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
    				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter(), getItemListaComissaoInterna().getVtxspreadtot());
    				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
    					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
    	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
    					} else {
    						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
    					}
    				}
    			}
    		}
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarComissaoBrisil <<<<<<<<<<<");
    	}
    	
    }
    
    public void tratarStandBy() {

        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.tratarStandBy <<<<<<<<<<<");
            
            int codSimNaoStandBy = Numeros.ZERO;
            
            codSimNaoStandBy = Integer.valueOf(getTradeFinNegocVO().getCindcdnegoccarta());
            if (codSimNaoStandBy == EnumSimNao.SIM.getCodigo()) {
                getTradeFinNegocVO().setTdiavalddletra(getViewHelper().getTdiamaxcredt());
        		getViewHelper().setDisabledTxtPrazoStandBy(Boolean.FALSE);
            } else {
                getTradeFinNegocVO().setTdiavalddletra(Numeros.ZERO);
                getViewHelper().setDisabledTxtPrazoStandBy(Boolean.TRUE);
            }
            
            calcularValoresSpreadFlatCustoTotalComissaoInt();

        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.tratarStandBy <<<<<<<<<<<");
        }
        
    }
    
    public void tratarComissaoBrasil() {

        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.tratarComissaoBrasil <<<<<<<<<<<");
            
            int codSimNaoStandBy = Numeros.ZERO;
            
            codSimNaoStandBy = Integer.valueOf(getTradeFinNegocVO().getCindcdnegoccarta());
            if (codSimNaoStandBy == EnumSimNao.SIM.getCodigo()) {
        		// Produtos PPE (1642) ou WORKING CAPITAL (2011)
        		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E) || 
        			getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL))
        			getTradeFinNegocVO().setCcomiscartanacio((EnumSimNaoStr.NAO.getCodigo()));
                else
        			getTradeFinNegocVO().setCcomiscartanacio((EnumSimNaoStr.SIM.getCodigo()));
            }

        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.tratarComissaoBrasil <<<<<<<<<<<");
        }
        
    }
    
    /**
     * Nome: validarDiaUtil
     * 
     * Propósito: Valida se a data informada é dia util no país
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/08/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void validarDiaUtil(AjaxBehaviorEvent event) {

        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.validarDiaUtil <<<<<<<<<<<");
            
            Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            Integer campoData = SiteUtil.getInt(params.get("campoData"));
            EnumCampoData enumCampoData = EnumCampoData.fromCode(campoData);
            
            Date data = null;
            Integer cdPais = Numeros.ZERO;
            Integer ecindcdeconm = Numeros.ZERO;
            
            switch (enumCampoData) {
                case LIMITE_COTACAO:
                    
                    data = getViewHelper().getDataLimiteCotacao();
                    
                    break;
                case PREVISAO_DESEMBOLSO:
                    
                    // Carrega a data informada de desembolso no campo fluxo de pagamento
                    getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDatePrevDesembolso());              
                    
                	if ((getViewHelper().getItemSelecListaFluxos() == "" || getViewHelper().getItemSelecListaFluxos() == null) && (getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0)) {
            			getViewHelper().setItemSelecListaFluxos(SiteUtil.getString(getTradeFinNegocVO().getListaFluxos().size() -1));
            			
            			listenerShowFluxoPgtSel(null);
            			listenerAlterarFluxo(null);
        			}
                    
                    data = getViewHelper().getDatePrevDesembolso();
                    cdPais = getTradeFinNegocVO().getCpais();
                    
                    break;

                case PREVISAO_EMISSAO:
                	
                	// Carrega a data informada de desembolso no campo fluxo de pagamento
                	getViewHelper().setDateFluxoPgtoTemp(getTradeFinNegocVO().getDprevtgarntexpdi());              
                	
                	data = getTradeFinNegocVO().getDprevtgarntexpdi();
                	cdPais = getTradeFinNegocVO().getCpais();
                	
                	break;
                case DISPONIBILIDADE_LINHA:
                    
                    data = getViewHelper().getDataDisponibilidade();
                    
                    break;
                case PREVISAO_DESEMBOLSO_INICIO:
                    
                    data = getTradeFinNegocVO().getDataPrevDesemb().getInicio();
                    
                    break;
                case PREVISAO_DESEMBOLSO_FIM:
                    
                    data = getTradeFinNegocVO().getDataPrevDesemb().getFim();
                    
                    break;
                case PREVISAO_EMBARQUE_INICIO:
                    
                    data = getTradeFinNegocVO().getDataPrevEmbarq().getInicio();
                    
                    break;
                case PREVISAO_EMBARQUE_FIM:
                    
                    data = getTradeFinNegocVO().getDataPrevEmbarq().getFim();
                    
                    break;
                    
                case VENCIMENTO_SAQUE:
                    
                    data = getViewHelper().getVencimentoSaque();
                    
                    break;
                default:
                    
                    break;
            }
            
            if(campoData.equals(EnumCampoData.PREVISAO_DESEMBOLSO.getCodigo())) {
                ecindcdeconm = getTradeFinNegocVO().getCeconmmoedadsemb();
                
                /** Antes de chamar o Fluxo para calcular o fluxo de pagamento irá chamar o serviço
                 * do Inec para devolver o código do  Páis Moeda e a descrição
                 */
				if (ecindcdeconm.equals(Numeros.QUINZE)) {
					getTradeFinNegocVO().setCpaisInec(null);
				} else {
					getTradeFinNegocVO().setCpaisInec(tradeFinanceNegociacaoService.inecIndicadorEconomico(ecindcdeconm));
				}
           
            }
            validarListenerDiaUtil = commonService.validarDiaUtil(data, cdPais, "1", getTradeFinNegocVO().getCpaisInec(), getTrdFinNegMercadoriaVO().getCpaisbnefc(), ecindcdeconm);
            if(data != null && validarListenerDiaUtil == false) {
                NpcFacesUtils.addInfoModalMessage("Data " + enumCampoData.getDescricao() + " inválida.", false);
            } 
        } finally {
        	if (validarListenerDiaUtil == false && itemListaFluxoPgto.getListaParcelasFluxoPgto() != null && !itemListaFluxoPgto.getListaParcelasFluxoPgto().isEmpty()) {
        		getTradeFinNegocVO().setListaFluxos(new ArrayList<TrdFinNegFluxoPagtoVO>());
        		itemListaFluxoPgto.setListaParcelasFluxoPgto(new ArrayList<TrdFinNegParcelaVO>());
        		fluxoPgtoManutModalBean.closeModal(null);
			}
        	if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
//    		if (getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) {
				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter());
	    		if (taxaFixaMaiorQueZero(custoTotal.toString())) {
					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
					} else {
						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
					}
				}
    		} else if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || getTradeFinNegocVO().getCcomiscartanacio().equals("2")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter(), getItemListaComissaoInterna().getVtxspreadtot());
				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
					} else {
						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
					}
				}
            }
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.validarDiaUtil <<<<<<<<<<<");
        }
        
    }

    /**
     * Nome: validarDiaUtilRecalculaPrazoOperacao
     * 
     * Propósito: Valida se a data informada é dia util no país
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/08/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void validarDiaUtilRecalculaPrazoOperacao(AjaxBehaviorEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.validarDiaUtilRecalculaPrazoOperacao <<<<<<<<<<<");
    		
    		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    		Integer campoData = SiteUtil.getInt(params.get("campoData"));
    		EnumCampoData enumCampoData = EnumCampoData.fromCode(campoData);
    		
    		Date data = null;
    		Integer cdPais = Numeros.ZERO;
    		Integer ecindcdeconm = Numeros.ZERO;;
    		
    		switch (enumCampoData) {
    		case LIMITE_COTACAO:
    			
    			data = getViewHelper().getDataLimiteCotacao();
    			
    			break;
    		case PREVISAO_DESEMBOLSO:
    			
    			// Carrega a data informada de desembolso no campo fluxo de pagamento
    			getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDatePrevDesembolso());              
    			
    			data = getViewHelper().getDatePrevDesembolso();
    			cdPais = getTradeFinNegocVO().getCpais();
              
    			break;
    			
    		case PREVISAO_EMISSAO:
    			
    			// Carrega a data informada de desembolso no campo fluxo de pagamento
    			getViewHelper().setDateFluxoPgtoTemp(getTradeFinNegocVO().getDprevtgarntexpdi());              
    			
    			data = getTradeFinNegocVO().getDprevtgarntexpdi();
    			cdPais = getTradeFinNegocVO().getCpais();
    			
    			break;
    		case DISPONIBILIDADE_LINHA:
    			
    			data = getViewHelper().getDataDisponibilidade();
    			
    			break;
    		case PREVISAO_DESEMBOLSO_INICIO:
    			
    			data = getTradeFinNegocVO().getDataPrevDesemb().getInicio();
    			
    			break;
    		case PREVISAO_DESEMBOLSO_FIM:
    			
    			data = getTradeFinNegocVO().getDataPrevDesemb().getFim();
    			
    			break;
    		case PREVISAO_EMBARQUE_INICIO:
    			
    			data = getTradeFinNegocVO().getDataPrevEmbarq().getInicio();
    			
    			break;
    		case PREVISAO_EMBARQUE_FIM:
    			
    			data = getTradeFinNegocVO().getDataPrevEmbarq().getFim();
    			
    			break;
    			
    		case VENCIMENTO_SAQUE:
    			
    			data = getViewHelper().getVencimentoSaque();
    			
    			break;
    		default:
    			
    			break;
    		}
    		
    		  if(campoData.equals(EnumCampoData.PREVISAO_DESEMBOLSO.getCodigo())) {
                  ecindcdeconm = getTradeFinNegocVO().getCeconmmoedadsemb();
                  
                  /** Antes de chamar o Fluxo para calcular o fluxo de pagamento irá chamar o serviço
                   * do Inec para devolver o código do  Páis Moeda e a descrição
                   */
  				if (ecindcdeconm.equals(Numeros.QUINZE)) {
  					getTradeFinNegocVO().setCpaisInec(null);
				} else {
					getTradeFinNegocVO().setCpaisInec(
							tradeFinanceNegociacaoService
									.inecIndicadorEconomico(ecindcdeconm));
				}
                
             
              }
    
    		if(data != null 
    				&& !commonService.validarDiaUtil(data, cdPais, "1", getTradeFinNegocVO().getCpaisInec(), getTrdFinNegMercadoriaVO().getCpaisbnefc(), ecindcdeconm)) {
    			NpcFacesUtils.addInfoModalMessage("Data " + enumCampoData.getDescricao() + " inválida.", false);
    			getViewHelper().setDateVencFianc(null);
    			return;
    		}
    		
    		if(getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0){
                NpcFacesUtils.addInfoModalMessage("Recalcular os fluxos de pagamento de principal, juros e comissões", false);
            }

            // limpar dados da comissão interna
    		limparDadosComissaoInterna();
            
            // Para o Garantia não tem o fluxo de pagamento, por isso a utilização dessa validdação
            if(!getTradeFinNegocVO().getProduto().isGarantia()) {
              limpaFluxoPgtComissaoInt();
              limpaFluxoPgtComissaoExterna();
                
            }
    		
    	} finally {
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.validarDiaUtilRecalculaPrazoOperacao <<<<<<<<<<<");
    	}
    	
    }
    
    
    /**
     * Nome: listenerCalculaDataVencimentoSaque
     * 
     * Propósito: Valida se a data informada é dia util no país e calcula prazo financiamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     */
    public void listenerCalculaDataVencimentoSaque(AjaxBehaviorEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerCalculaDataVencimentoSaque <<<<<<<<<<<");
    		
			if (getViewHelper().getVencimentoSaque() != null && getViewHelper().getDatePrevDesembolso() != null) {
				getTradeFinNegocVO().setTdiaopercmbio(commonService.getPrazoFinanciamento(getViewHelper().getDatePrevDesembolso(), Numeros.DOIS, viewHelper.getVencimentoSaque()));
				trocaPrazoFinancForfaiting();
            }                
    		
    	} finally {
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerCalculaDataVencimentoSaque <<<<<<<<<<<");
    	}
    	
    }


    /**
     * Nome: listenerValidarDataEmbarque
     * 
     * Propósito: Valida se a data informada é dia util no país
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/08/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerValidarDataEmbarque(AjaxBehaviorEvent event) {

        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerValidarDataEmbarque <<<<<<<<<<<");
            
            validarDataEmbarqueForfaiting();

            Date dtPrevtembrq = getDesembolsoForfaitingVO().getDprevtembrq();
            
    		viewHelper.setVencimentoSaque(commonService.getDataVencimentoSaque(dtPrevtembrq, Numeros.DOIS, getTradeFinNegocVO().getTdiavalddletra()));

        } finally {
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerValidarDataEmbarque <<<<<<<<<<<");
        }
        
    }
    
    
    /**
     * Nome: listenerValidarDataDesembolso
     * 
     * Propósito: Valida se a data informada é dia util no país e calcula prazo financiamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     */
    public void listenerValidarDataDesembolso(AjaxBehaviorEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerValidarDataDesembolso <<<<<<<<<<<");
    		
			validarDataPrevDesembolsoForfaiting();
    		
    	} finally {
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerValidarDataDesembolso <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: listenerValidarDataVencimento
     * 
     * Propósito: Valida se a data informada é dia util no país e calcula prazo financiamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     */
    public void listenerValidarDataVencimento(AjaxBehaviorEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerValidarDataVencimento <<<<<<<<<<<");
    		
    		validarDataVencimentoForfaiting();
    		
    	} finally {
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerValidarDataVencimento <<<<<<<<<<<");
    	}
    	
    }

    /******************************* 
     * FIM - METODOS DADOS BASICOS *
     *******************************/
    
    /*************************
     * INICIO - METODOS LIMITES *
     *************************/
    
    /**
     * 
        * Nome: pesquisarLimite
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 21/06/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
     */
    public void pesquisarLimite(AjaxBehaviorEvent e) {
       if(getViewHelper().isOperaComLimite() == true) {
           tratarListaLimite();
       }
    }
    
    /**
     * Nome: tratarListaLimite
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void tratarListaLimite() {
        
        limitesModalBean.getViewHelper().setCodItemSelecionadoLimite(null);
        limitesModalBean.getViewHelper().setCodItemSelecionadoProposta(null);
        
        // PROEX não seleciona limite
        if(!getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX) && getTradeFinNegocVO().getInformacaoPiloto().isOperarComLimite()) {
                    
            // Abre modal de limites se produto e cliente estiver selecionado
            if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCprodtservc()) 
                    && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCunicclicmbio())) {
                
                if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
                    limitesModalBean.getViewHelper().setIsConfirmaModallimite(Boolean.FALSE);
                    limitesModalBean.getViewHelper().setModalId("formTradeFinNegoc\\:modalLimites");
                } else {
                    limitesModalBean.getViewHelper().setIsConfirmaModallimite(Boolean.FALSE);
                    limitesModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalLimites");
                }
                
                getLimiteVO().setProduto(getTradeFinNegocVO().getCprodtservc());
                getLimiteVO().setCunicpssoacmbio(getTradeFinNegocVO().getCunicclicmbio());
                
                limitesModalBean.getViewHelper().setTratarSelecionarProposta(Boolean.TRUE);
                limitesModalBean.setLimiteVO(limiteVO);
                limitesModalBean.openModal();
                
            }
        } 
    }
    
    /**
     * Nome: closeModalLimites
     * 
     * Propósito: Fecha o Modal de Lilite e Proposta
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalLimites(ActionEvent event) {

        try {
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalLimites <<<<<<<<<<<");

            if (limitesModalBean.getViewHelper().getIsConfirmaModallimite() == Boolean.TRUE) {

                getTradeFinNegocVO().setMoedaLimite(getLimiteVO().getDescrmoeda());
                getTradeFinNegocVO().setCeconmmoedalim(getLimiteVO().getCindcdeconmmoeda());
                getTradeFinNegocVO().setNseqcontrlim(getLimiteVO().getNcontrlim());
                getTradeFinNegocVO().setNppstapontucmbio(getLimiteVO().getNseqcontrppl());
                getItemListaComissaoInterna().setPtxcustototal(getLimiteVO().getPspreadprodt());
                
                if (getTradeFinNegocVO().getNseqcontrlim() != null
                        && !getTradeFinNegocVO().getNseqcontrlim().equals(Numeros.ZERO)) {
                    getViewHelper().setnAprvCred(getTradeFinNegocVO().getNseqcontrlim());
                } else if (getTradeFinNegocVO().getNppstapontucmbio() != null
                        && !getTradeFinNegocVO().getNppstapontucmbio().equals(Numeros.ZERO)) {
                    getViewHelper().setnAprvCred(getTradeFinNegocVO().getNppstapontucmbio());
                }

                // Atualizar o valor do spread aprovado na lista de comissão interna
                if (getTradeFinNegocVO().getListaComissaoInterna() != null 
                        && getTradeFinNegocVO().getListaComissaoInterna().size() > Numeros.ZERO) {
                    
                    for (TrdFinNegComissaoVO item : getTradeFinNegocVO().getListaComissaoInterna()) {
                        item.setPtxcustototal(getLimiteVO().getPspreadprodt());
                    }
                }

                calcularValorLimite();
            }

            limitesModalBean.closeModal(event);

        } finally {
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalLimites <<<<<<<<<<<");
        }

    }
    
    /**
     * Nome: openModalDesenquadradas
     * 
     * Propósito: Carrega modal de operações desenquadradas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected Boolean openModalDesenquadradas(Integer telaOrigem) {
        
        try {
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalDesenquadradas <<<<<<<<<<<");
            
            Boolean result = Boolean.FALSE;

            desenquadradas.atualizaValores(getTradeFinNegocVO(), getViewHelper().getDatePrevDesembolso(), getListaDesembolso());
            
            if (desenquadradas.getValoresAtualizados()
                    && getTradeFinNegocVO().getCtponegoccmbio().equals(Numeros.NUM2) 
                    && (!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getNseqcontrlim()) 
                            || !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getNppstapontucmbio()))
                            && tradeFinanceBean.getViewHelper().isOperaComLimite() == true) {
                
                desenquadradasModalBean.setDesenquadradas(desenquadradas);
                desenquadradasModalBean.getViewHelper().setTelaOrigem(telaOrigem);
                desenquadradasModalBean.openModal();

                
                // Verifica o indicador de desenquadradas e se já não foi informada a justificativa  
                if (desenquadradas.getInddqmto().equals(SiteUtil.STRING_S)) {
                    desenquadradasModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalDesenquadradas");
                    desenquadradasModalBean.getViewHelper().setRenderModalDesenquadradas(Boolean.TRUE);
                    result = Boolean.TRUE;
                }
            }
            
            return result;
            
        } finally {
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalDesenquadradas <<<<<<<<<<<");
        }
    }
    
    /**
     * Nome: closeModalDesenquadradas
     * 
     * Propósito: Metodo acionado ao fechar o modal de operações desenquadradas
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 03/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
     public void closeModalDesenquadradas(ActionEvent event) {
         
         try{
             getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalDesenquadradas <<<<<<<<<<<");

             // recupera a justificativa informada
             getTradeFinNegocVO().setRjustfdqmto(desenquadradasModalBean.getDesenquadradas().getJustificativa());
             
             desenquadradasModalBean.closeModal(event);
             
             // botão Confirmar
             if (desenquadradasModalBean.getViewHelper().getBotaoAcionado().equals(DesenquadradasModalBean.BTN_CONFIRMAR)) {
                 
                 if (validarFluxoConfirmar(desenquadradasModalBean.getViewHelper().getTelaOrigem()) == true) {
                     setControleInclusaoAlteracao("DadosBasicos");
                     continuarConfirmar();
                 }
             }        
             
         }finally{
             getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalDesenquadradas <<<<<<<<<<<");
         }
         
     }
    
    /*************************
     * FIM - METODOS LIMITES *
     *************************/
    
    /****************************
     * INICIO - Fluxo pagamento *
     ****************************/

    /**
     * Nome: listenerIncluirFluxo
     * 
     * Propósito: Metodo do botão "Incluir Fluxo"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirFluxo(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirFluxo <<<<<<<<<<<");
            
            getViewHelper().setFuncaoBotaoFluxo("Incluir");
    		// Trata campo data se função for prorrogar/alongar e produtos PPE, LEI 4131, WORKING CAPITAL
    		if (getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo())
    		        && getTradeFinNegocVO().getListaFluxos().size() > Numeros.ZERO) {
    		
    		    NpcFacesUtils.addInfoModalMessage("Fluxo Pagamento já incluido.", false);
                return;
            }
    		
    		if(getViewHelper().getDateFluxoPgtoTemp() == null) {
    		    NpcFacesUtils.addInfoModalMessage("O campo Data é obrigatório.", false);
                return;
    		} else if(SiteUtil.comparaDatas(getViewHelper().getDateFluxoPgtoTemp(), new Date()) < 0){
                
                NpcFacesUtils.addInfoModalMessage("A Data do desembolso não pode ser menor que a data atual.", false);
                return;
            } else if(!validarDataPrevisaoDesembolso()) {
    		    return;
    		}
    		
    		String dataTemp = null;
    		
    		//Para produtos do Grupo 2, Fininp ECA(Grupo 1), e NCE(Grupo 3).
    		if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO) 
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO) 
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO) 
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO) 
    				|| getTradeFinNegocVO().getProduto().isNce()
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)){
    			
    			itemListaFluxoPgto.setCindcdeconmc(getTradeFinNegocVO().getCeconmmoedadsemb());
    		}else{
    			itemListaFluxoPgto.setCindcdeconmc(0);
    		}
    		
             /** Antes de chamar o Fluxo para calcular o fluxo de pagamento irá chamar o serviço
              * do Inec para devolver o código do  Páis Moeda e a descrição
              */
			if (!itemListaFluxoPgto.getCindcdeconmc().equals(Numeros.QUINZE)) {
				getTradeFinNegocVO().setCpaisInec(tradeFinanceNegociacaoService.inecIndicadorEconomico(itemListaFluxoPgto.getCindcdeconmc()));
			}
             
			itemListaFluxoPgto.setTdiaopercmbio(tradeFinNegocVO.getTdiaopercmbio());
    		itemListaFluxoPgto.setListaParcelasFluxoPgto(new ArrayList<TrdFinNegParcelaVO>());
    		
    		if(getViewHelper().getDateProrrogacao() == null){
    			itemListaFluxoPgto.setDateFluxoPgto(getViewHelper().getDateFluxoPgtoTemp());
    			dataTemp = SiteUtil.dataWebToMainframe(itemListaFluxoPgto.getDateFluxoPgto());
    			itemListaFluxoPgto.setDprevtdsembcmbio(SiteUtil.trocarPontoPorBarra(dataTemp));        	
    		}else{
    			itemListaFluxoPgto.setDateFluxoPgto(SiteUtil.dataMainframeToWeb(tradeFinNegocVO.getDprevtprorrog()));
    			itemListaFluxoPgto.setDprevtdsembcmbio(tradeFinNegocVO.getDprevtprorrog());
    		}
    		
    		// COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
    		if (getTradeFinNegocVO().getProduto().isNce()) {
    			itemListaFluxoPgto.setCodJurosMomento(Numeros.DOIS);
    			itemListaFluxoPgto.setNdsembcmbiotrade(getViewHelper().getNumDesembFlxPgtoOperAditar());
    		}        
    		
            setarDescricaoDosCombosFlxPgto();            
            
            if (itemListaFluxoPgto.isTodasPeriodicidadeIrregular() == true) {
                
                if (getViewHelper().getDateFluxoPgtoTemp() == null) {
                    NpcFacesUtils.addInfoModalMessage("Data desembolso inválida.", false);
                    if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() > 10) {
                        SiteUtil.reiniciarPaginacao();
                    }
                    return;
                }
                
                if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getVprevtdsembcmbio()) == true) {
                    NpcFacesUtils.addInfoModalMessage("Valor desembolso inválido.", false);
                    if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() > 10) {
                        SiteUtil.reiniciarPaginacao();
                    }
                    return;
                }
                
                if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getPrincQtdParcelas()) == true ||
                                itemListaFluxoPgto.getPrincQtdParcelas() <= Numeros.NUM0) {
                    NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Principal inválida.", false);
                    if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() > 10) {
                        SiteUtil.reiniciarPaginacao();
                    }
                    return;
                }
                
                if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getJurosQtdParcelas()) == true ||
                                itemListaFluxoPgto.getJurosQtdParcelas() <= Numeros.NUM0) {
                    NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Juros inválida.", false);
                    if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() > 10) {
                        SiteUtil.reiniciarPaginacao();
                    }
                    return;
                }
                
                itemListaFluxoPgto.setTdiafinandsemb(tradeFinNegocVO.getTdiaopercmbio());
                
                itemListaFluxoPgto.setQtdeocorrprinc(itemListaFluxoPgto.getPrincQtdParcelas());
                itemListaFluxoPgto.setQtdeocorrjuros(itemListaFluxoPgto.getJurosQtdParcelas());
                
                getViewHelper().setDateFluxoPgtoTemp(null);
                
                openModalFluxoPgto();
                
                return;
                
            }
            
            if (itemListaFluxoPgto.isPeriodicidadeIrregular() == true) {
                if (itemListaFluxoPgto.getCfluxoliqdcprinc().equals(EnumTradeFinance.
                                PERIODICIDADE_IRREGULAR.getCodigo()) == true) {
                    if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getPrincQtdParcelas()) == true ||
                                    itemListaFluxoPgto.getPrincQtdParcelas() <= Numeros.NUM0) {
                     
                        NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Principal inválida.", false);
                        if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() > 10) {
                            SiteUtil.reiniciarPaginacao();
                        }
                        return;
                    }
                } else {
                    if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getJurosQtdParcelas()) == true ||
                                    itemListaFluxoPgto.getJurosQtdParcelas() <= Numeros.NUM0) {
                       
                        NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Juros inválida.", false);
                        if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() > 10) {
                            SiteUtil.reiniciarPaginacao();
                        }
                        return;
                    }
                }
                
                getViewHelper().setStateIdListaParcelasFluxoPgto("NPCCIAO6");
                
                itemListaFluxoPgto.setCpais(getTradeFinNegocVO().getCpais());
                
                if (!SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais())) {
                    itemListaFluxoPgto.setCpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais());
                }
                
                // Por: Cláudio Tadeu em 14/10/2019 - IN? - País Desembolso
   				itemListaFluxoPgto.setCpaismoedadsemb(getTradeFinNegocVO().getCpaisInec());
   	            // *****
                
                tradeFinanceNegociacaoService.getFluxoPagtoDePrincipalJuros(itemListaFluxoPgto, getTradeFinNegocVO().isPrazoOperacaoAjustado());
                
                ordenarListaParcelasFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto());
                
                getViewHelper().setDateFluxoPgtoTemp(null);
                
                openModalFluxoPgto();
                
                // Exibe mensagem de alerta se o 'Prazo Operação (Dias)' > 375 e 'Periodicidade Juros' <> de semestral
           		if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO) 
        				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)        				
        				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)        				
        				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)        				
        				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)        				
        				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)        				
        				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)){ 
           			
           			if(getTradeFinNegocVO().getTdiaopercmbio() > 375 && getItemListaFluxoPgto().getCodJurosPeriodicidade() != 8) {
           				NpcFacesUtils.addInfoModalMessage("Verificar SWAP de fluxo de juros.", false);
           			}
           			
           		}
                
                return;
            }

            // Nova rotina Irregular

            getViewHelper().setStateIdListaParcelasFluxoPgto("NPCCIAO6");
            
            itemListaFluxoPgto.setCpais(getTradeFinNegocVO().getCpais());
            
            if(getViewHelper().getDateFluxoPgtoTemp() != null 
                            && !commonService.validarDiaUtil(getViewHelper().getDateFluxoPgtoTemp(), itemListaFluxoPgto.getCpais(), "1", getTradeFinNegocVO().getCpaisInec(), getTrdFinNegMercadoriaVO().getCpaisbnefc(), getTradeFinNegocVO().getCeconmmoedadsemb())) {
                NpcFacesUtils.addInfoModalMessage("Data inválida Fluxo de pagamento", false);
                getViewHelper().setDateVencFianc(null);
                return;
            }
            
            // Por: Cláudio Tadeu em 14/10/2019 - IN? - País Desembolso
            if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getCpaismoedadsemb())) {
    			itemListaFluxoPgto.setCpaismoedadsemb(getTradeFinNegocVO().getCpaisInec());
            }
            // *****
            
            if (!SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais())) {
                itemListaFluxoPgto.setCpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais());
            }
            
            validaListenerTrocaPrazo = tradeFinanceNegociacaoService.getFluxoPagtoDePrincipalJuros(itemListaFluxoPgto, getTradeFinNegocVO().isPrazoOperacaoAjustado());
            
            if (!validaListenerTrocaPrazo) {
				return;
			}
            
            ordenarListaParcelasFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto());

    		getViewHelper().setDateFluxoPgtoTemp(null);
    		
    		openModalFluxoPgto();
    		
    		// Exibe mensagem de alerta se o 'Prazo Operação (Dias)' > 375 e 'Periodicidade Juros' <> de semestral
       		if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO) 
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)        				
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)        				
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)        				
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)        				
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)        				
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)){ 
       			
        		if(getTradeFinNegocVO().getTdiaopercmbio() > 375 && getItemListaFluxoPgto().getCodJurosPeriodicidade() != 8) {
        			NpcFacesUtils.addInfoModalMessage("Verificar SWAP de fluxo de juros.", false);
        		}      
        		
       		}

       		setItemListaFluxoPgtoAux(itemListaFluxoPgto);
    	}finally{
        	if (validaListenerTrocaPrazo == false && itemListaFluxoPgto.getListaParcelasFluxoPgto() != null && !itemListaFluxoPgto.getListaParcelasFluxoPgto().isEmpty()) {
        		getTradeFinNegocVO().setListaFluxos(new ArrayList<TrdFinNegFluxoPagtoVO>());
        		itemListaFluxoPgto.setListaParcelasFluxoPgto(new ArrayList<TrdFinNegParcelaVO>());
        		fluxoPgtoManutModalBean.closeModal(null);
        		NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
			}
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirFluxo <<<<<<<<<<<");
    	}
    	
        
    }
    
    /**
     * Nome: calcularCustoExterno
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void calcularCustoExterno() {
        
        getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.calcularCustoExterno <<<<<<<<<<<");
        
        getTrdFinNegPrecificacaoVO().setSpreadclean("0,00000");

        tradeFinanceNegociacaoService.getCustoExterno(trdFinNegPrecificacaoVO);
        
        calcularMesesLibor();
        
        getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.calcularCustoExterno <<<<<<<<<<<");
        
    }

    protected void calcularCustoExternoForfaiting() {
        
        getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.calcularCustoExternoForfaiting <<<<<<<<<<<");
        
        Integer qtdeMesesLibor = Numeros.ZERO;
        
        getTrdFinNegPrecificacaoVO().setSpreadclean("0,00000");

        if(getTradeFinNegocVO().getTdiaopercmbio() <= 375) {

            tradeFinanceNegociacaoService.getCustoExterno(trdFinNegPrecificacaoVO);
             
            qtdeMesesLibor = getTrdFinNegPrecificacaoVO().getPrzomediodsembm();
        } else {
            trdFinNegPrecificacaoVO.setDtcotac(SiteUtil.dateToString(new Date(),"dd.MM.yyyy"));
            trdFinNegPrecificacaoVO.setDataCotacaoFormat(SiteUtil.dateToString(new Date(),"dd/MM/yyyy"));
            trdFinNegPrecificacaoVO.setIsglindcdfonte(SiteUtil.STRING_EMPTY);
            trdFinNegPrecificacaoVO.setCustoExternoFormat("0,00000");
            trdFinNegPrecificacaoVO.setDlimfndngcmbio(SiteUtil.dateToString(getViewHelper().getDataLimiteCotacao(), "dd/MM/yyyy"));
            
            qtdeMesesLibor = Numeros.ZERO;
            getTrdFinNegPrecificacaoVO().setSpreadclean("0,00000");
        }
        
        getTrdFinNegPrecificacaoVO().setLibor(getTrdFinNegPrecificacaoVO().getIsglindcdfonte() + " "
                + qtdeMesesLibor + " Meses" + " + "
                + SiteUtil.trocarPontoPorVirgula(getTrdFinNegPrecificacaoVO().getSpreadclean()) + " % AA");
        
        getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.calcularCustoExternoForfaiting <<<<<<<<<<<");
        
    }
    
    /**
     * Nome: calcularMesesLibor
     * 
     * Propósito: A quantidade de meses da libor é calculada com base na periodicidade do Juros do fluxo de pagamento.
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    private void calcularMesesLibor() {
        Integer qtdeMesesLibor = Numeros.ZERO;
        
        // recupera a periodicidade do juros selecionada para o primeiro fluxo de pagamento
        if (getTradeFinNegocVO().getListaFluxos().size() > Numeros.ZERO) {
            TrdFinNegFluxoPagtoVO item = getTradeFinNegocVO().getListaFluxos().get(0);
            
            if(item.getCfluxoliqdcprinc().equals(EnumTradeFinance.PERIODICIDADE_FINAL.getCodigo())
                    && item.getCodJurosPeriodicidade().equals(EnumTradeFinance.PERIODICIDADE_FINAL.getCodigo())
                    && getTradeFinNegocVO().getTdiaopercmbio() <= 365) {
                 
                qtdeMesesLibor = getTrdFinNegPrecificacaoVO().getPrzomediodsembm();
            } else {
				//Como era antes da alteração solicitada
                //qtdeMesesLibor = getViewHelper().getDiasPeriodicidade(item.getCodJurosPeriodicidade());
                //Alteração 04/01/2019. Os valores serão zerados.
            	qtdeMesesLibor = Numeros.ZERO;
            	getTrdFinNegPrecificacaoVO().setSpreadclean("0,00000");
            }
        } else {
        	// [2016-09-23 | Nicholas M. Dantas] Caso não haja nenhuma ocorrência na lista de fluxo de pagamentos
        	// os valores serão zerados.
        	qtdeMesesLibor = Numeros.ZERO;
        	getTrdFinNegPrecificacaoVO().setSpreadclean("0,00000");
        }
        
        getTrdFinNegPrecificacaoVO().setPrzomediodsembm(qtdeMesesLibor);
        
        getTrdFinNegPrecificacaoVO().setLibor(getTrdFinNegPrecificacaoVO().getIsglindcdfonte() + " "
                + qtdeMesesLibor + " Meses" + " + "
                + SiteUtil.trocarPontoPorVirgula(getTrdFinNegPrecificacaoVO().getSpreadclean()) + " % AA");
    }
    
    /**
     * Nome: listenerShowFluxoPgtSel
     * 
     * Propósito: Metodo executado no radio da lista de fluxo de pagamento
     *            Abre o modal de detalhes do fluxo de pagamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerShowFluxoPgtSel(AjaxBehaviorEvent e) {
        
        int itemSelecListaFluxos = -1;

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerShowFluxoPgtSel <<<<<<<<<<<");
    		
    		Date dataRecupera = new Date();
    		
            // valida se foi selecionado um item na lista
            if (SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaFluxos()) && !getViewHelper().getFuncaoBotaoFluxo().equals("Alterar")) {
                NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            } else {
                itemSelecListaFluxos = SiteUtil.getInt(getViewHelper().getItemSelecListaFluxos()); 
                if (itemSelecListaFluxos > EnumTradeFinance.MAX_LISTA_FLUXO_PRINC_JUROS.getCodigo()) {
                    NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                    return;
                }
            }
    		
    		getViewHelper().setFuncaoBotaoFluxo("Selecao");
    		
    		itemListaFluxoPgto.setDprevtdsembcmbio(SiteUtil.dateToString(getViewHelper().getDatePrevDesembolso(), "dd/MM/yyyy"));
    		itemListaFluxoPgto = getTradeFinNegocVO().getListaFluxos().get(itemSelecListaFluxos).copy();
    		itemListaFluxoPgto.setDateFluxoPgto(null);
    		itemListaFluxoPgto.setPrincQtdParcelas(getItemListaFluxoPgto().getQtdeocorrprinc());
    		itemListaFluxoPgto.setJurosQtdParcelas(getItemListaFluxoPgto().getQtdeocorrjuros());
    		
    		try {
    			dataRecupera = SiteUtil.stringToDate(itemListaFluxoPgto.getDprevtdsembcmbio(), "dd/MM/yyyy");
    		} catch (ParseException e1) {
    			return;
    		}
    		
    		getViewHelper().setDateFluxoPgtoTemp(dataRecupera);
    		
    		if (getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo())) {
    		    getViewHelper().setDatePrevDesembolso(dataRecupera);    		    
    		}
    		
    		trocarPeriodicidadePrinc();
    		trocarPeriodicidadeJuros();
    		
    		viewHelper.setCtrBotaoFluxo(Numeros.NUM1);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerShowFluxoPgtSel <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: listenerAlterarFluxo
     * 
     * Propósito: Metodo executado no botão "Alterar Fluxo"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerAlterarFluxo(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerAlterarFluxo <<<<<<<<<<<");
    		
    		String dataTemp = null;
    		
    		getViewHelper().setFuncaoBotaoFluxo("Alterar");
    		
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getFuncaoBotaoFluxo())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDatePrevDesembolso());
    		itemListaFluxoPgto.setDateFluxoPgto(getViewHelper().getDateFluxoPgtoTemp());
    		dataTemp = SiteUtil.dataWebToMainframe(itemListaFluxoPgto.getDateFluxoPgto());
    		itemListaFluxoPgto.setDprevtdsembcmbio(SiteUtil.stringDataMainframeToWeb(dataTemp));
    		itemListaFluxoPgto.setCpais(getTradeFinNegocVO().getCpais());
            
            if (itemListaFluxoPgto.isTodasPeriodicidadeIrregular() == true) {
                
                if (getViewHelper().getDateFluxoPgtoTemp() == null) {
                    NpcFacesUtils.addInfoModalMessage("Data desembolso inválida.", false);
                    return;
                }
                
                if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getVprevtdsembcmbio()) == true) {
                    NpcFacesUtils.addInfoModalMessage("Valor desembolso inválido.", false);
                    return;
                }
                
                if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getPrincQtdParcelas()) == true ||
                                itemListaFluxoPgto.getPrincQtdParcelas() <= Numeros.NUM0) {
                    NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Principal inválida.", false);
                    return;
                }
                
                if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getJurosQtdParcelas()) == true ||
                                itemListaFluxoPgto.getJurosQtdParcelas() <= Numeros.NUM0) {
                    NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Juros inválida.", false);
                    return;
                }
                
                itemListaFluxoPgto.setTdiafinandsemb(tradeFinNegocVO.getTdiaopercmbio());
                
                itemListaFluxoPgto.setQtdeocorrprinc(itemListaFluxoPgto.getPrincQtdParcelas());
                itemListaFluxoPgto.setQtdeocorrjuros(itemListaFluxoPgto.getJurosQtdParcelas());
                
                getViewHelper().setDateFluxoPgtoTemp(null);
                
				if (!getTradeFinNegocVO().getListaFluxos().get(SiteUtil.getInt(getViewHelper()
								.getItemSelecListaFluxos())).copy().getCfluxoliqdcprinc().equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR
								.getCodigo()) == true
						|| !getTradeFinNegocVO().getListaFluxos().get(SiteUtil.getInt(getViewHelper()
										.getItemSelecListaFluxos())).copy().getCodJurosPeriodicidade().equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR
										.getCodigo()) == true) {
					itemListaFluxoPgto.setListaParcelasFluxoPgto(new ArrayList<TrdFinNegParcelaVO>());
				}
                
                setarDescricaoDosCombosFlxPgto();
                
                openModalFluxoPgto();                
                return;
                
            }
            
            if (itemListaFluxoPgto.isPeriodicidadeIrregular() == true) {
                if (itemListaFluxoPgto.getCfluxoliqdcprinc().equals(EnumTradeFinance.
                                PERIODICIDADE_IRREGULAR.getCodigo()) == true) {
                    if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getPrincQtdParcelas()) == true ||
                                    itemListaFluxoPgto.getPrincQtdParcelas() <= Numeros.NUM0) {
                        NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Principal inválida.", false);
                        return;
                    }
                /*IN2068072                    
                } else {
                    if (SiteUtil.isEmptyOrNull(itemListaFluxoPgto.getJurosQtdParcelas()) == true ||
                                    itemListaFluxoPgto.getJurosQtdParcelas() <= Numeros.NUM0) {
                        NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Juros inválida.", false);
                        return;
                    } 
                */
                    setarDescricaoDosCombosFlxPgto();
                    
                    openModalFluxoPgto();                
                    return;
                }
                
                /////// Nova rotina Irregular
                ///////
                getViewHelper().setStateIdListaParcelasFluxoPgto("NPCCIAO6");
                
                itemListaFluxoPgto.setCpais(getTradeFinNegocVO().getCpais());
                
                if (!SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais())) {
                    itemListaFluxoPgto.setCpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais());
                }
                
                // Por: Cláudio Tadeu em 14/10/2019 - IN? - País Desembolso
                Integer ecindcdeconm = Numeros.ZERO;
				ecindcdeconm = getTradeFinNegocVO().getCeconmmoedadsemb();
                    
				/** Antes de chamar o Fluxo para calcular o fluxo de pagamento irá chamar o serviço
				* do Inec para devolver o código do  Páis Moeda e a descrição
				*/
				if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCpaisInec())) {
					if (ecindcdeconm.equals(Numeros.QUINZE)) {
						getTradeFinNegocVO().setCpaisInec(null);
					} else {
						getTradeFinNegocVO().setCpaisInec(tradeFinanceNegociacaoService.inecIndicadorEconomico(ecindcdeconm));
					}
				}
                 
   				itemListaFluxoPgto.setCpaismoedadsemb(getTradeFinNegocVO().getCpaisInec());
   	            // *****
                
                tradeFinanceNegociacaoService.getFluxoPagtoDePrincipalJuros(itemListaFluxoPgto, getTradeFinNegocVO().isPrazoOperacaoAjustado());
                
                ordenarListaParcelasFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto());
                
                getViewHelper().setDateFluxoPgtoTemp(null);
                
                setarDescricaoDosCombosFlxPgto();
                
                openModalFluxoPgto();
                
                return;
            }
            
            if(getViewHelper().getDateFluxoPgtoTemp() == null) {
                NpcFacesUtils.addInfoModalMessage("O campo Data é obrigatório.", false);
                return;
            } else if(SiteUtil.comparaDatas(getViewHelper().getDateFluxoPgtoTemp(), new Date()) < 0){
                
                NpcFacesUtils.addInfoModalMessage("A Data do desembolso não pode ser menor que a data atual.", false);
                return;
            } else if(!validarDataPrevisaoDesembolso()) {
                return;
            }
            
            getViewHelper().setStateIdListaParcelasFluxoPgto("NPCCIAO6");
              
            itemListaFluxoPgto.setCpais(getTradeFinNegocVO().getCpais());
              
            if (!SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais())) {
                itemListaFluxoPgto.setCpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais());
            }
			
            if (itemListaFluxoPgto.getTdiafinandsemb() == 0 || itemListaFluxoPgto.getTdiafinandsemb() == null) {
            	itemListaFluxoPgto.setTdiafinandsemb(tradeFinNegocVO.getTdiaopercmbio());
			}
            
            // Por: Cláudio Tadeu em 14/10/2019 - IN? - País Desembolso
            Integer ecindcdeconm = Numeros.ZERO;
			ecindcdeconm = getTradeFinNegocVO().getCeconmmoedadsemb();
                
			/** Antes de chamar o Fluxo para calcular o fluxo de pagamento irá chamar o serviço
			* do Inec para devolver o código do  Páis Moeda e a descrição
			*/
			if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCpaisInec())) {
				if (ecindcdeconm.equals(Numeros.QUINZE)) {
					getTradeFinNegocVO().setCpaisInec(null);
				} else {
					getTradeFinNegocVO().setCpaisInec(tradeFinanceNegociacaoService.inecIndicadorEconomico(ecindcdeconm));
				}
			}
             
			itemListaFluxoPgto.setCpaismoedadsemb(getTradeFinNegocVO().getCpaisInec());
	        // *****
            
            validaListenerTrocaPrazo = tradeFinanceNegociacaoService.getFluxoPagtoDePrincipalJuros(itemListaFluxoPgto, getTradeFinNegocVO().isPrazoOperacaoAjustado());
                  
            ordenarListaParcelasFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto());
                  
    		setarDescricaoDosCombosFlxPgto();
            
            getViewHelper().setDateFluxoPgtoTemp(null);
            
    		openModalFluxoPgto();

    	}finally{
        	if (validaListenerTrocaPrazo == false && itemListaFluxoPgto.getListaParcelasFluxoPgto() != null && !itemListaFluxoPgto.getListaParcelasFluxoPgto().isEmpty()) {
        		getTradeFinNegocVO().setListaFluxos(new ArrayList<TrdFinNegFluxoPagtoVO>());
        		itemListaFluxoPgto.setListaParcelasFluxoPgto(new ArrayList<TrdFinNegParcelaVO>());
        		fluxoPgtoManutModalBean.closeModal(null);
			}
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerAlterarFluxo <<<<<<<<<<<");
    	}
    	setValidaListenerTrocaValorMe(false);
    }

    /**
     * Nome: listenerExcluirFluxo
     * 
     * Propósito: Metodo executado no botão "Excluir Fluxo"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerExcluirFluxo(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirFluxo <<<<<<<<<<<");
    		
    		String dataTemp = null;
    		
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getFuncaoBotaoFluxo())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		
    		if (temMercadoriaAtrelada(itemListaFluxoPgto.getSeqFluxoPagto()) == Boolean.TRUE) {
    			NpcFacesUtils.addInfoModalMessage("Exclusão negada. Existe mercadoria associada.", false);
    			return;
    		}
    		
    		getViewHelper().setFuncaoBotaoFluxo("Excluir");
    		
    		itemListaFluxoPgto.setDateFluxoPgto(getViewHelper().getDateFluxoPgtoTemp());
    		dataTemp = SiteUtil.dataWebToMainframe(itemListaFluxoPgto.getDateFluxoPgto());
    		itemListaFluxoPgto.setDprevtdsembcmbio(SiteUtil.stringDataMainframeToWeb(dataTemp));
    		
    		ordenarListaParcelasFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto());
    		
    		getViewHelper().setDateFluxoPgtoTemp(null);
    		
    		setarDescricaoDosCombosFlxPgto();
    		
    		List<TrdFinNegParcelaVO> listaParcelasFluxoPgto = itemListaFluxoPgto.getListaParcelasFluxoPgto();
    		itemListaFluxoPgtoBackUp = new ArrayList<TrdFinNegParcelaVO>();
    		
    		for (int i = 0; i < listaParcelasFluxoPgto.size(); i++) {
    			TrdFinNegParcelaVO temp = listaParcelasFluxoPgto.get(i);
    			TrdFinNegParcelaVO aux = null;
				try {
					aux = (TrdFinNegParcelaVO) temp.clone();
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
    			itemListaFluxoPgtoBackUp.add(aux);
			}
    		
    		openModalFluxoPgto();

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirFluxo <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: temMercadoriaAtrelada
     * 
     * Propósito: Verifica se existe mercadoria atrelado ao item do fluxo
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected Boolean temMercadoriaAtrelada(Integer numeroItemFluxo) {

        for (Iterator<TrdFinNegMercadoriaVO> iterator = getTradeFinNegocVO().getListaMercadoria().iterator(); iterator
                .hasNext();) {
            TrdFinNegMercadoriaVO itemLista = (TrdFinNegMercadoriaVO) iterator.next();

            if (itemLista.getNdsembcmbiotrade().equals(numeroItemFluxo)) {
                return Boolean.TRUE;
            }

        }

        return Boolean.FALSE;
    }

    /**
     * Nome: listenerDetalharFluxo
     * 
     * Propósito: Metodo executado no botão "Detalhar"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerDetalharFluxo(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerDetalharFluxo <<<<<<<<<<<");
    		
    		String dataTemp = null;
    		
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getFuncaoBotaoFluxo())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		
    		getViewHelper().setFuncaoBotaoFluxo("Detalhar");
    		
    		
    		if (getViewHelper().getDateFluxoPgtoTemp() != null) {
    			itemListaFluxoPgto.setDateFluxoPgto(getViewHelper().getDateFluxoPgtoTemp());
			} else {
				itemListaFluxoPgto.setDateFluxoPgto(SiteUtil.dataMainframeToWeb(itemListaFluxoPgto.getDprevtdsembcmbio()));
			}
    		dataTemp = SiteUtil.dataWebToMainframe(itemListaFluxoPgto.getDateFluxoPgto());
    		itemListaFluxoPgto.setDprevtdsembcmbio(SiteUtil.stringDataMainframeToWeb(dataTemp));
    		
    		ordenarListaParcelasFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto());
    		
    		getViewHelper().setDateFluxoPgtoTemp(null);

    		setarDescricaoDosCombosFlxPgto();
    		
    		List<TrdFinNegParcelaVO> listaParcelasFluxoPgto = itemListaFluxoPgto.getListaParcelasFluxoPgto();
    		itemListaFluxoPgtoBackUp = new ArrayList<TrdFinNegParcelaVO>();
    		
    		for (int i = 0; i < listaParcelasFluxoPgto.size(); i++) {
    			TrdFinNegParcelaVO temp = listaParcelasFluxoPgto.get(i);
    			TrdFinNegParcelaVO aux = null;
				try {
					aux = (TrdFinNegParcelaVO) temp.clone();
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
    			itemListaFluxoPgtoBackUp.add(aux);
			}
    		openModalFluxoPgto();

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerDetalharFluxo <<<<<<<<<<<");
    	}
    	

    }
    
    public void listenerDetalharFluxoAlt() {
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerDetalharFluxo <<<<<<<<<<<");
    		String dataTemp = null;
    		
    		if (!getTradeFinNegocVO().getListaFluxos().isEmpty()) {
    			itemListaFluxoPgto = getTradeFinNegocVO().getListaFluxos().get(0);
			}
    		
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getFuncaoBotaoFluxo())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		getViewHelper().setFuncaoBotaoFluxo("Detalhar");
    		
    		getViewHelper().setDateFluxoPgtoTemp(SiteUtil.dataMainframeToWeb(itemListaFluxoPgto.getDprevtdsembcmbio()));
    		
    		itemListaFluxoPgto.setDateFluxoPgto(getViewHelper().getDateFluxoPgtoTemp());
    		dataTemp = SiteUtil.dataWebToMainframe(itemListaFluxoPgto.getDateFluxoPgto());
    		itemListaFluxoPgto.setDprevtdsembcmbio(SiteUtil.stringDataMainframeToWeb(dataTemp));
    		
    		ordenarListaParcelasFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto());
    		
    		getViewHelper().setDateFluxoPgtoTemp(null);

    		setarDescricaoDosCombosFlxPgto();
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerDetalharFluxo <<<<<<<<<<<");
    	}
	}
    
	public void carregarDetalhesComissaoIntAlt(String funcao) {
        TrdFinNegComissaoVO itemComissaoInt = null;
        // valida se foi selecionado um item na lista
        if (temFluxoPagamento() == true) {
        	
            if (getTradeFinNegocVO().getListaComissaoInterna().size() > 0) {
        	
	            itemComissaoInt = getTradeFinNegocVO().getListaComissaoInterna().get(getViewHelper().getItemSelecListaComissaoInterna());
	            
	            comissaoIntManutModalBean.getViewHelper().setFuncaoBotaoComissaoInterna(funcao);
	            comissaoIntManutModalBean.setItemListaComissaoInterna(new TrdFinNegComissaoVO());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setDateComissao(itemComissaoInt.getDateComissao());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setDataComissaoFormat(itemComissaoInt.getDataComissaoFormat());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setTdiafinandsemb(itemComissaoInt.getTdiafinandsemb());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setTdiaopercmbio(itemComissaoInt.getTdiaopercmbio());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setVprevtdsembcmbio(itemComissaoInt.getVprevtdsembcmbio());
	            
	            for (int j = 0; j < getViewHelper().getComboMoedaDesembolso().size(); j++) {
	                if (getViewHelper().getComboMoedaDesembolso().get(j).getValue().equals(getViewHelper().getCodMoedaComissao())) {
	                    comissaoIntManutModalBean.getViewHelper().setNomeMoedaComissaoInterna(getViewHelper().getComboMoedaDesembolso().get(j).getLabel());
	                    break;
	                }
	            }
	            
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setCindcdeconmmoeda(getViewHelper().getCodMoedaComissao());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setPeriodicidadeComissao(itemComissaoInt.getPeriodicidadeComissao());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setMomentoComissao(itemComissaoInt.getMomentoComissao());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setCfluxoperdccmbio(itemComissaoInt.getCfluxoperdccmbio());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setQpcelacmbiotrade(itemComissaoInt.getQpcelacmbiotrade());
	            comissaoIntManutModalBean.getItemListaComissaoInterna().setListaParcelasComissao(itemComissaoInt.getListaParcelasComissao());
            }
        } else {
        	return;
		}
    }
    
    /**
     * Nome: confirmaFluxoPagto
     * 
     * Propósito: Metodo executado no botão "Confirmar" do modal de Fluxo de pagamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void confirmaFluxoPagto() {

        int itemSelecListaFluxos = -1;
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.confirmaFluxoPagto <<<<<<<<<<<");
    		
    		TrdFinNegFluxoPagtoVO itemFluxoPgto = new TrdFinNegFluxoPagtoVO();
    		
    		if (getViewHelper().getFuncaoBotaoFluxo().equals("Incluir")) {
    			
    			// Adiciona os dados na lista.
    			getTradeFinNegocVO().getListaFluxos().add(itemListaFluxoPgto);
    			gerarSeqListaFluxoPgto();
    			
    			calcularPrazoCustoExterno();
    			
    			// Para o produto nce não tem comissão interna
                if(!getTradeFinNegocVO().getProduto().isNce()){
                    limparDadosComissaoInterna();
                }
    		}
    		
    		if (getViewHelper().getFuncaoBotaoFluxo().equals("Alterar")) {
    		    itemSelecListaFluxos = SiteUtil.getInt(getViewHelper().getItemSelecListaFluxos());
    		    
    			// Altera os dados na lista.
    		    if (getTradeFinNegocVO().getListaFluxos().size() != 0) {
    		    	getTradeFinNegocVO().getListaFluxos().set(itemSelecListaFluxos , itemListaFluxoPgto);
				} else if (itemListaFluxoPgto.getListaParcelasFluxoPgto().size() > 0) {
					// Adiciona os dados na lista.
	    			getTradeFinNegocVO().getListaFluxos().add(itemListaFluxoPgto);
	    			gerarSeqListaFluxoPgto();
	    			
	    			calcularPrazoCustoExterno();
				}
    			
    			// Para o produto nce não tem comissão interna
    			if(getTradeFinNegocVO().getProduto().isNce()){
                    limparDadosComissaoInterna();
    			}
                
                if (getTradeFinNegocVO().getListaFluxos().size() > Numeros.ZERO) {
                    tradeFinanceNegociacaoService.calcularPrazosMediosOperacaoDesembolso(itemListaFluxoPgto , getTradeFinNegocVO().getListaFluxos());

                    getTrdFinNegPrecificacaoVO().setCindcdeconmmoeda(tradeFinNegocVO.getCindcdeconmmoeda());
                    getTrdFinNegPrecificacaoVO().setPrzomediodsemb(itemListaFluxoPgto.getPrzomediooperd());
                    getTrdFinNegPrecificacaoVO().setCprodtservc(tradeFinNegocVO.getCprodtservc());
                    
                    getViewHelper().setDateFluxoPgtoTemp(null);

                    // Calcula custo externo se o produto não for NCE
                    if(!getTradeFinNegocVO().getProduto().isNce()) {
                        calcularCustoExterno();
                    }
                }
                
                if (getViewHelper().getValueComissaoCobranca() != null && getViewHelper().getValueComissaoCobranca() != "") {
                	listenerExcluirComissaoInterna(null);
                	listenerIncluirComissaoInterna(null);
				}
    		}
    		
    		if (getViewHelper().getFuncaoBotaoFluxo().equals("Excluir")) {
                itemSelecListaFluxos = SiteUtil.getInt(getViewHelper().getItemSelecListaFluxos());
    			
				itemFluxoPgto = getTradeFinNegocVO().getListaFluxos().get(itemSelecListaFluxos);
				getTradeFinNegocVO().getListaFluxos().remove(itemFluxoPgto);	   					
				
				// Se for excluido o primeiro fluxo de pagamento, deve limpar a lista de comissão adicional. 
				// A comissão adicional é baseada na data do primeiro desembolso
    			if(getTradeFinNegocVO().getListaComissaoExterna().size() > Numeros.ZERO && itemSelecListaFluxos == Numeros.ZERO){
					getTradeFinNegocVO().setListaComissaoExterna(new ComissaoCollection());
    			}
    				
    			gerarSeqListaFluxoPgto();
    			
    			tratarBotaoAltDetComissInterna();

    			// BRQ - Acerto Comissão Interna - Arredondamento                
    			limparDadosComissaoInterna();
                
                if (getTradeFinNegocVO().getListaFluxos().size() > Numeros.ZERO) {
                    
                    itemListaFluxoPgto = new TrdFinNegFluxoPagtoVO();

                    tradeFinanceNegociacaoService.calcularPrazosMediosOperacaoDesembolso(itemListaFluxoPgto,
                                    getTradeFinNegocVO().getListaFluxos());
                    
                    getTrdFinNegPrecificacaoVO().setCindcdeconmmoeda(tradeFinNegocVO.getCindcdeconmmoeda());
                    getTrdFinNegPrecificacaoVO().setPrzomediodsemb(itemListaFluxoPgto.getPrzomediooperd());
                    getTrdFinNegPrecificacaoVO().setCprodtservc(tradeFinNegocVO.getCprodtservc());
                    
                    // Calcula custo externo se o produto não for NCE
                    if(!getTradeFinNegocVO().getProduto().isNce()) {
                        calcularCustoExterno();
                    }
                } else {
                    calcularMesesLibor();
                }
            }
            
            if (getTradeFinNegocVO().getListaFluxos().size() <= Numeros.ZERO) {
                itemListaFluxoPgto.setPrzomediooperd(Numeros.NUM0);
                itemListaFluxoPgto.setPrzomedioopera("0");
            }
            
    		getViewHelper().setPrzomediooperd(SiteUtil.nullToInteger(itemListaFluxoPgto.getPrzomediooperd()));
    		getViewHelper().setPrzomedioopera(itemListaFluxoPgto.getPrzomedioopera());

    		if (!getViewHelper().getFuncaoBotaoFluxo().equals("Excluir") 
    		        || (getViewHelper().getFuncaoBotaoFluxo().equals("Excluir") && !getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo()))) {
    		    
    		    reIniciarFluxoPagto();
    		    
    		} else if (getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo())) {
    		    
    		    getViewHelper().setDateFluxoPgtoTemp(SiteUtil.dataMainframeToWeb(getTradeFinNegocVO().getDprevtprorrog()));
                getViewHelper().setDateProrrogacao(SiteUtil.dataMainframeToWeb(getTradeFinNegocVO().getDprevtprorrog()));
                getItemListaFluxoPgto().setPrincQtdParcelas(0);
                getItemListaFluxoPgto().setJurosQtdParcelas(0);
    		}
    		
    		Collections.sort(getTradeFinNegocVO().getListaFluxos(), new TrdFinNegFluxoPagtoVO().getDateComparator());
    		gerarSeqListaFluxoPgto();

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.confirmaFluxoPagto <<<<<<<<<<<");
    	}

    }
    
    /**
     * Nome: getPrazoOperacaoFluxoPagamento
     * 
     * Propósito: Retorna o maior prazo da lista de fluxo de pagamento, 
     * quando não tem fluxo de pagamento retornar o prazo da operação em dias
     *
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 03/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    protected void atualizaPrazoOperacaoFluxoPagamento() {
        Integer prazoOperacao = 0;
        getViewHelper().setAlertMessageConfirmation(null);
        
        for (TrdFinNegFluxoPagtoVO fluxoPagamento : getTradeFinNegocVO().getListaFluxos()) {
            if(fluxoPagamento.getTdiafinandsemb() > prazoOperacao) {
                prazoOperacao = fluxoPagamento.getTdiafinandsemb();
            }
        } 
        
        // Se o maior prazo entre os fluxos de pagamentos for menor que o prazo da operação, o sistema ajusta o prazo da operação.
        if(!SiteUtil.isEmptyOrNull(prazoOperacao) 
                && prazoOperacao < getTradeFinNegocVO().getTdiaopercmbio()) {
            
            getTradeFinNegocVO().setPrazoOperacaoAjustado(true);
            getTradeFinNegocVO().setTdiaopercmbio(prazoOperacao);
            getViewHelper().setAlertMessageConfirmation("Prazo da operação ajustado para " + prazoOperacao + " pelo fluxo de pagamento.");
        }
    }

	/**
	* Nome: reIniciarFluxoPagto
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 03/06/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    protected void reIniciarFluxoPagto() {

        itemListaFluxoPgto = new TrdFinNegFluxoPagtoVO();
        itemListaFluxoPgto.setCfluxoliqdcprinc(EnumTradeFinance.PERIODICIDADE_SEMESTRAL.getCodigo());
        itemListaFluxoPgto.setCodJurosPeriodicidade(EnumTradeFinance.PERIODICIDADE_SEMESTRAL.getCodigo());
        itemListaFluxoPgto.setCodJurosMomento(EnumTradeFinance.PERIODICIDADE_SEMESTRAL.getCodigo());
        getViewHelper().setDateFluxoPgtoTemp(null);

        viewHelper.setDisabledTxtParcelaFlxPgtPrinc(Boolean.TRUE);
        viewHelper.setDisabledTxtCarenciaPrinc(Boolean.FALSE);

        viewHelper.setDisabledTxtParcelaFlxPgtJuros(Boolean.TRUE);
        viewHelper.setDisabledTxtCarenciaJuros(Boolean.FALSE);
        viewHelper.setDisabledComboMomentoJuros(Boolean.FALSE);

        getViewHelper().setFuncaoBotaoFluxo("");

        // Limpa a seleção dos itens da lista.
        getViewHelper().setItemSelecListaFluxos(null);
    }
    
    /**
     * Nome: gerarSeqListaFluxoPgto
     * 
     * Propósito: Gera sequencia do fluxo de pagamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void gerarSeqListaFluxoPgto() {

        for (int i = 0; i < getTradeFinNegocVO().getListaFluxos().size(); i++) {
            getTradeFinNegocVO().getListaFluxos().get(i).setSeqFluxoPagto(i + 1);
        }
    }

    	/**
    	* Nome: listenerTrocaPeriodicidadePrinc
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 21/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaPeriodicidadePrinc(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaPeriodicidadePrinc <<<<<<<<<<<");
            
            itemListaFluxoPgto.setPrincQtdParcelas(0);
            trocarPeriodicidadePrinc();
            tratarPeriodo();
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaPeriodicidadePrinc <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
    	* Nome: carregarGridComissaoInt
    	* 
    	* Propósito: Carregar o Grid gerado quando é incluído um FLuxo de Pagamento 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void calcularPrazoCustoExterno(){
        
        if (getTradeFinNegocVO().getListaFluxos().size() > Numeros.ZERO) {
            
            tradeFinanceNegociacaoService.calcularPrazosMediosOperacaoDesembolso(itemListaFluxoPgto ,
                            getTradeFinNegocVO().getListaFluxos());
            
            getTrdFinNegPrecificacaoVO().setCindcdeconmmoeda(tradeFinNegocVO.getCindcdeconmmoeda());
            getTrdFinNegPrecificacaoVO().setPrzomediodsemb(itemListaFluxoPgto.getPrzomediooperd());
            getTrdFinNegPrecificacaoVO().setCprodtservc(tradeFinNegocVO.getCprodtservc());
            
            getViewHelper().setDateFluxoPgtoTemp(null);
            
            // Calcula custo externo se o produto não for NCE
            if(!getTradeFinNegocVO().getProduto().isNce()) {
                calcularCustoExterno();
            }
        }
    }
   
    /**
     * 
    	* Nome: trocarPeriodicidadePrinc
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void trocarPeriodicidadePrinc() {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.trocarPeriodicidadePrinc <<<<<<<<<<<");
            
            if (itemListaFluxoPgto.getCfluxoliqdcprinc() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
                viewHelper.setDisabledTxtParcelaFlxPgtPrinc(Boolean.FALSE);
                viewHelper.setDisabledTxtCarenciaPrinc(Boolean.TRUE);
                itemListaFluxoPgto.setTdiacarenprinc(0);
            } else if (itemListaFluxoPgto.getCfluxoliqdcprinc() ==
                            EnumTradeFinance.PERIODICIDADE_FINAL.getCodigo()) {
                viewHelper.setDisabledTxtParcelaFlxPgtPrinc(Boolean.TRUE);
                itemListaFluxoPgto.setTdiacarenprinc(0);
                viewHelper.setDisabledTxtCarenciaPrinc(Boolean.TRUE);
            } else {
                viewHelper.setDisabledTxtParcelaFlxPgtPrinc(Boolean.TRUE);
                viewHelper.setDisabledTxtCarenciaPrinc(Boolean.FALSE);
            }
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.trocarPeriodicidadePrinc <<<<<<<<<<<");
        }
        
    }

    public void listenerTrocaPeriodicidadeJuros(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaPeriodicidadeJuros <<<<<<<<<<<");
            
            itemListaFluxoPgto.setJurosQtdParcelas(0);
            trocarPeriodicidadeJuros();
            tratarPeriodo();
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaPeriodicidadeJuros <<<<<<<<<<<");
        }
        
    }

    private void trocarPeriodicidadeJuros() {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.trocarPeriodicidadeJuros <<<<<<<<<<<");
            
            if (itemListaFluxoPgto.getCodJurosPeriodicidade() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
                viewHelper.setDisabledTxtParcelaFlxPgtJuros(Boolean.FALSE);
                viewHelper.setDisabledTxtCarenciaJuros(Boolean.TRUE);
                viewHelper.setDisabledComboMomentoJuros(Boolean.TRUE);
                itemListaFluxoPgto.setJurosCarencia(0);

            } else if (itemListaFluxoPgto.getCfluxoliqdcprinc() ==
                            EnumTradeFinance.PERIODICIDADE_FINAL.getCodigo()) {
                viewHelper.setDisabledTxtParcelaFlxPgtJuros(Boolean.TRUE);
                itemListaFluxoPgto.setJurosCarencia(0);
                viewHelper.setDisabledTxtCarenciaJuros(Boolean.TRUE);
                viewHelper.setDisabledComboMomentoJuros(Boolean.FALSE);
            } else {
                viewHelper.setDisabledTxtParcelaFlxPgtJuros(Boolean.TRUE);
                viewHelper.setDisabledTxtCarenciaJuros(Boolean.FALSE);
                viewHelper.setDisabledComboMomentoJuros(Boolean.FALSE);
            }

        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.trocarPeriodicidadeJuros <<<<<<<<<<<");
        }
        
    }
    
    protected void setarDescricaoDosCombosFlxPgto() {
        String nomeCombo = null;

        for (int j = 0; j < viewHelper.getComboPeriodicidade().size(); j++) {
            if (viewHelper.getComboPeriodicidade().get(j).getValue().equals(itemListaFluxoPgto.getCfluxoliqdcprinc())) {
                nomeCombo = viewHelper.getComboPeriodicidade().get(j).getLabel();
                break;
            }
        }
        itemListaFluxoPgto.setNomePrincPeriodicidade(nomeCombo);

        for (int j = 0; j < viewHelper.getComboPeriodicidade().size(); j++) {
            if (viewHelper.getComboPeriodicidade().get(j).getValue().equals(itemListaFluxoPgto.getCodJurosPeriodicidade())) {
                nomeCombo = viewHelper.getComboPeriodicidade().get(j).getLabel();
                break;
            }
        }

        itemListaFluxoPgto.setNomeJurosPeriodicidade(nomeCombo);
        
        for (int j = 0; j < viewHelper.getComboMomento().size(); j++) {
            if (viewHelper.getComboMomento().get(j).getValue().equals(itemListaFluxoPgto.getCodJurosMomento())) {
                nomeCombo = viewHelper.getComboMomento().get(j).getLabel();
                break;
            }
        }
        itemListaFluxoPgto.setNomeJurosMomento(nomeCombo);
        
    }

    /**
     * Nome: closeModalFlxPgt
     * 
     * Propósito: Fecha modal de Fluxo de pagamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalFlxPgt(ActionEvent event) {
        
        Boolean confirmarManutencao = Boolean.FALSE;
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalFlxPgt <<<<<<<<<<<");
    		
    		confirmarManutencao = fluxoPgtoManutModalBean.getConfirmarManutencao();
    		
    		// desabilita modal
    		fluxoPgtoManutModalBean.closeModal(event);
    		
    		viewHelper.setCtrBotaoFluxo(Numeros.NUM0);
            
            if(confirmarManutencao == Boolean.TRUE) {
                confirmaFluxoPagto();
            }

            getViewHelper().setDateFluxoPgtoTemp(itemListaFluxoPgto.getDateFluxoPgto());
            getViewHelper().setItemSelecListaFluxos(null);
            
            // Defeito TH - ID 851
            if (getTradeFinNegocVO().getListaComissaoInterna() != null && (getTradeFinNegocVO().getListaComissaoInterna().size() <= Numeros.ZERO
                    && !getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo()))) {
                
                // Carrega a data informada de desembolso no campo fluxo de pagamento
                getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDatePrevDesembolso());              
        
                //Carrega Valor ME para Valor Desembolso
                itemListaFluxoPgto.setVprevtdsembcmbio(tradeFinNegocVO.getVnegocmoedaestrg());   
            }

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalFlxPgt <<<<<<<<<<<");
    	}

    }
    
    /**
     * Nome: openModalFluxoPgto
     * 
     * Propósito: Carrega variaveis para abrir modal de confirmação de fluxo de pagamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void openModalFluxoPgto() {
        
        if (itemListaFluxoPgto.isPeriodicidadeIrregular() == true) {
            if (getViewHelper().getFuncaoBotaoFluxo().equals("Incluir")||
                            getViewHelper().getFuncaoBotaoFluxo().equals("Alterar")) {
                
                fluxoPgtoManutModalBean.getViewHelper().setDisabledDadosIrregular(Boolean.FALSE);
                
                // seta o codigo do pais da unidade externa para calculo da data de vencimento
                itemListaFluxoPgto.setCpais(getTradeFinNegocVO().getCpais());
                
                if (itemListaFluxoPgto.isTodasPeriodicidadeIrregular() == false) {
                    fluxoPgtoManutModalBean.getViewHelper().setDisabledComboTipoParcela(Boolean.TRUE);
                    if (itemListaFluxoPgto.getCfluxoliqdcprinc().equals(EnumTradeFinance.
                                    PERIODICIDADE_IRREGULAR.getCodigo()) == true) {
                        fluxoPgtoManutModalBean.getItemListaParcelaIrreg().setTpparcela("P");
                        itemListaFluxoPgto.setQtdeocorrprinc(itemListaFluxoPgto.getPrincQtdParcelas());
                    } else {
                        fluxoPgtoManutModalBean.getItemListaParcelaIrreg().setTpparcela("J");
                        itemListaFluxoPgto.setQtdeocorrjuros(itemListaFluxoPgto.getJurosQtdParcelas());
                    }
                } else {
                	
                	if(itemListaFluxoPgto.getCfluxoliqdcprinc().equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo())){
                		
                		fluxoPgtoManutModalBean.getItemListaParcelaIrreg().setTdianegocpcela(0);
                		fluxoPgtoManutModalBean.getItemListaParcelaIrreg().setDateVctopcelatrade(null);
                		fluxoPgtoManutModalBean.getItemListaParcelaIrreg().setValorParcelaFluxoPgto("");
                	}
                	
                    fluxoPgtoManutModalBean.getViewHelper().setDisabledComboTipoParcela(Boolean.FALSE);
                    fluxoPgtoManutModalBean.getItemListaParcelaIrreg().setTpparcela("P");
                    itemListaFluxoPgto.setQtdeocorrprinc(itemListaFluxoPgto.getPrincQtdParcelas());
                    itemListaFluxoPgto.setQtdeocorrjuros(itemListaFluxoPgto.getJurosQtdParcelas());
                }
            }
            
            if (getViewHelper().getFuncaoBotaoFluxo().equals("Excluir") ||
                            getViewHelper().getFuncaoBotaoFluxo().equals("Detalhar")) {
                fluxoPgtoManutModalBean.getViewHelper().setDisabledDadosIrregular(Boolean.TRUE);
            } else {
                fluxoPgtoManutModalBean.getViewHelper().setDisabledValorQuandoIrregularTipoJuros(Boolean.FALSE);
            }
        } else {
            fluxoPgtoManutModalBean.getViewHelper().setDisabledDadosIrregular(Boolean.TRUE);
        }
        fluxoPgtoManutModalBean.setItemListaFluxoPgto(itemListaFluxoPgto);
		if (getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0) {
			formatarParcelasFluxoPagamentoWeb();
		}
		fluxoPgtoManutModalBean.getViewHelper().setNomeMoedaDesembolso(getViewHelper().getNomeMoedaDesembolso());
        fluxoPgtoManutModalBean.setConfirmarManutencao(Boolean.FALSE);
        fluxoPgtoManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalFluxoPgto");
        fluxoPgtoManutModalBean.openModal();
    }
    
    public void formatarParcelasFluxoPagamentoWeb() {
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.getFluxoPagtoDePrincipalJuros | FLXPGTPRINCJUROSCALC ------- ");
            
            List<TrdFinNegParcelaVO> lista = new ArrayList<TrdFinNegParcelaVO>();
            List<TrdFinNegParcelaVO> listaPrincJuros = new ArrayList<TrdFinNegParcelaVO>();
            
            for (int i = 0; i < getTradeFinNegocVO().getListaFluxos().size(); i++) {
            	TrdFinNegFluxoPagtoVO tradeFinNegoc = getTradeFinNegocVO().getListaFluxos().get(i);
            	List<TrdFinNegParcelaVO> fluxoPagamento = tradeFinNegoc.getListaParcelasFluxoPgto();
            	
	            boolean formatar = false;
            	for (int j = 0; j < fluxoPagamento.size(); j++) {
	            	if (fluxoPagamento.size() == (tradeFinNegoc.getQtdeocorrprinc() + tradeFinNegoc.getQtdeocorrjuros()) && itemListaFluxoPgto.getCodJurosPeriodicidade() != 14) {
	            		formatar = true;
	            	}
				}
	            TrdFinNegParcelaVO objTo = null;
	            if (formatar == true) {
	            	if (tradeFinNegoc.getCfluxoliqdcprinc().equals(tradeFinNegoc.getCodJurosPeriodicidade())) {
	                	String vPrinc = tradeFinNegoc.getVprevtdsembcmbio().replaceAll("\\.","").replace(",",".");
	                	for (int k = 0; k < fluxoPagamento.size(); k++) {
	                		TrdFinNegParcelaVO objFrom = fluxoPagamento.get(k);
	                		objTo = new TrdFinNegParcelaVO();

	                		// Copia os valores das propriedades
	                		if (objFrom.getTpparcela().equals("P")) {
	                			objTo.setTpparcela(objFrom.getTpparcela());
	                			objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
	                			objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
	                			objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
	                			objTo.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	                			objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	                			objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
	                			objTo.setVpcelamesatrade(objFrom.getVpcelamesatrade());
	                			objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));
	                			objTo.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getVpcelamesatrade()));

	                			vPrinc = vPrinc.replace(",", ".");
	                			String vParce = objFrom.getVpcelamesatrade().replaceAll("\\.","").replace(",",".");
	                			vParce = vParce.replace(",", ".");

	                			BigDecimal saldoDevedor = new BigDecimal(vPrinc).subtract(new BigDecimal(vParce));

	                			objTo.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
	                			vPrinc = saldoDevedor.toString();
	                			lista.add(objTo);
	                		} else if (objFrom.getTpparcela().equals("J")) {
	                			objTo.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getVpcelamesatrade()));
	                			listaPrincJuros.add(objTo);
	                		}
	                	}
	                	for (int k = 0; k < lista.size(); k++) {
	                		listaPrincJuros.get(k).setTpparcela(lista.get(k).getTpparcela());
	                		listaPrincJuros.get(k).setNpceladsembtrade(lista.get(k).getNpceladsembtrade());
	                		listaPrincJuros.get(k).setTdianegocpcela(lista.get(k).getTdianegocpcela());
	                		listaPrincJuros.get(k).setDvctopcelatrade(lista.get(k).getDvctopcelatrade());
	                		listaPrincJuros.get(k).setVenctoFluxDate(lista.get(k).getVenctoFluxDate());
	                		listaPrincJuros.get(k).setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(lista.get(k).getVencimentoFluxoPgto()));
	                		listaPrincJuros.get(k).setVpcelamesatrade(lista.get(k).getVpcelamesatrade());
	                		listaPrincJuros.get(k).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(k).getValorParcelaFluxoPgto()));

	                		listaPrincJuros.get(k).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(k).getValorPrincipalParcelaFluxoPgto()));
	                		listaPrincJuros.get(k).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(k).getValorSaldoDevedorFluxoPgto()));
	                	}
	            	} else {
	            		String vPrinc = tradeFinNegoc.getVprevtdsembcmbio().replaceAll("\\.","").replace(",",".");
	                	//String vPrinc = fluxoPagamento.getVprevtdsembcmbio().replace(".", "");
	            		
	                	for (int j = 0; j < fluxoPagamento.size(); j++) {

	                		TrdFinNegParcelaVO objFrom = fluxoPagamento.get(j);
	                		objTo = new TrdFinNegParcelaVO();

	                		// Copia os valores das propriedades
	                		if (objFrom.getTpparcela().equals("P")) {
	                			objTo.setTpparcela(objFrom.getTpparcela());
	                			objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
	                			objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
	                			objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
	                			objTo.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	                			objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	                			objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
	                			
	                			objTo.setVpcelamesatrade(objFrom.getVpcelamesatrade());
	                			objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));
	                			objTo.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getVpcelamesatrade()));

	                			vPrinc = vPrinc.replace(",", ".");
	                			String vParce = objFrom.getVpcelamesatrade().replaceAll("\\.","").replace(",",".");
	                			vParce = vParce.replace(",", ".");

	                			BigDecimal saldoDevedor = new BigDecimal(vPrinc).subtract(new BigDecimal(vParce));

	                			objTo.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
	                			vPrinc = saldoDevedor.toString();
	                			lista.add(objTo);
	                		} else if (objFrom.getTpparcela().equals("J")) {
	                			objTo.setTpparcela(objFrom.getTpparcela());
	                			objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
	                			objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
	                			objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
	                			objTo.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	                			objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	                			objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));

	                			objTo.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getVpcelamesatrade()));
	                			listaPrincJuros.add(objTo);
	                		}
	                	}
	                	if (listaPrincJuros.size() % lista.size() != 0) {
	                		for (int t = 0; t < lista.size(); t++) {
	                			String dataTemp = lista.get(t).getVencimentoFluxoPgto();
	                			for (int j = 0; j < listaPrincJuros.size(); j++) {
	                				String dataAux = listaPrincJuros.get(j).getVencimentoFluxoPgto();
	                				try {
										if (SiteUtil.stringToDate(dataTemp, "dd/MM/yyyy").equals(SiteUtil.stringToDate(dataAux, "dd/MM/yyyy"))) {
											listaPrincJuros.get(j).setTpparcela(lista.get(t).getTpparcela());
											listaPrincJuros.get(j).setNpceladsembtrade(lista.get(t).getNpceladsembtrade());
											listaPrincJuros.get(j).setVpcelamesatrade(lista.get(t).getVpcelamesatrade());
											listaPrincJuros.get(j).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(t).getValorParcelaFluxoPgto()));

											listaPrincJuros.get(j).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(t).getValorPrincipalParcelaFluxoPgto()));
											listaPrincJuros.get(j).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(t).getValorSaldoDevedorFluxoPgto()));
											break;
										} else if (j == listaPrincJuros.size() -1) {
											listaPrincJuros.add(lista.get(t));
										}
									} catch (ParseException e) {
										e.printStackTrace();
									}
	                			}
	                		}

	                		final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	                		Comparator<TrdFinNegParcelaVO> cmp = new Comparator<TrdFinNegParcelaVO>() {
	                			public int compare(TrdFinNegParcelaVO o1, TrdFinNegParcelaVO o2) {
	                				Date dataInicial = null;
	                				Date dataFinal = null;
	                				try {
	                					dataInicial = sdf1.parse(o1.getVencimentoFluxoPgto());
	                					dataFinal = sdf1.parse(o2.getVencimentoFluxoPgto());
	                				} catch (ParseException e) {
	                					e.printStackTrace();
	                				}
	                				return dataInicial.compareTo(dataFinal); 
	                			}
	                		};
	                		Collections.sort(listaPrincJuros, cmp);
	                		int prazoTemp = 0;
	                		for (int l = 1; l < listaPrincJuros.size(); l++) {
	                			prazoTemp = calcularDiferencaEntreDatas(listaPrincJuros.get(l-1).getVencimentoFluxoPgto(), listaPrincJuros.get(l).getVencimentoFluxoPgto());
	                			listaPrincJuros.get(l).setTdianegocpcela(prazoTemp);
	    					}
	                	} else {
	                		for (int z = 0; z < lista.size(); z++) {
	                			String dataTemp = lista.get(z).getVencimentoFluxoPgto();
	                			for (int j = 0; j < listaPrincJuros.size(); j++) {
	                				String dataAux = listaPrincJuros.get(j).getVencimentoFluxoPgto();
	                				try {
										if (SiteUtil.stringToDate(dataTemp, "dd/MM/yyyy").equals(SiteUtil.stringToDate(dataAux, "dd/MM/yyyy"))) {
											listaPrincJuros.get(j).setTpparcela(lista.get(z).getTpparcela());
											listaPrincJuros.get(j).setNpceladsembtrade(lista.get(z).getNpceladsembtrade());
											listaPrincJuros.get(j).setVpcelamesatrade(lista.get(z).getVpcelamesatrade());
											listaPrincJuros.get(j).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(z).getValorParcelaFluxoPgto()));

											listaPrincJuros.get(j).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(z).getValorPrincipalParcelaFluxoPgto()));
											listaPrincJuros.get(j).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(z).getValorSaldoDevedorFluxoPgto()));
											break;
										} else if (j == listaPrincJuros.size() -1) {
											listaPrincJuros.add(lista.get(z));
										}
									} catch (ParseException e) {
										e.printStackTrace();
									}
	                			}
	                		}
	    				}
	                	
	                	
	                	String vPrincAux = tradeFinNegoc.getVprevtdsembcmbio().replaceAll("\\.","").replace(",",".");
	                	for (int t = 0; t < listaPrincJuros.size(); t++) {
	                		if (listaPrincJuros.get(t).getTpparcela().equals("J")) {
	                			listaPrincJuros.get(t).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrincAux));

	                			vPrincAux = vPrincAux.replace(",",".");
	                			String vParce = "0.00";
	                			if (listaPrincJuros.get(t).getValorPrincipalParcelaFluxoPgto() != null) {
	                				vParce = listaPrincJuros.get(t).getValorPrincipalParcelaFluxoPgto().replace(",",".");
	                			}
	                			vParce = vParce.replace(",",".");
	                			BigDecimal saldoDevedor = new BigDecimal(vPrincAux).subtract(new BigDecimal(vParce));

	                			listaPrincJuros.get(t).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
	                			vPrincAux = saldoDevedor.toString();
	                		} else {
	                			vPrincAux = listaPrincJuros.get(t).getValorSaldoDevedorFluxoPgto().replace(".", "");
	                		}
	                	}
					}
	                
	            	getTradeFinNegocVO().getListaFluxos().get(i).setListaParcelasFluxoPgto(null);
	            	getTradeFinNegocVO().getListaFluxos().get(i).setListaParcelasFluxoPgto(listaPrincJuros);
	            	itemListaFluxoPgto.setListaParcelasFluxoPgto(listaPrincJuros);
	            	fluxoPgtoManutModalBean.setItemListaFluxoPgto(itemListaFluxoPgto);
				}
            }
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.getFluxoPagtoDePrincipalJuros | FLXPGTPRINCJUROSCALC ------- ");
        }
    }
    
    public int calcularDiferencaEntreDatas(String dataAtual, String dataSeguinte) {
    	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataMaior = null;
		Date dataMenor = null;
		try {
			dataMaior = (Date)formatter.parse(dataSeguinte);
			dataMenor = (Date)formatter.parse(dataAtual);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(dataMenor);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(dataMaior);

		Long diferencaDiasLong = ((cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (24*60*60*1000));
   		
		int diferencaDias = Integer.valueOf((int) diferencaDiasLong.longValue());
		
   		System.out.println(diferencaDias);
   		
   		return diferencaDias;
	}
    
    /**
     * Nome: ordenarListaParcelasFluxoPgto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 15/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void ordenarListaParcelasFluxoPgto(List<TrdFinNegParcelaVO> listaParcelasFluxoPgto) {
        int numParcela = 1;

        Collections.sort(listaParcelasFluxoPgto);

        numParcela = 1;
        for (TrdFinNegParcelaVO item : listaParcelasFluxoPgto) {
            item.setNpceladsembtrade(numParcela++);
        }

    }
    
    /*************************
     * FIM - Fluxo pagamento *
     *************************/
    
    /*************** Tela Modal Manutenção Comissao Interna **************/

    /**
     * Nome: listenerIncluirComissaoInterna
     * 
     * Propósito: Incluir dados da Comissao Interna
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirComissaoInterna(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirComissaoInterna <<<<<<<<<<<");
    		
    		if(getViewHelper().getTipoCobrancaComissao().equals(Numeros.ZERO) 
    		        || getViewHelper().getValueComissaoCobranca().isEmpty() 
    		        || getViewHelper().getCodMoedaComissao().equals(Numeros.ZERO) 
    		        || getViewHelper().getCodComissaoSobre().equals(Numeros.ZERO)) {
        
                NpcFacesUtils.addInfoModalMessage("Informe os campos de Comissão Interna.", false);
                return;
            }
    		
    		if (temFluxoPagamento() && (getTradeFinNegocVO().getListaFluxos() == null || getTradeFinNegocVO().getListaFluxos().isEmpty())) {
    		    NpcFacesUtils.addInfoModalMessage("Fluxo de Pagamento não incluído.", false);
    		    return;
    		}
    		
    		if ((getTradeFinNegocVO().getListaComissaoInterna() != null && getTradeFinNegocVO().getListaComissaoInterna().size() > 0)
    				&& (getTradeFinNegocVO().getListaComissaoInterna().get(0).getListaParcelasComissao() != null && getTradeFinNegocVO().getListaComissaoInterna().get(0).getListaParcelasComissao().size() > 0)) {
    		    NpcFacesUtils.addInfoModalMessage("Comissão Interna já incluida.", false);
                return;
    		}
    		
    		TrdFinNegComissaoVO itemComissaoInterna = null;
    		for (Iterator<TrdFinNegFluxoPagtoVO> iterator = getTradeFinNegocVO().getListaFluxos().iterator(); iterator.hasNext();) {
    		    
    		    TrdFinNegFluxoPagtoVO itemListaFluxoPgto = (TrdFinNegFluxoPagtoVO) iterator.next();
    		    itemComissaoInterna = new TrdFinNegComissaoVO();
                
    		    itemComissaoInterna.setCcobrcomisintrn(getViewHelper().getTipoCobrancaComissao());
    		    itemComissaoInterna.setCcobrcomiscmbio(getViewHelper().getCodComissaoSobre());
    		    itemComissaoInterna.setVmincobrcomis(getViewHelper().getVmincobrcomis());
                itemComissaoInterna.setCindcdeconmmoeda(getViewHelper().getCodMoedaComissao());
                
                itemComissaoInterna.setCpais(getTradeFinNegocVO().getCpais());
                itemComissaoInterna.setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());
                itemComissaoInterna.setVlxoperaccmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
                
                itemComissaoInterna.setDateComissao(itemListaFluxoPgto.getDateFluxoPgto());
                itemComissaoInterna.setDataComissaoFormat(itemListaFluxoPgto.getDprevtdsembcmbio());
                itemComissaoInterna.setTdiafinandsemb(itemListaFluxoPgto.getTdiafinandsemb());
                itemComissaoInterna.setTdiaopercmbio(itemListaFluxoPgto.getTdiaopercmbio());                
                itemComissaoInterna.setCodMomentoComissao(itemListaFluxoPgto.getCodJurosMomento());
                itemComissaoInterna.setVprevtdsembcmbio(itemListaFluxoPgto.getVprevtdsembcmbio());
                itemComissaoInterna.setPeriodicidadeComissao(itemListaFluxoPgto.getNomeJurosPeriodicidade());
                itemComissaoInterna.setCfluxoperdccmbio(itemListaFluxoPgto.getCodJurosPeriodicidade());
                itemComissaoInterna.setMomentoComissao(itemListaFluxoPgto.getNomeJurosMomento());
                
                itemComissaoInterna.setPtxcustototal(getItemListaComissaoInterna().getPtxcustototal());
                itemComissaoInterna.setFuncao("I");
                
                /* TIPO DE COBRANCA DE COMISSAO = VALOR DE COMISSAO */
                if (getViewHelper().getTipoCobrancaComissao() == 1) {
                    
                    itemComissaoInterna.setVlxcomiscmbio(getViewHelper().getValueComissaoCobranca());
                    itemComissaoInterna.setPjuronegoccmbio("0,00000");
                    itemComissaoInterna.setPcomisnegoccmbio("0,00000");
                } 
                // Flat ou A.A.
                else if (getViewHelper().getTipoCobrancaComissao() == 2 
                        || getViewHelper().getTipoCobrancaComissao() == 3) {
                    
                    itemComissaoInterna.setPjuronegoccmbio(getViewHelper().getValueComissaoCobranca());
                    itemComissaoInterna.setPcomisnegoccmbio(getViewHelper().getValueComissaoCobranca());
                    itemComissaoInterna.setVlxcomiscmbio("0,00");   
                }
                
                comissaoInternaExternaModalService.getComissaoInterna(itemComissaoInterna, itemListaFluxoPgto);
                
                if (getTradeFinNegocVO().getListaComissaoInterna() == null) {
                	getTradeFinNegocVO().setListaComissaoInterna(new ArrayList<TrdFinNegComissaoVO>());
				}
                getTradeFinNegocVO().getListaComissaoInterna().add(itemComissaoInterna);
            }
    		
    		calcularValoresSpreadFlatCustoTotalComissaoInt();
    		
    		getViewHelper().setItemSelecListaComissaoInterna(Numeros.NUM999);
    		tratarBotaoAltDetComissInterna();
    		
    		validarMinimoCobrarComissaoInterna();
    		//Carregar o fluxo de pagamento quando for alteração.
    		carregarFluxoPagtoAlt();
    		
    		if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter());
	    		if (taxaFixaMaiorQueZero(custoTotal.toString())) {
	    			if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
					} else {
						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
					}
				}
            } else if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || getTradeFinNegocVO().getCcomiscartanacio().equals("2")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
            	BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter(), getItemListaComissaoInterna().getVtxspreadtot());
				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
					} else {
						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
					}
				}
            }
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirComissaoInterna <<<<<<<<<<<");
    	}
    }
    
    private BigDecimal calcularCustoTotal(String vtravaliborcmbio, String ptxcustototal, String vtxspreadtot) {
    	ptxcustototal = ptxcustototal.replace(".",",");
		BigDecimal liborTravada = new BigDecimal(vtravaliborcmbio.replaceAll("\\.","").replace(",","."));
		BigDecimal overlibor = new BigDecimal(ptxcustototal.replaceAll("\\.","").replace(",","."));
		BigDecimal spredTotal = new BigDecimal(vtxspreadtot.replaceAll("\\.","").replace(",","."));
		
		overlibor = liborTravada.add(overlibor);
		
		return overlibor.add(spredTotal);
	}
    
    public void carregarFluxoPagtoAlt() {
    	if (fluxoPgtoManutModalBean.isAlterarCotacao() == true) {
    		if (getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0) {
    			getViewHelper().setItemSelecListaFluxos("0");    		
    			listenerShowFluxoPgtSel(null);
    			listenerDetalharFluxoAlt();
    		}
    	}
	}
    
    private BigDecimal calcularCustoTotal(String vtravaliborcmbio, String ptxcustototal) {
    	ptxcustototal = ptxcustototal.replace(".",",");
		BigDecimal liborTravada = new BigDecimal(vtravaliborcmbio.replaceAll("\\.","").replace(",","."));
		BigDecimal overlibor = new BigDecimal(ptxcustototal.replaceAll("\\.","").replace(",","."));
		
		return liborTravada.add(overlibor);
	}
    
	public boolean taxaFixaMaiorQueZero(String valor){
		boolean retorno = false;
		if (valor == null || valor.equals("")) {
			valor = "0.00";
		}
		BigDecimal seuBigdecimal = new BigDecimal(valor.replace(",", "."));
		if (seuBigdecimal.signum() > 0) {
			retorno = true;
		} else {
			retorno = false;
		}
		return retorno;
	}
    
	/**
     * Nome: listenerTrocaValorMinimoCobrar
     * 
     * Propósito: Executado no change do Valor mínimo a cobrar
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTrocaValorMinimoCobrar(AjaxBehaviorEvent e) {
        validarMinimoCobrarComissaoInterna();
    }
    
    public void validarMinimoCobrarComissaoInterna() {
        
        if(!SiteUtil.isEmptyOrNull(getViewHelper().getVmincobrcomis()) 
                && !SiteUtil.isValueZero(getViewHelper().getVmincobrcomis())) {
            
            Double minimoCobrar = SiteUtil.getDouble(SiteUtil.formatarPontosVirgula(getViewHelper().getVmincobrcomis()));
            Double valorTotalComisao = null;
            
            if(getTradeFinNegocVO().getProduto().isGarantia() 
                    || getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                
                valorTotalComisao = SiteUtil.getDouble(SiteUtil.formatarPontosVirgula(getItemListaComissaoInterna().getVlxtotalcomis()));
            } else {
            
                for (Iterator<TrdFinNegComissaoVO> iterator = getTradeFinNegocVO().getListaComissaoInterna().iterator(); iterator.hasNext();) {
                    TrdFinNegComissaoVO item = (TrdFinNegComissaoVO) iterator.next();
                    
                    valorTotalComisao = valorTotalComisao == null ? 0D : valorTotalComisao;
                    valorTotalComisao += SiteUtil.getDouble(SiteUtil.formatarPontosVirgula(item.getVprevtcomiscmbio()));
                }
            }
            
            if(valorTotalComisao != null 
                    && valorTotalComisao < minimoCobrar) {
                NpcFacesUtils.addInfoModalMessage("Comissão Interna menor que o Valor Mínimo a Cobrar.", false);
            }
        }
    }
    
    	/**
    	* Nome: tratarBotaoAltDetComissInterna
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private void tratarBotaoAltDetComissInterna() {
    	
    	comissaoIntManutModalBean.getViewHelper().setDisabledBtoAltDetComInt(
    	        getViewHelper().getItemSelecListaComissaoInterna() == null 
                    || new Integer(999).equals(getViewHelper().getItemSelecListaComissaoInterna()) 
                    || getTradeFinNegocVO().getListaComissaoInterna().isEmpty());
    }
    
    public void listenerSelecionarComissaoInterna(AjaxBehaviorEvent e) {
    	tratarBotaoAltDetComissInterna();
    }
    
    /**
     * Nome: listenerAlterarComissaoInterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerAlterarComissaoInterna(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerAlterarComissaoInterna <<<<<<<<<<<");
    		
    		TrdFinNegComissaoVO itemComissaoInt = null;
    		
    		// valida se foi selecionado um item na lista
    		if (getViewHelper().getItemSelecListaComissaoInterna() == null
    						|| getViewHelper().getItemSelecListaComissaoInterna() > EnumTradeFinance.MAX_LISTA_INCLUSAO_COTACAO
    						.getCodigo()) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		} 
    		
    		// Recupera o item selecionado na lista
    		itemComissaoInt = getTradeFinNegocVO().getListaComissaoInterna().get(
    						getViewHelper().getItemSelecListaComissaoInterna());
    		
    		comissaoIntManutModalBean.getViewHelper().setFuncaoBotaoComissaoInterna("Alterar");
            comissaoIntManutModalBean.getViewHelper().setCodProduto(getTradeFinNegocVO().getCprodtservc());
    		comissaoIntManutModalBean.getViewHelper().setLinhaSelecionada(getViewHelper().getItemSelecListaComissaoInterna().toString());
    		comissaoIntManutModalBean.setItemListaComissaoInterna(new TrdFinNegComissaoVO());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setDateComissao(itemComissaoInt.getDateComissao());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setDataComissaoFormat(itemComissaoInt.getDataComissaoFormat());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setTdiafinandsemb(itemComissaoInt.getTdiafinandsemb());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setTdiaopercmbio(itemComissaoInt.getTdiaopercmbio());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setVprevtdsembcmbio(itemComissaoInt.getVprevtdsembcmbio());       
            comissaoIntManutModalBean.getItemListaComissaoInterna().setPtxcustototal(itemComissaoInt.getPtxcustototal());
            comissaoIntManutModalBean.getItemListaComissaoInterna().setVtxspreadnegoc(itemComissaoInt.getVtxspreadnegoc());
            comissaoIntManutModalBean.getItemListaComissaoInterna().setVtxspreadtot(itemComissaoInt.getVtxspreadtot());
            comissaoIntManutModalBean.getItemListaComissaoInterna().setPcomisnegoccmbio(itemComissaoInt.getPcomisnegoccmbio());
            comissaoIntManutModalBean.getItemListaComissaoInterna().setPtxflatpnalt(itemComissaoInt.getPtxflatpnalt());
            comissaoIntManutModalBean.getItemListaComissaoInterna().setDsccustototal(itemComissaoInt.getDsccustototal());
            comissaoIntManutModalBean.getItemListaComissaoInterna().setCpais(getTradeFinNegocVO().getCpais());
            comissaoIntManutModalBean.getViewHelper().setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());
            
            comissaoIntManutModalBean.getViewHelper().setNomeMoedaComissaoInterna(
                    SiteUtil.buscarDescricao(getViewHelper().getComboMoedaDesembolso(), 
                                             getViewHelper().getCodMoedaComissao()));
            
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setCindcdeconmmoeda(getViewHelper().getCodMoedaComissao());
    		comissaoIntManutModalBean.getViewHelper().setCodComissaoSobre(getViewHelper().getCodComissaoSobre());
    		comissaoIntManutModalBean.setListaComissaoInterna(getTradeFinNegocVO().getListaComissaoInterna());
    		
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setPeriodicidadeComissao(itemComissaoInt.getPeriodicidadeComissao());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setMomentoComissao(itemComissaoInt.getMomentoComissao());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setCfluxoperdccmbio(itemComissaoInt.getCfluxoperdccmbio());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setQpcelacmbiotrade(itemComissaoInt.getQpcelacmbiotrade());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setVprevtcomiscmbio(itemComissaoInt.getVprevtcomiscmbio());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setVlxtotalcomis(itemComissaoInt.getVlxtotalcomis());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setVlxcomiscmbio(itemComissaoInt.getVlxcomiscmbio());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setPjuronegoccmbio(itemComissaoInt.getPjuronegoccmbio());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setVlxoperaccmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
    		
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setCcobrcomisintrn(getViewHelper().getTipoCobrancaComissao());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setVmincobrcomis(getViewHelper().getVmincobrcomis());
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setListaParcelasComissao(itemComissaoInt.getListaParcelasComissao());
    		
    		// Fluxo de pagamento referente a comissão interna
    		comissaoIntManutModalBean.setFluxoPagamentoReferente(getTradeFinNegocVO().getListaFluxos().get(getViewHelper().getItemSelecListaComissaoInterna()));
    		
    		comissaoIntManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoInterna");
    		comissaoIntManutModalBean.getViewHelper().setDisabledModalComissaoInt(Boolean.FALSE);
    		comissaoIntManutModalBean.getViewHelper().setDisabledConfirmar(Boolean.TRUE);
    		comissaoIntManutModalBean.getViewHelper().setDisabledBotaoGerar(Boolean.TRUE);
    		comissaoIntManutModalBean.openModal();

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerAlterarComissaoInterna <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
    	* Nome: closeModalComissaoInterna
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void closeModalComissaoInterna(ActionEvent event) {
        
        if(comissaoIntManutModalBean.getConfirmarManutencao()) {
            
            comissaoIntManutModalBean.getItemListaComissaoInterna().getListaParcelasComissao().clear();
            comissaoIntManutModalBean.getItemListaComissaoInterna().getListaParcelasComissao().addAll(comissaoIntManutModalBean.getListaParcelasTemp());
            
            calcularValoresSpreadFlatCustoTotalComissaoInt();
            validarMinimoCobrarComissaoInterna();
        }
        
        // desabilita modal
        comissaoIntManutModalBean.getViewHelper().setRenderModalComissaoInterna(Boolean.FALSE);
        getViewHelper().setFuncaoBotaoComissaoInterna("");
        
        tratarBotaoAltDetComissInterna();
    }
    
    /**
     * 
    	* Nome: listenerExcluirComissaoInterna
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerExcluirComissaoInterna(AjaxBehaviorEvent e) {
        
        String comissao = getViewHelper().getValueComissaoCobranca();
        String minimoCobrar = getViewHelper().getVmincobrcomis();
        
        limparDadosComissaoInterna();
        tratarBotaoAltDetComissInterna();
        
        getViewHelper().setValueComissaoCobranca(comissao);
        getViewHelper().setVmincobrcomis(minimoCobrar);
    }
    
    /**
     * Nome: listenerDetalharComissaoInterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerDetalharComissaoInterna(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerDetalharComissaoInterna <<<<<<<<<<<");
    		
    		carregarDetalhesComissaoInt("Detalhar");
    		getViewHelper().setFuncaoBotaoComissaoInterna("Detalhar");

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerDetalharComissaoInterna <<<<<<<<<<<");
    	}


    }
    
    /**
     * 
    	* Nome: carregarDetalhesComissaoInt
    	* 
    	* Propósito: Carrega os dados para o Detalhar e Exclusao da Comissao Interna 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void carregarDetalhesComissaoInt(String funcao){
        TrdFinNegComissaoVO itemComissaoInt = null;
        
        // valida se foi selecionado um item na lista
        if (getViewHelper().getItemSelecListaComissaoInterna() == null
                        || getViewHelper().getItemSelecListaComissaoInterna() > EnumTradeFinance.MAX_LISTA_INCLUSAO_COTACAO
                        .getCodigo()) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            return;
        }
        
        itemComissaoInt = getTradeFinNegocVO().getListaComissaoInterna().get(getViewHelper().getItemSelecListaComissaoInterna());
        
        comissaoIntManutModalBean.getViewHelper().setFuncaoBotaoComissaoInterna(funcao);
        comissaoIntManutModalBean.setItemListaComissaoInterna(new TrdFinNegComissaoVO());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setDateComissao(itemComissaoInt.getDateComissao());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setDataComissaoFormat(itemComissaoInt.getDataComissaoFormat());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setTdiafinandsemb(itemComissaoInt.getTdiafinandsemb());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setTdiaopercmbio(itemComissaoInt.getTdiaopercmbio());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setVprevtdsembcmbio(itemComissaoInt.getVprevtdsembcmbio());
        
        for (int j = 0; j < getViewHelper().getComboMoedaDesembolso().size(); j++) {
            if (getViewHelper().getComboMoedaDesembolso().get(j).getValue().equals(getViewHelper().getCodMoedaComissao())) {
                
                comissaoIntManutModalBean.getViewHelper().setNomeMoedaComissaoInterna(getViewHelper().getComboMoedaDesembolso().get(j).getLabel());
                break;
            }
        }
        
        comissaoIntManutModalBean.getItemListaComissaoInterna().setCindcdeconmmoeda(getViewHelper().getCodMoedaComissao());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setPeriodicidadeComissao(itemComissaoInt.getPeriodicidadeComissao());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setMomentoComissao(itemComissaoInt.getMomentoComissao());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setCfluxoperdccmbio(itemComissaoInt.getCfluxoperdccmbio());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setQpcelacmbiotrade(itemComissaoInt.getQpcelacmbiotrade());
        comissaoIntManutModalBean.getItemListaComissaoInterna().setListaParcelasComissao(itemComissaoInt.getListaParcelasComissao());
        
        comissaoIntManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoInterna");
        comissaoIntManutModalBean.getViewHelper().setDisabledModalComissaoInt(Boolean.TRUE);
        comissaoIntManutModalBean.getViewHelper().setDisabledTxtParcelaComissaoInt(Boolean.TRUE);
        comissaoIntManutModalBean.getViewHelper().setRenderModalComissaoInterna(Boolean.TRUE);
        comissaoIntManutModalBean.getViewHelper().setDisabledBotaoGerar(Boolean.TRUE);
        
        if(getViewHelper().getFuncaoBotaoComissaoInterna().equals("Excluir")){
            
            comissaoIntManutModalBean.getViewHelper().setDisabledConfirmar(Boolean.FALSE);
        }
        
        comissaoIntManutModalBean.openModal();
    }
    
    /**
     * Nome: listenerTrocaPrazoOperacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTrocaPrazoOperacao(AjaxBehaviorEvent e) {
        
        try {
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaPrazoOperacao <<<<<<<<<<<");
            
            // Desmarca a flag quando o usuário altera o prazo da operação
            getTradeFinNegocVO().setPrazoOperacaoAjustado(false);
            
            if(getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0){
                //NpcFacesUtils.addInfoModalMessage("Recalcular os fluxos de pagamento de principal, juros e comissões", false);
                
                setValidaListenerTrocaValorMe(true);
        		if ((getViewHelper().getItemSelecListaFluxos() == "" || getViewHelper().getItemSelecListaFluxos() == null) && getTradeFinNegocVO().getListaFluxos().size() > 0) {
        			getViewHelper().setItemSelecListaFluxos(SiteUtil.getString(getTradeFinNegocVO().getListaFluxos().size() -1));
    			}
                listenerShowFluxoPgtSel(e);
                itemListaFluxoPgto.setTdiaopercmbio(tradeFinNegocVO.getTdiaopercmbio());
                listenerAlterarFluxo(e);
            }
            
            // Carrega a data informada de desembolso no campo fluxo de pagamento
            getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDatePrevDesembolso());
                                
            // Carrega valor do fluxo de pagamento
            itemListaFluxoPgto.setVprevtdsembcmbio(tradeFinNegocVO.getVnegocmoedaestrg());
            
            // Para o Garantia não tem o fluxo de pagamento, por isso a utilização dessa validdação
            if(!getTradeFinNegocVO().getProduto().isGarantia()) {
              
                limpaFluxoPgtComissaoInt();
                limpaFluxoPgtComissaoExterna();
            }
            
            // se produto for garantia
            else {
            	
                if(!SiteUtil.isValueZero(getViewHelper().getValueComissaoCobranca())
                        || (getTradeFinNegocVO().getListaComissaoExterna() != null 
                            && getTradeFinNegocVO().getListaComissaoExterna().size() > 0)) {
                    
                    NpcFacesUtils.addInfoModalMessage("Recalcular juros e comissões", false);
                    limpaFluxoPgtComissaoExterna();
                }
                
            	if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDprevtgarntexpdi())){
            		
        			Date dataVencFianca = commonService.getDataVencimentoFianca(getTradeFinNegocVO().getDprevtgarntexpdi(), getTradeFinNegocVO().getTdiaopercmbio());
					getTradeFinNegocVO().setDprevtprorrog(SiteUtil.dateToString(dataVencFianca, "dd/MM/yyyy"));
            	}
            }
            listenerExcluirComissaoInterna(null);
            // limpar dados da comissão interna
            //limparDadosComissaoInterna();

        } finally {
        	if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
    		/*if (getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) {*/
				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter());
	    		if (taxaFixaMaiorQueZero(custoTotal.toString())) {
	    			if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
					} else {
						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
					}
				}
    		} else if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || getTradeFinNegocVO().getCcomiscartanacio().equals("2")) && taxaFixaMaiorQueZero(getItemListaComissaoInterna().getVtravaliborcmbio())) {
				BigDecimal custoTotal = calcularCustoTotal(getItemListaComissaoInterna().getVtravaliborcmbio(), getItemListaComissaoInterna().getPtxcustoexter(), getItemListaComissaoInterna().getVtxspreadtot());
				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
					if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
					} else {
						fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
					}
				}
            }
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaPrazoOperacao <<<<<<<<<<<");
        }
    }
    
    /**
     * Nome: listenerTrocaTipoComissao
     * 
     * Propósito: Ação executada no change do combo Cobrança da Comissão (Comissão Interna)
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTrocaTipoComissao(AjaxBehaviorEvent e) {
        limparDadosComissaoInterna();
    }

    /**
     * Nome: limparDadosComissaoInterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void limparDadosComissaoInterna() {
    	try {
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.limparDadosComissaoInterna <<<<<<<<<<<");
    		
    		trocaCobrancaComissao();
    		
    		// Limpa listas de comissão interna
    		if (!getTradeFinNegocVO().getProduto().isGarantia() 
                    && !getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
    		    
    		    getTradeFinNegocVO().setListaComissaoInterna(new ArrayList<TrdFinNegComissaoVO>());
    		}
    		
    		comissaoIntManutModalBean.setItemListaComissaoInterna(new TrdFinNegComissaoVO());
            comissaoIntManutModalBean.setListaParcelasTemp(new ArrayList<TrdFinNegParcelaVO>());
            
            if (getTradeFinNegocVO().getProduto().isGarantia()) {
                calcVencFianca();

                if (comissaoExtManutModalBean.getListaComissaoExterna().size() > 0) {
                    for (int i = 0; i < comissaoExtManutModalBean.getListaComissaoExterna().size(); i++) { 
                        
                        TrdFinNegComissaoVO itemLista = (TrdFinNegComissaoVO)comissaoExtManutModalBean.getListaComissaoExterna().get(i);
                        
                        itemLista.setDateComissao(getViewHelper().getDateVencFianc());
                        itemLista.setDataComissaoFormat(SiteUtil.dateToString(getViewHelper().getDateVencFianc(), "dd/MM/yyyy"));
                        itemLista.setTdiafinandsemb(getTradeFinNegocVO().getTdiaopercmbio());
                        itemLista.setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());                
                    }
                }
            }
            
    	} finally {
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.limparDadosComissaoInterna <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: limpaFluxoPgtComissaoInt
    	* 
    	* Propósito: Ao alterar o campo "Prazo Operação (Dias)" as listas de Fluxo de Pagamentos com e sem mercadorias atreladas e
    	*            Comissão Interna serão apagadas para realizar novo cálculo
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void limpaFluxoPgtComissaoInt(){
        getTradeFinNegocVO().getListaFluxos().clear();
        
        if (!getTradeFinNegocVO().getProduto().isGarantia() 
                && !getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            
            getTradeFinNegocVO().getListaComissaoInterna().clear();
        }
        
        if (temMercadoriaAtrelada(itemListaFluxoPgto.getSeqFluxoPagto()) == Boolean.TRUE) {
            getTradeFinNegocVO().getListaMercadoria().clear();
        }
    }   
    
    /**
     * 
    	* Nome: limpaFluxoPgtComissaoExterna
    	* 
    	* Propósito: Ao alterar o campo "Prazo Operação (Dias)" as listas de Fluxo de Pagamentos com e sem mercadorias atreladas e
    	*            Comissão Interna serão apagadas para realizar novo cálculo
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void limpaFluxoPgtComissaoExterna(){
        getTradeFinNegocVO().getListaComissaoExterna().clear();
    }   
    
    	/**
    	* 
    	* Nome: listenerTrocaUnidadeExterna
    	* Propósito: 
    	*
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 12/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaUnidadeExterna(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaUnidadeExterna <<<<<<<<<<<");
    		
    		if(SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio())){
    			getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setCbanqrcmbio(null);
    			
    			// Essa validação deve ser feita para os produtos que tem fluxo de pagamento GP2
    			if(getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0 && 
    					!getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)){
    				NpcFacesUtils.addInfoModalMessage("Recalcular os fluxos de pagamento de principal, juros e comissões", false);
    			}
    			
    		} else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
    			getViewHelper().setRenderMsg(Boolean.TRUE);
    		}
    		getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setBancocorr(null);
    		getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setImunintlcmbio(null);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaUnidadeExterna <<<<<<<<<<<");
    	}
    }
    
    public void listenerTratarBancoAvisador(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarBancoAvisador <<<<<<<<<<<");
    		
    		getTrdFinNegPrecificacaoVO().getBancoAvisadorVO().setIbanqrcmbio(null);
    		getTrdFinNegPrecificacaoVO().getBancoAvisadorVO().setImunintlcmbio(null);
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarBancoAvisador <<<<<<<<<<<");
    	}
    }
    
    
    public void listenerTratarReembolsador(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarReembolsador <<<<<<<<<<<");
    		
    		getTrdFinNegPrecificacaoVO().getBancoReembolsadorVO().setIbanqrcmbio(null);
    		getTrdFinNegPrecificacaoVO().getBancoReembolsadorVO().setImunintlcmbio(null);
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarReembolsador <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
     * Nome: listenerTrocaUnidadeExternaModal
     * Propósito: 
     *
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 12/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void listenerTrocaUnidadeExternaModal(ActionEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaUnidadeExternaModal <<<<<<<<<<<");
    		
    		
    		if (unidadeExternaModalBean.getViewHelper().getIsConfirmar() 
    				&& getViewHelper().getTipoUnidExt() != null 
    				&& !getViewHelper().getTipoUnidExt().equals("Reembolsador")) {
    			if (getTradeFinNegocVO().getListaFluxos() != null 
    					&& getTradeFinNegocVO().getListaFluxos().size() > 0
    					&& !getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
    				NpcFacesUtils.addInfoModalMessage("Recalcular os fluxos de pagamento de principal, juros e comissões", false);
    			} else if (getViewHelper().isRenderMsg()) {
        			NpcFacesUtils.addInfoModalMessage("Recalcular os fluxos de pagamento de principal, juros e comissões", false);
        		}
    			
    			getTradeFinNegocVO().setCpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais());
    		}
    		 
			unidadeExternaModalBean.closeModal(null);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaUnidadeExternaModal <<<<<<<<<<<");
    	}
    }

    /**
     * Nome: openModalModeloBoleto
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     */
    public void openModalModeloBoleto(AjaxBehaviorEvent event){
    	
    	try{
    	   
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalModeloBoleto <<<<<<<<<<<");
    		
    		getModeloBoletoVO().setCprodtservc(getTradeFinNegocVO().getCprodtservc());
    		getModeloBoletoVO().setImodcontrcmbio(getTradeFinNegocVO().getDmodcontrcmbio());
		
			modeloBoletoModalBean.getViewHelper().setRenderModal(Boolean.TRUE);
    		if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
    			modeloBoletoModalBean.getViewHelper().setModalId("formTradeFinNegoc\\:content_modalModelBol");
    		} else {
    			modeloBoletoModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalModelBol");
    		}

		    modeloBoletoModalBean.getViewHelper().setTitulo("Selecionar Modelo Boleto");
		    modeloBoletoModalBean.getViewHelper().setIsConfirmar(Boolean.FALSE);
    		modeloBoletoModalBean.setBoletoVO(getModeloBoletoVO());
    		modeloBoletoModalBean.pesquisarModelBolPorNome();
		    
		    if(modeloBoletoModalBean.getListaModBoleto().size() == 0) {
		    	modeloBoletoModalBean.getViewHelper().setRenderModal(Boolean.FALSE);
    			NpcFacesUtils.addInfoModalMessage("Não existem dados para essa pesquisa", false);
    		}
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalModeloBoleto <<<<<<<<<<<");
    	}
    	
    }
	/**
	* 
	* Nome: listenerTrocaModeloBoleto
	* Propósito: 
	*
	* @see : Referencias externas.	
	*
	*/
	public void listenerTrocaModeloBoleto(ActionEvent event) {
		
		try{
			getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaModeloBoleto <<<<<<<<<<<");
			
    		getTradeFinNegocVO().setCmodcontrcmbio(modeloBoletoModalBean.getBoletoVO().getCmodcontrcmbio());
    		getTradeFinNegocVO().setDmodcontrcmbio(modeloBoletoModalBean.getBoletoVO().getImodcontrcmbio());
    		
			modeloBoletoModalBean.closeModal(null);


		}finally{
			getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaModeloBoleto <<<<<<<<<<<");
		}
	}
    /**
     * Nome: trocaCobrancaComissao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */

    protected void trocaCobrancaComissao() {

        getViewHelper().setValueComissaoCobranca("");
        getViewHelper().setVmincobrcomis("0,00");
        
        getItemListaComissaoInterna().setCcobrcomisintrn(getViewHelper().getTipoCobrancaComissao());
        getItemListaComissaoInterna().setVmincobrcomis("0,00");
        getItemListaComissaoInterna().setVtxspreadnegoc("0,00000");
        getItemListaComissaoInterna().setVtxspreadtot("0,00000");
        getItemListaComissaoInterna().setPtxflatpnalt("0,00000");
        getItemListaComissaoInterna().setVlxtotalcomis("0,00");
        getItemListaComissaoInterna().setDsccustototal("");

        aplicarMascaraComissaoInterna();
    }
    
    private void aplicarMascaraComissaoInterna() {
        if (getViewHelper().getTipoCobrancaComissao() == 2 || getViewHelper().getTipoCobrancaComissao() == 3) {

            // Formata o campo Descrição para que o mesmo seja exibido na tela.
            getViewHelper().getCampoCodigoDescricao().setRendered(Boolean.TRUE);
            getViewHelper().getCampoCodigoDescricao().setStyleClass(SiteUtil.INPUT_ORI + " ajax-no-loading");
            getViewHelper().getCampoCodigoDescricao().setTitle("Comissão");
            getViewHelper().getCampoCodigoDescricao().setAlt("{'wholePartSize': 3, 'decimalPartSize': 5}");
            getViewHelper().getCampoCodigoDescricao().setSize(18);
            getViewHelper().getCampoCodigoDescricao().setMaxlength(14);
        } else {

            // Formata o campo Descrição para que o mesmo seja exibido na tela.
            getViewHelper().getCampoCodigoDescricao().setRendered(Boolean.TRUE);
            getViewHelper().getCampoCodigoDescricao().setStyleClass(SiteUtil.INPUT_ORI + " ajax-no-loading");
            getViewHelper().getCampoCodigoDescricao().setTitle("Comissão");
            getViewHelper().getCampoCodigoDescricao().setAlt("{'type':'money-dot'}");
            getViewHelper().getCampoCodigoDescricao().setSize(22);
            getViewHelper().getCampoCodigoDescricao().setMaxlength(18);
        }
        
        /*
         * Tipo VALOR = Comissao Sobre = Total
         * Tipo FLAT  = Comissao Sobre = Total
         * Tipo A.A.  = Comissao Sobre = Saldo Devedor
         */
        EnumCobrancaComissao tipoCobranca = EnumCobrancaComissao.fromCode(getViewHelper().getTipoCobrancaComissao());
        if (getTradeFinNegocVO().getProduto().isGarantia() || getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            getViewHelper().setCodComissaoSobre(getViewHelper().getCodComisSobre());
        } else {
            if (tipoCobranca.equals(EnumCobrancaComissao.COBRANCA_A_A)) {
                getViewHelper().setCodComissaoSobre(EnumComissaoSobre.SALDO_DEVEDOR.getCodigo());
            } else {
                getViewHelper().setCodComissaoSobre(EnumComissaoSobre.TOTAL.getCodigo());
            }
        }
        
    }
    
    /**
     * Nome: listenerTrocaMoedaComissao
     * 
     * Propósito: Ação executada no change do combo moeda da Comissão. (Comissão Interna)
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTrocaMoedaComissao(AjaxBehaviorEvent e) {
        
        limparDadosComissaoInterna();
    }
    
    /**
     * Nome: listenerTrocaValorComissao
     * 
     * Propósito: Ação executada no change do campo Comissão. (Comissão Interna)
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTrocaValorComissaoUnica(AjaxBehaviorEvent e) {
        
        listenerTrocaValorComissao(e);
		
        calcularValoresSpreadFlatCustoTotalComissaoInt();
    }
    
    /**
     * Nome: listenerTrocaValorComissao
     * 
     * Propósito: Ação executada no change do campo Comissão. (Comissão Interna)
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTrocaValorComissao(AjaxBehaviorEvent e) {
        
        String valorInformado = getViewHelper().getValueComissaoCobranca();
        
        if(!SiteUtil.isEmptyOrNull(getViewHelper().getValueComissaoCobranca()) 
                && SiteUtil.isValueZero(getViewHelper().getValueComissaoCobranca())) {
    
            /* TIPO DE COBRANCA DE COMISSAO = VALOR DE COMISSAO*/
            if (getViewHelper().getTipoCobrancaComissao() == 1) {
                
                NpcFacesUtils.addInfoModalMessage("Valor comissão inválido.", false);
            
            } 
            
            /* PERCENTUAL FLAT DE COMISSAO */
            else if (getViewHelper().getTipoCobrancaComissao() == 2 
                    || getViewHelper().getTipoCobrancaComissao() == 3) {
                
                NpcFacesUtils.addInfoModalMessage("Percentual comissão inválido.", false);
            }
            
            return;
        }
        limparDadosComissaoInterna();
        getViewHelper().setValueComissaoCobranca(valorInformado);
        
        if (getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || getTradeFinNegocVO().getCcomiscartanacio().equals("2")) {
        	listenerIncluirComissaoInterna(null);
        }
    }
    
    /**
     * Nome: calcularValoresSpreadFlatCustoTotalComissaoInt
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void calcularValoresSpreadFlatCustoTotalComissaoInt() throws NpccTradeWebException {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.calcularValoresSpreadFlatCustoTotalComissaoInt <<<<<<<<<<<");

    		/* TIPO DE COBRANCA DE COMISSAO */
    		if (getViewHelper().getTipoCobrancaComissao() == 1) {
    		    
    		    getItemListaComissaoInterna().setVlxcomiscmbio(getViewHelper().getValueComissaoCobranca());
    		    getItemListaComissaoInterna().setPcomisnegoccmbio("000,00000");
    		    getItemListaComissaoInterna().setPjuronegoccmbio("000,00000");
    		} 
    		
    		else if (getViewHelper().getTipoCobrancaComissao() == 2 
    		        || getViewHelper().getTipoCobrancaComissao() == 3) {
    		    
    		    getItemListaComissaoInterna().setPjuronegoccmbio(getViewHelper().getValueComissaoCobranca());
    		    getItemListaComissaoInterna().setPcomisnegoccmbio(getViewHelper().getValueComissaoCobranca());
    		    getItemListaComissaoInterna().setVlxcomiscmbio("0,00");   
    		}

    		getItemListaComissaoInterna().setCprodtservc(getTradeFinNegocVO().getCprodtservc());
    		getItemListaComissaoInterna().setCcobrcomiscmbio(getViewHelper().getTipoCobrancaComissao());
    		getItemListaComissaoInterna().setCindcdeconmmoeda(getViewHelper().getCodMoedaComissao());
    		getItemListaComissaoInterna().setVmincobrcomis(getViewHelper().getVmincobrcomis());
    		
    		getItemListaComissaoInterna().setVlxoperaccmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
    		getItemListaComissaoInterna().setPrzoperaccmbio(getTradeFinNegocVO().getTdiaopercmbio());
    		getItemListaComissaoInterna().setPrzoperaclibor(getTrdFinNegPrecificacaoVO().getPrzomediodsembm());
    		
    		getItemListaComissaoInterna().setCindcdnegoccarta(getTradeFinNegocVO().getCindcdnegoccarta().equals("S") ? "S" : "N");
    		getItemListaComissaoInterna().setCcomiscartanacio(getTradeFinNegocVO().getCcomiscartanacio().equals("1") ? "S" : "N");
    		getItemListaComissaoInterna().setCindcdnegocswap(getTradeFinNegocVO().getCindcdnegocswap().equals("S") ? "S" : "N");
    		
    		/* PERCENTUAL DA LIBOR TRAVADA */
    		if (getTradeFinNegocVO().getVtravaliborcmbio() != null) {
    		    getItemListaComissaoInterna().setVtravaliborcmbio(getTradeFinNegocVO().getVtravaliborcmbio());
    		} else {
    		    getItemListaComissaoInterna().setVtravaliborcmbio("0,00000");
    		}
    		
    		/* PERCENTUAL DO CUSTO EXTERNO */
    		if (getTrdFinNegPrecificacaoVO().getSpreadclean() != null) {
    		    getItemListaComissaoInterna().setPtxcustoexter(getTrdFinNegPrecificacaoVO().getSpreadclean());
    		} else {
    		    getItemListaComissaoInterna().setPtxcustoexter("0,00000");
    		}
    		
    		/* PERCENTUAL DO IMPOSTO DE RENDA */
    		if (getTradeFinNegocVO().getVimpstnegoccmbio() != null) {
    		    getItemListaComissaoInterna().setPtximpstrenda(getTradeFinNegocVO().getVimpstnegoccmbio());
    		} else {
    		    getItemListaComissaoInterna().setPtximpstrenda("0,00000");
    		}
    		
    		/* Limpa campos antes de realizar pesquisa */
    		getItemListaComissaoInterna().setVtxspreadnegoc("0,00000");
    		getItemListaComissaoInterna().setVtxspreadtot("0,00000");
    		getItemListaComissaoInterna().setPtxflatpnalt("0,00000");
    		getItemListaComissaoInterna().setVlxtotalcomis("0,00");
    		
            if(!SiteUtil.isEmptyOrNull(getViewHelper().getValueComissaoCobranca()) 
                    && !SiteUtil.isValueZero(getViewHelper().getValueComissaoCobranca())) {

                if(!getTradeFinNegocVO().getListaComissaoInterna().isEmpty() 
                        || (getTradeFinNegocVO().getListaComissaoInterna().isEmpty()
                                && (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) 
                                        || getTradeFinNegocVO().getProduto().isGarantia()))) {

                    // LC Importação - spread com about
                    if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) 
                            && getTradeFinNegocVO().getCcobrcomisadcio().equals(EnumSimNaoStr.SIM.getCodigo())) {
                        
                        getItemListaComissaoInterna().setVlimcobervar(getTradeFinNegocVO().getVlimcobervar());
                    } else {
                        getItemListaComissaoInterna().setVlimcobervar("");
                    }
                    
                    // LC e Garantias envia lista vazia.
                    List<TrdFinNegComissaoVO> listaComissaoInt = new ArrayList<TrdFinNegComissaoVO>();
                    if (!getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) 
                            && !getTradeFinNegocVO().getProduto().isGarantia()) {
                        
                        listaComissaoInt = getTradeFinNegocVO().getListaComissaoInterna();
                    }
                    
                    // Fluxo: NPCCIASO - Books: NPCCWXXE / NPCCWXXS
                    getTradeFinanceNegociacaoService().getSpreadNegociado(
                            itemListaComissaoInterna, 
                            listaComissaoInt,
                            getTradeFinNegocVO().getListaComissaoExterna(), 
                            getViewHelper().getPrzomediooperd(), 
                            getTradeFinNegocVO().getDadosPrecificacao().getCustoext());
                    
                    for (Iterator<TrdFinNegComissaoVO> iterator = getTradeFinNegocVO().getListaComissaoInterna().iterator(); iterator.hasNext();) {
                        TrdFinNegComissaoVO item = (TrdFinNegComissaoVO) iterator.next();
                        
                        item.setVtxspreadnegoc(getItemListaComissaoInterna().getVtxspreadnegoc());
                        item.setVtxspreadtot(getItemListaComissaoInterna().getVtxspreadtot());
                        item.setPtxflatpnalt(getItemListaComissaoInterna().getPtxflatpnalt());
                        item.setVlxtotalcomis(getItemListaComissaoInterna().getVlxtotalcomis());
                        item.setDsccustototal(getItemListaComissaoInterna().getDsccustototal());
                    }
                    
                    tradeFinNegocVO.setVtxspreadnegoc(getItemListaComissaoInterna().getVtxspreadnegoc());
                    tradeFinNegocVO.setVtxspreadtot(itemListaComissaoInterna.getVtxspreadtot());
                }
            }
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.calcularValoresSpreadFlatCustoTotalComissaoInt <<<<<<<<<<<");
    	}


    }
    
    /************************** 
     * FIM - COMISSÃO INTERNA *
     **************************/    
    
    /******************************************
     * Metodos do trecho Operações Vinculadas *
     ******************************************/
    
    /**
     * Nome: listenerIncluirOperacaoVinculada
     * 
     * Propósito: Metodo do botão incluir operações vinculadas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirOperacaoVinculada(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirOperacaoVinculada <<<<<<<<<<<");
    		
    		if (SiteUtil.isEmptyOrNull(getOperVinculadasVO().getDanobase()) ||
    						SiteUtil.isEmptyOrNull(getOperVinculadasVO().getNumoperacao()) ||
    						getOperVinculadasVO().getNumoperacao() <= Numeros.NUM0_LONG) {
    			NpcFacesUtils.addInfoModalMessage("Operação inválida.", false);
    			return;
    		}
    		
    		String cotacao = getOperVinculadasVO().getDanobase() +""+ SiteUtil.completarZerosEsquerda(9, getOperVinculadasVO().getNumoperacao().toString());
    		
    		for (TrdFinNegOperVincVO trdFinNegOperVincVO : getTradeFinNegocVO().getListaOperacaoVinculada()) {
    			if(cotacao.equals(trdFinNegOperVincVO.getNbletocmbioano().toString())){
    				NpcFacesUtils.addInfoModalMessage("Operação "+ cotacao +" já incluída.", false);
        			return;
    			}
			}
    		
    		List<TrdFinNegOperVincVO> listaOperVincLocal = new ArrayList<TrdFinNegOperVincVO>();
    		
    		getOperVinculadasVO().setCunicclicmbio(getTradeFinNegocVO().getCunicclicmbio());
    		getOperVinculadasVO().setDataPesquisa(null);
    		getOperVinculadasVO().setCprodtservc(getTradeFinNegocVO().getProduto().getCodigo());
    		getOperVinculadasVO().setCindcdeconmmoeda(getTradeFinNegocVO().getCindcdeconmmoeda());
    		listaOperVincLocal = getTradeFinanceNegociacaoService().getOperacoesVinculadas(getOperVinculadasVO());
    		
    		for (Iterator<TrdFinNegOperVincVO> iterator = listaOperVincLocal.iterator(); iterator.hasNext();) {
    			TrdFinNegOperVincVO itemOperVincVO = (TrdFinNegOperVincVO) iterator.next();
    			
    			getTradeFinNegocVO().getListaOperacaoVinculada().add(itemOperVincVO);
    			
    		}
    		
    		getOperVinculadasVO().setDanobase(0);
    		getOperVinculadasVO().setNumoperacao(0);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirOperacaoVinculada <<<<<<<<<<<");
    	}
    }

    /**
     * Nome: listenerModalOperacoesVinculadas
     * 
     * Propósito: Metodo para abrir o modal de seleção de operações vinculadas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerModalOperacoesVinculadas(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerModalOperacoesVinculadas <<<<<<<<<<<");
    		
    		oprVincModalBean.setListaModalOperVinculadas(new ArrayList<TrdFinNegOperVincVO>());
    		oprVincModalBean.setOperVinculadasVO(new TrdFinNegOperVincVO());
    		oprVincModalBean.getOperVinculadasVO().setCunicclicmbio(getTradeFinNegocVO().getCunicclicmbio());
    		oprVincModalBean.getOperVinculadasVO().setCprodtservc(getTradeFinNegocVO().getCprodtservc());
    		oprVincModalBean.getOperVinculadasVO().setCindcdeconmmoeda(getTradeFinNegocVO().getCindcdeconmmoeda());
    		oprVincModalBean.setListaOperacaoVinculada(getTradeFinNegocVO().getListaOperacaoVinculada());
    		oprVincModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalOperacoesVinculadas");
    		oprVincModalBean.getViewHelper().setRenderModalOperacoesVinculadas(Boolean.TRUE);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerModalOperacoesVinculadas <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: listenerExcluirOperacaoVinculada
     * 
     * Propósito: Metodo para excluir uma operação vinculada
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerExcluirOperacaoVinculada(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirOperacaoVinculada <<<<<<<<<<<");
    		
    		TrdFinNegOperVincVO itemOpVinc = null;
    		
    		// valida se foi selecionado um item na lista
    		if (getViewHelper().getItemSelecListaOperacaoVinculada() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		
    		itemOpVinc = getTradeFinNegocVO().getListaOperacaoVinculada().get(
    						getViewHelper().getItemSelecListaOperacaoVinculada());
    		
    		// Remove o item selecionado.
    		getTradeFinNegocVO().getListaOperacaoVinculada().remove(itemOpVinc);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirOperacaoVinculada <<<<<<<<<<<");
    	}
    	
    }
    
    /************************************************** 
     * FIM - Tela Modal Consulta Operações Vinculadas * 
     **************************************************/
    
    /*********** 
     * TARIFAS *
     ***********/
    
    /**
     * Nome: listenerIncluirTarifa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirTarifa(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirTarifa <<<<<<<<<<<");
    		
    		// Verifica se a tarifa já foi incluida
    		if(!tarifaIncluida(getViewHelper().getCodTarifa())) {
    		    
    		    TrdFinNegTarifaVO itemLista = null;
    		    
    		    String nomeTarifa = null;
    		    
    		    itemLista = getCommonService().detalharTarifaDespesa(getTradeFinNegocVO().getCunicclicmbio(), getViewHelper().getCodTarifa(),
    		            "", TIPO_TARIFA);
    		    
    		    for (int j = 0; j < getViewHelper().getComboTarifas().size(); j++) {
    		        if (getViewHelper().getComboTarifas().get(j).getValue().equals(getViewHelper().getCodTarifa())) {
    		            nomeTarifa = getViewHelper().getComboTarifas().get(j).getLabel();
    		            break;
    		        }
    		    }
    		    itemLista.setCindcddesptarf(getViewHelper().getCodTarifa());
    		    itemLista.setDescrdesptarif(nomeTarifa);
    		    
    		    /* Solcitado pelo MF em 30/06/2016 */
    		    itemLista.setCcondceconc(itemLista.getCindcddesptarf());
    		    
    		    
    		    // Adiciona os dados na lista.
    		    getTradeFinNegocVO().getListaTarifas().add(itemLista);
    		    
    		    getViewHelper().setCodTarifa(Numeros.ZERO);
            }

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirTarifa <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
     */
    public void incluirTarifaAutomatica(List<TarifaAutomaticaVO> listaTarifasAutomaticas) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirTarifaAutomatica <<<<<<<<<<<");
    		
    		for (int i = 0; i < listaTarifasAutomaticas.size(); i++) {
    			
    			if (listaTarifasAutomaticas.get(i).getIndaut().equalsIgnoreCase("S")) {
		    		TrdFinNegTarifaVO itemLista = null;
		    		String nomeTarifa = null;
		    		
		    		if (getTradeFinNegocVO().getCunicclicmbio() == 0) {
		    			getTradeFinNegocVO().setCunicclicmbio(getTradeFinanceBean().getTradeFinanceVO().getCunicclicmbio());
					}
		    		
		    		itemLista = getCommonService().detalharTarifaDespesa(getTradeFinNegocVO().getCunicclicmbio(), listaTarifasAutomaticas.get(i).getCcondceconc(), "", TIPO_TARIFA);
		    		    
		    		nomeTarifa = listaTarifasAutomaticas.get(i).getIcondceconc();
		    		
		    		
		    		itemLista.setCindcddesptarf(getViewHelper().getCodTarifa());
		    		itemLista.setDescrdesptarif(nomeTarifa);
		    		    
		    		/* Solcitado pelo MF em 30/06/2016 */
		    		itemLista.setCcondceconc(itemLista.getCtpodespcmbio());
		    	   
		    		// Adiciona os dados na lista.
		    		getTradeFinNegocVO().getListaTarifas().add(itemLista);
		    		    
		    		getViewHelper().setCodTarifa(Numeros.ZERO);
    			}

    		}
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirTarifaAutomatica <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
     */
    

    /**
     * Nome: listenerExcluirTarifas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerExcluirTarifas(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirTarifas <<<<<<<<<<<");
    		
    		TrdFinNegTarifaVO itemLista = null;
    		
    		// valida se foi selecionado um item na lista
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaTarifas())) {
                NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            }
    		
    		itemLista = getTradeFinNegocVO().getListaTarifas().get(SiteUtil.getInt(getViewHelper().getItemSelecListaTarifas()));
    		
    		// Remove o item selecionado.
    		getTradeFinNegocVO().getListaTarifas().remove(itemLista);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirTarifas <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: tarifaIncluida
     * 
     * Propósito: Verifica se a tarifa já foi incluida na cotação
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    private Boolean tarifaIncluida(Integer codTarifa) {
        Boolean result = false;
        
        for (Iterator<TrdFinNegTarifaVO> iterator = getTradeFinNegocVO().getListaTarifas().iterator(); iterator.hasNext();) {
            TrdFinNegTarifaVO tarifa = (TrdFinNegTarifaVO) iterator.next();
            
            if(codTarifa.equals(tarifa.getCtpodespcmbio())) {
                NpcFacesUtils.addInfoModalMessage("Tarifa já incluida.", false);
                result = true;
                break;
            }
        } 
        
        return result;
    }

    /***************** 
     * FIM - TARIFAS *
     *****************/

    /*********************************
     * Tela Modal Selecionar Cliente *
     *********************************/
    
    /**
     * Nome: listenerMudaNomeCliente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerMudaNomeCliente(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerMudaNomeCliente <<<<<<<<<<<");
    		
    		limpaCamposCliente();

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerMudaNomeCliente <<<<<<<<<<<");
    	}
    }

    /**
     * Nome: listenerMudaCpfCnpjCliente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerMudaCpfCnpjCliente(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerMudaCpfCnpjCliente <<<<<<<<<<<");
    		
    		limpaCamposCliente();

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerMudaCpfCnpjCliente <<<<<<<<<<<");
    	}
    	
    }

  
    
    /**
     * Nome: limpaCamposCliente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void limpaCamposCliente() {
        setClienteSelecaoVO(new ClienteSelecaoVO());
        getClienteSelecaoVO().setCnpj(new CnpjDataType());
        getClienteSelecaoVO().setCpf(new CpfDataType());
        getTradeFinNegocVO().setCunicclicmbio(null);
        getTradeFinNegocVO().setInformacaoPiloto(new InformacaoPilotoVO());
        
        if (getViewHelper().getCpfClienteBinding() != null) {
            getViewHelper().getCpfClienteBinding().setSubmittedValue(null);
        }

        if (getViewHelper().getCnpjClienteBinding() != null) {
            getViewHelper().getCnpjClienteBinding().setSubmittedValue(null);
        }
    }

    /**
     * Nome: listenerPesquisarClientePorNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClientePorNome(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerPesquisarClientePorNome <<<<<<<<<<<");
    		
    		if (getClienteSelecaoVO().getNomeCliente().length() <= 0) {
    			NpcFacesUtils.addInfoModalMessage("Preencha o campo Cliente.", false);
    			return;
    		}
    		
    		if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
    			clienteModalBean.getViewHelper().setModalId("formTradeFinNegoc\\:modalCliente");
    		} else {
    			clienteModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalCliente");
    		}
    		
    		clienteSelecaoVO.setCodCpfCnpj(Numeros.UM);
    		clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
    		clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(getViewHelper().getCodCpfCnpjSelecionado());
    		clienteModalBean.getViewHelper().setPesqCpf(Boolean.FALSE);
    		clienteModalBean.getViewHelper().setItemSelecListaSelCliente(null);
    		clienteModalBean.getViewHelper().setNomeStateIdListaSelCliente("NPCCIASJ");
    		clienteModalBean.openModal();
    		
    		getViewHelper().setRenderModalCliente(Boolean.TRUE);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerPesquisarClientePorNome <<<<<<<<<<<");
    	}
        
    }

    /**
     * Nome: listenerPesquisarClientePorCpfCnpj
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClientePorCpfCnpj(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerPesquisarClientePorCpfCnpj <<<<<<<<<<<");
    		
    		Integer cpfCnpjSelecionado = getViewHelper().getCodCpfCnpjSelecionado();
    		
    		// Verifica se o campo de CPF/CNPJ foi preenchido, caso contrário apresenta mensagem na tela.
    		if (cpfCnpjSelecionado == Numeros.DOIS && getClienteSelecaoVO().getCnpj().toString().equals("")) {
    			
    			NpcFacesUtils.addInfoModalMessage("Preencha o campo CNPJ.", false);
    			return;
    		} else if (cpfCnpjSelecionado == Numeros.TRES && getClienteSelecaoVO().getCpf().toString().equals("")) {
    			
    			NpcFacesUtils.addInfoModalMessage("Preencha o campo CPF.", false);
    			return;
    		}
    		
    		if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
    			clienteModalBean.getViewHelper().setModalId("formTradeFinNegoc\\:modalCliente");
    		} else {
    			clienteModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalCliente");
    		}
    		
    		clienteSelecaoVO.setCodCpfCnpj(getViewHelper().getCodCpfCnpjSelecionado());
    		clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
    		clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(cpfCnpjSelecionado);
    		clienteModalBean.getViewHelper().setPesqCpf(Boolean.TRUE);
    		clienteModalBean.getViewHelper().setItemSelecListaSelCliente(null);
    		clienteModalBean.openModal();
    		getViewHelper().setRenderModalCliente(Boolean.TRUE);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerPesquisarClientePorCpfCnpj <<<<<<<<<<<");
    	}
        
        
    }

    /**
     * Nome: closeModalCliente
     * 
     * Propósito: Metodo executado ao fechar o modal de clientes
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalCliente(ActionEvent event) {
    	
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalCliente <<<<<<<<<<<");
    		
    		Boolean isConfirmar = Boolean.FALSE;
    		
    		// Salva os dados do cliente para uso nos outros serviços
    		getViewHelper().setCodCpfCnpjSelecionado(clienteModalBean.getViewHelper().getCodCpfCnpjSelecionado());
    		getTradeFinNegocVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
    		getTradeFinNegocVO().setCdcpfcnpj(getClienteSelecaoVO().getCdcpfcnpj());
    		getTradeFinNegocVO().setCdfilial(getClienteSelecaoVO().getCdfilial());
    		getTradeFinNegocVO().setCdctrlcpfcnpj(getClienteSelecaoVO().getCdctrlcpfcnpj());
    		getTradeFinNegocVO().setNctabcriacmbio(getClienteSelecaoVO().getNctabcriacmbio());
    		isConfirmar = clienteModalBean.getViewHelper().isConfirmar(); 
    		
    		// desabilita modal
    		getViewHelper().setRenderModalCliente(Boolean.FALSE);
    		clienteModalBean.closeModal(event);
    		
    		// BOTAO CONFIRMAR do modal de clientes
    		if(isConfirmar) {
    			
    			// se existe cliente selecionado
    			if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCunicclicmbio())) {
    			    
    			    // Limpa campo de limite selecionado
    			    setLimiteVO(new LimitesModalVO());
    			    calcularValorLimite();
    				
                    // carrega dados de segmento e rating
    					obterDadosClienteRatingSegmento();

    				
    				alertasClienteModalBean.openModal(getTradeFinNegocVO().getCunicclicmbio());

        			// Exibe mensagem se o cliente estiver com bloqueio de uma operação desenquadrada
        			String msgBloqueio = desenquadradaModalService.consultarBloqueioCliente(getTradeFinNegocVO().getCunicclicmbio());
        			
        			if (!SiteUtil.isEmptyOrNull(msgBloqueio) && msgBloqueio.equals("S")) {
        				String mensagem = (SiteUtil.isEmptyOrNull(desenquadradaModalService
        						.getMsgRetorno()) ? "Cliente bloqueado por uma operação desenquadrada."
        						: desenquadradaModalService.getMsgRetorno());
        				
        				 NpcFacesUtils.addInfoModalMessage(mensagem, EnumButtonBehavior.SUBMIT);
        			}
        			
        			getTradeFinNegocVO().setInformacaoPiloto(tradeFinanceNegociacaoService.consultarSituacaoPiloto(getTradeFinNegocVO().getCunicclicmbio()));
    				
    			} else {
    				limpaCamposCliente();    				
    			}    			
    			
    		} else {
    			
    			// se existe cliente selecionado, ajusta o nome no campo
    			if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCunicclicmbio())) {
    				getClienteSelecaoVO().setNomeCliente(getClienteSelecaoVO().getIredzdpssoacmbio());
    			}
    			
    		}
    		
    		// Caso o piloto está ativo e o cliente nao opera com limite
    		// Não irá liberar para operar com limite
    		if(getTradeFinNegocVO().getInformacaoPiloto().isPilotoAtivo()
    		                && !getTradeFinNegocVO().getInformacaoPiloto().isClientePiloto()) {
    		    getViewHelper().setOperaComLimite(false);
    		} else {
    		    getViewHelper().setOperaComLimite(true);
    		}

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalCliente <<<<<<<<<<<");
    	}
        

    }

    public void openModalBotaoAlerta(AjaxBehaviorEvent event) {
        // recupera o código do cliente
        Long codigoCliente = SiteUtil.getLong(event.getComponent().getAttributes().get("paramCodPessoaAlertas"));

        alertasClienteModalBean.openModal(codigoCliente);
        
        getViewHelper().setControleBotaoAlerta(EnumTradeFinance.ACESSO_ALERTA.getCodigo());
    }
    
    /**
     * Nome: closeModalCliente
     * 
     * Propósito: Fecha modal cliente
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalAlertasCliente() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalAlertasCliente <<<<<<<<<<<");
    		
    		alertasClienteModalBean.closeModal();

    		if (SiteUtil.isEmptyOrNull(getViewHelper().getControleBotaoAlerta()) == true ||
    		                getViewHelper().getControleBotaoAlerta() != EnumTradeFinance.ACESSO_ALERTA.getCodigo()) {
                // trata modal de limites
    		    if(getViewHelper().isOperaComLimite() == true) {
    		        tratarListaLimite();
    		    }
                
            }
            getViewHelper().setControleBotaoAlerta(null);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalAlertasCliente <<<<<<<<<<<");
    	}
        

    }

    /**
     * Nome: getSelectItemRadioListaSelCliente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioListaSelCliente() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();

        SiteUtil.atualizarSelectItem(getListaSelCliente(), selectItemRadioLista);

        return selectItemRadioLista;
    }

    /**
     * Nome: obterDadosClienteRatingSegmento
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void obterDadosClienteRatingSegmento() {

        try {
            getTradeFinNegocVO().setTelaInicioNegociacao(getViewHelper().isTelaInicioNegociacao());
            getTradeFinanceNegociacaoService().getClienteDadosRatingSegmento(getTradeFinNegocVO());
        } catch (NpccTradeWebException e) {
            // Caso ocorra um erro ao recuperar os dados, limpa os dados para não ficar sujeira
            getTradeFinNegocVO().setCtposgmtocli(null);
            getTradeFinNegocVO().setIsgmto(null);
            getTradeFinNegocVO().setCrting(null);
            getTradeFinNegocVO().setCpssoaundorgnz(null);
            getTradeFinNegocVO().setNsequndorgnz(null);
            getTradeFinNegocVO().setIrzscial(null);
            getTradeFinNegocVO().setIciddeender(null);
            getTradeFinNegocVO().setCsgluf(null);
            getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO().setCbanqrcmbio(null);
            getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO().setIbanqrcmbio(null);
            getTradeFinNegocVO().setCpais(null);
            getTradeFinNegocVO().setNomeundorgnz(null);
            NpcFacesUtils.addInfoModalMessage(e.getMessage(), false);
        }

    }
    
    /***************************************
     * FIM - Tela Modal Selecionar Cliente *
     ***************************************/
    
    /*********************************
     * Tela Modal Detalhar Garantias *
     *********************************/

    /**
     * Nome: listenerDetalharGarantias
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerDetalharGarantias(AjaxBehaviorEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerDetalharGarantias <<<<<<<<<<<");
    		
    		carregarDadosModalGarantias();
    		
    		if (getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo()) 
    		                || (garantiasModalBean.getListaGarantiasAdicionais() != null
    		                && garantiasModalBean.getListaGarantiasAdicionais().size() > 0)) {
    			garantiasModalBean.openModalInclusao(null);
    		} else {
    			garantiasModalBean.openModalGarantias();
    		}

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerDetalharGarantias <<<<<<<<<<<");
    	}
    	
    }

	protected void carregarDadosModalGarantias() {
		garantiasModalBean.setCodProduto(getTradeFinNegocVO().getCprodtservc());
		garantiasModalBean.setCcpfcnpj(getTradeFinNegocVO().getCdcpfcnpj());
		garantiasModalBean.setCflialcpfcnpj(getTradeFinNegocVO().getCdfilial());
		garantiasModalBean.setCctrlcpfcnpj(getTradeFinNegocVO().getCdctrlcpfcnpj());
		garantiasModalBean.setCunicpssoacmbio(getTradeFinNegocVO().getCunicclicmbio());
		
		// DESCRICAO DO CLIENTE E PRODUTO
		garantiasModalBean.setNcunicclicmbio(getClienteSelecaoVO().getNomeCliente());
		garantiasModalBean.setDprodtservc(EnumProduto.fromCode(getTradeFinNegocVO().getCprodtservc()).getDescricao());
		
		garantiasModalBean.setNseqcontrlim(getTradeFinNegocVO().getNseqcontrlim());
		garantiasModalBean.setNppstapontucmbio(getTradeFinNegocVO().getNppstapontucmbio());
	}
    
    /***************************************
     * FIM - Tela Modal Detalhar Garantias *
     ***************************************/

    /*****************************************
     * Tela Modal Selecionar Unidade Externa *
     *****************************************/

    /**
     * Nome: listenerPesquisarUnidExtPorNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarUnidExtPorNome(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerPesquisarUnidExtPorNome <<<<<<<<<<<");
    		
    		if (getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio().length() <= 0) {
    			NpcFacesUtils.addInfoModalMessage("Preencha o campo Unidade Externa.", false);
    			return;
    		}
    		
    		getViewHelper().setNomeStateIdListaSelUnidExt("NPCDIADP");
    		
    		getTrdFinNegPrecificacaoVO().getUnidadeExternaVO()
    		.setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
    		setListaUniExterna(getCommonService().getListaUniExterna(getTrdFinNegPrecificacaoVO()));
    		
    		getViewHelper().setModalId("formTrdFinNegIncl\\:modalUnidExt");
    		
    		getViewHelper().setRenderModalUnidExt(Boolean.TRUE);
    		
    		return;

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerPesquisarUnidExtPorNome <<<<<<<<<<<");
    	}


    }

    /**
     * Nome: selecionarUnidExt
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String selecionarUnidExt() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.selecionarUnidExt <<<<<<<<<<<");
    		
    		// valida se foi selecionado um item na lista
    		if (getViewHelper().getItemSelecListaUnidExt() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return null;
    		}
    		
    		// Apresenta dados da lista na tela
    		getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setIbanqrcmbio(getListaUniExterna().get(getViewHelper().getItemSelecListaUnidExt())
    						.getIbanqrcmbio());
    		
    		// Salva os dados do UnidExt para uso nos outros serviços
    		
    		getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setCbanqrcmbio(getListaUniExterna().get(getViewHelper().getItemSelecListaUnidExt())
    						.getCbanqrcmbio());
    		getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setImunintlcmbio(getListaUniExterna().get(getViewHelper().getItemSelecListaUnidExt())
    						.getImunintlcmbio());
    		
    		if (getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo())) {
    			return "/content/comercializacao/precificacao/negociacao/tradeFinNegModalClose.xhtml";
    		}
    		return "/content/comercializacao/precificacao/negociacao/content/alteraModal/tradeFinNegModalClose.xhtml";

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.selecionarUnidExt <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: closeModalUnidExt
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalUnidExt(ActionEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalUnidExt <<<<<<<<<<<");
    		
    		// ao fechar o modal limpa a lista
    		setListaUniExterna(new ArrayList<TradeFinNegocListasVO>());
    		
    		// desabilita modal
    		getViewHelper().setRenderModalUnidExt(Boolean.FALSE);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalUnidExt <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: getSelectItemRadioListaUnidExt
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioListaUnidExt() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();

        SiteUtil.atualizarSelectItem(getListaUniExterna(), selectItemRadioLista);

        return selectItemRadioLista;
    }

    /**
     * Nome: paginarUnidExt
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginarUnidExt(ActionEvent event) {
        setListaUniExterna(getCommonService().getListaUniExterna(getTrdFinNegPrecificacaoVO()));
    }

    /**
     * Nome: getSelectItemRadioListaUniExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioListaUniExterna() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();

        SiteUtil.atualizarSelectItem(getListaUniExterna(), selectItemRadioLista);

        return selectItemRadioLista;
    }
    
    /***********************************************
     * FIM - Tela Modal Selecionar Unidade Externa *
     ***********************************************/
    
    /*********************************************** 
     * Tela Modal Selecionar Incluir Libor Travada *
     ***********************************************/

    /**
     * Nome: listenerIncluirLiborTravada
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirLiborTravada(AjaxBehaviorEvent e) {
    	liborTravadaModalBean.setTradeFinNegocVO(getTradeFinNegocVO());
    	liborTravadaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalLiborTravada");
    	liborTravadaModalBean.incluirLiborTravada();
    }
    
    /**
     * Nome: confirmaLiborTravada
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @Deprecated
    //MOVIDO PARA O BEAN DO MODAL LiborTravadaModalBean
    public String confirmaLiborTravada() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.confirmaLiborTravada <<<<<<<<<<<");
    		
    		getTradeFinNegocVO().setVtravaliborcmbio(getViewHelper().getLiborTravada());
    		
    		// Apresenta dados da lista na tela
    		
    		if (getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo())) {
    			return "/content/comercializacao/precificacao/negociacao/tradeFinNegModalClose.xhtml";
    		}
    		return "/content/comercializacao/precificacao/negociacao/content/alteraModal/tradeFinNegModalClose.xhtml";

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.confirmaLiborTravada <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: closeModalLiborTravada
     * 
     * Propósito: Sobreposição do metodo para recalcular o custo total após a alteração do valor da libor
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalLiborTravada(ActionEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalLiborTravada <<<<<<<<<<<");
    		
    		// desabilita modal
    		liborTravadaModalBean.closeModalLiborTravada(event);
    		
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    		    calcCustoTotalForfaiting();
    		} else {
    		    // Recalcular o custo total, se já tiver comissão interna inserida
                if(!getTradeFinNegocVO().getListaComissaoInterna().isEmpty()) {    
                    calcularValoresSpreadFlatCustoTotalComissaoInt();
                }
    		}

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalLiborTravada <<<<<<<<<<<");
    	}

    }

    /*******************************
     * FIM - Incluir Libor Travada * 
     *******************************/
    
    /********************************* 
     * Metodos do trecho Mercadorias *
     *********************************/

    /**
     * Nome: listenerIncluirMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirMercadoria(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirMercadoria <<<<<<<<<<<");
    		
    		String nomeCombo = "";
    		int maxIndexFluxo = 0;
    		Boolean isValid = Boolean.TRUE;
    		
    		/** VERIFICA SE FOI REALIZADA A PESQUISA DA MERCADORIA **/
    		if(!SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getRmcadoopercmbio()) 
    			&& SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCmcadoopercmbio())) {
    		        NpcFacesUtils.addInfoModalMessage("Pesquisa de Mercadoria não realizada.", false);
    		        return;
    		}
    		
    		/** VERIFICA SE FOI REALIZADA A PESQUISA DO BENEFICIARIO **/
    		if(!SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getIpssoacmbio())
                        && SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCunicpssoamcado())){
                    
                    NpcFacesUtils.addInfoModalMessage("Pesquisa de Beneficiário não realizada.", false);
                    return;
            }
			
    		if (getTradeFinNegocVO().getListaFluxos().size() <= Numeros.ZERO && temFluxoPagamento()) {
                NpcFacesUtils.addInfoModalMessage("Fluxo de Pagamento não incluído.", false);
                return;
            }

    		if (SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCpais())) {
        		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
        			NpcFacesUtils.addInfoModalMessage("País de Origem inválido.", false);
        			isValid = Boolean.FALSE;
        		}
    		} else {
    			for (int j = 0; j < getViewHelper().getComboPaisOrigem().size(); j++) {
    				if (getViewHelper().getComboPaisOrigem().get(j).getValue().
    								equals(getTrdFinNegMercadoriaVO().getCpais())) {
    					nomeCombo = getViewHelper().getComboPaisOrigem().get(j).getLabel();
    				}
    			}
    			getTrdFinNegMercadoriaVO().setNomeCpais(nomeCombo);
    		}

    		//validaçoes do pais de embarque
    		if(!SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCpaisembrq()))
	            getTrdFinNegMercadoriaVO().setNomePaisEmbrq(selectItemBean.getSelectItemLabelByValue(
	                            getTrdFinNegMercadoriaVO().getCpaisembrq(), getViewHelper().getComboPaisEmbarque()));

    		//validações da previsão de embarque
    		getTrdFinNegMercadoriaVO().setDataPrevEmbFormat(SiteUtil.dateToString(getTrdFinNegMercadoriaVO().getDprevtembrq(), "dd/MM/yyyy"));
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	    		if(SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getDprevtembrq())){
	    			NpcFacesUtils.addInfoModalMessage("Previsão de embarque inválido.", false);
	    			isValid = Boolean.FALSE;
	    		}
    		}

    		if (!SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCpaisbnefc())) {
    			for (int j = 0; j < getViewHelper().getComboPaisBeneficiario().size(); j++) {
    				if (getViewHelper().getComboPaisBeneficiario().get(j).getValue().
    								equals(getTrdFinNegMercadoriaVO().getCpaisbnefc())) {
    					nomeCombo = getViewHelper().getComboPaisBeneficiario().get(j).getLabel();
    				}
    			}
    			getTrdFinNegMercadoriaVO().setNomeCpaisbnefc(nomeCombo);
    		}
    		
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                
                if (getListaDesembolso().size() > Numeros.ZERO) {
                    maxIndexFluxo = getListaDesembolso().size() - 1;
                    if (!SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getNdsembcmbiotrade())
                                    && getTrdFinNegMercadoriaVO().getNdsembcmbiotrade() > getListaDesembolso().get(maxIndexFluxo).getSeqDesembolso()) {
                        NpcFacesUtils.addInfoModalMessage("Número do Desembolso inválido", false);
                        getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.ZERO);
                        isValid = Boolean.FALSE;
                    }
                } else {
                    if (!SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getNdsembcmbiotrade())) {
                        NpcFacesUtils.addInfoModalMessage("Número do Desembolso inválido", false);
                        getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.ZERO);
                        isValid = Boolean.FALSE;
                    }
                      
                }
    		} else {
    		    if (!getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
    		                    && !getTradeFinNegocVO().getProduto().isGarantia()) {
                    maxIndexFluxo = getTradeFinNegocVO().getListaFluxos().size() - 1;
                    if (!SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getNdsembcmbiotrade())
                                    && getTrdFinNegMercadoriaVO().getNdsembcmbiotrade() > getTradeFinNegocVO().getListaFluxos().get(maxIndexFluxo).getSeqFluxoPagto()) {
                        NpcFacesUtils.addInfoModalMessage("Número do Desembolso inválido", false);
                        isValid = Boolean.FALSE;
                    }
    		    }
    		}
    		
    		//Se produto for Diferente de Letra de Cambio, verifica se pelo menos um campo está preenchido
		    if (!getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) &&
		       SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCmcadoopercmbio()) &&
    		   SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCpais()) &&
	    	   SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getDprevtembrq()) &&
    		   SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCunicpssoamcado()) &&
    		   SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getCpaisbnefc()) &&
               SiteUtil.isEmptyOrNull(getTrdFinNegMercadoriaVO().getNdsembcmbiotrade())) {
               NpcFacesUtils.addInfoModalMessage("É necessário o preenchimento de pelo menos um dos campos.", false);
               isValid = Boolean.FALSE;
		    }
    		
    		if (isValid == Boolean.FALSE) {
    			return;
    		}
    		
    		
    		// Adiciona os dados na lista.
    		getTradeFinNegocVO().getListaMercadoria().add(getTrdFinNegMercadoriaVO());
    		
    		setTrdFinNegMercadoriaVO(new TrdFinNegMercadoriaVO());
    		
    		if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
    		    getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.ZERO);
                
    		}else {
    		    getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.UM);
                
    		}
    	    
    		

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirMercadoria <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: listenerExcluirMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerExcluirMercadoria(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirMercadoria <<<<<<<<<<<");
    		
    		TrdFinNegMercadoriaVO itemMercadoria = null;
    		
    		// valida se foi selecionado um item na lista
    		if (getViewHelper().getItemSelecListaMercadoria() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		
    		itemMercadoria = getTradeFinNegocVO().getListaMercadoria().get(getViewHelper().getItemSelecListaMercadoria());
    		
    		// Remove o item selecionado.
    		getTradeFinNegocVO().getListaMercadoria().remove(itemMercadoria);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirMercadoria <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: listenerPesquisarMercadoriaPorNome
     * 
     * Propósito: Metodo para abrir o modal de pesquisa de garantias
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarMercadoriaPorNome(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerPesquisarMercadoriaPorNome <<<<<<<<<<<");
    		
    		getTrdFinNegMercadoriaVO().setTipoPesquisaMercadoria(EnumTradeFinance.PESQUISA_MERCADORIA_POR_NOME.getCodigo());
    		mercadoriaModalBean.setMercadoriaVO(getTrdFinNegMercadoriaVO());
    		mercadoriaModalBean.getViewHelper().setNomeStateIdListaSelMercadoria("NPCCIAOY");
    		mercadoriaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalMercadoria");
    		mercadoriaModalBean.pesquisarMercadoriaPorNome();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerPesquisarMercadoriaPorNome <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: validarPais
     * 
     * Propósito: Valida se pais tem restrição
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void validarRestricaoPais(AjaxBehaviorEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.validarPais <<<<<<<<<<<");
    		
    		Integer paramPais = SiteUtil.getInt(event.getComponent().getAttributes().get("paramPais"));
    		Integer cdPais = 0;
    		
    		if (paramPais == 1) {
    			cdPais = getTrdFinNegMercadoriaVO().getCpais();
    		} else {
    			cdPais = getTrdFinNegMercadoriaVO().getCpaisbnefc();
    		}
    		
    		ComboPaisVO pais = commonService.getDetalhesPais(cdPais);

            if ((!SiteUtil.isEmptyOrNull(pais.getCindcdlvgemdinhe()) && pais.getCindcdlvgemdinhe().equals("1")) 
                            || (!SiteUtil.isEmptyOrNull(pais.getCindcdprisofscal()) &&
                                            pais.getCindcdprisofscal().equals("1"))
                            || (!SiteUtil.isEmptyOrNull(pais.getCindcdriscoestrg()) &&
                                            pais.getCindcdriscoestrg().equals("1"))) {
                        NpcFacesUtils.addInfoModalMessage("País com restrição no cadastro.", false);
                    }
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.validarPais <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: selecionarMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @Deprecated
    //MOVIDO PARA BEAN GENERICO DE MERCADORIAS
    public String selecionarMercadoria() {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.selecionarMercadoria <<<<<<<<<<<");
    		
    		// valida se foi selecionado um item na lista
    		if (getViewHelper().getItemSelecListaMercadoria() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return null;
    		}
    		
    		// Apresenta dados da lista na tela
    		getTrdFinNegMercadoriaVO().setRmcadoopercmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
    						.getRmcadoopercmbio());
    		
    		// Salva os dados do Mercadoria para uso nos outros serviços
    		
    		getTrdFinNegMercadoriaVO().setCmcadoopercmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
    						.getCmcadoopercmbio());
    		getTrdFinNegMercadoriaVO().setNtpositcmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
    						.getNtpositcmbio());
    		getTrdFinNegMercadoriaVO().setCindcdlicenmcado(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
    						.getCindcdlicenmcado());
    		getTrdFinNegMercadoriaVO().setCmcadorestcmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
    						.getCmcadorestcmbio());
    		getTrdFinNegMercadoriaVO().setCunicpssoacmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
    						.getCunicpssoacmbio());
    		
    		if (getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo())) {
    			return "/content/comercializacao/precificacao/negociacao/tradeFinNegModalClose.xhtml";
    		}
    		return "/content/comercializacao/precificacao/negociacao/content/alteraModal/tradeFinNegModalClose.xhtml";

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.selecionarMercadoria <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: closeModalMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @Deprecated
    //MOVIDO PARA BEAN GENERICO DE MERCADORIAS
    public void closeModalMercadoria(ActionEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalMercadoria <<<<<<<<<<<");
    		
    		// ao fechar o modal limpa a lista
    		setListaSelMercadoria(new ArrayList<TradeFinNegocListasVO>());
    		
    		// desabilita modal
    		getViewHelper().setRenderModalMercadoria(Boolean.FALSE);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalMercadoria <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: getSelectItemRadioListaMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @Deprecated
    //MOVIDO PARA BEAN GENERICO DE MERCADORIAS
    public List<SelectItem> getSelectItemRadioListaMercadoria() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getSelectItemRadioListaMercadoria <<<<<<<<<<<");
    		
    		List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
    		
    		SiteUtil.atualizarSelectItem(getListaSelMercadoria(), selectItemRadioLista);
    		
    		return selectItemRadioLista;

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getSelectItemRadioListaMercadoria <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: paginarMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @Deprecated
    //MOVIDO PARA BEAN GENERICO DE MERCADORIAS
    public void paginarMercadoria(ActionEvent event) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.paginarMercadoria <<<<<<<<<<<");
    		
    		setListaSelMercadoria(getTradeFinanceNegociacaoService().getMercadoriasModalList(getTrdFinNegMercadoriaVO()));

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.paginarMercadoria <<<<<<<<<<<");
    	}
    	
    }
    
    /***************************************
     * FIM - Metodos do trecho Mercadorias *
     ***************************************/
    
    /**************************************************** 
     * Tela Modal Selecionar Beneficiário da Mercadoria *
     ****************************************************/

    /**
     * Nome: listenerPesquisarBeneficiarioPorNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarBeneficiarioPorNome(AjaxBehaviorEvent e) {
        
    	 try{
    	        getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerPesquisarBeneficiarioPorNome <<<<<<<<<<<");
    	        
    	        benefModalBean.setBeneficiario(getTrdFinNegMercadoriaVO());
    	        benefModalBean.getViewHelper().setNomeCampo("Beneficiário");
                benefModalBean.getViewHelper().setNomeStateIdListaSelBeneficiario("NPCDIAFG");
                benefModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalBeneficiario");
                benefModalBean.openModal();
    	    
    	    }finally{
    	        getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerPesquisarBeneficiarioPorNome <<<<<<<<<<<");
    	  }
    }

    /************************************
     * FIM - Beneficiário da Mercadoria *
     ************************************/
    
    /******************************************
     * Tela Modal Manutenção Comissao EXTERNA *
     ******************************************/

    /**
     * Nome: listenerIncluirComissaoExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirComissaoExterna(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirComissaoExterna <<<<<<<<<<<");
    		
    		TrdFinNegFluxoPagtoVO fluxoPagamentoVO = new TrdFinNegFluxoPagtoVO();
    		
    		if (getTradeFinNegocVO().getListaFluxos().size() <= Numeros.ZERO && temFluxoPagamento()) {
    			NpcFacesUtils.addInfoModalMessage("Fluxo de Pagamento não incluído.", false);
    			return;
    		}
    		comissaoExtManutModalBean.limpar(null);
    		comissaoExtManutModalBean.getViewHelper().setCindcdeconmmoeda(getTradeFinNegocVO().getCindcdeconmmoeda());
            comissaoExtManutModalBean.getViewHelper().setDisabledModalComissaoExt(Boolean.TRUE);
            comissaoExtManutModalBean.getViewHelper().setDisabledComboTipoComissaoExt(Boolean.FALSE);
            comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoExterna");
            comissaoExtManutModalBean.getViewHelper().setDisabledModalComissaoExt(Boolean.FALSE);
            comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Incluir");
            comissaoExtManutModalBean.getViewHelper().setCodProduto(getTradeFinNegocVO().getCprodtservc());
            comissaoExtManutModalBean.setListaComissaoExterna(getTradeFinNegocVO().getListaComissaoExterna());
            
            comissaoExtManutModalBean.getItemListaComissaoExterna().setCindcdeconmmoeda(getTradeFinNegocVO().getCindcdeconmmoeda());
            
            comissaoExtManutModalBean.getListaParcelasTemp().clear();
            
            if (getTradeFinNegocVO().getProduto().isGarantia()) {
                comissaoExtManutModalBean.getItemListaComissaoExterna().setDateComissao(getViewHelper().getDateVencFianc());
                comissaoExtManutModalBean.getItemListaComissaoExterna().setDataComissaoFormat(SiteUtil.dateToString(getViewHelper().getDateVencFianc(), "dd/MM/yyyy"));
                comissaoExtManutModalBean.getItemListaComissaoExterna().setTdiafinandsemb(getTradeFinNegocVO().getTdiaopercmbio());
                comissaoExtManutModalBean.getItemListaComissaoExterna().setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());
            }
            else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) 
                    || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                comissaoExtManutModalBean.getItemListaComissaoExterna().setDateComissao(new Date());
                comissaoExtManutModalBean.getItemListaComissaoExterna().setDataComissaoFormat(SiteUtil.dateToString(new Date(), "dd/MM/yyyy"));
                comissaoExtManutModalBean.getItemListaComissaoExterna().setTdiafinandsemb(getTradeFinNegocVO().getTdiaopercmbio());
                comissaoExtManutModalBean.getItemListaComissaoExterna().setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());
            }
            else {
            	fluxoPagamentoVO = getTradeFinNegocVO().getListaFluxos().get(Numeros.ZERO);
                comissaoExtManutModalBean.getItemListaComissaoExterna().setDateComissao(fluxoPagamentoVO.getDateFluxoPgto());
                comissaoExtManutModalBean.getItemListaComissaoExterna().setDataComissaoFormat(fluxoPagamentoVO.getDprevtdsembcmbio());
                comissaoExtManutModalBean.getItemListaComissaoExterna().setTdiafinandsemb(fluxoPagamentoVO.getTdiafinandsemb());
                comissaoExtManutModalBean.getItemListaComissaoExterna().setTdiaopercmbio(fluxoPagamentoVO.getTdiaopercmbio());
            }

            // Inclusão de comissão adicional
            comissaoExtManutModalBean.getItemListaComissaoExterna().setTipoComissao(EnumTipoComissao.ADICIONAL);
            
            comissaoExtManutModalBean.getItemListaComissaoExterna().setCpais(getTradeFinNegocVO().getCpais());
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setVprevtdsembcmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setVmincobrcomis("0,00");
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setCperdcjurocmbio(Numeros.UM);
    		comissaoExtManutModalBean.getViewHelper().setDisabledTxtParcelaComissaoExt(Boolean.TRUE);  
    		comissaoIntManutModalBean.getItemListaComissaoInterna().setCpais(getTradeFinNegocVO().getCpais());
    		
    		// parametro utilizado para carregar o combo de tipo de comissão
    		comissaoExtManutModalBean.getViewHelper().setTelaOrigem(Numeros.UM);
    		comissaoExtManutModalBean.getViewHelper().setDisabledValorTaxaQuandoIrregular(Boolean.FALSE);
    		
    		comissaoExtManutModalBean.setQtdeFluxoPgt(getTradeFinNegocVO().getListaFluxos().size());
    		comissaoExtManutModalBean.openModal(getTradeFinNegocVO().getCprodtservc());

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirComissaoExterna <<<<<<<<<<<");
    	}
        
    }
    
    /**
     * Nome: listenerIncluirComissaoExternaReduzida
     * 
     * Propósito: metodo criado apra atender a necessidade do produto LC e garantia (ambos nao possuem parcelas)
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirComissaoExternaReduzida(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirComissaoExternaReduzida <<<<<<<<<<<");
    		
    		if (!(getTradeFinNegocVO().getProduto().isGarantia() || getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) ) {
    			NpcFacesUtils.addInfoModalMessage("Metodo utilizado para Garantia e LC.", false);
    			return;
    		}
    		
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getTipoComissaoExterna())) {
                NpcFacesUtils.addInfoModalMessage("O campo Tipo é obrigatório.", EnumButtonBehavior.SUBMIT);
                return ;
            }
    		
    		if ((getViewHelper().getCobrancaComissaoExterna().equals(Numeros.NUM2)
                    || getViewHelper().getCobrancaComissaoExterna().equals(Numeros.NUM3))
                    && SiteUtil.isValueZero(getViewHelper().getTaxaComissaoExterna())) {
                
                NpcFacesUtils.addInfoModalMessage("O campo Taxa é obrigatório.", EnumButtonBehavior.SUBMIT);
                return ;
            } 
            
            else if(getViewHelper().getCobrancaComissaoExterna().equals(Numeros.NUM1) 
                    && SiteUtil.isEmptyOrNull(getViewHelper().getValorComissaoExterna())) {
                
                NpcFacesUtils.addInfoModalMessage("O campo Valor é obrigatório.", EnumButtonBehavior.SUBMIT);
                return ;
            }
    	
        	if (getViewHelper().getCfluxoperdccmbioRed().equals(Numeros.ZERO)) {
        		
                NpcFacesUtils.addInfoModalMessage("Selecione uma periodicidade.", false);
                return ;
                
        	}
    		
    		TrdFinNegComissaoVO trdFinNegComissaoVO = new TrdFinNegComissaoVO();
 			
    		trdFinNegComissaoVO.setCcondceconc(getViewHelper().getTipoComissaoExterna());
 			trdFinNegComissaoVO.setCperdcjurocmbio(getViewHelper().getCobrancaComissaoExterna());
 			trdFinNegComissaoVO.setVlxtotalcomis(getViewHelper().getValorComissaoExterna());
 			trdFinNegComissaoVO.setVprevtcomiscmbio(getViewHelper().getValorComissaoExterna());
 			trdFinNegComissaoVO.setPjuronegoccmbio(getViewHelper().getTaxaComissaoExterna());
 			trdFinNegComissaoVO.setCindcdeconmmoeda(getViewHelper().getMoedaComissaoExterna());
 			trdFinNegComissaoVO.setPcomisnegoccmbio(getViewHelper().getTaxaComissaoExterna());
    		
    		Integer codInteger = 0;
            String descrCombo = null;
            
            codInteger = trdFinNegComissaoVO.getCcondceconc();
            for (int i = 0; i < viewHelper.getComboTipoComissao().size(); i++) {
                if (viewHelper.getComboTipoComissao().get(i).getValue().equals(codInteger)) {
                    descrCombo = viewHelper.getComboTipoComissao().get(i).getLabel();
                    break;
                }
            }
            trdFinNegComissaoVO.setTipoComissaoExt(descrCombo);

            codInteger = trdFinNegComissaoVO.getCperdcjurocmbio();
            for (int i = 0; i < viewHelper.getComboPeriodoDaTaxa().size(); i++) {
                if (viewHelper.getComboPeriodoDaTaxa().get(i).getValue().equals(codInteger)) {
                    descrCombo = viewHelper.getComboPeriodoDaTaxa().get(i).getLabel();
                    break;
                }
            }
            trdFinNegComissaoVO.setPeriodoTaxa(descrCombo);

            codInteger = trdFinNegComissaoVO.getCindcdeconmmoeda();
            for (int i = 0; i < viewHelper.getComboMoedaDesembolso().size(); i++) {
                if (viewHelper.getComboMoedaDesembolso().get(i).getValue().equals(codInteger)) {
                    descrCombo = viewHelper.getComboMoedaDesembolso().get(i).getLabel();
                    break;
                }
            }
            
            trdFinNegComissaoVO.setMoedaComissao(descrCombo);
            
            TrdFinNegComissaoVO dadosCalcComissao = new TrdFinNegComissaoVO();
            
            if(getViewHelper().getCobrancaComissaoExterna() == 0){
            	getViewHelper().setCobrancaComissaoExterna(1);
            }
            
            if (getViewHelper().getCobrancaComissaoExterna() == 1) {
                dadosCalcComissao.setCcobrcomiscmbio(1); // Valor
                /* VALOR DE COMISSAO */
                dadosCalcComissao.setVlxcomiscmbio(getViewHelper().getValorComissaoExterna());
                dadosCalcComissao.setPjuronegoccmbio("000,00000");
                
            } else if (getViewHelper().getCobrancaComissaoExterna() == 2 || getViewHelper().getCobrancaComissaoExterna() == 3) {
                dadosCalcComissao.setCcobrcomiscmbio(getViewHelper().getCobrancaComissaoExterna()); // Flat ou A.A
                /* PERCENTUAL FLAT DE COMISSAO */
                dadosCalcComissao.setPjuronegoccmbio(getViewHelper().getTaxaComissaoExterna());
                dadosCalcComissao.setVlxcomiscmbio("0,00");  
            } 
        	
        	dadosCalcComissao.setVlxcomiscmbio(getViewHelper().getValorComissaoExterna());
        	dadosCalcComissao.setCindcdeconmmoeda(getViewHelper().getMoedaComissaoExterna());
        	dadosCalcComissao.setVlxoperaccmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
        	dadosCalcComissao.setPrzoperaccmbio(getTradeFinNegocVO().getTdiaopercmbio());
        	
        	dadosCalcComissao.setCindcdnegoccarta("N");
        	dadosCalcComissao.setCcomiscartanacio("N");
        	dadosCalcComissao.setCindcdnegocswap("N");
        	dadosCalcComissao.setVtravaliborcmbio("0");
        	dadosCalcComissao.setPtxcustoexter("0");
        	dadosCalcComissao.setPtximpstrenda("0");
        	dadosCalcComissao.setCprodtservc(getTradeFinNegocVO().getCprodtservc());
        	           
            /* PESQUISA VALOR TOTAL DA COMISSÃO PARA AGENTE FINANCEIRO / CALCULA O VALOR */
            if (!SiteUtil.isEmptyOrNull(dadosCalcComissao.getCcobrcomiscmbio())) {
               
                setItemListaComissaoExterna(getTradeFinanceNegociacaoService().getSpreadNegociado(
                        dadosCalcComissao, 
                        new ArrayList<TrdFinNegComissaoVO>(),
                        getTradeFinNegocVO().getListaComissaoExterna(), 
                        getViewHelper().getPrzomediooperd(), 
                        getTradeFinNegocVO().getDadosPrecificacao().getCustoext()));
            }
            
            trdFinNegComissaoVO.setVtxspreadnegoc(getItemListaComissaoExterna().getVtxspreadnegoc());
            trdFinNegComissaoVO.setPtxflatpnalt(getItemListaComissaoExterna().getPtxflatpnalt());
            trdFinNegComissaoVO.setVlxtotalcomis(getItemListaComissaoExterna().getVlxtotalcomis());
            trdFinNegComissaoVO.setVtxspreadtot(getItemListaComissaoExterna().getVtxspreadtot());
            trdFinNegComissaoVO.setVprevtcomiscmbio(getItemListaComissaoExterna().getVlxtotalcomis());
            trdFinNegComissaoVO.setPcomisnegoccmbio(getViewHelper().getTaxaComissaoExterna());
            trdFinNegComissaoVO.setCfluxoperdccmbio(getViewHelper().getCfluxoperdccmbioRed());
            trdFinNegComissaoVO.setCodMomentoComissao(getViewHelper().getCodMomentoComissaoRed());
            
            codInteger = getViewHelper().getCfluxoperdccmbioRed();
            for (int i = 0; i < viewHelper.getComboPeriodicidade().size(); i++) {
                if (viewHelper.getComboPeriodicidade().get(i).getValue().equals(codInteger)) {
                    descrCombo = viewHelper.getComboPeriodicidade().get(i).getLabel();
                    break;
                }
            }                      
            trdFinNegComissaoVO.setPeriodicidadeComissao(descrCombo);
            
            codInteger = getViewHelper().getCodMomentoComissaoRed();
            for (int i = 0; i < viewHelper.getComboMomento().size(); i++) {
                if (viewHelper.getComboMomento().get(i).getValue().equals(codInteger)) {
                    descrCombo = viewHelper.getComboMomento().get(i).getLabel();
                    break;
                }
            }
            
            trdFinNegComissaoVO.setMomentoComissao(descrCombo);
            trdFinNegComissaoVO.setTipoComissao(EnumTipoComissao.ADICIONAL);            
            
    		getTradeFinNegocVO().getListaComissaoExterna().add(trdFinNegComissaoVO);
    		
    		getViewHelper().setTipoComissaoExterna(0);
    		getViewHelper().setCobrancaComissaoExterna(Numeros.NUM1);
    		getViewHelper().setValorComissaoExterna("");
    		getViewHelper().setTaxaComissaoExterna("");
    		getViewHelper().setMoedaComissaoExterna(EnumTradeFinance.MOEDA_USD.getCodigo());
    		getViewHelper().setCfluxoperdccmbioRed(Numeros.ZERO);
    		getViewHelper().setCodMomentoComissaoRed(Numeros.ZERO);
 		     
    		disableValorTaxa();
 		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirComissaoExternaReduzida <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: listenerAlterarComissaoExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerAlterarComissaoExterna(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerAlterarComissaoExterna <<<<<<<<<<<");

    		int itemSel = 0;
    		
    		TrdFinNegComissaoVO itemComissaoExterna = new TrdFinNegComissaoVO();
    		
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaComissaoExterna())) {    			
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		} else {    		 
    		
        		itemSel = SiteUtil.getInt(getViewHelper().getItemSelecListaComissaoExterna());
        		
        		TrdFinNegComissaoVO itemComissaoExternaAlt = new TrdFinNegComissaoVO();
        		itemComissaoExternaAlt = (TrdFinNegComissaoVO) getTradeFinNegocVO().getListaComissaoExterna().get(itemSel, EnumTipoComissao.ADICIONAL);
        		
        		itemComissaoExterna.setCcondceconc(itemComissaoExternaAlt.getCcondceconc());
        		itemComissaoExterna.setCperdcjurocmbio(itemComissaoExternaAlt.getCperdcjurocmbio());
        		itemComissaoExterna.setCindcdeconmmoeda(itemComissaoExternaAlt.getCindcdeconmmoeda());
        		itemComissaoExterna.setCfluxoperdccmbio(itemComissaoExternaAlt.getCfluxoperdccmbio());
        		itemComissaoExterna.setTipoComissaoExt(itemComissaoExternaAlt.getTipoComissaoExt());
        		itemComissaoExterna.setVprevtcomiscmbio(itemComissaoExternaAlt.getVprevtcomiscmbio());
        		itemComissaoExterna.setPjuronegoccmbio(itemComissaoExternaAlt.getPjuronegoccmbio());
        		itemComissaoExterna.setPeriodoTaxa(itemComissaoExternaAlt.getPeriodoTaxa());
        		itemComissaoExterna.setMoedaComissao(itemComissaoExternaAlt.getMoedaComissao());
        		itemComissaoExterna.setPeriodicidadeComissao(itemComissaoExternaAlt.getPeriodicidadeComissao());
        		itemComissaoExterna.setCodMomentoComissao(itemComissaoExternaAlt.getCodMomentoComissao());
        		itemComissaoExterna.setQpcelacmbiotrade(itemComissaoExternaAlt.getQpcelacmbiotrade());
        		itemComissaoExterna.setListaParcelasComissao(itemComissaoExternaAlt.getListaParcelasComissao());
        		
        		itemComissaoExterna.setTipoComissao(itemComissaoExternaAlt.getTipoComissao());
        		
        		// VERIFICAR
        		if (getTradeFinNegocVO().getProduto().isGarantia()) {
                    itemComissaoExterna.setDateComissao(getViewHelper().getDateVencFianc());
                    itemComissaoExterna.setDataComissaoFormat(SiteUtil.dateToString(getViewHelper().getDateVencFianc(), "dd/MM/yyyy"));
                    itemComissaoExterna.setTdiafinandsemb(getTradeFinNegocVO().getTdiaopercmbio());
                    itemComissaoExterna.setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());
                }
                else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) 
                        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                    itemComissaoExterna.setDateComissao(new Date());
                    itemComissaoExterna.setDataComissaoFormat(SiteUtil.dateToString(new Date(), "dd/MM/yyyy"));
                    itemComissaoExterna.setTdiafinandsemb(getTradeFinNegocVO().getTdiaopercmbio());
                    itemComissaoExterna.setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());
                }
                else {
                    TrdFinNegFluxoPagtoVO fluxoPagamentoVO = getTradeFinNegocVO().getListaFluxos().get(Numeros.ZERO);
                    itemComissaoExterna.setDateComissao(fluxoPagamentoVO.getDateFluxoPgto());
                    itemComissaoExterna.setDataComissaoFormat(fluxoPagamentoVO.getDprevtdsembcmbio());
                    itemComissaoExterna.setTdiafinandsemb(fluxoPagamentoVO.getTdiafinandsemb());
                    itemComissaoExterna.setTdiaopercmbio(fluxoPagamentoVO.getTdiaopercmbio());
                }
        		
        		itemComissaoExterna.setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());
        		itemComissaoExterna.setVprevtdsembcmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
        		itemComissaoExterna.setVmincobrcomis("0,00");
        		itemComissaoExterna.setVlxtotalcomis(itemComissaoExternaAlt.getVlxtotalcomis());
        		itemComissaoExterna.setCpais(getTradeFinNegocVO().getCpais());
        		
        		comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Alterar");
        		comissaoExtManutModalBean.getViewHelper().setLinhaSelecionada(getViewHelper().getItemSelecListaComissaoExterna());
        		comissaoExtManutModalBean.setQtdeFluxoPgt(getTradeFinNegocVO().getListaFluxos().size());
        		comissaoExtManutModalBean.setListaComissaoExterna(getTradeFinNegocVO().getListaComissaoExterna());
        		comissaoExtManutModalBean.setItemListaComissaoExterna(itemComissaoExterna);   
        		comissaoExtManutModalBean.setListaParcelasTemp(new ArrayList<TrdFinNegParcelaVO>(itemComissaoExternaAlt.getListaParcelasComissao()));
        		
        		comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoExterna");
        		comissaoExtManutModalBean.getViewHelper().setDisabledModalComissaoExt(Boolean.FALSE);
        		comissaoExtManutModalBean.getViewHelper().setDisabledComboTipoComissaoExt(Boolean.TRUE);
        		comissaoExtManutModalBean.getViewHelper().setDisabledTxtParcelaComissaoExt(Boolean.TRUE);
        		
        		if(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo().equals(itemComissaoExternaAlt.getCfluxoperdccmbio())){
        			comissaoExtManutModalBean.getViewHelper().setDisabledValorTaxaQuandoIrregular(Boolean.TRUE);
        		}
        		
        		// parametro utilizado para carregar o combo de tipo de comissão
        		comissaoExtManutModalBean.getViewHelper().setTelaOrigem(Numeros.UM);
        		
        		comissaoExtManutModalBean.openModal(getTradeFinNegocVO().getCprodtservc());
    		}
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerAlterarComissaoExterna <<<<<<<<<<<");
    	}
    	
        
    }

    /**
     * Nome: listenerExcluirComissaoExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerExcluirComissaoExterna(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirComissaoExterna <<<<<<<<<<<");

    		comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Excluir");
    		comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoExterna");
    		detalharComissaoExterna(EnumTipoComissao.ADICIONAL);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirComissaoExterna <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
     * Nome: closeModal
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 20/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void closeModalComissaoExterna(ActionEvent event) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalComissaoExterna <<<<<<<<<<<");
            
            if (comissaoExtManutModalBean.getConfirmarManutencao()) {
                
                if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                    calcCustoTotalForfaiting();
                } else {
                    calcularValoresSpreadFlatCustoTotalComissaoInt();
                }
            }
            
            comissaoExtManutModalBean.closeModal(event);
             
        }finally{
             BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalComissaoExterna <<<<<<<<<<<");
        }
        
    }
    
    /**
     * Nome: listenerExcluirComissaoExternaReduzida
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerExcluirComissaoExternaReduzida(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirComissaoExternaReduzida <<<<<<<<<<<");
    		
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaComissaoExterna())) {    			
    		    NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    		    return;
    		} else {
                getTradeFinNegocVO().getListaComissaoExterna()
                        .remove(SiteUtil.getInt(getViewHelper().getItemSelecListaComissaoExterna()),
                                EnumTipoComissao.ADICIONAL);
    		}
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirComissaoExternaReduzida <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: listenerDetalharComissaoExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerDetalharComissaoExterna(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerDetalharComissaoExterna <<<<<<<<<<<");

    		comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Detalhar");
    		comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoExterna");
    		detalharComissaoExterna(EnumTipoComissao.ADICIONAL);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerDetalharComissaoExterna <<<<<<<<<<<");
    	}
    }
    
    /**
     * Nome: listenerDetalharComissaoBanqueiro
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerDetalharComissaoBanqueiro(AjaxBehaviorEvent e) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerDetalharComissaoBanqueiro <<<<<<<<<<<");

            comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Detalhar");
            comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoBanqueiro");
            detalharComissaoExterna(EnumTipoComissao.BANQUEIRO);
            
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerDetalharComissaoBanqueiro <<<<<<<<<<<");
        }
    }

    /**
     * Nome: detalharComissaoExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void detalharComissaoExterna(EnumTipoComissao tipoComissao) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.detalharComissaoExterna <<<<<<<<<<<");

 
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaComissaoExterna()) 
    		        && SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaComissaoBanqueiro())) {    			
    		    NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    		    return;
    		} else {
    		    
    		    int itemSel = -1;
    		    
    		    if(tipoComissao.equals(EnumTipoComissao.ADICIONAL)) {
    		        itemSel =SiteUtil.getInt(getViewHelper().getItemSelecListaComissaoExterna());
    		    } else {
    		        itemSel =SiteUtil.getInt(getViewHelper().getItemSelecListaComissaoBanqueiro());
    		    }
                TrdFinNegComissaoVO itemComissaoExterna = (TrdFinNegComissaoVO)getTradeFinNegocVO().getListaComissaoExterna().get(itemSel, tipoComissao);
    		    
    		    comissaoExtManutModalBean.setItemListaComissaoExterna(itemComissaoExterna);
    		    comissaoExtManutModalBean.setListaComissaoExterna(getTradeFinNegocVO().getListaComissaoExterna());
    		    comissaoExtManutModalBean.setListaParcelasTemp(new ArrayList<TrdFinNegParcelaVO>(itemComissaoExterna.getListaParcelasComissao()));
    		    
    		    comissaoExtManutModalBean.getViewHelper().setLinhaSelecionada(SiteUtil.getString(itemSel));
    		    comissaoExtManutModalBean.getViewHelper().setDisabledTxtParcelaComissaoExt(Boolean.TRUE);
    		    comissaoExtManutModalBean.getViewHelper().setDisabledModalComissaoExt(Boolean.TRUE);
    		    
    		    // parametro utilizado para carregar o combo de tipo de comissão
    		    comissaoExtManutModalBean.getViewHelper().setTelaOrigem(Numeros.UM);
    		    
    		    comissaoExtManutModalBean.openModal(getTradeFinNegocVO().getCprodtservc());
    		}
    		
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.detalharComissaoExterna <<<<<<<<<<<");
    	}

    }

    
    /**************************
     * FIM - COMISSAO EXTERNA *
     **************************/  

    /**************************
     * INICIO - AUTORIZAÇÃO DSN e COTARCUSTOEXTERNO *
     **************************/  
    	/**
    	* Nome: abrirModalMotivoAutorizacaoDsn
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 21/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    protected void abrirModalMotivoAutorizacaoDsn() {
    
        custoExtAutoDsnModalBean.getViewHelper().setHeaderMotivo("Deseja confirmar Autorização DSN?");
        custoExtAutoDsnModalBean.getViewHelper().setLabelMotivo("Motivo da Solicitação da Autorização DSN");
        custoExtAutoDsnModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalMotivo");
        custoExtAutoDsnModalBean.getViewHelper().setTelaOrigem(EnumTradeFinance.ACESSO_AUTORIZA_DSN.getCodigo());
        
        getTradeFinNegocVO().setMotivo(SiteUtil.STRING_EMPTY);
        custoExtAutoDsnModalBean.setTradeFinNegocVO(getTradeFinNegocVO());
        
        custoExtAutoDsnModalBean.openModal(null);
    }
    
    /**
    * Nome: abrirModalMotivoCotarCustoExterno
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 03/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    protected void abrirModalMotivoCotarCustoExterno() {
    
        custoExtAutoDsnModalBean.getViewHelper().setHeaderMotivo("Deseja confirmar Cotar Custo Externo?");
        custoExtAutoDsnModalBean.getViewHelper().setLabelMotivo("Motivo");
        custoExtAutoDsnModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalMotivo");
        custoExtAutoDsnModalBean.getViewHelper().setTelaOrigem(EnumTradeFinance.ACESSO_COTAR_CUSTO_EXTERNO.getCodigo());
        
        getTradeFinNegocVO().setMotivo(SiteUtil.STRING_EMPTY);
        custoExtAutoDsnModalBean.setTradeFinNegocVO(tradeFinNegocVO);
        
        custoExtAutoDsnModalBean.openModal(null);
    }

    /**
    * Nome: closeModalCutoExtAutDsn
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 03/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void closeModalCutoExtAutDsn(ActionEvent event) {
        
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.closeModalCutoExtAutDsn <<<<<<<<<<<");

    		custoExtAutoDsnModalBean.closeModal(event);
    		
    		// botão Confirmar
    		if (custoExtAutoDsnModalBean.getViewHelper().getBotaoAcionado().equals(CustoExtAutoDsnModalBean.BTN_CONFIRMAR)) {
    		    
    		    /* Condição para abrir modal de desenquadradas: 
                        Tipo Cotação = Firme; 
                        Limite de Crédito selecionado; 
                        Retorno 'S' do fluxo de desenquadradas; 
                        
                   AUTORIZAÇÃO DSN não deve abrir o modal de desenquadradas.     
                */
                if (EnumTradeFinance.ACESSO_AUTORIZA_DSN.getCodigo() == custoExtAutoDsnModalBean.getViewHelper().getTelaOrigem() 
                        || !openModalDesenquadradas(custoExtAutoDsnModalBean.getViewHelper().getTelaOrigem())) {
                    
                    if(validarFluxoConfirmar(custoExtAutoDsnModalBean.getViewHelper().getTelaOrigem())) {
                        setControleInclusaoAlteracao("DadosBasicos");
                        continuarConfirmar();
                    }
                }    			
    		}        
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.closeModalCutoExtAutDsn <<<<<<<<<<<");
    	}
    	
    }
    
    public abstract void continuarConfirmar();
    
    protected boolean validarFluxoConfirmar(int tipoAcessoAlterarEvento) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.validarFluxoConfirmar <<<<<<<<<<<");

    		Integer tipoAcesso = null;
    		String msgRetorno = null;
    		
    		// Se botão selecionado for o 'Fechar' da tela de alteração
    		if(tipoAcessoAlterarEvento == EnumTradeFinance.ACESSO_FECHAR.getCodigo()) {
    		    tipoAcesso = EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo();
    		}
    		
    		// Se botão selecionado for o 'Confirmar' da tela de divergente
            else if(tipoAcessoAlterarEvento == EnumTradeFinance.ACESSO_CONFIRMAR_DIVERGENTE.getCodigo()) {
                tipoAcesso = EnumTradeFinance.ACESSO_CONFIRMAR_DIVERGENTE.getCodigo();
            }
    		
    		// Se botão selecionado for o 'Cotar Custo Externo'
            else if(tipoAcessoAlterarEvento == EnumTradeFinance.ACESSO_COTAR_CUSTO_EXTERNO.getCodigo()) {
                tipoAcesso = EnumTradeFinance.ACESSO_COTAR_CUSTO_EXTERNO.getCodigo();
            }
    		
    		// Se botão selecionado for o 'Autorização DSN'
            else if(tipoAcessoAlterarEvento == EnumTradeFinance.ACESSO_AUTORIZA_DSN.getCodigo()) {
                tipoAcesso = EnumTradeFinance.ACESSO_AUTORIZA_DSN.getCodigo();
            }
    		
    		// Se botão selecionado for o 'Gerar Boleto' da tela de alteração. (Inclusão não passa aqui)
            else if(tipoAcessoAlterarEvento == EnumTradeFinance.ACESSO_GERAR_BOLETO.getCodigo()) {
                tipoAcesso = EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo();
            }
    		
    		// Se botão selecionado for o 'Confirmar' da inclusão ou alteração
    		else {
    		    
    		    tipoAcesso = tipoAcessoAlterarEvento;
    		    
    		}
    		
    		getTradeFinNegocVO().setDvalddnegoccmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteCotacao()));
    		msgRetorno = validarFluxo(tipoAcesso);
    		
    		if (msgRetorno != null && msgRetorno.length() > Numeros.ZERO) {
                viewHelper.setTipoAcesso(tipoAcesso);
                viewHelper.setMensagemFluxoValidacao(msgRetorno);
            } 

    		return true;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.validarFluxoConfirmar <<<<<<<<<<<");
    	}
        
    }

    /**
    * Nome: validarFluxo
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 03/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public String validarFluxo(Integer tipoAcesso) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.validarFluxo <<<<<<<<<<<");

    		String msgRetorno = null;
    		
            // VALIDAÇÃO PARA OS PRODUTOS DO BNDES (PRE E POS)
    		if(getTradeFinNegocVO().getProduto().isBndesPos() || getTradeFinNegocVO().getProduto().isBndesPre()){
    		
    			getTradeFinNegocVO().getPrevDesembolsoVO().setQpcelatradeprinc(getTradeFinanceNegociacaoService().fluxoValidacaoPagamento(getTradeFinNegocVO())); 
    		}
    		
    		// Aciona o Fluxo: NPCCIAPH
			msgRetorno = getTradeFinanceNegociacaoService().fluxoValidacao(getTradeFinNegocVO(),
						getTrdFinNegPrecificacaoVO(),
						tipoAcesso,
						listaDesembolso);
    		
    		
    		return msgRetorno;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.validarFluxo <<<<<<<<<<<");
    	}
        
    }

    /**************************
     * FIM - AUTORIZAÇÃO DSN e COTARCUSTOEXTERNO *
     **************************/  
    
    /**
    * Nome: validarNegocioCotacao
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 20/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    protected Boolean validarNegocioCotacao(int tipoAcessoAlterarEvento) {
        Boolean isValid = Boolean.TRUE;
        
        int codSimNaoSwap = Numeros.ZERO;
        
        if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getQprzmedcmbio())){
        	getTradeFinNegocVO().setQprzmedcmbio(getViewHelper().getPrzomediooperd());
        }
        codSimNaoSwap = Integer.valueOf(getTradeFinNegocVO().getCindcdnegocswap());
        
        if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) || "0,00".equals(getTradeFinNegocVO().getVnegocmoedaestrg())){
        	NpcFacesUtils.addInfoModalMessage("O campo Valor ME é obrigatório.", false);
            isValid = Boolean.FALSE;
        }
        
        if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getObsCotacaoVO().getNomecttclicmbio())
        		&& SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getObsCotacaoVO().getTelcttclicmbio())){

            NpcFacesUtils.addInfoModalMessage("O campo Telefone é obrigatório.", false);
            isValid = Boolean.FALSE;
            
        }
        
        if(getTradeFinNegocVO().getTdiaopercmbio() == Numeros.ZERO){
            NpcFacesUtils.addInfoModalMessage("Prazo Total da Operação Inválido.", false);
            isValid = Boolean.FALSE;
        }
        
        if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getObsCotacaoVO().getNomecttclicmbio())
        		&& !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getObsCotacaoVO().getTelcttclicmbio())){
        	
        	NpcFacesUtils.addInfoModalMessage("O campo Contato é obrigatório.", false);
        	isValid = Boolean.FALSE;
        	
        }
        
        if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getObsCotacaoVO().getTelcttclicmbio())
        		&& getTradeFinNegocVO().getObsCotacaoVO().getTelcttclicmbio().length() < 14){
        	
        	NpcFacesUtils.addInfoModalMessage("O campo Telefone inválido.", false);
            isValid = Boolean.FALSE;
            
        }
        // Data 'Limite Cotação' é obrigatório e tem que ser maior que a data atual
        if (getViewHelper().getDataLimiteCotacao() == null) {
            
            NpcFacesUtils.addInfoModalMessage("O campo Limite Cotação é obrigatório.", false);
            isValid = Boolean.FALSE;
        } 
        
        // Data Limite Cotação não pode ser menor que a data atual
        else if (SiteUtil.comparaDatas(getViewHelper().getDataLimiteCotacao(), new Date()) < 0) {
            NpcFacesUtils.addInfoModalMessage("Data Limite Cotação não pode ser menor que a data atual.", false);
            isValid = Boolean.FALSE;
        }
        
		Integer Cpaisbnefc = Numeros.ZERO;

		if (getTradeFinNegocVO().getListaMercadoria().size() > 0) {
			Cpaisbnefc = getTradeFinNegocVO().getListaMercadoria().get(Numeros.ZERO).getCpaisbnefc();
		
    		TrdFinNegFluxoPagtoVO itemFluxo = null;
    		
            // Data Limite Cotação é válida
    		if(tradeFinNegocVO.getListaFluxos().size() > 0){			
    			for (Iterator<TrdFinNegFluxoPagtoVO> iterator = tradeFinNegocVO.getListaFluxos().iterator(); iterator.hasNext();) {
    				itemFluxo = (TrdFinNegFluxoPagtoVO) iterator.next();
    				
    		        if (!commonService.validarDiaUtil(itemFluxo.getDateFluxoPgto(), 0, "1", 0, Cpaisbnefc, getTradeFinNegocVO().getCeconmmoedadsemb())) {
    		            NpcFacesUtils.addInfoModalMessage("Previsão de desembolso em dia não útil no país do beneficiário. Favor recalcular os fluxos!!!", false);
    		            isValid = Boolean.FALSE;
    		        }
    			}				
    		}
        }

        
        //Data 'Embarque até' obrigtório para produto LC
        if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)){
            // Data 'Embarque até' é obrigatório e tem que ser maior que a data atual
            if (getViewHelper().getDataLimiteEmbarque() == null) {
                
                NpcFacesUtils.addInfoModalMessage("O campo \"Embarque até\" é obrigatório.", false);
                isValid = Boolean.FALSE;
            } 
            
        }
        
        // Modalidade é obrigatório para todos os produtos
        if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCmodldprodtcmbio())) {
            NpcFacesUtils.addInfoModalMessage("O campo Modalidade é obrigatório.", false);
            isValid = Boolean.FALSE;
        }
        
        if (codSimNaoSwap == EnumSimNao.SIM.getCodigo() && getTradeFinNegocVO().isCindcdnegoclibor() == true
                        && !getTradeFinNegocVO().getProduto().isNce()) {
            if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVtravaliborcmbio()) == true ||
                            getTradeFinNegocVO().getVtravaliborcmbio().equals("0,00000")) {
                NpcFacesUtils.addInfoModalMessage("O campo Libor Travada é obrigatório.", false);
                isValid = Boolean.FALSE;
            }
        } 
        
        if ((codSimNaoSwap == EnumSimNao.SIM.getCodigo() && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getPtxswapcmpdo()))
                        || (getTradeFinNegocVO().isCnegocswapestrg() && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getPtxswapcmpdo()))) {
            NpcFacesUtils.addInfoModalMessage("O campo Spread All-In é obrigatório.", false);
            isValid = Boolean.FALSE;
        }
        
        
        // Se foi o campo SWAP foi sinalizado como Sim, 
        // foi sinalizado ME/MN como Sim e 
        // não foi selecionado o PTAX, avisar o operador.  
		if ((getTradeFinNegocVO().getCtpocotactx() == Numeros.ZERO) &&
			(codSimNaoSwap == EnumSimNao.SIM.getCodigo()) && 
			(getTradeFinNegocVO().isCnegocswapestrg())) {
            
			NpcFacesUtils.addInfoModalMessage("O campo PTAX é obrigatório.", false);
            isValid = Boolean.FALSE;
				
		}
        
        // Valida campos obrigatórios por produto
        isValid &= validarCamposObrigatoriosPorProduto(getTradeFinNegocVO().getProduto(), tipoAcessoAlterarEvento);
        
        // Fluxo de pagamento obrigatório se não for 
        // BNDES Pós, BNDES Pré, Garantia Internacional Expedida ou LC Importação, Forfaiting 
        if (temFluxoPagamento()) {
        	
            isValid &= validarDataPrevisaoDesembolso();
            
            if (getTradeFinNegocVO().getListaFluxos() == null || 
                    getTradeFinNegocVO().getListaFluxos().size() <= Numeros.ZERO ) {
                
                NpcFacesUtils.addInfoModalMessage("Lista Fluxo Pagamento vazia.", false);
                isValid = Boolean.FALSE;
            }
        	
        }
        
         // Comissão Interna LC e Garantias
        if(getTradeFinNegocVO().getProduto().isGarantia() || getTradeFinNegocVO().getProduto().getCodigo().equals(EnumProduto.LC_IMPORTACAO.getCodigo())){
        	
        	if (SiteUtil.isEmptyOrNull(getViewHelper().getValueComissaoCobranca()) || SiteUtil.isValueZero(getViewHelper().getValueComissaoCobranca())) {
        		
                NpcFacesUtils.addInfoModalMessage("O valor da comissão interna é obrigatório.", false);
                isValid = Boolean.FALSE;
                
        	}   	
        	
        	if (getViewHelper().getCodMoedaComissao().equals(Numeros.ZERO)) {
        		
                NpcFacesUtils.addInfoModalMessage("Selecione uma moeda da comissão interna.", false);
                isValid = Boolean.FALSE;
                
        	}
        	
        	if (getViewHelper().getCfluxoperdccmbio().equals(Numeros.ZERO)) {
        		
                NpcFacesUtils.addInfoModalMessage("Selecione uma periodicidade da comissão interna.", false);
                isValid = Boolean.FALSE;
                
        	}
        	
        }

        // Comissão Interna (Spread) obrigatório se não for BNDES Pós, BNDES Pré ou N.C.E
        if(temFluxoPagamento() && !getTradeFinNegocVO().getProduto().isNce()) {
            if (getTradeFinNegocVO().getListaComissaoInterna().size() <= Numeros.ZERO  && getTradeFinNegocVO().getCcomiscartanacio().equals("1")) {
                NpcFacesUtils.addInfoModalMessage("Lista Comissão Interna (Spread) vazia.", false);
                isValid = Boolean.FALSE;
            } else if (getTradeFinNegocVO().getListaComissaoInterna().size() <= Numeros.ZERO  && getTradeFinNegocVO().getCcomiscartanacio().equals("2")) {
                NpcFacesUtils.addInfoModalMessage("O cálculo da Comissão Interna (Spread) é obrigatório.", false);
                isValid = Boolean.FALSE;
			}         
        }
        
        //valida se existir cotacao vinculada se ela nao ultrapassa o valor ME
        if(getTradeFinNegocVO().getListaOperacaoVinculada() != null && getTradeFinNegocVO().getListaOperacaoVinculada().size()>0){
        	BigDecimal totalOperacaoVinculada = new BigDecimal(0);
        	for (TrdFinNegOperVincVO operacaoVinculada : getTradeFinNegocVO().getListaOperacaoVinculada()) {
        		
        		try{
        			String valorCotacaoVinc = operacaoVinculada.getValorMoeda();
        			if(valorCotacaoVinc.contains(",")){
        				valorCotacaoVinc = valorCotacaoVinc.replaceAll("\\.", "");
        				valorCotacaoVinc = valorCotacaoVinc.replaceAll(",", ".");
        			}
        			totalOperacaoVinculada = totalOperacaoVinculada.add(new BigDecimal(valorCotacaoVinc));
        		}catch (Exception e){
        			NpcFacesUtils.addInfoModalMessage("Impossivel converter o valor da operacao vinculada", false);
        			isValid = Boolean.FALSE;
        		}
        	}
        	
        	String valorME = getTradeFinNegocVO().getVnegocmoedaestrg();
        	valorME = valorME.replaceAll("\\.", "");
        	valorME = valorME.replaceAll(",", ".");
        	if(new BigDecimal(valorME).compareTo(totalOperacaoVinculada) < 0){
        		NpcFacesUtils.addInfoModalMessage("Valor do Financiamento Menor que Operação Vinculada", false);
        		isValid = Boolean.FALSE;
        	}
        }
        
        // Valida o Indeterminado e o Vencimento Fianca ( Garantia Int Exp)
        if(getTradeFinNegocVO().getProduto().isGarantia()) {

            if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDprevtgarntexpdi())) {


                if((viewHelper.isIndeterminado() == Boolean.FALSE && (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDprevtgarntexpdi()) && SiteUtil.isEmptyOrNull(viewHelper.getDateVencFianc()))) 
                                || (viewHelper.isIndeterminado() == Boolean.TRUE && !SiteUtil.isEmptyOrNull(viewHelper.getDateVencFianc()))) {

                    NpcFacesUtils.addInfoModalMessage("Preenchimento incorreto. Preencha apenas ou a data Vencimento fiança ou clique na opção indeterminado.", false);
                    isValid = Boolean.FALSE;

                }
            }

        }

        // Comissão Interna (Spread) - Garantias e LC são comissão única
        else if(getTradeFinNegocVO().getProduto().isGarantia()) {
            
            // Validar campos 
            if(SiteUtil.isEmptyOrNull(getViewHelper().getValueComissaoCobranca())) {
                NpcFacesUtils.addInfoModalMessage("Valor comissão interna não preenchido.", false);
                 isValid = Boolean.FALSE;
            }
            
            if(SiteUtil.isEmptyOrNull(getViewHelper().getTipoCobrancaComissao())) {
                NpcFacesUtils.addInfoModalMessage("Cobrança comissão não preenchido.", false);
                isValid = Boolean.FALSE;
            }
            
            if(SiteUtil.isEmptyOrNull(getViewHelper().getCodMoedaComissao())) {
                NpcFacesUtils.addInfoModalMessage("Moeda comissão não preenchido.", false);
                isValid = Boolean.FALSE;
            }
            
            if(SiteUtil.isEmptyOrNull(getViewHelper().getCodComissaoSobre())) {
                NpcFacesUtils.addInfoModalMessage("Comissão sobre não preenchido.", false);
                isValid = Boolean.FALSE;
            }
        
        }
        
        // Se evento for 'Confirmar' da alteração/divergente, valida data Limite do Custo Externo      
        if(tipoAcessoAlterarEvento == EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo()) {
            if (!SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getDlimfndngcmbio())) {
                Date dataLimiteCusto = SiteUtil.dataMainframeToWeb(getTrdFinNegPrecificacaoVO().getDlimfndngcmbio().replace("/", "."));
                
                if(SiteUtil.comparaDatas(dataLimiteCusto, new Date()) < 0) {
                    NpcFacesUtils.addInfoModalMessage("Validade do custo externo expirada. Solicitar nova cotação de custo externo.", false);
                    isValid = Boolean.FALSE;
                }
            }
        }
        
        return isValid;
    }
    
    private Boolean validarCamposObrigatoriosPorProduto(EnumProduto produto, int tipoAcessoAlterarEvento) {
        Boolean isValid = Boolean.TRUE;
        Double varDouble = 0D;
        
        // Validação Forfaiting
        if (produto.equals(EnumProduto.PRODUTO_FORFAITING)) {
            
            // Valida Previsão de Desembolso
            if (getTradeFinNegocVO().getDataPrevDesemb() != null
                            && (getTradeFinNegocVO().getDataPrevDesemb().getInicio() != null || getTradeFinNegocVO().getDataPrevDesemb().getFim() != null)
                            && !getTradeFinNegocVO().getDataPrevDesemb().isValid()) {
                NpcFacesUtils.addInfoModalMessage(getTradeFinNegocVO().getDataPrevDesemb().getMensagemValidacao("Previsão de Desembolso"), false);
                isValid = Boolean.FALSE;
            }
            
            // Valida Previsão de Embarque
            if (getTradeFinNegocVO().getDataPrevEmbarq() != null
                            && (getTradeFinNegocVO().getDataPrevEmbarq().getInicio() != null || getTradeFinNegocVO().getDataPrevEmbarq().getFim() != null)
                            && !getTradeFinNegocVO().getDataPrevEmbarq().isValid()) {
                NpcFacesUtils.addInfoModalMessage(getTradeFinNegocVO().getDataPrevEmbarq().getMensagemValidacao("Previsão de Embarque"), false);
                isValid = Boolean.FALSE;
            }
        }
        
        // Valida se produto for LC Importação (Derik teste)
        else if (produto.equals(EnumProduto.LC_IMPORTACAO)) {
            
            if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCindcdlastrcarta())) {
                NpcFacesUtils.addInfoModalMessage("Em \"Precificação\", favor informar o campo \"ECA\".", false);
                isValid = Boolean.FALSE;          
            }
        }
        
        else if (produto.equals(EnumProduto.FINIMP_ECA)) {
        	if(tipoAcessoAlterarEvento == EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo()){
        		
        		if(SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio())){
        			NpcFacesUtils.addInfoModalMessage("O campo Banco Financiador é obrigatório.", false);
                    isValid = Boolean.FALSE;     
        		}
        		//banco financiador sempre obrigatorio
        		
        	}else if(tipoAcessoAlterarEvento == EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo()){
        		if(getTradeFinNegocVO().getListaCotacoes() == null || getTradeFinNegocVO().getListaCotacoes().size() == 0){
        			NpcFacesUtils.addInfoModalMessage("O campo \"Banco Financiador\" é obrigatório.", false);
        			isValid = Boolean.FALSE;     
        		}
        	}
        }
        
        // Valida campos obrigatórios para Forfaiting
        else if (produto.equals(EnumProduto.PRODUTO_FORFAITING)) {
            
            if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiavalddletra())){
                NpcFacesUtils.addInfoModalMessage("O campo Prazo das Letras é obrigatório.", false);
                isValid = Boolean.FALSE;
            }
            
            if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio())){
                NpcFacesUtils.addInfoModalMessage("O campo Prazo Financiamento é obrigatório.", false);
                isValid = Boolean.FALSE;
            }
            
            if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDataPrevDesemb().getInicio()) ||
                            SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDataPrevDesemb().getFim())) {
                NpcFacesUtils.addInfoModalMessage("O campo Previsão do Desembolso é obrigatório.", false);
                isValid = Boolean.FALSE;
            }
            
            if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVtxmoracmbio())){
                NpcFacesUtils.addInfoModalMessage("O campo Juros de Mora é obrigatório.", false);
                isValid = Boolean.FALSE;
            }
            
            if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVmultanegoccmbio())){
                NpcFacesUtils.addInfoModalMessage("O campo Multa é obrigatório.", false);
                isValid = Boolean.FALSE;
            }
            
            if(SiteUtil.isEmptyOrNull(getItemListaComissaoInterna().getVtxspreadnegoc())){
                NpcFacesUtils.addInfoModalMessage("O campo Spread Negociado é obrigatório.", false);
                isValid = Boolean.FALSE;
            } else {
                varDouble = Double.valueOf(SiteUtil.trocarVirgulaPorPonto(
                                getItemListaComissaoInterna().getVtxspreadnegoc()));
                 if (varDouble <= 0D) {
                     NpcFacesUtils.addInfoModalMessage("O valor do campo Spread Negociado é inválido.", false);
                     isValid = Boolean.FALSE;
                }
            }
        }
        
        // Valida campos obrigatórios para Proex
        else if (produto.equals(EnumProduto.PROEX)) {
            if(getTradeFinNegocVO().getPeriodoValidadeProposta() != null 
                    && !getTradeFinNegocVO().getPeriodoValidadeProposta().isIndeterminado()
                    && !getTradeFinNegocVO().getPeriodoValidadeProposta().isValid()) {
                NpcFacesUtils.addInfoModalMessage(getTradeFinNegocVO().getPeriodoValidadeProposta().getMensagemValidacao("Validade da Proposta"), false);
                isValid = Boolean.FALSE;
            }
        }
        
        return isValid;
    }
    
    private Boolean validarDataPrevisaoDesembolso() {
        Boolean isValid = Boolean.TRUE;
        
        if(!getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo())) {
            
            // Data do 'Previsão Desembolso' é obrigatório e tem que ser igual a data do primeiro fluxo de pagamento
            if (getViewHelper().getDatePrevDesembolso() == null) {
                
                NpcFacesUtils.addInfoModalMessage("O campo Previsão Desembolso é obrigatório.", false);
                isValid = Boolean.FALSE;
            } 
            
            // Data previsão desembolso não pode ser menor que a data atual
            else if (SiteUtil.comparaDatas(getViewHelper().getDatePrevDesembolso(), new Date()) < 0) {
                NpcFacesUtils.addInfoModalMessage("Data Previsão Desembolso não pode ser menor que a data atual.", false);
                isValid = Boolean.FALSE;
            }
            
        } else {
            
            // Data do 'Previsão Desembolso' é obrigatório e tem que ser igual a data do primeiro fluxo de pagamento
            if (getViewHelper().getDateProrrogacao() == null) {
                
                NpcFacesUtils.addInfoModalMessage("O campo Previsão Prorrogação é obrigatório.", false);
                isValid = Boolean.FALSE;
            } 
            
            // Data previsão desembolso não pode ser menor que a data atual
            else if (SiteUtil.comparaDatas(getViewHelper().getDateProrrogacao(), new Date()) < 0) {
                NpcFacesUtils.addInfoModalMessage("Data Previsão Prorrogação não pode ser menor que a data atual.", false);
                isValid = Boolean.FALSE;
            }
        }
        
        // Fluxo de pagamento obrigatorio
        if(isValid && getViewHelper().getFuncaoBotaoFluxo().equals("Incluir") && getViewHelper().getDateFluxoPgtoTemp() != null 
                        && !getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo())){
            isValid = Boolean.TRUE;
        } else if (isValid && getTradeFinNegocVO().getListaFluxos() != null && 
            getTradeFinNegocVO().getListaFluxos().size() > Numeros.ZERO) {
            
            if ((!getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo())
                            && !getViewHelper().getFuncaoBotaoFluxo().equals("Alterar"))
                    || (getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo()) 
                            && !getViewHelper().getFuncaoBotaoFluxo().equals("Alterar"))) {
                
            	if (getTradeFinNegocVO().getListaFluxos().get(0).getDprevtdsembcmbio() == null) {
            		if (getViewHelper().getDatePrevDesembolso() != null) {
                		getTradeFinNegocVO().getListaFluxos().get(0).setDprevtdsembcmbio(SiteUtil.dateToString(getViewHelper().getDatePrevDesembolso(), "dd/MM/yyyy"));
                		itemListaFluxoPgto.setDprevtdsembcmbio(SiteUtil.dateToString(getViewHelper().getDatePrevDesembolso(), "dd/MM/yyyy"));
					} else {
	            		getTradeFinNegocVO().getListaFluxos().get(0).setDprevtdsembcmbio(SiteUtil.dateToString(getViewHelper().getDateFluxoPgtoTemp(), "dd/MM/yyyy"));
	            		itemListaFluxoPgto.setDprevtdsembcmbio(SiteUtil.dateToString(getViewHelper().getDateFluxoPgtoTemp(), "dd/MM/yyyy"));
					}
				}
            	
                Date dataPrimeiroFluxo = SiteUtil.dataMainframeToWeb(getTradeFinNegocVO().getListaFluxos().get(0).getDprevtdsembcmbio().replace("/", "."));
                isValid = validaDataPrimeiroFluxo(dataPrimeiroFluxo);
            } else if(getViewHelper().getFuncaoBotaoFluxo().equals("Alterar") && SiteUtil.getInt(getViewHelper().getItemSelecListaFluxos())==0){
                isValid = validaDataPrimeiroFluxo(getViewHelper().getDateFluxoPgtoTemp());
            }
        }  else if(isValid && getViewHelper().getDateFluxoPgtoTemp() != null ) {
            
            isValid = validaDataPrimeiroFluxo(getViewHelper().getDateFluxoPgtoTemp());
        }
        
        return isValid;
    }
    
    private Boolean validaDataPrimeiroFluxo(Date dataFluxo) {
        Boolean isValid = Boolean.TRUE;
        
        if (!getFuncaoExecutando().equals(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo())) {
            if (SiteUtil.comparaDatas(dataFluxo, getViewHelper().getDatePrevDesembolso()) != 0) {
                NpcFacesUtils.addInfoModalMessage("A data do primeiro Fluxo de Pagamento tem que ser igual a data Previsão Desembolso.", false);
                isValid = Boolean.FALSE;
            }
        } else {
            if (SiteUtil.comparaDatas(dataFluxo, getViewHelper().getDateProrrogacao()) != 0) {
                NpcFacesUtils.addInfoModalMessage("A data do Fluxo de Pagamento tem que ser igual a data Previsão Prorrogação.", false);
                isValid = Boolean.FALSE;
            }
        }
        
        return isValid;
    }
    
    /*******************************************
     * INICIO - PREPARAR DADOS PARA MANUTENÇÂO *
     *******************************************/  
    
    /**
     * Nome: carregarDadosViaConsulta
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected boolean carregarDadosViaConsulta(Integer funcao) {

        // variavel carregada no bean 'TradeFinMonitBean.java' no metodo
        // 'iniciarAlterar()';
        if (getTradeFinanceBean().getViewHelper().getIniciarDadosViaConsulta()) {
            
            setFuncaoExecutando(funcao);

            getViewHelper().setComboProduto(
                    getSelectItemBean().getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                            EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                            EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));
            
            getTradeFinanceBean().setCotacoesList(new CotacoesExternasVO());

            // executa o metodo apenas uma vez
            getTradeFinanceBean().getViewHelper().setIniciarDadosViaConsulta(Boolean.FALSE);

            getTradeFinNegocVO().setCprodtservc(getTradeFinanceBean().getTradeFinanceVO().getCprodtservc());
            getTradeFinNegocVO().setNbletonegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getNbletonegoccmbio());
            getTradeFinNegocVO().setNbletocmbioano(getTradeFinanceBean().getTradeFinanceVO().getNbletocmbioano());
            getTradeFinNegocVO().setNcotacao(getTradeFinanceBean().getTradeFinanceVO().getNcotacao());
            getTradeFinNegocVO().setCaditvbletocmbio(getTradeFinanceBean().getTradeFinanceVO().getCaditvbletocmbio());
            getTradeFinNegocVO().setIorgextercmbio(getTradeFinanceBean().getTradeFinanceVO().getIorgextercmbio());
            getTradeFinNegocVO().setCrting(getTradeFinanceBean().getTradeFinanceVO().getCrting());
            getTradeFinNegocVO().setNomeundorgnz(getTradeFinanceBean().getTradeFinanceVO().getNomeundorgnz());
            
            
            configurarTelaPorProduto();

            // converte VO de consulta no VO de inclusão/alteração
            atualizarAlteracaoVO(funcao);
            
            // Guarda valor original dos campos para identificar alteração de status
            setTradeFinanceOriginalVO(getTradeFinNegocVO().copy());
            
            if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.ZERO);
                
            }else {
                getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.UM);
                
            }
            
            getViewHelper().setTelaRetorno("tradeFinMonitList");
            
            return true;
        }
        return false;
    }
    
    /**
     * Nome: atualizarAlteracaoVO
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarAlteracaoVO(Integer funcao) {
        
        // FINIMP DIRETO (1644)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
			
	        atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarSwapStandBy();
	        atualizarFluxoPagamento();
	        atualizarPrecificacao();
	        atualizarComissaoInterna();
	        atualizarMercadoria();
	        atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
			
			return;
		}
		
		// REFINIMP DIRETO (1646)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarSwapStandBy();
	        atualizarFluxoPagamento();
	        atualizarPrecificacao();
	        atualizarComissaoInterna();
	        atualizarMercadoria();
	        atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();	        

	        
			return;
		}
		
		// FINIMP INDIRETO (2692)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarSwapStandBy();
	        atualizarFluxoPagamento();
	        atualizarPrecificacao();
	        atualizarComissaoInterna();
	        atualizarMercadoria();
	        atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
	        
			
			return;
		}
		
		// REFINIMP INDIRETO (1717)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarSwapStandBy();
	        atualizarFluxoPagamento();
	        atualizarPrecificacao();
	        atualizarComissaoInterna();
	        atualizarMercadoria();
	        atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
	        
			
			return;
		}
		
		// LEI 4131 (2010)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarSwapStandBy();
	        
	        atualizarPrecificacao();
	        atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
	        
	        if(!EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo().equals(funcao)){
	        	
	        	atualizarFluxoPagamento();
	        	atualizarComissaoInterna();
	        }

			return;
		}
		
		// PPE (1642)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarSwapStandBy();
	        
	        atualizarPrecificacao();
	        atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
	        
	        if(!EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo().equals(funcao)){
		        atualizarFluxoPagamento();
		        atualizarComissaoInterna();
		        atualizarMercadoria();
	        }
	        
			return;
		}
		
		// WORKING CAPITAL (2011)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarSwapStandBy();
	        atualizarTomador();
	        
	        atualizarPrecificacao();
	        atualizarComissaoExterna();
	        atualizarOperVinculadaRofTarifas();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
	        
	        if(!EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo().equals(funcao)){

	        	atualizarFluxoPagamento();
	        	atualizarComissaoInterna();
	        }

			return;
		}
		
		// FORFAITING (644)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarPrecificacao();
			atualizarComissaoIntForfaiting();
			atualizarMercadoria();
			atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
	        atualizarTomador();

            if(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO_DESEMBOLSO.getCodigo().equals(funcao)){
                
                if (getTradeFinNegocVO().isForfaitingTipoJuroEmbutido() == false &&
                                getTradeFinNegocVO().isForfaitingTipoJuroDeduzido() == false) {
                    // inclui desembolso Tipo Juro Embutido de acordo com protótipo
                    getTradeFinNegocVO().setCtpojurotrade(EnumTradeFinance.OPCAO_JUROS_EMBUTIDOS.getCodigo());
                }
            }
	        
			return;
		}
		
		// FINIMP ECA (1715)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarSwapStandBy();
	        atualizarFluxoPagamento();
	        atualizarPrecificacao();
	        atualizarComissaoInterna();
	        atualizarMercadoria();
	        atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
			atualizarDespesasEcaLc();
			
			return;
		}
		
		// PROEX EQUALIZACAO (642)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
			atualizarProex();

			return;
		}
		
		// COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
		if (getTradeFinNegocVO().getProduto().isNce()) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        
	        if(!EnumTradeFinance.FUNCAO_TIPO_ADITAR.getCodigo().equals(funcao)){
	        	atualizarSwapStandBy();
	        	atualizarFluxoPagamento();
	        	atualizarPrecificacao();
	        	atualizarOperVinculadaRofTarifas();
	        	atualizarComissaoExterna();
	        	atualizarModeloBoleto();
	        	atualizarDadosObsCompl();
	        }
			return;
		}
		
		// GARANTIA INTERNACIONAL EXPEDIDA (1769, 3933)
		if(getTradeFinNegocVO().getProduto().isGarantia()) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        
	        atualizarPrecificacao();
            atualizarComissaoInterna();
            atualizarComissaoExterna();
            atualizarModeloBoleto();
            atualizarDadosObsCompl();
            atualizarDespesasGarantia();
            atualizarOperVinculadaRofTarifas();
	        
			return;
		}
		
		// BNDES Pós (661, 662)
		// BNDES Pré (663, 664, 665, 666, 667, 670, 3934)
		if (getTradeFinNegocVO().getProduto().isBndesPos() || getTradeFinNegocVO().getProduto().isBndesPre()) {

			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
	        atualizarDadosBndesPos();
	        return;
		}
		
		
		// CARTA DE CRÉDITO DE IMPORTAÇÃO (2018)
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
			
			atualizarClientes();
	        atualizarProdutosAprovacaoMoeda();
	        carregarGarantias();
	        atualizarPrecificacao();
	        atualizarComissaoInterna();
	        atualizarMercadoria();
	        atualizarOperVinculadaRofTarifas();
	        atualizarComissaoExterna();
	        atualizarModeloBoleto();
	        atualizarDadosObsCompl();
			atualizarDespesasEcaLc();
			
			return;
		}
		
		return;
    }
    
    private void atualizarDadosBndesPos() {
        getTradeFinNegocVO().setVprevtrectacmbio(getTradeFinanceBean().getTradeFinanceVO().getVprevtrectacmbio());
        getTradeFinNegocVO().setQregexporcmbio(getTradeFinanceBean().getTradeFinanceVO().getQregexporcmbio());
        getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setBancocorr(getTradeFinanceBean().getTradeFinanceVO().getDbcocred());
        getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setCbanqrcmbio(getTradeFinanceBean().getTradeFinanceVO().getCunicpssoaindica());
        getTradeFinNegocVO().setCcobrcomismtori(getTradeFinanceBean().getTradeFinanceVO().getCcobrcomismtori());
        getTradeFinNegocVO().setCcobrcomisagte(getTradeFinanceBean().getTradeFinanceVO().getCcobrcomisagte());
        getTradeFinNegocVO().setPcomismtoricmbio(getTradeFinanceBean().getTradeFinanceVO().getPcomismtoricmbio());
        getViewHelper().setDataLimiteFRO(SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDlimenviorsumo()));
        getViewHelper().setDataVencProposta(getTradeFinanceBean().getTradeFinanceVO().getDvctocntragarnt());
        getViewHelper().setPeriodoEmbarqueIni(SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDprevtinicembrq()));
        getViewHelper().setPeriodoEmbarqueFim(SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDprevtfimembrq()));
        getTradeFinNegocVO().setVagtefincrcmbio(getTradeFinanceBean().getTradeFinanceVO().getVagtefincrcmbio());
        getTradeFinNegocVO().setVbcomtoricmbio(getTradeFinanceBean().getTradeFinanceVO().getVbcomtoricmbio());
                
    }

	private void atualizarDespesasEcaLc() {
		CotacoesExternasVO cotacoesExternasVO =  new CotacoesExternasVO();
		
		// Houve uma alteração no book de entrada do NPCCWYDE e NPCCWYAE, com a inserção do campo cindcdaprovbanq
        // onde quando for 1 é referente a tela do aprovar banqueiro e fora dessa tela informa o código 2.
		cotacoesExternasVO = tradeFinanceMonitService.obterCotacoesExternas(getTradeFinNegocVO().getNbletonegoccmbio()
		                , getTradeFinNegocVO().getHinclreghist(), Numeros.DOIS);
		
		getTradeFinNegocVO().setListaCotacoes(cotacoesExternasVO.getListaCotacoes());
		
		getTradeFinNegocVO().setCusuariosess(cotacoesExternasVO.getCusuariosess());
		getTradeFinNegocVO().setNusuariosess(cotacoesExternasVO.getNusuariosess());
		
		//tem que ser setado todas as despesas se nao, nao vai mandar no salvar
		if(cotacoesExternasVO.getListaCotacoes() != null && cotacoesExternasVO.getListaCotacoes().size() > 0){
			
			Boolean primeiroApresentar = Boolean.TRUE;
			for (ListaCotacoesExternasVO listaCotacoesExternasVO : cotacoesExternasVO.getListaCotacoes()) {
				
				List<ListaDespesasVO> despesaList = tradeFinanceMonitService.obterDespesas(listaCotacoesExternasVO.getCfndng(), getTradeFinNegocVO().getNbletonegoccmbio(), getTradeFinNegocVO().getHinclreghist());

				listaCotacoesExternasVO.setListaDespesas(despesaList);
				
				//O primeiro a apresentar na tela
				if(primeiroApresentar){
					getTradeFinNegocVO().setListaDespesas(despesaList);
					primeiroApresentar = Boolean.FALSE;
				}
				
			}
		}
	}
	
	private void atualizarDespesasGarantia() {

	    ResponsavelDespesaVO respDespVO =  new ResponsavelDespesaVO();

	    // Houve uma alteração no book de entrada do NPCCWYDE e NPCCWYAE, com a inserção do campo cindcdaprovbanq
        // onde quando for 1 é referente a tela do aprovar banqueiro e fora dessa tela informa o código 2.
	    respDespVO = tradeFinanceMonitService.obterResponsavelDespesas(getTradeFinNegocVO().getNbletonegoccmbio(), 
	                    getTradeFinNegocVO().getHinclreghist(), Numeros.DOIS);

	    getTradeFinNegocVO().setListaRespDesp(respDespVO.getListaDespesa());

	    //tem que ser setado todas as despesas se nao, nao vai mandar no salvar
	    if(respDespVO.getListaDespesa() != null && respDespVO.getListaDespesa().size() > 0){

	        Boolean primeiroApresentar = Boolean.TRUE;
	        for (ListaResponsavelDespesaVO listaCotacoesExternasVO : respDespVO.getListaDespesa()) {

// IN2833579 - ERRO GARANTIA INTERNACIONAL(STANDBY) ERRO CONFIRMAR DA TELA DE FECHAMENTO
	        	List<ListaDespesasVO> despesaList = null;
	        	try {
		            despesaList = tradeFinanceMonitService.obterDespesas(listaCotacoesExternasVO.getCfndng(), getTradeFinNegocVO().getNbletonegoccmbio(), getTradeFinNegocVO().getHinclreghist());
				} catch (Exception e) {
					despesaList = new ArrayList<ListaDespesasVO>();
				}
// IN2833579 - ERRO GARANTIA INTERNACIONAL(STANDBY) ERRO CONFIRMAR DA TELA DE FECHAMENTO

	            listaCotacoesExternasVO.setListaDespesas(despesaList);

	            //O primeiro a apresentar na tela
	            if(primeiroApresentar){
	                getTradeFinNegocVO().setListaDespesas(despesaList);
	                primeiroApresentar = Boolean.FALSE;
	            }

	        }
	    }

	}

	private void carregarGarantias() {
		garantiasModalBean.setNbletonegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getNbletonegoccmbio());
        garantiasModalBean.setNseqcontrlim(getTradeFinanceBean().getTradeFinanceVO().getNseqcontrlim());
        
        garantiasModalBean.setNppstapontucmbio(getTradeFinanceBean().getTradeFinanceVO().getNppstapontucmbio());
        garantiasModalBean.setCcpfcnpj(getTradeFinanceBean().getTradeFinanceVO().getCpfcnpj());
        garantiasModalBean.setCflialcpfcnpj(getTradeFinanceBean().getTradeFinanceVO().getCflial());
        garantiasModalBean.setCctrlcpfcnpj(getTradeFinanceBean().getTradeFinanceVO().getCctrl());
        
        garantiasModalBean.carregarGarantias();
        garantiasModalBean.preparListaInclusao();
	}
    
    /**
     * 
    	* Nome: atualizarTomador
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 18/05/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    protected void atualizarTomador() {
    	try{
    	   getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.atualizarTomador <<<<<<<<<<<");   	  
    		
    	   getTradeFinNegocVO().setEcunicpssoacmbiot(getTradeFinanceBean().getTradeFinanceVO().getCunicpssoacmbiot());
    	   
    	   getTomadorModal().setCunicpssoacmbio(getTradeFinNegocVO().getEcunicpssoacmbiot());
    	   getTomadorModal().setIpssoacmbio(getTradeFinanceBean().getTradeFinanceVO().getNcunicpssoacmbiot());
    	   
    	   getTradeFinNegocVO().setCcobrcomisadcio(getTradeFinanceBean().getTradeFinanceVO().getCcobrcomisadcio());
    	   getTradeFinNegocVO().setPcobervarprodt(SiteUtil.trocarPontoPorVirgula(getTradeFinanceBean().getTradeFinanceVO().getPcobervarprodt()));
    	
    	}finally{
    	   getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.atualizarTomador <<<<<<<<<<<");
    	}
    	
	}
    
    /**
     * 
    	* Nome: atualizarAboutTomador
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 17/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
	public void atualizarAboutTomador(AjaxBehaviorEvent e) {
		try {
			getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.atualizarTomador <<<<<<<<<<<");

			getTradeFinNegocVO().setCcobrcomisadcio(getTradeFinNegocVO().getCcobrcomisadcio());

		} finally {
			getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.atualizarTomador <<<<<<<<<<<");
		}
    	
	}
    
    /**
     * 
     * Nome: atualizarTomador
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 18/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    protected void atualizarProex() {
    	
    	getTradeFinNegocVO().setPtxequalcmbio(getTradeFinanceBean().getTradeFinanceVO().getPtxequalcmbio());
    	getTradeFinNegocVO().setQprzmedcmbio(getTradeFinanceBean().getTradeFinanceVO().getQprzmedcmbio());
    	getTradeFinNegocVO().setCeconmmoedaequal(getTradeFinanceBean().getTradeFinanceVO().getCeconmmoedaequal());
    	getTradeFinNegocVO().setVprevtcmbioequal(getTradeFinanceBean().getTradeFinanceVO().getVprevtcmbioequal());
    	getTradeFinNegocVO().setVtxspreadnegoc(getTradeFinanceBean().getTradeFinanceVO().getVtxspreadnegoc());
    	getTradeFinNegocVO().setVtxspreadtot(getTradeFinanceBean().getTradeFinanceVO().getVtxspreadtot());
    	getTradeFinNegocVO().setCmoedaeconmrecta(getTradeFinanceBean().getTradeFinanceVO().getCmoedaeconmrecta());
    	getTradeFinNegocVO().setVprevtrectacmbio(getTradeFinanceBean().getTradeFinanceVO().getVprevtrectacmbio());
    	getTradeFinNegocVO().setCtpoprzcmbio(getTradeFinanceBean().getTradeFinanceVO().getCtpoprzcmbio());

    	getTradeFinNegocVO().getObsCotacaoVO().setListaRebate(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getListaRebate());
    	getTradeFinNegocVO().getObsCotacaoVO().setDespdesc(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDespdesc());
    	getTradeFinNegocVO().getObsCotacaoVO().setFormamor(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getFormamor());
    	getTradeFinNegocVO().getObsCotacaoVO().setDespconf(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDespconf());
    	getTradeFinNegocVO().getObsCotacaoVO().setListaTaxa(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getListaTaxa());
    	getTradeFinNegocVO().getObsCotacaoVO().setGarantias(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getGarantias());
    	
    	getTradeFinNegocVO().setRebate("");
    	getTradeFinNegocVO().setTaxaDesconto("");
    	getTradeFinNegocVO().setPeriodoValidadeProposta(new CalendarioPeriodo());
    	getTradeFinNegocVO().getPeriodoValidadeProposta().setInicio(SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDinicvalddppsta()));
    	getTradeFinNegocVO().getPeriodoValidadeProposta().setFim(SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDfimvalddppsta()));
    	
    	getTradeFinNegocVO().setDlimenviorsumo(getTradeFinanceBean().getTradeFinanceVO().getDlimenviorsumo());
    	
		getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setBancocorr(getTradeFinanceBean().getTradeFinanceVO().getDbcocred());
		getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setCbanqrcmbio(getTradeFinanceBean().getTradeFinanceVO().getCunicpssoaindica());
		
    }
    
    /**
     * 
    	* Nome: atualizarComissaoIntForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 18/05/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    protected void atualizarComissaoIntForfaiting() {
        Integer seqDesembolso = Numeros.NUM0;
        
		getTradeFinNegocVO().setVtxspreadnegoc(getTradeFinanceBean().getTradeFinanceVO().getVtxspreadnegoc());
		getTradeFinNegocVO().setVtxspreadtot(getTradeFinanceBean().getTradeFinanceVO().getVtxspreadtot());
		
		setListaDesembolso(getTradeFinanceBean().getTradeFinanceVO().getListaDesembolso());
        for (Iterator<TradeFinanceDesembolsoVO> iterator = getListaDesembolso().iterator(); iterator
                        .hasNext();) {
            TradeFinanceDesembolsoVO itemLista = (TradeFinanceDesembolsoVO) iterator.next();
            
            itemLista.setSeqDesembolso(++seqDesembolso);
            itemLista.setVprevtdsembcmbio(SiteUtil.formatarValorWeb(itemLista.getVprevtdsembcmbio()));

            itemLista.setVtxliborcmbio(SiteUtil.trocarPontoPorVirgula(itemLista.getVtxliborcmbio()));
            itemLista.setPtxjurofndng(SiteUtil.trocarPontoPorVirgula(itemLista.getPtxjurofndng()));
            itemLista.setPspreadtxcmbio(SiteUtil.trocarPontoPorVirgula(itemLista.getPspreadtxcmbio()));
            itemLista.setPjuronegoccmbio(SiteUtil.trocarPontoPorVirgula(itemLista.getPjuronegoccmbio()));
            itemLista.setTaxaDescontada(SiteUtil.trocarPontoPorVirgula(itemLista.getTaxaDescontada()));
            itemLista.setVjurodsembcmbio(SiteUtil.trocarPontoPorVirgula(itemLista.getVjurodsembcmbio()));
            itemLista.setVdsembnegoccmbio(SiteUtil.formatarValorWeb(itemLista.getVdsembnegoccmbio()));
        }
		
		getTradeFinNegocVO().setCtpojurotrade(getTradeFinanceBean().getTradeFinanceVO().getCtpojurotrade());
        getTxForfaitingVO().setJurosembded(getTradeFinNegocVO().getCtpojurotrade());

        getItemListaComissaoInterna().setPtxcustototal(SiteUtil.trocarPontoPorVirgula(getTradeFinanceBean().
                        getTradeFinanceVO().getVtxspreadaprov()));
        getItemListaComissaoInterna().setVtxspreadnegoc(SiteUtil.trocarPontoPorVirgula(getTradeFinanceBean().
                        getTradeFinanceVO().getVtxspreadnegoc()));
        getItemListaComissaoInterna().setVtxspreadtot(SiteUtil.trocarPontoPorVirgula(getTradeFinanceBean().
                        getTradeFinanceVO().getVtxspreadtot()));
        getItemListaComissaoInterna().setCustoTotalForfaiting(getTradeFinanceBean().getTradeFinanceVO().getDescctotal());
		
        getTrdFinNegPrecificacaoVO().setCindcdeconmmoeda(tradeFinNegocVO.getCindcdeconmmoeda());
        getTrdFinNegPrecificacaoVO().setPrzomediodsemb(tradeFinNegocVO.getTdiaopercmbio());
        getTrdFinNegPrecificacaoVO().setCprodtservc(tradeFinNegocVO.getCprodtservc());
        
// IN2833078(Kanban BRQ) - ERRO AO INCLUIR LIBOR FIXA EM BOLETO DE FORFAITING        	
// OC4529622 - ERROS BOLETO FORFAIT        	
        limparDesembolso();
        getDesembolsoForfaitingVO().setPtxjurofndng(SiteUtil.trocarPontoPorVirgula(getTrdFinNegPrecificacaoVO().getSpreadclean()));
        getDesembolsoForfaitingVO().setTdiafinandsemb(tradeFinNegocVO.getTdiaopercmbio());
        getDesembolsoForfaitingVO().setSaldoDesembolsar(getTradeFinanceBean().getTradeFinanceVO().getSvaloradsemb());
        
        getDesembolsoForfaitingVO().setBaixarSaldo(!SiteUtil.isValueZero(getDesembolsoForfaitingVO().getSaldoDesembolsar()));
        
        calcTaxasOperacaoForfaiting();
        calcTaxasDesembolsoForfaiting();
		
		getTradeFinanceBean().carregarQuadroJurosForfaiting();
	}
    
// IN2833078(Kanban BRQ) - ERRO AO INCLUIR LIBOR FIXA EM BOLETO DE FORFAITING        	
// OC4529622 - ERROS BOLETO FORFAIT        	
    /**
     * Nome: limparDesembolso
     * 
     * Propósito: Limpar Desembolso
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/05/2019 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    private void limparDesembolso() {
        getViewHelper().setDateFluxoPgtoTemp(null);
        getViewHelper().setDatePrevDesembolso(null);
        getViewHelper().setVencimentoSaque(null);
        
        setDesembolsoForfaitingVO(new TradeFinanceDesembolsoVO());
    }
    
    /**
     * Nome: atualizarClientes
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarClientes() {

        /**
         * Dados Clientes
         **/

        getClienteSelecaoVO().setNomeCliente(getTradeFinanceBean().getTradeFinanceVO().getNcunicclicmbio());
        getTradeFinNegocVO().setCunicclicmbio(getTradeFinanceBean().getTradeFinanceVO().getCunicclicmbio());
        getTradeFinNegocVO().setCidtfdcartacsndo(getTradeFinanceBean().getTradeFinanceVO().getCidtfdcartacsndo());
        getTradeFinNegocVO().setDanobase(getTradeFinanceBean().getTradeFinanceVO().getDanobase());
        
        getTradeFinNegocVO().getDadosPrecificacao().setCunicpssoacmbiot(getTradeFinanceBean().getTradeFinanceVO().getCunicpssoaindica());

        getTradeFinNegocVO().setCtposgmtocli(getTradeFinanceBean().getTradeFinanceVO().getCtposgmtocli());
        getTradeFinNegocVO().setCdcpfcnpj(getTradeFinanceBean().getTradeFinanceVO().getCpfcnpj());
        getTradeFinNegocVO().setCdfilial(getTradeFinanceBean().getTradeFinanceVO().getCflial());
        getTradeFinNegocVO().setCdctrlcpfcnpj(getTradeFinanceBean().getTradeFinanceVO().getCctrl());
        getTradeFinNegocVO().setCpfCnpjFormatado(getTradeFinanceBean().getTradeFinanceVO().getCpfCnpjFormatado());
        
        getTradeFinNegocVO().setNseqcontrlim(getTradeFinanceBean().getTradeFinanceVO().getNseqcontrlim());
        getTradeFinNegocVO().setNppstapontucmbio(getTradeFinanceBean().getTradeFinanceVO().getNppstapontucmbio());
        getTradeFinNegocVO().setMoedaLimite(getTradeFinanceBean().getTradeFinanceVO().getDescreconmlim());
        getTradeFinNegocVO().setCeconmmoedalim(getTradeFinanceBean().getTradeFinanceVO().getCeconmmoedalim());
        
        setLimiteVO(new LimitesModalVO());
        getLimiteVO().setNcontrlim(getTradeFinNegocVO().getNseqcontrlim());
        getLimiteVO().setNseqcontrppl(getTradeFinNegocVO().getNppstapontucmbio());
        getLimiteVO().setPspreadprodt(getTradeFinanceBean().getComissaoInternaVO().getVtxspreadaprov());
        getLimiteVO().setDescrmoeda(getTradeFinNegocVO().getMoedaLimite());
        getLimiteVO().setCindcdeconmmoeda(getTradeFinNegocVO().getCeconmmoedalim());
        
        getTradeFinNegocVO().setCrting(getTradeFinanceBean().getTradeFinanceVO().getCrting());

        if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCrting())){
        	getTradeFinNegocVO().setCrting(getTradeFinanceBean().getTradeFinanceVO().getRating());
        }
        
        
        if (getTradeFinNegocVO().getCdfilial() <= Numeros.ZERO) {
            // tipo CPF
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.TRES);
            getClienteSelecaoVO().setCpf(
                    SiteUtil.formatarCpfComponente(getClienteSelecaoVO().getCpf(), getTradeFinNegocVO().getCdcpfcnpj(),
                            getTradeFinNegocVO().getCdctrlcpfcnpj()));

        } else {
            // tipo CNPJ
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
            getClienteSelecaoVO().setCnpj(
                    SiteUtil.formatarCnpjComponente(getClienteSelecaoVO().getCnpj(),
                    		getTradeFinNegocVO().getCdcpfcnpj(),
                            getTradeFinNegocVO().getCdfilial(), getTradeFinNegocVO().getCdctrlcpfcnpj()));
        }

        getClienteSelecaoVO().setNomeCliente(getTradeFinanceBean().getTradeFinanceVO().getNcunicclicmbio());
        getClienteSelecaoVO().setNomeBanco(getTradeFinanceBean().getTradeFinanceVO().getNomesocial());
        getClienteSelecaoVO().setCodAgencia(getTradeFinanceBean().getTradeFinanceVO().getCagbcria().toString());
        getClienteSelecaoVO().setContaDv(getTradeFinanceBean().getTradeFinanceVO().getCctabcriaclicmbio().toString()+"-"+ getTradeFinanceBean().getTradeFinanceVO().getDigtcctabcria());
        getTradeFinNegocVO().setIciddeender(getTradeFinanceBean().getTradeFinanceVO().getCidade());
        getTradeFinNegocVO().setCsgluf(getTradeFinanceBean().getTradeFinanceVO().getEstado());
        getTradeFinNegocVO().setCpssoaundorgnz(getTradeFinanceBean().getTradeFinanceVO().getCpssoajurid());
        getTradeFinNegocVO().setIrzscial(getTradeFinanceBean().getTradeFinanceVO().getNomesocial());
        //
        getTradeFinNegocVO().setCpssoajurid(getTradeFinanceBean().getTradeFinanceVO().getCpssoajurid());
        getTradeFinNegocVO().setNsequndorgnz(getTradeFinanceBean().getTradeFinanceVO().getNsequndorgnz());
        getTradeFinNegocVO().setCmodldprodtcmbio(getTradeFinanceBean().getTradeFinanceVO().getCmodldprodtcmbio());
        getTradeFinNegocVO().setCsitbletocmbio(getTradeFinanceBean().getTradeFinanceVO().getCsitbletocmbio());
        //
        getTradeFinNegocVO().setIsgmto(getTradeFinanceBean().getTradeFinanceVO().getDtposgmtocli());
        
        //dados observacoes
        getTradeFinNegocVO().setObsCotacaoVO(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO());
        
        getTradeFinNegocVO().setDinclreg(getTradeFinanceBean().getTradeFinanceVO().getDinclreg());
        
        //TESTE
        //getTradeFinNegocVO().SETca (getTradeFinanceBean().getTradeFinanceVO().getCagbcria().toString());
        getTradeFinNegocVO().setNctabcriacmbio(getTradeFinanceBean().getTradeFinanceVO().getNctabcriacmbio());
    }

    /**
     * Nome: atualizarProdutosAprovacaoMoeda
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws ParseException 
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarProdutosAprovacaoMoeda(){

        /**
         * Dados Produtos
         **/
        getTradeFinNegocVO().setCprodtservc(getTradeFinanceBean().getTradeFinanceVO().getCprodtservc());
        getTradeFinNegocVO().setCtponegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getCtponegoccmbio());
        getViewHelper().setDataLimiteCotacao(
                SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDvalddnegoccmbio()));
        getViewHelper().setStatusCotacao(EnumTradeFinance.STATUS_EM_NEGOCIACAO.getDescricao());
        getViewHelper().setOperaComLimite(getTradeFinanceBean().getViewHelper().isOperaComLimite());
        
        getTrdFinNegPrecificacaoVO().getBancoIndicadoVO().setIbanqrcmbio(getTradeFinanceBean().getResponsavelDespList().getCunicpssoadesc());
        getTrdFinNegPrecificacaoVO().getBancoIndicadoVO().setCbanqrcmbio(getTradeFinanceBean().getResponsavelDespList().getCunicpssoacmbio());

        /**
         * Dados Aprovação
         **/
        getTradeFinNegocVO().setNseqcontrlim(getTradeFinanceBean().getTradeFinanceVO().getNseqcontrlim());
        getTradeFinNegocVO().setNppstapontucmbio(getTradeFinanceBean().getTradeFinanceVO().getNppstapontucmbio());
        
        setLimiteVO(new LimitesModalVO());  
        getLimiteVO().setNcontrlim(getTradeFinNegocVO().getNseqcontrlim());
        getLimiteVO().setNseqcontrppl(getTradeFinNegocVO().getNppstapontucmbio());
        getLimiteVO().setPspreadprodt(getTradeFinanceBean().getComissaoInternaVO().getVtxspreadaprov());
        getLimiteVO().setDescrmoeda(getTradeFinNegocVO().getMoedaLimite());
        getLimiteVO().setCindcdeconmmoeda(getTradeFinNegocVO().getCeconmmoedalim());
        

        /**
         * Dados Moeda
         **/
        getTradeFinNegocVO().setCindcdeconmmoeda(getTradeFinanceBean().getTradeFinanceVO().getCindcdeconmmoeda());
        getTradeFinNegocVO().setVnegocmoedaestrg(getTradeFinanceBean().getTradeFinanceVO().getVnegocmoedaestrg());
        getTradeFinNegocVO().setMoedaLimite(getTradeFinanceBean().getTradeFinanceVO().getSimbleconmlim());
        getTradeFinNegocVO().setCeconmmoedadsemb(getTradeFinanceBean().getTradeFinanceVO().getCeconmmoedadsemb());
        
        trocarMoedaDesembolso();

        getTradeFinNegocVO().setTdiaopercmbio(getTradeFinanceBean().getTradeFinanceVO().getTdiaopercmbio());
        getTradeFinNegocVO().setCfluxoperdccmbio(getTradeFinanceBean().getTradeFinanceVO().getCfluxoperdccmbio());
        getTradeFinNegocVO().getPrevDesembolsoVO().setTdiacarenprinc(getTradeFinanceBean().getTradeFinanceVO().getTdiacarenprinc());
        getTradeFinNegocVO().getPrevDesembolsoVO().setQpcelatradeprinc(getTradeFinanceBean().getTradeFinanceVO().getQpcelatradeprinc());
        
        // data prevista emissao
        getTradeFinNegocVO().setDprevtgarntexpdi(SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDprevtgarntexpdi()));
        // data vencimento fianca
        getViewHelper().setDateVencFianc(SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDfimnegoccmbio()));
        getTradeFinNegocVO().setDfimnegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getDfimnegoccmbio());
        
        // indeterminado
        getTradeFinNegocVO().setCnegoccmbioindmd(getTradeFinanceBean().getTradeFinanceVO().getCnegoccmbioindmd()); 
        getViewHelper().setIndeterminado(getTradeFinanceBean().isIndeterminado());
        
        // data previsão desembolso
        getTradeFinNegocVO().setVmoedalimgerc(getTradeFinanceBean().getTradeFinanceVO().getVmoedalimgerc());
        
        // Taxa de Juros e Margem Agente
        getTradeFinNegocVO().setPjuronegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getPjuronegoccmbio());
        getTradeFinNegocVO().setPagtefincrcmbio(getTradeFinanceBean().getTradeFinanceVO().getPagtefincrcmbio());
        getTradeFinNegocVO().setPtotjurocmbio(getTradeFinanceBean().getTradeFinanceVO().getPtotjurocmbio());

        // Custo Financeiro e Remuneração BNDES
        getTradeFinNegocVO().getObsCotacaoVO().setCustfin(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getCustfin());
        getTradeFinNegocVO().setVtxremunbndes(getTradeFinanceBean().getTradeFinanceVO().getVtxremunbndes());
        
        // Dados Valor Moeda BNDES
        getTradeFinNegocVO().setCidtfdbndesgrp(getTradeFinanceBean().getTradeFinanceVO().getCidtfdbndesgrp());
        getTradeFinNegocVO().setCidtfdbndesporte(getTradeFinanceBean().getTradeFinanceVO().getCidtfdbndesporte());
        getTradeFinNegocVO().setGrupomercadoriaboleto(getTradeFinanceBean().getTradeFinanceVO().getGrupomercadoriaboleto());
        
        //setar demais campos alteracao
        getViewHelper().setDataLimiteEmbarque(SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDlimembrqcmbio()));
        getTradeFinNegocVO().setDlimembrqcmbio(getTradeFinanceBean().getTradeFinanceVO().getDlimembrqcmbio());
        getTradeFinNegocVO().setVlimcobervar(SiteUtil.trocarPontoPorVirgula(getTradeFinanceBean().getTradeFinanceVO().getVlimcobervar()));
        getTradeFinNegocVO().setCprznegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getCprznegoccmbio());
        getTradeFinNegocVO().setTdiavalddcarta(getTradeFinanceBean().getTradeFinanceVO().getValddcarta());
        getTradeFinNegocVO().setTdiavalddletra(getTradeFinanceBean().getTradeFinanceVO().getTdiavalddletra());
        getTradeFinNegocVO().setTdiavalddletra(getTradeFinanceBean().getTradeFinanceVO().getTdiavalddletra());

        
        //fazer isso para a lista 
        //parametros para inclusao ZERAR TODOS
        getTradeFinNegocVO().getParcelaVO().setVpcelacreditprevt("");
        getTradeFinNegocVO().getParcelaVO().setVpcelacartaprevt("");
        getTradeFinNegocVO().getParcelaVO().setNprzpcelacarta("");
        getTradeFinNegocVO().getParcelaVO().setTdiapgtocarta(0);
        
        //valor da lista
        //setar toda a lista
        getTradeFinNegocVO().setListaParcelas(new ArrayList<ParcelaVO>());
        
        for (ListaParcelasDesembolsoVO parcelaDesembolsoVO : getTradeFinanceBean().getParcelaDesembList()) {
        	
        	ParcelaVO parcelaVO = new ParcelaVO();
        	parcelaVO.setVpcelacreditprevt(parcelaDesembolsoVO.getVpcelacreditprevt());
        	parcelaVO.setVpcelacartaprevt(parcelaDesembolsoVO.getVpcelacartaprevt());
        	parcelaVO.setCprzpcelacarta(parcelaDesembolsoVO.getCprzpcelacarta());
        	parcelaVO.setNprzpcelacarta(parcelaDesembolsoVO.getNprzpcelacarta());
        	parcelaVO.setTdiapgtocarta(parcelaDesembolsoVO.getTdiapgtocarta());
        	parcelaVO.setNpceladsembcarta(parcelaDesembolsoVO.getNpceladsembcarta());
        	
        	getTradeFinNegocVO().getListaParcelas().add(parcelaVO);
			
		}
        
        getTradeFinNegocVO().setTdiaopercmbio(getTradeFinanceBean().getTradeFinanceVO().getTdiaopercmbio());
        getTradeFinNegocVO().setCindcdembrqpcial(getTradeFinanceBean().getTradeFinanceVO().getCindcdembrqpcial());
        getTradeFinNegocVO().setQprevtembrqcmbio(getTradeFinanceBean().getTradeFinanceVO().getQprevtembrqcmbio());
       
        getTradeFinNegocVO().getObsCotacaoVO().setFpgtocomplcmbio(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getFormapagto());
        
        
        /**
         * Dados Moeda pertencentes ao produto Forfaiting
         */
        if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)){
        	getTradeFinNegocVO().setTdiavalddletra(getTradeFinanceBean().getTradeFinanceVO().getTdiavalddletra());
        	//Data Disponibilidade da Linha campo não definido
        	getTradeFinNegocVO().setVmoedalimgerc(getTradeFinanceBean().getTradeFinanceVO().getVmoedalimgerc());
        	
        	getTradeFinNegocVO().setDataPrevEmbarq(getTradeFinanceBean().getTradeFinanceVO().getDataPrevEmbarq());	
        	getTradeFinNegocVO().setDataPrevDesemb(getTradeFinanceBean().getTradeFinanceVO().getDataPrevDesemb());		 
        	getTradeFinNegocVO().setTdiaopercmbio(getTradeFinanceBean().getTradeFinanceVO().getTdiaopercmbio());
        	 
        }
        
    }

    /**
     * Nome: atualizarSwapStandBy
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarSwapStandBy() {

        /**
         * SWAP / PTAX / SPREAD
         **/
        if (getTradeFinanceBean().getTradeFinanceVO().getCindcdnegocswap() != null && 
        		getTradeFinanceBean().getTradeFinanceVO().getCindcdnegocswap().equals(EnumSimNao.SIM.getDescricao())) {
            	
        	getTradeFinNegocVO().setCindcdnegocswap(EnumSimNaoStr.SIM.getCodigo());
        } else {
            getTradeFinNegocVO().setCindcdnegocswap(EnumSimNaoStr.NAO.getCodigo());
        }
        
        listenerTrocaModalidade(null);

        /**
         * STAND BY
         **/
        if (getTradeFinanceBean().getTradeFinanceVO().getCindcdnegoccarta() != null && 
        		getTradeFinanceBean().getTradeFinanceVO().getCindcdnegoccarta().equals(EnumSimNao.SIM.getDescricao())) {
        	
            getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.SIM.getCodigo());
        } else {
            getTradeFinNegocVO().setCindcdnegoccarta(EnumSimNaoStr.NAO.getCodigo());
        }
        
        if (getTradeFinanceBean().getTradeFinanceVO().getCcomiscartanacio() != null && 
        		getTradeFinanceBean().getTradeFinanceVO().getCcomiscartanacio().equals(EnumSimNao.SIM.getDescricao())) {
        	
            getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.SIM.getCodigo());
        } else {
            getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.NAO.getCodigo());
        }
        if (getTradeFinanceBean().getTradeFinanceVO().getCindcdnegocarbtr() != null && 
        		getTradeFinanceBean().getTradeFinanceVO().getCindcdnegocarbtr().equals(EnumSimNao.SIM.getDescricao())) {
        	
            getTradeFinNegocVO().setCindcdnegocarbtr(EnumSimNaoStr.SIM.getCodigo());
        } else {
            getTradeFinNegocVO().setCindcdnegocarbtr(EnumSimNaoStr.NAO.getCodigo());
        }
        
        // habilita e desabilita campos
        listenerTratarSwap(null);
        listenerTratarCheckMeMn(null);
        
        getTradeFinNegocVO().setCindcdnegoclibor(getTradeFinanceBean().isLibor());
        getTradeFinNegocVO().setCnegocswapfluxo(getTradeFinanceBean().isFluxo());
        getTradeFinNegocVO().setCnegocswapestrg(getTradeFinanceBean().isMeMn());
        getTradeFinNegocVO().setCtpocotactx(getTradeFinanceBean().getTradeFinanceVO().getCtpocotactx());
        getTradeFinNegocVO().setPtxswapcmpdo(getTradeFinanceBean().getTradeFinanceVO().getPtxswapcmpdo());
        
        // Carrega o campo com os dados da consulta
        getTradeFinNegocVO().setTdiavalddletra(getTradeFinanceBean().getTradeFinanceVO().getTdiavalddletra());
    }
    
    /**
     * Nome: atualizarFluxoPagamento
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarFluxoPagamento() {
        
        atualizarFluxoPagamento(Numeros.ZERO);
    }

    /**
     * Nome: atualizarFluxoPagamento
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected int atualizarFluxoPagamento(Integer ndsembcmbiotrade) {
        TrdFinNegParcelaVO objTo = null;
        List<TrdFinNegParcelaVO> listaParcela = new ArrayList<TrdFinNegParcelaVO>();

        int sequencialFluxo = 1;
        boolean flag = true;
        List<TrdFinNegFluxoPagtoVO> listaFluxoPagamento = new ArrayList<TrdFinNegFluxoPagtoVO>();

        Iterator<FluxoPagamentoVO> it = getTradeFinanceBean().getFluxoPgtList().iterator();
        while (it.hasNext() && flag) {
            FluxoPagamentoVO item = (FluxoPagamentoVO) it.next();
            TrdFinNegFluxoPagtoVO fluxoPagamento = new TrdFinNegFluxoPagtoVO();
            
            if(ndsembcmbiotrade.equals(Numeros.ZERO) 
                    || (!ndsembcmbiotrade.equals(Numeros.ZERO) && item.getNdsembcmbiotrade().equals(ndsembcmbiotrade))) {
                
                if(!ndsembcmbiotrade.equals(Numeros.ZERO) && item.getNdsembcmbiotrade().equals(ndsembcmbiotrade)) {
                    
                    flag = false;
                    
                } else if(sequencialFluxo == 1) {
                    
                    // Atualiza data de previsão de desembolso com a primeira data de fluxo de pagamento
                    getViewHelper().setDatePrevDesembolso(SiteUtil.dataMainframeToWeb(item.getDprevtdsembcmbio()));
                }
            
                fluxoPagamento.setSeqFluxoPagto(sequencialFluxo);
                fluxoPagamento.setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());
    
                fluxoPagamento.setNbletonegoccmbio(item.getNbletonegoccmbio());
                fluxoPagamento.setNdsembcmbiotrade(item.getNdsembcmbiotrade());
                fluxoPagamento.setDateFluxoPgto(SiteUtil.dataMainframeToWeb(item.getDprevtdsembcmbio()));
                fluxoPagamento.setDprevtdsembcmbio(item.getDprevtdsembcmbio());
                fluxoPagamento.setJurosCarencia(item.getTdiacarenjuro());
                fluxoPagamento.setVprevtdsembcmbio(item.getVprevtdsembcmbio());
                fluxoPagamento.setTdiacarenprinc(item.getTdiacarenprinc());
                fluxoPagamento.setCfluxoliqdcprinc(item.getCfluxoliqdcprinc());
                fluxoPagamento.setNomePrincPeriodicidade(item.getDfluxoliqdcprinc());
                fluxoPagamento.setPrincQtdParcelas(item.getQpcelatradeprinc());
                fluxoPagamento.setQtdeocorrprinc(item.getQpcelatradeprinc());
                fluxoPagamento.setTdiafinandsemb(item.getTdiafinandsemb());
                fluxoPagamento.setCodJurosPeriodicidade(item.getCfluxoliqdcjuro());
                fluxoPagamento.setNomeJurosPeriodicidade(item.getDfluxoliqdcjuro());
                fluxoPagamento.setJurosQtdParcelas(item.getQpcelatradejuro());
                fluxoPagamento.setQtdeocorrjuros(item.getQpcelatradejuro());
                fluxoPagamento.setCodJurosMomento(item.getCmomencobrcmbio());
                fluxoPagamento.setNomeJurosMomento(item.getDescrmomen());
    
                item = tradeFinanceMonitService.obterFluxoPgtDet(item, getTradeFinNegocVO().getNbletonegoccmbio(), getTradeFinNegocVO().getHinclreghist());
    
                fluxoPagamento.setPrzomediodsemb(item.getPrzomediodsemb());
                
                listaParcela = new ArrayList<TrdFinNegParcelaVO>();
                for (Iterator<FluxoPagamentoVO> iterator = item.getLista().iterator(); iterator.hasNext();) {
                    FluxoPagamentoVO itemParcela = (FluxoPagamentoVO) iterator.next();
    
                    objTo = new TrdFinNegParcelaVO();
    
                    objTo.setTpparcela(itemParcela.getTipojuros());
                    objTo.setNpceladsembtrade(itemParcela.getNpceladsembtrade());
                    objTo.setTdianegocpcela(itemParcela.getTdianegocpcela());
                    objTo.setDvctopcelatrade(itemParcela.getDvctopcelatrade());
                    objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(itemParcela.getDvctopcelatrade()));
                    objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(itemParcela.getDvctopcelatrade()));
                    objTo.setVpcelamesatrade(itemParcela.getVpcelamesatrade());
                    objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(itemParcela.getVpcelamesatrade()));
                    
                    if (itemParcela.getValorPrincipalParcelaFluxoPgto() != null) {
                    	objTo.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(itemParcela.getValorPrincipalParcelaFluxoPgto()));
					}
                    objTo.setValorJurosParcelaFluxoPgto(itemParcela.getValorJurosParcelaFluxoPgto());
                	objTo.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(itemParcela.getValorSaldoDevedorFluxoPgto()));
                    
                    listaParcela.add(objTo);
                }
                fluxoPagamento.setListaParcelasFluxoPgto(listaParcela);
                listaFluxoPagamento.add(fluxoPagamento);
            }
            
            sequencialFluxo++;
        }
        
        getTradeFinNegocVO().setListaFluxos(listaFluxoPagamento);

        getViewHelper().setPrzomediooperd(getTradeFinanceBean().getTradeFinanceVO().getQprzmedcmbio());
        getViewHelper().setPrzomedioopera(SiteUtil.getString(getTradeFinanceBean().getTradeFinanceVO().getQprzmedcmbioano()));
        
        // devolve a ultima posição da lista
        return sequencialFluxo - 1;
    }

    /**
     * Nome: atualizarPrecificacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarPrecificacao() {

        /**
         * Precificação
         **/
        getTrdFinNegPrecificacaoVO().setCprodtservc(getTradeFinanceBean().getTradeFinanceVO().getCprodtservc());
        getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setCbanqrcmbio(getTradeFinanceBean().getTradeFinanceVO().getCbanqrcmbiofndng());
        getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setIbanqrcmbio(getTradeFinanceBean().getTradeFinanceVO().getDbcoextcmbio());
        getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setImunintlcmbio(getTradeFinanceBean().getTradeFinanceVO().getPraca());
        
        getTrdFinNegPrecificacaoVO().getBancoReembolsadorVO().setCbanqrcmbio(getTradeFinanceBean().getTradeFinanceVO().getCbanqrcmbiorcdor());
        
        getTrdFinNegPrecificacaoVO().setValidadecotac(getTradeFinanceBean().getTradeFinanceVO().getTdiaopercmbioprcf());
        getTrdFinNegPrecificacaoVO().setTdiaopercmbioprcf(getTradeFinanceBean().getTradeFinanceVO().getTdiaopercmbioprcf());
        
        getTrdFinNegPrecificacaoVO().setDtcotac(SiteUtil.stringDataWebToMainframe(getTradeFinanceBean().getTradeFinanceVO().getDcotacfndngcmbio()));
        getTrdFinNegPrecificacaoVO().setDataCotacaoFormat(getTradeFinanceBean().getTradeFinanceVO().getDcotacfndngcmbio());
        getTrdFinNegPrecificacaoVO().setDcotacfndngcmbio(getTradeFinanceBean().getTradeFinanceVO().getDcotacfndngcmbio());
        
        getTrdFinNegPrecificacaoVO().setCustoext(SiteUtil.trocarVirgulaPorPonto(getTradeFinanceBean().getTradeFinanceVO().getPtxfixacmbio()));
        getTrdFinNegPrecificacaoVO().setCustoExternoFormat(getTradeFinanceBean().getTradeFinanceVO().getPtxfixacmbio());
        getTrdFinNegPrecificacaoVO().setPtxfixacmbio(getTradeFinanceBean().getTradeFinanceVO().getPtxfixacmbio());
        
        getTrdFinNegPrecificacaoVO().setIsglindcdfonte(getTradeFinanceBean().getTradeFinanceVO().getSimbleconmmoeda());
        getTrdFinNegPrecificacaoVO().setSimbleconmmoeda(getTradeFinanceBean().getTradeFinanceVO().getSimbleconmmoeda());
        getTrdFinNegPrecificacaoVO().setLibor(getTradeFinanceBean().getTradeFinanceVO().getPreclibor());
        getTrdFinNegPrecificacaoVO().setPrzomediodsembm(getTradeFinanceBean().getTradeFinanceVO().getTmesliborcmbio());
        getTrdFinNegPrecificacaoVO().setTmesliborcmbio(getTradeFinanceBean().getTradeFinanceVO().getTmesliborcmbio());
        getTrdFinNegPrecificacaoVO().setSpreadclean(SiteUtil.trocarVirgulaPorPonto(getTradeFinanceBean().getTradeFinanceVO().getVtxliborcmbio()));
        getTrdFinNegPrecificacaoVO().setVtxliborcmbio(getTradeFinanceBean().getTradeFinanceVO().getVtxliborcmbio());
        
        getTrdFinNegPrecificacaoVO().setDlimfndngcmbio(getTradeFinanceBean().getTradeFinanceVO().getDlimfndngcmbio());
        getTrdFinNegPrecificacaoVO().setCindcdeconmmoeda(getTradeFinanceBean().getTradeFinanceVO().getCindcdeconmmoeda());
        
        getTrdFinNegPrecificacaoVO().setComissaodsemblso(getTradeFinanceBean().getTradeFinanceVO().getComissaodsemblso());
        getTrdFinNegPrecificacaoVO().setVlrcomisdsemb(getTradeFinanceBean().getTradeFinanceVO().getVlrcomisdsemb());

        if(getTrdFinNegPrecificacaoVO().getBancoAvisadorVO() == null){
        	getTrdFinNegPrecificacaoVO().setBancoAvisadorVO(new UnidadeExternaVO());
        }
        
        getTradeFinNegocVO().setVtravaliborcmbio(getTradeFinanceBean().getTradeFinanceVO().getVtravaliborcmbio());
        getTradeFinNegocVO().setVimpstnegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getVimpstnegoccmbio());
        getTradeFinNegocVO().setVtxspreadnegoc(getTradeFinanceBean().getTradeFinanceVO().getVtxspreadnegoc());
        getTradeFinNegocVO().setVtxspreadtot(getTradeFinanceBean().getTradeFinanceVO().getVtxspreadtot());
        getTradeFinNegocVO().setViofnegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getViofnegoccmbio());
        getTradeFinNegocVO().setVtxmoracmbio(getTradeFinanceBean().getTradeFinanceVO().getVtxmoracmbio());
        getTradeFinNegocVO().setCbasejuromora(getTradeFinanceBean().getTradeFinanceVO().getCbasejuromora());
        getTradeFinNegocVO().setVmultanegoccmbio(getTradeFinanceBean().getTradeFinanceVO().getVmultanegoccmbio());
        
        //eca
        getTradeFinNegocVO().setCindcdlastrcarta(getTradeFinanceBean().getTradeFinanceVO().getCindcdlastrcarta());
        getTradeFinNegocVO().setCpermtrnsfcarta(getTradeFinanceBean().getTradeFinanceVO().getCpermtrnsfcarta());
        getTradeFinNegocVO().setCindcdcartacnfdo(getTradeFinanceBean().getTradeFinanceVO().getCindcdcartacnfdo());
        getTradeFinNegocVO().setCindcdcartaidpdt(getTradeFinanceBean().getTradeFinanceVO().getCindcdcartaidpdt());
        getTradeFinNegocVO().setCcartaconverecdd(getTradeFinanceBean().getTradeFinanceVO().getCcartaconverecdd());
        
        //NCE
        
        if (getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDadoscpfcnpjf() <= Numeros.ZERO) {
            // tipo CPF
            getViewHelper().setCodCpfCnpjDepositarioSelecionado(Numeros.TRES);
            getTradeFinNegocVO().getObsCotacaoVO().setCpfDeposit(SiteUtil.formatarCpfComponente(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getCpfDeposit(),
                            getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDadoscpfcnpjr(), getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDadoscpfcnpjd()));

        } else {
            // tipo CNPJ
            getViewHelper().setCodCpfCnpjDepositarioSelecionado(Numeros.DOIS);
            getTradeFinNegocVO().getObsCotacaoVO().setCnpjDeposit(SiteUtil.formatarCnpjComponente(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getCnpjDeposit(),
                            getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDadoscpfcnpjf(), getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDadoscpfcnpjr(),
                            getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDadoscpfcnpjd()));
        }

        //LC
        
        if(getTradeFinanceBean().getCotacoesList().getListaCotacoes() != null && getTradeFinanceBean().getCotacoesList().getListaCotacoes().size() > 0){
        	
            ListaCotacoesExternasVO listaCotacao = getTradeFinanceBean().getCotacoesList().getListaCotacoes().get(0);
            
        	getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setCbanqrcmbio(listaCotacao.getCbanqrcmbiofndng());
        	getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().setIbanqrcmbio(listaCotacao.getNbanqrcmbiofndng());
        	
        	getTrdFinNegPrecificacaoVO().getBancoAvisadorVO().setCbanqrcmbio(listaCotacao.getCbanqrcmbiorcdor());
        	getTrdFinNegPrecificacaoVO().getBancoAvisadorVO().setIbanqrcmbio(listaCotacao.getNbanqrcmbiorcdor());
        	
        	getTrdFinNegPrecificacaoVO().getBancoReembolsadorVO().setCbanqrcmbio(listaCotacao.getCbanqrcmbioaviso());
        	getTrdFinNegPrecificacaoVO().getBancoReembolsadorVO().setIbanqrcmbio(listaCotacao.getNbanqrcmbioaviso());
        	
            List<ListaDespesasVO> listDespesa = tradeFinanceMonitService.obterDespesas(listaCotacao.getCfndng(), getTradeFinNegocVO().getNbletonegoccmbio(), getTradeFinNegocVO().getHinclreghist());
            
            if(listDespesa != null && listDespesa.size() > 0){
                getTradeFinNegocVO().setDespesaVO(listDespesa.get(0));
            }
        }
        // GARANTIAS
        // Monta tabela para selecionar a despesa
        getTradeFinNegocVO().setListaRespDesp(tradeFinanceBean.getResponsavelDespList().getListaDespesa());
        getViewHelper().setComboFuncao(selectItemBean.getComboFuncao());
        getTradeFinNegocVO().getCotacaoFundingVO().setDlimfndngcmbio(tradeFinanceBean.getResponsavelDespList().getDlimfndngcmbio());
        getTradeFinNegocVO().getDespesaVO().setFormataDespesaPorconta(tradeFinanceBean.getTradeFinanceVO().getFormataDespesaPorConta());
        
        ListaDespesasVO listaDespesasVO =  getTradeFinNegocVO().getDespesaVO();
        
        getTradeFinNegocVO().getDespesaVO().setCtpodespcmbio(listaDespesasVO.getCtpodespcmbio());
        getTradeFinNegocVO().getDespesaVO().setNtpodespcmbio(listaDespesasVO.getNtpodespcmbio());
        
        getTradeFinNegocVO().getDespesaVO().setCidtfdrespdesp(listaDespesasVO.getCidtfdrespdesp());
        getTradeFinNegocVO().getDespesaVO().setNidtfdrespdesp(listaDespesasVO.getNidtfdrespdesp());
        
    }
    
    /**
     * Nome: atualizarComissaoInterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarComissaoInterna() {
        
        atualizarComissaoInterna(Numeros.ZERO);
    }
    
    /**
     * Nome: atualizarComissaoInterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarComissaoInterna(int indexFluxoPagamento) {

        TrdFinNegComissaoVO itemComissaoInterna = new TrdFinNegComissaoVO();
        List<TrdFinNegComissaoVO> listaComissaoInternaTemp = new ArrayList<TrdFinNegComissaoVO>();

        
		// Para o produto CARTA DE CRÉDITO DE IMPORTAÇÃO (2018), a "comissão cobrado no brasil" é tratada no grid de comissão interna
		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	        if (getTradeFinanceBean().getTradeFinanceVO().getCcomiscartanacio() != null && 
	        		getTradeFinanceBean().getTradeFinanceVO().getCcomiscartanacio().equals(EnumSimNao.SIM.getDescricao())) {
	        	
	            getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.SIM.getCodigo());
	        } else {
	            getTradeFinNegocVO().setCcomiscartanacio(EnumSimNaoStr.NAO.getCodigo());
	        }
		}
        
        // Carrega todas as comissões
        if(indexFluxoPagamento == Numeros.ZERO) {
            for (ComissaoInternaVO item : getTradeFinanceBean().getComissaoIntList()) {
                
                itemComissaoInterna = new TrdFinNegComissaoVO();
                
                if(getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0){
                    
                    // relacionamento entre fluxo de pagamento e comissão interna é feita pela possição na lista (1x1)
                    int indexFluxoPgto = listaComissaoInternaTemp.size();
                    TrdFinNegFluxoPagtoVO _fluxoPgto = getTradeFinNegocVO().getListaFluxos().get(indexFluxoPgto);
                    
                    itemComissaoInterna.setTdiafinandsemb(_fluxoPgto.getTdiafinandsemb());
                    itemComissaoInterna.setTdiaopercmbio(_fluxoPgto.getTdiaopercmbio());
                    itemComissaoInterna.setVprevtdsembcmbio(_fluxoPgto.getVprevtdsembcmbio());
                }
                
                listaComissaoInternaTemp.add(loadComissaoInterna(itemComissaoInterna, item));
            }
        } 
        
        // Carrega apenas a comissão referente ao fluxo de pagamento
        else if (getTradeFinanceBean().getComissaoIntList().size() > 0 
                && getTradeFinanceBean().getComissaoIntList().size() >= indexFluxoPagamento) {
            
            ComissaoInternaVO item = getTradeFinanceBean().getComissaoIntList().get(indexFluxoPagamento - 1);
            TrdFinNegFluxoPagtoVO _fluxoPgto = getTradeFinNegocVO().getListaFluxos().get(0);
            
            itemComissaoInterna.setTdiafinandsemb(_fluxoPgto.getTdiafinandsemb());
            itemComissaoInterna.setTdiaopercmbio(_fluxoPgto.getTdiaopercmbio());
            itemComissaoInterna.setVprevtdsembcmbio(_fluxoPgto.getVprevtdsembcmbio());
            
            listaComissaoInternaTemp.add(loadComissaoInterna(itemComissaoInterna, item));
        }
        
        // Carrega lista de comissões interna no bean de negociação
        getTradeFinNegocVO().setListaComissaoInterna(listaComissaoInternaTemp);
        
        trocaCobrancaComissao();
        
        // Pega o primeiro item da lista para montar os campos comum entre as comissões
        getViewHelper().setItemSelecListaComissaoInterna(0);
        
        if (getTradeFinNegocVO().getListaComissaoInterna().size() > 0) {
        	setItemListaComissaoInterna(getTradeFinNegocVO().getListaComissaoInterna().get(getViewHelper().getItemSelecListaComissaoInterna()));
		}
        getViewHelper().setTipoCobrancaComissao(getItemListaComissaoInterna().getCcobrcomisintrn());
        getViewHelper().setVmincobrcomis(getItemListaComissaoInterna().getVmincobrcomis());
        getViewHelper().setCodMoedaComissao(getItemListaComissaoInterna().getCindcdeconmmoeda());
        getViewHelper().setCodComissaoSobre(getItemListaComissaoInterna().getCcobrcomiscmbio());
        getViewHelper().setCfluxoperdccmbio(getItemListaComissaoInterna().getCfluxoperdccmbio());
        getViewHelper().setCodMomentoComissao(getItemListaComissaoInterna().getCodMomentoComissao());
        
        if (getTradeFinNegocVO().getProduto().isGarantia() 
                        || getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
                        && getItemListaComissaoInterna().getCcobrcomiscmbio() != null) {
            getViewHelper().setCodComisSobre(getItemListaComissaoInterna().getCcobrcomiscmbio());
        }
        
        /* TIPO DE COBRANCA DE COMISSAO - VALOR */
        if (getViewHelper().getTipoCobrancaComissao() == 1) {
            
            getViewHelper().setValueComissaoCobranca(getItemListaComissaoInterna().getVlxtotalcomis());
        }        
        /* PERCENTUAL FLAT DE COMISSAO */
        else if (getViewHelper().getTipoCobrancaComissao() == 2 || getViewHelper().getTipoCobrancaComissao() == 3) {
            getViewHelper().setValueComissaoCobranca(getItemListaComissaoInterna().getPjuronegoccmbio());
        }
        
        // inicia spread negociado
        getTradeFinNegocVO().setVtxspreadnegoc(itemComissaoInterna.getVtxspreadnegoc());
        getTradeFinNegocVO().setVtxspreadtot(itemComissaoInterna.getVtxspreadtot());

        tratarBotaoAltDetComissInterna();
        aplicarMascaraComissaoInterna();
    }
    
    private TrdFinNegComissaoVO loadComissaoInterna(TrdFinNegComissaoVO itemComissaoInterna, ComissaoInternaVO item) {
        
        itemComissaoInterna.setNcomisintrncmbio(item.getNcomisintrncmbio());
        itemComissaoInterna.setCcobrcomiscmbio(item.getCcobrcomiscmbio());
        itemComissaoInterna.setCindcdeconmmoeda(item.getCindcdeconmmoeda());
        itemComissaoInterna.setPeriodicidadeComissao(item.getIfluxoperdccmbio());
        itemComissaoInterna.setMomentoComissao(item.getDescrmomento());
        itemComissaoInterna.setCodMomentoComissao(item.getCmomencobrcmbio());
        itemComissaoInterna.setCfluxoperdccmbio(item.getCfluxoperdccmbio());
        itemComissaoInterna.setCodMomentoComissao(item.getCmomencobrcmbio());
        itemComissaoInterna.setPcomisnegoccmbio(item.getPcomisnegoccmbio());
        itemComissaoInterna.setCcobrcomisintrn(item.getCcobrcomisintrn());
        itemComissaoInterna.setVtxspreadnegoc(item.getVtxspreadnegoc());
        itemComissaoInterna.setVtxspreadtot(item.getVtxspreadtot());
        itemComissaoInterna.setPtxflatpnalt(item.getPtxflatpnalt());
        itemComissaoInterna.setVmincobrcomis(item.getVmincobrcomis());
        itemComissaoInterna.setVlxtotalcomis(item.getVlxtotalcomis());
        itemComissaoInterna.setVprevtcomiscmbio(item.getVprevtcomiscmbio());
        
        itemComissaoInterna.setPjuronegoccmbio(item.getPcomisnegoccmbio());
        itemComissaoInterna.setVlxcomiscmbio(item.getVprevtcomiscmbio());
        
        itemComissaoInterna.setDsccustototal(getTradeFinanceBean().getTradeFinanceVO().getDescctotal());
        
        if(getFuncaoExecutando() != EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo()) {
            if (!SiteUtil.isValueZero(item.getVtxspreadaprov())) {
                itemComissaoInterna.setPtxcustototal(item.getVtxspreadaprov());
            } else {
                itemComissaoInterna.setPtxcustototal(getTradeFinanceBean().getTradeFinanceVO().getVtxspreadaprov());
            }
        }
        
        // LC / GARANTIA nao tem a data de previsao apra desembolso. Considerar a data de inclusao do registro
        if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) || getTradeFinNegocVO().getProduto().isGarantia()){
            itemComissaoInterna.setDataComissaoFormat(getTradeFinNegocVO().getDinclreg());
            itemComissaoInterna.setDateComissao(SiteUtil.dataMainframeToWeb(getTradeFinNegocVO().getDinclreg()));
        }else{
            itemComissaoInterna.setDataComissaoFormat(item.getDprevtdsembcmbio());
            itemComissaoInterna.setDateComissao(SiteUtil.dataMainframeToWeb(item.getDprevtdsembcmbio()));
        }
       
        // Carrega parcelas da comissão Interna
        List<ComissaoInternaVO> listaTemp = tradeFinanceMonitService.comissaoInternaDet(getTradeFinNegocVO().getNbletonegoccmbio(),
                item.getNcomisintrntrade(), getTradeFinNegocVO().getHinclreghist());
        
        itemComissaoInterna.setQpcelacmbiotrade(listaTemp.size());

        List<TrdFinNegParcelaVO> listaParcela = new ArrayList<TrdFinNegParcelaVO>();
        for (Iterator<ComissaoInternaVO> iterator = listaTemp.iterator(); iterator.hasNext();) {
            ComissaoInternaVO itemParcela = (ComissaoInternaVO) iterator.next();

            TrdFinNegParcelaVO objTo = new TrdFinNegParcelaVO();

            objTo.setNpcelacomis(itemParcela.getNpcelacomisintrn());
            objTo.setTdianegocpcela(itemParcela.getPrazoparcela());
            objTo.setDvctopcelatrade(SiteUtil.stringDataWebToMainframe(itemParcela.getDvctopcelatrade()));
            objTo.setVencimentoComissao(SiteUtil.stringDataMainframeToWeb(itemParcela.getDvctopcelatrade()));
            objTo.setVpcelacomiscmbio(itemParcela.getVpcelacomiscmbio());
            objTo.setValorParcelaComissao(SiteUtil.formatarValorWeb(itemParcela.getVpcelacomiscmbio()));
            objTo.setVcustofincrcmbio(itemParcela.getVprevtcomiscmbio());

            listaParcela.add(objTo);
        }
        
        itemComissaoInterna.setListaParcelasComissao(listaParcela);
        
        return itemComissaoInterna;
    }

    /**
     * Nome: atualizarMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarMercadoria() {
        
        atualizarMercadoria(Numeros.ZERO);
    }
    
    /**
     * Nome: atualizarMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarMercadoria(Integer ndsembcmbiotrade) {

        boolean flag = true;
        List<TrdFinNegMercadoriaVO> listaMercadoriaTemp = new ArrayList<TrdFinNegMercadoriaVO>();
        Iterator<MercadoriaVO> it = getTradeFinanceBean().getMercadoriaList().iterator();
        
        while (it.hasNext() && flag) {
            MercadoriaVO item = (MercadoriaVO) it.next();
            TrdFinNegMercadoriaVO itemMercadoria = new TrdFinNegMercadoriaVO();
            
            if (ndsembcmbiotrade.equals(Numeros.ZERO)
                    || (!ndsembcmbiotrade.equals(Numeros.ZERO) && item.getNdsembcmbiotrade().equals(ndsembcmbiotrade))) {
                
                itemMercadoria.setCmcadoopercmbio(item.getCmcadoopercmbio());
                itemMercadoria.setRmcadoopercmbio(item.getRmcadoopercmbio());
                itemMercadoria.setNmcadocmbiotrade(item.getNmcadocmbiotrade());
                itemMercadoria.setCpais(item.getCpais());
                itemMercadoria.setCpaisembrq(item.getCpaisembrq());
                itemMercadoria.setNomePaisEmbrq(item.getIpaisembrq());
                itemMercadoria.setNomeCpais(item.getIpais());
                itemMercadoria.setCpaisbnefc(item.getCpaisbnefc());
                itemMercadoria.setNomeCpaisbnefc(item.getIpaisbnefc());
                itemMercadoria.setIpssoacmbio(item.getIunicpssoamcado());
                itemMercadoria.setCunicpssoamcado(item.getCunicpssoamcado());
                itemMercadoria.setDprevtembrq(SiteUtil.dataMainframeToWeb(item.getDprevtembrq().replace("/", ".")));
                itemMercadoria.setDataPrevEmbFormat(item.getDprevtembrq());
                itemMercadoria.setNdsembcmbiotrade(item.getNdsembcmbiotrade());
                
                listaMercadoriaTemp.add(itemMercadoria);
                
                if (!item.getNdsembcmbiotrade().equals(Numeros.ZERO) && item.getNdsembcmbiotrade().equals(ndsembcmbiotrade)) {
                    flag = false;
                }
            }
        }
        
        getTradeFinNegocVO().setListaMercadoria(listaMercadoriaTemp);
        getTradeFinNegocVO().setCsegurtrnspmcado(EnumSimNaoStr.fromDescricao(getTradeFinanceBean().getTradeFinanceVO().getCsegurtrnspmcado()).getCodigo());
        getTradeFinNegocVO().setCsegurmcadoorgnz(EnumSimNaoStr.fromDescricao(getTradeFinanceBean().getTradeFinanceVO().getCsegurmcadoorgnz()).getCodigo());
    }

    /**
     * Nome: atualizarOperVinculadaRofTarifas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarOperVinculadaRofTarifas() {

        /* Operação Vinculada */
        List<TrdFinNegOperVincVO> listaOperacaoVincTemp = new ArrayList<TrdFinNegOperVincVO>();
        for (OperacaoVinculadaVO item : getTradeFinanceBean().getOprVincList()) {
            TrdFinNegOperVincVO itemOperacaoVinc = new TrdFinNegOperVincVO();
            itemOperacaoVinc.setNbletonegoccmbio(item.getNbletonegocvnclo());
            itemOperacaoVinc.setNbletocmbioano(item.getNbletocmbioano());
            itemOperacaoVinc.setIindcdeconmmoeda(item.getIindcdeconmmoeda());
            itemOperacaoVinc.setValorMoeda(item.getVnegocmoedaestr());
            itemOperacaoVinc.setIprodtservc(item.getIprodtservc());
     //       itemOperacaoVinc.setCindcdvncloimpor(item.getCindcdvncloimpor());
            listaOperacaoVincTemp.add(itemOperacaoVinc);
        }
        getTradeFinNegocVO().setListaOperacaoVinculada(listaOperacaoVincTemp);

        /* DADOS ROF*/
        getTradeFinNegocVO().getObsCotacaoVO().setNomerof(getTradeFinanceBean().
                        getTradeFinanceVO().getObsCotacaoVO().getNomerof());

        String cpfStr = SiteUtil.removeNaoNumericos(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getCpfrof());
        CpfDataType cpf = new CpfDataType();
        if (cpfStr == null || cpfStr.length() <= Numeros.ZERO) {
            cpfStr = "";
        } else {
            Integer numero = SiteUtil.nullToInteger(cpfStr.substring(0, cpfStr.length()-2));
            Integer dv = SiteUtil.nullToInteger(cpfStr.substring(cpfStr.length()-2, cpfStr.length()));
            cpf = SiteUtil.formatarCpfComponente(cpf, numero, dv);
        }
        getTradeFinNegocVO().getObsCotacaoVO().setRof_cpf(cpf);

        getTradeFinNegocVO().getObsCotacaoVO().setCargorof(getTradeFinanceBean().
                        getTradeFinanceVO().getObsCotacaoVO().getCargorof());
        getTradeFinNegocVO().getObsCotacaoVO().setTelrof(getTradeFinanceBean().
                        getTradeFinanceVO().getObsCotacaoVO().getTelrof());
        getTradeFinNegocVO().getObsCotacaoVO().setEmailrof(getTradeFinanceBean().
                        getTradeFinanceVO().getObsCotacaoVO().getEmailrof());
        
        /* Tarifas */
        List<TrdFinNegTarifaVO> listaTarifaTemp = new ArrayList<TrdFinNegTarifaVO>();
        for (TarifaVO item : getTradeFinanceBean().getTarifaList()) {
            TrdFinNegTarifaVO itemTarifa = new TrdFinNegTarifaVO();
            itemTarifa.setCcondceconc(item.getCcondceconc());
            itemTarifa.setDescrdesptarif(item.getItpodespcmbio());
            itemTarifa.setCindcddesptarf(item.getCindcddesptarf());
            itemTarifa.setCindcdeconmmoeda(item.getCindcdeconmmoeda());
            itemTarifa.setCtpodespcmbio(item.getCtpodespcmbio());
            itemTarifa.setIsglindcdfonte(item.getIsglindcdfonte());
            itemTarifa.setItpodespcmbio(item.getItpodespcmbio());
            itemTarifa.setVdespbletocmbio(SiteUtil.formatarValorWeb(item.getVdespbletocmbio()));

            listaTarifaTemp.add(itemTarifa);
        }
        getTradeFinNegocVO().setListaTarifas(listaTarifaTemp);
    }

    /**
     * Nome: atualizarComissaoExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarComissaoExterna() {

        List<ComissaoExternaVO> listaTemp = new ArrayList<ComissaoExternaVO>();
        TrdFinNegParcelaVO objTo = null;
        List<TrdFinNegParcelaVO> listaParcela = new ArrayList<TrdFinNegParcelaVO>();

        /* Comissão Externa */
        ComissaoCollection listaComissaoExternaTemp = new ComissaoCollection();
        
        for (Iterator<IComissaoExterna> it = getTradeFinanceBean().getComissaoExtList().iterator(); it.hasNext();) {
            ComissaoExternaVO item = (ComissaoExternaVO) it.next();
            TrdFinNegComissaoVO itemComissaoExterna = new TrdFinNegComissaoVO();

            itemComissaoExterna.setCcondceconc(item.getccondceconc());
            itemComissaoExterna.setNcomisextertrade(item.getncomisextertrade());
            itemComissaoExterna.setCperdcjurocmbio(item.getcperdcjurocmbio());
            
            itemComissaoExterna.setCindcdeconmmoeda(item.getcindcdeconmmoeda());
            itemComissaoExterna.setCfluxoperdccmbio(item.getcfluxoperdccmbio());
            itemComissaoExterna.setTipoComissaoExt(item.geticondeconc());
            itemComissaoExterna.setVprevtcomiscmbio(item.getvpcelacomiscmbio());
            itemComissaoExterna.setVlxtotalcomis(item.getvpcelacomiscmbio());
            itemComissaoExterna.setPjuronegoccmbio(item.getpcomisnegoccmbio());
            itemComissaoExterna.setPeriodoTaxa(item.getiperdcjurocmbio());
            itemComissaoExterna.setMoedaComissao(item.getisglindcdfonte());
            itemComissaoExterna.setPeriodicidadeComissao(item.getifluxoperdccmbio());
            itemComissaoExterna.setCodMomentoComissao(item.getcmomencobrcmbio());
            itemComissaoExterna.setMomentoComissao(item.getdescrmomento());
            itemComissaoExterna.setQpcelacmbiotrade(item.getqpcelacmbiotrade());
            
            itemComissaoExterna.setTipoComissao(item.getTipoComissao());

            listaTemp = tradeFinanceMonitService.comissaoExternaDet(getTradeFinNegocVO().getNbletonegoccmbio(),
                    item.getncomisextertrade(), getTradeFinNegocVO().getHinclreghist());

            listaParcela = new ArrayList<TrdFinNegParcelaVO>();
            for (Iterator<ComissaoExternaVO> iterator = listaTemp.iterator(); iterator.hasNext();) {
                ComissaoExternaVO itemParcela = (ComissaoExternaVO) iterator.next();

                objTo = new TrdFinNegParcelaVO();

                objTo.setNpcelacomis(itemParcela.getnpcelacomisexter());
                objTo.setTdianegocpcela(itemParcela.getprazoparcela());
                objTo.setDvctopcelatrade(SiteUtil.stringDataWebToMainframe(itemParcela.getdvctopcelatrade()));
                objTo.setVencimentoComissao(SiteUtil.stringDataMainframeToWeb(itemParcela.getdvctopcelatrade()));
                objTo.setVpcelacomiscmbio(itemParcela.getvpcelacomiscmbio());
                objTo.setValorParcelaComissao(SiteUtil.formatarValorWeb(itemParcela.getvpcelacomiscmbio()));
                objTo.setVcustofincrcmbio("");

                listaParcela.add(objTo);
            }
            itemComissaoExterna.setListaParcelasComissao(listaParcela);

            listaComissaoExternaTemp.add(itemComissaoExterna);
        }
        getTradeFinNegocVO().setListaComissaoExterna(listaComissaoExternaTemp);
    }

    	/**
    	* Nome: atualizarModeloBoleto
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 01/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    protected void atualizarModeloBoleto() {
        getTradeFinNegocVO().setCmodcontrcmbio(getTradeFinanceBean().getTradeFinanceVO().getCmodcontrcmbio());
        getTradeFinNegocVO().setDmodcontrcmbio(getTradeFinanceBean().getTradeFinanceVO().getDmodcontrcmbio());
    }
    
    /**
     * Nome: atualizarObs
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    protected void atualizarDadosObsCompl() {
		getTradeFinNegocVO().setObsCotacaoVO(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO());
		getTradeFinNegocVO().setDivergente(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().getDivergente());
	}

    protected void atualizarDivergente() {
        getTradeFinNegocVO().setDivergente(getTradeFinanceBean().getTradeFinanceVO().getObsCotacaoVO().
                        getDivergente());
      
    }
    
    
    
    /****************************************
     * FIM - PREPARAR DADOS PARA MANUTENÇÂO *
     ****************************************/
    
    /****************************************
     * INICIO - ROTINAS TOMADOR             *
     ****************************************/
    public void openModalTomador(AjaxBehaviorEvent e){
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalTomador <<<<<<<<<<<");

    		benefModalBean.setBeneficiario(tomadorModal);
    		benefModalBean.getViewHelper().setNomeCampo("Tomador");
            benefModalBean.getViewHelper().setNomeStateIdListaSelBeneficiario("NPCDIAFG");
            benefModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalTomador");
            benefModalBean.openModal();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalTomador <<<<<<<<<<<");
    	}
    	
    }
    
    /****************************************
     * FIM - ROTINAS TOMADOR             *
     ****************************************/
    
    /****************************************
     * INICIO - ROTINAS FORFAITING          *
     ****************************************/
    	/**
    	* Nome: tratarRefreshForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 14/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void tratarRefreshForfaiting() {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.tratarRefreshForfaiting <<<<<<<<<<<");
            
            if (getDesembolsoForfaitingVO().getEventoForfaiting() > Numeros.NUM10) {
                if (EnumTradeFinance.EVENTO_CALC_TAXAS_OPERACAO.getCodigo().equals(getDesembolsoForfaitingVO().
                                getEventoForfaiting())) {
                    calcTaxasOperacaoForfaiting();
                    getDesembolsoForfaitingVO().setEventoForfaiting(Numeros.NUM0);
                }
                if (EnumTradeFinance.EVENTO_CALC_TAXAS_DESEMBOLSO.getCodigo().equals(getDesembolsoForfaitingVO().
                                getEventoForfaiting())) {
                    calcTaxasDesembolsoForfaiting();
                    getDesembolsoForfaitingVO().setEventoForfaiting(Numeros.NUM0);
                }
                
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.tratarRefreshForfaiting <<<<<<<<<<<");
        }
        
    }
    	/**
    	* Nome: listenerTratarOpcaoJuros
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 14/05/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTratarOpcaoJuros(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarOpcaoJuros <<<<<<<<<<<");

    		TradeFinanceDesembolsoVO salvaDesembolso = null;
    		
    		if (getListaDesembolso().size() > Numeros.ZERO) {
                NpcFacesUtils.addInfoModalMessage("Lista de Desembolso já associada.", false);
                getTradeFinNegocVO().setCtpojurotrade(getTxForfaitingVO().getJurosembded());
                return;
            }
    		salvaDesembolso = getDesembolsoForfaitingVO();
    		setDesembolsoForfaitingVO(new TradeFinanceDesembolsoVO());
    		getDesembolsoForfaitingVO().setPtxjurofndng(salvaDesembolso.getPtxjurofndng());
    		getDesembolsoForfaitingVO().setTdiafinandsemb(salvaDesembolso.getTdiafinandsemb());
    		
    		calcTaxasOperacaoForfaiting();
    		calcTaxasDesembolsoForfaiting();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarOpcaoJuros <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerTrocaMoedaOperForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaMoedaOperForfaiting(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaMoedaOperForfaiting <<<<<<<<<<<");

    		getTrdFinNegPrecificacaoVO().setCindcdeconmmoeda(tradeFinNegocVO.getCindcdeconmmoeda());
    		getTrdFinNegPrecificacaoVO().setPrzomediodsemb(tradeFinNegocVO.getTdiaopercmbio());
    		getTrdFinNegPrecificacaoVO().setCprodtservc(tradeFinNegocVO.getCprodtservc());

    		setBancoCorrespondenteParametro();

    		calcularCustoExternoForfaiting();
    		getDesembolsoForfaitingVO().setPtxjurofndng(SiteUtil.trocarPontoPorVirgula(getTrdFinNegPrecificacaoVO().getSpreadclean()));
    		calcularValorLimite();
    		calcCustoTotalForfaiting();
    		calcTaxasDesembolsoForfaiting();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaMoedaOperForfaiting <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerTrocaValorMeForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaValorMeForfaiting(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaValorMeForfaiting <<<<<<<<<<<");

    		if (getTradeFinNegocVO().getVnegocmoedaestrg().contains(",") == false) {
    			getTradeFinNegocVO().setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg().concat(",00"));
    		}
    		setBancoCorrespondenteParametro();
    		calcularValorLimite();
    		calcTaxasOperacaoForfaiting();
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaValorMeForfaiting <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
    	* Nome: validarDatas
    	* 
    	* Propósito: Verifica se a data é um dia util e se respeita a regra de dois dias uteis à frente
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 12/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public Boolean validarDataDiaUtil(Date dataCtc){
          
        if(SiteUtil.comparaDatas(SiteUtil.toDay(), dataCtc) > 0 
                || !getCommonService().validarDiaUtil(dataCtc, Numeros.ZERO, "1", 0, getTrdFinNegMercadoriaVO().getCpaisbnefc(), getTradeFinNegocVO().getCeconmmoedadsemb())){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    	/**
    	* Nome: trocaPrazoFinancForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void trocaPrazoFinancForfaiting() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.trocaPrazoFinancForfaiting <<<<<<<<<<<");

    		if(!SiteUtil.isEmptyOrNull(tradeFinNegocVO.getVnegocmoedaestrg()) &&
    			!SiteUtil.isValueZero(getTradeFinNegocVO().getVnegocmoedaestrg())) {
	    		getTrdFinNegPrecificacaoVO().setCindcdeconmmoeda(tradeFinNegocVO.getCindcdeconmmoeda());
	    		getTrdFinNegPrecificacaoVO().setPrzomediodsemb(tradeFinNegocVO.getTdiaopercmbio());
	    		getTrdFinNegPrecificacaoVO().setCprodtservc(tradeFinNegocVO.getCprodtservc());
	    		
	    		calcularCustoExternoForfaiting();
	    		getDesembolsoForfaitingVO().setPtxjurofndng(SiteUtil.trocarPontoPorVirgula(getTrdFinNegPrecificacaoVO().getSpreadclean()));
	    		getDesembolsoForfaitingVO().setTdiafinandsemb(tradeFinNegocVO.getTdiaopercmbio());
	    		
	    		calcCustoTotalForfaiting();
	    		calcTaxasOperacaoForfaiting();
	    		calcTaxasDesembolsoForfaiting();
    		}
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.trocaPrazoFinancForfaiting <<<<<<<<<<<");
    	}
    	
    }

    /**
	* Nome: listenerTrocaPrazoFinancForfaiting
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	*/
	public void listenerTrocaPrazoFinancForfaiting(AjaxBehaviorEvent e) {
		
		try{
			getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaPrazoFinancForfaiting <<<<<<<<<<<");
	
			trocaPrazoFinancForfaiting();
	
		}finally{
			getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaPrazoFinancForfaiting <<<<<<<<<<<");
		}
		
	}
    
	/**
	* Nome: listenerTrocaLiborTravadaOperacao
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 23/08/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public void listenerTrocaLiborTravadaOperacao(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaLiborTravadaOperacao <<<<<<<<<<<");

    		calcCustoTotalForfaiting();
    		calcTaxasOperacaoForfaiting();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaLiborTravadaOperacao <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerTrocaSpreadNegForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaSpreadNegForfaiting(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaSpreadNegForfaiting <<<<<<<<<<<");

            getTradeFinNegocVO().setVtxspreadnegoc(getItemListaComissaoInterna().getVtxspreadnegoc());
    		calcCustoTotalForfaiting();
    		calcTaxasOperacaoForfaiting();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaSpreadNegForfaiting <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerTrocaValorDesembolso
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaValorDesembolso(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaValorDesembolso <<<<<<<<<<<");

    		if (validarValorDesembolsoForfaiting(EnumTradeFinance.DIGITACAO_VALOR.getCodigo()) == false) {
                return;
            }

            calcTaxasDesembEmbutidos();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaValorDesembolso <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerTrocaValorSaque
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaValorSaque(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaValorSaque <<<<<<<<<<<");

            calcTaxasDesembDeduzidos();
    		
    		validarValorDesembolsoForfaiting(EnumTradeFinance.DIGITACAO_VALOR.getCodigo());
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaValorSaque <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerIncluirLiborTravadaOperacao
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerIncluirLiborTravadaOperacao(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirLiborTravadaOperacao <<<<<<<<<<<");
    		
    		liborTravadaModalBean.setTradeFinNegocVO(getTradeFinNegocVO());
    		desembolsoForfaitingVO.setEventoForfaiting(Numeros.NUM1);
    		liborTravadaModalBean.setDesembolsoForfaitingVO(desembolsoForfaitingVO);
    		liborTravadaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalLiborTravada");
    		liborTravadaModalBean.incluirLiborTravada();

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirLiborTravadaOperacao <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerIncluirLiborTravadaDesembolso
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerIncluirLiborTravadaDesembolso(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirLiborTravadaDesembolso <<<<<<<<<<<");
    		incluirLiborTravadaDesembolso(EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo());
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirLiborTravadaDesembolso <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerIncluirLiborTravadaInclDesembolso
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerIncluirLiborTravadaInclDesembolso(AjaxBehaviorEvent e) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirLiborTravadaInclDesembolso <<<<<<<<<<<");
            incluirLiborTravadaDesembolso(EnumTradeFinance.ACESSO_INCLUIR_DESEMBOLSO_FORFAITING.getCodigo());
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirLiborTravadaInclDesembolso <<<<<<<<<<<");
        }
        
    }
    
    	/**
    	* Nome: validarValorDesembolsoForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 30/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private boolean validarValorDesembolsoForfaiting(Integer evento) {
        
        Double valorME = 0D;
        Double valorDesembolsoTeste = 0D;
        Double valorDesembolsoItem = 0D;
        Boolean bAbout = false;
        Double percAbout = 0D;
        Double valorLimite = 0D;
        
        valorME = SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(getTradeFinNegocVO().getVnegocmoedaestrg()));
        valorDesembolsoTeste = SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(getDesembolsoForfaitingVO().getVprevtdsembcmbio()));
        bAbout = getTradeFinNegocVO().getCcobrcomisadcio().equals("1") ;        
        percAbout = SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(getTradeFinNegocVO().getPcobervarprodt()));
        if(bAbout)
        	valorLimite = valorME * (1 + (percAbout / 100));

        if (evento.equals(EnumTradeFinance.DIGITACAO_VALOR.getCodigo())) {
            if(bAbout) {
	            if (valorDesembolsoTeste.compareTo(valorLimite) > Numeros.ZERO) {
	                NpcFacesUtils.addInfoModalMessage("Valor de Desembolso maior que Valor ME + About", false);
	                return false;
	            }
            }
	        else
	            if (valorDesembolsoTeste.compareTo(valorME) > Numeros.ZERO) {
	                NpcFacesUtils.addInfoModalMessage("Valor de Desembolso maior que Valor ME", false);
	                return false;
	            }
            return true;
        }

        if (evento.equals(EnumTradeFinance.BOTAO_INCLUIR.getCodigo())) {
            if (getListaDesembolso().size() > Numeros.ZERO) {
                for (Iterator<TradeFinanceDesembolsoVO> iterator = listaDesembolso.iterator(); iterator.hasNext();) {
                    TradeFinanceDesembolsoVO item = (TradeFinanceDesembolsoVO) iterator.next();
                    
                    valorDesembolsoItem = SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(item.getVprevtdsembcmbio()));
                    valorDesembolsoTeste = valorDesembolsoTeste + valorDesembolsoItem;
                }

                if(bAbout) {
	                if (valorDesembolsoTeste.compareTo(valorLimite) > Numeros.ZERO) {
	                    NpcFacesUtils.addInfoModalMessage("Somatória de Desembolsos maior que Valor ME + About", false);
	                    return false;
	                }
                }
	            else
	                if (valorDesembolsoTeste.compareTo(valorME) > Numeros.ZERO) {
	                    NpcFacesUtils.addInfoModalMessage("Somatória de Desembolsos maior que Valor ME", false);
	                    return false;
	                }
			} else {
				if (valorDesembolsoTeste > Numeros.ZERO) {
	                if(bAbout) {
						if (valorDesembolsoTeste.compareTo(valorLimite) > Numeros.ZERO) {
							NpcFacesUtils.addInfoModalMessage("Valor de Desembolso maior que Valor ME + About", false);
							return false;
						}
	                }
					else
						if (valorDesembolsoTeste.compareTo(valorME) > Numeros.ZERO) {
							NpcFacesUtils.addInfoModalMessage("Valor de Desembolso maior que Valor ME", false);
							return false;
						}
            	}
            }
            return true;
        }
        
        return true;
    }

    	/**
    	* Nome: atualizarSaldoDesembolsar
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 30/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    protected boolean atualizarSaldoDesembolsar(Integer evento) {
        
        Double valorSaldoCalc = 0D;
        String valorSaldoStr = null;
        Double valorDesembolsoItem = 0D;
        String[] partesValor = null;
        
        if (evento.equals(EnumTradeFinance.EVENTO_INCLUIR_EXCLUIR_DESEMBOLSO.getCodigo())) {
            
            // Uma vez alterada a lista de desembolso, não permite a baixa do saldo
            getDesembolsoForfaitingVO().setBaixarSaldo(false);
            
            valorSaldoCalc = SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(getTradeFinNegocVO().
                            getVnegocmoedaestrg()));

            if (getListaDesembolso().size() > Numeros.ZERO) {
                for (Iterator<TradeFinanceDesembolsoVO> iterator = listaDesembolso.iterator(); iterator.hasNext();) {
                    TradeFinanceDesembolsoVO item = (TradeFinanceDesembolsoVO) iterator.next();
                    
                    valorDesembolsoItem = SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(item.getVprevtdsembcmbio()));
                    valorSaldoCalc = valorSaldoCalc - valorDesembolsoItem;
                }
            }

            if (valorSaldoCalc.compareTo(0D) <= Numeros.ZERO) {
                getDesembolsoForfaitingVO().setSaldoDesembolsar("0.00");
            } else {
                valorSaldoStr = valorSaldoCalc.toString().replace(".", "-");
                partesValor = valorSaldoStr.split("-");
                if (partesValor[1].length() <= Numeros.UM) {
                    getDesembolsoForfaitingVO().setSaldoDesembolsar(valorSaldoCalc.toString() + "0");
                } else {
                    getDesembolsoForfaitingVO().setSaldoDesembolsar(valorSaldoCalc.toString());
                }
            }
        }
        
        return true;
    }
    
    	/**
    	* Nome: incluirLiborTravadaDesembolso
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private void incluirLiborTravadaDesembolso(Integer rotina) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.incluirLiborTravadaDesembolso <<<<<<<<<<<");

            desembolsoForfaitingVO.setEventoForfaiting(Numeros.NUM2);
            liborTravadaModalBean.setDesembolsoForfaitingVO(desembolsoForfaitingVO);
            if (rotina == EnumTradeFinance.ACESSO_INCLUIR_DESEMBOLSO_FORFAITING.getCodigo()) {
                liborTravadaModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalLiborTravada");
            } else {
                liborTravadaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalLiborTravada");
            }
            liborTravadaModalBean.incluirLiborTravadaDesembolso();
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.incluirLiborTravadaDesembolso <<<<<<<<<<<");
        }
    }

    	/**
    	* Nome: listenerTrocaLiborTravDesembolso
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaLiborTravDesembolso(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaLiborTravDesembolso <<<<<<<<<<<");

    		calcTaxasDesembolsoForfaiting();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaLiborTravDesembolso <<<<<<<<<<<");
    	}
    }

    	/**
    	* Nome: listenerTrocaSpreadInformado
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerTrocaSpreadInformado(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaSpreadInformado <<<<<<<<<<<");

    		calcTaxasDesembolsoForfaiting();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaSpreadInformado <<<<<<<<<<<");
    	}
    }

    	/**
    	* Nome: calcTaxasOperacaoForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void calcTaxasOperacaoForfaiting() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.calcTaxasOperacaoForfaiting <<<<<<<<<<<");

    		if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) == false &&
    						SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) == false &&
    						getTradeFinNegocVO().getTdiaopercmbio() > Numeros.NUM0 &&
    						SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVtravaliborcmbio()) == false &&
    						SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getSpreadclean()) == false &&
    						SiteUtil.isEmptyOrNull(getItemListaComissaoInterna().getVtxspreadnegoc()) == false)
    		{
    			atualizarQuadroForfaitingValor();
    		}
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.calcTaxasOperacaoForfaiting <<<<<<<<<<<");
    	}
    	
        
    }

    	/**
    	* Nome: calcTaxasDesembolsoForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void calcTaxasDesembolsoForfaiting() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.calcTaxasDesembolsoForfaiting <<<<<<<<<<<");
    		
    		if (getTradeFinNegocVO().isForfaitingTipoJuroEmbutido()) {
    			calcTaxasDesembEmbutidos();
    		}
    		
    		if (getTradeFinNegocVO().isForfaitingTipoJuroDeduzido()) {
    			calcTaxasDesembDeduzidos();
    		}

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.calcTaxasDesembolsoForfaiting <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: calcTaxasDesembEmbutidos
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private void calcTaxasDesembEmbutidos() {
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVprevtdsembcmbio()) == false &&
                        SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getTdiafinandsemb()) == false &&
                        SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPtxjurofndng()) == false)
        {
            if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVtxliborcmbio()) == true  &&
                        SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPspreadtxcmbio()) == true) {
                return;
            }
            if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVtxliborcmbio()) == true) {
                getDesembolsoForfaitingVO().setVtxliborcmbio("0,00000");
            }
            if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPspreadtxcmbio()) == true) {
                getDesembolsoForfaitingVO().setPspreadtxcmbio("0,00000");
            }
            
            getTxForfaitingVO().setJurosembded(getTradeFinNegocVO().getCtpojurotrade());
            getTxForfaitingVO().setVnegocmoedaestrg(getDesembolsoForfaitingVO().getVprevtdsembcmbio());
            getTxForfaitingVO().setTdiaopercmbio(getDesembolsoForfaitingVO().getTdiafinandsemb());
            getTxForfaitingVO().setVtravaliborcmbio(getDesembolsoForfaitingVO().getVtxliborcmbio());
            getTxForfaitingVO().setVtxliborcmbio(getDesembolsoForfaitingVO().getPtxjurofndng());
            getTxForfaitingVO().setVtxspreadnegoc(getDesembolsoForfaitingVO().getPspreadtxcmbio());
            
            getTradeFinanceNegociacaoService().calcTaxasForfaiting(getTxForfaitingVO());
            
            getDesembolsoForfaitingVO().setPjuronegoccmbio(getTxForfaitingVO().getTaxajuros());
            //Taxa descontada não utilizada
            getDesembolsoForfaitingVO().setVjurodsembcmbio(getTxForfaitingVO().getValorjuros());
            getDesembolsoForfaitingVO().setVdsembnegoccmbio(getTxForfaitingVO().getValorsaque());
        }
    }

    	/**
    	* Nome: calcTaxasDesembDeduzidos
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private void calcTaxasDesembDeduzidos() {
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVdsembnegoccmbio()) == false &&
                        SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getTdiafinandsemb()) == false &&
                        SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPtxjurofndng()) == false)
        {
            if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVtxliborcmbio()) == true  &&
                            SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPspreadtxcmbio()) == true) {
                    return;
            }
            if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVtxliborcmbio()) == true) {
                getDesembolsoForfaitingVO().setVtxliborcmbio("0,00000");
            }
            if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPspreadtxcmbio()) == true) {
                getDesembolsoForfaitingVO().setPspreadtxcmbio("0,00000");
            }

            getTxForfaitingVO().setJurosembded(getTradeFinNegocVO().getCtpojurotrade());
            getTxForfaitingVO().setVnegocmoedaestrg(getDesembolsoForfaitingVO().getVdsembnegoccmbio());
            getTxForfaitingVO().setTdiaopercmbio(getDesembolsoForfaitingVO().getTdiafinandsemb());
            getTxForfaitingVO().setVtravaliborcmbio(getDesembolsoForfaitingVO().getVtxliborcmbio());
            getTxForfaitingVO().setVtxliborcmbio(getDesembolsoForfaitingVO().getPtxjurofndng());
            getTxForfaitingVO().setVtxspreadnegoc(getDesembolsoForfaitingVO().getPspreadtxcmbio());
            
            getTradeFinanceNegociacaoService().calcTaxasForfaiting(getTxForfaitingVO());
            
            getDesembolsoForfaitingVO().setPjuronegoccmbio(getTxForfaitingVO().getTaxajuros());
            getDesembolsoForfaitingVO().setTaxaDescontada(getTxForfaitingVO().getTaxadescontada());
            getDesembolsoForfaitingVO().setVjurodsembcmbio(getTxForfaitingVO().getValorjuros());
            getDesembolsoForfaitingVO().setVprevtdsembcmbio(getTxForfaitingVO().getValorsaque());
        }
    }
    
    	/**
    	* Nome: atualizarQuadroOpForfaitingDescricao
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 19/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private void atualizarQuadroOpForfaitingDescricao() {
        if (getTradeFinanceBean().getQuadroOperacaoForfaiting().size() < Numeros.SETE) {
            getTradeFinanceBean().setQuadroOperacaoForfaiting(new ArrayList<TaxasForfaitingVO>());
            for (int i = 0; i < 7; i++) {
                getTradeFinanceBean().getQuadroOperacaoForfaiting().add(new TaxasForfaitingVO());
            }
        }
        
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(1).setInfoCol1("Valor");
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(2).setInfoCol1("Prazo");
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(3).setInfoCol1("Taxa");
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(4).setInfoCol1("Taxa Descontada");

        if (getTradeFinNegocVO().getCtpojurotrade().equals(EnumTradeFinance.OPCAO_JUROS_EMBUTIDOS.getCodigo())) {
            getTradeFinanceBean().getQuadroOperacaoForfaiting().get(0).setInfoCol1("FORFAITING COM JUROS EMBUTIDOS");
            getTradeFinanceBean().getQuadroOperacaoForfaiting().get(0).setInfoCol2("");
            
            getTradeFinanceBean().getQuadroOperacaoForfaiting().get(5).setInfoCol1("Valor dos juros a incluir no saque");
            getTradeFinanceBean().getQuadroOperacaoForfaiting().get(6).setInfoCol1("Valor do saque total");
        }

        if (getTradeFinNegocVO().getCtpojurotrade().equals(EnumTradeFinance.OPCAO_JUROS_DEDUZIDOS.getCodigo())) {
            getTradeFinanceBean().getQuadroOperacaoForfaiting().get(0).setInfoCol1("FORFAITING COM JUROS DEDUZIDOS");
            getTradeFinanceBean().getQuadroOperacaoForfaiting().get(0).setInfoCol2("");
            
            
            getTradeFinanceBean().getQuadroOperacaoForfaiting().get(5).setInfoCol1("Valor dos juros a descontar no saque");
            getTradeFinanceBean().getQuadroOperacaoForfaiting().get(6).setInfoCol1("Valor descontado");
        }
    }
    
    private void atualizarQuadroForfaitingValor() {
        if (getTradeFinNegocVO().getCtpojurotrade() != EnumTradeFinance.OPCAO_JUROS_EMBUTIDOS.getCodigo() &&
                        getTradeFinNegocVO().getCtpojurotrade() != EnumTradeFinance.OPCAO_JUROS_DEDUZIDOS.getCodigo()) {
            return;
        }
        
        atualizarQuadroOpForfaitingDescricao();
        getTxForfaitingVO().setJurosembded(getTradeFinNegocVO().getCtpojurotrade());
        getTxForfaitingVO().setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());
        getTxForfaitingVO().setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());
        getTxForfaitingVO().setVtravaliborcmbio(getTradeFinNegocVO().getVtravaliborcmbio());
        getTxForfaitingVO().setVtxliborcmbio(getTrdFinNegPrecificacaoVO().getSpreadclean());
        getTxForfaitingVO().setVtxspreadnegoc(getItemListaComissaoInterna().getVtxspreadnegoc());
        
        getTradeFinanceNegociacaoService().calcTaxasForfaiting(getTxForfaitingVO());
        
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(1).setInfoCol2(
                        SiteUtil.formatarValorWeb(getTradeFinNegocVO().getVnegocmoedaestrg()));
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(2).setInfoCol2(getTxForfaitingVO().getTdiaopercmbio().toString());
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(3).setInfoCol2(getTxForfaitingVO().getTaxajuros());
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(4).setInfoCol2(getTxForfaitingVO().getTaxadescontada());
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(5).setInfoCol2(getTxForfaitingVO().getValorjuros());
        getTradeFinanceBean().getQuadroOperacaoForfaiting().get(6).setInfoCol2(getTxForfaitingVO().getValorsaque());
                        
    }

    	/**
    	* Nome: listenerIncluirDesembolsoForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerIncluirDesembolsoForfaiting(AjaxBehaviorEvent e) {
        
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirDesembolsoForfaiting <<<<<<<<<<<");
            
            incluirDesembolsoForfaiting(EnumTradeFinance.TELA_INCLUIR_ALTERAR_FORFAITING.getCodigo());
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirDesembolsoForfaiting <<<<<<<<<<<");
    	}
        
    }
    
    	/**
    	* Nome: listenerInclDesembSaldoForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 30/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerInclDesembSaldoForfaiting(AjaxBehaviorEvent e) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerInclDesembSaldoForfaiting <<<<<<<<<<<");
            
            incluirDesembolsoForfaiting(EnumTradeFinance.TELA_INCLUIR_DESEMBOLSO.getCodigo());
            
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerInclDesembSaldoForfaiting <<<<<<<<<<<");
        }
        
    }

    public void incluirDesembolsoForfaiting(Integer telaDeAcesso) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.incluirDesembolsoForfaiting <<<<<<<<<<<");

            TradeFinanceDesembolsoVO desembolsoNew = new TradeFinanceDesembolsoVO();
            
            getDesembolsoForfaitingVO().setDataDesembolsoFormat(SiteUtil.dataWebToMainframe(
                    getViewHelper().getDatePrevDesembolso()).replace(".", "/"));
            getDesembolsoForfaitingVO().setDprevtdsembcmbio(getViewHelper().getDatePrevDesembolso());
             
            if (validarIncluirDesembolsoForfaiting() == false) {
                 NpcFacesUtils.addInfoModalMessage("Dados para inclusão incompletos.", false);
                 return;
             }
            
            
            if (validarValorDesembolsoForfaiting(EnumTradeFinance.BOTAO_INCLUIR.getCodigo()) == false) {
                return;
            }
             
            if(validarDataEmbarqueForfaiting() == false) {
            	return;
            }
            
            if (validarDataPrevDesembolsoForfaiting() == false) {
                return;
            }
            
            if(validarDataVencimentoForfaiting() == false) {
            	return;
            }
            
            getListaDesembolso().add(getDesembolsoForfaitingVO());
            gerarSeqListaDesembolsoForfaiting();
            
            desembolsoNew.setPtxjurofndng(getDesembolsoForfaitingVO().getPtxjurofndng());
            desembolsoNew.setVtxliborcmbio(getDesembolsoForfaitingVO().getVtxliborcmbio());
            desembolsoNew.setTdiafinandsemb(getDesembolsoForfaitingVO().getTdiafinandsemb());
            setDesembolsoForfaitingVO(desembolsoNew);
            getViewHelper().setDateFluxoPgtoTemp(null);
            getViewHelper().setDatePrevDesembolso(null);
            getViewHelper().setVencimentoSaque(null);
            desembolsoNew.setVdsembnegoccmbio(null);
            desembolsoNew.setVtxliborcmbio(null);
            
            atualizarSaldoDesembolsar(EnumTradeFinance.EVENTO_INCLUIR_EXCLUIR_DESEMBOLSO.getCodigo());
            
            getViewHelper().setRenderComissaoInterna(Boolean.TRUE);
            
            getDesembolsoForfaitingVO().setVprevtdsembcmbio(null);
            getDesembolsoForfaitingVO().setVtxliborcmbio(null);
            getDesembolsoForfaitingVO().setPspreadtxcmbio(null);
            getDesembolsoForfaitingVO().setVjurodsembcmbio(null);
            
            
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.incluirDesembolsoForfaiting <<<<<<<<<<<");
        }
        
    }
    
    	/**
    	* Nome: validarIncluirDesembolsoForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 27/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private boolean validarIncluirDesembolsoForfaiting() {
        
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getDataDesembolsoFormat())) {
            return false;
        }
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVprevtdsembcmbio())) {
            return false;
        }
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVdsembnegoccmbio())) {
            return false;
        }
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVtxliborcmbio())) {
            return false;
        }
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPtxjurofndng())) {
            return false;
        }
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPspreadtxcmbio())) {
            return false;
        }
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getPjuronegoccmbio())) {
            return false;
        }
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getTdiafinandsemb())) {
            return false;
        }
        if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getVjurodsembcmbio())) {
            return false;
        }

        if (getTradeFinNegocVO().isForfaitingTipoJuroEmbutido()) {
            
            return true;
        }
        
        if (getTradeFinNegocVO().isForfaitingTipoJuroDeduzido()) {
            if (SiteUtil.isEmptyOrNull(getDesembolsoForfaitingVO().getTaxaDescontada())) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Nome: validarDataEmbarqueForfaiting
     * 
     * Propósito: Valida se a data informada é dia util no país
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public boolean validarDataEmbarqueForfaiting() {

        Date dtInicioPrevEmbarque = getTradeFinNegocVO().getDataPrevEmbarq().getInicio();
        Date dtFimPrevEmbarque = getTradeFinNegocVO().getDataPrevEmbarq().getFim();
        Date dtPrevtembrq = getDesembolsoForfaitingVO().getDprevtembrq();
        
		if(SiteUtil.isEmptyOrNull(dtPrevtembrq)) {
			NpcFacesUtils.addInfoModalMessage("Data de embarque inválida", false);
			return false;
		}

		if(SiteUtil.isEmptyOrNull(dtInicioPrevEmbarque) || SiteUtil.isEmptyOrNull(dtFimPrevEmbarque)) {
			NpcFacesUtils.addInfoModalMessage("Previsão de embarque não informado", false);
			return false;
		}

		if (dtPrevtembrq.before(dtInicioPrevEmbarque) || dtPrevtembrq.after(dtFimPrevEmbarque)) {
			NpcFacesUtils.addInfoModalMessage("Data embarque fora do período de previsão de embarque", false);
			return false;
		}

		if(getViewHelper().getDatePrevDesembolso() != null) {
			getTradeFinNegocVO().setTdiaopercmbio(commonService.getPrazoFinanciamento(getViewHelper().getDatePrevDesembolso(), Numeros.DOIS, viewHelper.getVencimentoSaque()));
			trocaPrazoFinancForfaiting();
		}
		
		return true;
    }
    
    
    
	/**
	* Nome: validarDataPrevDesembolsoForfaiting
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*/
	private boolean validarDataPrevDesembolsoForfaiting() {
		
		Integer cdPais = getTradeFinNegocVO().getCpais();
		Integer ecindcdeconm = getTradeFinNegocVO().getCeconmmoedadsemb();
		Date dtPrevDesembolso = getViewHelper().getDatePrevDesembolso();
        Date dtInicioPrevDesembolso = getTradeFinNegocVO().getDataPrevDesemb().getInicio();
        Date dtFimPrevDesembolso = getTradeFinNegocVO().getDataPrevDesemb().getFim();
		
		// Carrega a data informada de desembolso no campo fluxo de pagamento
		getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDatePrevDesembolso());              
		
		/** Antes de chamar o Fluxo para calcular o fluxo de pagamento irá chamar o serviço
		 * do Inec para devolver o código do  Páis Moeda e a descrição
		*/
		if (ecindcdeconm.equals(Numeros.QUINZE)) {
			getTradeFinNegocVO().setCpaisInec(null);
		} else {
			getTradeFinNegocVO().setCpaisInec(tradeFinanceNegociacaoService.inecIndicadorEconomico(ecindcdeconm));
		}

		if(!commonService.validarDiaUtil(dtPrevDesembolso, cdPais, "1", getTradeFinNegocVO().getCpaisInec(), getTrdFinNegMercadoriaVO().getCpaisbnefc(), ecindcdeconm)) {
			NpcFacesUtils.addInfoModalMessage("Data desembolso inválida.", false);
			getTradeFinNegocVO().setTdiaopercmbio(Numeros.ZERO);
			return false;
		}
		
		if (viewHelper.getVencimentoSaque() != null) {
    		if(getViewHelper().getDatePrevDesembolso().after(viewHelper.getVencimentoSaque())) {
    			NpcFacesUtils.addInfoModalMessage("Data desembolso inválida.", false);
				getTradeFinNegocVO().setTdiaopercmbio(Numeros.ZERO);
    			return false;
    		}
        }                
		
        if(SiteUtil.isEmptyOrNull(dtInicioPrevDesembolso) || SiteUtil.isEmptyOrNull(dtFimPrevDesembolso)) {
			NpcFacesUtils.addInfoModalMessage("Previsão do desembolso não informado", false);
        	return false;
        }
        else
           if (dtPrevDesembolso.before(dtInicioPrevDesembolso) || dtPrevDesembolso.after(dtFimPrevDesembolso)) {
        	   NpcFacesUtils.addInfoModalMessage("Data desembolso fora do período de previsão de desembolso", false);
        	   return false;
           }

        getTradeFinNegocVO().setTdiaopercmbio(commonService.getPrazoFinanciamento(getViewHelper().getDatePrevDesembolso(), Numeros.DOIS, viewHelper.getVencimentoSaque()));
		trocaPrazoFinancForfaiting();

        return true;
	}
	
    /**
     * Nome: validarDataVencimentoForfaiting
     * 
     * Propósito: Valida se a data informada é dia util no país e calcula prazo financiamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     */
    public boolean validarDataVencimentoForfaiting() {
    	
		Date dtVencimentoSaque = getViewHelper().getVencimentoSaque();
		Integer cdPais = getTradeFinNegocVO().getCpais();
		Integer ecindcdeconm = getTradeFinNegocVO().getCeconmmoedadsemb();
		
		if(dtVencimentoSaque != null && !commonService.validarDiaUtil(dtVencimentoSaque, cdPais, "1", getTradeFinNegocVO().getCpaisInec(), getTrdFinNegMercadoriaVO().getCpaisbnefc(), ecindcdeconm)) {
			NpcFacesUtils.addInfoModalMessage("Data vencimento inválida.", false);
			getTradeFinNegocVO().setTdiaopercmbio(Numeros.ZERO);
			return false;
		}
		
		if (dtVencimentoSaque != null) {
    		if(getViewHelper().getDatePrevDesembolso().after(viewHelper.getVencimentoSaque())) {
    			NpcFacesUtils.addInfoModalMessage("Data vencimento inválida.", false);
				getTradeFinNegocVO().setTdiaopercmbio(Numeros.ZERO);
    			return false;
    		}
		
        }                
		
		getTradeFinNegocVO().setTdiaopercmbio(commonService.getPrazoFinanciamento(getViewHelper().getDatePrevDesembolso(), Numeros.DOIS, viewHelper.getVencimentoSaque()));
		trocaPrazoFinancForfaiting();
		
		return true;
    	
    }

	

    	/**
    	* Nome: listenerExcluirDesembolsoForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerExcluirDesembolsoForfaiting(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirDesembolsoForfaiting <<<<<<<<<<<");

            
    		excluirDesembolsoForfaiting(EnumTradeFinance.TELA_INCLUIR_ALTERAR_FORFAITING.getCodigo());
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirDesembolsoForfaiting <<<<<<<<<<<");
    	}
    }
    	
        
        /**
        * Nome: listenerExclDesembSaldoForfaiting
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 23/08/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
        */
    public void listenerExclDesembSaldoForfaiting(AjaxBehaviorEvent e) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExclDesembSaldoForfaiting <<<<<<<<<<<");

            
            excluirDesembolsoForfaiting(EnumTradeFinance.TELA_INCLUIR_DESEMBOLSO.getCodigo());
            
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExclDesembSaldoForfaiting <<<<<<<<<<<");
        }
        
    }

    	/**
    	* Nome: excluirDesembolsoForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 30/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void excluirDesembolsoForfaiting(Integer telaDeAcesso) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.excluirDesembolsoForfaiting <<<<<<<<<<<");

            TradeFinanceDesembolsoVO itemDesembolso = null;
            
            // valida se foi selecionado um item na lista
            if (getViewHelper().getItemSelecListaDesembolso() == null) {
                NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            }
            
            itemDesembolso = getListaDesembolso().get(getViewHelper().getItemSelecListaDesembolso());
            
            if (temMercadoriaAtrelada(itemDesembolso.getSeqDesembolso()) == Boolean.TRUE) {
                NpcFacesUtils.addInfoModalMessage("Exclusão negada. Existe mercadoria associada.", false);
                return;
            }
            
            // Remove o item selecionado.
            getListaDesembolso().remove(itemDesembolso);
            
            gerarSeqListaDesembolsoForfaiting();
            
            if (telaDeAcesso.equals(EnumTradeFinance.TELA_INCLUIR_DESEMBOLSO.getCodigo())) {
                atualizarSaldoDesembolsar(EnumTradeFinance.EVENTO_INCLUIR_EXCLUIR_DESEMBOLSO.getCodigo());
            }
            
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.excluirDesembolsoForfaiting <<<<<<<<<<<");
        }
        
        
    }

    	/**
    	* Nome: getItensRadioListaDesembolso
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public List<SelectItem> getItensRadioListaDesembolso() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaDesembolso <<<<<<<<<<<");

    		List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
    		
    		SiteUtil.atualizarSelectItem(getListaDesembolso(), selectItemRadioLista);
    		
    		return selectItemRadioLista;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaDesembolso <<<<<<<<<<<");
    	}
    	
    }

    /**
    * Nome: gerarSeqListaDesembolsoForfaiting
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 19/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    protected void gerarSeqListaDesembolsoForfaiting() {
    
        for (int i = 0; i < getListaDesembolso().size(); i++) {
            getListaDesembolso().get(i).setSeqDesembolso(i + 1);
        }
    }

    	/**
    	* Nome: listenerIncluirComissExtForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerIncluirComissExtForfaiting(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirComissExtForfaiting <<<<<<<<<<<");

    		comissaoExtManutModalBean.getItemListaComissaoExterna().setCcondceconc(Numeros.ZERO);
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setVlxtotalcomis("");
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setPjuronegoccmbio("");
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setCperdcjurocmbio(Numeros.ZERO);
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setCindcdeconmmoeda(EnumTradeFinance.MOEDA_USD.getCodigo());
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setCfluxoperdccmbio(EnumTradeFinance.
    						PERIODICIDADE_SEMESTRAL.getCodigo());
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setCodMomentoComissao(Numeros.ZERO);
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setQpcelacmbiotrade(null);
    		comissaoExtManutModalBean.getItemListaComissaoExterna().getListaParcelasComissao().clear();
    		comissaoExtManutModalBean.getViewHelper().setDisabledModalComissaoExt(Boolean.TRUE);
    		comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoExterna");
    		
    		comissaoExtManutModalBean.getViewHelper().setDisabledModalComissaoExt(Boolean.FALSE);
    		
    		comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Incluir");
    		comissaoExtManutModalBean.setListaComissaoExterna(getTradeFinNegocVO().getListaComissaoExterna());
    		
            if (getListaDesembolso().size() <= Numeros.ZERO) {
                if (getTradeFinNegocVO().getDataPrevDesemb().getInicio() == null) {
                    NpcFacesUtils.addInfoModalMessage("O campo Previsão do Desembolso não informado.", false);
                    return;
                }
                comissaoExtManutModalBean.getItemListaComissaoExterna().
                    setDateComissao(getTradeFinNegocVO().getDataPrevDesemb().getInicio());
            } else {
                comissaoExtManutModalBean.getItemListaComissaoExterna().
                    setDateComissao(getListaDesembolso().get(0).getDprevtdsembcmbio());
            }
            if (getListaDesembolso().size() <= Numeros.ZERO) {
                comissaoExtManutModalBean.getItemListaComissaoExterna().
                setDataComissaoFormat(getTradeFinNegocVO().getDataPrevDesemb().getInicioFormatado());
            } else {
                comissaoExtManutModalBean.getItemListaComissaoExterna().
                setDataComissaoFormat(getListaDesembolso().get(0).getDataDesembolsoFormat());
            }
    		comissaoExtManutModalBean.getItemListaComissaoExterna().
    		    setTdiafinandsemb(getTradeFinNegocVO().getTdiaopercmbio());
            comissaoExtManutModalBean.getItemListaComissaoExterna().
                setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());
    		comissaoExtManutModalBean.getItemListaComissaoExterna().
    		    setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());
    		comissaoExtManutModalBean.getItemListaComissaoExterna().
    		    setVprevtdsembcmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setVmincobrcomis("0,00");
    		comissaoExtManutModalBean.getItemListaComissaoExterna().setCperdcjurocmbio(Numeros.UM);
    		comissaoExtManutModalBean.getViewHelper().setDisabledTxtParcelaComissaoExt(Boolean.TRUE); 
    		
    		// Inclusão de comissão adicional
            comissaoExtManutModalBean.getItemListaComissaoExterna().setTipoComissao(EnumTipoComissao.ADICIONAL);
    		
    		// parametro utilizado para carregar o combo de tipo de comissão
    		comissaoExtManutModalBean.getViewHelper().setTelaOrigem(Numeros.UM);
    		
    		comissaoExtManutModalBean.setQtdeFluxoPgt(getListaDesembolso().size());
    		comissaoExtManutModalBean.openModal(getTradeFinNegocVO().getCprodtservc());
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirComissExtForfaiting <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerAlterarComissExtForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerAlterarComissExtForfaiting(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerAlterarComissExtForfaiting <<<<<<<<<<<");

    		int itemSel = 0;
    		TradeFinanceDesembolsoVO desembolsoVO = null;
    		
    		TrdFinNegComissaoVO itemComissaoExterna = new TrdFinNegComissaoVO();
    		
    		if (getViewHelper().getItemSelecListaComissaoExterna() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		
            if (getListaDesembolso().size() > Numeros.ZERO) {
                desembolsoVO = getListaDesembolso().get(Numeros.ZERO);
            }
            
    		itemSel = SiteUtil.getInt(getViewHelper().getItemSelecListaComissaoExterna());
    		
    		TrdFinNegComissaoVO itemComissaoExternaAlt = new TrdFinNegComissaoVO();
    		itemComissaoExternaAlt = (TrdFinNegComissaoVO) getTradeFinNegocVO().getListaComissaoExterna().get(itemSel, EnumTipoComissao.ADICIONAL);
    		
    		itemComissaoExterna.setCcondceconc(itemComissaoExternaAlt.getCcondceconc());
    		itemComissaoExterna.setCperdcjurocmbio(itemComissaoExternaAlt.getCperdcjurocmbio());
    		itemComissaoExterna.setCindcdeconmmoeda(itemComissaoExternaAlt.getCindcdeconmmoeda());
    		itemComissaoExterna.setCfluxoperdccmbio(itemComissaoExternaAlt.getCfluxoperdccmbio());
    		itemComissaoExterna.setTipoComissaoExt(itemComissaoExternaAlt.getTipoComissaoExt());
    		itemComissaoExterna.setVprevtcomiscmbio(itemComissaoExternaAlt.getVprevtcomiscmbio());
    		itemComissaoExterna.setPjuronegoccmbio(itemComissaoExternaAlt.getPjuronegoccmbio());
    		itemComissaoExterna.setPeriodoTaxa(itemComissaoExternaAlt.getPeriodoTaxa());
    		itemComissaoExterna.setMoedaComissao(itemComissaoExternaAlt.getMoedaComissao());
    		itemComissaoExterna.setPeriodicidadeComissao(itemComissaoExternaAlt.getPeriodicidadeComissao());
    		itemComissaoExterna.setCodMomentoComissao(itemComissaoExternaAlt.getCodMomentoComissao());
    		itemComissaoExterna.setQpcelacmbiotrade(itemComissaoExternaAlt.getQpcelacmbiotrade());
    		itemComissaoExterna.setListaParcelasComissao(itemComissaoExternaAlt.getListaParcelasComissao());
    		
    		itemComissaoExterna.setTipoComissao(itemComissaoExternaAlt.getTipoComissao());
    		
            itemComissaoExterna.setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());
            itemComissaoExterna.setVlxtotalcomis(itemComissaoExternaAlt.getVlxtotalcomis());
            
            if (getListaDesembolso().size() <= Numeros.ZERO) {
                itemComissaoExterna.setDateComissao(getTradeFinNegocVO().getDataPrevDesemb().getInicio());
                itemComissaoExterna.setDataComissaoFormat(getTradeFinNegocVO().getDataPrevDesemb().getInicioFormatado());
                itemComissaoExterna.setTdiafinandsemb(getTradeFinNegocVO().getTdiaopercmbio());
                itemComissaoExterna.setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());
                itemComissaoExterna.setVprevtdsembcmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
            } else {
                itemComissaoExterna.setDateComissao(desembolsoVO.getDprevtdsembcmbio());
                itemComissaoExterna.setDataComissaoFormat(SiteUtil.dataWebToMainframe(desembolsoVO.getDprevtdsembcmbio()));
                itemComissaoExterna.setTdiafinandsemb(desembolsoVO.getTdiafinandsemb());
                itemComissaoExterna.setTdiaopercmbio(desembolsoVO.getTdiafinandsemb());
                itemComissaoExterna.setVprevtdsembcmbio(desembolsoVO.getVprevtdsembcmbio());
            }
    		
    		comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Alterar");
    		comissaoExtManutModalBean.getViewHelper().setLinhaSelecionada(getViewHelper().getItemSelecListaComissaoExterna());
    		comissaoExtManutModalBean.setQtdeFluxoPgt(getListaDesembolso().size());
    		comissaoExtManutModalBean.setListaComissaoExterna(getTradeFinNegocVO().getListaComissaoExterna());
    		comissaoExtManutModalBean.setItemListaComissaoExterna(itemComissaoExterna);     
    		comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoExterna");
    		comissaoExtManutModalBean.getViewHelper().setDisabledModalComissaoExt(Boolean.FALSE);
    		
    		// parametro utilizado para carregar o combo de tipo de comissão
    		comissaoExtManutModalBean.getViewHelper().setTelaOrigem(Numeros.UM);
    		
    		comissaoExtManutModalBean.openModal(getTradeFinNegocVO().getCprodtservc());
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerAlterarComissExtForfaiting <<<<<<<<<<<");
    	}
    	
        
    }

    	/**
    	* Nome: listenerExcluirComissExtForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerExcluirComissExtForfaiting(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirComissExtForfaiting <<<<<<<<<<<");

    		comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Excluir");
    		comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoExterna");
    		detalharComissaoExterna(EnumTipoComissao.ADICIONAL);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirComissExtForfaiting <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: listenerDetalharComissExtForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerDetalharComissExtForfaiting(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerDetalharComissExtForfaiting <<<<<<<<<<<");

    		comissaoExtManutModalBean.getViewHelper().setFuncaoBotaoComissaoExterna("Detalhar");
    		comissaoExtManutModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalComissaoExterna");
    		detalharComissaoExterna(EnumTipoComissao.ADICIONAL);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerDetalharComissExtForfaiting <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: calcCustoTotalForfaiting
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private void calcCustoTotalForfaiting() {
        
        String vtravaliborcmbio = "0.00";
        Integer przomediodsembm = 0;
        if(SiteUtil.isEmptyOrNull(getItemListaComissaoInterna().getVtxspreadnegoc())){
            getItemListaComissaoInterna().setVtxspreadnegoc("0,00000");
        }
        
        if (SiteUtil.isEmptyOrNull(getItemListaComissaoInterna().getVtxspreadnegoc()) == false 
                && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) == false 
                && SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getSpreadclean()) == false) {

            if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVtravaliborcmbio()) == true) {
                
                przomediodsembm = getTrdFinNegPrecificacaoVO().getPrzomediodsembm();
                
            } else {
                
                Double libor = SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(getTradeFinNegocVO().getVtravaliborcmbio()));
                
                if (libor.compareTo(0D) > 0) {
                    vtravaliborcmbio = getTradeFinNegocVO().getVtravaliborcmbio();
                } else {
                    przomediodsembm = getTrdFinNegPrecificacaoVO().getPrzomediodsembm();
                }
            }
            
            getItemListaComissaoInterna().setCustoTotalForfaiting(
                    getTradeFinanceNegociacaoService().calcCustoTotalForfaiting(
                                    getTrdFinNegPrecificacaoVO(), 
                                    getTradeFinNegocVO(),
                                    getItemListaComissaoInterna().getVtxspreadnegoc(),
                                    vtravaliborcmbio,
                                    przomediodsembm,
                                    getTrdFinNegPrecificacaoVO().getSpreadclean()));
        }
    }

    /****************************************
     * FIM - ROTINAS FORFAITING          *
     ****************************************/
    
    /****************************************
     * INICIO - ROTINAS LC IMPORTACAO       *
     ****************************************/
    public void listenerCalcPrazoTotalOper(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerCalcPrazoTotalOper <<<<<<<<<<<");
    		
    		if(getFuncaoExecutando() == EnumTradeFinance.FUNCAO_TIPO_ALTERAR.getCodigo()) {
    			trocarPrazoLC();
    		} else if(getTradeFinNegocVO().getListaComissaoExterna() != null && getTradeFinNegocVO().getListaComissaoExterna().size() > 0 ||
    				!SiteUtil.isEmptyOrNull(getViewHelper().getValueComissaoCobranca())) {
    			trocarPrazoLC();
    		}
    		// Recalcula o prazo total da operação
    		getTradeFinNegocVO().setTdiaopercmbio(calcularPrazoTotalOper());
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerCalcPrazoTotalOper <<<<<<<<<<<");
    	}
    	
    }
    
    public void listenerIncluirMixedPayment(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirMixedPayment <<<<<<<<<<<");

    		if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getParcelaVO().getVpcelacreditprevt())
    						&& SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getParcelaVO().getVpcelacartaprevt())) {
    			NpcFacesUtils.addInfoModalMessage("Informe o Valor ou o Percentual da parcela!", false);
    			return;
    		}        
    		else if (!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getParcelaVO().getVpcelacreditprevt())
    						&& !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getParcelaVO().getVpcelacartaprevt())) {
    			NpcFacesUtils.addInfoModalMessage("Os campos Valor e Percentual não podem ser preenchidos ao mesmo tempo!", false);
    			return;
    		}
    		
    		if (getTradeFinNegocVO().getParcelaVO().getCprzpcelacarta().equals(Numeros.ZERO)) {
    			NpcFacesUtils.addInfoModalMessage("Informe se a parcela é À Vista ou Prazo!", false);
    			return;
    		} else {
    			getTradeFinNegocVO().getParcelaVO().setNprzpcelacarta(selectItemBean.getSelectItemLabelByValue(
    							getTradeFinNegocVO().getParcelaVO().getCprzpcelacarta(), getViewHelper().getComboAVistaPrazo()));
    		}
    		
    		if (getTradeFinNegocVO().getParcelaVO().getCprzpcelacarta().equals(Numeros.NUM1)) {
    			
    			if (getTradeFinNegocVO().getListaParcelas().size() > 0) {
    				if (getTradeFinNegocVO().getListaParcelas().get(0).getCprzpcelacarta().equals(Numeros.NUM1)) {
    					NpcFacesUtils.addInfoModalMessage("Já existe uma parcela à vista!", false);
    					return;
    				}                
    			}
    			
    			// Adiciona parcela na primeira posição da lista
    			getTradeFinNegocVO().getListaParcelas().add(0, getTradeFinNegocVO().getParcelaVO());
    		}
    		else if (getTradeFinNegocVO().getParcelaVO().getCprzpcelacarta().equals(Numeros.NUM2)) {
    			
    			// Adiciona parcela na lista
    			getTradeFinNegocVO().getListaParcelas().add(getTradeFinNegocVO().getParcelaVO());
    		}
    		
    		// Reorganiza a numeração das parcelas
    		numerarParcelas();
    		
    		getTradeFinNegocVO().setParcelaVO(new ParcelaVO());
    		
    		// Recalcula o prazo total da operação
    		getTradeFinNegocVO().setTdiaopercmbio(calcularPrazoTotalOper());        
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirMixedPayment <<<<<<<<<<<");
    	}
        
    }
    
    public void listenerExcluirMixedPayment(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirMixedPayment <<<<<<<<<<<");

    		ParcelaVO itemParcela = null;
    		
    		// valida se foi selecionado um item na lista
    		if (getViewHelper().getItemSelecListaParcelas() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		
    		itemParcela = getTradeFinNegocVO().getListaParcelas().get(getViewHelper().getItemSelecListaParcelas());
    		
    		// Remove o item selecionado.
    		getTradeFinNegocVO().getListaParcelas().remove(itemParcela);
    		
    		// Reorganiza a numeração das parcelas
    		numerarParcelas();        
    		
    		// Recalcula o prazo total da operação
    		getTradeFinNegocVO().setTdiaopercmbio(calcularPrazoTotalOper());        
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirMixedPayment <<<<<<<<<<<");
    	}


    }
    
    public void listenerIncluirDespesa(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerIncluirDespesa <<<<<<<<<<<");

    		if (getTradeFinNegocVO().getDespesaVO().getCtpodespcmbio().equals(Numeros.ZERO)) {
    			NpcFacesUtils.addInfoModalMessage("O campo \"Tipo de Despesa\" deve ser preenchido!", false);
    			return;
    		} else {
    			getTradeFinNegocVO().getDespesaVO().setNtpodespcmbio(selectItemBean.getSelectItemLabelByValue(
    							getTradeFinNegocVO().getDespesaVO().getCtpodespcmbio(), getViewHelper().getComboTipoDespesas()));
    		}
    		
    		
    		if (getTradeFinNegocVO().getDespesaVO().getCidtfdrespdesp().equals(Numeros.ZERO)) {
    			NpcFacesUtils.addInfoModalMessage("O campo \"Por Conta\" deve ser preenchido!", false);
    			return;
    		} else {
    			getTradeFinNegocVO().getDespesaVO().setNidtfdrespdesp(selectItemBean.getSelectItemLabelByValue(
    							getTradeFinNegocVO().getDespesaVO().getCidtfdrespdesp(), getViewHelper().getComboPorConta()));            
    		}
    		
			if (getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)
					|| getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
					|| getTradeFinNegocVO().getProduto().isGarantia()) {

				if (SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getBancocorr()) || 
						SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getImunintlcmbio())){
					
					NpcFacesUtils.addInfoModalMessage("Use a Lupa para Escolher um Banco", false);
					return;
				}


				if (SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio())
						&& SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getCbanqrcmbio())
						&& SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getBancodesemb())) {
					NpcFacesUtils.addInfoModalMessage("É preciso informar pelo menos um Banco!", false);
					return;
				}

				if (SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getBancodesemb())
						&& SiteUtil.getInt(tradeFinNegocVO.getCindcdcartacnfdo()) == Numeros.UM) {
					NpcFacesUtils.addInfoModalMessage("O flag de confirmada está como sim,\n favor preencher o banco Confirmador!",false);
					return;
				}
			}

    		getTradeFinNegocVO().getListaDespesas().add(getTradeFinNegocVO().getDespesaVO());
    		numerarDespesas();
    		getTradeFinNegocVO().setDespesaVO(new ListaDespesasVO());
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerIncluirDespesa <<<<<<<<<<<");
    	}

    }
    
    public void listenerExcluirDespesa(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerExcluirDespesa <<<<<<<<<<<");

    		ListaDespesasVO itemDespesa = null;
    		
    		// valida se foi selecionado um item na lista
    		if (getViewHelper().getItemSelecListaDespesas() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}
    		
    		itemDespesa = getTradeFinNegocVO().getListaDespesas().get(getViewHelper().getItemSelecListaDespesas());
    		
    		// Remove o item selecionado.
    		getTradeFinNegocVO().getListaDespesas().remove(itemDespesa);
    		
    		numerarDespesas();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerExcluirDespesa <<<<<<<<<<<");
    	}

    }
    
    private void numerarParcelas() {
        for (int i = 0; i < getTradeFinNegocVO().getListaParcelas().size(); i++) {
            getTradeFinNegocVO().getListaParcelas().get(i).setNpceladsembcarta(i + 1);
        }
    }
    
    private void numerarDespesas() {
        long numDesp = 0L;
        for (int i = 0; i < getTradeFinNegocVO().getListaDespesas().size(); i++) {
            numDesp = i + 1;
            getTradeFinNegocVO().getListaDespesas().get(i).setNdespbletocmbio(numDesp);
        }
    }
    
    private int calcularPrazoTotalOper() {
    	
    	if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCprznegoccmbio())){
    		
    		CalcPrazoTotalOperLcVO calcPrazoTotalOperLcVO = new CalcPrazoTotalOperLcVO();
    		calcPrazoTotalOperLcVO.setDlimembrqcmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteEmbarque()));
    		calcPrazoTotalOperLcVO.setCprznegoccmbio(getTradeFinNegocVO().getCprznegoccmbio().toString());
    		calcPrazoTotalOperLcVO.setTdiavalddcarta(getTradeFinNegocVO().getTdiavalddcarta());
    		calcPrazoTotalOperLcVO.setTdiavalddletra(getTradeFinNegocVO().getTdiavalddletra());
    		for (int i = 0; i < getTradeFinNegocVO().getListaParcelas().size(); i++) {
    			calcPrazoTotalOperLcVO.getListaTdiapgtocarta().add(getTradeFinNegocVO().getListaParcelas().get(i).getTdiapgtocarta());
    		}
    		
    		int prazoTotalOper = getTradeFinanceNegociacaoService().calcularPrazoTotalOperacaoLC(calcPrazoTotalOperLcVO);
    		
    		if (comissaoExtManutModalBean.getListaComissaoExterna().size() > 0) {
    			for (int i = 0; i < comissaoExtManutModalBean.getListaComissaoExterna().size(); i++) { 
    			    
    			    TrdFinNegComissaoVO item = (TrdFinNegComissaoVO)comissaoExtManutModalBean.getListaComissaoExterna().get(i); 
    			    
    				item.setTdiafinandsemb(prazoTotalOper);
    				item.setTdiaopercmbio(prazoTotalOper);                
    			}
    		}
    		
    		return prazoTotalOper;         
    	}
    	
    	return 0;
    	
    }

    /****************************************
     * FIM - ROTINAS LC IMPORTACAO          *
     ****************************************/
    
    /**********************************************************
     * INICIO - ROTINAS GARANTIA INTERNACIONAL EXPEDIDA       *
     **********************************************************/

    public void listenerCalcularVencimentoFianca(AjaxBehaviorEvent e) {
        try {
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarAvistaPrazo <<<<<<<<<<<");
            
            calcVencFianca();

        } finally {
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarAvistaPrazo <<<<<<<<<<<");
        }      
    }
    
    private void calcVencFianca() {
        
        if (getTradeFinNegocVO().getDprevtgarntexpdi() != null && getTradeFinNegocVO().getTdiaopercmbio() != null) {
            
            Date dataVencFianca = commonService.getDataVencimentoFianca(
                            getTradeFinNegocVO().getDprevtgarntexpdi(), getTradeFinNegocVO().getTdiaopercmbio());
            
            getViewHelper().setDateVencFianc(dataVencFianca);
            itemListaComissaoInterna.setDateComissao(dataVencFianca);
            itemListaComissaoInterna.setDataComissaoFormat(SiteUtil.dateToString(dataVencFianca, "dd/MM/yyyy"));
        }
    }
    
    public void listenerTrocarDataVencFianca(AjaxBehaviorEvent e) {
        getTradeFinNegocVO().getListaComissaoInterna().get(0).setDateComissao(getViewHelper().getDateVencFianc());       
        getTradeFinNegocVO().getListaComissaoInterna().get(0).setDataComissaoFormat(SiteUtil.dateToString(getViewHelper().getDateVencFianc(), "dd/MM/yyyy"));
    }

    /**********************************************************
     * FIM - ROTINAS GARANTIA INTERNACIONAL EXPEDIDA          *
     **********************************************************/

    /**
     * Nome: actionCollapsAreaNegocio
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionCollapsAreaNegocio(Long codAreaNegocio) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.actionCollapsAreaNegocio <<<<<<<<<<<");

    		switch (codAreaNegocio.intValue()) {
    		case 1:
    			if (getViewHelper().getValueMaisMenosFluxoPagto().equals("+")) {
    				getViewHelper().setValueMaisMenosFluxoPagto("-");
    				getViewHelper().setRenderFluxoPagto(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosFluxoPagto("+");
    				getViewHelper().setRenderFluxoPagto(Boolean.FALSE);
    			}
    			
    			break;
    			
    		case 2:
    			if (getViewHelper().getValueMaisMenosPrecificacao().equals("+")) {
    				getViewHelper().setValueMaisMenosPrecificacao("-");
    				getViewHelper().setRenderPrecificacao(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosPrecificacao("+");
    				getViewHelper().setRenderPrecificacao(Boolean.FALSE);
    			}
    			
    			break;
    			
    		case 3:
    			if (getViewHelper().getValueMaisMenosComissaoInterna().equals("+")) {
    				getViewHelper().setValueMaisMenosComissaoInterna("-");
    				getViewHelper().setRenderComissaoInterna(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosComissaoInterna("+");
    				getViewHelper().setRenderComissaoInterna(Boolean.FALSE);
    			}
    			
    			break;
    			
    		case 4:
    			if (getViewHelper().getValueMaisMenosMercadoria().equals("+")) {
    				getViewHelper().setValueMaisMenosMercadoria("-");
    				getViewHelper().setRenderMercadoria(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosMercadoria("+");
    				getViewHelper().setRenderMercadoria(Boolean.FALSE);
    			}
    			
    			break;
    			
    		case 5:
    			if (getViewHelper().getValueMaisMenosOperacaoVinculada().equals("+")) {
    				getViewHelper().setValueMaisMenosOperacaoVinculada("-");
    				getViewHelper().setRenderOperacaoVinculada(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosOperacaoVinculada("+");
    				getViewHelper().setRenderOperacaoVinculada(Boolean.FALSE);
    			}
    			
    			break;
    			
    		case 6:
    			if (getViewHelper().getValueMaisMenosResponsavelEmpresa().equals("+")) {
    				getViewHelper().setValueMaisMenosResponsavelEmpresa("-");
    				getViewHelper().setRenderResponsavelEmpresa(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosResponsavelEmpresa("+");
    				getViewHelper().setRenderResponsavelEmpresa(Boolean.FALSE);
    			}
    			
    			break;
    			
    		case 7:
    			if (getViewHelper().getValueMaisMenosTarifas().equals("+")) {
    				getViewHelper().setValueMaisMenosTarifas("-");
    				getViewHelper().setRenderTarifas(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosTarifas("+");
    				getViewHelper().setRenderTarifas(Boolean.FALSE);
    			}
    			
    			break;
    			
    		case 8:
    			if (getViewHelper().getValueMaisMenosComissao().equals("+")) {
    				getViewHelper().setValueMaisMenosComissao("-");
    				getViewHelper().setRenderComissao(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosComissao("+");
    				getViewHelper().setRenderComissao(Boolean.FALSE);
    			}
    			
    			break;
    			
    		case 9:
    			if (getViewHelper().getValueMaisMenosDocumentosConsignados().equals("+")) {
    				getViewHelper().setValueMaisMenosDocumentosConsignados("-");
    				getViewHelper().setRenderDocumentosConsignados(Boolean.TRUE);
    			} else {
    				getViewHelper().setValueMaisMenosDocumentosConsignados("+");
    				getViewHelper().setRenderDocumentosConsignados(Boolean.FALSE);
    			}
    			
    			break;            
    			

            case 10:
                if (getViewHelper().getValueMaisMenosContatoRetiradaGarantia().equals("+")) {
                    getViewHelper().setValueMaisMenosContatoRetiradaGarantia("-");
                    getViewHelper().setRenderContatoRetiradaGarantia(Boolean.TRUE);
                } else {
                    getViewHelper().setValueMaisMenosContatoRetiradaGarantia("+");
                    getViewHelper().setRenderContatoRetiradaGarantia(Boolean.FALSE);
                }

                break;  
    			
    		default:
    			break;
    		}
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.actionCollapsAreaNegocio <<<<<<<<<<<");
    	}
    	
    }
    // 
  	//** Variavel do tipo TarifaAutomaticaFiltroVO. *//*
  	private TarifaAutomaticaFiltroVO filtro = new TarifaAutomaticaFiltroVO();
      
      public TarifaAutomaticaFiltroVO getFiltro() {
  		return filtro;
  	}
    
	@Inject
	@Named("tarifaAutomaticaService")
	private ITarifaAutomaticaService service;

	private List<TarifaAutomaticaVO> listaPesquisa = new ArrayList<TarifaAutomaticaVO>();

	public List<TarifaAutomaticaVO> getListaPesquisa() {
		return listaPesquisa;
	}

	public void setListaPesquisa(List<TarifaAutomaticaVO> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	public void pesquisarTarifaAutomatica() {

		// 
		int x = 0;
		for (int i = 0; i < getViewHelper().getComboProduto().size(); i++) {
			int k = (Integer) getViewHelper().getComboProduto().get(i).getValue();
			if (k == getTradeFinNegocVO().getCprodtservc()) {
				x = i;
			}
		}

		String label = getViewHelper().getComboProduto().get(x).getLabel();

		filtro.setCoper(6405); // Fixo
		getFiltro().setRoper("Cobrar Tarifas de Operação de Câmbio - Mesa Trade"); // Fixo

		getFiltro().setRprodtservc(label); // variável
		filtro.setCprodtservc(getTradeFinNegocVO().getCprodtservc()); // variável

		// Executa chamada CWS - Fluxo: NPCDIAHV - Books: NPCDWN0E / NPCDWN0S
		setListaPesquisa(service.pesquisar(getFiltro()));
		incluirTarifaAutomatica(listaPesquisa);
	}
	//    
    
    /**
     * 
     * Nome: openModalBcDesembReemb
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModalBcDesembReemb(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		
	    	getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalBcDesembReemb <<<<<<<<<<<");
	    	
	    	getViewHelper().setTipoUnidExt("Reembolsador");
	    	
	    	getTrdFinNegPrecificacaoVO().getBancoReembolsadorVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
	        
	        unidadeExternaModalBean.setExternaVO(getTrdFinNegPrecificacaoVO().getBancoReembolsadorVO());
            unidadeExternaModalBean.getViewHelper().setIsConfirmar(Boolean.FALSE);
	        unidadeExternaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalUnidExt");
	        unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.DOIS);
	        unidadeExternaModalBean.pesquisarUnidExtPorNome();
	        
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalBcDesembReemb <<<<<<<<<<<");
    	}
    }
    
    /**
     * Nome: getItensRadioListaFluxos
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaFluxos() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaFluxos <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getTradeFinNegocVO().getListaFluxos().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaFluxos <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: getItensRadioListaMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaMercadoria() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaMercadoria <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getTradeFinNegocVO().getListaMercadoria().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaMercadoria <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: getItensRadioListaOperacaoVinculada
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaOperacaoVinculada() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaOperacaoVinculada <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getTradeFinNegocVO().getListaOperacaoVinculada().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaOperacaoVinculada <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: getItensRadioListaTarifas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaTarifas() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaTarifas <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getTradeFinNegocVO().getListaTarifas().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaTarifas <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: getItensRadioListaComissaoInterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaComissaoInterna() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaComissaoInterna <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getTradeFinNegocVO().getListaComissaoInterna().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaComissaoInterna <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: getItensRadioListaComissaoExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaComissaoExterna() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaComissaoInterna.getComissaoAdicional <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getTradeFinNegocVO().getListaComissaoExterna().getComissaoAdicional().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;	
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaComissaoInterna.getComissaoAdicional <<<<<<<<<<<");
    	}
    }
    
    /**
     * Nome: getItensRadioListaComissaoBanqueiro
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaComissaoBanqueiro() {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaComissaoBanqueiro.getComissaoBanqueiro <<<<<<<<<<<");

            List<SelectItem> list = new ArrayList<SelectItem>();
            
            // Percorre todos os itens da lista afim de criar os respectivos radio
            // buttons
            for (int index = 0; index < getTradeFinNegocVO().getListaComissaoExterna().getComissaoBanqueiro().size(); index++) {
                list.add(new SelectItem(index, "", ""));
            }
            
            return list;    
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaComissaoBanqueiro.getComissaoBanqueiro <<<<<<<<<<<");
        }
    }
    
    /**
     * Nome: getItensRadioListaParcelas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaParcelas() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaParcelas <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getTradeFinNegocVO().getListaParcelas().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaParcelas <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: getItensRadioListaDespesas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaDespesas() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaDespesas <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getTradeFinNegocVO().getListaDespesas().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaDespesas <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: getItensRadioListaRespDesp
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/07/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaRespDesp() {

        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.getItensRadioListaRespDesp <<<<<<<<<<<");

            List<SelectItem> list = new ArrayList<SelectItem>();
    
            // Percorre todos os itens da lista afim de criar os respectivos radio
            // buttons
            for (int index = 0; index < getTradeFinNegocVO().getListaRespDesp().size(); index++) {
                list.add(new SelectItem(index, "", ""));
            }
    
            return list;
        
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.getItensRadioListaRespDesp <<<<<<<<<<<");
        }
    }    
    
    /**
     * 
    	* Nome: pesquisarUnidadeExterna
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 18/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void openModalUnidadeExterna(AjaxBehaviorEvent event){
    	
    	try{
    	   
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalUnidadeExterna <<<<<<<<<<<");
    		
    		Integer paramTelaOrigem = SiteUtil.getInt(event.getComponent().getAttributes().get("paramTelaOrigem"));
    		getViewHelper().setTipoUnidExt("UnidExt");
    		
    		trdFinNegPrecificacaoVO.getUnidadeExternaVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
    		
    		if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
    		    unidadeExternaModalBean.getViewHelper().setTitulo("Selecionar Credor");
    		}else {
    		    unidadeExternaModalBean.getViewHelper().setTitulo("Selecionar Unidade Externa");
    		}
    		
    		if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
    			unidadeExternaModalBean.getViewHelper().setModalId("formTradeFinNegoc\\:content_modalUnidExt");
    		} else {
    			unidadeExternaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalUnidExt");
    		}
    		
    		unidadeExternaModalBean.getViewHelper().setIsConfirmar(Boolean.FALSE);
    		unidadeExternaModalBean.setExternaVO(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO());
    		unidadeExternaModalBean.getViewHelper().setModalidade(paramTelaOrigem == Numeros.CINCO ? paramTelaOrigem : Numeros.UM);
    		unidadeExternaModalBean.pesquisarUnidExtPorNome();
    		
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalUnidadeExterna <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
     * Nome: openModalBancoReembolsador
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 24/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void openModalBancoReembolsador(AjaxBehaviorEvent ajaxBehaviorEvent){
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalBancoReembolsador <<<<<<<<<<<");
    		
    		getViewHelper().setTipoUnidExt("Reembolsador");
    		
    		trdFinNegPrecificacaoVO.getBancoReembolsadorVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
    		trdFinNegPrecificacaoVO.getBancoReembolsadorVO().setBancodesemb(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getIbanqrcmbio());
    		
    		unidadeExternaModalBean.setExternaVO(trdFinNegPrecificacaoVO.getBancoReembolsadorVO());
    		
    		if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
    			unidadeExternaModalBean.getViewHelper().setModalId("formTradeFinNegoc\\:content_modalUnidExt");
    		} else {
    			unidadeExternaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalUnidExt");
    		}
    		unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.DOIS);
    		unidadeExternaModalBean.pesquisarUnidExtPorNome();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalBancoReembolsador <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: openModalBancoAvisador
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 28/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void openModalBancoAvisador(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalBancoAvisador <<<<<<<<<<<");

    		trdFinNegPrecificacaoVO.getBancoAvisadorVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
    		trdFinNegPrecificacaoVO.getBancoAvisadorVO().setBancoaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getIbanqrcmbio());
    		
    		unidadeExternaModalBean.setExternaVO(trdFinNegPrecificacaoVO.getBancoAvisadorVO());
    		
    		if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
    			unidadeExternaModalBean.getViewHelper().setModalId("formTradeFinNegoc\\:content_modalUnidExt");
    		} else {
    			unidadeExternaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalUnidExt");
    		}
    		unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.TRES);
    		unidadeExternaModalBean.pesquisarUnidExtPorNome();
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalBancoAvisador <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: openModalBancoIndicado
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 08/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void openModalBancoIndicado(AjaxBehaviorEvent ajaxBehaviorEvent) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalBancoIndicado <<<<<<<<<<<");

            trdFinNegPrecificacaoVO.getBancoIndicadoVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
            trdFinNegPrecificacaoVO.getBancoIndicadoVO().setBancoindica(trdFinNegPrecificacaoVO.getBancoIndicadoVO().getIbanqrcmbio());
            
            unidadeExternaModalBean.setExternaVO(trdFinNegPrecificacaoVO.getBancoIndicadoVO());
            
            if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
                unidadeExternaModalBean.getViewHelper().setModalId("formTradeFinNegoc\\:content_modalUnidExt");
            } else {
                unidadeExternaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalUnidExt");
            }
            unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.QUATRO);
            unidadeExternaModalBean.pesquisarUnidExtPorNome();
            
        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalBancoIndicado <<<<<<<<<<<");
        }
        
    }    
    
    
    /**
     * Nome: listenerTratarPrazo
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTratarPrazo(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarPrazo <<<<<<<<<<<");
    		
    		tratarPrazo();
    		listenerCalcPrazoTotalOper(null);      

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarPrazo <<<<<<<<<<<");
    	}
    	
    }
    
    
    /**
     * Nome: listenerCalcularSomatoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerCalcularSomatoria(AjaxBehaviorEvent e) {
        
        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerCalcularSomatoria <<<<<<<<<<<");

            String valor = "0,00";
            
            /// Quando o campo estava vazio apresentava erro de conversão
            if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getPjuronegoccmbio())){
                getTradeFinNegocVO().setPjuronegoccmbio("0,00");
            }
            
            if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getPagtefincrcmbio())){
                getTradeFinNegocVO().setPagtefincrcmbio("0,00");
            }
            //////
            
            if (!SiteUtil.isValueZero(getTradeFinNegocVO().getPjuronegoccmbio()) || 
                            !SiteUtil.isValueZero(getTradeFinNegocVO().getPagtefincrcmbio())) {
                double somatoria = getTradeFinanceNegociacaoService().calcularSomatoria(
                                Double.parseDouble(SiteUtil.trocarVirgulaPorPonto(getTradeFinNegocVO().getPjuronegoccmbio())),
                                Double.parseDouble(SiteUtil.trocarVirgulaPorPonto(getTradeFinNegocVO().getPagtefincrcmbio())));            
                DecimalFormat df = new DecimalFormat("0.00000");      
                valor = df.format(somatoria);                        
            }
            getTradeFinNegocVO().setPtotjurocmbio(valor);

        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerCalcularSomatoria <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
     * Nome: openModalUnidExternaBcCorresp
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModalUnidExternaBcCorresp(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalUnidExternaBcCorresp <<<<<<<<<<<");
	    	

	    	trdFinNegPrecificacaoVO.getUnidadeExternaVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
            
	        unidadeExternaModalBean.setExternaVO(trdFinNegPrecificacaoVO.getUnidadeExternaVO());
            unidadeExternaModalBean.getViewHelper().setIsConfirmar(Boolean.FALSE);
	        unidadeExternaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalUnidExt");
	        unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.UM);
	        unidadeExternaModalBean.getViewHelper().setItemSelecListaUnidExt(null);
	        unidadeExternaModalBean.pesquisarUnidExtPorNome();
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalUnidExternaBcCorresp <<<<<<<<<<<");
    	}
    }
    
    /**
     * Nome: listenerTratarAvistaPrazo
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTratarAvistaPrazo(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarAvistaPrazo <<<<<<<<<<<");
    		
    		tratarPrazo();

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarAvistaPrazo <<<<<<<<<<<");
    	}
    	
    }    
    
    /**
     * Nome: tratarPrazo
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    private void tratarPrazo() {
    	if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCprznegoccmbio())){
    		if (getTradeFinNegocVO().getCprznegoccmbio() == 1) {
    			getTradeFinNegocVO().setTdiavalddletra(0);
    			getTradeFinNegocVO().getListaParcelas().clear();
    		}
    		else if (getTradeFinNegocVO().getCprznegoccmbio() == 2) {
    			getTradeFinNegocVO().setTdiavalddcarta(0);
    			getTradeFinNegocVO().getListaParcelas().clear();
    		}
    		else if (getTradeFinNegocVO().getCprznegoccmbio() == 0 || getTradeFinNegocVO().getCprznegoccmbio() == 3) {
    			getTradeFinNegocVO().setTdiavalddcarta(0);
    			getTradeFinNegocVO().setTdiavalddletra(0);
    		} 
    		if (getTradeFinNegocVO().getParcelaVO().getCprzpcelacarta() != 2) {
    			getTradeFinNegocVO().getParcelaVO().setTdiapgtocarta(0);
    		}        
    	}
    } 
    
    /**
     * Nome: listenerDesabilitaQtdeParcelas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 10/10/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerDesabilitaQtdeParcelas(AjaxBehaviorEvent e) {

		try {
			getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.desabilitaQtdeParcelas <<<<<<<<<<<");

			if (getTradeFinNegocVO().getCfluxoperdccmbio().equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo())) {
				getViewHelper().setDisabledQtdeParcela(Boolean.FALSE);
				getTradeFinNegocVO().getPrevDesembolsoVO().setQpcelatradeprinc(Numeros.ZERO);
			} else {
				getViewHelper().setDisabledQtdeParcela(Boolean.TRUE);
			}
		} finally {
			getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.desabilitaQtdeParcelas <<<<<<<<<<<");
		}
    }  
    
    /**
     * 
    	* Nome: tratarPeriodMomentoECA
    	* 
    	* Propósito: Não deve apresentar opção 'Antecipado' no combo Momento quando selecionar 'Final' no combo Periodicidade
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 18/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void tratarPeriodo(){
    	getViewHelper().setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.FLUXO_PAGAMENTO.getCodigo(), getTradeFinNegocVO().getProduto().getCodigo()));
        if(itemListaFluxoPgto.getCfluxoliqdcprinc().equals(Numeros.DOZE) || itemListaFluxoPgto.getCodJurosPeriodicidade().equals(Numeros.DOZE) && !itemListaFluxoPgto.getCodJurosPeriodicidade().equals(Numeros.CATORZE)){
            for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
                if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.UM)){
                	getViewHelper().setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.FLUXO_PAGAMENTO.getCodigo(), getTradeFinNegocVO().getProduto().getCodigo()));
                    //Remover a opção 'Antecipado' no combo quando for produto ECA
                    getViewHelper().getComboMomento().remove(i);
                    break;
                }
            }
        }  
        if (itemListaFluxoPgto.getCodJurosPeriodicidade().equals(Numeros.CATORZE)) {
            for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
            	getViewHelper().setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.FLUXO_PAGAMENTO.getCodigo(), getTradeFinNegocVO().getProduto().getCodigo()));
                if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.DOIS)){
                    //Remover a opção 'Antecipado' no combo quando for produto ECA
                    getViewHelper().getComboMomento().remove(i);
                    break;
                }
            }
		}
    }    
    
    /**
     * 
    	* Nome: tratarMomento
    	* 
    	* Propósito: Não deve apresentar opção 'Final' no combo Periodicidade quando selecionar 'Antecipado' no combo Momento
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 18/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void tratarMomento(AjaxBehaviorEvent e){
        if(itemListaFluxoPgto.getCodJurosMomento().equals(Numeros.UM)){
            
            for(int i=0; i < getViewHelper().getComboPeriodicidade().size(); i++){
                if(getViewHelper().getComboPeriodicidade().get(i).getValue().equals(Numeros.DOZE)){
                    //Remover a opção 'Final' no combo
                    getViewHelper().getComboPeriodicidade().remove(i);
                    break;
                }
            }
        }else{
            getViewHelper().carregaComboPeriodicidade(commonService.getComboPeriodicidade(0));
        }
    }
    
    /**
     * 
     * Nome: openModalBcAvisador
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModalBcAvisador(AjaxBehaviorEvent ajaxBehaviorEvent) {
        
        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.openModalBcAvisador <<<<<<<<<<<");
            
            trdFinNegPrecificacaoVO.getBancoAvisadorVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
            
            unidadeExternaModalBean.setExternaVO(trdFinNegPrecificacaoVO.getBancoAvisadorVO());
            unidadeExternaModalBean.getViewHelper().setIsConfirmar(Boolean.FALSE);
            unidadeExternaModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:content_modalUnidExt");
            unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.TRES);
            unidadeExternaModalBean.getViewHelper().setItemSelecListaUnidExt(null);
            unidadeExternaModalBean.pesquisarUnidExtPorNome();
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.openModalBcAvisador <<<<<<<<<<<");
        }
    }    
    
    public Boolean temFluxoPagamento(){
    	
    	//produtos que nao tem fluxo de pagamento
    	if(getTradeFinNegocVO().getProduto().isBndesPos() 
                || getTradeFinNegocVO().getProduto().isBndesPre()
                || getTradeFinNegocVO().getProduto().isGarantia()
                || getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
                || getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)
                || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)){
    		
    		return Boolean.FALSE;
    		
    	}else{
    		
    		return Boolean.TRUE;
    	}
    	
    }
    
    /**
     * Nome: listenerTratarGarantidor
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTratarGarantidor(AjaxBehaviorEvent e) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBaseBean.listenerTratarGarantidor <<<<<<<<<<<");
            
            if (getTradeFinNegocVO().getObsCotacaoVO().getGarangarant().equals("1")) {
                getViewHelper().setDisabledGarantidor(Boolean.TRUE);
                getTrdFinNegPrecificacaoVO().setUnidadeExternaVO(new UnidadeExternaVO());
                getTradeFinNegocVO().getObsCotacaoVO().setGarancondbgar(null);
                getViewHelper().setRenderLupaAprovCredito(Boolean.TRUE);
            } else {
                getViewHelper().setDisabledGarantidor(Boolean.FALSE);
                getTradeFinNegocVO().setPagtefincrcmbio("0");
                //getTradeFinNegocVO().setCcobrcomisagte(Numeros.NUM3);
                getTradeFinNegocVO().setCcobrcomisagte(Numeros.NUM0);
                getTradeFinNegocVO().getObsCotacaoVO().setGarancondagfi(null);
                getTradeFinNegocVO().getObsCotacaoVO().setGaranbnds(null);
                getViewHelper().setRenderLupaAprovCredito(Boolean.FALSE);
                getTradeFinNegocVO().setPagtefincrcmbio(null);
                // Garantidor Bradesco = Não - Limpa limite
                setLimiteVO(new LimitesModalVO());
                calcularValorLimite();
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBaseBean.listenerTratarGarantidor <<<<<<<<<<<");
        }
    }
    
    /**
     * Nome: listenerTraxaPre
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 09/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTraxaPre(AjaxBehaviorEvent e) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBaseBean.listenerTraxaPre <<<<<<<<<<<");
            
            if (getTradeFinNegocVO().getObsCotacaoVO().getTxapre().equals("1")) {
                getViewHelper().setDisabledRadioTaxaPre(Boolean.TRUE);
                getTradeFinNegocVO().getObsCotacaoVO().setCustfin(null);
                getTradeFinNegocVO().setVtxremunbndes(null);
                getTradeFinNegocVO().setPagtefincrcmbio(null);
            } else {
                getViewHelper().setDisabledRadioTaxaPre(Boolean.FALSE);
                getTradeFinNegocVO().setPjuronegoccmbio(null);
                getTradeFinNegocVO().setPagtefincrcmbio(null);
                getTradeFinNegocVO().setPtotjurocmbio(null);
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBaseBean.listenerTraxaPre <<<<<<<<<<<");
        }
        
    }
    
    /**
     * @return o valor do viewHelper
     */
    public TradeFinanceNegociacaoViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(TradeFinanceNegociacaoViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do tradeFinNegocVO
     */
    public TrdFinNegocInclVO getTradeFinNegocVO() {
        return tradeFinNegocVO;
    }

    /**
     * @param tradeFinNegocVO seta o novo valor para o campo tradeFinNegocVO
     */
    public void setTradeFinNegocVO(TrdFinNegocInclVO tradeFinNegocVO) {
        this.tradeFinNegocVO = tradeFinNegocVO;
    }

    /**
     * @return o valor do itemListaFluxoPgto
     */
    public TrdFinNegFluxoPagtoVO getItemListaFluxoPgto() {
        return itemListaFluxoPgto;
    }

    /**
     * @param itemListaFluxoPgto seta o novo valor para o campo itemListaFluxoPgto
     */
    public void setItemListaFluxoPgto(TrdFinNegFluxoPagtoVO itemListaFluxoPgto) {
        this.itemListaFluxoPgto = itemListaFluxoPgto;
    }
    
    /**
     * @return o valor do itemListaFluxoPgtoAux
     */
    public TrdFinNegFluxoPagtoVO getItemListaFluxoPgtoAux() {
        return itemListaFluxoPgtoAux;
    }

    /**
     * @param itemListaFluxoPgtoAux seta o novo valor para o campo itemListaFluxoPgtoAux
     */
    public void setItemListaFluxoPgtoAux(TrdFinNegFluxoPagtoVO itemListaFluxoPgtoAux) {
        this.itemListaFluxoPgtoAux = itemListaFluxoPgtoAux;
    }
    
    /**
     * @return o valor do itemListaFluxoPgtoBackUp
     */
    public List<TrdFinNegParcelaVO> getItemListaFluxoPgtoBackUp() {
		return itemListaFluxoPgtoBackUp;
	}
    
    /**
     * @param itemListaFluxoPgtoBackUp seta o novo valor para o campo itemListaFluxoPgtoBackUp
     */
	public void setItemListaFluxoPgtoBackUp(List<TrdFinNegParcelaVO> itemListaFluxoPgtoBackUp) {
		this.itemListaFluxoPgtoBackUp = itemListaFluxoPgtoBackUp;
	}
    
    /**
     * @return o valor do tradeFinanceNegociacaoService
     */
    public ITradeFinanceNegociacaoService getTradeFinanceNegociacaoService() {
        return tradeFinanceNegociacaoService;
    }

    /**
     * @param tradeFinanceNegociacaoService seta o novo valor para o campo tradeFinanceNegociacaoService
     */
    public void setTradeFinanceNegociacaoService(ITradeFinanceNegociacaoService tradeFinanceNegociacaoService) {
        this.tradeFinanceNegociacaoService = tradeFinanceNegociacaoService;
    }

    /**
     * @return o valor do trdFinNegPrecificacaoVO
     */
    public TrdFinNegPrecificacaoVO getTrdFinNegPrecificacaoVO() {
        return trdFinNegPrecificacaoVO;
    }

    /**
     * @param trdFinNegPrecificacaoVO seta o novo valor para o campo trdFinNegPrecificacaoVO
     */
    public void setTrdFinNegPrecificacaoVO(TrdFinNegPrecificacaoVO trdFinNegPrecificacaoVO) {
        this.trdFinNegPrecificacaoVO = trdFinNegPrecificacaoVO;
    }

    /**
     * @return o valor do controleInclusaoAlteracao
     */
    public String getControleInclusaoAlteracao() {
        return controleInclusaoAlteracao;
    }

    /**
     * @param controleInclusaoAlteracao seta o novo valor para o campo controleInclusaoAlteracao
     */
    public void setControleInclusaoAlteracao(String controleInclusaoAlteracao) {
        this.controleInclusaoAlteracao = controleInclusaoAlteracao;
    }

    /**
     * @return o valor do clienteSelecaoVO
     */
    public ClienteSelecaoVO getClienteSelecaoVO() {
        return clienteSelecaoVO;
    }

    /**
     * @param clienteSelecaoVO seta o novo valor para o campo clienteSelecaoVO
     */
    public void setClienteSelecaoVO(ClienteSelecaoVO clienteSelecaoVO) {
        this.clienteSelecaoVO = clienteSelecaoVO;
    }

    /**
     * @return o valor do listaSelCliente
     */
    public List<TradeFinNegocListasVO> getListaSelCliente() {
        return listaSelCliente;
    }

    /**
     * @param listaSelCliente seta o novo valor para o campo listaSelCliente
     */
    public void setListaSelCliente(List<TradeFinNegocListasVO> listaSelCliente) {
        this.listaSelCliente = listaSelCliente;
    }

    /**
     * @return o valor do tipoPesquisaCliente
     */
    public Integer getTipoPesquisaCliente() {
        return tipoPesquisaCliente;
    }

    /**
     * @param tipoPesquisaCliente seta o novo valor para o campo tipoPesquisaCliente
     */
    public void setTipoPesquisaCliente(Integer tipoPesquisaCliente) {
        this.tipoPesquisaCliente = tipoPesquisaCliente;
    }

    /**
     * @return o valor do tipoCpfCnpj
     */
    public Integer getTipoCpfCnpj() {
        return tipoCpfCnpj;
    }

    /**
     * @param tipoCpfCnpj seta o novo valor para o campo tipoCpfCnpj
     */
    public void setTipoCpfCnpj(Integer tipoCpfCnpj) {
        this.tipoCpfCnpj = tipoCpfCnpj;
    }

    /**
     * @return o valor do limitesVO
     */
    public LimitesModalVO getLimiteVO() {
        return limiteVO;
    }

    /**
     * @param limitesVO seta o novo valor para o campo limitesVO
     */
    public void setLimiteVO(LimitesModalVO limiteVO) {
        this.limiteVO = limiteVO;
    }

    /**
     * @return o valor do listaModalLimite
     */
    public List<TradeFinNegocListasVO> getListaModalLimite() {
        return listaModalLimite;
    }

    /**
     * @param listaModalLimite seta o novo valor para o campo listaModalLimite
     */
    public void setListaModalLimite(List<TradeFinNegocListasVO> listaModalLimite) {
        this.listaModalLimite = listaModalLimite;
    }

    /**
     * @return o valor do prazoStandbyVO
     */
    public PrazoStandbyVO getPrazoStandbyVO() {
        return prazoStandbyVO;
    }

    /**
     * @param prazoStandbyVO seta o novo valor para o campo prazoStandbyVO
     */
    public void setPrazoStandbyVO(PrazoStandbyVO prazoStandbyVO) {
        this.prazoStandbyVO = prazoStandbyVO;
    }

    /**
     * @return o valor do listaUniExterna
     */
    public List<TradeFinNegocListasVO> getListaUniExterna() {
        return listaUniExterna;
    }

    /**
     * @param listaUniExterna seta o novo valor para o campo listaUniExterna
     */
    public void setListaUniExterna(List<TradeFinNegocListasVO> listaUniExterna) {
        this.listaUniExterna = listaUniExterna;
    }

    /**
     * @return o valor do trdFinNegMercadoriaVO
     */
    public TrdFinNegMercadoriaVO getTrdFinNegMercadoriaVO() {
        return trdFinNegMercadoriaVO;
    }

    /**
     * @param trdFinNegMercadoriaVO seta o novo valor para o campo trdFinNegMercadoriaVO
     */
    public void setTrdFinNegMercadoriaVO(TrdFinNegMercadoriaVO trdFinNegMercadoriaVO) {
        this.trdFinNegMercadoriaVO = trdFinNegMercadoriaVO;
    }

    /**
     * @return o valor do listaSelMercadoria
     */
    public List<TradeFinNegocListasVO> getListaSelMercadoria() {
        return listaSelMercadoria;
    }

    /**
     * @param listaSelMercadoria seta o novo valor para o campo listaSelMercadoria
     */
    public void setListaSelMercadoria(List<TradeFinNegocListasVO> listaSelMercadoria) {
        this.listaSelMercadoria = listaSelMercadoria;
    }

    /**
     * @return o valor do listaSelBeneficiario
     */
    public List<TradeFinNegocListasVO> getListaSelBeneficiario() {
        return listaSelBeneficiario;
    }

    /**
     * @param listaSelBeneficiario seta o novo valor para o campo listaSelBeneficiario
     */
    public void setListaSelBeneficiario(List<TradeFinNegocListasVO> listaSelBeneficiario) {
        this.listaSelBeneficiario = listaSelBeneficiario;
    }

    /**
     * @return o valor do operVinculadasVO
     */
    public TrdFinNegOperVincVO getOperVinculadasVO() {
        return operVinculadasVO;
    }

    /**
     * @param operVinculadasVO seta o novo valor para o campo operVinculadasVO
     */
    public void setOperVinculadasVO(TrdFinNegOperVincVO operVinculadasVO) {
        this.operVinculadasVO = operVinculadasVO;
    }

    /**
     * @return o valor do listaModalOperVinculadas
     */
    public List<TrdFinNegOperVincVO> getListaModalOperVinculadas() {
        return listaModalOperVinculadas;
    }

    /**
     * @param listaModalOperVinculadas seta o novo valor para o campo listaModalOperVinculadas
     */
    public void setListaModalOperVinculadas(List<TrdFinNegOperVincVO> listaModalOperVinculadas) {
        this.listaModalOperVinculadas = listaModalOperVinculadas;
    }

    /**
     * @return o valor do itemListaComissaoInterna
     */
    public TrdFinNegComissaoVO getItemListaComissaoInterna() {
        return itemListaComissaoInterna;
    }

    /**
     * @param itemListaComissaoInterna seta o novo valor para o campo itemListaComissaoInterna
     */
    public void setItemListaComissaoInterna(TrdFinNegComissaoVO itemListaComissaoInterna) {
        this.itemListaComissaoInterna = itemListaComissaoInterna;
    }

    /**
     * @return o valor do listaParcelas
     */
    public List<TrdFinNegComissaoVO> getListaParcelas() {
        return listaParcelas;
    }

    /**
     * @param listaParcelas seta o novo valor para o campo listaParcelas
     */
    public void setListaParcelas(List<TrdFinNegComissaoVO> listaParcelas) {
        this.listaParcelas = listaParcelas;
    }

    /**
     * @return o valor do itemListaComissaoExterna
     */
    public TrdFinNegComissaoVO getItemListaComissaoExterna() {
        return itemListaComissaoExterna;
    }

    /**
     * @param itemListaComissaoExterna seta o novo valor para o campo itemListaComissaoExterna
     */
    public void setItemListaComissaoExterna(TrdFinNegComissaoVO itemListaComissaoExterna) {
        this.itemListaComissaoExterna = itemListaComissaoExterna;
    }

    /**
     * @return o valor do tIPO_TARIFA
     */
    public String getTIPO_TARIFA() {
        return TIPO_TARIFA;
    }

    /**
     * @param tIPO_TARIFA seta o novo valor para o campo tIPO_TARIFA
     */
    public void setTIPO_TARIFA(String tIPO_TARIFA) {
        TIPO_TARIFA = tIPO_TARIFA;
    }

    /**
     * @return o valor do selectItemBean
     */
    public SelectItemBean getSelectItemBean() {
        return selectItemBean;
    }

    /**
     * @param selectItemBean seta o novo valor para o campo selectItemBean
     */
    public void setSelectItemBean(SelectItemBean selectItemBean) {
        this.selectItemBean = selectItemBean;
    }

    /**
     * @return o valor do prazoStandbyService
     */
    public IPrazoStandbyService getPrazoStandbyService() {
        return prazoStandbyService;
    }

    /**
     * @param prazoStandbyService seta o novo valor para o campo prazoStandbyService
     */
    public void setPrazoStandbyService(IPrazoStandbyService prazoStandbyService) {
        this.prazoStandbyService = prazoStandbyService;
    }

    /**
     * @return o valor do commonService
     */
    public ICommonService getCommonService() {
        return commonService;
    }

    /**
     * @param commonService seta o novo valor para o campo commonService
     */
    public void setCommonService(ICommonService commonService) {
        this.commonService = commonService;
    }

    /**
     * @return o valor do limitesModalBean
     */
    public LimitesModalBean getLimitesModalBean() {
        return limitesModalBean;
    }

    /**
     * @param limitesModalBean seta o novo valor para o campo limitesModalBean
     */
    public void setLimitesModalBean(LimitesModalBean limitesModalBean) {
        this.limitesModalBean = limitesModalBean;
    }

    /**
     * @return o valor do garantiasModalBean
     */
    public GarantiasModalBean getGarantiasModalBean() {
        return garantiasModalBean;
    }

    /**
     * @param garantiasModalBean seta o novo valor para o campo garantiasModalBean
     */
    public void setGarantiasModalBean(GarantiasModalBean garantiasModalBean) {
        this.garantiasModalBean = garantiasModalBean;
    }

    /**
     * @return o valor do tradeFinanceMonitService
     */
    public ITradeFinanceMonitService getTradeFinanceMonitService() {
        return tradeFinanceMonitService;
    }

    /**
     * @param tradeFinanceMonitService seta o novo valor para o campo tradeFinanceMonitService
     */
    public void setTradeFinanceMonitService(ITradeFinanceMonitService tradeFinanceMonitService) {
        this.tradeFinanceMonitService = tradeFinanceMonitService;
    }

    /**
     * @return o valor do tradeFinanceBean
     */
    public TradeFinanceBean getTradeFinanceBean() {
        return tradeFinanceBean;
    }

    /**
     * @param tradeFinanceBean seta o novo valor para o campo tradeFinanceBean
     */
    public void setTradeFinanceBean(TradeFinanceBean tradeFinanceBean) {
        this.tradeFinanceBean = tradeFinanceBean;
    }

    /**
     * @return o valor do comissaoExtManutModalBean
     */
    public ComissaoExtManutModalBean getComissaoExtManutModalBean() {
        return comissaoExtManutModalBean;
    }

    /**
     * @param comissaoExtManutModalBean seta o novo valor para o campo comissaoExtManutModalBean
     */
    public void setComissaoExtManutModalBean(ComissaoExtManutModalBean comissaoExtManutModalBean) {
        this.comissaoExtManutModalBean = comissaoExtManutModalBean;
    }

    /**
     * @return o valor do funcaoExecutando
     */
    public Integer getFuncaoExecutando() {
        return funcaoExecutando;
    }

    /**
     * @param funcaoExecutando seta o novo valor para o campo funcaoExecutando
     */
    public void setFuncaoExecutando(Integer funcaoExecutando) {
        this.funcaoExecutando = funcaoExecutando;
    }

    /**
     * @return o valor do txForfaitingVO
     */
    public TaxasForfaitingVO getTxForfaitingVO() {
        return txForfaitingVO;
    }

    /**
     * @param txForfaitingVO seta o novo valor para o campo txForfaitingVO
     */
    public void setTxForfaitingVO(TaxasForfaitingVO txForfaitingVO) {
        this.txForfaitingVO = txForfaitingVO;
    }

    /**
     * @return o valor do desembolsoForfaitingVO
     */
    public TradeFinanceDesembolsoVO getDesembolsoForfaitingVO() {
        return desembolsoForfaitingVO;
    }

    /**
     * @param desembolsoForfaitingVO seta o novo valor para o campo desembolsoForfaitingVO
     */
    public void setDesembolsoForfaitingVO(TradeFinanceDesembolsoVO desembolsoForfaitingVO) {
        this.desembolsoForfaitingVO = desembolsoForfaitingVO;
    }

    /**
     * @return o valor do listaDesembolso
     */
    public List<TradeFinanceDesembolsoVO> getListaDesembolso() {
        return listaDesembolso;
    }

    /**
     * @param listaDesembolso seta o novo valor para o campo listaDesembolso
     */
    public void setListaDesembolso(List<TradeFinanceDesembolsoVO> listaDesembolso) {
        this.listaDesembolso = listaDesembolso;
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
     * @return o valor do desenquadradas
     */
    public DesenquadramentoVO getDesenquadradas() {
        return desenquadradas;
    }

    /**
     * @param desenquadradas seta o novo valor para o campo desenquadradas
     */
    public void setDesenquadradas(DesenquadramentoVO desenquadradas) {
        this.desenquadradas = desenquadradas;
    }

    /**
     * @return o valor do tomadorModal
     */
    public TrdFinNegMercadoriaVO getTomadorModal() {
        return tomadorModal;
    }

    /**
     * @param tomadorModal seta o novo valor para o campo tomadorModal
     */
    public void setTomadorModal(TrdFinNegMercadoriaVO tomadorModal) {
        this.tomadorModal = tomadorModal;
    }

	public Date getLimiteCtc() {
		return limiteCtc;
	}

	public void setLimiteCtc(Date limiteCtc) {
		this.limiteCtc = limiteCtc;
	}

	public UnidadeExternaVO getBancoAvisadorVO() {
		return bancoAvisadorVO;
	}

	public void setBancoAvisadorVO(UnidadeExternaVO bancoAvisadorVO) {
		this.bancoAvisadorVO = bancoAvisadorVO;
	}

	public UnidadeExternaVO getUnidadeExternaVO() {
		return unidadeExternaVO;
	}

	public void setUnidadeExternaVO(UnidadeExternaVO unidadeExternaVO) {
		this.unidadeExternaVO = unidadeExternaVO;
	}

	public UnidadeExternaVO getBancoReembolsadorVO() {
		return bancoReembolsadorVO;
	}

	public void setBancoReembolsadorVO(UnidadeExternaVO bancoReembolsadorVO) {
		this.bancoReembolsadorVO = bancoReembolsadorVO;
	}

	/**
	 * @return the validaListenerTrocaValorMe
	 */
	public boolean isValidaListenerTrocaValorMe() {
		return validaListenerTrocaValorMe;
	}

	/**
	 * @param validaListenerTrocaValorMe the validaListenerTrocaValorMe to set
	 */
	public void setValidaListenerTrocaValorMe(boolean validaListenerTrocaValorMe) {
		this.validaListenerTrocaValorMe = validaListenerTrocaValorMe;
	}
	
    public ComissaoViewHelper getViewHelperAux() {
		return viewHelperAux;
	}

	public void setViewHelperAux(ComissaoViewHelper viewHelperAux) {
		this.viewHelperAux = viewHelperAux;
	}

	public ModeloBoletoVO getModeloBoletoVO() {
		return modeloBoletoVO;
	}

	public void setModeloBoletoVO(ModeloBoletoVO modeloBoletoVO) {
		this.modeloBoletoVO = modeloBoletoVO;
	}
	
	public TrdFinNegocInclVO getTradeFinanceOriginalVO() {
		return trdFinNegocOriginalVO;
	}

	public void setTradeFinanceOriginalVO(TrdFinNegocInclVO trdFinNegocOriginalVO) {
		this.trdFinNegocOriginalVO = trdFinNegocOriginalVO;
	}
}