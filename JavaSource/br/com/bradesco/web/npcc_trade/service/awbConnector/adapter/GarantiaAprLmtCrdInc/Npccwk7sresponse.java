package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 04/04/18 15:27
 */
public class Npccwk7sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK7S-HEADER.NPCCWK7S-COD-LAYOUT")
	private String codlayout = "NPCCWK7S";

	@Adapter(transactionField = "NPCCWK7S-HEADER.NPCCWK7S-TAM-LAYOUT")
	private Integer tamlayout = 2696;

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc.Npccwk7sresponse_lista")
	private List<Npccwk7sresponse_lista> lista = null;
	
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

	public List<Npccwk7sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwk7sresponse_lista> lista) {
		this.lista = lista;
	}
    
}