package br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto;

import java.io.Serializable;
import java.util.Date;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class UsosFontesVO implements Comparable<UsosFontesVO>, Serializable {
	
	private static final long serialVersionUID = -7709204237855313663L;
	
	private int numSequencial = 0;
	private Date dtInicio;
	private Date dtTermino;
	private String dtInicioFormat = "";
	private String dtTerminoFormat = "";
	
	/*
	 * 1 - Usos 
	 * 2 - Fontes
	 */
	private Integer cdTipoDocumento;
	private String descTipoDocumento;
	private String descUsosFontes;
	private String prcParticipacao;
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public int getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(int numSequencial) {
		this.numSequencial = numSequencial;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtTermino() {
		return dtTermino;
	}

	public void setDtTermino(Date dtTermino) {
		this.dtTermino = dtTermino;
	}

	public Integer getCdTipoDocumento() {
		return cdTipoDocumento;
	}

	public void setCdTipoDocumento(Integer cdTipoDocumento) {
		this.cdTipoDocumento = cdTipoDocumento;
	}

	public String getDescUsosFontes() {
		return descUsosFontes;
	}

	public void setDescUsosFontes(String descUsosFontes) {
		this.descUsosFontes = descUsosFontes;
	}

	public String getPrcParticipacao() {
		return prcParticipacao;
	}

	public void setPrcParticipacao(String prcParticipacao) {
		this.prcParticipacao = prcParticipacao;
	}
	
	public String getPrcParticipacaoFormatado() {
		return SiteUtil.getInstance().formatValoresToString(prcParticipacao);
	}
	
	public String getDescTipoDocumento() {
		if(null != this.cdTipoDocumento){
			if(1 == this.cdTipoDocumento){
				setDescTipoDocumento("Usos");
			} else if(2 == this.cdTipoDocumento){
				setDescTipoDocumento("Fontes");
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
				+ ((descTipoDocumento == null) ? 0 : descTipoDocumento
						.hashCode());
		result = prime * result
				+ ((descUsosFontes == null) ? 0 : descUsosFontes.hashCode());
		result = prime * result
				+ ((dtInicio == null) ? 0 : dtInicio.hashCode());
		result = prime * result
				+ ((dtTermino == null) ? 0 : dtTermino.hashCode());
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
		UsosFontesVO other = (UsosFontesVO) obj;
		if (cdTipoDocumento == null) {
			if (other.cdTipoDocumento != null)
				return false;
		} else if (!cdTipoDocumento.equals(other.cdTipoDocumento))
			return false;
		if (descTipoDocumento == null) {
			if (other.descTipoDocumento != null)
				return false;
		} else if (!descTipoDocumento.equals(other.descTipoDocumento))
			return false;
		if (descUsosFontes == null) {
			if (other.descUsosFontes != null)
				return false;
		} else if (!descUsosFontes.equals(other.descUsosFontes))
			return false;
		if (dtInicio == null) {
			if (other.dtInicio != null)
				return false;
		} else if (!dtInicio.equals(other.dtInicio))
			return false;
		if (dtTermino == null) {
			if (other.dtTermino != null)
				return false;
		} else if (!dtTermino.equals(other.dtTermino))
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
	public int compareTo(UsosFontesVO o) {
		if(this.hashCode() == o.hashCode()) {
			return 0;
		}
		return -1;
	}
	
	public boolean equalsPersonalzado(Object obj){
		
		boolean ret = true;
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsosFontesVO other = (UsosFontesVO) obj;
		
		if(this.descUsosFontes == null){
			if(other.descUsosFontes == null){
				ret = true;
			}else{
				ret = false;
			}
		}else{
			if(this.descUsosFontes.equals(other.descUsosFontes)){
				ret = true;
			}else{
				ret = false;
			}
		}
		
		if(ret){
			if(this.prcParticipacao == null){
				if(other.prcParticipacao == null){
					ret = true;
				}else{
					ret = false;
				}
			}else{
				if(siteUtil.valueToMainframeString(prcParticipacao).equals(other.prcParticipacao)){
					ret = true;
				}else{
					ret = false;
				}
			}
		}
		
		if(ret && this.descUsosFontes != null && !this.descUsosFontes.equals("") && this.prcParticipacao != null && !this.prcParticipacao.equals("")){
			if(this.dtInicio == null){
				if(other.dtInicio == null){
					ret = true;
				}else{
					ret = false;
				}
			}else{
				if(this.dtInicio.equals(other.dtInicio)){
					ret = true;
				}else{
					ret = false;
				}
			}
			
			if(ret){
				if(this.dtTermino == null){
					if(other.dtTermino == null){
						ret = true;
					}else{
						ret = false;
					}
				}else{
					if(this.dtTermino.equals(other.dtTermino)){
						ret = true;
					}else{
						ret = false;
					}
				}
			}
			
		}
		
		return ret;
	}

	public String getDtInicioFormat() {
		return dtInicioFormat;
	}

	public void setDtInicioFormat(String dtInicioFormat) {
		this.dtInicioFormat = dtInicioFormat;
	}

	public String getDtTerminoFormat() {
		return dtTerminoFormat;
	}

	public void setDtTerminoFormat(String dtTerminoFormat) {
		this.dtTerminoFormat = dtTerminoFormat;
	}

}