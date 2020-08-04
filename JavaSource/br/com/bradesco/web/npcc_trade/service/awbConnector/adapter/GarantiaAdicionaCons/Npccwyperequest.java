package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/03/16 08:12
 */
public class Npccwyperequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYPE-HEADER.NPCCWYPE-COD-LAYOUT")
	private String codlayout = "NPCCWYPE";

	@Adapter(transactionField = "NPCCWYPE-HEADER.NPCCWYPE-TAM-LAYOUT")
	private Integer tamlayout = 21;

	@Adapter(transactionField = "NPCCWYPE-REGISTRO.NPCCWYPE-CD-PRODT")
	private Integer cdprodt = 0;
	
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

	public Integer getCdprodt() {
		return cdprodt;
	}
	public void setCdprodt(Integer cdprodt) {
		this.cdprodt = cdprodt;
	}
    
}