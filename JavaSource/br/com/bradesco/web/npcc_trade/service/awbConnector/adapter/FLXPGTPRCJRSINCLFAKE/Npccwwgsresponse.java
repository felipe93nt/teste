package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/10/16 09:46
 */
public class Npccwwgsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWGS-HEADER.NPCCWWGS-COD-LAYOUT")
	private String codlayout = "NPCCWWGS";

	@Adapter(transactionField = "NPCCWWGS-HEADER.NPCCWWGS-TAM-LAYOUT")
	private Integer tamlayout = 54;

	@Adapter(transactionField = "NPCCWWGS-REGISTRO.NPCCWWGS-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWWGS-REGISTRO.NPCCWWGS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWGS-REGISTRO.NPCCWWGS-HINCL-REG")
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

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}
	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
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