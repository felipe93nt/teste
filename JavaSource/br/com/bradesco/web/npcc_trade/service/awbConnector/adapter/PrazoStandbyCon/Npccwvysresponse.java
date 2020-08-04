package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyCon;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/12/15 09:36
 */
public class Npccwvysresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVYS-HEADER.NPCCWVYS-COD-LAYOUT")
	private String codlayout = "NPCCWVYS";

	@Adapter(transactionField = "NPCCWVYS-HEADER.NPCCWVYS-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVYS-REGISTRO.NPCCWVYS-TDIA-MAX-CREDT")
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