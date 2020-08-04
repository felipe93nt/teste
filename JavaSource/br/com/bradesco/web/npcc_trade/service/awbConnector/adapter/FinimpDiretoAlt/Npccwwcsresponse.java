package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:30
 */
public class Npccwwcsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWCS-HEADER.NPCCWWCS-COD-LAYOUT")
	private String codlayout = "NPCCWWCS";

	@Adapter(transactionField = "NPCCWWCS-HEADER.NPCCWWCS-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWWCS-REGISTRO.NPCCWWCS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWCS-REGISTRO.NPCCWWCS-HINCL-REG")
	private String hinclreg = null;
	
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

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}
    
}