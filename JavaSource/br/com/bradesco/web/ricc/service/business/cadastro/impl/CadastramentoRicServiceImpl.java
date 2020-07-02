package br.com.bradesco.web.ricc.service.business.cadastro.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.pagination.cws.baseconnector.CWSBusinessServiceBaseConnector;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.ricc.enums.SegmentoEnum;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.request.ConsultarRICRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.request.RICCWAAERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response.ConsultarRICResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response.RICCWAASResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response.RICCWAASResponseRegistroAreaSaida;
import br.com.bradesco.web.ricc.service.business.cadastro.ICadastramentoRicService;
import br.com.bradesco.web.ricc.utils.SiteUtil;

@Named("cadastramentoRicService")
public class CadastramentoRicServiceImpl implements ICadastramentoRicService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Named("CWSBusinessServiceBaseConnector")
	private CWSBusinessServiceBaseConnector adapterCWS = null;

	private SiteUtil siteUtil = SiteUtil.getInstance();

	@Override
	public RetornoPesquisaCadastramentoVO carregarListaCadastro(
			PesquisaCadastramentoVO dadosEntrada) {

		/**
		 * @object request = objeto com os parametros a serem enviados para
		 *         transação CSW de consulta
		 * @object response = objeto com dados retornados da transação CSW de
		 *         consulta
		 */
		ConsultarRICRequest request = new ConsultarRICRequest();
		ConsultarRICResponse response = new ConsultarRICResponse();

		/**
		 * @object retorno = objeto a ser retornado para tela com os dados a
		 *         serem exibidos
		 * @object lista = lista de objeto a ser retornado para tela com os
		 *         dados a para preenchimento da tabela
		 */
		RetornoPesquisaCadastramentoVO retorno = new RetornoPesquisaCadastramentoVO();
		List<CadastramentoVO> lista = new ArrayList<CadastramentoVO>();

		request.setRICCWAAERequest(new RICCWAAERequest());
		request.getRICCWAAERequest()
				.setNversaoOrige(
						siteUtil.tratarParametroInteger(dadosEntrada
								.getVersaoOrigem()));
		request.getRICCWAAERequest().setMaxOcorr(Numeros.DEZ);
		request.getRICCWAAERequest().setCtpoPsqsa(
				dadosEntrada.getTipoPesquisa());
		request.getRICCWAAERequest().setCnpjEmpr(
				siteUtil.tratarParametroInteger(dadosEntrada.getCnpj()));
		request.getRICCWAAERequest().setCgrpEconm(
				siteUtil.tratarParametroInteger(dadosEntrada.getNumGrupo()));
		request.getRICCWAAERequest().setNomeGrp(
				dadosEntrada.getNomeGrupo().toUpperCase());
		request.getRICCWAAERequest().setStatusRel(
				siteUtil.tratarParametroInteger(dadosEntrada.getStatus()));

		response.setRICCWAASResponse(new RICCWAASResponse());

		try {
			/**
			 * @process efetua chamada ao mainframe enviando o request,
			 *          response, transação e tipo de conexão
			 */
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAA",
					"cws", "RICCIAAA");
		} catch (Exception e) {
			siteUtil.throwException("RICCIAAA", e);
		}

		retorno.setCodGrupo(String.valueOf(response.getRICCWAASResponse()
				.getCgrpEconm()));
		retorno.setNomeGrupo(response.getRICCWAASResponse().getNomeGrp());

		for (RICCWAASResponseRegistroAreaSaida reg : response
				.getRICCWAASResponse().getAreaSaida()) {
			if (reg.getNrelatCredt() != 0) {
				CadastramentoVO item = new CadastramentoVO();
				SegmentoEnum segmento = SegmentoEnum.getByCodigo(reg
						.getCsgmtoRelat());
				item.setCodRelatorio(reg.getNrelatCredt());
				item.setNomeRelatorio(reg.getNomeRelat());
				item.setCodSegmento(segmento.getCodigoString());
				item.setSegmento(segmento.getDescricao().toUpperCase());
				item.setFlagSetorTransporte(reg.getCidtfdTrnsp());
				item.setFlagSetorImobiliario(reg.getCidtfdImobl());
				item.setFlagSetorAgricola(reg.getCidtfdAgric());
				item.setFlagSetorProjeto(reg.getCidtfdProj());
				item.setCodSituacao(reg.getCsitRelat());
				item.setDescSituacao(siteUtil.converterCodStatus(reg
						.getCsitRelat()));
				item.setData(reg.getDataRel());
				item.setHora(reg.getHoraRel());
				item.setUsuarioInclusao(reg.getCusuarIncl());
				lista.add(item);
			}
		}
		retorno.setListaCadastro(lista);

		return retorno;
	}

}
