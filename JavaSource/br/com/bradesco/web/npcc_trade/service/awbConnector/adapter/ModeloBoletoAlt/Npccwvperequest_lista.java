package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/06/18 13:32
 */
public class Npccwvperequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVPE-REGISTRO.NPCCWVPE-LISTA.NPCCWVPE-CCLAUS-CONTR-CMBIO")
	private Integer lista_cclauscontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVPE-REGISTRO.NPCCWVPE-LISTA.NPCCWVPE-NORD-MOD-CMBIO")
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