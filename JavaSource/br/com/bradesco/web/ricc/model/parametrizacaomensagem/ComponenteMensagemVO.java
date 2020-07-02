package br.com.bradesco.web.ricc.model.parametrizacaomensagem;

import br.com.bradesco.web.ricc.model.manutencao.InstructionCodeVO;

public class ComponenteMensagemVO implements Comparable<InstructionCodeVO>{
	
	public String identidade = "";
	public String idGrupo = "";
	public String tpComp = "";
	public String descricao = "";
	public String bloco = "";
	public String tagOpc = "";
	public String tagXML = "";
	public String linhas = "";
	public String tipoDado = "";
	public String formato = "";
	public String tamanho = "";
	public String fixo = "";
	public String validador = "";
	public String ultAlt = "";
	public String usuario = "";
	
	public ComponenteMensagemVO(){
		
	}
	
	public ComponenteMensagemVO(String identidade, String idGrupo,
			String tpComp, String descricao, String bloco, String tagOpc,
			String tagXML, String linhas, String tipoDado, String formato,
			String tamanho, String fixo, String validador, String ultAlt,
			String usuario) {
		this.identidade = identidade;
		this.idGrupo = idGrupo;
		this.tpComp = tpComp;
		this.descricao = descricao;
		this.bloco = bloco;
		this.tagOpc = tagOpc;
		this.tagXML = tagXML;
		this.linhas = linhas;
		this.tipoDado = tipoDado;
		this.formato = formato;
		this.tamanho = tamanho;
		this.fixo = fixo;
		this.validador = validador;
		this.ultAlt = ultAlt;
		this.usuario = usuario;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getTpComp() {
		return tpComp;
	}

	public void setTpComp(String tpComp) {
		this.tpComp = tpComp;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getTagOpc() {
		return tagOpc;
	}

	public void setTagOpc(String tagOpc) {
		this.tagOpc = tagOpc;
	}

	public String getTagXML() {
		return tagXML;
	}

	public void setTagXML(String tagXML) {
		this.tagXML = tagXML;
	}

	public String getLinhas() {
		return linhas;
	}

	public void setLinhas(String linhas) {
		this.linhas = linhas;
	}

	public String getTipoDado() {
		return tipoDado;
	}

	public void setTipoDado(String tipoDado) {
		this.tipoDado = tipoDado;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getValidador() {
		return validador;
	}

	public void setValidador(String validador) {
		this.validador = validador;
	}

	public String getUltAlt() {
		return ultAlt;
	}

	public void setUltAlt(String ultAlt) {
		this.ultAlt = ultAlt;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int compareTo(InstructionCodeVO o) {
		return 0;
	}

}
