package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixaSaldoForfaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 11:32
 */
public class Baixasaldoforfaitingresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww6sresponse npccww6sresponse = null;
	
	public void setNpccww6sresponse(Npccww6sresponse npccww6sresponse) {
		this.npccww6sresponse = npccww6sresponse;
	}


	public Npccww6sresponse getNpccww6sresponse() {
		return npccww6sresponse;
	}
    
}