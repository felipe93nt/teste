package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif.Listarhistoricotarifrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif.Listarhistoricotarifresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif.Npccwzuerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif.Npccwzusresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif.Npccwzusresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf.NpccwvveRequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf.NpccwvvsResponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf.NpccwvvsResponseGride;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf.TradeFinanceLogConfRequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf.TradeFinanceLogConfResponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq.Npccwzterequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq.Npccwztsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq.Npccwztsresponse_gride;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq.Tradefinancelogpesqrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq.Tradefinancelogpesqresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.ITradeFinanceLogService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean.ListaHistoricoTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * Nome: TradeFinanceLogImpl.java
 * 
 * PropÃ³sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilaÃ§Ã£o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de ManutenÃ§Ã£o: 11/04/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrÃ£o
 *      hexavision.
 */
@Named("tradeFinanceLogService")
@RequestScoped
public class TradeFinanceLogImpl extends BaseService implements ITradeFinanceLogService, Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -3620121132382478536L;

    /**
     * Construtor.
     */

    public TradeFinanceLogImpl() {
        super();
    }

    /**
     * Nome: pesquisar dados do LOG
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public List<TradeFinanceListaVO> listar(TradeFinanceFiltroVO filtro) {

        List<TradeFinanceListaVO> listaVO = new ArrayList<TradeFinanceListaVO>();

        Tradefinancelogpesqrequest request = new Tradefinancelogpesqrequest();
        Tradefinancelogpesqresponse response = new Tradefinancelogpesqresponse();
        Npccwzterequest entrada = new Npccwzterequest();
        Npccwztsresponse saida = new Npccwztsresponse();
        request.setNpccwzterequest(entrada);
        response.setNpccwztsresponse(saida);

        if (filtro.getPeriodoCotacao() == null || filtro.getPeriodoCotacao().getInicio() == null
                || filtro.getPeriodoCotacao().getFim() == null) {
            entrada.setPeriodocotacaoi("");
            entrada.setPeriodocotacaof("");
        } else {
            entrada.setPeriodocotacaoi(SiteUtil.dataWebToMainframe(filtro.getPeriodoCotacao().getInicio()));
            entrada.setPeriodocotacaof(SiteUtil.dataWebToMainframe(filtro.getPeriodoCotacao().getFim()));
        }
        
        entrada.setCunicclicmbio(filtro.getCunicclicmbio());
        entrada.setDanobase(filtro.getDanobase());
        entrada.setNbletocmbioano(filtro.getNbletocmbioano());
        entrada.setNsequndorgnz(SiteUtil.getInt(filtro.getNsequndorgnz()));
        entrada.setCusuarinclt(filtro.getCusuarincl());

        // executa chamada CWS - Fluxo NPCCIARQ - Books: NPCCWZTE / NPCCWZTS
        listaComPaginacao(request, response, "TRADEFINANCELOGPESQ", "NPCCIARQ");

        // Recupera menssagem de retorno
        setMsgRetorno(response.getTexmens());

        for (int i = 0; i < response.getNpccwztsresponse().getQtdeocorr(); i++) {

            Npccwztsresponse_gride objFrom = response.getNpccwztsresponse().getGride().get(i);

            TradeFinanceListaVO objTo = new TradeFinanceListaVO();

            // Copia os valores das propriedades com o mesmo nome

            objTo.setDtcotacao(SiteUtil.trocarPontoPorBarra(objFrom.getGride_sdtcotacao()));
            objTo.setHorario(objFrom.getGride_shorario().replace(".", ":"));
            objTo.setNbletocmbioano(objFrom.getGride_snbletocmbioano());
            objTo.setCsitbletocmbio(objFrom.getGride_scsitbletocmbio());
            objTo.setDsitbletocmbio(objFrom.getGride_sdsitbletocmbio());
            objTo.setNsequndorgnz(objFrom.getGride_snsequndorgnz());
            objTo.setNomeundorgnz(objFrom.getGride_snomeundorgnz());
            objTo.setCagbcria(objFrom.getGride_scagbcria());
            objTo.setCctabcriacmbio(objFrom.getGride_scctabcriacmbio());
            objTo.setDigtcctabcria(objFrom.getGride_sdigtcctabcria());
            objTo.setCprodtservc(objFrom.getGride_scprodtservc());
            objTo.setDprodtservc(objFrom.getGride_sdprodtservc());
            objTo.setCunicclicmbio(objFrom.getGride_scunicclicmbio());
            objTo.setNcunicclicmbio(objFrom.getGride_sncunicclicmbio());
            objTo.setTppessoa(objFrom.getGride_stppessoa());
            objTo.setCpfcnpj(objFrom.getGride_scpfcnpj());
            objTo.setCflial(objFrom.getGride_scflial());
            objTo.setCctrl(objFrom.getGride_scctrl());
            objTo.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(objFrom.getGride_scpfcnpj(),
                            objFrom.getGride_scflial(), objFrom.getGride_scctrl()));
            objTo.setCrting(objFrom.getGride_scrting());
            objTo.setCtposgmtocli(objFrom.getGride_sctposgmtocli());
            objTo.setDtposgmtocli(objFrom.getGride_sdtposgmtocli());
            objTo.setCindcdeconmmoeda(objFrom.getGride_scindcdeconmmoeda());
            objTo.setSimbleconmmoeda(objFrom.getGride_ssimbleconmmoeda());
            objTo.setVnegocmoedaestrg(objFrom.getGride_svnegocmoedaestrg());
            objTo.setVtxspreadnegoc(objFrom.getGride_svtxspreadnegoc());
            objTo.setTdiaopercmbio(objFrom.getGride_stdiaopercmbio());
            objTo.setCusuarinclt(objFrom.getGride_scusuarinclt());
            objTo.setNusuarinclt(objFrom.getGride_snusuarinclt());
            objTo.setNbletonegoccmbio(objFrom.getGride_snbletonegoccmbio());
            objTo.setCmodldprodtcmbio(objFrom.getGride_scmodldprodtcmbio());
            objTo.setCmodldprodtdesc(objFrom.getGride_scmodldprodtdesc());
            objTo.setCaditvbletocmbio(objFrom.getGride_scaditvbletocmbio());

            listaVO.add(objTo);
        }
        return listaVO;

    }

    /**
     * Nome: confirmar Log
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */

    public List<TradeFinanceListaVO> confirmar(Long nBleto, Long nbletoAno) {

        List<TradeFinanceListaVO> listaVO = new ArrayList<TradeFinanceListaVO>();

        TradeFinanceLogConfRequest request = new TradeFinanceLogConfRequest();
        TradeFinanceLogConfResponse response = new TradeFinanceLogConfResponse();
        NpccwvveRequest entrada = new NpccwvveRequest();
        NpccwvvsResponse saida = new NpccwvvsResponse();
        request.setNpccwvveRequest(entrada);
        response.setNpccwvvsResponse(saida);

        // Processa lista para confirmação

        entrada.setNbletocmbioano(nBleto);
        entrada.setNbletonegoccmbio(nbletoAno);

        // executa chamada CWS - Fluxo NPCCIARO - Books: NPCCWVVE / NPCCWVVS
        listaComPaginacao(request, response, "TRADEFINANCELOGCONF", "NPCCIARO");

        // Recupera menssagem de retorno
        setMsgRetorno(response.getTexmens());

        for (int i = 0; i < response.getNpccwvvsResponse().getQtdeocorr(); i++) {

            NpccwvvsResponseGride objFrom = response.getNpccwvvsResponse().getGride().get(i);

            TradeFinanceListaVO objTo = new TradeFinanceListaVO();

            objTo.setCsitbletocmbio(objFrom.getScsitbletocmbio());
            objTo.setDsitbletocmbio(objFrom.getSdsitbletocmbio());
            objTo.setDtcotacao(SiteUtil.trocarPontoPorBarra(objFrom.getSdtcotacao()));
            objTo.setHorario(objFrom.getShorario().replace(".", ":"));
            objTo.setCunicclicmbio(objFrom.getScunicclicmbio());
            objTo.setNcunicclicmbio(objFrom.getSncunicclicmbio());
            objTo.setCprodtservc(objFrom.getScprodtservc());
            objTo.setDprodtservc(objFrom.getSdprodtservc());
            objTo.setVnegocmoedaestrg(SiteUtil.doubleToBrowserMoeda(objFrom.getSvnegocmoedaestrg()));
            objTo.setCusuarinclt(objFrom.getScusuarinclt());
            objTo.setNusuarinclt(objFrom.getSnusuarinclt());
            objTo.setCindcdtpomanut(objFrom.getScindcdtpomanut());
            objTo.setFuncao(objFrom.getSfuncao());
            objTo.setNbletonegoccmbio(objFrom.getSnbletonegoccmbio());
            objTo.setCmodldprodtcmbio(objFrom.getScmodldprodtcmbio());
            objTo.setCmodldprodtdesc(objFrom.getScmodldprodtdesc());
            objTo.setHinclreghist(objFrom.getShinclreghist());
            objTo.setHinclanthist(objFrom.getShinclanthist());

            listaVO.add(objTo);

        }

        return listaVO;
    }

    public List<ListaHistoricoTarifaVO> obterHistoricoTarifaLog(TradeFinanceListaVO listaVO) {

        List<ListaHistoricoTarifaVO> lista = new ArrayList<ListaHistoricoTarifaVO>();

        Listarhistoricotarifrequest request = new Listarhistoricotarifrequest();
        Listarhistoricotarifresponse response = new Listarhistoricotarifresponse();

        Npccwzuerequest entrada = new Npccwzuerequest();
        Npccwzusresponse saida = new Npccwzusresponse();

        request.setNpccwzuerequest(entrada);
        response.setNpccwzusresponse(saida);

        entrada.setNbletonegoccmbio(listaVO.getNbletonegoccmbio());

        entrada.setHinclreghist(SiteUtil.stringDataWebToMainframe(listaVO.getHinclreghist()));

        // FLUXO: NPCCIARR BOOK: NPCCWZUE/S
        listaSemPaginacao(request, response, "LISTARHISTORICOTARIF");

        setMsgRetorno(response.getTexmens());

        // LISTA HISTORICO TARIFA LOG
        for (int i = 0; i < saida.getQtdeocorr(); i++) {

            Npccwzusresponse_lista objFrom = saida.getLista().get(i);
            ListaHistoricoTarifaVO hist = new ListaHistoricoTarifaVO();

            hist.setCcondceconc(objFrom.getLista_ccondceconc());
            hist.setCindcddesptarf(objFrom.getLista_cindcddesptarf());
            hist.setCindcdeconmmoeda(objFrom.getLista_cindcdeconmmoeda());
            hist.setCtpodespcmbio(objFrom.getLista_ctpodespcmbio());
            hist.setIsglindcdfonte(objFrom.getLista_isglindcdfonte());
            hist.setItpodespcmbio(objFrom.getLista_itpodespcmbio());
            hist.setNdespbletocmbio(objFrom.getLista_ndespbletocmbio());
            hist.setNtarifbletocmbio(objFrom.getLista_ntarifbletocmbio());
            hist.setVdespbletocmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_vdespbletocmbio()));

            lista.add(hist);

        }
        return lista;
    }
    
    /**
     * Nome: pesquisar dados do LOG
     * 
     * Proposito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão
     *      hexavision.
     */
    public List<TradeFinanceListaVO> listarCotacoesExportacao(TradeFinanceFiltroVO filtro) {

        List<TradeFinanceListaVO> listaVO = new ArrayList<TradeFinanceListaVO>();

        Tradefinancelogpesqrequest request = new Tradefinancelogpesqrequest();
        Tradefinancelogpesqresponse response = new Tradefinancelogpesqresponse();
        Npccwzterequest entrada = new Npccwzterequest();
        Npccwztsresponse saida = new Npccwztsresponse();
        request.setNpccwzterequest(entrada);
        response.setNpccwztsresponse(saida);

        if (filtro.getPeriodoCotacao() == null || filtro.getPeriodoCotacao().getInicio() == null
                || filtro.getPeriodoCotacao().getFim() == null) {
            entrada.setPeriodocotacaoi("");
            entrada.setPeriodocotacaof("");
        } else {
            entrada.setPeriodocotacaoi(SiteUtil.dataWebToMainframe(filtro.getPeriodoCotacao().getInicio()));
            entrada.setPeriodocotacaof(SiteUtil.dataWebToMainframe(filtro.getPeriodoCotacao().getFim()));
        }
        
        entrada.setCunicclicmbio(filtro.getCunicclicmbio());
        entrada.setDanobase(filtro.getDanobase());
        entrada.setNbletocmbioano(filtro.getNbletocmbioano());
        entrada.setNsequndorgnz(SiteUtil.getInt(filtro.getNsequndorgnz()));
        entrada.setCusuarinclt(filtro.getCusuarincl());
        
        request.setNpccwzterequest(entrada);
        response.setNpccwztsresponse(saida);
        
        // executa chamada CWS - Fluxo NPCCIARQ - Books: NPCCWZTE / NPCCWZTS
        List<Tradefinancelogpesqresponse> pages = autoPaginate(request, response, "TRADEFINANCELOGPESQ");

        // Recupera menssagem de retorno
        setMsgRetorno(response.getTexmens());
        
        // percorre todas as paginas obtidas do MF
        for(Tradefinancelogpesqresponse page : pages) {
            Npccwztsresponse currentOutput = page.getNpccwztsresponse();
            
            // Percorre todas as ocorrencias de cada pagina
            for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {

                Npccwztsresponse_gride objFrom = currentOutput.getGride().get(i);

                TradeFinanceListaVO objTo = new TradeFinanceListaVO();

                // Copia os valores das propriedades com o mesmo nome

                objTo.setDtcotacao(SiteUtil.trocarPontoPorBarra(objFrom.getGride_sdtcotacao()));
                objTo.setHorario(objFrom.getGride_shorario().replace(".", ":"));
                objTo.setNbletocmbioano(objFrom.getGride_snbletocmbioano());
                objTo.setCsitbletocmbio(objFrom.getGride_scsitbletocmbio());
                objTo.setDsitbletocmbio(objFrom.getGride_sdsitbletocmbio());
                objTo.setNsequndorgnz(objFrom.getGride_snsequndorgnz());
                objTo.setNomeundorgnz(objFrom.getGride_snomeundorgnz());
                objTo.setCagbcria(objFrom.getGride_scagbcria());
                objTo.setCctabcriacmbio(objFrom.getGride_scctabcriacmbio());
                objTo.setDigtcctabcria(objFrom.getGride_sdigtcctabcria());
                objTo.setCprodtservc(objFrom.getGride_scprodtservc());
                objTo.setDprodtservc(objFrom.getGride_sdprodtservc());
                objTo.setCunicclicmbio(objFrom.getGride_scunicclicmbio());
                objTo.setNcunicclicmbio(objFrom.getGride_sncunicclicmbio());
                objTo.setTppessoa(objFrom.getGride_stppessoa());
                objTo.setCpfcnpj(objFrom.getGride_scpfcnpj());
                objTo.setCflial(objFrom.getGride_scflial());
                objTo.setCctrl(objFrom.getGride_scctrl());
                objTo.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(objFrom.getGride_scpfcnpj(),
                                objFrom.getGride_scflial(), objFrom.getGride_scctrl()));
                objTo.setCrting(objFrom.getGride_scrting());
                objTo.setCtposgmtocli(objFrom.getGride_sctposgmtocli());
                objTo.setDtposgmtocli(objFrom.getGride_sdtposgmtocli());
                objTo.setCindcdeconmmoeda(objFrom.getGride_scindcdeconmmoeda());
                objTo.setSimbleconmmoeda(objFrom.getGride_ssimbleconmmoeda());
                objTo.setVnegocmoedaestrg(objFrom.getGride_svnegocmoedaestrg());
                objTo.setVtxspreadnegoc(objFrom.getGride_svtxspreadnegoc());
                objTo.setTdiaopercmbio(objFrom.getGride_stdiaopercmbio());
                objTo.setCusuarinclt(objFrom.getGride_scusuarinclt());
                objTo.setNusuarinclt(objFrom.getGride_snusuarinclt());
                objTo.setNbletonegoccmbio(objFrom.getGride_snbletonegoccmbio());
                objTo.setCmodldprodtcmbio(objFrom.getGride_scmodldprodtcmbio());
                objTo.setCmodldprodtdesc(objFrom.getGride_scmodldprodtdesc());
                objTo.setCaditvbletocmbio(objFrom.getGride_scaditvbletocmbio());

                listaVO.add(objTo);
            }
        }
        
        return listaVO;
    }
    
    /**
     * Nome: confirmar Log
     * 
     * Proposito: exportar lista de registro para excel
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão
     *      hexavision.
     */

    public List<TradeFinanceListaVO> confirmarLogDetalhe(Long nBleto, Long nbletoAno) {

        List<TradeFinanceListaVO> listaVO = new ArrayList<TradeFinanceListaVO>();

        TradeFinanceLogConfRequest request = new TradeFinanceLogConfRequest();
        TradeFinanceLogConfResponse response = new TradeFinanceLogConfResponse();
        NpccwvveRequest entrada = new NpccwvveRequest();
        NpccwvvsResponse saida = new NpccwvvsResponse();
        request.setNpccwvveRequest(entrada);
        response.setNpccwvvsResponse(saida);

        // Processa lista para confirmação

        entrada.setNbletocmbioano(nBleto);
        entrada.setNbletonegoccmbio(nbletoAno);

        //listaComPaginacao(request, response, "TRADEFINANCELOGCONF", "NPCCIARO");
        
        // executa chamada CWS - Fluxo NPCCIARO - Books: NPCCWVVE / NPCCWVVS
        List<TradeFinanceLogConfResponse> pags = autoPaginate(request, response, "TRADEFINANCELOGCONF");

        // Recupera menssagem de retorno
        setMsgRetorno(response.getTexmens());
        
        for (TradeFinanceLogConfResponse page : pags) {
            NpccwvvsResponse currentOutput = page.getNpccwvvsResponse();
            
            for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {

                NpccwvvsResponseGride objFrom = currentOutput.getGride().get(i);

                TradeFinanceListaVO objTo = new TradeFinanceListaVO();

                objTo.setCsitbletocmbio(objFrom.getScsitbletocmbio());
                objTo.setDsitbletocmbio(objFrom.getSdsitbletocmbio());
                objTo.setDtcotacao(SiteUtil.trocarPontoPorBarra(objFrom.getSdtcotacao()));
                objTo.setHorario(objFrom.getShorario().replace(".", ":"));
                objTo.setCunicclicmbio(objFrom.getScunicclicmbio());
                objTo.setNcunicclicmbio(objFrom.getSncunicclicmbio());
                objTo.setCprodtservc(objFrom.getScprodtservc());
                objTo.setDprodtservc(objFrom.getSdprodtservc());
                
                objTo.setVnegocmoedaestrg(SiteUtil.doubleToBrowserMoeda(objFrom.getSvnegocmoedaestrg()));
                objTo.setCusuarinclt(objFrom.getScusuarinclt());
                objTo.setNusuarinclt(objFrom.getSnusuarinclt());
                objTo.setCindcdtpomanut(objFrom.getScindcdtpomanut());
                objTo.setFuncao(objFrom.getSfuncao());
                objTo.setNbletonegoccmbio(objFrom.getSnbletonegoccmbio());
                objTo.setCmodldprodtcmbio(objFrom.getScmodldprodtcmbio());
                objTo.setCmodldprodtdesc(objFrom.getScmodldprodtdesc());
                objTo.setHinclreghist(objFrom.getShinclreghist());
                objTo.setHinclanthist(objFrom.getShinclanthist());

                listaVO.add(objTo);
            }
        }

        return listaVO;
    }
}
