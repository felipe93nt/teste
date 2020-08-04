package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaPiloto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/05/17 16:44
 */
public class Npccwcdsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWCDS-HEADER.NPCCWCDS-COD-LAYOUT")
	private String codlayout = "NPCCWCDS";

	@Adapter(transactionField = "NPCCWCDS-HEADER.NPCCWCDS-TAM-LAYOUT")
	private Integer tamlayout = 15;

	@Adapter(transactionField = "NPCCWCDS-REGISTRO.NPCCWCDS-CPILOT-CMBIO-ATIVO")
	private Integer cpilotcmbioativo = 0;

	@Adapter(transactionField = "NPCCWCDS-REGISTRO.NPCCWCDS-CPARTC-PILOT-CMBIO")
	private Integer cpartcpilotcmbio = 0;
	
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

	public Integer getCpilotcmbioativo() {
		return cpilotcmbioativo;
	}
	public void setCpilotcmbioativo(Integer cpilotcmbioativo) {
		this.cpilotcmbioativo = cpilotcmbioativo;
	}

	public Integer getCpartcpilotcmbio() {
		return cpartcpilotcmbio;
	}
	public void setCpartcpilotcmbio(Integer cpartcpilotcmbio) {
		this.cpartcpilotcmbio = cpartcpilotcmbio;
	}
    
}