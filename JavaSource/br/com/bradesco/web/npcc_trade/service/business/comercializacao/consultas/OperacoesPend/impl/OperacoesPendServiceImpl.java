package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.data.connector.baseconnector.exception.CTGServiceException;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList.Npccwznerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList.Npccwznsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList.Npccwznsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList.Operacoespendlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList.Operacoespendlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais.Npccwzoerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais.Npccwzosresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais.Npccwzosresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais.Operacoespendtotaisrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais.Operacoespendtotaisresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.web.npcc_trade.service.business.NpccTradeServiceBusinessException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.IOperacoesPendService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.bean.OperacoesPendTotaisVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.bean.OperacoesPendVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.FormatadorParaView;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.operacoesPend.OperacoesPendViewHelper;


@Named("operacoesPendService")
@SessionScoped
public class OperacoesPendServiceImpl extends BaseService implements IOperacoesPendService{

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
   public OperacoesPendServiceImpl() {
       super();
   }
   
	public List<OperacoesPendVO> getOperacoesPend(OperacoesPendViewHelper operPend) {

		try {
			BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] OperacoesPendServiceImpl.OperacoesPend | OPERACOESPENDLIST ------- ");

			List<OperacoesPendVO> lista = new ArrayList<OperacoesPendVO>();

			Operacoespendlistrequest request = new Operacoespendlistrequest();
			Operacoespendlistresponse response = new Operacoespendlistresponse();

			Npccwznerequest entrada = new Npccwznerequest();
			Npccwznsresponse saida = new Npccwznsresponse();

			request.setNpccwznerequest(entrada);
			response.setNpccwznsresponse(saida);

			entrada.setDprevtdsembi(SiteUtil.dataWebToMainframe(operPend.getPeriodoCotacao().getInicio()));
			entrada.setDprevtdsembf(SiteUtil.dataWebToMainframe(operPend.getPeriodoCotacao().getFim()));
			entrada.setCprodtservc(operPend.getCprodtservc());
			entrada.setVprevtdsembi(operPend.getVprevtdsembi());
			entrada.setVprevtdsembf(operPend.getVprevtdsembf());
			entrada.setCodsituacao(operPend.getCsitbletocmbio());

			// Fluxo - NPCCIARF / NPCCWZNE - NPCCWZNS
			listaComPaginacao(request, response, "OPERACOESPENDLIST", "NPCCIARF");

			// Lista
			for (int i = 0; i < saida.getQtdeocorr(); i++) {

				Npccwznsresponse_lista objFrom = saida.getLista().get(i);
				OperacoesPendVO operacoesPendVO = new OperacoesPendVO();

				operacoesPendVO.setDprevtdsembcmbio(objFrom.getLista_dprevtdsembcmbio().replaceAll("\\.", "/"));
				operacoesPendVO.setTdiafinandsemb(objFrom.getLista_tdiafinandsemb());
				operacoesPendVO.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade().replaceAll("\\.", "/"));
				operacoesPendVO.setIsglindcdfonte(objFrom.getLista_isglindcdfonte());
				operacoesPendVO.setVprevtdsembcmbio(SiteUtil.formatarValorWeb(objFrom.getLista_vprevtdsembcmbio()));
				operacoesPendVO.setDfchtobletocmbio(objFrom.getLista_dfchtobletocmbio().replaceAll("\\.", "/"));
				operacoesPendVO.setNomeprodtservc(objFrom.getLista_nomeprodtservc());
				operacoesPendVO.setImpexpdevedor(objFrom.getLista_impexpdevedor());
				operacoesPendVO.setNomeundorgnz(objFrom.getLista_nomeundorgnz());
				
				BigDecimal temp = getValor(objFrom.getLista_vtxliborcmbio().toString());
			    String auxMeses = temp.toBigInteger().toString();
			    int meses = Integer.parseInt(auxMeses);
			    if (meses == 0) {
			    	auxMeses = "";
			    } else if (meses == 1) {
			    	auxMeses = auxMeses+ " mês";
				} else {
					auxMeses = auxMeses+ " meses";
				}
			    operacoesPendVO.setVtxliborcmbio(auxMeses);
				operacoesPendVO.setIorgextercmbio(objFrom.getLista_iorgextercmbio());
				operacoesPendVO.setCustoexternaa(SiteUtil.trocarPontoPorVirgula(getValor(objFrom.getLista_custoexternaa()).toString()));
				operacoesPendVO.setSpreadnegocaa(SiteUtil.trocarPontoPorVirgula(getValor(objFrom.getLista_spreadnegocaa()).toString()));
				operacoesPendVO.setNumeroop(objFrom.getLista_numeroop());
				operacoesPendVO.setIsitbletocmbio(objFrom.getLista_descsituacao());

				lista.add(operacoesPendVO);

			}

			return lista;

		} finally {
			BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] OperacoesPendServiceImpl.OperacoesPend | OPERACOESPENDLIST ------- ");
		}
	}
	
	protected BigDecimal getValor(final String fromServidor) {
		BigDecimal retorno;
		String valor = SiteUtil.formatarPontosVirgula(fromServidor);
		retorno = new BigDecimal(valor);
		return (retorno);
	}
	
	public List<OperacoesPendTotaisVO> getOperacoesPendTotais(OperacoesPendViewHelper operPendTotais, Integer flagLista) {

		try {
			BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] OperacoesPendServiceImpl.OperacoesPend | OPERACOESPENDLIST ------- ");

			List<OperacoesPendTotaisVO> lista = new ArrayList<OperacoesPendTotaisVO>();

			Operacoespendtotaisrequest request = new Operacoespendtotaisrequest();
			Operacoespendtotaisresponse response = new Operacoespendtotaisresponse();

			Npccwzoerequest entrada = new Npccwzoerequest();
			Npccwzosresponse saida = new Npccwzosresponse();

			request.setNpccwzoerequest(entrada);
			response.setNpccwzosresponse(saida);

			entrada.setDprevtdsembi(SiteUtil.dataWebToMainframe(operPendTotais.getPeriodoCotacao().getInicio()));
			entrada.setDprevtdsembf(SiteUtil.dataWebToMainframe(operPendTotais.getPeriodoCotacao().getFim()));
			entrada.setCprodtservc(operPendTotais.getCprodtservc());
			entrada.setVprevtdsembi(operPendTotais.getVprevtdsembi());
			entrada.setVprevtdsembf(operPendTotais.getVprevtdsembf());
			entrada.setFlaglista(flagLista);

			// Fluxo - NPCCIARG   / NPCCWZoE - NPCCWZoS
			listaComPaginacao(request, response, "OPERACOESPENDTOTAIS", "NPCCIARG");

			// Lista
			for (int i = 0; i < saida.getQtdeocorr(); i++) {

				Npccwzosresponse_lista objFrom = saida.getLista().get(i);
				OperacoesPendTotaisVO operacoesPendTotaisVO = new OperacoesPendTotaisVO();

				operacoesPendTotaisVO.setNomeundorgnz(objFrom.getLista_nomeundorgnz());
				operacoesPendTotaisVO.setVprevtdsembcmbio(SiteUtil.formatarValorWeb(objFrom.getLista_vprevtdsembcmbio()));
				operacoesPendTotaisVO.setIsitbletocmbio(objFrom.getLista_isglindcdfonte());


				lista.add(operacoesPendTotaisVO);

			}

			return lista;

		} finally {
			BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] OperacoesPendServiceImpl.OperacoesPend | OPERACOESPENDLIST ------- ");
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

   /**
    * Nome: pesquisarCotacoesExportacao
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas. 
    *
    * Registro  de Manutenção: 08/07/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
   public List<OperacoesPendVO> pesquisarCotacoesExportacao(OperacoesPendViewHelper operPend) {
       
	   try{

		   BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] OperacoesPendServiceImpl.pesquisarCotacoesExportacao | OPERACOESPENDLIST ------- ");

		   List<OperacoesPendVO> lista = new ArrayList<OperacoesPendVO>();

		   Operacoespendlistrequest request = new Operacoespendlistrequest();
		   Operacoespendlistresponse response = new Operacoespendlistresponse();

		   Npccwznerequest entrada = new Npccwznerequest();
		   Npccwznsresponse saida = new Npccwznsresponse();

		   request.setNpccwznerequest(entrada);
		   response.setNpccwznsresponse(saida);

		   entrada.setDprevtdsembi(SiteUtil.dataWebToMainframe(operPend.getPeriodoCotacao().getInicio()));
		   entrada.setDprevtdsembf(SiteUtil.dataWebToMainframe(operPend.getPeriodoCotacao().getFim()));
		   entrada.setCprodtservc(operPend.getCprodtservc());
		   entrada.setVprevtdsembi(operPend.getVprevtdsembi());
		   entrada.setVprevtdsembf(operPend.getVprevtdsembf());
		   entrada.setCodsituacao(operPend.getCsitbletocmbio());

		   // Executa chamada CWS - Fluxo - NPCCIARF - Books: NPCCWZNE / NPCCWZNS
		   List<Operacoespendlistresponse> pages = autoPaginate(request, response, "OPERACOESPENDLIST");

		   // Percorre todas as paginas obtidas do MF
		   for (Operacoespendlistresponse page : pages) {
			   Npccwznsresponse currentOutput = page.getNpccwznsresponse();

			   // Percorre todas as ocorrencias de cada pagina
			   for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {
				   Npccwznsresponse_lista objFrom = currentOutput.getLista().get(i);
				   OperacoesPendVO operacoesPendVO = new OperacoesPendVO();

				   operacoesPendVO.setDprevtdsembcmbio(objFrom.getLista_dprevtdsembcmbio().replaceAll("\\.", "/"));
				   operacoesPendVO.setTdiafinandsemb(objFrom.getLista_tdiafinandsemb());
				   operacoesPendVO.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade().replaceAll("\\.", "/"));
				   operacoesPendVO.setIsglindcdfonte(objFrom.getLista_isglindcdfonte());
				   operacoesPendVO.setVprevtdsembcmbio(SiteUtil.formatarValorWeb(objFrom.getLista_vprevtdsembcmbio()));
				   operacoesPendVO.setDfchtobletocmbio(objFrom.getLista_dfchtobletocmbio().replaceAll("\\.", "/"));
				   operacoesPendVO.setNomeprodtservc(objFrom.getLista_nomeprodtservc());
				   operacoesPendVO.setImpexpdevedor(objFrom.getLista_impexpdevedor());
				   operacoesPendVO.setNomeundorgnz(objFrom.getLista_nomeundorgnz());
				   operacoesPendVO.setVtxliborcmbio(SiteUtil.formatarValorWeb(objFrom.getLista_vtxliborcmbio()));
				   operacoesPendVO.setIorgextercmbio(objFrom.getLista_iorgextercmbio());
				   operacoesPendVO.setCustoexternaa(objFrom.getLista_custoexternaa());
				   operacoesPendVO.setSpreadnegocaa(objFrom.getLista_spreadnegocaa());
				   operacoesPendVO.setNumeroop(objFrom.getLista_numeroop());
				   operacoesPendVO.setIsitbletocmbio(objFrom.getLista_descsituacao());

				   lista.add(operacoesPendVO);

			   }
		   }

		   return lista;

	   } finally {
		   BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] OperacoesPendServiceImpl.pesquisarCotacoesExportacao | OPERACOESPENDLIST ------- ");
	   }
	   
   }


}
