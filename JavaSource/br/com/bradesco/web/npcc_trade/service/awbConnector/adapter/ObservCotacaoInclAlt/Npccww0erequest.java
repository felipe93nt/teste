package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 25/04/18 10:06
 */
public class Npccww0erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW0E-HEADER.NPCCWW0E-COD-LAYOUT")
	private String codlayout = "NPCCWW0E";

	@Adapter(transactionField = "NPCCWW0E-HEADER.NPCCWW0E-TAM-LAYOUT")
	private Integer tamlayout = 17924;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-CTPO-OPER")
	private String ctpooper = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-QTD-OC-REBT")
	private Integer qtdocrebt = 0;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-QTD-OC-TXDE")
	private Integer qtdoctxde = 0;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-NOME-CTT-CLI-CMBIO")
	private String nomecttclicmbio = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-TEL-CTT-CLI-CMBIO")
	private String telcttclicmbio = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-FPGTO-COMPL-CMBIO")
	private String fpgtocomplcmbio = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-NIDTFD-CARTA-CSNDO")
	private String nidtfdcartacsndo = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DESP-CONF")
	private String despconf = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DESP-DESC")
	private String despdesc = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-FORM-AMOR")
	private String formamor = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-GARANTIAS")
	private String garantias = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-AMORTIZAR")
	private String amortizar = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-PAGA-JURO")
	private String pagajuro = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-PART-BNDS")
	private String partbnds = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-ORCAMENTO")
	private String orcamento = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-BNDS")
	private String garanbnds = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-BRAD")
	private String garanbrad = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-TXA-PRE")
	private String txapre = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-CUST-FIN")
	private String custfin = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-MERCADORIA")
	private String mercadoria = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-NOME")
	private String dadosnome = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-CPF-CNPJ-R")
	private Integer dadoscpfcnpjr = 0;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-CPF-CNPJ-F")
	private Integer dadoscpfcnpjf = 0;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-CPF-CNPJ-D")
	private Integer dadoscpfcnpjd = 0;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-ENDER")
	private String dadosender = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-IDENT")
	private String dadosident = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-ORGAO")
	private String dadosorgao = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-ESTCI")
	private String dadosestci = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-REGCI")
	private String dadosregci = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-CARGO-NOME")
	private String cargonome = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-CARGO-EMAIL")
	private String cargoemail = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-GARANT")
	private String garangarant = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-IMPORT")
	private String garanimport = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-CONDBGAR")
	private String garancondbgar = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-CONDBMAN")
	private String garancondbman = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-CONDAGFI")
	private String garancondagfi = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-FINALIDADE")
	private String finalidade = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-RETIR-NOME")
	private String retirnome = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-RETIR-CIDADE")
	private String retircidade = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-RETIR-ENDER")
	private String retirender = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-RETIR-TELE")
	private String retirtele = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-RETIR-EMAIL")
	private String retiremail = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-LST-RBT", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt.Npccww0erequest_lstrbt")
	private List<Npccww0erequest_lstrbt> lstrbt = null;

	@Adapter(transactionField = "NPCCWW0E-REGISTRO.NPCCWW0E-LST-TDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt.Npccww0erequest_lsttde")
	private List<Npccww0erequest_lsttde> lsttde = null;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

	public String getCtpooper() {
		return ctpooper;
	}
	public void setCtpooper(String ctpooper) {
		this.ctpooper = ctpooper;
	}

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public Integer getQtdocrebt() {
		return qtdocrebt;
	}
	public void setQtdocrebt(Integer qtdocrebt) {
		this.qtdocrebt = qtdocrebt;
	}

	public Integer getQtdoctxde() {
		return qtdoctxde;
	}
	public void setQtdoctxde(Integer qtdoctxde) {
		this.qtdoctxde = qtdoctxde;
	}

	public String getNomecttclicmbio() {
		return nomecttclicmbio;
	}
	public void setNomecttclicmbio(String nomecttclicmbio) {
		this.nomecttclicmbio = nomecttclicmbio;
	}

	public String getTelcttclicmbio() {
		return telcttclicmbio;
	}
	public void setTelcttclicmbio(String telcttclicmbio) {
		this.telcttclicmbio = telcttclicmbio;
	}

	public String getFpgtocomplcmbio() {
		return fpgtocomplcmbio;
	}
	public void setFpgtocomplcmbio(String fpgtocomplcmbio) {
		this.fpgtocomplcmbio = fpgtocomplcmbio;
	}

	public String getNidtfdcartacsndo() {
		return nidtfdcartacsndo;
	}
	public void setNidtfdcartacsndo(String nidtfdcartacsndo) {
		this.nidtfdcartacsndo = nidtfdcartacsndo;
	}

	public String getDespconf() {
		return despconf;
	}
	public void setDespconf(String despconf) {
		this.despconf = despconf;
	}

	public String getDespdesc() {
		return despdesc;
	}
	public void setDespdesc(String despdesc) {
		this.despdesc = despdesc;
	}

	public String getFormamor() {
		return formamor;
	}
	public void setFormamor(String formamor) {
		this.formamor = formamor;
	}

	public String getGarantias() {
		return garantias;
	}
	public void setGarantias(String garantias) {
		this.garantias = garantias;
	}

	public String getAmortizar() {
		return amortizar;
	}
	public void setAmortizar(String amortizar) {
		this.amortizar = amortizar;
	}

	public String getPagajuro() {
		return pagajuro;
	}
	public void setPagajuro(String pagajuro) {
		this.pagajuro = pagajuro;
	}

	public String getPartbnds() {
		return partbnds;
	}
	public void setPartbnds(String partbnds) {
		this.partbnds = partbnds;
	}

	public String getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(String orcamento) {
		this.orcamento = orcamento;
	}

	public String getGaranbnds() {
		return garanbnds;
	}
	public void setGaranbnds(String garanbnds) {
		this.garanbnds = garanbnds;
	}

	public String getGaranbrad() {
		return garanbrad;
	}
	public void setGaranbrad(String garanbrad) {
		this.garanbrad = garanbrad;
	}

	public String getTxapre() {
		return txapre;
	}
	public void setTxapre(String txapre) {
		this.txapre = txapre;
	}

	public String getCustfin() {
		return custfin;
	}
	public void setCustfin(String custfin) {
		this.custfin = custfin;
	}

	public String getMercadoria() {
		return mercadoria;
	}
	public void setMercadoria(String mercadoria) {
		this.mercadoria = mercadoria;
	}

	public String getDadosnome() {
		return dadosnome;
	}
	public void setDadosnome(String dadosnome) {
		this.dadosnome = dadosnome;
	}

	public Integer getDadoscpfcnpjr() {
		return dadoscpfcnpjr;
	}
	public void setDadoscpfcnpjr(Integer dadoscpfcnpjr) {
		this.dadoscpfcnpjr = dadoscpfcnpjr;
	}

	public Integer getDadoscpfcnpjf() {
		return dadoscpfcnpjf;
	}
	public void setDadoscpfcnpjf(Integer dadoscpfcnpjf) {
		this.dadoscpfcnpjf = dadoscpfcnpjf;
	}

	public Integer getDadoscpfcnpjd() {
		return dadoscpfcnpjd;
	}
	public void setDadoscpfcnpjd(Integer dadoscpfcnpjd) {
		this.dadoscpfcnpjd = dadoscpfcnpjd;
	}

	public String getDadosender() {
		return dadosender;
	}
	public void setDadosender(String dadosender) {
		this.dadosender = dadosender;
	}

	public String getDadosident() {
		return dadosident;
	}
	public void setDadosident(String dadosident) {
		this.dadosident = dadosident;
	}

	public String getDadosorgao() {
		return dadosorgao;
	}
	public void setDadosorgao(String dadosorgao) {
		this.dadosorgao = dadosorgao;
	}

	public String getDadosestci() {
		return dadosestci;
	}
	public void setDadosestci(String dadosestci) {
		this.dadosestci = dadosestci;
	}

	public String getDadosregci() {
		return dadosregci;
	}
	public void setDadosregci(String dadosregci) {
		this.dadosregci = dadosregci;
	}

	public String getCargonome() {
		return cargonome;
	}
	public void setCargonome(String cargonome) {
		this.cargonome = cargonome;
	}

	public String getCargoemail() {
		return cargoemail;
	}
	public void setCargoemail(String cargoemail) {
		this.cargoemail = cargoemail;
	}

	public String getGarangarant() {
		return garangarant;
	}
	public void setGarangarant(String garangarant) {
		this.garangarant = garangarant;
	}

	public String getGaranimport() {
		return garanimport;
	}
	public void setGaranimport(String garanimport) {
		this.garanimport = garanimport;
	}

	public String getGarancondbgar() {
		return garancondbgar;
	}
	public void setGarancondbgar(String garancondbgar) {
		this.garancondbgar = garancondbgar;
	}

	public String getGarancondbman() {
		return garancondbman;
	}
	public void setGarancondbman(String garancondbman) {
		this.garancondbman = garancondbman;
	}

	public String getGarancondagfi() {
		return garancondagfi;
	}
	public void setGarancondagfi(String garancondagfi) {
		this.garancondagfi = garancondagfi;
	}

	public String getFinalidade() {
		return finalidade;
	}
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getRetirnome() {
		return retirnome;
	}
	public void setRetirnome(String retirnome) {
		this.retirnome = retirnome;
	}

	public String getRetircidade() {
		return retircidade;
	}
	public void setRetircidade(String retircidade) {
		this.retircidade = retircidade;
	}

	public String getRetirender() {
		return retirender;
	}
	public void setRetirender(String retirender) {
		this.retirender = retirender;
	}

	public String getRetirtele() {
		return retirtele;
	}
	public void setRetirtele(String retirtele) {
		this.retirtele = retirtele;
	}

	public String getRetiremail() {
		return retiremail;
	}
	public void setRetiremail(String retiremail) {
		this.retiremail = retiremail;
	}

	public List<Npccww0erequest_lstrbt> getLstrbt() {
		return lstrbt;
	}
	public void setLstrbt( List<Npccww0erequest_lstrbt> lstrbt) {
		this.lstrbt = lstrbt;
	}

	public List<Npccww0erequest_lsttde> getLsttde() {
		return lsttde;
	}
	public void setLsttde( List<Npccww0erequest_lsttde> lsttde) {
		this.lsttde = lsttde;
	}
    
}