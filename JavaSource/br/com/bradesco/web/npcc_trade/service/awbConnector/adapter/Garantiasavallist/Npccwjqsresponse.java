package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 04/10/16 15:49
 */
public class Npccwjqsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJQS-HEADER.NPCCWJQS-COD-LAYOUT")
	private String codlayout = "NPCCWJQS";

	@Adapter(transactionField = "NPCCWJQS-HEADER.NPCCWJQS-TAM-LAYOUT")
	private Integer tamlayout = 2406;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist.Npccwjqsresponse_lista")
	private List<Npccwjqsresponse_lista> lista = null;
	
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

	public List<Npccwjqsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwjqsresponse_lista> lista) {
		this.lista = lista;
	}
    
}