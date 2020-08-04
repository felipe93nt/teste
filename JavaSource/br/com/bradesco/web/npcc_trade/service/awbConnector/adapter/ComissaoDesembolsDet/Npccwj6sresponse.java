package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.math.BigDecimal;

/**
 * Arquivo gerado automaticamente em 20/11/18 16:58
 */
public class Npccwj6sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ6S-HEADER.NPCCWJ6S-COD-LAYOUT")
	private String codlayout = "NPCCWJ6S";

	@Adapter(transactionField = "NPCCWJ6S-HEADER.NPCCWJ6S-TAM-LAYOUT")
	private Integer tamlayout = 164;

	@Adapter(transactionField = "NPCCWJ6S-REGISTRO.NPCCWJ6S-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJ6S-REGISTRO.NPCCWJ6S-MOEDA-DESC")
	private String moedadesc = null;

	@Adapter(transactionField = "NPCCWJ6S-REGISTRO.NPCCWJ6S-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWJ6S-REGISTRO.NPCCWJ6S-PRODT-DESC")
	private String prodtdesc = null;

	@Adapter(transactionField = "NPCCWJ6S-REGISTRO.NPCCWJ6S-VLIM-COMIS-FIXA")
	private BigDecimal vlimcomisfixa = null;

	@Adapter(transactionField = "NPCCWJ6S-REGISTRO.NPCCWJ6S-VCOMIS-FIXA")
	private BigDecimal vcomisfixa = null;
	
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

	public BigDecimal getVlimcomisfixa() {
		return vlimcomisfixa;
	}
	public void setVlimcomisfixa(BigDecimal vlimcomisfixa) {
		this.vlimcomisfixa = vlimcomisfixa;
	}

	public BigDecimal getVcomisfixa() {
		return vcomisfixa;
	}
	public void setVcomisfixa(BigDecimal vcomisfixa) {
		this.vcomisfixa = vcomisfixa;
	}
    
}