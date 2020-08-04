package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AtualizarTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 22/06/16 11:12
 */
public class Npcdwn1erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWN1E-HEADER.NPCDWN1E-COD-LAYOUT")
	private String codlayout = "NPCDWN1E";

	@Adapter(transactionField = "NPCDWN1E-HEADER.NPCDWN1E-TAM-LAYOUT")
	private Integer tamlayout = 1916;

	@Adapter(transactionField = "NPCDWN1E-REGISTRO.NPCDWN1E-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWN1E-REGISTRO.NPCDWN1E-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcd.service.awbConnector.adapter.AtualizarTarifas.Npcdwn1erequest_lista")
	private List<Npcdwn1erequest_lista> lista = null;

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

	public List<Npcdwn1erequest_lista> getLista() {
		return lista;
	}

	public void setLista(List<Npcdwn1erequest_lista> lista) {
		this.lista = lista;
	}

}