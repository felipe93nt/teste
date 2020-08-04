package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/05/16 12:41
 */
public class Combodatadesembolsorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwx7erequest npccwx7erequest = null;
	
	public void setNpccwx7erequest(Npccwx7erequest npccwx7erequest) {
		this.npccwx7erequest = npccwx7erequest;
	}


	public Npccwx7erequest getNpccwx7erequest() {
		return npccwx7erequest;
	}
    
}