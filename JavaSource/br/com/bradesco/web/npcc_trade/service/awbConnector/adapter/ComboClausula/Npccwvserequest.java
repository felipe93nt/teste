package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/01/16 11:29
 */
public class Npccwvserequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVSE-HEADER.NPCCWVSE-COD-LAYOUT")
	private String codlayout = "NPCCWVSE";

	@Adapter(transactionField = "NPCCWVSE-HEADER.NPCCWVSE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVSE-REGISTRO.NPCCWVSE-CTPO-CLAUS-CMBIO")
	private Integer ctpoclauscmbio = 0;
	
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

	public Integer getCtpoclauscmbio() {
		return ctpoclauscmbio;
	}
	public void setCtpoclauscmbio(Integer ctpoclauscmbio) {
		this.ctpoclauscmbio = ctpoclauscmbio;
	}
    
}