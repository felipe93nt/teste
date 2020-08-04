package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarComplGarantia;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 12/12/16 15:24
 */
public class Npccwwjsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWJS-HEADER.NPCCWWJS-COD-LAYOUT")
	private String codlayout = "NPCCWWJS";

	@Adapter(transactionField = "NPCCWWJS-HEADER.NPCCWWJS-TAM-LAYOUT")
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