package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/09/16 10:15
 */
public class Comissaoforfaitingrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyoerequest npccwyoerequest = null;
	
	public void setNpccwyoerequest(Npccwyoerequest npccwyoerequest) {
		this.npccwyoerequest = npccwyoerequest;
	}


	public Npccwyoerequest getNpccwyoerequest() {
		return npccwyoerequest;
	}
    
}