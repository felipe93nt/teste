package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DataLimitCotacaoCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/04/16 11:04
 */
public class Npccwhferequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWHFE-HEADER.NPCCWHFE-COD-LAYOUT")
	private String codlayout = "NPCCWHFE";

	@Adapter(transactionField = "NPCCWHFE-HEADER.NPCCWHFE-TAM-LAYOUT")
	private Integer tamlayout = 40;

	@Adapter(transactionField = "NPCCWHFE-REGISTRO.NPCCWADE-DFCHTO-BLETO")
	private String dfchtobleto = null;

	@Adapter(transactionField = "NPCCWHFE-REGISTRO.NPCCWHFE-TDIA-LIQDC")
	private Integer tdialiqdc = 0;

	@Adapter(transactionField = "NPCCWHFE-REGISTRO.NPCCWHFE-DLIQDC-CMBIO")
	private String dliqdccmbio = null;

	@Adapter(transactionField = "NPCCWHFE-REGISTRO.NPCCWHFE-CTPO-LIQDC")
	private Integer ctpoliqdc = 0;
	
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

	public String getDfchtobleto() {
		return dfchtobleto;
	}
	public void setDfchtobleto(String dfchtobleto) {
		this.dfchtobleto = dfchtobleto;
	}

	public Integer getTdialiqdc() {
		return tdialiqdc;
	}
	public void setTdialiqdc(Integer tdialiqdc) {
		this.tdialiqdc = tdialiqdc;
	}

	public String getDliqdccmbio() {
		return dliqdccmbio;
	}
	public void setDliqdccmbio(String dliqdccmbio) {
		this.dliqdccmbio = dliqdccmbio;
	}

	public Integer getCtpoliqdc() {
		return ctpoliqdc;
	}
	public void setCtpoliqdc(Integer ctpoliqdc) {
		this.ctpoliqdc = ctpoliqdc;
	}
    
}