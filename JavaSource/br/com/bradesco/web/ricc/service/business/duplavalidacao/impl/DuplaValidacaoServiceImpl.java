package br.com.bradesco.web.ricc.service.business.duplavalidacao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.bradesco.web.ricc.model.duplavalidacao.DuplaValidacaoVO;
import br.com.bradesco.web.ricc.model.parametrizacao.ListaObrigatoriedadeParamVO;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.request.ConsultarDuplaValidaRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.request.RICCWAHERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response.ConsultarDuplaValidaResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response.RICCWAHSResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response.RICCWAHSResponseRegistroAreaDeDeSegmentos;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response.RICCWAHSResponseRegistroAreaParaParaSegmentos;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutDuplaValidacao.request.ManutDuplaValidacaoRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutDuplaValidacao.request.RICCWBOERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutDuplaValidacao.response.ManutDuplaValidacaoResponse;
import br.com.bradesco.web.ricc.service.business.BaseService;
import br.com.bradesco.web.ricc.service.business.duplavalidacao.IDuplaValidacaoService;
import br.com.bradesco.web.ricc.utils.DateUtil;
import br.com.bradesco.web.ricc.utils.RiccConstants;

@Named("duplaValidacaoService")
public class DuplaValidacaoServiceImpl extends BaseService implements IDuplaValidacaoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6215494803659220827L;
	
	protected DateUtil dateUtil = DateUtil.getCurrentInstance();
	
	@Override
	public void manutencaoDuplaValidacao (int tipoManutencao, DuplaValidacaoVO modelDe, DuplaValidacaoVO modelPara, String justificativa, String usuarioLogado){
		
		ManutDuplaValidacaoRequest request = new ManutDuplaValidacaoRequest();
		ManutDuplaValidacaoResponse response = new ManutDuplaValidacaoResponse();
		
		request.setRICCWBOERequest(new RICCWBOERequest());
		
		request.getRICCWBOERequest().setCsitValdcReg(tipoManutencao);
		request.getRICCWBOERequest().setNparmzDe(modelDe.getNumeroParametrizacao());
		request.getRICCWBOERequest().setNparmzPara(modelPara.getNumeroParametrizacao());
		request.getRICCWBOERequest().setCusuarValdc(usuarioLogado);
		request.getRICCWBOERequest().setRjustif(justificativa);
		
		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIABO");
		} catch (Exception e){
			siteUtil.throwException("RICCIABO", e);
		}
		
	}
	
	@Override
	public List<DuplaValidacaoVO> consultaDuplaValidacao (int codOrigem){
		
		ConsultarDuplaValidaRequest request = new ConsultarDuplaValidaRequest();
		ConsultarDuplaValidaResponse response = new ConsultarDuplaValidaResponse();
		
		request.setRICCWAHERequest(new RICCWAHERequest());
		
		request.getRICCWAHERequest().setNversaoOrige(codOrigem);
		
		response.setRICCWAHSResponse(new RICCWAHSResponse());
		
		try {
			adapterCWS.invokeProcessFromNC(request, response, "RICCIAAH");
		} catch (Exception e){
			siteUtil.throwException("RICCIAAH", e);
		}
		
		List<DuplaValidacaoVO> listaRetorno = new ArrayList<DuplaValidacaoVO>();
		ListaObrigatoriedadeParamVO obrigatorio = null;
		List<ListaObrigatoriedadeParamVO> listaObrigatorio = null;
		DuplaValidacaoVO de = new DuplaValidacaoVO();
		DuplaValidacaoVO para = new DuplaValidacaoVO();
		
		//DE
		de.setNumeroParametrizacao(response.getRICCWAHSResponse().getDeNparmz());
		listaObrigatorio = new ArrayList<ListaObrigatoriedadeParamVO>();

		for(RICCWAHSResponseRegistroAreaDeDeSegmentos deSegmento : response.getRICCWAHSResponse().getDeSegmentos()){
			switch (deSegmento.getDeCindcdSgmto()) {
			case 1:
				if (deSegmento.getDeCindcdObrigt() == 1) {
					obrigatorio = new ListaObrigatoriedadeParamVO(1, "Corporate");
					listaObrigatorio.add(obrigatorio);
				}
				break;
			case 2:
				if (deSegmento.getDeCindcdObrigt() == 1) {
					obrigatorio = new ListaObrigatoriedadeParamVO(2, "Corporate One");
					listaObrigatorio.add(obrigatorio);
				}
				break;
			case 3:
				if (deSegmento.getDeCindcdObrigt() == 1) {
					obrigatorio = new ListaObrigatoriedadeParamVO(3, "Varejo");
					listaObrigatorio.add(obrigatorio);
				}
				break;
			case 4:
				if (deSegmento.getDeCindcdObrigt() == 1) {
					obrigatorio = new ListaObrigatoriedadeParamVO(4, "Large Corporate");
					listaObrigatorio.add(obrigatorio);
				}
				break;
			}
		}
		
		de.setListaObrigatoriedadeSelecionada(listaObrigatorio);
		de.setValidadeMeses(String.valueOf(response.getRICCWAHSResponse().getDeTvladdRelat()));
		de.setRiscoTotal(response.getRICCWAHSResponse().getDeVrisco().toString());
		de.setUsuarioSolicitacao(response.getRICCWAHSResponse().getDeCusuarAtulz());
	
		if(siteUtil.isNotEmptyOrNull(response.getRICCWAHSResponse().getDeHatulzRelat())){
			de.setDataSolicitacao(dateUtil.changeStringDateFormat(response.getRICCWAHSResponse().getDeHatulzRelat().substring(0, 19), RiccConstants.TIMESTAMP_MENOR, RiccConstants.FORMATO_DATA_HORA));
		}
		de.setValidacao(response.getRICCWAHSResponse().getDeCusuarValdc());
		if(siteUtil.isNotEmptyOrNull(response.getRICCWAHSResponse().getDeHvaldcReg())){
			de.setDataValidacao(dateUtil.changeStringDateFormat(response.getRICCWAHSResponse().getDeHvaldcReg().substring(0, 19), RiccConstants.TIMESTAMP_MENOR, RiccConstants.FORMATO_DATA_HORA));
		}
		
		listaRetorno.add(de);
		
		//PARA
		para.setNumeroParametrizacao(response.getRICCWAHSResponse().getParaNparmz());
		listaObrigatorio = new ArrayList<ListaObrigatoriedadeParamVO>();
		
		for(RICCWAHSResponseRegistroAreaParaParaSegmentos paraSegmento : response.getRICCWAHSResponse().getParaSegmentos()){
			switch (paraSegmento.getParaCindcdSgmto()) {
			case 1:
				if (paraSegmento.getParaCindcdObrigt() == 1) {
					obrigatorio = new ListaObrigatoriedadeParamVO(1, "Corporate");
					listaObrigatorio.add(obrigatorio);
				}
				break;
			case 2:
				if (paraSegmento.getParaCindcdObrigt() == 1) {
					obrigatorio = new ListaObrigatoriedadeParamVO(2, "Corporate One");
					listaObrigatorio.add(obrigatorio);
				}
				break;
			case 3:
				if (paraSegmento.getParaCindcdObrigt() == 1) {
					obrigatorio = new ListaObrigatoriedadeParamVO(3, "Varejo");
					listaObrigatorio.add(obrigatorio);
				}
				break;
			case 4:
				if (paraSegmento.getParaCindcdObrigt() == 1) {
					obrigatorio = new ListaObrigatoriedadeParamVO(4, "Large Corporate");
					listaObrigatorio.add(obrigatorio);
				}
				break;
			}
		}
		
		para.setListaObrigatoriedadeSelecionada(listaObrigatorio);
		para.setValidadeMeses(String.valueOf(response.getRICCWAHSResponse().getParaTvladdRelat()));
		para.setRiscoTotal(response.getRICCWAHSResponse().getParaVrisco().toString());
		para.setUsuarioSolicitacao(response.getRICCWAHSResponse().getParaCusuarAtulz());
		if(siteUtil.isNotEmptyOrNull(response.getRICCWAHSResponse().getParaHatulzRelat())){
			para.setDataSolicitacao(dateUtil.changeStringDateFormat(response.getRICCWAHSResponse().getParaHatulzRelat().substring(0, 19), RiccConstants.TIMESTAMP_MENOR, RiccConstants.FORMATO_DATA_HORA));
		}
		listaRetorno.add(para);
		
		return listaRetorno;
		
	}

}
