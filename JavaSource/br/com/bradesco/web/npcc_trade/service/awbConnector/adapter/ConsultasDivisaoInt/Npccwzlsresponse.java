package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 29/08/16 17:35
 */
public class Npccwzlsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZLS-HEADER.NPCCWZLS-COD-LAYOUT")
	private String codlayout = "NPCCWZLS";

	@Adapter(transactionField = "NPCCWZLS-HEADER.NPCCWZLS-TAM-LAYOUT")
	private Integer tamlayout = 7699;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-QTDE-OCOR2")
	private Integer qtdeocor2 = 0;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt.Npccwzlsresponse_lista")
	private List<Npccwzlsresponse_lista> lista = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA2", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt.Npccwzlsresponse_lista2")
	private List<Npccwzlsresponse_lista2> lista2 = null;
	
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

	public Integer getQtdeocor2() {
		return qtdeocor2;
	}
	public void setQtdeocor2(Integer qtdeocor2) {
		this.qtdeocor2 = qtdeocor2;
	}

	public List<Npccwzlsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwzlsresponse_lista> lista) {
		this.lista = lista;
	}

	public List<Npccwzlsresponse_lista2> getLista2() {
		return lista2;
	}
	public void setLista2( List<Npccwzlsresponse_lista2> lista2) {
		this.lista2 = lista2;
	}
    
}