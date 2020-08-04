package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/12/15 15:27
 */
public class Npccwvtsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVTS-REGISTRO.NPCCWVTS-LISTA.NPCCWVTS-CMOD-CONTR-CMBIO")
	private Integer lista_cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVTS-REGISTRO.NPCCWVTS-LISTA.NPCCWVTS-IMOD-CONTR-CMBIO")
	private String lista_imodcontrcmbio = null;
	
	public Integer getLista_cmodcontrcmbio() {
		return lista_cmodcontrcmbio;
	}
	public void setLista_cmodcontrcmbio(Integer lista_cmodcontrcmbio) {
		this.lista_cmodcontrcmbio = lista_cmodcontrcmbio;
	}

	public String getLista_imodcontrcmbio() {
		return lista_imodcontrcmbio;
	}
	public void setLista_imodcontrcmbio(String lista_imodcontrcmbio) {
		this.lista_imodcontrcmbio = lista_imodcontrcmbio;
	}
    
}