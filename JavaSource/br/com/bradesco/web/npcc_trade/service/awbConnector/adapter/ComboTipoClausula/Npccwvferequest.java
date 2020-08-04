package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/01/16 16:05
 */
public class Npccwvferequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVFE-HEADER.NPCCWVFE-COD-LAYOUT")
	private String codlayout = "NPCCWVFE";

	@Adapter(transactionField = "NPCCWVFE-HEADER.NPCCWVFE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVFE-REGISTRO.NPCCWVFE-CTPO-CLAUS-CMBIO")
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