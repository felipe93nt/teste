package br.com.bradesco.web.npcc_trade.view.bean.operacionalizacao.formalizacao.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.TrataErroUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumMotivoDevolver;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPendencia;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitBaseBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * 
 * Nome: TradeFinMonitBean.java
 * 
 * Propósito:
 * <p>
 * Bean para funcionalidade da tela Monitor - Trade Finance
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */

@Named("tradeFinMonitFormalizacaoBean")
@SessionScoped
public class TradeFinMonitFormalizacaoBean extends TradeFinMonitBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor
     * 
     * @param
     */
    public TradeFinMonitFormalizacaoBean() {
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
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao pa/drão hexavision.
     */
    public String iniciar() {
        
        // Recarrega página se não for um postback ou se foi marcado para recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);
    
            filtroVO = new TradeFinanceFiltroVO();
            
            listenerLimparPesquisa(null);
            limparCpfCnpjCliente(null);
            tradeFinMonitBean.getViewHelper().setTradeFinanceMonitor(Numeros.ZERO);
    
            devolverModalBean.getViewHelper().setRenderModal(false);
            getViewHelper().setCtcSelecionado(null);
    
            getViewHelper().setTradefinanceMonitFormalizacao(Numeros.DOIS);
            
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
            
            lista = new ArrayList<TradeFinanceListaVO>();
            produto = selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                                            EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                                            EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo());
            
            getViewHelper().setComboOperador(selectItemBean.getOperador());
            getViewHelper().setComboUnidadeNegocio(selectItemBean.getComboUnidadeNegocio());
            
            getViewHelper().setRenderModal(false);
            tradeFinanceBean.getViewHelper().setDisabledBotaoDetGar(true);
            
        }
            
        return "tradeFinCotacoesFechadas";

    }
    
    /**
     * Nome: listenerLimparPesquisa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerLimparPesquisa(AjaxBehaviorEvent e) {
        super.listenerLimparPesquisa(null);
        
        getFiltroVO().getPeriodoFech().setInicio(new Date());
        getFiltroVO().getPeriodoFech().setFim(new Date());
    }

    /**
     * 
     * Nome: analisar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String analisar() {

        if(SiteUtil.isEmptyOrNull(viewHelper.getCtcSelecionado())) {
            NpcFacesUtils.addInfoModalMessage("Selecione um registro.", false);
            return null;
        }
        
        getViewHelper().setRenderModal(false);
        tradeFinanceListaVO = lista.get(SiteUtil.getInt(viewHelper.getCtcSelecionado()));
        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_CONSULTAR_FECHADAS);

        // FINIMP DIRETO (1644)
        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {

            return "finimpDiretoAnalisar";
        }

        // REFINIMP DIRETO (1646)
        if (tradeFinanceListaVO.getProduto()
                        .equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {

            return "refinimpDiretoAnalisar";
        }

        // FINIMP INDIRETO (2692)
        if (tradeFinanceListaVO.getProduto()
                        .equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {

            return "finimpIndiretoAnalisar";
        }

        // REFINIMP INDIRETO (1717)
        if (tradeFinanceListaVO.getProduto()
                        .equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {

            return "refinimpIndiretoAnalisar";
        }

        // LEI 4131 (2010)
        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {

            return "lei4131Analisar";
        }

        // PPE (1642)
        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {

            return "cotacaoPPEAnalisar";
        }

        // WORKING CAPITAL (2011)
        if (tradeFinanceListaVO.getProduto()
                        .equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {

            return "workingCapitalAnalisar";
        }

        // FORFAITING (644)
        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {

            return "forfaitingAnalisar";
        }
        
        //ECA (1715)
        if(tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
            return "finimpEcaAnalisar";
        }
        
        
        //LC IMPORTACAO(2018)
        if(tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
            
            return "lcImportacaoAnalisar";
        }
        
        //PROEX (642)
        if(tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
            return "proexAnalisar";
      
        }
          
        //NCE(1713, 622, 624, 638,639,640)
        if(tradeFinanceListaVO.getProduto().isNce()) {
            return "nceAnalisar";
        }
        
        //BNDES PRE(663, 664, 665, 666, 667, 670, 3934)
        if(tradeFinanceListaVO.getProduto().isBndesPre()) {
            return "bndesPreAnalisar";
        }
        
        // BNDS POS(661, 662)
        if(tradeFinanceListaVO.getProduto().isBndesPos()) {
            return "bndesPosAnalisar";
        }
        
        // GARANTIA(17,69,3933)
        if(tradeFinanceListaVO.getProduto().isGarantia()) {
            return "garantiaIntExpAnalisar";
        }
      
        return null;

    }

    /**
     * 
     * Nome: actionConfirmar
     * 
     * Propósito: Modal de confirmação tela Fechar
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionConfirmar() {

        String result = SiteUtil.STRING_EMPTY;
        getViewHelper().setRenderFechar(false);

        tradeFinanceBean.getTradeFinanceVO().setCsitbletocmbio(Numeros.DEZESSEIS);
        result = tradeFinanceMonitService.confirmarFormalizacao(tradeFinanceBean.getTradeFinanceVO(), Numeros.DEZESSEIS);
        
        setIniciarPagina(false);

        BradescoFacesUtils.addInfoModalMessage(result, "#{tradeFinMonitFormalizacaoBean.retomarPesquisa}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
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

    /**
     * 
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
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void validarForm(ActionEvent ae) {
        
        // valida campos obrigatórios
        if (!SiteUtil.validarCampos("formTradeFinMonitDet")) {
            
            viewHelper.setRenderFechar(Boolean.TRUE);
        }

    }

    /**
     * 
     * Nome: actionVoltarFinFechar
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
    public String actionVoltarFinFechar() {
        return "tradeFinCotacoesFechadas";
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
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginarCotacao(ActionEvent event) {
        setLista(tradeFinanceMonitService.obterCotacoesFechadas(filtroVO));
    }

    /**
     * Nome: actionDevolver
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/05/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionDevolver() {
        devolverModalBean.getDevolucaoVO().setNbletonegoccmbio(
                        tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());
        devolverModalBean.getDevolucaoVO().setCmotvobletocmbio(
                        tradeFinanceBean.getTradeFinanceVO().getCmotvobletocmbio());
        devolverModalBean.getDevolucaoVO().setRobsbletocmbio("");

        devolverModalBean.getDevolucaoVO().setNseqcontrlim(
				tradeFinanceBean.getTradeFinanceVO().getNseqcontrlim());
		devolverModalBean.getDevolucaoVO().setNppstapontucmbio(
				tradeFinanceBean.getTradeFinanceVO().getNppstapontucmbio());
		devolverModalBean.getDevolucaoVO().setCsitbletoaprov(
				tradeFinanceBean.getTradeFinanceVO().getCsitbletoaprov());
        
        // devolver formalizacao
        devolverModalBean.getDevolucaoVO().setCsitbletocmbio(EnumPendencia.PENDENCIA_FECHADAS_ANALISAR.getCodigo());
        devolverModalBean.getDevolucaoVO().setCtpoobsbleto(EnumMotivoDevolver.FORMALIZACAO_ANALISAR.getCodigo());
        devolverModalBean.getDevolucaoVO().setRobsbletocmbio("");
        devolverModalBean.getViewHelper().setIsConfirmar(false);
        devolverModalBean.getViewHelper().setAcaoVoltar("#{tradeFinMonitFormalizacaoBean.iniciar}");
        devolverModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalDevolver");

        devolverModalBean.openModal();
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
    	* Registro  de Manutenção: 01/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public void closeModalDevolver(){
        
        Boolean isConfirmar = devolverModalBean.getViewHelper().getIsConfirmar();
        String message = devolverModalBean.getViewHelper().getMessagemConfirmar();
        devolverModalBean.closeModal();
        
        setIniciarPagina(false);
        
        if(isConfirmar) {
            BradescoFacesUtils.addInfoModalMessage(message, "#{tradeFinMonitFormalizacaoBean.retomarPesquisa}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);
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
     *      Registro de Manutenção: 28/07/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String pesquisar(AjaxBehaviorEvent event) {

        if(validarCamposData() == false) {
            return null;
        }
        
        lista.clear();
        getViewHelper().setCtcSelecionado(null);
        
        getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
        
        lista = tradeFinanceMonitService.obterCotacoesFechadas(filtroVO);

        return "tradeFinCotacoesFechadas";
    }
    
    public String retomarPesquisa(){
        try { 
            setIniciarPagina(false);
            pesquisar(null);
        } catch (NpccTradeWebException e) {
            TrataErroUtil.getInstance().tratarRetornoPesquisaVaziaMainframe(e);
            lista = new ArrayList<TradeFinanceListaVO>();
        }
        return "tradeFinCotacoesFechadas";
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
     * Registro  de Manutenção: 08/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String exportar() {    
        getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
        
        BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista", 
                        tradeFinanceMonitService.obterCotacoesFechadasExportacao(getFiltroVO()));        

        return "tradeFinCotacoesFechadasExportTemplate";
    }

    /**
     * 
     * Nome: getSelectItemRadioCtc
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioCtc() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getLista().size(); index++) {
            list.add(new SelectItem(index, ""));
        }
        return list;
    }
    
    public void continuarConfirmar() {
        
    }

}
