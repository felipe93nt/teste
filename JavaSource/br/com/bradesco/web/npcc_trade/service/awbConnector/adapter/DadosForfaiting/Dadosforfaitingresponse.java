package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/11/17 10:30
 */
public class Dadosforfaitingresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwx4sresponse npccwx4sresponse = null;
	
	public void setNpccwx4sresponse(Npccwx4sresponse npccwx4sresponse) {
		this.npccwx4sresponse = npccwx4sresponse;
	}


	public Npccwx4sresponse getNpccwx4sresponse() {
		return npccwx4sresponse;
	}
    
}