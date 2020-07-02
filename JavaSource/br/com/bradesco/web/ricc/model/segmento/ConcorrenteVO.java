package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class ConcorrenteVO implements Comparable<ConcorrenteVO> {

	private String concorrente;
	private String porcentagem;
	private String numSequencial = "0";
	private String tipoCliente;

	public ConcorrenteVO() {

	}

	public ConcorrenteVO(String concorrente) {
		super();
		this.concorrente = concorrente;
	}

	public String getConcorrente() {
		return concorrente;
	}

	public void setConcorrente(String concorrente) {
		this.concorrente = concorrente;
	}
	
	public String getPorcentagem() {
		return porcentagem;
	}
	
	public void setPorcentagem(String porcentagem) {
		this.porcentagem = porcentagem;
	}

	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public int compareTo(ConcorrenteVO o) {
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
				+ ((concorrente == null) ? 0 : concorrente.hashCode());
		result = prime * result
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
		result = prime * result
				+ ((porcentagem == null) ? 0 : porcentagem.hashCode());
		result = prime * result
				+ ((tipoCliente == null) ? 0 : tipoCliente.hashCode());
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
		ConcorrenteVO other = (ConcorrenteVO) obj;
		if (concorrente == null) {
			if (other.concorrente != null)
				return false;
		} else if (!concorrente.equals(other.concorrente))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		if (porcentagem == null) {
			if (other.porcentagem != null)
				return false;
		} else if (!porcentagem.equals(other.porcentagem))
			return false;
		if (tipoCliente == null) {
			if (other.tipoCliente != null)
				return false;
		} else if (!tipoCliente.equals(other.tipoCliente))
			return false;
		return true;
	}

	public String getPorcentagemFormatado() {
		return SiteUtil.getInstance().formatValoresToString(porcentagem);
	}

}
