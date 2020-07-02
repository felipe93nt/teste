package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

public class FibrasVO implements Comparable<FibrasVO> {

	private String tipoFibra = "";
	private AreaPlantadaFibrasVO anoSafra1 = new AreaPlantadaFibrasVO();
	private AreaPlantadaFibrasVO anoSafra2 = new AreaPlantadaFibrasVO();
	private AreaPlantadaFibrasVO anoSafra3 = new AreaPlantadaFibrasVO();
	private AreaPlantadaFibrasVO anoSafraProjetado = new AreaPlantadaFibrasVO();

	public String getTipoFibra() {
		return tipoFibra;
	}

	public void setTipoFibra(String tipoFibra) {
		this.tipoFibra = tipoFibra;
	}

	public AreaPlantadaFibrasVO getAnoSafra1() {
		return anoSafra1;
	}

	public void setAnoSafra1(AreaPlantadaFibrasVO anoSafra1) {
		this.anoSafra1 = anoSafra1;
	}

	public AreaPlantadaFibrasVO getAnoSafra2() {
		return anoSafra2;
	}

	public void setAnoSafra2(AreaPlantadaFibrasVO anoSafra2) {
		this.anoSafra2 = anoSafra2;
	}

	public AreaPlantadaFibrasVO getAnoSafra3() {
		return anoSafra3;
	}

	public void setAnoSafra3(AreaPlantadaFibrasVO anoSafra3) {
		this.anoSafra3 = anoSafra3;
	}

	public AreaPlantadaFibrasVO getAnoSafraProjetado() {
		return anoSafraProjetado;
	}

	public void setAnoSafraProjetado(AreaPlantadaFibrasVO anoSafraProjetado) {
		this.anoSafraProjetado = anoSafraProjetado;
	}

	@Override
	public int compareTo(FibrasVO o) {
		return this.hashCode() == o.hashCode() ? 0 : this.hashCode() - o.hashCode();
	}

}
