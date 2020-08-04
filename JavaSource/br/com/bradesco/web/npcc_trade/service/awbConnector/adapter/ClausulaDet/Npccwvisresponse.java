package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/12/15 13:40
 */
public class Npccwvisresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVIS-HEADER.NPCCWVIS-COD-LAYOUT")
	private String codlayout = "NPCCWVIS";

	@Adapter(transactionField = "NPCCWVIS-HEADER.NPCCWVIS-TAM-LAYOUT")
	private Integer tamlayout = 3103;

	@Adapter(transactionField = "NPCCWVIS-REGISTRO.NPCCWVIS-CCLAUS-CONTR-CMBIO")
	private Integer cclauscontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVIS-REGISTRO.NPCCWVIS-RCLAUS-CONTR-CMBIO")
	private String rclauscontrcmbio = null;

	@Adapter(transactionField = "NPCCWVIS-REGISTRO.NPCCWVIS-CTPO-CLAUS-CMBIO")
	private Integer ctpoclauscmbio = 0;

	@Adapter(transactionField = "NPCCWVIS-REGISTRO.NPCCWVIS-ITPO-CLAUS-CMBIO")
	private String itpoclauscmbio = null;
	
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

	public String getItpoclauscmbio() {
		return itpoclauscmbio;
	}
	public void setItpoclauscmbio(String itpoclauscmbio) {
		this.itpoclauscmbio = itpoclauscmbio;
	}
    
}