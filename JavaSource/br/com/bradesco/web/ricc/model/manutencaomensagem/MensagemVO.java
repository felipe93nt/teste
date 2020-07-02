package br.com.bradesco.web.ricc.model.manutencaomensagem;

import br.com.bradesco.web.ricc.model.manutencaomensagem.MensagemVO;

public class MensagemVO implements Comparable<MensagemVO> {

	// Campos tabela
	private String codigoMensagem = "";
	private String referencia = "";
	private String data = "";
	private String usuario = "";
	private String status = "";
	private String beneficiario = "";
	private String ordenante = "";
	private String isnOsn = "";
	private String correspondente = "";
	private String departamento = "";
	private String moeda = "";
	private String valor = "";
	private String tipoTransmissao = "";
	
	public String getCodigoMensagem() {
		return codigoMensagem;
	}
	public void setCodigoMensagem(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getOrdenante() {
		return ordenante;
	}
	public void setOrdenante(String ordenante) {
		this.ordenante = ordenante;
	}
	public String getIsnOsn() {
		return isnOsn;
	}
	public void setIsnOsn(String isnOsn) {
		this.isnOsn = isnOsn;
	}
	public String getCorrespondente() {
		return correspondente;
	}
	public void setCorrespondente(String correspondente) {
		this.correspondente = correspondente;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getMoeda() {
		return moeda;
	}
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTipoTransmissao() {
		return tipoTransmissao;
	}
	public void setTipoTransmissao(String tipoTransmissao) {
		this.tipoTransmissao = tipoTransmissao;
	}
	@Override
	public int compareTo(MensagemVO o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
