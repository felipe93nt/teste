package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 17/05/16 09:26
 */
public class Desinclforfaitingresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwxsresponse npccwwxsresponse = null;
	
	public void setNpccwwxsresponse(Npccwwxsresponse npccwwxsresponse) {
		this.npccwwxsresponse = npccwwxsresponse;
	}


	public Npccwwxsresponse getNpccwwxsresponse() {
		return npccwwxsresponse;
	}
    
}