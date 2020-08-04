package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/10/16 09:54
 */
public class Npccwyberequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYBE-HEADER.NPCCWYBE-COD-LAYOUT")
	private String codlayout = "NPCCWYBE";

	@Adapter(transactionField = "NPCCWYBE-HEADER.NPCCWYBE-TAM-LAYOUT")
	private Integer tamlayout = 59;

	@Adapter(transactionField = "NPCCWYBE-REGISTRO.NPCCWYBE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYBE-REGISTRO.NPCCWYBE-CFNDNG")
	private Long cfndng = 0L;

	@Adapter(transactionField = "NPCCWYBE-REGISTRO.NPCCWYBE-HMANUT-REG")
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

	public Long getCfndng() {
		return cfndng;
	}
	public void setCfndng(Long cfndng) {
		this.cfndng = cfndng;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}
    
}