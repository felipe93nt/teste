package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarComplGarantia;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 12/12/16 15:24
 */
public class Alterarcomplgarantiarequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwjerequest npccwwjerequest = null;
	
	public void setNpccwwjerequest(Npccwwjerequest npccwwjerequest) {
		this.npccwwjerequest = npccwwjerequest;
	}


	public Npccwwjerequest getNpccwwjerequest() {
		return npccwwjerequest;
	}
    
}