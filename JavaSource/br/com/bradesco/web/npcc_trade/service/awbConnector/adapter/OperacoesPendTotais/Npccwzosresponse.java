package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 28/09/16 12:52
 */
public class Npccwzosresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZOS-HEADER.NPCCWZOS-COD-LAYOUT")
	private String codlayout = "NPCCWZOS";

	@Adapter(transactionField = "NPCCWZOS-HEADER.NPCCWZOS-TAM-LAYOUT")
	private Integer tamlayout = 19416;

	@Adapter(transactionField = "NPCCWZOS-REGISTRO.NPCCWZOS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZOS-REGISTRO.NPCCWZOS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais.Npccwzosresponse_lista")
	private List<Npccwzosresponse_lista> lista = null;
	
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

	public List<Npccwzosresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwzosresponse_lista> lista) {
		this.lista = lista;
	}
    
}