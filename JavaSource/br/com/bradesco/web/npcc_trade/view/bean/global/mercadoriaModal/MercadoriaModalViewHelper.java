package br.com.bradesco.web.npcc_trade.view.bean.global.mercadoriaModal;

public class MercadoriaModalViewHelper {

	private String nomeStateIdListaSelMercadoria = null;
	
	private String modalId = null;
	
	private Boolean renderModalMercadoria =  Boolean.FALSE;
	
	private Integer itemSelecListaMercadoria = 0;
	
	public String getNomeStateIdListaSelMercadoria() {
		return nomeStateIdListaSelMercadoria;
	}

	public void setNomeStateIdListaSelMercadoria(
			String nomeStateIdListaSelMercadoria) {
		this.nomeStateIdListaSelMercadoria = nomeStateIdListaSelMercadoria;
	}

	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	public Boolean getRenderModalMercadoria() {
		return renderModalMercadoria;
	}

	public void setRenderModalMercadoria(Boolean renderModalMercadoria) {
		this.renderModalMercadoria = renderModalMercadoria;
	}

	public Integer getItemSelecListaMercadoria() {
		return itemSelecListaMercadoria;
	}

	public void setItemSelecListaMercadoria(Integer itemSelecListaMercadoria) {
		this.itemSelecListaMercadoria = itemSelecListaMercadoria;
	}	
	
}
