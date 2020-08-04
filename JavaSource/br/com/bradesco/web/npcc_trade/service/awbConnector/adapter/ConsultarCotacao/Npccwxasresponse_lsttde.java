package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 25/04/18 09:19
 */
public class Npccwxasresponse_lsttde extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-LST-TDE.NPCCWXAS-TXADES")
	private String lsttde_txades = null;
	
	public String getLsttde_txades() {
		return lsttde_txades;
	}
	public void setLsttde_txades(String lsttde_txades) {
		this.lsttde_txades = lsttde_txades;
	}
    
}