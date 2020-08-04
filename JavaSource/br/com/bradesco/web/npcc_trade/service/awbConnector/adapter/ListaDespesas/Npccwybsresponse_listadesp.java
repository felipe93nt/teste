package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/10/16 09:54
 */
public class Npccwybsresponse_listadesp extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-NDESP-BLETO-CMBIO")
	private Long listadesp_ndespbletocmbio = 0L;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-CTPO-DESP-CMBIO")
	private Integer listadesp_ctpodespcmbio = 0;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-NTPO-DESP-CMBIO")
	private String listadesp_ntpodespcmbio = null;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-CIDTFD-RESP-DESP")
	private Integer listadesp_cidtfdrespdesp = 0;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-NIDTFD-RESP-DESP")
	private String listadesp_nidtfdrespdesp = null;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-PDESP-NEGOC-CMBIO")
	private String listadesp_pdespnegoccmbio = null;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-CBASE-BLETO-NEGOC")
	private Integer listadesp_cbasebletonegoc = 0;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-NBASE-BLETO-NEGOC")
	private String listadesp_nbasebletonegoc = null;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-CFLUXO-PERDC-CMBIO")
	private Integer listadesp_cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-NFLUXO-PERDC-CMBIO")
	private String listadesp_nfluxoperdccmbio = null;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-CINDCD-ECONM-MOEDA")
	private Integer listadesp_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-NINDCD-ECONM-MOEDA")
	private String listadesp_nindcdeconmmoeda = null;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-VDESP-BLETO-CMBIO")
	private String listadesp_vdespbletocmbio = null;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-CFORMA-COBR-DESP")
	private Integer listadesp_cformacobrdesp = 0;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-NFORMA-COBR-DESP")
	private String listadesp_nformacobrdesp = null;

	@Adapter(transactionField = "NPCCWYBS-SAIDA.NPCCWYBS-LISTA-DESP.NPCCWYBS-VMIN-DESP-CMBIO")
	private String listadesp_vmindespcmbio = null;
	
	public Long getListadesp_ndespbletocmbio() {
		return listadesp_ndespbletocmbio;
	}
	public void setListadesp_ndespbletocmbio(Long listadesp_ndespbletocmbio) {
		this.listadesp_ndespbletocmbio = listadesp_ndespbletocmbio;
	}

	public Integer getListadesp_ctpodespcmbio() {
		return listadesp_ctpodespcmbio;
	}
	public void setListadesp_ctpodespcmbio(Integer listadesp_ctpodespcmbio) {
		this.listadesp_ctpodespcmbio = listadesp_ctpodespcmbio;
	}

	public String getListadesp_ntpodespcmbio() {
		return listadesp_ntpodespcmbio;
	}
	public void setListadesp_ntpodespcmbio(String listadesp_ntpodespcmbio) {
		this.listadesp_ntpodespcmbio = listadesp_ntpodespcmbio;
	}

	public Integer getListadesp_cidtfdrespdesp() {
		return listadesp_cidtfdrespdesp;
	}
	public void setListadesp_cidtfdrespdesp(Integer listadesp_cidtfdrespdesp) {
		this.listadesp_cidtfdrespdesp = listadesp_cidtfdrespdesp;
	}

	public String getListadesp_nidtfdrespdesp() {
		return listadesp_nidtfdrespdesp;
	}
	public void setListadesp_nidtfdrespdesp(String listadesp_nidtfdrespdesp) {
		this.listadesp_nidtfdrespdesp = listadesp_nidtfdrespdesp;
	}

	public String getListadesp_pdespnegoccmbio() {
		return listadesp_pdespnegoccmbio;
	}
	public void setListadesp_pdespnegoccmbio(String listadesp_pdespnegoccmbio) {
		this.listadesp_pdespnegoccmbio = listadesp_pdespnegoccmbio;
	}

	public Integer getListadesp_cbasebletonegoc() {
		return listadesp_cbasebletonegoc;
	}
	public void setListadesp_cbasebletonegoc(Integer listadesp_cbasebletonegoc) {
		this.listadesp_cbasebletonegoc = listadesp_cbasebletonegoc;
	}

	public String getListadesp_nbasebletonegoc() {
		return listadesp_nbasebletonegoc;
	}
	public void setListadesp_nbasebletonegoc(String listadesp_nbasebletonegoc) {
		this.listadesp_nbasebletonegoc = listadesp_nbasebletonegoc;
	}

	public Integer getListadesp_cfluxoperdccmbio() {
		return listadesp_cfluxoperdccmbio;
	}
	public void setListadesp_cfluxoperdccmbio(Integer listadesp_cfluxoperdccmbio) {
		this.listadesp_cfluxoperdccmbio = listadesp_cfluxoperdccmbio;
	}

	public String getListadesp_nfluxoperdccmbio() {
		return listadesp_nfluxoperdccmbio;
	}
	public void setListadesp_nfluxoperdccmbio(String listadesp_nfluxoperdccmbio) {
		this.listadesp_nfluxoperdccmbio = listadesp_nfluxoperdccmbio;
	}

	public Integer getListadesp_cindcdeconmmoeda() {
		return listadesp_cindcdeconmmoeda;
	}
	public void setListadesp_cindcdeconmmoeda(Integer listadesp_cindcdeconmmoeda) {
		this.listadesp_cindcdeconmmoeda = listadesp_cindcdeconmmoeda;
	}

	public String getListadesp_nindcdeconmmoeda() {
		return listadesp_nindcdeconmmoeda;
	}
	public void setListadesp_nindcdeconmmoeda(String listadesp_nindcdeconmmoeda) {
		this.listadesp_nindcdeconmmoeda = listadesp_nindcdeconmmoeda;
	}

	public String getListadesp_vdespbletocmbio() {
		return listadesp_vdespbletocmbio;
	}
	public void setListadesp_vdespbletocmbio(String listadesp_vdespbletocmbio) {
		this.listadesp_vdespbletocmbio = listadesp_vdespbletocmbio;
	}

	public Integer getListadesp_cformacobrdesp() {
		return listadesp_cformacobrdesp;
	}
	public void setListadesp_cformacobrdesp(Integer listadesp_cformacobrdesp) {
		this.listadesp_cformacobrdesp = listadesp_cformacobrdesp;
	}

	public String getListadesp_nformacobrdesp() {
		return listadesp_nformacobrdesp;
	}
	public void setListadesp_nformacobrdesp(String listadesp_nformacobrdesp) {
		this.listadesp_nformacobrdesp = listadesp_nformacobrdesp;
	}

	public String getListadesp_vmindespcmbio() {
		return listadesp_vmindespcmbio;
	}
	public void setListadesp_vmindespcmbio(String listadesp_vmindespcmbio) {
		this.listadesp_vmindespcmbio = listadesp_vmindespcmbio;
	}
    
}