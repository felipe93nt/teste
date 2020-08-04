package br.com.bradesco.web.npcc_trade.view.bean.global.comissaoExtManutModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumCobrancaComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.comissaoBase.ComissaoBaseBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named("comissaoExtManutModalBean")
@SessionScoped
public class ComissaoExtManutModalBean extends ComissaoBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    private TrdFinNegComissaoVO itemListaComissaoExterna = new TrdFinNegComissaoVO();

    private TrdFinNegParcelaVO itemListaParcelaIrreg = new TrdFinNegParcelaVO();

    private ComissaoCollection listaComissaoExterna = new ComissaoCollection();

    private Integer qtdeFluxoPgt = Numeros.ZERO;
    private Integer tdiafinandsemb = Numeros.ZERO;
    
    private Boolean confirmarManutencao = Boolean.FALSE;
    
    private List<TrdFinNegParcelaVO> listaParcelasTemp = new ArrayList<TrdFinNegParcelaVO>();
    
    
    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;

    /**
     * Nome: listenerGerarParcelaComissaoExterna
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
    public void listenerGerarParcelaComissaoExterna(AjaxBehaviorEvent e) {

    	try{
    		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerGerarParcelaComissaoExterna <<<<<<<<<<<");
    		
             if (itemListaComissaoExterna.getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
                 itemListaComissaoExterna.setVmincobrcomis("0,00");
                 
                 getViewHelper().setStateIdListaParcelasComissao("NPCCIAO9");
                 gerarParcelas(itemListaComissaoExterna);
                 itemListaComissaoExterna.setVlxtotalcomis(itemListaComissaoExterna.getVprevtcomiscmbio());
                 tratarBotoesManutencaoIrregular();
                 return;
             }
             
    		 if(!comissaoIncluida(getItemListaComissaoExterna().getCcondceconc())) {
    			 
    			 if (qtdeFluxoPgt <= Numeros.ZERO) {
    				 if (!getViewHelper().getCodProduto().equals(EnumProduto.LC_IMPORTACAO.getCodigo())
    						 && !getViewHelper().getCodProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA.getCodigo())
    						 && !getViewHelper().getCodProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO.getCodigo())
    						 && !getViewHelper().getCodProduto().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
    					 
    					 NpcFacesUtils.addInfoModalMessage("Fluxo de Pagamento não incluído.", EnumButtonBehavior.SUBMIT);
    					 return;
    				 }
    			 }
    			 
    			 if (SiteUtil.isEmptyOrNull(getItemListaComissaoExterna().getCcondceconc())) {
    			     NpcFacesUtils.addInfoModalMessage("O campo Tipo é obrigatório.", EnumButtonBehavior.SUBMIT);
                     return;
    			 }
    			 
    			 if (verificarValorComTaxa() == false) {
    				 return;
    			 }
    			 
    			 itemListaComissaoExterna.setVmincobrcomis("0,00");
    			 
    			 getViewHelper().setStateIdListaParcelasComissao("NPCCIAO9");
    			 gerarParcelas(itemListaComissaoExterna);
    			 
   		        tratarBotoesManutencaoIrregular();
    		 }
    		 
    	}finally{
    		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerGerarParcelaComissaoExterna <<<<<<<<<<<");
    	}
    

    }
    
    private Boolean comissaoIncluida(Integer codTipoComissao) {
        Boolean result = false;
        
        Iterator<IComissaoExterna> iterator;
        
        if(itemListaComissaoExterna.getTipoComissao().equals(EnumTipoComissao.BANQUEIRO)) {
            iterator = listaComissaoExterna.getComissaoBanqueiro().iterator();
        } else {
            iterator = listaComissaoExterna.getComissaoAdicional().iterator();
        }
        
        while (iterator.hasNext()) {
            TrdFinNegComissaoVO item = (TrdFinNegComissaoVO) iterator.next();                    
            
            if(codTipoComissao.equals(item.getCcondceconc()) && !getViewHelper().getFuncaoBotaoComissaoExterna().equals("Alterar")) {
                
                NpcFacesUtils.addInfoModalMessage("Comissão já incluída.", EnumButtonBehavior.SUBMIT);
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    /**
     * Nome: limpar
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
    public void limpar(AjaxBehaviorEvent e) {
    	
    	try{
   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.limpar <<<<<<<<<<<");

   		 	getItemListaComissaoExterna().setCcondceconc(Numeros.ZERO);
	   		getItemListaComissaoExterna().setVlxtotalcomis("");
	   		getItemListaComissaoExterna().setPjuronegoccmbio("");
	   		getItemListaComissaoExterna().setCperdcjurocmbio(Numeros.UM);
	   		disableValorTaxa();
	   		getItemListaComissaoExterna().setCindcdeconmmoeda(viewHelper.getCindcdeconmmoeda());
	   		getItemListaComissaoExterna().setCfluxoperdccmbio(EnumTradeFinance.PERIODICIDADE_SEMESTRAL.getCodigo());
	   		getItemListaComissaoExterna().setCodMomentoComissao(Numeros.ZERO);
	   		getItemListaComissaoExterna().setQpcelacmbiotrade(null);
	   		itemListaComissaoExterna.setVprevtcomiscmbio(null);
	   		itemListaComissaoExterna.setListaParcelasComissao(new ArrayList<TrdFinNegParcelaVO>());
   		
	   	}finally{
	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.limpar <<<<<<<<<<<");
	   	}
        
        
    }

    /**
     * 
     * Nome: openModal
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
    public void openModal(Integer codProduto){
    	
    	try{
      		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.openModal <<<<<<<<<<<");
      		
      		 viewHelper.setDisabledBotaoGerar(Boolean.FALSE);
      		 viewHelper.setDisabledConfirmar(Boolean.FALSE);
      		 
      		 setConfirmarManutencao(Boolean.FALSE);
      		 
      		 viewHelper.setComboMoedaDesembolso(selectItemBean.getMoeda());
      		 viewHelper.setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.COMISSAO_EXTERNA.getCodigo(), codProduto));
      		 viewHelper.setComboPeriodicidade(selectItemBean.getPeriodicidadeComissAdicional(Numeros.ZERO));
      		 viewHelper.setComboTipoComissao(selectItemBean.getTipoComissao(codProduto, viewHelper.getTelaOrigem()));
      		 viewHelper.setComboPeriodoDaTaxa(selectItemBean.getCodigoCobrancaComissao());
      		 
      		 itemListaComissaoExterna.getListaParcelasComissao().clear();
             itemListaComissaoExterna.getListaParcelasComissao().addAll(listaParcelasTemp);
             disableValorTaxa();
             
      		 getViewHelper().setCodProduto(codProduto);
      		 getViewHelper().setRenderModal(Boolean.TRUE);
      		 
             tratarBotoesManutencaoIrregular();
      		 
   	   	}finally{
   	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.openModal <<<<<<<<<<<");
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
    public void closeModal(ActionEvent event) {
    	
    	try{
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.closeModal <<<<<<<<<<<");
    	    
    	    if (!confirmarManutencao) {
    	        
                getItemListaComissaoExterna().getListaParcelasComissao().clear();
                getItemListaComissaoExterna().getListaParcelasComissao().addAll(listaParcelasTemp);
            }
     		
     		getViewHelper().setLinhaSelecionada(null);
     		getViewHelper().setRenderModal(Boolean.FALSE);
     		 
  	   	}finally{
  	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.closeModal <<<<<<<<<<<");
  	   	}
        
    }

    /**
     * 
     * Nome: confirmaModalComissaoExterna
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
    public String confirmaModalComissaoExterna() {
    	
    	try{
     		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.confirmaModalComissaoExterna <<<<<<<<<<<");
     		
     		 TrdFinNegComissaoVO itemComissaoExternaTemp = null;
     		 
     		 if (getViewHelper().getFuncaoBotaoComissaoExterna().equals("Excluir")) {
     			 
                itemComissaoExternaTemp = (TrdFinNegComissaoVO) getListaComissaoExterna().get(
                        SiteUtil.getInt(viewHelper.getLinhaSelecionada()), 
                        getItemListaComissaoExterna().getTipoComissao());
     			 
     			 // Remove o item selecionado.
     			 getListaComissaoExterna().remove(itemComissaoExternaTemp);
     			 getItemListaComissaoExterna().getListaParcelasComissao().clear();
     			 listaParcelasTemp.clear();
     		 }
     		 
     		 if (getViewHelper().getFuncaoBotaoComissaoExterna().equals("Incluir")) {
     		     
     		    if (SiteUtil.isEmptyOrNull(getItemListaComissaoExterna().getCcondceconc())) {
                    NpcFacesUtils.addInfoModalMessage("O campo Tipo é obrigatório.", EnumButtonBehavior.SUBMIT);
                    return null;
                }
     		     
     		    if(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo().equals(itemListaComissaoExterna.getCfluxoperdccmbio())
     		                    && !verificaSomaParcela(getItemListaComissaoExterna())){
                    return null;
                }
     		     
     			if (!EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo().equals(itemListaComissaoExterna.getCfluxoperdccmbio())) {
     				if (verificarValorComTaxa() == false) {
     					return null;
     				}
     			}
     			 
     			if (prepararManutComissaoExterna() == Boolean.FALSE) {
     				return null;
     			}
     			 // Adiciona os dados na lista.
     			getListaComissaoExterna().add(itemListaComissaoExterna);
     		 }
     		 
     		 if (getViewHelper().getFuncaoBotaoComissaoExterna().equals("Alterar")) {
     			
     		    if (SiteUtil.isEmptyOrNull(getItemListaComissaoExterna().getCcondceconc())) {
                    NpcFacesUtils.addInfoModalMessage("O campo Tipo é obrigatório.", EnumButtonBehavior.SUBMIT);
                    return null;
                }
     		     
     		    if(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo().equals(itemListaComissaoExterna.getCfluxoperdccmbio())
                                && !verificaSomaParcela(getItemListaComissaoExterna())){
                    return null;
                } 
     		     
     			if (!EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo().equals(itemListaComissaoExterna.getCfluxoperdccmbio())) {
     				if (verificarValorComTaxa() == false) {
     					return null;
     				}
     			}
     			 
     			 if (prepararManutComissaoExterna() == Boolean.FALSE) {
     				 return null;
     			 }
     			 
     			 // Altera os dados na lista.
     			 getListaComissaoExterna().set(SiteUtil.getInt(viewHelper.getLinhaSelecionada()), itemListaComissaoExterna);
     		 }
     		 
     		 setConfirmarManutencao(Boolean.TRUE);
     		 getListaParcelasTemp().clear();
     		 getListaParcelasTemp().addAll(itemListaComissaoExterna.getListaParcelasComissao());
     		 
     		 itemListaComissaoExterna = new TrdFinNegComissaoVO();
     		 
     		 return "/content/global/comissaoExtManutModal/modalComissExtManutClose.xhtml";
     		 
  	   	}finally{
  	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.confirmaModalComissaoExterna <<<<<<<<<<<");
  	   	}
    	
    }

    /**
     * Nome: prepararManutComissaoExterna
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
    private Boolean prepararManutComissaoExterna() {

        Integer codInteger = 0;
        String descrCombo = null;
        
        if (itemListaComissaoExterna.getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
            if (itemListaComissaoExterna.getListaParcelasComissao().size() <= Numeros.ZERO) {
                NpcFacesUtils.addInfoModalMessage("Parcelas não informadas.", EnumButtonBehavior.SUBMIT);
                return Boolean.FALSE;
            }
            
        } else {

            // valida se foi selecionado um item na lista
            if (itemListaComissaoExterna.getVprevtcomiscmbio() == null
                            || itemListaComissaoExterna.getVprevtcomiscmbio().length() <= 0) {
                NpcFacesUtils.addInfoModalMessage("Dados modificados. Gerar parcelas.", EnumButtonBehavior.SUBMIT);
                return Boolean.FALSE;
            }
        }

        codInteger = itemListaComissaoExterna.getCcondceconc();
        for (int i = 0; i < viewHelper.getComboTipoComissao().size(); i++) {
            if (viewHelper.getComboTipoComissao().get(i).getValue().equals(codInteger)) {
                descrCombo = viewHelper.getComboTipoComissao().get(i).getLabel();
                break;
            }
        }
        itemListaComissaoExterna.setTipoComissaoExt(descrCombo);

        codInteger = itemListaComissaoExterna.getCperdcjurocmbio();
        for (int i = 0; i < viewHelper.getComboPeriodoDaTaxa().size(); i++) {
            if (viewHelper.getComboPeriodoDaTaxa().get(i).getValue().equals(codInteger)) {
                descrCombo = viewHelper.getComboPeriodoDaTaxa().get(i).getLabel();
                break;
            }
        }
        itemListaComissaoExterna.setPeriodoTaxa(descrCombo);

        codInteger = itemListaComissaoExterna.getCindcdeconmmoeda();
        for (int i = 0; i < viewHelper.getComboMoedaDesembolso().size(); i++) {
            if (viewHelper.getComboMoedaDesembolso().get(i).getValue().equals(codInteger)) {
                descrCombo = viewHelper.getComboMoedaDesembolso().get(i).getLabel();
                break;
            }
        }
        itemListaComissaoExterna.setMoedaComissao(descrCombo);

        codInteger = itemListaComissaoExterna.getCfluxoperdccmbio();
        for (int i = 0; i < viewHelper.getComboPeriodicidade().size(); i++) {
            if (viewHelper.getComboPeriodicidade().get(i).getValue().equals(codInteger)) {
                descrCombo = viewHelper.getComboPeriodicidade().get(i).getLabel();
                break;
            }
        }
        itemListaComissaoExterna.setPeriodicidadeComissao(descrCombo);

        codInteger = itemListaComissaoExterna.getCodMomentoComissao();
        for (int i = 0; i < viewHelper.getComboMomento().size(); i++) {
            if (viewHelper.getComboMomento().get(i).getValue().equals(codInteger)) {
                descrCombo = viewHelper.getComboMomento().get(i).getLabel();
                break;
            }
        }
        itemListaComissaoExterna.setMomentoComissao(descrCombo);
        
        if (itemListaComissaoExterna.getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
            geraTotalParcelasIrregular();
            tratarBotoesManutencaoIrregular();
        }


        return Boolean.TRUE;
    }
    
    /**
     * 
    	* Nome: verificarValorComTaxa
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
    private boolean verificarValorComTaxa() {
      
        if ((getItemListaComissaoExterna().getCperdcjurocmbio().equals(Numeros.NUM2)
                || getItemListaComissaoExterna().getCperdcjurocmbio().equals(Numeros.NUM3))
                && SiteUtil.isValueZero(itemListaComissaoExterna.getPjuronegoccmbio())) {
            
            NpcFacesUtils.addInfoModalMessage("O campo Taxa é obrigatório.", EnumButtonBehavior.SUBMIT);
            return false;
        } 
        
        else if(getItemListaComissaoExterna().getCperdcjurocmbio().equals(Numeros.NUM1) 
                && SiteUtil.isValueZero(itemListaComissaoExterna.getVlxtotalcomis())) {
            
            NpcFacesUtils.addInfoModalMessage("O campo Valor é obrigatório.", EnumButtonBehavior.SUBMIT);
            return false;
        }
        
        return true;
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
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerTrocaPeriodoDaTaxa <<<<<<<<<<<");
      		
      		disableValorTaxa();
      		 
      		if (itemListaComissaoExterna.getCfluxoperdccmbio() != EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
      		    itemListaComissaoExterna.setVprevtcomiscmbio(null);
      		} else {
        		  itemListaComissaoExterna.setVlxtotalcomis(null);
                  itemListaComissaoExterna.setPjuronegoccmbio(null);

          		  prepararManutencaoIrregular();
            }
      		 
   	   	}finally{
   	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerTrocaPeriodoDaTaxa <<<<<<<<<<<");
   	   	}
        
    }
    
    private void disableValorTaxa() {
        
        if (getItemListaComissaoExterna().getCperdcjurocmbio().equals(Numeros.NUM2)
                || getItemListaComissaoExterna().getCperdcjurocmbio().equals(Numeros.NUM3)) {
            
            getViewHelper().setDisabledValorComissaoExt(Boolean.TRUE);
            getViewHelper().setDisabledTaxaComissaoExt(Boolean.FALSE);
            getItemListaComissaoExterna().setVlxtotalcomis("");
            getItemListaComissaoExterna().setPjuronegoccmbio("");
        } else {
            getViewHelper().setDisabledValorComissaoExt(Boolean.FALSE);
            getViewHelper().setDisabledTaxaComissaoExt(Boolean.TRUE);
            getItemListaComissaoExterna().setPjuronegoccmbio("");
        }
        tratarBotoesManutencaoIrregular();
    }
    
    /**
     * 
        * Nome: listenerTrocaValorTaxa
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
    public void listenerTrocaValorTaxa(AjaxBehaviorEvent e) {
        
        try{
             BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerTrocaValorTaxa <<<<<<<<<<<");
            
             if (itemListaComissaoExterna.getCfluxoperdccmbio() != EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
                 itemListaComissaoExterna.setVprevtcomiscmbio(null);
             } else {
            	 tratarBotoesManutencaoIrregular();
             }
             
        }finally{
             BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerTrocaValorTaxa <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
        * Nome: listenerTrocaPrazo
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
    public void listenerTrocaVencimento(AjaxBehaviorEvent e) {
        itemListaParcelaIrreg.setTdianegocpcela(null);
        trocarPrazo(getItemListaComissaoExterna(), getItemListaParcelaIrreg());
        tratarBotoesManutencaoIrregular();
    }
    
    /**
     * 
    	* Nome: listenerTrocaMoeda
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
    public void listenerTrocaMoeda(AjaxBehaviorEvent e) {
    	
    	try{
     		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerTrocaMoeda <<<<<<<<<<<");
     		
     		 if (itemListaComissaoExterna.getCfluxoperdccmbio() != EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
     			 itemListaComissaoExterna.setVprevtcomiscmbio(null);
     		 }
     		 
  	   	}finally{
  	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerTrocaMoeda <<<<<<<<<<<");
  	   	}
        
    }
    
    /**
     * 
    	* Nome: listenerTrocaMomento
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
    public void listenerTrocaMomento(AjaxBehaviorEvent e) {
    	tratarComboMomento(getItemListaComissaoExterna());
    	/*try{
    		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerTrocaMomento <<<<<<<<<<<");
    		
    		 if (itemListaComissaoExterna.getCfluxoperdccmbio() != EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
    			 itemListaComissaoExterna.setVprevtcomiscmbio(null);
    		 }
    		 
    		 tratarMomento();
    		 
 	   	}finally{
 	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerTrocaMomento <<<<<<<<<<<");
 	   	}*/
        
    }
    
    /************************************************************
     * INICIO - METODOS TRATAMENTO PARA PERIODICIDADE IRREGULAR *
     ***********************************************************/

    /**
     * 
     * Nome: listenerTrocaPeriodicidadeComissaoExterna
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
    public void listenerTrocaPeriodicidadeComissaoExterna(AjaxBehaviorEvent e) {
    	try{
   		 	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerTrocaPeriodicidadeComissaoExterna <<<<<<<<<<<");
   		
   		 	itemListaComissaoExterna.setQpcelacmbiotrade(null);
   		 	viewHelper.setDisabledConfirmar(Boolean.FALSE);
   		 	
   		 	if (itemListaComissaoExterna.getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
   		 		getItemListaComissaoExterna().setListaParcelasComissao(new ArrayList<TrdFinNegParcelaVO>());
   		 		
   		 		
   		 		viewHelper.setDisabledTxtParcelaComissaoExt(Boolean.FALSE);
   		 		setItemListaParcelaIrreg(new TrdFinNegParcelaVO());
   		 	    getItemListaParcelaIrreg().setVencimentoComissao(getItemListaComissaoExterna().getDprevtdsembcmbio());
   		 	    
   		 		getItemListaComissaoExterna().setListaParcelasComissao(new ArrayList<TrdFinNegParcelaVO>());
	   		 	prepararManutencaoIrregular();
	   		 	listenerTrocaPrazo(null);
   		 	} else {
   		 		viewHelper.setDisabledTxtParcelaComissaoExt(Boolean.TRUE);
   		 		viewHelper.setDisabledBotaoGerar(Boolean.FALSE);
   		 		itemListaComissaoExterna.setVprevtcomiscmbio(null);

   		 		getViewHelper().setDisabledValorTaxaQuandoIrregular(Boolean.FALSE);
   		 	}
   		 	
   		 	tratarPeriodo(getItemListaComissaoExterna());
   		 
	   	}finally{
	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerTrocaPeriodicidadeComissaoExterna <<<<<<<<<<<");
	   	}
        
    }

    	/**
    	* Nome: listenerIncluirParcelaIrregular
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 29/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerIncluirParcelaIrregular(AjaxBehaviorEvent e) {
        
        
        Boolean result = incluirParcelaIrregular(getItemListaComissaoExterna(), getItemListaParcelaIrreg());
        
        if(result) {
            itemListaParcelaIrreg = new TrdFinNegParcelaVO();
        }
        tratarBotoesManutencaoIrregular();
    }

    	/**
    	* Nome: listenerExcluirParcelaIrregular
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 29/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void listenerExcluirParcelaIrregular(AjaxBehaviorEvent e) {
    	
    	try{
   		 	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.listenerExcluirParcelaIrregular <<<<<<<<<<<");
   		
   		 	TrdFinNegParcelaVO itemParcela = null;
   		 	
   		 	// valida se foi selecionado um item na lista.
   		 	if (SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaParcelaComiss())) {
   		 		NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
   		 		return;
   		 	}
   		 	
   		 	itemParcela = getItemListaComissaoExterna().getListaParcelasComissao().get(Integer.parseInt(
   		 	                getViewHelper().getItemSelecListaParcelaComiss()));
   		 	
   		 	// Remove o item selecionado.
   		 	getItemListaComissaoExterna().getListaParcelasComissao().remove(itemParcela);
   		 	
   		 	getViewHelper().setItemSelecListaParcelaComiss(null);
   		 	
   		 	tratarBotoesManutencaoIrregular();
   		 	
	   	}finally{
	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.listenerExcluirParcelaIrregular <<<<<<<<<<<");
	   	}
    	
        
    }

    	/**
    	* Nome: getItensRadioListaParcelaComiss
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 29/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public List<SelectItem> getItensRadioListaParcelaComiss() {
    	
    	try{
   		 	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoExtManutModalBean.getItensRadioListaParcelaComiss <<<<<<<<<<<");
   		
   		 	List<SelectItem> list = new ArrayList<SelectItem>();
   		 	
   		 	// Percorre todos os itens da lista afim de criar os respectivos radio
   		 	// buttons
   		 	for (int index = 0; index < getItemListaComissaoExterna().getListaParcelasComissao().size(); index++) {
   		 		list.add(new SelectItem(index, "", ""));
   		 	}
   		 	
   		 	return list;
   		 
	   	}finally{
	   		 BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoExtManutModalBean.getItensRadioListaParcelaComiss <<<<<<<<<<<");
	   	}
    	
    }
    
    	/**
    	* Nome: geraTotalParcelasIrregular
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 29/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    private void geraTotalParcelasIrregular() {
        TrdFinNegParcelaVO itemParcela = null;
        String strValorParcela = null;
        Double totalValorParcela = 0D;
        
        for (Iterator<TrdFinNegParcelaVO> iterator = itemListaComissaoExterna.
                        getListaParcelasComissao().iterator(); iterator.hasNext();) {
            itemParcela = (TrdFinNegParcelaVO) iterator.next();
            
            strValorParcela = SiteUtil.webMoedaToMainframe(itemParcela.getVpcelacomiscmbio());
            itemParcela.setVpcelacomiscmbio(strValorParcela);
            
            totalValorParcela += SiteUtil.webMoedaToDouble(itemParcela.getVpcelacomiscmbio());
        }
        totalValorParcela /= 100;
        itemListaComissaoExterna.setVprevtcomiscmbio(SiteUtil.doubleToBrowserMoeda(totalValorParcela));
        itemListaComissaoExterna.setQpcelacmbiotrade(itemListaComissaoExterna.getListaParcelasComissao().size());
        
        
    }
    
    /**
     * 
    	* Nome: listenerVerificaTotalParcela
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 19/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerVerificaTotalParcela(AjaxBehaviorEvent e) {
        if(SiteUtil.isEmptyOrNull(getItemListaComissaoExterna().getVlxtotalcomis())){
            NpcFacesUtils.addInfoModalMessage("Informe o valor Total.", false);
            return;
        }
        verificaTotalParcela(getItemListaComissaoExterna(), getItemListaParcelaIrreg());
    }
    
    /**
     * 
    	* Nome: listenerTrocaDataVencimento
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 19/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerTrocaDataVencimento(AjaxBehaviorEvent e) {
        trocarDataVencimento(getItemListaComissaoExterna(), getItemListaParcelaIrreg());
        
        /*
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerTrocaDataVencimento <<<<<<<<<<<");
            
            itemListaParcelaIrreg.setTdianegocpcela(null);
            
            //O vencimento da parcela deve ser maior que da anterior
            obterDtVencParcelaAnterior();
            
            comissaoInternaExternaModalService.calcularDataVencimentoOuPrazo(itemListaComissaoExterna, itemListaParcelaIrreg);
            
            if(!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getMensagem())) {
                itemListaParcelaIrreg.setDateVctopcelatrade(null);
                itemListaParcelaIrreg.setTdianegocpcela(Numeros.ZERO);
                NpcFacesUtils.addInfoModalMessage(itemListaParcelaIrreg.getMensagem(), EnumButtonBehavior.SUBMIT);
            }
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerTrocaDataVencimento <<<<<<<<<<<");
        }*/
            
    }
    
    /**
     * 
    	* Nome: listenerTrocaPrazo
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 19/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerTrocaPrazo(AjaxBehaviorEvent e) {
        itemListaParcelaIrreg.setDateVctopcelatrade(null);
        trocarPrazo(getItemListaComissaoExterna(), getItemListaParcelaIrreg());
        tratarBotoesManutencaoIrregular();
        
        /*try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerTrocaPrazo <<<<<<<<<<<");
            
            itemListaParcelaIrreg.setDateVctopcelatrade(null);
            
            //O vencimento da parcela deve ser maior que da anterior
            obterDtVencParcelaAnterior();
            
            comissaoInternaExternaModalService.calcularDataVencimentoOuPrazo(itemListaComissaoExterna, itemListaParcelaIrreg);
            
            if(!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getMensagem())) {
                itemListaParcelaIrreg.setDateVctopcelatrade(null);
                itemListaParcelaIrreg.setTdianegocpcela(Numeros.ZERO);
                NpcFacesUtils.addInfoModalMessage(itemListaParcelaIrreg.getMensagem(), EnumButtonBehavior.SUBMIT);
            }
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerTrocaPrazo <<<<<<<<<<<");
        }*/
        
    }
    
	/**
	* Nome: prepararManutencaoIrregular
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 13/10/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    private void prepararManutencaoIrregular() {

		  tratarBotoesManutencaoIrregular();
		  
          if (getItemListaComissaoExterna().getListaParcelasComissao().size() > Numeros.ZERO) {
              getItemListaComissaoExterna().getListaParcelasComissao().clear();
          }
    }
    
	/**
	* Nome: tratarBotoesManutencaoIrregular
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 13/10/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
	private void tratarBotoesManutencaoIrregular() {
			if (getItemListaComissaoExterna().getCperdcjurocmbio().equals(EnumCobrancaComissao.COBRANCA_A_A.getCodigo())
	                    || getItemListaComissaoExterna().getCperdcjurocmbio().equals(EnumCobrancaComissao.COBRANCA_FLAT.getCodigo())
	                    || getItemListaComissaoExterna().getCperdcjurocmbio().equals(EnumCobrancaComissao.COBRANCA_VALOR.getCodigo())) {
	          viewHelper.setDisabledBotaoGerar(Boolean.FALSE);
	      } else {
	          viewHelper.setDisabledBotaoGerar(Boolean.TRUE);
		  }
		  
		  // Botão Incluir Parcela Comissão Externa Irregular
		  if (getItemListaComissaoExterna().getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
			  if (getItemListaComissaoExterna().getCperdcjurocmbio() == EnumCobrancaComissao.COBRANCA_VALOR.getCodigo()) {
			   	  if (SiteUtil.isEmptyOrNull(getItemListaComissaoExterna().getVlxtotalcomis())) {
			   		  viewHelper.setDisabledBtoInclParcIrregComExt(Boolean.TRUE);
			   	  } else if ((!(SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(getItemListaComissaoExterna().getVlxtotalcomis())) > 0))) {
				   	  viewHelper.setDisabledBtoInclParcIrregComExt(Boolean.TRUE);
			   	  } else {
			   		  viewHelper.setDisabledBtoInclParcIrregComExt(Boolean.FALSE);
			   	  }
			  } else if ((getItemListaComissaoExterna().getCperdcjurocmbio() == EnumCobrancaComissao.COBRANCA_A_A.getCodigo()) 
					  || (getItemListaComissaoExterna().getCperdcjurocmbio() == EnumCobrancaComissao.COBRANCA_FLAT.getCodigo())) {
			   	  if ((SiteUtil.isEmptyOrNull(getItemListaComissaoExterna().getVlxtotalcomis()))) {
			   		  viewHelper.setDisabledBtoInclParcIrregComExt(Boolean.TRUE);
			   	  } else if ((!(SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(getItemListaComissaoExterna().getVlxtotalcomis())) > 0))) {
				   	  viewHelper.setDisabledBtoInclParcIrregComExt(Boolean.TRUE);
			   	  } else {
			   		  viewHelper.setDisabledBtoInclParcIrregComExt(Boolean.FALSE);
			   	  }
			  } else {
				  viewHelper.setDisabledBtoInclParcIrregComExt(Boolean.TRUE);
			  }
			  
		  	  if (getItemListaComissaoExterna().getListaParcelasComissao().size() > Numeros.ZERO) {
			   	  getViewHelper().setDisabledConfirmar(Boolean.FALSE);
			  } else {
			   	  getViewHelper().setDisabledConfirmar(Boolean.TRUE);
			  }
		  }
	}
	
    /************************************************************
     * FIM - METODOS TRATAMENTO PARA PERIODICIDADE IRREGULAR *
     ***********************************************************/

    public TrdFinNegComissaoVO getItemListaComissaoExterna() {
        return itemListaComissaoExterna;
    }

    public void setItemListaComissaoExterna(TrdFinNegComissaoVO itemListaComissaoExterna) {
        this.itemListaComissaoExterna = itemListaComissaoExterna;
    }

    public Integer getQtdeFluxoPgt() {
        return qtdeFluxoPgt;
    }

    public void setQtdeFluxoPgt(Integer qtdeFluxoPgt) {
        this.qtdeFluxoPgt = qtdeFluxoPgt;
    }

    public Integer getTdiafinandsemb() {
        return tdiafinandsemb;
    }

    public void setTdiafinandsemb(Integer tdiafinandsemb) {
        this.tdiafinandsemb = tdiafinandsemb;
    }

    public ComissaoCollection getListaComissaoExterna() {
        return listaComissaoExterna;
    }

    public void setListaComissaoExterna(ComissaoCollection listaComissaoExterna) {
        this.listaComissaoExterna = listaComissaoExterna;
    }

    /**
     * @return o valor do itemListaParcelaIrreg
     */
    public TrdFinNegParcelaVO getItemListaParcelaIrreg() {
        return itemListaParcelaIrreg;
    }

    /**
     * @param itemListaParcelaIrreg seta o novo valor para o campo itemListaParcelaIrreg
     */
    public void setItemListaParcelaIrreg(TrdFinNegParcelaVO itemListaParcelaIrreg) {
        this.itemListaParcelaIrreg = itemListaParcelaIrreg;
    }

    public Boolean getConfirmarManutencao() {
        return confirmarManutencao;
    }

    public void setConfirmarManutencao(Boolean confirmarManutencao) {
        this.confirmarManutencao = confirmarManutencao;
    }

    public List<TrdFinNegParcelaVO> getListaParcelasTemp() {
        return listaParcelasTemp;
    }

    public void setListaParcelasTemp(List<TrdFinNegParcelaVO> listaParcelasTemp) {
        this.listaParcelasTemp = listaParcelasTemp;
    }
    
}
