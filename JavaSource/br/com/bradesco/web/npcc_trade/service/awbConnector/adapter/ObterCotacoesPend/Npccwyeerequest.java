package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/08/16 12:49
 */
public class Npccwyeerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYEE-HEADER.NPCCWYEE-COD-LAYOUT")
	private String codlayout = "NPCCWYEE";

	@Adapter(transactionField = "NPCCWYEE-HEADER.NPCCWYEE-TAM-LAYOUT")
	private Integer tamlayout = 100;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-DE-PERIODO-COTACAO")
	private String deperiodocotacao = null;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-ATE-PERIODO-COTACAO")
	private String ateperiodocotacao = null;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-CUSUAR-INCLT")
	private String cusuarinclt = null;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-CBCO-EXT-CMBIO")
	private Long cbcoextcmbio = 0L;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-CSIT-CUST-EXT")
	private Integer csitcustext = 0;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-CSIT-UNID-EXT")
	private Integer csitunidext = 0;

	@Adapter(transactionField = "NPCCWYEE-REGISTRO.NPCCWYEE-CSIT-DIVERG")
	private Integer csitdiverg = 0;
	
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

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public String getCusuarinclt() {
		return cusuarinclt;
	}
	public void setCusuarinclt(String cusuarinclt) {
		this.cusuarinclt = cusuarinclt;
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

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}
	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
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

	public Integer getCsitcustext() {
		return csitcustext;
	}
	public void setCsitcustext(Integer csitcustext) {
		this.csitcustext = csitcustext;
	}

	public Integer getCsitunidext() {
		return csitunidext;
	}
	public void setCsitunidext(Integer csitunidext) {
		this.csitunidext = csitunidext;
	}

	public Integer getCsitdiverg() {
		return csitdiverg;
	}
	public void setCsitdiverg(Integer csitdiverg) {
		this.csitdiverg = csitdiverg;
	}
    
}