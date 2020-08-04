package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/08/16 16:41
 */
public class Obtertarifarequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwdjerequest npccwdjerequest = null;
	
	public void setNpccwdjerequest(Npccwdjerequest npccwdjerequest) {
		this.npccwdjerequest = npccwdjerequest;
	}


	public Npccwdjerequest getNpccwdjerequest() {
		return npccwdjerequest;
	}
    
}