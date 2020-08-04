package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 10/11/18 23:58
 */
public class Npccwx2erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX2E-HEADER.NPCCWX2E-COD-LAYOUT")
	private String codlayout = "NPCCWX2E";

	@Adapter(transactionField = "NPCCWX2E-HEADER.NPCCWX2E-TAM-LAYOUT")
	private Integer tamlayout = 3453;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-CBANQR-CMBIO-FNDNG")
	private Long cbanqrcmbiofndng = 0L;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-CINDCD-NEGOC-CARTA")
	private String cindcdnegoccarta = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-VALOR-OPERACAO")
	private String valoroperacao = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-SPREAD-CLEAN")
	private String spreadclean = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-PTX-FIXA-CMBIO")
	private String ptxfixacmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-CINDCD-TIPO-ACCES")
	private Integer cindcdtipoacces = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-DVALDD-NEGOC-CMBIO")
	private String dvalddnegoccmbio = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-CINDCD-NEGOC-SWAP")
	private String cindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-CNEGOC-SWAP-FLUXO")
	private String cnegocswapfluxo = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-VMIN-COBR-COMIS")
	private String vmincobrcomis = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-QTD-OCORR")
	private Integer qtdocorr = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-QTD-OCORR-MERC")
	private Integer qtdocorrmerc = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao.Npccwx2erequest_lista")
	private List<Npccwx2erequest_lista> lista = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LST-MERC", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao.Npccwx2erequest_lstmerc")
	private List<Npccwx2erequest_lstmerc> lstmerc = null;
	
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

	public Long getCbanqrcmbiofndng() {
		return cbanqrcmbiofndng;
	}
	public void setCbanqrcmbiofndng(Long cbanqrcmbiofndng) {
		this.cbanqrcmbiofndng = cbanqrcmbiofndng;
	}

	public String getCindcdnegoccarta() {
		return cindcdnegoccarta;
	}
	public void setCindcdnegoccarta(String cindcdnegoccarta) {
		this.cindcdnegoccarta = cindcdnegoccarta;
	}

	public String getValoroperacao() {
		return valoroperacao;
	}
	public void setValoroperacao(String valoroperacao) {
		this.valoroperacao = valoroperacao;
	}

	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}
	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}

	public String getSpreadclean() {
		return spreadclean;
	}
	public void setSpreadclean(String spreadclean) {
		this.spreadclean = spreadclean;
	}

	public String getPtxfixacmbio() {
		return ptxfixacmbio;
	}
	public void setPtxfixacmbio(String ptxfixacmbio) {
		this.ptxfixacmbio = ptxfixacmbio;
	}

	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}

	public Integer getCindcdtipoacces() {
		return cindcdtipoacces;
	}
	public void setCindcdtipoacces(Integer cindcdtipoacces) {
		this.cindcdtipoacces = cindcdtipoacces;
	}

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getDvalddnegoccmbio() {
		return dvalddnegoccmbio;
	}
	public void setDvalddnegoccmbio(String dvalddnegoccmbio) {
		this.dvalddnegoccmbio = dvalddnegoccmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public String getCindcdnegocswap() {
		return cindcdnegocswap;
	}
	public void setCindcdnegocswap(String cindcdnegocswap) {
		this.cindcdnegocswap = cindcdnegocswap;
	}

	public String getCnegocswapfluxo() {
		return cnegocswapfluxo;
	}
	public void setCnegocswapfluxo(String cnegocswapfluxo) {
		this.cnegocswapfluxo = cnegocswapfluxo;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getVmincobrcomis() {
		return vmincobrcomis;
	}
	public void setVmincobrcomis(String vmincobrcomis) {
		this.vmincobrcomis = vmincobrcomis;
	}

	public Integer getQtdocorr() {
		return qtdocorr;
	}
	public void setQtdocorr(Integer qtdocorr) {
		this.qtdocorr = qtdocorr;
	}

	public Integer getQtdocorrmerc() {
		return qtdocorrmerc;
	}
	public void setQtdocorrmerc(Integer qtdocorrmerc) {
		this.qtdocorrmerc = qtdocorrmerc;
	}

	public List<Npccwx2erequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwx2erequest_lista> lista) {
		this.lista = lista;
	}

	public List<Npccwx2erequest_lstmerc> getLstmerc() {
		return lstmerc;
	}
	public void setLstmerc( List<Npccwx2erequest_lstmerc> lstmerc) {
		this.lstmerc = lstmerc;
	}
    
}