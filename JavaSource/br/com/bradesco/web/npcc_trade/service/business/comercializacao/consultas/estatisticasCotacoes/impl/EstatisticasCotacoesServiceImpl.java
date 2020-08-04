package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.data.connector.baseconnector.exception.CTGServiceException;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList.Conestcotfecperdlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList.Conestcotfecperdlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList.Npccwzgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList.Npccwzgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList.Npccwzgsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList.Conestatcotacoeslistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList.Conestatcotacoeslistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList.Npccwzderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList.Npccwzdsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList.Npccwzdsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.web.npcc_trade.service.business.NpccTradeServiceBusinessException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.IEstatisticasCotacoesService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean.CotacoesVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean.EstatisticaCotacoesVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean.EstatisticasCotacoesFechadaPerdidaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;

@Named("estatisticasCotacoesServiceImpl")
@SessionScoped
public class EstatisticasCotacoesServiceImpl extends BaseService implements IEstatisticasCotacoesService{

    /**
    *
    */
   private static final long serialVersionUID = 1L;
   
   /**
    * Constante resouce cws
    */
   private final String RESOUCE = "cws";

   /**
    * Construtor.
    */
   public EstatisticasCotacoesServiceImpl() {
       super();
   }
	
   public EstatisticaCotacoesVO getEstatisticasCotacoes(CalendarioPeriodo filtroData, Integer tipoPesquisa){
	   try{
           BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] EstatisticasCotacoesServiceImpl.getEstatisticasCotacoes | CONESTATCOTACOESLIST ------- ");
           
           List<CotacoesVO> lista = new ArrayList<CotacoesVO>();
           EstatisticaCotacoesVO estatisticaCotacoesVO = new EstatisticaCotacoesVO();
           
           Conestatcotacoeslistrequest request = new Conestatcotacoeslistrequest();
           Conestatcotacoeslistresponse response = new Conestatcotacoeslistresponse();
           
           Npccwzderequest entrada = new Npccwzderequest();
           Npccwzdsresponse saida = new Npccwzdsresponse();
           
           request.setNpccwzderequest(entrada);
           response.setNpccwzdsresponse(saida);
           
           if (filtroData == null || filtroData.getInicio() == null) {
               entrada.setDtperini("");
           } else {
               String dtEmissaoIni = SiteUtil.dataWebToMainframe(filtroData.getInicio());
               entrada.setDtperini(dtEmissaoIni.equals("0") ? "" : dtEmissaoIni);
           }
           if (filtroData == null || filtroData.getFim() == null) {
               entrada.setDtperfim("");
           } else {
               String dtEmissaoFim = SiteUtil.dataWebToMainframe(filtroData.getFim());
               entrada.setDtperfim(dtEmissaoFim.equals("0") ? "" : dtEmissaoFim);
           }
           //produto 1 operador 2
           entrada.setTipopesq(tipoPesquisa);

        // Fluxo - NPCCIAQ6 / NPCCWZDE - NPCCWZDS
           listaComPaginacao(request, response, "CONESTATCOTACOESLIST","NPCCIAQ6");
           
           estatisticaCotacoesVO.setTotqtdstfec(saida.getTotqtdstfec());
           estatisticaCotacoesVO.setTotvalstfec(saida.getTotvalstfec());
           estatisticaCotacoesVO.setTotqtdstper(saida.getTotqtdstper());
           estatisticaCotacoesVO.setTotvalstper(saida.getTotvalstper());
           estatisticaCotacoesVO.setTotqtdstnfi(saida.getTotqtdstnfi());
           estatisticaCotacoesVO.setTotvalstnfi(saida.getTotvalstnfi());
           estatisticaCotacoesVO.setTotqtdstnin(saida.getTotqtdstnin());
           estatisticaCotacoesVO.setTotvalstnin(saida.getTotvalstnin());
           estatisticaCotacoesVO.setTotqtdstbai(saida.getTotqtdstbai());
           estatisticaCotacoesVO.setTotvalstbai(saida.getTotvalstbai());
           estatisticaCotacoesVO.setTotqtdtotal(saida.getTotqtdtotal());
           estatisticaCotacoesVO.setTotvaltotal(saida.getTotvaltotal());
           estatisticaCotacoesVO.setTotqtdperfv(saida.getTotqtdperfv());
           estatisticaCotacoesVO.setTotvalperfv(saida.getTotvalperfv());
           
           // Lista
           for (int i = 0; i < saida.getQtdeocorr(); i++) {
               
        	   Npccwzdsresponse_lista objFrom = saida.getLista().get(i);
               CotacoesVO cotacoesVO = new CotacoesVO();
                              
               cotacoesVO.setIdtppesquisa(objFrom.getLista_idtppesquisa());
               cotacoesVO.setCtfechadaqt(objFrom.getLista_ctfechadaqt());
               cotacoesVO.setCtfechadavl(objFrom.getLista_ctfechadavl());
               cotacoesVO.setCtperdidaqt(objFrom.getLista_ctperdidaqt());
               cotacoesVO.setCtperdidavl(objFrom.getLista_ctperdidavl());
               cotacoesVO.setCtnegofirqt(objFrom.getLista_ctnegofirqt());
               cotacoesVO.setCtnegofirvl(objFrom.getLista_ctnegofirvl());
               cotacoesVO.setCtnegoindqt(objFrom.getLista_ctnegoindqt());
               cotacoesVO.setCtnegoindvl(objFrom.getLista_ctnegoindvl());
               cotacoesVO.setCtbaixadaqt(objFrom.getLista_ctbaixadaqt());
               cotacoesVO.setCtbaixadavl(objFrom.getLista_ctbaixadavl());
               cotacoesVO.setTotqtdcotac(objFrom.getLista_totqtdcotac());
               cotacoesVO.setTotvalprodt(objFrom.getLista_totvalprodt());
               cotacoesVO.setPercentualct(objFrom.getLista_percentualct());
               cotacoesVO.setPercentualvl(objFrom.getLista_percentualvl());

               lista.add(cotacoesVO);
               
           }
           
           estatisticaCotacoesVO.setCotacoes(lista);
           
           return estatisticaCotacoesVO;
           
       }finally{
           BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] EstatisticasCotacoesServiceImpl.getEstatisticasCotacoes | CONESTATCOTACOESLIST ------- ");
       }
   }
   
   
   public List<EstatisticasCotacoesFechadaPerdidaVO> getEstatisticasCotacoesFechadasPerdidas(Integer anoBase){
	   try{
		   BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] EstatisticasCotacoesServiceImpl.getEstatisticasCotacoesFechadasPerdidas | CONESTCOTFECPERDLIST ------- ");
		   
		   List<EstatisticasCotacoesFechadaPerdidaVO> lista = new ArrayList<EstatisticasCotacoesFechadaPerdidaVO>();
		   
		   Conestcotfecperdlistrequest request = new Conestcotfecperdlistrequest();
		   Conestcotfecperdlistresponse response = new Conestcotfecperdlistresponse();
		   
		   Npccwzgerequest entrada = new Npccwzgerequest();
		   Npccwzgsresponse saida = new Npccwzgsresponse();
		   
           request.setNpccwzgerequest(entrada);
           response.setNpccwzgsresponse(saida);
		   
		   entrada.setDanobase(anoBase);
		   
		   // Fluxo - NPCCIAQ9 / NPCCWZGE - NPCCWZGS
		   listaComPaginacao(request, response, "CONESTCOTFECPERDLIST","NPCCIAQ9");
		   
		   // Lista
		   for (int i = 0; i < saida.getQtdeocorr(); i++) {
			   
			   Npccwzgsresponse_lista objFrom = saida.getLista().get(i);
			   EstatisticasCotacoesFechadaPerdidaVO cotacoesVO = new EstatisticasCotacoesFechadaPerdidaVO();
			   
			   cotacoesVO.setCotfechada(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_cotfechada()));
			   cotacoesVO.setCotperdida(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_cotperdida()));
			   cotacoesVO.setCottotal(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_cottotal()));
			   cotacoesVO.setFechadovlt(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_fechadovlt()));
			   cotacoesVO.setPerdidovlt(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_perdidovlt()));
			   cotacoesVO.setMes(objFrom.getLista_mes());
			   
			   lista.add(cotacoesVO);
			   
		   }
		   
		   return lista;
		   
	   }finally{
		   BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] EstatisticasCotacoesServiceImpl.getEstatisticasCotacoesFechadasPerdidas | CONESTCOTFECPERDLIST ------- ");
	   }
   }
   
   /**
    * Nome: listaComPaginacao
    * 
    * Propósito: Executa transação com paginação
    *
    * @param request
    *            the request
    * @param response
    *            the response
    * @param transactionName
    *            the transaction name
    * @param alias
    *            the alias
    * @throws NpccTradeServiceBusinessException
    *             the business exception
    * @see
    */
   public void listaComPaginacao(FRWKGL01Request request, FRWKGL01Response pResponse, String transactionName,
           String alias) throws NpccTradeException {
       try {
           // Executa transação
           getAdapterCWS().involkeProcessFromNC(request, pResponse, transactionName, RESOUCE, alias);
       } catch (CTGServiceException e) {
       	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  alias + " !!!!! ERROR !!!!! " + e.getErrorMessage()  + " XXXXXXXXXXXXXX");
           throw new NpccTradeWebException(e.getErrorMessage(), e, SiteUtil.STRING_EMPTY);
       } catch (Throwable t) {
       	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  alias + " !!!!! ERROR !!!!! " + t.getMessage()  + " XXXXXXXXXXXXXX");
           throw new NpccTradeException(t.getMessage(), t);
       }
   }

}
