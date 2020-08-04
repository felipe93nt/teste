package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 20/02/17 13:37
 */
public class Npccwxusresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXUS-HEADER.NPCCWXUS-COD-LAYOUT")
	private String codlayout = "NPCCWXUS";

	@Adapter(transactionField = "NPCCWXUS-HEADER.NPCCWXUS-TAM-LAYOUT")
	private Integer tamlayout = 5666;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList.Npccwxusresponse_lista")
	private List<Npccwxusresponse_lista> lista = null;
	
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

	public List<Npccwxusresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxusresponse_lista> lista) {
		this.lista = lista;
	}
    
}