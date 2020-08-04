package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/12/15 14:30
 */
public class Npccwvwerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVWE-HEADER.NPCCWVWE-COD-LAYOUT")
	private String codlayout = "NPCCWVWE";

	@Adapter(transactionField = "NPCCWVWE-HEADER.NPCCWVWE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVWE-REGISTRO.NPCCWVWE-TDIA-MAX-CREDT")
	private Integer tdiamaxcredt = 0;
	
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

	public Integer getTdiamaxcredt() {
		return tdiamaxcredt;
	}
	public void setTdiamaxcredt(Integer tdiamaxcredt) {
		this.tdiamaxcredt = tdiamaxcredt;
	}
    
}