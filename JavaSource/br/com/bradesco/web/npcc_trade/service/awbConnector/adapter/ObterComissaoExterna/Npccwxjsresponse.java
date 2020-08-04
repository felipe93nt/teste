package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:44
 */
public class Npccwxjsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXJS-HEADER.NPCCWXJS-COD-LAYOUT")
	private String codlayout = "NPCCWXJS";

	@Adapter(transactionField = "NPCCWXJS-HEADER.NPCCWXJS-TAM-LAYOUT")
	private Integer tamlayout = 3056;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna.Npccwxjsresponse_lista")
	private List<Npccwxjsresponse_lista> lista = null;
	
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

	public List<Npccwxjsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxjsresponse_lista> lista) {
		this.lista = lista;
	}
    
}