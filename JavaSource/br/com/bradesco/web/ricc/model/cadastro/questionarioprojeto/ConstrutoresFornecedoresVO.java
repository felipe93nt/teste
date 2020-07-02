package br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto;

import java.io.Serializable;

public class ConstrutoresFornecedoresVO implements Comparable<ConstrutoresFornecedoresVO>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private int numSequencial = 0;
	/*
	 * 1 - Construtores 
	 * 2 - Fornecedores
	 */
	private Integer cdTipoDocumento;
	private String descTipoDocumento;
	private String descConstrutoresFornecedores;

	public int getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(int numSequencial) {
		this.numSequencial = numSequencial;
	}

	public Integer getCdTipoDocumento() {
		return cdTipoDocumento;
	}

	public void setCdTipoDocumento(Integer cdTipoDocumento) {
		this.cdTipoDocumento = cdTipoDocumento;
	}

	public String getDescConstrutoresFornecedores() {
		return descConstrutoresFornecedores;
	}

	public void setDescConstrutoresFornecedores(
			String descConstrutoresFornecedores) {
		this.descConstrutoresFornecedores = descConstrutoresFornecedores;
	}
	
	public String getDescTipoDocumento() {
		if(null != this.cdTipoDocumento){
			if(1 == this.cdTipoDocumento){
				setDescTipoDocumento("Construtores");
			} else if(2 == this.cdTipoDocumento){
				setDescTipoDocumento("Fornecedores");
			}
		}
		return descTipoDocumento;
	}

	public void setDescTipoDocumento(String descTipoDocumento) {
		this.descTipoDocumento = descTipoDocumento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cdTipoDocumento == null) ? 0 : cdTipoDocumento.hashCode());
		result = prime
				* result
				+ ((descConstrutoresFornecedores == null) ? 0
						: descConstrutoresFornecedores.hashCode());
		result = prime
				* result
				+ ((descTipoDocumento == null) ? 0 : descTipoDocumento
						.hashCode());
		result = prime * result + numSequencial;
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
		ConstrutoresFornecedoresVO other = (ConstrutoresFornecedoresVO) obj;
		if (cdTipoDocumento == null) {
			if (other.cdTipoDocumento != null)
				return false;
		} else if (!cdTipoDocumento.equals(other.cdTipoDocumento))
			return false;
		if (descConstrutoresFornecedores == null) {
			if (other.descConstrutoresFornecedores != null)
				return false;
		} else if (!descConstrutoresFornecedores
				.equals(other.descConstrutoresFornecedores))
			return false;
		if (descTipoDocumento == null) {
			if (other.descTipoDocumento != null)
				return false;
		} else if (!descTipoDocumento.equals(other.descTipoDocumento))
			return false;
		if (numSequencial != other.numSequencial)
			return false;
		return true;
	}

	@Override
	public int compareTo(ConstrutoresFornecedoresVO o) {
		if(this.hashCode() == o.hashCode()){
			return 0;
		}
		return -1;
	}

}
