package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 01/12/16 15:20
 */
public class Npccwn7sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-NOME-CLIENTE")
	private String lista_snomecliente = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-CCPF-CNPJ")
	private Integer lista_sccpfcnpj = 0;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-CFLIAL-CPF-CNPJ")
	private Integer lista_scflialcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-CCTRL-CPF-CNPJ")
	private Integer lista_scctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-CPRODT-DESC")
	private String lista_scprodtdesc = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-NBLETO-NEGOC-CMBIO")
	private Long lista_snbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-DANO-BASE")
	private Integer lista_sdanobase = 0;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-NBLETO-CMBIO-ANO")
	private Integer lista_snbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-CBANQR-CMBIO")
	private Long lista_scbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-DCBANQR-CMBIO")
	private String lista_sdcbanqrcmbio = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-COPER-CMBIO-EXTER")
	private String lista_scopercmbioexter = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-RTOM-OBS-BLETO")
	private String lista_srtomobsbleto = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-ROBS-BLETO-CMBIO")
	private String lista_srobsbletocmbio = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-TDIA-OPER-CMBIO")
	private Integer lista_stdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-DFCHTO-BLETO-CMBIO")
	private String lista_sdfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-VTX-SPREAD-NEGOC")
	private String lista_svtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-DFIM-NEGOC-CMBIO")
	private String lista_sdfimnegoccmbio = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-ISGL-INDCD-FONTE")
	private String lista_sisglindcdfonte = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-VNEGOC-MOEDA-ESTRG")
	private String lista_svnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-VSDO-LIM-SENSI")
	private String lista_svsdolimsensi = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-HINCL-REG")
	private String lista_shinclreg = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-HMANUT-REG")
	private String lista_shmanutreg = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-CUSUAR")
	private String lista_scusuar = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-NOME-FUNC")
	private String lista_snomefunc = null;

	@Adapter(transactionField = "NPCCWN7S-REGISTRO.NPCCWN7S-LISTA.NPCCWN7S-S-TIPO-MANUT")
	private String lista_stipomanut = null;
	
	public String getLista_snomecliente() {
		return lista_snomecliente;
	}
	public void setLista_snomecliente(String lista_snomecliente) {
		this.lista_snomecliente = lista_snomecliente;
	}

	public Integer getLista_sccpfcnpj() {
		return lista_sccpfcnpj;
	}
	public void setLista_sccpfcnpj(Integer lista_sccpfcnpj) {
		this.lista_sccpfcnpj = lista_sccpfcnpj;
	}

	public Integer getLista_scflialcpfcnpj() {
		return lista_scflialcpfcnpj;
	}
	public void setLista_scflialcpfcnpj(Integer lista_scflialcpfcnpj) {
		this.lista_scflialcpfcnpj = lista_scflialcpfcnpj;
	}

	public Integer getLista_scctrlcpfcnpj() {
		return lista_scctrlcpfcnpj;
	}
	public void setLista_scctrlcpfcnpj(Integer lista_scctrlcpfcnpj) {
		this.lista_scctrlcpfcnpj = lista_scctrlcpfcnpj;
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

	public String getLista_sdcbanqrcmbio() {
		return lista_sdcbanqrcmbio;
	}
	public void setLista_sdcbanqrcmbio(String lista_sdcbanqrcmbio) {
		this.lista_sdcbanqrcmbio = lista_sdcbanqrcmbio;
	}

	public String getLista_scopercmbioexter() {
		return lista_scopercmbioexter;
	}
	public void setLista_scopercmbioexter(String lista_scopercmbioexter) {
		this.lista_scopercmbioexter = lista_scopercmbioexter;
	}

	public String getLista_srtomobsbleto() {
		return lista_srtomobsbleto;
	}
	public void setLista_srtomobsbleto(String lista_srtomobsbleto) {
		this.lista_srtomobsbleto = lista_srtomobsbleto;
	}

	public String getLista_srobsbletocmbio() {
		return lista_srobsbletocmbio;
	}
	public void setLista_srobsbletocmbio(String lista_srobsbletocmbio) {
		this.lista_srobsbletocmbio = lista_srobsbletocmbio;
	}

	public Integer getLista_stdiaopercmbio() {
		return lista_stdiaopercmbio;
	}
	public void setLista_stdiaopercmbio(Integer lista_stdiaopercmbio) {
		this.lista_stdiaopercmbio = lista_stdiaopercmbio;
	}

	public String getLista_sdfchtobletocmbio() {
		return lista_sdfchtobletocmbio;
	}
	public void setLista_sdfchtobletocmbio(String lista_sdfchtobletocmbio) {
		this.lista_sdfchtobletocmbio = lista_sdfchtobletocmbio;
	}

	public String getLista_svtxspreadnegoc() {
		return lista_svtxspreadnegoc;
	}
	public void setLista_svtxspreadnegoc(String lista_svtxspreadnegoc) {
		this.lista_svtxspreadnegoc = lista_svtxspreadnegoc;
	}

	public String getLista_sdfimnegoccmbio() {
		return lista_sdfimnegoccmbio;
	}
	public void setLista_sdfimnegoccmbio(String lista_sdfimnegoccmbio) {
		this.lista_sdfimnegoccmbio = lista_sdfimnegoccmbio;
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

	public String getLista_svsdolimsensi() {
		return lista_svsdolimsensi;
	}
	public void setLista_svsdolimsensi(String lista_svsdolimsensi) {
		this.lista_svsdolimsensi = lista_svsdolimsensi;
	}

	public String getLista_shinclreg() {
		return lista_shinclreg;
	}
	public void setLista_shinclreg(String lista_shinclreg) {
		this.lista_shinclreg = lista_shinclreg;
	}

	public String getLista_shmanutreg() {
		return lista_shmanutreg;
	}
	public void setLista_shmanutreg(String lista_shmanutreg) {
		this.lista_shmanutreg = lista_shmanutreg;
	}

	public String getLista_scusuar() {
		return lista_scusuar;
	}
	public void setLista_scusuar(String lista_scusuar) {
		this.lista_scusuar = lista_scusuar;
	}

	public String getLista_snomefunc() {
		return lista_snomefunc;
	}
	public void setLista_snomefunc(String lista_snomefunc) {
		this.lista_snomefunc = lista_snomefunc;
	}

	public String getLista_stipomanut() {
		return lista_stipomanut;
	}
	public void setLista_stipomanut(String lista_stipomanut) {
		this.lista_stipomanut = lista_stipomanut;
	}
    
}