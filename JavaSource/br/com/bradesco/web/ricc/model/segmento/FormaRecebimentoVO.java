package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class FormaRecebimentoVO implements Comparable<FormaRecebimentoVO> {

	private String formaRecebimento;
	private String porcentagem;
	private String numSequencial = "0";
	private String tipoCliente;
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public FormaRecebimentoVO() {
		super();
	}

	public FormaRecebimentoVO(String formaRecebimento, String porcentagem) {
		super();
		this.formaRecebimento = formaRecebimento;
		this.porcentagem = porcentagem;
	}
	
	public String getPorcentagemFormatado() {
		return SiteUtil.getInstance().formatValoresToString(porcentagem);
	}

	public String getFormaRecebimento() {
		return formaRecebimento;
	}

	public void setFormaRecebimento(String formaRecebimento) {
		this.formaRecebimento = formaRecebimento;
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
	public int compareTo(FormaRecebimentoVO o) {
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
		result = prime
				* result
				+ ((formaRecebimento == null) ? 0 : formaRecebimento.hashCode());
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
		FormaRecebimentoVO other = (FormaRecebimentoVO) obj;
		if (formaRecebimento == null) {
			if (other.formaRecebimento != null)
				return false;
		} else if (!formaRecebimento.equals(other.formaRecebimento))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		if (porcentagem == null) {
			if (other.porcentagem != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(porcentagem).equals(other.porcentagem))
			return false;
		if (tipoCliente == null) {
			if (other.tipoCliente != null)
				return false;
		} else if (!tipoCliente.equals(other.tipoCliente))
			return false;
		return true;
	}
	
	

}
