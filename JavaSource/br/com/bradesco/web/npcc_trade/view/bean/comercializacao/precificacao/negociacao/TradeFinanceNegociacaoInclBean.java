/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
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
package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UICnpj.UICnpj;
import br.com.bradesco.web.aq.view.components.UICpf.UICpf;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.comissaoIntExtModal.IComissaoInternaExternaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.CustoExternoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DadosGerarBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaRebateVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaTaxaDescontoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ObservacoesCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegPrecificacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.VincularOperacaoLcVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrizacao.IComissaoDesembolsoService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.bean.PrazoStandbyVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * Nome: TradeFinanceNegociacaoInclBean.java
 * 
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 03/05/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
@Named("tradeFinanceNegociacaoInclBean")
@SessionScoped
public class TradeFinanceNegociacaoInclBean extends TradeFinanceNegociacaoBase implements Serializable {

    /**
     * Atributes
     */
    private static final long serialVersionUID = 1L;
    
    private TradeFinanceListaVO dadosGerarBoleto = new TradeFinanceListaVO();
    private Boolean gerarBoletoIncl = false;
    private Boolean isDuplicar = false;

    /** Controle dos modais para evento Confirmar e Cotar Custo Externo */
    private int tipoAcessoIncluirEvento = Numeros.ZERO;
    
    @Inject
    @Named("comissaoInternaExternaModalService")
    private IComissaoInternaExternaModalService comissaoInternaExternaModalService;
     
    @Inject
	@Named("comissaodesembolsoService")
	private IComissaoDesembolsoService comissaodesembolsoservice;
    
    /**
     * 
     * Nome: iniciar
     * 
     * Prop�sito: Iniciar dados da tela
     * 
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 13/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String iniciar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.iniciar <<<<<<<<<<<");
    		
    		// Recarrega p�gina se n�o for um postback ou se foi marcado para
            // recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);
                
                iniciarPagina();
                
                tradeFinanceBean.setVincularOperacaoLcVO(new VincularOperacaoLcVO());
                vincularOperacaoLcBean.closeModal();
            }
    
    		return "tradeFinNegInicio";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.iniciar <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
     * Nome: iniciarPagina
     * 
     * Prop�sito: Iniciar dados da tela de inclus�o
     * 
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 13/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void iniciarPagina() {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [iniciarPagina] TradeFinanceNegociacaoInclBean.iniciarPagina <<<<<<<<<<<");
            
            fluxoPgtoManutModalBean.setIsAlterarCotacao(false);
            
            setFuncaoExecutando(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo());
            getTradeFinNegocVO().setCprodtservc(Numeros.ZERO);
            
            reIniciaInclusaoProduto();
            
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
            getViewHelper().setCodCpfCnpjDepositarioSelecionado(Numeros.DOIS);
            
            getViewHelper().setCnpjClienteBinding(new UICnpj());
            getViewHelper().setCpfClienteBinding(new UICpf());
            
            getViewHelper().setTelaInicioNegociacao(Boolean.TRUE);
            getViewHelper().setRenderDetalheCliente(Boolean.FALSE);
            getLimitesModalBean().getViewHelper().setRenderModal(Boolean.FALSE);
            getViewHelper().setRenderModalCliente(Boolean.FALSE);
            getTradeFinNegocVO().setCprodtservc(null);
            
            getViewHelper().setDisabledPercCDI(Boolean.TRUE);
            getViewHelper().setDisabledMaisCDI(Boolean.TRUE);
            getViewHelper().setDisabledTaxaPre(Boolean.TRUE);
            
            getViewHelper().setDisabledRadioTaxaPre(Boolean.TRUE);
            
            //variavel utilizada para o campo precificacao 
            //se for inclusao deve aparecer banco financiador e reembolsador
            //na alteracao eles nao podem aparecer
            getViewHelper().setCtrBotaoFluxo(0);
            
            getTradeFinNegocVO().getObsCotacaoVO().setGarangarant("1");
            getTradeFinNegocVO().getObsCotacaoVO().setTxapre("1");
            getViewHelper().setTelaRetorno("tradeFinNegInicio");
            
            //SEMPRE CARREGAR COMO 'BANCO BRADESCO' AO INICIAR A TELA
            getTradeFinNegocVO().setCidtfdcartacsndo(Numeros.DOIS);
            
            getTradeFinNegocVO().setCcobrcomismtori(Numeros.NUM3);
            getTradeFinNegocVO().setCcobrcomisagte(Numeros.NUM3);
            getTradeFinNegocVO().setPcomismtoricmbio("0");
            getTradeFinNegocVO().setPagtefincrcmbio("0");
            
            getTradeFinNegocVO().setVagtefincrcmbio("0");
            getTradeFinNegocVO().setVbcomtoricmbio("0");
            
            // Combo de despesa por conta (Garantia, lc e finimpEca)
            getViewHelper().setComboPorContaGarantia(selectItemBean.getComboPorContaGarantia());
            
            // LC Importacao Setar a data do dia
            getViewHelper().setDataLimiteEmbarque(new Date());
    
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.iniciarPagina <<<<<<<<<<<");
        }
    }

    /**
     * 
     * Nome: limparTela
     * 
     * Prop�sito: Limpar os dados da tela ao clicar no bot�o limpar
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 18/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public void limparTela(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.limparTela <<<<<<<<<<<");
    		limpaCamposCliente();
    		setIniciarPagina(true);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.limparTela <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: reIniciaInclusaoProduto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void reIniciaInclusaoProduto() {
        reIniciaInclusao(getTradeFinNegocVO().getCprodtservc());
    }

    /**
     * 
     * Nome: reIniciaInclusao
     * Prop�sito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     *
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    private void reIniciaInclusao(Integer codProduto) {

        String salvaTelaRetorno = getViewHelper().getTelaRetorno();

        setTradeFinNegocVO(new TrdFinNegocInclVO());

        getTradeFinNegocVO().setCprodtservc(codProduto);

        setViewHelper(new TradeFinanceNegociacaoViewHelper());
        getViewHelper().setTelaRetorno(salvaTelaRetorno);

        setClienteSelecaoVO(new ClienteSelecaoVO());
        getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
        
        setDesenquadradas(new DesenquadramentoVO());

        prepararInclusaoProduto();
    }

    /**
     * 
     * Nome: prepararInclusaoProduto
     * Prop�sito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     *
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    private void prepararInclusaoProduto() {

    	limparTradeFinNegocVO();

        setTrdFinNegMercadoriaVO(new TrdFinNegMercadoriaVO());
        setTrdFinNegPrecificacaoVO(new TrdFinNegPrecificacaoVO());
        setTomadorModal(new TrdFinNegMercadoriaVO());
        setPrazoStandbyVO(new PrazoStandbyVO());

        setTipoPesquisaCliente(Numeros.ZERO);

        setControleInclusaoAlteracao("DadosBasicos");

        setListaModalLimite(new ArrayList<TradeFinNegocListasVO>());

        setListaSelCliente(new ArrayList<TradeFinNegocListasVO>());
        setListaSelMercadoria(new ArrayList<TradeFinNegocListasVO>());
        setListaSelBeneficiario(new ArrayList<TradeFinNegocListasVO>());
        setListaUniExterna(new ArrayList<TradeFinNegocListasVO>());
        setListaDesembolso(new ArrayList<TradeFinanceDesembolsoVO>());

        setItemListaFluxoPgto(new TrdFinNegFluxoPagtoVO());
        setDesembolsoForfaitingVO(new TradeFinanceDesembolsoVO());

        setOperVinculadasVO(new TrdFinNegOperVincVO());
        setListaModalOperVinculadas(new ArrayList<TrdFinNegOperVincVO>());

        setItemListaComissaoInterna(new TrdFinNegComissaoVO());
        setItemListaComissaoExterna(new TrdFinNegComissaoVO());

        setListaParcelas(new ArrayList<TrdFinNegComissaoVO>());

        getTradeFinNegocVO().getObsCotacaoVO().setListaRebate(new ArrayList<ListaRebateVO>());
        getTradeFinNegocVO().getObsCotacaoVO().setListaTaxa(new ArrayList<ListaTaxaDescontoVO>());
        getTradeFinNegocVO().setPeriodoValidadeProposta(new CalendarioPeriodo());
        getTradeFinNegocVO().setPrazoOperacaoAjustado(false);
        getViewHelper().setAlertMessageConfirmation("");
        
        getTradeFinanceBean().setTradeFinanceVO(new TradeFinanceVO());

        getViewHelper().setComboProduto(
                        getSelectItemBean().getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                                        EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(), EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));

        // prepara dados modal de Garantias
        garantiasModalBean.resetBeanGarantia();
        carregarDadosModalGarantias();
		garantiasModalBean.carregarGarantiasInclusao();
		garantiasModalBean.getListaGarantiasInclusao().addAll(garantiasModalBean.getListaGarantiasAprov());
		
        configurarTelaPorProduto();
        	
    }

    /**
     * 
     * Nome: limparTradeFinNegocVO
     * Prop�sito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     *
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    private void limparTradeFinNegocVO() {
        // Valor Moeda Estrangeira
        getTradeFinNegocVO().setVnegocmoedaestrg(null);

        // Prazo Opera��o
        getTradeFinNegocVO().setTdiaopercmbio(0);

        // Spread All-In
        getTradeFinNegocVO().setPtxswapcmpdo(null);

        // taxa IR
        getTradeFinNegocVO().setVimpstnegoccmbio(null);

        // taxa IOF
        getTradeFinNegocVO().setViofnegoccmbio(null);

        // Juros de Mora
        getTradeFinNegocVO().setVtxmoracmbio(null);

        // taxa Multa
        getTradeFinNegocVO().setVmultanegoccmbio(null);

        //DADOS OBSERVACOES
        getTradeFinNegocVO().setObsCotacaoVO(new ObservacoesCotacaoVO());
        
        getTradeFinNegocVO().setListaFluxos(new ArrayList<TrdFinNegFluxoPagtoVO>());

        /* LISTA-MERCADORIA */
        getTradeFinNegocVO().setListaMercadoria(new ArrayList<TrdFinNegMercadoriaVO>());

        /* LISTA-OPERACAO VINCULADA */
        getTradeFinNegocVO().setListaOperacaoVinculada(new ArrayList<TrdFinNegOperVincVO>());

        /* LISTA-TARIFAS */
        getTradeFinNegocVO().setListaTarifas(new ArrayList<TrdFinNegTarifaVO>());

        /* LISTA-COMISSAO */
        getTradeFinNegocVO().setListaComissaoInterna(new ArrayList<TrdFinNegComissaoVO>());
        getTradeFinNegocVO().setListaComissaoExterna(new ComissaoCollection());

        /* LISTA-GARANTIAS_AVALISTAS */
        getTradeFinNegocVO().setListaGarantiasInclusao(new ArrayList<GarantiasVO>());

        getTradeFinNegocVO().setListaAvalistasInclusao(new ArrayList<GarantiasAvaListaVO>());

        getTradeFinNegocVO().setDadosPrecificacao(new TrdFinNegPrecificacaoVO());
        
        // Caso o campo cliente tem sido alterado, atualiza o campo
        getClienteSelecaoVO().setNomeCliente(getClienteSelecaoVO().getIredzdpssoacmbio());

    }
    
    /**
     * Nome: listenerTrocaProduto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void listenerTrocaProduto(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.listenerTrocaProduto <<<<<<<<<<<");
    		
    		if (testarProdutoDisponivel(getTradeFinNegocVO().getCprodtservc()) == Boolean.FALSE) {
    			NpcFacesUtils.addInfoModalMessage("Produto n�o encontrado.", false);
    			return;
    		}
    		
    		if(getViewHelper().isOperaComLimite() == true) {
    		    tratarListaLimite();
    		}
    		
    		getViewHelper().setRenderBtoConfirmar(Boolean.TRUE);
    		
    		if (getViewHelper().isTelaInicioNegociacao() == Boolean.TRUE) {
    			return;
    		}
    		getTradeFinNegocVO().setCmodldprodtcmbio(Numeros.NUM0);
    		
    		viewHelper.setComboModalidade(new ArrayList<SelectItem>());
    		
    		getViewHelper().setRenderBtoTrocarProdutoIncl(Boolean.TRUE);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.listenerTrocaProduto <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: actionTrocarProdutoIncl
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String actionTrocarProdutoIncl() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.actionTrocarProdutoIncl <<<<<<<<<<<");
    		
    		viewHelper.setClienteEditavel(Boolean.TRUE);
    		getViewHelper().setDisabledTipoCotacao(Boolean.FALSE);
    		getViewHelper().setDisabledModalidade(Boolean.FALSE);
    		
    		// verificar
    		return actionIniciarInclusaoPorProduto();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.actionTrocarProdutoIncl <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: actionIniciarInclusaoPorProduto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String actionIniciarInclusaoPorProduto() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.actionIniciarInclusaoPorProduto <<<<<<<<<<<");
    		
    		if(getTradeFinNegocVO().getProduto().getCodigo() == null 
                          || getTradeFinNegocVO().getProduto().getCodigo() == Numeros.ZERO
                          || getTradeFinNegocVO().getCunicclicmbio() == Numeros.ZERO
                          || getTradeFinNegocVO().getCunicclicmbio() == null) {
              NpcFacesUtils.addInfoModalMessage("� obrigat�rio selecionar um cliente e um produto.", false);
              return null;
            }
    	      
    		prepararInclusaoProduto();
    		getViewHelper().setTelaRetorno("tradeFinNegInicio");
    		
    		//se Limite Disponivel selecionado previamente na tela manter valor
    		if(!SiteUtil.isEmptyOrNull(getLimiteVO().getPspreadprodt())){
    			getItemListaComissaoInterna().setPtxcustototal(getLimiteVO().getPspreadprodt());
    		}
    		
    		// FINIMP DIRETO (1644)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
    			
    			return "finimpDiretoIncl";
    		}
    		
    		// REFINIMP DIRETO (1646)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
    			
    			return "refinimpDiretoIncl";
    		}
    		
    		// FINIMP INDIRETO (2692)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
    			
    			return "finimpIndiretoIncl";
    		}
    		
    		// REFINIMP INDIRETO (1717)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
    			
    			return "refinimpIndiretoIncl";
    		}
    		
    		// LEI 4131 (2010)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
    			
    			return "lei4131Incl";
    		}
    		
    		// PPE (1642)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
    			
    			return "cotacaoPPEIncl";
    		}
    		
    		// WORKING CAPITAL (2011)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
    			
    			return "workingCapitalIncl";
    		}
    		
    		// FORFAITING (644)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    			
                getTradeFinanceBean().getViewHelper().setIniciarDadosViaConsulta(Boolean.FALSE);  
    			return "forfaitingIncl";
    		}
    		
    		// FINIMP ECA (1715)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
    			
    			return "finimpEcaIncl";
    		}
    		
    		// PROEX (642)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
    			
    			return "proexEqualizacaoIncl";
    		}
    		
    		// COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
    		if (getTradeFinNegocVO().getProduto().isNce()) {
    			
    			return "nceIncl";
    		}
    		
    		// GARANTIA INTERNACIONAL EXPEDIDA (1769, 3933)
    		if(getTradeFinNegocVO().getProduto().isGarantia()) {
    			
    			return "garantiaIntExpIncl";
    		}
    		
    		// BNDES P�s (661, 662)
    		if (getTradeFinNegocVO().getProduto().isBndesPos()) {
    			
                getTradeFinNegocVO().getObsCotacaoVO().setGarangarant("1");
                getViewHelper().setDisabledGarantidor(Boolean.TRUE);
                return "bndesPosIncl";
    		}
    		
    		// BNDES Pr� (663, 664, 665, 666, 667, 670, 3934)
    		if (getTradeFinNegocVO().getProduto().isBndesPre()) {
    			
    			return "bndesPreIncl";
    		}
    		
    		// CARTA DE CR�DITO DE IMPORTA��O (2018)
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
    			
    			return "lcImportacaoIncl";
    		}
    		
    		return null;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.actionIniciarInclusaoPorProduto <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: listenerAutorizacaoDsn
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 09/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public void listenerAutorizacaoDsn(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.listenerAutorizacaoDsn <<<<<<<<<<<");
    		
    		if (validarNegocioCotacao(EnumTradeFinance.ACESSO_AUTORIZA_DSN.getCodigo()) == Boolean.FALSE) {
    			return;
    		}
    		
    		abrirModalMotivoAutorizacaoDsn();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.listenerAutorizacaoDsn <<<<<<<<<<<");
    	}

    }

    	/**
    	* Nome: listenerCotarCustoExterno
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 16/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public void listenerCotarCustoExterno(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.listenerCotarCustoExterno <<<<<<<<<<<");

    		// IN2672152 - Alexandre Rodrigues
    		// formatarParcelasFluxoPagamento();
    		setTipoAcessoIncluirEvento(EnumTradeFinance.ACESSO_COTAR_CUSTO_EXTERNO.getCodigo());
    		
    		if (validarNegocioCotacao(getTipoAcessoIncluirEvento())) {
    		    abrirModalMotivoCotarCustoExterno();
    		} else {
    			formatarParcelasFluxoPagamentoWeb();
                return;
			}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.listenerCotarCustoExterno <<<<<<<<<<<");
    	}
        
    }

    	/**
    	* Nome: actionModalConfirmar
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 27/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public void actionModalConfirmar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.actionModalConfirmar <<<<<<<<<<<");
    		
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		
    		/* Condi��o para abrir modal de desenquadradas: 
                    Tipo Cota��o = Firme; 
                    Limite de Cr�dito selecionado; 
                    Retorno 'S' do fluxo de desenquadradas; 
            */
            if (!openModalDesenquadradas(getTipoAcessoIncluirEvento())) {
                
                if (EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo().equals(getTipoAcessoIncluirEvento())) {
                    continuarModalConfirmaInclusao();
                    setTipoAcessoIncluirEvento(Numeros.ZERO);
                    return;
                }
            }
            
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.actionModalConfirmar <<<<<<<<<<<");
    	}

    }
    
    	/**
    	* Nome: actionFecharModalConfirma
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 01/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public void actionFecharModalConfirma(ActionEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.actionFecharModalConfirma <<<<<<<<<<<");
    		
    		if (EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo().equals(getTipoAcessoIncluirEvento())) {
    			viewHelper.setRenderModal(Boolean.FALSE);
    		}
    		
    		if (EnumTradeFinance.ACESSO_COTAR_CUSTO_EXTERNO.getCodigo().equals(getTipoAcessoIncluirEvento())) {
    			viewHelper.setRenderModal(Boolean.FALSE);
    			return;
    		}
    		
    		setTipoAcessoIncluirEvento(Numeros.ZERO);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.actionFecharModalConfirma <<<<<<<<<<<");
    	}

     }
    
    /**
     * Nome: listenerConfirmaInclusao
     * 
     * Prop�sito: Bot�o confirmar da tela de inclus�o Realiza inclus�o dos
     * seguintes produtos: - Finimp Direto - Refinimp Direto - Finimp Indireto -
     * Refinimp Indireto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void listenerConfirmaInclusao(AjaxBehaviorEvent event) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.listenerConfirmaInclusao <<<<<<<<<<<");

    		// IN2672152 - Alexandre Rodrigues
    		// formatarParcelasFluxoPagamento();
    		Integer paramOrigem = SiteUtil.getInt(event.getComponent().getAttributes().get("paramConfirmar"));
    		// gerar boleto ap�s inclus�o
    		setGerarBoletoIncl(paramOrigem == Numeros.DOIS);
    		
    		setTipoAcessoIncluirEvento(EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo());
    		
    		if (validarNegocioCotacao(getTipoAcessoIncluirEvento()) == Boolean.FALSE) {
    			formatarParcelasFluxoPagamentoWeb();
                return;
            }
    		
    		atualizaPrazoOperacaoFluxoPagamento();
    		
    		getViewHelper().setRenderModal(Boolean.TRUE);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.listenerConfirmaInclusao <<<<<<<<<<<");
    	}
        
    }

    public void formatarParcelasFluxoPagamento() {
    	for (TrdFinNegFluxoPagtoVO fluxoPagamento : getTradeFinNegocVO().getListaFluxos()) {
    		List<TrdFinNegParcelaVO> listaParaAlteracao = fluxoPagamento.getListaParcelasFluxoPgto();
        	List<TrdFinNegParcelaVO> listaPrinc = new ArrayList<TrdFinNegParcelaVO>();
        	List<TrdFinNegParcelaVO> listaJuros = new ArrayList<TrdFinNegParcelaVO>();

    		if (fluxoPagamento.getCfluxoliqdcprinc().equals(fluxoPagamento.getCodJurosPeriodicidade())) {
    			
        		// IN2754700 - Alexandre Rodrigues - INICIO
    			if (fluxoPagamento.getQtdeocorrprinc() < fluxoPagamento.getQtdeocorrjuros()) {
    				for (TrdFinNegParcelaVO parcela : listaParaAlteracao) {
    					if (parcela.getTpparcela().equals("P")) {
    						TrdFinNegParcelaVO parcelaPrincipal = new TrdFinNegParcelaVO();
    						parcelaPrincipal.setTpparcela("P");
    						parcelaPrincipal.setNpceladsembtrade(parcela.getNpceladsembtrade());
    						parcelaPrincipal.setTdianegocpcela(parcela.getTdianegocpcela());
    						parcelaPrincipal.setDvctopcelatrade(parcela.getDvctopcelatrade());
    						parcelaPrincipal.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(parcela.getDvctopcelatrade()));
    						parcelaPrincipal.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(parcela.getDvctopcelatrade()));
    						parcelaPrincipal.setVpcelamesatrade(parcela.getValorPrincipalParcelaFluxoPgto());
    						parcelaPrincipal.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(parcela.getValorPrincipalParcelaFluxoPgto()));
    	    				listaPrinc.add(parcelaPrincipal);
    	
    	    				TrdFinNegParcelaVO parcelaJuros = new TrdFinNegParcelaVO();
    	    				parcelaJuros.setTpparcela("J");
    	    				parcelaJuros.setNpceladsembtrade(parcela.getNpceladsembtrade());
    	    				parcelaJuros.setTdianegocpcela(parcela.getTdianegocpcela());
    	    				parcelaJuros.setDvctopcelatrade(parcela.getDvctopcelatrade());
    	    				parcelaJuros.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(parcela.getDvctopcelatrade()));
    	    				parcelaJuros.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(parcela.getDvctopcelatrade()));
    	    				parcelaJuros.setVpcelamesatrade(parcela.getValorJurosParcelaFluxoPgto());
    	    				parcelaJuros.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(parcela.getValorJurosParcelaFluxoPgto()));
    	    				listaPrinc.add(parcelaJuros);
    						
    					}
    					else if (parcela.getTpparcela().equals("J")) {
    	    				TrdFinNegParcelaVO parcelaJuros = new TrdFinNegParcelaVO();
    	    				parcelaJuros.setTpparcela("J");
    	    				parcelaJuros.setNpceladsembtrade(parcela.getNpceladsembtrade());
    	    				parcelaJuros.setTdianegocpcela(parcela.getTdianegocpcela());
    	    				parcelaJuros.setDvctopcelatrade(parcela.getDvctopcelatrade());
    	    				parcelaJuros.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(parcela.getDvctopcelatrade()));
    	    				parcelaJuros.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(parcela.getDvctopcelatrade()));
    	    				parcelaJuros.setVpcelamesatrade(parcela.getValorJurosParcelaFluxoPgto());
    	    				parcelaJuros.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(parcela.getValorJurosParcelaFluxoPgto()));

    	    				listaPrinc.add(parcelaJuros);
    					}
    				}
    			}
        		// IN2754700 - Alexandre Rodrigues - TERMINO
    			
    			else {
	    			for (int i = 0; i < listaParaAlteracao.size(); i++) {
	
	    				TrdFinNegParcelaVO objFrom = listaParaAlteracao.get(i);
	    				TrdFinNegParcelaVO objTo = new TrdFinNegParcelaVO();
	
	    				objTo.setTpparcela("P");
	    				objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
	    				objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
	    				objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
	    				objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	    				objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
	    				objTo.setVpcelamesatrade(objFrom.getValorPrincipalParcelaFluxoPgto());
	    				objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorPrincipalParcelaFluxoPgto()));
	    				listaPrinc.add(objTo);
	
	    				objTo = new TrdFinNegParcelaVO();
	    				objTo.setTpparcela("J");
	    				objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
	    				objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
	    				objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
	    				objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	    				objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
	    				objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
	    				objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
	    				listaJuros.add(objTo);
	    			}
	    			int numeroParcela = 1;
	    			
	    			for (int i = 0; i < listaJuros.size(); i++) {
	    				listaPrinc.get(i).setNpceladsembtrade(numeroParcela);
	    				numeroParcela++;
	    				listaJuros.get(i).setNpceladsembtrade(numeroParcela);
	    				numeroParcela++;
	    				listaPrinc.add(listaJuros.get(i));
	    			}
    			}
    		} else {
    			for (int i = 0; i < listaParaAlteracao.size(); i++) {
    				TrdFinNegParcelaVO objFrom = listaParaAlteracao.get(i);
    			
    				if (objFrom.getTpparcela().equals("P")) {
    					TrdFinNegParcelaVO objTo = new TrdFinNegParcelaVO();
    					objTo.setTpparcela("P");
    					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
    					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
    					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
    					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
    					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
    					objTo.setVpcelamesatrade(objFrom.getValorPrincipalParcelaFluxoPgto());
    					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorPrincipalParcelaFluxoPgto()));

    					listaPrinc.add(objTo);
    					if (objFrom.getValorJurosParcelaFluxoPgto() != null  && fluxoPagamento.getCodJurosPeriodicidade() != 14) {
							objTo = new TrdFinNegParcelaVO();
	    					objTo.setTpparcela("J");
	    					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
	    					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
	    					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
	    					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
	    					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
	    					objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
	    					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
	    					
	    					listaJuros.add(objTo);
    					}
    				} else {
    					TrdFinNegParcelaVO objTo = new TrdFinNegParcelaVO();
    					objTo.setTpparcela("J");
    					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
    					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
    					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
    					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
    					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
    					objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
    					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
    					
    					listaJuros.add(objTo);
					}
    			}
    			int numeroParcela = 1;
    			
    			for (int i = 0; i < listaJuros.size(); i++) {
    				if (i < fluxoPagamento.getQtdeocorrprinc()) {
        				listaPrinc.get(i).setNpceladsembtrade(numeroParcela);
        				numeroParcela++;
					}
    		
    				listaJuros.get(i).setNpceladsembtrade(numeroParcela);
    				numeroParcela++;
    				listaPrinc.add(listaJuros.get(i));
    			}
    		}
    		
    		// IN2672152 - Alexandre Rodrigues
    		fluxoPagamento.setListaParcelasFluxoPgto(listaPrinc);
    	}
	}
    
		/**
    	* Nome: continuarModalConfirmaInclusao
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 27/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    private void continuarModalConfirmaInclusao() {
        
        if (validarFluxoConfirmar(EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo()) == true) {
            setControleInclusaoAlteracao("DadosBasicos");
            continuarConfirmar();
        }
    }

    	/**
    	* Nome: fecharModalAlertaInclusao
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 16/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public void fecharModalAlertaInclusao() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.fecharModalAlertaInclusao <<<<<<<<<<<");
    		
    		//fechar rendermodal
    		viewHelper.setRenderModalAlerta(Boolean.FALSE);
    		
    		continuarConfirmar();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.fecharModalAlertaInclusao <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
     * Nome: continuarConfirmaInclusao
     * Prop�sito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     *
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public void continuarConfirmar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.continuarConfirmar <<<<<<<<<<<");
    		
    		formatarParcelasFluxoPagamento();
    		String msgRetornoOk = null;	
    		
            for (Iterator<TrdFinNegFluxoPagtoVO> iterator = getTradeFinNegocVO().getListaFluxos().iterator(); iterator.hasNext();) {
                TrdFinNegFluxoPagtoVO itemListaFluxos = (TrdFinNegFluxoPagtoVO) iterator.next();

                itemListaFluxos.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
                itemListaFluxos.setHinclreg(getTradeFinNegocVO().getHinclreg());
                
                int somaParcelas = itemListaFluxos.getQtdeocorrprinc() + itemListaFluxos.getQtdeocorrjuros();
                
                if (itemListaFluxos.getListaParcelasFluxoPgto().size() != somaParcelas) {
                	NpcFacesUtils.addInfoModalMessage("Erro nas parcelas do Fluxo de Pagamento.", false);
                	return;
    			}
            }
    		
    		if (getControleInclusaoAlteracao().equals("DadosBasicos") == true) {
    			incluirDadosBasicos();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ParcelasDesembolso") == true) {
    			incluirParcelasDesembolso();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("FluxoPagtoPrincipalJuros") == true) {
    		    
    		    if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    		        
    		        incluirDesembolsoForfaiting();
    		        
    		    } else {
    		        
    		        // Para Grupo 2 inclui fluxo de pagamento e suas parcelas
    		        // Para BNDES inclui previs�o de desembolso
    		        incluirFluxoPagtoPrincipalJuros();
    		    }
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ComissaoInterna") == true) {
    		    
    		    if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    		        incluirComissaoInternaForfaiting();
                } else {
                    incluirFluxoPagtoComissaoInterna();
                }
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ComissaoExterna") == true) {
    			incluirFluxoPagtoComissaoExterna();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("GarantVinculoTarifaObs") == true) {
    			incluirGarantVinculoTarifaObs();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ComissaoBanqueiro") == true) {
    			incluirFluxoPagtoComissaoBanqueiro();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("DespesasPrecificacao") == true) {
    			incluirDespesasPrecificacao();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ObservacoesCotacao") == true) {
    			incluirObservacoes();
    		}
    		
    		if (tradeFinanceBean.getVincularOperacaoLcVO() != null 
    		        && tradeFinanceBean.getVincularOperacaoLcVO().getNbletonegoccmbio() != Numeros.ZERO 
    		        && tradeFinanceBean.getVincularOperacaoLcVO().getCprodtservc() != Numeros.ZERO) {
    		    
    		    vincularOperacaoLC();
    		}
    		
    		// Exibe mensagem de retorno do fluxo de valida��o
            if (!SiteUtil.isEmptyOrNull(viewHelper.getMensagemFluxoValidacao())) {
                getTradeFinNegocVO().setMsgRetorno(viewHelper.getMensagemFluxoValidacao());
                viewHelper.setMensagemFluxoValidacao(null);
            }
    		
    		msgRetornoOk = getTradeFinNegocVO().getMsgRetorno();
    		msgRetornoOk += " <br /> ";
			msgRetornoOk += " N�MERO DA COTA��O: " + getTradeFinNegocVO().getDanobase()
							+ getTradeFinNegocVO().getNbletocmbioano();
			
			// Se Duplicar retorna para tela do monitor
			if (!getViewHelper().getTelaRetorno().endsWith("tradeFinNegInicio")) {
				
				// Parametro para abrir o boleto da cota��o duplicada no monitor.
				if(gerarBoletoIncl && (getTradeFinNegocVO().getCsitbletocmbio() != 3 && 
									   getTradeFinNegocVO().getCsitbletocmbio() != 4 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 14 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 31 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 32 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 33 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 34 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 35 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 36 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 37 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 38 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 40 &&
									   getTradeFinNegocVO().getCsitbletocmbio() != 42) ) {
					DadosGerarBoletoVO dadosGerarBoleto = new DadosGerarBoletoVO();
					dadosGerarBoleto.setGerarBoleto(true);
					dadosGerarBoleto.setDanobase(getTradeFinNegocVO().getDanobase());
					dadosGerarBoleto.setNbletocmbioano(getTradeFinNegocVO().getNbletocmbioano());
					getTradeFinanceBean().getViewHelper().setGerarBoletoDuplicar(dadosGerarBoleto);
					gerarBoletoIncl = Boolean.FALSE;
				}  else if (gerarBoletoIncl){
					BradescoFacesUtils.addInfoModalMessage("Boleto n�o pode ser gerado devido o status da cota��o: \"Pendente de Aprova��o\" ou "
							+ "\"Pendente de Custo Externo\" ou \"Rejeitado\".","statusBlock",BradescoViewExceptionActionType.ACTION, "submit", false);
				}
				
				if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)){
                    
                    openModalConfirmarLC();
                    
                } else {
                    
                 // Redireciona para a tela de consulta (Menu Din�mico) 
                    BradescoFacesUtils.addInfoModalMessage(msgRetornoOk, 
                            "#{tradeFinMonitBean.retomarPesquisaMonit}",
                            BradescoViewExceptionActionType.ACTION, "submit", false);   
                }
			} 
			
			// Se inclus�o retorna para tela inicial
			else {
				
				if(gerarBoletoIncl && (getTradeFinNegocVO().getCsitbletocmbio() != 3 && 
						   getTradeFinNegocVO().getCsitbletocmbio() != 4 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 14 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 31 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 32 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 33 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 34 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 35 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 36 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 37 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 38 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 40 &&
						   getTradeFinNegocVO().getCsitbletocmbio() != 42) ) {
					// prepara dados para gerar boleto
					setDadosGerarBoleto(new TradeFinanceListaVO());
					getDadosGerarBoleto().setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
					getDadosGerarBoleto().setCprodtservc(getTradeFinNegocVO().getCprodtservc());
					getDadosGerarBoleto().setCsitbletocmbio(getTradeFinNegocVO().getCsitbletocmbio());
					
					//BradescoFacesUtils.addInfoModalMessage(msgRetornoOk,"NOPE",BradescoViewExceptionActionType.ACTION, "submit", false);
				} else if (gerarBoletoIncl){
					BradescoFacesUtils.addInfoModalMessage("Boleto n�o pode ser gerado devido o status da cota��o: \"Pendente de Aprova��o\" ou "
							+ "\"Pendente de Custo Externo\" ou \"Rejeitado\".","statusBlock",BradescoViewExceptionActionType.ACTION, "submit", false);
				}
				
				setIniciarPagina(true);
				
				if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)){
					
				    openModalConfirmarLC();
				    
				} else {
				    
				    BradescoFacesUtils.addInfoModalMessage(msgRetornoOk,
                            "#{tradeFinanceNegociacaoInclBean.iniciar}",
                            BradescoViewExceptionActionType.ACTION, "submit", false);	
		        }
			}

    	} catch (NpccTradeWebException e) {
    		
    		// Se ocorreu erro durante a inclus�o exceto no fluxo de dados basicos
    		if (!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getNbletonegoccmbio())
    		        && getControleInclusaoAlteracao() != "FimInclusaoAlteracao") {
    			tradeFinanceNegociacaoService.desfazimentoIncl(getTradeFinNegocVO().getNbletonegoccmbio());
    		}
    		getTradeFinNegocVO().setMsgRetorno(e.getMessage());
    		NpcFacesUtils.addInfoModalMessage(getTradeFinNegocVO().getMsgRetorno(), false);
    		
		} finally {
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.continuarConfirmar <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
     * Nome: openModalConfirmarLC
     * 
     * Prop�sito: Abre modal de confirma��o do LC Importa��o e pergunda se deseja vincular uma opera��o
     *
     * @param : 
     *       <BR/>
     *
     * @see : Referencias externas. 
     *
     * Registro  de Manuten��o: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public void openModalConfirmarLC() {
        
        tradeFinanceBean.setVincularOperacaoLcVO(new VincularOperacaoLcVO());
        tradeFinanceBean.getVincularOperacaoLcVO().setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
        
        vincularOperacaoLcBean.setVincularOperacaoLcVO(tradeFinanceBean.getVincularOperacaoLcVO());
        vincularOperacaoLcBean.getVincularOperacaoLcVO().setCsitequal(Numeros.TRES);
        vincularOperacaoLcBean.getVincularOperacaoLcVO().setOrigemAlteracao(false);
        vincularOperacaoLcBean.getViewHelper().setMesagemConfirmacao(getTradeFinNegocVO().getMsgRetorno());
        vincularOperacaoLcBean.getViewHelper().setMesagemConfirmacao("Deseja incluir uma opera��o vinculada?");
        vincularOperacaoLcBean.getViewHelper().setMesagemNumeroCotacao(" N�MERO DA COTA��O: " + getTradeFinNegocVO().getDanobase()
                                                    + getTradeFinNegocVO().getNbletocmbioano());
        vincularOperacaoLcBean.openModal(null);
    }
    
    /**
     * 
     * Nome: confirmarVincularOperacaoLC
     * 
     * Prop�sito: Criar um cota��o ap�s a inclus�o de uma LC Importa��o
     *
     * @param : 
     *       <BR/>
     *
     * @see : Referencias externas. 
     *
     * Registro  de Manuten��o: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String confirmarVincularOperacaoLC() {
        
        if (SiteUtil.getInt(tradeFinanceBean.getVincularOperacaoLcVO().getCprodtservc()) == Numeros.ZERO) {
            NpcFacesUtils.addInfoModalMessage("Selecione um produto", EnumButtonBehavior.CLOSE);
            return null;
        }
    	
        vincularOperacaoLcBean.closeModal();
        
        // salva dados da cota��o LC 
        SiteUtil.copyPropertiesObjects(getClienteSelecaoVO(), tradeFinanceBean.getVincularOperacaoLcVO().getClienteSelecaoVO());
        
    	return iniciarPaginaVinculoLc();
    	
    }
    
    private String iniciarPaginaVinculoLc() {
        // reinicia os dados da inclus�o
        iniciarPagina();
        
        // carrega dados do novo produto
        getTradeFinNegocVO().setCprodtservc(tradeFinanceBean.getVincularOperacaoLcVO().getCprodtservc());
        
        // carrega dados do cliente
        SiteUtil.copyPropertiesObjects(tradeFinanceBean.getVincularOperacaoLcVO().getClienteSelecaoVO(), getClienteSelecaoVO());
        getClienteSelecaoVO().setIredzdpssoacmbio(getClienteSelecaoVO().getNomeCliente());
        getTradeFinNegocVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
        getTradeFinNegocVO().setCdcpfcnpj(getClienteSelecaoVO().getCdcpfcnpj());
        getTradeFinNegocVO().setCdfilial(getClienteSelecaoVO().getCdfilial());
        getTradeFinNegocVO().setCdctrlcpfcnpj(getClienteSelecaoVO().getCdctrlcpfcnpj());
        getTradeFinNegocVO().setNctabcriacmbio(getClienteSelecaoVO().getNctabcriacmbio());
        getTradeFinNegocVO().setCpfCnpjFormatado(getClienteSelecaoVO().getCpfCnpjFormatado());
        
        if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCdfilial())) {
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.TRES);
        }else{
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
        }
        
        // desabilita a edi��o do cliente
        getViewHelper().setClienteEditavel(Boolean.FALSE);
        getViewHelper().setDisabledTipoCotacao(Boolean.FALSE);
        getViewHelper().setDisabledModalidade(Boolean.FALSE);
        
        return actionIniciarInclusaoPorProduto();
    }
    
	/**
	 * Nome: actionFecharModalLc
	 * 
	 * Prop�sito: 
	 *
	 * @param : 
	 * @return : 
	 * @throws :
	 * @exception : 
	 * @see : Referencias externas.	
	 *
	 * Registro  de Manuten��o: 31/07/2017
	 *        - Autor: BRQ
	 *        - Responsavel: Equipe Web
	 *        - Adequa��o ao padr�o hexavision.
	 */
    public void actionFecharModalLc(ActionEvent ae) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.actionFechar <<<<<<<<<<<");
            
            vincularOperacaoLcBean.closeModal();
            tradeFinanceBean.setVincularOperacaoLcVO(new VincularOperacaoLcVO());
            setIniciarPagina(false);
            
            // Se Duplicar retorna para tela do monitor
            if (!getViewHelper().getTelaRetorno().endsWith("tradeFinNegInicio")) {
                BradescoFacesUtils.responseForward(tradeFinMonitBean.retomarPesquisaMonit());
            } else {
                BradescoFacesUtils.responseRedirect("/npcc_trade/content/comercializacao/precificacao/negociacao/tradeFinNegInicio.xhtml");
            }
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.actionFechar <<<<<<<<<<<");
        }
        
    }

    /**
     * Nome: listenerTratarIndicadorEconomico
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 31/05/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void listenerTratarIndicadorEconomico(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.listenerTratarIndicadorEconomico <<<<<<<<<<<");
    		
    		if (getViewHelper().isCheckPercCDI() == Boolean.FALSE
    						&& getViewHelper().isCheckPercCDI() == Boolean.FALSE
    						&& getViewHelper().isCheckTaxaPre() == Boolean.FALSE) {
    			
    			getViewHelper().setDisabledCheckPercCDI(Boolean.FALSE);
    			getViewHelper().setDisabledCheckMaisCDI(Boolean.FALSE);
    			getViewHelper().setDisabledCheckTaxaPre(Boolean.FALSE);
    			
    			getViewHelper().setDisabledPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledMaisCDI(Boolean.TRUE);
    			getViewHelper().setDisabledTaxaPre(Boolean.TRUE);
    			
    			getTradeFinNegocVO().setPtxcdifinan(null);
    			getTradeFinNegocVO().setPcdimaiscmbio(null);
    			getTradeFinNegocVO().setPfixajurocmbio(null);
    		}
    		
    		if (getViewHelper().isCheckPercCDI() == Boolean.TRUE) {
    			
    			getViewHelper().setDisabledCheckPercCDI(Boolean.FALSE);
    			getViewHelper().setDisabledCheckMaisCDI(Boolean.TRUE);
    			getViewHelper().setDisabledCheckTaxaPre(Boolean.TRUE);
    			
    			getViewHelper().setDisabledPercCDI(Boolean.FALSE);
    			getViewHelper().setDisabledMaisCDI(Boolean.TRUE);
    			getViewHelper().setDisabledTaxaPre(Boolean.TRUE);
    			
//    			getTradeFinNegocVO().setPcdimaiscmbio(null);
//    			getTradeFinNegocVO().setPfixajurocmbio(null);
    		} 

    		
    		if (getViewHelper().isCheckMaisCDI() == Boolean.TRUE) {
    			
    			getViewHelper().setDisabledCheckPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledCheckMaisCDI(Boolean.FALSE);
    			getViewHelper().setDisabledCheckTaxaPre(Boolean.TRUE);            
    			
    			getViewHelper().setDisabledPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledMaisCDI(Boolean.FALSE);
    			getViewHelper().setDisabledTaxaPre(Boolean.TRUE);
    			
//    			getTradeFinNegocVO().setPtxcdifinan(null);
//    			getTradeFinNegocVO().setPfixajurocmbio(null);
    		}

    		
    		if (getViewHelper().isCheckTaxaPre() == Boolean.TRUE) {
    			
    			getViewHelper().setDisabledCheckPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledCheckMaisCDI(Boolean.TRUE);
    			getViewHelper().setDisabledCheckTaxaPre(Boolean.FALSE);
    			
    			getViewHelper().setDisabledPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledMaisCDI(Boolean.TRUE);
    			getViewHelper().setDisabledTaxaPre(Boolean.FALSE);
    			
//    			getTradeFinNegocVO().setPtxcdifinan(null);
//    			getTradeFinNegocVO().setPcdimaiscmbio(null);
    		} 


    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.listenerTratarIndicadorEconomico <<<<<<<<<<<");
    	}


    }
        
    /**
     * Nome: incluirDadosBasicos
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws Exception 
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void incluirDadosBasicos() throws NpccTradeWebException {

        getTradeFinNegocVO().setCaditvbletocmbio(EnumTradeFinance.ADITIVO_NEGOC_INICIAL.getCodigo());
        if (getTradeFinNegocVO().getCsitbletocmbio() <= Numeros.NUM0) {
            getTradeFinNegocVO().setCsitbletocmbio(EnumTradeFinance.STATUS_EM_NEGOCIACAO.getCodigo());
        }
        getTradeFinNegocVO().setDvalddnegoccmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteCotacao()));
        
        // recupera a data de previs�o de embarque para o desenquadradas
        getTradeFinNegocVO().setDprevtembrq(getDesenquadradas().getDprevtembrq());
        
        //Derick - colocado essa validacao (if) pois no caso da inclusao do proex nao existe esse campo e esta zerando a variavel da inclusao
        if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getQprzmedcmbio())){
        	getTradeFinNegocVO().setQprzmedcmbio(getViewHelper().getPrzomediooperd());
        }
        
        // Para PROEX e N.C.E. o valor do campo � obtido a partir do input da tela.
        if ( !getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX) && !getTradeFinNegocVO().getProduto().isNce() && !getTradeFinNegocVO().getProduto().isBndesPos()) {
            
            getTradeFinNegocVO().setVtxspreadnegoc(getItemListaComissaoInterna().getVtxspreadnegoc());
        }
        
        // Para o GP1 e Gp3 o Valor Moeda do Limite tem que ser enviado nos campos Valor Utilizado e Valor Sensibilizado
        getTradeFinNegocVO().setVutlzdlimgerc(getTradeFinNegocVO().getVmoedalimgerc());
        getTradeFinNegocVO().setVsdolimsensi(getTradeFinNegocVO().getVmoedalimgerc());

        // FINIMP DIRETO (1644) OU REFINIMP DIRETO (1646)
        if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)
                        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {

            getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                            getListaFluxos().get(0).getDateFluxoPgto()));
            
            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirFinimpOuRefinimpDireto(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }

        // FINIMP INDIRETO (2692) OU REFINIMP INDIRETO (1717)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)
                        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {

            getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                            getListaFluxos().get(0).getDateFluxoPgto()));

            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirFinimpOuRefinimpIndireto(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }

        // LEI 4131 (2010)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {

            getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                            getListaFluxos().get(0).getDateFluxoPgto()));

            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirLei4131(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }

        // PPE (1642)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {

            getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                            getListaFluxos().get(0).getDateFluxoPgto()));

            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirPPE(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }

        // Working Capital (2011)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {

            getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                            getListaFluxos().get(0).getDateFluxoPgto()));

            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirWorkingCapital(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }

        // FORFAITING (644)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
            
            if (getListaDesembolso().size() > Numeros.ZERO) {
                getTradeFinNegocVO().setDprevtdsembcmbio(getListaDesembolso().get(0).
                                getDataDesembolsoFormat().replace("/", "."));
            } else {
                getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                                getDataPrevDesemb().getInicio()));
            }

            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirForfaiting(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }

        // FINIMP ECA (1715)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
            
            getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDatePrevDesembolso()));
            
            /////// Enviar a data final calculada para o mainframe
            Date dfim = commonService.getDataVencimentoFianca(getViewHelper().getDatePrevDesembolso(),
                            getTradeFinNegocVO().getTdiaopercmbio());
            
            getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(dfim));
            
            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirDadosBasicosGp1Gp3(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");            
        }

        // COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
        else if (getTradeFinNegocVO().getProduto().isNce()) {
            
            /////// Enviar a data final calculada para o mainframe
            Date dfim = commonService.getDataVencimentoFianca(new Date(),
                            getTradeFinNegocVO().getTdiaopercmbio());
            
            getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(dfim));
            
            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirDadosBasicosGp1Gp3(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");            
        }

        // BNDES P�s (661, 662)
        else if (getTradeFinNegocVO().getProduto().isBndesPos()) {
            
            getTradeFinNegocVO().setDlimenviorsumo(SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteFRO()));
            getTradeFinNegocVO().setDvctocntragarnt(getViewHelper().getDataVencProposta());
            getTradeFinNegocVO().setDprevtinicembrq(SiteUtil.dataWebToMainframe(getViewHelper().getPeriodoEmbarqueIni()));
            getTradeFinNegocVO().setDprevtfimembrq(SiteUtil.dataWebToMainframe(getViewHelper().getPeriodoEmbarqueFim()));
            
            /////// Enviar a data final calculada para o mainframe
            Date dfim = commonService.getDataVencimentoFianca(new Date(), getTradeFinNegocVO().getTdiaopercmbio());            
            getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(dfim));
            
            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirDadosBasicosGp1Gp3(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }

        // BNDES Pr� (663, 664, 665, 666, 667, 670, 3934)
        else if (getTradeFinNegocVO().getProduto().isBndesPre()) {
            
            /////// Enviar a data final calculada para o mainframe
            Date dfim = commonService.getDataVencimentoFianca(new Date(),
                            getTradeFinNegocVO().getTdiaopercmbio());
            
            getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(dfim));
            
            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirDadosBasicosGp1Gp3(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }
        
        // GARANTIA INTERNACIONAL EXPEDIDA (1769, 3933)
        else if (getTradeFinNegocVO().getProduto().isGarantia()) {
            
            //Se o checkBox 'Indeterminado' for selecionado o campo Dfimnegoccmbio dever� ser nulo
            if (getViewHelper().isIndeterminado()) {
                getTradeFinNegocVO().setCnegoccmbioindmd("1");
                getTradeFinNegocVO().setDfimnegoccmbio(null);
                
            } else {
                getTradeFinNegocVO().setCnegoccmbioindmd("2");
                getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDateVencFianc()));
            }
            
            getTradeFinNegocVO().setCidtfdrespdesp(getViewHelper().getCidtfdrespdesp());
            
            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirDadosBasicosGp1Gp3(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("ComissaoInterna");
        }
        
        // LC IMPORTA��O (2018)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            getTradeFinNegocVO().setDlimembrqcmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteEmbarque()));            
            /////// Enviar a data final calculada para o mainframe
            Date dfim = commonService.getDataVencimentoFianca(new Date(),
                            getTradeFinNegocVO().getTdiaopercmbio());
            
            getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(dfim));
            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirDadosBasicosGp1Gp3(getTradeFinNegocVO()));
            
            setControleInclusaoAlteracao("ParcelasDesembolso");
        }
            
        // PROEX (642)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
            
            /////// Enviar a data final calculada para o mainframe
            Date dfim = commonService.getDataVencimentoFianca(new Date(),
                            getTradeFinNegocVO().getTdiaopercmbio());
            
            getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(dfim));
            setTradeFinNegocVO(getTradeFinanceNegociacaoService().incluirDadosBasicosGp1Gp3(getTradeFinNegocVO()));
            setControleInclusaoAlteracao("GarantVinculoTarifaObs");
        } else {
            setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        }

        getTradeFinNegocVO().setMsgRetorno(getTradeFinanceNegociacaoService().getMsgRetorno());

    }

    /**
     * Nome: incluirFluxoPagtoPrincipalJuros
     * 
     * Prop�sito: Executa chamada ao MF para incluir Fluxo de Pagamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void incluirFluxoPagtoPrincipalJuros() {
        
        // BNDES Pre e P�s
        if (getTradeFinNegocVO().getProduto().isBndesPre() 
                || getTradeFinNegocVO().getProduto().isBndesPos()) {
            
            getTradeFinNegocVO().getPrevDesembolsoVO().setHinclreg(getTradeFinNegocVO().getHinclreg());
            getTradeFinNegocVO().getPrevDesembolsoVO().setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
            getTradeFinNegocVO().getPrevDesembolsoVO().setVprevtdsembcmbio(getTradeFinNegocVO().getVnegocmoedaestrg());
            
            // Carrega objeto para incluir desembolso
            TrdFinNegFluxoPagtoVO itemDesembolso = new TrdFinNegFluxoPagtoVO();
            itemDesembolso.setHinclreg(getTradeFinNegocVO().getPrevDesembolsoVO().getHinclreg());
            itemDesembolso.setNbletonegoccmbio(getTradeFinNegocVO().getPrevDesembolsoVO().getNbletonegoccmbio());
            itemDesembolso.setVprevtdsembcmbio(getTradeFinNegocVO().getPrevDesembolsoVO().getVprevtdsembcmbio());
            itemDesembolso.setTdiacarenprinc(getTradeFinNegocVO().getPrevDesembolsoVO().getTdiacarenprinc());
            itemDesembolso.setCfluxoliqdcprinc(Numeros.ZERO);
            itemDesembolso.setQtdeocorrprinc(getTradeFinNegocVO().getPrevDesembolsoVO().getQpcelatradeprinc());
            itemDesembolso.setJurosCarencia(Numeros.ZERO);
            itemDesembolso.setCfluxoliqdcprinc(Numeros.ZERO);
            itemDesembolso.setQtdeocorrjuros(Numeros.ZERO);
            itemDesembolso.setCodJurosMomento(Numeros.DOIS);
            
            // Aciona o Fluxo: NPCCIASQ - Books: NPCCWWYE / NPCCWWYS
            getTradeFinanceNegociacaoService().incluirFluxoPagtoPrincJurosFinimpDireto(itemDesembolso);
            
            // Seta proximo fluxo a ser executado
            setControleInclusaoAlteracao("GarantVinculoTarifaObs");
        }
        
        // Outros Produtos
        else {
            
            for (Iterator<TrdFinNegFluxoPagtoVO> iterator = getTradeFinNegocVO().getListaFluxos().iterator(); iterator.hasNext();) {
                TrdFinNegFluxoPagtoVO itemListaFluxos = (TrdFinNegFluxoPagtoVO) iterator.next();
                
                itemListaFluxos.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
                itemListaFluxos.setHinclreg(getTradeFinNegocVO().getHinclreg());
                
                // Aciona o Fluxo: NPCCIASQ - Books: NPCCWWYE / NPCCWWYS    
                getTradeFinanceNegociacaoService().incluirFluxoPagtoPrincJurosFinimpDireto(itemListaFluxos);
            }
            
            // NCE
            if (getTradeFinNegocVO().getProduto().isNce()) {
                
                setControleInclusaoAlteracao("ComissaoExterna");
            }
            // Outros Produtos
            else {
                setControleInclusaoAlteracao("ComissaoInterna");
            }
        }
    }

    private void incluirDesembolsoForfaiting() {

        for (Iterator<TradeFinanceDesembolsoVO> iterator = getListaDesembolso().iterator();
                        iterator.hasNext();) {
            TradeFinanceDesembolsoVO itemDesembolso = (TradeFinanceDesembolsoVO) iterator.next();

            itemDesembolso.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
            itemDesembolso.setHinclreg(getTradeFinNegocVO().getHinclreg());
            itemDesembolso.setCmomencobrcmbio(EnumTradeFinance.NAO_ZERAR_SALDO.getCodigo());

            getTradeFinanceNegociacaoService().incluirDesembolsoForfaiting(itemDesembolso);
        }

        setControleInclusaoAlteracao("ComissaoInterna");
    }

    /**
     * Nome: incluirFluxoPagtoComissaoInterna
     * 
     * Prop�sito: Executa chamada ao MF para incluir Comiss�o Interna
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void incluirFluxoPagtoComissaoInterna() {
    	for (Iterator<TrdFinNegComissaoVO> iterator = getTradeFinNegocVO().getListaComissaoInterna().iterator(); iterator.hasNext();) {
    		TrdFinNegComissaoVO itemListaComissaoInt = (TrdFinNegComissaoVO) iterator.next();

    		itemListaComissaoInt.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
    		itemListaComissaoInt.setHinclreg(getTradeFinNegocVO().getHinclreg());

    		if(getTradeFinNegocVO().getProduto().isGarantia() 
    				|| getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {

    			itemListaComissaoInt.setCindcdeconmmoeda(getViewHelper().getCodMoedaComissao());
    			itemListaComissaoInt.setVmincobrcomis(getViewHelper().getVmincobrcomis());
    			itemListaComissaoInt.setCcobrcomisintrn(getViewHelper().getTipoCobrancaComissao());
    			itemListaComissaoInt.setCindcdeconmmoeda(getViewHelper().getCodMoedaComissao());
    			itemListaComissaoInt.setCcobrcomiscmbio(getViewHelper().getCodComisSobre());
    			itemListaComissaoInt.setCfluxoperdccmbio(getViewHelper().getCfluxoperdccmbio());
    			itemListaComissaoInt.setCodMomentoComissao(getViewHelper().getCodMomentoComissao());

    			if (getViewHelper().getTipoCobrancaComissao() == 2 || getViewHelper().getTipoCobrancaComissao() == 3) {
    				itemListaComissaoInt.setPjuronegoccmbio(getViewHelper().getValueComissaoCobranca());
    				itemListaComissaoInt.setPcomisnegoccmbio(getViewHelper().getValueComissaoCobranca());
    				itemListaComissaoInt.setVprevtcomiscmbio(itemListaComissaoInt.getVlxtotalcomis());
    			} else {
    				itemListaComissaoInt.setPjuronegoccmbio("0,00");
    				itemListaComissaoInt.setPcomisnegoccmbio("0,00");
    				itemListaComissaoInt.setVlxcomiscmbio(getViewHelper().getValueComissaoCobranca());
    				itemListaComissaoInt.setVprevtcomiscmbio(getViewHelper().getValueComissaoCobranca());
    			}
    		}

    		getTradeFinanceNegociacaoService().incluirFluxoPagtoComissaoInternaFinOuRefinDireto(itemListaComissaoInt, getTradeFinNegocVO().getProduto().getCodigo(), getTradeFinNegocVO().getCcomiscartanacio());
    	}
    	setControleInclusaoAlteracao("ComissaoExterna");
    }

    private void incluirComissaoInternaForfaiting() {

        itemListaComissaoInterna.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
        itemListaComissaoInterna.setHinclreg(getTradeFinNegocVO().getHinclreg());

        getTradeFinanceNegociacaoService().incluirFluxoPagtoComissaoInternaFinOuRefinDireto(itemListaComissaoInterna, getTradeFinNegocVO().getProduto().getCodigo());

        setControleInclusaoAlteracao("ComissaoExterna");
    }

    /**
     * Nome: incluirFluxoPagtoComissaoExterna
     * 
     * Prop�sito: Executa chamada ao MF para incluir Comiss�o Externa
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void incluirFluxoPagtoComissaoExterna() {
    	
        for (Iterator<IComissaoExterna> iterator = getTradeFinNegocVO().getListaComissaoExterna().iterator(); iterator.hasNext();) {

        	TrdFinNegComissaoVO itemListaComissaoExt = (TrdFinNegComissaoVO) iterator.next();
            
            itemListaComissaoExt.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
            itemListaComissaoExt.setHinclreg(getTradeFinNegocVO().getHinclreg());
          
			// N�o trata comiss�o desembolso do banqueiro aqui (Crespcomisexter=2 e Ccondceconc=2696)
        	if(itemListaComissaoExt.getCrespcomisexter() == 2 && itemListaComissaoExt.getCcondceconc() == 2696) {
        		iterator.remove();
        		continue;
        	}

            getTradeFinanceNegociacaoService().incluirFluxoPagtoComissaoExternaFinOuRefinDireto(itemListaComissaoExt, getTradeFinNegocVO().getProduto().getCodigo());
        }

        setControleInclusaoAlteracao("GarantVinculoTarifaObs");
    }

    /**
     * Nome: incluirFluxoPgtoComissaoBanqueiro
     * 
     * Prop�sito: Inclui comiss�o desembolso banqueiro autom�tica. Executa chamada ao MF para incluir Comiss�o Banqueiro
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    private void incluirFluxoPagtoComissaoBanqueiro() {

        if( getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131) 			|| 
            getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO) 	|| 
            getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO) 	|| 
            getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA) 				|| 
            getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E) 			|| 
            getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO) || 
            getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)   || 
            getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL) ) { 

			String comissaoDesembolso = pesquisarParametroComissaoDesembolso();
			
			if(!SiteUtil.isEmptyOrNull(comissaoDesembolso)) {
	
				TrdFinNegComissaoVO comissaoBanqueiro = (TrdFinNegComissaoVO) new TrdFinNegComissaoVO();
				
				// Identifica quantidade de Comiss�es externas inclu�das para incrementar o contador de Ncomisextertrade 
				int seqRegistro = getTradeFinNegocVO().getListaComissaoExterna().size();
				seqRegistro++;
				
				comissaoBanqueiro.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());	// NR BOLETO
				comissaoBanqueiro.setHinclreg(getTradeFinNegocVO().getHinclreg());					// DATA/HORA INCLUSAO
				comissaoBanqueiro.setNcomisextertrade(seqRegistro);									// NR SEQUENCIAL
				comissaoBanqueiro.setCrespcomisexter(2);											// RESPONSAVEL COMISSAO EXTERNA = 2- DIVISAO (COMISSAO BANQUEIRO)
				comissaoBanqueiro.setCcondceconc(2696);												// TIPO DE COMISSAO EXTERNA = 2696 (Comiss�o desembolso)
				comissaoBanqueiro.setVlxcomiscmbio(comissaoDesembolso);								// VALOR DA COMISSAO
	            comissaoBanqueiro.setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());	// VALOR DA NEGOCIACAO 
	            comissaoBanqueiro.setCperdcjurocmbio(1);											// COBRANCA DA COMISSAO = 01 - VALOR           
	            comissaoBanqueiro.setVprevtdsembcmbio(getTradeFinNegocVO().getVnegocmoedaestrg());	// VALOR DO DESEMBOLSO
	            comissaoBanqueiro.setVprevtcomiscmbio(comissaoDesembolso);							// VALOR DA COMISSAO
	            comissaoBanqueiro.setVlxtotalcomis(comissaoDesembolso);								// VALOR TOTAL DA COMISSAO
	            comissaoBanqueiro.setCfluxoperdccmbio(14);											// PERIODICIDADE = 14 (Inicial)
	            comissaoBanqueiro.setCodMomentoComissao(1);											// MOMENTO = 1 (ANTECIPADO) 
	            comissaoBanqueiro.setCindcdeconmmoeda(getTradeFinNegocVO().getCeconmmoedadsemb());  // MOEDA DO DESEMBOLSO
                comissaoBanqueiro.setTdiafinandsemb(getTradeFinNegocVO().getListaFluxos().get(0).getTdiafinandsemb()); // PRAZO DO DESEMBOLSO
                comissaoBanqueiro.setDateComissao(getTradeFinNegocVO().getListaFluxos().get(0).getDateFluxoPgto()); // DATA DESEMBOLSO	
                comissaoBanqueiro.setCpais(getTradeFinNegocVO().getListaFluxos().get(0).getCpais());  				// PAIS
				
				comissaoInternaExternaModalService.gerarParcelasComissaoExterna(comissaoBanqueiro);

				// Altera data de vencimento para data da comiss�o. O Fluxo n�o aceita periodicidade inicial com momento antecipado e prazo zerado
				if(comissaoBanqueiro.getListaParcelasComissao().size() > 0) {
					comissaoBanqueiro.getListaParcelasComissao().get(0).setDvctopcelatrade(SiteUtil.dataWebToMainframe(comissaoBanqueiro.getDateComissao()));
				}
	            
		        getTradeFinanceNegociacaoService().alterarFluxoPagtoComissaoExterna(comissaoBanqueiro, getTradeFinNegocVO().getProduto().getCodigo());
			}
        }
        if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {

			if(!SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getVlrcomisdsemb())) {

				CustoExternoVO custoExternoVO = new CustoExternoVO();
				custoExternoVO.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());										// NR BOLETO
				custoExternoVO.setCsitbletocmbio(99);																				// SITUACAO BOLETO (99 - S� grava custo externo, n�o muda status) 
				custoExternoVO.setDlimfndngcmbio(SiteUtil.dataWebToMainframe(getCommonService().getDataLimiteCotacao(new Date())));	// DATA LIMITE COTA��O
				custoExternoVO.setCbanqrcmbiofndng(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbanqrcmbio());			// BANCO CORRESP0NDENTE
				custoExternoVO.setCbanqrcmbiorcdor(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbanqrcmbio());			// BANCO REEMBOLSADOR
				custoExternoVO.setVlrcomisdsemb(getTrdFinNegPrecificacaoVO().getVlrcomisdsemb());									// VALOR COMISS�O BANQUEIRO
				custoExternoVO.setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());											// PRAZO
				custoExternoVO.setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());										// VALOR ME
				custoExternoVO.setCprodtservc(getTradeFinNegocVO().getCprodtservc());												// PRODUTO
				custoExternoVO.setObservacao("");																					// OBSERVA��O
	
				tradeFinanceMonitService.alterarCustoExterno("N", custoExternoVO);
			}
        }

        // COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
        // BNDES P�s (661, 662)
        // BNDES Pr� (663, 664, 665, 666, 667, 670, 3934)
        // GARANTIA INTERNACIONAL EXPEDIDA (1769, 3933)
        // PROEX (642)
        if (getTradeFinNegocVO().getProduto().isNce()
                || getTradeFinNegocVO().getProduto().isBndesPos() 
                || getTradeFinNegocVO().getProduto().isBndesPre()
                || getTradeFinNegocVO().getProduto().isGarantia()
                || getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
            
            setControleInclusaoAlteracao("ObservacoesCotacao");
        }
        
        // LC IMPORTA��O (2018)
        else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            setControleInclusaoAlteracao("DespesasPrecificacao");        
        }
        
        else {
            setControleInclusaoAlteracao("FimInclusaoAlteracao");        
        }
    }

    /**
     * Nome: incluirGarantVinculoTarifaObs
     * 
     * Prop�sito: Executa chamada ao MF para incluir Garantias, Opera��es
     * Vinculadas, Tarifas e Observa��es
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void incluirGarantVinculoTarifaObs() {

        getTradeFinNegocVO().setListaGarantiasInclusao(getGarantiasModalBean().getListaGarantiasInclusao());

        getTradeFinNegocVO().setNtpopapelcmbio(EnumTradeFinance.TIPO_PAPEL_AVALISTA.getCodigo());
        getTradeFinNegocVO().setListaAvalistasInclusao(getGarantiasModalBean().getListaAvalistasInclusao());

        getTradeFinNegocVO().setDadosPrecificacao(getTrdFinNegPrecificacaoVO());
        
        // Trata campo tomador para produtos Working Capital e Forfaiting
        if(!SiteUtil.isEmptyOrNull(getTomadorModal().getCunicpssoacmbio()) && getTomadorModal().getCunicpssoacmbio() > 0L) {
            // Pega o c�digo selecionado na lupa
            getTradeFinNegocVO().setEcunicpssoacmbiot(getTomadorModal().getCunicpssoacmbio());
            getTradeFinNegocVO().setCindcpsqtomador(Numeros.UM);
        }
        
        // Executa chamada CWS - Fluxo: NPCCIAST - Books: NPCCWYNE / NPCCWYNS
        getTradeFinanceNegociacaoService().incluirGarantiasVinculosTarifasObsFinOuRefinDireto(getTradeFinNegocVO(), getTrdFinNegPrecificacaoVO());

        setControleInclusaoAlteracao("ComissaoBanqueiro");
                
    }
    
    /**
     * Nome: incluirParcelasDesembolso
     * 
     * Prop�sito: Executa chamada ao MF para incluir as Parcelas de Desembolso
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 28/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */ 
    private void incluirParcelasDesembolso() {
        
        // Aciona o Fluxo: NPCCIAPS - Books: NPCCWV1E / NPCCWV1S
        getTradeFinanceNegociacaoService().incluirParcelasDesembolso(
                        getTradeFinNegocVO().getNbletonegoccmbio(), 
                        getTradeFinNegocVO().getHinclreg(), 
                        getTradeFinNegocVO().getListaParcelas());

        setControleInclusaoAlteracao("ComissaoInterna");        
    }    

    /**
     * Nome: incluirDespesasPrecificacao
     * 
     * Prop�sito: Executa chamada ao MF para incluir as Despesas LC
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 28/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */ 
    public void incluirDespesasPrecificacao() {
        
    	try {
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.incluirDespesasPrecificacao <<<<<<<<<<<");
    		
            ListaCotacoesExternasVO cotacaoFunding = new ListaCotacoesExternasVO();
            
            cotacaoFunding.setCbanqrcmbiofndng(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbancoocrr());
            cotacaoFunding.setCbanqrcmbiorcdor(getTrdFinNegPrecificacaoVO().getBancoReembolsadorVO().getCbanqrcmbio());
            cotacaoFunding.setCbanqrcmbioaviso(getTrdFinNegPrecificacaoVO().getBancoAvisadorVO().getCbancoaviso());
            
            cotacaoFunding.setListaDespesas(getTradeFinNegocVO().getListaDespesas());
            
            // Ontem ocorreu um problema com o Duplicar no prduto LC Importacao e a solu��o seria que na hora 
            // da iclus�o fosse adicionado a Letra L de vez a I como antes ( Aline - 06/09/2016)
            
            String flagEntrada = null;
            if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                flagEntrada = "L";
                cotacaoFunding.setCindcdfndngutlzd("S");
            }else 
                flagEntrada = "I";
            
            // Aciona o Fluxo: NPCCIAPX - Books: NPCCWV6E / NPCCWV6S
    		getTradeFinanceNegociacaoService().incluirAlterarDespesasFundingLC(
    						getTradeFinNegocVO().getNbletonegoccmbio(), 
    						getTradeFinNegocVO().getHinclreg(),
    						cotacaoFunding, flagEntrada);
    		
    		setControleInclusaoAlteracao("ObservacoesCotacao");        

    	} finally {
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.incluirDespesasPrecificacao <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: incluirObservacoes
     * 
     * Prop�sito: Executa chamada ao MF para incluir Observa��es da Cota��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 02/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */    
    private void incluirObservacoes() {

        getTradeFinNegocVO().getObsCotacaoVO().setCtpooper("I");                    
        getTradeFinNegocVO().getObsCotacaoVO().setHinclreg(getTradeFinNegocVO().getHinclreg());
        getTradeFinNegocVO().getObsCotacaoVO().setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
        getTradeFinNegocVO().getObsCotacaoVO().setCunicclicmbio(getTradeFinNegocVO().getCunicclicmbio());
        getTradeFinNegocVO().getObsCotacaoVO().setCodCpfCnpj(getViewHelper().getCodCpfCnpjDepositarioSelecionado());

        if (!getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().equals(null)) {
            getTradeFinNegocVO().getObsCotacaoVO().setQtdocrebt(getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().size());
        }

        if (!getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().equals(null)) {
            getTradeFinNegocVO().getObsCotacaoVO().setQtdoctxde(getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().size());
        }
        
        // A tela de proex cont�m apenas CNPJ nas observa��es por este motivo setamos o campo codCpfCnpj com valor 2.
        if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
            getTradeFinNegocVO().getObsCotacaoVO().setCodCpfCnpj(Numeros.NUM2);
        }

        // Aciona o Fluxo: NPCCIAP2 - Books: NPCCWW0E / NPCCWW0S
        getTradeFinanceNegociacaoService().incluirAlterarObservacoesCotacao(getTradeFinNegocVO().getObsCotacaoVO());
        
        setControleInclusaoAlteracao("FimInclusaoAlteracao");
    }
    
    /**
     * Nome: vincularOperacaoLC
     * 
     * Prop�sito: Vincula opera��o com um LC
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 02/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void vincularOperacaoLC() {
        
        try {
            tradeFinanceBean.getVincularOperacaoLcVO().setNbletovncloimpor(getTradeFinNegocVO().getNbletonegoccmbio());
            tradeFinanceBean.getVincularOperacaoLcVO().setHinclreg(getTradeFinNegocVO().getHinclreg());
            
            // Aciona o Fluxo: NPCCIAP8 - Books: NPCCWW7E / NPCCWW7S
            getTradeFinanceNegociacaoService().operVinculadaLcIncl(tradeFinanceBean.getVincularOperacaoLcVO());
        } catch (NpccTradeWebException e) {
            NpcFacesUtils.addInfoModalMessage(e.getMessage(), EnumButtonBehavior.CLOSE);
        } finally {
            tradeFinanceBean.setVincularOperacaoLcVO(new VincularOperacaoLcVO());
        }
    }

    /**
     * Nome: iniciarDuplicacaoPorProduto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 16/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void iniciarDuplicacaoPorProduto() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.iniciarDuplicacaoPorProduto <<<<<<<<<<<");

    		// carrega os dados aparir da consulta
    		if (carregarDadosViaConsulta(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo())) {
    		    
    		    setControleInclusaoAlteracao("DadosBasicos");
    		    boolean trataLimite = true;
    		    
    			// calcula a data limite da cota��o apartir da data em que a duplica��o esta sendo realizada
    			getViewHelper().setDataLimiteCotacao(commonService.getDataLimiteCotacao(new Date()));

    			// Ao iniciar a tela de duplicar, deve chamar o fluxo 'NPCCIAT9' para recalcular as taxas do custo externo e data funding
    			if(getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)
    			        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)
    			        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)
    			        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)
                        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)
    			        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)
    			        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)
                        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)
    			        || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    			    
    			    if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                        getTrdFinNegPrecificacaoVO().setPrzomediodsemb(tradeFinNegocVO.getTdiaopercmbio());
                        
                        calcularCustoExternoForfaiting();
                    } else {
                        // Carrega o prazo m�dio para o VO de precifica��o, campo utilizado no fluxo IAT9
                        getTrdFinNegPrecificacaoVO().setPrzomediodsemb(getViewHelper().getPrzomediooperd());
                        
                        calcularCustoExterno();
                    }
    			}
    			    			
    			// Limpar dados de observa��es uso interno
    			limparObservacoes();
    			
    			// Limpar n�mero da cota��o
    			getTradeFinNegocVO().setNcotacao("");
    			
    			// Limpa dados do desembolso
    			setDesenquadradas(new DesenquadramentoVO());
    			
    			//Limpa Lista Despesa e Respons�vel despesa
    			if(getTradeFinNegocVO().getProduto().isGarantia()) {
    			    
    			    getTradeFinNegocVO().setListaRespDesp(new ArrayList<ListaResponsavelDespesaVO>());
    			    getTradeFinNegocVO().setListaDespesas(new ArrayList<ListaDespesasVO>());
    			    
    			}

    			if (getTradeFinNegocVO().getProduto().isBndesPre()) {
    	            if (getTradeFinNegocVO().getObsCotacaoVO().getTxapre().equals("1")) {
    	                getViewHelper().setDisabledRadioTaxaPre(Boolean.TRUE);
    	            } else {
    	                getViewHelper().setDisabledRadioTaxaPre(Boolean.FALSE);
    	            }
                }
    			
                if (getTradeFinNegocVO().getProduto().isBndesPos()) {
                    if (getTradeFinNegocVO().getObsCotacaoVO().getGarangarant().equals("1")) {
                        getViewHelper().setDisabledGarantidor(Boolean.TRUE);
                        getViewHelper().setRenderLupaAprovCredito(Boolean.TRUE);
                        trataLimite = true;
                    } else {
                        getViewHelper().setDisabledGarantidor(Boolean.FALSE);
                        getViewHelper().setRenderLupaAprovCredito(Boolean.FALSE);
                        trataLimite = false;
                    }
                }
                
                if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                    getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.ZERO);
                }else {
                    getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.UM);
                }
                
                // NCE
                if(tradeFinNegocVO.getProduto().isNce()){               
                    
                    getViewHelper().setCheckPercCDI(Boolean.FALSE);
                    tradeFinNegocVO.setPtxcdifinan(SiteUtil.formatarValorWeb(Numeros.ZERO));
                    getViewHelper().setCheckTaxaPre(Boolean.FALSE);
                    tradeFinNegocVO.setPfixajurocmbio(SiteUtil.formatarValorWeb(Numeros.ZERO));
                    getViewHelper().setCheckTaxaPre(Boolean.FALSE);
                    tradeFinNegocVO.setPfixajurocmbio(SiteUtil.formatarValorWeb(Numeros.ZERO));
                    
                    if(SiteUtil.isValueZero(this.getTradeFinanceBean().getTradeFinanceVO().getPtxcdifinan()) == false){
                        getViewHelper().setCheckPercCDI(Boolean.TRUE);
                        tradeFinNegocVO.setPtxcdifinan(SiteUtil.formatarValorWeb(this.getTradeFinanceBean().getTradeFinanceVO().getPtxcdifinan()));
                    }
                    
                    else if(SiteUtil.isValueZero(this.getTradeFinanceBean().getTradeFinanceVO().getPcdimaiscmbio()) == false){
                        getViewHelper().setCheckMaisCDI(Boolean.TRUE);
                        tradeFinNegocVO.setPcdimaiscmbio(SiteUtil.formatarValorWeb(this.getTradeFinanceBean().getTradeFinanceVO().getPcdimaiscmbio()));
                    }
                    
                    else if(SiteUtil.isValueZero(this.getTradeFinanceBean().getTradeFinanceVO().getPfixajurocmbio()) == false){
                        getViewHelper().setCheckTaxaPre(Boolean.TRUE);
                        tradeFinNegocVO.setPfixajurocmbio(SiteUtil.formatarValorWeb(this.getTradeFinanceBean().getTradeFinanceVO().getPfixajurocmbio()));
                    }                   
                    
                    tradeFinNegocVO.setCindcdlastragric(this.getTradeFinanceBean().getTradeFinanceVO().getCindcdlastragric());
                }
    			
                // Abrir modal de limites ao duplicar
                if (trataLimite && getViewHelper().isOperaComLimite() == true) {
                    tratarListaLimite();
                }
                
    		} else if(tradeFinanceBean.getVincularOperacaoLcVO() != null 
    		        && !SiteUtil.isEmptyOrNull(tradeFinanceBean.getVincularOperacaoLcVO().getNbletonegoccmbio())
    		        && !SiteUtil.isEmptyOrNull(tradeFinanceBean.getVincularOperacaoLcVO().getCprodtservc())
    		        && tradeFinanceBean.getVincularOperacaoLcVO().isOrigemAlteracao()) {
    		    
    		    iniciarPaginaVinculoLc();
    		}
    		
    		if (isDuplicar() == true) {
    			if (getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0) {
    				getViewHelper().setItemSelecListaFluxos("0");    		
    				listenerShowFluxoPgtSel(null);
    				listenerDetalharFluxoAlt();
    				carregarDetalhesComissaoIntAlt("Detalhar");
					setIsDuplicar(false);
    			}
			}
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.iniciarDuplicacaoPorProduto <<<<<<<<<<<");
    	}
    	
    }
    
	/**
	* Nome: iniciarDuplicacaoForfaiting
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 14/09/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
    public void iniciarDuplicacaoForfaiting() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.iniciarDuplicacaoForfaiting <<<<<<<<<<<");
            
            // Se Duplicar prepara dados a partir da consulta
            if (getTradeFinanceBean().getViewHelper().getIniciarDadosViaConsulta()) {
                iniciarDuplicacaoPorProduto();
            }
    		
            tratarRefreshForfaiting();
            getTrdFinNegMercadoriaVO().setNdsembcmbiotrade(Numeros.UM);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.iniciarDuplicacaoForfaiting <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: actionVoltarSelecionarCliente
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String actionVoltarSelecionarCliente() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.actionVoltarSelecionarCliente <<<<<<<<<<<");
    		
    		String salvaTelaRetorno = getViewHelper().getTelaRetorno();
    		
    		reIniciaInclusao(0);
    		
    		getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
    		
    		getViewHelper().setTelaInicioNegociacao(Boolean.TRUE);
    		getViewHelper().setRenderDetalheCliente(Boolean.FALSE);
    		
    		return salvaTelaRetorno;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.actionVoltarSelecionarCliente <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: incluirItemRebate
     * 
     * Prop�sito: Incluir na lista de rebate o rebate informadado pelo usu�rio. 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public void incluirItemRebate(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.incluirItemRebate <<<<<<<<<<<");
    		
    		// Verifica se o campo rebate esta preenchido.
    		if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getRebate())) {
    			
    			NpcFacesUtils.addInfoModalMessage("O campo Rebate � obrigat�rio.", false);
    		} else {
    			ListaRebateVO itemRebate = new ListaRebateVO();
    			itemRebate.setRebate(SiteUtil.getString(getTradeFinNegocVO().getRebate()));
    			getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().add(itemRebate);
    		}
    		
    		// Limpa o campo de rebate.
    		getTradeFinNegocVO().setRebate(SiteUtil.STRING_EMPTY);
    		getViewHelper().setCodRebateSelecionado(null);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.incluirItemRebate <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: excluirItemRebate
     * 
     * Prop�sito: Excluir o item selecionado na lista de rebate.
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public void excluirItemRebate(AjaxBehaviorEvent evento) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.excluirItemRebate <<<<<<<<<<<");
    		
    		/** Se n�o houver sele��o retorna mensagem na tela */
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getCodRebateSelecionado())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um registro para ser excluido.", false);
    			return;
    		} else {
    			
    			ListaRebateVO itemRemove =
    							getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().get(SiteUtil.getInt(getViewHelper().getCodRebateSelecionado()));
    			
    			// Remove o item selecionado.
    			getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().remove(itemRemove);
    		}
    		
    		// Limpa a sele��o dos itens da lista.
    		getViewHelper().setCodRebateSelecionado(null);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.excluirItemRebate <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: incluirItemTaxaDesconto
     * 
     * Prop�sito: Incluir na lista de taxa desconto a taxa informadada pelo usu�rio. 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public void incluirItemTaxaDesconto(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.incluirItemTaxaDesconto <<<<<<<<<<<");
    		
    		// Verifica se o campo rebate esta preenchido.
    		if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTaxaDesconto())) {
    			NpcFacesUtils.addInfoModalMessage("O campo Taxa Desconto � obrigat�rio.", false);
    		} else {
    			ListaTaxaDescontoVO itemTaxaDesconto = new ListaTaxaDescontoVO();
    			itemTaxaDesconto.setTxades(SiteUtil.getString(getTradeFinNegocVO().getTaxaDesconto()));
    			getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().add(itemTaxaDesconto);
    		}
    		
    		getTradeFinNegocVO().setTaxaDesconto(SiteUtil.STRING_EMPTY);
    		getViewHelper().setCodTaxaDescontoSelecionado(null);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.incluirItemTaxaDesconto <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: excluirItemTaxaDesconto
     * 
     * Prop�sito: Excluir o item selecionado na lista de taxa desconto.
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public void excluirItemTaxaDesconto(AjaxBehaviorEvent evento) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.excluirItemTaxaDesconto <<<<<<<<<<<");
    		
    		/** Se n�o houver sele��o retorna mensagem na tela */
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getCodTaxaDescontoSelecionado())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um registro para ser excluido.", false);
    			return;
    		} else {
    			
    			ListaTaxaDescontoVO itemRemover =
    							getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().get(
    											SiteUtil.getInt(getViewHelper().getCodTaxaDescontoSelecionado()));
    			
    			// Remove o item selecionado.
    			getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().remove(itemRemover);
    		}
    		
    		// Limpa a sele��o dos itens da lista.
    		getViewHelper().setCodTaxaDescontoSelecionado(null);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.excluirItemTaxaDesconto <<<<<<<<<<<");
    	}

    }
    
    /**
     * Nome: getSelectItemRadioRebate
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getSelectItemRadioRebate() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.getSelectItemRadioRebate <<<<<<<<<<<");
    		
    		List<SelectItem> list = new ArrayList<SelectItem>();
    		for (int index = 0; index < getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		return list;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.getSelectItemRadioRebate <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: getSelectItemRadioTaxaDesconto
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getSelectItemRadioTaxaDesconto() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.getSelectItemRadioTaxaDesconto <<<<<<<<<<<");
    		
    		List<SelectItem> list = new ArrayList<SelectItem>();
    		for (int index = 0; index < getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		return list;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.getSelectItemRadioTaxaDesconto <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
     * Nome: gerarBoleto
     * 
     * Prop�sito: Gerar boleto apartir do item selecionado na lista
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 08/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String gerarBoleto() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.gerarBoleto <<<<<<<<<<<");
    		
    		if(getDadosGerarBoleto() == null) {
    			return null;
    		}
    		
    		// carrega dado do boleto
    		tradeFinanceBean.obterDadosBasicos(dadosGerarBoleto, ConstantesTradeFinance.FUNC_CONSULTAR);
    		
    		setDadosGerarBoleto(new TradeFinanceListaVO());
    		
    		return tradeFinanceBean.gerarBoleto();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.gerarBoleto <<<<<<<<<<<");
    	}
        
    }
    
    /**
     * 
     * Nome: getGerarBoletoIncl
     * 
     * Prop�sito: Metodo utilizado para gerar o boleto automaticamente ap�s realizar a inclus�o 
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 08/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public boolean getGerarBoletoIncl() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.getGerarBoletoIncl <<<<<<<<<<<");
    		
    		return this.gerarBoletoIncl 
    						&& getDadosGerarBoleto() != null 
    						&& !SiteUtil.isEmptyOrNull(getDadosGerarBoleto().getNbletonegoccmbio());

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.getGerarBoletoIncl <<<<<<<<<<<");
    	}
    }
    
    private void limparObservacoes() {
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao1(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao2(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao3(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao4(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao5(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao6(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao7(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao8(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao9(SiteUtil.STRING_EMPTY);
        getTradeFinNegocVO().getObsCotacaoVO().setObservacao10(SiteUtil.STRING_EMPTY);
    }
    public void listenerTrocaPeriodicidadeComissaoExterna(AjaxBehaviorEvent e) {
  	  try{
  		  BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerTrocaPeriodicidadeComissaoExterna <<<<<<<<<<<");
  		  tratarPeriodo(getViewHelper().getCfluxoperdccmbioRed());

  	  }finally{
  		  BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerTrocaPeriodicidadeComissaoExterna <<<<<<<<<<<");
  	  }

    }
    
    protected void tratarPeriodo(Integer integer){
  	  getViewHelper().setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.COMISSAO_EXTERNA.getCodigo(), 0));
        if(integer.equals(Numeros.DOZE)){
            for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
                if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.UM)){
                    //Remover a op��o 'Antecipado' no combo quando for produto ECA
                    getViewHelper().getComboMomento().remove(i);
                    break;
                }
            }
        } else if (integer.equals(Numeros.CATORZE)) {
            for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
                if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.DOIS)){
                    //Remover a op��o 'Postecipado' no combo quando for produto ECA
                    getViewHelper().getComboMomento().remove(i);
                    break;
                }
            }
  		} else {
  			getViewHelper().getCodMomentoComissaoRed();
            getViewHelper().setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.COMISSAO_EXTERNA.getCodigo(), 0));
        }
    }
    
    public void listenerTrocaPeriodicidadeComissaoInterna(AjaxBehaviorEvent e) {
    	getViewHelper().setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.FLUXO_PAGAMENTO.getCodigo(), getTradeFinNegocVO().getProduto().getCodigo()));
    	if(getViewHelper().getCfluxoperdccmbio().equals(Numeros.DOZE)){
            for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
                if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.UM)){
                    //Remover a op��o 'Antecipado' no combo quando for produto ECA
                    getViewHelper().getComboMomento().remove(i);
                    break;
                }
            }
        } else if (getViewHelper().getCfluxoperdccmbio().equals(Numeros.CATORZE)) {
            for(int i=0; i < getViewHelper().getComboMomento().size(); i++) {
                if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.DOIS)) {
                    //Remover a op��o 'Postecipado' no combo quando for produto ECA
                    getViewHelper().getComboMomento().remove(i);
                    break;
                }
            }
		}
    }
    
    /**
     * @param gerarBoletoIncl seta o novo valor para o campo gerarBoletoIncl
     */
    public void setGerarBoletoIncl(boolean gerarBoletoIncl) {
        this.gerarBoletoIncl = gerarBoletoIncl;
    }

    /**
     * @return o valor do dadosGerarBoleto
     */
    public TradeFinanceListaVO getDadosGerarBoleto() {
        return dadosGerarBoleto;
    }

    /**
     * @param dadosGerarBoleto seta o novo valor para o campo dadosGerarBoleto
     */
    public void setDadosGerarBoleto(TradeFinanceListaVO dadosGerarBoleto) {
        this.dadosGerarBoleto = dadosGerarBoleto;
    }

    /**
     * @return o valor do tipoAcessoIncluirEvento
     */
    public int getTipoAcessoIncluirEvento() {
        return tipoAcessoIncluirEvento;
    }

    /**
     * @param tipoAcessoIncluirEvento seta o novo valor para o campo tipoAcessoIncluirEvento
     */
    public void setTipoAcessoIncluirEvento(int tipoAcessoIncluirEvento) {
        this.tipoAcessoIncluirEvento = tipoAcessoIncluirEvento;
    }
    
    public Boolean isDuplicar() {
		return isDuplicar;
	}

	public void setIsDuplicar(Boolean isDuplicar) {
		this.isDuplicar = isDuplicar;
	}
}
