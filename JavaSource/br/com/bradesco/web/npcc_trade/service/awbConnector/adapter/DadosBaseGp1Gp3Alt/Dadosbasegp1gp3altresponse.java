package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Alt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;

/**
 * Arquivo gerado automaticamente em 27/07/18 12:35
 */
public class Dadosbasegp1gp3altresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwbsresponse npccwwbsresponse = null;
	
	public void setNpccwwbsresponse(Npccwwbsresponse npccwwbsresponse) {
		this.npccwwbsresponse = npccwwbsresponse;
	}


	public Npccwwbsresponse getNpccwwbsresponse() {
		return npccwwbsresponse;
	}
    
}