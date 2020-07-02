package br.com.bradesco.web.ricc.service.business.questionariotransportes.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CapitalInvestidoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CustosOperacionaisVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.DadosTransportesDatabaseVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.FaturamentoEbitdaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.LocadorasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.PercentualFaturamentoEbitdaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TipoContratosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesCargasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesPassageirosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.ValoresLocadorasVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.request.ConsultarCapitalInveRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.request.RICCWASERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response.ConsultarCapitalInveResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response.RICCWASSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response.RICCWASSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.request.ConsultarContrTranspRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.request.RICCWAUERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.response.ConsultarContrTranspResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.response.RICCWAUSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.response.RICCWAUSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.request.ConsultarCustosOpRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.request.RICCWAQERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response.ConsultarCustosOpResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response.RICCWAQSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response.RICCWAQSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.request.ConsultarFatEmpresasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.request.RICCWARERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.response.ConsultarFatEmpresasResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.response.RICCWARSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.response.RICCWARSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.request.ConsultarLocVeiculosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.request.RICCWAVERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response.ConsultarLocVeiculosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response.RICCWAVSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response.RICCWAVSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.request.ConsultarTranspPassaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.request.RICCWATERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response.ConsultarTranspPassaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response.RICCWATSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response.RICCWATSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.request.ConsultarTransporteRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.request.RICCWAPERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response.ConsultarTransporteResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response.RICCWAPSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response.RICCWAPSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.request.DetalharRelTranspRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.request.RICCWBFERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.response.DetalharRelTranspResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.response.RICCWBFSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapitalInvest.request.ManutCapitalInvestRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapitalInvest.request.RICCWBZERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapitalInvest.request.RICCWBZERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapitalInvest.response.ManutCapitalInvestResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCustosOperacion.request.ManutCustosOperacionRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCustosOperacion.request.RICCWBXERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCustosOperacion.request.RICCWBXERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCustosOperacion.response.ManutCustosOperacionResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request.ManutFatEmpresaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request.RICCWBYERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request.RICCWBYERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.response.ManutFatEmpresaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutLocVeiculos.request.ManutLocVeiculosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutLocVeiculos.request.RICCWB2ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutLocVeiculos.request.RICCWB2ERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutLocVeiculos.response.ManutLocVeiculosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.request.ManutRelTransporteRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.request.RICCWCLERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.response.ManutRelTransporteResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspCargas.request.ManutTranspCargasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspCargas.request.RICCWBWERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspCargas.request.RICCWBWERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspCargas.response.ManutTranspCargasResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassagei.request.ManutTranspPassageiRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassagei.request.RICCWB1ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassagei.request.RICCWB1ERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassagei.response.ManutTranspPassageiResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request.ManutTranspPassasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request.RICCWB0ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request.RICCWB0ERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.response.ManutTranspPassasResponse;
import br.com.bradesco.web.ricc.service.business.BaseService;
import br.com.bradesco.web.ricc.service.business.questionariotransportes.IQuestionarioTransportesService;
import br.com.bradesco.web.ricc.utils.RiccConstants;

@Named("questionarioTransportesService")
public class QuestionarioTransportesServiceImpl extends BaseService implements
		IQuestionarioTransportesService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 92916449635830735L;

	@Override
	public void manutencaoDadosSetorTransportes(
			QuestionarioTransportesVO questionario, String tipoManutencao) {

		ManutRelTransporteRequest request = new ManutRelTransporteRequest();
		ManutRelTransporteResponse response = new ManutRelTransporteResponse();

		request.setRICCWCLERequest(new RICCWCLERequest());

		request.getRICCWCLERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWCLERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWCLERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCLERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		DadosTransportesDatabaseVO transportes = questionario
				.getDadosTransportesDatabase();
		if (transportes.getDatabase() != null) {
			request.getRICCWCLERequest().setDbaseInfo(
					dateUtil.dateToString(transportes.getDatabase(),
							RiccConstants.FORMATO_DIA_MES_ANO));
		} else {
			request.getRICCWCLERequest().setDbaseInfo("");
		}
		request.getRICCWCLERequest().setQveicFrota(
				siteUtil.tratarParametroInteger(transportes.getQtdVeiculos()));
		request.getRICCWCLERequest()
				.setVveicFrota(
						siteUtil.valueToMainframeBigDecimal(transportes
								.getValorFrota()));
		request.getRICCWCLERequest().setVsdoDvdorFrt(
				siteUtil.valueToMainframeBigDecimal(transportes
						.getSaldoDevedorFinameLeasing()));
		request.getRICCWCLERequest().setPgrauAlieFrt(
				siteUtil.valueToMainframeBigDecimal("0"));// transportes.getPrcGrauAlienacaoFrota().replace(".",
															// ",")));
		request.getRICCWCLERequest()
				.setNidadeMedFrt(
						siteUtil.tratarParametroInteger(transportes
								.getIdadeMediaAnos()));
		request.getRICCWCLERequest().setVmesFinanFrt(
				siteUtil.valueToMainframeBigDecimal(transportes
						.getDesembolsoMensalFinameLeasing()));
		request.getRICCWCLERequest().setVmesCaptlGro(
				siteUtil.valueToMainframeBigDecimal(transportes
						.getDesembolsoMensalCagiro()));
		request.getRICCWCLERequest().setVfatmtMedMes(
				siteUtil.valueToMainframeBigDecimal(transportes
						.getFaturamentoMedioMensal()));
		request.getRICCWCLERequest().setPcompmRecta(
				siteUtil.valueToMainframeBigDecimal("0"));// transportes.getPrcGrauComprometimentoReceitasComFinameLeasing().replace(".",
															// ",")));
		request.getRICCWCLERequest().setPcompmCaptl(
				siteUtil.valueToMainframeBigDecimal("0"));// transportes.getPrcGrauComprometimentoReceitasComFinameLeasingCagiro().replace(".",
															// ",")));
		request.getRICCWCLERequest().setPfrotaPrpia(
				siteUtil.valueToMainframeBigDecimal(transportes
						.getPrcFrotaPropria()));
		request.getRICCWCLERequest().setPultExerc(
				siteUtil.valueToMainframeBigDecimal(transportes
						.getPrcMargemEbitdaUltimoExercicio()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACL");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACL", e);
		}
	}

	@Override
	public DadosTransportesDatabaseVO consultaDadosSetorTransportes(
			QuestionarioTransportesVO questionario) {

		DetalharRelTranspRequest request = new DetalharRelTranspRequest();
		DetalharRelTranspResponse response = new DetalharRelTranspResponse();

		request.setRICCWBFERequest(new RICCWBFERequest());

		request.getRICCWBFERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBFERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBFERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWBFSResponse(new RICCWBFSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABF");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABF", e);
		}

		DadosTransportesDatabaseVO vo = new DadosTransportesDatabaseVO();

		RICCWBFSResponse _saida = response.getRICCWBFSResponse();
		vo.setDatabase(dateUtil.transformarStringParaDate(
				_saida.getDbaseInfo(), RiccConstants.FORMATO_DIA_MES_ANO));
		// if (siteUtil.isNotEmptyOrNull(vo.getDatabase())) {
		if (_saida.getQveicFrota() != 0) {
			vo.setQtdVeiculos(String.valueOf(_saida.getQveicFrota()));
		}
		if (!siteUtil.isEmptyZeroOrNull(_saida.getVveicFrota())) {
			vo.setValorFrota(_saida.getVveicFrota()
					.setScale(0, BigDecimal.ROUND_UP).toString());
		}
		if (!siteUtil.isEmptyZeroOrNull(_saida.getVsdoDvdorFrt())) {
			vo.setSaldoDevedorFinameLeasing(_saida.getVsdoDvdorFrt()
					.setScale(0, BigDecimal.ROUND_UP).toString());
		}
		vo.setPrcGrauAlienacaoFrota(_saida.getPgrauAlieFrt().toString());
		if (_saida.getNidadeMedFrt() != 0) {
			vo.setIdadeMediaAnos(String.valueOf(_saida.getNidadeMedFrt()));
		}
		if (!siteUtil.isEmptyZeroOrNull(_saida.getVmesFinanFrt())) {
			vo.setDesembolsoMensalFinameLeasing(_saida.getVmesFinanFrt()
					.setScale(0, BigDecimal.ROUND_UP).toString());
		}
		if (!siteUtil.isEmptyZeroOrNull(_saida.getVmesCaptlGro())) {
			vo.setDesembolsoMensalCagiro(_saida.getVmesCaptlGro()
					.setScale(0, BigDecimal.ROUND_UP).toString());
		}
		if (!siteUtil.isEmptyZeroOrNull(_saida.getVfatmtMedMes())) {
			vo.setFaturamentoMedioMensal(_saida.getVfatmtMedMes()
					.setScale(0, BigDecimal.ROUND_UP).toString());
		}
		vo.setPrcGrauComprometimentoReceitasComFinameLeasing(_saida
				.getPcompmRecta().toString());
		vo.setPrcGrauComprometimentoReceitasComFinameLeasingCagiro(_saida
				.getPcompmCaptl().toString());
		if (!siteUtil.isEmptyZeroOrNull(_saida.getPfrotaPrpia())) {
			vo.setPrcFrotaPropria(_saida.getPfrotaPrpia().toString());
		}
		if (!siteUtil.isEmptyZeroOrNull(_saida.getPultExerc())) {
			vo.setPrcMargemEbitdaUltimoExercicio(_saida.getPultExerc()
					.toString());
		}
		// }

		return vo;
	}

	@Override
	public void manutencaoAberturaFaturamentoEmpresa(
			QuestionarioTransportesVO questionario) {

		ManutFatEmpresaRequest request = new ManutFatEmpresaRequest();
		ManutFatEmpresaResponse response = new ManutFatEmpresaResponse();

		request.setRICCWBYERequest(new RICCWBYERequest());

		FaturamentoEbitdaVO _objInput = questionario.getFaturamentoEbitda();

		request.getRICCWBYERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBYERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBYERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBYERequest().setRtpoFatmt(
				siteUtil.tratarParametroString(_objInput
						.getDescReceitasPorSegmentoOutros()));

		List<RICCWBYERequestRegistroAreaEntrada> _listaEntrada = request
				.getRICCWBYERequest().getAreaEntrada();

		PercentualFaturamentoEbitdaVO _prcFaturamento = _objInput
				.getPrcFaturamento();
		PercentualFaturamentoEbitdaVO _prcEbitda = _objInput.getPrcEbitda();
		RICCWBYERequestRegistroAreaEntrada _item = null;
		for (int i = 1; i < 9; i++) {
			_item = new RICCWBYERequestRegistroAreaEntrada();
			/*
			 * 1 – Varejo; 2 – Saúde; 3 – Químico; 4 – Agro; 5 – Setor Público;
			 * 6 – Receitas a vista; 7 – Receitas a prazo; 8 – Outros.
			 */
			int cdTipoFaturamento = (i);
			_item.setCtpoFatmt(cdTipoFaturamento);

			String _valorPrcFaturamento = null;
			String _valorPrcEbitda = null;

			switch (cdTipoFaturamento) {
			// Varejo
			case 1:
				_valorPrcFaturamento = _prcFaturamento.getPrcVarejo();
				_valorPrcEbitda = _prcEbitda.getPrcVarejo();
				break;
			// Saúde
			case 2:
				_valorPrcFaturamento = _prcFaturamento.getPrcSaude();
				_valorPrcEbitda = _prcEbitda.getPrcSaude();
				break;
			// Quimico
			case 3:
				_valorPrcFaturamento = _prcFaturamento.getPrcQuimico();
				_valorPrcEbitda = _prcEbitda.getPrcQuimico();
				break;
			// Agro
			case 4:
				_valorPrcFaturamento = _prcFaturamento.getPrcAgro();
				_valorPrcEbitda = _prcEbitda.getPrcAgro();
				break;
			// Setor Publico
			case 5:
				_valorPrcFaturamento = _prcFaturamento.getPrcSetorPublico();
				_valorPrcEbitda = _prcEbitda.getPrcSetorPublico();
				break;
			// Receitas a vista
			case 6:
				_valorPrcFaturamento = _prcFaturamento.getPrcReceitasAVista();
				_valorPrcEbitda = _prcEbitda.getPrcReceitasAVista();
				break;
			// Receitas a prazo
			case 7:
				_valorPrcFaturamento = _prcFaturamento.getPrcReceitasAPrazo();
				_valorPrcEbitda = _prcEbitda.getPrcReceitasAPrazo();
				break;
			// Outros
			case 8:
				_valorPrcFaturamento = _prcFaturamento.getPrcOutros();
				_valorPrcEbitda = _prcEbitda.getPrcOutros();
				break;
			}

			_item.setPfatmtN(siteUtil.checkNullEntrada(_valorPrcFaturamento));
			_item.setPfatmt(siteUtil
					.valueToMainframeBigDecimal(_valorPrcFaturamento));

			_item.setPebitdaN(siteUtil.checkNullEntrada(_valorPrcEbitda));
			_item.setPebitda(siteUtil
					.valueToMainframeBigDecimal(_valorPrcEbitda));

			_listaEntrada.add(_item);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABY");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABY", e);
		}

	}

	@Override
	public FaturamentoEbitdaVO consultaAberturaFaturamentoEmpresa(
			QuestionarioTransportesVO questionario) {

		FaturamentoEbitdaVO _item = new FaturamentoEbitdaVO();

		ConsultarFatEmpresasRequest request = new ConsultarFatEmpresasRequest();
		ConsultarFatEmpresasResponse response = new ConsultarFatEmpresasResponse();

		request.setRICCWARERequest(new RICCWARERequest());

		request.getRICCWARERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWARERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWARERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWARSResponse(new RICCWARSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAR");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAR", e);
		}

		PercentualFaturamentoEbitdaVO _prcFaturamento = _item
				.getPrcFaturamento();
		PercentualFaturamentoEbitdaVO _prcEbitda = _item.getPrcEbitda();
		for (RICCWARSResponseRegistroAreaSaida saida : response
				.getRICCWARSResponse().getAreaSaida()) {

			_item.setDescReceitasPorSegmentoOutros(saida.getRtpoFatmt());

			int cdTipoFaturamento = saida.getCtpoFatmt();
			switch (cdTipoFaturamento) {
			// Varejo
			case 1:
				_prcFaturamento.setPrcVarejo(siteUtil.checkNullSaida(saida
						.getPfatmt().toString(), saida.getPfatmtN()));
				_prcEbitda.setPrcVarejo(siteUtil.checkNullSaida(saida
						.getPebitda().toString(), saida.getPebitdaN()));
				break;
			// Saúde
			case 2:
				_prcFaturamento.setPrcSaude(siteUtil.checkNullSaida(saida
						.getPfatmt().toString(), saida.getPfatmtN()));
				_prcEbitda.setPrcSaude(siteUtil.checkNullSaida(saida
						.getPebitda().toString(), saida.getPebitdaN()));
				break;
			// Quimico
			case 3:
				_prcFaturamento.setPrcQuimico(siteUtil.checkNullSaida(saida
						.getPfatmt().toString(), saida.getPfatmtN()));
				_prcEbitda.setPrcQuimico(siteUtil.checkNullSaida(saida
						.getPebitda().toString(), saida.getPebitdaN()));
				break;
			// Agro
			case 4:
				_prcFaturamento.setPrcAgro(siteUtil.checkNullSaida(saida
						.getPfatmt().toString(), saida.getPfatmtN()));
				_prcEbitda.setPrcAgro(siteUtil.checkNullSaida(saida
						.getPebitda().toString(), saida.getPebitdaN()));
				break;
			// Setor Publico
			case 5:
				_prcFaturamento.setPrcSetorPublico(siteUtil.checkNullSaida(
						saida.getPfatmt().toString(), saida.getPfatmtN()));
				_prcEbitda.setPrcSetorPublico(siteUtil.checkNullSaida(saida
						.getPebitda().toString(), saida.getPebitdaN()));
				break;
			// Receitas a vista
			case 6:
				_prcFaturamento.setPrcReceitasAVista(siteUtil.checkNullSaida(
						saida.getPfatmt().toString(), saida.getPfatmtN()));
				_prcEbitda.setPrcReceitasAVista(siteUtil.checkNullSaida(saida
						.getPebitda().toString(), saida.getPebitdaN()));
				break;
			// Receitas a prazo
			case 7:
				_prcFaturamento.setPrcReceitasAPrazo(siteUtil.checkNullSaida(
						saida.getPfatmt().toString(), saida.getPfatmtN()));
				_prcEbitda.setPrcReceitasAPrazo(siteUtil.checkNullSaida(saida
						.getPebitda().toString(), saida.getPebitdaN()));
				break;
			// Outros
			case 8:
				_prcFaturamento.setPrcOutros(siteUtil.checkNullSaida(saida
						.getPfatmt().toString(), saida.getPfatmtN()));
				_prcEbitda.setPrcOutros(siteUtil.checkNullSaida(saida
						.getPebitda().toString(), saida.getPebitdaN()));
				break;
			}

		}

		return _item;
	}

	@Override
	public List<CustosOperacionaisVO> consultaCustosOperacionais(
			QuestionarioTransportesVO questionario) {

		List<CustosOperacionaisVO> _lista = new ArrayList<CustosOperacionaisVO>();

		ConsultarCustosOpRequest request = new ConsultarCustosOpRequest();
		ConsultarCustosOpResponse response = new ConsultarCustosOpResponse();

		request.setRICCWAQERequest(new RICCWAQERequest());

		request.getRICCWAQERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAQERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAQERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWAQSResponse(new RICCWAQSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAQ");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAQ", e);
		}

		for (RICCWAQSResponseRegistroAreaSaida saida : response
				.getRICCWAQSResponse().getAreaSaida()) {
			CustosOperacionaisVO _item = new CustosOperacionaisVO();

			// tratamento para ignorar ano não prenchido na manutenção
			if (response.getRICCWAQSResponse().getAreaSaida().get(0)
					.getNanoCusto() == 1901) {
				_item.setAno("");
			} else {
				_item.setAno(siteUtil.nullToString(saida.getNanoCusto()));
			}
			if (!"S".equals(saida.getPcustCombsN())) {
				_item.setPrcCombustiveis(saida.getPcustCombs().toPlainString());
			}

			if (!"S".equals(saida.getPcustMdobraN())) {
				_item.setPrcMaoDeObra(saida.getPcustMdobra().toPlainString());
			}

			if (!"S".equals(saida.getPcustOutrosN())) {
				_item.setPrcOutros(saida.getPcustOutros().toPlainString());
			}

			if (!"S".equals(saida.getPcustTotalN())) {
				_item.setPrcTotal(saida.getPcustTotal().toPlainString());
			}

			_lista.add(_item);
		}

		return _lista;
	}

	@Override
	public void manutencaoCustosOperacionais(
			QuestionarioTransportesVO questionario) {
		ManutCustosOperacionRequest request = new ManutCustosOperacionRequest();
		ManutCustosOperacionResponse response = new ManutCustosOperacionResponse();

		request.setRICCWBXERequest(new RICCWBXERequest());

		request.getRICCWBXERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBXERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBXERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<RICCWBXERequestRegistroAreaEntrada> _listaEntrada = request
				.getRICCWBXERequest().getAreaEntrada();

		CustosOperacionaisVO _custoAno1 = questionario
				.getPrincipaisCustosOperacionais().getCustosOperacionaisAno1();
		CustosOperacionaisVO _custoAno2 = questionario
				.getPrincipaisCustosOperacionais().getCustosOperacionaisAno2();
		CustosOperacionaisVO _custoAno3 = questionario
				.getPrincipaisCustosOperacionais().getCustosOperacionaisAno3();
		CustosOperacionaisVO _custoAnoExpectativa = questionario
				.getPrincipaisCustosOperacionais()
				.getCustosOperacionaisAnoExpectativa();

		for (int i = 0; i < 4; i++) {
			RICCWBXERequestRegistroAreaEntrada _item = new RICCWBXERequestRegistroAreaEntrada();

			int _coluna = (i + 1);
			_item.setNcustoOper(_coluna);

			String _ano = null;
			String _prcCombustiveis = null;
			String _prcMaoDeObra = null;
			String _prcOutros = null;
			String _prcTotal = null;

			switch (_coluna) {
			case 1:
				_ano = _custoAno1.getAno();
				_prcCombustiveis = _custoAno1.getPrcCombustiveis();
				_prcMaoDeObra = _custoAno1.getPrcMaoDeObra();
				_prcOutros = _custoAno1.getPrcOutros();
				_prcTotal = _custoAno1.getPrcTotal();
				break;
			case 2:
				_ano = _custoAno2.getAno();
				_prcCombustiveis = _custoAno2.getPrcCombustiveis();
				_prcMaoDeObra = _custoAno2.getPrcMaoDeObra();
				_prcOutros = _custoAno2.getPrcOutros();
				_prcTotal = _custoAno2.getPrcTotal();
				break;
			case 3:
				_ano = _custoAno3.getAno();
				_prcCombustiveis = _custoAno3.getPrcCombustiveis();
				_prcMaoDeObra = _custoAno3.getPrcMaoDeObra();
				_prcOutros = _custoAno3.getPrcOutros();
				_prcTotal = _custoAno3.getPrcTotal();
				break;
			case 4:
				_ano = _custoAnoExpectativa.getAno();
				_prcCombustiveis = _custoAnoExpectativa.getPrcCombustiveis();
				_prcMaoDeObra = _custoAnoExpectativa.getPrcMaoDeObra();
				_prcOutros = _custoAnoExpectativa.getPrcOutros();
				_prcTotal = _custoAnoExpectativa.getPrcTotal();
				break;
			}

			_item.setNanoCusto(siteUtil.nullToInteger(_ano));

			_item.setPcustCombsN(siteUtil.checkNullEntrada(_prcCombustiveis));
			_item.setPcustCombs(siteUtil
					.valueToMainframeBigDecimal(_prcCombustiveis));

			_item.setPcustMdobraN(siteUtil.checkNullEntrada(_prcMaoDeObra));
			_item.setPcustMdobra(siteUtil
					.valueToMainframeBigDecimal(_prcMaoDeObra));

			_item.setPcustOutrosN(siteUtil.checkNullEntrada(_prcOutros));
			_item.setPcustOutros(siteUtil
					.valueToMainframeBigDecimal(_prcOutros));

			_item.setPcustTotalN(siteUtil.checkNullEntrada(_prcTotal));
			_item.setPcustTotal(siteUtil.valueToMainframeBigDecimal(_prcTotal));

			_listaEntrada.add(_item);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABX");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABX", e);
		}

	}

	@Override
	public void manutencaoCapex(QuestionarioTransportesVO questionario) {

		ManutCapitalInvestRequest request = new ManutCapitalInvestRequest();
		ManutCapitalInvestResponse response = new ManutCapitalInvestResponse();

		request.setRICCWBZERequest(new RICCWBZERequest());

		request.getRICCWBZERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBZERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBZERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<RICCWBZERequestRegistroAreaEntrada> _listaEntrada = request
				.getRICCWBZERequest().getAreaEntrada();

		CapitalInvestidoVO _capexAno1 = questionario
				.getPrincipaisCustosOperacionais().getCapexAno1();
		CapitalInvestidoVO _capexAno2 = questionario
				.getPrincipaisCustosOperacionais().getCapexAno2();
		CapitalInvestidoVO _capexAno3 = questionario
				.getPrincipaisCustosOperacionais().getCapexAno3();
		CapitalInvestidoVO _capexAnoExpectativa = questionario
				.getPrincipaisCustosOperacionais().getCapexAnoExpectativa();

		for (int i = 0; i < 4; i++) {
			RICCWBZERequestRegistroAreaEntrada _item = new RICCWBZERequestRegistroAreaEntrada();

			int _coluna = (i + 1);
			_item.setNcaptlInves(_coluna);

			String _ano = null;
			String _valorRecursosProprios = null;
			String _valorRecursosTerceiros = null;

			switch (_coluna) {
			case 1:
				_ano = _capexAno1.getAno();
				_valorRecursosProprios = _capexAno1.getValorRecursosProprios();
				_valorRecursosTerceiros = _capexAno1
						.getValorRecursosTerceiros();
				break;
			case 2:
				_ano = _capexAno2.getAno();
				_valorRecursosProprios = _capexAno2.getValorRecursosProprios();
				_valorRecursosTerceiros = _capexAno2
						.getValorRecursosTerceiros();
				break;
			case 3:
				_ano = _capexAno3.getAno();
				_valorRecursosProprios = _capexAno3.getValorRecursosProprios();
				_valorRecursosTerceiros = _capexAno3
						.getValorRecursosTerceiros();
				break;
			case 4:
				_ano = _capexAnoExpectativa.getAno();
				_valorRecursosProprios = _capexAnoExpectativa
						.getValorRecursosProprios();
				_valorRecursosTerceiros = _capexAnoExpectativa
						.getValorRecursosTerceiros();
				break;
			}

			_item.setNanoCaptl(siteUtil.nullToInteger(_ano));

			_item.setVrecrsPprioN(siteUtil
					.checkNullEntrada(_valorRecursosProprios));
			_item.setVrecrsPprio(siteUtil
					.valueToMainframeBigDecimal(_valorRecursosProprios));
			_item.setVrecrsPprioS(siteUtil
					.getFlgSinalCampo(_valorRecursosProprios));

			_item.setVrecrsTceroN(siteUtil
					.checkNullEntrada(_valorRecursosTerceiros));
			_item.setVrecrsTcero(siteUtil
					.valueToMainframeBigDecimal(_valorRecursosTerceiros));
			_item.setVrecrsTceroS(siteUtil
					.getFlgSinalCampo(_valorRecursosTerceiros));

			_listaEntrada.add(_item);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABZ");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABZ", e);
		}

	}

	@Override
	public List<CapitalInvestidoVO> consultaCapex(
			QuestionarioTransportesVO questionario) {

		List<CapitalInvestidoVO> _lista = new ArrayList<CapitalInvestidoVO>();

		ConsultarCapitalInveRequest request = new ConsultarCapitalInveRequest();
		ConsultarCapitalInveResponse response = new ConsultarCapitalInveResponse();

		request.setRICCWASERequest(new RICCWASERequest());

		request.getRICCWASERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWASERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWASERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWASSResponse(new RICCWASSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAS");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAS", e);
		}

		for (RICCWASSResponseRegistroAreaSaida saida : response
				.getRICCWASSResponse().getAreaSaida()) {
			CapitalInvestidoVO _item = new CapitalInvestidoVO();

			if (response.getRICCWASSResponse().getAreaSaida().get(0)
					.getNanoCaptl() == 1901) {
				_item.setAno("");
			} else {
				_item.setAno(siteUtil.nullToString(saida.getNanoCaptl()));
			}
			if (!"S".equals(saida.getVrecrsPprioN())) {
				String _prcProprio = saida.getVrecrsPprio()
						.setScale(0, BigDecimal.ROUND_UP).toPlainString();
				if ("-".equals(saida.getVrecrsPprioS())) {
					_prcProprio = "-" + _prcProprio;
				}
				_item.setValorRecursosProprios(_prcProprio);
			}

			if (!"S".equals(saida.getVrecrsTceroN())) {
				String _prcTerceiro = saida.getVrecrsTcero()
						.setScale(0, BigDecimal.ROUND_UP).toPlainString();
				if ("-".equals(saida.getVrecrsTceroS())) {
					_prcTerceiro = "-" + _prcTerceiro;
				}
				_item.setValorRecursosTerceiros(_prcTerceiro);
			}

			_lista.add(_item);
		}

		return _lista;
	}

	@Override
	public void manutencaoTiposContratos(QuestionarioTransportesVO questionario) {

		ManutTranspPassageiRequest request = new ManutTranspPassageiRequest();
		ManutTranspPassageiResponse response = new ManutTranspPassageiResponse();

		request.setRICCWB1ERequest(new RICCWB1ERequest());

		request.getRICCWB1ERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWB1ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWB1ERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<RICCWB1ERequestRegistroAreaEntrada> _listaEntrada = request
				.getRICCWB1ERequest().getAreaEntrada();

		TipoContratosVO _tipoAno1 = questionario.getTipoContratosAno1();
		TipoContratosVO _tipoAno2 = questionario.getTipoContratosAno2();
		TipoContratosVO _tipoAno3 = questionario.getTipoContratosAno3();
		TipoContratosVO _tipoAnoExpectativa = questionario
				.getTipoContratosAnoExpectativa();

		for (int i = 0; i < 4; i++) {
			RICCWB1ERequestRegistroAreaEntrada _item = new RICCWB1ERequestRegistroAreaEntrada();

			int _coluna = (i + 1);
			_item.setNcontrEmpr(_coluna);

			String _ano = null;
			String _prcAPerformar = null;
			String _prcTakeOrPay = null;
			String _prcLocacao = null;
			String _prcSpot = null;
			String _prcTotal = null;

			switch (_coluna) {
			case 1:
				_ano = _tipoAno1.getAno();
				_prcAPerformar = _tipoAno1.getPrcAPerformar();
				_prcTakeOrPay = _tipoAno1.getPrcTakeOrPay();
				_prcLocacao = _tipoAno1.getPrcLocacao();
				_prcSpot = _tipoAno1.getPrcSpot();
				_prcTotal = _tipoAno1.getPrcTotal();
				break;
			case 2:
				_ano = _tipoAno2.getAno();
				_prcAPerformar = _tipoAno2.getPrcAPerformar();
				_prcTakeOrPay = _tipoAno2.getPrcTakeOrPay();
				_prcLocacao = _tipoAno2.getPrcLocacao();
				_prcSpot = _tipoAno2.getPrcSpot();
				_prcTotal = _tipoAno2.getPrcTotal();
				break;
			case 3:
				_ano = _tipoAno3.getAno();
				_prcAPerformar = _tipoAno3.getPrcAPerformar();
				_prcTakeOrPay = _tipoAno3.getPrcTakeOrPay();
				_prcLocacao = _tipoAno3.getPrcLocacao();
				_prcSpot = _tipoAno3.getPrcSpot();
				_prcTotal = _tipoAno3.getPrcTotal();
				break;
			case 4:
				_ano = _tipoAnoExpectativa.getAno();
				_prcAPerformar = _tipoAnoExpectativa.getPrcAPerformar();
				_prcTakeOrPay = _tipoAnoExpectativa.getPrcTakeOrPay();
				_prcLocacao = _tipoAnoExpectativa.getPrcLocacao();
				_prcSpot = _tipoAnoExpectativa.getPrcSpot();
				_prcTotal = _tipoAnoExpectativa.getPrcTotal();
				break;
			}

			_item.setNanoContr(siteUtil.nullToInteger(_ano));

			_item.setPperformarN(siteUtil.checkNullEntrada(_prcAPerformar));
			_item.setPperformar(siteUtil
					.valueToMainframeBigDecimal(_prcAPerformar));

			_item.setPtakePayN(siteUtil.checkNullEntrada(_prcTakeOrPay));
			_item.setPtakePay(siteUtil
					.valueToMainframeBigDecimal(_prcTakeOrPay));

			_item.setPlocacaoN(siteUtil.checkNullEntrada(_prcLocacao));
			_item.setPlocacao(siteUtil.valueToMainframeBigDecimal(_prcLocacao));

			_item.setPspotN(siteUtil.checkNullEntrada(_prcSpot));
			_item.setPspot(siteUtil.valueToMainframeBigDecimal(_prcSpot));

			_item.setPtotalN(siteUtil.checkNullEntrada(_prcTotal));
			_item.setPtotal(siteUtil.valueToMainframeBigDecimal(_prcTotal));

			_listaEntrada.add(_item);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB1");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB1", e);
		}

	}

	@Override
	public List<TipoContratosVO> consultaTiposContratos(
			QuestionarioTransportesVO questionario) {

		List<TipoContratosVO> _lista = new ArrayList<TipoContratosVO>();

		ConsultarContrTranspRequest request = new ConsultarContrTranspRequest();
		ConsultarContrTranspResponse response = new ConsultarContrTranspResponse();

		request.setRICCWAUERequest(new RICCWAUERequest());

		request.getRICCWAUERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAUERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAUERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWAUSResponse(new RICCWAUSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAU");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAU", e);
		}

		for (RICCWAUSResponseRegistroAreaSaida saida : response
				.getRICCWAUSResponse().getAreaSaida()) {
			TipoContratosVO _item = new TipoContratosVO();

			if (response.getRICCWAUSResponse().getAreaSaida().get(0)
					.getNanoContr() == 1901) {
				_item.setAno("");
			} else {
				_item.setAno(siteUtil.nullToString(saida.getNanoContr()));
			}

			if (!"S".equals(saida.getPperformarN())) {
				_item.setPrcAPerformar(saida.getPperformar().toPlainString());
			}

			if (!"S".equals(saida.getPtakePayN())) {
				_item.setPrcTakeOrPay(saida.getPtakePay().toPlainString());
			}

			if (!"S".equals(saida.getPlocacaoN())) {
				_item.setPrcLocacao(saida.getPlocacao().toPlainString());
			}

			if (!"S".equals(saida.getPspotN())) {
				_item.setPrcSpot(saida.getPspot().toPlainString());
			}

			if (!"S".equals(saida.getPtotalN())) {
				_item.setPrcTotal(saida.getPtotal().toPlainString());
			}

			_lista.add(_item);
		}

		return _lista;
	}

	@Override
	public void manutencaoTransportesCargas(
			QuestionarioTransportesVO questionario) {

		ManutTranspCargasRequest request = new ManutTranspCargasRequest();
		ManutTranspCargasResponse response = new ManutTranspCargasResponse();

		request.setRICCWBWERequest(new RICCWBWERequest());

		request.getRICCWBWERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBWERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBWERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<RICCWBWERequestRegistroAreaEntrada> _listaEntrada = request
				.getRICCWBWERequest().getAreaEntrada();

		TransportesCargasVO _transportesAno1 = questionario
				.getTransportesCargasAno1();
		TransportesCargasVO _transportesAno2 = questionario
				.getTransportesCargasAno2();
		TransportesCargasVO _transportesAno3 = questionario
				.getTransportesCargasAno3();
		TransportesCargasVO _transportesAnoExpectativa = questionario
				.getTransportesCargasAnoExpectativa();

		for (int i = 0; i < 4; i++) {
			RICCWBWERequestRegistroAreaEntrada _item = new RICCWBWERequestRegistroAreaEntrada();

			int _coluna = (i + 1);
			_item.setNtrnspCarga(_coluna);

			String _ano = null;
			String _prcFrotaPropria = null;
			String _prcAgregados = null;
			String _prcTerceiros = null;

			switch (_coluna) {
			case 1:
				_ano = _transportesAno1.getAno();
				_prcFrotaPropria = _transportesAno1.getPrcPropria();
				_prcAgregados = _transportesAno1.getPrcAgregados();
				_prcTerceiros = _transportesAno1.getPrcTerceiros();
				break;
			case 2:
				_ano = _transportesAno2.getAno();
				_prcFrotaPropria = _transportesAno2.getPrcPropria();
				_prcAgregados = _transportesAno2.getPrcAgregados();
				_prcTerceiros = _transportesAno2.getPrcTerceiros();
				break;
			case 3:
				_ano = _transportesAno3.getAno();
				_prcFrotaPropria = _transportesAno3.getPrcPropria();
				_prcAgregados = _transportesAno3.getPrcAgregados();
				_prcTerceiros = _transportesAno3.getPrcTerceiros();
				break;
			case 4:
				_ano = _transportesAnoExpectativa.getAno();
				_prcFrotaPropria = _transportesAnoExpectativa.getPrcPropria();
				_prcAgregados = _transportesAnoExpectativa.getPrcAgregados();
				_prcTerceiros = _transportesAnoExpectativa.getPrcTerceiros();
				break;
			}

			_item.setNanoFrota(siteUtil.nullToInteger(_ano));

			_item.setPfrtPpriaN(siteUtil.checkNullEntrada(_prcFrotaPropria));
			_item.setPfrtPpria(siteUtil
					.valueToMainframeBigDecimal(_prcFrotaPropria));

			_item.setPfrtAgrdosN(siteUtil.checkNullEntrada(_prcAgregados));
			_item.setPfrtAgrdos(siteUtil
					.valueToMainframeBigDecimal(_prcAgregados));

			_item.setPfrtTcerosN(siteUtil.checkNullEntrada(_prcTerceiros));
			_item.setPfrtTceros(siteUtil
					.valueToMainframeBigDecimal(_prcTerceiros));

			_listaEntrada.add(_item);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABW");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABW", e);
		}

	}

	@Override
	public List<TransportesCargasVO> consultaTransportesCargas(
			QuestionarioTransportesVO questionario) {

		List<TransportesCargasVO> _lista = new ArrayList<TransportesCargasVO>();

		ConsultarTransporteRequest request = new ConsultarTransporteRequest();
		ConsultarTransporteResponse response = new ConsultarTransporteResponse();

		request.setRICCWAPERequest(new RICCWAPERequest());

		request.getRICCWAPERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAPERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAPERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWAPSResponse(new RICCWAPSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAP");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAP", e);
		}

		for (RICCWAPSResponseRegistroAreaSaida saida : response
				.getRICCWAPSResponse().getAreaSaida()) {
			TransportesCargasVO _item = new TransportesCargasVO();

			if (response.getRICCWAPSResponse().getAreaSaida().get(0)
					.getNanoFrota() == 1901) {
				_item.setAno("");
			} else {
				_item.setAno(siteUtil.nullToString(saida.getNanoFrota()));
			}
			if (!"S".equals(saida.getPfrtPpriaN())) {
				_item.setPrcPropria(saida.getPfrtPpria().toPlainString());
			}

			if (!"S".equals(saida.getPfrtAgrdosN())) {
				_item.setPrcAgregados(saida.getPfrtAgrdos().toPlainString());
			}

			if (!"S".equals(saida.getPfrtTcerosN())) {
				_item.setPrcTerceiros(saida.getPfrtTceros().toPlainString());
			}

			_lista.add(_item);
		}

		return _lista;
	}

	@Override
	public void manutencaoLocadoras(QuestionarioTransportesVO questionario) {

		LocadorasVO _locadora = questionario.getLocadoras();

		ManutLocVeiculosRequest request = new ManutLocVeiculosRequest();
		ManutLocVeiculosResponse response = new ManutLocVeiculosResponse();

		request.setRICCWB2ERequest(new RICCWB2ERequest());

		request.getRICCWB2ERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWB2ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWB2ERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWB2ERequest().setRotraLocac(
				siteUtil.nullToString(_locadora.getDescFaturamentoOutros()));

		List<RICCWB2ERequestRegistroAreaEntrada> _listaEntrada = request
				.getRICCWB2ERequest().getAreaEntrada();

		ValoresLocadorasVO _vlrsLocadoraAno1 = _locadora
				.getValoresLocadorasAno1();
		ValoresLocadorasVO _vlrsLocadoraAno2 = _locadora
				.getValoresLocadorasAno2();
		ValoresLocadorasVO _vlrsLocadoraAno3 = _locadora
				.getValoresLocadorasAno3();
		ValoresLocadorasVO _vlrsLocadoraAnoExpectativa = _locadora
				.getValoresLocadorasAnoExpectativa();

		for (int i = 0; i < 4; i++) {
			RICCWB2ERequestRegistroAreaEntrada _item = new RICCWB2ERequestRegistroAreaEntrada();

			int _coluna = (i + 1);
			_item.setNlocacVeic(_coluna);

			String _ano = null;

			// % Faturamento
			String _prcLocacao = null;
			String _prcVendaVeiculos = null;
			String _prcOutros = null;

			// Frota em unidades
			String _qtdTotal = null;
			String _qtdVendaVeiculosAno = null;

			switch (_coluna) {
			case 1:
				_ano = _vlrsLocadoraAno1.getAno();
				_prcLocacao = _vlrsLocadoraAno1.getPrcLocacao();
				_prcVendaVeiculos = _vlrsLocadoraAno1.getPrcVendaVeiculos();
				_prcOutros = _vlrsLocadoraAno1.getPrcOutros();
				_qtdTotal = _vlrsLocadoraAno1.getQtdTotal();
				_qtdVendaVeiculosAno = _vlrsLocadoraAno1
						.getQtdVendaVeiculosAno();
				break;
			case 2:
				_ano = _vlrsLocadoraAno2.getAno();
				_prcLocacao = _vlrsLocadoraAno2.getPrcLocacao();
				_prcVendaVeiculos = _vlrsLocadoraAno2.getPrcVendaVeiculos();
				_prcOutros = _vlrsLocadoraAno2.getPrcOutros();
				_qtdTotal = _vlrsLocadoraAno2.getQtdTotal();
				_qtdVendaVeiculosAno = _vlrsLocadoraAno2
						.getQtdVendaVeiculosAno();
				break;
			case 3:
				_ano = _vlrsLocadoraAno3.getAno();
				_prcLocacao = _vlrsLocadoraAno3.getPrcLocacao();
				_prcVendaVeiculos = _vlrsLocadoraAno3.getPrcVendaVeiculos();
				_prcOutros = _vlrsLocadoraAno3.getPrcOutros();
				_qtdTotal = _vlrsLocadoraAno3.getQtdTotal();
				_qtdVendaVeiculosAno = _vlrsLocadoraAno3
						.getQtdVendaVeiculosAno();
				break;
			case 4:
				_ano = _vlrsLocadoraAnoExpectativa.getAno();
				_prcLocacao = _vlrsLocadoraAnoExpectativa.getPrcLocacao();
				_prcVendaVeiculos = _vlrsLocadoraAnoExpectativa
						.getPrcVendaVeiculos();
				_prcOutros = _vlrsLocadoraAnoExpectativa.getPrcOutros();
				_qtdTotal = _vlrsLocadoraAnoExpectativa.getQtdTotal();
				_qtdVendaVeiculosAno = _vlrsLocadoraAnoExpectativa
						.getQtdVendaVeiculosAno();
				break;
			}

			_item.setNanoLocac(siteUtil.nullToInteger(_ano));

			// % Faturamento
			_item.setPlocacVeicN(siteUtil.checkNullEntrada(_prcLocacao));
			_item.setPlocacVeic(siteUtil
					.valueToMainframeBigDecimal(_prcLocacao));

			_item.setPvdaVeicN(siteUtil.checkNullEntrada(_prcVendaVeiculos));
			_item.setPvdaVeic(siteUtil
					.valueToMainframeBigDecimal(_prcVendaVeiculos));

			_item.setPotraLocacN(siteUtil.checkNullEntrada(_prcOutros));
			_item.setPotraLocac(siteUtil.valueToMainframeBigDecimal(_prcOutros));

			// Frota em unidades
			_item.setQtotUndN(siteUtil.checkNullEntrada(_qtdTotal));
			_item.setQtotUnd(siteUtil.tratarParametroInteger(_qtdTotal));

			_item.setQvdaVeicN(siteUtil.checkNullEntrada(_qtdVendaVeiculosAno));
			_item.setQvdaVeic(siteUtil
					.tratarParametroInteger(_qtdVendaVeiculosAno));

			_listaEntrada.add(_item);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB2");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB2", e);
		}

	}

	@Override
	public LocadorasVO consultaLocadoras(QuestionarioTransportesVO questionario) {

		LocadorasVO _locadora = new LocadorasVO();

		ConsultarLocVeiculosRequest request = new ConsultarLocVeiculosRequest();
		ConsultarLocVeiculosResponse response = new ConsultarLocVeiculosResponse();

		request.setRICCWAVERequest(new RICCWAVERequest());

		request.getRICCWAVERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAVERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAVERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWAVSResponse(new RICCWAVSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAV");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAV", e);
		}

		List<ValoresLocadorasVO> _lista = new ArrayList<ValoresLocadorasVO>();
		for (RICCWAVSResponseRegistroAreaSaida saida : response
				.getRICCWAVSResponse().getAreaSaida()) {
			ValoresLocadorasVO _item = new ValoresLocadorasVO();

			if (!"S".equals(saida.getRotraLocacN())) {
				_locadora.setDescFaturamentoOutros(saida.getRotraLocac());
			}

			if (response.getRICCWAVSResponse().getAreaSaida().get(0)
					.getNanoLocac() == 1901) {
				_item.setAno("");
			} else {
				_item.setAno(siteUtil.nullToString(saida.getNanoLocac()));
			}

			// % Faturamento
			if (!"S".equals(saida.getPlocacVeicN())) {
				_item.setPrcLocacao(saida.getPlocacVeic().toPlainString());
			}

			if (!"S".equals(saida.getPvdaVeicN())) {
				_item.setPrcVendaVeiculos(saida.getPvdaVeic().toPlainString());
			}

			if (!"S".equals(saida.getPotraLocacN())) {
				_item.setPrcOutros(saida.getPotraLocac().toPlainString());
			}

			// Frota em unidades
			if (!"S".equals(saida.getQtotUndN())) {
				_item.setQtdTotal(siteUtil.nullToString(saida.getQtotUnd()));
			}

			if (!"S".equals(saida.getQvdaVeicN())) {
				_item.setQtdVendaVeiculosAno(siteUtil.nullToString(saida
						.getQvdaVeic()));
			}

			_lista.add(_item);
		}

		_locadora.setValoresLocadorasAno1(_lista.get(0));
		_locadora.setValoresLocadorasAno2(_lista.get(1));
		_locadora.setValoresLocadorasAno3(_lista.get(2));
		_locadora.setValoresLocadorasAnoExpectativa(_lista.get(3));

		return _locadora;
	}

	@Override
	public void manutencaoTransportesPassageiros(
			QuestionarioTransportesVO questionario) {

		ManutTranspPassasRequest request = new ManutTranspPassasRequest();
		ManutTranspPassasResponse response = new ManutTranspPassasResponse();

		request.setRICCWB0ERequest(new RICCWB0ERequest());

		request.getRICCWB0ERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWB0ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWB0ERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		List<RICCWB0ERequestRegistroAreaEntrada> _listaEntrada = request
				.getRICCWB0ERequest().getAreaEntrada();

		TransportesPassageirosVO _transportesAno1 = questionario
				.getTransportesPassageirosAno1();
		TransportesPassageirosVO _transportesAno2 = questionario
				.getTransportesPassageirosAno2();
		TransportesPassageirosVO _transportesAno3 = questionario
				.getTransportesPassageirosAno3();
		TransportesPassageirosVO _transportesAnoExpectativa = questionario
				.getTransportesPassageirosAnoExpectativa();

		for (int i = 0; i < 4; i++) {
			RICCWB0ERequestRegistroAreaEntrada _item = new RICCWB0ERequestRegistroAreaEntrada();

			int _coluna = (i + 1);
			_item.setNreajsTrnsp(_coluna);

			String _ano = null;
			String _prcMunicipal = null;
			String _prcIntermunicipal = null;
			String _prcInterestadual = null;
			String _prcInternacional = null;
			String _prcFretamento = null;

			switch (_coluna) {
			case 1:
				_ano = _transportesAno1.getAno();
				_prcMunicipal = _transportesAno1.getPrcMunicipal();
				_prcIntermunicipal = _transportesAno1.getPrcIntermunicipal();
				_prcInterestadual = _transportesAno1.getPrcInterestadual();
				_prcInternacional = _transportesAno1.getPrcInternacional();
				_prcFretamento = _transportesAno1.getPrcFretamento();
				break;
			case 2:
				_ano = _transportesAno2.getAno();
				_prcMunicipal = _transportesAno2.getPrcMunicipal();
				_prcIntermunicipal = _transportesAno2.getPrcIntermunicipal();
				_prcInterestadual = _transportesAno2.getPrcInterestadual();
				_prcInternacional = _transportesAno2.getPrcInternacional();
				_prcFretamento = _transportesAno2.getPrcFretamento();
				break;
			case 3:
				_ano = _transportesAno3.getAno();
				_prcMunicipal = _transportesAno3.getPrcMunicipal();
				_prcIntermunicipal = _transportesAno3.getPrcIntermunicipal();
				_prcInterestadual = _transportesAno3.getPrcInterestadual();
				_prcInternacional = _transportesAno3.getPrcInternacional();
				_prcFretamento = _transportesAno3.getPrcFretamento();
				break;
			case 4:
				_ano = _transportesAnoExpectativa.getAno();
				_prcMunicipal = _transportesAnoExpectativa.getPrcMunicipal();
				_prcIntermunicipal = _transportesAnoExpectativa
						.getPrcIntermunicipal();
				_prcInterestadual = _transportesAnoExpectativa
						.getPrcInterestadual();
				_prcInternacional = _transportesAnoExpectativa
						.getPrcInternacional();
				_prcFretamento = _transportesAnoExpectativa.getPrcFretamento();
				break;
			}

			_item.setNanoTrsp(siteUtil.nullToInteger(_ano));

			_item.setPtranMuncpN(siteUtil.checkNullEntrada(_prcMunicipal));
			_item.setPtranMuncp(siteUtil
					.valueToMainframeBigDecimal(_prcMunicipal));

			_item.setPtranImuncpN(siteUtil.checkNullEntrada(_prcIntermunicipal));
			_item.setPtranImuncp(siteUtil
					.valueToMainframeBigDecimal(_prcIntermunicipal));

			_item.setPtranIestadN(siteUtil.checkNullEntrada(_prcInterestadual));
			_item.setPtranIestad(siteUtil
					.valueToMainframeBigDecimal(_prcInterestadual));

			_item.setPtranInacioN(siteUtil.checkNullEntrada(_prcInternacional));
			_item.setPtranInacio(siteUtil
					.valueToMainframeBigDecimal(_prcInternacional));

			_item.setPtranFrtmtoN(siteUtil.checkNullEntrada(_prcFretamento));
			_item.setPtranFrtmto(siteUtil
					.valueToMainframeBigDecimal(_prcFretamento));

			_listaEntrada.add(_item);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB0");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB0", e);
		}

	}

	@Override
	public List<TransportesPassageirosVO> consultaTransportesPassageiros(
			QuestionarioTransportesVO questionario) {

		List<TransportesPassageirosVO> _lista = new ArrayList<TransportesPassageirosVO>();

		ConsultarTranspPassaRequest request = new ConsultarTranspPassaRequest();
		ConsultarTranspPassaResponse response = new ConsultarTranspPassaResponse();

		request.setRICCWATERequest(new RICCWATERequest());

		request.getRICCWATERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWATERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWATERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWATSResponse(new RICCWATSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAT");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAT", e);
		}

		for (RICCWATSResponseRegistroAreaSaida saida : response
				.getRICCWATSResponse().getAreaSaida()) {
			TransportesPassageirosVO _item = new TransportesPassageirosVO();

			if (response.getRICCWATSResponse().getAreaSaida().get(0)
					.getNanoTrsp() == 1901) {
				_item.setAno("");
			} else {
				_item.setAno(siteUtil.nullToString(saida.getNanoTrsp()));
			}

			if (!"S".equals(saida.getPtranMuncpN())) {
				_item.setPrcMunicipal(saida.getPtranMuncp().toPlainString());
			}

			if (!"S".equals(saida.getPtranImuncpN())) {
				_item.setPrcIntermunicipal(saida.getPtranImuncp()
						.toPlainString());
			}

			if (!"S".equals(saida.getPtranIestadN())) {
				_item.setPrcInterestadual(saida.getPtranIestad()
						.toPlainString());
			}

			if (!"S".equals(saida.getPtranInacioN())) {
				_item.setPrcInternacional(saida.getPtranInacio()
						.toPlainString());
			}

			if (!"S".equals(saida.getPtranFrtmtoN())) {
				_item.setPrcFretamento(saida.getPtranFrtmto().toPlainString());
			}

			_lista.add(_item);
		}

		return _lista;
	}
}
