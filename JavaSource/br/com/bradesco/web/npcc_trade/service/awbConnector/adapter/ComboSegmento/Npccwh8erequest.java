package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 10:29
 */
public class Npccwh8erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWH8E-HEADER.NPCCWH8E-COD-LAYOUT")
	private String codlayout = "NPCCWH8E";

	@Adapter(transactionField = "NPCCWH8E-HEADER.NPCCWH8E-TAM-LAYOUT")
	private Integer tamlayout = 13;
	
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
    
}