/**
 *
 * Nome: TradeFinanceLogBean.java
 * Propï¿½sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UICnpj.UICnpj;
import br.com.bradesco.web.aq.view.components.UICpf.UICpf;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.ITradeFinanceLogService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean.ListaHistoricoTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean.TradeFinanceLogDiferencasListaVo;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean.TradeFinanceLogDiferencasVo;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitBaseBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * Nome: TradeFinanceLogBean.java
 * 
 * PropÃ³sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilaÃ§Ã£o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de ManutenÃ§Ã£o: 19/04/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrÃ£o
 *      hexavision.
 */
@Named("tradeFinanceLogBean")
@SessionScoped
public class TradeFinanceLogBean extends TradeFinMonitBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -6323497481068756486L;

    private boolean libor = false;
    private boolean fluxo = false;
    private boolean meMn = false;
    /** CHECKBOX GARANTIAS **/
    private boolean indeterminado = false;

    private List<TradeFinanceListaVO> listaLogAcoes = new ArrayList<TradeFinanceListaVO>();
    private TradeFinanceListaVO itemLogAcoesVO = new TradeFinanceListaVO();
    private String itemSelecionadoLogAcoes = null;

    /** Lista o Historico de tarifas **/
    private List<ListaHistoricoTarifaVO> listaHistTarif = new ArrayList<ListaHistoricoTarifaVO>();

    /** Lista que compara o antes e depois de uma cotação **/ 
    private List<TradeFinanceLogDiferencasVo> listaLogAntesDepois = new ArrayList<TradeFinanceLogDiferencasVo>();

	@Inject
    @Named("tradeFinanceLogService")
    private ITradeFinanceLogService tradeFinanceLogService;

    /**
     * Metodo construtor da classe.
     */
    public TradeFinanceLogBean() {
        super();
    }

    /**
     * Nome: iniciar Propï¿½sito: Inicia dados da tela
     *
     * @param : <BR/>
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     */
    public String iniciar() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.iniciar <<<<<<<<<<<");

            // Recarrega página se não for um postback ou se foi marcado para recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);

                listenerLimparPesquisa(null);
                limparCpfCnpjCliente(null);

                viewHelper.setComboUnidadeNegocio(getSelectItemBean().getComboUnidadeNegocio());
                getViewHelper().setNomeStateIdLista("NPCCIARQ");
                getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
                getViewHelper().setDisabledBotaoDetGar(false);
                getViewHelper().setCnpjBinding(new UICnpj());
                getViewHelper().setCpfBinding(new UICpf());
                getViewHelper().setTradeFinanceLog(Numeros.TRES);

                limparDadosDetalhe();

                tradeFinanceBean.getViewHelper().setDisabledBotaoDetGar(false);
                actionFecharModal();

            }

            return "tradeFinLog";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.iniciar <<<<<<<<<<<");
        }

    }
    
    public String actionExportar(){
        return super.actionExportar(false);
    }

    /**
     * Nome: pesquisar logs
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void pesquisar(AjaxBehaviorEvent evento) {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.pesquisar <<<<<<<<<<<");

            setLista(new ArrayList<TradeFinanceListaVO>());
            setListaLogAcoes(new ArrayList<TradeFinanceListaVO>());
            setItemLogAcoesVO(new TradeFinanceListaVO());
            setItemSelecionadoLogAcoes(null);;

            if (validarCamposData()) {

                getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
                // executa chamada CWS - Fluxo NPCCIARQ - Books: NPCCWZTE / NPCCWZTS
                setLista(tradeFinanceLogService.listar(filtroVO));
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.pesquisar <<<<<<<<<<<");
        }

    }
    
    /**
     * Nome: exportar
     * Proposito: exportar lista do monitor do log para EXCEL
     * 
     * @param ActionEvent
     * @see : Referencias externas.
     */
    public String exportar() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.exportar <<<<<<<<<<<");

            getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
            
            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista", tradeFinanceLogService.listarCotacoesExportacao(filtroVO));
            
            return "tradeFinLogExportTemplate";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.exportar <<<<<<<<<<<");
        }

    }
    
    /**
     * Nome: exportar
     * Proposito: exportar lista dolog de detalhe para EXCEL
     * 
     * @param ActionEvent
     * @see : Referencias externas.
     */
    public String exportarlogDetalhe() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.exportarlogDetalhe <<<<<<<<<<<");

            getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
            
            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("listaLogAcoes", 
                            tradeFinanceLogService.confirmarLogDetalhe(tradeFinanceListaVO.getNbletocmbioano(),
                            tradeFinanceListaVO.getNbletonegoccmbio()));
            
            return "tradeFinLogCotExportTemplate";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.exportarlogDetalhe <<<<<<<<<<<");
        }

    }

    /**
     * 
     * Nome: paginar Propï¿½sito: Retornar os dados conforme paginacao
     * 
     * @param ActionEvent
     * @see : Referencias externas.
     */
    public void paginar(ActionEvent event) {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.paginar <<<<<<<<<<<");

            // executa chamada CWS - Fluxo NPCCIARQ - Books: NPCCWZTE / NPCCWZTS
            setLista(tradeFinanceLogService.listar(filtroVO));

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.paginar <<<<<<<<<<<");
        }

    }

    /**
     * Nome: actionConfirmar
     * 
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 19/04/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public String actionConfirmar() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.actionConfirmar <<<<<<<<<<<");

            limparDadosDetalhe();

            // se lista vazia exibe mensagem de retorno do mainframe
            if (getLista().isEmpty()) {
                BradescoFacesUtils.addInfoModalMessage(tradeFinanceLogService.getMsgRetorno(),
                                false);
            } else {

                // valida se selecionou um registro na tela
                if (!SiteUtil.isEmptyOrNull(viewHelper.getCtcSelecionado())) {
                    tradeFinanceListaVO = lista.get(SiteUtil.getInt(viewHelper.getCtcSelecionado()));

                    // executa chamada CWS - Fluxo NPCCIARO - Books: NPCCWVVE /
                    // NPCCWVVS
                    setListaLogAcoes(tradeFinanceLogService.confirmar(
                                    tradeFinanceListaVO.getNbletocmbioano(),
                                    tradeFinanceListaVO.getNbletonegoccmbio()));

                    getViewHelper().setItemSelectLista(null);

                } else {
                    BradescoFacesUtils.addInfoModalMessage("Selecione um registro.",
                                    false);
                    return null;
                }
            }


            return "tradeFinLogDet";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.actionConfirmar <<<<<<<<<<<");
        }

    }

    /**
     * 
     * Nome: paginar Propï¿½sito: Retornar os dados conforme paginacao
     * 
     * @param ActionEvent
     * @see : Referencias externas.
     */
    public void paginarLog(ActionEvent event) {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.paginarLog <<<<<<<<<<<");

            // executa chamada CWS - Fluxo NPCCIARO - Books: NPCCWVVE / NPCCWVVS
            setListaLogAcoes(tradeFinanceLogService.confirmar(tradeFinanceListaVO.getNbletocmbioano(), tradeFinanceListaVO.getNbletonegoccmbio()));

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.paginarLog <<<<<<<<<<<");
        }

    }

    /**
     * Nome: actionConfirmarLog
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
     *      Registro de Manutenção: 23/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionConfirmarLog() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.actionConfirmarLog <<<<<<<<<<<");

            if (SiteUtil.isEmptyOrNull(getItemSelecionadoLogAcoes())){
                NpcFacesUtils.addInfoModalMessage("Selecione um item.", false);
                return "";
            }

            itemLogAcoesVO = listaLogAcoes.get(Integer.parseInt(getItemSelecionadoLogAcoes()));
            tradeFinanceBean.obterDadosBasicos(itemLogAcoesVO, ConstantesTradeFinance.FUNC_CONSULTAR_LOG);
            
            if(itemLogAcoesVO.getProduto().isBndesPos() || itemLogAcoesVO.getProduto().isBndesPre()
                            || itemLogAcoesVO.getProduto().isGarantia() || itemLogAcoesVO.getProduto().isNce()) {

                String result = carregaTelaOutrosProdutos(itemLogAcoesVO);
                viewHelper.setTelaLogChamada(result);
                return result;

            } else {

                String result = carregaTela(itemLogAcoesVO);
                viewHelper.setTelaLogChamada(result);
                return result;
            }


        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.actionConfirmarLog <<<<<<<<<<<");
        }

    }
    /**
     * Nome: carregaTela
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    private String carregaTela(TradeFinanceListaVO operacao) {

        String result = SiteUtil.STRING_EMPTY;

        switch (operacao.getProduto()) {

        case PRODUTO_FORFAITING:
            result = "forfaitingLog";
            break;

        case PRODUTO_FINIMP_DIRETO:
            result = "finimpDiretoLog";
            break;

        case PRODUTO_FINIMP_INDIRETO:
            result = "finimpIndiretoLog";
            break;

        case PRODUTO_LEI_4131:
            result = "lei4131Log";
            break;

        case PRODUTO_P_P_E:
            result = "cotacaoPPELog";
            break;

        case PRODUTO_REFINIMP_DIRETO:
            result = "refinimpDiretoLog";
            break;

        case PRODUTO_REFINIMP_INDIRETO:
            result = "refinimpIndiretoLog";
            break;

        case PRODUTO_WORKING_CAPITAL:
            result = "workingCapitalLog";
            break;

        case PROEX:
            result = "proexLog";
            break;

        case LC_IMPORTACAO:
            result = "lcImportacaoLog";
            break;

        case FINIMP_ECA:
            result = "finimpEcaLog";
            break;

        default:
            return null;
        }

        return result;

    }

    /**
     * Nome: carregaTelaOutrosProdutos
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 27/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String carregaTelaOutrosProdutos(TradeFinanceListaVO operacao) {

        String result = SiteUtil.STRING_EMPTY;

        if(operacao.getProduto().isBndesPos()) {
        	result = "bndesPosLog";

        }else if(operacao.getProduto().isBndesPre()) {
        	result = "bndesPreLog";

        }else if(operacao.getProduto().isGarantia()) {
        	result = "garantiaIntExpLog";

        }else if(operacao.getProduto().isNce()) {
        	result = "nceLog";
        }

        return result;


    }

    /**
     * Nome: actionDiferencas
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 15/08/2018
     *        - Autor: CD GP494
     *        - Responsavel: Equipe Web
     */
    public String actionDiferencas() {

    	try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.actionDiferencas <<<<<<<<<<<");

            getListaLogAntesDepois().clear();
            
            String hinclRegHistAntes = itemLogAcoesVO.getHinclanthist();
            String hinclRegHistDepois = itemLogAcoesVO.getHinclreghist();

            // Alterado o horario de historico para ANTES, pois devera buscar as informacoes com o horario ANTES
            // para comparar com o DEPOIS, que já foi carregado ao montar a tela de LOG.
            itemLogAcoesVO.setHinclreghist(hinclRegHistAntes);
            
            // Muda indicador para ANTES, pois o metodo 'obterDadosBasicos' deve popular os VOs criados para os valores ANTES.
            tradeFinanceBean.setIndicadorLogTradeFinanceAntesDepois(SiteUtil.STRING_A);
            
            tradeFinanceBean.obterDadosBasicos(itemLogAcoesVO, ConstantesTradeFinance.FUNC_CONSULTAR_LOG);

            // Após chamada dos fluxos, volta o horaria de historico para DEPOIS e o indicador de VOs
            itemLogAcoesVO.setHinclreghist(hinclRegHistDepois);
            
            tradeFinanceBean.setIndicadorLogTradeFinanceAntesDepois(SiteUtil.STRING_D);
            
            tradeFinanceBean.getTradeFinanceVO().setHinclreghist(hinclRegHistDepois); 
            tradeFinanceBean.getTradeFinanceDiferencasVO().setHinclreghist(hinclRegHistAntes);
            
            String tela = null;
            
            if(itemLogAcoesVO.getProduto().isBndesPos() || itemLogAcoesVO.getProduto().isBndesPre()
                            || itemLogAcoesVO.getProduto().isGarantia() || itemLogAcoesVO.getProduto().isNce()) {

                tela = carregaTelaOutrosProdutos(itemLogAcoesVO);
                viewHelper.setTelaLogChamada(tela);

            } else {

                tela = carregaTela(itemLogAcoesVO);
                viewHelper.setTelaLogChamada(tela);
                
            }
            
            if(tela.equalsIgnoreCase("forfaitingLog")){
            	getViewHelper().setTelaLog("title_log_forfaiting");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_forfaiting");
            	forfaitingLogDiferencas();
            }

            if(tela.equalsIgnoreCase("finimpDiretoLog")){
            	getViewHelper().setTelaLog("title_log_finimp_direto");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_finimp_direto");
            	finimpDiretoLogDiferencas();
            }

            if(tela.equalsIgnoreCase("finimpIndiretoLog")){
            	getViewHelper().setTelaLog("title_log_finimp_indireto");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_finimp_indireto");
            	finimpIndiretoLogDiferencas();
            }

            if(tela.equalsIgnoreCase("lei4131Log")){
            	getViewHelper().setTelaLog("title_log_lei4131");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_lei4131");
            	lei4131LogDiferencas();
            }

            if(tela.equalsIgnoreCase("cotacaoPPELog")){
            	getViewHelper().setTelaLog("title_log_ppe");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_ppe");
            	cotacaoPPELogDiferencas();
            }

            if(tela.equalsIgnoreCase("refinimpDiretoLog")){
            	getViewHelper().setTelaLog("title_log_refinimp_direto");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_refinimp_direto");
            	refinimpDiretoLogDiferencas();
            }

            if(tela.equalsIgnoreCase("refinimpIndiretoLog")){
            	getViewHelper().setTelaLog("title_log_refinimp_indireto");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_refinimp_indireto");
            	refinimpIndiretoLogDiferencas();
            }

            if(tela.equalsIgnoreCase("workingCapitalLog")){
            	getViewHelper().setTelaLog("title_log_working_capital");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_working_capital");
            	workingCapitalLogDiferencas();
            }

            if(tela.equalsIgnoreCase("proexLog")){
            	getViewHelper().setTelaLog("title_log_proex");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_proex");
            	proexLogDiferencas();
            }

            if(tela.equalsIgnoreCase("lcImportacaoLog")){
            	getViewHelper().setTelaLog("title_log_lcimportacao");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_lcimportacao");
            	lcImportacaoLogDiferencas();
            }

            if(tela.equalsIgnoreCase("finimpEcaLog")){
            	getViewHelper().setTelaLog("title_log_finimp_eca");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_finimp_eca");
            	finimpEcaLogDiferencas();
            }

            if(tela.equalsIgnoreCase("bndesPosLog")){
            	getViewHelper().setTelaLog("title_log_bndes_pos");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_bndes_pos");
            	bndesPosLogDiferencas();
            }

            if(tela.equalsIgnoreCase("bndesPreLog")){
            	getViewHelper().setTelaLog("title_log_bndes_pre");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_bndes_pre");
            	bndesPreLogDiferencas();
            }

            if(tela.equalsIgnoreCase("garantiaIntExpLog")){
            	getViewHelper().setTelaLog("title_log_garantia_int_exp");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_garantia_int_exp");
            	garantiaIntExpLogDiferencas();
            }

            if(tela.equalsIgnoreCase("nceLog")){
            	getViewHelper().setTelaLog("title_log_nce");
            	getViewHelper().setTelaLogDiferencas("title_diferencas_log_nce");
            	nceLogDiferencas();
            }
	
        	for (int i = 0; i < getListaLogAntesDepois().size(); i++) {
        		String antes =getListaLogAntesDepois().get(i).getAntes();
        		String depois =getListaLogAntesDepois().get(i).getDepois();
        		
        		if(antes == null){
        			antes = "";
        		}
        		
        		if(depois == null){
        			depois = "";
        		}
        		
    			if(antes.equals(depois)){
    				getListaLogAntesDepois().get(i).setHouveAlteracao(false);
    			}else {
    				getListaLogAntesDepois().get(i).setHouveAlteracao(true);
    			}
    		}
            
            return "tradeFinLogDiferencas";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.actionDiferencas <<<<<<<<<<<");
        }

    }
    
 // Metodo referente aos campos da tela forfaitingLog.xhtml
    private void forfaitingLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoedaForfaiting());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTomador());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacaoTx());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoIntForfaiting());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosForFaitingEmbutDeduz());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosMercadoria());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void finimpDiretoLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosSwapPtaxSpread());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosStandBy());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacaoTx());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInterna());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosMercadoria());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosOperacaoVinculada());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosResponsavelEmpresa());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void finimpIndiretoLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosSwapPtaxSpread());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosStandBy());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacaoTx());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInterna());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosMercadoria());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosOperacaoVinculada());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosResponsavelEmpresa());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }

    private void lei4131LogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosSwapPtaxSpread());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosStandBy());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInterna());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosOperacaoVinculada());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosResponsavelEmpresa());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void cotacaoPPELogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosSwapPtaxSpread());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosStandBy());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacaoTx());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInterna());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosMercadoria());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosResponsavelEmpresa());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void refinimpDiretoLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosSwapPtaxSpread());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosStandBy());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInterna());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosMercadoria());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosOperacaoVinculada());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosResponsavelEmpresa());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void refinimpIndiretoLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosSwapPtaxSpread());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosStandBy());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInterna());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosMercadoria());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosOperacaoVinculada());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosResponsavelEmpresa());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void workingCapitalLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTomador());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosStandBy());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInterna());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void proexLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoedaProex());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProex());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    // Metodo referente aos campos da tela lcImportacaoLog.xhtml
    private void lcImportacaoLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosLcImportacao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacaoLc());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosGridCustoExerno());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInternaUnica());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosMercadoria());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosOperacaoVinculada());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosDocumentosConsignados());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosResponsavelEmpresa());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoReduzida());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void finimpEcaLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosSwapPtaxSpread());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacaoEca());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrecificacaoTx());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosGridCustoExerno());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoBanqueiro());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInterna());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosMercadoria());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosOperacaoVinculada());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosResponsavelEmpresa());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void bndesPosLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoedaBndesPos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosGarantidorBndesPos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosGarantiasBndesPos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void bndesPreLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoedaBndesPre());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPrazosBndesPre());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosPgtJuroPartBndespre());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void garantiaIntExpLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFinalidadeGaranExp());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasdadosPrecificacaoGaranExp());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoInternaUnica());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissaoReduzida());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosContatoGaranExp());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosContraGaranExp());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }
    
    private void nceLogDiferencas(){
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosClientes());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosProdutos());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosAprovacaoCredito());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosValorMoeda());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosSwapPtaxSpread());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosFluxoPagamento());
    	getListaLogAntesDepois().addAll(carregarDiferencasdadosPrecificacaoNce());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosTarifaLog());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosComissao());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosModeloBoleto());
    	getListaLogAntesDepois().addAll(carregarDiferencasDadosObsOutrasEspecificacoes());
    }

    // Metodo referente aos campos da tela dadosClienteCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosClientes(){

    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	log.add(new TradeFinanceLogDiferencasVo("label_det_cliente", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getNcunicclicmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getNcunicclicmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_cpf_cnpj", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getCpfCnpjFormatado(), 
    			tradeFinanceBean.getTradeFinanceVO().getCpfCnpjFormatado()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_banco", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getNomesocial(), 
    			tradeFinanceBean.getTradeFinanceVO().getNomesocial()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_agencia", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getCagbcria(), 
    			tradeFinanceBean.getTradeFinanceVO().getCagbcria()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_conta", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getCctabcriaclicmbio() + "-" + tradeFinanceBean.getTradeFinanceDiferencasVO().getDigtcctabcria(), 
    			tradeFinanceBean.getTradeFinanceVO().getCctabcriaclicmbio() + "-" + tradeFinanceBean.getTradeFinanceVO().getDigtcctabcria()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_cidade_uf", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getCidade() + "-" + tradeFinanceBean.getTradeFinanceDiferencasVO().getEstado(), 
    			tradeFinanceBean.getTradeFinanceVO().getCidade() + "-" + tradeFinanceBean.getTradeFinanceVO().getEstado()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_un_negocio", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getNomeundorgnz(), 
    			tradeFinanceBean.getTradeFinanceVO().getNomeundorgnz()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_rating", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getCrting(), 
    			tradeFinanceBean.getTradeFinanceVO().getCrting()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_contato", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getNomecttclicmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getNomecttclicmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_telefone", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getTelcttclicmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getTelcttclicmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_segmento", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDtposgmtocli(), 
    			tradeFinanceBean.getTradeFinanceVO().getDtposgmtocli()));

    	if(itemLogAcoesVO.getProduto().isBndesPos() || itemLogAcoesVO.getProduto().isBndesPre()){

    		log.add(new TradeFinanceLogDiferencasVo("label_det_cargo", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getCargonome(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getCargonome()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_email", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getCargoemail(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getCargoemail()));

    	}

    	return log;
    }

    // Metodo referente aos campos da tela dadosProdutoCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosProdutos(){

    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	log.add(new TradeFinanceLogDiferencasVo("label_det_produto", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDprodtservc(), 
    			tradeFinanceBean.getTradeFinanceVO().getDprodtservc()));

    	log.add(new TradeFinanceLogDiferencasVo("label_modalidade", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDmodldprodtcmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getDmodldprodtcmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_status", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDsitbletocmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getDsitbletocmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_limite_ctc", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDvalddnegoccmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getDvalddnegoccmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_tp_ctc", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDescrctc(), 
    			tradeFinanceBean.getTradeFinanceVO().getDescrctc()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_ctc", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getNcotacao(), 
    			tradeFinanceBean.getTradeFinanceVO().getNcotacao()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_operador", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getCusuarinclt() + "-" + tradeFinanceBean.getTradeFinanceDiferencasVO().getNusuarinclt(), 
    			tradeFinanceBean.getTradeFinanceVO().getCusuarinclt() + "-" + tradeFinanceBean.getTradeFinanceVO().getNusuarinclt()));

    	log.add(new TradeFinanceLogDiferencasVo("label_data_cadastramento", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDinclreg(), 
    			tradeFinanceBean.getTradeFinanceVO().getDinclreg()));

    	return log;
    }

    // Metodo referente aos campos da tela dadosAprovCreditoCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosAprovacaoCredito(){

    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	if (!tradeFinanceBean.getTradeFinanceVO().getNppstapontucmbio().equals(0) &&
    			tradeFinanceBean.getTradeFinanceVO().getNppstapontucmbio() != null){
    		log.add(new TradeFinanceLogDiferencasVo("label_det_n_apr_cred", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getNppstapontucmbio(), 
    				tradeFinanceBean.getTradeFinanceVO().getNppstapontucmbio()));
    	}else {
    		log.add(new TradeFinanceLogDiferencasVo("label_det_n_apr_cred", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getNseqcontrlim(), 
    				tradeFinanceBean.getTradeFinanceVO().getNseqcontrlim()));
    	}

    	// Não coloquei o modal de garantias, pois é aberto a partir de um botão

    	return log;
    }

    // Metodo referente aos campos da tela dadosLcImportacaoCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosLcImportacao(){
    	int bigger = 0;
    	int lower = 0;
    	boolean isPreviousBigger = false;
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
    	TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();

    	log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_operacao", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedaoperacao(), 
    			tradeFinanceBean.getTradeFinanceVO().getMoedaoperacao()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_valor_ME", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getVnegocmoedaestrg(), 
    			tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedalimite(), 
    			tradeFinanceBean.getTradeFinanceVO().getMoedalimite()));

    	log.add(new TradeFinanceLogDiferencasVo("label_about", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getVlimcobervar(), 
    			tradeFinanceBean.getTradeFinanceVO().getVlimcobervar()));

    	log.add(new TradeFinanceLogDiferencasVo("label_embarque_ate", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDlimembrqcmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getDlimembrqcmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite_vlr", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getVmoedalimgerc(), 
    			tradeFinanceBean.getTradeFinanceVO().getVmoedalimgerc()));

    	log.add(new TradeFinanceLogDiferencasVo("label_prazo", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataPrazoLC(), 
    			tradeFinanceBean.getTradeFinanceVO().getFormataPrazoLC()));

    	log.add(new TradeFinanceLogDiferencasVo("label_prazo_maximo", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getValddcarta(), 
    			tradeFinanceBean.getTradeFinanceVO().getValddcarta()));

    	log.add(new TradeFinanceLogDiferencasVo("label_letras", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiavalddletra(), 
    			tradeFinanceBean.getTradeFinanceVO().getTdiavalddletra()));

    	// Antes label_det_mixed
    	for (int i = 0; i < tradeFinanceBean.getParcelaDesembListDiferencas().size(); i++) { 
    		listLog.getAntes().add(tradeFinanceBean.getParcelaDesembListDiferencas().get(i).getVpcelacreditprevt() + ", " +
    				tradeFinanceBean.getParcelaDesembListDiferencas().get(i).getVpcelacartaprevt() + ", " +
    				tradeFinanceBean.getParcelaDesembListDiferencas().get(i).getNprzpcelacarta() + ", " +
    				tradeFinanceBean.getParcelaDesembListDiferencas().get(i).getTdiapgtocarta());
    	}

    	// Depois label_det_mixed
    	for (int i = 0; i < tradeFinanceBean.getParcelaDesembList().size(); i++) {
    		listLog.getDepois().add(tradeFinanceBean.getParcelaDesembList().get(i).getVpcelacreditprevt() + ", " +
    				tradeFinanceBean.getParcelaDesembList().get(i).getVpcelacartaprevt() + ", " +
    				tradeFinanceBean.getParcelaDesembList().get(i).getNprzpcelacarta() + ", " +
    				tradeFinanceBean.getParcelaDesembList().get(i).getTdiapgtocarta());
    	}

    	// Verifica qual é o maior e o menor tamanho de lista (label_det_mixed)
    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
    		bigger = listLog.getAntes().size();
    		lower = listLog.getDepois().size();
    		isPreviousBigger = true;
    	} else {
    		bigger = listLog.getDepois().size();
    		lower = listLog.getAntes().size();
    		isPreviousBigger = false;
    	}

    	// Adiciona a label_det_mixed na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_det_mixed", listLog));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_prazo_total", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiaopercmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getTdiaopercmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_embarque_parcial", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataEmbarqueParcial(), 
    			tradeFinanceBean.getTradeFinanceVO().getFormataEmbarqueParcial()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_qtde_embarque", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getQprevtembrqcmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getQprevtembrqcmbio()));

    	log.add(new TradeFinanceLogDiferencasVo("label_forma_pagamento_complementar", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getFormapagto(), 
    			tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getFormapagto()));

    	return log;
    }

    // Metodo referente aos campos da tela dadosPrecificacaoLcCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosPrecificacaoLc(){

    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	log.add(new TradeFinanceLogDiferencasVo("label_eca", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataEca(), 
    			tradeFinanceBean.getTradeFinanceVO().getFormataEca()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_transferivel", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataTransferivel(), 
    			tradeFinanceBean.getTradeFinanceVO().getFormataTransferivel()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_confirmada", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataConfirmada(), 
    			tradeFinanceBean.getTradeFinanceVO().getFormataConfirmada()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_any_bank", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataAnyBank(), 
    			tradeFinanceBean.getTradeFinanceVO().getFormataAnyBank()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_via_ccr", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataViaCcr(), 
    			tradeFinanceBean.getTradeFinanceVO().getFormataViaCcr()));

    	return log;
    }

    // Metodo referente aos campos da tela dadosGridCustoExernoCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosGridCustoExerno(){
    	int bigger = 0;
    	int lower = 0;
    	boolean isPreviousBigger = false;
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
    	TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();

    	for (int i = 0; i < tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().size(); i++) {  	
    		listLog.getAntes().add(tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getNbanqrcmbiofndng() + "-" +  
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getPracacmbiofndmg() + ", " +
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getNbanqrcmbioaviso() + "-" +
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getPracacmbioaviso() + ", " +
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getNbanqrcmbiorcdor() + "-" +
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getPracacmbiorcdor() + ", " +
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getDcotacfndngcmbio() + ", " +
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getDlimfndngcmbio() + ", " +
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getNindcdfndngutlzd() + ", " +
    				tradeFinanceBean.getCotacoesListDiferencas().getListaCotacoes().get(i).getNusuarmanut());
    	}

    	for (int i = 0; i < tradeFinanceBean.getCotacoesList().getListaCotacoes().size(); i++) {  	
    		listLog.getDepois().add(tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getNbanqrcmbiofndng() + "-" +  
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getPracacmbiofndmg() + ", " +
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getNbanqrcmbioaviso() + "-" +
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getPracacmbioaviso() + ", " +
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getNbanqrcmbiorcdor() + "-" +
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getPracacmbiorcdor() + ", " +
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getDcotacfndngcmbio() + ", " +
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getDlimfndngcmbio() + ", " +
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getNindcdfndngutlzd() + ", " +
    				tradeFinanceBean.getCotacoesList().getListaCotacoes().get(i).getNusuarmanut());
    	}

    	// Verifica qual é o maior e o menor tamanho de lista (label_lista_cotacoes)
    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
    		bigger = listLog.getAntes().size();
    		lower = listLog.getDepois().size();
    		isPreviousBigger = true;
    	} else {
    		bigger = listLog.getDepois().size();
    		lower = listLog.getAntes().size();
    		isPreviousBigger = false;
    	}

    	// Adiciona a label_det_mixed na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_lista_cotacoes", listLog));

    	// Limpa as listas para serem reutilizadas
    	listLog.getAntes().clear();
    	listLog.getDepois().clear();

    	for (int i = 0; i < tradeFinanceBean.getListaDespesasDiferencas().size(); i++) {  	
    		listLog.getAntes().add(tradeFinanceBean.getListaDespesasDiferencas().get(i).getNtpodespcmbio() + ", " +  
    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNidtfdrespdesp() + ", " +
    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getPdespnegoccmbio() + ", " +
    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNbasebletonegoc() + ", " +
    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNfluxoperdccmbio() + ", " +
    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNindcdeconmmoeda() + ", " +
    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getVdespbletocmbio() + ", " +
    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNformacobrdesp() + ", " +
    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getVmindespcmbio());
    	}

    	for (int i = 0; i < tradeFinanceBean.getListaDespesas().size(); i++) {  	
    		listLog.getDepois().add(tradeFinanceBean.getListaDespesas().get(i).getNtpodespcmbio() + ", " +  
    				tradeFinanceBean.getListaDespesas().get(i).getNidtfdrespdesp() + ", " +
    				tradeFinanceBean.getListaDespesas().get(i).getPdespnegoccmbio() + ", " +
    				tradeFinanceBean.getListaDespesas().get(i).getNbasebletonegoc() + ", " +
    				tradeFinanceBean.getListaDespesas().get(i).getNfluxoperdccmbio() + ", " +
    				tradeFinanceBean.getListaDespesas().get(i).getNindcdeconmmoeda() + ", " +
    				tradeFinanceBean.getListaDespesas().get(i).getVdespbletocmbio() + ", " +
    				tradeFinanceBean.getListaDespesas().get(i).getNformacobrdesp() + ", " +
    				tradeFinanceBean.getListaDespesas().get(i).getVmindespcmbio());
    	}

    	// Verifica qual é o maior e o menor tamanho de lista (label_lista_despesas)
    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
    		bigger = listLog.getAntes().size();
    		lower = listLog.getDepois().size();
    		isPreviousBigger = true;
    	} else {
    		bigger = listLog.getDepois().size();
    		lower = listLog.getAntes().size();
    		isPreviousBigger = false;
    	}

    	// Adiciona a label_det_mixed na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_lista_despesas", listLog));

    	return log;
    }

    // Metodo referente aos campos da tela dadosComissaoInternaUnicaCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosComissaoInternaUnica(){
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	if(tradeFinanceBean.getViewHelper().isRenderComissaoInterna()){

    		log.add(new TradeFinanceLogDiferencasVo("label_det_cobranca_comissao_about", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getComissaoInterna(), 
    				tradeFinanceBean.getTradeFinanceVO().getComissaoInterna()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_comissao_cobrado_no_brasil", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getCcomiscartanacio(), 
    				tradeFinanceBean.getTradeFinanceVO().getCcomiscartanacio()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_cobranca_comissao", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getDescrComissao(), 
    				tradeFinanceBean.getComissaoInternaVO().getDescrComissao()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_comissao", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getValorComissaoBoleto(), 
    				tradeFinanceBean.getComissaoInternaVO().getValorComissaoBoleto()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_comissao", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getIsglindcdeconmmoeda(), 
    				tradeFinanceBean.getComissaoInternaVO().getIsglindcdeconmmoeda()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_comissao_sobre", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getIdentificaCobranca(), 
    				tradeFinanceBean.getComissaoInternaVO().getIdentificaCobranca()));

    		log.add(new TradeFinanceLogDiferencasVo("label_periodicidade", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getIfluxoperdccmbio(), 
    				tradeFinanceBean.getComissaoInternaVO().getIfluxoperdccmbio()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_momento", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getDescrmomen(), 
    				tradeFinanceBean.getComissaoInternaVO().getDescrmomen()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_minimo_cobrar", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getVmincobrcomis(), 
    				tradeFinanceBean.getComissaoInternaVO().getVmincobrcomis()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_spread_apvr", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getVtxspreadaprov(),  
    				tradeFinanceBean.getComissaoInternaVO().getVtxspreadaprov()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_spread_negoc", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getVtxspreadnegoc(), 
    				tradeFinanceBean.getComissaoInternaVO().getVtxspreadnegoc()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_flat", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getPtxflatpnalt(), 
    				tradeFinanceBean.getComissaoInternaVO().getPtxflatpnalt()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_valor", 
    				tradeFinanceBean.getComissaoInternaDiferencasVO().getVprevtcomiscmbio(), 
    				tradeFinanceBean.getComissaoInternaVO().getVprevtcomiscmbio()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_juros_mora", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxmoracmbio() + " " + tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataJuroMora(), 
    				tradeFinanceBean.getTradeFinanceVO().getVtxmoracmbio() + " " + tradeFinanceBean.getTradeFinanceVO().getFormataJuroMora()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_multa", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getVmultanegoccmbio(), 
    				tradeFinanceBean.getTradeFinanceVO().getVmultanegoccmbio()));

    	}

    	return log;
    }

    // Metodo referente aos campos da tela dadosMercadoriaCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosMercadoria(){
    	int bigger = 0;
    	int lower = 0;
    	boolean isPreviousBigger = false;
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
    	TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();

    	if(getViewHelper().isRenderMercadoria()){

    		for (int i = 0; i < tradeFinanceBean.getMercadoriaListDiferencas().size(); i++) {  
    			listLog.getAntes().add(tradeFinanceBean.getMercadoriaListDiferencas().get(i).getRmcadoopercmbio() + ", " +
    					tradeFinanceBean.getMercadoriaListDiferencas().get(i).getIpais() + ", " +
    					tradeFinanceBean.getMercadoriaListDiferencas().get(i).getIpaisembrq() + ", " +
    					tradeFinanceBean.getMercadoriaListDiferencas().get(i).getIunicpssoamcado() + ", " +
    					tradeFinanceBean.getMercadoriaListDiferencas().get(i).getIpaisbnefc() + ", " +
    					tradeFinanceBean.getMercadoriaListDiferencas().get(i).getDprevtembrq() + ", " +
    					tradeFinanceBean.getMercadoriaListDiferencas().get(i).getNdsembcmbiotrade()); 
    		}

    		for (int i = 0; i < tradeFinanceBean.getMercadoriaList().size(); i++) {  
    			listLog.getDepois().add(tradeFinanceBean.getMercadoriaList().get(i).getRmcadoopercmbio() + ", " +
    					tradeFinanceBean.getMercadoriaList().get(i).getIpais() + ", " +
    					tradeFinanceBean.getMercadoriaList().get(i).getIpaisembrq() + ", " +
    					tradeFinanceBean.getMercadoriaList().get(i).getIunicpssoamcado() + ", " +
    					tradeFinanceBean.getMercadoriaList().get(i).getIpaisbnefc() + ", " +
    					tradeFinanceBean.getMercadoriaList().get(i).getDprevtembrq() + ", " +
    					tradeFinanceBean.getMercadoriaList().get(i).getNdsembcmbiotrade());
    		}

    		// Verifica qual é o maior e o menor tamanho de lista (label_lista_mercadorias)
    		if (listLog.getAntes().size() > listLog.getDepois().size()) {
    			bigger = listLog.getAntes().size();
    			lower = listLog.getDepois().size();
    			isPreviousBigger = true;
    		} else {
    			bigger = listLog.getDepois().size();
    			lower = listLog.getAntes().size();
    			isPreviousBigger = false;
    		}

    		// Adiciona a label_lista_mercadorias na lista
    		log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_lista_mercadorias", listLog));

    	}

    	if(!tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(644)){
    		if(!tradeFinMonitBean.getTradeFinanceListaVO().getProduto().getCodigo().equals(644)){
    			log.add(new TradeFinanceLogDiferencasVo("label_det_seg_transporte", 
    					tradeFinanceBean.getTradeFinanceDiferencasVO().getCsegurtrnspmcado(), 
    					tradeFinanceBean.getTradeFinanceVO().getCsegurtrnspmcado()));

    			log.add(new TradeFinanceLogDiferencasVo("label_det_clausula_benf_br", 
    					tradeFinanceBean.getTradeFinanceDiferencasVO().getCsegurmcadoorgnz(), 
    					tradeFinanceBean.getTradeFinanceVO().getCsegurmcadoorgnz()));
    		}		
    	}

    	return log;
    }

    // Metodo referente aos campos da tela dadosOperacaoVinculadaCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosOperacaoVinculada(){
    	int bigger = 0;
    	int lower = 0;
    	boolean isPreviousBigger = false;
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
    	TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();

    	for (int i = 0; i < tradeFinanceBean.getOprVincListDiferencas().size(); i++) {  
    		listLog.getAntes().add(tradeFinanceBean.getOprVincListDiferencas().get(i).getNbletocmbioano() + ", " +
    				tradeFinanceBean.getOprVincListDiferencas().get(i).getIindcdeconmmoeda() + ", " +
    				tradeFinanceBean.getOprVincListDiferencas().get(i).getVnegocmoedaestr() + ", " +
    				tradeFinanceBean.getOprVincListDiferencas().get(i).getIprodtservc()); 
    	}

    	for (int i = 0; i < tradeFinanceBean.getOprVincList().size(); i++) {  
    		listLog.getDepois().add(tradeFinanceBean.getOprVincList().get(i).getNbletocmbioano() + ", " +
    				tradeFinanceBean.getOprVincList().get(i).getIindcdeconmmoeda() + ", " +
    				tradeFinanceBean.getOprVincList().get(i).getVnegocmoedaestr() + ", " +
    				tradeFinanceBean.getOprVincList().get(i).getIprodtservc());
    	}

    	// Verifica qual é o maior e o menor tamanho de lista (label_lista_operacoes_vinculadas)
    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
    		bigger = listLog.getAntes().size();
    		lower = listLog.getDepois().size();
    		isPreviousBigger = true;
    	} else {
    		bigger = listLog.getDepois().size();
    		lower = listLog.getAntes().size();
    		isPreviousBigger = false;
    	}

    	// Adiciona a label_lista_operacoes_vinculadas na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_lista_operacoes_vinculadas", listLog));

    	return log;
    }

    // Metodo referente aos campos da tela dadosDocumentosConsignadosCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosDocumentosConsignados(){
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	if(!tradeFinanceBean.getTradeFinanceVO().getCidtfdcartacsndo().equals(3)){
    		log.add(new TradeFinanceLogDiferencasVo("label_documento_consignado", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getDocumentosConsignados(), 
    				tradeFinanceBean.getTradeFinanceVO().getDocumentosConsignados()));
    	}else {
    		log.add(new TradeFinanceLogDiferencasVo("label_documento_consignado", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getDocumentosConsignados() + " " + tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDoctoconsig(), 
    				tradeFinanceBean.getTradeFinanceVO().getDocumentosConsignados() + " " + tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDoctoconsig()));
    	}

    	return log;
    }

    // Metodo referente aos campos da tela dadosResponsavelEmpresaCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosResponsavelEmpresa(){
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	if(tradeFinanceBean.getViewHelper().isRenderResponsavelEmpresa()){
    		log.add(new TradeFinanceLogDiferencasVo("label_det_nome", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getNomerof(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getNomerof()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_CPF", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getCpfrof(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getCpfrof()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_cargo", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getCargorof(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getCargorof()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_telefone", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getTelrof(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getTelrof()));

    		log.add(new TradeFinanceLogDiferencasVo("label_det_email", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getEmailrof(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getEmailrof()));
    	}

    	return log;
    }

    // Metodo referente aos campos da tela dadosTarifaLogCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosTarifaLog(){
    	int bigger = 0;
    	int lower = 0;
    	boolean isPreviousBigger = false;
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
    	TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();

    	for (int i = 0; i < tradeFinanceBean.getListaHistTarifDiferencas().size(); i++) {  
    		listLog.getAntes().add(tradeFinanceBean.getListaHistTarifDiferencas().get(i).getCcondceconc() + ", " +
    				tradeFinanceBean.getListaHistTarifDiferencas().get(i).getItpodespcmbio() + ", " +
    				tradeFinanceBean.getListaHistTarifDiferencas().get(i).getIsglindcdfonte() + ", " +
    				tradeFinanceBean.getListaHistTarifDiferencas().get(i).getVdespbletocmbio()); 
    	}

    	for (int i = 0; i < tradeFinanceBean.getListaHistTarif().size(); i++) {  
    		listLog.getDepois().add(tradeFinanceBean.getListaHistTarif().get(i).getCcondceconc() + ", " +
    				tradeFinanceBean.getListaHistTarif().get(i).getItpodespcmbio() + ", " +
    				tradeFinanceBean.getListaHistTarif().get(i).getIsglindcdfonte() + ", " +
    				tradeFinanceBean.getListaHistTarif().get(i).getVdespbletocmbio());
    	}

    	// Verifica qual é o maior e o menor tamanho de lista (label_tarifas)
    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
    		bigger = listLog.getAntes().size();
    		lower = listLog.getDepois().size();
    		isPreviousBigger = true;
    	} else {
    		bigger = listLog.getDepois().size();
    		lower = listLog.getAntes().size();
    		isPreviousBigger = false;
    	}

    	// Adiciona a label_tarifas na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_tarifas", listLog));

    	return log;
    }

    // Metodo referente aos campos da tela dadosComissaoReduzidaCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosComissaoReduzida(){
    	int bigger = 0;
    	int lower = 0;
    	boolean isPreviousBigger = false;
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
    	TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();



    	if(tradeFinanceBean.getViewHelper().isRenderComissao()){


    		for (int i = 0; i < tradeFinanceBean.getComissaoExtListDiferencas().size(); i++) {   
    			ComissaoExternaVO comissaoExternaVO = (ComissaoExternaVO) tradeFinanceBean.getComissaoExtListDiferencas().get(i);

    			listLog.getAntes().add(comissaoExternaVO.geticondeconc() + ", " +
    					comissaoExternaVO.getvpcelacomiscmbio() + ", " +
    					comissaoExternaVO.getpcomisnegoccmbio() + ", " +
    					comissaoExternaVO.getiperdcjurocmbio() + ", " + 
    					comissaoExternaVO.getisglindcdfonte() + ", " +
    					comissaoExternaVO.getifluxoperdccmbio() + ", " +
    					comissaoExternaVO.getdescrmomento());
    		}

    		for (int i = 0; i < tradeFinanceBean.getComissaoExtList().size(); i++) {  
    			ComissaoExternaVO comissaoExternaVO = (ComissaoExternaVO) tradeFinanceBean.getComissaoExtList().get(i);

    			listLog.getDepois().add(comissaoExternaVO.geticondeconc() + ", " +
    					comissaoExternaVO.getvpcelacomiscmbio() + ", " +
    					comissaoExternaVO.getpcomisnegoccmbio() + ", " +
    					comissaoExternaVO.getiperdcjurocmbio() + ", " + 
    					comissaoExternaVO.getisglindcdfonte() + ", " +
    					comissaoExternaVO.getifluxoperdccmbio() + ", " +
    					comissaoExternaVO.getdescrmomento());
    		}

    		// Verifica qual é o maior e o menor tamanho de lista (label_comissao_adicional)
    		if (listLog.getAntes().size() > listLog.getDepois().size()) {
    			bigger = listLog.getAntes().size();
    			lower = listLog.getDepois().size();
    			isPreviousBigger = true;
    		} else {
    			bigger = listLog.getDepois().size();
    			lower = listLog.getAntes().size();
    			isPreviousBigger = false;
    		}

    		// Adiciona a label_comissao_adicional na lista
    		log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_comissao_adicional", listLog));

    	}

    	return log;
    }

    // Metodo referente aos campos da tela dadosModeloBoletoCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosModeloBoleto(){
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	log.add(new TradeFinanceLogDiferencasVo("label_det_modelo_blt", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDmodcontrcmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getDmodcontrcmbio()));

    	return log;
    }

    // Metodo referente aos campos da tela dadosObsOutrasEspecificacoesCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosObsOutrasEspecificacoes(){
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	log.add(new TradeFinanceLogDiferencasVo("label_det_obs_interno", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao1(), 
    			tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao1()));

    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao2().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao2().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao2(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao2()));
    	}
 
    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao3().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao3().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao3(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao3()));
    	}

    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao4().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao4().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao4(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao4()));
    	}

    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao5().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao5().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao5(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao5()));
    	}

    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao6().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao6().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao6(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao6()));
    	}

    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao7().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao7().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao7(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao7()));
    	}

    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao8().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao8().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao8(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao8()));
    	}

    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao9().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao9().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao9(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao9()));
    	}

    	if(!tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao10().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao10().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo(" ", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getObservacao10(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getObservacao10()));
    	}
    	 
    	log.add(new TradeFinanceLogDiferencasVo("label_det_outras_espc", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getOutrasespcs(), 
    			tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getOutrasespcs()));

    	if(tradeFinMonitBean.getTradeFinanceListaVO().getProduto().isNce()){
    		log.add(new TradeFinanceLogDiferencasVo("label_orcamento", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getOrcamento(), 
    				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getOrcamento()));
    	}

    	return log;
    }

    // Metodo referente aos campos da tela dadosValorMoedaForfaitingCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosValorMoedaForfaiting(){
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_operacao", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedaoperacao(), 
    			tradeFinanceBean.getTradeFinanceVO().getMoedaoperacao()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_desembolso", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedadesembolso(), 
    			tradeFinanceBean.getTradeFinanceVO().getMoedadesembolso()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_valor_ME", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getVnegocmoedaestrg(), 
    			tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg()));

    	log.add(new TradeFinanceLogDiferencasVo("label_data_disponibilidade", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDprevtgarntexpdi(), 
    			tradeFinanceBean.getTradeFinanceVO().getDprevtgarntexpdi()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_prev_desembolso", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataDataDesembIni(), 
    			tradeFinanceBean.getTradeFinanceVO().getFormataDataDesembIni()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedalimite(), 
    			tradeFinanceBean.getTradeFinanceVO().getMoedalimite()));

    	log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite_vlr", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getVmoedalimgerc(), 
    			tradeFinanceBean.getTradeFinanceVO().getVmoedalimgerc()));


    	log.add(new TradeFinanceLogDiferencasVo("label_prev_embarque", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getDprevtinicembrq(), 
    			tradeFinanceBean.getTradeFinanceVO().getDprevtinicembrq()));


    	log.add(new TradeFinanceLogDiferencasVo("label_prazo_lestras", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiavalddletra(), 
    			tradeFinanceBean.getTradeFinanceVO().getTdiavalddletra()));


    	log.add(new TradeFinanceLogDiferencasVo("label_det_prazo_financiamento", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiaopercmbio(), 
    			tradeFinanceBean.getTradeFinanceVO().getTdiaopercmbio()));

    	return log;
    }

    // Metodo referente aos campos da tela dadosTomadorCons.xhtml
    private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosTomador(){
    	List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

    	log.add(new TradeFinanceLogDiferencasVo("label_det_tomador", 
    			tradeFinanceBean.getTradeFinanceDiferencasVO().getNcunicpssoacmbiot(), 
    			tradeFinanceBean.getTradeFinanceVO().getNcunicpssoacmbiot()));

    	if(tradeFinMonitBean.getTradeFinanceListaVO().getProduto().getCodigo().equals(644)){
    		log.add(new TradeFinanceLogDiferencasVo("label_about", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getComissaoInterna(), 
    				tradeFinanceBean.getTradeFinanceVO().getComissaoInterna()));


    		log.add(new TradeFinanceLogDiferencasVo("label_percentual_about", 
    				tradeFinanceBean.getTradeFinanceDiferencasVO().getPcobervarprodt(), 
    				tradeFinanceBean.getTradeFinanceVO().getPcobervarprodt()));
    	}

    	return log;
    }
	
	// Metodo referente aos campos da tela dadosPrecificacaoCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosPrecificacao(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

		if(tradeFinanceBean.getViewHelper().isRenderPrecificacao()){
			if(!tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(1715)){
				log.add(new TradeFinanceLogDiferencasVo("label_unidade_externa_bco_corres", 
						tradeFinanceBean.getTradeFinanceDiferencasVO().getDbcoextcmbio(), 
						tradeFinanceBean.getTradeFinanceVO().getDbcoextcmbio()));
				
				log.add(new TradeFinanceLogDiferencasVo("label_det_bc_ree_desembolsador", 
						tradeFinanceBean.getTradeFinanceDiferencasVO().getDbcorecebedor(), 
						tradeFinanceBean.getTradeFinanceVO().getDbcorecebedor()));
			}else {
				log.add(new TradeFinanceLogDiferencasVo("label_orgao_governam", 
						tradeFinanceBean.getTradeFinanceDiferencasVO().getIorgextercmbio(), 
						tradeFinanceBean.getTradeFinanceVO().getIorgextercmbio()));
			}

			log.add(new TradeFinanceLogDiferencasVo("label_praca", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPraca(), 
					tradeFinanceBean.getTradeFinanceVO().getPraca()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_dt_ctc", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getDcotacfndngcmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getDcotacfndngcmbio()));
		}

		log.add(new TradeFinanceLogDiferencasVo("label_det_tx_fixa", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getPtxfixacmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getPtxfixacmbio()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_libor", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getPreclibor(), 
				tradeFinanceBean.getTradeFinanceVO().getPreclibor()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_validade_dias", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiaopercmbioprcf(), 
				tradeFinanceBean.getTradeFinanceVO().getTdiaopercmbioprcf()));

		if(tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(644)){
			log.add(new TradeFinanceLogDiferencasVo("label_com_desemb", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVlrcomisdsemb(), 
					tradeFinanceBean.getTradeFinanceVO().getVlrcomisdsemb()));
		}

		return log;
	}
	
	// Metodo referente aos campos da tela dadosPrecificacaoTxCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosPrecificacaoTx(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_libor_travada", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVtravaliborcmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getVtravaliborcmbio()));

		if(!tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(644)
				&& !tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(2011)
				&& !tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(1642)){
			log.add(new TradeFinanceLogDiferencasVo("label_det_IR", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVimpstnegoccmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getVimpstnegoccmbio()));
		}
		
		if(!tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(644)
				&& !tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(2011)){
			log.add(new TradeFinanceLogDiferencasVo("label_det_IOF", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getViofnegoccmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getViofnegoccmbio()));
		}

		log.add(new TradeFinanceLogDiferencasVo("label_det_juros_mora", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxmoracmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getVtxmoracmbio()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_multa", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVmultanegoccmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getVmultanegoccmbio()));
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosComissaoBanqueiroCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosComissaoBanqueiro(){
		int bigger = 0;
	    int lower = 0;
	    boolean isPreviousBigger = false;
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();
		
		if(tradeFinanceBean.getViewHelper().isRenderComissao()){
			
			for (int i = 0; i < tradeFinanceBean.getComissaoExtListDiferencas().getComissaoBanqueiro().size(); i++) {  
				ComissaoExternaVO comissaoExternaVO = (ComissaoExternaVO) tradeFinanceBean.getComissaoExtListDiferencas().getComissaoBanqueiro().get(i);
				
				listLog.getAntes().add(comissaoExternaVO.geticondeconc() + ", " +
						comissaoExternaVO.getvpcelacomiscmbio() + ", " +
						comissaoExternaVO.getpcomisnegoccmbio() + ", " +
						comissaoExternaVO.getiperdcjurocmbio() + ", " + 
						comissaoExternaVO.getisglindcdfonte() + ", " +
						comissaoExternaVO.getifluxoperdccmbio() + ", " +
						comissaoExternaVO.getdescrmomento() + ", " +
						comissaoExternaVO.getqpcelacmbiotrade());
			}
			
			for (int i = 0; i < tradeFinanceBean.getComissaoExtList().getComissaoBanqueiro().size(); i++) {  
				ComissaoExternaVO comissaoExternaVO = (ComissaoExternaVO) tradeFinanceBean.getComissaoExtList().getComissaoBanqueiro().get(i);
				
				listLog.getDepois().add(comissaoExternaVO.geticondeconc() + ", " +
						comissaoExternaVO.getvpcelacomiscmbio() + ", " +
						comissaoExternaVO.getpcomisnegoccmbio() + ", " +
						comissaoExternaVO.getiperdcjurocmbio() + ", " + 
						comissaoExternaVO.getisglindcdfonte() + ", " +
						comissaoExternaVO.getifluxoperdccmbio() + ", " +
						comissaoExternaVO.getdescrmomento() + ", " +
						comissaoExternaVO.getqpcelacmbiotrade());
			}
			
			// Verifica qual é o maior e o menor tamanho de lista (label_comissao_banqueiro)
	        if (listLog.getAntes().size() > listLog.getDepois().size()) {
	            bigger = listLog.getAntes().size();
	            lower = listLog.getDepois().size();
	            isPreviousBigger = true;
	        } else {
	            bigger = listLog.getDepois().size();
	            lower = listLog.getAntes().size();
	            isPreviousBigger = false;
	        }
	    	
	        // Adiciona a label_comissao_banqueiro na lista
	    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_comissao_int", listLog));
			
	    	// Não coloquei o modal dadosComissaoModalCons.xhtml	    	
			
		}
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosComissaoIntForfaitingCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosComissaoIntForfaiting(){
		int bigger = 0;
	    int lower = 0;
	    boolean isPreviousBigger = false;
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();
		
		
		if(tradeFinanceBean.getViewHelper().isRenderComissaoInterna()){
			log.add(new TradeFinanceLogDiferencasVo("label_det_spread_apvr", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxspreadaprov(), 
					tradeFinanceBean.getTradeFinanceVO().getVtxspreadaprov()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_det_spread_negoc", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxspreadnegoc(), 
					tradeFinanceBean.getTradeFinanceVO().getVtxspreadnegoc()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_spread_total", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxspreadtot(), 
					tradeFinanceBean.getTradeFinanceVO().getVtxspreadtot()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_custo_total", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getDescctotal(), 
					tradeFinanceBean.getTradeFinanceVO().getDescctotal()));
			
		}

		for (int i = 0; i < tradeFinanceBean.getTradeFinanceDiferencasVO().getListaDesembolso().size(); i++) {  
			listLog.getAntes().add(tradeFinanceBean.getTradeFinanceDiferencasVO().getListaDesembolso().get(i).getDataDesembolsoFormat() + ", " +
					   (tradeFinanceBean.getTradeFinanceDiferencasVO().isForfaitingTipoJuroEmbutido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVprevtdsembcmbio() + ", " : "" ) +
					   (tradeFinanceBean.getTradeFinanceDiferencasVO().isForfaitingTipoJuroDeduzido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVdsembnegoccmbio() + ", " : "" ) +
						tradeFinanceBean.getTradeFinanceDiferencasVO().getListaDesembolso().get(i).getVtxliborcmbio() + ", " + 
						tradeFinanceBean.getTradeFinanceDiferencasVO().getListaDesembolso().get(i).getPtxjurofndng() + ", " +
						tradeFinanceBean.getTradeFinanceDiferencasVO().getListaDesembolso().get(i).getPspreadtxcmbio() + ", " +
						tradeFinanceBean.getTradeFinanceDiferencasVO().getListaDesembolso().get(i).getPjuronegoccmbio() + ", " +
					   (tradeFinanceBean.getTradeFinanceDiferencasVO().isForfaitingTipoJuroDeduzido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getTaxaDescontada() + ", " : "") +
						tradeFinanceBean.getTradeFinanceDiferencasVO().getListaDesembolso().get(i).getTdiafinandsemb() + ", " +
						tradeFinanceBean.getTradeFinanceDiferencasVO().getListaDesembolso().get(i).getVjurodsembcmbio() + ", " +
					   (tradeFinanceBean.getTradeFinanceDiferencasVO().isForfaitingTipoJuroDeduzido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVprevtdsembcmbio() + ", " : "") +
					   (tradeFinanceBean.getTradeFinanceDiferencasVO().isForfaitingTipoJuroEmbutido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVdsembnegoccmbio() : ""));
		}
		
		for (int i = 0; i < tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().size(); i++) {  
			listLog.getDepois().add(tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getDataDesembolsoFormat() + ", " +
				   (tradeFinanceBean.getTradeFinanceVO().isForfaitingTipoJuroEmbutido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVprevtdsembcmbio() + ", " : "" ) +
				   (tradeFinanceBean.getTradeFinanceVO().isForfaitingTipoJuroDeduzido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVdsembnegoccmbio() + ", " : "" ) +
					tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVtxliborcmbio() + ", " + 
					tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getPtxjurofndng() + ", " +
					tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getPspreadtxcmbio() + ", " +
					tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getPjuronegoccmbio() + ", " +
				   (tradeFinanceBean.getTradeFinanceVO().isForfaitingTipoJuroDeduzido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getTaxaDescontada() + ", " : "") +
					tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getTdiafinandsemb() + ", " +
					tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVjurodsembcmbio() + ", " +
				   (tradeFinanceBean.getTradeFinanceVO().isForfaitingTipoJuroDeduzido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVprevtdsembcmbio() + ", " : "") +
				   (tradeFinanceBean.getTradeFinanceVO().isForfaitingTipoJuroEmbutido() ? tradeFinanceBean.getTradeFinanceVO().getListaDesembolso().get(i).getVdsembnegoccmbio() : ""));
		}
		
		// Verifica qual é o maior e o menor tamanho de lista (label_comissao_int)
        if (listLog.getAntes().size() > listLog.getDepois().size()) {
            bigger = listLog.getAntes().size();
            lower = listLog.getDepois().size();
            isPreviousBigger = true;
        } else {
            bigger = listLog.getDepois().size();
            lower = listLog.getAntes().size();
            isPreviousBigger = false;
        }
    	
        // Adiciona a label_comissao_int na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_comissao_int", listLog));
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosForFaitingEmbutDeduzCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosForFaitingEmbutDeduz(){
		int bigger = 0;
	    int lower = 0;
	    boolean isPreviousBigger = false;
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();
		
		for (int i = 0; i < tradeFinanceBean.getQuadroOperacaoForfaitingDiferencas().size(); i++) {  
			listLog.getAntes().add(tradeFinanceBean.getQuadroOperacaoForfaitingDiferencas().get(i).getInfoCol1() + ", " +
					tradeFinanceBean.getQuadroOperacaoForfaitingDiferencas().get(i).getInfoCol2()); 
		}
			
		for (int i = 0; i < tradeFinanceBean.getQuadroOperacaoForfaiting().size(); i++) {  
				listLog.getDepois().add(tradeFinanceBean.getQuadroOperacaoForfaiting().get(i).getInfoCol1() + ", " +
						tradeFinanceBean.getQuadroOperacaoForfaiting().get(i).getInfoCol2());
		}
		
		// Verifica qual é o maior e o menor tamanho de lista (label_lista_juros)
        if (listLog.getAntes().size() > listLog.getDepois().size()) {
            bigger = listLog.getAntes().size();
            lower = listLog.getDepois().size();
            isPreviousBigger = true;
        } else {
            bigger = listLog.getDepois().size();
            lower = listLog.getAntes().size();
            isPreviousBigger = false;
        }
    	
        // Adiciona a label_lista_juros na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_lista_juros", listLog));
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosComissaoCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosComissao(){
		int bigger = 0;
	    int lower = 0;
	    boolean isPreviousBigger = false;
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();
		
		
		if(tradeFinanceBean.getViewHelper().isRenderComissao()){
			
			for (int i = 0; i < tradeFinanceBean.getComissaoExtListDiferencas().getComissaoBanqueiro().size(); i++) {  
				ComissaoExternaVO comissaoExternaVO = (ComissaoExternaVO) tradeFinanceBean.getComissaoExtListDiferencas().getComissaoBanqueiro().get(i);
				
				listLog.getAntes().add(comissaoExternaVO.geticondeconc() + ", " +
						comissaoExternaVO.getvpcelacomiscmbio() + ", " +
						comissaoExternaVO.getpcomisnegoccmbio() + ", " +
						comissaoExternaVO.getiperdcjurocmbio() + ", " + 
						comissaoExternaVO.getisglindcdfonte() + ", " +
						comissaoExternaVO.getifluxoperdccmbio() + ", " +
						comissaoExternaVO.getdescrmomento() + ", " +
						comissaoExternaVO.getqpcelacmbiotrade());
			}
			
			for (int i = 0; i < tradeFinanceBean.getComissaoExtList().getComissaoBanqueiro().size(); i++) {  
				ComissaoExternaVO comissaoExternaVO = (ComissaoExternaVO) tradeFinanceBean.getComissaoExtList().getComissaoBanqueiro().get(i);
				
				listLog.getDepois().add(comissaoExternaVO.geticondeconc() + ", " +
						comissaoExternaVO.getvpcelacomiscmbio() + ", " +
						comissaoExternaVO.getpcomisnegoccmbio() + ", " +
						comissaoExternaVO.getiperdcjurocmbio() + ", " + 
						comissaoExternaVO.getisglindcdfonte() + ", " +
						comissaoExternaVO.getifluxoperdccmbio() + ", " +
						comissaoExternaVO.getdescrmomento() + ", " +
						comissaoExternaVO.getqpcelacmbiotrade());
			}
			
			// Verifica qual é o maior e o menor tamanho de lista (label_comissao_adicional)
	        if (listLog.getAntes().size() > listLog.getDepois().size()) {
	            bigger = listLog.getAntes().size();
	            lower = listLog.getDepois().size();
	            isPreviousBigger = true;
	        } else {
	            bigger = listLog.getDepois().size();
	            lower = listLog.getAntes().size();
	            isPreviousBigger = false;
	        }
	    	
	        // Adiciona a label_comissao_adicional na lista
	    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_comissao_adicional", listLog));
		}

    	// Não coloquei o modal dadosComissaoModalCons.xhtml
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosValorMoedaCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosValorMoeda(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_operacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedaoperacao(), 
				tradeFinanceBean.getTradeFinanceVO().getMoedaoperacao()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_desembolso", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedadesembolso(), 
				tradeFinanceBean.getTradeFinanceVO().getMoedadesembolso()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_valor_ME", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVnegocmoedaestrg(), 
				tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_prev_desembolso", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDprevtdsembcmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getDprevtdsembcmbio()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedalimite(), 
				tradeFinanceBean.getTradeFinanceVO().getMoedalimite()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite_vlr", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVmoedalimgerc(), 
				tradeFinanceBean.getTradeFinanceVO().getVmoedalimgerc()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_pzr_operacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiaopercmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getTdiaopercmbio()));
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosSwapPtaxSpreadCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosSwapPtaxSpread(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		if(tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(1715)){
			log.add(new TradeFinanceLogDiferencasVo("label_det_n_apr_cred", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getNseqcontrlim(), 
					tradeFinanceBean.getTradeFinanceVO().getNseqcontrlim()));
		}
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_swap", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getCindcdnegocswap(), 
				tradeFinanceBean.getTradeFinanceVO().getCindcdnegocswap()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_libor", 
				(tradeFinanceBean.isLiborDiferencas()) ? "Sim" : "Não",  
				(tradeFinanceBean.isLibor()) ? "Sim" : "Não" ));

		log.add(new TradeFinanceLogDiferencasVo("label_det_fluxo", 
				(tradeFinanceBean.isFluxoDiferencas()) ? "Sim" : "Não", 
				(tradeFinanceBean.isFluxo()) ? "Sim" : "Não"));
		
		log.add(new TradeFinanceLogDiferencasVo("label_ME_MN", 
				(tradeFinanceBean.isMeMnDiferencas()) ? "Sim" : "Não", 
				(tradeFinanceBean.isMeMn()) ? "Sim" : "Não"));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_ptax", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDescrptax(), 
				tradeFinanceBean.getTradeFinanceVO().getDescrptax()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_spread_all", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getPtxswapcmpdo(), 
				tradeFinanceBean.getTradeFinanceVO().getPtxswapcmpdo()));
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosStandByCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosStandBy(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		if(!tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(2692)
				&& !tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(717)){
			log.add(new TradeFinanceLogDiferencasVo("label_det_standBy", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getCindcdnegoccarta(), 
					tradeFinanceBean.getTradeFinanceVO().getCindcdnegoccarta()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_pzr_standBy", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiavalddletra(), 
					tradeFinanceBean.getTradeFinanceVO().getTdiavalddletra()));
		}
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_comissao_standBy_br", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getCcomiscartanacio(), 
				tradeFinanceBean.getTradeFinanceVO().getCcomiscartanacio()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_arbitragem", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getCindcdnegocarbtr(), 
				tradeFinanceBean.getTradeFinanceVO().getCindcdnegocarbtr()));
		
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosFluxoPagamentoCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosFluxoPagamento(){
		int bigger = 0;
	    int lower = 0;
	    boolean isPreviousBigger = false;
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();
		
		if(tradeFinanceBean.getViewHelper().isRenderFluxoPagto()) {
			log.add(new TradeFinanceLogDiferencasVo("label_det_princ_dias", 
					tradeFinanceBean.getFluxoPgtDiferencasVO().getTdiacarenprinc(), 
					tradeFinanceBean.getFluxoPgtVO().getTdiacarenprinc()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_periodicidade", 
					tradeFinanceBean.getFluxoPgtDiferencasVO().getDfluxoliqdcprinc(), 
					tradeFinanceBean.getFluxoPgtVO().getDfluxoliqdcprinc()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_det_qtde_parcelas", 
					tradeFinanceBean.getFluxoPgtDiferencasVO().getQpcelatradeprinc(), 
					tradeFinanceBean.getFluxoPgtVO().getQpcelatradeprinc()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_det_juros_dias", 
					tradeFinanceBean.getFluxoPgtDiferencasVO().getTdiacarenjuro(),  
					tradeFinanceBean.getFluxoPgtVO().getTdiacarenjuro()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_det_periodicidade", 
					tradeFinanceBean.getFluxoPgtDiferencasVO().getDfluxoliqdcjuro(), 
					tradeFinanceBean.getFluxoPgtVO().getDfluxoliqdcjuro()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_det_qtde_parcelas", 
					tradeFinanceBean.getFluxoPgtDiferencasVO().getQpcelatradejuro(), 
					tradeFinanceBean.getFluxoPgtVO().getQpcelatradejuro()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_det_momento", 
					tradeFinanceBean.getFluxoPgtDiferencasVO().getDescrmomen(), 
					tradeFinanceBean.getFluxoPgtVO().getDescrmomen()));
			
			log.add(new TradeFinanceLogDiferencasVo("label_det_juro_moeda_nac", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getMontaJurosMoedaNac(), 
					tradeFinanceBean.getTradeFinanceVO().getMontaJurosMoedaNac()));
			
			for (int i = 0; i < tradeFinanceBean.getFluxoPgtListDiferencas().size(); i++) {  
	    		listLog.getAntes().add(tradeFinanceBean.getFluxoPgtListDiferencas().get(i).getDprevtdsembcmbio() + ", " +
	    				tradeFinanceBean.getFluxoPgtListDiferencas().get(i).getTdiafinandsemb() + ", " +
	    				tradeFinanceBean.getFluxoPgtListDiferencas().get(i).getVprevtdsembcmbio());
	    	}

			for (int i = 0; i < tradeFinanceBean.getFluxoPgtList().size(); i++) {  
	    		listLog.getDepois().add(tradeFinanceBean.getFluxoPgtList().get(i).getDprevtdsembcmbio() + ", " +
	    				tradeFinanceBean.getFluxoPgtList().get(i).getTdiafinandsemb() + ", " +
	    				tradeFinanceBean.getFluxoPgtList().get(i).getVprevtdsembcmbio());
	    	}

	    	// Verifica qual é o maior e o menor tamanho de lista (label_lista_fluxo_pagamento)
	    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
	    		bigger = listLog.getAntes().size();
	    		lower = listLog.getDepois().size();
	    		isPreviousBigger = true;
	    	} else {
	    		bigger = listLog.getDepois().size();
	    		lower = listLog.getAntes().size();
	    		isPreviousBigger = false;
	    	}

	    	// Adiciona a label_lista_fluxo_pagamento na lista
	    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_lista_fluxo_pagamento", listLog));
	    	
	    	log.add(new TradeFinanceLogDiferencasVo("label_prazo_medio_dia_ano", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPzroprdiaano(), 
					tradeFinanceBean.getTradeFinanceVO().getPzroprdiaano()));
		}
		
		// Não coloquei a o modal dadosFluxoPagamentoModalCons.xhtml
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosComissaoInternaCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosComissaoInterna(){
		int bigger = 0;
	    int lower = 0;
	    boolean isPreviousBigger = false;
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();
		
		if(tradeFinMonitBean.getTradeFinanceListaVO().getProduto().getCodigo().equals(2018)){
			log.add(new TradeFinanceLogDiferencasVo("label_det_cobranca_comissao_about", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getComissaoInterna(), 
					tradeFinanceBean.getTradeFinanceVO().getComissaoInterna()));
		}

		log.add(new TradeFinanceLogDiferencasVo("label_det_cobranca_comissao", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getDescrComissao(), 
				tradeFinanceBean.getComissaoInternaVO().getDescrComissao()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_comissao", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getValorComissaoBoleto(), 
				tradeFinanceBean.getComissaoInternaVO().getValorComissaoBoleto()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_comissao", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getIsglindcdeconmmoeda(), 
				tradeFinanceBean.getComissaoInternaVO().getIsglindcdeconmmoeda()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_det_comissao_sobre", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getIdentificaCobranca(), 
				tradeFinanceBean.getComissaoInternaVO().getIdentificaCobranca()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_det_minimo_cobrar", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getVmincobrcomis(), 
				tradeFinanceBean.getComissaoInternaVO().getVmincobrcomis()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_det_spread_apvr", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getVtxspreadaprov(), 
				tradeFinanceBean.getComissaoInternaVO().getVtxspreadaprov()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_det_spread_negoc", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getVtxspreadnegoc(), 
				tradeFinanceBean.getComissaoInternaVO().getVtxspreadnegoc()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_det_flat", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getPtxflatpnalt(), 
				tradeFinanceBean.getComissaoInternaVO().getPtxflatpnalt()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_det_valor", 
				tradeFinanceBean.getComissaoInternaDiferencasVO().getVlxtotalcomis(), 
				tradeFinanceBean.getComissaoInternaVO().getVlxtotalcomis()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_spread_total", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxspreadtot(), 
				tradeFinanceBean.getTradeFinanceVO().getVtxspreadtot()));
		
		for (int i = 0; i < tradeFinanceBean.getComissaoIntListDiferencas().size(); i++) {  
    		listLog.getAntes().add(
    				((!tradeFinanceBean.getTradeFinanceDiferencasVO().getProduto().isGarantia() 
    						&& !tradeFinanceBean.getTradeFinanceDiferencasVO().getProduto().getCodigo().equals(2018)) ? 
    								tradeFinanceBean.getComissaoIntListDiferencas().get(i).getDprevtdsembcmbio() + ", " : "" ) +
    				((tradeFinanceBean.getTradeFinanceDiferencasVO().getProduto().isGarantia()) ?
    						tradeFinanceBean.getTradeFinanceDiferencasVO().getDprevtgarntexpdi() + ", " : "" ) +
    				((tradeFinanceBean.getTradeFinanceDiferencasVO().getProduto().getCodigo().equals(2018)) ?
    						tradeFinanceBean.getTradeFinanceDiferencasVO().getDinclreg() + ", " : "" ) +
    				tradeFinanceBean.getComissaoIntListDiferencas().get(i).getIfluxoperdccmbio() + ", " +
    				tradeFinanceBean.getComissaoIntListDiferencas().get(i).getDescrmomento() + ", " +
    				tradeFinanceBean.getComissaoIntListDiferencas().get(i).getIsglindcdeconmmoeda() + ", " +
    				tradeFinanceBean.getComissaoIntListDiferencas().get(i).getVprevtcomiscmbio()); 
    	}

		for (int i = 0; i < tradeFinanceBean.getComissaoIntList().size(); i++) {  
			listLog.getDepois().add(
    				((!tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia() 
    						&& !tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(2018)) ? 
    								tradeFinanceBean.getComissaoIntList().get(i).getDprevtdsembcmbio() + ", " : "" ) +
    				((tradeFinanceBean.getTradeFinanceVO().getProduto().isGarantia()) ?
    						tradeFinanceBean.getTradeFinanceVO().getDprevtgarntexpdi() + ", " : "" ) +
    				((tradeFinanceBean.getTradeFinanceVO().getProduto().getCodigo().equals(2018)) ?
    						tradeFinanceBean.getTradeFinanceVO().getDinclreg() + ", " : "" ) +
    				tradeFinanceBean.getComissaoIntList().get(i).getIfluxoperdccmbio() + ", " +
    				tradeFinanceBean.getComissaoIntList().get(i).getDescrmomento() + ", " +
    				tradeFinanceBean.getComissaoIntList().get(i).getIsglindcdeconmmoeda() + ", " +
    				tradeFinanceBean.getComissaoIntList().get(i).getVprevtcomiscmbio());
    	}

    	// Verifica qual é o maior e o menor tamanho de lista (label_lista_comissao_interna)
    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
    		bigger = listLog.getAntes().size();
    		lower = listLog.getDepois().size();
    		isPreviousBigger = true;
    	} else {
    		bigger = listLog.getDepois().size();
    		lower = listLog.getAntes().size();
    		isPreviousBigger = false;
    	}

    	// Adiciona a label_lista_comissao_interna na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_lista_comissao_interna", listLog));
    	
    	log.add(new TradeFinanceLogDiferencasVo("label_det_custo_total", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDescctotal(), 
				tradeFinanceBean.getTradeFinanceVO().getDescctotal()));
		
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosValorMoedaProexCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosValorMoedaProex(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_operacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedaoperacao(), 
				tradeFinanceBean.getTradeFinanceVO().getMoedaoperacao()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_valor_ME", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVnegocmoedaestrg(), 
				tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg()));
		

		log.add(new TradeFinanceLogDiferencasVo("label_det_prazo_operacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiaopercmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getTdiaopercmbio()));
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosProexCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosProex(){
		int bigger = 0;
	    int lower = 0;
	    boolean isPreviousBigger = false;
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();
		
		log.add(new TradeFinanceLogDiferencasVo("label_taxa_equalizacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getPtxequalcmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getPtxequalcmbio()));

		log.add(new TradeFinanceLogDiferencasVo("label_prazo_medio", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getQprzmedcmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getQprzmedcmbio()));

		log.add(new TradeFinanceLogDiferencasVo("label_valor_equalizavel", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getValorEqualizavel(), 
				tradeFinanceBean.getTradeFinanceVO().getValorEqualizavel()));

		log.add(new TradeFinanceLogDiferencasVo("label_spread_media", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxspreadnegoc(), 
				tradeFinanceBean.getTradeFinanceVO().getVtxspreadnegoc()));

		log.add(new TradeFinanceLogDiferencasVo("label_receita", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getReceitaEstimada(), 
				tradeFinanceBean.getTradeFinanceVO().getReceitaEstimada()));

		log.add(new TradeFinanceLogDiferencasVo("label_despesa", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDespconf(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDespconf()));

		for (int i = 0; i < tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getListaRebate().size(); i++) {  
    		listLog.getAntes().add(tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getListaRebate().get(i).getRebate());
    	}
		
		for (int i = 0; i < tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getListaRebate().size(); i++) {  
    		listLog.getDepois().add(tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getListaRebate().get(i).getRebate());
    	}

    	// Verifica qual é o maior e o menor tamanho de lista (label_rebate)
    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
    		bigger = listLog.getAntes().size();
    		lower = listLog.getDepois().size();
    		isPreviousBigger = true;
    	} else {
    		bigger = listLog.getDepois().size();
    		lower = listLog.getAntes().size();
    		isPreviousBigger = false;
    	}

    	// Adiciona a label_rebate na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_rebate", listLog));
    	
    	
    	log.add(new TradeFinanceLogDiferencasVo("label_desconto_ntns", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDespdesc(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDespdesc()));
    	
    	log.add(new TradeFinanceLogDiferencasVo("label_forma_amortizacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getFormamor(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getFormamor()));
		
    	listLog.getAntes().clear();
    	listLog.getDepois().clear();
    	
    	for (int i = 0; i < tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getListaTaxa().size(); i++) {  
    		listLog.getAntes().add(tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getListaTaxa().get(i).getTxades());
    	}
		
    	for (int i = 0; i < tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getListaTaxa().size(); i++) {  
    		listLog.getDepois().add(tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getListaTaxa().get(i).getTxades());
    	}

    	// Verifica qual é o maior e o menor tamanho de lista (label_taxa_de_desconto)
    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
    		bigger = listLog.getAntes().size();
    		lower = listLog.getDepois().size();
    		isPreviousBigger = true;
    	} else {
    		bigger = listLog.getDepois().size();
    		lower = listLog.getAntes().size();
    		isPreviousBigger = false;
    	}

    	// Adiciona a label_taxa_de_desconto na lista
    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_taxa_de_desconto", listLog));
		
    	log.add(new TradeFinanceLogDiferencasVo("label_credor", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDbcocred(), 
				tradeFinanceBean.getTradeFinanceVO().getDbcocred()));
		
    	log.add(new TradeFinanceLogDiferencasVo("label_garantias", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getGarantias(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGarantias()));
    	
    	if(!tradeFinanceBean.getTradeFinanceVO().getDinicvalddppsta().isEmpty() 
    			&& !tradeFinanceBean.getTradeFinanceVO().getDfimvalddppsta().isEmpty() 
    			&& !tradeFinanceBean.getTradeFinanceDiferencasVO().getDinicvalddppsta().isEmpty()
    			&& !tradeFinanceBean.getTradeFinanceDiferencasVO().getDfimvalddppsta().isEmpty()){
    		log.add(new TradeFinanceLogDiferencasVo("label_validade_proposta",  
    				(!tradeFinanceBean.getTradeFinanceDiferencasVO().getDinicvalddppsta().isEmpty() && !tradeFinanceBean.getTradeFinanceDiferencasVO().getDfimvalddppsta().isEmpty()) ?
    						tradeFinanceBean.getTradeFinanceDiferencasVO().getDinicvalddppsta() + " Até " + tradeFinanceBean.getTradeFinanceDiferencasVO().getDfimvalddppsta() : "", 
    						(!tradeFinanceBean.getTradeFinanceVO().getDinicvalddppsta().isEmpty() && !tradeFinanceBean.getTradeFinanceVO().getDfimvalddppsta().isEmpty()) ?
    								tradeFinanceBean.getTradeFinanceVO().getDinicvalddppsta() + " Até " + tradeFinanceBean.getTradeFinanceVO().getDfimvalddppsta() : ""));
    	}
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosPrecificacaoEcaCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosPrecificacaoEca(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		if(tradeFinanceBean.getViewHelper().isRenderPrecificacao()){
			log.add(new TradeFinanceLogDiferencasVo("label_orgao_governam", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getIorgextercmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getIorgextercmbio()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_validade_dias", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiaopercmbioprcf(), 
					tradeFinanceBean.getTradeFinanceVO().getTdiaopercmbioprcf()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_dt_ctc", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getDcotacfndngcmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getDcotacfndngcmbio()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_tx_fixa", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPtxfixacmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getPtxfixacmbio()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_libor", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPreclibor(), 
					tradeFinanceBean.getTradeFinanceVO().getPreclibor()));
		}
		
		return log;
	}

	// Metodo referente aos campos da tela dadosValorMoedaBndesPosCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosValorMoedaBndesPos(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_operacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedaoperacao(), 
				tradeFinanceBean.getTradeFinanceVO().getMoedaoperacao()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_valor_ME", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVnegocmoedaestrg(), 
				tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedalimite(), 
				tradeFinanceBean.getTradeFinanceVO().getMoedalimite()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_pzr_operacao_mes", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiaopercmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getTdiaopercmbio()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_porte", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDescrPorte(), 
				tradeFinanceBean.getTradeFinanceVO().getDescrPorte()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_valor_fin", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVprevtrectacmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getVprevtrectacmbio()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite_vlr", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVmoedalimgerc(), 
				tradeFinanceBean.getTradeFinanceVO().getVmoedalimgerc()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_grupo", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDescrGrupo(), 
				tradeFinanceBean.getTradeFinanceVO().getDescrGrupo()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_carencia_meses", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiacarenprinc(), 
				tradeFinanceBean.getTradeFinanceVO().getTdiacarenprinc()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_amortizacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getAmortizar(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getAmortizar()));
		
		return log;
	}

	// Metodo referente aos campos da tela dadosGarantidorBndesPosCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosGarantidorBndesPos(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_garantidor_brad", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getGarantFormataDados(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGarantFormataDados()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_bc_garantidor", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDbcocred(), 
				tradeFinanceBean.getTradeFinanceVO().getDbcocred()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_condicao_bc_garantidor", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getGarancondbgar(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGarancondbgar()));
		
		if(!tradeFinanceBean.getTradeFinanceVO().getCcobrcomismtori().equals('0')){
			log.add(new TradeFinanceLogDiferencasVo("label_det_comiss_bc_mandat", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPcomismtoricmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getPcomismtoricmbio()));
		}
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_cobranca_comissao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getCobranComissBancoMand(), 
				tradeFinanceBean.getTradeFinanceVO().getCobranComissBancoMand()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_condic_bc_mandat", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getGarancondbman(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGarancondbman()));
		
		if(!tradeFinanceBean.getTradeFinanceVO().getCcobrcomisagte().equals('0')){
			log.add(new TradeFinanceLogDiferencasVo("label_det_comiss_ag_fin_gar", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPagtefincrcmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getPagtefincrcmbio()));
		}
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_cobranca_comissao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getCobranComissAgente(), 
				tradeFinanceBean.getTradeFinanceVO().getCobranComissAgente()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_condic_ag_fin_gar", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getGarancondagfi(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGarancondagfi()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_dt_limite_fro", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDlimenviorsumo(), 
				tradeFinanceBean.getTradeFinanceVO().getDlimenviorsumo()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_dt_venc_prop", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getFormatadDataVencProsposta(), 
				tradeFinanceBean.getTradeFinanceVO().getFormatadDataVencProsposta()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_qtde_re", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getQregexporcmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getQregexporcmbio()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_importador", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getGaranimport(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGaranimport()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_mercadoria", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getMercadoria(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getMercadoria()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_qtde_embarque", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getQprevtembrqcmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getQprevtembrqcmbio()));
		
		if(tradeFinanceBean.getTradeFinanceVO().getDprevtfimembrq() != null 
				&& tradeFinanceBean.getTradeFinanceVO().getDprevtfimembrq() != ""){
			log.add(new TradeFinanceLogDiferencasVo("label_det_periodo_embarque", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getDprevtinicembrq() + " a " + tradeFinanceBean.getTradeFinanceDiferencasVO().getDprevtfimembrq(), 
					tradeFinanceBean.getTradeFinanceVO().getDprevtinicembrq() + " a " + tradeFinanceBean.getTradeFinanceVO().getDprevtfimembrq()));
		}
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_agente_financeiro", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVagtefincrcmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getVagtefincrcmbio()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_banco_mandatario", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVbcomtoricmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getVbcomtoricmbio()));
		
		return log;
	}

	// Metodo referente aos campos da tela dadosGarantiasBndesPosCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosGarantiasBndesPos(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_garantias_bndes", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getGaranbnds(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGaranbnds()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_garantias_brad", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getGaranbrad(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getGaranbrad()));
		
		return log;
	}

	// Metodo referente aos campos da tela dadosValorMoedaBndesPreCons.xhtml 
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosValorMoedaBndesPre(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("msgs.label_det_moeda_operacao", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedaoperacao(), 
				tradeFinanceBean.getTradeFinanceVO().getMoedaoperacao()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_valor_ME", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVnegocmoedaestrg(), 
				tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getMoedalimite(), 
				tradeFinanceBean.getTradeFinanceVO().getMoedalimite()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_porte", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDescrPorte(), 
				tradeFinanceBean.getTradeFinanceVO().getDescrPorte()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_moeda_limite_vlr", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getVmoedalimgerc(), 
				tradeFinanceBean.getTradeFinanceVO().getVmoedalimgerc()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_grupo", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getDescrGrupo(), 
				tradeFinanceBean.getTradeFinanceVO().getDescrGrupo()));
		
		if(tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getTxapre() == "1"){
			log.add(new TradeFinanceLogDiferencasVo("label_det_tx_juro", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPjuronegoccmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getPjuronegoccmbio()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_margem_ag", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPagtefincrcmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getPagtefincrcmbio()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_tt_juro", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPtotjurocmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getPtotjurocmbio()));
		}
		
		if(tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getTxapre() == "2"){
			log.add(new TradeFinanceLogDiferencasVo("label_det_custo_fin", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getCustfin(), 
					tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getCustfin()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_remuneracao_bndes", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxremunbndes(), 
					tradeFinanceBean.getTradeFinanceVO().getVtxremunbndes()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_margem_ag", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getPagtefincrcmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getPagtefincrcmbio()));
		}
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosPrazosBndesPreCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosPrazosBndesPre(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_pzr_operacao_mes", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiaopercmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getTdiaopercmbio()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_carencia", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiacarenprinc(), 
				tradeFinanceBean.getTradeFinanceVO().getTdiacarenprinc()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_periodicidade", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getIfluxoperdccmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getIfluxoperdccmbio()));

		log.add(new TradeFinanceLogDiferencasVo("label_qtde_parcelas", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getQpcelatradeprinc(), 
				tradeFinanceBean.getTradeFinanceVO().getQpcelatradeprinc()));
		
		return log;
	}
	
	// Metodo referente aos campos da tela dadosPgtJuroPartBndespreCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosPgtJuroPartBndespre(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_pgt_juro", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getPagajuro(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getPagajuro()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_part_bndes", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getPartbnds(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getPartbnds()));
		
		return log;
	}

	// Metodo referente aos campos da tela 
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosFinalidadeGaranExp(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_finalidade", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getFinalidade(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getFinalidade()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_bc_indicado", 
				tradeFinanceBean.getResponsavelDespListDiferencas() != null?tradeFinanceBean.getResponsavelDespListDiferencas().getCunicpssoadesc() + " - " + tradeFinanceBean.getResponsavelDespListDiferencas().getCunicpssoaimun():"", 
				tradeFinanceBean.getResponsavelDespList() != null?tradeFinanceBean.getResponsavelDespList().getCunicpssoadesc() + " - " + tradeFinanceBean.getResponsavelDespList().getCunicpssoaimun():""));
		
		return log;
		
	}

	// Metodo referente aos campos da tela dadosPrecificacaoGaranExpCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasdadosPrecificacaoGaranExp(){
		int bigger = 0;
	    int lower = 0;
	    boolean isPreviousBigger = false;
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		TradeFinanceLogDiferencasListaVo listLog = new TradeFinanceLogDiferencasListaVo();
		
		if(tradeFinanceBean.getViewHelper().isRenderPrecificacao()){
			
			if(tradeFinanceBean.getResponsavelDespListDiferencas() != null){
				for (int i = 0; i < tradeFinanceBean.getResponsavelDespListDiferencas().getListaDespesa().size(); i++) {  
					listLog.getAntes().add(tradeFinanceBean.getResponsavelDespListDiferencas().getListaDespesa().get(i).getNbanqrcmbio() + ", " +
							tradeFinanceBean.getResponsavelDespListDiferencas().getListaDespesa().get(i).getNfuncresp() + ", " +
							tradeFinanceBean.getResponsavelDespListDiferencas().getListaDespesa().get(i).getImunindcmbio() + ", " +
							tradeFinanceBean.getResponsavelDespListDiferencas().getListaDespesa().get(i).getIpais() + ", " +
							tradeFinanceBean.getResponsavelDespListDiferencas().getListaDespesa().get(i).getCidbanqrswift() + ", " +
							tradeFinanceBean.getResponsavelDespListDiferencas().getListaDespesa().get(i).getNindcdfndngutlzd());
				}
			}
			
			if(tradeFinanceBean.getResponsavelDespList() != null){
				for (int i = 0; i < tradeFinanceBean.getResponsavelDespList().getListaDespesa().size(); i++) {  
					listLog.getDepois().add(tradeFinanceBean.getResponsavelDespList().getListaDespesa().get(i).getNbanqrcmbio() + ", " +
							tradeFinanceBean.getResponsavelDespList().getListaDespesa().get(i).getNfuncresp() + ", " +
							tradeFinanceBean.getResponsavelDespList().getListaDespesa().get(i).getImunindcmbio() + ", " +
							tradeFinanceBean.getResponsavelDespList().getListaDespesa().get(i).getIpais() + ", " +
							tradeFinanceBean.getResponsavelDespList().getListaDespesa().get(i).getCidbanqrswift() + ", " +
							tradeFinanceBean.getResponsavelDespList().getListaDespesa().get(i).getNindcdfndngutlzd());
				}
			}

	    	// Verifica qual é o maior e o menor tamanho de lista (label_responsavel_desp)
	    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
	    		bigger = listLog.getAntes().size();
	    		lower = listLog.getDepois().size();
	    		isPreviousBigger = true;
	    	} else {
	    		bigger = listLog.getDepois().size();
	    		lower = listLog.getAntes().size();
	    		isPreviousBigger = false;
	    	}

	    	// Adiciona a label_responsavel_desp na lista
	    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_responsavel_desp", listLog));
			
	    	log.add(new TradeFinanceLogDiferencasVo("label_det_validade_ctc", 
					tradeFinanceBean.getResponsavelDespListDiferencas().getDlimfndngcmbio(), 
					tradeFinanceBean.getResponsavelDespList().getDlimfndngcmbio()));
	    	
	    	log.add(new TradeFinanceLogDiferencasVo("label_det_despesa_cli", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataDespesaPorConta(), 
					tradeFinanceBean.getTradeFinanceVO().getFormataDespesaPorConta()));
	    	
	    	listLog.getAntes().clear();
	    	listLog.getDepois().clear();
	    	
	    	for (int i = 0; i < tradeFinanceBean.getListaDespesasDiferencas().size(); i++) {  
	    		listLog.getAntes().add(tradeFinanceBean.getListaDespesasDiferencas().get(i).getNtpodespcmbio() + ", " +
	    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getPdespnegoccmbio() + ", " +
	    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNbasebletonegoc() + ", " +
	    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNfluxoperdccmbio() + ", " +
	    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNindcdeconmmoeda() + ", " +
	    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getVdespbletocmbio() + ", " +
	    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getNformacobrdesp() + ", " +
	    				tradeFinanceBean.getListaDespesasDiferencas().get(i).getVmindespcmbio());
	    	}
			
	    	for (int i = 0; i < tradeFinanceBean.getListaDespesas().size(); i++) {  
	    		listLog.getDepois().add(tradeFinanceBean.getListaDespesas().get(i).getNtpodespcmbio() + ", " +
	    				tradeFinanceBean.getListaDespesas().get(i).getPdespnegoccmbio() + ", " +
	    				tradeFinanceBean.getListaDespesas().get(i).getNbasebletonegoc() + ", " +
	    				tradeFinanceBean.getListaDespesas().get(i).getNfluxoperdccmbio() + ", " +
	    				tradeFinanceBean.getListaDespesas().get(i).getNindcdeconmmoeda() + ", " +
	    				tradeFinanceBean.getListaDespesas().get(i).getVdespbletocmbio() + ", " +
	    				tradeFinanceBean.getListaDespesas().get(i).getNformacobrdesp() + ", " +
	    				tradeFinanceBean.getListaDespesas().get(i).getVmindespcmbio());
	    	}

	    	// Verifica qual é o maior e o menor tamanho de lista (label_cust_Banc)
	    	if (listLog.getAntes().size() > listLog.getDepois().size()) {
	    		bigger = listLog.getAntes().size();
	    		lower = listLog.getDepois().size();
	    		isPreviousBigger = true;
	    	} else {
	    		bigger = listLog.getDepois().size();
	    		lower = listLog.getAntes().size();
	    		isPreviousBigger = false;
	    	}

	    	// Adiciona a label_cust_Banc na lista
	    	log.addAll(formatarListaLog(bigger, lower, isPreviousBigger, true, "label_cust_Banc", listLog));
		}
		
		return log;
	}

	// Metodo referente aos campos da tela dadosContatoGaranExpCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosContatoGaranExp(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_nome_ctt", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getRetirnome(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getRetirnome()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_end_ctt", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getRetirender(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getRetirender()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_cidade", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getRetircidade(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getRetircidade()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_telefone", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getRetirtele(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getRetirtele()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_email", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getRetiremail(), 
				tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getRetiremail()));
		
		return log;
		
	}

	// Metodo referente aos campos da tela dadosContraGaranExpCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasDadosContraGaranExp(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_contra_garan", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataContraGarantia(), 
				tradeFinanceBean.getTradeFinanceVO().getFormataContraGarantia()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_dias", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getTdiacntragarnt(), 
				tradeFinanceBean.getTradeFinanceVO().getTdiacntragarnt()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_data", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getFormatadDataVencProsposta(), 
				tradeFinanceBean.getTradeFinanceVO().getFormatadDataVencProsposta()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_abr_ofertas", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataDataAbrtOferta(), 
				tradeFinanceBean.getTradeFinanceVO().getFormataDataAbrtOferta()));
		
		log.add(new TradeFinanceLogDiferencasVo("label_det_renv_auto", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataRenovAutomatica(), 
				tradeFinanceBean.getTradeFinanceVO().getFormataRenovAutomatica()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_dias", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getQdiaalertcntra(), 
				tradeFinanceBean.getTradeFinanceVO().getQdiaalertcntra()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_data", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataDataAlertGarantias(), 
				tradeFinanceBean.getTradeFinanceVO().getFormataDataAlertGarantias()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_cotar_custo_ext", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getFormataCustoExterno(), 
				tradeFinanceBean.getTradeFinanceVO().getFormataCustoExterno()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_ordenante", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getNcunicclicmbio(), 
				tradeFinanceBean.getTradeFinanceVO().getNcunicclicmbio()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_endereco", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getEndereco(), 
				tradeFinanceBean.getTradeFinanceVO().getEndereco()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_cidade", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getCidade(), 
				tradeFinanceBean.getTradeFinanceVO().getCidade()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_pais", 
				tradeFinanceBean.getTradeFinanceDiferencasVO().getPais(), 
				tradeFinanceBean.getTradeFinanceVO().getPais()));

		log.add(new TradeFinanceLogDiferencasVo("label_det_beneficiario", 
				tradeFinanceBean.getBeneficiarioDiferencas() != null?tradeFinanceBean.getBeneficiarioDiferencas().getCunicpssoadcmbio():"", 
				tradeFinanceBean.getBeneficiario() != null?tradeFinanceBean.getBeneficiario().getCunicpssoadcmbio():""));

		log.add(new TradeFinanceLogDiferencasVo("label_det_endereco", 
				tradeFinanceBean.getBeneficiarioDiferencas() != null?tradeFinanceBean.getBeneficiarioDiferencas().getLogrdcmbio():"", 
				tradeFinanceBean.getBeneficiario() != null?tradeFinanceBean.getBeneficiario().getLogrdcmbio():""));

		log.add(new TradeFinanceLogDiferencasVo("label_det_cidade", 
				tradeFinanceBean.getBeneficiarioDiferencas() != null?tradeFinanceBean.getBeneficiarioDiferencas().getIciddcmbio():"", 
				tradeFinanceBean.getBeneficiario() != null?tradeFinanceBean.getBeneficiario().getIciddcmbio():""));

		log.add(new TradeFinanceLogDiferencasVo("label_det_pais", 
				tradeFinanceBean.getBeneficiarioDiferencas() != null?tradeFinanceBean.getBeneficiarioDiferencas().getIpaiscmbio():"", 
				tradeFinanceBean.getBeneficiario() != null?tradeFinanceBean.getBeneficiario().getIpaiscmbio():""));

		log.add(new TradeFinanceLogDiferencasVo("label_det_afiancado", 
				tradeFinanceBean.getAfiancadoDiferencas() != null?tradeFinanceBean.getAfiancadoDiferencas().getCunicpssoadcmbio():"", 
				tradeFinanceBean.getAfiancado() != null?tradeFinanceBean.getAfiancado().getCunicpssoadcmbio():""));

		log.add(new TradeFinanceLogDiferencasVo("label_det_endereco", 
				tradeFinanceBean.getAfiancadoDiferencas() != null?tradeFinanceBean.getAfiancadoDiferencas().getLogrdcmbio():"", 
				tradeFinanceBean.getAfiancado() != null?tradeFinanceBean.getAfiancado().getLogrdcmbio():""));

		log.add(new TradeFinanceLogDiferencasVo("label_det_cidade", 
				tradeFinanceBean.getAfiancadoDiferencas() != null?tradeFinanceBean.getAfiancadoDiferencas().getIciddcmbio():"", 
				tradeFinanceBean.getAfiancado() != null?tradeFinanceBean.getAfiancado().getIciddcmbio():""));

		log.add(new TradeFinanceLogDiferencasVo("label_det_pais", 
				tradeFinanceBean.getAfiancadoDiferencas() != null?tradeFinanceBean.getAfiancadoDiferencas().getIpaiscmbio():"", 
				tradeFinanceBean.getAfiancado() != null?tradeFinanceBean.getAfiancado().getIpaiscmbio():""));

		return log;
	}

	// Metodo referente aos campos da tela dadosPrecificacaoNceCons.xhtml
	private List<TradeFinanceLogDiferencasVo> carregarDiferencasdadosPrecificacaoNce(){
		List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();
		
		if(tradeFinanceBean.getViewHelper().isRenderPrecificacao()){
			log.add(new TradeFinanceLogDiferencasVo("label_det_indc_econ", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getConcatenaTxaIndicador(), 
					tradeFinanceBean.getTradeFinanceVO().getConcatenaTxaIndicador()));

			log.add(new TradeFinanceLogDiferencasVo("label_spread", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxspreadnegoc(), 
					tradeFinanceBean.getTradeFinanceVO().getVtxspreadnegoc()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_IR", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVimpstnegoccmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getVimpstnegoccmbio()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_IOF", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getViofnegoccmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getViofnegoccmbio()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_juros_mora", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVtxmoracmbio() + " " + tradeFinanceBean.getTradeFinanceDiferencasVO().getCodJurosMora(), 
					tradeFinanceBean.getTradeFinanceVO().getVtxmoracmbio() + " " + tradeFinanceBean.getTradeFinanceVO().getCodJurosMora()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_multa", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getVmultanegoccmbio(), 
					tradeFinanceBean.getTradeFinanceVO().getVmultanegoccmbio()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_lastro_lca", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getLastroLca(), 
					tradeFinanceBean.getTradeFinanceVO().getLastroLca()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_nome", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDadosnome(), 
					tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDadosnome()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_cpf_cnpj", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDadoscpfcnpj(), 
					tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDadoscpfcnpj()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_endereco", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDadosender(), 
					tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDadosender()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_ctr_ident", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDadosident(), 
					tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDadosident()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_org_exped", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDadosorgao(), 
					tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDadosorgao()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_est_civil", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDadosestci(), 
					tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDadosestci()));

			log.add(new TradeFinanceLogDiferencasVo("label_det_reg_civil", 
					tradeFinanceBean.getTradeFinanceDiferencasVO().getObsCotacaoVO().getDadosregci(), 
					tradeFinanceBean.getTradeFinanceVO().getObsCotacaoVO().getDadosregci()));
		}
	
		return log;
	}
	
    /**Formata uma lista TradeFinanceLogDiferencasListaVo dentro de uma lista de TradeFinanceLogDiferencasVo:
     * @param bigger = tamanho da maior lista
     * @param lower = tamanho da menor lista 
     * @param isPreviousBigger = a lista ANTES é maior?
     * @param sortList = ordenar listas?
     * @param title = titulo que será demonstrado no GRID
     * @param lists = lista de ANTES/DEPOIS
     * @return
     */
    private List<TradeFinanceLogDiferencasVo> formatarListaLog(int bigger, int lower, boolean isPreviousBigger, boolean sortList,
            String title, TradeFinanceLogDiferencasListaVo lists) {
            List<TradeFinanceLogDiferencasVo> log = new ArrayList<TradeFinanceLogDiferencasVo>();

            // Verifica se uma das listas possui conteudo
            if (bigger + lower > 0) {
                // Realiza ordenação das listas
                if (sortList) {
                    Collections.sort(lists.getAntes());
                    Collections.sort(lists.getDepois());
                }

                int index = 0; // Inicia com 0 para obter a primeira o ocorrencia da lista
                List<Integer> changes = lists.getItensAlterados();

                // Verifica se as duas listas possuem valores para adicionar a primeira linha
                if (lists.getAntes().size() > 0 && lists.getDepois().size() > 0) {

                    log.add(new TradeFinanceLogDiferencasVo(title, lists.getAntes().get(index), lists.getDepois().get(index), changes
                                    .contains(index)));
                } else if (lists.getAntes().size() > 0) {

                    log.add(new TradeFinanceLogDiferencasVo(title, lists.getAntes().get(index), null, changes.contains(index)));
                } else {

                    log.add(new TradeFinanceLogDiferencasVo(title, null, lists.getDepois().get(index), changes.contains(index)));
                }

                // Percorre as listas a partir da menor índice para apos percorrer os itens restanes da maior
                for (index = 1; index < lower; index++) {
                    log.add(new TradeFinanceLogDiferencasVo(lists.getAntes().get(index), lists.getDepois().get(index), changes
                                    .contains(index)));
                }

                // Percorre o que sobrou da lista maior
                for (; index < bigger; index++) {
                	TradeFinanceLogDiferencasVo logItem = new TradeFinanceLogDiferencasVo();

                    // Verifica a lista com as ocorrencias restantes precisa ir para o "Antes" ou "Depois"
                    if (isPreviousBigger) {
                        logItem.setAntes(lists.getAntes().get(index));
                    } else {
                        logItem.setDepois(lists.getDepois().get(index));
                    }

                    logItem.setHouveAlteracao(changes.contains(index));

                    log.add(logItem);
                }
            }else {
            	log.add(new TradeFinanceLogDiferencasVo(title, null, null));
            }

            return log;
    }

    /**
     * Nome: actionFecharModal
     * 
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 19/04/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public void actionFecharModal(ActionEvent ae) {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.actionFecharModal <<<<<<<<<<<");

            actionFecharModal();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.actionFecharModal <<<<<<<<<<<");
        }

    }

    /**
     * Nome: actionFecharModal
     * 
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 19/04/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public void actionFecharModal() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.actionFecharModal <<<<<<<<<<<");

            getViewHelper().setRenderModal(false);

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.actionFecharModal <<<<<<<<<<<");
        }

    }

    /**
     * Nome: actionVoltar
     * 
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 19/04/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public String actionVoltar() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.actionVoltar <<<<<<<<<<<");

            return "tradeFinLog";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.actionVoltar <<<<<<<<<<<");
        }

    }

    /**
     * Nome: actionVoltarLog
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionVoltarLog() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.actionVoltarLog <<<<<<<<<<<");

            return "tradeFinLogDet";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.actionVoltarLog <<<<<<<<<<<");
        }

    }
    
    /**
     * Nome: actionVoltarLogDiferencas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionVoltarLogDiferencas() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.actionVoltarLogDiferencas <<<<<<<<<<<");

            return viewHelper.getTelaLogChamada();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.actionVoltarLogDiferencas <<<<<<<<<<<");
        }

    }
    

    /**
     * Nome: getSelectItemRadioCtcPend
     * 
     * Propósito: Tela de Filtro
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 19/04/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public List<SelectItem> getSelectItemRadioCtcPend() {
        List<SelectItem> selectItemCheckboxLista = new ArrayList<SelectItem>();
        SiteUtil.atualizarSelectItem(lista, selectItemCheckboxLista);
        return selectItemCheckboxLista;
    }

    /**
     * Nome: getSelectItemRadioPend
     * 
     * PropÃ³sito: Radio da segunda tela
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 19/04/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public List<SelectItem> getSelectItemRadioPend() {
        List<SelectItem> selectItemCheckboxLista = new ArrayList<SelectItem>();
        SiteUtil.atualizarSelectItem(listaLogAcoes, selectItemCheckboxLista);
        return selectItemCheckboxLista;
    }

    private void limparDadosDetalhe() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceLogBean.limparDadosDetalhe <<<<<<<<<<<");

            setListaLogAcoes(new ArrayList<TradeFinanceListaVO>());
            setItemLogAcoesVO(new TradeFinanceListaVO());
            setItemSelecionadoLogAcoes(null);

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceLogBean.limparDadosDetalhe <<<<<<<<<<<");
        }
    }

    /**
     * @return o valor do libor
     */
    public boolean isLibor() {
        return libor;
    }

    /**
     * @param libor seta o novo valor para o campo libor
     */
    public void setLibor(boolean libor) {
        this.libor = libor;
    }

    /**
     * @return o valor do fluxo
     */
    public boolean isFluxo() {
        return fluxo;
    }

    /**
     * @param fluxo seta o novo valor para o campo fluxo
     */
    public void setFluxo(boolean fluxo) {
        this.fluxo = fluxo;
    }

    /**
     * @return o valor do meMn
     */
    public boolean isMeMn() {
        return meMn;
    }

    /**
     * @param meMn seta o novo valor para o campo meMn
     */
    public void setMeMn(boolean meMn) {
        this.meMn = meMn;
    }

    public List<TradeFinanceListaVO> getListaLogAcoes() {
        return listaLogAcoes;
    }

    public void setListaLogAcoes(List<TradeFinanceListaVO> listaLogAcoes) {
        this.listaLogAcoes = listaLogAcoes;
    }

    public TradeFinanceListaVO getItemLogAcoesVO() {
        return itemLogAcoesVO;
    }

    public void setItemLogAcoesVO(TradeFinanceListaVO itemLogAcoesVO) {
        this.itemLogAcoesVO = itemLogAcoesVO;
    }

    public String getItemSelecionadoLogAcoes() {
        return itemSelecionadoLogAcoes;
    }

    public void setItemSelecionadoLogAcoes(String itemSelecionadoLogAcoes) {
        this.itemSelecionadoLogAcoes = itemSelecionadoLogAcoes;
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

    public void continuarConfirmar() {

    }

    /**
     * @return o valor do tradeFinanceLogService
     */
    public ITradeFinanceLogService getTradeFinanceLogService() {
        return tradeFinanceLogService;
    }

    /**
     * @param tradeFinanceLogService seta o novo valor para o campo tradeFinanceLogService
     */
    public void setTradeFinanceLogService(ITradeFinanceLogService tradeFinanceLogService) {
        this.tradeFinanceLogService = tradeFinanceLogService;
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
    
    public List<TradeFinanceLogDiferencasVo> getListaLogAntesDepois() {
		return listaLogAntesDepois;
	}

	public void setListaLogAntesDepois(
			List<TradeFinanceLogDiferencasVo> listaLogAntesDepois) {
		this.listaLogAntesDepois = listaLogAntesDepois;
	}
}