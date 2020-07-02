package br.com.bradesco.web.ricc.model.duplavalidacao;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.parametrizacao.ListaObrigatoriedadeParamVO;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class DuplaValidacaoVO {
	
	int numeroParametrizacao;
	private List<ListaObrigatoriedadeParamVO> listaObrigatoriedadeSelecionada = new ArrayList<ListaObrigatoriedadeParamVO>();
	String riscoTotal = "";
	String validadeMeses = "";
	String dataSolicitacao = "";
	String usuarioSolicitacao = "";
	String dataValidacao = "";
	String validacao = "";
	
	public String getRiscoTotalFormatado() {
		return SiteUtil.getInstance().formatValoresToString(riscoTotal);
	}
	public int getNumeroParametrizacao() {
		return numeroParametrizacao;
	}
	public void setNumeroParametrizacao(int numeroParametrizacao) {
		this.numeroParametrizacao = numeroParametrizacao;
	}
	public List<ListaObrigatoriedadeParamVO> getListaObrigatoriedadeSelecionada() {
		return listaObrigatoriedadeSelecionada;
	}
	public void setListaObrigatoriedadeSelecionada(
			List<ListaObrigatoriedadeParamVO> listaObrigatoriedadeSelecionada) {
		this.listaObrigatoriedadeSelecionada = listaObrigatoriedadeSelecionada;
	}
	public String getRiscoTotal() {
		return riscoTotal;
	}
	public void setRiscoTotal(String riscoTotal) {
		this.riscoTotal = riscoTotal;
	}
	public String getValidadeMeses() {
		return validadeMeses;
	}
	public void setValidadeMeses(String validadeMeses) {
		this.validadeMeses = validadeMeses;
	}
	public String getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getUsuarioSolicitacao() {
		return usuarioSolicitacao;
	}
	public void setUsuarioSolicitacao(String usuarioSolicitacao) {
		this.usuarioSolicitacao = usuarioSolicitacao;
	}
	public String getDataValidacao() {
		return dataValidacao;
	}
	public void setDataValidacao(String dataValidacao) {
		this.dataValidacao = dataValidacao;
	}
	public String getValidacao() {
		return validacao;
	}
	public void setValidacao(String validacao) {
		this.validacao = validacao;
	}
	
}
