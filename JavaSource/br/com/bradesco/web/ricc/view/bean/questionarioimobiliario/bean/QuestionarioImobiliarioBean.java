package br.com.bradesco.web.ricc.view.bean.questionarioimobiliario.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UITab.UITab;
import br.com.bradesco.web.aq.view.components.html.uiinputtextarea.UIInputTextAreaBradesco;
import br.com.bradesco.web.ricc.enums.ComentarioEnum;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AbaQuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AreaAtuacaoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.HistoricoLancamentosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.LandBankVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasAndamentoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasConcluidasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.xls.SetorImobiliarioVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.service.business.questionarioimobiliario.IQuestionarioImobiliarioService;
import br.com.bradesco.web.ricc.utils.Numeros;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.RiccMessages;
import br.com.bradesco.web.ricc.utils.SiteUtil;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.questionarioimobiliario.viewhelper.QuestionarioImobiliarioViewHelper;
import br.com.bradesco.web.ricc.xls.QuestionarioImobiliarioObrasAndamentoXLS;
import br.com.bradesco.web.ricc.xls.QuestionarioImobiliarioXLS;

@SessionScoped
@Named(value = "questionarioImobiliarioBean")
public class QuestionarioImobiliarioBean extends
		AbstractBean<QuestionarioImobiliarioViewHelper> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3938520854935490675L;

	private String paginaAnterior = "";

	@Inject
	@Named("questionarioImobiliarioService")
	private IQuestionarioImobiliarioService questionarioImobiliarioService = null;

	public IQuestionarioImobiliarioService getQuestionarioImobiliarioService() {
		return questionarioImobiliarioService;
	}

	public void setQuestionarioImobiliarioService(
			IQuestionarioImobiliarioService questionarioImobiliarioService) {
		this.questionarioImobiliarioService = questionarioImobiliarioService;
	}

	private ArrayList<String> mensagens = new ArrayList<String>();

	private UITab tabQuestionario = null;

	private UITab tabObrasAndamento = null;

	private UITab tabObrasConcluidas = null;

	private String abaSelecionada = "";

	private DiskFileItem file;
	private File tempFile;

	@Override
	public String iniciarPagina() {
		setViewHelper(new QuestionarioImobiliarioViewHelper());
		viewHelper.inicializar();

		tabQuestionario = new UITab();
		tabObrasAndamento = new UITab();
		tabObrasConcluidas = new UITab();

		tabQuestionario.setSelected(true);

		try {
		} catch (Exception e) {
			SiteUtil.getInstance().trataExceptionRecebida(e);
		}

		return RiccConstants.TELA_QUESTIONARIO_IMOBILIARIO;
	}

	public String voltar() {
		return paginaAnterior;
	}

	public void carregarDados() {

		consultaDetalheSetorImobiliario();
		listarAreaAtuacao();
		listarHistoricoLancamentos();
		listarLandBank();
		listarObrasAndamento();
		listarObrasConcluidas();

		consultaComentarios();
	}

	private void consultaDetalheSetorImobiliario() {

		QuestionarioImobiliarioVO model = viewHelper
				.getQuestionarioImobiliarioVO();

		try {
			model.setQuestionario(questionarioImobiliarioService
					.consultaDetalheSetorImobiliario(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
	}

	public void listarAreaAtuacao() {

		AbaQuestionarioImobiliarioVO questionario = viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario();

		questionario.setListaAreaAtuacao(new ArrayList<AreaAtuacaoVO>());
		questionario.setAreaAtuacaoSelecionado(new ArrayList<AreaAtuacaoVO>());

		try {
			questionario.setListaAreaAtuacao(questionarioImobiliarioService
					.consultaAreaAtuacao(viewHelper
							.getQuestionarioImobiliarioVO()));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (questionario.getListaAreaAtuacao().size() < Numeros.CINCO) {
			questionario.getListaAreaAtuacao().add(new AreaAtuacaoVO());
		}
		try {
			copiarAreaAtuacao();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void copiarAreaAtuacao() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<AreaAtuacaoVO> listaCopia = new ArrayList<AreaAtuacaoVO>();
		AreaAtuacaoVO voCopia = null;
		for (AreaAtuacaoVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario()
				.getListaAreaAtuacao()) {
			voCopia = new AreaAtuacaoVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if (siteUtil.isEmptyOrNull(voCopia.getEstado())) {
				voCopia.setEstado("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getRegiao())) {
				voCopia.setRegiao("");
			}

			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioImobiliarioVO().getQuestionario()
				.setCopiaListaAreaAtuacao(listaCopia);
	}

	public void areaAtuacao() {

		int contador = 0;
		for (AreaAtuacaoVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario()
				.getListaAreaAtuacao()) {
			if (!itemTabela
					.equals(viewHelper.getQuestionarioImobiliarioVO()
							.getQuestionario().getCopiaListaAreaAtuacao()
							.get(contador))) {
				// INCLUSÃO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getEstado())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getRegiao())) {
					try {
						questionarioImobiliarioService.manutencaoAreaAtuacao(
								viewHelper.getQuestionarioImobiliarioVO(),
								TipoManutencaoEnum.INCLUSAO.getCodigoString(),
								itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getEstado())
						&& siteUtil.isEmptyOrNull(itemTabela.getRegiao())) {
					try {
						questionarioImobiliarioService.manutencaoAreaAtuacao(
								viewHelper.getQuestionarioImobiliarioVO(),
								TipoManutencaoEnum.EXCLUSAO.getCodigoString(),
								itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getQuestionarioImobiliarioVO().getQuestionario()
						.getCopiaListaAreaAtuacao().get(contador)
						.getNumSequencial()) {
					try {
						questionarioImobiliarioService.manutencaoAreaAtuacao(
								viewHelper.getQuestionarioImobiliarioVO(),
								TipoManutencaoEnum.INCLUSAO.getCodigoString(),
								itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarAreaAtuacao();
	}

	public void listarHistoricoLancamentos() {

		AbaQuestionarioImobiliarioVO questionario = viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario();
		questionario
				.setListaHistoricoLancamentos(new ArrayList<HistoricoLancamentosVO>());
		questionario
				.setHistoricoLancamentosSelecionado(new ArrayList<HistoricoLancamentosVO>());
		StringBuilder vgvTotal = new StringBuilder();
		StringBuilder qtdTotal = new StringBuilder();

		try {
			questionario
					.setListaHistoricoLancamentos(questionarioImobiliarioService
							.consultaHistoricoLancamentos(
									viewHelper.getQuestionarioImobiliarioVO(),
									vgvTotal, qtdTotal));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		questionario.setVgvTotal(vgvTotal.toString());
		questionario.setQtdTotal(qtdTotal.toString());

		while (questionario.getListaHistoricoLancamentos().size() < Numeros.CINCO) {
			questionario.getListaHistoricoLancamentos().add(
					new HistoricoLancamentosVO());
		}
		try {
			copiarHistoricoLancamentos();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void copiarHistoricoLancamentos() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<HistoricoLancamentosVO> listaCopia = new ArrayList<HistoricoLancamentosVO>();
		HistoricoLancamentosVO voCopia = null;
		for (HistoricoLancamentosVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario()
				.getListaHistoricoLancamentos()) {
			voCopia = new HistoricoLancamentosVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if (siteUtil.isEmptyOrNull(voCopia.getAno())) {
				voCopia.setAno("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getVgvLancado())) {
				voCopia.setVgvLancado("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getQtdeEmpreendimentos())) {
				voCopia.setQtdeEmpreendimentos("");
			}

			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioImobiliarioVO().getQuestionario()
				.setCopiaListaHistoricoLancamentos(listaCopia);
	}

	public void historicoLancamentos() {

		int contador = 0;
		for (HistoricoLancamentosVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario()
				.getListaHistoricoLancamentos()) {
			if (!itemTabela.equals(viewHelper.getQuestionarioImobiliarioVO()
					.getQuestionario().getCopiaListaHistoricoLancamentos()
					.get(contador))) {
				// INCLUSÃO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getAno())
						&& siteUtil
								.isNotEmptyOrNull(itemTabela.getVgvLancado())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getQtdeEmpreendimentos())) {
					try {
						questionarioImobiliarioService
								.manutencaoHistoricoLancamentos(
										viewHelper
												.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.INCLUSAO
												.getCodigoString(),
										itemTabela,
										viewHelper
												.getQuestionarioImobiliarioVO()
												.getQuestionario()
												.getCopiaListaHistoricoLancamentos()
												.get(contador).getAno());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getAno())
						&& siteUtil.isEmptyOrNull(itemTabela.getVgvLancado())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getQtdeEmpreendimentos())) {
					try {
						questionarioImobiliarioService
								.manutencaoHistoricoLancamentos(
										viewHelper
												.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.EXCLUSAO
												.getCodigoString(),
										itemTabela,
										viewHelper
												.getQuestionarioImobiliarioVO()
												.getQuestionario()
												.getCopiaListaHistoricoLancamentos()
												.get(contador).getAno());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getQuestionarioImobiliarioVO().getQuestionario()
						.getCopiaListaHistoricoLancamentos().get(contador)
						.getNumSequencial()) {
					try {
						questionarioImobiliarioService
								.manutencaoHistoricoLancamentos(
										viewHelper
												.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.INCLUSAO
												.getCodigoString(),
										itemTabela,
										viewHelper
												.getQuestionarioImobiliarioVO()
												.getQuestionario()
												.getCopiaListaHistoricoLancamentos()
												.get(contador).getAno());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarHistoricoLancamentos();
	}

	public void listarPrevisaoLancamento() {

	}

	public boolean validarCamposAreaAtuacao() {
		AreaAtuacaoVO dados = viewHelper.getQuestionarioImobiliarioVO()
				.getQuestionario().getAreaAtuacao();

		if (siteUtil.isEmptyOrNull(dados.getEstado())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_estado");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getRegiao())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_regiao");
			return false;
		}
		return true;

	}

	public void incluirAreaAtuacao() throws IllegalAccessException,
			InvocationTargetException {
		if (validarCamposAreaAtuacao()) {
			QuestionarioImobiliarioVO model = viewHelper
					.getQuestionarioImobiliarioVO();
			model.getQuestionario().getAreaAtuacao()
					.setNumSequencial(Numeros.ZERO);
			try {
				questionarioImobiliarioService.manutencaoAreaAtuacao(model,
						TipoManutencaoEnum.INCLUSAO.getCodigoString(), model
								.getQuestionario().getAreaAtuacao());
				model.getQuestionario().setAreaAtuacao(new AreaAtuacaoVO());
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}
			viewHelper.setDesabilitaIncluirAreaAtuacao(Boolean.TRUE);
			listarAreaAtuacao();
		}
	}

	public void excluirAreaAtuacao() {
		List<AreaAtuacaoVO> listaSelecao = viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario()
				.getAreaAtuacaoSelecionado();
		if (siteUtil.selecaoNaoVazia(listaSelecao, "label_area_atuacao")) {
			AreaAtuacaoVO itemSelecionado = listaSelecao.get(0);

			try {
				questionarioImobiliarioService.manutencaoAreaAtuacao(
						viewHelper.getQuestionarioImobiliarioVO(),
						TipoManutencaoEnum.EXCLUSAO.getCodigoString(),
						itemSelecionado);
				listaSelecao.clear();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}
			listarAreaAtuacao();
		}
	}

	public boolean validarCamposHistoricoLancamentos() {
		HistoricoLancamentosVO dados = viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario()
				.getHistoricoLancamentos();
		if (siteUtil.isEmptyOrNull(dados.getAno())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_ano");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getVgvLancado())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_vgv_lancado");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getQtdeEmpreendimentos())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_qtde_empreendimentos");
			return false;
		}
		return true;
	}

	public boolean validarCamposLandBank() {
		LandBankVO campos = viewHelper.getQuestionarioImobiliarioVO()
				.getQuestionario().getLandBank();
		if (siteUtil.isEmptyOrNull(campos.getEmpreendimento())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_empreendimento");
			return false;
		}
		if (siteUtil.isEmptyOrNull(campos.getLocalizacao())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_localizacao");
			return false;
		}
		if (siteUtil.isEmptyOrNull(campos.getValorTerreno())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_valor_terreno");
			return false;
		}
		if (siteUtil.isEmptyOrNull(campos.getVgvEstimado())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_vgv_estimado");
			return false;
		}
		if (siteUtil.isEmptyOrNull(campos.getDataPrevista())) {
			RiccMessages.getInstance()
					.getMsgDataInvalida("label_data_prevista");
			return false;
		}
		if (siteUtil.isEmptyOrNull(campos.getPossuiOnus())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_possui_onus");
			return false;
		}
		return true;
	}

	public void listarLandBank() {
		AbaQuestionarioImobiliarioVO questionario = viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario();
		questionario.setListaLandBank(new ArrayList<LandBankVO>());
		questionario.setLandBankSelecionado(new ArrayList<LandBankVO>());
		StringBuilder totalTerreno = new StringBuilder();
		StringBuilder totalProjetada = new StringBuilder();
		try {
			questionario.setListaLandBank(questionarioImobiliarioService
					.consultaLandBank(
							viewHelper.getQuestionarioImobiliarioVO(),
							totalTerreno, totalProjetada));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		questionario.setTotalTerreno(totalTerreno.toString());
		questionario.setTotalProjetada(totalProjetada.toString());

		while (questionario.getListaLandBank().size() < 40) {
			questionario.getListaLandBank().add(new LandBankVO());
		}
		try {
			copiarLandBank();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void copiarLandBank() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<LandBankVO> listaCopia = new ArrayList<LandBankVO>();
		LandBankVO voCopia = null;
		for (LandBankVO itemTabela : viewHelper.getQuestionarioImobiliarioVO()
				.getQuestionario().getListaLandBank()) {
			voCopia = new LandBankVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if (siteUtil.isEmptyOrNull(voCopia.getEmpreendimento())) {
				voCopia.setEmpreendimento("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getLocalizacao())) {
				voCopia.setLocalizacao("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValorTerreno())) {
				voCopia.setValorTerreno("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getVgvEstimado())) {
				voCopia.setVgvEstimado("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDataPrevista())) {
				voCopia.setDataPrevista("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPossuiOnus())) {
				voCopia.setPossuiOnus("");
			}

			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioImobiliarioVO().getQuestionario()
				.setCopiaListaLandBank(listaCopia);
	}

	public void landBank() {

		int contador = 0;
		for (LandBankVO itemTabela : viewHelper.getQuestionarioImobiliarioVO()
				.getQuestionario().getListaLandBank()) {
			if (!itemTabela.equals(viewHelper.getQuestionarioImobiliarioVO()
					.getQuestionario().getCopiaListaLandBank().get(contador))) {
				// INCLUSÃO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getEmpreendimento())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getLocalizacao())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValorTerreno())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getVgvEstimado())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getDataPrevista())
						&& siteUtil
								.isNotEmptyOrNull(itemTabela.getPossuiOnus())) {
					try {
						questionarioImobiliarioService.manutencaoLandBank(
								viewHelper.getQuestionarioImobiliarioVO(),
								TipoManutencaoEnum.INCLUSAO.getCodigoString(),
								itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela
								.getEmpreendimento())
						&& siteUtil.isEmptyOrNull(itemTabela.getLocalizacao())
						&& siteUtil.isEmptyOrNull(itemTabela.getValorTerreno())
						&& siteUtil.isEmptyOrNull(itemTabela.getVgvEstimado())
						&& siteUtil.isEmptyOrNull(itemTabela.getDataPrevista())
						&& siteUtil.isEmptyOrNull(itemTabela.getPossuiOnus())) {
					try {
						questionarioImobiliarioService.manutencaoLandBank(
								viewHelper.getQuestionarioImobiliarioVO(),
								TipoManutencaoEnum.EXCLUSAO.getCodigoString(),
								itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getQuestionarioImobiliarioVO().getQuestionario()
						.getCopiaListaLandBank().get(contador)
						.getNumSequencial()) {
					try {
						questionarioImobiliarioService.manutencaoLandBank(
								viewHelper.getQuestionarioImobiliarioVO(),
								TipoManutencaoEnum.INCLUSAO.getCodigoString(),
								itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarLandBank();
	}

	public void incluirLandBank() throws IllegalAccessException,
			InvocationTargetException {
		if (validarCamposLandBank()) {
			LandBankVO dados = viewHelper.getQuestionarioImobiliarioVO()
					.getQuestionario().getLandBank();
			dados.setNumSequencial(Numeros.ZERO);

			try {
				questionarioImobiliarioService.manutencaoLandBank(
						viewHelper.getQuestionarioImobiliarioVO(),
						TipoManutencaoEnum.INCLUSAO.getCodigoString(), dados);
				viewHelper.getQuestionarioImobiliarioVO().getQuestionario()
						.setLandBank(new LandBankVO());
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}
			listarLandBank();
		}
	}

	public void excluirLandBank() {
		List<LandBankVO> listaSelecao = viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario()
				.getLandBankSelecionado();
		if (siteUtil.selecaoNaoVazia(listaSelecao, "label_land_bank")) {
			try {
				LandBankVO itemSelecionado = listaSelecao.get(0);
				questionarioImobiliarioService.manutencaoLandBank(
						viewHelper.getQuestionarioImobiliarioVO(),
						TipoManutencaoEnum.EXCLUSAO.getCodigoString(),
						itemSelecionado);
				listaSelecao.clear();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}
			AbaQuestionarioImobiliarioVO questionario = viewHelper
					.getQuestionarioImobiliarioVO().getQuestionario();
			questionario.setTotalTerreno("");
			questionario.setTotalProjetada("");
			listarLandBank();
		}
	}

	public void incluirObraAndamento() throws IllegalAccessException,
			InvocationTargetException {
		if (validarCamposObraAndamento()) {
			ObrasAndamentoVO dados = viewHelper.getQuestionarioImobiliarioVO()
					.getObrasAndamento();
			dados.setNumSequencial("0");
			String comentario = viewHelper.getQuestionarioImobiliarioVO()
					.getObrasAndamento().getDescObrasAndamento();

			try {
				questionarioImobiliarioService.manutencaoObrasAndamento(
						viewHelper.getQuestionarioImobiliarioVO(),
						TipoManutencaoEnum.INCLUSAO.getCodigoString(), dados);
				viewHelper.getQuestionarioImobiliarioVO().setObrasAndamento(
						new ObrasAndamentoVO());
				viewHelper.getQuestionarioImobiliarioVO().getObrasAndamento()
						.setDescObrasAndamento(comentario);
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}
			listarObrasAndamento();
		}
	}

	public boolean validarCamposObraAndamento() {
		ObrasAndamentoVO dados = getViewHelper().getQuestionarioImobiliarioVO()
				.getObrasAndamento();
		if (siteUtil.isEmptyOrNull(dados.getIncorporadora())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_incorporadora");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getNomeEmpreendimento())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_nome_empreendimento");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getUf())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_uf");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getCidade())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_cidade");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getBairro())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_bairro");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getPorcPartEmpreendimento())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_part_empreendimento");
			return false;
		}
		if (siteUtil.valueToMainframeBigDecimal(
				dados.getPorcPartEmpreendimento()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage(
					"Valor percentual '% Part. no Empr.' maior que 100,00%!",
					Boolean.FALSE);
			return false;
		}

		if (siteUtil.isEmptyOrNull(dados.getDataLancamento())) {
			BradescoFacesUtils.addInfoModalMessage("Data Lançamento Inválida!",
					false);
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getPrevisaoEntrega())) {
			BradescoFacesUtils.addInfoModalMessage(
					"Data Previsão de Entrega Inválida!", false);
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getPorcentagemObra())) {
			RiccMessages.getInstance()
					.getMsgCampoObrigatorio("label_porc_obra");
			return false;
		}
		if (siteUtil.valueToMainframeBigDecimal(dados.getPorcentagemObra())
				.doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage(
					"Valor percentual '% de Obra' maior que 100,00%!",
					Boolean.FALSE);
			return false;
		}

		if (siteUtil.isEmptyOrNull(dados.getTotalObra())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_total_obra");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getaIncorrer())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_a_incorrer");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getVgvTotal())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_total");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getVgvSemPermutas())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_sem_permutas");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getTotalUnidadesEstoque())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_total_unidades");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getTotalUnidadesSemPermutas())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_sem_permutas");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getTotalUnidadesComPermutas())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_com_permutas");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getPorcentagemVendas())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_porcentagem_vendas");
			return false;
		}
		if (siteUtil.valueToMainframeBigDecimal(dados.getPorcentagemVendas())
				.doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage(
					"Valor percentual '% Vendas' maior que 100,00%!",
					Boolean.FALSE);
			return false;
		}

		if (siteUtil.isEmptyOrNull(dados.getPorcentagemDistratos())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_porc_distratos");
			return false;
		}
		if (siteUtil
				.valueToMainframeBigDecimal(dados.getPorcentagemDistratos())
				.doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage(
					"Valor percentual '% Distratos' maior que 100,00%!",
					Boolean.FALSE);
			return false;
		}

		if (siteUtil.isEmptyOrNull(dados.getValoresRecebidos())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_val_ja_recebidos");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getValoresAteChaves())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_a_receber_ate_chaves");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getValoresPosChaves())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_recebiveis_pos_chaves");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getAgenteFinanceiro())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_agente_financeiro");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getValorContrato())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_valor_contrato");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getSaldoALiberar())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_saldo_liberar");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getSaldoDevedor())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_saldo_devedor");
			return false;
		}
		return true;
	}

	public void listarObrasAndamento() {

		QuestionarioImobiliarioVO questionario = viewHelper
				.getQuestionarioImobiliarioVO();

		questionario.setListaObrasAndamento(new ArrayList<ObrasAndamentoVO>());
		questionario
				.setObrasAndamentoSelecionado(new ArrayList<ObrasAndamentoVO>());

		StringBuilder sb = new StringBuilder();

		try {
			QuestionarioImobiliarioVO retorno = questionarioImobiliarioService
					.consultaObrasAndamento(
							viewHelper.getQuestionarioImobiliarioVO(), sb);

			questionario.setListaObrasAndamento(retorno
					.getListaObrasAndamento());

			questionario.setTotalCustoObra(retorno.getTotalCustoObra());
			questionario.setTotalCustoIncorrer(retorno.getTotalCustoIncorrer());
			questionario.setTotalVenda(retorno.getTotalVenda());
			questionario.setTotalVendaPermuta(retorno.getTotalVendaPermuta());
			questionario.setTotalQuantidadeEstoque(retorno
					.getTotalQuantidadeEstoque());
			questionario.setTotalUnidadeSemPermuta(retorno
					.getTotalUnidadeSemPermuta());
			questionario.setTotalUnidadePermuta(retorno
					.getTotalUnidadePermuta());
			questionario.setTotalValorRecibo(retorno.getTotalValorRecibo());
			questionario.setTotalValorReciboPreChave(retorno
					.getTotalValorReciboPreChave());
			questionario.setTotalValorReciboPosChave(retorno
					.getTotalValorReciboPosChave());
			questionario.setTotalValorContrato(retorno.getTotalValorContrato());
			questionario.setTotalSaldoLiberar(retorno.getTotalSaldoLiberar());
			questionario.setTotalSaldoDevedorAndamento(retorno
					.getTotalSaldoDevedorAndamento());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (questionario.getListaObrasAndamento().size() < 40) {
			questionario.getListaObrasAndamento().add(new ObrasAndamentoVO());
		}
		try {
			copiarObrasAndamento();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}

	}

	private void copiarObrasAndamento() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<ObrasAndamentoVO> listaCopia = new ArrayList<ObrasAndamentoVO>();
		ObrasAndamentoVO voCopia = null;
		for (ObrasAndamentoVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getListaObrasAndamento()) {
			voCopia = new ObrasAndamentoVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if (siteUtil.isEmptyOrNull(voCopia.getIncorporadora())) {
				voCopia.setIncorporadora("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getNomeEmpreendimento())) {
				voCopia.setNomeEmpreendimento("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getBairro())) {
				voCopia.setBairro("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getCidade())) {
				voCopia.setCidade("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getUf())) {
				voCopia.setUf("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPorcPartEmpreendimento())) {
				voCopia.setPorcPartEmpreendimento("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDataLancamento())) {
				voCopia.setDataLancamento("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPrevisaoEntrega())) {
				voCopia.setPrevisaoEntrega("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPorcentagemObra())) {
				voCopia.setPorcentagemObra("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getTotalObra())) {
				voCopia.setTotalObra("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getaIncorrer())) {
				voCopia.setaIncorrer("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getVgvTotal())) {
				voCopia.setVgvTotal("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getVgvSemPermutas())) {
				voCopia.setVgvSemPermutas("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getTotalUnidadesEstoque())) {
				voCopia.setTotalUnidadesEstoque("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getTotalUnidadesSemPermutas())) {
				voCopia.setTotalUnidadesSemPermutas("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getTotalUnidadesComPermutas())) {
				voCopia.setTotalUnidadesComPermutas("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPorcentagemVendas())) {
				voCopia.setPorcentagemVendas("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPorcentagemDistratos())) {
				voCopia.setPorcentagemDistratos("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValoresRecebidos())) {
				voCopia.setValoresRecebidos("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValoresAteChaves())) {
				voCopia.setValoresAteChaves("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValoresPosChaves())) {
				voCopia.setValoresPosChaves("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getAgenteFinanceiro())) {
				voCopia.setAgenteFinanceiro("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValorContrato())) {
				voCopia.setValorContrato("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getSaldoALiberar())) {
				voCopia.setSaldoALiberar("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getSaldoDevedor())) {
				voCopia.setSaldoDevedor("");
			}

			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioImobiliarioVO().setCopiaListaObrasAndamento(
				listaCopia);
	}

	public void obrasAndamento() {

		int contador = 0;
		for (ObrasAndamentoVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getListaObrasAndamento()) {
			if (!itemTabela.equals(viewHelper.getQuestionarioImobiliarioVO()
					.getCopiaListaObrasAndamento().get(contador))) {
				// INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getIncorporadora())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getNomeEmpreendimento())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getBairro())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getCidade())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getUf())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPorcPartEmpreendimento())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getDataLancamento())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPrevisaoEntrega())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPorcentagemObra())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getTotalObra())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getaIncorrer())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getVgvTotal())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getVgvSemPermutas())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getTotalUnidadesEstoque())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getTotalUnidadesSemPermutas())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getTotalUnidadesComPermutas())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPorcentagemVendas())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPorcentagemDistratos())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValoresRecebidos())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValoresAteChaves())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValoresPosChaves())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getAgenteFinanceiro())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValorContrato())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getSaldoALiberar())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getSaldoDevedor())) {
					try {
						questionarioImobiliarioService
								.manutencaoObrasAndamento(viewHelper
										.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.INCLUSAO
												.getCodigoString(), itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil
								.isEmptyOrNull(itemTabela.getIncorporadora())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getNomeEmpreendimento())
						&& siteUtil.isEmptyOrNull(itemTabela.getBairro())
						&& siteUtil.isEmptyOrNull(itemTabela.getCidade())
						&& siteUtil.isEmptyOrNull(itemTabela.getUf())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPorcPartEmpreendimento())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getDataLancamento())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPrevisaoEntrega())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPorcentagemObra())
						&& siteUtil.isEmptyOrNull(itemTabela.getTotalObra())
						&& siteUtil.isEmptyOrNull(itemTabela.getaIncorrer())
						&& siteUtil.isEmptyOrNull(itemTabela.getVgvTotal())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getVgvSemPermutas())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getTotalUnidadesEstoque())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getTotalUnidadesSemPermutas())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getTotalUnidadesComPermutas())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPorcentagemVendas())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPorcentagemDistratos())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getValoresRecebidos())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getValoresAteChaves())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getValoresPosChaves())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getAgenteFinanceiro())
						&& siteUtil
								.isEmptyOrNull(itemTabela.getValorContrato())
						&& siteUtil
								.isEmptyOrNull(itemTabela.getSaldoALiberar())
						&& siteUtil.isEmptyOrNull(itemTabela.getSaldoDevedor())) {
					try {
						questionarioImobiliarioService
								.manutencaoObrasAndamento(viewHelper
										.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.EXCLUSAO
												.getCodigoString(), itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getQuestionarioImobiliarioVO()
						.getListaObrasAndamento().get(contador)
						.getNumSequencial()) {
					try {
						questionarioImobiliarioService
								.manutencaoObrasAndamento(viewHelper
										.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.INCLUSAO
												.getCodigoString(), itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarObrasAndamento();
	}

	public void excluirObraAndamento() {
		viewHelper.getQuestionarioImobiliarioVO().getObrasAndamento();
		List<ObrasAndamentoVO> listaSelecao = viewHelper
				.getQuestionarioImobiliarioVO().getObrasAndamentoSelecionado();
		if (siteUtil.selecaoNaoVazia(listaSelecao, "label_obras_andamento")) {
			ObrasAndamentoVO itemSelecionado = listaSelecao.get(0);

			try {
				questionarioImobiliarioService.manutencaoObrasAndamento(
						viewHelper.getQuestionarioImobiliarioVO(),
						TipoManutencaoEnum.EXCLUSAO.getCodigoString(),
						itemSelecionado);
				listaSelecao.clear();
				// RiccMessages.getInstance().getMsgExclusaoSucesso();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}
			listarObrasAndamento();
		}
	}

	public void listarObrasConcluidas() {

		QuestionarioImobiliarioVO questionario = viewHelper
				.getQuestionarioImobiliarioVO();

		questionario
				.setListaObrasConcluidas(new ArrayList<ObrasConcluidasVO>());
		questionario
				.setObrasConcluidasSelecionado(new ArrayList<ObrasConcluidasVO>());

		StringBuilder sb = new StringBuilder();

		try {
			QuestionarioImobiliarioVO retorno = questionarioImobiliarioService
					.consultaObrasConcluidas(
							viewHelper.getQuestionarioImobiliarioVO(), sb);

			questionario.setListaObrasConcluidas(retorno
					.getListaObrasConcluidas());

			questionario.setTotalRecebidos(retorno.getTotalRecebidos());
			questionario.setTotal12Meses(retorno.getTotal12Meses());
			questionario.setTotal12A36(retorno.getTotal12A36());
			questionario.setTotalApos36(retorno.getTotalApos36());
			questionario.setTotalUnidades(retorno.getTotalUnidades());
			questionario.setTotalValorEstoque(retorno.getTotalValorEstoque());
			questionario.setTotalSaldoDevedor(retorno.getTotalSaldoDevedor());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (questionario.getListaObrasConcluidas().size() < 40) {
			questionario.getListaObrasConcluidas().add(new ObrasConcluidasVO());
		}
		try {
			copiarObrasConcluidas();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}

	}

	private void copiarObrasConcluidas() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<ObrasConcluidasVO> listaCopia = new ArrayList<ObrasConcluidasVO>();
		ObrasConcluidasVO voCopia = null;
		for (ObrasConcluidasVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getListaObrasConcluidas()) {
			voCopia = new ObrasConcluidasVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if (siteUtil.isEmptyOrNull(voCopia.getIncorporadora())) {
				voCopia.setIncorporadora("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getNomeEmpreendimento())) {
				voCopia.setNomeEmpreendimento("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getUf())) {
				voCopia.setUf("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getCidade())) {
				voCopia.setCidade("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getBairro())) {
				voCopia.setBairro("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getDataEntrega())) {
				voCopia.setDataEntrega("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValoresRecebidos())) {
				voCopia.setValoresRecebidos("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValoresAte12Meses())) {
				voCopia.setValoresAte12Meses("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValoresDe12Ate36Meses())) {
				voCopia.setValoresDe12Ate36Meses("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValoresApos36Meses())) {
				voCopia.setValoresApos36Meses("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getQtdeUnidades())) {
				voCopia.setQtdeUnidades("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValorEstoque())) {
				voCopia.setValorEstoque("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getPorcentagemVendas())) {
				voCopia.setPorcentagemVendas("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getAgenteFinanceiro())) {
				voCopia.setAgenteFinanceiro("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getSaldoDevedor())) {
				voCopia.setSaldoDevedor("");
			}

			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioImobiliarioVO().setCopiaListaObrasConcluidas(
				listaCopia);
	}

	public void obrasConcluidas() {

		int contador = 0;
		for (ObrasConcluidasVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getListaObrasConcluidas()) {
			if (!itemTabela.equals(viewHelper.getQuestionarioImobiliarioVO()
					.getCopiaListaObrasConcluidas().get(contador))) {
				// INCLUSÃO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getIncorporadora())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getNomeEmpreendimento())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getUf())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getCidade())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getBairro())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getDataEntrega())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValoresRecebidos())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValoresAte12Meses())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValoresDe12Ate36Meses())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValoresApos36Meses())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getQtdeUnidades())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValorEstoque())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getPorcentagemVendas())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getAgenteFinanceiro())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getSaldoDevedor())) {
					try {
						questionarioImobiliarioService
								.manutencaoObrasConcluidas(viewHelper
										.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.INCLUSAO
												.getCodigoString(), itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil
								.isEmptyOrNull(itemTabela.getIncorporadora())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getNomeEmpreendimento())
						&& siteUtil.isEmptyOrNull(itemTabela.getUf())
						&& siteUtil.isEmptyOrNull(itemTabela.getCidade())
						&& siteUtil.isEmptyOrNull(itemTabela.getBairro())
						&& siteUtil.isEmptyOrNull(itemTabela.getDataEntrega())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getValoresRecebidos())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getValoresAte12Meses())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getValoresDe12Ate36Meses())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getValoresApos36Meses())
						&& siteUtil.isEmptyOrNull(itemTabela.getQtdeUnidades())
						&& siteUtil.isEmptyOrNull(itemTabela.getValorEstoque())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getPorcentagemVendas())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getAgenteFinanceiro())
						&& siteUtil.isEmptyOrNull(itemTabela.getSaldoDevedor())) {
					try {
						questionarioImobiliarioService
								.manutencaoObrasConcluidas(viewHelper
										.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.EXCLUSAO
												.getCodigoString(), itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getQuestionarioImobiliarioVO()
						.getListaObrasConcluidas().get(contador)
						.getNumSequencial()) {
					try {
						questionarioImobiliarioService
								.manutencaoObrasConcluidas(viewHelper
										.getQuestionarioImobiliarioVO(),
										TipoManutencaoEnum.INCLUSAO
												.getCodigoString(), itemTabela);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarObrasConcluidas();
	}

	public void incluirObraConcluida() throws IllegalAccessException,
			InvocationTargetException {
		if (validarCamposObraConcluida()) {
			QuestionarioImobiliarioVO model = viewHelper
					.getQuestionarioImobiliarioVO();
			String comentario = model.getObrasConcluidas()
					.getDescObrasConcluidas();
			model.getObrasConcluidas().setNumSequencial(0);
			try {
				questionarioImobiliarioService.manutencaoObrasConcluidas(model,
						TipoManutencaoEnum.INCLUSAO.getCodigoString(),
						model.getObrasConcluidas());
				model.setObrasConcluidas(new ObrasConcluidasVO());
				model.getObrasConcluidas().setDescObrasConcluidas(comentario);
				// RiccMessages.getInstance().getMsgInclusaoSucesso();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}
			viewHelper.setDesabilitaIncluirObraConcluida(Boolean.TRUE);
			listarObrasConcluidas();
		}
	}

	public boolean validarCamposObraConcluida() {
		ObrasConcluidasVO dados = viewHelper.getQuestionarioImobiliarioVO()
				.getObrasConcluidas();

		if (siteUtil.isEmptyOrNull(dados.getIncorporadora())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_incorporadora");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getNomeEmpreendimento())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_nome_empreendimento");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getUf())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_uf");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getCidade())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_cidade");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getBairro())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_bairro");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getDataEntrega())) {
			RiccMessages.getInstance().getMsgDataInvalida("label_data_entrega");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getValoresRecebidos())) {
			RiccMessages.getInstance()
					.getMsgCampoObrigatorio("label_recebidos");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getValoresAte12Meses())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_ate12meses");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getValoresDe12Ate36Meses())) {
			RiccMessages.getInstance()
					.getMsgCampoObrigatorio("label_1236meses");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getValoresApos36Meses())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_apos36meses");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getQtdeUnidades())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_qtde_unidades");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getValorEstoque())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_valor_estoque");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getPorcentagemVendas())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_porcentagem_vendas");
			return false;
		}
		if (siteUtil.valueToMainframeBigDecimal(dados.getPorcentagemVendas())
				.doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage(
					"Valor percentual '% Vendas' maior que 100,00%!",
					Boolean.FALSE);
			return false;
		}

		if (siteUtil.isEmptyOrNull(dados.getAgenteFinanceiro())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_agente_financeiro");
			return false;
		}
		if (siteUtil.isEmptyOrNull(dados.getSaldoDevedor())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_saldo_devedor");
			return false;
		}

		return true;
	}

	public void excluirObraConcluida() {
		List<ObrasConcluidasVO> listaSelecao = viewHelper
				.getQuestionarioImobiliarioVO().getObrasConcluidasSelecionado();
		if (siteUtil.selecaoNaoVazia(listaSelecao, "label_obras_concluidas")) {
			ObrasConcluidasVO itemSelecionado = listaSelecao.get(0);

			try {
				questionarioImobiliarioService.manutencaoObrasConcluidas(
						viewHelper.getQuestionarioImobiliarioVO(),
						TipoManutencaoEnum.EXCLUSAO.getCodigoString(),
						itemSelecionado);
				listaSelecao.clear();
				// RiccMessages.getInstance().getMsgExclusaoSucesso();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}
			listarObrasConcluidas();
		}
	}

	public void atualizaNomeTerceirizada(AjaxBehaviorEvent e) {
		if (!viewHelper.getQuestionarioImobiliarioVO().getQuestionario()
				.getTerceirizada()) {
			viewHelper.getQuestionarioImobiliarioVO().getQuestionario()
					.setNomeTerceirizada("");
		}
	}

	public void selecionarAba(String id) {

		if (id.equals("Questionario")) {
			getViewHelper().setRenderAbaQuestionario(Boolean.TRUE);
			getViewHelper().setRenderAbaObrasAndamento(Boolean.FALSE);
			getViewHelper().setRenderAbaObrasConcluidas(Boolean.FALSE);
		} else if (id.equals("ObrasAndamento")) {
			getViewHelper().setRenderAbaQuestionario(Boolean.FALSE);
			getViewHelper().setRenderAbaObrasAndamento(Boolean.TRUE);
			getViewHelper().setRenderAbaObrasConcluidas(Boolean.FALSE);
		} else if (id.equals("ObrasConcluidas")) {
			getViewHelper().setRenderAbaQuestionario(Boolean.FALSE);
			getViewHelper().setRenderAbaObrasAndamento(Boolean.FALSE);
			getViewHelper().setRenderAbaObrasConcluidas(Boolean.TRUE);
		}
	}

	public void historicoLancamentosTotal(AjaxBehaviorEvent e) {
		BigInteger somaVgv = new BigInteger("0");
		BigInteger somaQtdeEmpreendimentos = new BigInteger("0");

		for (HistoricoLancamentosVO itemTabela : viewHelper
				.getQuestionarioImobiliarioVO().getQuestionario()
				.getListaHistoricoLancamentos()) {
			if (siteUtil.isNotEmptyOrNull(itemTabela.getVgvLancado())) {
				somaVgv = somaVgv.add(new BigInteger(siteUtil
						.retirarMascaraNumericos(itemTabela.getVgvLancado())));
			}
			if (siteUtil.isNotEmptyOrNull(itemTabela.getQtdeEmpreendimentos())) {
				somaQtdeEmpreendimentos = somaQtdeEmpreendimentos
						.add(new BigInteger(siteUtil
								.retirarMascaraNumericos(itemTabela
										.getQtdeEmpreendimentos())));
			}
		}
		getViewHelper().getQuestionarioImobiliarioVO().getQuestionario()
				.setVgvTotal(somaVgv.toString());
		getViewHelper().getQuestionarioImobiliarioVO().getQuestionario()
				.setQtdTotal(somaQtdeEmpreendimentos.toString());
	}

	public void landBankTotal(AjaxBehaviorEvent e) {
		BigInteger somaValorTerreno = new BigInteger("0");
		BigInteger somaVgvEstimado = new BigInteger("0");

		for (LandBankVO itemTabela : viewHelper.getQuestionarioImobiliarioVO()
				.getQuestionario().getListaLandBank()) {
			if (siteUtil.isNotEmptyOrNull(itemTabela.getValorTerreno())) {
				somaValorTerreno = somaValorTerreno
						.add(new BigInteger(siteUtil
								.retirarMascaraNumericos(itemTabela
										.getValorTerreno())));
			}
			if (siteUtil.isNotEmptyOrNull(itemTabela.getVgvEstimado())) {
				somaVgvEstimado = somaVgvEstimado.add(new BigInteger(siteUtil
						.retirarMascaraNumericos(itemTabela.getVgvEstimado())));
			}
		}
		getViewHelper().getQuestionarioImobiliarioVO().getQuestionario()
				.setTotalTerreno(somaValorTerreno.toString());
		getViewHelper().getQuestionarioImobiliarioVO().getQuestionario()
				.setTotalProjetada(somaVgvEstimado.toString());
	}

	public void salvar() {
		try {

			tabQuestionario = new UITab();
			tabObrasAndamento = new UITab();
			tabObrasConcluidas = new UITab();

			switch (AbaEnum.getByDescricao(abaSelecionada)) {
			case QUESTIONARIO:
				tabQuestionario.setSelected(true);
				break;
			case OBRAS_ANDAMENTO:
				tabObrasAndamento.setSelected(true);
				break;
			case OBRAS_CONCLUIDAS:
				tabObrasConcluidas.setSelected(true);
				break;
			default:
				tabQuestionario.setSelected(true);
				break;
			}

			areaAtuacao();
			historicoLancamentos();
			landBank();
			obrasAndamento();
			obrasConcluidas();

			questionarioImobiliarioService.manutencaoComentarios(
					viewHelper.getQuestionarioImobiliarioVO(),
					retornaListComentariosObrasAndamento(), "");
			questionarioImobiliarioService.manutencaoComentarios(
					viewHelper.getQuestionarioImobiliarioVO(),
					retornaListComentariosObrasConcluidas(), "");
			consultaComentarios();

			QuestionarioImobiliarioVO model = viewHelper
					.getQuestionarioImobiliarioVO();
			AbaQuestionarioImobiliarioVO questionario = viewHelper
					.getQuestionarioImobiliarioVO().getQuestionario();

			// if (validarCampos()) {
			questionarioImobiliarioService.manutencaoDetalheSetorImobiliario(
					model, TipoManutencaoEnum.ALTERACAO.getCodigoString(),
					questionario);
			// }
			if (mensagens.size() == 0) {
				RiccMessages.getInstance().getMsgSalvarSucesso();
			}
			mensagens.clear();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaComentarios() {

		QuestionarioImobiliarioVO model = viewHelper
				.getQuestionarioImobiliarioVO();

		try {
			// OBRAS ANDAMENTO / CONCLUÍDAS - 14
			List<ComentarioVO> comentarioObras = questionarioImobiliarioService
					.consultaComentarios(model, ComentarioEnum.OBRAS);

			// SEQUENCIAL 1 - ANDAMENTO
			model.getObrasAndamento().setDescObrasAndamento(
					comentarioObras.get(0).getComentario());
			// SEQUENCIAL 2 - CONCLUÍDAS
			model.getObrasConcluidas().setDescObrasConcluidas(
					comentarioObras.get(1).getComentario());

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	public List<ComentarioVO> retornaListComentariosObrasAndamento() {
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.OBRAS_ANDAMENTO.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.OBRAS_ANDAMENTO
				.getNumSequencial());

		if (siteUtil.isNotNull(viewHelper.getQuestionarioImobiliarioVO()
				.getObrasAndamento().getDescObrasAndamento())) {
			comentario.setComentario(viewHelper.getQuestionarioImobiliarioVO()
					.getObrasAndamento().getDescObrasAndamento());
		} else {
			comentario.setComentario(RiccConstants.VAZIO);
		}

		comentarios.add(comentario);

		return comentarios;
	}

	public void atualizaComentarioObrasAndamento(AjaxBehaviorEvent e) {
		String value = (String) ((UIInputTextAreaBradesco) e.getSource())
				.getValue();
		viewHelper.getQuestionarioImobiliarioVO().getObrasAndamento()
				.setDescObrasAndamento(value);
	}

	public List<ComentarioVO> retornaListComentariosObrasConcluidas() {
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.OBRAS_CONCLUIDAS.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.OBRAS_CONCLUIDAS
				.getNumSequencial());

		if (siteUtil.isNotNull(viewHelper.getQuestionarioImobiliarioVO()
				.getObrasConcluidas().getDescObrasConcluidas())) {
			comentario.setComentario(viewHelper.getQuestionarioImobiliarioVO()
					.getObrasConcluidas().getDescObrasConcluidas());
		} else {
			comentario.setComentario(RiccConstants.VAZIO);
		}

		comentarios.add(comentario);

		return comentarios;
	}

	public void atualizaComentarioObrasConcluidas(AjaxBehaviorEvent e) {
		String value = (String) ((UIInputTextAreaBradesco) e.getSource())
				.getValue();
		viewHelper.getQuestionarioImobiliarioVO().getObrasConcluidas()
				.setDescObrasConcluidas(value);
	}

	public void upload() {

		tabQuestionario = new UITab();
		tabObrasAndamento = new UITab();
		tabObrasConcluidas = new UITab();

		switch (AbaEnum.getByDescricao(abaSelecionada)) {
		case QUESTIONARIO:
			tabQuestionario.setSelected(true);
			break;
		case OBRAS_ANDAMENTO:
			tabObrasAndamento.setSelected(true);
			break;
		case OBRAS_CONCLUIDAS:
			tabObrasConcluidas.setSelected(true);
			break;
		default:
			tabQuestionario.setSelected(true);
			break;
		}

		try {
			if (this.file == null) {
				BradescoFacesUtils
						.addErrorModalMessage("Selecione a planilha para Upload.");
			} else {
				if (this.file.getName().toUpperCase().contains(".XLSM")) {
					this.tempFile = File.createTempFile("imob", ".xlsm");
					this.tempFile.deleteOnExit();

					copyToFile(this.file.getInputStream(), this.tempFile);

					SetorImobiliarioVO setorQuestionario = new QuestionarioImobiliarioXLS()
							.lerSetorImobiliarioQuestionario(this.tempFile);

					if (setorQuestionario != null) {
						SetorImobiliarioVO setorObrasAndamento = new QuestionarioImobiliarioObrasAndamentoXLS()
								.lerSetorImobiliarioObrasEmAndamento(this.tempFile);
						SetorImobiliarioVO setorObrasConcluidas = new QuestionarioImobiliarioXLS()
								.lerSetorImobiliarioObrasConcluidas(this.tempFile);
						viewHelper.setQuestionarioImobiliarioVO(popularViaXls(
								setorQuestionario, setorObrasAndamento,
								setorObrasConcluidas));
						BradescoFacesUtils.addInfoModalMessage(
								"Processamento da planilha concluído.", false);
					} else {
						BradescoFacesUtils
								.addErrorModalMessage("Selecione a planilha de setor correspondente.");
					}
				} else {
					BradescoFacesUtils
							.addErrorModalMessage("Arquivo inválido para Upload.");
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

	public QuestionarioImobiliarioVO popularViaXls(
			SetorImobiliarioVO xlsQuestionario,
			SetorImobiliarioVO xlsAndamento, SetorImobiliarioVO xlsConcluidas) {
		QuestionarioImobiliarioVO imobiliario = new QuestionarioImobiliarioVO();

		/** ABA Questionario **/
		AbaQuestionarioImobiliarioVO abaQuestionnario = new AbaQuestionarioImobiliarioVO();

		if (siteUtil.isEmptyOrNull(xlsQuestionario.getTipoEmpreendimento())) {
			abaQuestionnario.setEmpreendimentoResidencial(Boolean.FALSE);
			abaQuestionnario.setEmpreendimentoComercial(Boolean.FALSE);
		} else {
			if (xlsQuestionario.getTipoEmpreendimento().toUpperCase()
					.equals("RESIDENCIAL")) {
				abaQuestionnario.setEmpreendimentoResidencial(Boolean.TRUE);
			} else if (xlsQuestionario.getTipoEmpreendimento().toUpperCase()
					.equals("COMERCIAL")) {
				abaQuestionnario.setEmpreendimentoComercial(Boolean.TRUE);
			} else if (xlsQuestionario.getTipoEmpreendimento().toUpperCase()
					.equals("RESIDENCIAL / COMERCIAL")) {
				abaQuestionnario.setEmpreendimentoResidencial(Boolean.TRUE);
				abaQuestionnario.setEmpreendimentoComercial(Boolean.TRUE);
			}
		}

		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPublicoAlvo())) {
			abaQuestionnario.setBaixaRenda(Boolean.FALSE);
			abaQuestionnario.setClasseMedia(Boolean.FALSE);
			abaQuestionnario.setAltoPadrao(Boolean.FALSE);
		} else {
			if (xlsQuestionario.getPublicoAlvo().toUpperCase()
					.equals("BAIXA RENDA")) {
				abaQuestionnario.setBaixaRenda(Boolean.TRUE);
			} else if (xlsQuestionario.getPublicoAlvo().toUpperCase()
					.equals("CLASSE MÉDIA")) {
				abaQuestionnario.setClasseMedia(Boolean.TRUE);
			} else if (xlsQuestionario.getPublicoAlvo().toUpperCase()
					.equals("ALTO PADRÃO")) {
				abaQuestionnario.setAltoPadrao(Boolean.TRUE);
			} else if (xlsQuestionario.getPublicoAlvo().toUpperCase()
					.equals("BAIXA RENDA / CLASSE MÉDIA")) {
				abaQuestionnario.setBaixaRenda(Boolean.TRUE);
				abaQuestionnario.setClasseMedia(Boolean.TRUE);
			} else if (xlsQuestionario.getPublicoAlvo().toUpperCase()
					.equals("BAIXA RENDA / ALTO PADRÃO")) {
				abaQuestionnario.setBaixaRenda(Boolean.TRUE);
				abaQuestionnario.setAltoPadrao(Boolean.TRUE);
			} else if (xlsQuestionario.getPublicoAlvo().toUpperCase()
					.equals("CLASSE MÉDIA / ALTO PADRÃO")) {
				abaQuestionnario.setClasseMedia(Boolean.TRUE);
				abaQuestionnario.setAltoPadrao(Boolean.TRUE);
			} else if (xlsQuestionario.getPublicoAlvo().toUpperCase()
					.equals("BAIXA RENDA / CLASSE MÉDIA / ALTO PADRÃO")) {
				abaQuestionnario.setBaixaRenda(Boolean.TRUE);
				abaQuestionnario.setClasseMedia(Boolean.TRUE);
				abaQuestionnario.setAltoPadrao(Boolean.TRUE);
			}
		}

		abaQuestionnario.setPreChaves(siteUtil
				.tratarDuasCasasDecimais(xlsQuestionario.getPreChaves()));
		abaQuestionnario.setPosChaves(siteUtil
				.tratarDuasCasasDecimais(xlsQuestionario.getPosChaves()));

		if (siteUtil.isEmptyOrNull(xlsQuestionario.getTipoConstrutora())) {
			abaQuestionnario.setPropria(Boolean.FALSE);
			abaQuestionnario.setTerceirizada(Boolean.FALSE);
		} else {
			if (xlsQuestionario.getTipoConstrutora().toUpperCase()
					.equals("PRÓPRIA")) {
				abaQuestionnario.setPropria(Boolean.TRUE);
			} else if (xlsQuestionario.getTipoConstrutora().toUpperCase()
					.equals("TERCEIRIZADA")) {
				abaQuestionnario.setTerceirizada(Boolean.TRUE);
			} else if (xlsQuestionario.getTipoConstrutora().toUpperCase()
					.equals("PRÓPRIA / TERCEIRIZADA")) {
				abaQuestionnario.setPropria(Boolean.TRUE);
				abaQuestionnario.setTerceirizada(Boolean.TRUE);
			}
		}

		abaQuestionnario.setNomeTerceirizada(xlsQuestionario
				.getDescricaoConstrutora());

		// Area Atuação
		List<AreaAtuacaoVO> listaAreaAtuacao = new ArrayList<AreaAtuacaoVO>();
		AreaAtuacaoVO areaAtuacao;

		areaAtuacao = new AreaAtuacaoVO();
		areaAtuacao.setEstado(xlsQuestionario.getAreaAtuacaoEstado1());
		areaAtuacao.setRegiao(xlsQuestionario.getAreaAtuacaoRegiao1());
		listaAreaAtuacao.add(areaAtuacao);

		areaAtuacao = new AreaAtuacaoVO();
		areaAtuacao.setEstado(xlsQuestionario.getAreaAtuacaoEstado2());
		areaAtuacao.setRegiao(xlsQuestionario.getAreaAtuacaoRegiao2());
		listaAreaAtuacao.add(areaAtuacao);

		areaAtuacao = new AreaAtuacaoVO();
		areaAtuacao.setEstado(xlsQuestionario.getAreaAtuacaoEstado3());
		areaAtuacao.setRegiao(xlsQuestionario.getAreaAtuacaoRegiao3());
		listaAreaAtuacao.add(areaAtuacao);

		areaAtuacao = new AreaAtuacaoVO();
		areaAtuacao.setEstado(xlsQuestionario.getAreaAtuacaoEstado4());
		areaAtuacao.setRegiao(xlsQuestionario.getAreaAtuacaoRegiao4());
		listaAreaAtuacao.add(areaAtuacao);

		areaAtuacao = new AreaAtuacaoVO();
		areaAtuacao.setEstado(xlsQuestionario.getAreaAtuacaoEstado5());
		areaAtuacao.setRegiao(xlsQuestionario.getAreaAtuacaoRegiao5());
		listaAreaAtuacao.add(areaAtuacao);

		abaQuestionnario.setListaAreaAtuacao(listaAreaAtuacao);
		while (abaQuestionnario.getCopiaListaAreaAtuacao().size() < Numeros.CINCO) {
			abaQuestionnario.getCopiaListaAreaAtuacao()
					.add(new AreaAtuacaoVO());
		}
		for (int i = 0; i < Numeros.CINCO; i++) {
			if (this.viewHelper.getQuestionarioImobiliarioVO()
					.getQuestionario().getListaAreaAtuacao().get(i)
					.getNumSequencial() != 0) {
				abaQuestionnario
						.getListaAreaAtuacao()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getQuestionario()
										.getListaAreaAtuacao().get(i)
										.getNumSequencial());
				abaQuestionnario
						.getCopiaListaAreaAtuacao()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getQuestionario()
										.getCopiaListaAreaAtuacao().get(i)
										.getNumSequencial());
			}
		}

		// Histórico de Lançamentos
		List<HistoricoLancamentosVO> listaHistoricoLancamentos = new ArrayList<HistoricoLancamentosVO>();
		HistoricoLancamentosVO historicoLancamentos;

		historicoLancamentos = new HistoricoLancamentosVO();
		historicoLancamentos.setAno(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoAno1()));
		historicoLancamentos.setVgvLancado(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoVGV1()));
		historicoLancamentos.setQtdeEmpreendimentos(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoQtdeEmpreendimentos1()));
		listaHistoricoLancamentos.add(historicoLancamentos);

		historicoLancamentos = new HistoricoLancamentosVO();
		historicoLancamentos.setAno(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoAno2()));
		historicoLancamentos.setVgvLancado(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoVGV2()));
		historicoLancamentos.setQtdeEmpreendimentos(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoQtdeEmpreendimentos2()));
		listaHistoricoLancamentos.add(historicoLancamentos);

		historicoLancamentos = new HistoricoLancamentosVO();
		historicoLancamentos.setAno(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoAno3()));
		historicoLancamentos.setVgvLancado(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoVGV3()));
		historicoLancamentos.setQtdeEmpreendimentos(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoQtdeEmpreendimentos3()));
		listaHistoricoLancamentos.add(historicoLancamentos);

		historicoLancamentos = new HistoricoLancamentosVO();
		historicoLancamentos.setAno(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoAno4()));
		historicoLancamentos.setVgvLancado(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoVGV4()));
		historicoLancamentos.setQtdeEmpreendimentos(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoQtdeEmpreendimentos4()));
		listaHistoricoLancamentos.add(historicoLancamentos);

		historicoLancamentos = new HistoricoLancamentosVO();
		historicoLancamentos.setAno(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoAno5()));
		historicoLancamentos.setVgvLancado(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoVGV5()));
		historicoLancamentos.setQtdeEmpreendimentos(siteUtil
				.tratarParametroString(xlsQuestionario
						.getHistoricoLancamentoQtdeEmpreendimentos5()));
		listaHistoricoLancamentos.add(historicoLancamentos);

		abaQuestionnario
				.setListaHistoricoLancamentos(listaHistoricoLancamentos);
		while (abaQuestionnario.getCopiaListaHistoricoLancamentos().size() < Numeros.CINCO) {
			abaQuestionnario.getCopiaListaHistoricoLancamentos().add(
					new HistoricoLancamentosVO());
		}
		for (int i = 0; i < Numeros.CINCO; i++) {
			if (this.viewHelper.getQuestionarioImobiliarioVO()
					.getQuestionario().getListaHistoricoLancamentos().get(i)
					.getNumSequencial() != 0) {
				abaQuestionnario
						.getListaHistoricoLancamentos()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getQuestionario()
										.getListaHistoricoLancamentos().get(i)
										.getNumSequencial());
				abaQuestionnario
						.getCopiaListaHistoricoLancamentos()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getQuestionario()
										.getCopiaListaHistoricoLancamentos()
										.get(i).getNumSequencial());
			}
		}

		// Land Bank
		List<LandBankVO> listaLandBank = new ArrayList<LandBankVO>();
		LandBankVO landBank;

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento1());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao1());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno1()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado1()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista1());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus1())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus1().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus1().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento2());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao2());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno2()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado2()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista2());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus2())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus2().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus2().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento3());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao3());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno3()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado3()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista3());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus3())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus3().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus3().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento4());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao4());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno4()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado4()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista4());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus4())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus4().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus4().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento5());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao5());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno5()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado5()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista5());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus5())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus5().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus5().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento6());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao6());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno6()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado6()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista6());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus6())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus6().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus6().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento7());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao7());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno7()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado7()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista7());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus7())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus7().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus7().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento8());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao8());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno8()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado8()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista8());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus8())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus8().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus8().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento9());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao9());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno9()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado9()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista9());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus9())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus9().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus9().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento10());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao10());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno10()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado10()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista10());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus10())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus10().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus10().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento11());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao11());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno11()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado11()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista11());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus11())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus11().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus11().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento12());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao12());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno12()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado12()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista12());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus12())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus12().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus12().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento13());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao13());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno13()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado13()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista13());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus13())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus13().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus13().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento14());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao14());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno14()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado14()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista14());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus14())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus14().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus14().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento15());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao15());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno15()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado15()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista15());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus15())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus15().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus15().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento16());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao16());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno16()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado16()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista16());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus16())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus16().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus16().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento17());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao17());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno17()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado17()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista17());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus17())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus17().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus17().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento18());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao18());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno18()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado18()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista18());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus18())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus18().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus18().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento19());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao19());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno19()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado19()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista19());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus19())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus19().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus19().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento20());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao20());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno20()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado20()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista20());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus20())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus20().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus20().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento21());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao21());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno21()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado21()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista21());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus21())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus21().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus21().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento22());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao22());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno22()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado22()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista22());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus22())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus12().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus12().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento23());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao23());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno23()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado23()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista23());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus23())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus23().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus23().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento24());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao24());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno24()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado24()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista24());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus24())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus24().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus24().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento25());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao25());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno25()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado25()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista25());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus25())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus25().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus25().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento26());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao26());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno26()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado26()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista26());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus26())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus26().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus26().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento27());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao27());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno27()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado27()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista27());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus27())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus17().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus17().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento28());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao28());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno28()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado28()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista28());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus28())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus28().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus28().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento29());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao29());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno29()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado29()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista29());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus29())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus29().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus29().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento30());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao30());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno30()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado30()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista30());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus30())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus30().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus30().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento31());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao31());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno31()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado31()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista31());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus31())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus31().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus31().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento32());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao32());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno32()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado32()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista32());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus32())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus32().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus32().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento33());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao33());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno33()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado33()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista33());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus33())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus33().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus33().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento34());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao34());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno34()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado34()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista34());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus34())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus34().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus34().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento35());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao35());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno35()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado35()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista35());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus35())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus35().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus35().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento36());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao36());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno36()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado36()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista36());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus36())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus36().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus36().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento37());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao37());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno37()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado37()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista37());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus37())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus37().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus37().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento38());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao38());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno38()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado38()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista38());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus38())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus38().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus38().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento39());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao39());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno39()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado39()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista39());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus39())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus39().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus39().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		landBank = new LandBankVO();
		landBank.setEmpreendimento(xlsQuestionario.getEmpreendimento40());
		landBank.setLocalizacao(xlsQuestionario.getLocalizacao40());
		landBank.setValorTerreno(siteUtil.tratarParametroString(xlsQuestionario
				.getValorDoTerreno40()));
		landBank.setVgvEstimado(siteUtil.tratarParametroString(xlsQuestionario
				.getVgvProjetado40()));
		landBank.setDataPrevista(xlsQuestionario.getDataPrevista40());
		if (siteUtil.isEmptyOrNull(xlsQuestionario.getPossuiOnus40())) {
			landBank.setPossuiOnus("");
		} else {
			if (xlsQuestionario.getPossuiOnus40().toUpperCase().equals("SIM")) {
				landBank.setPossuiOnus("1");
			} else if (xlsQuestionario.getPossuiOnus40().toUpperCase()
					.equals("NÃO")) {
				landBank.setPossuiOnus("2");
			}
		}
		listaLandBank.add(landBank);

		abaQuestionnario.setListaLandBank(listaLandBank);
		while (abaQuestionnario.getCopiaListaLandBank().size() < Numeros.QUARENTA) {
			abaQuestionnario.getCopiaListaLandBank().add(new LandBankVO());
		}
		for (int i = 0; i < Numeros.QUARENTA; i++) {
			if (this.viewHelper.getQuestionarioImobiliarioVO()
					.getQuestionario().getListaLandBank().get(i)
					.getNumSequencial() != 0) {
				abaQuestionnario
						.getListaLandBank()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getQuestionario().getListaLandBank()
										.get(i).getNumSequencial());
				abaQuestionnario
						.getCopiaListaLandBank()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getQuestionario()
										.getCopiaListaLandBank().get(i)
										.getNumSequencial());
			}
		}

		imobiliario.setQuestionario(abaQuestionnario);

		/** ABA Obras em Andamento **/
		List<ObrasAndamentoVO> listaObrasAndamento = new ArrayList<ObrasAndamentoVO>();
		ObrasAndamentoVO obrasAndamento;

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora1());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento1());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao1());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao1());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao1());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento1()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento1());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega1());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra1()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra1()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer1()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal1()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas1()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque1()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas1()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas1()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda1()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato1()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos1()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves1()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves1()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro1());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato1()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar1()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor1()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora2());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento2());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao2());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao2());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao2());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento2()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento2());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega2());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra2()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra2()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer2()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal2()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas2()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque2()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas2()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas2()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda2()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato2()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos2()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves2()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves2()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro2());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato2()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar2()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor2()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora3());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento3());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao3());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao3());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao3());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento3()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento3());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega3());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra3()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra3()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer3()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal3()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas3()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque3()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas3()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas3()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda3()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato3()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos3()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves3()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves3()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro3());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato3()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar3()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor3()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora4());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento4());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao4());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao4());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao4());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento4()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento4());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega4());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra4()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra4()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer4()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal4()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas4()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque4()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas4()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas4()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda4()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato4()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos4()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves4()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves4()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro4());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato4()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar4()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor4()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora5());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento5());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao5());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao5());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao5());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento5()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento5());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega5());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra5()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra5()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer5()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal5()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas5()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque5()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas5()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas5()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda5()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato5()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos5()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves5()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves5()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro5());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato5()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar5()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor5()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora6());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento6());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao6());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao6());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao6());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento6()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento6());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega6());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra6()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra6()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer6()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal6()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas6()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque6()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas6()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas6()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda6()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato6()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos6()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves6()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves6()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro6());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato6()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar6()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor6()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora7());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento7());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao7());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao7());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao7());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento7()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento7());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega7());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra7()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra7()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer7()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal7()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas7()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque7()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas7()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas7()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda7()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato7()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos7()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves7()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves7()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro7());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato7()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar7()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor7()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora8());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento8());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao8());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao8());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao8());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento8()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento8());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega8());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra8()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra8()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer8()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal8()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas8()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque8()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas8()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas8()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda8()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato8()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos8()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves8()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves8()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro8());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato8()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar8()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor8()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora9());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento9());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao9());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao9());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao9());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento9()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento9());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega9());
		obrasAndamento.setPorcentagemObra(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getPorcentagemDeObra9()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra9()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer9()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal9()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas9()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque9()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas9()));
		obrasAndamento
				.setTotalUnidadesComPermutas(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesPermutas9()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda9()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato9()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos9()));
		obrasAndamento.setValoresAteChaves(siteUtil
				.tratarParametroString(xlsAndamento.getaReceberAteAsChaves9()));
		obrasAndamento.setValoresPosChaves(siteUtil
				.tratarParametroString(xlsAndamento.getRecebiveisPosChaves9()));
		obrasAndamento.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro9());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato9()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar9()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor9()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora10());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento10());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao10());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao10());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao10());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento10()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento10());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega10());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra10()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra10()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer10()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal10()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas10()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque10()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas10()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas10()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda10()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato10()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos10()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves10()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves10()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro10());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato10()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar10()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor10()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora11());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento11());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao11());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao11());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao11());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento11()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento11());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega11());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra11()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra11()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer11()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal11()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas11()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque11()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas11()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas11()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda11()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato11()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos11()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves11()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves11()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro11());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato11()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar11()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor11()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora12());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento12());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao12());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao12());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao12());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento12()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento12());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega12());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra12()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra12()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer12()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal12()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas12()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque12()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas12()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas12()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda12()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato12()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos12()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves12()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves12()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro12());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato12()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar12()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor12()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora13());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento13());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao13());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao13());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao13());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento13()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento13());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega13());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra13()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra13()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer13()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal13()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas13()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque13()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas13()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas13()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda13()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato13()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos13()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves13()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves13()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro13());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato13()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar13()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor13()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora14());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento14());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao14());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao14());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao14());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento14()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento14());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega14());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra14()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra14()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer14()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal14()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas14()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque14()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas14()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas14()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda14()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato14()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos14()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves14()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves14()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro14());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato14()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar14()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor14()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora15());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento15());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao15());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao15());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao15());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento15()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento15());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega15());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra15()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra15()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer15()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal15()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas15()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque15()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas15()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas15()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda15()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato15()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos15()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves15()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves15()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro15());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato15()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar15()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor15()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora16());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento16());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao16());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao16());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao16());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento16()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento16());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega16());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra16()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra16()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer16()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal16()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas16()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque16()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas16()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas16()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda16()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato16()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos16()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves16()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves16()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro16());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato16()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar16()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor16()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora17());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento17());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao17());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao17());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao17());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento17()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento17());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega17());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra17()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra17()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer17()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal17()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas17()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque17()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas17()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas17()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda17()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato17()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos17()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves17()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves17()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro17());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato17()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar17()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor17()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora18());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento18());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao18());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao18());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao18());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento18()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento18());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega18());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra18()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra18()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer18()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal18()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas18()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque18()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas18()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas18()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda18()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato18()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos18()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves18()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves18()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro18());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato18()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar18()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor18()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora19());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento19());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao19());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao19());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao19());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento19()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento19());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega19());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra19()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra19()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer19()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal19()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas19()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque19()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas19()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas19()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda19()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato19()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos19()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves19()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves19()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro19());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato19()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar19()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor19()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora20());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento20());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao20());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao20());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao20());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento20()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento20());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega20());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra20()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra20()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer20()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal20()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas20()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque20()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas20()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas20()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda20()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato20()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos20()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves20()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves20()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro20());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato20()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar20()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor20()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora21());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento21());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao21());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao21());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao21());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento21()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento21());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega21());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra21()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra21()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer21()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal21()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas21()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque21()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas21()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas21()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda21()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato21()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos21()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves21()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves21()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro21());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato21()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar21()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor21()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora22());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento22());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao22());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao22());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao22());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento22()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento22());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega22());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra22()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra22()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer22()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal22()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas22()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque22()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas22()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas22()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda22()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato22()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos22()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves22()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves22()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro22());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato22()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar22()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor22()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora23());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento23());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao23());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao23());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao23());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento23()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento23());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega23());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra23()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra23()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer23()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal23()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas23()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque23()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas23()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas23()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda23()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato23()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos23()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves23()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves23()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro23());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato23()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar23()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor23()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora24());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento24());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao24());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao24());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao24());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento24()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento24());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega24());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra24()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra24()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer24()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal24()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas24()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque24()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas24()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas24()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda24()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato24()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos24()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves24()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves24()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro24());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato24()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar24()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor24()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora25());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento25());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao25());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao25());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao25());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento25()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento25());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega25());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra25()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra25()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer25()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal25()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas25()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque25()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas25()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas25()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda25()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato25()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos25()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves25()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves25()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro25());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato25()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar25()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor25()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora26());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento26());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao26());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao26());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao26());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento26()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento26());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega26());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra26()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra26()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer26()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal26()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas26()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque26()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas26()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas26()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda26()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato26()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos26()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves26()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves26()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro26());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato26()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar26()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor26()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora27());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento27());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao27());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao27());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao27());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento27()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento27());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega27());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra27()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra27()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer27()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal27()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas27()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque27()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas27()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas27()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda27()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato27()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos27()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves27()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves27()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro27());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato27()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar27()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor27()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora28());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento28());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao28());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao28());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao28());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento28()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento28());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega28());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra28()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra28()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer28()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal28()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas28()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque28()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas28()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas28()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda28()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato28()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos28()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves28()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves28()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro28());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato28()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar28()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor28()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora29());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento29());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao29());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao29());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao29());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento29()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento29());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega29());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra29()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra29()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer29()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal29()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas29()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque29()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas29()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas29()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda29()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato29()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos29()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves29()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves29()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro29());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato29()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar29()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor29()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora30());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento30());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao30());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao30());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao30());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento30()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento30());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega30());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra30()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra30()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer30()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal30()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas30()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque30()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas30()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas30()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda30()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato30()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos30()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves30()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves30()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro30());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato30()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar30()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor30()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora31());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento31());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao31());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao31());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao31());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento31()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento31());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega31());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra31()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra31()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer31()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal31()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas31()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque31()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas31()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas31()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda31()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato31()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos31()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves31()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves31()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro31());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato31()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar31()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor31()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora32());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento32());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao32());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao32());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao32());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento32()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento32());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega32());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra32()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra32()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer32()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal32()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas32()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque32()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas32()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas32()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda32()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato32()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos32()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves32()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves32()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro32());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato32()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar32()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor32()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora33());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento33());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao33());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao33());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao33());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento33()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento33());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega33());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra33()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra33()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer33()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal33()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas33()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque33()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas33()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas33()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda33()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato33()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos33()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves33()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves33()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro33());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato33()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar33()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor33()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora34());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento34());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao34());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao34());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao34());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento34()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento34());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega34());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra34()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra34()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer34()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal34()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas34()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque34()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas34()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas34()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda34()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato34()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos34()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves34()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves34()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro34());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato34()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar34()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor34()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora35());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento35());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao35());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao35());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao35());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento35()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento35());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega35());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra35()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra35()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer35()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal35()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas35()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque35()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas35()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas35()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda35()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato35()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos35()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves35()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves35()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro35());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato35()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar35()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor35()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora36());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento36());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao36());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao36());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao36());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento36()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento36());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega36());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra36()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra36()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer36()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal36()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas36()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque36()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas36()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas36()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda36()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato36()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos36()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves36()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves36()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro36());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato36()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar36()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor36()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora37());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento37());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao37());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao37());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao37());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento37()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento37());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega37());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra37()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra37()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer37()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal37()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas37()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque37()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas37()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas37()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda37()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato37()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos37()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves37()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves37()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro37());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato37()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar37()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor37()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora38());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento38());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao38());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao38());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao38());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento38()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento38());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega38());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra38()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra38()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer38()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal38()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas38()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque38()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas38()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas38()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda38()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato38()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos38()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves38()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves38()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro38());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato38()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar38()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor38()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora39());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento39());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao39());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao39());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao39());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento39()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento39());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega39());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra39()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra39()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer39()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal39()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas39()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque39()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas39()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas39()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda39()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato39()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos39()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves39()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves39()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro39());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato39()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar39()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor39()));
		listaObrasAndamento.add(obrasAndamento);

		obrasAndamento = new ObrasAndamentoVO();
		obrasAndamento.setIncorporadora(xlsAndamento.getIncorporadora40());
		obrasAndamento.setNomeEmpreendimento(xlsAndamento
				.getNomeEmpreendimento40());
		obrasAndamento.setBairro(xlsAndamento.getBairroLocalizacao40());
		obrasAndamento.setCidade(xlsAndamento.getCidadeLocalizacao40());
		obrasAndamento.setUf(xlsAndamento.getUfLocalizacao40());
		obrasAndamento.setPorcPartEmpreendimento(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento
						.getParticipacaoNoEmpreendimento40()));
		obrasAndamento.setDataLancamento(xlsAndamento.getDataLancamento40());
		obrasAndamento.setPrevisaoEntrega(xlsAndamento.getPrevisaoEntrega40());
		obrasAndamento
				.setPorcentagemObra(siteUtil
						.tratarDuasCasasDecimais(xlsAndamento
								.getPorcentagemDeObra40()));
		obrasAndamento.setTotalObra(siteUtil.tratarParametroString(xlsAndamento
				.getCustoTotalDaObra40()));
		obrasAndamento.setaIncorrer(siteUtil.tratarParametroString(xlsAndamento
				.getCustoAIncorrer40()));
		obrasAndamento.setVgvTotal(siteUtil.tratarParametroString(xlsAndamento
				.getVgvTotal40()));
		obrasAndamento.setVgvSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento.getVgvPermutas40()));
		obrasAndamento
				.setTotalUnidadesEstoque(siteUtil
						.tratarParametroString(xlsAndamento
								.getTotalUnidadesEstoque40()));
		obrasAndamento.setTotalUnidadesSemPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesMenosPermutas40()));
		obrasAndamento.setTotalUnidadesComPermutas(siteUtil
				.tratarParametroString(xlsAndamento
						.getTotalUnidadesPermutas40()));
		obrasAndamento.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getVenda40()));
		obrasAndamento.setPorcentagemDistratos(siteUtil
				.tratarDuasCasasDecimais(xlsAndamento.getDistrato40()));
		obrasAndamento.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsAndamento.getValoresJaRecebidos40()));
		obrasAndamento
				.setValoresAteChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getaReceberAteAsChaves40()));
		obrasAndamento
				.setValoresPosChaves(siteUtil
						.tratarParametroString(xlsAndamento
								.getRecebiveisPosChaves40()));
		obrasAndamento
				.setAgenteFinanceiro(xlsAndamento.getAgenteFinanceiro40());
		obrasAndamento.setValorContrato(siteUtil
				.tratarParametroString(xlsAndamento.getValorDoContrato40()));
		obrasAndamento.setSaldoALiberar(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoALiberar40()));
		obrasAndamento.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsAndamento.getSaldoDevedor40()));
		listaObrasAndamento.add(obrasAndamento);

		imobiliario.setListaObrasAndamento(listaObrasAndamento);
		while (imobiliario.getCopiaListaObrasAndamento().size() < Numeros.QUARENTA) {
			imobiliario.getCopiaListaObrasAndamento().add(
					new ObrasAndamentoVO());
		}
		for (int i = 0; i < Numeros.QUARENTA; i++) {
			if (!this.viewHelper.getQuestionarioImobiliarioVO()
					.getListaObrasAndamento().get(i).getNumSequencial()
					.equals("0")) {
				imobiliario
						.getListaObrasAndamento()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getListaObrasAndamento().get(i)
										.getNumSequencial());
				imobiliario
						.getCopiaListaObrasAndamento()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getCopiaListaObrasAndamento().get(i)
										.getNumSequencial());
			}
		}

		imobiliario.getObrasAndamento().setDescObrasAndamento(
				xlsAndamento.getComentariosGeraisObrasAndamento());

		/** ABA Obras Concluidas **/
		List<ObrasConcluidasVO> listaObrasConcluidas = new ArrayList<ObrasConcluidasVO>();
		ObrasConcluidasVO obrasConcluidas;

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida1());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida1());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida1());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida1());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida1());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida1());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida1()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida1()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida1()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida1()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida1()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida1()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida1()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida1());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida1()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida2());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida2());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida2());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida2());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida2());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida2());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida2()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida2()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida2()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida2()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida2()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida2()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida2()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida2());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida2()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida3());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida3());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida3());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida3());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida3());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida3());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida3()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida3()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida3()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida3()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida3()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida3()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida3()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida3());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida3()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida4());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida4());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida4());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida4());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida4());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida4());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida4()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida4()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida4()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida4()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida4()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida4()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida4()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida4());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida4()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida5());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida5());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida5());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida5());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida5());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida5());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida5()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida5()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida5()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida5()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida5()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida5()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida5()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida5());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida5()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida6());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida6());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida6());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida6());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida6());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida6());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida6()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida6()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida6()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida6()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida6()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida6()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida6()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida6());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida6()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida7());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida7());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida7());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida7());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida7());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida7());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida7()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida7()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida7()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida7()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida7()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida7()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida7()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida7());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida7()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida8());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida8());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida8());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida8());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida8());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida8());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida8()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida8()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida8()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida8()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida8()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida8()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida8()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida8());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida8()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida9());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida9());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida9());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida9());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida9());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida9());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida9()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida9()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida9()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida9()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida9()));
		obrasConcluidas
				.setValorEstoque(siteUtil.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida9()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida9()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida9());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida9()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida10());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida10());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida10());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida10());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida10());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida10());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida10()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida10()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida10()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida10()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida10()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida10()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida10()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida10());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida10()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida11());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida11());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida11());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida11());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida11());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida11());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida11()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida11()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida11()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida11()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida11()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida11()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida11()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida11());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida11()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida12());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida12());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida12());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida12());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida12());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida12());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida12()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida12()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida12()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida12()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida12()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida12()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida12()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida12());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida12()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida13());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida13());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida13());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida13());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida13());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida13());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida13()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida13()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida13()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida13()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida13()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida13()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida13()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida13());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida13()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida14());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida14());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida14());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida14());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida14());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida14());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida14()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida14()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida14()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida14()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida14()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida14()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida14()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida14());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida14()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida15());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida15());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida15());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida15());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida15());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida15());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida15()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida15()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida15()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida15()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida15()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida15()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida15()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida15());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida15()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida16());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida16());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida16());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida16());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida16());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida16());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida16()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida16()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida16()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida16()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida16()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida16()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida16()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida16());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida16()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida17());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida17());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida17());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida17());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida17());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida17());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida17()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida17()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida17()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida17()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida17()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida17()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida17()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida17());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida17()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida18());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida18());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida18());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida18());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida18());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida18());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida18()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida18()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida18()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida18()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida18()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida18()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida18()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida18());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida18()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida19());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida19());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida19());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida19());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida19());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida19());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida19()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida19()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida19()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida19()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida19()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida19()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida19()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida19());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida19()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida20());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida20());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida20());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida20());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida20());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida20());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida20()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida20()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida20()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida20()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida20()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida20()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida20()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida20());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida20()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida21());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida21());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida21());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida21());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida21());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida21());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida21()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida21()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida21()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida21()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida21()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida21()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida21()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida21());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida21()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida22());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida22());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida22());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida22());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida22());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida22());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida22()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida22()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida22()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida22()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida22()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida22()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida22()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida22());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida22()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida23());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida23());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida23());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida23());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida23());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida23());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida23()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida23()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida23()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida23()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida23()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida23()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida23()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida23());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida23()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida24());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida24());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida24());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida24());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida24());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida24());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida24()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida24()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida24()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida24()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida24()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida24()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida24()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida24());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida24()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida25());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida25());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida25());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida25());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida25());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida25());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida25()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida25()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida25()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida25()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida25()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida25()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida25()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida25());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida25()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida26());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida26());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida26());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida26());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida26());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida26());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida26()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida26()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida26()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida26()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida26()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida26()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida26()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida26());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida26()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida27());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida27());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida27());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida27());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida27());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida27());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida27()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida27()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida27()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida27()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida27()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida27()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida27()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida27());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida27()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida28());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida28());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida28());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida28());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida28());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida28());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida28()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida28()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida28()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida28()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida28()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida28()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida28()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida28());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida28()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida29());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida29());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida29());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida29());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida29());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida29());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida29()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida29()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida29()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida29()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida29()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida29()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida29()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida29());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida29()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida30());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida30());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida30());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida30());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida30());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida30());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida30()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida30()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida30()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida30()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida30()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida30()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida30()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida30());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida30()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida31());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida31());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida31());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida31());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida31());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida31());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida31()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida31()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida31()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida31()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida31()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida31()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida31()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida31());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida31()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida32());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida32());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida32());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida32());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida32());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida32());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida32()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida32()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida32()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida32()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida32()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida32()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida32()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida32());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida32()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida33());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida33());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida33());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida33());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida33());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida33());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida33()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida33()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida33()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida33()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida33()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida33()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida33()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida33());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida33()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida34());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida34());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida34());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida34());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida34());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida34());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida34()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida34()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida34()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida34()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida34()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida34()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida34()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida34());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida34()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida35());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida35());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida35());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida35());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida35());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida35());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida35()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida35()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida35()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida35()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida35()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida35()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida35()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida35());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida35()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida36());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida36());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida36());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida36());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida36());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida36());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida36()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida36()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida36()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida36()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida36()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida36()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida36()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida36());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida36()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida37());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida37());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida37());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida37());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida37());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida37());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida37()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida37()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida37()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida37()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida37()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida37()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida37()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida37());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida37()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida38());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida38());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida38());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida38());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida38());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida38());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida38()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida38()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida38()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida38()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida38()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida38()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida38()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida38());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida38()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida39());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida39());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida39());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida39());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida39());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida39());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida39()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida39()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida39()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida39()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida39()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida39()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida39()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida39());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida39()));
		listaObrasConcluidas.add(obrasConcluidas);

		obrasConcluidas = new ObrasConcluidasVO();
		obrasConcluidas.setIncorporadora(xlsConcluidas
				.getIncorporadoraObraConcluida40());
		obrasConcluidas.setNomeEmpreendimento(xlsConcluidas
				.getNomeEmpreendimentoObraConcluida40());
		obrasConcluidas.setBairro(xlsConcluidas
				.getBairroLocalizacaoObraConcluida40());
		obrasConcluidas.setCidade(xlsConcluidas
				.getCidadeLocalizacaoObraConcluida40());
		obrasConcluidas.setUf(xlsConcluidas.getUfLocalizacaoObraConcluida40());
		obrasConcluidas.setDataEntrega(xlsConcluidas
				.getDataEntregaObraConcluida40());
		obrasConcluidas.setValoresRecebidos(siteUtil
				.tratarParametroString(xlsConcluidas
						.getRecebidosObraConcluida40()));
		obrasConcluidas.setValoresAte12Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAteDozeMesesObraConcluida40()));
		obrasConcluidas.setValoresDe12Ate36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getDeDozeAteDezesseisMesesObraConcluida40()));
		obrasConcluidas.setValoresApos36Meses(siteUtil
				.tratarParametroString(xlsConcluidas
						.getAposTrintaSeisMesesObraConcluida40()));
		obrasConcluidas.setQtdeUnidades(siteUtil
				.tratarParametroString(xlsConcluidas
						.getQuantidadeUnidadesObraConcluida40()));
		obrasConcluidas.setValorEstoque(siteUtil
				.tratarParametroString(xlsConcluidas
						.getEstoqueObraConcluida40()));
		obrasConcluidas.setPorcentagemVendas(siteUtil
				.tratarDuasCasasDecimais(xlsConcluidas
						.getPercentualVendasObraConcluida40()));
		obrasConcluidas.setAgenteFinanceiro(xlsConcluidas
				.getAgenteFinanceiroObraConcluida40());
		obrasConcluidas.setSaldoDevedor(siteUtil
				.tratarParametroString(xlsConcluidas
						.getSaldoDevedorObraConcluida40()));
		listaObrasConcluidas.add(obrasConcluidas);

		imobiliario.setListaObrasConcluidas(listaObrasConcluidas);
		while (imobiliario.getCopiaListaObrasConcluidas().size() < Numeros.QUARENTA) {
			imobiliario.getCopiaListaObrasConcluidas().add(
					new ObrasConcluidasVO());
		}
		for (int i = 0; i < Numeros.QUARENTA; i++) {
			if (!this.viewHelper.getQuestionarioImobiliarioVO()
					.getListaObrasConcluidas().get(i).getNumSequencial()
					.equals("0")) {
				imobiliario
						.getListaObrasConcluidas()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getListaObrasConcluidas().get(i)
										.getNumSequencial());
				imobiliario
						.getCopiaListaObrasConcluidas()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getQuestionarioImobiliarioVO()
										.getCopiaListaObrasConcluidas().get(i)
										.getNumSequencial());
			}
		}

		imobiliario.getObrasConcluidas().setDescObrasConcluidas(
				xlsConcluidas.getComentariosGeraisObraConcluida());

		imobiliario.setCodGrupoEconomico(this.viewHelper
				.getQuestionarioImobiliarioVO().getCodGrupoEconomico());
		imobiliario.setDescGrupoEconomico(this.viewHelper
				.getQuestionarioImobiliarioVO().getDescGrupoEconomico());

		imobiliario.setCodRelatorio(this.viewHelper
				.getQuestionarioImobiliarioVO().getCodRelatorio());

		return imobiliario;
	}

	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

	public UITab getTabQuestionario() {
		return tabQuestionario;
	}

	public void setTabQuestionario(UITab tabQuestionario) {
		this.tabQuestionario = tabQuestionario;
	}

	public UITab getTabObrasAndamento() {
		return tabObrasAndamento;
	}

	public void setTabObrasAndamento(UITab tabObrasAndamento) {
		this.tabObrasAndamento = tabObrasAndamento;
	}

	public UITab getTabObrasConcluidas() {
		return tabObrasConcluidas;
	}

	public void setTabObrasConcluidas(UITab tabObrasConcluidas) {
		this.tabObrasConcluidas = tabObrasConcluidas;
	}

	public ArrayList<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<String> mensagens) {
		this.mensagens = mensagens;
	}

	public String getAbaSelecionada() {
		return abaSelecionada;
	}

	public void setAbaSelecionada(String abaSelecionada) {
		this.abaSelecionada = abaSelecionada;
	}

	public enum AbaEnum {

		QUESTIONARIO(1, "questionario"), OBRAS_ANDAMENTO(2, "obras_andamento"), OBRAS_CONCLUIDAS(
				3, "obras_concluidas");

		private Integer codigo = null;
		private String descricao = null;

		private AbaEnum(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public static AbaEnum getByDescricao(String descricao) {
			if (SiteUtil.getInstance().isEmptyOrNull(descricao)) {
				return QUESTIONARIO;
			} else if (descricao.equals("questionario")) {
				return QUESTIONARIO;
			} else if (descricao.equals("obrasAndamento")) {
				return OBRAS_ANDAMENTO;
			} else if (descricao.equals("obrasConcluidas")) {
				return OBRAS_CONCLUIDAS;
			}

			return QUESTIONARIO;
		}

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

	}

	public DiskFileItem getFile() {
		return file;
	}

	public void setFile(DiskFileItem file) {
		this.file = file;
	}

}