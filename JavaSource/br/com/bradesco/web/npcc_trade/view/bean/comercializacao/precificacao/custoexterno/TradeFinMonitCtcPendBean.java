package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.custoexterno;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.VincularOperacaoLcVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.TrataErroUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPendencia;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.ResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitBaseBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.ComissaoIntManutModal.ComissaoIntManutModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.fluxoPgtoManutModal.FluxoPgtoManutModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.vincularOperacaoLc.VincularOperacaoLcBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * 
 * Nome: TradeFinMonitCtcPendeteBean.java
 * 
 * Propósito:
 * <p>
 * Bean para funcionalidade da tela Cotacoes Pendentes - Custo Externo
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */

@Named("tradeFinMonitCtcPendBean")
@SessionScoped
public class TradeFinMonitCtcPendBean extends TradeFinMonitBaseBean implements
		Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 5347235961636633087L;
	private Integer passNumber = Numeros.ZERO;

	@Inject
	@Named("vincularOperacaoLcBean")
	protected VincularOperacaoLcBean vincularOperacaoLcBean;

	@Inject
	@Named("fluxoPgtoManutModalBean")
    private FluxoPgtoManutModalBean fluxoPgtoManutModalBean;
    
    @Inject
    @Named("comissaoIntManutModalBean")
    protected ComissaoIntManutModalBean comissaoIntManutModalBean;
    
	/**
	 * Construtor
	 * 
	 * @param
	 */
	public TradeFinMonitCtcPendBean() {
		super();
	}
	
	/**
	 * 
	 * Nome: iniciar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */

	public String iniciar() {

		try {
			
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.iniciar <<<<<<<<<<<");

			// Recarrega página se não for um postback ou se foi marcado para
			// recaregar
			if (!isPostback() || getIniciarPagina()) {
				setIniciarPagina(false);

				filtroVO = new TradeFinanceFiltroVO();
				lista = new ArrayList<TradeFinanceListaVO>();

				listenerLimparPesquisa(null);
				limparCpfCnpjCliente(null);

				getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);

				devolverModalBean.getViewHelper().setRenderModal(false);
				produto = selectItemBean.getProduto(
						EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
						EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
						EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo());

				getViewHelper().setNomeStateIdLista("NPCCIAQ0");
				getViewHelper().setComboSegmento(getSelectItemBean().getComboSegmento());
				getViewHelper().setComboOperador(selectItemBean.getOperador());
				getViewHelper().setComboMoeda(selectItemBean.getMoeda());
				getViewHelper().setComboUnidadeNegocio(selectItemBean.getComboUnidadeNegocio());
				getViewHelper().setComboTipoDespesas(selectItemBean.getComboTipoDespesas());
				getViewHelper().setComboPorContaGarantia(selectItemBean.getComboPorContaGarantia());
				getViewHelper().setComboPorConta(selectItemBean.getComboPorConta());

				getViewHelper().setComboPeriodicidade(selectItemBean.getPeriodicidade(0));
				getViewHelper().setComboFormaPagamento(selectItemBean.getComboFormaPagamento());
				getViewHelper().setComboFuncao(selectItemBean.getComboFuncao());

				// Zera Lista Despesa
				getViewHelper().setItemSelecListaDespesas(null);
				// Zera Responsavel Despesa
				getViewHelper().setItemSelecListaRespDesp(null);
				// Zera Lista cotações
				getViewHelper().setItemSelecListaCotacoes(null);

				tradeFinanceBean.getViewHelper().setDisabledBotaoDetGar(true);

				getViewHelper().setDataValidadeCotacao(getCommonService().getDataLimiteCotacao(new Date()));

			}

			return "tradeFinCotacoesPendentes";

		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.iniciar <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: pesquisar
	 * 
	 * Propósito: Efetua a pesquisa de cotacoes pendentes
	 *
	 * @param : <BR/>
	 *
	 * @exception : BradescoFacesUtils Message Info
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 28/07/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void pesquisar(AjaxBehaviorEvent event) {

		try {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.pesquisar <<<<<<<<<<<");

			if (validarCamposData() == true) {
				/**
				 * CHECKBOX COTAÇÕES PENDENTES 32 = CUSTO EXTERNO 33 = UNIDADE
				 * EXTERNA 37 = DIVERGENTE
				 **/

				if (getViewHelper().getCustoExterno()) {
					filtroVO.setCsitcustext(32);
				} else {
					filtroVO.setCsitcustext(0);
				}
				if (getViewHelper().getUnidadeExterna()) {
					filtroVO.setCsitunidext(33);
				} else {
					filtroVO.setCsitunidext(0);

				}
				if (getViewHelper().getDivergente()) {
					filtroVO.setCsitdiverg(37);
				} else {
					filtroVO.setCsitdiverg(0);
				}

				lista.clear();

				getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());

				lista = tradeFinanceMonitService.obterCotacoesPend(filtroVO);
			}

		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.pesquisar <<<<<<<<<<<");
		}

	}

	public String retomarPesquisa() {
		try {
			setIniciarPagina(false);
			pesquisar(null);
		} catch (NpccTradeWebException e) {
			TrataErroUtil.getInstance().tratarRetornoPesquisaVaziaMainframe(e);
			lista = new ArrayList<TradeFinanceListaVO>();
		}
		return "/content/comercializacao/precificacao/monitor/tradeFinCotacoesPendentes.xhtml";
	}

	/**
	 * Nome: exportar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 08/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String exportar() {

		try {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.exportar <<<<<<<<<<<");

			/**
			 * CHECKBOX COTAÇÕES PENDENTES 32 = CUSTO EXTERNO 33 = UNIDADE
			 * EXTERNA 37 = DIVERGENTE
			 **/

			if (getViewHelper().getCustoExterno()) {
				getFiltroVO().setCsitcustext(32);
			} else {
				getFiltroVO().setCsitcustext(0);
			}
			if (getViewHelper().getUnidadeExterna()) {
				getFiltroVO().setCsitunidext(33);
			} else {
				getFiltroVO().setCsitunidext(0);

			}
			if (getViewHelper().getDivergente()) {
				getFiltroVO().setCsitdiverg(37);
			} else {
				getFiltroVO().setCsitdiverg(0);
			}

			getFiltroVO().setCunicclicmbio(
					getClienteSelecaoVO().getCunicpssoacmbio());

			BradescoCommonServiceFactory
					.getObjectManager()
					.setRequestAttribute(
							"lista",
							tradeFinanceMonitService
									.obterCotacoesPendExportacao(getFiltroVO()));

			return "tradeFinCotacoesPendentesExportTemplate";

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.exportar <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: atualizar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 16/02/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String atualizar() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.atualizar <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (SiteUtil.isEmptyOrNull(viewHelper.getCtcSelecionado())) {
				NpcFacesUtils.addInfoModalMessage("Selecione um Registro.",
						false);
				return null;
			}

			tradeFinanceBean.setFluxoPgtVO(new FluxoPagamentoVO());
			vincularOperacaoLcBean
					.setVincularOperacaoLcVO(new VincularOperacaoLcVO());

			getTradeFinanceVO().setCotacaoFundingVO(
					new ListaCotacoesExternasVO());
			setUnidadeExternaVO(new UnidadeExternaVO());
			setBancoReembolsadorVO(new UnidadeExternaVO());
			setBancoAvisadorVO(new UnidadeExternaVO());
			getViewHelper().setDataValidadeCotacao(
					getCommonService().getDataLimiteCotacao(new Date()));

			vincularOperacaoLcBean.getViewHelper().setRenderModal(false);
			tradeFinanceListaVO = lista.get(SiteUtil.getInt(viewHelper
					.getCtcSelecionado()));

			tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO,
					ConstantesTradeFinance.FUNC_CONSULTAR_PENDENTES);

			iniciarAtualizar();

			return carregarTelaPorSituacao(false);

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.atualizar <<<<<<<<<<<");
		}
	}

	private void iniciarAtualizar() {

		tradeFinanceVO = tradeFinanceBean.getTradeFinanceVO();
		setLimiteCtc(getCommonService().getDataLimiteCotacao(new Date()));
		atualizarComissaoExterna();

		if (!tradeFinanceVO.getProduto().equals(EnumProduto.FINIMP_ECA)
				&& !tradeFinanceVO.getProduto().equals(
						EnumProduto.LC_IMPORTACAO)) {
			
			//banco correspondente
			getUnidadeExternaVO().setBancocorr(tradeFinanceVO.getDbcoextcmbio());
			getUnidadeExternaVO().setCbancoocrr(SiteUtil.getLong(tradeFinanceVO.getCbanqrcmbiofndng()));
			
			getBancoReembolsadorVO().setCbancodesemb(SiteUtil.getLong(tradeFinanceVO.getCbanqrcmbiorcdor()));

			// banco reembolsador
			getBancoReembolsadorVO().setBancodesemb(tradeFinanceVO.getDbcoextcmbio());
			getBancoReembolsadorVO().setCbancoocrr(SiteUtil.getLong(tradeFinanceVO.getCbanqrcmbiofndng()));			
		}

		custoExternoVO.setIorgextercmbio(getTradeFinanceVO().getIorgextercmbio());
		custoExternoVO.setNbletonegoccmbio(getTradeFinanceVO().getNbletonegoccmbio());
		custoExternoVO.setCsitbletocmbio(getTradeFinanceVO().getCsitbletocmbio());
		custoExternoVO.setDlimfndngcmbio(getTradeFinanceVO().getDlimfndngcmbio());
		custoExternoVO.setCbanqrcmbiofndng(getTradeFinanceVO().getCbanqrcmbiofndng());
		custoExternoVO.setCbanqrcmbiorcdor(getTradeFinanceVO().getCbanqrcmbiorcdor());
		custoExternoVO.setPtxfixacmbio("");
		custoExternoVO.setCindcdeconmmoeda(getTradeFinanceVO().getCindcdeconmlibor());
		custoExternoVO.setTmesliborcmbio(getTradeFinanceVO().getTmesliborcmbio());
		custoExternoVO.setVtxliborcmbio(SiteUtil.trocarPontoPorVirgula(getTradeFinanceVO().getVtxliborcmbio()));
		custoExternoVO.setVlrcomisdsemb(getTradeFinanceVO().getVlrcomisdsemb());
		custoExternoVO.setObservacao("");

		if (tradeFinanceVO.getProduto().equals(EnumProduto.FINIMP_ECA)
				|| tradeFinanceVO.getProduto()
						.equals(EnumProduto.LC_IMPORTACAO)) {
			tradeFinanceVO.getCotacaoFundingVO().setPtxfixacmbio(
					getTradeFinanceVO().getPtxfixacmbio());
			tradeFinanceVO.getCotacaoFundingVO().setCindcdeconmmoelib(
					getTradeFinanceVO().getCindcdeconmlibor());
			tradeFinanceVO.getCotacaoFundingVO().setTmesliborcmbio(
					getTradeFinanceVO().getTmesliborcmbio());
			tradeFinanceVO.getCotacaoFundingVO().setVtxliborcmbio(
					getTradeFinanceVO().getVtxliborcmbio());
		}
		if (tradeFinanceListaVO.getProduto().isGarantia()) {
			getUnidadeExternaVO().setBancocorr(null);
		}
		//Se Libor > 0, desabilita o taxa fixa
		if(SiteUtil.isValueZero(this.getCustoExternoVO().getVtxliborcmbio()))
			getViewHelper().setDisabledTaxaFixa(false);
		else
			getViewHelper().setDisabledTaxaFixa(true);
		getViewHelper().setDisabledLibor(false);
		
		if (fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(getTradeFinanceBean().getTradeFinanceVO().getVtravaliborcmbio())) {
			getViewHelper().setDisabledLiborMeses(true);
		} else {
			getViewHelper().setDisabledLiborMeses(false);
		}
		
		getViewHelper().setComboPeriodoDaTaxa(selectItemBean.getPeriodoDaTaxa(tradeFinanceVO.getCprodtservc()));

	}

	/**
	 * 
	 * Nome: atualizarDivergente
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 16/02/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String atualizarDivergente() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.atualizarDivergente <<<<<<<<<<<");

			// Após carregar a tela de Pendencia Divergente, deve ser carregada
			// a tela de Pendente Custo Externo
			return carregarTelaPorSituacao(true);

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.atualizarDivergente <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: carregarTelaPorSituacao
	 * 
	 * Propósito: Retorna a tela a ser exibida por situação
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 16/02/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private String carregarTelaPorSituacao(Boolean atualizarDivergente) {
		// PENDENCIA 'COTAR CUSTO EXTERNO'
		if (tradeFinanceListaVO.getCsitbletocmbio().equals(
				EnumPendencia.CUSTO_EXTERNO.getCodigo())
				|| tradeFinanceListaVO.getCsitbletocmbio().equals(
						EnumPendencia.RECOTAR_CUSTO_EXTERNO.getCodigo())
				|| atualizarDivergente) {

			getViewHelper().setIsUnidadeExt(Boolean.FALSE);
			getViewHelper().setTelaCtcPend(
					SITUACAO_BLETO_DEVOLVER_CUSTO_UNID_EXT);

			// FINIMP DIRETO (1644)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FINIMP_DIRETO)) {

				return "finimpDiretoPendCustoExt";
			}

			// REFINIMP DIRETO (1646)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_REFINIMP_DIRETO)) {

				return "refinimpDiretoPendCustoExt";
			}

			// FINIMP INDIRETO (2692)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FINIMP_INDIRETO)) {

				return "finimpIndiretoPendCustoExt";
			}

			// REFINIMP INDIRETO (1717)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {

				return "refinimpIndiretoPendCustoExt";
			}

			// LEI 4131 (2010)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_LEI_4131)) {

				return "lei4131PendCustoExt";
			}

			// PPE (1642)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_P_P_E)) {

				return "cotacaoPPEPendCustoExt";
			}

			// WORKING CAPITAL (2011)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_WORKING_CAPITAL)) {

				return "workingCapitalPendCustoExt";
			}

			// FORFAITING (644)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FORFAITING)) {

				return "forfaitingPendCustoExt";
			}

			// FINIMP ECA (1715)
			if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {

				carregarCotacoesDespesas();

				return "finimpEcaPendCustoExt";
			}

			// LC IMPORTAÇÃO (2018)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.LC_IMPORTACAO)) {

				carregarCotacoesDespesas();

				return "lcImportacaoPendCustoExt";
			}

			// GARANTIA INTERNACIONAL EXPEDIDA (1769) | (3933)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA)
					|| (tradeFinanceListaVO.getProduto()
							.equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO))) {

				carregarCotacoesDespesasGarantia();

				return "garantiaIntExpPendCustoExt";
			}
		}

		// PENDENCIA - UNIDADE EXTERNA
		if (tradeFinanceListaVO.getCsitbletocmbio().equals(
				EnumPendencia.UNID_EXT.getCodigo())) {

			getViewHelper().setIsUnidadeExt(Boolean.TRUE);
			getViewHelper().setTelaCtcPend(
					SITUACAO_BLETO_DEVOLVER_CUSTO_UNID_EXT);

			// FINIMP DIRETO (1644)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FINIMP_DIRETO)) {

				return "finimpDiretoPendUnidadeExt";
			}

			// REFINIMP DIRETO (1646)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_REFINIMP_DIRETO)) {

				return "refinimpDiretoPendUnidadeExt";
			}

			// FINIMP INDIRETO (2692)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FINIMP_INDIRETO)) {

				return "finimpIndiretoPendUnidadeExt";
			}

			// REFINIMP INDIRETO (1717)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {

				return "refinimpIndiretoPendUnidadeExt";
			}

			// LEI 4131 (2010)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_LEI_4131)) {

				return "lei4131PendUnidadeExt";
			}

			// PPE (1642)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_P_P_E)) {

				return "cotacaoPPEPendUnidadeExt";
			}

			// WORKING CAPITAL (2011)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_WORKING_CAPITAL)) {

				return "workingCapitalPendUnidadeExt";
			}

			// FORFAITING (644)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FORFAITING)) {

				return "forfaitingPendUnidadeExt";
			}
		}

		// PENDENCIA - COTACOES DIVERGENTES
		if (tradeFinanceListaVO.getCsitbletocmbio().equals(
				EnumPendencia.DIVERGENTE.getCodigo())) {

			listaDePara = tradeFinanceMonitService
					.obterCotacoesDiverg(tradeFinanceListaVO);
			getViewHelper().setTelaCtcPend(SITUACAO_BLETO_DEVOLVER_DIVERGENCIA);

			// FINIMP DIRETO (1644)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FINIMP_DIRETO)) {

				return "finimpDiretoPendDivergencia";
			}

			// REFINIMP DIRETO (1646)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_REFINIMP_DIRETO)) {

				return "refinimpDiretoPendDivergencia";
			}

			// FINIMP INDIRETO (2692)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FINIMP_INDIRETO)) {

				return "finimpIndiretoPendDivergencia";

			}

			// REFINIMP INDIRETO (1717)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {

				return "refinimpIndiretoPendDivergencia";
			}

			// LEI 4131 (2010)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_LEI_4131)) {

				return "lei4131PendDivergencia";
			}

			// PPE (1642)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_P_P_E)) {

				return "cotacaoPPEPendDivergencia";
			}
			// WORKING CAPITAL (2011)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_WORKING_CAPITAL)) {

				return "workingCapitalPendDivergencia";
			}

			// FORFAITING (644)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FORFAITING)) {

				return "forfaitingPendDivergencia";
			}

			// FINIMP ECA (1715)
			if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {

				return "finimpEcaPendDivergencia";
			}

			// GARANTIA ITERNACIONAL EXPEDIDA (1769 | 3933)
			if (tradeFinanceListaVO.getProduto().isGarantia()) {

				return "garantiaIntExpPendDivergencia";
			}

			// LC IMPORTACAO (2018)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.LC_IMPORTACAO)) {
				return "lcImportacaoPendDivergencia";
			}
		}

		return null;
	}

	private void carregarCotacoesDespesas() {

		CotacoesExternasVO cotacoesExternasVO;

		// Houve uma alteração no book de entrada do NPCCWYDE e NPCCWYAE, com a
		// inserção do campo cindcdaprovbanq
		// onde quando for 1 é referente a tela do aprovar banqueiro e fora
		// dessa tela informa o código 2.
		cotacoesExternasVO = tradeFinanceMonitService.obterCotacoesExternas(
				tradeFinanceVO.getNbletonegoccmbio(), getTradeFinanceVO()
						.getHinclreghist(), Numeros.DOIS);

		tradeFinanceVO.setListaCotacoes(cotacoesExternasVO.getListaCotacoes());

		tradeFinanceVO.setCusuariosess(cotacoesExternasVO.getCusuariosess());
		tradeFinanceVO.setNusuariosess(cotacoesExternasVO.getNusuariosess());

		if (cotacoesExternasVO.getListaCotacoes() != null
				&& cotacoesExternasVO.getListaCotacoes().size() > 0) {

			// tem que ser setado todas as despesas se nao, nao vai mandar no
			// salvar
			if (cotacoesExternasVO.getListaCotacoes() != null
					&& cotacoesExternasVO.getListaCotacoes().size() > 0) {

				Boolean primeiroApresentar = Boolean.TRUE;
				for (ListaCotacoesExternasVO listaCotacoesExternasVO : cotacoesExternasVO
						.getListaCotacoes()) {

					List<ListaDespesasVO> despesaList = tradeFinanceMonitService
							.obterDespesas(listaCotacoesExternasVO.getCfndng(),
									getTradeFinanceVO().getNbletonegoccmbio(),
									getTradeFinanceVO().getHinclreghist());
					listaCotacoesExternasVO.setListaDespesas(despesaList);

					// O primeiro a apresentar na tela
					if (primeiroApresentar) {
						getTradeFinanceVO().setListaDespesas(despesaList);
						primeiroApresentar = Boolean.FALSE;
					}

				}
			}

		}
	}

	/**
	 * 
	 * Nome: carregarCotacoesDespesasGarantia
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private void carregarCotacoesDespesasGarantia() {
		ResponsavelDespesaVO responsavelDespesaVO = new ResponsavelDespesaVO();

		// Houve uma alteração no book de entrada do NPCCWYDE e NPCCWYAE, com a
		// inserção do campo cindcdaprovbanq
		// onde quando for 1 é referente a tela do aprovar banqueiro e fora
		// dessa tela informa o código 2.
		responsavelDespesaVO = tradeFinanceMonitService
				.obterResponsavelDespesas(
						tradeFinanceListaVO.getNbletonegoccmbio(),
						getTradeFinanceVO().getHinclreghist(), Numeros.DOIS);

		getTradeFinanceVO().getDespesaVO().setCidtfdrespdesp(
				tradeFinanceBean.getTradeFinanceVO().getCidtfdrespdesp());

		if (responsavelDespesaVO.getListaDespesa() != null
				&& responsavelDespesaVO.getListaDespesa().size() > 0) {

			// tem que ser setado todas as despesas se nao, nao vai mandar no
			// salvar
			if (responsavelDespesaVO.getListaDespesa() != null
					&& responsavelDespesaVO.getListaDespesa().size() > 0) {

				Boolean primeiroApresentar = Boolean.TRUE;
				for (ListaResponsavelDespesaVO despesaVO : responsavelDespesaVO
						.getListaDespesa()) {

// IN2833579 - ERRO GARANTIA INTERNACIONAL(STANDBY) ERRO CONFIRMAR DA TELA DE FECHAMENTO
					List<ListaDespesasVO> despesaList = null;
					try {
						despesaList = tradeFinanceMonitService
							.obterDespesas(despesaVO.getCfndng(),
									getTradeFinanceVO().getNbletonegoccmbio(),
									getTradeFinanceVO().getHinclreghist());
					} catch (Exception e) {
						despesaList = new ArrayList<ListaDespesasVO>();
					}
// IN2833579 - ERRO GARANTIA INTERNACIONAL(STANDBY) ERRO CONFIRMAR DA TELA DE FECHAMENTO

					despesaVO.setListaDespesas(despesaList);

					// O primeiro a apresentar na tela
					if (primeiroApresentar) {
						getTradeFinanceVO().setListaDespesas(despesaList);
						primeiroApresentar = Boolean.FALSE;
					}

				}
			}

		}
		getTradeFinanceVO().setListaDespesaGaran(
				responsavelDespesaVO.getListaDespesa());

	}

	/**
	 * Nome: validarForm
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 16/05/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void validarForm(AjaxBehaviorEvent ae) {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.validarForm <<<<<<<<<<<");

			// valida campos obrigatórios
			Boolean isValid = Boolean.TRUE;

			// se pendente custo externo
			Date dataCotacao = SiteUtil.toDay();

			String tpodata = null;

			if (getTradeFinanceListaVO().getCsitbletocmbio().equals(
					EnumPendencia.CUSTO_EXTERNO.getCodigo())) {
				tpodata = "2";
			} else {
				tpodata = "1";
			}

			// se pendente unidade externa
			if (tradeFinanceListaVO.getCsitbletocmbio().equals(
					EnumPendencia.UNID_EXT.getCodigo())) {
				dataCotacao = SiteUtil.dataMainframeToWeb(getTradeFinanceVO()
						.getDcotacfndngcmbio().replace("/", "."));
			}

			if (!tradeFinanceVO.getProduto().equals(EnumProduto.FINIMP_ECA)
					&& !tradeFinanceVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)
					&& !tradeFinanceVO.getProduto().isGarantia()) {

				if (limiteCtc == null) {

					NpcFacesUtils.addInfoModalMessage(
							"O campo Limite Cotação é obrigatório.", false);
					isValid = Boolean.FALSE;

				} else if (SiteUtil.comparaDatas(dataCotacao, limiteCtc) > 0
						|| !getCommonService().validarDiaUtil(getLimiteCtc(),
								Numeros.ZERO, tpodata, 0, 0, 0)) {

					NpcFacesUtils.addInfoModalMessage(
							"Data Limite Cotação inválida.", false);
					isValid = Boolean.FALSE;
				}

				if (SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getBancocorr()) || 
					SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getCbancoocrr())) {
					NpcFacesUtils.addInfoModalMessage("O campo Unidade Externa/Banco Correspondente é obrigatório.", false);
					isValid = Boolean.FALSE;
				}

				// 'Unidade Banco Reembolsador/Desembolsador' obrigatório apenas
				// para Pendente Unidade Externa
//				if (tradeFinanceListaVO.getCsitbletocmbio().equals(EnumPendencia.UNID_EXT.getCodigo()) && 
				if (SiteUtil.isEmptyOrNull(getBancoReembolsadorVO().getBancodesemb()) ||
				    SiteUtil.isEmptyOrNull(getBancoReembolsadorVO().getCbancoocrr())) {
					NpcFacesUtils.addInfoModalMessage("O campo Unidade Banco Reembolsador/Desembolsador é obrigatório.", false);
					isValid = Boolean.FALSE;
				}

			}

			if (!tradeFinanceVO.getProduto().equals(EnumProduto.LC_IMPORTACAO) && !tradeFinanceVO.getProduto().isGarantia()) {
				if ((fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(getTradeFinanceBean().getTradeFinanceVO().getVtravaliborcmbio()) == false || 
						SiteUtil.isEmptyOrNull(getTradeFinanceBean().getTradeFinanceVO().getVtravaliborcmbio())) && 
						(SiteUtil.isEmptyOrNull(getCustoExternoVO().getTmesliborcmbio()) || getCustoExternoVO().getTmesliborcmbio().equals("0")) &&
						(fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(getCustoExternoVO().getPtxfixacmbio()) == false || 
						SiteUtil.isEmptyOrNull(getCustoExternoVO().getPtxfixacmbio()))) {
					NpcFacesUtils.addInfoModalMessage("Informe o campo Taxa Fixa ou o campo Libor Travada ou Libor Mês.", false);
					isValid = Boolean.FALSE;
				} else if (!SiteUtil.isEmptyOrNull(getCustoExternoVO().getPtxfixacmbio()) && 
						!SiteUtil.isEmptyOrNull(getCustoExternoVO().getVtxliborcmbio())) {
					NpcFacesUtils.addInfoModalMessage("Informe o campo Taxa Fixa ou o campo Libor.", false);
					isValid = Boolean.FALSE;
				} else if (SiteUtil.isEmptyOrNull(getCustoExternoVO().getPtxfixacmbio()) && 
						   SiteUtil.isEmptyOrNull(getCustoExternoVO().getVtxliborcmbio())) {
					NpcFacesUtils.addInfoModalMessage("O campo Taxa Fixa ou o campo Libor é obrigatório.", false);
					isValid = Boolean.FALSE;
				}

				if (!SiteUtil.isValueZero(getCustoExternoVO().getVtxliborcmbio())) {
					/*
					 * if (getCustoExternoVO().getTmesliborcmbio() <=
					 * Numeros.NUM0) { NpcFacesUtils.addInfoModalMessage(
					 * "O campo prazo da Libor é obrigatório.", false); isValid
					 * = Boolean.FALSE; }
					 */

					if (getCustoExternoVO().getCindcdeconmmoeda() == Numeros.ZERO) {
						NpcFacesUtils.addInfoModalMessage(
								"O campo moeda da Libor é obrigatório.", false);
						isValid = Boolean.FALSE;
					}
				}
			}

			/** FINIMP ECA - VALIDACAO DA TAXA FIXA OU TAXA LIBOR **/
			if (tradeFinanceVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
				if (SiteUtil.isEmptyOrNull(custoExternoVO.getIorgextercmbio())) {
					NpcFacesUtils.addInfoModalMessage(
							"Informe o campo Orgão Governamental.", false);
					isValid = Boolean.FALSE;
				}

			}

			/** GARANTIA INTERNACIONAL - VALIDACAO DATA VALIDADE DA COTACAO **/
			if (getTradeFinanceVO().getProduto().isGarantia()
					|| getTradeFinanceVO().getProduto().equals(
							EnumProduto.FINIMP_ECA)) {

				if (getViewHelper().getDataValidadeCotacao() == null
						|| SiteUtil.comparaDatas(dataCotacao, getViewHelper()
								.getDataValidadeCotacao()) > 0
						|| !getCommonService().validarDiaUtil(
								getViewHelper().getDataValidadeCotacao(),
								Numeros.ZERO, tpodata, 0, 0, 0)) {

					NpcFacesUtils.addInfoModalMessage(
							"Data Validade da Cotação inválida.", false);
					isValid = Boolean.FALSE;
				} else {
					custoExternoVO.setDlimfndngcmbio(SiteUtil
							.dataWebToMainframe(getViewHelper()
									.getDataValidadeCotacao()));
				}
			}
			
			if (getTradeFinanceVO().getProduto().isGarantia() || getTradeFinanceVO().getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA) 
					|| getTradeFinanceVO().getProduto().isGarantia() || getTradeFinanceVO().getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO)) {
				
				Boolean isReembolsador = Boolean.FALSE;
				Boolean isConfirmador = Boolean.FALSE;
				
				// Valida Campos de Despesa
				for (int i = 0; i < tradeFinanceVO.getListaDespesaGaran().size(); i++) {
					if (tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Reembolsador")) {
						isReembolsador = Boolean.TRUE;
					}
// IN2833579 - ERRO GARANTIA INTERNACIONAL(STANDBY) ERRO CONFIRMAR DA TELA DE FECHAMENTO
					if (tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Emissor")) {
						isReembolsador = Boolean.TRUE;
					}
// IN2833579 - ERRO GARANTIA INTERNACIONAL(STANDBY) ERRO CONFIRMAR DA TELA DE FECHAMENTO
					if (tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Confirmador")) {
						isConfirmador = Boolean.TRUE;
					}
				}
				
				if (isReembolsador && isConfirmador == Boolean.TRUE )
					isValid = Boolean.TRUE;
				else {
					NpcFacesUtils.addInfoModalMessage("Banco Reembolsador e Confirmador são obrigatórios.", false);
					return;
				}	
				
			}
			if (getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)){
				if (tradeFinanceVO.getListaCotacoes().isEmpty()){
					NpcFacesUtils.addInfoModalMessage("Banco Reembolsador e Correspondente são obrigatórios.", false);
					return;
				}else if (SiteUtil.isEmptyOrNull(tradeFinanceVO.getListaCotacoes().get(0).getNbanqrcmbiofndng()) || 
						SiteUtil.isEmptyOrNull(tradeFinanceVO.getListaCotacoes().get(0).getNbanqrcmbiorcdor()) ){
					NpcFacesUtils.addInfoModalMessage("Banco Reembolsador e Correspondente são obrigatórios.", false);
					return;
		   	    }
			}

			if (tradeFinanceVO.getListaCotacoes() != null) {
				for (ListaCotacoesExternasVO cotacao : tradeFinanceVO
						.getListaCotacoes()) {
					try {
						if (SiteUtil.stringToDate(cotacao.getDlimfndngcmbio(),
								"dd/MM/yyyy") == null
								|| (SiteUtil.stringToDate(
										cotacao.getDlimfndngcmbio(),
										"dd/MM/yyyy") != null && !validarDataDiaUtil(SiteUtil
										.stringToDate(
												cotacao.getDlimfndngcmbio(),
												"dd/MM/yyyy")))) {
							NpcFacesUtils
									.addInfoModalMessage(
											"Cotação de Banqueiro com validade vencida! Favor alterar.",
											false);
							isValid = Boolean.FALSE;
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}

			if (isValid) {
				viewHelper.setRenderModal(Boolean.TRUE);
			}

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.validarForm <<<<<<<<<<<");
		}

	}

	/**
	 * Nome: validarlimitecotação
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 29/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void validarLimiteCotacao(AjaxBehaviorEvent ae) {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.validarForm <<<<<<<<<<<");

			String tpodata = null;

			if (getTradeFinanceListaVO().getCsitbletocmbio().equals(
					EnumPendencia.CUSTO_EXTERNO.getCodigo())) {
				tpodata = "2";
			} else {
				tpodata = "1";
			}

			if (getLimiteCtc() != null
					&& !getCommonService().validarDiaUtil(getLimiteCtc(),
							Numeros.ZERO, tpodata, 0, 0, 0)) {
				NpcFacesUtils.addInfoModalMessage(
						"Data Limite Cotação inválida.", false);
			}

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.validarForm <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: confirmar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 * 
	 *
	 *      Registro de Manutenção: 16/02/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void actionConfirmar() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.actionConfirmar <<<<<<<<<<<");

			// FINIMP ECA (1715)
			// LC IMPORTACAO (2018)
			if (tradeFinanceVO.getProduto().equals(EnumProduto.FINIMP_ECA)
					|| tradeFinanceVO.getProduto().equals(
							EnumProduto.LC_IMPORTACAO)
					|| tradeFinanceVO.getProduto().isGarantia()) {

				String result = SiteUtil.STRING_EMPTY;
				getViewHelper().setRenderModal(false);

				if (tradeFinanceVO.getProduto().isGarantia()) {
					getTradeFinanceVO().setListaCotacoes(
							converteListaCotacoesExternas());
				}

				numerarCotacoesDespesas();

				custoExternoVO.setCbanqrcmbiofndng(Numeros.UM_L);

				if (tradeFinanceVO.getProduto().equals(
						EnumProduto.LC_IMPORTACAO)
						|| tradeFinanceVO.getProduto().isGarantia()) {

					result = tradeFinanceMonitService.alterarCustoExterno("S",
							custoExternoVO);

				} else if (tradeFinanceVO.getProduto().equals(
						EnumProduto.FINIMP_ECA)) {
					result = tradeFinanceMonitService.alterarCustoExterno("E",
							custoExternoVO);

				} else {
					result = tradeFinanceMonitService.alterarCustoExterno("N",
							custoExternoVO);
				}

				if (tradeFinanceVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
					alterarFluxoPagtoComissaoExterna();
				}

				// Derick - se nao houver valor tem que ser chamado o fluxo
				// abaixo para ser apagado no mainframe - pedido Sergio e Tesser
				if (tradeFinanceBean.getTradeFinanceVO().getListaCotacoes() == null
						|| tradeFinanceBean.getTradeFinanceVO()
								.getListaCotacoes().size() == 0) {
					tradeFinanceBean.getTradeFinanceVO().getListaCotacoes()
							.add(new ListaCotacoesExternasVO());
				}

				for (int i = 0; i < tradeFinanceBean.getTradeFinanceVO()
						.getListaCotacoes().size(); i++) {

					getTradeFinanceVO()
							.getListaCotacoes()
							.get(i)
							.setPtxfixacmbio(
									getCustoExternoVO().getPtxfixacmbio());
					getTradeFinanceVO()
							.getListaCotacoes()
							.get(i)
							.setCindcdeconmmoelib(
									getCustoExternoVO().getCindcdeconmmoeda());
					getTradeFinanceVO()
							.getListaCotacoes()
							.get(i)
							.setTmesliborcmbio(
									getCustoExternoVO().getTmesliborcmbio());
					getTradeFinanceVO()
							.getListaCotacoes()
							.get(i)
							.setVtxliborcmbio(
									getCustoExternoVO().getVtxliborcmbio());
					getTradeFinanceVO()
							.getListaCotacoes()
							.get(i)
							.setDcotacfndngcmbio(
									SiteUtil.dateToString(new Date(),
											"dd/MM/yyyy"));

					// if(SiteUtil.isEmptyOrNull(getTradeFinanceVO().getListaCotacoes().get(i).getCbanqrcmbiofndng()))
					// {
					// getTradeFinanceVO().getListaCotacoes().get(i).setCbanqrcmbiofndng(tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getCbanqrcmbio());
					// getTradeFinanceVO().getListaCotacoes().get(i).setDcotacfndngcmbio(SiteUtil.dateToString(new
					// Date(), "dd/MM/yyyy"));
					//
					// }
					
					getTradeFinanceVO().getListaCotacoes().get(i).setCusuarmanut(SiteUtil.recuperarUsuarioLogado());
					tradeFinanceNegociacaoService.incluirAlterarDespesasFundingLC(tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio(),
									custoExternoVO.getShmanutreg(), tradeFinanceBean.getTradeFinanceVO().getListaCotacoes().get(i), "A");

				}

				// Para alteração do LC, pergunta se deseja alterar a operação
				// vinculada
				if (getTradeFinanceVO().getProduto().equals(
						EnumProduto.LC_IMPORTACAO)) {

					openModalConfirmarLC(result);

				} else {

					setIniciarPagina(false);
					BradescoFacesUtils.addInfoModalMessage(result,
							"#{tradeFinMonitCtcPendBean.retomarPesquisa}",
							BradescoViewExceptionActionType.ACTION, "submit",
							false);
				}
			} else {

				String result = SiteUtil.STRING_EMPTY;
				getViewHelper().setRenderModal(false);

				custoExternoVO.setNbletonegoccmbio(tradeFinanceBean
						.getTradeFinanceVO().getNbletonegoccmbio());
				custoExternoVO.setCsitbletocmbio(tradeFinanceBean
						.getTradeFinanceVO().getCsitbletocmbio());
				custoExternoVO.setDlimfndngcmbio(SiteUtil
						.dataWebToMainframe(limiteCtc));
				custoExternoVO.setCbanqrcmbiofndng(getUnidadeExternaVO()
						.getCbancoocrr());
				custoExternoVO.setCbanqrcmbiorcdor(getBancoReembolsadorVO()
						.getCbancoocrr());
				custoExternoVO.setVlrcomisdsemb(getCustoExternoVO()
						.getVlrcomisdsemb());
				custoExternoVO.setTdiaopercmbio(tradeFinanceBean
						.getTradeFinanceVO().getTdiaopercmbio());
				custoExternoVO.setVnegocmoedaestrg(tradeFinanceBean
						.getTradeFinanceVO().getVnegocmoedaestrg());
				custoExternoVO.setCprodtservc(tradeFinanceBean
						.getTradeFinanceVO().getCprodtservc());

				if (tradeFinanceVO.getProduto().isGarantia()) {
					result = tradeFinanceMonitService.alterarCustoExterno("S",
							custoExternoVO);
				} else {
					result = tradeFinanceMonitService.alterarCustoExterno("N",
							custoExternoVO);
				}

				alterarFluxoPagtoComissaoExterna();

				setIniciarPagina(false);

				BradescoFacesUtils
						.addInfoModalMessage(result,
								"#{tradeFinMonitCtcPendBean.retomarPesquisa}",
								BradescoViewExceptionActionType.ACTION,
								"submit", false);
			}
			
			//Chamada do serviço de aprovação de banqueiro.
			if (getTradeFinanceVO().getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA) || 
				getTradeFinanceVO().getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO) ||
				getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) ){
				
				tradeFinanceMonitService.aprovarBanqueiro(9999999999L, tradeFinanceVO.getNbletonegoccmbio());
			}
			
			if (temFluxoPagamento() == true) {
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
				alterarListaFluxoPagtoPrincJurosCtcPend();
			}
		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.actionConfirmar <<<<<<<<<<<");
		}
	}

	/**
	 * 
	 * Nome: openModalConfirmarLC
	 * 
	 * Propósito: Abre modal de confirmação do LC Importação e pergunda se
	 * deseja alterar a operação vinculada
	 *
	 * @param : <BR/>
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void openModalConfirmarLC(String message) {

		tradeFinanceBean.setVincularOperacaoLcVO(new VincularOperacaoLcVO());
		tradeFinanceBean.getVincularOperacaoLcVO().setNbletonegoccmbio(
				tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());
		tradeFinanceBean.getVincularOperacaoLcVO().setCsitbletocmbio(
				Numeros.QUATRO);
		tradeFinanceBean.getVincularOperacaoLcVO().setCprodtservc(
				tradeFinanceBean.getTradeFinanceVO().getCprodtservc());

		// Executa fluxo NPCCIXX para validar a situação da operação vinculada
		VincularOperacaoLcVO operVinculada = tradeFinanceNegociacaoService
				.validStatusVinculoLc(tradeFinanceBean
						.getVincularOperacaoLcVO());
		tradeFinanceBean.getVincularOperacaoLcVO().setCsitequal(
				operVinculada.getCsitequal());
		tradeFinanceBean.getVincularOperacaoLcVO().setNbletovncloimpor(
				operVinculada.getNbletovncloimpor());
		tradeFinanceBean.getVincularOperacaoLcVO().setCprodtservc(
				operVinculada.getCprodtservc());
		tradeFinanceBean.getVincularOperacaoLcVO().setHinclreghist(
				operVinculada.getHinclreghist());
		tradeFinanceBean.getVincularOperacaoLcVO().setCsitbletocmbio(
				operVinculada.getCsitbletocmbio());
		tradeFinanceBean.getVincularOperacaoLcVO().setCsitbletoaprov(
				operVinculada.getCsitbletoaprov());
		tradeFinanceBean.getVincularOperacaoLcVO().setCmodcontrcmbio(
				operVinculada.getCmodcontrcmbio());
		tradeFinanceBean.getVincularOperacaoLcVO().setOrigemAlteracao(true);

		if (tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.DOIS) {

			setIniciarPagina(false);
			BradescoFacesUtils.addInfoModalMessage(message,
					"#{tradeFinMonitCtcPendBean.retomarPesquisa}",
					BradescoViewExceptionActionType.ACTION, "submit", false);
		}

		else {

			if (tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.UM) {
				vincularOperacaoLcBean.getViewHelper().setPerguntaOperacao(
						"Deseja atualizar a operação vinculada?");
			} else {
				vincularOperacaoLcBean.getViewHelper().setPerguntaOperacao(
						"Deseja incluir uma operação vinculada?");
			}

			vincularOperacaoLcBean.setVincularOperacaoLcVO(tradeFinanceBean
					.getVincularOperacaoLcVO());
			vincularOperacaoLcBean.getVincularOperacaoLcVO()
					.setOrigemAlteracao(true);
			vincularOperacaoLcBean.getViewHelper().setMesagemConfirmacao(
					message);
			vincularOperacaoLcBean.openModal(null);
		}
	}

	public void confirmarVincularOperacaoLC() {

		String redirectTo = null;

		// Alterar vinculada
		if (tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.UM) {

			TradeFinanceListaVO dadosAlterar = new TradeFinanceListaVO();
			dadosAlterar.setNbletonegoccmbio(tradeFinanceBean
					.getVincularOperacaoLcVO().getNbletovncloimpor());
			dadosAlterar.setCprodtservc(tradeFinanceBean
					.getVincularOperacaoLcVO().getCprodtservc());
			dadosAlterar.setCsitbletocmbio(tradeFinanceBean
					.getVincularOperacaoLcVO().getCsitbletocmbio());
			dadosAlterar.setCsitbletoaprov(tradeFinanceBean
					.getVincularOperacaoLcVO().getCsitbletoaprov());
			dadosAlterar.setCmodcontrcmbio(tradeFinanceBean
					.getVincularOperacaoLcVO().getCmodcontrcmbio());

			tradeFinanceBean.obterDadosBasicos(dadosAlterar,
					ConstantesTradeFinance.FUNC_CONSULTAR_PENDENTES);

			iniciarAtualizar();

			getViewHelper().setIsUnidadeExt(Boolean.FALSE);
			getViewHelper().setTelaCtcPend(
					SITUACAO_BLETO_DEVOLVER_CUSTO_UNID_EXT);

			// FINIMP DIRETO (1644)
			if (dadosAlterar.getProduto().equals(
					EnumProduto.PRODUTO_FINIMP_DIRETO)) {
				redirectTo = "finimpDireto/finimpDiretoPendCustoExt.xhtml";
			}
			// FINIMP INDIRETO (2692)
			else if (dadosAlterar.getProduto().equals(
					EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
				redirectTo = "finimpIndireto/finimpIndiretoPendCustoExt.xhtml";
			}
			// FINIMP ECA (1715)
			if (dadosAlterar.getProduto().equals(EnumProduto.FINIMP_ECA)) {
				redirectTo = "finimpEca/finimpEcaPendCustoExt.xhtml";
			}

			vincularOperacaoLcBean.closeModal();
		}

		// Incluir vinculada
		else if (tradeFinanceBean.getVincularOperacaoLcVO().getCsitequal() == Numeros.TRES) {

			if (SiteUtil.getInt(tradeFinanceBean.getVincularOperacaoLcVO()
					.getCprodtservc()) == Numeros.ZERO) {
				NpcFacesUtils.addInfoModalMessage("Selecione um produto",
						EnumButtonBehavior.CLOSE);
				return;
			}

			// salva dados da cotação LC
			SiteUtil.copyPropertiesObjects(getClienteSelecaoVO(),
					tradeFinanceBean.getVincularOperacaoLcVO()
							.getClienteSelecaoVO());

			// FINIMP DIRETO (1644)
			if (tradeFinanceBean.getVincularOperacaoLcVO().getProduto()
					.equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
				redirectTo = "finimpDireto/finimpDiretoIncl.xhtml";
			}
			// FINIMP INDIRETO (2692)
			else if (tradeFinanceBean.getVincularOperacaoLcVO().getProduto()
					.equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
				redirectTo = "finimpIndireto/finimpIndiretoIncl.xhtml";
			}
			// FINIMP ECA (1715)
			if (tradeFinanceBean.getVincularOperacaoLcVO().getProduto()
					.equals(EnumProduto.FINIMP_ECA)) {
				redirectTo = "finimpEca/finimpEcaIncl.xhtml";
			}

			vincularOperacaoLcBean.closeModal();
		}

		BradescoFacesUtils
				.responseRedirect("/npcc_trade/content/comercializacao/precificacao/negociacao/"
						+ redirectTo);
	}

	public void actionFecharModalLc(ActionEvent ae) {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.actionFecharModalLc <<<<<<<<<<<");

			vincularOperacaoLcBean.closeModal();
			setIniciarPagina(false);

			BradescoFacesUtils.responseForward(retomarPesquisa());
		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.actionFecharModalLc <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: devolver
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void devolver(AjaxBehaviorEvent e) {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.devolver <<<<<<<<<<<");

			devolverModalBean.getDevolucaoVO().setNbletonegoccmbio(
					tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());
			devolverModalBean.getDevolucaoVO().setNseqcontrlim(
					tradeFinanceBean.getTradeFinanceVO().getNseqcontrlim());
			devolverModalBean.getDevolucaoVO().setNppstapontucmbio(
					tradeFinanceBean.getTradeFinanceVO().getNppstapontucmbio());
			devolverModalBean.getDevolucaoVO().setCsitbletoaprov(
					tradeFinanceBean.getTradeFinanceVO().getCsitbletoaprov());
			devolverModalBean.getDevolucaoVO().setCmotvobletocmbio(
					tradeFinanceBean.getTradeFinanceVO().getCmotvobletocmbio());
			devolverModalBean.getDevolucaoVO().setCsitbletocmbio(
					getViewHelper().getTelaCtcPend());
			devolverModalBean.getDevolucaoVO().setCtpoobsbleto(
					TIPO_OBS_OBSERVACAO);
			devolverModalBean.getDevolucaoVO().setRobsbletocmbio("");
			devolverModalBean.getViewHelper().setAcaoVoltar(
					"#{tradeFinMonitCtcPendBean.iniciar}");
			devolverModalBean.getViewHelper().setModalId(
					"formTradeFinMonitDet\\:modalDevolver");
			devolverModalBean.openModal();

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.devolver <<<<<<<<<<<");
		}

	}

	/**
	 * Nome: closeModalDevolver
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 01/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void closeModalDevolver() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.closeModalDevolver <<<<<<<<<<<");

			Boolean isConfirmar = devolverModalBean.getViewHelper()
					.getIsConfirmar();
			String message = devolverModalBean.getViewHelper()
					.getMessagemConfirmar();
			devolverModalBean.closeModal();

			if (isConfirmar) {

				setIniciarPagina(true);

				BradescoFacesUtils
						.addInfoModalMessage(message,
								"#{tradeFinMonitCtcPendBean.retomarPesquisa}",
								BradescoViewExceptionActionType.ACTION,
								"submit", false);
			}

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.closeModalDevolver <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: alterarFluxoPagtoComissaoExterna
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 27/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private void alterarFluxoPagtoComissaoExterna() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.alterarFluxoPagtoComissaoExterna <<<<<<<<<<<");

			Integer seqRegistro = Numeros.NUM1;

			if (getListaComissaoExt().size() > Numeros.ZERO) {
				for (Iterator<IComissaoExterna> iterator = getListaComissaoExt()
						.iterator(); iterator.hasNext();) {
					TrdFinNegComissaoVO itemListaComissaoExt = (TrdFinNegComissaoVO) iterator
							.next();

					itemListaComissaoExt.setNbletonegoccmbio(tradeFinanceBean
							.getTradeFinanceVO().getNbletonegoccmbio());
					itemListaComissaoExt.setHinclreg(custoExternoVO
							.getShmanutreg());

					itemListaComissaoExt.setVlxtotalcomis(itemListaComissaoExt
							.getVprevtcomiscmbio());

					itemListaComissaoExt.setNcomisextertrade(seqRegistro++);

					tradeFinanceNegociacaoService
							.alterarFluxoPagtoComissaoExterna(
									itemListaComissaoExt, tradeFinanceListaVO
											.getProduto().getCodigo());
				}
			} else {
				TrdFinNegComissaoVO itemComissaoExtVazio = new TrdFinNegComissaoVO();

				itemComissaoExtVazio.setNbletonegoccmbio(tradeFinanceBean
						.getTradeFinanceVO().getNbletonegoccmbio());
				itemComissaoExtVazio
						.setHinclreg(custoExternoVO.getShmanutreg());

				itemComissaoExtVazio.setNcomisextertrade(Numeros.NUM0);

				getTradeFinanceNegociacaoService()
						.alterarFluxoPagtoComissaoExterna(itemComissaoExtVazio,
								tradeFinanceListaVO.getProduto().getCodigo());
			}

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.alterarFluxoPagtoComissaoExterna <<<<<<<<<<<");
		}
	}

	/**
	 * 
	 * Nome: detalhar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String detalhar() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.detalhar <<<<<<<<<<<");

			// [ACESSO EXTERNO] Garante que não ira adotar o comportamento de
			// acesso externo
			getTradeFinanceBean().setExternalAccess(false);

			// PENDENCIA 'COTAR CUSTO EXTERNO'
			if (tradeFinanceListaVO.getCsitbletocmbio().equals(
					EnumPendencia.CUSTO_EXTERNO.getCodigo())) {

				getViewHelper().setIsUnidadeExt(Boolean.FALSE);

				// FINIMP DIRETO (1644)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FINIMP_DIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"finimpDiretoPendCustoExt");
					return "finimpDiretoCons";
				}

				// REFINIMP DIRETO (1646)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_REFINIMP_DIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"refinimpDiretoPendCustoExt");
					return "refinimpDiretoCons";
				}

				// FINIMP INDIRETO (2692)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FINIMP_INDIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"finimpIndiretoPendCustoExt");
					return "finimpIndiretoCons";
				}

				// REFINIMP INDIRETO (1717)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"refinimpIndiretoPendCustoExt");
					return "refinimpIndiretoCons";
				}

				// LEI 4131 (2010)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_LEI_4131)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"lei4131PendCustoExt");
					return "lei4131Cons";
				}

				// PPE (1642)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_P_P_E)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"cotacaoPPEPendCustoExt");
					return "cotacaoPPECons";
				}

				// WORKING CAPITAL (2011)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_WORKING_CAPITAL)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"workingCapitalPendCustoExt");
					return "workingCapitalCons";
				}

				// FORFAITING (644)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FORFAITING)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"forfaitingPendCustoExt");
					return "forfaitingCons";
				}

			}

			// PENDENCIA - UNIDADE EXTERNA
			if (tradeFinanceListaVO.getCsitbletocmbio().equals(
					EnumPendencia.UNID_EXT.getCodigo())) {

				limiteCtc = SiteUtil.dataMainframeToWeb(tradeFinanceVO
						.getDvalddnegoccmbio().replace("/", "."));
				getViewHelper().setIsUnidadeExt(Boolean.TRUE);

				// FINIMP DIRETO (1644)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FINIMP_DIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"finimpDiretoPendUnidadeExt");
					return "finimpDiretoCons";
				}

				// REFINIMP DIRETO (1646)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_REFINIMP_DIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"refinimpDiretoPendUnidadeExt");
					return "refinimpDiretoCons";
				}

				// FINIMP INDIRETO (2692)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FINIMP_INDIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"finimpIndiretoPendUnidadeExt");
					return "finimpIndiretoCons";
				}

				// REFINIMP INDIRETO (1717)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"refinimpIndiretoPendUnidadeExt");
					return "refinimpIndiretoCons";
				}

				// LEI 4131 (2010)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_LEI_4131)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"lei4131PendUnidadeExt");
					return "lei4131Cons";
				}

				// PPE (1642)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_P_P_E)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"cotacaoPPEPendUnidadeExt");
					return "cotacaoPPECons";
				}

				// WORKING CAPITAL (2011)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_WORKING_CAPITAL)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"workingCapitalPendUnidadeExt");
					return "workingCapitalCons";
				}

				// FORFAITING (644)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FORFAITING)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"forfaitingPendUnidadeExt");
					return "forfaitingCons";
				}

			}

			// PENDENCIA - DIVERGENTE
			if (tradeFinanceListaVO.getCsitbletocmbio().equals(
					EnumPendencia.DIVERGENTE.getCodigo())) {

				getViewHelper().setIsUnidadeExt(Boolean.FALSE);

				// FINIMP DIRETO (1644)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FINIMP_DIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"finimpDiretoPendDivergencia");
					return "finimpDiretoCons";
				}

				// REFINIMP DIRETO (1646)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_REFINIMP_DIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"refinimpDiretoPendDivergencia");
					return "refinimpDiretoCons";
				}

				// FINIMP INDIRETO (2692)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FINIMP_INDIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"finimpIndiretoPendDivergencia");
					return "finimpIndiretoCons";
				}

				// REFINIMP INDIRETO (1717)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"refinimpIndiretoPendDivergencia");
					return "refinimpIndiretoCons";
				}

				// LEI 4131 (2010)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_LEI_4131)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"lei4131PendDivergencia");
					return "lei4131Cons";
				}

				// PPE (1642)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_P_P_E)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"cotacaoPPEPendDivergencia");
					return "cotacaoPPECons";
				}

				// WORKING CAPITAL (2011)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_WORKING_CAPITAL)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"workingCapitalPendDivergencia");
					return "workingCapitalCons";
				}

				// FORFAITING (644)
				if (tradeFinanceListaVO.getProduto().equals(
						EnumProduto.PRODUTO_FORFAITING)) {

					tradeFinanceBean.getViewHelper().setPaginaOrigem(
							"forfaitingPendDivergencia");
					return "forfaitingCons";
				}

			}

			return null;

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.detalhar <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: getSelectItemRadioCtcPend
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 12/02/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<SelectItem> getSelectItemRadioCtcPend() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (int index = 0; index < getLista().size(); index++) {
			list.add(new SelectItem(index, ""));
		}
		return list;
	}

	/**
	 * Nome: atualizarComissaoExterna
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private void atualizarComissaoExterna() {

		List<ComissaoExternaVO> listaTemp = new ArrayList<ComissaoExternaVO>();
		TrdFinNegParcelaVO objTo = null;
		List<TrdFinNegParcelaVO> listaParcela = new ArrayList<TrdFinNegParcelaVO>();

		/* Comissão Externa */
		ComissaoCollection listaComissaoExternaTemp = new ComissaoCollection();

		for (Iterator<IComissaoExterna> it = tradeFinanceBean
				.getComissaoExtList().iterator(); it.hasNext();) {
			ComissaoExternaVO item = (ComissaoExternaVO) it.next();
			TrdFinNegComissaoVO itemComissaoExterna = new TrdFinNegComissaoVO();

			itemComissaoExterna.setCcondceconc(item.getccondceconc());
			itemComissaoExterna.setCperdcjurocmbio(item.getcperdcjurocmbio());
			itemComissaoExterna.setCindcdeconmmoeda(item.getcindcdeconmmoeda());
			itemComissaoExterna.setCfluxoperdccmbio(item.getcfluxoperdccmbio());
			itemComissaoExterna.setTipoComissaoExt(item.geticondeconc());
			itemComissaoExterna.setVprevtcomiscmbio(item.getvpcelacomiscmbio());
			itemComissaoExterna.setPjuronegoccmbio(item.getpcomisnegoccmbio());
			itemComissaoExterna.setPeriodoTaxa(item.getiperdcjurocmbio());
			itemComissaoExterna.setMoedaComissao(item.getisglindcdfonte());
			itemComissaoExterna.setPeriodicidadeComissao(item
					.getifluxoperdccmbio());
			itemComissaoExterna
					.setCodMomentoComissao(item.getcmomencobrcmbio());
			itemComissaoExterna.setQpcelacmbiotrade(item.getqpcelacmbiotrade());
			itemComissaoExterna.setFromList(item.getFromList());
			itemComissaoExterna.setMomentoComissao(item.getdescrmomento());

			itemComissaoExterna.setCrespcomisexter(item.getCrespcomisexter());

			listaTemp = tradeFinanceMonitService.comissaoExternaDet(
					tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio(),
					item.getncomisextertrade(), tradeFinanceBean
							.getTradeFinanceVO().getHinclreghist());

			listaParcela = new ArrayList<TrdFinNegParcelaVO>();
			for (Iterator<ComissaoExternaVO> iterator = listaTemp.iterator(); iterator
					.hasNext();) {
				ComissaoExternaVO itemParcela = (ComissaoExternaVO) iterator
						.next();

				objTo = new TrdFinNegParcelaVO();

				objTo.setNpcelacomis(itemParcela.getnpcelacomisexter());
				objTo.setTdianegocpcela(itemParcela.getprazoparcela());
				objTo.setDvctopcelatrade(itemParcela.getdvctopcelatrade());
				objTo.setVencimentoComissao(SiteUtil
						.stringDataMainframeToWeb(itemParcela
								.getdvctopcelatrade()));
				objTo.setVpcelacomiscmbio(itemParcela.getvpcelacomiscmbio());
				objTo.setValorParcelaComissao(SiteUtil
						.formatarValorWeb(itemParcela.getvpcelacomiscmbio()));
				objTo.setVcustofincrcmbio(itemParcela.getdvctopcelatrade());

				listaParcela.add(objTo);
			}
			itemComissaoExterna.setListaParcelasComissao(listaParcela);

			listaComissaoExternaTemp.add(itemComissaoExterna);
		}
		setListaComissaoExt(listaComissaoExternaTemp);
	}

	/**
	 * 
	 * Nome: actionFecharModal Propósito:
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 23/02/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void actionFecharModal() {
		viewHelper.setRenderModal(false);
	}

	/**
	 * 
	 * Nome: paginarCotacao
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void paginarCotacao(ActionEvent event) {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.paginarCotacao <<<<<<<<<<<");

			setLista(tradeFinanceMonitService.obterCotacoesPend(filtroVO));

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.paginarCotacao <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: listenerAlterarComissaoExterna
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerAlterarComissaoExterna(AjaxBehaviorEvent e) {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.listenerAlterarComissaoExterna <<<<<<<<<<<");

			int itemSel = 0;

			TrdFinNegComissaoVO itemComissaoExterna = new TrdFinNegComissaoVO();

			// valida se foi selecionado um item na lista
			if (SiteUtil.isEmptyOrNull(viewHelper.getComissaoExtSelecionado())) {
				BradescoFacesUtils.addInfoModalMessage(
						"Selecione um Registro.", false);
				return;
			}

			// FORFAITING (644)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FORFAITING)) {
				alterarComissExtForfaiting();
				return;
			}

			if (tradeFinanceBean.getFluxoPgtList().size() <= Numeros.ZERO) {
				NpcFacesUtils.addInfoModalMessage(
						"Fluxo de Pagamento não incluído.", false);
				return;
			}
			
			if (getBancoReembolsadorVO().getBancodesemb().isEmpty()) {
				NpcFacesUtils.addInfoModalMessage(
						"Banco Banco Reembolsador/Desembolsador.", false);
				return;
			}

			FluxoPagamentoVO fluxoPagamentoVO = tradeFinanceBean
					.getFluxoPgtList().get(Numeros.ZERO);
			itemSel = SiteUtil.getInt(viewHelper.getComissaoExtSelecionado());

			TrdFinNegComissaoVO itemOrig = (TrdFinNegComissaoVO) listaComissaoExt
					.get(itemSel, EnumTipoComissao.BANQUEIRO);

			itemComissaoExterna.setCcondceconc(itemOrig.getCcondceconc());
			itemComissaoExterna.setCperdcjurocmbio(itemOrig
					.getCperdcjurocmbio());
			itemComissaoExterna.setCindcdeconmmoeda(itemOrig
					.getCindcdeconmmoeda());
			itemComissaoExterna.setCfluxoperdccmbio(itemOrig
					.getCfluxoperdccmbio());
			itemComissaoExterna.setTipoComissaoExt(itemOrig
					.getTipoComissaoExt());
			itemComissaoExterna.setVprevtcomiscmbio(itemOrig
					.getVprevtcomiscmbio());
			itemComissaoExterna.setPjuronegoccmbio(itemOrig
					.getPjuronegoccmbio());
			itemComissaoExterna.setPeriodoTaxa(itemOrig.getPeriodoTaxa());
			itemComissaoExterna.setMoedaComissao(itemOrig.getMoedaComissao());
			itemComissaoExterna.setPeriodicidadeComissao(itemOrig
					.getPeriodicidadeComissao());
			itemComissaoExterna.setCodMomentoComissao(itemOrig
					.getCodMomentoComissao());
			itemComissaoExterna.setQpcelacmbiotrade(itemOrig
					.getQpcelacmbiotrade());
			itemComissaoExterna.setListaParcelasComissao(itemOrig
					.getListaParcelasComissao());
			itemComissaoExterna.setDateComissao(fluxoPagamentoVO
					.getVenctoFluxDate());
			itemComissaoExterna.setDataComissaoFormat(fluxoPagamentoVO
					.getDvctopcelatrade());
			itemComissaoExterna.setTdiafinandsemb(fluxoPagamentoVO
					.getTdiafinandsemb());
			itemComissaoExterna.setVnegocmoedaestrg(tradeFinanceBean
					.getTradeFinanceVO().getVnegocmoedaestrg());
			itemComissaoExterna.setVprevtdsembcmbio(tradeFinanceBean
					.getTradeFinanceVO().getVnegocmoedaestrg());
			itemComissaoExterna
					.setVlxtotalcomis(itemOrig.getVprevtcomiscmbio());
			itemComissaoExterna.setPrzoperaccmbio(itemOrig.getPrzoperaccmbio());
			itemComissaoExterna.setTdiaopercmbio(tradeFinanceBean
					.getTradeFinanceVO().getTdiaopercmbio());

			itemComissaoExterna.setCrespcomisexter(itemOrig
					.getCrespcomisexter());
			itemComissaoExterna.setTipoComissao(itemOrig.getTipoComissao());

			comissaoExtManutModalBean.getViewHelper()
					.setFuncaoBotaoComissaoExterna("Alterar");
			comissaoExtManutModalBean.getViewHelper().setLinhaSelecionada(
					viewHelper.getComissaoExtSelecionado());
			comissaoExtManutModalBean.setQtdeFluxoPgt(tradeFinanceBean
					.getFluxoPgtList().size());
			comissaoExtManutModalBean
					.setItemListaComissaoExterna(itemComissaoExterna);
			comissaoExtManutModalBean
					.setListaComissaoExterna(getListaComissaoExt());
			comissaoExtManutModalBean
					.setListaParcelasTemp(new ArrayList<TrdFinNegParcelaVO>(
							itemComissaoExterna.getListaParcelasComissao()));

			comissaoExtManutModalBean.getViewHelper().setModalId(
					"formTradeFinMonitDet\\:content_modalComissaoExtManut");
			comissaoExtManutModalBean.getViewHelper()
					.setDisabledModalComissaoExt(Boolean.FALSE);

			// parametro utilizado para carregar o combo de tipo de comissão
			comissaoExtManutModalBean.getViewHelper().setTelaOrigem(
					Numeros.DOIS);

			comissaoExtManutModalBean.openModal(tradeFinanceBean
					.getTradeFinanceVO().getCprodtservc());

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.listenerAlterarComissaoExterna <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: listenerExcluirComissaoExterna
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerExcluirComissaoExterna(AjaxBehaviorEvent e) {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.listenerExcluirComissaoExterna <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (SiteUtil.isEmptyOrNull(viewHelper.getComissaoExtSelecionado())) {
				BradescoFacesUtils.addInfoModalMessage(
						"Selecione um Registro.", false);
				return;
			}

			listaComissaoExt.remove(
					SiteUtil.getInt(viewHelper.getComissaoExtSelecionado()),
					EnumTipoComissao.BANQUEIRO);

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.listenerExcluirComissaoExterna <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: listenerIncluirComissaoExterna
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws ParseException
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */

	public void listenerIncluirComissaoExterna(AjaxBehaviorEvent e)
			throws ParseException {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.listenerIncluirComissaoExterna <<<<<<<<<<<");

			// FORFAITING (644)
			if (tradeFinanceListaVO.getProduto().equals(
					EnumProduto.PRODUTO_FORFAITING)) {
				incluirComissExtForfaiting();
				return;
			}

			if (tradeFinanceBean.getFluxoPgtList().size() <= Numeros.ZERO) {
				NpcFacesUtils.addInfoModalMessage(
						"Fluxo de Pagamento não incluído.", false);
				return;
			}

			FluxoPagamentoVO fluxoPagamentoVO = tradeFinanceBean
					.getFluxoPgtList().get(Numeros.ZERO);

			// Inclusao de comissao de banqueiros
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setTipoComissao(EnumTipoComissao.BANQUEIRO);

			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setDateComissao(fluxoPagamentoVO.getVenctoFluxDate());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setDataComissaoFormat(
							fluxoPagamentoVO.getDvctopcelatrade());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setTdiafinandsemb(fluxoPagamentoVO.getTdiafinandsemb());
			comissaoExtManutModalBean
					.getItemListaComissaoExterna()
					.setDprevtdsembcmbio(fluxoPagamentoVO.getDprevtdsembcmbio());

			comissaoExtManutModalBean.getViewHelper()
					.setFuncaoBotaoComissaoExterna("Incluir");
			comissaoExtManutModalBean.setListaComissaoExterna(listaComissaoExt);
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCcondceconc(Numeros.ZERO);
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setVlxtotalcomis("");
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setPjuronegoccmbio("");
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCperdcjurocmbio(Numeros.ZERO);
			comissaoExtManutModalBean
					.getItemListaComissaoExterna()
					.setCindcdeconmmoeda(EnumTradeFinance.MOEDA_USD.getCodigo());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCfluxoperdccmbio(
							EnumTradeFinance.PERIODICIDADE_SEMESTRAL
									.getCodigo());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCodMomentoComissao(Numeros.ZERO);
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setQpcelacmbiotrade(null);
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.getListaParcelasComissao().clear();
			comissaoExtManutModalBean.getViewHelper()
					.setDisabledModalComissaoExt(Boolean.TRUE);
			comissaoExtManutModalBean.getViewHelper().setModalId(
					"formTradeFinMonitDet\\:content_modalComissaoExtManut");

			comissaoExtManutModalBean.getViewHelper()
					.setDisabledModalComissaoExt(Boolean.FALSE);

			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setTdiaopercmbio(
							tradeFinanceBean.getTradeFinanceVO()
									.getTdiaopercmbio());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setVnegocmoedaestrg(
							tradeFinanceBean.getTradeFinanceVO()
									.getVnegocmoedaestrg());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setVprevtdsembcmbio(
							tradeFinanceBean.getTradeFinanceVO()
									.getVnegocmoedaestrg());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setVmincobrcomis("0,00");
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCperdcjurocmbio(Numeros.UM);
			comissaoExtManutModalBean.getViewHelper()
					.setDisabledTxtParcelaComissaoExt(Boolean.TRUE);
			comissaoExtManutModalBean
					.setListaParcelasTemp(new ArrayList<TrdFinNegParcelaVO>());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setTipoComissao(EnumTipoComissao.BANQUEIRO);

			// parametro utilizado para carregar o combo de tipo de comissão
			comissaoExtManutModalBean.getViewHelper().setTelaOrigem(
					Numeros.DOIS);

			comissaoExtManutModalBean.openModal(tradeFinanceBean
					.getTradeFinanceVO().getCprodtservc());

			comissaoExtManutModalBean.setQtdeFluxoPgt(tradeFinanceBean
					.getFluxoPgtList().size());

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.listenerIncluirComissaoExterna <<<<<<<<<<<");
		}

	}

	/**
	 * Nome: listenerDetalharComissaoExterna
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerDetalharComissaoExterna(AjaxBehaviorEvent e) {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.listenerDetalharComissaoExterna <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (SiteUtil.isEmptyOrNull(viewHelper.getComissaoExtSelecionado())) {
				BradescoFacesUtils.addInfoModalMessage(
						"Selecione um Registro.", false);
				return;
			}

			comissaoExtManutModalBean.getViewHelper()
					.setFuncaoBotaoComissaoExterna("Detalhar");

			if (listaComissaoExt.getComissaoBanqueiro().size() > 0) {
				TrdFinNegComissaoVO itemComissaoExterna = (TrdFinNegComissaoVO) listaComissaoExt
						.get(SiteUtil.getInt(viewHelper
								.getComissaoExtSelecionado()),
								EnumTipoComissao.BANQUEIRO);

				comissaoExtManutModalBean
						.setItemListaComissaoExterna(itemComissaoExterna);
				comissaoExtManutModalBean
						.setListaParcelasTemp(new ArrayList<TrdFinNegParcelaVO>(
								itemComissaoExterna.getListaParcelasComissao()));
			}

			// parametro utilizado para carregar o combo de tipo de comissão
			comissaoExtManutModalBean.getViewHelper().setTelaOrigem(
					Numeros.DOIS);

			comissaoExtManutModalBean.getViewHelper()
					.setDisabledModalComissaoExt(Boolean.TRUE);
			comissaoExtManutModalBean.openModal(tradeFinanceBean
					.getTradeFinanceVO().getCprodtservc());

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.listenerDetalharComissaoExterna <<<<<<<<<<<");
		}

	}

	/**
	 * Nome: listenerIncluirCotacao
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	
	public void listenerIncluirCotacao(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerIncluirCotacao <<<<<<<<<<<");
			
        if (getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
				if (tradeFinanceVO.getListaCotacoes().size() < 1) {
					if (unidadeExternaVO.getBancocorr().equals("") || bancoReembolsadorVO.getBancodesemb().equals("")){
						getViewHelper().setItemSelecListaCotacoes(null);
						NpcFacesUtils.addInfoModalMessage("Banco Correspondente e Reembolsador são Obrigatórios", false);
						return;
					}
				} else {
					getViewHelper().setItemSelecListaCotacoes(null);
					NpcFacesUtils.addInfoModalMessage("Já Existe um Registro de Despesa Cadastrado", false);
					return;
				}
				
				if ((SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getBancocorr()) || SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getImunintlcmbio())
						|| SiteUtil.isEmptyOrNull(getBancoReembolsadorVO().getIbanqrcmbio()) || SiteUtil.isEmptyOrNull(getBancoReembolsadorVO().getImunintlcmbio())) || 
						(!SiteUtil.isEmptyOrNull(getBancoAvisadorVO().getBancoaviso()) && SiteUtil.isEmptyOrNull(getBancoAvisadorVO().getImunintlcmbio()))){
					NpcFacesUtils.addInfoModalMessage("Use a Lupa para Escolher um Banco", false);
					return;
				}
				getViewHelper().setItemSelecListaCotacoes(null);
			}

			if (getTradeFinanceVO().getProduto().equals(EnumProduto.FINIMP_ECA)
					|| getTradeFinanceVO().getProduto().equals(
							EnumProduto.LC_IMPORTACAO)
					|| getTradeFinanceVO().getProduto().isGarantia()) {

				if (getTradeFinanceVO().getProduto().equals(
						EnumProduto.FINIMP_ECA)) {
					if (SiteUtil.isEmptyOrNull(getUnidadeExternaVO()
							.getCbanqrcmbio())) {
						NpcFacesUtils
								.addInfoModalMessage(
										"O campo \"Banco Financiador\" deve ser preenchido!",
										false);
						return;
					}
				}

				if (SiteUtil.isEmptyOrNull(getUnidadeExternaVO()
						.getCbanqrcmbio())
						&& SiteUtil.isEmptyOrNull(getBancoAvisadorVO()
								.getCbanqrcmbio())
						&& SiteUtil.isEmptyOrNull(getBancoReembolsadorVO()
								.getCbanqrcmbio())) {

					NpcFacesUtils.addInfoModalMessage(
							"É preciso informar pelo menos um Banco!", false);
					return;

				} else {
					getTradeFinanceVO().getCotacaoFundingVO()
							.setCbanqrcmbiofndng(
									getUnidadeExternaVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setNbanqrcmbiofndng(
									getUnidadeExternaVO().getIbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setPracacmbiofndmg(
									getUnidadeExternaVO().getImunintlcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setCbanqrcmbioaviso(
									getBancoAvisadorVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setNbanqrcmbioaviso(
									getBancoAvisadorVO().getIbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setPracacmbioaviso(
									getBancoAvisadorVO().getImunintlcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setCbanqrcmbiorcdor(
									getBancoReembolsadorVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setNbanqrcmbiorcdor(
									getBancoReembolsadorVO().getIbanqrcmbio());
					getTradeFinanceVO()
							.getCotacaoFundingVO()
							.setPracacmbiorcdor(
									getBancoReembolsadorVO().getImunintlcmbio());

				}

			} else {

				if (SiteUtil.isEmptyOrNull(getUnidadeExternaVO()
						.getCbanqrcmbio())) {
					NpcFacesUtils
							.addInfoModalMessage(
									"O campo \"Banco Financiador\" deve ser preenchido!",
									false);
					return;
				} else {
					getTradeFinanceVO().getCotacaoFundingVO()
							.setCbanqrcmbiofndng(
									getUnidadeExternaVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setNbanqrcmbiofndng(
									getUnidadeExternaVO().getIbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setPracacmbiofndmg(
									getUnidadeExternaVO().getImunintlcmbio());
				}

				if (SiteUtil.isEmptyOrNull(getBancoReembolsadorVO()
						.getCbanqrcmbio())) {
					NpcFacesUtils
							.addInfoModalMessage(
									"O campo \"Banco Reembolsador\" deve ser preenchido!",
									false);
					return;
				} else {
					getTradeFinanceVO().getCotacaoFundingVO()
							.setCbanqrcmbiorcdor(
									getBancoReembolsadorVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setNbanqrcmbiorcdor(
									getBancoReembolsadorVO().getIbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO()
							.setPracacmbiorcdor(
									getBancoAvisadorVO().getImunintlcmbio());
				}
			}

			if (getTradeFinanceVO().getProduto().equals(
					EnumProduto.LC_IMPORTACAO)) {
				if (SiteUtil.isEmptyOrNull(getBancoReembolsadorVO()
						.getCbanqrcmbio())
						&& SiteUtil.getInt(getTradeFinanceVO()
								.getCindcdcartacnfdo()) == Numeros.UM) {
					NpcFacesUtils
							.addInfoModalMessage(
									"O flag de confirmada está como sim,\n favor preencher o banco Avisador!",
									false);
					return;
				}
			}

			if (getViewHelper().getDataValidadeCotacao() == null
					|| (getViewHelper().getDataValidadeCotacao() != null && !validarDataDiaUtil(getViewHelper()
							.getDataValidadeCotacao()))) {

				NpcFacesUtils.addInfoModalMessage(
						"Campo \"Validade da Cotação\" inválido!", false);
				return;
			} else {
				getTradeFinanceVO().getCotacaoFundingVO().setDlimfndngcmbio(
						SiteUtil.dateToString(getViewHelper()
								.getDataValidadeCotacao(), "dd/MM/yyyy"));
			}

			// getTradeFinanceVO().getCotacaoFundingVO().setCfndng(1L);
			getTradeFinanceVO().getCotacaoFundingVO().setDcotacfndngcmbio(
					SiteUtil.dateToString(new Date(), "dd/MM/yyyy"));
			getTradeFinanceVO().getCotacaoFundingVO().setCindcdfndngutlzd("S");
			getTradeFinanceVO().getCotacaoFundingVO().setNindcdfndngutlzd(
					"Em Negociação");

			/** Indica usuário que realizou a ação **/
			getTradeFinanceVO().getCotacaoFundingVO().setCusuariosess(
					getTradeFinanceVO().getCusuariosess());
			getTradeFinanceVO().getCotacaoFundingVO().setNusuariosess(
					getTradeFinanceVO().getNusuariosess());

			getTradeFinanceVO().getListaCotacoes().add(
					getTradeFinanceVO().getCotacaoFundingVO());

			getTradeFinanceVO().setCotacaoFundingVO(
					new ListaCotacoesExternasVO());
			setUnidadeExternaVO(new UnidadeExternaVO());
			setBancoReembolsadorVO(new UnidadeExternaVO());
			setBancoAvisadorVO(new UnidadeExternaVO());
			getViewHelper().setDataValidadeCotacao(
					getCommonService().getDataLimiteCotacao(new Date()));

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerIncluirCotacao <<<<<<<<<<<");
		}
	}

	/**
	 * Nome: listenerExcluirCotacao
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerExcluirCotacao(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerExcluirCotacao <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (getViewHelper().getItemSelecListaCotacoes() == null) {
				NpcFacesUtils.addInfoModalMessage("Selecione um Registro.",
						false);
				return;
			}

			// Remove o item selecionado.
			ListaCotacoesExternasVO itemCotacao = getTradeFinanceVO()
					.getListaCotacoes().get(
							getViewHelper().getItemSelecListaCotacoes());
			getTradeFinanceVO().getListaCotacoes().remove(itemCotacao);
			getTradeFinanceVO().setListaDespesas(
					new ArrayList<ListaDespesasVO>());

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerExcluirCotacao <<<<<<<<<<<");
		}
	}

	/**
	 * Nome: listenerAlterarCotacao
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerAlterarCotacao(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerAlterarCotacao <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (getViewHelper().getItemSelecListaCotacoes() == null) {
				BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
				return;
			}
			
            if (getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
				if (unidadeExternaVO.getBancocorr().equals("") || bancoReembolsadorVO.getBancodesemb().equals("")){
					getViewHelper().setItemSelecListaCotacoes(null);
					NpcFacesUtils.addInfoModalMessage("Banco Correspondente e Reembolsador são Obrigatórios", false);
					return;
				}
				
				if ((SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getBancocorr()) || SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getImunintlcmbio())
						|| SiteUtil.isEmptyOrNull(getBancoReembolsadorVO().getIbanqrcmbio()) || SiteUtil.isEmptyOrNull(getBancoReembolsadorVO().getImunintlcmbio())) || 
						(!SiteUtil.isEmptyOrNull(getBancoAvisadorVO().getBancoaviso()) && SiteUtil.isEmptyOrNull(getBancoAvisadorVO().getImunintlcmbio()))){
					NpcFacesUtils.addInfoModalMessage("Use a Lupa para Escolher um Banco", false);
					return;
				}
			}

			if (getTradeFinanceVO().getProduto().equals(EnumProduto.FINIMP_ECA)
					|| getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO) || getTradeFinanceVO().getProduto().isGarantia()) {

				if (SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getCbanqrcmbio()) && SiteUtil.isEmptyOrNull(getBancoAvisadorVO().getCbanqrcmbio())
						&& SiteUtil.isEmptyOrNull(getBancoReembolsadorVO().getCbanqrcmbio())) {

					NpcFacesUtils.addInfoModalMessage("É preciso informar pelo menos um Banco!", false);
					return;

				} else {
					getTradeFinanceVO().getCotacaoFundingVO().setCbanqrcmbiofndng(getUnidadeExternaVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setNbanqrcmbiofndng(getUnidadeExternaVO().getIbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setPracacmbiofndmg(getUnidadeExternaVO().getImunintlcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setCbanqrcmbioaviso(getBancoAvisadorVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setNbanqrcmbioaviso(getBancoAvisadorVO().getIbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setPracacmbioaviso(getBancoAvisadorVO().getImunintlcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setCbanqrcmbiorcdor(getBancoReembolsadorVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setNbanqrcmbiorcdor(getBancoReembolsadorVO().getIbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setPracacmbiorcdor(getBancoReembolsadorVO().getImunintlcmbio());
				}

			} else {

				if (SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getCbanqrcmbio())) {
					NpcFacesUtils.addInfoModalMessage("O campo \"Banco Financiador\" deve ser preenchido!", false);
					return;
				} else {
					getTradeFinanceVO().getCotacaoFundingVO().setCbanqrcmbiofndng(getUnidadeExternaVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setNbanqrcmbiofndng(getUnidadeExternaVO().getIbanqrcmbio());
				}

				if (SiteUtil.isEmptyOrNull(getBancoReembolsadorVO().getCbanqrcmbio())) {
					NpcFacesUtils.addInfoModalMessage("O campo \"Banco Reembolsador\" deve ser preenchido!", false);
					return;
				} else {
					getTradeFinanceVO().getCotacaoFundingVO().setCbanqrcmbiorcdor(getBancoReembolsadorVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setNbanqrcmbiorcdor(getBancoReembolsadorVO().getIbanqrcmbio());
				}
			}

			if (getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
				if (SiteUtil.isEmptyOrNull(getBancoAvisadorVO().getCbanqrcmbio()) && SiteUtil.getInt(getTradeFinanceVO().getCindcdcartacnfdo()) == Numeros.UM) {
					NpcFacesUtils.addInfoModalMessage("O flag de confirmada está como sim,\n favor preencher o banco Avisador!", false);
					return;
				} else {
					getTradeFinanceVO().getCotacaoFundingVO().setCbanqrcmbioaviso(getBancoAvisadorVO().getCbanqrcmbio());
					getTradeFinanceVO().getCotacaoFundingVO().setNbanqrcmbioaviso(getBancoAvisadorVO().getIbanqrcmbio());
				}
			}

			if (getViewHelper().getDataValidadeCotacao() != null && !validarDataDiaUtil(getViewHelper().getDataValidadeCotacao())) {

				NpcFacesUtils.addInfoModalMessage("Campo \"Validade da Cotação\" inválido!", false);
				return;
			} else {
				getTradeFinanceVO().getCotacaoFundingVO().setDlimfndngcmbio(SiteUtil.dateToString(getViewHelper().getDataValidadeCotacao(), "dd/MM/yyyy"));
			}

			// getTradeFinanceVO().getCotacaoFundingVO().setCfndng(1L);
			getTradeFinanceVO().getCotacaoFundingVO().setDcotacfndngcmbio(SiteUtil.dateToString(new Date(), "dd/MM/yyyy"));
			getTradeFinanceVO().getCotacaoFundingVO().setCindcdfndngutlzd("S");
			getTradeFinanceVO().getCotacaoFundingVO().setNindcdfndngutlzd("Em Negociação");

			/** Indica usuário que realizou a ação **/
			getTradeFinanceVO().getCotacaoFundingVO().setCusuariosess(getTradeFinanceVO().getCusuariosess());
			getTradeFinanceVO().getCotacaoFundingVO().setNusuariosess(getTradeFinanceVO().getNusuariosess());

			ListaCotacoesExternasVO itemCotacao = getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes());
			getTradeFinanceVO().getCotacaoFundingVO().setListaDespesas(itemCotacao.getListaDespesas());

			// Substitui o item selecionado.
			getTradeFinanceVO().getListaCotacoes().set(getViewHelper().getItemSelecListaCotacoes(), getTradeFinanceVO().getCotacaoFundingVO());

			getTradeFinanceVO().setCotacaoFundingVO(new ListaCotacoesExternasVO());
			setUnidadeExternaVO(new UnidadeExternaVO());
			setBancoReembolsadorVO(new UnidadeExternaVO());
			setBancoAvisadorVO(new UnidadeExternaVO());

			getViewHelper().setDataValidadeCotacao(getCommonService().getDataLimiteCotacao(new Date()));

		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerAlterarCotacao <<<<<<<<<<<");
		}
	}

	/**
	 * 
	 * Nome: listenerIncluirRespDespesa
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 10/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerIncluirRespDespesa(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerIncluirRespDespesa <<<<<<<<<<<");

			ListaResponsavelDespesaVO responsavelDespesaVO = new ListaResponsavelDespesaVO();
			


			if (!SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getCbanqrcmbio())
					&& !SiteUtil.isEmptyOrNull(getUnidadeExternaVO()
							.getIbanqrcmbio())
					&& getViewHelper().getFuncaoSelecionada().intValue() > 0) {

				responsavelDespesaVO.setCbanqrcmbio(getUnidadeExternaVO()
						.getCbanqrcmbio());
				responsavelDespesaVO.setNbanqrcmbio(getUnidadeExternaVO()
						.getIbanqrcmbio());
				
				if (getViewHelper().getFuncaoSelecionada().equals(Numeros.UM)) {
					if (tradeFinanceVO.getListaDespesaGaran().size() == 0 ){
						responsavelDespesaVO.setCbanqrcmbiofndg(getUnidadeExternaVO().getCbancoocrr().intValue());
						responsavelDespesaVO.setNfuncresp("Reembolsador");
					}
					for (int i = 0; i < tradeFinanceVO.getListaDespesaGaran().size(); i++) {
						if (!tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Reembolsador")) {
							responsavelDespesaVO.setCbanqrcmbiofndg(getUnidadeExternaVO().getCbancoocrr().intValue());
							responsavelDespesaVO.setNfuncresp("Reembolsador");
						} else {
							NpcFacesUtils.addInfoModalMessage("Banco Reembolsador já adicionado!", false);
							return;
						}
					}
				} else if (getViewHelper().getFuncaoSelecionada().equals(Numeros.DOIS)) {
					if (tradeFinanceVO.getListaDespesaGaran().size() == 0 ){
						responsavelDespesaVO.setCbanqrcmbiorcdor(getUnidadeExternaVO().getCbancoocrr().intValue());
						responsavelDespesaVO.setNfuncresp("Confirmador");
					}
					for (int i = 0; i < tradeFinanceVO.getListaDespesaGaran().size(); i++) {
						if (!tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Confirmador")) {
							responsavelDespesaVO.setCbanqrcmbiorcdor(getUnidadeExternaVO().getCbancoocrr().intValue());
							responsavelDespesaVO.setNfuncresp("Confirmador");
						} else {
							NpcFacesUtils.addInfoModalMessage("Banco Confirmador já adicionado!", false);
							return;
						}
					}

				} else if (getViewHelper().getFuncaoSelecionada().equals(Numeros.TRES)) {
					if (tradeFinanceVO.getListaDespesaGaran().size() == 0 ){
						responsavelDespesaVO.setCbanqrcmbioaviso(getUnidadeExternaVO().getCbancoocrr().intValue());
						responsavelDespesaVO.setNfuncresp("Avisador");
					}
					for (int i = 0; i < tradeFinanceVO.getListaDespesaGaran().size(); i++) {
						if (!tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Avisador")) {
							responsavelDespesaVO.setCbanqrcmbioaviso(getUnidadeExternaVO().getCbancoocrr().intValue());
							responsavelDespesaVO.setNfuncresp("Avisador");
						} else { 
							NpcFacesUtils.addInfoModalMessage("Banco Avisador já adicionado!", false);
							return;
						}
						
					}
				}				

				responsavelDespesaVO.setCfuncao(getViewHelper()
						.getFuncaoSelecionada());
				responsavelDespesaVO.setCmunintlcmbio(getUnidadeExternaVO()
						.getCmunintlcmbio());
				responsavelDespesaVO.setImunindcmbio(getUnidadeExternaVO()
						.getImunintlcmbio());
				responsavelDespesaVO.setIpais(getUnidadeExternaVO().getIpais());
				responsavelDespesaVO.setCpais(getUnidadeExternaVO().getCpais());
				responsavelDespesaVO.setCidbanqrswift(getUnidadeExternaVO()
						.getCidbanqrswift());
				responsavelDespesaVO.setCindcdfndngutlzd("S");
				responsavelDespesaVO.setNindcdfndngutlzd("Em Negociação");
				responsavelDespesaVO.setDcotacfndngcmbio(SiteUtil.dateToString(
						new Date(), "dd/MM/yyyy"));

				getTradeFinanceVO().getListaDespesaGaran().add(
						responsavelDespesaVO);

				setUnidadeExternaVO(new UnidadeExternaVO());
				getViewHelper().setFuncaoSelecionada(0);
			} else {
				NpcFacesUtils.addInfoModalMessage(
						"Preencha os campos para inclusão!", false);
			}
		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerIncluirRespDespesa <<<<<<<<<<<");
		}
	}

	/**
	 * 
	 * Nome: listenerExcluirRespDespesa
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerExcluirRespDespesa(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerExcluirRespDespesa <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (getViewHelper().getItemSelecListaRespDesp() == null) {
				NpcFacesUtils.addInfoModalMessage("Selecione um Registro.",
						false);
				return;
			}

			// Remove o item selecionado.
			ListaResponsavelDespesaVO itemCotacao = getTradeFinanceVO()
					.getListaDespesaGaran().get(
							getViewHelper().getItemSelecListaRespDesp());
			getTradeFinanceVO().getListaDespesaGaran().remove(itemCotacao);
			getTradeFinanceVO().setListaDespesas(
					new ArrayList<ListaDespesasVO>());
			getViewHelper().setItemSelecListaRespDesp(null);
		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerExcluirRespDespesa <<<<<<<<<<<");
		}
	}

	/**
	 * 
	 * Nome: listenerAlterarRespDesp
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerAlterarRespDesp(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerAlterarRespDesp <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (getViewHelper().getItemSelecListaRespDesp() == null) {
				BradescoFacesUtils.addInfoModalMessage(
						"Selecione um Registro.", false);
				return;
			}

			if (!SiteUtil.isEmptyOrNull(getUnidadeExternaVO().getCbanqrcmbio())
					&& !SiteUtil.isEmptyOrNull(getUnidadeExternaVO()
							.getIbanqrcmbio())
					&& getViewHelper().getFuncaoSelecionada().intValue() > 0) {

				ListaResponsavelDespesaVO itemCotacao = getTradeFinanceVO()
						.getListaDespesaGaran().get(
								getViewHelper().getItemSelecListaRespDesp());

				if (getViewHelper().getFuncaoSelecionada().equals(Numeros.UM)){
					for (int i = 0; i < tradeFinanceVO.getListaDespesaGaran().size(); i++) {
						if ( tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Reembolsador")){
							if (itemCotacao.getNbanqrcmbio().equals(getUnidadeExternaVO().getIbanqrcmbio())){
								NpcFacesUtils.addInfoModalMessage("Banco Reembolsador já adicionado!", false);
							    return;
							}
							if (!getViewHelper().getFuncaoSelecionada().equals(getTradeFinanceVO().getListaDespesaGaran().
									                                           get(getViewHelper().getItemSelecListaRespDesp()).getCfuncao()) &&
							    !itemCotacao.getNbanqrcmbio().equals(getUnidadeExternaVO().getIbanqrcmbio())){
								NpcFacesUtils.addInfoModalMessage("Banco Reembolsador já adicionado!", false);
							    return;
							}
						}
					}
					itemCotacao.setCbanqrcmbiofndg(getUnidadeExternaVO().getCbancoocrr().intValue());
				    itemCotacao.setNfuncresp("Reembolsador");
				} else if (getViewHelper().getFuncaoSelecionada().equals(Numeros.DOIS)) {
					for (int i = 0; i < tradeFinanceVO.getListaDespesaGaran().size(); i++) {
						if ( tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Confirmador")){
							if (itemCotacao.getNbanqrcmbio().equals(getUnidadeExternaVO().getIbanqrcmbio())){
								NpcFacesUtils.addInfoModalMessage("Banco Confirmador já adicionado!", false);
							    return;
							}
							if (!getViewHelper().getFuncaoSelecionada().equals(getTradeFinanceVO().getListaDespesaGaran().
									                                           get(getViewHelper().getItemSelecListaRespDesp()).getCfuncao()) &&
							    !itemCotacao.getNbanqrcmbio().equals(getUnidadeExternaVO().getIbanqrcmbio())){
								NpcFacesUtils.addInfoModalMessage("Banco Confirmador já adicionado!", false);
							    return;
							}
						}	
					}
					itemCotacao.setCbanqrcmbiorcdor(getUnidadeExternaVO().getCbancoocrr().intValue());
					itemCotacao.setNfuncresp("Confirmador");
				} else if (getViewHelper().getFuncaoSelecionada().equals(Numeros.TRES)) {
					for (int i = 0; i < tradeFinanceVO.getListaDespesaGaran().size(); i++) {
						if ( tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Avisador")){
							if (itemCotacao.getNbanqrcmbio().equals(getUnidadeExternaVO().getIbanqrcmbio())){
								NpcFacesUtils.addInfoModalMessage("Banco Avisador já adicionado!", false);
							    return;
							}
							if (!getViewHelper().getFuncaoSelecionada().equals(getTradeFinanceVO().getListaDespesaGaran().
									                                           get(getViewHelper().getItemSelecListaRespDesp()).getCfuncao()) &&
							    !itemCotacao.getNbanqrcmbio().equals(getUnidadeExternaVO().getIbanqrcmbio())){
								NpcFacesUtils.addInfoModalMessage("Banco Avisador já adicionado!", false);
							    return;
							}
						}
					}
					itemCotacao.setCbanqrcmbioaviso(getUnidadeExternaVO().getCbancoocrr().intValue());
					itemCotacao.setNfuncresp("Avisador");
				}
				
				itemCotacao.setCbanqrcmbio(getUnidadeExternaVO().getCbanqrcmbio());
				itemCotacao.setNbanqrcmbio(getUnidadeExternaVO().getIbanqrcmbio());
				itemCotacao.setCfuncao(getViewHelper().getFuncaoSelecionada());
				itemCotacao.setCmunintlcmbio(getUnidadeExternaVO()
						.getCmunintlcmbio());
				itemCotacao.setImunintlcmbio(getUnidadeExternaVO()
						.getImunintlcmbio());
				itemCotacao.setIpais(getUnidadeExternaVO().getIpais());
				itemCotacao.setCpais(getUnidadeExternaVO().getCpais());
				itemCotacao.setCidbanqrswift(getUnidadeExternaVO()
						.getCidbanqrswift());
				itemCotacao.setCindcdfndgttlzd("S");
				itemCotacao.setNindcdfndgttlzd("Em Negociação");

				// Substitui o item selecionado.
				getTradeFinanceVO().getListaDespesaGaran().set(
						getViewHelper().getItemSelecListaRespDesp(),
						itemCotacao);

				getViewHelper().setItemSelecListaRespDesp(null);
				setUnidadeExternaVO(new UnidadeExternaVO());
				getViewHelper().setFuncaoSelecionada(Numeros.ZERO);
			}

			getViewHelper().setDataValidadeCotacao(
					getCommonService().getDataLimiteCotacao(new Date()));

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerAlterarRespDesp <<<<<<<<<<<");
		}
	}

	/**
	 * Nome: listenerCarregarListaDespesasFunding
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws ParseException
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerCarregarListaDespesasFunding(AjaxBehaviorEvent e)
			throws ParseException {

		try {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerCarregarListaDespesasFunding <<<<<<<<<<<");

			getUnidadeExternaVO().setBancocorr(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getNbanqrcmbiofndng());
			getBancoAvisadorVO().setBancoaviso(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getNbanqrcmbioaviso());
			getBancoReembolsadorVO().setBancodesemb(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getNbanqrcmbiorcdor());

			getUnidadeExternaVO().setCbanqrcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getCbanqrcmbio());
			getUnidadeExternaVO().setCbanqrcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getCbanqrcmbiofndng());
			getUnidadeExternaVO().setIbanqrcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getNbanqrcmbiofndng());
			getUnidadeExternaVO().setImunintlcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getPracacmbiofndmg());

			getBancoAvisadorVO().setCbanqrcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getCbanqrcmbioaviso());
			getBancoAvisadorVO().setIbanqrcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getNbanqrcmbioaviso());
			getBancoAvisadorVO().setImunintlcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getPracacmbioaviso());

			getBancoReembolsadorVO().setCbanqrcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getCbanqrcmbiorcdor());
			getBancoReembolsadorVO().setIbanqrcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getNbanqrcmbiorcdor());
			getBancoReembolsadorVO().setImunintlcmbio(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getPracacmbiorcdor());

			getTradeFinanceVO().setListaDespesas(getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getListaDespesas());

		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerCarregarListaDespesasFunding <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: listenertCarregarListaDespesaResp
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerCarregarListaDespesaResp(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerCarregarListaDespesaResp <<<<<<<<<<<");

			getUnidadeExternaVO().setCbanqrcmbio(
					getTradeFinanceVO().getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.getCbanqrcmbio());

			getUnidadeExternaVO().setIbanqrcmbio(
					getTradeFinanceVO().getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.getNbanqrcmbio());

			getUnidadeExternaVO().setBancocorr(
					getTradeFinanceVO().getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.getNbanqrcmbio());

			getViewHelper().setFuncaoSelecionada(
					getTradeFinanceVO().getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.getCfuncao());

			if (getTradeFinanceVO().getListaDespesaGaran()
					.get(getViewHelper().getItemSelecListaRespDesp())
					.getCfuncao().equals(Numeros.UM)) {

				getUnidadeExternaVO().setCbancoocrr(
						SiteUtil.getLong(getTradeFinanceVO()
								.getListaDespesaGaran()
								.get(getViewHelper()
										.getItemSelecListaRespDesp())
								.getCbanqrcmbiofndg()));

			} else if (getTradeFinanceVO().getListaDespesaGaran()
					.get(getViewHelper().getItemSelecListaRespDesp())
					.getCfuncao().equals(Numeros.DOIS)) {

				getUnidadeExternaVO().setCbancoocrr(
						SiteUtil.getLong(getTradeFinanceVO()
								.getListaDespesaGaran()
								.get(getViewHelper()
										.getItemSelecListaRespDesp())
								.getCbanqrcmbiorcdor()));

			} else if (getTradeFinanceVO().getListaDespesaGaran()
					.get(getViewHelper().getItemSelecListaRespDesp())
					.getCfuncao().equals(Numeros.TRES)) {

				getUnidadeExternaVO().setCbancoocrr(
						SiteUtil.getLong(getTradeFinanceVO()
								.getListaDespesaGaran()
								.get(getViewHelper()
										.getItemSelecListaRespDesp())
								.getCbanqrcmbioaviso()));

			}

			getUnidadeExternaVO().setImunintlcmbio(
					getTradeFinanceVO().getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.getImunindcmbio());

			getUnidadeExternaVO().setIpais(
					getTradeFinanceVO().getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.getIpais());

			getUnidadeExternaVO().setCidbanqrswift(
					getTradeFinanceVO().getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.getCidbanqrswift());

			getTradeFinanceVO().setListaDespesas(
					getTradeFinanceVO().getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.getListaDespesas());

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerCarregarListaDespesaResp <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: listenertCarregarListaDespesa
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerCarregarListaDespesa(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerCarregarListaDespesa <<<<<<<<<<<");

			getTradeFinanceVO().getDespesaVO().setCidtfdrespdesp(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getCidtfdrespdesp());

			getTradeFinanceVO().getDespesaVO().setCtpodespcmbio(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getCtpodespcmbio());

			getTradeFinanceVO().getDespesaVO().setPdespnegoccmbio(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getPdespnegoccmbio().replace(".", ","));

			getTradeFinanceVO().getDespesaVO().setCbasebletonegoc(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getCbasebletonegoc());

			getTradeFinanceVO().getDespesaVO().setCindcdeconmmoeda(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getCindcdeconmmoeda());

			getTradeFinanceVO().getDespesaVO().setVdespbletocmbio(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getVdespbletocmbio());

			getTradeFinanceVO().getDespesaVO().setCformacobrdesp(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getCformacobrdesp());

			getTradeFinanceVO().getDespesaVO().setVmindespcmbio(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getVmindespcmbio());

			getTradeFinanceVO().getDespesaVO().setCfluxoperdccmbio(
					getTradeFinanceVO().getListaDespesas()
							.get(getViewHelper().getItemSelecListaDespesas())
							.getCfluxoperdccmbio());

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerCarregarListaDespesa <<<<<<<<<<<");
		}

	}

	/**
	 * Nome: listenerIncluirDespesa
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	
	public void listenerIncluirDespesa(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerIncluirDespesa <<<<<<<<<<<");

			if (validarCamposDespesa()) {

				getTradeFinanceVO().getDespesaVO().setNtpodespcmbio(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCtpodespcmbio(), getViewHelper()
										.getComboTipoDespesas()));

				// Caso a informação do combo de despesa vem da consulta devido
				// que o usuário pode incluir essa informação na
				// tela de inclusão do Garantias
				if (tradeFinanceBean.getTradeFinanceVO().getCidtfdrespdesp() != Numeros.ZERO) {
					getTradeFinanceVO().getDespesaVO().setCidtfdrespdesp(
							tradeFinanceBean.getTradeFinanceVO()
									.getCidtfdrespdesp());

				} else {
					getTradeFinanceVO().getDespesaVO().setNidtfdrespdesp(
							selectItemBean.getSelectItemLabelByValue(
									getTradeFinanceVO().getDespesaVO()
											.getCidtfdrespdesp(),
									getViewHelper().getComboPorConta()));
				}

				getTradeFinanceVO().getDespesaVO().setNindcdeconmmoeda(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCindcdeconmmoeda(), getViewHelper()
										.getComboMoeda()));

				getTradeFinanceVO().getDespesaVO().setNformacobrdesp(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCformacobrdesp(), getViewHelper()
										.getComboFormaPagamento()));

				getTradeFinanceVO().getDespesaVO().setNfluxoperdccmbio(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCfluxoperdccmbio(), getViewHelper()
										.getComboPeriodicidade()));

				if (!SiteUtil.isValueZero(getTradeFinanceVO().getDespesaVO().getVdespbletocmbio())) {
					//getTradeFinanceVO().getDespesaVO().setNbasebletonegoc(null);
					getTradeFinanceVO().getDespesaVO().setNbasebletonegoc(
							selectItemBean.getSelectItemLabelByValue(getTradeFinanceVO().getDespesaVO().getCbasebletonegoc(), 
																	 getViewHelper().getComboPeriodoDaTaxa()));
				} 
				else {
					getTradeFinanceVO().getDespesaVO().setNbasebletonegoc(
							selectItemBean.getSelectItemLabelByValue(getTradeFinanceVO().getDespesaVO().getCbasebletonegoc(), 
																	 getViewHelper().getComboPeriodoDaTaxa()));
				}
				
				if(SiteUtil.isEmptyOrNull(getTradeFinanceVO().getDespesaVO().getPdespnegoccmbio()))
					getTradeFinanceVO().getDespesaVO().setPdespnegoccmbio("0,00000");
					
				if(SiteUtil.isEmptyOrNull(getTradeFinanceVO().getDespesaVO().getVdespbletocmbio()))
					getTradeFinanceVO().getDespesaVO().setVdespbletocmbio("0");

				if(SiteUtil.isEmptyOrNull(getTradeFinanceVO().getDespesaVO().getVmindespcmbio()))
					getTradeFinanceVO().getDespesaVO().setVmindespcmbio("0");

				getTradeFinanceVO().getListaDespesas().add(
						getTradeFinanceVO().getDespesaVO());

				if (getTradeFinanceVO().getProduto().isGarantia()) {

					getTradeFinanceVO()
							.getListaDespesaGaran()
							.get(getViewHelper().getItemSelecListaRespDesp())
							.setListaDespesas(
									getTradeFinanceVO().getListaDespesas());

				} else {
					getTradeFinanceVO()
							.getListaCotacoes()
							.get(getViewHelper().getItemSelecListaCotacoes())
							.setListaDespesas(
									getTradeFinanceVO().getListaDespesas());
					atualizaContDivInterna();
				}

				getTradeFinanceVO().setDespesaVO(new ListaDespesasVO());

			}
		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerIncluirDespesa <<<<<<<<<<<");
		}
	}

	/**
	 * Nome: listenerExcluirDespesa
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerExcluirDespesa(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerExcluirDespesa <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (getViewHelper().getItemSelecListaDespesas() == null) {
				NpcFacesUtils.addInfoModalMessage("Selecione um Registro.",
						false);
				return;
			}

			ListaDespesasVO itemDespesa = getTradeFinanceVO()
					.getListaDespesas().get(
							getViewHelper().getItemSelecListaDespesas());

			// Remove o item selecionado.
			getTradeFinanceVO().getListaDespesas().remove(itemDespesa);

			if (getTradeFinanceVO().getProduto().isGarantia()) {
				getTradeFinanceVO().getListaDespesaGaran().get(getViewHelper().getItemSelecListaRespDesp()).getListaDespesas().remove(getViewHelper().getItemSelecListaDespesas());

			} else {
				getTradeFinanceVO().getListaCotacoes().get(getViewHelper().getItemSelecListaCotacoes()).getListaDespesas().remove(getViewHelper().getItemSelecListaDespesas());
				atualizaContDivInterna();
			}

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerExcluirDespesa <<<<<<<<<<<");
		}
	}

	/**
	 * Nome: listenerAlterarDespesa
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 18/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void listenerAlterarDespesa(AjaxBehaviorEvent e) {
		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.listenerAlterarDespesa <<<<<<<<<<<");

			// valida se foi selecionado um item na lista
			if (getViewHelper().getItemSelecListaDespesas() == null) {
				BradescoFacesUtils.addInfoModalMessage(
						"Selecione um Registro.", false);
				return;
			}

			if (validarCamposDespesa()) {

				getTradeFinanceVO().getDespesaVO().setNtpodespcmbio(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCtpodespcmbio(), getViewHelper()
										.getComboTipoDespesas()));

				getTradeFinanceVO().getDespesaVO().setNidtfdrespdesp(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCidtfdrespdesp(), getViewHelper()
										.getComboPorConta()));

				getTradeFinanceVO().getDespesaVO().setNindcdeconmmoeda(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCindcdeconmmoeda(), getViewHelper()
										.getComboMoeda()));

				getTradeFinanceVO().getDespesaVO().setNformacobrdesp(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCformacobrdesp(), getViewHelper()
										.getComboFormaPagamento()));

				getTradeFinanceVO().getDespesaVO().setNfluxoperdccmbio(
						selectItemBean.getSelectItemLabelByValue(
								getTradeFinanceVO().getDespesaVO()
										.getCfluxoperdccmbio(), getViewHelper()
										.getComboPeriodicidade()));
				
				if (!SiteUtil.isValueZero(getTradeFinanceVO().getDespesaVO()
						.getVdespbletocmbio())) {
					//getTradeFinanceVO().getDespesaVO().setNbasebletonegoc(null);
					getTradeFinanceVO().getDespesaVO().setNbasebletonegoc(
							selectItemBean.getSelectItemLabelByValue(
									getTradeFinanceVO().getDespesaVO()
											.getCbasebletonegoc(),
									getViewHelper().getComboPeriodoDaTaxa()));
				} else {
					getTradeFinanceVO().getDespesaVO().setNbasebletonegoc(
							selectItemBean.getSelectItemLabelByValue(
									getTradeFinanceVO().getDespesaVO()
											.getCbasebletonegoc(),
									getViewHelper().getComboPeriodoDaTaxa()));

				}

				atualizaContDivInterna();

				// Substitui o item selecionado.
				getTradeFinanceVO().getListaDespesas().set(
						getViewHelper().getItemSelecListaDespesas(),
						getTradeFinanceVO().getDespesaVO());
				getTradeFinanceVO().setDespesaVO(new ListaDespesasVO());
			}

			/*
			 * if
			 * (getTradeFinanceVO().getDespesaVO().getCtpodespcmbio().equals(Numeros
			 * .ZERO)) { BradescoFacesUtils.addInfoModalMessage(
			 * "O campo \"Tipo de Despesa\" deve ser preenchido!", false);
			 * return; } else {
			 * getTradeFinanceVO().getDespesaVO().setNtpodespcmbio
			 * (selectItemBean.getSelectItemLabelByValue(
			 * getTradeFinanceVO().getDespesaVO().getCtpodespcmbio(),
			 * getViewHelper().getComboTipoDespesas())); }
			 * 
			 * if
			 * (getTradeFinanceVO().getDespesaVO().getCidtfdrespdesp().equals(
			 * Numeros.ZERO)) { BradescoFacesUtils.addInfoModalMessage(
			 * "O campo \"Por Conta\" deve ser preenchido!", false); return; }
			 * else {
			 * getTradeFinanceVO().getDespesaVO().setNidtfdrespdesp(selectItemBean
			 * .getSelectItemLabelByValue(
			 * getTradeFinanceVO().getDespesaVO().getCidtfdrespdesp(),
			 * getViewHelper().getComboPorConta())); }
			 * 
			 * getTradeFinanceVO().getDespesaVO().setNindcdeconmmoeda(selectItemBean
			 * .getSelectItemLabelByValue(
			 * getTradeFinanceVO().getDespesaVO().getCindcdeconmmoeda(),
			 * getViewHelper().getComboMoeda()));
			 * 
			 * getTradeFinanceVO().getDespesaVO().setNformacobrdesp(selectItemBean
			 * .getSelectItemLabelByValue(
			 * getTradeFinanceVO().getDespesaVO().getCformacobrdesp(),
			 * getViewHelper().getComboFormaPagamento()));
			 * 
			 * getTradeFinanceVO().getDespesaVO().setNfluxoperdccmbio(selectItemBean
			 * .getSelectItemLabelByValue(
			 * getTradeFinanceVO().getDespesaVO().getCfluxoperdccmbio(),
			 * getViewHelper().getComboPeriodicidade()));
			 * 
			 * atualizaContDivInterna();
			 * 
			 * // Substitui o item selecionado.
			 * getTradeFinanceVO().getListaDespesas
			 * ().set(getViewHelper().getItemSelecListaDespesas(),
			 * getTradeFinanceVO().getDespesaVO());
			 * getTradeFinanceVO().setDespesaVO(new ListaDespesasVO());
			 */

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.listenerAlterarDespesa <<<<<<<<<<<");
		}
	}

	/**
	 * 
	 * Nome: numerarCotacoes
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 09/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private void numerarCotacoesDespesas() {

		if (getTradeFinanceVO().getListaCotacoes() != null) {
			long numCotacao = 1;

			for (ListaCotacoesExternasVO cotacoesList : getTradeFinanceVO()
					.getListaCotacoes()) {
				cotacoesList.setCfndng(numCotacao++);
				long numDesp = 1;

				if (cotacoesList.getListaDespesas() != null) {
					for (ListaDespesasVO despesasList : cotacoesList
							.getListaDespesas()) {
						despesasList.setNdespbletocmbio(numDesp++);
					}
				}

			}
		}
	}

	/**
	 * 
	 * Nome: atualizaContDivInterna
	 * 
	 * Propósito: Qualquer alteração nas despesas deve-se atualizar com o
	 * usuário que esta realizando a ação.
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private void atualizaContDivInterna() {
		// Atualiza a lista de Despesa com o usuário que realiza a
		// inclusao/alteracao
		if (getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
				|| getTradeFinanceVO().getProduto().equals(
						EnumProduto.FINIMP_ECA)) {

			ListaCotacoesExternasVO itemCotacao = getTradeFinanceVO()
					.getListaCotacoes().get(
							getViewHelper().getItemSelecListaCotacoes());
			itemCotacao.setCusuariosess(getTradeFinanceVO().getCusuariosess());
			itemCotacao.setNusuariosess(getTradeFinanceVO().getNusuariosess());
		}
	}

	/**
	 * 
	 * Nome: converteListaCotacoesExternas
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/08/2016 - Autor: BRQ7 - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private List<ListaCotacoesExternasVO> converteListaCotacoesExternas() {
		List<ListaCotacoesExternasVO> list = new ArrayList<ListaCotacoesExternasVO>();

		for (ListaResponsavelDespesaVO responsavelDespesaVO : getTradeFinanceVO().getListaDespesaGaran()) {
			ListaCotacoesExternasVO cotacoesExternasVO = new ListaCotacoesExternasVO();

			cotacoesExternasVO.setCbanqrcmbio(responsavelDespesaVO.getCbanqrcmbio());
			cotacoesExternasVO.setNbanqrcmbio(responsavelDespesaVO.getNbanqrcmbio());
			cotacoesExternasVO.setCbanqrcmbiofndng(Long.valueOf(responsavelDespesaVO.getCbanqrcmbiofndg()));
			cotacoesExternasVO.setCbanqrcmbiorcdor(Long.valueOf(responsavelDespesaVO.getCbanqrcmbiorcdor()));
			cotacoesExternasVO.setCbanqrcmbioaviso(Long.valueOf(responsavelDespesaVO.getCbanqrcmbioaviso()));
			cotacoesExternasVO.setCmunintlcmbio(responsavelDespesaVO.getCmunintlcmbio());
			cotacoesExternasVO.setCpais(responsavelDespesaVO.getCpais());
			cotacoesExternasVO.setCidbanqrswift(responsavelDespesaVO.getCidbanqrswift());
			cotacoesExternasVO.setCindcdfndgttlzd(responsavelDespesaVO.getCindcdfndgttlzd());
			cotacoesExternasVO.setCidbanqrswift(responsavelDespesaVO.getCidbanqrswift());
			cotacoesExternasVO.setCindcdfndngutlzd(responsavelDespesaVO.getCindcdfndngutlzd());
			cotacoesExternasVO.setDcotacfndngcmbio(responsavelDespesaVO.getDcotacfndngcmbio());
			cotacoesExternasVO.setDlimfndngcmbio(SiteUtil.dateToString(getViewHelper().getDataValidadeCotacao(), "dd/MM/yyyy"));

			cotacoesExternasVO.setListaDespesas(responsavelDespesaVO.getListaDespesas());

			list.add(cotacoesExternasVO);
		}
		return list;
	}

	/**
	 * 
	 * Nome: validarDatas
	 * 
	 * Propósito: Verifica se a data é um dia util e se respeita a regra de dois
	 * dias uteis à frente
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 12/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private Boolean validarDataDiaUtil(Date dataCtc) {

		String tpodata = null;

		if (getTradeFinanceListaVO().getCsitbletocmbio().equals(
				EnumPendencia.CUSTO_EXTERNO.getCodigo())) {
			tpodata = "2";
		} else {
			tpodata = "1";
		}

		if (SiteUtil.comparaDatas(SiteUtil.toDay(), dataCtc) > 0
				|| !getCommonService().validarDiaUtil(dataCtc, Numeros.ZERO,
						tpodata, 0, 0, 0)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	/**
	 * 
	 * Nome: validarCamposDespesa
	 * 
	 * Propósito: Validar se todos os campos de despesa foram incluídos
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 01/09/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private boolean validarCamposDespesa() {
		boolean valido = Boolean.TRUE;

		if (getTradeFinanceVO().getProduto().isGarantia() || getTradeFinanceVO().getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA) 
				|| getTradeFinanceVO().getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO)) {
			
			Boolean isReembolsador = Boolean.FALSE;
			Boolean isConfirmador = Boolean.FALSE;
			
			// Valida Campos de Despesa
			for (int i = 0; i < tradeFinanceVO.getListaDespesaGaran().size(); i++) {
				if (tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Reembolsador")) {
					isReembolsador = Boolean.TRUE;
				}
				if (tradeFinanceVO.getListaDespesaGaran().get(i).getNfuncresp().equalsIgnoreCase("Confirmador")) {
					isConfirmador = Boolean.TRUE;
				}
			}
			
			if (isReembolsador && isConfirmador ) {
			}
			else {
				NpcFacesUtils.addInfoModalMessage("Banco Reembolsador e Confirmador são obrigatórios.", false);
				valido = Boolean.FALSE;
			}
		}

		if (getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)){
			if (tradeFinanceVO.getListaCotacoes().isEmpty()){
				NpcFacesUtils.addInfoModalMessage("Banco Reembolsador e Correspondente são obrigatórios.", false);
				valido = Boolean.FALSE;
			}else if (SiteUtil.isEmptyOrNull(tradeFinanceVO.getListaCotacoes().get(0).getNbanqrcmbiofndng()) || 
				SiteUtil.isEmptyOrNull(tradeFinanceVO.getListaCotacoes().get(0).getNbanqrcmbiorcdor()) ){
				NpcFacesUtils.addInfoModalMessage("Banco Reembolsador e Correspondente são obrigatórios.", false);
				valido = Boolean.FALSE;
	   	    }
		}
		
		if (getTradeFinanceVO().getDespesaVO().getCtpodespcmbio()
				.equals(Numeros.ZERO)) {
			NpcFacesUtils.addInfoModalMessage(
					"O campo \"Tipo de Despesa\" deve ser selecionado!", false);
			valido = Boolean.FALSE;
		}

		if (getTradeFinanceVO().getDespesaVO().getCidtfdrespdesp()
				.equals(Numeros.ZERO)) {
			NpcFacesUtils.addInfoModalMessage(
					"O campo \"Por Conta\" deve ser selecionado!", false);
			valido = Boolean.FALSE;
		}

		if (getTradeFinanceVO().getDespesaVO().getCindcdeconmmoeda()
				.equals(Numeros.ZERO)) {
			NpcFacesUtils.addInfoModalMessage(
					"O campo \"Moeda\" deve ser selecionado!", false);
			valido = Boolean.FALSE;
		}

		if (getTradeFinanceVO().getDespesaVO().getCformacobrdesp()
				.equals(Numeros.ZERO)) {
			NpcFacesUtils.addInfoModalMessage(
					"O campo \"Forma de Pagamento\" deve ser selecionado!",
					false);
			valido = Boolean.FALSE;
		}

		if (SiteUtil.comparaDatas(viewHelper.getDataValidadeCotacao(),
				new Date()) < 0) {

			NpcFacesUtils.addInfoModalMessage("Data de Validade Expirada.",
					false);
			valido = Boolean.FALSE;

		}

		return valido;
	}

	public void incluirComissExtForfaiting() {

		try {
			getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.incluirComissExtForfaiting <<<<<<<<<<<");

			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCcondceconc(Numeros.ZERO);
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setVlxtotalcomis("");
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setPjuronegoccmbio("");
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCperdcjurocmbio(Numeros.ZERO);
			comissaoExtManutModalBean
					.getItemListaComissaoExterna()
					.setCindcdeconmmoeda(EnumTradeFinance.MOEDA_USD.getCodigo());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCfluxoperdccmbio(
							EnumTradeFinance.PERIODICIDADE_SEMESTRAL
									.getCodigo());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCodMomentoComissao(Numeros.ZERO);
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setQpcelacmbiotrade(null);
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.getListaParcelasComissao().clear();
			comissaoExtManutModalBean.getViewHelper()
					.setDisabledModalComissaoExt(Boolean.TRUE);
			comissaoExtManutModalBean.getViewHelper().setModalId(
					"formTradeFinMonitDet\\:content_modalComissaoExtManut");

			comissaoExtManutModalBean.getViewHelper()
					.setDisabledModalComissaoExt(Boolean.FALSE);
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setTipoComissao(EnumTipoComissao.BANQUEIRO);

			comissaoExtManutModalBean.getViewHelper()
					.setFuncaoBotaoComissaoExterna("Incluir");
			comissaoExtManutModalBean.setListaComissaoExterna(listaComissaoExt);

			if (getTradeFinanceBean().getTradeFinanceVO().getListaDesembolso()
					.size() <= Numeros.ZERO) {
				if (getTradeFinanceBean().getTradeFinanceVO()
						.getDataPrevDesemb().getInicio() == null) {
					NpcFacesUtils.addInfoModalMessage(
							"O campo Previsão do Desembolso não informado.",
							false);
					return;
				}
				comissaoExtManutModalBean.getItemListaComissaoExterna()
						.setDateComissao(
								getTradeFinanceBean().getTradeFinanceVO()
										.getDataPrevDesemb().getInicio());
			} else {
				comissaoExtManutModalBean.getItemListaComissaoExterna()
						.setDateComissao(
								getTradeFinanceBean().getTradeFinanceVO()
										.getListaDesembolso().get(0)
										.getDprevtdsembcmbio());
			}
			if (getTradeFinanceBean().getTradeFinanceVO().getListaDesembolso()
					.size() <= Numeros.ZERO) {
				comissaoExtManutModalBean.getItemListaComissaoExterna()
						.setDataComissaoFormat(
								getTradeFinanceBean().getTradeFinanceVO()
										.getDataPrevDesemb()
										.getInicioFormatado());
			} else {
				comissaoExtManutModalBean.getItemListaComissaoExterna()
						.setDataComissaoFormat(
								getTradeFinanceBean().getTradeFinanceVO()
										.getListaDesembolso().get(0)
										.getDataDesembolsoFormat());
			}
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setTdiafinandsemb(
							getTradeFinanceBean().getTradeFinanceVO()
									.getTdiaopercmbio());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setTdiaopercmbio(
							getTradeFinanceBean().getTradeFinanceVO()
									.getTdiaopercmbio());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setVnegocmoedaestrg(
							getTradeFinanceBean().getTradeFinanceVO()
									.getVnegocmoedaestrg());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setVprevtdsembcmbio(
							getTradeFinanceBean().getTradeFinanceVO()
									.getVnegocmoedaestrg());
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setVmincobrcomis("0,00");
			comissaoExtManutModalBean.getItemListaComissaoExterna()
					.setCperdcjurocmbio(Numeros.UM);
			comissaoExtManutModalBean.getViewHelper()
					.setDisabledTxtParcelaComissaoExt(Boolean.TRUE);

			// parametro utilizado para carregar o combo de tipo de comissão
			comissaoExtManutModalBean.getViewHelper().setTelaOrigem(
					Numeros.DOIS);

			comissaoExtManutModalBean.setQtdeFluxoPgt(getTradeFinanceBean()
					.getTradeFinanceVO().getListaDesembolso().size());
			comissaoExtManutModalBean.openModal(getTradeFinanceBean()
					.getTradeFinanceVO().getCprodtservc());

		} finally {
			getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.incluirComissExtForfaiting <<<<<<<<<<<");
		}

	}

	public void alterarComissExtForfaiting() {

		try {
			getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendBean.alterarComissExtForfaiting <<<<<<<<<<<");

			int itemSel = 0;
			TradeFinanceDesembolsoVO desembolsoVO = null;

			TrdFinNegComissaoVO itemComissaoExterna = new TrdFinNegComissaoVO();

			if (getTradeFinanceBean().getTradeFinanceVO().getListaDesembolso()
					.size() > Numeros.ZERO) {
				desembolsoVO = getTradeFinanceBean().getTradeFinanceVO()
						.getListaDesembolso().get(Numeros.ZERO);
			}

			itemSel = SiteUtil.getInt(getViewHelper()
					.getItemSelecListaComissaoExterna());

			TrdFinNegComissaoVO itemComissaoExternaAlt = (TrdFinNegComissaoVO) listaComissaoExt
					.get(itemSel);

			itemComissaoExterna.setCcondceconc(itemComissaoExternaAlt
					.getCcondceconc());
			itemComissaoExterna.setCperdcjurocmbio(itemComissaoExternaAlt
					.getCperdcjurocmbio());
			itemComissaoExterna.setCindcdeconmmoeda(itemComissaoExternaAlt
					.getCindcdeconmmoeda());
			itemComissaoExterna.setCfluxoperdccmbio(itemComissaoExternaAlt
					.getCfluxoperdccmbio());
			itemComissaoExterna.setTipoComissaoExt(itemComissaoExternaAlt
					.getTipoComissaoExt());
			itemComissaoExterna.setVprevtcomiscmbio(itemComissaoExternaAlt
					.getVprevtcomiscmbio());
			itemComissaoExterna.setPjuronegoccmbio(itemComissaoExternaAlt
					.getPjuronegoccmbio());
			itemComissaoExterna.setPeriodoTaxa(itemComissaoExternaAlt
					.getPeriodoTaxa());
			itemComissaoExterna.setMoedaComissao(itemComissaoExternaAlt
					.getMoedaComissao());
			itemComissaoExterna.setPeriodicidadeComissao(itemComissaoExternaAlt
					.getPeriodicidadeComissao());
			itemComissaoExterna.setCodMomentoComissao(itemComissaoExternaAlt
					.getCodMomentoComissao());
			itemComissaoExterna.setQpcelacmbiotrade(itemComissaoExternaAlt
					.getQpcelacmbiotrade());
			itemComissaoExterna.setListaParcelasComissao(itemComissaoExternaAlt
					.getListaParcelasComissao());

			itemComissaoExterna.setVnegocmoedaestrg(getTradeFinanceBean()
					.getTradeFinanceVO().getVnegocmoedaestrg());
			itemComissaoExterna.setVlxtotalcomis(itemComissaoExternaAlt
					.getVlxtotalcomis());

			if (getTradeFinanceBean().getTradeFinanceVO().getListaDesembolso()
					.size() <= Numeros.ZERO) {
				itemComissaoExterna.setDateComissao(getTradeFinanceBean()
						.getTradeFinanceVO().getDataPrevDesemb().getInicio());
				itemComissaoExterna.setDataComissaoFormat(getTradeFinanceBean()
						.getTradeFinanceVO().getDataPrevDesemb()
						.getInicioFormatado());
				itemComissaoExterna.setTdiafinandsemb(getTradeFinanceBean()
						.getTradeFinanceVO().getTdiaopercmbio());
				itemComissaoExterna.setTdiaopercmbio(getTradeFinanceBean()
						.getTradeFinanceVO().getTdiaopercmbio());
				itemComissaoExterna.setVprevtdsembcmbio(getTradeFinanceBean()
						.getTradeFinanceVO().getVnegocmoedaestrg());
			} else {
				itemComissaoExterna.setDateComissao(desembolsoVO
						.getDprevtdsembcmbio());
				itemComissaoExterna
						.setDataComissaoFormat(SiteUtil
								.dataWebToMainframe(desembolsoVO
										.getDprevtdsembcmbio()));
				itemComissaoExterna.setTdiafinandsemb(desembolsoVO
						.getTdiafinandsemb());
				itemComissaoExterna.setTdiaopercmbio(desembolsoVO
						.getTdiafinandsemb());
				itemComissaoExterna.setVprevtdsembcmbio(desembolsoVO
						.getVprevtdsembcmbio());
			}

			comissaoExtManutModalBean.getViewHelper()
					.setFuncaoBotaoComissaoExterna("Alterar");
			comissaoExtManutModalBean.getViewHelper().setLinhaSelecionada(
					viewHelper.getComissaoExtSelecionado());
			comissaoExtManutModalBean.setQtdeFluxoPgt(getTradeFinanceBean()
					.getTradeFinanceVO().getListaDesembolso().size());
			comissaoExtManutModalBean
					.setListaComissaoExterna(getListaComissaoExt());
			comissaoExtManutModalBean
					.setItemListaComissaoExterna(itemComissaoExterna);
			comissaoExtManutModalBean.getViewHelper().setModalId(
					"formTradeFinMonitDet\\:content_modalComissaoExtManut");
			comissaoExtManutModalBean.getViewHelper()
					.setDisabledModalComissaoExt(Boolean.FALSE);

			// parametro utilizado para carregar o combo de tipo de comissão
			comissaoExtManutModalBean.getViewHelper().setTelaOrigem(
					Numeros.DOIS);

			comissaoExtManutModalBean.openModal(getTradeFinanceBean()
					.getTradeFinanceVO().getCprodtservc());

		} finally {
			getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendBean.alterarComissExtForfaiting <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: getSelectItemComissaoExt
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<SelectItem> getSelectItemComissaoExt() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (int index = 0; index < getListaComissaoExt()
				.getComissaoBanqueiro().size(); index++) {
			list.add(new SelectItem(index, ""));
		}
		return list;
	}

	/**
	 * Nome: getItensRadioListaCotacoes
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<SelectItem> getItensRadioListaCotacoes() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.getItensRadioListaCotacoes <<<<<<<<<<<");

			List<SelectItem> list = new ArrayList<SelectItem>();

			// Percorre todos os itens da lista afim de criar os respectivos
			// radio
			// buttons
			for (int index = 0; index < getTradeFinanceVO().getListaCotacoes()
					.size(); index++) {
				list.add(new SelectItem(index, ""));
			}

			return list;

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.getItensRadioListaCotacoes <<<<<<<<<<<");
		}

	}

	/**
	 * Nome: getItensRadioListaDespesas
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/07/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<SelectItem> getItensRadioListaDespesas() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.getItensRadioListaDespesas <<<<<<<<<<<");

			List<SelectItem> list = new ArrayList<SelectItem>();

			// Percorre todos os itens da lista afim de criar os respectivos
			// radio
			// buttons
			for (int index = 0; index < getTradeFinanceVO().getListaDespesas()
					.size(); index++) {
				list.add(new SelectItem(index, ""));
			}

			return list;

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.getItensRadioListaDespesas <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: getItensRadioListaRespDesp
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 10/08/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<SelectItem> getItensRadioListaRespDesp() {

		try {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Inicio] TradeFinMonitCtcPendeteBean.getItensRadioListaRespDesp <<<<<<<<<<<");

			List<SelectItem> list = new ArrayList<SelectItem>();

			// Percorre todos os itens da lista afim de criar os respectivos
			// radio
			// buttons
			for (int index = 0; index < getTradeFinanceVO()
					.getListaDespesaGaran().size(); index++) {
				list.add(new SelectItem(index, ""));
			}

			return list;

		} finally {
			BradescoCommonServiceFactory
					.getLogManager()
					.info(">>>>>>>>>>>  [Fim] TradeFinMonitCtcPendeteBean.getItensRadioListaRespDesp <<<<<<<<<<<");
		}

	}

	/**
	 * 
	 * Nome: loadCaminhoThree
	 * 
	 * Propósito: Carrega a lista de Funcionalidades para 3 passos
	 *
	 * @param : String, String, String
	 * 
	 * @return : List<String>
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 04/08/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<String> loadCaminho(String parent0, String parent1, String atual) {
		List<String> list = new ArrayList<String>();

		// Adiciona itens do caminho até a tela atual
		if (getTradeFinanceVO().getCsitbletocmbio() == 37) {
			list.add(SiteUtil.getBundleValue(parent0));
			list.add(SiteUtil.getBundleValue(parent1));
			list.add(SiteUtil.getBundleValue(atual));
			setPassNumber(Numeros.TRES);
		} else {
			list.add(SiteUtil.getBundleValue(parent0));
			list.add(SiteUtil.getBundleValue(atual));
			setPassNumber(Numeros.DOIS);
		}

		return list;

	}

	public void continuarConfirmar() {

	}
	
    private BigDecimal calcularCustoTotal(String vtravaliborcmbio, String ptxcustototal, String vtxspreadtot) {
    	ptxcustototal = ptxcustototal.replace(".",",");
		BigDecimal liborTravada = new BigDecimal(vtravaliborcmbio.replaceAll("\\.","").replace(",","."));
		BigDecimal overlibor = new BigDecimal(ptxcustototal.replaceAll("\\.","").replace(",","."));
		BigDecimal spredTotal = new BigDecimal(vtxspreadtot.replaceAll("\\.","").replace(",","."));
		
		overlibor = liborTravada.add(overlibor);
		
		return overlibor.add(spredTotal);
	}
    
    private BigDecimal calcularCustoTotal(String vtravaliborcmbio, String ptxcustototal) {
    	ptxcustototal = ptxcustototal.replace(".",",");
		BigDecimal liborTravada = new BigDecimal(vtravaliborcmbio.replaceAll("\\.","").replace(",","."));
		BigDecimal overlibor = new BigDecimal(ptxcustototal.replaceAll("\\.","").replace(",","."));
		
		return liborTravada.add(overlibor);
	}
    
    public void valueChangeListenerLiborCustoExterno(AjaxBehaviorEvent event) {
    	
    	// Se informado libor válida (> 0), desabilita taxa fixa
		if (!SiteUtil.isEmptyOrNull(this.getCustoExternoVO().getVtxliborcmbio()) &&
		    !SiteUtil.isValueZero(this.getCustoExternoVO().getVtxliborcmbio())) {
			
    		this.custoExternoVO.setPtxfixacmbio("");
			this.getViewHelper().setDisabledTaxaFixa(true);

			if(!SiteUtil.isValueZero(tradeFinanceBean.getTradeFinanceVO().getVtravaliborcmbio()) && temFluxoPagamento()) {
				if (tradeFinanceBean.getTradeFinanceVO().getCcomiscartanacio().equals("Sim") || tradeFinanceBean.getTradeFinanceVO().getCcomiscartanacio().equals("1")) {
					BigDecimal custoTotal = calcularCustoTotal(tradeFinanceBean.getTradeFinanceVO().getVtravaliborcmbio(), this.getCustoExternoVO().getVtxliborcmbio());
					if (fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(custoTotal.toString())) {
						
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
//						tradeFinanceBean.detalharFluxoPgt2();
				    	for (FluxoPagamentoVO itemFluxoPagamento :  tradeFinanceBean.getFluxoPgtList()) {
							if ((itemFluxoPagamento.getCfluxoliqdcjuro() == 14 || itemFluxoPagamento.getDfluxoliqdcjuro().equals("Inicial")) || 
									itemFluxoPagamento.getQpcelatradejuro() % itemFluxoPagamento.getQpcelatradeprinc() != 0) {
			    				calcularJurosPeriodicidadeDiferente(itemFluxoPagamento, custoTotal.toString().replace(".",","));
							} 
							else {
								calcularJuros(itemFluxoPagamento, custoTotal.toString().replace(".",","));
							}
				    	}

					}
	            } 
				else if (tradeFinanceBean.getTradeFinanceVO().getCcomiscartanacio().equals("Não") || tradeFinanceBean.getTradeFinanceVO().getCcomiscartanacio().equals("2")) {
	            	BigDecimal custoTotal = calcularCustoTotal(tradeFinanceBean.getTradeFinanceVO().getVtravaliborcmbio(), this.getCustoExternoVO().getVtxliborcmbio(), tradeFinanceBean.getTradeFinanceVO().getVtxspreadtot());
					if (fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(custoTotal.toString())) {
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
//						tradeFinanceBean.detalharFluxoPgt2();
				    	for (FluxoPagamentoVO itemFluxoPagamento :  tradeFinanceBean.getFluxoPgtList()) {
							if ((itemFluxoPagamento.getCfluxoliqdcjuro() == 14 || itemFluxoPagamento.getDfluxoliqdcjuro().equals("Inicial")) || 
									itemFluxoPagamento.getQpcelatradejuro() % itemFluxoPagamento.getQpcelatradeprinc() != 0) {
			    				calcularJurosPeriodicidadeDiferente(itemFluxoPagamento, custoTotal.toString().replace(".",","));
							} else {
								calcularJuros(itemFluxoPagamento, custoTotal.toString().replace(".",","));
							}
				    	}
					}
	            }
			}
		} else {
			this.getViewHelper().setDisabledTaxaFixa(false);
			if(temFluxoPagamento()) {
//IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
		    	for (FluxoPagamentoVO itemFluxoPagamento :  tradeFinanceBean.getFluxoPgtList()) {
					List<FluxoPagamentoVO> fluxoPagamentoVO = itemFluxoPagamento.getLista();
					for (int i = 0; i < fluxoPagamentoVO.size(); i++) {
						fluxoPagamentoVO.get(i).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb("0.00"));
					}
		    	}
			}
		}
    }
    
    public void valueChangeListenerTaxaFixa(AjaxBehaviorEvent event) {
    	
    	// Se informado Taxa Fixa (> 0), desabilita libor
		if(!SiteUtil.isEmptyOrNull(this.getCustoExternoVO().getPtxfixacmbio())) {

			this.getViewHelper().setDisabledLibor(true);
			this.getCustoExternoVO().setTmesliborcmbio(0); 
			this.getCustoExternoVO().setVtxliborcmbio("");
			tradeFinanceBean.getTradeFinanceVO().setVtravaliborcmbio("0,00");

			if(temFluxoPagamento()) {
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
//				tradeFinanceBean.detalharFluxoPgt2();
		    	for (FluxoPagamentoVO itemFluxoPagamento :  tradeFinanceBean.getFluxoPgtList()) {
					if ((itemFluxoPagamento.getCfluxoliqdcjuro() == 14 || itemFluxoPagamento.getDfluxoliqdcjuro().equals("Inicial")) || 
							itemFluxoPagamento.getQpcelatradejuro() % itemFluxoPagamento.getQpcelatradeprinc() != 0) {
						calcularJurosPeriodicidadeDiferente(itemFluxoPagamento, this.getCustoExternoVO().getPtxfixacmbio());
					} else {
						calcularJuros(itemFluxoPagamento, this.getCustoExternoVO().getPtxfixacmbio());
					}
		    	}
			}
		} else {
			this.getViewHelper().setDisabledLibor(false);
			this.getViewHelper().setDisabledLiborMeses(false);
			if(temFluxoPagamento()) {
//IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
		    	for (FluxoPagamentoVO itemFluxoPagamento :  tradeFinanceBean.getFluxoPgtList()) {
					List<FluxoPagamentoVO> fluxoPagamentoVO = itemFluxoPagamento.getLista();
					for (int i = 0; i < fluxoPagamentoVO.size(); i++) {
						fluxoPagamentoVO.get(i).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb("0.00"));
					}
		    	}
			}
		}
    }
    
    
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
 	/**
 	 * 
 	 * Nome: calcularJuros
 	 * 
 	 *
 	 *
 	 * @see : Referencias externas.
 	 *
 	 *      Registro de Manutenção: 13/06/2019 - Autor: BRQ - Responsavel:
 	 *      Equipe Web - Adequação ao padrão hexavision.
 	 */
    private void calcularJuros(FluxoPagamentoVO itemFluxoPagamento, String taxaDeJuros) {
//  	Saldo Devedor*(Libor Travada*Prazo Parcela)/360
  		taxaDeJuros = taxaDeJuros.replaceAll("\\.","").replace(",",".");
  		
  		BigDecimal taxaDeJurosAux = new BigDecimal(taxaDeJuros).divide(new BigDecimal("100"));
  		for (int i = 0; i < itemFluxoPagamento.getLista().size(); i++) {
  			String saldoDevedorAtual = itemFluxoPagamento.getLista().get(i).getVpcelamesatrade().replaceAll("\\.","").replace(",",".");
  			
  			Integer prazoParcela = itemFluxoPagamento.getLista().get(i).getTdianegocpcela();
  			
  			BigDecimal valor1 = new BigDecimal(taxaDeJurosAux.toString()).multiply(new BigDecimal(prazoParcela));
			BigDecimal resultado = casasDecimais(10, valor1.divide(new BigDecimal("360"), MathContext.DECIMAL32));
			
			BigDecimal valor3 = casasDecimais(10, new BigDecimal(saldoDevedorAtual).multiply(new BigDecimal(resultado.toString()), MathContext.DECIMAL32));
  			
			itemFluxoPagamento.getLista().get(i).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(valor3.toString()));
  		}
    }
    
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
 	/**
 	 * 
 	 * Nome: calcularJurosPeriodicidadeDiferente
 	 * 
 	 *
 	 *
 	 * @see : Referencias externas.
 	 *
 	 *      Registro de Manutenção: 13/06/2019 - Autor: BRQ - Responsavel:
 	 *      Equipe Web - Adequação ao padrão hexavision.
 	 */
    private void calcularJurosPeriodicidadeDiferente(FluxoPagamentoVO itemFluxoPagamento, String taxaDeJuros) {
		//Saldo Devedor*(Libor Travada*Prazo Parcela)/360
		taxaDeJuros = taxaDeJuros.replaceAll("\\.","").replace(",",".");
		
		BigDecimal taxaDeJurosAux = new BigDecimal(taxaDeJuros).divide(new BigDecimal("100"));
		BigDecimal valor3;
		Integer prazoParcela = 0;
		
		List<FluxoPagamentoVO> fluxoPagamentoVO = itemFluxoPagamento.getLista();
		
		for (int i = 0; i < fluxoPagamentoVO.size(); i++) {
			String ValorJurosTemp = fluxoPagamentoVO.get(i).getValorJurosParcelaFluxoPgto();
			if (!SiteUtil.isEmptyOrNull(ValorJurosTemp) && i < fluxoPagamentoVO.size()) {
				String saldoDevedorAtual = fluxoPagamentoVO.get(i).getVpcelamesatrade().replaceAll("\\.","").replace(",",".");
				if (itemFluxoPagamento.getCfluxoliqdcjuro() == 14 || itemFluxoPagamento.getDfluxoliqdcjuro().equals("Inicial")) {
					prazoParcela = itemFluxoPagamento.getTdiafinandsemb();
				} else if (prazoParcela == 0) {
					prazoParcela = fluxoPagamentoVO.get(i).getTdianegocpcela();
				}
				BigDecimal valor1 = new BigDecimal(taxaDeJurosAux.toString()).multiply(new BigDecimal(prazoParcela));
				BigDecimal resultado = casasDecimais(10, valor1.divide(new BigDecimal("360"), MathContext.DECIMAL32));

				valor3 = casasDecimais(10, new BigDecimal(saldoDevedorAtual).multiply(new BigDecimal(resultado.toString()), MathContext.DECIMAL32));

				fluxoPagamentoVO.get(i).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(valor3.toString()));
				prazoParcela = 0;
			} else if ((itemFluxoPagamento.getCfluxoliqdcjuro() != 14) && (!itemFluxoPagamento.getDfluxoliqdcjuro().equals("Inicial"))) {
				Integer prazoParcelaTemp = fluxoPagamentoVO.get(i).getTdianegocpcela();
				Integer prazoParcelaAux = fluxoPagamentoVO.get(i+1).getTdianegocpcela();
				prazoParcela = prazoParcelaTemp + prazoParcelaAux;
			} else if (itemFluxoPagamento.getCfluxoliqdcjuro() == 14 || itemFluxoPagamento.getDfluxoliqdcjuro().equals("Inicial")) {
				String saldoDevedorAtual = fluxoPagamentoVO.get(i).getVpcelamesatrade().replaceAll("\\.","").replace(",",".");
				if (prazoParcela == 0) {
					prazoParcela = fluxoPagamentoVO.get(i).getTdianegocpcela();
				}
				BigDecimal valor1 = new BigDecimal(taxaDeJurosAux.toString()).multiply(new BigDecimal(prazoParcela));
				BigDecimal resultado = casasDecimais(10, valor1.divide(new BigDecimal("360"), MathContext.DECIMAL32));

				valor3 = casasDecimais(10, new BigDecimal(saldoDevedorAtual).multiply(new BigDecimal(resultado.toString()), MathContext.DECIMAL32));

				fluxoPagamentoVO.get(i).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(valor3.toString()));
				prazoParcela = 0;
			}
		}
    }
    
    public Boolean temFluxoPagamento(){
    	//produtos que nao tem fluxo de pagamento
    	if(getTradeFinanceVO().getProduto().isBndesPos() 
                || getTradeFinanceVO().getProduto().isBndesPre()
                || getTradeFinanceVO().getProduto().isGarantia()
                || getTradeFinanceVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
                || getTradeFinanceVO().getProduto().equals(EnumProduto.PROEX)
                || getTradeFinanceVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)){
    		
    		return Boolean.FALSE;
    	}else{
    		return Boolean.TRUE;
    	}
    }
    
    
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
	/**
	 * 
	 * Nome: alterarListaFluxoPagtoPrincJurosCtcPend
	 * 
	 *
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 13/06/2019 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
    private void alterarListaFluxoPagtoPrincJurosCtcPend() {
    	for (FluxoPagamentoVO itemFluxoPagamento :  tradeFinanceBean.getFluxoPgtList()) {
    		alterarFluxoPagtoPrincJurosCtcPend(itemFluxoPagamento);
    	}
    	
    }
    
 // IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
	/**
	 * 
	 * Nome: alterarFluxoPagtoPrincJurosCtcPend
	 * 
	 *
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 13/06/2019 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	private void alterarFluxoPagtoPrincJurosCtcPend(FluxoPagamentoVO fluxoPagtoVO) {
		TrdFinNegFluxoPagtoVO itemDesembolso = new TrdFinNegFluxoPagtoVO();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS"); 
		Date date = new Date(); 
		
		itemDesembolso.setNbletonegoccmbio(tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());
		itemDesembolso.setSeqFluxoPagto(fluxoPagtoVO.getNdsembcmbiotrade());
		itemDesembolso.setHinclreg(dateFormat.format(date));
		itemDesembolso.setVprevtdsembcmbio(fluxoPagtoVO.getVprevtdsembcmbio());
		itemDesembolso.setDateFluxoPgto(SiteUtil.dataMainframeToWeb(fluxoPagtoVO.getDprevtdsembcmbio()));
		itemDesembolso.setTdiacarenprinc(fluxoPagtoVO.getTdiacarenprinc());
		itemDesembolso.setCfluxoliqdcprinc(fluxoPagtoVO.getCfluxoliqdcprinc());
		itemDesembolso.setQtdeocorrprinc(fluxoPagtoVO.getQpcelatradeprinc());
		itemDesembolso.setTdiafinandsemb(fluxoPagtoVO.getTdiafinandsemb());
		itemDesembolso.setCodJurosPeriodicidade(fluxoPagtoVO.getCfluxoliqdcjuro());
		itemDesembolso.setQtdeocorrjuros(fluxoPagtoVO.getQpcelatradejuro());
		itemDesembolso.setCodJurosMomento(fluxoPagtoVO.getCmomencobrcmbio());
		
		//Por: Cláudio Tadeu em 08/10/2019 - IN3448409 - Problema na funcionalidade "Cotar Custo Externo - Finimp Direto", que está alterando a informação da carência dos juros.
        itemDesembolso.setJurosCarencia(fluxoPagtoVO.getTdiacarenjuro());

		List<TrdFinNegParcelaVO> listaPrinc = new ArrayList<TrdFinNegParcelaVO>();
    	List<TrdFinNegParcelaVO> listaJuros = new ArrayList<TrdFinNegParcelaVO>();

    	List<FluxoPagamentoVO> listaParaAlteracao = fluxoPagtoVO.getLista();

		if (itemDesembolso.getCfluxoliqdcprinc().equals(itemDesembolso.getCodJurosPeriodicidade())) {
			
			if (itemDesembolso.getQtdeocorrprinc() < itemDesembolso.getQtdeocorrjuros()) {
				for (FluxoPagamentoVO parcela : listaParaAlteracao) {
					if (parcela.getTipojuros().equals("P")) {
						TrdFinNegParcelaVO parcelaPrincipal = new TrdFinNegParcelaVO();
						parcelaPrincipal.setTpparcela("P");
						parcelaPrincipal.setNpceladsembtrade(parcela.getNpceladsembtrade());
						parcelaPrincipal.setTdianegocpcela(parcela.getTdianegocpcela());
						parcelaPrincipal.setDvctopcelatrade(parcela.getDvctopcelatrade());
						parcelaPrincipal.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(parcela.getDvctopcelatrade()));
						parcelaPrincipal.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(parcela.getDvctopcelatrade()));
						parcelaPrincipal.setVpcelamesatrade(parcela.getValorPrincipalParcelaFluxoPgto());
						parcelaPrincipal.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(parcela.getValorPrincipalParcelaFluxoPgto()));
	    				listaPrinc.add(parcelaPrincipal);
	
	    				TrdFinNegParcelaVO parcelaJuros = new TrdFinNegParcelaVO();
	    				parcelaJuros.setTpparcela("J");
	    				parcelaJuros.setNpceladsembtrade(parcela.getNpceladsembtrade());
	    				parcelaJuros.setTdianegocpcela(parcela.getTdianegocpcela());
	    				parcelaJuros.setDvctopcelatrade(parcela.getDvctopcelatrade());
	    				parcelaJuros.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(parcela.getDvctopcelatrade()));
	    				parcelaJuros.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(parcela.getDvctopcelatrade()));
	    				parcelaJuros.setVpcelamesatrade(parcela.getValorJurosParcelaFluxoPgto());
	    				parcelaJuros.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(parcela.getValorJurosParcelaFluxoPgto()));
	    				listaPrinc.add(parcelaJuros);
						
					}
					else if (parcela.getTipojuros().equals("J")) {
	    				TrdFinNegParcelaVO parcelaJuros = new TrdFinNegParcelaVO();
	    				parcelaJuros.setTpparcela("J");
	    				parcelaJuros.setNpceladsembtrade(parcela.getNpceladsembtrade());
	    				parcelaJuros.setTdianegocpcela(parcela.getTdianegocpcela());
	    				parcelaJuros.setDvctopcelatrade(parcela.getDvctopcelatrade());
	    				parcelaJuros.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(parcela.getDvctopcelatrade()));
	    				parcelaJuros.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(parcela.getDvctopcelatrade()));
	    				parcelaJuros.setVpcelamesatrade(parcela.getValorJurosParcelaFluxoPgto());
	    				parcelaJuros.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(parcela.getValorJurosParcelaFluxoPgto()));

	    				listaPrinc.add(parcelaJuros);
					}
				}
			}
			
			else {
    			for (int i = 0; i < listaParaAlteracao.size(); i++) {

    				FluxoPagamentoVO objFrom = listaParaAlteracao.get(i);
    				TrdFinNegParcelaVO objTo = new TrdFinNegParcelaVO();

    				objTo.setTpparcela("P");
    				objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
    				objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
    				objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
    				objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
    				objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
    				objTo.setVpcelamesatrade(objFrom.getValorPrincipalParcelaFluxoPgto());
    				objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorPrincipalParcelaFluxoPgto()));
    				listaPrinc.add(objTo);

    				objTo = new TrdFinNegParcelaVO();
    				objTo.setTpparcela("J");
    				objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
    				objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
    				objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
    				objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
    				objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
    				objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
    				objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
    				listaJuros.add(objTo);
    			}
    			int numeroParcela = 1;
    			
    			for (int i = 0; i < listaJuros.size(); i++) {
    				listaPrinc.get(i).setNpceladsembtrade(numeroParcela);
    				numeroParcela++;
    				listaJuros.get(i).setNpceladsembtrade(numeroParcela);
    				numeroParcela++;
    				listaPrinc.add(listaJuros.get(i));
    			}
			}
		} else {
			for (int i = 0; i < listaParaAlteracao.size(); i++) {
				FluxoPagamentoVO objFrom = listaParaAlteracao.get(i);
			
				if (objFrom.getTipojuros().equals("P")) {
					TrdFinNegParcelaVO objTo = new TrdFinNegParcelaVO();
					objTo.setTpparcela("P");
					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
					objTo.setVpcelamesatrade(objFrom.getValorPrincipalParcelaFluxoPgto());
					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorPrincipalParcelaFluxoPgto()));

					listaPrinc.add(objTo);
					if (objFrom.getValorJurosParcelaFluxoPgto() != null  && itemDesembolso.getCodJurosPeriodicidade() != 14) {
						objTo = new TrdFinNegParcelaVO();
    					objTo.setTpparcela("J");
    					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
    					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
    					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
    					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
    					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
    					objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
    					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
    					
    					listaJuros.add(objTo);
					}
				} else {
					TrdFinNegParcelaVO objTo = new TrdFinNegParcelaVO();
					objTo.setTpparcela("J");
					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
					objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
					
					listaJuros.add(objTo);
				}
			}
			int numeroParcela = 1;
			
			for (int i = 0; i < listaJuros.size(); i++) {
				if (i < itemDesembolso.getQtdeocorrprinc()) {
    				listaPrinc.get(i).setNpceladsembtrade(numeroParcela);
    				numeroParcela++;
				}
		
				listaJuros.get(i).setNpceladsembtrade(numeroParcela);
				numeroParcela++;
				listaPrinc.add(listaJuros.get(i));
			}
		}
		
    	itemDesembolso.setListaParcelasFluxoPgto(listaPrinc);
    	
    	List<MercadoriaVO> listaSelMercadoriaCtcPend = tradeFinanceBean.getMercadoriaList();
    	
    	getTradeFinanceNegociacaoService().alterarFluxoPagtoPrincJurosCtcPend(itemDesembolso , listaSelMercadoriaCtcPend);
	}
    
	public BigDecimal casasDecimais(int casas, BigDecimal valor){
	    String quantCasas = "%."+casas+"f", textoValor = "0";
	    try {
	        textoValor = String.format(Locale.getDefault(), quantCasas, valor);
	    } catch(java.lang.IllegalArgumentException e) {
	        if(e.getMessage().equals("Digits < 0")){
	            textoValor = "0";
	        }
	        BradescoCommonServiceFactory.getLogManager().error(e.getMessage());
	    }
	    return new BigDecimal(textoValor.replace(",", "."));
	}
	
    public void listenerTrocaUnidadeExterna(AjaxBehaviorEvent e) {
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTrocaUnidadeExterna <<<<<<<<<<<");
    		
    		getUnidadeExternaVO().setBancocorr(null);
    		getUnidadeExternaVO().setImunintlcmbio(null);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTrocaUnidadeExterna <<<<<<<<<<<");
    	}
    }
    
    public void listenerTratarBancoAvisador(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarBancoAvisador <<<<<<<<<<<");
    		
    		getBancoAvisadorVO().setIbanqrcmbio(null);
    		getBancoAvisadorVO().setImunintlcmbio(null);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarBancoAvisador <<<<<<<<<<<");
    	}
    }
    
    
    public void listenerTratarReembolsador(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoBase.listenerTratarReembolsador <<<<<<<<<<<");
    		
    		getBancoReembolsadorVO().setIbanqrcmbio(null);
    		getBancoReembolsadorVO().setImunintlcmbio(null);
    		
    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoBase.listenerTratarReembolsador <<<<<<<<<<<");
    	}
    }
    
	public Integer getPassNumber() {
		return passNumber;
	}

	public void setPassNumber(Integer passNumber) {
		this.passNumber = passNumber;
	}

}
