package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GerarBatchMonitor;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/05/17 15:56
 */
public class Gerarbatchmonitorresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwkwsresponse npccwkwsresponse = null;
	
	public void setNpccwkwsresponse(Npccwkwsresponse npccwkwsresponse) {
		this.npccwkwsresponse = npccwkwsresponse;
	}


	public Npccwkwsresponse getNpccwkwsresponse() {
		return npccwkwsresponse;
	}
    
}