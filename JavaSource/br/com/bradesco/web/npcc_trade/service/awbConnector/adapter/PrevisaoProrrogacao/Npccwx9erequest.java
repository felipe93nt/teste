package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrevisaoProrrogacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/05/16 19:33
 */
public class Npccwx9erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX9E-HEADER.NPCCWX9E-COD-LAYOUT")
	private String codlayout = "NPCCWX9E";

	@Adapter(transactionField = "NPCCWX9E-HEADER.NPCCWX9E-TAM-LAYOUT")
	private Integer tamlayout = 31;

	@Adapter(transactionField = "NPCCWX9E-REGISTRO.NPCCWX9E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWX9E-REGISTRO.NPCCWX9E-CADITV-BLETO-CMBIO")
	private Integer caditvbletocmbio = 0;

	@Adapter(transactionField = "NPCCWX9E-REGISTRO.NPCCWX9E-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;
	
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

	public Integer getCaditvbletocmbio() {
		return caditvbletocmbio;
	}
	public void setCaditvbletocmbio(Integer caditvbletocmbio) {
		this.caditvbletocmbio = caditvbletocmbio;
	}

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}
	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}
    
}