package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/12/15 13:40
 */
public class Npccwvierequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVIE-HEADER.NPCCWVIE-COD-LAYOUT")
	private String codlayout = "NPCCWVIE";

	@Adapter(transactionField = "NPCCWVIE-HEADER.NPCCWVIE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVIE-REGISTRO.NPCCWVIE-CCLAUS-CONTR-CMBIO")
	private Integer cclauscontrcmbio = 0;
	
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

	public Integer getCclauscontrcmbio() {
		return cclauscontrcmbio;
	}
	public void setCclauscontrcmbio(Integer cclauscontrcmbio) {
		this.cclauscontrcmbio = cclauscontrcmbio;
	}
    
}