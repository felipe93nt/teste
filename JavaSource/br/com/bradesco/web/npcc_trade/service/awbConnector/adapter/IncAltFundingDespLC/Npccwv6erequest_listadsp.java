package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 08/11/16 15:05
 */
public class Npccwv6erequest_listadsp extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-NDESP-BLETO-CMBIO")
	private Long listadsp_ndespbletocmbio = 0L;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-CTPO-DESP-CMBIO")
	private Integer listadsp_ctpodespcmbio = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-CFLUXO-PERDC-CMBIO")
	private Integer listadsp_cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-CIDTFD-RESP-DESP")
	private Integer listadsp_cidtfdrespdesp = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-VDESP-BLETO-CMBIO")
	private String listadsp_vdespbletocmbio = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-PDESP-NEGOC-CMBIO")
	private String listadsp_pdespnegoccmbio = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-CBASE-BLETO-NEGOC")
	private Integer listadsp_cbasebletonegoc = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-CINDCD-ECONM-MOEDA")
	private Integer listadsp_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-VMIN-DESP-CMBIO")
	private String listadsp_vmindespcmbio = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP.NPCCWV6E-CFORMA-COBR-DESP")
	private Integer listadsp_cformacobrdesp = 0;
	
	public Long getListadsp_ndespbletocmbio() {
		return listadsp_ndespbletocmbio;
	}
	public void setListadsp_ndespbletocmbio(Long listadsp_ndespbletocmbio) {
		this.listadsp_ndespbletocmbio = listadsp_ndespbletocmbio;
	}

	public Integer getListadsp_ctpodespcmbio() {
		return listadsp_ctpodespcmbio;
	}
	public void setListadsp_ctpodespcmbio(Integer listadsp_ctpodespcmbio) {
		this.listadsp_ctpodespcmbio = listadsp_ctpodespcmbio;
	}

	public Integer getListadsp_cfluxoperdccmbio() {
		return listadsp_cfluxoperdccmbio;
	}
	public void setListadsp_cfluxoperdccmbio(Integer listadsp_cfluxoperdccmbio) {
		this.listadsp_cfluxoperdccmbio = listadsp_cfluxoperdccmbio;
	}

	public Integer getListadsp_cidtfdrespdesp() {
		return listadsp_cidtfdrespdesp;
	}
	public void setListadsp_cidtfdrespdesp(Integer listadsp_cidtfdrespdesp) {
		this.listadsp_cidtfdrespdesp = listadsp_cidtfdrespdesp;
	}

	public String getListadsp_vdespbletocmbio() {
		return listadsp_vdespbletocmbio;
	}
	public void setListadsp_vdespbletocmbio(String listadsp_vdespbletocmbio) {
		this.listadsp_vdespbletocmbio = listadsp_vdespbletocmbio;
	}

	public String getListadsp_pdespnegoccmbio() {
		return listadsp_pdespnegoccmbio;
	}
	public void setListadsp_pdespnegoccmbio(String listadsp_pdespnegoccmbio) {
		this.listadsp_pdespnegoccmbio = listadsp_pdespnegoccmbio;
	}

	public Integer getListadsp_cbasebletonegoc() {
		return listadsp_cbasebletonegoc;
	}
	public void setListadsp_cbasebletonegoc(Integer listadsp_cbasebletonegoc) {
		this.listadsp_cbasebletonegoc = listadsp_cbasebletonegoc;
	}

	public Integer getListadsp_cindcdeconmmoeda() {
		return listadsp_cindcdeconmmoeda;
	}
	public void setListadsp_cindcdeconmmoeda(Integer listadsp_cindcdeconmmoeda) {
		this.listadsp_cindcdeconmmoeda = listadsp_cindcdeconmmoeda;
	}

	public String getListadsp_vmindespcmbio() {
		return listadsp_vmindespcmbio;
	}
	public void setListadsp_vmindespcmbio(String listadsp_vmindespcmbio) {
		this.listadsp_vmindespcmbio = listadsp_vmindespcmbio;
	}

	public Integer getListadsp_cformacobrdesp() {
		return listadsp_cformacobrdesp;
	}
	public void setListadsp_cformacobrdesp(Integer listadsp_cformacobrdesp) {
		this.listadsp_cformacobrdesp = listadsp_cformacobrdesp;
	}
    
}