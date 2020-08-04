package br.com.bradesco.web.npcc_trade.view.bean.global.modeloBoletoModalbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.modeloBoletoModal.IModeloBoletoModalService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.TradeFinanceBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named(value = "modeloBoletoModalBean")
@SessionScoped
public class ModeloBoletoModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 3169166732668927612L;
	
	private ModeloBoletoModalViewHelper viewHelper = new ModeloBoletoModalViewHelper();
	
	private ModeloBoletoVO modeloBoletoVO = new ModeloBoletoVO();
	
	private List<ModeloBoletoVO> listaModBoleto = new ArrayList<ModeloBoletoVO>();
	
	@Inject
    @Named("modeloBoletoModalService")
    private IModeloBoletoModalService boletoModalService;
	
	/**
     * Nome: pesquisarModelBolPorNome
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
    public void pesquisarModelBolPorNome() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoModalBean.pesquisarModelBolPorNome <<<<<<<<<<<");
    	
    		getListaModBoleto().clear();
    		
   			if (SiteUtil.isEmptyOrNull(getBoletoVO().getImodcontrcmbio())) {
    			NpcFacesUtils.addInfoModalMessage("Preencha o campo para pesquisa.", false);
    			return;
    		}
    		
    		getViewHelper().getTitulo();
    		getViewHelper().setItemSelecListaModelBol(null);
    		
    		getViewHelper().setNomeStateIdListaSelModelBol("NPCDIAOO");
    		
    		setListaModBoleto(boletoModalService.getListaModBoleto(modeloBoletoVO));
    		
    		//getViewHelper().setRenderModal(Boolean.TRUE);
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoModalBean.pesquisarModelBolPorNome <<<<<<<<<<<");
    	}	
    
    }
 
    /**
     * Nome: getSelectItemRadioListaModelBol
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public List<SelectItem> getSelectItemRadioListaModelBol() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoModalBean.getSelectItemRadioListaModelBol <<<<<<<<<<<");
    	
    		List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
    		
    		SiteUtil.atualizarSelectItem(getListaModBoleto(), selectItemRadioLista);
    		
    		return selectItemRadioLista;
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoModalBean.getSelectItemRadioListaModelBol <<<<<<<<<<<");
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
     */
    public void closeModal(ActionEvent event){
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoModalBean.closeModal <<<<<<<<<<<");
    	
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoModalBean.closeModal <<<<<<<<<<<");
    	}	
    	
    }
    
    /**
     * Nome: selecionarModelBol
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public String selecionarModelBol() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoModalBean.selecionarModelBol <<<<<<<<<<<");
    	
    		// valida se foi selecionado um item na lista
    		if (viewHelper.getItemSelecListaModelBol() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return null;
    		}
    		
    		viewHelper.setIsConfirmar(Boolean.TRUE);
    		
    		// Salva os dados do ModelBol para uso nos outros serviços
    		modeloBoletoVO.setImodcontrcmbio(getListaModBoleto().get(viewHelper.getItemSelecListaModelBol()).getImodcontrcmbio());
    		modeloBoletoVO.setCmodcontrcmbio(getListaModBoleto().get(viewHelper.getItemSelecListaModelBol()).getCmodcontrcmbio());
   			
   			//tradeFinNegocVO.cmodcontrcmbio
    		
    		return "/content/global/modeloBoletoModal/modalModalBolListClose.xhtml";
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoModalBean.selecionarModelBol <<<<<<<<<<<");
    	}	

    }
    
    /**
     * Nome: paginarModalBol
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void paginarModalBol(ActionEvent event) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoModalBean.paginarModalBol <<<<<<<<<<<");
    	
    		setListaModBoleto(boletoModalService.getListaModBoleto(modeloBoletoVO));
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoModalBean.paginarModalBol <<<<<<<<<<<");
    	}	
    	
    }
    
	/**
     * Nome: getModeloBoletoPadrao
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
    public ModeloBoletoVO getModeloBoletoPadrao() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoModalBean.getModeloBoletoPadrao <<<<<<<<<<<");
    	
    		List<ModeloBoletoVO> listModeloBoletoboleto = boletoModalService.getListaModBoleto(modeloBoletoVO);
    		for (ModeloBoletoVO modeloBoletoVO : listModeloBoletoboleto) {
				if(modeloBoletoVO.getCindcdmodpdrao())
					return modeloBoletoVO;
			}
    		return null;
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoModalBean.getModeloBoletoPadrao <<<<<<<<<<<");
    	}	
    
    }
    
	public ModeloBoletoModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(ModeloBoletoModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public List<ModeloBoletoVO> getListaModBoleto() {
		return listaModBoleto;
	}

	public void setListaModBoleto(List<ModeloBoletoVO> listaModBoleto) {
		this.listaModBoleto = listaModBoleto;
	}

	public ModeloBoletoVO getBoletoVO() {
		return modeloBoletoVO;
	}

	public void setBoletoVO(ModeloBoletoVO modeloBoletoVO) {
		this.modeloBoletoVO = modeloBoletoVO;
	}

	
}
