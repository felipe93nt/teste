package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/09/16 16:13
 */
public class Npccwwuerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWUE-HEADER.NPCCWWUE-COD-LAYOUT")
	private String codlayout = "NPCCWWUE";

	@Adapter(transactionField = "NPCCWWUE-HEADER.NPCCWWUE-TAM-LAYOUT")
	private Integer tamlayout = 15;

	@Adapter(transactionField = "NPCCWWUE-REGISTRO.NPCCWWUE-CFLUXO-PERDC-CMBIO")
	private Integer cfluxoperdccmbio = 0;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}
	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}
    
}