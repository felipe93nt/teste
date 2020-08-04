package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/08/16 14:30
 */
public class Npccwzverequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZVE-HEADER.NPCCWZVE-COD-LAYOUT")
	private String codlayout = "NPCCWZVE";

	@Adapter(transactionField = "NPCCWZVE-HEADER.NPCCWZVE-TAM-LAYOUT")
	private Integer tamlayout = 84;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-DE-PERIODO-FECHMTO")
	private String deperiodofechmto = null;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-ATE-PERIODO-FECHMTO")
	private String ateperiodofechmto = null;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-CUSUAR-INCLT")
	private String cusuarinclt = null;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWZVE-REGISTRO.NPCCWZVE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;
	
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

	public String getCusuarinclt() {
		return cusuarinclt;
	}
	public void setCusuarinclt(String cusuarinclt) {
		this.cusuarinclt = cusuarinclt;
	}

	public Integer getNbletocmbioano() {
		return nbletocmbioano;
	}
	public void setNbletocmbioano(Integer nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}

	public Integer getDanobase() {
		return danobase;
	}
	public void setDanobase(Integer danobase) {
		this.danobase = danobase;
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
    
}