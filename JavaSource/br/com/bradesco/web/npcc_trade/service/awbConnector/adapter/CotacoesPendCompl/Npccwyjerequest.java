package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 07/07/16 15:14
 */
public class Npccwyjerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZVE-HEADER.NPCCWYJE-COD-LAYOUT")
	private String codlayout = "NPCCWYJE";

	@Adapter(transactionField = "NPCCWZVE-HEADER.NPCCWYJE-TAM-LAYOUT")
	private Integer tamlayout = 77;

	@Adapter(transactionField = "NPCCWYJE-REGISTRO.NPCCWYJE-PERIODO-COTACAO-I")
	private String periodocotacaoi = null;

	@Adapter(transactionField = "NPCCWYJE-REGISTRO.NPCCWYJE-PERIODO-COTACAO-F")
	private String periodocotacaof = null;

	@Adapter(transactionField = "NPCCWYJE-REGISTRO.NPCCWYJE-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWYJE-REGISTRO.NPCCWYJE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWYJE-REGISTRO.NPCCWYJE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWYJE-REGISTRO.NPCCWYJE-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWYJE-REGISTRO.NPCCWYJE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWYJE-REGISTRO.NPCCWYJE-CPSSOA-JURID")
	private Long cpssoajurid = 0L;
	
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

	public String getPeriodocotacaoi() {
		return periodocotacaoi;
	}
	public void setPeriodocotacaoi(String periodocotacaoi) {
		this.periodocotacaoi = periodocotacaoi;
	}

	public String getPeriodocotacaof() {
		return periodocotacaof;
	}
	public void setPeriodocotacaof(String periodocotacaof) {
		this.periodocotacaof = periodocotacaof;
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

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public Long getCpssoajurid() {
		return cpssoajurid;
	}
	public void setCpssoajurid(Long cpssoajurid) {
		this.cpssoajurid = cpssoajurid;
	}
    
}