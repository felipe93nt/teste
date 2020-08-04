package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 13:31
 */
public class Finimpdiretoinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv3sresponse npccwv3sresponse = null;
	
	public void setNpccwv3sresponse(Npccwv3sresponse npccwv3sresponse) {
		this.npccwv3sresponse = npccwv3sresponse;
	}


	public Npccwv3sresponse getNpccwv3sresponse() {
		return npccwv3sresponse;
	}
    
}