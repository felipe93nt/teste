package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.agendaSwap.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixarAgendaSwap.Baixaragendaswaprequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixarAgendaSwap.Baixaragendaswapresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixarAgendaSwap.Npccwzrerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixarAgendaSwap.Npccwzrsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap.Consultaagendaswaprequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap.Consultaagendaswapresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap.Npccwzqerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap.Npccwzqsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap.Npccwzqsresponse_gride;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.agendaSwap.IAgendaSwapService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.agendaSwap.bean.BaixaSwapFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPtax;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumStatusSwap;

@Named("agendaSwapService")
@SessionScoped
public class AgendaSwapServiceImpl extends BaseService implements IAgendaSwapService {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -2352003299545843468L;

    /**
     * Nome: getListaAgendaSwap
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    @Override
    public List<TradeFinanceListaVO> getListaAgendaSwap(TradeFinanceFiltroVO filtro) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] AgendaSwapServiceImpl.getListaAgendaSwap | CONSULTAAGENDASWAP ------- ");

            Consultaagendaswaprequest request = new Consultaagendaswaprequest();
            Consultaagendaswapresponse response =  new Consultaagendaswapresponse();
            Npccwzqerequest entrada = new Npccwzqerequest();
            Npccwzqsresponse saida = new Npccwzqsresponse();
            request.setNpccwzqerequest(entrada);
            response.setNpccwzqsresponse(saida);
            
            entrada.setDvctopcelatradei(SiteUtil.dataWebToMainframe(filtro.getPeriodoSwap().getInicio()));
            entrada.setDvctopcelatradef(SiteUtil.dataWebToMainframe(filtro.getPeriodoSwap().getFim()));
            entrada.setDfchtobletoi(SiteUtil.dataWebToMainframe(filtro.getPeriodoFech().getInicio()));
            entrada.setDfchtobletof(SiteUtil.dataWebToMainframe(filtro.getPeriodoFech().getFim()));
            entrada.setCunicclicmbio(filtro.getCunicclicmbio());
            entrada.setCindcdliqdcswap(filtro.getCindcdliqdcswap());
            entrada.setCtposgmtocli(filtro.getCtposgmtocli());
            entrada.setCprodtservc(filtro.getCprodtservc());
            entrada.setNsequndorgnz(SiteUtil.getInt(filtro.getNsequndorgnz()));
            entrada.setCbanqrcmbiofndng(filtro.getCbanqrcmbiofndng());

            // FLUXO: NPCCIARI BOOK: NPCCWZQE / NPCCWZQS 
            listaComPaginacao(request, response, "CONSULTAAGENDASWAP", "NPCCIARI");
            
            setMsgRetorno(response.getTexmens());

            TradeFinanceListaVO objTo;
            List<TradeFinanceListaVO> lista = new ArrayList<TradeFinanceListaVO>();
            
            for (int i = 0; i < response.getNpccwzqsresponse().getQtdeocorr(); i++) {
                
                Npccwzqsresponse_gride objFrom = response.getNpccwzqsresponse().getGride().get(i);
                objTo = new TradeFinanceListaVO();
                
                objTo.setCunicclicmbio(objFrom.getGride_cunicclicmbio());
                objTo.setNcunicclicmbio(objFrom.getGride_ncunicclicmbio());
                objTo.setNsequndorgnz(objFrom.getGride_nsequndorgnz());
                objTo.setNomeundorgnz(objFrom.getGride_nomeundorgnz());
                objTo.setDvctopcelatrade(SiteUtil.trocarPontoPorBarra(objFrom.getGride_dvctopcelatrade()));
                objTo.setCtpocotactx(objFrom.getGride_ctpocotactx());
                objTo.setDescricaoPtax(EnumPtax.fromCode(objFrom.getGride_ctpocotactx()).getDescricao());
                objTo.setVpcelaprnctrade(objFrom.getGride_vpcelaprnctrade());
                objTo.setVpcelajurotrade(objFrom.getGride_vpcelajurotrade());
                objTo.setCprodtservc(objFrom.getGride_cprodtservc());
                objTo.setDprodtservc(objFrom.getGride_dprodtservc());
                objTo.setCmodldprodtcmbio(objFrom.getGride_cmodldprodtcmbio());
                objTo.setCmodldprodtdesc(objFrom.getGride_cmodldprodtdesc());
                objTo.setTdiaopercmbio(objFrom.getGride_tdiaopercmbio());
                objTo.setNomerof(objFrom.getGride_nomerof());
                objTo.setNbletocmbioano(objFrom.getGride_nbletocmbioano());
                objTo.setCaditvbletocmbio(objFrom.getGride_caditvbletocmbio());
                if (objFrom.getGride_caditvbletocmbio() > 0) {                    
                    objTo.setCaditvbletocmbiostr("Sim");                    
                } else {                    
                    objTo.setCaditvbletocmbiostr("Não");
                }
                
                objTo.setCindcdliqdcswap(objFrom.getGride_cindcdliqdcswap());
                objTo.setDescricaoStatusSwap(EnumStatusSwap.fromCode(objFrom.getGride_cindcdliqdcswap()).getDescricao());
                objTo.setNbletonegoccmbio(objFrom.getGride_nbletonegoccmbio());
                objTo.setNdsembcmbiop(objFrom.getGride_ndsembcmbiop());
                objTo.setNpceladsembp(objFrom.getGride_npceladsembp());
                objTo.setNdsembcmbioj(objFrom.getGride_ndsembcmbioj());
                objTo.setNpceladsembj(objFrom.getGride_npceladsembj());
                
                lista.add(objTo);
            }

            return lista;
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] AgendaSwapServiceImpl.getListaAgendaSwap | CONSULTAAGENDASWAP ------- ");
        }
                    
    }

    /**
     * Nome: baixar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    @Override
    public String baixar(BaixaSwapFiltroVO filtro) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] AgendaSwapServiceImpl.baixar | BAIXARAGENDASWAP ------- ");

            Baixaragendaswaprequest request = new Baixaragendaswaprequest();
            Baixaragendaswapresponse response =  new Baixaragendaswapresponse();
            Npccwzrerequest entrada = new Npccwzrerequest();
            Npccwzrsresponse saida = new Npccwzrsresponse();
            request.setNpccwzrerequest(entrada);
            response.setNpccwzrsresponse(saida);
            
            entrada.setNbletonegoccmbio(filtro.getNbletonegoccmbio());
            entrada.setNdsembcmbiotrade(filtro.getNdsembcmbiotrade());
            entrada.setNpceladsembtrade(filtro.getNpceladsembtrade());
            entrada.setTpparcela(filtro.getTpparcela());
            
            // FLUXO: NPCCIARJ BOOK: NPCCWZRE / NPCCWZRS 
            listaSemPaginacao(request, response, "BAIXARAGENDASWAP");
            
            return response.getTexmens();
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] AgendaSwapServiceImpl.baixar | BAIXARAGENDASWAP ------- ");
        }       
    }
           
}
