package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/07/18 11:13
 */
public class Modeloboletodetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvosresponse npccwvosresponse = null;
	
	public void setNpccwvosresponse(Npccwvosresponse npccwvosresponse) {
		this.npccwvosresponse = npccwvosresponse;
	}


	public Npccwvosresponse getNpccwvosresponse() {
		return npccwvosresponse;
	}
    
}