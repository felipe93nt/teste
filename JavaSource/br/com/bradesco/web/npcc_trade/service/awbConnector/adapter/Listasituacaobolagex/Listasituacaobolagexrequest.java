package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/05/16 14:07
 */
public class Listasituacaobolagexrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwnzerequest npccwnzerequest = null;
	
	public void setNpccwnzerequest(Npccwnzerequest npccwnzerequest) {
		this.npccwnzerequest = npccwnzerequest;
	}


	public Npccwnzerequest getNpccwnzerequest() {
		return npccwnzerequest;
	}
    
}