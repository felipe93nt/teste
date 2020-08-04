package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/10/15 10:02
 */
public class Npcdwaaerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWAAE-HEADER.NPCDWAAE-COD-LAYOUT")
	private String codlayout = "NPCDWAAE";

	@Adapter(transactionField = "NPCDWAAE-HEADER.NPCDWAAE-TAM-LAYOUT")
	private Integer tamlayout = 15;

	@Adapter(transactionField = "NPCDWAAE-REGISTRO.NPCDWAAE-CFORMA-LIQDC-CMBIO")
	private Integer cformaliqdccmbio = 0;
	
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

	public Integer getCformaliqdccmbio() {
		return cformaliqdccmbio;
	}
	public void setCformaliqdccmbio(Integer cformaliqdccmbio) {
		this.cformaliqdccmbio = cformaliqdccmbio;
	}
    
}