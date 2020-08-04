package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 15/06/18 10:50
 */
public class Npccwvnerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVNE-HEADER.NPCCWVNE-COD-LAYOUT")
	private String codlayout = "NPCCWVNE";

	@Adapter(transactionField = "NPCCWVNE-HEADER.NPCCWVNE-TAM-LAYOUT")
	private Integer tamlayout = 488;

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-IMOD-CONTR-CMBIO")
	private String imodcontrcmbio = null;

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-CMODLD-PRODT-CMBIO")
	private Integer cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-CINDCD-MOD-PDRAO")
	private String cindcdmodpdrao = null;

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVNE-REGISTRO.NPCCWVNE-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoIncl.Npccwvnerequest_lista")
	private List<Npccwvnerequest_lista> lista = null;
	
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

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getImodcontrcmbio() {
		return imodcontrcmbio;
	}
	public void setImodcontrcmbio(String imodcontrcmbio) {
		this.imodcontrcmbio = imodcontrcmbio;
	}

	public Integer getCmodldprodtcmbio() {
		return cmodldprodtcmbio;
	}
	public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
		this.cmodldprodtcmbio = cmodldprodtcmbio;
	}

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
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

	public List<Npccwvnerequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvnerequest_lista> lista) {
		this.lista = lista;
	}
    
}