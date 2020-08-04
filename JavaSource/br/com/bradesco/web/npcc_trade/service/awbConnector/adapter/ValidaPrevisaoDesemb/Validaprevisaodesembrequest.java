package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/01/17 15:43
 */
public class Validaprevisaodesembrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvxerequest npccwvxerequest = null;
	
	public void setNpccwvxerequest(Npccwvxerequest npccwvxerequest) {
		this.npccwvxerequest = npccwvxerequest;
	}


	public Npccwvxerequest getNpccwvxerequest() {
		return npccwvxerequest;
	}
    
}