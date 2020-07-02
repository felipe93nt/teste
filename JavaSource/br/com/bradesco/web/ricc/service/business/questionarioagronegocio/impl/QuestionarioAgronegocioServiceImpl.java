package br.com.bradesco.web.ricc.service.business.questionarioagronegocio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.bradesco.data.connector.exception.ConnectorExecutionException;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaArrendadaAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaCorteUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPropriaAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.CogeracaoEnergiaUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.GraosFibrasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.MoagemUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.ProducaoUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.ProdutividadeUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.TerraUsinasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.UsinasVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.request.ConsultarAreaProdutoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.request.RICCWA5ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response.ConsultarAreaProdutoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response.RICCWA5SResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response.RICCWA5SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.request.ConsultarGraosFibrasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.request.RICCWA6ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.response.ConsultarGraosFibrasResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.response.RICCWA6SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.request.ConsultarProdUsinasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.response.ConsultarProdUsinasResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.response.RICCWA8SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.request.ConsultarUsinasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.response.ConsultarUsinasResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.response.RICCWA7SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.request.DetalharRelAgricolaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.response.DetalharRelAgricolaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.request.ManutAreaProdutorRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.request.RICCWCCERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.response.ManutAreaProdutorResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutGraosFibras.request.ManutGraosFibrasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutGraosFibras.request.RICCWCDERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutGraosFibras.request.RICCWCDERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutGraosFibras.response.ManutGraosFibrasResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.request.ManutProducaoUsinasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.request.RICCWCFERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.response.ManutProducaoUsinasResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelAgricola.request.ManutRelAgricolaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelAgricola.response.ManutRelAgricolaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.request.ManutUsinasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.request.RICCWCEERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.response.ManutUsinasResponse;
import br.com.bradesco.web.ricc.service.business.BaseService;
import br.com.bradesco.web.ricc.service.business.questionarioagronegocio.IQuestionarioAgronegocioService;
import br.com.bradesco.web.ricc.utils.Numeros;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.bean.QuestionarioAgronegocioBean;

/**
 * @name QuestionarioAgronegocioServiceImpl
 * @author Foursys
 * @see QuestionarioAgronegocioServiceImpl.java
 * @version 1.0
 * @since 13/09/2018
 */
@Named("questionarioAgronegocioService")
public class QuestionarioAgronegocioServiceImpl extends BaseService implements
		IQuestionarioAgronegocioService {
	/**
	 *
	 */
	private static final long serialVersionUID = 1191190165571159977L;
	static final String SIM = "S";
	static final String NAO = "N";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.service.business.questionarioagronegocio.
	 * IQuestionarioAgronegocioService
	 * #manutencaoAreaPropria(br.com.bradesco.web.
	 * ricc.model.cadastro.questionarioagronegocio.AreaPropriaAgronegocioVO)
	 */
	@Override
	public void manutencaoAreaPropria(QuestionarioAgronegocioVO agro,
			AreaPropriaAgronegocioVO areaVo, Integer tipoManutencao) {
		ManutAreaProdutorRequest request = new ManutAreaProdutorRequest();
		ManutAreaProdutorResponse response = new ManutAreaProdutorResponse();
		request.setRICCWCCERequest(new RICCWCCERequest());

		RICCWCCERequest req = request.getRICCWCCERequest();

		req.setCgrpEconm(siteUtil.tratarParametroInteger(agro.getCodGrupo()));
		req.setNrelatCredt(siteUtil.tratarParametroInteger(agro
				.getCodRelatorio()));
		req.setNversaoOrige(Numeros.ZERO);
		req.setCtpoArea(Numeros.UM);
		req.setCtpoManut(tipoManutencao);

		req.setIprotrAgri(agro.getAbaGraos().getNomeProdutor());
		req.setNareaProtr(areaVo.getNumSequencial());
		req.setRareaProtr(siteUtil.nullToString(areaVo.getDescricao()));
		req.setQareaHtare(siteUtil.tratarParametroInteger(areaVo.getAreaTotal()));
		req.setQareaPrdtv(siteUtil.tratarParametroInteger(areaVo
				.getAreaProdutiva()));
		req.setRciddeArea(areaVo.getCidade());
		req.setVareaMercd(siteUtil.valueToMainframeBigDecimal(areaVo
				.getValorMercado()));
		req.setVmercHtare(siteUtil.valueToMainframeBigDecimal(areaVo
				.getValorMercadoHectare()));
		req.setCindcdArea(siteUtil.tratarParametroInteger(areaVo
				.getIsAreaCedida()));
		req.setVcustoArre(new BigDecimal(0));
		req.setDinicContr("");
		req.setDfimContr("");

		try {
			this.adapterCWS.invokeProcessFromNC(request, response, "RICCIACC");
		} catch (ConnectorExecutionException e) {
			siteUtil.throwException("RICCIACC", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.service.business.questionarioagronegocio.
	 * IQuestionarioAgronegocioService#listarAreaPropria(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public GraosFibrasVO listarAreaPropria(String tipoProduto, String codGrupo,
			String codRelatorio) {
		ConsultarAreaProdutoRequest request = new ConsultarAreaProdutoRequest();
		ConsultarAreaProdutoResponse response = new ConsultarAreaProdutoResponse();
		request.setRICCWA5ERequest(new RICCWA5ERequest());
		response.setRICCWA5SResponse(new RICCWA5SResponse());
		RICCWA5SResponse saida = null;
		GraosFibrasVO vo = new GraosFibrasVO();
		vo.setListaAreaPropria(new ArrayList<AreaPropriaAgronegocioVO>());

		request.getRICCWA5ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(codGrupo));
		request.getRICCWA5ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(codRelatorio));
		request.getRICCWA5ERequest().setCtpoArea(
				siteUtil.tratarParametroInteger(tipoProduto));
		request.getRICCWA5ERequest().setNversaoOrige(Numeros.ZERO);
		request.getRICCWA5ERequest().setFILLER4("");
		request.getRICCWA5ERequest().setMaxOcorr(Numeros.CINQUENTA);

		try {
			saida = invokeProcessAutoPagination(request, response, "RICCIAA5",
					RICCWA5SResponseRegistroAreaSaida.class)
					.getRICCWA5SResponse();
		} catch (ConnectorExecutionException e) {
			siteUtil.throwException("RICCIAA5", e);
		}

		vo.setNomeProdutor(saida.getIprotrAgri());
		vo.setSomaAreaTotalPropria(Long.toString(saida.getQtotAreaTot()));
		vo.setSomaAreaProdutivaPropria(Long.toString(saida.getQtotAreaProd()));
		vo.setSomaValorMercado(saida.getVtotMercd()
				.setScale(0, BigDecimal.ROUND_UP).toString());
		vo.setSomaValorMercadoHectares(saida.getVtotMerHctar()
				.setScale(0, BigDecimal.ROUND_UP).toString());
		for (RICCWA5SResponseRegistroAreaSaida item : saida.getAreaSaida()) {
			// if (!"".equals(item.getRareaProtr())) {
			AreaPropriaAgronegocioVO area = new AreaPropriaAgronegocioVO();
			area.setNumSequencial(item.getNareaProtr());
			area.setDescricao(item.getRareaProtr());
			area.setAreaTotal(siteUtil.formatValoresToStringInteger(String
					.valueOf(item.getQareaHtare())));
			area.setAreaProdutiva(siteUtil.formatValoresToStringInteger(String
					.valueOf(item.getQareaPrdtv())));
			area.setCidade(item.getRciddeArea());
			area.setValorMercado(siteUtil.formatValoresToStringInteger(item
					.getVareaMercd().setScale(0, BigDecimal.ROUND_UP)
					.toString()));
			area.setValorMercadoHectare(siteUtil
					.formatValoresToStringInteger(item.getVmercHtare()
							.setScale(0, BigDecimal.ROUND_UP).toString()));
			area.setIsAreaCedida(String.valueOf(item.getCindcdArea()));
			vo.getListaAreaPropria().add(area);
			// }
		}
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.service.business.questionarioagronegocio.
	 * IQuestionarioAgronegocioService
	 * #manutencaoAreaArrendada(br.com.bradesco.web
	 * .ricc.model.cadastro.questionarioagronegocio.AreaArrendadaAgronegocioVO)
	 */
	@Override
	public void manutencaoAreaArrendada(QuestionarioAgronegocioVO agro,
			AreaArrendadaAgronegocioVO areaVo, Integer tipoManutencao) {
		ManutAreaProdutorRequest request = new ManutAreaProdutorRequest();
		ManutAreaProdutorResponse response = new ManutAreaProdutorResponse();
		request.setRICCWCCERequest(new RICCWCCERequest());
		RICCWCCERequest req = request.getRICCWCCERequest();

		req.setCgrpEconm(siteUtil.tratarParametroInteger(agro.getCodGrupo()));
		req.setNrelatCredt(siteUtil.tratarParametroInteger(agro
				.getCodRelatorio()));
		req.setNversaoOrige(Numeros.ZERO);
		req.setCtpoArea(Numeros.DOIS);
		req.setCtpoManut(tipoManutencao);

		req.setIprotrAgri(agro.getAbaGraos().getNomeProdutor());
		req.setNareaProtr(areaVo.getNumSequencial());
		req.setRareaProtr(areaVo.getDescricao());
		req.setQareaHtare(siteUtil.tratarParametroInteger(areaVo.getAreaTotal()));
		req.setQareaPrdtv(siteUtil.tratarParametroInteger(areaVo
				.getAreaProdutiva()));
		req.setRciddeArea(areaVo.getCidade());
		req.setVareaMercd(new BigDecimal(0));
		req.setVmercHtare(new BigDecimal(0));
		req.setCindcdArea(0);
		req.setVcustoArre(siteUtil.valueToMainframeBigDecimal(areaVo
				.getCustoArrendamento()));
		req.setDinicContr(areaVo.getInicioContrato().replace("/", "."));
		req.setDfimContr(areaVo.getFimContrato().replace("/", "."));

		try {
			this.adapterCWS.invokeProcessFromNC(request, response, "RICCIACC");
		} catch (ConnectorExecutionException e) {
			siteUtil.throwException("RICCIACC", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.service.business.questionarioagronegocio.
	 * IQuestionarioAgronegocioService#listarAreaArrendada(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public GraosFibrasVO listarAreaArrendada(String tipoProduto,
			String codGrupo, String codRelatorio) throws RiccException {
		ConsultarAreaProdutoRequest request = new ConsultarAreaProdutoRequest();
		ConsultarAreaProdutoResponse response = new ConsultarAreaProdutoResponse();
		request.setRICCWA5ERequest(new RICCWA5ERequest());
		response.setRICCWA5SResponse(new RICCWA5SResponse());
		RICCWA5SResponse saida = null;
		GraosFibrasVO vo = new GraosFibrasVO();
		vo.setListaAreaArrendada(new ArrayList<AreaArrendadaAgronegocioVO>());

		request.getRICCWA5ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(codGrupo));
		request.getRICCWA5ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(codRelatorio));
		request.getRICCWA5ERequest().setCtpoArea(
				siteUtil.tratarParametroInteger(tipoProduto));
		request.getRICCWA5ERequest().setNversaoOrige(Numeros.ZERO);
		request.getRICCWA5ERequest().setFILLER4("");
		request.getRICCWA5ERequest().setMaxOcorr(Numeros.CINQUENTA);

		try {
			saida = invokeProcessAutoPagination(request, response, "RICCIAA5",
					RICCWA5SResponseRegistroAreaSaida.class)
					.getRICCWA5SResponse();
		} catch (ConnectorExecutionException e) {
			siteUtil.throwException("RICCIAA5", e);
		}

		vo.setSomaAreaTotalArrendada(Long.toString(saida.getQtotAreaTot()));
		vo.setSomaAreaProdutivaArrendada(Long.toString(saida.getQtotAreaProd()));
		vo.setSomaCustoArrendamento(saida.getVtotCustArre().toString());
		for (RICCWA5SResponseRegistroAreaSaida item : saida.getAreaSaida()) {
			AreaArrendadaAgronegocioVO area = new AreaArrendadaAgronegocioVO();
			area.setNumSequencial(item.getNareaProtr());
			area.setDescricao(item.getRareaProtr());
			area.setAreaTotal(siteUtil.formatValoresToStringInteger(String
					.valueOf(item.getQareaHtare())));
			area.setAreaProdutiva(siteUtil.formatValoresToStringInteger(String
					.valueOf(item.getQareaPrdtv())));
			area.setCidade(item.getRciddeArea());
			area.setCustoArrendamento(siteUtil.formatValoresToString(item
					.getVcustoArre().toString()));
			area.setInicioContrato(item.getDinicContr().replace(".", "/"));
			area.setFimContrato(item.getDfimContr().replace(".", "/"));
			vo.getListaAreaArrendada().add(area);
		}
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.service.business.questionarioagronegocio.
	 * IQuestionarioAgronegocioService#consultarGrao(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public List<GraoFibraAux> consultarGraosFibras(
			QuestionarioAgronegocioVO questionario, int codigoTipoRamo)
			throws RiccException {
		ConsultarGraosFibrasRequest request = new ConsultarGraosFibrasRequest();
		ConsultarGraosFibrasResponse response = new ConsultarGraosFibrasResponse();

		request.setRICCWA6ERequest(new RICCWA6ERequest());
		request.getRICCWA6ERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWA6ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWA6ERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWA6ERequest().setCtpoRamo(codigoTipoRamo);

		List<GraoFibraAux> listaSaida = new ArrayList<GraoFibraAux>();

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAA6");

			for (RICCWA6SResponseRegistroAreaSaida item : response
					.getRICCWA6SResponse().getAreaSaida()) {
				GraoFibraAux saida = new GraoFibraAux();
				saida.setAnoSafra(item.getAnoSafra());

				saida.setNprodRelat(item.getNprodRelat());

				saida.setAreaArrendNull(item.getAreaArrendNull());
				saida.setAreaArrend(item.getAreaArrend());

				saida.setAreaPropr(item.getAreaPropr());
				saida.setAreaProprNull(item.getAreaProprNull());

				saida.setCarocoAHect(item.getCarocoAHect());
				saida.setCarocoAHectNull(item.getCarocoAHectNull());

				// saida.setCarocoArroba(item.getCarocoArroba());
				// saida.setCarocoArrobaNull(item.getCarocoArrobaNull());

				saida.setFibrilhaAHect(item.getFibrilhaAHect());
				saida.setFibrilhaAHectNull(item.getFibrilhaAHectNull());

				// saida.setFibrilhaArroba(item.getFibrilhaArroba());
				// saida.setFibrilhaArrobaNull(item.getFibrilhaArrobaNull());

				saida.setPlumaAHect(item.getPlumaAHect());
				saida.setPlumaAHectNull(item.getPlumaAHectNull());

				// saida.setPlumaArroba(item.getPlumaArroba());
				// saida.setPlumaArrobaNull(item.getPlumaArrobaNull());

				saida.setProdGrao(item.getProdGrao());
				saida.setProdGraoNull(item.getProdGraoNull());

				saida.setProdSemnt(item.getProdSemnt());
				saida.setProdSemntNull(item.getProdSemntNull());

				saida.setProdSemntKg(item.getProdSemntKg());
				saida.setProdSemntKgNull(item.getProdSemntKgNull());

				saida.setProdutivKg(item.getProdutivKg());
				saida.setProdutivKgNull(item.getProdutivKgNull());

				saida.setPvolGraoFix(item.getPvolGraoFix());
				saida.setPvolGraoFixNull(item.getPvolGraoFixNull());

				saida.setPvolPlumaFix(item.getPvolPlumaFix());
				saida.setPvolGraoFixNull(item.getPvolGraoFixNull());

				saida.setPvolPlumaFix(item.getPvolPlumaFix());
				saida.setPvolPlumaFixNull(item.getPvolPlumaFixNull());

				saida.setVcustoProd(item.getVcustoProd().setScale(0,
						BigDecimal.ROUND_UP));
				saida.setVcustoProdNull(item.getVcustoProdNull());

				saida.setVmedCaroco(item.getVmedCaroco());
				saida.setVmedCarocoNull(item.getVmedCarocoNull());

				saida.setVmedFibrilha(item.getVmedFibrilha());
				saida.setVmedFibrilhaNull(item.getVmedFibrilhaNull());

				saida.setVmedGrao(item.getVmedGrao());
				saida.setVmedGraoNull(item.getVmedGraoNull());

				saida.setVmedGraoFix(item.getVmedGraoFix());
				saida.setVmedGraoFixNull(item.getVmedGraoFixNull());

				saida.setVmedPluma(item.getVmedPluma());
				saida.setVmedPlumaNull(item.getVmedPlumaNull());

				saida.setVmedPlumaFix(item.getVmedPlumaFix());
				saida.setVmedPlumaFixNull(item.getVmedPlumaFixNull());

				saida.setVmedSemnt(item.getVmedSemnt());
				saida.setVmedSemntNull(item.getVmedSemntNull());

				saida.setVmedSemntKg(item.getVmedSemntKg());
				saida.setVmedSemntKgNull(item.getVmedSemntKgNull());

				listaSaida.add(saida);

			}

		} catch (ConnectorExecutionException e) {
			siteUtil.throwException("RICCIAA6", e);
		}

		return listaSaida;
	}

	public void manutencaoNomeUsina(QuestionarioAgronegocioVO questionario,
			UsinasVO usinas, TipoManutencaoEnum tipoManutencao) {
		ManutRelAgricolaRequest request = new ManutRelAgricolaRequest();
		ManutRelAgricolaResponse response = new ManutRelAgricolaResponse();

		request.getRICCWCJERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWCJERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCJERequest().setCtpoManut(tipoManutencao.getCodigo());
		request.getRICCWCJERequest().setCtpoRelato(3);
		request.getRICCWCJERequest().setIusinaAcucr(usinas.getNomeUsina());
		request.getRICCWCJERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACJ");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACJ", e);
		}

	}

	public String consultaNomeUsina(QuestionarioAgronegocioVO questionario) {
		DetalharRelAgricolaRequest request = new DetalharRelAgricolaRequest();
		DetalharRelAgricolaResponse response = new DetalharRelAgricolaResponse();
		request.getRICCWBDERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBDERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBDERequest().setCtpoRelato(3);
		request.getRICCWBDERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABD");
			questionario.getAbaUsinas().setNomeUsina(
					response.getRICCWBDSResponse().getIusinaAcucr());
			return response.getRICCWBDSResponse().getIusinaAcucr();
		} catch (Exception e) {
			siteUtil.throwException("RICCIABD", e);
		}

		return null;

	}

	public void manutencaoUsinas(QuestionarioAgronegocioVO questionario,
			List<QuestionarioAgronegocioBean.ObjectUsinas> usinas) {
		ManutUsinasRequest request = new ManutUsinasRequest();
		ManutUsinasResponse response = new ManutUsinasResponse();

		request.getRICCWCEERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWCEERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCEERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<RICCWCEERequestRegistroAreaEntrada> listaEntrada = new ArrayList<RICCWCEERequestRegistroAreaEntrada>();

		for (QuestionarioAgronegocioBean.ObjectUsinas usina : usinas) {

			RICCWCEERequestRegistroAreaEntrada ano = new RICCWCEERequestRegistroAreaEntrada();

			ano.setNusinaAcucr(usina.getNumSequencialUsina());

			// MOAGEM
			final MoagemUsinasVO moagem = usina.getMoagem();
			ano.setAnoSafra(moagem.getAno());
			ano.setCapacMoagem(siteUtil.nullToLong(siteUtil
					.retirarMascaraNumericos(moagem.getCapacidadeMoagem())));
			ano.setCapacMoagemNull(siteUtil.checkNullEntrada(moagem
					.getCapacidadeMoagem()));
			ano.setCanaPropr(siteUtil.valueToMainframeBigDecimal(moagem
					.getCanaAreaPropria()));
			ano.setCanaProprNull(siteUtil.checkNullEntrada(moagem
					.getCanaAreaPropria()));
			ano.setCanaArrend(siteUtil.valueToMainframeBigDecimal(moagem
					.getCanaAreaArrendada()));
			ano.setCanaArrendNull(siteUtil.checkNullEntrada(moagem
					.getCanaAreaArrendada()));
			ano.setCanaTerceiro(siteUtil.valueToMainframeBigDecimal(moagem
					.getCanaTerceiros()));
			ano.setCanaTerceiroNull(siteUtil.checkNullEntrada(moagem
					.getCanaTerceiros()));
			ano.setTotMoagem(siteUtil.valueToMainframeBigDecimal(moagem
					.getTotalMoagem()));
			ano.setTotMoagemNull(siteUtil.checkNullEntrada(moagem
					.getTotalMoagem()));

			// TERRA
			final TerraUsinasVO terra = usina.getTerra();
			ano.setAreaPropr(siteUtil.nullToLong(siteUtil
					.retirarMascaraNumericos(terra.getAreaPropria())));
			ano.setAreaProprNull(siteUtil.checkNullEntrada(terra
					.getAreaPropria()));
			ano.setAreaArrend(siteUtil.nullToLong(siteUtil
					.retirarMascaraNumericos(terra.getAreaArrendada())));
			ano.setAreaArrendNull(siteUtil.checkNullEntrada(terra
					.getAreaArrendada()));

			ano.setAreaRenov(siteUtil.nullToLong(siteUtil
					.retirarMascaraNumericos(terra.getAreaRenovacao())));
			ano.setAreaRenovNull(siteUtil.checkNullEntrada(terra
					.getAreaRenovacao()));
			ano.setAreaExpans(siteUtil.nullToLong(siteUtil
					.retirarMascaraNumericos(terra.getAreaExpansao())));
			ano.setAreaExpansNull(siteUtil.checkNullEntrada(terra
					.getAreaExpansao()));

			// ÁREA DE CORTE
			final AreaCorteUsinasVO areaCorte = usina.getAreaCorte();
			ano.setIdadeMed(siteUtil.valueToMainframeBigDecimal(areaCorte
					.getIdadeMediaCanavial()));
			ano.setIdadeMedNull(siteUtil.checkNullEntrada(areaCorte
					.getIdadeMediaCanavial()));
			ano.setColheitaMecan(siteUtil.valueToMainframeBigDecimal(areaCorte
					.getPorcentagemColheitaMecanizada()));
			ano.setColheitaMecanNull(siteUtil.checkNullEntrada(areaCorte
					.getPorcentagemColheitaMecanizada()));
			ano.setRaioMed(siteUtil.valueToMainframeBigDecimal(areaCorte
					.getRaioMedioCanavial()));
			ano.setRaioMedNull(siteUtil.checkNullEntrada(areaCorte
					.getRaioMedioCanavial()));

			// PRODUTIVIDADE
			final ProdutividadeUsinasVO produtividade = usina
					.getProdutividade();
			ano.setProdIndus(siteUtil.nullToLong(siteUtil
					.retirarMascaraNumericos(produtividade
							.getProducaoIndustrial())));
			ano.setProdIndusNull(siteUtil.checkNullEntrada(produtividade
					.getProducaoIndustrial()));

			// COGERAÇÃO DE ENERGIA
			final CogeracaoEnergiaUsinasVO cogeracaoEnergias = usina
					.getCogeracaoEnergias();
			ano.setPotencInstal(siteUtil.nullToLong(siteUtil
					.retirarMascaraNumericos(cogeracaoEnergias
							.getPotenciaInstalada())));
			ano.setPotencInstalNull(siteUtil.checkNullEntrada(cogeracaoEnergias
					.getPotenciaInstalada()));
			ano.setTotEnergiaVend(siteUtil.nullToLong(siteUtil
					.retirarMascaraNumericos(cogeracaoEnergias
							.getTotalEnergiaVendida())));
			ano.setTotEnergiaVendNull(siteUtil
					.checkNullEntrada(cogeracaoEnergias
							.getTotalEnergiaVendida()));
			ano.setFaturamento(siteUtil
					.valueToMainframeBigDecimal(cogeracaoEnergias
							.getFaturamento()));
			ano.setFaturamentoNull(siteUtil.checkNullEntrada(cogeracaoEnergias
					.getFaturamento()));

			listaEntrada.add(ano);

		}

		request.getRICCWCEERequest().setAreaEntrada(listaEntrada);

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACE");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACE", e);
		}

	}

	public List<QuestionarioAgronegocioBean.ObjectUsinas> consultaUsinas(
			QuestionarioAgronegocioVO questionario) {
		ConsultarUsinasRequest request = new ConsultarUsinasRequest();
		ConsultarUsinasResponse response = new ConsultarUsinasResponse();

		request.getRICCWA7ERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWA7ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWA7ERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<QuestionarioAgronegocioBean.ObjectUsinas> listaSaida = new ArrayList<QuestionarioAgronegocioBean.ObjectUsinas>();

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAA7");
			for (RICCWA7SResponseRegistroAreaSaida item : response
					.getRICCWA7SResponse().getAreaSaida()) {
				listaSaida
						.add(new QuestionarioAgronegocioBean().new ObjectUsinas(
								item));
			}

		} catch (Exception e) {
			siteUtil.throwException("RICCIAA7", e);
		}

		return listaSaida;

	}

	public void manutencaoProducaoUsinas(
			QuestionarioAgronegocioVO questionario,
			List<QuestionarioAgronegocioBean.ObjectUsinas> usinas) {

		ManutProducaoUsinasRequest request = new ManutProducaoUsinasRequest();
		ManutProducaoUsinasResponse response = new ManutProducaoUsinasResponse();

		request.getRICCWCFERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWCFERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCFERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<RICCWCFERequestRegistroAreaEntrada> listaEntrada = new ArrayList<RICCWCFERequestRegistroAreaEntrada>();

		for (QuestionarioAgronegocioBean.ObjectUsinas usina : usinas) {

			RICCWCFERequestRegistroAreaEntrada ano = new RICCWCFERequestRegistroAreaEntrada();

			// PRODUÇÃO
			ProducaoUsinasVO producao = usina.getProducao();
			ano.setDanoSafraAnt(producao.getAno());
			ano.setDanoSafraNovo(producao.getAno());
			ano.setAcrCristal(siteUtil.valueToMainframeBigDecimal(producao
					.getAcucarCristal()));
			ano.setAcrCristalN(siteUtil.checkNullEntrada(producao
					.getAcucarCristal()));
			ano.setAcrVhp(siteUtil.valueToMainframeBigDecimal(producao
					.getAcucarVhp()));
			ano.setAcrVhpN(siteUtil.checkNullEntrada(producao.getAcucarVhp()));
			ano.setAcrOrga(siteUtil.valueToMainframeBigDecimal(producao
					.getAcucarOrganico()));
			ano.setAcrOrgaN(siteUtil.checkNullEntrada(producao
					.getAcucarOrganico()));
			ano.setEtaAni(siteUtil.valueToMainframeBigDecimal(producao
					.getEtanolAnidro()));
			ano.setEtaAniN(siteUtil.checkNullEntrada(producao.getEtanolAnidro()));
			ano.setEtaHidra(siteUtil.valueToMainframeBigDecimal(producao
					.getEtanolHidratado()));
			ano.setEtaHidraN(siteUtil.checkNullEntrada(producao
					.getEtanolHidratado()));
			ano.setEtaOrga(siteUtil.valueToMainframeBigDecimal(producao
					.getEtanolOrganico()));
			ano.setEtaOrgaN(siteUtil.checkNullEntrada(producao
					.getEtanolOrganico()));

			listaEntrada.add(ano);

		}

		request.getRICCWCFERequest().setAreaEntrada(listaEntrada);

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACF");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACF", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.service.business.questionarioagronegocio.
	 * IQuestionarioAgronegocioService
	 * #manutencaoGrao(br.com.bradesco.web.ricc.model
	 * .cadastro.questionarioagronegocio.TipoGraoVO, java.lang.String)
	 */
	@Override
	public void manutencaoGraosFibra(QuestionarioAgronegocioVO questionario,
			List<GraoFibraAux> lista, int codTpoRamo) throws RiccException {

		ManutGraosFibrasRequest request = new ManutGraosFibrasRequest();
		ManutGraosFibrasResponse response = new ManutGraosFibrasResponse();

		/**
		 * codTpoRamo 1 e 2 - Grãos 3 - Fibras
		 */

		request.setRICCWCDERequest(new RICCWCDERequest());
		request.getRICCWCDERequest().setCtpoManut(1);
		request.getRICCWCDERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCDERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWCDERequest().setCtpoRamo(codTpoRamo);

		List<RICCWCDERequestRegistroAreaEntrada> listaEntrada = new ArrayList<RICCWCDERequestRegistroAreaEntrada>();

		for (int j = 0; j < lista.size(); j++) {

			RICCWCDERequestRegistroAreaEntrada entrada = new RICCWCDERequestRegistroAreaEntrada();

			entrada.setAnoSafra(lista.get(j).getAnoSafra());

			entrada.setNprodRelat(j + 1);

			entrada.setAreaProprNull(lista.get(j).getAreaProprNull());
			entrada.setAreaPropr(lista.get(j).getAreaPropr());

			entrada.setAreaArrendNull(lista.get(j).getAreaArrendNull());
			entrada.setAreaArrend(lista.get(j).getAreaArrend());

			entrada.setVcustoProdNull(lista.get(j).getVcustoProdNull());
			entrada.setVcustoProd(lista.get(j).getVcustoProd());

			/********************************************************
			 * GRÃOS
			 */

			entrada.setProdutivKgNull(lista.get(j).getProdutivKgNull());
			entrada.setProdutivKg(lista.get(j).getProdutivKg());

			/*
			 * CAMPO PRODUÇÃO TOTAL FALTANDO?
			 */

			entrada.setProdGraoNull(lista.get(j).getProdGraoNull());
			entrada.setProdGrao(lista.get(j).getProdGrao());

			entrada.setProdSemntNull(lista.get(j).getProdSemntNull());
			entrada.setProdSemnt(lista.get(j).getProdSemnt());

			entrada.setProdSemntKgNull(lista.get(j).getProdSemntKgNull());
			entrada.setProdSemntKg(lista.get(j).getProdSemntKg());

			entrada.setVmedGraoNull(lista.get(j).getVmedGraoNull());
			entrada.setVmedGrao(lista.get(j).getVmedGrao());

			entrada.setVmedSemntNull(lista.get(j).getVmedSemntNull());
			entrada.setVmedSemnt(lista.get(j).getVmedSemnt());

			entrada.setVmedSemntKgNull(lista.get(j).getVmedSemntKgNull());
			entrada.setVmedSemntKg(lista.get(j).getVmedSemntKg());

			entrada.setPvolGraoFixNull(lista.get(j).getPvolGraoFixNull());
			entrada.setPvolGraoFix(lista.get(j).getPvolGraoFix());

			entrada.setVmedGraoFixNull(lista.get(j).getVmedGraoFixNull());
			entrada.setVmedGraoFix(lista.get(j).getVmedGraoFix());

			/********************************************************
			 * FIBRAS
			 */

			entrada.setPlumaAHectNull(lista.get(j).getPlumaAHectNull());
			entrada.setPlumaAHect(lista.get(j).getPlumaAHect());

			entrada.setCarocoAHectNull(lista.get(j).getCarocoAHectNull());
			entrada.setCarocoAHect(lista.get(j).getCarocoAHect());

			entrada.setFibrilhaAHectNull(lista.get(j).getFibrilhaAHectNull());
			entrada.setFibrilhaAHect(lista.get(j).getFibrilhaAHect());

			// entrada.setPlumaArrobaNull(checkNullEntrada(lista.get(j).getPlumaArroba()));
			// entrada.setPlumaArroba(lista.get(j).getPlumaArroba());

			// entrada.setCarocoArrobaNull(checkNullEntrada(lista.get(j).getCarocoArroba()));
			// entrada.setCarocoArroba(lista.get(j).getCarocoArroba());

			// entrada.setFibrilhaArrobaNull(checkNullEntrada(lista.get(j).getFibrilhaArroba()));
			// entrada.setFibrilhaArroba(lista.get(j).getFibrilhaArroba());

			entrada.setVmedPlumaNull(lista.get(j).getVmedPlumaNull());
			entrada.setVmedPluma(lista.get(j).getVmedPluma());

			entrada.setVmedCarocoNull(lista.get(j).getVmedCarocoNull());
			entrada.setVmedCaroco(lista.get(j).getVmedCaroco());

			entrada.setVmedFibrilhaNull(lista.get(j).getVmedFibrilhaNull());
			entrada.setVmedFibrilha(lista.get(j).getVmedFibrilha());

			entrada.setPvolPlumaFixNull(lista.get(j).getPvolPlumaFixNull());
			entrada.setPvolPlumaFix(lista.get(j).getPvolPlumaFix());

			entrada.setVmedPlumaFixNull(lista.get(j).getVmedPlumaFixNull());
			entrada.setVmedPlumaFix(lista.get(j).getVmedPlumaFix());

			listaEntrada.add(entrada);
		}

		request.getRICCWCDERequest().setAreaEntrada(listaEntrada);

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACD");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACD", e);
		}
	}

	public List<QuestionarioAgronegocioBean.ObjectUsinas> consultaProducaoUsinas(
			QuestionarioAgronegocioVO questionario) {

		ConsultarProdUsinasRequest request = new ConsultarProdUsinasRequest();
		ConsultarProdUsinasResponse response = new ConsultarProdUsinasResponse();

		request.getRICCWA8ERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWA8ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWA8ERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<QuestionarioAgronegocioBean.ObjectUsinas> listaSaida = new ArrayList<QuestionarioAgronegocioBean.ObjectUsinas>();

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAA8");
			for (RICCWA8SResponseRegistroAreaSaida item : response
					.getRICCWA8SResponse().getAreaSaida()) {
				listaSaida
						.add(new QuestionarioAgronegocioBean().new ObjectUsinas(
								item));
			}

		} catch (Exception e) {
			siteUtil.throwException("RICCIAA8", e);
		}

		return listaSaida;

	}

	@Override
	public void manutencaoNomeProdutor(QuestionarioAgronegocioVO agro,
			TipoManutencaoEnum tipoManutencao) {
		ManutAreaProdutorRequest request = new ManutAreaProdutorRequest();
		ManutAreaProdutorResponse response = new ManutAreaProdutorResponse();
		request.setRICCWCCERequest(new RICCWCCERequest());

		RICCWCCERequest req = request.getRICCWCCERequest();

		req.setCgrpEconm(siteUtil.tratarParametroInteger(agro.getCodGrupo()));
		req.setNrelatCredt(siteUtil.tratarParametroInteger(agro
				.getCodRelatorio()));
		req.setNversaoOrige(Numeros.ZERO);
		req.setCtpoArea(Numeros.ZERO);
		req.setCtpoManut(tipoManutencao.getCodigo());

		req.setIprotrAgri(agro.getAbaGraos().getNomeProdutor());
		req.setRareaProtr(RiccConstants.VAZIO);
		req.setQareaHtare(Numeros.ZERO);
		req.setQareaPrdtv(Numeros.ZERO);
		req.setRciddeArea(RiccConstants.VAZIO);
		req.setVareaMercd(Numeros.ZERO_BIG);
		req.setVmercHtare(Numeros.ZERO_BIG);
		req.setCindcdArea(Numeros.ZERO);
		req.setVcustoArre(Numeros.ZERO_BIG);
		req.setDinicContr(RiccConstants.VAZIO);
		req.setDfimContr(RiccConstants.VAZIO);

		try {
			this.adapterCWS.invokeProcessFromNC(request, response, "RICCIACC");
		} catch (ConnectorExecutionException e) {
			siteUtil.throwException("RICCIACC", e);
		}

	}

}
