package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 21/01/16 11:22
 */
public class Npcdwemsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEMS-HEADER.NPCDWEMS-COD-LAYOUT")
	private String codlayout = "NPCDWEMS";

	@Adapter(transactionField = "NPCDWEMS-HEADER.NPCDWEMS-TAM-LAYOUT")
	private Integer tamlayout = 8016;

	@Adapter(transactionField = "NPCDWEMS-REGISTRO.NPCDWEMS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWEMS-REGISTRO.NPCDWEMS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList.Npcdwemsresponse_lista")
	private List<Npcdwemsresponse_lista> lista = null;
	
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

	public List<Npcdwemsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npcdwemsresponse_lista> lista) {
		this.lista = lista;
	}
    
}