package br.com.bradesco.web.npcc_trade.view.bean.global.unidadeExternaModalbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.IUnidadeExternaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named(value = "unidadeExternaModalBean")
@SessionScoped
public class UnidadeExternaModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 3169166732668927612L;
	
	private UnidadeExternaModalViewHelper viewHelper = new UnidadeExternaModalViewHelper();
	
	private UnidadeExternaVO externaVO = new UnidadeExternaVO();
	
	private List<UnidadeExternaVO> listaUniExterna = new ArrayList<UnidadeExternaVO>();
	
	@Inject
    @Named("unidadeExternaModalService")
    private IUnidadeExternaModalService externaModalService;
	
	/**
     * Nome: pesquisarUnidExtPorNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisarUnidExtPorNome() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] UnidadeExternaModalBean.pesquisarUnidExtPorNome <<<<<<<<<<<");
    	
    		getListaUniExterna().clear();
    		
    		if (getViewHelper().getModalidade().equals(Numeros.UM)) {
    			if (getExternaVO().getBancocorr() != null && getExternaVO().getBancocorr().length() <= 0) {
    				NpcFacesUtils.addInfoModalMessage("Preencha o campo para pesquisa.", false);
    				return;
    			}
    		}
    		else if (getViewHelper().getModalidade().equals(Numeros.DOIS)) {
    			if (getExternaVO().getBancodesemb() != null && getExternaVO().getBancodesemb().length() <= 0) {
    				NpcFacesUtils.addInfoModalMessage("Preencha o campo para pesquisa.", false);
    				return;
    			}
    		}
    		else if (getViewHelper().getModalidade().equals(Numeros.TRES)) {
    			if (getExternaVO().getBancoaviso() != null && getExternaVO().getBancoaviso().length() <= 0) {
    				NpcFacesUtils.addInfoModalMessage("Preencha o campo para pesquisa.", false);
    				return;
    			}
    		}
    		else if (getViewHelper().getModalidade().equals(Numeros.QUATRO)) {
    			if (getExternaVO().getBancoindica() != null && getExternaVO().getBancoindica().length() <= 0) {
    				NpcFacesUtils.addInfoModalMessage("Preencha o campo para pesquisa.", false);
    				return;
    			}
    		}
    		else if (getViewHelper().getModalidade().equals(Numeros.CINCO)) {
    			if (getExternaVO().getIbanqrcmbio() != null && getExternaVO().getIbanqrcmbio().length() <= 0) {
    				NpcFacesUtils.addInfoModalMessage("Preencha o campo para pesquisa.", false);
    				return;
    			}
    		}
    		
    		getViewHelper().getTitulo();
    		getViewHelper().setItemSelecListaUnidExt(null);
    		
    		getViewHelper().setNomeStateIdListaSelUnidExt("NPCDIADP");
    		
    		setListaUniExterna(externaModalService.getListaUniExterna(externaVO, getViewHelper().getModalidade()));
    		
    		getViewHelper().setRenderModal(Boolean.TRUE);
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] UnidadeExternaModalBean.pesquisarUnidExtPorNome <<<<<<<<<<<");
    	}	
    
    }
 
    /**
     * Nome: getSelectItemRadioListaUnidExt
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioListaUnidExt() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] UnidadeExternaModalBean.getSelectItemRadioListaUnidExt <<<<<<<<<<<");
    	
    		List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
    		
    		SiteUtil.atualizarSelectItem(getListaUniExterna(), selectItemRadioLista);
    		
    		return selectItemRadioLista;
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] UnidadeExternaModalBean.getSelectItemRadioListaUnidExt <<<<<<<<<<<");
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
    	* Registro  de Manutenção: 18/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event){
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] UnidadeExternaModalBean.closeModal <<<<<<<<<<<");
    	
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] UnidadeExternaModalBean.closeModal <<<<<<<<<<<");
    	}	
    	
    }
    
    /**
     * Nome: selecionarUnidExt
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String selecionarUnidExt() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] UnidadeExternaModalBean.selecionarUnidExt <<<<<<<<<<<");
    	
    		// valida se foi selecionado um item na lista
    		if (viewHelper.getItemSelecListaUnidExt() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return null;
    		}
    		
    		viewHelper.setIsConfirmar(Boolean.TRUE);
    		
    		// Salva os dados do UnidExt para uso nos outros serviços
    		if (getViewHelper().getModalidade().equals(Numeros.UM)) {
    			externaVO.setBancocorr(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getIbanqrcmbio());
    			externaVO.setCbancoocrr(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCbanqrcmbio());
    		}
    		else if (getViewHelper().getModalidade().equals(Numeros.DOIS)) {
    			externaVO.setBancodesemb(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getIbanqrcmbio());
    			externaVO.setCbancodesemb(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCbanqrcmbio());
    			externaVO.setCbancoocrr(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCbanqrcmbio());
    		}
    		else if (getViewHelper().getModalidade().equals(Numeros.TRES)) {
    			externaVO.setBancoaviso(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getIbanqrcmbio());
    			externaVO.setCbancoaviso(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCbanqrcmbio());
    		}
    		else if (getViewHelper().getModalidade().equals(Numeros.QUATRO)) {
    			externaVO.setBancoindica(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getIbanqrcmbio());
    			externaVO.setCbancoindica(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCbanqrcmbio());
    		}
    		
    		externaVO.setIbanqrcmbio(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getIbanqrcmbio());
    		externaVO.setCbanqrcmbio(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCbanqrcmbio());
    		externaVO.setCmunintlcmbio(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCmunintlcmbio());
    		externaVO.setImunintlcmbio(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getImunintlcmbio());
    		externaVO.setCpais(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCpais());
    		externaVO.setIpais(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getIpais());
    		externaVO.setCidbanqrswift(getListaUniExterna().get(viewHelper.getItemSelecListaUnidExt()).getCidbanqrswift());
    		
    		return "/content/global/unidadeExternaModal/modalUnidExtListClose.xhtml";
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] UnidadeExternaModalBean.selecionarUnidExt <<<<<<<<<<<");
    	}	

    }
    
    /**
     * Nome: paginarUnidExt
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginarUnidExt(ActionEvent event) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] UnidadeExternaModalBean.paginarUnidExt <<<<<<<<<<<");
    	
    		setListaUniExterna(externaModalService.getListaUniExterna(externaVO, getViewHelper().getModalidade()));
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] UnidadeExternaModalBean.paginarUnidExt <<<<<<<<<<<");
    	}	
    	
    }
    
	public UnidadeExternaModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(UnidadeExternaModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public List<UnidadeExternaVO> getListaUniExterna() {
		return listaUniExterna;
	}

	public void setListaUniExterna(List<UnidadeExternaVO> listaUniExterna) {
		this.listaUniExterna = listaUniExterna;
	}

	public UnidadeExternaVO getExternaVO() {
		return externaVO;
	}

	public void setExternaVO(UnidadeExternaVO externaVO) {
		this.externaVO = externaVO;
	}

	
}
