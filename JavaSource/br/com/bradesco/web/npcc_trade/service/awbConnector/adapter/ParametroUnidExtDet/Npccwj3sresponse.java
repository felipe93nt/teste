package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/10/18 18:45
 */
public class Npccwj3sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ3S-HEADER.NPCCWJ3S-COD-LAYOUT")
	private String codlayout = "NPCCWJ3S";

	@Adapter(transactionField = "NPCCWJ3S-HEADER.NPCCWJ3S-TAM-LAYOUT")
	private Integer tamlayout = 334;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-MOEDA-DESC")
	private String moedadesc = null;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-PRODT-DESC")
	private String prodtdesc = null;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-CIDTFD-FAIXA-OPER")
	private Integer cidtfdfaixaoper = 0;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-CBANQR-CMBIO")
	private Long cbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-BANQR-DESC")
	private String banqrdesc = null;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-BANQR-PRACA-DESC")
	private String banqrpracadesc = null;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-VLIM-APROV-CUSTO")
	private Double vlimaprovcusto = 0D;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-VLIM-INFER-BANQR")
	private Double vliminferbanqr = 0D;

	@Adapter(transactionField = "NPCCWJ3S-REGISTRO.NPCCWJ3S-VLIM-SUPE-BANQR")
	private Double vlimsupebanqr = 0D;
	
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

	public String getMoedadesc() {
		return moedadesc;
	}
	public void setMoedadesc(String moedadesc) {
		this.moedadesc = moedadesc;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getProdtdesc() {
		return prodtdesc;
	}
	public void setProdtdesc(String prodtdesc) {
		this.prodtdesc = prodtdesc;
	}

	public Integer getCidtfdfaixaoper() {
		return cidtfdfaixaoper;
	}
	public void setCidtfdfaixaoper(Integer cidtfdfaixaoper) {
		this.cidtfdfaixaoper = cidtfdfaixaoper;
	}

	public Long getCbanqrcmbio() {
		return cbanqrcmbio;
	}
	public void setCbanqrcmbio(Long cbanqrcmbio) {
		this.cbanqrcmbio = cbanqrcmbio;
	}

	public String getBanqrdesc() {
		return banqrdesc;
	}
	public void setBanqrdesc(String banqrdesc) {
		this.banqrdesc = banqrdesc;
	}

	public String getBanqrpracadesc() {
		return banqrpracadesc;
	}
	public void setBanqrpracadesc(String banqrpracadesc) {
		this.banqrpracadesc = banqrpracadesc;
	}

	public Double getVlimaprovcusto() {
		return vlimaprovcusto;
	}
	public void setVlimaprovcusto(Double vlimaprovcusto) {
		this.vlimaprovcusto = vlimaprovcusto;
	}

	public Double getVliminferbanqr() {
		return vliminferbanqr;
	}
	public void setVliminferbanqr(Double vliminferbanqr) {
		this.vliminferbanqr = vliminferbanqr;
	}

	public Double getVlimsupebanqr() {
		return vlimsupebanqr;
	}
	public void setVlimsupebanqr(Double vlimsupebanqr) {
		this.vlimsupebanqr = vlimsupebanqr;
	}
    
}