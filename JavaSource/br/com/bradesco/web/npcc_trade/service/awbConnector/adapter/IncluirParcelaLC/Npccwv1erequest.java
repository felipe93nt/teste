package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 24/06/16 11:10
 */
public class Npccwv1erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV1E-HEADER.NPCCWV1E-COD-LAYOUT")
	private String codlayout = "NPCCWV1E";

	@Adapter(transactionField = "NPCCWV1E-HEADER.NPCCWV1E-TAM-LAYOUT")
	private Integer tamlayout = 2102;

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC.Npccwv1erequest_lista")
	private List<Npccwv1erequest_lista> lista = null;
	
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

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwv1erequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwv1erequest_lista> lista) {
		this.lista = lista;
	}
    
}