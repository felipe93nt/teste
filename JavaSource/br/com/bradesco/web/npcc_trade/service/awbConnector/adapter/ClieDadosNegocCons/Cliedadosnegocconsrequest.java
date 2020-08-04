package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClieDadosNegocCons;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:55
 */
public class Cliedadosnegocconsrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxberequest npccwxberequest = null;
	
	public void setNpccwxberequest(Npccwxberequest npccwxberequest) {
		this.npccwxberequest = npccwxberequest;
	}


	public Npccwxberequest getNpccwxberequest() {
		return npccwxberequest;
	}
    
}