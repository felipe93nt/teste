package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/03/16 18:33
 */
public class Propostapontuallistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwmhsresponse npccwmhsresponse = null;
	
	public void setNpccwmhsresponse(Npccwmhsresponse npccwmhsresponse) {
		this.npccwmhsresponse = npccwmhsresponse;
	}


	public Npccwmhsresponse getNpccwmhsresponse() {
		return npccwmhsresponse;
	}
    
}