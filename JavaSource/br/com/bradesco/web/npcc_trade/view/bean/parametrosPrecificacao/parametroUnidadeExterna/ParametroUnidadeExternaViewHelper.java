/**
 *
 * Nome: FaixaOperacaoViewHelper.java
 * Propósito: <p> </p>
 *
 * @author :  Bradesco S.A.<BR/>
 * Equipe : Centro de Desembolvimento Curitiba <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 */
package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.parametroUnidadeExterna;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean.ParametroUnidadeExternaVO;

/**
 *
 * Nome: FaixaOperacaoViewHelper.java Propósito:
 * <p>
 * </p>
 *
 * @author : Bradesco<BR/>
 *         Equipe : CD <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 */
public class ParametroUnidadeExternaViewHelper {

	private String stateIdListaFaixas = null;
    /**
     * Variavel utilizada para definier o filtro
     */
    private ParametroUnidadeExternaVO filtro = new ParametroUnidadeExternaVO();

	/**
	 * Variavel utilizada para definier o state id da lista de log
	 */
	private String nomeStateIdLista = null;

	private Boolean renderModalSalvar = false;
	
	/** Variavel do tipo boolean. */
	private boolean disabledBtnIncluir = Boolean.TRUE;
	
	/** Variavel do tipo boolean. */
	private boolean disabledBtnAlterar = Boolean.FALSE;

	/** Variavel do tipo boolean. */
	private boolean disabledBtnExcluir = Boolean.FALSE;

    private Integer codItemSelecionadoLista = null;

	private List<SelectItem> comboProdutos = new ArrayList<SelectItem>();

	private List<SelectItem> comboMoedas = new ArrayList<SelectItem>();

	/**
     * Variável de controle do modal de confirmação
     */
    Boolean renderModal = Boolean.FALSE;
    
    private Boolean renderBotoes = false;
    
    /* Ativado quando solicitado alterar faixa na inclusão/alteracao faixas */
    private Boolean modoAlteracaoFaixa = false;

	/**
	 * @return o valor do renderModalSalvar
	 */
	public Boolean getRenderModalSalvar() {
		return renderModalSalvar;
	}

	/**
	 * @param renderModalSalvar
	 *            seta o novo valor para o campo renderModalSalvar
	 */
	public void setRenderModalSalvar(Boolean renderModalSalvar) {
		this.renderModalSalvar = renderModalSalvar;
	}

	/**
	 * @return o valor do comboProdutos
	 */
	public List<SelectItem> getComboProdutos() {
		return comboProdutos;
	}

	/**
	 * @param comboProdutos
	 *            seta o novo valor para o campo comboProdutos
	 */
	public void setComboProdutos(List<SelectItem> comboProdutos) {
		this.comboProdutos = comboProdutos;
	}

	public String getNomeStateIdLista() {
		return nomeStateIdLista;
	}

	public void setNomeStateIdLista(String nomeStateIdLista) {
		this.nomeStateIdLista = nomeStateIdLista;
	}

	public Integer getCodItemSelecionadoLista() {
		return codItemSelecionadoLista;
	}

	public void setCodItemSelecionadoLista(Integer codItemSelecionadoLista) {
		this.codItemSelecionadoLista = codItemSelecionadoLista;
	}

	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	public Boolean getRenderBotoes() {
		return renderBotoes;
	}

	public void setRenderBotoes(Boolean renderBotoes) {
		this.renderBotoes = renderBotoes;
	}

	public boolean isDisabledBtnIncluir() {
		return disabledBtnIncluir;
	}

	public void setDisabledBtnIncluir(boolean disabledBtnIncluir) {
		this.disabledBtnIncluir = disabledBtnIncluir;
	}

	public boolean isDisabledBtnAlterar() {
		return disabledBtnAlterar;
	}

	public void setDisabledBtnAlterar(boolean disabledBtnAlterar) {
		this.disabledBtnAlterar = disabledBtnAlterar;
	}

	public boolean isDisabledBtnExcluir() {
		return disabledBtnExcluir;
	}

	public void setDisabledBtnExcluir(boolean disabledBtnExcluir) {
		this.disabledBtnExcluir = disabledBtnExcluir;
	}

	public ParametroUnidadeExternaVO getFiltro() {
		return filtro;
	}

	public void setFiltro(ParametroUnidadeExternaVO filtro) {
		this.filtro = filtro;
	}

	public List<SelectItem> getComboMoedas() {
		return comboMoedas;
	}

	public void setComboMoedas(List<SelectItem> comboMoedas) {
		this.comboMoedas = comboMoedas;
	}

	public String getStateIdListaFaixas() {
		return stateIdListaFaixas;
	}

	public void setStateIdListaFaixas(String stateIdListaFaixas) {
		this.stateIdListaFaixas = stateIdListaFaixas;
	}

	public Boolean getModoAlteracaoFaixa() {
		return modoAlteracaoFaixa;
	}

	public void setModoAlteracaoFaixa(Boolean modoAlteracaoFaixa) {
		this.modoAlteracaoFaixa = modoAlteracaoFaixa;
	}
}
