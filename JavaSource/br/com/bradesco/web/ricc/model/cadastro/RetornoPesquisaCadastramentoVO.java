package br.com.bradesco.web.ricc.model.cadastro;

import java.util.ArrayList;
import java.util.List;

public class RetornoPesquisaCadastramentoVO {

	private String codGrupo = "";
	private String nomeGrupo = "";

	private List<CadastramentoVO> listaCadastro = new ArrayList<CadastramentoVO>();

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public List<CadastramentoVO> getListaCadastro() {
		return listaCadastro;
	}

	public void setListaCadastro(List<CadastramentoVO> listaCadastro) {
		this.listaCadastro = listaCadastro;
	}

}
