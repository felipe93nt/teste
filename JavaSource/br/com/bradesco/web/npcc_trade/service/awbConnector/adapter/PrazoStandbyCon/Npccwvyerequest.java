package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyCon;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/12/15 09:36
 */
public class Npccwvyerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVYE-HEADER.NPCCWVYE-COD-LAYOUT")
	private String codlayout = "NPCCWVYE";

	@Adapter(transactionField = "NPCCWVYE-HEADER.NPCCWVYE-TAM-LAYOUT")
	private Integer tamlayout = 16;

	@Adapter(transactionField = "NPCCWVYE-REGISTRO.NPCCWVYE-NPARM-GRAL-CMBIO")
	private Integer nparmgralcmbio = 0;
	
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

	public Integer getNparmgralcmbio() {
		return nparmgralcmbio;
	}
	public void setNparmgralcmbio(Integer nparmgralcmbio) {
		this.nparmgralcmbio = nparmgralcmbio;
	}
    
}