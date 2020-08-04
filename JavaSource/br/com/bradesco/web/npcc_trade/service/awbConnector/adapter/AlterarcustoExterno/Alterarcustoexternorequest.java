package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarcustoExterno;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/03/17 11:39
 */
public class Alterarcustoexternorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwygerequest npccwygerequest = null;
	
	public void setNpccwygerequest(Npccwygerequest npccwygerequest) {
		this.npccwygerequest = npccwygerequest;
	}


	public Npccwygerequest getNpccwygerequest() {
		return npccwygerequest;
	}
    
}