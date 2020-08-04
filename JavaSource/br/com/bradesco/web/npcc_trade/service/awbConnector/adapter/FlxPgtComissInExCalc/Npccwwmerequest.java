package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:06
 */
public class Npccwwmerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWME-HEADER.NPCCWWME-COD-LAYOUT")
	private String codlayout = "NPCCWWME";

	@Adapter(transactionField = "NPCCWWME-HEADER.NPCCWWME-TAM-LAYOUT")
	private Integer tamlayout = 116;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-VALOR-OPERACAO")
	private String valoroperacao = null;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-CPERDC-JURO-CMBIO")
	private Integer cperdcjurocmbio = 0;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-VPREVT-DSEMB-CMBIO")
	private String vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-VPREVT-COMIS-CMBIO")
	private String vprevtcomiscmbio = null;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-VMIN-COBR-COMIS")
	private String vmincobrcomis = null;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-CINDCD-PCOBR-COMIS")
	private Integer cindcdpcobrcomis = 0;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-CINDCD-FCOBR-COMIS")
	private Integer cindcdfcobrcomis = 0;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWWME-REGISTRO.NPCCWWME-CPAIS")
	private Integer cpais = 0;
	
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

	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}
	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}

	public String getValoroperacao() {
		return valoroperacao;
	}
	public void setValoroperacao(String valoroperacao) {
		this.valoroperacao = valoroperacao;
	}

	public String getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(String pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}

	public Integer getCperdcjurocmbio() {
		return cperdcjurocmbio;
	}
	public void setCperdcjurocmbio(Integer cperdcjurocmbio) {
		this.cperdcjurocmbio = cperdcjurocmbio;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}
	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}

	public String getVprevtcomiscmbio() {
		return vprevtcomiscmbio;
	}
	public void setVprevtcomiscmbio(String vprevtcomiscmbio) {
		this.vprevtcomiscmbio = vprevtcomiscmbio;
	}

	public String getVmincobrcomis() {
		return vmincobrcomis;
	}
	public void setVmincobrcomis(String vmincobrcomis) {
		this.vmincobrcomis = vmincobrcomis;
	}

	public Integer getCindcdpcobrcomis() {
		return cindcdpcobrcomis;
	}
	public void setCindcdpcobrcomis(Integer cindcdpcobrcomis) {
		this.cindcdpcobrcomis = cindcdpcobrcomis;
	}

	public Integer getCindcdfcobrcomis() {
		return cindcdfcobrcomis;
	}
	public void setCindcdfcobrcomis(Integer cindcdfcobrcomis) {
		this.cindcdfcobrcomis = cindcdfcobrcomis;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}
    
}