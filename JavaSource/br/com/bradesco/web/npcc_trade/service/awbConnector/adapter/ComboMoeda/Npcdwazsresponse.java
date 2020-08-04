package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 18/12/15 18:35
 */
public class Npcdwazsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWAZS-HEADER.NPCDWAZS-COD-LAYOUT")
	private String codlayout = "NPCDWAZS";

	@Adapter(transactionField = "NPCDWAZS-HEADER.NPCDWAZS-TAM-LAYOUT")
	private Integer tamlayout = 1766;

	@Adapter(transactionField = "NPCDWAZS-REGISTRO.NPCDWAZS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWAZS-REGISTRO.NPCDWAZS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda.Npcdwazsresponse_lista")
	private List<Npcdwazsresponse_lista> lista = null;
	
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

	public List<Npcdwazsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npcdwazsresponse_lista> lista) {
		this.lista = lista;
	}
    
}