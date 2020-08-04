package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 30/11/16 11:32
 */
public class Npccww3erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW3E-HEADER.NPCCWW3E-COD-LAYOUT")
	private String codlayout = "NPCCWW3E";

	@Adapter(transactionField = "NPCCWW3E-HEADER.NPCCWW3E-TAM-LAYOUT")
	private Integer tamlayout = 236;

	@Adapter(transactionField = "NPCCWW3E-REGISTRO.NPCCWW3E-QTDD-OCORR")
	private Integer qtddocorr = 0;

	@Adapter(transactionField = "NPCCWW3E-REGISTRO.NPCCWW3E-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp.Npccww3erequest_lista")
	private List<Npccww3erequest_lista> lista = null;
	
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

	public Integer getQtddocorr() {
		return qtddocorr;
	}
	public void setQtddocorr(Integer qtddocorr) {
		this.qtddocorr = qtddocorr;
	}

	public List<Npccww3erequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccww3erequest_lista> lista) {
		this.lista = lista;
	}
    
}