package br.com.bradesco.web.npcc_trade.view.bean.global.operadorModal;

public class OperadorModalViewHelper {

	private Boolean renderModalOpr = Boolean.FALSE;
	
	private Integer oprSelecionado = 0;
	
	private String nomeStateIdListaSelOpr = null;
	
	private String modalId = null;
	
	public Boolean getRenderModalOpr() {
		return renderModalOpr;
	}
	
	public void setRenderModalOpr(Boolean renderModalOpr) {
		this.renderModalOpr = renderModalOpr;
	}

	public Integer getOprSelecionado() {
		return oprSelecionado;
	}

	public void setOprSelecionado(Integer oprSelecionado) {
		this.oprSelecionado = oprSelecionado;
	}

	public String getNomeStateIdListaSelOpr() {
		return nomeStateIdListaSelOpr;
	}


	public void setNomeStateIdListaSelOpr(String nomeStateIdListaSelOpr) {
		this.nomeStateIdListaSelOpr = nomeStateIdListaSelOpr;
	}


	public String getModalId() {
		return modalId;
	}


	public void setModalId(String modalId) {
		this.modalId = modalId;
	}
	
}
