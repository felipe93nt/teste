package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/09/16 10:15
 */
public class Comissaoforfaitingresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyosresponse npccwyosresponse = null;
	
	public void setNpccwyosresponse(Npccwyosresponse npccwyosresponse) {
		this.npccwyosresponse = npccwyosresponse;
	}


	public Npccwyosresponse getNpccwyosresponse() {
		return npccwyosresponse;
	}
    
}