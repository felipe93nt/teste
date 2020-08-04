package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 13:29
 */
public class Fndrgrtvnctrfobsinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwynsresponse npccwynsresponse = null;
	
	public void setNpccwynsresponse(Npccwynsresponse npccwynsresponse) {
		this.npccwynsresponse = npccwynsresponse;
	}


	public Npccwynsresponse getNpccwynsresponse() {
		return npccwynsresponse;
	}
    
}