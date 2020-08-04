package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.cotacoesaVencer.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.data.connector.baseconnector.exception.CTGServiceException;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList.Cotacoesavencerlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList.Cotacoesavencerlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList.Npccwzjerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList.Npccwzjsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList.Npccwzjsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.web.npcc_trade.service.business.NpccTradeServiceBusinessException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.cotacoesaVencer.ICotacoesaVencerService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.cotacoesaVencer.bean.CotacoesaVencerVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

@Named("cotacoesaVencerServiceImpl")
@SessionScoped
public class CotacoesaVencerServiceImpl extends BaseService implements ICotacoesaVencerService{

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
   public CotacoesaVencerServiceImpl() {
       super();
   }
	
   public List<CotacoesaVencerVO> getCotacoesaVencer(Integer qtddias){
	   try{
           BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] CotacoesaVencerServiceImpl.CotacoesaVencer | COTACOESAVENCERLIST ------- ");
           
           List<CotacoesaVencerVO> lista = new ArrayList<CotacoesaVencerVO>();
           
           Cotacoesavencerlistrequest request = new Cotacoesavencerlistrequest();
           Cotacoesavencerlistresponse response = new Cotacoesavencerlistresponse();
           
           Npccwzjerequest entrada = new Npccwzjerequest();
           Npccwzjsresponse saida = new Npccwzjsresponse();
           
           request.setNpccwzjerequest(entrada);
           response.setNpccwzjsresponse(saida);
           
           entrada.setQtddias(qtddias);      

           
           // Fluxo - NPCCIARB / NPCCWZJE - NPCCWZJS
           listaComPaginacao(request, response, "COTACOESAVENCERLIST","NPCCIARB");

           // Lista
           for (int i = 0; i < saida.getQtdeocorr(); i++) {
               
               Npccwzjsresponse_lista objFrom = saida.getLista().get(i);
               CotacoesaVencerVO cotacoesVO = new CotacoesaVencerVO();
               
               cotacoesVO.setNbletocmbio(SiteUtil.getInt(objFrom.getLista_nbletonegoccmbio()));
               cotacoesVO.setDanobase(SiteUtil.getString((objFrom.getLista_danobase())));
               cotacoesVO.setNbletocmbioano(SiteUtil.completarZerosEsquerda(9, SiteUtil.getString(objFrom.getLista_nbletocmbioano())));
               cotacoesVO.setDfchtobletocmbio(objFrom.getLista_dfchtobletocmbio().replaceAll("\\.", "/"));
               cotacoesVO.setCuniccliccmbio(SiteUtil.getInt(objFrom.getLista_cunicclicmbio()));
               cotacoesVO.setCindcdeconmmoeda(objFrom.getLista_cindcdeconmmoeda());
               cotacoesVO.setCprodtserv(objFrom.getLista_cprodtservc());
               cotacoesVO.setCeconmmoedalim(objFrom.getLista_ceconmmoedalim());
               cotacoesVO.setDfimnegoccmbio(objFrom.getLista_dfimnegoccmbio().replaceAll("\\.", "/"));
               cotacoesVO.setVnegocmoedaestrg(SiteUtil.formatarValorWeb(objFrom.getLista_vnegocmoedaestrg()));
               cotacoesVO.setVnegocmoedadolar(SiteUtil.formatarValorWeb(objFrom.getLista_vnegocmoedadolar()));
               cotacoesVO.setDescprod(objFrom.getLista_descprod());
               cotacoesVO.setIsglindcdfonte(objFrom.getLista_isglindcdfonte());
               cotacoesVO.setNomecompletocli(objFrom.getLista_nomecompletocli());
               
               
               lista.add(cotacoesVO);
               
           }
           
           return lista;
           
       }finally{
           BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] CotacoesaVencerServiceImpl.CotacoesaVencer | COTACOESAVENCERLIST ------- ");
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
