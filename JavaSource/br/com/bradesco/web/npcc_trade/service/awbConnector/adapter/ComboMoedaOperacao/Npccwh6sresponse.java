package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 17/12/15 15:08
 */
public class Npccwh6sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWH6S-HEADER.NPCCWH6S-COD-LAYOUT")
	private String codlayout = "NPCCWH6S";

	@Adapter(transactionField = "NPCCWH6S-HEADER.NPCCWH6S-TAM-LAYOUT")
	private Integer tamlayout = 10516;

	@Adapter(transactionField = "NPCCWH6S-REGISTRO.NPCCWH6S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWH6S-REGISTRO.NPCCWH6S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao.Npccwh6sresponse_lista")
	private List<Npccwh6sresponse_lista> lista = null;
	
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

	public List<Npccwh6sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwh6sresponse_lista> lista) {
		this.lista = lista;
	}
    
}