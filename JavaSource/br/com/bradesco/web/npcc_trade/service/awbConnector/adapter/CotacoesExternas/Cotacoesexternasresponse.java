package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 31/10/17 12:30
 */
public class Cotacoesexternasresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwydsresponse npccwydsresponse = null;
	
	public void setNpccwydsresponse(Npccwydsresponse npccwydsresponse) {
		this.npccwydsresponse = npccwydsresponse;
	}


	public Npccwydsresponse getNpccwydsresponse() {
		return npccwydsresponse;
	}
    
}