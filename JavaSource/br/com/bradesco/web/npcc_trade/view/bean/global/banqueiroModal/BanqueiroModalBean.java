/**
 * Nome: br.com.bradesco.web.npcd.view.bean.global
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 23/07/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.banqueiroModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.IBanqueiroModalService;
import br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.bean.BanqueiroModalVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;

/**
 *
 * Nome: BancoEmissorBean
 * 
 * Prop�sito: Bean de controle para modal de banco emissor
 *
 * Data: 17/06/2015 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
@Named(value = "banqueiroModalBean")
@SessionScoped
public class BanqueiroModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1L;

	/** Variavel de akxilio a tela */
	private BanqueiroModalViewHelper viewHelper = new BanqueiroModalViewHelper();

	/** LISTA MODAL BANQUEIRO **/
	private List<BanqueiroModalVO> lista = new ArrayList<BanqueiroModalVO>();

	/** MODAL BANQUEIRO **/
	private BanqueiroModalVO filtroVO = new BanqueiroModalVO();

	/** MODAL BANQUEIRO **/
	private BanqueiroModalVO banqueiroModalVO = new BanqueiroModalVO();

	@Inject
	@Named("banqueiroModalService")
	private IBanqueiroModalService service;

	@Inject
	@Named("selectItemBean")
	private SelectItemBean selectItemBean;

	/**
	 * Nome: openModalBancoEmissor
	 * 
	 * Prop�sito: Efetua pesquisa do banco emissor
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 11/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public void openModal() {

		// Limpa lista.
		setLista(new ArrayList<BanqueiroModalVO>());

		// limpa filtros
		setFiltroVO(new BanqueiroModalVO());

		// carrega lista de op��es radio
        List<SelectItem> list = new ArrayList<SelectItem>();
        list.add(new SelectItem(Numeros.NUM1.intValue(), "C�digo"));
        list.add(new SelectItem(Numeros.NUM2.intValue(), "Swift Code"));
        list.add(new SelectItem(Numeros.NUM3.intValue(), "Nome"));

		getViewHelper().setComboSwiftCodeNomeModal(list);

		// Faz o tratamento do alt do campo descri��o.
//		viewHelper.alterarAltCampoModal(Numeros.NUM1);
		viewHelper.setCodItemSelecionadoLista(Numeros.NUM0);

		// Define "Swift Code" como op��o selecionada.
		filtroVO.setTipopesquisa(Numeros.NUM1);

		getViewHelper().setTxtCodigoDescricao(SiteUtil.STRING_EMPTY);

		// habilita modal do banco emissor
		getViewHelper().setRenderModal(Boolean.TRUE);
	}

	/**
	 * 
	 * Nome: pesquisar
	 * 
	 * Prop�sito: Realiza a pesquisa dos banqueiros
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 15/10/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public void pesquisar(AjaxBehaviorEvent evento) {

		Integer tipoPesquisa = SiteUtil.getInt(filtroVO.getTipopesquisa());

		switch (tipoPesquisa) {
		case 1:
			filtroVO.setCbanqrcmbio(SiteUtil.getLong(getViewHelper()
					.getTxtCodigoDescricao()));
			break;

		case 2:
			filtroVO.setCidbanqrswift(getViewHelper().getTxtCodigoDescricao());
			break;

		case 3:
			filtroVO.setIbanqrcmbio(getViewHelper().getTxtCodigoDescricao());
			break;

		default:
			break;
		}

		// executa chamada CWS - Fluxo NPCDIADP - Books: NPCDWFGE / NPCDWFGS
		setLista(service.listar(filtroVO));

		// Seleciona o primeiro item da lista.
		viewHelper.setCodItemSelecionadoLista(Numeros.NUM0);

	}

	/**
	 * 
	 * Nome: paginar
	 * 
	 * Prop�sito: Retornar os dados conforme pagina��o
	 * 
	 * @param ActionEvent
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 11/08/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public void paginar(ActionEvent event) {
		setLista(service.listar(filtroVO));
	}

	/**
	 * Nome: selecionar
	 * 
	 * Prop�sito: Seleciona banco no modal
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 11/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public String selecionar() {

		// valida selecionado
		if (getLista().isEmpty()
				|| getViewHelper().getCodItemSelecionadoLista() == null) {
			BradescoFacesUtils.addInfoModalMessage("Selecione um Banqueiro.",
					false);
			return null;
		}

		// recupera o item seleciona na lista de banqueiros
		BanqueiroModalVO itemSelecionado = getLista().get(
				getViewHelper().getCodItemSelecionadoLista());

		banqueiroModalVO.setCbanqrcmbio(itemSelecionado.getCbanqrcmbio());
		banqueiroModalVO.setCbanqrcmbiop(itemSelecionado.getCbanqrcmbiop());
		banqueiroModalVO.setCidbanqrswift(itemSelecionado.getCidbanqrswift());
		banqueiroModalVO.setIbanqrcmbio(itemSelecionado.getIbanqrcmbio());
		banqueiroModalVO.setCflialbanqrswift(itemSelecionado
				.getCflialbanqrswift());
		banqueiroModalVO.setImunintlcmbio(itemSelecionado.getImunintlcmbio());

		return "/content/global/banqueiroModal/banqueiroCloseModal.xhtml";
	}

	/**
	 * Nome: alterarAltCampoModal
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 31/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public void alterarAltCampoModal(AjaxBehaviorEvent event) {

		alterarAltCampoModal();
	}

	/**
	 * Nome: alterarAltCampoModal
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 07/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public void alterarAltCampoModal() {

		// Aciona o m�todo utilizado para definir o alt de acordo com a op��o
		// selecionada.

		// Se a op��o selecionada for Pa�s o combo de pa�s deve ser carregado.
		if (filtroVO.getTipopesquisa().compareTo(Numeros.NUM4) == Numeros.NUM0
				|| filtroVO.getTipopesquisa().compareTo(Numeros.NUM5) == Numeros.NUM0) {

			// Limpa o combo de pa�s antes de carrega-lo novamente.
			viewHelper.setComboPaisFiltro(new ArrayList<SelectItem>());
			viewHelper.setComboPaisFiltro(selectItemBean.getPais("A"));
		}

		filtroVO.setCpais(null);
		filtroVO.setCmunintlcmbio(null);

		// Limpa o campo de input de c�digo/descri��o
		getViewHelper().setTxtCodigoDescricao(SiteUtil.STRING_EMPTY);

		// Limpa a lista
		setLista(new ArrayList<BanqueiroModalVO>());
	}

	/**
	 * Nome: closeModal
	 * 
	 * Prop�sito: Fecha modal banco emissor
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 11/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public void closeModal(ActionEvent event) {

		// ao fechar o modal limpa a lista
		setLista(new ArrayList<BanqueiroModalVO>());

		// desaabilita modal do banco emissor
		getViewHelper().setRenderModal(Boolean.FALSE);
	}

	/**
	 * Nome: getSelectItemRadioLista
	 * 
	 * Prop�sito: Retorna a lista de select item para a lista
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public List<SelectItem> getSelectItemRadioLista() {
		List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
		SiteUtil.atualizarSelectItem(lista, selectItemRadioLista);
		return selectItemRadioLista;
	}

	/**
	 * @return o valor do viewHelper
	 */
	public BanqueiroModalViewHelper getViewHelper() {
		return viewHelper;
	}

	/**
	 * @param viewHelper
	 *            seta o novo valor para o campo viewHelper
	 */
	public void setViewHelper(BanqueiroModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	/**
	 * @return o valor do lista
	 */
	public List<BanqueiroModalVO> getLista() {
		return lista;
	}

	/**
	 * @param lista
	 *            seta o novo valor para o campo lista
	 */
	public void setLista(List<BanqueiroModalVO> lista) {
		this.lista = lista;
	}

	/**
	 * @return o valor do banqueiroModalVO
	 */
	public BanqueiroModalVO getBanqueiroModalVO() {
		return banqueiroModalVO;
	}

	/**
	 * @param banqueiroModalVO
	 *            seta o novo valor para o campo banqueiroModalVO
	 */
	public void setBanqueiroModalVO(BanqueiroModalVO banqueiroModalVO) {
		this.banqueiroModalVO = banqueiroModalVO;
	}

	/**
	 * @return o valor do service
	 */
	public IBanqueiroModalService getService() {
		return service;
	}

	/**
	 * @param service
	 *            seta o novo valor para o campo service
	 */
	public void setService(IBanqueiroModalService service) {
		this.service = service;
	}

	/**
	 * @return o valor do filtroVO
	 */
	public BanqueiroModalVO getFiltroVO() {
		return filtroVO;
	}

	/**
	 * @param filtroVO
	 *            seta o novo valor para o campo filtroVO
	 */
	public void setFiltroVO(BanqueiroModalVO filtroVO) {
		this.filtroVO = filtroVO;
	}

}
