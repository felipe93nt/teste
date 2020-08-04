package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/03/16 18:33
 */
public class Propostapontuallistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwmherequest npccwmherequest = null;
	
	public void setNpccwmherequest(Npccwmherequest npccwmherequest) {
		this.npccwmherequest = npccwmherequest;
	}


	public Npccwmherequest getNpccwmherequest() {
		return npccwmherequest;
	}
    
}