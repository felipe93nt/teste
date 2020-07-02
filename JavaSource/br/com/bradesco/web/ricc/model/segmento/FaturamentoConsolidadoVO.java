package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;


public class FaturamentoConsolidadoVO {

	private String ano = "";
	private String janeiro = "";
	private String fevereiro = "";
	private String marco = "";
	private String abril = "";
	private String maio = "";
	private String junho = "";
	private String julho = "";
	private String agosto = "";
	private String setembro = "";
	private String outubro = "";
	private String novembro = "";
	private String dezembro = "";
	private String totalFaturamento = "";
	private String mediaFaturamento = "";
	

	public FaturamentoConsolidadoVO() {
		super();
	}

	public FaturamentoConsolidadoVO(String ano, String janeiro,
			String fevereiro, String marco, String abril, String maio,
			String junho, String julho, String agosto, String setembro,
			String outubro, String novembro, String dezembro) {
		super();
		this.ano = ano;
		this.janeiro = janeiro;
		this.fevereiro = fevereiro;
		this.marco = marco;
		this.abril = abril;
		this.maio = maio;
		this.junho = junho;
		this.julho = julho;
		this.agosto = agosto;
		this.setembro = setembro;
		this.outubro = outubro;
		this.novembro = novembro;
		this.dezembro = dezembro;
	}
	
	public String getTotalFaturamentoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(totalFaturamento);
	}
	
	public String getMediaFaturamentoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(mediaFaturamento);
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getJaneiro() {
		return janeiro;
	}

	public void setJaneiro(String janeiro) {
		this.janeiro = janeiro;
	}

	public String getFevereiro() {
		return fevereiro;
	}

	public void setFevereiro(String fevereiro) {
		this.fevereiro = fevereiro;
	}
	
	public String getMarco() {
		return marco;
	}

	public void setMarco(String marco) {
		this.marco = marco;
	}

	public String getAbril() {
		return abril;
	}

	public void setAbril(String abril) {
		this.abril = abril;
	}

	public String getMaio() {
		return maio;
	}
	
	public void setMaio(String maio) {
		this.maio = maio;
	}

	public String getJunho() {
		return junho;
	}
	
	public void setJunho(String junho) {
		this.junho = junho;
	}

	public String getJulho() {
		return julho;
	}

	public void setJulho(String julho) {
		this.julho = julho;
	}

	public String getAgosto() {
		return agosto;
	}

	public void setAgosto(String agosto) {
		this.agosto = agosto;
	}

	public String getSetembro() {
		return setembro;
	}

	public void setSetembro(String setembro) {
		this.setembro = setembro;
	}

	public String getOutubro() {
		return outubro;
	}

	public void setOutubro(String outubro) {
		this.outubro = outubro;
	}

	public String getNovembro() {
		return novembro;
	}

	public void setNovembro(String novembro) {
		this.novembro = novembro;
	}

	public String getDezembro() {
		return dezembro;
	}

	public void setDezembro(String dezembro) {
		this.dezembro = dezembro;
	}
	
	public String getTotalFaturamento() {
		return totalFaturamento;
	}

	public void setTotalFaturamento(String totalFaturamento) {
		this.totalFaturamento = totalFaturamento;
	}

	public String getMediaFaturamento() {
		return mediaFaturamento;
	}

	public void setMediaFaturamento(String mediaFaturamento) {
		this.mediaFaturamento = mediaFaturamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abril == null) ? 0 : abril.hashCode());
		result = prime * result + ((agosto == null) ? 0 : agosto.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result
				+ ((dezembro == null) ? 0 : dezembro.hashCode());
		result = prime * result
				+ ((fevereiro == null) ? 0 : fevereiro.hashCode());
		result = prime * result + ((janeiro == null) ? 0 : janeiro.hashCode());
		result = prime * result + ((julho == null) ? 0 : julho.hashCode());
		result = prime * result + ((junho == null) ? 0 : junho.hashCode());
		result = prime * result + ((maio == null) ? 0 : maio.hashCode());
		result = prime * result + ((marco == null) ? 0 : marco.hashCode());
		result = prime * result
				+ ((novembro == null) ? 0 : novembro.hashCode());
		result = prime * result + ((outubro == null) ? 0 : outubro.hashCode());
		result = prime * result
				+ ((setembro == null) ? 0 : setembro.hashCode());
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
		FaturamentoConsolidadoVO other = (FaturamentoConsolidadoVO) obj;
		if (abril == null) {
			if (other.abril != null)
				return false;
		} else if (!abril.equals(other.abril))
			return false;
		if (agosto == null) {
			if (other.agosto != null)
				return false;
		} else if (!agosto.equals(other.agosto))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (dezembro == null) {
			if (other.dezembro != null)
				return false;
		} else if (!dezembro.equals(other.dezembro))
			return false;
		if (fevereiro == null) {
			if (other.fevereiro != null)
				return false;
		} else if (!fevereiro.equals(other.fevereiro))
			return false;
		if (janeiro == null) {
			if (other.janeiro != null)
				return false;
		} else if (!janeiro.equals(other.janeiro))
			return false;
		if (julho == null) {
			if (other.julho != null)
				return false;
		} else if (!julho.equals(other.julho))
			return false;
		if (junho == null) {
			if (other.junho != null)
				return false;
		} else if (!junho.equals(other.junho))
			return false;
		if (maio == null) {
			if (other.maio != null)
				return false;
		} else if (!maio.equals(other.maio))
			return false;
		if (marco == null) {
			if (other.marco != null)
				return false;
		} else if (!marco.equals(other.marco))
			return false;
		if (novembro == null) {
			if (other.novembro != null)
				return false;
		} else if (!novembro.equals(other.novembro))
			return false;
		if (outubro == null) {
			if (other.outubro != null)
				return false;
		} else if (!outubro.equals(other.outubro))
			return false;
		if (setembro == null) {
			if (other.setembro != null)
				return false;
		} else if (!setembro.equals(other.setembro))
			return false;
		return true;
	}
	
}
