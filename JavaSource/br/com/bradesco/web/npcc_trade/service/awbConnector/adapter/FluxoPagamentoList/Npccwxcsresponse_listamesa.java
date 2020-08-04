package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 20:56
 */
public class Npccwxcsresponse_listamesa extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-NDSEMB-CMBIO-TRADE")
	private Integer listamesa_ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-DPREVT-DSEMB-CMBIO")
	private String listamesa_dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-TDIA-FINAN-DSEMB")
	private Integer listamesa_tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-VPREVT-DSEMB-CMBIO")
	private String listamesa_vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-TDIA-CAREN-PRINC")
	private Integer listamesa_tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-CFLUXO-LIQDC-PRINC")
	private Integer listamesa_cfluxoliqdcprinc = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-DFLUXO-LIQDC-PRINC")
	private String listamesa_dfluxoliqdcprinc = null;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-QPCELA-TRADE-PRINC")
	private Integer listamesa_qpcelatradeprinc = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-TDIA-CAREN-JURO")
	private Integer listamesa_tdiacarenjuro = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-CFLUXO-LIQDC-JURO")
	private Integer listamesa_cfluxoliqdcjuro = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-DFLUXO-LIQDC-JURO")
	private String listamesa_dfluxoliqdcjuro = null;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-QPCELA-TRADE-JURO")
	private Integer listamesa_qpcelatradejuro = 0;

	@Adapter(transactionField = "NPCCWXCS-REGISTRO.NPCCWXCS-LISTA-MESA.NPCCWXCS-CMOMEN-COBR-CMBIO")
	private Integer listamesa_cmomencobrcmbio = 0;
	
	public Integer getListamesa_ndsembcmbiotrade() {
		return listamesa_ndsembcmbiotrade;
	}
	public void setListamesa_ndsembcmbiotrade(Integer listamesa_ndsembcmbiotrade) {
		this.listamesa_ndsembcmbiotrade = listamesa_ndsembcmbiotrade;
	}

	public String getListamesa_dprevtdsembcmbio() {
		return listamesa_dprevtdsembcmbio;
	}
	public void setListamesa_dprevtdsembcmbio(String listamesa_dprevtdsembcmbio) {
		this.listamesa_dprevtdsembcmbio = listamesa_dprevtdsembcmbio;
	}

	public Integer getListamesa_tdiafinandsemb() {
		return listamesa_tdiafinandsemb;
	}
	public void setListamesa_tdiafinandsemb(Integer listamesa_tdiafinandsemb) {
		this.listamesa_tdiafinandsemb = listamesa_tdiafinandsemb;
	}

	public String getListamesa_vprevtdsembcmbio() {
		return listamesa_vprevtdsembcmbio;
	}
	public void setListamesa_vprevtdsembcmbio(String listamesa_vprevtdsembcmbio) {
		this.listamesa_vprevtdsembcmbio = listamesa_vprevtdsembcmbio;
	}

	public Integer getListamesa_tdiacarenprinc() {
		return listamesa_tdiacarenprinc;
	}
	public void setListamesa_tdiacarenprinc(Integer listamesa_tdiacarenprinc) {
		this.listamesa_tdiacarenprinc = listamesa_tdiacarenprinc;
	}

	public Integer getListamesa_cfluxoliqdcprinc() {
		return listamesa_cfluxoliqdcprinc;
	}
	public void setListamesa_cfluxoliqdcprinc(Integer listamesa_cfluxoliqdcprinc) {
		this.listamesa_cfluxoliqdcprinc = listamesa_cfluxoliqdcprinc;
	}

	public String getListamesa_dfluxoliqdcprinc() {
		return listamesa_dfluxoliqdcprinc;
	}
	public void setListamesa_dfluxoliqdcprinc(String listamesa_dfluxoliqdcprinc) {
		this.listamesa_dfluxoliqdcprinc = listamesa_dfluxoliqdcprinc;
	}

	public Integer getListamesa_qpcelatradeprinc() {
		return listamesa_qpcelatradeprinc;
	}
	public void setListamesa_qpcelatradeprinc(Integer listamesa_qpcelatradeprinc) {
		this.listamesa_qpcelatradeprinc = listamesa_qpcelatradeprinc;
	}

	public Integer getListamesa_tdiacarenjuro() {
		return listamesa_tdiacarenjuro;
	}
	public void setListamesa_tdiacarenjuro(Integer listamesa_tdiacarenjuro) {
		this.listamesa_tdiacarenjuro = listamesa_tdiacarenjuro;
	}

	public Integer getListamesa_cfluxoliqdcjuro() {
		return listamesa_cfluxoliqdcjuro;
	}
	public void setListamesa_cfluxoliqdcjuro(Integer listamesa_cfluxoliqdcjuro) {
		this.listamesa_cfluxoliqdcjuro = listamesa_cfluxoliqdcjuro;
	}

	public String getListamesa_dfluxoliqdcjuro() {
		return listamesa_dfluxoliqdcjuro;
	}
	public void setListamesa_dfluxoliqdcjuro(String listamesa_dfluxoliqdcjuro) {
		this.listamesa_dfluxoliqdcjuro = listamesa_dfluxoliqdcjuro;
	}

	public Integer getListamesa_qpcelatradejuro() {
		return listamesa_qpcelatradejuro;
	}
	public void setListamesa_qpcelatradejuro(Integer listamesa_qpcelatradejuro) {
		this.listamesa_qpcelatradejuro = listamesa_qpcelatradejuro;
	}

	public Integer getListamesa_cmomencobrcmbio() {
		return listamesa_cmomencobrcmbio;
	}
	public void setListamesa_cmomencobrcmbio(Integer listamesa_cmomencobrcmbio) {
		this.listamesa_cmomencobrcmbio = listamesa_cmomencobrcmbio;
	}
    
}