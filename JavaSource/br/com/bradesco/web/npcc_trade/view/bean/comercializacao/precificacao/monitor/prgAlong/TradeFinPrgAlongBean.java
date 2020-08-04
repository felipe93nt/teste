package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.prgAlong;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DataDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPendencia;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoBase;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
  * Nome: TradeFinPrgAlongBean.java
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
@Named ("tradeFinPrgAlongBean")
@SessionScoped
public class TradeFinPrgAlongBean extends TradeFinanceNegociacaoBase implements Serializable{
	
	@Inject
    @Named("tradeFinanceMonitService")
    private ITradeFinanceMonitService tradeFinanceMonitService;
		
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 826133182627728555L;
    
    /** Controle dos modais para evento Confirmar e Cotar Custo Externo */
    private int tipoAcessoPrgAlongEvento = Numeros.ZERO;
    
    /** Controle das açoes do prorudo ppe Algongar/Prorrogar */
    private int codAcaoAlongarProrrogar = Numeros.ZERO;

	private List<DataDesembolsoVO> lista = new ArrayList<DataDesembolsoVO>();
	
	private Boolean renderBotaoCotarCustoExterno = true;
	
	private Boolean gerarBoletoIncl = false;
	
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
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinPrgAlongBean.iniciar <<<<<<<<<<<");
			
			// Recarrega página se não for um postback ou se foi marcado para
			// recaregar
			if (!isPostback() || getIniciarPagina()) {
				setIniciarPagina(Boolean.FALSE);
				
				// limpar campos da tela
				setTradeFinNegocVO(new TrdFinNegocInclVO());
				getViewHelper().setDateProrrogacao(null);
				getViewHelper().setDateVencFianc(null);
                
				reIniciarFluxoPagto();
				
				getViewHelper().setClienteEditavel(Boolean.FALSE);
				getViewHelper().setDisabledTipoCotacao(Boolean.TRUE);
				getViewHelper().setDisabledModalidade(Boolean.TRUE);
				
				getViewHelper().setRenderDetalheCliente(Boolean.TRUE);
				getViewHelper().setRenderModalCliente(Boolean.FALSE);
				getViewHelper().setTelaRetorno("tradeFinMonitList");
				getViewHelper().setComboDesembolsoOri(new ArrayList<SelectItem>());
				
				carregarDadosViaConsulta(EnumTradeFinance.FUNCAO_TIPO_PRORROGAR_ALONGAR.getCodigo());
				
				if(!getTradeFinNegocVO().getCprodtservc().equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA.getCodigo())
						&& !getTradeFinNegocVO().getCprodtservc().equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO.getCodigo())){
					
					carregarComboDesembolso();
					
				}
				
				getViewHelper().setDesabilitaCamposPrrg(Boolean.TRUE);				
				
				if (getTradeFinNegocVO().getCprodtservc().equals(EnumProduto.PRODUTO_P_P_E.getCodigo()) 
				        && getCodAcaoAlongarProrrogar() == ConstantesTradeFinance.FUNC_PRORROGAR){
					getViewHelper().setProrrogarPPE(Boolean.TRUE);
				}else{
					getViewHelper().setProrrogarPPE(Boolean.FALSE);
				}
				
				// Limpar Nº Aprov. crédito
                getTradeFinNegocVO().setNseqcontrlim(null);
                getTradeFinNegocVO().setNppstapontucmbio(null);
                
                // Só abre o modal se o piloto e o cliente está ativo
                if(getViewHelper().isOperaComLimite() == true) {
                    tratarListaLimite();
                }
				
				
	            if (getTradeFinNegocVO().getProduto().isGarantia()) {
	            	
	            	if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDfimnegoccmbio())){
	            		
	            		try {
	            			Date dataVencFianca = commonService.getDataVencimentoFianca(SiteUtil.stringToDate(getTradeFinNegocVO().getDfimnegoccmbio(), "dd/MM/yyyy"), getTradeFinNegocVO().getTdiaopercmbio());
							getTradeFinNegocVO().setDprevtprorrog(SiteUtil.dateToString(dataVencFianca, "dd/MM/yyyy"));

	            		} catch (ParseException e) {
	            		    BradescoCommonServiceFactory.getLogManager().info(e.getMessage());
						}
	            		 
	            	}
	            	
	            	Date dtVencFianca = getViewHelper().getDateVencFianc();
	            	
	            	if(dtVencFianca != null){
	            		
	            		GregorianCalendar gc = new GregorianCalendar();
	            		gc.setTime(dtVencFianca);
	            		gc.add(Calendar.DAY_OF_MONTH, getTradeFinNegocVO().getTdiaopercmbio());
	            		
	            		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
	            		
	            		getTradeFinNegocVO().setDprevtprorrog(formatter.format(gc.getTime()));
	            		
	            	}
	            	
	            }
	            
	            // Limpar dados de observações uso interno
                limparObservacoes();
                
                // Guarda os dados iniciais da alteração para verificar ao final se deve ser realizado o desenquadramento.
                setDesenquadradas(new DesenquadramentoVO());
	            
                getTradeFinNegocVO().setPrazoOperacaoAjustado(true);
                getViewHelper().setAlertMessageConfirmation("");
			}
			
			return null;

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinPrgAlongBean.iniciar <<<<<<<<<<<");
		}

	}
	
	/**
	 * 
		* Nome: carregarComboDesembolso
		* 
		* Propósito: Carregar um combo de SelectItem com os desembolsos da cotação 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 04/05/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	private void carregarComboDesembolso(){
		if(getViewHelper().getComboDesembolsoOri().isEmpty()) {
		    getTradeFinNegocVO().setNdsembcmbiotrade(Numeros.ZERO);
			lista = tradeFinanceMonitService.listaDataDesembolso(getTradeFinNegocVO().getNbletonegoccmbio());
			getViewHelper().getComboDesembolsoOri().add(new SelectItem(Numeros.ZERO, "Selecione..."));
			for (int i = 0; i < lista.size(); i++) {
				
				String desemb = lista.get(i).getDprevtdsembcmbio() + " - " +
								lista.get(i).getTdiafinandsemb() + " - " +
								lista.get(i).getVprevtdsembcmbio();
				
				getViewHelper().getComboDesembolsoOri().add(new SelectItem(lista.get(i).getNdsembcmbiotrade(), desemb));
			}
		}
	}
	
		/**
		* Nome: listenerTrocaValorMePrrgAlong
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 27/07/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
		*/
	public void listenerTrocaValorMePrrgAlong(AjaxBehaviorEvent event) {
        
        if (getTradeFinNegocVO().getListaFluxos().size() > Numeros.ZERO) {
            NpcFacesUtils.addInfoModalMessage("Fluxo Pagamento já incluido.", false);
            return;
        }
        
        getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDateProrrogacao());
        getItemListaFluxoPgto().setVprevtdsembcmbio(tradeFinNegocVO.getVnegocmoedaestrg());
	    
	    listenerTrocaValorMe(event);
	}
	
	/**
	 * 
		* Nome: obterDataPrevDesemb
		* 
		* Propósito: Retorna a data formatada com a previsao do desembolso
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 04/05/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public void obterDataPrevDesemb(AjaxBehaviorEvent event){
		
		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinPrgAlongBean.obterDataPrevDesemb <<<<<<<<<<<");
			
			if(!getTradeFinNegocVO().getNdsembcmbiotrade().equals(Numeros.ZERO)){
				getTradeFinNegocVO().setDprevtprorrog(tradeFinanceMonitService.obterProrrogacaoPrevisaoDesembolso(
								getTradeFinNegocVO().getNbletonegoccmbio(),
								getTradeFinNegocVO().getNdsembcmbiotrade(),
								getTradeFinNegocVO().getCaditvbletocmbio()));
				
				getViewHelper().setDateProrrogacao(SiteUtil.dataMainframeToWeb(getTradeFinNegocVO().getDprevtprorrog()));

				int indexFluxo = atualizarFluxoPagamento(getTradeFinNegocVO().getNdsembcmbiotrade());
				atualizarComissaoInterna(indexFluxo);
				
				if (getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
				    atualizarMercadoria(getTradeFinNegocVO().getNdsembcmbiotrade());
				}
				
			} else {
			    
				getTradeFinNegocVO().setDprevtprorrog("");
				getViewHelper().setDateFluxoPgtoTemp(null);
				
				// limpa fluxo de pagamento e comissão interna
				if(getTradeFinNegocVO().getListaFluxos() != null && getTradeFinNegocVO().getListaFluxos().size() > 0) {
				    
				    getViewHelper().setFuncaoBotaoFluxo("Excluir");
		            getViewHelper().setItemSelecListaFluxos("0");
		            confirmaFluxoPagto();
				}
			}
			

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinPrgAlongBean.obterDataPrevDesemb <<<<<<<<<<<");
		}
		
	}
	
		/**
		* Nome: validarDataPrevisaoProrrogacao
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 27/07/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
		*/
	public void validarDataPrevisaoProrrogacao(AjaxBehaviorEvent event) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.validarDataPrevisaoProrrogacao <<<<<<<<<<<");

            if (getTradeFinNegocVO().getListaFluxos().size() > Numeros.ZERO) {
                NpcFacesUtils.addInfoModalMessage("Fluxo Pagamento já incluido.", false);
            }
            
            if(getViewHelper().getDateProrrogacao() != null 
                            && getTradeFinNegocVO().getCpais() != null) {
               
                Integer cpaiInec = getTradeFinNegocVO().getCpaisInec();
                String tpodata = null; 
                
                if(getTradeFinNegocVO().getCsitbletocmbio().equals(EnumPendencia.CUSTO_EXTERNO.getCodigo())) {
                    tpodata = "2";
                }else {
                    tpodata = "1";
                }
                
                if (commonService.validarDiaUtil(getViewHelper().getDateProrrogacao(),
                                getTradeFinNegocVO().getCpais(), tpodata, cpaiInec, getTrdFinNegMercadoriaVO().getCpaisbnefc(), getTradeFinNegocVO().getCeconmmoedadsemb())) {
                    
                    getTradeFinNegocVO().setDprevtprorrog(SiteUtil.dateToString(getViewHelper().
                                    getDateProrrogacao(), "dd/MM/yyyy"));                  

                    getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDateProrrogacao());
                    getViewHelper().setDatePrevDesembolso(getViewHelper().getDateProrrogacao());
                } else {
                    NpcFacesUtils.addInfoModalMessage("Data Prorrogação inválida.", false);
                }
            }
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.validarDataPrevisaoProrrogacao <<<<<<<<<<<");
        }
        
	}
	
    public void listenerIncluirFluxoProrrogar(AjaxBehaviorEvent e) {
        getViewHelper().setDateFluxoPgtoTemp(getViewHelper().getDateProrrogacao());
        getViewHelper().setDatePrevDesembolso(getViewHelper().getDateProrrogacao());
        
        listenerIncluirFluxo(e);
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
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinPrgAlongBean.listenerConfirmar <<<<<<<<<<<");
			
			if (validarInclusao() == Boolean.FALSE) {
				return;
			}
			
			Integer paramOrigem = SiteUtil.getInt(event.getComponent().getAttributes().get("paramConfirmar"));
            // gerar boleto após inclusão
            setGerarBoletoIncl(paramOrigem == Numeros.DOIS);

			setTipoAcessoPrgAlongEvento(EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo());
            
            if (validarNegocioCotacao(getTipoAcessoPrgAlongEvento())) {
                
                atualizaPrazoOperacaoFluxoPagamento();
                
                // abre moda de confirmação
                getViewHelper().setRenderModal(Boolean.TRUE);
            }

		}finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinPrgAlongBean.listenerConfirmar <<<<<<<<<<<");
        }
        
    }
    
    public void continuarConfirmar() {
        
        String msgRetornoOk = null;
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinPrgAlongBean.continuarConfirmar <<<<<<<<<<<");
            
            for (Iterator<TrdFinNegFluxoPagtoVO> iterator = getTradeFinNegocVO().getListaFluxos().iterator(); iterator.hasNext();) {
                TrdFinNegFluxoPagtoVO itemListaFluxos = (TrdFinNegFluxoPagtoVO) iterator.next();

                itemListaFluxos.setNbletonegoccmbio(getTradeFinNegocVO().getNbletonegoccmbio());
                itemListaFluxos.setHinclreg(getTradeFinNegocVO().getHinclreg());
                
                int somaParcelas = itemListaFluxos.getQtdeocorrprinc() + itemListaFluxos.getQtdeocorrjuros();
                
                if (itemListaFluxos.getListaParcelasFluxoPgto().size() != somaParcelas) {
                	itemListaFluxos.setListaParcelasFluxoPgto(new ArrayList<TrdFinNegParcelaVO>());
                	NpcFacesUtils.addInfoModalMessage("Erro nas parcelas do Fluxo de Pagamento.", false);
                	return;
    			}
            }
            
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
			   
            // Parametro para abrir o boleto da cotação prorrogada/alongada no monitor.
            if(gerarBoletoIncl) {
                DadosGerarBoletoVO dadosGerarBoleto = new DadosGerarBoletoVO();
                dadosGerarBoleto.setGerarBoleto(true);
                dadosGerarBoleto.setDanobase(getTradeFinNegocVO().getDanobase());
                dadosGerarBoleto.setNbletocmbioano(getTradeFinNegocVO().getNbletocmbioano());
                getTradeFinanceBean().getViewHelper().setGerarBoletoDuplicar(dadosGerarBoleto);
                gerarBoletoIncl = Boolean.FALSE;
            }
            
         // Redireciona para a tela de consulta (Menu Dinâmico) 
            BradescoFacesUtils.addInfoModalMessage(msgRetornoOk, 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinPrgAlongBean.continuarConfirmar <<<<<<<<<<<");
		}
		
    }
    
    	/**
    	* Nome: listenerCotarCustoExterno
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
    public void listenerCotarCustoExterno(AjaxBehaviorEvent event) {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinPrgAlongBean.listenerCotarCustoExterno <<<<<<<<<<<");
            
            setTipoAcessoPrgAlongEvento(EnumTradeFinance.ACESSO_COTAR_CUSTO_EXTERNO.getCodigo());
            
            if (validarNegocioCotacao(getTipoAcessoPrgAlongEvento())) {
                abrirModalMotivoCotarCustoExterno();
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinPrgAlongBean.listenerCotarCustoExterno <<<<<<<<<<<");
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
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinPrgAlongBean.fecharModalAlertaAlteracao <<<<<<<<<<<");
            
            //fechar rendermodal
            viewHelper.setRenderModalAlerta(Boolean.FALSE);
            
            setControleInclusaoAlteracao("DadosBasicos");
            
            continuarConfirmar();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinPrgAlongBean.fecharModalAlertaAlteracao <<<<<<<<<<<");
        }
        
    }

    public void actionModalConfirmar() {
        
        try{

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinPrgAlongBean.actionModalConfirmar <<<<<<<<<<<");
            
            getViewHelper().setRenderModal(Boolean.FALSE);
            
            // confirmação do botão alterar
            if (EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo().equals(getTipoAcessoPrgAlongEvento())) {
                
                /*  Condição para abrir modal de desenquadradas: 
                    Tipo Cotação = Firme; 
                    Limite de Crédito selecionado; 
                    Retorno 'S' do fluxo de desenquadradas; 
                    Se o cliente está ativo no piloto;
                 */
                if (!openModalDesenquadradas(getTipoAcessoPrgAlongEvento())) {
                   
                    if (validarFluxoConfirmar(getTipoAcessoPrgAlongEvento()) == true) {
                        setControleInclusaoAlteracao("DadosBasicos");
                        continuarConfirmar();
                        setTipoAcessoPrgAlongEvento(Numeros.ZERO);
                    }
                }
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinPrgAlongBean.actionModalConfirmar <<<<<<<<<<<");
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
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinPrgAlongBean.actionFecharModalConfirma <<<<<<<<<<<");
            
            viewHelper.setRenderModal(Boolean.FALSE);
            setTipoAcessoPrgAlongEvento(Numeros.ZERO);
    
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinPrgAlongBean.actionFecharModalConfirma <<<<<<<<<<<");
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


            getTradeFinanceNegociacaoService().incluirFluxoPagtoPrincJurosFinimpDireto(itemListaFluxos);
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
        if(!SiteUtil.isEmptyOrNull(getTomadorModal().getCunicpssoacmbio()) && getTomadorModal().getCunicpssoacmbio() > 0L) {
            // Pega o código selecionado na lupa
            getTradeFinNegocVO().setEcunicpssoacmbiot(getTomadorModal().getCunicpssoacmbio());
            getTradeFinNegocVO().setCindcpsqtomador(Numeros.UM);
        }

        getTradeFinanceNegociacaoService().incluirGarantiasVinculosTarifasObsFinOuRefinDireto(getTradeFinNegocVO(), getTrdFinNegPrecificacaoVO());

        setControleInclusaoAlteracao("FimInclusaoAlteracao");
        
        if (getTradeFinNegocVO().getProduto().isGarantia()) {
            setControleInclusaoAlteracao("ObservacoesCotacao");
        }

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
    private Boolean validarInclusao() {
        int codSimNaoSwap = Numeros.ZERO;

        /************ Validações de Regras do Negócio ********/
        codSimNaoSwap = Integer.valueOf(getTradeFinNegocVO().getCindcdnegocswap());

        if (codSimNaoSwap == EnumSimNao.SIM.getCodigo() && getTradeFinNegocVO().isCindcdnegoclibor() == Boolean.TRUE
                        && !getTradeFinNegocVO().getProduto().isNce()) {
            if (getTradeFinNegocVO().getVtravaliborcmbio() == null || getTradeFinNegocVO().getVtravaliborcmbio() == "") {
                NpcFacesUtils.addInfoModalMessage("Libor Travada Obrigatório.", false);
                return Boolean.FALSE;
            }
        }

        if (!getTradeFinNegocVO().getProduto().isGarantia()) {
        	if (getTradeFinNegocVO().getListaFluxos().size() <= Numeros.ZERO) {
        		NpcFacesUtils.addInfoModalMessage("Lista Fluxo Pagamento vazia.", false);
        		return Boolean.FALSE;
        	}
        }

        if (getTradeFinNegocVO().getListaComissaoInterna().size() <= Numeros.ZERO) {
            NpcFacesUtils.addInfoModalMessage("Lista Comissão Interna (Spread) vazia.", false);
            return Boolean.FALSE;
        } else {
            for (Iterator<TrdFinNegComissaoVO> iterator = getTradeFinNegocVO().getListaComissaoInterna().iterator(); iterator
                    .hasNext();) {
                TrdFinNegComissaoVO itemLista = (TrdFinNegComissaoVO) iterator.next();
                if (itemLista.getVprevtcomiscmbio() == null || itemLista.getVprevtcomiscmbio().length() <= Numeros.ZERO) {
                    NpcFacesUtils.addInfoModalMessage("Item Comissão Interna (Spread) não incluido.", false);
                    return Boolean.FALSE;
                }
            }
        }

        return Boolean.TRUE;
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
        getTradeFinNegocVO().setVtxspreadnegoc(getItemListaComissaoInterna().getVtxspreadnegoc());
        
        if(getCodAcaoAlongarProrrogar() == ConstantesTradeFinance.FUNC_ALONGAR) {
            getTradeFinNegocVO().setCindcdtipoacces(11);            
        } else {
            getTradeFinNegocVO().setCindcdtipoacces(12);
        }
        
        setTradeFinNegocVO(tradeFinanceMonitService.incluirProrrogacao(getTradeFinNegocVO()));
        
        setControleInclusaoAlteracao("FluxoPagtoPrincipalJuros");
        
        if (getTradeFinNegocVO().getProduto().isGarantia()) {
            setControleInclusaoAlteracao("ComissaoInterna");
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
     * @return o valor do tipoAcessoPrgAlongEvento
     */
    public int getTipoAcessoPrgAlongEvento() {
        return tipoAcessoPrgAlongEvento;
    }

    /**
     * @param tipoAcessoPrgAlongEvento seta o novo valor para o campo tipoAcessoPrgAlongEvento
     */
    public void setTipoAcessoPrgAlongEvento(int tipoAcessoPrgAlongEvento) {
        this.tipoAcessoPrgAlongEvento = tipoAcessoPrgAlongEvento;
    }
    
    /**
     * @return o valor do codAcaoAlongarProrrogar
     */
	public int getCodAcaoAlongarProrrogar() {
		return codAcaoAlongarProrrogar;
	}

    /**
     * @param codAcaoAlongarProrrogar seta o novo valor para o campo codAcaoAlongarProrrogar
     */
	public void setCodAcaoAlongarProrrogar(int codAcaoAlongarProrrogar) {
		this.codAcaoAlongarProrrogar = codAcaoAlongarProrrogar;
	}

    /**
     * @return o valor do gerarBoletoIncl
     */
    public Boolean getGerarBoletoIncl() {
        return gerarBoletoIncl;
    }

    /**
     * @param gerarBoletoIncl seta o novo valor para o campo gerarBoletoIncl
     */
    public void setGerarBoletoIncl(Boolean gerarBoletoIncl) {
        this.gerarBoletoIncl = gerarBoletoIncl;
    }
    
}
