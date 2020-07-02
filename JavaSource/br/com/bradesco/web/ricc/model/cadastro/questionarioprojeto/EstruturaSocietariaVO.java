/**
 * 
 */
package br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto;

import java.io.Serializable;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class EstruturaSocietariaVO implements Comparable<EstruturaSocietariaVO>, Serializable {


	private static final long serialVersionUID = -496968361733879452L;
	
	private int numSequencial = 0;
	private String descAcionista;
	private String prcParticipacao;
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public int getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(int numSequencial) {
		this.numSequencial = numSequencial;
	}

	public String getDescAcionista() {
		return descAcionista;
	}

	public void setDescAcionista(String descAcionista) {
		this.descAcionista = descAcionista;
	}

	public String getPrcParticipacao() {
		return prcParticipacao;
	}

	public String getPrcParticipacaoFormatado() {
		return SiteUtil.getInstance().formatValoresToString(prcParticipacao);
	}
	
	public void setPrcParticipacao(String prcParticipacao) {
		this.prcParticipacao = prcParticipacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descAcionista == null) ? 0 : descAcionista.hashCode());
		result = prime * result + numSequencial;
		result = prime * result
				+ ((prcParticipacao == null) ? 0 : prcParticipacao.hashCode());
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
		EstruturaSocietariaVO other = (EstruturaSocietariaVO) obj;
		if (descAcionista == null) {
			if (other.descAcionista != null)
				return false;
		} else if (!descAcionista.equals(other.descAcionista))
			return false;
		if (numSequencial != other.numSequencial)
			return false;
		if (prcParticipacao == null) {
			if (other.prcParticipacao != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(prcParticipacao).equals(other.prcParticipacao))
			return false;
		return true;
	}

	@Override
	public int compareTo(EstruturaSocietariaVO o) {
		return this.hashCode() - o.hashCode();
	}

}
