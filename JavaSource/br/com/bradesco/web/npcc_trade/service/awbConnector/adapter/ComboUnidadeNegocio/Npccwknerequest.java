package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 21/03/16 16:22
 */
public class Npccwknerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWKNE-HEADER.NPCCWKNE-COD-LAYOUT")
	private String codlayout = "NPCCWKNE";

	@Adapter(transactionField = "NPCCWKNE-HEADER.NPCCWKNE-TAM-LAYOUT")
	private Integer tamlayout = 21;

	@Adapter(transactionField = "NPCCWKNE-REGISTRO.NPCCWKNE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;
	
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

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}
    
}