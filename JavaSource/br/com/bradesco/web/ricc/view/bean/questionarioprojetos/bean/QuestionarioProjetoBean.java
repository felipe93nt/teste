package br.com.bradesco.web.ricc.view.bean.questionarioprojetos.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.enums.ComentarioEnum;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.ConstrutoresFornecedoresVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.EstruturaSocietariaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.UsosFontesVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.xls.SetorProjetosVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.service.business.questionarioprojeto.IQuestionarioProjetoService;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.Numeros;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.RiccMessages;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.questionarioprojetos.viewhelper.QuestionarioProjetoViewHelper;
import br.com.bradesco.web.ricc.xls.QuestionarioProjetoXLS;

@SessionScoped
@Named(value = "questionarioProjetoBean")
public class QuestionarioProjetoBean extends
		AbstractBean<QuestionarioProjetoViewHelper> {

	private static final long serialVersionUID = 8068886362299034108L;

	@Inject
	@Named("questionarioProjetoService")
	private IQuestionarioProjetoService questionarioProjetoService;

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;

	private String paginaAnterior = "";
	private Date dtIn;
	private Date dtTerm;
	private List<UsosFontesVO> listaTempUsosFontes = new ArrayList<UsosFontesVO>();
	private List<ConstrutoresFornecedoresVO> listaTempConstForn = new ArrayList<ConstrutoresFornecedoresVO>();

	private ArrayList<String> mensagens = new ArrayList<String>();

	private DiskFileItem file;
	private File tempFile;

	private int erroContDtInicio = 0;
	private boolean erroDtInicio = false;

	@Override
	public String iniciarPagina() {
		setViewHelper(new QuestionarioProjetoViewHelper());
		viewHelper.inicializar();
		setListaTempUsosFontes(new ArrayList<UsosFontesVO>());
		setListaTempConstForn(new ArrayList<ConstrutoresFornecedoresVO>());
		return RiccConstants.TELA_QUESTIONARIO_PROJETO;
	}

	public void carregarDados() {
		// consulta relatório
		consultaRelatorioProjeto();

		// consulta estrutura societária
		listarEstruturaSocietaria();

		// consulta usos
		listarUsosFontes();

		// consulta fontes
		listarFontes();

		// consulta construtores
		listarConstrutoresFornecedores();

		// consulta fornecedores
		listarFornecedores();

		// consulta comentários
		consultaComentarios();

		siteUtil.retirarMensagemDuplicada();
	}

	private void consultaComentarios() {
		QuestionarioProjetoVO model = viewHelper.getModel();

		try {
			/*
			 * Sequência de comentário Descrição do projeto - 1/0 Detalhar
			 * fontes de financiamento - 2/1 Status de licenciamento
			 * socioambiental - 3/2
			 */
			List<ComentarioVO> _comentarios = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_PROJETOS);

			model.setDescProjeto(_comentarios.get(0).getComentario());
			model.setDescFonteFinanStatus(_comentarios.get(1).getComentario());
			model.setDescComentariosStatusLicenciamento(_comentarios.get(2)
					.getComentario());

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void listarConstrutoresFornecedores() {
		QuestionarioProjetoVO model = viewHelper.getModel();
		try {
			model.setListConstrutoresFornecedores(questionarioProjetoService
					.consultaConstrutoresFornecedores(model, 1));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (model.getListConstrutoresFornecedores().size() < Numeros.CINCO) {
			model.getListConstrutoresFornecedores().add(
					new ConstrutoresFornecedoresVO());
		}
		try {
			copiarQuadroConstrutores();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void listarFornecedores() {
		QuestionarioProjetoVO model = viewHelper.getModel();
		try {
			model.setListFornecedores(questionarioProjetoService
					.consultaConstrutoresFornecedores(model, 2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (model.getListFornecedores().size() < Numeros.CINCO) {
			model.getListFornecedores().add(new ConstrutoresFornecedoresVO());
		}
		try {
			copiarQuadroFornecedores();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void listarUsosFontes() {
		QuestionarioProjetoVO model = viewHelper.getModel();

		try {
			model.setListUsosFontes(questionarioProjetoService
					.consultaQuadroUsosFontes(model, 1));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		if (model.getListUsosFontes().size() != 0) {
			model.getUsosFontes().setDtInicio(
					model.getListUsosFontes().get(0).getDtInicio());
			model.getUsosFontes().setDtTermino(
					model.getListUsosFontes().get(0).getDtTermino());
		}

		while (model.getListUsosFontes().size() < Numeros.DEZ) {
			model.getListUsosFontes().add(new UsosFontesVO());
		}
		try {
			copiarQuadroUsosFontes();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void listarFontes() {
		QuestionarioProjetoVO model = viewHelper.getModel();
		try {
			model.setListaFontes(questionarioProjetoService
					.consultaQuadroUsosFontes(model, 2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		if (model.getListaFontes().size() != 0) {
			model.getUsosFontes().setDtInicio(
					model.getListaFontes().get(0).getDtInicio());
			model.getUsosFontes().setDtTermino(
					model.getListaFontes().get(0).getDtTermino());
		}

		while (model.getListaFontes().size() < Numeros.DEZ) {
			model.getListaFontes().add(new UsosFontesVO());
		}
		try {
			copiarQuadroFontes();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void listarEstruturaSocietaria() {
		QuestionarioProjetoVO model = viewHelper.getModel();

		model.getListEstruturaSocietariaSelecionado().clear();
		model.getListEstruturaSocietaria().clear();
		try {
			model.setListEstruturaSocietaria(questionarioProjetoService
					.consultaEstruturaSocietaria(model));

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (model.getListEstruturaSocietaria().size() < Numeros.CINCO) {
			model.getListEstruturaSocietaria().add(new EstruturaSocietariaVO());
		}
		try {
			copiarEstruturaSocietaria();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void copiarEstruturaSocietaria() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<EstruturaSocietariaVO> listaCopia = new ArrayList<EstruturaSocietariaVO>();
		EstruturaSocietariaVO voCopia = null;
		for (EstruturaSocietariaVO itemTabela : this.viewHelper.getModel()
				.getListEstruturaSocietaria()) {
			voCopia = new EstruturaSocietariaVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if (siteUtil.isEmptyOrNull(voCopia.getDescAcionista())) {
				voCopia.setDescAcionista("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPrcParticipacao())) {
				voCopia.setPrcParticipacao("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListaEstruturaSocietaria(listaCopia);
	}

	private void consultaRelatorioProjeto() {
		QuestionarioProjetoVO model = viewHelper.getModel();
		try {
			QuestionarioProjetoVO modelRetorno = questionarioProjetoService
					.consultaRelatorioProjeto(model);
			model.setNomeProjeto(modelRetorno.getNomeProjeto());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void estruturaSocietaria() {
		QuestionarioProjetoVO model = viewHelper.getModel();
		int contador = 0;
		for (EstruturaSocietariaVO itemTabela : viewHelper.getModel()
				.getListEstruturaSocietaria()) {
			if (!itemTabela.equals(viewHelper.getModel()
					.getCopiaListaEstruturaSocietaria().get(contador))) {
				// INCLUSÃO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getDescAcionista())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPrcParticipacao())) {
					try {
						questionarioProjetoService
								.manutencaoEstruturaSocietaria(model,
										RiccConstants.MANUTENCAO_INCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil
								.isEmptyOrNull(itemTabela.getDescAcionista())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPrcParticipacao())) {
					try {
						questionarioProjetoService
								.manutencaoEstruturaSocietaria(model,
										RiccConstants.MANUTENCAO_EXCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getModel().getCopiaListaEstruturaSocietaria()
						.get(contador).getNumSequencial()) {
					try {
						questionarioProjetoService
								.manutencaoEstruturaSocietaria(model,
										RiccConstants.MANUTENCAO_INCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarEstruturaSocietaria();
	}

	public void incluirEstruturaSocietaria(ActionEvent ae) {
		QuestionarioProjetoVO model = viewHelper.getModel();
		EstruturaSocietariaVO objInput = model.getAcionista();

		try {
			questionarioProjetoService.manutencaoEstruturaSocietaria(model,
					RiccConstants.MANUTENCAO_INCLUSAO, objInput);

			// Limpa os campos de input
			viewHelper.getModel().setAcionista(new EstruturaSocietariaVO());

			listarEstruturaSocietaria();

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		viewHelper.setDesabilitaIncluirAcionista(true);
	}

	public void excluirEstruturaSocietaria(ActionEvent ae) {
		QuestionarioProjetoVO model = viewHelper.getModel();
		EstruturaSocietariaVO _itemSelecionado = viewHelper.getModel()
				.getListEstruturaSocietariaSelecionado().get(0);
		try {
			questionarioProjetoService.manutencaoEstruturaSocietaria(model,
					RiccConstants.MANUTENCAO_EXCLUSAO, _itemSelecionado);

			// Limpa os campos de input
			viewHelper.getModel().getListEstruturaSocietariaSelecionado()
					.clear();

			listarEstruturaSocietaria();

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	public void construtoresFornecedores() {
		QuestionarioProjetoVO model = viewHelper.getModel();

		for (ConstrutoresFornecedoresVO construtoresFornecedores : viewHelper
				.getModel().getListConstrutoresFornecedores()) {

			if (construtoresFornecedores.getNumSequencial() > 0
					&& siteUtil.isEmptyOrNull(construtoresFornecedores
							.getDescConstrutoresFornecedores())) {
				try {
					questionarioProjetoService
							.manutencaoConstrutoresFornecedores(model,
									RiccConstants.MANUTENCAO_EXCLUSAO,
									construtoresFornecedores);
				} catch (Exception e) {
					siteUtil.trataExceptionRecebida(e);
				}
			} else if (construtoresFornecedores.getNumSequencial() == 0
					&& siteUtil.isNotEmptyOrNull(construtoresFornecedores
							.getCdTipoDocumento())
					&& siteUtil.isNotEmptyOrNull(construtoresFornecedores
							.getDescConstrutoresFornecedores())) {
				try {
					questionarioProjetoService
							.manutencaoConstrutoresFornecedores(model,
									RiccConstants.MANUTENCAO_INCLUSAO,
									construtoresFornecedores);
				} catch (Exception e) {
					siteUtil.trataExceptionRecebida(e);
				}
			}
		}
		listarConstrutoresFornecedores();
	}

	public String voltar() {
		return paginaAnterior;
	}

	public void salvar(ActionEvent ae) {

		this.erroContDtInicio = 0;
		this.erroDtInicio = false;

		QuestionarioProjetoVO model = viewHelper.getModel();
		estruturaSocietaria();
		if (validarUsosFontesData()) {
			// TABELA USO
			quadroUsosFontes();
			// TABELA FONTES
			quadroFontes();
		}
		quadroConstrutores();
		quadroFornecedores();
		try {
			// salva o nome do projeto
			questionarioProjetoService.manutencaoRelatorioProjeto(model,
					TipoManutencaoEnum.ALTERACAO.getCodigoString());

			// salva os comentarios
			segmentoService.manutencaoComentarios(model,
					retornaListComentariosProjeto(), "");

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		if (mensagens.size() == 0) {
			RiccMessages.getInstance().getMsgSalvarSucesso();
		}
		mensagens.clear();

	}

	private boolean validarUsosFontesData() {
		if (siteUtil.isEmptyOrNull(viewHelper.getModel().getUsosFontes()
				.getDtInicio())
				|| siteUtil.isEmptyOrNull(viewHelper.getModel().getUsosFontes()
						.getDtTermino())) {
			for (UsosFontesVO itemTabela : viewHelper.getModel()
					.getListUsosFontes()) {
				if (siteUtil.isNotEmptyOrNull(itemTabela.getDescUsosFontes())
						|| siteUtil.isNotEmptyOrNull(itemTabela
								.getPrcParticipacao())) {
					BradescoFacesUtils.addInfoModalMessage(
							"Campo data Usos e Fontes inconsistente", false);
					mensagens.add("Campo data Usos e Fontes inconsistente");
					return false;
				}
			}
			for (UsosFontesVO itemTabela : viewHelper.getModel()
					.getListaFontes()) {
				if (siteUtil.isNotEmptyOrNull(itemTabela.getDescUsosFontes())
						|| siteUtil.isNotEmptyOrNull(itemTabela
								.getPrcParticipacao())) {
					BradescoFacesUtils.addInfoModalMessage(
							"Campo data Usos e Fontes inconsistente", false);
					mensagens.add("Campo data Usos e Fontes inconsistente");
					return false;
				}
			}
		}
		if (siteUtil.isNotEmptyOrNull(viewHelper.getModel().getUsosFontes()
				.getDtInicio())
				&& siteUtil.isNotEmptyOrNull(viewHelper.getModel()
						.getUsosFontes().getDtTermino())) {
			if (viewHelper
					.getModel()
					.getUsosFontes()
					.getDtInicio()
					.after(viewHelper.getModel().getUsosFontes().getDtTermino())) {
				BradescoFacesUtils
						.addInfoModalMessage(
								"Campo Data Inicio maior que Data Termino Usos e Fontes",
								false);
				mensagens
						.add("Campo Data Inicio maior que Data Termino Usos e Fontes");
				return false;
			}
		}
		return true;
	}

	private List<ComentarioVO> retornaListComentariosProjeto() {
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.PROJETO_DESCRICAO_PROJETO
				.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.PROJETO_DESCRICAO_PROJETO
				.getNumSequencial());
		comentario.setComentario(siteUtil.nullToString(viewHelper.getModel()
				.getDescProjeto()));
		comentarios.add(comentario);

		comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.PROJETO_FONTES_FINANCIAMENTO
				.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.PROJETO_FONTES_FINANCIAMENTO
				.getNumSequencial());
		comentario.setComentario(siteUtil.nullToString(viewHelper.getModel()
				.getDescFonteFinanStatus()));
		comentarios.add(comentario);

		comentario = new ComentarioVO();
		comentario
				.setCodTipo(ComentarioEnum.PROJETO_LICENCIAMENTO_SOCIOAMBIENTAL
						.getCodigo());
		comentario
				.setCodSequencial(ComentarioEnum.PROJETO_LICENCIAMENTO_SOCIOAMBIENTAL
						.getNumSequencial());
		comentario.setComentario(siteUtil.nullToString(viewHelper.getModel()
				.getDescComentariosStatusLicenciamento()));
		comentarios.add(comentario);

		return comentarios;
	}

	public void quadroUsosFontes() {
		int contador = 0;
		for (UsosFontesVO itemTabela : viewHelper.getModel()
				.getListUsosFontes()) {
			itemTabela.setCdTipoDocumento(1);
			UsosFontesVO copia = viewHelper.getModel()
					.getCopiaListalistUsosFontes().get(contador);
			copia.setCdTipoDocumento(1);
			itemTabela.setDtInicio(viewHelper.getModel().getUsosFontes()
					.getDtInicio());
			itemTabela.setDtTermino(viewHelper.getModel().getUsosFontes()
					.getDtTermino());
			if (!itemTabela.equalsPersonalzado(viewHelper.getModel()
					.getCopiaListalistUsosFontes().get(contador))) {
				// INCLUSAO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getDescUsosFontes())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPrcParticipacao())) {
					try {
						if (!siteUtil.isEmptyOrNull(viewHelper.getModel()
								.getUsosFontes().getDtInicio())) {
							setDtIn(viewHelper.getModel().getUsosFontes()
									.getDtInicio());
						} else if ((!siteUtil.isEmptyOrNull(getDtIn()))) {
							viewHelper.getModel().getUsosFontes()
									.setDtInicio(getDtIn());
						}

						if (!siteUtil.isEmptyOrNull(viewHelper.getModel()
								.getUsosFontes().getDtTermino())) {
							setDtTerm(viewHelper.getModel().getUsosFontes()
									.getDtTermino());
						} else if ((!siteUtil.isEmptyOrNull(getDtTerm()))) {
							viewHelper.getModel().getUsosFontes()
									.setDtTermino(getDtTerm());
						}

						itemTabela.setDtInicio(viewHelper.getModel()
								.getUsosFontes().getDtInicio());
						itemTabela.setDtTermino(viewHelper.getModel()
								.getUsosFontes().getDtTermino());
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService.manutencaoQuadroUsosFontes(
								model, RiccConstants.MANUTENCAO_INCLUSAO,
								itemTabela);
					} catch (Exception e) {
						if (e.getMessage().contains(
								"DATA DE INICIO INCONSISTENTE")
								|| e.getMessage().contains(
										"DATA DE TERMINO INCONSISTENTE")) {
							if (this.erroContDtInicio == 0
									&& this.erroDtInicio == false) {
								siteUtil.trataExceptionRecebida(e);
								mensagens.add(e.getMessage());
								this.erroContDtInicio++;
								this.erroDtInicio = true;
							}
						} else {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
					}
					// EXCLUSAO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela
								.getDescUsosFontes())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPrcParticipacao())) {
					try {
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService.manutencaoQuadroUsosFontes(
								model, RiccConstants.MANUTENCAO_EXCLUSAO,
								itemTabela);
					} catch (Exception e) {
						if (e.getMessage().contains(
								"DATA DE INICIO INCONSISTENTE")
								|| e.getMessage().contains(
										"DATA DE TERMINO INCONSISTENTE")) {
							if (this.erroContDtInicio == 0
									&& this.erroDtInicio == false) {
								siteUtil.trataExceptionRecebida(e);
								mensagens.add(e.getMessage());
								this.erroContDtInicio++;
								this.erroDtInicio = true;
							}
						} else {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
					}
					// ALTERACAO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getModel().getCopiaListalistUsosFontes().get(contador)
						.getNumSequencial()) {
					try {
						viewHelper.getModel().setUsosFontes(itemTabela);
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService.manutencaoQuadroUsosFontes(
								model, RiccConstants.MANUTENCAO_INCLUSAO,
								itemTabela);
					} catch (Exception e) {
						if (e.getMessage().contains(
								"DATA DE INICIO INCONSISTENTE")
								|| e.getMessage().contains(
										"DATA DE TERMINO INCONSISTENTE")) {
							if (this.erroContDtInicio == 0
									&& this.erroDtInicio == false) {
								siteUtil.trataExceptionRecebida(e);
								mensagens.add(e.getMessage());
								this.erroContDtInicio++;
								this.erroDtInicio = true;
							}
						} else {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
					}
				}
			}
			contador++;
		}
		listarUsosFontes();
	}

	public void quadroFontes() {
		int contador = 0;

		for (UsosFontesVO itemTabela : viewHelper.getModel().getListaFontes()) {
			itemTabela.setCdTipoDocumento(2);
			UsosFontesVO copia = viewHelper.getModel()
					.getCopiaListalistFontes().get(contador);
			copia.setCdTipoDocumento(2);
			itemTabela.setDtInicio(viewHelper.getModel().getUsosFontes()
					.getDtInicio());
			itemTabela.setDtTermino(viewHelper.getModel().getUsosFontes()
					.getDtTermino());
			if (!itemTabela.equalsPersonalzado(viewHelper.getModel()
					.getCopiaListalistFontes().get(contador))) {
				// INCLUSAO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getDescUsosFontes())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPrcParticipacao())) {
					try {
						if (!siteUtil.isEmptyOrNull(viewHelper.getModel()
								.getUsosFontes().getDtInicio())) {
							setDtIn(viewHelper.getModel().getUsosFontes()
									.getDtInicio());
						} else if ((!siteUtil.isEmptyOrNull(getDtIn()))) {
							viewHelper.getModel().getUsosFontes()
									.setDtInicio(getDtIn());
						}

						if (!siteUtil.isEmptyOrNull(viewHelper.getModel()
								.getUsosFontes().getDtTermino())) {
							setDtTerm(viewHelper.getModel().getUsosFontes()
									.getDtTermino());
						} else if ((!siteUtil.isEmptyOrNull(getDtTerm()))) {
							viewHelper.getModel().getUsosFontes()
									.setDtTermino(getDtTerm());
						}

						itemTabela.setDtInicio(viewHelper.getModel()
								.getUsosFontes().getDtInicio());
						itemTabela.setDtTermino(viewHelper.getModel()
								.getUsosFontes().getDtTermino());
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService.manutencaoQuadroUsosFontes(
								model, RiccConstants.MANUTENCAO_INCLUSAO,
								itemTabela);
					} catch (Exception e) {
						if (e.getMessage().contains(
								"DATA DE INICIO INCONSISTENTE")
								|| e.getMessage().contains(
										"DATA DE TERMINO INCONSISTENTE")) {
							if (this.erroContDtInicio == 0
									&& this.erroDtInicio == false) {
								siteUtil.trataExceptionRecebida(e);
								mensagens.add(e.getMessage());
								this.erroContDtInicio++;
							}
						} else {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
					}
					// EXCLUSAO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela
								.getDescUsosFontes())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPrcParticipacao())) {
					try {
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService.manutencaoQuadroUsosFontes(
								model, RiccConstants.MANUTENCAO_EXCLUSAO,
								itemTabela);
					} catch (Exception e) {
						if (e.getMessage().contains(
								"DATA DE INICIO INCONSISTENTE")
								|| e.getMessage().contains(
										"DATA DE TERMINO INCONSISTENTE")) {
							if (this.erroContDtInicio == 0
									&& this.erroDtInicio == false) {
								siteUtil.trataExceptionRecebida(e);
								mensagens.add(e.getMessage());
								this.erroContDtInicio++;
							}
						} else {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
					}
					// ALTERACAO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getModel().getCopiaListalistFontes().get(contador)
						.getNumSequencial()) {
					try {
						viewHelper.getModel().setUsosFontes(itemTabela);
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService.manutencaoQuadroUsosFontes(
								model, RiccConstants.MANUTENCAO_INCLUSAO,
								itemTabela);
					} catch (Exception e) {
						if (e.getMessage().contains(
								"DATA DE INICIO INCONSISTENTE")
								|| e.getMessage().contains(
										"DATA DE TERMINO INCONSISTENTE")) {
							if (this.erroContDtInicio == 0
									&& this.erroDtInicio == false) {
								siteUtil.trataExceptionRecebida(e);
								mensagens.add(e.getMessage());
								this.erroContDtInicio++;
							}
						} else {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
					}
				}
			}
			contador++;
		}
		listarFontes();
	}

	public void quadroConstrutores() {
		int contador = 0;

		for (ConstrutoresFornecedoresVO itemTabela : viewHelper.getModel()
				.getListConstrutoresFornecedores()) {
			itemTabela.setCdTipoDocumento(1);
			viewHelper.getModel().getCopiaListConstrutoresFornecedores()
					.get(contador).setCdTipoDocumento(1);
			if (!itemTabela.equals(viewHelper.getModel()
					.getCopiaListConstrutoresFornecedores().get(contador))) {
				// INCLUSAO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getDescConstrutoresFornecedores())) {
					try {
						viewHelper.getModel().setConstrutoresFornecedores(
								itemTabela);
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService
								.manutencaoConstrutoresFornecedores(model,
										RiccConstants.MANUTENCAO_INCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSAO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela
								.getDescConstrutoresFornecedores())) {
					try {
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService
								.manutencaoConstrutoresFornecedores(model,
										RiccConstants.MANUTENCAO_EXCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERACAO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getModel().getCopiaListConstrutoresFornecedores()
						.get(contador).getNumSequencial()) {
					try {
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService
								.manutencaoConstrutoresFornecedores(model,
										RiccConstants.MANUTENCAO_INCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarConstrutoresFornecedores();
	}

	public void quadroFornecedores() {
		int contador = 0;

		for (ConstrutoresFornecedoresVO itemTabela : viewHelper.getModel()
				.getListFornecedores()) {
			itemTabela.setCdTipoDocumento(2);
			viewHelper.getModel().getCopiaListFornecedores().get(contador)
					.setCdTipoDocumento(2);
			if (!itemTabela.equals(viewHelper.getModel()
					.getCopiaListFornecedores().get(contador))) {
				// INCLUSAO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getDescConstrutoresFornecedores())) {
					try {
						viewHelper.getModel().setConstrutoresFornecedores(
								itemTabela);
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService
								.manutencaoConstrutoresFornecedores(model,
										RiccConstants.MANUTENCAO_INCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSAO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela
								.getDescConstrutoresFornecedores())) {
					try {
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService
								.manutencaoConstrutoresFornecedores(model,
										RiccConstants.MANUTENCAO_EXCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERACAO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getModel().getCopiaListFornecedores().get(contador)
						.getNumSequencial()) {
					try {
						QuestionarioProjetoVO model = viewHelper.getModel();
						questionarioProjetoService
								.manutencaoConstrutoresFornecedores(model,
										RiccConstants.MANUTENCAO_INCLUSAO,
										itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarFornecedores();
	}

	public void copiarQuadroUsosFontes() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<UsosFontesVO> listaCopia = new ArrayList<UsosFontesVO>();
		UsosFontesVO voCopia = null;
		for (UsosFontesVO itemTabela : this.viewHelper.getModel()
				.getListUsosFontes()) {
			voCopia = new UsosFontesVO();
			if (itemTabela.getNumSequencial() != 0) {
				BeanUtils.copyProperties(voCopia, itemTabela);
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDescUsosFontes())) {
				voCopia.setDescUsosFontes("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPrcParticipacao())) {
				voCopia.setPrcParticipacao("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDtInicio())) {
				voCopia.setDtInicio(viewHelper.getModel().getUsosFontes()
						.getDtInicio());
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDtTermino())) {
				voCopia.setDtTermino(viewHelper.getModel().getUsosFontes()
						.getDtTermino());
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListalistUsosFontes(listaCopia);
	}

	public void copiarQuadroFontes() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<UsosFontesVO> listaCopia = new ArrayList<UsosFontesVO>();
		UsosFontesVO voCopia = null;
		for (UsosFontesVO itemTabela : this.viewHelper.getModel()
				.getListaFontes()) {
			voCopia = new UsosFontesVO();
			if (itemTabela.getNumSequencial() != 0) {
				BeanUtils.copyProperties(voCopia, itemTabela);
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDescUsosFontes())) {
				voCopia.setDescUsosFontes("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPrcParticipacao())) {
				voCopia.setPrcParticipacao("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDtInicio())) {
				voCopia.setDtInicio(viewHelper.getModel().getUsosFontes()
						.getDtInicio());
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDtTermino())) {
				voCopia.setDtTermino(viewHelper.getModel().getUsosFontes()
						.getDtTermino());
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListalistFontes(listaCopia);

	}

	public void copiarQuadroConstrutores() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<ConstrutoresFornecedoresVO> listaCopia = new ArrayList<ConstrutoresFornecedoresVO>();
		ConstrutoresFornecedoresVO voCopia = null;
		for (ConstrutoresFornecedoresVO itemTabela : this.viewHelper.getModel()
				.getListConstrutoresFornecedores()) {
			voCopia = new ConstrutoresFornecedoresVO();
			if ((!siteUtil.isEmptyOrNull(itemTabela
					.getDescConstrutoresFornecedores()))) {
				BeanUtils.copyProperties(voCopia, itemTabela);
			}
			if (siteUtil.isEmptyOrNull(voCopia
					.getDescConstrutoresFornecedores())) {
				voCopia.setDescConstrutoresFornecedores("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListConstrutoresFornecedores(listaCopia);
	}

	public void copiarQuadroFornecedores() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<ConstrutoresFornecedoresVO> listaCopia = new ArrayList<ConstrutoresFornecedoresVO>();
		ConstrutoresFornecedoresVO voCopia = null;
		for (ConstrutoresFornecedoresVO itemTabela : this.viewHelper.getModel()
				.getListFornecedores()) {
			voCopia = new ConstrutoresFornecedoresVO();
			if ((!siteUtil.isEmptyOrNull(itemTabela
					.getDescConstrutoresFornecedores()))) {
				BeanUtils.copyProperties(voCopia, itemTabela);
			}
			if (siteUtil.isEmptyOrNull(voCopia
					.getDescConstrutoresFornecedores())) {
				voCopia.setDescConstrutoresFornecedores("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListFornecedores(listaCopia);
	}

	public void upload() {
		try {
			if (this.file == null) {
				BradescoFacesUtils
						.addErrorModalMessage("Selecione a planilha para Upload.");
			} else {
				if (this.file.getName().toUpperCase().contains(".XLSM")) {
					this.tempFile = File.createTempFile("proj", ".xlsm");
					this.tempFile.deleteOnExit();

					copyToFile(this.file.getInputStream(), this.tempFile);

					SetorProjetosVO setorProjetosVO = new QuestionarioProjetoXLS()
							.lerSetorProjetosXLSM(this.tempFile);

					if (setorProjetosVO != null) {
						viewHelper.setModel(popularViaXls(setorProjetosVO));
						BradescoFacesUtils.addInfoModalMessage(
								"Processamento da planilha conclu�do.", false);
					} else {
						BradescoFacesUtils
								.addErrorModalMessage("Selecione a planilha de setor correspondente.");
					}
				} else {
					BradescoFacesUtils
							.addErrorModalMessage("Arquivo inv�lido para Upload.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		}
	}

	public void copyToFile(InputStream inputStream, File file) {

		OutputStream outputStream;

		try {
			outputStream = new FileOutputStream(file);
			IOUtils.copy(inputStream, outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		} catch (IOException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		}
	}

	public QuestionarioProjetoVO popularViaXls(SetorProjetosVO xls) {

		QuestionarioProjetoVO projeto = new QuestionarioProjetoVO();

		projeto.setNomeProjeto(xls.getNomeProjeto());
		projeto.setDescProjeto(xls.getDescricaoProjeto());

		// Estrutura Societaria
		List<EstruturaSocietariaVO> listEstruturaSocietaria = new ArrayList<EstruturaSocietariaVO>();
		EstruturaSocietariaVO estrutura = new EstruturaSocietariaVO();

		estrutura = new EstruturaSocietariaVO();
		estrutura.setDescAcionista(xls.getAcionistas1());
		estrutura.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getAcionistasParticipacao1()));
		listEstruturaSocietaria.add(estrutura);

		estrutura = new EstruturaSocietariaVO();
		estrutura.setDescAcionista(xls.getAcionistas2());
		estrutura.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getAcionistasParticipacao2()));
		listEstruturaSocietaria.add(estrutura);

		estrutura = new EstruturaSocietariaVO();
		estrutura.setDescAcionista(xls.getAcionistas3());
		estrutura.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getAcionistasParticipacao3()));
		listEstruturaSocietaria.add(estrutura);

		estrutura = new EstruturaSocietariaVO();
		estrutura.setDescAcionista(xls.getAcionistas4());
		estrutura.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getAcionistasParticipacao4()));
		listEstruturaSocietaria.add(estrutura);

		estrutura = new EstruturaSocietariaVO();
		estrutura.setDescAcionista(xls.getAcionistas5());
		estrutura.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getAcionistasParticipacao5()));
		listEstruturaSocietaria.add(estrutura);

		projeto.setListEstruturaSocietaria(listEstruturaSocietaria);
		while (projeto.getCopiaListaEstruturaSocietaria().size() < Numeros.CINCO) {
			projeto.getCopiaListaEstruturaSocietaria().add(
					new EstruturaSocietariaVO());
		}
		for (int i = 0; i < Numeros.CINCO; i++) {
			if (this.viewHelper.getModel().getListEstruturaSocietaria().get(i)
					.getNumSequencial() != 0) {
				projeto.getListEstruturaSocietaria()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel()
										.getListEstruturaSocietaria().get(i)
										.getNumSequencial());
				projeto.getCopiaListaEstruturaSocietaria()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel()
										.getCopiaListaEstruturaSocietaria()
										.get(i).getNumSequencial());
			}
		}

		/** Usos/Fontes **/

		if (siteUtil.isNotEmptyOrNull(xls.getDataInicio())) {
			projeto.getUsosFontes().setDtInicio(
					dateUtil.stringToDate(xls.getDataInicio(),
							dateUtil.DATA_SEM_HORA_BARRA));
		}
		if (siteUtil.isNotEmptyOrNull(xls.getDataTermino())) {
			projeto.getUsosFontes().setDtTermino(
					dateUtil.stringToDate(xls.getDataTermino(),
							dateUtil.DATA_SEM_HORA_BARRA));
		}

		// Lista usos
		List<UsosFontesVO> listUsos = new ArrayList<UsosFontesVO>();
		UsosFontesVO usos;

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso1());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao1()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso2());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao2()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso3());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao3()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso4());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao4()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso5());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao5()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso6());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao6()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso7());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao7()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso8());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao8()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso9());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao9()));
		listUsos.add(usos);

		usos = new UsosFontesVO();
		usos.setDescUsosFontes(xls.getUso10());
		usos.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getUsoParticipacao10()));
		listUsos.add(usos);

		projeto.setListUsosFontes(listUsos);
		while (projeto.getCopiaListalistUsosFontes().size() < Numeros.DEZ) {
			projeto.getCopiaListalistUsosFontes().add(new UsosFontesVO());
		}
		for (int i = 0; i < Numeros.DEZ; i++) {
			if (this.viewHelper.getModel().getListUsosFontes().get(i)
					.getNumSequencial() != 0) {
				projeto.getListUsosFontes()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel().getListUsosFontes()
										.get(i).getNumSequencial());
				projeto.getCopiaListalistUsosFontes()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel()
										.getCopiaListalistUsosFontes().get(i)
										.getNumSequencial());
			}
		}

		// Lista fontes
		List<UsosFontesVO> listFontes = new ArrayList<UsosFontesVO>();
		UsosFontesVO fontes;

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes1());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao1()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes2());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao2()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes3());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao3()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes4());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao4()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes5());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao5()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes6());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao6()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes7());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao7()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes8());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao8()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes9());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao9()));
		listFontes.add(fontes);

		fontes = new UsosFontesVO();
		fontes.setDescUsosFontes(xls.getFontes10());
		fontes.setPrcParticipacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFontesParticipacao10()));
		listFontes.add(fontes);

		projeto.setListaFontes(listFontes);
		while (projeto.getCopiaListalistFontes().size() < Numeros.DEZ) {
			projeto.getCopiaListalistFontes().add(new UsosFontesVO());
		}
		for (int i = 0; i < Numeros.DEZ; i++) {
			if (this.viewHelper.getModel().getListaFontes().get(i)
					.getNumSequencial() != 0) {
				projeto.getListaFontes()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel().getListaFontes()
										.get(i).getNumSequencial());
				projeto.getCopiaListalistFontes()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel()
										.getCopiaListalistFontes().get(i)
										.getNumSequencial());
			}
		}

		// Status de Equacionamento do founding
		projeto.setDescFonteFinanStatus(xls.getStatusEquacionamento());

		/** Construtores/Fornecedores **/

		// Lista Construtores
		List<ConstrutoresFornecedoresVO> listaConstrutores = new ArrayList<ConstrutoresFornecedoresVO>();
		ConstrutoresFornecedoresVO construtores;

		construtores = new ConstrutoresFornecedoresVO();
		construtores.setDescConstrutoresFornecedores(xls.getConstrutores1());
		listaConstrutores.add(construtores);

		construtores = new ConstrutoresFornecedoresVO();
		construtores.setDescConstrutoresFornecedores(xls.getConstrutores2());
		listaConstrutores.add(construtores);

		construtores = new ConstrutoresFornecedoresVO();
		construtores.setDescConstrutoresFornecedores(xls.getConstrutores3());
		listaConstrutores.add(construtores);

		construtores = new ConstrutoresFornecedoresVO();
		construtores.setDescConstrutoresFornecedores(xls.getConstrutores4());
		listaConstrutores.add(construtores);

		construtores = new ConstrutoresFornecedoresVO();
		construtores.setDescConstrutoresFornecedores(xls.getConstrutores5());
		listaConstrutores.add(construtores);

		projeto.setListConstrutoresFornecedores(listaConstrutores);
		while (projeto.getCopiaListConstrutoresFornecedores().size() < Numeros.CINCO) {
			projeto.getCopiaListConstrutoresFornecedores().add(
					new ConstrutoresFornecedoresVO());
		}
		for (int i = 0; i < Numeros.CINCO; i++) {
			if (this.viewHelper.getModel().getListConstrutoresFornecedores()
					.get(i).getNumSequencial() != 0) {
				projeto.getListConstrutoresFornecedores()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel()
										.getListConstrutoresFornecedores()
										.get(i).getNumSequencial());
				projeto.getCopiaListConstrutoresFornecedores()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel()
										.getCopiaListConstrutoresFornecedores()
										.get(i).getNumSequencial());
			}
		}

		// Lista Fornecedores
		List<ConstrutoresFornecedoresVO> listaFornecedores = new ArrayList<ConstrutoresFornecedoresVO>();
		ConstrutoresFornecedoresVO fornecedores;

		fornecedores = new ConstrutoresFornecedoresVO();
		fornecedores.setDescConstrutoresFornecedores(xls.getFornecedores1());
		listaFornecedores.add(fornecedores);

		fornecedores = new ConstrutoresFornecedoresVO();
		fornecedores.setDescConstrutoresFornecedores(xls.getFornecedores2());
		listaFornecedores.add(fornecedores);

		fornecedores = new ConstrutoresFornecedoresVO();
		fornecedores.setDescConstrutoresFornecedores(xls.getFornecedores3());
		listaFornecedores.add(fornecedores);

		fornecedores = new ConstrutoresFornecedoresVO();
		fornecedores.setDescConstrutoresFornecedores(xls.getFornecedores4());
		listaFornecedores.add(fornecedores);

		fornecedores = new ConstrutoresFornecedoresVO();
		fornecedores.setDescConstrutoresFornecedores(xls.getFornecedores5());
		listaFornecedores.add(fornecedores);

		projeto.setListFornecedores(listaFornecedores);
		while (projeto.getCopiaListFornecedores().size() < Numeros.CINCO) {
			projeto.getCopiaListFornecedores().add(
					new ConstrutoresFornecedoresVO());
		}
		for (int i = 0; i < Numeros.CINCO; i++) {
			if (this.viewHelper.getModel().getListFornecedores().get(i)
					.getNumSequencial() != 0) {
				projeto.getListFornecedores()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel()
										.getListFornecedores().get(i)
										.getNumSequencial());
				projeto.getCopiaListFornecedores()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel()
										.getCopiaListFornecedores().get(i)
										.getNumSequencial());
			}
		}

		// Status de licenciamento socioambiental

		projeto.setDescComentariosStatusLicenciamento(xls
				.getStatusLicenciamentoSocioambiental());

		projeto.setCodGrupo(this.viewHelper.getModel().getCodGrupo());
		projeto.setNomeGrupo(this.viewHelper.getModel().getNomeGrupo());

		projeto.setCodRelatorio(this.viewHelper.getModel().getCodRelatorio());

		return projeto;
	}

	public DiskFileItem getFile() {
		return file;
	}

	public void setFile(DiskFileItem file) {
		this.file = file;
	}

	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

	public Date getDtIn() {
		return dtIn;
	}

	public void setDtIn(Date dtIn) {
		this.dtIn = dtIn;
	}

	public Date getDtTerm() {
		return dtTerm;
	}

	public void setDtTerm(Date dtTerm) {
		this.dtTerm = dtTerm;
	}

	public List<UsosFontesVO> getListaTempUsosFontes() {
		return listaTempUsosFontes;
	}

	public void setListaTempUsosFontes(List<UsosFontesVO> listaTempUsosFontes) {
		this.listaTempUsosFontes = listaTempUsosFontes;
	}

	public List<ConstrutoresFornecedoresVO> getListaTempConstForn() {
		return listaTempConstForn;
	}

	public void setListaTempConstForn(
			List<ConstrutoresFornecedoresVO> listaTempConstForn) {
		this.listaTempConstForn = listaTempConstForn;
	}

}