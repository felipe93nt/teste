package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.aditar;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.ITradeFinanceMonitService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DadosGerarBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoAditarVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ObservacoesCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegTarifaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoBase;
import br.com.bradesco.web.npcc_trade.view.bean.global.operacaoAditarModal.OperacaoAditarModalBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
  * Nome: TradeFinAditarBean.java
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
  * Registro  de Manutenção: 01/07/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@Named ("tradeFinAditarBean")
@SessionScoped
public class TradeFinAditarBean extends TradeFinanceNegociacaoBase implements Serializable{
	
	@Inject
    @Named("tradeFinanceMonitService")
    private ITradeFinanceMonitService tradeFinanceMonitService;
	
    @Inject
	@Named("operacaoAditarModalBean")
	private OperacaoAditarModalBean operacaoAditarModalBean;
		
    private List<OperacaoAditarVO> listOperacaoAditarVO = new ArrayList<OperacaoAditarVO>();
    
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 826133182627728555L;
	
	private String itemSelecLista = null;

    private Boolean gerarBoletoAlt = false;
	
    /** Controle dos modais para evento Confirmar e Cotar Custo Externo */
    private int tipoAcessoAlterarEvento = Numeros.ZERO;
    
	/**
	* Nome: iniciar
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
	public String iniciar(){
		
		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.iniciar <<<<<<<<<<<");
			
			
			if (carregarDadosViaConsulta(EnumTradeFinance.FUNCAO_TIPO_ADITAR.getCodigo()) == true) {
    			
			    // Desabilita botão fechar em caso de alteração para situação devolvida
    			tradeFinNegocVO.setCsitbletocmbio(EnumTradeFinance.STATUS_EM_NEGOCIACAO.getCodigo());
    			
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
                
                // NCE
                if(tradeFinNegocVO.getProduto().isNce()){             	
                	

            		getViewHelper().setCheckPercCDI(Boolean.FALSE);
            		tradeFinNegocVO.setPtxcdifinan(SiteUtil.formatarValorWeb(Numeros.ZERO));
            		getViewHelper().setCheckMaisCDI(Boolean.FALSE);
            		tradeFinNegocVO.setPcdimaiscmbio(SiteUtil.formatarValorWeb(Numeros.ZERO));
            		getViewHelper().setCheckTaxaPre(Boolean.FALSE);
            		tradeFinNegocVO.setPfixajurocmbio(SiteUtil.formatarValorWeb(Numeros.ZERO));               	
                	
                	tradeFinNegocVO.setCindcdlastragric(this.getTradeFinanceBean().getTradeFinanceVO().getCindcdlastragric());
                }
                
                tradeFinNegocVO.setVnegocmoedaestrg("");
                tradeFinNegocVO.setCmodcontrcmbio(Numeros.ZERO);
                getViewHelper().setDatePrevDesembolso(null);
                tradeFinNegocVO.setVtxmoracmbio("1,00000");
                tradeFinNegocVO.setVmultanegoccmbio("2,00000");
                setListOperacaoAditarVO(new ArrayList<OperacaoAditarVO>());
        		setItemListaFluxoPgto(new TrdFinNegFluxoPagtoVO());
        		tradeFinNegocVO.setListaFluxos(new ArrayList<TrdFinNegFluxoPagtoVO>());
        		tradeFinNegocVO.setListaComissaoExterna(new ComissaoCollection());
        		getViewHelper().setCodTarifa(Numeros.ZERO);
        		tradeFinNegocVO.setListaTarifas(new ArrayList<TrdFinNegTarifaVO>());
        		listenerTratarIndicadorEconomico(null);
        		
        		// Guarda os dados iniciais da alteração para verificar ao final se deve ser realizado o desenquadramento.
                setDesenquadradas(new DesenquadramentoVO(getTradeFinNegocVO(), getViewHelper().getDatePrevDesembolso()));
                
	            // Limpar dados de observações uso interno
                limparObservacoes();
                
                if (getViewHelper().getRenderModalLimite() && getViewHelper().isOperaComLimite() == true) {
                    tratarListaLimite();
                    getViewHelper().setRenderModalLimite(Boolean.FALSE);
                }
                
                getTradeFinNegocVO().setPrazoOperacaoAjustado(true);
                getViewHelper().setAlertMessageConfirmation("");
    		}
    		
            return "";

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.iniciar <<<<<<<<<<<");
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
     * Nome: listenerModalOperacoesAditar
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
    public void listenerModalOperacoesAditar(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.listenerModalOperacoesAditar <<<<<<<<<<<");
    		
    		operacaoAditarModalBean.setListaModalOperacao(new ArrayList<OperacaoAditarVO>());
    		operacaoAditarModalBean.setOperVinculadasVO(new TrdFinNegOperVincVO());
    		operacaoAditarModalBean.getOperVinculadasVO().setDanobase(getTradeFinNegocVO().getDanobase());
    		operacaoAditarModalBean.getOperVinculadasVO().setNumoperacao(getTradeFinNegocVO().getNbletocmbioano());
    		operacaoAditarModalBean.getListaModalOperacao().clear();
    		operacaoAditarModalBean.pesquisarOperacoesVinculadas();
    		operacaoAditarModalBean.setListaOperacao(listOperacaoAditarVO);
    		operacaoAditarModalBean.getViewHelper().setModalId("formTrdFinNegIncl\\:modalOperacoesAditar");
    		operacaoAditarModalBean.getViewHelper().setRenderModalOperacoesAditar(Boolean.TRUE);

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.listenerModalOperacoesAditar <<<<<<<<<<<");
    	}
    	
    }
    
	/**
	 * Nome: closeModalOperacaoAditar
	 * 
	 * Propósito: Metodo para fechar o modal de operações 
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
	public void closeModalOperacaoAditar(ActionEvent event) {

		try {

			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.closeModalOperacaoAditar <<<<<<<<<<<");
			
			List<OperacaoAditarVO> listOperacaoAditarAux = new ArrayList<OperacaoAditarVO>();
			listOperacaoAditarAux.addAll(listOperacaoAditarVO);
			
			listOperacaoAditarVO = new ArrayList<OperacaoAditarVO>();
			
			boolean isEquial = false;
			for (OperacaoAditarVO operacaoAditarVOModal : operacaoAditarModalBean.getListaOperacao()) {
				
				isEquial = false;
				
				for (OperacaoAditarVO operacaoAditarVO : listOperacaoAditarAux) {
					if(operacaoAditarVO.getCcontrfinanexpor().equals(operacaoAditarVOModal.getCcontrfinanexpor())){
						isEquial = true;
						
						listOperacaoAditarVO.add(operacaoAditarVO);
					}
				}
				
				if(!isEquial){
					listOperacaoAditarVO.add(operacaoAditarVOModal);
				}
			}
			
			atualizarValor(null);
			// desabilita modal
			operacaoAditarModalBean.getViewHelper().setRenderModalOperacoesAditar(Boolean.FALSE);

		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.closeModalOperacaoAditar <<<<<<<<<<<");
		}

	}
	
	/**
	 * Nome: closeModalOperacaoAditar
	 * 
	 * Propósito: Metodo para fechar o modal de operações 
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
	public void atualizarValor(AjaxBehaviorEvent e) {
		
		try {
			
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.atualizarValor <<<<<<<<<<<");
			
//			Object index = null;
//
//	        // Verifica se a chamada teve origem na tela ou no bean
//	        if (e != null) {
//	            index = e.getComponent().getAttributes().get("index");
//	        }
	        
	        BigDecimal valorAditamento = new BigDecimal(0);
	        
	        for (OperacaoAditarVO operacao : getListOperacaoAditarVO()) {
	        	
	        	if(!SiteUtil.isEmptyOrNull(operacao.getVladitado())){
	        		
	        		if(SiteUtil.webMoedaToBigDecimal(operacao.getVladitado()).compareTo(SiteUtil.webMoedaToBigDecimal(operacao.getVfinandevedcmbio())) == 1 ){
	        			NpcFacesUtils.addInfoModalMessage("Valor Aditado maior que Saldo Devedor.", false);
	        			operacao.setVladitado("");
	        			return;
	        		}
	        		valorAditamento = valorAditamento.add(SiteUtil.webMoedaToBigDecimal(operacao.getVladitado()));
	        	}
				
			}
	        
	        String retornoValor = valorAditamento.toString();
	        if((new BigDecimal(0)).compareTo(valorAditamento) == -1){
	        	String[] aux = retornoValor.split("\\."); 
	        	if(aux.length > 1){
	        		if(aux[1].length() == 1){
	        			retornoValor += "0";
	        		}
	        	}
	        	
	        }
	        getTradeFinNegocVO().setVnegocmoedaestrg(retornoValor);	
	        getItemListaFluxoPgto().setVprevtdsembcmbio(retornoValor);
		} finally {
			BradescoCommonServiceFactory
			.getLogManager()
			.info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.atualizarValor <<<<<<<<<<<");
		}
		
	}
    
    	/**
    	* Nome: listenerConfirmar
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 01/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerConfirmar(AjaxBehaviorEvent event) {
    	
		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.listenerConfirmar <<<<<<<<<<<");
			
			Integer paramOrigem = SiteUtil.getInt(event.getComponent().getAttributes().get("paramConfirmarAdt"));
    		//setGerarBoletoAlt(paramOrigem == Numeros.DOIS);
			setGerarBoletoAlt(Boolean.FALSE);
			
			if(paramOrigem == EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo()) {
				setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo());
				
			} else {
				setTipoAcessoAlterarEvento(EnumTradeFinance.ACESSO_GERAR_BOLETO.getCodigo());
			}
			
			// valida dados
    		if (confirmaAlteracao()) {
    			
    		    atualizaPrazoOperacaoFluxoPagamento();
    		    
    			// abre moda de confirmação
    			getViewHelper().setRenderModal(Boolean.TRUE);
    		}
    		
		}finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.listenerConfirmar <<<<<<<<<<<");
        }
        
    }
    
    
    
    
    public void continuarConfirmar() {
        
        String msgRetornoOk = null;
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.continuarConfirmar <<<<<<<<<<<");
			
			if (getControleInclusaoAlteracao().equals("DadosBasicos") == true) {
				incluirDadosBasicos();
			}
			
			if (getControleInclusaoAlteracao().equals("FluxoPagtoPrincipalJuros") == true) {
				incluirFluxoPagtoPrincipalJuros();
			}
			
			if (getControleInclusaoAlteracao().equals("ComissaoInterna") == true) {
				incluirFluxoPagtoComissaoInterna();
			}
			
			if (getControleInclusaoAlteracao().equals("ComissaoExterna") == true) {
				incluirFluxoPagtoComissaoExterna();
			}
			
			if (getControleInclusaoAlteracao().equals("GarantVinculoTarifaObs") == true) {
				incluirGarantVinculoTarifaObs();
			}
			
			if (getControleInclusaoAlteracao().equals("ObservacoesCotacao") == true) {
    			incluirObservacoes();
    		}
			
			// Exibe mensagem de retorno do fluxo de validação
            if (!SiteUtil.isEmptyOrNull(viewHelper.getMensagemFluxoValidacao())) {
                getTradeFinNegocVO().setMsgRetorno(viewHelper.getMensagemFluxoValidacao());
                viewHelper.setMensagemFluxoValidacao(null);
            }
			
			msgRetornoOk = getTradeFinNegocVO().getMsgRetorno();
            msgRetornoOk += " <br /> ";
            msgRetornoOk += "  NÚMERO DA COTAÇÃO: " + getTradeFinNegocVO().getDanobase()
                            + getTradeFinNegocVO().getNbletocmbioano();
            
			if(EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo().equals(getTipoAcessoAlterarEvento())) {
				
			 // Redireciona para a tela de consulta (Menu Dinâmico) 
                BradescoFacesUtils.addInfoModalMessage(msgRetornoOk, 
                        "#{tradeFinMonitBean.retomarPesquisaMonit}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
  
			} 
			
			// Botão Gerar Boleto - efetiva a alteração, recarrega a tela e abre o modal do boleto
			else if (EnumTradeFinance.ACESSO_GERAR_BOLETO.getCodigo().equals(getTipoAcessoAlterarEvento())) {
    			
    			TradeFinanceListaVO dadosGerarBoletoListaVO = new TradeFinanceListaVO();
    			dadosGerarBoletoListaVO.setNbletonegoccmbio(SiteUtil.getLong(getTradeFinNegocVO().getNbletonegoccmbio()));
    			dadosGerarBoletoListaVO.setCprodtservc(getTradeFinNegocVO().getCprodtservc());
    			dadosGerarBoletoListaVO.setCsitbletocmbio(getTradeFinNegocVO().getCsitbletocmbio());
    			
    			tradeFinanceBean.obterDadosBasicos(dadosGerarBoletoListaVO, ConstantesTradeFinance.FUNC_CONSULTAR);
    			
    			// informa o bean 'TradeFinanceNegociacaoBean.java' que os dados da tela
    			// de alteração devem ser carregados
    			tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.FALSE);
    			
				// Parametro para abrir o boleto aditado cotação duplicada no monitor.
				DadosGerarBoletoVO dadosGerarBoleto = new DadosGerarBoletoVO();
				dadosGerarBoleto.setGerarBoleto(true);
				dadosGerarBoleto.setDanobase(getTradeFinNegocVO().getDanobase());
				dadosGerarBoleto.setNbletocmbioano(getTradeFinNegocVO().getNbletocmbioano());
				getTradeFinanceBean().getViewHelper().setGerarBoletoDuplicar(dadosGerarBoleto);
    			setGerarBoletoAlt(Boolean.FALSE);
				
    			// Redireciona para a tela de consulta (Menu Dinâmico) 
                BradescoFacesUtils.addInfoModalMessage(msgRetornoOk, 
                        "#{tradeFinMonitBean.retomarPesquisaMonit}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    			
    		}
    		

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.continuarConfirmar <<<<<<<<<<<");
		}
		
    }
    
    public void actionModalConfirmar() {
        
        try{

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.actionModalConfirmar <<<<<<<<<<<");
            
            getViewHelper().setRenderModal(Boolean.FALSE);
            
            /* Condição para abrir modal de desenquadradas: 
                    Tipo Cotação = Firme; 
                    Limite de Crédito selecionado; 
                    Retorno 'S' do fluxo de desenquadradas; 
                    Cliente ativo no piloto;
            */
            if (!openModalDesenquadradas(EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo())) {
            
	            if (validarFluxoConfirmar(EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo()) == true) {
	            	Boolean isValid = Boolean.TRUE;
	            	
	            	if(getTradeFinNegocVO().getListaFluxos().size() == 0 ||getTradeFinNegocVO().getListaFluxos().size() < listOperacaoAditarVO.size()){
	            		NpcFacesUtils.addInfoModalMessage("Quantidade de Fluxo de Pagamento deve ser igual à quantidade de Operação.", false);
	                    isValid = Boolean.FALSE;
	            	}
	            	
	            	if(isValid){
	            		setControleInclusaoAlteracao("DadosBasicos");
	            		continuarConfirmar();
	            	}
	            	
	            } else {
	    			getViewHelper().setRenderModal(Boolean.FALSE);
	
	            }
            }
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.actionModalConfirmar <<<<<<<<<<<");
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
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.actionFecharModalConfirma <<<<<<<<<<<");
            
            viewHelper.setRenderModal(Boolean.FALSE);
    
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.actionFecharModalConfirma <<<<<<<<<<<");
        }
        
     }
    
    /**
     * Nome: incluirFluxoPagtoPrincipalJuros
     * 
     * Propósito: Executa chamada ao MF para incluir Fluxo de Pagamento
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
    private void incluirFluxoPagtoPrincipalJuros() {

        for (Iterator<TrdFinNegFluxoPagtoVO> iterator = getTradeFinNegocVO().getListaFluxos().iterator(); iterator.hasNext();) {
            TrdFinNegFluxoPagtoVO itemListaFluxos = (TrdFinNegFluxoPagtoVO) iterator.next();

            itemListaFluxos.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
            itemListaFluxos.setHinclreg(getTradeFinNegocVO().getHinclreg());


            getTradeFinanceNegociacaoService().incluirFluxoPagtoPrincJurosNCEAditarFaKe(itemListaFluxos);
        }

        setControleInclusaoAlteracao("ComissaoInterna");

    }

    /**
     * Nome: incluirFluxoPagtoComissaoInterna
     * 
     * Propósito: Executa chamada ao MF para incluir Comissão Interna
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
    private void incluirFluxoPagtoComissaoInterna() {

        for (Iterator<TrdFinNegComissaoVO> iterator = getTradeFinNegocVO().getListaComissaoInterna().iterator(); iterator
                .hasNext();) {
            TrdFinNegComissaoVO itemListaComissaoInt = (TrdFinNegComissaoVO) iterator.next();

            itemListaComissaoInt.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
            itemListaComissaoInt.setHinclreg(getTradeFinNegocVO().getHinclreg());

            getTradeFinanceNegociacaoService().incluirFluxoPagtoComissaoInternaFinOuRefinDireto(itemListaComissaoInt, getTradeFinNegocVO().getProduto().getCodigo());
        }

        setControleInclusaoAlteracao("ComissaoExterna");
    }

    /**
     * Nome: incluirFluxoPagtoComissaoExterna
     * 
     * Propósito: Executa chamada ao MF para incluir Comissão Externa
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
    private void incluirFluxoPagtoComissaoExterna() {

        for (Iterator<IComissaoExterna> iterator = getTradeFinNegocVO().getListaComissaoExterna().iterator(); iterator
                .hasNext();) {
            TrdFinNegComissaoVO itemListaComissaoExt = (TrdFinNegComissaoVO) iterator.next();

            itemListaComissaoExt.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
            itemListaComissaoExt.setHinclreg(getTradeFinNegocVO().getHinclreg());

            getTradeFinanceNegociacaoService().incluirFluxoPagtoComissaoExternaFinOuRefinDireto(itemListaComissaoExt, getTradeFinNegocVO().getProduto().getCodigo());
        }

        setControleInclusaoAlteracao("GarantVinculoTarifaObs");
    }
    
    /**
     * Nome: incluirGarantVinculoTarifaObs
     * 
     * Propósito: Executa chamada ao MF para incluir Garantias, Operações
     * Vinculadas, Tarifas e Observações
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
    private void incluirGarantVinculoTarifaObs() {

        getTradeFinNegocVO().setListaGarantiasInclusao(getGarantiasModalBean().getListaGarantiasInclusao());

        getTradeFinNegocVO().setNtpopapelcmbio(EnumTradeFinance.TIPO_PAPEL_AVALISTA.getCodigo());
        getTradeFinNegocVO().setListaAvalistasInclusao(getGarantiasModalBean().getListaAvalistasInclusao());

        getTradeFinNegocVO().setDadosPrecificacao(getTrdFinNegPrecificacaoVO());
        
        // Trata campo tomador para produtos Working Capital e Forfaiting
        if(SiteUtil.isEmptyOrNull(getTomadorModal().getCunicpssoacmbio())) {
            // Pega o código selecionado na lupa
            getTradeFinNegocVO().setEcunicpssoacmbiot(SiteUtil.getLong(getTomadorModal().getCunicpssoacmbio()));
            getTradeFinNegocVO().setCindcpsqtomador(Numeros.UM);
        }

        getTradeFinanceNegociacaoService().incluirGarantiasVinculosTarifasObsFinOuRefinDireto(getTradeFinNegocVO(), getTrdFinNegPrecificacaoVO());

        setControleInclusaoAlteracao("ObservacoesCotacao");
       

    }
    
    /**
     * 
     * Nome: incluirObservacoes
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
    private void incluirObservacoes() {

        getTradeFinNegocVO().getObsCotacaoVO().setCtpooper("I");                    
        getTradeFinNegocVO().getObsCotacaoVO().setHinclreg(getTradeFinNegocVO().getHinclreg());
        getTradeFinNegocVO().getObsCotacaoVO().setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
        getTradeFinNegocVO().getObsCotacaoVO().setCunicclicmbio(getTradeFinNegocVO().getCunicclicmbio());
        getTradeFinNegocVO().getObsCotacaoVO().setCodCpfCnpj(getViewHelper().getCodCpfCnpjDepositarioSelecionado());

        if (getTradeFinNegocVO().getObsCotacaoVO().getListaRebate() != null) {
            getTradeFinNegocVO().getObsCotacaoVO().setQtdocrebt(getTradeFinNegocVO().getObsCotacaoVO().getListaRebate().size());
        }

        if (getTradeFinNegocVO().getObsCotacaoVO().getListaTaxa() != null) {
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
    
    /**
     * Nome: validarInclusao
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
    private Boolean validarInclusao(int tipoAcessoAlterarEvento) {
    	
    	boolean isValid = Boolean.TRUE;
        
    	int codSimNaoSwap = Numeros.ZERO;

        /************ Validações de Regras do Negócio ********/
        codSimNaoSwap = Integer.valueOf(getTradeFinNegocVO().getCindcdnegocswap());

        if (codSimNaoSwap == EnumSimNao.SIM.getCodigo() && getTradeFinNegocVO().isCindcdnegoclibor() == Boolean.TRUE
                        && !getTradeFinNegocVO().getProduto().isNce()) {
            if (getTradeFinNegocVO().getVtravaliborcmbio() == null || getTradeFinNegocVO().getVtravaliborcmbio() == "") {
                NpcFacesUtils.addInfoModalMessage("Libor Travada Obrigatório.", false);
                isValid = Boolean.FALSE;
            }
        }

        if (!getTradeFinNegocVO().getProduto().isGarantia()) {
        	if (getTradeFinNegocVO().getListaFluxos().size() <= Numeros.ZERO) {
        		NpcFacesUtils.addInfoModalMessage("Lista Fluxo Pagamento vazia.", false);
        		isValid = Boolean.FALSE;
        	}
        }

        if (!getTradeFinNegocVO().getProduto().isNce()) {
	        if (getTradeFinNegocVO().getListaComissaoInterna().size() <= Numeros.ZERO) {
	            NpcFacesUtils.addInfoModalMessage("Lista Comissão Interna (Spread) vazia.", false);
	            isValid = Boolean.FALSE;
	        } else {
	            for (Iterator<TrdFinNegComissaoVO> iterator = getTradeFinNegocVO().getListaComissaoInterna().iterator(); iterator
	                    .hasNext();) {
	                TrdFinNegComissaoVO itemLista = (TrdFinNegComissaoVO) iterator.next();
	                if (itemLista.getVprevtcomiscmbio() == null || itemLista.getVprevtcomiscmbio().length() <= Numeros.ZERO) {
	                    NpcFacesUtils.addInfoModalMessage("Item Comissão Interna (Spread) não incluido.", false);
	                    isValid = Boolean.FALSE;
	                }
	            }
	        }
        }

        return isValid;
    }
    
    /**
     * 
    	* Nome: incluirDadosBasicos
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 12/05/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void incluirDadosBasicos() {

        getTradeFinNegocVO().setCaditvbletocmbio(EnumTradeFinance.ADITIVO_NEGOC_INICIAL.getCodigo());
        if (getTradeFinNegocVO().getCsitbletocmbio() <= Numeros.NUM0) {
            getTradeFinNegocVO().setCsitbletocmbio(EnumTradeFinance.STATUS_EM_NEGOCIACAO.getCodigo());
        }

        getTradeFinNegocVO().setDvalddnegoccmbio(SiteUtil.dataWebToMainframe(getViewHelper().getDataLimiteCotacao()));
        getTradeFinNegocVO().setQprzmedcmbio(getViewHelper().getPrzomediooperd());

        getTradeFinNegocVO().setCindcdtipoacces(11);            
        
        setTradeFinNegocVO(tradeFinanceMonitService.incluirProrrogacao(getTradeFinNegocVO()));
        
        setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        
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
    public List<SelectItem> getItensRadioListaOperacaoAditar() {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.getItensRadioListaOperacaoVinculada <<<<<<<<<<<");

    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < listOperacaoAditarVO.size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.getItensRadioListaOperacaoVinculada <<<<<<<<<<<");
    	}
    	
    }

    private void limparObservacoes() {
        getTradeFinNegocVO().setObsCotacaoVO(new ObservacoesCotacaoVO());
        
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
    public void listenerExcluirOperacaoAditar(AjaxBehaviorEvent e) {

    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.listenerExcluirFluxo <<<<<<<<<<<");
    		
    		if (SiteUtil.isEmptyOrNull(getItemSelecLista())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}

    		listOperacaoAditarVO.remove(Integer.parseInt(getItemSelecLista()));
    		

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.listenerExcluirFluxo <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
     * Nome: detalhesFluxoPgtRadio
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void atualizarFluxoPagamento(AjaxBehaviorEvent ajaxBehaviorEvent) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinAditarBean.atualizarFluxoPagamento <<<<<<<<<<<");

            OperacaoAditarVO operacao = listOperacaoAditarVO.get(Integer.parseInt(getItemSelecLista()));
            
            getItemListaFluxoPgto().setVprevtdsembcmbio(operacao.getVladitado());
            getViewHelper().setDateFluxoPgtoTemp(viewHelper.getDatePrevDesembolso());
            
            getViewHelper().setNumDesembFlxPgtoOperAditar(operacao.getNdsembcmbiotrade());
            

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinAditarBean.atualizarFluxoPagamento <<<<<<<<<<<");
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
    			setControleInclusaoAlteracao(SiteUtil.STRING_EMPTY);
    			getViewHelper().setRenderModal(Boolean.TRUE);
    			continuarConfirmar();
			}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionGerarBoleto <<<<<<<<<<<");
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
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradefinAditarBean.gerarBoleto <<<<<<<<<<<");
    		
    		setGerarBoletoAlt(Boolean.FALSE);
    	            
    		return tradeFinanceBean.gerarBoleto();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradefinAditarBean.gerarBoleto <<<<<<<<<<<");
    	}
        
    }
    
   
    public Boolean confirmaAlteracao() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradefinAditarBean.confirmaAlteracao <<<<<<<<<<<");
    		
    		return validarInclusao(getTipoAcessoAlterarEvento());

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradefinAditarBean.confirmaAlteracao <<<<<<<<<<<");
    	}
    	
    }
    
	public List<OperacaoAditarVO> getListOperacaoAditarVO() {
		return listOperacaoAditarVO;
	}


	public void setListOperacaoAditarVO(List<OperacaoAditarVO> listOperacaoAditarVO) {
		this.listOperacaoAditarVO = listOperacaoAditarVO;
	}


	public String getItemSelecLista() {
		return itemSelecLista;
	}


	public void setItemSelecLista(String itemSelecLista) {
		this.itemSelecLista = itemSelecLista;
	}


	/**
	 * @return the gerarBoletoAlt
	 */
	public Boolean getGerarBoletoAlt() {
		return gerarBoletoAlt;
	}


	/**
	 * @param gerarBoletoAlt the gerarBoletoAlt to set
	 */
	public void setGerarBoletoAlt(Boolean gerarBoletoAlt) {
		this.gerarBoletoAlt = gerarBoletoAlt;
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

	
}
