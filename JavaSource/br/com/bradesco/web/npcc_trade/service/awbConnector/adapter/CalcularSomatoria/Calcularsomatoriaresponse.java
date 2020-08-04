package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcularSomatoria;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/06/16 15:09
 */
public class Calcularsomatoriaresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv8sresponse npccwv8sresponse = null;
	
	public void setNpccwv8sresponse(Npccwv8sresponse npccwv8sresponse) {
		this.npccwv8sresponse = npccwv8sresponse;
	}


	public Npccwv8sresponse getNpccwv8sresponse() {
		return npccwv8sresponse;
	}
    
}