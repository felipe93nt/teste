package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 10/03/17 13:31
 */
public class Npccwk8sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK8S-HEADER.NPCCWK8S-COD-LAYOUT")
	private String codlayout = "NPCCWK8S";

	@Adapter(transactionField = "NPCCWK8S-HEADER.NPCCWK8S-TAM-LAYOUT")
	private Integer tamlayout = 2776;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred.Npccwk8sresponse_lista")
	private List<Npccwk8sresponse_lista> lista = null;
	
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

	public List<Npccwk8sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwk8sresponse_lista> lista) {
		this.lista = lista;
	}
    
}