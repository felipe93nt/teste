package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

public class PrincipaisCustosOperacionaisVO {

	// -- INICIO % em relação ao custo total
	private CustosOperacionaisVO custosOperacionaisAno1 = new CustosOperacionaisVO();
	private CustosOperacionaisVO custosOperacionaisAno2 = new CustosOperacionaisVO();
	private CustosOperacionaisVO custosOperacionaisAno3 = new CustosOperacionaisVO();
	private CustosOperacionaisVO custosOperacionaisAnoExpectativa = new CustosOperacionaisVO();
	// -- FIM % em relação ao custo total

	// -- INICIO CAPEX (R$)
	private CapitalInvestidoVO capexAno1 = new CapitalInvestidoVO();
	private CapitalInvestidoVO capexAno2 = new CapitalInvestidoVO();
	private CapitalInvestidoVO capexAno3 = new CapitalInvestidoVO();
	private CapitalInvestidoVO capexAnoExpectativa = new CapitalInvestidoVO();
	// -- FIM CAPEX (R$)

	private String descPrincipaisInvestimentos = "";

	public CustosOperacionaisVO getCustosOperacionaisAno1() {
		return custosOperacionaisAno1;
	}

	public void setCustosOperacionaisAno1(
			CustosOperacionaisVO custosOperacionaisAno1) {
		this.custosOperacionaisAno1 = custosOperacionaisAno1;
	}

	public CustosOperacionaisVO getCustosOperacionaisAno2() {
		return custosOperacionaisAno2;
	}

	public void setCustosOperacionaisAno2(
			CustosOperacionaisVO custosOperacionaisAno2) {
		this.custosOperacionaisAno2 = custosOperacionaisAno2;
	}

	public CustosOperacionaisVO getCustosOperacionaisAno3() {
		return custosOperacionaisAno3;
	}

	public void setCustosOperacionaisAno3(
			CustosOperacionaisVO custosOperacionaisAno3) {
		this.custosOperacionaisAno3 = custosOperacionaisAno3;
	}

	public CustosOperacionaisVO getCustosOperacionaisAnoExpectativa() {
		return custosOperacionaisAnoExpectativa;
	}

	public void setCustosOperacionaisAnoExpectativa(
			CustosOperacionaisVO custosOperacionaisAnoExpectativa) {
		this.custosOperacionaisAnoExpectativa = custosOperacionaisAnoExpectativa;
	}

	public CapitalInvestidoVO getCapexAno1() {
		return capexAno1;
	}

	public void setCapexAno1(CapitalInvestidoVO capexAno1) {
		this.capexAno1 = capexAno1;
	}

	public CapitalInvestidoVO getCapexAno2() {
		return capexAno2;
	}

	public void setCapexAno2(CapitalInvestidoVO capexAno2) {
		this.capexAno2 = capexAno2;
	}

	public CapitalInvestidoVO getCapexAno3() {
		return capexAno3;
	}

	public void setCapexAno3(CapitalInvestidoVO capexAno3) {
		this.capexAno3 = capexAno3;
	}

	public CapitalInvestidoVO getCapexAnoExpectativa() {
		return capexAnoExpectativa;
	}

	public void setCapexAnoExpectativa(CapitalInvestidoVO capexAnoExpectativa) {
		this.capexAnoExpectativa = capexAnoExpectativa;
	}

	public String getDescPrincipaisInvestimentos() {
		return descPrincipaisInvestimentos;
	}

	public void setDescPrincipaisInvestimentos(
			String descPrincipaisInvestimentos) {
		this.descPrincipaisInvestimentos = descPrincipaisInvestimentos;
	}

}
