package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;

//8. Endividamento Bancário
public class EndividamentoBancarioVO implements Comparable<EndividamentoBancarioVO> {

	private String instituicaoFinanceira;
	private String modalidade;
	private String saldo;
	private String vencimentoFinal;
	private String valorVencimentoFinal;
	private String amortizacao;
	private String descGarantia;
	private String codGarantia;
	private String numSequencial = "0";
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public EndividamentoBancarioVO() {

	}

	public EndividamentoBancarioVO(String instituicaoFinanceira,
			String modalidade, String saldo, String vencimentoFinal,
			String amortizacao, String descGarantia) {
		super();
		this.instituicaoFinanceira = instituicaoFinanceira;
		this.modalidade = modalidade;
		this.saldo = saldo;
		this.vencimentoFinal = vencimentoFinal;
		this.amortizacao = amortizacao;
		this.descGarantia = descGarantia;
	}
	
	public String getSaldoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(saldo);
	}
	
	public String getValorVencimentoFinalFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valorVencimentoFinal);
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getVencimentoFinal() {
		return vencimentoFinal;
	}

	public void setVencimentoFinal(String vencimentoFinal) {
		this.vencimentoFinal = vencimentoFinal;
	}

	public String getValorVencimentoFinal() {
		return valorVencimentoFinal;
	}
	
	public void setValorVencimentoFinal(String valorVencimentoFinal) {
		this.valorVencimentoFinal = valorVencimentoFinal;
	}

	public String getAmortizacao() {
		return amortizacao;
	}

	public void setAmortizacao(String amortizacao) {
		this.amortizacao = amortizacao;
	}

	public String getDescGarantia() {
		return descGarantia;
	}

	public void setDescGarantia(String descGarantia) {
		this.descGarantia = descGarantia;
	}

	public String getCodGarantia() {
		return codGarantia;
	}

	public void setCodGarantia(String codGarantia) {
		this.codGarantia = codGarantia;
	}

	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	@Override
	public int compareTo(EndividamentoBancarioVO o) {
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
				+ ((amortizacao == null) ? 0 : amortizacao.hashCode());
		result = prime * result
				+ ((codGarantia == null) ? 0 : codGarantia.hashCode());
		result = prime * result
				+ ((descGarantia == null) ? 0 : descGarantia.hashCode());
		result = prime
				* result
				+ ((instituicaoFinanceira == null) ? 0 : instituicaoFinanceira
						.hashCode());
		result = prime * result
				+ ((modalidade == null) ? 0 : modalidade.hashCode());
		result = prime * result
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime
				* result
				+ ((valorVencimentoFinal == null) ? 0 : valorVencimentoFinal
						.hashCode());
		result = prime * result
				+ ((vencimentoFinal == null) ? 0 : vencimentoFinal.hashCode());
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
		EndividamentoBancarioVO other = (EndividamentoBancarioVO) obj;
		if (amortizacao == null) {
			if (other.amortizacao != null)
				return false;
		} else if (!amortizacao.equals(other.amortizacao))
			return false;
		if (codGarantia == null) {
			if (other.codGarantia != null)
				return false;
		} else if (!codGarantia.equals(other.codGarantia))
			return false;
		if (descGarantia == null) {
			if (other.descGarantia != null)
				return false;
		} else if (!descGarantia.equals(other.descGarantia))
			return false;
		if (instituicaoFinanceira == null) {
			if (other.instituicaoFinanceira != null)
				return false;
		} else if (!instituicaoFinanceira.equals(other.instituicaoFinanceira))
			return false;
		if (modalidade == null) {
			if (other.modalidade != null)
				return false;
		} else if (!modalidade.equals(other.modalidade))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(saldo).equals(other.saldo))
			return false;
		if (valorVencimentoFinal == null) {
			if (other.valorVencimentoFinal != null)
				return false;
		} else if (!valorVencimentoFinal.equals(other.valorVencimentoFinal))
			return false;
		if (vencimentoFinal == null) {
			if (other.vencimentoFinal != null)
				return false;
		} else if (!vencimentoFinal.equals(other.vencimentoFinal.replace(".", "/")))
			return false;
		return true;
	}
	

}
