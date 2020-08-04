package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:44
 */
public class Npccwxjerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXJE-HEADER.NPCCWXJE-COD-LAYOUT")
	private String codlayout = "NPCCWXJE";

	@Adapter(transactionField = "NPCCWXJE-HEADER.NPCCWXJE-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWXJE-REGISTRO.NPCCWXJE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXJE-REGISTRO.NPCCWXJE-HINCL-REG-HIST")
	private String hinclreghist = null;
	
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

	public String getHinclreghist() {
		return hinclreghist;
	}
	public void setHinclreghist(String hinclreghist) {
		this.hinclreghist = hinclreghist;
	}
    
}