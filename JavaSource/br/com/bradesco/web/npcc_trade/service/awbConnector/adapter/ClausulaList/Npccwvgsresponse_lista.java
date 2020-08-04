package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 07/12/15 17:42
 */
public class Npccwvgsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVGS-REGISTRO.NPCCWVGS-LISTA.NPCCWVGS-CCLAUS-CONTR-CMBIO")
	private Integer lista_cclauscontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVGS-REGISTRO.NPCCWVGS-LISTA.NPCCWVGS-RCLAUS-CONTR-CMBIO")
	private String lista_rclauscontrcmbio = null;
	
	public Integer getLista_cclauscontrcmbio() {
		return lista_cclauscontrcmbio;
	}
	public void setLista_cclauscontrcmbio(Integer lista_cclauscontrcmbio) {
		this.lista_cclauscontrcmbio = lista_cclauscontrcmbio;
	}

	public String getLista_rclauscontrcmbio() {
		return lista_rclauscontrcmbio;
	}
	public void setLista_rclauscontrcmbio(String lista_rclauscontrcmbio) {
		this.lista_rclauscontrcmbio = lista_rclauscontrcmbio;
	}
    
}