package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/05/16 17:35
 */
public class Combotomadorrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwterequest npccwwterequest = null;
	
	public void setNpccwwterequest(Npccwwterequest npccwwterequest) {
		this.npccwwterequest = npccwwterequest;
	}


	public Npccwwterequest getNpccwwterequest() {
		return npccwwterequest;
	}
    
}