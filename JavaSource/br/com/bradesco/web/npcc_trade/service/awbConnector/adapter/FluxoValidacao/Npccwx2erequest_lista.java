package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/11/18 23:58
 */
public class Npccwx2erequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-CINDCD-PCOBR-PRINC")
	private Integer lista_cindcdpcobrprinc = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-VPREVT-DSEMB-CMBIO")
	private String lista_vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-DPREVT-DSEMB-CMBIO")
	private String lista_dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-CFLUXO-LIQDC-PRINC")
	private Integer lista_cfluxoliqdcprinc = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-CFLUXO-LIQDC-JURO")
	private Integer lista_cfluxoliqdcjuro = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-TDIA-CAREN-PRINC")
	private Integer lista_tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-TDIA-CAREN-JURO")
	private Integer lista_tdiacarenjuro = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-QPCELA-TRADE-PRINC")
	private Integer lista_qpcelatradeprinc = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-QPCELA-TRADE-JURO")
	private Integer lista_qpcelatradejuro = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-CMOMEN-COBR-CMBIO")
	private Integer lista_cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-NDSEMB-CMBIO-TRADE")
	private Integer lista_ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-VTX-LIBOR-CMBIO")
	private String lista_vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-PTX-JURO-FNDNG")
	private String lista_ptxjurofndng = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-PJURO-NEGOC-CMBIO")
	private String lista_pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-PSPREAD-TX-CMBIO")
	private String lista_pspreadtxcmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-TDIA-FINAN-DSEMB1")
	private Integer lista_tdiafinandsemb1 = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-VJURO-DSEMB-CMBIO")
	private String lista_vjurodsembcmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA.NPCCWX2E-VDSEMB-NEGOC-CMBIO")
	private String lista_vdsembnegoccmbio = null;
	
	public Integer getLista_cindcdpcobrprinc() {
		return lista_cindcdpcobrprinc;
	}
	public void setLista_cindcdpcobrprinc(Integer lista_cindcdpcobrprinc) {
		this.lista_cindcdpcobrprinc = lista_cindcdpcobrprinc;
	}

	public String getLista_vprevtdsembcmbio() {
		return lista_vprevtdsembcmbio;
	}
	public void setLista_vprevtdsembcmbio(String lista_vprevtdsembcmbio) {
		this.lista_vprevtdsembcmbio = lista_vprevtdsembcmbio;
	}

	public String getLista_dprevtdsembcmbio() {
		return lista_dprevtdsembcmbio;
	}
	public void setLista_dprevtdsembcmbio(String lista_dprevtdsembcmbio) {
		this.lista_dprevtdsembcmbio = lista_dprevtdsembcmbio;
	}

	public Integer getLista_cfluxoliqdcprinc() {
		return lista_cfluxoliqdcprinc;
	}
	public void setLista_cfluxoliqdcprinc(Integer lista_cfluxoliqdcprinc) {
		this.lista_cfluxoliqdcprinc = lista_cfluxoliqdcprinc;
	}

	public Integer getLista_cfluxoliqdcjuro() {
		return lista_cfluxoliqdcjuro;
	}
	public void setLista_cfluxoliqdcjuro(Integer lista_cfluxoliqdcjuro) {
		this.lista_cfluxoliqdcjuro = lista_cfluxoliqdcjuro;
	}

	public Integer getLista_tdiacarenprinc() {
		return lista_tdiacarenprinc;
	}
	public void setLista_tdiacarenprinc(Integer lista_tdiacarenprinc) {
		this.lista_tdiacarenprinc = lista_tdiacarenprinc;
	}

	public Integer getLista_tdiacarenjuro() {
		return lista_tdiacarenjuro;
	}
	public void setLista_tdiacarenjuro(Integer lista_tdiacarenjuro) {
		this.lista_tdiacarenjuro = lista_tdiacarenjuro;
	}

	public Integer getLista_qpcelatradeprinc() {
		return lista_qpcelatradeprinc;
	}
	public void setLista_qpcelatradeprinc(Integer lista_qpcelatradeprinc) {
		this.lista_qpcelatradeprinc = lista_qpcelatradeprinc;
	}

	public Integer getLista_qpcelatradejuro() {
		return lista_qpcelatradejuro;
	}
	public void setLista_qpcelatradejuro(Integer lista_qpcelatradejuro) {
		this.lista_qpcelatradejuro = lista_qpcelatradejuro;
	}

	public Integer getLista_cmomencobrcmbio() {
		return lista_cmomencobrcmbio;
	}
	public void setLista_cmomencobrcmbio(Integer lista_cmomencobrcmbio) {
		this.lista_cmomencobrcmbio = lista_cmomencobrcmbio;
	}

	public Integer getLista_ndsembcmbiotrade() {
		return lista_ndsembcmbiotrade;
	}
	public void setLista_ndsembcmbiotrade(Integer lista_ndsembcmbiotrade) {
		this.lista_ndsembcmbiotrade = lista_ndsembcmbiotrade;
	}

	public String getLista_vtxliborcmbio() {
		return lista_vtxliborcmbio;
	}
	public void setLista_vtxliborcmbio(String lista_vtxliborcmbio) {
		this.lista_vtxliborcmbio = lista_vtxliborcmbio;
	}

	public String getLista_ptxjurofndng() {
		return lista_ptxjurofndng;
	}
	public void setLista_ptxjurofndng(String lista_ptxjurofndng) {
		this.lista_ptxjurofndng = lista_ptxjurofndng;
	}

	public String getLista_pjuronegoccmbio() {
		return lista_pjuronegoccmbio;
	}
	public void setLista_pjuronegoccmbio(String lista_pjuronegoccmbio) {
		this.lista_pjuronegoccmbio = lista_pjuronegoccmbio;
	}

	public String getLista_pspreadtxcmbio() {
		return lista_pspreadtxcmbio;
	}
	public void setLista_pspreadtxcmbio(String lista_pspreadtxcmbio) {
		this.lista_pspreadtxcmbio = lista_pspreadtxcmbio;
	}

	public Integer getLista_tdiafinandsemb1() {
		return lista_tdiafinandsemb1;
	}
	public void setLista_tdiafinandsemb1(Integer lista_tdiafinandsemb1) {
		this.lista_tdiafinandsemb1 = lista_tdiafinandsemb1;
	}

	public String getLista_vjurodsembcmbio() {
		return lista_vjurodsembcmbio;
	}
	public void setLista_vjurodsembcmbio(String lista_vjurodsembcmbio) {
		this.lista_vjurodsembcmbio = lista_vjurodsembcmbio;
	}

	public String getLista_vdsembnegoccmbio() {
		return lista_vdsembnegoccmbio;
	}
	public void setLista_vdsembnegoccmbio(String lista_vdsembnegoccmbio) {
		this.lista_vdsembnegoccmbio = lista_vdsembnegoccmbio;
	}
    
}