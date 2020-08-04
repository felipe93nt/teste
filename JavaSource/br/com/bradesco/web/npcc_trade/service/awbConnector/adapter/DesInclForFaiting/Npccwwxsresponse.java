package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 17/05/16 09:25
 */
public class Npccwwxsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWXS-HEADER.NPCCWWXS-COD-LAYOUT")
	private String codlayout = "NPCCWWXS";

	@Adapter(transactionField = "NPCCWWXS-HEADER.NPCCWWXS-TAM-LAYOUT")
	private Integer tamlayout = 54;

	@Adapter(transactionField = "NPCCWWXS-REGISTRO.NPCCWWXS-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWWXS-REGISTRO.NPCCWWXS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWXS-REGISTRO.NPCCWWXS-HINCL-REG")
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