package br.com.bradesco.web.npcc_trade.view.bean.global.custoExtDsnModal;

public class CustoExtAutoDsnModalViewHelper {

	private Boolean renderModal = Boolean.FALSE;
	private String modalId;
	
	private String labelMotivo = "Motivo";
    private Integer botaoAcionado = 0;
    private Integer telaOrigem = 0;
    private String txtMotivo = null;
    private String headerMotivo = null;
	
	
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
     * @return o valor do labelMotivo
     */
    public String getLabelMotivo() {
        return labelMotivo;
    }

    /**
     * @param labelMotivo seta o novo valor para o campo labelMotivo
     */
    public void setLabelMotivo(String labelMotivo) {
        this.labelMotivo = labelMotivo;
    }

    /**
     * @return o valor do txtMotivo
     */
    public String getTxtMotivo() {
        return txtMotivo;
    }

    /**
     * @param txtMotivo seta o novo valor para o campo txtMotivo
     */
    public void setTxtMotivo(String txtMotivo) {
        this.txtMotivo = txtMotivo;
    }

    /**
     * @return o valor do headerMotivo
     */
    public String getHeaderMotivo() {
        return headerMotivo;
    }

    /**
     * @param headerMotivo seta o novo valor para o campo headerMotivo
     */
    public void setHeaderMotivo(String headerMotivo) {
        this.headerMotivo = headerMotivo;
    }

    /**
     * @return o valor do botaoAcionado
     */
    public Integer getBotaoAcionado() {
        return botaoAcionado;
    }

    /**
     * @param botaoAcionado seta o novo valor para o campo botaoAcionado
     */
    public void setBotaoAcionado(Integer botaoAcionado) {
        this.botaoAcionado = botaoAcionado;
    }

    /**
     * @return o valor do telaOrigem
     */
    public Integer getTelaOrigem() {
        return telaOrigem;
    }

    /**
     * @param telaOrigem seta o novo valor para o campo telaOrigem
     */
    public void setTelaOrigem(Integer telaOrigem) {
        this.telaOrigem = telaOrigem;
    }
	
	
	
}
