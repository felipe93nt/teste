package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/06/16 14:20
 */
public class Npccwzuerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZUE-HEADER.NPCCWZUE-COD-LAYOUT")
	private String codlayout = "NPCCWZUE";

	@Adapter(transactionField = "NPCCWZUE-HEADER.NPCCWZUE-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWZUE-REGISTRO.NPCCWZUE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWZUE-REGISTRO.NPCCWZUE-HINCL-REG-HIST")
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