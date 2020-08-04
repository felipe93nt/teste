package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/08/18 16:26
 */
public class Descritivotarifalistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwatsresponse npccwatsresponse = null;
	
	public void setNpccwatsresponse(Npccwatsresponse npccwatsresponse) {
		this.npccwatsresponse = npccwatsresponse;
	}


	public Npccwatsresponse getNpccwatsresponse() {
		return npccwatsresponse;
	}
    
}