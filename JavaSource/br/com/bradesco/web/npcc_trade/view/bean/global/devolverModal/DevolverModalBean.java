package br.com.bradesco.web.npcc_trade.view.bean.global.devolverModal;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.devolverModal.DevolucaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.devolverModal.IDevolverModalService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
  * Nome: DevolverModalBean.java
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
  * Registro  de Manutenção: 17/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@Named(value = "devolverModalBean")
@SessionScoped
public class DevolverModalBean implements Serializable{

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 697082233646550474L;
	
	private DevolverModalViewHelper viewHelper = new DevolverModalViewHelper();
	private DevolucaoVO devolucaoVO = new DevolucaoVO();
	
	@Inject
    @Named("devolverModalService")
    private IDevolverModalService devolverModalService;
	
	    /**
	     * Construtor
	     * 
	     * @param 
	     */
	public DevolverModalBean() {
		super();
	}
	
	/**
	 * 
		* Nome: devolverCotacao
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 08/04/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public String devolverCotacao(){
		String result = SiteUtil.STRING_EMPTY;
		
		if(SiteUtil.isEmptyOrNull(getDevolucaoVO().getRobsbletocmbio())) {
		    NpcFacesUtils.addInfoModalMessage("O campo Motivo da devolução é obrigatório.", EnumButtonBehavior.SUBMIT);
		    return null;
		}
		
	    if (devolucaoVO.getCsitbletocmbio() == Numeros.NUM36) {
	        result = devolverModalService.devolverCotacaoDivrg(devolucaoVO);
	    } else {
	        result = devolverModalService.devolverCotacao(devolucaoVO);
	    }
	    
	    viewHelper.setIsConfirmar(true);
	    viewHelper.setMessagemConfirmar(result);
	    return "/content/global/devolverModal/devolverModalClose.xhtml";
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
		* Registro  de Manutenção: 11/04/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public void openModal(){
		viewHelper.setRenderModal(Boolean.TRUE);
	}
	
	public void closeModal(){
	    viewHelper.setIsConfirmar(false);
		viewHelper.setRenderModal(Boolean.FALSE);
	}
	
	public DevolverModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(DevolverModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public DevolucaoVO getDevolucaoVO() {
		return devolucaoVO;
	}

	public void setDevolucaoVO(DevolucaoVO devolucaoVO) {
		this.devolucaoVO = devolucaoVO;
	}
	
	
}
