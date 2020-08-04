package br.com.bradesco.web.npcc_trade.view.bean.global.operacaoAditarModal;


public class OperacaoAditarModalViewHelper {

	private String modalId = null;

    private Boolean renderModalOperacoesAditar = Boolean.FALSE;
     
    private String stateIdListaModalOperacao = null;
    
    private String[] itemSelecListaModalOperacao = null;
    
	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	public Boolean getRenderModalOperacoesAditar() {
		return renderModalOperacoesAditar;
	}

	public void setRenderModalOperacoesAditar(Boolean renderModalOperacoesAditar) {
		this.renderModalOperacoesAditar = renderModalOperacoesAditar;
	}

	public String getStateIdListaModalOperacao() {
		return stateIdListaModalOperacao;
	}

	public void setStateIdListaModalOperacao(String stateIdListaModalOperacao) {
		this.stateIdListaModalOperacao = stateIdListaModalOperacao;
	}

	public String[] getItemSelecListaModalOperacao() {
		return itemSelecListaModalOperacao;
	}

	public void setItemSelecListaModalOperacao(String[] itemSelecListaModalOperacao) {
		this.itemSelecListaModalOperacao = itemSelecListaModalOperacao;
	}

}
