/**
 * Nome: br.com.bradesco.web.ricc.service.business.questionarioprojeto.impl
 * Compilador: JDK 1.5
 * Propósito: INSERIR O PROPÓSITO DAS CLASSES DO PACOTE
 * Data da criação: <dd/MM/yyyy>
 * Parâmetros de compilação: -d
 */
package br.com.bradesco.web.ricc.service.business.questionarioprojeto.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.ConstrutoresFornecedoresVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.EstruturaSocietariaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.UsosFontesVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.request.ConsultarConstFornecRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.request.RICCWAWERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response.ConsultarConstFornecResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response.RICCWAWSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response.RICCWAWSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.request.ConsultarEstruSocietRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.request.RICCWAYERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.response.ConsultarEstruSocietResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.response.RICCWAYSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.response.RICCWAYSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.request.ConsultarQuadroUsoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.request.RICCWAXERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.response.ConsultarQuadroUsoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.response.RICCWAXSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.response.RICCWAXSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.request.DetalharRelProjetosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.request.RICCWBGERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.response.DetalharRelProjetosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.response.RICCWBGSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutConstruFornec.request.ManutConstruFornecRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutConstruFornec.request.RICCWB3ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutConstruFornec.response.ManutConstruFornecResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEstruturaSocie.request.ManutEstruturaSocieRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEstruturaSocie.request.RICCWB5ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEstruturaSocie.response.ManutEstruturaSocieResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroUso.request.ManutQuadroUsoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroUso.request.RICCWB4ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroUso.response.ManutQuadroUsoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.request.ManutRelProjetosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.request.RICCWCMERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.response.ManutRelProjetosResponse;
import br.com.bradesco.web.ricc.service.business.BaseService;
import br.com.bradesco.web.ricc.service.business.questionarioprojeto.IQuestionarioProjetoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;

@Named("questionarioProjetoService")
public class QuestionarioProjetoServiceImpl extends BaseService implements
		IQuestionarioProjetoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6853870788284577665L;

	@Override
	public void manutencaoRelatorioProjeto(QuestionarioProjetoVO objInput,
			String tipoManutencao) {

		ManutRelProjetosRequest request = new ManutRelProjetosRequest();
		ManutRelProjetosResponse response = new ManutRelProjetosResponse();

		request.setRICCWCMERequest(new RICCWCMERequest());

		request.getRICCWCMERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		// 1 - INCLUSAO 2 - EXCLUSAO 3 - ALTERACAO
		request.getRICCWCMERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWCMERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(objInput.getCodGrupo()));
		request.getRICCWCMERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));
		request.getRICCWCMERequest().setIprojEmpr(objInput.getNomeProjeto());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACM");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACM", e);
		}

	}

	@Override
	public void manutencaoEstruturaSocietaria(QuestionarioProjetoVO objInput,
			String tipoManutencao, EstruturaSocietariaVO acionista) {

		ManutEstruturaSocieRequest request = new ManutEstruturaSocieRequest();
		ManutEstruturaSocieResponse response = new ManutEstruturaSocieResponse();

		request.setRICCWB5ERequest(new RICCWB5ERequest());

		request.getRICCWB5ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWB5ERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWB5ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(objInput.getCodGrupo()));
		request.getRICCWB5ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));
		request.getRICCWB5ERequest().setNestrtSoctr(
				siteUtil.tratarParametroInteger(acionista.getNumSequencial()));
		request.getRICCWB5ERequest().setIrzScial(
				siteUtil.tratarParametroString(acionista.getDescAcionista()));
		request.getRICCWB5ERequest().setPprtcAcnst(
				siteUtil.valueToMainframeBigDecimal(acionista
						.getPrcParticipacao()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB5");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB5", e);
		}
	}

	@Override
	public void manutencaoQuadroUsosFontes(QuestionarioProjetoVO objInput,
			String tipoManutencao, UsosFontesVO usosFontes) {

		ManutQuadroUsoRequest request = new ManutQuadroUsoRequest();
		ManutQuadroUsoResponse response = new ManutQuadroUsoResponse();

		request.setRICCWB4ERequest(new RICCWB4ERequest());

		request.getRICCWB4ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWB4ERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWB4ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(objInput.getCodGrupo()));
		request.getRICCWB4ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));
		request.getRICCWB4ERequest().setNquadrUso(
				siteUtil.tratarParametroInteger(usosFontes.getNumSequencial()));
		request.getRICCWB4ERequest()
				.setCtpoQuadr(
						siteUtil.tratarParametroInteger(usosFontes
								.getCdTipoDocumento()));
		request.getRICCWB4ERequest().setRquadrProj(
				siteUtil.tratarParametroString(usosFontes.getDescUsosFontes()));
		request.getRICCWB4ERequest().setDinicQuadr(
				dateUtil.dateToString(usosFontes.getDtInicio(),
						RiccConstants.FORMATO_DIA_MES_ANO));
		request.getRICCWB4ERequest().setDfimQuadr(
				dateUtil.dateToString(usosFontes.getDtTermino(),
						RiccConstants.FORMATO_DIA_MES_ANO));
		request.getRICCWB4ERequest().setPquadrProj(
				siteUtil.valueToMainframeBigDecimal(usosFontes
						.getPrcParticipacao()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB4");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB4", e);
		}
	}

	@Override
	public void manutencaoConstrutoresFornecedores(
			QuestionarioProjetoVO objInput, String tipoManutencao,
			ConstrutoresFornecedoresVO construtoresFornecedores) {

		ManutConstruFornecRequest request = new ManutConstruFornecRequest();
		ManutConstruFornecResponse response = new ManutConstruFornecResponse();

		request.setRICCWB3ERequest(new RICCWB3ERequest());

		request.getRICCWB3ERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWB3ERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWB3ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(objInput.getCodGrupo()));
		request.getRICCWB3ERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));
		request.getRICCWB3ERequest().setNconstFornc(
				siteUtil.tratarParametroInteger(construtoresFornecedores
						.getNumSequencial()));
		request.getRICCWB3ERequest().setCtpoFornc(
				siteUtil.tratarParametroInteger(construtoresFornecedores
						.getCdTipoDocumento()));
		request.getRICCWB3ERequest().setRconFornc(
				siteUtil.tratarParametroString(construtoresFornecedores
						.getDescConstrutoresFornecedores()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAB3");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAB3", e);
		}
	}

	@Override
	public QuestionarioProjetoVO consultaRelatorioProjeto(
			QuestionarioProjetoVO objInput) {

		DetalharRelProjetosRequest request = new DetalharRelProjetosRequest();
		DetalharRelProjetosResponse response = new DetalharRelProjetosResponse();

		request.setRICCWBGERequest(new RICCWBGERequest());
		response.setRICCWBGSResponse(new RICCWBGSResponse());

		request.getRICCWBGERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWBGERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(objInput.getCodGrupo()));
		request.getRICCWBGERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABG");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABG", e);
		}

		QuestionarioProjetoVO vo = new QuestionarioProjetoVO();
		vo.setNomeProjeto(response.getRICCWBGSResponse().getIprojEmpr());

		return vo;
	}

	@Override
	public List<EstruturaSocietariaVO> consultaEstruturaSocietaria(
			QuestionarioProjetoVO objInput) {

		ArrayList<EstruturaSocietariaVO> lista = new ArrayList<EstruturaSocietariaVO>();

		ConsultarEstruSocietRequest request = new ConsultarEstruSocietRequest();
		ConsultarEstruSocietResponse response = new ConsultarEstruSocietResponse();

		request.setRICCWAYERequest(new RICCWAYERequest());

		request.getRICCWAYERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWAYERequest().setMaxOcorr(50);
		request.getRICCWAYERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(objInput.getCodGrupo()));
		request.getRICCWAYERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));

		response.setRICCWAYSResponse(new RICCWAYSResponse());
		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAY", RICCWAYSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAY", e);
		}

		for (RICCWAYSResponseRegistroAreaSaida saida : response
				.getRICCWAYSResponse().getAreaSaida()) {

			EstruturaSocietariaVO vo = new EstruturaSocietariaVO();

			vo.setNumSequencial(saida.getNestrtSoct());
			vo.setDescAcionista(saida.getIrzScial());
			vo.setPrcParticipacao(saida.getPprtcAcnst().toPlainString());

			lista.add(vo);

		}

		return lista;
	}

	@Override
	public List<ConstrutoresFornecedoresVO> consultaConstrutoresFornecedores(
			QuestionarioProjetoVO objInput, int tipoConstrutorFornecedor) {

		ArrayList<ConstrutoresFornecedoresVO> lista = new ArrayList<ConstrutoresFornecedoresVO>();

		ConsultarConstFornecRequest request = new ConsultarConstFornecRequest();
		ConsultarConstFornecResponse response = new ConsultarConstFornecResponse();

		request.setRICCWAWERequest(new RICCWAWERequest());

		request.getRICCWAWERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWAWERequest().setMaxOcorr(50);
		request.getRICCWAWERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(objInput.getCodGrupo()));
		request.getRICCWAWERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));
		request.getRICCWAWERequest().setCtpoFornc(tipoConstrutorFornecedor);

		response.setRICCWAWSResponse(new RICCWAWSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAW", RICCWAWSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAW", e);
		}

		for (RICCWAWSResponseRegistroAreaSaida saida : response
				.getRICCWAWSResponse().getAreaSaida()) {
			ConstrutoresFornecedoresVO vo = new ConstrutoresFornecedoresVO();

			vo.setNumSequencial(saida.getNconstForn());
			vo.setDescConstrutoresFornecedores(saida.getRconFornc());

			lista.add(vo);
		}

		return lista;
	}

	@Override
	public List<UsosFontesVO> consultaQuadroUsosFontes(
			QuestionarioProjetoVO objInput, int tipoUsosFontes) {

		ArrayList<UsosFontesVO> lista = new ArrayList<UsosFontesVO>();

		ConsultarQuadroUsoRequest request = new ConsultarQuadroUsoRequest();
		ConsultarQuadroUsoResponse response = new ConsultarQuadroUsoResponse();

		request.setRICCWAXERequest(new RICCWAXERequest());

		request.getRICCWAXERequest().setNversaoOrige(
				siteUtil.tratarParametroInteger(objInput.getVersaoOrigem()));
		request.getRICCWAXERequest().setMaxOcorr(50);
		request.getRICCWAXERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(objInput.getCodGrupo()));
		request.getRICCWAXERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(objInput.getCodRelatorio()));
		request.getRICCWAXERequest().setCtpoQuadr(tipoUsosFontes);

		response.setRICCWAXSResponse(new RICCWAXSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAX", RICCWAXSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAX", e);
		}

		for (RICCWAXSResponseRegistroAreaSaida saida : response
				.getRICCWAXSResponse().getAreaSaida()) {
			UsosFontesVO vo = new UsosFontesVO();

			vo.setNumSequencial(saida.getNquadrUso());
			vo.setDescUsosFontes(saida.getRquadrProj());

			vo.setDtInicio(dateUtil.transformarStringParaDate(
					saida.getDinicQuadr(), RiccConstants.FORMATO_DIA_MES_ANO));
			vo.setDtTermino(dateUtil.transformarStringParaDate(
					saida.getDfimQuadr(), RiccConstants.FORMATO_DIA_MES_ANO));

			vo.setPrcParticipacao(saida.getPquadrProj().toPlainString());

			lista.add(vo);
		}

		return lista;
	}

}