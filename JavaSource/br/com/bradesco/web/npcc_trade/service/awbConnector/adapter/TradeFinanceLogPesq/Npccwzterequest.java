package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/08/16 18:41
 */
public class Npccwzterequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZVE-HEADER.NPCCWZTE-COD-LAYOUT")
	private String codlayout = "NPCCWZTE";

	@Adapter(transactionField = "NPCCWZVE-HEADER.NPCCWZTE-TAM-LAYOUT")
	private Integer tamlayout = 73;

	@Adapter(transactionField = "NPCCWZTE-REGISTRO.NPCCWZTE-PERIODO-COTACAO-I")
	private String periodocotacaoi = null;

	@Adapter(transactionField = "NPCCWZTE-REGISTRO.NPCCWZTE-PERIODO-COTACAO-F")
	private String periodocotacaof = null;

	@Adapter(transactionField = "NPCCWZTE-REGISTRO.NPCCWZTE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZTE-REGISTRO.NPCCWZTE-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWZTE-REGISTRO.NPCCWZTE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWZTE-REGISTRO.NPCCWZTE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWZTE-REGISTRO.NPCCWZTE-CUSUAR-INCLT")
	private String cusuarinclt = null;
	
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

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
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

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public String getCusuarinclt() {
		return cusuarinclt;
	}
	public void setCusuarinclt(String cusuarinclt) {
		this.cusuarinclt = cusuarinclt;
	}
    
}