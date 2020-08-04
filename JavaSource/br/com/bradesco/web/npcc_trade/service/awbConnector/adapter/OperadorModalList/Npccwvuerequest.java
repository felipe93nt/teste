package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 03/03/20 15:27
 */
public class Npccwvuerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVUE-HEADER.NPCCWVUE-COD-LAYOUT")
	private String codlayout = "NPCCWVUE";

	@Adapter(transactionField = "NPCCWVUE-HEADER.NPCCWVUE-TAM-LAYOUT")
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