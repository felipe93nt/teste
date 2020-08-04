package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.fluxoPgtoModal.impl;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc.Dtvencouprazocalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc.Dtvencouprazocalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc.Npccwx6erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc.Npccwx6sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb.Npccwvxerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb.Npccwvxsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb.Validaprevisaodesembrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb.Validaprevisaodesembresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.fluxoPgtoModal.IFluxoPgtoModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoInclBean;

@Named("fluxoPgtoModalService")
@RequestScoped
public class FluxoPgtoModalServiceImpl extends BaseService implements IFluxoPgtoModalService {
    @Inject
    @Named("tradeFinanceNegociacaoInclBean")
    protected TradeFinanceNegociacaoInclBean tradeFinanceNegociacaoInclBean;
	
    	/**
    	* Nome: calcularDataVencimentoOuPrazo
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 11/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
	public void  calcularDataVencimentoOuPrazo(TrdFinNegFluxoPagtoVO flxPgtVO, TrdFinNegParcelaVO irregularVO) {
    	
        Dtvencouprazocalcrequest request = new Dtvencouprazocalcrequest();
        Dtvencouprazocalcresponse response = new Dtvencouprazocalcresponse();
        Npccwx6erequest entrada = new Npccwx6erequest();
        Npccwx6sresponse saida = new Npccwx6sresponse();
        request.setNpccwx6erequest(entrada);
        response.setNpccwx6sresponse(saida);
        
        entrada.setCpais(flxPgtVO.getCpais());
        if (flxPgtVO.getNomePrincPeriodicidade().equals("Irregular")) {
            entrada.setDprevtdsembcmbio(SiteUtil.stringDataWebToMainframe(irregularVO.getVencimentoFluxoPgto()));
            entrada.setDvctopcelatrade(SiteUtil.dataWebToMainframe(irregularVO.getDateVctopcelatrade()));
            entrada.setTdiaprzooper(irregularVO.getTdianegocpcela());

            // Fluxo: NPCCIAPL - Books: NPCCWX6E / NPCCWX6S
            listaSemPaginacao(request, response, "DTVENCOUPRAZOCALC");

            irregularVO.setTdianegocpcela(response.getNpccwx6sresponse().getTdiaprzooper());
            irregularVO.setDvctopcelatrade(response.getNpccwx6sresponse().getDvctopcelatrade());
            irregularVO.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
            irregularVO.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
            
            irregularVO.setMensagem(null);
            if(response.getCodmens().equals("NPCC0901") || response.getCodmens().equals("NPCC0902") || response.getCodmens().equals("NPCC0903")) {
                irregularVO.setMensagem(response.getTexmens());
            }
		} else {
			for (int i = 0; i < flxPgtVO.getListaParcelasFluxoPgto().size(); i++) {
				//trdFinNegParcelaVO = new TrdFinNegParcelaVO();
				if (i == 0) {
					entrada.setDprevtdsembcmbio(SiteUtil.stringDataWebToMainframe(flxPgtVO.getDprevtdsembcmbio()));
					entrada.setDvctopcelatrade("");
		            entrada.setTdiaprzooper(flxPgtVO.getListaParcelasFluxoPgto().get(i).getTdianegocpcela());
				} else {
					entrada.setDprevtdsembcmbio(SiteUtil.stringDataWebToMainframe(flxPgtVO.getDprevtdsembcmbio()));
					entrada.setDvctopcelatrade(SiteUtil.stringDataWebToMainframe(flxPgtVO.getListaParcelasFluxoPgto().get(i).getDvctopcelatrade()));
		            entrada.setTdiaprzooper(flxPgtVO.getListaParcelasFluxoPgto().get(i).getTdianegocpcela());
				}
				
	            // Fluxo: NPCCIAPL - Books: NPCCWX6E / NPCCWX6S
	            listaSemPaginacao(request, response, "DTVENCOUPRAZOCALC");
	            
	            flxPgtVO.getListaParcelasFluxoPgto().get(i).setTdianegocpcela(response.getNpccwx6sresponse().getTdiaprzooper());
	            flxPgtVO.getListaParcelasFluxoPgto().get(i).setDvctopcelatrade(response.getNpccwx6sresponse().getDvctopcelatrade());
	            flxPgtVO.getListaParcelasFluxoPgto().get(i).setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
	            flxPgtVO.getListaParcelasFluxoPgto().get(i).setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
	            
	            
	            flxPgtVO.getListaParcelasFluxoPgto().get(i).setMensagem(null);
	            if(response.getCodmens().equals("NPCC0901") || response.getCodmens().equals("NPCC0902") || response.getCodmens().equals("NPCC0903")) {
	            	flxPgtVO.getListaParcelasFluxoPgto().get(i).setMensagem(response.getTexmens());
	            }
			}
		}
    }
	
	public void  calcularDataVencimentoOuPrazoLinha(TrdFinNegocInclVO tradeFinNegocVO, TrdFinNegFluxoPagtoVO flxPgtVO, TrdFinNegParcelaVO irregularVO , Integer linhaAlterada) {
    	
        Dtvencouprazocalcrequest request = new Dtvencouprazocalcrequest();
        Dtvencouprazocalcresponse response = new Dtvencouprazocalcresponse();
        Npccwx6erequest entrada = new Npccwx6erequest();
        Npccwx6sresponse saida = new Npccwx6sresponse();
        request.setNpccwx6erequest(entrada);
        response.setNpccwx6sresponse(saida);
        
        entrada.setCpais(flxPgtVO.getCpais());
        if (flxPgtVO.getNomePrincPeriodicidade().equals("Irregular")) {
            entrada.setDprevtdsembcmbio(SiteUtil.stringDataWebToMainframe(irregularVO.getVencimentoFluxoPgto()));
            entrada.setDvctopcelatrade(SiteUtil.dataWebToMainframe(irregularVO.getDateVctopcelatrade()));
            entrada.setDvctopcelatrade("          ");
            entrada.setTdiaprzooper(irregularVO.getTdianegocpcela());

            // Fluxo: NPCCIAPL - Books: NPCCWX6E / NPCCWX6S
            listaSemPaginacao(request, response, "DTVENCOUPRAZOCALC");

            irregularVO.setTdianegocpcela(response.getNpccwx6sresponse().getTdiaprzooper());
            irregularVO.setDvctopcelatrade(response.getNpccwx6sresponse().getDvctopcelatrade());
            irregularVO.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
            irregularVO.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
            
            irregularVO.setMensagem(null);
            if(response.getCodmens().equals("NPCC0901") || response.getCodmens().equals("NPCC0902") || response.getCodmens().equals("NPCC0903")) {
                irregularVO.setMensagem(response.getTexmens());
            }
            
            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setTdianegocpcela(irregularVO.getTdianegocpcela());
            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setDvctopcelatrade(irregularVO.getDvctopcelatrade());
            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setDateVctopcelatrade(irregularVO.getDateVctopcelatrade());
            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setVencimentoFluxoPgto(irregularVO.getVencimentoFluxoPgto());
            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setVenctoFluxDate(irregularVO.getVenctoFluxDate());
            
            if(response.getCodmens().equals("NPCC0901") || response.getCodmens().equals("NPCC0902") || response.getCodmens().equals("NPCC0903")) {
            	flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setMensagem(response.getTexmens());
            }
		} else {
            entrada.setDprevtdsembcmbio(SiteUtil.stringDataWebToMainframe(irregularVO.getVencimentoFluxoPgto()));
            entrada.setDvctopcelatrade(SiteUtil.dataWebToMainframe(irregularVO.getDateVctopcelatrade()));
            entrada.setTdiaprzooper(irregularVO.getTdianegocpcela());
            
            // Fluxo: NPCCIAPL - Books: NPCCWX6E / NPCCWX6S
            listaSemPaginacao(request, response, "DTVENCOUPRAZOCALC");
            
            if(validarDataDiaUtil(tradeFinNegocVO, SiteUtil.dataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()))) {
				irregularVO.setTdianegocpcela(response.getNpccwx6sresponse().getTdiaprzooper());
	            irregularVO.setDvctopcelatrade(response.getNpccwx6sresponse().getDvctopcelatrade());
	            irregularVO.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
	            irregularVO.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
	            irregularVO.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(response.getNpccwx6sresponse().getDvctopcelatrade()));
	            
	            irregularVO.setMensagem(null);
	            if(response.getCodmens().equals("NPCC0901") || response.getCodmens().equals("NPCC0902") || response.getCodmens().equals("NPCC0903")) {
	                irregularVO.setMensagem(response.getTexmens());
	            }
	            
	            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setTdianegocpcela(irregularVO.getTdianegocpcela());
	            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setDvctopcelatrade(irregularVO.getDvctopcelatrade());
	            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setDateVctopcelatrade(irregularVO.getDateVctopcelatrade());
	            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setVencimentoFluxoPgto(irregularVO.getVencimentoFluxoPgto());
	            flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setVenctoFluxDate(irregularVO.getVenctoFluxDate());
	            
	            if(response.getCodmens().equals("NPCC0901") || response.getCodmens().equals("NPCC0902") || response.getCodmens().equals("NPCC0903")) {
	            	flxPgtVO.getListaParcelasFluxoPgto().get(linhaAlterada).setMensagem(response.getTexmens());
	            }
			} else {
				System.out.println("A data informada não é dia útil.");
			}
		}
    }
	
	public Boolean validarDataDiaUtil(TrdFinNegocInclVO irregularVO, Date dataCtc){
    	
        if(SiteUtil.comparaDatas(SiteUtil.toDay(), dataCtc) > 0 || !validarDiaUtil(dataCtc, irregularVO.getCpais(), 
    			"1", irregularVO.getCpaisInec(), tradeFinanceNegociacaoInclBean.getTrdFinNegMercadoriaVO().getCpaisbnefc(), irregularVO.getCeconmmoedadsemb())){
        	return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
	
    /**
     * Nome: validarDiaUtil
     * 
     * Propósito: Verifica se a data é dia útil no pais informado.
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @SuppressWarnings("finally")
	public Boolean validarDiaUtil(Date data, Integer pais, String tpodata, Integer cpaisInec, Integer cpaisbenef, Integer cindcdeconmmoeda) {
    	Validaprevisaodesembrequest request = new Validaprevisaodesembrequest();
    	Validaprevisaodesembresponse response = new Validaprevisaodesembresponse();
    	Npccwvxerequest entrada = new Npccwvxerequest();
    	Npccwvxsresponse saida = new Npccwvxsresponse();
    	try {
    		request.setNpccwvxerequest(entrada);
    		response.setNpccwvxsresponse(saida);

    		entrada.setCpais(pais);
    		entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(data));
    		entrada.setCpaisdsemb(cpaisInec);
    		entrada.setTpodata(tpodata);
    		entrada.setCpaisbenef(cpaisbenef);
    		entrada.setCindcdeconmmoeda(cindcdeconmmoeda);

    		// Fluxo: NPCCIARP - Books: NPCCWVXE/S
    		listaSemPaginacao(request, response, "VALIDAPREVISAODESEMB");

    		// * NPCCWVXS-DATA-UTIL = 1 - DATA UTIL                    *
    		// *                      2 - DATA NAO UTIL                *
    		return saida.getDatautil() == Numeros.UM;
    	} catch (NpccTradeWebException e) {
    		System.out.println("Erro");
		} finally {
    		return saida.getDatautil() == Numeros.UM;
    	}
    }
}
