package br.com.bradesco.web.npcc_trade.view.bean.global.comissaoExtManutModal;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;

public class ComissaoExtManutModalViewHelper {

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

    /** Variável do tipo Integer. */
    private Integer itemSelecListaParcelaComiss = Numeros.NUM999;
	
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

    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;
	
	public String getStateIdListaParcelasComissao() {
		return stateIdListaParcelasComissao;
	}

	public void setStateIdListaParcelasComissao(String stateIdListaParcelasComissao) {
		this.stateIdListaParcelasComissao = stateIdListaParcelasComissao;
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

	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	public Boolean getDisabledTxtParcelaComissaoExt() {
		return disabledTxtParcelaComissaoExt;
	}

	public void setDisabledTxtParcelaComissaoExt(
			Boolean disabledTxtParcelaComissaoExt) {
		this.disabledTxtParcelaComissaoExt = disabledTxtParcelaComissaoExt;
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

	public SelectItemBean getSelectItemBean() {
		return selectItemBean;
	}

	public void setSelectItemBean(SelectItemBean selectItemBean) {
		this.selectItemBean = selectItemBean;
	}

	public String getFuncaoBotaoComissaoExterna() {
		return funcaoBotaoComissaoExterna;
	}

	public void setFuncaoBotaoComissaoExterna(String funcaoBotaoComissaoExterna) {
		this.funcaoBotaoComissaoExterna = funcaoBotaoComissaoExterna;
	}

	public String getLinhaSelecionada() {
		return linhaSelecionada;
	}

	public void setLinhaSelecionada(String linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}

    /**
     * @return o valor do disabledBotaoGerar
     */
    public Boolean getDisabledBotaoGerar() {
        return disabledBotaoGerar;
    }

    /**
     * @param disabledBotaoGerar seta o novo valor para o campo disabledBotaoGerar
     */
    public void setDisabledBotaoGerar(Boolean disabledBotaoGerar) {
        this.disabledBotaoGerar = disabledBotaoGerar;
    }

    /**
     * @return o valor do itemSelecListaParcelaComiss
     */
    public Integer getItemSelecListaParcelaComiss() {
        return itemSelecListaParcelaComiss;
    }

    /**
     * @param itemSelecListaParcelaComiss seta o novo valor para o campo itemSelecListaParcelaComiss
     */
    public void setItemSelecListaParcelaComiss(Integer itemSelecListaParcelaComiss) {
        this.itemSelecListaParcelaComiss = itemSelecListaParcelaComiss;
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

    /**
     * @return o valor do codProduto
     */
    public Integer getCodProduto() {
        return codProduto;
    }

    /**
     * @param codProduto seta o novo valor para o campo codProduto
     */
    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

	public Boolean getDisabledValorTaxaQuandoIrregular() {
		return disabledValorTaxaQuandoIrregular;
	}

	public void setDisabledValorTaxaQuandoIrregular(
			Boolean disabledValorTaxaQuandoIrregular) {
		this.disabledValorTaxaQuandoIrregular = disabledValorTaxaQuandoIrregular;
	}
    
}
