package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.clienteModal.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList.Clipornomeoucnpjlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList.Clipornomeoucnpjlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList.Npccwxuerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList.Npccwxusresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList.Npccwxusresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.clienteModal.IClienteModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNaoStr;

@Named("clienteModalService")
@RequestScoped
public class ClienteModalServiceImpl extends BaseService implements IClienteModalService, Serializable {
	
	/** Variavel do tipo long. */
	private static final long serialVersionUID = -1792295858586588401L;

	/**
	* Nome: getClientePorNomeOuCnpjList
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 12/01/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
	public List<TradeFinNegocListasVO> listar(ClienteSelecaoVO vo, boolean pesqCpf) {
		
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] ClienteModalServiceImpl.listar | CLIPORNOMEOUCNPJLIST ------- ");
            
		    List<TradeFinNegocListasVO> lista = new ArrayList<TradeFinNegocListasVO>();
		
		    TradeFinNegocListasVO objTo = null;
		
		    Clipornomeoucnpjlistrequest request = new Clipornomeoucnpjlistrequest();
		    Clipornomeoucnpjlistresponse response = new Clipornomeoucnpjlistresponse();
		    Npccwxuerequest entrada = new Npccwxuerequest();
		    Npccwxusresponse saida = new Npccwxusresponse();
		    request.setNpccwxuerequest(entrada);
		    response.setNpccwxusresponse(saida);
		    
		    entrada.setIndpesquisa(vo.getCodCpfCnpj());
		    
		    if (vo.getCodCpfCnpj() == Numeros.DOIS && vo.getCnpj() != null && !vo.getCnpj().toString().equals("")) {
	            entrada.setCdcpfcnpj(SiteUtil.nullToInteger(vo.getCnpj().getCnpjCampo1() + vo.getCnpj().getCnpjCampo2()
	                            + vo.getCnpj().getCnpjCampo3()));
	            entrada.setCdctrlcpfcnpj(SiteUtil.nullToInteger(vo.getCnpj().getCnpjCampo5()));
	            entrada.setCdfilial(SiteUtil.nullToInteger(vo.getCnpj().getCnpjCampo4()));
	            
	        }
	
	        // CPF
	        else if (vo.getCodCpfCnpj() == Numeros.TRES && pesqCpf && vo.getCpf() != null && !vo.getCpf().toString().equals("")) {
	            entrada.setCdcpfcnpj(SiteUtil.nullToInteger(vo.getCpf().getCpfCampo1() + vo.getCpf().getCpfCampo2()
	                            + vo.getCpf().getCpfCampo3()));
	            entrada.setCdctrlcpfcnpj(SiteUtil.nullToInteger(vo.getCpf().getCpfCampo4()));
	            entrada.setCdfilial(Numeros.ZERO);
	            
	        }else{
	        	//TODO: Verificar com pessoal do Trade (Thiago) a adição do "tipo pesquisa" para escolher qual deve ser realizada
	        	entrada.setIndpesquisa(Numeros.UM);
	        	entrada.setNmnomecliente(vo.getNomeCliente());
	        	
	        }
		    
		    // Executa chamada CWS - Fluxo: NPCCIASJ - Books: NPCCWXUE / NPCCWXUS
		    listaComPaginacao(request, response, "CLIPORNOMEOUCNPJLIST", "NPCCIASJ");
		    
		    setMsgRetorno(response.getTexmens());
		
		    for (int i = 0; i < response.getNpccwxusresponse().getQtdeocorr(); i++) {
		
		        Npccwxusresponse_lista objFrom = response.getNpccwxusresponse().getLista().get(i);
		        
		        objTo = new TradeFinNegocListasVO();
		
		        // Copia os valores das propriedades com o mesmo nome
		        objTo.setIredzdpssoacmbio(objFrom.getLista_iredzdpssoacmbio());
		        objTo.setCdcpfcnpj(objFrom.getLista_cdcpfcnpj());
		        objTo.setCdfilial(objFrom.getLista_cdfilial());
		        objTo.setCdctrlcpfcnpj(objFrom.getLista_cdctrlcpfcnpj());
		        objTo.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(objFrom.getLista_cdcpfcnpj(),
		        		objFrom.getLista_cdfilial(), objFrom.getLista_cdctrlcpfcnpj()));
		
		        objTo.setBconome(objFrom.getLista_bconome());
		        objTo.setCagbcria(objFrom.getLista_cagbcria());
		        objTo.setCctabcriacli(objFrom.getLista_cctabcriacli());
		        objTo.setCdigbcriacli(objFrom.getLista_cdigbcriacli());
		        objTo.setContaDvFormatado(objFrom.getLista_cctabcriacli() + "-" + objFrom.getLista_cdigbcriacli());
		        
		        objTo.setCunicpssoacmbio(objFrom.getLista_cunicpssoacmbio());
		        objTo.setNctabcriacmbio(objFrom.getLista_nctabcriacmbio());
		        
		        objTo.setPilotoativo(EnumSimNaoStr.fromCode(objFrom.getLista_pilotoativo()));
		
		        lista.add(objTo);
		    }
		
		    return lista;
		    
	    }finally{
	        BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] ClienteModalServiceImpl.listar | CLIPORNOMEOUCNPJLIST ------- ");
	    }
	}
}
