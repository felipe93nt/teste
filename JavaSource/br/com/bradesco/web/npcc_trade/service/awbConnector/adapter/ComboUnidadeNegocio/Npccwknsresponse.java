package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 21/03/16 16:22
 */
public class Npccwknsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWKNS-HEADER.NPCCWKNS-COD-LAYOUT")
	private String codlayout = "NPCCWKNS";

	@Adapter(transactionField = "NPCCWKNS-HEADER.NPCCWKNS-TAM-LAYOUT")
	private Integer tamlayout = 8816;

	@Adapter(transactionField = "NPCCWKNS-REGISTRO.NPCCWKNS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWKNS-REGISTRO.NPCCWKNS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio.Npccwknsresponse_lista")
	private List<Npccwknsresponse_lista> lista = null;
	
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

	public List<Npccwknsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwknsresponse_lista> lista) {
		this.lista = lista;
	}
    
}