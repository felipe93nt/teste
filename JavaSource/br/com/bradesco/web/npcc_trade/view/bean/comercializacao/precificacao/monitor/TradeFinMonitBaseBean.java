package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.ITradeFinanceMonitService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.CustoExternoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DeParaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.InformacaoPilotoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ITradeFinanceNegociacaoService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.BeneficiarioVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaParcelasDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNaoStr;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.TradeFinanceBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.agendaSwap.AgendaSwapBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.log.TradeFinanceLogBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.beneficiarioModal.BenefModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.clienteModal.ClienteModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.comissaoExtManutModal.ComissaoExtManutModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.desenquadradaModal.DesenquadradasModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.devolverModal.DevolverModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.garantiasModal.GarantiasModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.limitesModal.LimitesModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.operadorModal.OperadorModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.tomadorModal.TomadorModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.unidadeExternaModalbean.UnidadeExternaModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.operacionalizacao.formalizacao.monitor.TradeFinMonitFormalizacaoBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;
/**
 * Nome: BaseBean.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 02/06/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */

public abstract class TradeFinMonitBaseBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -6091408191964972394L;

    protected TradeFinMonitViewHelper viewHelper = new TradeFinMonitViewHelper();
    protected ClienteSelecaoVO clienteSelecaoVO = new ClienteSelecaoVO();
    protected CustoExternoVO custoExternoVO = new CustoExternoVO();
    protected UnidadeExternaVO externaVO = new UnidadeExternaVO();
    protected List<SelectItem> produto = new ArrayList<SelectItem>();
    protected TradeFinanceVO tradeFinanceVO = new TradeFinanceVO();
    protected TradeFinanceFiltroVO filtroVO = new TradeFinanceFiltroVO();
    protected List<TradeFinanceListaVO> lista = new ArrayList<TradeFinanceListaVO>();
    protected TradeFinanceListaVO tradeFinanceListaVO = new TradeFinanceListaVO();
    protected Boolean firme = Boolean.FALSE;
    protected Boolean indicativa = Boolean.FALSE;
    
    protected List<ListaCotacoesExternasVO> listaCotacoesExt = new ArrayList<ListaCotacoesExternasVO>();
    protected List<ListaDespesasVO> listaDespesas = new ArrayList<ListaDespesasVO>();
    protected List<ListaParcelasDesembolsoVO> parcelaDesembList = new ArrayList<ListaParcelasDesembolsoVO>();
    protected List<ListaResponsavelDespesaVO> responsavelDespList = new ArrayList<ListaResponsavelDespesaVO>();
    protected BeneficiarioVO beneficiario = new BeneficiarioVO();
    protected BeneficiarioVO afiancado = new BeneficiarioVO();
    protected ListaResponsavelDespesaVO despListSelecionado = new ListaResponsavelDespesaVO();
    protected ListaCotacoesExternasVO listaCotacoes = new ListaCotacoesExternasVO();
    
    protected InformacaoPilotoVO infoPiloto = new InformacaoPilotoVO();

    protected List<DeParaListaVO> listaDePara = new ArrayList<DeParaListaVO>();
    protected ComissaoCollection listaComissaoExt = new ComissaoCollection();

    String result = SiteUtil.STRING_EMPTY;
    protected static final Integer TIPO_OBS_OBSERVACAO = 1;
    protected static final Integer SITUACAO_BLETO_DEVOLVER_CUSTO_UNID_EXT = 35;
    protected static final Integer SITUACAO_BLETO_DEVOLVER_DIVERGENCIA = 38;
    
    /**
     * Controle de execução
     */
    protected Integer funcaoExecutando = 0;

    protected Date limiteCtc = null;
    protected UnidadeExternaVO unidadeExternaVO = new UnidadeExternaVO();
    protected UnidadeExternaVO bancoReembolsadorVO = new UnidadeExternaVO();
    protected UnidadeExternaVO bancoAvisadorVO = new UnidadeExternaVO();
    protected ListaResponsavelDespesaVO despSelecionado = new ListaResponsavelDespesaVO();
    
    /** Desenquadradas */
    private DesenquadramentoVO desenquadradas = new DesenquadramentoVO();
 
    @Inject
    @Named("devolverModalBean")
    protected DevolverModalBean devolverModalBean;

    @Inject
    @Named("comissaoExtManutModalBean")
    protected ComissaoExtManutModalBean comissaoExtManutModalBean;

    @Inject
    @Named("tradeFinanceNegociacaoService")
    protected ITradeFinanceNegociacaoService tradeFinanceNegociacaoService;

    @Inject
    @Named("tradeFinanceMonitService")
    protected ITradeFinanceMonitService tradeFinanceMonitService;

    @Inject
    @Named("tradeFinanceBean")
    protected TradeFinanceBean tradeFinanceBean;

    @Inject
    @Named("tradeFinMonitBean")
    protected TradeFinMonitBean tradeFinMonitBean;
    
    @Inject
    @Named("tradeFinanceLogBean")
    protected TradeFinanceLogBean tradeFinanceLogBean;

    @Inject
    @Named("tradeFinMonitFormalizacaoBean")
    private TradeFinMonitFormalizacaoBean tradeFinMonitFormalizacaoBean;

    @Inject
    @Named("clienteModalBean")
    protected ClienteModalBean clienteModalBean;

    @Inject
    @Named("unidadeExternaModalBean")
    protected UnidadeExternaModalBean unidadeExternaModalBean;

    @Inject
    @Named("operadorModalBean")
    protected OperadorModalBean operadorModalBean;

    @Inject
    @Named("selectItemBean")
    protected SelectItemBean selectItemBean;

    @Inject
    @Named("limitesModalBean")
    protected LimitesModalBean limitesModalBean;
    
    @Inject
    @Named("commonService")
    private ICommonService commonService;
    
    @Inject
    @Named("desenquadradasModalBean")
    protected DesenquadradasModalBean desenquadradasModalBean;
    
    @Inject
    @Named("tomadorModalBean")
    protected TomadorModalBean tomadorModalBean;
    
    @Inject
    @Named("benefModalBean")
    protected BenefModalBean benefModalBean;
    
    @Inject
    @Named("garantiasModalBean")
    private GarantiasModalBean garantiasModalBean;
    
    @Inject
    @Named("agendaSwapBean")
    private AgendaSwapBean agendaSwapBean;
     
    /**
     * 
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
     *      Registro de Manutenção: 18/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void limparCpfCnpjCliente(AjaxBehaviorEvent e) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.limparCpfCnpjCliente <<<<<<<<<<<");
	    	
	        this.getClienteSelecaoVO().setCnpj(null);
	        this.getClienteSelecaoVO().setCpf(null);
	
	        limparCpfCnpj();
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.limparCpfCnpjCliente <<<<<<<<<<<");
    	}
    }

    private void limparCpfCnpj() {
    	
    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.limparCpfCnpj <<<<<<<<<<<");
    	
        if (getViewHelper().getCpfBinding() != null) {
            getViewHelper().getCpfBinding().setSubmittedValue(null);
        }

        if (getViewHelper().getCnpjBinding() != null) {
            getViewHelper().getCnpjBinding().setSubmittedValue(null);
        }
        
        BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.limparCpfCnpj <<<<<<<<<<<");
    }

    /**
     * 
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
     *      Registro de Manutenção: 18/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerMudaCpfCnpjCliente(AjaxBehaviorEvent e) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.listenerMudaCpfCnpjCliente <<<<<<<<<<<");
	    	
	        this.clienteSelecaoVO.setCnpj(new CnpjDataType());
	        this.clienteSelecaoVO.setCpf(new CpfDataType());
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.listenerMudaCpfCnpjCliente <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: listenerPesquisarClienteNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarOperador(AjaxBehaviorEvent e) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.listenerPesquisarOperador <<<<<<<<<<<");
	    	
	        operadorModalBean.setOperadorSel(getFiltroVO().getOperadorVO());
	        operadorModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalOperador");
	        operadorModalBean.openModal();
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.listenerPesquisarOperador <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: listenerPesquisarClienteNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteNome(AjaxBehaviorEvent e) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.listenerPesquisarClienteNome <<<<<<<<<<<");
	
	        // Verifica se o campo de cliente está preenchido, caso não esteja, retorna uma mensagem
	        if (getClienteSelecaoVO().getNomeCliente().length() <= 0) {
	            NpcFacesUtils.addInfoModalMessage("Preencha o campo Cliente.", false);
	            return;
	        }
	
	        getClienteSelecaoVO().setCodCpfCnpj(Numeros.UM);
	        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
	        clienteModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalCliente");
	        // clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(Numeros.UM);
	        clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(getViewHelper().getCodCpfCnpjSelecionado());
	        clienteModalBean.getViewHelper().setPesqCpf(Boolean.FALSE);
	        clienteModalBean.openModal();
	        getViewHelper().setRenderModalCliente(Boolean.TRUE);
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.listenerPesquisarClienteNome <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: listenerPesquisarClienteCpfCnpj
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteCpfCnpj(AjaxBehaviorEvent e) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.listenerPesquisarClienteCpfCnpj <<<<<<<<<<<");
	
	        Integer cpfCnpjSelecionado = getViewHelper().getCodCpfCnpjSelecionado();
	
	        // Verifica se o campo de CPF/CNPJ foi preenchido, caso contrário apresenta mensagem na tela.
	        if (cpfCnpjSelecionado == Numeros.DOIS && getClienteSelecaoVO().getCnpj().toString().equals("")) {
	
	            NpcFacesUtils.addInfoModalMessage("Preencha o campo CNPJ.", false);
	            return;
	        } else if (cpfCnpjSelecionado == Numeros.TRES && getClienteSelecaoVO().getCpf().toString().equals("")) {
	
	            NpcFacesUtils.addInfoModalMessage("Preencha o campo CPF.", false);
	            return;
	        }
	
	        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
	        clienteModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalCliente");
	
	        getClienteSelecaoVO().setCodCpfCnpj(getViewHelper().getCodCpfCnpjSelecionado());
	        clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(cpfCnpjSelecionado);
	
	        clienteModalBean.getViewHelper().setPesqCpf(Boolean.TRUE);
	        clienteModalBean.openModal();
	        getViewHelper().setRenderModalCliente(Boolean.TRUE);
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.listenerPesquisarClienteCpfCnpj <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: openModalUnidadeExterna
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
    public void openModalUnidadeExterna(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.openModalUnidadeExterna <<<<<<<<<<<");
	
	        getFiltroVO().getUnidadeExternaVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
	
	        getTradeFinanceVO().getUnidadeExterna().setBancocorr(getTradeFinanceVO().getUnidadeExterna().getIbanqrcmbio());
	
	        unidadeExternaModalBean.setExternaVO(getFiltroVO().getUnidadeExternaVO());
	        unidadeExternaModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:content_modalUnidExt");
	        unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.UM);
	        unidadeExternaModalBean.getViewHelper().setItemSelecListaUnidExt(null);
	        unidadeExternaModalBean.pesquisarUnidExtPorNome();
	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.openModalUnidadeExterna <<<<<<<<<<<");
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
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.openModalUnidExternaBcCorresp <<<<<<<<<<<");
	    	

            getUnidadeExternaVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
            
	        unidadeExternaModalBean.setExternaVO(getUnidadeExternaVO());
            unidadeExternaModalBean.getViewHelper().setIsConfirmar(Boolean.FALSE);
	        unidadeExternaModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:content_modalUnidExt");
	        unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.UM);
	        unidadeExternaModalBean.getViewHelper().setItemSelecListaUnidExt(null);
	        unidadeExternaModalBean.pesquisarUnidExtPorNome();
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.openModalUnidExternaBcCorresp <<<<<<<<<<<");
    	}
    }

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
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.openModalBcDesembReemb <<<<<<<<<<<");
	    	
	        getBancoReembolsadorVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
	        
	        unidadeExternaModalBean.setExternaVO(getBancoReembolsadorVO());
            unidadeExternaModalBean.getViewHelper().setIsConfirmar(Boolean.FALSE);
	        unidadeExternaModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:content_modalUnidExt");
	        unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.DOIS);
	        unidadeExternaModalBean.getViewHelper().setItemSelecListaUnidExt(null);
	        unidadeExternaModalBean.pesquisarUnidExtPorNome();
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.openModalBcDesembReemb <<<<<<<<<<<");
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
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.openModalBcAvisador <<<<<<<<<<<");
            
            getBancoAvisadorVO().setTipoPesquisaUnidExt(EnumTradeFinance.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
            
            unidadeExternaModalBean.setExternaVO(getBancoAvisadorVO());
            unidadeExternaModalBean.getViewHelper().setIsConfirmar(Boolean.FALSE);
            unidadeExternaModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:content_modalUnidExt");
            unidadeExternaModalBean.getViewHelper().setModalidade(Numeros.TRES);
            unidadeExternaModalBean.getViewHelper().setItemSelecListaUnidExt(null);
            unidadeExternaModalBean.pesquisarUnidExtPorNome();
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.openModalBcAvisador <<<<<<<<<<<");
        }
    }    
    
    /**
     * Nome: validarCamposData
     * 
     * Propósito:
     *
     * @param :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public boolean validarCamposData() {

    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.validarCamposData <<<<<<<<<<<");
	    	
	        Boolean isValid = true;
	        Boolean filterIsEmpty = !existeValorParaPesquisa();
	        String validationMessage = SiteUtil.STRING_EMPTY;
	
	        Boolean validaPeriodoFechamento = (viewHelper.getTradeFinanceMonitor().equals(1) || viewHelper.getTradefinanceMonitFormalizacao().equals(2));
	        
	
	        // valida filtro obrigatório
	        if(validaPeriodoFechamento && 
	                        ((filtroVO.getPeriodoCotacao() == null || filtroVO.getPeriodoCotacao().isIndeterminado()) 
	                                        && (filtroVO.getPeriodoFech() == null || filtroVO.getPeriodoFech().isIndeterminado())
	                                        && SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())
	                                        && SiteUtil.isEmptyOrNull(filtroVO.getDanobase()))) {
	            validationMessage = "É obrigatório informar um Período ou uma Cotação para realizar a pesquisa.";
	            isValid &= false;
	        } else if (!validaPeriodoFechamento && 
	                        (filtroVO.getPeriodoCotacao() == null || filtroVO.getPeriodoCotacao().isIndeterminado())
	                        && SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())
	                        && SiteUtil.isEmptyOrNull(filtroVO.getDanobase())) {
	            validationMessage = "É obrigatório informar um Período ou uma Cotação para realizar a pesquisa.";
	            isValid &= false;
	        } 
	
	        else {
	
	            // valida Numero Cotação
	            if (SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())
	                            && !SiteUtil.isEmptyOrNull(filtroVO.getDanobase())) {
	                validationMessage = "Informe o Número Cotação.";
	                isValid &= false;
	            } else if (!SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())
	                            && SiteUtil.isEmptyOrNull(filtroVO.getDanobase())) {
	                validationMessage = "Informe o Ano da Cotação.";
	                isValid &= false;
	            }
	
	            // Valida o Período da Cotação
	            if (filtroVO.getPeriodoCotacao() != null
	                            && (filtroVO.getPeriodoCotacao().getInicio() != null || filtroVO.getPeriodoCotacao().getFim() != null)
	                            && !filtroVO.getPeriodoCotacao().isValid()) {
	                validationMessage = filtroVO.getPeriodoCotacao().getMensagemValidacao("Período da Cotação");
	                isValid &= false;
	            
	            // Valida quantidade de dias do periodo da cotação
	            }else if (filterIsEmpty 
	                            && filtroVO.getPeriodoCotacao() != null 
	                            && filtroVO.getPeriodoCotacao().getDiasPeriodo() > 366) {
	                validationMessage = "Para pesquisas apenas com período o intervalo máximo é de 365 dias.";
	                isValid &= false;
	            
	            
	            // Valida quantidade de dias do periodo da cotação
	            }else if (filterIsEmpty 
	            		&& filtroVO.getPeriodoCotacao() != null 
	            		&& filtroVO.getPeriodoCotacao().getDiasPeriodo() > 90 && SiteUtil.isEmptyOrNull(getClienteSelecaoVO().getNomeCliente())) {
	            	validationMessage = "Para pesquisas com intervalo entre 90 e 365 dias é necessário informar o cliente.";
	            	isValid &= false;
	            	
	            	
	            	// Valida quantidade de dias do periodo da cotação
	            }else if (filterIsEmpty 
	            		&& filtroVO.getPeriodoCotacao() != null 
	            		&& filtroVO.getPeriodoCotacao().getDiasPeriodo() > 30 && SiteUtil.isEmptyOrNull(getClienteSelecaoVO().getNomeCliente()) && SiteUtil.isEmptyOrNull(getFiltroVO().getCprodtservc()) ) {
	            	validationMessage = "Para pesquisas com intervalo entre 30 e 90 dias é necessário informar o produto ou cliente.";
	            	isValid &= false;
	            	
	            	
	            } else if (filtroVO.getPeriodoCotacao() != null 
                        && filtroVO.getPeriodoCotacao().getDiasPeriodo() > -1) {
	                isValid &= true;
	            } 
	
	            // Valida o Período do Fechamento
	            if (validaPeriodoFechamento && filtroVO.getPeriodoFech() != null
	                            && (filtroVO.getPeriodoFech().getInicio() != null || filtroVO.getPeriodoFech().getFim() != null)
	                            && !filtroVO.getPeriodoFech().isValid()) {
	                validationMessage = filtroVO.getPeriodoFech().getMensagemValidacao("Período do Fechamento");
	                isValid &= false;
//	            }
	            // Valida quantidade de dias do periodo de fechamento
	            //Kamban Defeito TH - ID 946 - pede para que retire essa restricao    
//	            else if (filterIsEmpty && validaPeriodoFechamento
//	                            && filtroVO.getPeriodoFech() != null 
//	                            && filtroVO.getPeriodoFech().getDiasPeriodo() > 30) {
//	                validationMessage = "Para pesquisas apenas com período o intervalo máximo é de 30 dias.";
//	                isValid &= false;
	            } else if (validaPeriodoFechamento 
	                            && filtroVO.getPeriodoFech() != null 
	                            && filtroVO.getPeriodoFech().getDiasPeriodo() > -1) {
	                isValid &= true;
	            }
	        } 
	
	        
	        // exibe o modal com as mensagems lançadas pelas validações.
	        if (!isValid) {
	            BradescoFacesUtils.addInfoModalMessage(validationMessage, false);
	            return false;
	        }
	
	        return true;
	        
	    }finally{
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.validarCamposData <<<<<<<<<<<");
		}
    }
    
    /**
     * Nome: validaCamposDataBatch
     * 
     * Propósito:
     *
     * @param :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/05/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public boolean validaCamposDataBatch() {
        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.validaCamposDataBatch <<<<<<<<<<<");
            
            Boolean isValid = true;
            String validaMensagem = SiteUtil.STRING_EMPTY;
            
            if (filtroVO.getPeriodoCotacao() == null || filtroVO.getPeriodoCotacao().isIndeterminado()) {
                validaMensagem = "É obrigatório informar um período";
                isValid &= false;
            }
            
            // Valida o Período da Cotação
            if (filtroVO.getPeriodoCotacao() != null
                            && (filtroVO.getPeriodoCotacao().getInicio() != null || filtroVO.getPeriodoCotacao().getFim() != null)
                            && !filtroVO.getPeriodoCotacao().isValid()) {
                validaMensagem = filtroVO.getPeriodoCotacao().getMensagemValidacao("Período da Cotação");
                isValid &= false;
            }
            
            // exibe o modal com as mensagems lançadas pelas validações.
            if (!isValid) {
                BradescoFacesUtils.addInfoModalMessage(validaMensagem, false);
                return false;
            }
            
            return true;
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.validaCamposDataBatch <<<<<<<<<<<");
        }
        
    }
    
    /**
     * Nome: existeValorParaPesquisa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public boolean existeValorParaPesquisa() {

    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.existeValorParaPesquisa <<<<<<<<<<<");
	    	
	        // Caso o cpf tenha sido informado retorna verdadeiro
	        if (getFiltroVO().getCpf() != null && !SiteUtil.isEmptyOrNull(getFiltroVO().getCpf().toString())) {
	            return true;
	        }
	
	        // Caso o cpnj tenha sido informado retorna verdadeiro
	        if (getFiltroVO().getCnpj() != null && !SiteUtil.isEmptyOrNull(getFiltroVO().getCnpj().toString())) {
	            return true;
	        }
	
	        // Caso qualquer outro campo tenha sido informado retorna verdadeiro
	        return !SiteUtil.isEmptyOrNull(getFiltroVO().getNmcliente())
	                        || !SiteUtil.isEmptyOrNull(getFiltroVO().getCusuarincl());
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.existeValorParaPesquisa <<<<<<<<<<<");
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
     *      Registro de Manutenção: 07/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal() {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.closeModal <<<<<<<<<<<");
	    	
	        getViewHelper().setCodCpfCnpjSelecionado(clienteModalBean.getViewHelper().getCodCpfCnpjSelecionado());
	        clienteModalBean.closeModal(null);
	        getViewHelper().setRenderModalCliente(Boolean.FALSE);
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.closeModal <<<<<<<<<<<");
    	}
    }

    /**
     * Nome: listenerLimparPesquisa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerLimparPesquisa(AjaxBehaviorEvent eventAjaxBehavior) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.listenerLimparPesquisa <<<<<<<<<<<");
	    	
	        // inicia variáveis
	        filtroVO = new TradeFinanceFiltroVO();
	        lista = new ArrayList<TradeFinanceListaVO>();
	        clienteSelecaoVO = new ClienteSelecaoVO();
	        externaVO = new UnidadeExternaVO();
	        tradeFinanceVO = new TradeFinanceVO();
	        getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
	        setFirme(Boolean.FALSE);
	        setIndicativa(Boolean.FALSE);
	        getViewHelper().setCtcSelecionado(null);
	        getViewHelper().setDisabledBotaoDetGar(Boolean.FALSE);
	        getViewHelper().setCustoExterno(Boolean.FALSE);
	        getViewHelper().setUnidadeExterna(Boolean.FALSE);
	        getViewHelper().setDivergente(Boolean.FALSE);
	        getViewHelper().setCtcSelecionado(null);
// BRQ - 25/06/19 - Erro Menu Trade
	        if (eventAjaxBehavior != null) {
	        	try {
	        tradeFinanceBean.getViewHelper().setDisabledBotaoDetGar(Boolean.TRUE);
				} catch (Exception e) {
					BradescoCommonServiceFactory.getLogManager().info("Erro - listenerLimparPesquisa: ", e.getMessage());
				}
			}
//	        tradeFinanceBean.getViewHelper().setDisabledBotaoDetGar(Boolean.TRUE);
// BRQ - 25/06/19 - Erro Menu Trade

	        listaCotacoesExt = new ArrayList<ListaCotacoesExternasVO>();
	        listaDespesas = new ArrayList<ListaDespesasVO>();
	        parcelaDesembList = new ArrayList<ListaParcelasDesembolsoVO>();
	        responsavelDespList = new ArrayList<ListaResponsavelDespesaVO>();
	        
	        despListSelecionado = new ListaResponsavelDespesaVO();
	        
	        getFiltroVO().getPeriodoCotacao().setInicio(new Date());
	        getFiltroVO().getPeriodoCotacao().setFim(new Date());
	        getViewHelper().setTradeFinanceLog(null);
	        
	        
	        //metodo para limpar o cpf / cnpj quando clicado no botao limpar 
	        setClienteSelecaoVO(new ClienteSelecaoVO());
	        getClienteSelecaoVO().setCnpj(new CnpjDataType());
	        getClienteSelecaoVO().setCpf(new CpfDataType());
	        limparCpfCnpj();
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.listenerLimparPesquisa <<<<<<<<<<<");
    	}
	        
    }
    
    /**
     * Nome: actionExportar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 10/05/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionExportar(Boolean renderMonitor) {
        try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.actionExportar <<<<<<<<<<<");
	
	    	 
	        
	        if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("viewObject", tradeFinanceBean.getTradeFinanceVO());
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("listaDesembolso", tradeFinanceBean.getDesembolsoVO());
	            tradeFinanceBean.carregarQuadroJurosForfaiting();

	            // Carrega os produtos que não é FORFAITING
	        } else {
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("dadosBasico", tradeFinanceBean.getTradeFinanceVO());          
	        }
	        // Aline 29/09/2016 - Para todos os produtos inclusive o forfaiting que trará as observações.
	        BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("obsCotacaoVO", tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO());


	        if (!tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPos() && !tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPre()  && !tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PROEX)) {

	            if (!tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia()) {
	                BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("oprVincList", tradeFinanceBean.getOprVincList());
	                BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("mercadoriaList", tradeFinanceBean.getMercadoriaList());
	                
	                if (!tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {

		            	if (tradeFinanceBean.getFluxoPgtList().size() > Numeros.ZERO) {
		            		FluxoPagamentoVO pagamentoVO = null;
		
		            		for (Iterator<FluxoPagamentoVO> iterator = tradeFinanceBean.getFluxoPgtList().iterator(); iterator.hasNext();) {
		            			pagamentoVO = (FluxoPagamentoVO) iterator.next();
		                        pagamentoVO = tradeFinanceMonitService.obterFluxoPgtDet(pagamentoVO,
		                        		tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio(), tradeFinanceBean.getTradeFinanceVO().getHinclreghist());
		
		                        tradeFinanceBean.ordenarListaParcelasFluxoPgto(pagamentoVO.getLista());
		            		}
		            	}
	                	
	                    BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("fluxoPgtList", tradeFinanceBean.getFluxoPgtList());
	                }

	            }

	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("comissaoExtList", tradeFinanceBean.getComissaoExtList());
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("tarifaList", tradeFinanceBean.getTarifaList());
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("moedaList", tradeFinanceBean.getMoedaList());

	        }

	        if (!tradeFinanceBean.getTradeFinanceVO().getProduto().isNce() && !tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPos()
	                        && !tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPre() && !tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PROEX)) {

	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("comissaoIntList", tradeFinanceBean.getComissaoIntList());
	        }

	        if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.FINIMP_ECA)
	                        || tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	           
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("cotacoesList", tradeFinanceBean.getCotacoesList());
	        }

	        if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("parcelaDesembList", tradeFinanceBean.getParcelaDesembList());
	        }

	        if (tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia()) {
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("responsavelDespList",tradeFinanceBean.getResponsavelDespList()); 
               
	            
	            // Validação necessária, pois se no serviço de Resposanvel despesa vir o codigo do beneficiario 0 não deverá entrar no serviço
	            if(tradeFinanceBean.getResponsavelDespList().getCunicpssoabnf() != Numeros.ZERO) {
	                
	                BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("beneficiario",tradeFinanceBean.getBeneficiario());   
	                
	            }
	            
	            // Validação necessária, pois se no serviço de Resposanvel despesa vir o codigo do afiançador 0 não deverá entrar no serviço
	            if(tradeFinanceBean.getResponsavelDespList().getCunicpssoaafi() != Numeros.ZERO) { 
	                
	                BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("afiancado",tradeFinanceBean.getAfiancado());   
	            }              
	               
	        }
	        if(tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia() || tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
	                        || tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
	            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("listaDespesas",tradeFinanceBean.getListaDespesas());     
	        }
	        
	        garantiasModalBean.setNcunicclicmbio(tradeFinanceBean.getTradeFinanceVO().getNcunicclicmbio());
            garantiasModalBean.setDprodtservc(tradeFinanceBean.getTradeFinanceVO().getDprodtservc());
            garantiasModalBean.setNbletonegoccmbio(tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());
            garantiasModalBean.setNseqcontrlim(tradeFinanceBean.getTradeFinanceVO().getNseqcontrlim());
            
            garantiasModalBean.setNppstapontucmbio(tradeFinanceBean.getTradeFinanceVO().getNppstapontucmbio());
            garantiasModalBean.setCcpfcnpj(tradeFinanceBean.getTradeFinanceVO().getCpfcnpj());
            garantiasModalBean.setCflialcpfcnpj(tradeFinanceBean.getTradeFinanceVO().getCflial());
            garantiasModalBean.setCctrlcpfcnpj(tradeFinanceBean.getTradeFinanceVO().getCctrl());
            
            garantiasModalBean.carregarGarantias();
	        
	        tradeFinanceBean.getViewHelper().setRenderMonitor(renderMonitor);

	        return carregaTela(tradeFinanceBean.getTradeFinanceVO());

    	}finally{
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.actionExportar <<<<<<<<<<<");
    	}
    }

    private String carregaTela(TradeFinanceVO operacao) {
    	
        String result = SiteUtil.STRING_EMPTY;
       
        if (tradeFinMonitBean.getViewHelper().getTradeFinanceMonitor().equals(Numeros.UM)
                        || tradeFinanceLogBean.getViewHelper().getTradeFinanceLog().equals(Numeros.TRES) 
                        || agendaSwapBean.getViewHelper().getTradeFinanceAgendaSWAP().equals(Numeros.QUATRO)) {

            if (operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_FINIMP_DIRETO.getCodigo())
                            || operacao.getProduto().getCodigo()
                                            .equals(EnumProduto.PRODUTO_FINIMP_INDIRETO.getCodigo())
                            || operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_LEI_4131.getCodigo())
                            || operacao.getProduto().getCodigo()
                                            .equals(EnumProduto.PRODUTO_REFINIMP_DIRETO.getCodigo())
                            || operacao.getProduto().getCodigo()
                                            .equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO.getCodigo())) {

                return "produtosPrintTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_P_P_E.getCodigo())) {
                return "cotacaoPPETemplate";
            }
            
            if (operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_WORKING_CAPITAL.getCodigo())) {
                return "workingCapitalTemplate";
            }
            
            if (operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                return "forfaitingTemplate";
            }

            if (operacao.getProduto().isBndesPos()) {
                return "bndesPosTemplate";
            }

            if (operacao.getProduto().isBndesPre()) {
                return "bndesPreTemplate";
            }

            if (operacao.getProduto().isGarantia()) {
                return "garantiaIntExpTemplate";
            }

            if (operacao.getProduto().isNce()) {
                return "nceTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.FINIMP_ECA.getCodigo())) {
                return "finimpEcaTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.LC_IMPORTACAO.getCodigo())) {
                return "lcImportacaoTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.PROEX.getCodigo())) {
                return "proexTemplate";
            }

        } else if (tradeFinMonitFormalizacaoBean.getViewHelper().getTradefinanceMonitFormalizacao()
                        .equals(Numeros.DOIS)) {

            if (operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                return "forfaitingAnalisarTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_FINIMP_DIRETO.getCodigo())
                            || operacao.getProduto().getCodigo()
                                            .equals(EnumProduto.PRODUTO_FINIMP_INDIRETO.getCodigo())
                            || operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_LEI_4131.getCodigo())
                            || operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_P_P_E.getCodigo())
                            || operacao.getProduto().getCodigo()
                                            .equals(EnumProduto.PRODUTO_REFINIMP_DIRETO.getCodigo())
                            || operacao.getProduto().getCodigo()
                                            .equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO.getCodigo())) {

                return "analisarProdutosTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.PRODUTO_WORKING_CAPITAL.getCodigo())) {
                return "workingCapitalAnalisarTemplate";
            }

            if (operacao.getProduto().isBndesPos()) {
                return "bndesPosAnalisarTemplate";
            }

            if (operacao.getProduto().isBndesPre()) {
                return "bndesPreAnalisarTemplate";
            }

            if (operacao.getProduto().isGarantia()) {
                return "garantiaIntExpAnalisarTemplate";
            }

            if (operacao.getProduto().isNce()) {
                return "nceAnalisarTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.FINIMP_ECA.getCodigo())) {
                return "finimpEcaAnalisarTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.LC_IMPORTACAO.getCodigo())) {
                return "lcImportacaoAnalisarTemplate";
            }

            if (operacao.getProduto().getCodigo().equals(EnumProduto.PROEX.getCodigo())) {
                return "proexAnalisarTemplate";
            }

        }

        return result;

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
            
            desenquadradas.atualizaValores(tradeFinanceBean.getTradeFinanceVO());
            
            // PROEX - Não trata Desenquadradas
            // BNDES POS - Não deve desenquadrar quando estiver sem limite e o "Garantidor Bradesco" for igual a NÃO.
            if(!tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PROEX)
                    && !tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPos()
                    || (tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPos() 
                            && tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGarangarant().equals(EnumSimNaoStr.SIM.getCodigo()))) {
            
                // Abre o modal de desenquadradas se os valores foram atualizados, ou não possui um limite selecionado
                // e se o Cliente está ativo no piloto
                if (desenquadradas.getValoresAtualizados()
                        || (SiteUtil.isEmptyOrNull(desenquadradas.getNseqcontrlim())
                                && SiteUtil.isEmptyOrNull(desenquadradas.getNppstapontucmbio()) 
                                && tradeFinanceBean.getViewHelper().isOperaComLimite())) {
                    
                    desenquadradasModalBean.setDesenquadradas(desenquadradas);
                    desenquadradasModalBean.getViewHelper().setTelaOrigem(telaOrigem);
                    desenquadradasModalBean.openModal();
                    
                    // Verifica o indicador de desenquadradas e se já não foi informada a justificativa  
                    if (desenquadradas.getInddqmto().equals(SiteUtil.STRING_S)) {
                        desenquadradasModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalDesenquadradas");
                        desenquadradasModalBean.getViewHelper().setRenderModalDesenquadradas(Boolean.TRUE);
                        result = Boolean.TRUE;
                    }
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
             getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.closeModalDesenquadradas <<<<<<<<<<<");

             // recupera a justificativa informada
             tradeFinanceBean.getTradeFinanceVO().setRjustfdqmto(desenquadradasModalBean.getDesenquadradas().getJustificativa());
             
             desenquadradasModalBean.closeModal(event);
             
             // botão Confirmar
             if (desenquadradasModalBean.getViewHelper().getBotaoAcionado().equals(DesenquadradasModalBean.BTN_CONFIRMAR)) {
                 
                 continuarConfirmar();
             }        
             
         }finally{
             getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.closeModalDesenquadradas <<<<<<<<<<<");
         }
         
     }
     
     public abstract void continuarConfirmar();
    
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
     * @return o valor do custoExternoVO
     */
    public CustoExternoVO getCustoExternoVO() {
        return custoExternoVO;
    }

    /**
     * @param custoExternoVO seta o novo valor para o campo custoExternoVO
     */
    public void setCustoExternoVO(CustoExternoVO custoExternoVO) {
        this.custoExternoVO = custoExternoVO;
    }

    /**
     * @return o valor do externaVO
     */
    public UnidadeExternaVO getExternaVO() {
        return externaVO;
    }

    /**
     * @param externaVO seta o novo valor para o campo externaVO
     */
    public void setExternaVO(UnidadeExternaVO externaVO) {
        this.externaVO = externaVO;
    }

    /**
     * @return o valor do filtroVO
     */
    public TradeFinanceFiltroVO getFiltroVO() {
        return filtroVO;
    }

    /**
     * @param filtroVO seta o novo valor para o campo filtroVO
     */
    public void setFiltroVO(TradeFinanceFiltroVO filtroVO) {
        this.filtroVO = filtroVO;
    }

    /**
     * @return o valor do clienteModalBean
     */
    public ClienteModalBean getClienteModalBean() {
        return clienteModalBean;
    }

    /**
     * @param clienteModalBean seta o novo valor para o campo clienteModalBean
     */
    public void setClienteModalBean(ClienteModalBean clienteModalBean) {
        this.clienteModalBean = clienteModalBean;
    }

    /**
     * @return o valor do unidadeExternaModalBean
     */
    public UnidadeExternaModalBean getUnidadeExternaModalBean() {
        return unidadeExternaModalBean;
    }

    /**
     * @param unidadeExternaModalBean seta o novo valor para o campo unidadeExternaModalBean
     */
    public void setUnidadeExternaModalBean(UnidadeExternaModalBean unidadeExternaModalBean) {
        this.unidadeExternaModalBean = unidadeExternaModalBean;
    }

    /**
     * @return o valor do operadorModalBean
     */
    public OperadorModalBean getOperadorModalBean() {
        return operadorModalBean;
    }

    /**
     * @param operadorModalBean seta o novo valor para o campo operadorModalBean
     */
    public void setOperadorModalBean(OperadorModalBean operadorModalBean) {
        this.operadorModalBean = operadorModalBean;
    }

    /**
     * @return o valor do viewHelper
     */
    public TradeFinMonitViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(TradeFinMonitViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do produto
     */
    public List<SelectItem> getProduto() {
        return produto;
    }

    /**
     * @param produto seta o novo valor para o campo produto
     */
    public void setProduto(List<SelectItem> produto) {
        this.produto = produto;
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
     * @return o valor do tradeFinanceVO
     */
    public TradeFinanceVO getTradeFinanceVO() {
        return tradeFinanceVO;
    }

    /**
     * @param tradeFinanceVO seta o novo valor para o campo tradeFinanceVO
     */
    public void setTradeFinanceVO(TradeFinanceVO tradeFinanceVO) {
        this.tradeFinanceVO = tradeFinanceVO;
    }

    /**
     * @return o valor do lista
     */
    public List<TradeFinanceListaVO> getLista() {
        return lista;
    }

    /**
     * @param lista seta o novo valor para o campo lista
     */
    public void setLista(List<TradeFinanceListaVO> lista) {
        this.lista = lista;
    }

    /**
     * @return o valor do tradeFinanceListaVO
     */
    public TradeFinanceListaVO getTradeFinanceListaVO() {
        return tradeFinanceListaVO;
    }

    /**
     * @param tradeFinanceListaVO seta o novo valor para o campo tradeFinanceListaVO
     */
    public void setTradeFinanceListaVO(TradeFinanceListaVO tradeFinanceListaVO) {
        this.tradeFinanceListaVO = tradeFinanceListaVO;
    }

    /**
     * @return o valor do firme
     */
    public Boolean getFirme() {
        return firme;
    }

    /**
     * @param firme seta o novo valor para o campo firme
     */
    public void setFirme(Boolean firme) {
        this.firme = firme;
    }

    /**
     * @return o valor do indicativa
     */
    public Boolean getIndicativa() {
        return indicativa;
    }

    /**
     * @param indicativa seta o novo valor para o campo indicativa
     */
    public void setIndicativa(Boolean indicativa) {
        this.indicativa = indicativa;
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
     * @return o valor do listaDePara
     */
    public List<DeParaListaVO> getListaDePara() {
        return listaDePara;
    }

    /**
     * @param listaDePara seta o novo valor para o campo listaDePara
     */
    public void setListaDePara(List<DeParaListaVO> listaDePara) {
        this.listaDePara = listaDePara;
    }

    /**
     * @return o valor do listaComissaoExt
     */
    public ComissaoCollection getListaComissaoExt() {
        return listaComissaoExt;
    }

    /**
     * @param listaComissaoExt seta o novo valor para o campo listaComissaoExt
     */
    public void setListaComissaoExt(ComissaoCollection listaComissaoExt) {
        this.listaComissaoExt = listaComissaoExt;
    }

    /**
     * @return o valor do result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result seta o novo valor para o campo result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return o valor do limiteCtc
     */
    public Date getLimiteCtc() {
        return limiteCtc;
    }

    /**
     * @param limiteCtc seta o novo valor para o campo limiteCtc
     */
    public void setLimiteCtc(Date limiteCtc) {
        this.limiteCtc = limiteCtc;
    }

    /**
     * @return o valor do devolverModalBean
     */
    public DevolverModalBean getDevolverModalBean() {
        return devolverModalBean;
    }

    /**
     * @param devolverModalBean seta o novo valor para o campo devolverModalBean
     */
    public void setDevolverModalBean(DevolverModalBean devolverModalBean) {
        this.devolverModalBean = devolverModalBean;
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
     * @return o valor do unidadeExternaVO
     */
    public UnidadeExternaVO getUnidadeExternaVO() {
        return unidadeExternaVO;
    }

    /**
     * @param unidadeExternaVO seta o novo valor para o campo unidadeExternaVO
     */
    public void setUnidadeExternaVO(UnidadeExternaVO unidadeExternaVO) {
        this.unidadeExternaVO = unidadeExternaVO;
    }

    /**
     * @return o valor do bancoReembolsadorVO
     */
    public UnidadeExternaVO getBancoReembolsadorVO() {
        return bancoReembolsadorVO;
    }

    /**
     * @param bancoReembolsadorVO seta o novo valor para o campo bancoReembolsadorVO
     */
    public void setBancoReembolsadorVO(UnidadeExternaVO bancoReembolsadorVO) {
        this.bancoReembolsadorVO = bancoReembolsadorVO;
    }

    /**
     * @return o valor do bancoAvisadorVO
     */
    public UnidadeExternaVO getBancoAvisadorVO() {
        return bancoAvisadorVO;
    }

    /**
     * @param bancoAvisadorVO seta o novo valor para o campo bancoAvisadorVO
     */
    public void setBancoAvisadorVO(UnidadeExternaVO bancoAvisadorVO) {
        this.bancoAvisadorVO = bancoAvisadorVO;
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
     * @return o valor do despSelecionado
     */
    public ListaResponsavelDespesaVO getDespSelecionado() {
        return despSelecionado;
    }

    /**
     * @param despSelecionado seta o novo valor para o campo despSelecionado
     */
    public void setDespSelecionado(ListaResponsavelDespesaVO despSelecionado) {
        this.despSelecionado = despSelecionado;
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
     * @return the infoPiloto
     */
    public InformacaoPilotoVO getInfoPiloto() {
        return infoPiloto;
    }

    /**
     * @param infoPiloto the infoPiloto to set
     */
    public void setInfoPiloto(InformacaoPilotoVO infoPiloto) {
        this.infoPiloto = infoPiloto;
    }

}
