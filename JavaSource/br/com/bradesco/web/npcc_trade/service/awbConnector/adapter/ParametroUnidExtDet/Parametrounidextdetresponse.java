package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/10/18 18:45
 */
public class Parametrounidextdetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwj3sresponse npccwj3sresponse = null;
	
	public void setNpccwj3sresponse(Npccwj3sresponse npccwj3sresponse) {
		this.npccwj3sresponse = npccwj3sresponse;
	}


	public Npccwj3sresponse getNpccwj3sresponse() {
		return npccwj3sresponse;
	}
    
}