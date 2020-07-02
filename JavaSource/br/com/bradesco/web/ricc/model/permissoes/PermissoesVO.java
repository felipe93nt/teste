package br.com.bradesco.web.ricc.model.permissoes;

public class PermissoesVO implements Comparable<PermissoesVO> {

	private String matriculaFunc = "";
	private String nomeFunc = "";
	private String codigoBic = "";
	private String instituicao = "";
	private String nivelAlcada = "";
	private String ultimaAlteracao = "";

	public PermissoesVO() {
	}

	public PermissoesVO(String matriculaFunc, String nomeFunc,
			String codigoBic, String instituicao, String nivelAlcada,
			String ultimaAlteracao) {
		this.matriculaFunc = matriculaFunc;
		this.nomeFunc = nomeFunc;
		this.codigoBic = codigoBic;
		this.instituicao = instituicao;
		this.nivelAlcada = nivelAlcada;
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String getMatriculaFunc() {
		return matriculaFunc;
	}

	public void setMatriculaFunc(String matriculaFunc) {
		this.matriculaFunc = matriculaFunc;
	}

	public String getNomeFunc() {
		return nomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}

	public String getCodigoBic() {
		return codigoBic;
	}

	public void setCodigoBic(String codigoBic) {
		this.codigoBic = codigoBic;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getNivelAlcada() {
		return nivelAlcada;
	}

	public void setNivelAlcada(String nivelAlcada) {
		this.nivelAlcada = nivelAlcada;
	}

	public String getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(String ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	@Override
	public int compareTo(PermissoesVO o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
