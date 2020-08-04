package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarBloqCliente;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/07/16 15:39
 */
public class Npccwmpsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMPS-HEADER.NPCCWMPS-COD-LAYOUT")
	private String codlayout = "NPCCWMPS";

	@Adapter(transactionField = "NPCCWMPS-HEADER.NPCCWMPS-TAM-LAYOUT")
	private Integer tamlayout = 14;

	@Adapter(transactionField = "NPCCWMPS-REGISTRO.NPCCWMPS-CCLI-BLOQ-DQMTO")
	private String cclibloqdqmto = null;
	
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

	public String getCclibloqdqmto() {
		return cclibloqdqmto;
	}
	public void setCclibloqdqmto(String cclibloqdqmto) {
		this.cclibloqdqmto = cclibloqdqmto;
	}
    
}