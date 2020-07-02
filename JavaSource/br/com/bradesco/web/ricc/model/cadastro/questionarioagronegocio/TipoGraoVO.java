package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

public class TipoGraoVO implements Comparable<TipoGraoVO> {

	private String tipoGrao = "";
	private String pesoSacaSementes = "";
	private String pesoSacaMediaSemente = "";
	private AreaPlantadaGraosVO anoSafra1 = new AreaPlantadaGraosVO();
	private AreaPlantadaGraosVO anoSafra2 = new AreaPlantadaGraosVO();
	private AreaPlantadaGraosVO anoSafra3 = new AreaPlantadaGraosVO();
	private AreaPlantadaGraosVO anoSafraProjetado = new AreaPlantadaGraosVO();

	public String getTipoGrao() {
		return tipoGrao;
	}

	public void setTipoGrao(String tipoGrao) {
		this.tipoGrao = tipoGrao;
	}
	
	public String getPesoSacaSementes() {
		return pesoSacaSementes;
	}

	public void setPesoSacaSementes(String pesoSacaSementes) {
		this.pesoSacaSementes = pesoSacaSementes;
	}

	public String getPesoSacaMediaSemente() {
		return pesoSacaMediaSemente;
	}

	public void setPesoSacaMediaSemente(String pesoSacaMediaSemente) {
		this.pesoSacaMediaSemente = pesoSacaMediaSemente;
	}

	public AreaPlantadaGraosVO getAnoSafra1() {
		return anoSafra1;
	}

	public void setAnoSafra1(AreaPlantadaGraosVO anoSafra1) {
		this.anoSafra1 = anoSafra1;
	}

	public AreaPlantadaGraosVO getAnoSafra2() {
		return anoSafra2;
	}

	public void setAnoSafra2(AreaPlantadaGraosVO anoSafra2) {
		this.anoSafra2 = anoSafra2;
	}

	public AreaPlantadaGraosVO getAnoSafra3() {
		return anoSafra3;
	}

	public void setAnoSafra3(AreaPlantadaGraosVO anoSafra3) {
		this.anoSafra3 = anoSafra3;
	}

	public AreaPlantadaGraosVO getAnoSafraProjetado() {
		return anoSafraProjetado;
	}

	public void setAnoSafraProjetado(AreaPlantadaGraosVO anoSafraProjetado) {
		this.anoSafraProjetado = anoSafraProjetado;
	}

	@Override
	public int compareTo(TipoGraoVO o) {
		return this.hashCode() == o.hashCode() ? 0 : this.hashCode() - o.hashCode();
	}

}
