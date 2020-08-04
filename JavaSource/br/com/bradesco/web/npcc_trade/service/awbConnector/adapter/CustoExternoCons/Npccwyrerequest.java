package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoExternoCons;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/04/16 12:32
 */
public class Npccwyrerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYRE-HEADER.NPCCWYRE-COD-LAYOUT")
	private String codlayout = "NPCCWYRE";

	@Adapter(transactionField = "NPCCWYRE-HEADER.NPCCWYRE-TAM-LAYOUT")
	private Integer tamlayout = 31;

	@Adapter(transactionField = "NPCCWYRE-REGISTRO.NPCCWYRE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWYRE-REGISTRO.NPCCWYRE-PRZO-MEDIO-DSEMB")
	private Integer przomediodsemb = 0;

	@Adapter(transactionField = "NPCCWYRE-REGISTRO.NPCCWYRE-CPRODT-SERVC")
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

	public Integer getPrzomediodsemb() {
		return przomediodsemb;
	}
	public void setPrzomediodsemb(Integer przomediodsemb) {
		this.przomediodsemb = przomediodsemb;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}
    
}