package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/10/16 10:41
 */
public class Parcelasdesembolsorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzferequest npccwzferequest = null;
	
	public void setNpccwzferequest(Npccwzferequest npccwzferequest) {
		this.npccwzferequest = npccwzferequest;
	}


	public Npccwzferequest getNpccwzferequest() {
		return npccwzferequest;
	}
    
}