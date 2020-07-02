package br.com.bradesco.web.ricc.model.manutencaomensagem;

public class BancoVO implements Comparable<BancoVO> {
	
	private String idBanco = "";
	
	public String getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}

	@Override
	public int compareTo(BancoVO o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
