package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 16/02/16 14:44
 */
public class Npccwiasresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIAS-HEADER.NPCCWIAS-COD-LAYOUT")
	private String codlayout = "NPCCWIAS";

	@Adapter(transactionField = "NPCCWIAS-HEADER.NPCCWIAS-TAM-LAYOUT")
	private Integer tamlayout = 16216;

	@Adapter(transactionField = "NPCCWIAS-REGISTRO.NPCCWIAS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWIAS-REGISTRO.NPCCWIAS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto.Npccwiasresponse_lista")
	private List<Npccwiasresponse_lista> lista = null;
	
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

	public List<Npccwiasresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwiasresponse_lista> lista) {
		this.lista = lista;
	}
    
}