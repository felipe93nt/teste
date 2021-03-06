package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GerarBatchMonitor;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/05/17 15:56
 */
public class Npccwkwerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWKWE-HEADER.NPCCWKWE-COD-LAYOUT")
	private String codlayout = "NPCCWKWE";

	@Adapter(transactionField = "NPCCWKWE-HEADER.NPCCWKWE-TAM-LAYOUT")
	private Integer tamlayout = 181;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-DE-PERIODO-COTACAO")
	private String deperiodocotacao = null;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-ATE-PERIODO-COTACAO")
	private String ateperiodocotacao = null;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-DE-PERIODO-FECHMTO")
	private String deperiodofechmto = null;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-ATE-PERIODO-FECHMTO")
	private String ateperiodofechmto = null;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CUSUAR-INCLT")
	private String cusuarinclt = null;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CBCO-EXT-CMBIO")
	private Long cbcoextcmbio = 0L;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CINDCD-NEGOC-SWAP")
	private String cindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CTPO-NEGOC-CMBIO")
	private Integer ctponegoccmbio = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-TDIA-DE-CMBIO")
	private Integer tdiadecmbio = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-TDIA-ATE-CMBIO")
	private Integer tdiaatecmbio = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-QPRZ-MED-DE")
	private Integer qprzmedde = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-QPRZ-MED-ATE")
	private Integer qprzmedate = 0;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-VALOR-ME-DE")
	private String valormede = null;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-VALOR-ME-ATE")
	private String valormeate = null;

	@Adapter(transactionField = "NPCCWKWE-REGISTRO.NPCCWKWE-CPAIS-REST")
	private Integer cpaisrest = 0;
	
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

	public String getDeperiodocotacao() {
		return deperiodocotacao;
	}
	public void setDeperiodocotacao(String deperiodocotacao) {
		this.deperiodocotacao = deperiodocotacao;
	}

	public String getAteperiodocotacao() {
		return ateperiodocotacao;
	}
	public void setAteperiodocotacao(String ateperiodocotacao) {
		this.ateperiodocotacao = ateperiodocotacao;
	}

	public String getDeperiodofechmto() {
		return deperiodofechmto;
	}
	public void setDeperiodofechmto(String deperiodofechmto) {
		this.deperiodofechmto = deperiodofechmto;
	}

	public String getAteperiodofechmto() {
		return ateperiodofechmto;
	}
	public void setAteperiodofechmto(String ateperiodofechmto) {
		this.ateperiodofechmto = ateperiodofechmto;
	}

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}
	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public String getCusuarinclt() {
		return cusuarinclt;
	}
	public void setCusuarinclt(String cusuarinclt) {
		this.cusuarinclt = cusuarinclt;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public Long getCbcoextcmbio() {
		return cbcoextcmbio;
	}
	public void setCbcoextcmbio(Long cbcoextcmbio) {
		this.cbcoextcmbio = cbcoextcmbio;
	}

	public String getCindcdnegocswap() {
		return cindcdnegocswap;
	}
	public void setCindcdnegocswap(String cindcdnegocswap) {
		this.cindcdnegocswap = cindcdnegocswap;
	}

	public Integer getCtponegoccmbio() {
		return ctponegoccmbio;
	}
	public void setCtponegoccmbio(Integer ctponegoccmbio) {
		this.ctponegoccmbio = ctponegoccmbio;
	}

	public Integer getDanobase() {
		return danobase;
	}
	public void setDanobase(Integer danobase) {
		this.danobase = danobase;
	}

	public Integer getNbletocmbioano() {
		return nbletocmbioano;
	}
	public void setNbletocmbioano(Integer nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}

	public Integer getTdiadecmbio() {
		return tdiadecmbio;
	}
	public void setTdiadecmbio(Integer tdiadecmbio) {
		this.tdiadecmbio = tdiadecmbio;
	}

	public Integer getTdiaatecmbio() {
		return tdiaatecmbio;
	}
	public void setTdiaatecmbio(Integer tdiaatecmbio) {
		this.tdiaatecmbio = tdiaatecmbio;
	}

	public Integer getQprzmedde() {
		return qprzmedde;
	}
	public void setQprzmedde(Integer qprzmedde) {
		this.qprzmedde = qprzmedde;
	}

	public Integer getQprzmedate() {
		return qprzmedate;
	}
	public void setQprzmedate(Integer qprzmedate) {
		this.qprzmedate = qprzmedate;
	}

	public String getValormede() {
		return valormede;
	}
	public void setValormede(String valormede) {
		this.valormede = valormede;
	}

	public String getValormeate() {
		return valormeate;
	}
	public void setValormeate(String valormeate) {
		this.valormeate = valormeate;
	}

	public Integer getCpaisrest() {
		return cpaisrest;
	}
	public void setCpaisrest(Integer cpaisrest) {
		this.cpaisrest = cpaisrest;
	}
    
}