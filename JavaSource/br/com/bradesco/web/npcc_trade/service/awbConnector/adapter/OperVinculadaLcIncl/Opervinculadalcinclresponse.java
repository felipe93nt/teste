package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperVinculadaLcIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/11/16 15:10
 */
public class Opervinculadalcinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww7sresponse npccww7sresponse = null;
	
	public void setNpccww7sresponse(Npccww7sresponse npccww7sresponse) {
		this.npccww7sresponse = npccww7sresponse;
	}


	public Npccww7sresponse getNpccww7sresponse() {
		return npccww7sresponse;
	}
    
}