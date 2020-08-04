package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Fluxovalidacaopagame;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/10/16 11:28
 */
public class Npccwx8sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX8S-HEADER.NPCCWX8S-COD-LAYOUT")
	private String codlayout = "NPCCWX8S";

	@Adapter(transactionField = "NPCCWX8S-HEADER.NPCCWX8S-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWX8S-REGISTRO.NPCCWX8S-QTDE-OCORR-PRINC")
	private Integer qtdeocorrprinc = 0;
	
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

	public Integer getQtdeocorrprinc() {
		return qtdeocorrprinc;
	}
	public void setQtdeocorrprinc(Integer qtdeocorrprinc) {
		this.qtdeocorrprinc = qtdeocorrprinc;
	}
    
}