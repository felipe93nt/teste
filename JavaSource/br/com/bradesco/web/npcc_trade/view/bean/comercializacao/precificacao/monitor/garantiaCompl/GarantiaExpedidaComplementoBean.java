package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.garantiaCompl;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.view.components.UICnpj.UICnpj;
import br.com.bradesco.web.aq.view.components.UICpf.UICpf;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.BeneficiarioVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.TrataErroUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNao;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.ConstantesTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.TradeFinMonitBaseBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * 
 * Nome: GarantiaExpedidaComplementoBean.java
 * 
 * Propósito:
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */

@Named("garantiaExpedidaComplementoBean")
@SessionScoped
public class GarantiaExpedidaComplementoBean extends TradeFinMonitBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 4807885081576357960L;

    private boolean botoesGarantiaIncl = false;
    private boolean botoesGarantiaAlt = false;
    /** CHECKBOX GARANTIAS **/
    private boolean indeterminado = false;

    private TrdFinNegocInclVO tradeFinNegocVO = new TrdFinNegocInclVO();

    private BeneficiarioVO beneficiario = new BeneficiarioVO();
    private BeneficiarioVO afiancado = new BeneficiarioVO();

    /** BENEFICIARIO / AFIANCADO **/
    private TrdFinNegMercadoriaVO beneficiarioModal = new TrdFinNegMercadoriaVO();
    private TradeFinNegocListasVO afiancadoModal = new TradeFinNegocListasVO();

    /**
     * Construtor
     * 
     * @param
     */
    public GarantiaExpedidaComplementoBean() {
        super();
    }

    /**
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
     *      Registro de Manutenção: 07/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciar() {

        try {

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.iniciar <<<<<<<<<<<");

            // Recarrega página se não for um postback ou se foi marcado para recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);

                listenerLimparPesquisa(null);
                limparCpfCnpjCliente(null);
               
                getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);

                // carregar combos da tela garantia
                getViewHelper().setComboSegmento(getSelectItemBean().getComboSegmento());
                getViewHelper().setComboUnidadeNegocio(getSelectItemBean().getComboUnidadeNegocio());

                getViewHelper().setCnpjBinding(new UICnpj());
                getViewHelper().setCpfBinding(new UICpf());
                
                getViewHelper().setDisabledDiasContraGarantia(Boolean.TRUE);
                getViewHelper().setDisabledDataContraGarantia(Boolean.TRUE);

            }

            return "garantiaExpCompl";

        } finally {
             BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.iniciar <<<<<<<<<<<");
        }
    }

    /**
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
     *      Registro de Manutenção: 07/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisar(AjaxBehaviorEvent event) {

        try {

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.pesquisar  <<<<<<<<<<<");

            if (validarCamposData()) {
                lista.clear();
                setTradeFinanceListaVO(null);

                getViewHelper().setCtcSelecionado(null);

                getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());

                // FLUXO: NPCCIASP BOOK: NPCCWYJE/S
                lista = tradeFinanceMonitService.obterCotacoesPendente(getFiltroVO());

            }
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.pesquisar  <<<<<<<<<<<");
        }
    }
    
    public String retomarPesquisa() {
        
        try{
            setIniciarPagina(false);
            pesquisar(null);
        } catch (NpccTradeWebException e) {
            TrataErroUtil.getInstance().tratarRetornoPesquisaVaziaMainframe(e);
            listenerLimparPesquisa(null);
            limparCpfCnpjCliente(null);
            filtroVO = new TradeFinanceFiltroVO();
            clienteSelecaoVO = new ClienteSelecaoVO();
        }

        return "/content/comercializacao/precificacao/monitor/garantiaExpCompl.xhtml";
    }

    /**
     * Nome: actionVoltar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionVoltar() {
        return "garantiaExpCompl";
    }

    /**
     * Nome: complementoInclusao
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
     * Registro  de Manutenção: 21/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String complementoInclusao() throws ParseException {
        
        try {

            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.complementoInclusao  <<<<<<<<<<<");


            if (getViewHelper().getCtcSelecionado() == null
                            || getViewHelper().getCtcSelecionado() == "") {
                NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
                return "";

            }else{
                actionConfirmar();
                limparDadosInclusao();
                valoresDefaultInclusao();
                return "garantiaIntExpInclCompl";
            }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.complementoInclusao  <<<<<<<<<<<");
        }
    }
    
    public void valoresDefaultInclusao() {
        
        try {

            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.actionConfirmar  <<<<<<<<<<<");
            
            tradeFinanceListaVO = lista.get(Integer.parseInt(getViewHelper().getCtcSelecionado()));
            
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA) 
            	|| tradeFinanceListaVO.getProduto().equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO)) {
            	viewHelper.setDisabledRadioCustoExterno(Boolean.TRUE);
            	tradeFinNegocVO.setCindcdcustoexter("1");
            }
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.valoresDefaultInclusao  <<<<<<<<<<<");
        }
    }

    private void limparDadosInclusao() {

        setTradeFinNegocVO(new TrdFinNegocInclVO());
        setBeneficiarioModal(new TrdFinNegMercadoriaVO());
        setAfiancadoModal(new TradeFinNegocListasVO());
        setBeneficiario(new BeneficiarioVO());
        setAfiancado(new BeneficiarioVO());
        
    }

    /**
     * Nome: complementoAlteracao
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
     * Registro  de Manutenção: 21/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String complementoAlteracao() throws ParseException {
        

        try { BradescoCommonServiceFactory.getLogManager().info(
                        ">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.complementoAlteracao  <<<<<<<<<<<");


        if (getViewHelper().getCtcSelecionado() == null
                        || getViewHelper().getCtcSelecionado() == "") {
            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
            return "";

        }else {
            
            actionConfirmar();

            getBeneficiarioModal().setIpssoacmbio(tradeFinanceBean.getBeneficiario().getCunicpssoadcmbio());
            
            if(tradeFinanceBean.getAfiancado() != null ){
                getAfiancadoModal().setNcunicpssoacmbiot(tradeFinanceBean.getAfiancado().getCunicpssoadcmbio());
                getAfiancado().setLogrdcmbio(tradeFinanceBean.getAfiancado().getLogrdcmbio());
                getAfiancado().setIciddcmbio(tradeFinanceBean.getAfiancado().getIciddcmbio());
                getAfiancado().setIpaiscmbio(tradeFinanceBean.getAfiancado().getIpaiscmbio());
            }
            
            if(tradeFinanceBean.getTradeFinanceVO().getDalertvctocntra() != null) {
                tradeFinNegocVO.setDalertvctocntra(tradeFinanceBean.getTradeFinanceVO().getDalertvctocntra());
            }
            
            tradeFinNegocVO.setCindcdcntragarnt(tradeFinanceBean.getTradeFinanceVO().getCindcdcntragarnt());
            tradeFinNegocVO.setTdiacntragarnt(tradeFinanceBean.getTradeFinanceVO().getTdiacntragarnt());
            tradeFinNegocVO.setDvctocntragarnt(tradeFinanceBean.getTradeFinanceVO().getDvctocntragarnt());
            tradeFinNegocVO.setDabertcntragarnt(tradeFinanceBean.getTradeFinanceVO().getDabertcntragarnt());
            tradeFinNegocVO.setCindcdrenovcntra(tradeFinanceBean.getTradeFinanceVO().getCindcdrenovcntra());
            tradeFinNegocVO.setQdiaalertcntra(tradeFinanceBean.getTradeFinanceVO().getQdiaalertcntra());
            tradeFinNegocVO.setCindcdcustoexter(tradeFinanceBean.getTradeFinanceVO().getCindcdcustoexter());

            getBeneficiario().setLogrdcmbio(tradeFinanceBean.getBeneficiario().getLogrdcmbio());
            getBeneficiario().setIciddcmbio(tradeFinanceBean.getBeneficiario().getIciddcmbio());
            getBeneficiario().setIpaiscmbio(tradeFinanceBean.getBeneficiario().getIpaiscmbio());

            return "garantiaIntExpAltCompl";

        }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.complementoAlteracao  <<<<<<<<<<<");
        }
    }

    /**
     * Nome: carregarDados
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
     * Registro  de Manutenção: 27/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void actionConfirmar() {
        
        try {

            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.actionConfirmar  <<<<<<<<<<<");
            
            tradeFinanceListaVO = lista.get(Integer.parseInt(getViewHelper().getCtcSelecionado()));
            tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_CONSULTAR_GARANTIA_COMPL);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.actionConfirmar  <<<<<<<<<<<");
        }

    }


    /**
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
     *      Registro de Manutenção: 08/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioCtc() {

        try {

            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.getSelectItemRadioCtc  <<<<<<<<<<<");

            List<SelectItem> list = new ArrayList<SelectItem>();
            for (int index = 0; index < getLista().size(); index++) {
                list.add(new SelectItem(index, ""));
            }

            return list;

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                            ">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.getSelectItemRadioCtc  <<<<<<<<<<<");
        }
    }

    /**
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
     *      Registro de Manutenção: 08/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginar(ActionEvent event) {

        try {

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.paginar  <<<<<<<<<<<");

            getViewHelper().setCtcSelecionado(null);

            // FLUXO: NPCCIASP BOOK: NPCCWYJE/S
            lista = tradeFinanceMonitService.obterCotacoesPendente(getFiltroVO());

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.paginar  <<<<<<<<<<<");
        }
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
     * Registro  de Manutenção: 20/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */

    public void validarForm(ActionEvent ae) {

        try {

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.validarForm  <<<<<<<<<<<");

            // valida campos obrigatórios
            if (!SiteUtil.validarCampos("formTradeFinMonitDet") 
                    && validarCampos()) {

                viewHelper.setRenderFechar(Boolean.TRUE);
            }
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.validarForm  <<<<<<<<<<<");
        }
    }

    /**
     * Nome: continuarConfirmar
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 20/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */

    public void continuarConfirmar() {

        String result = SiteUtil.STRING_EMPTY;
        getViewHelper().setRenderFechar(false);

        try {

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.continuarConfirmar <<<<<<<<<<<");

            getTradeFinNegocVO().setCunicpssoacmbioa(afiancadoModal.getCunicpssoacmbiot());
            getTradeFinNegocVO().setCunicpssoacmbiob(beneficiarioModal.getCunicpssoamcado());

            result = tradeFinanceNegociacaoService.incluirComplGarantia(getTradeFinNegocVO(), tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());

            setIniciarPagina(false);

            NpcFacesUtils.addInfoModalMessage(result, "#{garantiaExpedidaComplementoBean.retomarPesquisa}", BradescoViewExceptionActionType.ACTION, "submit", false);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.continuarConfirmar <<<<<<<<<<<");
        }

    }

    /**
     * Nome: actionConfirmarAlteracao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 22/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void actionConfirmarAlteracao() {

        String result = SiteUtil.STRING_EMPTY;
        getViewHelper().setRenderFechar(false);

        try {

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiaExpedidaComplementoBean.actionConfirmarAlteracao <<<<<<<<<<<");

            // Se iniciar o modal e efetuar a troca dos dados do Afiancado/Beneficiario
            if(!SiteUtil.isEmptyOrNull(afiancadoModal.getCunicpssoacmbiot()) && !SiteUtil.isEmptyOrNull(beneficiarioModal.getCunicpssoamcado())) {

                getTradeFinNegocVO().setCunicpssoacmbioa(afiancadoModal.getCunicpssoacmbiot());
                getTradeFinNegocVO().setCunicpssoacmbiob(beneficiarioModal.getCunicpssoamcado());

            }else {

                // Sem alteração utilizar o da consulta
                getTradeFinNegocVO().setCunicpssoacmbiob(tradeFinanceBean.getResponsavelDespList().getCunicpssoabnf());
                getTradeFinNegocVO().setCunicpssoacmbioa(tradeFinanceBean.getResponsavelDespList().getCunicpssoaafi());

            }

            result = tradeFinanceNegociacaoService.alterarComplGarantia(getTradeFinNegocVO(), tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio());

            setIniciarPagina(false);

            NpcFacesUtils.addInfoModalMessage(result, "#{garantiaExpedidaComplementoBean.retomarPesquisa}",
                            BradescoViewExceptionActionType.ACTION, "submit", false);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiaExpedidaComplementoBean.actionConfirmarAlteracao <<<<<<<<<<<");
        }

    }


    /**
     * Nome: actionFechar
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 21/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void actionFechar(ActionEvent ae) {

        try{

            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] garantiaExpedidaComplementoBean.actionFechar <<<<<<<<<<<");

            viewHelper.setRenderFechar(Boolean.FALSE);

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] garantiaExpedidaComplementoBean.actionFechar <<<<<<<<<<<");
        }
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
     * Registro  de Manutenção: 25/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String exportar() {    
        getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());

        BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista", 
                        tradeFinanceMonitService.obterCotacoesPendenteExportacao(getFiltroVO()));        

        return "garantiaExpComplExportTemplate";
    }

    /**
     * Nome: validarCampos
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
    public boolean validarCampos() {

        Boolean isValid = Boolean.TRUE;
        
        if("1".equals(getTradeFinNegocVO().getCindcdcntragarnt())) {

            if(!SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDvctocntragarnt()) 
                            && getTradeFinNegocVO().getTdiacntragarnt() != 0
                || SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getDvctocntragarnt()) 
                    && getTradeFinNegocVO().getTdiacntragarnt()  == 0) {

                NpcFacesUtils.addInfoModalMessage("É obrigatório informar a quantidade dias ou a Data contra-garantia.", false);
                isValid = Boolean.FALSE;
            }
        }
        
        if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCindcdrenovcntra())) {

            NpcFacesUtils.addInfoModalMessage("É obrigatório informar uma opção de sim ou não na Renovação Automática.", false);
            isValid = Boolean.FALSE;

        } 

        if(SiteUtil.isEmptyOrNull(getTradeFinNegocVO().getCindcdcustoexter())) {
            NpcFacesUtils.addInfoModalMessage("É obrigatório informar uma opção de sim ou não no Cotar Custo Externo.", false);
            isValid = Boolean.FALSE;

        } 
        
        if(SiteUtil.isEmptyOrNull(getBeneficiarioModal().getIpssoacmbio())) {
            NpcFacesUtils.addInfoModalMessage("É obrigatório preencher o beneficiário.", false);
            isValid = Boolean.FALSE;

        }

        return isValid;

    }

    /**
     * Nome: habilitaBotoes
     * 
     * Propósito: 
     *
     * @param : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 27/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void habilitaBotoes(AjaxBehaviorEvent ajaxBehaviorEvent) {

        tradeFinanceListaVO = lista.get(Integer.parseInt(getViewHelper().getCtcSelecionado()));

        if(tradeFinanceListaVO.getCsitbletocmbio() == 31) {
            botoesGarantiaIncl = Boolean.FALSE;

        }else if(tradeFinanceListaVO.getCsitbletocmbio() != 31) {
            botoesGarantiaIncl = Boolean.TRUE;
        }

        if(tradeFinanceListaVO.getCsitbletocmbio() == 29) {
            botoesGarantiaAlt = Boolean.FALSE;


        }else if(tradeFinanceListaVO.getCsitbletocmbio() != 29) {
            botoesGarantiaAlt = Boolean.TRUE;
        }

    }

    /** Utilização: Modal na Tela Incluir Garantias Compl
     * 
     * Nome: listenerPesquisarBeneficiarioPorNomeCons
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 20/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarBeneficiarioPorNomeCons(AjaxBehaviorEvent e) {

        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] garantiaExpedidaComplementoBean.listenerPesquisarBeneficiarioPorNome <<<<<<<<<<<");

            benefModalBean.setBeneficiario(getBeneficiarioModal());
            benefModalBean.getViewHelper().setNomeCampo("Beneficiário");
            benefModalBean.getViewHelper().setNomeStateIdListaSelBeneficiario("NPCDIAFG");
            benefModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalBeneficiario");
            benefModalBean.openModal();

        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] garantiaExpedidaComplementoBean.listenerPesquisarBeneficiarioPorNome <<<<<<<<<<<");
        }
    }

    /**
     * Nome: listenerPesquisarAfiancadoPorNome
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 15/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarAfiancadoPorNome(AjaxBehaviorEvent e) {

        try{
            getLogManager().info(">>>>>>>>>>>  [Inicio] garantiaExpedidaComplementoBean.listenerPesquisarAfiancadoPorNome <<<<<<<<<<<");

            tomadorModalBean.getViewHelper().setModalId("formTradeFinMonitDet\\:modalAfiancado");
            tomadorModalBean.setPrecificaVO(afiancadoModal);
            tomadorModalBean.getViewHelper().setNomeTomador(getAfiancadoModal().getNcunicpssoacmbiot());

            tomadorModalBean.pesquisarTomadorPorNome();
        

        }finally{
            getLogManager().info(">>>>>>>>>>>  [Fim] garantiaExpedidaComplementoBean.listenerPesquisarAfiancadoPorNome <<<<<<<<<<<");
        }
    }

    /** Utilização: Modal na Tela Incluir Garantias Compl
     * 
     * Nome: closeModalAfiancado
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 20/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void closeModalAfiancado(ActionEvent event) {
        
        if(!SiteUtil.isEmptyOrNull(afiancadoModal.getCunicpssoacmbiot())) {
            setAfiancado(getTradeFinanceNegociacaoService().obterAfiancador(afiancadoModal, 2));

        }
       
        tomadorModalBean.closeModal(event);

    }
    
    /** Utilização: Modal na Tela Incluir Garantias Compl
     * 
     * Nome: closeModalBenef
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 20/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void closeModalBenef(ActionEvent event) {
        
        if(!SiteUtil.isEmptyOrNull(beneficiarioModal.getCunicpssoamcado())){
            setBeneficiario(getTradeFinanceNegociacaoService().obterBeneficiario(beneficiarioModal, 1));

        }
       
        benefModalBean.closeModalBeneficiario(event);

    }
    
    /**
     * 
     * Nome: listenerTratarRadioGarantia
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 20/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void listenerTratarRadioGarantia(AjaxBehaviorEvent e) {
    	
    	try{
    		getLogManager().info(">>>>>>>>>>>  [Inicio] garantiaExpedidaComplementoBean.listenerTratarRadioGarantia <<<<<<<<<<<");
    		
    		if("1".equals(getTradeFinNegocVO().getCindcdcntragarnt())) {
    		    
    		    getViewHelper().setDisabledDiasContraGarantia(Boolean.FALSE);
    		    getViewHelper().setDisabledDataContraGarantia(Boolean.FALSE);
   
    		}else {
    		    getViewHelper().setDisabledDiasContraGarantia(Boolean.TRUE);
                getViewHelper().setDisabledDataContraGarantia(Boolean.TRUE);
    		}

    	}finally{
    		getLogManager().info(">>>>>>>>>>>  [Fim] garantiaExpedidaComplementoBean.listenerTratarRadioGarantia <<<<<<<<<<<");
    	}
    	
    }
    

    /**
     * @return o valor do botoesGarantiaAlt
     */
    public boolean isBotoesGarantiaAlt() {
        return botoesGarantiaAlt;
    }

    /**
     * @param botoesGarantiaAlt seta o novo valor para o campo botoesGarantiaAlt
     */
    public void setBotoesGarantiaAlt(boolean botoesGarantiaAlt) {
        this.botoesGarantiaAlt = botoesGarantiaAlt;
    }

    /**
     * @return o valor do botoesGarantiaIncl
     */
    public boolean isBotoesGarantiaIncl() {
        return botoesGarantiaIncl;
    }

    /**
     * @param botoesGarantiaIncl seta o novo valor para o campo botoesGarantiaIncl
     */
    public void setBotoesGarantiaIncl(boolean botoesGarantiaIncl) {
        this.botoesGarantiaIncl = botoesGarantiaIncl;
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
     * @return o valor do tradeFinNegocVO
     */
    public TrdFinNegocInclVO getTradeFinNegocVO() {
        return tradeFinNegocVO;
    }

    /**
     * @param tradeFinNegocVO seta o novo valor para o campo tradeFinNegocVO
     */
    public void setTradeFinNegocVO(TrdFinNegocInclVO tradeFinNegocVO) {
        this.tradeFinNegocVO = tradeFinNegocVO;
    }

    public BeneficiarioVO getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioVO beneficiario) {
        this.beneficiario = beneficiario;
    }

    public BeneficiarioVO getAfiancado() {
        return afiancado;
    }

    public void setAfiancado(BeneficiarioVO afiancado) {
        this.afiancado = afiancado;
    }

    public TrdFinNegMercadoriaVO getBeneficiarioModal() {
        return beneficiarioModal;
    }

    public void setBeneficiarioModal(TrdFinNegMercadoriaVO beneficiarioModal) {
        this.beneficiarioModal = beneficiarioModal;
    }

    public TradeFinNegocListasVO getAfiancadoModal() {
        return afiancadoModal;
    }

    public void setAfiancadoModal(TradeFinNegocListasVO afiancadoModal) {
        this.afiancadoModal = afiancadoModal;
    }
}
