package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/10/15 10:02
 */
public class Formaliquidacaolistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwaaerequest npcdwaaerequest = null;
	
	public void setNpcdwaaerequest(Npcdwaaerequest npcdwaaerequest) {
		this.npcdwaaerequest = npcdwaaerequest;
	}


	public Npcdwaaerequest getNpcdwaaerequest() {
		return npcdwaaerequest;
	}
    
}