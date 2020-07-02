package br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario;

import java.io.Serializable;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class LandBankVO implements Comparable<LandBankVO>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3683086292154330043L;

	private Integer numSequencial = 0;
	private String empreendimento = "";
	private String localizacao = "";
	private String valorTerreno = "";
	private String vgvEstimado = "";
	private String dataPrevista = "";
	private String possuiOnus = "";
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public Integer getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(Integer numSequencial) {
		this.numSequencial = numSequencial;
	}

	public LandBankVO() {
		super();
	}

	public LandBankVO(String empreendimento, String localizacao,
			String valorTerreno, String vgvEstimado, String dataPrevista,
			String possuiOnus) {
		super();
		this.empreendimento = empreendimento;
		this.localizacao = localizacao;
		this.valorTerreno = valorTerreno;
		this.vgvEstimado = vgvEstimado;
		this.dataPrevista = dataPrevista;
		this.possuiOnus = possuiOnus;
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

	public String getValorTerreno() {
		return valorTerreno;
	}
	
	public String getValorTerrenoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valorTerreno);
	}

	public void setValorTerreno(String valorTerreno) {
		this.valorTerreno = valorTerreno;
	}

	public String getVgvEstimado() {
		return vgvEstimado;
	}
	
	public String getVgvEstimadoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(vgvEstimado);
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

	public String getPossuiOnus() {
		return possuiOnus;
	}

	public void setPossuiOnus(String possuiOnus) {
		this.possuiOnus = possuiOnus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataPrevista == null) ? 0 : dataPrevista.hashCode());
		result = prime * result
				+ ((empreendimento == null) ? 0 : empreendimento.hashCode());
		result = prime * result
				+ ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result
				+ ((possuiOnus == null) ? 0 : possuiOnus.hashCode());
		result = prime * result
				+ ((valorTerreno == null) ? 0 : valorTerreno.hashCode());
		result = prime * result
				+ ((vgvEstimado == null) ? 0 : vgvEstimado.hashCode());
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
		LandBankVO other = (LandBankVO) obj;
		if (dataPrevista == null) {
			if (other.dataPrevista != null)
				return false;
		} else if (!dataPrevista.equals(other.dataPrevista.replace(".", "/")))
			return false;
		if (empreendimento == null) {
			if (other.empreendimento != null)
				return false;
		} else if (!empreendimento.equals(other.empreendimento))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (possuiOnus == null) {
			if (other.possuiOnus != null)
				return false;
		} else if (!possuiOnus.equals(other.possuiOnus))
			return false;
		if (valorTerreno == null) {
			if (other.valorTerreno != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valorTerreno).equals(other.valorTerreno))
			return false;
		if (vgvEstimado == null) {
			if (other.vgvEstimado != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(vgvEstimado).equals(other.vgvEstimado))
			return false;
		return true;
	}

	@Override
	public int compareTo(LandBankVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}

}
