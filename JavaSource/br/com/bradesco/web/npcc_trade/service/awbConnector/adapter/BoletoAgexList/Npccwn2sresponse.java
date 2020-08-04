package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 01/12/16 12:15
 */
public class Npccwn2sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWN2S-HEADER.NPCCWN2S-COD-LAYOUT")
	private String codlayout = "NPCCWN2S";

	@Adapter(transactionField = "NPCCWN2S-HEADER.NPCCWN2S-TAM-LAYOUT")
	private Integer tamlayout = 19196;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList.Npccwn2sresponse_lista")
	private List<Npccwn2sresponse_lista> lista = null;
	
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

	public List<Npccwn2sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwn2sresponse_lista> lista) {
		this.lista = lista;
	}
    
}