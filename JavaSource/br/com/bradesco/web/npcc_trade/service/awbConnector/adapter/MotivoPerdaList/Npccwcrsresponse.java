package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 29/03/16 17:03
 */
public class Npccwcrsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWCRS-HEADER.NPCCWCRS-COD-LAYOUT")
	private String codlayout = "NPCCWCRS";

	@Adapter(transactionField = "NPCCWCRS-HEADER.NPCCWCRS-TAM-LAYOUT")
	private Integer tamlayout = 5116;

	@Adapter(transactionField = "NPCCWCRS-REGISTRO.NPCCWCRS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWCRS-REGISTRO.NPCCWCRS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList.Npccwcrsresponse_lista")
	private List<Npccwcrsresponse_lista> lista = null;
	
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

	public List<Npccwcrsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwcrsresponse_lista> lista) {
		this.lista = lista;
	}
    
}