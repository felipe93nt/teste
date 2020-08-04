package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/09/18 16:07
 */
public class Descritivotarifalogresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwaxsresponse npccwaxsresponse = null;
	
	public void setNpccwaxsresponse(Npccwaxsresponse npccwaxsresponse) {
		this.npccwaxsresponse = npccwaxsresponse;
	}


	public Npccwaxsresponse getNpccwaxsresponse() {
		return npccwaxsresponse;
	}
    
}