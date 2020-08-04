package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 09/08/17 18:19
 */
public class Npccwppsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWPPS-HEADER.NPCCWPPS-COD-LAYOUT")
	private String codlayout = "NPCCWPPS";

	@Adapter(transactionField = "NPCCWPPS-HEADER.NPCCWPPS-TAM-LAYOUT")
	private Integer tamlayout = 9586;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList.Npccwppsresponse_lista")
	private List<Npccwppsresponse_lista> lista = null;
	
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

	public List<Npccwppsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwppsresponse_lista> lista) {
		this.lista = lista;
	}
    
}