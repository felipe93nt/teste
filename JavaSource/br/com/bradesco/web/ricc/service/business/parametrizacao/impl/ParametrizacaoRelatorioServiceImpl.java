package br.com.bradesco.web.ricc.service.business.parametrizacao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.pagination.cws.baseconnector.CWSBusinessServiceBaseConnector;
import br.com.bradesco.web.aq.application.security.utils.BradescoSecurityUtilsDelegate;
import br.com.bradesco.web.ricc.model.parametrizacao.ListaObrigatoriedadeParamVO;
import br.com.bradesco.web.ricc.model.parametrizacao.RelatorioParametrizacaoVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.request.DetalharParamRelatRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.request.RICCWBBERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.response.DetalharParamRelatResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.response.RICCWBBSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.response.RICCWBBSResponseRegistroSegmentos;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request.ManutParamRelatorioRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request.RICCWCNERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request.RICCWCNERequestRegistroSegmentos;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.response.ManutParamRelatorioResponse;
import br.com.bradesco.web.ricc.service.business.parametrizacao.IParametrizacaoRelatorioService;
import br.com.bradesco.web.ricc.utils.Numeros;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.SiteUtil;

@Named("parametrizacaoRelatorioService")
public class ParametrizacaoRelatorioServiceImpl implements
		IParametrizacaoRelatorioService {

	/**
	 *
	 */
	private static final long serialVersionUID = -6789555878960725661L;
	
	@Inject
    @Named("CWSBusinessServiceBaseConnector")
	private CWSBusinessServiceBaseConnector adapterCWS = null;

	private SiteUtil siteUtil = SiteUtil.getInstance();

	@SuppressWarnings("deprecation")
	@Override
	public String salvarRelatorio(RelatorioParametrizacaoVO relatorio) {
		
		ManutParamRelatorioRequest  request = new ManutParamRelatorioRequest();
		ManutParamRelatorioResponse response = new ManutParamRelatorioResponse();
		
		request.setRICCWCNERequest(new RICCWCNERequest());
		
		request.getRICCWCNERequest().setNversaoOrige(Numeros.UM);
		request.getRICCWCNERequest().setNparmzRelat(Numeros.UM);

		request.getRICCWCNERequest().setPzvalddRelat(siteUtil.tratarParametroInteger(relatorio.getValidadeMeses()));
		request.getRICCWCNERequest().setVriscoTot(siteUtil.valueToMainframeBigDecimal(relatorio.getRiscoTotal()));

	 	request.getRICCWCNERequest().setCusuarAtulz(BradescoSecurityUtilsDelegate.getPrincipal().toUpperCase());
	 	
		List<RICCWCNERequestRegistroSegmentos> segmentos = new ArrayList<RICCWCNERequestRegistroSegmentos>();

		for (int i = 1; i < 11; i++) {
			RICCWCNERequestRegistroSegmentos seg = new RICCWCNERequestRegistroSegmentos();
			switch (i) {
			case 1:
				seg.setCindcdSgmto(i);
				seg.setCindcdObrigt(2);
				for (ListaObrigatoriedadeParamVO vo : relatorio.getListaObrigatoriedade()) {
					if (Long.valueOf(vo.getCodigo()).equals(RiccConstants.SEGMENTO_CORPORATE)) {
						seg.setCindcdObrigt(1);
					}
				}			
				break;
			case 2:
				seg.setCindcdSgmto(i);
				seg.setCindcdObrigt(2);
				for (ListaObrigatoriedadeParamVO vo : relatorio.getListaObrigatoriedade()) {
					if (Long.valueOf(vo.getCodigo()).equals (RiccConstants.SEGMENTO_EMPRESAS)) {
						seg.setCindcdObrigt(1);
					}
				}				
				break;
			case 3:
				seg.setCindcdSgmto(i);
				seg.setCindcdObrigt(2);
				for (ListaObrigatoriedadeParamVO vo : relatorio.getListaObrigatoriedade()) {
					if (Long.valueOf(vo.getCodigo()).equals(RiccConstants.SEGMENTO_ALTOVAREJO)) {
						seg.setCindcdObrigt(1);
					}
				}				
				break;
			case 4:
				seg.setCindcdSgmto(i);
				seg.setCindcdObrigt(2);
				for (ListaObrigatoriedadeParamVO vo : relatorio.getListaObrigatoriedade()) {
					if (Long.valueOf(vo.getCodigo()).equals(RiccConstants.SEGMENTO_LARGE_CORPORATE)) {
						seg.setCindcdObrigt(1);
					}
				}				
				break;
			
			default:
				seg.setCindcdSgmto(0);
				seg.setCindcdObrigt(0);
				break;
			}
			segmentos.add(seg);
		}
		
		request.getRICCWCNERequest().setSegmentos(segmentos);
		
		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIACN");
		} catch (Exception e){
			siteUtil.throwException("RICCIACN", e);
		}
		return response.getTexmens();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.service.business.parametrizacao.
	 * IParametrizacaoRelatorioService#detalharRelatorio()
	 */
	@Override
	public RelatorioParametrizacaoVO detalharRelatorio() {
		RelatorioParametrizacaoVO vo = new RelatorioParametrizacaoVO();
		vo.setListaObrigatoriedade(new ArrayList<ListaObrigatoriedadeParamVO>());
		ListaObrigatoriedadeParamVO itemLista = new ListaObrigatoriedadeParamVO();
		DetalharParamRelatRequest request = new DetalharParamRelatRequest();
		DetalharParamRelatResponse response = new DetalharParamRelatResponse();
		request.setRICCWBBERequest(new RICCWBBERequest());
		response.setRICCWBBSResponse(new RICCWBBSResponse());

		request.getRICCWBBERequest().setNparmzRelat(Numeros.UM);
		request.getRICCWBBERequest().setNversaoOrige(Numeros.UM);

		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABB");
		} catch (Exception e){
			siteUtil.throwException("RICCIABB", e);
		}

		vo.setValidadeMeses(response.getRICCWBBSResponse().getPzvalddRelat());
		vo.setUsuario(response.getRICCWBBSResponse().getCusuarAtulz());
		vo.setDataAlteracao(response.getRICCWBBSResponse().getHatulzParmz());
		
		vo.setRiscoTotal(SiteUtil.getInstance().formatValoresToString(
				response.getRICCWBBSResponse().getVriscoTot().toString()));

		for (RICCWBBSResponseRegistroSegmentos seg : response.getRICCWBBSResponse().getSegmentos()) {
			switch (seg.getCindcdSgmto()) {
			case 1:
				if (seg.getCindcdObrigt() == 1) {
					itemLista.setCodigo(1);
					vo.getListaObrigatoriedade().add(itemLista);
					itemLista = new ListaObrigatoriedadeParamVO();
				}
				break;
			case 2:
				if (seg.getCindcdObrigt() == 1) {
					itemLista.setCodigo(2);
					vo.getListaObrigatoriedade().add(itemLista);
					itemLista = new ListaObrigatoriedadeParamVO();
				}
				break;
			case 3:
				if (seg.getCindcdObrigt() == 1) {
					itemLista.setCodigo(3);
					vo.getListaObrigatoriedade().add(itemLista);
					itemLista = new ListaObrigatoriedadeParamVO();
				}
				break;
			case 4:
				if (seg.getCindcdObrigt() == 1) {
					itemLista.setCodigo(4);
					vo.getListaObrigatoriedade().add(itemLista);
					itemLista = new ListaObrigatoriedadeParamVO();
				}
				break;
			}
		}
		return vo;
	}
}
