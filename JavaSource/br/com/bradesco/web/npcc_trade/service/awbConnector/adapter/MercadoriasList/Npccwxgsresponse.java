package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:19
 */
public class Npccwxgsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXGS-HEADER.NPCCWXGS-COD-LAYOUT")
	private String codlayout = "NPCCWXGS";

	@Adapter(transactionField = "NPCCWXGS-HEADER.NPCCWXGS-TAM-LAYOUT")
	private Integer tamlayout = 12516;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList.Npccwxgsresponse_lista")
	private List<Npccwxgsresponse_lista> lista = null;
	
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

	public List<Npccwxgsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxgsresponse_lista> lista) {
		this.lista = lista;
	}
    
}