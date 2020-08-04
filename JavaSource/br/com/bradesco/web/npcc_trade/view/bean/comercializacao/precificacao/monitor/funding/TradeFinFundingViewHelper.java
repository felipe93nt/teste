package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.funding;

public class TradeFinFundingViewHelper {
	
	private Integer refSelecionado;
	
	private Boolean renderModal = Boolean.FALSE;
	
	public Integer getRefSelecionado() {
		return refSelecionado;
	}

	public void setRefSelecionado(Integer refSelecionado) {
		this.refSelecionado = refSelecionado;
	}

    public Boolean getRenderModal() {
        return renderModal;
    }

    public void setRenderModal(Boolean renderModal) {
        this.renderModal = renderModal;
    }
	
}
