package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 25/04/18 10:06
 */
public class Npccww0erequest_lstrbt extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-LST-RBT.NPCCWW0E-REBATE")
	private String lstrbt_rebate = null;
	
	public String getLstrbt_rebate() {
		return lstrbt_rebate;
	}
	public void setLstrbt_rebate(String lstrbt_rebate) {
		this.lstrbt_rebate = lstrbt_rebate;
	}
    
}