package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/12/16 11:33
 */
public class Responsaveldespesasrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyaerequest npccwyaerequest = null;
	
	public void setNpccwyaerequest(Npccwyaerequest npccwyaerequest) {
		this.npccwyaerequest = npccwyaerequest;
	}


	public Npccwyaerequest getNpccwyaerequest() {
		return npccwyaerequest;
	}
    
}