package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/03/16 17:03
 */
public class Npccwcrerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWCRE-HEADER.NPCCWCRE-COD-LAYOUT")
	private String codlayout = "NPCCWCRE";

	@Adapter(transactionField = "NPCCWCRE-HEADER.NPCCWCRE-TAM-LAYOUT")
	private Integer tamlayout = 14;

	@Adapter(transactionField = "NPCCWCRE-REGISTRO.NPCCWCRE-CIDTFD-MESA-CMBIO")
	private Integer cidtfdmesacmbio = 0;
	
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

	public Integer getCidtfdmesacmbio() {
		return cidtfdmesacmbio;
	}
	public void setCidtfdmesacmbio(Integer cidtfdmesacmbio) {
		this.cidtfdmesacmbio = cidtfdmesacmbio;
	}
    
}