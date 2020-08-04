package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/03/16 17:03
 */
public class Npccwcrsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWCRS-REGISTRO.NPCCWCRS-LISTA.NPCCWCRS-CMOTVO-BLETO-CMBIO")
	private Integer lista_cmotvobletocmbio = 0;

	@Adapter(transactionField = "NPCCWCRS-REGISTRO.NPCCWCRS-LISTA.NPCCWCRS-RMOTVO-BLETO-CMBIO")
	private String lista_rmotvobletocmbio = null;
	
	public Integer getLista_cmotvobletocmbio() {
		return lista_cmotvobletocmbio;
	}
	public void setLista_cmotvobletocmbio(Integer lista_cmotvobletocmbio) {
		this.lista_cmotvobletocmbio = lista_cmotvobletocmbio;
	}

	public String getLista_rmotvobletocmbio() {
		return lista_rmotvobletocmbio;
	}
	public void setLista_rmotvobletocmbio(String lista_rmotvobletocmbio) {
		this.lista_rmotvobletocmbio = lista_rmotvobletocmbio;
	}
    
}