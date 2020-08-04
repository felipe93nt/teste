package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 25/04/18 09:19
 */
public class Npccwxasresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXAS-HEADER.NPCCWXAS-COD-LAYOUT")
	private String codlayout = "NPCCWXAS";

	@Adapter(transactionField = "NPCCWXAS-HEADER.NPCCWXAS-TAM-LAYOUT")
	private Integer tamlayout = 24687;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-QTD-OC-REBT")
	private Integer qtdocrebt = 0;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-QTD-OC-TXDE")
	private Integer qtdoctxde = 0;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO1")
	private String observacao1 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO2")
	private String observacao2 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO3")
	private String observacao3 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO4")
	private String observacao4 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO5")
	private String observacao5 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO6")
	private String observacao6 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO7")
	private String observacao7 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO8")
	private String observacao8 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO9")
	private String observacao9 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OBSERVACAO10")
	private String observacao10 = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-NOME-CTT-CLI-CMBIO")
	private String nomecttclicmbio = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-TEL-CTT-CLI-CMBIO")
	private String telcttclicmbio = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-OUTRAS-ESPCS")
	private String outrasespcs = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DIVERGENTE")
	private String divergente = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-NOME-ROF")
	private String nomerof = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-TEL-ROF")
	private String telrof = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-CPF-ROF")
	private String cpfrof = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-CARGO-ROF")
	private String cargorof = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-EMAIL-ROF")
	private String emailrof = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DESP-CONF")
	private String despconf = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DESP-DESC")
	private String despdesc = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-FORM-AMOR")
	private String formamor = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-GARANTIAS")
	private String garantias = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-AMORTIZAR")
	private String amortizar = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-PAGA-JURO")
	private String pagajuro = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-PART-BNDS")
	private String partbnds = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-ORCAMENTO")
	private String orcamento = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-GARAN-BNDS")
	private String garanbnds = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-GARAN-BRAD")
	private String garanbrad = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-TXA-PRE")
	private String txapre = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-CUST-FIN")
	private String custfin = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-MERCADORIA")
	private String mercadoria = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-FORMA-PAGTO")
	private String formapagto = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DOCTO-CONSIG")
	private String doctoconsig = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-NOME")
	private String dadosnome = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-CPF-CNPJ-R")
	private Integer dadoscpfcnpjr = 0;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-CPF-CNPJ-F")
	private Integer dadoscpfcnpjf = 0;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-CPF-CNPJ-D")
	private Integer dadoscpfcnpjd = 0;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-ENDER")
	private String dadosender = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-IDENT")
	private String dadosident = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-ORGAO")
	private String dadosorgao = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-ESTCI")
	private String dadosestci = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-DADOS-REGCI")
	private String dadosregci = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-CARGO-NOME")
	private String cargonome = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-CARGO-EMAIL")
	private String cargoemail = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-GARAN-GARANT")
	private String garangarant = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-GARAN-IMPORT")
	private String garanimport = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-GARAN-CONDBGAR")
	private String garancondbgar = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-GARAN-CONDBMAN")
	private String garancondbman = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-GARAN-CONDAGFI")
	private String garancondagfi = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-FINALIDADE")
	private String finalidade = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-RETIRADA.NPCCWXAS-RETIR-NOME")
	private String retirada_retirnome = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-RETIRADA.NPCCWXAS-RETIR-CIDADE")
	private String retirada_retircidade = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-RETIRADA.NPCCWXAS-RETIR-ENDER")
	private String retirada_retirender = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-RETIRADA.NPCCWXAS-RETIR-TELE")
	private String retirada_retirtele = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-RETIRADA.NPCCWXAS-RETIR-EMAIL")
	private String retirada_retiremail = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-LST-RBT", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao.Npccwxasresponse_lstrbt")
	private List<Npccwxasresponse_lstrbt> lstrbt = null;

	@Adapter(transactionField = "NPCCWXAS-REGISTRO.NPCCWXAS-LST-TDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao.Npccwxasresponse_lsttde")
	private List<Npccwxasresponse_lsttde> lsttde = null;
	
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

	public String getObservacao1() {
		return observacao1;
	}
	public void setObservacao1(String observacao1) {
		this.observacao1 = observacao1;
	}

	public String getObservacao2() {
		return observacao2;
	}
	public void setObservacao2(String observacao2) {
		this.observacao2 = observacao2;
	}

	public String getObservacao3() {
		return observacao3;
	}
	public void setObservacao3(String observacao3) {
		this.observacao3 = observacao3;
	}

	public String getObservacao4() {
		return observacao4;
	}
	public void setObservacao4(String observacao4) {
		this.observacao4 = observacao4;
	}

	public String getObservacao5() {
		return observacao5;
	}
	public void setObservacao5(String observacao5) {
		this.observacao5 = observacao5;
	}

	public String getObservacao6() {
		return observacao6;
	}
	public void setObservacao6(String observacao6) {
		this.observacao6 = observacao6;
	}

	public String getObservacao7() {
		return observacao7;
	}
	public void setObservacao7(String observacao7) {
		this.observacao7 = observacao7;
	}

	public String getObservacao8() {
		return observacao8;
	}
	public void setObservacao8(String observacao8) {
		this.observacao8 = observacao8;
	}

	public String getObservacao9() {
		return observacao9;
	}
	public void setObservacao9(String observacao9) {
		this.observacao9 = observacao9;
	}

	public String getObservacao10() {
		return observacao10;
	}
	public void setObservacao10(String observacao10) {
		this.observacao10 = observacao10;
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

	public String getOutrasespcs() {
		return outrasespcs;
	}
	public void setOutrasespcs(String outrasespcs) {
		this.outrasespcs = outrasespcs;
	}

	public String getDivergente() {
		return divergente;
	}
	public void setDivergente(String divergente) {
		this.divergente = divergente;
	}

	public String getNomerof() {
		return nomerof;
	}
	public void setNomerof(String nomerof) {
		this.nomerof = nomerof;
	}

	public String getTelrof() {
		return telrof;
	}
	public void setTelrof(String telrof) {
		this.telrof = telrof;
	}

	public String getCpfrof() {
		return cpfrof;
	}
	public void setCpfrof(String cpfrof) {
		this.cpfrof = cpfrof;
	}

	public String getCargorof() {
		return cargorof;
	}
	public void setCargorof(String cargorof) {
		this.cargorof = cargorof;
	}

	public String getEmailrof() {
		return emailrof;
	}
	public void setEmailrof(String emailrof) {
		this.emailrof = emailrof;
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

	public String getFormapagto() {
		return formapagto;
	}
	public void setFormapagto(String formapagto) {
		this.formapagto = formapagto;
	}

	public String getDoctoconsig() {
		return doctoconsig;
	}
	public void setDoctoconsig(String doctoconsig) {
		this.doctoconsig = doctoconsig;
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

	public String getRetirada_retirnome() {
		return retirada_retirnome;
	}
	public void setRetirada_retirnome(String retirada_retirnome) {
		this.retirada_retirnome = retirada_retirnome;
	}

	public String getRetirada_retircidade() {
		return retirada_retircidade;
	}
	public void setRetirada_retircidade(String retirada_retircidade) {
		this.retirada_retircidade = retirada_retircidade;
	}

	public String getRetirada_retirender() {
		return retirada_retirender;
	}
	public void setRetirada_retirender(String retirada_retirender) {
		this.retirada_retirender = retirada_retirender;
	}

	public String getRetirada_retirtele() {
		return retirada_retirtele;
	}
	public void setRetirada_retirtele(String retirada_retirtele) {
		this.retirada_retirtele = retirada_retirtele;
	}

	public String getRetirada_retiremail() {
		return retirada_retiremail;
	}
	public void setRetirada_retiremail(String retirada_retiremail) {
		this.retirada_retiremail = retirada_retiremail;
	}

	public List<Npccwxasresponse_lstrbt> getLstrbt() {
		return lstrbt;
	}
	public void setLstrbt( List<Npccwxasresponse_lstrbt> lstrbt) {
		this.lstrbt = lstrbt;
	}

	public List<Npccwxasresponse_lsttde> getLsttde() {
		return lsttde;
	}
	public void setLsttde( List<Npccwxasresponse_lsttde> lsttde) {
		this.lsttde = lsttde;
	}
    
}