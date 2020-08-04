package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 27/07/18 18:02
 */
public class Npcdwn0sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWN0S-HEADER.NPCDWN0S-COD-LAYOUT")
	private String codlayout = "NPCDWN0S";

	@Adapter(transactionField = "NPCDWN0S-HEADER.NPCDWN0S-TAM-LAYOUT")
	private Integer tamlayout = 11966;

	@Adapter(transactionField = "NPCDWN0S-REGISTRO.NPCDWN0S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWN0S-REGISTRO.NPCDWN0S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas.Npcdwn0sresponse_lista")
	private List<Npcdwn0sresponse_lista> lista = null;
	
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

	public List<Npcdwn0sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npcdwn0sresponse_lista> lista) {
		this.lista = lista;
	}
    
}