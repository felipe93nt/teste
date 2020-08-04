package br.com.bradesco.web.npcc_trade.view.bean.global.modeloBoletoModalbean;

public class ModeloBoletoModalViewHelper {

	private Integer itemSelecListaModelBol = 0;
	
	private String nomeStateIdListaSelModelBol = null;
	
	private Boolean renderModal = Boolean.FALSE;

	private String modalId;
	
	private Integer modalidade;
	
	private boolean telaInicioCusto = Boolean.TRUE;
	
	private Boolean isConfirmar = Boolean.FALSE;
	
	private String titulo = null;
	
	public Integer getItemSelecListaModelBol() {
		return itemSelecListaModelBol;
	}

	public void setItemSelecListaModelBol(Integer itemSelecListaModelBol) {
		this.itemSelecListaModelBol = itemSelecListaModelBol;
	}

	public String getNomeStateIdListaSelModelBol() {
		return nomeStateIdListaSelModelBol;
	}

	public void setNomeStateIdListaSelModelBol(String nomeStateIdListaSelModelBol) {
		this.nomeStateIdListaSelModelBol = nomeStateIdListaSelModelBol;
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

	public Integer getModalidade() {
		return modalidade;
	}

	public void setModalidade(Integer modalidade) {
		this.modalidade = modalidade;
	}

    /**
     * @return o valor do telaInicioCusto
     */
    public boolean isTelaInicioCusto() {
        return telaInicioCusto;
    }

    /**
     * @param telaInicioCusto seta o novo valor para o campo telaInicioCusto
     */
    public void setTelaInicioCusto(boolean telaInicioCusto) {
        this.telaInicioCusto = telaInicioCusto;
    }

	public Boolean getIsConfirmar() {
		return isConfirmar;
	}

	public void setIsConfirmar(Boolean isConfirmar) {
		this.isConfirmar = isConfirmar;
	}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
	
}
