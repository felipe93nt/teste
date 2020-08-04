package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/09/18 19:00
 */
public class Npccwjperequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJPE-HEADER.NPCCWJPE-COD-LAYOUT")
	private String codlayout = "NPCCWJPE";

	@Adapter(transactionField = "NPCCWJPE-HEADER.NPCCWJPE-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWJPE-REGISTRO.NPCCWJPE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWJPE-REGISTRO.NPCCWJPE-HORA-LOG-MANUT")
	private String horalogmanut = null;
	
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

	public String getHoralogmanut() {
		return horalogmanut;
	}
	public void setHoralogmanut(String horalogmanut) {
		this.horalogmanut = horalogmanut;
	}
    
}