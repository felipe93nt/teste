package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 21/01/16 11:22
 */
public class Beneficiariomodllistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwemerequest npcdwemerequest = null;
	
	public void setNpcdwemerequest(Npcdwemerequest npcdwemerequest) {
		this.npcdwemerequest = npcdwemerequest;
	}


	public Npcdwemerequest getNpcdwemerequest() {
		return npcdwemerequest;
	}
    
}