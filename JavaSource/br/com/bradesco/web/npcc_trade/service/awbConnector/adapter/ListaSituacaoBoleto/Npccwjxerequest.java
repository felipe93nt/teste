package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 18:08
 */
public class Npccwjxerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJXE-HEADER.NPCCWJXE-COD-LAYOUT")
	private String codlayout = "NPCCWJXE";

	@Adapter(transactionField = "NPCCWJXE-HEADER.NPCCWJXE-TAM-LAYOUT")
	private Integer tamlayout = 17;

	@Adapter(transactionField = "NPCCWJXE-REGISTRO.NPCCWJXE-CIDTFD-MESA-CMBIO")
	private Integer cidtfdmesacmbio = 0;

	@Adapter(transactionField = "NPCCWJXE-REGISTRO.NPCCWJXE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;
	
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

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}
    
}