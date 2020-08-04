package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 03/04/17 15:21
 */
public class Npccwznerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZNE-HEADER.NPCCWZNE-COD-LAYOUT")
	private String codlayout = "NPCCWZNE";

	@Adapter(transactionField = "NPCCWZNE-HEADER.NPCCWZNE-TAM-LAYOUT")
	private Integer tamlayout = 76;

	@Adapter(transactionField = "NPCCWZNE-REGISTRO.NPCCWZNE-DPREVT-DSEMB-I")
	private String dprevtdsembi = null;

	@Adapter(transactionField = "NPCCWZNE-REGISTRO.NPCCWZNE-DPREVT-DSEMB-F")
	private String dprevtdsembf = null;

	@Adapter(transactionField = "NPCCWZNE-REGISTRO.NPCCWZNE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWZNE-REGISTRO.NPCCWZNE-VPREVT-DSEMB-I")
	private Double vprevtdsembi = 0D;

	@Adapter(transactionField = "NPCCWZNE-REGISTRO.NPCCWZNE-VPREVT-DSEMB-F")
	private Double vprevtdsembf = 0D;

	@Adapter(transactionField = "NPCCWZNE-REGISTRO.NPCCWZNE-COD-SITUACAO")
	private Integer codsituacao = 0;
	
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

	public Integer getCodsituacao() {
		return codsituacao;
	}
	public void setCodsituacao(Integer codsituacao) {
		this.codsituacao = codsituacao;
	}
    
}