package br.com.bradesco.web.npcc_trade.view.bean.global.comissaoBase;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.comissaoIntExtModal.IComissaoInternaExternaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

public abstract class ComissaoBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -1069670811737975624L;
    
    protected ComissaoViewHelper viewHelper = new ComissaoViewHelper();
    
    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;
    
    @Inject
    @Named("comissaoInternaExternaModalService")
    private IComissaoInternaExternaModalService comissaoInternaExternaModalService;
    
    /**
     * 
    	* Nome: gerarParcelas
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
    protected void gerarParcelas(TrdFinNegComissaoVO comissaoVO){
        
        if (!conferirMomemtoUnico(comissaoVO)) {
            return;
        }
        
        comissaoInternaExternaModalService.gerarParcelasComissaoExterna(comissaoVO);
        
    }

    /**
     * 
    	* Nome: conferirMomemtoUnico
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
    protected boolean conferirMomemtoUnico(TrdFinNegComissaoVO comissaoVO) {
        if (comissaoVO.getCodMomentoComissao().equals
                        (EnumTradeFinance.MOMENTO_UNICO.getCodigo()) == true &&
                        comissaoVO.getCfluxoperdccmbio().equals
                        (EnumTradeFinance.PERIODICIDADE_FINAL.getCodigo()) == false) {
            NpcFacesUtils.addInfoModalMessage("Momento Único somente para a periodicidade Final", EnumButtonBehavior.SUBMIT);
            return false;
        }
        
        return true;
    }
    
    /**
     * 
    	* Nome: obterDtVencParcelaAnterior
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
    public void obterDtVencParcelaAnterior(TrdFinNegComissaoVO comissaoVO, TrdFinNegParcelaVO itemListaParcelaIrreg){
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoBaseBean.obterDtVencParcelaAnterior <<<<<<<<<<<");
    	    
    	    if(comissaoVO.getListaParcelasComissao() != null && !comissaoVO.getListaParcelasComissao().isEmpty()){
    	    	TrdFinNegParcelaVO parcela = comissaoVO.getListaParcelasComissao().get(comissaoVO.getListaParcelasComissao().size() - 1);
    	    	itemListaParcelaIrreg.setVencimentoComissao(parcela.getVencimentoComissao());
    	    }else{
    	    	//Caso não tenha parcela incluída, a primeira deve passar como parametro a data de previsao de desembolso
    	    	if (SiteUtil.isEmptyOrNull(comissaoVO.getDataComissaoFormat())) {
    	    		itemListaParcelaIrreg.setVencimentoComissao(comissaoVO.getDprevtdsembcmbio());
    	    	} else {
        	    	itemListaParcelaIrreg.setVencimentoComissao(comissaoVO.getDataComissaoFormat());
    	    		
    	    	}
    	    }
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoBaseBean.obterDtVencParcelaAnterior <<<<<<<<<<<");
    	}
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
    protected boolean verificaTotalParcela(TrdFinNegComissaoVO comissaoVO, TrdFinNegParcelaVO itemListaParcelaIrreg) {
        Boolean valido = Boolean.TRUE;
        if (!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getVpcelacomiscmbio()) 
                && !SiteUtil.isValueZero(itemListaParcelaIrreg.getVpcelacomiscmbio())) {
            
            Double valorSoma = SiteUtil.webMoedaToDouble(itemListaParcelaIrreg.getVpcelacomiscmbio());
            Double valorTotal = SiteUtil.webMoedaToDouble(comissaoVO.getVlxtotalcomis());
                                                                                
            if(valorSoma.compareTo(valorTotal) <= 0){
                for(TrdFinNegParcelaVO negParcelaVO : comissaoVO.getListaParcelasComissao()){
                    valorSoma += SiteUtil.webMoedaToDouble(negParcelaVO.getVpcelacomiscmbio());
                    
                    if(valorSoma.compareTo(valorTotal) > 0){
                        NpcFacesUtils.addInfoModalMessage("Soma dos valores das parcelas não deve ser superior ao Valor Total.", EnumButtonBehavior.SUBMIT);
                        valido = Boolean.FALSE;
                    }
                }
            }else{
                NpcFacesUtils.addInfoModalMessage("Valor superior ao Valor Total.", EnumButtonBehavior.SUBMIT);
                valido = Boolean.FALSE;
            }
        }
        
        return valido;
    }
    
    /**
     * 
    	* Nome: verificaPrazo
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 04/10/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private boolean verificaPrazo(TrdFinNegComissaoVO comissaoVO, TrdFinNegParcelaVO itemListaParcelaIrreg){
        boolean valido = Boolean.TRUE;
        
        Integer prazoSoma = itemListaParcelaIrreg.getTdianegocpcela();
        Integer prazoTotal = comissaoVO.getTdiaopercmbio();
        
        if(prazoSoma.compareTo(prazoTotal) <= 0){
            for(TrdFinNegParcelaVO negParcelaVO : comissaoVO.getListaParcelasComissao()){
                prazoSoma += negParcelaVO.getTdianegocpcela();
                
                if(prazoSoma.compareTo(prazoTotal) > 0){
                    NpcFacesUtils.addInfoModalMessage("Soma dos prazos das parcelas não deve ser superior ao Prazo Operação.", EnumButtonBehavior.SUBMIT);
                    valido = Boolean.FALSE;
                    break;
                }
            }
        }else{
            NpcFacesUtils.addInfoModalMessage("Prazo superior ao Prazo Operação.", EnumButtonBehavior.SUBMIT);
            valido = Boolean.FALSE;
        }
        return valido;
    }
    
    /**
     * 
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
    	* Registro  de Manutenção: 21/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void excluirParcelaIrregular(TrdFinNegComissaoVO comissaoVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoBaseBean.excluirParcelaIrregular <<<<<<<<<<<");
            
            TrdFinNegParcelaVO itemParcela = null;
            
            // valida se foi selecionado um item na lista
            if (SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaParcelaComiss())) {
                NpcFacesUtils.addInfoModalMessage("Selecione um registro.", EnumButtonBehavior.SUBMIT);
                return;
            }
            
            itemParcela = comissaoVO.getListaParcelasComissao().get(Integer.parseInt(getViewHelper().getItemSelecListaParcelaComiss()));
            
            // Remove o item selecionado.
            comissaoVO.getListaParcelasComissao().remove(itemParcela);
            
            getViewHelper().setItemSelecListaParcelaComiss(null);
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoBaseBean.excluirParcelaIrregular <<<<<<<<<<<");
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
    	* Registro  de Manutenção: 21/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    protected void trocarPrazo(TrdFinNegComissaoVO comissaoVO, TrdFinNegParcelaVO itemListaParcelaIrreg) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoBaseBean.trocarPrazo <<<<<<<<<<<");
            
            //O vencimento da parcela deve ser maior que da anterior
            obterDtVencParcelaAnterior(comissaoVO, itemListaParcelaIrreg);
            
            comissaoInternaExternaModalService.calcularDataVencimentoOuPrazo(comissaoVO, itemListaParcelaIrreg);
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoBaseBean.trocarPrazo <<<<<<<<<<<");
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
    public void trocarPeriodicidade(TrdFinNegComissaoVO comissaoVO, TrdFinNegParcelaVO itemListaParcelaIrreg) {
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoBaseBean.trocarPeriodicidade <<<<<<<<<<<");
    	    
    	    comissaoVO.setListaParcelasComissao(new ArrayList<TrdFinNegParcelaVO>());
    	    
    	    comissaoVO.setQpcelacmbiotrade(null);
    	    if (comissaoVO.getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
    	    	getViewHelper().setDisabledTxtParcelaComissaoInt(Boolean.FALSE);
    	    	viewHelper.setDisabledBotaoGerar(Boolean.TRUE);
    	    	itemListaParcelaIrreg = new TrdFinNegParcelaVO();
    	    	getViewHelper().setDisabledValorTaxaQuandoIrregular(Boolean.FALSE);
    	    } else {
    	    	getViewHelper().setDisabledTxtParcelaComissaoInt(Boolean.TRUE);
    	    	viewHelper.setDisabledBotaoGerar(Boolean.FALSE);
    	    	comissaoVO.setVprevtcomiscmbio(null);
    	    }
    	    
    	    conferirMomemtoUnico(comissaoVO);
    	    tratarPeriodo(comissaoVO);
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoBaseBean.trocarPeriodicidade <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: tratarPeriodo
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
    protected void tratarPeriodo(TrdFinNegComissaoVO comissaoVO){
        if(comissaoVO.getCfluxoperdccmbio().equals(Numeros.DOZE)){
            
            for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
                if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.UM)){
                    //Remover a opção 'Antecipado' no combo quando for produto ECA
                    getViewHelper().getComboMomento().remove(i);
                    break;
                }
            }
        } else if (comissaoVO.getCfluxoperdccmbio().equals(Numeros.CATORZE)) {
            for(int i=0; i < getViewHelper().getComboMomento().size(); i++){
                if(getViewHelper().getComboMomento().get(i).getValue().equals(Numeros.DOIS)){
                    //Remover a opção 'Postecipado' no combo quando for produto ECA
                    getViewHelper().getComboMomento().remove(i);
                    break;
                }
            }
		} else {
            getViewHelper().setComboMomento(selectItemBean.getMomentoJuros(EnumTradeFinance.COMISSAO_EXTERNA.getCodigo(), getViewHelper().getCodProduto()));
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
    public void tratarComboMomento(TrdFinNegComissaoVO comissaoVO){
    	
    	try {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoBaseBean.tratarComboMomento <<<<<<<<<<<");
    	    
    	    if (comissaoVO.getCfluxoperdccmbio().equals
    	    		(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) == false) {
    	    	getViewHelper().setDisabledBotaoGerar(Boolean.FALSE);
    	    	comissaoVO.setVprevtcomiscmbio(null);
    	    }
    	    
    	    conferirMomemtoUnico(comissaoVO);
    	    tratarMomento(comissaoVO);
    	    
    	} finally {
    	    BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoBaseBean.tratarComboMomento <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: tratarMomento
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
    private void tratarMomento(TrdFinNegComissaoVO comissaoVO){
        if(comissaoVO.getCodMomentoComissao().equals(Numeros.UM)){
            
            for(int i=0; i < getViewHelper().getComboPeriodicidade().size(); i++){
                if(getViewHelper().getComboPeriodicidade().get(i).getValue().equals(Numeros.DOZE)){
                    //Remover a opção 'Final' no combo
                    getViewHelper().getComboPeriodicidade().remove(i);
                    break;
                }
            }
        }else{
            getViewHelper().setComboPeriodicidade(selectItemBean.getPeriodicidade(0));
        }
            
        
    }
    
    /**
     * 
    	* Nome: trocarDataVencimento
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
    public void trocarDataVencimento(TrdFinNegComissaoVO comissaoVO, TrdFinNegParcelaVO itemListaParcelaIrreg) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoBaseBean.trocarDataVencimento <<<<<<<<<<<");
            
            itemListaParcelaIrreg.setTdianegocpcela(null);
            
            //O vencimento da parcela deve ser maior que da anterior
            obterDtVencParcelaAnterior(comissaoVO, itemListaParcelaIrreg);
            
            comissaoInternaExternaModalService.calcularDataVencimentoOuPrazo(comissaoVO, itemListaParcelaIrreg);
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoBaseBean.trocarDataVencimentoS <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
    	* Nome: incluirParcelaIrregular
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
    public Boolean incluirParcelaIrregular(TrdFinNegComissaoVO comissaoVO, TrdFinNegParcelaVO itemListaParcelaIrreg) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ComissaoBaseBean.incluirParcelaIrregular <<<<<<<<<<<");

            if (SiteUtil.isEmptyOrNull(comissaoVO.getQpcelacmbiotrade())||
                            comissaoVO.getQpcelacmbiotrade() <= Numeros.NUM0) {
                NpcFacesUtils.addInfoModalMessage("Campo Parcelas inválido.", EnumButtonBehavior.SUBMIT);
                return Boolean.FALSE;
            } else {
                if (comissaoVO.getListaParcelasComissao().size() >= comissaoVO.getQpcelacmbiotrade()) {
                    NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas já incluídas.", EnumButtonBehavior.SUBMIT);
                    return Boolean.FALSE;
                }
            }
            
//            if (SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getTdianegocpcela())||
//                itemListaParcelaIrreg.getTdianegocpcela() <= Numeros.NUM0) {
//                NpcFacesUtils.addInfoModalMessage("Prazo inválido.", EnumButtonBehavior.SUBMIT);
//                return Boolean.FALSE;
//            }
            if(!verificaPrazo(comissaoVO, itemListaParcelaIrreg)){
                return Boolean.FALSE;
            }
                    
            itemListaParcelaIrreg.setDvctopcelatrade(SiteUtil.dateToString(itemListaParcelaIrreg.
                    getDateVctopcelatrade(), "dd.MM.yyyy"));
            if (SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getDvctopcelatrade()) == true) {
                NpcFacesUtils.addInfoModalMessage("Vencimento inválido.", EnumButtonBehavior.SUBMIT);
                return Boolean.FALSE;
            }
                    
            if(!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getMensagem())) {
                NpcFacesUtils.addInfoModalMessage(itemListaParcelaIrreg.getMensagem(), EnumButtonBehavior.SUBMIT);
                return Boolean.FALSE;
            }
            
            itemListaParcelaIrreg.setVenctoFluxDate(itemListaParcelaIrreg.getDateVctopcelatrade());
            
            itemListaParcelaIrreg.setVencimentoComissao(SiteUtil.trocarPontoPorBarra(
                    itemListaParcelaIrreg.getDvctopcelatrade()));
            
            if ((SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getVpcelacomiscmbio()) 
                    || SiteUtil.isValueZero(itemListaParcelaIrreg.getVpcelacomiscmbio()))) {
                
                NpcFacesUtils.addInfoModalMessage("Valor inválido.", EnumButtonBehavior.SUBMIT);
                return Boolean.FALSE;
            }
            
            // Valida somatória das parcelas
            else if (verificaTotalParcela(comissaoVO, itemListaParcelaIrreg)){
            
                itemListaParcelaIrreg.setValorParcelaComissao(itemListaParcelaIrreg.getVpcelacomiscmbio());
                
                comissaoVO.getListaParcelasComissao().add(itemListaParcelaIrreg);
                
                ordenarListaParcelas(comissaoVO);
                
                if (comissaoVO.getListaParcelasComissao().size() > 10) {
                    SiteUtil.reiniciarPaginacao();
                }
            } else {
                return Boolean.FALSE;
            }
            
            return Boolean.TRUE;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ComissaoBaseBean.incluirParcelaIrregular <<<<<<<<<<<");
        }
        
    }
   
    /**
     * 
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
    	* Registro  de Manutenção: 21/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private void ordenarListaParcelas(TrdFinNegComissaoVO comissaoVO) {
        int numParcela = 1;

        //Collections.sort(comissaoVO.getListaParcelasComissao());

        numParcela = 1;
        for (TrdFinNegParcelaVO item : comissaoVO.getListaParcelasComissao()) {
            item.setNpcelacomis(numParcela++);
        }
        
    }
   
    /**
     * 
    	* Nome: verificaSomaParcela
    	* 
    	* Propósito: O valor total das parcelas deve ser sempre igual ao Valor Total
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
    protected Boolean verificaSomaParcela(TrdFinNegComissaoVO comissaoVO) {
        Double valorTotal = SiteUtil.webMoedaToDouble(comissaoVO.getVlxtotalcomis());
        Double valorSoma = new Double(0);
        
        for(TrdFinNegParcelaVO negParcelaVO : comissaoVO.getListaParcelasComissao()){    
            
            valorSoma += SiteUtil.webMoedaToDouble(negParcelaVO.getValorParcelaComissao());
        }
        
        if(valorSoma.compareTo(valorTotal) != 0){
            NpcFacesUtils.addInfoModalMessage("Soma dos valores das parcelas deve ser igual ao Valor Total.", EnumButtonBehavior.SUBMIT);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
    public SelectItemBean getSelectItemBean() {
        return selectItemBean;
    }

    public void setSelectItemBean(SelectItemBean selectItemBean) {
        this.selectItemBean = selectItemBean;
    }

    public ComissaoViewHelper getViewHelper() {
        return viewHelper;
    }

    public void setViewHelper(ComissaoViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do comissaoInternaExternaModalService
     */
    public IComissaoInternaExternaModalService getComissaoInternaExternaModalService() {
        return comissaoInternaExternaModalService;
    }

    /**
     * @param comissaoInternaExternaModalService seta o novo valor para o campo comissaoInternaExternaModalService
     */
    public void setComissaoInternaExternaModalService(IComissaoInternaExternaModalService comissaoInternaExternaModalService) {
        this.comissaoInternaExternaModalService = comissaoInternaExternaModalService;
    }
    
}
