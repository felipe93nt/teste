package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 22/12/15 12:13
 */
public class Npccwwnsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWNS-HEADER.NPCCWWNS-COD-LAYOUT")
	private String codlayout = "NPCCWWNS";

	@Adapter(transactionField = "NPCCWWNS-HEADER.NPCCWWNS-TAM-LAYOUT")
	private Integer tamlayout = 17796;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Npccwwnsresponse_lista")
	private List<Npccwwnsresponse_lista> lista = null;
	
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

	public List<Npccwwnsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwnsresponse_lista> lista) {
		this.lista = lista;
	}
    
}