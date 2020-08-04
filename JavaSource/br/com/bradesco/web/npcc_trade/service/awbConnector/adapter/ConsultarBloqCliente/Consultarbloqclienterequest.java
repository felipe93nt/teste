package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarBloqCliente;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/07/16 15:39
 */
public class Consultarbloqclienterequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwmperequest npccwmperequest = null;
	
	public void setNpccwmperequest(Npccwmperequest npccwmperequest) {
		this.npccwmperequest = npccwmperequest;
	}


	public Npccwmperequest getNpccwmperequest() {
		return npccwmperequest;
	}
    
}