package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Alt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 27/07/18 12:35
 */
public class Dadosbasegp1gp3altrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwberequest npccwwberequest = null;
	
	public void setNpccwwberequest(Npccwwberequest npccwwberequest) {
		this.npccwwberequest = npccwwberequest;
	}


	public Npccwwberequest getNpccwwberequest() {
		return npccwwberequest;
	}
    
}