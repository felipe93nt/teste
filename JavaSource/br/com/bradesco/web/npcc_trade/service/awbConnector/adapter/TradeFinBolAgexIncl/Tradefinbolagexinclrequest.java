package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinBolAgexIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/12/16 16:39
 */
public class Tradefinbolagexinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwnyerequest npccwnyerequest = null;
	
	public void setNpccwnyerequest(Npccwnyerequest npccwnyerequest) {
		this.npccwnyerequest = npccwnyerequest;
	}


	public Npccwnyerequest getNpccwnyerequest() {
		return npccwnyerequest;
	}
    
}