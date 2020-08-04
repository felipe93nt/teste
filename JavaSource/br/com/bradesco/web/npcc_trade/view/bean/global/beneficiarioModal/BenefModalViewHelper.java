package br.com.bradesco.web.npcc_trade.view.bean.global.beneficiarioModal;

public class BenefModalViewHelper {

	private String nomeStateIdListaSelBeneficiario = null;
	
	private String modalId = null;
	
	private Boolean RenderModalBeneficiario =  Boolean.FALSE;
	private Boolean RenderModalBeneficiarioAfiancado =  Boolean.FALSE;
	
	private Integer itemSelecListaBeneficiario = 0;
	
	/** Variaveis Utilizada na Tela Garantia Incluir Complemento e Alterar Complemento **/
	private Integer garantiaBenf = 0;
	private Integer garantiaAfianc = 0;
	
	private String nomeCampo = "Beneficiário";
	
	
	public String getNomeStateIdListaSelBeneficiario() {
		return nomeStateIdListaSelBeneficiario;
	}

	public void setNomeStateIdListaSelBeneficiario(
			String nomeStateIdListaSelBeneficiario) {
		this.nomeStateIdListaSelBeneficiario = nomeStateIdListaSelBeneficiario;
	}

	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	public Boolean getRenderModalBeneficiario() {
		return RenderModalBeneficiario;
	}

	public void setRenderModalBeneficiario(Boolean renderModalBeneficiario) {
		RenderModalBeneficiario = renderModalBeneficiario;
	}

	public Integer getItemSelecListaBeneficiario() {
		return itemSelecListaBeneficiario;
	}

	public void setItemSelecListaBeneficiario(Integer itemSelecListaBeneficiario) {
		this.itemSelecListaBeneficiario = itemSelecListaBeneficiario;
	}

    /**
     * @return o valor do renderModalBeneficiarioAfiancado
     */
    public Boolean getRenderModalBeneficiarioAfiancado() {
        return RenderModalBeneficiarioAfiancado;
    }

    /**
     * @param renderModalBeneficiarioAfiancado seta o novo valor para o campo renderModalBeneficiarioAfiancado
     */
    public void setRenderModalBeneficiarioAfiancado(Boolean renderModalBeneficiarioAfiancado) {
        RenderModalBeneficiarioAfiancado = renderModalBeneficiarioAfiancado;
    }

    /**
     * @return o valor do garantiaBenf
     */
    public Integer getGarantiaBenf() {
        return garantiaBenf;
    }

    /**
     * @param garantiaBenf seta o novo valor para o campo garantiaBenf
     */
    public void setGarantiaBenf(Integer garantiaBenf) {
        this.garantiaBenf = garantiaBenf;
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

    /**
     * @return o valor do nomeCampo
     */
    public String getNomeCampo() {
        return nomeCampo;
    }

    /**
     * @param nomeCampo seta o novo valor para o campo nomeCampo
     */
    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

}
