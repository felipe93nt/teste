package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 30/03/16 14:37
 */
public class Npccwiesresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIES-HEADER.NPCCWIES-COD-LAYOUT")
	private String codlayout = "NPCCWIES";

	@Adapter(transactionField = "NPCCWIES-HEADER.NPCCWIES-TAM-LAYOUT")
	private Integer tamlayout = 3316;

	@Adapter(transactionField = "NPCCWIES-REGISTRO.NPCCWIES-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWIES-REGISTRO.NPCCWIES-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas.Npccwiesresponse_lista")
	private List<Npccwiesresponse_lista> lista = null;
	
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

	public List<Npccwiesresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwiesresponse_lista> lista) {
		this.lista = lista;
	}
    
}