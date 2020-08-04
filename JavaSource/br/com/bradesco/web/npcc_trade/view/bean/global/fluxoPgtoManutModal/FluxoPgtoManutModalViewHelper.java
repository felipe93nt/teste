package br.com.bradesco.web.npcc_trade.view.bean.global.fluxoPgtoManutModal;

import br.com.bradesco.web.npcc_trade.utils.Numeros;


public class FluxoPgtoManutModalViewHelper {

	private String stateIdLista = null;
	
	private String modalId;
	
	private Boolean renderModal;
	
	private String nomeMoedaDesembolso = null;
    
    private Boolean disabledDadosIrregular = Boolean.FALSE;

    private Boolean disabledValorQuandoIrregularTipoJuros = Boolean.FALSE;
    
    private Boolean disabledComboTipoParcela = Boolean.FALSE;
    
    private String itemSelecListaParcelaComiss = null;

    /**
     * @return o valor do stateIdLista
     */
    public String getStateIdLista() {
        return stateIdLista;
    }

    /**
     * @param stateIdLista seta o novo valor para o campo stateIdLista
     */
    public void setStateIdLista(String stateIdLista) {
        this.stateIdLista = stateIdLista;
    }

    /**
     * @return o valor do modalId
     */
    public String getModalId() {
        return modalId;
    }

    /**
     * @param modalId seta o novo valor para o campo modalId
     */
    public void setModalId(String modalId) {
        this.modalId = modalId;
    }

    /**
     * @return o valor do renderModal
     */
    public Boolean getRenderModal() {
        return renderModal;
    }

    /**
     * @param renderModal seta o novo valor para o campo renderModal
     */
    public void setRenderModal(Boolean renderModal) {
        this.renderModal = renderModal;
    }

    /**
     * @return o valor do nomeMoedaDesembolso
     */
    public String getNomeMoedaDesembolso() {
        return nomeMoedaDesembolso;
    }

    /**
     * @param nomeMoedaDesembolso seta o novo valor para o campo nomeMoedaDesembolso
     */
    public void setNomeMoedaDesembolso(String nomeMoedaDesembolso) {
        this.nomeMoedaDesembolso = nomeMoedaDesembolso;
    }

    /**
     * @return o valor do disabledDadosIrregular
     */
    public Boolean getDisabledDadosIrregular() {
        return disabledDadosIrregular;
    }

    /**
     * @param disabledDadosIrregular seta o novo valor para o campo disabledDadosIrregular
     */
    public void setDisabledDadosIrregular(Boolean disabledDadosIrregular) {
        this.disabledDadosIrregular = disabledDadosIrregular;
    }

    /**
     * @return o valor do disabledComboTipoParcela
     */
    public Boolean getDisabledComboTipoParcela() {
        return disabledComboTipoParcela;
    }

    /**
     * @param disabledComboTipoParcela seta o novo valor para o campo disabledComboTipoParcela
     */
    public void setDisabledComboTipoParcela(Boolean disabledComboTipoParcela) {
        this.disabledComboTipoParcela = disabledComboTipoParcela;
    }

	public Boolean getDisabledValorQuandoIrregularTipoJuros() {
		return disabledValorQuandoIrregularTipoJuros;
	}

	public void setDisabledValorQuandoIrregularTipoJuros(
			Boolean disabledValorQuandoIrregularTipoJuros) {
		this.disabledValorQuandoIrregularTipoJuros = disabledValorQuandoIrregularTipoJuros;
	}

    public String getItemSelecListaParcelaComiss() {
        return itemSelecListaParcelaComiss;
    }

    public void setItemSelecListaParcelaComiss(String itemSelecListaParcelaComiss) {
        this.itemSelecListaParcelaComiss = itemSelecListaParcelaComiss;
    }
	
}
