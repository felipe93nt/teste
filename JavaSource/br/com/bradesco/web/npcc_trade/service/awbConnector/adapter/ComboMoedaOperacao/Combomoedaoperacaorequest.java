package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 17/12/15 15:08
 */
public class Combomoedaoperacaorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwh6erequest npccwh6erequest = null;
	
	public void setNpccwh6erequest(Npccwh6erequest npccwh6erequest) {
		this.npccwh6erequest = npccwh6erequest;
	}


	public Npccwh6erequest getNpccwh6erequest() {
		return npccwh6erequest;
	}
    
}