package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 01/12/16 15:20
 */
public class Consultalogagexlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwn7sresponse npccwn7sresponse = null;
	
	public void setNpccwn7sresponse(Npccwn7sresponse npccwn7sresponse) {
		this.npccwn7sresponse = npccwn7sresponse;
	}


	public Npccwn7sresponse getNpccwn7sresponse() {
		return npccwn7sresponse;
	}
    
}