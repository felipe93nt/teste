package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarOperacoes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 27/07/18 17:40
 */
public class Npcdwnzsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWNZS-HEADER.NPCDWNZS-COD-LAYOUT")
	private String codlayout = "NPCDWNZS";

	@Adapter(transactionField = "NPCDWNZS-HEADER.NPCDWNZS-TAM-LAYOUT")
	private Integer tamlayout = 2616;

	@Adapter(transactionField = "NPCDWNZS-REGISTRO.NPCDWNZS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWNZS-REGISTRO.NPCDWNZS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarOperacoes.Npcdwnzsresponse_lista")
	private List<Npcdwnzsresponse_lista> lista = null;
	
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

	public List<Npcdwnzsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npcdwnzsresponse_lista> lista) {
		this.lista = lista;
	}
    
}