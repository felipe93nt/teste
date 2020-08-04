package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 08/11/16 15:05
 */
public class Npccwv6sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV6S-HEADER.NPCCWV6S-COD-LAYOUT")
	private String codlayout = "NPCCWV6S";

	@Adapter(transactionField = "NPCCWV6S-HEADER.NPCCWV6S-TAM-LAYOUT")
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