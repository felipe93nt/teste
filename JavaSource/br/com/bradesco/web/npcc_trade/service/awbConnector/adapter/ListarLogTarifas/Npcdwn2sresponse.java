package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarLogTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 22/06/16 10:48
 */
public class Npcdwn2sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWN2S-HEADER.NPCDWN2S-COD-LAYOUT")
	private String codlayout = "NPCDWN2S";

	@Adapter(transactionField = "NPCDWN2S-HEADER.NPCDWN2S-TAM-LAYOUT")
	private Integer tamlayout = 17716;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcd.service.awbConnector.adapter.ListarLogTarifas.Npcdwn2sresponse_lista")
	private List<Npcdwn2sresponse_lista> lista = null;

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

	public List<Npcdwn2sresponse_lista> getLista() {
		return lista;
	}

	public void setLista(List<Npcdwn2sresponse_lista> lista) {
		this.lista = lista;
	}

}