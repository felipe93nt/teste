package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 08/06/16 17:23
 */
public class Npccwicerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWICE-HEADER.NPCCWICE-COD-LAYOUT")
	private String codlayout = "NPCCWICE";

	@Adapter(transactionField = "NPCCWICE-HEADER.NPCCWICE-TAM-LAYOUT")
	private Integer tamlayout = 21;

	@Adapter(transactionField = "NPCCWICE-REGISTRO.NPCCWICE-CPRODT-SERVC")
	private Integer cprodtservc = 0;
	
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

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}
    
}