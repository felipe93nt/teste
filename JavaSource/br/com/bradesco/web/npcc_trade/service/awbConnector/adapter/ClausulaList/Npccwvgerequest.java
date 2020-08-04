package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 07/12/15 17:42
 */
public class Npccwvgerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVGE-HEADER.NPCCWVGE-COD-LAYOUT")
	private String codlayout = "NPCCWVGE";

	@Adapter(transactionField = "NPCCWVGE-HEADER.NPCCWVGE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVGE-REGISTRO.NPCCWVGE-CTPO-CLAUS-CMBIO")
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