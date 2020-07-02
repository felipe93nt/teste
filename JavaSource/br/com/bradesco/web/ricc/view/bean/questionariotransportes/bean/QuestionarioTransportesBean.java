package br.com.bradesco.web.ricc.view.bean.questionariotransportes.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.enums.ComentarioEnum;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CapitalInvestidoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CustosOperacionaisVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.DadosTransportesDatabaseVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.FaturamentoEbitdaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.LocadorasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.PercentualFaturamentoEbitdaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.PrincipaisCustosOperacionaisVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TipoContratosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesCargasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesPassageirosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.ValoresLocadorasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.xls.SetorTransportesVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.service.business.questionariotransportes.IQuestionarioTransportesService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.questionariotransportes.viewhelper.QuestionarioTransportesViewHelper;
import br.com.bradesco.web.ricc.xls.QuestionarioTransporteXLS;

@SessionScoped
@Named(value = "questionarioTransportesBean")
public class QuestionarioTransportesBean extends
		AbstractBean<QuestionarioTransportesViewHelper> {

	private static final long serialVersionUID = 7812957486456093017L;

	@Inject
	@Named("questionarioTransportesService")
	private IQuestionarioTransportesService questionarioTransportesService;

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;

	private String paginaAnterior = "";
	private String idCampoValidacaoFocoResponse = "";

	private DiskFileItem file;
	private File tempFile;

	@Override
	public String iniciarPagina() {
		setViewHelper(new QuestionarioTransportesViewHelper());
		viewHelper.inicializar();

		idCampoValidacaoFocoResponse = null;

		return RiccConstants.TELA_QUESTIONARIO_TRANSPORTES;
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
		 * Principais Contratos. 2 – Licitações e seus Vencimentos. 3 –
		 * Outorga. 4 – Detalhe Principais Investimentos.
		 */
		consultaComentarios();

		carregarTotaisPrcNaoSalvos();

		siteUtil.retirarMensagemDuplicada();
	}

	private void carregarTotaisPrcNaoSalvos() {
		for (int i = 1; i <= 4; i++) {
			calculaTotalTransporteCargasAno(i);
			calculaTotalFaturamentoLocadorasAno(i);
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

	public void calculoGrauAlienacao(AjaxBehaviorEvent e) {
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
		calculoFrotaPropria(null);
	}

	public void calculoGrauLeasing(AjaxBehaviorEvent e) {
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

		calculoGrauLeasingCagiro(null);
	}

	public void calculoGrauLeasingCagiro(AjaxBehaviorEvent e) {
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

	public void calculoFrotaPropria(AjaxBehaviorEvent e) {
		DadosTransportesDatabaseVO dadosTransportes = getViewHelper()
				.getModel().getDadosTransportesDatabase();
		BigDecimal grauFrota = siteUtil
				.valueToMainframeBigDecimal(dadosTransportes
						.getPrcGrauAlienacaoFrota().replace(".", ","));
		BigDecimal porcentagem = new BigDecimal("100.00");

		BigDecimal calculo = porcentagem.subtract(grauFrota);
		if (!siteUtil.valorVazio(grauFrota.toPlainString())) {
			if (calculo.toPlainString().contains("-")) {
				dadosTransportes.setPrcFrotaPropria("0,00");
			} else {
				dadosTransportes.setPrcFrotaPropria(siteUtil
						.formatValoresToString(calculo.toPlainString()));
			}
		} else {
			if (siteUtil.isEmptyOrNull(dadosTransportes
					.getPrcGrauAlienacaoFrota())) {
				dadosTransportes.setPrcFrotaPropria(null);
			} else {
				dadosTransportes.setPrcFrotaPropria("100,00");
			}
		}
	}

	public void calculaTotalCustosOperacionais(AjaxBehaviorEvent e) {
		int anoRequest = getAnoRequestById(e.getComponent().getId());
		CustosOperacionaisVO _custosOperacionais = getViewHelper()
				.getCustosOperacionaisAno(anoRequest);

		BigDecimal combustiveis = siteUtil
				.valueToMainframeBigDecimal(_custosOperacionais
						.getPrcCombustiveis());
		BigDecimal maoObra = siteUtil
				.valueToMainframeBigDecimal(_custosOperacionais
						.getPrcMaoDeObra());
		BigDecimal outros = siteUtil
				.valueToMainframeBigDecimal(_custosOperacionais.getPrcOutros());

		BigDecimal calculo = combustiveis.add(maoObra.add(outros));
		if (!siteUtil.valorVazio(calculo.toPlainString())) {
			_custosOperacionais.setPrcTotal(calculo.toPlainString());
		} else {
			_custosOperacionais.setPrcTotal("");
		}
	}

	private int getAnoRequestById(String id) {
		if (id.contains("Ano1")) {
			return 1;
		} else if (id.contains("Ano2")) {
			return 2;
		} else if (id.contains("Ano3")) {
			return 3;
		} else {
			return 4;
		}
	}

	public void calculaTotalTipoContratos(AjaxBehaviorEvent e) {
		int anoRequest = getAnoRequestById(e.getComponent().getId());
		TipoContratosVO _tipoContratos = getViewHelper().getTipoContratosAno(
				anoRequest);

		BigDecimal performar = siteUtil
				.valueToMainframeBigDecimal(_tipoContratos.getPrcAPerformar());
		BigDecimal takeOrPlay = siteUtil
				.valueToMainframeBigDecimal(_tipoContratos.getPrcTakeOrPay());
		BigDecimal locacao = siteUtil.valueToMainframeBigDecimal(_tipoContratos
				.getPrcLocacao());
		BigDecimal spot = siteUtil.valueToMainframeBigDecimal(_tipoContratos
				.getPrcSpot());

		BigDecimal calculo = performar.add(takeOrPlay.add(locacao.add(spot)));
		if (!siteUtil.valorVazio(calculo.toPlainString())) {
			_tipoContratos.setPrcTotal(calculo.toPlainString());
		} else {
			_tipoContratos.setPrcTotal("");
		}
	}

	public void calculaTotalTransporteCargas(AjaxBehaviorEvent e) {
		int anoRequest = getAnoRequestById(e.getComponent().getId());
		calculaTotalTransporteCargasAno(anoRequest);
	}

	private void calculaTotalTransporteCargasAno(int ano) {
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

	public void calculaTotalFaturamentoLocadoras(AjaxBehaviorEvent e) {
		int anoRequest = getAnoRequestById(e.getComponent().getId());
		calculaTotalFaturamentoLocadorasAno(anoRequest);
	}

	private void calculaTotalFaturamentoLocadorasAno(int ano) {
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

	public String voltar() {
		return paginaAnterior;
	}

	public void salvar(ActionEvent ae) {
		QuestionarioTransportesVO model = viewHelper.getModel();

		try {

			// manutenção abertura faturamento ebitda - RICCIABY
			questionarioTransportesService
					.manutencaoAberturaFaturamentoEmpresa(model);

			// manutenção dados setor transporte - RICCIACL - OK
			questionarioTransportesService.manutencaoDadosSetorTransportes(
					model, TipoManutencaoEnum.ALTERACAO.getCodigoString());

			// manutenção principais custos operacionais - RICCIABX

			// Atribuir 1901 a ano não preenchido para mainframe ignorar
			if (viewHelper.getCustosOperacionaisAno(1).getAno().equals("")) {
				viewHelper.getCustosOperacionaisAno(1).setAno("1901");
			}
			atribuirValorAnos(null);
			if (siteUtil.valueToMainframeBigDecimal(
					getViewHelper().getModel()
							.getPrincipaisCustosOperacionais()
							.getCustosOperacionaisAno1().getPrcTotal())
					.compareTo(new BigDecimal(999.99)) > 0
					|| siteUtil.valueToMainframeBigDecimal(
							getViewHelper().getModel()
									.getPrincipaisCustosOperacionais()
									.getCustosOperacionaisAno2().getPrcTotal())
							.compareTo(new BigDecimal(999.99)) > 0
					|| siteUtil.valueToMainframeBigDecimal(
							getViewHelper().getModel()
									.getPrincipaisCustosOperacionais()
									.getCustosOperacionaisAno3().getPrcTotal())
							.compareTo(new BigDecimal(999.99)) > 0
					|| siteUtil.valueToMainframeBigDecimal(
							getViewHelper().getModel()
									.getPrincipaisCustosOperacionais()
									.getCustosOperacionaisAnoExpectativa()
									.getPrcTotal()).compareTo(
							new BigDecimal(999.99)) > 0) {
				throw new IllegalArgumentException(
						"Porcentagem em relação ao custo total Superior a 999,99%");
			} else {
				questionarioTransportesService
						.manutencaoCustosOperacionais(model);
			}

			// manutenção capital investido - RICCIABZ
			questionarioTransportesService.manutencaoCapex(model);

			// manutenção tipos de contratos - RICCIAB1
			if (siteUtil.valueToMainframeBigDecimal(
					getViewHelper().getModel().getTipoContratosAno1()
							.getPrcTotal()).compareTo(new BigDecimal(999.99)) > 0
					|| siteUtil.valueToMainframeBigDecimal(
							getViewHelper().getModel().getTipoContratosAno2()
									.getPrcTotal()).compareTo(
							new BigDecimal(999.99)) > 0
					|| siteUtil.valueToMainframeBigDecimal(
							getViewHelper().getModel().getTipoContratosAno3()
									.getPrcTotal()).compareTo(
							new BigDecimal(999.99)) > 0
					|| siteUtil.valueToMainframeBigDecimal(
							getViewHelper().getModel()
									.getTipoContratosAnoExpectativa()
									.getPrcTotal()).compareTo(
							new BigDecimal(999.99)) > 0) {
				throw new IllegalArgumentException(
						"Porcentagem Tipo de Contratos Superior a 999,99%");
			} else {
				questionarioTransportesService.manutencaoTiposContratos(model);
			}

			// manutenção transporte de cargas - RICCIABW
			questionarioTransportesService.manutencaoTransportesCargas(model);

			// manutenção locadoras - RICCIAB2
			questionarioTransportesService.manutencaoLocadoras(model);

			// manutenção transporte passageiros - RICCIAB0
			questionarioTransportesService
					.manutencaoTransportesPassageiros(model);

			// Atribuir "" a ano "1901" para ignorar na tela
			if (viewHelper.getCustosOperacionaisAno(1).getAno().equals("1901")) {
				viewHelper.getCustosOperacionaisAno(1).setAno("");
			}
			atribuirValorAnos(null);

			// manutenção comentários - RICCIACG
			segmentoService.manutencaoComentarios(model,
					retornaListComentariosTransportes(), "");

			siteUtil.getMessages().getMsgSalvarSucesso();
			// }

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	private boolean validaTotalPercentuais() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		/*
		 * A soma do percentual é maior que 100,0% - exibir modal de erro AO
		 * SALVAR, informar quadro e ano que excedeu total - Principais custos
		 * operacionais - Tipo de Contratos - Transporte de cargas - %
		 * faturamento de locadoras
		 */
		if (!validaPrcTotal("validaPrcTotalCustosOperacionaisAno")) {
			return false;
		}

		if (!validaPrcTotal("validaPrcTotalTipoContratosAno")) {
			return false;
		}

		if (!validaPrcTotal("validaPrcTotalTransporteCargasAno")) {
			return false;
		}

		if (!validaPrcTotal("validaPrcTotalFaturamentoLocadorasAno")) {
			return false;
		}

		return true;
	}

	private Boolean validaPrcTotal(String nomeMetodo)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		for (int i = 1; i <= 4; i++) {
			if (!(Boolean) this.getClass().getMethod(nomeMetodo, int.class)
					.invoke(this, i)) {
				return false;
			}
		}
		return true;
	}

	public boolean validaPrcTotalFaturamentoLocadorasAno(int ano) {
		String _idCampoQuadroGenerico = "txt_locadoras_prcAno?Locacao";
		ValoresLocadorasVO _vlrsLocadoras = viewHelper
				.getValoresLocadorasAno(ano);
		BigDecimal _prcTotal = siteUtil
				.valueToMainframeBigDecimal(_vlrsLocadoras.getPrcTotal());
		if (_prcTotal.compareTo(new BigDecimal(100)) == 1) {
			siteUtil.getMessages().getMsgSomaPercentualTotalMaiorQueCem(
					"label_para_locadoras", _vlrsLocadoras.getAno());
			idCampoValidacaoFocoResponse = _idCampoQuadroGenerico.replace("?",
					getDeParaAnoToId(ano));
			return false;
		}
		return true;
	}

	public boolean validaPrcTotalTransporteCargasAno(int ano) {
		String _idCampoQuadroGenerico = "txt_transportesCargas_prcAno?Propria";
		TransportesCargasVO _transporte = viewHelper
				.getTransporteCargasAno(ano);
		BigDecimal _prcTotal = siteUtil.valueToMainframeBigDecimal(_transporte
				.getPrcTotal());
		if (_prcTotal.compareTo(new BigDecimal(100)) == 1) {
			siteUtil.getMessages().getMsgSomaPercentualTotalMaiorQueCem(
					"label_transporte_cargas", _transporte.getAno());
			idCampoValidacaoFocoResponse = _idCampoQuadroGenerico.replace("?",
					getDeParaAnoToId(ano));
			return false;
		}
		return true;
	}

	public boolean validaPrcTotalTipoContratosAno(int ano) {
		String _idCampoQuadroGenerico = "txt_tipoContratos_prcAno?APerformar";
		TipoContratosVO _tipoContratos = viewHelper.getTipoContratosAno(ano);
		BigDecimal _prcTotal = siteUtil
				.valueToMainframeBigDecimal(_tipoContratos.getPrcTotal());
		if (_prcTotal.compareTo(new BigDecimal(100)) == 1) {
			siteUtil.getMessages().getMsgSomaPercentualTotalMaiorQueCem(
					"label_tipo_contratos", _tipoContratos.getAno());
			idCampoValidacaoFocoResponse = _idCampoQuadroGenerico.replace("?",
					getDeParaAnoToId(ano));
			return false;
		}
		return true;
	}

	public boolean validaPrcTotalCustosOperacionaisAno(int ano) {
		String _idCampoQuadroGenerico = "txt_custosOperacionais_prcAno?Combustiveis";
		CustosOperacionaisVO _custos = viewHelper.getCustosOperacionaisAno(ano);
		BigDecimal _prcTotal = siteUtil.valueToMainframeBigDecimal(_custos
				.getPrcTotal());
		if (_prcTotal.compareTo(new BigDecimal(100)) == 1) {
			siteUtil.getMessages().getMsgSomaPercentualTotalMaiorQueCem(
					"label_principais_custos", _custos.getAno());
			idCampoValidacaoFocoResponse = _idCampoQuadroGenerico.replace("?",
					getDeParaAnoToId(ano));
			return false;
		}
		return true;
	}

	private String getDeParaAnoToId(Integer ano) {
		if (ano == 4) {
			return "Expectativa";
		}
		return String.valueOf(ano);
	}

	private List<ComentarioVO> retornaListComentariosTransportes() {
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();

		FaturamentoEbitdaVO _faturamentoEbitda = viewHelper.getModel()
				.getFaturamentoEbitda();
		ComentarioVO comentario = new ComentarioVO();
		comentario
				.setCodTipo(ComentarioEnum.TRANSPORTES_SITUACAO_PRINCIPAIS_CONTRATOS
						.getCodigo());
		comentario
				.setCodSequencial(ComentarioEnum.TRANSPORTES_SITUACAO_PRINCIPAIS_CONTRATOS
						.getNumSequencial());
		comentario.setComentario(siteUtil.nullToString(_faturamentoEbitda
				.getDescSituacaoPrincipaisContratos()));
		comentarios.add(comentario);

		comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.TRANSPORTES_LICITACOES_VENCIMENTOS
				.getCodigo());
		comentario
				.setCodSequencial(ComentarioEnum.TRANSPORTES_LICITACOES_VENCIMENTOS
						.getNumSequencial());
		comentario.setComentario(siteUtil.nullToString(_faturamentoEbitda
				.getDescLicitacoesVencimentos()));
		comentarios.add(comentario);

		comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.TRANSPORTES_OUTORGA.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.TRANSPORTES_OUTORGA
				.getNumSequencial());
		comentario.setComentario(siteUtil.nullToString(_faturamentoEbitda
				.getDescOutorgaUltimosValoresFonteFinanciamento()));
		comentarios.add(comentario);

		PrincipaisCustosOperacionaisVO _principaisCustos = viewHelper
				.getModel().getPrincipaisCustosOperacionais();
		comentario = new ComentarioVO();
		comentario
				.setCodTipo(ComentarioEnum.TRANSPORTES_PRINCIPAIS_INVESTIMENTOS
						.getCodigo());
		comentario
				.setCodSequencial(ComentarioEnum.TRANSPORTES_PRINCIPAIS_INVESTIMENTOS
						.getNumSequencial());
		comentario.setComentario(siteUtil.nullToString(_principaisCustos
				.getDescPrincipaisInvestimentos()));
		comentarios.add(comentario);

		return comentarios;
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

	public void upload() {

		try {
			if (this.file == null) {
				BradescoFacesUtils
						.addErrorModalMessage("Selecione a planilha para Upload.");
			} else {
				if (this.file.getName().toUpperCase().contains(".XLSM")) {
					this.tempFile = File.createTempFile("transp", ".xlsm");
					this.tempFile.deleteOnExit();

					copyToFile(this.file.getInputStream(), this.tempFile);

					SetorTransportesVO setorProjetosVO = new QuestionarioTransporteXLS()
							.lerSetorTransportesXLSM(this.tempFile);

					if (setorProjetosVO != null) {
						viewHelper.setModel(popularViaXls(setorProjetosVO));
						BradescoFacesUtils.addInfoModalMessage(
								"Processamento da planilha conclu�do.", false);
					} else {
						BradescoFacesUtils
								.addErrorModalMessage("Selecione a planilha de setor correspondente.");
					}
				} else {
					BradescoFacesUtils
							.addErrorModalMessage("Arquivo inv�lido para Upload.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		}
	}

	public void copyToFile(InputStream inputStream, File file) {
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(file);
			IOUtils.copy(inputStream, outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		} catch (IOException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		}
	}

	public QuestionarioTransportesVO popularViaXls(SetorTransportesVO xls) {

		QuestionarioTransportesVO transportes = new QuestionarioTransportesVO();

		// Data Base
		DadosTransportesDatabaseVO dataBase = new DadosTransportesDatabaseVO();

		if (siteUtil.isNotEmptyOrNull(xls.getDataBase())) {
			dataBase.setDatabase(dateUtil.stringToDate(xls.getDataBase(),
					dateUtil.DATA_SEM_HORA_BARRA));
		}
		dataBase.setQtdVeiculos(siteUtil.tratarParametroString(xls
				.getQuantidadeVeiculos()));
		dataBase.setValorFrota(siteUtil.tratarParametroString(xls
				.getValorDaFrota()));
		dataBase.setSaldoDevedorFinameLeasing(siteUtil
				.tratarParametroString(xls.getSaldoDevedor()));

		dataBase.setIdadeMediaAnos(siteUtil.tratarParametroString(xls
				.getIdadeMedia()));
		dataBase.setDesembolsoMensalFinameLeasing(siteUtil
				.tratarParametroString(xls.getDesembolsoLeasingFiname()));
		dataBase.setDesembolsoMensalCagiro(siteUtil.tratarParametroString(xls
				.getDesembolsoCagiro()));
		dataBase.setFaturamentoMedioMensal(siteUtil.tratarParametroString(xls
				.getFaturamentoMedioMensal()));

		dataBase.setPrcFrotaPropria(siteUtil.tratarDuasCasasDecimais(xls
				.getPercentualFrotaPropria()));
		dataBase.setPrcMargemEbitdaUltimoExercicio(siteUtil
				.tratarDuasCasasDecimais(xls.getMargemEBITDA()));

		transportes.setDadosTransportesDatabase(dataBase);

		// Abertura do Faturamento EBITDA
		FaturamentoEbitdaVO faturamentoEbitda = new FaturamentoEbitdaVO();

		PercentualFaturamentoEbitdaVO prcFaturamento = new PercentualFaturamentoEbitdaVO();
		prcFaturamento.setPrcVarejo(siteUtil.tratarDuasCasasDecimais(xls
				.getVarejoFaturamento()));
		prcFaturamento.setPrcSaude(siteUtil.tratarDuasCasasDecimais(xls
				.getSaudeFaturamento()));
		prcFaturamento.setPrcQuimico(siteUtil.tratarDuasCasasDecimais(xls
				.getQuimicoFaturamento()));
		prcFaturamento.setPrcAgro(siteUtil.tratarDuasCasasDecimais(xls
				.getAgroFaturamento()));
		prcFaturamento.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getOutrosFaturamento()));
		prcFaturamento.setPrcSetorPublico(siteUtil.tratarDuasCasasDecimais(xls
				.getSetorPublicoFaturamento()));
		prcFaturamento.setPrcReceitasAVista(siteUtil.tratarDuasCasasDecimais(xls
				.getReceitasVistaFaturamento()));
		prcFaturamento.setPrcReceitasAPrazo(siteUtil.tratarDuasCasasDecimais(xls
				.getReceitasPrazoFaturamento()));
		faturamentoEbitda.setPrcFaturamento(prcFaturamento);

		PercentualFaturamentoEbitdaVO prcEbitda = new PercentualFaturamentoEbitdaVO();
		prcEbitda.setPrcVarejo(siteUtil.tratarDuasCasasDecimais(xls
				.getVarejoEBITDA()));
		prcEbitda.setPrcSaude(siteUtil.tratarDuasCasasDecimais(xls
				.getSaudeEBITDA()));
		prcEbitda.setPrcQuimico(siteUtil.tratarDuasCasasDecimais(xls
				.getQuimicoEBITDA()));
		prcEbitda
				.setPrcAgro(siteUtil.tratarDuasCasasDecimais(xls.getAgroEBITDA()));
		prcEbitda.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getOutrosEBITDA()));
		prcEbitda.setPrcSetorPublico(siteUtil.tratarDuasCasasDecimais(xls
				.getSetorPublicoEBITDA()));
		prcEbitda.setPrcReceitasAVista(siteUtil.tratarDuasCasasDecimais(xls
				.getReceitasVistaEBITDA()));
		prcEbitda.setPrcReceitasAPrazo(siteUtil.tratarDuasCasasDecimais(xls
				.getReceitasPrazoEBITDA()));
		faturamentoEbitda.setPrcEbitda(prcEbitda);

		faturamentoEbitda.setDescReceitasPorSegmentoOutros(xls
				.getDescricaoOutros());
		faturamentoEbitda.setDescSituacaoPrincipaisContratos(xls
				.getDetalharSituacaoPrincipaisContratos());
		faturamentoEbitda.setDescLicitacoesVencimentos(xls
				.getLicitacoesSeusVencimentos());
		faturamentoEbitda.setDescOutorgaUltimosValoresFonteFinanciamento(xls
				.getOutorgaVencimentosUltimosValores());

		transportes.setFaturamentoEbitda(faturamentoEbitda);

		// Principais Custos Operacionais
		PrincipaisCustosOperacionaisVO principaisCustosOperacionais = new PrincipaisCustosOperacionaisVO();

		// CustosOperacionais
		CustosOperacionaisVO custosOperacionais;

		custosOperacionais = new CustosOperacionaisVO();
		custosOperacionais.setAno(xls.getAnoPrincipalCustoOperacional());
		custosOperacionais.setPrcCombustiveis(siteUtil
				.tratarDuasCasasDecimais(xls.getCombustiveis1()));
		custosOperacionais.setPrcMaoDeObra(siteUtil.tratarDuasCasasDecimais(xls
				.getMaoDeObra1()));
		custosOperacionais.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getOutros1()));
		principaisCustosOperacionais
				.setCustosOperacionaisAno1(custosOperacionais);

		custosOperacionais = new CustosOperacionaisVO();
		custosOperacionais.setPrcCombustiveis(siteUtil
				.tratarDuasCasasDecimais(xls.getCombustiveis2()));
		custosOperacionais.setPrcMaoDeObra(siteUtil.tratarDuasCasasDecimais(xls
				.getMaoDeObra2()));
		custosOperacionais.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getOutros2()));
		principaisCustosOperacionais
				.setCustosOperacionaisAno2(custosOperacionais);

		custosOperacionais = new CustosOperacionaisVO();
		custosOperacionais.setPrcCombustiveis(siteUtil
				.tratarDuasCasasDecimais(xls.getCombustiveis3()));
		custosOperacionais.setPrcMaoDeObra(siteUtil.tratarDuasCasasDecimais(xls
				.getMaoDeObra3()));
		custosOperacionais.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getOutros3()));
		principaisCustosOperacionais
				.setCustosOperacionaisAno3(custosOperacionais);

		custosOperacionais = new CustosOperacionaisVO();
		custosOperacionais.setPrcCombustiveis(siteUtil
				.tratarDuasCasasDecimais(xls.getCombustiveis4()));
		custosOperacionais.setPrcMaoDeObra(siteUtil.tratarDuasCasasDecimais(xls
				.getMaoDeObra4()));
		custosOperacionais.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getOutros4()));
		principaisCustosOperacionais
				.setCustosOperacionaisAnoExpectativa(custosOperacionais);

		// Capex
		CapitalInvestidoVO capex;

		capex = new CapitalInvestidoVO();
		capex.setValorRecursosProprios(siteUtil.tratarParametroString(xls
				.getRecursosProprios1()));
		capex.setValorRecursosTerceiros(siteUtil.tratarParametroString(xls
				.getRecursosTerceiros1()));
		principaisCustosOperacionais.setCapexAno1(capex);

		capex = new CapitalInvestidoVO();
		capex.setValorRecursosProprios(siteUtil.tratarParametroString(xls
				.getRecursosProprios2()));
		capex.setValorRecursosTerceiros(siteUtil.tratarParametroString(xls
				.getRecursosTerceiros2()));
		principaisCustosOperacionais.setCapexAno2(capex);

		capex = new CapitalInvestidoVO();
		capex.setValorRecursosProprios(siteUtil.tratarParametroString(xls
				.getRecursosProprios3()));
		capex.setValorRecursosTerceiros(siteUtil.tratarParametroString(xls
				.getRecursosTerceiros3()));
		principaisCustosOperacionais.setCapexAno3(capex);

		capex = new CapitalInvestidoVO();
		capex.setValorRecursosProprios(siteUtil.tratarParametroString(xls
				.getRecursosProprios4()));
		capex.setValorRecursosTerceiros(siteUtil.tratarParametroString(xls
				.getRecursosTerceiros4()));
		principaisCustosOperacionais.setCapexAnoExpectativa(capex);

		principaisCustosOperacionais.setDescPrincipaisInvestimentos(xls
				.getDetalharPrincipaisInvestimentos());

		transportes
				.setPrincipaisCustosOperacionais(principaisCustosOperacionais);

		// Tipos de Contratos
		TipoContratosVO tipoContratos;

		tipoContratos = new TipoContratosVO();
		tipoContratos.setPrcAPerformar(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoAPerformar1()));
		tipoContratos.setPrcTakeOrPay(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoTakeOrPay1()));
		tipoContratos.setPrcLocacao(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoLocacao1()));
		tipoContratos.setPrcSpot(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoSpot1()));
		transportes.setTipoContratosAno1(tipoContratos);

		tipoContratos = new TipoContratosVO();
		tipoContratos.setPrcAPerformar(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoAPerformar2()));
		tipoContratos.setPrcTakeOrPay(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoTakeOrPay2()));
		tipoContratos.setPrcLocacao(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoLocacao2()));
		tipoContratos.setPrcSpot(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoSpot2()));
		transportes.setTipoContratosAno2(tipoContratos);

		tipoContratos = new TipoContratosVO();
		tipoContratos.setPrcAPerformar(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoAPerformar3()));
		tipoContratos.setPrcTakeOrPay(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoTakeOrPay3()));
		tipoContratos.setPrcLocacao(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoLocacao3()));
		tipoContratos.setPrcSpot(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoSpot3()));
		transportes.setTipoContratosAno3(tipoContratos);

		tipoContratos = new TipoContratosVO();
		tipoContratos.setPrcAPerformar(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoAPerformar4()));
		tipoContratos.setPrcTakeOrPay(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoTakeOrPay4()));
		tipoContratos.setPrcLocacao(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoLocacao4()));
		tipoContratos.setPrcSpot(siteUtil.tratarDuasCasasDecimais(xls
				.getTpContratoSpot4()));
		transportes.setTipoContratosAnoExpectativa(tipoContratos);

		// Para Transportes de Cargas
		TransportesCargasVO transportesCargas;

		transportesCargas = new TransportesCargasVO();
		transportesCargas.setPrcPropria(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaPropria1()));
		transportesCargas.setPrcAgregados(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaAgregados1()));
		transportesCargas.setPrcTerceiros(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaTerceiros1()));
		transportes.setTransportesCargasAno1(transportesCargas);

		transportesCargas = new TransportesCargasVO();
		transportesCargas.setPrcPropria(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaPropria2()));
		transportesCargas.setPrcAgregados(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaAgregados2()));
		transportesCargas.setPrcTerceiros(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaTerceiros2()));
		transportes.setTransportesCargasAno2(transportesCargas);

		transportesCargas = new TransportesCargasVO();
		transportesCargas.setPrcPropria(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaPropria3()));
		transportesCargas.setPrcAgregados(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaAgregados3()));
		transportesCargas.setPrcTerceiros(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaTerceiros3()));
		transportes.setTransportesCargasAno3(transportesCargas);

		transportesCargas = new TransportesCargasVO();
		transportesCargas.setPrcPropria(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaPropria4()));
		transportesCargas.setPrcAgregados(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaAgregados4()));
		transportesCargas.setPrcTerceiros(siteUtil.tratarDuasCasasDecimais(xls
				.getFrotaTerceiros4()));
		transportes.setTransportesCargasAnoExpectativa(transportesCargas);

		// Para Locadoras
		LocadorasVO locadoras = new LocadorasVO();
		locadoras.setDescFaturamentoOutros(xls.getDescricaoFaturamentoOutros());
		ValoresLocadorasVO valoresLocadoras;

		valoresLocadoras = new ValoresLocadorasVO();
		valoresLocadoras.setPrcLocacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoLocacao1()));
		valoresLocadoras.setPrcVendaVeiculos(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoVendaDeVeiculos1()));
		valoresLocadoras.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoOutros1()));
		valoresLocadoras.setQtdTotal(siteUtil.tratarParametroString(xls
				.getFrotaUnidadesTotal1()));
		valoresLocadoras.setQtdVendaVeiculosAno(siteUtil
				.tratarParametroString(xls.getFrotaUnidadesVendaVeiculos1()));
		locadoras.setValoresLocadorasAno1(valoresLocadoras);

		valoresLocadoras = new ValoresLocadorasVO();
		valoresLocadoras.setPrcLocacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoLocacao2()));
		valoresLocadoras.setPrcVendaVeiculos(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoVendaDeVeiculos2()));
		valoresLocadoras.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoOutros2()));
		valoresLocadoras.setQtdTotal(siteUtil.tratarParametroString(xls
				.getFrotaUnidadesTotal2()));
		valoresLocadoras.setQtdVendaVeiculosAno(siteUtil
				.tratarParametroString(xls.getFrotaUnidadesVendaVeiculos2()));
		locadoras.setValoresLocadorasAno2(valoresLocadoras);

		valoresLocadoras = new ValoresLocadorasVO();
		valoresLocadoras.setPrcLocacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoLocacao3()));
		valoresLocadoras.setPrcVendaVeiculos(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoVendaDeVeiculos3()));
		valoresLocadoras.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoOutros3()));
		valoresLocadoras.setQtdTotal(siteUtil.tratarParametroString(xls
				.getFrotaUnidadesTotal3()));
		valoresLocadoras.setQtdVendaVeiculosAno(siteUtil
				.tratarParametroString(xls.getFrotaUnidadesVendaVeiculos3()));
		locadoras.setValoresLocadorasAno3(valoresLocadoras);

		valoresLocadoras = new ValoresLocadorasVO();
		valoresLocadoras.setPrcLocacao(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoLocacao4()));
		valoresLocadoras.setPrcVendaVeiculos(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoVendaDeVeiculos4()));
		valoresLocadoras.setPrcOutros(siteUtil.tratarDuasCasasDecimais(xls
				.getFaturamentoOutros4()));
		valoresLocadoras.setQtdTotal(siteUtil.tratarParametroString(xls
				.getFrotaUnidadesTotal4()));
		valoresLocadoras.setQtdVendaVeiculosAno(siteUtil
				.tratarParametroString(xls.getFrotaUnidadesVendaVeiculos4()));
		locadoras.setValoresLocadorasAnoExpectativa(valoresLocadoras);

		transportes.setLocadoras(locadoras);

		// Para Transportes de Passageiros
		TransportesPassageirosVO transportesPassageiros;

		transportesPassageiros = new TransportesPassageirosVO();
		transportesPassageiros.setPrcMunicipal(siteUtil
				.tratarDuasCasasDecimais(xls.getReajustesPassagensMunicipal1()));
		transportesPassageiros.setPrcIntermunicipal(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensIntermunicipal1()));
		transportesPassageiros.setPrcInterestadual(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensInterestadual1()));
		transportesPassageiros.setPrcInternacional(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensInternacional1()));
		transportesPassageiros.setPrcFretamento(siteUtil
				.tratarDuasCasasDecimais(xls.getReajustesPassagensFretamento1()));
		transportes.setTransportesPassageirosAno1(transportesPassageiros);

		transportesPassageiros = new TransportesPassageirosVO();
		transportesPassageiros.setPrcMunicipal(siteUtil
				.tratarDuasCasasDecimais(xls.getReajustesPassagensMunicipal2()));
		transportesPassageiros.setPrcIntermunicipal(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensIntermunicipal2()));
		transportesPassageiros.setPrcInterestadual(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensInterestadual2()));
		transportesPassageiros.setPrcInternacional(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensInternacional2()));
		transportesPassageiros.setPrcFretamento(siteUtil
				.tratarDuasCasasDecimais(xls.getReajustesPassagensFretamento2()));
		transportes.setTransportesPassageirosAno2(transportesPassageiros);

		transportesPassageiros = new TransportesPassageirosVO();
		transportesPassageiros.setPrcMunicipal(siteUtil
				.tratarDuasCasasDecimais(xls.getReajustesPassagensMunicipal3()));
		transportesPassageiros.setPrcIntermunicipal(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensIntermunicipal3()));
		transportesPassageiros.setPrcInterestadual(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensInterestadual3()));
		transportesPassageiros.setPrcInternacional(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensInternacional3()));
		transportesPassageiros.setPrcFretamento(siteUtil
				.tratarDuasCasasDecimais(xls.getReajustesPassagensFretamento3()));
		transportes.setTransportesPassageirosAno3(transportesPassageiros);

		transportesPassageiros = new TransportesPassageirosVO();
		transportesPassageiros.setPrcMunicipal(siteUtil
				.tratarDuasCasasDecimais(xls.getReajustesPassagensMunicipal4()));
		transportesPassageiros.setPrcIntermunicipal(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensIntermunicipal4()));
		transportesPassageiros.setPrcInterestadual(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensInterestadual4()));
		transportesPassageiros.setPrcInternacional(siteUtil
				.tratarDuasCasasDecimais(xls
						.getReajustesPassagensInternacional4()));
		transportesPassageiros.setPrcFretamento(siteUtil
				.tratarDuasCasasDecimais(xls.getReajustesPassagensFretamento4()));
		transportes
				.setTransportesPassageirosAnoExpectativa(transportesPassageiros);

		transportes.setCodGrupo(this.viewHelper.getModel().getCodGrupo());
		transportes.setNomeGrupo(this.viewHelper.getModel().getNomeGrupo());

		transportes.setCodRelatorio(this.viewHelper.getModel()
				.getCodRelatorio());

		return transportes;
	}

	public DiskFileItem getFile() {
		return file;
	}

	public void setFile(DiskFileItem file) {
		this.file = file;
	}

	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

	public String getIdCampoValidacaoFocoResponse() {
		return idCampoValidacaoFocoResponse;
	}

	public void setIdCampoValidacaoFocoResponse(
			String idCampoValidacaoFocoResponse) {
		this.idCampoValidacaoFocoResponse = idCampoValidacaoFocoResponse;
	}

}
