package br.com.bradesco.web.ricc.model.permissoes;

public class MtVO implements Comparable<MtVO>{
	private String identificacao = "";

	public MtVO() {

	}

	public MtVO(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	
	@Override
	public int compareTo(MtVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
