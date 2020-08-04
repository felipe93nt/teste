package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc.Garantiaaprlmtcrdincrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc.Garantiaaprlmtcrdincresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc.Npccwk7erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc.Npccwk7sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc.Npccwk7sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred.Garantiaavalmtcredrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred.Garantiaavalmtcredresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred.Npccwk8erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred.Npccwk8sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred.Npccwk8sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc.Garantiaavalistaincrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc.Garantiaavalistaincresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc.Npccwk9erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc.Npccwk9sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc.Npccwk9sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist.Garantiaadiclistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist.Garantiaadiclistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist.Npccwdgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist.Npccwdgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist.Npccwdgsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist.Garantiaaprovlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist.Garantiaaprovlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist.Npccwjperequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist.Npccwjpsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist.Npccwjpsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist.Garantiasavallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist.Garantiasavallistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist.Npccwjqerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist.Npccwjqsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist.Npccwjqsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.IGarantiasModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaAprLmtCreditoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CadastroNacionalPessoa;

@Named("garantiasModalService")
@SessionScoped
public class GarantiasModalServiceImpl extends BaseService implements IGarantiasModalService{
	
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
		* Nome: getGarantiaAdicionais
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 04/03/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<GarantiasVO> getGarantiaAdicionais(Long nbletonegoccmbio, String hinclreghist) {
		
		try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.getGarantiaAdicionais | GARANTIAADICLIST ------- ");
		
			List<GarantiasVO> garantiasVOs = new ArrayList<GarantiasVO>();
			Garantiaadiclistrequest request = new Garantiaadiclistrequest();
			Garantiaadiclistresponse response = new Garantiaadiclistresponse();
			
			Npccwdgerequest entrada = new Npccwdgerequest();
			Npccwdgsresponse saida = new Npccwdgsresponse();
			
			request.setNpccwdgerequest(entrada);
			response.setNpccwdgsresponse(saida);
			
			entrada.setNbletonegoccmbio(nbletonegoccmbio);
			entrada.setHinclreghist(hinclreghist);
			
			// Fluxo - NPCCIAB7 / BOOK: NPCCWDGE/S
			listaSemPaginacao(request, response, "GARANTIAADICLIST");
			
			for(int i=0; i < response.getNpccwdgsresponse().getQtdeocorr(); i++){
				Npccwdgsresponse_lista item = response.getNpccwdgsresponse().getLista().get(i);
				GarantiasVO garantiasVO = new GarantiasVO();
				garantiasVO.setCcaractpogarnt(item.getLista_ccatlggarnt());
				garantiasVO.setIcaractpogarnt(item.getLista_icaractpogarnt());
				garantiasVO.setDescrGaran(item.getLista_ccatlggarnt() + "-" + item.getLista_icaractpogarnt());
				garantiasVO.setRcomplgarntcmbio(item.getLista_rcomplgarntcmbio());
				garantiasVO.setVtxgarntcmbio(SiteUtil.formatarValorWeb(item.getLista_vtxgarntcmbio()));
				garantiasVO.setCindcdeconmmoegar(item.getLista_cindcdeconmmoeda());
				garantiasVO.setDescrMoedaGar(item.getLista_cinddseconmmoeda());
				garantiasVOs.add(garantiasVO);
			}
			
			return garantiasVOs;
			
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.getGarantiaAdicionais | GARANTIAADICLIST ------- ");
        }
	}

    /*private List<GarantiasVO> mockGarantiaAdicionais(){
    	
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.mockGarantiaAdicionais ------- ");
	    	
			List<GarantiasVO> lista = new ArrayList<GarantiasVO>();
	    	
			GarantiasVO garantiasVO = null;
	    	
	    	for (int i = 0; i < 11; i++) {
	    		
				garantiasVO = new GarantiasVO();
				garantiasVO.setCcaractpogarnt(SiteUtil.getInt(i));
				
				garantiasVO.setIcaractpogarnt("Nome Garantia Adicional");
				garantiasVO.setRcomplgarntcmbio("Complemento Garantia Adicional");
				garantiasVO.setVtxgarntcmbio(SiteUtil.trocarPontoPorVirgula("1.2345"));
				garantiasVO.setDescrGaran("Descricao Garantia Adicional");
				lista.add(garantiasVO);
				
	    	}
	    	
	    	return lista;
	    	
		 }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.mockGarantiaAdicionais ------- ");
        }
    	
    }*/
	
	/**
	 * 
		* Nome: getGarantiasAprovList
		* 
		* Propósito: Listar as Garantias Aprovadas
		*
		* @param : nbletonegoccmbio
		* @return : List<GarantiasAprovlistaVO>
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 20/01/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
    public List<GarantiasVO> getGarantiasAprovList(Long nbletonegoccmbio, String horalogmanut) {
    	
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.getGarantiasAprovList | GARANTIAAPROVLIST ------- ");
	    	
	    	List<GarantiasVO> lista = new ArrayList<GarantiasVO>();
	    	
	    	Garantiaaprovlistrequest request = new Garantiaaprovlistrequest();
	    	Garantiaaprovlistresponse response = new Garantiaaprovlistresponse();
	    	
	    	Npccwjperequest entrada = new Npccwjperequest();
	    	entrada.setNbletonegoccmbio(nbletonegoccmbio);
	    	entrada.setHoralogmanut(horalogmanut);
	    	
	    	Npccwjpsresponse saida = new Npccwjpsresponse();
	    	
	    	request.setNpccwjperequest(entrada);
	    	response.setNpccwjpsresponse(saida); 
	    	
	    	// FLUXO: NPCCIAG1 / BOOK: NPCCWJPE/S
	    	listaSemPaginacao(request, response, "GARANTIAAPROVLIST");
	    	
	    	GarantiasVO objTo = null;
	    	
	    	for (int i = 0; i < response.getNpccwjpsresponse().getQtdeocorr(); i++) {
	    		
	    		Npccwjpsresponse_lista objFrom = response.getNpccwjpsresponse().getLista().get(i);
	    		objTo = new GarantiasVO();
	    		
	    		objTo.setCcaractpogarnt(objFrom.getLista_ccatlggarnt());
	    		objTo.setIcaractpogarnt(objFrom.getLista_icaractpogarnt());
				objTo.setDescrGaran(objFrom.getLista_ccatlggarnt() + "-" + objFrom.getLista_icaractpogarnt());
	    		objTo.setVtxgarntcmbio(SiteUtil.formatarValorWeb(objFrom.getLista_vtxgarntcmbio()));
	    		objTo.setCindcdgarntprinc(objFrom.getLista_cindcdgarntprinc());
	    		objTo.setCidtfdgarntadcio(objFrom.getLista_cidtfdgarntadcio());
	    		objTo.setRcomplgarntcmbio(objFrom.getLista_rcomplgarntcmbio());
	    		objTo.setDescPrincipal(SiteUtil.indicadorSimNao(objTo.getCindcdgarntprinc()));
	    		objTo.setCindcdeconmmoegar(objFrom.getLista_cindcdeconmmoeda());
	    		objTo.setDescrMoedaGar(objFrom.getLista_cinddseconmmoeda());

	    		lista.add(objTo);
	    	}
	    	
	    	return lista;
	    	
		 }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.getGarantiasAprovList | GARANTIAAPROVLIST ------- ");
        }

    }

    /*private List<GarantiasVO> mockGarantiasAprov(){
    	
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.mockGarantiasAprov ------- ");
	    	
			List<GarantiasVO> lista = new ArrayList<GarantiasVO>();
	    	
			GarantiasVO objTo = null;
	    	
	    	for (int i = 0; i < 11; i++) {
	    		
	    		objTo = new GarantiasVO();
	    		objTo.setCcaractpogarnt(SiteUtil.getInt(i));
				
	    		objTo.setIcaractpogarnt("Nome Garantia Adicional");
	    		objTo.setRcomplgarntcmbio("Complemento Garantia Adicional");
	    		objTo.setVtxgarntcmbio(SiteUtil.trocarPontoPorVirgula("1.2345"));
	    		objTo.setDescrGaran("Descricao Garantia Adicional");
	    		objTo.setCindcdgarntprinc("P");
	    		objTo.setDescPrincipal(SiteUtil.indicadorSimNao("S"));
				
				lista.add(objTo);
				
	    	}
	    	
	    	return lista;
	    	
		 }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.mockGarantiasAprov ------- ");
        }
    	
    }*/
    
    
    /**
     * 
    	* Nome: getGarantiasAvaList
    	* 
    	* Propósito: Listar as garantias Avalistas 
    	*
    	* @param : nbletonegoccmbio
    	* @return : List<GarantiasAvaListaVO>
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 20/01/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public List<GarantiasAvaListaVO> getGarantiasAvaList(Long nbletonegoccmbio, String hinclreghist){
    	
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.getGarantiasAvaList | GARANTIASAVALLIST ------- ");
	    	
	    	List<GarantiasAvaListaVO> lista = new ArrayList<GarantiasAvaListaVO>();
	    	
	    	Garantiasavallistrequest request = new Garantiasavallistrequest();
	    	Garantiasavallistresponse response = new Garantiasavallistresponse();
	    	
	    	Npccwjqerequest entrada = new Npccwjqerequest();
	    	Npccwjqsresponse saida = new Npccwjqsresponse();
	    	
	    	entrada.setNbletonegoccmbio(nbletonegoccmbio);
	    	entrada.setHinclreghist(hinclreghist);
	    	
	    	request.setNpccwjqerequest(entrada);
	    	response.setNpccwjqsresponse(saida);
	    	
	    	// FLUXO: NPCCIAG2 / BOOK: NPCCWJQE/S
	    	listaSemPaginacao(request, response, "GARANTIASAVALLIST");
	    	
	    	GarantiasAvaListaVO objTo = null;
	    	
	    	for (int i = 0; i < response.getNpccwjqsresponse().getQtdeocorr(); i++) {
	    		
	    		Npccwjqsresponse_lista objFrom = response.getNpccwjqsresponse().getLista().get(i);
	    		objTo = new GarantiasAvaListaVO();            
	    		objTo.setCdcpfcnpj(objFrom.getLista_cdcpfcnpj());
	    		objTo.setCdctrlcpfcnpj(objFrom.getLista_cdctrlcpfcnpj());
	    		objTo.setCdempresa(objFrom.getLista_cdempresa());
	    		objTo.setCdfilial(objFrom.getLista_cdfilial());
	    		objTo.setCpssoa(objFrom.getLista_cpssoa());
	    		objTo.setCunicpssoacmbio(objFrom.getLista_cunicpssoacmbio());
	    		objTo.setDocumento(objFrom.getLista_documento());
	    		objTo.setNmconjuge(objFrom.getLista_nmconjuge());
	    		objTo.setNmnomecliente(objFrom.getLista_nmnomecliente());
	    		objTo.setQualificacao(objFrom.getLista_qualificacao());
	    		
    			if(!SiteUtil.isEmptyOrNull(objTo.getCdcpfcnpj())) {
                    objTo.setDcocliente(new CadastroNacionalPessoa(objTo.getCdcpfcnpj(), objTo.getCdfilial(),
                            objTo.getCdctrlcpfcnpj()).toString());	    			    
    			}
	    		
	    		lista.add(objTo);
	    	}
	    	
	    	return lista;
	    	
		 }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.getGarantiasAvaList | GARANTIASAVALLIST ------- ");
        }
    	
    }
	

//    private List<GarantiasAvaListaVO> mockListaGarantiasAva(){
//    	
//    	try{
//	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.mockListaGarantiasAva ------- ");
//	    	
//	    	List<GarantiasAvaListaVO> lista = new ArrayList<GarantiasAvaListaVO>();
//	    	
//	    	GarantiasAvaListaVO objTo = null;
//	    	
//	    	for (int i = 0; i < 11; i++) {
//	    		
//	    		//Npccwjqsresponse_lista objFrom = response.getNpccwjqsresponse().getLista().get(i);
//	    		objTo = new GarantiasAvaListaVO();            
//	    		objTo.setCunicpssoacmbio(SiteUtil.getLong(12345));
//	    		objTo.setCpssoa(SiteUtil.getLong(1));
//	    		objTo.setDocumento("AAAA");
//	    		objTo.setCdempresa(SiteUtil.getLong(987654321));
//	    		objTo.setCdcpfcnpj(SiteUtil.getInt(12345678));
//	    		objTo.setCdfilial(SiteUtil.getInt(1));
//	    		objTo.setCdctrlcpfcnpj(SiteUtil.getInt(12));
//	    		objTo.setNmnomecliente("MOCK NOME CLIENTE");
//	    		objTo.setNmconjuge("MOCK NOME CONJUGE");
//	    		objTo.setQualificacao("QUALIFICAÇÃO");
//	    		
//    			if(!SiteUtil.isEmptyOrNull(objTo.getCdcpfcnpj())) {
//                    objTo.setDcocliente(new CadastroNacionalPessoa(objTo.getCdcpfcnpj(), objTo.getCdfilial(),
//                            objTo.getCdctrlcpfcnpj()).toString());	    			    
//    			}
//	    		
//	    		lista.add(objTo);
//	    	}
//	    	
//	    	return lista;
//	    	
//		 }finally{
//            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.mockListaGarantiasAva ------- ");
//        }
//    	
//    }
    
    
    /**
	 * 
		* Nome: getGarantiasAprLmtCreditoList
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 22/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<GarantiasAvaAprLmtCreditoVO> getAvalistasAprLmtCreditoList(Long nseqcontrlim, Long nppstapontucmbio, 
	        Integer ccpfcnpj, Integer cflialcnpj, Integer cctrlcpfcnpj){
		
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.getAvalistasAprLmtCreditoList | GARANTIAAVALMTCRED ------- ");
	    	
	    	setMsgRetorno(null);
	    	List<GarantiasAvaAprLmtCreditoVO> lista = new ArrayList<GarantiasAvaAprLmtCreditoVO>();
	    	
	    	Garantiaavalmtcredrequest request = new Garantiaavalmtcredrequest();
	    	Garantiaavalmtcredresponse response = new Garantiaavalmtcredresponse();
	    	
	    	Npccwk8erequest entrada = new Npccwk8erequest();
	    	Npccwk8sresponse saida = new Npccwk8sresponse();
	    	
	    	try {
	    		
	    		request.setNpccwk8erequest(entrada);
	    		response.setNpccwk8sresponse(saida);
	    		
	    		entrada.setNseqcontrlim(nseqcontrlim);
	    		entrada.setNppstapontucmbio(nppstapontucmbio);
	    		entrada.setCcpfcnpj(ccpfcnpj);
	    		entrada.setCctrlcpfcnpj(cctrlcpfcnpj);
	    		entrada.setCflialcnpj(cflialcnpj);
	    		
	    		// FLUXO: NPCCIAH4 BOOK: NPCCWK8E/S 
	    		listaSemPaginacao(request, response, "GARANTIAAVALMTCRED"); 
	    		
	    		setMsgRetorno(response.getTexmens());
	    		
	    		for (int i = Numeros.ZERO; i < response.getNpccwk8sresponse().getQtdeocorr(); i++) {
	    			
	    			Npccwk8sresponse_lista objFrom = response.getNpccwk8sresponse().getLista().get(i);
	    			GarantiasAvaAprLmtCreditoVO  objTo =  new GarantiasAvaAprLmtCreditoVO();
	    			
	    			objTo.setDocumento(objFrom.getLista_documento());
	    			objTo.setCdcpfcnpj(objFrom.getLista_cdcpfcnpj());
	    			objTo.setCdfilial(objFrom.getLista_cdfilial());
	    			objTo.setCdctrlcpfcnpj(objFrom.getLista_cdctrlcpfcnpj());
	    			objTo.setNmnomecliente(objFrom.getLista_nmnomecliente());
	    			objTo.setCdoctopssoaempr(objFrom.getLista_cdoctopssoaempr());
	    			objTo.setDindcdobrigavals(objFrom.getLista_dindcdobrigavals());
	    			
	    			if(!SiteUtil.isEmptyOrNull(objTo.getCdcpfcnpj())) {
                        objTo.setCpfcnpjformatado(new CadastroNacionalPessoa(objTo.getCdcpfcnpj(), objTo.getCdfilial(),
                                objTo.getCdctrlcpfcnpj()).toString());	    			    
	    			}
	    			
	    			lista.add(objTo);
	    		}
	    		
	    	} catch (NpccTradeWebException e) {
	    		setMsgRetorno(e.getMessage());
	    		lista = new ArrayList<GarantiasAvaAprLmtCreditoVO>();
	    	}
	    	
	    	return lista;
	    	
		 }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.getAvalistasAprLmtCreditoList | GARANTIAAVALMTCRED ------- ");
        }
		
	}

	
    /*private List<GarantiasAvaAprLmtCreditoVO> mockAvalistasAprLmtCredito(){
    	
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.mockAvalistasAprLmtCredito ------- ");
	    	
	    	List<GarantiasAvaAprLmtCreditoVO> lista = new ArrayList<GarantiasAvaAprLmtCreditoVO>();
	    	
			GarantiasAvaAprLmtCreditoVO  objTo =  null;
	    	
	    	for (int i = 0; i < 11; i++) {
	    		
    			objTo =  new GarantiasAvaAprLmtCreditoVO();
    			
    			objTo.setDocumento("CNPJ");
    			objTo.setNseqcontrlim(SiteUtil.getLong(i));
    			objTo.setCdcpfcnpj(SiteUtil.getInt(12345678));
    			objTo.setCdfilial(SiteUtil.getInt(1));
    			objTo.setCdctrlcpfcnpj(SiteUtil.getInt(12));
    			objTo.setNmnomecliente("Nome do Cliente");
    			objTo.setCdoctopssoaempr("CDOCTO-PSSOA-EMPR");
    			objTo.setDindcdobrigavals("01");
    			
    			if(!SiteUtil.isEmptyOrNull(objTo.getCdcpfcnpj())) {
                    objTo.setCpfcnpjformatado(new CadastroNacionalPessoa(objTo.getCdcpfcnpj(), objTo.getCdfilial(), objTo.getCdctrlcpfcnpj()).toString());	    			    
    			}
    			
				lista.add(objTo);
				
	    	}
	    	
	    	return lista;
	    	
		 }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.mockAvalistasAprLmtCredito ------- ");
        }
    	
    }*/
	
	
	public List<GarantiasVO> getGarantiasAprovadasInclusao(Integer codProd, 
			Integer cpfCnpj, Integer cFilial, Integer ctrl, Long ncontrlim, Long nppstapontucmbio){
		
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.getGarantiasAprovadasInclusao | GARANTIAAPRLMTCRDINC ------- ");
	    	
	    	setMsgRetorno(null);
	    	List<GarantiasVO> lista = new ArrayList<GarantiasVO>();
	    	Garantiaaprlmtcrdincrequest request = new Garantiaaprlmtcrdincrequest();
	    	Garantiaaprlmtcrdincresponse response = new Garantiaaprlmtcrdincresponse();
	    	Npccwk7erequest entrada = new Npccwk7erequest();
	    	Npccwk7sresponse saida = new Npccwk7sresponse();
	    	
	    	try {
	    		
	    		request.setNpccwk7erequest(entrada);
	    		response.setNpccwk7sresponse(saida);
	    		
	    		entrada.setCprodtservcoper(codProd);
	    		entrada.setCcpfcnpj(cpfCnpj);
	    		entrada.setCflialcpfcnpj(cFilial);
	    		entrada.setCctrlcpfcnpj(ctrl);
	    		entrada.setNcontrlim(ncontrlim);
	    		entrada.setNppstapontucmbio(nppstapontucmbio);
	    		
	    		// Fluxo - NPCCIAH3 / BOOK: NPCCWK7E/S
	    		listaSemPaginacao(request, response, "GARANTIAAPRLMTCRDINC");
	    		
	    		setMsgRetorno(response.getTexmens());
	    		
	    		for (int i = Numeros.ZERO; i < response.getNpccwk7sresponse().getQtdeocorr(); i++) {
	    			Npccwk7sresponse_lista objfrom = response.getNpccwk7sresponse().getLista().get(i);
	    			GarantiasVO objTo = new GarantiasVO();
	    			
	    			objTo.setCcaractpogarnt(objfrom.getLista_ccaractpogarnt());
	    			objTo.setIcaractpogarnt(objfrom.getLista_icaractpogarnt());
	    			objTo.setDescrGaran(objfrom.getLista_ccaractpogarnt() + "-" + objfrom.getLista_icaractpogarnt());
	    			objTo.setCindcdeconmmoegar(objfrom.getLista_cindcdeconmmoegar());
	    			objTo.setDescrMoedaGar(objfrom.getLista_cindcddescrmoegar());
	    			objTo.setVtxgarntcmbio(SiteUtil.formatarValorWeb(objfrom.getLista_vtxgarntcmbio()));
	    			objTo.setDvctogarntcmbio(objfrom.getLista_dvctogarantcmbio());
	    			objTo.setCindcdgarntprinc(objfrom.getLista_cindcdgarntprinc());
	    			objTo.setDescPrincipal(SiteUtil.indicadorSimNao(objTo.getCindcdgarntprinc()));
	    			objTo.setCidtfdgarntadcio(Numeros.DOIS);
	    			
	    			lista.add(objTo);
	    		}
	    		
	    	
	    		
	    	} catch (NpccTradeWebException e) {
	    		setMsgRetorno(e.getMessage());
	    		lista = new ArrayList<GarantiasVO>();
	    	}
	    	
	    	return lista;
	    	
		 }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.getGarantiasAprovadasInclusao | GARANTIAAPRLMTCRDINC ------- ");
        }
		
	}
    
	/**
	 * 
		* Nome: getAvalistasCadastroInclusao
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 22/03/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<GarantiasAvaListaVO> getAvalistasCadastroInclusao(Long cunicpssoa, Integer ctpovnclo) {
		
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.getAvalistasCadastroInclusao | GARANTIAAVALISTAINC ------- ");
	    	
	    	setMsgRetorno(null);
	    	List<GarantiasAvaListaVO> lista = new ArrayList<GarantiasAvaListaVO>();
	    	
	    	Garantiaavalistaincrequest request = new Garantiaavalistaincrequest();
	    	Garantiaavalistaincresponse response = new Garantiaavalistaincresponse();
	    	Npccwk9erequest entrada = new Npccwk9erequest();
	    	Npccwk9sresponse saida = new Npccwk9sresponse();
	    	
	    	try {
	    		
	    		request.setNpccwk9erequest(entrada);
	    		response.setNpccwk9sresponse(saida);
	    		
	    		entrada.setCunicpssoacmbio(cunicpssoa);
	    		entrada.setCtpovnclocmbio(ctpovnclo);
	    		
	    		// Fluxo - NPCCIAH5 / BOOK: NPCCWK9E/S
	    		listaSemPaginacao(request, response, "GARANTIAAVALISTAINC");
	    		
	    		setMsgRetorno(response.getTexmens());
	    		
	    		for (int i = 0; i < response.getNpccwk9sresponse().getQtdeocorr(); i++) {
	    			
	    			Npccwk9sresponse_lista objFrom = response.getNpccwk9sresponse().getLista().get(i);
	    			GarantiasAvaListaVO objTo = new GarantiasAvaListaVO();            
	    			objTo.setCdcpfcnpj(objFrom.getLista_cdcpfcnpj());
	    			objTo.setCdctrlcpfcnpj(objFrom.getLista_cdctrlcpfcnpj());
	    			objTo.setCdfilial(objFrom.getLista_cdfilial());
	    			objTo.setCunicpssoacmbio(objFrom.getLista_cunicpssoacmbio());
	    			objTo.setDocumento(objFrom.getLista_documento());
	    			objTo.setNmnomecliente(objFrom.getLista_nmnomecliente());
	    			objTo.setQualificacao(objFrom.getLista_qualificacao());
	    			
	    			if(!SiteUtil.isEmptyOrNull(objTo.getCdcpfcnpj())) {
	                    objTo.setDcocliente(new CadastroNacionalPessoa(objTo.getCdcpfcnpj(), objTo.getCdfilial(),
	                            objTo.getCdctrlcpfcnpj()).toString());	    			    
	    			}
	    			
	    			lista.add(objTo);
	    		}
	    		
	    	} catch (NpccTradeWebException e) {
	    		setMsgRetorno(e.getMessage());
	    		lista = new ArrayList<GarantiasAvaListaVO>();
	    	}
	    	
	    	
	    	return lista;
	    	
		 }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.getAvalistasCadastroInclusao | GARANTIAAVALISTAINC ------- ");
        }
		
	}
	
}
	
	//Método pra ser utilizado como mock do avalista	
//	public List<GarantiasAvaListaVO> getAvalistasCadastroInclusao(Long cunicpssoa, Integer ctpovnclo) {
//		
//    	try{
//	    	BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] GarantiasModalServiceImpl.getAvalistasCadastroInclusao | GARANTIAAVALISTAINC ------- ");
//	    	
//	    	setMsgRetorno(null);
//	    	List<GarantiasAvaListaVO> lista = new ArrayList<GarantiasAvaListaVO>();
//	    	
//	    	
//	    	try {
//	    		
//	    		for (int i = 0; i < 11; i++) {
//	    			
//	    			GarantiasAvaListaVO objTo = new GarantiasAvaListaVO();   
//	    			
//		    		objTo.setCunicpssoacmbio(SiteUtil.getLong(12345));
//		    		objTo.setDocumento("AAAA");
//		    		objTo.setCdcpfcnpj(SiteUtil.getInt(12345678));
//		    		objTo.setCdfilial(SiteUtil.getInt(1));
//		    		objTo.setCdctrlcpfcnpj(SiteUtil.getInt(12));
//		    		objTo.setNmnomecliente("MOCK NOME CLIENTE");
//		    		objTo.setQualificacao("QUALIFICAÇÃO");
//	    			
//	    			
//	    			if(!SiteUtil.isEmptyOrNull(objTo.getCdcpfcnpj())) {
//	                    objTo.setDcocliente(new CadastroNacionalPessoa(objTo.getCdcpfcnpj(), objTo.getCdfilial(),
//	                            objTo.getCdctrlcpfcnpj()).toString());	    			    
//	    			}
//	    			
//	    			lista.add(objTo);
//	    		}
//	    		
//	    	} catch (NpccTradeWebException e) {
//	    		setMsgRetorno(e.getMessage());
//	    		lista = new ArrayList<GarantiasAvaListaVO>();
//	    	}
//	    	
//	    	
//	    	return lista;
//	    	
//		 }finally{
//            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] GarantiasModalServiceImpl.getAvalistasCadastroInclusao | GARANTIAAVALISTAINC ------- ");
//        }
//		
//	}
//	
//}
