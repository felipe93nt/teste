package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 01/12/16 12:15
 */
public class Npccwn2sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-STATUS")
	private Integer lista_sstatus = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-TP-PESSOA")
	private String lista_stppessoa = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CPF-CNPJ")
	private Integer lista_scpfcnpj = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CFLIAL-CNPJ")
	private Integer lista_scflialcnpj = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CCTRL-CPF-CNPJ")
	private Integer lista_scctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CUNIC-CLI-DESC")
	private String lista_scunicclidesc = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CUNIC-CLI-CMBIO")
	private Long lista_scunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CPRODT-SERVC")
	private Integer lista_scprodtservc = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CPRODT-DESC")
	private String lista_scprodtdesc = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-NBLETO-NEGOC-CMBIO")
	private Long lista_snbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DANO-BASE")
	private Integer lista_sdanobase = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-NBLETO-CMBIO-ANO")
	private Integer lista_snbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CBANQR-CMBIO")
	private Long lista_scbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-IBANQR-CMBIO")
	private String lista_sibanqrcmbio = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-COPER-CMBIO-EXTER")
	private String lista_scopercmbioexter = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-TOMADOR")
	private String lista_stomador = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-OBSERVACAO")
	private String lista_sobservacao = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-VTX-SPREAD-NEGOC")
	private String lista_svtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-TDIA-OPER-CMBIO")
	private Integer lista_stdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CINDCD-ECONM-MOEDA")
	private Integer lista_scindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-ISGL-INDCD-FONTE")
	private String lista_sisglindcdfonte = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-VNEGOC-MOEDA-ESTRG")
	private String lista_svnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-NSEQ-CONTR-LIM")
	private Long lista_snseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-VSDO-LIM-SENSI")
	private String lista_svsdolimsensi = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DFCHTO-BLETO-CMBIO")
	private String lista_sdfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DFIM-NEGOC-CMBIO")
	private String lista_sdfimnegoccmbio = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-VULT-BAIXA-CMBIO")
	private String lista_svultbaixacmbio = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-VULT-ESTRN-CMBIO")
	private String lista_svultestrncmbio = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CPRODT-LIMITE-GE")
	private Integer lista_scprodtlimitege = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DES-CPRODT-LIM-GE")
	private String lista_sdescprodtlimge = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-COD-MOEDA-GE")
	private Integer lista_scodmoedage = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DESC-MOEDA-GE")
	private String lista_sdescmoedage = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-VALOR-LIM-GE")
	private String lista_svalorlimge = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-VALOR-DISP-GE")
	private String lista_svalordispge = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DFCHTO-LIMITE-GE")
	private String lista_sdfchtolimitege = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CPSSOA-JURID-GE")
	private Long lista_scpssoajuridge = 0L;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-CTPO-CONTR-GE")
	private Integer lista_sctpocontrge = 0;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-NSEQ-CONTR-GE")
	private Long lista_snseqcontrge = 0L;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-NCONTR-LIM-GE")
	private Long lista_sncontrlimge = 0L;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DESC-STATUS")
	private String lista_sdescstatus = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DESC-BANQUEIRO")
	private String lista_sdescbanqueiro = null;

	@Adapter(transactionField = "NPCCWN2S-REGISTRO.NPCCWN2S-LISTA.NPCCWN2S-S-DESC-GARANTIA")
	private String lista_sdescgarantia = null;
	
	public Integer getLista_sstatus() {
		return lista_sstatus;
	}
	public void setLista_sstatus(Integer lista_sstatus) {
		this.lista_sstatus = lista_sstatus;
	}

	public String getLista_stppessoa() {
		return lista_stppessoa;
	}
	public void setLista_stppessoa(String lista_stppessoa) {
		this.lista_stppessoa = lista_stppessoa;
	}

	public Integer getLista_scpfcnpj() {
		return lista_scpfcnpj;
	}
	public void setLista_scpfcnpj(Integer lista_scpfcnpj) {
		this.lista_scpfcnpj = lista_scpfcnpj;
	}

	public Integer getLista_scflialcnpj() {
		return lista_scflialcnpj;
	}
	public void setLista_scflialcnpj(Integer lista_scflialcnpj) {
		this.lista_scflialcnpj = lista_scflialcnpj;
	}

	public Integer getLista_scctrlcpfcnpj() {
		return lista_scctrlcpfcnpj;
	}
	public void setLista_scctrlcpfcnpj(Integer lista_scctrlcpfcnpj) {
		this.lista_scctrlcpfcnpj = lista_scctrlcpfcnpj;
	}

	public String getLista_scunicclidesc() {
		return lista_scunicclidesc;
	}
	public void setLista_scunicclidesc(String lista_scunicclidesc) {
		this.lista_scunicclidesc = lista_scunicclidesc;
	}

	public Long getLista_scunicclicmbio() {
		return lista_scunicclicmbio;
	}
	public void setLista_scunicclicmbio(Long lista_scunicclicmbio) {
		this.lista_scunicclicmbio = lista_scunicclicmbio;
	}

	public Integer getLista_scprodtservc() {
		return lista_scprodtservc;
	}
	public void setLista_scprodtservc(Integer lista_scprodtservc) {
		this.lista_scprodtservc = lista_scprodtservc;
	}

	public String getLista_scprodtdesc() {
		return lista_scprodtdesc;
	}
	public void setLista_scprodtdesc(String lista_scprodtdesc) {
		this.lista_scprodtdesc = lista_scprodtdesc;
	}

	public Long getLista_snbletonegoccmbio() {
		return lista_snbletonegoccmbio;
	}
	public void setLista_snbletonegoccmbio(Long lista_snbletonegoccmbio) {
		this.lista_snbletonegoccmbio = lista_snbletonegoccmbio;
	}

	public Integer getLista_sdanobase() {
		return lista_sdanobase;
	}
	public void setLista_sdanobase(Integer lista_sdanobase) {
		this.lista_sdanobase = lista_sdanobase;
	}

	public Integer getLista_snbletocmbioano() {
		return lista_snbletocmbioano;
	}
	public void setLista_snbletocmbioano(Integer lista_snbletocmbioano) {
		this.lista_snbletocmbioano = lista_snbletocmbioano;
	}

	public Long getLista_scbanqrcmbio() {
		return lista_scbanqrcmbio;
	}
	public void setLista_scbanqrcmbio(Long lista_scbanqrcmbio) {
		this.lista_scbanqrcmbio = lista_scbanqrcmbio;
	}

	public String getLista_sibanqrcmbio() {
		return lista_sibanqrcmbio;
	}
	public void setLista_sibanqrcmbio(String lista_sibanqrcmbio) {
		this.lista_sibanqrcmbio = lista_sibanqrcmbio;
	}

	public String getLista_scopercmbioexter() {
		return lista_scopercmbioexter;
	}
	public void setLista_scopercmbioexter(String lista_scopercmbioexter) {
		this.lista_scopercmbioexter = lista_scopercmbioexter;
	}

	public String getLista_stomador() {
		return lista_stomador;
	}
	public void setLista_stomador(String lista_stomador) {
		this.lista_stomador = lista_stomador;
	}

	public String getLista_sobservacao() {
		return lista_sobservacao;
	}
	public void setLista_sobservacao(String lista_sobservacao) {
		this.lista_sobservacao = lista_sobservacao;
	}

	public String getLista_svtxspreadnegoc() {
		return lista_svtxspreadnegoc;
	}
	public void setLista_svtxspreadnegoc(String lista_svtxspreadnegoc) {
		this.lista_svtxspreadnegoc = lista_svtxspreadnegoc;
	}

	public Integer getLista_stdiaopercmbio() {
		return lista_stdiaopercmbio;
	}
	public void setLista_stdiaopercmbio(Integer lista_stdiaopercmbio) {
		this.lista_stdiaopercmbio = lista_stdiaopercmbio;
	}

	public Integer getLista_scindcdeconmmoeda() {
		return lista_scindcdeconmmoeda;
	}
	public void setLista_scindcdeconmmoeda(Integer lista_scindcdeconmmoeda) {
		this.lista_scindcdeconmmoeda = lista_scindcdeconmmoeda;
	}

	public String getLista_sisglindcdfonte() {
		return lista_sisglindcdfonte;
	}
	public void setLista_sisglindcdfonte(String lista_sisglindcdfonte) {
		this.lista_sisglindcdfonte = lista_sisglindcdfonte;
	}

	public String getLista_svnegocmoedaestrg() {
		return lista_svnegocmoedaestrg;
	}
	public void setLista_svnegocmoedaestrg(String lista_svnegocmoedaestrg) {
		this.lista_svnegocmoedaestrg = lista_svnegocmoedaestrg;
	}

	public Long getLista_snseqcontrlim() {
		return lista_snseqcontrlim;
	}
	public void setLista_snseqcontrlim(Long lista_snseqcontrlim) {
		this.lista_snseqcontrlim = lista_snseqcontrlim;
	}

	public String getLista_svsdolimsensi() {
		return lista_svsdolimsensi;
	}
	public void setLista_svsdolimsensi(String lista_svsdolimsensi) {
		this.lista_svsdolimsensi = lista_svsdolimsensi;
	}

	public String getLista_sdfchtobletocmbio() {
		return lista_sdfchtobletocmbio;
	}
	public void setLista_sdfchtobletocmbio(String lista_sdfchtobletocmbio) {
		this.lista_sdfchtobletocmbio = lista_sdfchtobletocmbio;
	}

	public String getLista_sdfimnegoccmbio() {
		return lista_sdfimnegoccmbio;
	}
	public void setLista_sdfimnegoccmbio(String lista_sdfimnegoccmbio) {
		this.lista_sdfimnegoccmbio = lista_sdfimnegoccmbio;
	}

	public String getLista_svultbaixacmbio() {
		return lista_svultbaixacmbio;
	}
	public void setLista_svultbaixacmbio(String lista_svultbaixacmbio) {
		this.lista_svultbaixacmbio = lista_svultbaixacmbio;
	}

	public String getLista_svultestrncmbio() {
		return lista_svultestrncmbio;
	}
	public void setLista_svultestrncmbio(String lista_svultestrncmbio) {
		this.lista_svultestrncmbio = lista_svultestrncmbio;
	}

	public Integer getLista_scprodtlimitege() {
		return lista_scprodtlimitege;
	}
	public void setLista_scprodtlimitege(Integer lista_scprodtlimitege) {
		this.lista_scprodtlimitege = lista_scprodtlimitege;
	}

	public String getLista_sdescprodtlimge() {
		return lista_sdescprodtlimge;
	}
	public void setLista_sdescprodtlimge(String lista_sdescprodtlimge) {
		this.lista_sdescprodtlimge = lista_sdescprodtlimge;
	}

	public Integer getLista_scodmoedage() {
		return lista_scodmoedage;
	}
	public void setLista_scodmoedage(Integer lista_scodmoedage) {
		this.lista_scodmoedage = lista_scodmoedage;
	}

	public String getLista_sdescmoedage() {
		return lista_sdescmoedage;
	}
	public void setLista_sdescmoedage(String lista_sdescmoedage) {
		this.lista_sdescmoedage = lista_sdescmoedage;
	}

	public String getLista_svalorlimge() {
		return lista_svalorlimge;
	}
	public void setLista_svalorlimge(String lista_svalorlimge) {
		this.lista_svalorlimge = lista_svalorlimge;
	}

	public String getLista_svalordispge() {
		return lista_svalordispge;
	}
	public void setLista_svalordispge(String lista_svalordispge) {
		this.lista_svalordispge = lista_svalordispge;
	}

	public String getLista_sdfchtolimitege() {
		return lista_sdfchtolimitege;
	}
	public void setLista_sdfchtolimitege(String lista_sdfchtolimitege) {
		this.lista_sdfchtolimitege = lista_sdfchtolimitege;
	}

	public Long getLista_scpssoajuridge() {
		return lista_scpssoajuridge;
	}
	public void setLista_scpssoajuridge(Long lista_scpssoajuridge) {
		this.lista_scpssoajuridge = lista_scpssoajuridge;
	}

	public Integer getLista_sctpocontrge() {
		return lista_sctpocontrge;
	}
	public void setLista_sctpocontrge(Integer lista_sctpocontrge) {
		this.lista_sctpocontrge = lista_sctpocontrge;
	}

	public Long getLista_snseqcontrge() {
		return lista_snseqcontrge;
	}
	public void setLista_snseqcontrge(Long lista_snseqcontrge) {
		this.lista_snseqcontrge = lista_snseqcontrge;
	}

	public Long getLista_sncontrlimge() {
		return lista_sncontrlimge;
	}
	public void setLista_sncontrlimge(Long lista_sncontrlimge) {
		this.lista_sncontrlimge = lista_sncontrlimge;
	}

	public String getLista_sdescstatus() {
		return lista_sdescstatus;
	}
	public void setLista_sdescstatus(String lista_sdescstatus) {
		this.lista_sdescstatus = lista_sdescstatus;
	}

	public String getLista_sdescbanqueiro() {
		return lista_sdescbanqueiro;
	}
	public void setLista_sdescbanqueiro(String lista_sdescbanqueiro) {
		this.lista_sdescbanqueiro = lista_sdescbanqueiro;
	}

	public String getLista_sdescgarantia() {
		return lista_sdescgarantia;
	}
	public void setLista_sdescgarantia(String lista_sdescgarantia) {
		this.lista_sdescgarantia = lista_sdescgarantia;
	}
    
}