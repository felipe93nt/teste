package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 10:05
 */
public class Descritivotarifadetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwaoxresponse npccwaoxresponse = null;
	
	public void setNpccwaoxresponse(Npccwaoxresponse npccwaoxresponse) {
		this.npccwaoxresponse = npccwaoxresponse;
	}


	public Npccwaoxresponse getNpccwaoxresponse() {
		return npccwaoxresponse;
	}
    
}