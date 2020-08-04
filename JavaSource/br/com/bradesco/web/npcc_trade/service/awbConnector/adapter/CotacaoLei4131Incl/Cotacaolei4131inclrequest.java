package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Incl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 11:40
 */
public class Cotacaolei4131inclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv0erequest npccwv0erequest = null;
	
	public void setNpccwv0erequest(Npccwv0erequest npccwv0erequest) {
		this.npccwv0erequest = npccwv0erequest;
	}


	public Npccwv0erequest getNpccwv0erequest() {
		return npccwv0erequest;
	}
    
}