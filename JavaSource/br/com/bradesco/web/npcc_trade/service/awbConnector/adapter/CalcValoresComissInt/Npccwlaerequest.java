package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:10
 */
public class Npccwlaerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWLAE-HEADER.NPCCWLAE-COD-LAYOUT")
	private String codlayout = "NPCCWLAE";

	@Adapter(transactionField = "NPCCWLAE-HEADER.NPCCWLAE-TAM-LAYOUT")
	private Integer tamlayout = 7656;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-FUNCAO")
	private String funcao = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-VMIN-COBR-COMIS")
	private String vmincobrcomis = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-CCOBR-COMIS-INTRN")
	private Integer ccobrcomisintrn = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-VLX-OPERAC-CMBIO")
	private String vlxoperaccmbio = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-VPREVT-DSEMB-CMBIO")
	private String vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-VLX-COMIS-CMBIO")
	private String vlxcomiscmbio = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-CINDCD-PCOBR-JUROS")
	private Integer cindcdpcobrjuros = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-CINDCD-FCOBR-COTAC")
	private Integer cindcdfcobrcotac = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-QTDE-OCORR-PRINC")
	private Integer qtdeocorrprinc = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-QTDE-OCORR-JUROS")
	private Integer qtdeocorrjuros = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt.Npccwlaerequest_lista")
	private List<Npccwlaerequest_lista> lista = null;
	
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

	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
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

	public String getVmincobrcomis() {
		return vmincobrcomis;
	}
	public void setVmincobrcomis(String vmincobrcomis) {
		this.vmincobrcomis = vmincobrcomis;
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

	public Integer getCcobrcomisintrn() {
		return ccobrcomisintrn;
	}
	public void setCcobrcomisintrn(Integer ccobrcomisintrn) {
		this.ccobrcomisintrn = ccobrcomisintrn;
	}

	public String getVlxoperaccmbio() {
		return vlxoperaccmbio;
	}
	public void setVlxoperaccmbio(String vlxoperaccmbio) {
		this.vlxoperaccmbio = vlxoperaccmbio;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}
	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}

	public String getVlxcomiscmbio() {
		return vlxcomiscmbio;
	}
	public void setVlxcomiscmbio(String vlxcomiscmbio) {
		this.vlxcomiscmbio = vlxcomiscmbio;
	}

	public String getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(String pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
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

	public Integer getQtdeocorrprinc() {
		return qtdeocorrprinc;
	}
	public void setQtdeocorrprinc(Integer qtdeocorrprinc) {
		this.qtdeocorrprinc = qtdeocorrprinc;
	}

	public Integer getQtdeocorrjuros() {
		return qtdeocorrjuros;
	}
	public void setQtdeocorrjuros(Integer qtdeocorrjuros) {
		this.qtdeocorrjuros = qtdeocorrjuros;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwlaerequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwlaerequest_lista> lista) {
		this.lista = lista;
	}
    
}