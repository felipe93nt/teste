package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

public class FaturamentoEbitdaVO {

	private PercentualFaturamentoEbitdaVO prcFaturamento = new PercentualFaturamentoEbitdaVO();
	private PercentualFaturamentoEbitdaVO prcEbitda = new PercentualFaturamentoEbitdaVO();

	private String descReceitasPorSegmentoOutros = "";

	private String descSituacaoPrincipaisContratos = "";
	private String descLicitacoesVencimentos = "";
	private String descOutorgaUltimosValoresFonteFinanciamento = "";

	public PercentualFaturamentoEbitdaVO getPrcFaturamento() {
		return prcFaturamento;
	}

	public void setPrcFaturamento(PercentualFaturamentoEbitdaVO prcFaturamento) {
		this.prcFaturamento = prcFaturamento;
	}

	public PercentualFaturamentoEbitdaVO getPrcEbitda() {
		return prcEbitda;
	}

	public void setPrcEbitda(PercentualFaturamentoEbitdaVO prcEbitda) {
		this.prcEbitda = prcEbitda;
	}

	public String getDescSituacaoPrincipaisContratos() {
		return descSituacaoPrincipaisContratos;
	}

	public void setDescSituacaoPrincipaisContratos(
			String descSituacaoPrincipaisContratos) {
		this.descSituacaoPrincipaisContratos = descSituacaoPrincipaisContratos;
	}

	public String getDescLicitacoesVencimentos() {
		return descLicitacoesVencimentos;
	}

	public void setDescLicitacoesVencimentos(String descLicitacoesVencimentos) {
		this.descLicitacoesVencimentos = descLicitacoesVencimentos;
	}

	public String getDescOutorgaUltimosValoresFonteFinanciamento() {
		return descOutorgaUltimosValoresFonteFinanciamento;
	}

	public void setDescOutorgaUltimosValoresFonteFinanciamento(
			String descOutorgaUltimosValoresFonteFinanciamento) {
		this.descOutorgaUltimosValoresFonteFinanciamento = descOutorgaUltimosValoresFonteFinanciamento;
	}

	public String getDescReceitasPorSegmentoOutros() {
		return descReceitasPorSegmentoOutros;
	}

	public void setDescReceitasPorSegmentoOutros(
			String descReceitasPorSegmentoOutros) {
		this.descReceitasPorSegmentoOutros = descReceitasPorSegmentoOutros;
	}

}
