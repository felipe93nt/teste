package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/01/17 15:43
 */
public class Npccwvxerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVXE-HEADER.NPCCWVXE-COD-LAYOUT")
	private String codlayout = "NPCCWVXE";

	@Adapter(transactionField = "NPCCWVXE-HEADER.NPCCWVXE-TAM-LAYOUT")
	private Integer tamlayout = 38;

	@Adapter(transactionField = "NPCCWVXE-REGISTRO.NPCCWVXE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWVXE-REGISTRO.NPCCWVXE-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "NPCCWVXE-REGISTRO.NPCCWVXE-TPO-DATA")
	private String tpodata = null;

	@Adapter(transactionField = "NPCCWVXE-REGISTRO.NPCCWVXE-CPAIS-DSEMB")
	private Integer cpaisdsemb = 0;

	@Adapter(transactionField = "NPCCWVXE-REGISTRO.NPCCWVXE-CPAIS-BENEF")
	private Integer cpaisbenef = 0;

	@Adapter(transactionField = "NPCCWVXE-REGISTRO.NPCCWVXE-CINDCD-ECONM-MOEDA")
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

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getTpodata() {
		return tpodata;
	}
	public void setTpodata(String tpodata) {
		this.tpodata = tpodata;
	}

	public Integer getCpaisdsemb() {
		return cpaisdsemb;
	}
	public void setCpaisdsemb(Integer cpaisdsemb) {
		this.cpaisdsemb = cpaisdsemb;
	}

	public Integer getCpaisbenef() {
		return cpaisbenef;
	}
	public void setCpaisbenef(Integer cpaisbenef) {
		this.cpaisbenef = cpaisbenef;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}
    
}