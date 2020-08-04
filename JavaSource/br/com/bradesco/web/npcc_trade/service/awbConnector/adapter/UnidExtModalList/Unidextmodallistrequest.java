package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/04/16 08:46
 */
public class Unidextmodallistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwfgerequest npcdwfgerequest = null;
	
	public void setNpcdwfgerequest(Npcdwfgerequest npcdwfgerequest) {
		this.npcdwfgerequest = npcdwfgerequest;
	}


	public Npcdwfgerequest getNpcdwfgerequest() {
		return npcdwfgerequest;
	}
    
}