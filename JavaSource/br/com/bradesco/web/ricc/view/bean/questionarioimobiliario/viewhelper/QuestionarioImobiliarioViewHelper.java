package br.com.bradesco.web.ricc.view.bean.questionarioimobiliario.viewhelper;

import javax.faces.event.AjaxBehaviorEvent;

import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AreaAtuacaoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.HistoricoLancamentosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.LandBankVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasAndamentoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasConcluidasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class QuestionarioImobiliarioViewHelper extends AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -906644343478869177L;

	@Override
	public void inicializar() {
		questionarioImobiliarioVO = new QuestionarioImobiliarioVO();
		renderAbaQuestionario = Boolean.TRUE;
		renderAbaObrasAndamento = Boolean.FALSE;
		renderAbaObrasConcluidas = Boolean.FALSE;
		desabilitaIncluirAreaAtuacao = Boolean.TRUE;
		desabilitaIncluirHistorico = Boolean.TRUE;
		desabilitaIncluirLandBank = Boolean.TRUE;
		desabilitaIncluirObraAndamento = Boolean.TRUE;
		desabilitaIncluirObraConcluida = Boolean.TRUE;
	}
	
	/**
	 * Model que contém um model de cada aba
	 * 		1 - AbaQuestionarioImobiliarioVO
	 * 		2 - ObrasAndamentoVO
	 * 		3 - ObrasConcluidasVO
	 */
	private QuestionarioImobiliarioVO questionarioImobiliarioVO;

	//Atributos que renderizam as "abas"
	private Boolean renderAbaQuestionario;
	private Boolean renderAbaObrasAndamento;
	private Boolean renderAbaObrasConcluidas;
	private Boolean desabilitaIncluirAreaAtuacao;
	private Boolean desabilitaIncluirHistorico;
	private Boolean desabilitaIncluirLandBank;
	private Boolean desabilitaIncluirObraAndamento;
	private Boolean desabilitaIncluirObraConcluida;
	
	
	public void desabilitaIncluirObraConcluida (AjaxBehaviorEvent e) {
		ObrasConcluidasVO model = questionarioImobiliarioVO.getObrasConcluidas();
		if (siteUtil.isEmptyOrNull(model.getIncorporadora())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getNomeEmpreendimento())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getUf())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getCidade())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getBairro())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getValoresRecebidos())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getValoresAte12Meses())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getValoresDe12Ate36Meses())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getValoresApos36Meses())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getQtdeUnidades())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getValorEstoque())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getPorcentagemVendas())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getAgenteFinanceiro())) {
			setDesabilitaIncluirObraConcluida(true);
		} else if (siteUtil.isEmptyOrNull(model.getSaldoDevedor())) {
			setDesabilitaIncluirObraConcluida(true);
		} else {
			setDesabilitaIncluirObraConcluida(false);
		}
	}
	
	public void desabilitaIncluirObraAndamento (AjaxBehaviorEvent e) {
		ObrasAndamentoVO model = questionarioImobiliarioVO.getObrasAndamento();
		if (siteUtil.isEmptyOrNull(model.getIncorporadora())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getNomeEmpreendimento())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getUf())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getCidade())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getBairro())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getPorcPartEmpreendimento())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getPorcentagemObra())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getTotalObra())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getaIncorrer())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getVgvTotal())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getVgvSemPermutas())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getTotalUnidadesEstoque())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getTotalUnidadesSemPermutas())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getTotalUnidadesComPermutas())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getPorcentagemVendas())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getPorcentagemDistratos())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getValoresRecebidos())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getValoresRecebidos())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getValoresAteChaves())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getValoresPosChaves())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getAgenteFinanceiro())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getValorContrato())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getSaldoALiberar())) {
			setDesabilitaIncluirObraAndamento(true);
		} else if (siteUtil.isEmptyOrNull(model.getSaldoDevedor())) {
			setDesabilitaIncluirObraAndamento(true);
		} else {
			setDesabilitaIncluirObraAndamento(false);
		}
	}
	
	public void desabilitaIncluirAreaAtuacao(AjaxBehaviorEvent e) {
		AreaAtuacaoVO model = questionarioImobiliarioVO.getQuestionario().getAreaAtuacao();
		if (siteUtil.isEmptyOrNull(model.getEstado())) {
			setDesabilitaIncluirAreaAtuacao(true);
		} else if (siteUtil.isEmptyOrNull(model.getRegiao())) {
			setDesabilitaIncluirAreaAtuacao(true);
		} else {
			setDesabilitaIncluirAreaAtuacao(false);
		}
	}
	
	public void desabilitaIncluirHistorico(AjaxBehaviorEvent e) {
		HistoricoLancamentosVO historico = questionarioImobiliarioVO.getQuestionario().getHistoricoLancamentos();
		if(siteUtil.isEmptyOrNull(historico.getAno())) {
			setDesabilitaIncluirHistorico(true);
		} else if (siteUtil.isEmptyOrNull(historico.getVgvLancado())) {
			setDesabilitaIncluirHistorico(true);
		} else if (siteUtil.isEmptyOrNull(historico.getQtdeEmpreendimentos())) {
			setDesabilitaIncluirHistorico(true);
		} else {
			setDesabilitaIncluirHistorico(false);
		}
	}
	
	public void desabilitaIncluirLandBank (AjaxBehaviorEvent e) {
		LandBankVO landBank = questionarioImobiliarioVO.getQuestionario().getLandBank();
		if(siteUtil.isEmptyOrNull(landBank.getEmpreendimento())) {
			setDesabilitaIncluirLandBank(true);
		} else if (siteUtil.isEmptyOrNull(landBank.getLocalizacao())) {
			setDesabilitaIncluirLandBank(true);
		} else if (siteUtil.isEmptyOrNull(landBank.getValorTerreno())) {
			setDesabilitaIncluirLandBank(true);
		} else if (siteUtil.isEmptyOrNull(landBank.getVgvEstimado())) {
			setDesabilitaIncluirLandBank(true);
		} else if (siteUtil.isEmptyOrNull(landBank.getPossuiOnus())) {
			setDesabilitaIncluirLandBank(true);
		} else {
			setDesabilitaIncluirLandBank(false);
		}
	}

	public QuestionarioImobiliarioVO getQuestionarioImobiliarioVO() {
		return questionarioImobiliarioVO;
	}

	public void setQuestionarioImobiliarioVO(
			QuestionarioImobiliarioVO questionarioImobiliarioVO) {
		this.questionarioImobiliarioVO = questionarioImobiliarioVO;
	}

	public Boolean getRenderAbaQuestionario() {
		return renderAbaQuestionario;
	}

	public void setRenderAbaQuestionario(Boolean renderAbaQuestionario) {
		this.renderAbaQuestionario = renderAbaQuestionario;
	}

	public Boolean getRenderAbaObrasAndamento() {
		return renderAbaObrasAndamento;
	}

	public void setRenderAbaObrasAndamento(Boolean renderAbaObrasAndamento) {
		this.renderAbaObrasAndamento = renderAbaObrasAndamento;
	}

	public Boolean getRenderAbaObrasConcluidas() {
		return renderAbaObrasConcluidas;
	}

	public void setRenderAbaObrasConcluidas(Boolean renderAbaObrasConcluidas) {
		this.renderAbaObrasConcluidas = renderAbaObrasConcluidas;
	}

	public Boolean getDesabilitaIncluirAreaAtuacao() {
		return desabilitaIncluirAreaAtuacao;
	}

	public void setDesabilitaIncluirAreaAtuacao(Boolean desabilitaIncluirAreaAtuacao) {
		this.desabilitaIncluirAreaAtuacao = desabilitaIncluirAreaAtuacao;
	}

	public Boolean getDesabilitaIncluirHistorico() {
		return desabilitaIncluirHistorico;
	}

	public void setDesabilitaIncluirHistorico(Boolean desabilitaIncluirHistorico) {
		this.desabilitaIncluirHistorico = desabilitaIncluirHistorico;
	}

	public Boolean getDesabilitaIncluirLandBank() {
		return desabilitaIncluirLandBank;
	}

	public void setDesabilitaIncluirLandBank(Boolean desabilitaIncluirLandBank) {
		this.desabilitaIncluirLandBank = desabilitaIncluirLandBank;
	}

	public Boolean getDesabilitaIncluirObraAndamento() {
		return desabilitaIncluirObraAndamento;
	}

	public void setDesabilitaIncluirObraAndamento(
			Boolean desabilitaIncluirObraAndamento) {
		this.desabilitaIncluirObraAndamento = desabilitaIncluirObraAndamento;
	}

	public Boolean getDesabilitaIncluirObraConcluida() {
		return desabilitaIncluirObraConcluida;
	}

	public void setDesabilitaIncluirObraConcluida(
			Boolean desabilitaIncluirObraConcluida) {
		this.desabilitaIncluirObraConcluida = desabilitaIncluirObraConcluida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
