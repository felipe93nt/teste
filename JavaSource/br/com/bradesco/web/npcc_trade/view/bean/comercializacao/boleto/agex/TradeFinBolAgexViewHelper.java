package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.boleto.agex;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.utils.Numeros;


/**
 * 
  * Nome: TradeFinBolAgexViewHelper.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
 */
public class TradeFinBolAgexViewHelper {
	
    private Integer ctcSelecionado = null;
    private Integer codCpfCnpjSelecionado = Numeros.DOIS;
    private List<SelectItem> comboMoedaItens = new ArrayList<SelectItem>();
    
	private boolean renderMercadoria = true;
	private boolean renderFechar = false;
	private boolean renderBotoes = false;
	private boolean renderModal = false;
	
	private boolean renderModalLimite;
	private boolean renderModalCliente;

    private Integer itemSelecListaSelCliente = Numeros.ZERO;
    private Integer itemSelecListaUnidExt = Numeros.ZERO;
	private Integer itemSelecListaSelBoleto = Numeros.ZERO;
    
    private String codlistRadio = null;
    private String nomeStateIdLista = null;
    private List<Integer> lista = new ArrayList<Integer>();

    /** Filtro código */
    private Date filtroData = null;
    private String filtroMoeda;

    /**
     * Indice do radio selecionado na grid
     */
    private Integer itemSelecListaModalLimites = Numeros.ZERO;
	
	/**
     *  Variável utilizada para definier o state id da lista 
     */
    private String stateIdListaModalLimites = null;
    
    private String modalId = null;

    private boolean telaIniciaUnidade = Boolean.TRUE;
    /** Variavel do tipo Boolean. */
    private Boolean unidadeExterna = Boolean.FALSE;
    private List<SelectItem> comboUnidadeExterna = new ArrayList<SelectItem>();

	/**
	 * @return o valor do filtroData
	 */
	public Date getFiltroData() {
		return filtroData;
	}

	/**
	 * @param filtroData seta o novo valor para o campo filtroData
	 */
	public void setFiltroData(Date filtroData) {
		this.filtroData = filtroData;
	}


	public String getFiltroMoeda() {
		return filtroMoeda;
	}

	public void setFiltroMoeda(String filtroMoeda) {
		this.filtroMoeda = filtroMoeda;
	}

	
    /**
     * @return o valor do codlistRadio
     */
    public String getCodlistRadio() {
        return codlistRadio;
    }
    /**
     * @param codlistRadio seta o novo valor para o campo codlistRadio
     */
    public void setCodlistRadio(String codlistRadio) {
        this.codlistRadio = codlistRadio;
    }
	
    /**
     * @return o valor do nomeStateIdLista
     */
    public String getNomeStateIdLista() {
        return nomeStateIdLista;
    }

    /**
     * @param nomeStateIdLista seta o novo valor para o campo nomeStateIdLista
     */
    public void setNomeStateIdLista(String nomeStateIdLista) {
        this.nomeStateIdLista = nomeStateIdLista;
    }

    /**
     * @return o valor do lista
     */
    public List<Integer> getLista() {
        return lista;
    }

    /**
     * @param lista seta o novo valor para o campo lista
     */
    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }
    
	/**
     * Nome: getTipoPesquisaCpfCnpj
     * 
     * Propósito: Monta a lista de Radio Button de Tipo de Pesquisa para CPF/CNPJ
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getTipoPesquisaCpfCnpj() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM2, "CNPJ"));
        tipo.add(new SelectItem(Numeros.NUM3, "CPF"));
        return tipo;
    }
    
	public List<SelectItem> getComboMoedaItens() {
		return comboMoedaItens;
	}

	public void setComboMoedaItens(List<SelectItem> comboMoedaItens) {
		this.comboMoedaItens = comboMoedaItens;
	}

	public Integer getCtcSelecionado() {
		return ctcSelecionado;
	}

	public void setCtcSelecionado(Integer ctcSelecionado) {
		this.ctcSelecionado = ctcSelecionado;
	}

	public Integer getCodCpfCnpjSelecionado() {
		return codCpfCnpjSelecionado;
	}

	public void setCodCpfCnpjSelecionado(Integer codCpfCnpjSelecionado) {
		this.codCpfCnpjSelecionado = codCpfCnpjSelecionado;
	}

	public boolean isRenderMercadoria() {
		return renderMercadoria;
	}

	public void setRenderMercadoria(boolean renderMercadoria) {
		this.renderMercadoria = renderMercadoria;
	}

	public boolean isRenderFechar() {
		return renderFechar;
	}

	public void setRenderFechar(boolean renderFechar) {
		this.renderFechar = renderFechar;
	}

	public boolean isRenderModal() {
		return renderModal;
	}

	public void setRenderModal(boolean renderModal) {
		this.renderModal = renderModal;
	}
	
    public boolean isRenderBotoes() {
			return renderBotoes;
	}

   public void setRenderBotoes(boolean renderBotoes) {
			this.renderBotoes = renderBotoes;
	}
    
	public boolean isRenderModalCliente() {
		return renderModalCliente;
	}

	public void setRenderModalCliente(boolean renderModalCliente) {
		this.renderModalCliente = renderModalCliente;
	}
    
	/**
	 * @return o valor do renderModalLimite
	 */
	public Boolean isRenderModalLimite() {
		return renderModalLimite;
	}

	public Boolean getRenderModalLimite() {
		return renderModalLimite;
	}

	/**
	 * @param renderModalLimite seta o novo valor para o campo renderModalLimite
	 */
	public void setRenderModalLimite(Boolean renderModalLimite) {
		this.renderModalLimite = renderModalLimite;
	}

	/**
	 * @return o valor do itemSelecListaUnidExt
	 */
	public Integer getItemSelecListaUnidExt() {
		return itemSelecListaUnidExt;
	}

	/**
	 * @param itemSelecListaUnidExt seta o novo valor para o campo itemSelecListaUnidExt
	 */
	public void setItemSelecListaUnidExt(Integer itemSelecListaUnidExt) {
		this.itemSelecListaUnidExt = itemSelecListaUnidExt;
	}
	
	/**
	 * @return o valor do itemSelecListaSelCliente
	 */
	public Integer getItemSelecListaSelCliente() {
		return itemSelecListaSelCliente;
	}

	/**
	 * @param itemSelecListaSelCliente seta o novo valor para o campo itemSelecListaSelCliente
	 */
	public void setItemSelecListaSelCliente(Integer itemSelecListaSelCliente) {
		this.itemSelecListaSelCliente = itemSelecListaSelCliente;
	}

	/**
	 * @return o valor do itemSelecListaModalLimites
	 */
	public Integer getItemSelecListaModalLimites() {
		return itemSelecListaModalLimites;
	}

	/**
	 * @param itemSelecListaModalLimites seta o novo valor para o campo itemSelecListaModalLimites
	 */
	public void setItemSelecListaModalLimites(Integer itemSelecListaModalLimites) {
		this.itemSelecListaModalLimites = itemSelecListaModalLimites;
	}

	/**
	 * @return o valor do stateIdListaModalLimites
	 */
	public String getStateIdListaModalLimites() {
		return stateIdListaModalLimites;
	}

	/**
	 * @param stateIdListaModalLimites seta o novo valor para o campo stateIdListaModalLimites
	 */
	public void setStateIdListaModalLimites(String stateIdListaModalLimites) {
		this.stateIdListaModalLimites = stateIdListaModalLimites;
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
	 * @return the itemSelecListaSelBoleto
	 */
	public Integer getItemSelecListaSelBoleto() {
		return itemSelecListaSelBoleto;
	}

	/**
	 * @param itemSelecListaSelBoleto the itemSelecListaSelBoleto to set
	 */
	public void setItemSelecListaSelBoleto(Integer itemSelecListaSelBoleto) {
		this.itemSelecListaSelBoleto = itemSelecListaSelBoleto;
	}

    /**
     * @return o valor do telaIniciaUnidade
     */
    public boolean isTelaIniciaUnidade() {
        return telaIniciaUnidade;
    }

    /**
     * @param telaIniciaUnidade seta o novo valor para o campo telaIniciaUnidade
     */
    public void setTelaIniciaUnidade(boolean telaIniciaUnidade) {
        this.telaIniciaUnidade = telaIniciaUnidade;
    }

    /**
     * @return o valor do comboUnidadeExterna
     */
    public List<SelectItem> getComboUnidadeExterna() {
        return comboUnidadeExterna;
    }

    /**
     * @param comboUnidadeExterna seta o novo valor para o campo comboUnidadeExterna
     */
    public void setComboUnidadeExterna(List<SelectItem> comboUnidadeExterna) {
        this.comboUnidadeExterna = comboUnidadeExterna;
    }

    /**
     * @return o valor do unidadeExterna
     */
    public Boolean getUnidadeExterna() {
        return unidadeExterna;
    }

	/**
     * @param unidadeExterna seta o novo valor para o campo unidadeExterna
     */
    public void setUnidadeExterna(Boolean unidadeExterna) {
        this.unidadeExterna = unidadeExterna;
    }
	
}
