package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 26/02/16 18:08
 */
public class Npccwjxsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJXS-HEADER.NPCCWJXS-COD-LAYOUT")
	private String codlayout = "NPCCWJXS";

	@Adapter(transactionField = "NPCCWJXS-HEADER.NPCCWJXS-TAM-LAYOUT")
	private Integer tamlayout = 1736;

	@Adapter(transactionField = "NPCCWJXS-REGISTRO.NPCCWJXS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWJXS-REGISTRO.NPCCWJXS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto.Npccwjxsresponse_lista")
	private List<Npccwjxsresponse_lista> lista = null;
	
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

	public List<Npccwjxsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwjxsresponse_lista> lista) {
		this.lista = lista;
	}
    
}