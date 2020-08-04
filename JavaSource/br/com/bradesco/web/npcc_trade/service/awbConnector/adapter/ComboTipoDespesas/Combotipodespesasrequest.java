package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 14:03
 */
public class Combotipodespesasrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwigerequest npccwigerequest = null;
	
	public void setNpccwigerequest(Npccwigerequest npccwigerequest) {
		this.npccwigerequest = npccwigerequest;
	}


	public Npccwigerequest getNpccwigerequest() {
		return npccwigerequest;
	}
    
}