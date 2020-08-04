package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/09/16 12:52
 */
public class Npccwzoerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZOE-HEADER.NPCCWZOE-COD-LAYOUT")
	private String codlayout = "NPCCWZOE";

	@Adapter(transactionField = "NPCCWZOE-HEADER.NPCCWZOE-TAM-LAYOUT")
	private Integer tamlayout = 76;

	@Adapter(transactionField = "NPCCWZOE-REGISTRO.NPCCWZOE-DPREVT-DSEMB-I")
	private String dprevtdsembi = null;

	@Adapter(transactionField = "NPCCWZOE-REGISTRO.NPCCWZOE-DPREVT-DSEMB-F")
	private String dprevtdsembf = null;

	@Adapter(transactionField = "NPCCWZOE-REGISTRO.NPCCWZOE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWZOE-REGISTRO.NPCCWZOE-VPREVT-DSEMB-I")
	private Double vprevtdsembi = 0D;

	@Adapter(transactionField = "NPCCWZOE-REGISTRO.NPCCWZOE-VPREVT-DSEMB-F")
	private Double vprevtdsembf = 0D;

	@Adapter(transactionField = "NPCCWZOE-REGISTRO.NPCCWZOE-FLAG-LISTA")
	private Integer flaglista = 0;
	
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

	public String getDprevtdsembi() {
		return dprevtdsembi;
	}
	public void setDprevtdsembi(String dprevtdsembi) {
		this.dprevtdsembi = dprevtdsembi;
	}

	public String getDprevtdsembf() {
		return dprevtdsembf;
	}
	public void setDprevtdsembf(String dprevtdsembf) {
		this.dprevtdsembf = dprevtdsembf;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Double getVprevtdsembi() {
		return vprevtdsembi;
	}
	public void setVprevtdsembi(Double vprevtdsembi) {
		this.vprevtdsembi = vprevtdsembi;
	}

	public Double getVprevtdsembf() {
		return vprevtdsembf;
	}
	public void setVprevtdsembf(Double vprevtdsembf) {
		this.vprevtdsembf = vprevtdsembf;
	}

	public Integer getFlaglista() {
		return flaglista;
	}
	public void setFlaglista(Integer flaglista) {
		this.flaglista = flaglista;
	}
    
}