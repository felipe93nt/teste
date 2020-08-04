package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/08/16 14:31
 */
public class Cotacoesfechadasrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzverequest npccwzverequest = null;
	
	public void setNpccwzverequest(Npccwzverequest npccwzverequest) {
		this.npccwzverequest = npccwzverequest;
	}


	public Npccwzverequest getNpccwzverequest() {
		return npccwzverequest;
	}
    
}