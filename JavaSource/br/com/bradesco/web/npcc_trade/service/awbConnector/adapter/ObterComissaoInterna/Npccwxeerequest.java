package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/04/17 09:29
 */
public class Npccwxeerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXEE-HEADER.NPCCWXEE-COD-LAYOUT")
	private String codlayout = "NPCCWXEE";

	@Adapter(transactionField = "NPCCWXEE-HEADER.NPCCWXEE-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWXEE-REGISTRO.NPCCWXEE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXEE-REGISTRO.NPCCWXEE-HINCL-REG-HIST")
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