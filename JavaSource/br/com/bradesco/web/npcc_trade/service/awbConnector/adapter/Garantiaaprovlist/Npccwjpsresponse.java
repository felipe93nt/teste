package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 20/09/18 19:00
 */
public class Npccwjpsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJPS-HEADER.NPCCWJPS-COD-LAYOUT")
	private String codlayout = "NPCCWJPS";

	@Adapter(transactionField = "NPCCWJPS-HEADER.NPCCWJPS-TAM-LAYOUT")
	private Integer tamlayout = 3266;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist.Npccwjpsresponse_lista")
	private List<Npccwjpsresponse_lista> lista = null;
	
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

	public List<Npccwjpsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwjpsresponse_lista> lista) {
		this.lista = lista;
	}
    
}