package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/10/16 15:49
 */
public class Npccwjqerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJQE-HEADER.NPCCWJQE-COD-LAYOUT")
	private String codlayout = "NPCCWJQE";

	@Adapter(transactionField = "NPCCWJQE-HEADER.NPCCWJQE-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWJQE-REGISTRO.NPCCWJQE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWJQE-REGISTRO.NPCCWJQE-HINCL-REG-HIST")
	private String hinclreghist = null;
	
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

	public String getHinclreghist() {
		return hinclreghist;
	}
	public void setHinclreghist(String hinclreghist) {
		this.hinclreghist = hinclreghist;
	}
    
}