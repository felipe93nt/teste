package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 30/06/16 17:47
 */
public class Npccwwssresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWSS-HEADER.NPCCWWSS-COD-LAYOUT")
	private String codlayout = "NPCCWWSS";

	@Adapter(transactionField = "NPCCWWSS-HEADER.NPCCWWSS-TAM-LAYOUT")
	private Integer tamlayout = 19516;

	@Adapter(transactionField = "NPCCWWSS-REGISTRO.NPCCWWSS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWSS-REGISTRO.NPCCWWSS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes.Npccwwssresponse_lista")
	private List<Npccwwssresponse_lista> lista = null;
	
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

	public List<Npccwwssresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwssresponse_lista> lista) {
		this.lista = lista;
	}
    
}