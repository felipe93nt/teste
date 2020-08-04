package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/12/15 15:47
 */
public class Npccwvaerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVAE-HEADER.NPCCWVAE-COD-LAYOUT")
	private String codlayout = "NPCCWVAE";

	@Adapter(transactionField = "NPCCWVAE-HEADER.NPCCWVAE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVAE-REGISTRO.NPCCWVAE-CTPO-CLAUS-CMBIO")
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