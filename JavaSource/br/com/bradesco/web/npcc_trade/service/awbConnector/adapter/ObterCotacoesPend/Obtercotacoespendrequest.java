package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/08/16 12:50
 */
public class Obtercotacoespendrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyeerequest npccwyeerequest = null;
	
	public void setNpccwyeerequest(Npccwyeerequest npccwyeerequest) {
		this.npccwyeerequest = npccwyeerequest;
	}


	public Npccwyeerequest getNpccwyeerequest() {
		return npccwyeerequest;
	}
    
}