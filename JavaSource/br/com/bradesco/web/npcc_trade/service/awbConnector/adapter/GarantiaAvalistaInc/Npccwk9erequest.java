package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/03/16 11:16
 */
public class Npccwk9erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK9E-HEADER.NPCCWK9E-COD-LAYOUT")
	private String codlayout = "NPCCWK9E";

	@Adapter(transactionField = "NPCCWK9E-HEADER.NPCCWK9E-TAM-LAYOUT")
	private Integer tamlayout = 25;

	@Adapter(transactionField = "NPCCWK9E-REGISTRO.NPCCWK9E-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWK9E-REGISTRO.NPCCWK9E-CTPO-VNCLO-CMBIO")
	private Integer ctpovnclocmbio = 0;
	
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

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	public Integer getCtpovnclocmbio() {
		return ctpovnclocmbio;
	}
	public void setCtpovnclocmbio(Integer ctpovnclocmbio) {
		this.ctpovnclocmbio = ctpovnclocmbio;
	}
    
}