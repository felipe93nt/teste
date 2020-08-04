package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 15:14
 */
public class Npccwvjerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVJE-HEADER.NPCCWVJE-COD-LAYOUT")
	private String codlayout = "NPCCWVJE";

	@Adapter(transactionField = "NPCCWVJE-HEADER.NPCCWVJE-TAM-LAYOUT")
	private Integer tamlayout = 3023;

	@Adapter(transactionField = "NPCCWVJE-REGISTRO.NPCCWVJE-CCLAUS-CONTR-CMBIO")
	private Integer cclauscontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVJE-REGISTRO.NPCCWVJE-RCLAUS-CONTR-CMBIO")
	private String rclauscontrcmbio = null;

	@Adapter(transactionField = "NPCCWVJE-REGISTRO.NPCCWVJE-CTPO-CLAUS-CMBIO")
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

	public Integer getCclauscontrcmbio() {
		return cclauscontrcmbio;
	}
	public void setCclauscontrcmbio(Integer cclauscontrcmbio) {
		this.cclauscontrcmbio = cclauscontrcmbio;
	}

	public String getRclauscontrcmbio() {
		return rclauscontrcmbio;
	}
	public void setRclauscontrcmbio(String rclauscontrcmbio) {
		this.rclauscontrcmbio = rclauscontrcmbio;
	}

	public Integer getCtpoclauscmbio() {
		return ctpoclauscmbio;
	}
	public void setCtpoclauscmbio(Integer ctpoclauscmbio) {
		this.ctpoclauscmbio = ctpoclauscmbio;
	}
    
}