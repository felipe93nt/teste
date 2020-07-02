package br.com.bradesco.web.ricc.model.parametrizacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RelatorioParametrizacaoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6416483666132610294L;
	private String riscoTotal = "";
	private Integer validadeMeses = null;
	private String usuario = "";
	private List<ListaObrigatoriedadeParamVO> listaObrigatoriedade = new ArrayList<ListaObrigatoriedadeParamVO>();
	private String dataAlteracao = "";
	private Integer NversaoOrige = 1;
	private Integer NparmzRelat = 1;

	/**
	 * @return the riscoTotal
	 */
	public String getRiscoTotal() {
		return riscoTotal;
	}

	/**
	 * @param riscoTotal
	 *            the riscoTotal to set
	 */
	public void setRiscoTotal(String riscoTotal) {
		this.riscoTotal = riscoTotal;
	}

	/**
	 * @return the validadeMeses
	 */
	public Integer getValidadeMeses() {
		return validadeMeses;
	}

	/**
	 * @param validadeMeses
	 *            the validadeMeses to set
	 */
	public void setValidadeMeses(Integer validadeMeses) {
		this.validadeMeses = validadeMeses;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the listaObrigatoriedade
	 */
	public List<ListaObrigatoriedadeParamVO> getListaObrigatoriedade() {
		return listaObrigatoriedade;
	}

	/**
	 * @param listaObrigatoriedade
	 *            the listaObrigatoriedade to set
	 */
	public void setListaObrigatoriedade(
			List<ListaObrigatoriedadeParamVO> listaObrigatoriedade) {
		this.listaObrigatoriedade = listaObrigatoriedade;
	}

	/**
	 * @return the dataAlteracao
	 */
	public String getDataAlteracao() {
		return dataAlteracao;
	}

	/**
	 * @param dataAlteracao
	 *            the dataAlteracao to set
	 */
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	/**
	 * @return the nversaoOrige
	 */
	public Integer getNversaoOrige() {
		return NversaoOrige;
	}

	/**
	 * @param nversaoOrige
	 *            the nversaoOrige to set
	 */
	public void setNversaoOrige(Integer nversaoOrige) {
		NversaoOrige = nversaoOrige;
	}

	/**
	 * @return the nparmzRelat
	 */
	public Integer getNparmzRelat() {
		return NparmzRelat;
	}

	/**
	 * @param nparmzRelat
	 *            the nparmzRelat to set
	 */
	public void setNparmzRelat(Integer nparmzRelat) {
		NparmzRelat = nparmzRelat;
	}

}
