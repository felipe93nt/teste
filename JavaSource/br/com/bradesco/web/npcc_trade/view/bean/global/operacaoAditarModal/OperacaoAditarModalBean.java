package br.com.bradesco.web.npcc_trade.view.bean.global.operacaoAditarModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operacaoAditarModal.impl.OperacaoAditarModalServiceImpl;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoAditarVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named("operacaoAditarModalBean")
@SessionScoped
public class OperacaoAditarModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = -8478897192118812144L;

	private TrdFinNegOperVincVO operVinculadasVO = new TrdFinNegOperVincVO();

	private List<OperacaoAditarVO> listaModalOperacao = new ArrayList<OperacaoAditarVO>();

	private List<OperacaoAditarVO> listaOperacao = new ArrayList<OperacaoAditarVO>();

	private OperacaoAditarModalViewHelper viewHelper = new OperacaoAditarModalViewHelper();
	
	private Boolean closeModalOperacoesAditar = Boolean.FALSE;

	@Inject
	@Named("operacaoAditarModalServiceImpl")
	protected OperacaoAditarModalServiceImpl operacaoAditarModalServiceImpl;

	/**
	 * Nome: pesquisaOperacoesVinculadas
	 * 
	 * Prop�sito: Metodo do bot�o pesquisar do modal de opera��o vinculadas
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public void pesquisarOperacoesVinculadas() {

		try {

			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] OperacaoAditarModalBean.pesquisarOperacoesVinculadas <<<<<<<<<<<");

			getViewHelper().setStateIdListaModalOperacao("NPCCIAP4");
			
			OperacaoAditarVO operacao = new OperacaoAditarVO();
			operacao.setDanobase(getOperVinculadasVO().getDanobase());
			operacao.setNumoperacao(getOperVinculadasVO().getNumoperacao());
			
			setListaModalOperacao(operacaoAditarModalServiceImpl.getOperacoes(operacao));

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] OperacaoAditarModalBean.pesquisarOperacoesVinculadas <<<<<<<<<<<");
		}

	}

	/**
	 * Nome: selecionarModalOperacoesAditar
	 * 
	 * Prop�sito: Metodo para selecionar opera��es Aditar no modal
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public String selecionarModalOperacoesAditar() {

		try {

			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] OperacaoAditarModalBean.selecionarModalOperacoesAditar <<<<<<<<<<<");

			String item = "0";

			// valida se foi selecionado um item na lista
			if (getViewHelper().getItemSelecListaModalOperacao() == null
					|| getViewHelper().getItemSelecListaModalOperacao().length <= Numeros.ZERO) {
				NpcFacesUtils.addInfoModalMessage("Selecione um Registro.",
						false);
				return null;
			}
			
			setListaOperacao(new ArrayList<OperacaoAditarVO>());

			for (int i = 0; i < getViewHelper().getItemSelecListaModalOperacao().length; i++) {

				item = getViewHelper().getItemSelecListaModalOperacao()[i];

				getListaOperacao().add(getListaModalOperacao().get(SiteUtil.getInt(item)));
			}

			return "/content/global/operacaoAditarModal/operacaoAditarModalClose.xhtml";

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] OperacaoAditarModalBean.selecionarModalOperacoesAditar <<<<<<<<<<<");
		}

	}


	/**
	 * Nome: getSelectItemRadioListaModalOperacao
	 * 
	 * Prop�sito: Retorna o selectItem para opera��es
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public List<SelectItem> getSelectItemRadioListaModalOperacao() {

		try {

			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] OperacaoAditarModalBean.getSelectItemRadioListaModalOperacao <<<<<<<<<<<");

			List<SelectItem> list = new ArrayList<SelectItem>();

			// Percorre todos os itens da lista afim de criar os respectivos radio buttons
			for (int index = 0; index < getListaModalOperacao().size(); index++) {
				list.add(new SelectItem(index, "", ""));
			}

			return list;

		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] OperacaoAditarModalBean.getSelectItemRadioListaModalOperacao <<<<<<<<<<<");
		}

	}

	/**
	 * Nome: paginarOperacoesVinculadas
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public void paginarOperacoesVinculadas(ActionEvent event) {

		getViewHelper().setStateIdListaModalOperacao("NPCCIAPC");
	}

	public TrdFinNegOperVincVO getOperVinculadasVO() {
		return operVinculadasVO;
	}

	public void setOperVinculadasVO(TrdFinNegOperVincVO operVinculadasVO) {
		this.operVinculadasVO = operVinculadasVO;
	}

	public OperacaoAditarModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(OperacaoAditarModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public List<OperacaoAditarVO> getListaModalOperacao() {
		return listaModalOperacao;
	}

	public void setListaModalOperacao(List<OperacaoAditarVO> listaModalOperacao) {
		this.listaModalOperacao = listaModalOperacao;
	}

	public List<OperacaoAditarVO> getListaOperacao() {
		return listaOperacao;
	}

	public void setListaOperacao(List<OperacaoAditarVO> listaOperacao) {
		this.listaOperacao = listaOperacao;
	}

	public Boolean getCloseModalOperacoesAditar() {
		return closeModalOperacoesAditar;
	}

	public void setCloseModalOperacoesAditar(Boolean closeModalOperacoesAditar) {
		this.closeModalOperacoesAditar = closeModalOperacoesAditar;
	}
	
}
