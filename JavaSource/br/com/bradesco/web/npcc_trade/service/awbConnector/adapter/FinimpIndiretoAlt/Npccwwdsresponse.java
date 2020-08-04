package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 11:53
 */
public class Npccwwdsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWDS-HEADER.NPCCWWDS-COD-LAYOUT")
	private String codlayout = "NPCCWWDS";

	@Adapter(transactionField = "NPCCWWDS-HEADER.NPCCWWDS-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWWDS-REGISTRO.NPCCWWDS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWDS-REGISTRO.NPCCWWDS-HINCL-REG")
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