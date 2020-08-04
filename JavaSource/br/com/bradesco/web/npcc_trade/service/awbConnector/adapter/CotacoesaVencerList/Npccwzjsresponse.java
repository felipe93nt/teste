package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 24/11/17 16:31
 */
public class Npccwzjsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZJS-HEADER.NPCCWZJS-COD-LAYOUT")
	private String codlayout = "NPCCWZJS";

	@Adapter(transactionField = "NPCCWZJS-HEADER.NPCCWZJS-TAM-LAYOUT")
	private Integer tamlayout = 14268;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList.Npccwzjsresponse_lista")
	private List<Npccwzjsresponse_lista> lista = null;
	
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

	public List<Npccwzjsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwzjsresponse_lista> lista) {
		this.lista = lista;
	}
    
}