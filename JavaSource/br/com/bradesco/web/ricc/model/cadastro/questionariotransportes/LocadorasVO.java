package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

public class LocadorasVO {

	// -- INICIO % Faturamento
	private ValoresLocadorasVO valoresLocadorasAno1 = new ValoresLocadorasVO();
	private ValoresLocadorasVO valoresLocadorasAno2 = new ValoresLocadorasVO();
	private ValoresLocadorasVO valoresLocadorasAno3 = new ValoresLocadorasVO();
	private ValoresLocadorasVO valoresLocadorasAnoExpectativa = new ValoresLocadorasVO();
	// -- FIM % Faturamento

	private String descFaturamentoOutros = "";

	public ValoresLocadorasVO getValoresLocadorasAno1() {
		return valoresLocadorasAno1;
	}

	public void setValoresLocadorasAno1(ValoresLocadorasVO valoresLocadorasAno1) {
		this.valoresLocadorasAno1 = valoresLocadorasAno1;
	}

	public ValoresLocadorasVO getValoresLocadorasAno2() {
		return valoresLocadorasAno2;
	}

	public void setValoresLocadorasAno2(ValoresLocadorasVO valoresLocadorasAno2) {
		this.valoresLocadorasAno2 = valoresLocadorasAno2;
	}

	public ValoresLocadorasVO getValoresLocadorasAno3() {
		return valoresLocadorasAno3;
	}

	public void setValoresLocadorasAno3(ValoresLocadorasVO valoresLocadorasAno3) {
		this.valoresLocadorasAno3 = valoresLocadorasAno3;
	}

	public ValoresLocadorasVO getValoresLocadorasAnoExpectativa() {
		return valoresLocadorasAnoExpectativa;
	}

	public void setValoresLocadorasAnoExpectativa(
			ValoresLocadorasVO valoresLocadorasAnoExpectativa) {
		this.valoresLocadorasAnoExpectativa = valoresLocadorasAnoExpectativa;
	}

	public String getDescFaturamentoOutros() {
		return descFaturamentoOutros;
	}

	public void setDescFaturamentoOutros(String descFaturamentoOutros) {
		this.descFaturamentoOutros = descFaturamentoOutros;
	}

}
