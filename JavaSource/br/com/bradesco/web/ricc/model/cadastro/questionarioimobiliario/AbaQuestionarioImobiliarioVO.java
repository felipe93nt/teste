package br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class AbaQuestionarioImobiliarioVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7440100873336466236L;

	private Boolean empreendimentoResidencial = Boolean.FALSE;
	private Boolean empreendimentoComercial = Boolean.FALSE;
	private Boolean baixaRenda = Boolean.FALSE;
	private Boolean classeMedia = Boolean.FALSE;
	private Boolean altoPadrao = Boolean.FALSE;
	private String preChaves = "";
	private String posChaves = "";
	private Boolean propria = Boolean.FALSE;
	private Boolean terceirizada = Boolean.FALSE;
	private String nomeTerceirizada = "";

	private AreaAtuacaoVO areaAtuacao = new AreaAtuacaoVO();
	private List<AreaAtuacaoVO> areaAtuacaoSelecionado = new ArrayList<AreaAtuacaoVO>();
	private List<AreaAtuacaoVO> listaAreaAtuacao = new ArrayList<AreaAtuacaoVO>();
	private List<AreaAtuacaoVO> copiaListaAreaAtuacao = new ArrayList<AreaAtuacaoVO>();

	private HistoricoLancamentosVO historicoLancamentos = new HistoricoLancamentosVO();
	private List<HistoricoLancamentosVO> historicoLancamentosSelecionado = new ArrayList<HistoricoLancamentosVO>();
	private List<HistoricoLancamentosVO> listaHistoricoLancamentos = new ArrayList<HistoricoLancamentosVO>();
	private List<HistoricoLancamentosVO> copiaListaHistoricoLancamentos = new ArrayList<HistoricoLancamentosVO>();
	private String vgvTotal;
	private String qtdTotal;

	private PrevisaoLancamentoVO previsaoLancamento = new PrevisaoLancamentoVO();
	private List<PrevisaoLancamentoVO> previsaoLancamentoSelecionado = new ArrayList<PrevisaoLancamentoVO>();
	private List<PrevisaoLancamentoVO> listaPrevisaoLancamento = new ArrayList<PrevisaoLancamentoVO>();

	private LandBankVO landBank = new LandBankVO();
	private List<LandBankVO> landBankSelecionado = new ArrayList<LandBankVO>();
	private List<LandBankVO> listaLandBank = new ArrayList<LandBankVO>();
	private List<LandBankVO> copiaListaLandBank = new ArrayList<LandBankVO>();
	private String totalTerreno;
	private String totalProjetada;

	public String getVgvTotalFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(vgvTotal);
	}
	
	public String getQtdTotalFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(qtdTotal);
	}
	
	public String getTotalTerrenoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalTerreno);
	}

	public String getTotalProjetadaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalProjetada);
	}
	
	public Boolean getEmpreendimentoResidencial() {
		return empreendimentoResidencial;
	}

	public void setEmpreendimentoResidencial(Boolean empreendimentoResidencial) {
		this.empreendimentoResidencial = empreendimentoResidencial;
	}

	public Boolean getEmpreendimentoComercial() {
		return empreendimentoComercial;
	}

	public void setEmpreendimentoComercial(Boolean empreendimentoComercial) {
		this.empreendimentoComercial = empreendimentoComercial;
	}

	public Boolean getBaixaRenda() {
		return baixaRenda;
	}

	public void setBaixaRenda(Boolean baixaRenda) {
		this.baixaRenda = baixaRenda;
	}

	public Boolean getClasseMedia() {
		return classeMedia;
	}

	public void setClasseMedia(Boolean classeMedia) {
		this.classeMedia = classeMedia;
	}

	public Boolean getAltoPadrao() {
		return altoPadrao;
	}

	public void setAltoPadrao(Boolean altoPadrao) {
		this.altoPadrao = altoPadrao;
	}

	public String getPreChaves() {
		return preChaves;
	}

	public void setPreChaves(String preChaves) {
		this.preChaves = preChaves;
	}

	public String getPosChaves() {
		return posChaves;
	}

	public void setPosChaves(String posChaves) {
		this.posChaves = posChaves;
	}

	public AreaAtuacaoVO getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacaoVO areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public Boolean getPropria() {
		return propria;
	}

	public void setPropria(Boolean propria) {
		this.propria = propria;
	}

	public Boolean getTerceirizada() {
		return terceirizada;
	}

	public void setTerceirizada(Boolean terceirizada) {
		this.terceirizada = terceirizada;
	}

	public String getNomeTerceirizada() {
		return nomeTerceirizada;
	}

	public void setNomeTerceirizada(String nomeTerceirizada) {
		this.nomeTerceirizada = nomeTerceirizada;
	}

	public List<AreaAtuacaoVO> getListaAreaAtuacao() {
		return listaAreaAtuacao;
	}

	public void setListaAreaAtuacao(List<AreaAtuacaoVO> listaAreaAtuacao) {
		this.listaAreaAtuacao = listaAreaAtuacao;
	}

	public HistoricoLancamentosVO getHistoricoLancamentos() {
		return historicoLancamentos;
	}

	public void setHistoricoLancamentos(
			HistoricoLancamentosVO historicoLancamentos) {
		this.historicoLancamentos = historicoLancamentos;
	}

	public List<HistoricoLancamentosVO> getListaHistoricoLancamentos() {
		return listaHistoricoLancamentos;
	}

	public void setListaHistoricoLancamentos(
			List<HistoricoLancamentosVO> listaHistoricoLancamentos) {
		this.listaHistoricoLancamentos = listaHistoricoLancamentos;
	}

	public PrevisaoLancamentoVO getPrevisaoLancamento() {
		return previsaoLancamento;
	}

	public void setPrevisaoLancamento(PrevisaoLancamentoVO previsaoLancamento) {
		this.previsaoLancamento = previsaoLancamento;
	}

	public List<PrevisaoLancamentoVO> getListaPrevisaoLancamento() {
		return listaPrevisaoLancamento;
	}

	public void setListaPrevisaoLancamento(
			List<PrevisaoLancamentoVO> listaPrevisaoLancamento) {
		this.listaPrevisaoLancamento = listaPrevisaoLancamento;
	}

	public LandBankVO getLandBank() {
		return landBank;
	}

	public void setLandBank(LandBankVO landBank) {
		this.landBank = landBank;
	}

	public List<LandBankVO> getLandBankSelecionado() {
		return landBankSelecionado;
	}

	public void setLandBankSelecionado(List<LandBankVO> landBankSelecionado) {
		this.landBankSelecionado = landBankSelecionado;
	}

	public List<LandBankVO> getListaLandBank() {
		return listaLandBank;
	}

	public void setListaLandBank(List<LandBankVO> listaLandBank) {
		this.listaLandBank = listaLandBank;
	}
	
	public String getTotalTerreno() {
		return totalTerreno;
	}

	public void setTotalTerreno(String totalTerreno) {
		this.totalTerreno = totalTerreno;
	}

	public String getTotalProjetada() {
		return totalProjetada;
	}

	public void setTotalProjetada(String totalProjetada) {
		this.totalProjetada = totalProjetada;
	}

	public List<AreaAtuacaoVO> getAreaAtuacaoSelecionado() {
		return areaAtuacaoSelecionado;
	}

	public void setAreaAtuacaoSelecionado(
			List<AreaAtuacaoVO> areaAtuacaoSelecionado) {
		this.areaAtuacaoSelecionado = areaAtuacaoSelecionado;
	}

	public List<HistoricoLancamentosVO> getHistoricoLancamentosSelecionado() {
		return historicoLancamentosSelecionado;
	}

	public void setHistoricoLancamentosSelecionado(
			List<HistoricoLancamentosVO> historicoLancamentosSelecionado) {
		this.historicoLancamentosSelecionado = historicoLancamentosSelecionado;
	}

	public List<PrevisaoLancamentoVO> getPrevisaoLancamentoSelecionado() {
		return previsaoLancamentoSelecionado;
	}

	public void setPrevisaoLancamentoSelecionado(
			List<PrevisaoLancamentoVO> previsaoLancamentoSelecionado) {
		this.previsaoLancamentoSelecionado = previsaoLancamentoSelecionado;
	}
	
	public List<AreaAtuacaoVO> getCopiaListaAreaAtuacao() {
		return copiaListaAreaAtuacao;
	}

	public void setCopiaListaAreaAtuacao(List<AreaAtuacaoVO> copiaListaAreaAtuacao) {
		this.copiaListaAreaAtuacao = copiaListaAreaAtuacao;
	}

	public List<HistoricoLancamentosVO> getCopiaListaHistoricoLancamentos() {
		return copiaListaHistoricoLancamentos;
	}

	public void setCopiaListaHistoricoLancamentos(
			List<HistoricoLancamentosVO> copiaListaHistoricoLancamentos) {
		this.copiaListaHistoricoLancamentos = copiaListaHistoricoLancamentos;
	}

	public List<LandBankVO> getCopiaListaLandBank() {
		return copiaListaLandBank;
	}

	public void setCopiaListaLandBank(List<LandBankVO> copiaListaLandBank) {
		this.copiaListaLandBank = copiaListaLandBank;
	}
	
	public String getVgvTotal() {
		return vgvTotal;
	}

	public void setVgvTotal(String vgvTotal) {
		this.vgvTotal = vgvTotal;
	}

	public String getQtdTotal() {
		return qtdTotal;
	}

	public void setQtdTotal(String qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
