package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.pagination.PaginationAPI;
import br.com.bradesco.web.aq.application.pagination.PaginationRequest;
import br.com.bradesco.web.aq.application.pagination.PaginationResponse;
import br.com.bradesco.web.aq.application.pagination.cws.CWSPaginationAPIAdapterImpl;
import br.com.bradesco.web.aq.application.pagination.cws.baseconnector.CWSBusinessServiceBaseConnector;
import br.com.bradesco.web.aq.application.pagination.factory.PaginationAPIFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList.Boletoagexlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList.Boletoagexlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList.Npccwn2erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList.Npccwn2sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList.Npccwn2sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList.Consultalogagexlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList.Consultalogagexlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList.Npccwn7erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList.Npccwn7sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList.Npccwn7sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Modeloboletodetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Modeloboletodetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Npccwvoerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Npccwvosresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.StatusBolAtz.Npccwn0erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.StatusBolAtz.Npccwn0sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.StatusBolAtz.Statusbolatzrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.StatusBolAtz.Statusbolatzresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinBolAgexIncl.Npccwnyerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinBolAgexIncl.Npccwnysresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinBolAgexIncl.Tradefinbolagexinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinBolAgexIncl.Tradefinbolagexinclresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.BolAgexListService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexListVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.StatusBolAtzFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
/**
 * 
  * Nome: BolAgexListServiceImpl.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 18/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
@Named("bolAgexListService")
@SessionScoped
public class BolAgexListServiceImpl extends BaseService implements BolAgexListService, Serializable{

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;
    
    /**
     * @return the msgRetorno
     */
    public String capturarMensagemRetorno() {
        return this.getMsgRetorno();
    }
    
	/**
	 * 
	 * Nome: incluirBoletoAgex
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 23/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String incluirBoletoAgex(BolAgexFiltroVO filtroVO) {

		Tradefinbolagexinclrequest request = new Tradefinbolagexinclrequest();
		Tradefinbolagexinclresponse response = new Tradefinbolagexinclresponse();

		Npccwnyerequest entrada = new Npccwnyerequest();
		Npccwnysresponse saida = new Npccwnysresponse();

		request.setNpccwnyerequest(entrada);
		response.setNpccwnysresponse(saida);

		entrada.setEdfchtobletocmbio(SiteUtil.dataWebToMainframe(filtroVO.getFechamento()));
		entrada.setEcunicclicmbio(filtroVO.getCunicpssoacmbio());
		
		entrada.setEcprodtservc(filtroVO.getCprodtservc());
		entrada.setEcmodldprodtcmbio(filtroVO.getCmodldprodtcmbio());
		entrada.setEcindcdeconmmoeda(filtroVO.getCindcdeconmmoeda());
		entrada.setEnseqcontrlim(filtroVO.getNcontrlim()); // Número limite gerencial (modal)
		entrada.setEvnegocmoedaestrg(SiteUtil.webMoedaToMainframe(filtroVO.getValorboleto())); // Valor boleto
		entrada.setEvsdolimsensi(SiteUtil.webMoedaToMainframe(filtroVO.getVdispnlimgerc())); // Valor Saldo Limite Disponível (modal)
		entrada.setEcbanqrcmbio(filtroVO.getCbcoextcmbio()); // Unidade externa
		entrada.setEcopercmbioexter(filtroVO.getNumoperexterior().trim()); // Número operação exterior
		entrada.setEvtxspreadnegoc(SiteUtil.webMoedaToMainframe(filtroVO.getSvtxspreadnegoc())); // Spread
		entrada.setEtdiaopercmbio(filtroVO.getTdiaprazo()); // Prazo
		entrada.setEdfimnegoccmbio(SiteUtil.dataWebToMainframe(filtroVO.getVencimento())); // Data vencimento
		entrada.setErtomobsbleto(filtroVO.getTomador().trim()); // Tomador
		entrada.setErobsbletocmbio(filtroVO.getObservacao().trim()); // Observação
		entrada.setEccatlggarntprin(filtroVO.getCcatlggarntprinc());

		// executa chamada CWS
		listaSemPaginacao(request, response, "TRADEFINBOLAGEXINCL");

		// Exibe mensagem do mainframe		
		this.setMsgRetorno(response.getTexmens());
		
		return String.format("%s <BR />NÚMERO DO BOLETO: %s", 
		                this.getMsgRetorno(), 
		                SiteUtil.formatarReferenciaBradesco(saida.getDanobase(), saida.getNbletocmbioano()));
	}


	/**
	 * 
	 * Nome: detalharBoletoAgex
	 * 
	 * Propósito: Recuperar informações detalhadas de boleto AGEX
	 *
	 * @param : filtroProduto
	 * @return : TradeFinBolAgexVO
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BolAgexVO detalharBoletoAgex(Integer codModeloBoleto) {

		BolAgexVO boletoAgexVO = new BolAgexVO();
		boletoAgexVO.setLista(new ArrayList<BolAgexListVO>());

		Modeloboletodetrequest request = new Modeloboletodetrequest();
		Modeloboletodetresponse response = new Modeloboletodetresponse();
		Npccwvoerequest bookEntrada = new Npccwvoerequest();
		Npccwvosresponse bookSaida = new Npccwvosresponse();

		request.setNpccwvoerequest(bookEntrada);
		response.setNpccwvosresponse(bookSaida);

		// carrega book de entrada
		bookEntrada.setCmodcontrcmbio(codModeloBoleto);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("response", response);
		params.put("transactionName", "MODELOBOLETODET");

		CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector> apiAdapter = new CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector>(
				getAdapterCWS());
		PaginationAPI paginationAPI = PaginationAPIFactory.getInstance()
				.getAPI("cws", apiAdapter, params);

		boolean init = false;
		boolean hasMoreData = false;
		// chama o mainframe enquanto ainda houver dados (hasMoreDataRight == true)
		do {
			PaginationRequest<Modeloboletodetrequest> paginationRequest = new PaginationRequest<Modeloboletodetrequest>(
					request);

			// preparando o objeto que vai receber o response da API, que encapsula o response do adaptador
			PaginationResponse<Modeloboletodetresponse> paginationResponse = null;

			if (!init) {
				init = true;
				// inicializa a paginacao atraves da API de paginacao e obtem o
				// retorno do adaptador
				// encapsulado em um response da API
				paginationResponse = paginationAPI.init(paginationRequest);
			} else {
				// obtem a proxima leva de dados do MF e retorna o response da
				// API que encapsula o retorno
				paginationResponse = paginationAPI.next(paginationRequest);
			}

			// atualiza a flag que informa se tem mais dados para frente (a direita)
			hasMoreData = paginationResponse.isHasMoreDataRight();
			response = paginationResponse.getResponse();

			// trata retorno
			this.setMsgRetorno(response.getTexmens());

			// processa os dados retornados pelo CWS
			for (int i = 0; i < response.getNpccwvosresponse().getQtdeocorr(); i++) {
				BolAgexListVO objTo = new BolAgexListVO();
				
				boletoAgexVO.getLista().add(objTo);
			}

		} while (hasMoreData);

		return boletoAgexVO;
	}
    
    public BolAgexVO pesquisar(BolAgexFiltroVO filtroVO, String stateId){
       	BolAgexVO bolAgexVO = new BolAgexVO();
        
        Boletoagexlistrequest request = new Boletoagexlistrequest();
        Boletoagexlistresponse response = new Boletoagexlistresponse();
        Npccwn2erequest entrada = new Npccwn2erequest();
        Npccwn2sresponse saida = new Npccwn2sresponse();
        
        request.setNpccwn2erequest(entrada);
        response.setNpccwn2sresponse(saida);
       
        if(!SiteUtil.isEmptyOrNull(filtroVO.getEdanobase())&& !SiteUtil.isEmptyOrNull(filtroVO.getEnbletonegoccmbioano())){
        	entrada.setEnbletocmbioano(filtroVO.getEnbletonegoccmbioano());
        	entrada.setEdanobase(filtroVO.getEdanobase());        	
        }
        else  if(!SiteUtil.isEmptyOrNull(filtroVO.getEdanobase())|| !SiteUtil.isEmptyOrNull(filtroVO.getEnbletonegoccmbioano())){
        	System.out.println("Informar ano e numero do boleto");
        	return bolAgexVO;		 	
        	
        }       
        else{        	
        	entrada.setEcprodtservc(filtroVO.getEcprodtservc());        
			entrada.setEcunicclicmbio(filtroVO.getEcunicclicmbio());        

			entrada.setEstatus(filtroVO.getEstatus());
			entrada.setEdataini(SiteUtil.dataWebToMainframe(filtroVO.getDataInicioFim().getInicio()));
			entrada.setEdatafim(SiteUtil.dataWebToMainframe(filtroVO.getDataInicioFim().getFim()));       
			
        }
        entrada.setEflag(filtroVO.getFlagBaixEstrn());
        entrada.setEcprodtservc(filtroVO.getCprodtservc());
        
        listaComPaginacao(request, response, "BOLETOAGEXLIST", stateId);
        
		// trata retorno
		this.setMsgRetorno(response.getTexmens());
        
        bolAgexVO.setQtdeocorr(saida.getQtdeocorr());
        
        for (int i = Numeros.ZERO; i < saida.getQtdeocorr(); i++) {
            Npccwn2sresponse_lista list = saida.getLista().get(i);
            BolAgexListVO item = new BolAgexListVO();
            
            item.setSstatus(list.getLista_sstatus());
            item.setStppessoa(list.getLista_stppessoa());

            item.setScpfcnpj(list.getLista_scpfcnpj()); 
			item.setScflialcnpj(list.getLista_scflialcnpj());
			item.setScctrlcpfcnpj(list.getLista_scctrlcpfcnpj());
			
            item.setCpfCnpj(SiteUtil.formatarCPFCCNPJ(list.getLista_scpfcnpj(), list.getLista_scflialcnpj(), list.getLista_scctrlcpfcnpj()));
            item.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(item.getScpfcnpj(), item.getScflialcnpj(),item.getScctrlcpfcnpj()));
            
            item.setSncunicclicmbio(list.getLista_scunicclidesc());
            item.setScunicclidesc(list.getLista_scunicclidesc());
            item.setScunicclicmbio(list.getLista_scunicclicmbio());
            
            item.setScprodtservc(list.getLista_scprodtservc());
            item.setScprodtdesc(list.getLista_scprodtdesc());
            
            item.setNbletocmbioano(list.getLista_snbletocmbioano());
            item.setSdanobase(list.getLista_sdanobase());
            item.setSnbletonegoccmbio(list.getLista_snbletonegoccmbio());
           
            item.setScbanqrcmbio(list.getLista_scbanqrcmbio());
            item.setSdcbanqrcmbio(list.getLista_sibanqrcmbio());
            
            item.setScopercmbioexter(list.getLista_scopercmbioexter());
            
            item.setStomador(list.getLista_stomador());
            item.setSobservacao(list.getLista_sobservacao());
            
            item.setSvtxspreadnegoc(SiteUtil.trocarPontoPorVirgula(list.getLista_svtxspreadnegoc()));
            item.setStdiaopercmbio(list.getLista_stdiaopercmbio());
            item.setScindcdeconmmoeda(list.getLista_scindcdeconmmoeda());
            item.setSisglindcdfonte(list.getLista_sisglindcdfonte());

            item.setSvnegocmoedaestrg(SiteUtil.formatarValorWeb(list.getLista_svnegocmoedaestrg()));
            item.setSnseqcontrlim(list.getLista_snseqcontrlim());

            item.setSvsdolimsensi(SiteUtil.formatarValorWeb(list.getLista_svsdolimsensi()));

            item.setSdfchtobletocmbio(SiteUtil.stringDataMainframeToWeb(list.getLista_sdfchtobletocmbio()));
            item.setSdfimnegoccmbio(SiteUtil.stringDataMainframeToWeb(list.getLista_sdfimnegoccmbio()));

            item.setSvultbaixacmbio(SiteUtil.formatarValorWeb(list.getLista_svultbaixacmbio()));
            item.setSvultestrncmbio(SiteUtil.formatarValorWeb(list.getLista_svultestrncmbio()));
            
            item.setScprodtlimitege(list.getLista_scprodtlimitege());
            item.setSdescprodtlimge(list.getLista_sdescprodtlimge());
            item.setScodmoedage(list.getLista_scodmoedage());
            item.setSdescmoedage(list.getLista_sdescmoedage());

            item.setSvalorlimge(SiteUtil.formatarValorWeb(list.getLista_svalorlimge()));
            item.setSvalordispge(SiteUtil.formatarValorWeb(list.getLista_svalordispge()));

            item.setSdfchtolimitege(SiteUtil.stringDataMainframeToWeb(list.getLista_sdfchtolimitege()));
            item.setScpssoajuridge(list.getLista_scpssoajuridge());
            
            item.setSctpocontrge(list.getLista_sctpocontrge());
            item.setSnseqcontrge(list.getLista_snseqcontrge());
            
            item.setSncontrlimge(list.getLista_sncontrlimge());
            item.setSdescstatus(list.getLista_sdescstatus());
            item.setSdescbanqueiro(list.getLista_sdescbanqueiro());

            item.setSdescgarantia(list.getLista_sdescgarantia());
            item.setScusuarincl(SiteUtil.STRING_EMPTY);
         
            item.setStatusCodDesc(SiteUtil.getString(item.getSdescstatus().trim()));
            item.setBanqrCodNom(SiteUtil.getString(item.getScbanqrcmbio()) + " - " + item.getSdescbanqueiro().trim());
           
            item.setRefBradesco(SiteUtil.formatarReferenciaBradesco(item.getSdanobase(), item.getNbletocmbioano()));
            
            bolAgexVO.getLista().add(item);
        }
        
        return bolAgexVO;
    }
    
    /**
     * 
        * Nome: excluir
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 19/04/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
     */
    public final String excluirConfirm(StatusBolAtzFiltroVO filtroVO) {

        Statusbolatzrequest request = new Statusbolatzrequest();
        Statusbolatzresponse response = new Statusbolatzresponse();
        Npccwn0erequest entrada = new Npccwn0erequest();
        Npccwn0sresponse saida = new Npccwn0sresponse();
        
        request.setNpccwn0erequest(entrada);
        response.setNpccwn0sresponse(saida);
        
        entrada.setEnbletonegoccmbio(filtroVO.getEnbletonegoccmbio());
        
        entrada.setEstatusbletocmbio(filtroVO.getEstatusbletocmbio());
        entrada.setEstatusbletoanter(filtroVO.getEstatusbletoanter());
        
        entrada.setEsaldbletocmbio(SiteUtil.webMoedaToMainframe(filtroVO.getEsaldbletocmbio()));
        entrada.setEvultestrnbaixa(SiteUtil.webMoedaToMainframe(filtroVO.getEvultestrnbaixa()));
        
        entrada.setEtmaxcontrprodt(filtroVO.getEtmaxcontrprodt());
        
        entrada.setEcindcdmoedautlzd(filtroVO.getEcindcdmoedautlzd());
        
        listaSemPaginacao(request, response, "STATUSBOLATZ");
        return response.getTexmens();
    }
    /**
     * 
        * Nome: consultaLogPesquisar
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 22/04/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
     */
    public BolAgexVO consultaLogPesquisar(BolAgexFiltroVO filtroVO){
        BolAgexVO bolAgexVO = new BolAgexVO();
        Consultalogagexlistrequest request = new Consultalogagexlistrequest();
        Consultalogagexlistresponse response = new Consultalogagexlistresponse();
        Npccwn7erequest entrada = new Npccwn7erequest();
        Npccwn7sresponse saida = new Npccwn7sresponse();
        request.setNpccwn7erequest(entrada);
        response.setNpccwn7sresponse(saida);
        
        entrada.setEcunicclicmbio(filtroVO.getEcunicclicmbio());
        entrada.setEdataini(SiteUtil.dataWebToMainframe(filtroVO.getDataInicioFim().getInicio()));
        entrada.setEdatafim(SiteUtil.dataWebToMainframe(filtroVO.getDataInicioFim().getFim()));
       
        listaComPaginacao(request, response, "CONSULTALOGAGEXLIST", "NPCCIAT1");
        //listaSemPaginacao(request, response, "CONSULTALOGLIST");
        bolAgexVO.setQtdeocorr(saida.getQtdeocorr());
        
        for (int i = Numeros.ZERO; i < saida.getQtdeocorr(); i++) {
            BolAgexListVO item = new BolAgexListVO();
            Npccwn7sresponse_lista list = saida.getLista().get(i);
            
            item.setCpfCnpj(SiteUtil.formatarCPFCCNPJ(list.getLista_sccpfcnpj(), list.getLista_scflialcpfcnpj(), list.getLista_scctrlcpfcnpj()));
            
            item.setScbanqrcmbio(list.getLista_scbanqrcmbio());
            item.setSccpfcnpj(list.getLista_sccpfcnpj());
            item.setScctrlcpfcnpj(list.getLista_scctrlcpfcnpj());
            item.setScflialcnpj(list.getLista_scflialcpfcnpj());
            item.setScflialcpfcnpj(list.getLista_scflialcpfcnpj());
            item.setScopercmbioexter(list.getLista_scopercmbioexter());
            item.setScprodtdesc( list.getLista_scprodtdesc());
            item.setScusuar(list.getLista_scusuar());
            item.setSdcbanqrcmbio(list.getLista_sdcbanqrcmbio());
            item.setSdfchtobletocmbio(SiteUtil.stringDataMainframeToWeb(list.getLista_sdfchtobletocmbio()));
            item.setSdfimnegoccmbio(SiteUtil.stringDataMainframeToWeb(list.getLista_sdfimnegoccmbio()));
            item.setShinclreg(SiteUtil.dateTimeMainframeToWeb((list.getLista_shinclreg())).substring(0,10));         
            item.setShmanutreg(list.getLista_shmanutreg());
            item.setSisglindcdfonte(list.getLista_sisglindcdfonte());
            item.setSnbletonegoccmbio(list.getLista_snbletonegoccmbio());
            item.setSnomecliente(list.getLista_snomecliente());
            item.setSnomefunc(list.getLista_snomefunc());
            item.setSrobsbletocmbio(list.getLista_srobsbletocmbio());
            item.setSrtomobsbleto(list.getLista_srtomobsbleto());
            item.setStdiaopercmbio(list.getLista_stdiaopercmbio());
            item.setStipomanut(list.getLista_stipomanut());
            item.setSvnegocmoedaestrg(SiteUtil.formatarValorWeb(list.getLista_svnegocmoedaestrg()));
            item.setSvsdolimsensi(SiteUtil.formatarValorWeb(list.getLista_svsdolimsensi()));
            item.setSvtxspreadnegoc(SiteUtil.trocarPontoPorVirgula(list.getLista_svtxspreadnegoc()));
            item.setNbletocmbioano(list.getLista_snbletocmbioano());
            item.setSdanobase(list.getLista_sdanobase());
            item.setRefBradesco(SiteUtil.formatarReferenciaBradesco(item.getSdanobase(), item.getNbletocmbioano()));
            
            bolAgexVO.getLista().add(item);
        }
        //bolAgexVO.getLista().addAll(mockLista());
        
        return bolAgexVO;
    }
 
}
