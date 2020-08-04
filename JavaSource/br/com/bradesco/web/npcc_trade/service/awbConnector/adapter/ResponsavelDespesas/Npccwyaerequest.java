package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/12/16 11:33
 */
public class Npccwyaerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYAE-HEADER.NPCCWYAE-COD-LAYOUT")
	private String codlayout = "NPCCWYAE";

	@Adapter(transactionField = "NPCCWYAE-HEADER.NPCCWYAE-TAM-LAYOUT")
	private Integer tamlayout = 50;

	@Adapter(transactionField = "NPCCWYAE-REGISTRO.NPCCWYAE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYAE-REGISTRO.NPCCWYAE-CINDCD-APROV-BANQ")
	private Integer cindcdaprovbanq = 0;

	@Adapter(transactionField = "NPCCWYAE-REGISTRO.NPCCWYAE-HMANUT-REG")
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

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Integer getCindcdaprovbanq() {
		return cindcdaprovbanq;
	}
	public void setCindcdaprovbanq(Integer cindcdaprovbanq) {
		this.cindcdaprovbanq = cindcdaprovbanq;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}
    
}