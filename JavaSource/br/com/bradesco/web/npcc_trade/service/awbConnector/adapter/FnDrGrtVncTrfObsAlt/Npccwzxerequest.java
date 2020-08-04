package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 11/11/16 16:40
 */
public class Npccwzxerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZXE-HEADER.NPCCWZXE-COD-LAYOUT")
	private String codlayout = "NPCCWZXE";

	@Adapter(transactionField = "NPCCWZXE-HEADER.NPCCWZXE-TAM-LAYOUT")
	private Integer tamlayout = 7750;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-QTD-OC-VINC")
	private Integer qtdocvinc = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-QTD-OC-TARI")
	private Integer qtdoctari = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-QTD-OC-GARN")
	private Integer qtdocgarn = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-QTD-OC-AVAL")
	private Integer qtdocaval = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-DCOTAC-FNDNG-CMBIO")
	private String dcotacfndngcmbio = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CBANQR-CMBIO-FNDNG")
	private Long cbanqrcmbiofndng = 0L;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CBANQR-CMBIO-RCDOR")
	private Long cbanqrcmbiorcdor = 0L;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CBANQR-CMBIO-AVISO")
	private Long cbanqrcmbioaviso = 0L;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-DLIM-FNDNG-CMBIO")
	private String dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-PTX-FIXA-CMBIO")
	private String ptxfixacmbio = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CINDCD-ECONM-MOE-LIB")
	private Integer cindcdeconmmoelib = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-TMES-LIBOR-CMBIO")
	private Integer tmesliborcmbio = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-VTX-LIBOR-CMBIO")
	private String vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CONTATO.NPCCWZXE-CONTATO-NOME")
	private String contato_contatonome = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CONTATO.NPCCWZXE-CONTATO-TELE")
	private String contato_contatotele = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CONTATO-ROF.NPCCWZXE-NOME")
	private String contatorof_nome = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CONTATO-ROF.NPCCWZXE-TELEFONE")
	private String contatorof_telefone = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CONTATO-ROF.NPCCWZXE-CPF")
	private String contatorof_cpf = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CONTATO-ROF.NPCCWZXE-CARGO")
	private String contatorof_cargo = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CONTATO-ROF.NPCCWZXE-EMAIL")
	private String contatorof_email = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-OUTRAS-ESPCS")
	private String outrasespcs = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-OBSERVACAO")
	private String observacao = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-MOTIVO")
	private String motivo = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CUNIC-PSSOA-CMBIO-T")
	private Long cunicpssoacmbiot = 0L;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-CUNIC-PSSOA-INDICA")
	private Long cunicpssoaindica = 0L;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-AVA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest_lstava")
	private List<Npccwzxerequest_lstava> lstava = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-VIN", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest_lstvin")
	private List<Npccwzxerequest_lstvin> lstvin = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-TAR", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest_lsttar")
	private List<Npccwzxerequest_lsttar> lsttar = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest_lstgar")
	private List<Npccwzxerequest_lstgar> lstgar = null;
	
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

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
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

	public List<Npccwzxerequest_lstava> getLstava() {
		return lstava;
	}
	public void setLstava( List<Npccwzxerequest_lstava> lstava) {
		this.lstava = lstava;
	}

	public List<Npccwzxerequest_lstvin> getLstvin() {
		return lstvin;
	}
	public void setLstvin( List<Npccwzxerequest_lstvin> lstvin) {
		this.lstvin = lstvin;
	}

	public List<Npccwzxerequest_lsttar> getLsttar() {
		return lsttar;
	}
	public void setLsttar( List<Npccwzxerequest_lsttar> lsttar) {
		this.lsttar = lsttar;
	}

	public List<Npccwzxerequest_lstgar> getLstgar() {
		return lstgar;
	}
	public void setLstgar( List<Npccwzxerequest_lstgar> lstgar) {
		this.lstgar = lstgar;
	}
    
}