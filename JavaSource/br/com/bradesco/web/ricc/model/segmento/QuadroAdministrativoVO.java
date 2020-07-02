package br.com.bradesco.web.ricc.model.segmento;


public class QuadroAdministrativoVO implements Comparable<QuadroAdministrativoVO> {
	
	private String administrador;
	private String cargo;
	private String numSequencial = "0";
	private String maxOcorrencias;

	public QuadroAdministrativoVO() {
		super();
	}

	public QuadroAdministrativoVO(String administrador, String cargo) {
		super();
		this.administrador = administrador;
		this.cargo = cargo;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	public String getMaxOcorrencias() {
		return maxOcorrencias;
	}

	public void setMaxOcorrencias(String maxOcorrencias) {
		this.maxOcorrencias = maxOcorrencias;
	}

	@Override
	public int compareTo(QuadroAdministrativoVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((administrador == null) ? 0 : administrador.hashCode());
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result
				+ ((maxOcorrencias == null) ? 0 : maxOcorrencias.hashCode());
		result = prime * result
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
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
		QuadroAdministrativoVO other = (QuadroAdministrativoVO) obj;
		if (administrador == null) {
			if (other.administrador != null)
				return false;
		} else if (!administrador.equals(other.administrador))
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (maxOcorrencias == null) {
			if (other.maxOcorrencias != null)
				return false;
		} else if (!maxOcorrencias.equals(other.maxOcorrencias))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		return true;
	}
	
}
