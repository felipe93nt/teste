package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Npccwmnsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMNS-HEADER.NPCCWMNS-COD-LAYOUT")
	private String codlayout = "NPCCWMNS";

	@Adapter(transactionField = "NPCCWMNS-HEADER.NPCCWMNS-TAM-LAYOUT")
	private Integer tamlayout = 1972;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-IND-DQMTO")
	private String inddqmto = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-COD-MOEDA-OPER")
	private Integer codmoedaoper = 0;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-SIGLA-MOEDA-OPER")
	private String siglamoedaoper = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DESC-MOEDA-OPER")
	private String descmoedaoper = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-COD-MOEDA-LIM")
	private Integer codmoedalim = 0;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-SIGLA-MOEDA-LIM")
	private String siglamoedalim = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DESC-MOEDA-LIM")
	private String descmoedalim = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-CNT-CREDITO")
	private Integer dadoslista_cntcredito = 0;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-CREDITO", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse_dadoslista_credito")
	private List<Npccwmnsresponse_dadoslista_credito> dadoslista_credito = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-S-CNT-PA")
	private Integer dadoslista_scntpa = 0;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-PA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse_dadoslista_pa")
	private List<Npccwmnsresponse_dadoslista_pa> dadoslista_pa = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-CNT-AB")
	private Integer dadoslista_cntab = 0;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-AB", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse_dadoslista_ab")
	private List<Npccwmnsresponse_dadoslista_ab> dadoslista_ab = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-CNT-ST")
	private Integer dadoslista_cntst = 0;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-ST", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse_dadoslista_st")
	private List<Npccwmnsresponse_dadoslista_st> dadoslista_st = null;
	
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

	public String getInddqmto() {
		return inddqmto;
	}
	public void setInddqmto(String inddqmto) {
		this.inddqmto = inddqmto;
	}

	public Integer getCodmoedaoper() {
		return codmoedaoper;
	}
	public void setCodmoedaoper(Integer codmoedaoper) {
		this.codmoedaoper = codmoedaoper;
	}

	public String getSiglamoedaoper() {
		return siglamoedaoper;
	}
	public void setSiglamoedaoper(String siglamoedaoper) {
		this.siglamoedaoper = siglamoedaoper;
	}

	public String getDescmoedaoper() {
		return descmoedaoper;
	}
	public void setDescmoedaoper(String descmoedaoper) {
		this.descmoedaoper = descmoedaoper;
	}

	public Integer getCodmoedalim() {
		return codmoedalim;
	}
	public void setCodmoedalim(Integer codmoedalim) {
		this.codmoedalim = codmoedalim;
	}

	public String getSiglamoedalim() {
		return siglamoedalim;
	}
	public void setSiglamoedalim(String siglamoedalim) {
		this.siglamoedalim = siglamoedalim;
	}

	public String getDescmoedalim() {
		return descmoedalim;
	}
	public void setDescmoedalim(String descmoedalim) {
		this.descmoedalim = descmoedalim;
	}

	public Integer getDadoslista_cntcredito() {
		return dadoslista_cntcredito;
	}
	public void setDadoslista_cntcredito(Integer dadoslista_cntcredito) {
		this.dadoslista_cntcredito = dadoslista_cntcredito;
	}

	public List<Npccwmnsresponse_dadoslista_credito> getDadoslista_credito() {
		return dadoslista_credito;
	}
	public void setDadoslista_credito( List<Npccwmnsresponse_dadoslista_credito> dadoslista_credito) {
		this.dadoslista_credito = dadoslista_credito;
	}

	public Integer getDadoslista_scntpa() {
		return dadoslista_scntpa;
	}
	public void setDadoslista_scntpa(Integer dadoslista_scntpa) {
		this.dadoslista_scntpa = dadoslista_scntpa;
	}

	public List<Npccwmnsresponse_dadoslista_pa> getDadoslista_pa() {
		return dadoslista_pa;
	}
	public void setDadoslista_pa( List<Npccwmnsresponse_dadoslista_pa> dadoslista_pa) {
		this.dadoslista_pa = dadoslista_pa;
	}

	public Integer getDadoslista_cntab() {
		return dadoslista_cntab;
	}
	public void setDadoslista_cntab(Integer dadoslista_cntab) {
		this.dadoslista_cntab = dadoslista_cntab;
	}

	public List<Npccwmnsresponse_dadoslista_ab> getDadoslista_ab() {
		return dadoslista_ab;
	}
	public void setDadoslista_ab( List<Npccwmnsresponse_dadoslista_ab> dadoslista_ab) {
		this.dadoslista_ab = dadoslista_ab;
	}

	public Integer getDadoslista_cntst() {
		return dadoslista_cntst;
	}
	public void setDadoslista_cntst(Integer dadoslista_cntst) {
		this.dadoslista_cntst = dadoslista_cntst;
	}

	public List<Npccwmnsresponse_dadoslista_st> getDadoslista_st() {
		return dadoslista_st;
	}
	public void setDadoslista_st( List<Npccwmnsresponse_dadoslista_st> dadoslista_st) {
		this.dadoslista_st = dadoslista_st;
	}
    
}