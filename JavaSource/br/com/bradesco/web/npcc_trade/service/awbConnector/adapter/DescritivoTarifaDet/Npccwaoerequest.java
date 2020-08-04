package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 10:05
 */
public class Npccwaoerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWAOE-HEADER.NPCCWAOE-COD-LAYOUT")
	private String codlayout = "NPCCWAOE";

	@Adapter(transactionField = "NPCCWAOE-HEADER.NPCCWAOE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWAOE-REGISTRO.NPCCWAOE-E-CCOND-ECONC")
	private Integer eccondeconc = 0;
	
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

	public Integer getEccondeconc() {
		return eccondeconc;
	}
	public void setEccondeconc(Integer eccondeconc) {
		this.eccondeconc = eccondeconc;
	}
    
}