package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/10/15 10:02
 */
public class Npcdwaasresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWAAS-HEADER.NPCDWAAS-COD-LAYOUT")
	private String codlayout = "NPCDWAAS";

	@Adapter(transactionField = "NPCDWAAS-HEADER.NPCDWAAS-TAM-LAYOUT")
	private Integer tamlayout = 18896;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoList.Npcdwaasresponse_lista")
	private List<Npcdwaasresponse_lista> lista = null;
	
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

	public List<Npcdwaasresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npcdwaasresponse_lista> lista) {
		this.lista = lista;
	}
    
}