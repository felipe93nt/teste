package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 25/10/16 17:51
 */
public class Npccwzdsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-ID-TPPESQUISA")
	private String lista_idtppesquisa = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-FECHADA-QT")
	private String lista_ctfechadaqt = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-FECHADA-VL")
	private String lista_ctfechadavl = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-PERDIDA-QT")
	private String lista_ctperdidaqt = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-PERDIDA-VL")
	private String lista_ctperdidavl = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-NEGOFIR-QT")
	private String lista_ctnegofirqt = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-NEGOFIR-VL")
	private String lista_ctnegofirvl = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-NEGOIND-QT")
	private String lista_ctnegoindqt = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-NEGOIND-VL")
	private String lista_ctnegoindvl = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-BAIXADA-QT")
	private String lista_ctbaixadaqt = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-CT-BAIXADA-VL")
	private String lista_ctbaixadavl = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-TOT-QTD-COTAC")
	private String lista_totqtdcotac = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-TOT-VAL-PRODT")
	private String lista_totvalprodt = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-PERCENTUAL-CT")
	private String lista_percentualct = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA.NPCCWZDS-PERCENTUAL-VL")
	private String lista_percentualvl = null;
	
	public String getLista_idtppesquisa() {
		return lista_idtppesquisa;
	}
	public void setLista_idtppesquisa(String lista_idtppesquisa) {
		this.lista_idtppesquisa = lista_idtppesquisa;
	}

	public String getLista_ctfechadaqt() {
		return lista_ctfechadaqt;
	}
	public void setLista_ctfechadaqt(String lista_ctfechadaqt) {
		this.lista_ctfechadaqt = lista_ctfechadaqt;
	}

	public String getLista_ctfechadavl() {
		return lista_ctfechadavl;
	}
	public void setLista_ctfechadavl(String lista_ctfechadavl) {
		this.lista_ctfechadavl = lista_ctfechadavl;
	}

	public String getLista_ctperdidaqt() {
		return lista_ctperdidaqt;
	}
	public void setLista_ctperdidaqt(String lista_ctperdidaqt) {
		this.lista_ctperdidaqt = lista_ctperdidaqt;
	}

	public String getLista_ctperdidavl() {
		return lista_ctperdidavl;
	}
	public void setLista_ctperdidavl(String lista_ctperdidavl) {
		this.lista_ctperdidavl = lista_ctperdidavl;
	}

	public String getLista_ctnegofirqt() {
		return lista_ctnegofirqt;
	}
	public void setLista_ctnegofirqt(String lista_ctnegofirqt) {
		this.lista_ctnegofirqt = lista_ctnegofirqt;
	}

	public String getLista_ctnegofirvl() {
		return lista_ctnegofirvl;
	}
	public void setLista_ctnegofirvl(String lista_ctnegofirvl) {
		this.lista_ctnegofirvl = lista_ctnegofirvl;
	}

	public String getLista_ctnegoindqt() {
		return lista_ctnegoindqt;
	}
	public void setLista_ctnegoindqt(String lista_ctnegoindqt) {
		this.lista_ctnegoindqt = lista_ctnegoindqt;
	}

	public String getLista_ctnegoindvl() {
		return lista_ctnegoindvl;
	}
	public void setLista_ctnegoindvl(String lista_ctnegoindvl) {
		this.lista_ctnegoindvl = lista_ctnegoindvl;
	}

	public String getLista_ctbaixadaqt() {
		return lista_ctbaixadaqt;
	}
	public void setLista_ctbaixadaqt(String lista_ctbaixadaqt) {
		this.lista_ctbaixadaqt = lista_ctbaixadaqt;
	}

	public String getLista_ctbaixadavl() {
		return lista_ctbaixadavl;
	}
	public void setLista_ctbaixadavl(String lista_ctbaixadavl) {
		this.lista_ctbaixadavl = lista_ctbaixadavl;
	}

	public String getLista_totqtdcotac() {
		return lista_totqtdcotac;
	}
	public void setLista_totqtdcotac(String lista_totqtdcotac) {
		this.lista_totqtdcotac = lista_totqtdcotac;
	}

	public String getLista_totvalprodt() {
		return lista_totvalprodt;
	}
	public void setLista_totvalprodt(String lista_totvalprodt) {
		this.lista_totvalprodt = lista_totvalprodt;
	}

	public String getLista_percentualct() {
		return lista_percentualct;
	}
	public void setLista_percentualct(String lista_percentualct) {
		this.lista_percentualct = lista_percentualct;
	}

	public String getLista_percentualvl() {
		return lista_percentualvl;
	}
	public void setLista_percentualvl(String lista_percentualvl) {
		this.lista_percentualvl = lista_percentualvl;
	}
    
}