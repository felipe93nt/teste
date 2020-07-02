package br.com.bradesco.web.ricc.model.cadastro;

import java.io.Serializable;

public class PesquisaCadastramentoVO implements Serializable {
	/**
	 * Atributo serialVersionUID 
	 * Tipo long
	 */
	private static final long serialVersionUID = 2032300829103448600L;
	
	// Campos pesquisa
	private String versaoOrigem = "";
	private String cnpj = "";
	private String numGrupo = "";
	private String nomeGrupo = "";
	private String status = "";
	private Integer tipoPesquisa = 0;
	
	private String numGrupoLabel = "";
	private String nomeGrupoLabel = "";

	public String getCnpj() {
		return cnpj;
	}

	public String getVersaoOrigem() {
		return versaoOrigem;
	}

	public void setVersaoOrigem(String versaoOrigem) {
		this.versaoOrigem = versaoOrigem;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNumGrupo() {
		return numGrupo;
	}

	public void setNumGrupo(String numGrupo) {
		this.numGrupo = numGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public Integer getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(Integer tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNumGrupoLabel() {
		return numGrupoLabel;
	}

	public void setNumGrupoLabel(String numGrupoLabel) {
		this.numGrupoLabel = numGrupoLabel;
	}

	public String getNomeGrupoLabel() {
		return nomeGrupoLabel;
	}

	public void setNomeGrupoLabel(String nomeGrupoLabel) {
		this.nomeGrupoLabel = nomeGrupoLabel;
	}

}
