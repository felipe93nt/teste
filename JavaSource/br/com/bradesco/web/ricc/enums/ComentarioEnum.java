package br.com.bradesco.web.ricc.enums;

public enum ComentarioEnum {
	ATIVIDADES_EMPRESA ("1", "1"),
	ORGANOGRAMA_EMPRESA ("1", "2"),
	PLANO_SUCESSAO("2", "1"),
	PATRIMONIO("3", "1"),
	CAPACIDADE_PRODUTIVA ("4", "1"),
	FORNECEDORES("5","1"),
	FORMA_RECEBIMENTO("5","2"),
	CONCORRENTES("5","3"),
	CARTEIRA("6","1"),
	FATURAMENTO_CONSOLIDADO("7","1"),
	HIGHLIGHTS_EMPRESA("8","1"),
	ENDIVIDAMENTO_BANCARIO("9","1"),
	RECIPROCIDADES("10","1"),
	QUADRO_ATIVOS("11", "1"),
	PAISES_EXPORTACAO("12", "1"),
	PROTECAO_CAMBIAL("12","2"),
	DETALHE_ESTRATEGIA("13","1"),
	PRINCIPAIS_INVESTIMENTOS("13","2"),
	OBRAS("14", "0"),
	OBRAS_ANDAMENTO("14", "1"),
	OBRAS_CONCLUIDAS("14", "2"),
	TRANSPORTES_SITUACAO_PRINCIPAIS_CONTRATOS("15", "1"),
	TRANSPORTES_LICITACOES_VENCIMENTOS("15", "2"),
	TRANSPORTES_OUTORGA("15", "3"),
	TRANSPORTES_PRINCIPAIS_INVESTIMENTOS("15", "4"),
	PROJETO_DESCRICAO_PROJETO("16", "1"),
	PROJETO_FONTES_FINANCIAMENTO("16", "2"),
	PROJETO_LICENCIAMENTO_SOCIOAMBIENTAL("16", "3");
	
	private String codigo = null;
	private String numSequencial = null;

	private ComentarioEnum(String codigo, String numSequencial) {
		this.codigo = codigo;
		this.numSequencial = numSequencial;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public Integer getCodigoInt() {
		return Integer.parseInt(codigo);
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumSequencial() {
		return numSequencial;
	}
	
	public Integer getNumSequencialInt() {
		return Integer.parseInt(numSequencial);
	}
	
	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}
	
}
