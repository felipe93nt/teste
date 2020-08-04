package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 08/06/16 17:23
 */
public class Npccwicsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWICS-REGISTRO.NPCCWICS-LISTA.NPCCWICS-CMODLD-PRODT-CMBIO")
	private Integer lista_cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWICS-REGISTRO.NPCCWICS-LISTA.NPCCWICS-CSGL-MODLD-CMBIO")
	private String lista_csglmodldcmbio = null;

	@Adapter(transactionField = "NPCCWICS-REGISTRO.NPCCWICS-LISTA.NPCCWICS-IMODLD-PRODT-CMBIO")
	private String lista_imodldprodtcmbio = null;
	
	public Integer getLista_cmodldprodtcmbio() {
		return lista_cmodldprodtcmbio;
	}
	public void setLista_cmodldprodtcmbio(Integer lista_cmodldprodtcmbio) {
		this.lista_cmodldprodtcmbio = lista_cmodldprodtcmbio;
	}

	public String getLista_csglmodldcmbio() {
		return lista_csglmodldcmbio;
	}
	public void setLista_csglmodldcmbio(String lista_csglmodldcmbio) {
		this.lista_csglmodldcmbio = lista_csglmodldcmbio;
	}

	public String getLista_imodldprodtcmbio() {
		return lista_imodldprodtcmbio;
	}
	public void setLista_imodldprodtcmbio(String lista_imodldprodtcmbio) {
		this.lista_imodldprodtcmbio = lista_imodldprodtcmbio;
	}
    
}