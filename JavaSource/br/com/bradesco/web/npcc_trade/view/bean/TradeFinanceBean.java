package br.com.bradesco.web.npcc_trade.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.ITradeFinanceLogService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean.ListaHistoricoTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.ITradeFinanceMonitService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoInternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoVinculadaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ITradeFinanceNegociacaoService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.BeneficiarioVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaParcelasDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TaxasForfaitingVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.VincularOperacaoLcVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.IModeloBoletoService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ClausulasBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoBndesPosVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoBndesPreVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoNceVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.service.gcc.AnexarArquivoGccVO;
import br.com.bradesco.web.npcc_trade.service.gcc.ConnectorGcc;
import br.com.bradesco.web.npcc_trade.service.gcc.InfoDocumentoGccVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.DateTime;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumMomentoJuro;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPastasGcc;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitBaseBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitViewHelper;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoViewHelper;
import br.com.bradesco.web.npcc_trade.view.bean.global.anexarArquivoGccModal.AnexarArquivoGccModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.garantiasModal.GarantiasModalBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 *
 * Nome: TradeFinanceBean.java
 *
 * Propï¿½sito:
 * <p>
 * Bean com a funcionalidade de carregar dados bï¿½sicos em todas as telas Trade
 * Finance
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrï¿½o hexavision.
 */

@Named("tradeFinanceBean")
@SessionScoped
public class TradeFinanceBean extends TradeFinMonitBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /**
     * Objeto auxiliar da tela Monitor - Trade Finance
     */
    private TradeFinMonitViewHelper viewHelper = new TradeFinMonitViewHelper();
    private TradeFinanceNegociacaoViewHelper viewHelperNegoc = new TradeFinanceNegociacaoViewHelper();



	private TradeFinanceVO tradeFinanceVO = new TradeFinanceVO();
	private TradeFinanceVO tradeFinanceDiferencasVO = new TradeFinanceVO();
    private List<FluxoPagamentoVO> fluxoPgtList = new ArrayList<FluxoPagamentoVO>();
    private List<FluxoPagamentoVO> fluxoPgtListDiferencas = new ArrayList<FluxoPagamentoVO>();
    private FluxoPagamentoVO fluxoPgtVO = new FluxoPagamentoVO();
    private FluxoPagamentoVO fluxoPgtDiferencasVO = new FluxoPagamentoVO();
    private ComissaoInternaVO comissaoInternaVO = new ComissaoInternaVO();
    private ComissaoInternaVO comissaoInternaDiferencasVO = new ComissaoInternaVO();
    private ComissaoExternaVO comissaoExternaVO = new ComissaoExternaVO();
    private List<OperacaoVinculadaVO> oprVincList = new ArrayList<OperacaoVinculadaVO>();
    private List<OperacaoVinculadaVO> oprVincListDiferencas = new ArrayList<OperacaoVinculadaVO>();
    private List<TarifaVO> tarifaList = new ArrayList<TarifaVO>();
    private List<MercadoriaVO> mercadoriaList = new ArrayList<MercadoriaVO>();
    private List<MercadoriaVO> mercadoriaListDiferencas = new ArrayList<MercadoriaVO>();
    private ComissaoCollection comissaoExtList = new ComissaoCollection();
    private ComissaoCollection comissaoExtListDiferencas = new ComissaoCollection();
    private List<ComissaoInternaVO> comissaoIntList = new ArrayList<ComissaoInternaVO>();
    private List<ComissaoInternaVO> comissaoIntListDiferencas = new ArrayList<ComissaoInternaVO>();
    private List<TradeFinanceDesembolsoVO> desembolsoVO = new ArrayList<TradeFinanceDesembolsoVO>();
    private CotacoesExternasVO cotacoesList = new CotacoesExternasVO();
    private CotacoesExternasVO cotacoesListDiferencas = new CotacoesExternasVO();
    private ListaCotacoesExternasVO listaCotacoes = new ListaCotacoesExternasVO();
    private String dataAtual;
    private List<SelectItem> moedaList = new ArrayList<SelectItem>();
    private TradeFinanceFiltroVO filtroVO = new TradeFinanceFiltroVO();
    private List<ListaDespesasVO> listaDespesas = new ArrayList<ListaDespesasVO>();
    private List<ListaDespesasVO> listaDespesasDiferencas = new ArrayList<ListaDespesasVO>();
	private List<ListaParcelasDesembolsoVO> parcelaDesembList = new ArrayList<ListaParcelasDesembolsoVO>();
    private List<ListaParcelasDesembolsoVO> parcelaDesembListDiferencas = new ArrayList<ListaParcelasDesembolsoVO>();
    private ResponsavelDespesaVO responsavelDespList = new ResponsavelDespesaVO();
    private ResponsavelDespesaVO responsavelDespListDiferencas = new ResponsavelDespesaVO();
    private BeneficiarioVO beneficiario = new BeneficiarioVO();
    private BeneficiarioVO beneficiarioDiferencas = new BeneficiarioVO();
    private BeneficiarioVO afiancado = new BeneficiarioVO();
    private BeneficiarioVO afiancadoDiferencas = new BeneficiarioVO();
    private ListaResponsavelDespesaVO despSelecionado = new ListaResponsavelDespesaVO();
    private boolean libor = false;
    private boolean fluxo = false;
    private boolean meMn = false;
    private boolean liborDiferencas = false;
    private boolean fluxoDiferencas = false;
    private boolean meMnDiferencas = false;
    /** CHECKBOX GARANTIAS **/
    private boolean indeterminado = false;

    private Integer habibitaGerarBoleto = 0;

	/** Usado na aprovação banqueiro (Finimp Eca, Lc e garantia) **/
    private Integer cindcdaprovbanq = 0;

    private TradeFinanceVO dadosCliProdOperVincFromFecharLCVO = new TradeFinanceVO();

    /** Lista o Historico de tarifas **/
    private List<ListaHistoricoTarifaVO> listaHistTarif = new ArrayList<ListaHistoricoTarifaVO>();

    private List<ListaHistoricoTarifaVO> listaHistTarifDiferencas = new ArrayList<ListaHistoricoTarifaVO>();

    /**
     * Lista de EMAIL anexos.
     */
    private List<InfoDocumentoGccVO> listaEmailAnexos = new ArrayList<InfoDocumentoGccVO>();

    /**
     * Lista de EMAIL anexos.
     */
    private List<InfoDocumentoGccVO> listaDocsAnexos = new ArrayList<InfoDocumentoGccVO>();


    protected List<SelectItem> comboProduto;

    protected List<TaxasForfaitingVO> quadroOperacaoForfaiting = new ArrayList<TaxasForfaitingVO>();
    protected List<TaxasForfaitingVO> quadroOperacaoForfaitingDiferencas = new ArrayList<TaxasForfaitingVO>();

	/** Variavel utilizada para vincular uma operação a uma LC Importação*/
    private VincularOperacaoLcVO vincularOperacaoLcVO = new VincularOperacaoLcVO();

    /** INDICADOR PARA MONTAR OBJETO VO ANTES / DEPOIS
     *  UTILIZADOS NAS TELAS DE DIFERENCAS DO LOG TRADE FINANCE
     *  "A" = ANTES
     *  "D" = DEPOIS   **/
    private String indicadorLogTradeFinanceAntesDepois = SiteUtil.STRING_D;

    @Inject
    @Named("tradeFinanceMonitService")
    private ITradeFinanceMonitService tradeFinanceMonitService;

    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;

    @Inject
    @Named("garantiasModalBean")
    private GarantiasModalBean garantiasModalBean;

    @Inject
    @Named("modeloBoletoService")
    private IModeloBoletoService modeloBoletoService;

    @Inject
    @Named("tradeFinanceLogService")
    private ITradeFinanceLogService tradeFinanceLogService;



    /**
     * Injeção do conector GCC.
     */
    @Inject
    private AnexarArquivoGccModalBean anexarArquivoGccModalBean;

    /**
     * Injeção do conector GCC.
     */
    @Inject
    private ConnectorGcc connectorGcc;

    @Override
    public String iniciar() {
        return null;
    }

    /**
     *
     * Nome: obterDadosBasicos
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void obterDadosBasicos(TradeFinanceListaVO operacao, Integer funcao) {
    	
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceBean.obterDadosBasicos <<<<<<<<<<<");

            viewHelper = new TradeFinMonitViewHelper();

            // A consulta do log deve usar o mesmo parametro de pesquisa da consulta do monitor
            Integer funcaoConsulta = (funcao.equals(ConstantesTradeFinance.FUNC_CONSULTAR_LOG) ?
                            ConstantesTradeFinance.FUNC_CONSULTAR : funcao);

            // Carrega o produto Forfaiting do Fluxo NPCCIAPJ e NPCCIATR
            if (operacao.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            		setTradeFinanceVO(tradeFinanceMonitService.obterDadosBasicosForFaiting(operacao, funcaoConsulta));
            		tradeFinanceMonitService.obterDesembolsoForFaiting(operacao, getTradeFinanceVO(),
            				operacao.getHinclreghist());
            	}else {
            		setTradeFinanceDiferencasVO(tradeFinanceMonitService.obterDadosBasicosForFaiting(operacao, funcaoConsulta));
            		tradeFinanceMonitService.obterDesembolsoForFaiting(operacao, getTradeFinanceDiferencasVO(),
            				operacao.getHinclreghist());
            	}

            	// verifica antes/depois
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            		carregarQuadroJurosForfaiting();
            	}else {
            		carregarQuadroJurosForfaitingDiferencas();
				}

            // Carrega os produtos que não é FORFAITING
            } else {
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            		setTradeFinanceVO(tradeFinanceMonitService.obterDadosBasicos(operacao, funcaoConsulta));
            		try {
            			Double liborTravada = Double.parseDouble(tradeFinanceVO.getVtravaliborcmbio().replace(',', '.'));
            			if(liborTravada.equals(0.0)) {
            				viewHelper.setRenderValorLiborTravada(false);
            			}
            			else {
            				viewHelper.setRenderValorLiborTravada(true);
            			}
            		}
            		catch (Exception e) {
            			viewHelper.setRenderValorLiborTravada(true);
					}
            	}else {
            		setTradeFinanceDiferencasVO(tradeFinanceMonitService.obterDadosBasicos(operacao, funcaoConsulta));
				}
            }

            if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            // Aline 29/09/2016 - Para todos os produtos inclusive o forfaiting que trará as observações.
            	getTradeFinanceVO().setObsCotacaoVO(tradeFinanceMonitService.obterDadosBasicosCompl(operacao));
            }else {
            	getTradeFinanceDiferencasVO().setObsCotacaoVO(tradeFinanceMonitService.obterDadosBasicosCompl(operacao));
			}

            if (!operacao.getProduto().isBndesPos() && !operacao.getProduto().isBndesPre()  && !operacao.getProduto().equals(EnumProduto.PROEX)) {

                if (!operacao.getProduto().isGarantia()&& !operacao.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
                		setOprVincList(tradeFinanceMonitService.obterOperacaoVinculada(operacao.getNbletonegoccmbio(), operacao.getHinclreghist()));
                	}else {
                		setOprVincListDiferencas(tradeFinanceMonitService.obterOperacaoVinculada(operacao.getNbletonegoccmbio(), operacao.getHinclreghist()));
					}
                    if (!operacao.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                    	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
                    		setFluxoPgtList(tradeFinanceMonitService.obterFluxoPgtList(operacao.getNbletonegoccmbio(), tradeFinanceVO.getHinclreghist()));
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
                    		for (int i = 0; i < getFluxoPgtList().size(); i++) {
                    			String index = Integer.toString(i);
	                    		viewHelper.setFluxoPgtSelecionado(index);
	                    		getFluxoPgtVO().setLista(null);
	                    		detalharFluxoPgt2();
							}
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO

                    	}else {
                    	    setFluxoPgtListDiferencas(tradeFinanceMonitService.obterFluxoPgtList(operacao.getNbletonegoccmbio(), tradeFinanceVO.getHinclreghist()));
                    	}
                        viewHelper.setFluxoPgtSelecionado("0");
                        detalhesFluxoPgtRadio(null);
                    }

                }

                if (!operacao.getProduto().isGarantia()){
                	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
                		setMercadoriaList(tradeFinanceMonitService.obterMercadoria(operacao.getNbletonegoccmbio(), operacao.getHinclreghist()));
                	}else {
                		setMercadoriaListDiferencas(tradeFinanceMonitService.obterMercadoria(operacao.getNbletonegoccmbio(), operacao.getHinclreghist()));
                	}

                }

                if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
                	setComissaoExtList(tradeFinanceMonitService.obterComissaoExterna(operacao.getNbletonegoccmbio(), operacao.getHinclreghist()));
                }else {
                	setComissaoExtListDiferencas(tradeFinanceMonitService.obterComissaoExterna(operacao.getNbletonegoccmbio(), operacao.getHinclreghist()));
				}

                if(funcao.equals(ConstantesTradeFinance.FUNC_CONSULTAR_LOG)) {
                	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
                		setListaHistTarif(tradeFinanceLogService.obterHistoricoTarifaLog(operacao));
                	}else {
                		setListaHistTarifDiferencas(tradeFinanceLogService.obterHistoricoTarifaLog(operacao));
					}
                } else {
                    setTarifaList(tradeFinanceMonitService.obterTarifa(operacao.getNbletonegoccmbio()));
                }

                setMoedaList(selectItemBean.getMoeda());
            }

            if (!operacao.getProduto().isNce() && !operacao.getProduto().isBndesPos()
                            && !operacao.getProduto().isBndesPre() && !operacao.getProduto().equals(EnumProduto.PROEX)
                            && !operacao.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)){
				
            	// Por: Cláudio Tadeu em: 03/10/2019 - IN ??? - Está ocorrendo inconsistência nos percentuais de comissão interna.
            	// Necessário diferenciar as rotinas, pois se a chamada ao detalharFluxoPgt2 existir causa problema 
            	// no percentual de comissão interna na tela da Divisão Internaciona, mas se não existir causa problema
            	// na lista de Desembolso no bloco de Comissão Interna na tela deImprimirdo botão Gerar Boleto da tela 
            	// do Monitor/Trade Finance.
            	if(funcao == ConstantesTradeFinance.FUNC_GERAR_BOLETO) {
                	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
                		setComissaoIntList(tradeFinanceMonitService.obterComissaoInterna(operacao.getNbletonegoccmbio(), 
    							operacao.getHinclreghist(), getTradeFinanceVO().getVtxspreadtot()));
                    	detalharFluxoPgt2();
                	}else {
                		setComissaoIntListDiferencas(tradeFinanceMonitService.obterComissaoInterna(operacao.getNbletonegoccmbio(),
    							operacao.getHinclreghist(), getTradeFinanceVO().getVtxspreadtot()));
    				}
            	} else {
                	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
                		setComissaoIntList(tradeFinanceMonitService.obterComissaoInterna(operacao.getNbletonegoccmbio(), 
    							operacao.getHinclreghist(), getTradeFinanceVO().getVtxspreadtot()));
                	}else {
                		setComissaoIntListDiferencas(tradeFinanceMonitService.obterComissaoInterna(operacao.getNbletonegoccmbio(),
    							operacao.getHinclreghist(), getTradeFinanceVO().getVtxspreadtot()));
    				}
            	}
            	// *****
            		
			// Por: Cláudio Tadeu em: 03/10/2019 - IN ??? - Está ocorrendo inconsistência nos percentuais de comissão interna.
			} else {
        		setComissaoIntList(null);
        		setComissaoIntList(new ArrayList<ComissaoInternaVO>());
            }
        	// *****
            
            if(funcao.equals(ConstantesTradeFinance.FUNC_DUPLICAR)){
                getTradeFinanceVO().setCeconmmoedalim(null);
                getTradeFinanceVO().setVmoedalimgerc(null);
                getTradeFinanceVO().setNseqcontrlim(null);
                getTradeFinanceVO().setNppstapontucmbio(null);
                getTradeFinanceVO().setVtxspreadaprov(null);
            }

            // Houve uma alteração no book de entrada do NPCCWYDE e NPCCWYAE, com a inserção do campo cindcdaprovbanq
            // onde quando for 1 é referente a tela do aprovar banqueiro e fora dessa tela informa o código 2.
            if(funcao.equals(ConstantesTradeFinance.FUNC_APROVAR_CTC)) {
                cindcdaprovbanq = Numeros.UM;
            }else {
                cindcdaprovbanq = Numeros.DOIS;
            }

            if (operacao.getProduto().equals(EnumProduto.FINIMP_ECA)
                            || operacao.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
	            	setCotacoesList(null);
	                listaDespesas.clear();
	                setCotacoesList(tradeFinanceMonitService.obterCotacoesExternas(operacao.getNbletonegoccmbio(), operacao.getHinclreghist(), cindcdaprovbanq));
            	}else {
            		setCotacoesListDiferencas(null);
                    listaDespesasDiferencas.clear();
                	setCotacoesListDiferencas(tradeFinanceMonitService.obterCotacoesExternas(operacao.getNbletonegoccmbio(), operacao.getHinclreghist(), cindcdaprovbanq));
				}

                montaTabelaListaDespesa(null);
            }

            if (operacao.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            		setParcelaDesembList(tradeFinanceMonitService.obterParcelasDesembolso(operacao, operacao.getHinclreghist()));
            	}else {
            		setParcelaDesembListDiferencas(tradeFinanceMonitService.obterParcelasDesembolso(operacao, operacao.getHinclreghist()));
            	}
            }

            if (operacao.getProduto().isGarantia()) {

                listaDespesasDiferencas.clear();

            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
	                listaDespesas.clear();
	                setResponsavelDespList(null);
	                setBeneficiario(null);
	                setAfiancado(null);
	                setResponsavelDespList(tradeFinanceMonitService.obterResponsavelDespesas(operacao.getNbletonegoccmbio(), operacao.getHinclreghist(), cindcdaprovbanq));
            	}else {
            		listaDespesasDiferencas.clear();
                    setResponsavelDespListDiferencas(null);
                    setBeneficiarioDiferencas(null);
                    setAfiancadoDiferencas(null);
                	setResponsavelDespListDiferencas(tradeFinanceMonitService.obterResponsavelDespesas(operacao.getNbletonegoccmbio(), operacao.getHinclreghist(), cindcdaprovbanq));
            	}

                // Validação necessária, pois se no serviço de Resposanvel despesa vir o codigo do beneficiario 0 não deverá entrar no serviço
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            		if(getResponsavelDespList().getCunicpssoabnf() != Numeros.ZERO) {
	                    setBeneficiario(tradeFinanceMonitService.obterConsBenefAfianc(getResponsavelDespList().getCunicpssoabnf(), 1, getTradeFinanceVO().getCpssoajurid(), tradeFinanceVO ));
	                }
            	}else {
            		if(getResponsavelDespListDiferencas().getCunicpssoabnf() != Numeros.ZERO) {
                		setBeneficiarioDiferencas(tradeFinanceMonitService.obterConsBenefAfianc(getResponsavelDespListDiferencas().getCunicpssoabnf(), 1, getTradeFinanceDiferencasVO().getCpssoajurid(), tradeFinanceDiferencasVO ));
                	}
				}

                // Validação necessária, pois se no serviço de Resposanvel despesa vir o codigo do afiançador 0 não deverá entrar no serviço
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            		if(getResponsavelDespList().getCunicpssoaafi() != Numeros.ZERO) {
	                    Integer flagConsGarantia =  3;
	                    setAfiancado(tradeFinanceMonitService.obterConsBenefAfianc(getResponsavelDespList().getCunicpssoaafi(), flagConsGarantia, getTradeFinanceVO().getCpssoajurid(), tradeFinanceVO));
	                }
            	}else {
            		if(getResponsavelDespListDiferencas().getCunicpssoaafi() != Numeros.ZERO) {
                		Integer flagConsGarantia =  3;
                    	setAfiancadoDiferencas(tradeFinanceMonitService.obterConsBenefAfianc(getResponsavelDespListDiferencas().getCunicpssoaafi(), flagConsGarantia, getTradeFinanceDiferencasVO().getCpssoajurid(), tradeFinanceDiferencasVO));
					}
				}

                obterCheckIndterminado();
            }

            // Chamada consulta ao GCC arquivos anexados.
            // GCC com problema de HARDWARE
            // Retomar a chamada quando serviço disponivel novamente
            if(!funcao.equals(ConstantesTradeFinance.FUNC_CONSULTAR_LOG)) {

                // carrega lista de emails anexos
                setListaEmailAnexos(consultarAnexos(listaEmailAnexos, EnumPastasGcc.EMAIL));

                // carrega lista de documentos anexos
                setListaDocsAnexos(consultarAnexos(listaDocsAnexos, EnumPastasGcc.DIVERSOS));

            }
            
        	// Por: Cláudio Tadeu em: 10/10/2019 - IN ??? - Está ocorrendo inconsistência nos percentuais de comissão interna.
        	// Necessário diferenciar as rotinas, pois se a chamada ao detalharFluxoPgt2 existir causa problema 
        	// no percentual de comissão interna na tela da Divisão Internaciona, mas se não existir causa problema
        	// na lista de Desembolso no bloco de Comissão Interna na tela deImprimirdo botão Gerar Boleto da tela 
        	// do Monitor/Trade Finance.
            // Pega o primeiro item da lista de comissões, retornada pelo mainframe.  
        	if(funcao != ConstantesTradeFinance.FUNC_GERAR_BOLETO) {
                viewHelper.setComissaoIntSelecionado("0");
                detalhesComissaoIntRadio(null);
        	}
        	// *****
            
            if (!operacao.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            		obterSwapSelecionados();
            	}else {
            		obterSwapSelecionadosDiferencas();
            	}
            }
            
//            /* RECUPERAR VALOR DA COMISSÃO PARA AGENTE FINANCEIRO E BANCO MANDATARIO */
//            if (operacao.getProduto().isBndesPos()) {
//            	calcularComissaoBndesPos();
//            }

            // Seta a hora da manutenção para o utilizar no Modal do Garantias
            tradeFinanceVO.setHinclreghist(operacao.getHinclreghist());

            if (operacao.getProduto().equals(EnumProduto.CCE_CEDULA_EXPORTACAO) ||
            	operacao.getProduto().equals(EnumProduto.CCE_CEDULA_EXPORTACAO_INDIRETO) ||
            	operacao.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
                getViewHelper().setRenderMercadoria(Boolean.FALSE);
            }

            if (tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Perdido") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Aguardando DSN") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Baixada") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Pendente complemento") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Pendente custo externo") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Pendente de unidade externa") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Recotar custo externo") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Devolvido") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Divergente") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Divergente div. Int.") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Divergência Devolvida") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Pendente – Desenquadrada") ||
        		tradeFinanceVO.getDsitbletocmbio().equalsIgnoreCase("Perdido – Desenquadrada") ||
        		tradeFinanceVO.getCsitbletoaprov() == Numeros.SETE || tradeFinanceVO.getCsitbletoaprov()== Numeros.NOVE) {
            	setHabibitaGerarBoleto(1);
			} else {
				setHabibitaGerarBoleto(0);
			}
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceBean.obterDadosBasicos <<<<<<<<<<<");
        }
    }

    /**
     * Nome: montaTabelaListaDespesa
     *
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 10/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void montaTabelaListaDespesa(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.montaTabelaListaDespesa <<<<<<<<<<<");
            if(tradeFinanceVO.getProduto().isGarantia()) {
                // Monta Tabela de despesa do Garantias
                despSelecionado = responsavelDespList.getListaDespesa().get(Integer.parseInt(getViewHelper().getBancoSelecionado()));

                if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
                	setListaDespesas(tradeFinanceMonitService.obterDespesas(despSelecionado.getCfndng(), tradeFinanceVO.getNbletonegoccmbio(), tradeFinanceVO.getHinclreghist()));
                }else {
                	setListaDespesasDiferencas(tradeFinanceMonitService.obterDespesas(despSelecionado.getCfndng(), tradeFinanceDiferencasVO.getNbletonegoccmbio(), tradeFinanceDiferencasVO.getHinclreghist()));
				}

            }else {
                if(ajaxBehaviorEvent == null){
                    getViewHelper().setBancoSelecionado("0");
                }

                if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
	                if(!cotacoesList.getListaCotacoes().isEmpty()){
	                    listaCotacoes = cotacoesList.getListaCotacoes().get(Integer.parseInt(getViewHelper().getBancoSelecionado()));
	                    setListaDespesas(tradeFinanceMonitService.obterDespesas(listaCotacoes.getCfndng(), tradeFinanceVO.getNbletonegoccmbio(), tradeFinanceVO.getHinclreghist()));
	                }
                }else {
                	if(!cotacoesListDiferencas.getListaCotacoes().isEmpty()){
                		listaCotacoes = cotacoesListDiferencas.getListaCotacoes().get(Integer.parseInt(getViewHelper().getBancoSelecionado()));
	                    setListaDespesasDiferencas(tradeFinanceMonitService.obterDespesas(listaCotacoes.getCfndng(), tradeFinanceDiferencasVO.getNbletonegoccmbio(), tradeFinanceDiferencasVO.getHinclreghist()));
	                }
				}
            }



        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.montaTabelaListaDespesa <<<<<<<<<<<");
        }

    }

    /**
     *
     * Nome: detalhesFluxoPgtRadio
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void detalhesFluxoPgtRadio(AjaxBehaviorEvent ajaxBehaviorEvent) {
        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalhesFluxoPgtRadio <<<<<<<<<<<");

            if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
	            if (fluxoPgtList.size() > 0 && !SiteUtil.isEmptyOrNull(viewHelper.getFluxoPgtSelecionado())) {
	                setFluxoPgtVO(fluxoPgtList.get(SiteUtil.getInt(viewHelper.getFluxoPgtSelecionado())));
	            }
            }else {
            	if (fluxoPgtListDiferencas.size() > 0 && !SiteUtil.isEmptyOrNull(viewHelper.getFluxoPgtSelecionado())) {
            		setFluxoPgtDiferencasVO(fluxoPgtListDiferencas.get(SiteUtil.getInt(viewHelper.getFluxoPgtSelecionado())));
                }
            }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.detalhesFluxoPgtRadio <<<<<<<<<<<");
        }
    }

    /**
     *
     * Nome: detalhesComissaoIntRadio
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void detalhesComissaoIntRadio(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalhesComissaoIntRadio <<<<<<<<<<<");

            if (comissaoIntList.size() > 0) {
            	if(getIndicadorLogTradeFinanceAntesDepois().equals(SiteUtil.STRING_D)){
            		setComissaoInternaVO(comissaoIntList.get(SiteUtil.getInt(viewHelper.getComissaoIntSelecionado())));
            	}else {
            		setComissaoInternaDiferencasVO(comissaoIntList.get(SiteUtil.getInt(viewHelper.getComissaoIntSelecionado())));
				}
            }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.detalhesComissaoIntRadio <<<<<<<<<<<");
        }

    }

    /**
     *
     * Nome: detalharFluxoPgt
     *
     * Propï¿½sito: Detalhar fluxo de desembolso selecionado
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void detalharFluxoPgt2() {
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalharFluxoPgt <<<<<<<<<<<");

    		// valida se foi selecionado um item na lista
    		if (SiteUtil.isEmptyOrNull(viewHelper.getFluxoPgtSelecionado())) {
    			BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		} else if (fluxoPgtList.size() > 0) {
    			FluxoPagamentoVO pagamentoVO = new FluxoPagamentoVO();
    			if (getFluxoPgtVO().getLista() == null || getFluxoPgtVO().getLista().isEmpty()) {
                    pagamentoVO = fluxoPgtList.get(SiteUtil.getInt(viewHelper.getFluxoPgtSelecionado()));
                    pagamentoVO = tradeFinanceMonitService.obterFluxoPgtDet(pagamentoVO, tradeFinanceVO.getNbletonegoccmbio(), tradeFinanceVO.getHinclreghist());
				}

                if (getFluxoPgtVO().getLista() == null || getFluxoPgtVO().getLista().isEmpty()) {
                	getFluxoPgtVO().setLista(pagamentoVO.getLista());
				}

                if (comissaoIntList != null) {
                	ComissaoInternaVO comissaoInternaVO = new ComissaoInternaVO();
                	for (int i = 0; i < comissaoIntList.size(); i++) {
                    	viewHelper.setComissaoIntSelecionado(String.valueOf(i));
                        comissaoInternaVO = comissaoIntList.get(SiteUtil.getInt(viewHelper.getComissaoIntSelecionado()));
                        getComissaoIntList().get(i).setLista(tradeFinanceMonitService.comissaoInternaDet(tradeFinanceVO.getNbletonegoccmbio(), comissaoInternaVO.getNcomisintrntrade(), tradeFinanceVO.getHinclreghist()));
					}
				}
                ordenarListaParcelasFluxoPgto(getFluxoPgtVO().getLista());
            }
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceBean.detalharFluxoPgt <<<<<<<<<<<");
        }
    }

    /**
     *
     * Nome: detalharFluxoPgt
     *
     * Propï¿½sito: Detalhar fluxo de desembolso selecionado
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void detalharFluxoPgt(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalharFluxoPgt <<<<<<<<<<<");

    		// valida se foi selecionado um item na lista
    		if (SiteUtil.isEmptyOrNull(viewHelper.getFluxoPgtSelecionado())) {
    			BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		} else if (fluxoPgtList.size() > 0) {
    			if (getFluxoPgtVO().getLista() == null || getFluxoPgtVO().getLista().isEmpty()) {
                    FluxoPagamentoVO pagamentoVO = fluxoPgtList.get(SiteUtil.getInt(viewHelper.getFluxoPgtSelecionado()));
                    pagamentoVO = tradeFinanceMonitService.obterFluxoPgtDet(pagamentoVO,
                                    tradeFinanceVO.getNbletonegoccmbio(), tradeFinanceVO.getHinclreghist());
				}
                ordenarListaParcelasFluxoPgto(getFluxoPgtVO().getLista());

                viewHelper.setRenderModalFluxoPgt(true);
            }
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.detalharFluxoPgt <<<<<<<<<<<");
        }

    }

    /**
     * Nome: ordenarListaParcelasFluxoPgto
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void ordenarListaParcelasFluxoPgto(List<FluxoPagamentoVO> listaParcelasFluxoPgto) {
        int numParcela = 1;

        Collections.sort(listaParcelasFluxoPgto);

        numParcela = 1;
        for (FluxoPagamentoVO item : listaParcelasFluxoPgto) {
            item.setNpceladsembtrade(numParcela++);
        }
    }

    /**
     *
     * Nome: paginarFluxoPgt
     *
     * Propï¿½sito: Paginar fluxo de desembolso selecionado
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void paginarFluxoPgt(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.paginarFluxoPgt <<<<<<<<<<<");

            FluxoPagamentoVO pagamentoVO = fluxoPgtList.get(SiteUtil.getInt(viewHelper.getFluxoPgtSelecionado()));
            pagamentoVO = tradeFinanceMonitService.obterFluxoPgtDet(pagamentoVO,
                            tradeFinanceVO.getNbletonegoccmbio(), tradeFinanceVO.getHinclreghist());

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.paginarFluxoPgt <<<<<<<<<<<");
        }

    }

    /**
     *
     * Nome: detalharComissaoInterna
     *
     * Propï¿½sito: Detalhar a Comissao Interna selecionada
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void detalharComissaoInterna(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalharComissaoInterna <<<<<<<<<<<");

    		// valida se foi selecionado um item na lista
    		if (SiteUtil.isEmptyOrNull(viewHelper.getComissaoIntSelecionado())) {
    			BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}else if (comissaoIntList.size() > 0) {
                ComissaoInternaVO internaVO = comissaoIntList.get(SiteUtil.getInt(viewHelper.getComissaoIntSelecionado()));
                getComissaoInternaVO().setLista(
                                tradeFinanceMonitService.comissaoInternaDet(tradeFinanceVO.getNbletonegoccmbio(),
                                                internaVO.getNcomisintrntrade(), tradeFinanceVO.getHinclreghist()));
                getComissaoInternaVO().setQtdepcela(getComissaoInternaVO().getLista().size());
                viewHelper.setRenderModalComissaoInt(true);
            }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.detalharComissaoInterna <<<<<<<<<<<");
        }

    }

    /**
     *
     * Nome: paginarComissaoInterna
     *
     * Propï¿½sito: Paginar Comissao Interna selecionada
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void paginarComissaoInterna(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.paginarComissaoInterna <<<<<<<<<<<");

            ComissaoInternaVO internaVO = comissaoIntList.get(SiteUtil.getInt(viewHelper.getComissaoIntSelecionado()));
            getComissaoInternaVO().setLista(
                            tradeFinanceMonitService.comissaoInternaDet(tradeFinanceVO.getNbletonegoccmbio(),
                                            internaVO.getNcomisintrntrade(), tradeFinanceVO.getHinclreghist()));

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.paginarComissaoInterna <<<<<<<<<<<");
        }

    }

    /**
     *
     * Nome: detalharComissaoExterna
     *
     * Propósito: Detalhar Comissao Externa selecionada
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void detalharComissaoExterna(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalharComissaoExterna <<<<<<<<<<<");

    		// valida se foi selecionado um item na lista
    		if (SiteUtil.isEmptyOrNull(viewHelper.getComissaoExtSelecionado())) {

    		    BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
    			return;
    		}

    		else if (comissaoExtList.size() > 0) {

                setComissaoExternaVO((ComissaoExternaVO) comissaoExtList.get(
                        SiteUtil.getInt(viewHelper.getComissaoExtSelecionado()), EnumTipoComissao.ADICIONAL));

                getComissaoExternaVO().setLista(
                                tradeFinanceMonitService.comissaoExternaDet(tradeFinanceVO.getNbletonegoccmbio(),
                                                getComissaoExternaVO().getncomisextertrade(),
                                                tradeFinanceVO.getHinclreghist()));

                viewHelper.setRenderModalComissaoExt(true);
            }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.detalharComissaoExterna <<<<<<<<<<<");
        }
    }

    /**
     *
     * Nome: detalharComissaoBanqueiro
     *
     * Propósito: Detalhar Comissao Banqueiro selecionada
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void detalharComissaoBanqueiro(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalharComissaoBanqueiro <<<<<<<<<<<");

            // valida se foi selecionado um item na lista
            if (SiteUtil.isEmptyOrNull(viewHelper.getComissaoBanqueiroSelecionado())) {

                BradescoFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;
            }

            else if (comissaoExtList.size() > 0) {

                setComissaoExternaVO((ComissaoExternaVO) comissaoExtList.get(
                        SiteUtil.getInt(viewHelper.getComissaoBanqueiroSelecionado()), EnumTipoComissao.BANQUEIRO));

                getComissaoExternaVO().setLista(
                                tradeFinanceMonitService.comissaoExternaDet(tradeFinanceVO.getNbletonegoccmbio(),
                                                getComissaoExternaVO().getncomisextertrade(),
                                                tradeFinanceVO.getHinclreghist()));

                viewHelper.setRenderModalComissaoBanqueiro(true);
            }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceBean.detalharComissaoBanqueiro <<<<<<<<<<<");
        }
    }

    /**
     *
     * Nome: detalharComissaoExterna
     *
     * Propï¿½sito: Detalhar Comissao Externa selecionada
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void paginarComissaoExterna(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.paginarComissaoExterna <<<<<<<<<<<");

            setComissaoExternaVO((ComissaoExternaVO)comissaoExtList.get(SiteUtil.getInt(viewHelper.getComissaoExtSelecionado())));
            getComissaoExternaVO().setLista(
                            tradeFinanceMonitService.comissaoExternaDet(tradeFinanceVO.getNbletonegoccmbio(),
                                            getComissaoExternaVO().getncomisextertrade(),
                                            tradeFinanceVO.getHinclreghist()));

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.paginarComissaoExterna <<<<<<<<<<<");
        }

    }

    /**
     *
     * Nome: obterSwapSelecionados
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    private void obterSwapSelecionados() {

        // 1- TRUE 2 - FALSE;

        if (tradeFinanceVO.getCindcdnegoclibor().equals("1")) {
            libor = Boolean.TRUE;

        } else if (tradeFinanceVO.getCindcdnegoclibor().equals("2")) {
            libor = Boolean.FALSE;

        }
        if (tradeFinanceVO.getCnegocswapfluxo().equals("1")) {
            fluxo = Boolean.TRUE;

        } else if (tradeFinanceVO.getCnegocswapfluxo().equals("2")) {
            fluxo = Boolean.FALSE;

        }
        if (tradeFinanceVO.getCnegocswapestrg().equals("1")) {
            meMn = Boolean.TRUE;

        } else if (tradeFinanceVO.getCnegocswapestrg().equals("2")) {
            meMn = Boolean.FALSE;
        }
    }

    private void obterSwapSelecionadosDiferencas() {

        // 1- TRUE 2 - FALSE;

        if (tradeFinanceDiferencasVO.getCindcdnegoclibor().equals("1")) {
            setLiborDiferencas(Boolean.TRUE);

        } else if (tradeFinanceDiferencasVO.getCindcdnegoclibor().equals("2")) {
            setLiborDiferencas(Boolean.FALSE);

        }
        if (tradeFinanceDiferencasVO.getCnegocswapfluxo().equals("1")) {
            setFluxoDiferencas(Boolean.TRUE);

        } else if (tradeFinanceDiferencasVO.getCnegocswapfluxo().equals("2")) {
            setFluxoDiferencas(Boolean.FALSE);

        }
        if (tradeFinanceDiferencasVO.getCnegocswapestrg().equals("1")) {
            setMeMnDiferencas(Boolean.TRUE);

        } else if (tradeFinanceDiferencasVO.getCnegocswapestrg().equals("2")) {
            setMeMnDiferencas(Boolean.FALSE);
        }
    }

    /**
     * Nome: obterCheckIndterminado
     *
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     * Registro  de Manutenção: 25/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void obterCheckIndterminado() {

        // 1- TRUE 2 - FALSE;

        if (tradeFinanceVO.getCnegoccmbioindmd().equals("1")) {
            setIndeterminado(Boolean.TRUE);

        } else if (tradeFinanceVO.getCnegoccmbioindmd().equals("2")) {
            setIndeterminado(Boolean.FALSE);
        }
    }

    /**
     *
     * Nome: getSelectItemRadioFluxoPgt
     *
     * Propï¿½sito: preencher lista auxiliar para selecao de flux de pagamentos na tela
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public List<SelectItem> getSelectItemRadioFluxoPgt() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getFluxoPgtList().size(); index++) {
            list.add(new SelectItem(index, ""));
        }
        return list;
    }

    /**
     *
     * Nome: getSelectItemComissaoInt
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public List<SelectItem> getSelectItemComissaoInt() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getComissaoIntList().size(); index++) {
            list.add(new SelectItem(index, ""));
        }
        return list;
    }

    /**
     * Nome: getSelectItemRadioDesp
     *
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 10/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioDesp() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getCotacoesList().getListaCotacoes().size(); index++) {
            list.add(new SelectItem(index, ""));
        }
        return list;
    }

    /**
     * Nome: getSelectItemRadioDespesa
     *
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     * Registro  de Manutenção: 16/08/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioDespesa() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getResponsavelDespList().getListaDespesa().size(); index++) {
            list.add(new SelectItem(index, ""));
        }
        return list;
    }


    /**
     *
     * Nome: getSelectItemComissaoExt
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public List<SelectItem> getSelectItemComissaoExt() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getComissaoExtList().getComissaoAdicional().size(); index++) {
            list.add(new SelectItem(index, ""));
        }
        return list;
    }

    /**
     *
     * Nome: getSelectItemComissaoExt
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public List<SelectItem> getSelectItemComissaoBanqueiro() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getComissaoExtList().getComissaoBanqueiro().size(); index++) {
            list.add(new SelectItem(index, ""));
        }
        return list;
    }

    /**
     *
     * Nome: fecharModalFLuxoPgt
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void fecharModalFLuxoPgt() {
        viewHelper.setRenderModalFluxoPgt(false);
    }

    /**
     *
     * Nome: fecharModalComissaoInt
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void fecharModalComissaoInt() {
        viewHelper.setRenderModalComissaoInt(false);
    }

    /**
     *
     * Nome: fecharModalComissaoExt
     *
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public void fecharModalComissaoExt() {
        viewHelper.setRenderModalComissaoExt(false);
        viewHelper.setRenderModalComissaoBanqueiro(false);
    }

    /**
     * Nome: getViewHelper
     *
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 03/05/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public TradeFinMonitViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * Nome: setViewHelper
     *
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 03/05/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public void setViewHelper(TradeFinMonitViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * Nome: detalharGarantias
     *
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 03/05/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public void detalharGarantias(AjaxBehaviorEvent event) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalharGarantias <<<<<<<<<<<");

            garantiasModalBean.setNcunicclicmbio(tradeFinanceVO.getNcunicclicmbio());
            garantiasModalBean.setDprodtservc(tradeFinanceVO.getDprodtservc());
            garantiasModalBean.setNbletonegoccmbio(tradeFinanceVO.getNbletonegoccmbio());
            garantiasModalBean.setNseqcontrlim(tradeFinanceVO.getNseqcontrlim());
            garantiasModalBean.setHinclreghist(tradeFinanceVO.getHinclreghist());

            garantiasModalBean.setNppstapontucmbio(tradeFinanceVO.getNppstapontucmbio());
            garantiasModalBean.setCcpfcnpj(tradeFinanceVO.getCpfcnpj());
            garantiasModalBean.setCflialcpfcnpj(tradeFinanceVO.getCflial());
            garantiasModalBean.setCctrlcpfcnpj(tradeFinanceVO.getCctrl());

            garantiasModalBean.openModal(null);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.detalharGarantias <<<<<<<<<<<");
        }

    }

    /**
     * Nome: detalharGarantiasInclusao
     *
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 03/05/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public void detalharGarantiasInclusao(AjaxBehaviorEvent event) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.detalharGarantiasInclusao <<<<<<<<<<<");

            garantiasModalBean.setNcunicclicmbio(tradeFinanceVO.getNcunicclicmbio());
            garantiasModalBean.setDprodtservc(tradeFinanceVO.getDprodtservc());
            garantiasModalBean.setNseqcontrlim(tradeFinanceVO.getNseqcontrlim());
            garantiasModalBean.openModalInclusao(null);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.detalharGarantiasInclusao <<<<<<<<<<<");
        }

    }

    /**
     * Nome: gerarBoleto
     *
     * Propï¿½sito: Carrega os dados do boleto e retorna a view
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    public String gerarBoleto() {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.gerarBoleto <<<<<<<<<<<");

            DadosBoletoVO dadosBoleto;

            // BNDES POS - Instancia para modelo de boleto BDES POS
            if(this.tradeFinanceVO.getProduto().isBndesPos()) {
                dadosBoleto = new DadosBoletoBndesPosVO();
            } else if(this.tradeFinanceVO.getProduto().isBndesPre()) {
                dadosBoleto = new DadosBoletoBndesPreVO();
            } else if(this.tradeFinanceVO.getProduto().isNce()) {
                dadosBoleto = new DadosBoletoNceVO();
            } else {
                dadosBoleto = new DadosBoletoVO();
            }

            // valida dados minimos
            if (tradeFinanceVO == null || SiteUtil.isEmptyOrNull(tradeFinanceVO.getCprodtservc())
                            || SiteUtil.isEmptyOrNull(tradeFinanceVO.getCmodcontrcmbio())) {
                NpcFacesUtils.addInfoModalMessage("Dados insulficiente para gerar o boleto.", false);
                return null;
            }

            // carrega dados básicos
            dadosBoleto.setDadosBasico(getTradeFinanceVO());

            // carrega template, titulo e subtitulo do boleto a partir do produto
            dadosBoleto.setTemplateAndCabecalho(tradeFinanceVO.getProduto());

            // seta data por Extenso no gerar boleto do BNDES POS
            if(this.tradeFinanceVO.getProduto().isBndesPos()){
				dadosBoleto.setDataPorExtenso(DateTime.inWords(SiteUtil.dataMainframeToWeb(tradeFinanceVO.getDinclreg().replace("/", "."))));
            }

            // carrega listas
            dadosBoleto.setComissaoExtList(getComissaoExtList());
            dadosBoleto.setComissaoIntList(getComissaoIntList());
            dadosBoleto.setMercadoriaList(getMercadoriaList());
            dadosBoleto.setTarifaList(getTarifaList());
            dadosBoleto.setFluxoPgtList(getFluxoPgtList());

            // carregar listas de garantias e avalistas
            garantiasModalBean.setNbletonegoccmbio(tradeFinanceVO.getNbletonegoccmbio());
            garantiasModalBean.setNseqcontrlim(tradeFinanceVO.getNseqcontrlim());
            garantiasModalBean.setHinclreghist(tradeFinanceVO.getHinclreghist());

            garantiasModalBean.setNppstapontucmbio(tradeFinanceVO.getNppstapontucmbio());
            garantiasModalBean.setCcpfcnpj(tradeFinanceVO.getCpfcnpj());
            garantiasModalBean.setCflialcpfcnpj(tradeFinanceVO.getCflial());
            garantiasModalBean.setCctrlcpfcnpj(tradeFinanceVO.getCctrl());

            garantiasModalBean.carregarGarantias();

            dadosBoleto.setGarantiaAdicionalList(garantiasModalBean.getListaGarantiasAdicionais());
            dadosBoleto.setGarantiasAprlmtList(garantiasModalBean.getListaGarantiasAprLmt());
            dadosBoleto.setGarantiasAprovList(garantiasModalBean.getListaGarantiasAprov());
            dadosBoleto.setGarantiasAvaList(garantiasModalBean.extrairListaGarantiasAvalistas());

            // Caso tenha mais de uma comissão Interna no gerar boleto carrega somente a primeira
            if (getComissaoIntList() != null && getComissaoIntList().size() > 0) {
                dadosBoleto.setPrimeiroItemLista(getComissaoIntList().get(Numeros.ZERO));
            }

            // Caso o produto for "Pré agamento de exportação" não mostrar o desembolso
            if (dadosBoleto.getDadosBasico().getCprodtservc().equals(1642)) {
                dadosBoleto.setRenderComissaInt(false);

            }
            
            // carrega detalhes dos fluxos de pagamentos
            for (FluxoPagamentoVO item : dadosBoleto.getFluxoPgtList()) {
                if (item.getLista() == null || item.getLista().size() == Numeros.ZERO) {
                    item = (tradeFinanceMonitService.obterFluxoPgtDet(item,
                                    tradeFinanceVO.getNbletonegoccmbio(), tradeFinanceVO.getHinclreghist()));

                    ordenarListaParcelasFluxoPgto(item.getLista());
                }
            }

            // monta clauslas do boleto
            montarClausulasBoleto(dadosBoleto);

            // Carrega Detalhes para Custos no Exterior pelo Desembolso
            if (this.tradeFinanceVO.getProduto().isGarantia()) {
                dadosBoleto.setRenderDadosBanqueiro(false);

                // lista de Responsaveis pelas despesas
                TradeFinanceListaVO operacao = new TradeFinanceListaVO();
                operacao.setNbletonegoccmbio(this.getTradeFinanceVO().getNbletonegoccmbio());
                ResponsavelDespesaVO responsavelDespesaVO = new ResponsavelDespesaVO();
                responsavelDespesaVO = tradeFinanceMonitService.obterResponsavelDespesas(operacao.getNbletonegoccmbio(), operacao.getHinclreghist(), cindcdaprovbanq);

                // Tenta identificar o registro que gerou a despesa (Tipo P)
                dadosBoleto.setRenderDadosBanqueiro(false);
                ListaResponsavelDespesaVO itemResponsavelDespesaVO = null;
                for (Iterator<ListaResponsavelDespesaVO> iterator = responsavelDespesaVO.getListaDespesa().iterator(); iterator.hasNext();) {
                    itemResponsavelDespesaVO = (ListaResponsavelDespesaVO) iterator.next();
                    dadosBoleto.setListaDespesasExteriorDesemb(tradeFinanceMonitService.obterDespesas(itemResponsavelDespesaVO.getCfndng(), this.getTradeFinanceVO().getNbletonegoccmbio(), operacao.getHinclreghist()));

                    /*
                     * Imprimir lista de despesas com UM resgistro idependente se foi aprovado ou não
                     * Se possuir mais de UM registro na lista imprimir somente se tiver aprovado
                     * Caso contrario não imprimir
                     */
                    if (dadosBoleto.getCotacoesListCustExt().getListaCotacoes().size() == Numeros.UM
                                    || itemResponsavelDespesaVO.getCindcdfndngutlzd().toUpperCase().equalsIgnoreCase(SiteUtil.STRING_P)) {

                        dadosBoleto.setRenderDadosBanqueiro(true);
                        dadosBoleto.setResponsavelDespesa(itemResponsavelDespesaVO);
                        List<ListaDespesasVO> listaDespesasExteriorDesemb =
                        		tradeFinanceMonitService.obterDespesas(itemResponsavelDespesaVO.getCfndng(),
                        												getTradeFinanceVO().getNbletonegoccmbio(),
                        												getTradeFinanceVO().getHinclreghist());
                        if(!listaDespesasExteriorDesemb.isEmpty()) {
                        	dadosBoleto.setListaDespesasExteriorDesemb(listaDespesasExteriorDesemb);
                        }

                    }
                }
            }

            // Carrega Detalhes para Custos no Exterior pela Emissão
            if (this.tradeFinanceVO.getProduto().equals(EnumProduto.LC_IMPORTACAO) ||
            		this.tradeFinanceVO.getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA) ||
        			this.tradeFinanceVO.getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO)) {
                dadosBoleto.setRenderDadosBanqueiro(false);

                // lista de Cotações Externas
                dadosBoleto.setCotacoesListCustExt(tradeFinanceMonitService.obterCotacoesExternas(
                                getTradeFinanceVO().getNbletonegoccmbio(),
                                getTradeFinanceVO().getHinclreghist(),
                                cindcdaprovbanq));

                // Tenta identificar o registro que gerou a despesa (Tipo P)
                dadosBoleto.setRenderDadosBanqueiro(false);
                ListaCotacoesExternasVO itemResponsavelDespesaVO = null;
                for (Iterator<ListaCotacoesExternasVO> iterator = dadosBoleto.getCotacoesListCustExt().getListaCotacoes().iterator(); iterator.hasNext();) {
                    itemResponsavelDespesaVO = (ListaCotacoesExternasVO) iterator.next();

                    /*
                     * Imprimir lista de despesas se possuir UM resgistro idependente se foi aprovado ou não
                     * Se possuir mais de UM registro na lista imprimir somente se tiver aprovado
                     * Caso contrario não imprimir
                     */
                    if (dadosBoleto.getCotacoesListCustExt().getListaCotacoes().size() == Numeros.UM
                                    || itemResponsavelDespesaVO.getCindcdfndngutlzd().toUpperCase().equalsIgnoreCase(SiteUtil.STRING_P)) {

                        dadosBoleto.setRenderDadosBanqueiro(true);
                        dadosBoleto.setResponsavelDespesaCustExt(itemResponsavelDespesaVO);
                        List<ListaDespesasVO> listaDespesasExteriorDesemb =
                        		tradeFinanceMonitService.obterDespesas(itemResponsavelDespesaVO.getCfndng(),
                        												getTradeFinanceVO().getNbletonegoccmbio(),
                        												getTradeFinanceVO().getHinclreghist());
                        if(!listaDespesasExteriorDesemb.isEmpty()) {
                        	dadosBoleto.setListaDespesasExteriorDesemb(listaDespesasExteriorDesemb);
                        }
                    }
                }

            }

            if (!SiteUtil.isEmptyOrNull(comissaoInternaVO.getDescrmomento())) {
                if (!SiteUtil.isEmptyOrNull(comissaoInternaVO.getDesccomisbleto())
                                && comissaoInternaVO.getDesccomisbleto().toUpperCase().equals("NÃO HÁ")) {
                    comissaoInternaVO.setDescrmomento("");
                } else {
                    comissaoInternaVO.setDescrmomento(EnumMomentoJuro.fromCode(comissaoInternaVO.getCmomencobrcmbio()).getDescricao());
                }
            } else {
                comissaoInternaVO.setDescrmomento(EnumMomentoJuro.fromCode(Numeros.ZERO).getDescricao());
            }

            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("dadosBoleto", dadosBoleto);

            return dadosBoleto.getTemplate();

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.gerarBoleto <<<<<<<<<<<");
        }

    }


    /**
     * Nome: montarClausulasBoleto
     *
     * Propï¿½sito: Monta clï¿½usulas do boleto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
    private void montarClausulasBoleto(DadosBoletoVO dadosBoleto) {

        // chama serviï¿½o para montar as clausulas do boleto
        ModeloBoletoVO modeloBoletoVO = new ModeloBoletoVO();
        modeloBoletoVO = modeloBoletoService.detalhar(tradeFinanceVO.getCmodcontrcmbio());

        // monta clauslas do boleto
        dadosBoleto.setClausulas(new ArrayList<ClausulasBoletoVO>());

        // percorre a lista de clausulas cadastradas para o modelo de boleto
        for (Iterator<ComboClausulaVO> iterator = modeloBoletoVO.getLista().iterator(); iterator.hasNext();) {
            ComboClausulaVO clausula = (ComboClausulaVO) iterator.next();

            ClausulasBoletoVO clausulasBoleto = new ClausulasBoletoVO(clausula.getCtpoclauscmbio());

            // verifica se tipo clausula jï¿½ inserido na lista
            int index = dadosBoleto.getClausulas().indexOf(clausulasBoleto);
            if (index == -1) {
                clausulasBoleto.getTipoClausula().setItpoclauscmbio(
                                dadosBoleto.getNextNumeroClausula() + clausula.getItpoclauscmbio());
                dadosBoleto.getClausulas().add(clausulasBoleto);
            } else {
                clausulasBoleto = dadosBoleto.getClausulas().get(index);
            }

            // inclui a clausula
            clausulasBoleto.getClausulas().add(clausula);
        }
    }

    /**
     * Nome: actionVoltar
     *
     * Propósito: Ação do botão voltar com base no parametro passado pela tela de origem
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 10/05/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionVoltar() {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.actionVoltar <<<<<<<<<<<");

            String result = getViewHelper().getPaginaOrigem();

            // retorna para o monitor caso não for informado tela de origem
            if (getViewHelper().getPaginaOrigem() == null) {
                result = "tradeFinMonitList";
            }

            // limpar variavel de retorno
            getViewHelper().setPaginaOrigem(null);

            return result;

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.actionVoltar <<<<<<<<<<<");
        }

    }

    /**
     * Nome: anexarEmail
     *
     * Propósito: Habilita/Desabilita modal de anexar e-mail
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void anexarEmail(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.anexarEmail <<<<<<<<<<<");

            anexarArquivoGccModalBean.getViewHelper().setTitleModal("Anexar E-mail");
            openModalAnexarArquivo(EnumPastasGcc.EMAIL);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.anexarEmail <<<<<<<<<<<");
        }

    }

    /**
     * Nome: anexarDocumentos
     *
     * Propósito: Habilita/Desabilita modal de anexar documentos
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void anexarDocumentos(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.anexarDocumentos <<<<<<<<<<<");

            anexarArquivoGccModalBean.getViewHelper().setTitleModal("Anexar Documento");
            openModalAnexarArquivo(EnumPastasGcc.DIVERSOS);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.anexarDocumentos <<<<<<<<<<<");
        }

    }

    /**
     * Nome: toggleModalAnexarEmail
     *
     * Propósito: Habilita/Desabilita modal de anexar e-mail
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModalAnexarArquivo(EnumPastasGcc pastaDestino) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.openModalAnexarArquivo <<<<<<<<<<<");

            AnexarArquivoGccVO parametros = new AnexarArquivoGccVO();

            // nome da pasta ano e mês
            String[] strData = tradeFinanceVO.getDinclreg().replace(".", "/").split("/");
            parametros.setAnoMes(strData[2] + strData[1]);

            // nome da pasta numero do boleto
            parametros.setNroBoleto(tradeFinanceVO.getNbletonegoccmbio().toString());

            // nome da pasta final
            parametros.setPasta(pastaDestino);

            // tipo de pessoa e CPF/CNPJ
            if (tradeFinanceVO.getCflial() == Numeros.ZERO) {
                parametros.setTipoPessoa(String.valueOf((Numeros.TRES)));
            } else {
                parametros.setTipoPessoa(String.valueOf(Numeros.SEIS));
            }
            parametros.setCpfCnpj(tradeFinanceVO.getCpfcnpj().toString());

            // set modal id
            anexarArquivoGccModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalAnexarEmail");

            // recarrega lista depois de anexar
            anexarArquivoGccModalBean.getViewHelper().setRecarregaLista(Boolean.TRUE);
            if (pastaDestino.equals(EnumPastasGcc.EMAIL)) {
                anexarArquivoGccModalBean.setListaAnexos(listaEmailAnexos);
            } else {
                anexarArquivoGccModalBean.setListaAnexos(listaDocsAnexos);
            }

            // abre modal para anexar arquivo
            anexarArquivoGccModalBean.openModal(parametros);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.openModalAnexarArquivo <<<<<<<<<<<");
        }

    }

    /**
     *
     * Nome: consultarAnexos
     *
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<InfoDocumentoGccVO> consultarAnexos(List<InfoDocumentoGccVO> listaAnexos, EnumPastasGcc pasta) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] TradeFinanceBean.consultarAnexos <<<<<<<<<<<");

            AnexarArquivoGccVO parametros = new AnexarArquivoGccVO();
            listaAnexos = new ArrayList<InfoDocumentoGccVO>();

            if (!SiteUtil.isEmptyOrNull(tradeFinanceVO.getDinclreg())
                    && !SiteUtil.isEmptyOrNull(tradeFinanceVO.getNbletonegoccmbio())) {

                // nome da pasta ano e mês
                String[] strData = tradeFinanceVO.getDinclreg().replace(".", "/").split("/");
                parametros.setAnoMes(strData[2] + strData[1]);

                // nome da pasta numero do boleto
                parametros.setNroBoleto(tradeFinanceVO.getNbletonegoccmbio().toString());

                // nome da pasta final
                parametros.setPasta(pasta);

                // consulta anexos GCC
                anexarArquivoGccModalBean.consultarAnexos(parametros, listaAnexos);
            }

            return listaAnexos;

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] TradeFinanceBean.consultarAnexos <<<<<<<<<<<");
        }

    }


    /**
     * Nome: actionConfirmarAprovar
     *
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     * Registro  de Manutenção: 05/08/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */

    public void actionConfirmarAprovar() {

        String result = SiteUtil.STRING_EMPTY;
        getViewHelper().setRenderFechar(false);
        Long cfndng = 0L;

        if(tradeFinanceVO.getProduto().isGarantia()) {

            if(getViewHelper().getBancoSelecionado().equals("")) {
                NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
                return;

            }else {

                despSelecionado = responsavelDespList.getListaDespesa().get(SiteUtil.getInt(getViewHelper().getBancoSelecionado()));
                cfndng = despSelecionado.getCfndng();
                result = tradeFinanceMonitService.aprovarBanqueiro(cfndng, tradeFinanceVO.getNbletonegoccmbio());
            }

        }else if(getViewHelper().getBancoSelecionado().equals("")) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            return;

        }else {
            listaCotacoes = cotacoesList.getListaCotacoes().get(SiteUtil.getInt(getViewHelper().getBancoSelecionado()));
            cfndng = listaCotacoes.getCfndng();
            result = tradeFinanceMonitService.aprovarBanqueiro(cfndng, tradeFinanceVO.getNbletonegoccmbio());
        }

        setIniciarPagina(false);

        BradescoFacesUtils.addInfoModalMessage(result, "#{tradeFinMonitBean.retomarPesquisaMonit}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
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
     * Registro  de Manutenção: 05/08/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void validarForm(ActionEvent ae) {

        try {

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.paginarCotacao  <<<<<<<<<<<");

            // valida campos obrigatórios
            if (!SiteUtil.validarCampos("formTradeFinMonitDet")) {

                viewHelper.setRenderFechar(Boolean.TRUE);
            }

            viewHelper.setRenderFechar(Boolean.TRUE);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.paginarCotacao  <<<<<<<<<<<");
        }

    }

    /**
     *
     * Nome: actionFecharModal
     *
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionFecharModal(ActionEvent ae) {
        viewHelper.setRenderFechar(Boolean.FALSE);
    }

    public void carregarQuadroJurosForfaiting() {
    	this.quadroOperacaoForfaiting = carregarDadosQuadroJurosForfaiting(quadroOperacaoForfaiting, getTradeFinanceBean().getTradeFinanceVO());
    }

    public void carregarQuadroJurosForfaitingDiferencas() {
    	this.quadroOperacaoForfaitingDiferencas = carregarDadosQuadroJurosForfaiting(quadroOperacaoForfaitingDiferencas, getTradeFinanceBean().getTradeFinanceDiferencasVO());
    }

    public List<TaxasForfaitingVO> carregarDadosQuadroJurosForfaiting(List<TaxasForfaitingVO> quadroOperacaoForfaiting, TradeFinanceVO tradeFinanceVO) {
        //Monta colunas com texto fixo
        if (quadroOperacaoForfaiting.size() < Numeros.SETE) {
            quadroOperacaoForfaiting = new ArrayList<TaxasForfaitingVO>();
            for (int i = 0; i < 7; i++) {
                quadroOperacaoForfaiting.add(new TaxasForfaitingVO());
            }
        }

        quadroOperacaoForfaiting.get(1).setInfoCol1("Valor");
        quadroOperacaoForfaiting.get(2).setInfoCol1("Prazo");
        quadroOperacaoForfaiting.get(3).setInfoCol1("Taxa");
        quadroOperacaoForfaiting.get(4).setInfoCol1("Taxa Descontada");

        if (getTradeFinanceBean().getTradeFinanceVO().getCtpojurotrade().equals(EnumTradeFinance.OPCAO_JUROS_EMBUTIDOS.getCodigo())) {
            quadroOperacaoForfaiting.get(0).setInfoCol1("FORFAITING COM JUROS EMBUTIDOS");
            quadroOperacaoForfaiting.get(0).setInfoCol2("");

            quadroOperacaoForfaiting.get(5).setInfoCol1("Valor dos juros a incluir no saque");
            quadroOperacaoForfaiting.get(6).setInfoCol1("Valor do saque total");
        }

        if (getTradeFinanceBean().getTradeFinanceVO().getCtpojurotrade().equals(EnumTradeFinance.OPCAO_JUROS_DEDUZIDOS.getCodigo())) {
            quadroOperacaoForfaiting.get(0).setInfoCol1("FORFAITING COM JUROS DEDUZIDOS");
            quadroOperacaoForfaiting.get(0).setInfoCol2("");


            quadroOperacaoForfaiting.get(5).setInfoCol1("Valor dos juros a descontar no saque");
            quadroOperacaoForfaiting.get(6).setInfoCol1("Valor descontado");
        }

        quadroOperacaoForfaiting.get(1).setInfoCol2(SiteUtil.formatarValorWeb(getTradeFinanceBean().getTradeFinanceVO().getVnegocmoedaestrg()));
        quadroOperacaoForfaiting.get(2).setInfoCol2(getTradeFinanceBean().getTradeFinanceVO().getTdiaopercmbio().toString());
        quadroOperacaoForfaiting.get(3).setInfoCol2(getTradeFinanceBean().getTradeFinanceVO().getTaxajuros());
        quadroOperacaoForfaiting.get(4).setInfoCol2(getTradeFinanceBean().getTradeFinanceVO().getTaxadescontada());
        quadroOperacaoForfaiting.get(5).setInfoCol2(SiteUtil.formatarValorWeb(getTradeFinanceBean().getTradeFinanceVO().getValorjuros()));
        quadroOperacaoForfaiting.get(6).setInfoCol2(SiteUtil.formatarValorWeb(getTradeFinanceBean().getTradeFinanceVO().getValorsaque()));
		return quadroOperacaoForfaiting;
    }

    public String actionExportar(){
        return super.actionExportar(true);
    }


    public TradeFinanceVO getTradeFinanceVO() {
        return tradeFinanceVO;
    }

    public void setTradeFinanceVO(TradeFinanceVO tradeFinanceVO) {
        this.tradeFinanceVO = tradeFinanceVO;
    }

    public List<FluxoPagamentoVO> getFluxoPgtList() {
        return fluxoPgtList;
    }

    public void setFluxoPgtList(List<FluxoPagamentoVO> fluxoPgtList) {
        this.fluxoPgtList = fluxoPgtList;
    }

    public FluxoPagamentoVO getFluxoPgtVO() {
        return fluxoPgtVO;
    }

    public void setFluxoPgtVO(FluxoPagamentoVO fluxoPgtVO) {
        this.fluxoPgtVO = fluxoPgtVO;
    }

    public ComissaoInternaVO getComissaoInternaVO() {
        return comissaoInternaVO;
    }

    public void setComissaoInternaVO(ComissaoInternaVO comissaoInternaVO) {
        this.comissaoInternaVO = comissaoInternaVO;
    }

    public ComissaoExternaVO getComissaoExternaVO() {
        return comissaoExternaVO;
    }

    public void setComissaoExternaVO(ComissaoExternaVO comissaoExternaVO) {
        this.comissaoExternaVO = comissaoExternaVO;
    }

    public List<OperacaoVinculadaVO> getOprVincList() {
        return oprVincList;
    }

    public void setOprVincList(List<OperacaoVinculadaVO> oprVincList) {
        this.oprVincList = oprVincList;
    }

    public List<TarifaVO> getTarifaList() {
        return tarifaList;
    }

    public void setTarifaList(List<TarifaVO> tarifaList) {
        this.tarifaList = tarifaList;
    }

    public List<MercadoriaVO> getMercadoriaList() {
        return mercadoriaList;
    }

    public void setMercadoriaList(List<MercadoriaVO> mercadoriaList) {
        this.mercadoriaList = mercadoriaList;
    }

    public ComissaoCollection getComissaoExtList() {
        return comissaoExtList;
    }

    public void setComissaoExtList(ComissaoCollection comissaoExtList) {
        this.comissaoExtList = comissaoExtList;
    }

    public List<ComissaoInternaVO> getComissaoIntList() {
        return comissaoIntList;
    }

    public void setComissaoIntList(List<ComissaoInternaVO> comissaoIntList) {
        this.comissaoIntList = comissaoIntList;
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public List<SelectItem> getMoedaList() {
        return moedaList;
    }

    public void setMoedaList(List<SelectItem> moedaList) {
        this.moedaList = moedaList;
    }

    public TradeFinanceFiltroVO getFiltroVO() {
        return filtroVO;
    }

    public void setFiltroVO(TradeFinanceFiltroVO filtroVO) {
        this.filtroVO = filtroVO;
    }

    public boolean isLibor() {
        return libor;
    }

    public void setLibor(boolean libor) {
        this.libor = libor;
    }

    public boolean isFluxo() {
        return fluxo;
    }

    public void setFluxo(boolean fluxo) {
        this.fluxo = fluxo;
    }

    public boolean isMeMn() {
        return meMn;
    }

    public void setMeMn(boolean meMn) {
        this.meMn = meMn;
    }

    /**
     * @return o valor do desembolsoVO
     */
    public List<TradeFinanceDesembolsoVO> getDesembolsoVO() {
        return desembolsoVO;
    }

    /**
     * @param desembolsoVO seta o novo valor para o campo desembolsoVO
     */
    public void setDesembolsoVO(List<TradeFinanceDesembolsoVO> desembolsoVO) {
        this.desembolsoVO = desembolsoVO;
    }

    /**
     * @return o valor do listaEmailAnexos
     */
    public List<InfoDocumentoGccVO> getListaEmailAnexos() {
        return listaEmailAnexos;
    }

    /**
     * @param listaEmailAnexos seta o novo valor para o campo listaEmailAnexos
     */
    public void setListaEmailAnexos(List<InfoDocumentoGccVO> listaEmailAnexos) {
        this.listaEmailAnexos = listaEmailAnexos;
    }

    /**
     * @return o valor do listaDocsAnexos
     */
    public List<InfoDocumentoGccVO> getListaDocsAnexos() {
        return listaDocsAnexos;
    }

    /**
     * @param listaDocsAnexos seta o novo valor para o campo listaDocsAnexos
     */
    public void setListaDocsAnexos(List<InfoDocumentoGccVO> listaDocsAnexos) {
        this.listaDocsAnexos = listaDocsAnexos;
    }
    /**
     * @return o valor do listaDespesas
     */
    public List<ListaDespesasVO> getListaDespesas() {
        return listaDespesas;
    }

    /**
     * @param listaDespesas seta o novo valor para o campo listaDespesas
     */
    public void setListaDespesas(List<ListaDespesasVO> listaDespesas) {
        this.listaDespesas = listaDespesas;
    }

    /**
     * @return o valor do cotacoesList
     */
    public CotacoesExternasVO getCotacoesList() {
        return cotacoesList;
    }

    /**
     * @param cotacoesList seta o novo valor para o campo cotacoesList
     */
    public void setCotacoesList(CotacoesExternasVO cotacoesList) {
        this.cotacoesList = cotacoesList;
    }

    /**
     * @return o valor do connectorGcc
     */
    public ConnectorGcc getConnectorGcc() {
        return connectorGcc;
    }

    /**
     * @param connectorGcc seta o novo valor para o campo connectorGcc
     */
    public void setConnectorGcc(ConnectorGcc connectorGcc) {
        this.connectorGcc = connectorGcc;
    }

    /**
     * @return o valor do parcelaDesembList
     */
    public List<ListaParcelasDesembolsoVO> getParcelaDesembList() {
        return parcelaDesembList;
    }

    /**
     * @param parcelaDesembList seta o novo valor para o campo parcelaDesembList
     */
    public void setParcelaDesembList(List<ListaParcelasDesembolsoVO> parcelaDesembList) {
        this.parcelaDesembList = parcelaDesembList;
    }

    /**
     * @return o valor do responsavelDespList
     */
    public ResponsavelDespesaVO getResponsavelDespList() {
        return responsavelDespList;
    }

    /**
     * @param responsavelDespList seta o novo valor para o campo responsavelDespList
     */
    public void setResponsavelDespList(ResponsavelDespesaVO responsavelDespList) {
        this.responsavelDespList = responsavelDespList;
    }

    /**
     * @return o valor do tradeFinanceMonitService
     */
    public ITradeFinanceMonitService getTradeFinanceMonitService() {
        return tradeFinanceMonitService;
    }

    /**
     * @param tradeFinanceMonitService seta o novo valor para o campo tradeFinanceMonitService
     */
    public void setTradeFinanceMonitService(ITradeFinanceMonitService tradeFinanceMonitService) {
        this.tradeFinanceMonitService = tradeFinanceMonitService;
    }

    /**
     * @return o valor do selectItemBean
     */
    public SelectItemBean getSelectItemBean() {
        return selectItemBean;
    }

    /**
     * @param selectItemBean seta o novo valor para o campo selectItemBean
     */
    public void setSelectItemBean(SelectItemBean selectItemBean) {
        this.selectItemBean = selectItemBean;
    }

    /**
     * @return o valor do garantiasModalBean
     */
    public GarantiasModalBean getGarantiasModalBean() {
        return garantiasModalBean;
    }

    /**
     * @param garantiasModalBean seta o novo valor para o campo garantiasModalBean
     */
    public void setGarantiasModalBean(GarantiasModalBean garantiasModalBean) {
        this.garantiasModalBean = garantiasModalBean;
    }

    /**
     * @return o valor do modeloBoletoService
     */
    public IModeloBoletoService getModeloBoletoService() {
        return modeloBoletoService;
    }

    /**
     * @param modeloBoletoService seta o novo valor para o campo modeloBoletoService
     */
    public void setModeloBoletoService(IModeloBoletoService modeloBoletoService) {
        this.modeloBoletoService = modeloBoletoService;
    }

    /**
     * @return o valor do anexarArquivoGccModalBean
     */
    public AnexarArquivoGccModalBean getAnexarArquivoGccModalBean() {
        return anexarArquivoGccModalBean;
    }

    /**
     * @param anexarArquivoGccModalBean seta o novo valor para o campo anexarArquivoGccModalBean
     */
    public void setAnexarArquivoGccModalBean(AnexarArquivoGccModalBean anexarArquivoGccModalBean) {
        this.anexarArquivoGccModalBean = anexarArquivoGccModalBean;
    }

    /**
     * @return o valor do beneficiario
     */
    public BeneficiarioVO getBeneficiario() {
        return beneficiario;
    }

    /**
     * @param beneficiario seta o novo valor para o campo beneficiario
     */
    public void setBeneficiario(BeneficiarioVO beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * @return o valor do afiancado
     */
    public BeneficiarioVO getAfiancado() {
        return afiancado;
    }

    /**
     * @param afiancado seta o novo valor para o campo afiancado
     */
    public void setAfiancado(BeneficiarioVO afiancado) {
        this.afiancado = afiancado;
    }

    /**
     * @return o valor do indeterminado
     */
    public boolean isIndeterminado() {
        return indeterminado;
    }

    /**
     * @param indeterminado seta o novo valor para o campo indeterminado
     */
    public void setIndeterminado(boolean indeterminado) {
        this.indeterminado = indeterminado;
    }

    /**
     * @return o valor do despSelecionado
     */
    public ListaResponsavelDespesaVO getDespSelecionado() {
        return despSelecionado;
    }

    /**
     * @param despSelecionado seta o novo valor para o campo despSelecionado
     */
    public void setDespSelecionado(ListaResponsavelDespesaVO despSelecionado) {
        this.despSelecionado = despSelecionado;
    }

    public void continuarConfirmar() {

    }

    /**
     * @return the comboProduto
     */
    public List<SelectItem> getComboProduto() {
        return comboProduto;
    }

    /**
     * @param comboProduto the comboProduto to set
     */
    public void setComboProduto(List<SelectItem> comboProduto) {
        this.comboProduto = comboProduto;
    }

    /**
     * @return o valor do quadroOperacaoForfaiting
     */
    public List<TaxasForfaitingVO> getQuadroOperacaoForfaiting() {
        return quadroOperacaoForfaiting;
    }

    /**
     * @param quadroOperacaoForfaiting seta o novo valor para o campo quadroOperacaoForfaiting
     */
    public void setQuadroOperacaoForfaiting(List<TaxasForfaitingVO> quadroOperacaoForfaiting) {
        this.quadroOperacaoForfaiting = quadroOperacaoForfaiting;
    }

    /**
     * @return o valor do listaHistTarif
     */
    public List<ListaHistoricoTarifaVO> getListaHistTarif() {
        return listaHistTarif;
    }

    /**
     * @param listaHistTarif seta o novo valor para o campo listaHistTarif
     */
    public void setListaHistTarif(List<ListaHistoricoTarifaVO> listaHistTarif) {
        this.listaHistTarif = listaHistTarif;
    }

    /**
     * @return o valor do tradeFinanceNegociacaoService
     */
    public ITradeFinanceNegociacaoService getTradeFinanceNegociacaoService() {
        return tradeFinanceNegociacaoService;
    }

    /**
     * @param tradeFinanceNegociacaoService seta o novo valor para o campo tradeFinanceNegociacaoService
     */
    public void setTradeFinanceNegociacaoService(ITradeFinanceNegociacaoService tradeFinanceNegociacaoService) {
        this.tradeFinanceNegociacaoService = tradeFinanceNegociacaoService;
    }

	public TradeFinanceVO getDadosCliProdOperVincFromFecharLCVO() {
		return dadosCliProdOperVincFromFecharLCVO;
	}

	public void setDadosCliProdOperVincFromFecharLCVO(TradeFinanceVO dadosCliProdOperVincFromFecharLCVO) {
		this.dadosCliProdOperVincFromFecharLCVO = dadosCliProdOperVincFromFecharLCVO;
	}

    public Integer getCindcdaprovbanq() {
        return cindcdaprovbanq;
    }

    public void setCindcdaprovbanq(Integer cindcdaprovbanq) {
        this.cindcdaprovbanq = cindcdaprovbanq;
    }

    /**
     * @return o valor do vincularOperacaoLcVO
     */
    public VincularOperacaoLcVO getVincularOperacaoLcVO() {
        return vincularOperacaoLcVO;
    }

    /**
     * @param vincularOperacaoLcVO seta o novo valor para o campo vincularOperacaoLcVO
     */
    public void setVincularOperacaoLcVO(VincularOperacaoLcVO vincularOperacaoLcVO) {
        this.vincularOperacaoLcVO = vincularOperacaoLcVO;
    }

    /**
     * @return recupera o ViewHelperNegoc
     */
    public TradeFinanceNegociacaoViewHelper getViewHelperNegoc() {
		return viewHelperNegoc;
	}

    /**
     * @param seta sViewHelperNegoc
     */
	public void setViewHelperNegoc(TradeFinanceNegociacaoViewHelper viewHelperNegoc) {
		this.viewHelperNegoc = viewHelperNegoc;
	}

	public String getIndicadorLogTradeFinanceAntesDepois() {
		return indicadorLogTradeFinanceAntesDepois;
	}

	public void setIndicadorLogTradeFinanceAntesDepois(
			String indicadorLogTradeFinanceAntesDepois) {
		this.indicadorLogTradeFinanceAntesDepois = indicadorLogTradeFinanceAntesDepois;
	}

	public TradeFinanceVO getTradeFinanceDiferencasVO() {
		return tradeFinanceDiferencasVO;
	}

	public void setTradeFinanceDiferencasVO(TradeFinanceVO tradeFinanceDiferencasVO) {
		this.tradeFinanceDiferencasVO = tradeFinanceDiferencasVO;
	}

    public List<TaxasForfaitingVO> getQuadroOperacaoForfaitingDiferencas() {
		return quadroOperacaoForfaitingDiferencas;
	}

	public void setQuadroOperacaoForfaitingDiferencas(
			List<TaxasForfaitingVO> quadroOperacaoForfaitingDiferencas) {
		this.quadroOperacaoForfaitingDiferencas = quadroOperacaoForfaitingDiferencas;
	}

	public List<ListaParcelasDesembolsoVO> getParcelaDesembListDiferencas() {
		return parcelaDesembListDiferencas;
	}

	public void setParcelaDesembListDiferencas(
			List<ListaParcelasDesembolsoVO> parcelaDesembListDiferencas) {
		this.parcelaDesembListDiferencas = parcelaDesembListDiferencas;
	}

	public CotacoesExternasVO getCotacoesListDiferencas() {
		return cotacoesListDiferencas;
	}

	public void setCotacoesListDiferencas(CotacoesExternasVO cotacoesListDiferencas) {
		this.cotacoesListDiferencas = cotacoesListDiferencas;
	}

    public List<ListaDespesasVO> getListaDespesasDiferencas() {
		return listaDespesasDiferencas;
	}

	public void setListaDespesasDiferencas(
			List<ListaDespesasVO> listaDespesasDiferencas) {
		this.listaDespesasDiferencas = listaDespesasDiferencas;
	}

	public ResponsavelDespesaVO getResponsavelDespListDiferencas() {
		return responsavelDespListDiferencas;
	}

	public void setResponsavelDespListDiferencas(
			ResponsavelDespesaVO responsavelDespListDiferencas) {
		this.responsavelDespListDiferencas = responsavelDespListDiferencas;
	}

	public BeneficiarioVO getBeneficiarioDiferencas() {
		return beneficiarioDiferencas;
	}

	public void setBeneficiarioDiferencas(BeneficiarioVO beneficiarioDiferencas) {
		this.beneficiarioDiferencas = beneficiarioDiferencas;
	}

	public BeneficiarioVO getAfiancadoDiferencas() {
		return afiancadoDiferencas;
	}

	public void setAfiancadoDiferencas(BeneficiarioVO afiancadoDiferencas) {
		this.afiancadoDiferencas = afiancadoDiferencas;
	}

	public ComissaoInternaVO getComissaoInternaDiferencasVO() {
		return comissaoInternaDiferencasVO;
	}

	public void setComissaoInternaDiferencasVO(
			ComissaoInternaVO comissaoInternaDiferencasVO) {
		this.comissaoInternaDiferencasVO = comissaoInternaDiferencasVO;
	}

	public List<MercadoriaVO> getMercadoriaListDiferencas() {
		return mercadoriaListDiferencas;
	}

	public void setMercadoriaListDiferencas(List<MercadoriaVO> mercadoriaListDiferencas) {
		this.mercadoriaListDiferencas = mercadoriaListDiferencas;
	}

	public List<OperacaoVinculadaVO> getOprVincListDiferencas() {
		return oprVincListDiferencas;
	}

	public void setOprVincListDiferencas(List<OperacaoVinculadaVO> oprVincListDiferencas) {
		this.oprVincListDiferencas = oprVincListDiferencas;
	}

	public List<ListaHistoricoTarifaVO> getListaHistTarifDiferencas() {
		return listaHistTarifDiferencas;
	}

	public void setListaHistTarifDiferencas(List<ListaHistoricoTarifaVO> listaHistTarifDiferencas) {
		this.listaHistTarifDiferencas = listaHistTarifDiferencas;
	}

	public ComissaoCollection getComissaoExtListDiferencas() {
		return comissaoExtListDiferencas;
	}

	public void setComissaoExtListDiferencas(ComissaoCollection comissaoExtListDiferencas) {
		this.comissaoExtListDiferencas = comissaoExtListDiferencas;
	}

	public boolean isLiborDiferencas() {
		return liborDiferencas;
	}

	public void setLiborDiferencas(boolean liborDiferencas) {
		this.liborDiferencas = liborDiferencas;
	}

	public boolean isFluxoDiferencas() {
		return fluxoDiferencas;
	}

	public void setFluxoDiferencas(boolean fluxoDiferencas) {
		this.fluxoDiferencas = fluxoDiferencas;
	}

	public boolean isMeMnDiferencas() {
		return meMnDiferencas;
	}

	public void setMeMnDiferencas(boolean meMnDiferencas) {
		this.meMnDiferencas = meMnDiferencas;
	}

	public FluxoPagamentoVO getFluxoPgtDiferencasVO() {
		return fluxoPgtDiferencasVO;
	}

	public void setFluxoPgtDiferencasVO(FluxoPagamentoVO fluxoPgtDiferencasVO) {
		this.fluxoPgtDiferencasVO = fluxoPgtDiferencasVO;
	}

	public List<FluxoPagamentoVO> getFluxoPgtListDiferencas() {
		return fluxoPgtListDiferencas;
	}

	public void setFluxoPgtListDiferencas(List<FluxoPagamentoVO> fluxoPgtListDiferencas) {
		this.fluxoPgtListDiferencas = fluxoPgtListDiferencas;
	}

	public List<ComissaoInternaVO> getComissaoIntListDiferencas() {
		return comissaoIntListDiferencas;
	}

	public void setComissaoIntListDiferencas(
			List<ComissaoInternaVO> comissaoIntListDiferencas) {
		this.comissaoIntListDiferencas = comissaoIntListDiferencas;
	}

	public Integer getHabibitaGerarBoleto() {
		return habibitaGerarBoleto;
	}

	public void setHabibitaGerarBoleto(Integer habibitaGerarBoleto) {
		this.habibitaGerarBoleto = habibitaGerarBoleto;
	}
}
