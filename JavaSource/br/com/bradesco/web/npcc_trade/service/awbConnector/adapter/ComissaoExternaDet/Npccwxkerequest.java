package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:25
 */
public class Npccwxkerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXKE-HEADER.NPCCWXKE-COD-LAYOUT")
	private String codlayout = "NPCCWXKE";

	@Adapter(transactionField = "NPCCWXKE-HEADER.NPCCWXKE-TAM-LAYOUT")
	private Integer tamlayout = 54;

	@Adapter(transactionField = "NPCCWXKE-REGISTRO.NPCCWXKE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXKE-REGISTRO.NPCCWXKE-NCOMIS-EXTER-TRADE")
	private Integer ncomisextertrade = 0;

	@Adapter(transactionField = "NPCCWXKE-REGISTRO.NPCCWXKE-HINCL-REG-HIST")
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

	public Integer getNcomisextertrade() {
		return ncomisextertrade;
	}
	public void setNcomisextertrade(Integer ncomisextertrade) {
		this.ncomisextertrade = ncomisextertrade;
	}

	public String getHinclreghist() {
		return hinclreghist;
	}
	public void setHinclreghist(String hinclreghist) {
		this.hinclreghist = hinclreghist;
	}
    
}