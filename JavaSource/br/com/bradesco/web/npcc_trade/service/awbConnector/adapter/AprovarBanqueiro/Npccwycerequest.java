package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AprovarBanqueiro;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/08/16 18:13
 */
public class Npccwycerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYCE-HEADER.NPCCWYCE-COD-LAYOUT")
	private String codlayout = "NPCCWYCE";

	@Adapter(transactionField = "NPCCWYCE-HEADER.NPCCWYCE-TAM-LAYOUT")
	private Integer tamlayout = 33;

	@Adapter(transactionField = "NPCCWYCE-REGISTRO.NPCCWYCE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYCE-REGISTRO.NPCCWYCE-CFNDNG")
	private Long cfndng = 0L;
	
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
    
}