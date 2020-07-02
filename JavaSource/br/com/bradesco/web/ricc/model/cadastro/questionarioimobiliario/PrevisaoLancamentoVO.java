package br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario;

import java.io.Serializable;

public class PrevisaoLancamentoVO implements Comparable<PrevisaoLancamentoVO>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2571895251383411873L;

	private String empreendimento;
	private String localizacao;
	private String vgvEstimado;
	private String dataPrevista;
	
	public PrevisaoLancamentoVO() {
		super();
	}
	
	
	public PrevisaoLancamentoVO(String empreendimento, String localizacao,
			String vgvEstimado, String dataPrevista) {
		super();
		this.empreendimento = empreendimento;
		this.localizacao = localizacao;
		this.vgvEstimado = vgvEstimado;
		this.dataPrevista = dataPrevista;
	}


	public String getEmpreendimento() {
		return empreendimento;
	}
	public void setEmpreendimento(String empreendimento) {
		this.empreendimento = empreendimento;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getVgvEstimado() {
		return vgvEstimado;
	}
	public void setVgvEstimado(String vgvEstimado) {
		this.vgvEstimado = vgvEstimado;
	}
	public String getDataPrevista() {
		return dataPrevista;
	}
	public void setDataPrevista(String dataPrevista) {
		this.dataPrevista = dataPrevista;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int compareTo(PrevisaoLancamentoVO o) {
		if(this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}
}
