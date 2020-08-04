package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 17:35
 */
public class Consultasdivisaointresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzlsresponse npccwzlsresponse = null;
	
	public void setNpccwzlsresponse(Npccwzlsresponse npccwzlsresponse) {
		this.npccwzlsresponse = npccwzlsresponse;
	}


	public Npccwzlsresponse getNpccwzlsresponse() {
		return npccwzlsresponse;
	}
    
}