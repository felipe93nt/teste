package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 10/02/17 13:29
 */
public class Npccwynerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYNE-HEADER.NPCCWYNE-COD-LAYOUT")
	private String codlayout = "NPCCWYNE";

	@Adapter(transactionField = "NPCCWYNE-HEADER.NPCCWYNE-TAM-LAYOUT")
	private Integer tamlayout = 8430;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-QTD-OC-MERC")
	private Integer qtdocmerc = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-QTD-OC-VINC")
	private Integer qtdocvinc = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-QTD-OC-TARI")
	private Integer qtdoctari = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-QTD-OC-GARN")
	private Integer qtdocgarn = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-QTD-OC-AVAL")
	private Integer qtdocaval = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-DCOTAC-FNDNG-CMBIO")
	private String dcotacfndngcmbio = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CBANQR-CMBIO-FNDNG")
	private Long cbanqrcmbiofndng = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CBANQR-CMBIO-RCDOR")
	private Long cbanqrcmbiorcdor = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CBANQR-CMBIO-AVISO")
	private Long cbanqrcmbioaviso = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-DLIM-FNDNG-CMBIO")
	private String dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-PTX-FIXA-CMBIO")
	private String ptxfixacmbio = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CINDCD-ECONM-MOE-LIB")
	private Integer cindcdeconmmoelib = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-TMES-LIBOR-CMBIO")
	private Integer tmesliborcmbio = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-VTX-LIBOR-CMBIO")
	private String vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CONTATO.NPCCWYNE-CONTATO-NOME")
	private String contato_contatonome = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CONTATO.NPCCWYNE-CONTATO-TELE")
	private String contato_contatotele = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CONTATO-ROF.NPCCWYNE-NOME")
	private String contatorof_nome = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CONTATO-ROF.NPCCWYNE-TELEFONE")
	private String contatorof_telefone = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CONTATO-ROF.NPCCWYNE-CPF")
	private String contatorof_cpf = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CONTATO-ROF.NPCCWYNE-CARGO")
	private String contatorof_cargo = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CONTATO-ROF.NPCCWYNE-EMAIL")
	private String contatorof_email = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-OUTRAS-ESPCS")
	private String outrasespcs = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-OBSERVACAO")
	private String observacao = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-MOTIVO")
	private String motivo = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CUNIC-PSSOA-CMBIO-T")
	private Long cunicpssoacmbiot = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-CUNIC-PSSOA-INDICA")
	private Long cunicpssoaindica = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-AVA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lstava")
	private List<Npccwynerequest_lstava> lstava = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lstmer")
	private List<Npccwynerequest_lstmer> lstmer = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-VIN", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lstvin")
	private List<Npccwynerequest_lstvin> lstvin = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-TAR", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lsttar")
	private List<Npccwynerequest_lsttar> lsttar = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-GAR", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lstgar")
	private List<Npccwynerequest_lstgar> lstgar = null;
	
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

	public Integer getQtdocmerc() {
		return qtdocmerc;
	}
	public void setQtdocmerc(Integer qtdocmerc) {
		this.qtdocmerc = qtdocmerc;
	}

	public Integer getQtdocvinc() {
		return qtdocvinc;
	}
	public void setQtdocvinc(Integer qtdocvinc) {
		this.qtdocvinc = qtdocvinc;
	}

	public Integer getQtdoctari() {
		return qtdoctari;
	}
	public void setQtdoctari(Integer qtdoctari) {
		this.qtdoctari = qtdoctari;
	}

	public Integer getQtdocgarn() {
		return qtdocgarn;
	}
	public void setQtdocgarn(Integer qtdocgarn) {
		this.qtdocgarn = qtdocgarn;
	}

	public Integer getQtdocaval() {
		return qtdocaval;
	}
	public void setQtdocaval(Integer qtdocaval) {
		this.qtdocaval = qtdocaval;
	}

	public String getDcotacfndngcmbio() {
		return dcotacfndngcmbio;
	}
	public void setDcotacfndngcmbio(String dcotacfndngcmbio) {
		this.dcotacfndngcmbio = dcotacfndngcmbio;
	}

	public Long getCbanqrcmbiofndng() {
		return cbanqrcmbiofndng;
	}
	public void setCbanqrcmbiofndng(Long cbanqrcmbiofndng) {
		this.cbanqrcmbiofndng = cbanqrcmbiofndng;
	}

	public Long getCbanqrcmbiorcdor() {
		return cbanqrcmbiorcdor;
	}
	public void setCbanqrcmbiorcdor(Long cbanqrcmbiorcdor) {
		this.cbanqrcmbiorcdor = cbanqrcmbiorcdor;
	}

	public Long getCbanqrcmbioaviso() {
		return cbanqrcmbioaviso;
	}
	public void setCbanqrcmbioaviso(Long cbanqrcmbioaviso) {
		this.cbanqrcmbioaviso = cbanqrcmbioaviso;
	}

	public String getDlimfndngcmbio() {
		return dlimfndngcmbio;
	}
	public void setDlimfndngcmbio(String dlimfndngcmbio) {
		this.dlimfndngcmbio = dlimfndngcmbio;
	}

	public String getPtxfixacmbio() {
		return ptxfixacmbio;
	}
	public void setPtxfixacmbio(String ptxfixacmbio) {
		this.ptxfixacmbio = ptxfixacmbio;
	}

	public Integer getCindcdeconmmoelib() {
		return cindcdeconmmoelib;
	}
	public void setCindcdeconmmoelib(Integer cindcdeconmmoelib) {
		this.cindcdeconmmoelib = cindcdeconmmoelib;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public Integer getTmesliborcmbio() {
		return tmesliborcmbio;
	}
	public void setTmesliborcmbio(Integer tmesliborcmbio) {
		this.tmesliborcmbio = tmesliborcmbio;
	}

	public String getVtxliborcmbio() {
		return vtxliborcmbio;
	}
	public void setVtxliborcmbio(String vtxliborcmbio) {
		this.vtxliborcmbio = vtxliborcmbio;
	}

	public String getContato_contatonome() {
		return contato_contatonome;
	}
	public void setContato_contatonome(String contato_contatonome) {
		this.contato_contatonome = contato_contatonome;
	}

	public String getContato_contatotele() {
		return contato_contatotele;
	}
	public void setContato_contatotele(String contato_contatotele) {
		this.contato_contatotele = contato_contatotele;
	}

	public String getContatorof_nome() {
		return contatorof_nome;
	}
	public void setContatorof_nome(String contatorof_nome) {
		this.contatorof_nome = contatorof_nome;
	}

	public String getContatorof_telefone() {
		return contatorof_telefone;
	}
	public void setContatorof_telefone(String contatorof_telefone) {
		this.contatorof_telefone = contatorof_telefone;
	}

	public String getContatorof_cpf() {
		return contatorof_cpf;
	}
	public void setContatorof_cpf(String contatorof_cpf) {
		this.contatorof_cpf = contatorof_cpf;
	}

	public String getContatorof_cargo() {
		return contatorof_cargo;
	}
	public void setContatorof_cargo(String contatorof_cargo) {
		this.contatorof_cargo = contatorof_cargo;
	}

	public String getContatorof_email() {
		return contatorof_email;
	}
	public void setContatorof_email(String contatorof_email) {
		this.contatorof_email = contatorof_email;
	}

	public String getOutrasespcs() {
		return outrasespcs;
	}
	public void setOutrasespcs(String outrasespcs) {
		this.outrasespcs = outrasespcs;
	}

	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Long getCunicpssoacmbiot() {
		return cunicpssoacmbiot;
	}
	public void setCunicpssoacmbiot(Long cunicpssoacmbiot) {
		this.cunicpssoacmbiot = cunicpssoacmbiot;
	}

	public Long getCunicpssoaindica() {
		return cunicpssoaindica;
	}
	public void setCunicpssoaindica(Long cunicpssoaindica) {
		this.cunicpssoaindica = cunicpssoaindica;
	}

	public List<Npccwynerequest_lstava> getLstava() {
		return lstava;
	}
	public void setLstava( List<Npccwynerequest_lstava> lstava) {
		this.lstava = lstava;
	}

	public List<Npccwynerequest_lstmer> getLstmer() {
		return lstmer;
	}
	public void setLstmer( List<Npccwynerequest_lstmer> lstmer) {
		this.lstmer = lstmer;
	}

	public List<Npccwynerequest_lstvin> getLstvin() {
		return lstvin;
	}
	public void setLstvin( List<Npccwynerequest_lstvin> lstvin) {
		this.lstvin = lstvin;
	}

	public List<Npccwynerequest_lsttar> getLsttar() {
		return lsttar;
	}
	public void setLsttar( List<Npccwynerequest_lsttar> lsttar) {
		this.lsttar = lsttar;
	}

	public List<Npccwynerequest_lstgar> getLstgar() {
		return lstgar;
	}
	public void setLstgar( List<Npccwynerequest_lstgar> lstgar) {
		this.lstgar = lstgar;
	}
    
}