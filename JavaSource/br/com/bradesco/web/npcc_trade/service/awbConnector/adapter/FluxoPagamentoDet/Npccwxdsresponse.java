package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 22/08/16 14:53
 */
public class Npccwxdsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXDS-HEADER.NPCCWXDS-COD-LAYOUT")
	private String codlayout = "NPCCWXDS";

	@Adapter(transactionField = "NPCCWXDS-HEADER.NPCCWXDS-TAM-LAYOUT")
	private Integer tamlayout = 7560;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-PRZO-MEDIO-DSEMB")
	private Integer przomediodsemb = 0;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet.Npccwxdsresponse_lista")
	private List<Npccwxdsresponse_lista> lista = null;
	
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

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}
	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}

	public Integer getPrzomediodsemb() {
		return przomediodsemb;
	}
	public void setPrzomediodsemb(Integer przomediodsemb) {
		this.przomediodsemb = przomediodsemb;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwxdsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxdsresponse_lista> lista) {
		this.lista = lista;
	}
    
}