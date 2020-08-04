package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarBloqCliente;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/07/16 15:39
 */
public class Consultarbloqclienteresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwmpsresponse npccwmpsresponse = null;
	
	public void setNpccwmpsresponse(Npccwmpsresponse npccwmpsresponse) {
		this.npccwmpsresponse = npccwmpsresponse;
	}


	public Npccwmpsresponse getNpccwmpsresponse() {
		return npccwmpsresponse;
	}
    
}