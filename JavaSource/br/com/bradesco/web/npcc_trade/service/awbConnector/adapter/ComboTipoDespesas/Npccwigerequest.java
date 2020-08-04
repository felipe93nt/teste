package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 14:03
 */
public class Npccwigerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIGE-HEADER.NPCCWIGE-COD-LAYOUT")
	private String codlayout = "NPCCWIGE";

	@Adapter(transactionField = "NPCCWIGE-HEADER.NPCCWIGE-TAM-LAYOUT")
	private Integer tamlayout = 16;

	@Adapter(transactionField = "NPCCWIGE-REGISTRO.NPCCWIGE-CTPO-DESP-CMBIO")
	private Integer ctpodespcmbio = 0;
	
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

	public Integer getCtpodespcmbio() {
		return ctpodespcmbio;
	}
	public void setCtpodespcmbio(Integer ctpodespcmbio) {
		this.ctpodespcmbio = ctpodespcmbio;
	}
    
}