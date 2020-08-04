package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 26/02/16 15:30
 */
public class Npccwwpsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWPS-HEADER.NPCCWWPS-COD-LAYOUT")
	private String codlayout = "NPCCWWPS";

	@Adapter(transactionField = "NPCCWWPS-HEADER.NPCCWWPS-TAM-LAYOUT")
	private Integer tamlayout = 18916;

	@Adapter(transactionField = "NPCCWWPS-REGISTRO.NPCCWWPS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWPS-REGISTRO.NPCCWWPS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao.Npccwwpsresponse_lista")
	private List<Npccwwpsresponse_lista> lista = null;
	
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

	public List<Npccwwpsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwpsresponse_lista> lista) {
		this.lista = lista;
	}
    
}