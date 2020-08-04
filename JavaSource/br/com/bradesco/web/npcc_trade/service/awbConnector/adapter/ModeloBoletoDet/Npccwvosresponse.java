package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 03/07/18 11:13
 */
public class Npccwvosresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVOS-HEADER.NPCCWVOS-COD-LAYOUT")
	private String codlayout = "NPCCWVOS";

	@Adapter(transactionField = "NPCCWVOS-HEADER.NPCCWVOS-TAM-LAYOUT")
	private Integer tamlayout = 21710;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-IMOD-CONTR-CMBIO")
	private String imodcontrcmbio = null;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-CINDCD-MOD-PDRAO")
	private String cindcdmodpdrao = null;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Npccwvosresponse_lista")
	private List<Npccwvosresponse_lista> lista = null;
	
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

	public Integer getCmodcontrcmbio() {
		return cmodcontrcmbio;
	}
	public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
		this.cmodcontrcmbio = cmodcontrcmbio;
	}

	public String getImodcontrcmbio() {
		return imodcontrcmbio;
	}
	public void setImodcontrcmbio(String imodcontrcmbio) {
		this.imodcontrcmbio = imodcontrcmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getCindcdmodpdrao() {
		return cindcdmodpdrao;
	}
	public void setCindcdmodpdrao(String cindcdmodpdrao) {
		this.cindcdmodpdrao = cindcdmodpdrao;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwvosresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvosresponse_lista> lista) {
		this.lista = lista;
	}
    
}