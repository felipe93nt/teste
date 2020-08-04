package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixarAgendaSwap;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/09/16 10:28
 */
public class Npccwzrerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZRE-HEADER.NPCCWZRE-COD-LAYOUT")
	private String codlayout = "NPCCWZRE";

	@Adapter(transactionField = "NPCCWZRE-HEADER.NPCCWZRE-TAM-LAYOUT")
	private Integer tamlayout = 34;

	@Adapter(transactionField = "NPCCWZRE-REGISTRO.NPCCWZRE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWZRE-REGISTRO.NPCCWZRE-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWZRE-REGISTRO.NPCCWZRE-NPCELA-DSEMB-TRADE")
	private Integer npceladsembtrade = 0;

	@Adapter(transactionField = "NPCCWZRE-REGISTRO.NPCCWZRE-TP-PARCELA")
	private String tpparcela = null;
	
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

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}
	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}

	public Integer getNpceladsembtrade() {
		return npceladsembtrade;
	}
	public void setNpceladsembtrade(Integer npceladsembtrade) {
		this.npceladsembtrade = npceladsembtrade;
	}

	public String getTpparcela() {
		return tpparcela;
	}
	public void setTpparcela(String tpparcela) {
		this.tpparcela = tpparcela;
	}
    
}