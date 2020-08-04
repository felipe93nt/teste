package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/05/16 14:07
 */
public class Listasituacaobolagexresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwnzsresponse npccwnzsresponse = null;
	
	public void setNpccwnzsresponse(Npccwnzsresponse npccwnzsresponse) {
		this.npccwnzsresponse = npccwnzsresponse;
	}


	public Npccwnzsresponse getNpccwnzsresponse() {
		return npccwnzsresponse;
	}
    
}