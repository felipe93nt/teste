package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 06/06/16 11:36
 */
public class Npccwztirequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZTI-HEADER.NPCCWZTI-COD-LAYOUT")
	private String codlayout = "NPCCWZTI";

	@Adapter(transactionField = "NPCCWZTI-HEADER.NPCCWZTI-TAM-LAYOUT")
	private Integer tamlayout = 18052;

	@Adapter(transactionField = "NPCCWZTI-BLOCO-RETORNO.NPCCWZTI-COD-RETORNO")
	private Integer codretorno = 0;

	@Adapter(transactionField = "NPCCWZTI-BLOCO-RETORNO.NPCCWZTI-COD-ERRO")
	private String coderro = null;

	@Adapter(transactionField = "NPCCWZTI-BLOCO-RETORNO.NPCCWZTI-COD-MENSAGEM")
	private String codmensagem = null;

	@Adapter(transactionField = "NPCCWZTI-DADOS-SESSAO.NPCCWZTI-CUSUAR-SESSAO")
	private String cusuarsessao = null;

	@Adapter(transactionField = "NPCCWZTI-DADOS-SESSAO.NPCCWZTI-CDEPEN-SESSAO")
	private Integer cdepensessao = 0;

	@Adapter(transactionField = "NPCCWZTI-DADOS-SESSAO.NPCCWZTI-CTERMINAL")
	private String cterminal = null;

	@Adapter(transactionField = "NPCCWZTI-ENTRADA.NPCCWZTI-E-PERIODO-COTACAO-I")
	private String eperiodocotacaoi = null;

	@Adapter(transactionField = "NPCCWZTI-ENTRADA.NPCCWZTI-E-PERIODO-COTACAO-F")
	private String eperiodocotacaof = null;

	@Adapter(transactionField = "NPCCWZTI-ENTRADA.NPCCWZTI-E-CUNIC-CLI-CMBIO")
	private Long ecunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZTI-ENTRADA.NPCCWZTI-E-NBLETO-CMBIO-ANO")
	private Long enbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWZTI-ENTRADA.NPCCWZTI-E-NSEQ-UND-ORGNZ")
	private Integer ensequndorgnz = 0;

	@Adapter(transactionField = "NPCCWZTI-ENTRADA.NPCCWZTI-E-CUSUAR-INCLT")
	private String ecusuarinclt = null;

	@Adapter(transactionField = "NPCCWZTI-REGISTRO.NPCCWZTI-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZTI-REGISTRO.NPCCWZTI-GRIDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq.Npccwztirequest_gride")
	private List<Npccwztirequest_gride> gride = null;
	
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

	public Integer getCodretorno() {
		return codretorno;
	}
	public void setCodretorno(Integer codretorno) {
		this.codretorno = codretorno;
	}

	public String getCoderro() {
		return coderro;
	}
	public void setCoderro(String coderro) {
		this.coderro = coderro;
	}

	public String getCodmensagem() {
		return codmensagem;
	}
	public void setCodmensagem(String codmensagem) {
		this.codmensagem = codmensagem;
	}

	public String getCusuarsessao() {
		return cusuarsessao;
	}
	public void setCusuarsessao(String cusuarsessao) {
		this.cusuarsessao = cusuarsessao;
	}

	public Integer getCdepensessao() {
		return cdepensessao;
	}
	public void setCdepensessao(Integer cdepensessao) {
		this.cdepensessao = cdepensessao;
	}

	public String getCterminal() {
		return cterminal;
	}
	public void setCterminal(String cterminal) {
		this.cterminal = cterminal;
	}

	public String getEperiodocotacaoi() {
		return eperiodocotacaoi;
	}
	public void setEperiodocotacaoi(String eperiodocotacaoi) {
		this.eperiodocotacaoi = eperiodocotacaoi;
	}

	public String getEperiodocotacaof() {
		return eperiodocotacaof;
	}
	public void setEperiodocotacaof(String eperiodocotacaof) {
		this.eperiodocotacaof = eperiodocotacaof;
	}

	public Long getEcunicclicmbio() {
		return ecunicclicmbio;
	}
	public void setEcunicclicmbio(Long ecunicclicmbio) {
		this.ecunicclicmbio = ecunicclicmbio;
	}

	public Long getEnbletocmbioano() {
		return enbletocmbioano;
	}
	public void setEnbletocmbioano(Long enbletocmbioano) {
		this.enbletocmbioano = enbletocmbioano;
	}

	public Integer getEnsequndorgnz() {
		return ensequndorgnz;
	}
	public void setEnsequndorgnz(Integer ensequndorgnz) {
		this.ensequndorgnz = ensequndorgnz;
	}

	public String getEcusuarinclt() {
		return ecusuarinclt;
	}
	public void setEcusuarinclt(String ecusuarinclt) {
		this.ecusuarinclt = ecusuarinclt;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwztirequest_gride> getGride() {
		return gride;
	}
	public void setGride( List<Npccwztirequest_gride> gride) {
		this.gride = gride;
	}
    
}