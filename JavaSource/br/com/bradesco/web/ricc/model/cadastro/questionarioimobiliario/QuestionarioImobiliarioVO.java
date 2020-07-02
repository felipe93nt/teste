package br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.converter.BaseEntity;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class QuestionarioImobiliarioVO implements BaseEntity, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1742417813805275329L;

	private String codGrupoEconomico;
	private String descGrupoEconomico = "";

	private String versaoOrigem = "";
	private String codRelatorio = "";
	private String codSegmentoRelatorio = "";

	private AbaQuestionarioImobiliarioVO questionario = new AbaQuestionarioImobiliarioVO();

	private ObrasAndamentoVO obrasAndamento = new ObrasAndamentoVO();
	private List<ObrasAndamentoVO> obrasAndamentoSelecionado = new ArrayList<ObrasAndamentoVO>();
	private List<ObrasAndamentoVO> listaObrasAndamento = new ArrayList<ObrasAndamentoVO>();
	private List<ObrasAndamentoVO> copiaListaObrasAndamento = new ArrayList<ObrasAndamentoVO>();
	
	private String totalCustoObra;
	private String totalCustoIncorrer;
	private String totalVenda;
	private String totalVendaPermuta;
	private String totalQuantidadeEstoque;
	private String totalUnidadeSemPermuta;
	private String totalUnidadePermuta;
	private String totalValorRecibo;
	private String totalValorReciboPreChave;
	private String totalValorReciboPosChave;
	private String totalValorContrato;
	private String totalSaldoLiberar;
	private String totalSaldoDevedorAndamento;

	private ObrasConcluidasVO obrasConcluidas = new ObrasConcluidasVO();
	private List<ObrasConcluidasVO> obrasConcluidasSelecionado = new ArrayList<ObrasConcluidasVO>();
	private List<ObrasConcluidasVO> listaObrasConcluidas = new ArrayList<ObrasConcluidasVO>();
	private List<ObrasConcluidasVO> copiaListaObrasConcluidas = new ArrayList<ObrasConcluidasVO>();
	
	private String totalRecebidos;
	private String total12Meses;
	private String total12A36;
	private String totalApos36;
	private String totalUnidades;
	private String totalValorEstoque;
	private String totalSaldoDevedor;
	
	//Get Totais formatados
	public String getTotalCustoObraFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalCustoObra);
	}

	public String getTotalCustoIncorrerFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalCustoIncorrer);
	}

	public String getTotalVendaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalVenda);
	}

	public String getTotalVendaPermutaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalVendaPermuta);
	}

	public String getTotalQuantidadeEstoqueFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalQuantidadeEstoque);
	}

	public String getTotalUnidadeSemPermutaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalUnidadeSemPermuta);
	}

	public String getTotalUnidadePermutaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalUnidadePermuta);
	}

	public String getTotalValorReciboFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalValorRecibo);
	}

	public String getTotalValorReciboPreChaveFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalValorReciboPreChave);
	}

	public String getTotalValorReciboPosChaveFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalValorReciboPosChave);
	}

	public String getTotalValorContratoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalValorContrato);
	}

	public String getTotalSaldoLiberarFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalSaldoLiberar);
	}

	public String getTotalSaldoDevedorAndamentoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalSaldoDevedorAndamento);
	}

	public String getTotalRecebidosFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalRecebidos);
	}

	public String getTotal12MesesFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(total12Meses);
	}

	public String getTotal12A36Formatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(total12A36);
	}

	public String getTotalApos36Formatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalApos36);
	}

	public String getTotalUnidadesFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalUnidades);
	}

	public String getTotalValorEstoqueFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalValorEstoque);
	}

	public String getTotalSaldoDevedorFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalSaldoDevedor);
	}
	//Fim Totais Formatados
	

	public String getCodGrupoEconomico() {
		return codGrupoEconomico;
	}

	public void setCodGrupoEconomico(String codGrupoEconomico) {
		this.codGrupoEconomico = codGrupoEconomico;
	}

	public String getDescGrupoEconomico() {
		return descGrupoEconomico;
	}

	public void setDescGrupoEconomico(String descGrupoEconomico) {
		this.descGrupoEconomico = descGrupoEconomico;
	}

	public String getVersaoOrigem() {
		return versaoOrigem;
	}

	public void setVersaoOrigem(String versaoOrigem) {
		this.versaoOrigem = versaoOrigem;
	}

	public String getCodRelatorio() {
		return codRelatorio;
	}

	public void setCodRelatorio(String codRelatorio) {
		this.codRelatorio = codRelatorio;
	}

	public AbaQuestionarioImobiliarioVO getQuestionario() {
		return questionario;
	}

	public void setQuestionario(AbaQuestionarioImobiliarioVO questionario) {
		this.questionario = questionario;
	}

	public ObrasAndamentoVO getObrasAndamento() {
		return obrasAndamento;
	}

	public void setObrasAndamento(ObrasAndamentoVO obrasAndamento) {
		this.obrasAndamento = obrasAndamento;
	}

	public ObrasConcluidasVO getObrasConcluidas() {
		return obrasConcluidas;
	}

	public void setObrasConcluidas(ObrasConcluidasVO obrasConcluidas) {
		this.obrasConcluidas = obrasConcluidas;
	}

	public String getCodSegmentoRelatorio() {
		return codSegmentoRelatorio;
	}

	public void setCodSegmentoRelatorio(String codSegmentoRelatorio) {
		this.codSegmentoRelatorio = codSegmentoRelatorio;
	}

	public List<ObrasAndamentoVO> getObrasAndamentoSelecionado() {
		return obrasAndamentoSelecionado;
	}

	public void setObrasAndamentoSelecionado(
			List<ObrasAndamentoVO> obrasAndamentoSelecionado) {
		this.obrasAndamentoSelecionado = obrasAndamentoSelecionado;
	}

	public List<ObrasAndamentoVO> getListaObrasAndamento() {
		return listaObrasAndamento;
	}

	public void setListaObrasAndamento(
			List<ObrasAndamentoVO> listaObrasAndamento) {
		this.listaObrasAndamento = listaObrasAndamento;
	}

	public List<ObrasConcluidasVO> getListaObrasConcluidas() {
		return listaObrasConcluidas;
	}

	public List<ObrasConcluidasVO> getObrasConcluidasSelecionado() {
		return obrasConcluidasSelecionado;
	}

	public void setObrasConcluidasSelecionado(
			List<ObrasConcluidasVO> obrasConcluidasSelecionado) {
		this.obrasConcluidasSelecionado = obrasConcluidasSelecionado;
	}

	public void setListaObrasConcluidas(
			List<ObrasConcluidasVO> listaObrasConcluidas) {
		this.listaObrasConcluidas = listaObrasConcluidas;
	}
	
	public List<ObrasAndamentoVO> getCopiaListaObrasAndamento() {
		return copiaListaObrasAndamento;
	}

	public void setCopiaListaObrasAndamento(
			List<ObrasAndamentoVO> copiaListaObrasAndamento) {
		this.copiaListaObrasAndamento = copiaListaObrasAndamento;
	}

	public List<ObrasConcluidasVO> getCopiaListaObrasConcluidas() {
		return copiaListaObrasConcluidas;
	}

	public void setCopiaListaObrasConcluidas(
			List<ObrasConcluidasVO> copiaListaObrasConcluidas) {
		this.copiaListaObrasConcluidas = copiaListaObrasConcluidas;
	}
	
	public String getTotalCustoObra() {
		return totalCustoObra;
	}

	public void setTotalCustoObra(String totalCustoObra) {
		this.totalCustoObra = totalCustoObra;
	}

	public String getTotalCustoIncorrer() {
		return totalCustoIncorrer;
	}

	public void setTotalCustoIncorrer(String totalCustoIncorrer) {
		this.totalCustoIncorrer = totalCustoIncorrer;
	}

	public String getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(String totalVenda) {
		this.totalVenda = totalVenda;
	}

	public String getTotalVendaPermuta() {
		return totalVendaPermuta;
	}

	public void setTotalVendaPermuta(String totalVendaPermuta) {
		this.totalVendaPermuta = totalVendaPermuta;
	}

	public String getTotalQuantidadeEstoque() {
		return totalQuantidadeEstoque;
	}

	public void setTotalQuantidadeEstoque(String totalQuantidadeEstoque) {
		this.totalQuantidadeEstoque = totalQuantidadeEstoque;
	}

	public String getTotalUnidadeSemPermuta() {
		return totalUnidadeSemPermuta;
	}

	public void setTotalUnidadeSemPermuta(String totalUnidadeSemPermuta) {
		this.totalUnidadeSemPermuta = totalUnidadeSemPermuta;
	}

	public String getTotalUnidadePermuta() {
		return totalUnidadePermuta;
	}

	public void setTotalUnidadePermuta(String totalUnidadePermuta) {
		this.totalUnidadePermuta = totalUnidadePermuta;
	}

	public String getTotalValorRecibo() {
		return totalValorRecibo;
	}

	public void setTotalValorRecibo(String totalValorRecibo) {
		this.totalValorRecibo = totalValorRecibo;
	}

	public String getTotalValorReciboPreChave() {
		return totalValorReciboPreChave;
	}

	public void setTotalValorReciboPreChave(String totalValorReciboPreChave) {
		this.totalValorReciboPreChave = totalValorReciboPreChave;
	}

	public String getTotalValorReciboPosChave() {
		return totalValorReciboPosChave;
	}

	public void setTotalValorReciboPosChave(String totalValorReciboPosChave) {
		this.totalValorReciboPosChave = totalValorReciboPosChave;
	}

	public String getTotalValorContrato() {
		return totalValorContrato;
	}

	public void setTotalValorContrato(String totalValorContrato) {
		this.totalValorContrato = totalValorContrato;
	}
	
	public String getTotalSaldoLiberar() {
		return totalSaldoLiberar;
	}

	public void setTotalSaldoLiberar(String totalSaldoLiberar) {
		this.totalSaldoLiberar = totalSaldoLiberar;
	}

	public String getTotalSaldoDevedorAndamento() {
		return totalSaldoDevedorAndamento;
	}

	public void setTotalSaldoDevedorAndamento(String totalSaldoDevedorAndamento) {
		this.totalSaldoDevedorAndamento = totalSaldoDevedorAndamento;
	}

	public String getTotalRecebidos() {
		return totalRecebidos;
	}

	public void setTotalRecebidos(String totalRecebidos) {
		this.totalRecebidos = totalRecebidos;
	}

	public String getTotal12Meses() {
		return total12Meses;
	}

	public void setTotal12Meses(String total12Meses) {
		this.total12Meses = total12Meses;
	}

	public String getTotal12A36() {
		return total12A36;
	}

	public void setTotal12A36(String total12a36) {
		total12A36 = total12a36;
	}

	public String getTotalApos36() {
		return totalApos36;
	}

	public void setTotalApos36(String totalApos36) {
		this.totalApos36 = totalApos36;
	}

	public String getTotalUnidades() {
		return totalUnidades;
	}

	public void setTotalUnidades(String totalUnidades) {
		this.totalUnidades = totalUnidades;
	}

	public String getTotalValorEstoque() {
		return totalValorEstoque;
	}

	public void setTotalValorEstoque(String totalValorEstoque) {
		this.totalValorEstoque = totalValorEstoque;
	}

	public String getTotalSaldoDevedor() {
		return totalSaldoDevedor;
	}

	public void setTotalSaldoDevedor(String totalSaldoDevedor) {
		this.totalSaldoDevedor = totalSaldoDevedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Long getId() {
		// COLOCAR AQUI A VARIÁVEL QUE IDENTIFICA A TELA
		return Long.valueOf(this.codGrupoEconomico);
	}

}
