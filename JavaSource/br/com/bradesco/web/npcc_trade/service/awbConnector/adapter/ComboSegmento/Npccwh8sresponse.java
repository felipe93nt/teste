package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 26/02/16 10:29
 */
public class Npccwh8sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWH8S-HEADER.NPCCWH8S-COD-LAYOUT")
	private String codlayout = "NPCCWH8S";

	@Adapter(transactionField = "NPCCWH8S-HEADER.NPCCWH8S-TAM-LAYOUT")
	private Integer tamlayout = 1166;

	@Adapter(transactionField = "NPCCWH8S-REGISTRO.NPCCWH8S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWH8S-REGISTRO.NPCCWH8S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento.Npccwh8sresponse_lista")
	private List<Npccwh8sresponse_lista> lista = null;
	
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

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwh8sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwh8sresponse_lista> lista) {
		this.lista = lista;
	}
    
}