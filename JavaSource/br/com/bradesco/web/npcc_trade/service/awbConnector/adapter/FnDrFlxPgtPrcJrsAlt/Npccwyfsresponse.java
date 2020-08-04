package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/05/16 15:23
 */
public class Npccwyfsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYFS-HEADER.NPCCWYFS-COD-LAYOUT")
	private String codlayout = "NPCCWYFS";

	@Adapter(transactionField = "NPCCWYFS-HEADER.NPCCWYFS-TAM-LAYOUT")
	private Integer tamlayout = 54;

	@Adapter(transactionField = "NPCCWYFS-REGISTRO.NPCCWYFS-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWYFS-REGISTRO.NPCCWYFS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYFS-REGISTRO.NPCCWYFS-HMANUT-REG")
	private String hmanutreg = null;
	
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

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}
    
}