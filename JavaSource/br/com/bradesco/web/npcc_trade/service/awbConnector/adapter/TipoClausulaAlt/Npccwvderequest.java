package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/12/15 09:56
 */
public class Npccwvderequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVDE-HEADER.NPCCWVDE-COD-LAYOUT")
	private String codlayout = "NPCCWVDE";

	@Adapter(transactionField = "NPCCWVDE-HEADER.NPCCWVDE-TAM-LAYOUT")
	private Integer tamlayout = 98;

	@Adapter(transactionField = "NPCCWVDE-REGISTRO.NPCCWVDE-CTPO-CLAUS-CMBIO")
	private Integer ctpoclauscmbio = 0;

	@Adapter(transactionField = "NPCCWVDE-REGISTRO.NPCCWVDE-ITPO-CLAUS-CMBIO")
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