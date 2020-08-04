package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 06/01/16 11:29
 */
public class Npccwvssresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVSS-HEADER.NPCCWVSS-COD-LAYOUT")
	private String codlayout = "NPCCWVSS";

	@Adapter(transactionField = "NPCCWVSS-HEADER.NPCCWVSS-TAM-LAYOUT")
	private Integer tamlayout = 21051;

	@Adapter(transactionField = "NPCCWVSS-REGISTRO.NPCCWVSS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVSS-REGISTRO.NPCCWVSS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula.Npccwvssresponse_lista")
	private List<Npccwvssresponse_lista> lista = null;
	
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

	public List<Npccwvssresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvssresponse_lista> lista) {
		this.lista = lista;
	}
    
}