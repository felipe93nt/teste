package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 25/04/18 09:19
 */
public class Npccwxasresponse_lstrbt extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-LST-RBT.NPCCWXAS-REBATE")
	private String lstrbt_rebate = null;
	
	public String getLstrbt_rebate() {
		return lstrbt_rebate;
	}
	public void setLstrbt_rebate(String lstrbt_rebate) {
		this.lstrbt_rebate = lstrbt_rebate;
	}
    
}