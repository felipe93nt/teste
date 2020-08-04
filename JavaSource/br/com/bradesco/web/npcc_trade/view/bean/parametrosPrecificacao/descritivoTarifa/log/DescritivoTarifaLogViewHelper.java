/**
 *
 * Nome: DescritivoTarifaLogViewHelper.java
 * Propósito: <p> </p>
 *
 * @author :  Bradesco S.A.<BR/>
 * Equipe : CD <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 */
package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.descritivoTarifa.log;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.bean.DescritivoTarifaVO;

/**
 *
 * Nome: TarifaAutomaticaViewHelper.java Propósito:
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
public class DescritivoTarifaLogViewHelper {

	private String stateIdListaPesquisa = null;
    /**
     * Variavel utilizada para definier o filtro
     */
    private DescritivoTarifaVO filtro = new DescritivoTarifaVO();

	/**
	 * Variavel utilizada para definier o state id da lista de log
	 */
	private String nomeStateIdLista = null;

	private Boolean renderModalSalvar = false;
	
	/** Variavel do tipo boolean. */
	private boolean disabledBtnIncluir = Boolean.FALSE;
	
	/** Variavel do tipo boolean. */
	private boolean disabledBtnAlterar = Boolean.FALSE;

	/** Variavel do tipo boolean. */
	private boolean disabledBtnExcluir = Boolean.FALSE;

    private Integer codItemSelecionadoLista = null;

	private List<SelectItem> comboProdutos = new ArrayList<SelectItem>();

	/**
     * Variável de controle do modal de confirmação
     */
    Boolean renderModal = Boolean.FALSE;
    
    private Boolean renderBotoes = false;
    
	/**
	 * @return o valor do stateIdListaPesquisa
	 */
	public String getStateIdListaPesquisa() {
		return stateIdListaPesquisa;
	}

	/**
	 * @param stateIdListaPesquisa
	 *            seta o novo valor para o campo stateIdListaPesquisa
	 */
	public void setStateIdListaPesquisa(String stateIdListaPesquisa) {
		this.stateIdListaPesquisa = stateIdListaPesquisa;
	}

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

	public DescritivoTarifaVO getFiltro() {
		return filtro;
	}

	public void setFiltro(DescritivoTarifaVO filtro) {
		this.filtro = filtro;
	}
}
