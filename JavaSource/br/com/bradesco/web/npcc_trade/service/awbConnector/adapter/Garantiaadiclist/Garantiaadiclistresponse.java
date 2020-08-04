package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/04/18 11:48
 */
public class Garantiaadiclistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwdgsresponse npccwdgsresponse = null;
	
	public void setNpccwdgsresponse(Npccwdgsresponse npccwdgsresponse) {
		this.npccwdgsresponse = npccwdgsresponse;
	}


	public Npccwdgsresponse getNpccwdgsresponse() {
		return npccwdgsresponse;
	}
    
}