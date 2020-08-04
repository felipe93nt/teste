package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 30/03/16 14:37
 */
public class Npccwiesresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIES-REGISTRO.NPCCWIES-LISTA.NPCCWIES-CTPO-DESP-CMBIO")
	private Integer lista_ctpodespcmbio = 0;

	@Adapter(transactionField = "NPCCWIES-REGISTRO.NPCCWIES-LISTA.NPCCWIES-DTPO-DESP-CMBIO")
	private String lista_dtpodespcmbio = null;

	@Adapter(transactionField = "NPCCWIES-REGISTRO.NPCCWIES-LISTA.NPCCWIES-IDENT-TRFA-DEPS")
	private String lista_identtrfadeps = null;
	
	public Integer getLista_ctpodespcmbio() {
		return lista_ctpodespcmbio;
	}
	public void setLista_ctpodespcmbio(Integer lista_ctpodespcmbio) {
		this.lista_ctpodespcmbio = lista_ctpodespcmbio;
	}

	public String getLista_dtpodespcmbio() {
		return lista_dtpodespcmbio;
	}
	public void setLista_dtpodespcmbio(String lista_dtpodespcmbio) {
		this.lista_dtpodespcmbio = lista_dtpodespcmbio;
	}

	public String getLista_identtrfadeps() {
		return lista_identtrfadeps;
	}
	public void setLista_identtrfadeps(String lista_identtrfadeps) {
		this.lista_identtrfadeps = lista_identtrfadeps;
	}
    
}