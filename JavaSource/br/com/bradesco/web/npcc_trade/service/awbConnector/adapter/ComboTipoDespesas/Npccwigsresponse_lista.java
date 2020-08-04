package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 14:03
 */
public class Npccwigsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIGS-REGISTRO.NPCCWIGS-LISTA.NPCCWIGS-DTPO-DESP-CMBIO")
	private String lista_dtpodespcmbio = null;

	@Adapter(transactionField = "NPCCWIGS-REGISTRO.NPCCWIGS-LISTA.NPCCWIGS-CTPO-DESP-CMBIO")
	private Integer lista_ctpodespcmbio = 0;

	@Adapter(transactionField = "NPCCWIGS-REGISTRO.NPCCWIGS-LISTA.NPCCWIGS-NTPO-SIT-CMBIO")
	private Integer lista_ntpositcmbio = 0;
	
	public String getLista_dtpodespcmbio() {
		return lista_dtpodespcmbio;
	}
	public void setLista_dtpodespcmbio(String lista_dtpodespcmbio) {
		this.lista_dtpodespcmbio = lista_dtpodespcmbio;
	}

	public Integer getLista_ctpodespcmbio() {
		return lista_ctpodespcmbio;
	}
	public void setLista_ctpodespcmbio(Integer lista_ctpodespcmbio) {
		this.lista_ctpodespcmbio = lista_ctpodespcmbio;
	}

	public Integer getLista_ntpositcmbio() {
		return lista_ntpositcmbio;
	}
	public void setLista_ntpositcmbio(Integer lista_ntpositcmbio) {
		this.lista_ntpositcmbio = lista_ntpositcmbio;
	}
    
}