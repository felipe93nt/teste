package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/09/16 10:19
 */
public class Consbeneficafiancadoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzmsresponse npccwzmsresponse = null;
	
	public void setNpccwzmsresponse(Npccwzmsresponse npccwzmsresponse) {
		this.npccwzmsresponse = npccwzmsresponse;
	}


	public Npccwzmsresponse getNpccwzmsresponse() {
		return npccwzmsresponse;
	}
    
}