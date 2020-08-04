package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/12/16 14:09
 */
public class Npccw0csresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCW0CS-HEADER.NPCCW0CS-COD-LAYOUT")
	private String codlayout = "NPCCW0CS";

	@Adapter(transactionField = "NPCCW0CS-HEADER.NPCCW0CS-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCW0CS-REGISTRO.NPCCW0CS-NBLETO-NEGOC-CMBIO")
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