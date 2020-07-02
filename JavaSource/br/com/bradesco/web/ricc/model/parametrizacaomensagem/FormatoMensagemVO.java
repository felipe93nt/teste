package br.com.bradesco.web.ricc.model.parametrizacaomensagem;

import br.com.bradesco.web.ricc.model.manutencao.InstructionCodeVO;

public class FormatoMensagemVO implements Comparable<InstructionCodeVO> {

	private String identificacao = "";
	private String mt = "";
	private String descricao = "";
	private String inicioVigencia = "";
	private String fimVigencia = "";
	private String nivelAutorizacao = "";
	private String ultimaAtualizacao = "";
	private String usuario = "";

	public FormatoMensagemVO() {
	}

	public FormatoMensagemVO(String identificacao, String mt, String descricao,
			String inicioVigencia, String fimVigencia, String nivelAutorizacao,
			String ultimaAtualizacao, String usuario) {
		this.identificacao = identificacao;
		this.mt = mt;
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
		this.nivelAutorizacao = nivelAutorizacao;
		this.ultimaAtualizacao = ultimaAtualizacao;
		this.usuario = usuario;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getMt() {
		return mt;
	}

	public void setMt(String mt) {
		this.mt = mt;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public String getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(String fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public String getNivelAutorizacao() {
		return nivelAutorizacao;
	}

	public void setNivelAutorizacao(String nivelAutorizacao) {
		this.nivelAutorizacao = nivelAutorizacao;
	}

	public String getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(String ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int compareTo(InstructionCodeVO o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
