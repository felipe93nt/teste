package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe1.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CapitalInvestidoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CustosOperacionaisVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.DadosTransportesDatabaseVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.PrincipaisCustosOperacionaisVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TipoContratosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesCargasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesPassageirosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.ValoresLocadorasVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.service.business.questionariotransportes.IQuestionarioTransportesService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe1.viewhelper.Equipe1ConsultaQuestionarioTransportesViewHelper;

/**
 * @name Equipe1ConsultaQuestionarioTransportesBean
 * @author Equipe 1 - André Nunes, Isaac Maciel, João Carlos e João Gil
 * @see Equipe1ConsultaQuestionarioTransportesViewHelper.java
 * @version 1.0
 * @since 11/05/2020
 */
@SessionScoped
@Named(value = "equipe1ConsultaQuestionarioTransportesBean")
public class Equipe1ConsultaQuestionarioTransportesBean extends
		AbstractBean<Equipe1ConsultaQuestionarioTransportesViewHelper> {

	private static final long serialVersionUID = 7812957486456093017L;

	@Inject
	@Named("questionarioTransportesService")
	private IQuestionarioTransportesService questionarioTransportesService;

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;

	private String paginaAnterior = "";

	@Override
	public String iniciarPagina() {
		setViewHelper(new Equipe1ConsultaQuestionarioTransportesViewHelper());
		viewHelper.inicializar();

		return RiccConstants.TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE_TRANSPORTES;
	}

	public void carregarDados() {

		// consulta detalhes transporte - RICCIABF
		consultaDadosSetorTransporte();

		// consulta abertura faturamento ebitda - RICCIAAR
		consultaAberturaFaturamentoEbitda();

		// consulta principais custos operacionais - RICCIAAQ
		consultaPrincipaisCustosOperacionais();

		// consulta capital investido - RICCIAAS
		consultaCapex();

		// consulta tipos de contratos - RICCIAAU
		consultaTiposContratos();

		// consulta transporte de cargas - RICCIAAP
		consultaTransporteCargas();

		// consulta locadoras (tudo) - RICCIAAV
		consultaLocadoras();

		// consulta transporte passageiros - RICCIAAT
		consultaTransportePassageiros();

		/*
		 * consulta comentários - RICCIAA9 Tipo 15 1 – Detalhe Situação dos
		 * Principais Contratos. 2 – Licitações e seus Vencimentos. 3 – Outorga.
		 * 4 – Detalhe Principais Investimentos.
		 */
		consultaComentarios();

		atribuirValorAnos(null);
		carregarTotaisPrcNaoSalvos();

		siteUtil.retirarMensagemDuplicada();
	}

	public void calculoGrauAlienacao() {
		DadosTransportesDatabaseVO dadosTransportes = getViewHelper()
				.getModel().getDadosTransportesDatabase();
		BigDecimal saldoDevedor = siteUtil
				.valueToMainframeBigDecimal(dadosTransportes
						.getSaldoDevedorFinameLeasing());
		BigDecimal valorFrota = siteUtil
				.valueToMainframeBigDecimal(dadosTransportes.getValorFrota());

		if (!siteUtil.valorVazio(valorFrota.toPlainString())) {
			// Multiplica por 100 para trazer pra %
			BigDecimal calculo = saldoDevedor.divide(valorFrota, 2,
					BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100));
			dadosTransportes.setPrcGrauAlienacaoFrota(calculo.setScale(2,
					BigDecimal.ROUND_HALF_DOWN).toPlainString());
		} else {
			dadosTransportes.setPrcGrauAlienacaoFrota("");
		}
	}

	public void calculoGrauLeasing() {
		DadosTransportesDatabaseVO dadosTransportes = getViewHelper()
				.getModel().getDadosTransportesDatabase();
		BigDecimal desembolso = siteUtil
				.valueToMainframeBigDecimal(dadosTransportes
						.getDesembolsoMensalFinameLeasing());
		BigDecimal faturamento = siteUtil
				.valueToMainframeBigDecimal(dadosTransportes
						.getFaturamentoMedioMensal());

		if (!siteUtil.valorVazio(faturamento.toPlainString())) {
			// Multiplica por 100 para trazer pra %
			BigDecimal calculo = desembolso.divide(faturamento, 2,
					BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100));
			dadosTransportes
					.setPrcGrauComprometimentoReceitasComFinameLeasing(calculo
							.toPlainString());
		} else {
			dadosTransportes
					.setPrcGrauComprometimentoReceitasComFinameLeasing("");
		}
	}

	public void calculoGrauLeasingCagiro() {
		DadosTransportesDatabaseVO dadosTransportes = getViewHelper()
				.getModel().getDadosTransportesDatabase();
		BigDecimal desembolsoFiname = siteUtil
				.valueToMainframeBigDecimal(dadosTransportes
						.getDesembolsoMensalFinameLeasing());
		BigDecimal desembolsoCagiro = siteUtil
				.valueToMainframeBigDecimal(dadosTransportes
						.getDesembolsoMensalCagiro());
		BigDecimal faturamento = siteUtil
				.valueToMainframeBigDecimal(dadosTransportes
						.getFaturamentoMedioMensal());

		if (!siteUtil.valorVazio(faturamento.toPlainString())) {
			// Multiplica por 100 para trazer pra %
			BigDecimal calculo = (desembolsoFiname.add(desembolsoCagiro))
					.divide(faturamento, 2, BigDecimal.ROUND_HALF_DOWN)
					.multiply(new BigDecimal(100));
			dadosTransportes
					.setPrcGrauComprometimentoReceitasComFinameLeasingCagiro(calculo
							.toPlainString());
		} else {
			dadosTransportes
					.setPrcGrauComprometimentoReceitasComFinameLeasingCagiro("");
		}
	}

	private void carregarTotaisPrcNaoSalvos() {
		for (int i = 1; i <= 4; i++) {
			calculaTotalTransporteCargas(i);
			calculaTotalFaturamentoLocadoras(i);
		}
	}

	private void consultaDadosSetorTransporte() {
		QuestionarioTransportesVO model = viewHelper.getModel();
		try {
			model.setDadosTransportesDatabase(questionarioTransportesService
					.consultaDadosSetorTransportes(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaAberturaFaturamentoEbitda() {
		QuestionarioTransportesVO model = viewHelper.getModel();
		try {
			model.setFaturamentoEbitda(questionarioTransportesService
					.consultaAberturaFaturamentoEmpresa(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaPrincipaisCustosOperacionais() {
		QuestionarioTransportesVO model = viewHelper.getModel();

		List<CustosOperacionaisVO> _lista;
		try {
			_lista = questionarioTransportesService
					.consultaCustosOperacionais(model);

			PrincipaisCustosOperacionaisVO _principaisCustosOperacionais = model
					.getPrincipaisCustosOperacionais();
			_principaisCustosOperacionais.setCustosOperacionaisAno1(_lista
					.get(0));
			_principaisCustosOperacionais.setCustosOperacionaisAno2(_lista
					.get(1));
			_principaisCustosOperacionais.setCustosOperacionaisAno3(_lista
					.get(2));
			_principaisCustosOperacionais
					.setCustosOperacionaisAnoExpectativa(_lista.get(3));

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaCapex() {
		QuestionarioTransportesVO model = viewHelper.getModel();

		List<CapitalInvestidoVO> _lista;
		try {
			_lista = questionarioTransportesService.consultaCapex(model);

			PrincipaisCustosOperacionaisVO _principaisCustosOperacionais = model
					.getPrincipaisCustosOperacionais();
			_principaisCustosOperacionais.setCapexAno1(_lista.get(0));
			_principaisCustosOperacionais.setCapexAno2(_lista.get(1));
			_principaisCustosOperacionais.setCapexAno3(_lista.get(2));
			_principaisCustosOperacionais.setCapexAnoExpectativa(_lista.get(3));

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaTiposContratos() {
		QuestionarioTransportesVO model = viewHelper.getModel();

		List<TipoContratosVO> _lista;
		try {
			_lista = questionarioTransportesService
					.consultaTiposContratos(model);

			model.setTipoContratosAno1(_lista.get(0));
			model.setTipoContratosAno2(_lista.get(1));
			model.setTipoContratosAno3(_lista.get(2));
			model.setTipoContratosAnoExpectativa(_lista.get(3));

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaTransporteCargas() {
		QuestionarioTransportesVO model = viewHelper.getModel();

		List<TransportesCargasVO> _lista;
		try {
			_lista = questionarioTransportesService
					.consultaTransportesCargas(model);

			model.setTransportesCargasAno1(_lista.get(0));
			model.setTransportesCargasAno2(_lista.get(1));
			model.setTransportesCargasAno3(_lista.get(2));
			model.setTransportesCargasAnoExpectativa(_lista.get(3));

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void calculaTotalTransporteCargas(int ano) {
		TransportesCargasVO _transporte = getViewHelper()
				.getTransporteCargasAno(ano);

		BigDecimal _propria = siteUtil.valueToMainframeBigDecimal(_transporte
				.getPrcPropria());
		BigDecimal _agregados = siteUtil.valueToMainframeBigDecimal(_transporte
				.getPrcAgregados());
		BigDecimal _terceiros = siteUtil.valueToMainframeBigDecimal(_transporte
				.getPrcTerceiros());

		BigDecimal calculo = _propria.add(_agregados.add(_terceiros));
		if (!siteUtil.valorVazio(calculo.toPlainString())) {
			_transporte.setPrcTotal(calculo.toPlainString());
		} else {
			_transporte.setPrcTotal("");
		}
	}

	private void calculaTotalFaturamentoLocadoras(int ano) {
		ValoresLocadorasVO _vlrsLocadoras = getViewHelper()
				.getValoresLocadorasAno(ano);

		BigDecimal _locacao = siteUtil
				.valueToMainframeBigDecimal(_vlrsLocadoras.getPrcLocacao());
		BigDecimal _vendaVeiculos = siteUtil
				.valueToMainframeBigDecimal(_vlrsLocadoras
						.getPrcVendaVeiculos());
		BigDecimal _outros = siteUtil.valueToMainframeBigDecimal(_vlrsLocadoras
				.getPrcOutros());

		BigDecimal calculo = _locacao.add(_vendaVeiculos.add(_outros));
		if (!siteUtil.valorVazio(calculo.toPlainString())) {
			_vlrsLocadoras.setPrcTotal(calculo.toPlainString());
		} else {
			_vlrsLocadoras.setPrcTotal("");
		}
	}

	private void consultaLocadoras() {
		QuestionarioTransportesVO model = viewHelper.getModel();
		try {
			model.setLocadoras(questionarioTransportesService
					.consultaLocadoras(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaTransportePassageiros() {
		QuestionarioTransportesVO model = viewHelper.getModel();

		List<TransportesPassageirosVO> _lista;
		try {
			_lista = questionarioTransportesService
					.consultaTransportesPassageiros(model);

			model.setTransportesPassageirosAno1(_lista.get(0));
			model.setTransportesPassageirosAno2(_lista.get(1));
			model.setTransportesPassageirosAno3(_lista.get(2));
			model.setTransportesPassageirosAnoExpectativa(_lista.get(3));

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaComentarios() {
		QuestionarioTransportesVO model = viewHelper.getModel();

		try {
			/*
			 * Sequência de comentário Descrição do projeto - 1/0 Detalhar
			 * fontes de financiamento - 2/1 Status de licenciamento
			 * socioambiental - 3/2
			 */
			List<ComentarioVO> _comentarios = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_TRANSPORTE);

			model.getFaturamentoEbitda().setDescSituacaoPrincipaisContratos(
					_comentarios.get(0).getComentario());
			model.getFaturamentoEbitda().setDescLicitacoesVencimentos(
					_comentarios.get(1).getComentario());
			model.getFaturamentoEbitda()
					.setDescOutorgaUltimosValoresFonteFinanciamento(
							_comentarios.get(2).getComentario());
			model.getPrincipaisCustosOperacionais()
					.setDescPrincipaisInvestimentos(
							_comentarios.get(3).getComentario());

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void atribuirValorAnos(AjaxBehaviorEvent e) {
		CustosOperacionaisVO _custosOperacionais = viewHelper
				.getCustosOperacionaisAno(1);
		String _anoRequest = _custosOperacionais.getAno();

		String _ano = null;
		for (int i = 1; i <= 4; i++) {
			// Tratamento para quando apagar o ANO 1 - Custos Operacionais
			if (siteUtil.isNotEmptyOrNull(_anoRequest)) {
				if (siteUtil.isNotEmptyOrNull(_ano)) {
					Integer _anoInteger = siteUtil.nullToInteger(_ano);
					_ano = String.valueOf(++_anoInteger);
				} else {
					_ano = String.valueOf(_anoRequest);
				}
			}

			if (i != 1) {
				// Preenche os demais anos do Custos Operacionais
				viewHelper.getCustosOperacionaisAno(i).setAno(_ano);
			}

			// CAPEX (R$)
			viewHelper.getCapexAno(i).setAno(_ano);
			// Tipo de Contratos
			viewHelper.getTipoContratosAno(i).setAno(_ano);
			// Para transporte de cargas
			viewHelper.getTransporteCargasAno(i).setAno(_ano);
			// Locadoras
			viewHelper.getValoresLocadorasAno(i).setAno(_ano);
			// Para transporte de passageiros
			viewHelper.getTransportesPassageirosAno(i).setAno(_ano);
		}

	}

	public String voltar() {
		return paginaAnterior;
	}

	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

}
