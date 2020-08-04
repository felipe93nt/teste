package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 08/06/16 17:23
 */
public class Combomodalidaderesponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwicsresponse npccwicsresponse = null;
	
	public void setNpccwicsresponse(Npccwicsresponse npccwicsresponse) {
		this.npccwicsresponse = npccwicsresponse;
	}


	public Npccwicsresponse getNpccwicsresponse() {
		return npccwicsresponse;
	}
    
}