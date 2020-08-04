package br.com.bradesco.web.npcc_trade.view.bean.global.oprVincModal;


public class OprVincModalViewHelper {

	private String modalId = null;

    private Boolean renderModalOperacoesVinculadas = Boolean.FALSE;
     
    private String stateIdListaModalOperVinculadas = null;
    
    private Integer[] itemSelecListaModalOperVinculadas = null;
    
	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	public Boolean getRenderModalOperacoesVinculadas() {
		return renderModalOperacoesVinculadas;
	}

	public void setRenderModalOperacoesVinculadas(
			Boolean renderModalOperacoesVinculadas) {
		this.renderModalOperacoesVinculadas = renderModalOperacoesVinculadas;
	}

	public String getStateIdListaModalOperVinculadas() {
		return stateIdListaModalOperVinculadas;
	}

	public void setStateIdListaModalOperVinculadas(String stateIdListaModalOperVinculadas) {
		this.stateIdListaModalOperVinculadas = stateIdListaModalOperVinculadas;
	}

	public Integer[] getItemSelecListaModalOperVinculadas() {
		return itemSelecListaModalOperVinculadas;
	}

	public void setItemSelecListaModalOperVinculadas(
			Integer[] itemSelecListaModalOperVinculadas) {
		this.itemSelecListaModalOperVinculadas = itemSelecListaModalOperVinculadas;
	}

}
