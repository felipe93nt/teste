package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.agendaSwap;

import java.io.Serializable;
import java.util.ArrayList;
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
import br.com.bradesco.web.aq.view.components.UICnpj.UICnpj;
import br.com.bradesco.web.aq.view.components.UICpf.UICpf;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.agendaSwap.IAgendaSwapService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.agendaSwap.bean.BaixaSwapFiltroVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitBaseBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named("agendaSwapBean")
@SessionScoped
public class AgendaSwapBean extends TradeFinMonitBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -8173217983470102090L;
    
    @Inject
    @Named("agendaSwapService")
    protected IAgendaSwapService agendaSwapService;
    
    @Override
    public void continuarConfirmar() {
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
     *      Registro de Manutenção: 13/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    @Override
    public String iniciar() {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.iniciar <<<<<<<<<<<");
            
            // Recarrega página se não for um postback ou se foi marcado para
            // recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);

                listenerLimparPesquisa(null);
                limparCpfCnpjCliente(null);
                
                setProduto(getSelectItemBean().getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                                EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(), EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));

                getViewHelper().setComboSegmento(getSelectItemBean().getComboSegmento());
                getViewHelper().setComboUnidadeNegocio(getSelectItemBean().getComboUnidadeNegocio());
                getViewHelper().setComboStatusSwap(getSelectItemBean().getComboStatusSwap());
                getViewHelper().setCnpjBinding(new UICnpj());
                getViewHelper().setCpfBinding(new UICpf());
                getViewHelper().setDisabledDetalhar(true);
                getViewHelper().setDisabledBaixar(true);
                getViewHelper().setTradeFinanceAgendaSWAP(Numeros.QUATRO);
            }

            return "agendaSwapList";

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.iniciar <<<<<<<<<<<");
        }
    }
    
    /**
     * 
     * Nome: pesquisar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisar(AjaxBehaviorEvent event) {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.pesquisar <<<<<<<<<<<");
            
            if (filtroVO.getPeriodoSwap() == null || filtroVO.getPeriodoSwap().isIndeterminado()) {
                BradescoFacesUtils.addInfoModalMessage("É obrigatório informar o Período de Vencimento SWAP.", false);
                return;
            }
            
            getViewHelper().setCtcSelecionado(null);
            getViewHelper().setDisabledDetalhar(true);
            getViewHelper().setDisabledBaixar(true);
            lista.clear();
    
            getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
            
            setLista(agendaSwapService.getListaAgendaSwap(filtroVO));
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.pesquisar <<<<<<<<<<<");
        }
    }

    /**
     * 
     * Nome: paginar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginar(ActionEvent event) {
        
        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.paginar  <<<<<<<<<<<");
            
            setLista(agendaSwapService.getListaAgendaSwap(filtroVO));

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.paginar  <<<<<<<<<<<");
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
     *      Registro de Manutenção: 14/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String detalhar() {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.detalhar <<<<<<<<<<<");
            
            if (tradeFinanceListaVO.getNbletonegoccmbio() == null
                            || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
                NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
                return "";
            }
            
            // [ACESSO EXTERNO] Garante que não ira adotar o comportamento de acesso externo
            getTradeFinanceBean().setExternalAccess(false);
            
            tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_CONSULTAR);
    
            tradeFinanceBean.getViewHelper().setPaginaOrigem("agendaSwapList");

            getViewHelper().setCtcSelecionado(null);
            getViewHelper().setDisabledDetalhar(true);
            getViewHelper().setDisabledBaixar(true);

            // FINIMP DIRETO (1644)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
    
                return "finimpDiretoCons";
            }
    
            // REFINIMP DIRETO (1646)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
    
                return "refinimpDiretoCons";
            }
    
            // FINIMP INDIRETO (2692)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
    
                return "finimpIndiretoCons";
            }
    
            // REFINIMP INDIRETO (1717)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
    
                return "refinimpIndiretoCons";
            }
    
            // LEI 4131 (2010)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
    
                return "lei4131Cons";
            }
    
            // PPE (1642)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
    
                return "cotacaoPPECons";
            }
    
            // WORKING CAPITAL (2011)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
    
                return "workingCapitalCons";
            }
    
            // FORFAITING 644
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
//                carregarQuadroJurosForfaiting();
    
                return "forfaitingCons";
            }
    
            // BNDES PRE
            if (tradeFinanceListaVO.getProduto().isBndesPre()) {
    
                return "bndesPreCons";
            }
    
            // BNDES POS
            if (tradeFinanceListaVO.getProduto().isBndesPos()) {
    
                return "bndesPosCons";
            }
    
            // BNDES PRE
            if (tradeFinanceListaVO.getProduto().isNce()) {
    
                // TODO RENDER TEMPORARIO
                tradeFinanceBean.getViewHelper().setRenderLastroLca(Boolean.TRUE);
                return "nceCons";
            }
    
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
                return "finimpEcaCons";
            }
    
            // PROEX 642
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
                return "proexCons";
            }
    
            // GARANTIA INTERNACIONAL EXPEDIDAS
            if (tradeFinanceListaVO.getProduto().isGarantia()) {
                return "garantiaIntExpCons";
            }
    
            // LC IMPORTAÇÃO 2018
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                return "lcImportacaoCons";
            }
    
            return null;
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.detalhar <<<<<<<<<<<");
        }
    }
    
    /**
     * 
     * Nome: validarForm
     * 
     * Propósito: Ação que executa a validação do formulário e abre o modal de confirmação
     * 
     * @return : Navegação por mensagem
     * 
     * @throws : NpccServiceBusinessException
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manutenção: 14/09/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void validarForm(ActionEvent ae) {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.validarForm <<<<<<<<<<<");
            
            // valida campos obrigatórios
            if (!SiteUtil.validarCampos("formTradeFinMonitDet")) {              
                viewHelper.setRenderModal(Boolean.TRUE);
            }            

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.validarForm <<<<<<<<<<<");
        }

    }    
    
    /**
     * 
     * Nome: actionConfirmar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionConfirmar() {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.actionConfirmar <<<<<<<<<<<");

            viewHelper.setRenderModal(Boolean.FALSE);

            if (SiteUtil.isEmptyOrNull(getViewHelper().getCtcSelecionado())){
                NpcFacesUtils.addInfoModalMessage("Selecione um item.", false);
                return;
            }
            
            BaixaSwapFiltroVO filtro = new BaixaSwapFiltroVO();            
            
            filtro.setNbletonegoccmbio(getTradeFinanceListaVO().getNbletonegoccmbio());
            
            if (!SiteUtil.isEmptyOrNull(getTradeFinanceListaVO().getVpcelaprnctrade()) 
                            && !SiteUtil.isValueZero(getTradeFinanceListaVO().getVpcelaprnctrade())) {
                filtro.setNdsembcmbiotrade(getTradeFinanceListaVO().getNdsembcmbiop());
                filtro.setNpceladsembtrade(getTradeFinanceListaVO().getNpceladsembp());
                filtro.setTpparcela("P");
            }
            if (!SiteUtil.isEmptyOrNull(getTradeFinanceListaVO().getVpcelajurotrade()) 
                            && !SiteUtil.isValueZero(getTradeFinanceListaVO().getVpcelajurotrade())) {
                filtro.setNdsembcmbiotrade(getTradeFinanceListaVO().getNdsembcmbioj());
                filtro.setNpceladsembtrade(getTradeFinanceListaVO().getNpceladsembj());
                filtro.setTpparcela("J");
            }
            
            
            String result = agendaSwapService.baixar(filtro);
            
            BradescoFacesUtils.addInfoModalMessage(result, "#{agendaSwapBean.iniciar}",
                            BradescoViewExceptionActionType.ACTION, "submit", false);
                        
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.actionConfirmar <<<<<<<<<<<");
        }
    }
    
    /**
     * 
     * Nome: actionFechar
     * 
     * Propósito: Ação do botão fechar do modal de confirmação
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manutenção: 26/09/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionFechar(ActionEvent ae) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.actionFechar <<<<<<<<<<<");
            
            viewHelper.setRenderModal(Boolean.FALSE);

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.actionFechar <<<<<<<<<<<");
        }
        
    }

    /**
     * 
     * Nome: getSelectItemRadioCtc
     * 
     * Propósito: Preencher lista auxiliar para seleção
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 15/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioCtc() {

        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.getSelectItemRadioCtc  <<<<<<<<<<<");
            
            List<SelectItem> list = new ArrayList<SelectItem>();
            for (int index = 0; index < getLista().size(); index++) {
                list.add(new SelectItem(index, ""));
            }
            
            return list;
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.getSelectItemRadioCtc  <<<<<<<<<<<");
        }
    }
    
    /**
     * 
     * Nome: habilitaBotoes
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void habilitaBotoes(AjaxBehaviorEvent ajaxBehaviorEvent) {
        
        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] AgendaSwapBean.habilitaBotoes  <<<<<<<<<<<");
    
            setTradeFinanceListaVO(getLista().get(SiteUtil.getInt(getViewHelper().getCtcSelecionado())));
            
            getViewHelper().setDisabledDetalhar(false);
            
            if (getTradeFinanceListaVO().getCindcdliqdcswap().equals("1") ) {
                getViewHelper().setDisabledBaixar(false); 
            } else {
                getViewHelper().setDisabledBaixar(true); 
            }
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] AgendaSwapBean.habilitaBotoes  <<<<<<<<<<<");
        }           

    }
        
}
