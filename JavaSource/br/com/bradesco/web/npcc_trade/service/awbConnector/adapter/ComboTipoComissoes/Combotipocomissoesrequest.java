package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 30/06/16 17:47
 */
public class Combotipocomissoesrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwserequest npccwwserequest = null;
	
	public void setNpccwwserequest(Npccwwserequest npccwwserequest) {
		this.npccwwserequest = npccwwserequest;
	}


	public Npccwwserequest getNpccwwserequest() {
		return npccwwserequest;
	}
    
}