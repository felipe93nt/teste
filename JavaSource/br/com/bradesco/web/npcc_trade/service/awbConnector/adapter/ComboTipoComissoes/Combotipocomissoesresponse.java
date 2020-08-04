package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 30/06/16 17:47
 */
public class Combotipocomissoesresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwssresponse npccwwssresponse = null;
	
	public void setNpccwwssresponse(Npccwwssresponse npccwwssresponse) {
		this.npccwwssresponse = npccwwssresponse;
	}


	public Npccwwssresponse getNpccwwssresponse() {
		return npccwwssresponse;
	}
    
}