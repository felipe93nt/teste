package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.fechar;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.InformacaoPilotoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.VincularOperacaoLcVO;
import br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean.LimitesModalVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitBaseBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.vincularOperacaoLc.VincularOperacaoLcBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * 
 * Nome: TradeFinMonitBaixarBean.java
 * 
 * Propósito:
 * <p>
 * Bean para funcionalidade da tela Baixar Trade Finance
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */

@Named("tradeFinMonitFecharBean")
@SessionScoped
public class TradeFinMonitFecharBean extends TradeFinMonitBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    private LimitesModalVO limiteVO = new LimitesModalVO();

    @Inject
    @Named("vincularOperacaoLcBean")
    protected VincularOperacaoLcBean vincularOperacaoLcBean;
    
    /**
     * Construtor
     * 
     * @param
     */
    public TradeFinMonitFecharBean() {
        super();
    }
    
    @Override
    public String iniciar() {
    
        // Recarrega página se não for um postback ou se foi marcado para
        // recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);
            
            setDesenquadradas(new DesenquadramentoVO(tradeFinanceBean.getTradeFinanceVO()));
        }
        
        return null;
    }

    /**
     * 
     * Nome: validarForm
     * 
     * Propósito: Ação que executa a validação do formulário e abre o modal de confirmação das telas de inclusão e
     * alteração
     * 
     * @return : Navegação por mensagem
     * 
     * @throws : NpccServiceBusinessException
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void validarForm(ActionEvent ae) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.validarForm <<<<<<<<<<<");
    		
    		Boolean isValid = Boolean.TRUE;
    		
    		String respValidaDataAprov = "";
    		
    		
    		// Chama fluxo de validação da data da cotação para o Finimp Eca, Garantia e Lc
            if(tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia()
                            || tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.FINIMP_ECA)
                            || tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                
            	respValidaDataAprov = tradeFinanceMonitService.validaDataAprovRespDesp(getTradeFinanceBean().getCotacoesList(),
                               getTradeFinanceBean().getResponsavelDespList(), getTradeFinanceBean().getTradeFinanceVO());
                  
            }
    		
    		// valida campos obrigatórios
    		if (SiteUtil.validarCampos("formTradeFinMonitDet")) {

    			isValid = Boolean.FALSE;
    		}
    		  		
    		// Só pode Fechar se a cotação for Firme
    		if (!tradeFinanceBean.getTradeFinanceVO().getCtponegoccmbio().equals(Numeros.NUM2)) {
    		    NpcFacesUtils.addInfoModalMessage("Não é possível fechar cotação do tipo Indicativa.", false);
                isValid = Boolean.FALSE;
    		}
    		
			if (respValidaDataAprov.equals("3")) {
				viewHelper.setRenderModalFecharCotarCustorExterno(Boolean.TRUE);
			} else {
				
	    		Date validadeCotacao = SiteUtil.dataMainframeToWeb(getTradeFinanceBean().getTradeFinanceVO().getDvalddnegoccmbio().replace("/", "."));
	    		if(SiteUtil.comparaDatas(validadeCotacao, new Date()) < 0) {
	    			NpcFacesUtils.addInfoModalMessage("Data Limite da Cotação expirada.", false);
	    			isValid = Boolean.FALSE;
	    		}
				
				viewHelper.setRenderFechar(isValid);
			}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.validarForm <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: actionVoltar
     * 
     * Propósito: Ação exucuta pelo botão voltar das telas de inclur, alterar e detalhar
     *
     * @return : String de navegação
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionVoltar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.actionVoltar <<<<<<<<<<<");
    		setIniciarPagina(true);
    		return "tradeFinMonitList";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.actionVoltar <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: actionConfirmar
     * 
     * Propósito: Ação exucuta pelo botão confirmar das telas de inclusão e alteração
     *
     * @return : Navegação por mensagem
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionConfirmar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.actionConfirmar <<<<<<<<<<<");
    		
    		viewHelper.setRenderFechar(Boolean.FALSE);
    		situacaoPiloto();
  
    		/**
    		 * Condição para abrir modal de desenquadradas:
    		 *    Indicador de desenquadramento seja SIM 'S'
    		 *    Se o cliente está ativo no piloto
    		 */
    		if (!tradeFinanceBean.getTradeFinanceVO().getInddqmto().equals("S") 
    		        || !openModalDesenquadradas(0)) {
  
    		    continuarConfirmar();
    		}
    		
    		
    	}finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.actionConfirmar <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
     * Nome: actionSim
     * 
     * Propósito: Ação exucuta pelo botão confirmar das telas de inclusão e alteração
     *
     * @return : Navegação por mensagem
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionSim() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.actionSim <<<<<<<<<<<");
    		
    		viewHelper.setRenderModalFecharCotarCustorExterno(Boolean.FALSE); 	
    		
    		String result = SiteUtil.STRING_EMPTY;
       
    		result = tradeFinanceMonitService.confirmarPerda(tradeFinanceBean.getTradeFinanceVO(), 34);   

    		// Redireciona para a tela de consulta (Menu Dinâmico) 
            BradescoFacesUtils.addInfoModalMessage(result, 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);
    	

    		
    	}finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.actionSim <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
     * Nome: actionNao
     * 
     * Propósito: Ação exucuta pelo botão confirmar das telas de inclusão e alteração
     *
     * @return : Navegação por mensagem
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionNao() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.actionSim <<<<<<<<<<<");
    		
    		viewHelper.setRenderModalFecharCotarCustorExterno(Boolean.FALSE);  
    		
    		// Redireciona para a tela de consulta (Menu Dinâmico) 
            BradescoFacesUtils.addInfoModalMessage(null, 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);
    		
    	}finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.actionSim <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
     * Nome: continuarConfirmar
     * 
     * Propósito: Continuar botão confirmar
     *
     * @return : Navegação por mensagem
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void continuarConfirmar() {
        
        String result = SiteUtil.STRING_EMPTY;
        
        if (tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPos() || tradeFinanceBean.getTradeFinanceVO().getProduto().isBndesPre()
                        || tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia()
                        || tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.FINIMP_ECA)
                        || tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
                        || tradeFinanceBean.getTradeFinanceVO().getProduto().isNce()
                        || tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.PROEX)) {
            
            result = tradeFinanceMonitService.confirmarPerda(tradeFinanceBean.getTradeFinanceVO(), 2);
        } else {
            result = tradeFinanceMonitService.confirmarPerda(tradeFinanceBean.getTradeFinanceVO(), 33);
        }
        
        if(!tradeFinanceBean.getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)){

         // Redireciona para a tela de consulta (Menu Dinâmico) 
            BradescoFacesUtils.addInfoModalMessage(result, 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);
        	
        } else {
            
            openModalConfirmarLC(result);
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
    public void openModalConfirmarLC(String message) {
        
        tradeFinanceBean.setVincularOperacaoLcVO(new VincularOperacaoLcVO());
        tradeFinanceBean.getVincularOperacaoLcVO().setNbletonegoccmbio(tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());
        tradeFinanceBean.getVincularOperacaoLcVO().setCsitbletocmbio(Numeros.NOVE);
        tradeFinanceBean.getVincularOperacaoLcVO().setCprodtservc(tradeFinanceBean.getTradeFinanceVO().getCprodtservc());
        
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
            BradescoFacesUtils.addInfoModalMessage(message, 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);
        }
        
        else {
            
            if (tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.UM) {
                vincularOperacaoLcBean.getViewHelper().setPerguntaOperacao("Deseja fechar a operação vinculada?");
            } else {
                vincularOperacaoLcBean.getViewHelper().setPerguntaOperacao("Deseja incluir uma operação vinculada?");
            }
            
            vincularOperacaoLcBean.setVincularOperacaoLcVO(tradeFinanceBean.getVincularOperacaoLcVO());
            vincularOperacaoLcBean.getVincularOperacaoLcVO().setOrigemAlteracao(true);
            vincularOperacaoLcBean.getViewHelper().setMesagemConfirmacao(message);
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
            
            tradeFinanceBean.obterDadosBasicos(dadosAlterar, ConstantesTradeFinance.FUNC_CONSULTAR_FECHADAS);
            tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
            
            // FINIMP DIRETO (1644)
            if (dadosAlterar.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
                redirectTo = "finimpDireto/finimpDiretoFch.xhtml";
            } 
            // FINIMP INDIRETO (2692)
            else if (dadosAlterar.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
                redirectTo = "finimpIndireto/finimpIndiretoFch.xhtml";
            }
            // FINIMP ECA (1715)
            if (dadosAlterar.getProduto().equals(EnumProduto.FINIMP_ECA)) {
                redirectTo = "finimpEca/finimpEcaFch.xhtml";
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
            setIniciarPagina(true);
            
            BradescoFacesUtils.responseForward(tradeFinMonitBean.retomarPesquisaMonit());
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionFecharModalLc <<<<<<<<<<<");
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
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void tratarListaLimite(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.tratarListaLimite <<<<<<<<<<<");
    		
    		limitesModalBean.getViewHelper().setCodItemSelecionadoLimite(null);
    		limitesModalBean.getViewHelper().setCodItemSelecionadoProposta(null);
    		
    		// Abre modal de limites se produto e cliente estiver selecionado
    		if (!SiteUtil.isEmptyOrNull(tradeFinanceBean.getTradeFinanceVO().getCprodtservc())
    						&& !SiteUtil.isEmptyOrNull(tradeFinanceBean.getTradeFinanceVO().getCunicclicmbio())) {
    			limitesModalBean.getViewHelper().setIsConfirmaModallimite(Boolean.FALSE);
    			limitesModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalLimites");
    			
    			getLimiteVO().setProduto(tradeFinanceBean.getTradeFinanceVO().getCprodtservc());
    			getLimiteVO().setCunicpssoacmbio(tradeFinanceBean.getTradeFinanceVO().getCunicclicmbio());
    			
    			limitesModalBean.getViewHelper().setTratarSelecionarProposta(Boolean.TRUE);
    			limitesModalBean.setLimiteVO(limiteVO);
    			limitesModalBean.getViewHelper().setIsConfirmaModallimite(Boolean.FALSE);
    			limitesModalBean.openModal();
    			
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.tratarListaLimite <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: closeModalLimites
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalLimites(ActionEvent event) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.closeModalLimites <<<<<<<<<<<");
    		
    		if(limitesModalBean.getViewHelper().getIsConfirmaModallimite() == Boolean.TRUE){
                
                tradeFinanceBean.getTradeFinanceVO().setMoedalimite(SiteUtil.getString(getLimiteVO().getDescrmoeda()));
                tradeFinanceBean.getTradeFinanceVO().setSimbleconmlim(getLimiteVO().getDescrmoeda());
                tradeFinanceBean.getTradeFinanceVO().setCeconmmoedalim(getLimiteVO().getCindcdeconmmoeda());
                tradeFinanceBean.getTradeFinanceVO().setNseqcontrlim(getLimiteVO().getNcontrlim());
                tradeFinanceBean.getTradeFinanceVO().setNppstapontucmbio(getLimiteVO().getNseqcontrppl());
                tradeFinanceBean.getComissaoInternaVO().setVtxspreadaprov(getLimiteVO().getPspreadprodt());
                
                calcularValorLimite();

    		} 
          
    		limitesModalBean.closeModal(event);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.closeModalLimites <<<<<<<<<<<");
    	}

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
    private void calcularValorLimite() {
        tradeFinanceBean.getTradeFinanceVO().setCeconmmoedalim(getLimiteVO().getCindcdeconmmoeda());

        tradeFinanceBean.getTradeFinanceVO().setNppstapontucmbio(0L);
        if (getLimiteVO().getNseqcontrppl() != null && 
                        getLimiteVO().getNseqcontrppl() > Numeros.NUM0_LONG) {

            tradeFinanceBean.getTradeFinanceVO().setNppstapontucmbio(getLimiteVO().getNseqcontrppl());
        }

        tradeFinanceBean.getTradeFinanceVO().setNseqcontrlim(0L);
        if (getLimiteVO().getNcontrlim() != null &&
                        getLimiteVO().getNcontrlim() > Numeros.NUM0_LONG) {

            tradeFinanceBean.getTradeFinanceVO().setNseqcontrlim(getLimiteVO().getNcontrlim());
        }

        tradeFinanceBean.getTradeFinanceVO().setVmoedalimgerc("0,00");

        if (SiteUtil.isEmptyOrNull(tradeFinanceBean.getTradeFinanceVO().getCindcdeconmmoeda())
                || SiteUtil.isEmptyOrNull(tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg())
                || SiteUtil.isValueZero(tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg())
                || SiteUtil.isEmptyOrNull(tradeFinanceBean.getTradeFinanceVO().getCeconmmoedalim())) {
            return;
        }
        
        TrdFinNegocInclVO negocInclVO = new TrdFinNegocInclVO();
        negocInclVO.setDfchtobletocmbio(SiteUtil.dataWebToMainframe(new Date()));
        negocInclVO.setCindcdeconmmoeda(tradeFinanceBean.getTradeFinanceVO().getCindcdeconmmoeda());
        negocInclVO.setVnegocmoedaestrg(tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg());
        negocInclVO.setCeconmmoedalim(tradeFinanceBean.getTradeFinanceVO().getCeconmmoedalim());

        tradeFinanceBean.getTradeFinanceVO().setVmoedalimgerc(tradeFinanceNegociacaoService.getConverterValorParaMoedaLimite(negocInclVO));
    }
    
    
    /**
     * 
     * Nome: actionFechar
     * 
     * Propósito: Ação do botão fechar do modal das telas de inclusão e alteração
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionFechar(ActionEvent ae) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitFecharBean.actionFechar <<<<<<<<<<<");
    		
    		viewHelper.setRenderFechar(Boolean.FALSE);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitFecharBean.actionFechar <<<<<<<<<<<");
    	}
    	
    }
    
    public void situacaoPiloto() {

        InformacaoPilotoVO informacaoPilotoVO = new InformacaoPilotoVO();
        informacaoPilotoVO = tradeFinanceNegociacaoService.consultarSituacaoPiloto(tradeFinanceBean.getTradeFinanceVO().getCunicclicmbio());

        // Caso o piloto está ativo e o cliente nao opera com limite
        // Não irá liberar para operar com limite
        if(informacaoPilotoVO.isPilotoAtivo()
                        && !informacaoPilotoVO.isClientePiloto()) {
            tradeFinanceBean.getViewHelper().setOperaComLimite(false);
        } else {
            tradeFinanceBean.getViewHelper().setOperaComLimite(true);
        }
    }
    
    /**
     * @return o valor do limiteVO
     */
    public LimitesModalVO getLimiteVO() {
        return limiteVO;
    }

    /**
     * @param limiteVO seta o novo valor para o campo limiteVO
     */
    public void setLimiteVO(LimitesModalVO limiteVO) {
        this.limiteVO = limiteVO;
    }

}
