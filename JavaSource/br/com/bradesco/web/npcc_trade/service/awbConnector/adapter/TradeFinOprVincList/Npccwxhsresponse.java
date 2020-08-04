package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 11/11/16 10:41
 */
public class Npccwxhsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXHS-HEADER.NPCCWXHS-COD-LAYOUT")
	private String codlayout = "NPCCWXHS";

	@Adapter(transactionField = "NPCCWXHS-HEADER.NPCCWXHS-TAM-LAYOUT")
	private Integer tamlayout = 3296;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList.Npccwxhsresponse_lista")
	private List<Npccwxhsresponse_lista> lista = null;
	
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

	public List<Npccwxhsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxhsresponse_lista> lista) {
		this.lista = lista;
	}
    
}