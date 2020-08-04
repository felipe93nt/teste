package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConvVlrPraMoedaLimit;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/01/16 14:08
 */
public class Npccwwzerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWZE-HEADER.NPCCWWZE-COD-LAYOUT")
	private String codlayout = "NPCCWWZE";

	@Adapter(transactionField = "NPCCWWZE-HEADER.NPCCWWZE-TAM-LAYOUT")
	private Integer tamlayout = 60;

	@Adapter(transactionField = "NPCCWWZE-REGISTRO.NPCCWWZE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWZE-REGISTRO.NPCCWWZE-DFCHTO-BLETO-CMBIO")
	private String dfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWWZE-REGISTRO.NPCCWWZE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWWZE-REGISTRO.NPCCWWZE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWWZE-REGISTRO.NPCCWWZE-CECONM-MOEDA-LIM")
	private Integer ceconmmoedalim = 0;
	
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

	public String getDfchtobletocmbio() {
		return dfchtobletocmbio;
	}
	public void setDfchtobletocmbio(String dfchtobletocmbio) {
		this.dfchtobletocmbio = dfchtobletocmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

	public Integer getCeconmmoedalim() {
		return ceconmmoedalim;
	}
	public void setCeconmmoedalim(Integer ceconmmoedalim) {
		this.ceconmmoedalim = ceconmmoedalim;
	}
    
}