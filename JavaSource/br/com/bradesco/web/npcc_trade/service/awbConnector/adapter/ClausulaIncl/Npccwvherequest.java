package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 08/12/15 10:25
 */
public class Npccwvherequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVHE-HEADER.NPCCWVHE-COD-LAYOUT")
	private String codlayout = "NPCCWVHE";

	@Adapter(transactionField = "NPCCWVHE-HEADER.NPCCWVHE-TAM-LAYOUT")
	private Integer tamlayout = 3018;

	@Adapter(transactionField = "NPCCWVHE-REGISTRO.NPCCWVHE-RCLAUS-CONTR-CMBIO")
	private String rclauscontrcmbio = null;

	@Adapter(transactionField = "NPCCWVHE-REGISTRO.NPCCWVHE-CTPO-CLAUS-CMBIO")
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