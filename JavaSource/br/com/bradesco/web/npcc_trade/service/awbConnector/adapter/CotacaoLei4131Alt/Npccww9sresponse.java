package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Alt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 14:52
 */
public class Npccww9sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW9S-HEADER.NPCCWW9S-COD-LAYOUT")
	private String codlayout = "NPCCWW9S";

	@Adapter(transactionField = "NPCCWW9S-HEADER.NPCCWW9S-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWW9S-REGISTRO.NPCCWW9S-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWW9S-REGISTRO.NPCCWW9S-HINCL-REG")
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