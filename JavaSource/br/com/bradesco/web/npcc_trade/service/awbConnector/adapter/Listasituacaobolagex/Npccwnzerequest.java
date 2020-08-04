package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/05/16 14:07
 */
public class Npccwnzerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWNZE-HEADER.NPCCWNZE-COD-LAYOUT")
	private String codlayout = "NPCCWNZE";

	@Adapter(transactionField = "NPCCWNZE-HEADER.NPCCWNZE-TAM-LAYOUT")
	private Integer tamlayout = 20;

	@Adapter(transactionField = "NPCCWNZE-REGISTRO.NPCCWNZE-CIDTFD-MESA-CMBIO")
	private Integer cidtfdmesacmbio = 0;

	@Adapter(transactionField = "NPCCWNZE-REGISTRO.NPCCWNZE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWNZE-REGISTRO.NPCCWNZE-TIPO")
	private Integer tipo = 0;
	
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

	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
    
}