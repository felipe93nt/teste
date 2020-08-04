package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 03/04/17 15:21
 */
public class Npccwznsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZNS-HEADER.NPCCWZNS-COD-LAYOUT")
	private String codlayout = "NPCCWZNS";

	@Adapter(transactionField = "NPCCWZNS-HEADER.NPCCWZNS-TAM-LAYOUT")
	private Integer tamlayout = 14538;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList.Npccwznsresponse_lista")
	private List<Npccwznsresponse_lista> lista = null;
	
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

	public List<Npccwznsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwznsresponse_lista> lista) {
		this.lista = lista;
	}
    
}