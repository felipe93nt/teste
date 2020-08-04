package br.com.bradesco.web.npcc_trade.view.bean.global.operadorModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.IOperadorModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.bean.OperadorVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named(value = "operadorModalBean")
@SessionScoped
public class OperadorModalBean implements Serializable {
	
	/** Variavel do tipo long. */
	private static final long serialVersionUID = -1146781377264484120L;
	private OperadorVO operadorVO = new OperadorVO();
	private OperadorVO operadorSel = new OperadorVO();
	private List<OperadorVO> lista = new ArrayList<OperadorVO>();
	private OperadorModalViewHelper viewHelper = new OperadorModalViewHelper();
	
	@Inject 
	@Named("operadorModalServiceImpl")
	private IOperadorModalService operadorModalService;
	
	/**
     * Nome: openModal
     * 
     * Propósito: Efetua pesquisa do banco emissor
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal() {
    	lista.clear();
        setLista(operadorModalService.pesquisarOperador(operadorVO));
        getViewHelper().setRenderModalOpr(Boolean.TRUE);
    }
	
	/**
	 * 
		* Nome: selecionarCliente
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 23/03/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public String selecionarOperador() { 
       // valida se foi selecionado um item na lista
       if (viewHelper.getOprSelecionado() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            return null;
        }
        
        getOperadorSel().setCusuarincl(getLista().get(viewHelper.getOprSelecionado()).getCusuarincl());
        
        return "/content/global/operadorModal/operadorModalClose.xhtml";
    }
	
	/**
     * 
    	* Nome: paginarCliente
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/03/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void paginarOperador(ActionEvent event) {
    	setLista(operadorModalService.pesquisarOperador(operadorVO));
    }
	
	/**
     * Nome: closeModal
     * 
     * Propósito: Fecha modal banco emissor
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event) {
        // desabilita modal
        getViewHelper().setRenderModalOpr(Boolean.FALSE);
    }
    
    /**
     * Nome: getSelectItemRadioListaMercadoria
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
    public List<SelectItem> getSelectItemRadioLista() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();

        SiteUtil.atualizarSelectItem(getLista(), selectItemRadioLista);

        return selectItemRadioLista;
    }

	public OperadorVO getOperadorVO() {
		return operadorVO;
	}

	public void setOperadorVO(OperadorVO operadorVO) {
		this.operadorVO = operadorVO;
	}

	public List<OperadorVO> getLista() {
		return lista;
	}

	public void setLista(List<OperadorVO> lista) {
		this.lista = lista;
	}

	public OperadorModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(OperadorModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public OperadorVO getOperadorSel() {
		return operadorSel;
	}

	public void setOperadorSel(OperadorVO operadorSel) {
		this.operadorSel = operadorSel;
	}
	
}
