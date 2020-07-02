package br.com.bradesco.web.ricc.model.permissoes;

public class InstrucoesVO implements Comparable<InstrucoesVO> {
	
	private String identificacao = "";
	
	public InstrucoesVO() {

	}
	
	public InstrucoesVO(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	@Override
	public int compareTo(InstrucoesVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
