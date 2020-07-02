package br.com.bradesco.web.ricc.model.cadastro.questionariocorporate;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class QuadroAtivosCorporateVO implements
		Comparable<QuadroAtivosCorporateVO> {

	private String numSequencial="0";
	private String concessoesProjetosSpes;
	private String porcParticipacao;
	private String informacoesRelevantes;
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	public QuadroAtivosCorporateVO() {
		super();
	}

	public QuadroAtivosCorporateVO(String concessoesProjetosSpes,
			String porcParticipacao, String informacoesRelevantes) {
		super();
		this.concessoesProjetosSpes = concessoesProjetosSpes;
		this.porcParticipacao = porcParticipacao;
		this.informacoesRelevantes = informacoesRelevantes;
	}

	public String getConcessoesProjetosSpes() {
		return concessoesProjetosSpes;
	}

	public void setConcessoesProjetosSpes(String concessoesProjetosSpes) {
		this.concessoesProjetosSpes = concessoesProjetosSpes;
	}

	public String getPorcParticipacao() {
		return porcParticipacao;
	}
	
	public String getPorcParticipacaoFormatado() {
		return SiteUtil.getInstance().formatValoresToString(porcParticipacao);
	}

	public void setPorcParticipacao(String porcParticipacao) {
		this.porcParticipacao = porcParticipacao;
	}

	public String getInformacoesRelevantes() {
		return informacoesRelevantes;
	}

	public void setInformacoesRelevantes(String informacoesRelevantes) {
		this.informacoesRelevantes = informacoesRelevantes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuadroAtivosCorporateVO other = (QuadroAtivosCorporateVO) obj;
		if (concessoesProjetosSpes == null) {
			if (other.concessoesProjetosSpes != null)
				return false;
		} else if (!concessoesProjetosSpes.equals(other.concessoesProjetosSpes))
			return false;
		if (porcParticipacao == null) {
			if (other.porcParticipacao != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(porcParticipacao).equals(other.porcParticipacao))
			return false;
		if (informacoesRelevantes == null) {
			if (other.informacoesRelevantes != null)
				return false;
		} else if (!informacoesRelevantes.equals(other.informacoesRelevantes))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(QuadroAtivosCorporateVO o) {
		return this.hashCode() - o.hashCode();
	}
}
