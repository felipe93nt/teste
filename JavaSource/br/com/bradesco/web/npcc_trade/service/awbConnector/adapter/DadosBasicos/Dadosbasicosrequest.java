package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 31/07/18 09:11
 */
public class Dadosbasicosrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwx1erequest npccwx1erequest = null;
	
	public void setNpccwx1erequest(Npccwx1erequest npccwx1erequest) {
		this.npccwx1erequest = npccwx1erequest;
	}


	public Npccwx1erequest getNpccwx1erequest() {
		return npccwx1erequest;
	}
    
}