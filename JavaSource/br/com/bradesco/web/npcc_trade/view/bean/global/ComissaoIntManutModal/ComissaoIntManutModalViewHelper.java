package br.com.bradesco.web.npcc_trade.view.bean.global.ComissaoIntManutModal;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public class ComissaoIntManutModalViewHelper {
	
	private Boolean renderModalComissaoInterna = Boolean.FALSE;
	
	private Integer codComissaoSobre = 0;
	
	private String stateIdListaParcelasComissao = null;

	private Boolean disabledTxtParcelaComissaoInt = Boolean.TRUE;
	
	private String funcaoBotaoComissaoInterna = null;
	
	private String nomeMoedaComissaoInterna = null;
	
	private List<SelectItem> comboPeriodicidade = new ArrayList<SelectItem>();
	
	private List<SelectItem> comboMomento = new ArrayList<SelectItem>();
	
	private Boolean disabledModalComissaoInt = Boolean.FALSE;
	
	private Integer linhaSelecionada = 0;
	
	private String vnegocmoedaestrg = null;
	
	private Integer tipoCobrancaComissao = 0;
	
	private Integer cindcdeconmmoeda = 0;
	
	private String modalId = null;
	   
	private boolean disabledBtoAltDetComInt = true;
	
	private Boolean disabledConfirmar = Boolean.FALSE;
	
	private Boolean disabledGerar = Boolean.FALSE;

    /** Variável do tipo Integer. */
    private Integer itemSelecListaParcelaComiss = Numeros.NUM999;
    
    private Integer codProduto = null;
	
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

	public String getStateIdListaParcelasComissao() {
		return stateIdListaParcelasComissao;
	}

	public void setStateIdListaParcelasComissao(String stateIdListaParcelasComissao) {
		this.stateIdListaParcelasComissao = stateIdListaParcelasComissao;
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

	public List<SelectItem> getComboPeriodicidade() {
		return comboPeriodicidade;
	}

	public void setComboPeriodicidade(List<SelectItem> comboPeriodicidade) {
		this.comboPeriodicidade = comboPeriodicidade;
	}

	public List<SelectItem> getComboMomento() {
		return comboMomento;
	}

	public void setComboMomento(List<SelectItem> comboMomento) {
		this.comboMomento = comboMomento;
	}

	public Boolean getDisabledModalComissaoInt() {
		return disabledModalComissaoInt;
	}

	public void setDisabledModalComissaoInt(Boolean disabledModalComissaoInt) {
		this.disabledModalComissaoInt = disabledModalComissaoInt;
	}

	public Integer getLinhaSelecionada() {
		return linhaSelecionada;
	}

	public void setLinhaSelecionada(Integer linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
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

	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

    /**
     * @return o valor do disabledBtoAltDetComInt
     */
    public boolean isDisabledBtoAltDetComInt() {
        return disabledBtoAltDetComInt;
    }

    /**
     * @param disabledBtoAltDetComInt seta o novo valor para o campo disabledBtoAltDetComInt
     */
    public void setDisabledBtoAltDetComInt(boolean disabledBtoAltDetComInt) {
        this.disabledBtoAltDetComInt = disabledBtoAltDetComInt;
    }

    public Boolean getDisabledConfirmar() {
        return disabledConfirmar;
    }

    public void setDisabledConfirmar(Boolean disabledConfirmar) {
        this.disabledConfirmar = disabledConfirmar;
    }

    public Boolean getDisabledGerar() {
        return disabledGerar;
    }

    public void setDisabledGerar(Boolean disabledGerar) {
        this.disabledGerar = disabledGerar;
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
	
}
