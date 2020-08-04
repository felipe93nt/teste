package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 07/12/15 17:42
 */
public class Npccwvgsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVGS-HEADER.NPCCWVGS-COD-LAYOUT")
	private String codlayout = "NPCCWVGS";

	@Adapter(transactionField = "NPCCWVGS-HEADER.NPCCWVGS-TAM-LAYOUT")
	private Integer tamlayout = 21051;

	@Adapter(transactionField = "NPCCWVGS-REGISTRO.NPCCWVGS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVGS-REGISTRO.NPCCWVGS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList.Npccwvgsresponse_lista")
	private List<Npccwvgsresponse_lista> lista = null;
	
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

	public List<Npccwvgsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvgsresponse_lista> lista) {
		this.lista = lista;
	}
    
}