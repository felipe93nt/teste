package br.com.bradesco.web.npcc_trade.view.bean.global.unidadeExternaModalbean;

public class UnidadeExternaModalViewHelper {

	private Integer itemSelecListaUnidExt = 0;
	
	private String nomeStateIdListaSelUnidExt = null;
	
	private Boolean renderModal = Boolean.FALSE;

	private String modalId;
	
	private Integer modalidade;
	
	private boolean telaInicioCusto = Boolean.TRUE;
	
	private Boolean isConfirmar = Boolean.FALSE;
	
	private String titulo = null;
	
	public Integer getItemSelecListaUnidExt() {
		return itemSelecListaUnidExt;
	}

	public void setItemSelecListaUnidExt(Integer itemSelecListaUnidExt) {
		this.itemSelecListaUnidExt = itemSelecListaUnidExt;
	}

	public String getNomeStateIdListaSelUnidExt() {
		return nomeStateIdListaSelUnidExt;
	}

	public void setNomeStateIdListaSelUnidExt(String nomeStateIdListaSelUnidExt) {
		this.nomeStateIdListaSelUnidExt = nomeStateIdListaSelUnidExt;
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
