package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 14/12/15 15:27
 */
public class Npccwvtsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVTS-HEADER.NPCCWVTS-COD-LAYOUT")
	private String codlayout = "NPCCWVTS";

	@Adapter(transactionField = "NPCCWVTS-HEADER.NPCCWVTS-TAM-LAYOUT")
	private Integer tamlayout = 2774;

	@Adapter(transactionField = "NPCCWVTS-REGISTRO.NPCCWVTS-CPRODT-SERV")
	private Integer cprodtserv = 0;

	@Adapter(transactionField = "NPCCWVTS-REGISTRO.NPCCWVTS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVTS-REGISTRO.NPCCWVTS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto.Npccwvtsresponse_lista")
	private List<Npccwvtsresponse_lista> lista = null;
	
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

	public Integer getCprodtserv() {
		return cprodtserv;
	}
	public void setCprodtserv(Integer cprodtserv) {
		this.cprodtserv = cprodtserv;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwvtsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvtsresponse_lista> lista) {
		this.lista = lista;
	}
    
}