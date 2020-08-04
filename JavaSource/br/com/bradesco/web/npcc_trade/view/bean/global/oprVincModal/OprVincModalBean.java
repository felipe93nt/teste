package br.com.bradesco.web.npcc_trade.view.bean.global.oprVincModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.oprVincModal.impl.OprVincModalServiceImpl;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named("oprVincModalBean")
@SessionScoped
public class OprVincModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = -8478897192118812144L;
	
	private TrdFinNegOperVincVO operVinculadasVO =  new TrdFinNegOperVincVO();
	
	private List<TrdFinNegOperVincVO> listaModalOperVinculadas = new ArrayList<TrdFinNegOperVincVO>();
	
	private List<TrdFinNegOperVincVO> listaOperacaoVinculada = new ArrayList<TrdFinNegOperVincVO>();
	
	private OprVincModalViewHelper viewHelper = new OprVincModalViewHelper();
	
	
	@Inject
    @Named("oprVincModalService")
    protected OprVincModalServiceImpl oprVincModalService;
	
	/**
     * Nome: pesquisaOperacoesVinculadas
     * 
     * Propósito: Metodo do botão pesquisar do modal de operação vinculadas
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
    public void pesquisarOperacoesVinculadas(AjaxBehaviorEvent event) {
    	
    	try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] OprVincModalBean.pesquisarOperacoesVinculadas <<<<<<<<<<<");
            
            getOperVinculadasVO().setNumoperacao(Numeros.NUM0);
            
            getViewHelper().setStateIdListaModalOperVinculadas("NPCCIAPC");
            setListaModalOperVinculadas(oprVincModalService.getOperacoesVinculadas(getOperVinculadasVO()));
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] OprVincModalBean.pesquisarOperacoesVinculadas <<<<<<<<<<<");
        }
    	
    }
	
	/**
     * Nome: selecionarModalOperacoesVinculadas
     * 
     * Propósito: Metodo para selecionar operações vinculadas no modal
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
    public String selecionarModalOperacoesVinculadas() {
    	
    	try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] OprVincModalBean.selecionarModalOperacoesVinculadas <<<<<<<<<<<");
            
            int item = Numeros.ZERO;
            
            // valida se foi selecionado um item na lista
            if (getViewHelper().getItemSelecListaModalOperVinculadas() == null
            		|| getViewHelper().getItemSelecListaModalOperVinculadas().length <= Numeros.ZERO) {
            	NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            	return null;
            }
            
            for (int i = 0; i < getViewHelper().getItemSelecListaModalOperVinculadas().length; i++) {
            	
            	item = getViewHelper().getItemSelecListaModalOperVinculadas()[i];
            	
            	for (TrdFinNegOperVincVO trdFinNegOperVincVO : getListaOperacaoVinculada()) {
        			if(getListaModalOperVinculadas().get(item).getNbletocmbioano().equals(trdFinNegOperVincVO.getNbletocmbioano())){
        				NpcFacesUtils.addInfoModalMessage("Operação "+ trdFinNegOperVincVO.getNbletocmbioano() +" já incluída.", false);
            			return null;
        			}
    			}
            	
            	getListaOperacaoVinculada().add(getListaModalOperVinculadas().get(item));
            }
            
            return "/content/global/oprVincModal/oprVincModalClose.xhtml";
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] OprVincModalBean.selecionarModalOperacoesVinculadas <<<<<<<<<<<");
        }
    	
    }
    
    /**
     * Nome: closeModalOperacoesVinculadas
     * 
     * Propósito: Metodo para fechar o modal de operações vinculadas
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
    public void closeModalOperacoesVinculadas(ActionEvent event) {
    	
    	try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] OprVincModalBean.closeModalOperacoesVinculadas <<<<<<<<<<<");
            
            // desabilita modal
            getViewHelper().setRenderModalOperacoesVinculadas(Boolean.FALSE);
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] OprVincModalBean.closeModalOperacoesVinculadas <<<<<<<<<<<");
        }
    	
    }
    
    /**
     * Nome: getSelectItemRadioListaModalOperVinculadas
     * 
     * Propósito: Retorna o selectItem para operações vinculadas
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
    public List<SelectItem> getSelectItemRadioListaModalOperVinculadas() {
    	
    	try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] OprVincModalBean.getSelectItemRadioListaModalOperVinculadas <<<<<<<<<<<");
            
            List<SelectItem> list = new ArrayList<SelectItem>();
            
            // Percorre todos os itens da lista afim de criar os respectivos radio
            // buttons
            for (int index = 0; index < getListaModalOperVinculadas().size(); index++) {
            	list.add(new SelectItem(index, "", ""));
            }
            
            return list;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] OprVincModalBean.getSelectItemRadioListaModalOperVinculadas <<<<<<<<<<<");
        }
    	
    }
    
    /**
     * Nome: paginarOperacoesVinculadas
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
    public void paginarOperacoesVinculadas(ActionEvent event) {

        getViewHelper().setStateIdListaModalOperVinculadas("NPCCIAPC");
    }

	public TrdFinNegOperVincVO getOperVinculadasVO() {
		return operVinculadasVO;
	}

	public void setOperVinculadasVO(TrdFinNegOperVincVO operVinculadasVO) {
		this.operVinculadasVO = operVinculadasVO;
	}

	public List<TrdFinNegOperVincVO> getListaModalOperVinculadas() {
		return listaModalOperVinculadas;
	}

	public void setListaModalOperVinculadas(
			List<TrdFinNegOperVincVO> listaModalOperVinculadas) {
		this.listaModalOperVinculadas = listaModalOperVinculadas;
	}

	public OprVincModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(OprVincModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public List<TrdFinNegOperVincVO> getListaOperacaoVinculada() {
		return listaOperacaoVinculada;
	}

	public void setListaOperacaoVinculada(List<TrdFinNegOperVincVO> listaOperacaoVinculada) {
		this.listaOperacaoVinculada = listaOperacaoVinculada;
	}
    
}
