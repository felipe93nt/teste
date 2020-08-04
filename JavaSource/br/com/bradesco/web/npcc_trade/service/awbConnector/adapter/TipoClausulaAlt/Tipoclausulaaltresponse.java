package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/12/15 09:56
 */
public class Tipoclausulaaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvdsresponse npccwvdsresponse = null;
	
	public void setNpccwvdsresponse(Npccwvdsresponse npccwvdsresponse) {
		this.npccwvdsresponse = npccwvdsresponse;
	}


	public Npccwvdsresponse getNpccwvdsresponse() {
		return npccwvdsresponse;
	}
    
}