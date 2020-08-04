package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Incl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;

/**
 * Arquivo gerado automaticamente em 27/07/18 10:39
 */
public class Dadosbasegp1gp3inclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv2sresponse npccwv2sresponse = null;
	
	public void setNpccwv2sresponse(Npccwv2sresponse npccwv2sresponse) {
		this.npccwv2sresponse = npccwv2sresponse;
	}


	public Npccwv2sresponse getNpccwv2sresponse() {
		return npccwv2sresponse;
	}
    
}