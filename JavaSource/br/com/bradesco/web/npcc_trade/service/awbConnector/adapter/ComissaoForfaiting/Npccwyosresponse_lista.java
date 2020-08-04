package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/09/16 10:15
 */
public class Npccwyosresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-DPREVT-DSEMB-CMBIO")
	private String lista_dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-VPREVT-DSEMB-CMBIO")
	private String lista_vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-VTX-LIBOR-CMBIO")
	private String lista_vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-PTX-JURO-FNDNG")
	private String lista_ptxjurofndng = null;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-PSPREAD-TX-CMBIO")
	private String lista_pspreadtxcmbio = null;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-PJURO-NEGOC-CMBIO")
	private String lista_pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-TDIA-FINAN-DSEMB")
	private Integer lista_tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-VJURO-DSEMB-CMBIO")
	private String lista_vjurodsembcmbio = null;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA.NPCCWYOS-VDSEMB-NEGOC-CMBIO")
	private String lista_vdsembnegoccmbio = null;
	
	public String getLista_dprevtdsembcmbio() {
		return lista_dprevtdsembcmbio;
	}
	public void setLista_dprevtdsembcmbio(String lista_dprevtdsembcmbio) {
		this.lista_dprevtdsembcmbio = lista_dprevtdsembcmbio;
	}

	public String getLista_vprevtdsembcmbio() {
		return lista_vprevtdsembcmbio;
	}
	public void setLista_vprevtdsembcmbio(String lista_vprevtdsembcmbio) {
		this.lista_vprevtdsembcmbio = lista_vprevtdsembcmbio;
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

	public String getLista_pspreadtxcmbio() {
		return lista_pspreadtxcmbio;
	}
	public void setLista_pspreadtxcmbio(String lista_pspreadtxcmbio) {
		this.lista_pspreadtxcmbio = lista_pspreadtxcmbio;
	}

	public String getLista_pjuronegoccmbio() {
		return lista_pjuronegoccmbio;
	}
	public void setLista_pjuronegoccmbio(String lista_pjuronegoccmbio) {
		this.lista_pjuronegoccmbio = lista_pjuronegoccmbio;
	}

	public Integer getLista_tdiafinandsemb() {
		return lista_tdiafinandsemb;
	}
	public void setLista_tdiafinandsemb(Integer lista_tdiafinandsemb) {
		this.lista_tdiafinandsemb = lista_tdiafinandsemb;
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