package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/09/16 12:52
 */
public class Operacoespendtotaisrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzoerequest npccwzoerequest = null;
	
	public void setNpccwzoerequest(Npccwzoerequest npccwzoerequest) {
		this.npccwzoerequest = npccwzoerequest;
	}


	public Npccwzoerequest getNpccwzoerequest() {
		return npccwzoerequest;
	}
    
}