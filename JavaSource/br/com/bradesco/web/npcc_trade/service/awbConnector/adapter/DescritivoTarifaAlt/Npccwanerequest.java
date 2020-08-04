package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 09:55
 */
public class Npccwanerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWANE-HEADER.NPCCWANE-COD-LAYOUT")
	private String codlayout = "NPCCWANE";

	@Adapter(transactionField = "NPCCWANE-HEADER.NPCCWANE-TAM-LAYOUT")
	private Integer tamlayout = 68;

	@Adapter(transactionField = "NPCCWANE-REGISTRO.NPCCWANE-E-CCOND-ECONC")
	private Integer eccondeconc = 0;

	@Adapter(transactionField = "NPCCWANE-REGISTRO.NPCCWANE-E-DALTER")
	private String edalter = null;
	
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

	public String getEdalter() {
		return edalter;
	}
	public void setEdalter(String edalter) {
		this.edalter = edalter;
	}
    
}