package br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario;

import java.io.Serializable;

import br.com.bradesco.web.ricc.converter.BaseEntity;

public class AreaAtuacaoVO implements BaseEntity, Comparable<AreaAtuacaoVO>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7737902086076586856L;
	
	private Integer numSequencial = 0;
	private String estado = "";
	private String regiao = "";
	
	public AreaAtuacaoVO() {
		super();
	}
	
	public AreaAtuacaoVO(String estado, String regiao) {
		super();
		this.estado = estado;
		this.regiao = regiao;
	}


	public Integer getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(Integer numSequencial) {
		this.numSequencial = numSequencial;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaAtuacaoVO other = (AreaAtuacaoVO) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (regiao == null) {
			if (other.regiao != null)
				return false;
		} else if (!regiao.equals(other.regiao))
			return false;
		return true;
	}
	
	@Override
	public Long getId() {
		return Long.valueOf(numSequencial);
	}

	@Override
	public int compareTo(AreaAtuacaoVO o) {
		if(this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}

	
}
