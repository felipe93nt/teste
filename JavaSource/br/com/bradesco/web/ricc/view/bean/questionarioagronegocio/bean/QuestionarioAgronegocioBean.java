package br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
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
import br.com.bradesco.web.aq.view.util.Numeros;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaArrendadaAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaCorteUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPlantadaFibrasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPlantadaGraosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPropriaAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.CogeracaoEnergiaUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.FibrasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.GraosFibrasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.MoagemUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.ProducaoUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.ProdutividadeUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.TerraUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.TipoGraoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.UsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.xls.SetorAgronegocioVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.response.RICCWA8SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.response.RICCWA7SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.business.questionarioagronegocio.IQuestionarioAgronegocioService;
import br.com.bradesco.web.ricc.service.business.questionarioagronegocio.impl.GraoFibraAux;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.SiteUtil;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.viewhelper.QuestionarioAgronegocioViewHelper;
import br.com.bradesco.web.ricc.xls.QuestionarioAgronegocioXLS;

/**
 * @name QuestionarioAgronegocioBean
 * @author Foursys
 * @see QuestionarioAgronegocioBean.java
 * @version 1.0
 * @since 11/09/2018
 */
@SessionScoped
@Named(value = "questionarioAgronegocioBean")
public class QuestionarioAgronegocioBean extends
		AbstractBean<QuestionarioAgronegocioViewHelper> {

	/**
	 *
	 */
	private static final long serialVersionUID = 4282153544491589739L;

	public static final int COD_SOJA = 1;

	public static final int COD_MILHO = 2;

	public static final int COD_ALGODAO = 3;

	/**
	 * Atributo questionarioAgronegocioService Tipo
	 * IQuestionarioAgronegocioService
	 */
	@Inject
	@Named("questionarioAgronegocioService")
	private IQuestionarioAgronegocioService questionarioAgronegocioService;

	/**
	 * Atributo paginaAnterior Tipo String
	 */
	private String paginaAnterior = "";

	private ArrayList<String> mensagens = new ArrayList<String>();

	private UITab tabGraosFibras = null;

	private UITab tabUsinas = null;

	private String abaSelecionada = "";

	private DiskFileItem file;
	private File tempFile;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {

		tabGraosFibras = new UITab();
		tabUsinas = new UITab();

		tabGraosFibras.setSelected(true);

		this.viewHelper = new QuestionarioAgronegocioViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_QUESTIONARIO_AGRONEGOCIO;
	}

	/**
	 * @description
	 * @name carregarDados
	 * @see QuestionarioAgronegocioBean
	 * @return void
	 */
	public void carregarDadosTela() {
		carregarNomeProdutor();
		listarAreaPropria();
		listarAreaArrendada();
		carregarDadosGraoMilho();
		carregarDadosGraoSoja();
		carregarDadosFibraAlgodao();
		carregarDadosUsinas();
	}

	private void calcularTotalizadoresGraosFibras() {
		graoAreaPlantada1Total(null);
		graoAreaPlantada2Total(null);
		graoAreaPlantada3Total(null);
		graoAreaPlantadaProjetadoTotal(null);

		graoProducaoTotal1(null);
		graoProducaoTotal2(null);
		graoProducaoTotal3(null);
		graoProducaoTotalProjetado(null);

		milhoAreaPlantada1Total(null);
		milhoAreaPlantada2Total(null);
		milhoAreaPlantada3Total(null);
		milhoAreaPlantadaProjetadoTotal(null);

		milhoProducaoTotal1(null);
		milhoProducaoTotal2(null);
		milhoProducaoTotal3(null);
		milhoProducaoTotalProjetado(null);

		calcularValoresSafra1(null);
		areaPlantada2Total(null);
		areaPlantada3Total(null);
		areaPlantadaProjetadoTotal(null);
	}

	private void carregarDadosUsinas() {
		try {
			viewHelper
					.getModel()
					.getAbaUsinas()
					.setNomeUsina(
							questionarioAgronegocioService
									.consultaNomeUsina(viewHelper.getModel()));
			consultarUsinas();
			consultarProducaoUsinas();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void carregarDadosFibraAlgodao() {
		try {
			List<GraoFibraAux> listaAlgodao = questionarioAgronegocioService
					.consultarGraosFibras(viewHelper.getModel(), COD_ALGODAO);

			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.setAnoSafra1(
							new GraoFibraAux().mapearSaidaFibra(listaAlgodao
									.get(0)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.setAnoSafra2(
							new GraoFibraAux().mapearSaidaFibra(listaAlgodao
									.get(1)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.setAnoSafra3(
							new GraoFibraAux().mapearSaidaFibra(listaAlgodao
									.get(2)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.setAnoSafraProjetado(
							new GraoFibraAux().mapearSaidaFibra(listaAlgodao
									.get(3)));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void carregarDadosGraoSoja() {
		try {
			List<GraoFibraAux> listaSoja = questionarioAgronegocioService
					.consultarGraosFibras(viewHelper.getModel(), COD_SOJA);

			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoSoja()
					.setAnoSafra1(
							new GraoFibraAux().mapearSaidaGrao(listaSoja.get(0)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoSoja()
					.setAnoSafra2(
							new GraoFibraAux().mapearSaidaGrao(listaSoja.get(1)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoSoja()
					.setAnoSafra3(
							new GraoFibraAux().mapearSaidaGrao(listaSoja.get(2)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoSoja()
					.setAnoSafraProjetado(
							new GraoFibraAux().mapearSaidaGrao(listaSoja.get(3)));
			AreaPlantadaGraosVO areaPlantada = getViewHelper().getModel()
					.getAbaGraos().getGraoSoja().getAnoSafra1();
			getViewHelper().getModel().getAbaGraos().getGraoSoja()
					.setPesoSacaSementes(areaPlantada.getPesoSacaSementes());
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoSoja()
					.setPesoSacaMediaSemente(
							areaPlantada.getPesoSacaMediaSemente());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void carregarDadosGraoMilho() {
		try {
			List<GraoFibraAux> listaMilho = questionarioAgronegocioService
					.consultarGraosFibras(viewHelper.getModel(), COD_MILHO);

			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoMilho()
					.setAnoSafra1(
							new GraoFibraAux().mapearSaidaGrao(listaMilho
									.get(0)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoMilho()
					.setAnoSafra2(
							new GraoFibraAux().mapearSaidaGrao(listaMilho
									.get(1)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoMilho()
					.setAnoSafra3(
							new GraoFibraAux().mapearSaidaGrao(listaMilho
									.get(2)));
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoMilho()
					.setAnoSafraProjetado(
							new GraoFibraAux().mapearSaidaGrao(listaMilho
									.get(3)));
			AreaPlantadaGraosVO areaPlantada = getViewHelper().getModel()
					.getAbaGraos().getGraoMilho().getAnoSafra1();
			getViewHelper().getModel().getAbaGraos().getGraoMilho()
					.setPesoSacaSementes(areaPlantada.getPesoSacaSementes());
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getGraoMilho()
					.setPesoSacaMediaSemente(
							areaPlantada.getPesoSacaMediaSemente());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void carregarNomeProdutor() {
		try {
			QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
			GraosFibrasVO retorno = this.questionarioAgronegocioService
					.listarAreaPropria(RiccConstants.NOME_PRODUTOR,
							agro.getCodGrupo(), agro.getCodRelatorio());
			this.viewHelper.getModel().getAbaGraos()
					.setNomeProdutor(retorno.getNomeProdutor());

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarAreaPropria() {
		try {
			QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
			GraosFibrasVO vo = agro.getAbaGraos();
			vo.getListaAreaPropria().clear();
			vo.setSomaAreaTotalPropria("");
			vo.setSomaAreaProdutivaPropria("");
			vo.setSomaValorMercado("");
			vo.setSomaValorMercadoHectares("");
			GraosFibrasVO retorno = this.questionarioAgronegocioService
					.listarAreaPropria(RiccConstants.AREA_PROPRIA,
							agro.getCodGrupo(), agro.getCodRelatorio());
			vo.setListaAreaPropria(retorno.getListaAreaPropria());

			vo.setSomaAreaTotalPropria(retorno.getSomaAreaTotalPropria());
			vo.setSomaAreaProdutivaPropria(retorno
					.getSomaAreaProdutivaPropria());
			vo.setSomaValorMercado(retorno.getSomaValorMercado());
			vo.setSomaValorMercadoHectares(retorno
					.getSomaValorMercadoHectares());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (viewHelper.getModel().getAbaGraos().getListaAreaPropria().size() < 20) {
			viewHelper.getModel().getAbaGraos().getListaAreaPropria()
					.add(new AreaPropriaAgronegocioVO());
		}
		try {
			copiarAreaPropria();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void copiarAreaPropria() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<AreaPropriaAgronegocioVO> listaCopia = new ArrayList<AreaPropriaAgronegocioVO>();
		AreaPropriaAgronegocioVO voCopia = null;
		for (AreaPropriaAgronegocioVO itemTabela : this.viewHelper.getModel()
				.getAbaGraos().getListaAreaPropria()) {
			voCopia = new AreaPropriaAgronegocioVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if (siteUtil.isEmptyOrNull(voCopia.getDescricao())) {
				voCopia.setDescricao("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getAreaTotal())) {
				voCopia.setAreaTotal("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getAreaProdutiva())) {
				voCopia.setAreaProdutiva("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getCidade())) {
				voCopia.setCidade("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValorMercado())) {
				voCopia.setValorMercado("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getValorMercadoHectare())) {
				voCopia.setValorMercadoHectare("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getIsAreaCedida())) {
				voCopia.setIsAreaCedida("");
			}
			listaCopia.add(voCopia);
		}
		viewHelper.getModel().getAbaGraos()
				.setCopiaListaAreaPropria(listaCopia);
	}

	public void areaPropriaTotal(AjaxBehaviorEvent e) {
		BigInteger somaAreaTotalPropria = new BigInteger("0");
		BigInteger somaAreaProdutivaPropria = new BigInteger("0");
		BigInteger somaValorMercado = new BigInteger("0");
		BigInteger somaValorMercadoHectares = new BigInteger("0");

		for (AreaPropriaAgronegocioVO itemTabela : viewHelper.getModel()
				.getAbaGraos().getListaAreaPropria()) {
			if (siteUtil.isNotEmptyOrNull(itemTabela.getAreaTotal())) {
				somaAreaTotalPropria = somaAreaTotalPropria.add(new BigInteger(
						siteUtil.retirarMascaraNumericos(itemTabela
								.getAreaTotal())));
			}
			if (siteUtil.isNotEmptyOrNull(itemTabela.getAreaProdutiva())) {
				somaAreaProdutivaPropria = somaAreaProdutivaPropria
						.add(new BigInteger(siteUtil
								.retirarMascaraNumericos(itemTabela
										.getAreaProdutiva())));
			}
			if (siteUtil.isNotEmptyOrNull(itemTabela.getValorMercado())) {
				somaValorMercado = somaValorMercado
						.add(new BigInteger(siteUtil
								.retirarMascaraNumericos(itemTabela
										.getValorMercado())));
			}
			if (siteUtil.isNotEmptyOrNull(itemTabela.getValorMercadoHectare())) {
				somaValorMercadoHectares = somaValorMercadoHectares
						.add(new BigInteger(siteUtil
								.retirarMascaraNumericos(itemTabela
										.getValorMercadoHectare())));
			}
		}
		getViewHelper().getModel().getAbaGraos()
				.setSomaAreaTotalPropria(somaAreaTotalPropria.toString());
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.setSomaAreaProdutivaPropria(
						somaAreaProdutivaPropria.toString());
		getViewHelper().getModel().getAbaGraos()
				.setSomaValorMercado(somaValorMercado.toString());
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.setSomaValorMercadoHectares(
						somaValorMercadoHectares.toString());
	}

	public void areaPropria() {
		QuestionarioAgronegocioVO model = this.viewHelper.getModel();
		int contador = 0;
		for (AreaPropriaAgronegocioVO itemTabela : this.viewHelper.getModel()
				.getAbaGraos().getListaAreaPropria()) {
			if (!itemTabela.equals(viewHelper.getModel().getAbaGraos()
					.getCopiaListaAreaPropria().get(contador))) {
				// INCLUSÃO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getDescricao())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getAreaTotal())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getAreaProdutiva())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getCidade())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValorMercado())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getValorMercadoHectare())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getIsAreaCedida())) {
					try {
						questionarioAgronegocioService.manutencaoAreaPropria(
								model, itemTabela,
								TipoManutencaoEnum.INCLUSAO.getCodigo());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getDescricao())
						&& siteUtil.isEmptyOrNull(itemTabela.getAreaTotal())
						&& siteUtil
								.isEmptyOrNull(itemTabela.getAreaProdutiva())
						&& siteUtil.isEmptyOrNull(itemTabela.getCidade())
						&& siteUtil.isEmptyOrNull(itemTabela.getValorMercado())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getValorMercadoHectare())
						&& siteUtil.isEmptyOrNull(itemTabela.getIsAreaCedida())) {
					try {
						questionarioAgronegocioService.manutencaoAreaPropria(
								model, itemTabela,
								TipoManutencaoEnum.EXCLUSAO.getCodigo());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getModel().getAbaGraos().getCopiaListaAreaPropria()
						.get(contador).getNumSequencial()) {
					try {
						questionarioAgronegocioService.manutencaoAreaPropria(
								model, itemTabela,
								TipoManutencaoEnum.INCLUSAO.getCodigo());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarAreaPropria();
	}

	public void incluirAreaPropria() {
		QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
		AreaPropriaAgronegocioVO areaVo = agro.getAbaGraos().getAreaPropria();
		areaVo.setNumSequencial(0);
		try {
			if (validarAreaPropria()) {
				this.questionarioAgronegocioService.manutencaoAreaPropria(agro,
						areaVo, TipoManutencaoEnum.INCLUSAO.getCodigo());
				agro.getAbaGraos().setAreaPropria(
						new AreaPropriaAgronegocioVO());
				// siteUtil.getMessages().getMsgInclusaoSucesso();
				this.listarAreaPropria();
			}
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		listarAreaPropria();
	}

	private boolean validarAreaPropria() {
		AreaPropriaAgronegocioVO area = this.viewHelper.getModel()
				.getAbaGraos().getAreaPropria();

		if (siteUtil.isEmptyOrNull(area.getIsAreaCedida())) {
			BradescoFacesUtils.addInfoModalMessage("Area Cedida inválida!",
					Boolean.FALSE);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public void excluirAreaPropria() {
		QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
		AreaPropriaAgronegocioVO areaVo = agro.getAbaGraos()
				.getAreaPropriaSelecionado().get(Numeros.ZERO);
		try {
			this.questionarioAgronegocioService.manutencaoAreaPropria(agro,
					areaVo, TipoManutencaoEnum.EXCLUSAO.getCodigo());
			agro.getAbaGraos().getAreaPropriaSelecionado().clear();
			// siteUtil.getMessages().getMsgExclusaoSucesso();
			this.listarAreaPropria();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarAreaArrendada() {
		try {
			QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
			GraosFibrasVO vo = agro.getAbaGraos();
			vo.getListaAreaArrendada().clear();
			vo.setSomaAreaTotalArrendada("");
			vo.setSomaAreaProdutivaArrendada("");
			vo.setSomaCustoArrendamento("");
			GraosFibrasVO retorno = this.questionarioAgronegocioService
					.listarAreaArrendada(RiccConstants.AREA_ARRENDADA,
							agro.getCodGrupo(), agro.getCodRelatorio());
			vo.setListaAreaArrendada(retorno.getListaAreaArrendada());

			vo.setSomaAreaTotalArrendada(retorno.getSomaAreaTotalArrendada());
			vo.setSomaAreaProdutivaArrendada(retorno
					.getSomaAreaProdutivaArrendada());
			vo.setSomaCustoArrendamento(retorno.getSomaCustoArrendamento());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (viewHelper.getModel().getAbaGraos().getListaAreaArrendada()
				.size() < 20) {
			viewHelper.getModel().getAbaGraos().getListaAreaArrendada()
					.add(new AreaArrendadaAgronegocioVO());
		}
		try {
			copiarAreaArrendada();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}

	private void copiarAreaArrendada() throws IllegalAccessException,
			InvocationTargetException {
		ArrayList<AreaArrendadaAgronegocioVO> listaCopia = new ArrayList<AreaArrendadaAgronegocioVO>();
		AreaArrendadaAgronegocioVO voCopia = null;
		for (AreaArrendadaAgronegocioVO itemTabela : this.viewHelper.getModel()
				.getAbaGraos().getListaAreaArrendada()) {
			voCopia = new AreaArrendadaAgronegocioVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if (siteUtil.isEmptyOrNull(voCopia.getDescricao())) {
				voCopia.setDescricao("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getAreaTotal())) {
				voCopia.setAreaTotal("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getAreaProdutiva())) {
				voCopia.setAreaProdutiva("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getCidade())) {
				voCopia.setCidade("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getCustoArrendamento())) {
				voCopia.setCustoArrendamento("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getInicioContrato())) {
				voCopia.setInicioContrato("");
			}
			if (siteUtil.isEmptyOrNull(voCopia.getFimContrato())) {
				voCopia.setFimContrato("");
			}
			listaCopia.add(voCopia);
		}
		viewHelper.getModel().getAbaGraos()
				.setCopiaListaAreaArrendada(listaCopia);
	}

	public void areaArrendadaTotal(AjaxBehaviorEvent e) {
		BigInteger somaAreaTotal = new BigInteger("0");
		BigInteger somaAreaProdutiva = new BigInteger("0");
		BigDecimal somaCustoArrendamento = new BigDecimal("0");
		BigDecimal qtdCustoArrendamento = new BigDecimal("0");

		for (AreaArrendadaAgronegocioVO itemTabela : viewHelper.getModel()
				.getAbaGraos().getListaAreaArrendada()) {
			if (siteUtil.isNotEmptyOrNull(itemTabela.getAreaTotal())) {
				somaAreaTotal = somaAreaTotal.add(new BigInteger(siteUtil
						.retirarMascaraNumericos(itemTabela.getAreaTotal())));
			}
			if (siteUtil.isNotEmptyOrNull(itemTabela.getAreaProdutiva())) {
				somaAreaProdutiva = somaAreaProdutiva.add(new BigInteger(
						siteUtil.retirarMascaraNumericos(itemTabela
								.getAreaProdutiva())));
			}
			if (siteUtil.isNotEmptyOrNull(itemTabela.getCustoArrendamento())) {
				somaCustoArrendamento = somaCustoArrendamento
						.add(new BigDecimal(siteUtil
								.retirarMascaraNumericos(itemTabela
										.getCustoArrendamento())));
				qtdCustoArrendamento = qtdCustoArrendamento.add(new BigDecimal(
						1));
			}
		}
		if (qtdCustoArrendamento.compareTo(new BigDecimal(0)) == 1) {
			somaCustoArrendamento = somaCustoArrendamento.divide(
					qtdCustoArrendamento).setScale(1);
		}
		getViewHelper().getModel().getAbaGraos()
				.setSomaAreaTotalArrendada(somaAreaTotal.toString());
		getViewHelper().getModel().getAbaGraos()
				.setSomaAreaProdutivaArrendada(somaAreaProdutiva.toString());
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.setSomaCustoArrendamento(
						somaCustoArrendamento.toString() + "0");
	}

	public void areaArrendada() {
		QuestionarioAgronegocioVO model = this.viewHelper.getModel();
		int contador = 0;
		for (AreaArrendadaAgronegocioVO itemTabela : this.viewHelper.getModel()
				.getAbaGraos().getListaAreaArrendada()) {
			if (!itemTabela.equals(viewHelper.getModel().getAbaGraos()
					.getCopiaListaAreaArrendada().get(contador))) {
				// INCLUSÃO
				if (itemTabela.getNumSequencial() == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getDescricao())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getAreaTotal())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getAreaProdutiva())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getCidade())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getCustoArrendamento())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getInicioContrato())
						&& siteUtil.isNotEmptyOrNull(itemTabela
								.getFimContrato())) {
					try {
						questionarioAgronegocioService.manutencaoAreaArrendada(
								model, itemTabela,
								TipoManutencaoEnum.INCLUSAO.getCodigo());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (itemTabela.getNumSequencial() > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getDescricao())
						&& siteUtil.isEmptyOrNull(itemTabela.getAreaTotal())
						&& siteUtil
								.isEmptyOrNull(itemTabela.getAreaProdutiva())
						&& siteUtil.isEmptyOrNull(itemTabela.getCidade())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getCustoArrendamento())
						&& siteUtil.isEmptyOrNull(itemTabela
								.getInicioContrato())
						&& siteUtil.isEmptyOrNull(itemTabela.getFimContrato())) {
					try {
						questionarioAgronegocioService.manutencaoAreaArrendada(
								model, itemTabela,
								TipoManutencaoEnum.EXCLUSAO.getCodigo());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getModel().getAbaGraos().getCopiaListaAreaArrendada()
						.get(contador).getNumSequencial()) {
					try {
						questionarioAgronegocioService.manutencaoAreaArrendada(
								model, itemTabela,
								TipoManutencaoEnum.INCLUSAO.getCodigo());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador++;
		}
		listarAreaArrendada();
	}

	public void excluirAreaArrendada() {
		QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
		AreaArrendadaAgronegocioVO areaVo = agro.getAbaGraos()
				.getAreaArrendadaSelecionado().get(Numeros.ZERO);
		try {
			this.questionarioAgronegocioService.manutencaoAreaArrendada(agro,
					areaVo, TipoManutencaoEnum.EXCLUSAO.getCodigo());
			agro.getAbaGraos().getAreaArrendadaSelecionado().clear();
			this.listarAreaArrendada();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void manutencaoGraosFibras() throws RiccException {

		List<List<GraoFibraAux>> listaGraoFibra = montarListaGraosFibras();

		for (int i = 0; i < listaGraoFibra.size(); i++) {
			List<GraoFibraAux> colunas = listaGraoFibra.get(i);
			questionarioAgronegocioService.manutencaoGraosFibra(viewHelper
					.getModel(), colunas, colunas.get(0).getCodTpoRamo());

		}

	}

	private List<List<GraoFibraAux>> montarListaGraosFibras() {
		List<List<GraoFibraAux>> listaGraosFibras = new ArrayList<List<GraoFibraAux>>();

		List<GraoFibraAux> listaAlgodaoMap = new ArrayList<GraoFibraAux>();

		FibrasVO algodao = getViewHelper().getModel().getAbaGraos()
				.getFibraAlgodao();

		algodao.getAnoSafra1().setCodTipoRamo(COD_ALGODAO);
		algodao.getAnoSafra2().setCodTipoRamo(COD_ALGODAO);
		algodao.getAnoSafra3().setCodTipoRamo(COD_ALGODAO);
		algodao.getAnoSafraProjetado().setCodTipoRamo(COD_ALGODAO);

		listaAlgodaoMap.add(new GraoFibraAux().mapearEntradaFibra(algodao
				.getAnoSafra1()));
		listaAlgodaoMap.add(new GraoFibraAux().mapearEntradaFibra(algodao
				.getAnoSafra2()));
		listaAlgodaoMap.add(new GraoFibraAux().mapearEntradaFibra(algodao
				.getAnoSafra3()));
		listaAlgodaoMap.add(new GraoFibraAux().mapearEntradaFibra(algodao
				.getAnoSafraProjetado()));

		listaGraosFibras.add(listaAlgodaoMap);

		TipoGraoVO soja = getViewHelper().getModel().getAbaGraos()
				.getGraoSoja();
		List<GraoFibraAux> listaSojaMap = new ArrayList<GraoFibraAux>();

		soja.getAnoSafra1().setCodigoTipoRamo(COD_SOJA);
		soja.getAnoSafra1().setPesoSacaSementes(soja.getPesoSacaSementes());
		soja.getAnoSafra1().setPesoSacaMediaSemente(
				soja.getPesoSacaMediaSemente());
		soja.getAnoSafra2().setCodigoTipoRamo(COD_SOJA);
		soja.getAnoSafra2().setPesoSacaSementes(soja.getPesoSacaSementes());
		soja.getAnoSafra2().setPesoSacaMediaSemente(
				soja.getPesoSacaMediaSemente());
		soja.getAnoSafra3().setCodigoTipoRamo(COD_SOJA);
		soja.getAnoSafra3().setPesoSacaSementes(soja.getPesoSacaSementes());
		soja.getAnoSafra3().setPesoSacaMediaSemente(
				soja.getPesoSacaMediaSemente());
		soja.getAnoSafraProjetado().setCodigoTipoRamo(COD_SOJA);
		soja.getAnoSafraProjetado().setPesoSacaSementes(
				soja.getPesoSacaSementes());
		soja.getAnoSafraProjetado().setPesoSacaMediaSemente(
				soja.getPesoSacaMediaSemente());

		listaSojaMap.add(new GraoFibraAux().mapearEntradaGrao(soja
				.getAnoSafra1()));
		listaSojaMap.add(new GraoFibraAux().mapearEntradaGrao(soja
				.getAnoSafra2()));
		listaSojaMap.add(new GraoFibraAux().mapearEntradaGrao(soja
				.getAnoSafra3()));
		listaSojaMap.add(new GraoFibraAux().mapearEntradaGrao(soja
				.getAnoSafraProjetado()));

		listaGraosFibras.add(listaSojaMap);

		TipoGraoVO milho = getViewHelper().getModel().getAbaGraos()
				.getGraoMilho();

		List<GraoFibraAux> listaMilhoMap = new ArrayList<GraoFibraAux>();

		milho.getAnoSafra1().setCodigoTipoRamo(COD_MILHO);
		milho.getAnoSafra1().setPesoSacaSementes(milho.getPesoSacaSementes());
		milho.getAnoSafra1().setPesoSacaMediaSemente(
				milho.getPesoSacaMediaSemente());
		milho.getAnoSafra2().setCodigoTipoRamo(COD_MILHO);
		milho.getAnoSafra2().setPesoSacaSementes(milho.getPesoSacaSementes());
		milho.getAnoSafra2().setPesoSacaMediaSemente(
				milho.getPesoSacaMediaSemente());
		milho.getAnoSafra3().setCodigoTipoRamo(COD_MILHO);
		milho.getAnoSafra3().setPesoSacaSementes(milho.getPesoSacaSementes());
		milho.getAnoSafra3().setPesoSacaMediaSemente(
				milho.getPesoSacaMediaSemente());
		milho.getAnoSafraProjetado().setCodigoTipoRamo(COD_MILHO);
		milho.getAnoSafraProjetado().setPesoSacaSementes(
				milho.getPesoSacaSementes());
		milho.getAnoSafraProjetado().setPesoSacaMediaSemente(
				milho.getPesoSacaMediaSemente());

		listaMilhoMap.add(new GraoFibraAux().mapearEntradaGrao(milho
				.getAnoSafra1()));
		listaMilhoMap.add(new GraoFibraAux().mapearEntradaGrao(milho
				.getAnoSafra2()));
		listaMilhoMap.add(new GraoFibraAux().mapearEntradaGrao(milho
				.getAnoSafra3()));
		listaMilhoMap.add(new GraoFibraAux().mapearEntradaGrao(milho
				.getAnoSafraProjetado()));

		listaGraosFibras.add(listaMilhoMap);

		return listaGraosFibras;
	}

	public String voltar() {
		return paginaAnterior;
	}

	private void consultarUsinas() {
		try {
			List<ObjectUsinas> listaRetorno = questionarioAgronegocioService
					.consultaUsinas(viewHelper.getModel());
			// TODO ARRUMAR INDEX OUT OF BOUNDS DO METODO SUBSTRING
			for (ObjectUsinas usina : listaRetorno) {
				switch (usina.numSequencialUsina) {
				case 1:
					viewHelper.getModel().getAbaUsinas()
							.setAnoAreaCorte1(usina.areaCorte);
					try {
						viewHelper
								.getModel()
								.getAbaUsinas()
								.getAnoAreaCorte1()
								.setIdadeMediaCanavial(
										usina.areaCorte
												.getIdadeMediaCanavial()
												.substring(
														0,
														usina.areaCorte
																.getIdadeMediaCanavial()
																.length() - 1));
					} catch (Exception e) {
						// TODO: handle exception
					}
					viewHelper.getModel().getAbaUsinas()
							.setAnoCogeracaoEnergia1(usina.cogeracaoEnergias);
					viewHelper.getModel().getAbaUsinas()
							.setAnoMoagem1(usina.moagem);
					viewHelper.getModel().getAbaUsinas()
							.setAnoProdutividade1(usina.produtividade);
					viewHelper.getModel().getAbaUsinas()
							.setAnoTerra1(usina.terra);
					break;
				case 2:
					viewHelper.getModel().getAbaUsinas()
							.setAnoAreaCorte2(usina.areaCorte);
					try {
						viewHelper
								.getModel()
								.getAbaUsinas()
								.getAnoAreaCorte2()
								.setIdadeMediaCanavial(
										usina.areaCorte
												.getIdadeMediaCanavial()
												.substring(
														0,
														usina.areaCorte
																.getIdadeMediaCanavial()
																.length() - 1));
					} catch (Exception e) {
						// TODO: handle exception
					}
					viewHelper.getModel().getAbaUsinas()
							.setAnoCogeracaoEnergia2(usina.cogeracaoEnergias);
					viewHelper.getModel().getAbaUsinas()
							.setAnoMoagem2(usina.moagem);
					viewHelper.getModel().getAbaUsinas()
							.setAnoProdutividade2(usina.produtividade);
					viewHelper.getModel().getAbaUsinas()
							.setAnoTerra2(usina.terra);
					break;
				case 3:
					viewHelper.getModel().getAbaUsinas()
							.setAnoAreaCorte3(usina.areaCorte);
					try {
						viewHelper
								.getModel()
								.getAbaUsinas()
								.getAnoAreaCorte3()
								.setIdadeMediaCanavial(
										usina.areaCorte
												.getIdadeMediaCanavial()
												.substring(
														0,
														usina.areaCorte
																.getIdadeMediaCanavial()
																.length() - 1));
					} catch (Exception e) {
						// TODO: handle exception
					}
					viewHelper.getModel().getAbaUsinas()
							.setAnoCogeracaoEnergia3(usina.cogeracaoEnergias);
					viewHelper.getModel().getAbaUsinas()
							.setAnoMoagem3(usina.moagem);
					viewHelper.getModel().getAbaUsinas()
							.setAnoProdutividade3(usina.produtividade);
					viewHelper.getModel().getAbaUsinas()
							.setAnoTerra3(usina.terra);
					break;
				case 4:
					viewHelper.getModel().getAbaUsinas()
							.setAnoAreaCorteProjetado(usina.areaCorte);
					try {
						viewHelper
								.getModel()
								.getAbaUsinas()
								.getAnoAreaCorteProjetado()
								.setIdadeMediaCanavial(
										usina.areaCorte
												.getIdadeMediaCanavial()
												.substring(
														0,
														usina.areaCorte
																.getIdadeMediaCanavial()
																.length() - 1));
					} catch (Exception e) {
						// TODO: handle exception
					}
					viewHelper
							.getModel()
							.getAbaUsinas()
							.setAnoCogeracaoEnergiaProjetado(
									usina.cogeracaoEnergias);
					viewHelper.getModel().getAbaUsinas()
							.setAnoMoagemProjetado(usina.moagem);
					viewHelper.getModel().getAbaUsinas()
							.setAnoProdutividadeProjetado(usina.produtividade);
					viewHelper.getModel().getAbaUsinas()
							.setAnoTerraProjetado(usina.terra);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void manutencaoUsinas() throws RiccException {

		UsinasVO usinas = viewHelper.getModel().getAbaUsinas();

		List<ObjectUsinas> listaUsinas = new ArrayList<QuestionarioAgronegocioBean.ObjectUsinas>();

		ObjectUsinas ano1 = this.new ObjectUsinas(usinas.getAnoAreaCorte1(),
				usinas.getAnoCogeracaoEnergia1(), usinas.getAnoMoagem1(),
				usinas.getAnoProdutividade1(), usinas.getAnoTerra1(), 1);
		listaUsinas.add(ano1);

		ObjectUsinas ano2 = this.new ObjectUsinas(usinas.getAnoAreaCorte2(),
				usinas.getAnoCogeracaoEnergia2(), usinas.getAnoMoagem2(),
				usinas.getAnoProdutividade2(), usinas.getAnoTerra2(), 2);
		listaUsinas.add(ano2);

		ObjectUsinas ano3 = this.new ObjectUsinas(usinas.getAnoAreaCorte3(),
				usinas.getAnoCogeracaoEnergia3(), usinas.getAnoMoagem3(),
				usinas.getAnoProdutividade3(), usinas.getAnoTerra3(), 3);
		listaUsinas.add(ano3);

		ObjectUsinas anoProjetado = this.new ObjectUsinas(
				usinas.getAnoAreaCorteProjetado(),
				usinas.getAnoCogeracaoEnergiaProjetado(),
				usinas.getAnoMoagemProjetado(),
				usinas.getAnoProdutividadeProjetado(),
				usinas.getAnoTerraProjetado(), 4);
		listaUsinas.add(anoProjetado);

		if (siteUtil.valueToMainframeBigDecimal(
				getViewHelper().getModel().getAbaUsinas().getAnoMoagem1()
						.getTotalMoagem()).compareTo(new BigDecimal(999.99)) > 0
				|| siteUtil.valueToMainframeBigDecimal(
						getViewHelper().getModel().getAbaUsinas()
								.getAnoMoagem2().getTotalMoagem()).compareTo(
						new BigDecimal(999.99)) > 0
				|| siteUtil.valueToMainframeBigDecimal(
						getViewHelper().getModel().getAbaUsinas()
								.getAnoMoagem3().getTotalMoagem()).compareTo(
						new BigDecimal(999.99)) > 0
				|| siteUtil.valueToMainframeBigDecimal(
						getViewHelper().getModel().getAbaUsinas()
								.getAnoMoagemProjetado().getTotalMoagem())
						.compareTo(new BigDecimal(999.99)) > 0) {
			throw new IllegalArgumentException(
					"Porcentagem Moagem Superior a 999,99%");
		} else {
			questionarioAgronegocioService.manutencaoUsinas(
					viewHelper.getModel(), listaUsinas);
		}

	}

	private void consultarProducaoUsinas() {

		try {
			List<ObjectUsinas> listaRetorno = questionarioAgronegocioService
					.consultaProducaoUsinas(viewHelper.getModel());

			int sequencial = 1;

			for (ObjectUsinas usina : listaRetorno) {
				switch (sequencial) {
				case 1:
					viewHelper.getModel().getAbaUsinas()
							.setAnoProducao1(usina.producao);
					break;
				case 2:
					viewHelper.getModel().getAbaUsinas()
							.setAnoProducao2(usina.producao);
					break;
				case 3:
					viewHelper.getModel().getAbaUsinas()
							.setAnoProducao3(usina.producao);
					break;
				case 4:
					viewHelper.getModel().getAbaUsinas()
							.setAnoProducaoProjetado(usina.producao);
					break;
				default:
					break;
				}
				sequencial++;
			}
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	private void manutencaoProducaoUsinas() throws RiccException {

		UsinasVO usinas = viewHelper.getModel().getAbaUsinas();

		List<ObjectUsinas> listaUsinas = new ArrayList<QuestionarioAgronegocioBean.ObjectUsinas>();

		ObjectUsinas ano1 = this.new ObjectUsinas(usinas.getAnoProducao1());

		ano1.getProducao().setAno(
				viewHelper.getModel().getAbaUsinas().getAnoMoagem1().getAno());
		listaUsinas.add(ano1);

		ObjectUsinas ano2 = this.new ObjectUsinas(usinas.getAnoProducao2());
		ano2.getProducao().setAno(
				viewHelper.getModel().getAbaUsinas().getAnoMoagem2().getAno());
		listaUsinas.add(ano2);

		ObjectUsinas ano3 = this.new ObjectUsinas(usinas.getAnoProducao3());
		ano3.getProducao().setAno(
				viewHelper.getModel().getAbaUsinas().getAnoMoagem3().getAno());
		listaUsinas.add(ano3);

		ObjectUsinas anoProjetado = this.new ObjectUsinas(
				usinas.getAnoProducaoProjetado());
		anoProjetado.getProducao().setAno(
				viewHelper.getModel().getAbaUsinas().getAnoMoagemProjetado()
						.getAno());
		listaUsinas.add(anoProjetado);

		questionarioAgronegocioService.manutencaoProducaoUsinas(
				viewHelper.getModel(), listaUsinas);

	}

	/**
	 * @description
	 * @name selecionarAba
	 * @see QuestionarioAgronegocioBean
	 * @param e
	 * @return void
	 */
	public void selecionarAba(String id) {
		if (id.equals("GraosFibras")) {
			getViewHelper().setRenderAbaGraosFibras(Boolean.TRUE);
			getViewHelper().setRenderAbaUsinas(Boolean.FALSE);
			getViewHelper().getModel().getAbaGraos()
					.setAreaArrendada(new AreaArrendadaAgronegocioVO());
			getViewHelper().getModel().getAbaGraos()
					.setAreaPropria(new AreaPropriaAgronegocioVO());
		} else if (id.equals("Usinas")) {
			getViewHelper().setRenderAbaGraosFibras(Boolean.FALSE);
			getViewHelper().setRenderAbaUsinas(Boolean.TRUE);
		}
	}

	/************************************************************/
	/*															*/
	/* Aba "Produtor Graos fibras" */
	/*															*/
	/************************************************************/

	public void calcularAnoUsinas1(AjaxBehaviorEvent e) {
		UsinasVO modelUsinas = viewHelper.getModel().getAbaUsinas();
		String ano = modelUsinas.getAnoMoagem1().getAno();
		modelUsinas.getAnoTerra1().setAno(ano);
		modelUsinas.getAnoAreaCorte1().setAno(ano);
		modelUsinas.getAnoProducao1().setAno(ano);
		modelUsinas.getAnoProdutividade1().setAno(ano);
		modelUsinas.getAnoCogeracaoEnergia1().setAno(ano);
	}

	public void calcularAnoUsinas2(AjaxBehaviorEvent e) {
		UsinasVO modelUsinas = viewHelper.getModel().getAbaUsinas();
		String ano = modelUsinas.getAnoMoagem2().getAno();
		modelUsinas.getAnoTerra2().setAno(ano);
		modelUsinas.getAnoAreaCorte2().setAno(ano);
		modelUsinas.getAnoProducao2().setAno(ano);
		modelUsinas.getAnoProdutividade2().setAno(ano);
		modelUsinas.getAnoCogeracaoEnergia2().setAno(ano);
	}

	public void calcularAnoUsinas3(AjaxBehaviorEvent e) {
		UsinasVO modelUsinas = viewHelper.getModel().getAbaUsinas();
		String ano = modelUsinas.getAnoMoagem3().getAno();
		modelUsinas.getAnoTerra3().setAno(ano);
		modelUsinas.getAnoAreaCorte3().setAno(ano);
		modelUsinas.getAnoProducao3().setAno(ano);
		modelUsinas.getAnoProdutividade3().setAno(ano);
		modelUsinas.getAnoCogeracaoEnergia3().setAno(ano);
	}

	public void calcularAnoUsinas4(AjaxBehaviorEvent e) {
		UsinasVO modelUsinas = viewHelper.getModel().getAbaUsinas();
		String ano = modelUsinas.getAnoMoagemProjetado().getAno();
		modelUsinas.getAnoTerraProjetado().setAno(ano);
		modelUsinas.getAnoAreaCorteProjetado().setAno(ano);
		modelUsinas.getAnoProducaoProjetado().setAno(ano);
		modelUsinas.getAnoProdutividadeProjetado().setAno(ano);
		modelUsinas.getAnoCogeracaoEnergiaProjetado().setAno(ano);
	}

	public void graoAreaPlantada1Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra1()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra1()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoSoja()
				.getAnoSafra1()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void graoAreaPlantada2Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra2()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra2()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoSoja()
				.getAnoSafra2()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void graoAreaPlantada3Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra3()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra3()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoSoja()
				.getAnoSafra3()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void graoAreaPlantadaProjetadoTotal(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafraProjetado()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafraProjetado()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoSoja()
				.getAnoSafraProjetado()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void milhoAreaPlantada1Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra1()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra1()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoMilho()
				.getAnoSafra1()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void milhoAreaPlantada2Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra2()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra2()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoMilho()
				.getAnoSafra2()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void milhoAreaPlantada3Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra3()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra3()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoMilho()
				.getAnoSafra3()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void milhoAreaPlantadaProjetadoTotal(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafraProjetado()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafraProjetado()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoMilho()
				.getAnoSafraProjetado()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	// Produção total realizada/projetada (saca de 60kg):
	public void graoProducaoTotal1(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra1()
						.getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra1()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoSoja()
				.getAnoSafra1()
				.setProducaoTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void graoProducaoTotal2(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra2()
						.getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra2()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoSoja()
				.getAnoSafra2()
				.setProducaoTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void graoProducaoTotal3(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra3()
						.getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafra3()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoSoja()
				.getAnoSafra3()
				.setProducaoTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void graoProducaoTotalProjetado(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafraProjetado()
						.getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoSoja().getAnoSafraProjetado()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoSoja()
				.getAnoSafraProjetado()
				.setProducaoTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void milhoProducaoTotal1(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra1()
						.getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra1()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoMilho()
				.getAnoSafra1()
				.setProducaoTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void milhoProducaoTotal2(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra2()
						.getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra2()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoMilho()
				.getAnoSafra2()
				.setProducaoTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void milhoProducaoTotal3(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra3()
						.getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafra3()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoMilho()
				.getAnoSafra3()
				.setProducaoTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void milhoProducaoTotalProjetado(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafraProjetado()
						.getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getGraoMilho().getAnoSafraProjetado()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getGraoMilho()
				.getAnoSafraProjetado()
				.setProducaoTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	// Fibras
	// Area Plantada Total (hectares):
	public void calcularValoresSafra1(AjaxBehaviorEvent e) {
		try {
			// Area Propria
			BigDecimal areaPropria = new BigDecimal(
					siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
							.getAbaGraos().getFibraAlgodao().getAnoSafra1()
							.getAreaPropria().replace(".", "")));
			// area Arrendada
			BigDecimal areaArrendada = new BigDecimal(
					siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
							.getAbaGraos().getFibraAlgodao().getAnoSafra1()
							.getAreaArrendada().replace(".", "")));

			// Total Area Plantada
			BigDecimal totalAreaPlantada = areaPropria.add(areaArrendada);
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.getAnoSafra1()
					.setAreaTotal(
							totalAreaPlantada.toPlainString().replace(".", ""));

			// Pluma em arroba/hectares
			BigDecimal plumaHectare = siteUtil
					.valueToMainframeBigDecimal(getViewHelper().getModel()
							.getAbaGraos().getFibraAlgodao().getAnoSafra1()
							.getPlumaHectare());

			// Caroco em arroba/hectares
			BigDecimal carocoHectare = siteUtil
					.valueToMainframeBigDecimal(getViewHelper().getModel()
							.getAbaGraos().getFibraAlgodao().getAnoSafra1()
							.getCarocoHectare());

			// Fibrilha em arroba/hectares
			BigDecimal fibrilhaHectare = siteUtil
					.valueToMainframeBigDecimal(getViewHelper().getModel()
							.getAbaGraos().getFibraAlgodao().getAnoSafra1()
							.getFibrilhaHectare());

			// Total realizada / Projetada
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.getAnoSafra1()
					.setTotalHectare(
							new BigDecimal(0).add(plumaHectare)
									.add(carocoHectare).add(fibrilhaHectare)
									.toPlainString());

			// pluma arroba
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.getAnoSafra1()
					.setPlumaProducao(
							totalAreaPlantada.multiply(plumaHectare)
									.setScale(0, RoundingMode.HALF_EVEN)
									.toPlainString());

			// Caroco arroba
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.getAnoSafra1()
					.setCarocoProducao(
							totalAreaPlantada.multiply(carocoHectare)
									.setScale(0, RoundingMode.HALF_EVEN)
									.toPlainString());

			// Fibrilha arroba
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.getAnoSafra1()
					.setFibrilhaProducao(
							totalAreaPlantada.multiply(fibrilhaHectare)
									.setScale(0, RoundingMode.HALF_EVEN)
									.toPlainString());

			// Total producao
			BigDecimal pluma = new BigDecimal(getViewHelper().getModel()
					.getAbaGraos().getFibraAlgodao().getAnoSafra1()
					.getPlumaProducao());
			BigDecimal caroco = new BigDecimal(getViewHelper().getModel()
					.getAbaGraos().getFibraAlgodao().getAnoSafra1()
					.getCarocoProducao());
			BigDecimal fibrilha = new BigDecimal(getViewHelper().getModel()
					.getAbaGraos().getFibraAlgodao().getAnoSafra1()
					.getFibrilhaProducao());
			getViewHelper()
					.getModel()
					.getAbaGraos()
					.getFibraAlgodao()
					.getAnoSafra1()
					.setTotalProducao(
							new BigDecimal(0).add(pluma).add(caroco)
									.add(fibrilha).toPlainString());
		} catch (Exception e1) {
			siteUtil.log(e1);
		}
	}

	// Fibras
	// Area Plantada Total (hectares):
	public void calcularValoresSafra2(AjaxBehaviorEvent e) {
		// Area Propria
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getAreaPropria()));
		// area Arrendada
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getAreaArrendada()));

		// Total Area Plantada
		BigDecimal totalAreaPlantada = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra2().setAreaTotal(totalAreaPlantada.toPlainString());

		// Pluma em arroba/hectares
		BigDecimal plumaHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getPlumaHectare());

		// Caroco em arroba/hectares
		BigDecimal carocoHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getCarocoHectare());

		// Fibrilha em arroba/hectares
		BigDecimal fibrilhaHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getFibrilhaHectare());

		// Total realizada / Projetada
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra2()
				.setTotalHectare(
						new BigDecimal(0).add(plumaHectare).add(carocoHectare)
								.add(fibrilhaHectare).toPlainString());

		// pluma arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra2()
				.setPlumaProducao(
						totalAreaPlantada.multiply(plumaHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Caroco arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra2()
				.setCarocoProducao(
						totalAreaPlantada.multiply(carocoHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Fibrilha arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra2()
				.setFibrilhaProducao(
						totalAreaPlantada.multiply(fibrilhaHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Total producao
		BigDecimal pluma = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafra2()
				.getPlumaProducao());
		BigDecimal caroco = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafra2()
				.getCarocoProducao());
		BigDecimal fibrilha = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafra2()
				.getFibrilhaProducao());
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra2()
				.setTotalProducao(
						new BigDecimal(0).add(pluma).add(caroco).add(fibrilha)
								.toPlainString());
	}

	// Fibras
	// Area Plantada Total (hectares):
	public void calcularValoresSafra3(AjaxBehaviorEvent e) {
		// Area Propria
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getAreaPropria()));
		// area Arrendada
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getAreaArrendada()));

		// Total Area Plantada
		BigDecimal totalAreaPlantada = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra3().setAreaTotal(totalAreaPlantada.toPlainString());

		// Pluma em arroba/hectares
		BigDecimal plumaHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getPlumaHectare());

		// Caroco em arroba/hectares
		BigDecimal carocoHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getCarocoHectare());

		// Fibrilha em arroba/hectares
		BigDecimal fibrilhaHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getFibrilhaHectare());

		// Total realizada / Projetada
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra3()
				.setTotalHectare(
						new BigDecimal(0).add(plumaHectare).add(carocoHectare)
								.add(fibrilhaHectare).toPlainString());

		// pluma arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra3()
				.setPlumaProducao(
						totalAreaPlantada.multiply(plumaHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Caroco arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra3()
				.setCarocoProducao(
						totalAreaPlantada.multiply(carocoHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Fibrilha arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra3()
				.setFibrilhaProducao(
						totalAreaPlantada.multiply(fibrilhaHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Total producao
		BigDecimal pluma = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getPlumaProducao());
		BigDecimal caroco = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getCarocoProducao());
		BigDecimal fibrilha = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getFibrilhaProducao());
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra3()
				.setTotalProducao(
						new BigDecimal(0).add(pluma).add(caroco).add(fibrilha)
								.toPlainString());
	}

	// Fibras
	// Area Plantada Total (hectares):
	public void calcularValoresSafra4(AjaxBehaviorEvent e) {
		// Area Propria
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getAreaPropria()));
		// area Arrendada
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getAreaArrendada()));

		// Total Area Plantada
		BigDecimal totalAreaPlantada = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafraProjetado()
				.setAreaTotal(totalAreaPlantada.toPlainString());

		// Pluma em arroba/hectares
		BigDecimal plumaHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getPlumaHectare());

		// Caroco em arroba/hectares
		BigDecimal carocoHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getCarocoHectare());

		// Fibrilha em arroba/hectares
		BigDecimal fibrilhaHectare = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getFibrilhaHectare());

		// Total realizada / Projetada
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafraProjetado()
				.setTotalHectare(
						new BigDecimal(0).add(plumaHectare).add(carocoHectare)
								.add(fibrilhaHectare).toPlainString());

		// pluma arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafraProjetado()
				.setPlumaProducao(
						totalAreaPlantada.multiply(plumaHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Caroco arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafraProjetado()
				.setCarocoProducao(
						totalAreaPlantada.multiply(carocoHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Fibrilha arroba
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafraProjetado()
				.setFibrilhaProducao(
						totalAreaPlantada.multiply(fibrilhaHectare)
								.setScale(0, RoundingMode.HALF_EVEN)
								.toPlainString());

		// Total producao
		BigDecimal pluma = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
				.getPlumaProducao());
		BigDecimal caroco = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
				.getCarocoProducao());
		BigDecimal fibrilha = new BigDecimal(getViewHelper().getModel()
				.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
				.getFibrilhaProducao());
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafraProjetado()
				.setTotalProducao(
						new BigDecimal(0).add(pluma).add(caroco).add(fibrilha)
								.toPlainString());
	}

	public void areaPlantada2Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra2()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void areaPlantada3Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra3()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void areaPlantadaProjetadoTotal(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafraProjetado()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	// Produtividade total realizada/projetada @/hectare
	public void produtividade1TotalHectare(AjaxBehaviorEvent e) {
		BigDecimal pluma = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getPlumaHectare()));
		BigDecimal caroco = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getCarocoHectare()));
		BigDecimal fibrilha = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getFibrilhaHectare()));

		BigDecimal calculo = pluma.add(caroco.add(fibrilha));
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra1()
				.setTotalHectare(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void produtividade2TotalHectare(AjaxBehaviorEvent e) {
		BigDecimal pluma = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getPlumaHectare()));
		BigDecimal caroco = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getCarocoHectare()));
		BigDecimal fibrilha = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getFibrilhaHectare()));

		BigDecimal calculo = pluma.add(caroco.add(fibrilha));
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra2()
				.setTotalHectare(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void produtividade3TotalHectare(AjaxBehaviorEvent e) {
		BigDecimal pluma = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getPlumaHectare()));
		BigDecimal caroco = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getCarocoHectare()));
		BigDecimal fibrilha = new BigDecimal(
				siteUtil.retirarMascaraNumericos((getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getFibrilhaHectare())));

		BigDecimal calculo = pluma.add(caroco.add(fibrilha));
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra3()
				.setTotalHectare(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void produtividadeProjetadoTotalHectare(AjaxBehaviorEvent e) {
		BigDecimal pluma = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getPlumaHectare()));
		BigDecimal caroco = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getCarocoHectare()));
		BigDecimal fibrilha = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getFibrilhaHectare()));

		BigDecimal calculo = pluma.add(caroco.add(fibrilha));
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafraProjetado()
				.setTotalHectare(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	// Produçao total realizada/projetada (@) - Pluma
	public void calculo1Pluma(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getAreaArrendada()));

		BigDecimal total = areaPropria.add(areaArrendada);

		BigDecimal pluma = siteUtil.valueToMainframeBigDecimal(getViewHelper()
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1()
				.getPlumaHectare());
		BigDecimal calculo = pluma.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra1().setPlumaProducao(calculo.toString());

	}

	public void calculo2Pluma(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2()
				.getAreaTotal());
		BigDecimal pluma = siteUtil.valueToMainframeBigDecimal(getViewHelper()
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2()
				.getPlumaHectare());
		BigDecimal calculo = pluma.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra2().setPlumaProducao(calculo.toString());

	}

	public void calculo3Pluma(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getAreaTotal());
		BigDecimal pluma = siteUtil.valueToMainframeBigDecimal(getViewHelper()
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getPlumaHectare());
		BigDecimal calculo = pluma.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra3().setPlumaProducao(calculo.toString());

	}

	public void calculo4Pluma(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafraProjetado().getAreaTotal());
		BigDecimal pluma = siteUtil.valueToMainframeBigDecimal(getViewHelper()
				.getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafraProjetado().getPlumaHectare());
		BigDecimal calculo = pluma.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafraProjetado().setPlumaProducao(calculo.toString());

	}

	// Produçao total realizada/projetada (@) - Caroco
	public void calculo1Caroco(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1()
				.getAreaTotal());
		BigDecimal caroco = siteUtil.valueToMainframeBigDecimal(getViewHelper()
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1()
				.getCarocoHectare());
		BigDecimal calculo = caroco.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra1().setCarocoProducao(calculo.toString());

	}

	public void calculo2Caroco(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2()
				.getAreaTotal());
		BigDecimal caroco = siteUtil.valueToMainframeBigDecimal(getViewHelper()
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2()
				.getCarocoHectare());
		BigDecimal calculo = caroco.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra2().setCarocoProducao(calculo.toString());

	}

	public void calculo3Caroco(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getAreaTotal());
		BigDecimal caroco = siteUtil.valueToMainframeBigDecimal(getViewHelper()
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getCarocoHectare());
		BigDecimal calculo = caroco.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra3().setCarocoProducao(calculo.toString());

	}

	public void calculo4Caroco(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getAreaTotal());
		BigDecimal caroco = siteUtil.valueToMainframeBigDecimal(getViewHelper()
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getCarocoHectare());
		BigDecimal calculo = caroco.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra3().setCarocoProducao(calculo.toString());

	}

	// Produçao total realizada/projetada (@) - Fibrilha

	public void calculo1Fibrilha(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1()
				.getAreaTotal());
		BigDecimal fibrilha = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getFibrilhaHectare());
		BigDecimal calculo = fibrilha.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra1().setFibrilhaProducao(calculo.toString());

	}

	public void calculo2Fibrilha(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2()
				.getAreaTotal());
		BigDecimal fibrilha = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getCarocoHectare());
		BigDecimal calculo = fibrilha.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra2().setFibrilhaProducao(calculo.toString());

	}

	public void calculo3Fibrilha(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getAreaTotal());
		BigDecimal fibrilha = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getCarocoHectare());
		BigDecimal calculo = fibrilha.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra3().setFibrilhaProducao(calculo.toString());

	}

	public void calculo4Fibrilha(AjaxBehaviorEvent e) {

		BigDecimal total = siteUtil.valueToMainframeBigDecimal(viewHelper
				.getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3()
				.getAreaTotal());
		BigDecimal fibrilha = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getCarocoHectare());
		BigDecimal calculo = fibrilha.multiply(total);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao()
				.getAnoSafra3().setFibrilhaProducao(calculo.toString());

	}

	// Produçao total realizada/projetada (@)
	public void producao1Total(AjaxBehaviorEvent e) {
		BigDecimal pluma = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getPlumaProducao()));
		BigDecimal caroco = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getCarocoProducao()));
		BigDecimal fibrilha = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra1()
						.getFibrilhaProducao()));

		BigDecimal calculo = pluma.add(caroco.add(fibrilha));
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra1()
				.setTotalProducao(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void producao2Total(AjaxBehaviorEvent e) {
		BigDecimal pluma = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getPlumaProducao()));
		BigDecimal caroco = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getCarocoProducao()));
		BigDecimal fibrilha = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra2()
						.getFibrilhaProducao()));

		BigDecimal calculo = pluma.add(caroco.add(fibrilha));
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra2()
				.setTotalProducao(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void producao3Total(AjaxBehaviorEvent e) {
		BigDecimal pluma = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getPlumaProducao()));
		BigDecimal caroco = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getCarocoProducao()));
		BigDecimal fibrilha = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafra3()
						.getFibrilhaProducao()));

		BigDecimal calculo = pluma.add(caroco.add(fibrilha));
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafra3()
				.setTotalProducao(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void producaoProjetadoTotal(AjaxBehaviorEvent e) {
		BigDecimal pluma = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getPlumaProducao()));
		BigDecimal caroco = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getCarocoProducao()));
		BigDecimal fibrilha = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaGraos().getFibraAlgodao().getAnoSafraProjetado()
						.getFibrilhaProducao()));

		BigDecimal calculo = pluma.add(caroco.add(fibrilha));
		getViewHelper()
				.getModel()
				.getAbaGraos()
				.getFibraAlgodao()
				.getAnoSafraProjetado()
				.setTotalProducao(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	/************************************************************/
	/*															*/
	/* Aba "usinas de A&A" */
	/*															*/
	/************************************************************/

	// Moagem (k tons)
	public void moagemTotal1(AjaxBehaviorEvent e) {
		BigDecimal canaPropriaAreaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem1().getCanaAreaPropria());
		BigDecimal canaPropriaAreaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem1().getCanaAreaArrendada());
		BigDecimal canaTerceiros = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem1().getCanaTerceiros());

		BigDecimal calculo = canaPropriaAreaPropria
				.add(canaPropriaAreaArrendada.add(canaTerceiros));

		getViewHelper()
				.getModel()
				.getAbaUsinas()
				.getAnoMoagem1()
				.setTotalMoagem(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void moagemTotal2(AjaxBehaviorEvent e) {
		BigDecimal canaPropriaAreaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem2().getCanaAreaPropria());
		BigDecimal canaPropriaAreaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem2().getCanaAreaArrendada());
		BigDecimal canaTerceiros = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem2().getCanaTerceiros());

		BigDecimal calculo = canaPropriaAreaPropria
				.add(canaPropriaAreaArrendada.add(canaTerceiros));
		getViewHelper()
				.getModel()
				.getAbaUsinas()
				.getAnoMoagem2()
				.setTotalMoagem(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());
	}

	public void moagemTotal3(AjaxBehaviorEvent e) {
		BigDecimal canaPropriaAreaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem3().getCanaAreaPropria());
		BigDecimal canaPropriaAreaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem3().getCanaAreaArrendada());
		BigDecimal canaTerceiros = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem3().getCanaTerceiros());

		BigDecimal calculo = canaPropriaAreaPropria
				.add(canaPropriaAreaArrendada.add(canaTerceiros));
		getViewHelper()
				.getModel()
				.getAbaUsinas()
				.getAnoMoagem3()
				.setTotalMoagem(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());
	}

	public void moagemTotalProjetado(AjaxBehaviorEvent e) {
		BigDecimal canaPropriaAreaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagemProjetado()
						.getCanaAreaPropria());
		BigDecimal canaPropriaAreaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagemProjetado()
						.getCanaAreaArrendada());
		BigDecimal canaTerceiros = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagemProjetado()
						.getCanaTerceiros());

		BigDecimal calculo = canaPropriaAreaPropria
				.add(canaPropriaAreaArrendada.add(canaTerceiros));
		getViewHelper()
				.getModel()
				.getAbaUsinas()
				.getAnoMoagemProjetado()
				.setTotalMoagem(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());
	}

	// Terra (ha)
	public void terraTotal1(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerra1().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerra1().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaUsinas()
				.getAnoTerra1()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void terraTotal2(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerra2().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerra2().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaUsinas()
				.getAnoTerra2()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void terraTotal3(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerra3().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerra3().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaUsinas()
				.getAnoTerra3()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void terraTotalProjetado(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerraProjetado().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerraProjetado()
						.getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper()
				.getModel()
				.getAbaUsinas()
				.getAnoTerraProjetado()
				.setAreaTotal(
						calculo.equals(BigDecimal.ZERO) ? "" : calculo
								.toPlainString());

	}

	public void salvar() {

		tabGraosFibras = new UITab();
		tabUsinas = new UITab();

		switch (AbaEnum.getByDescricao(abaSelecionada)) {
		case GRAOS_FIBRAS:
			tabGraosFibras.setSelected(true);
			break;
		case USINAS:
			tabUsinas.setSelected(true);
			break;
		default:
			tabGraosFibras.setSelected(true);
			break;
		}

		QuestionarioAgronegocioVO model = viewHelper.getModel();
		UsinasVO usinas = viewHelper.getModel().getAbaUsinas();

		try {
			salvarNomeProdutor();
			areaPropria();
			areaArrendada();
			manutencaoGraosFibras();
		} catch (Exception e) {
			selecionarAba("GraosFibras");
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		try {
			questionarioAgronegocioService.manutencaoNomeUsina(model, usinas,
					TipoManutencaoEnum.ALTERACAO);
			manutencaoUsinas();
			manutencaoProducaoUsinas();
		} catch (Exception e) {
			selecionarAba("Usinas");
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		if (mensagens.size() == 0) {
			siteUtil.getMessages().getMsgSalvarSucesso();
		}
		mensagens.clear();
		carregarDadosTela();
	}

	private void salvarNomeProdutor() {
		questionarioAgronegocioService.manutencaoNomeProdutor(
				viewHelper.getModel(), TipoManutencaoEnum.INCLUSAO);
	}

	/**
	 * @return the paginaAnterior
	 */
	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	/**
	 * @param paginaAnterior
	 *            the paginaAnterior to set
	 */
	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

	public class ObjectUsinas {

		private MoagemUsinasVO moagem = null;
		private TerraUsinasVO terra = null;
		private AreaCorteUsinasVO areaCorte = null;
		private ProdutividadeUsinasVO produtividade = null;
		private CogeracaoEnergiaUsinasVO cogeracaoEnergias = null;
		private ProducaoUsinasVO producao = null;
		private int numSequencialUsina = 0;

		private ObjectUsinas(AreaCorteUsinasVO areaCorte,
				CogeracaoEnergiaUsinasVO cogeracao, MoagemUsinasVO moagem,
				ProdutividadeUsinasVO produtividade, TerraUsinasVO terra,
				int coluna) {
			this.areaCorte = areaCorte;
			this.cogeracaoEnergias = cogeracao;
			this.moagem = moagem;
			this.produtividade = produtividade;
			this.terra = terra;
			this.numSequencialUsina = coluna;
		}

		public ObjectUsinas(RICCWA7SResponseRegistroAreaSaida registro) {
			// MOAGEM
			moagem = new MoagemUsinasVO();
			moagem.setAno(registro.getAnoSafra());
			moagem.setCapacidadeMoagem(checkNull(registro.getCapacMoagemNull(),
					registro.getCapacMoagem()));
			moagem.setCanaAreaPropria(checkNull(registro.getCanaProprNull(),
					registro.getCanaPropr()));
			moagem.setCanaAreaArrendada(checkNull(registro.getCanaArrendNull(),
					registro.getCanaArrend()));
			moagem.setCanaTerceiros(checkNull(registro.getCanaTerceiroNull(),
					registro.getCanaTerceiro()));
			moagem.setTotalMoagem(checkNull(registro.getTotMoagemNull(),
					registro.getTotMaogem()));

			// TERRA
			terra = new TerraUsinasVO();
			terra.setAno(registro.getAnoSafra());
			terra.setAreaPropria(checkNull(registro.getAreaProprNull(),
					registro.getAreaPropr()));
			terra.setAreaArrendada(checkNull(registro.getAreaArrendNull(),
					registro.getAreaArrend()));
			terra.setAreaRenovacao(checkNull(registro.getAreaRenovNull(),
					registro.getAreaRenov()));
			terra.setAreaExpansao(checkNull(registro.getAreaExpansNull(),
					registro.getAreaExpans()));

			// ÁREA DE CORTE
			areaCorte = new AreaCorteUsinasVO();
			areaCorte.setAno(registro.getAnoSafra());
			areaCorte.setIdadeMediaCanavial(checkNull(
					registro.getIdadeMedNull(), registro.getIdadeMed()));
			areaCorte.setPorcentagemColheitaMecanizada(checkNull(
					registro.getColheitaMecanNull(),
					registro.getColheitaMecan()));
			areaCorte.setRaioMedioCanavial(checkNull(registro.getRaioMedNull(),
					registro.getRaioMed()));

			// PRODUTIVIDADE
			produtividade = new ProdutividadeUsinasVO();
			produtividade.setAno(registro.getAnoSafra());
			produtividade.setProducaoIndustrial(checkNull(
					registro.getProdIndusNull(), registro.getProdIndus()));

			// COGERAÇÃO DE ENERGIA
			cogeracaoEnergias = new CogeracaoEnergiaUsinasVO();
			cogeracaoEnergias.setAno(registro.getAnoSafra());
			cogeracaoEnergias
					.setPotenciaInstalada(checkNull(
							registro.getPotencInstalNull(),
							registro.getPotencInstal()));
			cogeracaoEnergias.setTotalEnergiaVendida(checkNull(
					registro.getTotEnergiaVendNull(),
					registro.getTotEnergiaVend()));
			cogeracaoEnergias.setFaturamento(checkNull(
					registro.getFaturamentoNull(), registro.getFaturamento()));

			numSequencialUsina = registro.getNusinaAcucr();
		}

		private ObjectUsinas(ProducaoUsinasVO producao) {
			this.producao = producao;
		}

		public ObjectUsinas(RICCWA8SResponseRegistroAreaSaida registro) {
			// PRODUÇÃO
			producao = new ProducaoUsinasVO();
			producao.setAno(registro.getAnoSafra());
			producao.setAnoAnterior(registro.getAnoSafra());
			producao.setAcucarCristal(checkNull(registro.getAcrCristalN(),
					registro.getAcrCristal()));
			producao.setAcucarVhp(checkNull(registro.getAcrVhpN(),
					registro.getAcrVhp()));
			producao.setAcucarOrganico(checkNull(registro.getAcrOrgaN(),
					registro.getAcrOrga()));
			producao.setEtanolAnidro(checkNull(registro.getEtaAniN(),
					registro.getEtaAni()));
			producao.setEtanolHidratado(checkNull(registro.getEtaHidraN(),
					registro.getEtaHidra()));
			producao.setEtanolOrganico(checkNull(registro.getEtaOrgaN(),
					registro.getEtaOrga()));
		}

		@SuppressWarnings("unused")
		private String checkNull(String campoNulidade, String campo) {
			return campoNulidade.equalsIgnoreCase("S") ? "" : campo;
		}

		@SuppressWarnings("unused")
		private String checkNull(String campoNulidade, Integer campo) {
			return campoNulidade.equalsIgnoreCase("S") ? "" : campo.toString();
		}

		private String checkNull(String campoNulidade, Long campo) {
			return campoNulidade.equalsIgnoreCase("S") ? "" : campo.toString();
		}

		private String checkNull(String campoNulidade, BigDecimal campo) {
			return campoNulidade.equalsIgnoreCase("S") ? "" : campo.toString();
		}

		public MoagemUsinasVO getMoagem() {
			return moagem;
		}

		public TerraUsinasVO getTerra() {
			return terra;
		}

		public AreaCorteUsinasVO getAreaCorte() {
			return areaCorte;
		}

		public ProdutividadeUsinasVO getProdutividade() {
			return produtividade;
		}

		public CogeracaoEnergiaUsinasVO getCogeracaoEnergias() {
			return cogeracaoEnergias;
		}

		public ProducaoUsinasVO getProducao() {
			return producao;
		}

		public int getNumSequencialUsina() {
			return numSequencialUsina;
		}

	}

	public enum AbaEnum {

		GRAOS_FIBRAS(1, "graosFibras"), USINAS(2, "usinas");

		private Integer codigo = null;
		private String descricao = null;

		private AbaEnum(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public static AbaEnum getByDescricao(String descricao) {
			if (SiteUtil.getInstance().isEmptyOrNull(descricao)) {
				return GRAOS_FIBRAS;
			} else if (descricao.equals("graosFibras")) {
				return GRAOS_FIBRAS;
			} else if (descricao.equals("usinas")) {
				return USINAS;
			}

			return GRAOS_FIBRAS;
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

	public void upload() {

		tabGraosFibras = new UITab();
		tabUsinas = new UITab();

		switch (AbaEnum.getByDescricao(abaSelecionada)) {
		case GRAOS_FIBRAS:
			tabGraosFibras.setSelected(true);
			break;
		case USINAS:
			tabUsinas.setSelected(true);
			break;
		default:
			tabGraosFibras.setSelected(true);
			break;
		}

		try {
			if (this.file == null) {
				BradescoFacesUtils
						.addErrorModalMessage("Selecione a planilha para Upload.");
			} else {
				if (this.file.getName().toUpperCase().contains(".XLSM")) {
					this.tempFile = File.createTempFile("agro", ".xlsm");
					this.tempFile.deleteOnExit();

					copyToFile(this.file.getInputStream(), this.tempFile);

					SetorAgronegocioVO setorProdutor = new QuestionarioAgronegocioXLS()
							.lerSetorAgronegocioProdutorGraosFibras(this.tempFile);

					if (setorProdutor != null) {
						SetorAgronegocioVO setorUsinas = new QuestionarioAgronegocioXLS()
								.lerSetorAgronegocioUsinasAcucarAlcool(this.tempFile);
						BradescoFacesUtils.addInfoModalMessage(
								"Processamento da planilha concluído.", false);
						viewHelper.setModel(popularViaXls(setorProdutor,
								setorUsinas));
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

	public QuestionarioAgronegocioVO popularViaXls(SetorAgronegocioVO xlsGrao,
			SetorAgronegocioVO xlsUsina) {
		QuestionarioAgronegocioVO agro = new QuestionarioAgronegocioVO();

		/** Aba Graos **/
		GraosFibrasVO abaGraos = new GraosFibrasVO();

		abaGraos.setNomeProdutor(xlsGrao.getNomeProdutor());

		// Lista Area Propria
		List<AreaPropriaAgronegocioVO> listaAreaPropria = new ArrayList<AreaPropriaAgronegocioVO>();

		AreaPropriaAgronegocioVO areaPropria;

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria1());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria1()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria1()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria1());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria1()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria1()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria1())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria1().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria1().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria2());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria2()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria2()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria2());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria2()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria2()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria2())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria2().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria2().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria3());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria3()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria3()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria3());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria3()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria3()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria3())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria3().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria3().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria4());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria4()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria4()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria4());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria4()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria4()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria4())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria4().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria4().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria5());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria5()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria5()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria5());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria5()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria5()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria5())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria5().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria5().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria6());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria6()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria6()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria6());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria6()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria6()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria6())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria6().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria6().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria7());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria7()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria7()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria7());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria7()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria7()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria7())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria7().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria7().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria8());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria8()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria8()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria8());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria8()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria8()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria8())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria8().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria8().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria9());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria9()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria9()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria9());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria9()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria9()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria9())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria9().toUpperCase().equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria9().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria10());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria10()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria10()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria10());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria10()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria10()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria10())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria10().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria10().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria11());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria11()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria11()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria11());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria11()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria11()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria11())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria11().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria11().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria12());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria12()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria12()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria12());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria12()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria12()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria12())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria12().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria12().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria13());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria13()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria13()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria13());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria13()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria13()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria13())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria13().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria13().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria14());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria14()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria14()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria14());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria14()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria14()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria14())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria14().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria14().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria15());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria15()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria15()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria15());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria15()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria15()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria15())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria15().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria15().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria16());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria16()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria16()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria16());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria16()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria16()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria16())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria16().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria16().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria17());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria17()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria17()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria17());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria17()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria17()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria17())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria17().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria17().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria18());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria18()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria18()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria18());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria18()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria18()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria18())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria18().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria18().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria19());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria19()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria19()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria19());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria19()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria19()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria19())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria19().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria19().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		areaPropria = new AreaPropriaAgronegocioVO();
		areaPropria.setDescricao(xlsGrao.getDescricaoAreaPropria20());
		areaPropria.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaPropria20()));
		areaPropria.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaPropria20()));
		areaPropria.setCidade(xlsGrao.getCidadeAreaPropria20());
		areaPropria.setValorMercado(siteUtil.tratarParametroString(xlsGrao
				.getValorMercadoRSMilAreaPropria20()));
		areaPropria.setValorMercadoHectare(siteUtil
				.tratarParametroString(xlsGrao
						.getValorMercadoRSHectareAreaPropria20()));
		if (siteUtil.isEmptyOrNull(xlsGrao.getAreaCedidaAreaPropria20())) {
			areaPropria.setIsAreaCedida("");
		} else {
			if (xlsGrao.getAreaCedidaAreaPropria20().toUpperCase()
					.equals("SIM")) {
				areaPropria.setIsAreaCedida("1");
			} else if (xlsGrao.getAreaCedidaAreaPropria20().toUpperCase()
					.equals("NÃO")) {
				areaPropria.setIsAreaCedida("2");
			}
		}
		listaAreaPropria.add(areaPropria);

		abaGraos.setListaAreaPropria(listaAreaPropria);
		while (abaGraos.getCopiaListaAreaPropria().size() <= 20) {
			abaGraos.getCopiaListaAreaPropria().add(
					new AreaPropriaAgronegocioVO());
		}
		for (int i = 0; i < 20; i++) {
			if (this.viewHelper.getModel().getAbaGraos().getListaAreaPropria()
					.get(i).getNumSequencial() != 0) {
				abaGraos.getListaAreaPropria()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel().getAbaGraos()
										.getListaAreaPropria().get(i)
										.getNumSequencial());
				abaGraos.getCopiaListaAreaPropria()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel().getAbaGraos()
										.getCopiaListaAreaPropria().get(i)
										.getNumSequencial());
			}
		}

		// Lista Area Arrendada
		List<AreaArrendadaAgronegocioVO> listaAreaArrendada = new ArrayList<AreaArrendadaAgronegocioVO>();
		AreaArrendadaAgronegocioVO areaArrendada;

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada1());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada1()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada1()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada1());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada1()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada1());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada1());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada2());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada2()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada2()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada2());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada2()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada2());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada2());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada3());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada3()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada3()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada3());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada3()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada3());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada3());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada4());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada4()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada4()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada4());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada4()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada4());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada4());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada5());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada5()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada5()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada5());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada5()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada5());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada5());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada6());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada6()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada6()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada6());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada6()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada6());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada6());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada7());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada7()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada7()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada7());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada7()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada7());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada7());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada8());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada8()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada8()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada8());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada8()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada8());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada8());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada9());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada9()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada9()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada9());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada9()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada9());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada9());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada10());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada10()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada10()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada10());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada10()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada10());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada10());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada11());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada11()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada11()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada11());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada11()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada11());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada11());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada12());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada12()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada12()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada12());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada12()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada12());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada12());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada13());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada13()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada13()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada13());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada13()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada13());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada13());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada14());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada14()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada14()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada14());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada14()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada14());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada14());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada15());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada15()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada15()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada15());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada15()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada15());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada15());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada16());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada16()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada16()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada16());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada16()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada16());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada16());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada17());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada17()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada17()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada17());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada17()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada17());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada17());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada18());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada18()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada18()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada18());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada18()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada18());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada18());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada19());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada19()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada19()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada19());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada19()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada19());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada19());
		listaAreaArrendada.add(areaArrendada);

		areaArrendada = new AreaArrendadaAgronegocioVO();
		areaArrendada.setDescricao(xlsGrao.getDescricaoAreaArrendada20());
		areaArrendada.setAreaTotal(siteUtil.tratarParametroString(xlsGrao
				.getAreaTotalAreaArrendada20()));
		areaArrendada.setAreaProdutiva(siteUtil.tratarParametroString(xlsGrao
				.getAreaProdutivaAreaArrendada20()));
		areaArrendada.setCidade(xlsGrao.getCidadeAreaArrendada20());
		areaArrendada.setCustoArrendamento(siteUtil
				.tratarParametroString(xlsGrao
						.getCustoArrendamentoAreaArrendada20()));
		areaArrendada.setInicioContrato(xlsGrao.getDataInicioAreaArrendada20());
		areaArrendada.setFimContrato(xlsGrao.getDataFimAreaArrendada20());
		listaAreaArrendada.add(areaArrendada);

		abaGraos.setListaAreaArrendada(listaAreaArrendada);
		while (abaGraos.getCopiaListaAreaArrendada().size() <= 20) {
			abaGraos.getCopiaListaAreaArrendada().add(
					new AreaArrendadaAgronegocioVO());
		}
		for (int i = 0; i < 20; i++) {
			if (this.viewHelper.getModel().getAbaGraos()
					.getListaAreaArrendada().get(i).getNumSequencial() != 0) {
				abaGraos.getListaAreaArrendada()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel().getAbaGraos()
										.getListaAreaArrendada().get(i)
										.getNumSequencial());
				abaGraos.getCopiaListaAreaArrendada()
						.get(i)
						.setNumSequencial(
								this.viewHelper.getModel().getAbaGraos()
										.getCopiaListaAreaArrendada().get(i)
										.getNumSequencial());
			}
		}

		/** Tipo Grãos **/
		TipoGraoVO grao;
		AreaPlantadaGraosVO anoSafra;

		// Soja
		grao = new TipoGraoVO();
		grao.setPesoSacaSementes(siteUtil.tratarParametroString(xlsGrao
				.getSojaUnidadesProducaoSementes()));
		grao.setPesoSacaMediaSemente(siteUtil.tratarParametroString(xlsGrao
				.getSojaUnidadesPrecoMedioSemente()));

		anoSafra = new AreaPlantadaGraosVO();
		anoSafra.setAno(xlsGrao.getSojaAnoSafra1());
		anoSafra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getSojaAreaPlantadaPropria1()));
		anoSafra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getSojaAreaArrendadaPropria1()));
		anoSafra.setProducaoGraos(siteUtil.tratarParametroString(xlsGrao
				.getSojaProducaoGraos1()));
		anoSafra.setProducaoSementes(siteUtil.tratarParametroString(xlsGrao
				.getSojaProducaoSementes1()));
		anoSafra.setProdutividade(siteUtil.tratarParametroString(xlsGrao
				.getSojaProdutividadeRealizadaProjetada1()));
		anoSafra.setPrecoMedioGrao(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioGraoRealizadoProjetado1()));
		anoSafra.setPrecoMedioSemente(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioSementeRealizadoProjetado1()));
		anoSafra.setPorcentagemVolumeGraoFixado(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getSojaPorcentagemVolumeGraoFixado1()));
		anoSafra.setPrecoMedioGraoFixado(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioFixado1()));
		anoSafra.setCustoProducaoRealizado(siteUtil
				.tratarParametroString(xlsGrao
						.getSojaCustoProducaoRealizadoProjetado1()));
		grao.setAnoSafra1(anoSafra);

		anoSafra = new AreaPlantadaGraosVO();
		anoSafra.setAno(xlsGrao.getSojaAnoSafra2());
		anoSafra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getSojaAreaPlantadaPropria2()));
		anoSafra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getSojaAreaArrendadaPropria2()));
		anoSafra.setProducaoGraos(siteUtil.tratarParametroString(xlsGrao
				.getSojaProducaoGraos2()));
		anoSafra.setProducaoSementes(siteUtil.tratarParametroString(xlsGrao
				.getSojaProducaoSementes2()));
		anoSafra.setProdutividade(siteUtil.tratarParametroString(xlsGrao
				.getSojaProdutividadeRealizadaProjetada2()));
		anoSafra.setPrecoMedioGrao(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioGraoRealizadoProjetado2()));
		anoSafra.setPrecoMedioSemente(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioSementeRealizadoProjetado2()));
		anoSafra.setPorcentagemVolumeGraoFixado(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getSojaPorcentagemVolumeGraoFixado2()));
		anoSafra.setPrecoMedioGraoFixado(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioFixado2()));
		anoSafra.setCustoProducaoRealizado(siteUtil
				.tratarParametroString(xlsGrao
						.getSojaCustoProducaoRealizadoProjetado2()));
		grao.setAnoSafra2(anoSafra);

		anoSafra = new AreaPlantadaGraosVO();
		anoSafra.setAno(xlsGrao.getSojaAnoSafra3());
		anoSafra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getSojaAreaPlantadaPropria3()));
		anoSafra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getSojaAreaArrendadaPropria3()));
		anoSafra.setProducaoGraos(siteUtil.tratarParametroString(xlsGrao
				.getSojaProducaoGraos3()));
		anoSafra.setProducaoSementes(siteUtil.tratarParametroString(xlsGrao
				.getSojaProducaoSementes3()));
		anoSafra.setProdutividade(siteUtil.tratarParametroString(xlsGrao
				.getSojaProdutividadeRealizadaProjetada3()));
		anoSafra.setPrecoMedioGrao(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioGraoRealizadoProjetado3()));
		anoSafra.setPrecoMedioSemente(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioSementeRealizadoProjetado3()));
		anoSafra.setPorcentagemVolumeGraoFixado(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getSojaPorcentagemVolumeGraoFixado3()));
		anoSafra.setPrecoMedioGraoFixado(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioFixado3()));
		anoSafra.setCustoProducaoRealizado(siteUtil
				.tratarParametroString(xlsGrao
						.getSojaCustoProducaoRealizadoProjetado3()));
		grao.setAnoSafra3(anoSafra);

		anoSafra = new AreaPlantadaGraosVO();
		anoSafra.setAno(xlsGrao.getSojaAnoSafra4());
		anoSafra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getSojaAreaPlantadaPropria4()));
		anoSafra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getSojaAreaArrendadaPropria4()));
		anoSafra.setProducaoGraos(siteUtil.tratarParametroString(xlsGrao
				.getSojaProducaoGraos4()));
		anoSafra.setProducaoSementes(siteUtil.tratarParametroString(xlsGrao
				.getSojaProducaoSementes4()));
		anoSafra.setProdutividade(siteUtil.tratarParametroString(xlsGrao
				.getSojaProdutividadeRealizadaProjetada4()));
		anoSafra.setPrecoMedioGrao(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioGraoRealizadoProjetado4()));
		anoSafra.setPrecoMedioSemente(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioSementeRealizadoProjetado4()));
		anoSafra.setPorcentagemVolumeGraoFixado(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getSojaPorcentagemVolumeGraoFixado4()));
		anoSafra.setPrecoMedioGraoFixado(siteUtil.tratarParametroString(xlsGrao
				.getSojaPrecoMedioFixado4()));
		anoSafra.setCustoProducaoRealizado(siteUtil
				.tratarParametroString(xlsGrao
						.getSojaCustoProducaoRealizadoProjetado4()));
		grao.setAnoSafraProjetado(anoSafra);

		abaGraos.setGraoSoja(grao);

		// Milho
		grao = new TipoGraoVO();
		grao.setPesoSacaSementes(siteUtil.tratarParametroString(xlsGrao
				.getMilhoUnidadesProducaoSementes()));
		grao.setPesoSacaMediaSemente(siteUtil.tratarParametroString(xlsGrao
				.getMilhoUnidadesPrecoMedioSemente()));

		anoSafra = new AreaPlantadaGraosVO();
		anoSafra.setAno(xlsGrao.getMilhoAnoSafra1());
		anoSafra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getMilhoAreaPlantadaPropria1()));
		anoSafra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getMilhoAreaArrendadaPropria1()));
		anoSafra.setProducaoGraos(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProducaoGraos1()));
		anoSafra.setProducaoSementes(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProducaoSementes1()));
		anoSafra.setProdutividade(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProdutividadeRealizadaProjetada1()));
		anoSafra.setPrecoMedioGrao(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioGraoRealizadoProjetado1()));
		anoSafra.setPrecoMedioSemente(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioSementeRealizadoProjetado1()));
		anoSafra.setPorcentagemVolumeGraoFixado(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getMilhoPorcentagemVolumeGraoFixado1()));
		anoSafra.setPrecoMedioGraoFixado(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioFixado1()));
		anoSafra.setCustoProducaoRealizado(siteUtil
				.tratarParametroString(xlsGrao
						.getMilhoCustoProducaoRealizadoProjetado1()));
		grao.setAnoSafra1(anoSafra);

		anoSafra = new AreaPlantadaGraosVO();
		anoSafra.setAno(xlsGrao.getMilhoAnoSafra2());
		anoSafra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getMilhoAreaPlantadaPropria2()));
		anoSafra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getMilhoAreaArrendadaPropria2()));
		anoSafra.setProducaoGraos(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProducaoGraos2()));
		anoSafra.setProducaoSementes(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProducaoSementes2()));
		anoSafra.setProdutividade(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProdutividadeRealizadaProjetada2()));
		anoSafra.setPrecoMedioGrao(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioGraoRealizadoProjetado2()));
		anoSafra.setPrecoMedioSemente(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioSementeRealizadoProjetado2()));
		anoSafra.setPorcentagemVolumeGraoFixado(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getMilhoPorcentagemVolumeGraoFixado2()));
		anoSafra.setPrecoMedioGraoFixado(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioFixado2()));
		anoSafra.setCustoProducaoRealizado(siteUtil
				.tratarParametroString(xlsGrao
						.getMilhoCustoProducaoRealizadoProjetado2()));
		grao.setAnoSafra2(anoSafra);

		anoSafra = new AreaPlantadaGraosVO();
		anoSafra.setAno(xlsGrao.getMilhoAnoSafra3());
		anoSafra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getMilhoAreaPlantadaPropria3()));
		anoSafra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getMilhoAreaArrendadaPropria3()));
		anoSafra.setProducaoGraos(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProducaoGraos3()));
		anoSafra.setProducaoSementes(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProducaoSementes3()));
		anoSafra.setProdutividade(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProdutividadeRealizadaProjetada3()));
		anoSafra.setPrecoMedioGrao(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioGraoRealizadoProjetado3()));
		anoSafra.setPrecoMedioSemente(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioSementeRealizadoProjetado3()));
		anoSafra.setPorcentagemVolumeGraoFixado(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getMilhoPorcentagemVolumeGraoFixado3()));
		anoSafra.setPrecoMedioGraoFixado(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioFixado3()));
		anoSafra.setCustoProducaoRealizado(siteUtil
				.tratarParametroString(xlsGrao
						.getMilhoCustoProducaoRealizadoProjetado3()));
		grao.setAnoSafra3(anoSafra);

		anoSafra = new AreaPlantadaGraosVO();
		anoSafra.setAno(xlsGrao.getMilhoAnoSafra4());
		anoSafra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getMilhoAreaPlantadaPropria4()));
		anoSafra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getMilhoAreaArrendadaPropria4()));
		anoSafra.setProducaoGraos(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProducaoGraos4()));
		anoSafra.setProducaoSementes(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProducaoSementes4()));
		anoSafra.setProdutividade(siteUtil.tratarParametroString(xlsGrao
				.getMilhoProdutividadeRealizadaProjetada4()));
		anoSafra.setPrecoMedioGrao(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioGraoRealizadoProjetado4()));
		anoSafra.setPrecoMedioSemente(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioSementeRealizadoProjetado4()));
		anoSafra.setPorcentagemVolumeGraoFixado(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getMilhoPorcentagemVolumeGraoFixado4()));
		anoSafra.setPrecoMedioGraoFixado(siteUtil.tratarParametroString(xlsGrao
				.getMilhoPrecoMedioFixado4()));
		anoSafra.setCustoProducaoRealizado(siteUtil
				.tratarParametroString(xlsGrao
						.getMilhoCustoProducaoRealizadoProjetado4()));
		grao.setAnoSafraProjetado(anoSafra);

		abaGraos.setGraoMilho(grao);

		/** Tipo Fibras **/
		FibrasVO fibra = new FibrasVO();
		AreaPlantadaFibrasVO anoSafraFibra = new AreaPlantadaFibrasVO();

		anoSafraFibra = new AreaPlantadaFibrasVO();
		anoSafraFibra.setAno(xlsGrao.getAlgodaoAnoSafra1());
		anoSafraFibra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoAreaPlantadaPropria1()));
		anoSafraFibra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoAreaArrendadaPropria1()));
		anoSafraFibra.setPlumaHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalPluma1()));
		anoSafraFibra.setCarocoHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalCaroco1()));
		anoSafraFibra.setFibrilhaHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalFibrilha1()));
		anoSafraFibra.setMediaPlumaRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoPluma1()));
		anoSafraFibra.setMediaCarocoRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoCaroco1()));
		anoSafraFibra.setMediaFibrilhaRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoFibrilha1()));
		anoSafraFibra.setPorcentagemVolumePluma(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getAlgodaoPorcentagemVolumeFixadoPluma1()));
		anoSafraFibra.setPrecoFixadoMomento(siteUtil
				.tratarParametroString(xlsGrao.getAlgodaoPrecoFixadoPluma1()));
		anoSafraFibra.setCustoProducaoRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoCustoProducaoRealizadoProjetado1()));
		fibra.setAnoSafra1(anoSafraFibra);

		anoSafraFibra = new AreaPlantadaFibrasVO();
		anoSafraFibra.setAno(xlsGrao.getAlgodaoAnoSafra2());
		anoSafraFibra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoAreaPlantadaPropria2()));
		anoSafraFibra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoAreaArrendadaPropria2()));
		anoSafraFibra.setPlumaHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalPluma2()));
		anoSafraFibra.setCarocoHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalCaroco2()));
		anoSafraFibra.setFibrilhaHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalFibrilha2()));
		anoSafraFibra.setMediaPlumaRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoPluma2()));
		anoSafraFibra.setMediaCarocoRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoCaroco2()));
		anoSafraFibra.setMediaFibrilhaRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoFibrilha2()));
		anoSafraFibra.setPorcentagemVolumePluma(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getAlgodaoPorcentagemVolumeFixadoPluma2()));
		anoSafraFibra.setPrecoFixadoMomento(siteUtil
				.tratarParametroString(xlsGrao.getAlgodaoPrecoFixadoPluma2()));
		anoSafraFibra.setCustoProducaoRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoCustoProducaoRealizadoProjetado2()));
		fibra.setAnoSafra2(anoSafraFibra);

		anoSafraFibra = new AreaPlantadaFibrasVO();
		anoSafraFibra.setAno(xlsGrao.getAlgodaoAnoSafra3());
		anoSafraFibra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoAreaPlantadaPropria3()));
		anoSafraFibra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoAreaArrendadaPropria3()));
		anoSafraFibra.setPlumaHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalPluma3()));
		anoSafraFibra.setCarocoHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalCaroco3()));
		anoSafraFibra.setFibrilhaHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalFibrilha3()));
		anoSafraFibra.setMediaPlumaRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoPluma3()));
		anoSafraFibra.setMediaCarocoRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoCaroco3()));
		anoSafraFibra.setMediaFibrilhaRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoFibrilha3()));
		anoSafraFibra.setPorcentagemVolumePluma(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getAlgodaoPorcentagemVolumeFixadoPluma3()));
		anoSafraFibra.setPrecoFixadoMomento(siteUtil
				.tratarParametroString(xlsGrao.getAlgodaoPrecoFixadoPluma3()));
		anoSafraFibra.setCustoProducaoRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoCustoProducaoRealizadoProjetado3()));
		fibra.setAnoSafra3(anoSafraFibra);

		anoSafraFibra = new AreaPlantadaFibrasVO();
		anoSafraFibra.setAno(xlsGrao.getAlgodaoAnoSafra4());
		anoSafraFibra.setAreaPropria(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoAreaPlantadaPropria4()));
		anoSafraFibra.setAreaArrendada(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoAreaArrendadaPropria4()));
		anoSafraFibra.setPlumaHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalPluma4()));
		anoSafraFibra.setCarocoHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalCaroco4()));
		anoSafraFibra.setFibrilhaHectare(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoProdutividadeTotalFibrilha4()));
		anoSafraFibra.setMediaPlumaRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoPluma4()));
		anoSafraFibra.setMediaCarocoRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoCaroco4()));
		anoSafraFibra.setMediaFibrilhaRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoPrecoMedioRealizadoProjetadoFibrilha4()));
		anoSafraFibra.setPorcentagemVolumePluma(siteUtil
				.tratarDuasCasasDecimais(xlsGrao
						.getAlgodaoPorcentagemVolumeFixadoPluma4()));
		anoSafraFibra.setPrecoFixadoMomento(siteUtil
				.tratarParametroString(xlsGrao.getAlgodaoPrecoFixadoPluma4()));
		anoSafraFibra.setCustoProducaoRP(siteUtil.tratarParametroString(xlsGrao
				.getAlgodaoCustoProducaoRealizadoProjetado4()));
		fibra.setAnoSafraProjetado(anoSafraFibra);

		abaGraos.setFibraAlgodao(fibra);
		agro.setAbaGraos(abaGraos);

		/** Aba Usina **/
		UsinasVO abaUsinas = new UsinasVO();
		abaUsinas.setNomeUsina(xlsUsina.getNomeDaUsina());

		// moagem
		MoagemUsinasVO moagem;

		moagem = new MoagemUsinasVO();
		moagem.setAno(xlsUsina.getUsinaAnoSafra1());
		moagem.setCapacidadeMoagem(siteUtil.tratarParametroString(xlsUsina
				.getCapacidadeMoagem1()));
		moagem.setCanaAreaPropria(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaPropriaAreaPropria1()));
		moagem.setCanaAreaArrendada(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaPropriaAreaArreandada1()));
		moagem.setCanaTerceiros(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaTerceiros1()));
		abaUsinas.setAnoMoagem1(moagem);

		moagem = new MoagemUsinasVO();
		moagem.setAno(xlsUsina.getUsinaAnoSafra2());
		moagem.setCapacidadeMoagem(siteUtil.tratarParametroString(xlsUsina
				.getCapacidadeMoagem2()));
		moagem.setCanaAreaPropria(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaPropriaAreaPropria2()));
		moagem.setCanaAreaArrendada(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaPropriaAreaArreandada2()));
		moagem.setCanaTerceiros(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaTerceiros2()));
		abaUsinas.setAnoMoagem2(moagem);

		moagem = new MoagemUsinasVO();
		moagem.setAno(xlsUsina.getUsinaAnoSafra3());
		moagem.setCapacidadeMoagem(siteUtil.tratarParametroString(xlsUsina
				.getCapacidadeMoagem3()));
		moagem.setCanaAreaPropria(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaPropriaAreaPropria3()));
		moagem.setCanaAreaArrendada(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaPropriaAreaArreandada3()));
		moagem.setCanaTerceiros(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaTerceiros3()));
		abaUsinas.setAnoMoagem3(moagem);

		moagem = new MoagemUsinasVO();
		moagem.setAno(xlsUsina.getUsinaAnoSafra4());
		moagem.setCapacidadeMoagem(siteUtil.tratarParametroString(xlsUsina
				.getCapacidadeMoagem4()));
		moagem.setCanaAreaPropria(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaPropriaAreaPropria4()));
		moagem.setCanaAreaArrendada(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaPropriaAreaArreandada4()));
		moagem.setCanaTerceiros(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getCanaTerceiros4()));
		abaUsinas.setAnoMoagemProjetado(moagem);

		// Terra
		TerraUsinasVO terra;

		terra = new TerraUsinasVO();
		terra.setAreaPropria(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaPropria1()));
		terra.setAreaArrendada(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaArreandada1()));
		terra.setAreaRenovacao(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaRenovacao1()));
		terra.setAreaExpansao(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaExpansao1()));
		abaUsinas.setAnoTerra1(terra);

		terra = new TerraUsinasVO();
		terra.setAreaPropria(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaPropria2()));
		terra.setAreaArrendada(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaArreandada2()));
		terra.setAreaRenovacao(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaRenovacao2()));
		terra.setAreaExpansao(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaExpansao2()));
		abaUsinas.setAnoTerra2(terra);

		terra = new TerraUsinasVO();
		terra.setAreaPropria(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaPropria3()));
		terra.setAreaArrendada(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaArreandada3()));
		terra.setAreaRenovacao(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaRenovacao3()));
		terra.setAreaExpansao(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaExpansao3()));
		abaUsinas.setAnoTerra3(terra);

		terra = new TerraUsinasVO();
		terra.setAreaPropria(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaPropria4()));
		terra.setAreaArrendada(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaArreandada4()));
		terra.setAreaRenovacao(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaRenovacao4()));
		terra.setAreaExpansao(siteUtil.tratarParametroString(xlsUsina
				.getTerraAreaExpansao4()));
		abaUsinas.setAnoTerraProjetado(terra);

		// Area Corte
		AreaCorteUsinasVO anoAreaCorte;

		anoAreaCorte = new AreaCorteUsinasVO();
		anoAreaCorte.setIdadeMediaCanavial(siteUtil
				.tratarParametroString(xlsUsina.getIdadeMediaCanavial1()));
		anoAreaCorte.setPorcentagemColheitaMecanizada(siteUtil
				.tratarDuasCasasDecimais(xlsUsina
						.getPorcentagemColheitaMecanizada1()));
		anoAreaCorte.setRaioMedioCanavial(siteUtil
				.tratarParametroString(xlsUsina.getRaioMedioCanavial1()));
		abaUsinas.setAnoAreaCorte1(anoAreaCorte);

		anoAreaCorte = new AreaCorteUsinasVO();
		anoAreaCorte.setIdadeMediaCanavial(siteUtil
				.tratarParametroString(xlsUsina.getIdadeMediaCanavial2()));
		anoAreaCorte.setPorcentagemColheitaMecanizada(siteUtil
				.tratarDuasCasasDecimais(xlsUsina
						.getPorcentagemColheitaMecanizada2()));
		anoAreaCorte.setRaioMedioCanavial(siteUtil
				.tratarParametroString(xlsUsina.getRaioMedioCanavial2()));
		abaUsinas.setAnoAreaCorte2(anoAreaCorte);

		anoAreaCorte = new AreaCorteUsinasVO();
		anoAreaCorte.setIdadeMediaCanavial(siteUtil
				.tratarParametroString(xlsUsina.getIdadeMediaCanavial3()));
		anoAreaCorte.setPorcentagemColheitaMecanizada(siteUtil
				.tratarDuasCasasDecimais(xlsUsina
						.getPorcentagemColheitaMecanizada3()));
		anoAreaCorte.setRaioMedioCanavial(siteUtil
				.tratarParametroString(xlsUsina.getRaioMedioCanavial3()));
		abaUsinas.setAnoAreaCorte3(anoAreaCorte);

		anoAreaCorte = new AreaCorteUsinasVO();
		anoAreaCorte.setIdadeMediaCanavial(siteUtil
				.tratarParametroString(xlsUsina.getIdadeMediaCanavial4()));
		anoAreaCorte.setPorcentagemColheitaMecanizada(siteUtil
				.tratarDuasCasasDecimais(xlsUsina
						.getPorcentagemColheitaMecanizada4()));
		anoAreaCorte.setRaioMedioCanavial(siteUtil
				.tratarParametroString(xlsUsina.getRaioMedioCanavial4()));
		abaUsinas.setAnoAreaCorteProjetado(anoAreaCorte);

		// Produção
		ProducaoUsinasVO anoProducao;

		anoProducao = new ProducaoUsinasVO();
		anoProducao.setAcucarCristal(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarCristal1()));
		anoProducao.setAcucarVhp(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarVHP1()));
		anoProducao.setAcucarOrganico(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarOrganico1()));
		anoProducao.setEtanolAnidro(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolAnidro1()));
		anoProducao.setEtanolHidratado(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolHidratado1()));
		anoProducao.setEtanolOrganico(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolOrganico1()));
		abaUsinas.setAnoProducao1(anoProducao);

		anoProducao = new ProducaoUsinasVO();
		anoProducao.setAcucarCristal(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarCristal2()));
		anoProducao.setAcucarVhp(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarVHP2()));
		anoProducao.setAcucarOrganico(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarOrganico2()));
		anoProducao.setEtanolAnidro(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolAnidro2()));
		anoProducao.setEtanolHidratado(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolHidratado2()));
		anoProducao.setEtanolOrganico(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolOrganico2()));
		abaUsinas.setAnoProducao2(anoProducao);

		anoProducao = new ProducaoUsinasVO();
		anoProducao.setAcucarCristal(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarCristal3()));
		anoProducao.setAcucarVhp(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarVHP3()));
		anoProducao.setAcucarOrganico(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarOrganico3()));
		anoProducao.setEtanolAnidro(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolAnidro3()));
		anoProducao.setEtanolHidratado(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolHidratado3()));
		anoProducao.setEtanolOrganico(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolOrganico3()));
		abaUsinas.setAnoProducao3(anoProducao);

		anoProducao = new ProducaoUsinasVO();
		anoProducao.setAcucarCristal(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarCristal4()));
		anoProducao.setAcucarVhp(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarVHP4()));
		anoProducao.setAcucarOrganico(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaAcucarOrganico4()));
		anoProducao.setEtanolAnidro(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolAnidro4()));
		anoProducao.setEtanolHidratado(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolHidratado4()));
		anoProducao.setEtanolOrganico(siteUtil.tratarDuasCasasDecimais(xlsUsina
				.getProducaoEtanolOrganico4()));
		abaUsinas.setAnoProducaoProjetado(anoProducao);

		// Produtividade
		ProdutividadeUsinasVO anoProdutividade;

		anoProdutividade = new ProdutividadeUsinasVO();
		anoProdutividade.setProducaoIndustrial(siteUtil
				.tratarParametroString(xlsUsina.getProducaoIndustrial1()));
		abaUsinas.setAnoProdutividade1(anoProdutividade);

		anoProdutividade = new ProdutividadeUsinasVO();
		anoProdutividade.setProducaoIndustrial(siteUtil
				.tratarParametroString(xlsUsina.getProducaoIndustrial2()));
		abaUsinas.setAnoProdutividade2(anoProdutividade);

		anoProdutividade = new ProdutividadeUsinasVO();
		anoProdutividade.setProducaoIndustrial(siteUtil
				.tratarParametroString(xlsUsina.getProducaoIndustrial3()));
		abaUsinas.setAnoProdutividade3(anoProdutividade);

		anoProdutividade = new ProdutividadeUsinasVO();
		anoProdutividade.setProducaoIndustrial(siteUtil
				.tratarParametroString(xlsUsina.getProducaoIndustrial4()));
		abaUsinas.setAnoProdutividadeProjetado(anoProdutividade);

		// Cogeração de Energia
		CogeracaoEnergiaUsinasVO anoCogeracaoEnergia;

		anoCogeracaoEnergia = new CogeracaoEnergiaUsinasVO();
		anoCogeracaoEnergia.setPotenciaInstalada(siteUtil
				.tratarParametroString(xlsUsina.getPotenciaInstalada1()));
		anoCogeracaoEnergia.setTotalEnergiaVendida(siteUtil
				.tratarParametroString(xlsUsina.getTotalEnergiaVendida1()));
		anoCogeracaoEnergia.setFaturamento(siteUtil
				.tratarParametroString(xlsUsina.getFaturamento1()));
		abaUsinas.setAnoCogeracaoEnergia1(anoCogeracaoEnergia);

		anoCogeracaoEnergia = new CogeracaoEnergiaUsinasVO();
		anoCogeracaoEnergia.setPotenciaInstalada(siteUtil
				.tratarParametroString(xlsUsina.getPotenciaInstalada2()));
		anoCogeracaoEnergia.setTotalEnergiaVendida(siteUtil
				.tratarParametroString(xlsUsina.getTotalEnergiaVendida2()));
		anoCogeracaoEnergia.setFaturamento(siteUtil
				.tratarParametroString(xlsUsina.getFaturamento2()));
		abaUsinas.setAnoCogeracaoEnergia2(anoCogeracaoEnergia);

		anoCogeracaoEnergia = new CogeracaoEnergiaUsinasVO();
		anoCogeracaoEnergia.setPotenciaInstalada(siteUtil
				.tratarParametroString(xlsUsina.getPotenciaInstalada3()));
		anoCogeracaoEnergia.setTotalEnergiaVendida(siteUtil
				.tratarParametroString(xlsUsina.getTotalEnergiaVendida3()));
		anoCogeracaoEnergia.setFaturamento(siteUtil
				.tratarParametroString(xlsUsina.getFaturamento3()));
		abaUsinas.setAnoCogeracaoEnergia3(anoCogeracaoEnergia);

		anoCogeracaoEnergia = new CogeracaoEnergiaUsinasVO();
		anoCogeracaoEnergia.setPotenciaInstalada(siteUtil
				.tratarParametroString(xlsUsina.getPotenciaInstalada4()));
		anoCogeracaoEnergia.setTotalEnergiaVendida(siteUtil
				.tratarParametroString(xlsUsina.getTotalEnergiaVendida4()));
		anoCogeracaoEnergia.setFaturamento(siteUtil
				.tratarParametroString(xlsUsina.getFaturamento4()));
		abaUsinas.setAnoCogeracaoEnergiaProjetado(anoCogeracaoEnergia);

		agro.setAbaUsinas(abaUsinas);

		agro.setCodGrupo(this.viewHelper.getModel().getCodGrupo());
		agro.setDescGrupo(this.viewHelper.getModel().getDescGrupo());

		agro.setCodRelatorio(this.viewHelper.getModel().getCodRelatorio());

		return agro;
	}

	public DiskFileItem getFile() {
		return file;
	}

	public void setFile(DiskFileItem file) {
		this.file = file;
	}

	public UITab getTabGraosFibras() {
		return tabGraosFibras;
	}

	public void setTabGraosFibras(UITab tabGraosFibras) {
		this.tabGraosFibras = tabGraosFibras;
	}

	public UITab getTabUsinas() {
		return tabUsinas;
	}

	public void setTabUsinas(UITab tabUsinas) {
		this.tabUsinas = tabUsinas;
	}

	public String getAbaSelecionada() {
		return abaSelecionada;
	}

	public void setAbaSelecionada(String abaSelecionada) {
		this.abaSelecionada = abaSelecionada;
	}

}
