package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarOperacoes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 17:40
 */
public class Npcdwnzerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWNZE-HEADER.NPCDWNZE-COD-LAYOUT")
	private String codlayout = "NPCDWNZE";

	@Adapter(transactionField = "NPCDWNZE-HEADER.NPCDWNZE-TAM-LAYOUT")
	private Integer tamlayout = 21;

	@Adapter(transactionField = "NPCDWNZE-REGISTRO.NPCDWNZE-CPRODT-SERVC")
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