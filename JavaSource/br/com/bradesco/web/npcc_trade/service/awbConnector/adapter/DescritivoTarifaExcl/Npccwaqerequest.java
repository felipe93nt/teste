package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaExcl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 10:03
 */
public class Npccwaqerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWAQE-HEADER.NPCCWAQE-COD-LAYOUT")
	private String codlayout = "NPCCWAQE";

	@Adapter(transactionField = "NPCCWAQE-HEADER.NPCCWAQE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWANE-REGISTRO.NPCCWAQE-E-CCOND-ECONC")
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