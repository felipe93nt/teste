package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 25/04/18 10:06
 */
public class Npccww0erequest_lsttde extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-LST-TDE.NPCCWW0E-TXADES")
	private String lsttde_txades = null;
	
	public String getLsttde_txades() {
		return lsttde_txades;
	}
	public void setLsttde_txades(String lsttde_txades) {
		this.lsttde_txades = lsttde_txades;
	}
    
}