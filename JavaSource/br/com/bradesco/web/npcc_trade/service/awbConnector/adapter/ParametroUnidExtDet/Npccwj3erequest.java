package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.math.BigDecimal;

/**
 * Arquivo gerado automaticamente em 05/10/18 18:45
 */
public class Npccwj3erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ3E-HEADER.NPCCWJ3E-COD-LAYOUT")
	private String codlayout = "NPCCWJ3E";

	@Adapter(transactionField = "NPCCWJ3E-HEADER.NPCCWJ3E-TAM-LAYOUT")
	private Integer tamlayout = 43;

	@Adapter(transactionField = "NPCCWJ3E-REGISTRO.NPCCWJ3E-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJ3E-REGISTRO.NPCCWJ3E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWJ3E-REGISTRO.NPCCWJ3E-VALOR-ME")
	private BigDecimal valorme = null;
	
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

	public BigDecimal getValorme() {
		return valorme;
	}
	public void setValorme(BigDecimal valorme) {
		this.valorme = valorme;
	}
    
}