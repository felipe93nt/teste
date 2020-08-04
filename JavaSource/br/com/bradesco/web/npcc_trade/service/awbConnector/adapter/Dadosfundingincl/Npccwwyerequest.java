package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl;

import java.util.List;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 14:05
 */
public class Npccwwyerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWYE-HEADER.NPCCWWYE-COD-LAYOUT")
	private String codlayout = "NPCCWWYE";

	@Adapter(transactionField = "NPCCWWYE-HEADER.NPCCWWYE-TAM-LAYOUT")
	private Integer tamlayout = 890;

	@Adapter(transactionField = "NPCCWWYE-REGISTRO.NPCCWWYE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWYE-REGISTRO.NPCCWWYE-CINDCD-MOEDA-OPER")
	private Integer cindcdmoedaoper = 0;

	@Adapter(transactionField = "NPCCWWYE-REGISTRO.NPCCWWYE-VFNDNG-NEGOC-CMBIO")
	private String vfndngnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWYE-REGISTRO.NPCCWWYE-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWYE-REGISTRO.NPCCWWYE-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl.Npccwwyerequest_lista")
	private List<Npccwwyerequest_lista> lista = null;
	
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

	public Integer getCindcdmoedaoper() {
		return cindcdmoedaoper;
	}
	public void setCindcdmoedaoper(Integer cindcdmoedaoper) {
		this.cindcdmoedaoper = cindcdmoedaoper;
	}

	public String getVfndngnegoccmbio() {
		return vfndngnegoccmbio;
	}
	public void setVfndngnegoccmbio(String vfndngnegoccmbio) {
		this.vfndngnegoccmbio = vfndngnegoccmbio;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwwyerequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwyerequest_lista> lista) {
		this.lista = lista;
	}
    
}