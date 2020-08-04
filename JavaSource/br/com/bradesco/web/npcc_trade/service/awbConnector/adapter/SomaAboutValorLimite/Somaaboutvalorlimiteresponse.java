package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SomaAboutValorLimite;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/02/17 13:48
 */
public class Somaaboutvalorlimiteresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww8sresponse npccww8sresponse = null;
	
	public void setNpccww8sresponse(Npccww8sresponse npccww8sresponse) {
		this.npccww8sresponse = npccww8sresponse;
	}


	public Npccww8sresponse getNpccww8sresponse() {
		return npccww8sresponse;
	}
    
}