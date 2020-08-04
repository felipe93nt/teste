package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 08/12/15 15:56
 */
public class Npccwvberequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVBE-HEADER.NPCCWVBE-COD-LAYOUT")
	private String codlayout = "NPCCWVBE";

	@Adapter(transactionField = "NPCCWVBE-HEADER.NPCCWVBE-TAM-LAYOUT")
	private Integer tamlayout = 93;

	@Adapter(transactionField = "NPCCWVBE-REGISTRO.NPCCWVBE-ITPO-CLAUS-CMBIO")
	private String itpoclauscmbio = null;
	
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

	public String getItpoclauscmbio() {
		return itpoclauscmbio;
	}
	public void setItpoclauscmbio(String itpoclauscmbio) {
		this.itpoclauscmbio = itpoclauscmbio;
	}
    
}