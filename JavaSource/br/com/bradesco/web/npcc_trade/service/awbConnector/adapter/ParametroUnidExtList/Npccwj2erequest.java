package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/10/18 17:22
 */
public class Npccwj2erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ2E-HEADER.NPCCWJ2E-COD-LAYOUT")
	private String codlayout = "NPCCWJ2E";

	@Adapter(transactionField = "NPCCWJ2E-HEADER.NPCCWJ2E-TAM-LAYOUT")
	private Integer tamlayout = 26;

	@Adapter(transactionField = "NPCCWJ2E-REGISTRO.NPCCWJ2E-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJ2E-REGISTRO.NPCCWJ2E-CPRODT-SERVC")
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

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}
    
}