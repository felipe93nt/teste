package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 30/11/16 11:32
 */
public class Validadataaprovdespresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww3sresponse npccww3sresponse = null;
	
	public void setNpccww3sresponse(Npccww3sresponse npccww3sresponse) {
		this.npccww3sresponse = npccww3sresponse;
	}


	public Npccww3sresponse getNpccww3sresponse() {
		return npccww3sresponse;
	}
    
}