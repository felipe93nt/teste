package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 10:29
 */
public class Combosegmentoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwh8sresponse npccwh8sresponse = null;
	
	public void setNpccwh8sresponse(Npccwh8sresponse npccwh8sresponse) {
		this.npccwh8sresponse = npccwh8sresponse;
	}


	public Npccwh8sresponse getNpccwh8sresponse() {
		return npccwh8sresponse;
	}
    
}