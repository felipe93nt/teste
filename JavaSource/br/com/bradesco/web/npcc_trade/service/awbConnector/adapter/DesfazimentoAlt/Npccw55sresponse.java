package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 15:00
 */
public class Npccw55sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCW55S-HEADER.NPCCW55S-COD-LAYOUT")
	private String codlayout = "NPCCW55S";

	@Adapter(transactionField = "NPCCW55S-HEADER.NPCCW55S-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCW55S-REGISTRO.NPCCW55S-NBLETO-NEGOC-CMBIO")
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