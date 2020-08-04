package br.com.bradesco.web.npcc_trade.view.bean.global.ComissaoIntManutModal;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.global.comissaoBase.ComissaoBaseBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named("comissaoIntManutModalBean")
@SessionScoped
public class ComissaoIntManutModalBean extends ComissaoBaseBean implements Serializable {
	
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 6849261367444749827L;

	private TrdFinNegComissaoVO itemListaComissaoInterna = new TrdFinNegComissaoVO();

    private TrdFinNegParcelaVO itemListaParcelaIrreg = new TrdFinNegParcelaVO();
	
	private List<TrdFinNegComissaoVO> listaComissaoInterna = new ArrayList<TrdFinNegComissaoVO>();
	
	private TrdFinNegFluxoPagtoVO fluxoPagamentoReferente = new TrdFinNegFluxoPagtoVO();
	
	private Boolean confirmarManutencao = Boolean.FALSE;
	
	private List<TrdFinNegParcelaVO> listaParcelasTemp = new ArrayList<TrdFinNegParcelaVO>();
	
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
    public void openModal(){
    	
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.openModal <<<<<<<<<<<");

            setConfirmarManutencao(Boolean.FALSE);
            viewHelper.setComboMomento(getSelectItemBean().getMomentoJuros(EnumTradeFinance.COMISSAO_INTERNA.getCodigo(), getViewHelper().getCodProduto()));
            viewHelper.setComboPeriodicidade(getSelectItemBean().getPeriodicidade(Numeros.ZERO));
            
            itemListaParcelaIrreg = new TrdFinNegParcelaVO();
            
            if(!listaParcelasTemp.isEmpty()){
            	itemListaComissaoInterna.getListaParcelasComissao().clear();
            	itemListaComissaoInterna.getListaParcelasComissao().addAll(listaParcelasTemp);
            }
            
            if (itemListaComissaoInterna.getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
                getViewHelper().setDisabledTxtParcelaComissaoInt(Boolean.FALSE);
            }
            
            getViewHelper().setRenderModalComissaoInterna(Boolean.TRUE);
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.openModal <<<<<<<<<<<");
        }
    }
	 
	 /**
     * Nome: listenerGerarParcelaComissaoInterna
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
    public void listenerGerarParcelaComissaoInterna(AjaxBehaviorEvent e) {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerGerarParcelaComissaoInterna <<<<<<<<<<<");
           
            if (getViewHelper().getCodProduto().equals(EnumProduto.LC_IMPORTACAO.getCodigo())
            		|| getViewHelper().getCodProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA.getCodigo())
            		|| getViewHelper().getCodProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO.getCodigo())) {
                
            	getItemListaComissaoInterna().setVprevtdsembcmbio(getViewHelper().getVnegocmoedaestrg());
            }        
            
            try {
            	
            	if (!conferirMomemtoUnico(getItemListaComissaoInterna())) {
                    return;
                }
                
            	getItemListaComissaoInterna().setVnegocmoedaestrg(getViewHelper().getVnegocmoedaestrg());
            	getItemListaComissaoInterna().setFuncao("A");
            	
            	getViewHelper().setStateIdListaParcelasComissao("NPCCIAH6");
                getComissaoInternaExternaModalService().getComissaoInterna(getItemListaComissaoInterna(), getFluxoPagamentoReferente());
            	
            } catch (NpccTradeWebException e2) {
            	NpcFacesUtils.addInfoModalMessage(e2.getMessage(), EnumButtonBehavior.SUBMIT);
            }
            
            getViewHelper().setDisabledConfirmar(Boolean.FALSE);
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerGerarParcelaComissaoInterna <<<<<<<<<<<");
        }
    	
    }
    
    /**
     * Nome: listenerTrocaPeriodicidadeComissaoInterna
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
    public void listenerTrocaPeriodicidadeComissaoInterna(AjaxBehaviorEvent e) {
    	
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerTrocaPeriodicidadeComissaoInterna <<<<<<<<<<<");
           
            trocarPeriodicidade(itemListaComissaoInterna, getItemListaParcelaIrreg());
            
            listenerTrocaPrazo(e);
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerTrocaPeriodicidadeComissaoInterna <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
    	* Nome: listenerComboMomento
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
    public void listenerComboMomento(AjaxBehaviorEvent e){
        
    	try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerComboMomento <<<<<<<<<<<");
            
            tratarComboMomento(itemListaComissaoInterna);

    	} finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerComboMomento <<<<<<<<<<<");
        }
    }
    
    /**
     * Nome: confirmaModalComissaoInterna
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
    public String confirmaModalComissaoInterna() {
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.confirmaModalComissaoInterna <<<<<<<<<<<");
    	    
    	    //TrdFinNegComissaoVO itemComissaoTemp = new TrdFinNegComissaoVO();
    	    
    	    if (getViewHelper().getFuncaoBotaoComissaoInterna().equals("Incluir")) {
    	    	
    	    	if(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo().equals(itemListaComissaoInterna.getCfluxoperdccmbio())
    	    			&& !verificaSomaParcela(getItemListaComissaoInterna())){
    	    		return null;
    	    	}
    	    	if (prepararManutComissaoInterna() == Boolean.FALSE) {
    	    		return null;
    	    	}
    	    	
    	    	// Adiciona os dados na lista.
    	    	getListaComissaoInterna().set(Integer.parseInt(getViewHelper().getLinhaSelecionada()), getItemListaComissaoInterna());
    	    }
    	    
    	    if (getViewHelper().getFuncaoBotaoComissaoInterna().equals("Alterar")) {
    	    	if(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo().equals(itemListaComissaoInterna.getCfluxoperdccmbio())
    	    			&& !verificaSomaParcela(getItemListaComissaoInterna())){
    	    		return null;
    	    	}
    	    	if (prepararManutComissaoInterna() == Boolean.FALSE) {
    	    		return null;
    	    	}
    	    	
    	    	// Altera os dados na lista.
    	    	getListaComissaoInterna().set(Integer.parseInt(getViewHelper().getLinhaSelecionada()), getItemListaComissaoInterna());
    	    }
    	    
    	    getListaParcelasTemp().clear();
    	    getListaParcelasTemp().addAll(getItemListaComissaoInterna().getListaParcelasComissao());
    	    
    	    setConfirmarManutencao(Boolean.TRUE);
    	    
    	    getViewHelper().setFuncaoBotaoComissaoInterna("");
    	    // Limpa a seleção dos itens da lista.
    	    getViewHelper().setLinhaSelecionada(null);
    	    
    	    getViewHelper().setDisabledBtoAltDetComInt(false);
    	    
    	    return "/content/global/comissaoIntModal/comissaoIntManutModalClose.xhtml";
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.confirmaModalComissaoInterna <<<<<<<<<<<");
    	}
    }
    
    /**
     * Nome: prepararManutComissaoInterna
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
    protected Boolean prepararManutComissaoInterna() {
    	
	    Integer codInteger = 0;
	    String descrCombo = null;
	    
	    if (conferirMomemtoUnico() == false) {
	    	return Boolean.FALSE;
	    }
	    
	    if (getItemListaComissaoInterna().getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
	    	if (getItemListaComissaoInterna().getListaParcelasComissao().size() <= Numeros.ZERO) {
	    		NpcFacesUtils.addInfoModalMessage("Parcelas não geradas.", EnumButtonBehavior.SUBMIT);
	    		return Boolean.FALSE;
	    	}
	    	
	    } else {
	    	
	    	// valida se foi selecionado um item na lista
	    	if (getItemListaComissaoInterna().getVprevtcomiscmbio() == null
	    			|| getItemListaComissaoInterna().getVprevtcomiscmbio().length() <= 0) {
	    		NpcFacesUtils.addInfoModalMessage("Dados modificados. Gerar parcelas.", EnumButtonBehavior.SUBMIT);
	    		return Boolean.FALSE;
	    	}
	    }
	    
	    getViewHelper().setRenderModalComissaoInterna(Boolean.FALSE);
	    
	    codInteger = getItemListaComissaoInterna().getCfluxoperdccmbio();
	    for (int i = 0; i < getViewHelper().getComboPeriodicidade().size(); i++) {
	    	if (getViewHelper().getComboPeriodicidade().get(i).getValue().equals(codInteger)) {
	    		descrCombo = getViewHelper().getComboPeriodicidade().get(i).getLabel();
	    		break;
	    	}
	    }
	    getItemListaComissaoInterna().setPeriodicidadeComissao(descrCombo);
	    
	    codInteger = getItemListaComissaoInterna().getCodMomentoComissao();
	    for (int i = 0; i < getViewHelper().getComboMomento().size(); i++) {
	    	if (getViewHelper().getComboMomento().get(i).getValue().equals(codInteger)) {
	    		descrCombo = getViewHelper().getComboMomento().get(i).getLabel();
	    		break;
	    	}
	    }
	    getItemListaComissaoInterna().setMomentoComissao(descrCombo);
	    
	    getItemListaComissaoInterna().setCcobrcomiscmbio(getViewHelper().getCodComissaoSobre());
	    
	    if (getItemListaComissaoInterna().getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
	    	geraTotalParcelasIrregular();
	    }
	    
	    return Boolean.TRUE;
    	    
    }

    /************************************************************
     * INICIO - METODOS TRATAMENTO PARA PERIODICIDADE IRREGULAR *
     ***********************************************************/

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
        
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerIncluirParcelaIrregular <<<<<<<<<<<");
    	    
    	    Boolean result = incluirParcelaIrregular(itemListaComissaoInterna, getItemListaParcelaIrreg());
    	    
    	    if(result) {
    	    	itemListaParcelaIrreg = new TrdFinNegParcelaVO();
    	    	try {
    	    		itemListaParcelaIrreg.setDateVctopcelatrade(SiteUtil.stringToDate(getItemListaComissaoInterna().getDataComissaoFormat(), "dd/MM/yyyy"));
    	    	} catch (ParseException ex) {
    	    		itemListaParcelaIrreg.setDateVctopcelatrade(null);
    	    	}
    	    }
    	    
    	    getViewHelper().setDisabledConfirmar(Boolean.FALSE);
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerIncluirParcelaIrregular <<<<<<<<<<<");
    	}
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
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerExcluirParcelaIrregular <<<<<<<<<<<");
    	    
    	    excluirParcelaIrregular(itemListaComissaoInterna);
    	    
    	    if (getItemListaComissaoInterna().getListaParcelasComissao().size() > Numeros.ZERO) {
    	    	getViewHelper().setDisabledConfirmar(Boolean.FALSE);
    	    } else {
    	    	getViewHelper().setDisabledConfirmar(Boolean.TRUE);
    	    }
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerExcluirParcelaIrregular <<<<<<<<<<<");
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
    public void listenerTrocaPrazo(AjaxBehaviorEvent e) {
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerTrocaPrazo <<<<<<<<<<<");
    	    
    	    itemListaParcelaIrreg.setDateVctopcelatrade(null);
    	    trocarPrazo(getItemListaComissaoInterna(), getItemListaParcelaIrreg());
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerTrocaPrazo <<<<<<<<<<<");
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
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerTrocaVencimento <<<<<<<<<<<");
    	   
    	    itemListaParcelaIrreg.setTdianegocpcela(null);
    	    trocarPrazo(getItemListaComissaoInterna(), getItemListaParcelaIrreg());
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerTrocaVencimento <<<<<<<<<<<");
    	}
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
    	* Registro  de Manutenção: 22/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerTrocaDataVencimento(AjaxBehaviorEvent e) {
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerTrocaDataVencimento <<<<<<<<<<<");
    	    
    	    trocarDataVencimento(getItemListaComissaoInterna(), getItemListaParcelaIrreg());
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerTrocaDataVencimento <<<<<<<<<<<");
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
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.getItensRadioListaParcelaComiss <<<<<<<<<<<");
    	    
    	    List<SelectItem> list = new ArrayList<SelectItem>();
    	    
    	    // Percorre todos os itens da lista afim de criar os respectivos radio
    	    // buttons
    	    for (int index = 0; index < getItemListaComissaoInterna().getListaParcelasComissao().size(); index++) {
    	    	list.add(new SelectItem(SiteUtil.getString(index), "", ""));
    	    }
    	    
    	    return list;
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.getItensRadioListaParcelaComiss <<<<<<<<<<<");
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
        
        for (Iterator<TrdFinNegParcelaVO> iterator = getItemListaComissaoInterna().
                        getListaParcelasComissao().iterator(); iterator.hasNext();) {
            itemParcela = (TrdFinNegParcelaVO) iterator.next();
            
            strValorParcela = SiteUtil.webMoedaToMainframe(itemParcela.getVpcelacomiscmbio());
            itemParcela.setVpcelacomiscmbio(strValorParcela);
            
            totalValorParcela += SiteUtil.webMoedaToDouble(itemParcela.getVpcelacomiscmbio());
        }
        totalValorParcela /= 100;
        getItemListaComissaoInterna().setVprevtcomiscmbio(SiteUtil.doubleToBrowserMoeda(totalValorParcela));
        getItemListaComissaoInterna().setQpcelacmbiotrade(getItemListaComissaoInterna().getListaParcelasComissao().size());
    }
    
    private boolean conferirMomemtoUnico() {
        if (getItemListaComissaoInterna().getCodMomentoComissao().equals
                        (EnumTradeFinance.MOMENTO_UNICO.getCodigo()) == true &&
                        getItemListaComissaoInterna().getCfluxoperdccmbio().equals
                        (EnumTradeFinance.PERIODICIDADE_FINAL.getCodigo()) == false) {
            NpcFacesUtils.addInfoModalMessage("Momento Único somente para a periodicidade Final", EnumButtonBehavior.SUBMIT);
            return false;
        }
        
        return true;
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
    	* Registro  de Manutenção: 21/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerVerificaTotalParcela(AjaxBehaviorEvent e) {
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoIntManutModalBean.listenerVerificaTotalParcela <<<<<<<<<<<");
    	    
    	    verificaTotalParcela(getItemListaComissaoInterna(), getItemListaParcelaIrreg());
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoIntManutModalBean.listenerVerificaTotalParcela <<<<<<<<<<<");
    	}
    }
    
    
    /************************************************************
     * FIM - METODOS TRATAMENTO PARA PERIODICIDADE IRREGULAR *
     ***********************************************************/

	public TrdFinNegComissaoVO getItemListaComissaoInterna() {
		return itemListaComissaoInterna;
	}

	public void setItemListaComissaoInterna(
			TrdFinNegComissaoVO itemListaComissaoInterna) {
		this.itemListaComissaoInterna = itemListaComissaoInterna;
	}

	public List<TrdFinNegComissaoVO> getListaComissaoInterna() {
		return listaComissaoInterna;
	}

	public void setListaComissaoInterna(
			List<TrdFinNegComissaoVO> listaComissaoInterna) {
		this.listaComissaoInterna = listaComissaoInterna;
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

    public List<TrdFinNegParcelaVO> getListaParcelasTemp() {
        return listaParcelasTemp;
    }

    public void setListaParcelasTemp(List<TrdFinNegParcelaVO> listaParcelasTemp) {
        this.listaParcelasTemp = listaParcelasTemp;
    }

    public Boolean getConfirmarManutencao() {
        return confirmarManutencao;
    }

    public void setConfirmarManutencao(Boolean confirmarManutencao) {
        this.confirmarManutencao = confirmarManutencao;
    }

    /**
     * @return o valor do fluxoPagamentoReferente
     */
    public TrdFinNegFluxoPagtoVO getFluxoPagamentoReferente() {
        return fluxoPagamentoReferente;
    }

    /**
     * @param fluxoPagamentoReferente seta o novo valor para o campo fluxoPagamentoReferente
     */
    public void setFluxoPagamentoReferente(TrdFinNegFluxoPagtoVO fluxoPagamentoReferente) {
        this.fluxoPagamentoReferente = fluxoPagamentoReferente;
    }

}
