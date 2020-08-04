package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperVinculadaLcIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/11/16 15:10
 */
public class Npccww7sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW7S-HEADER.NPCCWW7S-COD-LAYOUT")
	private String codlayout = "NPCCWW7S";

	@Adapter(transactionField = "NPCCWW7S-HEADER.NPCCWW7S-TAM-LAYOUT")
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