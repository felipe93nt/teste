package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 16/05/16 14:07
 */
public class Npccwnzsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWNZS-HEADER.NPCCWNZS-COD-LAYOUT")
	private String codlayout = "NPCCWNZS";

	@Adapter(transactionField = "NPCCWNZS-HEADER.NPCCWNZS-TAM-LAYOUT")
	private Integer tamlayout = 1736;

	@Adapter(transactionField = "NPCCWNZS-REGISTRO.NPCCWNZS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWNZS-REGISTRO.NPCCWNZS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex.Npccwnzsresponse_lista")
	private List<Npccwnzsresponse_lista> lista = null;
	
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

	public List<Npccwnzsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwnzsresponse_lista> lista) {
		this.lista = lista;
	}
    
}