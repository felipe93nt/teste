package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:04
 */
public class Npccwxferequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXFE-HEADER.NPCCWXFE-COD-LAYOUT")
	private String codlayout = "NPCCWXFE";

	@Adapter(transactionField = "NPCCWXFE-HEADER.NPCCWXFE-TAM-LAYOUT")
	private Integer tamlayout = 54;

	@Adapter(transactionField = "NPCCWXFE-REGISTRO.NPCCWXFE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXFE-REGISTRO.NPCCWXFE-NCOMIS-INTRN-TRADE")
	private Integer ncomisintrntrade = 0;

	@Adapter(transactionField = "NPCCWXFE-REGISTRO.NPCCWXFE-HINCL-REG-HIST")
	private String hinclreghist = null;
	
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

	public Integer getNcomisintrntrade() {
		return ncomisintrntrade;
	}
	public void setNcomisintrntrade(Integer ncomisintrntrade) {
		this.ncomisintrntrade = ncomisintrntrade;
	}

	public String getHinclreghist() {
		return hinclreghist;
	}
	public void setHinclreghist(String hinclreghist) {
		this.hinclreghist = hinclreghist;
	}
    
}