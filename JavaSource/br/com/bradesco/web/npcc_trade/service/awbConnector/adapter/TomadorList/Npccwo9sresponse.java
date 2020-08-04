package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/05/16 11:24
 */
public class Npccwo9sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWO9S-HEADER.NPCCWO9S-COD-LAYOUT")
	private String codlayout = "NPCCWO9S";

	@Adapter(transactionField = "NPCCWO9S-HEADER.NPCCWO9S-TAM-LAYOUT")
	private Integer tamlayout = 12816;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList.Npccwo9sresponse_lista")
	private List<Npccwo9sresponse_lista> lista = null;
	
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

	public List<Npccwo9sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwo9sresponse_lista> lista) {
		this.lista = lista;
	}
    
}