package br.com.bradesco.web.npcc_trade.view.bean.global.liborTravadaBean;

public class LiborTravaModalViewHelper {

	private String modalId = null;
	
	private Boolean renderModalLiborTravada = Boolean.FALSE;
	
	private String liborTravada = null;
    
    private String chamador = null;

	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	public Boolean getRenderModalLiborTravada() {
		return renderModalLiborTravada;
	}

	public void setRenderModalLiborTravada(Boolean renderModalLiborTravada) {
		this.renderModalLiborTravada = renderModalLiborTravada;
	}

	public String getLiborTravada() {
		return liborTravada;
	}

	public void setLiborTravada(String liborTravada) {
		this.liborTravada = liborTravada;
	}

    /**
     * @return o valor do chamador
     */
    public String getChamador() {
        return chamador;
    }

    /**
     * @param chamador seta o novo valor para o campo chamador
     */
    public void setChamador(String chamador) {
        this.chamador = chamador;
    }
	
	
}
