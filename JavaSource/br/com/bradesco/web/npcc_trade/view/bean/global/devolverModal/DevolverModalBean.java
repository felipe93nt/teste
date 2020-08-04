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
  * Prop�sito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 17/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
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
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 08/04/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public String devolverCotacao(){
		String result = SiteUtil.STRING_EMPTY;
		
		if(SiteUtil.isEmptyOrNull(getDevolucaoVO().getRobsbletocmbio())) {
		    NpcFacesUtils.addInfoModalMessage("O campo Motivo da devolu��o � obrigat�rio.", EnumButtonBehavior.SUBMIT);
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
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 11/04/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
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
