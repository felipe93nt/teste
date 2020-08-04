package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/03/16 18:33
 */
public class Npccwmhsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMHS-HEADER.NPCCWMHS-COD-LAYOUT")
	private String codlayout = "NPCCWMHS";

	@Adapter(transactionField = "NPCCWMHS-HEADER.NPCCWMHS-TAM-LAYOUT")
	private Integer tamlayout = 9016;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList.Npccwmhsresponse_lista")
	private List<Npccwmhsresponse_lista> lista = null;
	
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

	public List<Npccwmhsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwmhsresponse_lista> lista) {
		this.lista = lista;
	}
    
}