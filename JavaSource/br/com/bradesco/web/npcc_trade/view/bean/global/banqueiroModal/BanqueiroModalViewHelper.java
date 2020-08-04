/**
 * Nome: br.com.bradesco.web.npcd.view.bean.global
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 17/11/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.banqueiroModal;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.view.components.html.uiinputtext.UIInputTextBradesco;
import br.com.bradesco.web.aq.view.components.html.uiselectonemenu.UISelectOneMenuBradesco;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * Nome: BancoEmissorViewHelper.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 17/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class BanqueiroModalViewHelper {

	/**
	 * Item selecionado na lista de banco emissor
	 **/
	private Integer codItemSelecionadoLista = Numeros.ZERO;

	/**
	 * Variáveis de controle do MODAL BANCO EMISSOR
	 **/
	private Boolean renderModal = Boolean.FALSE;

	/** Variavel do tipo List<SelectItem>. */
	private List<SelectItem> comboSwiftCodeNomeModal = new ArrayList<SelectItem>();

	/** Variavel do tipo String. */
	private String txtCodigoDescricao = null;

	/** Variavel do tipo BradescoHtmlInputText. */
	private UIInputTextBradesco campoCodigoDescricaoModal = new UIInputTextBradesco();

	/** Variavel do tipo List<SelectItem>. */
	private List<SelectItem> comboPaisFiltro = new ArrayList<SelectItem>();

	/** Variavel do tipo List<SelectItem>. */
	private List<SelectItem> comboUfFiltro = new ArrayList<SelectItem>();

	/** Variavel do tipo List<SelectItem>. */
	private List<SelectItem> comboCidadeFiltro = new ArrayList<SelectItem>();

	/** Variavel do tipo UISelectOneMenuBradesco. */
	private UISelectOneMenuBradesco selectComboUfFiltro = new UISelectOneMenuBradesco();

	/** Variavel do tipo UISelectOneMenuBradesco. */
	private UISelectOneMenuBradesco selectComboCidadeFiltro = new UISelectOneMenuBradesco();

	/**
	 * Variáveis de com o id do modal
	 **/
	private String modalId = "";

	/**
	 * @return o valor do codItemSelecionadoLista
	 */
	public Integer getCodItemSelecionadoLista() {
		return codItemSelecionadoLista;
	}

	/**
	 * @param codItemSelecionadoLista
	 *            seta o novo valor para o campo codItemSelecionadoLista
	 */
	public void setCodItemSelecionadoLista(Integer codItemSelecionadoLista) {
		this.codItemSelecionadoLista = codItemSelecionadoLista;
	}

	/**
	 * @return o valor do renderModal
	 */
	public Boolean getRenderModal() {
		return renderModal;
	}

	/**
	 * @param renderModal
	 *            seta o novo valor para o campo renderModal
	 */
	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	/**
	 * @return o valor do modalId
	 */
	public String getModalId() {
		return modalId;
	}

	/**
	 * @param modalId
	 *            seta o novo valor para o campo modalId
	 */
	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	/**
	 * @return o valor do txtCodigoDescricao
	 */
	public String getTxtCodigoDescricao() {
		return txtCodigoDescricao;
	}

	/**
	 * @param txtCodigoDescricao
	 *            seta o novo valor para o campo txtCodigoDescricao
	 */
	public void setTxtCodigoDescricao(String txtCodigoDescricao) {
		this.txtCodigoDescricao = txtCodigoDescricao;
	}

	/**
	 * @return o valor do campoCodigoDescricaoModal
	 */
	public UIInputTextBradesco getCampoCodigoDescricaoModal() {
		return campoCodigoDescricaoModal;
	}

	/**
	 * @param campoCodigoDescricaoModal
	 *            seta o novo valor para o campo campoCodigoDescricaoModal
	 */
	public void setCampoCodigoDescricaoModal(
			UIInputTextBradesco campoCodigoDescricaoModal) {
		this.campoCodigoDescricaoModal = campoCodigoDescricaoModal;
	}

	/**
	 * @return o valor do comboSwiftCodeNomeModal
	 */
	public List<SelectItem> getComboSwiftCodeNomeModal() {
		return comboSwiftCodeNomeModal;
	}

	/**
	 * @param comboSwiftCodeNomeModal
	 *            seta o novo valor para o campo comboSwiftCodeNomeModal
	 */
	public void setComboSwiftCodeNomeModal(
			List<SelectItem> comboSwiftCodeNomeModal) {
		this.comboSwiftCodeNomeModal = comboSwiftCodeNomeModal;
	}

	/**
	 * @return o valor do comboPaisFiltro
	 */
	public List<SelectItem> getComboPaisFiltro() {
		return comboPaisFiltro;
	}

	/**
	 * @param comboPaisFiltro
	 *            seta o novo valor para o campo comboPaisFiltro
	 */
	public void setComboPaisFiltro(List<SelectItem> comboPaisFiltro) {
		this.comboPaisFiltro = comboPaisFiltro;
	}

	/**
	 * @return o valor do comboUfFiltro
	 */
	public List<SelectItem> getComboUfFiltro() {
		return comboUfFiltro;
	}

	/**
	 * @param comboUfFiltro
	 *            seta o novo valor para o campo comboUfFiltro
	 */
	public void setComboUfFiltro(List<SelectItem> comboUfFiltro) {
		this.comboUfFiltro = comboUfFiltro;
	}

	/**
	 * @return o valor do comboCidadeFiltro
	 */
	public List<SelectItem> getComboCidadeFiltro() {
		return comboCidadeFiltro;
	}

	/**
	 * @param comboCidadeFiltro
	 *            seta o novo valor para o campo comboCidadeFiltro
	 */
	public void setComboCidadeFiltro(List<SelectItem> comboCidadeFiltro) {
		this.comboCidadeFiltro = comboCidadeFiltro;
	}

	/**
	 * @return o valor do selectComboUfFiltro
	 */
	public UISelectOneMenuBradesco getSelectComboUfFiltro() {
		return selectComboUfFiltro;
	}

	/**
	 * @param selectComboUfFiltro
	 *            seta o novo valor para o campo selectComboUfFiltro
	 */
	public void setSelectComboUfFiltro(
			UISelectOneMenuBradesco selectComboUfFiltro) {
		this.selectComboUfFiltro = selectComboUfFiltro;
	}

	/**
	 * @return o valor do selectComboCidadeFiltro
	 */
	public UISelectOneMenuBradesco getSelectComboCidadeFiltro() {
		return selectComboCidadeFiltro;
	}

	/**
	 * @param selectComboCidadeFiltro
	 *            seta o novo valor para o campo selectComboCidadeFiltro
	 */
	public void setSelectComboCidadeFiltro(
			UISelectOneMenuBradesco selectComboCidadeFiltro) {
		this.selectComboCidadeFiltro = selectComboCidadeFiltro;
	}

}
