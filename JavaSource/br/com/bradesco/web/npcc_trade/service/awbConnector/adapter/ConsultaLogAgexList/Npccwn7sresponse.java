package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 01/12/16 15:20
 */
public class Npccwn7sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWN7S-HEADER.NPCCWN7S-COD-LAYOUT")
	private String codlayout = "NPCCWN7S";

	@Adapter(transactionField = "NPCCWN7S-HEADER.NPCCWN7S-TAM-LAYOUT")
	private Integer tamlayout = 11236;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList.Npccwn7sresponse_lista")
	private List<Npccwn7sresponse_lista> lista = null;
	
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

	public List<Npccwn7sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwn7sresponse_lista> lista) {
		this.lista = lista;
	}
    
}