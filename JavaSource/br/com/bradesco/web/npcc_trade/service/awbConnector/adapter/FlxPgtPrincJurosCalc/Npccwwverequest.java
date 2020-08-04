package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/10/19 13:20
 */
public class Npccwwverequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWVE-HEADER.NPCCWWVE-COD-LAYOUT")
	private String codlayout = "NPCCWWVE";

	@Adapter(transactionField = "NPCCWWVE-HEADER.NPCCWWVE-TAM-LAYOUT")
	private Integer tamlayout = 72;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-VPREVT-DSEMB-CMBIO")
	private String vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-TDIA-CAREN-PRINC")
	private Integer tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-CINDCD-PCOBR-PRINC")
	private Integer cindcdpcobrprinc = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-TDIA-CAREN-JURO")
	private Integer tdiacarenjuro = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-CINDCD-PCOBR-JUROS")
	private Integer cindcdpcobrjuros = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-CINDCD-FCOBR-COTAC")
	private Integer cindcdfcobrcotac = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-CPAIS-MOEDA-DSEMB")
	private Integer cpaismoedadsemb = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-CINDCD-ECONMC")
	private Integer cindcdeconmc = 0;

	@Adapter(transactionField = "NPCCWWVE-REGISTRO.NPCCWWVE-PRZ-OPER-AJUSTADO")
	private String przoperajustado = null;
	
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

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}
	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}

	public Integer getTdiacarenprinc() {
		return tdiacarenprinc;
	}
	public void setTdiacarenprinc(Integer tdiacarenprinc) {
		this.tdiacarenprinc = tdiacarenprinc;
	}

	public Integer getCindcdpcobrprinc() {
		return cindcdpcobrprinc;
	}
	public void setCindcdpcobrprinc(Integer cindcdpcobrprinc) {
		this.cindcdpcobrprinc = cindcdpcobrprinc;
	}

	public Integer getTdiacarenjuro() {
		return tdiacarenjuro;
	}
	public void setTdiacarenjuro(Integer tdiacarenjuro) {
		this.tdiacarenjuro = tdiacarenjuro;
	}

	public Integer getCindcdpcobrjuros() {
		return cindcdpcobrjuros;
	}
	public void setCindcdpcobrjuros(Integer cindcdpcobrjuros) {
		this.cindcdpcobrjuros = cindcdpcobrjuros;
	}

	public Integer getCindcdfcobrcotac() {
		return cindcdfcobrcotac;
	}
	public void setCindcdfcobrcotac(Integer cindcdfcobrcotac) {
		this.cindcdfcobrcotac = cindcdfcobrcotac;
	}

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public Integer getCpaismoedadsemb() {
		return cpaismoedadsemb;
	}
	public void setCpaismoedadsemb(Integer cpaismoedadsemb) {
		this.cpaismoedadsemb = cpaismoedadsemb;
	}

	public Integer getCindcdeconmc() {
		return cindcdeconmc;
	}
	public void setCindcdeconmc(Integer cindcdeconmc) {
		this.cindcdeconmc = cindcdeconmc;
	}

	public String getPrzoperajustado() {
		return przoperajustado;
	}
	public void setPrzoperajustado(String przoperajustado) {
		this.przoperajustado = przoperajustado;
	}
    
}