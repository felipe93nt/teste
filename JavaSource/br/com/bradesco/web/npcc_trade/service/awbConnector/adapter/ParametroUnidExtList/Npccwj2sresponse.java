package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 18/10/18 17:22
 */
public class Npccwj2sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ2S-HEADER.NPCCWJ2S-COD-LAYOUT")
	private String codlayout = "NPCCWJ2S";

	@Adapter(transactionField = "NPCCWJ2S-HEADER.NPCCWJ2S-TAM-LAYOUT")
	private Integer tamlayout = 6000;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-MOEDA-DESC")
	private String moedadesc = null;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-PRODT-DESC")
	private String prodtdesc = null;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-VLIM-APROV-CUSTO")
	private Double vlimaprovcusto = 0D;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-QTD-FAIXA-OPER")
	private Integer qtdfaixaoper = 0;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-TB-FAIXAS.NPCCWJ2S-TB-FAIXAS-OCCURS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList.Npccwj2sresponse_tbfaixas_tbfaixasoccurs")
	private List<Npccwj2sresponse_tbfaixas_tbfaixasoccurs> tbfaixas_tbfaixasoccurs = null;
	
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

	public Double getVlimaprovcusto() {
		return vlimaprovcusto;
	}
	public void setVlimaprovcusto(Double vlimaprovcusto) {
		this.vlimaprovcusto = vlimaprovcusto;
	}

	public Integer getQtdfaixaoper() {
		return qtdfaixaoper;
	}
	public void setQtdfaixaoper(Integer qtdfaixaoper) {
		this.qtdfaixaoper = qtdfaixaoper;
	}

	public List<Npccwj2sresponse_tbfaixas_tbfaixasoccurs> getTbfaixas_tbfaixasoccurs() {
		return tbfaixas_tbfaixasoccurs;
	}
	public void setTbfaixas_tbfaixasoccurs( List<Npccwj2sresponse_tbfaixas_tbfaixasoccurs> tbfaixas_tbfaixasoccurs) {
		this.tbfaixas_tbfaixasoccurs = tbfaixas_tbfaixasoccurs;
	}
    
}