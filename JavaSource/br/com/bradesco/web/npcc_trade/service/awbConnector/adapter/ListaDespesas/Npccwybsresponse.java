package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 27/10/16 09:54
 */
public class Npccwybsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYBS-HEADER.NPCCWYBS-COD-LAYOUT")
	private String codlayout = "NPCCWYBS";

	@Adapter(transactionField = "NPCCWYBS-HEADER.NPCCWYBS-TAM-LAYOUT")
	private Integer tamlayout = 3616;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas.Npccwybsresponse_listadesp")
	private List<Npccwybsresponse_listadesp> listadesp = null;
	
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

	public List<Npccwybsresponse_listadesp> getListadesp() {
		return listadesp;
	}
	public void setListadesp( List<Npccwybsresponse_listadesp> listadesp) {
		this.listadesp = listadesp;
	}
    
}