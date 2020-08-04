package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/12/16 14:09
 */
public class Npccw0cerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCW0CE-HEADER.NPCCW0CE-COD-LAYOUT")
	private String codlayout = "NPCCW0CE";

	@Adapter(transactionField = "NPCCW0CE-HEADER.NPCCW0CE-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCW0CE-REGISTRO.NPCCW0CE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;
	
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

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}
    
}