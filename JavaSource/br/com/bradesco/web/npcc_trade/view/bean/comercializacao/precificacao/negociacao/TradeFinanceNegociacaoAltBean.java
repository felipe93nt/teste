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

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.comissaoIntExtModal.IComissaoInternaExternaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.CustoExternoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaRebateVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaTaxaDescontoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.VincularOperacaoLcVO;
import br.com.bradesco.web.npcc_trade.service.gcc.AnexarArquivoGccVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumAcaoSituacao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPastasGcc;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.global.anexarArquivoGccModal.AnexarArquivoGccModalBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * Nome: TradeFinanceNegociacaoAltBean.java
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
 *      Registro de Manutenção: 23/04/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
@Named("tradeFinanceNegociacaoAltBean")
@SessionScoped
public class TradeFinanceNegociacaoAltBean extends TradeFinanceNegociacaoBase implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /** Situação do boleto de acordo com rotina executada */
    private Integer csitbletocmbio = 0;
    
    /** Controle dos modais para evento Confirmar e Cotar Custo Externo */
    private int tipoAcessoAlterarEvento = Numeros.ZERO;
    
    private Boolean gerarBoletoAlt = false;
    private Boolean renderBotaoCotarCustoExterno = false;
    private Boolean renderBotaoFechar = false;
    
    protected Date limiteCtc = null;
    protected UnidadeExternaVO unidadeExternaVO = new UnidadeExternaVO();
    protected UnidadeExternaVO bancoReembolsadorVO = new UnidadeExternaVO();
    protected UnidadeExternaVO bancoAvisadorVO = new UnidadeExternaVO();
    

    /** Controle dos modais para evento Confirmar e Cotar Custo Externo */
    //L/C
    private int tipoAcessoIncluirEvento = Numeros.ZERO;
    
    /**
     * Variável ListaCotacoes 
     */
    private ListaCotacoesExternasVO listaCotacoes = new ListaCotacoesExternasVO();
    
    /**
     * Injeção do conector GCC.
     */
    @Inject
    private AnexarArquivoGccModalBean anexarArquivoGccModalBean;
                
    @Inject
    @Named("comissaoInternaExternaModalService")
    private IComissaoInternaExternaModalService comissaoInternaExternaModalService;
     
    /**
     * 
     * Nome: iniciar
     * 
     * Propósito: Carrega os dados para tela de alteração
     * 
     * @return : String de navegação
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciar() {
        
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.iniciar <<<<<<<<<<<");
    		
    		fluxoPgtoManutModalBean.setIsAlterarCotacao(true);
    		
    		if (carregarDadosViaConsulta(EnumTradeFinance.FUNCAO_TIPO_ALTERAR.getCodigo()) == true) {
    			
			    // Desabilita botão fechar em caso de alteração para situação devolvida
			    setRenderBotaoFechar(tradeFinNegocVO.getCsitbletocmbio().equals(EnumAcaoSituacao.DEVOLVIDO.getCodigo()));			    
    			setCsitbletocmbio(EnumTradeFinance.STATUS_EM_NEGOCIACAO.getCodigo());
    			tradeFinNegocVO.setCsitbletocmbio(EnumTradeFinance.STATUS_EM_NEGOCIACAO.getCodigo());
    			
    			setFuncaoExecutando(EnumTradeFinance.FUNCAO_TIPO_ALTERAR.getCodigo());
    			
    			// limpar e dasabilitar componentes
    			getViewHelper().setRenderModal(Boolean.FALSE);
    			getViewHelper().setRenderModalAlerta(Boolean.FALSE);
    			
        		//variavel utilizada para o campo precificacao 
        		//se for inclusao deve aparecer banco financiador e reembolsador
        		//na alteracao eles nao podem aparecer
        		getViewHelper().setCtrBotaoFluxo(1);
    			
                if (tradeFinNegocVO.getCtponegoccmbio().equals(EnumTradeFinance.TPO_NEGOC_CMBIO_FIRME.getCodigo())) {
					getViewHelper().setDisabledTipoCotacao(Boolean.TRUE);
				} else {
					getViewHelper().setDisabledTipoCotacao(Boolean.FALSE);
				}
                
                // Exibe botão 'Cotar Custo Externo' apenas para produtos do 'Grupo 2' e Grupo 1
                if(tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)
                        || tradeFinNegocVO.getProduto().isGarantia()
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.FINIMP_ECA)
                        || tradeFinNegocVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                    
                    setRenderBotaoCotarCustoExterno(true);
                }
                                
                // NCE
                if(tradeFinNegocVO.getProduto().isNce()){             	
                	
            		getViewHelper().setCheckPercCDI(Boolean.FALSE);
            		tradeFinNegocVO.setPtxcdifinan(SiteUtil.formatarValorWeb(Numeros.ZERO));
            		getViewHelper().setCheckMaisCDI(Boolean.FALSE);
            		tradeFinNegocVO.setPcdimaiscmbio(SiteUtil.formatarValorWeb(Numeros.ZERO));
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
                
                listenerTratarIndicadorEconomico(null);
 		   		
                // BNDES POS
        		if (this.getTradeFinNegocVO().getProduto().isBndesPos()) {
        	        try {
	        			this.getViewHelper().setDataLimiteFRO(SiteUtil.stringToDate(this.getTradeFinanceBean().getTradeFinanceVO().getDlimenviorsumo(), "dd/MM/yyyy"));
        	        } catch (ParseException e) {
        	        	// se der erro na conversão, deixar vazio
        	        }
        	        
        	        this.getViewHelper().setDataVencProposta(this.getTradeFinanceBean().getTradeFinanceVO().getDvctocntragarnt());
	        			
        	        try {
        	        	this.getViewHelper().setPeriodoEmbarqueIni(SiteUtil.stringToDate(this.getTradeFinanceBean().getTradeFinanceVO().getDprevtinicembrq(), "dd/MM/yyyy"));
        	        } catch (ParseException e) {
        	        	// se der erro na conversão, deixar vazio
        	        }
        	        
        	        try {
        	        	this.getViewHelper().setPeriodoEmbarqueFim(SiteUtil.stringToDate(this.getTradeFinanceBean().getTradeFinanceVO().getDprevtfimembrq(), "dd/MM/yyyy"));
        	        } catch (ParseException e) {
        	        	// se der erro na conversão, deixar vazio
        	        }
        	        
        	        this.getTradeFinNegocVO().setPcomismtoricmbio(this.getTradeFinanceBean().getTradeFinanceVO().getPcomismtoricmbio());
        	        
        	        listenerTratarGarantidor(null);
        			
        		}
        		
        		// BNDES PRE
        		if(this.getTradeFinNegocVO().getProduto().isBndesPre()){
                    if (tradeFinNegocVO.getObsCotacaoVO().getTxapre().equals("1")) {
                        getViewHelper().setDisabledRadioTaxaPre(Boolean.TRUE);
                        listenerCalcularSomatoria(null);
                    } else {
                        getViewHelper().setDisabledRadioTaxaPre(Boolean.FALSE);
                    }        			        			
        		}

        		// FINIMP ECA
        		if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
        		    //esse parametros tem que ser limpos, sao uma lista e o simples é usado apra fazer a busca
        			getTrdFinNegPrecificacaoVO().setUnidadeExternaVO(new UnidadeExternaVO());
        			getTrdFinNegPrecificacaoVO().setBancoReembolsadorVO(new UnidadeExternaVO());
        			getItemListaFluxoPgto().setVprevtdsembcmbio(null);
        			getViewHelper().setDateFluxoPgtoTemp(null);
        		}
        		
        		getViewHelper().setItemSelecListaCotacoes(0);
        		// Guarda os dados iniciais da alteração para verificar ao final se deve ser realizado o desenquadramento.
                setDesenquadradas(new DesenquadramentoVO(getTradeFinNegocVO(), getViewHelper().getDatePrevDesembolso()));

                // Inicia a alteração com o prazo ajustado
                getTradeFinNegocVO().setPrazoOperacaoAjustado(true);
                getViewHelper().setAlertMessageConfirmation("");
                
                if (temFluxoPagamento() == true) {
                    listenerDetalharFluxoAlt();
                    carregarDetalhesComissaoIntAlt("Detalhar");
				}
        		//Carregar o fluxo de pagamento quando for alteração.
        		carregarFluxoPagtoAlt();
    		}
    		
            return "";
            
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.iniciar <<<<<<<<<<<");
    	}
    }

		/**
    	* Nome: iniciarAlteracaoForfaiting
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
    public void iniciarAlteracaoForfaiting() {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.iniciarAlteracaoForfaiting <<<<<<<<<<<");
            
            // Se Alteracao, prepara dados a partir da consulta
            if (getTradeFinanceBean().getViewHelper().getIniciarDadosViaConsulta()) {
                iniciar();
            }
            
            tratarRefreshForfaiting();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.iniciarAlteracaoForfaiting <<<<<<<<<<<");
        }
        
    }

    public void iniciarInclusaoDesembolsoForfaiting() {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.iniciarInclusaoDesembolsoForfaiting <<<<<<<<<<<");
            
            // Se Alteracao, prepara dados a partir da consulta
            if (getTradeFinanceBean().getViewHelper().getIniciarDadosViaConsulta()) {
                if (carregarDadosViaConsulta(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO_DESEMBOLSO.getCodigo()) == true) {
                    
                    // Desabilita botão fechar em caso de alteração para situação devolvida
                    setRenderBotaoFechar(tradeFinNegocVO.getCsitbletocmbio().equals(EnumAcaoSituacao.DEVOLVIDO.getCodigo()));               
                    setCsitbletocmbio(EnumTradeFinance.STATUS_EM_NEGOCIACAO.getCodigo());
                    
                    
                    // limpar e dasabilitar componentes
                    getViewHelper().setRenderModal(Boolean.FALSE);
                    getViewHelper().setRenderModalAlerta(Boolean.FALSE);
                    
                    //variavel utilizada para o campo precificacao 
                    //se for inclusao deve aparecer banco financiador e reembolsador
                    //na alteracao eles nao podem aparecer
                    getViewHelper().setCtrBotaoFluxo(1);
                }
            }
            
            tratarRefreshForfaiting();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.iniciarInclusaoDesembolsoForfaiting <<<<<<<<<<<");
        }
        
    }
    
    	/**
    	* Nome: iniciarDivergenciaPorProduto
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 06/05/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void iniciarDivergenciaPorProduto() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.iniciarDivergenciaPorProduto <<<<<<<<<<<");
    		
    		if (carregarDadosViaConsulta(EnumTradeFinance.FUNCAO_TIPO_ALTERAR.getCodigo()) == true) {
    			setCsitbletocmbio(EnumTradeFinance.STATUS_DIVERGENTE.getCodigo());
    			tradeFinNegocVO.setCsitbletocmbio(EnumTradeFinance.STATUS_DIVERGENTE.getCodigo());
    			
    			// Guarda os dados iniciais da alteração para verificar ao final se deve ser realizado o desenquadramento.
                setDesenquadradas(new DesenquadramentoVO(getTradeFinNegocVO(), getViewHelper().getDatePrevDesembolso()));
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.iniciarDivergenciaPorProduto <<<<<<<<<<<");
    	}
    	
    }

    /**
    * Nome: listenerCotarCustoExterno
    * 
    * Propósito: Ação do botão 'Cotar Custo Externo'
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 16/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void listenerCotarCustoExterno(AjaxBehaviorEvent e) {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerCotarCustoExterno <<<<<<<<<<<");
    		
    		setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_COTAR_CUSTO_EXTERNO.getCodigo());
    		
    		if (validarNegocioCotacao(getTipoAcessoAlterarEvento())) {
    			abrirModalMotivoCotarCustoExterno();
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerCotarCustoExterno <<<<<<<<<<<");
    	}
    	
    }

    /**
    * Nome: actionModalConfirmar
    * 
    * Propósito: Ação do botão 'Confirmar' do modal de confirmação
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 27/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void actionModalConfirmar() {
    	
    	try{

    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.actionModalConfirmar <<<<<<<<<<<");
    		
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		
    		// confirmação do botão alterar
    		if (EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo().equals(getTipoAcessoAlterarEvento())
    				|| EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR_PRINCIPAIS.getCodigo().equals(getTipoAcessoAlterarEvento()) 
    		        || EnumTradeFinance.ACESSO_CONFIRMAR_DIVERGENTE.getCodigo().equals(getTipoAcessoAlterarEvento())
    				|| EnumTradeFinance.ACESSO_FECHAR.getCodigo().equals(getTipoAcessoAlterarEvento())
    				|| EnumTradeFinance.ACESSO_GERAR_BOLETO.getCodigo().equals(getTipoAcessoAlterarEvento())
    				|| EnumTradeFinance.ACESSO_INCLUIR_DESEMBOLSO_FORFAITING.getCodigo().equals(getTipoAcessoAlterarEvento())
                    || EnumTradeFinance.ACESSO_BAIXAR_SALDO_FORFAITING.getCodigo().equals(getTipoAcessoAlterarEvento())) {
    			
    		    /* Condição para abrir modal de desenquadradas: 
                        Tipo Cotação = Firme; 
                        Limite de Crédito selecionado; 
                        Retorno 'S' do fluxo de desenquadradas; 
                        Se o cliente está ativo no piloto;
                */
    			if (!openModalDesenquadradas(getTipoAcessoAlterarEvento())) {
                    
                    if (validarFluxoConfirmar(getTipoAcessoAlterarEvento()) == true) {
                        setControleInclusaoAlteracao("DadosBasicos");
                        continuarConfirmar();
                        setTipoAcessoAlterarEvento(Numeros.ZERO);
                    }
                }
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionModalConfirmar <<<<<<<<<<<");
    	}
        
    }
    
    /**
     * Nome: actionModalConfirmarDesembForfaiting
     * 
     * Propósito: Ação do botão 'Confirmar' do modal de confirmação da tela de inlusão de Desembolso
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 27/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
     public void actionModalConfirmarDesembForfaiting() {
         
         try{

             BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.actionModalConfirmarDesembForfaiting <<<<<<<<<<<");
             
             getViewHelper().setRenderModal(Boolean.FALSE);
             
             // Botão BAIXAR
             if(getTipoAcessoAlterarEvento() == EnumTradeFinance.ACESSO_BAIXAR_SALDO_FORFAITING.getCodigo()) {
                 
                 getTradeFinanceNegociacaoService().baixarSaldoForfaiting(tradeFinNegocVO, desembolsoForfaitingVO);
                 
              // Redireciona para a tela de consulta (Menu Dinâmico) 
                 BradescoFacesUtils.addInfoModalMessage(getTradeFinanceNegociacaoService().getMsgRetorno(), 
                         "#{tradeFinMonitBean.retomarPesquisaMonit}",
                         BradescoViewExceptionActionType.ACTION, "submit", false);
             } 
             
             // Botão Confirmar
             else {
                 setControleInclusaoAlteracao("DadosBasicos");
                 continuarConfirmar();
                 setTipoAcessoAlterarEvento(Numeros.ZERO);
             }
             
         }finally{
             BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionModalConfirmarDesembForfaiting <<<<<<<<<<<");
         }
         
     }
    
    	/**
    	* Nome: actionFecharModalConfirma
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 26/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void actionFecharModalConfirma(ActionEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.actionFecharModalConfirma <<<<<<<<<<<");
    		
    		viewHelper.setRenderModal(Boolean.FALSE);
    		setTipoAcessoAlterarEvento(Numeros.ZERO);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionFecharModalConfirma <<<<<<<<<<<");
    	}
    	
     }
    
    /**
     * 
     * Nome: listenerConfirmaAlteracao
     * 
     * Propósito: Ação do botão 'Confirmar'
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerConfirmaAlteracao(AjaxBehaviorEvent event) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerConfirmaAlteracao <<<<<<<<<<<");
    		
    		/* Parametro passado pelo botão "Confirmar": 
    		 *   6 - Confirmar Alteração dados principais (envia div internacional)
    		 *   60 - Confirmar Alteração
    		 *   10 - Confirmar Divergente
    		 */ 
    		Integer paramOrigem = SiteUtil.getInt(event.getComponent().getAttributes().get("paramConfirmarAlt"));
    		
    		if(paramOrigem == EnumTradeFinance.ACESSO_CONFIRMAR_DIVERGENTE.getCodigo()) {
    		    setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_CONFIRMAR_DIVERGENTE.getCodigo());
    		} else {
    			if(camposPrincipaisAlterados())
        		    setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR_PRINCIPAIS.getCodigo());
    			else
    				setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo());
    		}
    		
    		// valida dados
    		if (confirmaAlteracao()) {
    		    
    		    atualizaPrazoOperacaoFluxoPagamento();
    			
    			// abre moda de confirmação
    			getViewHelper().setRenderModal(Boolean.TRUE);
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerConfirmaAlteracao <<<<<<<<<<<");
    	}
        
    }
    
	/**
	* Nome: camposPrincipaisAlterados
	* 
	* Propósito: Identifica os campos principais da cotação de sofreram alteração
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*/
    public boolean camposPrincipaisAlterados() {

    	if(tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)     ||
    	   tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)   ||    			
    	   tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)   ||    			
    	   tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO) ||    			
    	   tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)   ||    			
    	   tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)             ||
    	   tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131) ){
    	    		
    		// Moeda da operação 
    	    if(!getTradeFinanceOriginalVO().getCindcdeconmmoeda().equals(getTradeFinNegocVO().getCindcdeconmmoeda()))
    		   return true;
    		
    		// Valor ME
    	    if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getCindcdeconmmoeda()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) ) ||
    	    	 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getCindcdeconmmoeda()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) ) )
    	    	return true;
    	    		
    	    if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getCindcdeconmmoeda()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) )
    	       if(!getTradeFinanceOriginalVO().getVnegocmoedaestrg().equals(getTradeFinNegocVO().getVnegocmoedaestrg()))
    		      return true;
    		
    		// Prazo da operação
    	    if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) ) ||
    	    	 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) ) )
    	    	return true;
    	       		
    	    if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) )
    	    	if(!getTradeFinanceOriginalVO().getTdiaopercmbio().equals(getTradeFinNegocVO().getTdiaopercmbio()))
    		   	   return true;
    	     		
    		// Moeda do desembolso
    		if(!getTradeFinanceOriginalVO().getCeconmmoedadsemb().equals(getTradeFinNegocVO().getCeconmmoedadsemb()))
    		   return true;

    		//Previsão do desembolso
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getListaFluxos().get(0).getDprevtdsembcmbio()) && SiteUtil.isEmptyOrNull(SiteUtil.dateToString(getViewHelper().getDatePrevDesembolso(),"dd/MM/yyyy")) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getListaFluxos().get(0).getDprevtdsembcmbio()) && !SiteUtil.isEmptyOrNull(SiteUtil.dateToString(getViewHelper().getDatePrevDesembolso(),"dd/MM/yyyy")) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getListaFluxos().get(0).getDprevtdsembcmbio()) && !SiteUtil.isEmptyOrNull(SiteUtil.dateToString(getViewHelper().getDatePrevDesembolso(),"dd/MM/yyyy")) )
    	 	   if(!getTradeFinanceOriginalVO().getListaFluxos().get(0).getDprevtdsembcmbio().equals(SiteUtil.dateToString(getViewHelper().getDatePrevDesembolso(),"dd/MM/yyyy")))
    		   	  return true;
    		    	
    		// Unidade Externa/Banco Correspondente
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDadosPrecificacao().getUnidadeExternaVO().getIbanqrcmbio()) && SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDadosPrecificacao().getUnidadeExternaVO().getIbanqrcmbio()) && !SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio()) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDadosPrecificacao().getUnidadeExternaVO().getIbanqrcmbio()) && !SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio()) )
    		   if(!getTradeFinanceOriginalVO().getDadosPrecificacao().getUnidadeExternaVO().getIbanqrcmbio().equals(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio()))
    	          return true;                                                                                    
    		    	
    		// Libor Travada
    		if(!getTradeFinanceOriginalVO().getVtravaliborcmbio().equals(getTradeFinNegocVO().getVtravaliborcmbio()))
    		   return true;                                                                 

    		// Fluxo de pagamentos
    		if(getTradeFinNegocVO().getListaFluxos().size() > 0) {

    		   // Periodicidade Principal
    		   if(!getTradeFinanceOriginalVO().getListaFluxos().get(0).getCfluxoliqdcprinc().equals(getTradeFinNegocVO().getListaFluxos().get(0).getCfluxoliqdcprinc()))
    			  return true;
    		    	
    		   // Periodicidade Juros
    		   if(!getTradeFinanceOriginalVO().getListaFluxos().get(0).getCodJurosPeriodicidade().equals(getTradeFinNegocVO().getListaFluxos().get(0).getCodJurosPeriodicidade()))
    		      return true;	    	 
    		}
    		else
    		    return true;
    	}
    		    	
    	if(tradeFinNegocVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING))  
    	{
    	    // Moeda da operação 
    	    if(!getTradeFinanceOriginalVO().getCindcdeconmmoeda().equals(getTradeFinNegocVO().getCindcdeconmmoeda()))
    		   return true;

    	    // Valor ME
    	    if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) ) ||
    	    	 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) ) )
    	    	return true;
    	       		
    	    if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) )
    		   if(!SiteUtil.formatarValorWeb(getTradeFinanceOriginalVO().getVnegocmoedaestrg()).equals(getTradeFinNegocVO().getVnegocmoedaestrg()))
    			  return true;
    	    		
    	    // Prazo das letras
    	    if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiavalddletra()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiavalddletra()) ) ||
    	    	 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiavalddletra()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiavalddletra()) ) )
    	    	return true;
    	       		
    	    if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiavalddletra()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiavalddletra()) )
    		   if(!getTradeFinanceOriginalVO().getTdiavalddletra().equals(getTradeFinNegocVO().getTdiavalddletra()))
    			  return true;
    		    	
    		// Moeda do desembolso
    		if(!getTradeFinanceOriginalVO().getCeconmmoedadsemb().equals(getTradeFinNegocVO().getCeconmmoedadsemb()))
    			return true;
    		    	
    		// Prazo Financiamento (Dias)
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) ) ||
    		     ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) ) )
    		    return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) )
    		   if(!getTradeFinanceOriginalVO().getTdiaopercmbio().equals(getTradeFinNegocVO().getTdiaopercmbio()))
    			  return true;
    		    	
    		//Previsão Desembolso Inicial
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevDesemb().getInicio()) && SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevDesemb().getInicio()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevDesemb().getInicio()) && !SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevDesemb().getInicio()) ) )
    		    return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevDesemb().getInicio()) && !SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevDesemb().getInicio()) )
    		   if(!getTradeFinanceOriginalVO().getDataPrevDesemb().getInicio().equals(tradeFinNegocVO.getDataPrevDesemb().getInicio()))
    			  return true;	

    		//Previsão Desembolso Final
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevDesemb().getFim()) && SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevDesemb().getFim()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevDesemb().getFim()) && !SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevDesemb().getFim()) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevDesemb().getFim()) && !SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevDesemb().getFim()) )
    		   if(!getTradeFinanceOriginalVO().getDataPrevDesemb().getFim().equals(tradeFinNegocVO.getDataPrevDesemb().getFim()))
    			  return true;
    		    	
    		//Previsão Embarque Inicial
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevEmbarq().getInicio()) && SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevEmbarq().getInicio()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevEmbarq().getInicio()) && !SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevEmbarq().getInicio()) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevEmbarq().getInicio()) && !SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevEmbarq().getInicio()) )
    		   if(!getTradeFinanceOriginalVO().getDataPrevEmbarq().getInicio().equals(tradeFinNegocVO.getDataPrevEmbarq().getInicio()))
    			  return true;	

    		//Previsão Embarque Final
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevEmbarq().getFim()) && SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevEmbarq().getFim()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevEmbarq().getFim()) && !SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevEmbarq().getFim()) ) )
    		   return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDataPrevEmbarq().getFim()) && !SiteUtil.isEmptyOrNull(tradeFinNegocVO.getDataPrevEmbarq().getFim()) )
    		   if(!getTradeFinanceOriginalVO().getDataPrevEmbarq().getFim().equals(tradeFinNegocVO.getDataPrevEmbarq().getFim()))
    			  return true;
    		    	
    		// About
    		if ( !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCcobrcomisadcio()) )
    		   if(!getTradeFinanceOriginalVO().getCcobrcomisadcio().equals(getTradeFinNegocVO().getCcobrcomisadcio()))
    			  return true;
    		    	
    		// Percentual About
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getPcobervarprodt()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getPcobervarprodt()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getPcobervarprodt()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getPcobervarprodt()) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getPcobervarprodt()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getPcobervarprodt()) )
    		   if(!getTradeFinanceOriginalVO().getPcobervarprodt().equals(getTradeFinNegocVO().getPcobervarprodt()))
    			  return true;
    		    	
    		// Unidade Externa/Banco Correspondente
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDadosPrecificacao().getUnidadeExternaVO().getIbanqrcmbio()) && SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio()) ) ||
    		     ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDadosPrecificacao().getUnidadeExternaVO().getIbanqrcmbio()) && !SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio()) ) )
    		    return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDadosPrecificacao().getUnidadeExternaVO().getIbanqrcmbio()) && !SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio()) )
    		   if(!getTradeFinanceOriginalVO().getDadosPrecificacao().getUnidadeExternaVO().getIbanqrcmbio().equals(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio()))
    			  return true;
    		    	
    		// Libor Travada
    		if(!getTradeFinanceOriginalVO().getVtravaliborcmbio().equals(getTradeFinNegocVO().getVtravaliborcmbio()))
    			return true;   		    
    	}
    	    	
    	if(tradeFinNegocVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)){

    	    // Moeda da operação
    	    if(!getTradeFinanceOriginalVO().getCindcdeconmmoeda().equals(getTradeFinNegocVO().getCindcdeconmmoeda()))
    			return true;
    		
    		// Valor ME
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) )
    		   if(!getTradeFinanceOriginalVO().getVnegocmoedaestrg().equals(getTradeFinNegocVO().getVnegocmoedaestrg()))
    			  return true;

    		// About
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVlimcobervar()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVlimcobervar()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVlimcobervar()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVlimcobervar()) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVlimcobervar()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVlimcobervar()) )
    		   if (SiteUtil.getDouble(getTradeFinanceOriginalVO().getVlimcobervar())!=(SiteUtil.getDouble(getTradeFinNegocVO().getVlimcobervar())))
    			  return true;

    		// Embarque Até
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDlimembrqcmbio()) && SiteUtil.isEmptyOrNull(SiteUtil.dateToString(viewHelper.getDataLimiteEmbarque(), "dd/MM/yyyy" )) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDlimembrqcmbio()) && !SiteUtil.isEmptyOrNull(SiteUtil.dateToString(viewHelper.getDataLimiteEmbarque(), "dd/MM/yyyy" )) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDlimembrqcmbio()) && !SiteUtil.isEmptyOrNull(SiteUtil.dateToString(viewHelper.getDataLimiteEmbarque(), "dd/MM/yyyy" )) )
    		   if(!getTradeFinanceOriginalVO().getDlimembrqcmbio().equals(SiteUtil.dateToString(viewHelper.getDataLimiteEmbarque(), "dd/MM/yyyy" )))
    			  return true;
    		
    		// Prazo Total Operação
    		if(!getTradeFinanceOriginalVO().getTdiaopercmbio().equals(getTradeFinNegocVO().getTdiaopercmbio()))
    			return true;
    	    		
    		// Embarque Parcial
    		if ( !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCindcdembrqpcial()) )
    		   if(!getTradeFinanceOriginalVO().getCindcdembrqpcial().equals(getTradeFinNegocVO().getCindcdembrqpcial()))
    			  return true;
    		    	
    		// ECA
    		if(!getTradeFinanceOriginalVO().getCindcdlastrcarta().equals(getTradeFinNegocVO().getCindcdlastrcarta()))
    			return true;
    	    		
    		// Transferivel
    		if(!getTradeFinanceOriginalVO().getCpermtrnsfcarta().equals(getTradeFinNegocVO().getCpermtrnsfcarta()))
    			return true;
    		    	
    		// Confirmada
    		if(!getTradeFinanceOriginalVO().getCindcdcartacnfdo().equals(getTradeFinNegocVO().getCindcdcartacnfdo()))
    			return true;
    		    	
    		// Any Bank
    		if(!getTradeFinanceOriginalVO().getCindcdcartaidpdt().equals(getTradeFinNegocVO().getCindcdcartaidpdt()))
    			return true;
    		    	
    		// Via CCR
    		if(!getTradeFinanceOriginalVO().getCcartaconverecdd().equals(getTradeFinNegocVO().getCcartaconverecdd()))
    			return true;
    	    	
    	}
    	    		
    	if (tradeFinNegocVO.getProduto().isGarantia()){

    		//Moeda da operação
    	  	if(!getTradeFinanceOriginalVO().getCindcdeconmmoeda().equals(getTradeFinNegocVO().getCindcdeconmmoeda()))
    		    return true;
    		
    		// Valor ME
    	   	if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) ) )
    			return true;
    		    		
    	   	if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getVnegocmoedaestrg()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVnegocmoedaestrg()) )
    	   	   if(!getTradeFinanceOriginalVO().getVnegocmoedaestrg().equals(getTradeFinNegocVO().getVnegocmoedaestrg()))
    	   		   return true;
    		    	
    	  	// Prazo Operação (Dias)
    	   	if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) ) )
    			return true;
    		    		
    	   	if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getTdiaopercmbio()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTdiaopercmbio()) )
    	   	   if(!getTradeFinanceOriginalVO().getTdiaopercmbio().equals(getTradeFinNegocVO().getTdiaopercmbio()))
    	   		  return true;
    		    	
    		// Data Prevista Emissão
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDprevtgarntexpdi()) && SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDprevtgarntexpdi()) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDprevtgarntexpdi()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDprevtgarntexpdi()) ) )
    			return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDprevtgarntexpdi()) && !SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDprevtgarntexpdi()) )
    		   if(!getTradeFinanceOriginalVO().getDprevtgarntexpdi().equals(getTradeFinNegocVO().getDprevtgarntexpdi()))
    			  return true;
    		    	
    		// Data Vencimento Fiança
    		if ( ( !SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDfimnegoccmbio()) && SiteUtil.isEmptyOrNull(SiteUtil.dateToString(getViewHelper().getDateVencFianc(), "dd/MM/yyyy" )) ) ||
    			 ( SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDfimnegoccmbio()) && !SiteUtil.isEmptyOrNull(SiteUtil.dateToString(getViewHelper().getDateVencFianc(), "dd/MM/yyyy" )) ) )
    		    return true;
    		    		
    		if (!SiteUtil.isEmptyOrNull(getTradeFinanceOriginalVO().getDfimnegoccmbio()) && !SiteUtil.isEmptyOrNull(SiteUtil.dateToString(getViewHelper().getDateVencFianc(), "dd/MM/yyyy" )) )
    		   if(!getTradeFinanceOriginalVO().getDfimnegoccmbio().equals(SiteUtil.dateToString(getViewHelper().getDateVencFianc(), "dd/MM/yyyy" )))
    		      return true;
    		    	
    		// Indeterminado
    		if(getTradeFinanceOriginalVO().getCnegoccmbioindmd().equals("1") && !getViewHelper().isIndeterminado()) 
    	        return true;
    		    	
    	   	if(getTradeFinanceOriginalVO().getCnegoccmbioindmd().equals("2") && getViewHelper().isIndeterminado()) 
    	   		return true;
    		    	
    	}
    	return false;
    }    
    
    	/**
    	* Nome: listenerConfirmarIncluirDesembolsoForfaiting
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
    public void listenerConfirmarIncluirDesembolsoForfaiting(AjaxBehaviorEvent e) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerConfirmarIncluirDesembolsoForfaiting <<<<<<<<<<<");
            
            setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_INCLUIR_DESEMBOLSO_FORFAITING.getCodigo());
            
            // valida dados
            if (confirmaAlteracao()) {
                
                // abre moda de confirmação
                getViewHelper().setRenderModal(Boolean.TRUE);
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerConfirmarIncluirDesembolsoForfaiting <<<<<<<<<<<");
        }
        
    }

    	/**
    	* Nome: listenerBaixarSaldo
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
    public void listenerBaixarSaldo(AjaxBehaviorEvent e) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerBaixarSaldo <<<<<<<<<<<");
            
            if (!getDesembolsoForfaitingVO().isBaixarSaldo()) {
                NpcFacesUtils.addInfoModalMessage("Obrigatório confirmar a inclusão/exclusão do desembolso antes de baixar o saldo.", false);
                return;
            }
            
            setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_BAIXAR_SALDO_FORFAITING.getCodigo());
            
            // valida dados
            if (confirmaAlteracao()) {
                
                // abre moda de confirmação
                getViewHelper().setRenderModal(Boolean.TRUE);
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerBaixarSaldo <<<<<<<<<<<");
        }
        
    }
    /**
     * Nome: confirmaAlteracao
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
    public Boolean confirmaAlteracao() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.confirmaAlteracao <<<<<<<<<<<");
    		
    		return validarNegocioCotacao(getTipoAcessoAlterarEvento());

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.confirmaAlteracao <<<<<<<<<<<");
    	}
    	
    }
    
     /**
      * Nome: continuarConfirmar
      * 
      * Propósito: Implementação do metodo abstrato da classe TradeFinanceNegociacaoBase.java
      *
      * @see : Referencias externas.  
      *
      * Registro  de Manutenção: 03/06/2016
      *        - Autor: BRQ
      *        - Responsavel: Equipe Web
      *        - Adequação ao padrão hexavision.
      */
    public void continuarConfirmar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.continuarConfirmar <<<<<<<<<<<");
    		
    		// confirma alteração do dados basicos por produto
    		if (getControleInclusaoAlteracao().equals("DadosBasicos") == true) {
    			alterarDadosBasicos();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ParcelasDesembolso") == true) {
    			incluirParcelasDesembolso();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("FluxoPagtoPrincipalJuros") == true) {
    		    
    		    // Para Grupo 2 inclui fluxo de pagamento e suas parcelas
                // Para BNDES inclui previsão de desembolso
    			alterarFluxoPagtoPrincipalJuros();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("DesembolsoForfaiting") == true) {
    			alterarDesembolsoEouMercadoriaForfainting();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ComissaoInterna") == true) {
    			alterarFluxoPagtoComissaoInterna();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ComissaoExterna") == true) {
    			alterarFluxoPagtoComissaoExterna();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("GarantVinculoTarifaObs") == true) {
    			alterarGarantVinculoTarifaObs();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ComissaoBanqueiro") == true) {
    			alterarFluxoPagtoComissaoBanqueiro();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("DespesasPrecificacao") == true) {
    			alterarDespesasPrecificacao();
    		}
    		
    		if (getControleInclusaoAlteracao().equals("ObservacoesCotacao") == true) {
    			alterarObservacoes();
    		}

    		// Exibe mensagem de retorno do fluxo de validação
    		if (!SiteUtil.isEmptyOrNull(viewHelper.getMensagemFluxoValidacao())) {
    		    getTradeFinNegocVO().setMsgRetorno(viewHelper.getMensagemFluxoValidacao());
    		    viewHelper.setMensagemFluxoValidacao(null);
    		}
    		
    		// Botão Fechar - Após alteração redireciona para tela de fechar cotação
    		if (EnumTradeFinance.ACESSO_FECHAR.getCodigo().equals(getTipoAcessoAlterarEvento())) {
    			
    			BradescoFacesUtils.addInfoModalMessage(getTradeFinNegocVO().getMsgRetorno(), 
    			        "#{tradeFinanceNegociacaoAltBean.confirmarFechar}",
						    BradescoViewExceptionActionType.ACTION, "submit", false);
    		} 
    		
    		// Botão Gerar Boleto - efetiva a alteração, recarrega a tela e abre o modal do boleto 
    		else if (EnumTradeFinance.ACESSO_GERAR_BOLETO.getCodigo().equals(getTipoAcessoAlterarEvento())) {
    			
    			TradeFinanceListaVO dadosGerarBoleto = new TradeFinanceListaVO();
    			dadosGerarBoleto.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
    			dadosGerarBoleto.setCprodtservc(getTradeFinNegocVO().getCprodtservc());
    			dadosGerarBoleto.setCsitbletocmbio(getTradeFinNegocVO().getCsitbletocmbio());
    			
    			tradeFinanceBean.obterDadosBasicos(dadosGerarBoleto, ConstantesTradeFinance.FUNC_CONSULTAR);
    			
    			// informa o bean 'TradeFinanceNegociacaoBean.java' que os dados da tela
    			// de alteração devem ser carregados
    			tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
    			
    			setGerarBoletoAlt(Boolean.TRUE);
    		}
    		
    		// Botão - outros
    		else {
    			
    		    // Para alteração do LC, pergunta se deseja alterar a operação vinculada
    		    if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
    		            && (EnumTradeFinance.ACESSO_CONFIRMAR_DIVERGENTE.getCodigo().equals(getTipoAcessoAlterarEvento())
    		                    || EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo().equals(getTipoAcessoAlterarEvento()))) {
                    
                    openModalConfirmarLC();
                    
                } else {
                    
                    // Redireciona para a tela de consulta (Menu Dinâmico) 
                    BradescoFacesUtils.addInfoModalMessage(getTradeFinNegocVO().getMsgRetorno(), 
                            "#{tradeFinMonitBean.retomarPesquisaMonit}",
                            BradescoViewExceptionActionType.ACTION, "submit", false);   
                }
    		}

    	} catch (NpccTradeWebException e) {
    	    
    	    // Se ocorreu erro durante a alteração exeto no fluxo de dados basicos
    	    if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getNbletonegoccmbio())
    	              && getControleInclusaoAlteracao() != "FimInclusaoAlteracao") {
    	        
    	        tradeFinanceNegociacaoService.desfazimentoAlt(getTradeFinNegocVO().getNbletonegoccmbio());
    	        getTradeFinNegocVO().setMsgRetorno(getTradeFinanceNegociacaoService().getMsgRetorno());
    	    }
    	    
    	    NpcFacesUtils.addInfoModalMessage(getTradeFinNegocVO().getMsgRetorno(), false);
    	    
    	} finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.continuarConfirmar <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
     * Nome: openModalConfirmarLC
     * 
     * Propósito: Abre modal de confirmação do LC Importação e pergunda se deseja alterar a operação vinculada
     *
     * @param : 
     *       <BR/>
     *
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void openModalConfirmarLC() {
        
        tradeFinanceBean.setVincularOperacaoLcVO(new VincularOperacaoLcVO());
        tradeFinanceBean.getVincularOperacaoLcVO().setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
        tradeFinanceBean.getVincularOperacaoLcVO().setCsitbletocmbio(tipoAcessoAlterarEvento);
        tradeFinanceBean.getVincularOperacaoLcVO().setCprodtservc(getTradeFinNegocVO().getCprodtservc());
        
        if(EnumTradeFinance.ACESSO_CONFIRMAR_DIVERGENTE.getCodigo().equals(tipoAcessoAlterarEvento)) {
            tradeFinanceBean.getVincularOperacaoLcVO().setFuncaoTela(ConstantesTradeFinance.FUNC_DIVERGENTE);
        } else {
            tradeFinanceBean.getVincularOperacaoLcVO().setFuncaoTela(ConstantesTradeFinance.FUNC_ALTERAR);
        }
        
        // Executa fluxo NPCCIXX para validar a situação da operação vinculada
        VincularOperacaoLcVO operVinculada = tradeFinanceNegociacaoService.validStatusVinculoLc(tradeFinanceBean.getVincularOperacaoLcVO());
        tradeFinanceBean.getVincularOperacaoLcVO().setCsitequal(operVinculada.getCsitequal());
        tradeFinanceBean.getVincularOperacaoLcVO().setNbletovncloimpor(operVinculada.getNbletovncloimpor());
        tradeFinanceBean.getVincularOperacaoLcVO().setCprodtservc(operVinculada.getCprodtservc());
        tradeFinanceBean.getVincularOperacaoLcVO().setHinclreghist(operVinculada.getHinclreghist());
        tradeFinanceBean.getVincularOperacaoLcVO().setCsitbletocmbio(operVinculada.getCsitbletocmbio());
        tradeFinanceBean.getVincularOperacaoLcVO().setCsitbletoaprov(operVinculada.getCsitbletoaprov());
        tradeFinanceBean.getVincularOperacaoLcVO().setCmodcontrcmbio(operVinculada.getCmodcontrcmbio());
        tradeFinanceBean.getVincularOperacaoLcVO().setOrigemAlteracao(true);
        
        if(tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.DOIS) {
            
         // Redireciona para a tela de consulta (Menu Dinâmico) 
            BradescoFacesUtils.addInfoModalMessage(getTradeFinNegocVO().getMsgRetorno(), 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);
        }
        
        else {
            
            if (tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.UM) {
                vincularOperacaoLcBean.getViewHelper().setPerguntaOperacao("Deseja alterar a operação vinculada?");
            } else {
                vincularOperacaoLcBean.getViewHelper().setPerguntaOperacao("Deseja incluir uma operação vinculada?");
            }
            
            vincularOperacaoLcBean.setVincularOperacaoLcVO(tradeFinanceBean.getVincularOperacaoLcVO());
            vincularOperacaoLcBean.getVincularOperacaoLcVO().setOrigemAlteracao(true);
            vincularOperacaoLcBean.getViewHelper().setMesagemConfirmacao(getTradeFinNegocVO().getMsgRetorno());
            vincularOperacaoLcBean.openModal(null);
        }
    }
    
    public void confirmarVincularOperacaoLC() {
        
        String redirectTo = null;
        
        // Alterar vinculada
        if(tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.UM) {
            
            TradeFinanceListaVO dadosAlterar = new TradeFinanceListaVO();
            dadosAlterar.setNbletonegoccmbio(tradeFinanceBean.getVincularOperacaoLcVO().getNbletovncloimpor());
            dadosAlterar.setCprodtservc(tradeFinanceBean.getVincularOperacaoLcVO().getCprodtservc());
            dadosAlterar.setCsitbletocmbio(tradeFinanceBean.getVincularOperacaoLcVO().getCsitbletocmbio());
            dadosAlterar.setCsitbletoaprov(tradeFinanceBean.getVincularOperacaoLcVO().getCsitbletoaprov());
            dadosAlterar.setCmodcontrcmbio(tradeFinanceBean.getVincularOperacaoLcVO().getCmodcontrcmbio());
            
            tradeFinanceBean.obterDadosBasicos(dadosAlterar, tradeFinanceBean.getVincularOperacaoLcVO().getFuncaoTela());
            tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
            
            // FINIMP DIRETO (1644)
            if (dadosAlterar.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
                redirectTo = ConstantesTradeFinance.FUNC_DIVERGENTE == tradeFinanceBean.getVincularOperacaoLcVO().getFuncaoTela() 
                        ? "finimpDireto/finimpDiretoDvgt.xhtml" : "finimpDireto/finimpDiretoAlt.xhtml";
            } 
            // FINIMP INDIRETO (2692)
            else if (dadosAlterar.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
                redirectTo = ConstantesTradeFinance.FUNC_DIVERGENTE == tradeFinanceBean.getVincularOperacaoLcVO().getFuncaoTela() 
                        ? "finimpIndireto/finimpIndiretoDvgt.xhtml" : "finimpIndireto/finimpIndiretoAlt.xhtml";
            }
            // FINIMP ECA (1715)
            if (dadosAlterar.getProduto().equals(EnumProduto.FINIMP_ECA)) {
                redirectTo = ConstantesTradeFinance.FUNC_DIVERGENTE == tradeFinanceBean.getVincularOperacaoLcVO().getFuncaoTela() 
                        ? "finimpEca/finimpEcaDvgt.xhtml" : "finimpEca/finimpEcaAlt.xhtml";
            }
            
            vincularOperacaoLcBean.closeModal();
        }
        
        // Incluir vinculada
        else if(tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.TRES) {
            
            if (SiteUtil.getInt(tradeFinanceBean.getVincularOperacaoLcVO().getCprodtservc()) == Numeros.ZERO) {
                NpcFacesUtils.addInfoModalMessage("Selecione um produto", EnumButtonBehavior.CLOSE);
                return;
            }
            
            // salva dados da cotação LC 
            SiteUtil.copyPropertiesObjects(getClienteSelecaoVO(), tradeFinanceBean.getVincularOperacaoLcVO().getClienteSelecaoVO());
            
            // FINIMP DIRETO (1644)
            if (tradeFinanceBean.getVincularOperacaoLcVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
                redirectTo = "finimpDireto/finimpDiretoIncl.xhtml";
            } 
            // FINIMP INDIRETO (2692)
            else if (tradeFinanceBean.getVincularOperacaoLcVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
                redirectTo = "finimpIndireto/finimpIndiretoIncl.xhtml";
            }
            // FINIMP ECA (1715)
            if (tradeFinanceBean.getVincularOperacaoLcVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
                redirectTo = "finimpEca/finimpEcaIncl.xhtml";
            }
            
            vincularOperacaoLcBean.closeModal();
        }
        
        BradescoFacesUtils.responseRedirect("/npcc_trade/content/comercializacao/precificacao/negociacao/" + redirectTo);
    }
    
    public void actionFecharModalLc(ActionEvent ae) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.actionFecharModalLc <<<<<<<<<<<");
            
            vincularOperacaoLcBean.closeModal();
            setIniciarPagina(false);
            
            BradescoFacesUtils.responseForward(tradeFinMonitBean.retomarPesquisaMonit());
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionFecharModalLc <<<<<<<<<<<");
        }
        
    }

	/**
	* Nome: fecharModalAlertaAlteracao
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 16/06/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public void fecharModalAlertaAlteracao() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.fecharModalAlertaAlteracao <<<<<<<<<<<");
    		
    		//fechar rendermodal
    		viewHelper.setRenderModalAlerta(Boolean.FALSE);
    		
    		setControleInclusaoAlteracao("DadosBasicos");
    		
    		continuarConfirmar();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.fecharModalAlertaAlteracao <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: alterarDadosBasicosFinimpDireto
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
    private void alterarDadosBasicos() {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.alterarDadosBasicos <<<<<<<<<<<");
            
            getTradeFinNegocVO().setCaditvbletocmbio(EnumTradeFinance.ADITIVO_NEGOC_INICIAL.getCodigo());
            getTradeFinNegocVO().setDvalddnegoccmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteCotacao()));
            getTradeFinNegocVO().setCsitbletoaprov(this.getTradeFinanceBean().getTradeFinanceVO().getCsitbletoaprov());
            if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getQprzmedcmbio())){
            	getTradeFinNegocVO().setQprzmedcmbio(getViewHelper().getPrzomediooperd());
            }
            if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getVtxspreadnegoc())){
            	getTradeFinNegocVO().setVtxspreadnegoc(getItemListaComissaoInterna().getVtxspreadnegoc());
            }
            
            // recupera a data de previsão de embarque para o desenquadradas
            getTradeFinNegocVO().setDprevtembrq(getDesenquadradas().getDprevtembrq());
            
            // Para o GP1 e Gp3 o Valor Moeda do Limite tem que ser enviado nos campos Valor Utilizado e Valor Sensibilizado
            getTradeFinNegocVO().setVutlzdlimgerc(getTradeFinNegocVO().getVmoedalimgerc());
            getTradeFinNegocVO().setVsdolimsensi(getTradeFinNegocVO().getVmoedalimgerc());
            
            // FINIMP DIRETO (1644) OU REFINIMP DIRETO (1646)
            if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)
                            || this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
                
                getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                                getListaFluxos().get(0).getDateFluxoPgto()));
                
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarFinimpOuRefinimpDireto(getTradeFinNegocVO()));
                setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
            }
            
            // FINIMP INDIRETO (2692) OU REFINIMP INDIRETO (1717)
            else if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)
                            || this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
                
                getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                                getListaFluxos().get(0).getDateFluxoPgto()));
                
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarFinimpOuRefinimpIndireto(getTradeFinNegocVO()));
                setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
            }
            
            // LEI 4131 (2010)
            else if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
                
                getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                                getListaFluxos().get(0).getDateFluxoPgto()));
                
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarLei4131(getTradeFinNegocVO()));
                setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
            }
            
            // PPE (1642)
            else if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
                
                getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                                getListaFluxos().get(0).getDateFluxoPgto()));
                
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarPPE(getTradeFinNegocVO()));
                setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
            }
            
            // Working Capital (2011)
            else if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
                
                getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                                getListaFluxos().get(0).getDateFluxoPgto()));
                
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarWorkingCapital(getTradeFinNegocVO()));
                setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
            }
            
            // FORFAITING (644)
            else if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                
                if (getListaDesembolso().size() > Numeros.ZERO) {
                    getTradeFinNegocVO().setDprevtdsembcmbio(getListaDesembolso().get(0).
                                    getDataDesembolsoFormat().replace("/", "."));
                } else {
                    getTradeFinNegocVO().setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(getTradeFinNegocVO().
                                    getDataPrevDesemb().getInicio()));
                }
                
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarForfaiting(getTradeFinNegocVO()));
                setControleInclusaoAlteracao("DesembolsoForfaiting");
            }
            
            // PROEX (642)
            else if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
            	
                Long codigoCredor = new Long(0);
                if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio())){
                    codigoCredor = new Long(getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio());
                }
                getTradeFinNegocVO().setCunicpssoaindica(codigoCredor);
        
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarDadosBasicosGp1Gp3(getTradeFinNegocVO(), getTradeFinanceBean().getTradeFinanceVO()));
                
                setControleInclusaoAlteracao("GarantVinculoTarifaObs");
                
                // FINIMP ECA (1715)
            }   else if (this.getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
                	
                    /////// Enviar a data final calculada para o mainframe
                    Date dfim = commonService.getDataVencimentoFianca(getViewHelper().getDatePrevDesembolso(),
                                    getTradeFinNegocVO().getTdiaopercmbio());
                    
                    getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(dfim));
                    
                	setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarDadosBasicosGp1Gp3(getTradeFinNegocVO(), getTradeFinanceBean().getTradeFinanceVO()));
                	setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
            
                // GARANTIA (1769, 3933)
            }   else if(this.getTradeFinNegocVO().getProduto().isGarantia()) {

                //Se o checkBox 'Indeterminado' for selecionado o campo Dfimnegoccmbio será nulo
                if (getViewHelper().isIndeterminado()) {
                    getTradeFinNegocVO().setCnegoccmbioindmd("1");
                    getTradeFinNegocVO().setDfimnegoccmbio(null);
                    
                } else {
                    getTradeFinNegocVO().setCnegoccmbioindmd("2");
                    getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDateVencFianc()));
                }
                
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarDadosBasicosGp1Gp3(getTradeFinNegocVO(), getTradeFinanceBean().getTradeFinanceVO()));
            
                getTradeFinNegocVO().setNbletonegoccmbio(tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());
                getTradeFinNegocVO().setCunicpssoacmbiob(tradeFinanceBean.getResponsavelDespList().getCunicpssoabnf());
                getTradeFinNegocVO().setCunicpssoacmbioa(tradeFinanceBean.getResponsavelDespList().getCunicpssoaafi());
                getTradeFinNegocVO().setCindcdcntragarnt(tradeFinanceBean.getTradeFinanceVO().getCindcdcntragarnt()); 
                getTradeFinNegocVO().setTdiacntragarnt(tradeFinanceBean.getTradeFinanceVO().getTdiacntragarnt());

                getTradeFinNegocVO().setDvctocntragarnt(tradeFinanceBean.getTradeFinanceVO().getDvctocntragarnt());
                getTradeFinNegocVO().setDabertcntragarnt(tradeFinanceBean.getTradeFinanceVO().getDabertcntragarnt());
                getTradeFinNegocVO().setCindcdrenovcntra(tradeFinanceBean.getTradeFinanceVO().getCindcdrenovcntra());
                getTradeFinNegocVO().setQdiaalertcntra(tradeFinanceBean.getTradeFinanceVO().getQdiaalertcntra());
                getTradeFinNegocVO().setDalertvctocntra(tradeFinanceBean.getTradeFinanceVO().getDalertvctocntra());
                getTradeFinNegocVO().setCindcdcustoexter(tradeFinanceBean.getTradeFinanceVO().getCindcdcustoexter());
//                getTradeFinNegocVO().setCsitbletocmbio(tradeFinanceBean.getTradeFinanceVO().getCsitbletocmbio());
                
                tradeFinanceNegociacaoService.alterarComplGarantia(getTradeFinNegocVO(), getTradeFinNegocVO().getNbletonegoccmbio());

            	// Por: Cláudio Tadeu em: 31/10/2019 - IN ??? - Está ocorrendo inconsistência na gravação dos dados de comissão interna.
                //setControleInclusaoAlteracao("ComissaoExterna");
                setControleInclusaoAlteracao("ComissaoInterna");
            	// *****
                
                
            // BNDES Pré (663, 664, 665, 666, 667, 670, 3934)
            } else if(this.getTradeFinNegocVO().getProduto().isBndesPre()) {

                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarDadosBasicosGp1Gp3(getTradeFinNegocVO(),getTradeFinanceBean().getTradeFinanceVO()));
               
                setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
                
            // BNDES Pós (661, 662)
            } else if (getTradeFinNegocVO().getProduto().isBndesPos()) {
               
               Long codigoCredor = new Long(0);
               this.getTradeFinNegocVO().setDlimenviorsumo((SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteFRO())));
               this.getTradeFinNegocVO().setDvctocntragarnt(getViewHelper().getDataVencProposta());
               this.getTradeFinNegocVO().setDprevtinicembrq(SiteUtil.dataWebToMainframe(getViewHelper().getPeriodoEmbarqueIni()));
               this.getTradeFinNegocVO().setDprevtfimembrq(SiteUtil.dataWebToMainframe(getViewHelper().getPeriodoEmbarqueFim()));
               if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio())){
                   codigoCredor = new Long(getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio());
               }
               getTradeFinNegocVO().setCunicpssoaindica(codigoCredor);
       
               
               setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarDadosBasicosGp1Gp3(getTradeFinNegocVO(), getTradeFinanceBean().getTradeFinanceVO()));
               setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
                
            }
            
            // LC IMPORTAÇÃO (2018)
            else if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                getTradeFinNegocVO().setDlimembrqcmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteEmbarque()));  
                
                /////// Enviar a data final calculada para o mainframe
                Date dfim = commonService.getDataVencimentoFianca(new Date(),
                                getTradeFinNegocVO().getTdiaopercmbio());
                
                getTradeFinNegocVO().setDfimnegoccmbio(SiteUtil.dataWebToMainframe(dfim));
                
                setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarDadosBasicosGp1Gp3(getTradeFinNegocVO(), getTradeFinanceBean().getTradeFinanceVO()));
                setControleInclusaoAlteracao("ParcelasDesembolso");
            }
            
            // COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
            else if (getTradeFinNegocVO().getProduto().isNce()) {
            	
            	setTradeFinNegocVO(getTradeFinanceNegociacaoService().alterarDadosBasicosGp1Gp3(getTradeFinNegocVO(), getTradeFinanceBean().getTradeFinanceVO()));
            	setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
            }
            
            getTradeFinNegocVO().setMsgRetorno(getTradeFinanceNegociacaoService().getMsgRetorno());

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.alterarDadosBasicos <<<<<<<<<<<");
        }


    }
    
    /**
     * 
     * Nome: actionGerarBoleto
     * 
     * Propósito: Ação do botão Gerar Boleto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionGerarBoleto(AjaxBehaviorEvent event) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.actionGerarBoleto <<<<<<<<<<<");
    		
    		// valida dados
    		if (confirmaAlteracao()) {
    			
    			// abre moda de confirmação
    			setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_GERAR_BOLETO.getCodigo());
    			getViewHelper().setRenderModal(Boolean.TRUE);
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionGerarBoleto <<<<<<<<<<<");
    	}
        
    }
    
    /**
     * 
     * Nome: actionFechar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionFechar(){
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.actionFechar <<<<<<<<<<<");
    		
    		// valida dados
    		if (confirmaAlteracao()) {
    			
    			// abre moda de confirmação
    			setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_FECHAR.getCodigo());
    			getViewHelper().setRenderModal(Boolean.TRUE);
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionFechar <<<<<<<<<<<");
    	}
        
    }
    
    /**
     * 
     * Nome: confirmarFechar
     * 
     * Propósito: Direciona para tela de fechar cotação após confirmação da
     * alteração
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String confirmarFechar(){
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.confirmarFechar <<<<<<<<<<<");
    		
    		String pagina = null;
    		
    		TradeFinanceListaVO tradeFinanceListaVO = new TradeFinanceListaVO();
    		tradeFinanceListaVO.setNbletonegoccmbio(tradeFinNegocVO.getNbletonegoccmbio());
    		tradeFinanceListaVO.setCprodtservc(tradeFinNegocVO.getCprodtservc());
    		tradeFinanceListaVO.setCsitbletocmbio(tradeFinNegocVO.getCsitbletocmbio());
    		
    		tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_FECHAR);
    		
    			
    		// FINIMP DIRETO (1644)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
    			
    			pagina = "finimpDiretoFch";
    		}
    		
    		// REFINIMP DIRETO (1646)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
    			
    			pagina = "refinimpDiretoFch";
    		}
    		
    		// FINIMP INDIRETO (2692)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
    			
    			pagina = "finimpIndiretoFch";
    		}
    		
    		// REFINIMP INDIRETO (1717)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
    			
    			pagina = "refinimpIndiretoFch";
    		}
    		
    		// LEI 4131 (2010)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
    			
    			pagina = "lei4131Fch";
    		}
    		
    		// PPE (1642)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
    			
    			pagina = "cotacaoPPEFch";
    		}
    		
    		// WORKING CAPITAL (2011)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
    			
    			pagina = "workingCapitalFch";
    		}
    		
    		// FORFAITING 644
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    			
    			pagina = "forfaitingFch";
    		}
    		
    		// PROEX(2018)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
	
	            return "proexFch";
	        }
	        
	        //LC de Importação (2018)
	        if(tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	            return "lcImportacaoFch";
	        }
	        
	        //NCE(1713, 622, 624, 638,639,640)
	        if(tradeFinanceListaVO.getProduto().isNce()) {
	            return "nceFch";
	        }
	        
	        //BNDES PRE(663, 664, 665, 666, 667, 670, 3934)
	        if(tradeFinanceListaVO.getProduto().isBndesPre()) {
	            return "bndesPreFch";
	        }
	        
	        // BNDS POS(661, 662)
	        if(tradeFinanceListaVO.getProduto().isBndesPos()) {
	            return "bndesPosFch";
	        }
	        
	        // GARANTIA(17,69,3933)
	        if(tradeFinanceListaVO.getProduto().isGarantia()) {
	            return "garantiaIntExpFch";
	        }
    		return pagina;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.confirmarFechar <<<<<<<<<<<");
    	}
        
    }
    
    /**
     * 
    	* Nome: actionPerdido
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 26/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public String actionPerdido(){
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.actionPerdido <<<<<<<<<<<");
    			
    		// FINIMP DIRETO (1644)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
    			
    			return "finimpDiretoPrd";
    		}
    		
    		// REFINIMP DIRETO (1646)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
    			
    			return "refinimpDiretoPrd";
    		}
    		
    		// FINIMP INDIRETO (2692)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
    			
    			return "finimpIndiretoPrd";
    		}
    		
    		// REFINIMP INDIRETO (1717)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
    			
    			return "refinimpIndiretoPrd";
    		}
    		
    		// LEI 4131 (2010)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
    			
    			return "lei4131Prd";
    		}
    		
    		// PPE (1642)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
    			
    			return "cotacaoPPEPrd";
    		}
    		
    		// WORKING CAPITAL (2011)
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
    			
    			return "workingCapitalPrd";
    		}
    		
    		// FORFAITING 644
    		if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    			
    			return "forfaitingConsPrd";
    		}
    		
            // Proex (642)
            if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PROEX)) {
    
                return "proexPrd";
            }
            
            // N.C.E 
            if (tradeFinanceBean.getTradeFinanceVO().getProduto().isNce()) {
    
                return "ncePrd";
            }
            
            // BNDES PRE
            if (tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPre()) {
    
                return "bndesPrePrd";
            }
            
            // BNDES POS
            if (tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPos()) {
    
                return "bndesPosPrd";
            }
            // Finimp ECA
            if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
                return "finimpEcaPrd";
            }
    
            // GARANTIA INTERNACIONAL EXPEDIDAS
            if (tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia()) {
                return "garantiaIntExpPrd";
            }
    
            // LC IMPORTAÇÃO 2018
            if (tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                return "lcImportacaoPrd";
            }
    		
    		return null;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionPerdido <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: alterarFluxoPagtoPrincipalJurosFinimpDireto
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
    private void alterarFluxoPagtoPrincipalJuros() {
        
        // BNDES Pre e Pós
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
            itemDesembolso.setSeqFluxoPagto(Numeros.UM);
            
            List<TrdFinNegMercadoriaVO> listaSelMercadoria = new ArrayList<TrdFinNegMercadoriaVO>();
            
            getTradeFinanceNegociacaoService().alterarFluxoPagtoPrincJuros(itemDesembolso, listaSelMercadoria);
            
            // Seta proximo fluxo a ser executado
            setControleInclusaoAlteracao("GarantVinculoTarifaObs");
        }
        
        // Outros Produtos
        else {
            	for (int i = 0; i < getTradeFinNegocVO().getListaFluxos().size(); i++) {
                TrdFinNegFluxoPagtoVO itemListaFluxos = getTradeFinNegocVO().getListaFluxos().get(i);
                
                itemListaFluxos.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
                itemListaFluxos.setHinclreg(getTradeFinNegocVO().getHinclreg());
                
                List<TrdFinNegMercadoriaVO> listaSelMercadoria = new ArrayList<TrdFinNegMercadoriaVO>();
                
                listaSelMercadoria = getTradeFinNegocVO().getListaMercadoria();
                
                for (int j = 0; j < listaSelMercadoria.size(); j++) {
                	//itemListaFluxos.setSeqFluxoPagto(j);
                	listaSelMercadoria.get(j).setNmcadocmbiotrade(j+1);
				}
                
                getTradeFinanceNegociacaoService().alterarFluxoPagtoPrincJuros(itemListaFluxos, listaSelMercadoria);
            }
            
            // NCE
            if (getTradeFinNegocVO().getProduto().isNce()) {
                
                setControleInclusaoAlteracao("ComissaoExterna");
            } else {
                setControleInclusaoAlteracao("ComissaoInterna");
            }
        }

    }

    /**
     * Nome: alterarFluxoPagtoComissaoInterna
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
    private void alterarFluxoPagtoComissaoInterna() {
        
        Integer seqRegistro = Numeros.NUM1;

        for (Iterator<TrdFinNegComissaoVO> iterator =  getTradeFinNegocVO().getListaComissaoInterna().iterator(); iterator
                .hasNext();) {
            TrdFinNegComissaoVO itemListaComissaoInt = (TrdFinNegComissaoVO) iterator.next();

            itemListaComissaoInt.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
            if (getTradeFinNegocVO().getCprodtservc().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                itemListaComissaoInt.setHinclreg(getTradeFinNegocVO().getHmanutreg());
            } else {
                itemListaComissaoInt.setHinclreg(getTradeFinNegocVO().getHinclreg());
            }
            
            itemListaComissaoInt.setNcomisintrncmbio(seqRegistro++);
            itemListaComissaoInt.setCcobrcomisintrn(getViewHelper().getTipoCobrancaComissao());
            itemListaComissaoInt.setVmincobrcomis(getViewHelper().getVmincobrcomis());
            itemListaComissaoInt.setPtxcustototal(getItemListaComissaoInterna().getPtxcustototal());
            itemListaComissaoInt.setVtxspreadnegoc(getItemListaComissaoInterna().getVtxspreadnegoc());
            itemListaComissaoInt.setVtxspreadtot(getItemListaComissaoInterna().getVtxspreadtot());
            itemListaComissaoInt.setPtxflatpnalt(getItemListaComissaoInterna().getPtxflatpnalt());
            itemListaComissaoInt.setVlxtotalcomis(getItemListaComissaoInterna().getVlxtotalcomis());
            itemListaComissaoInt.setCcobrcomiscmbio(getViewHelper().getCodComissaoSobre());
            itemListaComissaoInt.setCindcdeconmmoeda(getViewHelper().getCodMoedaComissao());
            
        	// Por: Cláudio Tadeu em: 01/11/2019 - IN ??? - Está ocorrendo inconsistência na gravação dos dados de comissão interna. Campo Momento não altera
            itemListaComissaoInt.setCodMomentoComissao(getViewHelper().getCodMomentoComissao());             
            itemListaComissaoInt.setCfluxoperdccmbio(getViewHelper().getCfluxoperdccmbio());
        	// *****
            
            if(getTradeFinNegocVO().getProduto().isGarantia() 
                    || getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                
                itemListaComissaoInt.setVprevtcomiscmbio(getItemListaComissaoInterna().getVlxtotalcomis());
                itemListaComissaoInt.setCcobrcomiscmbio(getViewHelper().getCodComisSobre());
                
                if (getViewHelper().getTipoCobrancaComissao() == 2 || getViewHelper().getTipoCobrancaComissao() == 3) {
                    itemListaComissaoInt.setPjuronegoccmbio(getViewHelper().getValueComissaoCobranca());
                    itemListaComissaoInt.setPcomisnegoccmbio(getViewHelper().getValueComissaoCobranca());
                    itemListaComissaoInt.setVlxcomiscmbio("0,00");
                } else {
                    itemListaComissaoInt.setPjuronegoccmbio("0,00");
                    itemListaComissaoInt.setPcomisnegoccmbio("0,00");
                    itemListaComissaoInt.setVlxcomiscmbio(getViewHelper().getValueComissaoCobranca());
                }
            }

            getTradeFinanceNegociacaoService().alterarFluxoPagtoComissaoInterna(itemListaComissaoInt, getTradeFinNegocVO().getProduto().getCodigo());

        }

        setControleInclusaoAlteracao("ComissaoExterna");
    }

    /**
     * Nome: alterarFluxoPagtoComissaoExterna
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
    private void alterarFluxoPagtoComissaoExterna() {
        
        Integer seqRegistro = Numeros.NUM1;

        // Remove comissão do banqueiro (Crespcomisexter=2 e Ccondceconc=2696)
        if (getTradeFinNegocVO().getListaComissaoExterna().size() > Numeros.ZERO) {
            for (Iterator<IComissaoExterna> iterator = getTradeFinNegocVO().getListaComissaoExterna().iterator(); iterator.hasNext();) {

            	TrdFinNegComissaoVO itemListaComissaoExt = (TrdFinNegComissaoVO) iterator.next();

            	if(itemListaComissaoExt.getCrespcomisexter() == 2 && itemListaComissaoExt.getCcondceconc() == 2696) {
            		iterator.remove();
            	}
            }
        }
        
        if (getTradeFinNegocVO().getListaComissaoExterna().size() > Numeros.ZERO) {
            for (Iterator<IComissaoExterna> iterator = getTradeFinNegocVO().getListaComissaoExterna().iterator(); iterator.hasNext();) {
                TrdFinNegComissaoVO itemListaComissaoExt = (TrdFinNegComissaoVO) iterator.next();

                itemListaComissaoExt.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());

                if (getTradeFinNegocVO().getCprodtservc().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                    itemListaComissaoExt.setHinclreg(getTradeFinNegocVO().getHmanutreg());
                } else {
                    itemListaComissaoExt.setHinclreg(getTradeFinNegocVO().getHinclreg());
                }
                
                itemListaComissaoExt.setNcomisextertrade(seqRegistro++);

                getTradeFinanceNegociacaoService().alterarFluxoPagtoComissaoExterna(itemListaComissaoExt, getTradeFinNegocVO().getProduto().getCodigo());
            }
        } else {
            TrdFinNegComissaoVO itemComissaoExtVazio = new TrdFinNegComissaoVO();

            itemComissaoExtVazio.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());

            if (getTradeFinNegocVO().getCprodtservc().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                itemComissaoExtVazio.setHinclreg(getTradeFinNegocVO().getHmanutreg());
            } else {
                itemComissaoExtVazio.setHinclreg(getTradeFinNegocVO().getHinclreg());
            }
            
            itemComissaoExtVazio.setNcomisextertrade(Numeros.NUM0);

            getTradeFinanceNegociacaoService().alterarFluxoPagtoComissaoExterna(itemComissaoExtVazio, getTradeFinNegocVO().getProduto().getCodigo());
        }

        setControleInclusaoAlteracao("GarantVinculoTarifaObs");
    }

    /**
     * Nome: alterarFluxoPgtoComissaoBanqueiro
     * 
     * Propósito: Inclui comissão desembolso banqueiro automática. Executa chamada ao MF para alterar Comissão Banqueiro
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    private void alterarFluxoPagtoComissaoBanqueiro() {

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
				
				// Identifica quantidade de Comissões externas incluídas para incrementar o contador de Ncomisextertrade 
				int seqRegistro = getTradeFinNegocVO().getListaComissaoExterna().size();
				seqRegistro++;
				
				comissaoBanqueiro.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());	// NR BOLETO
				comissaoBanqueiro.setHinclreg(getTradeFinNegocVO().getHinclreg());					// DATA/HORA INCLUSAO
				comissaoBanqueiro.setNcomisextertrade(seqRegistro);									// NR SEQUENCIAL
				comissaoBanqueiro.setCrespcomisexter(2);											// RESPONSAVEL COMISSAO EXTERNA = 2- DIVISAO (COMISSAO BANQUEIRO)
				comissaoBanqueiro.setCcondceconc(2696);												// TIPO DE COMISSAO EXTERNA = 2696 (Comissão desembolso)
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

				// Altera data de vencimento para data da comissão. O Fluxo não aceita periodicidade inicial com momento antecipado e prazo zerado
				if(comissaoBanqueiro.getListaParcelasComissao().size() > 0) {
					comissaoBanqueiro.getListaParcelasComissao().get(0).setDvctopcelatrade(SiteUtil.dataWebToMainframe(comissaoBanqueiro.getDateComissao()));
				}
	            
		        getTradeFinanceNegociacaoService().alterarFluxoPagtoComissaoExterna(comissaoBanqueiro, getTradeFinNegocVO().getProduto().getCodigo());
			}
        }

        if(getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {

        	String comissaoDesembolso = pesquisarParametroComissaoDesembolso();
        	
			CustoExternoVO custoExternoVO = new CustoExternoVO();
			custoExternoVO.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());										// NR BOLETO
			custoExternoVO.setCsitbletocmbio(99);																				// SITUACAO BOLETO (99 - Só grava custo externo, não muda status) 
			custoExternoVO.setDlimfndngcmbio(SiteUtil.dataWebToMainframe(getCommonService().getDataLimiteCotacao(new Date())));	// DATA LIMITE COTAÇÃO
			custoExternoVO.setCbanqrcmbiofndng(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbanqrcmbio());			// BANCO CORRESP0NDENTE
			custoExternoVO.setCbanqrcmbiorcdor(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbanqrcmbio());			// BANCO REEMBOLSADOR
			custoExternoVO.setVlrcomisdsemb(comissaoDesembolso);																// VALOR COMISSÃO BANQUEIRO
			custoExternoVO.setTdiaopercmbio(getTradeFinNegocVO().getTdiaopercmbio());											// PRAZO
			custoExternoVO.setVnegocmoedaestrg(getTradeFinNegocVO().getVnegocmoedaestrg());										// VALOR ME
			custoExternoVO.setCprodtservc(getTradeFinNegocVO().getCprodtservc());												// PRODUTO
			custoExternoVO.setObservacao("");																					// OBSERVAÇÃO

			tradeFinanceMonitService.alterarCustoExterno("N", custoExternoVO);
        }
        
//      setControleInclusaoAlteracao("GarantVinculoTarifaObs");

		// ECA / LC / NCE
		// BNDES Pré (663, 664, 665, 666, 667, 670, 3934)
		// BNDES Pós (661, 662)
		// PROEX
		// NCE
		// Garantia
		if (getTradeFinNegocVO().getProduto().isGarantia()
		        || getTradeFinNegocVO().getProduto().isBndesPre()
                || getTradeFinNegocVO().getProduto().isBndesPos()
                || getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)
		        || getTradeFinNegocVO().getProduto().isNce()) {
		    
		    setControleInclusaoAlteracao("ObservacoesCotacao");    
		}
		
		// LC IMPORTAÇÃO (2018)
        else if(getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA) 
        		|| getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            
            setControleInclusaoAlteracao("DespesasPrecificacao");
        } 
		
		// OUTROS
		else {
			setControleInclusaoAlteracao("FimInclusaoAlteracao");
			
		}
    }

    private void alterarGarantVinculoTarifaObs() {

        getTradeFinNegocVO().setListaGarantiasInclusao(getGarantiasModalBean().getListaGarantiasInclusao());

        getTradeFinNegocVO().setNtpopapelcmbio(EnumTradeFinance.TIPO_PAPEL_AVALISTA.getCodigo());
        getTradeFinNegocVO().setListaAvalistasInclusao(getGarantiasModalBean().getListaAvalistasInclusao());

        getTradeFinNegocVO().setDadosPrecificacao(getTrdFinNegPrecificacaoVO());
        
        Integer cinddcdecomMoeda = getTradeFinNegocVO().getDadosPrecificacao().getCindcdeconmmoeda();
		Long cBanqrCmbio = getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio();
		
		// Trata campo tomador para produtos Working Capital e Forfaiting
        if(!SiteUtil.isEmptyOrNull(getTomadorModal().getCunicpssoacmbio()) && getTomadorModal().getCunicpssoacmbio() > 0L) {
            // Pega o código selecionado na lupa
            getTradeFinNegocVO().setEcunicpssoacmbiot(getTomadorModal().getCunicpssoacmbio());
        }
		
		getTradeFinanceNegociacaoService().alterarGarantiasVinculosTarifasObs(getTradeFinNegocVO(), getTrdFinNegPrecificacaoVO());
		
		getTradeFinNegocVO().getDadosPrecificacao().setCindcdeconmmoeda(cinddcdecomMoeda);
		getTradeFinNegocVO().getDadosPrecificacao().getUnidadeExternaVO().setCbanqrcmbio(cBanqrCmbio);
		
	    setControleInclusaoAlteracao("ComissaoBanqueiro");    
		
//		// ECA / LC / NCE
//		// BNDES Pré (663, 664, 665, 666, 667, 670, 3934)
//		// BNDES Pós (661, 662)
//		// PROEX
//		// NCE
//		// Garantia
//		if (getTradeFinNegocVO().getProduto().isGarantia()
//		        || getTradeFinNegocVO().getProduto().isBndesPre()
//                || getTradeFinNegocVO().getProduto().isBndesPos()
//                || getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)
//		        || getTradeFinNegocVO().getProduto().isNce()) {
//		    
//		    setControleInclusaoAlteracao("ObservacoesCotacao");    
//		}
//		
//		// LC IMPORTAÇÃO (2018)
//        else if(getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA) 
//        		|| getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
//            
//            setControleInclusaoAlteracao("DespesasPrecificacao");
//        } 
//		
//		// OUTROS
//		else {
//			setControleInclusaoAlteracao("FimInclusaoAlteracao");
//			
//		}
		
    }
    
    public ListaCotacoesExternasVO getListaCotacoes() {
        return listaCotacoes;
    }

    public void setListaCotacoes(ListaCotacoesExternasVO listaCotacoes) {
        this.listaCotacoes = listaCotacoes;
    }

    /**
     * Nome: incluirObservacoes
     * 
     * Propósito: Executa chamada ao MF para incluir Observações da Cotação
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */    
    private void alterarObservacoes() {

        getTradeFinNegocVO().getObsCotacaoVO().setCtpooper("A");                    
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
        
        // A tela de proex contém apenas CNPJ nas observações por este motivo setamos o campo codCpfCnpj com valor 2.
        if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)) {
            getTradeFinNegocVO().getObsCotacaoVO().setCodCpfCnpj(Numeros.NUM2);
        }

        // Aciona o Fluxo: NPCCIAP2 - Books: NPCCWW0E / NPCCWW0S
        getTradeFinanceNegociacaoService().incluirAlterarObservacoesCotacao(getTradeFinNegocVO().getObsCotacaoVO());
        
        setControleInclusaoAlteracao("FimInclusaoAlteracao");
       
    }
    
    private void alterarDesembolsoEouMercadoriaForfainting(){
        TradeFinanceDesembolsoVO itemDesembolso = null;

        if (getListaDesembolso().size() > Numeros.ZERO) {
            for (Iterator<TradeFinanceDesembolsoVO> iterator = getListaDesembolso().iterator(); iterator.hasNext();) {
                itemDesembolso = (TradeFinanceDesembolsoVO) iterator.next();
            
                itemDesembolso.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
                itemDesembolso.setHinclreg(getTradeFinNegocVO().getHmanutreg());
                if (EnumTradeFinance.ACESSO_BAIXAR_SALDO_FORFAITING.getCodigo().equals(getTipoAcessoAlterarEvento())) {
                    itemDesembolso.setCmomencobrcmbio(EnumTradeFinance.SIM_ZERAR_SALDO.getCodigo());
                } else {
                    itemDesembolso.setCmomencobrcmbio(EnumTradeFinance.NAO_ZERAR_SALDO.getCodigo());
                }
                
                List<TrdFinNegMercadoriaVO> listaSelMercadoria = new ArrayList<TrdFinNegMercadoriaVO>();
                
                for (Iterator<TrdFinNegMercadoriaVO> iteratorMerc = getTradeFinNegocVO().getListaMercadoria().iterator();
                        iteratorMerc.hasNext();) {
                    TrdFinNegMercadoriaVO itemMercadoria = (TrdFinNegMercadoriaVO) iteratorMerc.next();
                    
                    if (itemMercadoria.getNdsembcmbiotrade().equals(itemDesembolso.getSeqDesembolso())) {
                        listaSelMercadoria.add(itemMercadoria);
                    }
                }
                
                getTradeFinanceNegociacaoService().alterarDesembolsoEouMercadoriaForfainting(itemDesembolso,
                                listaSelMercadoria);
            }
        } else {
            if (getTradeFinNegocVO().getListaMercadoria().size() > Numeros.ZERO) {
                
                itemDesembolso = new TradeFinanceDesembolsoVO();
                itemDesembolso.setSeqDesembolso(Numeros.NUM0);
                itemDesembolso.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
                if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                    itemDesembolso.setHinclreg(getTradeFinNegocVO().getHinclreg());
                    
                }else {
                    itemDesembolso.setHinclreg(getTradeFinNegocVO().getHmanutreg()); 
                }
                
                getTradeFinanceNegociacaoService().alterarDesembolsoEouMercadoriaForfainting(itemDesembolso,
                                getTradeFinNegocVO().getListaMercadoria());
            }

        }
		
        if (getTipoAcessoAlterarEvento() == EnumTradeFinance.ACESSO_INCLUIR_DESEMBOLSO_FORFAITING.getCodigo() 
                || getTipoAcessoAlterarEvento() == EnumTradeFinance.ACESSO_BAIXAR_SALDO_FORFAITING.getCodigo()) {
            setControleInclusaoAlteracao("FimInclusaoAlteracao");
        } else {
            setControleInclusaoAlteracao("ComissaoInterna");
        }
    }
    
    /**
     * Nome: alterarDespesasPrecificacao
     * 
     * Propósito: Executa chamada ao MF para incluir as Despesas LC
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */ 
    private void alterarDespesasPrecificacao() {
    		
        ListaCotacoesExternasVO cotacaoFunding = new ListaCotacoesExternasVO();
        cotacaoFunding.setListaDespesas(getTradeFinNegocVO().getListaDespesas());
        
        numerarCotacoesDespesas();
        
        //Derick - se nao houver valor tem que ser chamado o fluxo abaixo para ser apagado no mainframe - pedido Sergio e Tesser
        if(getTradeFinNegocVO().getListaCotacoes() == null || getTradeFinNegocVO().getListaCotacoes().size() == 0 ){
        	getTradeFinNegocVO().getListaCotacoes().add(new ListaCotacoesExternasVO());
        }
        
        for (int i = 0; i < getTradeFinNegocVO().getListaCotacoes().size(); i++) {

        	getTradeFinNegocVO().getCotacaoFundingVO().setPtxfixacmbio(getTrdFinNegPrecificacaoVO().getPtxfixacmbio());
        	getTradeFinNegocVO().getCotacaoFundingVO().setCindcdeconmmoelib(getTrdFinNegPrecificacaoVO().getCindcdeconmmoeda());
        	getTradeFinNegocVO().getCotacaoFundingVO().setTmesliborcmbio(getTrdFinNegPrecificacaoVO().getTmesliborcmbio());
        	getTradeFinNegocVO().getCotacaoFundingVO().setVtxliborcmbio(getTrdFinNegPrecificacaoVO().getVtxliborcmbio());
        	
        	getTradeFinNegocVO().getListaCotacoes().get(i).setVtxliborcmbio(getTrdFinNegPrecificacaoVO().getVtxliborcmbio());
        	getTradeFinNegocVO().getListaCotacoes().get(i).setTmesliborcmbio(getTrdFinNegPrecificacaoVO().getTmesliborcmbio());
        	getTradeFinNegocVO().getListaCotacoes().get(i).setTdiaopercmbio(getTrdFinNegPrecificacaoVO().getTdiaopercmbioprcf());
        	getTradeFinNegocVO().getListaCotacoes().get(i).setCindcdeconmmoelib(getTrdFinNegPrecificacaoVO().getCindcdeconmmoeda());
        	
        	getTradeFinNegocVO().getListaCotacoes().get(i).setCusuarmanut(getTradeFinNegocVO().getListaCotacoes().get(i).getCusuarmanut());
        	// Aciona o Fluxo: NPCCIAPX - Books: NPCCWV6E / NPCCWV6S
            tradeFinanceNegociacaoService.incluirAlterarDespesasFundingLC(
            				getTradeFinNegocVO().getNbletonegoccmbio(), 
                            getTradeFinNegocVO().getHinclreg(),
                            getTradeFinNegocVO().getListaCotacoes().get(i), 
                            "A");
            
        }

        if (getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
        	setControleInclusaoAlteracao("FimInclusaoAlteracao");
        } else {
        	setControleInclusaoAlteracao("ObservacoesCotacao");        
        }
        
    	
    }
    
    /**
     * Nome: incluirParcelasDesembolso
     * 
     * Propósito: Executa chamada ao MF para incluir as Parcelas de Desembolso
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */ 
    private void incluirParcelasDesembolso() {
        
        // Aciona o Fluxo: NPCCIAPS - Books: NPCCWV1E / NPCCWV1S
        getTradeFinanceNegociacaoService().incluirParcelasDesembolso(
                        getTradeFinNegocVO().getNbletonegoccmbio(), 
                        getTradeFinNegocVO().getHinclreg(), 
                        getTradeFinNegocVO().getListaParcelas());

        if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            setControleInclusaoAlteracao("DesembolsoForfaiting");
        }else{
            setControleInclusaoAlteracao("ComissaoInterna");        
        }
    }   
    
    /**
     * Nome: anexarEmail
     * 
     * Propósito: Habilita/Desabilita modal de anexar e-mail
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void anexarEmail(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.anexarEmail <<<<<<<<<<<");
    		
    		anexarArquivoGccModalBean.getViewHelper().setTitleModal("Anexar E-mail");
    		openModalAnexarArquivo(EnumPastasGcc.EMAIL);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.anexarEmail <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: anexarDocumentos
     * 
     * Propósito: Habilita/Desabilita modal de anexar documentos
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void anexarDocumentos(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.anexarDocumentos <<<<<<<<<<<");
    		
    		anexarArquivoGccModalBean.getViewHelper().setTitleModal("Anexar Documento");
    		openModalAnexarArquivo(EnumPastasGcc.DIVERSOS);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.anexarDocumentos <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: toggleModalAnexarEmail
     * 
     * Propósito: Habilita/Desabilita modal de anexar e-mail
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModalAnexarArquivo(EnumPastasGcc pastaDestino) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.openModalAnexarArquivo <<<<<<<<<<<");
    		
    		AnexarArquivoGccVO parametros = new AnexarArquivoGccVO();
    		
    		// nome da pasta ano e mês
    		String[] strData = tradeFinanceBean.getTradeFinanceVO().getDinclreg().replace(".", "/").split("/");
    		parametros.setAnoMes(strData[2] + strData[1]);
    		
    		// nome da pasta numero do boleto
    		parametros.setNroBoleto(tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio().toString());
    		
    		// nome da pasta final
    		parametros.setPasta(pastaDestino);
    		
    		// tipo de pessoa e CPF/CNPJ
    		if (tradeFinanceBean.getTradeFinanceVO().getCflial() == Numeros.ZERO) {
    			parametros.setTipoPessoa(String.valueOf((Numeros.TRES)));
    		} else {
    			parametros.setTipoPessoa(String.valueOf(Numeros.SEIS));
    		}
    		parametros.setCpfCnpj(tradeFinanceBean.getTradeFinanceVO().getCpfcnpj().toString());
    		
    		// set modal id
    		anexarArquivoGccModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalAnexarEmail");
    		
    		// recarrega lista depois de anexar
    		anexarArquivoGccModalBean.getViewHelper().setRecarregaLista(Boolean.FALSE);
    		
    		// abre modal para anexar arquivo
    		anexarArquivoGccModalBean.openModal(parametros);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.openModalAnexarArquivo <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
     * Nome: gerarBoleto
     * 
     * Propósito: Gerar boleto apartir do item selecionado na lista
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String gerarBoleto() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.gerarBoleto <<<<<<<<<<<");
    		
    		setGerarBoletoAlt(Boolean.FALSE);
    		
            // GARANTIA INTERNACIONAL EXPEDIDAS
            if (tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia()) {
        		this.getTradeFinanceBean().setComboProduto(this.getViewHelper().getComboProduto());
            }
    		return tradeFinanceBean.gerarBoleto();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.gerarBoleto <<<<<<<<<<<");
    	}
        
    }
    
    /**
     * @return o valor do csitbletocmbio
     */
    @SuppressWarnings("unused")
	private Integer getCsitbletocmbio() {
        return csitbletocmbio;
    }

    /**
     * @param csitbletocmbio seta o novo valor para o campo csitbletocmbio
     */
    private void setCsitbletocmbio(Integer csitbletocmbio) {
        this.csitbletocmbio = csitbletocmbio;
    }

    /**
     * @return o valor do tipoAcessoAlterarEvento
     */
    public int getTipoAcessoAlterarEvento() {
        return tipoAcessoAlterarEvento;
    }

    /**
     * @param tipoAcessoAlterarEvento seta o novo valor para o campo tipoAcessoAlterarEvento
     */
    public void setTipoAcessoAlterarEvento(int tipoAcessoAlterarEvento) {
        this.tipoAcessoAlterarEvento = tipoAcessoAlterarEvento;
    }

    /**
     * @return o valor do gerarBoletoAlt
     */
    public Boolean getGerarBoletoAlt() {
        return gerarBoletoAlt;
    }

    /**
     * @param gerarBoletoAlt seta o novo valor para o campo gerarBoletoAlt
     */
    public void setGerarBoletoAlt(Boolean gerarBoletoAlt) {
        this.gerarBoletoAlt = gerarBoletoAlt;
    }

    /**
     * @return o valor do renderBotaoCotarCustoExterno
     */
    public Boolean getRenderBotaoCotarCustoExterno() {
        return renderBotaoCotarCustoExterno;
    }

    /**
     * @param renderBotaoCotarCustoExterno seta o novo valor para o campo renderBotaoCotarCustoExterno
     */
    public void setRenderBotaoCotarCustoExterno(Boolean renderBotaoCotarCustoExterno) {
        this.renderBotaoCotarCustoExterno = renderBotaoCotarCustoExterno;
    }
  
    /**
     * @return o valor do renderBotaoFechar
     */
    public Boolean getRenderBotaoFechar() {
		return renderBotaoFechar;
	}

    /**
     * @param renderBotaoFechar seta o novo valor para o campo renderBotaoFechar
     */
	public void setRenderBotaoFechar(Boolean renderBotaoFechar) {
		this.renderBotaoFechar = renderBotaoFechar;
	}
    
	
	
	
	/**
	 * Tela de alteracao L/C criado por derick
	 * INICIO
	 */
	
	/**
     * Nome: listenerConfirmaInclusao
     * 
     * Propósito: Botão confirmar da tela de inclusão Realiza inclusão dos
     * seguintes produtos: - Finimp Direto - Refinimp Direto - Finimp Indireto -
     * Refinimp Indireto
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
    public void listenerConfirmaInclusao(AjaxBehaviorEvent event) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltlBean.listenerConfirmaInclusao <<<<<<<<<<<");
    		
    		// Integer paramOrigem = SiteUtil.getInt(event.getComponent().getAttributes().get("paramConfirmar"));
    		
    		setTipoAcessoIncluirEvento(EnumTradeFinance.ACESSO_CONFIRMAR_ALTERAR.getCodigo());
    		
    		// Para PROEX estas validações não são necessárias.
    		if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX) == Boolean.FALSE) {
    			
    			if (validarNegocioCotacao(getTipoAcessoIncluirEvento()) == Boolean.FALSE) {
    				return;
    			}
    		}
    		
    		getViewHelper().setRenderModal(Boolean.TRUE);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltlBean.listenerConfirmaInclusao <<<<<<<<<<<");
    	}
        
    }
    
    
    public int getTipoAcessoIncluirEvento() {
		return tipoAcessoIncluirEvento;
	}

	public void setTipoAcessoIncluirEvento(int tipoAcessoIncluirEvento) {
		this.tipoAcessoIncluirEvento = tipoAcessoIncluirEvento;
	}
	
	   
   

	
	/**
	 * Tela de alteracao L/C criado por derick
	 * FIM
	 */
	
	
    /**
     * Tela de alteracao PROEX criado por derick
     * INICIO
     */
    
    
    /**
     * Nome: listenerAutorizacaoDsn
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 09/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void listenerAutorizacaoDsn(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerAutorizacaoDsn <<<<<<<<<<<");
    		
    		setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_AUTORIZA_DSN.getCodigo());
    	
    		if (validarNegocioCotacao(getTipoAcessoAlterarEvento())) {
    		    abrirModalMotivoAutorizacaoDsn();
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerAutorizacaoDsn <<<<<<<<<<<");
    	}

    }
	    
	
	/**
	 * Nome: getSelectItemRadioRebate
	 * 
	 * Propósito: 
	 *
	 * @param : 
	 * @return : 
	 * @throws :
	 * @exception : 
	 * @see : Referencias externas.  
	 *
	 * Registro  de Manutenção: 25/05/2016
	 *        - Autor: BRQ
	 *        - Responsavel: Equipe Web
	 *        - Adequação ao padrão hexavision.
	 */
	public List<SelectItem> getSelectItemRadioRebate() {
		
		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.getSelectItemRadioRebate <<<<<<<<<<<");
			
			List<SelectItem> list = new ArrayList<SelectItem>();
			for (int index = 0; index < getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().size(); index++) {
				list.add(new SelectItem(index, "", ""));
			}
			return list;
	
		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.getSelectItemRadioRebate <<<<<<<<<<<");
		}
		
	}
    
	

    /**
     * Nome: getSelectItemRadioTaxaDesconto
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioTaxaDesconto() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.getSelectItemRadioTaxaDesconto <<<<<<<<<<<");
    		
    		List<SelectItem> list = new ArrayList<SelectItem>();
    		for (int index = 0; index < getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		return list;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.getSelectItemRadioTaxaDesconto <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * Nome: incluirItemRebate
     * 
     * Propósito: Incluir na lista de rebate o rebate informadado pelo usuário. 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void incluirItemRebate(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.incluirItemRebate <<<<<<<<<<<");
    		
    		// Verifica se o campo rebate esta preenchido.
    		if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getRebate())) {
    			
    			NpcFacesUtils.addInfoModalMessage("O campo Rebate é obrigatório.", false);
    		} else {
    			ListaRebateVO itemRebate = new ListaRebateVO();
    			itemRebate.setRebate(SiteUtil.getString(getTradeFinNegocVO().getRebate()));
    			getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().add(itemRebate);
    		}
    		
    		// Limpa o campo de rebate.
    		getTradeFinNegocVO().setRebate(SiteUtil.STRING_EMPTY);
    		getViewHelper().setCodRebateSelecionado(null);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.incluirItemRebate <<<<<<<<<<<");
    	}

    }
    
    /**
     * Nome: excluirItemRebate
     * 
     * Propósito: Excluir o item selecionado na lista de rebate.
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void excluirItemRebate(AjaxBehaviorEvent evento) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.excluirItemRebate <<<<<<<<<<<");
    		
    		/** Se não houver seleção retorna mensagem na tela */
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getCodRebateSelecionado())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um registro para excluir.", false);
    			return;
    		} else {
    			
    			ListaRebateVO itemRemove =
    							getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().get(SiteUtil.getInt(getViewHelper().getCodRebateSelecionado()));
    			
    			// Remove o item selecionado.
    			getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().remove(itemRemove);
    		}
    		
    		// Limpa a seleção dos itens da lista.
    		getViewHelper().setCodRebateSelecionado(null);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.excluirItemRebate <<<<<<<<<<<");
    	}

    }
    
    /**
     * Nome: incluirItemTaxaDesconto
     * 
     * Propósito: Incluir na lista de taxa desconto a taxa informadada pelo usuário. 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void incluirItemTaxaDesconto(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.incluirItemTaxaDesconto <<<<<<<<<<<");
    		
    		// Verifica se o campo rebate esta preenchido.
    		if (SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getTaxaDesconto())) {
    			NpcFacesUtils.addInfoModalMessage("O campo Taxa Desconto é obrigatório.", false);
    		} else {
    			ListaTaxaDescontoVO itemTaxaDesconto = new ListaTaxaDescontoVO();
    			itemTaxaDesconto.setTxades(SiteUtil.getString(getTradeFinNegocVO().getTaxaDesconto()));
    			getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().add(itemTaxaDesconto);
    		}
    		
    		getTradeFinNegocVO().setTaxaDesconto(SiteUtil.STRING_EMPTY);
    		getViewHelper().setCodTaxaDescontoSelecionado(null);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.incluirItemTaxaDesconto <<<<<<<<<<<");
    	}

    }
    
    /**
     * Nome: excluirItemTaxaDesconto
     * 
     * Propósito: Excluir o item selecionado na lista de taxa desconto.
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 25/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void excluirItemTaxaDesconto(AjaxBehaviorEvent evento) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.excluirItemTaxaDesconto <<<<<<<<<<<");
    		
    		/** Se não houver seleção retorna mensagem na tela */
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getCodTaxaDescontoSelecionado())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um registro para excluir.", false);
    			return;
    		} else {
    			
    			ListaTaxaDescontoVO itemRemover =
    							getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().get(
    											SiteUtil.getInt(getViewHelper().getCodTaxaDescontoSelecionado()));
    			
    			// Remove o item selecionado.
    			getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa().remove(itemRemover);
    		}
    		
    		// Limpa a seleção dos itens da lista.
    		getViewHelper().setCodTaxaDescontoSelecionado(null);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.excluirItemTaxaDesconto <<<<<<<<<<<");
    	}

    }

    /**
     * Tela de alteracao PROEX criado por derick
     * FIM
     */

    
    
    /**
     * Tela de alteracao ECA criado por derick
     * INICIO
     */
    
    
    /**
     * Nome: listenerIncluirCotacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirCotacao(AjaxBehaviorEvent e) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerIncluirCotacao <<<<<<<<<<<");
            
            if(getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)
            		|| getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
            		|| getTradeFinNegocVO().getProduto().isGarantia()){          
            	
            	if(getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)){
            		if(SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio())){
            			NpcFacesUtils.addInfoModalMessage("O campo \"Banco Financiador\" deve ser preenchido!", false);
                		return;
            		}
            	}
            	
            	if (SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio())
            			&& SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getCbanqrcmbio())) {

            		NpcFacesUtils.addInfoModalMessage("É preciso informar pelo menos um Banco!", false);
            		return;

            	}else{
            		getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbiofndng(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio());
            		getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbiofndng(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getIbanqrcmbio());
            		getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbioaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getCbanqrcmbio());
            		getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbioaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getIbanqrcmbio());
                    getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbiorcdor(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getCbanqrcmbio());
                    getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbiorcdor(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getIbanqrcmbio());
            	}           	
            	
            }else{
            	
            	if (SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio())) {
            		NpcFacesUtils.addInfoModalMessage("O campo \"Banco Financiador\" deve ser preenchido!", false);
            		return;
            	} else {
            		getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbiofndng(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio());
            		getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbiofndng(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getIbanqrcmbio());
            	}
            	
                if (SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getCbanqrcmbio())) {
                    NpcFacesUtils.addInfoModalMessage("O campo \"Banco Reembolsador\" deve ser preenchido!", false);
                    return;
                } else {
                    getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbiorcdor(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getCbanqrcmbio());
                    getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbiorcdor(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getIbanqrcmbio());
                }
            }


            if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)){
                if (SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getCbanqrcmbio())
                		&& SiteUtil.getInt(getTradeFinNegocVO().getCindcdcartacnfdo()) == Numeros.UM) {
            		NpcFacesUtils.addInfoModalMessage("O flag de confirmada está como sim,\n favor preencher o banco Avisador!", false);
            		return;
                }else{
                    getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbioaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getCbanqrcmbio());
                    getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbioaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getIbanqrcmbio());
                }
            }


            if (getViewHelper().getDataValidadeCotacao() == null || (getViewHelper().getDataValidadeCotacao() != null && !validarDataDiaUtil(getViewHelper().getDataValidadeCotacao()))) {
                NpcFacesUtils.addInfoModalMessage("O campo \"Validade da Cotação\" deve ser preenchido!", false);
                return;
            } else {
                getTradeFinNegocVO().getCotacaoFundingVO().setDlimfndngcmbio(SiteUtil.dateToString(
                                getViewHelper().getDataValidadeCotacao(), "dd/MM/yyyy"));


                /** Indica usuário que realizou a ação **/
                getTradeFinNegocVO().getCotacaoFundingVO().setCusuariosess(getTradeFinNegocVO().getCusuariosess());
                getTradeFinNegocVO().getCotacaoFundingVO().setNusuariosess(getTradeFinNegocVO().getNusuariosess());

                //getTradeFinNegocVO().getCotacaoFundingVO().setCfndng(1L);
                getTradeFinNegocVO().getCotacaoFundingVO().setDcotacfndngcmbio(SiteUtil.dateToString(new Date(), "dd/MM/yyyy"));
                getTradeFinNegocVO().getCotacaoFundingVO().setCindcdfndngutlzd("S");
                getTradeFinNegocVO().getCotacaoFundingVO().setNindcdfndngutlzd("Em Negociação");

                getTradeFinNegocVO().getListaCotacoes().add(getTradeFinNegocVO().getCotacaoFundingVO());
                getTradeFinNegocVO().setCotacaoFundingVO(new ListaCotacoesExternasVO());
                
                setUnidadeExternaVO(new UnidadeExternaVO());
                setBancoReembolsadorVO(new UnidadeExternaVO());
                setBancoAvisadorVO(new UnidadeExternaVO());

            }
            complListaAlteracaoCotacao();

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerIncluirCotacao <<<<<<<<<<<");
        }                
    }
    
    	/**
    	* Nome: listenerIncluirCotacaoGarantia
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
    public void listenerIncluirCotacaoGarantia(AjaxBehaviorEvent e) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerIncluirCotacao <<<<<<<<<<<");

            if (SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbanqrcmbio())) {
                NpcFacesUtils.addInfoModalMessage("O campo \"Banco\" deve ser preenchido!", false);
                return;
            } else {
                getTradeFinNegocVO().getResponsavelDespesaVO().setCbanqrcmbio(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbanqrcmbio());
                getTradeFinNegocVO().getResponsavelDespesaVO().setNbanqrcmbio(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio());
            }

            if(getViewHelper().getFuncaoSelecionada().equals(Numeros.UM)){
                getTradeFinNegocVO().getResponsavelDespesaVO().setCbanqrcmbiofndg(getViewHelper().getFuncaoSelecionada());
                getTradeFinNegocVO().getResponsavelDespesaVO().setNfuncresp("Emissor");

            }else if(getViewHelper().getFuncaoSelecionada().equals(Numeros.DOIS)){
                getTradeFinNegocVO().getResponsavelDespesaVO().setCbanqrcmbiorcdor(getViewHelper().getFuncaoSelecionada());
                getTradeFinNegocVO().getResponsavelDespesaVO().setNfuncresp("Confirmador");

            }else if(getViewHelper().getFuncaoSelecionada().equals(Numeros.TRES)){
                getTradeFinNegocVO().getResponsavelDespesaVO().setCbanqrcmbioaviso(getViewHelper().getFuncaoSelecionada());
                getTradeFinNegocVO().getResponsavelDespesaVO().setNfuncresp("Avisador");
            }

            getTradeFinNegocVO().getResponsavelDespesaVO().setCmunintlcmbio(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCmunintlcmbio());
            getTradeFinNegocVO().getResponsavelDespesaVO().setImunintlcmbio(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getImunintlcmbio());
            getTradeFinNegocVO().getResponsavelDespesaVO().setIpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIpais());
            getTradeFinNegocVO().getResponsavelDespesaVO().setCpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais());
            getTradeFinNegocVO().getResponsavelDespesaVO().setCidbanqrswift(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCidbanqrswift());

            getTradeFinNegocVO().getListaRespDesp().add(getTradeFinNegocVO().getResponsavelDespesaVO());
            getViewHelper().setFuncaoSelecionada(0);

            //getTradeFinNegocVO().getCotacaoFundingVO().setCfndng(1L);
            getTradeFinNegocVO().getResponsavelDespesaVO().setDcotacfndngcmbio(SiteUtil.dateToString(new Date(), "dd/MM/yyyy"));
            getTradeFinNegocVO().getResponsavelDespesaVO().setCindcdfndngutlzd("S");
            getTradeFinNegocVO().getResponsavelDespesaVO().setNindcdfndngutlzd("Em Negociação");

            complListaAlteracaoCotacao();


        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerIncluirCotacao <<<<<<<<<<<");
        } 
    }

        
    
    /**
     * Nome: listenerExcluirCotacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerExcluirCotacao(AjaxBehaviorEvent e) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerExcluirCotacao <<<<<<<<<<<");

            // valida se foi selecionado um item na lista
            if (getViewHelper().getItemSelecListaCotacoes() == null) {
                NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            }

            // Remove o item selecionado.
            ListaCotacoesExternasVO itemCotacao = getTradeFinNegocVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes());
            getTradeFinNegocVO().getListaCotacoes().remove(itemCotacao);
            getTradeFinNegocVO().setListaDespesas(new ArrayList<ListaDespesasVO>());

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerExcluirCotacao <<<<<<<<<<<");
        }                        
    }
    
    	/**
    	* Nome: listenerExcluirCotacaoGarantia
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
    public void listenerExcluirCotacaoGarantia(AjaxBehaviorEvent e) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerExcluirCotacao <<<<<<<<<<<");

            // valida se foi selecionado um item na lista
            if (getViewHelper().getItemSelecListaCotacoes() == null) {
                NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            }

            // Remove o item selecionado.
            ListaResponsavelDespesaVO itemCotacao = getTradeFinNegocVO().getListaRespDesp().get(getViewHelper().getItemSelecListaCotacoes());
            getTradeFinNegocVO().getListaRespDesp().remove(itemCotacao);


        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerExcluirCotacao <<<<<<<<<<<");
        }
    }
    
    /**
     * Nome: listenerAlterarCotacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerAlterarCotacao(AjaxBehaviorEvent e) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerAlterarCotacao <<<<<<<<<<<");

            // valida se foi selecionado um item na lista
            if(getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA) || getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                
                if (getViewHelper().getItemSelecListaCotacoes() == null) {
                    BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                    return;
                }
                
                if (SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio())) {
                    BradescoFacesUtils.addInfoModalMessage("O campo \"Banco Correspondente\" deve ser preenchido!", false);
                    return;
                } else {
                	getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbiofndng(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getCbanqrcmbio());
                	getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbiofndng(trdFinNegPrecificacaoVO.getUnidadeExternaVO().getIbanqrcmbio());
                }
                
                if (getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                	 if (!SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getCbanqrcmbio())) {
                     	getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbioaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getCbanqrcmbio());
                     	getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbioaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getIbanqrcmbio());
                     }
                     
                     getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbioaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getCbanqrcmbio());
             		getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbioaviso(trdFinNegPrecificacaoVO.getBancoAvisadorVO().getIbanqrcmbio());
                }            
                
                if (SiteUtil.isEmptyOrNull(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getCbanqrcmbio())) {
                    BradescoFacesUtils.addInfoModalMessage("O campo \"Banco Confirmador\" deve ser preenchido!", false);
                    return;
                } else {
                	getTradeFinNegocVO().getCotacaoFundingVO().setCbanqrcmbiorcdor(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getCbanqrcmbio());
                	getTradeFinNegocVO().getCotacaoFundingVO().setNbanqrcmbiorcdor(trdFinNegPrecificacaoVO.getBancoReembolsadorVO().getIbanqrcmbio());
                }
                
                if (getViewHelper().getDataValidadeCotacao().equals(null)) {
                    BradescoFacesUtils.addInfoModalMessage("O campo \"Validade da Cotação\" deve ser preenchido!", false);
                    return;
                } else {
                	getTradeFinNegocVO().getCotacaoFundingVO().setDlimfndngcmbio(SiteUtil.dateToString(
                                    getViewHelper().getDataValidadeCotacao(), "dd/MM/yyyy"));
                }
                
                //getTradeFinNegocVO().getCotacaoFundingVO().setCfndng(1L);
                getTradeFinNegocVO().getCotacaoFundingVO().setDcotacfndngcmbio(SiteUtil.dateToString(new Date(), "dd/MM/yyyy"));
                getTradeFinNegocVO().getCotacaoFundingVO().setCindcdfndngutlzd("S");
                getTradeFinNegocVO().getCotacaoFundingVO().setNindcdfndngutlzd("Em Negociação");
                
                /** Indica usuário que realizou a ação **/
                getTradeFinNegocVO().getCotacaoFundingVO().setCusuariosess(getTradeFinNegocVO().getCusuariosess());
                getTradeFinNegocVO().getCotacaoFundingVO().setNusuariosess(getTradeFinNegocVO().getNusuariosess());
                
                
                ListaCotacoesExternasVO itemCotacao = getTradeFinNegocVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes());            
                getTradeFinNegocVO().getCotacaoFundingVO().setListaDespesas(itemCotacao.getListaDespesas());
                            
                // Substitui o item selecionado.
                getTradeFinNegocVO().getListaCotacoes().set(getViewHelper().getItemSelecListaCotacoes(), getTradeFinNegocVO().getCotacaoFundingVO());                    
                
                getTradeFinNegocVO().setCotacaoFundingVO(new ListaCotacoesExternasVO());
                setBancoReembolsadorVO(new UnidadeExternaVO());
                setBancoAvisadorVO(new UnidadeExternaVO());
                
                complListaAlteracaoCotacao();
            }

        
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerAlterarCotacao <<<<<<<<<<<");
        }                       
    }
    
    	/**
    	* Nome: listenerAlterarCotacaoGarantia
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
    public void listenerAlterarCotacaoGarantia(AjaxBehaviorEvent e) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerAlterarRespDesp <<<<<<<<<<<");

            // valida se foi selecionado um item na lista
            if (getViewHelper().getItemSelecListaCotacoes() == null) {
                BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            }

            if(!SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbanqrcmbio())
                            && !SiteUtil.isEmptyOrNull(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio())
                            && getViewHelper().getFuncaoSelecionada().intValue() > 0){

                ListaResponsavelDespesaVO itemCotacao = getTradeFinNegocVO().getListaRespDesp().get(getViewHelper().getItemSelecListaCotacoes());            

                itemCotacao.setCbanqrcmbio(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCbanqrcmbio());
                itemCotacao.setNbanqrcmbio(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIbanqrcmbio());

                if(getViewHelper().getFuncaoSelecionada().equals(Numeros.UM)){
                    itemCotacao.setCbanqrcmbiofndg(getViewHelper().getFuncaoSelecionada());
                    itemCotacao.setNfuncresp("Emissor");

                }else if(getViewHelper().getFuncaoSelecionada().equals(Numeros.DOIS)){
                    itemCotacao.setCbanqrcmbiofndg(getViewHelper().getFuncaoSelecionada());
                    itemCotacao.setNfuncresp("Confirmador");

                }else if(getViewHelper().getFuncaoSelecionada().equals(Numeros.TRES)){
                    itemCotacao.setCbanqrcmbiofndg(getViewHelper().getFuncaoSelecionada());
                    itemCotacao.setNfuncresp("Avisador");
                }

                itemCotacao.setCmunintlcmbio(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCmunintlcmbio());
                itemCotacao.setImunintlcmbio(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getImunintlcmbio());
                itemCotacao.setIpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getIpais());
                itemCotacao.setCpais(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCpais());
                itemCotacao.setCidbanqrswift(getTrdFinNegPrecificacaoVO().getUnidadeExternaVO().getCidbanqrswift());
                itemCotacao.setCindcdfndgttlzd("S");
                itemCotacao.setNindcdfndgttlzd("Em Negociação");

                // Substitui o item selecionado. 
                getTradeFinNegocVO().getListaRespDesp().set(getViewHelper().getItemSelecListaCotacoes(), itemCotacao);                    
                complListaAlteracaoCotacao();

                getViewHelper().setItemSelecListaRespDesp(null);
            }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerAlterarRespDesp <<<<<<<<<<<");
        }     
    }

    	/**
    	* Nome: complListaAlteracaoCotacao
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
    public void complListaAlteracaoCotacao() {
        
        setUnidadeExternaVO(new UnidadeExternaVO());
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, +2);            
        getViewHelper().setDataValidadeCotacao(calendar.getTime());
        
    }
        
    
    /**
     * Nome: listenerCarregarListaDespesasFunding
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerCarregarListaDespesasFunding(AjaxBehaviorEvent e) {
        
        getTradeFinNegocVO().setListaDespesas(getTradeFinNegocVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getListaDespesas());

    }    
    
    
  	/**
	* Nome: listenerCarregarListaDespesasGarantia
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
    public void listenerCarregarListaDespesasGarantia(AjaxBehaviorEvent e) {
      
      getTradeFinNegocVO().setListaDespesas(getTradeFinNegocVO().getListaRespDesp().get(getViewHelper().getItemSelecListaCotacoes()).getListaDespesas());
           
    }    
    
    

    /**
     * Nome: listenerIncluirDespesa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerIncluirDespesa(AjaxBehaviorEvent e) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerIncluirDespesa <<<<<<<<<<<");
            
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
            
            getTradeFinNegocVO().getDespesaVO().setNindcdeconmmoeda(selectItemBean.getSelectItemLabelByValue(getTradeFinNegocVO().getDespesaVO().getCindcdeconmmoeda(), selectItemBean.getMoeda()));
            
            getTradeFinNegocVO().getDespesaVO().setNformacobrdesp(selectItemBean.getSelectItemLabelByValue(getTradeFinNegocVO().getDespesaVO().getCformacobrdesp(), selectItemBean.getComboFormaPagamento()));

            getTradeFinNegocVO().getDespesaVO().setNfluxoperdccmbio(selectItemBean.getSelectItemLabelByValue(getTradeFinNegocVO().getDespesaVO().getCfluxoperdccmbio(), getViewHelper().getComboPeriodicidade()));
            
            getTradeFinNegocVO().getDespesaVO().setNbasebletonegoc(selectItemBean.getSelectItemLabelByValue(getTradeFinNegocVO().getDespesaVO().getCbasebletonegoc(), getViewHelper().getComboPeriodoDaTaxa()));
            
            atualizaContDivInterna();
            
            getTradeFinNegocVO().getListaDespesas().add(getTradeFinNegocVO().getDespesaVO());
           
            if(getTradeFinNegocVO().getProduto().isGarantia()) {
                getTradeFinNegocVO().getListaRespDesp().get(getViewHelper().getItemSelecListaCotacoes()).setListaDespesas(getTradeFinNegocVO().getListaDespesas());
              
            }else {
                getTradeFinNegocVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).setListaDespesas(getTradeFinNegocVO().getListaDespesas());
            }
           
            getTradeFinNegocVO().setDespesaVO(new ListaDespesasVO());
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerIncluirDespesa <<<<<<<<<<<");
        }        
    }
    
    /**
     * Nome: listenerExcluirDespesa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerExcluirDespesa(AjaxBehaviorEvent e) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerExcluirDespesa <<<<<<<<<<<");

            // valida se foi selecionado um item na lista
            if (getViewHelper().getItemSelecListaDespesas() == null) {
                NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            }
            
            atualizaContDivInterna();
            
            ListaDespesasVO itemDespesa = getTradeFinNegocVO().getListaDespesas().get(getViewHelper().getItemSelecListaDespesas());
            
            // Remove o item selecionado.
            getTradeFinNegocVO().getListaDespesas().remove(itemDespesa);
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerExcluirDespesa <<<<<<<<<<<");
        }        
    }
    
    /**
     * Nome: listenerAlterarDespesa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerAlterarDespesa(AjaxBehaviorEvent e) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerAlterarDespesa <<<<<<<<<<<");

            // valida se foi selecionado um item na lista
            if (getViewHelper().getItemSelecListaDespesas() == null) {
                BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            }
            
            if (getTradeFinNegocVO().getDespesaVO().getCtpodespcmbio().equals(Numeros.ZERO)) {
                BradescoFacesUtils.addInfoModalMessage("O campo \"Tipo de Despesa\" deve ser preenchido!", false);
                return;
            } else {
            	getTradeFinNegocVO().getDespesaVO().setNtpodespcmbio(selectItemBean.getSelectItemLabelByValue(
            			getTradeFinNegocVO().getDespesaVO().getCtpodespcmbio(), getViewHelper().getComboTipoDespesas()));
            }
                        
            if (getTradeFinNegocVO().getDespesaVO().getCidtfdrespdesp().equals(Numeros.ZERO)) {
                BradescoFacesUtils.addInfoModalMessage("O campo \"Por Conta\" deve ser preenchido!", false);
                return;
            } else {
            	getTradeFinNegocVO().getDespesaVO().setNidtfdrespdesp(selectItemBean.getSelectItemLabelByValue(
            			getTradeFinNegocVO().getDespesaVO().getCidtfdrespdesp(), getViewHelper().getComboPorConta()));            
            }
            
            getTradeFinNegocVO().getDespesaVO().setNindcdeconmmoeda(selectItemBean.getSelectItemLabelByValue(
            		getTradeFinNegocVO().getDespesaVO().getCindcdeconmmoeda(), getViewHelper().getComboMoeda()));
            
            getTradeFinNegocVO().getDespesaVO().setNformacobrdesp(selectItemBean.getSelectItemLabelByValue(
            		getTradeFinNegocVO().getDespesaVO().getCformacobrdesp(), getViewHelper().getComboFormaPagamento()));

            getTradeFinNegocVO().getDespesaVO().setNfluxoperdccmbio(selectItemBean.getSelectItemLabelByValue(
            		getTradeFinNegocVO().getDespesaVO().getCfluxoperdccmbio(), getViewHelper().getComboPeriodicidade()));
            
            getTradeFinNegocVO().getDespesaVO().setNbasebletonegoc(selectItemBean.getSelectItemLabelByValue(
                    getTradeFinNegocVO().getDespesaVO().getCbasebletonegoc(), getViewHelper().getComboPeriodoDaTaxa()));
            
            atualizaContDivInterna();
            
            // Substitui o item selecionado.
            getTradeFinNegocVO().getListaDespesas().set(getViewHelper().getItemSelecListaDespesas(), getTradeFinNegocVO().getDespesaVO());                    
            getTradeFinNegocVO().setDespesaVO(new ListaDespesasVO());
        
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerAlterarDespesa <<<<<<<<<<<");
        }                        
    }
    
    /**
     * Nome: listenerTratarIndicadorEconomico
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 31/05/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerTratarIndicadorEconomico(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerTratarIndicadorEconomico <<<<<<<<<<<");
    		
    		if (getViewHelper().isCheckPercCDI() == Boolean.FALSE
    						&& getViewHelper().isCheckMaisCDI() == Boolean.FALSE
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
    		} 

    		
    		if (getViewHelper().isCheckMaisCDI() == Boolean.TRUE) {
    			
    			getViewHelper().setDisabledCheckPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledCheckMaisCDI(Boolean.FALSE);
    			getViewHelper().setDisabledCheckTaxaPre(Boolean.TRUE);            
    			
    			getViewHelper().setDisabledPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledMaisCDI(Boolean.FALSE);
    			getViewHelper().setDisabledTaxaPre(Boolean.TRUE);
    		}

    		
    		if (getViewHelper().isCheckTaxaPre() == Boolean.TRUE) {
    			
    			getViewHelper().setDisabledCheckPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledCheckMaisCDI(Boolean.TRUE);
    			getViewHelper().setDisabledCheckTaxaPre(Boolean.FALSE);
    			
    			getViewHelper().setDisabledPercCDI(Boolean.TRUE);
    			getViewHelper().setDisabledMaisCDI(Boolean.TRUE);
    			getViewHelper().setDisabledTaxaPre(Boolean.FALSE);
    		} 


    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerTratarIndicadorEconomico <<<<<<<<<<<");
    	}


    }
    
    /**
     * 
     * Nome: numerarCotacoes
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 09/08/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    private void numerarCotacoesDespesas() {
    	
    	if(getTradeFinNegocVO().getListaCotacoes() != null){
    		long numCotacao = 1;
    		
    		for (ListaCotacoesExternasVO cotacoesList : getTradeFinNegocVO().getListaCotacoes()) {
    			cotacoesList.setCfndng(numCotacao++);
    			long numDesp = 1;
    			
    			if(cotacoesList.getListaDespesas() != null){
    				for (ListaDespesasVO despesasList : cotacoesList.getListaDespesas()) {
    					despesasList.setNdespbletocmbio(numDesp++);
    				}
    			}
    			
    		}
    	}
    }
    
    /**
     * Nome: getItensRadioListaCotacoes
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/07/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaCotacoes() {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.getItensRadioListaCotacoes <<<<<<<<<<<");

            List<SelectItem> list = new ArrayList<SelectItem>();
            
            // Percorre todos os itens da lista afim de criar os respectivos radio
            // buttons
            for (int index = 0; index < getTradeFinNegocVO().getListaCotacoes().size(); index++) {
                list.add(new SelectItem(index, "", ""));
            }
            
            return list;
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.getItensRadioListaCotacoes <<<<<<<<<<<");
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
     *      Registro de Manutenção: 21/07/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getItensRadioListaDespesas() {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.getItensRadioListaDespesas <<<<<<<<<<<");

            List<SelectItem> list = new ArrayList<SelectItem>();
            
            // Percorre todos os itens da lista afim de criar os respectivos radio
            // buttons
            for (int index = 0; index < getTradeFinNegocVO().getListaDespesas().size(); index++) {
                list.add(new SelectItem(index, "", ""));
            }
            
            return list;
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.getItensRadioListaDespesas <<<<<<<<<<<");
        }
        
    }   
    
    
  public List<SelectItem> getItensRadioListaRespDesp() {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.getItensRadioListaRespDesp <<<<<<<<<<<");

            List<SelectItem> list = new ArrayList<SelectItem>();
            
            // Percorre todos os itens da lista afim de criar os respectivos radio
            // buttons
            for (int index = 0; index < getTradeFinNegocVO().getListaRespDesp().size(); index++) {
                list.add(new SelectItem(index, "", ""));
            }
            
            return list;
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.getItensRadioListaRespDesp <<<<<<<<<<<");
        }
        
    }   
    
  public void listenerTrocaPeriodicidadeComissaoExterna(AjaxBehaviorEvent e) {
	  try{
		  BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerTrocaPeriodicidadeComissaoExterna <<<<<<<<<<<");
		  tratarPeriodo(getViewHelper().getCfluxoperdccmbioRed());

	  }finally{
		  BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerTrocaPeriodicidadeComissaoExterna <<<<<<<<<<<");
	  }

  }
  
  /**
   * 
  	* Nome: tratarPeriodo
  	* 
  	* Propósito: 
 * @param integer 
  	*
  	* @param : 
  	* @return : 
  	* @throws :
  	* @exception : 
  	* @see : Referencias externas.	
  	*
  	* Registro  de Manutenção: 21/09/2016
  	*        - Autor: BRQ
  	*        - Responsavel: Equipe Web
  	*        - Adequação ao padrão hexavision.
   */
  protected void tratarPeriodo(Integer integer){
	  getViewHelper().setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.COMISSAO_EXTERNA.getCodigo(), 0));
      if(integer.equals(Numeros.DOZE)){
          for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
              if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.UM)){
                  //Remover a opção 'Antecipado' no combo quando for produto ECA
                  getViewHelper().getComboMomento().remove(i);
                  break;
              }
          }
      } else if (integer.equals(Numeros.CATORZE)) {
          for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
              if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.DOIS)){
                  //Remover a opção 'Postecipado' no combo quando for produto ECA
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
					//Remover a opção 'Antecipado' no combo quando for produto ECA
					getViewHelper().getComboMomento().remove(i);
					break;
				}
			}
		} else if (getViewHelper().getCfluxoperdccmbio().equals(Numeros.CATORZE)) {
			for(int i=0; i < getViewHelper().getComboMomento().size(); i++) {
				if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.DOIS)) {
					//Remover a opção 'Postecipado' no combo quando for produto ECA
					getViewHelper().getComboMomento().remove(i);
					break;
				}
			}
		}
	}
  
  
    /**
     * 
    	* Nome: atualizaContDivInterna
    	* 
    	* Propósito: Qualquer alteração nas despesas deve-se atualizar com o usuário que esta realizando a ação.
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 03/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void atualizaContDivInterna(){
        //Atualiza a lista de Despesa com o usuário que realiza a inclusao/alteracao
        if(getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) || getTradeFinNegocVO().getProduto().equals(EnumProduto.FINIMP_ECA)) {
            
            if(getTradeFinNegocVO().getListaCotacoes() != null && getTradeFinNegocVO().getListaCotacoes().size() > 0){

                ListaCotacoesExternasVO itemCotacao = getTradeFinNegocVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes());
                itemCotacao.setCusuariosess(getTradeFinNegocVO().getCusuariosess());

            }
        }
    }

	public Date getLimiteCtc() {
		return limiteCtc;
	}

	public void setLimiteCtc(Date limiteCtc) {
		this.limiteCtc = limiteCtc;
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

	public UnidadeExternaVO getBancoAvisadorVO() {
		return bancoAvisadorVO;
	}

	public void setBancoAvisadorVO(UnidadeExternaVO bancoAvisadorVO) {
		this.bancoAvisadorVO = bancoAvisadorVO;
	}
    
    
	 /**
     * 
        * Nome: listenerCarregarListaDespesaResp
        * 
        * Propósito: Alteracao do Garantia, carrega a lista de despesa do Garantia
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
    public void listenerCarregarListaDespesaResp(AjaxBehaviorEvent e){
        
        getTradeFinNegocVO().setListaDespesas(tradeFinanceBean.getTradeFinanceVO().getListaDespesaGaran().get(getViewHelper().getItemSelecListaRespDesp()).getListaDespesas());

    }
    
    
    
    /**
     * Tela de alteracao PROEX criado por derick
     * FIM
     */

    
    
    

}