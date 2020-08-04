package br.com.bradesco.web.npcc_trade.view.bean.global.comissaoBase;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class ComissaoViewHelper {

    private String stateIdListaParcelasComissao = null;
    
    private String modalId;
    
    private String funcaoBotaoComissaoExterna;
    
    private Boolean disabledModalComissaoExt = Boolean.FALSE;
    
    private Boolean disabledComboTipoComissaoExt = Boolean.FALSE;

    private Boolean disabledTxtParcelaComissaoExt = Boolean.FALSE;
    
    private Boolean disabledValorTaxaQuandoIrregular = Boolean.FALSE;

    private Boolean disabledBotaoGerar = Boolean.FALSE;
    
    private Boolean renderModal = Boolean.FALSE;
    
    private String linhaSelecionada = null;
    
    private Integer telaOrigem = null;

    private String itemSelecListaParcelaComiss = null;
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboTipoComissao = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboPeriodoDaTaxa = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboMoedaDesembolso = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboMomento = new ArrayList<SelectItem>();
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboPeriodicidade = new ArrayList<SelectItem>();
    
    private Integer codProduto = null;
    
    private Boolean renderModalComissaoInterna = Boolean.FALSE;
    
    private Integer codComissaoSobre = 0;
    
    private Boolean disabledTxtParcelaComissaoInt = Boolean.TRUE;
    
    private String funcaoBotaoComissaoInterna = null;
    
    private String nomeMoedaComissaoInterna = null;
    
    private Boolean disabledModalComissaoInt = Boolean.FALSE;
    
    private String vnegocmoedaestrg = null;
    
    private Integer tipoCobrancaComissao = 0;
    
    private Integer cindcdeconmmoeda = 0;
    
    private boolean disabledBtoAltDetComInt = true;
    
    private Boolean disabledConfirmar = Boolean.FALSE;
    
    private Boolean disabledValorComissaoExt = Boolean.TRUE;
    
    private Boolean disabledTaxaComissaoExt = Boolean.TRUE;

    private boolean disabledBtoInclParcIrregComExt = Boolean.TRUE;
    
    public String getStateIdListaParcelasComissao() {
        return stateIdListaParcelasComissao;
    }

    public void setStateIdListaParcelasComissao(String stateIdListaParcelasComissao) {
        this.stateIdListaParcelasComissao = stateIdListaParcelasComissao;
    }

    public String getModalId() {
        return modalId;
    }

    public void setModalId(String modalId) {
        this.modalId = modalId;
    }

    public String getFuncaoBotaoComissaoExterna() {
        return funcaoBotaoComissaoExterna;
    }

    public void setFuncaoBotaoComissaoExterna(String funcaoBotaoComissaoExterna) {
        this.funcaoBotaoComissaoExterna = funcaoBotaoComissaoExterna;
    }

    public Boolean getDisabledModalComissaoExt() {
        return disabledModalComissaoExt;
    }

    public void setDisabledModalComissaoExt(Boolean disabledModalComissaoExt) {
        this.disabledModalComissaoExt = disabledModalComissaoExt;
    }

    public Boolean getDisabledComboTipoComissaoExt() {
        return disabledComboTipoComissaoExt;
    }

    public void setDisabledComboTipoComissaoExt(Boolean disabledComboTipoComissaoExt) {
        this.disabledComboTipoComissaoExt = disabledComboTipoComissaoExt;
    }

    public Boolean getDisabledTxtParcelaComissaoExt() {
        return disabledTxtParcelaComissaoExt;
    }

    public void setDisabledTxtParcelaComissaoExt(Boolean disabledTxtParcelaComissaoExt) {
        this.disabledTxtParcelaComissaoExt = disabledTxtParcelaComissaoExt;
    }

    public Boolean getDisabledValorTaxaQuandoIrregular() {
        return disabledValorTaxaQuandoIrregular;
    }

    public void setDisabledValorTaxaQuandoIrregular(Boolean disabledValorTaxaQuandoIrregular) {
        this.disabledValorTaxaQuandoIrregular = disabledValorTaxaQuandoIrregular;
    }

    public Boolean getDisabledBotaoGerar() {
        return disabledBotaoGerar;
    }

    public void setDisabledBotaoGerar(Boolean disabledBotaoGerar) {
        this.disabledBotaoGerar = disabledBotaoGerar;
    }

    public Boolean getRenderModal() {
        return renderModal;
    }

    public void setRenderModal(Boolean renderModal) {
        this.renderModal = renderModal;
    }

    public String getLinhaSelecionada() {
        return linhaSelecionada;
    }

    public void setLinhaSelecionada(String linhaSelecionada) {
        this.linhaSelecionada = linhaSelecionada;
    }

    public Integer getTelaOrigem() {
        return telaOrigem;
    }

    public void setTelaOrigem(Integer telaOrigem) {
        this.telaOrigem = telaOrigem;
    }

    public String getItemSelecListaParcelaComiss() {
        return itemSelecListaParcelaComiss;
    }

    public void setItemSelecListaParcelaComiss(String itemSelecListaParcelaComiss) {
        this.itemSelecListaParcelaComiss = itemSelecListaParcelaComiss;
    }

    public List<SelectItem> getComboTipoComissao() {
        return comboTipoComissao;
    }

    public void setComboTipoComissao(List<SelectItem> comboTipoComissao) {
        this.comboTipoComissao = comboTipoComissao;
    }

    public List<SelectItem> getComboPeriodoDaTaxa() {
        return comboPeriodoDaTaxa;
    }

    public void setComboPeriodoDaTaxa(List<SelectItem> comboPeriodoDaTaxa) {
        this.comboPeriodoDaTaxa = comboPeriodoDaTaxa;
    }

    public List<SelectItem> getComboMoedaDesembolso() {
        return comboMoedaDesembolso;
    }

    public void setComboMoedaDesembolso(List<SelectItem> comboMoedaDesembolso) {
        this.comboMoedaDesembolso = comboMoedaDesembolso;
    }

    public List<SelectItem> getComboMomento() {
        return comboMomento;
    }

    public void setComboMomento(List<SelectItem> comboMomento) {
        this.comboMomento = comboMomento;
    }

    public List<SelectItem> getComboPeriodicidade() {
        return comboPeriodicidade;
    }

    public void setComboPeriodicidade(List<SelectItem> comboPeriodicidade) {
        this.comboPeriodicidade = comboPeriodicidade;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Boolean getRenderModalComissaoInterna() {
        return renderModalComissaoInterna;
    }

    public void setRenderModalComissaoInterna(Boolean renderModalComissaoInterna) {
        this.renderModalComissaoInterna = renderModalComissaoInterna;
    }

    public Integer getCodComissaoSobre() {
        return codComissaoSobre;
    }

    public void setCodComissaoSobre(Integer codComissaoSobre) {
        this.codComissaoSobre = codComissaoSobre;
    }

    public Boolean getDisabledTxtParcelaComissaoInt() {
        return disabledTxtParcelaComissaoInt;
    }

    public void setDisabledTxtParcelaComissaoInt(Boolean disabledTxtParcelaComissaoInt) {
        this.disabledTxtParcelaComissaoInt = disabledTxtParcelaComissaoInt;
    }

    public String getFuncaoBotaoComissaoInterna() {
        return funcaoBotaoComissaoInterna;
    }

    public void setFuncaoBotaoComissaoInterna(String funcaoBotaoComissaoInterna) {
        this.funcaoBotaoComissaoInterna = funcaoBotaoComissaoInterna;
    }

    public String getNomeMoedaComissaoInterna() {
        return nomeMoedaComissaoInterna;
    }

    public void setNomeMoedaComissaoInterna(String nomeMoedaComissaoInterna) {
        this.nomeMoedaComissaoInterna = nomeMoedaComissaoInterna;
    }

    public Boolean getDisabledModalComissaoInt() {
        return disabledModalComissaoInt;
    }

    public void setDisabledModalComissaoInt(Boolean disabledModalComissaoInt) {
        this.disabledModalComissaoInt = disabledModalComissaoInt;
    }

    public String getVnegocmoedaestrg() {
        return vnegocmoedaestrg;
    }

    public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
        this.vnegocmoedaestrg = vnegocmoedaestrg;
    }

    public Integer getTipoCobrancaComissao() {
        return tipoCobrancaComissao;
    }

    public void setTipoCobrancaComissao(Integer tipoCobrancaComissao) {
        this.tipoCobrancaComissao = tipoCobrancaComissao;
    }

    public Integer getCindcdeconmmoeda() {
        return cindcdeconmmoeda;
    }

    public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
        this.cindcdeconmmoeda = cindcdeconmmoeda;
    }

    public boolean isDisabledBtoAltDetComInt() {
        return disabledBtoAltDetComInt;
    }

    public void setDisabledBtoAltDetComInt(boolean disabledBtoAltDetComInt) {
        this.disabledBtoAltDetComInt = disabledBtoAltDetComInt;
    }

    public Boolean getDisabledConfirmar() {
        return disabledConfirmar;
    }

    public void setDisabledConfirmar(Boolean disabledConfirmar) {
        this.disabledConfirmar = disabledConfirmar;
    }

    /**
     * @return o valor do disabledValorComissaoExt
     */
    public Boolean getDisabledValorComissaoExt() {
        return disabledValorComissaoExt;
    }

    /**
     * @param disabledValorComissaoExt seta o novo valor para o campo disabledValorComissaoExt
     */
    public void setDisabledValorComissaoExt(Boolean disabledValorComissaoExt) {
        this.disabledValorComissaoExt = disabledValorComissaoExt;
    }

    /**
     * @return o valor do disabledTaxaComissaoExt
     */
    public Boolean getDisabledTaxaComissaoExt() {
        return disabledTaxaComissaoExt;
    }

    /**
     * @param disabledTaxaComissaoExt seta o novo valor para o campo disabledTaxaComissaoExt
     */
    public void setDisabledTaxaComissaoExt(Boolean disabledTaxaComissaoExt) {
        this.disabledTaxaComissaoExt = disabledTaxaComissaoExt;
    }

	/**
	 * @return the disabledBtoInclParcIrregComissao
	 */
	public boolean isDisabledBtoInclParcIrregComExt() {
		return disabledBtoInclParcIrregComExt;
	}

	/**
	 * @param disabledBtoInclParcIrregComExt the disabledBtoInclParcIrregComExt to set
	 */
	public void setDisabledBtoInclParcIrregComExt(
			boolean disabledBtoInclParcIrregComExt) {
		this.disabledBtoInclParcIrregComExt = disabledBtoInclParcIrregComExt;
	}
    
}
