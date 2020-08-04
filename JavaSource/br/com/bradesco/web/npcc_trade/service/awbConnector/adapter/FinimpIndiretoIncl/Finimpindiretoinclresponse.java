package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 10:25
 */
public class Finimpindiretoinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv4sresponse npccwv4sresponse = null;
	
	public void setNpccwv4sresponse(Npccwv4sresponse npccwv4sresponse) {
		this.npccwv4sresponse = npccwv4sresponse;
	}


	public Npccwv4sresponse getNpccwv4sresponse() {
		return npccwv4sresponse;
	}
    
}