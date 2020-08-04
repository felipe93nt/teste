package br.com.bradesco.web.npcc_trade.view.bean.global.boletoModal;

import java.io.Serializable;

/**
 * 
  * Nome: BoletoModalViewHelper.java
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
  * Registro  de Manutenção: 20/01/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class BoletoModalViewHelper implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Boolean renderModal = Boolean.FALSE;
    
    private String modalId;
    
	/**
	 * @return o valor do renderModal
	 */
	public Boolean getRenderModal() {
		return renderModal;
	}

	/**
	 * @param renderModal seta o novo valor para o campo renderModal
	 */
	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	/**
	 * @return o valor do serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return o valor do modalId
	 */
	public String getModalId() {
		return modalId;
	}

	/**
	 * @param modalId seta o novo valor para o campo modalId
	 */
	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

}
