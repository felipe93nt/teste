package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/03/17 13:31
 */
public class Garantiaavalmtcredresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwk8sresponse npccwk8sresponse = null;
	
	public void setNpccwk8sresponse(Npccwk8sresponse npccwk8sresponse) {
		this.npccwk8sresponse = npccwk8sresponse;
	}


	public Npccwk8sresponse getNpccwk8sresponse() {
		return npccwk8sresponse;
	}
    
}