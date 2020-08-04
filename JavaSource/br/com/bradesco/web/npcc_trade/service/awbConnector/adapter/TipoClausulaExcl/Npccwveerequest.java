package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaExcl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 08:52
 */
public class Npccwveerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVEE-HEADER.NPCCWVEE-COD-LAYOUT")
	private String codlayout = "NPCCWVEE";

	@Adapter(transactionField = "NPCCWVEE-HEADER.NPCCWVEE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVEE-REGISTRO.NPCCWVEE-CTPO-CLAUS-CMBIO")
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