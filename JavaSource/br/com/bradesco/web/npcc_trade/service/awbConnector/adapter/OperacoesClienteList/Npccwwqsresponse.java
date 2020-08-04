package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 06/10/16 10:30
 */
public class Npccwwqsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWQS-HEADER.NPCCWWQS-COD-LAYOUT")
	private String codlayout = "NPCCWWQS";

	@Adapter(transactionField = "NPCCWWQS-HEADER.NPCCWWQS-TAM-LAYOUT")
	private Integer tamlayout = 8666;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Npccwwqsresponse_lista")
	private List<Npccwwqsresponse_lista> lista = null;
	
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

	public List<Npccwwqsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwqsresponse_lista> lista) {
		this.lista = lista;
	}
    
}