package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaPiloto;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/05/17 16:44
 */
public class Consultapilotoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwcdsresponse npccwcdsresponse = null;
	
	public void setNpccwcdsresponse(Npccwcdsresponse npccwcdsresponse) {
		this.npccwcdsresponse = npccwcdsresponse;
	}


	public Npccwcdsresponse getNpccwcdsresponse() {
		return npccwcdsresponse;
	}
    
}