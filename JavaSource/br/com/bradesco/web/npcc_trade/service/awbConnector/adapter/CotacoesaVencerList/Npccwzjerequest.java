package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/11/17 16:31
 */
public class Npccwzjerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZJE-HEADER.NPCCWZJE-COD-LAYOUT")
	private String codlayout = "NPCCWZJE";

	@Adapter(transactionField = "NPCCWZJE-HEADER.NPCCWZJE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWZJE-REGISTRO.NPCCWZJE-QTD-DIAS")
	private Integer qtddias = 0;
	
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

	public Integer getQtddias() {
		return qtddias;
	}
	public void setQtddias(Integer qtddias) {
		this.qtddias = qtddias;
	}
    
}