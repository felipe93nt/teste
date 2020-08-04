package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/12/15 15:27
 */
public class Npccwvterequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVTE-HEADER.NPCCWVTE-COD-LAYOUT")
	private String codlayout = "NPCCWVTE";

	@Adapter(transactionField = "NPCCWVTE-HEADER.NPCCWVTE-TAM-LAYOUT")
	private Integer tamlayout = 21;

	@Adapter(transactionField = "NPCCWVTE-REGISTRO.NPCCWVTE-CPRODT-SERV")
	private Integer cprodtserv = 0;
	
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

	public Integer getCprodtserv() {
		return cprodtserv;
	}
	public void setCprodtserv(Integer cprodtserv) {
		this.cprodtserv = cprodtserv;
	}
    
}