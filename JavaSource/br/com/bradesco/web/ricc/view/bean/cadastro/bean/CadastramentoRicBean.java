package br.com.bradesco.web.ricc.view.bean.cadastro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.enums.SegmentoEnum;
import br.com.bradesco.web.ricc.enums.SituacaoRelatorioEnum;
import br.com.bradesco.web.ricc.enums.TipoFuncaoEnum;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.service.business.cadastro.ICadastramentoRicService;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.RiccMessages;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.cadastro.viewhelper.CadastramentoRicViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.bean.ConsultaQuestionarioAltoVarejoBean;
import br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.bean.QuestionarioAltoVarejoBean;
import br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.viewhelper.ConsultaAltoVarejoViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionariocorporate.bean.ConsultaQuestionarioCorporateBean;
import br.com.bradesco.web.ricc.view.bean.questionariocorporate.bean.QuestionarioCorporateBean;
import br.com.bradesco.web.ricc.view.bean.questionariocorporate.viewhelper.ConsultaQuestionarioCorporateViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionariocorporate.viewhelper.QuestionarioCorporateViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionarioempresas.bean.ConsultaQuestionarioEmpresasBean;
import br.com.bradesco.web.ricc.view.bean.questionarioempresas.bean.QuestionarioEmpresasBean;
import br.com.bradesco.web.ricc.view.bean.questionarioempresas.viewhelper.ConsultaQuestionarioEmpresasViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionariolargecorporate.bean.ConsultaQuestionarioLargeCorporateBean;
import br.com.bradesco.web.ricc.view.bean.questionariolargecorporate.bean.QuestionarioLargeCorporateBean;
import br.com.bradesco.web.ricc.view.bean.questionariolargecorporate.viewhelper.ConsultaQuestionarioLargeCorporateViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionariolargecorporate.viewhelper.QuestionarioLargeCorporateViewHelper;

/**
 * @name CadastramentoRicBean
 * @author Foursys
 * @see Equipe4Bean.java
 * @version 1.0
 * @since 30/08/2018
 */
@SessionScoped
@Named(value = "cadastramentoRicBean")
public class CadastramentoRicBean extends
		AbstractBean<CadastramentoRicViewHelper> {

	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 1631866463606968265L;

	/**
	 * Atributo cadastramentoRicService Tipo ICadastramentoRicService
	 */
	@Inject
	@Named("cadastramentoRicService")
	private ICadastramentoRicService cadastramentoRicService;

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new CadastramentoRicViewHelper());
		viewHelper.inicializar();

		return RiccConstants.TELA_CADASTRO_RIC;
	}

	public String consultar() {
		CadastramentoVO itemSelecionado = getViewHelper().getItemSelecionado()
				.get(0);
		String retorno = "";

		if (siteUtil.isNotEmptyOrNull(itemSelecionado)) {
			Long codigoSegmento = Long
					.valueOf(itemSelecionado.getCodSegmento());

			if (RiccConstants.SEGMENTO_ALTOVAREJO.equals(codigoSegmento)) {
				ConsultaQuestionarioAltoVarejoBean bean = (ConsultaQuestionarioAltoVarejoBean) FacesUtils
						.getManagedBean("consultaQuestionarioAltoVarejoBean");

				bean.setViewHelper(new ConsultaAltoVarejoViewHelper());
				bean.getViewHelper().inicializar();
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

			} else if (RiccConstants.SEGMENTO_CORPORATE.equals(codigoSegmento)) {
				ConsultaQuestionarioCorporateBean bean = (ConsultaQuestionarioCorporateBean) FacesUtils
						.getManagedBean("consultaQuestionarioCorporateBean");

				bean.setViewHelper(new ConsultaQuestionarioCorporateViewHelper());
				bean.getViewHelper().inicializar();
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

			} else if (RiccConstants.SEGMENTO_LARGE_CORPORATE
					.equals(codigoSegmento)) {
				ConsultaQuestionarioLargeCorporateBean bean = (ConsultaQuestionarioLargeCorporateBean) FacesUtils
						.getManagedBean("consultaQuestionarioLargeCorporateBean");

				bean.setViewHelper(new ConsultaQuestionarioLargeCorporateViewHelper());
				bean.getViewHelper().inicializar();
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

			} else if (RiccConstants.SEGMENTO_EMPRESAS.equals(codigoSegmento)) {
				ConsultaQuestionarioEmpresasBean bean = (ConsultaQuestionarioEmpresasBean) FacesUtils
						.getManagedBean("consultaQuestionarioEmpresasBean");

				bean.setViewHelper(new ConsultaQuestionarioEmpresasViewHelper());
				bean.getViewHelper().inicializar();
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
		limparCamposCadastro();
		RetornoPesquisaCadastramentoVO retornoMainframe = new RetornoPesquisaCadastramentoVO();
		if (validarCamposPesquisa()) {
			PesquisaCadastramentoVO modelPesquisa = viewHelper
					.getModelPesquisa();
			try {
				retornoMainframe = cadastramentoRicService
						.carregarListaCadastro(modelPesquisa);
				viewHelper
						.setListaCadastramento(carregarListaSetor(retornoMainframe
								.getListaCadastro()));

			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}

			modelPesquisa.setNumGrupoLabel(retornoMainframe.getCodGrupo());
			modelPesquisa.setNomeGrupoLabel(retornoMainframe.getNomeGrupo());
		}
		return RiccConstants.TELA_CADASTRO_RIC;
	}

	private void limparCamposCadastro() {
		this.viewHelper.setBtnAlterar(Boolean.FALSE);
		this.viewHelper.setBtnExcluir(Boolean.FALSE);
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		this.viewHelper.setBtnCopiar(Boolean.FALSE);
		this.viewHelper.getListaCadastramento().clear();
		this.viewHelper.getItemSelecionado().clear();
		this.viewHelper.getModelPesquisa().setNumGrupoLabel("");
		this.viewHelper.getModelPesquisa().setNomeGrupoLabel("");
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

	/**
	 * @description
	 * @name incluir
	 * @see CadastramentoRicBean
	 * @return
	 * @return String
	 */
	public String incluir() {
		TipoQuestionarioVO segmento = getViewHelper().getSegmentoSelecionado();
		List<TipoQuestionarioVO> listaSetorSelecionado = this.getViewHelper()
				.getListaSetorSelecionado();
		String retorno = "";

		if (siteUtil.isNotEmptyOrNull(segmento)) {

			Long codigoSegmento = segmento.getCodigo();

			if (RiccConstants.SEGMENTO_ALTOVAREJO.equals(codigoSegmento)) {
				QuestionarioAltoVarejoBean bean = (QuestionarioAltoVarejoBean) FacesUtils
						.getManagedBean(segmento.getNomeBean());
				try {
					retorno = bean.iniciarPagina();

					bean.getViewHelper()
							.getAltoVarejoVO()
							.setCodGrupo(
									viewHelper.getModelPesquisa()
											.getNumGrupoLabel());
					bean.getViewHelper()
							.getAltoVarejoVO()
							.setNomeGrupo(
									viewHelper.getModelPesquisa()
											.getNomeGrupoLabel());

					bean.getViewHelper()
							.getAltoVarejoVO()
							.setSetorSelecionado(
									viewHelper.getListaSetorSelecionado());

					String codRelatorio = segmentoService
							.manutencaoRelatorioInfoCredito(bean
									.getViewHelper().getAltoVarejoVO(),
									TipoFuncaoEnum.NOVO,
									SituacaoRelatorioEnum.PROVISORIO,
									SegmentoEnum.ALTO_VAREJO);

					bean.getViewHelper().getAltoVarejoVO()
							.setCodRelatorio(codRelatorio);
					segmentoService.manutencaoRelatorioSegmento(bean
							.getViewHelper().getAltoVarejoVO(),
							TipoManutencaoEnum.INCLUSAO);

					for (TipoQuestionarioVO setor : listaSetorSelecionado) {
						bean.getViewHelper().getAltoVarejoVO().setSetor(setor);
						bean.incluirSetor();
					}
					bean.getViewHelper()
							.getAltoVarejoVO()
							.setCodSituacaoRelatorio(
									SituacaoRelatorioEnum.PROVISORIO
											.getCodigo().toString());

				} catch (Exception e) {
					siteUtil.trataExceptionRecebida(e);
					return null;
				}

			} else if (RiccConstants.SEGMENTO_CORPORATE.equals(codigoSegmento)) {
				QuestionarioCorporateBean bean = (QuestionarioCorporateBean) FacesUtils
						.getManagedBean(segmento.getNomeBean());
				bean.setViewHelper(new QuestionarioCorporateViewHelper());
				bean.getViewHelper().inicializar();
				try {
					retorno = bean.iniciarPagina();

					bean.getViewHelper()
							.getModel()
							.setCodGrupo(
									viewHelper.getModelPesquisa()
											.getNumGrupoLabel());
					bean.getViewHelper()
							.getModel()
							.setNomeGrupo(
									viewHelper.getModelPesquisa()
											.getNomeGrupoLabel());

					String codRelatorio = segmentoService
							.manutencaoRelatorioInfoCredito(bean
									.getViewHelper().getModel(),
									TipoFuncaoEnum.NOVO,
									SituacaoRelatorioEnum.PROVISORIO,
									SegmentoEnum.CORPORATE);

					bean.getViewHelper().getModel()
							.setCodRelatorio(codRelatorio);
					segmentoService.manutencaoRelatorioSegmento(bean
							.getViewHelper().getModel(),
							TipoManutencaoEnum.INCLUSAO);

					for (TipoQuestionarioVO setor : listaSetorSelecionado) {
						bean.getViewHelper().getModel().setSetor(setor);
						bean.incluirSetor();
					}
					bean.getViewHelper()
							.getModel()
							.setCodSituacaoRelatorio(
									SituacaoRelatorioEnum.PROVISORIO
											.getCodigo().toString());

				} catch (Exception e) {
					siteUtil.trataExceptionRecebida(e);
					return null;
				}
			} else if (RiccConstants.SEGMENTO_LARGE_CORPORATE
					.equals(codigoSegmento)) {
				QuestionarioLargeCorporateBean bean = (QuestionarioLargeCorporateBean) FacesUtils
						.getManagedBean(segmento.getNomeBean());
				bean.setViewHelper(new QuestionarioLargeCorporateViewHelper());
				bean.getViewHelper().inicializar();
				try {
					retorno = bean.iniciarPagina();

					bean.getViewHelper()
							.getModel()
							.setCodGrupo(
									viewHelper.getModelPesquisa()
											.getNumGrupoLabel());
					bean.getViewHelper()
							.getModel()
							.setNomeGrupo(
									viewHelper.getModelPesquisa()
											.getNomeGrupoLabel());
					String codRelatorio = segmentoService
							.manutencaoRelatorioInfoCredito(bean
									.getViewHelper().getModel(),
									TipoFuncaoEnum.NOVO,
									SituacaoRelatorioEnum.PROVISORIO,
									SegmentoEnum.LARGE_CORPORATE);

					bean.getViewHelper().getModel()
							.setCodRelatorio(codRelatorio);
					segmentoService.manutencaoRelatorioSegmento(bean
							.getViewHelper().getModel(),
							TipoManutencaoEnum.INCLUSAO);

					for (TipoQuestionarioVO setor : listaSetorSelecionado) {
						bean.getViewHelper().getModel().setSetor(setor);
						bean.incluirSetor();
					}
					bean.getViewHelper()
							.getModel()
							.setCodSituacaoRelatorio(
									SituacaoRelatorioEnum.PROVISORIO
											.getCodigo().toString());

				} catch (Exception e) {
					siteUtil.trataExceptionRecebida(e);
					return null;
				}
			} else if (RiccConstants.SEGMENTO_EMPRESAS.equals(codigoSegmento)) {
				QuestionarioEmpresasBean bean = (QuestionarioEmpresasBean) FacesUtils
						.getManagedBean(segmento.getNomeBean());
				retorno = bean.iniciarPagina();

				bean.getViewHelper()
						.getQuestionarioEmpresasVO()
						.setCodGrupo(
								viewHelper.getModelPesquisa()
										.getNumGrupoLabel());
				bean.getViewHelper()
						.getQuestionarioEmpresasVO()
						.setNomeGrupo(
								viewHelper.getModelPesquisa()
										.getNomeGrupoLabel());

				String codRelatorio = segmentoService
						.manutencaoRelatorioInfoCredito(bean.getViewHelper()
								.getQuestionarioEmpresasVO(),
								TipoFuncaoEnum.NOVO,
								SituacaoRelatorioEnum.PROVISORIO,
								SegmentoEnum.EMPRESAS);
				bean.getViewHelper().getQuestionarioEmpresasVO()
						.setCodRelatorio(codRelatorio);

				segmentoService.manutencaoRelatorioSegmento(bean
						.getViewHelper().getQuestionarioEmpresasVO(),
						TipoManutencaoEnum.INCLUSAO);

				for (TipoQuestionarioVO setor : listaSetorSelecionado) {
					bean.getViewHelper().getQuestionarioEmpresasVO()
							.setSetor(setor);
					bean.incluirSetor();
				}

				bean.getViewHelper()
						.getQuestionarioEmpresasVO()
						.setCodSituacaoRelatorio(
								SituacaoRelatorioEnum.PROVISORIO.getCodigo()
										.toString());
			}
			viewHelper.setRenderModal(Boolean.FALSE);
		} else {
			siteUtil.getMessages().getMsgSelecioneUmItemLista("label_segmento");
		}
		return retorno;
	}

	public String alterar() {
		CadastramentoVO itemSelecionado = viewHelper.getItemSelecionado()
				.get(0);
		String retorno = "";

		if (siteUtil.isNotEmptyOrNull(itemSelecionado)) {
			Long codigoSegmento = Long
					.valueOf(itemSelecionado.getCodSegmento());

			if (RiccConstants.SEGMENTO_ALTOVAREJO.equals(codigoSegmento)) {
				QuestionarioAltoVarejoBean bean = (QuestionarioAltoVarejoBean) FacesUtils
						.getManagedBean(RiccConstants.BEAN_QUESTIONARIO_ALTOVAREJO);
				try {
					retorno = bean.iniciarPagina();

					bean.getViewHelper()
							.getAltoVarejoVO()
							.setCodGrupo(
									viewHelper.getModelPesquisa()
											.getNumGrupoLabel());
					bean.getViewHelper()
							.getAltoVarejoVO()
							.setNomeGrupo(
									viewHelper.getModelPesquisa()
											.getNomeGrupoLabel());
					bean.getViewHelper()
							.getAltoVarejoVO()
							.setCodRelatorio(
									String.valueOf(itemSelecionado
											.getCodRelatorio()));
					bean.carregarDados();

				} catch (Exception e) {
					siteUtil.trataExceptionRecebida(e);
					return null;
				}

			} else if (RiccConstants.SEGMENTO_CORPORATE.equals(codigoSegmento)) {
				QuestionarioCorporateBean bean = (QuestionarioCorporateBean) FacesUtils
						.getManagedBean(RiccConstants.BEAN_QUESTIONARIO_CORPORATE);
				bean.setViewHelper(new QuestionarioCorporateViewHelper());
				bean.getViewHelper().inicializar();
				retorno = bean.iniciarPagina();

				bean.getViewHelper()
						.getModel()
						.setCodGrupo(
								viewHelper.getModelPesquisa()
										.getNumGrupoLabel());
				bean.getViewHelper()
						.getModel()
						.setNomeGrupo(
								viewHelper.getModelPesquisa()
										.getNomeGrupoLabel());
				bean.getViewHelper()
						.getModel()
						.setCodRelatorio(
								String.valueOf(itemSelecionado
										.getCodRelatorio()));
				bean.carregarDados();

			} else if (RiccConstants.SEGMENTO_LARGE_CORPORATE
					.equals(codigoSegmento)) {
				QuestionarioLargeCorporateBean bean = (QuestionarioLargeCorporateBean) FacesUtils
						.getManagedBean(RiccConstants.BEAN_QUESTIONARIO_LARGE_CORPORATE);
				bean.setViewHelper(new QuestionarioLargeCorporateViewHelper());
				bean.getViewHelper().inicializar();
				retorno = bean.iniciarPagina();

				bean.getViewHelper()
						.getModel()
						.setCodGrupo(
								viewHelper.getModelPesquisa()
										.getNumGrupoLabel());
				bean.getViewHelper()
						.getModel()
						.setNomeGrupo(
								viewHelper.getModelPesquisa()
										.getNomeGrupoLabel());
				bean.getViewHelper()
						.getModel()
						.setCodRelatorio(
								String.valueOf(itemSelecionado
										.getCodRelatorio()));
				bean.carregarDados();

			} else if (RiccConstants.SEGMENTO_EMPRESAS.equals(codigoSegmento)) {
				QuestionarioEmpresasBean bean = (QuestionarioEmpresasBean) FacesUtils
						.getManagedBean(RiccConstants.BEAN_QUESTIONARIO_EMPRESAS);
				retorno = bean.iniciarPagina();

				bean.getViewHelper()
						.getQuestionarioEmpresasVO()
						.setCodGrupo(
								viewHelper.getModelPesquisa()
										.getNumGrupoLabel());
				bean.getViewHelper()
						.getQuestionarioEmpresasVO()
						.setNomeGrupo(
								viewHelper.getModelPesquisa()
										.getNomeGrupoLabel());
				bean.getViewHelper()
						.getQuestionarioEmpresasVO()
						.setCodRelatorio(
								String.valueOf(itemSelecionado
										.getCodRelatorio()));
				bean.carregarDados();

			}
		} else {
			siteUtil.getMessages().getMsgSelecioneUmItemLista("label_segmento");
		}
		return retorno;
	}

	public String excluir() {
		CadastramentoVO itemSelecionado = viewHelper.getItemSelecionado()
				.get(0);

		String retorno = "";

		if (siteUtil.isNotEmptyOrNull(itemSelecionado)) {
			String codGrupo = getViewHelper().getModelPesquisa()
					.getNumGrupoLabel();
			Integer nRelatorio = itemSelecionado.getCodRelatorio();

			retorno = segmentoService.excluirRelatorio(codGrupo, nRelatorio);

			fecharModalExcluir();

			RiccMessages.getInstance().getMsgExclusaoSucesso();
			return carregarListaCadastramento();
		}
		return retorno;
	}

	public String copiar() {

		CadastramentoVO itemSelecionado = viewHelper.getItemSelecionado()
				.get(0);

		if (siteUtil.isNotEmptyOrNull(itemSelecionado)) {
			String codGrupo = getViewHelper().getModelPesquisa()
					.getNumGrupoLabel();

			// Chamada do Service
			int codRelatorio = segmentoService.copiarCadastro(itemSelecionado,
					codGrupo);

			itemSelecionado.setCodRelatorio(codRelatorio);

			return alterar();
		}
		return "";
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

	public void abrirModalExcluir() {
		viewHelper.setRenderModalExcluir(Boolean.TRUE);
	}

	public void fecharModal() {
		viewHelper.setRenderModal(Boolean.FALSE);
	}

	public void fecharModalExcluir() {
		viewHelper.setRenderModalExcluir(Boolean.FALSE);
	}

	public String voltar() {

		getViewHelper().getItemSelecionado().clear();
		this.viewHelper.setBtnAlterar(Boolean.FALSE);
		this.viewHelper.setBtnExcluir(Boolean.FALSE);
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		this.viewHelper.setBtnCopiar(Boolean.FALSE);

		return RiccConstants.TELA_CADASTRO_RIC;
	}

}
