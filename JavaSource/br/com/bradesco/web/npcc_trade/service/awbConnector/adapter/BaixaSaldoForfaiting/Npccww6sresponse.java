package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixaSaldoForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 11:32
 */
public class Npccww6sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW6S-HEADER.NPCCWW6S-COD-LAYOUT")
	private String codlayout = "NPCCWW6S";

	@Adapter(transactionField = "NPCCWW6S-HEADER.NPCCWW6S-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCWW6S-SAIDA.NPCCWW6S-NBLETO-NEGOC-CMBIO")
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