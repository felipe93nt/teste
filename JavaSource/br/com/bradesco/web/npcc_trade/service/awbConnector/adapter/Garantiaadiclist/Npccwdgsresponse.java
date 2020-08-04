package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 09/04/18 11:48
 */
public class Npccwdgsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWDGS-HEADER.NPCCWDGS-COD-LAYOUT")
	private String codlayout = "NPCCWDGS";

	@Adapter(transactionField = "NPCCWDGS-HEADER.NPCCWDGS-TAM-LAYOUT")
	private Integer tamlayout = 3296;

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist.Npccwdgsresponse_lista")
	private List<Npccwdgsresponse_lista> lista = null;
	
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

	public List<Npccwdgsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwdgsresponse_lista> lista) {
		this.lista = lista;
	}
    
}