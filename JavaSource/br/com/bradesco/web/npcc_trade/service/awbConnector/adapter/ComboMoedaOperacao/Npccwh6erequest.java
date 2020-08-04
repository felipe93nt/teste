package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 17/12/15 15:08
 */
public class Npccwh6erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWH6E-HEADER.NPCCWH6E-COD-LAYOUT")
	private String codlayout = "NPCCWH6E";

	@Adapter(transactionField = "NPCCWH6E-HEADER.NPCCWH6E-TAM-LAYOUT")
	private Integer tamlayout = 26;

	@Adapter(transactionField = "NPCCWH6E-REGISTRO.NPCCWH6E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWH6E-REGISTRO.NPCCWH6E-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;
	
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

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}
    
}