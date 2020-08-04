package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/06/16 20:56
 */
public class Npccwxcsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXCS-HEADER.NPCCWXCS-COD-LAYOUT")
	private String codlayout = "NPCCWXCS";

	@Adapter(transactionField = "NPCCWXCS-HEADER.NPCCWXCS-TAM-LAYOUT")
	private Integer tamlayout = 2456;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList.Npccwxcsresponse_listamesa")
	private List<Npccwxcsresponse_listamesa> listamesa = null;
	
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

	public List<Npccwxcsresponse_listamesa> getListamesa() {
		return listamesa;
	}
	public void setListamesa( List<Npccwxcsresponse_listamesa> listamesa) {
		this.listamesa = listamesa;
	}
    
}