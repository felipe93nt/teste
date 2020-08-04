package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/01/17 15:43
 */
public class Npccwvxsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVXS-HEADER.NPCCWVXS-COD-LAYOUT")
	private String codlayout = "NPCCWVXS";

	@Adapter(transactionField = "NPCCWVXS-HEADER.NPCCWVXS-TAM-LAYOUT")
	private Integer tamlayout = 14;

	@Adapter(transactionField = "NPCCWVXS-REGISTRO.NPCCWVXS-DATA-UTIL")
	private Integer datautil = 0;
	
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

	public Integer getDatautil() {
		return datautil;
	}
	public void setDatautil(Integer datautil) {
		this.datautil = datautil;
	}
    
}