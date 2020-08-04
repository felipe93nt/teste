package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 17:35
 */
public class Npccwzlsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-IRZ-SCIAL")
	private String lista_irzscial = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-DTPO-SGMTO-CLI")
	private String lista_dtposgmtocli = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-DTCOTACAO")
	private String lista_dtcotacao = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-DFCHTO-BLETO-CMBIO")
	private String lista_dfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-NOME-UND-ORGNZ")
	private String lista_nomeundorgnz = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-ECONM-MOEDA")
	private String lista_econmmoeda = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-VNEGOC-MOEDA-ESTRG")
	private String lista_vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-CPRODT-DESC")
	private String lista_cprodtdesc = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-PRZ-MED-TOT")
	private String lista_przmedtot = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-VTX-SPREAD-NEGOC")
	private String lista_vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-DPREVT-DSEMB-CMBIO")
	private String lista_dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA.NPCCWZLS-UNI-BNC-CST")
	private String lista_unibnccst = null;
	
	public String getLista_irzscial() {
		return lista_irzscial;
	}
	public void setLista_irzscial(String lista_irzscial) {
		this.lista_irzscial = lista_irzscial;
	}

	public String getLista_dtposgmtocli() {
		return lista_dtposgmtocli;
	}
	public void setLista_dtposgmtocli(String lista_dtposgmtocli) {
		this.lista_dtposgmtocli = lista_dtposgmtocli;
	}

	public String getLista_dtcotacao() {
		return lista_dtcotacao;
	}
	public void setLista_dtcotacao(String lista_dtcotacao) {
		this.lista_dtcotacao = lista_dtcotacao;
	}

	public String getLista_dfchtobletocmbio() {
		return lista_dfchtobletocmbio;
	}
	public void setLista_dfchtobletocmbio(String lista_dfchtobletocmbio) {
		this.lista_dfchtobletocmbio = lista_dfchtobletocmbio;
	}

	public String getLista_nomeundorgnz() {
		return lista_nomeundorgnz;
	}
	public void setLista_nomeundorgnz(String lista_nomeundorgnz) {
		this.lista_nomeundorgnz = lista_nomeundorgnz;
	}

	public String getLista_econmmoeda() {
		return lista_econmmoeda;
	}
	public void setLista_econmmoeda(String lista_econmmoeda) {
		this.lista_econmmoeda = lista_econmmoeda;
	}

	public String getLista_vnegocmoedaestrg() {
		return lista_vnegocmoedaestrg;
	}
	public void setLista_vnegocmoedaestrg(String lista_vnegocmoedaestrg) {
		this.lista_vnegocmoedaestrg = lista_vnegocmoedaestrg;
	}

	public String getLista_cprodtdesc() {
		return lista_cprodtdesc;
	}
	public void setLista_cprodtdesc(String lista_cprodtdesc) {
		this.lista_cprodtdesc = lista_cprodtdesc;
	}

	public String getLista_przmedtot() {
		return lista_przmedtot;
	}
	public void setLista_przmedtot(String lista_przmedtot) {
		this.lista_przmedtot = lista_przmedtot;
	}

	public String getLista_vtxspreadnegoc() {
		return lista_vtxspreadnegoc;
	}
	public void setLista_vtxspreadnegoc(String lista_vtxspreadnegoc) {
		this.lista_vtxspreadnegoc = lista_vtxspreadnegoc;
	}

	public String getLista_dprevtdsembcmbio() {
		return lista_dprevtdsembcmbio;
	}
	public void setLista_dprevtdsembcmbio(String lista_dprevtdsembcmbio) {
		this.lista_dprevtdsembcmbio = lista_dprevtdsembcmbio;
	}

	public String getLista_unibnccst() {
		return lista_unibnccst;
	}
	public void setLista_unibnccst(String lista_unibnccst) {
		this.lista_unibnccst = lista_unibnccst;
	}
    
}