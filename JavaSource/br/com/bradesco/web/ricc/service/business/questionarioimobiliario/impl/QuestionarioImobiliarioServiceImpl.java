package br.com.bradesco.web.ricc.service.business.questionarioimobiliario.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import br.com.bradesco.web.ricc.enums.ComentarioEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AbaQuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AreaAtuacaoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.HistoricoLancamentosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.LandBankVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasAndamentoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasConcluidasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.request.ConsultarAreaAtuacaoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.request.RICCWA4ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.response.ConsultarAreaAtuacaoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.response.RICCWA4SResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.response.RICCWA4SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.request.ConsultarComentariosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.request.RICCWA9ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response.ConsultarComentariosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response.RICCWA9SResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response.RICCWA9SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.request.ConsultarCompraTerreRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.request.RICCWA0ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response.ConsultarCompraTerreResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response.RICCWA0SResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response.RICCWA0SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.request.ConsultarObrasAndamRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.request.RICCWA2ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response.ConsultarObrasAndamResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response.RICCWA2SResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response.RICCWA2SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.request.ConsultarObrasConcluRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.request.RICCWA1ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response.ConsultarObrasConcluResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response.RICCWA1SResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response.RICCWA1SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.request.CosultarEmpreLancadRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.request.RICCWAZERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response.CosultarEmpreLancadResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response.RICCWAZSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response.RICCWAZSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.request.DetalharRelImobiliaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.request.RICCWBEERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.response.DetalharRelImobiliaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.response.RICCWBESResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaAtuacao.request.ManutAreaAtuacaoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaAtuacao.request.RICCWCBERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaAtuacao.response.ManutAreaAtuacaoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request.ManutComentariosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request.RICCWCGERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request.RICCWCGERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.response.ManutComentariosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.request.ManutCompraTerrenoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.request.RICCWB7ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.response.ManutCompraTerrenoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEmpreendLanc.request.ManutEmpreendLancRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEmpreendLanc.request.RICCWB6ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEmpreendLanc.response.ManutEmpreendLancResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasAndamento.request.ManutObrasAndamentoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasAndamento.request.RICCWB9ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasAndamento.response.ManutObrasAndamentoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.request.ManutObrasConcluidasRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.request.RICCWB8ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.response.ManutObrasConcluidasResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.request.ManutRelImobiliarioRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.request.RICCWCKERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.response.ManutRelImobiliarioResponse;
import br.com.bradesco.web.ricc.service.business.BaseService;
import br.com.bradesco.web.ricc.service.business.questionarioimobiliario.IQuestionarioImobiliarioService;
import br.com.bradesco.web.ricc.utils.RiccConstants;

@Named("questionarioImobiliarioService")
public class QuestionarioImobiliarioServiceImpl extends BaseService implements
		IQuestionarioImobiliarioService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5573692746416639124L;

	@Override
	public void manutencaoDetalheSetorImobiliario(
			QuestionarioImobiliarioVO objInput, String tipoManutencao,
			AbaQuestionarioImobiliarioVO questionario) {

		ManutRelImobiliarioRequest request = new ManutRelImobiliarioRequest();
		ManutRelImobiliarioResponse response = new ManutRelImobiliarioResponse();

		request.setRICCWCKERequest(new RICCWCKERequest());

		request.getRICCWCKERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWCKERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWCKERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWCKERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		// True = 1 - sim, False = 2 - não
		if (questionario.getEmpreendimentoResidencial()) {
			request.getRICCWCKERequest().setCidtfdResid(1);
		} else {
			request.getRICCWCKERequest().setCidtfdResid(2);
		}
		// True = 1 - sim, False = 2 - não
		if (questionario.getEmpreendimentoComercial()) {
			request.getRICCWCKERequest().setCidtfdComl(1);
		} else {
			request.getRICCWCKERequest().setCidtfdComl(2);
		}
		// True = 1 - sim, False = 2 - não
		if (questionario.getBaixaRenda()) {
			request.getRICCWCKERequest().setCbaixaRenda(1);
		} else {
			request.getRICCWCKERequest().setCbaixaRenda(2);
		}
		// True = 1 - sim, False = 2 - não
		if (questionario.getClasseMedia()) {
			request.getRICCWCKERequest().setCmedRenda(1);
		} else {
			request.getRICCWCKERequest().setCmedRenda(2);
		}
		// True = 1 - sim, False = 2 - não
		if (questionario.getAltoPadrao()) {
			request.getRICCWCKERequest().setCaltaRenda(1);
		} else {
			request.getRICCWCKERequest().setCaltaRenda(2);
		}

		request.getRICCWCKERequest()
				.setPpreChave(
						siteUtil.valueToMainframeBigDecimal(questionario
								.getPreChaves()));
		request.getRICCWCKERequest()
				.setPposChave(
						siteUtil.valueToMainframeBigDecimal(questionario
								.getPosChaves()));
		// True = 1 - sim, False = 2 - não
		if (questionario.getPropria()) {
			request.getRICCWCKERequest().setCconstPpria(1);
		} else {
			request.getRICCWCKERequest().setCconstPpria(2);
		}
		// True = 1 - sim, False = 2 - não
		if (questionario.getTerceirizada()) {
			request.getRICCWCKERequest().setCconstTceira(1);
		} else {
			request.getRICCWCKERequest().setCconstTceira(2);
		}
		request.getRICCWCKERequest().setRconstTceira(
				questionario.getNomeTerceirizada());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACK");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACK", e);
		}
	}

	@Override
	public AbaQuestionarioImobiliarioVO consultaDetalheSetorImobiliario(
			QuestionarioImobiliarioVO objInput) {

		DetalharRelImobiliaRequest request = new DetalharRelImobiliaRequest();
		DetalharRelImobiliaResponse response = new DetalharRelImobiliaResponse();

		request.setRICCWBEERequest(new RICCWBEERequest());
		response.setRICCWBESResponse(new RICCWBESResponse());

		request.getRICCWBEERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWBEERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWBEERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		AbaQuestionarioImobiliarioVO retorno = new AbaQuestionarioImobiliarioVO();

		try {

			adapterCWS.invokeProcessFromNC(request, response, "RICCIABE");

			retorno.setBaixaRenda(response.getRICCWBESResponse()
					.getCbaixaRenda() == 1);
			retorno.setAltoPadrao(response.getRICCWBESResponse()
					.getCaltaRenda() == 1);
			retorno.setPropria(response.getRICCWBESResponse().getCconstPpria() == 1);
			retorno.setTerceirizada(response.getRICCWBESResponse()
					.getCconstTceira() == 1);
			retorno.setEmpreendimentoComercial(response.getRICCWBESResponse()
					.getCidtfdComl() == 1);
			retorno.setEmpreendimentoResidencial(response.getRICCWBESResponse()
					.getCidtfdResid() == 1);
			retorno.setClasseMedia(response.getRICCWBESResponse()
					.getCmedRenda() == 1);
			retorno.setPosChaves(response.getRICCWBESResponse().getPposChave()
					.toString());
			retorno.setPreChaves(response.getRICCWBESResponse().getPpreChave()
					.toString());
			retorno.setNomeTerceirizada(response.getRICCWBESResponse()
					.getRconstTceira());

		} catch (Exception e) {
			siteUtil.throwException("RICCIABE", e);
		}

		return retorno;
	}

	@Override
	public void manutencaoAreaAtuacao(QuestionarioImobiliarioVO objInput,
			String tipoManutencao, AreaAtuacaoVO areaAtuacao) {

		ManutAreaAtuacaoRequest request = new ManutAreaAtuacaoRequest();
		ManutAreaAtuacaoResponse response = new ManutAreaAtuacaoResponse();

		request.setRICCWCBERequest(new RICCWCBERequest());

		request.getRICCWCBERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWCBERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWCBERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWCBERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		request.getRICCWCBERequest().setNareaAtuac(
				areaAtuacao.getNumSequencial());
		request.getRICCWCBERequest().setRestAtuac(areaAtuacao.getEstado());
		request.getRICCWCBERequest().setRrgiaoAtua(areaAtuacao.getRegiao());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACB");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACB", e);
		}

	}

	@Override
	public List<AreaAtuacaoVO> consultaAreaAtuacao(
			QuestionarioImobiliarioVO objInput) {

		ConsultarAreaAtuacaoRequest request = new ConsultarAreaAtuacaoRequest();
		ConsultarAreaAtuacaoResponse response = new ConsultarAreaAtuacaoResponse();

		request.setRICCWA4ERequest(new RICCWA4ERequest());
		response.setRICCWA4SResponse(new RICCWA4SResponse());

		request.getRICCWA4ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWA4ERequest().setMaxOcorr(50);
		request.getRICCWA4ERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWA4ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAA4", RICCWA4SResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAA4", e);
		}

		ArrayList<AreaAtuacaoVO> lista = new ArrayList<AreaAtuacaoVO>();

		for (RICCWA4SResponseRegistroAreaSaida saida : response
				.getRICCWA4SResponse().getAreaSaida()) {

			AreaAtuacaoVO vo = new AreaAtuacaoVO();

			vo.setNumSequencial(saida.getNareaAtuac());
			vo.setEstado(saida.getRestAtuac());
			vo.setRegiao(saida.getRrgiaoAtua());

			lista.add(vo);

		}

		return lista;
	}

	@Override
	public void manutencaoHistoricoLancamentos(
			QuestionarioImobiliarioVO objInput, String tipoManutencao,
			HistoricoLancamentosVO historicoLancamentos, String anoAnterior) {

		ManutEmpreendLancRequest request = new ManutEmpreendLancRequest();
		ManutEmpreendLancResponse response = new ManutEmpreendLancResponse();

		request.setRICCWB6ERequest(new RICCWB6ERequest());

		request.getRICCWB6ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWB6ERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWB6ERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWB6ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		request.getRICCWB6ERequest().setNemptoImobl(
				historicoLancamentos.getNumSequencial());
		request.getRICCWB6ERequest().setNanoHistAnt(
				siteUtil.tratarParametroInteger(anoAnterior));
		request.getRICCWB6ERequest().setNanoHistNovo(
				siteUtil.tratarParametroInteger(historicoLancamentos.getAno()));
		request.getRICCWB6ERequest().setVtotLcto(
				siteUtil.valueToMainframeBigDecimal(historicoLancamentos
						.getVgvLancado()));
		request.getRICCWB6ERequest().setQtotLcto(
				siteUtil.tratarParametroInteger(historicoLancamentos
						.getQtdeEmpreendimentos()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB6");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB6", e);
		}
	}

	@Override
	public List<HistoricoLancamentosVO> consultaHistoricoLancamentos(
			QuestionarioImobiliarioVO objInput, StringBuilder vgvTotal,
			StringBuilder qtdTotal) {

		CosultarEmpreLancadRequest request = new CosultarEmpreLancadRequest();
		CosultarEmpreLancadResponse response = new CosultarEmpreLancadResponse();

		request.setRICCWAZERequest(new RICCWAZERequest());
		response.setRICCWAZSResponse(new RICCWAZSResponse());

		request.getRICCWAZERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(2));
		request.getRICCWAZERequest().setMaxOcorr(50);
		request.getRICCWAZERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWAZERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAZ");
		} catch (Exception e) {
			int tries = 0;

			while (e != null
					&& e.getCause() != null
					&& e.getCause().getCause() != null
					&& ("REQUEST TIMEOUT").equals(e.getCause().getCause()
							.getMessage()) && tries < 3) {
				try {
					adapterCWS.invokeProcessFromNC(request, response,
							"RICCIAAZ");
					e = null;
				} catch (Exception ee) {
					e = ee;
				}
				tries++;
			}
			if (e != null) {
				siteUtil.throwException("RICCIAAZ", e);
			}
		}

		ArrayList<HistoricoLancamentosVO> lista = new ArrayList<HistoricoLancamentosVO>();

		vgvTotal.append(response.getRICCWAZSResponse().getVtotVgv());
		qtdTotal.append(response.getRICCWAZSResponse().getQtotEmpmt());

		for (RICCWAZSResponseRegistroAreaSaida saida : response
				.getRICCWAZSResponse().getAreaSaida()) {

			HistoricoLancamentosVO vo = new HistoricoLancamentosVO();
			vo.setNumSequencial(saida.getNemptoImob());
			vo.setAno(siteUtil.tratarParametroString(saida.getNanoHist()));
			vo.setVgvLancado(saida.getVtotLcto()
					.setScale(0, BigDecimal.ROUND_UP).toPlainString());
			vo.setQtdeEmpreendimentos(siteUtil.tratarParametroString(saida
					.getQtotLcto()));

			lista.add(vo);

		}

		return lista;
	}

	@Override
	public void manutencaoLandBank(QuestionarioImobiliarioVO objInput,
			String tipoManutencao, LandBankVO landBank) {

		ManutCompraTerrenoRequest request = new ManutCompraTerrenoRequest();
		ManutCompraTerrenoResponse response = new ManutCompraTerrenoResponse();

		request.setRICCWB7ERequest(new RICCWB7ERequest());

		request.getRICCWB7ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWB7ERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWB7ERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWB7ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		request.getRICCWB7ERequest().setNprevtLcto(landBank.getNumSequencial());
		request.getRICCWB7ERequest().setDbaseInfo(
				dateUtil.dateToString(new Date(),
						RiccConstants.FORMATO_DIA_MES_ANO));
		request.getRICCWB7ERequest()
				.setIemptoImob(landBank.getEmpreendimento());
		request.getRICCWB7ERequest().setRlocEmpto(landBank.getLocalizacao());
		request.getRICCWB7ERequest()
				.setVtotTerrn(
						siteUtil.valueToMainframeBigDecimal(landBank
								.getValorTerreno()));
		request.getRICCWB7ERequest().setVprevt(
				siteUtil.valueToMainframeBigDecimal(landBank.getVgvEstimado()));
		request.getRICCWB7ERequest().setDprevtLcto(
				landBank.getDataPrevista().replace("/", "."));
		request.getRICCWB7ERequest().setCsitLcto(
				siteUtil.tratarParametroInteger(landBank.getPossuiOnus()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB7");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB7", e);
		}
	}

	@Override
	public List<LandBankVO> consultaLandBank(
			QuestionarioImobiliarioVO objInput, StringBuilder totalTerreno,
			StringBuilder totalProjetada) {

		ConsultarCompraTerreRequest request = new ConsultarCompraTerreRequest();
		ConsultarCompraTerreResponse response = new ConsultarCompraTerreResponse();

		request.setRICCWA0ERequest(new RICCWA0ERequest());
		response.setRICCWA0SResponse(new RICCWA0SResponse());

		request.getRICCWA0ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWA0ERequest().setMaxOcorr(50);
		request.getRICCWA0ERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWA0ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAA0", RICCWA0SResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAA0", e);
		}

		ArrayList<LandBankVO> lista = new ArrayList<LandBankVO>();

		for (RICCWA0SResponseRegistroAreaSaida saida : response
				.getRICCWA0SResponse().getAreaSaida()) {

			LandBankVO vo = new LandBankVO();

			vo.setNumSequencial(saida.getNprevtLcto());
			vo.setEmpreendimento(siteUtil.tratarParametroString(saida
					.getIemptoImob()));
			vo.setLocalizacao(siteUtil.tratarParametroString(saida
					.getRlocEmpto()));
			vo.setValorTerreno(saida.getVtotTerrn()
					.setScale(0, BigDecimal.ROUND_UP).toPlainString());
			vo.setVgvEstimado(saida.getVprevt()
					.setScale(0, BigDecimal.ROUND_UP).toPlainString());
			vo.setDataPrevista(saida.getDprevtLcto().replace(".", "/"));
			vo.setPossuiOnus(String.valueOf(saida.getCsitLcto()));

			lista.add(vo);

		}
		totalTerreno.append(response.getRICCWA0SResponse().getVtotTerreno()
				.setScale(0, BigDecimal.ROUND_UP).toString());
		totalProjetada.append(response.getRICCWA0SResponse().getVtotProjetada()
				.setScale(0, BigDecimal.ROUND_UP).toString());
		return lista;
	}

	// Aba ObrasAndamento
	@Override
	public void manutencaoObrasAndamento(QuestionarioImobiliarioVO objInput,
			String tipoManutencao, ObrasAndamentoVO obrasAndamento) {

		ManutObrasAndamentoRequest request = new ManutObrasAndamentoRequest();
		ManutObrasAndamentoResponse response = new ManutObrasAndamentoResponse();

		request.setRICCWB9ERequest(new RICCWB9ERequest());

		request.getRICCWB9ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWB9ERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWB9ERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWB9ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		request.getRICCWB9ERequest().setDbaseRelat(
				dateUtil.dateToString(new Date(),
						RiccConstants.FORMATO_DIA_MES_ANO));
		request.getRICCWB9ERequest().setNobraRelat(
				siteUtil.tratarParametroInteger(obrasAndamento
						.getNumSequencial()));

		request.getRICCWB9ERequest().setIincprImob(
				obrasAndamento.getIncorporadora());
		request.getRICCWB9ERequest().setIemptoImob(
				obrasAndamento.getNomeEmpreendimento());
		request.getRICCWB9ERequest().setRbairoEmpt(obrasAndamento.getBairro());
		request.getRICCWB9ERequest().setRciddeEmpt(obrasAndamento.getCidade());
		request.getRICCWB9ERequest().setCufEmpt(obrasAndamento.getUf());
		request.getRICCWB9ERequest().setPemptoImob(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getPorcPartEmpreendimento()));
		request.getRICCWB9ERequest().setDlctoEmpto(
				obrasAndamento.getDataLancamento().replace("/", "."));
		request.getRICCWB9ERequest().setDprevtEntr(
				obrasAndamento.getPrevisaoEntrega().replace("/", "."));
		request.getRICCWB9ERequest().setPobraEmpto(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getPorcentagemObra()));

		request.getRICCWB9ERequest().setVcustoTot(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getTotalObra()));
		request.getRICCWB9ERequest().setVcustoInc(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getaIncorrer()));

		request.getRICCWB9ERequest().setVtotGral(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getVgvTotal()));
		request.getRICCWB9ERequest().setVvdaPermu(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getVgvSemPermutas()));

		request.getRICCWB9ERequest().setQtotEstoq(
				siteUtil.tratarParametroInteger(obrasAndamento
						.getTotalUnidadesEstoque()));
		request.getRICCWB9ERequest().setQundMnor(
				siteUtil.tratarParametroInteger(obrasAndamento
						.getTotalUnidadesSemPermutas()));
		request.getRICCWB9ERequest().setQundPermu(
				siteUtil.tratarParametroInteger(obrasAndamento
						.getTotalUnidadesComPermutas()));

		request.getRICCWB9ERequest().setPvdaRealz(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getPorcentagemVendas()));
		request.getRICCWB9ERequest().setPdtroRealz(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getPorcentagemDistratos()));
		request.getRICCWB9ERequest().setVtotRecbd(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getValoresRecebidos()));
		request.getRICCWB9ERequest().setVpreChave(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getValoresAteChaves()));
		request.getRICCWB9ERequest().setVposChave(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getValoresPosChaves()));

		request.getRICCWB9ERequest().setRagteFincr(
				obrasAndamento.getAgenteFinanceiro());
		request.getRICCWB9ERequest().setVtotContr(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getValorContrato()));
		request.getRICCWB9ERequest().setVsdoLibrd(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getSaldoALiberar()));
		request.getRICCWB9ERequest().setVsdoDvdor(
				siteUtil.valueToMainframeBigDecimal(obrasAndamento
						.getSaldoDevedor()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB9");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB9", e);
		}
	}

	@Override
	public QuestionarioImobiliarioVO consultaObrasAndamento(
			QuestionarioImobiliarioVO objInput, StringBuilder dataBase) {

		ConsultarObrasAndamRequest request = new ConsultarObrasAndamRequest();
		ConsultarObrasAndamResponse response = new ConsultarObrasAndamResponse();

		request.setRICCWA2ERequest(new RICCWA2ERequest());

		request.getRICCWA2ERequest().setNversaoOrige(2);
		request.getRICCWA2ERequest().setMaxOcorr(50);
		request.getRICCWA2ERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWA2ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		response.setRICCWA2SResponse(new RICCWA2SResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAA2", RICCWA2SResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAA2", e);
		}

		QuestionarioImobiliarioVO questionario = new QuestionarioImobiliarioVO();

		ArrayList<ObrasAndamentoVO> lista = new ArrayList<ObrasAndamentoVO>();

		dataBase.append(response.getRICCWA2SResponse().getDbaseRelat());

		questionario.setTotalCustoObra(String.valueOf(response
				.getRICCWA2SResponse().getVtotalCustoTot()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalCustoIncorrer(String.valueOf(response
				.getRICCWA2SResponse().getVtotalCustoInc()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalVenda(String.valueOf(response
				.getRICCWA2SResponse().getVtotalTotGral()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalVendaPermuta(String.valueOf(response
				.getRICCWA2SResponse().getVtotalVdaPermu()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalQuantidadeEstoque(String.valueOf(response
				.getRICCWA2SResponse().getQtotalTotEstoq()));
		questionario.setTotalUnidadeSemPermuta(String.valueOf(response
				.getRICCWA2SResponse().getQtotalUndMnor()));
		questionario.setTotalUnidadePermuta(String.valueOf(response
				.getRICCWA2SResponse().getQtotalUndPermu()));
		questionario.setTotalValorRecibo(String.valueOf(response
				.getRICCWA2SResponse().getVtotalTotRecbd()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalValorReciboPreChave(String.valueOf(response
				.getRICCWA2SResponse().getVtotalPreChave()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalValorReciboPosChave(String.valueOf(response
				.getRICCWA2SResponse().getVtotalPosChave()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalValorContrato(String.valueOf(response
				.getRICCWA2SResponse().getVtotalTotContr()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalSaldoLiberar(String.valueOf(response
				.getRICCWA2SResponse().getVtotalSdoLibrd()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalSaldoDevedorAndamento(String.valueOf(response
				.getRICCWA2SResponse().getVtotalSdoDvdor()
				.setScale(0, BigDecimal.ROUND_UP)));

		for (RICCWA2SResponseRegistroAreaSaida saida : response
				.getRICCWA2SResponse().getAreaSaida()) {

			ObrasAndamentoVO vo = new ObrasAndamentoVO();

			vo.setNumSequencial(String.valueOf(saida.getNobraRelat()));

			vo.setIncorporadora(saida.getIincprImob());
			vo.setNomeEmpreendimento(saida.getIemptoImob());
			vo.setBairro(saida.getRbairoEmpt());
			vo.setCidade(saida.getRciddeEmpt());
			vo.setUf(saida.getCufEmpt());
			vo.setPorcPartEmpreendimento(saida.getPemptoImob().toString());
			vo.setDataLancamento(saida.getDlctoEmpto().replace(".", "/"));
			vo.setPrevisaoEntrega(saida.getDprevtEntr().replace(".", "/"));
			vo.setPorcentagemObra(saida.getPobraEmpto().toString());

			vo.setTotalObra(saida.getVcustoTot()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setaIncorrer(saida.getVcustoInc()
					.setScale(0, BigDecimal.ROUND_UP).toString());

			vo.setVgvTotal(saida.getVtotGral().setScale(0, BigDecimal.ROUND_UP)
					.toString());
			vo.setVgvSemPermutas(saida.getVvdaPermu()
					.setScale(0, BigDecimal.ROUND_UP).toString());

			vo.setTotalUnidadesEstoque(String.valueOf(saida.getQtotEstoq()));
			vo.setTotalUnidadesSemPermutas(String.valueOf(saida.getQundMnor()));
			vo.setTotalUnidadesComPermutas(String.valueOf(saida.getQundPermu()));

			vo.setPorcentagemVendas(saida.getPvdaRealz().toString());
			vo.setPorcentagemDistratos(saida.getPdtroRealz().toString());
			vo.setValoresRecebidos(saida.getVtotRecbd()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setValoresAteChaves(saida.getVpreChave()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setValoresPosChaves(saida.getVposChave()
					.setScale(0, BigDecimal.ROUND_UP).toString());

			vo.setAgenteFinanceiro(saida.getRagteFincr());
			vo.setValorContrato(saida.getVtotContr()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setSaldoALiberar(saida.getVsdoLibrd()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setSaldoDevedor(saida.getVsdoDvdor()
					.setScale(0, BigDecimal.ROUND_UP).toString());

			lista.add(vo);
		}

		questionario.setListaObrasAndamento(lista);
		return questionario;
	}

	// Aba ObrasConcluidas
	@Override
	public void manutencaoObrasConcluidas(QuestionarioImobiliarioVO objInput,
			String tipoManutencao, ObrasConcluidasVO obrasConcluidas) {

		ManutObrasConcluidasRequest request = new ManutObrasConcluidasRequest();
		ManutObrasConcluidasResponse response = new ManutObrasConcluidasResponse();

		request.setRICCWB8ERequest(new RICCWB8ERequest());

		request.getRICCWB8ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWB8ERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWB8ERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWB8ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));
		request.getRICCWB8ERequest().setDbaseInfo(
				dateUtil.dateToString(new Date(),
						RiccConstants.FORMATO_DIA_MES_ANO));
		request.getRICCWB8ERequest().setNobraConcl(
				obrasConcluidas.getNumSequencial());

		request.getRICCWB8ERequest().setIincprImob(
				obrasConcluidas.getIncorporadora());
		request.getRICCWB8ERequest().setIemptoImob(
				obrasConcluidas.getNomeEmpreendimento());
		request.getRICCWB8ERequest().setRbairoEmpt(obrasConcluidas.getBairro());
		request.getRICCWB8ERequest().setRciddeEmpt(obrasConcluidas.getCidade());
		request.getRICCWB8ERequest().setCufEmpt(obrasConcluidas.getUf());
		request.getRICCWB8ERequest().setDentrgEmpt(
				obrasConcluidas.getDataEntrega().replace("/", "."));

		request.getRICCWB8ERequest().setVtotRecbd(
				siteUtil.valueToMainframeBigDecimal(obrasConcluidas
						.getValoresRecebidos()));
		request.getRICCWB8ERequest().setVdoze(
				siteUtil.valueToMainframeBigDecimal(obrasConcluidas
						.getValoresAte12Meses()));
		request.getRICCWB8ERequest().setVtrntaSeis(
				siteUtil.valueToMainframeBigDecimal(obrasConcluidas
						.getValoresDe12Ate36Meses()));
		request.getRICCWB8ERequest().setVposTrnta(
				siteUtil.valueToMainframeBigDecimal(obrasConcluidas
						.getValoresApos36Meses()));

		request.getRICCWB8ERequest().setQtotUnd(
				siteUtil.tratarParametroInteger(obrasConcluidas
						.getQtdeUnidades()));
		request.getRICCWB8ERequest().setVtotEstoq(
				siteUtil.valueToMainframeBigDecimal(obrasConcluidas
						.getValorEstoque()));
		request.getRICCWB8ERequest().setPvdaRealz(
				siteUtil.valueToMainframeBigDecimal(obrasConcluidas
						.getPorcentagemVendas()));
		request.getRICCWB8ERequest().setRagteFincr(
				obrasConcluidas.getAgenteFinanceiro());
		request.getRICCWB8ERequest().setVsdoDvdor(
				siteUtil.valueToMainframeBigDecimal(obrasConcluidas
						.getSaldoDevedor()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB8");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB8", e);
		}
	}

	@Override
	public QuestionarioImobiliarioVO consultaObrasConcluidas(
			QuestionarioImobiliarioVO objInput, StringBuilder dataBase) {

		ConsultarObrasConcluRequest request = new ConsultarObrasConcluRequest();
		ConsultarObrasConcluResponse response = new ConsultarObrasConcluResponse();

		request.setRICCWA1ERequest(new RICCWA1ERequest());

		request.getRICCWA1ERequest().setNversaoOrige(2);
		request.getRICCWA1ERequest().setMaxOcorr(50);
		request.getRICCWA1ERequest()
				.setCgrpEconm(
						siteUtil.tratarParametroInteger(objInput
								.getCodGrupoEconomico()));
		request.getRICCWA1ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		response.setRICCWA1SResponse(new RICCWA1SResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAA1", RICCWA1SResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAA1", e);
		}

		QuestionarioImobiliarioVO questionario = new QuestionarioImobiliarioVO();

		ArrayList<ObrasConcluidasVO> lista = new ArrayList<ObrasConcluidasVO>();

		dataBase.append(response.getRICCWA1SResponse().getDbaseInfo());

		questionario.setTotalRecebidos(String.valueOf(response
				.getRICCWA1SResponse().getVtotalRecbd()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotal12Meses(String.valueOf(response
				.getRICCWA1SResponse().getVtotalDoze()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotal12A36(String.valueOf(response
				.getRICCWA1SResponse().getVtotalTrntaSeis()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalApos36(String.valueOf(response
				.getRICCWA1SResponse().getVtotalPosTrnta()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalUnidades(String.valueOf(response
				.getRICCWA1SResponse().getQtotalUnd()));
		questionario.setTotalValorEstoque(String.valueOf(response
				.getRICCWA1SResponse().getVtotalEstoq()
				.setScale(0, BigDecimal.ROUND_UP)));
		questionario.setTotalSaldoDevedor(String.valueOf(response
				.getRICCWA1SResponse().getVtotalSdoDvdor()
				.setScale(0, BigDecimal.ROUND_UP)));

		for (RICCWA1SResponseRegistroAreaSaida saida : response
				.getRICCWA1SResponse().getAreaSaida()) {

			ObrasConcluidasVO vo = new ObrasConcluidasVO();
			vo.setNumSequencial(saida.getNobraConcl());

			vo.setIncorporadora(saida.getIincprImob());
			vo.setNomeEmpreendimento(saida.getIemptoImob());
			vo.setBairro(saida.getRbairoEmpt());
			vo.setCidade(saida.getRciddeEmpt());
			vo.setUf(saida.getCufEmpt());
			vo.setDataEntrega(saida.getDentrgEmpt().replace(".", "/"));

			vo.setValoresRecebidos(saida.getVtotRecbd()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setValoresAte12Meses(saida.getVdoze()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setValoresDe12Ate36Meses(saida.getVtrntaSeis()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setValoresApos36Meses(saida.getVposTrnta()
					.setScale(0, BigDecimal.ROUND_UP).toString());

			vo.setQtdeUnidades(String.valueOf(saida.getQtotUnd()));
			vo.setValorEstoque(saida.getVtotEstoq()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			vo.setPorcentagemVendas(saida.getPvdaRealz().toString());
			vo.setAgenteFinanceiro(saida.getRagteFincr());
			vo.setSaldoDevedor(saida.getVsdoDvdor()
					.setScale(0, BigDecimal.ROUND_UP).toString());

			lista.add(vo);
		}
		questionario.setListaObrasConcluidas(lista);
		return questionario;
	}

	@Override
	public void manutencaoComentarios(QuestionarioImobiliarioVO questionario,
			List<ComentarioVO> comentarios, String tipoManutencao)
			throws RiccException {
		ManutComentariosRequest request = new ManutComentariosRequest();
		ManutComentariosResponse response = new ManutComentariosResponse();
		request.setRICCWCGERequest(new RICCWCGERequest());

		List<RICCWCGERequestRegistroAreaEntrada> listaEntrada = new ArrayList<RICCWCGERequestRegistroAreaEntrada>();

		for (ComentarioVO comentario : comentarios) {
			RICCWCGERequestRegistroAreaEntrada registro = new RICCWCGERequestRegistroAreaEntrada();

			registro.setCtpoComent(siteUtil.tratarParametroInteger(comentario
					.getCodTipo()));
			registro.setCseqComent(siteUtil.tratarParametroInteger(comentario
					.getCodSequencial()));
			registro.setRcomenRelt(siteUtil.nullToString(comentario
					.getComentario().replace("\n", "|")));

			listaEntrada.add(registro);
		}

		request.getRICCWCGERequest().setAreaEntrada(listaEntrada);
		request.getRICCWCGERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWCGERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario
						.getCodGrupoEconomico()));
		request.getRICCWCGERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		adapterCWS.invokeProcessFromNC(request, response, "RICCIACG");
	}

	@Override
	public List<ComentarioVO> consultaComentarios(
			QuestionarioImobiliarioVO questionario, ComentarioEnum comentario) {
		ConsultarComentariosRequest request = new ConsultarComentariosRequest();
		ConsultarComentariosResponse response = new ConsultarComentariosResponse();
		List<ComentarioVO> listaRetorno = new ArrayList<ComentarioVO>();
		request.setRICCWA9ERequest(new RICCWA9ERequest());
		request.getRICCWA9ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario
						.getCodGrupoEconomico()));
		request.getRICCWA9ERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWA9ERequest().setCtpoComent(
				siteUtil.tratarParametroInteger(comentario.getCodigo()));

		response.setRICCWA9SResponse(new RICCWA9SResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAA9", RICCWA9SResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAA9", e);
		}

		for (RICCWA9SResponseRegistroAreaSaida reg : response
				.getRICCWA9SResponse().getAreaSaida()) {
			ComentarioVO item = new ComentarioVO();
			item.setCodSequencial(String.valueOf(reg.getCseqComent()));
			item.setCodTipo(String.valueOf(reg.getCtpoComent()));
			item.setComentario(reg.getRcomenRelt().replace("|", "\n"));
			listaRetorno.add(item);
		}

		return listaRetorno;
	}
}
