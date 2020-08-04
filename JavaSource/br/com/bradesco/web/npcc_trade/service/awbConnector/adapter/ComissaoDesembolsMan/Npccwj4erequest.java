package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsMan;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.math.BigDecimal;

/**
 * Arquivo gerado automaticamente em 20/11/18 18:01
 */
public class Npccwj4erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ4E-HEADER.NPCCWJ4E-COD-LAYOUT")
	private String codlayout = "NPCCWJ4E";

	@Adapter(transactionField = "NPCCWJ4E-HEADER.NPCCWJ4E-TAM-LAYOUT")
	private Integer tamlayout = 61;

	@Adapter(transactionField = "NPCCWJ4E-REGISTRO.NPCCWJ4E-FUNCAO")
	private String funcao = null;

	@Adapter(transactionField = "NPCCWJ4E-REGISTRO.NPCCWJ4E-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJ4E-REGISTRO.NPCCWJ4E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWJ4E-REGISTRO.NPCCWJ4E-VLIM-COMIS-FIXA")
	private BigDecimal vlimcomisfixa = null;

	@Adapter(transactionField = "NPCCWJ4E-REGISTRO.NPCCWJ4E-VCOMIS-FIXA")
	private BigDecimal vcomisfixa = null;
	
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

	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
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

	public BigDecimal getVlimcomisfixa() {
		return vlimcomisfixa;
	}
	public void setVlimcomisfixa(BigDecimal vlimcomisfixa) {
		this.vlimcomisfixa = vlimcomisfixa;
	}

	public BigDecimal getVcomisfixa() {
		return vcomisfixa;
	}
	public void setVcomisfixa(BigDecimal vcomisfixa) {
		this.vcomisfixa = vcomisfixa;
	}
    
}