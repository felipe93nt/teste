package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 03/03/20 15:27
 */
public class Npccwvusresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVUS-HEADER.NPCCWVUS-COD-LAYOUT")
	private String codlayout = "NPCCWVUS";

	@Adapter(transactionField = "NPCCWVUS-HEADER.NPCCWVUS-TAM-LAYOUT")
	private Integer tamlayout = 19616;

	@Adapter(transactionField = "NPCCWVUS-REGISTRO.NPCCWVUS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVUS-REGISTRO.NPCCWVUS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Npccwvusresponse_lista")
	private List<Npccwvusresponse_lista> lista = null;
	
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

	public List<Npccwvusresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvusresponse_lista> lista) {
		this.lista = lista;
	}
    
}