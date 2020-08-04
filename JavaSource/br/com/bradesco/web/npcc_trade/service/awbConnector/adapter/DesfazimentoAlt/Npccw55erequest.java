package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 15:00
 */
public class Npccw55erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCW55E-HEADER.NPCCW55E-COD-LAYOUT")
	private String codlayout = "NPCCW55E";

	@Adapter(transactionField = "NPCCW55E-HEADER.NPCCW55E-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCW55E-REGISTRO.NPCCW55E-NBLETO-NEGOC-CMBIO")
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