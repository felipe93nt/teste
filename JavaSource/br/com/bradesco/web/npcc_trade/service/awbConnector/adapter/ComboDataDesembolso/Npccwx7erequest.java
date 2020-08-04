package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/05/16 12:41
 */
public class Npccwx7erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX7E-HEADER.NPCCWX7E-COD-LAYOUT")
	private String codlayout = "NPCCWX7E";

	@Adapter(transactionField = "NPCCWX7E-HEADER.NPCCWX7E-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCWX7E-REGISTRO.NPCCWX7E-NBLETO-NEGOC-CMBIO")
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