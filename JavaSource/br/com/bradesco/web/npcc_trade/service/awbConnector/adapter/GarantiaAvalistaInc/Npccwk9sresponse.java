package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 22/03/16 11:16
 */
public class Npccwk9sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK9S-HEADER.NPCCWK9S-COD-LAYOUT")
	private String codlayout = "NPCCWK9S";

	@Adapter(transactionField = "NPCCWK9S-HEADER.NPCCWK9S-TAM-LAYOUT")
	private Integer tamlayout = 3396;

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc.Npccwk9sresponse_lista")
	private List<Npccwk9sresponse_lista> lista = null;
	
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

	public List<Npccwk9sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwk9sresponse_lista> lista) {
		this.lista = lista;
	}
    
}