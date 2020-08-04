package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaExcl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 15:28
 */
public class Npccwvkerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVKE-HEADER.NPCCWVKE-COD-LAYOUT")
	private String codlayout = "NPCCWVKE";

	@Adapter(transactionField = "NPCCWVKE-HEADER.NPCCWVKE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVKE-REGISTRO.NPCCWVKE-CCLAUS-CONTR-CMBIO")
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