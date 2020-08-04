package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/09/16 16:13
 */
public class Comboperiodicidaderequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwuerequest npccwwuerequest = null;
	
	public void setNpccwwuerequest(Npccwwuerequest npccwwuerequest) {
		this.npccwwuerequest = npccwwuerequest;
	}


	public Npccwwuerequest getNpccwwuerequest() {
		return npccwwuerequest;
	}
    
}