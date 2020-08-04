package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtMan;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 03/10/18 15:12
 */
public class Npccwj7erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ7E-HEADER.NPCCWJ7E-COD-LAYOUT")
	private String codlayout = "NPCCWJ7E";

	@Adapter(transactionField = "NPCCWJ7E-HEADER.NPCCWJ7E-TAM-LAYOUT")
	private Integer tamlayout = 1366;

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-FUNCAO-IAE")
	private String funcaoiae = null;

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-VLIM-APROV-CUSTO")
	private String vlimaprovcusto = null;

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-QTD-FAIXA-OPER")
	private Integer qtdfaixaoper = 0;

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-FAIXAS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtMan.Npccwj7erequest_faixas")
	private List<Npccwj7erequest_faixas> faixas = null;
	
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

	public String getFuncaoiae() {
		return funcaoiae;
	}
	public void setFuncaoiae(String funcaoiae) {
		this.funcaoiae = funcaoiae;
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

	public String getVlimaprovcusto() {
		return vlimaprovcusto;
	}
	public void setVlimaprovcusto(String vlimaprovcusto) {
		this.vlimaprovcusto = vlimaprovcusto;
	}

	public Integer getQtdfaixaoper() {
		return qtdfaixaoper;
	}
	public void setQtdfaixaoper(Integer qtdfaixaoper) {
		this.qtdfaixaoper = qtdfaixaoper;
	}

	public List<Npccwj7erequest_faixas> getFaixas() {
		return faixas;
	}
	public void setFaixas( List<Npccwj7erequest_faixas> faixas) {
		this.faixas = faixas;
	}
    
}