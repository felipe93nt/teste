package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PaisDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/07/16 10:46
 */
public class Npcdwayerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWAYE-HEADER.NPCDWAYE-COD-LAYOUT")
	private String codlayout = "NPCDWAYE";

	@Adapter(transactionField = "NPCDWAYE-HEADER.NPCDWAYE-TAM-LAYOUT")
	private Integer tamlayout = 16;

	@Adapter(transactionField = "NPCDWAYE-REGISTRO.NPCDWAYE-CPAIS")
	private Integer cpais = 0;
	
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

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}
    
}