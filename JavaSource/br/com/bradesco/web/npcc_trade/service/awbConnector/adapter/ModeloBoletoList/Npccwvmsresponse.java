package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 29/06/18 09:46
 */
public class Npccwvmsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVMS-HEADER.NPCCWVMS-COD-LAYOUT")
	private String codlayout = "NPCCWVMS";

	@Adapter(transactionField = "NPCCWVMS-HEADER.NPCCWVMS-TAM-LAYOUT")
	private Integer tamlayout = 2824;

	@Adapter(transactionField = "NPCCWVMS-REGISTRO.NPCCWVMS-CPRODT-SERV")
	private Integer cprodtserv = 0;

	@Adapter(transactionField = "NPCCWVMS-REGISTRO.NPCCWVMS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVMS-REGISTRO.NPCCWVMS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Npccwvmsresponse_lista")
	private List<Npccwvmsresponse_lista> lista = null;
	
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

	public List<Npccwvmsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvmsresponse_lista> lista) {
		this.lista = lista;
	}
    
}