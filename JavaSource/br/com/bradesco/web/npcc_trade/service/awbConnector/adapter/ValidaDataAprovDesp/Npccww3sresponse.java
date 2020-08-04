package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 30/11/16 11:32
 */
public class Npccww3sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW3S-HEADER.NPCCWW3S-COD-LAYOUT")
	private String codlayout = "NPCCWW3S";

	@Adapter(transactionField = "NPCCWW3S-HEADER.NPCCWW3S-TAM-LAYOUT")
	private Integer tamlayout = 14;

	@Adapter(transactionField = "NPCCWW3S-REGISTRO.NPCCWW3S-CSIT-FECHA")
	private Integer csitfecha = 0;
	
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

	public Integer getCsitfecha() {
		return csitfecha;
	}
	public void setCsitfecha(Integer csitfecha) {
		this.csitfecha = csitfecha;
	}
    
}