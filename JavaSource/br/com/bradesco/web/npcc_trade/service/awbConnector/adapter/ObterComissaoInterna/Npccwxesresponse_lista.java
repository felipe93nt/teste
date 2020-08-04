package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/04/17 09:29
 */
public class Npccwxesresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-NCOMIS-INTRN-CMBIO")
	private Integer lista_ncomisintrncmbio = 0;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-CFLUXO-PERDC-CMBIO")
	private Integer lista_cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-IFLUXO-PERDC-CMBIO")
	private String lista_ifluxoperdccmbio = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-CMOMEN-COBR-CMBIO")
	private Integer lista_cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-ISGL-INDCD-FONTE")
	private String lista_isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-VPREVT-COMIS-CMBIO")
	private String lista_vprevtcomiscmbio = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-DPREVT-DSEMB-CMBIO")
	private String lista_dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-CCOBR-COMIS-INTRN")
	private Integer lista_ccobrcomisintrn = 0;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-PCOMIS-NEGOC-CMBIO")
	private String lista_pcomisnegoccmbio = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-CCOBR-COMIS-CMBIO")
	private Integer lista_ccobrcomiscmbio = 0;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-VMIN-COBR-COMIS")
	private String lista_vmincobrcomis = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-VTX-SPREAD-APROV")
	private String lista_vtxspreadaprov = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-VTX-SPREAD-NEGOC")
	private String lista_vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-PTX-FLAT-PNALT")
	private String lista_ptxflatpnalt = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA.NPCCWXES-DESC-COMIS-BLETO")
	private String lista_desccomisbleto = null;
	
	public Integer getLista_ncomisintrncmbio() {
		return lista_ncomisintrncmbio;
	}
	public void setLista_ncomisintrncmbio(Integer lista_ncomisintrncmbio) {
		this.lista_ncomisintrncmbio = lista_ncomisintrncmbio;
	}

	public Integer getLista_cfluxoperdccmbio() {
		return lista_cfluxoperdccmbio;
	}
	public void setLista_cfluxoperdccmbio(Integer lista_cfluxoperdccmbio) {
		this.lista_cfluxoperdccmbio = lista_cfluxoperdccmbio;
	}

	public String getLista_ifluxoperdccmbio() {
		return lista_ifluxoperdccmbio;
	}
	public void setLista_ifluxoperdccmbio(String lista_ifluxoperdccmbio) {
		this.lista_ifluxoperdccmbio = lista_ifluxoperdccmbio;
	}

	public Integer getLista_cmomencobrcmbio() {
		return lista_cmomencobrcmbio;
	}
	public void setLista_cmomencobrcmbio(Integer lista_cmomencobrcmbio) {
		this.lista_cmomencobrcmbio = lista_cmomencobrcmbio;
	}

	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public String getLista_isglindcdfonte() {
		return lista_isglindcdfonte;
	}
	public void setLista_isglindcdfonte(String lista_isglindcdfonte) {
		this.lista_isglindcdfonte = lista_isglindcdfonte;
	}

	public String getLista_vprevtcomiscmbio() {
		return lista_vprevtcomiscmbio;
	}
	public void setLista_vprevtcomiscmbio(String lista_vprevtcomiscmbio) {
		this.lista_vprevtcomiscmbio = lista_vprevtcomiscmbio;
	}

	public String getLista_dprevtdsembcmbio() {
		return lista_dprevtdsembcmbio;
	}
	public void setLista_dprevtdsembcmbio(String lista_dprevtdsembcmbio) {
		this.lista_dprevtdsembcmbio = lista_dprevtdsembcmbio;
	}

	public Integer getLista_ccobrcomisintrn() {
		return lista_ccobrcomisintrn;
	}
	public void setLista_ccobrcomisintrn(Integer lista_ccobrcomisintrn) {
		this.lista_ccobrcomisintrn = lista_ccobrcomisintrn;
	}

	public String getLista_pcomisnegoccmbio() {
		return lista_pcomisnegoccmbio;
	}
	public void setLista_pcomisnegoccmbio(String lista_pcomisnegoccmbio) {
		this.lista_pcomisnegoccmbio = lista_pcomisnegoccmbio;
	}

	public Integer getLista_ccobrcomiscmbio() {
		return lista_ccobrcomiscmbio;
	}
	public void setLista_ccobrcomiscmbio(Integer lista_ccobrcomiscmbio) {
		this.lista_ccobrcomiscmbio = lista_ccobrcomiscmbio;
	}

	public String getLista_vmincobrcomis() {
		return lista_vmincobrcomis;
	}
	public void setLista_vmincobrcomis(String lista_vmincobrcomis) {
		this.lista_vmincobrcomis = lista_vmincobrcomis;
	}

	public String getLista_vtxspreadaprov() {
		return lista_vtxspreadaprov;
	}
	public void setLista_vtxspreadaprov(String lista_vtxspreadaprov) {
		this.lista_vtxspreadaprov = lista_vtxspreadaprov;
	}

	public String getLista_vtxspreadnegoc() {
		return lista_vtxspreadnegoc;
	}
	public void setLista_vtxspreadnegoc(String lista_vtxspreadnegoc) {
		this.lista_vtxspreadnegoc = lista_vtxspreadnegoc;
	}

	public String getLista_ptxflatpnalt() {
		return lista_ptxflatpnalt;
	}
	public void setLista_ptxflatpnalt(String lista_ptxflatpnalt) {
		this.lista_ptxflatpnalt = lista_ptxflatpnalt;
	}

	public String getLista_desccomisbleto() {
		return lista_desccomisbleto;
	}
	public void setLista_desccomisbleto(String lista_desccomisbleto) {
		this.lista_desccomisbleto = lista_desccomisbleto;
	}
    
}