package br.com.bradesco.web.ricc.service.business.questionariosegmento.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Named;

import br.com.bradesco.web.aq.application.security.utils.BradescoSecurityUtilsDelegate;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.ricc.enums.SegmentoEnum;
import br.com.bradesco.web.ricc.enums.SituacaoRelatorioEnum;
import br.com.bradesco.web.ricc.enums.TipoFuncaoEnum;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariocorporate.QuadroAtivosCorporateVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.DadosTransportesDatabaseVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.model.segmento.CapacidadeProdutivaVO;
import br.com.bradesco.web.ricc.model.segmento.CartaoVO;
import br.com.bradesco.web.ricc.model.segmento.CarteiraContratosVO;
import br.com.bradesco.web.ricc.model.segmento.ClienteVO;
import br.com.bradesco.web.ricc.model.segmento.ConcorrenteVO;
import br.com.bradesco.web.ricc.model.segmento.DetalhamentoPatrimonioVO;
import br.com.bradesco.web.ricc.model.segmento.EndividamentoBancarioVO;
import br.com.bradesco.web.ricc.model.segmento.FaturamentoConsolidadoVO;
import br.com.bradesco.web.ricc.model.segmento.FaturamentoPorSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.FormaRecebimentoVO;
import br.com.bradesco.web.ricc.model.segmento.FornecedorVO;
import br.com.bradesco.web.ricc.model.segmento.HighlightsEmpresaVO;
import br.com.bradesco.web.ricc.model.segmento.ImportacoesExportacoesVO;
import br.com.bradesco.web.ricc.model.segmento.LinhaSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.PerspectivasVO;
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.model.segmento.QuestionarioSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.VolumeBradescoVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAberturaFat.request.ConsultarAberturaFatRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAberturaFat.request.RICCWAEERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAberturaFat.response.ConsultarAberturaFatResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAberturaFat.response.RICCWAESResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.request.ConsultarBalancoEmpRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.request.RICCWAFERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response.ConsultarBalancoEmpResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response.RICCWAFSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response.RICCWAFSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.request.ConsultarCapacidadeRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.request.RICCWADERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response.ConsultarCapacidadeResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response.RICCWADSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response.RICCWADSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.request.ConsultarCartoesGpRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.request.RICCWAHERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.response.ConsultarCartoesGpResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.response.RICCWAHSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.response.RICCWAHSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.request.ConsultarClienteFornRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.request.RICCWAOERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response.ConsultarClienteFornResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response.RICCWAOSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response.RICCWAOSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.request.ConsultarComentariosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.request.RICCWA9ERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response.ConsultarComentariosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response.RICCWA9SResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response.RICCWA9SResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.request.ConsultarContratosGpRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.request.RICCWAJERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response.ConsultarContratosGpResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response.RICCWAJSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response.RICCWAJSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.request.ConsultarEndividamenRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.request.RICCWALERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response.ConsultarEndividamenResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response.RICCWALSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response.RICCWALSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.request.ConsultarExposicaoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.request.RICCWAGERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.response.ConsultarExposicaoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.response.RICCWAGSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.response.RICCWAGSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.request.ConsultarFatConsolidRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.request.RICCWAKERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.response.ConsultarFatConsolidResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.response.RICCWAKSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.response.RICCWAKSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.request.ConsultarPatrimonioRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.request.RICCWACERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response.ConsultarPatrimonioResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response.RICCWACSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response.RICCWACSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.request.ConsultarPerspectivaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.request.RICCWAIERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.response.ConsultarPerspectivaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.response.RICCWAISResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.request.ConsultarQuadroAdminRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.request.RICCWABERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response.ConsultarQuadroAdminResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response.RICCWABSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response.RICCWABSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.request.ConsultarQuadroAtivoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.request.RICCWANERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response.ConsultarQuadroAtivoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response.RICCWANSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response.RICCWANSResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.request.ConsultarReciprocidaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.request.RICCWAMERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.response.ConsultarReciprocidaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.response.RICCWAMSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.request.ConsultarRelSetorialRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.request.RICCWBAERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.response.ConsultarRelSetorialResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.response.RICCWBASResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.request.CopiarRelatorioRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.request.RICCWCOERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.response.CopiarRelatorioResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.response.RICCWCOSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelSegmento.request.DetalharRelSegmentoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelSegmento.request.RICCWBCERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelSegmento.response.DetalharRelSegmentoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelSegmento.response.RICCWBCSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAberturaFat.request.ManutAberturaFatRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAberturaFat.request.RICCWBLERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAberturaFat.response.ManutAberturaFatResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutBalancoEmpresa.request.ManutBalancoEmpresaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutBalancoEmpresa.request.RICCWBMERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutBalancoEmpresa.request.RICCWBMERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutBalancoEmpresa.response.ManutBalancoEmpresaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.request.ManutCapacidadeProdRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.request.RICCWBKERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.response.ManutCapacidadeProdResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCartoesGpEcon.request.ManutCartoesGpEconRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCartoesGpEcon.request.RICCWBOERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCartoesGpEcon.response.ManutCartoesGpEconResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutClienteFornec.request.ManutClienteFornecRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutClienteFornec.request.RICCWBVERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutClienteFornec.response.ManutClienteFornecResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request.ManutComentariosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request.RICCWCGERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request.RICCWCGERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.response.ManutComentariosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.request.ManutContratosGpEconRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.request.RICCWBQERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.response.ManutContratosGpEconResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEndividamenBanc.request.ManutEndividamenBancRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEndividamenBanc.request.RICCWBSERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEndividamenBanc.response.ManutEndividamenBancResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExclusaoRelat.request.ManutExclusaoRelatRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExclusaoRelat.request.RICCWBTERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExclusaoRelat.response.ManutExclusaoRelatResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request.ManutExposicaoCambRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request.RICCWBNERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request.RICCWBNERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.response.ManutExposicaoCambResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatConsolidado.request.ManutFatConsolidadoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatConsolidado.request.RICCWBRERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatConsolidado.request.RICCWBRERequestRegistroAreaEntrada;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatConsolidado.response.ManutFatConsolidadoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPatrimonio.request.ManutPatrimonioRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPatrimonio.request.RICCWBJERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPatrimonio.response.ManutPatrimonioResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.request.ManutPerspectivaEmpRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.request.RICCWBPERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.response.ManutPerspectivaEmpResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAdmin.request.ManutQuadroAdminRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAdmin.request.RICCWBIERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAdmin.response.ManutQuadroAdminResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAtivos.request.ManutQuadroAtivosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAtivos.request.RICCWBUERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAtivos.response.ManutQuadroAtivosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelAgricola.request.ManutRelAgricolaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelAgricola.response.ManutRelAgricolaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.request.ManutRelImobiliarioRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.request.RICCWCKERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.response.ManutRelImobiliarioResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.request.ManutRelProjetosRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.request.RICCWCMERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.response.ManutRelProjetosResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSegmento.request.ManutRelSegmentoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSegmento.request.RICCWCIERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSegmento.response.ManutRelSegmentoResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSetorial.request.ManutRelSetorialRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSetorial.request.RICCWCHERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSetorial.response.ManutRelSetorialResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.request.ManutRelTransporteRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.request.RICCWCLERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.response.ManutRelTransporteResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.request.ManutencaoRICRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.response.ManutencaoRICResponse;
import br.com.bradesco.web.ricc.service.business.BaseService;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;

@Named("segmentoService")
public class SegmentoServiceImpl extends BaseService implements
		ISegmentoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5920629946538870932L;

	@Override
	public void manutencaoQuadroAtivos(QuestionarioSegmentoVO questionario,
			QuadroAtivosCorporateVO ativos, String tipoManutencao) {
		ManutQuadroAtivosRequest request = new ManutQuadroAtivosRequest();
		ManutQuadroAtivosResponse response = new ManutQuadroAtivosResponse();
		request.setRICCWBUERequest(new RICCWBUERequest());
		request.getRICCWBUERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBUERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		// request.getRICCWBUERequest().setNrelatSgmto(siteUtil.tratarParametroInteger(questionario.getCodSegmentoRelatorio()));
		request.getRICCWBUERequest().setNrelatSgmto(1);
		request.getRICCWBUERequest().setNquadrAtivo(
				siteUtil.tratarParametroInteger(ativos.getNumSequencial()));
		request.getRICCWBUERequest().setRativo(
				ativos.getConcessoesProjetosSpes());

		if (tipoManutencao
				.equals(TipoManutencaoEnum.INCLUSAO.getCodigoString())) {
			request.getRICCWBUERequest().setPprtcpAtiv(
					siteUtil.valueToMainframeBigDecimal(ativos
							.getPorcParticipacao()));
		} else {
			if ((ativos.getPorcParticipacao() != null)
					&& !(ativos.getPorcParticipacao().equals(""))) {
				request.getRICCWBUERequest().setPprtcpAtiv(
						siteUtil.valueToMainframeBigDecimal(ativos
								.getPorcParticipacao()));
			} else {
				request.getRICCWBUERequest().setPprtcpAtiv(new BigDecimal(0));
			}
		}

		request.getRICCWBUERequest().setRinfoRelvt(
				ativos.getInformacoesRelevantes());
		request.getRICCWBUERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWBUERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABU");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABU", e);
		}
	}

	@Override
	public List<QuadroAtivosCorporateVO> consultaQuadroAtivos(
			QuestionarioSegmentoVO questionario) {
		ConsultarQuadroAtivoRequest request = new ConsultarQuadroAtivoRequest();
		ConsultarQuadroAtivoResponse response = new ConsultarQuadroAtivoResponse();
		List<QuadroAtivosCorporateVO> listaRetorno = new ArrayList<QuadroAtivosCorporateVO>();

		request.setRICCWANERequest(new RICCWANERequest());
		request.getRICCWANERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWANERequest().setMaxOcorr(30);
		request.getRICCWANERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWANERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWANERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWANSResponse(new RICCWANSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAN", RICCWANSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAN", e);
		}

		QuadroAtivosCorporateVO item = null;
		for (RICCWANSResponseRegistroAreaSaida reg : response
				.getRICCWANSResponse().getAreaSaida()) {
			item = new QuadroAtivosCorporateVO();
			item.setNumSequencial(String.valueOf(reg.getNquadrAtiv()));
			item.setConcessoesProjetosSpes(reg.getRativo());
			item.setPorcParticipacao(reg.getPprtcpAtiv().toString());
			item.setInformacoesRelevantes(reg.getRinfoRelvt());
			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void consultaSegmento(QuestionarioSegmentoVO questionario) {
		DetalharRelSegmentoRequest request = new DetalharRelSegmentoRequest();
		DetalharRelSegmentoResponse response = new DetalharRelSegmentoResponse();
		request.setRICCWBCERequest(new RICCWBCERequest());
		request.getRICCWBCERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBCERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBCERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWBCSResponse(new RICCWBCSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABC");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABC", e);
		}

		questionario.setNomeRelatorio(response.getRICCWBCSResponse()
				.getRrelatInfoCred());
		questionario.setAdministracao(String.valueOf(response
				.getRICCWBCSResponse().getCtpoAdmEmpr()));
		questionario.setPlanoSucessao(String.valueOf(response
				.getRICCWBCSResponse().getCplanoSucss()));
		questionario.setInformarAtraso(response.getRICCWBCSResponse()
				.getRinadpCart());

	}

	@Override
	public void manutencaoQuadroAdministrativo(
			QuestionarioSegmentoVO questionario,
			QuadroAdministrativoVO administrador, String tipoManutencao) {
		ManutQuadroAdminRequest request = new ManutQuadroAdminRequest();
		ManutQuadroAdminResponse response = new ManutQuadroAdminResponse();
		request.setRICCWBIERequest(new RICCWBIERequest());

		request.getRICCWBIERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBIERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWBIERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBIERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBIERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBIERequest().setNseqQuadr(
				siteUtil.tratarParametroInteger(administrador
						.getNumSequencial()));
		request.getRICCWBIERequest().setIrzScial(
				administrador.getAdministrador());
		request.getRICCWBIERequest().setRcargo(administrador.getCargo());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABI");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABI", e);
		}

	}

	@Override
	public List<QuadroAdministrativoVO> consultaQuadroAdministrativo(
			QuestionarioSegmentoVO questionario) {
		ConsultarQuadroAdminRequest request = new ConsultarQuadroAdminRequest();
		ConsultarQuadroAdminResponse response = new ConsultarQuadroAdminResponse();
		List<QuadroAdministrativoVO> listaRetorno = new ArrayList<QuadroAdministrativoVO>();

		request.setRICCWABERequest(new RICCWABERequest());
		request.getRICCWABERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWABERequest().setMaxOcorr(30);
		request.getRICCWABERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWABERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWABERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWABSResponse(new RICCWABSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAB", RICCWABSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAB", e);
		}
		QuadroAdministrativoVO item = null;
		for (RICCWABSResponseRegistroAreaSaida reg : response
				.getRICCWABSResponse().getAreaSaida()) {
			item = new QuadroAdministrativoVO();
			item.setNumSequencial(String.valueOf(reg.getNseqQuadr()));
			item.setAdministrador(reg.getIrzScial());
			item.setCargo(reg.getRcargo());
			listaRetorno.add(item);
		}
		return listaRetorno;
	}

	@Override
	public void manutencaoDetalhamentoPatrimonio(
			QuestionarioSegmentoVO questionario,
			DetalhamentoPatrimonioVO patrimonio, String tipoManutencao) {
		ManutPatrimonioRequest request = new ManutPatrimonioRequest();
		ManutPatrimonioResponse response = new ManutPatrimonioResponse();

		request.setRICCWBJERequest(new RICCWBJERequest());
		request.getRICCWBJERequest().setCtpoManut(
				Integer.parseInt(tipoManutencao));
		request.getRICCWBJERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBJERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBJERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBJERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBJERequest().setRpatrm(patrimonio.getPatrimonio());
		if (tipoManutencao
				.equals(TipoManutencaoEnum.INCLUSAO.getCodigoString())) {
			request.getRICCWBJERequest().setVpatrm(
					siteUtil.valueToMainframeBigDecimal(patrimonio
							.getValorPatrimonio()));
		} else {
			request.getRICCWBJERequest().setVpatrm(
					siteUtil.valueToMainframeBigDecimal(patrimonio
							.getValorPatrimonio()));
		}
		request.getRICCWBJERequest().setNpatrmRelat(
				siteUtil.tratarParametroInteger(patrimonio
						.getSequencialPatrimonio()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABJ");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABJ", e);
		}

	}

	@Override
	public List<DetalhamentoPatrimonioVO> consultaDetalhamentoPatrimonio(
			QuestionarioSegmentoVO questionario, StringBuilder totalizador) {
		ConsultarPatrimonioRequest request = new ConsultarPatrimonioRequest();
		ConsultarPatrimonioResponse response = new ConsultarPatrimonioResponse();
		List<DetalhamentoPatrimonioVO> listaRetorno = new ArrayList<DetalhamentoPatrimonioVO>();
		request.setRICCWACERequest(new RICCWACERequest());
		request.getRICCWACERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWACERequest().setMaxOcorr(50);
		request.getRICCWACERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWACERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWACERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWACSResponse(new RICCWACSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAC", RICCWACSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAC", e);
		}

		totalizador.append(response.getRICCWACSResponse().getVtotPatrm()
				.setScale(0, BigDecimal.ROUND_UP).toString());
		DetalhamentoPatrimonioVO item = null;
		for (RICCWACSResponseRegistroAreaSaida reg : response
				.getRICCWACSResponse().getAreaSaida()) {
			item = new DetalhamentoPatrimonioVO();
			item.setSequencialPatrimonio(String.valueOf(reg.getNpatrmRelat()));
			item.setPatrimonio(reg.getRpatrm());
			item.setValorPatrimonio(reg.getVpatrm()
					.setScale(0, BigDecimal.ROUND_UP).toString());
			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoCapacidadeProdutiva(
			QuestionarioSegmentoVO questionario,
			CapacidadeProdutivaVO producao, String tipoManutencao) {
		ManutCapacidadeProdRequest request = new ManutCapacidadeProdRequest();
		ManutCapacidadeProdResponse response = new ManutCapacidadeProdResponse();

		request.setRICCWBKERequest(new RICCWBKERequest());
		request.getRICCWBKERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBKERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWBKERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBKERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBKERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBKERequest().setNcapacPrdtv(
				siteUtil.tratarParametroInteger(producao.getNumSequencial()));
		request.getRICCWBKERequest().setRplanta(producao.getPlantas());
		request.getRICCWBKERequest().setQtCapac(
				siteUtil.tratarParametroInteger(producao.getProducao().replace(
						".", "")));
		request.getRICCWBKERequest().setQtProduc(
				siteUtil.tratarParametroInteger(producao.getUtilizada()
						.replace(".", "")));
		if (tipoManutencao
				.equals(TipoManutencaoEnum.INCLUSAO.getCodigoString())) {
			request.getRICCWBKERequest().setPutilzProd(
					siteUtil.valueToMainframeBigDecimal(producao
							.getUtilizacaoPercentual()));
		} else {
			request.getRICCWBKERequest().setPutilzProd(
					siteUtil.valueToMainframeBigDecimal(producao
							.getUtilizacaoPercentual()));
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABK");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABK", e);
		}
	}

	@Override
	public List<CapacidadeProdutivaVO> consultaCapacidadeProdutiva(
			QuestionarioSegmentoVO questionario, StringBuilder totalCapacidade,
			StringBuilder totalProducao) {
		ConsultarCapacidadeRequest request = new ConsultarCapacidadeRequest();
		ConsultarCapacidadeResponse response = new ConsultarCapacidadeResponse();
		List<CapacidadeProdutivaVO> listaRetorno = new ArrayList<CapacidadeProdutivaVO>();

		request.setRICCWADERequest(new RICCWADERequest());
		request.getRICCWADERequest().setNversaoOrige(2);
		request.getRICCWADERequest().setMaxOcorr(50);
		request.getRICCWADERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWADERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWADERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWADSResponse(new RICCWADSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAD", RICCWADSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAD", e);
		}
		CapacidadeProdutivaVO item = null;
		totalCapacidade.append(response.getRICCWADSResponse().getQtotCapac());
		totalProducao.append(response.getRICCWADSResponse().getQtotProduc());
		for (RICCWADSResponseRegistroAreaSaida reg : response
				.getRICCWADSResponse().getAreaSaida()) {
			item = new CapacidadeProdutivaVO();
			item.setNumSequencial(String.valueOf(reg.getNcapacPrtv()));
			item.setPlantas(reg.getRplanta());
			item.setProducao(String.valueOf(reg.getQtCapac()));
			item.setUtilizada(String.valueOf(reg.getQtProduc()));
			item.setUtilizacaoPercentual(reg.getPutilzProd().toString());
			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoCartoes(QuestionarioSegmentoVO questionario,
			CartaoVO cartao, String tipoManutencao) {
		ManutCartoesGpEconRequest request = new ManutCartoesGpEconRequest();
		ManutCartoesGpEconResponse response = new ManutCartoesGpEconResponse();
		request.setRICCWBOERequest(new RICCWBOERequest());
		request.getRICCWBOERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBOERequest().seteCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWBOERequest().seteCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBOERequest()
				.seteNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBOERequest().seteNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBOERequest().seteNcataoRelat(
				siteUtil.tratarParametroInteger(cartao.getNumSequencial()));
		request.getRICCWBOERequest().seteQtotCart(
				siteUtil.tratarParametroInteger(cartao.getQuantidade().replace(
						".", "")));
		request.getRICCWBOERequest().seteRbande(cartao.getBandeira());

		if (tipoManutencao
				.equals(TipoManutencaoEnum.INCLUSAO.getCodigoString())) {
			request.getRICCWBOERequest().seteVresul(
					siteUtil.valueToMainframeBigDecimal(cartao.getResultado()));
		} else {
			request.getRICCWBOERequest().seteVresul(
					siteUtil.valueToMainframeBigDecimal(cartao.getResultado()));
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABO");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABO", e);
		}

	}

	@Override
	public List<CartaoVO> consultaCartoes(QuestionarioSegmentoVO questionario) {

		ConsultarCartoesGpRequest request = new ConsultarCartoesGpRequest();
		ConsultarCartoesGpResponse response = new ConsultarCartoesGpResponse();

		request.setRICCWAHERequest(new RICCWAHERequest());

		request.getRICCWAHERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAHERequest().setMaxOcorr(50);
		request.getRICCWAHERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAHERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAHERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAHSResponse(new RICCWAHSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAH", RICCWAHSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAH", e);
		}

		List<CartaoVO> listaRetorno = new ArrayList<CartaoVO>();

		CartaoVO item = null;
		for (RICCWAHSResponseRegistroAreaSaida reg : response
				.getRICCWAHSResponse().getAreaSaida()) {

			item = new CartaoVO();
			item.setNumSequencial(String.valueOf(reg.getNcataoCredt()));
			item.setQuantidade(String.valueOf(reg.getQtotCart()));
			item.setResultado(String.valueOf(reg.getVresul().setScale(0,
					BigDecimal.ROUND_UP)));
			item.setBandeira(reg.getRbande());

			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoCarteiraContratos(
			QuestionarioSegmentoVO questionario, CarteiraContratosVO carteira,
			String tipoManutencao) {
		ManutContratosGpEconRequest request = new ManutContratosGpEconRequest();
		ManutContratosGpEconResponse response = new ManutContratosGpEconResponse();

		request.setRICCWBQERequest(new RICCWBQERequest());
		request.getRICCWBQERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBQERequest().setCtpoManut(
				Integer.parseInt(tipoManutencao));
		request.getRICCWBQERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBQERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBQERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBQERequest().setDtFim(
				carteira.getDataTermino().replace("/", "."));
		request.getRICCWBQERequest().setIrzScial(carteira.getCliente());
		request.getRICCWBQERequest().setNdetlhContr(
				siteUtil.tratarParametroInteger(carteira.getNumSequencial()));
		request.getRICCWBQERequest().setRproj(carteira.getProjetoObraServico());
		if (tipoManutencao
				.equals(TipoManutencaoEnum.INCLUSAO.getCodigoString())) {
			request.getRICCWBQERequest().setVcontr(
					siteUtil.valueToMainframeBigDecimal(carteira
							.getValorContrato()));
			request.getRICCWBQERequest().setVsaldo(
					siteUtil.valueToMainframeBigDecimal(carteira
							.getSaldoPerformar()));
		} else {
			request.getRICCWBQERequest().setVcontr(
					siteUtil.valueToMainframeBigDecimal(carteira
							.getValorContrato()));
			request.getRICCWBQERequest().setVsaldo(
					siteUtil.valueToMainframeBigDecimal(carteira
							.getSaldoPerformar()));
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABQ");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABQ", e);
		}

	}

	@Override
	public List<CarteiraContratosVO> consultaCarteiraContratos(
			QuestionarioSegmentoVO questionario, StringBuilder totalContrato,
			StringBuilder totalSaldo) {

		ConsultarContratosGpRequest request = new ConsultarContratosGpRequest();
		ConsultarContratosGpResponse response = new ConsultarContratosGpResponse();

		request.setRICCWAJERequest(new RICCWAJERequest());

		request.getRICCWAJERequest().setNversaoOrige(2);
		request.getRICCWAJERequest().setMaxOcorr(50);
		request.getRICCWAJERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAJERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAJERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAJSResponse(new RICCWAJSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAJ", RICCWAJSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAJ", e);
		}

		List<CarteiraContratosVO> listaRetorno = new ArrayList<CarteiraContratosVO>();
		CarteiraContratosVO item = null;
		totalContrato.append(response.getRICCWAJSResponse().getVtotContr()
				.setScale(0, BigDecimal.ROUND_UP).toString());
		totalSaldo.append(response.getRICCWAJSResponse().getVtotSaldo()
				.setScale(0, BigDecimal.ROUND_UP).toString());
		for (RICCWAJSResponseRegistroAreaSaida reg : response
				.getRICCWAJSResponse().getAreaSaida()) {

			item = new CarteiraContratosVO();
			item.setNumSequencial(String.valueOf(reg.getNdetlhContr()));
			item.setProjetoObraServico(reg.getRproj().trim());
			item.setCliente(reg.getIrzScial().trim());
			item.setValorContrato(String.valueOf(reg.getVcontr().setScale(0,
					BigDecimal.ROUND_UP)));
			item.setSaldoPerformar(String.valueOf(reg.getVsaldo().setScale(0,
					BigDecimal.ROUND_UP)));
			item.setDataTermino(reg.getDtFim());

			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoCliente(QuestionarioSegmentoVO questionario,
			ClienteVO cliente, String tipoManutencao) {
		ManutClienteFornecRequest request = new ManutClienteFornecRequest();
		ManutClienteFornecResponse response = new ManutClienteFornecResponse();

		request.setRICCWBVERequest(new RICCWBVERequest());
		request.getRICCWBVERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBVERequest().setCtpoManut(
				Integer.parseInt(tipoManutencao));
		request.getRICCWBVERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBVERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBVERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBVERequest().setNcliFornc(
				siteUtil.tratarParametroInteger(cliente.getNumSequencial()));
		request.getRICCWBVERequest().setCtpoCli(
				siteUtil.tratarParametroInteger(cliente.getTipoCliente()));
		request.getRICCWBVERequest().setRcliFornc(cliente.getCliente());
		if (tipoManutencao
				.equals(TipoManutencaoEnum.INCLUSAO.getCodigoString())) {
			request.getRICCWBVERequest().setPcliFornc(
					siteUtil.valueToMainframeBigDecimal(cliente
							.getPorcentagem()));
		} else {
			request.getRICCWBVERequest().setPcliFornc(
					siteUtil.valueToMainframeBigDecimal(cliente
							.getPorcentagem()));
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABV");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABV", e);
		}

	}

	@Override
	public List<ClienteVO> consultaCliente(QuestionarioSegmentoVO questionario) {
		ConsultarClienteFornRequest request = new ConsultarClienteFornRequest();
		ConsultarClienteFornResponse response = new ConsultarClienteFornResponse();
		List<ClienteVO> listaRetorno = new ArrayList<ClienteVO>();

		request.setRICCWAOERequest(new RICCWAOERequest());
		request.getRICCWAOERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAOERequest().setMaxOcorr(50);
		request.getRICCWAOERequest().setCtpoCli(
				Integer.parseInt(RiccConstants.COD_TIPO_CLIENTE));
		request.getRICCWAOERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAOERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAOERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAOSResponse(new RICCWAOSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAO", RICCWAOSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAO", e);
		}
		ClienteVO item = null;
		for (RICCWAOSResponseRegistroAreaSaida reg : response
				.getRICCWAOSResponse().getAreaSaida()) {
			item = new ClienteVO();
			item.setNumSequencial(String.valueOf(reg.getNcliFornc()));
			item.setTipoCliente(String.valueOf(reg.getCtpoCli()));
			item.setCliente(reg.getRcliFornc());
			item.setPorcentagem(reg.getPcliFornc().toString());
			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoConcorrente(QuestionarioSegmentoVO questionario,
			ConcorrenteVO concorrente, String tipoManutencao) {
		ManutClienteFornecRequest request = new ManutClienteFornecRequest();
		ManutClienteFornecResponse response = new ManutClienteFornecResponse();

		request.setRICCWBVERequest(new RICCWBVERequest());
		request.getRICCWBVERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBVERequest().setCtpoManut(
				Integer.parseInt(tipoManutencao));
		request.getRICCWBVERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBVERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBVERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBVERequest()
				.setNcliFornc(
						siteUtil.tratarParametroInteger(concorrente
								.getNumSequencial()));
		request.getRICCWBVERequest().setCtpoCli(
				siteUtil.tratarParametroInteger(concorrente.getTipoCliente()));
		request.getRICCWBVERequest().setRcliFornc(concorrente.getConcorrente());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABV");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABV", e);
		}

	}

	@Override
	public List<ConcorrenteVO> consultaConcorrente(
			QuestionarioSegmentoVO questionario) {
		ConsultarClienteFornRequest request = new ConsultarClienteFornRequest();
		ConsultarClienteFornResponse response = new ConsultarClienteFornResponse();
		List<ConcorrenteVO> listaRetorno = new ArrayList<ConcorrenteVO>();

		request.setRICCWAOERequest(new RICCWAOERequest());
		request.getRICCWAOERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAOERequest().setMaxOcorr(50);
		request.getRICCWAOERequest().setCtpoCli(
				Integer.parseInt(RiccConstants.COD_TIPO_CONCORRENTE));
		request.getRICCWAOERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAOERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAOERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAOSResponse(new RICCWAOSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAO", RICCWAOSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAO", e);
		}
		ConcorrenteVO item = null;
		for (RICCWAOSResponseRegistroAreaSaida reg : response
				.getRICCWAOSResponse().getAreaSaida()) {
			item = new ConcorrenteVO();
			item.setNumSequencial(String.valueOf(reg.getNcliFornc()));
			item.setTipoCliente(String.valueOf(reg.getCtpoCli()));
			item.setConcorrente(reg.getRcliFornc());
			item.setPorcentagem(reg.getPcliFornc().toString());
			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoEndividamentoBancario(
			QuestionarioSegmentoVO questionario,
			EndividamentoBancarioVO endividamento,
			TipoManutencaoEnum tipoManutencao) {
		ManutEndividamenBancRequest request = new ManutEndividamenBancRequest();
		ManutEndividamenBancResponse response = new ManutEndividamenBancResponse();
		request.setRICCWBSERequest(new RICCWBSERequest());
		request.getRICCWBSERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBSERequest().setCtpoManut(tipoManutencao.getCodigo());
		request.getRICCWBSERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBSERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBSERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBSERequest().setNendvtBrio(
				siteUtil.tratarParametroInteger(endividamento
						.getNumSequencial()));
		request.getRICCWBSERequest().setVvctoEndv(new BigDecimal(0));
		request.getRICCWBSERequest().setDtVvcto(
				endividamento.getVencimentoFinal().replace("/", "."));
		request.getRICCWBSERequest().setRamotzEndv(
				siteUtil.nullToString(endividamento.getAmortizacao()));
		request.getRICCWBSERequest().setRgarntBco(
				endividamento.getDescGarantia());
		request.getRICCWBSERequest().setFILLER110("");

		request.getRICCWBSERequest().setIrzScial(
				endividamento.getInstituicaoFinanceira());
		request.getRICCWBSERequest()
				.setRmodldBco(endividamento.getModalidade());

		if (tipoManutencao.equals(TipoManutencaoEnum.INCLUSAO)) {
			request.getRICCWBSERequest().setVsdoEndv(
					siteUtil.valueToMainframeBigDecimal(endividamento
							.getSaldo()));
		} else {

			request.getRICCWBSERequest().setVsdoEndv(
					siteUtil.valueToMainframeBigDecimal(endividamento
							.getSaldo()));
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABS");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABS", e);
		}

	}

	@Override
	public List<EndividamentoBancarioVO> consultaEndividamentoBancario(
			QuestionarioSegmentoVO questionario, StringBuilder totalizador) {

		ConsultarEndividamenRequest request = new ConsultarEndividamenRequest();
		ConsultarEndividamenResponse response = new ConsultarEndividamenResponse();

		request.setRICCWALERequest(new RICCWALERequest());

		request.getRICCWALERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWALERequest().setMaxOcorr(50);
		request.getRICCWALERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWALERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWALERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWALSResponse(new RICCWALSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAL", RICCWALSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAL", e);
		}

		List<EndividamentoBancarioVO> listaRetorno = new ArrayList<EndividamentoBancarioVO>();

		if (siteUtil.isNotEmptyOrNull(response.getRICCWALSResponse()
				.getVtotSaldo())) {
			totalizador.append(response.getRICCWALSResponse().getVtotSaldo()
					.setScale(0, BigDecimal.ROUND_UP).toString());
		}
		EndividamentoBancarioVO item = null;
		for (RICCWALSResponseRegistroAreaSaida reg : response
				.getRICCWALSResponse().getAreaSaida()) {

			item = new EndividamentoBancarioVO();
			item.setNumSequencial(String.valueOf(reg.getNendvtBrio()));
			item.setInstituicaoFinanceira(reg.getIrzScial());
			item.setModalidade(reg.getRmodldBco());
			item.setSaldo(String.valueOf(reg.getVsdoEndv().setScale(0,
					BigDecimal.ROUND_UP)));
			item.setVencimentoFinal(reg.getDtVvcto());
			// Campo não utilizavel?
			item.setValorVencimentoFinal(reg.getVvctoEndv().toString());
			item.setAmortizacao(reg.getRamotzEndv());
			item.setDescGarantia(reg.getRgarntBco());

			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoFaturamentoConsolidado(
			QuestionarioSegmentoVO questionario,
			List<FaturamentoConsolidadoVO> listaFaturamento,
			String tipoManutencao) {

		ManutFatConsolidadoRequest request = new ManutFatConsolidadoRequest();
		ManutFatConsolidadoResponse response = new ManutFatConsolidadoResponse();

		request.setRICCWBRERequest(new RICCWBRERequest());

		request.getRICCWBRERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBRERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBRERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBRERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		List<RICCWBRERequestRegistroAreaEntrada> listaEntrada = new ArrayList<RICCWBRERequestRegistroAreaEntrada>();
		for (int coluna = 0; coluna < listaFaturamento.size(); coluna++) {
			listaEntrada.add(new RICCWBRERequestRegistroAreaEntrada());
			listaEntrada.get(coluna).setNumAnoAnt(0);
			listaEntrada.get(coluna).setNumAnoNovo(
					siteUtil.tratarParametroInteger(listaFaturamento
							.get(coluna).getAno()));

			String janeiro = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getJaneiro());
			if (siteUtil.isEmptyOrNull(janeiro)) {
				listaEntrada.get(coluna).setVtotM01(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM01Null("S");
				listaEntrada.get(coluna).setVtotM01S("+");
			} else {
				listaEntrada.get(coluna).setVtotM01(
						new BigDecimal(janeiro.replace("-", "")));
				listaEntrada.get(coluna).setVtotM01Null("N");
				listaEntrada.get(coluna).setVtotM01S(
						janeiro.contains("-") ? "-" : "+");
			}

			String fevereiro = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getFevereiro());
			if (siteUtil.isEmptyOrNull(fevereiro)) {
				listaEntrada.get(coluna).setVtotM02(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM02Null("S");
				listaEntrada.get(coluna).setVtotM02S("+");
			} else {
				listaEntrada.get(coluna).setVtotM02(
						new BigDecimal(fevereiro.replace("-", "")));
				listaEntrada.get(coluna).setVtotM02Null("N");
				listaEntrada.get(coluna).setVtotM02S(
						fevereiro.contains("-") ? "-" : "+");
			}

			String marco = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getMarco());
			if (siteUtil.isEmptyOrNull(marco)) {
				listaEntrada.get(coluna).setVtotM03(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM03Null("S");
				listaEntrada.get(coluna).setVtotM03S("+");
			} else {
				listaEntrada.get(coluna).setVtotM03(
						new BigDecimal(marco.replace("-", "")));
				listaEntrada.get(coluna).setVtotM03Null("N");
				listaEntrada.get(coluna).setVtotM03S(
						marco.contains("-") ? "-" : "+");
			}

			String abril = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getAbril());
			if (siteUtil.isEmptyOrNull(abril)) {
				listaEntrada.get(coluna).setVtotM04(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM04Null("S");
				listaEntrada.get(coluna).setVtotM04S("+");
			} else {
				listaEntrada.get(coluna).setVtotM04(
						new BigDecimal(abril.replace("-", "")));
				listaEntrada.get(coluna).setVtotM04Null("N");
				listaEntrada.get(coluna).setVtotM04S(
						abril.contains("-") ? "-" : "+");
			}

			String maio = siteUtil.valueToMainframeString(listaFaturamento.get(
					coluna).getMaio());
			if (siteUtil.isEmptyOrNull(maio)) {
				listaEntrada.get(coluna).setVtotM05(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM05Null("S");
				listaEntrada.get(coluna).setVtotM05S("+");
			} else {
				listaEntrada.get(coluna).setVtotM05(
						new BigDecimal(maio.replace("-", "")));
				listaEntrada.get(coluna).setVtotM05Null("N");
				listaEntrada.get(coluna).setVtotM05S(
						maio.contains("-") ? "-" : "+");
			}

			String junho = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getJunho());
			if (siteUtil.isEmptyOrNull(junho)) {
				listaEntrada.get(coluna).setVtotM06(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM06Null("S");
				listaEntrada.get(coluna).setVtotM06S("+");
			} else {
				listaEntrada.get(coluna).setVtotM06(
						new BigDecimal(junho.replace("-", "")));
				listaEntrada.get(coluna).setVtotM06Null("N");
				listaEntrada.get(coluna).setVtotM06S(
						junho.contains("-") ? "-" : "+");
			}

			String julho = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getJulho());
			if (siteUtil.isEmptyOrNull(julho)) {
				listaEntrada.get(coluna).setVtotM07(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM07Null("S");
				listaEntrada.get(coluna).setVtotM07S("+");
			} else {
				listaEntrada.get(coluna).setVtotM07(
						new BigDecimal(julho.replace("-", "")));
				listaEntrada.get(coluna).setVtotM07Null("N");
				listaEntrada.get(coluna).setVtotM07S(
						julho.contains("-") ? "-" : "+");
			}

			String agosto = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getAgosto());
			if (siteUtil.isEmptyOrNull(agosto)) {
				listaEntrada.get(coluna).setVtotM08(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM08Null("S");
				listaEntrada.get(coluna).setVtotM08S("+");
			} else {
				listaEntrada.get(coluna).setVtotM08(
						new BigDecimal(agosto.replace("-", "")));
				listaEntrada.get(coluna).setVtotM08Null("N");
				listaEntrada.get(coluna).setVtotM08S(
						agosto.contains("-") ? "-" : "+");
			}

			String setembro = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getSetembro());
			if (siteUtil.isEmptyOrNull(setembro)) {
				listaEntrada.get(coluna).setVtotM09(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM09Null("S");
				listaEntrada.get(coluna).setVtotM09S("+");
			} else {
				listaEntrada.get(coluna).setVtotM09(
						new BigDecimal(setembro.replace("-", "")));
				listaEntrada.get(coluna).setVtotM09Null("N");
				listaEntrada.get(coluna).setVtotM09S(
						setembro.contains("-") ? "-" : "+");
			}

			String outubro = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getOutubro());
			if (siteUtil.isEmptyOrNull(outubro)) {
				listaEntrada.get(coluna).setVtotM10(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM10Null("S");
				listaEntrada.get(coluna).setVtotM10S("+");
			} else {
				listaEntrada.get(coluna).setVtotM10(
						new BigDecimal(outubro.replace("-", "")));
				listaEntrada.get(coluna).setVtotM10Null("N");
				listaEntrada.get(coluna).setVtotM10S(
						outubro.contains("-") ? "-" : "+");
			}

			String novembro = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getNovembro());
			if (siteUtil.isEmptyOrNull(novembro)) {
				listaEntrada.get(coluna).setVtotM11(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM11Null("S");
				listaEntrada.get(coluna).setVtotM11S("+");
			} else {
				listaEntrada.get(coluna).setVtotM11(
						new BigDecimal(novembro.replace("-", "")));
				listaEntrada.get(coluna).setVtotM11Null("N");
				listaEntrada.get(coluna).setVtotM11S(
						novembro.contains("-") ? "-" : "+");
			}

			String dezembro = siteUtil.valueToMainframeString(listaFaturamento
					.get(coluna).getDezembro());
			if (siteUtil.isEmptyOrNull(dezembro)) {
				listaEntrada.get(coluna).setVtotM12(BigDecimal.ZERO);
				listaEntrada.get(coluna).setVtotM12Null("S");
				listaEntrada.get(coluna).setVtotM12S("+");
			} else {
				listaEntrada.get(coluna).setVtotM12(
						new BigDecimal(dezembro.replace("-", "")));
				listaEntrada.get(coluna).setVtotM12Null("N");
				listaEntrada.get(coluna).setVtotM12S(
						dezembro.contains("-") ? "-" : "+");
			}

		}
		request.getRICCWBRERequest().setAreaEntrada(listaEntrada);

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABR");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABR", e);
		}

	}

	@Override
	public List<FaturamentoConsolidadoVO> consultaFaturamentoConsolidado(
			QuestionarioSegmentoVO questionario) {

		ConsultarFatConsolidRequest request = new ConsultarFatConsolidRequest();
		ConsultarFatConsolidResponse response = new ConsultarFatConsolidResponse();

		request.setRICCWAKERequest(new RICCWAKERequest());

		request.getRICCWAKERequest().setNversaoOrige(2);
		request.getRICCWAKERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAKERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAKERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAKSResponse(new RICCWAKSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAK", RICCWAKSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAK", e);
		}

		List<FaturamentoConsolidadoVO> listaRetorno = new ArrayList<FaturamentoConsolidadoVO>();
		FaturamentoConsolidadoVO item = null;
		for (RICCWAKSResponseRegistroAreaSaida reg : response
				.getRICCWAKSResponse().getAreaSaida()) {

			item = new FaturamentoConsolidadoVO();
			if (reg.getsNumAno() == 0) {
				item.setAno("");
			} else {
				item.setAno(String.valueOf(reg.getsNumAno()));
			}

			if (reg.getVtotM01Null().equals("S")) {
				item.setJaneiro("");
			} else {
				if (reg.getVtotM01S().equals("-")) {
					item.setJaneiro("-"
							+ reg.getVtotM01().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setJaneiro(reg.getVtotM01()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM02Null().equals("S")) {
				item.setFevereiro("");
			} else {
				if (reg.getVtotM02S().equals("-")) {
					item.setFevereiro("-"
							+ reg.getVtotM02().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setFevereiro(reg.getVtotM02()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM03Null().equals("S")) {
				item.setMarco("");
			} else {
				if (reg.getVtotM03S().equals("-")) {
					item.setMarco("-"
							+ reg.getVtotM03().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setMarco(reg.getVtotM03()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM04Null().equals("S")) {
				item.setAbril("");
			} else {
				if (reg.getVtotM04S().equals("-")) {
					item.setAbril("-"
							+ reg.getVtotM04().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setAbril(reg.getVtotM04()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM05Null().equals("S")) {
				item.setMaio("");
			} else {
				if (reg.getVtotM05S().equals("-")) {
					item.setMaio("-"
							+ reg.getVtotM05().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setMaio(reg.getVtotM05()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM06Null().equals("S")) {
				item.setJunho("");
			} else {
				if (reg.getVtotM06S().equals("-")) {
					item.setJunho("-"
							+ reg.getVtotM06().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setJunho(reg.getVtotM06()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM07Null().equals("S")) {
				item.setJulho("");
			} else {
				if (reg.getVtotM07S().equals("-")) {
					item.setJulho("-"
							+ reg.getVtotM07().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setJulho(reg.getVtotM07()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM08Null().equals("S")) {
				item.setAgosto("");
			} else {
				if (reg.getVtotM08S().equals("-")) {
					item.setAgosto("-"
							+ reg.getVtotM08().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setAgosto(reg.getVtotM08()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM09Null().equals("S")) {
				item.setSetembro("");
			} else {
				if (reg.getVtotM09S().equals("-")) {
					item.setSetembro("-"
							+ reg.getVtotM09().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setSetembro(reg.getVtotM09()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM10Null().equals("S")) {
				item.setOutubro("");
			} else {
				if (reg.getVtotM10S().equals("-")) {
					item.setOutubro("-"
							+ reg.getVtotM10().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setOutubro(reg.getVtotM10()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM11Null().equals("S")) {
				item.setNovembro("");
			} else {
				if (reg.getVtotM11S().equals("-")) {
					item.setNovembro("-"
							+ reg.getVtotM11().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setNovembro(reg.getVtotM11()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotM12Null().equals("S")) {
				item.setDezembro("");
			} else {
				if (reg.getVtotM12S().equals("-")) {
					item.setDezembro("-"
							+ reg.getVtotM12().setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setDezembro(reg.getVtotM12()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotFatmtS().equals("-")) {
				item.setTotalFaturamento("-"
						+ reg.getVtotFatmt().setScale(0, BigDecimal.ROUND_UP)
								.toString());
			} else {
				item.setTotalFaturamento(reg.getVtotFatmt()
						.setScale(0, BigDecimal.ROUND_UP).toString());
			}
			if (reg.getVmedFatmtS().equals("-")) {
				item.setMediaFaturamento("-"
						+ reg.getVmedFatmt().setScale(0, BigDecimal.ROUND_UP)
								.toString());
			} else {
				item.setMediaFaturamento(reg.getVmedFatmt()
						.setScale(0, BigDecimal.ROUND_UP).toString());
			}

			listaRetorno.add(item);
		}

		while (listaRetorno.size() < 3) {
			listaRetorno.add(new FaturamentoConsolidadoVO());
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoFaturamentoSegmento(
			QuestionarioSegmentoVO questionario,
			FaturamentoPorSegmentoVO faturamento,
			TipoManutencaoEnum tipoManutencao) {
		ManutAberturaFatRequest request = new ManutAberturaFatRequest();
		ManutAberturaFatResponse response = new ManutAberturaFatResponse();
		request.setRICCWBLERequest(new RICCWBLERequest());
		RICCWBLERequest entrada = request.getRICCWBLERequest();

		entrada.setNversaoOrige(siteUtil.tratarParametroInteger(questionario
				.getVersaoOrigem()));
		entrada.setCgrpEconm(siteUtil.tratarParametroInteger(questionario
				.getCodGrupo()));
		entrada.setNrelatCredt(siteUtil.tratarParametroInteger(questionario
				.getCodRelatorio()));
		entrada.setNrelatSgmto(siteUtil.tratarParametroInteger(questionario
				.getCodSegmentoRelatorio()));

		entrada.setAnoCol1(siteUtil.tratarParametroInteger(faturamento
				.getAno1()));
		entrada.setAnoCol2(siteUtil.tratarParametroInteger(faturamento
				.getAno2()));
		entrada.setAnoCol3(siteUtil.tratarParametroInteger(faturamento
				.getAno3()));

		LinhaSegmentoVO linha1 = faturamento.getLinha1();
		entrada.setL1Descricao(linha1.getDescricao());
		entrada.setL1PabertC1(siteUtil.valueToMainframeBigDecimal(linha1
				.getPorcentagem1()));
		entrada.setL1PabertC1N(siteUtil.checkNullEntrada(linha1
				.getPorcentagem1()));
		entrada.setL1PabertC2(siteUtil.valueToMainframeBigDecimal(linha1
				.getPorcentagem2()));
		entrada.setL1PabertC2N(siteUtil.checkNullEntrada(linha1
				.getPorcentagem2()));
		entrada.setL1PabertC3(siteUtil.valueToMainframeBigDecimal(linha1
				.getPorcentagem3()));
		entrada.setL1PabertC3N(siteUtil.checkNullEntrada(linha1
				.getPorcentagem3()));

		LinhaSegmentoVO linha2 = faturamento.getLinha2();
		entrada.setL2Descricao(linha2.getDescricao());
		entrada.setL2PabertC1(siteUtil.valueToMainframeBigDecimal(linha2
				.getPorcentagem1()));
		entrada.setL2PabertC1N(siteUtil.checkNullEntrada(linha2
				.getPorcentagem1()));
		entrada.setL2PabertC2(siteUtil.valueToMainframeBigDecimal(linha2
				.getPorcentagem2()));
		entrada.setL2PabertC2N(siteUtil.checkNullEntrada(linha2
				.getPorcentagem2()));
		entrada.setL2PabertC3(siteUtil.valueToMainframeBigDecimal(linha2
				.getPorcentagem3()));
		entrada.setL2PabertC3N(siteUtil.checkNullEntrada(linha2
				.getPorcentagem3()));

		LinhaSegmentoVO linha3 = faturamento.getLinha3();
		entrada.setL3Descricao(linha3.getDescricao());
		entrada.setL3PabertC1(siteUtil.valueToMainframeBigDecimal(linha3
				.getPorcentagem1()));
		entrada.setL3PabertC1N(siteUtil.checkNullEntrada(linha3
				.getPorcentagem1()));
		entrada.setL3PabertC2(siteUtil.valueToMainframeBigDecimal(linha3
				.getPorcentagem2()));
		entrada.setL3PabertC2N(siteUtil.checkNullEntrada(linha3
				.getPorcentagem2()));
		entrada.setL3PabertC3(siteUtil.valueToMainframeBigDecimal(linha3
				.getPorcentagem3()));
		entrada.setL3PabertC3N(siteUtil.checkNullEntrada(linha3
				.getPorcentagem3()));

		LinhaSegmentoVO linha4 = faturamento.getLinha4();
		entrada.setL4Descricao(linha4.getDescricao());
		entrada.setL4PabertC1(siteUtil.valueToMainframeBigDecimal(linha4
				.getPorcentagem1()));
		entrada.setL4PabertC1N(siteUtil.checkNullEntrada(linha4
				.getPorcentagem1()));
		entrada.setL4PabertC2(siteUtil.valueToMainframeBigDecimal(linha4
				.getPorcentagem2()));
		entrada.setL4PabertC2N(siteUtil.checkNullEntrada(linha4
				.getPorcentagem2()));
		entrada.setL4PabertC3(siteUtil.valueToMainframeBigDecimal(linha4
				.getPorcentagem3()));
		entrada.setL4PabertC3N(siteUtil.checkNullEntrada(linha4
				.getPorcentagem3()));

		LinhaSegmentoVO linha5 = faturamento.getLinha5();
		entrada.setL5Descricao(linha5.getDescricao());
		entrada.setL5PabertC1(siteUtil.valueToMainframeBigDecimal(linha5
				.getPorcentagem1()));
		entrada.setL5PabertC1N(siteUtil.checkNullEntrada(linha5
				.getPorcentagem1()));
		entrada.setL5PabertC2(siteUtil.valueToMainframeBigDecimal(linha5
				.getPorcentagem2()));
		entrada.setL5PabertC2N(siteUtil.checkNullEntrada(linha5
				.getPorcentagem2()));
		entrada.setL5PabertC3(siteUtil.valueToMainframeBigDecimal(linha5
				.getPorcentagem3()));
		entrada.setL5PabertC3N(siteUtil.checkNullEntrada(linha5
				.getPorcentagem3()));

		LinhaSegmentoVO linha6 = faturamento.getLinha6();
		entrada.setL6Descricao(linha6.getDescricao());
		entrada.setL6PabertC1(siteUtil.valueToMainframeBigDecimal(linha6
				.getPorcentagem1()));
		entrada.setL6PabertC1N(siteUtil.checkNullEntrada(linha6
				.getPorcentagem1()));
		entrada.setL6PabertC2(siteUtil.valueToMainframeBigDecimal(linha6
				.getPorcentagem2()));
		entrada.setL6PabertC2N(siteUtil.checkNullEntrada(linha6
				.getPorcentagem2()));
		entrada.setL6PabertC3(siteUtil.valueToMainframeBigDecimal(linha6
				.getPorcentagem3()));
		entrada.setL6PabertC3N(siteUtil.checkNullEntrada(linha6
				.getPorcentagem3()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABL");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABL", e);
		}

	}

	@Override
	public FaturamentoPorSegmentoVO consultaFaturamentoSegmento(
			QuestionarioSegmentoVO questionario) {

		ConsultarAberturaFatRequest request = new ConsultarAberturaFatRequest();
		ConsultarAberturaFatResponse response = new ConsultarAberturaFatResponse();
		FaturamentoPorSegmentoVO retorno = new FaturamentoPorSegmentoVO();

		request.setRICCWAEERequest(new RICCWAEERequest());

		request.getRICCWAEERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAEERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAEERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAEERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAESResponse(new RICCWAESResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAE");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAE", e);
		}

		RICCWAESResponse saida = response.getRICCWAESResponse();

		if (saida.getAnoCol1() != 0) {
			retorno.setAno1(String.valueOf(saida.getAnoCol1()));
		}
		if (saida.getAnoCol2() != 0) {
			retorno.setAno2(String.valueOf(saida.getAnoCol2()));
		}
		if (saida.getAnoCol3() != 0) {
			retorno.setAno3(String.valueOf(saida.getAnoCol3()));
		}

		LinhaSegmentoVO linha1 = new LinhaSegmentoVO();
		linha1.setDescricao(saida.getL1Descricao());
		linha1.setPorcentagem1(siteUtil.checkNullSaida(saida.getL1PabertC1()
				.toString(), saida.getL1PabertC1N()));
		linha1.setPorcentagem2(siteUtil.checkNullSaida(saida.getL1PabertC2()
				.toString(), saida.getL1PabertC2N()));
		linha1.setPorcentagem3(siteUtil.checkNullSaida(saida.getL1PabertC3()
				.toString(), saida.getL1PabertC3N()));
		retorno.setLinha1(linha1);

		LinhaSegmentoVO linha2 = new LinhaSegmentoVO();
		linha2.setDescricao(saida.getL2Descricao());
		linha2.setPorcentagem1(siteUtil.checkNullSaida(saida.getL2PabertC1()
				.toString(), saida.getL2PabertC1N()));
		linha2.setPorcentagem2(siteUtil.checkNullSaida(saida.getL2PabertC2()
				.toString(), saida.getL2PabertC2N()));
		linha2.setPorcentagem3(siteUtil.checkNullSaida(saida.getL2PabertC3()
				.toString(), saida.getL2PabertC3N()));
		retorno.setLinha2(linha2);

		LinhaSegmentoVO linha3 = new LinhaSegmentoVO();
		linha3.setDescricao(saida.getL3Descricao());
		linha3.setPorcentagem1(siteUtil.checkNullSaida(saida.getL3PabertC1()
				.toString(), saida.getL3PabertC1N()));
		linha3.setPorcentagem2(siteUtil.checkNullSaida(saida.getL3PabertC2()
				.toString(), saida.getL3PabertC2N()));
		linha3.setPorcentagem3(siteUtil.checkNullSaida(saida.getL3PabertC3()
				.toString(), saida.getL3PabertC3N()));
		retorno.setLinha3(linha3);

		LinhaSegmentoVO linha4 = new LinhaSegmentoVO();
		linha4.setDescricao(saida.getL4Descricao());
		linha4.setPorcentagem1(siteUtil.checkNullSaida(saida.getL4PabertC1()
				.toString(), saida.getL4PabertC1N()));
		linha4.setPorcentagem2(siteUtil.checkNullSaida(saida.getL4PabertC2()
				.toString(), saida.getL4PabertC2N()));
		linha4.setPorcentagem3(siteUtil.checkNullSaida(saida.getL4PabertC3()
				.toString(), saida.getL4PabertC3N()));
		retorno.setLinha4(linha4);

		LinhaSegmentoVO linha5 = new LinhaSegmentoVO();
		linha5.setDescricao(saida.getL5Descricao());
		linha5.setPorcentagem1(siteUtil.checkNullSaida(saida.getL5PabertC1()
				.toString(), saida.getL5PabertC1N()));
		linha5.setPorcentagem2(siteUtil.checkNullSaida(saida.getL5PabertC2()
				.toString(), saida.getL5PabertC2N()));
		linha5.setPorcentagem3(siteUtil.checkNullSaida(saida.getL5PabertC3()
				.toString(), saida.getL5PabertC3N()));
		retorno.setLinha5(linha5);

		LinhaSegmentoVO linha6 = new LinhaSegmentoVO();
		linha6.setDescricao(saida.getL6Descricao());
		linha6.setPorcentagem1(siteUtil.checkNullSaida(saida.getL6PabertC1()
				.toString(), saida.getL6PabertC1N()));
		linha6.setPorcentagem2(siteUtil.checkNullSaida(saida.getL6PabertC2()
				.toString(), saida.getL6PabertC2N()));
		linha6.setPorcentagem3(siteUtil.checkNullSaida(saida.getL6PabertC3()
				.toString(), saida.getL6PabertC3N()));
		retorno.setLinha6(linha6);

		return retorno;
	}

	@Override
	public void manutencaoFormaRecebimento(QuestionarioSegmentoVO questionario,
			FormaRecebimentoVO recebimento, String tipoManutencao) {
		ManutClienteFornecRequest request = new ManutClienteFornecRequest();
		ManutClienteFornecResponse response = new ManutClienteFornecResponse();

		request.setRICCWBVERequest(new RICCWBVERequest());
		request.getRICCWBVERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBVERequest().setCtpoManut(
				Integer.parseInt(tipoManutencao));
		request.getRICCWBVERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBVERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBVERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBVERequest()
				.setNcliFornc(
						siteUtil.tratarParametroInteger(recebimento
								.getNumSequencial()));
		request.getRICCWBVERequest().setCtpoCli(
				siteUtil.tratarParametroInteger(recebimento.getTipoCliente()));
		request.getRICCWBVERequest().setRcliFornc(
				recebimento.getFormaRecebimento());
		if (tipoManutencao
				.equals(TipoManutencaoEnum.INCLUSAO.getCodigoString())) {
			request.getRICCWBVERequest().setPcliFornc(
					siteUtil.valueToMainframeBigDecimal(recebimento
							.getPorcentagem()));
		} else {
			request.getRICCWBVERequest().setPcliFornc(
					siteUtil.valueToMainframeBigDecimal(recebimento
							.getPorcentagem()));
		}
		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABV");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABV", e);
		}

	}

	@Override
	public List<FormaRecebimentoVO> consultaFormaRecebimento(
			QuestionarioSegmentoVO questionario) {
		ConsultarClienteFornRequest request = new ConsultarClienteFornRequest();
		ConsultarClienteFornResponse response = new ConsultarClienteFornResponse();
		List<FormaRecebimentoVO> listaRetorno = new ArrayList<FormaRecebimentoVO>();

		request.setRICCWAOERequest(new RICCWAOERequest());
		request.getRICCWAOERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAOERequest().setMaxOcorr(50);
		request.getRICCWAOERequest().setCtpoCli(
				Integer.parseInt(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO));
		request.getRICCWAOERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAOERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAOERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAOSResponse(new RICCWAOSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAO", RICCWAOSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAO", e);
		}
		FormaRecebimentoVO item = null;
		for (RICCWAOSResponseRegistroAreaSaida reg : response
				.getRICCWAOSResponse().getAreaSaida()) {
			item = new FormaRecebimentoVO();
			item.setNumSequencial(String.valueOf(reg.getNcliFornc()));
			item.setTipoCliente(String.valueOf(reg.getCtpoCli()));
			item.setFormaRecebimento(reg.getRcliFornc());
			item.setPorcentagem(reg.getPcliFornc().toString());
			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoFornecedor(QuestionarioSegmentoVO questionario,
			FornecedorVO fornecedor, String tipoManutencao) {
		ManutClienteFornecRequest request = new ManutClienteFornecRequest();
		ManutClienteFornecResponse response = new ManutClienteFornecResponse();

		request.setRICCWBVERequest(new RICCWBVERequest());
		request.getRICCWBVERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBVERequest().setCtpoManut(
				Integer.parseInt(tipoManutencao));
		request.getRICCWBVERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBVERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBVERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBVERequest().setNcliFornc(
				siteUtil.tratarParametroInteger(fornecedor.getNumSequencial()));
		request.getRICCWBVERequest().setCtpoCli(
				siteUtil.tratarParametroInteger(fornecedor.getTipoCliente()));
		request.getRICCWBVERequest().setRcliFornc(fornecedor.getFornecedor());
		if (tipoManutencao
				.equals(TipoManutencaoEnum.INCLUSAO.getCodigoString())) {
			request.getRICCWBVERequest().setPcliFornc(
					siteUtil.valueToMainframeBigDecimal(fornecedor
							.getPorcentagem()));
		} else {
			request.getRICCWBVERequest().setPcliFornc(
					siteUtil.valueToMainframeBigDecimal(fornecedor
							.getPorcentagem()));
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABV");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABV", e);
		}
	}

	@Override
	public List<FornecedorVO> consultaFornecedor(
			QuestionarioSegmentoVO questionario) {
		ConsultarClienteFornRequest request = new ConsultarClienteFornRequest();
		ConsultarClienteFornResponse response = new ConsultarClienteFornResponse();
		List<FornecedorVO> listaRetorno = new ArrayList<FornecedorVO>();

		request.setRICCWAOERequest(new RICCWAOERequest());
		request.getRICCWAOERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAOERequest().setMaxOcorr(50);
		request.getRICCWAOERequest().setCtpoCli(
				Integer.parseInt(RiccConstants.COD_TIPO_FORNECEDOR));
		request.getRICCWAOERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAOERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAOERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAOSResponse(new RICCWAOSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAO", RICCWAOSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAO", e);
		}
		FornecedorVO item = null;
		for (RICCWAOSResponseRegistroAreaSaida reg : response
				.getRICCWAOSResponse().getAreaSaida()) {
			item = new FornecedorVO();
			item.setNumSequencial(String.valueOf(reg.getNcliFornc()));
			item.setTipoCliente(String.valueOf(reg.getCtpoCli()));
			item.setFornecedor(reg.getRcliFornc());
			item.setPorcentagem(reg.getPcliFornc().toString());
			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoHighlightsEmpresa(
			QuestionarioSegmentoVO questionario,
			List<HighlightsEmpresaVO> listaBalanco,
			TipoManutencaoEnum tipoManutencao, String nomeHighlightsEmpresa) {
		ManutBalancoEmpresaRequest request = new ManutBalancoEmpresaRequest();
		ManutBalancoEmpresaResponse response = new ManutBalancoEmpresaResponse();

		request.setRICCWBMERequest(new RICCWBMERequest());
		request.getRICCWBMERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBMERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBMERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBMERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBMERequest().setIrzScial(nomeHighlightsEmpresa);
		List<RICCWBMERequestRegistroAreaEntrada> listaEntrada = new ArrayList<RICCWBMERequestRegistroAreaEntrada>();
		RICCWBMERequestRegistroAreaEntrada item = null;
		for (int coluna = 0; coluna < listaBalanco.size(); coluna++) {
			item = new RICCWBMERequestRegistroAreaEntrada();
			item.setNbalanEmpr(coluna + 1);
			if (siteUtil
					.isNotEmptyOrNull(listaBalanco.get(coluna).getBalanco())) {
				item.setDtBalan(dateUtil.dateToString(listaBalanco.get(coluna)
						.getBalanco(), RiccConstants.FORMATO_DIA_MES_ANO));
			} else {
				item.setDtBalan("");
			}

			String receitaLiquida = siteUtil
					.valueToMainframeString(listaBalanco.get(coluna)
							.getReceitaLiquida());
			if (siteUtil.isEmptyOrNull(receitaLiquida)) {
				item.setVrectLiqNull("S");
				item.setVrectLiq(BigDecimal.ZERO);
				item.setVrectLiqS("+");
			} else {
				item.setVrectLiqNull("N");
				item.setVrectLiq(new BigDecimal(receitaLiquida.replace("-", "")));
				item.setVrectLiqS(receitaLiquida.contains("-") ? "-" : "+");
			}

			String contasReceber = siteUtil.valueToMainframeString(listaBalanco
					.get(coluna).getContasAReceber());
			if (siteUtil.isEmptyOrNull(contasReceber)) {
				item.setVcontRecNull("S");
				item.setVcontRec(BigDecimal.ZERO);
				item.setVcontRecS("+");
			} else {
				item.setVcontRecNull("N");
				item.setVcontRec(new BigDecimal(contasReceber.replace("-", "")));
				item.setVcontRecS(contasReceber.contains("-") ? "-" : "+");
			}

			String estoques = siteUtil.valueToMainframeString(listaBalanco.get(
					coluna).getEstoques());
			if (siteUtil.isEmptyOrNull(estoques)) {
				item.setVtotEstqNull("S");
				item.setVtotEstoq(BigDecimal.ZERO);
				item.setVtotEstqS("+");
			} else {
				item.setVtotEstqNull("N");
				item.setVtotEstoq(new BigDecimal(estoques.replace("-", "")));
				item.setVtotEstqS(estoques.contains("-") ? "-" : "+");
			}

			String gerBruta = siteUtil.valueToMainframeString(listaBalanco.get(
					coluna).getGerBrutaCaixa());
			if (siteUtil.isEmptyOrNull(gerBruta)) {
				item.setVrectBrtNull("S");
				item.setVrectBrut(BigDecimal.ZERO);
				item.setVrectBrutS("+");
			} else {
				item.setVrectBrtNull("N");
				item.setVrectBrut(new BigDecimal(gerBruta.replace("-", "")));
				item.setVrectBrutS(gerBruta.contains("-") ? "-" : "+");
			}

			String margemOp = siteUtil.valueToMainframeString(listaBalanco.get(
					coluna).getMargemOperacional());
			if (siteUtil.isEmptyOrNull(margemOp)) {
				item.setPmargmOpNull("S");
				item.setPmargmOper(BigDecimal.ZERO);
				item.setPmargmOperS("+");
			} else {
				item.setPmargmOpNull("N");
				item.setPmargmOper(new BigDecimal(margemOp.replace("-", "")));
				item.setPmargmOperS(margemOp.contains("-") ? "-" : "+");
			}

			String lucroLiquido = siteUtil.valueToMainframeString(listaBalanco
					.get(coluna).getLucroPrejuizoLiquido());
			if (siteUtil.isEmptyOrNull(lucroLiquido)) {
				item.setVlucroLiNull("S");
				item.setVlucroLiq(BigDecimal.ZERO);
				item.setVlucroLiqS("+");
			} else {
				item.setVlucroLiNull("N");
				item.setVlucroLiq(new BigDecimal(lucroLiquido.replace("-", "")));
				item.setVlucroLiqS(lucroLiquido.contains("-") ? "-" : "+");
			}

			String patrimonioLiquido = siteUtil
					.valueToMainframeString(listaBalanco.get(coluna)
							.getPatrimonioLiquido());
			if (siteUtil.isEmptyOrNull(patrimonioLiquido)) {
				item.setVpatrmLiNull("S");
				item.setVpatrmLiq(BigDecimal.ZERO);
				item.setVpatrmLiqS("+");
			} else {
				item.setVpatrmLiNull("N");
				item.setVpatrmLiq(new BigDecimal(patrimonioLiquido.replace("-",
						"")));
				item.setVpatrmLiqS(patrimonioLiquido.contains("-") ? "-" : "+");
			}

			String endividamentoTotal = siteUtil
					.valueToMainframeString(listaBalanco.get(coluna)
							.getEndividamentoFinanceiroTotal());
			if (siteUtil.isEmptyOrNull(endividamentoTotal)) {
				item.setVtotEndvNull("S");
				item.setVtotEndv(BigDecimal.ZERO);
				item.setVtotEndvS("+");
			} else {
				item.setVtotEndvNull("N");
				item.setVtotEndv(new BigDecimal(endividamentoTotal.replace("-",
						"")));
				item.setVtotEndvS(endividamentoTotal.contains("-") ? "-" : "+");
			}

			String disponibilidade = siteUtil
					.valueToMainframeString(listaBalanco.get(coluna)
							.getDisponibilidades());
			if (siteUtil.isEmptyOrNull(disponibilidade)) {
				item.setVdispnCxNull("S");
				item.setVdispnCx(BigDecimal.ZERO);
				item.setVdispnCxS("+");
			} else {
				item.setVdispnCxNull("N");
				item.setVdispnCx(new BigDecimal(disponibilidade
						.replace("-", "")));
				item.setVdispnCxS(disponibilidade.contains("-") ? "-" : "+");
			}

			String endividamentoLiquido = siteUtil
					.valueToMainframeString(listaBalanco.get(coluna)
							.getEndividamentoFinanceiroLiquido());
			if (siteUtil.isEmptyOrNull(endividamentoLiquido)) {
				item.setVliqEndvNull("S");
				item.setVliqEndv(BigDecimal.ZERO);
				item.setVliqEndvS("+");
			} else {
				item.setVliqEndvNull("N");
				item.setVliqEndv(new BigDecimal(endividamentoLiquido.replace(
						"-", "")));
				item.setVliqEndvS(endividamentoLiquido.contains("-") ? "-"
						: "+");
			}

			listaEntrada.add(item);
		}
		request.getRICCWBMERequest().setAreaEntrada(listaEntrada);

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABM");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABM", e);
		}
	}

	@Override
	public List<HighlightsEmpresaVO> consultaHighlightsEmpresa(
			QuestionarioSegmentoVO questionario,
			StringBuilder nomeHighlightsEmpresa) {

		ConsultarBalancoEmpRequest request = new ConsultarBalancoEmpRequest();
		ConsultarBalancoEmpResponse response = new ConsultarBalancoEmpResponse();

		request.setRICCWAFERequest(new RICCWAFERequest());

		request.getRICCWAFERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAFERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAFERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAFERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAFSResponse(new RICCWAFSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAF", RICCWAFSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAF", e);
		}

		List<HighlightsEmpresaVO> listaRetorno = new ArrayList<HighlightsEmpresaVO>();

		nomeHighlightsEmpresa.append(response.getRICCWAFSResponse()
				.getIrzScial());
		HighlightsEmpresaVO item = null;
		for (RICCWAFSResponseRegistroAreaSaida reg : response
				.getRICCWAFSResponse().getAreaSaida()) {

			item = new HighlightsEmpresaVO();

			item.setNumSequencial(String.valueOf(reg.getNbalanEmpr()));
			item.setBalanco(dateUtil.transformarStringParaDate(
					reg.getDtBalan(), "dd.MM.yyyy"));

			if (reg.getVrectLiqNull().equals("S")) {
				item.setReceitaLiquida("");
			} else {
				if (reg.getVrectLiqS().equals("-")) {
					item.setReceitaLiquida("-"
							+ reg.getVrectLiq()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setReceitaLiquida(reg.getVrectLiq()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVcontRecNull().equals("S")) {
				item.setContasAReceber("");
			} else {
				if (reg.getVcontRecS().equals("-")) {
					item.setContasAReceber("-"
							+ reg.getVcontRec()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setContasAReceber(reg.getVcontRec()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotEstqNull().equals("S")) {
				item.setEstoques("");
			} else {
				if (reg.getVtotEstqS().equals("-")) {
					item.setEstoques("-"
							+ reg.getVtotEstoq()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setEstoques(reg.getVtotEstoq()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVrectBrtNull().equals("S")) {
				item.setGerBrutaCaixa("");
			} else {
				if (reg.getVrectBrutS().equals("-")) {
					item.setGerBrutaCaixa("-"
							+ reg.getVrectBrut()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setGerBrutaCaixa(reg.getVrectBrut()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getPmargmOpNull().equals("S")) {
				item.setMargemOperacional("");
			} else {
				if (reg.getPmargmOperS().equals("-")) {
					item.setMargemOperacional("-"
							+ reg.getPmargmOper().toString());
				} else {
					item.setMargemOperacional(reg.getPmargmOper().toString());
				}
			}
			if (reg.getVlucroLiNull().equals("S")) {
				item.setLucroPrejuizoLiquido("");
			} else {
				if (reg.getVlucroLiqS().equals("-")) {
					item.setLucroPrejuizoLiquido("-"
							+ reg.getVlucroLiq()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setLucroPrejuizoLiquido(reg.getVlucroLiq()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVpatrmLiNull().equals("S")) {
				item.setPatrimonioLiquido("");
			} else {
				if (reg.getVpatrmLiqS().equals("-")) {
					item.setPatrimonioLiquido("-"
							+ reg.getVpatrmLiq()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setPatrimonioLiquido(reg.getVpatrmLiq()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVtotEndvNull().equals("S")) {
				item.setEndividamentoFinanceiroTotal("");
			} else {
				if (reg.getVtotEndvS().equals("-")) {
					item.setEndividamentoFinanceiroTotal("-"
							+ reg.getVtotEndv()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setEndividamentoFinanceiroTotal(reg.getVtotEndv()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVdispnCxNull().equals("S")) {
				item.setDisponibilidades("");
			} else {
				if (reg.getVdispnCxS().equals("-")) {
					item.setDisponibilidades("-"
							+ reg.getVdispnCx()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setDisponibilidades(reg.getVdispnCx()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			if (reg.getVliqEndvNull().equals("S")) {
				item.setEndividamentoFinanceiroLiquido("");
			} else {
				if (reg.getVliqEndvS().equals("-")) {
					item.setEndividamentoFinanceiroLiquido("-"
							+ reg.getVliqEndv()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setEndividamentoFinanceiroLiquido(reg.getVliqEndv()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}
			listaRetorno.add(item);
		}
		return listaRetorno;
	}

	@Override
	public void manutencaoImportacoesExportacoes(
			QuestionarioSegmentoVO questionario,
			List<ImportacoesExportacoesVO> listaVolume, String tipoManutencao,
			String tipoMoeda) {
		ManutExposicaoCambRequest request = new ManutExposicaoCambRequest();
		ManutExposicaoCambResponse response = new ManutExposicaoCambResponse();

		request.setRICCWBNERequest(new RICCWBNERequest());
		request.getRICCWBNERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBNERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBNERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWBNERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));
		request.getRICCWBNERequest().setTpoMoeda(tipoMoeda);

		List<RICCWBNERequestRegistroAreaEntrada> listaEntrada = request
				.getRICCWBNERequest().getAreaEntrada();
		RICCWBNERequestRegistroAreaEntrada item = null;
		for (int coluna = 0; coluna < listaVolume.size(); coluna++) {
			item = new RICCWBNERequestRegistroAreaEntrada();
			String ano = listaVolume.get(coluna).getAno();
			if (siteUtil.isNotEmptyOrNull(ano)) {
				while (ano.length() < 4) {
					ano = "0" + ano;
				}
				String mes = "";
				if (coluna != 2) {
					mes = "01";
				} else {
					mes = listaVolume.get(coluna).getMes();
					while (mes.length() < 2) {
						mes = "0" + mes;
					}
					listaVolume.get(coluna).setMes(mes);
				}
				item.setDtInfo("01." + mes + "." + ano);

			} else {
				item.setDtInfo("");
			}
			item.setNmercdExter(coluna + 1);

			String importacao = siteUtil.valueToMainframeString(listaVolume
					.get(coluna).getImportacao());
			if (siteUtil.isEmptyOrNull(importacao)) {
				item.setVtotImporNull("S");
				item.setVtotImpor(BigDecimal.ZERO);
				item.setVtotImporS("+");
			} else {
				item.setVtotImporNull("N");
				item.setVtotImpor(new BigDecimal(importacao.replace("-", "")));
				item.setVtotImporS(importacao.contains("-") ? "-" : "+");
			}

			String exportacao = siteUtil.valueToMainframeString(listaVolume
					.get(coluna).getExportacao());
			if (siteUtil.isEmptyOrNull(exportacao)) {
				item.setVtotExporNull("S");
				item.setVtotExpor(BigDecimal.ZERO);
				item.setVtotExporS("+");
			} else {
				item.setVtotExporNull("N");
				item.setVtotExpor(new BigDecimal(exportacao.replace("-", "")));
				item.setVtotExporS(exportacao.contains("-") ? "-" : "+");
			}

			listaEntrada.add(item);
		}
		request.getRICCWBNERequest().setAreaEntrada(listaEntrada);

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABN");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABN", e);
		}

	}

	@Override
	public List<ImportacoesExportacoesVO> consultaImportacoesExportacoes(
			QuestionarioSegmentoVO questionario, StringBuilder moeda) {

		ConsultarExposicaoRequest request = new ConsultarExposicaoRequest();
		ConsultarExposicaoResponse response = new ConsultarExposicaoResponse();

		request.setRICCWAGERequest(new RICCWAGERequest());

		request.getRICCWAGERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAGERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAGERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAGERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAGSResponse(new RICCWAGSResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAAG", RICCWAGSResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAG", e);
		}

		List<ImportacoesExportacoesVO> listaRetorno = new ArrayList<ImportacoesExportacoesVO>();

		moeda.append(response.getRICCWAGSResponse().getTpoMoeda());
		ImportacoesExportacoesVO item = null;
		for (RICCWAGSResponseRegistroAreaSaida reg : response
				.getRICCWAGSResponse().getAreaSaida()) {
			item = new ImportacoesExportacoesVO();
			// GregorianCalendar cal = (GregorianCalendar)
			// Calendar.getInstance(new Locale("pt_BR"));
			Calendar cal = new GregorianCalendar();
			if (siteUtil.isNotEmptyOrNull(reg.getDtInfo())) {
				cal.setTime(dateUtil.transformarStringParaDate(reg.getDtInfo(),
						RiccConstants.FORMATO_DIA_MES_ANO));

				item.setAno(String.valueOf(cal.get(Calendar.YEAR)));
				// Calendar funciona como um vetor. mes 0 = janeiro, fevereiro =
				// 1, ...
				item.setMes(String.valueOf(1 + Integer.parseInt(String
						.valueOf(cal.get(Calendar.MONTH)))));

			} else {
				item.setAno("");
				item.setMes("");
			}

			if (reg.getVtotImporNull().equals("S")) {
				item.setImportacao("");
			} else {
				if (reg.getVtotImporS().equals("-")) {
					item.setImportacao("-"
							+ reg.getVtotImpor()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setImportacao(reg.getVtotImpor()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}

			if (reg.getVtotExporNull().equals("S")) {
				item.setExportacao("");
			} else {
				if (reg.getVtotExporS().equals("-")) {
					item.setExportacao("-"
							+ reg.getVtotExpor()
									.setScale(0, BigDecimal.ROUND_UP)
									.toString());
				} else {
					item.setExportacao(reg.getVtotExpor()
							.setScale(0, BigDecimal.ROUND_UP).toString());
				}
			}

			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoPerspectivas(QuestionarioSegmentoVO questionario,
			PerspectivasVO perspectiva, String tipoManutencao) {
		ManutPerspectivaEmpRequest request = new ManutPerspectivaEmpRequest();
		ManutPerspectivaEmpResponse response = new ManutPerspectivaEmpResponse();
		request.setRICCWBPERequest(new RICCWBPERequest());

		RICCWBPERequest entrada = request.getRICCWBPERequest();
		entrada.setNversaoOrige(siteUtil.tratarParametroInteger(questionario
				.getVersaoOrigem()));
		entrada.setCgrpEconm(siteUtil.tratarParametroInteger(questionario
				.getCodGrupo()));
		entrada.setCtpoManut(Integer.parseInt(tipoManutencao));
		entrada.setNrelatCredt(siteUtil.tratarParametroInteger(questionario
				.getCodRelatorio()));
		entrada.setNrelatSgmto(siteUtil.tratarParametroInteger(questionario
				.getCodSegmentoRelatorio()));

		String faturamento = siteUtil.valueToMainframeString(perspectiva
				.getFaturamento());
		if (siteUtil.isEmptyOrNull(faturamento)) {
			entrada.setFtmtNull("S");
			entrada.setVtotFtmt(BigDecimal.ZERO);
			entrada.setVtotFtmtS("+");
		} else {
			entrada.setFtmtNull("N");
			entrada.setVtotFtmt(new BigDecimal(faturamento.replace("-", "")));
			entrada.setVtotFtmtS(faturamento.contains("-") ? "-" : "+");
		}

		String ebitida = siteUtil.valueToMainframeString(perspectiva
				.getEbitda());
		if (siteUtil.isEmptyOrNull(ebitida)) {
			entrada.setVebitdaNull("S");
			entrada.setVebitda(BigDecimal.ZERO);
			entrada.setVebitdaS("+");
		} else {
			entrada.setVebitdaNull("N");
			entrada.setVebitda(new BigDecimal(ebitida.replace("-", "")));
			entrada.setVebitdaS(ebitida.contains("-") ? "-" : "+");
		}

		String lucroLiq = siteUtil.valueToMainframeString(perspectiva
				.getLucroLiquido());
		if (siteUtil.isEmptyOrNull(lucroLiq)) {
			entrada.setVlucroNull("S");
			entrada.setVlucroLiq(BigDecimal.ZERO);
			entrada.setVlucroLiqS("+");
		} else {
			entrada.setVlucroNull("N");
			entrada.setVlucroLiq(new BigDecimal(lucroLiq.replace("-", "")));
			entrada.setVlucroLiqS(lucroLiq.contains("-") ? "-" : "+");
		}

		String dividaBancaria = siteUtil.valueToMainframeString(perspectiva
				.getDividaBancaria());
		if (siteUtil.isEmptyOrNull(dividaBancaria)) {
			entrada.setVdividaNull("S");
			entrada.setVdividaBca(BigDecimal.ZERO);
			entrada.setVdividaBcaS("+");
		} else {
			entrada.setVdividaNull("N");
			entrada.setVdividaBca(new BigDecimal(dividaBancaria
					.replace("-", "")));
			entrada.setVdividaBcaS(dividaBancaria.contains("-") ? "-" : "+");
		}

		String posicaoCaixa = siteUtil.valueToMainframeString(perspectiva
				.getPosicaoCaixa());
		if (siteUtil.isEmptyOrNull(posicaoCaixa)) {
			entrada.setVposicaoNull("S");
			entrada.setVposicaoCx(BigDecimal.ZERO);
			entrada.setVposicaoCxS("+");
		} else {
			entrada.setVposicaoNull("N");
			entrada.setVposicaoCx(new BigDecimal(posicaoCaixa.replace("-", "")));
			entrada.setVposicaoCxS(posicaoCaixa.contains("-") ? "-" : "+");
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABP");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABP", e);
		}
	}

	@Override
	public PerspectivasVO consultaPerspectivas(
			QuestionarioSegmentoVO questionario) {

		ConsultarPerspectivaRequest request = new ConsultarPerspectivaRequest();
		ConsultarPerspectivaResponse response = new ConsultarPerspectivaResponse();

		request.setRICCWAIERequest(new RICCWAIERequest());

		request.getRICCWAIERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAIERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAIERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAIERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAISResponse(new RICCWAISResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAI");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAI", e);
		}

		PerspectivasVO item = new PerspectivasVO();

		if (response.getRICCWAISResponse().getFtmtNull().equals("S")) {
			item.setFaturamento("");
		} else {
			if (response.getRICCWAISResponse().getVtotFtmtS().equals("-")) {
				item.setFaturamento("-"
						+ response.getRICCWAISResponse().getVtotFtmt()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setFaturamento(response.getRICCWAISResponse()
						.getVtotFtmt().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAISResponse().getVebitdaNull().equals("S")) {
			item.setEbitda("");
		} else {
			if (response.getRICCWAISResponse().getVebitdaS().equals("-")) {
				item.setEbitda("-"
						+ response.getRICCWAISResponse().getVebitda()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setEbitda(response.getRICCWAISResponse().getVebitda()
						.setScale(0, BigDecimal.ROUND_UP).toString());
			}
		}

		if (response.getRICCWAISResponse().getVlucroNull().equals("S")) {
			item.setLucroLiquido("");
		} else {
			if (response.getRICCWAISResponse().getVlucroLiqS().equals("-")) {
				item.setLucroLiquido("-"
						+ response.getRICCWAISResponse().getVlucroLiq()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setLucroLiquido(response.getRICCWAISResponse()
						.getVlucroLiq().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAISResponse().getVdividaNull().equals("S")) {
			item.setDividaBancaria("");
		} else {
			if (response.getRICCWAISResponse().getVdividaBcaS().equals("-")) {
				item.setDividaBancaria("-"
						+ response.getRICCWAISResponse().getVdividaBca()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setDividaBancaria(response.getRICCWAISResponse()
						.getVdividaBca().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAISResponse().getVposicaoNull().equals("S")) {
			item.setPosicaoCaixa("");
		} else {
			if (response.getRICCWAISResponse().getVposicaoCxS().equals("-")) {
				item.setPosicaoCaixa("-"
						+ response.getRICCWAISResponse().getVposicaoCx()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setPosicaoCaixa(response.getRICCWAISResponse()
						.getVposicaoCx().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		return item;
	}

	@Override
	public void manutencaoVolumeBradesco(QuestionarioSegmentoVO questionario,
			VolumeBradescoVO volume, String tipoManutencao) {
		// ManutReciprocidadeGpRequest request = new
		// ManutReciprocidadeGpRequest();
		// ManutReciprocidadeGpResponse response = new
		// ManutReciprocidadeGpResponse();
		// request.setRICCWBTERequest(new RICCWBTERequest());
		//
		// RICCWBTERequest entrada = request.getRICCWBTERequest();
		// entrada.setNversaoOrige(siteUtil.tratarParametroInteger(questionario
		// .getVersaoOrigem()));
		// entrada.setCgrpEconm(siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		// entrada.setNrelatCredt(siteUtil.tratarParametroInteger(questionario
		// .getCodRelatorio()));
		// entrada.setNrelatSgmto(siteUtil.tratarParametroInteger(questionario
		// .getCodSegmentoRelatorio()));
		// String data = "";
		// if (siteUtil.isNotEmptyOrNull(volume.getAno()) &&
		// siteUtil.isNotEmptyOrNull(volume.getMes())) {
		// String ano = volume.getAno();
		// String mes = volume.getMes();
		// while (ano.length() < 4) {
		// ano = "0" + ano;
		// }
		// while (mes.length() < 2) {
		// mes = "0" + mes;
		// }
		// data = "01." + mes + "." + ano;
		// }
		// entrada.setDtInfo(data);
		//
		// String cobrancaValor =
		// siteUtil.valueToMainframeString(volume.getCobrancaValor());
		// if (siteUtil.isEmptyOrNull(cobrancaValor)) {
		// entrada.setVvolumCobrNull("S");
		// entrada.setVvolumCobr(BigDecimal.ZERO);
		// entrada.setVvolumCobrS("+");
		// } else {
		// entrada.setVvolumCobrNull("N");
		// entrada.setVvolumCobr(new BigDecimal(cobrancaValor.replace("-",
		// "")));
		// entrada.setVvolumCobrS(cobrancaValor.contains("-") ? "-" : "+");
		// }
		//
		// String cobrancaQtd = siteUtil.valueToMainframeString(volume
		// .getCobrancaQuantidade());
		// if (siteUtil.isEmptyOrNull(cobrancaQtd)) {
		// entrada.setQtRecddCobrNull("S");
		// entrada.setQtRecddCobr(0);
		// } else {
		// entrada.setQtRecddCobrNull("N");
		// entrada.setQtRecddCobr(siteUtil.tratarParametroInteger(cobrancaQtd));
		// }
		//
		// String cobrancaResult = siteUtil.valueToMainframeString(volume
		// .getCobrancaResultLiq());
		// if(siteUtil.isEmptyOrNull(cobrancaResult)) {
		// entrada.setVresulCobrNull("S");
		// entrada.setVresulCobr(BigDecimal.ZERO);
		// entrada.setVresulCobrS("+");
		// } else {
		// entrada.setVresulCobrNull("N");
		// entrada.setVresulCobr(new BigDecimal(cobrancaResult.replace("-",
		// "")));
		// entrada.setVresulCobrS(cobrancaResult.contains("-") ? "-" : "+");
		// }
		//
		// String pagforValor = siteUtil.valueToMainframeString(volume
		// .getPagforValor());
		// if (siteUtil.isEmptyOrNull(pagforValor)) {
		// entrada.setVvolumForncNull("S");
		// entrada.setVvolumFornc(BigDecimal.ZERO);
		// entrada.setVvolumForncS("+");
		// } else {
		// entrada.setVvolumForncNull("N");
		// entrada.setVvolumFornc(new BigDecimal(pagforValor.replace("-", "")));
		// entrada.setVvolumForncS(pagforValor.contains("-") ? "-" : "+");
		// }
		//
		// String pagforQtd = siteUtil.valueToMainframeString(volume
		// .getPagforQuantidade());
		// if (siteUtil.isEmptyOrNull(pagforQtd)) {
		// entrada.setQtRecddForncNull("S");
		// entrada.setQtRecddFornc(0);
		// } else {
		// entrada.setQtRecddForncNull("N");
		// entrada.setQtRecddFornc(siteUtil.tratarParametroInteger(pagforQtd));
		// }
		//
		// String pagforResult = siteUtil.valueToMainframeString(volume
		// .getPagforResultLiq());
		// if (siteUtil.isEmptyOrNull(pagforResult)) {
		// entrada.setVrectaForncNull("S");
		// entrada.setVrectaFornc(BigDecimal.ZERO);
		// entrada.setVrectaForncS("+");
		// } else {
		// entrada.setVrectaForncNull("N");
		// entrada.setVrectaFornc(new BigDecimal(pagforResult.replace("-",
		// "")));
		// entrada.setVrectaForncS(pagforResult.contains("-") ? "-" : "+");
		// }
		//
		// String ptrbValor = siteUtil.valueToMainframeString(volume
		// .getPtrbValor());
		// if (siteUtil.isEmptyOrNull(ptrbValor)) {
		// entrada.setVrecddTribtNull("S");
		// entrada.setVrecddTribt(BigDecimal.ZERO);
		// entrada.setVrecddTribtS("+");
		// } else {
		// entrada.setVrecddTribtNull("N");
		// entrada.setVrecddTribt(new BigDecimal(ptrbValor.replace("-", "")));
		// entrada.setVrecddTribtS(ptrbValor.contains("-") ? "-" : "+");
		// }
		//
		// String ptrbQtd = siteUtil.valueToMainframeString(volume
		// .getPtrbQuantidade());
		// if (siteUtil.isEmptyOrNull(ptrbQtd)) {
		// entrada.setQtRecddTribtNull("S");
		// entrada.setQtRecddTribt(0);
		// } else {
		// entrada.setQtRecddTribtNull("N");
		// entrada.setQtRecddTribt(siteUtil.tratarParametroInteger(ptrbQtd));
		// }
		//
		// String empresaValor = siteUtil.valueToMainframeString(volume
		// .getNetEmpresaValor());
		// if (siteUtil.isEmptyOrNull(empresaValor)) {
		// entrada.setVemprBdscoNull("S");
		// entrada.setVemprBdsco(BigDecimal.ZERO);
		// entrada.setVemprBdscoS("+");
		// } else {
		// entrada.setVemprBdscoNull("N");
		// entrada.setVemprBdsco(new BigDecimal(empresaValor.replace("-", "")));
		// entrada.setVemprBdscoS(empresaValor.contains("-") ? "-" : "+");
		// }
		//
		// String empresaQtd = siteUtil.valueToMainframeString(volume
		// .getNetEmpresaQuantidade());
		// if (siteUtil.isEmptyOrNull(empresaQtd)) {
		// entrada.setQtEmprBsdcoNull("S");
		// entrada.setQtEmprBsdco(0);
		// } else {
		// entrada.setQtEmprBsdcoNull("N");
		// entrada.setQtEmprBsdco(siteUtil.tratarParametroInteger(empresaQtd));
		// }
		//
		// String folhaValor = siteUtil.valueToMainframeString(volume
		// .getFolhaPabValor());
		// if (siteUtil.isEmptyOrNull(folhaValor)) {
		// entrada.setVflSalrlNull("S");
		// entrada.setVflSalrl(BigDecimal.ZERO);
		// entrada.setVflSalrlS("+");
		// } else {
		// entrada.setVflSalrlNull("N");
		// entrada.setVflSalrl(new BigDecimal(folhaValor.replace("-", "")));
		// entrada.setVflSalrlS(folhaValor.contains("-") ? "-" : "+");
		// }
		//
		// String folhaQtd = siteUtil.valueToMainframeString(volume
		// .getFolhaPabQtdFuncionarios());
		// if (siteUtil.isEmptyOrNull(folhaQtd)) {
		// entrada.setQtTotFuncNull("S");
		// entrada.setQtTotFunc(0);
		// } else {
		// entrada.setQtTotFuncNull("N");
		// entrada.setQtTotFunc(siteUtil.tratarParametroInteger(folhaQtd));
		// }
		//
		// String folhaResult = siteUtil.valueToMainframeString(volume
		// .getFolhaPabResultado());
		// if (siteUtil.isEmptyOrNull(folhaResult)) {
		// entrada.setVresulEmprNull("S");
		// entrada.setVresulEmpr(BigDecimal.ZERO);
		// entrada.setVresulEmprS("+");
		// } else {
		// entrada.setVresulEmprNull("N");
		// entrada.setVresulEmpr(new BigDecimal(folhaResult.replace("-", "")));
		// entrada.setVresulEmprS(folhaResult.contains("-") ? "-" : "+");
		// }
		//
		// String creditoValor = siteUtil.valueToMainframeString(volume
		// .getCreditoConsignadoValor());
		// if (siteUtil.isEmptyOrNull(creditoValor)) {
		// entrada.setVtotCredtNull("S");
		// entrada.setVtotCredt(BigDecimal.ZERO);
		// entrada.setVtotCredtS("+");
		// } else {
		// entrada.setVtotCredtNull("N");
		// entrada.setVtotCredt(new BigDecimal(creditoValor.replace("-", "")));
		// entrada.setVtotCredtS(creditoValor.contains("-") ? "-" : "+");
		// }
		//
		// String creditoQtd = siteUtil.valueToMainframeString(volume
		// .getCreditoConsignadoQtdFuncionarios());
		// if (siteUtil.isEmptyOrNull(creditoQtd)) {
		// entrada.setQtTotCredtNull("S");
		// entrada.setQtTotCredt(0);
		// } else {
		// entrada.setQtTotCredtNull("N");
		// entrada.setQtTotCredt(siteUtil.tratarParametroInteger(creditoQtd));
		// }
		//
		// String creditoResult = siteUtil.valueToMainframeString(volume
		// .getCreditoConsignadoResultado());
		// if (siteUtil.isEmptyOrNull(creditoResult)) {
		// entrada.setVresulCredtNull("S");
		// entrada.setVresulCredt(BigDecimal.ZERO);
		// entrada.setVresulCredtS("+");
		// } else {
		// entrada.setVresulCredtNull("N");
		// entrada.setVresulCredt(new BigDecimal(creditoResult.replace("-",
		// "")));
		// entrada.setVresulCredtS(creditoResult.contains("-") ? "-" : "+");
		// }
		//
		// try {
		// adapterCWS.invokeProcessFromNC(request, response, "RICCIABT");
		// } catch (Exception e){
		// siteUtil.throwException("RICCIABT", e);
		// }

	}

	@Override
	public VolumeBradescoVO consultaVolumeBradesco(
			QuestionarioSegmentoVO questionario) {

		ConsultarReciprocidaRequest request = new ConsultarReciprocidaRequest();
		ConsultarReciprocidaResponse response = new ConsultarReciprocidaResponse();

		request.setRICCWAMERequest(new RICCWAMERequest());

		request.getRICCWAMERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWAMERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWAMERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWAMERequest().setNrelatSgmto(
				siteUtil.tratarParametroInteger(questionario
						.getCodSegmentoRelatorio()));

		response.setRICCWAMSResponse(new RICCWAMSResponse());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAM");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAM", e);
		}

		VolumeBradescoVO item = new VolumeBradescoVO();

		if (siteUtil.isNotEmptyOrNull(response.getRICCWAMSResponse()
				.getDtInfo())) {

			Date date = dateUtil.transformarStringParaDate(response
					.getRICCWAMSResponse().getDtInfo(),
					RiccConstants.FORMATO_DIA_MES_ANO);

			if (siteUtil.isNotNull(date)) {
				item.setAno(dateUtil.dateToString(date, "yyyy"));
				item.setMes(dateUtil.dateToString(date, "MM"));
			}

		}

		if (response.getRICCWAMSResponse().getVvolumCobrNull().equals("S")) {
			item.setCobrancaValor("");
		} else {
			if (response.getRICCWAMSResponse().getVvolumCobrS().equals("-")) {
				item.setCobrancaValor("-"
						+ response.getRICCWAMSResponse().getVvolumCobr()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setCobrancaValor(response.getRICCWAMSResponse()
						.getVvolumCobr().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAMSResponse().getQtRecddCobrNull().equals("S")) {
			item.setCobrancaQuantidade("");
		} else {
			item.setCobrancaQuantidade(String.valueOf(response
					.getRICCWAMSResponse().getQtRecddCobr()));
		}

		if (response.getRICCWAMSResponse().getVresulCobrNull().equals("S")) {
			item.setCobrancaResultLiq("");
		} else {
			if (response.getRICCWAMSResponse().getVresulCobrS().equals("-")) {
				item.setCobrancaResultLiq("-"
						+ response.getRICCWAMSResponse().getVresulCobr()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setCobrancaResultLiq(response.getRICCWAMSResponse()
						.getVresulCobr().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		// Fornecedor
		if (response.getRICCWAMSResponse().getVvolumForncNull().equals("S")) {
			item.setPagforValor("");
		} else {
			if (response.getRICCWAMSResponse().getVvolumForncS().equals("-")) {
				item.setPagforValor("-"
						+ response.getRICCWAMSResponse().getVvolumFornc()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setPagforValor(response.getRICCWAMSResponse()
						.getVvolumFornc().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAMSResponse().getQtRecddForncNull().equals("S")) {
			item.setPagforQuantidade("");
		} else {
			item.setPagforQuantidade(String.valueOf(response
					.getRICCWAMSResponse().getQtRecddFornc()));
		}

		if (response.getRICCWAMSResponse().getVrectaForncNull().equals("S")) {
			item.setPagforResultLiq("");
		} else {
			if (response.getRICCWAMSResponse().getVrectaForncS().equals("-")) {
				item.setPagforResultLiq("-"
						+ response.getRICCWAMSResponse().getVrectaFornc()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setPagforResultLiq(response.getRICCWAMSResponse()
						.getVrectaFornc().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		// Tributos
		if (response.getRICCWAMSResponse().getVrecddTribtNull().equals("S")) {
			item.setPtrbValor("");
		} else {
			if (response.getRICCWAMSResponse().getVrecddTribtS().equals("-")) {
				item.setPtrbValor("-"
						+ response.getRICCWAMSResponse().getVrecddTribt()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setPtrbValor(response.getRICCWAMSResponse()
						.getVrecddTribt().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAMSResponse().getQtRecddTribtNull().equals("S")) {
			item.setPtrbQuantidade("");
		} else {
			item.setPtrbQuantidade(String.valueOf(response
					.getRICCWAMSResponse().getQtRecddTribt()));
		}

		// Empresa
		if (response.getRICCWAMSResponse().getVemprBdscoNull().equals("S")) {
			item.setNetEmpresaValor("");
		} else {
			if (response.getRICCWAMSResponse().getVemprBdscoS().equals("-")) {
				item.setNetEmpresaValor("-"
						+ response.getRICCWAMSResponse().getVemprBdsco()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setNetEmpresaValor(response.getRICCWAMSResponse()
						.getVemprBdsco().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAMSResponse().getQtEmprBsdcoNull().equals("S")) {
			item.setNetEmpresaQuantidade("");
		} else {
			item.setNetEmpresaQuantidade(String.valueOf(response
					.getRICCWAMSResponse().getQtEmprBsdco()));
		}

		// Folha
		if (response.getRICCWAMSResponse().getVflSalrlNull().equals("S")) {
			item.setFolhaPabValor("");
		} else {
			if (response.getRICCWAMSResponse().getVflSalrlS().equals("-")) {
				item.setFolhaPabValor("-"
						+ response.getRICCWAMSResponse().getVflSalrl()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setFolhaPabValor(response.getRICCWAMSResponse()
						.getVflSalrl().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAMSResponse().getQtTotFuncNull().equals("S")) {
			item.setFolhaPabQtdFuncionarios("");
		} else {
			item.setFolhaPabQtdFuncionarios(String.valueOf(response
					.getRICCWAMSResponse().getQtTotFunc()));
		}

		if (response.getRICCWAMSResponse().getVresulEmprNull().equals("S")) {
			item.setFolhaPabResultado("");
		} else {
			if (response.getRICCWAMSResponse().getVresulEmprS().equals("-")) {
				item.setFolhaPabResultado("-"
						+ response.getRICCWAMSResponse().getVresulEmpr()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setFolhaPabResultado(response.getRICCWAMSResponse()
						.getVresulEmpr().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		// Credito Consignado
		if (response.getRICCWAMSResponse().getVtotCredtNull().equals("S")) {
			item.setCreditoConsignadoValor("");
		} else {
			if (response.getRICCWAMSResponse().getVtotCredtS().equals("-")) {
				item.setCreditoConsignadoValor("-"
						+ response.getRICCWAMSResponse().getVtotCredt()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setCreditoConsignadoValor(response.getRICCWAMSResponse()
						.getVtotCredt().setScale(0, BigDecimal.ROUND_UP)
						.toString());
			}
		}

		if (response.getRICCWAMSResponse().getQtTotCredtNull().equals("S")) {
			item.setCreditoConsignadoQtdFuncionarios("");
		} else {
			item.setCreditoConsignadoQtdFuncionarios(String.valueOf(response
					.getRICCWAMSResponse().getQtTotCredt()));
		}

		if (response.getRICCWAMSResponse().getVresulCredtNull().equals("S")) {
			item.setCreditoConsignadoResultado("");
		} else {
			if (response.getRICCWAMSResponse().getVresulCredtS().equals("-")) {
				item.setCreditoConsignadoResultado("-"
						+ response.getRICCWAMSResponse().getVresulCredt()
								.setScale(0, BigDecimal.ROUND_UP).toString());
			} else {
				item.setCreditoConsignadoResultado(response
						.getRICCWAMSResponse().getVresulCredt()
						.setScale(0, BigDecimal.ROUND_UP).toString());
			}
		}

		return item;
	}

	@Override
	public Integer manutencaoSetores(QuestionarioSegmentoVO questionario,
			TipoQuestionarioVO setor, String tipoManutencao) {
		ManutRelSetorialRequest request = new ManutRelSetorialRequest();
		ManutRelSetorialResponse response = new ManutRelSetorialResponse();

		request.setRICCWCHERequest(new RICCWCHERequest());

		request.getRICCWCHERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCHERequest().setCidtfdSetor(
				siteUtil.tratarParametroInteger(setor.getCodigo()));
		request.getRICCWCHERequest().setCtpoManut(
				siteUtil.tratarParametroInteger(tipoManutencao));
		request.getRICCWCHERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWCHERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACH");

		} catch (Exception e) {
			siteUtil.throwException("RICCIACH", e);
		}

		return request.getRICCWCHERequest().getCidtfdSetor();

	}

	public void manutencaoSetorAgro(QuestionarioSegmentoVO questionario,
			QuestionarioAgronegocioVO setor, TipoManutencaoEnum tipoManutencao) {
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
		request.getRICCWCJERequest().setIusinaAcucr(
				setor.getAbaUsinas().getNomeUsina());
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

	public void manutencaoSetorImobiliario(QuestionarioSegmentoVO questionario,
			QuestionarioImobiliarioVO setor, TipoManutencaoEnum tipoManutencao) {
		ManutRelImobiliarioRequest request = new ManutRelImobiliarioRequest();
		ManutRelImobiliarioResponse response = new ManutRelImobiliarioResponse();

		request.setRICCWCKERequest(new RICCWCKERequest());

		request.getRICCWCKERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWCKERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCKERequest().setCtpoManut(tipoManutencao.getCodigo());
		request.getRICCWCKERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		request.getRICCWCKERequest().setCidtfdResid(
				siteUtil.converterBooleanSimNao(setor.getQuestionario()
						.getEmpreendimentoResidencial()));
		request.getRICCWCKERequest().setCidtfdComl(
				siteUtil.converterBooleanSimNao(setor.getQuestionario()
						.getEmpreendimentoComercial()));
		request.getRICCWCKERequest().setCbaixaRenda(
				siteUtil.converterBooleanSimNao(setor.getQuestionario()
						.getBaixaRenda()));
		request.getRICCWCKERequest().setCmedRenda(
				siteUtil.converterBooleanSimNao(setor.getQuestionario()
						.getClasseMedia()));
		request.getRICCWCKERequest().setCaltaRenda(
				siteUtil.converterBooleanSimNao(setor.getQuestionario()
						.getAltoPadrao()));
		request.getRICCWCKERequest().setCconstPpria(
				siteUtil.converterBooleanSimNao(setor.getQuestionario()
						.getPropria()));
		request.getRICCWCKERequest().setCconstTceira(
				siteUtil.converterBooleanSimNao(setor.getQuestionario()
						.getTerceirizada()));
		request.getRICCWCKERequest().setRconstTceira(
				setor.getQuestionario().getNomeTerceirizada());
		if (tipoManutencao.equals(TipoManutencaoEnum.ALTERACAO)) {
			request.getRICCWCKERequest().setPpreChave(
					siteUtil.valueToMainframeBigDecimal(setor.getQuestionario()
							.getPreChaves()));
			request.getRICCWCKERequest().setPposChave(
					siteUtil.valueToMainframeBigDecimal(setor.getQuestionario()
							.getPosChaves()));
		} else {
			request.getRICCWCKERequest().setPpreChave(BigDecimal.ZERO);
			request.getRICCWCKERequest().setPposChave(BigDecimal.ZERO);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACK");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACK", e);
		}

	}

	public void manutencaoSetorProjetos(QuestionarioSegmentoVO questionario,
			QuestionarioProjetoVO setor, TipoManutencaoEnum tipoManutencao) {
		ManutRelProjetosRequest request = new ManutRelProjetosRequest();
		ManutRelProjetosResponse response = new ManutRelProjetosResponse();

		request.setRICCWCMERequest(new RICCWCMERequest());

		request.getRICCWCMERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWCMERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCMERequest().setCtpoManut(tipoManutencao.getCodigo());
		request.getRICCWCMERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		request.getRICCWCMERequest().setIprojEmpr(setor.getNomeProjeto());

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACM");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACM", e);
		}

	}

	public void manutencaoSetorTransporte(QuestionarioSegmentoVO questionario,
			QuestionarioTransportesVO setor, TipoManutencaoEnum tipoManutencao) {
		ManutRelTransporteRequest request = new ManutRelTransporteRequest();
		ManutRelTransporteResponse response = new ManutRelTransporteResponse();
		request.setRICCWCLERequest(new RICCWCLERequest());

		RICCWCLERequest entrada = request.getRICCWCLERequest();

		entrada.setNversaoOrige(siteUtil.tratarParametroInteger(questionario
				.getVersaoOrigem()));
		entrada.setCgrpEconm(siteUtil.tratarParametroInteger(questionario
				.getCodGrupo()));
		entrada.setCtpoManut(tipoManutencao.getCodigo());
		entrada.setNrelatCredt(siteUtil.tratarParametroInteger(questionario
				.getCodRelatorio()));

		if (tipoManutencao.equals(TipoManutencaoEnum.ALTERACAO)) {
			DadosTransportesDatabaseVO transporteDatabase = setor
					.getDadosTransportesDatabase();
			entrada.setDbaseInfo(dateUtil.dateToString(new Date(),
					RiccConstants.FORMATO_DIA_MES_ANO));
			entrada.setQveicFrota(siteUtil
					.tratarParametroInteger(transporteDatabase.getQtdVeiculos()));
			entrada.setVveicFrota(siteUtil
					.valueToMainframeBigDecimal(transporteDatabase
							.getValorFrota()));
			entrada.setVsdoDvdorFrt(siteUtil
					.valueToMainframeBigDecimal(transporteDatabase
							.getSaldoDevedorFinameLeasing()));
			entrada.setPgrauAlieFrt(siteUtil
					.valueToMainframeBigDecimal(transporteDatabase
							.getPrcGrauAlienacaoFrota()));
			entrada.setNidadeMedFrt(siteUtil
					.tratarParametroInteger(transporteDatabase
							.getIdadeMediaAnos()));
			entrada.setVmesFinanFrt(siteUtil
					.valueToMainframeBigDecimal(transporteDatabase
							.getDesembolsoMensalFinameLeasing()));
			entrada.setVmesCaptlGro(siteUtil
					.valueToMainframeBigDecimal(transporteDatabase
							.getDesembolsoMensalCagiro()));
			entrada.setVfatmtMedMes(siteUtil
					.valueToMainframeBigDecimal(transporteDatabase
							.getFaturamentoMedioMensal()));
			entrada.setPcompmRecta(siteUtil.valueToMainframeBigDecimal(transporteDatabase
					.getPrcGrauComprometimentoReceitasComFinameLeasing()));
			entrada.setPcompmCaptl(siteUtil.valueToMainframeBigDecimal(transporteDatabase
					.getPrcGrauComprometimentoReceitasComFinameLeasingCagiro()));
			entrada.setPultExerc(siteUtil
					.valueToMainframeBigDecimal(transporteDatabase
							.getPrcMargemEbitdaUltimoExercicio()));
		} else {
			entrada.setDbaseInfo("");
			entrada.setQveicFrota(0);
			entrada.setVveicFrota(BigDecimal.ZERO);
			entrada.setVsdoDvdorFrt(BigDecimal.ZERO);
			entrada.setPgrauAlieFrt(BigDecimal.ZERO);
			entrada.setNidadeMedFrt(0);
			entrada.setVmesFinanFrt(BigDecimal.ZERO);
			entrada.setVmesCaptlGro(BigDecimal.ZERO);
			entrada.setVfatmtMedMes(BigDecimal.ZERO);
			entrada.setPcompmRecta(BigDecimal.ZERO);
			entrada.setPcompmCaptl(BigDecimal.ZERO);
			entrada.setPultExerc(BigDecimal.ZERO);
		}

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACL");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACL", e);
		}
	}

	@Override
	public List<TipoQuestionarioVO> consultaSetores(
			QuestionarioSegmentoVO questionario) {
		ConsultarRelSetorialRequest request = new ConsultarRelSetorialRequest();
		ConsultarRelSetorialResponse response = new ConsultarRelSetorialResponse();
		List<TipoQuestionarioVO> listaRetorno = new ArrayList<TipoQuestionarioVO>();

		request.setRICCWBAERequest(new RICCWBAERequest());
		request.getRICCWBAERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(questionario
								.getVersaoOrigem()));
		request.getRICCWBAERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWBAERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		response.setRICCWBASResponse(new RICCWBASResponse());
		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABA");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABA", e);
		}

		if (response.getRICCWBASResponse().getCidtfdTrnsp() == Numeros.UM) {
			listaRetorno.add(new TipoQuestionarioVO(
					"questionarioTransportesBean",
					RiccConstants.SETOR_TRANSPORTES, "Transportes"));
		}
		if (response.getRICCWBASResponse().getCidtfdImobl() == Numeros.UM) {
			listaRetorno.add(new TipoQuestionarioVO(
					"questionarioImobiliarioBean",
					RiccConstants.SETOR_IMOBILIARIO, "Imobiliário"));
		}
		if (response.getRICCWBASResponse().getCidtfdAgric() == Numeros.UM) {
			listaRetorno.add(new TipoQuestionarioVO(
					"questionarioAgronegocioBean",
					RiccConstants.SETOR_AGRONEGOCIO, "Agronegócio"));
		}
		if (response.getRICCWBASResponse().getCidtfdProj() == Numeros.UM) {
			listaRetorno.add(new TipoQuestionarioVO("questionarioProjetoBean",
					RiccConstants.SETOR_PROJETOS, "Projetos"));
		}

		return listaRetorno;
	}

	@Override
	public void manutencaoComentarios(QuestionarioSegmentoVO questionario,
			List<ComentarioVO> comentarios, String tipoManutencao)
			throws RiccException {
		ManutComentariosRequest request = new ManutComentariosRequest();
		ManutComentariosResponse response = new ManutComentariosResponse();
		request.setRICCWCGERequest(new RICCWCGERequest());

		List<RICCWCGERequestRegistroAreaEntrada> listaEntrada = new ArrayList<RICCWCGERequestRegistroAreaEntrada>();

		RICCWCGERequestRegistroAreaEntrada registro = null;
		for (ComentarioVO comentario : comentarios) {
			registro = new RICCWCGERequestRegistroAreaEntrada();
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
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWCGERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));

		adapterCWS.invokeProcessFromNC(request, response, "RICCIACG");
	}

	@Override
	public List<ComentarioVO> consultaComentarios(
			QuestionarioSegmentoVO questionario, String codTipoComentario) {
		// TODO Alterar codTipoComentario de String p/ Enum
		ConsultarComentariosRequest request = new ConsultarComentariosRequest();
		ConsultarComentariosResponse response = new ConsultarComentariosResponse();
		List<ComentarioVO> listaRetorno = new ArrayList<ComentarioVO>();
		request.setRICCWA9ERequest(new RICCWA9ERequest());
		request.getRICCWA9ERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(questionario.getCodGrupo()));
		request.getRICCWA9ERequest()
				.setNrelatCredt(
						siteUtil.tratarParametroInteger(questionario
								.getCodRelatorio()));
		request.getRICCWA9ERequest().setCtpoComent(
				siteUtil.tratarParametroInteger(codTipoComentario));

		response.setRICCWA9SResponse(new RICCWA9SResponse());

		try {
			response = invokeProcessAutoPagination(request, response,
					"RICCIAA9", RICCWA9SResponseRegistroAreaSaida.class);
		} catch (Exception e) {
			siteUtil.throwException("RICCIAA9", e);
		}
		ComentarioVO item = null;
		for (RICCWA9SResponseRegistroAreaSaida reg : response
				.getRICCWA9SResponse().getAreaSaida()) {
			item = new ComentarioVO();
			item.setCodSequencial(String.valueOf(reg.getCseqComent()));
			item.setCodTipo(String.valueOf(reg.getCtpoComent()));
			item.setComentario(reg.getRcomenRelt().replace("|", "\n"));
			listaRetorno.add(item);
		}

		return listaRetorno;
	}

	public String manutencaoRelatorioInfoCredito(QuestionarioSegmentoVO vo,
			TipoFuncaoEnum tipoFuncao, SituacaoRelatorioEnum situacaoRelatorio,
			SegmentoEnum segmento) {

		ManutencaoRICRequest request = new ManutencaoRICRequest();
		ManutencaoRICResponse response = new ManutencaoRICResponse();

		boolean agro = false;
		boolean imobiliario = false;
		boolean transporte = false;
		boolean projetos = false;

		for (TipoQuestionarioVO tp : vo.getSetorSelecionado()) {
			if (tp.getCodigo() == 1) {
				agro = true;
			}

			if (tp.getCodigo() == 2) {
				imobiliario = true;
			}

			if (tp.getCodigo() == 3) {
				projetos = true;
			}

			if (tp.getCodigo() == 4) {
				transporte = true;
			}
		}
		vo.setCodSituacaoRelatorio(situacaoRelatorio.getCodigo().toString());
		request.getRICCWBHERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(vo.getCodGrupo()));
		request.getRICCWBHERequest().setCidtfdAgric(agro ? 1 : 2);
		request.getRICCWBHERequest().setCidtfdImobl(imobiliario ? 1 : 2);
		request.getRICCWBHERequest().setCidtfdProj(projetos ? 1 : 2);
		request.getRICCWBHERequest().setCidtfdTrnsp(transporte ? 1 : 2);
		request.getRICCWBHERequest().setCsgmtoRelat(segmento.getCodigo());
		request.getRICCWBHERequest()
				.setCsitRelat(situacaoRelatorio.getCodigo());
		request.getRICCWBHERequest().setCtpoFuncao(tipoFuncao.getCodigo());
		request.getRICCWBHERequest().setCusuarIncl(
				BradescoSecurityUtilsDelegate.getPrincipal().toUpperCase());
		request.getRICCWBHERequest().setNomeRelat(vo.getNomeRelatorio());
		request.getRICCWBHERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(vo.getCodRelatorio()));
		request.getRICCWBHERequest().setNversaoOrige(0);
		request.getRICCWBHERequest().setFILLER98("");

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABH");
		} catch (Exception e) {
			siteUtil.throwException("RICCIABH", e);
		}

		if (tipoFuncao.equals(TipoFuncaoEnum.NOVO)) {
			vo.setCodGrupo(String.valueOf(response.getRICCWBHSResponse()
					.getCgrpEconm()));
			vo.setCodRelatorio(String.valueOf(response.getRICCWBHSResponse()
					.getNrelatCredt()));
		}
		return String.valueOf(response.getRICCWBHSResponse().getNrelatCredt());
	}

	@SuppressWarnings("deprecation")
	public String manutencaoRelatorioSegmento(QuestionarioSegmentoVO vo,
			TipoManutencaoEnum tipoManutencao) {

		ManutRelSegmentoRequest request = new ManutRelSegmentoRequest();
		ManutRelSegmentoResponse response = new ManutRelSegmentoResponse();
		request.setRICCWCIERequest(new RICCWCIERequest());
		request.getRICCWCIERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(vo.getCodGrupo()));
		request.getRICCWCIERequest().setCplanoSucss(
				siteUtil.tratarParametroInteger(vo.getPlanoSucessao()));
		request.getRICCWCIERequest().setCtpoAdmEmpr(
				siteUtil.tratarParametroInteger(vo.getAdministracao()));
		request.getRICCWCIERequest().setCtpoManut(tipoManutencao.getCodigo());
		request.getRICCWCIERequest().setNrelatCredt(
				siteUtil.tratarParametroInteger(vo.getCodRelatorio()));
		request.getRICCWCIERequest().setNversaoOrige(0);
		request.getRICCWCIERequest().setRinadpCart(vo.getInformarAtraso());
		request.getRICCWCIERequest().setFILLER136("");

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACI");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACI", e);
		}

		return response.getTexmens();

	}

	public String excluirRelatorio(String codGrupo, Integer numeroRelatorio) {
		ManutExclusaoRelatRequest request = new ManutExclusaoRelatRequest();
		ManutExclusaoRelatResponse response = new ManutExclusaoRelatResponse();

		String retorno = "";

		request.setRICCWBTERequest(new RICCWBTERequest());
		request.getRICCWBTERequest().setCgrpEconm(Integer.parseInt(codGrupo));
		request.getRICCWBTERequest().setNrelatCredt(numeroRelatorio);

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABT");
			retorno = "Relatorio excluido com sucesso";
		} catch (Exception e) {
			siteUtil.throwException("RICCIABT", e);
			retorno = e.getMessage();
		}

		return retorno;
	}

	public Integer copiarCadastro(CadastramentoVO itemSelecionado,
			String codGrupo) {

		CopiarRelatorioRequest request = new CopiarRelatorioRequest();
		CopiarRelatorioResponse response = new CopiarRelatorioResponse();

		request.setRICCWCOERequest(new RICCWCOERequest());

		request.getRICCWCOERequest().setNversaoOrige(0);
		request.getRICCWCOERequest().setCgrpEconm(Integer.valueOf(codGrupo));
		request.getRICCWCOERequest().setNrelatCredt(
				itemSelecionado.getCodRelatorio());
		request.getRICCWCOERequest().setCodUsuar(
				BradescoSecurityUtilsDelegate.getPrincipal().toUpperCase());

		response.setRICCWCOSResponse(new RICCWCOSResponse());
		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACO");
		} catch (Exception e) {
			siteUtil.throwException("RICCIACO", e);
		}

		itemSelecionado.setCodRelatorio(response.getRICCWCOSResponse()
				.getNrelatCredt());

		return response.getRICCWCOSResponse().getNrelatCredt();
	}

}