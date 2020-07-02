package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;

//11. Reciprocidades não capturadas na aba "reciprocidade" no CLIM/ANAC
public class CartaoVO implements Comparable<CartaoVO> {

	private String numSequencial = "0";
	private String quantidade;
	private String resultado;
	private String bandeira;

	public CartaoVO() {

	}

	public CartaoVO(String quantidade, String resultado, String bandeira) {
		super();
		this.quantidade = quantidade;
		this.resultado = resultado;
		this.bandeira = bandeira;
	}

	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	public String getQuantidade() {
		return quantidade;
	}
	
	public String getQuantidadeFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(quantidade);
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getResultado() {
		return resultado;
	}
	
	public String getResultadoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(resultado);
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	@Override
	public int compareTo(CartaoVO o) {
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
				+ ((bandeira == null) ? 0 : bandeira.hashCode());
		result = prime * result
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
		result = prime * result
				+ ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result
				+ ((resultado == null) ? 0 : resultado.hashCode());
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
		CartaoVO other = (CartaoVO) obj;
		if (bandeira == null) {
			if (other.bandeira != null)
				return false;
		} else if (!bandeira.equals(other.bandeira))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		return true;
	}
	
}
