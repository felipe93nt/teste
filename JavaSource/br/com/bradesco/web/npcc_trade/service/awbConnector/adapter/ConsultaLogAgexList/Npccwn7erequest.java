package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 01/12/16 15:20
 */
public class Npccwn7erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWN7E-HEADER.NPCCWN7E-COD-LAYOUT")
	private String codlayout = "NPCCWN7E";

	@Adapter(transactionField = "NPCCWN7E-HEADER.NPCCWN7E-TAM-LAYOUT")
	private Integer tamlayout = 43;

	@Adapter(transactionField = "NPCCWN7E-REGISTRO.NPCCWN7E-E-CUNIC-CLI-CMBIO")
	private Long ecunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWN7E-REGISTRO.NPCCWN7E-E-DATA-INI")
	private String edataini = null;

	@Adapter(transactionField = "NPCCWN7E-REGISTRO.NPCCWN7E-E-DATA-FIM")
	private String edatafim = null;
	
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

	public Long getEcunicclicmbio() {
		return ecunicclicmbio;
	}
	public void setEcunicclicmbio(Long ecunicclicmbio) {
		this.ecunicclicmbio = ecunicclicmbio;
	}

	public String getEdataini() {
		return edataini;
	}
	public void setEdataini(String edataini) {
		this.edataini = edataini;
	}

	public String getEdatafim() {
		return edatafim;
	}
	public void setEdatafim(String edatafim) {
		this.edatafim = edatafim;
	}
    
}