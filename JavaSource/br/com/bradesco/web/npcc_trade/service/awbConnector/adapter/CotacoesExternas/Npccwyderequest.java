package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 31/10/17 12:30
 */
public class Npccwyderequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYDE-HEADER.NPCCWYDE-COD-LAYOUT")
	private String codlayout = "NPCCWYDE";

	@Adapter(transactionField = "NPCCWYDE-HEADER.NPCCWYDE-TAM-LAYOUT")
	private Integer tamlayout = 50;

	@Adapter(transactionField = "NPCCWYDE-REGISTRO.NPCCWYDE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYDE-REGISTRO.NPCCWYDE-CINDCD-APROV-BANQ")
	private Integer cindcdaprovbanq = 0;

	@Adapter(transactionField = "NPCCWYDE-REGISTRO.NPCCWYDE-HMANUT-REG")
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