package br.com.bradesco.web.ricc.model.parametrizacaoalcada;

public class AlcadaVO implements Comparable<AlcadaVO>{
	
	private String identidade = "";
	private String valorMaximoAlcada = "";
	private String nivelMinimoUm = "";
	private String nivelMinimoDois = "";
	private String ultimaAlteracao = "";
	
	
	
	/**
	 * @return the identidade
	 */
	public String getIdentidade() {
		return identidade;
	}



	/**
	 * @param identidade the identidade to set
	 */
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}



	/**
	 * @return the valorMaximoAlcada
	 */
	public String getValorMaximoAlcada() {
		return valorMaximoAlcada;
	}



	/**
	 * @param valorMaximoAlcada the valorMaximoAlcada to set
	 */
	public void setValorMaximoAlcada(String valorMaximoAlcada) {
		this.valorMaximoAlcada = valorMaximoAlcada;
	}



	/**
	 * @return the nivelMinimoUm
	 */
	public String getNivelMinimoUm() {
		return nivelMinimoUm;
	}



	/**
	 * @param nivelMinimoUm the nivelMinimoUm to set
	 */
	public void setNivelMinimoUm(String nivelMinimoUm) {
		this.nivelMinimoUm = nivelMinimoUm;
	}



	/**
	 * @return the nivelMinimoDois
	 */
	public String getNivelMinimoDois() {
		return nivelMinimoDois;
	}



	/**
	 * @param nivelMinimoDois the nivelMinimoDois to set
	 */
	public void setNivelMinimoDois(String nivelMinimoDois) {
		this.nivelMinimoDois = nivelMinimoDois;
	}



	/**
	 * @return the ultimaAlteracao
	 */
	public String getUltimaAlteracao() {
		return ultimaAlteracao;
	}



	/**
	 * @param ultimaAlteracao the ultimaAlteracao to set
	 */
	public void setUltimaAlteracao(String ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}



	@Override
	public int compareTo(AlcadaVO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
