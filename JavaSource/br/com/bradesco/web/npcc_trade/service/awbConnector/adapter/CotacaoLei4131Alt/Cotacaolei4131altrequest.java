package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Alt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 14:52
 */
public class Cotacaolei4131altrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww9erequest npccww9erequest = null;
	
	public void setNpccww9erequest(Npccww9erequest npccww9erequest) {
		this.npccww9erequest = npccww9erequest;
	}


	public Npccww9erequest getNpccww9erequest() {
		return npccww9erequest;
	}
    
}