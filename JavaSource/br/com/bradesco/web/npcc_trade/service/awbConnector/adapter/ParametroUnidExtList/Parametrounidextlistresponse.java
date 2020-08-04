package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/10/18 17:22
 */
public class Parametrounidextlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwj2sresponse npccwj2sresponse = null;
	
	public void setNpccwj2sresponse(Npccwj2sresponse npccwj2sresponse) {
		this.npccwj2sresponse = npccwj2sresponse;
	}


	public Npccwj2sresponse getNpccwj2sresponse() {
		return npccwj2sresponse;
	}
    
}