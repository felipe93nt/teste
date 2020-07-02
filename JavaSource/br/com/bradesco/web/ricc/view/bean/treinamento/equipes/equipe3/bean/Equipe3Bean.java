package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe3.bean;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.service.business.cadastro.ICadastramentoRicService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.cadastro.bean.CadastramentoRicBean;
import br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.bean.ConsultaQuestionarioAltoVarejoBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe3.viewhelper.Equipe3ConsultaAltoVarejoViewHelper;
import br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe3.viewhelper.Equipe3ViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Foursys
 * @see Equipe3Bean.java
 * @version 1.0
 * @since 11/05/2020
 */
@SessionScoped
@Named(value = "equipe3Bean")
public class Equipe3Bean extends AbstractBean<Equipe3ViewHelper> {
	private static final long serialVersionUID = 1631866463606968265L;

	private ConsultaQuestionarioAltoVarejoBean consultaQuestionarioAltoVarejoBean = new ConsultaQuestionarioAltoVarejoBean();

	public ConsultaQuestionarioAltoVarejoBean getConsultaQuestionarioAltoVarejoBean() {
		return consultaQuestionarioAltoVarejoBean;
	}

	public void setConsultaQuestionarioAltoVarejoBean(
			ConsultaQuestionarioAltoVarejoBean consultaQuestionarioAltoVarejoBean) {
		this.consultaQuestionarioAltoVarejoBean = consultaQuestionarioAltoVarejoBean;
	}

	/**
	 * Atributo serialVersionUID Tipo long
	 */

	/**
	 * Atributo cadastramentoRicService Tipo ICadastramentoRicService
	 */
	@Inject
	@Named("cadastramentoRicService")
	private ICadastramentoRicService cadastramentoRicService;

	private String retorno = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new Equipe3ViewHelper());
		viewHelper.inicializar();
		carregarListaCadastramento();
		consultar();
		return RiccConstants.TREINAMENTO_EQUIPE_3_CONSULTA;
	}

	public String consultar() {

		CadastramentoVO itemSelecionado = new CadastramentoVO();

		for (CadastramentoVO lista : viewHelper.getListaCadastramento()) {
			if (lista.getCodRelatorio() == 561) {
				itemSelecionado = lista;
			}

		}

		if (siteUtil.isNotEmptyOrNull(itemSelecionado)) {
			Long codigoSegmento = Long
					.valueOf(itemSelecionado.getCodSegmento());

			if (RiccConstants.SEGMENTO_ALTOVAREJO.equals(codigoSegmento)) {
				Equipe3ConsultaQuestionarioAltoVarejoBean bean = (Equipe3ConsultaQuestionarioAltoVarejoBean) FacesUtils
						.getManagedBean("equipe3ConsultaQuestionarioAltoVarejoBean");
				bean.setViewHelper(new Equipe3ConsultaAltoVarejoViewHelper());				bean.getViewHelper().inicializar();
				bean.getViewHelper()
						.getModel()
						.setCodRelatorio(
								itemSelecionado.getCodRelatorio().toString());
				bean.getViewHelper()
						.getModel()
						.setCodGrupo(
								getViewHelper().getModelPesquisa()
										.getNumGrupoLabel());
				bean.getViewHelper()
						.getModel()
						.setNomeGrupo(
								getViewHelper().getModelPesquisa()
										.getNomeGrupoLabel());
				retorno = bean.iniciarPagina();
			}
		} else {
			siteUtil.getMessages().getMsgSelecioneUmItemLista("label_cadastro");
		}
		return retorno;
	}

	/**
	 * @description
	 * @name habilitarBotoes
	 * @see CadastramentoRicBean
	 * @return
	 * @return String
	 */
	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		CadastramentoVO cadastro = null;
		String usuarioLogado = null;
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		this.viewHelper.setBtnCopiar(Boolean.FALSE);
		this.viewHelper.setBtnAlterar(Boolean.FALSE);
		this.viewHelper.setBtnExcluir(Boolean.FALSE);
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {

			cadastro = this.viewHelper.getItemSelecionado().get(Numeros.ZERO);
			usuarioLogado = BradescoCommonServiceFactory.getSecurityManager()
					.getUserId().trim().toUpperCase();

			this.viewHelper.setBtnConsultar(Boolean.TRUE);
			this.viewHelper.setBtnCopiar(Boolean.TRUE);
			if (cadastro.getUsuarioInclusao().equals(usuarioLogado)
					&& cadastro.getCodSituacao() == Numeros.DOIS) {
				this.viewHelper.setBtnAlterar(Boolean.TRUE);
				this.viewHelper.setBtnExcluir(Boolean.TRUE);
			}
		}

	}

	/**
	 * @description
	 * @name carregarListaCadastramento
	 * @see CadastramentoRicBean
	 * @return
	 * @return String
	 */
	public String carregarListaCadastramento() {
		RetornoPesquisaCadastramentoVO retornoMainframe = new RetornoPesquisaCadastramentoVO();
		PesquisaCadastramentoVO modelPesquisa = viewHelper.getModelPesquisa();
		modelPesquisa.setNumGrupo("9");
		modelPesquisa.setTipoPesquisa(2);
		modelPesquisa.setStatus("4");
		modelPesquisa.setCnpj("");

		try {
			retornoMainframe = cadastramentoRicService
					.carregarListaCadastro(modelPesquisa);
			viewHelper
					.setListaCadastramento(carregarListaSetor(retornoMainframe
							.getListaCadastro()));

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			e.printStackTrace();
		}
		modelPesquisa.setNumGrupoLabel(retornoMainframe.getCodGrupo());
		modelPesquisa.setNomeGrupoLabel(retornoMainframe.getNomeGrupo());
		return RiccConstants.TELA_CADASTRO_RIC;
	}

	/**
	 * @description
	 * @name paginar
	 * @see CadastramentoRicBean
	 * @param ae
	 * @return void
	 */
	public void paginar(ActionEvent ae) {
		this.carregarListaCadastramento();
	}

	public List<CadastramentoVO> carregarListaSetor(
			List<CadastramentoVO> listaCadastro) {

		for (CadastramentoVO item : listaCadastro) {
			List<String> listaSetor = new ArrayList<String>();
			String setores = "";
			if (item.getFlagSetorAgricola().equals(Numeros.UM)) {
				listaSetor.add("AGRONEGOCIO");
			}
			if (item.getFlagSetorImobiliario().equals(Numeros.UM)) {
				listaSetor.add("IMOBILIARIO");
			}
			if (item.getFlagSetorTransporte().equals(Numeros.UM)) {
				listaSetor.add("TRANSPORTE");
			}
			if (item.getFlagSetorProjeto().equals(Numeros.UM)) {
				listaSetor.add("PROJETOS");
			}

			if (!listaSetor.isEmpty()) {
				setores = setores.concat(listaSetor.get(0));
				for (int i = 1; i < listaSetor.size(); i++) {
					setores = setores.concat(", " + listaSetor.get(i));
				}
			}
			item.setSetor(setores);

		}
		return listaCadastro;
	}

	/**
	 * @description
	 * @name validarCamposPesquisa
	 * @see CadastramentoRicBean
	 * @return
	 * @return boolean
	 */
	public boolean validarCamposPesquisa() {
		PesquisaCadastramentoVO model = viewHelper.getModelPesquisa();

		if (siteUtil.isNotEmptyOrNull(model.getCnpj())
				&& siteUtil.isEmptyOrNull(model.getNumGrupo())
				&& siteUtil.isEmptyOrNull(model.getNomeGrupo())) {
			model.setTipoPesquisa(Integer.parseInt(RiccConstants.PESQUISA_CNPJ));
			return true;
		} else if (siteUtil.isEmptyOrNull(model.getCnpj())
				&& siteUtil.isNotEmptyOrNull(model.getNumGrupo())
				&& siteUtil.isEmptyOrNull(model.getNomeGrupo())) {
			model.setTipoPesquisa(Integer
					.parseInt(RiccConstants.PESQUISA_NUMERO_GRUPO));
			return true;
		} else if (siteUtil.isEmptyOrNull(model.getCnpj())
				&& siteUtil.isEmptyOrNull(model.getNumGrupo())
				&& siteUtil.isNotEmptyOrNull(model.getNomeGrupo())) {
			model.setTipoPesquisa(Integer
					.parseInt(RiccConstants.PESQUISA_NOME_GRUPO));
			return true;
		} else if (siteUtil.isEmptyOrNull(model.getCnpj())
				&& siteUtil.isEmptyOrNull(model.getNumGrupo())
				&& siteUtil.isEmptyOrNull(model.getNomeGrupo())) {
			siteUtil.getMessages().getMsgInformada(
					"msg_preencher_campo_pesquisa");
			BradescoFacesUtils.addInfoModalMessage("- CNPJ", false);
			BradescoFacesUtils.addInfoModalMessage("- Grupo - Número", false);
			BradescoFacesUtils.addInfoModalMessage("- Grupo - Nome", false);

			return false;
		} else {
			siteUtil.getMessages().getMsgInformada("msg_preencher_somente_um");
			BradescoFacesUtils.addInfoModalMessage("- CNPJ", false);
			BradescoFacesUtils.addInfoModalMessage("- Grupo - Número", false);
			BradescoFacesUtils.addInfoModalMessage("- Grupo - Nome", false);
			return false;
		}

	}

	public void abrirModal() {
		inicializarCamposModal();// Limpa os campos do modal ao abri-lo
		viewHelper.setRenderModal(Boolean.TRUE);
	}

	public void inicializarCamposModal() {
		viewHelper.setSegmentoSelecionado(new TipoQuestionarioVO());
		viewHelper.setListaSegmento(siteUtil.carregarListaSegmento());
		viewHelper
				.setListaSetorSelecionado(new ArrayList<TipoQuestionarioVO>());
		viewHelper.setListaSetor(siteUtil.carregarListaSetor());
	}

}
