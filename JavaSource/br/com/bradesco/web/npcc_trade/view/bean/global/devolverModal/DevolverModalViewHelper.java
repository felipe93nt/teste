package br.com.bradesco.web.npcc_trade.view.bean.global.devolverModal;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

public class DevolverModalViewHelper {

	private Boolean renderModal = Boolean.FALSE;
	private Boolean renderModalConfirmar = Boolean.FALSE;
	private String modalId;
	private String acaoVoltar = SiteUtil.STRING_EMPTY;
	
	private Boolean isConfirmar = Boolean.FALSE;
	private String messagemConfirmar = SiteUtil.STRING_EMPTY;
	
	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

    /**
     * @return o valor do acaoVoltar
     */
    public String getAcaoVoltar() {
        return acaoVoltar;
    }

    /**
     * @param acaoVoltar seta o novo valor para o campo acaoVoltar
     */
    public void setAcaoVoltar(String acaoVoltar) {
        this.acaoVoltar = acaoVoltar;
    }

    /**
     * @return o valor do isConfirmar
     */
    public Boolean getIsConfirmar() {
        return isConfirmar;
    }

    /**
     * @param isConfirmar seta o novo valor para o campo isConfirmar
     */
    public void setIsConfirmar(Boolean isConfirmar) {
        this.isConfirmar = isConfirmar;
    }

    /**
     * @return o valor do messagemConfirmar
     */
    public String getMessagemConfirmar() {
        return messagemConfirmar;
    }

    /**
     * @param messagemConfirmar seta o novo valor para o campo messagemConfirmar
     */
    public void setMessagemConfirmar(String messagemConfirmar) {
        this.messagemConfirmar = messagemConfirmar;
    }

    /**
     * @return o valor do renderModalConfirmar
     */
    public Boolean getRenderModalConfirmar() {
        return renderModalConfirmar;
    }

    /**
     * @param renderModalConfirmar seta o novo valor para o campo renderModalConfirmar
     */
    public void setRenderModalConfirmar(Boolean renderModalConfirmar) {
        this.renderModalConfirmar = renderModalConfirmar;
    }
	
	
	
}
