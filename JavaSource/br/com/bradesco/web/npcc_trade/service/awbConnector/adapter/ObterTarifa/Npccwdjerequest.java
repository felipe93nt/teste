package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/08/16 16:41
 */
public class Npccwdjerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWDJE-HEADER.NPCCWDJE-COD-LAYOUT")
	private String codlayout = "NPCCWDJE";

	@Adapter(transactionField = "NPCCWDJE-HEADER.NPCCWDJE-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCWDJE-REGISTRO.NPCCWDJE-NBLETO-NEGOC-CMBIO")
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