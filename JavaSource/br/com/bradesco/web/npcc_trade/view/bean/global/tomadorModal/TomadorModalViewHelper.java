package br.com.bradesco.web.npcc_trade.view.bean.global.tomadorModal;

public class TomadorModalViewHelper {

    private String nomeTomador = null;
    
	private Integer itemSelecListaTomador = 0;
	
	private String nomeStateIdListaSelTomador = null;
	
	private Boolean renderModal = Boolean.FALSE;

	private String modalId;
	
	private Integer garantiaAfianc = 0;
	
	public Integer getItemSelecListaTomador() {
		return itemSelecListaTomador;
	}

	public void setItemSelecListaTomador(Integer itemSelecListaTomador) {
		this.itemSelecListaTomador = itemSelecListaTomador;
	}

	public String getNomeStateIdListaSelTomador() {
		return nomeStateIdListaSelTomador;
	}

	public void setNomeStateIdListaSelTomador(String nomeStateIdListaSelTomador) {
		this.nomeStateIdListaSelTomador = nomeStateIdListaSelTomador;
	}

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
     * @return o valor do nomeTomador
     */
    public String getNomeTomador() {
        return nomeTomador;
    }

    /**
     * @param nomeTomador seta o novo valor para o campo nomeTomador
     */
    public void setNomeTomador(String nomeTomador) {
        this.nomeTomador = nomeTomador;
    }

    /**
     * @return o valor do garantiaAfianc
     */
    public Integer getGarantiaAfianc() {
        return garantiaAfianc;
    }

    /**
     * @param garantiaAfianc seta o novo valor para o campo garantiaAfianc
     */
    public void setGarantiaAfianc(Integer garantiaAfianc) {
        this.garantiaAfianc = garantiaAfianc;
    }
	
}
