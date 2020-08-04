package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/09/16 10:15
 */
public class Npccwyoerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYOE-HEADER.NPCCWYOE-COD-LAYOUT")
	private String codlayout = "NPCCWYOE";

	@Adapter(transactionField = "NPCCWYOE-HEADER.NPCCWYOE-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWYOE-REGISTRO.NPCCWYOE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYOE-REGISTRO.NPCCWYOE-HINCL-REG")
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