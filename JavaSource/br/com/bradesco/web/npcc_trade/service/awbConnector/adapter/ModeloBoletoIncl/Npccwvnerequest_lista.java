package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/06/18 10:50
 */
public class Npccwvnerequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-LISTA.NPCCWVNE-CCLAUS-CONTR-CMBIO")
	private Integer lista_cclauscontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-LISTA.NPCCWVNE-NORD-MOD-CMBIO")
	private Integer lista_nordmodcmbio = 0;
	
	public Integer getLista_cclauscontrcmbio() {
		return lista_cclauscontrcmbio;
	}
	public void setLista_cclauscontrcmbio(Integer lista_cclauscontrcmbio) {
		this.lista_cclauscontrcmbio = lista_cclauscontrcmbio;
	}

	public Integer getLista_nordmodcmbio() {
		return lista_nordmodcmbio;
	}
	public void setLista_nordmodcmbio(Integer lista_nordmodcmbio) {
		this.lista_nordmodcmbio = lista_nordmodcmbio;
	}
    
}